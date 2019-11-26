package cn.hujw.wanandroid.model.mine.mvp.presenter;

import cn.hujw.wanandroid.model.mine.mvp.contract.CollectArticleContract;
import cn.hujw.wanandroid.model.mine.mvp.listener.CollectArticleOnListener;
import cn.hujw.wanandroid.model.mine.mvp.modle.CollectArticleModel;
import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.mvp.MvpPresenter;

/**
 * @author: hujw
 * @date: 2019/11/26
 * @description:
 * @email: hujw_android@163.com
 */
public class CollectArticlePresenter extends MvpPresenter<CollectArticleContract.View> implements CollectArticleContract.Presenter, CollectArticleOnListener {

    @MvpInject
    CollectArticleModel model;

    @Override
    public void getCollectArticle(int num) {
        model.setListener(this);
        model.getCollectArticle(num);
    }

    @Override
    public void onCollectArticleSucceed(CollectArticleModel data) {
        getView().getCollectArticleSuccess(data);
    }

    @Override
    public void onCollectArticleFail(String msg) {
        getView().getCollectArticleError(msg);
    }
}
