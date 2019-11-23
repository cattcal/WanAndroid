package cn.hujw.wanandroid.helper;

import android.os.SystemClock;

/**
 * @author: hujw
 * @date: 2019/8/19
 * @description: 防双击判断工具类
 * @email: hujw_android@163.com
 */
public final class DoubleClickHelper {

    /** 数组的长度为2代表只记录双击操作 */
    private static final long[] TIME_ARRAY = new long[2];

    /**
     * 是否在短时间内进行了双击操作
     */
    public static boolean isOnDoubleClick() {
        // 默认间隔时长
        return isOnDoubleClick(1500);
    }

    /**
     * 是否在短时间内进行了双击操作
     */
    public static boolean isOnDoubleClick(int time) {
        System.arraycopy(TIME_ARRAY, 1, TIME_ARRAY, 0, TIME_ARRAY.length - 1);
        TIME_ARRAY[TIME_ARRAY.length - 1] = SystemClock.uptimeMillis();
        return TIME_ARRAY[0] >= (SystemClock.uptimeMillis() - time);
    }
}
