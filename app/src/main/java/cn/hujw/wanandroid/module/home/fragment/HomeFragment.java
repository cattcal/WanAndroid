package cn.hujw.wanandroid.module.home.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.bingoogolapple.bgabanner.BGABanner;
import cn.hujw.image.ImageLoader;
import cn.hujw.titlebar.library.TitleBar;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.eventbus.RefreshBus;
import cn.hujw.wanandroid.module.home.mvp.contract.ShareArticleContract;
import cn.hujw.wanandroid.module.home.mvp.modle.ShareArticleModel;
import cn.hujw.wanandroid.module.home.mvp.presenter.ShareArticlePresenter;
import cn.hujw.wanandroid.module.login.activity.LoginActivity;
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
import cn.hujw.wanandroid.utils.SmartRefreshUtils;
import cn.hujw.wanandroid.utils.UserManager;

import static cn.hujw.wanandroid.common.Config.PAGE_START;

/**
 * @author: hujw
 * @date: 2019/8/11
 * @description: 主页面
 * @email: hujw_android@163.com
 */
public class HomeFragment extends MvpLazyFragment implements HomeContract.View, CollectContract.View, ShareArticleContract.View {

    private static final String TAG = "HomeFragment";
    @MvpInject
    HomePresenter mPresenter;

    @MvpInject
    CollectPresenter collectPresenter;

    @MvpInject
    ShareArticlePresenter shareArticlePresenter;

    @BindView(R.id.tb_home)
    TitleBar mTitleBar;
    @BindView(R.id.tv_home_search)
    AppCompatTextView mSearchView;
    @BindView(R.id.srl_home)
    SmartRefreshLayout mSmartRefreshLayout;

    @BindView(R.id.rv_home_list)
    RecyclerView mRecyclerView;

    BGABanner mBanner;

    private SmartRefreshUtils mSmartRefreshUtils;

    private ArticleAdapter mAdapter;
    private List<ArticleModel.DatasBean> mData = new ArrayList<>();

    private int mCurrentPage = PAGE_START;

    private List<BannerModel> bannerData = new ArrayList<>();
    private List<ArticleModel.DatasBean> topList = new ArrayList<>();
    private AppCompatImageView mCollectView;
    private int mId;
    private int mPosition;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {

        //上拉加载和下拉刷新
        setSmartRefresh();

        //初始化适配器
        initAdapter();

    }

    /**
     * 下拉刷新和上拉记载
     */
    private void setSmartRefresh() {
        //初始化
        mSmartRefreshUtils = SmartRefreshUtils.getInstance(mSmartRefreshLayout);

        //下拉刷新
        mSmartRefreshUtils.setRefreshListener(() -> {
            if (mAdapter.getData().size() != 0 || bannerData.size() != 0) {
                mAdapter.getData().clear();
                bannerData.clear();
                mAdapter.notifyDataSetChanged();
                loadData();
            }
        });

        //上拉加载
        mSmartRefreshUtils.setLoadMoreListener(() -> mPresenter.getArticle(mCurrentPage));
    }

    /**
     * 初始化适配器
     */
    private void initAdapter() {
        mAdapter = new ArticleAdapter(mData);

        //添加头部Banner
        mAdapter.addHeaderView(getBannerView());

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                WebActivity.start(getContext(), mAdapter.getData().get(position).getLink());
            }
        });


        mRecyclerView.addOnItemTouchListener(new OnItemChildClickListener() {
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

        mRecyclerView.addOnItemTouchListener(new OnItemLongClickListener() {
            @Override
            public void onSimpleItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                 ArticleModel.DatasBean datasBean= mAdapter.getData().get(position);
                shareArticlePresenter.shareArticle(datasBean.getTitle(),datasBean.getLink());
            }
        });

    }


    /**
     * 添加Banner
     */
    private View getBannerView() {

        mBanner = (BGABanner) getLayoutInflater().inflate(R.layout.header_banner, (ViewGroup) mRecyclerView.getParent(), false);

        return mBanner;
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
        mCurrentPage = PAGE_START;
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
    }

    @Override
    public void getArticleSuccess(ArticleModel data) {
        mCurrentPage = data.getCurPage() + PAGE_START;
        this.mData = data.getDatas();


        if (data.getTotal() != 0) {
            onComplete();
            if (data.getCurPage() == 1) {
                if (topList.size() > 0 || topList != null) {
                    mData.addAll(0, topList);
                }
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
    public void getArticleError(String msg) {
        onError();
        toast(msg);
        mSmartRefreshUtils.fail();
    }

    @Override
    public void getTopArticleSuccess(List<ArticleModel.DatasBean> data) {
        topList = data;
    }

    @Override
    public void getTopArticleError(String msg) {

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
        if (mAdapter.getData().get(mPosition).isCollect() == false) {
            mAdapter.getData().get(mPosition).setCollect(true);
            mCollectView.setBackgroundResource(R.drawable.ico_collect);
            mAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void getCollectError(String msg) {

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

    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void refresh(RefreshBus refreshBus) {
        loadData();
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