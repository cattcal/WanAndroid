package cn.hujw.wanandroid.ui.mvp.model;

import com.allen.library.interceptor.Transformer;
import com.allen.library.observer.DataObserver;

import cn.hujw.wanandroid.http.ApiHelper;
import cn.hujw.wanandroid.mvp.MvpModel;
import cn.hujw.wanandroid.ui.mvp.listener.CollectOnListener;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/27 0027
 */
public class UnCollectModel extends MvpModel<CollectOnListener> {
    public void getCollect(int id) {
        // 为了省事，这里直接回调成功
        ApiHelper.getWanAndroidApi()
                .getUnCollect(id)
                .compose(Transformer.switchSchedulers())
                .subscribe(new DataObserver<UnCollectModel>() {
                    @Override
                    protected void onError(String errorMsg) {
                        getListener().onUnCollectFail(errorMsg);
                    }

                    @Override
                    protected void onSuccess(UnCollectModel data) {
                        getListener().onUnCollectSucceed(data);
                    }
                });
    }
}
