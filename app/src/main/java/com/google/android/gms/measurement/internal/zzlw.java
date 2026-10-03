package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes5.dex */
final class zzlw implements Runnable {
    private final /* synthetic */ boolean zza = true;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzac zzd;
    private final /* synthetic */ zzac zze;
    private final /* synthetic */ zzlf zzf;

    zzlw(zzlf zzlfVar, boolean z, zzn zznVar, boolean z2, zzac zzacVar, zzac zzacVar2) {
        this.zzb = zznVar;
        this.zzc = z2;
        this.zzd = zzacVar;
        this.zze = zzacVar2;
        this.zzf = zzlfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfq zzfqVar = this.zzf.zzb;
        if (zzfqVar == null) {
            this.zzf.zzj().zzg().zza("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.zza) {
            Preconditions.checkNotNull(this.zzb);
            this.zzf.zza(zzfqVar, this.zzc ? null : this.zzd, this.zzb);
        } else {
            try {
                if (TextUtils.isEmpty(this.zze.zza)) {
                    Preconditions.checkNotNull(this.zzb);
                    zzfqVar.zza(this.zzd, this.zzb);
                } else {
                    zzfqVar.zza(this.zzd);
                }
            } catch (RemoteException e) {
                this.zzf.zzj().zzg().zza("Failed to send conditional user property to the service", e);
            }
        }
        this.zzf.zzaq();
    }
}
