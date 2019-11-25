package cn.hujw.wanandroid.model.wechat.fragment;

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
import cn.hujw.wanandroid.model.wechat.adapter.WeChatArticleAdapter;
import cn.hujw.wanandroid.model.wechat.mvp.contract.WeChatArticleContract;
import cn.hujw.wanandroid.model.wechat.mvp.modle.WeChatArticleModel;
import cn.hujw.wanandroid.model.wechat.mvp.modle.WeChatTabModel;
import cn.hujw.wanandroid.model.wechat.mvp.presenter.WeChatArticlePresenter;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/21 0021
 */
public class WeChatArticleFragment extends MvpLazyFragment implements WeChatArticleContract.View, BaseRecyclerViewAdapter.OnItemClickListener {

    private static final String TAG = "WeChatArticleFragment";

    @MvpInject
    WeChatArticlePresenter mPresenter;

    @BindView(R.id.srl_wechat_article)
    SmartRefreshLayout mSmartRefreshLayout;
    @BindView(R.id.rv_wechat_article)
    RecyclerView mRecyclerView;


    private int mCurrentPage;

    private WeChatArticleAdapter mAdapter;

    private WeChatTabModel mTabModel;
    private int position = -1;

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

        mAdapter = new WeChatArticleAdapter(getContext());
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
            mPresenter.getWeChatArticle(mTabModel.getId(), mCurrentPage);
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
        mPresenter.getWeChatArticle(mTabModel.getId(), mCurrentPage);
    }

    @Override
    public void getWeChatArticleSuccess(WeChatArticleModel data) {
        onComplete();
        mAdapter.addData(data.getDatas());

    }

    @Override
    public void getWeChatArticleError(String msg) {
        onError();
        toast(msg);
    }

    @Override
    public void onItemClick(RecyclerView recyclerView, View itemView, int position) {
        WebActivity.start(getContext(), mAdapter.getData().get(position).getLink());
    }
}
