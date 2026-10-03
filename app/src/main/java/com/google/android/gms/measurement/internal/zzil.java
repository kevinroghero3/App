package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
final class zzil implements Callable<List<zznx>> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzhs zzb;

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zznx> call() throws Exception {
        this.zzb.zza.zzr();
        return this.zzb.zza.zzf().zzj(this.zza);
    }

    zzil(zzhs zzhsVar, String str) {
        this.zza = str;
        this.zzb = zzhsVar;
    }
}
