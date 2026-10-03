package com.google.android.gms.internal.auth;

import io.sentry.android.core.SentryLogcatAdapter;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class zzcx extends zzdc {
    zzcx(zzcz zzczVar, String str, Double d, boolean z) {
        super(zzczVar, str, d, true, null);
    }

    @Override // com.google.android.gms.internal.auth.zzdc
    @Nullable
    final /* synthetic */ Object zza(Object obj) {
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            SentryLogcatAdapter.e("PhenotypeFlag", "Invalid double value for " + this.zzc + ": " + ((String) obj));
            return null;
        }
    }
}
