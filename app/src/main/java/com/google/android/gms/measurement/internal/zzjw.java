package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
final class zzjw implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzja zzb;

    zzjw(zzja zzjaVar, AtomicReference atomicReference) {
        this.zza = atomicReference;
        this.zzb = zzjaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                this.zza.set(this.zzb.zze().zzg(this.zzb.zzg().zzad()));
                this.zza.notify();
            } catch (Throwable th) {
                this.zza.notify();
                throw th;
            }
        }
    }
}
