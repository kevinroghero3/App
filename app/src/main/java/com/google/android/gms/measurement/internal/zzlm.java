package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
final class zzlm implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zzlf zzc;

    zzlm(zzlf zzlfVar, AtomicReference atomicReference, zzn zznVar) {
        this.zza = atomicReference;
        this.zzb = zznVar;
        this.zzc = zzlfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                try {
                    if (!this.zzc.zzk().zzn().zzj()) {
                        this.zzc.zzj().zzv().zza("Analytics storage consent denied; will not get app instance id");
                        this.zzc.zzm().zza((String) null);
                        this.zzc.zzk().zze.zza(null);
                        this.zza.set(null);
                        this.zza.notify();
                        return;
                    }
                    zzfq zzfqVar = this.zzc.zzb;
                    if (zzfqVar == null) {
                        this.zzc.zzj().zzg().zza("Failed to get app instance id");
                        this.zza.notify();
                        return;
                    }
                    Preconditions.checkNotNull(this.zzb);
                    this.zza.set(zzfqVar.zzb(this.zzb));
                    String str = (String) this.zza.get();
                    if (str != null) {
                        this.zzc.zzm().zza(str);
                        this.zzc.zzk().zze.zza(str);
                    }
                    this.zzc.zzaq();
                    this.zza.notify();
                } catch (Throwable th) {
                    this.zza.notify();
                    throw th;
                }
            } catch (RemoteException e) {
                this.zzc.zzj().zzg().zza("Failed to get app instance id", e);
                this.zza.notify();
            }
        }
    }
}
