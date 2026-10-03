package com.google.android.gms.measurement;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzho;
import com.google.android.gms.measurement.internal.zziw;
import com.google.android.gms.measurement.internal.zziz;
import com.google.android.gms.measurement.internal.zzja;
import com.google.android.gms.measurement.internal.zznv;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
final class zzb extends AppMeasurement.zza {
    private final zzho zza;
    private final zzja zzb;

    @Override // com.google.android.gms.measurement.internal.zzko
    public final int zza(String str) {
        Preconditions.checkNotEmpty(str);
        return 25;
    }

    @Override // com.google.android.gms.measurement.internal.zzko
    public final long zzf() {
        return this.zza.zzt().zzm();
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final Boolean zza() {
        return this.zzb.zzaa();
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final Double zzb() {
        return this.zzb.zzab();
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final Integer zzc() {
        return this.zzb.zzac();
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final Long zzd() {
        return this.zzb.zzad();
    }

    @Override // com.google.android.gms.measurement.internal.zzko
    public final Object zza(int i) {
        if (i == 0) {
            return zze();
        }
        if (i == 1) {
            return zzd();
        }
        if (i == 2) {
            return zzb();
        }
        if (i == 3) {
            return zzc();
        }
        if (i != 4) {
            return null;
        }
        return zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzko
    public final String zzg() {
        return this.zzb.zzae();
    }

    @Override // com.google.android.gms.measurement.internal.zzko
    public final String zzh() {
        return this.zzb.zzaf();
    }

    @Override // com.google.android.gms.measurement.internal.zzko
    public final String zzi() {
        return this.zzb.zzag();
    }

    @Override // com.google.android.gms.measurement.internal.zzko
    public final String zzj() {
        return this.zzb.zzae();
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final String zze() {
        return this.zzb.zzai();
    }

    @Override // com.google.android.gms.measurement.internal.zzko
    public final List<Bundle> zza(String str, String str2) {
        return this.zzb.zza(str, str2);
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final Map<String, Object> zza(boolean z) {
        List<zznv> listZza = this.zzb.zza(z);
        ArrayMap arrayMap = new ArrayMap(listZza.size());
        for (zznv zznvVar : listZza) {
            Object objZza = zznvVar.zza();
            if (objZza != null) {
                arrayMap.put(zznvVar.zza, objZza);
            }
        }
        return arrayMap;
    }

    @Override // com.google.android.gms.measurement.internal.zzko
    public final Map<String, Object> zza(String str, String str2, boolean z) {
        return this.zzb.zza(str, str2, z);
    }

    public zzb(@NonNull zzho zzhoVar) {
        super();
        Preconditions.checkNotNull(zzhoVar);
        this.zza = zzhoVar;
        this.zzb = zzhoVar.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzko
    public final void zzb(String str) {
        this.zza.zze().zza(str, this.zza.zzb().elapsedRealtime());
    }

    @Override // com.google.android.gms.measurement.internal.zzko
    public final void zza(String str, String str2, Bundle bundle) {
        this.zza.zzp().zza(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzko
    public final void zzc(String str) {
        this.zza.zze().zzb(str, this.zza.zzb().elapsedRealtime());
    }

    @Override // com.google.android.gms.measurement.internal.zzko
    public final void zzb(String str, String str2, Bundle bundle) {
        this.zzb.zzb(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzko
    public final void zza(String str, String str2, Bundle bundle, long j) {
        this.zzb.zza(str, str2, bundle, true, false, j);
    }

    @Override // com.google.android.gms.measurement.internal.zzko
    public final void zza(zziz zzizVar) {
        this.zzb.zza(zzizVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzko
    public final void zza(Bundle bundle) {
        this.zzb.zzb(bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzko
    public final void zza(zziw zziwVar) {
        this.zzb.zza(zziwVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzko
    public final void zzb(zziz zzizVar) {
        this.zzb.zzb(zzizVar);
    }
}
