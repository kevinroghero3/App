package com.salesforce.marketingcloud.analytics;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.messages.Region;
import com.salesforce.marketingcloud.messages.RegionMessageManager;
import com.salesforce.marketingcloud.messages.iam.InAppMessage;
import com.salesforce.marketingcloud.messages.inbox.InboxMessage;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.sfmcsdk.components.events.Event;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class h implements com.salesforce.marketingcloud.e, com.salesforce.marketingcloud.behaviors.b, j, RegionMessageManager.RegionTransitionEventListener, AnalyticsManager, g, f, m, n, l, com.salesforce.marketingcloud.alarms.b.InterfaceC0064b {
    private static final String s = "ETAnalyticsEnabled";
    private static final String t = "PIAnalyticsEnabled";
    private static final Object u = new Object();
    final com.salesforce.marketingcloud.storage.h d;
    private final com.salesforce.marketingcloud.behaviors.c e;
    private final EnumSet<com.salesforce.marketingcloud.behaviors.a> f;
    private final com.salesforce.marketingcloud.http.e g;
    private final String h;
    private final MarketingCloudConfig i;
    private final com.salesforce.marketingcloud.alarms.b j;
    com.salesforce.marketingcloud.analytics.etanalytics.b k;
    com.salesforce.marketingcloud.analytics.etanalytics.a l;
    com.salesforce.marketingcloud.analytics.piwama.i m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    com.salesforce.marketingcloud.analytics.stats.c f33n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private com.salesforce.marketingcloud.analytics.etanalytics.c f34o;
    private com.salesforce.marketingcloud.internal.n p;
    private com.salesforce.marketingcloud.toggles.a q;
    private com.salesforce.marketingcloud.toggles.a r;

    class a extends com.salesforce.marketingcloud.internal.i {
        final /* synthetic */ InboxMessage c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Object[] objArr, InboxMessage inboxMessage) {
            super(str, objArr);
            this.c = inboxMessage;
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            if (this.c == null || !h.this.d.l().e(this.c.id())) {
                com.salesforce.marketingcloud.g.e(AnalyticsManager.TAG, "InboxMessage is a Legacy message, null or unknown.  Call to trackInboxOpenEvent() ignored.", new Object[0]);
                return;
            }
            com.salesforce.marketingcloud.analytics.etanalytics.a aVar = h.this.l;
            if (aVar != null) {
                aVar.trackInboxOpenEvent(this.c);
            }
            com.salesforce.marketingcloud.analytics.etanalytics.b bVar = h.this.k;
            if (bVar != null) {
                bVar.trackInboxOpenEvent(this.c);
            }
            com.salesforce.marketingcloud.analytics.piwama.i iVar = h.this.m;
            if (iVar != null) {
                iVar.trackInboxOpenEvent(this.c);
            }
            com.salesforce.marketingcloud.analytics.stats.c cVar = h.this.f33n;
            if (cVar != null) {
                cVar.trackInboxOpenEvent(this.c);
            }
        }
    }

    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.salesforce.marketingcloud.behaviors.a.values().length];
            a = iArr;
            try {
                iArr[com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_APP_BACKGROUNDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_APP_FOREGROUNDED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_DEVICE_SHUTDOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_DEVICE_BOOT_COMPLETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public h(@NonNull MarketingCloudConfig marketingCloudConfig, @NonNull com.salesforce.marketingcloud.storage.h hVar, @NonNull String str, @NonNull com.salesforce.marketingcloud.alarms.b bVar, @NonNull com.salesforce.marketingcloud.behaviors.c cVar, @NonNull com.salesforce.marketingcloud.http.e eVar, @NonNull com.salesforce.marketingcloud.internal.n nVar) {
        this.f = EnumSet.of(com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_APP_BACKGROUNDED, com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_APP_FOREGROUNDED, com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_DEVICE_SHUTDOWN, com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_DEVICE_BOOT_COMPLETE);
        this.d = (com.salesforce.marketingcloud.storage.h) com.salesforce.marketingcloud.util.g.a(hVar, "MCStorage may not be null.");
        this.e = (com.salesforce.marketingcloud.behaviors.c) com.salesforce.marketingcloud.util.g.a(cVar, "BehaviorManager may not be null.");
        this.g = eVar;
        this.h = str;
        this.i = marketingCloudConfig;
        this.j = bVar;
        this.p = nVar;
    }

    private void b(int i, com.salesforce.marketingcloud.toggles.a aVar) {
        if (com.salesforce.marketingcloud.b.a(i, 512)) {
            return;
        }
        this.r = aVar;
        if (aVar == com.salesforce.marketingcloud.toggles.a.ENABLED || (this.i.piAnalyticsEnabled() && aVar == com.salesforce.marketingcloud.toggles.a.UNKNOWN)) {
            this.m = new com.salesforce.marketingcloud.analytics.piwama.i(this.i, this.d, this.g, this.p);
        }
    }

    private void c(Bundle bundle) {
        long j = bundle.getLong("timestamp", 0L);
        com.salesforce.marketingcloud.analytics.etanalytics.a aVar = this.l;
        if (aVar != null) {
            aVar.c(j);
        }
        com.salesforce.marketingcloud.analytics.etanalytics.b bVar = this.k;
        if (bVar != null) {
            bVar.c(j);
        }
        com.salesforce.marketingcloud.analytics.piwama.i iVar = this.m;
        if (iVar != null) {
            iVar.c(j);
        }
        com.salesforce.marketingcloud.analytics.stats.c cVar = this.f33n;
        if (cVar != null) {
            cVar.c(j);
        }
    }

    boolean a(int i, com.salesforce.marketingcloud.toggles.a aVar) {
        boolean z = false;
        if (com.salesforce.marketingcloud.b.a(i, 256)) {
            return false;
        }
        this.q = aVar;
        if (aVar == com.salesforce.marketingcloud.toggles.a.ENABLED || (this.i.analyticsEnabled() && aVar == com.salesforce.marketingcloud.toggles.a.UNKNOWN)) {
            z = true;
        }
        if (z) {
            this.k = new com.salesforce.marketingcloud.analytics.etanalytics.b(this.d, this.p);
        }
        return z;
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public boolean areAnalyticsEnabled() {
        if (com.salesforce.marketingcloud.b.a(com.salesforce.marketingcloud.b.a(this.d.j()), 256)) {
            return false;
        }
        if (this.q == null) {
            this.q = a(s, (com.salesforce.marketingcloud.toggles.a) null);
        }
        com.salesforce.marketingcloud.toggles.a aVar = this.q;
        return aVar == com.salesforce.marketingcloud.toggles.a.ENABLED || (aVar == com.salesforce.marketingcloud.toggles.a.UNKNOWN && this.i.analyticsEnabled());
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public boolean arePiAnalyticsEnabled() {
        if (com.salesforce.marketingcloud.b.a(com.salesforce.marketingcloud.b.a(this.d.j()), 512)) {
            return false;
        }
        if (this.r == null) {
            this.r = a(t, (com.salesforce.marketingcloud.toggles.a) null);
        }
        com.salesforce.marketingcloud.toggles.a aVar = this.r;
        return aVar == com.salesforce.marketingcloud.toggles.a.ENABLED || (aVar == com.salesforce.marketingcloud.toggles.a.UNKNOWN && this.i.piAnalyticsEnabled());
    }

    @Override // com.salesforce.marketingcloud.d
    public String componentName() {
        return "AnalyticsManager";
    }

    @Override // com.salesforce.marketingcloud.d
    public JSONObject componentState() {
        JSONObject jSONObject = new JSONObject();
        try {
            boolean z = true;
            jSONObject.put("bet_analytics", this.l != null);
            jSONObject.put("et_analytics", this.k != null);
            jSONObject.put("pi_analytics", this.m != null);
            if (this.f33n == null) {
                z = false;
            }
            jSONObject.put("device_stats", z);
            com.salesforce.marketingcloud.analytics.piwama.i iVar = this.m;
            if (iVar != null) {
                jSONObject.put("predictive_intelligence_identifier", iVar.getPiIdentifier());
            }
            jSONObject.put("analyticsEnabled", areAnalyticsEnabled());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override // com.salesforce.marketingcloud.e
    public void controlChannelInit(int i) {
        boolean zA = com.salesforce.marketingcloud.b.a(i, 256);
        if (com.salesforce.marketingcloud.b.a(i, 2048)) {
            com.salesforce.marketingcloud.analytics.etanalytics.a aVar = this.l;
            if (aVar != null) {
                aVar.a(false);
                this.l = null;
            }
            com.salesforce.marketingcloud.analytics.etanalytics.a.a(this.d, this.p, com.salesforce.marketingcloud.b.c(i, 2048));
            com.salesforce.marketingcloud.analytics.stats.c cVar = this.f33n;
            if (cVar != null) {
                cVar.a(false);
                this.f33n = null;
            }
            com.salesforce.marketingcloud.analytics.stats.c.a(this.d, com.salesforce.marketingcloud.b.c(i, 2048));
        } else {
            this.l = new com.salesforce.marketingcloud.analytics.etanalytics.a(this.d, this.p);
            MarketingCloudConfig marketingCloudConfig = this.i;
            this.f33n = new com.salesforce.marketingcloud.analytics.stats.c(marketingCloudConfig, this.h, marketingCloudConfig.analyticsEnabled() && !zA, this.d, this.g, this.j, this.p);
        }
        if (zA) {
            com.salesforce.marketingcloud.analytics.etanalytics.b bVar = this.k;
            if (bVar != null) {
                bVar.a(false);
                this.k = null;
            }
            com.salesforce.marketingcloud.analytics.etanalytics.b.a(this.d, this.p, com.salesforce.marketingcloud.b.c(i, 256));
        } else if (this.k == null && this.i.analyticsEnabled()) {
            this.k = new com.salesforce.marketingcloud.analytics.etanalytics.b(this.d, this.p);
        }
        if (com.salesforce.marketingcloud.b.a(i, 512)) {
            com.salesforce.marketingcloud.analytics.piwama.i iVar = this.m;
            if (iVar != null) {
                iVar.a(false);
                this.m = null;
            }
            com.salesforce.marketingcloud.analytics.piwama.i.a(this.d, this.g, this.p, com.salesforce.marketingcloud.b.c(i, 512));
        } else if (this.m == null && this.i.piAnalyticsEnabled()) {
            this.m = new com.salesforce.marketingcloud.analytics.piwama.i(this.i, this.d, this.g, this.p);
        }
        if (this.l != null || this.k != null) {
            if (this.f34o == null) {
                this.f34o = new com.salesforce.marketingcloud.analytics.etanalytics.c(this.i, this.h, this.d, this.g, this.j, this.p);
            }
        } else {
            this.j.d(com.salesforce.marketingcloud.alarms.a.EnumC0062a.d);
            com.salesforce.marketingcloud.analytics.etanalytics.c cVar2 = this.f34o;
            if (cVar2 != null) {
                cVar2.b();
                this.f34o = null;
            }
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void disableAnalytics() {
        synchronized (u) {
            this.q = com.salesforce.marketingcloud.toggles.a.DISABLED;
            this.d.e().edit().putString(s, this.q.name()).apply();
            com.salesforce.marketingcloud.analytics.etanalytics.b bVar = this.k;
            if (bVar != null) {
                bVar.a(true);
                this.k = null;
            }
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void disablePiAnalytics() {
        synchronized (u) {
            this.r = com.salesforce.marketingcloud.toggles.a.DISABLED;
            this.d.e().edit().putString(t, this.r.name()).apply();
            com.salesforce.marketingcloud.g.a(AnalyticsManager.TAG, "Pi Analytics runtime toggle set to " + this.r.name(), new Object[0]);
            com.salesforce.marketingcloud.analytics.piwama.i iVar = this.m;
            if (iVar != null) {
                iVar.a(true);
                this.m = null;
            }
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void enableAnalytics() {
        synchronized (u) {
            if (com.salesforce.marketingcloud.b.a(com.salesforce.marketingcloud.b.a(this.d.j()), 256)) {
                return;
            }
            this.q = com.salesforce.marketingcloud.toggles.a.ENABLED;
            this.d.e().edit().putString(s, this.q.name()).apply();
            this.k = new com.salesforce.marketingcloud.analytics.etanalytics.b(this.d, this.p);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void enablePiAnalytics() {
        synchronized (u) {
            if (com.salesforce.marketingcloud.b.a(com.salesforce.marketingcloud.b.a(this.d.j()), 512)) {
                return;
            }
            this.r = com.salesforce.marketingcloud.toggles.a.ENABLED;
            this.d.e().edit().putString(t, this.r.name()).apply();
            com.salesforce.marketingcloud.g.a(AnalyticsManager.TAG, "Pi Analytics runtime toggle set to " + this.r.name(), new Object[0]);
            this.m = new com.salesforce.marketingcloud.analytics.piwama.i(this.i, this.d, this.g, this.p);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public String getPiIdentifier() {
        com.salesforce.marketingcloud.analytics.piwama.i iVar = this.m;
        if (iVar != null) {
            return iVar.getPiIdentifier();
        }
        return null;
    }

    @Override // com.salesforce.marketingcloud.e
    public void init(@NonNull InitializationStatus.a aVar, int i) {
        boolean zA = a(i, a(s, this.q));
        if (com.salesforce.marketingcloud.b.b(i, 2048)) {
            this.l = new com.salesforce.marketingcloud.analytics.etanalytics.a(this.d, this.p);
            this.f33n = new com.salesforce.marketingcloud.analytics.stats.c(this.i, this.h, zA, this.d, this.g, this.j, this.p);
        }
        b(i, a(t, this.r));
        if (this.l != null || this.k != null) {
            this.f34o = new com.salesforce.marketingcloud.analytics.etanalytics.c(this.i, this.h, this.d, this.g, this.j, this.p);
        }
        this.e.a(this, this.f);
        this.j.a(this, com.salesforce.marketingcloud.alarms.a.EnumC0062a.l);
    }

    @Override // com.salesforce.marketingcloud.behaviors.b
    public void onBehavior(@NonNull com.salesforce.marketingcloud.behaviors.a aVar, @NonNull Bundle bundle) {
        int i = b.a[aVar.ordinal()];
        if (i == 1) {
            a(bundle);
            return;
        }
        if (i == 2) {
            b(bundle);
        } else if (i == 3 || i == 4) {
            c(bundle);
        }
    }

    @Override // com.salesforce.marketingcloud.messages.RegionMessageManager.RegionTransitionEventListener
    public void onTransitionEvent(int i, @NonNull Region region) {
        if (i == 1) {
            com.salesforce.marketingcloud.analytics.etanalytics.a aVar = this.l;
            if (aVar != null) {
                aVar.a(region);
            }
            com.salesforce.marketingcloud.analytics.etanalytics.b bVar = this.k;
            if (bVar != null) {
                bVar.a(region);
            }
            com.salesforce.marketingcloud.analytics.piwama.i iVar = this.m;
            if (iVar != null) {
                iVar.a(region);
            }
            com.salesforce.marketingcloud.analytics.stats.c cVar = this.f33n;
            if (cVar != null) {
                cVar.a(region);
                return;
            }
            return;
        }
        if (i != 2) {
            return;
        }
        com.salesforce.marketingcloud.analytics.etanalytics.a aVar2 = this.l;
        if (aVar2 != null) {
            aVar2.b(region);
        }
        com.salesforce.marketingcloud.analytics.etanalytics.b bVar2 = this.k;
        if (bVar2 != null) {
            bVar2.b(region);
        }
        com.salesforce.marketingcloud.analytics.piwama.i iVar2 = this.m;
        if (iVar2 != null) {
            iVar2.b(region);
        }
        com.salesforce.marketingcloud.analytics.stats.c cVar2 = this.f33n;
        if (cVar2 != null) {
            cVar2.b(region);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void setPiIdentifier(@Nullable @Size(min = 1) String str) {
        if (str != null && TextUtils.getTrimmedLength(str) == 0) {
            com.salesforce.marketingcloud.g.e(AnalyticsManager.TAG, "Call to setPiIdentifier() ignored. Predictive Intelligence Identifier contained only whitespace.", new Object[0]);
            return;
        }
        com.salesforce.marketingcloud.analytics.piwama.i iVar = this.m;
        if (iVar != null) {
            iVar.setPiIdentifier(str);
        }
    }

    @Override // com.salesforce.marketingcloud.d
    public void tearDown(boolean z) {
        this.e.a(this);
        this.j.e(com.salesforce.marketingcloud.alarms.a.EnumC0062a.l);
        com.salesforce.marketingcloud.analytics.etanalytics.a aVar = this.l;
        if (aVar != null) {
            aVar.a(z);
            this.l = null;
        }
        com.salesforce.marketingcloud.analytics.etanalytics.b bVar = this.k;
        if (bVar != null) {
            bVar.a(z);
            this.k = null;
        }
        com.salesforce.marketingcloud.analytics.etanalytics.c cVar = this.f34o;
        if (cVar != null) {
            cVar.b();
            this.f34o = null;
        }
        com.salesforce.marketingcloud.analytics.stats.c cVar2 = this.f33n;
        if (cVar2 != null) {
            cVar2.a(z);
            this.f33n = null;
        }
        com.salesforce.marketingcloud.analytics.piwama.i iVar = this.m;
        if (iVar != null) {
            iVar.a(z);
            this.m = null;
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void trackCartContents(@NonNull PiCart piCart) {
        if (piCart == null) {
            com.salesforce.marketingcloud.g.e(AnalyticsManager.TAG, "PiCart may not be null.  We could not complete your trackCartContents() request.", new Object[0]);
            return;
        }
        com.salesforce.marketingcloud.analytics.etanalytics.a aVar = this.l;
        if (aVar != null) {
            aVar.trackCartContents(piCart);
        }
        com.salesforce.marketingcloud.analytics.etanalytics.b bVar = this.k;
        if (bVar != null) {
            bVar.trackCartContents(piCart);
        }
        com.salesforce.marketingcloud.analytics.piwama.i iVar = this.m;
        if (iVar != null) {
            iVar.trackCartContents(piCart);
        }
        com.salesforce.marketingcloud.analytics.stats.c cVar = this.f33n;
        if (cVar != null) {
            cVar.trackCartContents(piCart);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void trackCartConversion(@NonNull PiOrder piOrder) {
        if (piOrder == null) {
            com.salesforce.marketingcloud.g.e(AnalyticsManager.TAG, "PiOrder may not be null.  We could not complete your trackCartConversion() request.", new Object[0]);
            return;
        }
        com.salesforce.marketingcloud.analytics.etanalytics.a aVar = this.l;
        if (aVar != null) {
            aVar.trackCartConversion(piOrder);
        }
        com.salesforce.marketingcloud.analytics.etanalytics.b bVar = this.k;
        if (bVar != null) {
            bVar.trackCartConversion(piOrder);
        }
        com.salesforce.marketingcloud.analytics.piwama.i iVar = this.m;
        if (iVar != null) {
            iVar.trackCartConversion(piOrder);
        }
        com.salesforce.marketingcloud.analytics.stats.c cVar = this.f33n;
        if (cVar != null) {
            cVar.trackCartConversion(piOrder);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void trackInboxOpenEvent(@NonNull InboxMessage inboxMessage) {
        this.p.b().execute(new a("track_inbox_open", new Object[0], inboxMessage));
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void trackPageView(@NonNull @Size(min = 1) String str) {
        trackPageView(str, null, null, null);
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void trackPageView(@NonNull @Size(min = 1) String str, @Nullable String str2) {
        trackPageView(str, str2, null, null);
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void trackPageView(@NonNull @Size(min = 1) String str, @Nullable String str2, @Nullable String str3) {
        trackPageView(str, str2, str3, null);
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void trackPageView(@NonNull @Size(min = 1) String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str)) {
            com.salesforce.marketingcloud.g.e(AnalyticsManager.TAG, "url may not be null or empty.  We could not complete your trackPageView() request.", new Object[0]);
            return;
        }
        com.salesforce.marketingcloud.analytics.etanalytics.a aVar = this.l;
        if (aVar != null) {
            aVar.trackPageView(str, str2, str3, str4);
        }
        com.salesforce.marketingcloud.analytics.etanalytics.b bVar = this.k;
        if (bVar != null) {
            bVar.trackPageView(str, str2, str3, str4);
        }
        com.salesforce.marketingcloud.analytics.piwama.i iVar = this.m;
        if (iVar != null) {
            iVar.trackPageView(str, str2, str3, str4);
        }
        com.salesforce.marketingcloud.analytics.stats.c cVar = this.f33n;
        if (cVar != null) {
            cVar.trackPageView(str, str2, str3, str4);
        }
    }

    private void b(Bundle bundle) {
        long j = bundle.getLong("timestamp", System.currentTimeMillis());
        com.salesforce.marketingcloud.alarms.b bVar = this.j;
        com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a = com.salesforce.marketingcloud.alarms.a.EnumC0062a.l;
        if (bVar.a(enumC0062a, System.currentTimeMillis())) {
            this.j.d(enumC0062a);
        }
        com.salesforce.marketingcloud.analytics.etanalytics.c cVar = this.f34o;
        if (cVar != null) {
            cVar.a();
        }
        com.salesforce.marketingcloud.analytics.etanalytics.a aVar = this.l;
        if (aVar != null) {
            aVar.b(j);
        }
        com.salesforce.marketingcloud.analytics.etanalytics.b bVar2 = this.k;
        if (bVar2 != null) {
            bVar2.b(j);
        }
        com.salesforce.marketingcloud.analytics.piwama.i iVar = this.m;
        if (iVar != null) {
            iVar.c();
            this.m.b(j);
        }
        com.salesforce.marketingcloud.analytics.stats.c cVar2 = this.f33n;
        if (cVar2 != null) {
            cVar2.a();
            this.f33n.b(j);
        }
    }

    private com.salesforce.marketingcloud.toggles.a a(String str, com.salesforce.marketingcloud.toggles.a aVar) {
        if (aVar != null) {
            return aVar;
        }
        String string = this.d.e().getString(str, null);
        if (string == null) {
            return com.salesforce.marketingcloud.toggles.a.UNKNOWN;
        }
        return com.salesforce.marketingcloud.toggles.a.valueOf(string);
    }

    private void a(Bundle bundle) {
        long j = bundle.getLong("timestamp", 0L);
        com.salesforce.marketingcloud.alarms.b bVar = this.j;
        com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a = com.salesforce.marketingcloud.alarms.a.EnumC0062a.l;
        if (bVar.a(enumC0062a, System.currentTimeMillis())) {
            this.j.d(enumC0062a);
        }
        com.salesforce.marketingcloud.analytics.etanalytics.a aVar = this.l;
        if (aVar != null) {
            aVar.a(j);
        }
        com.salesforce.marketingcloud.analytics.etanalytics.b bVar2 = this.k;
        if (bVar2 != null) {
            bVar2.a(j);
        }
        com.salesforce.marketingcloud.analytics.piwama.i iVar = this.m;
        if (iVar != null) {
            iVar.a(j);
            this.m.c();
        }
        com.salesforce.marketingcloud.analytics.stats.c cVar = this.f33n;
        if (cVar != null) {
            cVar.a(j);
            this.f33n.a();
        }
        com.salesforce.marketingcloud.analytics.etanalytics.c cVar2 = this.f34o;
        if (cVar2 != null) {
            cVar2.a();
        }
    }

    h(@NonNull MarketingCloudConfig marketingCloudConfig, @NonNull com.salesforce.marketingcloud.storage.h hVar, @NonNull String str, @NonNull com.salesforce.marketingcloud.alarms.b bVar, @NonNull com.salesforce.marketingcloud.behaviors.c cVar, @NonNull com.salesforce.marketingcloud.http.e eVar, com.salesforce.marketingcloud.analytics.etanalytics.a aVar, com.salesforce.marketingcloud.analytics.etanalytics.b bVar2, com.salesforce.marketingcloud.analytics.piwama.i iVar, com.salesforce.marketingcloud.internal.n nVar, com.salesforce.marketingcloud.analytics.stats.c cVar2, com.salesforce.marketingcloud.analytics.etanalytics.c cVar3) {
        this(marketingCloudConfig, hVar, str, bVar, cVar, eVar, nVar);
        this.l = aVar;
        this.k = bVar2;
        this.m = iVar;
        this.f33n = cVar2;
        this.f34o = cVar3;
    }

    @Override // com.salesforce.marketingcloud.analytics.j
    public void b(@NonNull NotificationMessage notificationMessage) {
        com.salesforce.marketingcloud.analytics.etanalytics.a aVar = this.l;
        if (aVar != null) {
            aVar.b(notificationMessage);
        }
        com.salesforce.marketingcloud.analytics.etanalytics.b bVar = this.k;
        if (bVar != null) {
            bVar.b(notificationMessage);
        }
        com.salesforce.marketingcloud.analytics.piwama.i iVar = this.m;
        if (iVar != null) {
            iVar.b(notificationMessage);
        }
        com.salesforce.marketingcloud.analytics.stats.c cVar = this.f33n;
        if (cVar != null) {
            cVar.b(notificationMessage);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.j
    public void a(@NonNull Map<String, String> map) {
        com.salesforce.marketingcloud.analytics.etanalytics.a aVar = this.l;
        if (aVar != null) {
            aVar.b(map);
        }
        com.salesforce.marketingcloud.analytics.etanalytics.b bVar = this.k;
        if (bVar != null) {
            bVar.b(map);
        }
        com.salesforce.marketingcloud.analytics.piwama.i iVar = this.m;
        if (iVar != null) {
            iVar.b(map);
        }
        com.salesforce.marketingcloud.analytics.stats.c cVar = this.f33n;
        if (cVar != null) {
            cVar.b(map);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.f
    public void b(@NonNull InAppMessage inAppMessage) {
        if (inAppMessage == null) {
            com.salesforce.marketingcloud.g.e(AnalyticsManager.TAG, "InAppMessage is null.  Call to onInAppMessageDownloaded() ignored.", new Object[0]);
            return;
        }
        com.salesforce.marketingcloud.analytics.etanalytics.a aVar = this.l;
        if (aVar != null) {
            aVar.b(inAppMessage);
        }
        com.salesforce.marketingcloud.analytics.etanalytics.b bVar = this.k;
        if (bVar != null) {
            bVar.b(inAppMessage);
        }
        com.salesforce.marketingcloud.analytics.piwama.i iVar = this.m;
        if (iVar != null) {
            iVar.b(inAppMessage);
        }
        com.salesforce.marketingcloud.analytics.stats.c cVar = this.f33n;
        if (cVar != null) {
            cVar.b(inAppMessage);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.j
    public void a(@NonNull NotificationMessage notificationMessage, int i, String str, String str2) {
        com.salesforce.marketingcloud.analytics.etanalytics.a aVar = this.l;
        if (aVar != null) {
            aVar.a(notificationMessage, i, str, str2);
        }
        com.salesforce.marketingcloud.analytics.etanalytics.b bVar = this.k;
        if (bVar != null) {
            bVar.a(notificationMessage, i, str, str2);
        }
        com.salesforce.marketingcloud.analytics.piwama.i iVar = this.m;
        if (iVar != null) {
            iVar.a(notificationMessage, i, str, str2);
        }
        com.salesforce.marketingcloud.analytics.stats.c cVar = this.f33n;
        if (cVar != null) {
            cVar.a(notificationMessage, i, str, str2);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.m
    public void b(@NonNull JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() > 0) {
            com.salesforce.marketingcloud.analytics.etanalytics.a aVar = this.l;
            if (aVar != null) {
                aVar.b(jSONObject);
            }
            com.salesforce.marketingcloud.analytics.etanalytics.b bVar = this.k;
            if (bVar != null) {
                bVar.b(jSONObject);
            }
            com.salesforce.marketingcloud.analytics.piwama.i iVar = this.m;
            if (iVar != null) {
                iVar.b(jSONObject);
            }
            com.salesforce.marketingcloud.analytics.stats.c cVar = this.f33n;
            if (cVar != null) {
                cVar.b(jSONObject);
                return;
            }
            return;
        }
        com.salesforce.marketingcloud.g.e(AnalyticsManager.TAG, "Information not valid. Call to onSyncGateTimeOutEvent() ignored", new Object[0]);
    }

    private void a() {
        com.salesforce.marketingcloud.g.c(AnalyticsManager.TAG, "attempt to send pending events Immediate", new Object[0]);
        com.salesforce.marketingcloud.analytics.stats.c cVar = this.f33n;
        if (cVar != null) {
            cVar.a();
        }
        com.salesforce.marketingcloud.analytics.etanalytics.c cVar2 = this.f34o;
        if (cVar2 != null) {
            cVar2.a();
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.j
    public void a(@NonNull NotificationMessage notificationMessage) {
        com.salesforce.marketingcloud.analytics.etanalytics.a aVar = this.l;
        if (aVar != null) {
            aVar.a(notificationMessage);
        }
        com.salesforce.marketingcloud.analytics.etanalytics.b bVar = this.k;
        if (bVar != null) {
            bVar.a(notificationMessage);
        }
        com.salesforce.marketingcloud.analytics.piwama.i iVar = this.m;
        if (iVar != null) {
            iVar.a(notificationMessage);
        }
        com.salesforce.marketingcloud.analytics.stats.c cVar = this.f33n;
        if (cVar != null) {
            cVar.a(notificationMessage);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.j
    public void a(@NonNull com.salesforce.marketingcloud.push.f fVar, @NonNull String str) {
        com.salesforce.marketingcloud.analytics.etanalytics.a aVar = this.l;
        if (aVar != null) {
            aVar.a(fVar, str);
        }
        com.salesforce.marketingcloud.analytics.etanalytics.b bVar = this.k;
        if (bVar != null) {
            bVar.a(fVar, str);
        }
        com.salesforce.marketingcloud.analytics.piwama.i iVar = this.m;
        if (iVar != null) {
            iVar.a(fVar, str);
        }
        com.salesforce.marketingcloud.analytics.stats.c cVar = this.f33n;
        if (cVar != null) {
            cVar.a(fVar, str);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.j
    public void a(@NonNull NotificationMessage notificationMessage, boolean z) {
        com.salesforce.marketingcloud.analytics.etanalytics.a aVar = this.l;
        if (aVar != null) {
            aVar.a(notificationMessage, z);
        }
        com.salesforce.marketingcloud.analytics.etanalytics.b bVar = this.k;
        if (bVar != null) {
            bVar.a(notificationMessage, z);
        }
        com.salesforce.marketingcloud.analytics.piwama.i iVar = this.m;
        if (iVar != null) {
            iVar.a(notificationMessage, z);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.g
    public void a(@NonNull InboxMessage inboxMessage) {
        if (inboxMessage == null) {
            com.salesforce.marketingcloud.g.e(AnalyticsManager.TAG, "InboxMessage is null.  Call to onMessageDownloaded() ignored.", new Object[0]);
            return;
        }
        com.salesforce.marketingcloud.analytics.etanalytics.a aVar = this.l;
        if (aVar != null) {
            aVar.a(inboxMessage);
        }
        com.salesforce.marketingcloud.analytics.etanalytics.b bVar = this.k;
        if (bVar != null) {
            bVar.a(inboxMessage);
        }
        com.salesforce.marketingcloud.analytics.piwama.i iVar = this.m;
        if (iVar != null) {
            iVar.a(inboxMessage);
        }
        com.salesforce.marketingcloud.analytics.stats.c cVar = this.f33n;
        if (cVar != null) {
            cVar.a(inboxMessage);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.f
    public void a(@NonNull InAppMessage inAppMessage, @NonNull com.salesforce.marketingcloud.messages.iam.j jVar) {
        if (inAppMessage != null && jVar != null) {
            com.salesforce.marketingcloud.analytics.etanalytics.a aVar = this.l;
            if (aVar != null) {
                aVar.a(inAppMessage, jVar);
            }
            com.salesforce.marketingcloud.analytics.etanalytics.b bVar = this.k;
            if (bVar != null) {
                bVar.a(inAppMessage, jVar);
            }
            com.salesforce.marketingcloud.analytics.piwama.i iVar = this.m;
            if (iVar != null) {
                iVar.a(inAppMessage, jVar);
            }
            com.salesforce.marketingcloud.analytics.stats.c cVar = this.f33n;
            if (cVar != null) {
                cVar.a(inAppMessage, jVar);
                return;
            }
            return;
        }
        com.salesforce.marketingcloud.g.e(AnalyticsManager.TAG, "InAppMessage or MessageCompletedEvent is null.  Call to onInAppMessageCompleted() ignored.", new Object[0]);
    }

    @Override // com.salesforce.marketingcloud.analytics.m
    public void a(@NonNull String str, @NonNull String str2, @NonNull String str3, @Nullable String str4) {
        if (str != null && str2 != null && str3 != null) {
            com.salesforce.marketingcloud.analytics.etanalytics.a aVar = this.l;
            if (aVar != null) {
                aVar.a(str, str2, str3, str4);
            }
            com.salesforce.marketingcloud.analytics.etanalytics.b bVar = this.k;
            if (bVar != null) {
                bVar.a(str, str2, str3, str4);
            }
            com.salesforce.marketingcloud.analytics.piwama.i iVar = this.m;
            if (iVar != null) {
                iVar.a(str, str2, str3, str4);
            }
            com.salesforce.marketingcloud.analytics.stats.c cVar = this.f33n;
            if (cVar != null) {
                cVar.a(str, str2, str3, str4);
                return;
            }
            return;
        }
        com.salesforce.marketingcloud.g.e(AnalyticsManager.TAG, "triggerId, outcomeId or outcomeType is null.  Call to onTriggerSuccessEvent() ignored.", new Object[0]);
    }

    @Override // com.salesforce.marketingcloud.analytics.m
    public void a(@NonNull JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() > 0) {
            com.salesforce.marketingcloud.analytics.etanalytics.a aVar = this.l;
            if (aVar != null) {
                aVar.a(jSONObject);
            }
            com.salesforce.marketingcloud.analytics.etanalytics.b bVar = this.k;
            if (bVar != null) {
                bVar.a(jSONObject);
            }
            com.salesforce.marketingcloud.analytics.piwama.i iVar = this.m;
            if (iVar != null) {
                iVar.a(jSONObject);
            }
            com.salesforce.marketingcloud.analytics.stats.c cVar = this.f33n;
            if (cVar != null) {
                cVar.a(jSONObject);
                return;
            }
            return;
        }
        com.salesforce.marketingcloud.g.e(AnalyticsManager.TAG, "Information not valid. Call to onInvalidConfigEvent() ignored", new Object[0]);
    }

    @Override // com.salesforce.marketingcloud.analytics.f
    public void a(@NonNull String str, @NonNull String str2, @NonNull List<String> list) {
        if (str != null && str2 != null && list != null && !list.isEmpty()) {
            com.salesforce.marketingcloud.analytics.etanalytics.a aVar = this.l;
            if (aVar != null) {
                aVar.a(str, str2, list);
            }
            com.salesforce.marketingcloud.analytics.etanalytics.b bVar = this.k;
            if (bVar != null) {
                bVar.a(str, str2, list);
            }
            com.salesforce.marketingcloud.analytics.piwama.i iVar = this.m;
            if (iVar != null) {
                iVar.a(str, str2, list);
            }
            com.salesforce.marketingcloud.analytics.stats.c cVar = this.f33n;
            if (cVar != null) {
                cVar.a(str, str2, list);
                return;
            }
            return;
        }
        com.salesforce.marketingcloud.g.e(AnalyticsManager.TAG, "messageId, activityInstanceId or reasons is null.  Call to onInAppMessageValidationError() ignored.", new Object[0]);
    }

    @Override // com.salesforce.marketingcloud.analytics.f
    public void a(@NonNull InAppMessage inAppMessage, @NonNull JSONObject jSONObject) {
        if (inAppMessage != null && jSONObject != null && jSONObject.length() > 0) {
            com.salesforce.marketingcloud.analytics.etanalytics.a aVar = this.l;
            if (aVar != null) {
                aVar.a(inAppMessage, jSONObject);
            }
            com.salesforce.marketingcloud.analytics.etanalytics.b bVar = this.k;
            if (bVar != null) {
                bVar.a(inAppMessage, jSONObject);
            }
            com.salesforce.marketingcloud.analytics.piwama.i iVar = this.m;
            if (iVar != null) {
                iVar.a(inAppMessage, jSONObject);
            }
            com.salesforce.marketingcloud.analytics.stats.c cVar = this.f33n;
            if (cVar != null) {
                cVar.a(inAppMessage, jSONObject);
                return;
            }
            return;
        }
        com.salesforce.marketingcloud.g.e(AnalyticsManager.TAG, "Message and/or Information not valid. Call to onInAppMessageThrottled() ignored", new Object[0]);
    }

    @Override // com.salesforce.marketingcloud.analytics.f
    public void a(@NonNull InAppMessage inAppMessage) {
        if (inAppMessage == null) {
            com.salesforce.marketingcloud.g.e(AnalyticsManager.TAG, "InAppMessage is null.  Call to onIamDisplayed() ignored.", new Object[0]);
            return;
        }
        com.salesforce.marketingcloud.analytics.etanalytics.a aVar = this.l;
        if (aVar != null) {
            aVar.a(inAppMessage);
        }
        com.salesforce.marketingcloud.analytics.etanalytics.b bVar = this.k;
        if (bVar != null) {
            bVar.a(inAppMessage);
        }
        com.salesforce.marketingcloud.analytics.piwama.i iVar = this.m;
        if (iVar != null) {
            iVar.a(inAppMessage);
        }
        com.salesforce.marketingcloud.analytics.stats.c cVar = this.f33n;
        if (cVar != null) {
            cVar.a(inAppMessage);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.n
    public void a(@NonNull e eVar, @NonNull Event... eventArr) {
        com.salesforce.marketingcloud.analytics.etanalytics.a aVar = this.l;
        if (aVar != null) {
            aVar.a(eVar, eventArr);
        }
        com.salesforce.marketingcloud.analytics.etanalytics.b bVar = this.k;
        if (bVar != null) {
            bVar.a(eVar, eventArr);
        }
        com.salesforce.marketingcloud.analytics.piwama.i iVar = this.m;
        if (iVar != null) {
            iVar.a(eVar, eventArr);
        }
        com.salesforce.marketingcloud.analytics.stats.c cVar = this.f33n;
        if (cVar != null) {
            cVar.a(eVar, eventArr);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.l
    public void a(@NonNull l.a aVar, @NonNull JSONObject jSONObject) {
        com.salesforce.marketingcloud.analytics.etanalytics.a aVar2 = this.l;
        if (aVar2 != null) {
            aVar2.a(aVar, jSONObject);
        }
        com.salesforce.marketingcloud.analytics.etanalytics.b bVar = this.k;
        if (bVar != null) {
            bVar.a(aVar, jSONObject);
        }
        com.salesforce.marketingcloud.analytics.piwama.i iVar = this.m;
        if (iVar != null) {
            iVar.a(aVar, jSONObject);
        }
        com.salesforce.marketingcloud.analytics.stats.c cVar = this.f33n;
        if (cVar != null) {
            cVar.a(aVar, jSONObject);
        }
    }

    @Override // com.salesforce.marketingcloud.alarms.b.InterfaceC0064b
    public void a(@NonNull com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a) {
        if (enumC0062a == com.salesforce.marketingcloud.alarms.a.EnumC0062a.l) {
            com.salesforce.marketingcloud.g.c(AnalyticsManager.TAG, "Handling alarm of type [%s]", enumC0062a.name());
            a();
        }
    }
}
