package com.transistorsoft.locationmanager.event;

import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.locationmanager.util.Util;
import io.sentry.protocol.Response;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AuthorizationEvent {
    private int a;
    private JSONObject b;
    private String c;

    public AuthorizationEvent(int i, String str) {
        this.a = i;
        this.c = str;
    }

    public String getError() {
        return this.c;
    }

    public JSONObject getResponse() {
        return this.b;
    }

    public int getStatusCode() {
        return this.a;
    }

    public boolean isSuccessful() {
        return this.c == null && this.b != null;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", this.a);
            jSONObject.put("success", isSuccessful());
            jSONObject.put("error", this.c);
            jSONObject.put(Response.TYPE, this.b);
        } catch (JSONException e) {
            TSLog.logger.error(TSLog.error(e.getMessage()), (Throwable) e);
        }
        return jSONObject;
    }

    public Map<String, Object> toMap() {
        HashMap map = new HashMap();
        map.put("status", Integer.valueOf(this.a));
        map.put("error", this.c);
        map.put("success", Boolean.valueOf(isSuccessful()));
        map.put(Response.TYPE, null);
        JSONObject jSONObject = this.b;
        if (jSONObject != null) {
            try {
                map.put(Response.TYPE, Util.toMap(jSONObject));
            } catch (JSONException e) {
                TSLog.logger.error(TSLog.error(e.getMessage()), (Throwable) e);
            }
        }
        return map;
    }

    public AuthorizationEvent(int i, JSONObject jSONObject) {
        this.a = i;
        this.b = jSONObject;
    }
}
