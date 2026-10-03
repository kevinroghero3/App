package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: loaded from: classes5.dex */
final class zzkz implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zzkx zzb;
    private final /* synthetic */ zzkx zzc;
    private final /* synthetic */ long zzd;
    private final /* synthetic */ zzkw zze;

    zzkz(zzkw zzkwVar, Bundle bundle, zzkx zzkxVar, zzkx zzkxVar2, long j) {
        this.zza = bundle;
        this.zzb = zzkxVar;
        this.zzc = zzkxVar2;
        this.zzd = j;
        this.zze = zzkwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkw.zza(this.zze, this.zza, this.zzb, this.zzc, this.zzd);
    }
}
