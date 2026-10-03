package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzov;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
final class zzs extends zznf {
    private String zza;
    private Set<Integer> zzb;
    private Map<Integer, zzu> zzc;
    private Long zzd;
    private Long zze;

    private final zzu zza(Integer num) {
        if (this.zzc.containsKey(num)) {
            return this.zzc.get(num);
        }
        zzu zzuVar = new zzu(this, this.zza);
        this.zzc.put(num, zzuVar);
        return zzuVar;
    }

    @Override // com.google.android.gms.measurement.internal.zznf
    protected final boolean zzc() {
        return false;
    }

    final List<com.google.android.gms.internal.measurement.zzfs.zzc> zza(String str, List<com.google.android.gms.internal.measurement.zzfs.zze> list, List<com.google.android.gms.internal.measurement.zzfs.zzn> list2, Long l, Long l2) {
        boolean z;
        zzbb zzbbVar;
        zzw zzwVar;
        ArrayMap arrayMap;
        Map<Integer, com.google.android.gms.internal.measurement.zzfs.zzl> map;
        List<com.google.android.gms.internal.measurement.zzfg.zzb> list3;
        Map<Integer, com.google.android.gms.internal.measurement.zzfs.zzl> map2;
        Map<Integer, List<Integer>> map3;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(list2);
        this.zza = str;
        this.zzb = new HashSet();
        this.zzc = new ArrayMap();
        this.zzd = l;
        this.zze = l2;
        Iterator<com.google.android.gms.internal.measurement.zzfs.zze> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                z = false;
                break;
            }
            if ("_s".equals(it2.next().zzg())) {
                z = true;
                break;
            }
        }
        boolean z2 = zzov.zza() && zze().zzf(this.zza, zzbh.zzbi);
        boolean z3 = zzov.zza() && zze().zzf(this.zza, zzbh.zzbh);
        if (z) {
            zzan zzanVarZzh = zzh();
            String str2 = this.zza;
            zzanVarZzh.zzak();
            zzanVarZzh.zzt();
            Preconditions.checkNotEmpty(str2);
            ContentValues contentValues = new ContentValues();
            contentValues.put("current_session_count", (Integer) 0);
            try {
                zzanVarZzh.e_().update("events", contentValues, "app_id = ?", new String[]{str2});
            } catch (SQLiteException e) {
                zzanVarZzh.zzj().zzg().zza("Error resetting session-scoped event counts. appId", zzgb.zza(str2), e);
            }
        }
        Map<Integer, List<com.google.android.gms.internal.measurement.zzfg.zzb>> mapEmptyMap = Collections.emptyMap();
        if (z3 && z2) {
            mapEmptyMap = zzh().zzl(this.zza);
        }
        Map<Integer, com.google.android.gms.internal.measurement.zzfs.zzl> mapZzk = zzh().zzk(this.zza);
        if (!mapZzk.isEmpty()) {
            HashSet hashSet = new HashSet(mapZzk.keySet());
            if (z) {
                String str3 = this.zza;
                Map<Integer, List<Integer>> mapZzm = zzh().zzm(this.zza);
                Preconditions.checkNotEmpty(str3);
                Preconditions.checkNotNull(mapZzk);
                ArrayMap arrayMap2 = new ArrayMap();
                if (!mapZzk.isEmpty()) {
                    for (Integer num : mapZzk.keySet()) {
                        num.intValue();
                        com.google.android.gms.internal.measurement.zzfs.zzl zzlVar = mapZzk.get(num);
                        List<Integer> list4 = mapZzm.get(num);
                        if (list4 == null || list4.isEmpty()) {
                            map3 = mapZzm;
                            arrayMap2.put(num, zzlVar);
                            mapZzm = map3;
                        } else {
                            List<Long> listZza = g_().zza(zzlVar.zzi(), list4);
                            if (!listZza.isEmpty()) {
                                com.google.android.gms.internal.measurement.zzfs.zzl.zza zzaVarZzb = zzlVar.zzca().zzb().zzb(listZza);
                                zzaVarZzb.zzd().zzd(g_().zza(zzlVar.zzk(), list4));
                                ArrayList arrayList = new ArrayList();
                                for (com.google.android.gms.internal.measurement.zzfs.zzd zzdVar : zzlVar.zzh()) {
                                    Map<Integer, List<Integer>> map4 = mapZzm;
                                    if (!list4.contains(Integer.valueOf(zzdVar.zza()))) {
                                        arrayList.add(zzdVar);
                                    }
                                    mapZzm = map4;
                                }
                                map3 = mapZzm;
                                zzaVarZzb.zza().zza(arrayList);
                                ArrayList arrayList2 = new ArrayList();
                                for (com.google.android.gms.internal.measurement.zzfs.zzm zzmVar : zzlVar.zzj()) {
                                    if (!list4.contains(Integer.valueOf(zzmVar.zzb()))) {
                                        arrayList2.add(zzmVar);
                                    }
                                }
                                zzaVarZzb.zzc().zzc(arrayList2);
                                arrayMap2.put(num, (com.google.android.gms.internal.measurement.zzfs.zzl) ((com.google.android.gms.internal.measurement.zzju) zzaVarZzb.zzah()));
                                mapZzm = map3;
                            }
                        }
                    }
                }
                map = arrayMap2;
            } else {
                map = mapZzk;
            }
            Iterator it3 = hashSet.iterator();
            while (it3.hasNext()) {
                Integer num2 = (Integer) it3.next();
                num2.intValue();
                com.google.android.gms.internal.measurement.zzfs.zzl zzlVar2 = map.get(num2);
                BitSet bitSet = new BitSet();
                BitSet bitSet2 = new BitSet();
                ArrayMap arrayMap3 = new ArrayMap();
                if (zzlVar2 != null && zzlVar2.zza() != 0) {
                    for (com.google.android.gms.internal.measurement.zzfs.zzd zzdVar2 : zzlVar2.zzh()) {
                        if (zzdVar2.zzf()) {
                            arrayMap3.put(Integer.valueOf(zzdVar2.zza()), zzdVar2.zze() ? Long.valueOf(zzdVar2.zzb()) : null);
                        }
                    }
                }
                ArrayMap arrayMap4 = new ArrayMap();
                if (zzlVar2 != null && zzlVar2.zzc() != 0) {
                    for (Iterator<com.google.android.gms.internal.measurement.zzfs.zzm> it4 = zzlVar2.zzj().iterator(); it4.hasNext(); it4 = it4) {
                        com.google.android.gms.internal.measurement.zzfs.zzm next = it4.next();
                        if (next.zzf() && next.zza() > 0) {
                            arrayMap4.put(Integer.valueOf(next.zzb()), Long.valueOf(next.zza(next.zza() - 1)));
                        }
                    }
                }
                if (zzlVar2 != null) {
                    int i = 0;
                    while (i < (zzlVar2.zzd() << 6)) {
                        if (zznt.zza(zzlVar2.zzk(), i)) {
                            map2 = map;
                            zzj().zzp().zza("Filter already evaluated. audience ID, filter ID", num2, Integer.valueOf(i));
                            bitSet2.set(i);
                            if (zznt.zza(zzlVar2.zzi(), i)) {
                                bitSet.set(i);
                            }
                            i++;
                            map = map2;
                        } else {
                            map2 = map;
                        }
                        arrayMap3.remove(Integer.valueOf(i));
                        i++;
                        map = map2;
                    }
                }
                Map<Integer, com.google.android.gms.internal.measurement.zzfs.zzl> map5 = map;
                com.google.android.gms.internal.measurement.zzfs.zzl zzlVar3 = mapZzk.get(num2);
                if (z3 && z2 && (list3 = mapEmptyMap.get(num2)) != null && this.zze != null && this.zzd != null) {
                    for (com.google.android.gms.internal.measurement.zzfg.zzb zzbVar : list3) {
                        int iZzb = zzbVar.zzb();
                        long jLongValue = this.zze.longValue() / 1000;
                        if (zzbVar.zzi()) {
                            jLongValue = this.zzd.longValue() / 1000;
                        }
                        if (arrayMap3.containsKey(Integer.valueOf(iZzb))) {
                            arrayMap3.put(Integer.valueOf(iZzb), Long.valueOf(jLongValue));
                        }
                        if (arrayMap4.containsKey(Integer.valueOf(iZzb))) {
                            arrayMap4.put(Integer.valueOf(iZzb), Long.valueOf(jLongValue));
                        }
                    }
                }
                this.zzc.put(num2, new zzu(this, this.zza, zzlVar3, bitSet, bitSet2, arrayMap3, arrayMap4));
                it3 = it3;
                map = map5;
            }
        }
        if (!list.isEmpty()) {
            zzw zzwVar2 = new zzw(this);
            ArrayMap arrayMap5 = new ArrayMap();
            for (com.google.android.gms.internal.measurement.zzfs.zze zzeVar : list) {
                com.google.android.gms.internal.measurement.zzfs.zze zzeVarZza = zzwVar2.zza(this.zza, zzeVar);
                if (zzeVarZza != null) {
                    zzan zzanVarZzh2 = zzh();
                    String str4 = this.zza;
                    String strZzg = zzeVarZza.zzg();
                    zzbb zzbbVarZzd = zzanVarZzh2.zzd(str4, zzeVar.zzg());
                    if (zzbbVarZzd == null) {
                        zzanVarZzh2.zzj().zzu().zza("Event aggregate wasn't created during raw event logging. appId, event", zzgb.zza(str4), zzanVarZzh2.zzi().zza(strZzg));
                        zzbbVar = new zzbb(str4, zzeVar.zzg(), 1L, 1L, 1L, zzeVar.zzd(), 0L, null, null, null, null);
                    } else {
                        zzbbVar = new zzbb(zzbbVarZzd.zza, zzbbVarZzd.zzb, zzbbVarZzd.zzc + 1, zzbbVarZzd.zzd + 1, zzbbVarZzd.zze + 1, zzbbVarZzd.zzf, zzbbVarZzd.zzg, zzbbVarZzd.zzh, zzbbVarZzd.zzi, zzbbVarZzd.zzj, zzbbVarZzd.zzk);
                    }
                    zzh().zza(zzbbVar);
                    long j = zzbbVar.zzc;
                    String strZzg2 = zzeVarZza.zzg();
                    Map<Integer, List<com.google.android.gms.internal.measurement.zzfg.zzb>> mapZzf = (Map) arrayMap5.get(strZzg2);
                    if (mapZzf == null) {
                        mapZzf = zzh().zzf(this.zza, strZzg2);
                        arrayMap5.put(strZzg2, mapZzf);
                    }
                    for (Integer num3 : mapZzf.keySet()) {
                        int iIntValue = num3.intValue();
                        if (this.zzb.contains(num3)) {
                            zzj().zzp().zza("Skipping failed audience ID", num3);
                        } else {
                            Iterator<com.google.android.gms.internal.measurement.zzfg.zzb> it5 = mapZzf.get(num3).iterator();
                            boolean zZza = true;
                            while (true) {
                                if (!it5.hasNext()) {
                                    zzwVar = zzwVar2;
                                    arrayMap = arrayMap5;
                                    break;
                                }
                                com.google.android.gms.internal.measurement.zzfg.zzb next2 = it5.next();
                                zzwVar = zzwVar2;
                                zzy zzyVar = new zzy(this, this.zza, iIntValue, next2);
                                arrayMap = arrayMap5;
                                zZza = zzyVar.zza(this.zzd, this.zze, zzeVarZza, j, zzbbVar, zza(iIntValue, next2.zzb()));
                                if (zZza) {
                                    zza(num3).zza(zzyVar);
                                    zzwVar2 = zzwVar;
                                    arrayMap5 = arrayMap;
                                } else {
                                    this.zzb.add(num3);
                                    break;
                                }
                            }
                            if (!zZza) {
                                this.zzb.add(num3);
                            }
                            zzwVar2 = zzwVar;
                            arrayMap5 = arrayMap;
                        }
                    }
                }
            }
        }
        if (!list2.isEmpty()) {
            ArrayMap arrayMap6 = new ArrayMap();
            for (com.google.android.gms.internal.measurement.zzfs.zzn zznVar : list2) {
                String strZzg3 = zznVar.zzg();
                Map<Integer, List<com.google.android.gms.internal.measurement.zzfg.zze>> mapZzg = (Map) arrayMap6.get(strZzg3);
                if (mapZzg == null) {
                    mapZzg = zzh().zzg(this.zza, strZzg3);
                    arrayMap6.put(strZzg3, mapZzg);
                }
                for (Integer num4 : mapZzg.keySet()) {
                    int iIntValue2 = num4.intValue();
                    if (this.zzb.contains(num4)) {
                        zzj().zzp().zza("Skipping failed audience ID", num4);
                        break;
                    }
                    Iterator<com.google.android.gms.internal.measurement.zzfg.zze> it6 = mapZzg.get(num4).iterator();
                    boolean zZza2 = true;
                    while (true) {
                        if (it6.hasNext()) {
                            com.google.android.gms.internal.measurement.zzfg.zze next3 = it6.next();
                            if (zzj().zza(2)) {
                                zzj().zzp().zza("Evaluating filter. audience, filter, property", num4, next3.zzi() ? Integer.valueOf(next3.zza()) : null, zzi().zzc(next3.zze()));
                                zzj().zzp().zza("Filter definition", g_().zza(next3));
                            }
                            if (!next3.zzi() || next3.zza() > 256) {
                                zzj().zzu().zza("Invalid property filter ID. appId, id", zzgb.zza(this.zza), String.valueOf(next3.zzi() ? Integer.valueOf(next3.zza()) : null));
                                this.zzb.add(num4);
                            } else {
                                zzaa zzaaVar = new zzaa(this, this.zza, iIntValue2, next3);
                                zZza2 = zzaaVar.zza(this.zzd, this.zze, zznVar, zza(iIntValue2, next3.zza()));
                                if (zZza2) {
                                    zza(num4).zza(zzaaVar);
                                } else {
                                    this.zzb.add(num4);
                                }
                            }
                        }
                        if (!zZza2) {
                            this.zzb.add(num4);
                        }
                    }
                }
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Set<Integer> setKeySet = this.zzc.keySet();
        setKeySet.removeAll(this.zzb);
        for (Integer num5 : setKeySet) {
            int iIntValue3 = num5.intValue();
            zzu zzuVar = this.zzc.get(num5);
            Preconditions.checkNotNull(zzuVar);
            com.google.android.gms.internal.measurement.zzfs.zzc zzcVarZza = zzuVar.zza(iIntValue3);
            arrayList3.add(zzcVarZza);
            zzan zzanVarZzh3 = zzh();
            String str5 = this.zza;
            com.google.android.gms.internal.measurement.zzfs.zzl zzlVarZzd = zzcVarZza.zzd();
            zzanVarZzh3.zzak();
            zzanVarZzh3.zzt();
            Preconditions.checkNotEmpty(str5);
            Preconditions.checkNotNull(zzlVarZzd);
            byte[] bArrZzbx = zzlVarZzd.zzbx();
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("app_id", str5);
            contentValues2.put("audience_id", num5);
            contentValues2.put("current_results", bArrZzbx);
            try {
                try {
                    if (zzanVarZzh3.e_().insertWithOnConflict("audience_filter_values", null, contentValues2, 5) == -1) {
                        zzanVarZzh3.zzj().zzg().zza("Failed to insert filter results (got -1). appId", zzgb.zza(str5));
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    zzanVarZzh3.zzj().zzg().zza("Error storing filter results. appId", zzgb.zza(str5), e);
                }
            } catch (SQLiteException e3) {
                e = e3;
            }
        }
        return arrayList3;
    }

    zzs(zzng zzngVar) {
        super(zzngVar);
    }

    private final boolean zza(int i, int i2) {
        zzu zzuVar = this.zzc.get(Integer.valueOf(i));
        if (zzuVar == null) {
            return false;
        }
        return zzuVar.zzd.get(i2);
    }
}
