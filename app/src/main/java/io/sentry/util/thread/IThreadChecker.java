package io.sentry.util.thread;

import io.sentry.protocol.SentryThread;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public interface IThreadChecker {
    long currentThreadSystemId();

    String getCurrentThreadName();

    boolean isMainThread();

    boolean isMainThread(long j);

    boolean isMainThread(@NotNull SentryThread sentryThread);

    boolean isMainThread(@NotNull Thread thread);
}
