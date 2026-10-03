package io.sentry.android.replay;

import android.os.Process;

/* JADX INFO: loaded from: classes6.dex */
public final class BuildConfig {
    public static final String BUILD_TYPE = "release";
    public static final boolean DEBUG = false;
    public static final String LIBRARY_PACKAGE_NAME = "io.sentry.android.replay";
    public static final String VERSION_NAME = "8.20.0";
    public static int sendSessionEvent;
    public static int setMediaButtonReceiver;

    public static int MediaBrowserCompatMediaBrowserImplApi214() {
        int i = sendSessionEvent;
        int i2 = i % 8245396;
        sendSessionEvent = i + 1;
        if (i2 != 0) {
            return setMediaButtonReceiver;
        }
        int startUptimeMillis = (int) Process.getStartUptimeMillis();
        setMediaButtonReceiver = startUptimeMillis;
        return startUptimeMillis;
    }
}
