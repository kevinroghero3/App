package com.salesforce.marketingcloud.sfmcsdk.components.logging;

import android.util.Log;
import io.sentry.android.core.SentryLogcatAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface LogListener {
    void out(@NotNull LogLevel logLevel, @NotNull String str, @NotNull String str2, @Nullable Throwable th);

    /* JADX INFO: loaded from: classes6.dex */
    public static class AndroidLogger implements LogListener {

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[LogLevel.values().length];
                try {
                    iArr[LogLevel.DEBUG.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[LogLevel.WARN.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[LogLevel.ERROR.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[LogLevel.NONE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        @Override // com.salesforce.marketingcloud.sfmcsdk.components.logging.LogListener
        public void out(@NotNull LogLevel level, @NotNull String tag, @NotNull String message, @Nullable Throwable th) {
            Intrinsics.checkNotNullParameter(level, "level");
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(message, "message");
            int i = WhenMappings.$EnumSwitchMapping$0[level.ordinal()];
            if (i == 1) {
                if (th == null) {
                    Log.d(tag, message);
                    return;
                } else {
                    Log.d(tag, message, th);
                    return;
                }
            }
            if (i == 2) {
                if (th == null) {
                    SentryLogcatAdapter.w(tag, message);
                    return;
                } else {
                    SentryLogcatAdapter.w(tag, message, th);
                    return;
                }
            }
            if (i != 3) {
                return;
            }
            if (th == null) {
                SentryLogcatAdapter.e(tag, message);
            } else {
                SentryLogcatAdapter.e(tag, message, th);
            }
        }
    }
}
