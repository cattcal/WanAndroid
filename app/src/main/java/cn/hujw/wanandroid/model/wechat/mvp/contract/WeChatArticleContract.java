package cn.hujw.wanandroid.model.wechat.mvp.contract;

import cn.hujw.wanandroid.mvp.IMvpView;
import cn.hujw.wanandroid.model.wechat.mvp.modle.WeChatArticleModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/21 0021
 */
public class WeChatArticleContract {

    public interface View extends IMvpView {

        void getWeChatArticleSuccess(WeChatArticleModel data);

        void getWeChatArticleError(String msg);
    }

    public interface Presenter {

        void getWeChatArticle(int id, int num);
    }
}
