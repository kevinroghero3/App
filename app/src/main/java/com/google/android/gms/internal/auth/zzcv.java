package com.google.android.gms.internal.auth;

import io.sentry.android.core.SentryLogcatAdapter;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class zzcv extends zzdc {
    zzcv(zzcz zzczVar, String str, Long l, boolean z) {
        super(zzczVar, str, l, true, null);
    }

    @Override // com.google.android.gms.internal.auth.zzdc
    @Nullable
    final /* synthetic */ Object zza(Object obj) {
        try {
            return Long.valueOf(Long.parseLong((String) obj));
        } catch (NumberFormatException unused) {
            SentryLogcatAdapter.e("PhenotypeFlag", "Invalid long value for " + this.zzc + ": " + ((String) obj));
            return null;
        }
    }
}
