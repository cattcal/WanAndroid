package cn.hujw.wanandroid.module.mine.mvp.modle;

import cn.hujw.rxhttp.interceptor.Transformer;
import cn.hujw.rxhttp.observer.DataObserver;

import cn.hujw.wanandroid.http.ApiHelper;
import cn.hujw.wanandroid.module.mine.mvp.listener.MineOnListener;
import cn.hujw.wanandroid.mvp.MvpModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/26 0026
 */
public class UserInfoModel extends MvpModel<MineOnListener> {

    /**
     * coinCount : 21
     * level : 1
     * rank : 4183
     * userId : 20690
     * username : h**iaoniu
     */

    private int coinCount;
    private int level;
    private int rank;
    private int userId;
    private String username;


    public void getUserInfo() {
        // 为了省事，这里直接回调成功
        ApiHelper.getWanAndroidApi()
                .getUserInfo()
                .compose(Transformer.switchSchedulers())
                .subscribe(new DataObserver<UserInfoModel>() {
                    @Override
                    protected void onError(String errorMsg) {
                        getListener().onUserInfoFail(errorMsg);
                    }

                    @Override
                    protected void onSuccess(UserInfoModel data) {
                        getListener().onUserInfoSucceed(data);
                    }
                });
    }

    public int getCoinCount() {
        return coinCount;
    }

    public void setCoinCount(int coinCount) {
        this.coinCount = coinCount;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
