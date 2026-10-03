package com.google.android.gms.maps;

import com.google.android.gms.maps.model.IndoorBuilding;

/* JADX INFO: loaded from: classes2.dex */
final class zzk extends com.google.android.gms.maps.internal.zzaa {
    final /* synthetic */ GoogleMap.OnIndoorStateChangeListener zza;

    zzk(GoogleMap googleMap, GoogleMap.OnIndoorStateChangeListener onIndoorStateChangeListener) {
        this.zza = onIndoorStateChangeListener;
    }

    @Override // com.google.android.gms.maps.internal.zzab
    public final void zzb() {
        this.zza.onIndoorBuildingFocused();
    }

    @Override // com.google.android.gms.maps.internal.zzab
    public final void zzc(com.google.android.gms.internal.maps.zzu zzuVar) {
        this.zza.onIndoorLevelActivated(new IndoorBuilding(zzuVar));
    }
}
