package cn.hujw.wanandroid.ui.mvp.presenter;

import java.util.List;

import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.mvp.MvpPresenter;
import cn.hujw.wanandroid.ui.mvp.contract.WeChatContract;
import cn.hujw.wanandroid.ui.mvp.listener.WeChatOnListener;
import cn.hujw.wanandroid.ui.mvp.model.WeChatTabModel;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/11/21 0021
 */
public class WeChatPresenter extends MvpPresenter<WeChatContract.View> implements WeChatContract.Presenter, WeChatOnListener {

    @MvpInject
    WeChatTabModel weChatTabModel;



    @Override
    public void getWeChatTab() {
        weChatTabModel.setListener(this);
        weChatTabModel.getWeChatTab();
    }

    @Override
    public void onWeChatTabSucceed(List<WeChatTabModel> data) {
        getView().getWeChatTabSuccess(data);
    }

    @Override
    public void onWeChatTabFail(String msg) {
        getView().getWeChatTabError(msg);
    }


}
