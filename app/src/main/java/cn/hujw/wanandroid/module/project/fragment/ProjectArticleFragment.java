package cn.hujw.wanandroid.module.project.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.allen.library.cookie.store.SPCookieStore;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import butterknife.BindView;
import cn.hujw.base.BaseRecyclerViewAdapter;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.common.MyApplication;
import cn.hujw.wanandroid.module.home.mvp.contract.ShareArticleContract;
import cn.hujw.wanandroid.module.home.mvp.modle.ArticleModel;
import cn.hujw.wanandroid.module.home.mvp.modle.ShareArticleModel;
import cn.hujw.wanandroid.module.home.mvp.presenter.ShareArticlePresenter;
import cn.hujw.wanandroid.module.login.activity.LoginActivity;
import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.mvp.MvpLazyFragment;
import cn.hujw.wanandroid.ui.activity.WebActivity;
import cn.hujw.wanandroid.module.project.adapter.ProjectArticleAdapter;
import cn.hujw.wanandroid.module.project.mvp.contract.ProjectArticleContract;
import cn.hujw.wanandroid.module.project.mvp.modle.ProjectArticleModel;
import cn.hujw.wanandroid.module.project.mvp.modle.ProjectTabModel;
import cn.hujw.wanandroid.module.project.mvp.presenter.ProjectArticlePresenter;
import cn.hujw.wanandroid.ui.mvp.contract.CollectContract;
import cn.hujw.wanandroid.ui.mvp.model.CollectModel;
import cn.hujw.wanandroid.ui.mvp.model.UnCollectModel;
import cn.hujw.wanandroid.ui.mvp.presenter.CollectPresenter;
import cn.hujw.wanandroid.utils.SmartRefreshUtils;
import cn.hujw.wanandroid.utils.UserManager;

import static cn.hujw.wanandroid.common.Config.PAGE_START;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/21 0021
 */
public class ProjectArticleFragment extends MvpLazyFragment implements ProjectArticleContract.View,
        CollectContract.View, ShareArticleContract.View {

    private static final String TAG = "WeChatArticleFragment";

    @MvpInject
    ProjectArticlePresenter mPresenter;

    @MvpInject
    CollectPresenter collectPresenter;

    @MvpInject
    ShareArticlePresenter shareArticlePresenter;

    @BindView(R.id.srl_wechat_article)
    SmartRefreshLayout mSmartRefreshLayout;
    @BindView(R.id.rv_wechat_article)
    RecyclerView mRecyclerView;

    private SmartRefreshUtils mSmartRefreshUtils;


    private int mCurrentPage = 1;

    private ProjectArticleAdapter mAdapter;

    private ProjectTabModel mTabModel;
    private int position = -1;
    private List<ProjectArticleModel.DatasBean> mData;
    private AppCompatImageView mCollectView;
    private int mPosition;

    public static ProjectArticleFragment newInstance(ProjectTabModel model, int position) {
        ProjectArticleFragment fragment = new ProjectArticleFragment();
        Bundle args = new Bundle(2);
        args.putSerializable("projectTabModel", model);
        args.putInt("position", position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wechat_article;
    }

    @Override
    protected void initView() {
        Bundle args = getArguments();
        if (args != null) {
            mTabModel = (ProjectTabModel) args.getSerializable("projectTabModel");
            position = args.getInt("position", -1);
        }


        setSmartRefresh();

        initAdapter();

    }


    private void initAdapter() {
        mAdapter = new ProjectArticleAdapter(mData);
        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                WebActivity.start(getContext(), mAdapter.getData().get(position).getLink());
            }
        });

        mRecyclerView.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                mCollectView = view.findViewById(R.id.item_cb_collect);
                mPosition = position;
                int id = mAdapter.getData().get(position).getId();


                if (UserManager.getInstance().isLogin()) {
                    if (mAdapter.getData().get(position).isCollect() != true) {
                        collectPresenter.getCollect(id);
                    } else {
                        collectPresenter.getUnCollect(id);
                    }
                } else {
                    mCollectView.setBackgroundResource(R.drawable.ico_collect_normal);
                    startActivity(LoginActivity.class);
                }
            }
        });

        mRecyclerView.addOnItemTouchListener(new OnItemLongClickListener() {
            @Override
            public void onSimpleItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                ProjectArticleModel.DatasBean datasBean = mAdapter.getData().get(position);
                shareArticlePresenter.shareArticle(datasBean.getTitle(), datasBean.getLink());
            }
        });


        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);
    }

    /**
     * 下拉刷新和上拉记载
     */
    private void setSmartRefresh() {
        //初始化
        mSmartRefreshUtils = SmartRefreshUtils.getInstance(mSmartRefreshLayout);

        //下拉刷新
        mSmartRefreshUtils.setRefreshListener(() -> {
            if (mAdapter.getData().size() != 0) {
                mAdapter.getData().clear();
                mAdapter.notifyDataSetChanged();

                loadData();

            }
        });

        //上拉加载
        mSmartRefreshUtils.setLoadMoreListener(() -> {
            mCurrentPage++;
            mPresenter.getProjectArticle(mCurrentPage, mTabModel.getId() + "");
        });
    }

    @Override
    protected void initData() {
        loadData();
    }

    /**
     * 加载第一页数据
     */
    private void loadData() {
        mCurrentPage = 1;
        mPresenter.getProjectArticle(mCurrentPage, mTabModel.getId() + "");
    }


    @Override
    public void getProjectArticleSuccess(ProjectArticleModel data) {
        log("page:" + mCurrentPage);

        this.mData = data.getDatas();
        if (data.getTotal() != 0) {
            onComplete();
            if (data.getCurPage() == 1) {
                mAdapter.setNewData(mData);
            } else {
                mAdapter.addData(mData);
            }
        } else {
            onEmpty();
        }

        mSmartRefreshUtils.success();
    }

    @Override
    public void getProjectArticleError(String msg) {
        onError();
        toast(msg);
        mSmartRefreshUtils.fail();
    }

    @Override
    public void getCollectSuccess(CollectModel data) {
        toast("收藏成功");
        if (mAdapter.getData().get(mPosition).isCollect() == false) {
            mAdapter.getData().get(mPosition).setCollect(true);
            mCollectView.setBackgroundResource(R.drawable.ico_collect);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void getCollectError(String msg) {
        toast(msg);
    }

    @Override
    public void getUnCollectSuccess(UnCollectModel data) {
        toast("取消收藏");
        if (mAdapter.getData().get(mPosition).isCollect() == true) {
            mAdapter.getData().get(mPosition).setCollect(false);
            mCollectView.setBackgroundResource(R.drawable.ico_collect_normal);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void getUnCollectError(String msg) {
        toast(msg);
    }

    @Override
    public void getShareArticleSuccess(ShareArticleModel data) {
        toast("分享成功到广场");
    }

    @Override
    public void getShareArticleError(String msg) {
        toast(msg);
    }
}
