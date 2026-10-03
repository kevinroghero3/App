package io.sentry;

import io.sentry.transport.ITransport;
import io.sentry.transport.NoOpTransport;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpTransportFactory implements ITransportFactory {
    private static final NoOpTransportFactory instance = new NoOpTransportFactory();

    public static NoOpTransportFactory getInstance() {
        return instance;
    }

    private NoOpTransportFactory() {
    }

    @Override // io.sentry.ITransportFactory
    public ITransport create(@NotNull SentryOptions sentryOptions, @NotNull RequestDetails requestDetails) {
        return NoOpTransport.getInstance();
    }
}
