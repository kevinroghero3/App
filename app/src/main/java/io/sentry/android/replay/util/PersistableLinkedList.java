package io.sentry.android.replay.util;

import io.sentry.ReplayRecording;
import io.sentry.SentryOptions;
import io.sentry.android.replay.ReplayCache;
import io.sentry.rrweb.RRWebEvent;
import java.io.BufferedWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class PersistableLinkedList extends ConcurrentLinkedDeque<RRWebEvent> {
    public static final int $stable = 8;
    private final Function0<ReplayCache> cacheProvider;
    private final SentryOptions options;
    private final ScheduledExecutorService persistingExecutor;
    private final String propertyName;

    public /* bridge */ boolean contains(RRWebEvent rRWebEvent) {
        return super.contains((Object) rRWebEvent);
    }

    @Override // java.util.concurrent.ConcurrentLinkedDeque, java.util.AbstractCollection, java.util.Collection, java.util.Deque
    public final /* bridge */ boolean contains(Object obj) {
        if (obj == null || (obj instanceof RRWebEvent)) {
            return contains((RRWebEvent) obj);
        }
        return false;
    }

    public int getSize() {
        return super.size();
    }

    public /* bridge */ boolean remove(RRWebEvent rRWebEvent) {
        return super.remove((Object) rRWebEvent);
    }

    @Override // java.util.concurrent.ConcurrentLinkedDeque, java.util.AbstractCollection, java.util.Collection, java.util.Deque
    public final /* bridge */ boolean remove(Object obj) {
        if (obj == null || (obj instanceof RRWebEvent)) {
            return remove((RRWebEvent) obj);
        }
        return false;
    }

    @Override // java.util.concurrent.ConcurrentLinkedDeque, java.util.AbstractCollection, java.util.Collection, java.util.Deque
    public final int size() {
        return getSize();
    }

    public PersistableLinkedList(@NotNull String propertyName, @NotNull SentryOptions options, @NotNull ScheduledExecutorService persistingExecutor, @NotNull Function0<ReplayCache> cacheProvider) {
        Intrinsics.checkNotNullParameter(propertyName, "propertyName");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(persistingExecutor, "persistingExecutor");
        Intrinsics.checkNotNullParameter(cacheProvider, "cacheProvider");
        this.propertyName = propertyName;
        this.options = options;
        this.persistingExecutor = persistingExecutor;
        this.cacheProvider = cacheProvider;
    }

    @Override // java.util.concurrent.ConcurrentLinkedDeque, java.util.AbstractCollection, java.util.Collection, java.util.Deque
    public boolean addAll(@NotNull Collection<? extends RRWebEvent> elements) throws Exception {
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean zAddAll = super.addAll(elements);
        persistRecording();
        return zAddAll;
    }

    @Override // java.util.concurrent.ConcurrentLinkedDeque, java.util.AbstractCollection, java.util.Collection, java.util.Deque, java.util.Queue
    public boolean add(@NotNull RRWebEvent element) throws Exception {
        Intrinsics.checkNotNullParameter(element, "element");
        boolean zAdd = super.add(element);
        persistRecording();
        return zAdd;
    }

    @Override // java.util.concurrent.ConcurrentLinkedDeque, java.util.Deque, java.util.Queue
    public RRWebEvent remove() throws Exception {
        RRWebEvent result = (RRWebEvent) super.remove();
        persistRecording();
        Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    private final void persistRecording() throws Exception {
        final ReplayCache replayCacheInvoke = this.cacheProvider.invoke();
        if (replayCacheInvoke == null) {
            return;
        }
        final ReplayRecording replayRecording = new ReplayRecording();
        replayRecording.setPayload(new ArrayList(this));
        if (this.options.getThreadChecker().isMainThread()) {
            this.persistingExecutor.submit(new Runnable() { // from class: io.sentry.android.replay.util.PersistableLinkedList$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() throws Exception {
                    PersistableLinkedList.persistRecording$lambda$1(this.f$0, replayRecording, replayCacheInvoke);
                }
            });
            return;
        }
        StringWriter stringWriter = new StringWriter();
        this.options.getSerializer().serialize(replayRecording, new BufferedWriter(stringWriter));
        replayCacheInvoke.persistSegmentValues$sentry_android_replay_release(this.propertyName, stringWriter.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void persistRecording$lambda$1(PersistableLinkedList this$0, ReplayRecording recording, ReplayCache cache) throws Exception {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(recording, "$recording");
        Intrinsics.checkNotNullParameter(cache, "$cache");
        StringWriter stringWriter = new StringWriter();
        this$0.options.getSerializer().serialize(recording, new BufferedWriter(stringWriter));
        cache.persistSegmentValues$sentry_android_replay_release(this$0.propertyName, stringWriter.toString());
    }
}
