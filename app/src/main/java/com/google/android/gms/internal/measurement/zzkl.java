package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes4.dex */
public class zzkl {
    private static final zzjh zza = zzjh.zza;
    private zzih zzb;
    private volatile zzlh zzc;
    private volatile zzih zzd;

    public int hashCode() {
        return 1;
    }

    public final int zzb() {
        if (this.zzd != null) {
            return this.zzd.zzb();
        }
        if (this.zzc != null) {
            return this.zzc.zzby();
        }
        return 0;
    }

    public final zzih zzc() {
        if (this.zzd != null) {
            return this.zzd;
        }
        synchronized (this) {
            if (this.zzd != null) {
                return this.zzd;
            }
            if (this.zzc == null) {
                this.zzd = zzih.zza;
            } else {
                this.zzd = this.zzc.zzbw();
            }
            return this.zzd;
        }
    }

    private final zzlh zzb(zzlh zzlhVar) {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    try {
                        this.zzc = zzlhVar;
                        this.zzd = zzih.zza;
                    } catch (zzkc unused) {
                        this.zzc = zzlhVar;
                        this.zzd = zzih.zza;
                    }
                }
            }
        }
        return this.zzc;
    }

    public final zzlh zza(zzlh zzlhVar) {
        zzlh zzlhVar2 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzlhVar;
        return zzlhVar2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzkl)) {
            return false;
        }
        zzkl zzklVar = (zzkl) obj;
        zzlh zzlhVar = this.zzc;
        zzlh zzlhVar2 = zzklVar.zzc;
        if (zzlhVar == null && zzlhVar2 == null) {
            return zzc().equals(zzklVar.zzc());
        }
        if (zzlhVar != null && zzlhVar2 != null) {
            return zzlhVar.equals(zzlhVar2);
        }
        if (zzlhVar != null) {
            return zzlhVar.equals(zzklVar.zzb(zzlhVar.zzaj()));
        }
        return zzb(zzlhVar2.zzaj()).equals(zzlhVar2);
    }
}
