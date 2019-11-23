package cn.hujw.wanandroid.ui.dialog;

import androidx.fragment.app.FragmentActivity;

import cn.hujw.base.BaseDialog;
import cn.hujw.wanandroid.R;

/**
 * 描述：
 *
 * @author hujw
 * @date 2019/9/23 0023
 */
public final class LoadingDialog {


    private static BaseDialog dialog;

    public static void showLoading(FragmentActivity activity) {
        dialog=new WaitDialog.Builder(activity)
                .setMessage(R.string.common_loading)
                .show();
    }

    public static void dismissLoading() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
