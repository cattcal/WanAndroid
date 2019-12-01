package cn.hujw.wanandroid.utils;

import androidx.annotation.NonNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 描述：时间工具类
 *
 * @author hujw
 * @date 2019/11/27 0027
 */
public final class TimeUtils {

    private static final ThreadLocal<SimpleDateFormat> SDF_THREAD_LOCAL = new ThreadLocal<>();


    private static SimpleDateFormat getDefaultFormat() {
        return getDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    private static SimpleDateFormat getDateFormat(String pattern) {
        SimpleDateFormat simpleDateFormat = SDF_THREAD_LOCAL.get();
        if (simpleDateFormat == null) {
            simpleDateFormat = new SimpleDateFormat(pattern, Locale.getDefault());
            SDF_THREAD_LOCAL.set(simpleDateFormat);
        } else {
            simpleDateFormat.applyPattern(pattern);
        }
        return simpleDateFormat;
    }

    private TimeUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 将时间戳转为时间字符串
     */
    public static String millis2String(final long millis) {
        return millis2String(millis, getDefaultFormat());
    }

    public static String millis2String(long millis, @NonNull final String pattern) {
        return millis2String(millis, getDateFormat(pattern));
    }

    public static String millis2String(final long millis, @NonNull final DateFormat format) {
        return format.format(new Date(millis));
    }

    /**
     * 将时间字符串转为时间戳
     */
    public static long string2Millis(final String time) {
        return string2Millis(time, getDefaultFormat());
    }

    public static long string2Millis(final String time, @NonNull final String pattern) {
        return string2Millis(time, getDateFormat(pattern));
    }

    public static long string2Millis(final String time, @NonNull final DateFormat format) {
        try {
            return format.parse(time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 将时间字符串转为 Date 类型
     */
    public static Date string2Date(final String time) {
        return string2Date(time, getDefaultFormat());
    }

    public static Date string2Date(final String time, @NonNull final String pattern) {
        return string2Date(time, getDateFormat(pattern));
    }

    public static Date string2Date(final String time, @NonNull final DateFormat format) {
        try {
            return format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将 Date 类型转为时间字符串
     */
    public static String date2String(final Date date) {
        return date2String(date, getDefaultFormat());
    }

    public static String date2String(final Date date, @NonNull final String pattern) {
        return getDateFormat(pattern).format(date);
    }

    public static String date2String(final Date date, @NonNull final DateFormat format) {
        return format.format(date);
    }

    /**
     * 将 Date 类型转为时间戳
     */
    public static long date2Millis(final Date date) {
        return date.getTime();
    }

    /**
     * 将时间戳转为 Date 类型
     */
    public static Date millis2Date(final long millis) {
        return new Date(millis);
    }

    /**
     * 获取当前毫秒时间戳
     */
    public static long getNowMills() {
        return System.currentTimeMillis();
    }

    /**
     * 获取当前时间字符串
     */
    public static String getNowString() {
        return millis2String(System.currentTimeMillis(), getDefaultFormat());
    }

    public static String getNowString(@NonNull final DateFormat format) {
        return millis2String(System.currentTimeMillis(), format);
    }

    /**
     * 获取当前 Date
     */
    public static Date getNowDate() {
        return new Date();
    }

    /**
     * 获取中式星期
     */
    public static String getChineseWeek(final String time) {
        return getChineseWeek(string2Date(time, getDefaultFormat()));
    }

    public static String getChineseWeek(final String time, @NonNull final DateFormat format) {
        return getChineseWeek(string2Date(time, format));
    }

    public static String getChineseWeek(final Date date) {
        return new SimpleDateFormat("E", Locale.CHINA).format(date);
    }

    public static String getChineseWeek(final long millis) {
        return getChineseWeek(new Date(millis));
    }

}
