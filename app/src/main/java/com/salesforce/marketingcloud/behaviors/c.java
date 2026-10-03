package com.salesforce.marketingcloud.behaviors;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.f;
import com.salesforce.marketingcloud.g;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c extends f {
    public static final String i = "timestamp";
    static final int j = 1;
    static final String k = g.a("BehaviorManager");
    private final ExecutorService d;
    private final ArrayMap<com.salesforce.marketingcloud.behaviors.a, Set<com.salesforce.marketingcloud.behaviors.b>> e = new ArrayMap<>();
    private final Map<com.salesforce.marketingcloud.behaviors.a, Bundle> f = new ArrayMap(1);
    private final Context g;
    private BroadcastReceiver h;

    /* JADX INFO: loaded from: classes3.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                g.d(c.k, "Received null intent", new Object[0]);
                return;
            }
            String action = intent.getAction();
            if (action == null) {
                g.d(c.k, "Received null action", new Object[0]);
                return;
            }
            com.salesforce.marketingcloud.behaviors.a aVarA = com.salesforce.marketingcloud.behaviors.a.a(action);
            if (aVarA != null) {
                c.this.onBehavior(aVarA, intent.getExtras());
            }
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    static class b implements Runnable {
        final Set<com.salesforce.marketingcloud.behaviors.b> b;
        final com.salesforce.marketingcloud.behaviors.a c;
        final Bundle d;

        b(Set<com.salesforce.marketingcloud.behaviors.b> set, com.salesforce.marketingcloud.behaviors.a aVar, Bundle bundle) {
            this.b = set;
            this.c = aVar;
            this.d = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (com.salesforce.marketingcloud.behaviors.b bVar : this.b) {
                if (bVar != null) {
                    try {
                        bVar.onBehavior(this.c, this.d);
                    } catch (Exception e) {
                        g.b(c.k, e, "Failure delivering behavior %s to %s", this.c.b, bVar.getClass().getName());
                    }
                }
            }
        }
    }

    public c(@NonNull Context context, @NonNull ExecutorService executorService) {
        this.g = context;
        this.d = executorService;
    }

    public static void a(@NonNull Context context, @NonNull com.salesforce.marketingcloud.behaviors.a aVar, @Nullable Bundle bundle) {
        com.salesforce.marketingcloud.util.g.a(context, "Context is null");
        com.salesforce.marketingcloud.util.g.a(aVar, "Behavior is null");
        Intent intent = new Intent(aVar.b);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context.sendBroadcast(intent.setPackage(context.getPackageName()));
    }

    @Override // com.salesforce.marketingcloud.d
    public final String componentName() {
        return "BehaviorManager";
    }

    @Override // com.salesforce.marketingcloud.d
    public final JSONObject componentState() {
        return null;
    }

    public void onBehavior(@NonNull com.salesforce.marketingcloud.behaviors.a aVar, @Nullable Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putLong("timestamp", System.currentTimeMillis());
        g.a(k, "Behavior found: %s", aVar.name());
        synchronized (this.e) {
            Set<com.salesforce.marketingcloud.behaviors.b> set = this.e.get(aVar);
            if (set != null && !set.isEmpty()) {
                try {
                    this.d.submit(new b(Collections.unmodifiableSet(set), aVar, bundle));
                } catch (RejectedExecutionException e) {
                    g.b(k, e, "Unable to deliver behavior %s.", aVar.b);
                }
            }
        }
        synchronized (this.f) {
            if (aVar.c) {
                this.f.put(aVar, bundle);
            }
            com.salesforce.marketingcloud.behaviors.a aVar2 = aVar.d;
            if (aVar2 != null) {
                this.f.put(aVar2, null);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.f, com.salesforce.marketingcloud.d
    public final void tearDown(boolean z) {
        Context context = this.g;
        if (context != null) {
            context.unregisterReceiver(this.h);
        }
    }

    @Override // com.salesforce.marketingcloud.f
    public void a(@NonNull InitializationStatus.a aVar) {
        this.h = new a();
        IntentFilter intentFilter = new IntentFilter();
        for (com.salesforce.marketingcloud.behaviors.a aVar2 : com.salesforce.marketingcloud.behaviors.a.values()) {
            intentFilter.addAction(aVar2.b);
        }
        ContextCompat.registerReceiver(this.g, this.h, intentFilter, 4);
    }

    public void a(@NonNull com.salesforce.marketingcloud.behaviors.b bVar, @NonNull EnumSet<com.salesforce.marketingcloud.behaviors.a> enumSet) {
        com.salesforce.marketingcloud.util.g.a(bVar, "BehaviorListener is null");
        com.salesforce.marketingcloud.util.g.a(enumSet, "Behavior set is null");
        synchronized (this.e) {
            g.a(k, "Registering %s for behaviors: %s", bVar.getClass().getName(), enumSet.toString());
            for (com.salesforce.marketingcloud.behaviors.a aVar : enumSet) {
                Set<com.salesforce.marketingcloud.behaviors.b> hashSet = this.e.get(aVar);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    this.e.put(aVar, hashSet);
                }
                hashSet.add(bVar);
            }
        }
        synchronized (this.f) {
            for (com.salesforce.marketingcloud.behaviors.a aVar2 : enumSet) {
                if (aVar2.c && this.f.containsKey(aVar2)) {
                    this.d.submit(new b(Collections.singleton(bVar), aVar2, this.f.get(aVar2)));
                }
            }
        }
    }

    public void a(@NonNull com.salesforce.marketingcloud.behaviors.b bVar) {
        synchronized (this.e) {
            Iterator<Map.Entry<com.salesforce.marketingcloud.behaviors.a, Set<com.salesforce.marketingcloud.behaviors.b>>> it2 = this.e.entrySet().iterator();
            while (it2.hasNext()) {
                it2.next().getValue().remove(bVar);
            }
        }
    }
}
