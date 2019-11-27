package cn.hujw.wanandroid.module.home.activity;

import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.mvp.MvpActivity;
import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.ui.activity.WebActivity;
import cn.hujw.wanandroid.module.home.adapter.HotAdapter;
import cn.hujw.wanandroid.module.home.adapter.SearchArticleAdapter;
import cn.hujw.wanandroid.module.home.mvp.contract.SearchContract;
import cn.hujw.wanandroid.module.home.mvp.modle.HotModel;
import cn.hujw.wanandroid.module.home.mvp.modle.SearchArticleModel;
import cn.hujw.wanandroid.module.home.mvp.presenter.SearchPresenter;

/**
 * @author: hujw
 * @date: 2019/11/24
 * @description:
 * @email: hujw_android@163.com
 */
public class SearchActivity extends MvpActivity implements SearchContract.View {

    @MvpInject
    SearchPresenter mPresenter;

    @BindView(R.id.et_home_search)
    AppCompatEditText mSearchView;

    @BindView(R.id.rv_search_hot)
    RecyclerView mHotRecyclerView;
    @BindView(R.id.rv_search_article)
    RecyclerView mSearchArticleRecyclerView;

    @BindView(R.id.ll_search_hot)
    LinearLayout mHotLayout;
    @BindView(R.id.srl_search)
    SmartRefreshLayout mSmartRefreshLayout;

    private HotAdapter mHotAdapter;
    private SearchArticleAdapter mAdapter;

    private int mCurrentPage;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {

        mHotAdapter = new HotAdapter(getContext());
        mHotAdapter.setOnItemClickListener((recyclerView, itemView, position) -> {
            onComplete();

            mSearchView.setText(mHotAdapter.getData().get(position).getName() + "");
            loadData();

        });
        FlexboxLayoutManager manager = new FlexboxLayoutManager(getContext(), FlexDirection.ROW, FlexWrap.WRAP);
        mHotRecyclerView.setLayoutManager(manager);
        mHotRecyclerView.setAdapter(mHotAdapter);

        mAdapter = new SearchArticleAdapter(getContext());
        mAdapter.setOnItemClickListener((recyclerView, itemView, position) -> WebActivity.start(getContext(), mAdapter.getData().get(position).getLink()));
        mSearchArticleRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mSearchArticleRecyclerView.setAdapter(mAdapter);


        mSmartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                loadData();
                refreshLayout.finishRefresh(true);


            }
        });

        mSmartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mCurrentPage++;
                mPresenter.getSearchArticle(mCurrentPage, mSearchView.getText() + "");
                refreshLayout.finishLoadMore(true);
            }
        });

    }

    private void loadData() {
        mAdapter.clearData();
        mCurrentPage = 0;
        mPresenter.getSearchArticle(mCurrentPage, mSearchView.getText() + "");
    }

    @Override
    protected void initData() {
        mPresenter.getHot();
    }

    @Override
    public void getHotSuccess(List<HotModel> data) {

        mHotAdapter.setData(data);
    }

    @Override
    public void getHotError(String msg) {
        onError();
        toast(msg);
    }

    @Override
    public void getSearchArticleSuccess(SearchArticleModel data) {
        if (data.getTotal() == 0) {
            onEmpty();
        } else {
            if (data.getDatas() != null || data.getDatas().size() > 0) {
                onComplete();
                mHotLayout.setVisibility(View.GONE);
                mSmartRefreshLayout.setVisibility(View.VISIBLE);
                mAdapter.addData(data.getDatas());
            }
        }
    }

    @Override
    public void getSearchArticleError(String msg) {
        toast(msg);
    }


    @OnClick(R.id.tv_home_search)
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_home_search:
                loadData();
                break;
        }
    }
}
