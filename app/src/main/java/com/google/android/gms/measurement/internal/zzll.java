package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
final class zzll implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ Bundle zzc;
    private final /* synthetic */ zzlf zzd;

    zzll(zzlf zzlfVar, AtomicReference atomicReference, zzn zznVar, Bundle bundle) {
        this.zza = atomicReference;
        this.zzb = zznVar;
        this.zzc = bundle;
        this.zzd = zzlfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                try {
                    zzfq zzfqVar = this.zzd.zzb;
                    if (zzfqVar == null) {
                        this.zzd.zzj().zzg().zza("Failed to get trigger URIs; not connected to service");
                        this.zza.notify();
                    } else {
                        Preconditions.checkNotNull(this.zzb);
                        this.zza.set(zzfqVar.zza(this.zzb, this.zzc));
                        this.zzd.zzaq();
                        this.zza.notify();
                    }
                } catch (Throwable th) {
                    this.zza.notify();
                    throw th;
                }
            } catch (RemoteException e) {
                this.zzd.zzj().zzg().zza("Failed to get trigger URIs; remote exception", e);
                this.zza.notify();
            }
        }
    }
}
