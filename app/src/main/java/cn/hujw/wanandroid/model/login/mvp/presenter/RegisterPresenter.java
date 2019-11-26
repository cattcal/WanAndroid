package cn.hujw.wanandroid.model.login.mvp.presenter;

import cn.hujw.wanandroid.model.login.mvp.contract.RegisterContract;
import cn.hujw.wanandroid.model.login.mvp.listener.RegisterOnListener;
import cn.hujw.wanandroid.model.login.mvp.model.UserRegisterModel;
import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.mvp.MvpPresenter;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/26 0026
 */
public class RegisterPresenter extends MvpPresenter<RegisterContract.View> implements RegisterContract.Presenter, RegisterOnListener {

    @MvpInject
    UserRegisterModel model;

    @Override
    public void getRegister(String userName, String passWord, String rePassword) {
        model.setListener(this);
        model.userRegister(userName,passWord,rePassword);
    }

    @Override
    public void onRegisterSucceed(UserRegisterModel data) {
        getView().getRegisterSuccess(data);
    }

    @Override
    public void onRegisterFail(String msg) {
        getView().getRegisterError(msg);
    }
}
