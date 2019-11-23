package cn.hujw.wanandroid.ui.mvp.presenter;

import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.mvp.MvpPresenter;
import cn.hujw.wanandroid.ui.mvp.contract.ProjectArticleContract;
import cn.hujw.wanandroid.ui.mvp.contract.WeChatArticleContract;
import cn.hujw.wanandroid.ui.mvp.listener.ProjectArticleOnListener;
import cn.hujw.wanandroid.ui.mvp.listener.WeChatArticleOnListener;
import cn.hujw.wanandroid.ui.mvp.model.ProjectArticleModel;
import cn.hujw.wanandroid.ui.mvp.model.WeChatArticleModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/21 0021
 */
public class ProjectArticlePresenter extends MvpPresenter<ProjectArticleContract.View> implements ProjectArticleContract.Presenter, ProjectArticleOnListener {

    @MvpInject
    ProjectArticleModel projectArticleModel;

    @Override
    public void getProjectArticle(int num, String cid) {
        projectArticleModel.setListener(this);
        projectArticleModel.getProjectArticle(num,cid);
    }

    @Override
    public void onProjectArticleSucceed(ProjectArticleModel data) {
        getView().getProjectArticleSuccess(data);
    }

    @Override
    public void onProjectArticleFail(String msg) {
        getView().getProjectArticleError(msg);
    }
}
