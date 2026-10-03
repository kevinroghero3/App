package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes5.dex */
final class zzhw implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzhs zzb;

    zzhw(zzhs zzhsVar, zzn zznVar) {
        this.zza = zznVar;
        this.zzb = zzhsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzr();
        zzng zzngVar = this.zzb.zza;
        zzn zznVar = this.zza;
        zzngVar.zzl().zzt();
        zzngVar.zzs();
        Preconditions.checkNotEmpty(zznVar.zza);
        zzngVar.zza(zznVar);
    }
}
