package io.sentry.ndk;

import android.os.Process;

/* JADX INFO: loaded from: classes6.dex */
public final class BuildConfig {
    public static final String BUILD_TYPE = "release";
    public static final boolean DEBUG = false;
    public static final String LIBRARY_PACKAGE_NAME = "io.sentry.ndk";
    public static int setCallback;
    public static int setFlags;

    public static int MediaBrowserCompatMediaBrowserImplApi216() {
        int i = setFlags;
        int i2 = i % 5033488;
        setFlags = i + 1;
        if (i2 != 0) {
            return setCallback;
        }
        int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
        setCallback = startElapsedRealtime;
        return startElapsedRealtime;
    }
}
