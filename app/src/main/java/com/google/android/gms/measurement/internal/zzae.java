package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Size;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzpm;
import com.google.android.gms.internal.measurement.zzpn;
import com.google.firebase.perf.util.Constants;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: loaded from: classes4.dex */
public final class zzae extends zzio {
    private Boolean zza;
    private String zzb;
    private zzag zzc;
    private Boolean zzd;

    public final double zza(String str, zzfo<Double> zzfoVar) {
        if (str == null) {
            return zzfoVar.zza(null).doubleValue();
        }
        String strZza = this.zzc.zza(str, zzfoVar.zza());
        if (TextUtils.isEmpty(strZza)) {
            return zzfoVar.zza(null).doubleValue();
        }
        try {
            return zzfoVar.zza(Double.valueOf(Double.parseDouble(strZza))).doubleValue();
        } catch (NumberFormatException unused) {
            return zzfoVar.zza(null).doubleValue();
        }
    }

    final int zzc() {
        return (zzpn.zza() && zze().zzf(null, zzbh.zzcd) && zzq().zza(231100000, true)) ? 35 : 0;
    }

    final int zza(@Size(min = 1) String str) {
        return zza(str, zzbh.zzah, 500, Constants.MAX_URL_LENGTH);
    }

    final int zza(String str, boolean z) {
        if (!zzpm.zza() || !zze().zzf(null, zzbh.zzcv)) {
            return 100;
        }
        if (z) {
            return zza(str, zzbh.zzar, 100, 500);
        }
        return 500;
    }

    final int zzb(String str, boolean z) {
        return Math.max(zza(str, z), 256);
    }

    public final int zzg() {
        return zzq().zza(201500000, true) ? 100 : 25;
    }

    public final int zzb(@Size(min = 1) String str) {
        return zza(str, zzbh.zzai, 25, 100);
    }

    public final int zzc(@Size(min = 1) String str) {
        return zzb(str, zzbh.zzo);
    }

    public final int zzb(String str, zzfo<Integer> zzfoVar) {
        if (str == null) {
            return zzfoVar.zza(null).intValue();
        }
        String strZza = this.zzc.zza(str, zzfoVar.zza());
        if (TextUtils.isEmpty(strZza)) {
            return zzfoVar.zza(null).intValue();
        }
        try {
            return zzfoVar.zza(Integer.valueOf(Integer.parseInt(strZza))).intValue();
        } catch (NumberFormatException unused) {
            return zzfoVar.zza(null).intValue();
        }
    }

    public final int zza(String str, zzfo<Integer> zzfoVar, int i, int i2) {
        return Math.max(Math.min(zzb(str, zzfoVar), i2), i);
    }

    final long zzd(String str) {
        return zzc(str, zzbh.zza);
    }

    public static long zzh() {
        return zzbh.zzd.zza(null).longValue();
    }

    public static long zzm() {
        return zzbh.zzad.zza(null).longValue();
    }

