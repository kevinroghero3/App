package com.salesforce.marketingcloud.messages;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.internal.i;
import com.salesforce.marketingcloud.internal.l;
import com.salesforce.marketingcloud.internal.n;
import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.messages.geofence.GeofenceMessageResponse;
import com.salesforce.marketingcloud.messages.proximity.ProximityMessageResponse;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.storage.h;
import com.salesforce.marketingcloud.storage.j;
import com.salesforce.marketingcloud.util.Crypto;
import com.transistorsoft.locationmanager.activity.TSLocationManagerActivity;
import com.transistorsoft.rnbackgroundgeolocation.RNBackgroundGeolocationModule;
import java.util.EnumSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d implements com.salesforce.marketingcloud.e, RegionMessageManager, com.salesforce.marketingcloud.alarms.b.InterfaceC0064b, com.salesforce.marketingcloud.location.e, com.salesforce.marketingcloud.behaviors.b, com.salesforce.marketingcloud.messages.c.b, com.salesforce.marketingcloud.messages.c.a, com.salesforce.marketingcloud.location.c {
    private static final String A = "RegionMessageManager";
    static final String B = com.salesforce.marketingcloud.g.a(A);
    private static final float C = 0.8f;
    static final String w = "et_geo_enabled_key";
    static final String x = "et_region_message_toggled_key";
    static final String y = "et_proximity_enabled_key";
    static final int z = 5000;
    final h d;
    private final com.salesforce.marketingcloud.alarms.b e;
    private final com.salesforce.marketingcloud.location.f f;
    private final com.salesforce.marketingcloud.proximity.e g;
    private final MarketingCloudConfig h;
    private final String i;
    private final Context j;
    private final com.salesforce.marketingcloud.notifications.a k;
    private final com.salesforce.marketingcloud.behaviors.c l;
    private final com.salesforce.marketingcloud.http.e m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Set<RegionMessageManager.GeofenceMessageResponseListener> f65n = new ArraySet();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Set<RegionMessageManager.ProximityMessageResponseListener> f66o = new ArraySet();
    private final Set<RegionMessageManager.RegionTransitionEventListener> p;
    private final AtomicBoolean q;
    private final n r;
    private com.salesforce.marketingcloud.messages.geofence.a s;
    private com.salesforce.marketingcloud.messages.proximity.a t;
    private com.salesforce.marketingcloud.toggles.a u;
    private com.salesforce.marketingcloud.toggles.a v;

    class a extends i {
        a(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            LatLon latLonE;
            h hVar = d.this.d;
            if (hVar == null || (latLonE = hVar.m().e(d.this.d.b())) == null) {
                return;
            }
            d.this.a(latLonE);
        }
    }

    class b extends i {
        b(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            LatLon latLonE;
            h hVar = d.this.d;
            if (hVar == null || (latLonE = hVar.m().e(d.this.d.b())) == null) {
                return;
            }
            d.this.b(latLonE);
        }
    }

    class c extends i {
        c(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            d.this.d.o().l();
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.d$d, reason: collision with other inner class name */
    class C0084d extends i {
        final /* synthetic */ LatLon c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0084d(String str, Object[] objArr, LatLon latLon) {
            super(str, objArr);
            this.c = latLon;
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            try {
                d dVar = d.this;
                boolean zA = dVar.a(this.c, dVar.d.o().l(d.this.d.b()));
                d.this.d.m().a(this.c, d.this.d.b());
                if (zA) {
                    d.this.a(this.c, 5000);
                    d.this.a(this.c);
                    d.this.b(this.c);
                }
            } catch (Exception e) {
                com.salesforce.marketingcloud.g.b(d.B, e, "Unable to store last location", new Object[0]);
            }
        }
    }

    class e extends i {
        final /* synthetic */ Region c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, Object[] objArr, Region region) {
            super(str, objArr);
            this.c = region;
        }

        @Override // com.salesforce.marketingcloud.internal.i
        public void a() {
            try {
                d.this.d.o().a(this.c, d.this.d.b());
            } catch (Exception e) {
                com.salesforce.marketingcloud.g.b(d.B, e, "Unable to set magic region", new Object[0]);
            }
        }
    }

    class f implements com.salesforce.marketingcloud.notifications.a.b {
        final /* synthetic */ Message a;

        f(Message message) {
            this.a = message;
        }

        @Override // com.salesforce.marketingcloud.notifications.a.b
        public void a(int i) {
            if (i != -1) {
                try {
                    com.salesforce.marketingcloud.internal.h.a(this.a, i);
                    d.this.d.n().a(this.a, d.this.d.b());
                } catch (Exception e) {
                    com.salesforce.marketingcloud.g.b(d.B, e, "Unable to update message id with notification id.", new Object[0]);
                }
            }
        }
    }

    static /* synthetic */ class g {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[com.salesforce.marketingcloud.behaviors.a.values().length];
            b = iArr;
            try {
                iArr[com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_DEVICE_BOOT_COMPLETE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_APP_PACKAGE_REPLACED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_DEVICE_SHUTDOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_APP_FOREGROUNDED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[com.salesforce.marketingcloud.alarms.a.EnumC0062a.values().length];
            a = iArr2;
            try {
                iArr2[com.salesforce.marketingcloud.alarms.a.EnumC0062a.e.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public d(@NonNull Context context, @NonNull MarketingCloudConfig marketingCloudConfig, @NonNull h hVar, @NonNull String str, @NonNull com.salesforce.marketingcloud.location.f fVar, @NonNull com.salesforce.marketingcloud.proximity.e eVar, @NonNull com.salesforce.marketingcloud.behaviors.c cVar, @NonNull com.salesforce.marketingcloud.alarms.b bVar, @NonNull com.salesforce.marketingcloud.http.e eVar2, @NonNull com.salesforce.marketingcloud.notifications.a aVar, n nVar, RegionMessageManager.RegionTransitionEventListener regionTransitionEventListener) {
        ArraySet arraySet = new ArraySet();
        this.p = arraySet;
        this.q = new AtomicBoolean(false);
        this.j = context;
        this.d = hVar;
        this.f = fVar;
        this.g = eVar;
        this.k = aVar;
        this.e = bVar;
        this.l = cVar;
        this.m = eVar2;
        this.i = str;
        this.h = marketingCloudConfig;
        arraySet.add(regionTransitionEventListener);
        this.r = nVar;
    }

    private void a(@Nullable InitializationStatus.a aVar, int i) {
        if (com.salesforce.marketingcloud.b.a(i, 32)) {
            return;
        }
        this.s = new com.salesforce.marketingcloud.messages.geofence.a(this.d, this.f, this.m, this.r, this);
        this.e.a(this, com.salesforce.marketingcloud.alarms.a.EnumC0062a.e);
        if (isGeofenceMessagingEnabled()) {
            if (!c(true)) {
                disableGeofenceMessaging();
            }
            if (aVar != null) {
                aVar.c(!com.salesforce.marketingcloud.util.f.b(this.j));
            }
        }
    }

    private void b(@Nullable InitializationStatus.a aVar, int i) {
        if (com.salesforce.marketingcloud.b.a(i, 64)) {
            return;
        }
        this.t = new com.salesforce.marketingcloud.messages.proximity.a(this.d, this.g, this.m, this.r, this);
        this.e.a(this, com.salesforce.marketingcloud.alarms.a.EnumC0062a.e);
        if (isProximityMessagingEnabled()) {
            if (!d(true)) {
                disableProximityMessaging();
            }
            if (aVar != null) {
                aVar.c(!com.salesforce.marketingcloud.util.f.b(this.j));
            }
        }
    }

    private boolean d(boolean z2) {
        if (!com.salesforce.marketingcloud.util.b.a()) {
            com.salesforce.marketingcloud.g.e(B, "If you wish to use proximity messenger then you need to add the AltBeacon dependency.", new Object[0]);
            return false;
        }
        if (!b(z2)) {
            return false;
        }
        com.salesforce.marketingcloud.g.d(B, "Enabling proximity messaging.", new Object[0]);
        if (z2) {
            this.t.c();
        } else {
            h hVar = this.d;
            if (hVar != null) {
                hVar.e().edit().putBoolean(y, true).apply();
                this.d.e().edit().putBoolean(x, true).apply();
            }
            this.v = com.salesforce.marketingcloud.toggles.a.ENABLED;
            Bundle bundle = new Bundle();
            bundle.putBoolean(RegionMessageManager.BUNDLE_KEY_MESSAGING_ENABLED, true);
            com.salesforce.marketingcloud.behaviors.c.a(this.j, com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_CUSTOMER_PROXIMITY_MESSAGING_TOGGLED, bundle);
        }
        this.t.a();
        return c();
    }

    private void e() {
        if (Build.VERSION.SDK_INT >= 31) {
            com.salesforce.marketingcloud.g.a(B, "Missing %s or %s", "android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT");
        }
    }

    private void f() {
        if (Build.VERSION.SDK_INT < 29) {
            com.salesforce.marketingcloud.g.a(B, "Missing %s", RNBackgroundGeolocationModule.ACCESS_FINE_LOCATION);
        } else {
            com.salesforce.marketingcloud.g.a(B, "Missing %s or %s", RNBackgroundGeolocationModule.ACCESS_FINE_LOCATION, TSLocationManagerActivity.ACCESS_BACKGROUND_LOCATION);
        }
    }

    private void g() {
        if (isGeofenceMessagingEnabled() && a(true)) {
            this.s.c();
        }
        if (isProximityMessagingEnabled() && b(true)) {
            this.t.c();
        }
    }

    private void h() {
        this.r.b().execute(new c("reset_flags", new Object[0]));
    }

    private void i() {
        if (isGeofenceMessagingEnabled()) {
            this.r.b().execute(new a("update_geofence", new Object[0]));
        }
    }

    private void j() {
        if (isProximityMessagingEnabled()) {
            this.r.b().execute(new b("update_proximity", new Object[0]));
        }
    }

    @Override // com.salesforce.marketingcloud.d
    public final String componentName() {
        return A;
    }

    @Override // com.salesforce.marketingcloud.d
    public final JSONObject componentState() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("geofenceMessagingEnabled", isGeofenceMessagingEnabled());
            jSONObject.put("proximityMessagingEnabled", isProximityMessagingEnabled());
            j jVarO = this.d.o();
            Crypto cryptoB = this.d.b();
            if (jVarO != null) {
                Region regionL = jVarO.l(cryptoB);
                if (regionL != null) {
                    jSONObject.put("magic_fence", regionL);
                }
                jSONObject.put("geofence_regions", jVarO.a(1, cryptoB));
                jSONObject.put("geofence_region_messages", this.d.n().a(cryptoB));
                jSONObject.put("proximity_regions", jVarO.a(3, cryptoB));
                jSONObject.put("proximity_region_messages", this.d.n().b(cryptoB));
                jSONObject.put("boot_complete_permission", com.salesforce.marketingcloud.util.f.a(this.j, "android.permission.RECEIVE_BOOT_COMPLETED"));
            }
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.a(B, e2, "Error creating RegionMessageManager state.", new Object[0]);
        }
        return jSONObject;
    }

    @Override // com.salesforce.marketingcloud.e
    public final void controlChannelInit(int i) {
        synchronized (this) {
            if (com.salesforce.marketingcloud.b.a(i, 32)) {
                disableGeofenceMessaging();
                this.s = null;
                com.salesforce.marketingcloud.messages.geofence.a.a(this.d, this.f, this.m, com.salesforce.marketingcloud.b.c(i, 32));
            } else if (this.s == null && this.h.geofencingEnabled()) {
                a((InitializationStatus.a) null, i);
            }
            if (com.salesforce.marketingcloud.b.a(i, 64)) {
                disableProximityMessaging();
                this.t = null;
                com.salesforce.marketingcloud.messages.proximity.a.a(this.d, this.g, this.m, com.salesforce.marketingcloud.b.c(i, 64));
            } else if (this.t == null && this.h.proximityEnabled()) {
                b(null, i);
            }
            if (com.salesforce.marketingcloud.b.a(i, 96)) {
                this.f.b((com.salesforce.marketingcloud.location.c) this);
                this.f.b((com.salesforce.marketingcloud.location.e) this);
                this.l.a(this);
                this.d.m().g();
                com.salesforce.marketingcloud.alarms.b bVar = this.e;
                com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a = com.salesforce.marketingcloud.alarms.a.EnumC0062a.e;
                bVar.e(enumC0062a);
                this.e.d(enumC0062a);
            } else {
                this.l.a(this, EnumSet.of(com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_DEVICE_BOOT_COMPLETE, com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_APP_PACKAGE_REPLACED, com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_DEVICE_SHUTDOWN, com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_APP_FOREGROUNDED));
                this.f.a((com.salesforce.marketingcloud.location.c) this);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.messages.RegionMessageManager
    public final void disableGeofenceMessaging() {
        synchronized (this) {
            com.salesforce.marketingcloud.g.a(B, "Disabling geofence messaging", new Object[0]);
            if (isGeofenceMessagingEnabled()) {
                h hVar = this.d;
                if (hVar != null) {
                    hVar.e().edit().putBoolean(w, false).apply();
                }
                this.u = com.salesforce.marketingcloud.toggles.a.DISABLED;
                Bundle bundle = new Bundle();
                bundle.putBoolean(RegionMessageManager.BUNDLE_KEY_MESSAGING_ENABLED, false);
                com.salesforce.marketingcloud.behaviors.c.a(this.j, com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_CUSTOMER_FENCE_MESSAGING_TOGGLED, bundle);
                com.salesforce.marketingcloud.messages.geofence.a aVar = this.s;
                if (aVar != null) {
                    aVar.b();
                }
            }
            a();
        }
    }

    @Override // com.salesforce.marketingcloud.messages.RegionMessageManager
    public final void disableProximityMessaging() {
        synchronized (this) {
            com.salesforce.marketingcloud.g.a(B, "Disabling proximity messaging", new Object[0]);
            if (isProximityMessagingEnabled()) {
                h hVar = this.d;
                if (hVar != null) {
                    hVar.e().edit().putBoolean(y, false).apply();
                }
                this.v = com.salesforce.marketingcloud.toggles.a.DISABLED;
                Bundle bundle = new Bundle();
                bundle.putBoolean(RegionMessageManager.BUNDLE_KEY_MESSAGING_ENABLED, false);
                com.salesforce.marketingcloud.behaviors.c.a(this.j, com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_CUSTOMER_PROXIMITY_MESSAGING_TOGGLED, bundle);
                com.salesforce.marketingcloud.messages.proximity.a aVar = this.t;
                if (aVar != null) {
                    aVar.b();
                }
            }
            a();
        }
    }

    @Override // com.salesforce.marketingcloud.messages.RegionMessageManager
    public final boolean enableGeofenceMessaging() {
        boolean zC;
        synchronized (this) {
            zC = c(false);
        }
        return zC;
    }

    @Override // com.salesforce.marketingcloud.messages.RegionMessageManager
    public final boolean enableProximityMessaging() {
        boolean zD;
        synchronized (this) {
            zD = d(false);
        }
        return zD;
    }

    @Override // com.salesforce.marketingcloud.e
    public final void init(@NonNull InitializationStatus.a aVar, int i) {
        synchronized (this) {
            a(aVar, i);
            b(aVar, i);
            if (this.s != null || this.t != null) {
                this.l.a(this, EnumSet.of(com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_DEVICE_BOOT_COMPLETE, com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_APP_PACKAGE_REPLACED, com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_DEVICE_SHUTDOWN, com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_APP_FOREGROUNDED));
                this.f.a((com.salesforce.marketingcloud.location.c) this);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.messages.RegionMessageManager
    public final boolean isGeofenceMessagingEnabled() {
        if (com.salesforce.marketingcloud.b.a(com.salesforce.marketingcloud.b.a(this.d.j()), 32)) {
            return false;
        }
        if (this.u == null) {
            this.u = a(w, (com.salesforce.marketingcloud.toggles.a) null);
        }
        com.salesforce.marketingcloud.toggles.a aVar = this.u;
        return aVar == com.salesforce.marketingcloud.toggles.a.ENABLED || (aVar == com.salesforce.marketingcloud.toggles.a.UNKNOWN && this.h.geofencingEnabled());
    }

    @Override // com.salesforce.marketingcloud.messages.RegionMessageManager
    public final boolean isProximityMessagingEnabled() {
        if (com.salesforce.marketingcloud.b.a(com.salesforce.marketingcloud.b.a(this.d.j()), 64)) {
            return false;
        }
        if (this.v == null) {
            this.v = a(y, (com.salesforce.marketingcloud.toggles.a) null);
        }
        com.salesforce.marketingcloud.toggles.a aVar = this.v;
        return aVar == com.salesforce.marketingcloud.toggles.a.ENABLED || (aVar == com.salesforce.marketingcloud.toggles.a.UNKNOWN && this.h.proximityEnabled());
    }

    @Override // com.salesforce.marketingcloud.behaviors.b
    public final void onBehavior(@NonNull com.salesforce.marketingcloud.behaviors.a aVar, @NonNull Bundle bundle) {
        if (aVar == null) {
            return;
        }
        int i = g.b[aVar.ordinal()];
        if (i == 1) {
            h();
        } else if (i != 2) {
            if (i == 3) {
                h();
                return;
            }
            if (i != 4) {
                return;
            }
            i();
            j();
            if (isGeofenceMessagingEnabled() || isProximityMessagingEnabled()) {
                com.salesforce.marketingcloud.alarms.b bVar = this.e;
                com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a = com.salesforce.marketingcloud.alarms.a.EnumC0062a.e;
                bVar.d(enumC0062a);
                this.e.b(enumC0062a);
                return;
            }
            return;
        }
        g();
    }

    @Override // com.salesforce.marketingcloud.messages.RegionMessageManager
    public final void registerGeofenceMessageResponseListener(@NonNull RegionMessageManager.GeofenceMessageResponseListener geofenceMessageResponseListener) {
        if (geofenceMessageResponseListener != null) {
            synchronized (this.f65n) {
                this.f65n.add(geofenceMessageResponseListener);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.messages.RegionMessageManager
    public final void registerProximityMessageResponseListener(@NonNull RegionMessageManager.ProximityMessageResponseListener proximityMessageResponseListener) {
        if (proximityMessageResponseListener != null) {
            synchronized (this.f66o) {
                this.f66o.add(proximityMessageResponseListener);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.messages.RegionMessageManager
    public final void registerRegionTransitionEventListener(@NonNull RegionMessageManager.RegionTransitionEventListener regionTransitionEventListener) {
        if (regionTransitionEventListener != null) {
            synchronized (this.p) {
                this.p.add(regionTransitionEventListener);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.d
    public void tearDown(boolean z2) {
    }

    @Override // com.salesforce.marketingcloud.messages.RegionMessageManager
    public final void unregisterGeofenceMessageResponseListener(@NonNull RegionMessageManager.GeofenceMessageResponseListener geofenceMessageResponseListener) {
        synchronized (this.f65n) {
            this.f65n.remove(geofenceMessageResponseListener);
        }
    }

    @Override // com.salesforce.marketingcloud.messages.RegionMessageManager
    public final void unregisterProximityMessageResponseListener(@NonNull RegionMessageManager.ProximityMessageResponseListener proximityMessageResponseListener) {
        synchronized (this.f66o) {
            this.f66o.remove(proximityMessageResponseListener);
        }
    }

    @Override // com.salesforce.marketingcloud.messages.RegionMessageManager
    public final void unregisterRegionTransitionEventListener(@NonNull RegionMessageManager.RegionTransitionEventListener regionTransitionEventListener) {
        synchronized (this.p) {
            this.p.remove(regionTransitionEventListener);
        }
    }

    private static com.salesforce.marketingcloud.location.b c(Region region) {
        return new com.salesforce.marketingcloud.location.b(region.id(), C * region.radius(), region.center().latitude(), region.center().longitude(), 2);
    }

    private boolean c(boolean z2) {
        synchronized (this) {
            if (!com.salesforce.marketingcloud.util.b.b()) {
                com.salesforce.marketingcloud.g.e(B, "GooglePlayServices Location dependency missing from build.", new Object[0]);
                return false;
            }
            if (!a(z2)) {
                return false;
            }
            com.salesforce.marketingcloud.g.d(B, "Enabling geofence messaging", new Object[0]);
            if (!z2) {
                this.d.e().edit().putBoolean(w, true).apply();
                this.d.e().edit().putBoolean(x, true).apply();
                this.u = com.salesforce.marketingcloud.toggles.a.ENABLED;
                Bundle bundle = new Bundle();
                bundle.putBoolean(RegionMessageManager.BUNDLE_KEY_MESSAGING_ENABLED, true);
                com.salesforce.marketingcloud.behaviors.c.a(this.j, com.salesforce.marketingcloud.behaviors.a.BEHAVIOR_CUSTOMER_FENCE_MESSAGING_TOGGLED, bundle);
            }
            this.s.a();
            return c();
        }
    }

    private boolean a(boolean z2) {
        if (com.salesforce.marketingcloud.b.a(com.salesforce.marketingcloud.b.a(this.d.j()), 32)) {
            return false;
        }
        if (!z2 && isGeofenceMessagingEnabled()) {
            com.salesforce.marketingcloud.g.a(B, "Geofence messaging is already enabled", new Object[0]);
            return false;
        }
        com.salesforce.marketingcloud.messages.geofence.a aVar = this.s;
        if (aVar != null && !aVar.d()) {
            com.salesforce.marketingcloud.g.a(B, "Geofence messaging was not enabled due to device limitation.", new Object[0]);
            return false;
        }
        if (com.salesforce.marketingcloud.util.f.b(this.j)) {
            return true;
        }
        f();
        return false;
    }

    private boolean b(boolean z2) {
        if (com.salesforce.marketingcloud.b.a(com.salesforce.marketingcloud.b.a(this.d.j()), 64)) {
            return false;
        }
        if (!z2 && isProximityMessagingEnabled()) {
            com.salesforce.marketingcloud.g.a(B, "Proximity messaging is already enabled.", new Object[0]);
            return false;
        }
        if (this.t == null) {
            com.salesforce.marketingcloud.g.a(B, "Proximity messaging was not enabled while configuring the SDK.  Messaging will not be enabled.", new Object[0]);
            return false;
        }
        if (Build.VERSION.SDK_INT >= 31 && this.h.proximityNotificationCustomizationOptions() == null) {
            com.salesforce.marketingcloud.g.a(B, "Proximity messaging configuration is not passed while configuring the SDK.  Messaging will not be enabled.", new Object[0]);
            return false;
        }
        if (this.t.d() && this.f.a()) {
            if (!com.salesforce.marketingcloud.util.f.b(this.j)) {
                f();
                return false;
            }
            if (com.salesforce.marketingcloud.util.f.c(this.j)) {
                return true;
            }
            e();
            return false;
        }
        com.salesforce.marketingcloud.g.a(B, "Proximity messaging was not enabled due to device limitation.", new Object[0]);
        return false;
    }

    private boolean c() {
        if (this.s == null && this.t == null) {
            return false;
        }
        if (this.q.compareAndSet(false, true)) {
            try {
                this.f.a((com.salesforce.marketingcloud.location.e) this);
            } catch (Exception e2) {
                com.salesforce.marketingcloud.g.b(B, e2, "Unable to request location update", new Object[0]);
                b();
                return false;
            }
        }
        this.e.b(com.salesforce.marketingcloud.alarms.a.EnumC0062a.e);
        return true;
    }

    boolean d() {
        h hVar;
        return (isProximityMessagingEnabled() || isGeofenceMessagingEnabled()) && (hVar = this.d) != null && hVar.e().getBoolean(x, false);
    }

    private void d(Region region) {
        this.r.b().execute(new e("storing_fence", new Object[0], region));
    }

    private void a() {
        if (isProximityMessagingEnabled() || isGeofenceMessagingEnabled()) {
            return;
        }
        this.e.d(com.salesforce.marketingcloud.alarms.a.EnumC0062a.e);
    }

    private com.salesforce.marketingcloud.toggles.a a(String str, com.salesforce.marketingcloud.toggles.a aVar) {
        if (aVar != null) {
            return aVar;
        }
        if (this.d.e().getBoolean(str, false)) {
            return com.salesforce.marketingcloud.toggles.a.ENABLED;
        }
        return com.salesforce.marketingcloud.toggles.a.DISABLED;
    }

    @Override // com.salesforce.marketingcloud.alarms.b.InterfaceC0064b
    public final void a(@NonNull com.salesforce.marketingcloud.alarms.a.EnumC0062a enumC0062a) {
        if (g.a[enumC0062a.ordinal()] != 1) {
            return;
        }
        i();
        j();
        if (isGeofenceMessagingEnabled() || isProximityMessagingEnabled()) {
            this.e.b(com.salesforce.marketingcloud.alarms.a.EnumC0062a.e);
        }
    }

    void a(LatLon latLon) {
        com.salesforce.marketingcloud.messages.geofence.a aVar;
        if (isGeofenceMessagingEnabled() && (aVar = this.s) != null && latLon != null) {
            aVar.a(latLon, this.i, this.h, this);
        } else {
            com.salesforce.marketingcloud.g.a(B, "Tried to update geofence messages, but was not enabled.", new Object[0]);
        }
    }

    @Override // com.salesforce.marketingcloud.messages.c.b
    public final void a(MessageResponse messageResponse) {
        if (messageResponse == null) {
            return;
        }
        b(messageResponse);
        try {
            Region regionA = l.a(messageResponse.getRefreshCenter(), messageResponse.getRefreshRadius());
            d(regionA);
            this.f.a(c(regionA));
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.b(B, e2, "Failed to updated radius for magic region.", new Object[0]);
        }
    }

    private void b() {
        disableProximityMessaging();
        disableGeofenceMessaging();
    }

    void b(LatLon latLon) {
        com.salesforce.marketingcloud.messages.proximity.a aVar;
        if (isProximityMessagingEnabled() && (aVar = this.t) != null && latLon != null) {
            aVar.a(latLon, this.i, this.h, this);
        } else {
            com.salesforce.marketingcloud.g.a(B, "Tried to update proximity messages, but was not enabled.", new Object[0]);
        }
    }

    private void b(MessageResponse messageResponse) {
        if (messageResponse instanceof GeofenceMessageResponse) {
            synchronized (this.f65n) {
                if (!this.f65n.isEmpty()) {
                    for (RegionMessageManager.GeofenceMessageResponseListener geofenceMessageResponseListener : this.f65n) {
                        if (geofenceMessageResponseListener != null) {
                            try {
                                geofenceMessageResponseListener.onGeofenceMessageResponse((GeofenceMessageResponse) messageResponse);
                            } catch (Exception e2) {
                                com.salesforce.marketingcloud.g.b(B, e2, "%s threw an exception while processing the geofence response", geofenceMessageResponseListener.getClass().getName());
                            }
                        }
                    }
                }
            }
            return;
        }
        if (messageResponse instanceof ProximityMessageResponse) {
            synchronized (this.f66o) {
                if (!this.f66o.isEmpty()) {
                    for (RegionMessageManager.ProximityMessageResponseListener proximityMessageResponseListener : this.f66o) {
                        if (proximityMessageResponseListener != null) {
                            try {
                                proximityMessageResponseListener.onProximityMessageResponse((ProximityMessageResponse) messageResponse);
                            } catch (Exception e3) {
                                com.salesforce.marketingcloud.g.b(B, e3, "%s threw an exception while processing the proximity response", proximityMessageResponseListener.getClass().getName());
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.salesforce.marketingcloud.location.e
    public void a(Location location) {
        this.q.set(false);
        if (location == null) {
            return;
        }
        try {
            this.r.b().execute(new C0084d("store_latlon", new Object[0], new LatLon(location.getLatitude(), location.getLongitude())));
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.b(B, e2, "Unable to make geofence message request after location update", new Object[0]);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0044  */
    boolean a(@NonNull LatLon latLon, @Nullable Region region) {
        boolean z2;
        if (region != null) {
            try {
                float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
                Location.distanceBetween(latLon.latitude(), latLon.longitude(), region.center().latitude(), region.center().longitude(), fArr);
                z2 = d() || fArr[0] > ((float) region.radius()) * C;
            } catch (Exception unused) {
                com.salesforce.marketingcloud.g.b(B, "An error occurred while calculating distance between last known location and the current location.", new Object[0]);
            }
        }
        h hVar = this.d;
        if (hVar != null) {
            hVar.e().edit().remove(x).apply();
        }
        return z2;
    }

    @Override // com.salesforce.marketingcloud.messages.c.a
    public void b(Region region) {
        a(1, region);
    }

    @Override // com.salesforce.marketingcloud.location.c
    public final void a(@NonNull String str, int i, @Nullable Location location) {
        if (i == 2 && Region.MAGIC_REGION_ID.equals(str)) {
            String str2 = B;
            com.salesforce.marketingcloud.g.d(str2, "MagicRegion exited", new Object[0]);
            if (!com.salesforce.marketingcloud.util.f.b(this.j)) {
                com.salesforce.marketingcloud.g.a(str2, "MagicRegion exited, but was missing location permission.", new Object[0]);
                b();
            } else if (location != null) {
                a(location);
            } else {
                this.f.a((com.salesforce.marketingcloud.location.e) this);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.location.c
    public final void a(int i, @Nullable String str) {
        com.salesforce.marketingcloud.g.a(B, "Region error %d - %s", Integer.valueOf(i), str);
    }

    void a(LatLon latLon, int i) {
        if (com.salesforce.marketingcloud.util.f.b(this.j)) {
            Region regionA = l.a(latLon, i);
            d(regionA);
            this.f.a(c(regionA));
        }
    }

    @Override // com.salesforce.marketingcloud.messages.c.a
    public final void a(Region region, Message message) {
        if (region == null || message == null) {
            return;
        }
        com.salesforce.marketingcloud.g.d(B, "showMessage(%s, %s)", region.id(), message.id());
        NotificationMessage notificationMessageA = com.salesforce.marketingcloud.internal.j.a(message, region);
        if (notificationMessageA == null || !com.salesforce.marketingcloud.messages.b.c(message)) {
            return;
        }
        try {
            com.salesforce.marketingcloud.messages.b.a(message, this.d);
            this.k.a(notificationMessageA, new f(message));
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.b(B, e2, "Failed to show message", new Object[0]);
        }
    }

    @Override // com.salesforce.marketingcloud.messages.c.a
    public void a(Region region) {
        a(2, region);
    }

    private void a(int i, Region region) {
        synchronized (this.p) {
            if (!this.p.isEmpty()) {
                for (RegionMessageManager.RegionTransitionEventListener regionTransitionEventListener : this.p) {
                    if (regionTransitionEventListener != null) {
                        try {
                            regionTransitionEventListener.onTransitionEvent(i, region);
                        } catch (Exception e2) {
                            com.salesforce.marketingcloud.g.b(B, e2, "%s threw an exception while processing the region (%s) transition (%d)", regionTransitionEventListener.getClass().getName(), region.id(), Integer.valueOf(i));
                        }
                    }
                }
            }
        }
    }
}
