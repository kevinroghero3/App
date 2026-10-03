package com.google.android.gms.internal.auth;

import io.sentry.android.core.SentryLogcatAdapter;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class zzcw extends zzdc {
    zzcw(zzcz zzczVar, String str, Boolean bool, boolean z) {
        super(zzczVar, str, bool, true, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.auth.zzdc
    @Nullable
    final /* synthetic */ Object zza(Object obj) {
        if (zzcb.zzc.matcher(obj).matches()) {
            return Boolean.TRUE;
        }
        if (zzcb.zzd.matcher(obj).matches()) {
            return Boolean.FALSE;
        }
        SentryLogcatAdapter.e("PhenotypeFlag", "Invalid boolean value for " + this.zzc + ": " + ((String) obj));
        return null;
    }
}
