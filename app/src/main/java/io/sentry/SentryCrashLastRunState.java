package io.sentry;

import io.sentry.cache.EnvelopeCache;
import io.sentry.util.AutoClosableReentrantLock;
import java.io.File;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class SentryCrashLastRunState {
    private static final SentryCrashLastRunState INSTANCE = new SentryCrashLastRunState();
    private Boolean crashedLastRun;
    private final AutoClosableReentrantLock crashedLastRunLock = new AutoClosableReentrantLock();
    private boolean readCrashedLastRun;

    private SentryCrashLastRunState() {
    }

    public static SentryCrashLastRunState getInstance() {
        return INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x004b  */
    public Boolean isCrashedLastRun(@Nullable String str, boolean z) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.crashedLastRunLock.acquire();
        try {
            if (this.readCrashedLastRun) {
                Boolean bool = this.crashedLastRun;
                if (iSentryLifecycleTokenAcquire != null) {
                    iSentryLifecycleTokenAcquire.close();
                }
                return bool;
            }
            if (str == null) {
                if (iSentryLifecycleTokenAcquire == null) {
                    return null;
                }
                iSentryLifecycleTokenAcquire.close();
                return null;
            }
            boolean z2 = true;
            this.readCrashedLastRun = true;
            File file = new File(str, EnvelopeCache.CRASH_MARKER_FILE);
            File file2 = new File(str, EnvelopeCache.NATIVE_CRASH_MARKER_FILE);
            try {
                try {
                    if (file.exists()) {
                        file.delete();
                    } else {
                        if (!file2.exists()) {
                            z2 = false;
                        } else if (z) {
                            file2.delete();
                        }
                        this.crashedLastRun = Boolean.valueOf(z2);
                        if (iSentryLifecycleTokenAcquire != null) {
                            iSentryLifecycleTokenAcquire.close();
                        }
                        return this.crashedLastRun;
                    }
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
            }
            this.crashedLastRun = Boolean.valueOf(z2);
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            return this.crashedLastRun;
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void setCrashedLastRun(boolean z) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.crashedLastRunLock.acquire();
        try {
            if (!this.readCrashedLastRun) {
                this.crashedLastRun = Boolean.valueOf(z);
                this.readCrashedLastRun = true;
            }
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void reset() {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.crashedLastRunLock.acquire();
        try {
            this.readCrashedLastRun = false;
            this.crashedLastRun = null;
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
