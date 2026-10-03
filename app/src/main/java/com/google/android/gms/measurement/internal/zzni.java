package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
final class zzni implements zzgh {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzng zzb;

    zzni(zzng zzngVar, String str) {
        this.zza = str;
        this.zzb = zzngVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgh
    public final void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.zzb.zza(true, i, th, bArr, this.zza);
    }
}
