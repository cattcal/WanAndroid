package cn.hujw.wanandroid.module.home.mvp.contract;

import java.util.List;

import cn.hujw.wanandroid.mvp.IMvpView;
import cn.hujw.wanandroid.module.home.mvp.modle.NavigationModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/22 0022
 */
public class NavigationContract {

    public interface View extends IMvpView {

        void getNavigationSuccess(List<NavigationModel> data);

        void getNavigationError(String msg);

    }

    public interface Presenter {

        void getNavigation();

    }
}
