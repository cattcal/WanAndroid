package cn.hujw.wanandroid.module.mine.mvp.contract;

import cn.hujw.wanandroid.module.mine.mvp.modle.LeaderboardModel;
import cn.hujw.wanandroid.mvp.IMvpView;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/26 0026
 */
public class LeaderboardContract {

    public interface View extends IMvpView {

        void getLeaderboardSuccess(LeaderboardModel data);

        void getLeaderboardError(String msg);
    }

    public interface Presenter {

        void getLeaderboard(int num);
    }
}
