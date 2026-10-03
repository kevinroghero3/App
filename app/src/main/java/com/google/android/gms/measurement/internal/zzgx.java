package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import ch.qos.logback.classic.spi.CallerData;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzpg;
import com.google.android.gms.internal.measurement.zzqr;
import com.google.firebase.messaging.Constants;

/* JADX INFO: loaded from: classes5.dex */
final class zzgx implements Runnable {
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzby zza;
    private final /* synthetic */ ServiceConnection zzb;
    private final /* synthetic */ zzgu zzc;

    zzgx(zzgu zzguVar, com.google.android.gms.internal.measurement.zzby zzbyVar, ServiceConnection serviceConnection) {
        this.zza = zzbyVar;
        this.zzb = serviceConnection;
        this.zzc = zzguVar;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0106  */
    /* JADX WARN: Code duplicated, block: B:42:0x011d  */
    @Override // java.lang.Runnable
    public final void run() {
        zzgu zzguVar = this.zzc;
        zzgv zzgvVar = zzguVar.zza;
        String str = zzguVar.zzb;
        com.google.android.gms.internal.measurement.zzby zzbyVar = this.zza;
        ServiceConnection serviceConnection = this.zzb;
        Bundle bundleZza = zzgvVar.zza(str, zzbyVar);
        zzgvVar.zza.zzl().zzt();
        zzgvVar.zza.zzy();
        if (bundleZza != null) {
            long j = bundleZza.getLong("install_begin_timestamp_seconds", 0L) * 1000;
            if (j == 0) {
                zzgvVar.zza.zzj().zzu().zza("Service response is missing Install Referrer install timestamp");
            } else {
                String string = bundleZza.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    zzgvVar.zza.zzj().zzg().zza("No referrer defined in Install Referrer response");
                } else {
                    zzgvVar.zza.zzj().zzp().zza("InstallReferrer API result", string);
                    Bundle bundleZza2 = zzgvVar.zza.zzt().zza(Uri.parse(CallerData.NA + string), zzqr.zza() && zzgvVar.zza.zzf().zza(zzbh.zzca), zzpg.zza() && zzgvVar.zza.zzf().zza(zzbh.zzcu));
                    if (bundleZza2 == null) {
                        zzgvVar.zza.zzj().zzg().zza("No campaign params defined in Install Referrer result");
                    } else {
                        String string2 = bundleZza2.getString("medium");
                        if (string2 == null || "(not set)".equalsIgnoreCase(string2) || "organic".equalsIgnoreCase(string2)) {
                            if (j == zzgvVar.zza.zzn().zzd.zza()) {
                                zzgvVar.zza.zzj().zzp().zza("Logging Install Referrer campaign from module while it may have already been logged.");
                            }
                            if (zzgvVar.zza.zzac()) {
                                zzgvVar.zza.zzn().zzd.zza(j);
                                zzgvVar.zza.zzj().zzp().zza("Logging Install Referrer campaign from gmscore with ", "referrer API v2");
                                bundleZza2.putString("_cis", "referrer API v2");
                                zzgvVar.zza.zzp().zza("auto", Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundleZza2, str);
                            }
                        } else {
                            long j2 = bundleZza.getLong("referrer_click_timestamp_seconds", 0L) * 1000;
                            if (j2 == 0) {
                                zzgvVar.zza.zzj().zzg().zza("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                bundleZza2.putLong("click_timestamp", j2);
                                if (j == zzgvVar.zza.zzn().zzd.zza()) {
                                    zzgvVar.zza.zzj().zzp().zza("Logging Install Referrer campaign from module while it may have already been logged.");
                                }
                                if (zzgvVar.zza.zzac()) {
                                    zzgvVar.zza.zzn().zzd.zza(j);
                                    zzgvVar.zza.zzj().zzp().zza("Logging Install Referrer campaign from gmscore with ", "referrer API v2");
                                    bundleZza2.putString("_cis", "referrer API v2");
                                    zzgvVar.zza.zzp().zza("auto", Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundleZza2, str);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (serviceConnection != null) {
            ConnectionTracker.getInstance().unbindService(zzgvVar.zza.zza(), serviceConnection);
        }
    }
}