    public final long zzc(String str, zzfo<Long> zzfoVar) {
        if (str == null) {
            return zzfoVar.zza(null).longValue();
        }
        String strZza = this.zzc.zza(str, zzfoVar.zza());
        if (TextUtils.isEmpty(strZza)) {
            return zzfoVar.zza(null).longValue();
        }
        try {
            return zzfoVar.zza(Long.valueOf(Long.parseLong(strZza))).longValue();
        } catch (NumberFormatException unused) {
            return zzfoVar.zza(null).longValue();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzio, com.google.android.gms.measurement.internal.zziq
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    private final Bundle zzz() {
        try {
            if (zza().getPackageManager() == null) {
                zzj().zzg().zza("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(zza()).getApplicationInfo(zza().getPackageName(), 128);
            if (applicationInfo == null) {
                zzj().zzg().zza("Failed to load metadata: ApplicationInfo is null");
                return null;
            }
            return applicationInfo.metaData;
        } catch (PackageManager.NameNotFoundException e) {
            zzj().zzg().zza("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzio, com.google.android.gms.measurement.internal.zziq
    @Pure
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzio, com.google.android.gms.measurement.internal.zziq
    @Pure
    public final /* bridge */ /* synthetic */ zzad zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    @Pure
    public final /* bridge */ /* synthetic */ zzae zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    @Pure
    public final /* bridge */ /* synthetic */ zzaz zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    @Pure
    public final /* bridge */ /* synthetic */ zzfw zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzio, com.google.android.gms.measurement.internal.zziq
    @Pure
    public final /* bridge */ /* synthetic */ zzgb zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    @Pure
    public final /* bridge */ /* synthetic */ zzgm zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzio, com.google.android.gms.measurement.internal.zziq
    @Pure
    public final /* bridge */ /* synthetic */ zzhh zzl() {
        return super.zzl();
    }

    public final zzir zze(String str) {
        Object obj;
        Preconditions.checkNotEmpty(str);
        Bundle bundleZzz = zzz();
        if (bundleZzz == null) {
            zzj().zzg().zza("Failed to load metadata: Metadata bundle is null");
            obj = null;
        } else {
            obj = bundleZzz.get(str);
        }
        if (obj == null) {
            return zzir.UNINITIALIZED;
        }
        if (Boolean.TRUE.equals(obj)) {
            return zzir.GRANTED;
        }
        if (Boolean.FALSE.equals(obj)) {
            return zzir.DENIED;
        }
        if ("default".equals(obj)) {
            return zzir.DEFAULT;
        }
        zzj().zzu().zza("Invalid manifest metadata for", str);
        return zzir.UNINITIALIZED;
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    @Pure
    public final /* bridge */ /* synthetic */ zznw zzq() {
        return super.zzq();
    }

    final Boolean zzf(@Size(min = 1) String str) {
        Preconditions.checkNotEmpty(str);
        Bundle bundleZzz = zzz();
        if (bundleZzz == null) {
            zzj().zzg().zza("Failed to load metadata: Metadata bundle is null");
            return null;
        }
        if (bundleZzz.containsKey(str)) {
            return Boolean.valueOf(bundleZzz.getBoolean(str));
        }
        return null;
    }

    public final String zzn() {
        return zza("debug.firebase.analytics.app", "");
    }

    public final String zzo() {
        return zza("debug.deferred.deeplink", "");
    }

    public final String zzd(String str, zzfo<String> zzfoVar) {
        if (str == null) {
            return zzfoVar.zza(null);
        }
        return zzfoVar.zza(this.zzc.zza(str, zzfoVar.zza()));
    }

    public final String zzp() {
        return this.zzb;
    }

    final String zzg(String str) {
        return zzd(str, zzbh.zzal);
    }

    private final String zza(String str, String str2) {
        try {
            String str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
            Preconditions.checkNotNull(str3);
            return str3;
        } catch (ClassNotFoundException e) {
            zzj().zzg().zza("Could not find SystemProperties class", e);
            return str2;
        } catch (IllegalAccessException e2) {
            zzj().zzg().zza("Could not access SystemProperties.get()", e2);
            return str2;
        } catch (NoSuchMethodException e3) {
            zzj().zzg().zza("Could not find SystemProperties.get() method", e3);
            return str2;
        } catch (InvocationTargetException e4) {
            zzj().zzg().zza("SystemProperties.get() threw an exception", e4);
            return str2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:13:0x003d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:14:0x003e A[Catch: NotFoundException -> 0x0043, TRY_LEAVE, TryCatch #0 {NotFoundException -> 0x0043, blocks: (B:11:0x002b, B:14:0x003e), top: B:19:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:19:0x002b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    final List<String> zzh(@Size(min = 1) String str) {
        Integer numValueOf;
        String[] stringArray;
        Preconditions.checkNotEmpty(str);
        Bundle bundleZzz = zzz();
        if (bundleZzz == null) {
            zzj().zzg().zza("Failed to load metadata: Metadata bundle is null");
        } else {
            if (bundleZzz.containsKey(str)) {
                numValueOf = Integer.valueOf(bundleZzz.getInt(str));
            }
            if (numValueOf == null) {
                return null;
            }
            try {
                stringArray = zza().getResources().getStringArray(numValueOf.intValue());
                if (stringArray == null) {
                    return null;
                }
                return Arrays.asList(stringArray);
            } catch (Resources.NotFoundException e) {
                zzj().zzg().zza("Failed to load string array from metadata: resource not found", e);
                return null;
            }
        }
        numValueOf = null;
        if (numValueOf == null) {
            return null;
        }
        stringArray = zza().getResources().getStringArray(numValueOf.intValue());
        if (stringArray == null) {
            return null;
        }
        return Arrays.asList(stringArray);
    }

    zzae(zzho zzhoVar) {
        super(zzhoVar);
        this.zzc = new zzag() { // from class: com.google.android.gms.measurement.internal.zzah
            @Override // com.google.android.gms.measurement.internal.zzag
            public final String zza(String str, String str2) {
                return null;
            }
        };
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ void zzr() {
        super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    final void zza(zzag zzagVar) {
        this.zzc = zzagVar;
    }

    public final void zzi(String str) {
        this.zzb = str;
    }

    public final boolean zzu() {
        Boolean boolZzf = zzf("google_analytics_adid_collection_enabled");
        return boolZzf == null || boolZzf.booleanValue();
    }

    final boolean zzj(String str) {
        return zzf(str, zzbh.zzak);
    }

    public final boolean zza(zzfo<Boolean> zzfoVar) {
        return zzf(null, zzfoVar);
    }

    public final boolean zze(String str, zzfo<Boolean> zzfoVar) {
        return zzf(str, zzfoVar);
    }

    public final boolean zzf(String str, zzfo<Boolean> zzfoVar) {
        if (str == null) {
            return zzfoVar.zza(null).booleanValue();
        }
        String strZza = this.zzc.zza(str, zzfoVar.zza());
        if (TextUtils.isEmpty(strZza)) {
            return zzfoVar.zza(null).booleanValue();
        }
        return zzfoVar.zza(Boolean.valueOf(AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(strZza))).booleanValue();
    }

    public final boolean zzk(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(this.zzc.zza(str, "gaia_collection_enabled"));
    }

    public final boolean zzv() {
        Boolean boolZzf = zzf("google_analytics_automatic_screen_reporting_enabled");
        return boolZzf == null || boolZzf.booleanValue();
    }

    public final boolean zzw() {
        Boolean boolZzf = zzf("firebase_analytics_collection_deactivated");
        return boolZzf != null && boolZzf.booleanValue();
    }

    public final boolean zzl(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(this.zzc.zza(str, "measurement.event_sampling_enabled"));
    }

    final boolean zzx() {
        if (this.zza == null) {
            Boolean boolZzf = zzf("app_measurement_lite");
            this.zza = boolZzf;
            if (boolZzf == null) {
                this.zza = Boolean.FALSE;
            }
        }
        return this.zza.booleanValue() || !this.zzu.zzag();
    }

    @EnsuresNonNull({"this.isMainProcess"})
    public final boolean zzy() {
        if (this.zzd == null) {
            synchronized (this) {
                if (this.zzd == null) {
                    ApplicationInfo applicationInfo = zza().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.zzd = Boolean.valueOf(str != null && str.equals(myProcessName));
                    }
                    if (this.zzd == null) {
                        this.zzd = Boolean.TRUE;
                        zzj().zzg().zza("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzd.booleanValue();
    }
}
