package com.transistorsoft.locationmanager.event;

import com.google.android.gms.location.ActivityTransitionEvent;
import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.locationmanager.util.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ActivityChangeEvent {
    private final ActivityTransitionEvent a;

    public ActivityChangeEvent(ActivityTransitionEvent activityTransitionEvent) {
        this.a = activityTransitionEvent;
    }

    public String getActivityName() {
        return Util.getActivityName(this.a.getActivityType());
    }

    public ActivityTransitionEvent getDetectedActivity() {
        return this.a;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("activity", Util.getActivityName(this.a.getActivityType()));
            jSONObject.put("confidence", 100);
        } catch (JSONException e) {
            TSLog.logger.error(TSLog.error(e.getMessage()));
            e.printStackTrace();
        }
        return jSONObject;
    }

    public Map<String, Object> toMap() {
        HashMap map = new HashMap();
        map.put("activity", getActivityName());
        map.put("confidence", 100);
        return map;
    }
}
