package cn.hujw.wanandroid.module.project.mvp.presenter;

import java.util.List;

import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.mvp.MvpPresenter;
import cn.hujw.wanandroid.module.project.mvp.contract.ProjectContract;
import cn.hujw.wanandroid.module.project.mvp.listener.ProjectOnListener;
import cn.hujw.wanandroid.module.project.mvp.modle.ProjectTabModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/22 0022
 */
public class ProjectPresenter extends MvpPresenter<ProjectContract.View> implements ProjectContract .Presenter, ProjectOnListener {

    @MvpInject
    ProjectTabModel projectTabModel;

    @Override
    public void getProjectTab() {
        projectTabModel.setListener(this);
        projectTabModel.getProjectTab();
    }

    @Override
    public void onProjectTabSucceed(List<ProjectTabModel> data) {
        getView().getProjectTabSuccess(data);
    }

    @Override
    public void onProjectTabFail(String msg) {
        getView().getProjectTabError(msg);
    }
}
