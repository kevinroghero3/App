package com.google.android.gms.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zziw;
import com.google.android.gms.measurement.internal.zziz;
import com.google.android.gms.measurement.internal.zzko;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
final class zza extends AppMeasurement.zza {
    private final zzko zza;

    @Override // com.google.android.gms.measurement.internal.zzko
    public final int zza(String str) {
        return this.zza.zza(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzko
    public final long zzf() {
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final Boolean zza() {
        return (Boolean) this.zza.zza(4);
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final Double zzb() {
        return (Double) this.zza.zza(2);
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final Integer zzc() {
        return (Integer) this.zza.zza(3);
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final Long zzd() {
        return (Long) this.zza.zza(1);
    }

    @Override // com.google.android.gms.measurement.internal.zzko
    public final Object zza(int i) {
        return this.zza.zza(i);
    }

    @Override // com.google.android.gms.measurement.internal.zzko
    public final String zzg() {
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzko
    public final String zzh() {
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzko
    public final String zzi() {
        return this.zza.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzko
    public final String zzj() {
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final String zze() {
        return (String) this.zza.zza(0);
    }

    @Override // com.google.android.gms.measurement.internal.zzko
    public final List<Bundle> zza(String str, String str2) {
        return this.zza.zza(str, str2);
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final Map<String, Object> zza(boolean z) {
        return this.zza.zza((String) null, (String) null, z);
    }

    @Override // com.google.android.gms.measurement.internal.zzko
    public final Map<String, Object> zza(String str, String str2, boolean z) {
        return this.zza.zza(str, str2, z);
    }

    public zza(zzko zzkoVar) {
        super();
        Preconditions.checkNotNull(zzkoVar);
        this.zza = zzkoVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzko
    public final void zzb(String str) {
        this.zza.zzb(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzko
    public final void zza(String str, String str2, Bundle bundle) {
        this.zza.zza(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzko
    public final void zzc(String str) {
        this.zza.zzc(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzko
    public final void zzb(String str, String str2, Bundle bundle) {
        this.zza.zzb(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzko
    public final void zza(String str, String str2, Bundle bundle, long j) {
        this.zza.zza(str, str2, bundle, j);
    }

    @Override // com.google.android.gms.measurement.internal.zzko
    public final void zza(zziz zzizVar) {
        this.zza.zza(zzizVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzko
    public final void zza(Bundle bundle) {
        this.zza.zza(bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzko
    public final void zza(zziw zziwVar) {
        this.zza.zza(zziwVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzko
    public final void zzb(zziz zzizVar) {
        this.zza.zzb(zzizVar);
    }
}
