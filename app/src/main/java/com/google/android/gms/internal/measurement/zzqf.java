package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: loaded from: classes4.dex */
public final class zzqf implements Supplier<zzqi> {
    private static zzqf zza = new zzqf();
    private final Supplier<zzqi> zzb = Suppliers.ofInstance(new zzqh());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzqi get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzqi) zza.get()).zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return ((zzqi) zza.get()).zzb();
    }
}
