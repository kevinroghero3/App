package com.google.mlkit.common.sdkinternal;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class LazyInstanceMap<K, V> {
    private final Map zza = new HashMap();

    protected abstract V create(@NonNull K k);

    public V get(@NonNull K k) {
        synchronized (this.zza) {
            if (this.zza.containsKey(k)) {
                return (V) this.zza.get(k);
            }
            V vCreate = create(k);
            this.zza.put(k, vCreate);
            return vCreate;
        }
    }
}
