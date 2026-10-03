package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import ch.qos.logback.core.CoreConstants;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class zzis {
    public static final zzis zza = new zzis(null, null, 100);
    private final EnumMap<zza, zzir> zzb;
    private final int zzc;

    public static boolean zza(int i, int i2) {
        if (i == -20 && i2 == -30) {
            return true;
        }
        return (i == -30 && i2 == -20) || i == i2 || i < i2;
    }

    static char zza(zzir zzirVar) {
        if (zzirVar == null) {
            return CoreConstants.DASH_CHAR;
        }
        int iOrdinal = zzirVar.ordinal();
        if (iOrdinal == 1) {
            return '+';
        }
        if (iOrdinal == 2) {
            return '0';
        }
        if (iOrdinal != 3) {
            return CoreConstants.DASH_CHAR;
        }
        return '1';
    }

    public enum zza {
        AD_STORAGE("ad_storage"),
        ANALYTICS_STORAGE("analytics_storage"),
        AD_USER_DATA("ad_user_data"),
        AD_PERSONALIZATION("ad_personalization");

        public final String zze;

        zza(String str) {
            this.zze = str;
        }
    }

    public final int zza() {
        return this.zzc;
    }

    public final int hashCode() {
        int iHashCode = this.zzc * 17;
        Iterator<zzir> it2 = this.zzb.values().iterator();
        while (it2.hasNext()) {
            iHashCode = (iHashCode * 31) + it2.next().hashCode();
        }
        return iHashCode;
    }

    public final Bundle zzb() {
        Bundle bundle = new Bundle();
        Iterator it2 = this.zzb.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            String strZzb = zzb((zzir) entry.getValue());
            if (strZzb != null) {
                bundle.putString(((zza) entry.getKey()).zze, strZzb);
            }
        }
        return bundle;
    }

    static zzir zza(String str) {
        if (str == null) {
            return zzir.UNINITIALIZED;
        }
        if (str.equals("granted")) {
            return zzir.GRANTED;
        }
        if (str.equals("denied")) {
            return zzir.DENIED;
        }
        return zzir.UNINITIALIZED;
    }

    public final zzir zzc() {
        zzir zzirVar = this.zzb.get(zza.AD_STORAGE);
        return zzirVar == null ? zzir.UNINITIALIZED : zzirVar;
    }

    public final zzir zzd() {
        zzir zzirVar = this.zzb.get(zza.ANALYTICS_STORAGE);
        return zzirVar == null ? zzir.UNINITIALIZED : zzirVar;
    }

    static zzir zza(char c) {
        if (c == '+') {
            return zzir.DEFAULT;
        }
        if (c == '0') {
            return zzir.DENIED;
        }
        if (c == '1') {
            return zzir.GRANTED;
        }
        return zzir.UNINITIALIZED;
    }

    static zzir zza(Boolean bool) {
        if (bool == null) {
            return zzir.UNINITIALIZED;
        }
        if (bool.booleanValue()) {
            return zzir.GRANTED;
        }
        return zzir.DENIED;
    }

    public static zzis zza(Bundle bundle, int i) {
        if (bundle == null) {
            return new zzis(null, null, i);
        }
        EnumMap enumMap = new EnumMap(zza.class);
        for (zza zzaVar : zzit.STORAGE.zzd) {
            enumMap.put(zzaVar, zza(bundle.getString(zzaVar.zze)));
        }
        return new zzis(enumMap, i);
    }

    public static zzis zza(zzir zzirVar, zzir zzirVar2, int i) {
        EnumMap enumMap = new EnumMap(zza.class);
        enumMap.put(zza.AD_STORAGE, zzirVar);
        enumMap.put(zza.ANALYTICS_STORAGE, zzirVar2);
        return new zzis(enumMap, -10);
    }

    public static zzis zzb(String str) {
        return zza(str, 100);
    }

    public static zzis zza(String str, int i) {
        EnumMap enumMap = new EnumMap(zza.class);
        if (str == null) {
            str = "";
        }
        zza[] zzaVarArrZza = zzit.STORAGE.zza();
        for (int i2 = 0; i2 < zzaVarArrZza.length; i2++) {
            zza zzaVar = zzaVarArrZza[i2];
            int i3 = i2 + 2;
            if (i3 < str.length()) {
                enumMap.put(zzaVar, zza(str.charAt(i3)));
            } else {
                enumMap.put(zzaVar, zzir.UNINITIALIZED);
            }
        }
        return new zzis(enumMap, i);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0035  */
    public final zzis zza(zzis zzisVar) {
        EnumMap enumMap = new EnumMap(zza.class);
        for (zza zzaVar : zzit.STORAGE.zzd) {
            zzir zzirVar = this.zzb.get(zzaVar);
            zzir zzirVar2 = zzisVar.zzb.get(zzaVar);
            if (zzirVar == null) {
                zzirVar = zzirVar2;
            } else if (zzirVar2 != null) {
                zzir zzirVar3 = zzir.UNINITIALIZED;
                if (zzirVar == zzirVar3) {
                    zzirVar = zzirVar2;
                } else if (zzirVar2 != zzirVar3) {
                    zzir zzirVar4 = zzir.DEFAULT;
                    if (zzirVar == zzirVar4) {
                        zzirVar = zzirVar2;
                    } else if (zzirVar2 != zzirVar4) {
                        zzir zzirVar5 = zzir.DENIED;
                        zzirVar = (zzirVar == zzirVar5 || zzirVar2 == zzirVar5) ? zzirVar5 : zzir.GRANTED;
                    }
                }
            }
            if (zzirVar != null) {
                enumMap.put(zzaVar, zzirVar);
            }
        }
        return new zzis(enumMap, 100);
    }

    public final zzis zzb(zzis zzisVar) {
        EnumMap enumMap = new EnumMap(zza.class);
        for (zza zzaVar : zzit.STORAGE.zzd) {
            zzir zzirVar = this.zzb.get(zzaVar);
            if (zzirVar == zzir.UNINITIALIZED) {
                zzirVar = zzisVar.zzb.get(zzaVar);
            }
            if (zzirVar != null) {
                enumMap.put(zzaVar, zzirVar);
            }
        }
        return new zzis(enumMap, this.zzc);
    }

    public final Boolean zze() {
        zzir zzirVar = this.zzb.get(zza.AD_STORAGE);
        if (zzirVar == null) {
            return null;
        }
        int iOrdinal = zzirVar.ordinal();
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                return Boolean.FALSE;
            }
            if (iOrdinal != 3) {
                return null;
            }
        }
        return Boolean.TRUE;
    }

    public final Boolean zzf() {
        zzir zzirVar = this.zzb.get(zza.ANALYTICS_STORAGE);
        if (zzirVar == null) {
            return null;
        }
        int iOrdinal = zzirVar.ordinal();
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                return Boolean.FALSE;
            }
            if (iOrdinal != 3) {
                return null;
            }
        }
        return Boolean.TRUE;
    }

    static String zza(int i) {
        if (i == -30) {
            return "TCF";
        }
        if (i == -20) {
            return "API";
        }
        if (i == -10) {
            return "MANIFEST";
        }
        if (i == 0) {
            return "1P_API";
        }
        if (i == 30) {
            return "1P_INIT";
        }
        if (i == 90) {
            return "REMOTE_CONFIG";
        }
        if (i == 100) {
            return "UNKNOWN";
        }
        return "OTHER";
    }

    static String zzb(zzir zzirVar) {
        int iOrdinal = zzirVar.ordinal();
        if (iOrdinal == 2) {
            return "denied";
        }
        if (iOrdinal != 3) {
            return null;
        }
        return "granted";
    }

    public static String zza(Bundle bundle) {
        String string;
        zza[] zzaVarArr = zzit.STORAGE.zzd;
        int length = zzaVarArr.length;
        int i = 0;
        while (true) {
            Boolean bool = null;
            if (i >= length) {
                return null;
            }
            zza zzaVar = zzaVarArr[i];
            if (bundle.containsKey(zzaVar.zze) && (string = bundle.getString(zzaVar.zze)) != null) {
                if (string.equals("granted")) {
                    bool = Boolean.TRUE;
                } else if (string.equals("denied")) {
                    bool = Boolean.FALSE;
                }
                if (bool == null) {
                    return string;
                }
            }
            i++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0030  */
    /* JADX WARN: Code duplicated, block: B:17:0x0033  */
    public final String zzg() {
        char c;
        int iOrdinal;
        StringBuilder sb = new StringBuilder("G1");
        for (zza zzaVar : zzit.STORAGE.zza()) {
            zzir zzirVar = this.zzb.get(zzaVar);
            if (zzirVar == null || (iOrdinal = zzirVar.ordinal()) == 0) {
                c = CoreConstants.DASH_CHAR;
            } else if (iOrdinal == 1) {
                c = '1';
            } else if (iOrdinal == 2) {
                c = '0';
            } else if (iOrdinal != 3) {
                c = CoreConstants.DASH_CHAR;
            } else {
                c = '1';
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public final String zzh() {
        StringBuilder sb = new StringBuilder("G1");
        for (zza zzaVar : zzit.STORAGE.zza()) {
            sb.append(zza(this.zzb.get(zzaVar)));
        }
        return sb.toString();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(zza(this.zzc));
        for (zza zzaVar : zzit.STORAGE.zzd) {
            sb.append(",");
            sb.append(zzaVar.zze);
            sb.append("=");
            zzir zzirVar = this.zzb.get(zzaVar);
            if (zzirVar == null) {
                sb.append("uninitialized");
            } else {
                int iOrdinal = zzirVar.ordinal();
                if (iOrdinal == 0) {
                    sb.append("uninitialized");
                } else if (iOrdinal == 1) {
                    sb.append("default");
                } else if (iOrdinal == 2) {
                    sb.append("denied");
                } else if (iOrdinal == 3) {
                    sb.append("granted");
                }
            }
        }
        return sb.toString();
    }

    private zzis(EnumMap<zza, zzir> enumMap, int i) {
        EnumMap<zza, zzir> enumMap2 = new EnumMap<>(zza.class);
        this.zzb = enumMap2;
        enumMap2.putAll(enumMap);
        this.zzc = i;
    }

    public zzis(Boolean bool, Boolean bool2, int i) {
        EnumMap<zza, zzir> enumMap = new EnumMap<>(zza.class);
        this.zzb = enumMap;
        enumMap.put(zza.AD_STORAGE, zza(bool));
        enumMap.put(zza.ANALYTICS_STORAGE, zza(bool2));
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzis)) {
            return false;
        }
        zzis zzisVar = (zzis) obj;
        for (zza zzaVar : zzit.STORAGE.zzd) {
            if (this.zzb.get(zzaVar) != zzisVar.zzb.get(zzaVar)) {
                return false;
            }
        }
        return this.zzc == zzisVar.zzc;
    }

    public final boolean zza(zzis zzisVar, zza... zzaVarArr) {
        for (zza zzaVar : zzaVarArr) {
            if (!zzisVar.zza(zzaVar) && zza(zzaVar)) {
                return true;
            }
        }
        return false;
    }

    public final boolean zzi() {
        return zza(zza.AD_STORAGE);
    }

    public final boolean zza(zza zzaVar) {
        return this.zzb.get(zzaVar) != zzir.DENIED;
    }

    public final boolean zzj() {
        return zza(zza.ANALYTICS_STORAGE);
    }

    public final boolean zzk() {
        Iterator<zzir> it2 = this.zzb.values().iterator();
        while (it2.hasNext()) {
            if (it2.next() != zzir.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    public final boolean zzc(zzis zzisVar) {
        return zzb(zzisVar, (zza[]) this.zzb.keySet().toArray(new zza[0]));
    }

    public final boolean zzb(zzis zzisVar, zza... zzaVarArr) {
        for (zza zzaVar : zzaVarArr) {
            zzir zzirVar = this.zzb.get(zzaVar);
            zzir zzirVar2 = zzisVar.zzb.get(zzaVar);
            zzir zzirVar3 = zzir.DENIED;
            if (zzirVar == zzirVar3 && zzirVar2 != zzirVar3) {
                return true;
            }
        }
        return false;
    }
}
