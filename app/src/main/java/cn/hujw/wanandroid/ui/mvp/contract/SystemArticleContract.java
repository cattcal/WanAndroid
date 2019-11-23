package cn.hujw.wanandroid.ui.mvp.contract;

import cn.hujw.wanandroid.mvp.IMvpView;
import cn.hujw.wanandroid.ui.mvp.model.SystemArticleModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/21 0021
 */
public class SystemArticleContract {

    public interface View extends IMvpView {

        void getArticleSuccess(SystemArticleModel data);

        void getArticleError(String msg);
    }

    public interface Presenter {

        void getSystemArticle(int num,String cid);
    }
}
