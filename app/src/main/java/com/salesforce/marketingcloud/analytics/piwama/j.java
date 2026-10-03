package com.salesforce.marketingcloud.analytics.piwama;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.common.net.HttpHeaders;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.messages.RegionMessageManager;
import com.salesforce.marketingcloud.messages.push.PushMessageManager;
import com.salesforce.marketingcloud.registration.RegistrationManager;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
abstract class j {
    static final String c = "YXBpX2tleQ==";
    static final String d = "app_id";
    static final String e = "app_name";
    static final String f = "user_info";
    static final String g = "payload";
    static final String h = "849f26e2-2df6-11e4-ab12-14109fdc48df";
    private static final Map<String, String> i = Collections.unmodifiableMap(new a());
    private static final String j = "device";
    private static final String k = "details";
    private static final String l = "manufacturer";
    private static final String m = "device_id";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f37n = "push_enabled";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f38o = "location";
    private static final String p = "latitude";
    private static final String q = "longitude";
    private static final String r = "platform";
    private static final String s = "platform_version";
    private static final String t = "device_type";
    private static final String u = "email";
    private static final String v = "events";
    final com.salesforce.marketingcloud.storage.h a;
    final MarketingCloudConfig b;

    class a extends ArrayMap {
        a() {
            put(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8");
            put(HttpHeaders.CONNECTION, "close");
        }
    }

    j(@NonNull MarketingCloudConfig marketingCloudConfig, @NonNull com.salesforce.marketingcloud.storage.h hVar) {
        this.b = marketingCloudConfig;
        this.a = hVar;
    }

    com.salesforce.marketingcloud.http.c a(@NonNull RegistrationManager registrationManager, @NonNull PushMessageManager pushMessageManager, @NonNull RegionMessageManager regionMessageManager, @NonNull List<com.salesforce.marketingcloud.analytics.b> list) {
        return com.salesforce.marketingcloud.http.b.j.a(this.b, this.a.c(), b(), a(a(a(registrationManager, pushMessageManager, regionMessageManager, list.get(0).f())), list), i);
    }

    abstract JSONObject a(@NonNull JSONObject jSONObject);

    abstract Object[] b();

    String a(JSONObject jSONObject, List<com.salesforce.marketingcloud.analytics.b> list) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("payload");
        String string = "{}";
        if (jSONObjectOptJSONObject != null) {
            JSONArray jSONArray = new JSONArray();
            for (com.salesforce.marketingcloud.analytics.b bVar : list) {
                try {
                    if (bVar.e() != null) {
                        jSONArray.put(new JSONObject(bVar.e()));
                    }
                } catch (Exception e2) {
                    com.salesforce.marketingcloud.g.b(i.k, e2, "Failed to add the PI AnalyticItem Event to the event list.", new Object[0]);
                }
            }
            if (jSONArray.length() > 0) {
                try {
                    jSONObjectOptJSONObject.put(v, jSONArray);
                    string = jSONObject.toString();
                } catch (Exception e3) {
                    com.salesforce.marketingcloud.g.b(i.k, e3, "Failed to add the PI AnalyticItem Events to the payload.", new Object[0]);
                }
                jSONObjectOptJSONObject.remove(v);
            }
        }
        return string;
    }

    JSONObject a(@NonNull RegistrationManager registrationManager, @NonNull PushMessageManager pushMessageManager, @NonNull RegionMessageManager regionMessageManager, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_id", registrationManager.getDeviceId());
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("email", str);
            }
            jSONObject.put(k, a(pushMessageManager));
            JSONObject jSONObjectA = a(regionMessageManager);
            if (jSONObjectA != null) {
                jSONObject.put("location", jSONObjectA);
            }
            jSONObject.put("device", a());
        } catch (JSONException e2) {
            com.salesforce.marketingcloud.g.b(i.k, e2, "Could not create User Info object.", new Object[0]);
        }
        return jSONObject;
    }

    JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("manufacturer", Build.MANUFACTURER);
        jSONObject.put("platform", "Android");
        jSONObject.put("platform_version", Build.VERSION.RELEASE);
        jSONObject.put(t, Build.MODEL);
        return jSONObject;
    }

    JSONObject a(@NonNull RegionMessageManager regionMessageManager) throws JSONException {
        LatLon latLonE;
        if ((!regionMessageManager.isGeofenceMessagingEnabled() && !regionMessageManager.isProximityMessagingEnabled()) || (latLonE = this.a.m().e(this.a.b())) == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("latitude", latLonE.latitude());
        jSONObject.put("longitude", latLonE.longitude());
        return jSONObject;
    }

    JSONObject a(@NonNull PushMessageManager pushMessageManager) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("push_enabled", pushMessageManager.isPushEnabled());
        return jSONObject;
    }
}
