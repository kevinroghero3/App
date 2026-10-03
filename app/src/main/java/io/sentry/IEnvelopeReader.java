package io.sentry;

import java.io.IOException;
import java.io.InputStream;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public interface IEnvelopeReader {
    SentryEnvelope read(@NotNull InputStream inputStream) throws IOException;
}
