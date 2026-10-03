package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: loaded from: classes4.dex */
public final class zzoc implements Supplier<zzob> {
    private static zzoc zza = new zzoc();
    private final Supplier<zzob> zzb = Suppliers.ofInstance(new zzoe());

    @SideEffectFree
    public static long zza() {
        return ((zzob) zza.get()).zza();
    }

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzob get() {
        return this.zzb.get();
    }
}
