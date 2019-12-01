package cn.hujw.wanandroid.ui.mvp.listener;

import cn.hujw.wanandroid.ui.mvp.model.CollectModel;
import cn.hujw.wanandroid.ui.mvp.model.UnCollectModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/27 0027
 */
public interface CollectOnListener {
    void onCollectSucceed(CollectModel data);

    void onCollectFail(String msg);


    void onUnCollectSucceed(UnCollectModel data);

    void onUnCollectFail(String msg);
}
