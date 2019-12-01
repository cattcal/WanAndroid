package cn.hujw.wanandroid.ui.mvp.contract;

import cn.hujw.wanandroid.mvp.IMvpView;
import cn.hujw.wanandroid.ui.mvp.model.CollectModel;
import cn.hujw.wanandroid.ui.mvp.model.UnCollectModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/27 0027
 */
public class CollectContract {
    public interface View extends IMvpView {


        void getCollectSuccess(CollectModel data);

        void getCollectError(String msg);

        void getUnCollectSuccess(UnCollectModel data);

        void getUnCollectError(String msg);
    }

    public interface Presenter {


        void getCollect(int id);

        void getUnCollect(int id);

    }

}
