
package the.ua.dionis_view;


public class HookManager {

    public static the.ua.dionis_view.DionisView hookAgentWeb(the.ua.dionis_view.DionisView dionisView, the.ua.dionis_view.DionisView.AgentBuilder agentBuilder) {
        return dionisView;
    }

    public static boolean permissionHook(String url,String[]permissions){
        return true;
    }
}
