package cn.hujw.wanandroid.module.login.mvp.contract;

import cn.hujw.wanandroid.module.login.mvp.model.UserLoginModel;
import cn.hujw.wanandroid.mvp.IMvpView;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/25 0025
 */
public class LoginContract {

    public interface View extends IMvpView {

        void getLoginSuccess(UserLoginModel data);

        void getLoginError(String msg);
    }

    public interface Presenter {

        void getLogin(String userName, String passWord);
    }
}
