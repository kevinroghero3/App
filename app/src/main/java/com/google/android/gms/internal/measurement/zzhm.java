package com.google.android.gms.internal.measurement;

import io.sentry.android.core.SentryLogcatAdapter;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class zzhm extends zzhi<Long> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.measurement.zzhi
    @Nullable
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final Long zza(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        SentryLogcatAdapter.e("PhenotypeFlag", "Invalid long value for " + super.zzb() + ": " + String.valueOf(obj));
        return null;
    }

    zzhm(zzhq zzhqVar, String str, Long l, boolean z) {
        super(zzhqVar, str, l);
    }
}
