package io.sentry;

import io.sentry.transport.ITransport;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public interface ITransportFactory {
    ITransport create(@NotNull SentryOptions sentryOptions, @NotNull RequestDetails requestDetails);
}
