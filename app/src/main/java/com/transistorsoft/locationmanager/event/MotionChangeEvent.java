package com.transistorsoft.locationmanager.event;

import com.transistorsoft.locationmanager.location.TSLocation;
import com.transistorsoft.locationmanager.logger.TSLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MotionChangeEvent {
    public Boolean isMoving;
    public JSONObject json;
    public TSLocation location;

    public MotionChangeEvent(TSLocation tSLocation) {
        this.location = tSLocation;
    }

    public Boolean getIsMoving() {
        return Boolean.valueOf(this.location.getIsMoving());
    }

    public TSLocation getLocation() {
        return this.location;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("location", this.location.toJson());
            jSONObject.put("isMoving", this.location.getIsMoving());
        } catch (JSONException e) {
            TSLog.logger.debug(TSLog.error(e.getMessage()));
        }
        return jSONObject;
    }
}
