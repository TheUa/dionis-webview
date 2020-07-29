

package the.ua.dionis_view;

import android.webkit.ValueCallback;

public interface JsAccessEntrace extends the.ua.dionis_view.QuickCallJs {


    void callJs(String js, ValueCallback<String> callback);

    void callJs(String js);


}
