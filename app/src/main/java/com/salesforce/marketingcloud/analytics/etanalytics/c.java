package com.salesforce.marketingcloud.analytics.etanalytics;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.analytics.AnalyticsManager;
import com.salesforce.marketingcloud.g;
import com.salesforce.marketingcloud.http.e;
import com.salesforce.marketingcloud.http.f;
import com.salesforce.marketingcloud.internal.i;
import com.salesforce.marketingcloud.internal.n;
import com.salesforce.marketingcloud.storage.h;
import com.salesforce.marketingcloud.util.j;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class c implements e.c, com.salesforce.marketingcloud.alarms.b.InterfaceC0064b {
    private static final int j = 256000;
    private static final int k = 999;
    private static final int l = 50;
    final MarketingCloudConfig d;
    final String e;
    final h f;
    final e g;
    final com.salesforce.marketingcloud.alarms.b h;
    private final n i;

    class a extends i {
        final /* synthetic */ int c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Object[] objArr, int i) {
            super(str, objArr);
            this.c = i;
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            try {
                List<com.salesforce.marketingcloud.analytics.b> listB = c.this.f.h().b(c.this.f.b(), this.c);
                if (listB.isEmpty()) {
                    c.this.h.d(com.salesforce.marketingcloud.alarms.a.EnumC0062a.d);
                    return;
                }
                com.salesforce.marketingcloud.http.b bVar = com.salesforce.marketingcloud.http.b.i;
                c cVar = c.this;
                MarketingCloudConfig marketingCloudConfig = cVar.d;
                com.salesforce.marketingcloud.storage.b bVarC = cVar.f.c();
                c cVar2 = c.this;
                com.salesforce.marketingcloud.http.c cVarA = bVar.a(marketingCloudConfig, bVarC, cVar2.a(cVar2.d.applicationId(), c.this.e, listB).toString());
                cVarA.a(com.salesforce.marketingcloud.analytics.c.a(listB));
                int iA = com.salesforce.marketingcloud.http.a.a.a(cVarA);
                if (iA <= c.j) {
                    g.d(AnalyticsManager.TAG, "Analytics sent with batch size %d.", Integer.valueOf(this.c));
                    c.this.g.a(cVarA);
                    return;
                }
                String str = AnalyticsManager.TAG;
                g.e(str, "Bundle size of %d bytes is too large:. Reducing send batch size.", Integer.valueOf(iA));
                if (this.c <= 50) {
                    g.b(str, "Batch size already at or below minimum, cannot reduce further. Analytics not sent.", new Object[0]);
                    return;
                }
                int size = listB.size();
                int i = this.c;
                c.this.a((int) ((size < i ? listB.size() : i) * 0.66f));
            } catch (Exception e) {
                g.b(AnalyticsManager.TAG, e, "Failed to send analytics", new Object[0]);
            }
        }
    }

    public c(MarketingCloudConfig marketingCloudConfig, String str, h hVar, e eVar, com.salesforce.marketingcloud.alarms.b bVar, @NonNull n nVar) {
        this.d = (MarketingCloudConfig) com.salesforce.marketingcloud.util.g.a(marketingCloudConfig, "Config is null");
        this.e = (String) com.salesforce.marketingcloud.util.g.a(str, "DeviceId is null");
        this.f = (h) com.salesforce.marketingcloud.util.g.a(hVar, "MCStorage is null");
        this.g = (e) com.salesforce.marketingcloud.util.g.a(eVar, "RequestManager is null");
        this.h = (com.salesforce.marketingcloud.alarms.b) com.salesforce.marketingcloud.util.g.a(bVar, "AlarmScheduler is null");
        this.i = nVar;
        eVar.a(com.salesforce.marketingcloud.http.b.i, this);
        bVar.a(this, com.salesforce.marketingcloud.alarms.a.EnumC0062a.d);
    }

    @Override // com.salesforce.marketingcloud.http.e.c
    public void a(com.salesforce.marketingcloud.http.c cVar, f fVar) {
        if (fVar.p()) {
            this.h.c(com.salesforce.marketingcloud.alarms.a.EnumC0062a.d);
            if (cVar.r() != null) {
                this.i.b().execute(new com.salesforce.marketingcloud.analytics.d(this.f.h(), com.salesforce.marketingcloud.analytics.c.a(cVar.r())));
                return;
            }
            return;
        }
        String str = AnalyticsManager.TAG;
        int iK = fVar.k();
        g.c(str, "Request failed: %d - %s", Integer.valueOf(iK), fVar.n());
        this.h.b(com.salesforce.marketingcloud.alarms.a.EnumC0062a.d);
    }

    public void b() {
        this.g.a(com.salesforce.marketingcloud.http.b.i);
        com.salesforce.marketingcloud.alarms.b bVar = this.h;
        com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a = com.salesforce.marketingcloud.alarms.a.EnumC0062a.d;
        bVar.d(enumC0062a);
        this.h.e(enumC0062a);
    }

    @Override // com.salesforce.marketingcloud.alarms.b.InterfaceC0064b
    public void a(@NonNull com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a) {
        if (enumC0062a == com.salesforce.marketingcloud.alarms.a.EnumC0062a.d) {
            a();
        }
    }

    public void a() {
        a(999);
    }

    public void a(int i) {
        this.i.b().execute(new a("send_analytics", new Object[0], i));
    }

    JSONArray a(String str, String str2, List<com.salesforce.marketingcloud.analytics.b> list) {
        JSONArray jSONArray = new JSONArray();
        for (com.salesforce.marketingcloud.analytics.b bVar : list) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.salesforce.marketingcloud.analytics.b.v, str);
                jSONObject.put("deviceId", str2);
                jSONObject.put(com.salesforce.marketingcloud.analytics.b.x, j.a(bVar.b()));
                jSONObject.put("value", bVar.g());
                jSONObject.put(com.salesforce.marketingcloud.analytics.b.z, new JSONArray((Collection) Collections.singletonList(Integer.valueOf(bVar.a()))));
                jSONObject.put(com.salesforce.marketingcloud.analytics.b.A, new JSONArray((Collection) bVar.i()));
                String strC = bVar.c();
                if (!TextUtils.isEmpty(strC)) {
                    JSONObject jSONObject2 = new JSONObject(strC);
                    String strOptString = jSONObject2.optString("uuid");
                    if (!TextUtils.isEmpty(strOptString)) {
                        jSONObject.put("uuid", strOptString);
                    }
                    String strOptString2 = jSONObject2.optString("requestId");
                    if (!TextUtils.isEmpty(strOptString2)) {
                        jSONObject.put("requestId", strOptString2);
                    }
                    JSONObject jSONObject3 = jSONObject2.optJSONObject(com.salesforce.marketingcloud.analytics.b.u) != null ? jSONObject2.getJSONObject(com.salesforce.marketingcloud.analytics.b.u) : new JSONObject();
                    jSONObject3.put("platform", "Android");
                    jSONObject.put(com.salesforce.marketingcloud.analytics.b.u, jSONObject3);
                }
                jSONArray.put(jSONObject);
            } catch (Exception e) {
                g.b(AnalyticsManager.TAG, e, "Failed to update EtAnalyticItem or convert it to JSON for transmission.", new Object[0]);
            }
        }
        return jSONArray;
    }
}
