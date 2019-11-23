package cn.hujw.wanandroid.ui.mvp.contract;

import java.util.List;

import cn.hujw.wanandroid.mvp.IMvpView;
import cn.hujw.wanandroid.ui.mvp.model.WeChatTabModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/21 0021
 */
public class WeChatContract {

    public interface View extends IMvpView {

        void getWeChatTabSuccess(List<WeChatTabModel> data);

        void getWeChatTabError(String msg);

    }

    public interface Presenter {

        void getWeChatTab();

    }
}
