package cn.hujw.wanandroid.module.mine.mvp.presenter;

import cn.hujw.wanandroid.module.mine.mvp.contract.LeaderboardContract;
import cn.hujw.wanandroid.module.mine.mvp.listener.LeaderboardOnListener;
import cn.hujw.wanandroid.module.mine.mvp.modle.LeaderboardModel;
import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.mvp.MvpPresenter;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/26 0026
 */
public class LeaderboardPresenter extends MvpPresenter<LeaderboardContract.View> implements LeaderboardContract.Presenter, LeaderboardOnListener {

    @MvpInject
    LeaderboardModel model;

    @Override
    public void getLeaderboard(int num) {
        model.setListener(this);
        model.getLeaderboard(num);
    }

    @Override
    public void onLeaderboardSucceed(LeaderboardModel data) {
        getView().getLeaderboardSuccess(data);
    }

    @Override
    public void ontLeaderboardFail(String errorMsg) {
        getView().getLeaderboardError(errorMsg);
    }
}
