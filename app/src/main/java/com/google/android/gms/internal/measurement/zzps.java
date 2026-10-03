package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: loaded from: classes4.dex */
public final class zzps implements Supplier<zzpr> {
    private static zzps zza = new zzps();
    private final Supplier<zzpr> zzb = Suppliers.ofInstance(new zzpu());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzpr get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzpr) zza.get()).zza();
    }
}
