package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes5.dex */
final class zzlj implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzn zzc;
    private final /* synthetic */ boolean zzd;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdi zze;
    private final /* synthetic */ zzlf zzf;

    zzlj(zzlf zzlfVar, String str, String str2, zzn zznVar, boolean z, com.google.android.gms.internal.measurement.zzdi zzdiVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zznVar;
        this.zzd = z;
        this.zze = zzdiVar;
        this.zzf = zzlfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle = new Bundle();
        try {
            try {
                zzfq zzfqVar = this.zzf.zzb;
                if (zzfqVar == null) {
                    this.zzf.zzj().zzg().zza("Failed to get user properties; not connected to service", this.zza, this.zzb);
                    this.zzf.zzq().zza(this.zze, bundle);
                } else {
                    Preconditions.checkNotNull(this.zzc);
                    Bundle bundleZza = zznw.zza(zzfqVar.zza(this.zza, this.zzb, this.zzd, this.zzc));
                    this.zzf.zzaq();
                    this.zzf.zzq().zza(this.zze, bundleZza);
                }
            } catch (RemoteException e) {
                this.zzf.zzj().zzg().zza("Failed to get user properties; remote exception", this.zza, e);
                this.zzf.zzq().zza(this.zze, bundle);
            }
        } catch (Throwable th) {
            this.zzf.zzq().zza(this.zze, bundle);
            throw th;
        }
    }
}
