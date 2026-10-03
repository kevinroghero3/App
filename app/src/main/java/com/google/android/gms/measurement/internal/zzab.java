package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: loaded from: classes4.dex */
abstract class zzab {
    String zza;
    int zzb;
    Boolean zzc;
    Boolean zzd;
    Long zze;
    Long zzf;

    private static Boolean zza(BigDecimal bigDecimal, com.google.android.gms.internal.measurement.zzfg.zzd zzdVar, double d) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        Preconditions.checkNotNull(zzdVar);
        if (zzdVar.zzh() && zzdVar.zza() != com.google.android.gms.internal.measurement.zzfg.zzd.zza.UNKNOWN_COMPARISON_TYPE) {
            com.google.android.gms.internal.measurement.zzfg.zzd.zza zzaVarZza = zzdVar.zza();
            com.google.android.gms.internal.measurement.zzfg.zzd.zza zzaVar = com.google.android.gms.internal.measurement.zzfg.zzd.zza.BETWEEN;
            if (zzaVarZza == zzaVar) {
                if (!zzdVar.zzl() || !zzdVar.zzk()) {
                    return null;
                }
            } else if (!zzdVar.zzi()) {
                return null;
            }
            com.google.android.gms.internal.measurement.zzfg.zzd.zza zzaVarZza2 = zzdVar.zza();
            if (zzdVar.zza() == zzaVar) {
                if (zznt.zzb(zzdVar.zzf()) && zznt.zzb(zzdVar.zze())) {
                    try {
                        BigDecimal bigDecimal5 = new BigDecimal(zzdVar.zzf());
                        bigDecimal4 = new BigDecimal(zzdVar.zze());
                        bigDecimal3 = bigDecimal5;
                        bigDecimal2 = null;
                    } catch (NumberFormatException unused) {
                    }
                }
                return null;
            }
            if (!zznt.zzb(zzdVar.zzd())) {
                return null;
            }
            try {
                bigDecimal2 = new BigDecimal(zzdVar.zzd());
                bigDecimal3 = null;
                bigDecimal4 = null;
            } catch (NumberFormatException unused2) {
            }
            if (zzaVarZza2 == zzaVar) {
                if (bigDecimal3 == null) {
                    return null;
                }
            } else if (bigDecimal2 != null) {
            }
            int i = zzv.zzb[zzaVarZza2.ordinal()];
            boolean z = false;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4 || bigDecimal3 == null) {
                            return null;
                        }
                        if (bigDecimal.compareTo(bigDecimal3) >= 0 && bigDecimal.compareTo(bigDecimal4) <= 0) {
                            z = true;
                        }
                        return Boolean.valueOf(z);
                    }
                    if (bigDecimal2 != null) {
                        if (d == 0.0d) {
                            return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == 0);
                        }
                        if (bigDecimal.compareTo(bigDecimal2.subtract(new BigDecimal(d).multiply(new BigDecimal(2)))) > 0 && bigDecimal.compareTo(bigDecimal2.add(new BigDecimal(d).multiply(new BigDecimal(2)))) < 0) {
                            z = true;
                        }
                        return Boolean.valueOf(z);
                    }
                } else if (bigDecimal2 != null) {
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) > 0);
                }
            } else if (bigDecimal2 != null) {
                return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) < 0);
            }
        }
        return null;
    }

    abstract int zza();

    abstract boolean zzb();

    abstract boolean zzc();

    static Boolean zza(String str, com.google.android.gms.internal.measurement.zzfg.zzf zzfVar, zzgb zzgbVar) {
        String strZze;
        List<String> list;
        Preconditions.checkNotNull(zzfVar);
        if (str == null || !zzfVar.zzj() || zzfVar.zzb() == com.google.android.gms.internal.measurement.zzfg.zzf.zzb.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        com.google.android.gms.internal.measurement.zzfg.zzf.zzb zzbVarZzb = zzfVar.zzb();
        com.google.android.gms.internal.measurement.zzfg.zzf.zzb zzbVar = com.google.android.gms.internal.measurement.zzfg.zzf.zzb.IN_LIST;
        if (zzbVarZzb == zzbVar) {
            if (zzfVar.zza() == 0) {
                return null;
            }
        } else if (!zzfVar.zzi()) {
            return null;
        }
        com.google.android.gms.internal.measurement.zzfg.zzf.zzb zzbVarZzb2 = zzfVar.zzb();
        boolean zZzg = zzfVar.zzg();
        if (zZzg || zzbVarZzb2 == com.google.android.gms.internal.measurement.zzfg.zzf.zzb.REGEXP || zzbVarZzb2 == zzbVar) {
            strZze = zzfVar.zze();
        } else {
            strZze = zzfVar.zze().toUpperCase(Locale.ENGLISH);
        }
        String str2 = strZze;
        if (zzfVar.zza() == 0) {
            list = null;
        } else {
            List<String> listZzf = zzfVar.zzf();
            if (!zZzg) {
                ArrayList arrayList = new ArrayList(listZzf.size());
                Iterator<String> it2 = listZzf.iterator();
                while (it2.hasNext()) {
                    arrayList.add(it2.next().toUpperCase(Locale.ENGLISH));
                }
                listZzf = Collections.unmodifiableList(arrayList);
            }
            list = listZzf;
        }
        return zza(str, zzbVarZzb2, zZzg, str2, list, zzbVarZzb2 == com.google.android.gms.internal.measurement.zzfg.zzf.zzb.REGEXP ? str2 : null, zzgbVar);
    }

    private static Boolean zza(String str, com.google.android.gms.internal.measurement.zzfg.zzf.zzb zzbVar, boolean z, String str2, List<String> list, String str3, zzgb zzgbVar) {
        if (str == null) {
            return null;
        }
        if (zzbVar == com.google.android.gms.internal.measurement.zzfg.zzf.zzb.IN_LIST) {
            if (list == null || list.isEmpty()) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && zzbVar != com.google.android.gms.internal.measurement.zzfg.zzf.zzb.REGEXP) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (zzv.zza[zzbVar.ordinal()]) {
            case 1:
                if (str3 == null) {
                    return null;
                }
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (zzgbVar != null) {
                        zzgbVar.zzu().zza("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                if (list == null) {
                    return null;
                }
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    static Boolean zza(double d, com.google.android.gms.internal.measurement.zzfg.zzd zzdVar) {
        try {
            return zza(new BigDecimal(d), zzdVar, Math.ulp(d));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean zza(long j, com.google.android.gms.internal.measurement.zzfg.zzd zzdVar) {
        try {
            return zza(new BigDecimal(j), zzdVar, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean zza(String str, com.google.android.gms.internal.measurement.zzfg.zzd zzdVar) {
        if (!zznt.zzb(str)) {
            return null;
        }
        try {
            return zza(new BigDecimal(str), zzdVar, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean zza(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    zzab(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }
}
