package cn.hujw.wanandroid.model.system.mvp.listener;

import cn.hujw.wanandroid.model.system.mvp.modle.SystemArticleModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/21 0021
 */
public interface SystemArticleOnListener {

    void onSystemArticleSucceed(SystemArticleModel data);

    void onSystemArticleFail(String msg);
}
