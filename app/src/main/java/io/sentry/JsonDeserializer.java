package io.sentry;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public interface JsonDeserializer<T> {
    T deserialize(@NotNull ObjectReader objectReader, @NotNull ILogger iLogger) throws Exception;
}
