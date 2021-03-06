package cn.hujw.wanandroid.module.login.activity;

import android.view.View;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import com.gyf.immersionbar.ImmersionBar;

import butterknife.BindView;
import butterknife.OnClick;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.helper.InputTextHelper;
import cn.hujw.wanandroid.module.login.mvp.contract.RegisterContract;
import cn.hujw.wanandroid.module.login.mvp.model.UserRegisterModel;
import cn.hujw.wanandroid.module.login.mvp.presenter.RegisterPresenter;
import cn.hujw.wanandroid.mvp.MvpActivity;
import cn.hujw.wanandroid.mvp.MvpInject;
import cn.hujw.widget.view.RegexEditText;

/**
 * @author: hujw
 * @date: 2019/8/21
 * @description: 注册界面
 * @email: hujw_android@163.com
 */
public class RegisterActivity extends MvpActivity implements RegisterContract.View {

    @MvpInject
    RegisterPresenter mPresenter;

    @BindView(R.id.et_register_user_name)
    RegexEditText mUserNameView;


    @BindView(R.id.et_register_password1)
    AppCompatEditText mPasswordView1;
    @BindView(R.id.et_register_password2)
    AppCompatEditText mPasswordView2;

    @BindView(R.id.btn_register_commit)
    AppCompatButton mCommitView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        InputTextHelper.with(this)
                .setMain(mCommitView)
                .addView(mUserNameView)
                .addView(mPasswordView1)
                .addView(mPasswordView2)
                .build();
    }

    @Override
    protected void initData() {

    }


    @Override
    protected ImmersionBar statusBarConfig() {
        return super.statusBarConfig().keyboardEnable(true);
    }

    @OnClick({R.id.btn_register_commit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_register_commit:
                // 提交注册
                if (!mPasswordView1.getText().toString().equals(mPasswordView2.getText().toString())) {
                    toast(R.string.register_password_input_error);
                } else {
                    mPresenter.getRegister(mUserNameView.getText() + "",
                            mPasswordView1.getText() + "",
                            mPasswordView2.getText() + "");

                }
                break;
            default:
                break;
        }
    }

    @Override
    public void getRegisterSuccess(UserRegisterModel data) {
        startActivity(LoginActivity.class);
    }

    @Override
    public void getRegisterError(String msg) {
        toast(msg);
    }
}
