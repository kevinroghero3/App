package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
final class zznn implements zzny {
    final /* synthetic */ zzng zza;

    zznn(zzng zzngVar) {
        this.zza = zzngVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzny
    public final void zza(String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.zza.zzl().zzb(new zznm(this, str, str2, bundle));
        } else if (this.zza.zzm != null) {
            this.zza.zzm.zzj().zzg().zza("AppId not known when logging event", str2);
        }
    }
}
