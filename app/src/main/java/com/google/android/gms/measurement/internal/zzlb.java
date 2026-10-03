package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes5.dex */
final class zzlb implements Runnable {
    private final /* synthetic */ zzkw zza;

    zzlb(zzkw zzkwVar) {
        this.zza = zzkwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkw zzkwVar = this.zza;
        zzkwVar.zza = zzkwVar.zzh;
    }
}
