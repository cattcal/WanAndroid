package cn.hujw.wanandroid.http;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：AppUrl常量
 *
 * @author hujw
 * @date 2019/9/23 0023
 */
public final class AppUrlConfig {
    public static String BASE_KET = "wanandroid_api";
    public static String BASE_URL = "https://www.wanandroid.com/";

    public static String BASE_GANK_URL = "http://gank.io/";
    public static String BASE_GANK_KET = "gank_api";


    public static Map<String, String> getAllUrl() {
        Map<String, String> map = new HashMap<>();
        map.put(BASE_KET, BASE_URL);
        map.put(BASE_GANK_KET, BASE_GANK_URL);
        return map;
    }

}
