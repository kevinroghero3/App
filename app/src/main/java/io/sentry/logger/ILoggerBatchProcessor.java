package io.sentry.logger;

import io.sentry.SentryLogEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public interface ILoggerBatchProcessor {
    void add(@NotNull SentryLogEvent sentryLogEvent);

    void close(boolean z);

    void flush(long j);
}
