package com.google.android.gms.measurement.internal;

import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: loaded from: classes5.dex */
final class zzga implements Runnable {
    private final /* synthetic */ int zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ Object zzc;
    private final /* synthetic */ Object zzd;
    private final /* synthetic */ Object zze;
    private final /* synthetic */ zzgb zzf;

    zzga(zzgb zzgbVar, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
        this.zzf = zzgbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgm zzgmVarZzn = this.zzf.zzu.zzn();
        if (!zzgmVarZzn.zzaf()) {
            this.zzf.zza(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        if (this.zzf.zza == 0) {
            if (this.zzf.zze().zzy()) {
                this.zzf.zza = 'C';
            } else {
                this.zzf.zza = 'c';
            }
        }
        if (this.zzf.zzb < 0) {
            this.zzf.zzb = 88000L;
        }
        String strSubstring = ExifInterface.GPS_MEASUREMENT_2D + "01VDIWEA?".charAt(this.zza) + this.zzf.zza + this.zzf.zzb + ":" + zzgb.zza(true, this.zzb, this.zzc, this.zzd, this.zze);
        if (strSubstring.length() > 1024) {
            strSubstring = this.zzb.substring(0, 1024);
        }
        zzgq zzgqVar = zzgmVarZzn.zzb;
        if (zzgqVar != null) {
            zzgqVar.zza(strSubstring, 1L);
        }
    }
}
