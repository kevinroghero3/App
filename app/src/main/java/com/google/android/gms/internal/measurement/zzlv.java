package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes4.dex */
final class zzlv {
    private static final zzlv zza = new zzlv();
    private final ConcurrentMap<Class<?>, zzlz<?>> zzc = new ConcurrentHashMap();
    private final zzly zzb = new zzkv();

    public static zzlv zza() {
        return zza;
    }

    public final <T> zzlz<T> zza(Class<T> cls) {
        zzjx.zza(cls, "messageType");
        zzlz<T> zzlzVar = (zzlz) this.zzc.get(cls);
        if (zzlzVar != null) {
            return zzlzVar;
        }
        zzlz<T> zzlzVarZza = this.zzb.zza(cls);
        zzjx.zza(cls, "messageType");
        zzjx.zza(zzlzVarZza, "schema");
        zzlz<T> zzlzVar2 = (zzlz) this.zzc.putIfAbsent(cls, zzlzVarZza);
        return zzlzVar2 != null ? zzlzVar2 : zzlzVarZza;
    }

    public final <T> zzlz<T> zza(T t) {
        return zza((Class) t.getClass());
    }

    private zzlv() {
    }
}
