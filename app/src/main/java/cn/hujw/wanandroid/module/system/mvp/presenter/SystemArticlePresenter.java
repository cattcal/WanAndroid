package cn.hujw.wanandroid.module.system.mvp.presenter;

import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.mvp.MvpPresenter;
import cn.hujw.wanandroid.module.system.mvp.contract.SystemArticleContract;
import cn.hujw.wanandroid.module.system.mvp.listener.SystemArticleOnListener;
import cn.hujw.wanandroid.module.system.mvp.modle.SystemArticleModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/21 0021
 */
public class SystemArticlePresenter extends MvpPresenter<SystemArticleContract.View> implements SystemArticleContract.Presenter, SystemArticleOnListener {


    @MvpInject
    SystemArticleModel systemArticleModel;


    @Override
    public void getSystemArticle(int num, String cid) {
        systemArticleModel.setListener(this);
        systemArticleModel.getSystemArticle(num,cid);
    }

    @Override
    public void onSystemArticleSucceed(SystemArticleModel data) {
        getView().getArticleSuccess(data);
    }

    @Override
    public void onSystemArticleFail(String msg) {
        getView().getArticleError(msg);
    }
}
