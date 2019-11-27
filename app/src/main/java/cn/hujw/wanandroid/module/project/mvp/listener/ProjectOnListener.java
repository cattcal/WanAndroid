package cn.hujw.wanandroid.module.project.mvp.listener;

import java.util.List;

import cn.hujw.wanandroid.module.project.mvp.modle.ProjectTabModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/22 0022
 */
public interface ProjectOnListener {

    void onProjectTabSucceed(List<ProjectTabModel> data);

    void onProjectTabFail(String msg);

}
