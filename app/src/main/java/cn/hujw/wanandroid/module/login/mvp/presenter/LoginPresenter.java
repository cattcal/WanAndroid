package cn.hujw.wanandroid.module.login.mvp.presenter;

import cn.hujw.wanandroid.module.login.mvp.contract.LoginContract;
import cn.hujw.wanandroid.module.login.mvp.listener.LoginOnListener;
import cn.hujw.wanandroid.module.login.mvp.model.UserLoginModel;
import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.mvp.MvpPresenter;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/25 0025
 */
public class LoginPresenter extends MvpPresenter<LoginContract.View> implements LoginContract.Presenter, LoginOnListener {

    @MvpInject
    UserLoginModel model;

    @Override
    public void getLogin(String userName, String passWord) {
        model.setListener(this);
        model.userLogin(userName,passWord);
    }

    @Override
    public void onLoginSucceed(UserLoginModel data) {
        getView().getLoginSuccess(data);
    }

    @Override
    public void onLoginFail(String msg) {
        getView().getLoginError(msg);
    }
}
