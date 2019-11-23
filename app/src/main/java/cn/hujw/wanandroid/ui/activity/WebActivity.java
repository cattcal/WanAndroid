package cn.hujw.wanandroid.ui.activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import butterknife.BindView;
import cn.hujw.wanandroid.R;
import cn.hujw.wanandroid.common.MyActivity;
import cn.hujw.wanandroid.helper.WebViewLifecycleUtils;
import cn.hujw.wanandroid.other.IntentKey;

/**
 * @author: hujw
 * @date: 2019/8/22
 * @description: 浏览器界面
 * @email: hujw_android@163.com
 */
public final class WebActivity extends MyActivity {

    public static void start(Context context, String url) {
        if (url == null || "".equals(url)) {
            return;
        }
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra(IntentKey.URL, url);
        context.startActivity(intent);
    }

    @BindView(R.id.pb_web_progress)
    ProgressBar mProgressBar;
    @BindView(R.id.wv_web_view)
    WebView mWebView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_web;
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void initView() {
        WebViewLifecycleUtils.init(mWebView);
    }

    @Override
    protected void initData() {
        mWebView.setWebViewClient(new MyWebViewClient());
        mWebView.setWebChromeClient(new MyWebChromeClient());

        String url = getIntent().getStringExtra(IntentKey.URL);
        mWebView.loadUrl(url);
    }

    @Override
    public void onLeftClick(View v) {
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {
            // 后退网页并且拦截该事件
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onResume() {
        WebViewLifecycleUtils.onResume(mWebView);
        super.onResume();
    }

    @Override
    protected void onPause() {
        WebViewLifecycleUtils.onPause(mWebView);
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        WebViewLifecycleUtils.onDestroy(mWebView);
        super.onDestroy();
    }

    private class MyWebViewClient extends WebViewClient {

        /**
         * 同名 API 兼容
         */
        @TargetApi(Build.VERSION_CODES.M)
        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            if (request.isForMainFrame()) {
                onReceivedError(view,
                        error.getErrorCode(), error.getDescription().toString(),
                        request.getUrl().toString());
            }
        }

        /**
         * 网页加载错误时回调，这个方法会在 onPageFinished 之前调用
         */
        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            // 这里为什么要用延迟呢？因为加载出错之后会先调用 onReceivedError 再调用 onPageFinished
            post(WebActivity.this::showError);
        }

        /**
         * 开始加载网页
         */
        @Override
        public void onPageStarted(final WebView view, final String url, Bitmap favicon) {
            mProgressBar.setVisibility(View.VISIBLE);
        }

        /**
         * 完成加载网页
         */
        @Override
        public void onPageFinished(WebView view, String url) {
            mProgressBar.setVisibility(View.GONE);
            showComplete();
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            // 注意一定要去除这行代码，否则设置无效。
            //super.onReceivedSslError(view, handler, error);
            // Android默认的处理方式
            //handler.cancel();
            // 接受所有网站的证书
            handler.proceed();
        }

        /**
         * 同名 API 兼容
         */
        @TargetApi(Build.VERSION_CODES.N)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return shouldOverrideUrlLoading(view, request.getUrl().toString());
        }

        /**
         * 跳转到其他链接
         */
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, final String url) {
            String scheme = Uri.parse(url).getScheme();
            if (scheme != null) {
                scheme = scheme.toLowerCase();
            }
            if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                mWebView.loadUrl(url);
            }
            // 已经处理该链接请求
            return true;
        }
    }

    private class MyWebChromeClient extends WebChromeClient {

        /**
         * 收到网页标题
         */
        @Override
        public void onReceivedTitle(WebView view, String title) {
            if (title != null) {
                setTitle(title);
            }
        }

        /**
         * 收到加载进度变化
         */
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            mProgressBar.setProgress(newProgress);
        }
    }
}
