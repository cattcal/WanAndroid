package cn.hujw.wanandroid.module.project.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import butterknife.BindView;
import cn.hujw.base.BaseRecyclerViewAdapter;
import cn.hujw.wanandroid.R;
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

import static cn.hujw.wanandroid.common.Config.PAGE_START;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/21 0021
 */
public class ProjectArticleFragment extends MvpLazyFragment implements ProjectArticleContract.View, CollectContract.View {

    private static final String TAG = "WeChatArticleFragment";

    @MvpInject
    ProjectArticlePresenter mPresenter;

    @MvpInject
    CollectPresenter collectPresenter;

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
        mAdapter = new ProjectArticleAdapter( mData);
        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                WebActivity.start(getContext(), mAdapter.getData().get(position).getLink());
            }
        });

        mRecyclerView.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                AppCompatCheckBox mCollectView = view.findViewById(R.id.item_cb_collect);
                int id = mAdapter.getData().get(position).getId();

                if (!mCollectView.isChecked()) {
                    collectPresenter.getCollect(id);
                } else {
                    collectPresenter.getUnCollect(id);
                }
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
        mSmartRefreshUtils.setRefreshListener(() -> loadData());

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
    }

    @Override
    public void getCollectError(String msg) {
        toast(msg);
    }

    @Override
    public void getUnCollectSuccess(UnCollectModel data) {
        toast("取消收藏");
    }

    @Override
    public void getUnCollectError(String msg) {
        toast(msg);
    }
}
