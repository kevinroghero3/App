package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
final class zzmb implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzn zze;
    private final /* synthetic */ boolean zzf;
    private final /* synthetic */ zzlf zzg;

    zzmb(zzlf zzlfVar, AtomicReference atomicReference, String str, String str2, String str3, zzn zznVar, boolean z) {
        this.zza = atomicReference;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = zznVar;
        this.zzf = z;
        this.zzg = zzlfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                try {
                    zzfq zzfqVar = this.zzg.zzb;
                    if (zzfqVar == null) {
                        this.zzg.zzj().zzg().zza("(legacy) Failed to get user properties; not connected to service", zzgb.zza(this.zzb), this.zzc, this.zzd);
                        this.zza.set(Collections.emptyList());
                        this.zza.notify();
                    } else {
                        if (TextUtils.isEmpty(this.zzb)) {
                            Preconditions.checkNotNull(this.zze);
                            this.zza.set(zzfqVar.zza(this.zzc, this.zzd, this.zzf, this.zze));
                        } else {
                            this.zza.set(zzfqVar.zza(this.zzb, this.zzc, this.zzd, this.zzf));
                        }
                        this.zzg.zzaq();
                        this.zza.notify();
                    }
                } catch (Throwable th) {
                    this.zza.notify();
                    throw th;
                }
            } catch (RemoteException e) {
                this.zzg.zzj().zzg().zza("(legacy) Failed to get user properties; remote exception", zzgb.zza(this.zzb), this.zzc, e);
                this.zza.set(Collections.emptyList());
                this.zza.notify();
            }
        }
    }
}
