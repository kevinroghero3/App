package io.sentry.android.replay;

import io.sentry.SentryReplayOptions;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class SessionReplayOptionsKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Getter is unsupported.")
    public static final boolean getMaskAllText(@NotNull SentryReplayOptions sentryReplayOptions) {
        Intrinsics.checkNotNullParameter(sentryReplayOptions, "<this>");
        throw new IllegalStateException("Getter not supported");
    }

    public static final void setMaskAllText(@NotNull SentryReplayOptions sentryReplayOptions, boolean z) {
        Intrinsics.checkNotNullParameter(sentryReplayOptions, "<this>");
        sentryReplayOptions.setMaskAllText(z);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Getter is unsupported.")
    public static final boolean getMaskAllImages(@NotNull SentryReplayOptions sentryReplayOptions) {
        Intrinsics.checkNotNullParameter(sentryReplayOptions, "<this>");
        throw new IllegalStateException("Getter not supported");
    }

    public static final void setMaskAllImages(@NotNull SentryReplayOptions sentryReplayOptions, boolean z) {
        Intrinsics.checkNotNullParameter(sentryReplayOptions, "<this>");
        sentryReplayOptions.setMaskAllImages(z);
    }
}
