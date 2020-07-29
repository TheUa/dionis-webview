

package the.ua.dionis_view;

import android.webkit.WebView;

import java.util.Map;
import java.util.Set;


public class JsInterfaceHolderImpl extends the.ua.dionis_view.JsBaseInterfaceHolder {

    private static final String TAG = the.ua.dionis_view.JsInterfaceHolderImpl.class.getSimpleName();
    private WebCreator mWebCreator;
    private the.ua.dionis_view.DionisView.SecurityType mSecurityType;
    private WebView mWebView;

    static the.ua.dionis_view.JsInterfaceHolderImpl getJsInterfaceHolder(WebCreator webCreator, the.ua.dionis_view.DionisView.SecurityType securityType) {
        return new the.ua.dionis_view.JsInterfaceHolderImpl(webCreator, securityType);
    }

    JsInterfaceHolderImpl(WebCreator webCreator, the.ua.dionis_view.DionisView.SecurityType securityType) {
        super(webCreator, securityType);
        this.mWebCreator = webCreator;
        this.mWebView = mWebCreator.getWebView();
        this.mSecurityType = securityType;
    }

    @Override
    public the.ua.dionis_view.JsInterfaceHolder addJavaObjects(Map<String, Object> maps) {
        if (!checkSecurity()) {
            LogUtils.e(TAG, "The injected object is not safe, give up injection");
            return this;
        }
        Set<Map.Entry<String, Object>> sets = maps.entrySet();
        for (Map.Entry<String, Object> mEntry : sets) {
            Object v = mEntry.getValue();
            boolean t = checkObject(v);
            if (!t) {
                throw new the.ua.dionis_view.JsInterfaceObjectException("This object has not offer method javascript to call ,please check addJavascriptInterface annotation was be added");
            } else {
                addJavaObjectDirect(mEntry.getKey(), v);
            }
        }
        return this;
    }

    @Override
    public the.ua.dionis_view.JsInterfaceHolder addJavaObject(String k, Object v) {
        if (!checkSecurity()) {
            return this;
        }
        boolean t = checkObject(v);
        if (!t) {
            throw new the.ua.dionis_view.JsInterfaceObjectException("this object has not offer method javascript to call , please check addJavascriptInterface annotation was be added");
        } else {
            addJavaObjectDirect(k, v);
        }
        return this;
    }

    private the.ua.dionis_view.JsInterfaceHolder addJavaObjectDirect(String k, Object v) {
        LogUtils.i(TAG, "k:" + k + "  v:" + v);
        this.mWebView.addJavascriptInterface(v, k);
        return this;
    }

}
