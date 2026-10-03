package com.salesforce.marketingcloud.location;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class f extends com.salesforce.marketingcloud.f {
    public static final String d = "NO_GPS_HARDWARE";
    public static final String e = "RECEIVER_NOT_DECLARED_IN_MANIFEST";
    public static final int f = -1;
    protected static final String g = "com.salesforce.marketingcloud.location.LOCATION_UPDATE";
    protected static final String h = "com.salesforce.marketingcloud.location.GEOFENCE_ERROR";
    protected static final String i = "com.salesforce.marketingcloud.location.GEOFENCE_EVENT";
    protected static final String j = "extra_location";
    protected static final String k = "extra_transition";
    protected static final String l = "extra_fence_ids";
    protected static final String m = "extra_error_code";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected static final String f60n = "extra_error_message";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f61o = "LocationManager";
    static final String p = com.salesforce.marketingcloud.g.a(f61o);

    public abstract void a(c cVar);

    public abstract void a(e eVar);

    public abstract void a(List<String> list);

    public abstract void a(b... bVarArr);

    public boolean a() {
        return false;
    }

    public abstract void b();

    public abstract void b(c cVar);

    public abstract void b(e eVar);

    @Override // com.salesforce.marketingcloud.d
    public final String componentName() {
        return f61o;
    }

    public static Intent a(@NonNull Location location) {
        return new Intent(g).putExtra(j, location);
    }

    public static Intent a(int i2, @NonNull List<String> list, @Nullable Location location) {
        Intent intent = new Intent(i);
        intent.putExtra(k, i2);
        if (list instanceof ArrayList) {
            intent.putStringArrayListExtra(l, (ArrayList) list);
        } else {
            intent.putStringArrayListExtra(l, new ArrayList<>(list));
        }
        if (location != null) {
            intent.putExtra(j, location);
        }
        return intent;
    }

    public static Intent a(int i2, String str) {
        return new Intent(h).putExtra(m, i2).putExtra(f60n, str);
    }

    public static f a(Context context, MarketingCloudConfig marketingCloudConfig) {
        Exception exc;
        boolean zB = com.salesforce.marketingcloud.util.b.b();
        Boolean boolValueOf = null;
        Exception exc2 = null;
        if (zB) {
            boolean zA = LocationReceiver.a(context);
            if (zA) {
                try {
                    return new h(context, marketingCloudConfig);
                } catch (Exception e2) {
                    exc2 = e2;
                    com.salesforce.marketingcloud.g.b(p, exc2, "Unable to create real instance of %s", f61o);
                }
            }
            Exception exc3 = exc2;
            boolValueOf = Boolean.valueOf(zA);
            exc = exc3;
        } else {
            com.salesforce.marketingcloud.g.e(p, "GooglePlayServices Location dependency missing from build.", new Object[0]);
            exc = null;
        }
        return new a(marketingCloudConfig, boolValueOf, zB, exc);
    }

    static JSONObject a(MarketingCloudConfig marketingCloudConfig, Boolean bool, boolean z, Exception exc) {
        JSONObject jSONObjectA = a(marketingCloudConfig);
        try {
            jSONObjectA.put("serviceAvailable", bool);
            jSONObjectA.put("gmsLocationDependencyAvailable", z);
            if (exc != null) {
                jSONObjectA.put("exceptionMessage", exc.getMessage());
            }
        } catch (JSONException e2) {
            com.salesforce.marketingcloud.g.b(p, e2, "Error creating LocationManager state.", new Object[0]);
        }
        return jSONObjectA;
    }

    static JSONObject a(MarketingCloudConfig marketingCloudConfig, int i2, String str) {
        JSONObject jSONObjectA = a(marketingCloudConfig);
        try {
            jSONObjectA.put("apiCode", i2);
            jSONObjectA.put("apiMessage", str);
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.b(p, e2, "Error creating LocationManager state.", new Object[0]);
        }
        return jSONObjectA;
    }

    private static JSONObject a(MarketingCloudConfig marketingCloudConfig) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("geofencingEnabled", marketingCloudConfig.geofencingEnabled());
            jSONObject.put("proximityEnabled", marketingCloudConfig.proximityEnabled());
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.b(p, e2, "Error creating LocationManager state.", new Object[0]);
        }
        return jSONObject;
    }
}
