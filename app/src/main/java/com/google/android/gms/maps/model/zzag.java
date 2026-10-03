package com.google.android.gms.maps.model;

import com.google.android.gms.internal.maps.zzao;

/* JADX INFO: loaded from: classes2.dex */
final class zzag extends zzao {
    final /* synthetic */ TileProvider zza;

    zzag(TileOverlayOptions tileOverlayOptions, TileProvider tileProvider) {
        this.zza = tileProvider;
    }

    @Override // com.google.android.gms.internal.maps.zzap
    public final Tile zzb(int i, int i2, int i3) {
        return this.zza.getTile(i, i2, i3);
    }
}
