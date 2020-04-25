package cn.hujw.wanandroid.module.home.mvp.listener;

import cn.hujw.wanandroid.module.home.mvp.modle.ShareArticleModel;

public interface ShareArticleOnListener {

    void onShareArticleSucceed(ShareArticleModel data);

    void onShareArticleFail(String msg);
}
