package cn.hujw.wanandroid.model.project.mvp.contract;

import cn.hujw.wanandroid.mvp.IMvpView;
import cn.hujw.wanandroid.model.project.mvp.modle.ProjectArticleModel;

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
