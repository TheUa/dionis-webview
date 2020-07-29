

package the.ua.dionis_view;

import android.util.ArrayMap;
import android.webkit.WebView;


public class WebSecurityControllerImpl implements WebSecurityController<the.ua.dionis_view.WebSecurityCheckLogic> {

	private WebView mWebView;
	private ArrayMap<String, Object> mMap;
	private the.ua.dionis_view.DionisView.SecurityType mSecurityType;

	public WebSecurityControllerImpl(WebView view, ArrayMap<String, Object> map, the.ua.dionis_view.DionisView.SecurityType securityType) {
		this.mWebView = view;
		this.mMap = map;
		this.mSecurityType = securityType;
	}

	@Override
	public void check(the.ua.dionis_view.WebSecurityCheckLogic webSecurityCheckLogic) {
		webSecurityCheckLogic.dealHoneyComb(mWebView);
		if (mMap != null && mSecurityType == the.ua.dionis_view.DionisView.SecurityType.STRICT_CHECK && !mMap.isEmpty()) {
			webSecurityCheckLogic.dealJsInterface(mMap, mSecurityType);
		}
	}
}
