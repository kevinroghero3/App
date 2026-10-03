package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: loaded from: classes4.dex */
public final class zzrd implements Supplier<zzrg> {
    private static zzrd zza = new zzrd();
    private final Supplier<zzrg> zzb = Suppliers.ofInstance(new zzrf());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzrg get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzrg) zza.get()).zza();
    }
}
