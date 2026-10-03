package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public final class zzax {
    public static final zzax zza = new zzax(null, 100);
    private final int zzb;
    private final String zzc;
    private final Boolean zzd;
    private final String zze;
    private final EnumMap<zzis.zza, zzir> zzf;

    public final int zza() {
        return this.zzb;
    }

    public final int hashCode() {
        int i;
        Boolean bool = this.zzd;
        if (bool == null) {
            i = 3;
        } else {
            i = bool == Boolean.TRUE ? 7 : 13;
        }
        String str = this.zze;
        return this.zzc.hashCode() + (i * 29) + ((str == null ? 17 : str.hashCode()) * 137);
    }

    public final Bundle zzb() {
        Bundle bundle = new Bundle();
        Iterator it2 = this.zzf.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            String strZzb = zzis.zzb((zzir) entry.getValue());
            if (strZzb != null) {
                bundle.putString(((zzis.zza) entry.getKey()).zze, strZzb);
            }
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            bundle.putString("is_dma_region", bool.toString());
        }
        String str = this.zze;
        if (str != null) {
            bundle.putString("cps_display_str", str);
        }
        return bundle;
    }

    public static zzax zza(Bundle bundle, int i) {
        if (bundle == null) {
            return new zzax(null, i);
        }
        EnumMap enumMap = new EnumMap(zzis.zza.class);
        for (zzis.zza zzaVar : zzit.DMA.zza()) {
            enumMap.put(zzaVar, zzis.zza(bundle.getString(zzaVar.zze)));
        }
        return new zzax((EnumMap<zzis.zza, zzir>) enumMap, i, bundle.containsKey("is_dma_region") ? Boolean.valueOf(bundle.getString("is_dma_region")) : null, bundle.getString("cps_display_str"));
    }

    static zzax zza(zzir zzirVar, int i) {
        EnumMap enumMap = new EnumMap(zzis.zza.class);
        enumMap.put(zzis.zza.AD_USER_DATA, zzirVar);
        return new zzax((EnumMap<zzis.zza, zzir>) enumMap, -10, (Boolean) null, (String) null);
    }

    public static zzax zza(String str) {
        if (str == null || str.length() <= 0) {
            return zza;
        }
        String[] strArrSplit = str.split(":");
        int i = Integer.parseInt(strArrSplit[0]);
        EnumMap enumMap = new EnumMap(zzis.zza.class);
        zzis.zza[] zzaVarArrZza = zzit.DMA.zza();
        int length = zzaVarArrZza.length;
        int i2 = 0;
        int i3 = 1;
        while (i2 < length) {
            enumMap.put(zzaVarArrZza[i2], zzis.zza(strArrSplit[i3].charAt(0)));
            i2++;
            i3++;
        }
        return new zzax((EnumMap<zzis.zza, zzir>) enumMap, i, (Boolean) null, (String) null);
    }

    public final zzir zzc() {
        zzir zzirVar = this.zzf.get(zzis.zza.AD_USER_DATA);
        return zzirVar == null ? zzir.UNINITIALIZED : zzirVar;
    }

    public static Boolean zza(Bundle bundle) {
        zzir zzirVarZza;
        if (bundle == null || (zzirVarZza = zzis.zza(bundle.getString("ad_personalization"))) == null) {
            return null;
        }
        int i = zzaw.zza[zzirVarZza.ordinal()];
        if (i == 3) {
            return Boolean.FALSE;
        }
        if (i != 4) {
            return null;
        }
        return Boolean.TRUE;
    }

    public final Boolean zzd() {
        return this.zzd;
    }

    private final String zzh() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.zzb);
        for (zzis.zza zzaVar : zzit.DMA.zza()) {
            sb.append(":");
            sb.append(zzis.zza(this.zzf.get(zzaVar)));
        }
        return sb.toString();
    }

    public final String zze() {
        return this.zze;
    }

    public final String zzf() {
        return this.zzc;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(zzis.zza(this.zzb));
        for (zzis.zza zzaVar : zzit.DMA.zza()) {
            sb.append(",");
            sb.append(zzaVar.zze);
            sb.append("=");
            zzir zzirVar = this.zzf.get(zzaVar);
            if (zzirVar == null) {
                sb.append("uninitialized");
            } else {
                int i = zzaw.zza[zzirVar.ordinal()];
                if (i == 1) {
                    sb.append("uninitialized");
                } else if (i == 2) {
                    sb.append("default");
                } else if (i == 3) {
                    sb.append("denied");
                } else if (i == 4) {
                    sb.append("granted");
                }
            }
        }
        if (this.zzd != null) {
            sb.append(",isDmaRegion=");
            sb.append(this.zzd);
        }
        if (this.zze != null) {
            sb.append(",cpsDisplayStr=");
            sb.append(this.zze);
        }
        return sb.toString();
    }

    zzax(Boolean bool, int i) {
        this(bool, i, (Boolean) null, (String) null);
    }

    zzax(Boolean bool, int i, Boolean bool2, String str) {
        EnumMap<zzis.zza, zzir> enumMap = new EnumMap<>(zzis.zza.class);
        this.zzf = enumMap;
        enumMap.put(zzis.zza.AD_USER_DATA, zzis.zza(bool));
        this.zzb = i;
        this.zzc = zzh();
        this.zzd = bool2;
        this.zze = str;
    }

    private zzax(EnumMap<zzis.zza, zzir> enumMap, int i, Boolean bool, String str) {
        EnumMap<zzis.zza, zzir> enumMap2 = new EnumMap<>(zzis.zza.class);
        this.zzf = enumMap2;
        enumMap2.putAll(enumMap);
        this.zzb = i;
        this.zzc = zzh();
        this.zzd = bool;
        this.zze = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzax)) {
            return false;
        }
        zzax zzaxVar = (zzax) obj;
        if (this.zzc.equalsIgnoreCase(zzaxVar.zzc) && Objects.equals(this.zzd, zzaxVar.zzd)) {
            return Objects.equals(this.zze, zzaxVar.zze);
        }
        return false;
    }

    public final boolean zzg() {
        Iterator<zzir> it2 = this.zzf.values().iterator();
        while (it2.hasNext()) {
            if (it2.next() != zzir.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }
}
