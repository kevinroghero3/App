package com.transistorsoft.locationmanager.geofence;

import android.app.PendingIntent;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.intentfilter.androidpermissions.PermissionManager;
import com.intentfilter.androidpermissions.models.DeniedPermissions;
import com.transistorsoft.locationmanager.adapter.BackgroundGeolocation;
import com.transistorsoft.locationmanager.adapter.TSConfig;
import com.transistorsoft.locationmanager.adapter.callback.TSCallback;
import com.transistorsoft.locationmanager.adapter.callback.TSGeofenceExistsCallback;
import com.transistorsoft.locationmanager.adapter.callback.TSGeofencesChangeCallback;
import com.transistorsoft.locationmanager.data.sqlite.GeofenceDAO;
import com.transistorsoft.locationmanager.event.BootEvent;
import com.transistorsoft.locationmanager.event.ConfigChangeEvent;
import com.transistorsoft.locationmanager.event.GeofencesChangeEvent;
import com.transistorsoft.locationmanager.event.HeadlessEvent;
import com.transistorsoft.locationmanager.event.LocationProviderChangeEvent;
import com.transistorsoft.locationmanager.event.MotionChangeEvent;
import com.transistorsoft.locationmanager.lifecycle.LifecycleManager;
import com.transistorsoft.locationmanager.location.TSLocationManager;
import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.locationmanager.service.ActivityRecognitionService;
import com.transistorsoft.locationmanager.service.GeofencingService;
import com.transistorsoft.locationmanager.service.PolygonGeofencingService;
import com.transistorsoft.locationmanager.settings.Settings;
import com.transistorsoft.locationmanager.util.HeadlessEventBroadcaster;
import com.transistorsoft.locationmanager.util.LocationAuthorization;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.lang3.StringUtils;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
public class TSGeofenceManager implements Runnable {
    public static final String ACTION_STATIONARY_GEOFENCE = "STATIONARY_GEOFENCE";
    public static final int MAX_GEOFENCES = 97;
    public static final float MINIMUM_STATIONARY_RADIUS = 150.0f;
    private static final String s = "-->";
    private static TSGeofenceManager t = null;
    private static final long u = 1000;
    private final Context a;
    private Location e;
    private Runnable g;
    private final long j;
    private final long k;
    private final AtomicBoolean l;
    private final AtomicBoolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final AtomicBoolean f111n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final AtomicInteger f112o;
    private final AtomicBoolean p;
    private final AtomicBoolean q;
    private final Handler r;
    private final ArrayList<String> b = new ArrayList<>();
    private final List<TSGeofencesChangeCallback> c = new ArrayList();
    private final Location d = new Location("TSLocationManager");
    private final AtomicLong f = new AtomicLong(0);
    private final List<String> h = new ArrayList();
    private final HashMap<String, Boolean> i = new HashMap<>();

    /* JADX INFO: loaded from: classes3.dex */
    class a implements Runnable {
        final /* synthetic */ TSConfig a;

        /* JADX INFO: renamed from: com.transistorsoft.locationmanager.geofence.TSGeofenceManager$a$a, reason: collision with other inner class name */
        class C0124a implements PermissionManager.PermissionRequestListener {
            final /* synthetic */ FusedLocationProviderClient a;
            final /* synthetic */ LocationRequest b;
            final /* synthetic */ PendingIntent c;

            C0124a(FusedLocationProviderClient fusedLocationProviderClient, LocationRequest locationRequest, PendingIntent pendingIntent) {
                this.a = fusedLocationProviderClient;
                this.b = locationRequest;
                this.c = pendingIntent;
            }

            @Override // com.intentfilter.androidpermissions.PermissionManager.PermissionRequestListener
            public void onPermissionDenied(DeniedPermissions deniedPermissions) {
                TSLog.logger.warn(TSLog.warn("Location permission denied while attempting to startMonitoringSignificantLocationChanges"));
                TSGeofenceManager.this.q.set(false);
            }

            @Override // com.intentfilter.androidpermissions.PermissionManager.PermissionRequestListener
            public void onPermissionGranted() {
                this.a.requestLocationUpdates(this.b, this.c);
                TSGeofenceManager.this.q.set(true);
            }
        }

        a(TSConfig tSConfig) {
            this.a = tSConfig;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (GeofenceDAO.getInstance(TSGeofenceManager.this.a).count() <= 0) {
                return;
            }
            TSLog.logger.info(TSLog.on("Start monitoring significant location changes"));
            FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(TSGeofenceManager.this.a);
            LocationRequest locationRequestCreate = LocationRequest.create();
            if (this.a.isLocationTrackingMode() || !this.a.getGeofenceModeHighAccuracy().booleanValue()) {
                locationRequestCreate.setPriority(104);
                locationRequestCreate.setSmallestDisplacement(this.a.getGeofenceProximityRadius().longValue() / 2.0f);
                locationRequestCreate.setInterval(60000L);
                locationRequestCreate.setFastestInterval(60000L);
                locationRequestCreate.setMaxWaitTime(60000L);
            } else {
                locationRequestCreate.setPriority(this.a.getIsMoving().booleanValue() ? this.a.getDesiredAccuracy().intValue() : 102);
                locationRequestCreate.setInterval(this.a.getLocationUpdateInterval().longValue());
                locationRequestCreate.setSmallestDisplacement(this.a.getIsMoving().booleanValue() ? 0 : 150);
                locationRequestCreate.setMaxWaitTime(0L);
                if (this.a.getFastestLocationUpdateInterval().longValue() >= 0) {
                    locationRequestCreate.setFastestInterval(this.a.getFastestLocationUpdateInterval().longValue());
                }
            }
            try {
                PendingIntent pendingIntent = GeofencingService.getPendingIntent(TSGeofenceManager.this.a);
                fusedLocationProviderClient.removeLocationUpdates(pendingIntent);
                LocationAuthorization.withBackgroundPermission(TSGeofenceManager.this.a, new C0124a(fusedLocationProviderClient, locationRequestCreate, pendingIntent));
            } catch (SecurityException e) {
                TSLog.logger.error(TSLog.error("SecurityException while attempting to requestLocationUpdates: " + e.getMessage()), (Throwable) e);
            }
        }
    }

