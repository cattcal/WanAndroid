package cn.hujw.wanandroid.ui.mvp.listener;

import java.util.List;

import cn.hujw.wanandroid.ui.mvp.model.ArticleModel;
import cn.hujw.wanandroid.ui.mvp.model.BannerModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/20 0020
 */
public interface HomeOnListener {

    void onBannerSucceed(List<BannerModel> data);

    void onBannerFail(String msg);

    void onArticleSucceed(ArticleModel data);

    void onArticleFail(String msg);
}
