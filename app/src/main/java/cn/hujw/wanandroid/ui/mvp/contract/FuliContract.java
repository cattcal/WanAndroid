package cn.hujw.wanandroid.ui.mvp.contract;

import java.util.List;

import cn.hujw.wanandroid.mvp.IMvpView;
import cn.hujw.wanandroid.ui.mvp.model.FuliModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/12/3 0003
 */
public class FuliContract {

    public interface View extends IMvpView {


        void getFuliSuccess(String data);

        void getFulictError(String msg);


    }

    public interface Presenter {


        void getFuli(int page);


    }
}
