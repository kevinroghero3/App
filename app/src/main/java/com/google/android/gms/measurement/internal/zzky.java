package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: loaded from: classes5.dex */
final class zzky implements Runnable {
    private final /* synthetic */ zzkx zza;
    private final /* synthetic */ zzkx zzb;
    private final /* synthetic */ long zzc;
    private final /* synthetic */ boolean zzd;
    private final /* synthetic */ zzkw zze;

    zzky(zzkw zzkwVar, zzkx zzkxVar, zzkx zzkxVar2, long j, boolean z) {
        this.zza = zzkxVar;
        this.zzb = zzkxVar2;
        this.zzc = j;
        this.zzd = z;
        this.zze = zzkwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zze.zza(this.zza, this.zzb, this.zzc, this.zzd, (Bundle) null);
    }
}
