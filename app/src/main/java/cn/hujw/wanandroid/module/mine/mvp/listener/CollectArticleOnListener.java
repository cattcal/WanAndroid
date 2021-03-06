package cn.hujw.wanandroid.module.mine.mvp.listener;

import cn.hujw.wanandroid.module.mine.mvp.modle.CollectArticleModel;

/**
 * @author: hujw
 * @date: 2019/11/26
 * @description:
 * @email: hujw_android@163.com
 */
public interface CollectArticleOnListener {

    void onCollectArticleSucceed(CollectArticleModel data);

    void onCollectArticleFail(String msg);
}
