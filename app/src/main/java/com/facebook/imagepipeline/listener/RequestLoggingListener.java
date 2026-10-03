package com.facebook.imagepipeline.listener;

import android.os.SystemClock;
import android.util.Pair;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class RequestLoggingListener implements RequestListener {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "RequestLoggingListener";
    private final Map<Pair<String, String>, Long> producerStartTimeMap = new HashMap();
    private final Map<String, Long> requestStartTimeMap = new HashMap();

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void onRequestStart(@NotNull ImageRequest request, @NotNull Object callerContextObject, @NotNull String requestId, boolean z) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(callerContextObject, "callerContextObject");
            Intrinsics.checkNotNullParameter(requestId, "requestId");
            if (FLog.isLoggable(2)) {
                Companion companion = Companion;
                FLog.v(TAG, "time %d: onRequestSubmit: {requestId: %s, callerContext: %s, isPrefetch: %b}", Long.valueOf(companion.getTime()), requestId, callerContextObject, Boolean.valueOf(z));
                this.requestStartTimeMap.put(requestId, Long.valueOf(companion.getTime()));
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerStart(@NotNull String requestId, @NotNull String producerName) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter(requestId, "requestId");
            Intrinsics.checkNotNullParameter(producerName, "producerName");
            if (FLog.isLoggable(2)) {
                Pair<String, String> pairCreate = Pair.create(requestId, producerName);
                long time = Companion.getTime();
                this.producerStartTimeMap.put(pairCreate, Long.valueOf(time));
                FLog.v(TAG, "time %d: onProducerStart: {requestId: %s, producer: %s}", Long.valueOf(time), requestId, producerName);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerFinishWithSuccess(@NotNull String requestId, @NotNull String producerName, @Nullable Map<String, String> map) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter(requestId, "requestId");
            Intrinsics.checkNotNullParameter(producerName, "producerName");
            if (FLog.isLoggable(2)) {
                Long lRemove = this.producerStartTimeMap.remove(Pair.create(requestId, producerName));
                Companion companion = Companion;
                long time = companion.getTime();
                FLog.v(TAG, "time %d: onProducerFinishWithSuccess: {requestId: %s, producer: %s, elapsedTime: %d ms, extraMap: %s}", Long.valueOf(time), requestId, producerName, Long.valueOf(companion.getElapsedTime(lRemove, time)), map);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerFinishWithFailure(@NotNull String requestId, @NotNull String producerName, @NotNull Throwable throwable, @Nullable Map<String, String> map) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter(requestId, "requestId");
            Intrinsics.checkNotNullParameter(producerName, "producerName");
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            if (FLog.isLoggable(5)) {
                Long lRemove = this.producerStartTimeMap.remove(Pair.create(requestId, producerName));
                Companion companion = Companion;
                long time = companion.getTime();
                FLog.w(TAG, throwable, "time %d: onProducerFinishWithFailure: {requestId: %s, stage: %s, elapsedTime: %d ms, extraMap: %s, throwable: %s}", Long.valueOf(time), requestId, producerName, Long.valueOf(companion.getElapsedTime(lRemove, time)), map, throwable.toString());
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerFinishWithCancellation(@NotNull String requestId, @NotNull String producerName, @Nullable Map<String, String> map) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter(requestId, "requestId");
            Intrinsics.checkNotNullParameter(producerName, "producerName");
            if (FLog.isLoggable(2)) {
                Long lRemove = this.producerStartTimeMap.remove(Pair.create(requestId, producerName));
                Companion companion = Companion;
                long time = companion.getTime();
                FLog.v(TAG, "time %d: onProducerFinishWithCancellation: {requestId: %s, stage: %s, elapsedTime: %d ms, extraMap: %s}", Long.valueOf(time), requestId, producerName, Long.valueOf(companion.getElapsedTime(lRemove, time)), map);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerEvent(@NotNull String requestId, @NotNull String producerName, @NotNull String producerEventName) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter(requestId, "requestId");
            Intrinsics.checkNotNullParameter(producerName, "producerName");
            Intrinsics.checkNotNullParameter(producerEventName, "producerEventName");
            if (FLog.isLoggable(2)) {
                Long l = this.producerStartTimeMap.get(Pair.create(requestId, producerName));
                Companion companion = Companion;
                FLog.v(TAG, "time %d: onProducerEvent: {requestId: %s, stage: %s, eventName: %s; elapsedTime: %d ms}", Long.valueOf(companion.getTime()), requestId, producerName, producerEventName, Long.valueOf(companion.getElapsedTime(l, companion.getTime())));
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onUltimateProducerReached(@NotNull String requestId, @NotNull String producerName, boolean z) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter(requestId, "requestId");
            Intrinsics.checkNotNullParameter(producerName, "producerName");
            if (FLog.isLoggable(2)) {
                Long lRemove = this.producerStartTimeMap.remove(Pair.create(requestId, producerName));
                Companion companion = Companion;
                long time = companion.getTime();
                FLog.v(TAG, "time %d: onUltimateProducerReached: {requestId: %s, producer: %s, elapsedTime: %d ms, success: %b}", Long.valueOf(time), requestId, producerName, Long.valueOf(companion.getElapsedTime(lRemove, time)), Boolean.valueOf(z));
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void onRequestSuccess(@NotNull ImageRequest request, @NotNull String requestId, boolean z) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(requestId, "requestId");
            if (FLog.isLoggable(2)) {
                Long lRemove = this.requestStartTimeMap.remove(requestId);
                Companion companion = Companion;
                long time = companion.getTime();
                FLog.v(TAG, "time %d: onRequestSuccess: {requestId: %s, elapsedTime: %d ms}", Long.valueOf(time), requestId, Long.valueOf(companion.getElapsedTime(lRemove, time)));
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void onRequestFailure(@NotNull ImageRequest request, @NotNull String requestId, @NotNull Throwable throwable, boolean z) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(requestId, "requestId");
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            if (FLog.isLoggable(5)) {
                Long lRemove = this.requestStartTimeMap.remove(requestId);
                Companion companion = Companion;
                long time = companion.getTime();
                FLog.w(TAG, "time %d: onRequestFailure: {requestId: %s, elapsedTime: %d ms, throwable: %s}", Long.valueOf(time), requestId, Long.valueOf(companion.getElapsedTime(lRemove, time)), throwable.toString());
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void onRequestCancellation(@NotNull String requestId) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter(requestId, "requestId");
            if (FLog.isLoggable(2)) {
                Long lRemove = this.requestStartTimeMap.remove(requestId);
                Companion companion = Companion;
                long time = companion.getTime();
                FLog.v(TAG, "time %d: onRequestCancellation: {requestId: %s, elapsedTime: %d ms}", Long.valueOf(time), requestId, Long.valueOf(companion.getElapsedTime(lRemove, time)));
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public boolean requiresExtraMap(@NotNull String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return FLog.isLoggable(2);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final long getElapsedTime(Long l, long j) {
            if (l != null) {
                return j - l.longValue();
            }
            return -1L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final long getTime() {
            return SystemClock.uptimeMillis();
        }
    }
}
