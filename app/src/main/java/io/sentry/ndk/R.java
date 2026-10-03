package io.sentry.ndk;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public final class R {
    public static int describeContents;
    public static int setActive;

    private R() {
    }

    public static int MediaBrowserCompatMediaBrowserImplApi23() {
        int i = describeContents;
        int i2 = i % 7331606;
        describeContents = i + 1;
        if (i2 != 0) {
            return setActive;
        }
        int iUptimeMillis = (int) SystemClock.uptimeMillis();
        setActive = iUptimeMillis;
        return iUptimeMillis;
    }
}