    class b implements Runnable {
        final /* synthetic */ GeofencesChangeEvent a;

        b(GeofencesChangeEvent geofencesChangeEvent) {
            this.a = geofencesChangeEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LifecycleManager.getInstance().isHeadless()) {
                HeadlessEventBroadcaster.post(new HeadlessEvent(TSGeofenceManager.this.a, "geofenceschange", this.a));
                return;
            }
            synchronized (TSGeofenceManager.this.c) {
                Iterator it2 = TSGeofenceManager.this.c.iterator();
                if (it2.hasNext()) {
                    while (it2.hasNext()) {
                        ((TSGeofencesChangeCallback) it2.next()).onGeofencesChange(this.a);
                    }
                }
            }
        }
    }

    class c implements Runnable {
        private final Context a;
        private final TSCallback b;
        private final List<TSGeofence> c;

        class a implements TSCallback {
            a() {
            }

            @Override // com.transistorsoft.locationmanager.adapter.callback.TSCallback
            public void onFailure(String str) {
                TSGeofenceManager.this.reEvaluate();
                c.this.b.onSuccess();
            }

            @Override // com.transistorsoft.locationmanager.adapter.callback.TSCallback
            public void onSuccess() {
                TSGeofenceManager.this.reEvaluate();
                c.this.b.onSuccess();
            }
        }

        c(Context context, List<TSGeofence> list, TSCallback tSCallback) {
            this.a = context;
            this.c = list;
            this.b = tSCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.c.isEmpty()) {
                this.b.onFailure("No Geofences provided");
                return;
            }
            for (TSGeofence tSGeofence : this.c) {
                if (!tSGeofence.b()) {
                    this.b.onFailure("Geofence argument error '" + tSGeofence.getIdentifier() + "': " + tSGeofence.a().getMessage());
                    return;
                }
            }
            if (GeofenceDAO.getInstance(this.a).create(this.c) <= 0) {
                this.b.onFailure("INSERT geofences failed");
                return;
            }
            TSGeofenceManager.this.h();
            ArrayList arrayList = new ArrayList();
            Iterator<TSGeofence> it2 = this.c.iterator();
            while (it2.hasNext()) {
                String identifier = it2.next().getIdentifier();
                if (TSGeofenceManager.this.a(identifier)) {
                    arrayList.add(identifier);
                }
            }
            TSGeofenceManager.this.a(arrayList, new a());
        }
    }

    class d implements Runnable {

        class a implements TSLocationManager.LocationCallback {
            a() {
            }

            @Override // com.transistorsoft.locationmanager.location.TSLocationManager.LocationCallback
            public void onFailure(String str) {
            }

            @Override // com.transistorsoft.locationmanager.location.TSLocationManager.LocationCallback
            public void onLocation(Location location) {
                if (TSGeofenceManager.this.m.get()) {
                    TSGeofenceManager.this.a(location);
                }
            }
        }

        private d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            TSGeofenceManager.this.f112o.set(GeofenceDAO.getInstance(TSGeofenceManager.this.a).count());
            TSLocationManager.getInstance(TSGeofenceManager.this.a).getLastLocation(new a());
        }

        @Override // java.lang.Runnable
        public void run() {
            TSLog.logger.debug("evaluation buffer timer elapsed");
            if (TSGeofenceManager.this.g != null) {
                TSGeofenceManager.this.r.removeCallbacks(TSGeofenceManager.this.g);
                TSGeofenceManager.this.g = null;
            }
            BackgroundGeolocation.getThreadPool().execute(new Runnable() { // from class: com.transistorsoft.locationmanager.geofence.TSGeofenceManager$d$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a();
                }
            });
        }

        /* synthetic */ d(TSGeofenceManager tSGeofenceManager, a aVar) {
            this();
        }
    }

    class f implements Runnable {
        private final Context a;
        private final TSGeofenceExistsCallback b;
        private final String c;

        f(Context context, String str, TSGeofenceExistsCallback tSGeofenceExistsCallback) {
            this.a = context;
            this.c = str;
            this.b = tSGeofenceExistsCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.onResult(GeofenceDAO.getInstance(this.a).exists(this.c));
        }
    }

    class g implements Runnable {
        private final Context a;
        private final TSCallback b;
        private final List<String> c;

        class a implements TSCallback {
            a() {
            }

            @Override // com.transistorsoft.locationmanager.adapter.callback.TSCallback
            public void onFailure(String str) {
                g.this.a();
            }

            @Override // com.transistorsoft.locationmanager.adapter.callback.TSCallback
            public void onSuccess() {
                g.this.a();
            }
        }

        g(Context context, List<String> list, TSCallback tSCallback) {
            this.c = list;
            this.a = context;
            this.b = tSCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context = this.a;
            if (context == null) {
                TSLog.logger.warn(TSLog.warn("Failed to retrieve Context from WeakReference.  It seems the application process has been destroyed."));
                this.b.onFailure("Context reference failure");
                return;
            }
            GeofenceDAO geofenceDAO = GeofenceDAO.getInstance(context);
            if (geofenceDAO.count() == 0) {
                this.b.onSuccess();
            } else {
                TSGeofenceManager.this.a(this.c.isEmpty() ? geofenceDAO.getIdentifiers() : new ArrayList<>(this.c), new a());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            GeofenceDAO geofenceDAO = GeofenceDAO.getInstance(this.a);
            try {
                if (this.c.size() == 0) {
                    geofenceDAO.destroyAll();
                } else {
                    Iterator<String> it2 = this.c.iterator();
                    while (it2.hasNext()) {
                        geofenceDAO.destroy(it2.next());
                    }
                }
                TSGeofenceManager.this.h();
                TSGeofenceManager.this.reEvaluate();
                this.b.onSuccess();
            } catch (Exception e) {
                TSLog.logger.error(TSLog.error(e.getMessage()), (Throwable) e);
                this.b.onFailure(e.getMessage());
            }
        }
    }

    private TSGeofenceManager(Context context) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.l = atomicBoolean;
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
        this.m = atomicBoolean2;
        AtomicBoolean atomicBoolean3 = new AtomicBoolean(false);
        this.f111n = atomicBoolean3;
        AtomicInteger atomicInteger = new AtomicInteger(-1);
        this.f112o = atomicInteger;
        this.p = new AtomicBoolean(false);
        this.q = new AtomicBoolean(false);
        TSConfig tSConfig = TSConfig.getInstance(context.getApplicationContext());
        this.a = context.getApplicationContext();
        this.r = new Handler(Looper.getMainLooper());
        this.j = 30000L;
        this.k = 250L;
        atomicBoolean.set(false);
        atomicBoolean2.set(false);
        atomicBoolean3.set(false);
        atomicInteger.set(-1);
        if (tSConfig.getIsMoving().booleanValue()) {
            startMonitoringSignificantLocationChanges();
        }
        EventBus eventBus = EventBus.getDefault();
        if (eventBus.isRegistered(this)) {
            return;
        }
        eventBus.register(this);
    }

    public static TSGeofenceManager getInstance(Context context) {
        if (t == null) {
            t = a(context.getApplicationContext());
        }
        return t;
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void _onBootEvent(BootEvent bootEvent) {
        synchronized (this.h) {
            this.h.clear();
        }
        d();
        reEvaluate();
    }

    public void add(TSGeofence tSGeofence, TSCallback tSCallback) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(tSGeofence);
        add(arrayList, tSCallback);
    }

    public void destroy() {
        stop();
        EventBus eventBus = EventBus.getDefault();
        if (eventBus.isRegistered(this)) {
            eventBus.unregister(this);
        }
    }

    public void evaluate() {
        if (b()) {
            a(this.d);
        }
    }

    public void geofenceExists(String str, TSGeofenceExistsCallback tSGeofenceExistsCallback) {
        BackgroundGeolocation.getThreadPool().execute(new f(this.a, str, tSGeofenceExistsCallback));
    }

    public List<String> getMonitoredPolygonIdentifiers() {
        ArrayList arrayList;
        synchronized (this.i) {
            arrayList = new ArrayList(this.i.keySet());
        }
        return arrayList;
    }

    public boolean getPolygonState(String str) {
        boolean zEquals;
        synchronized (this.i) {
            zEquals = this.i.containsKey(str) ? Boolean.TRUE.equals(this.i.get(str)) : false;
        }
        return zEquals;
    }

    public Location getStationaryLocation() {
        return this.e;
    }

    public boolean hasGeofences() {
        return this.f112o.get() > 0;
    }

    public boolean isMonitoringGeofencesInProximity() {
        boolean zIsEmpty;
        synchronized (this.h) {
            zIsEmpty = this.h.isEmpty();
        }
        return !zIsEmpty;
    }

    public boolean isMonitoringInfiniteGeofences() {
        return this.f112o.get() > TSConfig.getInstance(this.a).getMaxMonitoredGeofences().intValue();
    }

    public boolean isMonitoringPolygon(String str) {
        boolean zContainsKey;
        synchronized (this.i) {
            zContainsKey = this.i.containsKey(str);
        }
        return zContainsKey;
    }

    public boolean isMonitoringPolygons() {
        boolean zIsEmpty;
        synchronized (this.i) {
            zIsEmpty = this.i.isEmpty();
        }
        return !zIsEmpty;
    }

    public boolean isMonitoringStationaryRegion() {
        return this.p.get();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onConfigChange(ConfigChangeEvent configChangeEvent) {
        if (configChangeEvent.isDirty("geofenceProximityRadius")) {
            evaluate();
        }
        TSConfig tSConfig = TSConfig.getInstance(configChangeEvent.getContext());
        if (tSConfig.isLocationTrackingMode()) {
            return;
        }
        if (configChangeEvent.isDirty("geofenceModeHighAccuracy")) {
            if (tSConfig.getGeofenceModeHighAccuracy().booleanValue()) {
                ActivityRecognitionService.start(this.a);
                if (tSConfig.getIsMoving().booleanValue()) {
                    startMonitoringSignificantLocationChanges();
                } else {
                    startMonitoringStationaryRegion(this.d);
                }
            } else {
                ActivityRecognitionService.stop(this.a);
                if (tSConfig.getIsMoving().booleanValue()) {
                    tSConfig.setIsMoving(Boolean.FALSE);
                    stopMonitoringSignificantLocationChanges();
                    GeofencingService.stop(this.a);
                }
                if (isMonitoringInfiniteGeofences()) {
                    startMonitoringSignificantLocationChanges();
                    startMonitoringStationaryRegion(this.d);
                }
            }
        }
        if (tSConfig.getGeofenceModeHighAccuracy().booleanValue() && tSConfig.getIsMoving().booleanValue()) {
            if (configChangeEvent.isDirty("locationUpdateInterval") || configChangeEvent.isDirty("distanceFilter") || configChangeEvent.isDirty("deferTime")) {
                startMonitoringSignificantLocationChanges();
            }
        }
    }

    public void onGeofencesChange(TSGeofencesChangeCallback tSGeofencesChangeCallback) {
        synchronized (this.c) {
            this.c.add(tSGeofencesChangeCallback);
        }
        reEvaluate();
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onMotionChangeEvent(MotionChangeEvent motionChangeEvent) {
        if (isMonitoringPolygons()) {
            if (motionChangeEvent.getIsMoving().booleanValue()) {
                GeofenceDAO geofenceDAO = GeofenceDAO.getInstance(this.a);
                Iterator<String> it2 = getMonitoredPolygonIdentifiers().iterator();
                while (it2.hasNext()) {
                    geofenceDAO.find(it2.next()).startMonitoringPolygon();
                }
                PolygonGeofencingService.startMonitoring(this.a);
                return;
            }
            if (!PolygonGeofencingService.StateChange.isEmpty() || PolygonGeofencingService.LoiteringEvent.isLoitering()) {
                return;
            }
            TSConfig tSConfig = TSConfig.getInstance(this.a);
            if (!LocationAuthorization.hasActivityPermission(this.a) || tSConfig.getDisableMotionActivityUpdates().booleanValue()) {
                return;
            }
            PolygonGeofencingService.stop(this.a);
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onProviderChangeEvent(LocationProviderChangeEvent locationProviderChangeEvent) {
        if (TSConfig.getInstance(this.a).getEnabled().booleanValue()) {
            if (locationProviderChangeEvent.isEnabled()) {
                evaluate();
            } else {
                reset();
            }
        }
    }

    public void reEvaluate() {
        g();
    }

    public void remove(String str, TSCallback tSCallback) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        remove(arrayList, tSCallback);
    }

    public Object removeListener(String str, Object obj) {
        if (!"geofenceschange".equalsIgnoreCase(str)) {
            return null;
        }
        synchronized (this.c) {
            if (!this.c.contains((TSGeofencesChangeCallback) obj)) {
                return null;
            }
            return Boolean.valueOf(this.c.remove(obj));
        }
    }

    public void removeListeners() {
        synchronized (this.c) {
            this.c.clear();
        }
    }

    public void reset() {
        f();
        this.f.set(0L);
        a();
    }

    @Override // java.lang.Runnable
    public void run() {
        start();
    }

    public void setIsMoving(boolean z) {
        this.l.set(z);
    }

    public void setLocation(Location location, boolean z) {
        float fDistanceTo;
        if (TSConfig.getInstance(this.a).getEnabled().booleanValue()) {
            if (!this.m.get()) {
                start();
            }
            if (this.f112o.get() == -1) {
                this.f112o.set(GeofenceDAO.getInstance(this.a).count());
            }
            if (this.f112o.get() == 0) {
                b(location);
                return;
            }
            long time = this.f.get() > 0 ? location.getTime() - this.f.get() : -1L;
            boolean z2 = true;
            boolean z3 = z != this.l.get();
            this.l.set(z);
            boolean z4 = this.f.get() == 0 || time >= this.j;
            String str = "isMoving: " + z + " | stateChanged: " + z3 + " | timerExpired: " + z4 + " | elapsed: " + time;
            if (time >= 0 && time < 10000) {
                TSLog.logger.debug(str);
                return;
            }
            if (b()) {
                synchronized (this.d) {
                    fDistanceTo = this.d.distanceTo(location);
                }
                if (TSConfig.getInstance(this.a).getDebug().booleanValue()) {
                    TSLog.logger.debug(str + " | d: " + fDistanceTo);
                }
                if (fDistanceTo <= TSConfig.getInstance(this.a).getGeofenceProximityRadius().longValue() / 2.0f) {
                    if (fDistanceTo < 200.0f && !z3) {
                        return;
                    }
                    z2 = z3;
                }
            } else {
                z2 = z3;
            }
            if (z4 || z2) {
                a(location);
            } else if (!b()) {
                b(location);
                a(location);
            }
            b(location);
        }
    }

    public void setPolygonState(String str, boolean z) {
        boolean z2;
        synchronized (this.i) {
            if (this.i.containsKey(str)) {
                this.i.put(str, Boolean.valueOf(z));
                z2 = true;
            } else {
                z2 = false;
            }
        }
        if (z2) {
            e();
        }
    }

    public void start() {
        if (this.m.get()) {
            return;
        }
        TSLog.logger.info(TSLog.on("Start monitoring geofences"));
        TSConfig tSConfig = TSConfig.getInstance(this.a);
        this.m.set(true);
        this.f111n.set(false);
        GeofenceDAO geofenceDAO = GeofenceDAO.getInstance(this.a);
        if (tSConfig.getDidDeviceReboot().booleanValue()) {
            reset();
        } else {
            SharedPreferences sharedPreferences = this.a.getSharedPreferences(getClass().getCanonicalName(), 0);
            Set<String> stringSet = sharedPreferences.getStringSet("mMonitoredIdentifiers", new HashSet());
            if (stringSet.size() > 0) {
                synchronized (this.h) {
                    this.h.addAll(stringSet);
                }
            }
            Set<String> stringSet2 = sharedPreferences.getStringSet("mMonitoredPolygons", new HashSet());
            if (!stringSet2.isEmpty()) {
                synchronized (this.i) {
                    Iterator<String> it2 = stringSet2.iterator();
                    while (it2.hasNext()) {
                        String[] strArrSplit = it2.next().split(s);
                        if (strArrSplit.length == 2) {
                            this.i.put(strArrSplit[0], Boolean.valueOf(Boolean.parseBoolean(strArrSplit[1])));
                        } else {
                            TSLog.warn(TSLog.warn("Unexpected record for mMonitoredPolygons; " + Arrays.toString(strArrSplit)));
                        }
                    }
                }
                for (String str : getMonitoredPolygonIdentifiers()) {
                    TSGeofence tSGeofenceFind = geofenceDAO.find(str);
                    if (tSGeofenceFind != null) {
                        startMonitoringPolygon(tSGeofenceFind);
                    } else {
                        TSLog.logger.warn(TSLog.warn("Expected to find a monitored-polygon '" + str + "' in the database but none was found"));
                        synchronized (this.i) {
                            this.i.remove(str);
                        }
                        e();
                    }
                }
            }
        }
        this.f112o.set(geofenceDAO.count());
    }

    public void startMonitoringPolygon(TSGeofence tSGeofence) {
        synchronized (this.i) {
            if (!this.i.containsKey(tSGeofence.getIdentifier())) {
                this.i.put(tSGeofence.getIdentifier(), Boolean.FALSE);
            }
        }
        e();
        tSGeofence.startMonitoringPolygon();
        PolygonGeofencingService.startMonitoring(this.a);
    }

    public void startMonitoringSignificantLocationChanges() {
        TSConfig tSConfig = TSConfig.getInstance(this.a);
        if (tSConfig.getEnabled().booleanValue() && Settings.isValid(this.a) && !tSConfig.isLocationTrackingMode()) {
            if (tSConfig.getGeofenceModeHighAccuracy().booleanValue()) {
                if (!tSConfig.getIsMoving().booleanValue()) {
                    return;
                }
            } else if (!isMonitoringInfiniteGeofences()) {
                return;
            }
            if (!this.m.get()) {
                start();
            }
            BackgroundGeolocation.getThreadPool().execute(new a(tSConfig));
        }
    }

    public void startMonitoringStationaryRegion(Location location) {
        float f2;
        TSConfig tSConfig = TSConfig.getInstance(this.a);
        if (!LocationAuthorization.hasBackgroundPermission(this.a)) {
            TSLog.logger.debug(TSLog.info("Cannot monitor stationary-region with 'WhenInUse' authorization"));
            return;
        }
        if (tSConfig.getIsMoving().booleanValue()) {
            return;
        }
        if (!tSConfig.isLocationTrackingMode() && !isMonitoringInfiniteGeofences() && !tSConfig.getGeofenceModeHighAccuracy().booleanValue()) {
            return;
        }
        GeofencingClient geofencingClient = LocationServices.getGeofencingClient(this.a.getApplicationContext());
        float fIntValue = tSConfig.getStationaryRadius().intValue();
        try {
            if (tSConfig.isLocationTrackingMode() || tSConfig.getGeofenceModeHighAccuracy().booleanValue()) {
                if (fIntValue < 150.0f) {
                    f2 = 150.0f;
                }
                TSLog.logger.debug(TSLog.on("Start monitoring stationary region (radius: " + f2 + "m " + location.getLatitude() + "," + location.getLongitude() + " hAcc=" + location.getAccuracy() + ")"));
                geofencingClient.addGeofences(new GeofencingRequest.Builder().addGeofence(new Geofence.Builder().setRequestId(ACTION_STATIONARY_GEOFENCE).setCircularRegion(location.getLatitude(), location.getLongitude(), f2).setExpirationDuration(-1L).setTransitionTypes(2).build()).build(), GeofencingService.getPendingIntent(this.a, ACTION_STATIONARY_GEOFENCE));
                this.p.set(true);
                this.e = location;
                return;
            }
            fIntValue = tSConfig.getGeofenceProximityRadius().longValue() / 2.0f;
            geofencingClient.addGeofences(new GeofencingRequest.Builder().addGeofence(new Geofence.Builder().setRequestId(ACTION_STATIONARY_GEOFENCE).setCircularRegion(location.getLatitude(), location.getLongitude(), f2).setExpirationDuration(-1L).setTransitionTypes(2).build()).build(), GeofencingService.getPendingIntent(this.a, ACTION_STATIONARY_GEOFENCE));
            this.p.set(true);
            this.e = location;
            return;
        } catch (SecurityException e2) {
            TSLog.logger.warn(TSLog.warn("SecurityException while attempting to addGeofences: " + e2.getMessage()));
            this.p.set(false);
            return;
        } catch (Exception e3) {
            TSLog.logger.warn(TSLog.warn("Exception while attempting to addGeofences: " + e3.getMessage()));
            this.p.set(false);
            return;
        }
        f2 = fIntValue;
        TSLog.logger.debug(TSLog.on("Start monitoring stationary region (radius: " + f2 + "m " + location.getLatitude() + "," + location.getLongitude() + " hAcc=" + location.getAccuracy() + ")"));
    }

    public void stop() {
        this.m.set(false);
        f();
        this.f.set(0L);
        Runnable runnable = this.g;
        if (runnable != null) {
            this.r.removeCallbacks(runnable);
        }
        BackgroundGeolocation.getThreadPool().execute(new Runnable() { // from class: com.transistorsoft.locationmanager.geofence.TSGeofenceManager$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c();
            }
        });
        stopMonitoringSignificantLocationChanges();
        GeofencingService.stop(this.a);
        if (isMonitoringPolygons()) {
            PolygonGeofencingService.stop(this.a);
            Iterator<String> it2 = getMonitoredPolygonIdentifiers().iterator();
            while (it2.hasNext()) {
                stopMonitoringPolygon(it2.next());
            }
        }
    }

    public void stopMonitoringPolygon(String str) {
        boolean zContainsKey;
        boolean zBooleanValue;
        synchronized (this.i) {
            zContainsKey = this.i.containsKey(str);
            zBooleanValue = zContainsKey ? this.i.get(str).booleanValue() : false;
            this.i.remove(str);
        }
        if (zContainsKey) {
            PolygonGeofencingService.StateChange stateChangeFindByIdentifier = PolygonGeofencingService.StateChange.findByIdentifier(str);
            if (stateChangeFindByIdentifier != null) {
                PolygonGeofencingService.handleGeofencingEvent(this.a, str, stateChangeFindByIdentifier.location, zBooleanValue ? 2 : 1);
                PolygonGeofencingService.StateChange.remove(str);
            }
            e();
            TSGeofence.clearPolygon(str);
        }
    }

    public void stopMonitoringSignificantLocationChanges() {
        if (this.q.get()) {
            TSLog.logger.info(TSLog.off("Stop monitoring significant location changes"));
            this.q.set(false);
            LocationServices.getFusedLocationProviderClient(this.a).removeLocationUpdates(GeofencingService.getPendingIntent(this.a));
        }
    }

    public void stopMonitoringStationaryRegion() {
        if (this.p.get()) {
            TSLog.logger.debug(TSLog.off("Stop monitoring stationary region"));
            this.p.set(false);
            this.e = null;
            LocationServices.getGeofencingClient(this.a.getApplicationContext()).removeGeofences(GeofencingService.getPendingIntent(this.a, ACTION_STATIONARY_GEOFENCE));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(final TSCallback tSCallback, final Exception exc) {
        TSLog.logger.error(TSLog.warn("GeofencingClient removeGeofences FAILURE: " + exc.getMessage()));
        if (tSCallback != null) {
            BackgroundGeolocation.getThreadPool().execute(new Runnable() { // from class: com.transistorsoft.locationmanager.geofence.TSGeofenceManager$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    TSGeofenceManager.a(tSCallback, exc);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        c((TSCallback) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(final TSCallback tSCallback, final Exception exc) {
        TSLog.logger.error(TSLog.warn("GeofencingClient removeGeofences FAILURE: " + exc.getMessage()));
        if (tSCallback != null) {
            BackgroundGeolocation.getThreadPool().execute(new Runnable() { // from class: com.transistorsoft.locationmanager.geofence.TSGeofenceManager$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    TSGeofenceManager.c(tSCallback, exc);
                }
            });
        }
    }

    private void e() {
        final SharedPreferences.Editor editorEdit = this.a.getSharedPreferences(getClass().getCanonicalName(), 0).edit();
        ArrayList arrayList = new ArrayList();
        synchronized (this.i) {
            for (Map.Entry<String, Boolean> entry : this.i.entrySet()) {
                arrayList.add(entry.getKey() + s + entry.getValue());
            }
            TSLog.logger.debug("ℹ️  Persist monitored polygons: " + this.i);
        }
        editorEdit.putStringSet("mMonitoredPolygons", new HashSet(arrayList));
        BackgroundGeolocation.getThreadPool().execute(new Runnable() { // from class: com.transistorsoft.locationmanager.geofence.TSGeofenceManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                editorEdit.apply();
            }
        });
    }

    private void f() {
        synchronized (this.d) {
            this.d.reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.f112o.set(GeofenceDAO.getInstance(this.a).count());
    }

    void g() {
        Runnable runnable = this.g;
        if (runnable != null) {
            this.r.removeCallbacks(runnable);
        } else {
            this.g = new d(this, null);
        }
        this.r.postDelayed(this.g, this.k);
    }

    void c(final TSCallback tSCallback) {
        TSLog.logger.debug(TSLog.off("Stop monitoring geofences"));
        GeofencingClient geofencingClient = LocationServices.getGeofencingClient(this.a);
        final List<String> identifiers = GeofenceDAO.getInstance(this.a).getIdentifiers();
        if (identifiers.isEmpty()) {
            if (tSCallback != null) {
                tSCallback.onSuccess();
                return;
            }
            return;
        }
        if (isMonitoringPolygons()) {
            for (String str : identifiers) {
                if (isMonitoringPolygon(str)) {
                    stopMonitoringPolygon(str);
                }
            }
        }
        geofencingClient.removeGeofences(identifiers).addOnSuccessListener(new OnSuccessListener() { // from class: com.transistorsoft.locationmanager.geofence.TSGeofenceManager$$ExternalSyntheticLambda4
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                this.f$0.a(identifiers, tSCallback, (Void) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.transistorsoft.locationmanager.geofence.TSGeofenceManager$$ExternalSyntheticLambda5
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                TSGeofenceManager.b(tSCallback, exc);
            }
        });
    }

    public void add(List<TSGeofence> list, TSCallback tSCallback) {
        BackgroundGeolocation.getThreadPool().execute(new c(this.a, list, tSCallback));
    }

    public void remove(List<String> list, TSCallback tSCallback) {
        BackgroundGeolocation.getThreadPool().execute(new g(this.a, list, tSCallback));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(List list, final TSCallback tSCallback, Void r4) {
        TSLog.logger.debug("ℹ️  GeofencingClient removeGeofences SUCCESS");
        synchronized (this.h) {
            this.h.removeAll(list);
        }
        d();
        a(new GeofencesChangeEvent().setOff(list));
        if (tSCallback != null) {
            BackgroundGeolocation.getThreadPool().execute(new Runnable() { // from class: com.transistorsoft.locationmanager.geofence.TSGeofenceManager$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    tSCallback.onSuccess();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        final SharedPreferences.Editor editorEdit = this.a.getSharedPreferences(getClass().getCanonicalName(), 0).edit();
        synchronized (this.h) {
            editorEdit.putStringSet("mMonitoredIdentifiers", new HashSet(this.h));
        }
        TSLog.logger.debug("ℹ️  Persist monitored geofences: " + this.h);
        BackgroundGeolocation.getThreadPool().execute(new Runnable() { // from class: com.transistorsoft.locationmanager.geofence.TSGeofenceManager$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                editorEdit.apply();
            }
        });
    }

    private static TSGeofenceManager a(Context context) {
        TSGeofenceManager tSGeofenceManager;
        synchronized (TSGeofenceManager.class) {
            if (t == null) {
                t = new TSGeofenceManager(context.getApplicationContext());
            }
            tSGeofenceManager = t;
        }
        return tSGeofenceManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        synchronized (this.h) {
            this.h.clear();
        }
        d();
        synchronized (this.i) {
            this.i.clear();
        }
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        boolean zContains;
        synchronized (this.h) {
            zContains = this.h.contains(str);
        }
        return zContains;
    }

    private boolean b() {
        boolean z;
        synchronized (this.d) {
            z = this.d.getTime() > 0;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Location location) {
        if (!this.m.get()) {
            TSLog.logger.warn(TSLog.warn("TSGeofenceManager is disabled"));
        } else if (location == null) {
            TSLog.logger.warn(TSLog.warn("Executed with null location"));
        } else {
            BackgroundGeolocation.getThreadPool().execute(new e(location));
        }
    }

    private void b(Location location) {
        synchronized (this.d) {
            this.d.set(location);
        }
    }

    class e implements Runnable {
        private final Location a;

        class a implements TSCallback {
            final /* synthetic */ TSGeofence a;

            a(TSGeofence tSGeofence) {
                this.a = tSGeofence;
            }

            @Override // com.transistorsoft.locationmanager.adapter.callback.TSCallback
            public void onFailure(String str) {
            }

            @Override // com.transistorsoft.locationmanager.adapter.callback.TSCallback
            public void onSuccess() {
                TSLog.logger.warn(TSLog.warn("Destroyed an invalid geofence with error: " + this.a.a().getMessage()));
            }
        }

        e(Location location) {
            this.a = location;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(TSConfig tSConfig, List list, List list2, StringBuffer stringBuffer, List list3, Void r8) {
            TSGeofenceManager.this.f.set(this.a.getTime());
            TSLog.logger.debug("ℹ️  GeofencingClient addGeofences SUCCESS");
            if (!tSConfig.isLocationTrackingMode() && !ActivityRecognitionService.isStarted()) {
                ActivityRecognitionService.start(TSGeofenceManager.this.a);
            }
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                TSGeofence tSGeofence = (TSGeofence) it2.next();
                if (!list2.contains(tSGeofence)) {
                    list2.add(tSGeofence);
                }
                if (!TSGeofenceManager.this.a(tSGeofence.getIdentifier())) {
                    synchronized (TSGeofenceManager.this.h) {
                        TSGeofenceManager.this.h.add(tSGeofence.getIdentifier());
                    }
                }
            }
            synchronized (TSGeofenceManager.this.h) {
                Iterator it3 = TSGeofenceManager.this.h.iterator();
                while (it3.hasNext()) {
                    stringBuffer.append(TSLog.boxRow(TSLog.ICON_ON + ((String) it3.next())));
                }
            }
            TSGeofenceManager.this.d();
            stringBuffer.append(TSLog.BOX_BOTTOM);
            TSLog.logger.debug(stringBuffer.toString());
            TSGeofenceManager.this.a(new GeofencesChangeEvent(list2, list3));
        }

        @Override // java.lang.Runnable
        public void run() {
            final List list;
            ArrayList arrayList;
            ArrayList arrayList2;
            boolean zIsEmpty;
            final TSConfig tSConfig = TSConfig.getInstance(TSGeofenceManager.this.a);
            long jLongValue = tSConfig.getGeofenceProximityRadius().longValue();
            if (this.a.hasAccuracy()) {
                jLongValue = (long) (jLongValue + this.a.getAccuracy());
            }
            int i = TSGeofenceManager.this.f112o.get();
            int iIntValue = tSConfig.getMaxMonitoredGeofences().intValue();
            final ArrayList<TSGeofence> arrayList3 = new ArrayList();
            final ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            HashMap map = new HashMap();
            if (i > 0) {
                if (i < iIntValue) {
                    synchronized (TSGeofenceManager.this.h) {
                        if (TSGeofenceManager.this.f111n.get() && TSGeofenceManager.this.h.size() == i) {
                            return;
                        } else {
                            arrayList3.addAll(GeofenceDAO.getInstance(TSGeofenceManager.this.a).all());
                        }
                    }
                } else {
                    arrayList3.addAll(GeofenceDAO.getInstance(TSGeofenceManager.this.a).allWithinRadius(jLongValue, this.a.getLatitude(), this.a.getLongitude(), iIntValue));
                }
            }
            if (TSGeofenceManager.this.f111n.compareAndSet(false, true)) {
                arrayList4.addAll(arrayList3);
            }
            for (TSGeofence tSGeofence : arrayList3) {
                map.put(tSGeofence.getIdentifier(), tSGeofence);
            }
            final StringBuffer stringBuffer = new StringBuffer();
            String str = "TSGeofenceManager monitoring " + arrayList3.size() + RemoteSettings.FORWARD_SLASH_STRING + TSGeofenceManager.this.f112o.get();
            if (TSGeofenceManager.this.isMonitoringInfiniteGeofences()) {
                str = str + " within " + tSConfig.getGeofenceProximityRadius() + " meters";
            }
            stringBuffer.append(TSLog.header(str));
            synchronized (TSGeofenceManager.this.h) {
                for (String str2 : TSGeofenceManager.this.h) {
                    if (map.containsKey(str2)) {
                        arrayList3.remove(map.get(str2));
                    } else {
                        arrayList5.add(str2);
                    }
                }
            }
            if (!arrayList5.isEmpty()) {
                TSGeofenceManager.this.a(arrayList5, (TSCallback) null);
            }
            if (arrayList3.isEmpty()) {
                list = arrayList5;
                arrayList = arrayList4;
                arrayList2 = arrayList3;
                TSGeofenceManager.this.f.set(this.a.getTime());
                if (i == 0 && !tSConfig.isLocationTrackingMode()) {
                    if (tSConfig.getGeofenceModeHighAccuracy().booleanValue() && ActivityRecognitionService.isStarted()) {
                        ActivityRecognitionService.stop(TSGeofenceManager.this.a);
                    }
                    TSGeofenceManager.this.stopMonitoringStationaryRegion();
                    TSGeofenceManager.this.stopMonitoringSignificantLocationChanges();
                }
                synchronized (TSGeofenceManager.this.h) {
                    for (String str3 : TSGeofenceManager.this.h) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(!list.contains(str3) ? TSLog.ICON_ON : TSLog.ICON_OFF);
                        sb.append(str3);
                        stringBuffer.append(TSLog.boxRow(sb.toString()));
                    }
                    stringBuffer.append(TSLog.BOX_BOTTOM);
                    TSLog.logger.debug(stringBuffer.toString());
                }
            } else {
                GeofencingRequest.Builder builder = new GeofencingRequest.Builder();
                if (tSConfig.getGeofenceInitialTriggerEntry().booleanValue()) {
                    builder.setInitialTrigger(5);
                } else {
                    builder.setInitialTrigger(0);
                }
                for (TSGeofence tSGeofence2 : arrayList3) {
                    if (tSGeofence2.b()) {
                        builder.addGeofence(tSGeofence2.build());
                    } else {
                        TSGeofenceManager.this.remove(tSGeofence2.getIdentifier(), new a(tSGeofence2));
                    }
                }
                try {
                    list = arrayList5;
                    arrayList = arrayList4;
                    arrayList2 = arrayList3;
                    try {
                        LocationServices.getGeofencingClient(TSGeofenceManager.this.a).addGeofences(builder.build(), GeofencingService.getPendingIntent(TSGeofenceManager.this.a)).addOnSuccessListener(new OnSuccessListener() { // from class: com.transistorsoft.locationmanager.geofence.TSGeofenceManager$e$$ExternalSyntheticLambda0
                            @Override // com.google.android.gms.tasks.OnSuccessListener
                            public final void onSuccess(Object obj) {
                                this.f$0.a(tSConfig, arrayList3, arrayList4, stringBuffer, list, (Void) obj);
                            }
                        }).addOnFailureListener(new OnFailureListener() { // from class: com.transistorsoft.locationmanager.geofence.TSGeofenceManager$e$$ExternalSyntheticLambda1
                            @Override // com.google.android.gms.tasks.OnFailureListener
                            public final void onFailure(Exception exc) {
                                this.f$0.a(exc);
                            }
                        });
                    } catch (IllegalArgumentException e) {
                        e = e;
                        TSLog.logger.error(TSLog.error(e.getMessage()));
                    } catch (SecurityException e2) {
                        e = e2;
                        TSLog.logger.error(TSLog.error("SecurityException while attempting to listen to geofences: " + e.getMessage()), (Throwable) e);
                    }
                } catch (IllegalArgumentException e3) {
                    e = e3;
                    list = arrayList5;
                    arrayList = arrayList4;
                    arrayList2 = arrayList3;
                } catch (SecurityException e4) {
                    e = e4;
                    list = arrayList5;
                    arrayList = arrayList4;
                    arrayList2 = arrayList3;
                }
            }
            if (list.size() + arrayList.size() != 0 || TSGeofenceManager.this.f112o.get() <= 0) {
                if (arrayList2.isEmpty()) {
                    TSGeofenceManager.this.a(new GeofencesChangeEvent(arrayList, list));
                }
                if (!tSConfig.isLocationTrackingMode() && tSConfig.getGeofenceModeHighAccuracy().booleanValue() && tSConfig.getIsMoving().booleanValue()) {
                    synchronized (TSGeofenceManager.this.h) {
                        zIsEmpty = TSGeofenceManager.this.h.isEmpty();
                    }
                    if (list.isEmpty() || !zIsEmpty) {
                        if (arrayList.isEmpty()) {
                            return;
                        }
                        TSGeofenceManager.this.startMonitoringSignificantLocationChanges();
                    } else {
                        tSConfig.setIsMoving(Boolean.FALSE);
                        GeofencingService.stopService(TSGeofenceManager.this.a);
                        TSGeofenceManager.this.stopMonitoringSignificantLocationChanges();
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(Exception exc) {
            ApiException apiException;
            String str = "Failed to start monitoring geofences: " + exc.getMessage();
            if ((exc instanceof ApiException) && (apiException = (ApiException) ApiException.class.cast(exc)) != null) {
                if (apiException.getStatusCode() == 1004) {
                    str = "Geofence monitoring is forbidden with location permission 'WhenInUse'";
                } else {
                    str = str + StringUtils.SPACE + apiException.getStatusCode() + StringUtils.SPACE + apiException.getStatusMessage();
                }
            }
            TSLog.logger.warn(TSLog.warn(str));
            TSGeofenceManager.this.a();
            TSGeofenceManager.this.a(new GeofencesChangeEvent());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(List list, final TSCallback tSCallback, Void r4) {
        TSLog.logger.debug("ℹ️  GeofencingClient removeGeofences SUCCESS");
        synchronized (this.h) {
            this.h.clear();
        }
        d();
        a(new GeofencesChangeEvent().setOff(list));
        if (tSCallback != null) {
            BackgroundGeolocation.getThreadPool().execute(new Runnable() { // from class: com.transistorsoft.locationmanager.geofence.TSGeofenceManager$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    tSCallback.onSuccess();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(TSCallback tSCallback, Exception exc) {
        tSCallback.onFailure(exc.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(TSCallback tSCallback, Exception exc) {
        tSCallback.onFailure(exc.getMessage());
    }

    void a(List<String> list, final TSCallback tSCallback) {
        if (list.isEmpty()) {
            if (tSCallback != null) {
                tSCallback.onSuccess();
                return;
            }
            return;
        }
        ArrayList<String> arrayList = new ArrayList();
        for (String str : list) {
            if (a(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            if (tSCallback != null) {
                tSCallback.onSuccess();
                return;
            }
            return;
        }
        if (isMonitoringPolygons()) {
            for (String str2 : arrayList) {
                if (isMonitoringPolygon(str2)) {
                    stopMonitoringPolygon(str2);
                }
            }
        }
        LocationServices.getGeofencingClient(this.a).removeGeofences(arrayList).addOnSuccessListener(new TSGeofenceManager$$ExternalSyntheticLambda7(this, arrayList, tSCallback)).addOnFailureListener(new OnFailureListener() { // from class: com.transistorsoft.locationmanager.geofence.TSGeofenceManager$$ExternalSyntheticLambda8
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                TSGeofenceManager.d(tSCallback, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GeofencesChangeEvent geofencesChangeEvent) {
        BackgroundGeolocation.getUiHandler().post(new b(geofencesChangeEvent));
    }
}
