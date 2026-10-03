package com.transistorsoft.locationmanager.location;

import android.app.PendingIntent;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.compose.animation.core.AnimationKt;
import androidx.core.app.NotificationCompat;
import androidx.core.location.LocationManagerCompat;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.transistorsoft.locationmanager.adapter.BackgroundGeolocation;
import com.transistorsoft.locationmanager.adapter.TSConfig;
import com.transistorsoft.locationmanager.adapter.callback.TSLocationCallback;
import com.transistorsoft.locationmanager.data.sqlite.SQLiteLocationDAO;
import com.transistorsoft.locationmanager.event.ConfigChangeEvent;
import com.transistorsoft.locationmanager.event.LocationErrorEvent;
import com.transistorsoft.locationmanager.event.LocationProviderChangeEvent;
import com.transistorsoft.locationmanager.event.MotionChangeEvent;
import com.transistorsoft.locationmanager.event.PersistEvent;
import com.transistorsoft.locationmanager.event.StopDetectionEvent;
import com.transistorsoft.locationmanager.geofence.TSGeofenceManager;
import com.transistorsoft.locationmanager.http.HttpService;
import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.locationmanager.logger.TSMediaPlayer;
import com.transistorsoft.locationmanager.plugin.TSPlugin;
import com.transistorsoft.locationmanager.service.ActivityRecognitionService;
import com.transistorsoft.locationmanager.service.TrackingService;
import com.transistorsoft.locationmanager.settings.Settings;
import com.transistorsoft.locationmanager.util.LocationAuthorization;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;
import org.slf4j.Logger;

/* JADX INFO: loaded from: classes.dex */
public class TSLocationManager {
    public static final int LOCATION_ERROR_BACKGROUND_WHEN_IN_USE = 3;
    public static final int LOCATION_ERROR_CANCELLED = 499;
    public static final int LOCATION_ERROR_DENIED = 1;
    public static final int LOCATION_ERROR_MINIMUM_ACCURACY = 100;
    public static final int LOCATION_ERROR_NETWORK = 2;
    public static final int LOCATION_ERROR_NOT_INITIALIZED = -1;
    public static final int LOCATION_ERROR_TIMEOUT = 408;
    public static final int LOCATION_ERROR_TRACKING_MODE_DISABLED = 101;
    public static final int LOCATION_ERROR_UNKNOWN = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static TSLocationManager f117n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final float f118o = 250.0f;
    private static final String p = "odometer_latitude";
    private static final String q = "odometer_longitude";
    private static final String r = "odometer_accuracy";
    private final Context a;
    private TSWatchPositionRequest f;
    private TSProviderChangeRequest g;
    private float l;
    private LocationProviderChangeEvent m;
    private final Map<Integer, SingleLocationRequest> b = new HashMap();
    private final LocationRequest c = LocationRequest.create();
    private final AtomicBoolean d = new AtomicBoolean(false);
    private final AtomicBoolean e = new AtomicBoolean(false);
    private final Location h = new Location("TSLocationManager");
    private final Location i = new Location("TSLocationManager");
    private final Location j = new Location("TSLocationManager");
    private final ArrayList<Float> k = new ArrayList<>();

    public interface LocationCallback {
        void onFailure(String str);

        void onLocation(Location location);
    }

    class a implements LocationCallback {
        final /* synthetic */ SingleLocationRequest a;

        a(SingleLocationRequest singleLocationRequest) {
            this.a = singleLocationRequest;
        }

        @Override // com.transistorsoft.locationmanager.location.TSLocationManager.LocationCallback
        public void onFailure(String str) {
            this.a.g();
        }

        @Override // com.transistorsoft.locationmanager.location.TSLocationManager.LocationCallback
        public void onLocation(Location location) {
            TSLocationManager.this.onSingleLocationResult(new SingleLocationResult(this.a.getId(), location));
            if (this.a.e()) {
                return;
            }
            this.a.g();
        }
    }

    class b implements LocationCallback {
        b() {
        }

        @Override // com.transistorsoft.locationmanager.location.TSLocationManager.LocationCallback
        public void onFailure(String str) {
        }

