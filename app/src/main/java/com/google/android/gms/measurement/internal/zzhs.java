package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.compose.animation.core.AnimationKt;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes5.dex */
public final class zzhs extends zzft {
    private final zzng zza;
    private Boolean zzb;
    private String zzc;

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final zzal zza(zzn zznVar) {
        zzb(zznVar, false);
        Preconditions.checkNotEmpty(zznVar.zza);
        try {
            return (zzal) this.zza.zzl().zzb(new zzif(this, zznVar)).get(10000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.zza.zzj().zzg().zza("Failed to get consent. appId", zzgb.zza(zznVar.zza), e);
            return new zzal(null);
        }
    }

    final zzbf zzb(zzbf zzbfVar, zzn zznVar) {
        zzba zzbaVar;
        if (Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zzbfVar.zza) && (zzbaVar = zzbfVar.zzb) != null && zzbaVar.zza() != 0) {
            String strZzd = zzbfVar.zzb.zzd("_cis");
            if ("referrer broadcast".equals(strZzd) || "referrer API".equals(strZzd)) {
                this.zza.zzj().zzn().zza("Event has been filtered ", zzbfVar.toString());
                return new zzbf("_cmpx", zzbfVar.zzb, zzbfVar.zzc, zzbfVar.zzd);
            }
        }
        return zzbfVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final String zzb(zzn zznVar) {
        zzb(zznVar, false);
        return this.zza.zzb(zznVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final List<zzmy> zza(zzn zznVar, Bundle bundle) {
        zzb(zznVar, false);
        Preconditions.checkNotNull(zznVar.zza);
        try {
            return (List) this.zza.zzl().zza(new zzim(this, zznVar, bundle)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzj().zzg().zza("Failed to get trigger URIs. appId", zzgb.zza(zznVar.zza), e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final List<zznv> zza(zzn zznVar, boolean z) {
        zzb(zznVar, false);
        String str = zznVar.zza;
        Preconditions.checkNotNull(str);
        try {
            List<zznx> list = (List) this.zza.zzl().zza(new zzil(this, str)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zznx zznxVar : list) {
                if (z || !zznw.zzg(zznxVar.zzc)) {
                    arrayList.add(new zznv(zznxVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzj().zzg().zza("Failed to get user properties. appId", zzgb.zza(zznVar.zza), e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final List<zzac> zza(String str, String str2, zzn zznVar) {
        zzb(zznVar, false);
        String str3 = zznVar.zza;
        Preconditions.checkNotNull(str3);
        try {
            return (List) this.zza.zzl().zza(new zzib(this, str3, str, str2)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzj().zzg().zza("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final List<zzac> zza(String str, String str2, String str3) {
        zza(str, true);
        try {
            return (List) this.zza.zzl().zza(new zzie(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzj().zzg().zza("Failed to get conditional user properties as", e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final List<zznv> zza(String str, String str2, boolean z, zzn zznVar) {
        zzb(zznVar, false);
        String str3 = zznVar.zza;
        Preconditions.checkNotNull(str3);
        try {
            List<zznx> list = (List) this.zza.zzl().zza(new zzhz(this, str3, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zznx zznxVar : list) {
                if (z || !zznw.zzg(zznxVar.zzc)) {
                    arrayList.add(new zznv(zznxVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzj().zzg().zza("Failed to query user properties. appId", zzgb.zza(zznVar.zza), e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final List<zznv> zza(String str, String str2, String str3, boolean z) {
        zza(str, true);
        try {
            List<zznx> list = (List) this.zza.zzl().zza(new zzic(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zznx zznxVar : list) {
                if (z || !zznw.zzg(zznxVar.zzc)) {
                    arrayList.add(new zznv(zznxVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzj().zzg().zza("Failed to get user properties as. appId", zzgb.zza(str), e);
            return Collections.emptyList();
        }
    }

    public zzhs(zzng zzngVar) {
        this(zzngVar, null);
    }

    private zzhs(zzng zzngVar, String str) {
        Preconditions.checkNotNull(zzngVar);
        this.zza = zzngVar;
        this.zzc = null;
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final void zzc(zzn zznVar) {
        zzb(zznVar, false);
        zzb(new zzhv(this, zznVar));
    }

    private final void zzb(zzn zznVar, boolean z) {
        Preconditions.checkNotNull(zznVar);
        Preconditions.checkNotEmpty(zznVar.zza);
        zza(zznVar.zza, false);
        this.zza.zzq().zza(zznVar.zzb, zznVar.zzp);
    }

    private final void zza(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            this.zza.zzj().zzg().zza("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z) {
            try {
                if (this.zzb == null) {
                    this.zzb = Boolean.valueOf("com.google.android.gms".equals(this.zzc) || UidVerifier.isGooglePlayServicesUid(this.zza.zza(), Binder.getCallingUid()) || GoogleSignatureVerifier.getInstance(this.zza.zza()).isUidGoogleSigned(Binder.getCallingUid()));
                }
                if (this.zzb.booleanValue()) {
                    return;
                }
            } catch (SecurityException e) {
                this.zza.zzj().zzg().zza("Measurement Service called with invalid calling package. appId", zzgb.zza(str));
                throw e;
            }
        }
        if (this.zzc == null && GooglePlayServicesUtilLight.uidHasPackageName(this.zza.zza(), Binder.getCallingUid(), str)) {
            this.zzc = str;
        }
        if (str.equals(this.zzc)) {
        } else {
            throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
        }
    }

    final void zzc(zzbf zzbfVar, zzn zznVar) {
        if (!this.zza.zzi().zzl(zznVar.zza)) {
            zzd(zzbfVar, zznVar);
            return;
        }
        this.zza.zzj().zzp().zza("EES config found for", zznVar.zza);
        zzgy zzgyVarZzi = this.zza.zzi();
        String str = zznVar.zza;
        com.google.android.gms.internal.measurement.zzb zzbVar = TextUtils.isEmpty(str) ? null : zzgyVarZzi.zza.get(str);
        if (zzbVar == null) {
            this.zza.zzj().zzp().zza("EES not loaded for", zznVar.zza);
            zzd(zzbfVar, zznVar);
            return;
        }
        try {
            Map<String, Object> mapZza = this.zza.zzp().zza(zzbfVar.zzb.zzb(), true);
            String strZza = zziv.zza(zzbfVar.zza);
            if (strZza == null) {
                strZza = zzbfVar.zza;
            }
            if (zzbVar.zza(new com.google.android.gms.internal.measurement.zzad(strZza, zzbfVar.zzd, mapZza))) {
                if (zzbVar.zzd()) {
                    this.zza.zzj().zzp().zza("EES edited event", zzbfVar.zza);
                    zzd(this.zza.zzp().zza(zzbVar.zza().zzb()), zznVar);
                } else {
                    zzd(zzbfVar, zznVar);
                }
                if (zzbVar.zzc()) {
                    for (com.google.android.gms.internal.measurement.zzad zzadVar : zzbVar.zza().zzc()) {
                        this.zza.zzj().zzp().zza("EES logging created event", zzadVar.zzb());
                        zzd(this.zza.zzp().zza(zzadVar), zznVar);
                    }
                    return;
                }
                return;
            }
        } catch (com.google.android.gms.internal.measurement.zzc unused) {
            this.zza.zzj().zzg().zza("EES error. appId, eventName", zznVar.zzb, zzbfVar.zza);
        }
        this.zza.zzj().zzp().zza("EES was not applied to event", zzbfVar.zza);
        zzd(zzbfVar, zznVar);
    }

    final /* synthetic */ void zza(String str, Bundle bundle) {
        this.zza.zzf().zza(str, bundle);
    }

    final /* synthetic */ void zzi(zzn zznVar) {
        this.zza.zzr();
        this.zza.zze(zznVar);
    }

    final /* synthetic */ void zzj(zzn zznVar) {
        this.zza.zzr();
        this.zza.zzf(zznVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final void zza(zzbf zzbfVar, zzn zznVar) {
        Preconditions.checkNotNull(zzbfVar);
        zzb(zznVar, false);
        zzb(new zzii(this, zzbfVar, zznVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final void zza(zzbf zzbfVar, String str, String str2) {
        Preconditions.checkNotNull(zzbfVar);
        Preconditions.checkNotEmpty(str);
        zza(str, true);
        zzb(new zzih(this, zzbfVar, str));
    }

    private final void zzd(zzbf zzbfVar, zzn zznVar) {
        this.zza.zzr();
        this.zza.zza(zzbfVar, zznVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final void zzd(zzn zznVar) {
        Preconditions.checkNotEmpty(zznVar.zza);
        zza(zznVar.zza, false);
        zzb(new zzid(this, zznVar));
    }

    private final void zza(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        if (this.zza.zzl().zzg()) {
            runnable.run();
        } else {
            this.zza.zzl().zzc(runnable);
        }
    }

    private final void zzb(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        if (this.zza.zzl().zzg()) {
            runnable.run();
        } else {
            this.zza.zzl().zzb(runnable);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final void zza(zzac zzacVar, zzn zznVar) {
        Preconditions.checkNotNull(zzacVar);
        Preconditions.checkNotNull(zzacVar.zzc);
        zzb(zznVar, false);
        zzac zzacVar2 = new zzac(zzacVar);
        zzacVar2.zza = zznVar.zza;
        zzb(new zzhx(this, zzacVar2, zznVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final void zza(zzac zzacVar) {
        Preconditions.checkNotNull(zzacVar);
        Preconditions.checkNotNull(zzacVar.zzc);
        Preconditions.checkNotEmpty(zzacVar.zza);
        zza(zzacVar.zza, true);
        zzb(new zzia(this, new zzac(zzacVar)));
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final void zze(zzn zznVar) {
        Preconditions.checkNotEmpty(zznVar.zza);
        Preconditions.checkNotNull(zznVar.zzt);
        zza(new zzig(this, zznVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final void zza(long j, String str, String str2, String str3) {
        zzb(new zzhy(this, str2, str3, str, j));
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final void zza(final Bundle bundle, zzn zznVar) {
        zzb(zznVar, false);
        final String str = zznVar.zza;
        Preconditions.checkNotNull(str);
        zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzht
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza(str, bundle);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final void zzf(final zzn zznVar) {
        Preconditions.checkNotEmpty(zznVar.zza);
        Preconditions.checkNotNull(zznVar.zzt);
        zza(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzhu
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzi(zznVar);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final void zzg(zzn zznVar) {
        zzb(zznVar, false);
        zzb(new zzhw(this, zznVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final void zzh(final zzn zznVar) {
        Preconditions.checkNotEmpty(zznVar.zza);
        Preconditions.checkNotNull(zznVar.zzt);
        zza(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzhr
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzj(zznVar);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final void zza(zznv zznvVar, zzn zznVar) {
        Preconditions.checkNotNull(zznvVar);
        zzb(zznVar, false);
        zzb(new zzij(this, zznvVar, zznVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzfq
    public final byte[] zza(zzbf zzbfVar, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzbfVar);
        zza(str, true);
        this.zza.zzj().zzc().zza("Log and bundle. event", this.zza.zzg().zza(zzbfVar.zza));
        long jNanoTime = this.zza.zzb().nanoTime() / AnimationKt.MillisToNanos;
        try {
            byte[] bArr = (byte[]) this.zza.zzl().zzb(new zzik(this, zzbfVar, str)).get();
            if (bArr == null) {
                this.zza.zzj().zzg().zza("Log and bundle returned null. appId", zzgb.zza(str));
                bArr = new byte[0];
            }
            this.zza.zzj().zzc().zza("Log and bundle processed. event, size, time_ms", this.zza.zzg().zza(zzbfVar.zza), Integer.valueOf(bArr.length), Long.valueOf((this.zza.zzb().nanoTime() / AnimationKt.MillisToNanos) - jNanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzj().zzg().zza("Failed to log and bundle. appId, event, error", zzgb.zza(str), this.zza.zzg().zza(zzbfVar.zza), e);
            return null;
        }
    }
}
