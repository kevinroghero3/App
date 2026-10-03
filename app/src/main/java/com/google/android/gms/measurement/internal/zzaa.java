package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzov;
import com.google.maps.android.BuildConfig;

/* JADX INFO: loaded from: classes4.dex */
final class zzaa extends zzab {
    private com.google.android.gms.internal.measurement.zzfg.zze zzg;
    private final /* synthetic */ zzs zzh;

    @Override // com.google.android.gms.measurement.internal.zzab
    final int zza() {
        return this.zzg.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzab
    final boolean zzb() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzab
    final boolean zzc() {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzaa(zzs zzsVar, String str, int i, com.google.android.gms.internal.measurement.zzfg.zze zzeVar) {
        super(str, i);
        this.zzh = zzsVar;
        this.zzg = zzeVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final boolean zza(Long l, Long l2, com.google.android.gms.internal.measurement.zzfs.zzn zznVar, boolean z) {
        byte b = zzov.zza() && this.zzh.zze().zzf(this.zza, zzbh.zzbg);
        boolean zZzf = this.zzg.zzf();
        boolean zZzg = this.zzg.zzg();
        boolean zZzh = this.zzg.zzh();
        byte b2 = zZzf || zZzg || zZzh;
        Boolean boolZza = null;
        boolZza = null;
        boolZza = null;
        boolZza = null;
        boolZza = null;
        if (z && b2 == false) {
            this.zzh.zzj().zzp().zza("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.zzb), this.zzg.zzi() ? Integer.valueOf(this.zzg.zza()) : null);
            return true;
        }
        com.google.android.gms.internal.measurement.zzfg.zzc zzcVarZzb = this.zzg.zzb();
        boolean zZzf2 = zzcVarZzb.zzf();
        if (zznVar.zzk()) {
            if (!zzcVarZzb.zzh()) {
                this.zzh.zzj().zzu().zza("No number filter for long property. property", this.zzh.zzi().zzc(zznVar.zzg()));
            } else {
                boolZza = zzab.zza(zzab.zza(zznVar.zzc(), zzcVarZzb.zzc()), zZzf2);
            }
        } else if (zznVar.zzi()) {
            if (!zzcVarZzb.zzh()) {
                this.zzh.zzj().zzu().zza("No number filter for double property. property", this.zzh.zzi().zzc(zznVar.zzg()));
            } else {
                boolZza = zzab.zza(zzab.zza(zznVar.zza(), zzcVarZzb.zzc()), zZzf2);
            }
        } else if (zznVar.zzm()) {
            if (!zzcVarZzb.zzj()) {
                if (!zzcVarZzb.zzh()) {
                    this.zzh.zzj().zzu().zza("No string or number filter defined. property", this.zzh.zzi().zzc(zznVar.zzg()));
                } else if (zznt.zzb(zznVar.zzh())) {
                    boolZza = zzab.zza(zzab.zza(zznVar.zzh(), zzcVarZzb.zzc()), zZzf2);
                } else {
                    this.zzh.zzj().zzu().zza("Invalid user property value for Numeric number filter. property, value", this.zzh.zzi().zzc(zznVar.zzg()), zznVar.zzh());
                }
            } else {
                boolZza = zzab.zza(zzab.zza(zznVar.zzh(), zzcVarZzb.zzd(), this.zzh.zzj()), zZzf2);
            }
        } else {
            this.zzh.zzj().zzu().zza("User property has no value, property", this.zzh.zzi().zzc(zznVar.zzg()));
        }
        this.zzh.zzj().zzp().zza("Property filter result", boolZza == null ? BuildConfig.TRAVIS : boolZza);
        if (boolZza == null) {
            return false;
        }
        this.zzc = Boolean.TRUE;
        if (zZzh && !boolZza.booleanValue()) {
            return true;
        }
        if (!z || this.zzg.zzf()) {
            this.zzd = boolZza;
        }
        if (boolZza.booleanValue() && b2 != false && zznVar.zzl()) {
            long jZzd = zznVar.zzd();
            if (l != null) {
                jZzd = l.longValue();
            }
            if (b != false && this.zzg.zzf() && !this.zzg.zzg() && l2 != null) {
                jZzd = l2.longValue();
            }
            if (this.zzg.zzg()) {
                this.zzf = Long.valueOf(jZzd);
            } else {
                this.zze = Long.valueOf(jZzd);
            }
        }
        return true;
    }
}
