package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes5.dex */
final class zzlq implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ Bundle zzb;
    private final /* synthetic */ zzlf zzc;

    zzlq(zzlf zzlfVar, zzn zznVar, Bundle bundle) {
        this.zza = zznVar;
        this.zzb = bundle;
        this.zzc = zzlfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfq zzfqVar = this.zzc.zzb;
        if (zzfqVar == null) {
            this.zzc.zzj().zzg().zza("Failed to send default event parameters to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzfqVar.zza(this.zzb, this.zza);
        } catch (RemoteException e) {
            this.zzc.zzj().zzg().zza("Failed to send default event parameters to service", e);
        }
    }
}
