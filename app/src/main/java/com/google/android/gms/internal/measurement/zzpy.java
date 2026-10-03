package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: loaded from: classes4.dex */
public final class zzpy implements Supplier<zzpx> {
    private static zzpy zza = new zzpy();
    private final Supplier<zzpx> zzb = Suppliers.ofInstance(new zzqa());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzpx get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzpx) zza.get()).zza();
    }
}
