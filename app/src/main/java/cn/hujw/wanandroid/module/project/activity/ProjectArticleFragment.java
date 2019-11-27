package cn.hujw.wanandroid.module.project.activity;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

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

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/21 0021
 */
public class ProjectArticleFragment extends MvpLazyFragment implements ProjectArticleContract.View, BaseRecyclerViewAdapter.OnItemClickListener {

    private static final String TAG = "WeChatArticleFragment";

    @MvpInject
    ProjectArticlePresenter mPresenter;

    @BindView(R.id.srl_wechat_article)
    SmartRefreshLayout mSmartRefreshLayout;
    @BindView(R.id.rv_wechat_article)
    RecyclerView mRecyclerView;


    private int mCurrentPage;

    private ProjectArticleAdapter mAdapter;

    private ProjectTabModel mTabModel;
    private int position = -1;

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

        mAdapter = new ProjectArticleAdapter(getContext());
        mAdapter.setOnItemClickListener(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);

        setRefresh();

    }

    /**
     * 刷新加载
     */
    private void setRefresh() {
        mSmartRefreshLayout.setOnRefreshListener(refreshLayout -> {
            loadData();
            refreshLayout.finishRefresh(true);
        });

        mSmartRefreshLayout.setOnLoadMoreListener(refreshLayout -> {
            mCurrentPage++;
            mPresenter.getProjectArticle(mCurrentPage, mTabModel.getId() + "");
            refreshLayout.finishLoadMore(true);
        });
    }

    @Override
    protected void initData() {
        onLoading();
        loadData();
    }

    /**
     * 加载第一页数据
     */
    private void loadData() {
        mAdapter.clearData();
        mCurrentPage = 0;
        mPresenter.getProjectArticle(mCurrentPage, mTabModel.getId() + "");
    }


    @Override
    public void onItemClick(RecyclerView recyclerView, View itemView, int position) {
        WebActivity.start(getContext(), mAdapter.getData().get(position).getLink());
    }

    @Override
    public void getProjectArticleSuccess(ProjectArticleModel data) {
        onComplete();
        mAdapter.addData(data.getDatas());
    }

    @Override
    public void getProjectArticleError(String msg) {
        onError();
        toast(msg);
    }
}
