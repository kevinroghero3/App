package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes5.dex */
final class zzls implements Runnable {
    private final /* synthetic */ zzbf zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdi zzc;
    private final /* synthetic */ zzlf zzd;

    zzls(zzlf zzlfVar, zzbf zzbfVar, String str, com.google.android.gms.internal.measurement.zzdi zzdiVar) {
        this.zza = zzbfVar;
        this.zzb = str;
        this.zzc = zzdiVar;
        this.zzd = zzlfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            try {
                zzfq zzfqVar = this.zzd.zzb;
                if (zzfqVar == null) {
                    this.zzd.zzj().zzg().zza("Discarding data. Failed to send event to service to bundle");
                    this.zzd.zzq().zza(this.zzc, (byte[]) null);
                } else {
                    byte[] bArrZza = zzfqVar.zza(this.zza, this.zzb);
                    this.zzd.zzaq();
                    this.zzd.zzq().zza(this.zzc, bArrZza);
                }
            } catch (RemoteException e) {
                this.zzd.zzj().zzg().zza("Failed to send event to the service to bundle", e);
                this.zzd.zzq().zza(this.zzc, (byte[]) null);
            }
        } catch (Throwable th) {
            this.zzd.zzq().zza(this.zzc, (byte[]) null);
            throw th;
        }
    }
}