        @Override // com.transistorsoft.locationmanager.location.TSLocationManager.LocationCallback
        public void onLocation(Location location) {
            Location locationA;
            TSProviderChangeRequest tSProviderChangeRequestBuild = new TSProviderChangeRequest.Builder(TSLocationManager.this.a).setSamples(0).build();
            TSLocationManager.this.register(tSProviderChangeRequestBuild);
            synchronized (TSLocationManager.this.h) {
                locationA = TSLocationManager.a(TSLocationManager.this.h);
            }
            TSLocationManager.this.onSingleLocationResult(new SingleLocationResult(tSProviderChangeRequestBuild.getId(), locationA));
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    class c implements TSLocationCallback {
        final /* synthetic */ Location a;
        final /* synthetic */ TSConfig b;

        class a implements LocationCallback {
            a() {
            }

            @Override // com.transistorsoft.locationmanager.location.TSLocationManager.LocationCallback
            public void onFailure(String str) {
            }

            @Override // com.transistorsoft.locationmanager.location.TSLocationManager.LocationCallback
            public void onLocation(Location location) {
                Location locationA;
                synchronized (TSLocationManager.this.h) {
                    locationA = TSLocationManager.a(TSLocationManager.this.h);
                }
                TSLocationManager tSLocationManager = TSLocationManager.this;
                tSLocationManager.onSingleLocationResult(new SingleLocationResult(tSLocationManager.g.getId(), locationA));
            }
        }

        c(Location location, TSConfig tSConfig) {
            this.a = location;
            this.b = tSConfig;
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSLocationCallback
        public void onError(Integer num) {
            TSLocationManager.this.getLastLocation(new a());
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSLocationCallback
        public void onLocation(TSLocation tSLocation) {
            Location location = tSLocation.getLocation();
            float fDistanceTo = location.distanceTo(this.a);
            if (location.hasAccuracy()) {
                fDistanceTo += location.getAccuracy();
            }
            if (this.a.hasAccuracy()) {
                fDistanceTo += this.a.getAccuracy();
            }
            TSLog.logger.debug(TSLog.info("Distance from last location: " + fDistanceTo));
            if (fDistanceTo < 200.0f) {
                return;
            }
            if (!this.b.getIsMoving().booleanValue()) {
                TSGeofenceManager.getInstance(TSLocationManager.this.a).startMonitoringStationaryRegion(location);
            } else if (this.b.isLocationTrackingMode()) {
                TSLocationManager.this.requestLocationUpdates();
            } else {
                TSGeofenceManager.getInstance(TSLocationManager.this.a).startMonitoringSignificantLocationChanges();
            }
        }
    }

    class d implements Runnable {
        final /* synthetic */ SingleLocationRequest a;
        final /* synthetic */ TSLocation b;

        d(SingleLocationRequest singleLocationRequest, TSLocation tSLocation) {
            this.a = singleLocationRequest;
            this.b = tSLocation;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.onSuccess(this.b);
        }
    }

    class e implements LocationCallback {
        final /* synthetic */ SingleLocationRequest a;

        e(SingleLocationRequest singleLocationRequest) {
            this.a = singleLocationRequest;
        }

        @Override // com.transistorsoft.locationmanager.location.TSLocationManager.LocationCallback
        public void onFailure(String str) {
            TSLocationManager.this.cancelRequest(this.a);
        }

        @Override // com.transistorsoft.locationmanager.location.TSLocationManager.LocationCallback
        public void onLocation(Location location) {
            Location locationA = TSLocationManager.a(location);
            this.a.a(locationA);
            this.a.b(0);
            TSLocationManager.this.onSingleLocationResult(new SingleLocationResult(this.a.getId(), locationA));
            TSLocationManager.this.cancelRequest(this.a);
        }
    }

    class f implements LocationCallback {
        final /* synthetic */ LocationCallback a;

        f(LocationCallback locationCallback) {
            this.a = locationCallback;
        }

        @Override // com.transistorsoft.locationmanager.location.TSLocationManager.LocationCallback
        public void onFailure(String str) {
            TSLog.logger.warn(TSLog.warn("Failed to acquire stationary location from last-known-location"));
            this.a.onFailure("Failed to acquire stationary location");
        }

        @Override // com.transistorsoft.locationmanager.location.TSLocationManager.LocationCallback
        public void onLocation(Location location) {
            TSLog.logger.info(TSLog.notice("Force acquire stationary location with last-known-location"));
            Bundle extras = location.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            location.setTime(System.currentTimeMillis());
            extras.putString(NotificationCompat.CATEGORY_EVENT, BackgroundGeolocation.ACTION_ON_MOTION_CHANGE);
            this.a.onLocation(location);
        }
    }

    class g implements Comparator<Float> {
        g() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Float f, Float f2) {
            return (int) (f.floatValue() - f2.floatValue());
        }
    }

    private TSLocationManager(Context context) {
        TSConfig tSConfig = TSConfig.getInstance(context.getApplicationContext());
        this.a = context;
        EventBus eventBus = EventBus.getDefault();
        if (!eventBus.isRegistered(this)) {
            eventBus.register(this);
        }
        if (tSConfig.getEnabled().booleanValue() && tSConfig.isLocationTrackingMode()) {
            c();
        }
    }

    private void d() {
        if (this.d.get()) {
            TSLog.logger.info(TSLog.off("Location-services: OFF"));
        }
        this.d.set(false);
        FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this.a);
        if (fusedLocationProviderClient == null) {
            return;
        }
        fusedLocationProviderClient.removeLocationUpdates(TrackingService.getPendingIntent(this.a));
    }

    private void e() {
        synchronized (this.b) {
            Iterator<Map.Entry<Integer, SingleLocationRequest>> it2 = this.b.entrySet().iterator();
            while (it2.hasNext()) {
                SingleLocationRequest value = it2.next().getValue();
                value.finish();
                TSLog.logger.debug(TSLog.off("Stop LocationRequest: " + value.getId()));
                it2.remove();
            }
        }
    }

    private void f(Location location) {
        if (TSConfig.getInstance(this.a).getEnabled().booleanValue()) {
            TSLocation.applyExtras(this.a, location);
            synchronized (this.j) {
                this.j.set(location);
            }
            final SharedPreferences.Editor editorEdit = this.a.getSharedPreferences(getClass().getSimpleName(), 0).edit();
            long jDoubleToRawLongBits = Double.doubleToRawLongBits(location.getLatitude());
            long jDoubleToRawLongBits2 = Double.doubleToRawLongBits(location.getLongitude());
            editorEdit.putLong(p, jDoubleToRawLongBits);
            editorEdit.putLong(q, jDoubleToRawLongBits2);
            editorEdit.putFloat(r, location.getAccuracy());
            BackgroundGeolocation.getThreadPool().execute(new Runnable() { // from class: com.transistorsoft.locationmanager.location.TSLocationManager$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    editorEdit.apply();
                }
            });
        }
    }

