package com.facebook.imagepipeline.producers;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class InternalProducerListener implements ProducerListener2 {
    private final ProducerListener producerListener;
    private final ProducerListener2 producerListener2;

    public InternalProducerListener(@Nullable ProducerListener producerListener, @Nullable ProducerListener2 producerListener2) {
        this.producerListener = producerListener;
        this.producerListener2 = producerListener2;
    }

    public final ProducerListener getProducerListener() {
        return this.producerListener;
    }

    public final ProducerListener2 getProducerListener2() {
        return this.producerListener2;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerStart(@NotNull ProducerContext context, @Nullable String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        ProducerListener producerListener = this.producerListener;
        if (producerListener != null) {
            producerListener.onProducerStart(context.getId(), str);
        }
        ProducerListener2 producerListener2 = this.producerListener2;
        if (producerListener2 != null) {
            producerListener2.onProducerStart(context, str);
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerEvent(@NotNull ProducerContext context, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        ProducerListener producerListener = this.producerListener;
        if (producerListener != null) {
            producerListener.onProducerEvent(context.getId(), str, str2);
        }
        ProducerListener2 producerListener2 = this.producerListener2;
        if (producerListener2 != null) {
            producerListener2.onProducerEvent(context, str, str2);
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerFinishWithSuccess(@NotNull ProducerContext context, @Nullable String str, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(context, "context");
        ProducerListener producerListener = this.producerListener;
        if (producerListener != null) {
            producerListener.onProducerFinishWithSuccess(context.getId(), str, map);
        }
        ProducerListener2 producerListener2 = this.producerListener2;
        if (producerListener2 != null) {
            producerListener2.onProducerFinishWithSuccess(context, str, map);
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerFinishWithFailure(@NotNull ProducerContext context, @Nullable String str, @Nullable Throwable th, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(context, "context");
        ProducerListener producerListener = this.producerListener;
        if (producerListener != null) {
            producerListener.onProducerFinishWithFailure(context.getId(), str, th, map);
        }
        ProducerListener2 producerListener2 = this.producerListener2;
        if (producerListener2 != null) {
            producerListener2.onProducerFinishWithFailure(context, str, th, map);
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerFinishWithCancellation(@NotNull ProducerContext context, @Nullable String str, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(context, "context");
        ProducerListener producerListener = this.producerListener;
        if (producerListener != null) {
            producerListener.onProducerFinishWithCancellation(context.getId(), str, map);
        }
        ProducerListener2 producerListener2 = this.producerListener2;
        if (producerListener2 != null) {
            producerListener2.onProducerFinishWithCancellation(context, str, map);
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onUltimateProducerReached(@NotNull ProducerContext context, @Nullable String str, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        ProducerListener producerListener = this.producerListener;
        if (producerListener != null) {
            producerListener.onUltimateProducerReached(context.getId(), str, z);
        }
        ProducerListener2 producerListener2 = this.producerListener2;
        if (producerListener2 != null) {
            producerListener2.onUltimateProducerReached(context, str, z);
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public boolean requiresExtraMap(@NotNull ProducerContext context, @Nullable String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        ProducerListener producerListener = this.producerListener;
        Boolean boolValueOf = producerListener != null ? Boolean.valueOf(producerListener.requiresExtraMap(context.getId())) : null;
        if (!Intrinsics.areEqual(boolValueOf, Boolean.TRUE)) {
            ProducerListener2 producerListener2 = this.producerListener2;
            boolValueOf = producerListener2 != null ? Boolean.valueOf(producerListener2.requiresExtraMap(context, str)) : null;
        }
        if (boolValueOf != null) {
            return boolValueOf.booleanValue();
        }
        return false;
    }
}
