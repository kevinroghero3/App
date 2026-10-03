package com.google.android.gms.internal.measurement;

import io.sentry.android.core.SentryLogcatAdapter;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class zzhl extends zzhi<Boolean> {
    @Override // com.google.android.gms.internal.measurement.zzhi
    @Nullable
    final /* synthetic */ Boolean zza(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (zzgh.zzc.matcher(str).matches()) {
                return Boolean.TRUE;
            }
            if (zzgh.zzd.matcher(str).matches()) {
                return Boolean.FALSE;
            }
        }
        SentryLogcatAdapter.e("PhenotypeFlag", "Invalid boolean value for " + super.zzb() + ": " + String.valueOf(obj));
        return null;
    }

    zzhl(zzhq zzhqVar, String str, Boolean bool, boolean z) {
        super(zzhqVar, str, bool);
    }
}
