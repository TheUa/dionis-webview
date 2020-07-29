

package the.ua.dionis_view;

import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;

import java.util.Map;


public class UrlLoaderImpl implements IUrlLoader {
	private Handler mHandler = null;
	private WebView mWebView;
	private the.ua.dionis_view.HttpHeaders mHttpHeaders;
	public static final String TAG = the.ua.dionis_view.UrlLoaderImpl.class.getSimpleName();

	UrlLoaderImpl(WebView webView, the.ua.dionis_view.HttpHeaders httpHeaders) {
		this.mWebView = webView;
		if (this.mWebView == null) {
			new NullPointerException("webview cannot be null .");
		}
		this.mHttpHeaders = httpHeaders;
		if (this.mHttpHeaders == null) {
			this.mHttpHeaders = the.ua.dionis_view.HttpHeaders.create();
		}
		mHandler = new Handler(Looper.getMainLooper());
	}

	private void safeLoadUrl(final String url) {
		mHandler.post(new Runnable() {
			@Override
			public void run() {
				loadUrl(url);
			}
		});
	}

	private void safeReload() {
		mHandler.post(new Runnable() {
			@Override
			public void run() {
				reload();
			}
		});
	}

	@Override
	public void loadUrl(String url) {
		this.loadUrl(url, this.mHttpHeaders.getHeaders(url));
	}

	@Override
	public void loadUrl(final String url, final Map<String, String> headers) {
		if (!the.ua.dionis_view.AgentWebUtils.isUIThread()) {
			the.ua.dionis_view.AgentWebUtils.runInUiThread(new Runnable() {
				@Override
				public void run() {
					loadUrl(url, headers);
				}
			});
		}
		LogUtils.i(TAG, "loadUrl:" + url + " headers:" + headers);
		if (headers == null || headers.isEmpty()) {
			this.mWebView.loadUrl(url);
		} else {
			this.mWebView.loadUrl(url, headers);
		}
	}

	@Override
	public void reload() {
		if (!the.ua.dionis_view.AgentWebUtils.isUIThread()) {
			mHandler.post(new Runnable() {
				@Override
				public void run() {
					reload();
				}
			});
			return;
		}
		this.mWebView.reload();
	}

	@Override
	public void loadData(final String data, final String mimeType, final String encoding) {
		if (!the.ua.dionis_view.AgentWebUtils.isUIThread()) {
			mHandler.post(new Runnable() {
				@Override
				public void run() {
					loadData(data, mimeType, encoding);
				}
			});
			return;
		}
		this.mWebView.loadData(data, mimeType, encoding);
	}

	@Override
	public void stopLoading() {
		if (!the.ua.dionis_view.AgentWebUtils.isUIThread()) {
			mHandler.post(new Runnable() {
				@Override
				public void run() {
					stopLoading();
				}
			});
			return;
		}
		this.mWebView.stopLoading();
	}

	@Override
	public void loadDataWithBaseURL(final String baseUrl, final String data, final String mimeType, final String encoding, final String historyUrl) {
		if (!the.ua.dionis_view.AgentWebUtils.isUIThread()) {
			mHandler.post(new Runnable() {
				@Override
				public void run() {
					loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);
				}
			});
			return;
		}
		this.mWebView.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);
	}

	@Override
	public void postUrl(final String url, final byte[] postData) {
		if (!the.ua.dionis_view.AgentWebUtils.isUIThread()) {
			mHandler.post(new Runnable() {
				@Override
				public void run() {
					postUrl(url, postData);
				}
			});
			return;
		}
		this.mWebView.postUrl(url, postData);
	}

	@Override
	public the.ua.dionis_view.HttpHeaders getHttpHeaders() {
		return this.mHttpHeaders == null ? this.mHttpHeaders = the.ua.dionis_view.HttpHeaders.create() : this.mHttpHeaders;
	}
}
