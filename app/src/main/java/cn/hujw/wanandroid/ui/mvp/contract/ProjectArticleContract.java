package cn.hujw.wanandroid.ui.mvp.contract;

import cn.hujw.wanandroid.mvp.IMvpView;
import cn.hujw.wanandroid.ui.mvp.model.ProjectArticleModel;
import cn.hujw.wanandroid.ui.mvp.model.WeChatArticleModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/21 0021
 */
public class ProjectArticleContract {

    public interface View extends IMvpView {

        void getProjectArticleSuccess(ProjectArticleModel data);

        void getProjectArticleError(String msg);
    }

    public interface Presenter {

        void getProjectArticle( int num,String cid);
    }
}
