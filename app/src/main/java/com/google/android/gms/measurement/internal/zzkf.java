package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzqk;

/* JADX INFO: loaded from: classes5.dex */
final class zzkf implements Runnable {
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdi zza;
    private final /* synthetic */ zzja zzb;

    zzkf(zzja zzjaVar, com.google.android.gms.internal.measurement.zzdi zzdiVar) {
        this.zza = zzdiVar;
        this.zzb = zzjaVar;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0077  */
    /* JADX WARN: Code duplicated, block: B:25:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    public final void run() {
        Long lValueOf;
        zzmp zzmpVarZzp = this.zzb.zzp();
        if (!zzqk.zza() || !zzmpVarZzp.zze().zza(zzbh.zzby)) {
            zzmpVarZzp.zzj().zzv().zza("getSessionId has been disabled.");
        } else {
            if (zzmpVarZzp.zzk().zzn().zzj()) {
                if (!zzmpVarZzp.zzk().zza(zzmpVarZzp.zzb().currentTimeMillis()) && zzmpVarZzp.zzk().zzl.zza() != 0) {
                    lValueOf = Long.valueOf(zzmpVarZzp.zzk().zzl.zza());
                }
                if (lValueOf != null) {
                    this.zzb.zzu.zzt().zza(this.zza, lValueOf.longValue());
                }
                try {
                    this.zza.zza(null);
                } catch (RemoteException e) {
                    this.zzb.zzu.zzj().zzg().zza("getSessionId failed with exception", e);
                    return;
                }
            }
            zzmpVarZzp.zzj().zzv().zza("Analytics storage consent denied; will not get session id");
        }
        lValueOf = null;
        if (lValueOf != null) {
            this.zzb.zzu.zzt().zza(this.zza, lValueOf.longValue());
        } else {
            this.zza.zza(null);
        }
    }
}
