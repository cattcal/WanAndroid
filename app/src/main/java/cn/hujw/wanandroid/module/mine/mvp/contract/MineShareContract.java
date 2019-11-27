package cn.hujw.wanandroid.module.mine.mvp.contract;

import cn.hujw.wanandroid.module.mine.mvp.modle.MineShareModel;
import cn.hujw.wanandroid.mvp.IMvpView;

/**
 * @author: hujw
 * @date: 2019/11/26
 * @description:
 * @email: hujw_android@163.com
 */
public class MineShareContract {

    public interface View extends IMvpView {

        void getMineShareSuccess(MineShareModel data);

        void getMineShareError(String msg);
    }

    public interface Presenter {

        void getMineShare(int num);
    }
}
