

package the.ua.dionis_view;

import android.os.Handler;
import android.os.Looper;
import android.webkit.ValueCallback;
import android.webkit.WebView;


public class JsAccessEntraceImpl extends the.ua.dionis_view.BaseJsAccessEntrace {

    private WebView mWebView;
    private Handler mHandler = new Handler(Looper.getMainLooper());

    public static the.ua.dionis_view.JsAccessEntraceImpl getInstance(WebView webView) {
        return new the.ua.dionis_view.JsAccessEntraceImpl(webView);
    }

    private JsAccessEntraceImpl(WebView webView) {
        super(webView);
        this.mWebView = webView;
    }

    private void safeCallJs(final String s, final ValueCallback valueCallback) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                callJs(s, valueCallback);
            }
        });
    }

    @Override
    public void callJs(String params, final ValueCallback<String> callback) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            safeCallJs(params, callback);
            return;
        }
        super.callJs(params,callback);
    }


}
