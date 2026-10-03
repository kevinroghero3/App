package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes5.dex */
final class zzhj implements Thread.UncaughtExceptionHandler {
    private final String zza;
    private final /* synthetic */ zzhh zzb;

    public zzhj(zzhh zzhhVar, String str) {
        this.zzb = zzhhVar;
        Preconditions.checkNotNull(str);
        this.zza = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        synchronized (this) {
            this.zzb.zzj().zzg().zza(this.zza, th);
        }
    }
}
