package cn.hujw.wanandroid.module.home.activity;

import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.module.home.adapter.SearchHistoryAdapter;
import cn.hujw.wanandroid.module.home.mvp.contract.ShareArticleContract;
import cn.hujw.wanandroid.module.home.mvp.modle.ArticleModel;
import cn.hujw.wanandroid.module.home.mvp.modle.ShareArticleModel;
import cn.hujw.wanandroid.module.home.mvp.presenter.ShareArticlePresenter;
import cn.hujw.wanandroid.module.login.activity.LoginActivity;
import cn.hujw.wanandroid.mvp.MvpActivity;
import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.ui.activity.WebActivity;
import cn.hujw.wanandroid.module.home.adapter.HotAdapter;
import cn.hujw.wanandroid.module.home.adapter.SearchArticleAdapter;
import cn.hujw.wanandroid.module.home.mvp.contract.SearchContract;
import cn.hujw.wanandroid.module.home.mvp.modle.HotModel;
import cn.hujw.wanandroid.module.home.mvp.modle.SearchArticleModel;
import cn.hujw.wanandroid.module.home.mvp.presenter.SearchPresenter;
import cn.hujw.wanandroid.ui.mvp.contract.CollectContract;
import cn.hujw.wanandroid.ui.mvp.model.CollectModel;
import cn.hujw.wanandroid.ui.mvp.model.UnCollectModel;
import cn.hujw.wanandroid.ui.mvp.presenter.CollectPresenter;
import cn.hujw.wanandroid.utils.SPHistoryUtils;
import cn.hujw.wanandroid.utils.SPUtils;
import cn.hujw.wanandroid.utils.SmartRefreshUtils;
import cn.hujw.wanandroid.utils.UserManager;

import static cn.hujw.wanandroid.common.Config.PAGE_START;

/**
 * @author: hujw
 * @date: 2019/11/24
 * @description:
 * @email: hujw_android@163.com
 */
public class SearchActivity extends MvpActivity implements SearchContract.View, CollectContract.View, ShareArticleContract.View {

    @MvpInject
    SearchPresenter mPresenter;
    @MvpInject
    CollectPresenter collectPresenter;

    @MvpInject
    ShareArticlePresenter shareArticlePresenter;

    @BindView(R.id.et_home_search)
    AppCompatEditText mSearchView;


    @BindView(R.id.rv_search_article)
    RecyclerView mSearchArticleRecyclerView;

    @BindView(R.id.rv_search_hot)
    RecyclerView mHotRecyclerView;
    @BindView(R.id.ll_search_hot)
    LinearLayout mHotLayout;

    @BindView(R.id.rv_search_history)
    RecyclerView mHistoryRecyclerView;
    @BindView(R.id.ll_search_history)
    LinearLayout mHistoryLayout;
    @BindView(R.id.tv_clear_history)
    AppCompatTextView mClearHistory;

    @BindView(R.id.srl_search)
    SmartRefreshLayout mSmartRefreshLayout;

    private SmartRefreshUtils mSmartRefreshUtils;


    private HotAdapter mHotAdapter;
    private SearchArticleAdapter mAdapter;
    private SearchHistoryAdapter mHistoryAdapter;

    private int mCurrentPage;
    private List<HotModel> mHotData;
    private List<SearchArticleModel.DatasBean> mData;
    private SPUtils instance;
    private String inputText;

    private AppCompatImageView mCollectView;
    private int mId;
    private int mPosition;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {

        mHistoryLayout.setVisibility(View.GONE);

        setSmartRefresh();

        initAdapter();

        //显示历史记录
        showHistory();


    }

