

package the.ua.dionis_view;

import android.webkit.WebViewClient;

public class MiddlewareWebClientBase extends WebViewClientDelegate {
    private the.ua.dionis_view.MiddlewareWebClientBase mMiddleWrareWebClientBase;
    private static String TAG = the.ua.dionis_view.MiddlewareWebClientBase.class.getSimpleName();

//    MiddlewareWebClientBase(MiddlewareWebClientBase client) {
//        super(client);
//        this.mMiddleWrareWebClientBase = client;
//    }

    protected MiddlewareWebClientBase(WebViewClient client) {
        super(client);
    }



    protected MiddlewareWebClientBase() {
        super(null);
    }

    final the.ua.dionis_view.MiddlewareWebClientBase next() {
        return this.mMiddleWrareWebClientBase;
    }

    @Override
    final void setDelegate(WebViewClient delegate) {
        super.setDelegate(delegate);

    }

    final the.ua.dionis_view.MiddlewareWebClientBase enq(the.ua.dionis_view.MiddlewareWebClientBase middleWrareWebClientBase) {
        setDelegate(middleWrareWebClientBase);
        this.mMiddleWrareWebClientBase = middleWrareWebClientBase;
        return middleWrareWebClientBase;
    }

}
