package com.reactnativekeyboardcontroller.log;

import android.util.Log;
import io.sentry.android.core.SentryLogcatAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class Logger {
    public static final Logger INSTANCE = new Logger();
    private static final boolean enabled = false;

    private Logger() {
    }

    public static /* synthetic */ void i$default(Logger logger, String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        logger.i(str, str2, th);
    }

    public final void i(@Nullable String str, @NotNull String message, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (enabled) {
            Log.i(str, message, th);
        }
    }

    public static /* synthetic */ void w$default(Logger logger, String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        logger.w(str, str2, th);
    }

    public final void w(@Nullable String str, @NotNull String message, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (enabled) {
            SentryLogcatAdapter.w(str, message, th);
        }
    }
}
