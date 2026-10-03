package com.google.android.gms.maps;

import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.model.Marker;

/* JADX INFO: loaded from: classes2.dex */
final class zzf extends com.google.android.gms.maps.internal.zzh {
    final /* synthetic */ GoogleMap.InfoWindowAdapter zza;

    zzf(GoogleMap googleMap, GoogleMap.InfoWindowAdapter infoWindowAdapter) {
        this.zza = infoWindowAdapter;
    }

    @Override // com.google.android.gms.maps.internal.zzi
    public final IObjectWrapper zzb(com.google.android.gms.internal.maps.zzad zzadVar) {
        return ObjectWrapper.wrap(this.zza.getInfoContents(new Marker(zzadVar)));
    }

    @Override // com.google.android.gms.maps.internal.zzi
    public final IObjectWrapper zzc(com.google.android.gms.internal.maps.zzad zzadVar) {
        return ObjectWrapper.wrap(this.zza.getInfoWindow(new Marker(zzadVar)));
    }
}
