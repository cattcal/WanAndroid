package cn.hujw.wanandroid.model.login.mvp.listener;

import cn.hujw.wanandroid.model.login.mvp.model.UserInfoModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/25 0025
 */
public interface LoginOnListener {
    void onLoginSucceed(UserInfoModel data);

    void onLoginFail(String msg);
}
