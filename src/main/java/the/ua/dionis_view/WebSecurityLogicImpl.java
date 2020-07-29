

package the.ua.dionis_view;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.ArrayMap;
import android.webkit.WebView;


public class WebSecurityLogicImpl implements the.ua.dionis_view.WebSecurityCheckLogic {
    private String TAG = this.getClass().getSimpleName();
    private int webviewType;

    public static the.ua.dionis_view.WebSecurityLogicImpl getInstance(int webViewType) {
        return new the.ua.dionis_view.WebSecurityLogicImpl(webViewType);
    }

    public WebSecurityLogicImpl(int webViewType) {
        this.webviewType = webViewType;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void dealHoneyComb(WebView view) {
    }

    @Override
    public void dealJsInterface(ArrayMap<String, Object> objects, the.ua.dionis_view.DionisView.SecurityType securityType) {
    }
}
