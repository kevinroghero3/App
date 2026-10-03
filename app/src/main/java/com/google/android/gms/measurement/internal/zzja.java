package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.collection.ArrayMap;
import androidx.core.app.NotificationCompat;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.measurement.zzod;
import com.google.android.gms.internal.measurement.zzoo;
import com.google.android.gms.internal.measurement.zzpb;
import com.google.android.gms.internal.measurement.zzpg;
import com.google.android.gms.internal.measurement.zzpz;
import com.google.android.gms.internal.measurement.zzql;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import io.sentry.protocol.App;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import kotlin.Unit;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: loaded from: classes5.dex */
public final class zzja extends zzg {
    protected zzkm zza;
    final zzt zzb;
    private zziw zzc;
    private final Set<zziz> zzd;
    private boolean zze;
    private final AtomicReference<String> zzf;
    private final Object zzg;
    private boolean zzh;
    private int zzi;
    private zzav zzj;
    private PriorityQueue<zzmy> zzk;
    private zzis zzl;
    private final AtomicLong zzm;
    private long zzn;
    private boolean zzo;
    private zzav zzp;
    private SharedPreferences.OnSharedPreferenceChangeListener zzq;
    private zzav zzr;
    private final zzny zzs;

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

    public final Boolean zzaa() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzl().zza(atomicReference, 15000L, "boolean test flag value", new zzjn(this, atomicReference));
    }

    public final Double zzab() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzl().zza(atomicReference, 15000L, "double test flag value", new zzkj(this, atomicReference));
    }

    public final Integer zzac() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzl().zza(atomicReference, 15000L, "int test flag value", new zzkg(this, atomicReference));
    }

    public final Long zzad() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzl().zza(atomicReference, 15000L, "long test flag value", new zzkh(this, atomicReference));
    }

    public final String zzae() {
        return this.zzf.get();
    }

    public final String zzaf() {
        zzkx zzkxVarZzaa = this.zzu.zzq().zzaa();
        if (zzkxVarZzaa != null) {
            return zzkxVarZzaa.zzb;
        }
        return null;
    }

    public final String zzag() {
        zzkx zzkxVarZzaa = this.zzu.zzq().zzaa();
        if (zzkxVarZzaa != null) {
            return zzkxVarZzaa.zza;
        }
        return null;
    }

    public final String zzah() {
        if (this.zzu.zzu() != null) {
            return this.zzu.zzu();
        }
        try {
            return new zzhi(zza(), this.zzu.zzx()).zza("google_app_id");
        } catch (IllegalStateException e) {
            this.zzu.zzj().zzg().zza("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    public final String zzai() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzl().zza(atomicReference, 15000L, "String test flag value", new zzjw(this, atomicReference));
    }

    public final ArrayList<Bundle> zza(String str, String str2) {
        if (zzl().zzg()) {
            zzj().zzg().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        }
        if (zzad.zza()) {
            zzj().zzg().zza("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzu.zzl().zza(atomicReference, 5000L, "get conditional user properties", new zzkd(this, atomicReference, null, str, str2));
        List list = (List) atomicReference.get();
        if (list == null) {
            zzj().zzg().zza("Timed out waiting for get conditional user properties", null);
            return new ArrayList<>();
        }
        return zznw.zzb((List<zzac>) list);
    }

    public final List<zznv> zza(boolean z) {
        zzu();
        zzj().zzp().zza("Getting user properties (FE)");
        if (zzl().zzg()) {
            zzj().zzg().zza("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        }
        if (zzad.zza()) {
            zzj().zzg().zza("Cannot get all user properties from main thread");
            return Collections.emptyList();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzu.zzl().zza(atomicReference, 5000L, "get user properties", new zzjx(this, atomicReference, z));
        List<zznv> list = (List) atomicReference.get();
        if (list != null) {
            return list;
        }
        zzj().zzg().zza("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
        return Collections.emptyList();
    }

    public final Map<String, Object> zza(String str, String str2, boolean z) {
        if (zzl().zzg()) {
            zzj().zzg().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        if (zzad.zza()) {
            zzj().zzg().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzu.zzl().zza(atomicReference, 5000L, "get user properties", new zzkc(this, atomicReference, null, str, str2, z));
        List<zznv> list = (List) atomicReference.get();
        if (list == null) {
            zzj().zzg().zza("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyMap();
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zznv zznvVar : list) {
            Object objZza = zznvVar.zza();
            if (objZza != null) {
                arrayMap.put(zznvVar.zza, objZza);
            }
        }
        return arrayMap;
    }

    final PriorityQueue<zzmy> zzaj() {
        if (this.zzk == null) {
            this.zzk = new PriorityQueue<>(Comparator.comparing(new Function() { // from class: com.google.android.gms.measurement.internal.zzjd
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Long.valueOf(((zzmy) obj).zzb);
                }
            }, new Comparator() { // from class: com.google.android.gms.measurement.internal.zzjc
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return Long.compare(((Long) obj).longValue(), ((Long) obj2).longValue());
                }
            }));
        }
        return this.zzk;
    }

    static /* synthetic */ void zza(zzja zzjaVar, zzis zzisVar, zzis zzisVar2) {
        if (zzod.zza() && zzjaVar.zze().zza(zzbh.zzdf)) {
            return;
        }
        zzis.zza zzaVar = zzis.zza.ANALYTICS_STORAGE;
        zzis.zza zzaVar2 = zzis.zza.AD_STORAGE;
        boolean zZza = zzisVar.zza(zzisVar2, zzaVar, zzaVar2);
        boolean zZzb = zzisVar.zzb(zzisVar2, zzaVar, zzaVar2);
        if (zZza || zZzb) {
            zzjaVar.zzg().zzag();
        }
    }

    static /* synthetic */ void zza(zzja zzjaVar, zzis zzisVar, long j, boolean z, boolean z2) {
        zzjaVar.zzt();
        zzjaVar.zzu();
        zzis zzisVarZzn = zzjaVar.zzk().zzn();
        if (j <= zzjaVar.zzn && zzis.zza(zzisVarZzn.zza(), zzisVar.zza())) {
            zzjaVar.zzj().zzn().zza("Dropped out-of-date consent setting, proposed settings", zzisVar);
            return;
        }
        if (zzjaVar.zzk().zza(zzisVar)) {
            zzjaVar.zzn = j;
            if (zzjaVar.zze().zza(zzbh.zzcp) && zzjaVar.zzo().zzan()) {
                zzjaVar.zzo().zzb(z);
            } else {
                zzjaVar.zzo().zza(z);
            }
            if (z2) {
                zzjaVar.zzo().zza(new AtomicReference<>());
                return;
            }
            return;
        }
        zzjaVar.zzj().zzn().zza("Lower precedence consent source ignored, proposed source", Integer.valueOf(zzisVar.zza()));
    }

    static /* synthetic */ void zzb(zzja zzjaVar, int i) {
        if (zzjaVar.zzj == null) {
            zzjaVar.zzj = new zzjo(zzjaVar, zzjaVar.zzu);
        }
        zzjaVar.zzj.zza(i * 1000);
    }

    protected zzja(zzho zzhoVar) {
        super(zzhoVar);
        this.zzd = new CopyOnWriteArraySet();
        this.zzg = new Object();
        this.zzh = false;
        this.zzi = 1;
        this.zzo = true;
        this.zzs = new zzke(this);
        this.zzf = new AtomicReference<>();
        this.zzl = zzis.zza;
        this.zzn = -1L;
        this.zzm = new AtomicLong(0L);
        this.zzb = new zzt(zzhoVar);
    }

    public final void zzak() {
        zzt();
        zzu();
        if (this.zzu.zzaf()) {
            Boolean boolZzf = zze().zzf("google_analytics_deferred_deep_link_enabled");
            if (boolZzf != null && boolZzf.booleanValue()) {
                zzj().zzc().zza("Deferred Deep Link feature enabled.");
                zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjj
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzan();
                    }
                });
            }
            zzo().zzac();
            this.zzo = false;
            String strZzw = zzk().zzw();
            if (TextUtils.isEmpty(strZzw)) {
                return;
            }
            zzf().zzac();
            if (strZzw.equals(Build.VERSION.RELEASE)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", strZzw);
            zzc("auto", "_ou", bundle);
        }
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

    public final void zza(String str, String str2, Bundle bundle) {
        long jCurrentTimeMillis = zzb().currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, jCurrentTimeMillis);
        if (str2 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str2);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzl().zzb(new zzka(this, bundle2));
    }

    public final void zzal() {
        if (!(zza().getApplicationContext() instanceof Application) || this.zza == null) {
            return;
        }
        ((Application) zza().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
    }

    final void zzam() {
        if (zzpz.zza() && zze().zza(zzbh.zzch)) {
            if (zzl().zzg()) {
                zzj().zzg().zza("Cannot get trigger URIs from analytics worker thread");
                return;
            }
            if (zzad.zza()) {
                zzj().zzg().zza("Cannot get trigger URIs from main thread");
                return;
            }
            zzu();
            zzj().zzp().zza("Getting trigger URIs (FE)");
            final AtomicReference atomicReference = new AtomicReference();
            zzl().zza(atomicReference, 5000L, "get trigger URIs", new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjf
                @Override // java.lang.Runnable
                public final void run() {
                    zzja zzjaVar = this.zza;
                    AtomicReference<List<zzmy>> atomicReference2 = atomicReference;
                    Bundle bundleZza = zzjaVar.zzk().zzi.zza();
                    zzlf zzlfVarZzo = zzjaVar.zzo();
                    if (bundleZza == null) {
                        bundleZza = new Bundle();
                    }
                    zzlfVarZzo.zza(atomicReference2, bundleZza);
                }
            });
            final List list = (List) atomicReference.get();
            if (list == null) {
                zzj().zzg().zza("Timed out waiting for get trigger URIs");
            } else {
                zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzje
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zza(list);
                    }
                });
            }
        }
    }

    public final void zzan() {
        zzt();
        if (zzk().zzo.zza()) {
            zzj().zzc().zza("Deferred Deep Link already retrieved. Not fetching again.");
            return;
        }
        long jZza = zzk().zzp.zza();
        zzk().zzp.zza(1 + jZza);
        if (jZza >= 5) {
            zzj().zzu().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
            zzk().zzo.zza(true);
        } else {
            if (zzoo.zza() && zze().zza(zzbh.zzco)) {
                if (this.zzp == null) {
                    this.zzp = new zzjz(this, this.zzu);
                }
                this.zzp.zza(0L);
                return;
            }
            this.zzu.zzah();
        }
    }

    public final void zzao() {
        zzt();
        zzj().zzc().zza("Handle tcf update.");
        zzmw zzmwVarZza = zzmw.zza(zzk().zzc());
        zzj().zzp().zza("Tcf preferences read", zzmwVarZza);
        if (zzk().zza(zzmwVarZza)) {
            Bundle bundleZza = zzmwVarZza.zza();
            zzj().zzp().zza("Consent generated from Tcf", bundleZza);
            if (bundleZza != Bundle.EMPTY) {
                zza(bundleZza, -30, zzb().currentTimeMillis());
            }
            Bundle bundle = new Bundle();
            bundle.putString("_tcfd", zzmwVarZza.zzb());
            zzc("auto", "_tcf", bundle);
        }
    }

    final /* synthetic */ void zza(List list) {
        zzt();
        if (Build.VERSION.SDK_INT >= 30) {
            SparseArray<Long> sparseArrayZzh = zzk().zzh();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                zzmy zzmyVar = (zzmy) it2.next();
                if (!sparseArrayZzh.contains(zzmyVar.zzc) || sparseArrayZzh.get(zzmyVar.zzc).longValue() < zzmyVar.zzb) {
                    zzaj().add(zzmyVar);
                }
            }
            zzap();
        }
    }

    final /* synthetic */ void zza(SharedPreferences sharedPreferences, String str) {
        if ("IABTCF_TCString".equals(str)) {
            zzj().zzp().zza("IABTCF_TCString change picked up in listener.");
            ((zzav) Preconditions.checkNotNull(this.zzr)).zza(500L);
        }
    }

    final /* synthetic */ void zza(Bundle bundle) {
        if (bundle == null) {
            zzk().zzt.zza(new Bundle());
            return;
        }
        Bundle bundleZza = zzk().zzt.zza();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                zzq();
                if (zznw.zza(obj)) {
                    zzq();
                    zznw.zza(this.zzs, 27, (String) null, (String) null, 0);
                }
                zzj().zzv().zza("Invalid default event parameter type. Name, value", str, obj);
            } else if (zznw.zzg(str)) {
                zzj().zzv().zza("Invalid default event parameter name. Name", str);
            } else if (obj == null) {
                bundleZza.remove(str);
            } else if (zzq().zza("param", str, zze().zza((String) null, false), obj)) {
                zzq().zza(bundleZza, str, obj);
            }
        }
        zzq();
        if (zznw.zza(bundleZza, zze().zzg())) {
            zzq();
            zznw.zza(this.zzs, 26, (String) null, (String) null, 0);
            zzj().zzv().zza("Too many default event parameters set. Discarding beyond event parameter limit");
        }
        zzk().zzt.zza(bundleZza);
        zzo().zza(bundleZza);
    }

    public final void zzb(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, zzb().currentTimeMillis());
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        String str3 = str == null ? App.TYPE : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (Objects.equals(str2, FirebaseAnalytics.Event.SCREEN_VIEW)) {
            zzn().zza(bundle2, j);
        } else {
            zzb(str3, str2, j, bundle2, z2, !z2 || this.zzc == null || zznw.zzg(str2), z, null);
        }
    }

    public final void zza(String str, String str2, Bundle bundle, String str3) {
        zzs();
        zzb(str, str2, zzb().currentTimeMillis(), bundle, false, true, true, str3);
    }

    final void zzc(String str, String str2, Bundle bundle) {
        zzt();
        zza(str, str2, zzb().currentTimeMillis(), bundle);
    }

    final void zza(String str, String str2, long j, Bundle bundle) {
        zzt();
        zza(str, str2, j, bundle, true, this.zzc == null || zznw.zzg(str2), true, null);
    }

    /* JADX WARN: Code duplicated, block: B:54:0x013d  */
    protected final void zza(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        boolean zZza;
        long j2;
        int length;
        int i;
        Class<?> cls;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(bundle);
        zzt();
        zzu();
        if (!this.zzu.zzac()) {
            zzj().zzc().zza("Event not sent since app measurement is disabled");
            return;
        }
        List<String> listZzaf = zzg().zzaf();
        if (listZzaf != null && !listZzaf.contains(str2)) {
            zzj().zzc().zza("Dropping non-safelisted event. event name, origin", str2, str);
            return;
        }
        if (!this.zze) {
            this.zze = true;
            try {
                if (!this.zzu.zzag()) {
                    cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, zza().getClassLoader());
                } else {
                    cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
                }
                try {
                    cls.getDeclaredMethod("initialize", Context.class).invoke(null, zza());
                } catch (Exception e) {
                    zzj().zzu().zza("Failed to invoke Tag Manager's initialize() method", e);
                }
            } catch (ClassNotFoundException unused) {
                zzj().zzn().zza("Tag Manager is not found and thus will not be used");
            }
        }
        if (Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(str2)) {
            if (bundle.containsKey("gclid")) {
                zza("auto", "_lgclid", bundle.getString("gclid"), zzb().currentTimeMillis());
            }
            if (zzpg.zza() && zze().zza(zzbh.zzct) && bundle.containsKey("gbraid")) {
                zza("auto", "_gbraid", bundle.getString("gbraid"), zzb().currentTimeMillis());
            }
        }
        if (z && zznw.zzj(str2)) {
            zzq().zza(bundle, zzk().zzt.zza());
        }
        if (!z3 && !"_iap".equals(str2)) {
            zznw zznwVarZzt = this.zzu.zzt();
            if (!zznwVarZzt.zzc(NotificationCompat.CATEGORY_EVENT, str2)) {
                i = 2;
            } else if (!zznwVarZzt.zza(NotificationCompat.CATEGORY_EVENT, zziv.zza, zziv.zzb, str2)) {
                i = 13;
            } else if (zznwVarZzt.zza(NotificationCompat.CATEGORY_EVENT, 40, str2)) {
                i = 0;
            } else {
                i = 2;
            }
            if (i != 0) {
                zzj().zzh().zza("Invalid public event name. Event will not be logged (FE)", zzi().zza(str2));
                this.zzu.zzt();
                String strZza = zznw.zza(str2, 40, true);
                length = str2 != null ? str2.length() : 0;
                this.zzu.zzt();
                zznw.zza(this.zzs, i, "_ev", strZza, length);
                return;
            }
        }
        zzkx zzkxVarZza = zzn().zza(false);
        if (zzkxVarZza != null && !bundle.containsKey("_sc")) {
            zzkxVarZza.zzd = true;
        }
        zznw.zza(zzkxVarZza, bundle, z && !z3);
        boolean zEquals = "am".equals(str);
        boolean zZzg = zznw.zzg(str2);
        if (z && this.zzc != null && !zZzg && !zEquals) {
            zzj().zzc().zza("Passing event to registered event handler (FE)", zzi().zza(str2), zzi().zza(bundle));
            Preconditions.checkNotNull(this.zzc);
            this.zzc.interceptEvent(str, str2, bundle, j);
            return;
        }
        if (this.zzu.zzaf()) {
            int iZza = zzq().zza(str2);
            if (iZza != 0) {
                zzj().zzh().zza("Invalid event name. Event will not be logged (FE)", zzi().zza(str2));
                zzq();
                String strZza2 = zznw.zza(str2, 40, true);
                length = str2 != null ? str2.length() : 0;
                this.zzu.zzt();
                zznw.zza(this.zzs, str3, iZza, "_ev", strZza2, length);
                return;
            }
            Bundle bundleZza = zzq().zza(str3, str2, bundle, CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"}), z3);
            Preconditions.checkNotNull(bundleZza);
            if (zzn().zza(false) != null && "_ae".equals(str2)) {
                zzmv zzmvVar = zzp().zzb;
                long jElapsedRealtime = zzmvVar.zzb.zzb().elapsedRealtime();
                long j3 = jElapsedRealtime - zzmvVar.zza;
                zzmvVar.zza = jElapsedRealtime;
                if (j3 > 0) {
                    zzq().zza(bundleZza, j3);
                }
            }
            if (!"auto".equals(str) && "_ssr".equals(str2)) {
                zznw zznwVarZzq = zzq();
                String string = bundleZza.getString("_ffr");
                if (Strings.isEmptyOrWhitespace(string)) {
                    string = null;
                } else if (string != null) {
                    string = string.trim();
                }
                if (Objects.equals(string, zznwVarZzq.zzk().zzq.zza())) {
                    zznwVarZzq.zzj().zzc().zza("Not logging duplicate session_start_with_rollout event");
                    return;
                }
                zznwVarZzq.zzk().zzq.zza(string);
            } else if ("_ae".equals(str2)) {
                String strZza3 = zzq().zzk().zzq.zza();
                if (!TextUtils.isEmpty(strZza3)) {
                    bundleZza.putString("_ffr", strZza3);
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(bundleZza);
            if (zze().zza(zzbh.zzcn)) {
                zZza = zzp().zzaa();
            } else {
                zZza = zzk().zzn.zza();
            }
            if (zzk().zzk.zza() > 0 && zzk().zza(j) && zZza) {
                zzj().zzp().zza("Current session is expired, remove the session number, ID, and engagement time");
                j2 = 0;
                zza("auto", NotificationMessage.NOTIF_KEY_SID, (Object) null, zzb().currentTimeMillis());
                zza("auto", "_sno", (Object) null, zzb().currentTimeMillis());
                zza("auto", "_se", (Object) null, zzb().currentTimeMillis());
                zzk().zzl.zza(0L);
            } else {
                j2 = 0;
            }
            if (bundleZza.getLong(FirebaseAnalytics.Param.EXTEND_SESSION, j2) == 1) {
                zzj().zzp().zza("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                this.zzu.zzs().zza.zza(j, true);
            }
            ArrayList arrayList2 = new ArrayList(bundleZza.keySet());
            Collections.sort(arrayList2);
            int size = arrayList2.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList2.get(i2);
                i2++;
                String str4 = (String) obj;
                if (str4 != null) {
                    zzq();
                    Bundle[] bundleArrZzb = zznw.zzb(bundleZza.get(str4));
                    if (bundleArrZzb != null) {
                        bundleZza.putParcelableArray(str4, bundleArrZzb);
                    }
                }
            }
            int i3 = 0;
            while (i3 < arrayList.size()) {
                Bundle bundleZza2 = (Bundle) arrayList.get(i3);
                String str5 = i3 != 0 ? "_ep" : str2;
                bundleZza2.putString("_o", str);
                if (z2) {
                    bundleZza2 = zzq().zza(bundleZza2, (String) null);
                }
                Bundle bundle2 = bundleZza2;
                zzo().zza(new zzbf(str5, new zzba(bundle2), str, j), str3);
                if (!zEquals) {
                    Iterator<zziz> it2 = this.zzd.iterator();
                    while (it2.hasNext()) {
                        it2.next().onEvent(str, str2, new Bundle(bundle2), j);
                    }
                }
                i3++;
            }
            if (zzn().zza(false) == null || !"_ae".equals(str2)) {
                return;
            }
            zzp().zza(true, true, zzb().elapsedRealtime());
        }
    }

    final void zzap() {
        zzmy zzmyVarPoll;
        MeasurementManagerFutures measurementManagerFuturesZzn;
        zzt();
        if (zzaj().isEmpty() || this.zzh || (zzmyVarPoll = zzaj().poll()) == null || (measurementManagerFuturesZzn = zzq().zzn()) == null) {
            return;
        }
        this.zzh = true;
        zzj().zzp().zza("Registering trigger URI", zzmyVarPoll.zza);
        ListenableFuture<Unit> listenableFutureRegisterTriggerAsync = measurementManagerFuturesZzn.registerTriggerAsync(Uri.parse(zzmyVarPoll.zza));
        if (listenableFutureRegisterTriggerAsync == null) {
            this.zzh = false;
            zzaj().add(zzmyVarPoll);
            return;
        }
        if (!zze().zza(zzbh.zzcl)) {
            SparseArray<Long> sparseArrayZzh = zzk().zzh();
            sparseArrayZzh.put(zzmyVarPoll.zzc, Long.valueOf(zzmyVarPoll.zzb));
            zzk().zza(sparseArrayZzh);
        }
        Futures.addCallback(listenableFutureRegisterTriggerAsync, new zzjp(this, zzmyVarPoll), new zzjm(this));
    }

    public final void zza(zziz zzizVar) {
        zzu();
        Preconditions.checkNotNull(zzizVar);
        if (this.zzd.add(zzizVar)) {
            return;
        }
        zzj().zzu().zza("OnEventListener already registered");
    }

    public final void zzaq() {
        zzt();
        zzj().zzc().zza("Register tcfPrefChangeListener.");
        if (this.zzq == null) {
            this.zzr = new zzjs(this, this.zzu);
            this.zzq = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.measurement.internal.zzji
                @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                    this.zza.zza(sharedPreferences, str);
                }
            };
        }
        zzk().zzc().registerOnSharedPreferenceChangeListener(this.zzq);
    }

    final void zza(long j, boolean z) {
        zzt();
        zzu();
        zzj().zzc().zza("Resetting analytics data (FE)");
        zzmp zzmpVarZzp = zzp();
        zzmpVarZzp.zzt();
        zzmpVarZzp.zzb.zza();
        if (zzql.zza() && zze().zza(zzbh.zzbr)) {
            zzg().zzag();
        }
        boolean zZzac = this.zzu.zzac();
        zzgm zzgmVarZzk = zzk();
        zzgmVarZzk.zzc.zza(j);
        if (!TextUtils.isEmpty(zzgmVarZzk.zzk().zzq.zza())) {
            zzgmVarZzk.zzq.zza(null);
        }
        if (zzpb.zza() && zzgmVarZzk.zze().zza(zzbh.zzbm)) {
            zzgmVarZzk.zzk.zza(0L);
        }
        zzgmVarZzk.zzl.zza(0L);
        if (!zzgmVarZzk.zze().zzw()) {
            zzgmVarZzk.zzb(!zZzac);
        }
        zzgmVarZzk.zzr.zza(null);
        zzgmVarZzk.zzs.zza(0L);
        zzgmVarZzk.zzt.zza(null);
        if (z) {
            zzo().zzah();
        }
        if (zzpb.zza() && zze().zza(zzbh.zzbm)) {
            zzp().zza.zza();
        }
        this.zzo = !zZzac;
    }

    private final void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzl().zzb(new zzjv(this, str, str2, j, zznw.zza(bundle), z, z2, z3, str3));
    }

    private final void zza(String str, String str2, long j, Object obj) {
        zzl().zzb(new zzju(this, str, str2, obj, j));
    }

    final void zza(String str) {
        this.zzf.set(str);
    }

    public final void zzb(Bundle bundle) {
        zza(bundle, zzb().currentTimeMillis());
    }

    public final void zza(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            zzj().zzu().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        Preconditions.checkNotNull(bundle2);
        zzip.zza(bundle2, "app_id", String.class, null);
        zzip.zza(bundle2, "origin", String.class, null);
        zzip.zza(bundle2, "name", String.class, null);
        zzip.zza(bundle2, "value", Object.class, null);
        zzip.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzip.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzip.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzip.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzip.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzip.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzip.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzip.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzip.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        if (zzq().zzb(string) != 0) {
            zzj().zzg().zza("Invalid conditional user property name", zzi().zzc(string));
            return;
        }
        if (zzq().zza(string, obj) != 0) {
            zzj().zzg().zza("Invalid conditional user property value", zzi().zzc(string), obj);
            return;
        }
        Object objZzc = zzq().zzc(string, obj);
        if (objZzc == null) {
            zzj().zzg().zza("Unable to normalize conditional user property value", zzi().zzc(string), obj);
            return;
        }
        zzip.zza(bundle2, objZzc);
        long j2 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
        if (!TextUtils.isEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME)) && (j2 > 15552000000L || j2 < 1)) {
            zzj().zzg().zza("Invalid conditional user property timeout", zzi().zzc(string), Long.valueOf(j2));
            return;
        }
        long j3 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
        if (j3 > 15552000000L || j3 < 1) {
            zzj().zzg().zza("Invalid conditional user property time to live", zzi().zzc(string), Long.valueOf(j3));
        } else {
            zzl().zzb(new zzkb(this, bundle2));
        }
    }

    final void zza(Bundle bundle, int i, long j) {
        String str;
        zzu();
        String strZza = zzis.zza(bundle);
        if (strZza != null) {
            zzj().zzv().zza("Ignoring invalid consent setting", strZza);
            zzj().zzv().zza("Valid consent values are 'granted', 'denied'");
        }
        boolean z = zze().zza(zzbh.zzcq) && zzl().zzg();
        zzis zzisVarZza = zzis.zza(bundle, i);
        if (zzisVarZza.zzk()) {
            zza(zzisVarZza, j, z);
        }
        zzax zzaxVarZza = zzax.zza(bundle, i);
        if (zzaxVarZza.zzg()) {
            zza(zzaxVarZza, z);
        }
        Boolean boolZza = zzax.zza(bundle);
        if (boolZza != null) {
            if (i == -30) {
                str = "tcf";
            } else {
                str = App.TYPE;
            }
            zza(str, FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS, (Object) boolZza.toString(), false);
        }
    }

    public final void zza(zzis zzisVar, long j, boolean z) {
        zzis zzisVar2;
        boolean z2;
        boolean zZzc;
        boolean z3;
        zzis zzisVarZzb = zzisVar;
        zzu();
        int iZza = zzisVar.zza();
        if (com.google.android.gms.internal.measurement.zznx.zza() && zze().zza(zzbh.zzda)) {
            if (iZza != -10) {
                zzir zzirVarZzc = zzisVar.zzc();
                zzir zzirVar = zzir.UNINITIALIZED;
                if (zzirVarZzc == zzirVar && zzisVar.zzd() == zzirVar) {
                    zzj().zzv().zza("Ignoring empty consent settings");
                    return;
                }
            }
        } else if (iZza != -10 && zzisVar.zze() == null && zzisVar.zzf() == null) {
            zzj().zzv().zza("Discarding empty consent settings");
            return;
        }
        synchronized (this.zzg) {
            zzisVar2 = this.zzl;
            z2 = false;
            if (zzis.zza(iZza, zzisVar2.zza())) {
                zZzc = zzisVar.zzc(this.zzl);
                if (zzisVar.zzj() && !this.zzl.zzj()) {
                    z2 = true;
                }
                zzisVarZzb = zzisVar.zzb(this.zzl);
                this.zzl = zzisVarZzb;
                z3 = z2;
                z2 = true;
            } else {
                zZzc = false;
                z3 = false;
            }
        }
        if (!z2) {
            zzj().zzn().zza("Ignoring lower-priority consent settings, proposed settings", zzisVarZzb);
            return;
        }
        long andIncrement = this.zzm.getAndIncrement();
        if (zZzc) {
            zza((String) null);
            zzkk zzkkVar = new zzkk(this, zzisVarZzb, j, andIncrement, z3, zzisVar2);
            if (z) {
                zzt();
                zzkkVar.run();
                return;
            } else {
                zzl().zzc(zzkkVar);
                return;
            }
        }
        zzkn zzknVar = new zzkn(this, zzisVarZzb, andIncrement, z3, zzisVar2);
        if (z) {
            zzt();
            zzknVar.run();
        } else if (iZza == 30 || iZza == -10) {
            zzl().zzc(zzknVar);
        } else {
            zzl().zzb(zzknVar);
        }
    }

    final void zza(zzax zzaxVar, boolean z) {
        zzkl zzklVar = new zzkl(this, zzaxVar);
        if (z) {
            zzt();
            zzklVar.run();
        } else {
            zzl().zzb(zzklVar);
        }
    }

    public final void zza(zziw zziwVar) {
        zziw zziwVar2;
        zzt();
        zzu();
        if (zziwVar != null && zziwVar != (zziwVar2 = this.zzc)) {
            Preconditions.checkState(zziwVar2 == null, "EventInterceptor already set.");
        }
        this.zzc = zziwVar;
    }

    public final void zza(Boolean bool) {
        zzu();
        zzl().zzb(new zzki(this, bool));
    }

    final void zza(zzis zzisVar) {
        zzt();
        boolean z = (zzisVar.zzj() && zzisVar.zzi()) || zzo().zzam();
        if (z != this.zzu.zzad()) {
            this.zzu.zzb(z);
            Boolean boolZzu = zzk().zzu();
            if (!z || boolZzu == null || boolZzu.booleanValue()) {
                zza(Boolean.valueOf(z), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(Boolean bool, boolean z) {
        zzt();
        zzu();
        zzj().zzc().zza("Setting app measurement enabled (FE)", bool);
        zzk().zza(bool);
        if (z) {
            zzk().zzb(bool);
        }
        if (this.zzu.zzad() || !(bool == null || bool.booleanValue())) {
            zzar();
        }
    }

    public final void zza(String str, String str2, Object obj, boolean z) {
        zza(str, str2, obj, z, zzb().currentTimeMillis());
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0031  */
    public final void zza(String str, String str2, Object obj, boolean z, long j) {
        int iZzb;
        int length;
        if (str == null) {
            str = App.TYPE;
        }
        String str3 = str;
        if (z) {
            iZzb = zzq().zzb(str2);
        } else {
            zznw zznwVarZzq = zzq();
            if (!zznwVarZzq.zzc("user property", str2)) {
                iZzb = 6;
            } else if (!zznwVarZzq.zza("user property", zzix.zza, str2)) {
                iZzb = 15;
            } else if (zznwVarZzq.zza("user property", 24, str2)) {
                iZzb = 0;
            } else {
                iZzb = 6;
            }
        }
        if (iZzb != 0) {
            zzq();
            String strZza = zznw.zza(str2, 24, true);
            length = str2 != null ? str2.length() : 0;
            this.zzu.zzt();
            zznw.zza(this.zzs, iZzb, "_ev", strZza, length);
            return;
        }
        if (obj != null) {
            int iZza = zzq().zza(str2, obj);
            if (iZza != 0) {
                zzq();
                String strZza2 = zznw.zza(str2, 24, true);
                length = ((obj instanceof String) || (obj instanceof CharSequence)) ? String.valueOf(obj).length() : 0;
                this.zzu.zzt();
                zznw.zza(this.zzs, iZza, "_ev", strZza2, length);
                return;
            }
            Object objZzc = zzq().zzc(str2, obj);
            if (objZzc != null) {
                zza(str3, str2, j, objZzc);
                return;
            }
            return;
        }
        zza(str3, str2, j, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0050  */
    final void zza(String str, String str2, Object obj, long j) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzu();
        if (FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS.equals(str2)) {
            if (obj instanceof String) {
                String str3 = (String) obj;
                if (!TextUtils.isEmpty(str3)) {
                    String lowerCase = str3.toLowerCase(Locale.ENGLISH);
                    String str4 = com.facebook.hermes.intl.Constants.CASEFIRST_FALSE;
                    Long lValueOf = Long.valueOf(com.facebook.hermes.intl.Constants.CASEFIRST_FALSE.equals(lowerCase) ? 1L : 0L);
                    zzgs zzgsVar = zzk().zzh;
                    if (lValueOf.longValue() == 1) {
                        str4 = "true";
                    }
                    zzgsVar.zza(str4);
                    obj = lValueOf;
                } else if (obj == null) {
                    zzk().zzh.zza("unset");
                }
                str2 = "_npa";
            } else if (obj == null) {
                zzk().zzh.zza("unset");
                str2 = "_npa";
            }
        }
        String str5 = str2;
        Object obj2 = obj;
        if (!this.zzu.zzac()) {
            zzj().zzp().zza("User property not set since app measurement is disabled");
        } else if (this.zzu.zzaf()) {
            zzo().zza(new zznv(str5, j, obj2, str));
        }
    }

    public final void zzb(zziz zzizVar) {
        zzu();
        Preconditions.checkNotNull(zzizVar);
        if (this.zzd.remove(zzizVar)) {
            return;
        }
        zzj().zzu().zza("OnEventListener had not been registered");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzar() {
        zzt();
        String strZza = zzk().zzh.zza();
        if (strZza != null) {
            if ("unset".equals(strZza)) {
                zza(App.TYPE, "_npa", (Object) null, zzb().currentTimeMillis());
            } else {
                zza(App.TYPE, "_npa", Long.valueOf("true".equals(strZza) ? 1L : 0L), zzb().currentTimeMillis());
            }
        }
        if (this.zzu.zzac() && this.zzo) {
            zzj().zzc().zza("Recording app launch after enabling measurement for the first time (FE)");
            zzak();
            if (zzpb.zza() && zze().zza(zzbh.zzbm)) {
                zzp().zza.zza();
            }
            zzl().zzb(new zzjq(this));
            return;
        }
        zzj().zzc().zza("Updating Scion state (FE)");
        zzo().zzaj();
    }
}
