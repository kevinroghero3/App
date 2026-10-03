package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: loaded from: classes5.dex */
class zzio implements zziq {
    protected final zzho zzu;

    @Override // com.google.android.gms.measurement.internal.zziq
    @Pure
    public Context zza() {
        return this.zzu.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zziq
    @Pure
    public Clock zzb() {
        return this.zzu.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zziq
    @Pure
    public zzad zzd() {
        return this.zzu.zzd();
    }

    @Pure
    public zzae zze() {
        return this.zzu.zzf();
    }

    @Pure
    public zzaz zzf() {
        return this.zzu.zzg();
    }

    @Pure
    public zzfw zzi() {
        return this.zzu.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zziq
    @Pure
    public zzgb zzj() {
        return this.zzu.zzj();
    }

    @Pure
    public zzgm zzk() {
        return this.zzu.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zziq
    @Pure
    public zzhh zzl() {
        return this.zzu.zzl();
    }

    @Pure
    public zznw zzq() {
        return this.zzu.zzt();
    }

    zzio(zzho zzhoVar) {
        Preconditions.checkNotNull(zzhoVar);
        this.zzu = zzhoVar;
    }

    public void zzr() {
        this.zzu.zzl().zzr();
    }

    public void zzs() {
        this.zzu.zzy();
    }

    public void zzt() {
        this.zzu.zzl().zzt();
    }
}
