package com.salesforce.marketingcloud.config;

import android.content.SharedPreferences;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.analytics.m;
import com.salesforce.marketingcloud.extensions.PushExtensionsKt;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a extends com.salesforce.marketingcloud.f implements com.salesforce.marketingcloud.k.f {
    private static final String A = "maxDisplay";
    private static final String B = "timeBetweenDisplaySec";
    private static final String C = "invalidConfigurationKey";
    private static final String D = "invalidConfigurationValue";
    private static final String E = "event";
    private static final String F = "activeEvents";
    private static final String G = "enableEngagementEvents";
    private static final String H = "enableSystemEvents";
    private static final String I = "enableAppEvents";
    private static final String J = "enableIdentityEvents";
    private static final String K = "enableDebugInfo";
    private static final String L = "enableTelemetryInfo";
    private static final String M = "endpoints";
    private static final String N = "deliveryReceipt";
    private static final String O = "deliveryReceiptStatus";
    private static final String P = "gateDeliveryReceiptProcessingMs";
    private static final String Q = "dataTypes";
    private static final int R = 999;
    private static final String S = "version";
    private static a T = null;
    public static final C0071a d = new C0071a(null);
    public static final String e = "correlationIds";
    public static final String f = "gateEventProcessingMs";
    public static final int g = 0;
    public static final String h = "eventName";
    public static final String i = "endpoint";
    public static final String j = "path";
    public static final String k = "maxBatchSize";
    public static final int l = 0;
    public static final int m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f49n = 10000;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final EnumSet<com.salesforce.marketingcloud.k.e> f50o;
    private static final Object p;
    private static final String q = "~!ConfigComponent";
    private static final int r = 1;
    private static final boolean s = true;
    private static final boolean t = false;
    private static final boolean u = false;
    private static final boolean v = false;
    private static final boolean w = false;
    private static final boolean x = false;
    private static final String y = "items";
    private static final String z = "inApp";
    private final com.salesforce.marketingcloud.k U;
    private final com.salesforce.marketingcloud.storage.h V;
    private final m W;
    private Map<String, com.salesforce.marketingcloud.config.b> X;
    private Boolean Y;
    private Boolean Z;
    private Boolean a0;
    private Boolean b0;
    private Boolean c0;
    private Boolean d0;
    private Map<String, String> e0;
    private Integer f0;
    private Integer g0;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.config.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes3.dex */
    public static final class C0071a {
        public /* synthetic */ C0071a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void b() {
        }

        public final a a() {
            return a.T;
        }

        public final Object c() {
            return a.p;
        }

        public final EnumSet<com.salesforce.marketingcloud.k.e> d() {
            return a.f50o;
        }

        private C0071a() {
        }

        public final void a(@Nullable a aVar) {
            a.T = aVar;
        }
    }

    static final class b extends Lambda implements Function0<String> {
        public static final b b = new b();

        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Unable to generate complete SDK state output for component.";
        }
    }

    static final class c extends Lambda implements Function0<String> {
        public static final c b = new c();

        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Failed to parse [New Events Config] sync data";
        }
    }

    static final class d extends Lambda implements Function0<String> {
        public static final d b = new d();

        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Failed to parse [Endpoint Config] sync data.";
        }
    }

    static final class e extends Lambda implements Function0<String> {
        public static final e b = new e();

        e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Failed to parse [Event Config] sync data";
        }
    }

    static final class f extends Lambda implements Function0<String> {
        public static final f b = new f();

        f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Failed to parse [InApp Config] sync data";
        }
    }

    static final class g extends Lambda implements Function0<String> {
        final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(String str) {
            super(0);
            this.b = str;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Unknown endpoint '" + this.b + "' in config.";
        }
    }

    static final class h extends Lambda implements Function0<String> {
        public static final h b = new h();

        h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Failed to parse endpoint from sync response.";
        }
    }

    static final class i extends Lambda implements Function0<String> {
        public static final i b = new i();

        i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Unable to handle sync payload due to version mismatch";
        }
    }

    static final class j extends Lambda implements Function0<String> {
        public static final j b = new j();

        j() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Could not process [AppConfig Node] from Sync.";
        }
    }

    static final class k extends Lambda implements Function0<String> {
        final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(String str) {
            super(0);
            this.b = str;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Failed to log analytics for InvalidConfig [" + this.b + "]";
        }
    }

    static {
        EnumSet<com.salesforce.marketingcloud.k.e> enumSetOf = EnumSet.of(com.salesforce.marketingcloud.k.e.appConfig);
        Intrinsics.checkNotNullExpressionValue(enumSetOf, "of(...)");
        f50o = enumSetOf;
        p = new Object();
    }

    public a(@NotNull com.salesforce.marketingcloud.k syncRouteComponent, @NotNull com.salesforce.marketingcloud.storage.h storage, @NotNull m triggerAnalytics) {
        Intrinsics.checkNotNullParameter(syncRouteComponent, "syncRouteComponent");
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(triggerAnalytics, "triggerAnalytics");
        this.U = syncRouteComponent;
        this.V = storage;
        this.W = triggerAnalytics;
        T = this;
    }

    public static final void b(@Nullable a aVar) {
        d.a(aVar);
    }

    public static final a g() {
        return d.a();
    }

    @Override // com.salesforce.marketingcloud.d
    public String componentName() {
        return "ConfigComponent";
    }

    @Override // com.salesforce.marketingcloud.d
    public JSONObject componentState() {
        JSONObject jSONObject = new JSONObject();
        synchronized (p) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(G, this.V.e().getBoolean(G, true));
                jSONObject2.put(H, this.V.e().getBoolean(H, false));
                jSONObject2.put(I, this.V.e().getBoolean(I, false));
                jSONObject2.put(J, this.V.e().getBoolean(J, false));
                jSONObject2.put(L, this.V.e().getBoolean(L, false));
                jSONObject2.put(K, this.V.e().getBoolean(K, false));
                Map<String, String> mapEmptyMap = this.e0;
                if (mapEmptyMap == null) {
                    mapEmptyMap = MapsKt__MapsKt.emptyMap();
                }
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, String> entry : mapEmptyMap.entrySet()) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(h, entry.getKey());
                    String value = entry.getValue();
                    if (value != null) {
                        jSONObject3.put(e, value);
                    }
                    jSONArray.put(jSONObject3);
                }
                Unit unit = Unit.INSTANCE;
                jSONObject2.put(F, jSONArray);
                jSONObject.put("event", jSONObject2);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(f, this.V.e().getInt(f, 0));
                jSONObject4.put(A, this.V.e().getInt(A, Integer.MAX_VALUE));
                jSONObject4.put(B, this.V.e().getInt(B, 0));
                jSONObject.put(z, jSONObject4);
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put(O, this.V.e().getInt(O, 0));
                jSONObject5.put(P, this.V.e().getInt(P, 10000));
                jSONObject.put(N, jSONObject5);
                Map<String, com.salesforce.marketingcloud.config.b> mapEmptyMap2 = this.X;
                if (mapEmptyMap2 == null) {
                    mapEmptyMap2 = MapsKt__MapsKt.emptyMap();
                }
                jSONObject.put(M, PushExtensionsKt.toJSONArray(mapEmptyMap2));
            } catch (Exception unused) {
                com.salesforce.marketingcloud.g.e(com.salesforce.marketingcloud.g.a, q, null, b.b, 2, null);
            }
            Unit unit2 = Unit.INSTANCE;
        }
        return jSONObject;
    }

    public final Map<String, String> d() {
        return this.e0;
    }

    public final int e() {
        int iIntValue;
        synchronized (p) {
            Integer num = this.g0;
            if (num != null) {
                iIntValue = num.intValue();
            } else {
                iIntValue = this.V.e().getInt(P, 10000);
                this.g0 = Integer.valueOf(iIntValue);
            }
        }
        return iIntValue;
    }

    public final int f() {
        int iIntValue;
        synchronized (p) {
            Integer num = this.f0;
            if (num != null) {
                iIntValue = num.intValue();
            } else {
                iIntValue = this.V.e().getInt(O, 0);
                this.f0 = Integer.valueOf(iIntValue);
            }
        }
        return iIntValue;
    }

    public final boolean i() {
        boolean zBooleanValue;
        synchronized (p) {
            Boolean bool = this.a0;
            if (bool != null) {
                zBooleanValue = bool.booleanValue();
            } else {
                zBooleanValue = this.V.e().getBoolean(I, false);
                this.a0 = Boolean.valueOf(zBooleanValue);
            }
        }
        return zBooleanValue;
    }

    public final boolean j() {
        boolean zBooleanValue;
        synchronized (p) {
            Boolean bool = this.d0;
            if (bool != null) {
                zBooleanValue = bool.booleanValue();
            } else {
                zBooleanValue = this.V.e().getBoolean(K, false);
                this.d0 = Boolean.valueOf(zBooleanValue);
            }
        }
        return zBooleanValue;
    }

    public final boolean k() {
        boolean zBooleanValue;
        synchronized (p) {
            Boolean bool = this.Y;
            if (bool != null) {
                zBooleanValue = bool.booleanValue();
            } else {
                zBooleanValue = this.V.e().getBoolean(G, true);
                this.Y = Boolean.valueOf(zBooleanValue);
            }
        }
        return zBooleanValue;
    }

    public final boolean l() {
        boolean zBooleanValue;
        synchronized (p) {
            Boolean bool = this.b0;
            if (bool != null) {
                zBooleanValue = bool.booleanValue();
            } else {
                zBooleanValue = this.V.e().getBoolean(J, false);
                this.b0 = Boolean.valueOf(zBooleanValue);
            }
        }
        return zBooleanValue;
    }

    public final boolean m() {
        boolean zBooleanValue;
        synchronized (p) {
            Boolean bool = this.Z;
            if (bool != null) {
                zBooleanValue = bool.booleanValue();
            } else {
                zBooleanValue = this.V.e().getBoolean(H, false);
                this.Z = Boolean.valueOf(zBooleanValue);
            }
        }
        return zBooleanValue;
    }

    public final boolean n() {
        boolean zBooleanValue;
        synchronized (p) {
            Boolean bool = this.c0;
            if (bool != null) {
                zBooleanValue = bool.booleanValue();
            } else {
                zBooleanValue = this.V.e().getBoolean(L, false);
                this.c0 = Boolean.valueOf(zBooleanValue);
            }
        }
        return zBooleanValue;
    }

    @Override // com.salesforce.marketingcloud.k.f
    public void onSyncReceived(@NotNull com.salesforce.marketingcloud.k.e node, @NotNull JSONObject data) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(data, "data");
        if (f50o.contains(node)) {
            if (data.optInt("version") != 1) {
                com.salesforce.marketingcloud.g.b(com.salesforce.marketingcloud.g.a, q, null, i.b, 2, null);
                return;
            }
            try {
                if (node == com.salesforce.marketingcloud.k.e.appConfig) {
                    d(data);
                }
            } catch (Throwable th) {
                com.salesforce.marketingcloud.g.a.b(q, th, j.b);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.f, com.salesforce.marketingcloud.d
    public void tearDown(boolean z2) {
        this.U.a(f50o, (com.salesforce.marketingcloud.k.f) null);
        T = null;
    }

    private final void c(JSONObject jSONObject) {
        synchronized (p) {
            try {
                int iOptInt = jSONObject.optInt(f, 0);
                int iOptInt2 = jSONObject.optInt(A, Integer.MAX_VALUE);
                int iOptInt3 = jSONObject.optInt(B, 0);
                SharedPreferences.Editor editorEdit = this.V.e().edit();
                Intrinsics.checkNotNullExpressionValue(editorEdit, "edit(...)");
                if (iOptInt >= 0) {
                    editorEdit.putInt(com.salesforce.marketingcloud.events.c.r, iOptInt);
                }
                if (iOptInt2 >= 0) {
                    editorEdit.putInt(com.salesforce.marketingcloud.events.c.s, iOptInt2);
                }
                if (iOptInt3 >= 0) {
                    editorEdit.putInt(com.salesforce.marketingcloud.events.c.t, iOptInt3);
                }
                editorEdit.apply();
                if (iOptInt < 0) {
                    a(f, String.valueOf(iOptInt));
                }
                if (iOptInt2 < 0) {
                    a(A, String.valueOf(iOptInt2));
                }
                if (iOptInt3 < 0) {
                    a(B, String.valueOf(iOptInt3));
                }
            } catch (Exception e2) {
                com.salesforce.marketingcloud.g.a.b(q, e2, f.b);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final Map<String, String> h() {
        return PushExtensionsKt.toMap(new JSONArray(this.V.e().getString(F, new JSONArray().toString())));
    }

    public final void d(@NotNull JSONObject data) {
        Intrinsics.checkNotNullParameter(data, "data");
        JSONObject jSONObjectOptJSONObject = data.optJSONObject("items");
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("event");
        if (jSONObjectOptJSONObject2 == null) {
            jSONObjectOptJSONObject2 = new JSONObject();
        } else {
            Intrinsics.checkNotNull(jSONObjectOptJSONObject2);
        }
        b(jSONObjectOptJSONObject2);
        JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject(z);
        if (jSONObjectOptJSONObject3 == null) {
            jSONObjectOptJSONObject3 = new JSONObject();
        } else {
            Intrinsics.checkNotNull(jSONObjectOptJSONObject3);
        }
        c(jSONObjectOptJSONObject3);
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(M);
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
        } else {
            Intrinsics.checkNotNull(jSONArrayOptJSONArray);
        }
        a(jSONArrayOptJSONArray);
        JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject.optJSONObject(N);
        if (jSONObjectOptJSONObject4 == null) {
            jSONObjectOptJSONObject4 = new JSONObject();
        } else {
            Intrinsics.checkNotNull(jSONObjectOptJSONObject4);
        }
        a(jSONObjectOptJSONObject4);
    }

    @Override // com.salesforce.marketingcloud.f
    public void a(@NotNull InitializationStatus.a statusBuilder) {
        Intrinsics.checkNotNullParameter(statusBuilder, "statusBuilder");
        this.U.a(f50o, this);
    }

    public final boolean b(@NotNull String eventName) {
        boolean zContainsKey;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        synchronized (p) {
            Map<String, String> map = this.e0;
            if (map != null) {
                String lowerCase = eventName.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                zContainsKey = map.containsKey(lowerCase);
            } else {
                Map<String, String> mapH = h();
                this.e0 = mapH;
                String lowerCase2 = eventName.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                zContainsKey = mapH.containsKey(lowerCase2);
            }
        }
        return zContainsKey;
    }

    public final com.salesforce.marketingcloud.config.b a(@Nullable com.salesforce.marketingcloud.storage.h hVar, @Nullable String str) {
        com.salesforce.marketingcloud.config.b bVar;
        if (hVar == null || str == null || str.length() == 0) {
            return null;
        }
        synchronized (p) {
            Map<String, com.salesforce.marketingcloud.config.b> map = this.X;
            if (map == null || (bVar = map.get(str)) == null) {
                Map<String, com.salesforce.marketingcloud.config.b> mapB = b(new JSONArray(hVar.e().getString(M, new JSONArray().toString())));
                this.X = mapB;
                bVar = mapB.get(str);
            }
        }
        return bVar;
    }

    private final Map<String, com.salesforce.marketingcloud.config.b> b(JSONArray jSONArray) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (jSONArray.length() != 0) {
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    Object obj = jSONArray.get(i2);
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                    JSONObject jSONObject = (JSONObject) obj;
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(Q);
                    if (jSONArrayOptJSONArray != null) {
                        int length2 = jSONArrayOptJSONArray.length();
                        for (int i3 = 0; i3 < length2; i3++) {
                            Object obj2 = jSONArrayOptJSONArray.get(i3);
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj2;
                            if (Intrinsics.areEqual(str, "EVENTS")) {
                                com.salesforce.marketingcloud.config.b.a aVar = com.salesforce.marketingcloud.config.b.d;
                                String stringOrNull = PushExtensionsKt.getStringOrNull(jSONObject, "path");
                                Integer intOrNull = PushExtensionsKt.getIntOrNull(jSONObject, k);
                                int iIntValue = 999;
                                if (intOrNull != null) {
                                    if (intOrNull.intValue() > 999) {
                                        intOrNull = null;
                                    }
                                    if (intOrNull != null) {
                                        iIntValue = intOrNull.intValue();
                                    }
                                }
                                linkedHashMap.put(str, aVar.a(str, stringOrNull, Integer.valueOf(iIntValue)));
                            } else {
                                com.salesforce.marketingcloud.g.e(com.salesforce.marketingcloud.g.a, q, null, new g(str), 2, null);
                            }
                        }
                    }
                } catch (Exception e2) {
                    com.salesforce.marketingcloud.g.a.e(q, e2, h.b);
                }
            }
        }
        return linkedHashMap;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001f A[Catch: all -> 0x0039, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0008, B:6:0x000c, B:8:0x001f), top: B:14:0x0008 }] */
    public final String a(@NotNull String eventName) {
        String str;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        synchronized (p) {
            Map<String, String> map = this.e0;
            if (map != null) {
                String lowerCase = eventName.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                str = map.get(lowerCase);
                if (str == null) {
                    Map<String, String> mapH = h();
                    this.e0 = mapH;
                    String lowerCase2 = eventName.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    str = mapH.get(lowerCase2);
                }
            } else {
                Map<String, String> mapH2 = h();
                this.e0 = mapH2;
                String lowerCase3 = eventName.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                str = mapH2.get(lowerCase3);
            }
        }
        return str;
    }

    private final void a(JSONObject jSONObject) {
        synchronized (p) {
            try {
                SharedPreferences.Editor editorEdit = this.V.e().edit();
                int iOptInt = jSONObject.optInt(O, 0);
                Integer numValueOf = Integer.valueOf(iOptInt);
                if (iOptInt < 0) {
                    numValueOf = null;
                }
                int iIntValue = numValueOf != null ? numValueOf.intValue() : 0;
                editorEdit.putInt(O, iIntValue);
                this.f0 = Integer.valueOf(iIntValue);
                int iOptInt2 = jSONObject.optInt(P, 10000);
                Integer numValueOf2 = iOptInt2 > 10000 ? Integer.valueOf(iOptInt2) : null;
                int iIntValue2 = numValueOf2 != null ? numValueOf2.intValue() : 10000;
                editorEdit.putInt(P, iIntValue2);
                this.g0 = Integer.valueOf(iIntValue2);
                editorEdit.apply();
            } catch (Exception e2) {
                com.salesforce.marketingcloud.g.a.b(q, e2, c.b);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void b(JSONObject jSONObject) {
        synchronized (p) {
            try {
                SharedPreferences.Editor editorEdit = this.V.e().edit();
                Intrinsics.checkNotNullExpressionValue(editorEdit, "edit(...)");
                boolean zOptBoolean = jSONObject.optBoolean(G, true);
                editorEdit.putBoolean(G, zOptBoolean);
                this.Y = Boolean.valueOf(zOptBoolean);
                boolean zOptBoolean2 = jSONObject.optBoolean(H, false);
                editorEdit.putBoolean(H, zOptBoolean2);
                this.Z = Boolean.valueOf(zOptBoolean2);
                boolean zOptBoolean3 = jSONObject.optBoolean(I, false);
                editorEdit.putBoolean(I, zOptBoolean3);
                this.a0 = Boolean.valueOf(zOptBoolean3);
                boolean zOptBoolean4 = jSONObject.optBoolean(J, false);
                editorEdit.putBoolean(J, zOptBoolean4);
                this.b0 = Boolean.valueOf(zOptBoolean4);
                boolean zOptBoolean5 = jSONObject.optBoolean(K, false);
                editorEdit.putBoolean(K, zOptBoolean5);
                this.d0 = Boolean.valueOf(zOptBoolean5);
                boolean zOptBoolean6 = jSONObject.optBoolean(L, false);
                editorEdit.putBoolean(L, zOptBoolean6);
                this.c0 = Boolean.valueOf(zOptBoolean6);
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(F);
                if (jSONArrayOptJSONArray == null) {
                    jSONArrayOptJSONArray = new JSONArray();
                } else {
                    Intrinsics.checkNotNull(jSONArrayOptJSONArray);
                }
                this.e0 = PushExtensionsKt.toMap(jSONArrayOptJSONArray);
                editorEdit.putString(F, jSONArrayOptJSONArray.toString());
                editorEdit.apply();
            } catch (Exception e2) {
                com.salesforce.marketingcloud.g.a.b(q, e2, e.b);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void a(JSONArray jSONArray) {
        synchronized (p) {
            try {
                this.X = b(jSONArray);
                this.V.e().edit().putString(M, jSONArray.toString()).apply();
            } catch (Exception e2) {
                com.salesforce.marketingcloud.g.a.b(q, e2, d.b);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void a(String str, String str2) {
        try {
            if (j()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(C, str);
                jSONObject.put(D, str2);
                this.W.a(jSONObject);
            }
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.a.b(q, e2, new k(str));
        }
    }
}
