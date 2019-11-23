package cn.hujw.wanandroid.ui.mvp.listener;

import cn.hujw.wanandroid.ui.mvp.model.ProjectArticleModel;

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
