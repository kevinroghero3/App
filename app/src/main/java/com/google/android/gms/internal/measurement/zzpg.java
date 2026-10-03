package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: loaded from: classes4.dex */
public final class zzpg implements Supplier<zzpf> {
    private static zzpg zza = new zzpg();
    private final Supplier<zzpf> zzb = Suppliers.ofInstance(new zzpi());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzpf get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzpf) zza.get()).zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return ((zzpf) zza.get()).zzb();
    }

    @SideEffectFree
    public static boolean zzc() {
        return ((zzpf) zza.get()).zzc();
    }
}
