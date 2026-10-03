package io.sentry.util;

import io.sentry.ISentryLifecycleToken;
import java.util.concurrent.locks.ReentrantLock;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class AutoClosableReentrantLock extends ReentrantLock {
    private static final long serialVersionUID = -3283069816958445549L;

    public ISentryLifecycleToken acquire() {
        lock();
        return new AutoClosableReentrantLockLifecycleToken(this);
    }

    /* JADX INFO: loaded from: classes3.dex */
    static final class AutoClosableReentrantLockLifecycleToken implements ISentryLifecycleToken {
        private final ReentrantLock lock;

        AutoClosableReentrantLockLifecycleToken(@NotNull ReentrantLock reentrantLock) {
            this.lock = reentrantLock;
        }

        @Override // io.sentry.ISentryLifecycleToken, java.lang.AutoCloseable
        public void close() {
            this.lock.unlock();
        }
    }
}
