package cn.hujw.wanandroid.module.login.mvp.listener;

import cn.hujw.wanandroid.module.login.mvp.model.UserRegisterModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/26 0026
 */
public interface RegisterOnListener {

    void onRegisterSucceed(UserRegisterModel data);

    void onRegisterFail(String msg);
}
