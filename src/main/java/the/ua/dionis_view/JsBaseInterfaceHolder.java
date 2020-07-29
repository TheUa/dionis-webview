

package the.ua.dionis_view;

import android.os.Build;
import android.webkit.JavascriptInterface;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public abstract class JsBaseInterfaceHolder implements the.ua.dionis_view.JsInterfaceHolder {

    private the.ua.dionis_view.DionisView.SecurityType mSecurityType;
    private WebCreator mWebCreator;

    protected JsBaseInterfaceHolder(WebCreator webCreator, the.ua.dionis_view.DionisView.SecurityType securityType) {
        this.mSecurityType = securityType;
        this.mWebCreator = webCreator;
    }

    @Override
    public boolean checkObject(Object v) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            return true;
        }
        if (mWebCreator.getWebViewType() == the.ua.dionis_view.AgentWebConfig.WEBVIEW_AGENTWEB_SAFE_TYPE) {
            return true;
        }
        boolean tag = false;
        Class clazz = v.getClass();
        Method[] mMethods = clazz.getMethods();
        for (Method mMethod : mMethods) {
            Annotation[] mAnnotations = mMethod.getAnnotations();
            for (Annotation mAnnotation : mAnnotations) {
                if (mAnnotation instanceof JavascriptInterface) {
                    tag = true;
                    break;
                }
            }
            if (tag) {
                break;
            }
        }
        return tag;
    }

    protected boolean checkSecurity() {
        if (mSecurityType == the.ua.dionis_view.DionisView.SecurityType.STRICT_CHECK) {
            mWebCreator.getWebViewType();
        }
        return true;
    }

}