    private void g(Location location) {
        String string;
        synchronized (this.h) {
            if (!b(this.h) || TSLocation.a(location) >= TSLocation.a(this.h)) {
                float accuracy = location.getAccuracy();
                a(accuracy);
                Bundle extras = location.getExtras();
                boolean zEqualsIgnoreCase = (!extras.containsKey(NotificationCompat.CATEGORY_EVENT) || (string = extras.getString(NotificationCompat.CATEGORY_EVENT)) == null) ? false : string.equalsIgnoreCase(BackgroundGeolocation.EVENT_MOTIONCHANGE);
                if (!extras.containsKey("sample")) {
                    TSConfig tSConfig = TSConfig.getInstance(this.a);
                    if (tSConfig.isLocationTrackingMode() && accuracy <= tSConfig.getDesiredOdometerAccuracy().floatValue()) {
                        if ((!tSConfig.getIsMoving().booleanValue() || location.getSpeed() <= 0.0f) && !zEqualsIgnoreCase) {
                            synchronized (this.j) {
                                if (!b(this.j)) {
                                    f(location);
                                }
                            }
                        } else {
                            c(location);
                        }
                    }
                    synchronized (this.i) {
                        if (!b(this.i) || accuracy <= TSConfig.MAXIMUM_LOCATION_ACCURACY.floatValue()) {
                            this.i.set(location);
                        }
                    }
                }
                synchronized (this.h) {
                    this.h.set(location);
                    this.h.setExtras(new Bundle());
                }
            }
        }
    }

    public static TSLocationManager getInstance(Context context) {
        if (f117n == null) {
            f117n = a(context.getApplicationContext());
        }
        return f117n;
    }

    public static float speedBetween(Location location, Location location2) {
        return (location.distanceTo(location2) / elapsedTimeMillis(location, location2)) * 1000.0f;
    }

    public LocationRequest buildLocationRequest() {
        TSConfig tSConfig = TSConfig.getInstance(this.a);
        synchronized (this.c) {
            float fFloatValue = tSConfig.getDistanceFilter().floatValue();
            if (fFloatValue < 0.0f) {
                Logger logger = TSLog.logger;
                StringBuilder sb = new StringBuilder();
                sb.append(TSLog.warn("Invalid distanceFilter: " + fFloatValue));
                sb.append(".  Applying default ");
                fFloatValue = 10.0f;
                sb.append(10.0f);
                logger.warn(sb.toString());
            }
            long j = 0;
            if (tSConfig.getFastestLocationUpdateInterval().longValue() >= 0) {
                this.c.setFastestInterval(tSConfig.getFastestLocationUpdateInterval().longValue());
            }
            if (tSConfig.isLocationTrackingMode()) {
                if (tSConfig.getUseSignificantChangesOnly().booleanValue() && fFloatValue < f118o) {
                    fFloatValue = 250.0f;
                }
                long jLongValue = tSConfig.getDeferTime().longValue();
                if (jLongValue >= 0) {
                    j = jLongValue;
                }
                this.c.setSmallestDisplacement(fFloatValue);
                this.c.setInterval(tSConfig.getLocationUpdateInterval().longValue());
                this.c.setMaxWaitTime(j);
                this.c.setPriority(tSConfig.getDesiredAccuracy().intValue());
            } else {
                this.c.setSmallestDisplacement(tSConfig.getGeofenceProximityRadius().longValue() / 2.0f);
                this.c.setInterval(tSConfig.getLocationUpdateInterval().longValue());
                this.c.setMaxWaitTime(0L);
                this.c.setPriority(105);
            }
        }
        return this.c;
    }

    public TSLocation buildTSLocation(Location location) {
        TSLocation tSLocation;
        synchronized (this) {
            g(location);
            tSLocation = new TSLocation(this.a, location, ActivityRecognitionService.getMostProbableActivity(), this.m);
        }
        return tSLocation;
    }

    public void cancelRequest(SingleLocationRequest singleLocationRequest) {
        boolean z;
        if (singleLocationRequest == null) {
            return;
        }
        synchronized (this.b) {
            if (this.b.containsKey(Integer.valueOf(singleLocationRequest.getId()))) {
                this.b.remove(Integer.valueOf(singleLocationRequest.getId()));
                z = true;
            } else {
                z = false;
            }
        }
        if (z) {
            singleLocationRequest.finish();
            singleLocationRequest.onError(singleLocationRequest.didTimeout() ? LOCATION_ERROR_TIMEOUT : LOCATION_ERROR_CANCELLED);
        }
    }

    public void destroy() {
        stopUpdatingLocation();
        stopWatchPosition();
        e();
        EventBus eventBus = EventBus.getDefault();
        if (eventBus.isRegistered(this)) {
            eventBus.unregister(this);
        }
    }

    public void flush() {
        synchronized (this.b) {
            Iterator<Map.Entry<Integer, SingleLocationRequest>> it2 = this.b.entrySet().iterator();
            while (it2.hasNext()) {
                it2.next().getValue().g();
            }
        }
    }

    public LocationProviderChangeEvent getCurrentLocationProvider() {
        return this.m;
    }

    public void getCurrentPosition(SingleLocationRequest singleLocationRequest) {
        register(singleLocationRequest);
        getLastLocation(new a(singleLocationRequest));
    }

    public void getLastGoodLocation(LocationCallback locationCallback) {
        boolean zB;
        synchronized (this.i) {
            zB = b(this.i);
        }
        if (!zB) {
            getLastLocation(locationCallback);
            return;
        }
        Location location = new Location("TSLocationManager");
        synchronized (this.i) {
            location.set(this.i);
        }
        locationCallback.onLocation(location);
    }

