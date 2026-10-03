package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzqw;
import io.sentry.protocol.App;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: loaded from: classes4.dex */
public class AppMeasurementDynamiteService extends com.google.android.gms.internal.measurement.zzdg {
    zzho zza = null;
    private final Map<Integer, zziz> zzb = new ArrayMap();

    final class zza implements zziw {
        private com.google.android.gms.internal.measurement.zzdj zza;

        zza(com.google.android.gms.internal.measurement.zzdj zzdjVar) {
            this.zza = zzdjVar;
        }

        @Override // com.google.android.gms.measurement.internal.zziw
        public final void interceptEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.zza.zza(str, str2, bundle, j);
            } catch (RemoteException e) {
                zzho zzhoVar = AppMeasurementDynamiteService.this.zza;
                if (zzhoVar != null) {
                    zzhoVar.zzj().zzu().zza("Event interceptor threw exception", e);
                }
            }
        }
    }

    final class zzb implements zziz {
        private com.google.android.gms.internal.measurement.zzdj zza;

        zzb(com.google.android.gms.internal.measurement.zzdj zzdjVar) {
            this.zza = zzdjVar;
        }

        @Override // com.google.android.gms.measurement.internal.zziz
        public final void onEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.zza.zza(str, str2, bundle, j);
            } catch (RemoteException e) {
                zzho zzhoVar = AppMeasurementDynamiteService.this.zza;
                if (zzhoVar != null) {
                    zzhoVar.zzj().zzu().zza("Event listener threw exception", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void beginAdUnitExposure(@NonNull String str, long j) throws RemoteException {
        zza();
        this.zza.zze().zza(str, j);
    }

    @EnsuresNonNull({"scion"})
    private final void zza() {
        if (this.zza == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void clearConditionalUserProperty(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle) throws RemoteException {
        zza();
        this.zza.zzp().zza(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void clearMeasurementEnabled(long j) throws RemoteException {
        zza();
        this.zza.zzp().zza((Boolean) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void endAdUnitExposure(@NonNull String str, long j) throws RemoteException {
        zza();
        this.zza.zze().zzb(str, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void generateEventId(com.google.android.gms.internal.measurement.zzdi zzdiVar) throws RemoteException {
        zza();
        long jZzm = this.zza.zzt().zzm();
        zza();
        this.zza.zzt().zza(zzdiVar, jZzm);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void getAppInstanceId(com.google.android.gms.internal.measurement.zzdi zzdiVar) throws RemoteException {
        zza();
        this.zza.zzl().zzb(new zzh(this, zzdiVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void getCachedAppInstanceId(com.google.android.gms.internal.measurement.zzdi zzdiVar) throws RemoteException {
        zza();
        zza(zzdiVar, this.zza.zzp().zzae());
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void getConditionalUserProperties(String str, String str2, com.google.android.gms.internal.measurement.zzdi zzdiVar) throws RemoteException {
        zza();
        this.zza.zzl().zzb(new zzk(this, zzdiVar, str, str2));
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void getCurrentScreenClass(com.google.android.gms.internal.measurement.zzdi zzdiVar) throws RemoteException {
        zza();
        zza(zzdiVar, this.zza.zzp().zzaf());
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void getCurrentScreenName(com.google.android.gms.internal.measurement.zzdi zzdiVar) throws RemoteException {
        zza();
        zza(zzdiVar, this.zza.zzp().zzag());
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void getGmpAppId(com.google.android.gms.internal.measurement.zzdi zzdiVar) throws RemoteException {
        zza();
        zza(zzdiVar, this.zza.zzp().zzah());
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void getMaxUserProperties(String str, com.google.android.gms.internal.measurement.zzdi zzdiVar) throws RemoteException {
        zza();
        this.zza.zzp();
        Preconditions.checkNotEmpty(str);
        zza();
        this.zza.zzt().zza(zzdiVar, 25);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void getSessionId(com.google.android.gms.internal.measurement.zzdi zzdiVar) throws RemoteException {
        zza();
        zzja zzjaVarZzp = this.zza.zzp();
        zzjaVarZzp.zzl().zzb(new zzkf(zzjaVarZzp, zzdiVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void getTestFlag(com.google.android.gms.internal.measurement.zzdi zzdiVar, int i) throws RemoteException {
        zza();
        if (i == 0) {
            this.zza.zzt().zza(zzdiVar, this.zza.zzp().zzai());
            return;
        }
        if (i == 1) {
            this.zza.zzt().zza(zzdiVar, this.zza.zzp().zzad().longValue());
            return;
        }
        if (i != 2) {
            if (i == 3) {
                this.zza.zzt().zza(zzdiVar, this.zza.zzp().zzac().intValue());
                return;
            } else {
                if (i != 4) {
                    return;
                }
                this.zza.zzt().zza(zzdiVar, this.zza.zzp().zzaa().booleanValue());
                return;
            }
        }
        zznw zznwVarZzt = this.zza.zzt();
        double dDoubleValue = this.zza.zzp().zzab().doubleValue();
        Bundle bundle = new Bundle();
        bundle.putDouble("r", dDoubleValue);
        try {
            zzdiVar.zza(bundle);
        } catch (RemoteException e) {
            zznwVarZzt.zzu.zzj().zzu().zza("Error returning double value to wrapper", e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void getUserProperties(String str, String str2, boolean z, com.google.android.gms.internal.measurement.zzdi zzdiVar) throws RemoteException {
        zza();
        this.zza.zzl().zzb(new zzi(this, zzdiVar, str, str2, z));
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void initForTests(@NonNull Map map) throws RemoteException {
        zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void initialize(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzdq zzdqVar, long j) throws RemoteException {
        zzho zzhoVar = this.zza;
        if (zzhoVar == null) {
            this.zza = zzho.zza((Context) Preconditions.checkNotNull((Context) ObjectWrapper.unwrap(iObjectWrapper)), zzdqVar, Long.valueOf(j));
        } else {
            zzhoVar.zzj().zzu().zza("Attempting to initialize multiple times");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void isDataCollectionEnabled(com.google.android.gms.internal.measurement.zzdi zzdiVar) throws RemoteException {
        zza();
        this.zza.zzl().zzb(new zzm(this, zzdiVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void logEvent(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        zza();
        this.zza.zzp().zza(str, str2, bundle, z, z2, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void logEventAndBundle(String str, String str2, Bundle bundle, com.google.android.gms.internal.measurement.zzdi zzdiVar, long j) throws RemoteException {
        zza();
        Preconditions.checkNotEmpty(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", App.TYPE);
        this.zza.zzl().zzb(new zzj(this, zzdiVar, new zzbf(str2, new zzba(bundle), App.TYPE, j), str));
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void logHealthData(int i, @NonNull String str, @NonNull IObjectWrapper iObjectWrapper, @NonNull IObjectWrapper iObjectWrapper2, @NonNull IObjectWrapper iObjectWrapper3) throws RemoteException {
        zza();
        this.zza.zzj().zza(i, true, false, str, iObjectWrapper == null ? null : ObjectWrapper.unwrap(iObjectWrapper), iObjectWrapper2 == null ? null : ObjectWrapper.unwrap(iObjectWrapper2), iObjectWrapper3 != null ? ObjectWrapper.unwrap(iObjectWrapper3) : null);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void onActivityCreated(@NonNull IObjectWrapper iObjectWrapper, @NonNull Bundle bundle, long j) throws RemoteException {
        zza();
        zzkm zzkmVar = this.zza.zzp().zza;
        if (zzkmVar != null) {
            this.zza.zzp().zzal();
            zzkmVar.onActivityCreated((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void onActivityDestroyed(@NonNull IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzkm zzkmVar = this.zza.zzp().zza;
        if (zzkmVar != null) {
            this.zza.zzp().zzal();
            zzkmVar.onActivityDestroyed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void onActivityPaused(@NonNull IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzkm zzkmVar = this.zza.zzp().zza;
        if (zzkmVar != null) {
            this.zza.zzp().zzal();
            zzkmVar.onActivityPaused((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void onActivityResumed(@NonNull IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzkm zzkmVar = this.zza.zzp().zza;
        if (zzkmVar != null) {
            this.zza.zzp().zzal();
            zzkmVar.onActivityResumed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzdi zzdiVar, long j) throws RemoteException {
        zza();
        zzkm zzkmVar = this.zza.zzp().zza;
        Bundle bundle = new Bundle();
        if (zzkmVar != null) {
            this.zza.zzp().zzal();
            zzkmVar.onActivitySaveInstanceState((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
        try {
            zzdiVar.zza(bundle);
        } catch (RemoteException e) {
            this.zza.zzj().zzu().zza("Error returning bundle value to wrapper", e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void onActivityStarted(@NonNull IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzkm zzkmVar = this.zza.zzp().zza;
        if (zzkmVar != null) {
            this.zza.zzp().zzal();
            zzkmVar.onActivityStarted((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void onActivityStopped(@NonNull IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzkm zzkmVar = this.zza.zzp().zza;
        if (zzkmVar != null) {
            this.zza.zzp().zzal();
            zzkmVar.onActivityStopped((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void performAction(Bundle bundle, com.google.android.gms.internal.measurement.zzdi zzdiVar, long j) throws RemoteException {
        zza();
        zzdiVar.zza(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void registerOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzdj zzdjVar) throws RemoteException {
        zziz zzbVar;
        zza();
        synchronized (this.zzb) {
            zzbVar = this.zzb.get(Integer.valueOf(zzdjVar.zza()));
            if (zzbVar == null) {
                zzbVar = new zzb(zzdjVar);
                this.zzb.put(Integer.valueOf(zzdjVar.zza()), zzbVar);
            }
        }
        this.zza.zzp().zza(zzbVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void resetAnalyticsData(long j) throws RemoteException {
        zza();
        zzja zzjaVarZzp = this.zza.zzp();
        zzjaVarZzp.zza((String) null);
        zzjaVarZzp.zzl().zzb(new zzjy(zzjaVarZzp, j));
    }

    private final void zza(com.google.android.gms.internal.measurement.zzdi zzdiVar, String str) {
        zza();
        this.zza.zzt().zza(zzdiVar, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setConditionalUserProperty(@NonNull Bundle bundle, long j) throws RemoteException {
        zza();
        if (bundle == null) {
            this.zza.zzj().zzg().zza("Conditional user property must not be null");
        } else {
            this.zza.zzp().zza(bundle, j);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setConsent(@NonNull final Bundle bundle, final long j) throws RemoteException {
        zza();
        final zzja zzjaVarZzp = this.zza.zzp();
        zzjaVarZzp.zzl().zzc(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjg
            @Override // java.lang.Runnable
            public final void run() {
                zzja zzjaVar = zzjaVarZzp;
                Bundle bundle2 = bundle;
                long j2 = j;
                if (TextUtils.isEmpty(zzjaVar.zzg().zzae())) {
                    zzjaVar.zza(bundle2, 0, j2);
                } else {
                    zzjaVar.zzj().zzv().zza("Using developer consent only; google app id found");
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setConsentThirdParty(@NonNull Bundle bundle, long j) throws RemoteException {
        zza();
        this.zza.zzp().zza(bundle, -20, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setCurrentScreen(@NonNull IObjectWrapper iObjectWrapper, @NonNull String str, @NonNull String str2, long j) throws RemoteException {
        zza();
        this.zza.zzq().zza((Activity) ObjectWrapper.unwrap(iObjectWrapper), str, str2);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setDataCollectionEnabled(boolean z) throws RemoteException {
        zza();
        zzja zzjaVarZzp = this.zza.zzp();
        zzjaVarZzp.zzu();
        zzjaVarZzp.zzl().zzb(new zzjr(zzjaVarZzp, z));
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setDefaultEventParameters(@NonNull Bundle bundle) {
        zza();
        final zzja zzjaVarZzp = this.zza.zzp();
        final Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
        zzjaVarZzp.zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjh
            @Override // java.lang.Runnable
            public final void run() {
                zzjaVarZzp.zza(bundle2);
            }
        });
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setEventInterceptor(com.google.android.gms.internal.measurement.zzdj zzdjVar) throws RemoteException {
        zza();
        zza zzaVar = new zza(zzdjVar);
        if (this.zza.zzl().zzg()) {
            this.zza.zzp().zza(zzaVar);
        } else {
            this.zza.zzl().zzb(new zzl(this, zzaVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setInstanceIdProvider(com.google.android.gms.internal.measurement.zzdo zzdoVar) throws RemoteException {
        zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        zza();
        this.zza.zzp().zza(Boolean.valueOf(z));
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setMinimumSessionDuration(long j) throws RemoteException {
        zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setSessionTimeoutDuration(long j) throws RemoteException {
        zza();
        zzja zzjaVarZzp = this.zza.zzp();
        zzjaVarZzp.zzl().zzb(new zzjt(zzjaVarZzp, j));
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setSgtmDebugInfo(@NonNull Intent intent) throws RemoteException {
        zza();
        zzja zzjaVarZzp = this.zza.zzp();
        if (zzqw.zza() && zzjaVarZzp.zze().zzf(null, zzbh.zzbu)) {
            Uri data = intent.getData();
            if (data == null) {
                zzjaVarZzp.zzj().zzn().zza("Activity intent has no data. Preview Mode was not enabled.");
                return;
            }
            String queryParameter = data.getQueryParameter("sgtm_debug_enable");
            if (queryParameter == null || !queryParameter.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
                zzjaVarZzp.zzj().zzn().zza("Preview Mode was not enabled.");
                zzjaVarZzp.zze().zzi(null);
                return;
            }
            String queryParameter2 = data.getQueryParameter("sgtm_preview_key");
            if (TextUtils.isEmpty(queryParameter2)) {
                return;
            }
            zzjaVarZzp.zzj().zzn().zza("Preview Mode was enabled. Using the sgtmPreviewKey: ", queryParameter2);
            zzjaVarZzp.zze().zzi(queryParameter2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setUserId(@NonNull final String str, long j) throws RemoteException {
        zza();
        final zzja zzjaVarZzp = this.zza.zzp();
        if (str != null && TextUtils.isEmpty(str)) {
            zzjaVarZzp.zzu.zzj().zzu().zza("User ID must be non-empty or null");
        } else {
            zzjaVarZzp.zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjl
                @Override // java.lang.Runnable
                public final void run() {
                    zzja zzjaVar = zzjaVarZzp;
                    if (zzjaVar.zzg().zzb(str)) {
                        zzjaVar.zzg().zzag();
                    }
                }
            });
            zzjaVarZzp.zza((String) null, "_id", (Object) str, true, j);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setUserProperty(@NonNull String str, @NonNull String str2, @NonNull IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        zza();
        this.zza.zzp().zza(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void unregisterOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzdj zzdjVar) throws RemoteException {
        zziz zzizVarRemove;
        zza();
        synchronized (this.zzb) {
            zzizVarRemove = this.zzb.remove(Integer.valueOf(zzdjVar.zza()));
        }
        if (zzizVarRemove == null) {
            zzizVarRemove = new zzb(zzdjVar);
        }
        this.zza.zzp().zzb(zzizVarRemove);
    }
}
