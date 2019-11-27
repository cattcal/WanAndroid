package cn.hujw.wanandroid.module.mine.mvp.contract;

import cn.hujw.wanandroid.module.mine.mvp.modle.MineIntegralModel;
import cn.hujw.wanandroid.mvp.IMvpView;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/27 0027
 */
public class MineIntegralContract {
    public interface View extends IMvpView {

        void getMineIntegralSuccess(MineIntegralModel data);

        void getMineIntegralError(String msg);
    }

    public interface Presenter {

        void getMineIntegral(int num);
    }
}
