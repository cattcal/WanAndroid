package cn.hujw.wanandroid.module.home.mvp.contract;

import java.util.List;

import cn.hujw.wanandroid.module.home.mvp.modle.ArticleModel;
import cn.hujw.wanandroid.module.home.mvp.modle.BannerModel;
import cn.hujw.wanandroid.module.home.mvp.modle.ShareArticleModel;
import cn.hujw.wanandroid.mvp.IMvpView;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/20 0020
 */
public final class ShareArticleContract {

    public interface View extends IMvpView {

        void getShareArticleSuccess(ShareArticleModel data);

        void getShareArticleError(String msg);


    }

    public interface Presenter {


        void shareArticle(String title, String link);

    }
}
