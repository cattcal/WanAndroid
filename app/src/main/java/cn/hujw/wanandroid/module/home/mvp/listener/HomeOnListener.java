package cn.hujw.wanandroid.module.home.mvp.listener;

import java.util.List;

import cn.hujw.wanandroid.module.home.mvp.modle.ArticleModel;
import cn.hujw.wanandroid.module.home.mvp.modle.BannerModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/20 0020
 */
public interface HomeOnListener {

    void onBannerSucceed(List<BannerModel> data);

    void onBannerFail(String msg);

    void onTopArticleSucceed(List<ArticleModel.DatasBean> data);

    void onTopArticleFail(String msg);

    void onArticleSucceed(ArticleModel data);

    void onArticleFail(String msg);
}
