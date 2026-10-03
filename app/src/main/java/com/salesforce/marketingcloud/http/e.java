package com.salesforce.marketingcloud.http;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import com.google.android.gms.security.ProviderInstaller;
import com.google.maps.android.BuildConfig;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.MCService;
import com.salesforce.marketingcloud.internal.i;
import com.salesforce.marketingcloud.internal.n;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e extends com.salesforce.marketingcloud.f {
    public static final String j = "com.salesforce.marketingcloud.http.RESPONSE";
    public static final String k = "http_response";
    public static final String l = "http_request";
    static final String m = com.salesforce.marketingcloud.g.a("RequestManager");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f57n = 10;
    private final Context f;
    private final SharedPreferences g;
    private n h;
    private BroadcastReceiver i;
    private final Map<String, String> e = new a();
    final Map<com.salesforce.marketingcloud.http.b, c> d = new ArrayMap();

    class a extends LinkedHashMap<String, String> {
        a() {
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<String, String> entry) {
            return size() > 10;
        }
    }

    class b extends i {
        final /* synthetic */ c c;
        final /* synthetic */ com.salesforce.marketingcloud.http.c d;
        final /* synthetic */ f e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, Object[] objArr, c cVar, com.salesforce.marketingcloud.http.c cVar2, f fVar) {
            super(str, objArr);
            this.c = cVar;
            this.d = cVar2;
            this.e = fVar;
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            this.c.a(this.d, this.e);
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public interface c {
        void a(com.salesforce.marketingcloud.http.c cVar, f fVar);
    }

    /* JADX INFO: loaded from: classes3.dex */
    class d extends BroadcastReceiver {
        d() {
        }

        private com.salesforce.marketingcloud.http.c a(Intent intent) {
            try {
                Bundle bundleExtra = intent.getBundleExtra(e.l);
                if (bundleExtra != null) {
                    return com.salesforce.marketingcloud.http.c.a(bundleExtra);
                }
                return null;
            } catch (Exception e) {
                com.salesforce.marketingcloud.g.b(e.m, e, "Failed to extract request from intent extras", new Object[0]);
                return null;
            }
        }

        private f b(Intent intent) {
            try {
                return (f) intent.getParcelableExtra(e.k);
            } catch (Exception e) {
                com.salesforce.marketingcloud.g.b(e.m, e, "Failed to extract response from intent extras", new Object[0]);
                return null;
            }
        }

        private void c(Intent intent) {
            com.salesforce.marketingcloud.http.c cVarA = a(intent);
            f fVarB = b(intent);
            if (cVarA == null || fVarB == null) {
                com.salesforce.marketingcloud.g.a(e.m, "Received null request/response - request: %s, response: %s", cVarA != null ? "non-null" : BuildConfig.TRAVIS, fVarB == null ? BuildConfig.TRAVIS : "non-null");
            } else {
                e.this.a(cVarA, fVarB);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                com.salesforce.marketingcloud.g.d(e.m, "Received null intent", new Object[0]);
                return;
            }
            String action = intent.getAction();
            if (action == null) {
                com.salesforce.marketingcloud.g.d(e.m, "Received null action", new Object[0]);
            } else if (action.equals(e.j)) {
                c(intent);
            } else {
                com.salesforce.marketingcloud.g.a(e.m, "Received unknown action: %s", action);
            }
        }
    }

    public e(Context context, SharedPreferences sharedPreferences, n nVar) {
        this.f = (Context) com.salesforce.marketingcloud.util.g.a(context, "Context is null");
        this.g = (SharedPreferences) com.salesforce.marketingcloud.util.g.a(sharedPreferences, "SharedPreferences is null");
        this.h = nVar;
    }

    @Override // com.salesforce.marketingcloud.f
    public final void a(@NonNull InitializationStatus.a aVar) {
        try {
            a();
        } catch (Exception e) {
            aVar.e(true);
            aVar.a("Failed to install providers: " + e.getMessage());
        }
        this.i = new d();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(j);
        ContextCompat.registerReceiver(this.f, this.i, intentFilter, 4);
    }

    @Override // com.salesforce.marketingcloud.d
    public final String componentName() {
        return "RequestManager";
    }

    @Override // com.salesforce.marketingcloud.d
    public final JSONObject componentState() {
        return new JSONObject(this.e);
    }

    @Override // com.salesforce.marketingcloud.f, com.salesforce.marketingcloud.d
    public final void tearDown(boolean z) {
        BroadcastReceiver broadcastReceiver;
        synchronized (this.d) {
            this.d.clear();
        }
        Context context = this.f;
        if (context == null || (broadcastReceiver = this.i) == null) {
            return;
        }
        context.unregisterReceiver(broadcastReceiver);
    }

    private void a() throws Exception {
        ProviderInstaller.installIfNeeded(this.f);
    }

    public void a(@NonNull com.salesforce.marketingcloud.http.b bVar, @NonNull c cVar) {
        synchronized (this.d) {
            if (this.d.put(bVar, cVar) != null) {
                com.salesforce.marketingcloud.g.a(m, "%s replaces previous listener for $s requests", cVar.getClass().getName(), bVar.name());
            }
        }
    }

    public void a(@NonNull com.salesforce.marketingcloud.http.b bVar) {
        synchronized (this.d) {
            this.d.remove(bVar);
        }
    }

    public void a(@NonNull com.salesforce.marketingcloud.http.c cVar) {
        synchronized (this) {
            com.salesforce.marketingcloud.util.g.a(cVar, "request is null");
            try {
                a();
            } catch (Exception unused) {
                com.salesforce.marketingcloud.g.e(m, "Failed to verify SSL providers via Google Play Services.", new Object[0]);
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jC = cVar.q().c(this.g);
            long jA = cVar.q().a(this.g);
            if (jCurrentTimeMillis > jC && jCurrentTimeMillis > jA) {
                cVar.q().b(this.g);
                MCService.a(this.f, cVar);
            } else {
                a(cVar, f.a("Too Many Requests", 429));
            }
        }
    }

    void a(@NonNull com.salesforce.marketingcloud.http.c cVar, @NonNull f fVar) {
        com.salesforce.marketingcloud.http.b bVarQ = cVar.q();
        com.salesforce.marketingcloud.g.d(m, "%s request took %dms with code: %d", bVarQ.name(), Long.valueOf(fVar.q()), Integer.valueOf(fVar.k()));
        bVarQ.a(this.g, fVar);
        try {
            this.e.put(cVar.s(), String.format(Locale.ENGLISH, "%s - %d", fVar.n(), Integer.valueOf(fVar.k())));
        } catch (Exception e) {
            com.salesforce.marketingcloud.g.b(m, e, "Failed to record response.", new Object[0]);
        }
        synchronized (this.d) {
            c cVar2 = this.d.get(bVarQ);
            if (cVar2 != null) {
                try {
                    this.h.a().execute(new b("onResponse", new Object[0], cVar2, cVar, fVar));
                } catch (Exception e2) {
                    com.salesforce.marketingcloud.g.b(m, e2, "Failed to deliver response.", new Object[0]);
                }
            } else {
                com.salesforce.marketingcloud.g.e(m, "Request %s complete, but no listener was present to handle response %d.", cVar.s(), Integer.valueOf(fVar.k()));
            }
        }
    }
}
