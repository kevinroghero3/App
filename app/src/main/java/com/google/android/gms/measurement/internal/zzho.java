package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzoo;
import com.google.android.gms.internal.measurement.zzpg;
import com.google.android.gms.internal.measurement.zzpz;
import com.google.android.gms.internal.measurement.zzqx;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.net.URL;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class zzho implements zziq {
    private static volatile zzho zzb;
    final long zza;
    private Boolean zzaa;
    private long zzab;
    private volatile Boolean zzac;
    private Boolean zzad;
    private Boolean zzae;
    private volatile boolean zzaf;
    private int zzag;
    private int zzah;
    private final Context zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final boolean zzg;
    private final zzad zzh;
    private final zzae zzi;
    private final zzgm zzj;
    private final zzgb zzk;
    private final zzhh zzl;
    private final zzmp zzm;
    private final zznw zzn;
    private final zzfw zzo;
    private final Clock zzp;
    private final zzkw zzq;
    private final zzja zzr;
    private final zza zzs;
    private final zzkr zzt;
    private final String zzu;
    private zzfu zzv;
    private zzlf zzw;
    private zzaz zzx;
    private zzfv zzy;
    private boolean zzz = false;
    private AtomicInteger zzai = new AtomicInteger(0);

    public final int zzc() {
        zzl().zzt();
        if (this.zzi.zzw()) {
            return 1;
        }
        Boolean bool = this.zzae;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        if (!zzad()) {
            return 8;
        }
        Boolean boolZzv = zzn().zzv();
        if (boolZzv != null) {
            return boolZzv.booleanValue() ? 0 : 3;
        }
        Boolean boolZzf = this.zzi.zzf("firebase_analytics_collection_enabled");
        if (boolZzf != null) {
            return boolZzf.booleanValue() ? 0 : 4;
        }
        Boolean bool2 = this.zzad;
        if (bool2 != null) {
            return bool2.booleanValue() ? 0 : 5;
        }
        return (this.zzac == null || this.zzac.booleanValue()) ? 0 : 7;
    }

    @Override // com.google.android.gms.measurement.internal.zziq
    @Pure
    public final Context zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.measurement.internal.zziq
    @Pure
    public final Clock zzb() {
        return this.zzp;
    }

    @Pure
    public final zza zze() {
        zza zzaVar = this.zzs;
        if (zzaVar != null) {
            return zzaVar;
        }
        throw new IllegalStateException("Component not created");
    }

    @Override // com.google.android.gms.measurement.internal.zziq
    @Pure
    public final zzad zzd() {
        return this.zzh;
    }

    @Pure
    public final zzae zzf() {
        return this.zzi;
    }

    @Pure
    public final zzaz zzg() {
        zza((zzin) this.zzx);
        return this.zzx;
    }

    @Pure
    public final zzfv zzh() {
        zza((zzg) this.zzy);
        return this.zzy;
    }

    @Pure
    public final zzfu zzi() {
        zza((zzg) this.zzv);
        return this.zzv;
    }

    @Pure
    public final zzfw zzk() {
        return this.zzo;
    }

    @Override // com.google.android.gms.measurement.internal.zziq
    @Pure
    public final zzgb zzj() {
        zza((zzin) this.zzk);
        return this.zzk;
    }

    public final zzgb zzm() {
        zzgb zzgbVar = this.zzk;
        if (zzgbVar == null || !zzgbVar.zzaf()) {
            return null;
        }
        return this.zzk;
    }

    @Pure
    public final zzgm zzn() {
        zza((zzio) this.zzj);
        return this.zzj;
    }

    @Override // com.google.android.gms.measurement.internal.zziq
    @Pure
    public final zzhh zzl() {
        zza((zzin) this.zzl);
        return this.zzl;
    }

    @SideEffectFree
    final zzhh zzo() {
        return this.zzl;
    }

    public static zzho zza(Context context, com.google.android.gms.internal.measurement.zzdq zzdqVar, Long l) {
        Bundle bundle;
        if (zzdqVar != null && (zzdqVar.zze == null || zzdqVar.zzf == null)) {
            zzdqVar = new com.google.android.gms.internal.measurement.zzdq(zzdqVar.zza, zzdqVar.zzb, zzdqVar.zzc, zzdqVar.zzd, null, null, zzdqVar.zzg, null);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzho.class) {
                if (zzb == null) {
                    zzb = new zzho(new zziy(context, zzdqVar, l));
                }
            }
        } else if (zzdqVar != null && (bundle = zzdqVar.zzg) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            Preconditions.checkNotNull(zzb);
            zzb.zza(zzdqVar.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        Preconditions.checkNotNull(zzb);
        return zzb;
    }

    @Pure
    public final zzja zzp() {
        zza((zzg) this.zzr);
        return this.zzr;
    }

    @Pure
    private final zzkr zzai() {
        zza((zzin) this.zzt);
        return this.zzt;
    }

    @Pure
    public final zzkw zzq() {
        zza((zzg) this.zzq);
        return this.zzq;
    }

    @Pure
    public final zzlf zzr() {
        zza((zzg) this.zzw);
        return this.zzw;
    }

    @Pure
    public final zzmp zzs() {
        zza((zzg) this.zzm);
        return this.zzm;
    }

    @Pure
    public final zznw zzt() {
        zza((zzio) this.zzn);
        return this.zzn;
    }

    @Pure
    public final String zzu() {
        return this.zzd;
    }

    @Pure
    public final String zzv() {
        return this.zze;
    }

    @Pure
    public final String zzw() {
        return this.zzf;
    }

    @Pure
    public final String zzx() {
        return this.zzu;
    }

    static /* synthetic */ void zza(zzho zzhoVar, zziy zziyVar) {
        zzhoVar.zzl().zzt();
        zzaz zzazVar = new zzaz(zzhoVar);
        zzazVar.zzad();
        zzhoVar.zzx = zzazVar;
        zzfv zzfvVar = new zzfv(zzhoVar, zziyVar.zzf);
        zzfvVar.zzv();
        zzhoVar.zzy = zzfvVar;
        zzfu zzfuVar = new zzfu(zzhoVar);
        zzfuVar.zzv();
        zzhoVar.zzv = zzfuVar;
        zzlf zzlfVar = new zzlf(zzhoVar);
        zzlfVar.zzv();
        zzhoVar.zzw = zzlfVar;
        zzhoVar.zzn.zzae();
        zzhoVar.zzj.zzae();
        zzhoVar.zzy.zzw();
        zzhoVar.zzj().zzn().zza("App measurement initialized, version", 88000L);
        zzhoVar.zzj().zzn().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String strZzad = zzfvVar.zzad();
        if (TextUtils.isEmpty(zzhoVar.zzd)) {
            if (zzhoVar.zzt().zzd(strZzad, zzhoVar.zzi.zzp())) {
                zzhoVar.zzj().zzn().zza("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
            } else {
                zzhoVar.zzj().zzn().zza("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app " + strZzad);
            }
        }
        zzhoVar.zzj().zzc().zza("Debug-level message logging enabled");
        if (zzhoVar.zzag != zzhoVar.zzai.get()) {
            zzhoVar.zzj().zzg().zza("Not all components initialized", Integer.valueOf(zzhoVar.zzag), Integer.valueOf(zzhoVar.zzai.get()));
        }
        zzhoVar.zzz = true;
    }

    private zzho(zziy zziyVar) {
        long jCurrentTimeMillis;
        Bundle bundle;
        boolean z = false;
        Preconditions.checkNotNull(zziyVar);
        zzad zzadVar = new zzad(zziyVar.zza);
        this.zzh = zzadVar;
        zzfp.zza = zzadVar;
        Context context = zziyVar.zza;
        this.zzc = context;
        this.zzd = zziyVar.zzb;
        this.zze = zziyVar.zzc;
        this.zzf = zziyVar.zzd;
        this.zzg = zziyVar.zzh;
        this.zzac = zziyVar.zze;
        this.zzu = zziyVar.zzj;
        this.zzaf = true;
        com.google.android.gms.internal.measurement.zzdq zzdqVar = zziyVar.zzg;
        if (zzdqVar != null && (bundle = zzdqVar.zzg) != null) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.zzad = (Boolean) obj;
            }
            Object obj2 = zzdqVar.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.zzae = (Boolean) obj2;
            }
        }
        com.google.android.gms.internal.measurement.zzhi.zzb(context);
        Clock defaultClock = DefaultClock.getInstance();
        this.zzp = defaultClock;
        Long l = zziyVar.zzi;
        if (l != null) {
            jCurrentTimeMillis = l.longValue();
        } else {
            jCurrentTimeMillis = defaultClock.currentTimeMillis();
        }
        this.zza = jCurrentTimeMillis;
        this.zzi = new zzae(this);
        zzgm zzgmVar = new zzgm(this);
        zzgmVar.zzad();
        this.zzj = zzgmVar;
        zzgb zzgbVar = new zzgb(this);
        zzgbVar.zzad();
        this.zzk = zzgbVar;
        zznw zznwVar = new zznw(this);
        zznwVar.zzad();
        this.zzn = zznwVar;
        this.zzo = new zzfw(new zzjb(zziyVar, this));
        this.zzs = new zza(this);
        zzkw zzkwVar = new zzkw(this);
        zzkwVar.zzv();
        this.zzq = zzkwVar;
        zzja zzjaVar = new zzja(this);
        zzjaVar.zzv();
        this.zzr = zzjaVar;
        zzmp zzmpVar = new zzmp(this);
        zzmpVar.zzv();
        this.zzm = zzmpVar;
        zzkr zzkrVar = new zzkr(this);
        zzkrVar.zzad();
        this.zzt = zzkrVar;
        zzhh zzhhVar = new zzhh(this);
        zzhhVar.zzad();
        this.zzl = zzhhVar;
        com.google.android.gms.internal.measurement.zzdq zzdqVar2 = zziyVar.zzg;
        if (zzdqVar2 != null && zzdqVar2.zzb != 0) {
            z = true;
        }
        if (context.getApplicationContext() instanceof Application) {
            zzja zzjaVarZzp = zzp();
            if (zzjaVarZzp.zza().getApplicationContext() instanceof Application) {
                Application application = (Application) zzjaVarZzp.zza().getApplicationContext();
                if (zzjaVarZzp.zza == null) {
                    zzjaVarZzp.zza = new zzkm(zzjaVarZzp);
                }
                if (!z) {
                    application.unregisterActivityLifecycleCallbacks(zzjaVarZzp.zza);
                    application.registerActivityLifecycleCallbacks(zzjaVarZzp.zza);
                    zzjaVarZzp.zzj().zzp().zza("Registered activity lifecycle callback");
                }
            }
        } else {
            zzj().zzu().zza("Application context is not an Application");
        }
        zzhhVar.zzb(new zzhp(this, zziyVar));
    }

    private static void zza(zzio zzioVar) {
        if (zzioVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static void zza(zzg zzgVar) {
        if (zzgVar == null) {
            throw new IllegalStateException("Component not created");
        }
        if (zzgVar.zzy()) {
            return;
        }
        throw new IllegalStateException("Component not initialized: " + String.valueOf(zzgVar.getClass()));
    }

    private static void zza(zzin zzinVar) {
        if (zzinVar == null) {
            throw new IllegalStateException("Component not created");
        }
        if (zzinVar.zzaf()) {
            return;
        }
        throw new IllegalStateException("Component not initialized: " + String.valueOf(zzinVar.getClass()));
    }

    final void zzy() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    final void zzz() {
        this.zzai.incrementAndGet();
    }

    final /* synthetic */ void zza(String str, int i, Throwable th, byte[] bArr, Map map) {
        if ((i != 200 && i != 204 && i != 304) || th != null) {
            zzj().zzu().zza("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i), th);
            return;
        }
        zzn().zzo.zza(true);
        if (bArr == null || bArr.length == 0) {
            zzj().zzc().zza("Deferred Deep Link response empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String strOptString = jSONObject.optString("deeplink", "");
            String strOptString2 = jSONObject.optString("gclid", "");
            String strOptString3 = jSONObject.optString("gbraid", "");
            double dOptDouble = jSONObject.optDouble("timestamp", 0.0d);
            if (TextUtils.isEmpty(strOptString)) {
                zzj().zzc().zza("Deferred Deep Link is empty.");
                return;
            }
            Bundle bundle = new Bundle();
            if (zzpg.zza() && this.zzi.zza(zzbh.zzct)) {
                if (!zzt().zzi(strOptString)) {
                    zzj().zzu().zza("Deferred Deep Link validation failed. gclid, gbraid, deep link", strOptString2, strOptString3, strOptString);
                    return;
                }
                bundle.putString("gbraid", strOptString3);
            } else if (!zzt().zzi(strOptString)) {
                zzj().zzu().zza("Deferred Deep Link validation failed. gclid, deep link", strOptString2, strOptString);
                return;
            }
            bundle.putString("gclid", strOptString2);
            bundle.putString("_cis", "ddp");
            this.zzr.zzc("auto", Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundle);
            zznw zznwVarZzt = zzt();
            if (TextUtils.isEmpty(strOptString) || !zznwVarZzt.zza(strOptString, dOptDouble)) {
                return;
            }
            zznwVarZzt.zza().sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
        } catch (JSONException e) {
            zzj().zzg().zza("Failed to parse the Deferred Deep Link response. exception", e);
        }
    }

    final void zzaa() {
        this.zzag++;
    }

    final void zza(boolean z) {
        this.zzac = Boolean.valueOf(z);
    }

    public final void zzb(boolean z) {
        zzl().zzt();
        this.zzaf = z;
    }

    /* JADX WARN: Code duplicated, block: B:80:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:85:0x020e  */
    /* JADX WARN: Code duplicated, block: B:87:0x021c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:94:0x0234  */
    /* JADX WARN: Code duplicated, block: B:97:0x0251 A[ADDED_TO_REGION] */
    protected final void zza(com.google.android.gms.internal.measurement.zzdq zzdqVar) {
        zzis zzisVar;
        Boolean boolZza;
        zzax zzaxVarZza;
        Boolean boolZzf;
        zzl().zzt();
        if (zzpz.zza() && this.zzi.zza(zzbh.zzch) && zzt().zzw()) {
            zznw zznwVarZzt = zzt();
            zznwVarZzt.zzt();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
            ContextCompat.registerReceiver(zznwVarZzt.zza(), new zzo(zznwVarZzt.zzu), intentFilter, 2);
            zznwVarZzt.zzj().zzc().zza("Registered app receiver");
        }
        zzis zzisVarZzn = zzn().zzn();
        int iZza = zzisVarZzn.zza();
        if (com.google.android.gms.internal.measurement.zznx.zza() && this.zzi.zza(zzbh.zzda)) {
            zzir zzirVarZze = this.zzi.zze("google_analytics_default_allow_ad_storage");
            zzir zzirVarZze2 = this.zzi.zze("google_analytics_default_allow_analytics_storage");
            zzir zzirVar = zzir.UNINITIALIZED;
            if ((zzirVarZze != zzirVar || zzirVarZze2 != zzirVar) && zzn().zza(-10)) {
                zzisVar = zzis.zza(zzirVarZze, zzirVarZze2, -10);
            } else {
                if (!TextUtils.isEmpty(zzh().zzae()) && (iZza == 0 || iZza == 30 || iZza == 10 || iZza == 30 || iZza == 30 || iZza == 40)) {
                    zzp().zza(new zzis(null, null, -10), this.zza, false);
                } else if (TextUtils.isEmpty(zzh().zzae()) && zzdqVar != null && zzdqVar.zzg != null && zzn().zza(30)) {
                    zzisVar = zzis.zza(zzdqVar.zzg, 30);
                    if (!zzisVar.zzk()) {
                    }
                }
                zzisVar = null;
            }
        } else {
            Boolean boolZzf2 = this.zzi.zzf("google_analytics_default_allow_ad_storage");
            Boolean boolZzf3 = this.zzi.zzf("google_analytics_default_allow_analytics_storage");
            if ((boolZzf2 != null || boolZzf3 != null) && zzn().zza(-10)) {
                zzisVar = new zzis(boolZzf2, boolZzf3, -10);
            } else {
                if (!TextUtils.isEmpty(zzh().zzae()) && (iZza == 0 || iZza == 30 || iZza == 10 || iZza == 30 || iZza == 30 || iZza == 40)) {
                    zzp().zza(new zzis(null, null, -10), this.zza, false);
                } else if (TextUtils.isEmpty(zzh().zzae()) && zzdqVar != null && zzdqVar.zzg != null && zzn().zza(30)) {
                    zzisVar = zzis.zza(zzdqVar.zzg, 30);
                    if (!zzisVar.zzk()) {
                    }
                }
                zzisVar = null;
            }
        }
        if (zzisVar != null) {
            zzp().zza(zzisVar, this.zza, this.zzi.zza(zzbh.zzde));
            zzisVarZzn = zzisVar;
        }
        zzp().zza(zzisVarZzn);
        int iZza2 = zzn().zzm().zza();
        if (com.google.android.gms.internal.measurement.zznx.zza() && this.zzi.zza(zzbh.zzda)) {
            zzir zzirVarZze3 = this.zzi.zze("google_analytics_default_allow_ad_user_data");
            if (zzirVarZze3 != zzir.UNINITIALIZED && zzis.zza(-10, iZza2)) {
                zzp().zza(zzax.zza(zzirVarZze3, -10), this.zzi.zza(zzbh.zzde));
            } else if (TextUtils.isEmpty(zzh().zzae())) {
                if (TextUtils.isEmpty(zzh().zzae())) {
                    zzaxVarZza = zzax.zza(zzdqVar.zzg, 30);
                    if (zzaxVarZza.zzg()) {
                        zzp().zza(zzaxVarZza, this.zzi.zza(zzbh.zzde));
                    }
                }
                if (TextUtils.isEmpty(zzh().zzae())) {
                    zzp().zza(zzdqVar.zze, FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS, (Object) boolZza.toString(), false);
                }
            } else {
                if (TextUtils.isEmpty(zzh().zzae())) {
                    zzaxVarZza = zzax.zza(zzdqVar.zzg, 30);
                    if (zzaxVarZza.zzg()) {
                        zzp().zza(zzaxVarZza, this.zzi.zza(zzbh.zzde));
                    }
                }
                if (TextUtils.isEmpty(zzh().zzae())) {
                    zzp().zza(zzdqVar.zze, FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS, (Object) boolZza.toString(), false);
                }
            }
        } else {
            Boolean boolZzf4 = this.zzi.zzf("google_analytics_default_allow_ad_user_data");
            if (boolZzf4 != null && zzis.zza(-10, iZza2)) {
                zzp().zza(new zzax(boolZzf4, -10), this.zzi.zza(zzbh.zzde));
            } else if (TextUtils.isEmpty(zzh().zzae()) && (iZza2 == 0 || iZza2 == 30)) {
                zzp().zza(new zzax(null, -10), this.zzi.zza(zzbh.zzde));
            } else {
                if (TextUtils.isEmpty(zzh().zzae()) && zzdqVar != null && zzdqVar.zzg != null && zzis.zza(30, iZza2)) {
                    zzaxVarZza = zzax.zza(zzdqVar.zzg, 30);
                    if (zzaxVarZza.zzg()) {
                        zzp().zza(zzaxVarZza, this.zzi.zza(zzbh.zzde));
                    }
                }
                if (TextUtils.isEmpty(zzh().zzae()) && zzdqVar != null && zzdqVar.zzg != null && zzn().zzh.zza() == null && (boolZza = zzax.zza(zzdqVar.zzg)) != null) {
                    zzp().zza(zzdqVar.zze, FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS, (Object) boolZza.toString(), false);
                }
            }
        }
        if (zzqx.zza() && this.zzi.zza(zzbh.zzcx) && ((boolZzf = this.zzi.zzf("google_analytics_tcf_data_enabled")) == null || boolZzf.booleanValue())) {
            zzj().zzc().zza("TCF client enabled.");
            zzp().zzaq();
            zzp().zzao();
        }
        if (zzn().zzc.zza() == 0) {
            zzj().zzp().zza("Persisting first open", Long.valueOf(this.zza));
            zzn().zzc.zza(this.zza);
        }
        zzp().zzb.zzb();
        if (!zzaf()) {
            if (zzac()) {
                if (!zzt().zze("android.permission.INTERNET")) {
                    zzj().zzg().zza("App is missing INTERNET permission");
                }
                if (!zzt().zze("android.permission.ACCESS_NETWORK_STATE")) {
                    zzj().zzg().zza("App is missing ACCESS_NETWORK_STATE permission");
                }
                if (!Wrappers.packageManager(this.zzc).isCallerInstantApp() && !this.zzi.zzx()) {
                    if (!zznw.zza(this.zzc)) {
                        zzj().zzg().zza("AppMeasurementReceiver not registered/enabled");
                    }
                    if (!zznw.zza(this.zzc, false)) {
                        zzj().zzg().zza("AppMeasurementService not registered/enabled");
                    }
                }
                zzj().zzg().zza("Uploading is not possible. App measurement disabled");
            }
        } else {
            if (!TextUtils.isEmpty(zzh().zzae()) || !TextUtils.isEmpty(zzh().zzac())) {
                zzt();
                if (zznw.zza(zzh().zzae(), zzn().zzy(), zzh().zzac(), zzn().zzx())) {
                    zzj().zzn().zza("Rechecking which service to use due to a GMP App Id change");
                    zzn().zzz();
                    zzi().zzaa();
                    this.zzw.zzae();
                    this.zzw.zzad();
                    zzn().zzc.zza(this.zza);
                    zzn().zze.zza(null);
                }
                zzn().zzc(zzh().zzae());
                zzn().zzb(zzh().zzac());
            }
            if (!zzn().zzn().zza(zzis.zza.ANALYTICS_STORAGE)) {
                zzn().zze.zza(null);
            }
            zzp().zza(zzn().zze.zza());
            if (!zzt().zzx() && !TextUtils.isEmpty(zzn().zzq.zza())) {
                zzj().zzu().zza("Remote config removed with active feature rollouts");
                zzn().zzq.zza(null);
            }
            if (!TextUtils.isEmpty(zzh().zzae()) || !TextUtils.isEmpty(zzh().zzac())) {
                boolean zZzac = zzac();
                if (!zzn().zzab() && !this.zzi.zzw()) {
                    zzn().zzb(!zZzac);
                }
                if (zZzac) {
                    zzp().zzak();
                }
                zzs().zza.zza();
                zzr().zza(new AtomicReference<>());
                zzr().zza(zzn().zzt.zza());
            }
        }
        if (zzpz.zza() && this.zzi.zza(zzbh.zzch) && zzt().zzw()) {
            final zzja zzjaVarZzp = zzp();
            Objects.requireNonNull(zzjaVarZzp);
            new Thread(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzhn
                @Override // java.lang.Runnable
                public final void run() {
                    zzjaVarZzp.zzam();
                }
            }).start();
        }
        zzn().zzj.zza(true);
    }

    public final boolean zzab() {
        return this.zzac != null && this.zzac.booleanValue();
    }

    public final boolean zzac() {
        return zzc() == 0;
    }

    public final boolean zzad() {
        zzl().zzt();
        return this.zzaf;
    }

    @Pure
    public final boolean zzae() {
        return TextUtils.isEmpty(this.zzd);
    }

    protected final boolean zzaf() {
        if (!this.zzz) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
        zzl().zzt();
        Boolean bool = this.zzaa;
        if (bool == null || this.zzab == 0 || (bool != null && !bool.booleanValue() && Math.abs(this.zzp.elapsedRealtime() - this.zzab) > 1000)) {
            this.zzab = this.zzp.elapsedRealtime();
            boolean z = true;
            Boolean boolValueOf = Boolean.valueOf(zzt().zze("android.permission.INTERNET") && zzt().zze("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.zzc).isCallerInstantApp() || this.zzi.zzx() || (zznw.zza(this.zzc) && zznw.zza(this.zzc, false))));
            this.zzaa = boolValueOf;
            if (boolValueOf.booleanValue()) {
                if (!zzt().zza(zzh().zzae(), zzh().zzac()) && TextUtils.isEmpty(zzh().zzac())) {
                    z = false;
                }
                this.zzaa = Boolean.valueOf(z);
            }
        }
        return this.zzaa.booleanValue();
    }

    @Pure
    public final boolean zzag() {
        return this.zzg;
    }

    public final boolean zzah() {
        zzl().zzt();
        zza((zzin) zzai());
        String strZzad = zzh().zzad();
        Pair<String, Boolean> pairZza = zzn().zza(strZzad);
        if (!this.zzi.zzu() || ((Boolean) pairZza.second).booleanValue() || TextUtils.isEmpty((CharSequence) pairZza.first)) {
            zzj().zzc().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return false;
        }
        if (!zzai().zzc()) {
            zzj().zzu().zza("Network is not available for Deferred Deep Link request. Skipping");
            return false;
        }
        StringBuilder sb = new StringBuilder();
        if (zzoo.zza() && this.zzi.zza(zzbh.zzco)) {
            zzlf zzlfVarZzr = zzr();
            zzlfVarZzr.zzt();
            zzlfVarZzr.zzu();
            if (!zzlfVarZzr.zzao() || zzlfVarZzr.zzq().zzg() >= 234200) {
                zzja zzjaVarZzp = zzp();
                zzjaVarZzp.zzt();
                zzal zzalVarZzaa = zzjaVarZzp.zzo().zzaa();
                Bundle bundle = zzalVarZzaa != null ? zzalVarZzaa.zza : null;
                if (bundle == null) {
                    int i = this.zzah;
                    this.zzah = i + 1;
                    boolean z = i < 10;
                    zzj().zzc().zza("Failed to retrieve DMA consent from the service, " + (z ? "Retrying." : "Skipping.") + " retryCount", Integer.valueOf(this.zzah));
                    return z;
                }
                zzis zzisVarZza = zzis.zza(bundle, 100);
                sb.append("&gcs=");
                sb.append(zzisVarZza.zzg());
                zzax zzaxVarZza = zzax.zza(bundle, 100);
                sb.append("&dma=");
                sb.append(zzaxVarZza.zzd() == Boolean.FALSE ? 0 : 1);
                if (!TextUtils.isEmpty(zzaxVarZza.zze())) {
                    sb.append("&dma_cps=");
                    sb.append(zzaxVarZza.zze());
                }
                int i2 = zzax.zza(bundle) == Boolean.TRUE ? 0 : 1;
                sb.append("&npa=");
                sb.append(i2);
                zzj().zzp().zza("Consent query parameters to Bow", sb);
            }
        }
        zznw zznwVarZzt = zzt();
        zzh();
        URL urlZza = zznwVarZzt.zza(88000L, strZzad, (String) pairZza.first, zzn().zzp.zza() - 1, sb.toString());
        if (urlZza != null) {
            zzkr zzkrVarZzai = zzai();
            zzkq zzkqVar = new zzkq() { // from class: com.google.android.gms.measurement.internal.zzhq
                @Override // com.google.android.gms.measurement.internal.zzkq
                public final void zza(String str, int i3, Throwable th, byte[] bArr, Map map) {
                    this.zza.zza(str, i3, th, bArr, map);
                }
            };
            zzkrVarZzai.zzt();
            zzkrVarZzai.zzac();
            Preconditions.checkNotNull(urlZza);
            Preconditions.checkNotNull(zzkqVar);
            zzkrVarZzai.zzl().zza(new zzkt(zzkrVarZzai, strZzad, urlZza, null, null, zzkqVar));
        }
        return false;
    }
}
