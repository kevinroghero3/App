package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: loaded from: classes4.dex */
public final class zzqk implements Supplier<zzqj> {
    private static zzqk zza = new zzqk();
    private final Supplier<zzqj> zzb = Suppliers.ofInstance(new zzqm());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzqj get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzqj) zza.get()).zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return ((zzqj) zza.get()).zzb();
    }
}
