package cn.hujw.wanandroid.http;

import android.app.Application;

import com.allen.library.RxHttpUtils;
import com.allen.library.config.OkHttpConfig;
import com.allen.library.cookie.store.SPCookieStore;
import com.allen.library.interfaces.BuildHeadersListener;
import com.allen.library.manage.RxUrlManager;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import cn.hujw.wanandroid.other.AppConfig;
import okhttp3.OkHttpClient;

/**
 * 描述：RxHttpUtils初始化配置管理类
 *
 * @author hujw
 * @date 2019/9/23 0023
 */
public final class RxHttpUtilsManager {

    public static void init(Application application) {

        OkHttpClient okHttpClient = new OkHttpConfig
                .Builder(application.getApplicationContext())
                //全局的请求头信息
                .setHeaders(() -> {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("appVersion", AppConfig.getVersionName());
                    hashMap.put("client", "android");
                    hashMap.put("token", "your_token");
                    hashMap.put("other_header", URLEncoder.encode("中文需要转码"));
                    return hashMap;
                })
                //开启缓存策略(默认false)
                //1、在有网络的时候，先去读缓存，缓存时间到了，再去访问网络获取数据；
                //2、在没有网络的时候，去读缓存中的数据。
                .setCache(true)
                .setHasNetCacheTime(10)//默认有网络时候缓存60秒
                //.setNoNetCacheTime(3600)//默认有网络时候缓存3600秒
                //全局持久话cookie,保存到内存（new MemoryCookieStore()）或者保存到本地（new SPCookieStore(this)）
                //不设置的话，默认不对cookie做处理
                .setCookieType(new SPCookieStore(application.getApplicationContext()))
                //可以添加自己的拦截器(比如使用自己熟悉三方的缓存库等等)
                //.setAddInterceptor(null)
                //全局ssl证书认证
                //1、信任所有证书,不安全有风险（默认信任所有证书）
                //.setSslSocketFactory()
                //2、使用预埋证书，校验服务端证书（自签名证书）
                //.setSslSocketFactory(cerInputStream)
                //3、使用bks证书和密码管理客户端证书（双向认证），使用预埋证书，校验服务端证书（自签名证书）
                //.setSslSocketFactory(bksInputStream,"123456",cerInputStream)
                //全局超时配置
                .setReadTimeout(10)
                //全局超时配置
                .setWriteTimeout(10)
                //全局超时配置
                .setConnectTimeout(10)
                //全局是否打开请求log日志
                .setDebug(true)
                .build();

        //一个项目多url的配置方法(这种写法的前提是事先已经知道所有的baseUrl了)
        RxUrlManager.getInstance().setMultipleUrl(AppUrlConfig.getAllUrl());
        //如果是动态从服务器获取的baseUrl的话也可以添加进来
        //key是对url做区分使用，value就是服务器下发的baseUrl（baseUrl必须以"xxx/"斜杠结尾，retrofit的要求）
        //RxUrlManager.getInstance().addUrl("urlKey", "urlValue");


        RxHttpUtils
                .getInstance()
                .init(application)
                .config()
                //使用自定义factory的用法
                //.setCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //.setConverterFactory(ScalarsConverterFactory.create(), GsonConverterFactory.create(GsonAdapter.buildGson()))
                //配置全局baseUrl
                .setBaseUrl(AppUrlConfig.BASE_URL)
                //开启全局配置
                .setOkClient(okHttpClient);
    }


}
