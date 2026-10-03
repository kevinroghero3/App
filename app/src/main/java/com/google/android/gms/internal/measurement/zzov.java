package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: loaded from: classes4.dex */
public final class zzov implements Supplier<zzoy> {
    private static zzov zza = new zzov();
    private final Supplier<zzoy> zzb = Suppliers.ofInstance(new zzox());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzoy get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzoy) zza.get()).zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return ((zzoy) zza.get()).zzb();
    }

    @SideEffectFree
    public static boolean zzc() {
        return ((zzoy) zza.get()).zzc();
    }

    @SideEffectFree
    public static boolean zzd() {
        return ((zzoy) zza.get()).zzd();
    }
}
