package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzwi implements zzwf {
    final List zza;

    public zzwi(Context context, zzwh zzwhVar) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        if (zzwhVar.zzc()) {
            arrayList.add(new zzwx(context, zzwhVar));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzwf
    public final void zza(zzwe zzweVar) {
        Iterator it2 = this.zza.iterator();
        while (it2.hasNext()) {
            ((zzwf) it2.next()).zza(zzweVar);
        }
    }
}
