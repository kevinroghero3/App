package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.collection.LruCache;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.sentry.ProfilingTraceData;
import io.sentry.SentryLockReason;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: loaded from: classes5.dex */
public final class zzgy extends zznf implements zzag {
    final LruCache<String, com.google.android.gms.internal.measurement.zzb> zza;
    final com.google.android.gms.internal.measurement.zzv zzb;
    private final Map<String, Map<String, String>> zzc;
    private final Map<String, Set<String>> zzd;
    private final Map<String, Map<String, Boolean>> zze;
    private final Map<String, Map<String, Boolean>> zzg;
    private final Map<String, com.google.android.gms.internal.measurement.zzfl.zzd> zzh;
    private final Map<String, Map<String, Integer>> zzi;
    private final Map<String, String> zzj;
    private final Map<String, String> zzk;
    private final Map<String, String> zzl;

    final int zzb(String str, String str2) throws Throwable {
        Integer num;
        zzt();
        zzv(str);
        Map<String, Integer> map = this.zzi.get(str);
        if (map == null || (num = map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    @Override // com.google.android.gms.measurement.internal.zznf
    protected final boolean zzc() {
        return false;
    }

    final long zza(String str) throws Throwable {
        String strZza = zza(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(strZza)) {
            return 0L;
        }
        try {
            return Long.parseLong(strZza);
        } catch (NumberFormatException e) {
            zzj().zzu().zza("Unable to parse timezone offset. appId", zzgb.zza(str), e);
            return 0L;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzio, com.google.android.gms.measurement.internal.zziq
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    static /* synthetic */ com.google.android.gms.internal.measurement.zzb zza(zzgy zzgyVar, String str) throws Throwable {
        zzgyVar.zzak();
        Preconditions.checkNotEmpty(str);
        if (!zzgyVar.zzl(str)) {
            return null;
        }
        if (zzgyVar.zzh.containsKey(str) && zzgyVar.zzh.get(str) != null) {
            zzgyVar.zza(str, zzgyVar.zzh.get(str));
        } else {
            zzgyVar.zzv(str);
        }
        return zzgyVar.zza.snapshot().get(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzio, com.google.android.gms.measurement.internal.zziq
    @Pure
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zznc
    public final /* bridge */ /* synthetic */ zzs zzg() {
        return super.zzg();
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

    @Override // com.google.android.gms.measurement.internal.zznc
    public final /* bridge */ /* synthetic */ zzan zzh() {
        return super.zzh();
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

    @Override // com.google.android.gms.measurement.internal.zznc
    public final /* bridge */ /* synthetic */ zzgy zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzio, com.google.android.gms.measurement.internal.zziq
    @Pure
    public final /* bridge */ /* synthetic */ zzhh zzl() {
        return super.zzl();
    }

    final zzir zza(String str, zzis.zza zzaVar) {
        zzt();
        zzv(str);
        com.google.android.gms.internal.measurement.zzfl.zza zzaVarZzb = zzb(str);
        if (zzaVarZzb == null) {
            return zzir.UNINITIALIZED;
        }
        for (com.google.android.gms.internal.measurement.zzfl.zza.C0030zza c0030zza : zzaVarZzb.zzf()) {
            if (zza(c0030zza.zzc()) == zzaVar) {
                int i = zzhf.zzc[c0030zza.zzb().ordinal()];
                if (i == 1) {
                    return zzir.DENIED;
                }
                if (i == 2) {
                    return zzir.GRANTED;
                }
                return zzir.UNINITIALIZED;
            }
        }
        return zzir.UNINITIALIZED;
    }

    final zzis.zza zzb(String str, zzis.zza zzaVar) {
        zzt();
        zzv(str);
        com.google.android.gms.internal.measurement.zzfl.zza zzaVarZzb = zzb(str);
        if (zzaVarZzb == null) {
            return null;
        }
        for (com.google.android.gms.internal.measurement.zzfl.zza.zzc zzcVar : zzaVarZzb.zze()) {
            if (zzaVar == zza(zzcVar.zzc())) {
                return zza(zzcVar.zzb());
            }
        }
        return null;
    }

    private static zzis.zza zza(com.google.android.gms.internal.measurement.zzfl.zza.zze zzeVar) {
        int i = zzhf.zzb[zzeVar.ordinal()];
        if (i == 1) {
            return zzis.zza.AD_STORAGE;
        }
        if (i == 2) {
            return zzis.zza.ANALYTICS_STORAGE;
        }
        if (i == 3) {
            return zzis.zza.AD_USER_DATA;
        }
        if (i != 4) {
            return null;
        }
        return zzis.zza.AD_PERSONALIZATION;
    }

    @Override // com.google.android.gms.measurement.internal.zznc
    public final /* bridge */ /* synthetic */ zzmg zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zznc
    public final /* bridge */ /* synthetic */ zzne zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zznc
    public final /* bridge */ /* synthetic */ zznt g_() {
        return super.g_();
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    @Pure
    public final /* bridge */ /* synthetic */ zznw zzq() {
        return super.zzq();
    }

    final com.google.android.gms.internal.measurement.zzfl.zza zzb(String str) throws Throwable {
        zzt();
        zzv(str);
        com.google.android.gms.internal.measurement.zzfl.zzd zzdVarZzc = zzc(str);
        if (zzdVarZzc == null || !zzdVarZzc.zzp()) {
            return null;
        }
        return zzdVarZzc.zzd();
    }

    protected final com.google.android.gms.internal.measurement.zzfl.zzd zzc(String str) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        zzv(str);
        return this.zzh.get(str);
    }

    private final com.google.android.gms.internal.measurement.zzfl.zzd zza(String str, byte[] bArr) {
        if (bArr == null) {
            return com.google.android.gms.internal.measurement.zzfl.zzd.zzg();
        }
        try {
            com.google.android.gms.internal.measurement.zzfl.zzd zzdVar = (com.google.android.gms.internal.measurement.zzfl.zzd) ((com.google.android.gms.internal.measurement.zzju) ((com.google.android.gms.internal.measurement.zzfl.zzd.zza) zznt.zza(com.google.android.gms.internal.measurement.zzfl.zzd.zze(), bArr)).zzah());
            zzj().zzp().zza("Parsed config. version, gmp_app_id", zzdVar.zzs() ? Long.valueOf(zzdVar.zzc()) : null, zzdVar.zzq() ? zzdVar.zzi() : null);
            return zzdVar;
        } catch (com.google.android.gms.internal.measurement.zzkc e) {
            zzj().zzu().zza("Unable to merge remote config. appId", zzgb.zza(str), e);
            return com.google.android.gms.internal.measurement.zzfl.zzd.zzg();
        } catch (RuntimeException e2) {
            zzj().zzu().zza("Unable to merge remote config. appId", zzgb.zza(str), e2);
            return com.google.android.gms.internal.measurement.zzfl.zzd.zzg();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzag
    public final String zza(String str, String str2) throws Throwable {
        zzt();
        zzv(str);
        Map<String, String> map = this.zzc.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    protected final String zzd(String str) {
        zzt();
        return this.zzl.get(str);
    }

    protected final String zze(String str) {
        zzt();
        return this.zzk.get(str);
    }

    final String zzf(String str) throws Throwable {
        zzt();
        zzv(str);
        return this.zzj.get(str);
    }

    private static Map<String, String> zza(com.google.android.gms.internal.measurement.zzfl.zzd zzdVar) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzdVar != null) {
            for (com.google.android.gms.internal.measurement.zzfl.zzg zzgVar : zzdVar.zzn()) {
                arrayMap.put(zzgVar.zzb(), zzgVar.zzc());
            }
        }
        return arrayMap;
    }

    final Set<String> zzg(String str) {
        zzt();
        zzv(str);
        return this.zzd.get(str);
    }

    final SortedSet<String> zzh(String str) {
        zzt();
        zzv(str);
        TreeSet treeSet = new TreeSet();
        com.google.android.gms.internal.measurement.zzfl.zza zzaVarZzb = zzb(str);
        if (zzaVarZzb == null) {
            return treeSet;
        }
        Iterator<com.google.android.gms.internal.measurement.zzfl.zza.zzf> it2 = zzaVarZzb.zzc().iterator();
        while (it2.hasNext()) {
            treeSet.add(it2.next().zzb());
        }
        return treeSet;
    }

    zzgy(zzng zzngVar) {
        super(zzngVar);
        this.zzc = new ArrayMap();
        this.zzd = new ArrayMap();
        this.zze = new ArrayMap();
        this.zzg = new ArrayMap();
        this.zzh = new ArrayMap();
        this.zzj = new ArrayMap();
        this.zzk = new ArrayMap();
        this.zzl = new ArrayMap();
        this.zzi = new ArrayMap();
        this.zza = new zzhe(this, 20);
        this.zzb = new zzhd(this);
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

    protected final void zzi(String str) {
        zzt();
        this.zzk.put(str, null);
    }

    private final void zza(String str, com.google.android.gms.internal.measurement.zzfl.zzd.zza zzaVar) {
        HashSet hashSet = new HashSet();
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (zzaVar != null) {
            Iterator<com.google.android.gms.internal.measurement.zzfl.zzb> it2 = zzaVar.zze().iterator();
            while (it2.hasNext()) {
                hashSet.add(it2.next().zzb());
            }
            for (int i = 0; i < zzaVar.zza(); i++) {
                com.google.android.gms.internal.measurement.zzfl.zzc.zza zzaVarZzca = zzaVar.zza(i).zzca();
                if (zzaVarZzca.zzb().isEmpty()) {
                    zzj().zzu().zza("EventConfig contained null event name");
                } else {
                    String strZzb = zzaVarZzca.zzb();
                    String strZzb2 = zziv.zzb(zzaVarZzca.zzb());
                    if (!TextUtils.isEmpty(strZzb2)) {
                        zzaVarZzca = zzaVarZzca.zza(strZzb2);
                        zzaVar.zza(i, zzaVarZzca);
                    }
                    if (zzaVarZzca.zze() && zzaVarZzca.zzc()) {
                        arrayMap.put(strZzb, Boolean.TRUE);
                    }
                    if (zzaVarZzca.zzf() && zzaVarZzca.zzd()) {
                        arrayMap2.put(zzaVarZzca.zzb(), Boolean.TRUE);
                    }
                    if (zzaVarZzca.zzg()) {
                        if (zzaVarZzca.zza() < 2 || zzaVarZzca.zza() > 65535) {
                            zzj().zzu().zza("Invalid sampling rate. Event name, sample rate", zzaVarZzca.zzb(), Integer.valueOf(zzaVarZzca.zza()));
                        } else {
                            arrayMap3.put(zzaVarZzca.zzb(), Integer.valueOf(zzaVarZzca.zza()));
                        }
                    }
                }
            }
        }
        this.zzd.put(str, hashSet);
        this.zze.put(str, arrayMap);
        this.zzg.put(str, arrayMap2);
        this.zzi.put(str, arrayMap3);
    }

    private final void zzv(String str) throws Throwable {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        if (this.zzh.get(str) == null) {
            zzap zzapVarZzf = zzh().zzf(str);
            if (zzapVarZzf == null) {
                this.zzc.put(str, null);
                this.zze.put(str, null);
                this.zzd.put(str, null);
                this.zzg.put(str, null);
                this.zzh.put(str, null);
                this.zzj.put(str, null);
                this.zzk.put(str, null);
                this.zzl.put(str, null);
                this.zzi.put(str, null);
                return;
            }
            com.google.android.gms.internal.measurement.zzfl.zzd.zza zzaVarZzca = zza(str, zzapVarZzf.zza).zzca();
            zza(str, zzaVarZzca);
            this.zzc.put(str, zza((com.google.android.gms.internal.measurement.zzfl.zzd) ((com.google.android.gms.internal.measurement.zzju) zzaVarZzca.zzah())));
            this.zzh.put(str, (com.google.android.gms.internal.measurement.zzfl.zzd) ((com.google.android.gms.internal.measurement.zzju) zzaVarZzca.zzah()));
            zza(str, (com.google.android.gms.internal.measurement.zzfl.zzd) ((com.google.android.gms.internal.measurement.zzju) zzaVarZzca.zzah()));
            this.zzj.put(str, zzaVarZzca.zzc());
            this.zzk.put(str, zzapVarZzf.zzb);
            this.zzl.put(str, zzapVarZzf.zzc);
        }
    }

    private final void zza(final String str, com.google.android.gms.internal.measurement.zzfl.zzd zzdVar) {
        if (zzdVar.zza() == 0) {
            this.zza.remove(str);
            return;
        }
        zzj().zzp().zza("EES programs found", Integer.valueOf(zzdVar.zza()));
        com.google.android.gms.internal.measurement.zzgc.zzc zzcVar = zzdVar.zzm().get(0);
        try {
            com.google.android.gms.internal.measurement.zzb zzbVar = new com.google.android.gms.internal.measurement.zzb();
            zzbVar.zza("internal.remoteConfig", new Callable() { // from class: com.google.android.gms.measurement.internal.zzgz
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new com.google.android.gms.internal.measurement.zzm("internal.remoteConfig", new zzhg(this.zza, str));
                }
            });
            zzbVar.zza("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.zzhc
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    final zzgy zzgyVar = this.zza;
                    final String str2 = str;
                    return new com.google.android.gms.internal.measurement.zzx("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.zzha
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            zzgy zzgyVar2 = zzgyVar;
                            String str3 = str2;
                            zzf zzfVarZze = zzgyVar2.zzh().zze(str3);
                            HashMap map = new HashMap();
                            map.put("platform", "android");
                            map.put(SentryLockReason.JsonKeys.PACKAGE_NAME, str3);
                            map.put("gmp_version", 88000L);
                            if (zzfVarZze != null) {
                                String strZzaf = zzfVarZze.zzaf();
                                if (strZzaf != null) {
                                    map.put("app_version", strZzaf);
                                }
                                map.put("app_version_int", Long.valueOf(zzfVarZze.zze()));
                                map.put("dynamite_version", Long.valueOf(zzfVarZze.zzo()));
                            }
                            return map;
                        }
                    });
                }
            });
            zzbVar.zza("internal.logger", new Callable() { // from class: com.google.android.gms.measurement.internal.zzhb
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new com.google.android.gms.internal.measurement.zzr(this.zza.zzb);
                }
            });
            zzbVar.zza(zzcVar);
            this.zza.put(str, zzbVar);
            zzj().zzp().zza("EES program loaded for appId, activities", str, Integer.valueOf(zzcVar.zza().zza()));
            Iterator<com.google.android.gms.internal.measurement.zzgc.zzb> it2 = zzcVar.zza().zzd().iterator();
            while (it2.hasNext()) {
                zzj().zzp().zza("EES program activity", it2.next().zzb());
            }
        } catch (com.google.android.gms.internal.measurement.zzc unused) {
            zzj().zzg().zza("Failed to load EES program. appId", str);
        }
    }

    final void zzj(String str) {
        zzt();
        this.zzh.remove(str);
    }

    final boolean zzk(String str) {
        zzt();
        com.google.android.gms.internal.measurement.zzfl.zzd zzdVarZzc = zzc(str);
        if (zzdVarZzc == null) {
            return false;
        }
        return zzdVarZzc.zzo();
    }

    public final boolean zzl(String str) {
        com.google.android.gms.internal.measurement.zzfl.zzd zzdVar;
        return (TextUtils.isEmpty(str) || (zzdVar = this.zzh.get(str)) == null || zzdVar.zza() == 0) ? false : true;
    }

    final boolean zzm(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(zza(str, "measurement.upload.blacklist_internal"));
    }

    final boolean zzc(String str, zzis.zza zzaVar) throws Throwable {
        zzt();
        zzv(str);
        com.google.android.gms.internal.measurement.zzfl.zza zzaVarZzb = zzb(str);
        if (zzaVarZzb == null) {
            return false;
        }
        for (com.google.android.gms.internal.measurement.zzfl.zza.C0030zza c0030zza : zzaVarZzb.zzd()) {
            if (zzaVar == zza(c0030zza.zzc())) {
                if (c0030zza.zzb() == com.google.android.gms.internal.measurement.zzfl.zza.zzd.GRANTED) {
                    return true;
                }
            }
        }
        return false;
    }

    final boolean zzn(String str) {
        zzt();
        zzv(str);
        com.google.android.gms.internal.measurement.zzfl.zza zzaVarZzb = zzb(str);
        return zzaVarZzb == null || !zzaVarZzb.zzh() || zzaVarZzb.zzg();
    }

    final boolean zzc(String str, String str2) throws Throwable {
        Boolean bool;
        zzt();
        zzv(str);
        if ("ecommerce_purchase".equals(str2) || FirebaseAnalytics.Event.PURCHASE.equals(str2) || FirebaseAnalytics.Event.REFUND.equals(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.zzg.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    final boolean zzd(String str, String str2) throws Throwable {
        Boolean bool;
        zzt();
        zzv(str);
        if (zzm(str) && zznw.zzg(str2)) {
            return true;
        }
        if (zzo(str) && zznw.zzh(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.zze.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    final boolean zzo(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(zza(str, "measurement.upload.blacklist_public"));
    }

    protected final boolean zza(String str, byte[] bArr, String str2, String str3) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        com.google.android.gms.internal.measurement.zzfl.zzd.zza zzaVarZzca = zza(str, bArr).zzca();
        if (zzaVarZzca == null) {
            return false;
        }
        zza(str, zzaVarZzca);
        zza(str, (com.google.android.gms.internal.measurement.zzfl.zzd) ((com.google.android.gms.internal.measurement.zzju) zzaVarZzca.zzah()));
        this.zzh.put(str, (com.google.android.gms.internal.measurement.zzfl.zzd) ((com.google.android.gms.internal.measurement.zzju) zzaVarZzca.zzah()));
        this.zzj.put(str, zzaVarZzca.zzc());
        this.zzk.put(str, str2);
        this.zzl.put(str, str3);
        this.zzc.put(str, zza((com.google.android.gms.internal.measurement.zzfl.zzd) ((com.google.android.gms.internal.measurement.zzju) zzaVarZzca.zzah())));
        zzh().zza(str, new ArrayList(zzaVarZzca.zzd()));
        try {
            zzaVarZzca.zzb();
            bArr = ((com.google.android.gms.internal.measurement.zzfl.zzd) ((com.google.android.gms.internal.measurement.zzju) zzaVarZzca.zzah())).zzbx();
        } catch (RuntimeException e) {
            zzj().zzu().zza("Unable to serialize reduced-size config. Storing full config instead. appId", zzgb.zza(str), e);
        }
        zzan zzanVarZzh = zzh();
        Preconditions.checkNotEmpty(str);
        zzanVarZzh.zzt();
        zzanVarZzh.zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        contentValues.put("config_last_modified_time", str2);
        contentValues.put("e_tag", str3);
        try {
            if (zzanVarZzh.e_().update("apps", contentValues, "app_id = ?", new String[]{str}) == 0) {
                zzanVarZzh.zzj().zzg().zza("Failed to update remote config (got 0). appId", zzgb.zza(str));
            }
        } catch (SQLiteException e2) {
            zzanVarZzh.zzj().zzg().zza("Error storing remote config. appId", zzgb.zza(str), e2);
        }
        this.zzh.put(str, (com.google.android.gms.internal.measurement.zzfl.zzd) ((com.google.android.gms.internal.measurement.zzju) zzaVarZzca.zzah()));
        return true;
    }

    final boolean zzp(String str) throws Throwable {
        zzt();
        zzv(str);
        return this.zzd.get(str) != null && this.zzd.get(str).contains("app_instance_id");
    }

    final boolean zzq(String str) throws Throwable {
        zzt();
        zzv(str);
        if (this.zzd.get(str) != null) {
            return this.zzd.get(str).contains(ProfilingTraceData.JsonKeys.DEVICE_MODEL) || this.zzd.get(str).contains(DeviceRequestsHelper.DEVICE_INFO_PARAM);
        }
        return false;
    }

    final boolean zzr(String str) throws Throwable {
        zzt();
        zzv(str);
        return this.zzd.get(str) != null && this.zzd.get(str).contains("enhanced_user_id");
    }

    final boolean zzs(String str) throws Throwable {
        zzt();
        zzv(str);
        return this.zzd.get(str) != null && this.zzd.get(str).contains("google_signals");
    }

    final boolean zzt(String str) throws Throwable {
        zzt();
        zzv(str);
        if (this.zzd.get(str) != null) {
            return this.zzd.get(str).contains("os_version") || this.zzd.get(str).contains(DeviceRequestsHelper.DEVICE_INFO_PARAM);
        }
        return false;
    }

    final boolean zzu(String str) throws Throwable {
        zzt();
        zzv(str);
        return this.zzd.get(str) != null && this.zzd.get(str).contains("user_id");
    }
}
