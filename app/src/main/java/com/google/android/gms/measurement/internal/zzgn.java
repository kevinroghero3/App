package com.google.android.gms.measurement.internal;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
final class zzgn {
    private final zzir zza;

    static zzgn zza(String str) {
        return new zzgn((TextUtils.isEmpty(str) || str.length() > 1) ? zzir.UNINITIALIZED : zzis.zza(str.charAt(0)));
    }

    final zzir zza() {
        return this.zza;
    }

    final String zzb() {
        return String.valueOf(zzis.zza(this.zza));
    }

    zzgn(zzir zzirVar) {
        this.zza = zzirVar;
    }
}
