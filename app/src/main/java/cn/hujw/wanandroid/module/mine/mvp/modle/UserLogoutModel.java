package cn.hujw.wanandroid.module.mine.mvp.modle;

import com.allen.library.interceptor.Transformer;
import com.allen.library.observer.DataObserver;

import cn.hujw.wanandroid.http.ApiHelper;
import cn.hujw.wanandroid.module.mine.mvp.listener.LogoutOnListener;
import cn.hujw.wanandroid.mvp.MvpModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/26 0026
 */
public class UserLogoutModel extends MvpModel<LogoutOnListener> {

    public void userLogout() {
        // 为了省事，这里直接回调成功
        ApiHelper.getWanAndroidApi()
                .userLogout()
                .compose(Transformer.switchSchedulers())
                .subscribe(new DataObserver<UserLogoutModel>() {
                    @Override
                    protected void onError(String errorMsg) {
                        getListener().onLogoutFail(errorMsg);
                    }

                    @Override
                    protected void onSuccess(UserLogoutModel data) {
                        getListener().onLogoutSucceed(data);
                    }
                });
    }
}
