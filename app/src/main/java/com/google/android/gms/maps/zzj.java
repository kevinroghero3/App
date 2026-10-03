package com.google.android.gms.maps;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
final class zzj extends com.google.android.gms.maps.internal.zzao {
    final /* synthetic */ GoogleMap.OnMapLoadedCallback zza;

    zzj(GoogleMap googleMap, GoogleMap.OnMapLoadedCallback onMapLoadedCallback) {
        this.zza = onMapLoadedCallback;
    }

    @Override // com.google.android.gms.maps.internal.zzap
    public final void zzb() throws RemoteException {
        this.zza.onMapLoaded();
    }
}
