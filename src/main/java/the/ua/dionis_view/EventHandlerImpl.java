

package the.ua.dionis_view;

import android.view.KeyEvent;
import android.webkit.WebView;

public class EventHandlerImpl implements the.ua.dionis_view.IEventHandler {
	private WebView mWebView;
	private the.ua.dionis_view.EventInterceptor mEventInterceptor;

	public static the.ua.dionis_view.EventHandlerImpl getInstantce(WebView view, the.ua.dionis_view.EventInterceptor eventInterceptor) {
		return new the.ua.dionis_view.EventHandlerImpl(view, eventInterceptor);
	}

	public EventHandlerImpl(WebView webView, the.ua.dionis_view.EventInterceptor eventInterceptor) {
		this.mWebView = webView;
		this.mEventInterceptor = eventInterceptor;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			return back();
		}
		return false;
	}

	@Override
	public boolean back() {
		if (this.mEventInterceptor != null && this.mEventInterceptor.event()) {
			return true;
		}
		if (mWebView != null && mWebView.canGoBack()) {
			mWebView.goBack();
			return true;
		}
		return false;
	}

}
