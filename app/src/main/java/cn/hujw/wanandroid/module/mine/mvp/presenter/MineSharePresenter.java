package cn.hujw.wanandroid.module.mine.mvp.presenter;

import cn.hujw.wanandroid.module.mine.mvp.contract.MineShareContract;
import cn.hujw.wanandroid.module.mine.mvp.listener.MineShareOnListener;
import cn.hujw.wanandroid.module.mine.mvp.modle.MineShareModel;
import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.mvp.MvpPresenter;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/27 0027
 */
public class MineSharePresenter extends MvpPresenter<MineShareContract.View> implements MineShareContract.Presenter, MineShareOnListener {

    @MvpInject
    MineShareModel model;

    @Override
    public void getMineShare(int num) {
        model.setListener(this);
        model.getShareArticle(num);
    }

    @Override
    public void onMineShareSucceed(MineShareModel data) {
        getView().getMineShareSuccess(data);
    }

    @Override
    public void onMineShareFail(String msg) {
        getView().getMineShareError(msg);
    }
}
