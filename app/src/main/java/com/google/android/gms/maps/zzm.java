package com.google.android.gms.maps;

import com.google.android.gms.maps.model.GroundOverlay;

/* JADX INFO: loaded from: classes2.dex */
final class zzm extends com.google.android.gms.maps.internal.zzy {
    final /* synthetic */ GoogleMap.OnGroundOverlayClickListener zza;

    zzm(GoogleMap googleMap, GoogleMap.OnGroundOverlayClickListener onGroundOverlayClickListener) {
        this.zza = onGroundOverlayClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzz
    public final void zzb(com.google.android.gms.internal.maps.zzr zzrVar) {
        this.zza.onGroundOverlayClick(new GroundOverlay(zzrVar));
    }
}
