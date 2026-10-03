package io.sentry.logger;

import io.sentry.SentryDate;
import io.sentry.SentryLogLevel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpLoggerApi implements ILoggerApi {
    private static final NoOpLoggerApi instance = new NoOpLoggerApi();

    @Override // io.sentry.logger.ILoggerApi
    public void debug(@Nullable String str, @Nullable Object... objArr) {
    }

    @Override // io.sentry.logger.ILoggerApi
    public void error(@Nullable String str, @Nullable Object... objArr) {
    }

    @Override // io.sentry.logger.ILoggerApi
    public void fatal(@Nullable String str, @Nullable Object... objArr) {
    }

    @Override // io.sentry.logger.ILoggerApi
    public void info(@Nullable String str, @Nullable Object... objArr) {
    }

    @Override // io.sentry.logger.ILoggerApi
    public void log(@NotNull SentryLogLevel sentryLogLevel, @Nullable SentryDate sentryDate, @Nullable String str, @Nullable Object... objArr) {
    }

    @Override // io.sentry.logger.ILoggerApi
    public void log(@NotNull SentryLogLevel sentryLogLevel, @NotNull SentryLogParameters sentryLogParameters, @Nullable String str, @Nullable Object... objArr) {
    }

    @Override // io.sentry.logger.ILoggerApi
    public void log(@NotNull SentryLogLevel sentryLogLevel, @Nullable String str, @Nullable Object... objArr) {
    }

    @Override // io.sentry.logger.ILoggerApi
    public void trace(@Nullable String str, @Nullable Object... objArr) {
    }

    @Override // io.sentry.logger.ILoggerApi
    public void warn(@Nullable String str, @Nullable Object... objArr) {
    }

    private NoOpLoggerApi() {
    }

    public static NoOpLoggerApi getInstance() {
        return instance;
    }
}
