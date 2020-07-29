

package the.ua.dionis_view;

import android.webkit.WebView;

public class DefaultWebLifeCycleImpl implements the.ua.dionis_view.WebLifeCycle {
    private WebView mWebView;
    DefaultWebLifeCycleImpl(WebView webView) {
        this.mWebView = webView;
    }

    @Override
    public void onResume() {
        if (this.mWebView != null) {
            this.mWebView.onResume();
            this.mWebView.resumeTimers();
        }
    }

    @Override
    public void onPause() {
        if (this.mWebView != null) {
            this.mWebView.onPause();
            this.mWebView.pauseTimers();
        }
    }

    @Override
    public void onDestroy() {
        if(this.mWebView!=null){
            this.mWebView.resumeTimers();
        }
        the.ua.dionis_view.AgentWebUtils.clearWebView(this.mWebView);
    }
}
