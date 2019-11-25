package cn.hujw.wanandroid.model.home.mvp.contract;

import java.util.List;

import cn.hujw.wanandroid.mvp.IMvpView;
import cn.hujw.wanandroid.model.home.mvp.modle.ArticleModel;
import cn.hujw.wanandroid.model.home.mvp.modle.BannerModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/20 0020
 */
public final class HomeContract {

    public interface View extends IMvpView {

        void getBannerSuccess(List<BannerModel> data);

        void getBannerError(String msg);

        void getArticleSuccess(ArticleModel data);

        void getArticleError(String msg);
    }

    public interface Presenter {

        void getBanner();

        void getArticle(int num);
    }
}
