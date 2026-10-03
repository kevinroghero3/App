package com.google.android.gms.measurement.internal;

import com.facebook.appevents.AppEventsConstants;
import java.util.EnumMap;

/* JADX INFO: loaded from: classes4.dex */
final class zzaj {
    private final EnumMap<zzis.zza, zzai> zza;

    public final zzai zza(zzis.zza zzaVar) {
        zzai zzaiVar = this.zza.get(zzaVar);
        return zzaiVar == null ? zzai.UNSET : zzaiVar;
    }

    public static zzaj zza(String str) {
        EnumMap enumMap = new EnumMap(zzis.zza.class);
        if (str.length() >= zzis.zza.values().length) {
            int i = 0;
            if (str.charAt(0) == '1') {
                zzis.zza[] zzaVarArrValues = zzis.zza.values();
                int length = zzaVarArrValues.length;
                int i2 = 1;
                while (i < length) {
                    enumMap.put(zzaVarArrValues[i], zzai.zza(str.charAt(i2)));
                    i++;
                    i2++;
                }
                return new zzaj(enumMap);
            }
        }
        return new zzaj();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(AppEventsConstants.EVENT_PARAM_VALUE_YES);
        for (zzis.zza zzaVar : zzis.zza.values()) {
            zzai zzaiVar = this.zza.get(zzaVar);
            if (zzaiVar == null) {
                zzaiVar = zzai.UNSET;
            }
            sb.append(zzaiVar.zzl);
        }
        return sb.toString();
    }

    zzaj() {
        this.zza = new EnumMap<>(zzis.zza.class);
    }

    private zzaj(EnumMap<zzis.zza, zzai> enumMap) {
        EnumMap<zzis.zza, zzai> enumMap2 = new EnumMap<>(zzis.zza.class);
        this.zza = enumMap2;
        enumMap2.putAll(enumMap);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x001b  */
    public final void zza(zzis.zza zzaVar, int i) {
        zzai zzaiVar = zzai.UNSET;
        if (i == -30) {
            zzaiVar = zzai.TCF;
        } else if (i == -20) {
            zzaiVar = zzai.API;
        } else if (i == -10) {
            zzaiVar = zzai.MANIFEST;
        } else if (i == 0) {
            zzaiVar = zzai.API;
        } else if (i == 30) {
            zzaiVar = zzai.INITIALIZATION;
        }
        this.zza.put(zzaVar, zzaiVar);
    }

    public final void zza(zzis.zza zzaVar, zzai zzaiVar) {
        this.zza.put(zzaVar, zzaiVar);
    }
}
