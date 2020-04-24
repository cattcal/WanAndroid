package cn.hujw.wanandroid.module.mine.mvp.presenter;

import java.util.List;

import cn.hujw.wanandroid.module.mine.mvp.contract.CommonlyUsedWebSiteContract;
import cn.hujw.wanandroid.module.mine.mvp.listener.CommonlyUsedWebSiteListener;
import cn.hujw.wanandroid.module.mine.mvp.modle.CommonlyUsedWebSiteModel;
import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.mvp.MvpPresenter;

public class CommonlyUsedWebSitePresenter extends MvpPresenter<CommonlyUsedWebSiteContract.View> implements CommonlyUsedWebSiteContract.Presenter, CommonlyUsedWebSiteListener {

    @MvpInject
    CommonlyUsedWebSiteModel model;

    @Override
    public void getCommonlyUsedWebSite() {
        model.setListener(this);
        model.getCommonlyUsedWebSite();
    }

    @Override
    public void onCommonlyUsedWebSiteSucceed(List<CommonlyUsedWebSiteModel> data) {
        getView().getCommonlyUsedWebSiteSuccess(data);
    }

    @Override
    public void onCommonlyUsedWebSiteFail(String errorMsg) {
        getView().getCommonlyUsedWebSiteError(errorMsg);
    }
}
