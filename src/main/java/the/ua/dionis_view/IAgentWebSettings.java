

package the.ua.dionis_view;

import android.webkit.WebView;


public interface IAgentWebSettings<T extends android.webkit.WebSettings> {

    the.ua.dionis_view.IAgentWebSettings toSetting(WebView webView);

    T getWebSettings();

}
