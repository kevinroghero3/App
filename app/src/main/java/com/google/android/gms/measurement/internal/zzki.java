package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes5.dex */
final class zzki implements Runnable {
    private final /* synthetic */ Boolean zza;
    private final /* synthetic */ zzja zzb;

    zzki(zzja zzjaVar, Boolean bool) {
        this.zza = bool;
        this.zzb = zzjaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza(this.zza, true);
    }
}
