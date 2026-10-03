package com.google.android.gms.internal.measurement;

import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes4.dex */
public final class zzht {
    private final boolean zza;

    public zzht(zzhw zzhwVar) {
        Preconditions.checkNotNull(zzhwVar, "BuildInfo must be non-null");
        this.zza = !zzhwVar.zza();
    }

    public final boolean zza(String str) {
        Preconditions.checkNotNull(str, "flagName must not be null");
        if (this.zza) {
            return zzhv.zza.get().containsValue(str);
        }
        return true;
    }
}
