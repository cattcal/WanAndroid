package cn.hujw.wanandroid.model.mine.activity;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;
import cn.hujw.base.BaseRecyclerViewAdapter;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.model.mine.adapter.CollectArticleAdapter;
import cn.hujw.wanandroid.model.mine.mvp.contract.CollectArticleContract;
import cn.hujw.wanandroid.model.mine.mvp.modle.CollectArticleModel;
import cn.hujw.wanandroid.model.mine.mvp.presenter.CollectArticlePresenter;
import cn.hujw.wanandroid.mvp.MvpActivity;
import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.ui.activity.WebActivity;

/**
 * @author: hujw
 * @date: 2019/11/26
 * @description:
 * @email: hujw_android@163.com
 */
public class CollectArticleActivity extends MvpActivity implements CollectArticleContract.View {

    @MvpInject
    CollectArticlePresenter mPresenter;

    @BindView(R.id.srl_collect_article)
    SmartRefreshLayout mSmartRefreshLayout;
    @BindView(R.id.rv_collect_article)
    RecyclerView mRecyclerView;

    private CollectArticleAdapter mAdapter;

    private int mCurrentPage;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_collect_article;
    }

    @Override
    protected void initView() {
        mAdapter = new CollectArticleAdapter(getContext());
        mAdapter.setOnItemClickListener((recyclerView, itemView, position) -> WebActivity.start(getContext(), mAdapter.getData().get(position).getLink()));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);

        mSmartRefreshLayout.setOnRefreshListener(refreshLayout -> {
            loadData();
            refreshLayout.finishRefresh();
        });

        mSmartRefreshLayout.setOnLoadMoreListener(refreshLayout -> {
            mCurrentPage++;
            mPresenter.getCollectArticle(mCurrentPage);
            refreshLayout.finishLoadMore();
        });
    }

    @Override
    protected void initData() {
        loadData();
    }

    private void loadData() {
        mAdapter.clearData();
        mCurrentPage = 0;
        mPresenter.getCollectArticle(mCurrentPage);
    }

    @Override
    public void getCollectArticleSuccess(CollectArticleModel data) {
        mAdapter.addData(data.getDatas());
    }

    @Override
    public void getCollectArticleError(String msg) {

    }
}
