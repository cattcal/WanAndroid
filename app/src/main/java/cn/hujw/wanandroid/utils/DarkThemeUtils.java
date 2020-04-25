package cn.hujw.wanandroid.utils;

import android.content.Context;
import android.content.res.Configuration;

/**
 * 黑暗模式判断类
 */
public final class DarkThemeUtils {

    public static boolean isDarkTheme(Context context) {
        int flag = context.getResources().getConfiguration().uiMode
                & Configuration.UI_MODE_NIGHT_MASK;
        return flag == Configuration.UI_MODE_NIGHT_YES;
    }
}
