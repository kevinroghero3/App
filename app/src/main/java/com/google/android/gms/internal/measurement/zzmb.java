package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes4.dex */
final class zzmb {
    private static final Class<?> zza = zzd();
    private static final zzmu<?, ?> zzb = zzc();
    private static final zzmu<?, ?> zzc = new zzmw();

    static int zza(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzjb.zza(i, true);
    }

    static int zza(List<?> list) {
        return list.size();
    }

    static int zza(int i, List<zzih> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzf = size * zzjb.zzf(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            iZzf += zzjb.zza(list.get(i2));
        }
        return iZzf;
    }

    static int zzb(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzjb.zzf(i));
    }

    static int zzb(List<Integer> list) {
        int size = list.size();
        int iZza = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzjv) {
            zzjv zzjvVar = (zzjv) list;
            for (int i = 0; i < size; i++) {
                iZza += zzjb.zza(zzjvVar.zzb(i));
            }
        } else {
            for (int i2 = 0; i2 < size; i2++) {
                iZza += zzjb.zza(list.get(i2).intValue());
            }
        }
        return iZza;
    }

    static int zzc(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzjb.zzb(i, 0);
    }

    static int zzc(List<?> list) {
        return list.size() << 2;
    }

    static int zzd(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzjb.zza(i, 0L);
    }

    static int zzd(List<?> list) {
        return list.size() << 3;
    }

    static int zza(int i, List<zzlh> list, zzlz zzlzVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZza = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZza += zzjb.zza(i, list.get(i2), zzlzVar);
        }
        return iZza;
    }

    static int zze(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzjb.zzf(i));
    }

    static int zze(List<Integer> list) {
        int size = list.size();
        int iZzc = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzjv) {
            zzjv zzjvVar = (zzjv) list;
            for (int i = 0; i < size; i++) {
                iZzc += zzjb.zzc(zzjvVar.zzb(i));
            }
        } else {
            for (int i2 = 0; i2 < size; i2++) {
                iZzc += zzjb.zzc(list.get(i2).intValue());
            }
        }
        return iZzc;
    }

    static int zzf(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzf(list) + (list.size() * zzjb.zzf(i));
    }

    static int zzf(List<Long> list) {
        int size = list.size();
        int iZzb = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzks) {
            zzks zzksVar = (zzks) list;
            for (int i = 0; i < size; i++) {
                iZzb += zzjb.zzb(zzksVar.zzb(i));
            }
        } else {
            for (int i2 = 0; i2 < size; i2++) {
                iZzb += zzjb.zzb(list.get(i2).longValue());
            }
        }
        return iZzb;
    }

    static int zza(int i, Object obj, zzlz zzlzVar) {
        if (obj instanceof zzkl) {
            return zzjb.zzb(i, (zzkl) obj);
        }
        return zzjb.zzb(i, (zzlh) obj, zzlzVar);
    }

    static int zzb(int i, List<?> list, zzlz zzlzVar) {
        int iZza;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzf = zzjb.zzf(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zzkl) {
                iZza = zzjb.zza((zzkl) obj);
            } else {
                iZza = zzjb.zza((zzlh) obj, zzlzVar);
            }
            iZzf += iZza;
        }
        return iZzf;
    }

    static int zzg(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzjb.zzf(i));
    }

    static int zzg(List<Integer> list) {
        int size = list.size();
        int iZze = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzjv) {
            zzjv zzjvVar = (zzjv) list;
            for (int i = 0; i < size; i++) {
                iZze += zzjb.zze(zzjvVar.zzb(i));
            }
        } else {
            for (int i2 = 0; i2 < size; i2++) {
                iZze += zzjb.zze(list.get(i2).intValue());
            }
        }
        return iZze;
    }

    static int zzh(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzh(list) + (size * zzjb.zzf(i));
    }

    static int zzh(List<Long> list) {
        int size = list.size();
        int iZzd = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzks) {
            zzks zzksVar = (zzks) list;
            for (int i = 0; i < size; i++) {
                iZzd += zzjb.zzd(zzksVar.zzb(i));
            }
        } else {
            for (int i2 = 0; i2 < size; i2++) {
                iZzd += zzjb.zzd(list.get(i2).longValue());
            }
        }
        return iZzd;
    }

    static int zzb(int i, List<?> list) {
        int iZza;
        int iZza2;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int iZzf = zzjb.zzf(i) * size;
        if (list instanceof zzkn) {
            zzkn zzknVar = (zzkn) list;
            while (i2 < size) {
                Object objZzb = zzknVar.zzb(i2);
                if (objZzb instanceof zzih) {
                    iZza2 = zzjb.zza((zzih) objZzb);
                } else {
                    iZza2 = zzjb.zza((String) objZzb);
                }
                iZzf += iZza2;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzih) {
                    iZza = zzjb.zza((zzih) obj);
                } else {
                    iZza = zzjb.zza((String) obj);
                }
                iZzf += iZza;
                i2++;
            }
        }
        return iZzf;
    }

    static int zzi(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzi(list) + (size * zzjb.zzf(i));
    }

    static int zzi(List<Integer> list) {
        int size = list.size();
        int iZzg = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzjv) {
            zzjv zzjvVar = (zzjv) list;
            for (int i = 0; i < size; i++) {
                iZzg += zzjb.zzg(zzjvVar.zzb(i));
            }
        } else {
            for (int i2 = 0; i2 < size; i2++) {
                iZzg += zzjb.zzg(list.get(i2).intValue());
            }
        }
        return iZzg;
    }

    static int zzj(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzj(list) + (size * zzjb.zzf(i));
    }

    static int zzj(List<Long> list) {
        int size = list.size();
        int iZze = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzks) {
            zzks zzksVar = (zzks) list;
            for (int i = 0; i < size; i++) {
                iZze += zzjb.zze(zzksVar.zzb(i));
            }
        } else {
            for (int i2 = 0; i2 < size; i2++) {
                iZze += zzjb.zze(list.get(i2).longValue());
            }
        }
        return iZze;
    }

    private static zzmu<?, ?> zzc() {
        try {
            Class<?> clsZze = zze();
            if (clsZze == null) {
                return null;
            }
            return (zzmu) clsZze.getConstructor(null).newInstance(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static zzmu<?, ?> zza() {
        return zzb;
    }

    public static zzmu<?, ?> zzb() {
        return zzc;
    }

    private static Class<?> zzd() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zze() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static <UT, UB> UB zza(Object obj, int i, List<Integer> list, zzjy zzjyVar, UB ub, zzmu<UT, UB> zzmuVar) {
        if (zzjyVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Integer num = list.get(i3);
                int iIntValue = num.intValue();
                if (zzjyVar.zza(iIntValue)) {
                    if (i3 != i2) {
                        list.set(i2, num);
                    }
                    i2++;
                } else {
                    ub = (UB) zza(obj, i, iIntValue, ub, zzmuVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it2 = list.iterator();
            while (it2.hasNext()) {
                int iIntValue2 = it2.next().intValue();
                if (!zzjyVar.zza(iIntValue2)) {
                    ub = (UB) zza(obj, i, iIntValue2, ub, zzmuVar);
                    it2.remove();
                }
            }
        }
        return ub;
    }

    static <UT, UB> UB zza(Object obj, int i, int i2, UB ub, zzmu<UT, UB> zzmuVar) {
        if (ub == null) {
            ub = zzmuVar.zzc(obj);
        }
        zzmuVar.zzb(ub, i, i2);
        return ub;
    }

    static <T, FT extends zzjm<FT>> void zza(zzjj<FT> zzjjVar, T t, T t2) {
        zzjk<T> zzjkVarZza = zzjjVar.zza(t2);
        if (zzjkVarZza.zza.isEmpty()) {
            return;
        }
        zzjjVar.zzb(t).zza((zzjk) zzjkVarZza);
    }

    static <T> void zza(zzla zzlaVar, T t, T t2, long j) {
        zzna.zza(t, j, zzlaVar.zza(zzna.zze(t, j), zzna.zze(t2, j)));
    }

    static <T, UT, UB> void zza(zzmu<UT, UB> zzmuVar, T t, T t2) {
        zzmuVar.zzc(t, zzmuVar.zza(zzmuVar.zzd(t), zzmuVar.zzd(t2)));
    }

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzju.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List<Boolean> list, zznu zznuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznuVar.zza(i, list, z);
    }

    public static void zza(int i, List<zzih> list, zznu zznuVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznuVar.zza(i, list);
    }

    public static void zzb(int i, List<Double> list, zznu zznuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznuVar.zzb(i, list, z);
    }

    public static void zzc(int i, List<Integer> list, zznu zznuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznuVar.zzc(i, list, z);
    }

    public static void zzd(int i, List<Integer> list, zznu zznuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznuVar.zzd(i, list, z);
    }

    public static void zze(int i, List<Long> list, zznu zznuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznuVar.zze(i, list, z);
    }

    public static void zzf(int i, List<Float> list, zznu zznuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznuVar.zzf(i, list, z);
    }

    public static void zza(int i, List<?> list, zznu zznuVar, zzlz zzlzVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznuVar.zza(i, list, zzlzVar);
    }

    public static void zzg(int i, List<Integer> list, zznu zznuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznuVar.zzg(i, list, z);
    }

    public static void zzh(int i, List<Long> list, zznu zznuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznuVar.zzh(i, list, z);
    }

    public static void zzb(int i, List<?> list, zznu zznuVar, zzlz zzlzVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznuVar.zzb(i, list, zzlzVar);
    }

    public static void zzi(int i, List<Integer> list, zznu zznuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznuVar.zzi(i, list, z);
    }

    public static void zzj(int i, List<Long> list, zznu zznuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznuVar.zzj(i, list, z);
    }

    public static void zzk(int i, List<Integer> list, zznu zznuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznuVar.zzk(i, list, z);
    }

    public static void zzl(int i, List<Long> list, zznu zznuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznuVar.zzl(i, list, z);
    }

    public static void zzb(int i, List<String> list, zznu zznuVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznuVar.zzb(i, list);
    }

    public static void zzm(int i, List<Integer> list, zznu zznuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznuVar.zzm(i, list, z);
    }

    public static void zzn(int i, List<Long> list, zznu zznuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznuVar.zzn(i, list, z);
    }

    static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}
