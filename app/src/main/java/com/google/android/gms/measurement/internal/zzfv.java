package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.android.gms.internal.measurement.zzod;
import com.google.android.gms.internal.measurement.zzpz;
import com.google.android.gms.internal.measurement.zzql;
import com.google.android.gms.internal.measurement.zzrc;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.maps.android.BuildConfig;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: loaded from: classes5.dex */
public final class zzfv extends zzg {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private long zzg;
    private List<String> zzh;
    private String zzi;
    private int zzj;
    private String zzk;
    private String zzl;
    private String zzm;
    private long zzn;
    private String zzo;

    final int zzaa() {
        zzu();
        return this.zzj;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zzz() {
        return true;
    }

    final int zzab() {
        zzu();
        return this.zzc;
    }

    @Override // com.google.android.gms.measurement.internal.zzio, com.google.android.gms.measurement.internal.zziq
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzio, com.google.android.gms.measurement.internal.zziq
    @Pure
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zza zzc() {
        return super.zzc();
    }

    /* JADX WARN: Code duplicated, block: B:46:0x015f A[PHI: r28 r30
  0x015f: PHI (r28v5 java.util.List<java.lang.String>) = 
  (r28v2 java.util.List<java.lang.String>)
  (r28v2 java.util.List<java.lang.String>)
  (r28v6 java.util.List<java.lang.String>)
 binds: [B:29:0x0112, B:31:0x011e, B:25:0x0107] A[DONT_GENERATE, DONT_INLINE]
  0x015f: PHI (r30v3 java.lang.String) = (r30v1 java.lang.String), (r30v1 java.lang.String), (r30v4 java.lang.String) binds: [B:29:0x0112, B:31:0x011e, B:25:0x0107] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:49:0x0175  */
    /* JADX WARN: Code duplicated, block: B:50:0x0178  */
    /* JADX WARN: Code duplicated, block: B:56:0x01be  */
    /* JADX WARN: Code duplicated, block: B:62:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:68:0x020b  */
    final zzn zza(String str) {
        long jMin;
        List<String> list;
        String str2;
        long j;
        boolean z;
        boolean z2;
        String str3;
        Boolean boolZzf;
        boolean zBooleanValue;
        int iZzc;
        long jZzh;
        String strZzb;
        zzt();
        String strZzad = zzad();
        String strZzae = zzae();
        zzu();
        String str4 = this.zzb;
        long jZzab = zzab();
        zzu();
        Preconditions.checkNotNull(this.zzd);
        String str5 = this.zzd;
        zzu();
        zzt();
        if (this.zzf == 0) {
            this.zzf = this.zzu.zzt().zza(zza(), zza().getPackageName());
        }
        long j2 = this.zzf;
        boolean zZzac = this.zzu.zzac();
        boolean z3 = !zzk().zzm;
        zzt();
        String strZzah = !this.zzu.zzac() ? null : zzah();
        zzho zzhoVar = this.zzu;
        long jZza = zzhoVar.zzn().zzc.zza();
        if (jZza == 0) {
            jMin = zzhoVar.zza;
        } else {
            jMin = Math.min(zzhoVar.zza, jZza);
        }
        long j3 = jMin;
        int iZzaa = zzaa();
        boolean zZzu = zze().zzu();
        zzgm zzgmVarZzk = zzk();
        zzgmVarZzk.zzt();
        boolean z4 = zzgmVarZzk.zzg().getBoolean("deferred_analytics_collection", false);
        String strZzac = zzac();
        Boolean boolZzf2 = zze().zzf("google_analytics_default_allow_ad_personalization_signals");
        Boolean boolValueOf = boolZzf2 == null ? null : Boolean.valueOf(!boolZzf2.booleanValue());
        long j4 = this.zzg;
        List<String> list2 = this.zzh;
        String strZzh = zzk().zzn().zzh();
        if (this.zzi == null) {
            this.zzi = zzq().zzp();
        }
        String str6 = this.zzi;
        if (zzod.zza()) {
            list = list2;
            str2 = str6;
            if (zze().zza(zzbh.zzdf) && !zzk().zzn().zza(zzis.zza.ANALYTICS_STORAGE)) {
                z = zZzac;
                z2 = z3;
                j = 0;
                str3 = null;
            }
            boolZzf = zze().zzf("google_analytics_sgtm_upload_enabled");
            if (boolZzf == null) {
                zBooleanValue = false;
            } else {
                zBooleanValue = boolZzf.booleanValue();
            }
            long jZzc = zzq().zzc(zzad());
            int iZza = zzk().zzn().zza();
            String strZzf = zzk().zzm().zzf();
            if (zzpz.zza() || !zze().zza(zzbh.zzch)) {
                iZzc = 0;
            } else {
                zzq();
                iZzc = zznw.zzc();
            }
            if (zzpz.zza() || !zze().zza(zzbh.zzch)) {
                jZzh = j;
            } else {
                jZzh = zzq().zzh();
            }
            String strZzp = zze().zzp();
            if (!com.google.android.gms.internal.measurement.zznx.zza() && zze().zza(zzbh.zzda)) {
                strZzb = new zzgn(zze().zze("google_analytics_default_allow_ad_personalization_signals")).zzb();
            } else {
                strZzb = "";
            }
            return new zzn(strZzad, strZzae, str4, jZzab, str5, 88000L, j2, str, z, z2, strZzah, 0L, j3, iZzaa, zZzu, z4, strZzac, boolValueOf, j4, list, (String) null, strZzh, str2, str3, zBooleanValue, jZzc, iZza, strZzf, iZzc, jZzh, strZzp, strZzb);
        }
        list = list2;
        str2 = str6;
        if (zzql.zza() && zze().zza(zzbh.zzbr)) {
            zzt();
            j = 0;
            if (this.zzn != 0) {
                long jCurrentTimeMillis = zzb().currentTimeMillis();
                z = zZzac;
                z2 = z3;
                long j5 = this.zzn;
                if (this.zzm != null && jCurrentTimeMillis - j5 > 86400000 && this.zzo == null) {
                    zzag();
                }
            } else {
                z = zZzac;
                z2 = z3;
            }
            if (this.zzm == null) {
                zzag();
            }
            str3 = this.zzm;
        } else {
            z = zZzac;
            z2 = z3;
            j = 0;
            str3 = null;
        }
        boolZzf = zze().zzf("google_analytics_sgtm_upload_enabled");
        if (boolZzf == null) {
            zBooleanValue = false;
        } else {
            zBooleanValue = boolZzf.booleanValue();
        }
        long jZzc2 = zzq().zzc(zzad());
        int iZza2 = zzk().zzn().zza();
        String strZzf2 = zzk().zzm().zzf();
        if (zzpz.zza()) {
            iZzc = 0;
        } else {
            iZzc = 0;
        }
        if (zzpz.zza()) {
            jZzh = j;
        } else {
            jZzh = j;
        }
        String strZzp2 = zze().zzp();
        if (!com.google.android.gms.internal.measurement.zznx.zza()) {
            strZzb = "";
        } else {
            strZzb = "";
        }
        return new zzn(strZzad, strZzae, str4, jZzab, str5, 88000L, j2, str, z, z2, strZzah, 0L, j3, iZzaa, zZzu, z4, strZzac, boolValueOf, j4, list, (String) null, strZzh, str2, str3, zBooleanValue, jZzc2, iZza2, strZzf2, iZzc, jZzh, strZzp2, strZzb);
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

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzfv zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzfu zzh() {
        return super.zzh();
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

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzja zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzkw zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzlf zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzmp zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    @Pure
    public final /* bridge */ /* synthetic */ zznw zzq() {
        return super.zzq();
    }

    final String zzac() {
        zzu();
        return this.zzl;
    }

    final String zzad() {
        zzu();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    private final String zzah() {
        if (zzrc.zza() && zze().zza(zzbh.zzbk)) {
            zzj().zzp().zza("Disabled IID for tests.");
            return null;
        }
        try {
            Class<?> clsLoadClass = zza().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            if (clsLoadClass == null) {
                return null;
            }
            try {
                Object objInvoke = clsLoadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, zza());
                if (objInvoke == null) {
                    return null;
                }
                try {
                    return (String) clsLoadClass.getDeclaredMethod("getFirebaseInstanceId", null).invoke(objInvoke, null);
                } catch (Exception unused) {
                    zzj().zzv().zza("Failed to retrieve Firebase Instance Id");
                    return null;
                }
            } catch (Exception unused2) {
                zzj().zzw().zza("Failed to obtain Firebase Analytics instance");
                return null;
            }
        } catch (ClassNotFoundException unused3) {
        }
    }

    final String zzae() {
        zzt();
        zzu();
        Preconditions.checkNotNull(this.zzk);
        return this.zzk;
    }

    final List<String> zzaf() {
        return this.zzh;
    }

    zzfv(zzho zzhoVar, long j) {
        super(zzhoVar);
        this.zzn = 0L;
        this.zzo = null;
        this.zzg = j;
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ void zzr() {
        super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:34:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:35:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:36:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:37:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:38:0x010b  */
    /* JADX WARN: Code duplicated, block: B:39:0x0119  */
    /* JADX WARN: Code duplicated, block: B:40:0x0127  */
    /* JADX WARN: Code duplicated, block: B:41:0x0135  */
    /* JADX WARN: Code duplicated, block: B:42:0x0143  */
    /* JADX WARN: Code duplicated, block: B:43:0x0151  */
    /* JADX WARN: Code duplicated, block: B:46:0x0161  */
    /* JADX WARN: Code duplicated, block: B:49:0x0168  */
    /* JADX WARN: Code duplicated, block: B:52:0x018b  */
    /* JADX WARN: Code duplicated, block: B:53:0x018c  */
    /* JADX WARN: Code duplicated, block: B:56:0x0195 A[Catch: IllegalStateException -> 0x01cb, TryCatch #2 {IllegalStateException -> 0x01cb, blocks: (B:50:0x0170, B:54:0x018d, B:56:0x0195, B:58:0x01ae, B:60:0x01c0, B:62:0x01c5, B:61:0x01c3), top: B:87:0x0170 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x01ae A[Catch: IllegalStateException -> 0x01cb, TryCatch #2 {IllegalStateException -> 0x01cb, blocks: (B:50:0x0170, B:54:0x018d, B:56:0x0195, B:58:0x01ae, B:60:0x01c0, B:62:0x01c5, B:61:0x01c3), top: B:87:0x0170 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x01c0 A[Catch: IllegalStateException -> 0x01cb, TryCatch #2 {IllegalStateException -> 0x01cb, blocks: (B:50:0x0170, B:54:0x018d, B:56:0x0195, B:58:0x01ae, B:60:0x01c0, B:62:0x01c5, B:61:0x01c3), top: B:87:0x0170 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x01c3 A[Catch: IllegalStateException -> 0x01cb, TryCatch #2 {IllegalStateException -> 0x01cb, blocks: (B:50:0x0170, B:54:0x018d, B:56:0x0195, B:58:0x01ae, B:60:0x01c0, B:62:0x01c5, B:61:0x01c3), top: B:87:0x0170 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:70:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:71:0x0200  */
    /* JADX WARN: Code duplicated, block: B:74:0x020a  */
    /* JADX WARN: Code duplicated, block: B:77:0x021d  */
    /* JADX WARN: Code duplicated, block: B:79:0x0221  */
    /* JADX WARN: Code duplicated, block: B:81:0x022c  */
    /* JADX WARN: Code duplicated, block: B:91:0x021d A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.measurement.internal.zzg
    @EnsuresNonNull({RemoteConfigConstants.RequestFieldKey.APP_ID, "appStore", "appName", "gmpAppId", "gaAppId"})
    protected final void zzx() {
        String str;
        String string;
        byte b;
        int iZzc;
        boolean z;
        List<String> listZzh;
        Iterator<String> it2;
        String strZza;
        String str2;
        String packageName = zza().getPackageName();
        PackageManager packageManager = zza().getPackageManager();
        String str3 = "";
        String installerPackageName = "unknown";
        String str4 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        int i = Integer.MIN_VALUE;
        try {
            if (packageManager == null) {
                zzj().zzg().zza("PackageManager is null, app identity information might be inaccurate. appId", zzgb.zza(packageName));
            } else {
                try {
                    installerPackageName = packageManager.getInstallerPackageName(packageName);
                } catch (IllegalArgumentException unused) {
                    zzj().zzg().zza("Error retrieving app installer package name. appId", zzgb.zza(packageName));
                }
                if (installerPackageName == null) {
                    installerPackageName = "manual_install";
                } else if ("com.android.vending".equals(installerPackageName)) {
                    installerPackageName = "";
                }
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(zza().getPackageName(), 0);
                    if (packageInfo != null) {
                        CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                        string = !TextUtils.isEmpty(applicationLabel) ? applicationLabel.toString() : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                        try {
                            str4 = packageInfo.versionName;
                            i = packageInfo.versionCode;
                        } catch (PackageManager.NameNotFoundException unused2) {
                            str = str4;
                            str4 = string;
                            zzj().zzg().zza("Error retrieving package info. appId, appName", zzgb.zza(packageName), str4);
                            string = str4;
                            str4 = str;
                        }
                    }
                } catch (PackageManager.NameNotFoundException unused3) {
                    str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                }
                this.zza = packageName;
                this.zzd = installerPackageName;
                this.zzb = str4;
                this.zzc = i;
                this.zze = string;
                this.zzf = 0L;
                if (TextUtils.isEmpty(this.zzu.zzu()) && "am".equals(this.zzu.zzv())) {
                    b = true;
                } else {
                    b = false;
                }
                iZzc = this.zzu.zzc();
                switch (iZzc) {
                    case 0:
                        zzj().zzp().zza("App measurement collection enabled");
                        break;
                    case 1:
                        zzj().zzn().zza("App measurement deactivated via the manifest");
                        break;
                    case 2:
                        zzj().zzp().zza("App measurement deactivated via the init parameters");
                        break;
                    case 3:
                        zzj().zzn().zza("App measurement disabled by setAnalyticsCollectionEnabled(false)");
                        break;
                    case 4:
                        zzj().zzn().zza("App measurement disabled via the manifest");
                        break;
                    case 5:
                        zzj().zzp().zza("App measurement disabled via the init parameters");
                        break;
                    case 6:
                        zzj().zzv().zza("App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics");
                        break;
                    case 7:
                        zzj().zzn().zza("App measurement disabled via the global data collection setting");
                        break;
                    case 8:
                        zzj().zzn().zza("App measurement disabled due to denied storage consent");
                        break;
                    default:
                        zzj().zzn().zza("App measurement disabled");
                        zzj().zzm().zza("Invalid scion state in identity");
                        break;
                }
                z = iZzc == 0;
                this.zzk = "";
                this.zzl = "";
                if (b != false) {
                    this.zzl = this.zzu.zzu();
                }
                strZza = new zzhi(zza(), this.zzu.zzx()).zza("google_app_id");
                if (TextUtils.isEmpty(strZza)) {
                    str3 = strZza;
                }
                this.zzk = str3;
                if (!TextUtils.isEmpty(strZza)) {
                    this.zzl = new zzhi(zza(), this.zzu.zzx()).zza("admob_app_id");
                }
                if (z) {
                    zzgd zzgdVarZzp = zzj().zzp();
                    String str5 = this.zza;
                    if (TextUtils.isEmpty(this.zzk)) {
                        str2 = this.zzl;
                    } else {
                        str2 = this.zzk;
                    }
                    zzgdVarZzp.zza("App measurement enabled for app package, google app id", str5, str2);
                }
                this.zzh = null;
                listZzh = zze().zzh("analytics.safelisted_events");
                if (listZzh == null) {
                    if (listZzh.isEmpty()) {
                        zzj().zzv().zza("Safelisted event list is empty. Ignoring");
                    } else {
                        it2 = listZzh.iterator();
                        do {
                            if (it2.hasNext()) {
                                this.zzh = listZzh;
                            }
                        } while (zzq().zzb("safelisted event", it2.next()));
                    }
                } else {
                    this.zzh = listZzh;
                }
                if (packageManager != null) {
                    this.zzj = InstantApps.isInstantApp(zza()) ? 1 : 0;
                } else {
                    this.zzj = 0;
                }
            }
            strZza = new zzhi(zza(), this.zzu.zzx()).zza("google_app_id");
            if (TextUtils.isEmpty(strZza)) {
                str3 = strZza;
            }
            this.zzk = str3;
            if (!TextUtils.isEmpty(strZza)) {
                this.zzl = new zzhi(zza(), this.zzu.zzx()).zza("admob_app_id");
            }
            if (z) {
                zzgd zzgdVarZzp2 = zzj().zzp();
                String str6 = this.zza;
                if (TextUtils.isEmpty(this.zzk)) {
                    str2 = this.zzl;
                } else {
                    str2 = this.zzk;
                }
                zzgdVarZzp2.zza("App measurement enabled for app package, google app id", str6, str2);
            }
        } catch (IllegalStateException e) {
            zzj().zzg().zza("Fetching Google App Id failed with exception. appId", zzgb.zza(packageName), e);
        }
        string = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        this.zza = packageName;
        this.zzd = installerPackageName;
        this.zzb = str4;
        this.zzc = i;
        this.zze = string;
        this.zzf = 0L;
        if (TextUtils.isEmpty(this.zzu.zzu())) {
            b = false;
        } else {
            b = false;
        }
        iZzc = this.zzu.zzc();
        switch (iZzc) {
            case 0:
                zzj().zzp().zza("App measurement collection enabled");
                break;
            case 1:
                zzj().zzn().zza("App measurement deactivated via the manifest");
                break;
            case 2:
                zzj().zzp().zza("App measurement deactivated via the init parameters");
                break;
            case 3:
                zzj().zzn().zza("App measurement disabled by setAnalyticsCollectionEnabled(false)");
                break;
            case 4:
                zzj().zzn().zza("App measurement disabled via the manifest");
                break;
            case 5:
                zzj().zzp().zza("App measurement disabled via the init parameters");
                break;
            case 6:
                zzj().zzv().zza("App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics");
                break;
            case 7:
                zzj().zzn().zza("App measurement disabled via the global data collection setting");
                break;
            case 8:
                zzj().zzn().zza("App measurement disabled due to denied storage consent");
                break;
            default:
                zzj().zzn().zza("App measurement disabled");
                zzj().zzm().zza("Invalid scion state in identity");
                break;
        }
        if (iZzc == 0) {
        }
        this.zzk = "";
        this.zzl = "";
        if (b != false) {
            this.zzl = this.zzu.zzu();
        }
        this.zzh = null;
        listZzh = zze().zzh("analytics.safelisted_events");
        if (listZzh == null) {
            if (listZzh.isEmpty()) {
                zzj().zzv().zza("Safelisted event list is empty. Ignoring");
            } else {
                it2 = listZzh.iterator();
                do {
                    if (it2.hasNext()) {
                        this.zzh = listZzh;
                    }
                } while (zzq().zzb("safelisted event", it2.next()));
            }
        } else {
            this.zzh = listZzh;
        }
        if (packageManager != null) {
            this.zzj = InstantApps.isInstantApp(zza()) ? 1 : 0;
        } else {
            this.zzj = 0;
        }
    }

    final void zzag() {
        String str;
        zzt();
        if (!zzk().zzn().zza(zzis.zza.ANALYTICS_STORAGE)) {
            zzj().zzc().zza("Analytics Storage consent is not granted");
            str = null;
        } else {
            byte[] bArr = new byte[16];
            zzq().zzv().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        }
        zzj().zzc().zza(String.format("Resetting session stitching token to %s", str == null ? BuildConfig.TRAVIS : "not null"));
        this.zzm = str;
        this.zzn = zzb().currentTimeMillis();
    }

    final boolean zzb(String str) {
        String str2 = this.zzo;
        boolean z = (str2 == null || str2.equals(str)) ? false : true;
        this.zzo = str;
        return z;
    }
}
