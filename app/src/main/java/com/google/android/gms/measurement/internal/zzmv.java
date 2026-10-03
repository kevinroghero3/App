package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzpb;

/* JADX INFO: loaded from: classes5.dex */
final class zzmv {
    protected long zza;
    final /* synthetic */ zzmp zzb;
    private long zzc;
    private final zzav zzd;

    final long zza(long j) {
        long j2 = this.zza;
        this.zza = j;
        return j - j2;
    }

    static /* synthetic */ void zza(zzmv zzmvVar) {
        zzmvVar.zzb.zzt();
        zzmvVar.zza(false, false, zzmvVar.zzb.zzb().elapsedRealtime());
        zzmvVar.zzb.zzc().zza(zzmvVar.zzb.zzb().elapsedRealtime());
    }

    public zzmv(zzmp zzmpVar) {
        this.zzb = zzmpVar;
        this.zzd = new zzmu(this, zzmpVar.zzu);
        long jElapsedRealtime = zzmpVar.zzb().elapsedRealtime();
        this.zzc = jElapsedRealtime;
        this.zza = jElapsedRealtime;
    }

    final void zza() {
        this.zzd.zza();
        this.zzc = 0L;
        this.zza = 0L;
    }

    final void zzb(long j) {
        this.zzd.zza();
    }

    final void zzc(long j) {
        this.zzb.zzt();
        this.zzd.zza();
        this.zzc = j;
        this.zza = j;
    }

    public final boolean zza(boolean z, boolean z2, long j) {
        this.zzb.zzt();
        this.zzb.zzu();
        if (!zzpb.zza() || !this.zzb.zze().zza(zzbh.zzbm) || this.zzb.zzu.zzac()) {
            this.zzb.zzk().zzk.zza(this.zzb.zzb().currentTimeMillis());
        }
        long jZza = j - this.zzc;
        if (!z && jZza < 1000) {
            this.zzb.zzj().zzp().zza("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(jZza));
            return false;
        }
        if (!z2) {
            jZza = zza(j);
        }
        this.zzb.zzj().zzp().zza("Recording user engagement, ms", Long.valueOf(jZza));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", jZza);
        zznw.zza(this.zzb.zzn().zza(!this.zzb.zze().zzv()), bundle, true);
        if (!z2) {
            this.zzb.zzm().zzc("auto", "_e", bundle);
        }
        this.zzc = j;
        this.zzd.zza();
        this.zzd.zza(3600000L);
        return true;
    }
}
