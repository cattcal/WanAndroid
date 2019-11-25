package cn.hujw.wanandroid.model.wechat.mvp.listener;

import cn.hujw.wanandroid.model.wechat.mvp.modle.WeChatArticleModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/21 0021
 */
public interface WeChatArticleOnListener {

    void onWeChatArticleSucceed(WeChatArticleModel data);

    void onWeChatArticleFail(String msg);

}
