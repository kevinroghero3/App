package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: loaded from: classes4.dex */
public final class zza extends zzd {
    private final Map<String, Long> zza;
    private final Map<String, Integer> zzb;
    private long zzc;

    @Override // com.google.android.gms.measurement.internal.zzio, com.google.android.gms.measurement.internal.zziq
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
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

    static /* synthetic */ void zza(zza zzaVar, String str, long j) {
        zzaVar.zzt();
        Preconditions.checkNotEmpty(str);
        if (zzaVar.zzb.isEmpty()) {
            zzaVar.zzc = j;
        }
        Integer num = zzaVar.zzb.get(str);
        if (num != null) {
            zzaVar.zzb.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (zzaVar.zzb.size() >= 100) {
            zzaVar.zzj().zzu().zza("Too many ads visible");
        } else {
            zzaVar.zzb.put(str, 1);
            zzaVar.zza.put(str, Long.valueOf(j));
        }
    }

    static /* synthetic */ void zzb(zza zzaVar, String str, long j) {
        zzaVar.zzt();
        Preconditions.checkNotEmpty(str);
        Integer num = zzaVar.zzb.get(str);
        if (num != null) {
            zzkx zzkxVarZza = zzaVar.zzn().zza(false);
            int iIntValue = num.intValue() - 1;
            if (iIntValue == 0) {
                zzaVar.zzb.remove(str);
                Long l = zzaVar.zza.get(str);
                if (l == null) {
                    zzaVar.zzj().zzg().zza("First ad unit exposure time was never set");
                } else {
                    long jLongValue = l.longValue();
                    zzaVar.zza.remove(str);
                    zzaVar.zza(str, j - jLongValue, zzkxVarZza);
                }
                if (zzaVar.zzb.isEmpty()) {
                    long j2 = zzaVar.zzc;
                    if (j2 == 0) {
                        zzaVar.zzj().zzg().zza("First ad exposure time was never set");
                        return;
                    } else {
                        zzaVar.zza(j - j2, zzkxVarZza);
                        zzaVar.zzc = 0L;
                        return;
                    }
                }
                return;
            }
            zzaVar.zzb.put(str, Integer.valueOf(iIntValue));
            return;
        }
        zzaVar.zzj().zzg().zza("Call to endAdUnitExposure for unknown ad unit id", str);
    }

    public zza(zzho zzhoVar) {
        super(zzhoVar);
        this.zzb = new ArrayMap();
        this.zza = new ArrayMap();
    }

    public final void zza(String str, long j) {
        if (str == null || str.length() == 0) {
            zzj().zzg().zza("Ad unit id must be a non-empty string");
        } else {
            zzl().zzb(new zzc(this, str, j));
        }
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

    public final void zzb(String str, long j) {
        if (str == null || str.length() == 0) {
            zzj().zzg().zza("Ad unit id must be a non-empty string");
        } else {
            zzl().zzb(new zzb(this, str, j));
        }
    }

    private final void zza(long j, zzkx zzkxVar) {
        if (zzkxVar == null) {
            zzj().zzp().zza("Not logging ad exposure. No active activity");
            return;
        }
        if (j < 1000) {
            zzj().zzp().zza("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("_xt", j);
        zznw.zza(zzkxVar, bundle, true);
        zzm().zzc("am", "_xa", bundle);
    }

    private final void zza(String str, long j, zzkx zzkxVar) {
        if (zzkxVar == null) {
            zzj().zzp().zza("Not logging ad unit exposure. No active activity");
            return;
        }
        if (j < 1000) {
            zzj().zzp().zza("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_ai", str);
        bundle.putLong("_xt", j);
        zznw.zza(zzkxVar, bundle, true);
        zzm().zzc("am", "_xu", bundle);
    }

    public final void zza(long j) {
        zzkx zzkxVarZza = zzn().zza(false);
        for (String str : this.zza.keySet()) {
            zza(str, j - this.zza.get(str).longValue(), zzkxVarZza);
        }
        if (!this.zza.isEmpty()) {
            zza(j - this.zzc, zzkxVarZza);
        }
        zzb(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(long j) {
        Iterator<String> it2 = this.zza.keySet().iterator();
        while (it2.hasNext()) {
            this.zza.put(it2.next(), Long.valueOf(j));
        }
        if (this.zza.isEmpty()) {
            return;
        }
        this.zzc = j;
    }
}
