

package the.ua.dionis_view;

import android.util.ArrayMap;
import android.webkit.WebView;


public interface WebSecurityCheckLogic {
    void dealHoneyComb(WebView view);
    void dealJsInterface(ArrayMap<String, Object> objects, the.ua.dionis_view.DionisView.SecurityType securityType);
}
