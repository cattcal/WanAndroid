package cn.hujw.wanandroid.module.mine.mvp.contract;

import cn.hujw.wanandroid.module.mine.mvp.modle.UserInfoModel;
import cn.hujw.wanandroid.mvp.IMvpView;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/26 0026
 */
public class MineContract {
    public interface View extends IMvpView {

        void getUserInfoSuccess(UserInfoModel data);

        void getUserInfoError(String msg);
    }

    public interface Presenter {

        void getUserInfo();
    }
}
