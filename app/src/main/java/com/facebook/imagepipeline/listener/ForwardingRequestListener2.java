package com.facebook.imagepipeline.listener;

import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.producers.ProducerContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class ForwardingRequestListener2 implements RequestListener2 {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "ForwardingRequestListener2";
    private final List<RequestListener2> requestListeners;

    public ForwardingRequestListener2(@Nullable Set<? extends RequestListener2> set) {
        if (set == null) {
            this.requestListeners = new ArrayList();
            return;
        }
        ArrayList arrayList = new ArrayList(set.size());
        this.requestListeners = arrayList;
        CollectionsKt___CollectionsKt.filterNotNullTo(set, arrayList);
    }

    public ForwardingRequestListener2(@NotNull RequestListener2... listenersToAdd) {
        Intrinsics.checkNotNullParameter(listenersToAdd, "listenersToAdd");
        ArrayList arrayList = new ArrayList(listenersToAdd.length);
        this.requestListeners = arrayList;
        ArraysKt___ArraysKt.filterNotNullTo(listenersToAdd, arrayList);
    }

    public final void addRequestListener(@NotNull RequestListener2 requestListener) {
        Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        this.requestListeners.add(requestListener);
    }

    private final void forEachListener(String str, Function1<? super RequestListener2, Unit> function1) {
        Iterator<T> it2 = this.requestListeners.iterator();
        while (it2.hasNext()) {
            try {
                function1.invoke((RequestListener2) it2.next());
            } catch (Exception e) {
                FLog.e(TAG, "InternalListener exception in " + str, e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public boolean requiresExtraMap(@NotNull ProducerContext producerContext, @NotNull String producerName) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
        List<RequestListener2> list = this.requestListeners;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                if (((RequestListener2) it2.next()).requiresExtraMap(producerContext, producerName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestStart(@NotNull ProducerContext producerContext) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Iterator<T> it2 = this.requestListeners.iterator();
        while (it2.hasNext()) {
            try {
                ((RequestListener2) it2.next()).onRequestStart(producerContext);
            } catch (Exception e) {
                FLog.e(TAG, "InternalListener exception in onRequestStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerStart(@NotNull ProducerContext producerContext, @NotNull String producerName) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
        Iterator<T> it2 = this.requestListeners.iterator();
        while (it2.hasNext()) {
            try {
                ((RequestListener2) it2.next()).onProducerStart(producerContext, producerName);
            } catch (Exception e) {
                FLog.e(TAG, "InternalListener exception in onProducerStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerFinishWithSuccess(@Nullable ProducerContext producerContext, @Nullable String str, @Nullable Map<String, String> map) {
        Iterator<T> it2 = this.requestListeners.iterator();
        while (it2.hasNext()) {
            try {
                ((RequestListener2) it2.next()).onProducerFinishWithSuccess(producerContext, str, map);
            } catch (Exception e) {
                FLog.e(TAG, "InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerFinishWithFailure(@Nullable ProducerContext producerContext, @Nullable String str, @Nullable Throwable th, @Nullable Map<String, String> map) {
        Iterator<T> it2 = this.requestListeners.iterator();
        while (it2.hasNext()) {
            try {
                ((RequestListener2) it2.next()).onProducerFinishWithFailure(producerContext, str, th, map);
            } catch (Exception e) {
                FLog.e(TAG, "InternalListener exception in onProducerFinishWithFailure", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerFinishWithCancellation(@Nullable ProducerContext producerContext, @Nullable String str, @Nullable Map<String, String> map) {
        Iterator<T> it2 = this.requestListeners.iterator();
        while (it2.hasNext()) {
            try {
                ((RequestListener2) it2.next()).onProducerFinishWithCancellation(producerContext, str, map);
            } catch (Exception e) {
                FLog.e(TAG, "InternalListener exception in onProducerFinishWithCancellation", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerEvent(@NotNull ProducerContext producerContext, @NotNull String producerName, @NotNull String producerEventName) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
        Intrinsics.checkNotNullParameter(producerEventName, "producerEventName");
        Iterator<T> it2 = this.requestListeners.iterator();
        while (it2.hasNext()) {
            try {
                ((RequestListener2) it2.next()).onProducerEvent(producerContext, producerName, producerEventName);
            } catch (Exception e) {
                FLog.e(TAG, "InternalListener exception in onIntermediateChunkStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onUltimateProducerReached(@NotNull ProducerContext producerContext, @NotNull String producerName, boolean z) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
        Iterator<T> it2 = this.requestListeners.iterator();
        while (it2.hasNext()) {
            try {
                ((RequestListener2) it2.next()).onUltimateProducerReached(producerContext, producerName, z);
            } catch (Exception e) {
                FLog.e(TAG, "InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestSuccess(@NotNull ProducerContext producerContext) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Iterator<T> it2 = this.requestListeners.iterator();
        while (it2.hasNext()) {
            try {
                ((RequestListener2) it2.next()).onRequestSuccess(producerContext);
            } catch (Exception e) {
                FLog.e(TAG, "InternalListener exception in onRequestSuccess", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestFailure(@NotNull ProducerContext producerContext, @NotNull Throwable throwable) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Iterator<T> it2 = this.requestListeners.iterator();
        while (it2.hasNext()) {
            try {
                ((RequestListener2) it2.next()).onRequestFailure(producerContext, throwable);
            } catch (Exception e) {
                FLog.e(TAG, "InternalListener exception in onRequestFailure", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestCancellation(@NotNull ProducerContext producerContext) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Iterator<T> it2 = this.requestListeners.iterator();
        while (it2.hasNext()) {
            try {
                ((RequestListener2) it2.next()).onRequestCancellation(producerContext);
            } catch (Exception e) {
                FLog.e(TAG, "InternalListener exception in onRequestCancellation", e);
            }
        }
    }
}
