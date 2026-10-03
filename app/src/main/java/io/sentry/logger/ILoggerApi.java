package io.sentry.logger;

import io.sentry.SentryDate;
import io.sentry.SentryLogLevel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public interface ILoggerApi {
    void debug(@Nullable String str, @Nullable Object... objArr);

    void error(@Nullable String str, @Nullable Object... objArr);

    void fatal(@Nullable String str, @Nullable Object... objArr);

    void info(@Nullable String str, @Nullable Object... objArr);

    void log(@NotNull SentryLogLevel sentryLogLevel, @Nullable SentryDate sentryDate, @Nullable String str, @Nullable Object... objArr);

    void log(@NotNull SentryLogLevel sentryLogLevel, @NotNull SentryLogParameters sentryLogParameters, @Nullable String str, @Nullable Object... objArr);

    void log(@NotNull SentryLogLevel sentryLogLevel, @Nullable String str, @Nullable Object... objArr);

    void trace(@Nullable String str, @Nullable Object... objArr);

    void warn(@Nullable String str, @Nullable Object... objArr);
}
