package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
final class zzke implements zzny {
    private final /* synthetic */ zzja zza;

    zzke(zzja zzjaVar) {
        this.zza = zzjaVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzny
    public final void zza(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            this.zza.zzb("auto", str2, bundle);
        } else {
            this.zza.zza("auto", str2, bundle, str);
        }
    }
}
