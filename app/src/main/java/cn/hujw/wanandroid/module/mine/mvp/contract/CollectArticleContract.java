package cn.hujw.wanandroid.module.mine.mvp.contract;

import cn.hujw.wanandroid.module.mine.mvp.modle.CollectArticleModel;
import cn.hujw.wanandroid.mvp.IMvpView;

/**
 * @author: hujw
 * @date: 2019/11/26
 * @description:
 * @email: hujw_android@163.com
 */
public class CollectArticleContract {

    public interface View extends IMvpView {

        void getCollectArticleSuccess(CollectArticleModel data);

        void getCollectArticleError(String msg);
    }

    public interface Presenter {

        void getCollectArticle(int num);
    }
}
