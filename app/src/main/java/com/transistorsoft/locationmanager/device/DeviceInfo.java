package com.transistorsoft.locationmanager.device;

import android.content.Context;
import android.os.Build;
import com.transistorsoft.locationmanager.a.A;
import com.transistorsoft.locationmanager.logger.TSLog;
import io.sentry.protocol.Device;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DeviceInfo {
    public static final String ACTION_GET_DEVICE_INFO = "getDeviceInfo";
    private static DeviceInfo e = null;
    private static final String f = "Android";
    private String a;
    private final String b = Build.MODEL;
    private final String c = Build.MANUFACTURER;
    private final String d = Build.VERSION.RELEASE;
    private static final String g = A.getPlatform();
    public static String MANUFACTURER_HUAWEI = "Huawei";

    public DeviceInfo(Context context) {
    }

    private static DeviceInfo a(Context context) {
        DeviceInfo deviceInfo;
        synchronized (DeviceInfo.class) {
            if (e == null) {
                e = new DeviceInfo(context.getApplicationContext());
            }
            deviceInfo = e;
        }
        return deviceInfo;
    }

    public static DeviceInfo getInstance(Context context) {
        if (e == null) {
            e = a(context.getApplicationContext());
        }
        return e;
    }

    public String getManufacturer() {
        return this.c;
    }

    public String getModel() {
        return this.b;
    }

    public String getPlatform() {
        return "Android";
    }

    public String getUniqueId() {
        return this.a;
    }

    public String getVersion() {
        return this.d;
    }

    public String print() {
        return this.c + StringUtils.SPACE + this.b + " @ " + this.d + " (" + A.getPlatform() + ")";
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("model", this.b);
            jSONObject.put(Device.JsonKeys.MANUFACTURER, this.c);
            jSONObject.put("version", this.d);
            jSONObject.put("platform", "Android");
            jSONObject.put("framework", g);
        } catch (JSONException e2) {
            TSLog.logger.error(TSLog.error(e2.getMessage()), (Throwable) e2);
        }
        return jSONObject;
    }

    public Map<String, Object> toMap() {
        HashMap map = new HashMap();
        map.put("model", this.b);
        map.put(Device.JsonKeys.MANUFACTURER, this.c);
        map.put("version", this.d);
        map.put("platform", "Android");
        map.put("framework", g);
        return map;
    }
}
