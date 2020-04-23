package cn.hujw.wanandroid.module.mine.activity;

import android.view.View;

import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.common.Config;
import cn.hujw.wanandroid.eventbus.RefreshBus;
import cn.hujw.wanandroid.module.mine.adapter.CollectArticleAdapter;
import cn.hujw.wanandroid.module.mine.mvp.contract.CollectArticleContract;
import cn.hujw.wanandroid.module.mine.mvp.modle.CollectArticleModel;
import cn.hujw.wanandroid.module.mine.mvp.presenter.CollectArticlePresenter;
import cn.hujw.wanandroid.mvp.MvpActivity;
import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.ui.activity.WebActivity;
import cn.hujw.wanandroid.ui.mvp.contract.CollectContract;
import cn.hujw.wanandroid.ui.mvp.model.CollectModel;
import cn.hujw.wanandroid.ui.mvp.model.UnCollectModel;
import cn.hujw.wanandroid.ui.mvp.presenter.CollectPresenter;
import cn.hujw.wanandroid.utils.SmartRefreshUtils;

import static cn.hujw.wanandroid.common.Config.PAGE_START;

/**
 * @author: hujw
 * @date: 2019/11/26
 * @description: 收藏文章页面
 * @email: hujw_android@163.com
 */
public class CollectArticleActivity extends MvpActivity implements CollectArticleContract.View, CollectContract.View {

    @MvpInject
    CollectArticlePresenter mPresenter;

    @MvpInject
    CollectPresenter collectPresenter;

    @BindView(R.id.srl_collect_article)
    SmartRefreshLayout mSmartRefreshLayout;
    @BindView(R.id.rv_collect_article)
    RecyclerView mRecyclerView;

    private CollectArticleAdapter mAdapter;

    private int mCurrentPage;

    private List<CollectArticleModel.DatasBean> mData;

    private SmartRefreshUtils mSmartRefreshUtils;
    private int mPosition;
    private AppCompatImageView mCollectView;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_collect_article;
    }

    @Override
    protected void initView() {
        //设置下拉刷新和上拉加载
        setSmartRefresh();

        //初始化适配器
        initAdapter();


    }

    /**
     * 初始化适配器
     */
    private void initAdapter() {
        mAdapter = new CollectArticleAdapter(mData);

        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                WebActivity.start(getContext(), mAdapter.getData().get(position).getLink());
            }
        });

        mRecyclerView.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                mPosition = position;
                mCollectView = view.findViewById(R.id.item_cb_collect);

                collectPresenter.getUnCollect(mAdapter.getData().get(position).getOriginId());


            }
        });

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
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
        mSmartRefreshUtils.setLoadMoreListener(() -> mPresenter.getCollectArticle(mCurrentPage));
    }

    @Override
    protected void initData() {
        loadData();
    }

    private void loadData() {
        mAdapter.getData().clear();
        mCurrentPage = PAGE_START;
        mPresenter.getCollectArticle(mCurrentPage);
    }

    @Override
    public void getCollectArticleSuccess(CollectArticleModel data) {

        mCurrentPage = data.getCurPage() + PAGE_START;

        this.mData = data.getDatas();
        if (data.getTotal() == 0) {
            onEmpty();
        } else {
            if (data.getCurPage() == 1) {
                mAdapter.setNewData(mData);
            } else {
                mAdapter.addData(mData);
            }
        }

        mSmartRefreshUtils.success();
    }

    @Override
    public void getCollectArticleError(String msg) {
        onError();
        mSmartRefreshUtils.fail();
    }

    @Override
    public void getCollectSuccess(CollectModel data) {

    }

    @Override
    public void getCollectError(String msg) {

    }

    @Override
    public void getUnCollectSuccess(UnCollectModel data) {
        toast("取消收藏");
        mAdapter.remove(mPosition);

        if (mAdapter.getData().size()==0){
            onEmpty();
        }
    }

    @Override
    public void getUnCollectError(String msg) {

    }


}
