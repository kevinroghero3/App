package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
final class zznk implements Callable<String> {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzng zzb;

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        if (!this.zzb.zzb((String) Preconditions.checkNotNull(this.zza.zza)).zzj() || !zzis.zzb(this.zza.zzt).zzj()) {
            this.zzb.zzj().zzp().zza("Analytics storage consent denied. Returning null app instance id");
            return null;
        }
        zzf zzfVarZza = this.zzb.zza(this.zza);
        if (zzfVarZza != null) {
            return zzfVarZza.zzad();
        }
        this.zzb.zzj().zzu().zza("App info was null when attempting to get app instance id");
        return null;
    }

    zznk(zzng zzngVar, zzn zznVar) {
        this.zza = zznVar;
        this.zzb = zzngVar;
    }
}
