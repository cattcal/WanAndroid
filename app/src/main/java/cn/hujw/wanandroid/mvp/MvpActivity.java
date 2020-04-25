package cn.hujw.wanandroid.mvp;

import android.content.Context;

import com.gyf.immersionbar.ImmersionBar;

import cn.hujw.wanandroid.common.MyActivity;
import cn.hujw.wanandroid.mvp.proxy.IMvpPresenterProxy;
import cn.hujw.wanandroid.mvp.proxy.MvpPresenterProxyImpl;
import cn.hujw.wanandroid.utils.DarkThemeUtils;

/**
 * @author: hujw
 * @date: 2019/8/25
 * @description: MVP Activity 基类
 * @email: hujw_android@163.com
 */
public abstract class MvpActivity extends MyActivity implements IMvpView {

    private IMvpPresenterProxy mMvpProxy;

    @Override
    public void initActivity() {
        mMvpProxy = createPresenterProxy();
        mMvpProxy.bindPresenter();
        super.initActivity();


    }

    protected IMvpPresenterProxy createPresenterProxy() {
        return new MvpPresenterProxyImpl(this);
    }

    @Override
    protected void onDestroy() {
        mMvpProxy.unbindPresenter();
        super.onDestroy();
    }

    @Override
    public Context getContext() {
        return this;
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
