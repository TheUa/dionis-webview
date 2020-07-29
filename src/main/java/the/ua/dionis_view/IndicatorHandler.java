

package the.ua.dionis_view;

import android.webkit.WebView;


public class IndicatorHandler implements the.ua.dionis_view.IndicatorController {
	private BaseIndicatorSpec mBaseIndicatorSpec;

	@Override
	public void progress(WebView v, int newProgress) {

		if (newProgress == 0) {
			reset();
		} else if (newProgress > 0 && newProgress <= 10) {
			showIndicator();
		} else if (newProgress > 10 && newProgress < 95) {
			setProgress(newProgress);
		} else {
			setProgress(newProgress);
			finish();
		}

	}

	@Override
	public BaseIndicatorSpec offerIndicator() {
		return this.mBaseIndicatorSpec;
	}

	public void reset() {

		if (mBaseIndicatorSpec != null) {
			mBaseIndicatorSpec.reset();
		}
	}

	@Override
	public void finish() {
		if (mBaseIndicatorSpec != null) {
			mBaseIndicatorSpec.hide();
		}
	}

	@Override
	public void setProgress(int n) {
		if (mBaseIndicatorSpec != null) {
			mBaseIndicatorSpec.setProgress(n);
		}
	}

	@Override
	public void showIndicator() {

		if (mBaseIndicatorSpec != null) {
			mBaseIndicatorSpec.show();
		}
	}

	static the.ua.dionis_view.IndicatorHandler getInstance() {
		return new the.ua.dionis_view.IndicatorHandler();
	}


	the.ua.dionis_view.IndicatorHandler inJectIndicator(BaseIndicatorSpec baseIndicatorSpec) {
		this.mBaseIndicatorSpec = baseIndicatorSpec;
		return this;
	}
}
