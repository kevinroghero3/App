package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
final class zzmd extends zzma<Object, Object> {
    zzmd(int i) {
        super(i);
    }

    @Override // com.google.android.gms.internal.measurement.zzma
    public final void zzd() {
        if (!zze()) {
            for (int i = 0; i < zza(); i++) {
                Map.Entry<Object, Object> entryZzb = zzb(i);
                if (((zzjm) entryZzb.getKey()).zze()) {
                    entryZzb.setValue(Collections.unmodifiableList((List) entryZzb.getValue()));
                }
            }
            for (Map.Entry<Object, Object> entry : zzb()) {
                if (((zzjm) entry.getKey()).zze()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzd();
    }
}
