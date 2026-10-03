package com.salesforce.marketingcloud.messages.proximity;

import androidx.annotation.NonNull;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.g;
import com.salesforce.marketingcloud.http.f;
import com.salesforce.marketingcloud.internal.i;
import com.salesforce.marketingcloud.internal.l;
import com.salesforce.marketingcloud.internal.n;
import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.messages.Message;
import com.salesforce.marketingcloud.messages.Region;
import com.salesforce.marketingcloud.storage.h;
import com.salesforce.marketingcloud.storage.j;
import com.salesforce.marketingcloud.util.Crypto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.salesforce.marketingcloud.messages.c, com.salesforce.marketingcloud.proximity.e.a, com.salesforce.marketingcloud.http.e.c {
    static final String j = g.a("ProximityMessageManager");
    final h d;
    final com.salesforce.marketingcloud.proximity.e e;
    final com.salesforce.marketingcloud.messages.c.a f;
    final com.salesforce.marketingcloud.http.e g;
    private final n h;
    private com.salesforce.marketingcloud.messages.c.b i;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.proximity.a$a, reason: collision with other inner class name */
    class C0089a implements MarketingCloudSdk.WhenReadyListener {
        final /* synthetic */ MarketingCloudConfig a;
        final /* synthetic */ String b;
        final /* synthetic */ LatLon c;

        C0089a(MarketingCloudConfig marketingCloudConfig, String str, LatLon latLon) {
            this.a = marketingCloudConfig;
            this.b = str;
            this.c = latLon;
        }

        @Override // com.salesforce.marketingcloud.MarketingCloudSdk.WhenReadyListener
        public void ready(@NonNull MarketingCloudSdk marketingCloudSdk) {
            a aVar = a.this;
            aVar.g.a(com.salesforce.marketingcloud.http.b.f54o.a(this.a, aVar.d.c(), com.salesforce.marketingcloud.http.b.a(this.a.applicationId(), this.b, this.c)));
        }
    }

    class b extends i {
        b(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            a.this.d.o().f(3);
        }
    }

    class c extends i {
        final /* synthetic */ com.salesforce.marketingcloud.proximity.c c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, Object[] objArr, com.salesforce.marketingcloud.proximity.c cVar) {
            super(str, objArr);
            this.c = cVar;
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            try {
                j jVarO = a.this.d.o();
                Region regionA = jVarO.a(this.c.n(), a.this.d.b());
                if (regionA == null) {
                    g.a(a.j, "BeaconRegion [%s] did not have matching Region in storage.", this.c);
                    return;
                }
                if (l.a(regionA)) {
                    g.a(a.j, "Ignoring entry event.  Already inside Region [%s]", regionA);
                    return;
                }
                g.d(a.j, "Region [%s] was entered.  Will attempt to show associated message.", regionA.id());
                l.a(regionA, true);
                jVarO.a(regionA.id(), true);
                a.this.f.b(regionA);
                List<String> listC = jVarO.c(regionA.id(), 5);
                if (listC.isEmpty()) {
                    return;
                }
                com.salesforce.marketingcloud.storage.i iVarN = a.this.d.n();
                Crypto cryptoB = a.this.d.b();
                for (String str : listC) {
                    Message messageA = iVarN.a(str, cryptoB);
                    if (messageA != null) {
                        a.this.f.a(regionA, messageA);
                    } else {
                        g.a(a.j, "Message with id [%s] not found", str);
                    }
                }
            } catch (Exception e) {
                g.b(a.j, e, "Proximity region (%s) was entered, but failed to check for associated message", this.c.n());
            }
        }
    }

    class d implements Runnable {
        final /* synthetic */ com.salesforce.marketingcloud.proximity.c b;

        d(com.salesforce.marketingcloud.proximity.c cVar) {
            this.b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            j jVarO = a.this.d.o();
            Region regionA = jVarO.a(this.b.n(), a.this.d.b());
            if (regionA == null) {
                g.a(a.j, "BeaconRegion [%s] did not have matching Region in storage.", this.b);
            } else {
                if (!l.a(regionA)) {
                    g.a(a.j, "Ignoring exit event.  Was not inside BeaconRegion [%s]", this.b);
                    return;
                }
                l.a(regionA, false);
                a.this.f.a(regionA);
                jVarO.a(regionA.id(), false);
            }
        }
    }

    class e extends i {
        final /* synthetic */ ProximityMessageResponse c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, Object[] objArr, ProximityMessageResponse proximityMessageResponse) {
            super(str, objArr);
            this.c = proximityMessageResponse;
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            Crypto cryptoB = a.this.d.b();
            j jVarO = a.this.d.o();
            List<Region> listA = jVarO.a(3, a.this.d.b());
            if (!listA.isEmpty()) {
                Collections.sort(listA);
            }
            jVarO.f(3);
            com.salesforce.marketingcloud.storage.i iVarN = a.this.d.n();
            if (!this.c.beacons().isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (Region region : this.c.beacons()) {
                    try {
                        boolean z = false;
                        for (Message message : region.messages()) {
                            com.salesforce.marketingcloud.messages.b.a(message, iVarN, cryptoB);
                            iVarN.a(message, cryptoB);
                            z = true;
                        }
                        if (z) {
                            int iBinarySearch = Collections.binarySearch(listA, region);
                            if (iBinarySearch >= 0) {
                                l.a(region, l.a(listA.remove(iBinarySearch)));
                            }
                            jVarO.a(region, cryptoB);
                            arrayList.add(new com.salesforce.marketingcloud.proximity.c(region));
                        }
                    } catch (Exception e) {
                        g.b(a.j, e, "Unable to start monitoring proximity region: %s", region.id());
                    }
                }
                g.a(a.j, "Monitoring beacons from request [%s]", arrayList);
                a.this.e.a(arrayList);
            }
            if (listA.isEmpty()) {
                return;
            }
            ArrayList arrayList2 = new ArrayList(listA.size());
            Iterator<Region> it2 = listA.iterator();
            while (it2.hasNext()) {
                arrayList2.add(new com.salesforce.marketingcloud.proximity.c(it2.next()));
            }
            g.a(a.j, "Unmonitoring beacons [%s]", arrayList2);
            a.this.e.b(arrayList2);
        }
    }

    public a(@NonNull h hVar, @NonNull com.salesforce.marketingcloud.proximity.e eVar, @NonNull com.salesforce.marketingcloud.http.e eVar2, @NonNull n nVar, @NonNull com.salesforce.marketingcloud.messages.c.a aVar) {
        this.d = hVar;
        this.e = eVar;
        this.g = eVar2;
        this.h = nVar;
        this.f = aVar;
        eVar2.a(com.salesforce.marketingcloud.http.b.f54o, this);
    }

    public static void a(h hVar, com.salesforce.marketingcloud.proximity.e eVar, com.salesforce.marketingcloud.http.e eVar2, boolean z) {
        eVar.c();
        if (z) {
            hVar.o().f(3);
            hVar.n().e(5);
        }
        eVar2.a(com.salesforce.marketingcloud.http.b.f54o);
    }

    @Override // com.salesforce.marketingcloud.messages.c
    public void b() {
        this.e.c();
        this.e.b(this);
        this.g.a(com.salesforce.marketingcloud.http.b.f54o);
        this.h.b().execute(new b("disable_beacon_tracking", new Object[0]));
    }

    @Override // com.salesforce.marketingcloud.messages.c
    public void c() {
        g.c(j, "monitorStoredRegions", new Object[0]);
        try {
            List<Region> listA = this.d.o().a(3, this.d.b());
            if (listA.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList(listA.size());
            Iterator<Region> it2 = listA.iterator();
            while (it2.hasNext()) {
                arrayList.add(new com.salesforce.marketingcloud.proximity.c(it2.next()));
            }
            g.a(j, "Monitoring beacons [%s]", arrayList);
            this.e.a(arrayList);
        } catch (Exception unused) {
            g.b(j, "Unable to monitor stored proximity regions.", new Object[0]);
        }
    }

    public boolean d() {
        return this.e.b();
    }

    @Override // com.salesforce.marketingcloud.proximity.e.a
    public void b(@NonNull com.salesforce.marketingcloud.proximity.c cVar) {
        g.d(j, "Proximity region (%s) entered.", cVar.n());
        this.h.b().execute(new c("", new Object[0], cVar));
    }

    @Override // com.salesforce.marketingcloud.messages.c
    public void a(LatLon latLon, String str, MarketingCloudConfig marketingCloudConfig, com.salesforce.marketingcloud.messages.c.b bVar) {
        this.i = bVar;
        try {
            MarketingCloudSdk.requestSdk(new C0089a(marketingCloudConfig, str, latLon));
        } catch (Exception e2) {
            g.b(j, e2, "Failed to update proximity messages", new Object[0]);
        }
    }

    @Override // com.salesforce.marketingcloud.messages.c
    public void a() {
        this.e.a(this);
        this.g.a(com.salesforce.marketingcloud.http.b.f54o, this);
    }

    @Override // com.salesforce.marketingcloud.proximity.e.a
    public void a(@NonNull com.salesforce.marketingcloud.proximity.c cVar) {
        g.d(j, "Proximity region (%s) exited.", cVar.n());
        this.h.b().execute(new d(cVar));
    }

    @Override // com.salesforce.marketingcloud.http.e.c
    public void a(com.salesforce.marketingcloud.http.c cVar, f fVar) {
        if (fVar.p()) {
            try {
                a(new ProximityMessageResponse(new JSONObject(fVar.j())));
                return;
            } catch (Exception e2) {
                g.b(j, e2, "Error parsing response.", new Object[0]);
                return;
            }
        }
        String str = j;
        int iK = fVar.k();
        g.c(str, "Request failed: %d - %s", Integer.valueOf(iK), fVar.n());
    }

    void a(ProximityMessageResponse proximityMessageResponse) {
        g.c(j, "Proximity message request contained %d regions", Integer.valueOf(proximityMessageResponse.beacons().size()));
        com.salesforce.marketingcloud.messages.c.b bVar = this.i;
        if (bVar != null) {
            bVar.a(proximityMessageResponse);
        }
        this.h.b().execute(new e("beacon_response", new Object[0], proximityMessageResponse));
    }
}
