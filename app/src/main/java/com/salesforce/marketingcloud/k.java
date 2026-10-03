package com.salesforce.marketingcloud;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.salesforce.marketingcloud.analytics.l;
import com.salesforce.marketingcloud.internal.n;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class k implements com.salesforce.marketingcloud.e, com.salesforce.marketingcloud.behaviors.b, com.salesforce.marketingcloud.http.e.c, com.salesforce.marketingcloud.alarms.b.InterfaceC0064b {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f58n = "_sync";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f59o = "_nodes";
    private static final String p = g.a("SyncRouteComponent");
    private static final int q = 202;
    protected final MarketingCloudConfig d;
    protected final com.salesforce.marketingcloud.http.e e;
    protected final com.salesforce.marketingcloud.storage.h f;
    protected final String g;
    private final n h;
    private final com.salesforce.marketingcloud.behaviors.c i;
    private final com.salesforce.marketingcloud.alarms.b j;
    private final l k;
    protected Map<e, f> l = new ArrayMap(e.values().length);
    private boolean m;

    class a extends com.salesforce.marketingcloud.internal.i {
        a(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            MarketingCloudSdk.requestSdk(k.this.b());
        }
    }

    class b implements MarketingCloudSdk.WhenReadyListener {
        b() {
        }

        @Override // com.salesforce.marketingcloud.MarketingCloudSdk.WhenReadyListener
        public void ready(@NonNull MarketingCloudSdk marketingCloudSdk) {
            k kVar = k.this;
            kVar.e.a(com.salesforce.marketingcloud.http.b.q.a(kVar.d, kVar.f.c(), com.salesforce.marketingcloud.http.b.b(k.this.d.applicationId(), k.this.g), "{}"));
        }
    }

    class c extends com.salesforce.marketingcloud.internal.i {
        final /* synthetic */ e c;
        final /* synthetic */ JSONObject d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, Object[] objArr, e eVar, JSONObject jSONObject) {
            super(str, objArr);
            this.c = eVar;
            this.d = jSONObject;
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            f fVar = k.this.l.get(this.c);
            if (fVar != null) {
                fVar.onSyncReceived(this.c, this.d);
            }
        }
    }

    static /* synthetic */ class d {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.salesforce.marketingcloud.behaviors.a.values().length];
            a = iArr;
            try {
                iArr[com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_APP_FOREGROUNDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_SDK_PUSH_RECEIVED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public enum e {
        blocked,
        inAppMessages,
        triggers,
        pushFeaturesInUse,
        appConfig
    }

    /* JADX INFO: loaded from: classes3.dex */
    public interface f {
        void onSyncReceived(@NonNull e eVar, @NonNull JSONObject jSONObject);
    }

    k(String str, MarketingCloudConfig marketingCloudConfig, com.salesforce.marketingcloud.storage.h hVar, com.salesforce.marketingcloud.http.e eVar, com.salesforce.marketingcloud.behaviors.c cVar, com.salesforce.marketingcloud.alarms.b bVar, n nVar, l lVar) {
        this.g = str;
        this.d = marketingCloudConfig;
        this.f = hVar;
        this.i = cVar;
        this.e = eVar;
        this.j = bVar;
        this.h = nVar;
        this.k = lVar;
    }

    public static boolean a(@NonNull Map<String, String> map) {
        return map.containsKey(f58n) || map.containsKey(f59o);
    }

    private boolean c() {
        return !this.m;
    }

    MarketingCloudSdk.WhenReadyListener b() {
        return new b();
    }

    @Override // com.salesforce.marketingcloud.d
    public String componentName() {
        return "SyncRoute";
    }

    @Override // com.salesforce.marketingcloud.d
    public JSONObject componentState() {
        return null;
    }

    @Override // com.salesforce.marketingcloud.e
    public void controlChannelInit(int i) {
        if (com.salesforce.marketingcloud.b.a(i, com.salesforce.marketingcloud.b.c.RTBF.b)) {
            this.i.a(this);
            this.e.a(com.salesforce.marketingcloud.http.b.q);
            com.salesforce.marketingcloud.alarms.b bVar = this.j;
            com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a = com.salesforce.marketingcloud.alarms.a.EnumC0062a.h;
            bVar.e(enumC0062a);
            this.j.d(enumC0062a);
            this.m = true;
        }
    }

    @Override // com.salesforce.marketingcloud.e
    public void init(@NonNull InitializationStatus.a aVar, int i) {
        if (com.salesforce.marketingcloud.b.a(i, com.salesforce.marketingcloud.b.c.RTBF.b)) {
            this.m = true;
            return;
        }
        this.e.a(com.salesforce.marketingcloud.http.b.q, this);
        this.i.a(this, EnumSet.of(com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_APP_FOREGROUNDED, com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_SDK_PUSH_RECEIVED));
        this.j.a(this, com.salesforce.marketingcloud.alarms.a.EnumC0062a.h);
    }

    @Override // com.salesforce.marketingcloud.behaviors.b
    public void onBehavior(@NonNull com.salesforce.marketingcloud.behaviors.a aVar, @NonNull Bundle bundle) {
        int i = d.a[aVar.ordinal()];
        if (i == 1) {
            a();
            return;
        }
        if (i != 2) {
            return;
        }
        if (bundle.containsKey(f58n)) {
            a();
        } else if (bundle.containsKey(f59o)) {
            a(bundle.getString(f59o));
        }
    }

    @Override // com.salesforce.marketingcloud.d
    public void tearDown(boolean z) {
        this.i.a(this);
        this.e.a(com.salesforce.marketingcloud.http.b.q);
        com.salesforce.marketingcloud.alarms.b bVar = this.j;
        com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a = com.salesforce.marketingcloud.alarms.a.EnumC0062a.h;
        bVar.e(enumC0062a);
        if (z) {
            this.j.d(enumC0062a);
        }
    }

    public void a(e eVar, f fVar) {
        f fVar2 = this.l.get(eVar);
        if (fVar2 == null || fVar == null || fVar2 == fVar) {
            this.l.put(eVar, fVar);
        } else {
            g.e(p, "Node %s already assigned to listener %s.  %s was not added for the Node.", eVar, fVar2, fVar);
        }
    }

    public void a(@NonNull EnumSet<e> enumSet, f fVar) {
        Iterator<e> it2 = enumSet.iterator();
        while (it2.hasNext()) {
            a(it2.next(), fVar);
        }
    }

    @Override // com.salesforce.marketingcloud.alarms.b.InterfaceC0064b
    public void a(@NonNull com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a) {
        if (enumC0062a == com.salesforce.marketingcloud.alarms.a.EnumC0062a.h) {
            a();
        }
    }

    private void a(String str) {
        if (str != null) {
            try {
                a(new JSONArray(str));
            } catch (Exception e2) {
                g.b(p, e2, "Failed to parse sync push message", new Object[0]);
            }
        }
    }

    private void a() {
        if (c()) {
            this.h.b().execute(new a("attempt_sync_route_request", new Object[0]));
        }
    }

    @Override // com.salesforce.marketingcloud.http.e.c
    public void a(com.salesforce.marketingcloud.http.c cVar, com.salesforce.marketingcloud.http.f fVar) {
        if (fVar.p()) {
            this.j.d(com.salesforce.marketingcloud.alarms.a.EnumC0062a.h);
            com.salesforce.marketingcloud.http.b.a(fVar.m(), this.f.c());
            a(fVar.q());
            try {
                JSONArray jSONArray = new JSONObject(fVar.j()).getJSONArray("nodes");
                if (jSONArray != null) {
                    a(jSONArray, fVar.k());
                    return;
                }
                return;
            } catch (Exception e2) {
                g.b(p, e2, "Failed to parse /sync route response", new Object[0]);
                return;
            }
        }
        this.j.b(com.salesforce.marketingcloud.alarms.a.EnumC0062a.h);
        g.b(p, "Sync route request failed with message: %s", fVar.n());
    }

    private void a(long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            l.a aVar = l.a.SYNC_API;
            jSONObject.put(aVar.b(), j);
            if (com.salesforce.marketingcloud.config.a.g() == null || !com.salesforce.marketingcloud.config.a.g().n()) {
                return;
            }
            this.k.a(aVar, jSONObject);
        } catch (JSONException e2) {
            g.b(p, e2, "Failed to log TelemetryEvent for Sync Route", new Object[0]);
        }
    }

    private void a(@NonNull JSONArray jSONArray) throws JSONException {
        a(jSONArray, 202);
    }

    private void a(@NonNull JSONArray jSONArray, int i) throws JSONException {
        String strOptString;
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            try {
                strOptString = jSONObject.optString("name");
                try {
                    e eVarValueOf = e.valueOf(strOptString);
                    if (i != 202 || eVarValueOf == e.appConfig || eVarValueOf == e.blocked) {
                        this.h.a().execute(new c(strOptString + "-sync_node_process", new Object[0], eVarValueOf, jSONObject));
                    }
                } catch (Exception unused) {
                    g.a(p, "Failed to process node %s sync route", strOptString);
                }
            } catch (Exception unused2) {
                strOptString = null;
            }
        }
    }
}
