package com.transistorsoft.locationmanager.event;

import com.transistorsoft.locationmanager.geofence.TSGeofence;
import com.transistorsoft.locationmanager.logger.TSLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.DebugKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class GeofencesChangeEvent {
    private final List<TSGeofence> a;
    private final List<String> b;

    public GeofencesChangeEvent() {
        this.a = new ArrayList();
        this.b = new ArrayList();
    }

    public List<TSGeofence> getActivatedGeofences() {
        return this.a;
    }

    public List<String> getDeactivatedGeofences() {
        return this.b;
    }

    public GeofencesChangeEvent setOff(List<String> list) {
        this.b.clear();
        this.b.addAll(list);
        return this;
    }

    public GeofencesChangeEvent setOn(List<TSGeofence> list) {
        this.a.clear();
        this.a.addAll(list);
        return this;
    }

    public JSONObject toJson() {
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        try {
            Iterator<String> it2 = this.b.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(it2.next());
            }
            Iterator<TSGeofence> it3 = this.a.iterator();
            while (it3.hasNext()) {
                jSONArray.put(it3.next().toJson());
            }
            jSONObject.put("on", jSONArray);
            jSONObject.put(DebugKt.DEBUG_PROPERTY_VALUE_OFF, jSONArray2);
        } catch (JSONException e) {
            TSLog.logger.error(TSLog.error(e.getMessage()));
            e.printStackTrace();
        }
        return jSONObject;
    }

    public Map<String, List> toMap() {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        map.put(DebugKt.DEBUG_PROPERTY_VALUE_OFF, new ArrayList(this.b));
        map.put("on", arrayList);
        Iterator<TSGeofence> it2 = this.a.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().toMap());
        }
        return map;
    }

    public GeofencesChangeEvent(List<TSGeofence> list, List<String> list2) {
        this.a = list;
        this.b = list2;
    }
}
