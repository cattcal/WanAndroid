package cn.hujw.wanandroid.module.mine.mvp.presenter;

import cn.hujw.wanandroid.module.mine.mvp.contract.MineContract;
import cn.hujw.wanandroid.module.mine.mvp.listener.MineOnListener;
import cn.hujw.wanandroid.module.mine.mvp.modle.UserInfoModel;
import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.mvp.MvpPresenter;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/26 0026
 */
public class MinePresenter extends MvpPresenter<MineContract.View> implements MineContract.Presenter, MineOnListener {

    @MvpInject
    UserInfoModel model;

    @Override
    public void getUserInfo() {
        model.setListener(this);
        model.getUserInfo();
    }

    @Override
    public void onUserInfoSucceed(UserInfoModel data) {
        getView().getUserInfoSuccess(data);
    }

    @Override
    public void onUserInfoFail(String msg) {
        getView().getUserInfoError(msg);
    }
}
