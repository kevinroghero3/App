package com.transistorsoft.locationmanager.device;

import android.os.Build;
import io.sentry.protocol.Device;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DeviceSettingsRequest {
    private String a;
    private String b;
    private String c;
    private boolean d;
    private long e;
    private String f;

    public DeviceSettingsRequest(String str) {
        this.d = false;
        this.e = 0L;
        this.a = Build.MANUFACTURER;
        this.b = Build.MODEL;
        this.c = Build.VERSION.RELEASE;
        this.f = str;
    }

    public String getAction() {
        return this.f;
    }

    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Device.JsonKeys.MANUFACTURER, this.a);
        jSONObject.put("model", this.b);
        jSONObject.put("version", this.c);
        jSONObject.put("seen", this.d);
        jSONObject.put("lastSeenAt", this.e);
        jSONObject.put("action", this.f);
        return jSONObject;
    }

    public Map<String, Object> toMap() {
        HashMap map = new HashMap();
        map.put(Device.JsonKeys.MANUFACTURER, this.a);
        map.put("model", this.b);
        map.put("version", this.c);
        map.put("seen", Boolean.valueOf(this.d));
        map.put("lastSeenAt", Long.valueOf(this.e));
        map.put("action", this.f);
        return map;
    }

    public DeviceSettingsRequest(String str, long j) {
        this.d = false;
        this.e = 0L;
        this.a = Build.MANUFACTURER;
        this.b = Build.MODEL;
        this.c = Build.VERSION.RELEASE;
        this.e = j;
        this.d = j > 0;
        this.f = str;
    }
}
