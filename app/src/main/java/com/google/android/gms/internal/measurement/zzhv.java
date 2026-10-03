package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableSetMultimap;

/* JADX INFO: loaded from: classes4.dex */
public final class zzhv {
    public static final Supplier<ImmutableSetMultimap<String, String>> zza = Suppliers.memoize(new Supplier() { // from class: com.google.android.gms.internal.measurement.zzhx
        @Override // com.google.common.base.Supplier
        public final Object get() {
            return new ImmutableSetMultimap.Builder().build();
        }
    });
}
