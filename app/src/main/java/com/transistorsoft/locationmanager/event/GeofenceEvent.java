package com.transistorsoft.locationmanager.event;

import com.transistorsoft.locationmanager.geofence.TSGeofence;
import com.transistorsoft.locationmanager.location.TSLocation;
import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.locationmanager.util.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class GeofenceEvent {
    private final TSGeofence a;
    private final TSLocation b;

    public GeofenceEvent(int i, TSGeofence tSGeofence, TSLocation tSLocation) {
        this.a = tSGeofence;
        this.b = tSLocation;
        tSLocation.addGeofencingEvent(i, tSGeofence);
    }

    public TSGeofence getGeofence() {
        return this.a;
    }

    public TSLocation getLocation() {
        return this.b;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("location", this.b.toJson());
            jSONObject.put("identifier", this.a.getIdentifier());
            jSONObject.put("action", this.b.getGeofenceAction());
            jSONObject.put("timestamp", this.b.getGeofenceTimestamp());
            JSONObject geofenceExtras = this.b.getGeofenceExtras();
            if (geofenceExtras != null) {
                jSONObject.put("extras", geofenceExtras);
            }
        } catch (JSONException e) {
            TSLog.logger.error(TSLog.error(e.getMessage()));
            e.printStackTrace();
        }
        return jSONObject;
    }

    public Map<String, Object> toMap() {
        HashMap map = new HashMap();
        map.put("identifier", this.a.getIdentifier());
        map.put("action", this.b.getGeofenceAction());
        map.put("timestamp", this.b.getGeofenceTimestamp());
        try {
            map.put("location", this.b.toMap());
            JSONObject geofenceExtras = this.b.getGeofenceExtras();
            if (geofenceExtras != null) {
                map.put("extras", Util.toMap(geofenceExtras));
            }
        } catch (JSONException e) {
            TSLog.logger.warn(TSLog.warn(e.getMessage()));
            e.printStackTrace();
        }
        return map;
    }
}
