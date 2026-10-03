package app.notifee.core.model;

import android.os.Build;
import android.os.Bundle;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class NotificationAndroidPressActionModel {
    private Bundle mNotificationAndroidPressActionBundle;

    private NotificationAndroidPressActionModel(Bundle bundle) {
        this.mNotificationAndroidPressActionBundle = bundle;
    }

    public static NotificationAndroidPressActionModel fromBundle(Bundle bundle) {
        return new NotificationAndroidPressActionModel(bundle);
    }

    public String getId() {
        String string = this.mNotificationAndroidPressActionBundle.getString("id");
        Objects.requireNonNull(string);
        return string;
    }

    public String getLaunchActivity() {
        return this.mNotificationAndroidPressActionBundle.getString("launchActivity");
    }

    public int getLaunchActivityFlags() {
        int i;
        if (!this.mNotificationAndroidPressActionBundle.containsKey("launchActivityFlags")) {
            return -1;
        }
        ArrayList<Integer> integerArrayList = this.mNotificationAndroidPressActionBundle.getIntegerArrayList("launchActivityFlags");
        Objects.requireNonNull(integerArrayList);
        int i2 = 0;
        for (int i3 = 0; i3 < integerArrayList.size(); i3++) {
            switch (integerArrayList.get(i3).intValue()) {
                case 0:
                    i = 1073741824;
                    break;
                case 1:
                    i = 536870912;
                    break;
                case 2:
                    i = 268435456;
                    break;
                case 3:
                    i = 134217728;
                    break;
                case 4:
                    i = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                    break;
                case 5:
                    i = 33554432;
                    break;
                case 6:
                    i = 16777216;
                    break;
                case 7:
                    i = 8388608;
                    break;
                case 8:
                    i = 4194304;
                    break;
                case 9:
                    i = 2097152;
                    break;
                case 10:
                    i = 1048576;
                    break;
                case 11:
                case 12:
                    i = 524288;
                    break;
                case 13:
                    i = 262144;
                    break;
                case 14:
                    i = 131072;
                    break;
                case 15:
                    i = 65536;
                    break;
                case 16:
                    i = 32768;
                    break;
                case 17:
                    i = 16384;
                    break;
                case 18:
                    i = 8192;
                    break;
                case 19:
                    i = 4096;
                    break;
                case 20:
                    if (Build.VERSION.SDK_INT >= 28) {
                        i = 2048;
                        break;
                    }
                    break;
                default:
                    continue;
                    break;
            }
            i2 |= i;
        }
        return i2;
    }

    public String getMainComponent() {
        return this.mNotificationAndroidPressActionBundle.getString("mainComponent");
    }

    public Bundle toBundle() {
        return (Bundle) this.mNotificationAndroidPressActionBundle.clone();
    }
}
