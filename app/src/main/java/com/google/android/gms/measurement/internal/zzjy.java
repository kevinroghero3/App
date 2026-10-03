package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
final class zzjy implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzja zzb;

    zzjy(zzja zzjaVar, long j) {
        this.zza = j;
        this.zzb = zzjaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza(this.zza, true);
        this.zzb.zzo().zza(new AtomicReference<>());
    }
}
