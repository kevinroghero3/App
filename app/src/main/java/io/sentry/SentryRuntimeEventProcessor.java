package io.sentry;

import io.sentry.protocol.SentryRuntime;
import io.sentry.protocol.SentryTransaction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
final class SentryRuntimeEventProcessor implements EventProcessor {
    private final String javaVendor;
    private final String javaVersion;

    public SentryRuntimeEventProcessor(@Nullable String str, @Nullable String str2) {
        this.javaVersion = str;
        this.javaVendor = str2;
    }

    public SentryRuntimeEventProcessor() {
        this(System.getProperty("java.version"), System.getProperty("java.vendor"));
    }

    @Override // io.sentry.EventProcessor
    public SentryEvent process(@NotNull SentryEvent sentryEvent, @Nullable Hint hint) {
        return (SentryEvent) process(sentryEvent);
    }

    @Override // io.sentry.EventProcessor
    public SentryTransaction process(@NotNull SentryTransaction sentryTransaction, @Nullable Hint hint) {
        return (SentryTransaction) process(sentryTransaction);
    }

    private <T extends SentryBaseEvent> T process(@NotNull T t) {
        if (t.getContexts().getRuntime() == null) {
            t.getContexts().setRuntime(new SentryRuntime());
        }
        SentryRuntime runtime = t.getContexts().getRuntime();
        if (runtime != null && runtime.getName() == null && runtime.getVersion() == null) {
            runtime.setName(this.javaVendor);
            runtime.setVersion(this.javaVersion);
        }
        return t;
    }

    @Override // io.sentry.EventProcessor
    public Long getOrder() {
        return 2000L;
    }
}
