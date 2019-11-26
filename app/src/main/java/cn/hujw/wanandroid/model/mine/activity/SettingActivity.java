package cn.hujw.wanandroid.model.mine.activity;

import android.view.View;

import com.allen.library.cookie.store.SPCookieStore;

import butterknife.OnClick;
import cn.hujw.base.BaseDialog;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.helper.ActivityStackManager;
import cn.hujw.wanandroid.model.login.activity.LoginActivity;
import cn.hujw.wanandroid.model.mine.mvp.contract.LogoutContract;
import cn.hujw.wanandroid.model.mine.mvp.modle.UserLogoutModel;
import cn.hujw.wanandroid.model.mine.mvp.presenter.LogoutPresenter;
import cn.hujw.wanandroid.mvp.MvpActivity;
import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.ui.dialog.MessageDialog;

/**
 * 描述：设置界面
 *
 * @author hujw
 * @date 2019/11/25 0025
 */
public class SettingActivity extends MvpActivity implements LogoutContract.View {

    @MvpInject
    LogoutPresenter mPresenter;
    private SPCookieStore cookieStore;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

        cookieStore = new SPCookieStore(getContext());

    }

    @OnClick({R.id.sb_setting_about_us, R.id.tv_setting_logout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sb_setting_about_us:
                break;
            case R.id.tv_setting_logout:
                new MessageDialog.Builder(getActivity())
                        .setMessage("你确定要退出吗？")
                        .setListener(new MessageDialog.OnListener() {
                            @Override
                            public void onConfirm(BaseDialog dialog) {
                                mPresenter.getLogout();
                            }

                            @Override
                            public void onCancel(BaseDialog dialog) {

                            }
                        }).show();
                break;
        }
    }

    @Override
    public void getLogoutSuccess(UserLogoutModel data) {
        if (cookieStore != null) {
            cookieStore.removeAllCookie();
        }
        startActivity(LoginActivity.class);
        // 进行内存优化，销毁掉所有的界面
        ActivityStackManager.getInstance().finishAllActivities(LoginActivity.class);
    }

    @Override
    public void getLogoutError(String msg) {
        toast(msg);
    }
}
