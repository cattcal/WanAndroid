package cn.hujw.wanandroid.module.mine.mvp.listener;

import java.util.List;

import cn.hujw.wanandroid.module.mine.mvp.modle.CommonlyUsedWebSiteModel;

public interface CommonlyUsedWebSiteListener {
    void onCommonlyUsedWebSiteSucceed(List<CommonlyUsedWebSiteModel> data);

    void onCommonlyUsedWebSiteFail(String errorMsg);
}
