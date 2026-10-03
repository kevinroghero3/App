package com.facebook.react.views.scroll;

import android.os.SystemClock;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
public final class OnScrollDispatchHelper {
    private static final Companion Companion = new Companion(null);
    private static final int MIN_EVENT_SEPARATION_MS = 10;
    private float xFlingVelocity;
    private float yFlingVelocity;
    private int prevX = Integer.MIN_VALUE;
    private int prevY = Integer.MIN_VALUE;
    private long lastScrollEventTimeMs = -11;

    public final float getXFlingVelocity() {
        return this.xFlingVelocity;
    }

    public final float getYFlingVelocity() {
        return this.yFlingVelocity;
    }

    public final boolean onScrollChanged(int i, int i2) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j = jUptimeMillis - this.lastScrollEventTimeMs;
        boolean z = (j <= 10 && this.prevX == i && this.prevY == i2) ? false : true;
        if (j != 0) {
            float f = j;
            this.xFlingVelocity = (i - this.prevX) / f;
            this.yFlingVelocity = (i2 - this.prevY) / f;
        }
        this.lastScrollEventTimeMs = jUptimeMillis;
        this.prevX = i;
        this.prevY = i2;
        return z;
    }

    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
