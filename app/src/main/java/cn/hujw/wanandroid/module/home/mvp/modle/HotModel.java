package cn.hujw.wanandroid.module.home.mvp.modle;

import com.allen.library.interceptor.Transformer;
import com.allen.library.observer.DataObserver;

import java.util.List;

import cn.hujw.wanandroid.http.ApiHelper;
import cn.hujw.wanandroid.mvp.MvpModel;
import cn.hujw.wanandroid.module.home.mvp.listener.SearchOnListener;

/**
 * @author: hujw
 * @date: 2019/11/24
 * @description:
 * @email: hujw_android@163.com
 */
public class HotModel extends MvpModel<SearchOnListener> {


    /**
     * id : 6
     * link :
     * name : 面试
     * order : 1
     * visible : 1
     */

    private int id;
    private String link;
    private String name;
    private int order;
    private int visible;


    public void getHot() {
        // 为了省事，这里直接回调成功
        ApiHelper.getWanAndroidApi()
                .getHot()
                .compose(Transformer.switchSchedulers())
                .subscribe(new DataObserver<List<HotModel>>() {
                    @Override
                    protected void onError(String errorMsg) {
                        getListener().onHotFail(errorMsg);
                    }

                    @Override
                    protected void onSuccess(List<HotModel> data) {
                        getListener().onHotSucceed(data);
                    }
                });
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
