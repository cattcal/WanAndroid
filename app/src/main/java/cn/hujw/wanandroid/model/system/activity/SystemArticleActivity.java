package cn.hujw.wanandroid.model.system.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import cn.hujw.base.BaseRecyclerViewAdapter;
import cn.hujw.titlebar.library.TitleBar;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.mvp.MvpActivity;
import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.other.IntentKey;
import cn.hujw.wanandroid.ui.activity.WebActivity;
import cn.hujw.wanandroid.model.system.adapter.SystemArticleAdapter;
import cn.hujw.wanandroid.model.system.mvp.contract.SystemArticleContract;
import cn.hujw.wanandroid.model.system.mvp.modle.SystemArticleModel;
import cn.hujw.wanandroid.model.system.mvp.presenter.SystemArticlePresenter;

/**
 * 描述： 知识体系下的文章
 *
 * @author hujw
 * @date 2019/11/21 0021
 */
public final class SystemArticleActivity extends MvpActivity implements SystemArticleContract.View, BaseRecyclerViewAdapter.OnItemClickListener {

    @MvpInject
    SystemArticlePresenter mPresenter;

    private static final String TAG = "SystemArticleActivity";

    @BindView(R.id.tb_system_article)
    TitleBar mTitleBar;
    @BindView(R.id.srl_system_article)
    SmartRefreshLayout mSmartRefreshLayout;
    @BindView(R.id.rv_system_article)
    RecyclerView mRecyclerView;

    private SystemArticleAdapter mAdapter;

    private int mCurrentPage;

    //cid
    private String cid;
    private String title;

    public static void start(Context context, String id, String title) {
        if (id == null || "".equals(id)) {
            return;
        }
        Intent intent = new Intent(context, SystemArticleActivity.class);
        intent.putExtra(IntentKey.ID, id);
        intent.putExtra("title", title);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_system_article;
    }

    @Override
    protected void initView() {
        cid = getIntent().getStringExtra(IntentKey.ID);
        title = getIntent().getStringExtra("title");

        mTitleBar.setTitle(title);

        mAdapter = new SystemArticleAdapter(getContext());
        mAdapter.setOnItemClickListener(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);

        setRefresh();
    }

    private void setRefresh() {
        mSmartRefreshLayout.setOnRefreshListener(refreshLayout -> {
            loadData();
            mSmartRefreshLayout.finishRefresh(true);
        });

        mSmartRefreshLayout.setOnLoadMoreListener(refreshLayout -> {
            mCurrentPage++;
            mPresenter.getSystemArticle(mCurrentPage, cid);
            mSmartRefreshLayout.finishLoadMore(true);

        });
    }

    @Override
    protected void initData() {
        onLoading();
        loadData();
    }


    /**
     * 请求第一页的数据
     */
    private void loadData() {
        mAdapter.clearData();
        mCurrentPage = 0;
        mPresenter.getSystemArticle(mCurrentPage, cid);
    }

    @Override
    public void getArticleSuccess(SystemArticleModel data) {
        onComplete();
        mAdapter.addData(data.getDatas());
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void getArticleError(String msg) {
        onError();
    }

    @Override
    public void onItemClick(RecyclerView recyclerView, View itemView, int position) {
        WebActivity.start(getContext(), mAdapter.getData().get(position).getLink());
    }
}
