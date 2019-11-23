package cn.hujw.wanandroid.http;

import com.allen.library.RxHttpUtils;

/**
 * 描述：Api帮助类
 *
 * @author hujw
 * @date 2019/9/23 0023
 */
public final class ApiHelper {

    /**
     * 玩安卓url相关接口
     * 注意：WanAndroidApi里边是baseUrl为玩安卓的所有请求,这样写就可以为不同的baseUrl创建不同的retrofit对象
     *
     * @return
     */
    public static WanAndroidApi getWanAndroidApi() {
        return RxHttpUtils.createApi(AppUrlConfig.BASE_KET, AppUrlConfig.BASE_URL, WanAndroidApi.class);
    }
}
