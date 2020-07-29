

package the.ua.dionis_view;

import android.webkit.WebView;
import android.widget.FrameLayout;

public interface WebCreator extends the.ua.dionis_view.IWebIndicator {
    the.ua.dionis_view.WebCreator create();

    WebView getWebView();

    FrameLayout getWebParentLayout();

    int getWebViewType();
}
