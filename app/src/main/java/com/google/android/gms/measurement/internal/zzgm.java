package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import ch.qos.logback.core.spi.ComponentTracker;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.internal.Preconditions;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: loaded from: classes5.dex */
final class zzgm extends zzin {
    static final Pair<String, Long> zza = new Pair<>("", 0L);
    private long zzaa;
    public zzgq zzb;
    public final zzgr zzc;
    public final zzgr zzd;
    public final zzgs zze;
    public final zzgr zzf;
    public final zzgp zzg;
    public final zzgs zzh;
    public final zzgo zzi;
    public final zzgp zzj;
    public final zzgr zzk;
    public final zzgr zzl;
    public boolean zzm;
    public zzgp zzn;
    public zzgp zzo;
    public zzgr zzp;
    public final zzgs zzq;
    public final zzgs zzr;
    public final zzgr zzs;
    public final zzgo zzt;
    private SharedPreferences zzv;
    private Object zzw;
    private SharedPreferences zzx;
    private String zzy;
    private boolean zzz;

    protected final SharedPreferences zzc() {
        zzt();
        zzac();
        if (this.zzx == null) {
            synchronized (this.zzw) {
                if (this.zzx == null) {
                    String str = zza().getPackageName() + "_preferences";
                    zzj().zzp().zza("Default prefs file", str);
                    this.zzx = zza().getSharedPreferences(str, 0);
                }
            }
        }
        return this.zzx;
    }

    @Override // com.google.android.gms.measurement.internal.zzin
    protected final boolean zzo() {
        return true;
    }

    protected final SharedPreferences zzg() {
        zzt();
        zzac();
        Preconditions.checkNotNull(this.zzv);
        return this.zzv;
    }

