package com.google.android.gms.measurement.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import com.google.android.gms.internal.measurement.zzds;
import com.google.android.gms.measurement.internal.zziw;
import com.google.android.gms.measurement.internal.zziz;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class AppMeasurementSdk {
    private final zzds zza;

    public static final class ConditionalUserProperty {
        public static final String ACTIVE = "active";
        public static final String CREATION_TIMESTAMP = "creation_timestamp";
        public static final String EXPIRED_EVENT_NAME = "expired_event_name";
        public static final String EXPIRED_EVENT_PARAMS = "expired_event_params";
        public static final String NAME = "name";
        public static final String ORIGIN = "origin";
        public static final String TIMED_OUT_EVENT_NAME = "timed_out_event_name";
        public static final String TIMED_OUT_EVENT_PARAMS = "timed_out_event_params";
        public static final String TIME_TO_LIVE = "time_to_live";
        public static final String TRIGGERED_EVENT_NAME = "triggered_event_name";
        public static final String TRIGGERED_EVENT_PARAMS = "triggered_event_params";
        public static final String TRIGGERED_TIMESTAMP = "triggered_timestamp";
        public static final String TRIGGER_EVENT_NAME = "trigger_event_name";
        public static final String TRIGGER_TIMEOUT = "trigger_timeout";
        public static final String VALUE = "value";

        private ConditionalUserProperty() {
        }
    }

    public interface EventInterceptor extends zziw {
        @Override // com.google.android.gms.measurement.internal.zziw
        void interceptEvent(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle, long j);
    }

    public interface OnEventListener extends zziz {
        @Override // com.google.android.gms.measurement.internal.zziz
        void onEvent(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle, long j);
    }

    public int getMaxUserProperties(@NonNull @Size(min = 1) String str) {
        return this.zza.zza(str);
    }

    public long generateEventId() {
        return this.zza.zza();
    }

    public Bundle performActionWithResponse(@NonNull Bundle bundle) {
        return this.zza.zza(bundle, true);
    }

    public static AppMeasurementSdk getInstance(@NonNull Context context) {
        return zzds.zza(context).zzb();
    }

    public static AppMeasurementSdk getInstance(@NonNull Context context, @NonNull String str, @NonNull String str2, @Nullable String str3, @NonNull Bundle bundle) {
        return zzds.zza(context, str, str2, str3, bundle).zzb();
    }

    public String getAppIdOrigin() {
        return this.zza.zzd();
    }

    public String getAppInstanceId() {
        return this.zza.zzf();
    }

    public String getCurrentScreenClass() {
        return this.zza.zzg();
    }

    public String getCurrentScreenName() {
        return this.zza.zzh();
    }

    public String getGmpAppId() {
        return this.zza.zzi();
    }

    public List<Bundle> getConditionalUserProperties(@Nullable String str, @Nullable @Size(max = 23, min = 1) String str2) {
        return this.zza.zza(str, str2);
    }

    public Map<String, Object> getUserProperties(@Nullable String str, @Nullable @Size(max = 24, min = 1) String str2, boolean z) {
        return this.zza.zza(str, str2, z);
    }

    public AppMeasurementSdk(zzds zzdsVar) {
        this.zza = zzdsVar;
    }

    public void beginAdUnitExposure(@NonNull @Size(min = 1) String str) {
        this.zza.zzb(str);
    }

    public void clearConditionalUserProperty(@NonNull @Size(max = 24, min = 1) String str, @Nullable String str2, @Nullable Bundle bundle) {
        this.zza.zza(str, str2, bundle);
    }

    public void endAdUnitExposure(@NonNull @Size(min = 1) String str) {
        this.zza.zzc(str);
    }

    public void logEvent(@NonNull String str, @NonNull String str2, @Nullable Bundle bundle) {
        this.zza.zzb(str, str2, bundle);
    }

    public void logEventNoInterceptor(@NonNull String str, @NonNull String str2, @Nullable Bundle bundle, long j) {
        this.zza.zza(str, str2, bundle, j);
    }

    public void performAction(@NonNull Bundle bundle) {
        this.zza.zza(bundle, false);
    }

    public void registerOnMeasurementEventListener(@NonNull OnEventListener onEventListener) {
        this.zza.zza(onEventListener);
    }

    public void setConditionalUserProperty(@NonNull Bundle bundle) {
        this.zza.zza(bundle);
    }

    public void setConsent(@NonNull Bundle bundle) {
        this.zza.zzb(bundle);
    }

    public void setCurrentScreen(@NonNull Activity activity, @Nullable @Size(max = 36, min = 1) String str, @Nullable @Size(max = 36, min = 1) String str2) {
        this.zza.zza(activity, str, str2);
    }

    public final void zza(boolean z) {
        this.zza.zza(z);
    }

    public void setEventInterceptor(@NonNull EventInterceptor eventInterceptor) {
        this.zza.zza(eventInterceptor);
    }

    public void setMeasurementEnabled(@Nullable Boolean bool) {
        this.zza.zza(bool);
    }

    public void setMeasurementEnabled(boolean z) {
        this.zza.zza(Boolean.valueOf(z));
    }

    public void setUserProperty(@NonNull String str, @NonNull String str2, @NonNull Object obj) {
        this.zza.zza(str, str2, obj, true);
    }

    public void unregisterOnMeasurementEventListener(@NonNull OnEventListener onEventListener) {
        this.zza.zzb(onEventListener);
    }
}
