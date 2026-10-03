package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* JADX INFO: loaded from: classes5.dex */
final class zzmc implements Runnable {
    private final /* synthetic */ ComponentName zza;
    private final /* synthetic */ zzma zzb;

    zzmc(zzma zzmaVar, ComponentName componentName) {
        this.zza = componentName;
        this.zzb = zzmaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlf.zza(this.zzb.zza, this.zza);
    }
}
