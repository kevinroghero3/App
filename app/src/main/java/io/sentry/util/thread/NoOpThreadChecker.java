package io.sentry.util.thread;

import io.sentry.protocol.SentryThread;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpThreadChecker implements IThreadChecker {
    private static final NoOpThreadChecker instance = new NoOpThreadChecker();

    @Override // io.sentry.util.thread.IThreadChecker
    public long currentThreadSystemId() {
        return 0L;
    }

    @Override // io.sentry.util.thread.IThreadChecker
    public boolean isMainThread() {
        return false;
    }

    @Override // io.sentry.util.thread.IThreadChecker
    public boolean isMainThread(long j) {
        return false;
    }

    @Override // io.sentry.util.thread.IThreadChecker
    public boolean isMainThread(@NotNull SentryThread sentryThread) {
        return false;
    }

    @Override // io.sentry.util.thread.IThreadChecker
    public boolean isMainThread(@NotNull Thread thread) {
        return false;
    }

    public static NoOpThreadChecker getInstance() {
        return instance;
    }

    @Override // io.sentry.util.thread.IThreadChecker
    public String getCurrentThreadName() {
        return "";
    }
}
