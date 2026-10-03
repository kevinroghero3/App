package com.transistorsoft.locationmanager.event;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ConnectivityChangeEvent {
    private final Boolean a;

    public ConnectivityChangeEvent(boolean z) {
        this.a = Boolean.valueOf(z);
    }

    public boolean hasConnection() {
        return this.a.booleanValue();
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("connected", this.a);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public Map<String, Object> toMap() {
        HashMap map = new HashMap();
        map.put("connected", this.a);
        return map;
    }
}
