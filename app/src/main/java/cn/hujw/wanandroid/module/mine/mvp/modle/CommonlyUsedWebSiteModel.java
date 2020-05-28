package cn.hujw.wanandroid.module.mine.mvp.modle;

import cn.hujw.rxhttp.interceptor.Transformer;
import cn.hujw.rxhttp.observer.DataObserver;

import java.util.List;

import cn.hujw.wanandroid.http.ApiHelper;
import cn.hujw.wanandroid.module.mine.mvp.listener.CommonlyUsedWebSiteListener;
import cn.hujw.wanandroid.mvp.MvpModel;

public class CommonlyUsedWebSiteModel extends MvpModel<CommonlyUsedWebSiteListener> {

    /**
     * icon :
     * id : 17
     * link : http://www.wanandroid.com/article/list/0?cid=176
     * name : 国内大牛博客集合
     * order : 1
     * visible : 1
     */

    private String icon;
    private int id;
    private String link;
    private String name;
    private int order;
    private int visible;

    public void getCommonlyUsedWebSite() {
        // 为了省事，这里直接回调成功
        ApiHelper.getWanAndroidApi()
                .getCommonlyUsedWebSite()
                .compose(Transformer.switchSchedulers())
                .subscribe(new DataObserver<List<CommonlyUsedWebSiteModel> >() {
                    @Override
                    protected void onError(String errorMsg) {
                        getListener().onCommonlyUsedWebSiteFail(errorMsg);
                    }

                    @Override
                    protected void onSuccess(List<CommonlyUsedWebSiteModel> data) {
                        getListener().onCommonlyUsedWebSiteSucceed(data);
                    }
                });
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }
}
