package cn.hujw.wanandroid.model.mine.mvp.listener;

import cn.hujw.wanandroid.model.mine.mvp.modle.UserInfoModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/26 0026
 */
public interface MineOnListener {

    void onUserInfoSucceed(UserInfoModel data);

    void onUserInfoFail(String msg);
}
