package com.salesforce.marketingcloud.analytics.stats;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import ch.qos.logback.core.CoreConstants;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.analytics.l;
import com.salesforce.marketingcloud.internal.n;
import com.salesforce.marketingcloud.messages.iam.InAppMessage;
import com.salesforce.marketingcloud.messages.iam.j;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.sfmcsdk.components.events.Event;
import com.salesforce.marketingcloud.util.Crypto;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class c extends com.salesforce.marketingcloud.analytics.i implements com.salesforce.marketingcloud.http.e.c, com.salesforce.marketingcloud.alarms.b.InterfaceC0064b {
    static final String k = com.salesforce.marketingcloud.g.a("DeviceStats");
    private static final String l = "nodes";
    private static final String m = "version";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f41n = "event";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f42o = "eventType";
    private static final String p = "items";
    private static final int q = 999;
    private static final int r = 1;
    private static final int s = 256000;
    private static final int t = 50;
    public final boolean d;
    protected final n e;
    final String f;
    final com.salesforce.marketingcloud.storage.h g;
    final com.salesforce.marketingcloud.http.e h;
    final MarketingCloudConfig i;
    final com.salesforce.marketingcloud.alarms.b j;

    class a extends com.salesforce.marketingcloud.internal.i {
        a(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            com.salesforce.marketingcloud.storage.c cVarI = c.this.g.i();
            Crypto cryptoB = c.this.g.b();
            List<com.salesforce.marketingcloud.analytics.stats.b> listI = cVarI.i(cryptoB);
            if (!listI.isEmpty()) {
                Date date = new Date();
                for (com.salesforce.marketingcloud.analytics.stats.b bVar : listI) {
                    try {
                        bVar.a(date);
                        cVarI.a(bVar, cryptoB);
                    } catch (Exception e) {
                        com.salesforce.marketingcloud.g.b(c.k, e, "Unable to update sync event analytic [%s]", Integer.valueOf(bVar.d()));
                    }
                }
            }
            com.salesforce.marketingcloud.g.c(c.k, "Handling app close and sending stats.", new Object[0]);
        }
    }

    class b extends com.salesforce.marketingcloud.internal.i {
        final /* synthetic */ InAppMessage c;
        final /* synthetic */ JSONObject d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, Object[] objArr, InAppMessage inAppMessage, JSONObject jSONObject) {
            super(str, objArr);
            this.c = inAppMessage;
            this.d = jSONObject;
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            if (com.salesforce.marketingcloud.config.a.g() == null || com.salesforce.marketingcloud.config.a.g().j()) {
                com.salesforce.marketingcloud.g.c(c.k, "InAppMessage throttled event stat for message id %s", this.c.id());
                Date date = new Date();
                try {
                    c.this.e.b().execute(new com.salesforce.marketingcloud.analytics.stats.a(c.this.g.i(), c.this.g.b(), com.salesforce.marketingcloud.analytics.stats.b.a(com.salesforce.marketingcloud.analytics.stats.b.l, date, com.salesforce.marketingcloud.analytics.stats.d.a(c.this.i.applicationId(), c.this.f, date, this.c.id(), com.salesforce.marketingcloud.internal.c.a(this.c), this.d), true)));
                } catch (JSONException e) {
                    com.salesforce.marketingcloud.g.b(c.k, e, "Failed to record iam throttled event stat.", new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.stats.c$c, reason: collision with other inner class name */
    class C0068c extends com.salesforce.marketingcloud.internal.i {
        final /* synthetic */ JSONObject c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0068c(String str, Object[] objArr, JSONObject jSONObject) {
            super(str, objArr);
            this.c = jSONObject;
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            if (com.salesforce.marketingcloud.config.a.g() == null || com.salesforce.marketingcloud.config.a.g().j()) {
                try {
                    Date date = new Date();
                    c.this.e.b().execute(new com.salesforce.marketingcloud.analytics.stats.a(c.this.g.i(), c.this.g.b(), com.salesforce.marketingcloud.analytics.stats.b.a(com.salesforce.marketingcloud.analytics.stats.b.l, date, com.salesforce.marketingcloud.analytics.stats.d.a(c.this.i.applicationId(), c.this.f, date, (String) null, (String) null, this.c), true)));
                } catch (Exception e) {
                    com.salesforce.marketingcloud.g.b(c.k, e, "Failed to record syncGateTimeOut Event stat.", new Object[0]);
                }
            }
        }
    }

    class d extends com.salesforce.marketingcloud.internal.i {
        final /* synthetic */ JSONObject c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, Object[] objArr, JSONObject jSONObject) {
            super(str, objArr);
            this.c = jSONObject;
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            if (com.salesforce.marketingcloud.config.a.g() == null || com.salesforce.marketingcloud.config.a.g().j()) {
                try {
                    Date date = new Date();
                    c.this.e.b().execute(new com.salesforce.marketingcloud.analytics.stats.a(c.this.g.i(), c.this.g.b(), com.salesforce.marketingcloud.analytics.stats.b.a(com.salesforce.marketingcloud.analytics.stats.b.l, date, com.salesforce.marketingcloud.analytics.stats.d.a(c.this.i.applicationId(), c.this.f, date, (String) null, (String) null, this.c), true)));
                } catch (JSONException e) {
                    com.salesforce.marketingcloud.g.b(c.k, e, "Failed to record onInvalidConfig Event stat.", new Object[0]);
                }
            }
        }
    }

    class e extends com.salesforce.marketingcloud.internal.i {
        final /* synthetic */ JSONObject c;
        final /* synthetic */ l.a d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, Object[] objArr, JSONObject jSONObject, l.a aVar) {
            super(str, objArr);
            this.c = jSONObject;
            this.d = aVar;
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            try {
                if (com.salesforce.marketingcloud.config.a.g() == null || com.salesforce.marketingcloud.config.a.g().n()) {
                    Date date = new Date();
                    c.this.e.b().execute(new com.salesforce.marketingcloud.analytics.stats.a(c.this.g.i(), c.this.g.b(), com.salesforce.marketingcloud.analytics.stats.b.a(107, date, com.salesforce.marketingcloud.analytics.stats.d.a(c.this.i.applicationId(), c.this.f, date, this.c), true)));
                }
            } catch (Exception e) {
                com.salesforce.marketingcloud.g.b(c.k, e, "Failed to record onTelemetryEvent stat. %s", this.d.name());
            }
        }
    }

    class f extends com.salesforce.marketingcloud.internal.i {
        final /* synthetic */ Event[] c;
        final /* synthetic */ Date d;
        final /* synthetic */ com.salesforce.marketingcloud.analytics.e e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, Object[] objArr, Event[] eventArr, Date date, com.salesforce.marketingcloud.analytics.e eVar) {
            super(str, objArr);
            this.c = eventArr;
            this.d = date;
            this.e = eVar;
        }

        /* JADX WARN: Code duplicated, block: B:73:0x0084 A[EXC_TOP_SPLITTER, PHI: r5 r6 r7 r8
  0x0084: PHI (r5v7 java.lang.Boolean) = 
  (r5v5 java.lang.Boolean)
  (r5v2 java.lang.Boolean)
  (r5v2 java.lang.Boolean)
  (r5v2 java.lang.Boolean)
  (r5v2 java.lang.Boolean)
 binds: [B:38:0x007c, B:33:0x006b, B:28:0x005a, B:23:0x0049, B:19:0x003a] A[DONT_GENERATE, DONT_INLINE]
  0x0084: PHI (r6v4 java.lang.Boolean) = 
  (r6v1 java.lang.Boolean)
  (r6v8 java.lang.Boolean)
  (r6v1 java.lang.Boolean)
  (r6v1 java.lang.Boolean)
  (r6v1 java.lang.Boolean)
 binds: [B:38:0x007c, B:33:0x006b, B:28:0x005a, B:23:0x0049, B:19:0x003a] A[DONT_GENERATE, DONT_INLINE]
  0x0084: PHI (r7v4 java.lang.Boolean) = 
  (r7v1 java.lang.Boolean)
  (r7v1 java.lang.Boolean)
  (r7v5 java.lang.Boolean)
  (r7v1 java.lang.Boolean)
  (r7v1 java.lang.Boolean)
 binds: [B:38:0x007c, B:33:0x006b, B:28:0x005a, B:23:0x0049, B:19:0x003a] A[DONT_GENERATE, DONT_INLINE]
  0x0084: PHI (r8v4 java.lang.Boolean) = 
  (r8v1 java.lang.Boolean)
  (r8v1 java.lang.Boolean)
  (r8v1 java.lang.Boolean)
  (r8v5 java.lang.Boolean)
  (r8v1 java.lang.Boolean)
 binds: [B:38:0x007c, B:33:0x006b, B:28:0x005a, B:23:0x0049, B:19:0x003a] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            Event[] eventArr;
            int i;
            Boolean bool;
            Boolean bool2;
            com.salesforce.marketingcloud.config.a aVarG = com.salesforce.marketingcloud.config.a.g();
            if (aVarG == null) {
                return;
            }
            Event[] eventArr2 = this.c;
            int length = eventArr2.length;
            Boolean boolValueOf = null;
            Boolean boolValueOf2 = null;
            Boolean boolValueOf3 = null;
            int i2 = 0;
            Boolean boolValueOf4 = null;
            while (i2 < length) {
                Event event = eventArr2[i2];
                try {
                    if (aVarG.b(event.name())) {
                        int i3 = i.a[event.getCategory().ordinal()];
                        if (i3 == 1) {
                            if (boolValueOf4 == null) {
                                boolValueOf4 = Boolean.valueOf(aVarG.i());
                            }
                            if (boolValueOf4.booleanValue()) {
                                com.salesforce.marketingcloud.g.c(c.k, "Event tracked %s( %s ) with Attributes: %s", event.getClass().getSimpleName(), event.name(), event.attributes());
                                eventArr = eventArr2;
                                i = length;
                                bool = boolValueOf4;
                                bool2 = boolValueOf;
                                c.this.e.b().execute(new com.salesforce.marketingcloud.analytics.stats.a(c.this.g.i(), c.this.g.b(), com.salesforce.marketingcloud.analytics.stats.b.a(105, this.d, com.salesforce.marketingcloud.analytics.stats.d.a(c.this.i.applicationId(), c.this.f, this.d, event.name(), event.id, event.toJson().getJSONObject("attributes"), this.e.e(), aVarG.a(event.name())), true)));
                                boolValueOf4 = bool;
                                boolValueOf = bool2;
                            }
                        } else if (i3 == 2) {
                            if (boolValueOf == null) {
                                boolValueOf = Boolean.valueOf(aVarG.k());
                            }
                            if (boolValueOf.booleanValue()) {
                                com.salesforce.marketingcloud.g.c(c.k, "Event tracked %s( %s ) with Attributes: %s", event.getClass().getSimpleName(), event.name(), event.attributes());
                                eventArr = eventArr2;
                                i = length;
                                bool = boolValueOf4;
                                bool2 = boolValueOf;
                                c.this.e.b().execute(new com.salesforce.marketingcloud.analytics.stats.a(c.this.g.i(), c.this.g.b(), com.salesforce.marketingcloud.analytics.stats.b.a(105, this.d, com.salesforce.marketingcloud.analytics.stats.d.a(c.this.i.applicationId(), c.this.f, this.d, event.name(), event.id, event.toJson().getJSONObject("attributes"), this.e.e(), aVarG.a(event.name())), true)));
                                boolValueOf4 = bool;
                                boolValueOf = bool2;
                            }
                        } else if (i3 != 3) {
                            if (i3 == 4) {
                                if (boolValueOf3 == null) {
                                    boolValueOf3 = Boolean.valueOf(aVarG.m());
                                }
                                if (!boolValueOf3.booleanValue()) {
                                }
                            }
                            try {
                                com.salesforce.marketingcloud.g.c(c.k, "Event tracked %s( %s ) with Attributes: %s", event.getClass().getSimpleName(), event.name(), event.attributes());
                                eventArr = eventArr2;
                                try {
                                    i = length;
                                    try {
                                        bool = boolValueOf4;
                                        try {
                                            bool2 = boolValueOf;
                                            try {
                                                c.this.e.b().execute(new com.salesforce.marketingcloud.analytics.stats.a(c.this.g.i(), c.this.g.b(), com.salesforce.marketingcloud.analytics.stats.b.a(105, this.d, com.salesforce.marketingcloud.analytics.stats.d.a(c.this.i.applicationId(), c.this.f, this.d, event.name(), event.id, event.toJson().getJSONObject("attributes"), this.e.e(), aVarG.a(event.name())), true)));
                                                boolValueOf4 = bool;
                                                boolValueOf = bool2;
                                            } catch (Exception e) {
                                                e = e;
                                                boolValueOf4 = bool;
                                                boolValueOf = bool2;
                                                com.salesforce.marketingcloud.g.b(c.k, "Failed to record event in devstats", e);
                                            }
                                        } catch (Exception e2) {
                                            e = e2;
                                            bool2 = boolValueOf;
                                            boolValueOf4 = bool;
                                            boolValueOf = bool2;
                                            com.salesforce.marketingcloud.g.b(c.k, "Failed to record event in devstats", e);
                                            i2++;
                                            eventArr2 = eventArr;
                                            length = i;
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        bool = boolValueOf4;
                                        bool2 = boolValueOf;
                                        boolValueOf4 = bool;
                                        boolValueOf = bool2;
                                        com.salesforce.marketingcloud.g.b(c.k, "Failed to record event in devstats", e);
                                        i2++;
                                        eventArr2 = eventArr;
                                        length = i;
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    i = length;
                                    bool = boolValueOf4;
                                    bool2 = boolValueOf;
                                    boolValueOf4 = bool;
                                    boolValueOf = bool2;
                                    com.salesforce.marketingcloud.g.b(c.k, "Failed to record event in devstats", e);
                                    i2++;
                                    eventArr2 = eventArr;
                                    length = i;
                                }
                            } catch (Exception e5) {
                                e = e5;
                                eventArr = eventArr2;
                            }
                        } else {
                            if (boolValueOf2 == null) {
                                boolValueOf2 = Boolean.valueOf(aVarG.l());
                            }
                            if (boolValueOf2.booleanValue()) {
                                com.salesforce.marketingcloud.g.c(c.k, "Event tracked %s( %s ) with Attributes: %s", event.getClass().getSimpleName(), event.name(), event.attributes());
                                eventArr = eventArr2;
                                i = length;
                                bool = boolValueOf4;
                                bool2 = boolValueOf;
                                c.this.e.b().execute(new com.salesforce.marketingcloud.analytics.stats.a(c.this.g.i(), c.this.g.b(), com.salesforce.marketingcloud.analytics.stats.b.a(105, this.d, com.salesforce.marketingcloud.analytics.stats.d.a(c.this.i.applicationId(), c.this.f, this.d, event.name(), event.id, event.toJson().getJSONObject("attributes"), this.e.e(), aVarG.a(event.name())), true)));
                                boolValueOf4 = bool;
                                boolValueOf = bool2;
                            }
                        }
                        i2++;
                        eventArr2 = eventArr;
                        length = i;
                    }
                    eventArr = eventArr2;
                    i = length;
                } catch (Exception e6) {
                    e = e6;
                    eventArr = eventArr2;
                    i = length;
                }
                i2++;
                eventArr2 = eventArr;
                length = i;
            }
        }
    }

    class g extends com.salesforce.marketingcloud.internal.i {
        final /* synthetic */ Map c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(String str, Object[] objArr, Map map) {
            super(str, objArr);
            this.c = map;
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            try {
                if (com.salesforce.marketingcloud.config.a.g() != null && com.salesforce.marketingcloud.config.a.g().f() != 0) {
                    if (com.salesforce.marketingcloud.messages.push.a.a((Map<String, String>) this.c)) {
                        Date date = new Date();
                        c cVar = c.this;
                        new com.salesforce.marketingcloud.analytics.stats.a(c.this.g.i(), c.this.g.b(), com.salesforce.marketingcloud.analytics.stats.b.a(112, date, com.salesforce.marketingcloud.analytics.stats.d.b(cVar.i.applicationId, cVar.f, date, (String) this.c.get(NotificationMessage.NOTIF_KEY_ID), (String) this.c.get(NotificationMessage.NOTIF_KEY_REQUEST_ID), (String) this.c.get("messageDateUtc"), (String) this.c.get(NotificationMessage.NOTIF_KEY_MESSAGE_TYPE), (String) this.c.get(NotificationMessage.NOTIF_KEY_PB_ID)), true)).a();
                        if (com.salesforce.marketingcloud.config.a.g().f() == 1) {
                            com.salesforce.marketingcloud.alarms.b bVar = c.this.j;
                            com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a = com.salesforce.marketingcloud.alarms.a.EnumC0062a.l;
                            bVar.d(enumC0062a);
                            enumC0062a.a(com.salesforce.marketingcloud.config.a.g().e());
                            c.this.j.b(enumC0062a);
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.salesforce.marketingcloud.g.c(c.k, "onPushReceived with feature disabled do not report delivery receipt", new Object[0]);
            } catch (Exception e) {
                com.salesforce.marketingcloud.g.b(c.k, e, "Failed to record Delivery Receipt event stat", new Object[0]);
            }
        }
    }

    class h extends com.salesforce.marketingcloud.internal.i {
        final /* synthetic */ com.salesforce.marketingcloud.http.b c;
        final /* synthetic */ int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(String str, Object[] objArr, com.salesforce.marketingcloud.http.b bVar, int i) {
            super(str, objArr);
            this.c = bVar;
            this.d = i;
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            com.salesforce.marketingcloud.http.b bVar = this.c;
            com.salesforce.marketingcloud.http.b bVar2 = com.salesforce.marketingcloud.http.b.s;
            if ((bVar == bVar2 || bVar == com.salesforce.marketingcloud.http.b.r) && !com.salesforce.marketingcloud.http.b.a(c.this.g)) {
                com.salesforce.marketingcloud.g.c(c.k, "No subscriber token found ignore sendStats request", new Object[0]);
                c.this.j.d(this.c == bVar2 ? com.salesforce.marketingcloud.alarms.a.EnumC0062a.k : com.salesforce.marketingcloud.alarms.a.EnumC0062a.j);
                return;
            }
            com.salesforce.marketingcloud.http.b bVar3 = this.c;
            com.salesforce.marketingcloud.http.b bVar4 = com.salesforce.marketingcloud.http.b.r;
            List<com.salesforce.marketingcloud.analytics.stats.b> listJ = bVar3 == bVar4 ? c.this.g.i().j(c.this.g.b()) : c.this.g.i().n(c.this.g.b());
            if (listJ.isEmpty()) {
                com.salesforce.marketingcloud.http.b bVar5 = this.c;
                if (bVar5 == bVar4) {
                    c.this.j.d(com.salesforce.marketingcloud.alarms.a.EnumC0062a.j);
                    return;
                } else {
                    if (bVar5 == bVar2) {
                        c.this.j.d(com.salesforce.marketingcloud.alarms.a.EnumC0062a.k);
                        return;
                    }
                    return;
                }
            }
            com.salesforce.marketingcloud.g.c(c.k, "Preparing payload for device statistics.", new Object[0]);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.salesforce.marketingcloud.analytics.stats.d.b, c.this.i.applicationId());
                jSONObject.put("deviceId", c.this.f);
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject2 = new JSONObject();
                jSONArray.put(jSONObject2);
                jSONObject.put(c.l, jSONArray);
                jSONObject2.put("version", 1);
                jSONObject2.put("name", "event");
                Integer numValueOf = Integer.valueOf(this.d);
                String strF = null;
                if (this.c == bVar2) {
                    com.salesforce.marketingcloud.config.b bVarA = com.salesforce.marketingcloud.config.a.g() != null ? com.salesforce.marketingcloud.config.a.g().a(c.this.g, com.salesforce.marketingcloud.config.b.EnumC0072b.EVENTS.name()) : null;
                    if (bVarA != null) {
                        strF = bVarA.f();
                        if (bVarA.e() != null) {
                            numValueOf = Integer.valueOf(Math.min(this.d, bVarA.e().intValue()));
                        }
                    }
                }
                for (Map.Entry<String, JSONArray> entry : c.this.a(listJ, numValueOf.intValue()).entrySet()) {
                    jSONObject2.put("items", entry.getValue());
                    com.salesforce.marketingcloud.http.b bVar6 = this.c;
                    c cVar = c.this;
                    com.salesforce.marketingcloud.http.c cVarA = bVar6.a(cVar.i, cVar.g.c(), jSONObject.toString(), strF);
                    cVarA.a(entry.getKey());
                    int iA = com.salesforce.marketingcloud.http.a.a.a(cVarA);
                    if (iA > c.s) {
                        String str = c.k;
                        com.salesforce.marketingcloud.g.e(str, "Bundle size of %d bytes is too large. Reducing send batch size.", Integer.valueOf(iA));
                        if (numValueOf.intValue() <= 50) {
                            com.salesforce.marketingcloud.g.b(str, "Batch size already at or below minimum, cannot reduce further. Stats not sent.", new Object[0]);
                            return;
                        }
                        int length = entry.getValue().length();
                        if (length >= numValueOf.intValue()) {
                            length = numValueOf.intValue();
                        }
                        c.this.a(this.c, (int) (length * 0.66f));
                        return;
                    }
                    if (cVarA.r() != null) {
                        c.this.g.i().a(com.salesforce.marketingcloud.analytics.c.a(cVarA.r()), Boolean.TRUE);
                    }
                    c.this.h.a(cVarA);
                }
            } catch (Exception e) {
                com.salesforce.marketingcloud.g.b(c.k, e, "Failed to start sync events request.", new Object[0]);
            }
        }
    }

    static /* synthetic */ class i {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Event.Category.values().length];
            a = iArr;
            try {
                iArr[Event.Category.APPLICATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Event.Category.ENGAGEMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Event.Category.IDENTITY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Event.Category.SYSTEM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public c(@NonNull MarketingCloudConfig marketingCloudConfig, @NonNull String str, boolean z, @NonNull com.salesforce.marketingcloud.storage.h hVar, @NonNull com.salesforce.marketingcloud.http.e eVar, @NonNull com.salesforce.marketingcloud.alarms.b bVar, @NonNull n nVar) {
        this.i = marketingCloudConfig;
        this.f = str;
        this.d = z;
        this.g = hVar;
        this.h = eVar;
        this.j = bVar;
        this.e = nVar;
        eVar.a(com.salesforce.marketingcloud.http.b.r, this);
        eVar.a(com.salesforce.marketingcloud.http.b.s, this);
        bVar.a(this, com.salesforce.marketingcloud.alarms.a.EnumC0062a.j, com.salesforce.marketingcloud.alarms.a.EnumC0062a.k);
    }

    public static void a(@NonNull com.salesforce.marketingcloud.storage.h hVar, boolean z) {
        if (z) {
            hVar.i().f();
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.i, com.salesforce.marketingcloud.analytics.f
    public void b(@NonNull InAppMessage inAppMessage) {
        if (!this.d) {
            com.salesforce.marketingcloud.g.a(k, "Track user is false.  Ignoring onInAppMessageDownloaded event.", new Object[0]);
            return;
        }
        try {
            com.salesforce.marketingcloud.g.c(k, "Creating download event stat for message id %s", inAppMessage.id());
            Date date = new Date();
            this.e.b().execute(new com.salesforce.marketingcloud.analytics.stats.a(this.g.i(), this.g.b(), com.salesforce.marketingcloud.analytics.stats.b.a(101, date, com.salesforce.marketingcloud.analytics.stats.d.b(this.i.applicationId(), this.f, date, inAppMessage.id(), com.salesforce.marketingcloud.internal.c.a(inAppMessage)), true)));
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.b(k, e2, "Failed to record analytic event for In App Message Downloaded", new Object[0]);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.i
    public void a(boolean z) {
        this.h.a(com.salesforce.marketingcloud.http.b.r);
        this.h.a(com.salesforce.marketingcloud.http.b.s);
        com.salesforce.marketingcloud.alarms.b bVar = this.j;
        com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a = com.salesforce.marketingcloud.alarms.a.EnumC0062a.j;
        com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a2 = com.salesforce.marketingcloud.alarms.a.EnumC0062a.k;
        bVar.e(enumC0062a, enumC0062a2);
        if (z) {
            this.j.d(enumC0062a, enumC0062a2, com.salesforce.marketingcloud.alarms.a.EnumC0062a.l);
        }
    }

    @Override // com.salesforce.marketingcloud.http.e.c
    public void a(@NonNull com.salesforce.marketingcloud.http.c cVar, @NonNull com.salesforce.marketingcloud.http.f fVar) {
        if (fVar.p()) {
            if (cVar.q() == com.salesforce.marketingcloud.http.b.r) {
                this.j.c(com.salesforce.marketingcloud.alarms.a.EnumC0062a.j);
            } else if (cVar.q() == com.salesforce.marketingcloud.http.b.s) {
                this.j.c(com.salesforce.marketingcloud.alarms.a.EnumC0062a.k);
            }
            if (cVar.r() != null) {
                String[] strArrA = com.salesforce.marketingcloud.analytics.c.a(cVar.r());
                com.salesforce.marketingcloud.g.c(k, "Removing events %s from DB", Arrays.toString(strArrA));
                this.g.i().c(strArrA);
                return;
            }
            return;
        }
        String str = k;
        int iK = fVar.k();
        com.salesforce.marketingcloud.g.c(str, "Request failed: %d - %s", Integer.valueOf(iK), fVar.n());
        if (cVar.q() == com.salesforce.marketingcloud.http.b.r) {
            this.j.b(com.salesforce.marketingcloud.alarms.a.EnumC0062a.j);
        } else if (cVar.q() == com.salesforce.marketingcloud.http.b.s) {
            this.j.b(com.salesforce.marketingcloud.alarms.a.EnumC0062a.k);
        }
        if (cVar.r() != null) {
            this.g.i().a(com.salesforce.marketingcloud.analytics.c.a(cVar.r()), Boolean.FALSE);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.i, com.salesforce.marketingcloud.analytics.m
    public void b(@NonNull JSONObject jSONObject) {
        try {
            this.e.b().execute(new C0068c("onSyncGateTimedOutEvent", new Object[0], jSONObject));
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.b(k, e2, "Failed to track syncGateTimeOut Event stat.", new Object[0]);
        }
    }

    @Override // com.salesforce.marketingcloud.alarms.b.InterfaceC0064b
    public void a(@NonNull com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a) {
        if (enumC0062a == com.salesforce.marketingcloud.alarms.a.EnumC0062a.j || enumC0062a == com.salesforce.marketingcloud.alarms.a.EnumC0062a.k) {
            com.salesforce.marketingcloud.g.c(k, "Handling alarm to send stats type [%s]", enumC0062a.name());
            a();
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.i
    public void a(long j) {
        this.e.b().execute(new a("stats_app_close", new Object[0]));
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004c  */
    @Override // com.salesforce.marketingcloud.analytics.i, com.salesforce.marketingcloud.analytics.f
    public void a(@NonNull InAppMessage inAppMessage, @NonNull j jVar) {
        byte b2;
        if (!this.d) {
            com.salesforce.marketingcloud.g.a(k, "Track user is false. Ignoring onInAppMessageCompleted event.", new Object[0]);
            return;
        }
        try {
            com.salesforce.marketingcloud.g.c(k, "Creating display event stat for message id %s", inAppMessage.id());
            InAppMessage.Button buttonH = jVar.h();
            String strL = jVar.l();
            int iHashCode = strL.hashCode();
            int i2 = 1;
            if (iHashCode != -935167046) {
                if (iHashCode == 2117198997 && strL.equals(j.f)) {
                    b2 = 1;
                } else {
                    b2 = -1;
                }
            } else if (strL.equals(j.h)) {
                b2 = 0;
            } else {
                b2 = -1;
            }
            String strId = null;
            if (b2 != 0) {
                if (b2 != 1) {
                    i2 = 3;
                } else {
                    strId = buttonH != null ? buttonH.id() : null;
                    i2 = 2;
                }
            }
            Date date = new Date(jVar.k().getTime() + jVar.j());
            this.e.b().execute(new com.salesforce.marketingcloud.analytics.stats.a(this.g.i(), this.g.b(), com.salesforce.marketingcloud.analytics.stats.b.a(100, date, com.salesforce.marketingcloud.analytics.stats.d.a(this.i.applicationId(), this.f, date, inAppMessage.id(), com.salesforce.marketingcloud.internal.c.a(inAppMessage), (long) Math.ceil(jVar.j() / 1000.0d), i2, strId), false)));
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.b(k, e2, "Failed to record analytic event for In App Message Displayed", new Object[0]);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.i
    public void b(@NonNull Map<String, String> map) {
        try {
            this.e.b().execute(new g("onPushReceived", new Object[0], map));
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.b(k, e2, "Failed to track Delivery Receipt event stat", new Object[0]);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.i, com.salesforce.marketingcloud.analytics.j
    public void a(@NonNull com.salesforce.marketingcloud.push.f fVar, @NonNull String str) {
        String message = fVar.getMessage();
        if (this.d && message != null) {
            try {
                Date date = new Date();
                this.e.b().execute(new com.salesforce.marketingcloud.analytics.stats.a(this.g.i(), this.g.b(), com.salesforce.marketingcloud.analytics.stats.b.a(com.salesforce.marketingcloud.analytics.stats.b.l, date, com.salesforce.marketingcloud.analytics.stats.d.a(this.i.applicationId(), this.f, date, str, (String) null, fVar.b()), true)));
                return;
            } catch (Exception e2) {
                com.salesforce.marketingcloud.g.b(k, e2, "Failed to record analytic event for Push Notification Error", new Object[0]);
                return;
            }
        }
        com.salesforce.marketingcloud.g.a(k, "Track user is false.  Ignoring PushNotificationError event.", new Object[0]);
    }

    @Override // com.salesforce.marketingcloud.analytics.i, com.salesforce.marketingcloud.analytics.j
    public void a(@NonNull NotificationMessage notificationMessage, int i2, String str, @Nullable String str2) {
        if (!this.d) {
            com.salesforce.marketingcloud.g.a(k, "Track user is false.  Ignoring recordNotificationMessageClicked event or message is null.", new Object[0]);
            return;
        }
        if (notificationMessage == null) {
            com.salesforce.marketingcloud.g.a(k, "NotificationMessage is null. Ignoring recordNotificationMessageClicked event.", new Object[0]);
            return;
        }
        try {
            Date date = new Date();
            this.e.b().execute(new com.salesforce.marketingcloud.analytics.stats.a(this.g.i(), this.g.b(), com.salesforce.marketingcloud.analytics.stats.b.a(i2, date, com.salesforce.marketingcloud.analytics.stats.d.a(this.i.applicationId(), this.f, date, notificationMessage.id(), str, notificationMessage.requestId, notificationMessage.propertyBag(), str2), true)));
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.b(k, e2, "Failed to record analytic event for recordNotificationMessageClicked", new Object[0]);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.i, com.salesforce.marketingcloud.analytics.m
    public void a(@NonNull String str, @NonNull String str2, @NonNull String str3, @Nullable String str4) {
        if (!this.d) {
            com.salesforce.marketingcloud.g.a(k, "Track user is false.  Ignoring onTriggerSuccessEvent event.", new Object[0]);
            return;
        }
        com.salesforce.marketingcloud.g.c(k, "Creating trigger event stat for message id %s", str);
        try {
            Date date = new Date();
            this.e.b().execute(new com.salesforce.marketingcloud.analytics.stats.a(this.g.i(), this.g.b(), com.salesforce.marketingcloud.analytics.stats.b.a(102, date, com.salesforce.marketingcloud.analytics.stats.d.a(this.i.applicationId(), this.f, date, str2, str4, str, str3), true)));
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.b(k, e2, "Failed to record device stat for successful trigger event", new Object[0]);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.i, com.salesforce.marketingcloud.analytics.f
    public void a(@NonNull String str, @NonNull String str2, @NonNull List<String> list) {
        com.salesforce.marketingcloud.g.c(k, "Creating message validation error event stat for message id %s", str);
        try {
            Date date = new Date();
            this.e.b().execute(new com.salesforce.marketingcloud.analytics.stats.a(this.g.i(), this.g.b(), com.salesforce.marketingcloud.analytics.stats.b.a(com.salesforce.marketingcloud.analytics.stats.b.i, date, com.salesforce.marketingcloud.analytics.stats.d.a(this.i.applicationId(), this.f, date, str, str2, list), true)));
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.b(k, e2, "Failed to record validation event stat.", new Object[0]);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.i, com.salesforce.marketingcloud.analytics.f
    public void a(@NonNull InAppMessage inAppMessage) {
        try {
            com.salesforce.marketingcloud.g.c(k, "InAppMessage displayed event stat for message id %s", inAppMessage.id());
            Date date = new Date();
            this.e.b().execute(new com.salesforce.marketingcloud.analytics.stats.a(this.g.i(), this.g.b(), com.salesforce.marketingcloud.analytics.stats.b.a(104, date, com.salesforce.marketingcloud.analytics.stats.d.a(this.i.applicationId(), this.f, date, inAppMessage.id(), com.salesforce.marketingcloud.internal.c.a(inAppMessage)), true)));
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.b(k, e2, "Failed to record iam displayed event stat.", new Object[0]);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.i, com.salesforce.marketingcloud.analytics.f
    public void a(@NonNull InAppMessage inAppMessage, @NonNull JSONObject jSONObject) {
        try {
            this.e.b().execute(new b("onInAppMessageThrottled", new Object[0], inAppMessage, jSONObject));
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.b(k, e2, "Failed to track iam throttled event stat.", new Object[0]);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.i, com.salesforce.marketingcloud.analytics.m
    public void a(@NonNull JSONObject jSONObject) {
        try {
            this.e.b().execute(new d("onInvalidConfigEvent", new Object[0], jSONObject));
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.b(k, e2, "Failed to track onInvalidConfig Event stat.", new Object[0]);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.i, com.salesforce.marketingcloud.analytics.l
    public void a(@NonNull l.a aVar, @NonNull JSONObject jSONObject) {
        try {
            this.e.b().execute(new e("onTelemetryEvent", new Object[0], jSONObject, aVar));
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.b(k, e2, "Failed to track onTelemetryEvent stat. %s", aVar.name());
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.i, com.salesforce.marketingcloud.analytics.n
    public void a(@NonNull com.salesforce.marketingcloud.analytics.e eVar, @NonNull Event... eventArr) {
        try {
            this.e.b().execute(new f("track_events", new Object[0], eventArr, new Date(), eVar));
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.b(k, e2, "Failed to record iam displayed event stat.", new Object[0]);
        }
    }

    public void a() {
        a(com.salesforce.marketingcloud.http.b.r, 999);
        a(com.salesforce.marketingcloud.http.b.s, 999);
    }

    void a(com.salesforce.marketingcloud.http.b bVar, int i2) {
        this.e.b().execute(new h("send_stats", new Object[0], bVar, i2));
    }

    Map<String, JSONArray> a(List<com.salesforce.marketingcloud.analytics.stats.b> list, int i2) {
        boolean z;
        int size = list.size();
        int iCeil = (int) Math.ceil(((double) size) / ((double) i2));
        ArrayMap arrayMap = new ArrayMap(iCeil);
        for (int i3 = 0; i3 < iCeil; i3++) {
            StringBuilder sb = new StringBuilder();
            JSONArray jSONArray = new JSONArray();
            int i4 = i3 * i2;
            boolean z2 = true;
            int i5 = i4;
            while (i5 < size && i5 < i4 + i2) {
                com.salesforce.marketingcloud.analytics.stats.b bVar = list.get(i5);
                if (z2) {
                    z = false;
                } else {
                    sb.append(CoreConstants.COMMA_CHAR);
                    z = z2;
                }
                sb.append(bVar.b());
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(f42o, bVar.d());
                    if (bVar.d() == 112) {
                        bVar.c().a.put(com.salesforce.marketingcloud.analytics.stats.d.f, com.salesforce.marketingcloud.util.j.a(new Date()));
                    }
                    jSONObject.put("event", bVar.c().a);
                    jSONArray.put(jSONObject);
                } catch (JSONException e2) {
                    com.salesforce.marketingcloud.g.b(k, e2, "Unable to add device stats to payload.", new Object[0]);
                }
                i5++;
                z2 = z;
            }
            arrayMap.put(sb.toString(), jSONArray);
        }
        return arrayMap;
    }
}
