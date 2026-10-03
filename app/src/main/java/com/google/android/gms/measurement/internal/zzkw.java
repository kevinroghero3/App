package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Size;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.maps.android.BuildConfig;
import io.sentry.protocol.App;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: loaded from: classes5.dex */
public final class zzkw extends zzg {
    protected zzkx zza;
    private volatile zzkx zzb;
    private volatile zzkx zzc;
    private final Map<Activity, zzkx> zzd;
    private Activity zze;
    private volatile boolean zzf;
    private volatile zzkx zzg;
    private zzkx zzh;
    private boolean zzi;
    private final Object zzj;

    @Override // com.google.android.gms.measurement.internal.zzio, com.google.android.gms.measurement.internal.zziq
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zzz() {
        return false;
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

    private final zzkx zzd(@NonNull Activity activity) {
        Preconditions.checkNotNull(activity);
        zzkx zzkxVar = this.zzd.get(activity);
        if (zzkxVar == null) {
            zzkx zzkxVar2 = new zzkx(null, zza(activity.getClass(), "Activity"), zzq().zzm());
            this.zzd.put(activity, zzkxVar2);
            zzkxVar = zzkxVar2;
        }
        return this.zzg != null ? this.zzg : zzkxVar;
    }

    public final zzkx zzaa() {
        return this.zzb;
    }

    public final zzkx zza(boolean z) {
        zzu();
        zzt();
        if (!z) {
            return this.zza;
        }
        zzkx zzkxVar = this.zza;
        return zzkxVar != null ? zzkxVar : this.zzh;
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

    private final String zza(Class<?> cls, String str) {
        String str2;
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return str;
        }
        String[] strArrSplit = canonicalName.split("\\.");
        if (strArrSplit.length > 0) {
            str2 = strArrSplit[strArrSplit.length - 1];
        } else {
            str2 = "";
        }
        return str2.length() > zze().zza((String) null, false) ? str2.substring(0, zze().zza((String) null, false)) : str2;
    }

    static /* synthetic */ void zza(zzkw zzkwVar, Bundle bundle, zzkx zzkxVar, zzkx zzkxVar2, long j) {
        if (bundle != null) {
            bundle.remove("screen_name");
            bundle.remove(FirebaseAnalytics.Param.SCREEN_CLASS);
        }
        zzkwVar.zza(zzkxVar, zzkxVar2, j, true, zzkwVar.zzq().zza((String) null, FirebaseAnalytics.Event.SCREEN_VIEW, bundle, (List<String>) null, false));
    }

    public zzkw(zzho zzhoVar) {
        super(zzhoVar);
        this.zzj = new Object();
        this.zzd = new ConcurrentHashMap();
    }

    private final void zza(Activity activity, zzkx zzkxVar, boolean z) {
        zzkx zzkxVar2;
        zzkx zzkxVar3 = this.zzb == null ? this.zzc : this.zzb;
        if (zzkxVar.zzb == null) {
            zzkxVar2 = new zzkx(zzkxVar.zza, activity != null ? zza(activity.getClass(), "Activity") : null, zzkxVar.zzc, zzkxVar.zze, zzkxVar.zzf);
        } else {
            zzkxVar2 = zzkxVar;
        }
        this.zzc = this.zzb;
        this.zzb = zzkxVar2;
        zzl().zzb(new zzky(this, zzkxVar2, zzkxVar3, zzb().elapsedRealtime(), z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:48:0x00ad  */
    public final void zza(zzkx zzkxVar, zzkx zzkxVar2, long j, boolean z, Bundle bundle) {
        String str;
        long j2;
        zzt();
        boolean z2 = false;
        boolean z3 = (zzkxVar2 != null && zzkxVar2.zzc == zzkxVar.zzc && Objects.equals(zzkxVar2.zzb, zzkxVar.zzb) && Objects.equals(zzkxVar2.zza, zzkxVar.zza)) ? false : true;
        if (z && this.zza != null) {
            z2 = true;
        }
        if (z3) {
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            zznw.zza(zzkxVar, bundle2, true);
            if (zzkxVar2 != null) {
                String str2 = zzkxVar2.zza;
                if (str2 != null) {
                    bundle2.putString("_pn", str2);
                }
                String str3 = zzkxVar2.zzb;
                if (str3 != null) {
                    bundle2.putString("_pc", str3);
                }
                bundle2.putLong("_pi", zzkxVar2.zzc);
            }
            if (z2) {
                long jZza = zzp().zzb.zza(j);
                if (jZza > 0) {
                    zzq().zza(bundle2, jZza);
                }
            }
            if (!zze().zzv()) {
                bundle2.putLong("_mst", 1L);
            }
            if (zzkxVar.zze) {
                str = App.TYPE;
            } else {
                str = "auto";
            }
            String str4 = str;
            long jCurrentTimeMillis = zzb().currentTimeMillis();
            if (zzkxVar.zze) {
                long j3 = zzkxVar.zzf;
                if (j3 != 0) {
                    j2 = j3;
                } else {
                    j2 = jCurrentTimeMillis;
                }
            } else {
                j2 = jCurrentTimeMillis;
            }
            zzm().zza(str4, "_vs", j2, bundle2);
        }
        if (z2) {
            zza(this.zza, true, j);
        }
        this.zza = zzkxVar;
        if (zzkxVar.zze) {
            this.zzh = zzkxVar;
        }
        zzo().zza(zzkxVar);
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

    public final void zza(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (!zze().zzv() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.zzd.put(activity, new zzkx(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
    }

    public final void zza(Activity activity) {
        synchronized (this.zzj) {
            if (activity == this.zze) {
                this.zze = null;
            }
        }
        if (zze().zzv()) {
            this.zzd.remove(activity);
        }
    }

    public final void zzb(Activity activity) {
        synchronized (this.zzj) {
            this.zzi = false;
            this.zzf = true;
        }
        long jElapsedRealtime = zzb().elapsedRealtime();
        if (!zze().zzv()) {
            this.zzb = null;
            zzl().zzb(new zzla(this, jElapsedRealtime));
        } else {
            zzkx zzkxVarZzd = zzd(activity);
            this.zzc = this.zzb;
            this.zzb = null;
            zzl().zzb(new zzld(this, zzkxVarZzd, jElapsedRealtime));
        }
    }

    public final void zzc(Activity activity) {
        synchronized (this.zzj) {
            this.zzi = true;
            if (activity != this.zze) {
                synchronized (this.zzj) {
                    this.zze = activity;
                    this.zzf = false;
                }
                if (zze().zzv()) {
                    this.zzg = null;
                    zzl().zzb(new zzlc(this));
                }
            }
        }
        if (!zze().zzv()) {
            this.zzb = this.zzg;
            zzl().zzb(new zzlb(this));
        } else {
            zza(activity, zzd(activity), false);
            zza zzaVarZzc = zzc();
            zzaVarZzc.zzl().zzb(new zze(zzaVarZzc, zzaVarZzc.zzb().elapsedRealtime()));
        }
    }

    public final void zzb(Activity activity, Bundle bundle) {
        zzkx zzkxVar;
        if (!zze().zzv() || bundle == null || (zzkxVar = this.zzd.get(activity)) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", zzkxVar.zzc);
        bundle2.putString("name", zzkxVar.zza);
        bundle2.putString("referrer_name", zzkxVar.zzb);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzkx zzkxVar, boolean z, long j) {
        zzc().zza(zzb().elapsedRealtime());
        if (!zzp().zza(zzkxVar != null && zzkxVar.zzd, z, j) || zzkxVar == null) {
            return;
        }
        zzkxVar.zzd = false;
    }

    @Deprecated
    public final void zza(@NonNull Activity activity, @Size(max = 36, min = 1) String str, @Size(max = 36, min = 1) String str2) {
        if (!zze().zzv()) {
            zzj().zzv().zza("setCurrentScreen cannot be called while screen reporting is disabled.");
            return;
        }
        zzkx zzkxVar = this.zzb;
        if (zzkxVar == null) {
            zzj().zzv().zza("setCurrentScreen cannot be called while no activity active");
            return;
        }
        if (this.zzd.get(activity) == null) {
            zzj().zzv().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = zza(activity.getClass(), "Activity");
        }
        boolean zEquals = Objects.equals(zzkxVar.zzb, str2);
        boolean zEquals2 = Objects.equals(zzkxVar.zza, str);
        if (zEquals && zEquals2) {
            zzj().zzv().zza("setCurrentScreen cannot be called with the same class and name");
            return;
        }
        if (str != null && (str.length() <= 0 || str.length() > zze().zza((String) null, false))) {
            zzj().zzv().zza("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            return;
        }
        if (str2 != null && (str2.length() <= 0 || str2.length() > zze().zza((String) null, false))) {
            zzj().zzv().zza("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            return;
        }
        zzj().zzp().zza("Setting current screen to name, class", str == null ? BuildConfig.TRAVIS : str, str2);
        zzkx zzkxVar2 = new zzkx(str, str2, zzq().zzm());
        this.zzd.put(activity, zzkxVar2);
        zza(activity, zzkxVar2, true);
    }

    public final void zza(Bundle bundle, long j) {
        String str;
        synchronized (this.zzj) {
            if (!this.zzi) {
                zzj().zzv().zza("Cannot log screen view event when the app is in the background.");
                return;
            }
            String strZza = null;
            if (bundle != null) {
                String string = bundle.getString("screen_name");
                if (string != null && (string.length() <= 0 || string.length() > zze().zza((String) null, false))) {
                    zzj().zzv().zza("Invalid screen name length for screen view. Length", Integer.valueOf(string.length()));
                    return;
                }
                String string2 = bundle.getString(FirebaseAnalytics.Param.SCREEN_CLASS);
                if (string2 != null && (string2.length() <= 0 || string2.length() > zze().zza((String) null, false))) {
                    zzj().zzv().zza("Invalid screen class length for screen view. Length", Integer.valueOf(string2.length()));
                    return;
                } else {
                    str = string;
                    strZza = string2;
                }
            } else {
                str = null;
            }
            if (strZza == null) {
                Activity activity = this.zze;
                if (activity != null) {
                    strZza = zza(activity.getClass(), "Activity");
                } else {
                    strZza = "Activity";
                }
            }
            String str2 = strZza;
            zzkx zzkxVar = this.zzb;
            if (this.zzf && zzkxVar != null) {
                this.zzf = false;
                boolean zEquals = Objects.equals(zzkxVar.zzb, str2);
                boolean zEquals2 = Objects.equals(zzkxVar.zza, str);
                if (zEquals && zEquals2) {
                    zzj().zzv().zza("Ignoring call to log screen view event with duplicate parameters.");
                    return;
                }
            }
            zzj().zzp().zza("Logging screen view with name, class", str == null ? BuildConfig.TRAVIS : str, str2 == null ? BuildConfig.TRAVIS : str2);
            zzkx zzkxVar2 = this.zzb == null ? this.zzc : this.zzb;
            zzkx zzkxVar3 = new zzkx(str, str2, zzq().zzm(), true, j);
            this.zzb = zzkxVar3;
            this.zzc = zzkxVar2;
            this.zzg = zzkxVar3;
            zzl().zzb(new zzkz(this, bundle, zzkxVar3, zzkxVar2, zzb().elapsedRealtime()));
        }
    }
}
