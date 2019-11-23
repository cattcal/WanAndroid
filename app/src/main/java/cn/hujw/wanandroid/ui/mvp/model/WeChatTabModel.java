package cn.hujw.wanandroid.ui.mvp.model;

import com.allen.library.interceptor.Transformer;
import com.allen.library.observer.DataObserver;

import java.io.Serializable;
import java.util.List;

import cn.hujw.wanandroid.http.ApiHelper;
import cn.hujw.wanandroid.mvp.MvpModel;
import cn.hujw.wanandroid.ui.mvp.listener.WeChatOnListener;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/21 0021
 */
public class WeChatTabModel extends MvpModel<WeChatOnListener> implements Serializable {


    /**
     * children : []
     * courseId : 13
     * id : 408
     * name : 鸿洋
     * order : 190000
     * parentChapterId : 407
     * userControlSetTop : false
     * visible : 1
     */

    private int courseId;
    private int id;
    private String name;
    private int order;
    private int parentChapterId;
    private boolean userControlSetTop;
    private int visible;
    private List<?> children;

    public void getWeChatTab() {
        // 为了省事，这里直接回调成功
        ApiHelper.getWanAndroidApi()
                .getPublicTab()
                .compose(Transformer.switchSchedulers())
                .subscribe(new DataObserver<List<WeChatTabModel>>() {
                    @Override
                    protected void onError(String errorMsg) {
                        getListener().onWeChatTabFail(errorMsg);
                    }

                    @Override
                    protected void onSuccess(List<WeChatTabModel> data) {
                        getListener().onWeChatTabSucceed(data);
                    }
                });
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getParentChapterId() {
        return parentChapterId;
    }

    public void setParentChapterId(int parentChapterId) {
        this.parentChapterId = parentChapterId;
    }

    public boolean isUserControlSetTop() {
        return userControlSetTop;
    }

    public void setUserControlSetTop(boolean userControlSetTop) {
        this.userControlSetTop = userControlSetTop;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public List<?> getChildren() {
        return children;
    }

    public void setChildren(List<?> children) {
        this.children = children;
    }
}
