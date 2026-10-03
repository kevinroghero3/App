package com.google.android.gms.measurement.internal;

import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
final class zzhg implements com.google.android.gms.internal.measurement.zzo {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzgy zzb;

    @Override // com.google.android.gms.internal.measurement.zzo
    public final String zza(String str) {
        Map map = (Map) this.zzb.zzc.get(this.zza);
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return (String) map.get(str);
    }

    zzhg(zzgy zzgyVar, String str) {
        this.zza = str;
        this.zzb = zzgyVar;
    }
}
