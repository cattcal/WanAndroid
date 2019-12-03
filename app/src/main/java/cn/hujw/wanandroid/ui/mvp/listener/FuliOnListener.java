package cn.hujw.wanandroid.ui.mvp.listener;

import java.util.List;

import cn.hujw.wanandroid.ui.mvp.model.FuliModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/12/3 0003
 */
public interface FuliOnListener {

    void onFuliSucceed(String data);

    void onFuliFail(String msg);
}
