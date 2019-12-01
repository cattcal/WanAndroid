package cn.hujw.wanandroid.module.mine.mvp.presenter;

import cn.hujw.wanandroid.module.mine.mvp.contract.MineIntegralContract;
import cn.hujw.wanandroid.module.mine.mvp.listener.MineIntegralOnListener;
import cn.hujw.wanandroid.module.mine.mvp.modle.MineIntegralModel;
import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.mvp.MvpPresenter;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/27 0027
 */
public class MineIntegralPresenter extends MvpPresenter<MineIntegralContract.View> implements MineIntegralContract.Presenter, MineIntegralOnListener {

    @MvpInject
    MineIntegralModel model;

    @Override
    public void getMineIntegral(int num) {
        model.setListener(this);
        model.getMineIntegral(num);
    }

    @Override
    public void onMineIntegralSucceed(MineIntegralModel data) {
        getView().getMineIntegralSuccess(data);
    }

    @Override
    public void ontMineIntegralFail(String errorMsg) {
        getView().getMineIntegralError(errorMsg);
    }
}
