package com.mrousavy.camera.react;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class FpsSampleCollector {
    private final Callback callback;
    private Timer timer;
    private List<Long> timestamps;

    public interface Callback {
        void onAverageFpsChanged(double d);
    }

    public FpsSampleCollector(@NotNull Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
        this.timestamps = new ArrayList();
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final void start() {
        Timer timer = new Timer("VisionCamera FPS Sample Collector");
        this.timer = timer;
        timer.schedule(new TimerTask() { // from class: com.mrousavy.camera.react.FpsSampleCollector$start$$inlined$schedule$1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                this.this$0.getCallback().onAverageFpsChanged(this.this$0.getAverageFps());
            }
        }, 1000L, 1000L);
    }

    public final void stop() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
        }
        this.timer = null;
    }

    public final void onTick() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.timestamps.add(Long.valueOf(jCurrentTimeMillis));
        List<Long> list = this.timestamps;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (jCurrentTimeMillis - ((Number) obj).longValue() < 1000) {
                arrayList.add(obj);
            }
        }
        this.timestamps = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final double getAverageFps() {
        Long l = (Long) CollectionsKt___CollectionsKt.firstOrNull((List) this.timestamps);
        Long l2 = (Long) CollectionsKt___CollectionsKt.lastOrNull((List) this.timestamps);
        if (l == null || l2 == null) {
            return 0.0d;
        }
        return 1000.0d / ((l2.longValue() - l.longValue()) / ((double) (this.timestamps.size() - 1)));
    }
}
