

package the.ua.dionis_view;

import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public interface WebListenerManager {
    the.ua.dionis_view.WebListenerManager setWebChromeClient(WebView webview, WebChromeClient webChromeClient);
    the.ua.dionis_view.WebListenerManager setWebViewClient(WebView webView, WebViewClient webViewClient);
    the.ua.dionis_view.WebListenerManager setDownloader(WebView webView, DownloadListener downloadListener);
}
