package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes5.dex */
final class zzln implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzlf zzb;

    zzln(zzlf zzlfVar, zzn zznVar) {
        this.zza = zznVar;
        this.zzb = zzlfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfq zzfqVar = this.zzb.zzb;
        if (zzfqVar == null) {
            this.zzb.zzj().zzg().zza("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzfqVar.zzd(this.zza);
        } catch (RemoteException e) {
            this.zzb.zzj().zzg().zza("Failed to reset data on the service: remote exception", e);
        }
        this.zzb.zzaq();
    }
}
