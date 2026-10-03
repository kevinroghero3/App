package com.facebook.imagepipeline.datasource;

import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.listener.RequestListener2;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class ProducerToDataSourceAdapter<T> extends AbstractProducerToDataSourceAdapter<T> {
    public static final Companion Companion = new Companion(null);

    public /* synthetic */ ProducerToDataSourceAdapter(Producer producer, SettableProducerContext settableProducerContext, RequestListener2 requestListener2, DefaultConstructorMarker defaultConstructorMarker) {
        this(producer, settableProducerContext, requestListener2);
    }

    @JvmStatic
    public static final <T> DataSource<T> create(@NotNull Producer<T> producer, @NotNull SettableProducerContext settableProducerContext, @NotNull RequestListener2 requestListener2) {
        return Companion.create(producer, settableProducerContext, requestListener2);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final <T> DataSource<T> create(@NotNull Producer<T> producer, @NotNull SettableProducerContext settableProducerContext, @NotNull RequestListener2 listener) {
            Intrinsics.checkNotNullParameter(producer, "producer");
            Intrinsics.checkNotNullParameter(settableProducerContext, "settableProducerContext");
            Intrinsics.checkNotNullParameter(listener, "listener");
            return new ProducerToDataSourceAdapter(producer, settableProducerContext, listener, null);
        }
    }

    private ProducerToDataSourceAdapter(Producer<T> producer, SettableProducerContext settableProducerContext, RequestListener2 requestListener2) {
        super(producer, settableProducerContext, requestListener2);
    }
}
