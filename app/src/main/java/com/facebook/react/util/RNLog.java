package com.facebook.react.util;

import app.notifee.core.event.LogEvent;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.ReactConstants;
import com.transistorsoft.locationmanager.logger.TSLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class RNLog {
    public static final int ADVICE = 4;
    public static final int ERROR = 6;
    public static final RNLog INSTANCE = new RNLog();
    public static final int LOG = 2;
    public static final int MINIMUM_LEVEL_FOR_UI = 5;
    public static final int TRACE = 3;
    public static final int WARN = 5;

    private RNLog() {
    }

    @JvmStatic
    public static final void l(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        FLog.i(ReactConstants.TAG, message);
    }

    @JvmStatic
    public static final void t(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        FLog.i(ReactConstants.TAG, message);
    }

    @JvmStatic
    public static final void a(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        FLog.w(ReactConstants.TAG, "(ADVICE)" + message);
    }

    @JvmStatic
    public static final void w(@Nullable ReactContext reactContext, @NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        INSTANCE.logInternal(reactContext, message, 5);
        FLog.w(ReactConstants.TAG, message);
    }

    @JvmStatic
    public static final void e(@Nullable ReactContext reactContext, @NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        INSTANCE.logInternal(reactContext, message, 6);
        FLog.e(ReactConstants.TAG, message);
    }

    @JvmStatic
    public static final void e(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        FLog.e(ReactConstants.TAG, message);
    }

    private final void logInternal(ReactContext reactContext, String str, int i) {
        if (i < 5 || reactContext == null || !reactContext.hasActiveReactInstance() || str == null) {
            return;
        }
        ((RCTLog) reactContext.getJSModule(RCTLog.class)).logIfNoNativeHook(levelToString(i), str);
    }

    private final String levelToString(int i) {
        if (i == 2 || i == 3) {
            return TSLog.ACTION_LOG;
        }
        if (i == 4 || i == 5) {
            return LogEvent.LEVEL_WARN;
        }
        if (i == 6) {
            return "error";
        }
        return "none";
    }
}
