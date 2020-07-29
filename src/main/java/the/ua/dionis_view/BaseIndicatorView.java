

package the.ua.dionis_view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;


public abstract class BaseIndicatorView extends FrameLayout implements BaseIndicatorSpec, the.ua.dionis_view.LayoutParamsOffer {
    public BaseIndicatorView(Context context) {
        super(context);
    }

    public BaseIndicatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseIndicatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void reset() {
    }

    @Override
    public void setProgress(int newProgress) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }
}
