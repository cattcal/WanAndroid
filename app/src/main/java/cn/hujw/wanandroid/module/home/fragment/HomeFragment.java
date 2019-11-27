package cn.hujw.wanandroid.module.home.fragment;

import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.bingoogolapple.bgabanner.BGABanner;
import cn.hujw.base.BaseRecyclerViewAdapter;
import cn.hujw.image.ImageLoader;
import cn.hujw.titlebar.library.TitleBar;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.mvp.MvpLazyFragment;
import cn.hujw.wanandroid.module.home.activity.NavigationActivity;
import cn.hujw.wanandroid.module.home.activity.SearchActivity;
import cn.hujw.wanandroid.ui.activity.WebActivity;
import cn.hujw.wanandroid.module.home.adapter.ArticleAdapter;
import cn.hujw.wanandroid.module.home.mvp.contract.HomeContract;
import cn.hujw.wanandroid.module.home.mvp.modle.ArticleModel;
import cn.hujw.wanandroid.module.home.mvp.modle.BannerModel;
import cn.hujw.wanandroid.module.home.mvp.presenter.HomePresenter;
import cn.hujw.wanandroid.ui.mvp.contract.CollectContract;
import cn.hujw.wanandroid.ui.mvp.model.CollectModel;
import cn.hujw.wanandroid.ui.mvp.model.UnCollectModel;
import cn.hujw.wanandroid.ui.mvp.presenter.CollectPresenter;

/**
 * @author: hujw
 * @date: 2019/8/11
 * @description: 主页面
 * @email: hujw_android@163.com
 */
public class HomeFragment extends MvpLazyFragment implements HomeContract.View, CollectContract.View, BaseRecyclerViewAdapter.OnItemClickListener, ArticleAdapter.OnViewItemClickListener {

    private static final String TAG = "HomeFragment";
    @MvpInject
    HomePresenter mPresenter;

    @MvpInject
    CollectPresenter collectPresenter;

    @BindView(R.id.tb_home)
    TitleBar mTitleBar;
    @BindView(R.id.tv_home_search)
    AppCompatTextView mSearchView;
    @BindView(R.id.srl_home)
    SmartRefreshLayout mSmartRefreshLayout;
    @BindView(R.id.bga_banner_home)
    BGABanner mBanner;
    @BindView(R.id.rv_home_list)
    RecyclerView mRecyclerView;

    private ArticleAdapter mAdapter;
    private List<ArticleModel.DatasBean> mData = new ArrayList<>();

    private int mCurrentPage;
    private List<BannerModel> bannerData = new ArrayList<>();
    private AppCompatImageView mCollectView;


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {

        mAdapter = new ArticleAdapter(getContext());
        mAdapter.setOnItemClickListener(this);
        mAdapter.setmOnViewItemClickListener(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);

        setRefresh();
    }

    /**
     * 刷新
     */
    private void setRefresh() {
        mSmartRefreshLayout.setOnRefreshListener(refreshLayout -> {
            //刷新
            loadData();
            refreshLayout.finishRefresh(true);
        });

        mSmartRefreshLayout.setOnLoadMoreListener(refreshLayout -> {
            //加载更多
            mCurrentPage++;
            mPresenter.getArticle(mCurrentPage);
            refreshLayout.finishLoadMore(true);
        });
    }


    @Override
    protected void initData() {
        onLoading();//请求数据的时候弹出Dialog  HintLayout布局的使用
        loadData();
    }

    /**
     * 请求第一页的数据
     */
    private void loadData() {
        bannerData.clear();
        mAdapter.clearData();
        mCurrentPage = 0;
        mPresenter.getBanner();
        mPresenter.getArticle(mCurrentPage);
    }

    @Override
    public void getBannerSuccess(List<BannerModel> data) {
        this.bannerData = data;
        if (bannerData != null || bannerData.size() > 0) {
            List<String> imgs = new ArrayList<>(data.size());
            List<String> titles = new ArrayList<>(data.size());
            List<String> urls = new ArrayList<>(data.size());

            for (BannerModel model : data) {
                imgs.add(model.getImagePath());
                titles.add(model.getTitle());
                urls.add(model.getUrl());
            }

            //通过传入数据模型并结合 Adapter 的方式配置数据源。这种方式主要用于加载网络图片，以及实现少于3页时的无限轮播
            mBanner.setAdapter((BGABanner.Adapter<ImageView, String>) (banner, itemView, model, position) -> ImageLoader.with(getContext()).load(imgs.get(position)).into(itemView));
            mBanner.setData(imgs, titles);

            //监听广告 item 的单击事件，在 BGABanner 里已经帮开发者处理了防止重复点击事件
            mBanner.setDelegate((BGABanner.Delegate<ImageView, String>) (banner, itemView, model, position) -> WebActivity.start(getContext(), urls.get(position)));

        } else {
            onEmpty();
        }
    }

    @Override
    public void getBannerError(String msg) {
        onError();
        toast(msg);
        mSmartRefreshLayout.finishRefresh(false);
    }

    @Override
    public void getArticleSuccess(ArticleModel data) {
        this.mData = data.getDatas();
        if (mData != null || mData.size() > 0) {
            onComplete();
            mAdapter.addData(data.getDatas());
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void getArticleError(String msg) {
        onError();
        toast(msg);
        mSmartRefreshLayout.finishRefresh(false);
    }

    @Override
    public void onItemClick(RecyclerView recyclerView, View itemView, int position) {
        WebActivity.start(getContext(), mAdapter.getData().get(position).getLink());
    }

    @OnClick({R.id.tv_home_search, R.id.iv_home_navigation})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_home_search:
                startActivity(SearchActivity.class);
                break;
            case R.id.iv_home_navigation:
                startActivity(NavigationActivity.class);
                break;
        }
    }

    @Override
    public void getCollectSuccess(CollectModel data) {
        toast("收藏成功");
        mCollectView.setImageResource(R.drawable.ico_collect);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void getCollectError(String msg) {

    }

    @Override
    public void getUnCollectSuccess(UnCollectModel data) {
        toast("取消收藏");
        mCollectView.setImageResource(R.drawable.ico_collect_normal);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void getUnCollectError(String msg) {

    }

    /**
     * 收藏
     *
     * @param view
     * @param position
     */
    @Override
    public void onItemClick(View view, int position) {
        mCollectView = view.findViewById(R.id.item_iv_collect);
        boolean collectFlag = mAdapter.getData().get(position).isCollect();

        if (collectFlag == false) {
            collectPresenter.getCollect(mAdapter.getData().get(position).getId());
        } else {
            collectPresenter.getUnCollect(mAdapter.getData().get(position).getId());
        }


    }
}