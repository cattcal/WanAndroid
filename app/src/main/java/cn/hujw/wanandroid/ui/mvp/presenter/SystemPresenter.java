package cn.hujw.wanandroid.ui.mvp.presenter;

import java.util.List;

import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.mvp.MvpPresenter;
import cn.hujw.wanandroid.ui.mvp.contract.SystemContract;
import cn.hujw.wanandroid.ui.mvp.listener.SystemOnListener;
import cn.hujw.wanandroid.ui.mvp.model.SystemModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/21 0021
 */
public final class SystemPresenter extends MvpPresenter<SystemContract.View> implements SystemContract.Presenter, SystemOnListener {

    @MvpInject
    SystemModel systemModel;

    @Override
    public void getSystem() {
        systemModel.setListener(this);
        systemModel.getSystem();
    }

    @Override
    public void onSystemSucceed(List<SystemModel> data) {
        getView().getSystemSuccess(data);
    }

    @Override
    public void onSystemFail(String msg) {
        getView().getSystemError(msg);
    }
}
