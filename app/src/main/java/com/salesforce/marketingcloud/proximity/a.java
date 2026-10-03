package com.salesforce.marketingcloud.proximity;

import android.app.Application;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.g;
import com.salesforce.marketingcloud.internal.j;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.altbeacon.beacon.BeaconConsumer;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.Identifier;
import org.altbeacon.beacon.MonitorNotifier;
import org.altbeacon.beacon.Region;
import org.altbeacon.beacon.powersave.BackgroundPowerSaver;

/* JADX INFO: loaded from: classes3.dex */
class a implements BeaconConsumer, MonitorNotifier {
    static final String j = "m:0-3=4c000215,i:4-19,i:20-21,i:22-23,p:24-24";
    static final int k = 121;
    static final String l = "0ahUKEwj";
    final Map<String, Region> a;
    private final BeaconManager b;
    private final Context c;
    private final List<c> d;
    private final ProximityNotificationCustomizationOptions e;
    private boolean f;
    private boolean g;
    private BackgroundPowerSaver h;
    private Intent i;

    a(Context context) {
        this(context, null);
    }

    static Region a(c cVar) {
        return new Region(cVar.n(), Identifier.fromUuid(UUID.fromString(cVar.m())), Identifier.fromInt(cVar.o()), Identifier.fromInt(cVar.p()));
    }

    private void b() {
        this.g = true;
        this.b.bind(this);
        g.a(e.h, "Waiting for BeaconService connection", new Object[0]);
    }

