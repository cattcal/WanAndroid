package cn.hujw.wanandroid.module.wechat.fragment;

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
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import cn.hujw.base.BaseRecyclerViewAdapter;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.common.MyApplication;
import cn.hujw.wanandroid.eventbus.RefreshBus;
import cn.hujw.wanandroid.module.login.activity.LoginActivity;
import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.mvp.MvpLazyFragment;
import cn.hujw.wanandroid.ui.activity.WebActivity;
import cn.hujw.wanandroid.module.wechat.adapter.WeChatArticleAdapter;
import cn.hujw.wanandroid.module.wechat.mvp.contract.WeChatArticleContract;
import cn.hujw.wanandroid.module.wechat.mvp.modle.WeChatArticleModel;
import cn.hujw.wanandroid.module.wechat.mvp.modle.WeChatTabModel;
import cn.hujw.wanandroid.module.wechat.mvp.presenter.WeChatArticlePresenter;
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
public class WeChatArticleFragment extends MvpLazyFragment implements WeChatArticleContract.View,
        BaseRecyclerViewAdapter.OnItemClickListener, CollectContract.View {

    private static final String TAG = "WeChatArticleFragment";

    @MvpInject
    WeChatArticlePresenter mPresenter;

    @MvpInject
    CollectPresenter collectPresenter;

    @BindView(R.id.srl_wechat_article)
    SmartRefreshLayout mSmartRefreshLayout;
    @BindView(R.id.rv_wechat_article)
    RecyclerView mRecyclerView;


    private int mCurrentPage = 1;

    private WeChatArticleAdapter mAdapter;

    private WeChatTabModel mTabModel;
    private int position = -1;
    private List<WeChatArticleModel.DatasBean> mData;

    private SmartRefreshUtils mSmartRefreshUtils;
    private AppCompatImageView mCollectView;
    private int mPosition;
    private SPCookieStore mCookieStore;


    public static WeChatArticleFragment newInstance(WeChatTabModel model, int position) {
        WeChatArticleFragment fragment = new WeChatArticleFragment();
        Bundle args = new Bundle(2);
        args.putSerializable("weChatTabModel", model);
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
            mTabModel = (WeChatTabModel) args.getSerializable("weChatTabModel");
            position = args.getInt("position", -1);
        }

        setSmartRefresh();

        initAdapter();


    }

    private void initAdapter() {
        mAdapter = new WeChatArticleAdapter(mData);
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

                mCookieStore = new SPCookieStore(MyApplication.getContext());

                if (mCookieStore.getAllCookie().size() == 0) {
                    mCollectView.setBackgroundResource(R.drawable.ico_collect_normal);
                    startActivity(LoginActivity.class);
                }else{
                    if (mAdapter.getData().get(position).isCollect() != true) {
                        collectPresenter.getCollect(id);
                    } else {
                        collectPresenter.getUnCollect(id);
                    }
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
            mPresenter.getWeChatArticle(mTabModel.getId(), mCurrentPage);
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
        mPresenter.getWeChatArticle(mTabModel.getId(), mCurrentPage);
    }

    @Override
    public void getWeChatArticleSuccess(WeChatArticleModel data) {

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
    public void getWeChatArticleError(String msg) {
        onError();
        toast(msg);
        mSmartRefreshUtils.fail();
    }

    @Override
    public void onItemClick(RecyclerView recyclerView, View itemView, int position) {
        WebActivity.start(getContext(), mAdapter.getData().get(position).getLink());
    }

    @Override
    public void getCollectSuccess(CollectModel data) {
        toast("收藏成功");

        if (mAdapter.getData().get(mPosition).isCollect()==false){
            mCollectView.setBackgroundResource(R.drawable.ico_collect);
            mAdapter.getData().get(mPosition).setCollect(true);
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

        if (mAdapter.getData().get(mPosition).isCollect()==true){
            mCollectView.setBackgroundResource(R.drawable.ico_collect_normal);
            mAdapter.getData().get(mPosition).setCollect(false);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void getUnCollectError(String msg) {
        toast(msg);
    }


}
