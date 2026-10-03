package com.facebook.imagepipeline.producers;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface Producer<T> {
    void produceResults(@NotNull Consumer<T> consumer, @NotNull ProducerContext producerContext);
}
