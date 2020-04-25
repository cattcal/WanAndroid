package cn.hujw.wanandroid.module.mine.activity;

import android.os.Bundle;
import android.view.View;

import com.allen.library.cookie.store.SPCookieStore;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.hujw.base.BaseDialog;
import cn.hujw.image.ImageLoader;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.common.MyApplication;
import cn.hujw.wanandroid.helper.ActivityStackManager;
import cn.hujw.wanandroid.helper.CacheDataManager;
import cn.hujw.wanandroid.module.login.activity.LoginActivity;
import cn.hujw.wanandroid.module.mine.mvp.contract.LogoutContract;
import cn.hujw.wanandroid.module.mine.mvp.modle.UserLogoutModel;
import cn.hujw.wanandroid.module.mine.mvp.presenter.LogoutPresenter;
import cn.hujw.wanandroid.mvp.MvpActivity;
import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.wanandroid.ui.activity.WebActivity;
import cn.hujw.wanandroid.ui.dialog.MessageDialog;
import cn.hujw.wanandroid.utils.UserManager;
import cn.hujw.widget.layout.SettingBar;

/**
 * 描述：设置界面
 *
 * @author hujw
 * @date 2019/11/25 0025
 */
public class SettingActivity extends MvpActivity implements LogoutContract.View {

    @MvpInject
    LogoutPresenter mPresenter;

    @BindView(R.id.sb_setting_cache)
    SettingBar mCleanCacheView;

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
        // 获取应用缓存大小
        mCleanCacheView.setRightText(CacheDataManager.getTotalCacheSize(this));

        cookieStore = new SPCookieStore(MyApplication.getContext());

    }

    @OnClick({R.id.sb_setting_about_us, R.id.sb_setting_exit, R.id.sb_setting_update, R.id.sb_setting_cache, R.id.sb_setting_agreement})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sb_setting_about_us:
                break;
            case R.id.sb_setting_exit:
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
            case R.id.sb_setting_update:
                break;
            case R.id.sb_setting_cache:
                new MessageDialog.Builder(getActivity())
                        .setMessage("你确定清除缓存吗？")
                        .setListener(new MessageDialog.OnListener() {
                            @Override
                            public void onConfirm(BaseDialog dialog) {
                                // 清空缓存

                                ImageLoader.clear(getContext());
                                CacheDataManager.clearAllCache(getContext());
                                // 重新获取应用缓存大小
                                mCleanCacheView.setRightText(CacheDataManager.getTotalCacheSize(getContext()));
                            }

                            @Override
                            public void onCancel(BaseDialog dialog) {

                            }
                        }).show();
                break;
            case R.id.sb_setting_agreement:
                break;

        }
    }

    @Override
    public void getLogoutSuccess(UserLogoutModel data) {
        if (cookieStore != null) {
            cookieStore.removeAllCookie();
        }

        UserManager.getInstance().logout();

        startActivity(LoginActivity.class);
        // 进行内存优化，销毁掉所有的界面
        ActivityStackManager.getInstance().finishAllActivities(LoginActivity.class);
    }

    @Override
    public void getLogoutError(String msg) {
        toast(msg);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

}