    private void c() {
        g.d(e.h, "monitorNewRegions", new Object[0]);
        if (this.d.isEmpty()) {
            return;
        }
        for (c cVar : this.d) {
            if (this.a.containsKey(cVar.n())) {
                g.d(e.h, "Region [%s] already monitored by SDK", cVar);
            } else {
                Region regionA = a(cVar);
                this.a.put(cVar.n(), regionA);
                g.d(e.h, "Now monitoring [%s]", cVar.toString());
                this.b.startMonitoring(regionA);
            }
        }
        this.d.clear();
    }

    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        this.i = intent;
        this.c.startService(intent);
        return this.c.bindService(intent, serviceConnection, i);
    }

    public void d() {
        g.a(e.h, "stopMonitoring()", new Object[0]);
        synchronized (this.d) {
            if (this.f) {
                a();
                this.b.unbind(this);
                this.b.removeMonitorNotifier(this);
                if (this.h != null) {
                    ((Application) this.c.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.h);
                }
                this.f = false;
            } else {
                this.d.clear();
            }
        }
    }

    public void didDetermineStateForRegion(int i, Region region) {
        String str = e.h;
        g.d(str, "didDetermineStateForRegion(%d, %s)", Integer.valueOf(i), region);
        if (!MarketingCloudSdk.isReady() && !MarketingCloudSdk.isInitializing()) {
            g.e(str, "MarketingCloudSdk#init must be called in your application's onCreate", new Object[0]);
            return;
        }
        final Intent intentPutExtra = new Intent(i == 1 ? e.d : e.e).putExtra(e.f, a(region));
        if (!MarketingCloudSdk.isReady()) {
            MarketingCloudSdk.requestSdk(new MarketingCloudSdk.WhenReadyListener() { // from class: com.salesforce.marketingcloud.proximity.a$$ExternalSyntheticLambda0
                @Override // com.salesforce.marketingcloud.MarketingCloudSdk.WhenReadyListener
                public final void ready(MarketingCloudSdk marketingCloudSdk) {
                    this.f$0.a(intentPutExtra, marketingCloudSdk);
                }
            });
        } else {
            Context context = this.c;
            context.sendBroadcast(intentPutExtra.setPackage(context.getPackageName()));
        }
    }

    public void didEnterRegion(Region region) {
        g.d(e.h, "didEnterRegion(%s)", region);
    }

    public void didExitRegion(Region region) {
        g.d(e.h, "didExitRegion(%s)", region);
    }

    public Context getApplicationContext() {
        return this.c;
    }

    public void onBeaconServiceConnect() {
        g.a(e.h, "onBeaconServiceConnect", new Object[0]);
        synchronized (this.d) {
            this.h = new BackgroundPowerSaver(this.c);
            this.b.addMonitorNotifier(this);
            this.f = true;
            this.g = false;
            c();
        }
    }

    public void unbindService(ServiceConnection serviceConnection) {
        this.c.unbindService(serviceConnection);
        this.c.stopService(this.i);
        this.f = false;
        this.g = false;
    }

    a(Context context, @Nullable ProximityNotificationCustomizationOptions proximityNotificationCustomizationOptions) {
        this.a = new ArrayMap();
        this.d = new ArrayList();
        this.c = context;
        BeaconManager instanceForApplication = BeaconManager.getInstanceForApplication(context);
        this.b = instanceForApplication;
        this.e = proximityNotificationCustomizationOptions;
        instanceForApplication.getBeaconParsers().add(new BeaconParser("iBeacon").setBeaconLayout(j));
        instanceForApplication.setBackgroundScanPeriod(5000L);
        instanceForApplication.setBackgroundBetweenScanPeriod(10000L);
        instanceForApplication.addMonitorNotifier(this);
    }

    private static c a(Region region) {
        try {
            return new c(region.getUniqueId(), region.getId1().toString(), region.getId2().toInt(), region.getId3().toInt());
        } catch (Exception e) {
            g.b(e.h, e, "Unable to convert Region to BeaconRegion", new Object[0]);
            return null;
        }
    }

    public void b(@NonNull List<c> list) {
        g.a(e.h, "unmonitorBeaconRegions() - [%d regions]", Integer.valueOf(list.size()));
        if (list.isEmpty()) {
            return;
        }
        for (c cVar : list) {
            this.a.remove(cVar.n());
            b(a(cVar));
        }
    }

    private void a(ProximityNotificationCustomizationOptions proximityNotificationCustomizationOptions) {
        if (proximityNotificationCustomizationOptions != null) {
            com.salesforce.marketingcloud.notifications.c cVar = new com.salesforce.marketingcloud.notifications.c(proximityNotificationCustomizationOptions.getSmallIconResId(), proximityNotificationCustomizationOptions.getChannelIdProvider());
            HashMap map = new HashMap();
            map.put("alert", "Searching for available beacons ...");
            map.put(NotificationMessage.NOTIF_KEY_ID, l);
            Notification notificationBuild = cVar.setupNotificationBuilder(this.c, j.a(map)).build();
            if (this.b.isAnyConsumerBound()) {
                return;
            }
            this.b.enableForegroundServiceScanning(notificationBuild, k);
        }
    }

    private void b(Region region) {
        try {
            this.b.stopMonitoring(region);
        } catch (Exception e) {
            g.a(e.h, e, "Failed to stop monitoring %s", region);
        }
    }

    public void a(@NonNull List<c> list) {
        String str = e.h;
        g.a(str, "monitorBeaconRegions() - [%d regions]", Integer.valueOf(list.size()));
        a(this.e);
        this.b.addMonitorNotifier(this);
        if (list.isEmpty()) {
            return;
        }
        synchronized (this.d) {
            this.d.clear();
            this.d.addAll(list);
            if (this.f) {
                c();
            } else {
                g.d(str, "Not yet connected.  Will register Beacons once complete.", new Object[0]);
                if (!this.g) {
                    b();
                }
            }
        }
    }

    private void a() {
        String str = e.h;
        g.d(str, "clearAllMonitoredRegions", new Object[0]);
        if (this.a.isEmpty()) {
            return;
        }
        g.d(str, "Stop monitoring %d BeaconRegions", Integer.valueOf(this.a.size()));
        for (Region region : this.a.values()) {
            if (region != null) {
                b(region);
            }
        }
        this.a.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Intent intent, MarketingCloudSdk marketingCloudSdk) {
        Context context = this.c;
        context.sendBroadcast(intent.setPackage(context.getPackageName()));
    }
}
