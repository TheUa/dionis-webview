

package the.ua.dionis_view;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import android.webkit.*;


public abstract class AbsAgentWebSettings implements the.ua.dionis_view.IAgentWebSettings, WebListenerManager {
    private WebSettings mWebSettings;
    private static final String TAG = the.ua.dionis_view.AbsAgentWebSettings.class.getSimpleName();
    public static final String USERAGENT_UC = " UCBrowser/11.6.4.950 ";
    public static final String USERAGENT_ = "Mozilla/5.0 (Linux; Android 6.0.1; SM-G925I) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Mobile Safari/537.36";
    public static final String USERAGENT_QQ_BROWSER = " MQQBrowser/8.0 ";
    public static final String USERAGENT_AGENTWEB = " " + the.ua.dionis_view.AgentWebConfig.AGENTWEB_VERSION + " ";
    protected the.ua.dionis_view.DionisView mDionisView;

    public static the.ua.dionis_view.AbsAgentWebSettings getInstance() {
        return new AgentWebSettingsImpl();
    }

    public AbsAgentWebSettings() {
    }

    final void bindAgentWeb(the.ua.dionis_view.DionisView dionisView) {
        this.mDionisView = dionisView;
        this.bindAgentWebSupport(dionisView);
    }

    protected abstract void bindAgentWebSupport(the.ua.dionis_view.DionisView dionisView);

    @Override
    public the.ua.dionis_view.IAgentWebSettings toSetting(WebView webView) {
        settings(webView);
        return this;
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void settings(WebView webView) {
        mWebSettings = webView.getSettings();
        mWebSettings.setJavaScriptEnabled(true);
        mWebSettings.setSupportZoom(true);
        mWebSettings.setBuiltInZoomControls(false);
        mWebSettings.setSavePassword(false);
        if (the.ua.dionis_view.AgentWebUtils.checkNetwork(webView.getContext())) {
            mWebSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        } else {
            mWebSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        }
        mWebSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        mWebSettings.setTextZoom(100);
        mWebSettings.setDatabaseEnabled(true);
        mWebSettings.setAppCacheEnabled(true);
        mWebSettings.setLoadsImagesAutomatically(true);
        mWebSettings.setSupportMultipleWindows(true);
        mWebSettings.setBlockNetworkImage(false);
        mWebSettings.setAllowFileAccess(true);
        mWebSettings.setAllowFileAccessFromFileURLs(false);
        mWebSettings.setAllowUniversalAccessFromFileURLs(false);
        mWebSettings.setSupportMultipleWindows(true);
        mWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);

        mWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        mWebSettings.setLoadWithOverviewMode(false);
        mWebSettings.setUseWideViewPort(false);
        mWebSettings.setDomStorageEnabled(true);
        mWebSettings.setNeedInitialFocus(true);
        mWebSettings.setDefaultTextEncodingName("utf-8");
        mWebSettings.setDefaultFontSize(16);
        mWebSettings.setMinimumFontSize(12);
        mWebSettings.setGeolocationEnabled(true);
        String dir = the.ua.dionis_view.AgentWebConfig.getCachePath(webView.getContext());
        LogUtils.i(TAG, "dir:" + dir + "   appcache:" + the.ua.dionis_view.AgentWebConfig.getCachePath(webView.getContext()));
        mWebSettings.setGeolocationDatabasePath(dir);
        mWebSettings.setDatabasePath(dir);
        mWebSettings.setAppCachePath(dir);
        mWebSettings.setAppCacheMaxSize(Long.MAX_VALUE);
        mWebSettings.setUserAgentString(getWebSettings()
                .getUserAgentString()
                .concat(USERAGENT_AGENTWEB)
                .concat(USERAGENT_)
        );
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            Context context = webView.getContext();
            String processName = the.ua.dionis_view.ProcessUtils.getCurrentProcessName(context);
            if (!context.getApplicationContext().getPackageName().equals(processName)) {
                WebView.setDataDirectorySuffix(processName);
            }
        }
    }

    @Override
    public WebSettings getWebSettings() {
        return mWebSettings;
    }

    @Override
    public WebListenerManager setWebChromeClient(WebView webview, WebChromeClient webChromeClient) {
        webview.setWebChromeClient(webChromeClient);
        return this;
    }

    @Override
    public WebListenerManager setWebViewClient(WebView webView, WebViewClient webViewClient) {
        webView.setWebViewClient(webViewClient);
        return this;
    }

    @Override
    public WebListenerManager setDownloader(WebView webView, DownloadListener downloadListener) {
        webView.setDownloadListener(downloadListener);
        return this;
    }

}
