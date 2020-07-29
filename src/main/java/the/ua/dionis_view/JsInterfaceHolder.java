

package the.ua.dionis_view;

import java.util.Map;

public interface JsInterfaceHolder {

    the.ua.dionis_view.JsInterfaceHolder addJavaObjects(Map<String, Object> maps);

    the.ua.dionis_view.JsInterfaceHolder addJavaObject(String k, Object v);

    boolean checkObject(Object v);

}
