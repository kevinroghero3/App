package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
final class zzik extends zzim {
    private int zza = 0;
    private final int zzb;
    private final /* synthetic */ zzih zzc;

    @Override // com.google.android.gms.internal.measurement.zzin
    public final byte zza() {
        int i = this.zza;
        if (i >= this.zzb) {
            throw new NoSuchElementException();
        }
        this.zza = i + 1;
        return this.zzc.zzb(i);
    }

    zzik(zzih zzihVar) {
        this.zzc = zzihVar;
        this.zzb = zzihVar.zzb();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza < this.zzb;
    }
}
