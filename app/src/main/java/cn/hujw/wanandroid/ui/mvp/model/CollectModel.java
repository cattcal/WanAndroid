package cn.hujw.wanandroid.ui.mvp.model;

import cn.hujw.rxhttp.interceptor.Transformer;
import cn.hujw.rxhttp.observer.DataObserver;

import cn.hujw.wanandroid.http.ApiHelper;
import cn.hujw.wanandroid.mvp.MvpModel;
import cn.hujw.wanandroid.ui.mvp.listener.CollectOnListener;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/27 0027
 */
public class CollectModel extends MvpModel<CollectOnListener> {
    public void getCollect(int id) {
        // 为了省事，这里直接回调成功
        ApiHelper.getWanAndroidApi()
                .getCollect(id)
                .compose(Transformer.switchSchedulers())
                .subscribe(new DataObserver<CollectModel>() {
                    @Override
                    protected void onError(String errorMsg) {
                        getListener().onCollectFail(errorMsg);
                    }

                    @Override
                    protected void onSuccess(CollectModel data) {
                        getListener().onCollectSucceed(data);
                    }
                });
    }
}
