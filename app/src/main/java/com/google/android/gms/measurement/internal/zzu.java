package com.google.android.gms.measurement.internal;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzov;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
final class zzu {
    private String zza;
    private boolean zzb;
    private com.google.android.gms.internal.measurement.zzfs.zzl zzc;
    private BitSet zzd;
    private BitSet zze;
    private Map<Integer, Long> zzf;
    private Map<Integer, List<Long>> zzg;
    private final /* synthetic */ zzs zzh;

    final com.google.android.gms.internal.measurement.zzfs.zzc zza(int i) {
        ArrayList arrayList;
        List listEmptyList;
        com.google.android.gms.internal.measurement.zzfs.zzc.zza zzaVarZzb = com.google.android.gms.internal.measurement.zzfs.zzc.zzb();
        zzaVarZzb.zza(i);
        zzaVarZzb.zza(this.zzb);
        com.google.android.gms.internal.measurement.zzfs.zzl zzlVar = this.zzc;
        if (zzlVar != null) {
            zzaVarZzb.zza(zzlVar);
        }
        com.google.android.gms.internal.measurement.zzfs.zzl.zza zzaVarZzd = com.google.android.gms.internal.measurement.zzfs.zzl.zze().zzb(zznt.zza(this.zzd)).zzd(zznt.zza(this.zze));
        Map<Integer, Long> map = this.zzf;
        if (map == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(map.size());
            for (Integer num : this.zzf.keySet()) {
                int iIntValue = num.intValue();
                Long l = this.zzf.get(num);
                if (l != null) {
                    arrayList2.add((com.google.android.gms.internal.measurement.zzfs.zzd) ((com.google.android.gms.internal.measurement.zzju) com.google.android.gms.internal.measurement.zzfs.zzd.zzc().zza(iIntValue).zza(l.longValue()).zzah()));
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            zzaVarZzd.zza(arrayList);
        }
        Map<Integer, List<Long>> map2 = this.zzg;
        if (map2 == null) {
            listEmptyList = Collections.emptyList();
        } else {
            ArrayList arrayList3 = new ArrayList(map2.size());
            for (Integer num2 : this.zzg.keySet()) {
                com.google.android.gms.internal.measurement.zzfs.zzm.zza zzaVarZza = com.google.android.gms.internal.measurement.zzfs.zzm.zzc().zza(num2.intValue());
                List<Long> list = this.zzg.get(num2);
                if (list != null) {
                    Collections.sort(list);
                    zzaVarZza.zza(list);
                }
                arrayList3.add((com.google.android.gms.internal.measurement.zzfs.zzm) ((com.google.android.gms.internal.measurement.zzju) zzaVarZza.zzah()));
            }
            listEmptyList = arrayList3;
        }
        zzaVarZzd.zzc(listEmptyList);
        zzaVarZzb.zza(zzaVarZzd);
        return (com.google.android.gms.internal.measurement.zzfs.zzc) ((com.google.android.gms.internal.measurement.zzju) zzaVarZzb.zzah());
    }

    private zzu(zzs zzsVar, String str) {
        this.zzh = zzsVar;
        this.zza = str;
        this.zzb = true;
        this.zzd = new BitSet();
        this.zze = new BitSet();
        this.zzf = new ArrayMap();
        this.zzg = new ArrayMap();
    }

    private zzu(zzs zzsVar, String str, com.google.android.gms.internal.measurement.zzfs.zzl zzlVar, BitSet bitSet, BitSet bitSet2, Map<Integer, Long> map, Map<Integer, Long> map2) {
        this.zzh = zzsVar;
        this.zza = str;
        this.zzd = bitSet;
        this.zze = bitSet2;
        this.zzf = map;
        this.zzg = new ArrayMap();
        if (map2 != null) {
            for (Integer num : map2.keySet()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(map2.get(num));
                this.zzg.put(num, arrayList);
            }
        }
        this.zzb = false;
        this.zzc = zzlVar;
    }

    final void zza(@NonNull zzab zzabVar) {
        int iZza = zzabVar.zza();
        Boolean bool = zzabVar.zzc;
        if (bool != null) {
            this.zze.set(iZza, bool.booleanValue());
        }
        Boolean bool2 = zzabVar.zzd;
        if (bool2 != null) {
            this.zzd.set(iZza, bool2.booleanValue());
        }
        if (zzabVar.zze != null) {
            Long l = this.zzf.get(Integer.valueOf(iZza));
            long jLongValue = zzabVar.zze.longValue() / 1000;
            if (l == null || jLongValue > l.longValue()) {
                this.zzf.put(Integer.valueOf(iZza), Long.valueOf(jLongValue));
            }
        }
        if (zzabVar.zzf != null) {
            List<Long> arrayList = this.zzg.get(Integer.valueOf(iZza));
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.zzg.put(Integer.valueOf(iZza), arrayList);
            }
            if (zzabVar.zzc()) {
                arrayList.clear();
            }
            if (zzov.zza() && this.zzh.zze().zzf(this.zza, zzbh.zzbi) && zzabVar.zzb()) {
                arrayList.clear();
            }
            if (zzov.zza() && this.zzh.zze().zzf(this.zza, zzbh.zzbi)) {
                long jLongValue2 = zzabVar.zzf.longValue() / 1000;
                if (arrayList.contains(Long.valueOf(jLongValue2))) {
                    return;
                }
                arrayList.add(Long.valueOf(jLongValue2));
                return;
            }
            arrayList.add(Long.valueOf(zzabVar.zzf.longValue() / 1000));
        }
    }
}
