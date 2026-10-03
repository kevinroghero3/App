package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
final class zzly implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzn zzc;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdi zzd;
    private final /* synthetic */ zzlf zze;

    zzly(zzlf zzlfVar, String str, String str2, zzn zznVar, com.google.android.gms.internal.measurement.zzdi zzdiVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zznVar;
        this.zzd = zzdiVar;
        this.zze = zzlfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            try {
                zzfq zzfqVar = this.zze.zzb;
                if (zzfqVar == null) {
                    this.zze.zzj().zzg().zza("Failed to get conditional properties; not connected to service", this.zza, this.zzb);
                    this.zze.zzq().zza(this.zzd, arrayList);
                } else {
                    Preconditions.checkNotNull(this.zzc);
                    ArrayList<Bundle> arrayListZzb = zznw.zzb(zzfqVar.zza(this.zza, this.zzb, this.zzc));
                    this.zze.zzaq();
                    this.zze.zzq().zza(this.zzd, arrayListZzb);
                }
            } catch (RemoteException e) {
                this.zze.zzj().zzg().zza("Failed to get conditional properties; remote exception", this.zza, this.zzb, e);
                this.zze.zzq().zza(this.zzd, arrayList);
            }
        } catch (Throwable th) {
            this.zze.zzq().zza(this.zzd, arrayList);
            throw th;
        }
    }
}
