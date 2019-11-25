package cn.hujw.wanandroid.model.wechat.mvp.listener;

import java.util.List;

import cn.hujw.wanandroid.model.wechat.mvp.modle.WeChatTabModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/21 0021
 */
public interface WeChatOnListener {

    void onWeChatTabSucceed(List<WeChatTabModel> data);

    void onWeChatTabFail(String msg);



}
