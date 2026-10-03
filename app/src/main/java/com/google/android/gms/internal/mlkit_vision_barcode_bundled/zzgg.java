package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class zzgg {
    public static final /* synthetic */ int zza = 0;
    private static final zzgs zzb;

    static {
        int i = zzfu.zza;
        zzb = new zzgu();
    }

    public static void zzA(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzC(i, list, z);
    }

    public static void zzB(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzE(i, list, z);
    }

    public static void zzC(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzJ(i, list, z);
    }

    public static void zzD(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzL(i, list, z);
    }

    static boolean zzE(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static int zza(List list) {
        int size = list.size();
        int iZzB = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzei) {
            zzei zzeiVar = (zzei) list;
            for (int i = 0; i < size; i++) {
                iZzB += zzdn.zzB(zzeiVar.zze(i));
            }
        } else {
            for (int i2 = 0; i2 < size; i2++) {
                iZzB += zzdn.zzB(((Integer) list.get(i2)).intValue());
            }
        }
        return iZzB;
    }

    static int zzb(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzdn.zzA(i << 3) + 4);
    }

    static int zzc(List list) {
        return list.size() * 4;
    }

    static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzdn.zzA(i << 3) + 8);
    }

    static int zze(List list) {
        return list.size() * 8;
    }

    static int zzf(List list) {
        int size = list.size();
        int iZzB = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzei) {
            zzei zzeiVar = (zzei) list;
            for (int i = 0; i < size; i++) {
                iZzB += zzdn.zzB(zzeiVar.zze(i));
            }
        } else {
            for (int i2 = 0; i2 < size; i2++) {
                iZzB += zzdn.zzB(((Integer) list.get(i2)).intValue());
            }
        }
        return iZzB;
    }

    static int zzg(List list) {
        int size = list.size();
        int iZzB = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfb) {
            zzfb zzfbVar = (zzfb) list;
            for (int i = 0; i < size; i++) {
                iZzB += zzdn.zzB(zzfbVar.zze(i));
            }
        } else {
            for (int i2 = 0; i2 < size; i2++) {
                iZzB += zzdn.zzB(((Long) list.get(i2)).longValue());
            }
        }
        return iZzB;
    }

    static int zzh(int i, Object obj, zzge zzgeVar) {
        int i2 = i << 3;
        if (!(obj instanceof zzex)) {
            return zzdn.zzA(i2) + zzdn.zzy((zzfm) obj, zzgeVar);
        }
        int iZzA = zzdn.zzA(i2);
        int iZza = ((zzex) obj).zza();
        return iZzA + zzdn.zzA(iZza) + iZza;
    }

    static int zzi(List list) {
        int size = list.size();
        int iZzA = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzei) {
            zzei zzeiVar = (zzei) list;
            for (int i = 0; i < size; i++) {
                int iZze = zzeiVar.zze(i);
                iZzA += zzdn.zzA((iZze + iZze) ^ (iZze >> 31));
            }
        } else {
            for (int i2 = 0; i2 < size; i2++) {
                int iIntValue = ((Integer) list.get(i2)).intValue();
                iZzA += zzdn.zzA((iIntValue + iIntValue) ^ (iIntValue >> 31));
            }
        }
        return iZzA;
    }

    static int zzj(List list) {
        int size = list.size();
        int iZzB = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfb) {
            zzfb zzfbVar = (zzfb) list;
            for (int i = 0; i < size; i++) {
                long jZze = zzfbVar.zze(i);
                iZzB += zzdn.zzB((jZze + jZze) ^ (jZze >> 63));
            }
        } else {
            for (int i2 = 0; i2 < size; i2++) {
                long jLongValue = ((Long) list.get(i2)).longValue();
                iZzB += zzdn.zzB((jLongValue + jLongValue) ^ (jLongValue >> 63));
            }
        }
        return iZzB;
    }

    static int zzk(List list) {
        int size = list.size();
        int iZzA = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzei) {
            zzei zzeiVar = (zzei) list;
            for (int i = 0; i < size; i++) {
                iZzA += zzdn.zzA(zzeiVar.zze(i));
            }
        } else {
            for (int i2 = 0; i2 < size; i2++) {
                iZzA += zzdn.zzA(((Integer) list.get(i2)).intValue());
            }
        }
        return iZzA;
    }

    static int zzl(List list) {
        int size = list.size();
        int iZzB = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfb) {
            zzfb zzfbVar = (zzfb) list;
            for (int i = 0; i < size; i++) {
                iZzB += zzdn.zzB(zzfbVar.zze(i));
            }
        } else {
            for (int i2 = 0; i2 < size; i2++) {
                iZzB += zzdn.zzB(((Long) list.get(i2)).longValue());
            }
        }
        return iZzB;
    }

    public static zzgs zzm() {
        return zzb;
    }

    static Object zzn(Object obj, int i, int i2, Object obj2, zzgs zzgsVar) {
        zzeh zzehVar;
        zzgt zzgtVar;
        Object obj3 = obj2;
        if (obj2 == null && (zzgtVar = (zzehVar = (zzeh) obj).zzc) == zzgt.zzc()) {
            obj3 = zzgtVar;
            zzgt zzgtVarZzf = zzgt.zzf();
            zzehVar.zzc = zzgtVarZzf;
            obj3 = zzgtVarZzf;
        }
        obj3 = zzgtVar;
        ((zzgt) obj3).zzj(i << 3, Long.valueOf(i2));
        return obj3;
    }

    static void zzo(zzdt zzdtVar, Object obj, Object obj2) {
        zzdx zzdxVar = ((zzed) obj2).zzb;
        if (zzdxVar.zza.isEmpty()) {
            return;
        }
        ((zzed) obj).zzc().zzh(zzdxVar);
    }

    static void zzp(zzgs zzgsVar, Object obj, Object obj2) {
        zzeh zzehVar = (zzeh) obj;
        zzgt zzgtVarZze = zzehVar.zzc;
        zzgt zzgtVar = ((zzeh) obj2).zzc;
        if (!zzgt.zzc().equals(zzgtVar)) {
            if (zzgt.zzc().equals(zzgtVarZze)) {
                zzgtVarZze = zzgt.zze(zzgtVarZze, zzgtVar);
            } else {
                zzgtVarZze.zzd(zzgtVar);
            }
        }
        zzehVar.zzc = zzgtVarZze;
    }

    public static void zzq(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzc(i, list, z);
    }

    public static void zzr(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzg(i, list, z);
    }

    public static void zzs(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzj(i, list, z);
    }

    public static void zzt(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzl(i, list, z);
    }

    public static void zzu(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzn(i, list, z);
    }

    public static void zzv(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzp(i, list, z);
    }

    public static void zzw(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzs(i, list, z);
    }

    public static void zzx(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzu(i, list, z);
    }

    public static void zzy(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzy(i, list, z);
    }

    public static void zzz(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzA(i, list, z);
    }
}
