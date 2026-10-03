package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
final class zzkh implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzja zzb;

    zzkh(zzja zzjaVar, AtomicReference atomicReference) {
        this.zza = atomicReference;
        this.zzb = zzjaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                this.zza.set(Long.valueOf(this.zzb.zze().zzc(this.zzb.zzg().zzad(), zzbh.zzam)));
                this.zza.notify();
            } catch (Throwable th) {
                this.zza.notify();
                throw th;
            }
        }
    }
}
