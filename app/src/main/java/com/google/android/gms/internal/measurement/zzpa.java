package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: loaded from: classes4.dex */
public final class zzpa implements Supplier<zzoz> {
    private static zzpa zza = new zzpa();
    private final Supplier<zzoz> zzb = Suppliers.ofInstance(new zzpc());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzoz get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzoz) zza.get()).zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return ((zzoz) zza.get()).zzb();
    }
}
