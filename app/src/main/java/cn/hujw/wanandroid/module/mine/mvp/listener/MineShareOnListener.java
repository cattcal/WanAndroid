package cn.hujw.wanandroid.module.mine.mvp.listener;

import cn.hujw.wanandroid.module.mine.mvp.modle.MineShareModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/27 0027
 */
public interface MineShareOnListener {

    void onMineShareSucceed(MineShareModel data);

    void onMineShareFail(String msg);
}
