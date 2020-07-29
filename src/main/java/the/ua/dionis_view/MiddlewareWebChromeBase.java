

package the.ua.dionis_view;

import android.webkit.WebChromeClient;


public class MiddlewareWebChromeBase extends WebChromeClientDelegate {

    private the.ua.dionis_view.MiddlewareWebChromeBase mMiddlewareWebChromeBase;


    protected MiddlewareWebChromeBase(WebChromeClient webChromeClient) {
        super(webChromeClient);
    }

    public MiddlewareWebChromeBase() {
        super(null);
    }


//    public MiddlewareWebChromeBase() {
//        super(null, null);
//    }

//    protected MiddlewareWebChromeBase(WebChromeClient webChromeClient) {
//        super(webChromeClient);
//    }

//    protected MiddlewareWebChromeBase() {
//        super(null);
//    }

    @Override
    final void setDelegate(WebChromeClient delegate) {
        super.setDelegate(delegate);
    }

    final the.ua.dionis_view.MiddlewareWebChromeBase enq(the.ua.dionis_view.MiddlewareWebChromeBase middlewareWebChromeBase) {
        setDelegate(middlewareWebChromeBase);
        this.mMiddlewareWebChromeBase = middlewareWebChromeBase;
        return this.mMiddlewareWebChromeBase;
    }


    final the.ua.dionis_view.MiddlewareWebChromeBase next() {
        return this.mMiddlewareWebChromeBase;
    }

}
