package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: loaded from: classes4.dex */
public final class zzqq implements Supplier<zzqp> {
    private static zzqq zza = new zzqq();
    private final Supplier<zzqp> zzb = Suppliers.ofInstance(new zzqs());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzqp get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzqp) zza.get()).zza();
    }
}
