package cn.hujw.wanandroid.ui.mvp.presenter;

import java.util.List;

import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.mvp.MvpPresenter;
import cn.hujw.wanandroid.ui.mvp.contract.SearchContract;
import cn.hujw.wanandroid.ui.mvp.listener.SearchOnListener;
import cn.hujw.wanandroid.ui.mvp.model.HotModel;
import cn.hujw.wanandroid.ui.mvp.model.SearchArticleModel;

/**
 * @author: hujw
 * @date: 2019/11/24
 * @description:
 * @email: hujw_android@163.com
 */
public class SearchPresenter extends MvpPresenter<SearchContract.View> implements SearchContract.Presenter, SearchOnListener {

    @MvpInject
    HotModel hotModel;
    @MvpInject
    SearchArticleModel searchArticleModel;

    @Override
    public void getHot() {
        hotModel.setListener(this);
        hotModel.getHot();
    }

    @Override
    public void getSearchArticle(int num,String search) {
        searchArticleModel.setListener(this);
        searchArticleModel.getSearchArticle(num,search);
    }

    @Override
    public void onHotSucceed(List<HotModel> data) {
        getView().getHotSuccess(data);
    }

    @Override
    public void onHotFail(String msg) {
        getView().getHotError(msg);
    }

    @Override
    public void onSearchArticleSucceed(SearchArticleModel data) {
        getView().getSearchArticleSuccess(data);
    }

    @Override
    public void onSearchArticleFail(String msg) {
        getView().getSearchArticleError(msg);
    }
}
