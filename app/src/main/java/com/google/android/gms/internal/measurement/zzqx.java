package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: loaded from: classes4.dex */
public final class zzqx implements Supplier<zzra> {
    private static zzqx zza = new zzqx();
    private final Supplier<zzra> zzb = Suppliers.ofInstance(new zzqz());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzra get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzra) zza.get()).zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return ((zzra) zza.get()).zzb();
    }

    @SideEffectFree
    public static boolean zzc() {
        return ((zzra) zza.get()).zzc();
    }
}
