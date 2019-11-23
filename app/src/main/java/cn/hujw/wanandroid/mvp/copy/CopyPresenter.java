package cn.hujw.wanandroid.mvp.copy;

import java.util.List;

import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.mvp.MvpPresenter;

/**
 * @author: hujw
 * @date: 2019/8/25
 * @description: 可进行拷贝的业务处理类
 * @email: hujw_android@163.com
 */
public final class CopyPresenter extends MvpPresenter<CopyContract.View>
        implements CopyContract.Presenter, CopyOnListener {

    @MvpInject
    CopyModel mModel;

    /**
     * {@link CopyContract.Presenter}
     */

    @Override
    public void login(String account, String password) {
        mModel.setAccount(account);
        mModel.setPassword(password);
        mModel.setListener(this);
        mModel.login();
    }

    /**
     * {@link CopyOnListener}
     */

    @Override
    public void onSucceed(List<String> data) {
        getView().loginSuccess(data);
    }

    @Override
    public void onFail(String msg) {
        getView().loginError(msg);
    }
}