    final Pair<String, Boolean> zza(String str) {
        zzt();
        if (!zzn().zza(zzis.zza.AD_STORAGE)) {
            return new Pair<>("", Boolean.FALSE);
        }
        long jElapsedRealtime = zzb().elapsedRealtime();
        if (this.zzy != null && jElapsedRealtime < this.zzaa) {
            return new Pair<>(this.zzy, Boolean.valueOf(this.zzz));
        }
        this.zzaa = jElapsedRealtime + zze().zzd(str);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zza());
            this.zzy = "";
            String id = advertisingIdInfo.getId();
            if (id != null) {
                this.zzy = id;
            }
            this.zzz = advertisingIdInfo.isLimitAdTrackingEnabled();
        } catch (Exception e) {
            zzj().zzc().zza("Unable to get advertising id", e);
            this.zzy = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.zzy, Boolean.valueOf(this.zzz));
    }

    final SparseArray<Long> zzh() {
        Bundle bundleZza = this.zzi.zza();
        if (bundleZza == null) {
            return new SparseArray<>();
        }
        int[] intArray = bundleZza.getIntArray("uriSources");
        long[] longArray = bundleZza.getLongArray("uriTimestamps");
        if (intArray == null || longArray == null) {
            return new SparseArray<>();
        }
        if (intArray.length != longArray.length) {
            zzj().zzg().zza("Trigger URI source and timestamp array lengths do not match");
            return new SparseArray<>();
        }
        SparseArray<Long> sparseArray = new SparseArray<>();
        for (int i = 0; i < intArray.length; i++) {
            sparseArray.put(intArray[i], Long.valueOf(longArray[i]));
        }
        return sparseArray;
    }

    final zzax zzm() {
        zzt();
        return zzax.zza(zzg().getString("dma_consent_settings", null));
    }

    final zzis zzn() {
        zzt();
        return zzis.zza(zzg().getString("consent_settings", "G1"), zzg().getInt("consent_source", 100));
    }

    final Boolean zzp() {
        zzt();
        if (zzg().contains("use_service")) {
            return Boolean.valueOf(zzg().getBoolean("use_service", false));
        }
        return null;
    }

    final Boolean zzu() {
        zzt();
        if (zzg().contains("measurement_enabled_from_api")) {
            return Boolean.valueOf(zzg().getBoolean("measurement_enabled_from_api", true));
        }
        return null;
    }

    final Boolean zzv() {
        zzt();
        if (zzg().contains("measurement_enabled")) {
            return Boolean.valueOf(zzg().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    protected final String zzw() {
        zzt();
        String string = zzg().getString("previous_os_version", null);
        zzf().zzac();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor editorEdit = zzg().edit();
            editorEdit.putString("previous_os_version", str);
            editorEdit.apply();
        }
        return string;
    }

    final String zzx() {
        zzt();
        return zzg().getString("admob_app_id", null);
    }

    final String zzy() {
        zzt();
        return zzg().getString("gmp_app_id", null);
    }

    zzgm(zzho zzhoVar) {
        super(zzhoVar);
        this.zzw = new Object();
        this.zzf = new zzgr(this, "session_timeout", ComponentTracker.DEFAULT_TIMEOUT);
        this.zzg = new zzgp(this, "start_new_session", true);
        this.zzk = new zzgr(this, "last_pause_time", 0L);
        this.zzl = new zzgr(this, SDKAnalyticsEvents.PARAMETER_SESSION_ID, 0L);
        this.zzh = new zzgs(this, "non_personalized_ads", null);
        this.zzi = new zzgo(this, "last_received_uri_timestamps_by_source", null);
        this.zzj = new zzgp(this, "allow_remote_dynamite", false);
        this.zzc = new zzgr(this, "first_open_time", 0L);
        this.zzd = new zzgr(this, "app_install_time", 0L);
        this.zze = new zzgs(this, "app_instance_id", null);
        this.zzn = new zzgp(this, "app_backgrounded", false);
        this.zzo = new zzgp(this, "deep_link_retrieval_complete", false);
        this.zzp = new zzgr(this, "deep_link_retrieval_attempts", 0L);
        this.zzq = new zzgs(this, "firebase_feature_rollouts", null);
        this.zzr = new zzgs(this, "deferred_attribution_cache", null);
        this.zzs = new zzgr(this, "deferred_attribution_cache_timestamp", 0L);
        this.zzt = new zzgo(this, "default_event_parameters", null);
    }

    final void zzz() {
        zzt();
        Boolean boolZzv = zzv();
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.clear();
        editorEdit.apply();
        if (boolZzv != null) {
            zza(boolZzv);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzin
    @EnsuresNonNull.List({@EnsuresNonNull({"this.preferences"}), @EnsuresNonNull({"this.monitoringSample"})})
    protected final void zzaa() {
        SharedPreferences sharedPreferences = zza().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzv = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("has_been_opened", false);
        this.zzm = z;
        if (!z) {
            SharedPreferences.Editor editorEdit = this.zzv.edit();
            editorEdit.putBoolean("has_been_opened", true);
            editorEdit.apply();
        }
        this.zzb = new zzgq(this, "health_monitor", Math.max(0L, zzbh.zzc.zza(null).longValue()));
    }

    final void zzb(String str) {
        zzt();
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.putString("admob_app_id", str);
        editorEdit.apply();
    }

    final void zzc(String str) {
        zzt();
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.putString("gmp_app_id", str);
        editorEdit.apply();
    }

    final void zza(Boolean bool) {
        zzt();
        SharedPreferences.Editor editorEdit = zzg().edit();
        if (bool != null) {
            editorEdit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            editorEdit.remove("measurement_enabled");
        }
        editorEdit.apply();
    }

    final void zzb(Boolean bool) {
        zzt();
        SharedPreferences.Editor editorEdit = zzg().edit();
        if (bool != null) {
            editorEdit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
        } else {
            editorEdit.remove("measurement_enabled_from_api");
        }
        editorEdit.apply();
    }

    final void zza(boolean z) {
        zzt();
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.putBoolean("use_service", z);
        editorEdit.apply();
    }

    final void zzb(boolean z) {
        zzt();
        zzj().zzp().zza("App measurement setting deferred collection", Boolean.valueOf(z));
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.putBoolean("deferred_analytics_collection", z);
        editorEdit.apply();
    }

    final void zza(SparseArray<Long> sparseArray) {
        if (sparseArray == null) {
            this.zzi.zza(null);
            return;
        }
        int[] iArr = new int[sparseArray.size()];
        long[] jArr = new long[sparseArray.size()];
        for (int i = 0; i < sparseArray.size(); i++) {
            iArr[i] = sparseArray.keyAt(i);
            jArr[i] = sparseArray.valueAt(i).longValue();
        }
        Bundle bundle = new Bundle();
        bundle.putIntArray("uriSources", iArr);
        bundle.putLongArray("uriTimestamps", jArr);
        this.zzi.zza(bundle);
    }

    final boolean zzab() {
        SharedPreferences sharedPreferences = this.zzv;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains("deferred_analytics_collection");
    }

    final boolean zza(long j) {
        return j - this.zzf.zza() > this.zzk.zza();
    }

    final boolean zza(zzis zzisVar) {
        zzt();
        int iZza = zzisVar.zza();
        if (!zza(iZza)) {
            return false;
        }
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.putString("consent_settings", zzisVar.zzh());
        editorEdit.putInt("consent_source", iZza);
        editorEdit.apply();
        return true;
    }

    final boolean zza(zzax zzaxVar) {
        zzt();
        if (!zzis.zza(zzaxVar.zza(), zzm().zza())) {
            return false;
        }
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.putString("dma_consent_settings", zzaxVar.zzf());
        editorEdit.apply();
        return true;
    }

    final boolean zza(int i) {
        return zzis.zza(i, zzg().getInt("consent_source", 100));
    }

    protected final boolean zza(zzmw zzmwVar) {
        zzt();
        String string = zzg().getString("stored_tcf_param", "");
        String strZzc = zzmwVar.zzc();
        if (strZzc.equals(string)) {
            return false;
        }
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.putString("stored_tcf_param", strZzc);
        editorEdit.apply();
        return true;
    }
}
