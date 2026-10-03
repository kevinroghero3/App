package io.sentry.hints;

import io.sentry.protocol.SentryId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public interface DiskFlushNotification {
    boolean isFlushable(@Nullable SentryId sentryId);

    void markFlushed();

    void setFlushable(@NotNull SentryId sentryId);
}
