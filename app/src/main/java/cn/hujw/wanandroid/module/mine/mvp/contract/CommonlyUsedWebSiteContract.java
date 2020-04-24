package cn.hujw.wanandroid.module.mine.mvp.contract;

import java.util.List;

import cn.hujw.wanandroid.module.mine.mvp.modle.CommonlyUsedWebSiteModel;
import cn.hujw.wanandroid.mvp.IMvpView;

/**
 * 常用网站
 */
public class CommonlyUsedWebSiteContract {

    public interface View extends IMvpView {

        void getCommonlyUsedWebSiteSuccess(List<CommonlyUsedWebSiteModel> data);

        void getCommonlyUsedWebSiteError(String msg);
    }

    public interface Presenter {

        void getCommonlyUsedWebSite();
    }
}
