package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes4.dex */
final class zzil extends zziu {
    private final int zzc;
    private final int zzd;

    @Override // com.google.android.gms.internal.measurement.zziu, com.google.android.gms.internal.measurement.zzih
    public final byte zza(int i) {
        int iZzb = zzb();
        if (((iZzb - (i + 1)) | i) >= 0) {
            return this.zzb[this.zzc + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + iZzb);
    }

    @Override // com.google.android.gms.internal.measurement.zziu, com.google.android.gms.internal.measurement.zzih
    final byte zzb(int i) {
        return this.zzb[this.zzc + i];
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    protected final int zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zziu, com.google.android.gms.internal.measurement.zzih
    public final int zzb() {
        return this.zzd;
    }

    zzil(byte[] bArr, int i, int i2) {
        super(bArr);
        zzih.zza(i, i + i2, bArr.length);
        this.zzc = i;
        this.zzd = i2;
    }
}
