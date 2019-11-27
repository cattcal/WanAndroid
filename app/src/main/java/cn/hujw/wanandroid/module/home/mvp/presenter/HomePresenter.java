package cn.hujw.wanandroid.module.home.mvp.presenter;

import java.util.List;

import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.mvp.MvpPresenter;
import cn.hujw.wanandroid.module.home.mvp.contract.HomeContract;
import cn.hujw.wanandroid.module.home.mvp.listener.HomeOnListener;
import cn.hujw.wanandroid.module.home.mvp.modle.ArticleModel;
import cn.hujw.wanandroid.module.home.mvp.modle.BannerModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/20 0020
 */
public final class HomePresenter extends MvpPresenter<HomeContract.View>
        implements HomeContract.Presenter, HomeOnListener {

    @MvpInject
    BannerModel bannerModel;

    @MvpInject
    ArticleModel articleModel;


    @Override
    public void getBanner() {
        bannerModel.setListener(this);
        bannerModel.getBanner();
    }

    @Override
    public void getArticle(int num) {
        articleModel.setListener(this);
        articleModel.getArticle(num);
    }

    @Override
    public void onBannerSucceed(List<BannerModel> data) {
        getView().getBannerSuccess(data);
    }

    @Override
    public void onBannerFail(String msg) {
        getView().getBannerError(msg);
    }

    @Override
    public void onArticleSucceed(ArticleModel data) {
        getView().getArticleSuccess(data);
    }

    @Override
    public void onArticleFail(String msg) {
        getView().getArticleError(msg);
    }
}
