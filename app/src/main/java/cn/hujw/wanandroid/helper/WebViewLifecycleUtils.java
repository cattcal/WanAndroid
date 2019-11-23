package cn.hujw.wanandroid.helper;

import android.os.Build;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * @author: hujw
 * @date: 2019/8/19
 * @description: WebView 生命周期优化工具
 * @email: hujw_android@163.com
 */
public final class WebViewLifecycleUtils {

    public static void init(WebView webView) {
        // 不显示滚动条
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);

        WebSettings settings = webView.getSettings();
        // 允许文件访问
        settings.setAllowFileAccess(true);
        // 开启 JavaScript
        settings.setJavaScriptEnabled(true);
        // 允许网页定位
        settings.setGeolocationEnabled(true);
        // 允许保存密码
        settings.setSavePassword(true);
        // 加快网页加载完成的速度，等页面完成再加载图片
        settings.setLoadsImagesAutomatically(true);
        // 本地 DOM 存储（解决加载某些网页出现白板现象）
        settings.setDomStorageEnabled(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // 解决 Android 5.0 上 WebView 默认不允许加载 Http 与 Https 混合内容
            settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
    }

    public static void onResume(WebView webView) {
        webView.onResume();
        webView.resumeTimers();
    }

    public static void onPause(WebView webView) {
        webView.onPause();
        webView.pauseTimers();
    }

    public static void onDestroy(WebView webView) {
        ((ViewGroup) webView.getParent()).removeView(webView);
        //清除历史记录
        webView.clearHistory();
        //停止加载
        webView.stopLoading();
        //加载一个空白页
        webView.loadUrl("about:blank");
        webView.setWebChromeClient(null);
        webView.setWebViewClient(null);
        //移除WebView所有的View对象
        webView.removeAllViews();
        //销毁此的WebView的内部状态
        webView.destroy();
    }
}
