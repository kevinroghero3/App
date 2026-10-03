package com.salesforce.marketingcloud.analytics.piwama;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.analytics.PiCart;
import com.salesforce.marketingcloud.analytics.PiOrder;
import com.salesforce.marketingcloud.internal.n;
import com.salesforce.marketingcloud.messages.Region;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class i extends com.salesforce.marketingcloud.analytics.i implements com.salesforce.marketingcloud.http.e.c {
    static final String h = "user_id";
    static final String i = "session_id";
    static final int j = 100;
    static final String k = com.salesforce.marketingcloud.g.a("PiWamaAnalytic");
    private static final int l = 30;
    private static final String m = "et_background_time_cache";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f35n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f36o = 999;
    private static j p;
    final com.salesforce.marketingcloud.storage.h d;
    final com.salesforce.marketingcloud.http.e e;
    final n f;
    private final MarketingCloudConfig g;

    class a extends com.salesforce.marketingcloud.internal.i {
        final /* synthetic */ com.salesforce.marketingcloud.storage.h c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Object[] objArr, com.salesforce.marketingcloud.storage.h hVar) {
            super(str, objArr);
            this.c = hVar;
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            this.c.h().g(1);
        }
    }

    class b extends com.salesforce.marketingcloud.internal.i {
        final /* synthetic */ long c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, Object[] objArr, long j) {
            super(str, objArr);
            this.c = j;
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            try {
                com.salesforce.marketingcloud.storage.a aVarH = i.this.d.h();
                for (com.salesforce.marketingcloud.analytics.b bVar : aVarH.h(i.this.d.b())) {
                    int seconds = (int) TimeUnit.MILLISECONDS.toSeconds(this.c - bVar.b().getTime());
                    if (seconds > 0) {
                        bVar.b(seconds);
                        bVar.a(true);
                        bVar.d(i.this.a());
                        aVarH.b(bVar, i.this.d.b());
                    }
                }
                com.salesforce.marketingcloud.analytics.b bVarA = com.salesforce.marketingcloud.analytics.b.a(new Date(this.c), 1, 2);
                bVarA.d(i.this.a());
                bVarA.a(true);
                bVarA.c(new com.salesforce.marketingcloud.analytics.piwama.b(new Date(this.c)).c().toString());
                aVarH.a(bVarA, i.this.d.b());
            } catch (Exception e) {
                com.salesforce.marketingcloud.g.b(i.k, e, "Failed to update our PiWama TimeInApp.", new Object[0]);
            }
        }
    }

    class c extends com.salesforce.marketingcloud.internal.i {
        final /* synthetic */ NotificationMessage c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, Object[] objArr, NotificationMessage notificationMessage) {
            super(str, objArr);
            this.c = notificationMessage;
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            if (i.this.d.h().c(1)) {
                i.this.a(System.currentTimeMillis());
            }
            Date date = new Date();
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.c.id());
            Region region = this.c.region();
            if (region != null) {
                arrayList.add(region.id());
            }
            com.salesforce.marketingcloud.analytics.b bVarA = com.salesforce.marketingcloud.analytics.b.a(date, 1, 5, (List<String>) arrayList, false);
            bVarA.d(i.this.a());
            bVarA.c(new e(date, true, bVarA.i()).c().toString());
            i.this.f.b().execute(new com.salesforce.marketingcloud.analytics.a(i.this.d.h(), i.this.d.b(), bVarA));
        }
    }

    class d extends com.salesforce.marketingcloud.internal.i {
        d(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            i iVar = i.this;
            i.a(iVar.e, iVar.d.h().a(i.this.d.b(), 999));
        }
    }

    public i(@NonNull MarketingCloudConfig marketingCloudConfig, @NonNull com.salesforce.marketingcloud.storage.h hVar, @NonNull com.salesforce.marketingcloud.http.e eVar, @NonNull n nVar) {
        com.salesforce.marketingcloud.util.g.a(marketingCloudConfig, "MarketingCloudConfig may not be null.");
        this.d = (com.salesforce.marketingcloud.storage.h) com.salesforce.marketingcloud.util.g.a(hVar, "MCStorage may not be null.");
        this.e = (com.salesforce.marketingcloud.http.e) com.salesforce.marketingcloud.util.g.a(eVar, "RequestManager may not be null.");
        this.g = marketingCloudConfig;
        p = a(marketingCloudConfig) ? new k(marketingCloudConfig, hVar) : new com.salesforce.marketingcloud.analytics.piwama.a(marketingCloudConfig, hVar);
        eVar.a(com.salesforce.marketingcloud.http.b.j, this);
        this.f = nVar;
    }

    public static void a(com.salesforce.marketingcloud.storage.h hVar, com.salesforce.marketingcloud.http.e eVar, n nVar, boolean z) {
        if (z) {
            a(hVar, nVar);
            hVar.c().a("predictive_intelligence_identifier");
        }
        eVar.a(com.salesforce.marketingcloud.http.b.j);
    }

    static List<List<com.salesforce.marketingcloud.analytics.b>> b(List<com.salesforce.marketingcloud.analytics.b> list) {
        int size = list.size();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (int i3 = size; i3 > 0; i3 -= 100) {
            int i4 = i2 * 100;
            i2++;
            int i5 = i2 * 100;
            if (i5 > size) {
                i5 = i3 + i4;
            }
            arrayList.add(new ArrayList(list.subList(i4, i5)));
        }
        return arrayList;
    }

    public void c() {
        this.f.b().execute(new d("send_pi_analytics", new Object[0]));
    }

    @Override // com.salesforce.marketingcloud.analytics.i, com.salesforce.marketingcloud.analytics.AnalyticsManager
    public String getPiIdentifier() {
        return this.d.c().b("predictive_intelligence_identifier", null);
    }

    @Override // com.salesforce.marketingcloud.analytics.i, com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void setPiIdentifier(@Nullable @Size(min = 1) String str) {
        if (str == null) {
            this.d.c().a("predictive_intelligence_identifier");
        } else {
            this.d.c().a("predictive_intelligence_identifier", str.trim());
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.i, com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void trackCartContents(@NonNull PiCart piCart) {
        if (piCart != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                a(new f(piCart, new Date(jCurrentTimeMillis)), jCurrentTimeMillis);
            } catch (Exception e) {
                com.salesforce.marketingcloud.g.b(k, e, "Failed to add PiWamaAnalytic for trackCartContents.  See LogCat for details.", new Object[0]);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.i, com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void trackCartConversion(@NonNull PiOrder piOrder) {
        if (piOrder != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                a(new g(piOrder, new Date(jCurrentTimeMillis)), jCurrentTimeMillis);
            } catch (IllegalArgumentException e) {
                com.salesforce.marketingcloud.g.b(k, e, "Failed to add PiWamaAnalytic for trackCartConversion.  See LogCat for details.", new Object[0]);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.i, com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void trackPageView(@NonNull @Size(min = 1) String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            a(new h(str, str2, str3, str4, new Date(jCurrentTimeMillis)), jCurrentTimeMillis);
        } catch (IllegalArgumentException e) {
            com.salesforce.marketingcloud.g.b(k, e, "Failed to record PiWamaItem for trackPageView.", new Object[0]);
        }
    }

    private static void a(com.salesforce.marketingcloud.storage.h hVar, n nVar) {
        nVar.b().execute(new a("deleting_pi_analytics", new Object[0], hVar));
    }

    static void a(com.salesforce.marketingcloud.http.e eVar, List<com.salesforce.marketingcloud.analytics.b> list) {
        MarketingCloudSdk marketingCloudSdk;
        if ((!MarketingCloudSdk.isReady() && !MarketingCloudSdk.isInitializing()) || (marketingCloudSdk = MarketingCloudSdk.getInstance()) == null || list.isEmpty()) {
            return;
        }
        Iterator<List<com.salesforce.marketingcloud.analytics.b>> it2 = a(list).iterator();
        while (it2.hasNext()) {
            for (List<com.salesforce.marketingcloud.analytics.b> list2 : b(it2.next())) {
                com.salesforce.marketingcloud.http.c cVarA = p.a(marketingCloudSdk.getRegistrationManager(), marketingCloudSdk.getPushMessageManager(), marketingCloudSdk.getRegionMessageManager(), list2);
                cVarA.a(com.salesforce.marketingcloud.analytics.c.a(list2));
                eVar.a(cVarA);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.i
    public void b(long j2) {
        Date date = new Date(j2);
        b();
        if (this.d.h().c(1)) {
            return;
        }
        try {
            com.salesforce.marketingcloud.analytics.b bVarA = com.salesforce.marketingcloud.analytics.b.a(date, 1, 5);
            bVarA.c(new e(date, false, Collections.emptyList()).c().toString());
            this.f.b().execute(new com.salesforce.marketingcloud.analytics.a(this.d.h(), this.d.b(), bVarA));
        } catch (Exception e) {
            com.salesforce.marketingcloud.g.b(k, e, "Failed to create WamaItem for TimeInApp.", new Object[0]);
        }
    }

    static List<List<com.salesforce.marketingcloud.analytics.b>> a(List<com.salesforce.marketingcloud.analytics.b> list) {
        ArrayList arrayList = new ArrayList();
        Collections.sort(list, new Comparator() { // from class: com.salesforce.marketingcloud.analytics.piwama.i$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return i.a((com.salesforce.marketingcloud.analytics.b) obj, (com.salesforce.marketingcloud.analytics.b) obj2);
            }
        });
        ArrayList arrayList2 = new ArrayList();
        String strF = null;
        for (com.salesforce.marketingcloud.analytics.b bVar : list) {
            if ((strF != null && strF.equals(bVar.f())) || bVar.f() == null) {
                arrayList2.add(bVar);
            } else {
                if (!arrayList2.isEmpty()) {
                    arrayList.add(arrayList2);
                }
                strF = bVar.f();
                arrayList2 = new ArrayList();
                arrayList2.add(bVar);
            }
        }
        arrayList.add(arrayList2);
        return arrayList;
    }

    private void b() {
        long j2 = this.d.e().getLong(m, -1L);
        if (j2 != -1) {
            this.d.e().edit().remove(m).apply();
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j2);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(12, -30);
            if (calendar.before(calendar2)) {
                this.d.c().a(com.salesforce.marketingcloud.storage.b.f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(com.salesforce.marketingcloud.analytics.b bVar, com.salesforce.marketingcloud.analytics.b bVar2) {
        if (bVar.f() == null) {
            return bVar2.f() == null ? 0 : -1;
        }
        if (bVar2.f() == null) {
            return 1;
        }
        return bVar.f().compareTo(bVar2.f());
    }

    @Override // com.salesforce.marketingcloud.analytics.i
    public void a(boolean z) {
        if (z) {
            a(this.d, this.f);
        }
        com.salesforce.marketingcloud.http.e eVar = this.e;
        if (eVar != null) {
            eVar.a(com.salesforce.marketingcloud.http.b.j);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.i
    public void a(long j2) {
        this.d.e().edit().putLong(m, j2).apply();
        this.f.b().execute(new b("end_time_in_app", new Object[0], j2));
    }

    @Override // com.salesforce.marketingcloud.analytics.i, com.salesforce.marketingcloud.analytics.j
    public void a(@NonNull NotificationMessage notificationMessage) {
        try {
            this.f.b().execute(new c("notification_opened", new Object[0], notificationMessage));
        } catch (Exception e) {
            com.salesforce.marketingcloud.g.b(k, e, "Failed to store our WamaItem for message opened.", new Object[0]);
        }
    }

    @Override // com.salesforce.marketingcloud.http.e.c
    public void a(com.salesforce.marketingcloud.http.c cVar, com.salesforce.marketingcloud.http.f fVar) {
        if (fVar.p()) {
            try {
                JSONObject jSONObject = new JSONObject(fVar.j());
                a(com.salesforce.marketingcloud.analytics.c.a(cVar.r() != null ? cVar.r() : ""), jSONObject.getString("user_id"), jSONObject.getString("session_id"));
                return;
            } catch (Exception e) {
                com.salesforce.marketingcloud.g.b(k, e, "Error parsing response.", new Object[0]);
                return;
            }
        }
        com.salesforce.marketingcloud.g.c(k, "Request failed: %d - %s", Integer.valueOf(fVar.k()), fVar.n());
    }

    private boolean a(@NonNull MarketingCloudConfig marketingCloudConfig) {
        String strTrim = marketingCloudConfig.predictiveIntelligenceServerUrl().toLowerCase(Locale.ENGLISH).trim();
        return (strTrim.startsWith("https://stage.app.igodigital.com/api/v1/collect/qa/qa1s1/process_batch") || strTrim.startsWith("https://stage.app.igodigital.com/api/v1/collect/qa/qa3s1/process_batch") || strTrim.startsWith("https://app.igodigital.com/api/v1/collect/process_batch")) ? false : true;
    }

    private void a(String[] strArr, String str, String str2) {
        this.d.c().a(com.salesforce.marketingcloud.storage.b.g, str);
        this.d.c().a(com.salesforce.marketingcloud.storage.b.f, str2);
        if (strArr != null) {
            this.f.b().execute(new com.salesforce.marketingcloud.analytics.d(this.d.h(), strArr));
        }
    }

    private void a(@NonNull com.salesforce.marketingcloud.analytics.piwama.c cVar, long j2) throws IllegalArgumentException {
        JSONObject jSONObjectC = cVar.c();
        if (jSONObjectC != null) {
            try {
                com.salesforce.marketingcloud.analytics.b bVarA = com.salesforce.marketingcloud.analytics.b.a(new Date(j2), 1, cVar.b());
                bVarA.d(a());
                bVarA.c(jSONObjectC.toString());
                bVarA.a(true);
                if (TextUtils.isEmpty(bVarA.e())) {
                    return;
                }
                this.f.b().execute(new com.salesforce.marketingcloud.analytics.a(this.d.h(), this.d.b(), bVarA));
                return;
            } catch (Exception e) {
                com.salesforce.marketingcloud.g.b(k, e, "Failed to record PiWamaItem in local storage.", new Object[0]);
                throw new IllegalArgumentException("Failed to record PiWamaItem in local storage.");
            }
        }
        throw new IllegalArgumentException("Failed to convert your input type to a JSON Object.");
    }

    String a() {
        String piIdentifier = getPiIdentifier();
        return (piIdentifier == null && this.g.useLegacyPiIdentifier()) ? com.salesforce.marketingcloud.registration.d.a(this.d) : piIdentifier;
    }
}
