package com.salesforce.marketingcloud.location;

import androidx.annotation.NonNull;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
final class a extends f {
    private final JSONObject q;
    private final Boolean r;
    private final Exception s;
    private final boolean t;
    private final boolean u;

    a(MarketingCloudConfig marketingCloudConfig, Boolean bool, boolean z, Exception exc) {
        this.t = marketingCloudConfig.geofencingEnabled();
        this.u = marketingCloudConfig.proximityEnabled();
        this.r = bool;
        this.s = exc;
        this.q = f.a(marketingCloudConfig, bool, z, exc);
    }

    @Override // com.salesforce.marketingcloud.f
    public void a(@NonNull InitializationStatus.a aVar) {
        if (!this.t && !this.u) {
            aVar.b(false);
            return;
        }
        aVar.b(true);
        Exception exc = this.s;
        if (exc == null) {
            Boolean bool = this.r;
            if (bool == null || bool.booleanValue()) {
                return;
            }
            aVar.a(f.e);
            return;
        }
        String message = exc.getMessage();
        if (message != null) {
            aVar.a(message);
        }
        Exception exc2 = this.s;
        if (exc2 instanceof g) {
            aVar.a(((g) exc2).a());
        }
    }

    @Override // com.salesforce.marketingcloud.location.f
    public void b(e eVar) {
        com.salesforce.marketingcloud.g.e(f.p, "LocationManager unavailable. unregisterForLocationUpdate ignored", new Object[0]);
    }

    @Override // com.salesforce.marketingcloud.d
    public JSONObject componentState() {
        return this.q;
    }

    @Override // com.salesforce.marketingcloud.location.f
    public void b() {
        com.salesforce.marketingcloud.g.e(f.p, "LocationManager unavailable. unmonitorAllGeofences ignored", new Object[0]);
    }

    @Override // com.salesforce.marketingcloud.location.f
    public void b(c cVar) {
        com.salesforce.marketingcloud.g.e(f.p, "LocationManager unavailable. unregisterForGeofenceRegionEvents ignored", new Object[0]);
    }

    @Override // com.salesforce.marketingcloud.location.f
    public void a(e eVar) {
        com.salesforce.marketingcloud.g.e(f.p, "LocationManager unavailable. registerForLocationUpdate ignored", new Object[0]);
    }

    @Override // com.salesforce.marketingcloud.location.f
    public void a(b... bVarArr) {
        com.salesforce.marketingcloud.g.e(f.p, "LocationManager unavailable. monitorGeofences ignored", new Object[0]);
    }

    @Override // com.salesforce.marketingcloud.location.f
    public void a(List<String> list) {
        com.salesforce.marketingcloud.g.e(f.p, "LocationManager unavailable. unmonitorGeofences ignored", new Object[0]);
    }

    @Override // com.salesforce.marketingcloud.location.f
    public void a(c cVar) {
        com.salesforce.marketingcloud.g.e(f.p, "LocationManager unavailable. registerForGeofenceRegionEvents ignored", new Object[0]);
    }
}
