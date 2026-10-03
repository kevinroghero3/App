package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: loaded from: classes4.dex */
public final class zzrc implements Supplier<zzrb> {
    private static zzrc zza = new zzrc();
    private final Supplier<zzrb> zzb = Suppliers.ofInstance(new zzre());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzrb get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzrb) zza.get()).zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return ((zzrb) zza.get()).zzb();
    }
}
