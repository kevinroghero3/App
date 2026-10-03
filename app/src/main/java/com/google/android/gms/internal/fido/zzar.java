package com.google.android.gms.internal.fido;

/* JADX INFO: loaded from: classes4.dex */
final class zzar extends zzao {
    private final zzat zza;

    zzar(zzat zzatVar, int i) {
        super(zzatVar.size(), i);
        this.zza = zzatVar;
    }

    @Override // com.google.android.gms.internal.fido.zzao
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}
