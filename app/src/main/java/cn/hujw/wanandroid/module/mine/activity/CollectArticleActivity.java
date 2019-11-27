package cn.hujw.wanandroid.module.mine.activity;

import android.view.View;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.module.home.adapter.ArticleAdapter;
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

/**
 * @author: hujw
 * @date: 2019/11/26
 * @description: 收藏文章页面
 * @email: hujw_android@163.com
 */
public class CollectArticleActivity extends MvpActivity implements CollectArticleContract.View, CollectContract.View, ArticleAdapter.OnViewItemClickListener {

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
    private AppCompatImageView mCollectView;
    private int position;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_collect_article;
    }

    @Override
    protected void initView() {
        mAdapter = new CollectArticleAdapter(getContext());
        mAdapter.setOnItemClickListener((recyclerView, itemView, position) -> WebActivity.start(getContext(), mAdapter.getData().get(position).getLink()));
        mAdapter.setmOnViewItemClickListener(this);
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
        if (data.getTotal()==0){
            onEmpty();
        }else{
            mAdapter.addData(data.getDatas());
        }
    }

    @Override
    public void getCollectArticleError(String msg) {
        onError();
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
        mCollectView.setImageResource(R.drawable.ico_collect_normal);
        mAdapter.removeItem(position);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void getUnCollectError(String msg) {

    }

    /**
     * 取消收藏
     */
    @Override
    public void onItemClick(View view, int position) {
        this.position = position;
        mCollectView = view.findViewById(R.id.item_iv_collect);
        collectPresenter.getUnCollect(mAdapter.getData().get(position).getOriginId());
    }
}
