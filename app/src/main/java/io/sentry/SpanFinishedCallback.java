package io.sentry;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public interface SpanFinishedCallback {
    void execute(@NotNull Span span);
}
