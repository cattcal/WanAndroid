package cn.hujw.wanandroid.model.home.activity;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.hujw.base.BaseRecyclerViewAdapter;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.mvp.MvpActivity;
import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.ui.activity.WebActivity;
import cn.hujw.wanandroid.model.home.adapter.NavigationRightAdapter;
import cn.hujw.wanandroid.model.home.adapter.NavigationTabAdapter;
import cn.hujw.wanandroid.model.home.mvp.contract.NavigationContract;
import cn.hujw.wanandroid.model.home.mvp.modle.NavigationModel;
import cn.hujw.wanandroid.model.home.mvp.presenter.NavigationPresenter;

/**
 * 描述：导航页面
 *
 * @author hujw
 * @date 2019/11/20 0020
 */
public final class NavigationActivity extends MvpActivity implements NavigationContract.View, NavigationRightAdapter.OnItemClick {

    private static final String TAG = "NavigationActivity";
    @MvpInject
    NavigationPresenter mPresenter;


    @BindView(R.id.rv_navigation_tab)
    RecyclerView mTabRecyclerView;
    @BindView(R.id.rv_navigation_right)
    RecyclerView mRightRecyclerView;


    private NavigationTabAdapter mTabAdapter;

    private NavigationRightAdapter mRightAdapter;

    private List<NavigationModel> mData = new ArrayList<>();
    private LinearLayoutManager tabManager;
    private LinearLayoutManager rightManager;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_navigation;
    }

    @Override
    protected void initView() {
        mTabAdapter = new NavigationTabAdapter(this);
        //Tab点击

        mTabAdapter.setOnItemClickListener((recyclerView, itemView, position) -> {

            //设置点击的位置，改变点击背景
            mTabAdapter.setSelectPosition(position);

            //将左边点击的小项移动到中间
            moveTabClickItemToCenter(position);
            //点击Tab滚动Right
            clickTabScrollRight(position);
        });

        tabManager = new LinearLayoutManager(this);
        mTabRecyclerView.setLayoutManager(tabManager);
        mTabRecyclerView.setAdapter(mTabAdapter);

        mRightAdapter = new NavigationRightAdapter(this);
        mRightAdapter.setmOnItemClick(this);
        mRightAdapter.setOnScrollingListener(new BaseRecyclerViewAdapter.OnScrollingListener() {
            @Override
            public void onScrollTop(RecyclerView recyclerView) {
                mTabAdapter.setSelectPosition(0);
                mTabRecyclerView.smoothScrollToPosition(0);
            }

            @Override
            public void onScrolling(RecyclerView recyclerView) {

                int firstVisibleItemPosition = rightManager.findFirstVisibleItemPosition();
                mTabAdapter.setSelectPosition(firstVisibleItemPosition);
                mTabRecyclerView.smoothScrollToPosition(firstVisibleItemPosition + 1);
                moveTabClickItemToCenter(firstVisibleItemPosition);

            }

            @Override
            public void onScrollDown(RecyclerView recyclerView) {

            }
        });

        rightManager = new LinearLayoutManager(this);
        mRightRecyclerView.setLayoutManager(rightManager);
        mRightRecyclerView.setAdapter(mRightAdapter);
    }

    /**
     * 点击Tab滚动Right
     */
    private void clickTabScrollRight(int position) {
        int rightFirstVisiblePosition = rightManager.findFirstVisibleItemPosition();
        int rightLastVisiblePosition = rightManager.findLastVisibleItemPosition();

        if (position < rightFirstVisiblePosition) { //position在firstVisiblePosition的上面直接滚动即可
            mRightRecyclerView.smoothScrollToPosition(position);
        } else if (position >= rightFirstVisiblePosition && position <= rightLastVisiblePosition) {//可视的范围内
            int top = rightManager.findViewByPosition(position).getTop();
            mRightRecyclerView.smoothScrollBy(0, top);
        } else { //position在lastVisiblePosition的下面
            //这个并不能立即就滚到到位，必须监听右边的滚动
            mRightRecyclerView.smoothScrollToPosition(position);
        }
    }


    /**
     * 将左边点击的小项移动到中间
     */
    private void moveTabClickItemToCenter(int position) {
        int tabFirstVisiblePosition = tabManager.findFirstVisibleItemPosition();
        int tabLastVisiblePosition = tabManager.findLastVisibleItemPosition();
        int centerPosition = (tabFirstVisiblePosition + tabLastVisiblePosition) / 2;
        int centerTop = tabManager.findViewByPosition(centerPosition).getTop();
        int currentTop = tabManager.findViewByPosition(position).getTop();
        mTabRecyclerView.smoothScrollBy(0, currentTop - centerTop);
    }

    @Override
    protected void initData() {
        onLoading();
        mPresenter.getNavigation();
    }

    @Override
    public void getNavigationSuccess(List<NavigationModel> data) {
        onComplete();
        this.mData = data;
        if (mData != null || mData.size() > 0) {
            mTabAdapter.setData(data);

            mRightAdapter.setData(data);
        }
    }

    @Override
    public void getNavigationError(String msg) {
        onError();
    }

    @Override
    public void onItemClick(View view, int position, int tag) {

        NavigationModel navigationModel = mRightAdapter.getData().get(position);
        NavigationModel.ArticlesBean articlesBean = navigationModel.getArticles().get(tag);
        WebActivity.start(getContext(), articlesBean.getLink());
    }


}
