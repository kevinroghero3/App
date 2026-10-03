package com.salesforce.marketingcloud.analytics.piwama;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.salesforce.marketingcloud.analytics.PiOrder;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class g implements c {
    private final PiOrder a;
    private final Date b;

    public g(@NotNull PiOrder piOrder, @NotNull Date timestamp) {
        Intrinsics.checkNotNullParameter(piOrder, "piOrder");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        this.a = piOrder;
        this.b = timestamp;
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.c
    public String a() {
        return "";
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.c
    public int b() {
        return com.salesforce.marketingcloud.analytics.b.p;
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.c
    public JSONObject c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject);
        PiOrder piOrder = this.a;
        jSONObject.put(FirebaseAnalytics.Param.SHIPPING, piOrder.shipping);
        jSONObject.put("order_number", piOrder.orderNumber);
        jSONObject.put(FirebaseAnalytics.Param.DISCOUNT, piOrder.discount);
        jSONObject.put("cart", piOrder.cart.toJson$sdk_release());
        return jSONObject;
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.c
    public String d() {
        return "track_conversion";
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.c
    public Date e() {
        return this.b;
    }
}
