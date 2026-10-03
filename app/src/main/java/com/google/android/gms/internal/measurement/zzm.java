package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class zzm extends zzal {
    private final zzo zzk;

    @Override // com.google.android.gms.internal.measurement.zzal
    public final zzaq zza(zzh zzhVar, List<zzaq> list) {
        return zzaq.zzc;
    }

    public zzm(String str, zzo zzoVar) {
        super(str);
        this.zzk = zzoVar;
        this.zzb.put("getValue", new zzp(this, "getValue", zzoVar));
    }
}
