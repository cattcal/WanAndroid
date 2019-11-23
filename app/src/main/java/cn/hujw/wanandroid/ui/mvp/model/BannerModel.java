package cn.hujw.wanandroid.ui.mvp.model;

import com.allen.library.interceptor.Transformer;
import com.allen.library.observer.DataObserver;

import java.util.List;

import cn.hujw.wanandroid.http.ApiHelper;
import cn.hujw.wanandroid.mvp.MvpModel;
import cn.hujw.wanandroid.ui.mvp.listener.HomeOnListener;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/20 0020
 */
public final class BannerModel extends MvpModel<HomeOnListener> {

    /**
     * desc : 享学~
     * id : 29
     * imagePath : https://www.wanandroid.com/blogimgs/4f70771f-2d7a-4494-b9fd-0d11eca0bd6e.png
     * isVisible : 1
     * order : 0
     * title : 你比高级Android工程师差在哪里？
     * type : 0
     * url : https://mp.weixin.qq.com/s/AjittX17Jbw5B-IcNPN81A
     */

    private String desc;
    private int id;
    private String imagePath;
    private int isVisible;
    private int order;
    private String title;
    private int type;
    private String url;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(int isVisible) {
        this.isVisible = isVisible;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public void getBanner() {
        // 为了省事，这里直接回调成功
        ApiHelper.getWanAndroidApi()
                .getBanner()
                .compose(Transformer.switchSchedulers())
                .subscribe(new DataObserver<List<BannerModel>>() {
                    @Override
                    protected void onError(String errorMsg) {
                        getListener().onBannerFail(errorMsg);
                    }

                    @Override
                    protected void onSuccess(List<BannerModel> data) {
                        getListener().onBannerSucceed(data);
                    }
                });
    }
}
