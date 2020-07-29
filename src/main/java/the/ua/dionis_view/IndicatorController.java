

package the.ua.dionis_view;

import android.webkit.WebView;


public interface IndicatorController {

    void progress(WebView v, int newProgress);

    BaseIndicatorSpec offerIndicator();

    void showIndicator();

    void setProgress(int newProgress);

    void finish();
}
