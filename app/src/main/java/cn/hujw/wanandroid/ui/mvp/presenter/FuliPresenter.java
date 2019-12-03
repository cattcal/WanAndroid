package cn.hujw.wanandroid.ui.mvp.presenter;

import java.util.List;

import cn.hujw.wanandroid.common.Config;
import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.mvp.MvpPresenter;
import cn.hujw.wanandroid.ui.mvp.contract.FuliContract;
import cn.hujw.wanandroid.ui.mvp.listener.FuliOnListener;
import cn.hujw.wanandroid.ui.mvp.model.FuliModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/12/3 0003
 */
public class FuliPresenter extends MvpPresenter<FuliContract.View> implements FuliContract.Presenter, FuliOnListener {

    @MvpInject
    FuliModel model;

    @Override
    public void getFuli(int page) {
        model.setListener(this);
        model.getFuli(Config.ONE_PAGE_COUNT_DEFAULT,page);
    }

    @Override
    public void onFuliSucceed(String data) {
        getView().getFuliSuccess(data);
    }

    @Override
    public void onFuliFail(String msg) {
        getView().getFulictError(msg);
    }
}
