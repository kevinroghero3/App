package com.salesforce.marketingcloud.messages.geofence;

import android.location.Location;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.g;
import com.salesforce.marketingcloud.internal.i;
import com.salesforce.marketingcloud.internal.n;
import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.location.f;
import com.salesforce.marketingcloud.messages.Message;
import com.salesforce.marketingcloud.messages.Region;
import com.salesforce.marketingcloud.storage.h;
import com.salesforce.marketingcloud.storage.j;
import com.salesforce.marketingcloud.util.Crypto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.salesforce.marketingcloud.messages.c, com.salesforce.marketingcloud.location.c, com.salesforce.marketingcloud.http.e.c {
    static final String k = g.a("GeofenceMessageManager");
    final f d;
    final h e;
    final com.salesforce.marketingcloud.messages.c.a f;
    final com.salesforce.marketingcloud.http.e g;
    private final n h;
    AtomicBoolean i = new AtomicBoolean(false);
    private com.salesforce.marketingcloud.messages.c.b j;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.geofence.a$a, reason: collision with other inner class name */
    class C0085a implements MarketingCloudSdk.WhenReadyListener {
        final /* synthetic */ MarketingCloudConfig a;
        final /* synthetic */ String b;
        final /* synthetic */ LatLon c;

        C0085a(MarketingCloudConfig marketingCloudConfig, String str, LatLon latLon) {
            this.a = marketingCloudConfig;
            this.b = str;
            this.c = latLon;
        }

        @Override // com.salesforce.marketingcloud.MarketingCloudSdk.WhenReadyListener
        public void ready(@NonNull MarketingCloudSdk marketingCloudSdk) {
            a aVar = a.this;
            aVar.g.a(com.salesforce.marketingcloud.http.b.f53n.a(this.a, aVar.e.c(), com.salesforce.marketingcloud.http.b.a(this.a.applicationId(), this.b, this.c)));
        }
    }

    class b extends i {
        final /* synthetic */ String c;
        final /* synthetic */ int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, Object[] objArr, String str2, int i) {
            super(str, objArr);
            this.c = str2;
            this.d = i;
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            try {
                j jVarO = a.this.e.o();
                Region regionA = jVarO.a(this.c, a.this.e.b());
                int i = 0;
                if (regionA == null) {
                    g.c(a.k, "Removing stale geofence from being monitored.", new Object[0]);
                    a.this.d.a(Collections.singletonList(this.c));
                    return;
                }
                int i2 = this.d;
                if (i2 == 1) {
                    a.this.f.b(regionA);
                    i = 3;
                } else if (i2 == 2) {
                    a.this.f.a(regionA);
                    i = 4;
                }
                if (i != 0) {
                    List<String> listC = jVarO.c(regionA.id(), i);
                    if (listC.isEmpty()) {
                        return;
                    }
                    com.salesforce.marketingcloud.storage.i iVarN = a.this.e.n();
                    Crypto cryptoB = a.this.e.b();
                    for (String str : listC) {
                        Message messageA = iVarN.a(str, cryptoB);
                        if (messageA != null) {
                            a.this.f.a(regionA, messageA);
                        } else {
                            g.a(a.k, "Message with id [%s] not found", str);
                        }
                    }
                }
            } catch (Exception e) {
                g.b(a.k, e, "Geofence (%s - %d) was tripped, but failed to check for associated message", this.c, Integer.valueOf(this.d));
            }
        }
    }

    class c extends i {
        c(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            List<String> listD = a.this.e.o().d(1);
            if (!listD.isEmpty()) {
                a.this.d.a(listD);
            }
            a.this.e.o().f(1);
        }
    }

    class d extends i {
        final /* synthetic */ GeofenceMessageResponse c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, Object[] objArr, GeofenceMessageResponse geofenceMessageResponse) {
            super(str, objArr);
            this.c = geofenceMessageResponse;
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            j jVarO = a.this.e.o();
            List<String> listD = jVarO.d(1);
            jVarO.f(1);
            com.salesforce.marketingcloud.storage.i iVarN = a.this.e.n();
            Crypto cryptoB = a.this.e.b();
            if (!this.c.fences().isEmpty()) {
                ArrayList arrayList = new ArrayList();
                Iterator<Region> it2 = this.c.fences().iterator();
                while (true) {
                    boolean z = false;
                    if (!it2.hasNext()) {
                        break;
                    }
                    Region next = it2.next();
                    try {
                        for (Message message : next.messages()) {
                            com.salesforce.marketingcloud.messages.b.a(message, iVarN, cryptoB);
                            iVarN.a(message, cryptoB);
                            z = true;
                        }
                        if (z) {
                            if (!listD.remove(next.id())) {
                                arrayList.add(next);
                            }
                            jVarO.a(next, cryptoB);
                        }
                    } catch (Exception e) {
                        g.b(a.k, e, "Unable to start monitoring geofence region: %s", next.id());
                    }
                }
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    a.this.d.a(a.a((Region) it3.next()));
                }
            }
            if (!listD.isEmpty()) {
                a.this.d.a(listD);
            }
            a.this.i.set(true);
        }
    }

    class e extends i {
        e(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            if (a.this.i.get()) {
                g.d(a.k, "Attempt to monitor fences from DB ignored, because they're already monitored.", new Object[0]);
            }
            g.d(a.k, "monitorStoredRegions", new Object[0]);
            try {
                List<Region> listA = a.this.e.o().a(1, a.this.e.b());
                if (listA.isEmpty()) {
                    return;
                }
                Iterator<Region> it2 = listA.iterator();
                while (it2.hasNext()) {
                    a.this.d.a(a.a(it2.next()));
                }
            } catch (Exception e) {
                g.b(a.k, e, "Unable to monitor stored geofence regions.", new Object[0]);
            }
        }
    }

    public a(@NonNull h hVar, @NonNull f fVar, @NonNull com.salesforce.marketingcloud.http.e eVar, n nVar, @NonNull com.salesforce.marketingcloud.messages.c.a aVar) {
        this.e = hVar;
        this.d = fVar;
        this.g = eVar;
        this.f = aVar;
        this.h = nVar;
        eVar.a(com.salesforce.marketingcloud.http.b.f53n, this);
    }

    private static int a(int i) {
        if (i < 100) {
            return 100;
        }
        return i;
    }

    @Override // com.salesforce.marketingcloud.messages.c
    public void b() {
        f fVar = this.d;
        if (fVar != null) {
            fVar.b(this);
            if (this.e != null) {
                this.h.b().execute(new c("disable_fence_tracking", new Object[0]));
            }
        }
        this.g.a(com.salesforce.marketingcloud.http.b.f53n);
        this.i.set(false);
    }

    @Override // com.salesforce.marketingcloud.messages.c
    public void c() {
        this.h.b().execute(new e("monitor_stored_regions", new Object[0]));
    }

    public boolean d() {
        return this.d.a();
    }

    public static void a(h hVar, f fVar, com.salesforce.marketingcloud.http.e eVar, boolean z) {
        List<String> listD = hVar.o().d(1);
        if (!listD.isEmpty()) {
            fVar.a(listD);
        }
        if (z) {
            hVar.o().f(1);
            com.salesforce.marketingcloud.storage.i iVarN = hVar.n();
            iVarN.e(3);
            iVarN.e(4);
        }
        eVar.a(com.salesforce.marketingcloud.http.b.f53n);
    }

    static com.salesforce.marketingcloud.location.b a(Region region) {
        return new com.salesforce.marketingcloud.location.b(region.id(), a(region.radius()), region.center().latitude(), region.center().longitude(), 3);
    }

    @Override // com.salesforce.marketingcloud.messages.c
    public void a(LatLon latLon, String str, MarketingCloudConfig marketingCloudConfig, com.salesforce.marketingcloud.messages.c.b bVar) {
        this.j = bVar;
        try {
            MarketingCloudSdk.requestSdk(new C0085a(marketingCloudConfig, str, latLon));
        } catch (Exception e2) {
            g.b(k, e2, "Failed to update geofence messages", new Object[0]);
        }
    }

    @Override // com.salesforce.marketingcloud.location.c
    public void a(@NonNull String str, int i, @Nullable Location location) {
        String str2 = k;
        g.d(str2, "Geofence (%s - %s) was tripped.", str, Integer.valueOf(i));
        if (i == 4) {
            g.d(str2, "Dwell transition ignore for %s", str);
        } else {
            this.h.b().execute(new b("fence_event", new Object[0], str, i));
        }
    }

    @Override // com.salesforce.marketingcloud.location.c
    public void a(int i, @Nullable String str) {
        g.a(k, "Region error %d - %s", Integer.valueOf(i), str);
    }

    @Override // com.salesforce.marketingcloud.messages.c
    public void a() {
        this.d.a(this);
        this.g.a(com.salesforce.marketingcloud.http.b.f53n, this);
    }

    @Override // com.salesforce.marketingcloud.http.e.c
    public void a(com.salesforce.marketingcloud.http.c cVar, com.salesforce.marketingcloud.http.f fVar) {
        if (fVar.p()) {
            try {
                a(new GeofenceMessageResponse(new JSONObject(fVar.j())));
                return;
            } catch (Exception e2) {
                g.b(k, e2, "Error parsing response.", new Object[0]);
                return;
            }
        }
        String str = k;
        int iK = fVar.k();
        g.c(str, "Request failed: %d - %s", Integer.valueOf(iK), fVar.n());
    }

    void a(GeofenceMessageResponse geofenceMessageResponse) {
        g.c(k, "Geofence message request contained %d regions", Integer.valueOf(geofenceMessageResponse.fences().size()));
        com.salesforce.marketingcloud.messages.c.b bVar = this.j;
        if (bVar != null) {
            bVar.a(geofenceMessageResponse);
        }
        this.h.b().execute(new d("fence_response", new Object[0], geofenceMessageResponse));
    }
}
