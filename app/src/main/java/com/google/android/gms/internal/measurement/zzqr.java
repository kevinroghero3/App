package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: loaded from: classes4.dex */
public final class zzqr implements Supplier<zzqu> {
    private static zzqr zza = new zzqr();
    private final Supplier<zzqu> zzb = Suppliers.ofInstance(new zzqt());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzqu get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzqu) zza.get()).zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return ((zzqu) zza.get()).zzb();
    }

    @SideEffectFree
    public static boolean zzc() {
        return ((zzqu) zza.get()).zzc();
    }
}
