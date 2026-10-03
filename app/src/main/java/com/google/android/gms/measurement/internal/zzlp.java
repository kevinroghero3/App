package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes5.dex */
final class zzlp implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdi zzb;
    private final /* synthetic */ zzlf zzc;

    zzlp(zzlf zzlfVar, zzn zznVar, com.google.android.gms.internal.measurement.zzdi zzdiVar) {
        this.zza = zznVar;
        this.zzb = zzdiVar;
        this.zzc = zzlfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            try {
                if (!this.zzc.zzk().zzn().zzj()) {
                    this.zzc.zzj().zzv().zza("Analytics storage consent denied; will not get app instance id");
                    this.zzc.zzm().zza((String) null);
                    this.zzc.zzk().zze.zza(null);
                    this.zzc.zzq().zza(this.zzb, (String) null);
                    return;
                }
                zzfq zzfqVar = this.zzc.zzb;
                if (zzfqVar == null) {
                    this.zzc.zzj().zzg().zza("Failed to get app instance id");
                    this.zzc.zzq().zza(this.zzb, (String) null);
                    return;
                }
                Preconditions.checkNotNull(this.zza);
                String strZzb = zzfqVar.zzb(this.zza);
                if (strZzb != null) {
                    this.zzc.zzm().zza(strZzb);
                    this.zzc.zzk().zze.zza(strZzb);
                }
                this.zzc.zzaq();
                this.zzc.zzq().zza(this.zzb, strZzb);
            } catch (RemoteException e) {
                this.zzc.zzj().zzg().zza("Failed to get app instance id", e);
                this.zzc.zzq().zza(this.zzb, (String) null);
            }
        } catch (Throwable th) {
            this.zzc.zzq().zza(this.zzb, (String) null);
            throw th;
        }
    }
}
