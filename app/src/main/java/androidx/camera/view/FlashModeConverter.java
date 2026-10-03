package androidx.camera.view;

import androidx.annotation.Nullable;
import com.transistorsoft.locationmanager.Constants;

/* JADX INFO: loaded from: classes3.dex */
final class FlashModeConverter {
    private FlashModeConverter() {
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0036  */
    public static int valueOf(@Nullable String str) {
        byte b;
        if (str == null) {
            throw new NullPointerException("name cannot be null");
        }
        int iHashCode = str.hashCode();
        if (iHashCode != 2527) {
            if (iHashCode != 78159) {
                if (iHashCode == 2020783 && str.equals("AUTO")) {
                    b = 2;
                } else {
                    b = -1;
                }
            } else if (str.equals(Constants.a.b)) {
                b = 1;
            } else {
                b = -1;
            }
        } else if (str.equals(Constants.a.a)) {
            b = 0;
        } else {
            b = -1;
        }
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return 2;
        }
        if (b == 2) {
            return 0;
        }
        throw new IllegalArgumentException("Unknown flash mode name " + str);
    }

    public static String nameOf(int i) {
        if (i == 0) {
            return "AUTO";
        }
        if (i == 1) {
            return Constants.a.a;
        }
        if (i == 2) {
            return Constants.a.b;
        }
        throw new IllegalArgumentException("Unknown flash mode " + i);
    }
}
