package cn.hujw.wanandroid.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import cn.hujw.wanandroid.common.Config;

/**
 * 描述：刷新工具类
 *
 * @author hujw
 * @date 2019/11/29 0029
 */
public final class SmartRefreshUtils {

    private final RefreshLayout mRefreshLayout;
    private RefreshListener mRefreshListener;
    private LoadMoreListener mLoadMoreListener;

    public SmartRefreshUtils(RefreshLayout refreshLayout) {
        mRefreshLayout = refreshLayout;
        mRefreshLayout.setEnableAutoLoadMore(false);
        mRefreshLayout.setEnableOverScrollBounce(true);
    }

    public static SmartRefreshUtils getInstance(RefreshLayout refreshLayout) {
        return new SmartRefreshUtils(refreshLayout);
    }


    public SmartRefreshUtils setRefreshListener(@Nullable RefreshListener refreshListener) {
        this.mRefreshListener = refreshListener;
        if (refreshListener == null) {
            mRefreshLayout.setEnableRefresh(false);
        } else {
            mRefreshLayout.setEnablePureScrollMode(false);
            mRefreshLayout.setEnableRefresh(true);
            mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                    refreshLayout.finishRefresh((int) Config.HTTP_TIMEOUT, false, false);
                    mRefreshListener.onRefresh();
                }
            });
        }
        return this;
    }


    public SmartRefreshUtils setLoadMoreListener(LoadMoreListener loadMoreListener) {
        this.mLoadMoreListener = loadMoreListener;
        if (loadMoreListener == null) {
            mRefreshLayout.setEnableLoadMore(false);
        } else {
            mRefreshLayout.setEnablePureScrollMode(false);
            mRefreshLayout.setEnableLoadMore(true);
            mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
                @Override
                public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                    refreshLayout.finishLoadMore((int) Config.HTTP_TIMEOUT);
                    mLoadMoreListener.onLoadMore();
                }
            });
        }
        return this;
    }

    public void autoRefresh() {
        mRefreshLayout.autoRefresh();
    }

    public void autoLoadMore() {
        mRefreshLayout.autoLoadMore();
    }


    public void success() {
        mRefreshLayout.finishRefresh(true);
        mRefreshLayout.finishLoadMore(true);
    }

    public void fail() {
        mRefreshLayout.finishRefresh(false);
        mRefreshLayout.finishLoadMore(false);
    }


    public interface RefreshListener {
        void onRefresh();
    }

    public interface LoadMoreListener {
        void onLoadMore();
    }
}
