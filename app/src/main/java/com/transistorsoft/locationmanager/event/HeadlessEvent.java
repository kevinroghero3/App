package com.transistorsoft.locationmanager.event;

import android.content.Context;
import com.transistorsoft.locationmanager.http.HttpResponse;
import com.transistorsoft.locationmanager.location.TSLocation;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class HeadlessEvent {
    private final Object a;
    private final String b;
    private final Context c;

    public HeadlessEvent(Context context, String str, Object obj) {
        this.b = str;
        this.a = obj;
        this.c = context;
    }

    public ActivityChangeEvent getActivityChangeEvent() {
        return (ActivityChangeEvent) this.a;
    }

    public AuthorizationEvent getAuthorizationEvent() {
        return (AuthorizationEvent) this.a;
    }

    public JSONObject getBootEvent() {
        return (JSONObject) this.a;
    }

    public ConnectivityChangeEvent getConnectivityChangeEvent() {
        return (ConnectivityChangeEvent) this.a;
    }

    public Context getContext() {
        return this.c;
    }

    public Boolean getEnabledChangeEvent() {
        return (Boolean) this.a;
    }

    public Object getEvent() {
        return this.a;
    }

    public GeofenceEvent getGeofenceEvent() {
        return (GeofenceEvent) this.a;
    }

    public GeofencesChangeEvent getGeofencesChangeEvent() {
        return (GeofencesChangeEvent) this.a;
    }

    public HeartbeatEvent getHeartbeatEvent() {
        return (HeartbeatEvent) this.a;
    }

    public HttpResponse getHttpEvent() {
        return (HttpResponse) this.a;
    }

    public TSLocation getLocationEvent() {
        return (TSLocation) this.a;
    }

    public MotionChangeEvent getMotionChangeEvent() {
        return (MotionChangeEvent) this.a;
    }

    public String getName() {
        return this.b;
    }

    public String getNotificationEvent() {
        return (String) this.a;
    }

    public PowerSaveModeChangeEvent getPowerSaveChangeEvent() {
        return (PowerSaveModeChangeEvent) this.a;
    }

    public LocationProviderChangeEvent getProviderChangeEvent() {
        return (LocationProviderChangeEvent) this.a;
    }

    public JSONObject getScheduleEvent() {
        return (JSONObject) this.a;
    }

    public JSONObject getTerminateEvent() {
        return (JSONObject) this.a;
    }
}
