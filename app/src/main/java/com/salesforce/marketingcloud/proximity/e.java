package com.salesforce.marketingcloud.proximity;

import android.content.Context;
import androidx.annotation.NonNull;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.f;
import com.salesforce.marketingcloud.g;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class e extends f {
    public static final String d = "com.salesforce.marketingcloud.proximity.BEACON_REGION_ENTERED";
    public static final String e = "com.salesforce.marketingcloud.proximity.BEACON_REGION_EXITED";
    public static final String f = "beaconRegion";
    private static final String g = "ProximityManager";
    protected static final String h = g.a(g);

    /* JADX INFO: loaded from: classes3.dex */
    public interface a {
        void a(@NonNull c cVar);

        void b(@NonNull c cVar);
    }

    public static e a(Context context, MarketingCloudConfig marketingCloudConfig) {
        String message;
        boolean zA = a(context);
        Boolean bool = null;
        if (!zA) {
            message = null;
        } else if (com.salesforce.marketingcloud.util.b.a()) {
            try {
                return new b(context, marketingCloudConfig.proximityNotificationCustomizationOptions());
            } catch (IllegalStateException e2) {
                message = e2.getMessage();
                g.b(h, e2, "Unable to create real instance of %s", g);
            }
        } else {
            Boolean bool2 = Boolean.FALSE;
            g.e(h, "If you wish to use proximity messenger then you need to add the AltBeacon dependency.", new Object[0]);
            message = null;
            bool = bool2;
        }
        return new d(marketingCloudConfig.proximityEnabled(), a(marketingCloudConfig.proximityEnabled(), Boolean.valueOf(zA), bool, message));
    }

    public abstract void a(@NonNull a aVar);

    public abstract void a(List<c> list);

    public abstract void b(@NonNull a aVar);

    public abstract void b(List<c> list);

    public boolean b() {
        return false;
    }

    public abstract void c();

    @Override // com.salesforce.marketingcloud.d
    public final String componentName() {
        return g;
    }

    protected static boolean a(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    protected static JSONObject a(boolean z, Boolean bool, Boolean bool2, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject = a(jSONObject, z);
            jSONObject.put("hardwareAvailable", bool);
            jSONObject.put("libraryDeclared", bool2);
            if (str != null) {
                jSONObject.put("serviceMissing", str);
            }
        } catch (JSONException e2) {
            g.b(h, e2, "Error creating fake ProximityManager state.", new Object[0]);
        }
        return jSONObject;
    }

    protected static JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, true);
        return jSONObject;
    }

    private static JSONObject a(JSONObject jSONObject, boolean z) throws JSONException {
        jSONObject.put("proximityEnabled", z);
        return jSONObject;
    }
}
