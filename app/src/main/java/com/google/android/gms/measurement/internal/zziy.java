package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes5.dex */
public final class zziy {
    final Context zza;
    String zzb;
    String zzc;
    String zzd;
    Boolean zze;
    long zzf;
    com.google.android.gms.internal.measurement.zzdq zzg;
    boolean zzh;
    Long zzi;
    String zzj;

    public zziy(Context context, @Nullable com.google.android.gms.internal.measurement.zzdq zzdqVar, @Nullable Long l) {
        this.zzh = true;
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zza = applicationContext;
        this.zzi = l;
        if (zzdqVar != null) {
            this.zzg = zzdqVar;
            this.zzb = zzdqVar.zzf;
            this.zzc = zzdqVar.zze;
            this.zzd = zzdqVar.zzd;
            this.zzh = zzdqVar.zzc;
            this.zzf = zzdqVar.zzb;
            this.zzj = zzdqVar.zzh;
            Bundle bundle = zzdqVar.zzg;
            if (bundle != null) {
                this.zze = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
