package cn.hujw.wanandroid.module.login.mvp.model;

import com.allen.library.interceptor.Transformer;
import com.allen.library.observer.DataObserver;

import java.util.List;

import cn.hujw.wanandroid.http.ApiHelper;
import cn.hujw.wanandroid.module.login.mvp.listener.LoginOnListener;
import cn.hujw.wanandroid.mvp.MvpModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/25 0025
 */
public final class UserLoginModel extends MvpModel<LoginOnListener> {

    /**
     * admin : false
     * chapterTops : []
     * collectIds : []
     * email :
     * icon :
     * id : 20690
     * nickname : huxiaoniu
     * password :
     * publicName : huxiaoniu
     * token :
     * type : 0
     * username : huxiaoniu
     */

    private boolean admin;
    private String email;
    private String icon;
    private int id;
    private String nickname;
    private String password;
    private String publicName;
    private String token;
    private int type;
    private String username;
    private List<?> chapterTops;
    private List<?> collectIds;

    public void userLogin(String username,String  password) {
        // 为了省事，这里直接回调成功
        ApiHelper.getWanAndroidApi()
                .userLogin(username,password)
                .compose(Transformer.switchSchedulers())
                .subscribe(new DataObserver<UserLoginModel>() {
                    @Override
                    protected void onError(String errorMsg) {
                        getListener().onLoginFail(errorMsg);
                    }

                    @Override
                    protected void onSuccess(UserLoginModel data) {
                        getListener().onLoginSucceed(data);
                    }
                });
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPublicName() {
        return publicName;
    }

    public void setPublicName(String publicName) {
        this.publicName = publicName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<?> getChapterTops() {
        return chapterTops;
    }

    public void setChapterTops(List<?> chapterTops) {
        this.chapterTops = chapterTops;
    }

    public List<?> getCollectIds() {
        return collectIds;
    }

    public void setCollectIds(List<?> collectIds) {
        this.collectIds = collectIds;
    }
}
