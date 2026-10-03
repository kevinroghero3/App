package com.google.firebase.sessions;

import android.os.SystemClock;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: loaded from: classes5.dex */
public final class WallClock implements TimeProvider {
    public static final WallClock INSTANCE = new WallClock();
    private static final long US_PER_MILLIS = 1000;

    private WallClock() {
    }

    @Override // com.google.firebase.sessions.TimeProvider
    /* JADX INFO: renamed from: elapsedRealtime-UwyO8pc */
    public long mo5016elapsedRealtimeUwyO8pc() {
        Duration.Companion companion = Duration.Companion;
        return DurationKt.toDuration(SystemClock.elapsedRealtime(), DurationUnit.MILLISECONDS);
    }

    @Override // com.google.firebase.sessions.TimeProvider
    public long currentTimeUs() {
        return System.currentTimeMillis() * 1000;
    }
}
