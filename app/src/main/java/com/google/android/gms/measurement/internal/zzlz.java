package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
final class zzlz implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzn zze;
    private final /* synthetic */ zzlf zzf;

    zzlz(zzlf zzlfVar, AtomicReference atomicReference, String str, String str2, String str3, zzn zznVar) {
        this.zza = atomicReference;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = zznVar;
        this.zzf = zzlfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                try {
                    zzfq zzfqVar = this.zzf.zzb;
                    if (zzfqVar == null) {
                        this.zzf.zzj().zzg().zza("(legacy) Failed to get conditional properties; not connected to service", zzgb.zza(this.zzb), this.zzc, this.zzd);
                        this.zza.set(Collections.emptyList());
                        this.zza.notify();
                    } else {
                        if (TextUtils.isEmpty(this.zzb)) {
                            Preconditions.checkNotNull(this.zze);
                            this.zza.set(zzfqVar.zza(this.zzc, this.zzd, this.zze));
                        } else {
                            this.zza.set(zzfqVar.zza(this.zzb, this.zzc, this.zzd));
                        }
                        this.zzf.zzaq();
                        this.zza.notify();
                    }
                } catch (Throwable th) {
                    this.zza.notify();
                    throw th;
                }
            } catch (RemoteException e) {
                this.zzf.zzj().zzg().zza("(legacy) Failed to get conditional properties; remote exception", zzgb.zza(this.zzb), this.zzc, e);
                this.zza.set(Collections.emptyList());
                this.zza.notify();
            }
        }
    }
}
