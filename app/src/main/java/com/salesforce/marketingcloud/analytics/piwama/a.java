package com.salesforce.marketingcloud.analytics.piwama;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.extensions.PushExtensionsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class a extends j {
    private static final Object[] w = {""};

    a(@NonNull MarketingCloudConfig marketingCloudConfig, @NonNull com.salesforce.marketingcloud.storage.h hVar) {
        super(marketingCloudConfig, hVar);
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.j
    JSONObject a(@NonNull JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(PushExtensionsKt.base64Decode(com.salesforce.marketingcloud.a.d), "849f26e2-2df6-11e4-ab12-14109fdc48df");
            jSONObject2.put("app_id", this.b.applicationId());
            String strB = this.a.c().b(com.salesforce.marketingcloud.storage.b.g, null);
            if (!TextUtils.isEmpty(strB)) {
                jSONObject2.put("user_id", strB);
            }
            String strB2 = this.a.c().b(com.salesforce.marketingcloud.storage.b.f, null);
            if (!TextUtils.isEmpty(strB2)) {
                jSONObject2.put(SDKAnalyticsEvents.PARAMETER_SESSION_ID, strB2);
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("app_name", this.b.appPackageName());
            jSONObject3.put("user_info", jSONObject);
            jSONObject2.put("payload", jSONObject3);
            return jSONObject2;
        } catch (JSONException e) {
            com.salesforce.marketingcloud.g.b(i.k, e, "Failed to construct PiWama payload JSON Object.", new Object[0]);
            return new JSONObject();
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.j
    Object[] b() {
        return w;
    }
}
