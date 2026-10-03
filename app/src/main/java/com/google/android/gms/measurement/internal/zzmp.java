package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.util.Clock;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: loaded from: classes5.dex */
public final class zzmp extends zzg {
    protected final zzmx zza;
    protected final zzmv zzb;
    private Handler zzc;
    private boolean zzd;
    private final zzmq zze;

    @Override // com.google.android.gms.measurement.internal.zzio, com.google.android.gms.measurement.internal.zziq
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zzz() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzio, com.google.android.gms.measurement.internal.zziq
    @Pure
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zza zzc() {
        return super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzio, com.google.android.gms.measurement.internal.zziq
    @Pure
    public final /* bridge */ /* synthetic */ zzad zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    @Pure
    public final /* bridge */ /* synthetic */ zzae zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    @Pure
    public final /* bridge */ /* synthetic */ zzaz zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzfv zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzfu zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    @Pure
    public final /* bridge */ /* synthetic */ zzfw zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzio, com.google.android.gms.measurement.internal.zziq
    @Pure
    public final /* bridge */ /* synthetic */ zzgb zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    @Pure
    public final /* bridge */ /* synthetic */ zzgm zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzio, com.google.android.gms.measurement.internal.zziq
    @Pure
    public final /* bridge */ /* synthetic */ zzhh zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzja zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzkw zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzlf zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzmp zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    @Pure
    public final /* bridge */ /* synthetic */ zznw zzq() {
        return super.zzq();
    }

    static /* synthetic */ void zza(zzmp zzmpVar, long j) {
        zzmpVar.zzt();
        zzmpVar.zzab();
        zzmpVar.zzj().zzp().zza("Activity paused, time", Long.valueOf(j));
        zzmpVar.zze.zza(j);
        if (zzmpVar.zze().zzv()) {
            zzmpVar.zzb.zzb(j);
        }
    }

    static /* synthetic */ void zzb(zzmp zzmpVar, long j) {
        zzmpVar.zzt();
        zzmpVar.zzab();
        zzmpVar.zzj().zzp().zza("Activity resumed, time", Long.valueOf(j));
        if (zzmpVar.zze().zza(zzbh.zzcn)) {
            if (zzmpVar.zze().zzv() || zzmpVar.zzd) {
                zzmpVar.zzb.zzc(j);
            }
        } else if (zzmpVar.zze().zzv() || zzmpVar.zzk().zzn.zza()) {
            zzmpVar.zzb.zzc(j);
        }
        zzmpVar.zze.zza();
        zzmx zzmxVar = zzmpVar.zza;
        zzmxVar.zza.zzt();
        if (zzmxVar.zza.zzu.zzac()) {
            zzmxVar.zza(zzmxVar.zza.zzb().currentTimeMillis(), false);
        }
    }

    zzmp(zzho zzhoVar) {
        super(zzhoVar);
        this.zzd = true;
        this.zza = new zzmx(this);
        this.zzb = new zzmv(this);
        this.zze = new zzmq(this);
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ void zzr() {
        super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzab() {
        zzt();
        if (this.zzc == null) {
            this.zzc = new com.google.android.gms.internal.measurement.zzdc(Looper.getMainLooper());
        }
    }

    final void zza(boolean z) {
        zzt();
        this.zzd = z;
    }

    final boolean zzaa() {
        zzt();
        return this.zzd;
    }

    public final boolean zza(boolean z, boolean z2, long j) {
        return this.zzb.zza(z, z2, j);
    }
}
