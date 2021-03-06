package cn.hujw.wanandroid.module.project.mvp.listener;

import cn.hujw.wanandroid.module.project.mvp.modle.ProjectArticleModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/21 0021
 */
public interface ProjectArticleOnListener {

    void onProjectArticleSucceed(ProjectArticleModel data);

    void onProjectArticleFail(String msg);

}
