package cn.hujw.wanandroid.module.mine.mvp.listener;

import cn.hujw.wanandroid.module.mine.mvp.modle.UserLogoutModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/26 0026
 */
public interface LogoutOnListener {

    void onLogoutSucceed(UserLogoutModel data);

    void onLogoutFail(String msg);
}
