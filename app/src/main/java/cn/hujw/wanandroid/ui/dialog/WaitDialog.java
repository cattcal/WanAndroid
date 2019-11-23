package cn.hujw.wanandroid.ui.dialog;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.StringRes;
import androidx.fragment.app.FragmentActivity;

import cn.hujw.base.BaseDialog;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.common.MyDialogFragment;

/**
 * @author: hujw
 * @date: 2019/9/10
 * @description: 等待加载对话框
 * @email: hujw_android@163.com
 */
public final class WaitDialog {

    public static final class Builder
            extends MyDialogFragment.Builder<Builder> {

        private final TextView mMessageView;

        public Builder(FragmentActivity activity) {
            super(activity);
            setContentView(R.layout.dialog_wait);
            setAnimStyle(BaseDialog.AnimStyle.TOAST);
            setBackgroundDimEnabled(false);
            setCancelable(false);

            mMessageView = findViewById(R.id.tv_wait_message);
        }

        public Builder setMessage(@StringRes int id) {
            return setMessage(getString(id));
        }
        public Builder setMessage(CharSequence text) {
            mMessageView.setText(text);
            mMessageView.setVisibility(text == null ? View.GONE : View.VISIBLE);
            return this;
        }
    }
}
