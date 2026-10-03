package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
final class zzif implements Callable<zzal> {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzhs zzb;

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzal call() throws Exception {
        this.zzb.zza.zzr();
        return new zzal(this.zzb.zza.zza(this.zza.zza));
    }

    zzif(zzhs zzhsVar, zzn zznVar) {
        this.zza = zznVar;
        this.zzb = zzhsVar;
    }
}
