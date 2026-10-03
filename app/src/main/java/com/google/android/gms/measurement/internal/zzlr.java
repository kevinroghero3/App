package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes5.dex */
final class zzlr implements Runnable {
    private final /* synthetic */ zzkx zza;
    private final /* synthetic */ zzlf zzb;

    zzlr(zzlf zzlfVar, zzkx zzkxVar) {
        this.zza = zzkxVar;
        this.zzb = zzlfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfq zzfqVar = this.zzb.zzb;
        if (zzfqVar == null) {
            this.zzb.zzj().zzg().zza("Failed to send current screen to service");
            return;
        }
        try {
            zzkx zzkxVar = this.zza;
            if (zzkxVar == null) {
                zzfqVar.zza(0L, (String) null, (String) null, this.zzb.zza().getPackageName());
            } else {
                zzfqVar.zza(zzkxVar.zzc, zzkxVar.zza, zzkxVar.zzb, this.zzb.zza().getPackageName());
            }
            this.zzb.zzaq();
        } catch (RemoteException e) {
            this.zzb.zzj().zzg().zza("Failed to send current screen to the service", e);
        }
    }
}
