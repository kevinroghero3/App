package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: loaded from: classes4.dex */
public final class zzql implements Supplier<zzqo> {
    private static zzql zza = new zzql();
    private final Supplier<zzqo> zzb = Suppliers.ofInstance(new zzqn());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzqo get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzqo) zza.get()).zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return ((zzqo) zza.get()).zzb();
    }

    @SideEffectFree
    public static boolean zzc() {
        return ((zzqo) zza.get()).zzc();
    }

    @SideEffectFree
    public static boolean zzd() {
        return ((zzqo) zza.get()).zzd();
    }
}
