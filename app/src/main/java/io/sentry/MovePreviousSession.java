package io.sentry;

import io.sentry.cache.EnvelopeCache;
import io.sentry.cache.IEnvelopeCache;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
final class MovePreviousSession implements Runnable {
    private final SentryOptions options;

    MovePreviousSession(@NotNull SentryOptions sentryOptions) {
        this.options = sentryOptions;
    }

    @Override // java.lang.Runnable
    public void run() {
        String cacheDirPath = this.options.getCacheDirPath();
        if (cacheDirPath == null) {
            this.options.getLogger().log(SentryLevel.INFO, "Cache dir is not set, not moving the previous session.", new Object[0]);
            return;
        }
        if (!this.options.isEnableAutoSessionTracking()) {
            this.options.getLogger().log(SentryLevel.DEBUG, "Session tracking is disabled, bailing from previous session mover.", new Object[0]);
            return;
        }
        IEnvelopeCache envelopeDiskCache = this.options.getEnvelopeDiskCache();
        if (envelopeDiskCache instanceof EnvelopeCache) {
            EnvelopeCache envelopeCache = (EnvelopeCache) envelopeDiskCache;
            envelopeCache.movePreviousSession(EnvelopeCache.getCurrentSessionFile(cacheDirPath), EnvelopeCache.getPreviousSessionFile(cacheDirPath));
            envelopeCache.flushPreviousSession();
        }
    }
}