    public void getLastLocation(final LocationCallback locationCallback) {
        if (!LocationAuthorization.hasPermission(this.a)) {
            locationCallback.onFailure("Permission failure");
            return;
        }
        try {
            LocationServices.getFusedLocationProviderClient(this.a).getLastLocation().addOnSuccessListener(new OnSuccessListener() { // from class: com.transistorsoft.locationmanager.location.TSLocationManager$$ExternalSyntheticLambda2
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    this.f$0.a(locationCallback, (Location) obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.transistorsoft.locationmanager.location.TSLocationManager$$ExternalSyntheticLambda3
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    this.f$0.a(locationCallback, exc);
                }
            });
        } catch (SecurityException e2) {
            TSLog.logger.error(TSLog.error("SecurityException while attempting to getLastLocation: " + e2.getMessage()));
            locationCallback.onFailure(e2.getMessage());
        }
    }

    public Location getLastOdometerLocation() {
        synchronized (this.j) {
            if (!b(this.j)) {
                return null;
            }
            Location location = new Location("TSLocationManager");
            location.set(this.j);
            return location;
        }
    }

    public SingleLocationRequest getRequest(int i) {
        SingleLocationRequest singleLocationRequest;
        synchronized (this.b) {
            singleLocationRequest = this.b.get(Integer.valueOf(i));
        }
        return singleLocationRequest;
    }

    public Boolean isLocationServicesEnabled() {
        return !LocationAuthorization.hasPermission(this.a) ? Boolean.FALSE : Boolean.valueOf(LocationManagerCompat.isLocationEnabled((LocationManager) this.a.getSystemService("location")));
    }

