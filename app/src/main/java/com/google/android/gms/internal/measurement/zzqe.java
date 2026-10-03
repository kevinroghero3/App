package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: loaded from: classes4.dex */
public final class zzqe implements Supplier<zzqd> {
    private static zzqe zza = new zzqe();
    private final Supplier<zzqd> zzb = Suppliers.ofInstance(new zzqg());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzqd get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzqd) zza.get()).zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return ((zzqd) zza.get()).zzb();
    }
}
