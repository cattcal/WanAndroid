package cn.hujw.wanandroid.ui.mvp.listener;

import java.util.List;

import cn.hujw.wanandroid.ui.mvp.model.WeChatTabModel;

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
