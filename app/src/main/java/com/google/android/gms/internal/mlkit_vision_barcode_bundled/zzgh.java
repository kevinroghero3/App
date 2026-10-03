package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
final class zzgh extends zzgo {
    zzgh() {
        super(null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgo
    public final void zza() {
        if (!zzj()) {
            for (int i = 0; i < zzc(); i++) {
                ((zzdw) ((zzgi) zzg(i)).zza()).zzg();
            }
            Iterator it2 = zzd().iterator();
            while (it2.hasNext()) {
                ((zzdw) ((Map.Entry) it2.next()).getKey()).zzg();
            }
        }
        super.zza();
    }
}
