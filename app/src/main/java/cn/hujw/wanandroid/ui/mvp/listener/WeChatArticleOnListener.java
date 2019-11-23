package cn.hujw.wanandroid.ui.mvp.listener;

import java.util.List;

import cn.hujw.wanandroid.ui.mvp.model.WeChatArticleModel;
import cn.hujw.wanandroid.ui.mvp.model.WeChatTabModel;

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
