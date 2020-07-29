

package the.ua.dionis_view;

public interface PermissionInterceptor {
    boolean intercept(String url, String[] permissions, String action);
}
