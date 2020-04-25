package cn.hujw.wanandroid.module.home.mvp.modle;

import com.allen.library.interceptor.Transformer;
import com.allen.library.observer.DataObserver;

import cn.hujw.wanandroid.http.ApiHelper;
import cn.hujw.wanandroid.module.home.mvp.listener.ShareArticleOnListener;
import cn.hujw.wanandroid.mvp.MvpModel;

public class ShareArticleModel extends MvpModel<ShareArticleOnListener> {

    public void searchArticle(String title, String link) {
        // 为了省事，这里直接回调成功
        ApiHelper.getWanAndroidApi()
                .shareArticle(title,link)
                .compose(Transformer.switchSchedulers())
                .subscribe(new DataObserver<ShareArticleModel>() {
                    @Override
                    protected void onError(String errorMsg) {
                        getListener().onShareArticleFail(errorMsg);
                    }

                    @Override
                    protected void onSuccess(ShareArticleModel data) {
                        getListener().onShareArticleSucceed(data);
                    }
                });
    }
}
