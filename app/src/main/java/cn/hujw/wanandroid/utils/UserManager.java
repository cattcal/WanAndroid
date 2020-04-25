package cn.hujw.wanandroid.utils;

import android.content.Context;
import android.text.TextUtils;

import com.google.gson.Gson;

import cn.hujw.wanandroid.module.login.activity.LoginActivity;
import cn.hujw.wanandroid.module.login.mvp.model.UserLoginModel;

public final class UserManager {

    private static final String KEY_LOGIN_BEAN = "KEY_LOGIN_BEAN";

    private UserLoginModel mLoginModel = null;

    private static class Holder {
        private static final UserManager INSTANCE = new UserManager();
    }

    public static UserManager getInstance() {
        return Holder.INSTANCE;
    }

    private UserManager() {
        getLoginModel();
    }

    public UserLoginModel getLoginModel() {
        if (mLoginModel == null) {
            String json = SPUtils.getInstance().get(KEY_LOGIN_BEAN, "");
            if (!TextUtils.isEmpty(json)) {
                try {
                    mLoginModel = new Gson().fromJson(json, UserLoginModel.class);
                } catch (Exception ignore) {
                }
            }
        }
        return mLoginModel;
    }

    public void login(UserLoginModel loginModel) {
        mLoginModel = loginModel;
        String json = new Gson().toJson(loginModel);
        SPUtils.getInstance().save(KEY_LOGIN_BEAN, json);
    }

    public void logout() {
        mLoginModel = null;
        SPUtils.getInstance().clear();
    }

    public void update(UserLoginModel loginModel) {
        mLoginModel = loginModel;
        SPUtils.getInstance().save(KEY_LOGIN_BEAN, loginModel);
    }

    public boolean isLogin() {
        UserLoginModel loginModel = getLoginModel();
        if (loginModel == null) {
            return false;
        }
        if (loginModel.getId() > 0) {
            return true;
        }
        return false;
    }

    public int getUserId() {
        UserLoginModel loginModel = getLoginModel();
        if (loginModel == null) {
            return 0;
        }
        return loginModel.getId();
    }


    public boolean doIfLogin(Context context) {
        if (isLogin()) {
            return true;
        } else {
            LoginActivity.start(context);
            return false;
        }
    }


}
