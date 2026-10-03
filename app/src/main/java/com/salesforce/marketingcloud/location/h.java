package com.salesforce.marketingcloud.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import androidx.core.content.ContextCompat;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class h extends f {
    final d q;
    final Set<e> r = new ArraySet();
    private final Set<c> s = new ArraySet();
    private MarketingCloudConfig t;
    private int u;
    private int v;
    private String w;
    private int x;
    private Context y;
    private BroadcastReceiver z;

    class a extends BroadcastReceiver {
        a() {
        }

        /* JADX WARN: Code duplicated, block: B:27:0x0052  */
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            byte b;
            if (intent == null) {
                com.salesforce.marketingcloud.g.d(f.p, "Received null intent", new Object[0]);
                return;
            }
            String action = intent.getAction();
            if (action == null) {
                com.salesforce.marketingcloud.g.d(f.p, "Received null action", new Object[0]);
                return;
            }
            int iHashCode = action.hashCode();
            if (iHashCode != -284548713) {
                if (iHashCode != 557677285) {
                    if (iHashCode == 557783927 && action.equals("com.salesforce.marketingcloud.location.GEOFENCE_EVENT")) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                } else if (action.equals("com.salesforce.marketingcloud.location.GEOFENCE_ERROR")) {
                    b = 1;
                } else {
                    b = -1;
                }
            } else if (action.equals("com.salesforce.marketingcloud.location.LOCATION_UPDATE")) {
                b = 0;
            } else {
                b = -1;
            }
            if (b == 0) {
                com.salesforce.marketingcloud.g.a(f.p, "Received location update.", new Object[0]);
                h.this.b((Location) intent.getParcelableExtra("extra_location"));
                return;
            }
            if (b == 1) {
                int intExtra = intent.getIntExtra("extra_error_code", -1);
                String stringExtra = intent.getStringExtra("extra_error_message");
                if (intExtra == -1 || stringExtra == null) {
                    return;
                }
                h.this.b(intExtra, stringExtra);
                return;
            }
            if (b != 2) {
                com.salesforce.marketingcloud.g.a(f.p, "Received unknown action: %s", action);
                return;
            }
            int intExtra2 = intent.getIntExtra("extra_transition", -1);
            if (intExtra2 == -1) {
                return;
            }
            com.salesforce.marketingcloud.g.a(f.p, "Received geofence transition %d", Integer.valueOf(intExtra2));
            h.this.b(intExtra2, intent.getStringArrayListExtra("extra_fence_ids"), (Location) intent.getParcelableExtra("extra_location"));
        }
    }

    h(@NonNull Context context, MarketingCloudConfig marketingCloudConfig) throws IllegalStateException {
        this.y = context;
        this.q = new d(context);
        this.t = marketingCloudConfig;
    }

    @Override // com.salesforce.marketingcloud.f
    public void a(@NonNull InitializationStatus.a aVar) {
        this.z = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.salesforce.marketingcloud.location.LOCATION_UPDATE");
        intentFilter.addAction("com.salesforce.marketingcloud.location.GEOFENCE_EVENT");
        intentFilter.addAction("com.salesforce.marketingcloud.location.GEOFENCE_ERROR");
        ContextCompat.registerReceiver(this.y, this.z, intentFilter, 4);
        aVar.a(this.q.c());
        aVar.a(this.q.b());
        aVar.b(!this.q.d());
    }

    @Override // com.salesforce.marketingcloud.location.f
    public void b(@NonNull e eVar) {
        synchronized (this.r) {
            this.r.remove(eVar);
        }
    }

    @Override // com.salesforce.marketingcloud.d
    public JSONObject componentState() {
        JSONObject jSONObjectA = f.a(this.t, this.q.c(), this.q.b());
        try {
            jSONObjectA.put("locationRequests", this.u);
            jSONObjectA.put("locationsReceived", this.v);
            jSONObjectA.put("lastLocationRequester", this.w);
            jSONObjectA.put("geofenceEvents", this.x);
        } catch (JSONException e) {
            com.salesforce.marketingcloud.g.b(f.p, e, "Error creating state for RealLocationManager.", new Object[0]);
        }
        return jSONObjectA;
    }

    @Override // com.salesforce.marketingcloud.f, com.salesforce.marketingcloud.d
    public void tearDown(boolean z) {
        BroadcastReceiver broadcastReceiver;
        d dVar = this.q;
        if (dVar != null && z) {
            dVar.a();
        }
        Context context = this.y;
        if (context == null || (broadcastReceiver = this.z) == null) {
            return;
        }
        context.unregisterReceiver(broadcastReceiver);
    }

    @Override // com.salesforce.marketingcloud.location.f
    public void b() {
        this.q.a();
    }

    @Override // com.salesforce.marketingcloud.location.f
    public void b(@NonNull c cVar) {
        if (cVar != null) {
            synchronized (this.s) {
                this.s.remove(cVar);
            }
        }
    }

    void b(Location location) {
        if (location == null) {
            return;
        }
        this.v++;
        synchronized (this.r) {
            if (!this.r.isEmpty()) {
                for (e eVar : this.r) {
                    if (eVar != null) {
                        eVar.a(location);
                    }
                }
                this.r.clear();
            }
        }
    }

    @Override // com.salesforce.marketingcloud.location.f
    public boolean a() {
        return this.q.d();
    }

    @Override // com.salesforce.marketingcloud.location.f
    public void a(@NonNull e eVar) {
        boolean z;
        if (eVar == null) {
            return;
        }
        synchronized (this.r) {
            z = this.r.add(eVar) && this.r.size() == 1;
        }
        if (z) {
            this.u++;
            this.w = eVar.getClass().getName();
            this.q.e();
        }
    }

    h(Context context, d dVar) {
        this.y = context;
        this.q = dVar;
    }

    @Override // com.salesforce.marketingcloud.location.f
    public void a(b... bVarArr) {
        if (bVarArr != null && bVarArr.length != 0) {
            com.salesforce.marketingcloud.g.d(f.p, "Monitoring %s fence(s).", Integer.valueOf(bVarArr.length));
            this.q.a(bVarArr);
        } else {
            com.salesforce.marketingcloud.g.a(f.p, "monitorGeofences - No geofenceRegions provided.", new Object[0]);
        }
    }

    void b(int i, @NonNull List<String> list, @Nullable Location location) {
        String str = f.p;
        com.salesforce.marketingcloud.g.d(str, "onGeofenceRegionEvent", new Object[0]);
        if (list != null && !list.isEmpty()) {
            this.x++;
            synchronized (this.s) {
                if (!this.s.isEmpty()) {
                    for (c cVar : this.s) {
                        if (cVar != null) {
                            for (String str2 : list) {
                                com.salesforce.marketingcloud.g.a(f.p, "Notifiying %s of geofence [%s] region event [d]", cVar.getClass().getName(), str2, Integer.valueOf(i));
                                cVar.a(str2, i, location);
                            }
                        }
                    }
                } else {
                    com.salesforce.marketingcloud.g.c(str, "Geofence region event occured with no one listening.", new Object[0]);
                }
            }
            return;
        }
        com.salesforce.marketingcloud.g.c(str, "No fenceIds were provided.", new Object[0]);
    }

    @Override // com.salesforce.marketingcloud.location.f
    public void a(List<String> list) {
        if (list != null && list.size() != 0) {
            this.q.a(list);
        } else {
            com.salesforce.marketingcloud.g.c(f.p, "unmonitorGeofences - No geofenceRegionIds provided.", new Object[0]);
        }
    }

    @Override // com.salesforce.marketingcloud.location.f
    public void a(@NonNull c cVar) {
        com.salesforce.marketingcloud.g.d(f.p, "registerForGeofenceRegionEvents(%s)", cVar.getClass().getName());
        synchronized (this.s) {
            this.s.add(cVar);
        }
    }

    void b(int i, String str) {
        synchronized (this.s) {
            if (!this.s.isEmpty()) {
                for (c cVar : this.s) {
                    if (cVar != null) {
                        cVar.a(i, str);
                    }
                }
            }
        }
    }
}
