package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
final class zzjd implements zznu {
    private final zzjb zza;

    public static zzjd zza(zzjb zzjbVar) {
        zzjd zzjdVar = zzjbVar.zza;
        return zzjdVar != null ? zzjdVar : new zzjd(zzjbVar);
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final int zza() {
        return zznt.zza;
    }

    private zzjd(zzjb zzjbVar) {
        zzjb zzjbVar2 = (zzjb) zzjx.zza(zzjbVar, "output");
        this.zza = zzjbVar2;
        zzjbVar2.zza = this;
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zza(int i, boolean z) throws IOException {
        this.zza.zzb(i, z);
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zza(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzj(i, 2);
            int iZza = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZza += zzjb.zza(list.get(i3).booleanValue());
            }
            this.zza.zzk(iZza);
            while (i2 < list.size()) {
                this.zza.zzb(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzb(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zza(int i, zzih zzihVar) throws IOException {
        this.zza.zzc(i, zzihVar);
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zza(int i, List<zzih> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zzc(i, list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zza(int i, double d) throws IOException {
        this.zza.zzb(i, d);
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zzb(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzj(i, 2);
            int iZza = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZza += zzjb.zza(list.get(i3).doubleValue());
            }
            this.zza.zzk(iZza);
            while (i2 < list.size()) {
                this.zza.zzb(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzb(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    @Deprecated
    public final void zza(int i) throws IOException {
        this.zza.zzj(i, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zza(int i, int i2) throws IOException {
        this.zza.zzh(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zzc(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzj(i, 2);
            int iZza = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZza += zzjb.zza(list.get(i3).intValue());
            }
            this.zza.zzk(iZza);
            while (i2 < list.size()) {
                this.zza.zzi(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzh(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zzb(int i, int i2) throws IOException {
        this.zza.zzg(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zzd(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzj(i, 2);
            int iZzb = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzb += zzjb.zzb(list.get(i3).intValue());
            }
            this.zza.zzk(iZzb);
            while (i2 < list.size()) {
                this.zza.zzh(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzg(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zza(int i, long j) throws IOException {
        this.zza.zzf(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzj(i, 2);
            int iZza = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZza += zzjb.zza(list.get(i3).longValue());
            }
            this.zza.zzk(iZza);
            while (i2 < list.size()) {
                this.zza.zzf(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzf(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zza(int i, float f) throws IOException {
        this.zza.zzb(i, f);
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzj(i, 2);
            int iZza = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZza += zzjb.zza(list.get(i3).floatValue());
            }
            this.zza.zzk(iZza);
            while (i2 < list.size()) {
                this.zza.zzb(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzb(i, list.get(i2).floatValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zza(int i, Object obj, zzlz zzlzVar) throws IOException {
        zzjb zzjbVar = this.zza;
        zzjbVar.zzj(i, 3);
        zzlzVar.zza((zzlh) obj, zzjbVar.zza);
        zzjbVar.zzj(i, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zza(int i, List<?> list, zzlz zzlzVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, list.get(i2), zzlzVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zzc(int i, int i2) throws IOException {
        this.zza.zzh(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zzg(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzj(i, 2);
            int iZzc = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzc += zzjb.zzc(list.get(i3).intValue());
            }
            this.zza.zzk(iZzc);
            while (i2 < list.size()) {
                this.zza.zzi(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzh(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zzb(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zzh(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzj(i, 2);
            int iZzb = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzb += zzjb.zzb(list.get(i3).longValue());
            }
            this.zza.zzk(iZzb);
            while (i2 < list.size()) {
                this.zza.zzh(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzh(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final <K, V> void zza(int i, zzky<K, V> zzkyVar, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.zza.zzj(i, 2);
            this.zza.zzk(zzkz.zza(zzkyVar, entry.getKey(), entry.getValue()));
            zzkz.zza(this.zza, zzkyVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zzb(int i, Object obj, zzlz zzlzVar) throws IOException {
        this.zza.zzc(i, (zzlh) obj, zzlzVar);
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zzb(int i, List<?> list, zzlz zzlzVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, list.get(i2), zzlzVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzih) {
            this.zza.zzd(i, (zzih) obj);
        } else {
            this.zza.zzb(i, (zzlh) obj);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zzd(int i, int i2) throws IOException {
        this.zza.zzg(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zzi(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzj(i, 2);
            int iZzd = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzd += zzjb.zzd(list.get(i3).intValue());
            }
            this.zza.zzk(iZzd);
            while (i2 < list.size()) {
                this.zza.zzh(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzg(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zzc(int i, long j) throws IOException {
        this.zza.zzf(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zzj(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzj(i, 2);
            int iZzc = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzc += zzjb.zzc(list.get(i3).longValue());
            }
            this.zza.zzk(iZzc);
            while (i2 < list.size()) {
                this.zza.zzf(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzf(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zze(int i, int i2) throws IOException {
        this.zza.zzi(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzj(i, 2);
            int iZze = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZze += zzjb.zze(list.get(i3).intValue());
            }
            this.zza.zzk(iZze);
            while (i2 < list.size()) {
                this.zza.zzj(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzi(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zzd(int i, long j) throws IOException {
        this.zza.zzg(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzj(i, 2);
            int iZzd = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzd += zzjb.zzd(list.get(i3).longValue());
            }
            this.zza.zzk(iZzd);
            while (i2 < list.size()) {
                this.zza.zzg(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzg(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    @Deprecated
    public final void zzb(int i) throws IOException {
        this.zza.zzj(i, 3);
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zza(int i, String str) throws IOException {
        this.zza.zzb(i, str);
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zzb(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzkn) {
            zzkn zzknVar = (zzkn) list;
            while (i2 < list.size()) {
                Object objZzb = zzknVar.zzb(i2);
                if (objZzb instanceof String) {
                    this.zza.zzb(i, (String) objZzb);
                } else {
                    this.zza.zzc(i, (zzih) objZzb);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzb(i, list.get(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zzf(int i, int i2) throws IOException {
        this.zza.zzk(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzj(i, 2);
            int iZzg = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzg += zzjb.zzg(list.get(i3).intValue());
            }
            this.zza.zzk(iZzg);
            while (i2 < list.size()) {
                this.zza.zzk(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzk(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zze(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzj(i, 2);
            int iZze = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZze += zzjb.zze(list.get(i3).longValue());
            }
            this.zza.zzk(iZze);
            while (i2 < list.size()) {
                this.zza.zzh(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzh(i, list.get(i2).longValue());
            i2++;
        }
    }
}
