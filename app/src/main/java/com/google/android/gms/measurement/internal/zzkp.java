package com.google.android.gms.measurement.internal;

import android.net.Uri;

/* JADX INFO: loaded from: classes5.dex */
final class zzkp implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ Uri zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzkm zze;

    zzkp(zzkm zzkmVar, boolean z, Uri uri, String str, String str2) {
        this.zza = z;
        this.zzb = uri;
        this.zzc = str;
        this.zzd = str2;
        this.zze = zzkmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkm.zza(this.zze, this.zza, this.zzb, this.zzc, this.zzd);
    }
}
