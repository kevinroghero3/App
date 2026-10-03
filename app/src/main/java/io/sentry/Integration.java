package io.sentry;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public interface Integration {
    void register(@NotNull IScopes iScopes, @NotNull SentryOptions sentryOptions);
}
