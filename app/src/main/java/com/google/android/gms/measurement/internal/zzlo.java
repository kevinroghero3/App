package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes5.dex */
final class zzlo implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzlf zzb;

    zzlo(zzlf zzlfVar, zzn zznVar) {
        this.zza = zznVar;
        this.zzb = zzlfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfq zzfqVar = this.zzb.zzb;
        if (zzfqVar == null) {
            this.zzb.zzj().zzg().zza("Discarding data. Failed to send app launch");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzfqVar.zzc(this.zza);
            this.zzb.zzh().zzac();
            this.zzb.zza(zzfqVar, (AbstractSafeParcelable) null, this.zza);
            this.zzb.zzaq();
        } catch (RemoteException e) {
            this.zzb.zzj().zzg().zza("Failed to send app launch to the service", e);
        }
    }
}
