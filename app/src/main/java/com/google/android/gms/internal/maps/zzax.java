package com.google.android.gms.internal.maps;

/* JADX INFO: loaded from: classes4.dex */
final class zzax extends zzau {
    private final zzaz zza;

    zzax(zzaz zzazVar, int i) {
        super(zzazVar.size(), i);
        this.zza = zzazVar;
    }

    @Override // com.google.android.gms.internal.maps.zzau
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}
