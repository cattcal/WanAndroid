package cn.hujw.wanandroid.ui.mvp.listener;

import java.util.List;

import cn.hujw.wanandroid.ui.mvp.model.SystemModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/21 0021
 */
public interface SystemOnListener {

    void onSystemSucceed(List<SystemModel> data);

    void onSystemFail(String msg);
}
