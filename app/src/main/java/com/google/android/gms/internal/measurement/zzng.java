package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes4.dex */
abstract class zzng {
    zzng() {
    }

    abstract int zza(int i, byte[] bArr, int i2, int i3);

    abstract int zza(String str, byte[] bArr, int i, int i2);

    abstract String zza(byte[] bArr, int i, int i2) throws zzkc;

    final boolean zzb(byte[] bArr, int i, int i2) {
        return zza(0, bArr, i, i2) == 0;
    }
}
