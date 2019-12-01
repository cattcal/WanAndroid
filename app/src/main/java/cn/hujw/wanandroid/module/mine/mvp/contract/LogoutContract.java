package cn.hujw.wanandroid.module.mine.mvp.contract;

import cn.hujw.wanandroid.module.mine.mvp.modle.UserLogoutModel;
import cn.hujw.wanandroid.mvp.IMvpView;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/26 0026
 */
public class LogoutContract {

    public interface View extends IMvpView {

        void getLogoutSuccess(UserLogoutModel data);

        void getLogoutError(String msg);
    }

    public interface Presenter {

        void getLogout();
    }
}
