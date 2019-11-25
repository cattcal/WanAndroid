package cn.hujw.wanandroid.model.project.mvp.contract;

import java.util.List;

import cn.hujw.wanandroid.mvp.IMvpView;
import cn.hujw.wanandroid.model.project.mvp.modle.ProjectTabModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/22 0022
 */
public class ProjectContract {

    public interface View extends IMvpView {

        void getProjectTabSuccess(List<ProjectTabModel> data);

        void getProjectTabError(String msg);

    }

    public interface Presenter {

        void getProjectTab();

    }
}