    public Boolean isUpdatingLocation() {
        return Boolean.valueOf(this.d.get());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onConfigChange(ConfigChangeEvent configChangeEvent) {
        if (this.d.get()) {
            if (configChangeEvent.isDirty("desiredAccuracy") || configChangeEvent.isDirty("distanceFilter") || configChangeEvent.isDirty("locationUpdateInterval") || configChangeEvent.isDirty("fastestLocationUpdateInterval") || configChangeEvent.isDirty("deferTime") || configChangeEvent.isDirty("disableElasticity") || configChangeEvent.isDirty("elasticityMultiplier")) {
                requestLocationUpdates();
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onLocationError(SingleLocationRequest singleLocationRequest) {
        TSLog.logger.warn(TSLog.warn("TSLocationManager received location error: " + singleLocationRequest.getErrorCode()));
        TSConfig tSConfig = TSConfig.getInstance(this.a);
        EventBus.getDefault().post(new LocationErrorEvent(Integer.valueOf(singleLocationRequest.getErrorCode())));
        if (singleLocationRequest.getAction() != 1 || tSConfig.getIsMoving().booleanValue()) {
            return;
        }
        a(new e(singleLocationRequest));
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0121 A[Catch: NullPointerException -> 0x015e, all -> 0x0171, TryCatch #0 {NullPointerException -> 0x015e, blocks: (B:34:0x00cf, B:35:0x00dc, B:37:0x00e2, B:39:0x00ee, B:41:0x00f8, B:42:0x0104, B:46:0x0117, B:48:0x0121, B:49:0x0124, B:43:0x0110, B:50:0x012c, B:54:0x0134, B:56:0x014d, B:58:0x0153), top: B:67:0x00cf, outer: #1 }] */
    public void onLocationResult(LocationResult locationResult) {
        TSLocation tSLocationBuildTSLocation;
        synchronized (this) {
            try {
                TSLog.logger.debug(TSLog.header("Process LocationResult"));
                TSConfig tSConfig = TSConfig.getInstance(this.a);
                if (tSConfig.isLocationTrackingMode() && !tSConfig.getUseSignificantChangesOnly().booleanValue() && !tSConfig.getDisableElasticity().booleanValue() && tSConfig.getDistanceFilter().floatValue() > 0.0f) {
                    List<Location> locations = locationResult.getLocations();
                    Location location = locations.get(locations.size() - 1);
                    if (this.d.get() && location.hasSpeed() && !Float.isNaN(location.getSpeed()) && location.getAccuracy() <= TSConfig.MAXIMUM_LOCATION_ACCURACY.floatValue()) {
                        float fCalculateDistanceFilter = tSConfig.calculateDistanceFilter(location.getSpeed());
                        synchronized (this.c) {
                            if (fCalculateDistanceFilter != this.c.getSmallestDisplacement()) {
                                TSLog.logger.info(TSLog.notice("Re-scaled distanceFilter: " + this.c.getSmallestDisplacement() + "->" + fCalculateDistanceFilter + ")"));
                                this.c.setSmallestDisplacement(fCalculateDistanceFilter);
                                updateLocationRequest();
                            }
                        }
                    }
                }
                if (this.a == null) {
                    TSLog.logger.error(TSLog.warn("Null Context in SingleLocationResultAction"));
                    return;
                }
                try {
                    List<Location> locations2 = locationResult.getLocations();
                    ArrayList arrayList = new ArrayList();
                    for (Location location2 : locations2) {
                        if (e(location2)) {
                            if (tSConfig.getAllowIdenticalLocations().booleanValue()) {
                                TSLog.logger.debug(TSLog.info("Same as last location"));
                                tSLocationBuildTSLocation = buildTSLocation(location2);
                                if (tSConfig.shouldPersist(tSLocationBuildTSLocation)) {
                                    arrayList.add(tSLocationBuildTSLocation);
                                }
                                EventBus.getDefault().post(tSLocationBuildTSLocation);
                            } else {
                                TSLog.logger.debug(TSLog.info("IGNORED: same as last location"));
                            }
                        } else if (!d(location2)) {
                            tSLocationBuildTSLocation = buildTSLocation(location2);
                            if (tSConfig.shouldPersist(tSLocationBuildTSLocation)) {
                                arrayList.add(tSLocationBuildTSLocation);
                            }
                            EventBus.getDefault().post(tSLocationBuildTSLocation);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        return;
                    }
                    TSMediaPlayer.getInstance().debug(this.a, "tslocationmanager_ooooiii3_full_vol");
                    ExecutorService threadPool = BackgroundGeolocation.getThreadPool();
                    if (tSConfig.getPersist().booleanValue() && tSConfig.isLocationTrackingMode()) {
                        threadPool.execute(new h(this.a, arrayList));
                    }
                } catch (NullPointerException e2) {
                    TSLog.logger.error(TSLog.error(e2.getMessage()), (Throwable) e2);
                    e2.printStackTrace();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void onProviderChange(LocationProviderChangeEvent locationProviderChangeEvent) {
        Location location;
        this.m = locationProviderChangeEvent;
        TSConfig tSConfig = TSConfig.getInstance(this.a);
        if (tSConfig.getEnabled().booleanValue()) {
            TSGeofenceManager tSGeofenceManager = TSGeofenceManager.getInstance(this.a);
            if (!locationProviderChangeEvent.isEnabled()) {
                tSGeofenceManager.stopMonitoringStationaryRegion();
            } else if (!tSGeofenceManager.isMonitoringStationaryRegion() && !isUpdatingLocation().booleanValue()) {
                TrackingService.changePace(this.a, tSConfig.getIsMoving().booleanValue(), null);
            }
            if (!locationProviderChangeEvent.isEnabled() || locationProviderChangeEvent.isAirplaneMode()) {
                getLastLocation(new b());
                return;
            }
            if (!locationProviderChangeEvent.isPermissionGranted()) {
                Logger logger = TSLog.logger;
                StringBuilder sb = new StringBuilder();
                sb.append(TSLog.warn("onProviderChange with no location permission -- doing nothing (lastLocation: " + this.h));
                sb.append(")");
                logger.warn(sb.toString());
                return;
            }
            SingleLocationRequest singleLocationRequest = this.g;
            if (singleLocationRequest != null) {
                cancelRequest(singleLocationRequest);
            }
            synchronized (this.h) {
                location = new Location(this.h);
            }
            TSProviderChangeRequest tSProviderChangeRequestBuild = new TSProviderChangeRequest.Builder(this.a).setSamples(3).setCallback(new c(location, tSConfig)).build();
            this.g = tSProviderChangeRequestBuild;
            getCurrentPosition(tSProviderChangeRequestBuild);
        }
    }

    public void onSingleLocationResult(SingleLocationResult singleLocationResult) {
        SingleLocationRequest singleLocationRequest;
        synchronized (this) {
            synchronized (this.b) {
                singleLocationRequest = this.b.get(Integer.valueOf(singleLocationResult.a()));
            }
            if (singleLocationRequest == null) {
                TSLog.logger.warn(TSLog.info("Failed to find SingleLocationRequest.  Request ignored."));
                return;
            }
            locationAge(singleLocationResult.getLocation());
            a(singleLocationRequest.getAction(), singleLocationRequest.getId(), singleLocationResult.getLocation());
            TSConfig tSConfig = TSConfig.getInstance(this.a);
            singleLocationRequest.a(singleLocationResult.getLocation());
            TSGeofenceManager.getInstance(this.a).setLocation(singleLocationResult.getLocation(), tSConfig.getIsMoving().booleanValue());
            if (singleLocationRequest.e()) {
                singleLocationRequest.finish();
                synchronized (this.b) {
                    this.b.remove(Integer.valueOf(singleLocationResult.a()));
                }
                Location bestLocation = singleLocationRequest.getBestLocation();
                Bundle extras = bestLocation.getExtras();
                int i = singleLocationRequest.a;
                if (i == 1) {
                    extras.putString(NotificationCompat.CATEGORY_EVENT, BackgroundGeolocation.EVENT_MOTIONCHANGE);
                    TSLog.logger.info(TSLog.notice("Acquired motionchange position, isMoving: " + tSConfig.getIsMoving()));
                } else if (i == 2) {
                    TSMediaPlayer.getInstance().debug(this.a, "tslocationmanager_ooooiii3_full_vol");
                    TSLog.logger.info(TSLog.notice("Acquired current position"));
                } else if (i == 3) {
                    TSMediaPlayer.getInstance().debug(this.a, "tslocationmanager_ooooiii3_full_vol");
                    TSLog.logger.info(TSLog.notice("Acquired providerchange position"));
                    extras.putString(NotificationCompat.CATEGORY_EVENT, BackgroundGeolocation.EVENT_PROVIDERCHANGE);
                } else if (i == 4) {
                    extras.putBoolean("persist", false);
                }
                TSLocation tSLocationBuildTSLocation = buildTSLocation(bestLocation);
                if (singleLocationRequest.hasExtras()) {
                    tSLocationBuildTSLocation.setExtras(singleLocationRequest.getExtras());
                }
                EventBus.getDefault().post(tSLocationBuildTSLocation);
                if (singleLocationRequest.a == 1) {
                    EventBus.getDefault().post(new MotionChangeEvent(tSLocationBuildTSLocation));
                    if (tSConfig.getIsMoving().booleanValue()) {
                        TSMediaPlayer.getInstance().debug(this.a, "tslocationmanager_chime_short_chord_up");
                        if (tSConfig.isLocationTrackingMode()) {
                            requestLocationUpdates();
                        }
                    } else {
                        TSMediaPlayer.getInstance().debug(this.a, "tslocationmanager_marimba_drop");
                        if (tSConfig.isLocationTrackingMode()) {
                            d();
                        }
                    }
                }
                BackgroundGeolocation.getUiHandler().post(new d(singleLocationRequest, tSLocationBuildTSLocation));
                if (singleLocationRequest.getPersist()) {
                    int i2 = singleLocationRequest.a;
                    boolean z = i2 == 1;
                    if (i2 != 2 && !tSConfig.shouldPersist(tSLocationBuildTSLocation)) {
                    } else {
                        BackgroundGeolocation.getThreadPool().execute(new h(this.a, tSLocationBuildTSLocation, z));
                    }
                }
            } else {
                TSMediaPlayer.getInstance().debug(this.a, "tslocationmanager_click_tap_done_checkbox5_full_vol");
                TSLocation tSLocationBuildTSLocation2 = buildTSLocation(singleLocationResult.getLocation());
                if (singleLocationRequest.hasExtras()) {
                    tSLocationBuildTSLocation2.setExtras(singleLocationRequest.getExtras());
                }
                EventBus.getDefault().post(tSLocationBuildTSLocation2);
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onStopDetection(StopDetectionEvent stopDetectionEvent) {
        if (this.d.get()) {
            synchronized (this.c) {
                this.c.setSmallestDisplacement(TSConfig.getInstance(this.a).getDistanceFilter().floatValue());
                updateLocationRequest();
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onWatchPositionResult(WatchPositionResult watchPositionResult) {
        synchronized (this) {
            TSMediaPlayer.getInstance().debug(this.a, "tslocationmanager_ooooiii3_full_vol");
            if (!this.e.get()) {
                TSWatchPositionRequest tSWatchPositionRequestBuild = new TSWatchPositionRequest.Builder(this.a).build();
                this.f = tSWatchPositionRequestBuild;
                tSWatchPositionRequestBuild.a(watchPositionResult.getRequestId());
                stopWatchPosition();
                TSLog.logger.warn(TSLog.warn("onWatchPositionResult:  watchPositionRequest is null"));
                return;
            }
            a(this.f.getAction(), watchPositionResult.getRequestId(), watchPositionResult.getLocation());
            TSLocation tSLocationBuildTSLocation = buildTSLocation(watchPositionResult.getLocation());
            if (this.f.hasExtras()) {
                tSLocationBuildTSLocation.setExtras(this.f.getExtras());
            }
            if (this.f.getPersist()) {
                BackgroundGeolocation.getThreadPool().execute(new h(this.a, tSLocationBuildTSLocation));
            }
            this.f.onSuccess(tSLocationBuildTSLocation);
            EventBus.getDefault().post(tSLocationBuildTSLocation);
        }
    }

    public void register(SingleLocationRequest singleLocationRequest) {
        synchronized (this.b) {
            this.b.put(Integer.valueOf(singleLocationRequest.getId()), singleLocationRequest);
        }
    }

    public void requestLocationUpdates() {
        if (this.d.get()) {
            d();
        }
        if (TSConfig.getInstance(this.a).getEnabled().booleanValue() && Settings.isValid(this.a)) {
            TSLog.logger.info(TSLog.on("Location-services: ON"));
            try {
                LocationServices.getFusedLocationProviderClient(this.a).requestLocationUpdates(buildLocationRequest(), TrackingService.getPendingIntent(this.a));
                this.d.set(true);
            } catch (SecurityException e2) {
                TSLog.logger.error(TSLog.error("SecurityException while attempting to requestLocationUpdates: " + e2.getMessage()), (Throwable) e2);
            }
        }
    }

    public void setOdometer(Float f2, final TSLocationCallback tSLocationCallback) {
        boolean zB;
        TSConfig tSConfig = TSConfig.getInstance(this.a);
        tSConfig.setOdometer(f2);
        TSLog.logger.info(TSLog.info("setOdometer: " + f2 + ", isMoving: " + tSConfig.getIsMoving()));
        synchronized (this.j) {
            zB = b(this.j);
        }
        if (tSConfig.getIsMoving().booleanValue() || !zB) {
            a();
            getCurrentPosition(new TSCurrentPositionRequest.Builder(this.a).setCallback(tSLocationCallback).setPersist(false).setDesiredAccuracy(tSConfig.getDesiredOdometerAccuracy().intValue()).setSamples(3).build());
            return;
        }
        Location location = new Location("TSLocationManager");
        synchronized (this.j) {
            location.set(this.j);
        }
        final TSLocation tSLocation = new TSLocation(this.a, location, ActivityRecognitionService.getMostProbableActivity());
        BackgroundGeolocation.getUiHandler().post(new Runnable() { // from class: com.transistorsoft.locationmanager.location.TSLocationManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                tSLocationCallback.onLocation(tSLocation);
            }
        });
    }

    public void stop() {
        stopUpdatingLocation();
        a();
    }

    public void stopUpdatingLocation() {
        d();
    }

    public void stopWatchPosition() {
        if (this.e.compareAndSet(true, false)) {
            TSLog.logger.info(TSLog.off("watchPosition: OFF"));
        }
        TSWatchPositionRequest tSWatchPositionRequest = this.f;
        if (tSWatchPositionRequest != null) {
            tSWatchPositionRequest.h();
        }
    }

    public void updateLocationRequest() {
        if (!this.d.get()) {
            TSLog.logger.warn(TSLog.warn("Attempt to refreshLocationUpdates when not updating location"));
            return;
        }
        FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this.a);
        try {
            PendingIntent pendingIntent = TrackingService.getPendingIntent(this.a);
            fusedLocationProviderClient.removeLocationUpdates(pendingIntent);
            synchronized (this.c) {
                try {
                    fusedLocationProviderClient.requestLocationUpdates(this.c, pendingIntent);
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (SecurityException e2) {
            TSLog.logger.error(TSLog.error("SecurityException while attempting to updateLocationRequest: " + e2.getMessage()), (Throwable) e2);
        }
    }

    public void watchPosition(TSWatchPositionRequest tSWatchPositionRequest) {
        TSWatchPositionRequest tSWatchPositionRequest2;
        TSLog.logger.info(TSLog.on("watchPosition: ON"));
        if (this.e.get() && (tSWatchPositionRequest2 = this.f) != null) {
            tSWatchPositionRequest2.h();
        }
        this.e.set(true);
        this.f = tSWatchPositionRequest;
        tSWatchPositionRequest.g();
    }

    private static TSLocationManager a(Context context) {
        TSLocationManager tSLocationManager;
        synchronized (TSLocationManager.class) {
            if (f117n == null) {
                f117n = new TSLocationManager(context.getApplicationContext());
            }
            tSLocationManager = f117n;
        }
        return tSLocationManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        SharedPreferences sharedPreferences = this.a.getSharedPreferences(TSLocationManager.class.getSimpleName(), 0);
        if (sharedPreferences.contains(p) && sharedPreferences.contains(q)) {
            double dLongBitsToDouble = Double.longBitsToDouble(sharedPreferences.getLong(p, 0L));
            double dLongBitsToDouble2 = Double.longBitsToDouble(sharedPreferences.getLong(q, 0L));
            if (dLongBitsToDouble == 0.0d || dLongBitsToDouble2 == 0.0d) {
                return;
            }
            Location location = new Location("TSLocationManager");
            location.setLatitude(dLongBitsToDouble);
            location.setLongitude(dLongBitsToDouble2);
            location.setAccuracy(sharedPreferences.getFloat(r, 0.0f));
            TSConfig tSConfig = TSConfig.getInstance(this.a);
            Bundle extras = location.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            extras.putFloat(TSLocation.LOCATION_OPTIONS_ODOMETER, tSConfig.getOdometer().floatValue());
            location.setExtras(extras);
            TSLog.logger.debug(TSLog.info("Load last odometer location: " + location));
            synchronized (this.j) {
                this.j.set(location);
            }
        }
    }

    private void c(Location location) {
        synchronized (this.j) {
            if (!b(this.j)) {
                f(location);
                return;
            }
            float fDistanceTo = location.distanceTo(this.j);
            if (fDistanceTo < (location.getAccuracy() + this.j.getAccuracy()) / 2.0f) {
                return;
            }
            Float fIncrementOdometer = TSConfig.getInstance(this.a).incrementOdometer(Float.valueOf(fDistanceTo));
            TSLog.logger.debug("Odometer: " + fIncrementOdometer);
            f(location);
        }
    }

    public static long elapsedTimeMillis(Location location, Location location2) {
        return (location.getElapsedRealtimeNanos() - location2.getElapsedRealtimeNanos()) / AnimationKt.MillisToNanos;
    }

    public static long locationAge(Location location) {
        return (SystemClock.elapsedRealtimeNanos() - location.getElapsedRealtimeNanos()) / AnimationKt.MillisToNanos;
    }

    static Location a(Location location) {
        Location location2 = new Location(location);
        location2.setTime(System.currentTimeMillis());
        location2.setElapsedRealtimeNanos(SystemClock.elapsedRealtimeNanos());
        location2.setExtras(new Bundle());
        return location2;
    }

    static class h implements Runnable {
        private final WeakReference<Context> a;
        private TSLocation b;
        private List<TSLocation> c;
        private boolean d;

        h(Context context, TSLocation tSLocation) {
            this.d = false;
            this.a = new WeakReference<>(context);
            this.b = tSLocation;
        }

        private void a() {
            JSONObject params = TSConfig.getInstance(this.a.get()).getParams();
            if (this.b != null) {
                EventBus.getDefault().post(new PersistEvent(this.a.get(), this.b, params));
                return;
            }
            List<TSLocation> list = this.c;
            if (list != null) {
                Iterator<TSLocation> it2 = list.iterator();
                while (it2.hasNext()) {
                    EventBus.getDefault().post(new PersistEvent(this.a.get(), it2.next(), params));
                }
            }
        }

        private void b() {
            TSConfig tSConfig = TSConfig.getInstance(this.a.get());
            SQLiteLocationDAO sQLiteLocationDAO = SQLiteLocationDAO.getInstance(this.a.get());
            TSLocation tSLocation = this.b;
            if (tSLocation != null) {
                sQLiteLocationDAO.persist(tSLocation);
            } else {
                List<TSLocation> list = this.c;
                if (list != null) {
                    Iterator<TSLocation> it2 = list.iterator();
                    while (it2.hasNext()) {
                        sQLiteLocationDAO.persist(it2.next());
                    }
                }
            }
            if (tSConfig.getAutoSync().booleanValue() && tSConfig.hasUrl()) {
                Integer autoSyncThreshold = tSConfig.getAutoSyncThreshold();
                if (autoSyncThreshold.intValue() <= 0 || this.d || sQLiteLocationDAO.count() >= autoSyncThreshold.intValue()) {
                    HttpService.getInstance(this.a.get()).flush(this.d);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.get() == null) {
                TSLog.logger.error(TSLog.warn("Null Context in PersistTask"));
                return;
            }
            if (!EventBus.getDefault().hasSubscriberForEvent(PersistEvent.class)) {
                b();
            } else if (TSPlugin.getInstance().canUsePersistEvent(this.a.get())) {
                a();
            } else {
                TSLog.logger.warn(TSLog.warn("Failed to persist location"));
            }
        }

        h(Context context, TSLocation tSLocation, boolean z) {
            this.d = false;
            this.a = new WeakReference<>(context);
            this.d = z;
            this.b = tSLocation;
        }

        h(Context context, List<TSLocation> list) {
            this.d = false;
            this.a = new WeakReference<>(context);
            this.c = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(LocationCallback locationCallback, Location location) {
        if (location != null) {
            location.setExtras(new Bundle());
            synchronized (this.h) {
                if (!b(this.h)) {
                    this.h.set(TSLocation.applyExtras(this.a, location));
                }
            }
            locationCallback.onLocation(location);
            return;
        }
        synchronized (this.h) {
            if (b(this.h)) {
                location = new Location("TSLocationManager");
                location.set(this.h);
            }
        }
        if (location != null) {
            locationCallback.onLocation(location);
        } else {
            TSLog.logger.warn(TSLog.error("Could not fetch last location"));
            locationCallback.onFailure("Could not fetch last location");
        }
    }

    private boolean d(Location location) {
        synchronized (this.h) {
            if (!b(this.h)) {
                return false;
            }
            float fSpeedBetween = speedBetween(location, this.h);
            float fDistanceTo = this.h.distanceTo(location);
            float fElapsedTimeMillis = elapsedTimeMillis(location, this.h);
            if (fDistanceTo < location.getAccuracy()) {
                return false;
            }
            TSLog.logger.debug("Distance from last location: " + fDistanceTo + ", apparent speed: " + fSpeedBetween);
            if (fSpeedBetween <= TSConfig.getInstance(this.a).getSpeedJumpFilter().intValue()) {
                return false;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(TSLog.warn("Detected invalid location (teleport) with apparent speed of " + fSpeedBetween + " meters/s (distance from last location: " + fDistanceTo + " meters, dt: " + fElapsedTimeMillis + ")"));
            if (!location.isFromMockProvider() && !this.h.isFromMockProvider()) {
                TSLog.logger.warn(stringBuffer.toString());
                return true;
            }
            stringBuffer.append(TSLog.warn("However, location mocking is detected.  Normally, this location would be ignored as an anomaly."));
            TSLog.logger.warn(stringBuffer.toString());
            return false;
        }
    }

    public void cancelRequest(int i) {
        SingleLocationRequest request = getRequest(i);
        if (request != null) {
            cancelRequest(request);
        }
    }

    private boolean e(Location location) {
        synchronized (this.h) {
            if (!b(this.h)) {
                return false;
            }
            if (this.h.getTime() == location.getTime() && this.h.getLatitude() == location.getLatitude() && this.h.getLongitude() == location.getLongitude()) {
                return true;
            }
            return location.getLatitude() == this.h.getLatitude() && location.getLongitude() == this.h.getLongitude() && location.getSpeed() == this.h.getSpeed() && location.getBearing() == this.h.getBearing();
        }
    }

    private void c() {
        BackgroundGeolocation.getThreadPool().execute(new Runnable() { // from class: com.transistorsoft.locationmanager.location.TSLocationManager$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b();
            }
        });
    }

    private boolean b(Location location) {
        return location.getTime() != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(LocationCallback locationCallback, Exception exc) {
        Location location;
        TSLog.logger.warn(TSLog.error(exc.getMessage()));
        synchronized (this.h) {
            if (b(this.h)) {
                location = new Location("TSLocationManager");
                location.set(this.h);
            } else {
                location = null;
            }
        }
        if (location != null) {
            locationCallback.onLocation(location);
        } else {
            locationCallback.onFailure("Could not fetch last location");
        }
    }

    private void a(int i, int i2, Location location) {
        String str;
        long jLocationAge = locationAge(location);
        StringBuffer stringBuffer = new StringBuffer();
        if (i == 1) {
            str = BackgroundGeolocation.EVENT_MOTIONCHANGE;
        } else if (i == 2) {
            str = BackgroundGeolocation.ACTION_GET_CURRENT_POSITION;
        } else if (i == 3) {
            str = BackgroundGeolocation.EVENT_PROVIDERCHANGE;
        } else if (i != 5) {
            str = "SingleLocationResult";
        } else {
            str = BackgroundGeolocation.ACTION_WATCH_POSITION;
        }
        stringBuffer.append(TSLog.header(str + " LocationResult: " + i2 + " (" + jLocationAge + "ms old)"));
        StringBuilder sb = new StringBuilder();
        sb.append(TSLog.ICON_PIN);
        sb.append(location);
        sb.append(", time: ");
        sb.append(location.getTime());
        stringBuffer.append(TSLog.boxRow(sb.toString()));
        TSLog.logger.info(stringBuffer.toString());
    }

    private void a(LocationCallback locationCallback) {
        getLastLocation(new f(locationCallback));
    }

    private void a(float f2) {
        synchronized (this.k) {
            this.k.add(Float.valueOf(f2));
            if (this.k.size() > 11) {
                this.k.remove(0);
            }
            ArrayList arrayList = new ArrayList(this.k);
            Collections.sort(arrayList, new g());
            int size = arrayList.size() / 2;
            if (arrayList.size() == 1) {
                this.l = ((Float) arrayList.get(0)).floatValue();
            } else if (arrayList.size() % 2 > 0) {
                this.l = ((Float) arrayList.get(size)).floatValue();
            } else {
                this.l = (((Float) arrayList.get(size)).floatValue() + ((Float) arrayList.get(size - 1)).floatValue()) / 2.0f;
            }
            TSLog.logger.debug("Median accuracy: " + this.l);
        }
    }

    private void a() {
        TSLog.logger.debug(TSLog.info("Clear last odometer location"));
        synchronized (this.j) {
            this.j.reset();
        }
        SharedPreferences.Editor editorEdit = this.a.getSharedPreferences(getClass().getSimpleName(), 0).edit();
        editorEdit.remove(p);
        editorEdit.remove(q);
        editorEdit.remove(r);
        editorEdit.apply();
    }

    private void a(Integer num) {
        TSLog.logger.warn(TSLog.warn("Location error: " + num));
        new LocationErrorEvent(num);
    }
}
