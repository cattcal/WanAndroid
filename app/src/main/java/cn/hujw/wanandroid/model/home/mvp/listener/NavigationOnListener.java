package cn.hujw.wanandroid.model.home.mvp.listener;

import java.util.List;

import cn.hujw.wanandroid.model.home.mvp.modle.NavigationModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/22 0022
 */
public interface NavigationOnListener {

    void onNavigationSucceed(List<NavigationModel> data);

    void onNavigationFail(String msg);
}
