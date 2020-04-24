package cn.hujw.wanandroid.helper;

import cn.hujw.wanandroid.module.mine.mvp.modle.UserInfoModel;

public final class UserInfoManager {

    /**
     * 用户信息管理类
     */
    private static UserInfoManager mInstance;

    private UserInfoModel mUserInfoModel;

    /**
     * 单例封装
     *
     * @return
     */
    public static UserInfoManager getInstance() {
        if (mInstance == null) {
            if (mInstance == null) {
                mInstance = new UserInfoManager();
            }

        }
        return mInstance;
    }

    public UserInfoModel getUserInfo() {
        return mUserInfoModel;
    }

    public void setUserInfo(UserInfoModel mUserInfoModel) {
        this.mUserInfoModel = mUserInfoModel;
    }

}
