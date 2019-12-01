package cn.hujw.wanandroid.module.mine.mvp.listener;

import cn.hujw.wanandroid.module.mine.mvp.modle.LeaderboardModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/26 0026
 */
public interface LeaderboardOnListener {

    void onLeaderboardSucceed(LeaderboardModel data);

    void ontLeaderboardFail(String errorMsg);
}
