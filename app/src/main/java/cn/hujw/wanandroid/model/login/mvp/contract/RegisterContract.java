package cn.hujw.wanandroid.model.login.mvp.contract;

import cn.hujw.wanandroid.model.login.mvp.model.UserRegisterModel;
import cn.hujw.wanandroid.mvp.IMvpView;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/25 0025
 */
public class RegisterContract {

    public interface View extends IMvpView {

        void getRegisterSuccess(UserRegisterModel data);

        void getRegisterError(String msg);
    }

    public interface Presenter {

        void getRegister(String userName, String passWord,String rePassword);
    }
}
