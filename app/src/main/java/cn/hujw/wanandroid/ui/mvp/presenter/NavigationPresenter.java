package cn.hujw.wanandroid.ui.mvp.presenter;

import java.util.List;

import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.mvp.MvpPresenter;
import cn.hujw.wanandroid.ui.mvp.contract.NavigationContract;
import cn.hujw.wanandroid.ui.mvp.listener.NavigationOnListener;
import cn.hujw.wanandroid.ui.mvp.model.NavigationModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/22 0022
 */
public class NavigationPresenter extends MvpPresenter<NavigationContract.View> implements NavigationContract.Presenter,NavigationOnListener {

    @MvpInject
    NavigationModel model;

    @Override
    public void getNavigation() {
        model.setListener(this);
        model.getNavigation();
    }

    @Override
    public void onNavigationSucceed(List<NavigationModel> data) {
        getView().getNavigationSuccess(data);
    }

    @Override
    public void onNavigationFail(String msg) {
        getView().getNavigationError(msg);
    }

}
