package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzqf;

/* JADX INFO: loaded from: classes5.dex */
final class zzmt implements Runnable {
    long zza;
    long zzb;
    final /* synthetic */ zzmq zzc;

    zzmt(zzmq zzmqVar, long j, long j2) {
        this.zzc = zzmqVar;
        this.zza = j;
        this.zzb = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzms
            @Override // java.lang.Runnable
            public final void run() {
                zzmt zzmtVar = this.zza;
                zzmq zzmqVar = zzmtVar.zzc;
                long j = zzmtVar.zza;
                long j2 = zzmtVar.zzb;
                zzmqVar.zza.zzt();
                zzmqVar.zza.zzj().zzc().zza("Application going to the background");
                zzmqVar.zza.zzk().zzn.zza(true);
                zzmqVar.zza.zza(true);
                if (!zzmqVar.zza.zze().zzv()) {
                    zzmqVar.zza.zzb.zzb(j2);
                    zzmqVar.zza.zza(false, false, j2);
                }
                if (zzqf.zza() && zzmqVar.zza.zze().zza(zzbh.zzcf)) {
                    zzmqVar.zza.zzj().zzn().zza("Application backgrounded at: timestamp_millis", Long.valueOf(j));
                } else {
                    zzmqVar.zza.zzm().zza("auto", "_ab", j, new Bundle());
                }
            }
        });
    }
}
