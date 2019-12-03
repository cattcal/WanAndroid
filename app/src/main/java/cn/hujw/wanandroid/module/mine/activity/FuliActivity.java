package cn.hujw.wanandroid.module.mine.activity;

import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.common.Config;
import cn.hujw.wanandroid.mvp.MvpActivity;
import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.ui.activity.ImageActivity;
import cn.hujw.wanandroid.ui.adapter.FuliAdapter;
import cn.hujw.wanandroid.ui.mvp.contract.FuliContract;
import cn.hujw.wanandroid.ui.mvp.model.FuliModel;
import cn.hujw.wanandroid.ui.mvp.presenter.FuliPresenter;
import cn.hujw.wanandroid.utils.SmartRefreshUtils;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/12/3 0003
 */
public class FuliActivity extends MvpActivity implements FuliContract.View {

    @MvpInject
    FuliPresenter mPresenter;

    @BindView(R.id.rv_fuli)
    RecyclerView mRecyclerView;

    private FuliAdapter mAdapter;
    private List<FuliModel.ResultsBean> mData = new ArrayList<>();

    @BindView(R.id.srl_fuli)
    SmartRefreshLayout mSmartRefreshLayout;

    private SmartRefreshUtils mSmartRefreshUtils;

    private int mCurrentPage;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fuli;
    }

    @Override
    protected void initView() {

        setSmartRefresh();

        initAdapter();
    }

    private void initAdapter() {
        mAdapter = new FuliAdapter(mData);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ImageActivity.start(getContext(), mAdapter.getData().get(position).getUrl());
            }
        });

        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        onLoading();
        loadData();
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
            mPresenter.getFuli( mCurrentPage);
        });
    }

    private void loadData() {
        mCurrentPage = 1;
        mPresenter.getFuli(mCurrentPage);

    }

    @Override
    public void getFuliSuccess(String data) {
        onComplete();
        Gson gson = new Gson();
        FuliModel fuliModel = gson.fromJson(data, FuliModel.class);
        mData.addAll(fuliModel.getResults());
        mAdapter.setNewData(mData);

        mSmartRefreshUtils.success();
    }

    @Override
    public void getFulictError(String msg) {
        onError();
        toast(msg);
        mSmartRefreshUtils.fail();
    }
}
