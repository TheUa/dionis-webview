

package the.ua.dionis_view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.webkit.DownloadListener;
import android.webkit.WebView;


public class AgentWebSettingsImpl extends the.ua.dionis_view.AbsAgentWebSettings {
    private the.ua.dionis_view.DionisView mDionisView;

    @Override
    protected void bindAgentWebSupport(the.ua.dionis_view.DionisView dionisView) {
        this.mDionisView = dionisView;
    }

    @Override
    public the.ua.dionis_view.WebListenerManager setDownloader(WebView webView, DownloadListener downloadListener) {
        if (downloadListener == null) {
            downloadListener = the.ua.dionis_view.DefaultDownloadImpl.create(mDionisView.getActivity(), webView, mDionisView.getPermissionInterceptor());
        }
        return super.setDownloader(webView, downloadListener);
    }

    private Activity getActivityByContext(Context context) {
        if (context instanceof Activity) return (Activity) context;
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

}
