package com.google.android.gms.measurement.internal;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes5.dex */
final class zzjm implements Executor {
    private final /* synthetic */ zzja zza;

    zzjm(zzja zzjaVar) {
        this.zza = zzjaVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.zza.zzl().zzb(runnable);
    }
}
