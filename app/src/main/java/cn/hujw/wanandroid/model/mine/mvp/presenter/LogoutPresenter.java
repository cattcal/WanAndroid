package cn.hujw.wanandroid.model.mine.mvp.presenter;

import cn.hujw.wanandroid.model.mine.mvp.contract.LogoutContract;
import cn.hujw.wanandroid.model.mine.mvp.listener.LogoutOnListener;
import cn.hujw.wanandroid.model.mine.mvp.modle.UserLogoutModel;
import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.mvp.MvpPresenter;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/26 0026
 */
public class LogoutPresenter extends MvpPresenter<LogoutContract.View> implements LogoutContract.Presenter, LogoutOnListener {

    @MvpInject
    UserLogoutModel model;

    @Override
    public void getLogout() {
        model.setListener(this);
        model.userLogout();
    }

    @Override
    public void onLogoutSucceed(UserLogoutModel data) {
        getView().getLogoutSuccess(data);
    }

    @Override
    public void onLogoutFail(String msg) {
        getView().getLogoutError(msg);
    }


}
