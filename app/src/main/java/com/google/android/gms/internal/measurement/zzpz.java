package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: loaded from: classes4.dex */
public final class zzpz implements Supplier<zzqc> {
    private static zzpz zza = new zzpz();
    private final Supplier<zzqc> zzb = Suppliers.ofInstance(new zzqb());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzqc get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzqc) zza.get()).zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return ((zzqc) zza.get()).zzb();
    }

    @SideEffectFree
    public static boolean zzc() {
        return ((zzqc) zza.get()).zzc();
    }

    @SideEffectFree
    public static boolean zzd() {
        return ((zzqc) zza.get()).zzd();
    }

    @SideEffectFree
    public static boolean zze() {
        return ((zzqc) zza.get()).zze();
    }

    @SideEffectFree
    public static boolean zzf() {
        return ((zzqc) zza.get()).zzf();
    }

    @SideEffectFree
    public static boolean zzg() {
        return ((zzqc) zza.get()).zzg();
    }

    @SideEffectFree
    public static boolean zzh() {
        return ((zzqc) zza.get()).zzh();
    }

    @SideEffectFree
    public static boolean zzi() {
        return ((zzqc) zza.get()).zzi();
    }
}
