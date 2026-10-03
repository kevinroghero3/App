package com.google.android.gms.measurement.internal;

import android.util.SparseArray;
import com.google.common.util.concurrent.FutureCallback;

/* JADX INFO: loaded from: classes5.dex */
final class zzjp implements FutureCallback<Object> {
    private final /* synthetic */ zzmy zza;
    private final /* synthetic */ zzja zzb;

    zzjp(zzja zzjaVar, zzmy zzmyVar) {
        this.zza = zzmyVar;
        this.zzb = zzjaVar;
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onFailure(Throwable th) {
        this.zzb.zzt();
        this.zzb.zzh = false;
        if (!this.zzb.zze().zza(zzbh.zzcl)) {
            this.zzb.zzap();
            this.zzb.zzj().zzg().zza("registerTriggerAsync failed with throwable", th);
            return;
        }
        this.zzb.zzaj().add(this.zza);
        if (this.zzb.zzi > 64) {
            this.zzb.zzi = 1;
            this.zzb.zzj().zzu().zza("registerTriggerAsync failed. May try later. App ID, throwable", zzgb.zza(this.zzb.zzg().zzad()), zzgb.zza(th.toString()));
            return;
        }
        this.zzb.zzj().zzu().zza("registerTriggerAsync failed. App ID, delay in seconds, throwable", zzgb.zza(this.zzb.zzg().zzad()), zzgb.zza(String.valueOf(this.zzb.zzi)), zzgb.zza(th.toString()));
        zzja zzjaVar = this.zzb;
        zzja.zzb(zzjaVar, zzjaVar.zzi);
        this.zzb.zzi <<= 1;
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onSuccess(Object obj) {
        this.zzb.zzt();
        if (this.zzb.zze().zza(zzbh.zzcl)) {
            SparseArray<Long> sparseArrayZzh = this.zzb.zzk().zzh();
            zzmy zzmyVar = this.zza;
            sparseArrayZzh.put(zzmyVar.zzc, Long.valueOf(zzmyVar.zzb));
            this.zzb.zzk().zza(sparseArrayZzh);
            this.zzb.zzh = false;
            this.zzb.zzi = 1;
            this.zzb.zzj().zzc().zza("Successfully registered trigger URI", this.zza.zza);
            this.zzb.zzap();
            return;
        }
        this.zzb.zzh = false;
        this.zzb.zzap();
        this.zzb.zzj().zzc().zza("registerTriggerAsync ran. uri", this.zza.zza);
    }
}
