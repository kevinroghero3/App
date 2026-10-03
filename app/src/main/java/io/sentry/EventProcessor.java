package io.sentry;

import io.sentry.protocol.SentryTransaction;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public interface EventProcessor {
    default Long getOrder() {
        return null;
    }

    default SentryEvent process(@NotNull SentryEvent sentryEvent, @NotNull Hint hint) {
        return sentryEvent;
    }

    default SentryLogEvent process(@NotNull SentryLogEvent sentryLogEvent) {
        return sentryLogEvent;
    }

    default SentryReplayEvent process(@NotNull SentryReplayEvent sentryReplayEvent, @NotNull Hint hint) {
        return sentryReplayEvent;
    }

    default SentryTransaction process(@NotNull SentryTransaction sentryTransaction, @NotNull Hint hint) {
        return sentryTransaction;
    }
}
