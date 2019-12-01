package cn.hujw.wanandroid.ui.mvp.presenter;

import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.mvp.MvpPresenter;
import cn.hujw.wanandroid.ui.mvp.contract.CollectContract;
import cn.hujw.wanandroid.ui.mvp.listener.CollectOnListener;
import cn.hujw.wanandroid.ui.mvp.model.CollectModel;
import cn.hujw.wanandroid.ui.mvp.model.UnCollectModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/27 0027
 */
public class CollectPresenter extends MvpPresenter<CollectContract.View> implements CollectContract.Presenter, CollectOnListener {

    @MvpInject
    CollectModel collectModel;

    @MvpInject
    UnCollectModel unCollectModel;

    @Override
    public void getCollect(int id) {
        collectModel.setListener(this);
        collectModel.getCollect(id);
    }

    @Override
    public void getUnCollect(int id) {
        unCollectModel.setListener(this);
        unCollectModel.getCollect(id);
    }

    @Override
    public void onCollectSucceed(CollectModel data) {
        getView().getCollectSuccess(data);
    }

    @Override
    public void onCollectFail(String msg) {
        getView().getCollectError(msg);
    }

    @Override
    public void onUnCollectSucceed(UnCollectModel data) {
        getView().getUnCollectSuccess(data);
    }

    @Override
    public void onUnCollectFail(String msg) {
        getView().getUnCollectError(msg);
    }
}
