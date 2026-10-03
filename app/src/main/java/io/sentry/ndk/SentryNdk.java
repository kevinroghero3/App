package io.sentry.ndk;

import com.transistorsoft.locationmanager.logger.TSLog;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class SentryNdk {
    private static volatile boolean nativeLibrariesLoaded;

    public static native void initSentryNative(@NotNull NdkOptions ndkOptions);

    public static native void shutdown();

    private SentryNdk() {
    }

    public static void init(@NotNull NdkOptions ndkOptions) {
        loadNativeLibraries();
        initSentryNative(ndkOptions);
    }

    public static void close() {
        loadNativeLibraries();
        shutdown();
    }

    public static void loadNativeLibraries() {
        synchronized (SentryNdk.class) {
            if (!nativeLibrariesLoaded) {
                System.loadLibrary(TSLog.ACTION_LOG);
                System.loadLibrary("sentry");
                System.loadLibrary("sentry-android");
                nativeLibrariesLoaded = true;
            }
        }
    }
}
