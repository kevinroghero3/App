package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.Clock;
import io.sentry.util.StringUtils;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: loaded from: classes5.dex */
public final class zzmg extends zznf {
    public final zzgr zza;
    public final zzgr zzb;
    public final zzgr zzc;
    public final zzgr zzd;
    public final zzgr zze;
    private final Map<String, zzmj> zzg;

    @Override // com.google.android.gms.measurement.internal.zzio, com.google.android.gms.measurement.internal.zziq
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zznf
    protected final boolean zzc() {
        return false;
    }

    @Deprecated
    private final Pair<String, Boolean> zza(String str) {
        zzmj zzmjVar;
        AdvertisingIdClient.Info advertisingIdInfo;
        zzt();
        long jElapsedRealtime = zzb().elapsedRealtime();
        zzmj zzmjVar2 = this.zzg.get(str);
        if (zzmjVar2 != null && jElapsedRealtime < zzmjVar2.zzc) {
            return new Pair<>(zzmjVar2.zza, Boolean.valueOf(zzmjVar2.zzb));
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        long jZzd = zze().zzd(str) + jElapsedRealtime;
        try {
            long jZzc = zze().zzc(str, zzbh.zzb);
            if (jZzc > 0) {
                try {
                    advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zza());
                } catch (PackageManager.NameNotFoundException unused) {
                    if (zzmjVar2 != null && jElapsedRealtime < zzmjVar2.zzc + jZzc) {
                        return new Pair<>(zzmjVar2.zza, Boolean.valueOf(zzmjVar2.zzb));
                    }
                    advertisingIdInfo = null;
                }
            } else {
                advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zza());
            }
            if (advertisingIdInfo == null) {
                return new Pair<>(StringUtils.PROPER_NIL_UUID, Boolean.FALSE);
            }
            String id = advertisingIdInfo.getId();
            zzmjVar = id != null ? new zzmj(id, advertisingIdInfo.isLimitAdTrackingEnabled(), jZzd) : new zzmj("", advertisingIdInfo.isLimitAdTrackingEnabled(), jZzd);
            this.zzg.put(str, zzmjVar);
            AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
            return new Pair<>(zzmjVar.zza, Boolean.valueOf(zzmjVar.zzb));
        } catch (Exception e) {
            zzj().zzc().zza("Unable to get advertising id", e);
            zzmjVar = new zzmj("", false, jZzd);
        }
    }

    final Pair<String, Boolean> zza(String str, zzis zzisVar) {
        if (zzisVar.zzi()) {
            return zza(str);
        }
        return new Pair<>("", Boolean.FALSE);
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

    @Deprecated
    final String zza(String str, boolean z) {
        String str2;
        zzt();
        if (!z) {
            str2 = StringUtils.PROPER_NIL_UUID;
        } else {
            str2 = (String) zza(str).first;
        }
        MessageDigest messageDigestZzu = zznw.zzu();
        if (messageDigestZzu == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigestZzu.digest(str2.getBytes())));
    }

    zzmg(zzng zzngVar) {
        super(zzngVar);
        this.zzg = new HashMap();
        zzgm zzgmVarZzk = zzk();
        Objects.requireNonNull(zzgmVarZzk);
        this.zza = new zzgr(zzgmVarZzk, "last_delete_stale", 0L);
        zzgm zzgmVarZzk2 = zzk();
        Objects.requireNonNull(zzgmVarZzk2);
        this.zzb = new zzgr(zzgmVarZzk2, "backoff", 0L);
        zzgm zzgmVarZzk3 = zzk();
        Objects.requireNonNull(zzgmVarZzk3);
        this.zzc = new zzgr(zzgmVarZzk3, "last_upload", 0L);
        zzgm zzgmVarZzk4 = zzk();
        Objects.requireNonNull(zzgmVarZzk4);
        this.zzd = new zzgr(zzgmVarZzk4, "last_upload_attempt", 0L);
        zzgm zzgmVarZzk5 = zzk();
        Objects.requireNonNull(zzgmVarZzk5);
        this.zze = new zzgr(zzgmVarZzk5, "midnight_offset", 0L);
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
}
