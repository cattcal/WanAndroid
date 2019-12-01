package cn.hujw.wanandroid.module.mine.mvp.listener;

import cn.hujw.wanandroid.module.mine.mvp.modle.MineIntegralModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/27 0027
 */
public interface MineIntegralOnListener {
    void onMineIntegralSucceed(MineIntegralModel data);

    void ontMineIntegralFail(String errorMsg);

}
