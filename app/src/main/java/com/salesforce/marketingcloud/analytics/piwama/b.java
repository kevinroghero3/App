package com.salesforce.marketingcloud.analytics.piwama;

import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements c {
    private final Date a;

    public b(@NotNull Date timestamp) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        this.a = timestamp;
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.c
    public String a() {
        return "app_close";
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.c
    public int b() {
        return 0;
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.c
    public JSONObject c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject);
        return jSONObject;
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.c
    public String d() {
        return "track_event";
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.c
    public Date e() {
        return this.a;
    }
}
