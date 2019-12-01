package cn.hujw.wanandroid.module.mine.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.module.mine.adapter.MineShareAdapter;
import cn.hujw.wanandroid.module.mine.mvp.contract.MineShareContract;
import cn.hujw.wanandroid.module.mine.mvp.modle.MineShareModel;
import cn.hujw.wanandroid.module.mine.mvp.presenter.MineSharePresenter;
import cn.hujw.wanandroid.mvp.MvpActivity;
import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.ui.activity.WebActivity;

/**
 * 描述：分享文章列表
 *
 * @author hujw
 * @date 2019/11/27 0027
 */
public class MineShareActivity extends MvpActivity implements MineShareContract.View {

    @MvpInject
    MineSharePresenter mPresenter;

    @BindView(R.id.rv_mine_share)
    RecyclerView mRecyclerView;
    @BindView(R.id.srl_mine_share)
    SmartRefreshLayout mSmartRefreshLayout;


    private MineShareAdapter mAdapter;

    private int mCurrentPage;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_mine_share;
    }

    @Override
    protected void initView() {
        mAdapter = new MineShareAdapter(getContext());
        mAdapter.setOnItemClickListener((recyclerView, itemView, position) -> WebActivity.start(getContext(), mAdapter.getData().get(position).getLink()));

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);

        mSmartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                initData();
                refreshLayout.finishRefresh();
            }
        });

        mSmartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mCurrentPage++;
                mPresenter.getMineShare(mCurrentPage);
                refreshLayout.finishLoadMore();
            }
        });
    }

    @Override
    protected void initData() {
        mAdapter.clearData();
        mCurrentPage = 1;
        mPresenter.getMineShare(mCurrentPage);
    }

    @Override
    public void getMineShareSuccess(MineShareModel data) {
        if (data.getShareArticles().getTotal()==0){
            onEmpty();
        }else{
            mAdapter.addData(data.getShareArticles().getDatas());
        }
    }

    @Override
    public void getMineShareError(String msg) {
        onError();
    }

}
