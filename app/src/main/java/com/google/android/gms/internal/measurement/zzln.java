package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
final class zzln<T> implements zzlz<T> {
    private final zzlh zza;
    private final zzmu<?, ?> zzb;
    private final boolean zzc;
    private final zzjj<?> zzd;

    @Override // com.google.android.gms.internal.measurement.zzlz
    public final int zza(T t) {
        zzmu<?, ?> zzmuVar = this.zzb;
        int iZzb = zzmuVar.zzb(zzmuVar.zzd(t));
        return this.zzc ? iZzb + this.zzd.zza(t).zza() : iZzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzlz
    public final int zzb(T t) {
        int iHashCode = this.zzb.zzd(t).hashCode();
        return this.zzc ? (iHashCode * 53) + this.zzd.zza(t).hashCode() : iHashCode;
    }

    static <T> zzln<T> zza(zzmu<?, ?> zzmuVar, zzjj<?> zzjjVar, zzlh zzlhVar) {
        return new zzln<>(zzmuVar, zzjjVar, zzlhVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzlz
    public final T zza() {
        zzlh zzlhVar = this.zza;
        if (zzlhVar instanceof zzju) {
            return (T) ((zzju) zzlhVar).zzcb();
        }
        return (T) zzlhVar.zzcf().zzai();
    }

    private zzln(zzmu<?, ?> zzmuVar, zzjj<?> zzjjVar, zzlh zzlhVar) {
        this.zzb = zzmuVar;
        this.zzc = zzjjVar.zza(zzlhVar);
        this.zzd = zzjjVar;
        this.zza = zzlhVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzlz
    public final void zzc(T t) {
        this.zzb.zzf(t);
        this.zzd.zzc(t);
    }

    @Override // com.google.android.gms.internal.measurement.zzlz
    public final void zza(T t, T t2) {
        zzmb.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzmb.zza(this.zzd, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlz
    public final void zza(T t, zzlw zzlwVar, zzjh zzjhVar) throws IOException {
        boolean zZzt;
        zzmu<?, ?> zzmuVar = this.zzb;
        zzjj<?> zzjjVar = this.zzd;
        Object objZzc = zzmuVar.zzc(t);
        zzjk<T> zzjkVarZzb = zzjjVar.zzb(t);
        while (zzlwVar.zzc() != Integer.MAX_VALUE) {
            try {
                int iZzd = zzlwVar.zzd();
                if (iZzd != 11) {
                    if ((iZzd & 7) == 2) {
                        Object objZza = zzjjVar.zza(zzjhVar, this.zza, iZzd >>> 3);
                        if (objZza != null) {
                            zzjjVar.zza(zzlwVar, objZza, zzjhVar, zzjkVarZzb);
                        } else {
                            zZzt = zzmuVar.zza(objZzc, zzlwVar);
                        }
                    } else {
                        zZzt = zzlwVar.zzt();
                    }
                    if (!zZzt) {
                        zzmuVar.zzb(t, objZzc);
                        return;
                    }
                } else {
                    Object objZza2 = null;
                    int iZzj = 0;
                    zzih zzihVarZzp = null;
                    while (zzlwVar.zzc() != Integer.MAX_VALUE) {
                        int iZzd2 = zzlwVar.zzd();
                        if (iZzd2 == 16) {
                            iZzj = zzlwVar.zzj();
                            objZza2 = zzjjVar.zza(zzjhVar, this.zza, iZzj);
                        } else if (iZzd2 == 26) {
                            if (objZza2 != null) {
                                zzjjVar.zza(zzlwVar, objZza2, zzjhVar, zzjkVarZzb);
                            } else {
                                zzihVarZzp = zzlwVar.zzp();
                            }
                        } else if (!zzlwVar.zzt()) {
                            break;
                        }
                    }
                    if (zzlwVar.zzd() != 12) {
                        throw zzkc.zzb();
                    }
                    if (zzihVarZzp != null) {
                        if (objZza2 != null) {
                            zzjjVar.zza(zzihVarZzp, objZza2, zzjhVar, zzjkVarZzb);
                        } else {
                            zzmuVar.zza(objZzc, iZzj, zzihVarZzp);
                        }
                    }
                }
            } catch (Throwable th) {
                zzmuVar.zzb(t, objZzc);
                throw th;
            }
        }
        zzmuVar.zzb(t, objZzc);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0094  */
    /* JADX WARN: Code duplicated, block: B:56:0x0099 A[EDGE_INSN: B:56:0x0099->B:34:0x0099 BREAK  A[LOOP:1: B:18:0x0053->B:61:0x0053], SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzlz
    public final void zza(T t, byte[] bArr, int i, int i2, zzig zzigVar) throws IOException {
        zzju zzjuVar = (zzju) t;
        zzmx zzmxVarZzd = zzjuVar.zzb;
        if (zzmxVarZzd == zzmx.zzc()) {
            zzmxVarZzd = zzmx.zzd();
            zzjuVar.zzb = zzmxVarZzd;
        }
        ((zzju.zzb) t).zza();
        zzju.zzd zzdVar = null;
        while (i < i2) {
            int iZzc = zzid.zzc(bArr, i, zzigVar);
            int i3 = zzigVar.zza;
            if (i3 == 11) {
                int i4 = 0;
                zzih zzihVar = null;
                while (iZzc < i2) {
                    iZzc = zzid.zzc(bArr, iZzc, zzigVar);
                    int i5 = zzigVar.zza;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 == 2) {
                        if (i7 != 0) {
                            if (i5 != 12) {
                                break;
                                break;
                            }
                            iZzc = zzid.zza(i5, bArr, iZzc, i2, zzigVar);
                        } else {
                            iZzc = zzid.zzc(bArr, iZzc, zzigVar);
                            i4 = zzigVar.zza;
                            zzdVar = (zzju.zzd) this.zzd.zza(zzigVar.zzd, this.zza, i4);
                        }
                    } else {
                        if (i6 == 3) {
                            if (zzdVar != null) {
                                zzlv.zza();
                                throw new NoSuchMethodError();
                            }
                            if (i7 == 2) {
                                iZzc = zzid.zza(bArr, iZzc, zzigVar);
                                zzihVar = (zzih) zzigVar.zzc;
                            }
                        }
                        if (i5 != 12) {
                            break;
                        } else {
                            iZzc = zzid.zza(i5, bArr, iZzc, i2, zzigVar);
                        }
                    }
                }
                if (zzihVar != null) {
                    zzmxVarZzd.zza((i4 << 3) | 2, zzihVar);
                }
                i = iZzc;
            } else if ((i3 & 7) == 2) {
                zzdVar = (zzju.zzd) this.zzd.zza(zzigVar.zzd, this.zza, i3 >>> 3);
                if (zzdVar != null) {
                    zzlv.zza();
                    throw new NoSuchMethodError();
                }
                i = zzid.zza(i3, bArr, iZzc, i2, zzmxVarZzd, zzigVar);
            } else {
                i = zzid.zza(i3, bArr, iZzc, i2, zzigVar);
            }
        }
        if (i != i2) {
            throw zzkc.zzg();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlz
    public final void zza(T t, zznu zznuVar) throws IOException {
        Iterator itZzd = this.zzd.zza(t).zzd();
        while (itZzd.hasNext()) {
            Map.Entry entry = (Map.Entry) itZzd.next();
            zzjm zzjmVar = (zzjm) entry.getKey();
            if (zzjmVar.zzc() != zznr.MESSAGE || zzjmVar.zze() || zzjmVar.zzd()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof zzkg) {
                zznuVar.zza(zzjmVar.zza(), (Object) ((zzkg) entry).zza().zzc());
            } else {
                zznuVar.zza(zzjmVar.zza(), entry.getValue());
            }
        }
        zzmu<?, ?> zzmuVar = this.zzb;
        zzmuVar.zza(zzmuVar.zzd(t), zznuVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzlz
    public final boolean zzb(T t, T t2) {
        if (!this.zzb.zzd(t).equals(this.zzb.zzd(t2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza(t).equals(this.zzd.zza(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzlz
    public final boolean zzd(T t) {
        return this.zzd.zza(t).zzg();
    }
}
