package cn.hujw.wanandroid.module.project.mvp.modle;

import cn.hujw.rxhttp.interceptor.Transformer;
import cn.hujw.rxhttp.observer.DataObserver;

import java.io.Serializable;
import java.util.List;

import cn.hujw.wanandroid.http.ApiHelper;
import cn.hujw.wanandroid.mvp.MvpModel;
import cn.hujw.wanandroid.module.project.mvp.listener.ProjectOnListener;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/22 0022
 */
public class ProjectTabModel extends MvpModel<ProjectOnListener> implements Serializable {


    /**
     * children : []
     * courseId : 13
     * id : 294
     * name : 完整项目
     * order : 145000
     * parentChapterId : 293
     * userControlSetTop : false
     * visible : 0
     */

    private int courseId;
    private int id;
    private String name;
    private int order;
    private int parentChapterId;
    private boolean userControlSetTop;
    private int visible;
    private List<?> children;

    public void getProjectTab() {
        // 为了省事，这里直接回调成功
        ApiHelper.getWanAndroidApi()
                .getProjectTab()
                .compose(Transformer.switchSchedulers())
                .subscribe(new DataObserver<List<ProjectTabModel>>() {
                    @Override
                    protected void onError(String errorMsg) {
                        getListener().onProjectTabFail(errorMsg);
                    }

                    @Override
                    protected void onSuccess(List<ProjectTabModel> data) {
                        getListener().onProjectTabSucceed(data);
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
