

package the.ua.dionis_view;

import android.view.KeyEvent;

public interface IEventHandler {

    boolean onKeyDown(int keyCode, KeyEvent event);

    boolean back();
}
