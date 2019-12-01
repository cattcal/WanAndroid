package cn.hujw.wanandroid.module.home.mvp.listener;

import java.util.List;

import cn.hujw.wanandroid.module.home.mvp.modle.HotModel;
import cn.hujw.wanandroid.module.home.mvp.modle.SearchArticleModel;

/**
 * @author: hujw
 * @date: 2019/11/24
 * @description:
 * @email: hujw_android@163.com
 */
public interface SearchOnListener {

    void onHotSucceed(List<HotModel> data);

    void onHotFail(String msg);

    void onSearchArticleSucceed(SearchArticleModel data);

    void onSearchArticleFail(String msg);

}
