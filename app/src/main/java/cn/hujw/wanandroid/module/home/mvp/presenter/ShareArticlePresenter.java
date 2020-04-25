package cn.hujw.wanandroid.module.home.mvp.presenter;

import cn.hujw.wanandroid.module.home.mvp.contract.ShareArticleContract;
import cn.hujw.wanandroid.module.home.mvp.listener.ShareArticleOnListener;
import cn.hujw.wanandroid.module.home.mvp.modle.ShareArticleModel;
import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.mvp.MvpPresenter;

public class ShareArticlePresenter extends MvpPresenter<ShareArticleContract.View> implements ShareArticleContract.Presenter, ShareArticleOnListener {

    @MvpInject
    ShareArticleModel model;

    @Override
    public void shareArticle(String title, String link) {
        model.setListener(this);
        model.searchArticle(title, link);
    }

    @Override
    public void onShareArticleSucceed(ShareArticleModel data) {
        getView().getShareArticleSuccess(data);
    }

    @Override
    public void onShareArticleFail(String msg) {
        getView().getShareArticleError(msg);
    }
}
