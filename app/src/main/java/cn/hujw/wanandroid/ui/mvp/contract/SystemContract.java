package cn.hujw.wanandroid.ui.mvp.contract;

import java.util.List;

import cn.hujw.wanandroid.mvp.IMvpView;
import cn.hujw.wanandroid.ui.mvp.model.SystemModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/21 0021
 */
public final class SystemContract {

    public interface View extends IMvpView {

        void getSystemSuccess(List<SystemModel> data);

        void getSystemError(String msg);

    }

    public interface Presenter {

        void getSystem();

    }
}
