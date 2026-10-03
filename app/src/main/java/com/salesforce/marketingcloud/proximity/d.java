package com.salesforce.marketingcloud.proximity;

import androidx.annotation.NonNull;
import com.google.maps.android.BuildConfig;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.g;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class d extends e {
    private final boolean i;
    private final JSONObject j;

    public d(boolean z, JSONObject jSONObject) {
        this.i = z;
        this.j = jSONObject;
    }

    @Override // com.salesforce.marketingcloud.f
    public void a(@NonNull InitializationStatus.a aVar) {
        aVar.d(this.i);
    }

    @Override // com.salesforce.marketingcloud.proximity.e
    public void b(List<c> list) {
        g.d(e.h, "unmonitorBeaconRegions call ignored because of unsupported device.", new Object[0]);
    }

    @Override // com.salesforce.marketingcloud.proximity.e
    public void c() {
        g.d(e.h, "stopMonitoringBeaconRegions() call ignored because of unsupported device.", new Object[0]);
    }

    @Override // com.salesforce.marketingcloud.d
    public JSONObject componentState() {
        return this.j;
    }

    @Override // com.salesforce.marketingcloud.proximity.e
    public void a(List<c> list) {
        g.d(e.h, "monitorBeaconRegions call ignored because of unsupported device.", new Object[0]);
    }

    @Override // com.salesforce.marketingcloud.proximity.e
    public void b(@NonNull e.a aVar) {
        g.d(e.h, "unregisterProximityEventListener(%s) call ignored because of unsupported device.", aVar != null ? aVar.getClass().getSimpleName() : BuildConfig.TRAVIS);
    }

    @Override // com.salesforce.marketingcloud.proximity.e
    public void a(@NonNull e.a aVar) {
        g.d(e.h, "registerProximityEventListener(%s) call ignored because of unsupported device.", aVar != null ? aVar.getClass().getSimpleName() : BuildConfig.TRAVIS);
    }
}
