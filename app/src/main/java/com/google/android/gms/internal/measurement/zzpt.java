package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: loaded from: classes4.dex */
public final class zzpt implements Supplier<zzpw> {
    private static zzpt zza = new zzpt();
    private final Supplier<zzpw> zzb = Suppliers.ofInstance(new zzpv());

    @SideEffectFree
    public static double zza() {
        return ((zzpw) zza.get()).zza();
    }

    @SideEffectFree
    public static long zzb() {
        return ((zzpw) zza.get()).zzb();
    }

    @SideEffectFree
    public static long zzc() {
        return ((zzpw) zza.get()).zzc();
    }

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzpw get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static String zzd() {
        return ((zzpw) zza.get()).zzd();
    }

    @SideEffectFree
    public static boolean zze() {
        return ((zzpw) zza.get()).zze();
    }
}
