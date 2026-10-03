package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes5.dex */
final class zzjq implements Runnable {
    private final /* synthetic */ zzja zza;

    zzjq(zzja zzjaVar) {
        this.zza = zzjaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzb.zza();
    }
}
