package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* JADX INFO: loaded from: classes5.dex */
final class zzme implements Runnable {
    private final /* synthetic */ zzma zza;

    zzme(zzma zzmaVar) {
        this.zza = zzmaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlf.zza(this.zza.zza, new ComponentName(this.zza.zza.zza(), "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