    private void showHistory() {
        List<String> historyList = SPHistoryUtils.getSearchHistory();

        if (historyList.size() > 0) {
            mHistoryLayout.setVisibility(View.VISIBLE);
            mHistoryAdapter = new SearchHistoryAdapter(historyList);
            FlexboxLayoutManager manager = new FlexboxLayoutManager(getContext(), FlexDirection.ROW, FlexWrap.WRAP);

            mHistoryRecyclerView.setLayoutManager(manager);
            mHistoryRecyclerView.setAdapter(mHistoryAdapter);

            mHistoryAdapter.setOnItemClickListener((recyclerView, itemView, position) -> {
                mSearchView.setText(mHistoryAdapter.getData().get(position));
                loadData();
            });
        } else {
            mHistoryLayout.setVisibility(View.GONE);
        }
        mClearHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SPUtils.getInstance().clear();
                mHistoryLayout.setVisibility(View.GONE);
            }
        });
    }

    private void initAdapter() {
        mHotAdapter = new HotAdapter(mHotData);
        mHotAdapter.setOnItemClickListener((recyclerView, itemView, position) -> {
            onComplete();

            mSearchView.setText(mHotAdapter.getData().get(position).getName() + "");
            SPHistoryUtils.saveSearchHistory(mSearchView.getText().toString());

            loadData();

        });

        FlexboxLayoutManager manager = new FlexboxLayoutManager(getContext(), FlexDirection.ROW, FlexWrap.WRAP);
        mHotRecyclerView.setLayoutManager(manager);
        mHotRecyclerView.setAdapter(mHotAdapter);

        mAdapter = new SearchArticleAdapter(mData);
        mSearchArticleRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {

                WebActivity.start(getContext(), mAdapter.getData().get(position).getLink());
            }
        });

        mSearchArticleRecyclerView.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                mCollectView = view.findViewById(R.id.item_cb_collect);

                mPosition = position;

                mId = mAdapter.getData().get(position).getId();

                if (UserManager.getInstance().isLogin()) {
                    if (mAdapter.getData().get(position).isCollect() != true) {
                        collectPresenter.getCollect(mId);
                    } else {
                        collectPresenter.getUnCollect(mId);
                    }
                } else {
                    mCollectView.setBackgroundResource(R.drawable.ico_collect_normal);
                    startActivity(LoginActivity.class);
                }
            }
        });

        mSearchArticleRecyclerView.addOnItemTouchListener(new OnItemLongClickListener() {
            @Override
            public void onSimpleItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                SearchArticleModel.DatasBean datasBean = mAdapter.getData().get(position);
                shareArticlePresenter.shareArticle(datasBean.getTitle(), datasBean.getLink());
            }
        });

        mSearchArticleRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mSearchArticleRecyclerView.setAdapter(mAdapter);
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
        mSmartRefreshUtils.setLoadMoreListener(() -> mPresenter.getSearchArticle(mCurrentPage, mSearchView.getText() + ""));
    }

    private void loadData() {
        mCurrentPage = PAGE_START;
        mPresenter.getSearchArticle(mCurrentPage, mSearchView.getText() + "");
    }

    @Override
    protected void initData() {
        mPresenter.getHot();
    }

    @Override
    public void getHotSuccess(List<HotModel> data) {
        mHotData = data;
        mHotAdapter.setNewData(mHotData);
    }

    @Override
    public void getHotError(String msg) {
        onError();
        toast(msg);
    }

    @Override
    public void getSearchArticleSuccess(SearchArticleModel data) {
        mCurrentPage = data.getCurPage() + PAGE_START;

        this.mData = data.getDatas();
        if (data.getTotal() != 0) {
            onComplete();
            mHotLayout.setVisibility(View.GONE);
            mHistoryLayout.setVisibility(View.GONE);
            mSmartRefreshLayout.setVisibility(View.VISIBLE);

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
    public void getSearchArticleError(String msg) {
        toast(msg);
        mSmartRefreshUtils.fail();
    }


    @OnClick(R.id.tv_home_search)
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_home_search:
                //缓存搜索记录
                SPHistoryUtils.saveSearchHistory(mSearchView.getText().toString());
                loadData();
                break;
        }
    }

    @Override
    public void getCollectSuccess(CollectModel data) {
        toast("收藏成功");
        if (mAdapter.getData().get(mPosition).isCollect() == false) {
            mAdapter.getData().get(mPosition).setCollect(true);
            mCollectView.setBackgroundResource(R.drawable.ico_collect);
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
        if (mAdapter.getData().get(mPosition).isCollect() == true) {
            mAdapter.getData().get(mPosition).setCollect(false);
            mCollectView.setBackgroundResource(R.drawable.ico_collect_normal);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void getUnCollectError(String msg) {
        toast(msg);
    }

    @Override
    public void getShareArticleSuccess(ShareArticleModel data) {
        toast("分享成功到广场");
    }

    @Override
    public void getShareArticleError(String msg) {
        toast(msg);

    }
}
