

package the.ua.dionis_view;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Action implements Parcelable {

	public transient static final int ACTION_PERMISSION = 1;
	public transient static final int ACTION_FILE = 2;
	public transient static final int ACTION_CAMERA = 3;
	public transient static final int ACTION_VIDEO = 4;
	private ArrayList<String> mPermissions = new ArrayList();
	private int mAction;
	private int mFromIntention;

	public Action() {
	}

	public ArrayList<String> getPermissions() {
		return mPermissions;
	}

	public void setPermissions(ArrayList<String> permissions) {
		this.mPermissions = permissions;
	}

	public void setPermissions(String[] permissions) {
		this.mPermissions = new ArrayList<>(Arrays.asList(permissions));
	}

	public int getAction() {
		return mAction;
	}

	public void setAction(int action) {
		this.mAction = action;
	}

	protected Action(Parcel in) {
		mPermissions = in.createStringArrayList();
		mAction = in.readInt();
		mFromIntention = in.readInt();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeStringList(mPermissions);
		dest.writeInt(mAction);
		dest.writeInt(mFromIntention);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<Action> CREATOR = new Creator<Action>() {
		@Override
		public the.ua.dionis_view.Action createFromParcel(Parcel in) {
			return new the.ua.dionis_view.Action(in);
		}

		@Override
		public the.ua.dionis_view.Action[] newArray(int size) {
			return new the.ua.dionis_view.Action[size];
		}
	};

	public int getFromIntention() {
		return mFromIntention;
	}

	public static the.ua.dionis_view.Action createPermissionsAction(String[] permissions) {
		the.ua.dionis_view.Action mAction = new the.ua.dionis_view.Action();
		mAction.setAction(the.ua.dionis_view.Action.ACTION_PERMISSION);
		List<String> mList = Arrays.asList(permissions);
		mAction.setPermissions(new ArrayList<String>(mList));
		return mAction;
	}

	public the.ua.dionis_view.Action setFromIntention(int fromIntention) {
		this.mFromIntention = fromIntention;
		return this;
	}
}
