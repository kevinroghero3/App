package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
final class zziz implements zzlw {
    private final zziv zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final double zza() throws IOException {
        zzb(1);
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final float zzb() throws IOException {
        zzb(5);
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final int zzc() throws IOException {
        int i = this.zzd;
        if (i != 0) {
            this.zzb = i;
            this.zzd = 0;
        } else {
            this.zzb = this.zza.zzi();
        }
        int i2 = this.zzb;
        if (i2 == 0 || i2 == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final int zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final int zze() throws IOException {
        zzb(0);
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final int zzf() throws IOException {
        zzb(5);
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final int zzg() throws IOException {
        zzb(0);
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final int zzh() throws IOException {
        zzb(5);
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final int zzi() throws IOException {
        zzb(0);
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final int zzj() throws IOException {
        zzb(0);
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final long zzk() throws IOException {
        zzb(1);
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final long zzl() throws IOException {
        zzb(0);
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final long zzm() throws IOException {
        zzb(1);
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final long zzn() throws IOException {
        zzb(0);
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final long zzo() throws IOException {
        zzb(0);
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final zzih zzp() throws IOException {
        zzb(2);
        return this.zza.zzq();
    }

    public static zziz zza(zziv zzivVar) {
        zziz zzizVar = zzivVar.zzc;
        return zzizVar != null ? zzizVar : new zziz(zzivVar);
    }

    private final Object zza(zznh zznhVar, Class<?> cls, zzjh zzjhVar) throws IOException {
        switch (zzjc.zza[zznhVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzs());
            case 2:
                return zzp();
            case 3:
                return Double.valueOf(zza());
            case 4:
                return Integer.valueOf(zze());
            case 5:
                return Integer.valueOf(zzf());
            case 6:
                return Long.valueOf(zzk());
            case 7:
                return Float.valueOf(zzb());
            case 8:
                return Integer.valueOf(zzg());
            case 9:
                return Long.valueOf(zzl());
            case 10:
                zzb(2);
                return zzb(zzlv.zza().zza((Class) cls), zzjhVar);
            case 11:
                return Integer.valueOf(zzh());
            case 12:
                return Long.valueOf(zzm());
            case 13:
                return Integer.valueOf(zzi());
            case 14:
                return Long.valueOf(zzn());
            case 15:
                return zzr();
            case 16:
                return Integer.valueOf(zzj());
            case 17:
                return Long.valueOf(zzo());
            default:
                throw new IllegalArgumentException("unsupported field type.");
        }
    }

    private final <T> T zza(zzlz<T> zzlzVar, zzjh zzjhVar) throws IOException {
        T tZza = zzlzVar.zza();
        zzc(tZza, zzlzVar, zzjhVar);
        zzlzVar.zzc(tZza);
        return tZza;
    }

    private final <T> T zzb(zzlz<T> zzlzVar, zzjh zzjhVar) throws IOException {
        T tZza = zzlzVar.zza();
        zzd(tZza, zzlzVar, zzjhVar);
        zzlzVar.zzc(tZza);
        return tZza;
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final String zzq() throws IOException {
        zzb(2);
        return this.zza.zzr();
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final String zzr() throws IOException {
        zzb(2);
        return this.zza.zzs();
    }

    private zziz(zziv zzivVar) {
        zziv zzivVar2 = (zziv) zzjx.zza(zzivVar, "input");
        this.zza = zzivVar2;
        zzivVar2.zzc = this;
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final <T> void zza(T t, zzlz<T> zzlzVar, zzjh zzjhVar) throws IOException {
        zzb(3);
        zzc(t, zzlzVar, zzjhVar);
    }

    private final <T> void zzc(T t, zzlz<T> zzlzVar, zzjh zzjhVar) throws IOException {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzlzVar.zza(t, this, zzjhVar);
            if (this.zzb != this.zzc) {
                throw zzkc.zzg();
            }
            this.zzc = i;
        } catch (Throwable th) {
            this.zzc = i;
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final <T> void zzb(T t, zzlz<T> zzlzVar, zzjh zzjhVar) throws IOException {
        zzb(2);
        zzd(t, zzlzVar, zzjhVar);
    }

    private final <T> void zzd(T t, zzlz<T> zzlzVar, zzjh zzjhVar) throws IOException {
        int iZzj = this.zza.zzj();
        zziv zzivVar = this.zza;
        if (zzivVar.zza >= zzivVar.zzb) {
            throw new zzkc("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int iZzb = zzivVar.zzb(iZzj);
        this.zza.zza++;
        zzlzVar.zza(t, this, zzjhVar);
        this.zza.zzc(0);
        zziv zzivVar2 = this.zza;
        zzivVar2.zza--;
        zzivVar2.zzd(iZzb);
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final void zza(List<Boolean> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzif) {
            zzif zzifVar = (zzif) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzifVar.zza(this.zza.zzu());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzifVar.zza(this.zza.zzu());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzkc.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Boolean.valueOf(this.zza.zzu()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i2 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Boolean.valueOf(this.zza.zzu()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzkc.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final void zzb(List<zzih> list) throws IOException {
        int iZzi;
        if ((this.zzb & 7) != 2) {
            throw zzkc.zza();
        }
        do {
            list.add(zzp());
            if (this.zza.zzt()) {
                return;
            } else {
                iZzi = this.zza.zzi();
            }
        } while (iZzi == this.zzb);
        this.zzd = iZzi;
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final void zzc(List<Double> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzjg) {
            zzjg zzjgVar = (zzjg) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzjgVar.zza(this.zza.zza());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i == 2) {
                int iZzj = this.zza.zzj();
                zzd(iZzj);
                int iZzc = this.zza.zzc();
                do {
                    zzjgVar.zza(this.zza.zza());
                } while (this.zza.zzc() < iZzc + iZzj);
                return;
            }
            throw zzkc.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 1) {
            do {
                list.add(Double.valueOf(this.zza.zza()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i2 == 2) {
            int iZzj2 = this.zza.zzj();
            zzd(iZzj2);
            int iZzc2 = this.zza.zzc();
            do {
                list.add(Double.valueOf(this.zza.zza()));
            } while (this.zza.zzc() < iZzc2 + iZzj2);
            return;
        }
        throw zzkc.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final void zzd(List<Integer> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzjv) {
            zzjv zzjvVar = (zzjv) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzjvVar.zzd(this.zza.zzd());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzjvVar.zzd(this.zza.zzd());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzkc.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.zza.zzd()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i2 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Integer.valueOf(this.zza.zzd()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzkc.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final void zze(List<Integer> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzjv) {
            zzjv zzjvVar = (zzjv) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int iZzj = this.zza.zzj();
                zzc(iZzj);
                int iZzc = this.zza.zzc();
                do {
                    zzjvVar.zzd(this.zza.zze());
                } while (this.zza.zzc() < iZzc + iZzj);
                return;
            }
            if (i == 5) {
                do {
                    zzjvVar.zzd(this.zza.zze());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            throw zzkc.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 2) {
            int iZzj2 = this.zza.zzj();
            zzc(iZzj2);
            int iZzc2 = this.zza.zzc();
            do {
                list.add(Integer.valueOf(this.zza.zze()));
            } while (this.zza.zzc() < iZzc2 + iZzj2);
            return;
        }
        if (i2 == 5) {
            do {
                list.add(Integer.valueOf(this.zza.zze()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        throw zzkc.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final void zzf(List<Long> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzks) {
            zzks zzksVar = (zzks) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzksVar.zza(this.zza.zzk());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i == 2) {
                int iZzj = this.zza.zzj();
                zzd(iZzj);
                int iZzc = this.zza.zzc();
                do {
                    zzksVar.zza(this.zza.zzk());
                } while (this.zza.zzc() < iZzc + iZzj);
                return;
            }
            throw zzkc.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 1) {
            do {
                list.add(Long.valueOf(this.zza.zzk()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i2 == 2) {
            int iZzj2 = this.zza.zzj();
            zzd(iZzj2);
            int iZzc2 = this.zza.zzc();
            do {
                list.add(Long.valueOf(this.zza.zzk()));
            } while (this.zza.zzc() < iZzc2 + iZzj2);
            return;
        }
        throw zzkc.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final void zzg(List<Float> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzjq) {
            zzjq zzjqVar = (zzjq) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int iZzj = this.zza.zzj();
                zzc(iZzj);
                int iZzc = this.zza.zzc();
                do {
                    zzjqVar.zza(this.zza.zzb());
                } while (this.zza.zzc() < iZzc + iZzj);
                return;
            }
            if (i == 5) {
                do {
                    zzjqVar.zza(this.zza.zzb());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            throw zzkc.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 2) {
            int iZzj2 = this.zza.zzj();
            zzc(iZzj2);
            int iZzc2 = this.zza.zzc();
            do {
                list.add(Float.valueOf(this.zza.zzb()));
            } while (this.zza.zzc() < iZzc2 + iZzj2);
            return;
        }
        if (i2 == 5) {
            do {
                list.add(Float.valueOf(this.zza.zzb()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        throw zzkc.zza();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzlw
    @Deprecated
    public final <T> void zza(List<T> list, zzlz<T> zzlzVar, zzjh zzjhVar) throws IOException {
        int iZzi;
        int i = this.zzb;
        if ((i & 7) != 3) {
            throw zzkc.zza();
        }
        do {
            list.add(zza(zzlzVar, zzjhVar));
            if (this.zza.zzt() || this.zzd != 0) {
                return;
            } else {
                iZzi = this.zza.zzi();
            }
        } while (iZzi == i);
        this.zzd = iZzi;
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final void zzh(List<Integer> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzjv) {
            zzjv zzjvVar = (zzjv) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzjvVar.zzd(this.zza.zzf());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzjvVar.zzd(this.zza.zzf());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzkc.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.zza.zzf()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i2 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Integer.valueOf(this.zza.zzf()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzkc.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final void zzi(List<Long> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzks) {
            zzks zzksVar = (zzks) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzksVar.zza(this.zza.zzl());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzksVar.zza(this.zza.zzl());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzkc.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(this.zza.zzl()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i2 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Long.valueOf(this.zza.zzl()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzkc.zza();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzlw
    public final <K, V> void zza(Map<K, V> map, zzky<K, V> zzkyVar, zzjh zzjhVar) throws IOException {
        zzb(2);
        int iZzb = this.zza.zzb(this.zza.zzj());
        Object objZza = zzkyVar.zzb;
        Object objZza2 = zzkyVar.zzd;
        while (true) {
            try {
                int iZzc = zzc();
                if (iZzc == Integer.MAX_VALUE || this.zza.zzt()) {
                    break;
                }
                if (iZzc == 1) {
                    objZza = zza(zzkyVar.zza, (Class<?>) null, (zzjh) null);
                } else if (iZzc == 2) {
                    objZza2 = zza(zzkyVar.zzc, zzkyVar.zzd.getClass(), zzjhVar);
                } else {
                    try {
                        if (!zzt()) {
                            throw new zzkc("Unable to parse map entry.");
                        }
                    } catch (zzkf unused) {
                        if (!zzt()) {
                            throw new zzkc("Unable to parse map entry.");
                        }
                    }
                }
            } catch (Throwable th) {
                this.zza.zzd(iZzb);
                throw th;
            }
        }
        map.put(objZza, objZza2);
        this.zza.zzd(iZzb);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzlw
    public final <T> void zzb(List<T> list, zzlz<T> zzlzVar, zzjh zzjhVar) throws IOException {
        int iZzi;
        int i = this.zzb;
        if ((i & 7) != 2) {
            throw zzkc.zza();
        }
        do {
            list.add(zzb(zzlzVar, zzjhVar));
            if (this.zza.zzt() || this.zzd != 0) {
                return;
            } else {
                iZzi = this.zza.zzi();
            }
        } while (iZzi == i);
        this.zzd = iZzi;
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final void zzj(List<Integer> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzjv) {
            zzjv zzjvVar = (zzjv) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int iZzj = this.zza.zzj();
                zzc(iZzj);
                int iZzc = this.zza.zzc();
                do {
                    zzjvVar.zzd(this.zza.zzg());
                } while (this.zza.zzc() < iZzc + iZzj);
                return;
            }
            if (i == 5) {
                do {
                    zzjvVar.zzd(this.zza.zzg());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            throw zzkc.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 2) {
            int iZzj2 = this.zza.zzj();
            zzc(iZzj2);
            int iZzc2 = this.zza.zzc();
            do {
                list.add(Integer.valueOf(this.zza.zzg()));
            } while (this.zza.zzc() < iZzc2 + iZzj2);
            return;
        }
        if (i2 == 5) {
            do {
                list.add(Integer.valueOf(this.zza.zzg()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        throw zzkc.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final void zzk(List<Long> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzks) {
            zzks zzksVar = (zzks) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzksVar.zza(this.zza.zzn());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i == 2) {
                int iZzj = this.zza.zzj();
                zzd(iZzj);
                int iZzc = this.zza.zzc();
                do {
                    zzksVar.zza(this.zza.zzn());
                } while (this.zza.zzc() < iZzc + iZzj);
                return;
            }
            throw zzkc.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 1) {
            do {
                list.add(Long.valueOf(this.zza.zzn()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i2 == 2) {
            int iZzj2 = this.zza.zzj();
            zzd(iZzj2);
            int iZzc2 = this.zza.zzc();
            do {
                list.add(Long.valueOf(this.zza.zzn()));
            } while (this.zza.zzc() < iZzc2 + iZzj2);
            return;
        }
        throw zzkc.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final void zzl(List<Integer> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzjv) {
            zzjv zzjvVar = (zzjv) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzjvVar.zzd(this.zza.zzh());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzjvVar.zzd(this.zza.zzh());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzkc.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.zza.zzh()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i2 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Integer.valueOf(this.zza.zzh()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzkc.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final void zzm(List<Long> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzks) {
            zzks zzksVar = (zzks) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzksVar.zza(this.zza.zzo());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzksVar.zza(this.zza.zzo());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzkc.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(this.zza.zzo()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i2 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Long.valueOf(this.zza.zzo()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzkc.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final void zzn(List<String> list) throws IOException {
        zza(list, false);
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int iZzi;
        int iZzi2;
        if ((this.zzb & 7) != 2) {
            throw zzkc.zza();
        }
        if ((list instanceof zzkn) && !z) {
            zzkn zzknVar = (zzkn) list;
            do {
                zzknVar.zza(zzp());
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi2 = this.zza.zzi();
                }
            } while (iZzi2 == this.zzb);
            this.zzd = iZzi2;
            return;
        }
        do {
            list.add(z ? zzr() : zzq());
            if (this.zza.zzt()) {
                return;
            } else {
                iZzi = this.zza.zzi();
            }
        } while (iZzi == this.zzb);
        this.zzd = iZzi;
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final void zzo(List<String> list) throws IOException {
        zza(list, true);
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final void zzp(List<Integer> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzjv) {
            zzjv zzjvVar = (zzjv) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzjvVar.zzd(this.zza.zzj());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzjvVar.zzd(this.zza.zzj());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzkc.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.zza.zzj()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i2 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Integer.valueOf(this.zza.zzj()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzkc.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final void zzq(List<Long> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzks) {
            zzks zzksVar = (zzks) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzksVar.zza(this.zza.zzp());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzksVar.zza(this.zza.zzp());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzkc.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(this.zza.zzp()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i2 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Long.valueOf(this.zza.zzp()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzkc.zza();
    }

    private final void zza(int i) throws IOException {
        if (this.zza.zzc() != i) {
            throw zzkc.zzh();
        }
    }

    private final void zzb(int i) throws IOException {
        if ((this.zzb & 7) != i) {
            throw zzkc.zza();
        }
    }

    private static void zzc(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzkc.zzg();
        }
    }

    private static void zzd(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzkc.zzg();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final boolean zzs() throws IOException {
        zzb(0);
        return this.zza.zzu();
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final boolean zzt() throws IOException {
        int i;
        if (this.zza.zzt() || (i = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zze(i);
    }
}
