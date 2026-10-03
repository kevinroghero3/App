package com.google.android.gms.maps;

import com.google.android.gms.maps.internal.zzbg;
import com.google.android.gms.maps.model.Polygon;

/* JADX INFO: loaded from: classes2.dex */
final class zzo extends zzbg {
    final /* synthetic */ GoogleMap.OnPolygonClickListener zza;

    zzo(GoogleMap googleMap, GoogleMap.OnPolygonClickListener onPolygonClickListener) {
        this.zza = onPolygonClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzbh
    public final void zzb(com.google.android.gms.internal.maps.zzag zzagVar) {
        this.zza.onPolygonClick(new Polygon(zzagVar));
    }
}
