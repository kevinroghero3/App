package io.sentry;

import io.sentry.util.AutoClosableReentrantLock;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public final class SentrySpanStorage {
    private static volatile SentrySpanStorage INSTANCE;
    private static final AutoClosableReentrantLock staticLock = new AutoClosableReentrantLock();
    private final Map<String, ISpan> spans = new ConcurrentHashMap();

    public static SentrySpanStorage getInstance() {
        if (INSTANCE == null) {
            ISentryLifecycleToken iSentryLifecycleTokenAcquire = staticLock.acquire();
            try {
                if (INSTANCE == null) {
                    INSTANCE = new SentrySpanStorage();
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
        return INSTANCE;
    }

    private SentrySpanStorage() {
    }

    public void store(@NotNull String str, @NotNull ISpan iSpan) {
        this.spans.put(str, iSpan);
    }

    public ISpan get(@Nullable String str) {
        return this.spans.get(str);
    }

    public ISpan removeAndGet(@Nullable String str) {
        return this.spans.remove(str);
    }
}
