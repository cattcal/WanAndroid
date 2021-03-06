package cn.hujw.wanandroid.module.login.mvp.listener;

import cn.hujw.wanandroid.module.login.mvp.model.UserLoginModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/25 0025
 */
public interface LoginOnListener {
    void onLoginSucceed(UserLoginModel data);

    void onLoginFail(String msg);
}
