package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzql;
import com.salesforce.marketingcloud.notifications.NotificationMessage;

/* JADX INFO: loaded from: classes5.dex */
final class zzmx {
    final /* synthetic */ zzmp zza;

    zzmx(zzmp zzmpVar) {
        this.zza = zzmpVar;
    }

    final void zza() {
        this.zza.zzt();
        if (this.zza.zzk().zza(this.zza.zzb().currentTimeMillis())) {
            this.zza.zzk().zzg.zza(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.zza.zzj().zzp().zza("Detected application was in foreground");
                zzb(this.zza.zzb().currentTimeMillis(), false);
            }
        }
    }

    final void zza(long j, boolean z) {
        this.zza.zzt();
        this.zza.zzab();
        if (this.zza.zzk().zza(j)) {
            this.zza.zzk().zzg.zza(true);
            if (zzql.zza() && this.zza.zze().zza(zzbh.zzbr)) {
                this.zza.zzg().zzag();
            }
        }
        this.zza.zzk().zzk.zza(j);
        if (this.zza.zzk().zzg.zza()) {
            zzb(j, z);
        }
    }

    private final void zzb(long j, boolean z) {
        this.zza.zzt();
        if (this.zza.zzu.zzac()) {
            this.zza.zzk().zzk.zza(j);
            this.zza.zzj().zzp().zza("Session started, time", Long.valueOf(this.zza.zzb().elapsedRealtime()));
            long j2 = j / 1000;
            this.zza.zzm().zza("auto", NotificationMessage.NOTIF_KEY_SID, Long.valueOf(j2), j);
            this.zza.zzk().zzl.zza(j2);
            this.zza.zzk().zzg.zza(false);
            Bundle bundle = new Bundle();
            bundle.putLong(NotificationMessage.NOTIF_KEY_SID, j2);
            this.zza.zzm().zza("auto", "_s", j, bundle);
            String strZza = this.zza.zzk().zzq.zza();
            if (TextUtils.isEmpty(strZza)) {
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("_ffr", strZza);
            this.zza.zzm().zza("auto", "_ssr", j, bundle2);
        }
    }
}
