package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.internal.measurement.zzpg;
import com.google.android.gms.internal.measurement.zzqr;
import com.google.firebase.messaging.Constants;

/* JADX INFO: loaded from: classes5.dex */
final class zzkm implements Application.ActivityLifecycleCallbacks {
    private final /* synthetic */ zzja zza;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    static /* synthetic */ void zza(zzkm zzkmVar, boolean z, Uri uri, String str, String str2) {
        Bundle bundleZza;
        zzkmVar.zza.zzt();
        try {
            zznw zznwVarZzq = zzkmVar.zza.zzq();
            boolean z2 = zzqr.zza() && zzkmVar.zza.zze().zza(zzbh.zzbz);
            boolean z3 = zzpg.zza() && zzkmVar.zza.zze().zza(zzbh.zzct);
            if (TextUtils.isEmpty(str2)) {
                bundleZza = null;
            } else if (str2.contains("gclid") || ((z3 && str2.contains("gbraid")) || str2.contains("utm_campaign") || str2.contains("utm_source") || str2.contains("utm_medium") || str2.contains("utm_id") || str2.contains("dclid") || str2.contains("srsltid") || (z2 && str2.contains("sfmc_id")))) {
                bundleZza = zznwVarZzq.zza(Uri.parse("https://google.com/search?" + str2), z2, z3);
                if (bundleZza != null) {
                    bundleZza.putString("_cis", "referrer");
                }
            } else {
                zznwVarZzq.zzj().zzc().zza("Activity created with data 'referrer' without required params");
                bundleZza = null;
            }
            if (z) {
                Bundle bundleZza2 = zzkmVar.zza.zzq().zza(uri, zzqr.zza() && zzkmVar.zza.zze().zza(zzbh.zzbz), zzpg.zza() && zzkmVar.zza.zze().zza(zzbh.zzct));
                if (bundleZza2 != null) {
                    bundleZza2.putString("_cis", SDKConstants.PARAM_INTENT);
                    if (!bundleZza2.containsKey("gclid") && bundleZza != null && bundleZza.containsKey("gclid")) {
                        bundleZza2.putString("_cer", String.format("gclid=%s", bundleZza.getString("gclid")));
                    }
                    zzkmVar.zza.zzc(str, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundleZza2);
                    zzkmVar.zza.zzb.zza(str, bundleZza2);
                }
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            zzkmVar.zza.zzj().zzc().zza("Activity created with referrer", str2);
            if (zzkmVar.zza.zze().zza(zzbh.zzbj)) {
                if (bundleZza != null) {
                    zzkmVar.zza.zzc(str, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundleZza);
                    zzkmVar.zza.zzb.zza(str, bundleZza);
                } else {
                    zzkmVar.zza.zzj().zzc().zza("Referrer does not contain valid parameters", str2);
                }
                zzkmVar.zza.zza("auto", "_ldl", (Object) null, true);
                return;
            }
            if (!str2.contains("gclid") || (!str2.contains("utm_campaign") && !str2.contains("utm_source") && !str2.contains("utm_medium") && !str2.contains("utm_term") && !str2.contains("utm_content"))) {
                zzkmVar.zza.zzj().zzc().zza("Activity created with data 'referrer' without required params");
            } else {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                zzkmVar.zza.zza("auto", "_ldl", (Object) str2, true);
            }
        } catch (RuntimeException e) {
            zzkmVar.zza.zzj().zzg().zza("Throwable caught in handleReferrerForOnActivityCreated", e);
        }
    }

    zzkm(zzja zzjaVar) {
        this.zza = zzjaVar;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0044  */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        String str;
        try {
            try {
                this.zza.zzj().zzp().zza("onActivityCreated");
                Intent intent = activity.getIntent();
                if (intent == null) {
                    return;
                }
                Uri data = intent.getData();
                if (data == null || !data.isHierarchical()) {
                    Bundle extras = intent.getExtras();
                    if (extras != null) {
                        String string = extras.getString("com.android.vending.referral_url");
                        if (TextUtils.isEmpty(string)) {
                            data = null;
                        } else {
                            data = Uri.parse(string);
                        }
                    } else {
                        data = null;
                    }
                }
                Uri uri = data;
                if (uri != null && uri.isHierarchical()) {
                    this.zza.zzq();
                    if (zznw.zza(intent)) {
                        str = "gs";
                    } else {
                        str = "auto";
                    }
                    this.zza.zzl().zzb(new zzkp(this, bundle == null, uri, str, uri.getQueryParameter("referrer")));
                }
            } catch (RuntimeException e) {
                this.zza.zzj().zzg().zza("Throwable caught in onActivityCreated", e);
            }
        } finally {
            this.zza.zzn().zza(activity, bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.zza.zzn().zza(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        this.zza.zzn().zzb(activity);
        zzmp zzmpVarZzp = this.zza.zzp();
        zzmpVarZzp.zzl().zzb(new zzmr(zzmpVarZzp, zzmpVarZzp.zzb().elapsedRealtime()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zzmp zzmpVarZzp = this.zza.zzp();
        zzmpVarZzp.zzl().zzb(new zzmo(zzmpVarZzp, zzmpVarZzp.zzb().elapsedRealtime()));
        this.zza.zzn().zzc(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zza.zzn().zzb(activity, bundle);
    }
}
