package com.salesforce.marketingcloud.analytics.piwama;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements c {
    private final Date a;
    private final boolean b;
    private final List<String> c;

    public e(@NotNull Date timestamp, boolean z, @NotNull List<String> objectIds) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(objectIds, "objectIds");
        this.a = timestamp;
        this.b = z;
        this.c = objectIds;
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.c
    public String a() {
        return "app_open";
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.c
    public int b() {
        return 0;
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.c
    public JSONObject c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("open_from_push", this.b);
        if (!this.c.isEmpty()) {
            jSONObject2.put("message_ids", new JSONArray((Collection) this.c));
        }
        Unit unit = Unit.INSTANCE;
        jSONObject.put("details", jSONObject2);
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
