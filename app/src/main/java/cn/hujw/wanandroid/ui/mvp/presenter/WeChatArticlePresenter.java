package cn.hujw.wanandroid.ui.mvp.presenter;

import java.util.List;

import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.mvp.MvpPresenter;
import cn.hujw.wanandroid.ui.mvp.contract.WeChatArticleContract;
import cn.hujw.wanandroid.ui.mvp.contract.WeChatContract;
import cn.hujw.wanandroid.ui.mvp.listener.WeChatArticleOnListener;
import cn.hujw.wanandroid.ui.mvp.listener.WeChatOnListener;
import cn.hujw.wanandroid.ui.mvp.model.WeChatArticleModel;
import cn.hujw.wanandroid.ui.mvp.model.WeChatTabModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/21 0021
 */
public class WeChatArticlePresenter extends MvpPresenter<WeChatArticleContract.View> implements WeChatArticleContract.Presenter, WeChatArticleOnListener {


    @MvpInject
    WeChatArticleModel weChatArticleModel;


    @Override
    public void getWeChatArticle(int id,int num) {
        weChatArticleModel.setListener(this);
        weChatArticleModel.getSystemArticle(id,num);
    }


    @Override
    public void onWeChatArticleSucceed(WeChatArticleModel data) {
        getView().getWeChatArticleSuccess(data);
    }

    @Override
    public void onWeChatArticleFail(String msg) {
        getView().getWeChatArticleError(msg);
    }
}
