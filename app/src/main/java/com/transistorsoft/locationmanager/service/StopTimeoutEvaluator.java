package com.transistorsoft.locationmanager.service;

import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import com.transistorsoft.locationmanager.logger.TSLog;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes3.dex */
public class StopTimeoutEvaluator {
    private static final Handler e = new Handler(Looper.getMainLooper());
    private Runnable a;
    private a b;
    private int c;
    private final Set<Float> d = new CopyOnWriteArraySet();

    interface a {
        void a();
    }

    StopTimeoutEvaluator(int i, a aVar) {
        this.b = aVar;
        this.c = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.a = null;
        this.b.a();
    }

    void a() {
        if (this.a != null) {
            TSLog.logger.debug(TSLog.calendar("cancel stopTimeout timer"));
            e.removeCallbacks(this.a);
            this.a = null;
        }
    }

    boolean b() {
        return this.a != null;
    }

    void d() {
        TSLog.logger.debug(TSLog.calendar("will stop updating location in " + ((this.c / 1000) / 60) + "min"));
        a();
        Runnable runnable = new Runnable() { // from class: com.transistorsoft.locationmanager.service.StopTimeoutEvaluator$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c();
            }
        };
        this.a = runnable;
        e.postDelayed(runnable, (long) this.c);
    }

    float a(Location location) {
        if (location != null && location.hasSpeed() && !Float.isNaN(location.getSpeed())) {
            this.d.add(Float.valueOf(location.getSpeed()));
        }
        float fFloatValue = 0.0f;
        if (this.d.size() > 5) {
            this.d.remove(Float.valueOf(0.0f));
        }
        Iterator<Float> it2 = this.d.iterator();
        while (it2.hasNext()) {
            fFloatValue += it2.next().floatValue();
        }
        return !this.d.isEmpty() ? fFloatValue / this.d.size() : fFloatValue;
    }
}
