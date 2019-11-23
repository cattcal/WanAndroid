package cn.hujw.wanandroid.mvp;

import android.content.Context;

import cn.hujw.wanandroid.common.MyLazyFragment;
import cn.hujw.wanandroid.mvp.proxy.IMvpPresenterProxy;
import cn.hujw.wanandroid.mvp.proxy.MvpPresenterProxyImpl;

/**
 * @author: hujw
 * @date: 2019/8/25
 * @description: MVP 懒加载 Fragment 基类
 * @email: hujw_android@163.com
 */
public abstract class MvpLazyFragment extends MyLazyFragment implements IMvpView {

    private IMvpPresenterProxy mMvpProxy;

    @Override
    protected void initFragment() {
        mMvpProxy = createPresenterProxy();
        mMvpProxy.bindPresenter();
        super.initFragment();
    }

    protected IMvpPresenterProxy createPresenterProxy() {
        return new MvpPresenterProxyImpl(this);
    }

    @Override
    public void onDestroy() {
        if (mMvpProxy != null) {
            mMvpProxy.unbindPresenter();
        }
        super.onDestroy();
    }

    @Override
    public Context getContext() {
        return super.getContext();
    }

    @Override
    public void onLoading() {
        showLoading();
    }

    @Override
    public void onComplete() {
        showComplete();
    }

    @Override
    public void onEmpty() {
        showEmpty();
    }

    @Override
    public void onError() {
        showError();
    }
}
