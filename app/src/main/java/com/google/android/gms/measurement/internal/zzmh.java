package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes5.dex */
final class zzmh implements Runnable {
    private final /* synthetic */ zzma zza;

    zzmh(zzma zzmaVar) {
        this.zza = zzmaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zza.zzb = null;
        this.zza.zza.zzap();
    }
}
