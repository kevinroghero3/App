package com.transistorsoft.locationmanager.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.location.ActivityTransitionEvent;
import com.google.common.base.Ascii;
import com.intentfilter.androidpermissions.PermissionManager;
import com.intentfilter.androidpermissions.models.DeniedPermissions;
import com.transistorsoft.locationmanager.activity.TSLocationManagerActivity;
import com.transistorsoft.locationmanager.adapter.callback.TSActivityChangeCallback;
import com.transistorsoft.locationmanager.adapter.callback.TSBackgroundTaskCallback;
import com.transistorsoft.locationmanager.adapter.callback.TSBeforeInsertBlock;
import com.transistorsoft.locationmanager.adapter.callback.TSCallback;
import com.transistorsoft.locationmanager.adapter.callback.TSConnectivityChangeCallback;
import com.transistorsoft.locationmanager.adapter.callback.TSEmailLogCallback;
import com.transistorsoft.locationmanager.adapter.callback.TSEnabledChangeCallback;
import com.transistorsoft.locationmanager.adapter.callback.TSGeofenceCallback;
import com.transistorsoft.locationmanager.adapter.callback.TSGeofenceExistsCallback;
import com.transistorsoft.locationmanager.adapter.callback.TSGeofencesChangeCallback;
import com.transistorsoft.locationmanager.adapter.callback.TSGetCountCallback;
import com.transistorsoft.locationmanager.adapter.callback.TSGetGeofenceCallback;
import com.transistorsoft.locationmanager.adapter.callback.TSGetGeofencesCallback;
import com.transistorsoft.locationmanager.adapter.callback.TSGetLocationsCallback;
import com.transistorsoft.locationmanager.adapter.callback.TSGetLogCallback;
import com.transistorsoft.locationmanager.adapter.callback.TSHasGeofenceCallback;
import com.transistorsoft.locationmanager.adapter.callback.TSHeartbeatCallback;
import com.transistorsoft.locationmanager.adapter.callback.TSHttpResponseCallback;
import com.transistorsoft.locationmanager.adapter.callback.TSInsertLocationCallback;
import com.transistorsoft.locationmanager.adapter.callback.TSLocationCallback;
import com.transistorsoft.locationmanager.adapter.callback.TSLocationProviderChangeCallback;
import com.transistorsoft.locationmanager.adapter.callback.TSNotificationActionCallback;
import com.transistorsoft.locationmanager.adapter.callback.TSPlayServicesConnectErrorCallback;
import com.transistorsoft.locationmanager.adapter.callback.TSPowerSaveChangeCallback;
import com.transistorsoft.locationmanager.adapter.callback.TSRequestPermissionCallback;
import com.transistorsoft.locationmanager.adapter.callback.TSScheduleCallback;
import com.transistorsoft.locationmanager.adapter.callback.TSSecurityExceptionCallback;
import com.transistorsoft.locationmanager.adapter.callback.TSSyncCallback;
import com.transistorsoft.locationmanager.data.LocationModel;
import com.transistorsoft.locationmanager.data.SQLQuery;
import com.transistorsoft.locationmanager.data.sqlite.GeofenceDAO;
import com.transistorsoft.locationmanager.data.sqlite.SQLiteLocationDAO;
import com.transistorsoft.locationmanager.device.DeviceSettings;
import com.transistorsoft.locationmanager.device.DeviceSettingsRequest;
import com.transistorsoft.locationmanager.event.ActivityChangeEvent;
import com.transistorsoft.locationmanager.event.ConnectivityChangeEvent;
import com.transistorsoft.locationmanager.event.GeofenceEvent;
import com.transistorsoft.locationmanager.event.HeadlessEvent;
import com.transistorsoft.locationmanager.event.HeartbeatEvent;
import com.transistorsoft.locationmanager.event.LocationErrorEvent;
import com.transistorsoft.locationmanager.event.LocationProviderChangeEvent;
import com.transistorsoft.locationmanager.event.MotionChangeEvent;
import com.transistorsoft.locationmanager.event.PersistEvent;
import com.transistorsoft.locationmanager.event.PowerSaveModeChangeEvent;
import com.transistorsoft.locationmanager.event.SecurityExceptionEvent;
import com.transistorsoft.locationmanager.event.SettingsFailureEvent;
import com.transistorsoft.locationmanager.event.TemplateErrorEvent;
import com.transistorsoft.locationmanager.event.TerminateEvent;
import com.transistorsoft.locationmanager.geofence.TSGeofence;
import com.transistorsoft.locationmanager.geofence.TSGeofenceManager;
import com.transistorsoft.locationmanager.http.HttpResponse;
import com.transistorsoft.locationmanager.http.HttpService;
import com.transistorsoft.locationmanager.lifecycle.LifecycleManager;
import com.transistorsoft.locationmanager.location.TSCurrentPositionRequest;
import com.transistorsoft.locationmanager.location.TSLocation;
import com.transistorsoft.locationmanager.location.TSLocationManager;
import com.transistorsoft.locationmanager.location.TSWatchPositionRequest;
import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.locationmanager.logger.TSLogReader;
import com.transistorsoft.locationmanager.logger.TSMediaPlayer;
import com.transistorsoft.locationmanager.plugin.TSPlugin;
import com.transistorsoft.locationmanager.provider.TSProviderManager;
import com.transistorsoft.locationmanager.scheduler.ScheduleEvent;
import com.transistorsoft.locationmanager.scheduler.TSScheduleManager;
import com.transistorsoft.locationmanager.service.ActivityRecognitionService;
import com.transistorsoft.locationmanager.service.GeofencingService;
import com.transistorsoft.locationmanager.service.HeartbeatService;
import com.transistorsoft.locationmanager.service.TrackingService;
import com.transistorsoft.locationmanager.settings.Settings;
import com.transistorsoft.locationmanager.util.BackgroundTaskManager;
import com.transistorsoft.locationmanager.util.HeadlessEventBroadcaster;
import com.transistorsoft.locationmanager.util.LocationAuthorization;
import com.transistorsoft.locationmanager.util.Sensors;
import com.transistorsoft.locationmanager.util.TSNotification;
import com.transistorsoft.rnbackgroundgeolocation.RNBackgroundGeolocationModule;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import o.ArtificialStackFrames;
import o.extraCallback;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BackgroundGeolocation {
    public static final String ACTION_ADD_GEOFENCE = "addGeofence";
    public static final String ACTION_ADD_GEOFENCES = "addGeofences";
    public static final String ACTION_CHANGE_PACE = "changePace";
    public static final String ACTION_CLEAR_DATABASE = "clearDatabase";
    public static final String ACTION_DESTROY_LOCATION = "destroyLocation";
    public static final String ACTION_DESTROY_LOCATIONS = "destroyLocations";
    public static final String ACTION_DESTROY_LOG = "destroyLog";
    public static final String ACTION_FINISH = "finish";
    public static final String ACTION_GEOFENCE_EXISTS = "geofenceExists";
    public static final String ACTION_GET_COUNT = "getCount";
    public static final String ACTION_GET_CURRENT_POSITION = "getCurrentPosition";
    public static final String ACTION_GET_GEOFENCE = "getGeofence";
    public static final String ACTION_GET_GEOFENCES = "getGeofences";
    public static final String ACTION_GET_LOCATIONS = "getLocations";
    public static final String ACTION_GET_ODOMETER = "getOdometer";
    public static final String ACTION_GET_PROVIDER_STATE = "getProviderState";
    public static final String ACTION_GET_SENSORS = "getSensors";
    public static final String ACTION_GOOGLE_PLAY_SERVICES_CONNECT_ERROR = "googlePlayServiceConnectError";
    public static final String ACTION_HEARTBEAT = "heartbeat";
    public static final String ACTION_HTTP_RESPONSE = "http";
    public static final String ACTION_INSERT_LOCATION = "insertLocation";
    public static final String ACTION_IS_IGNORING_BATTERY_OPTIMIZATIONS = "isIgnoringBatteryOptimizations";
    public static final String ACTION_IS_POWER_SAVE_MODE = "isPowerSaveMode";
    public static final String ACTION_LOCATION_ERROR = "locationError";
    public static final String ACTION_ON_GEOFENCE = "onGeofence";
    public static final String ACTION_ON_MOTION_CHANGE = "onMotionChange";
    public static final String ACTION_PLAY_SOUND = "playSound";
    public static final String ACTION_REMOVE_GEOFENCE = "removeGeofence";
    public static final String ACTION_REMOVE_GEOFENCES = "removeGeofences";
    public static final String ACTION_REMOVE_LISTENER = "removeListener";
    public static final String ACTION_REQUEST_PERMISSION = "requestPermission";
    public static final String ACTION_RESET_ODOMETER = "resetOdometer";
    public static final String ACTION_SCHEDULE = "schedule";
    public static final String ACTION_SET_CONFIG = "setConfig";
    public static final String ACTION_SET_NOTIFICATION = "setNotification";
    public static final String ACTION_SET_ODOMETER = "setOdometer";
    public static final String ACTION_SHOW_SETTINGS = "showSettings";
    public static final String ACTION_START = "start";
    public static final String ACTION_START_BACKGROUND_TASK = "startBackgroundTask";
    public static final String ACTION_START_GEOFENCES = "startGeofences";
    public static final String ACTION_START_ON_BOOT = "startOnBoot";
    public static final String ACTION_START_SCHEDULE = "startSchedule";
    public static final String ACTION_STOP = "stop";
    public static final String ACTION_STOP_BACKGROUND_TASK = "stopBackgroundTask";
    public static final String ACTION_STOP_SCHEDULE = "stopSchedule";
    public static final String ACTION_STOP_WATCH_POSITION = "stopWatchPosition";
    public static final String ACTION_SYNC = "sync";
    public static final String ACTION_WATCH_POSITION = "watchPosition";
    public static final String EVENT_ACTIVITYCHANGE = "activitychange";
    public static final String EVENT_AUTHORIZATION = "authorization";
    public static final String EVENT_BOOT = "boot";
    public static final String EVENT_CONNECTIVITYCHANGE = "connectivitychange";
    public static final String EVENT_ENABLEDCHANGE = "enabledchange";
    public static final String EVENT_ERROR = "error";
    public static final String EVENT_GEOFENCE = "geofence";
    public static final String EVENT_GEOFENCESCHANGE = "geofenceschange";
    public static final String EVENT_GEOFENCES_CHANGE = "geofenceschange";
    public static final String EVENT_HEARTBEAT = "heartbeat";
    public static final String EVENT_HTTP = "http";
    public static final String EVENT_LOCATION = "location";
    public static final String EVENT_MOTIONCHANGE = "motionchange";
    public static final String EVENT_NOTIFICATIONACTION = "notificationaction";
    public static final String EVENT_PLAY_SERVICES_CONNECT_ERROR = "playservicesconnecterror";
    public static final String EVENT_POWERSAVECHANGE = "powersavechange";
    public static final String EVENT_PROVIDERCHANGE = "providerchange";
    public static final String EVENT_SCHEDULE = "schedule";
    public static final String EVENT_SECURITY_EXCEPTION = "securityexception";
    public static final String EVENT_TERMINATE = "terminate";
    public static final int FORCE_RELOAD_BOOT = 6;
    public static final int FORCE_RELOAD_GEOFENCE = 3;
    public static final int FORCE_RELOAD_HEARTBEAT = 4;
    public static final int FORCE_RELOAD_LOCATION_CHANGE = 1;
    public static final int FORCE_RELOAD_MOTION_CHANGE = 2;
    public static final int FORCE_RELOAD_SCHEDULE = 5;
    public static final String TAG = "TSLocationManager";
    private static final String a = "mainActivityInactive";
    private static BackgroundGeolocation b;
    private static final ExecutorService c = Executors.newCachedThreadPool();
    private static Handler d;
    private LocationProviderChangeEvent f;
    private final Context g;
    private Activity h;
    private Z l;
    private final int e = 0;
    private final AtomicBoolean i = new AtomicBoolean(false);
    private final AtomicBoolean j = new AtomicBoolean(false);
    private final AtomicBoolean k = new AtomicBoolean(false);
    private final List<TSLocationCallback> m = new ArrayList();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final List<TSLocationCallback> f97n = new ArrayList();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final List<TSGeofenceCallback> f98o = new ArrayList();
    private final List<TSEnabledChangeCallback> p = new ArrayList();
    private final List<TSConnectivityChangeCallback> q = new ArrayList();
    private final List<TSHttpResponseCallback> r = new ArrayList();
    private final List<TSHeartbeatCallback> s = new ArrayList();
    private final List<TSActivityChangeCallback> t = new ArrayList();
    private final List<TSPowerSaveChangeCallback> u = new ArrayList();
    private final List<TSLocationProviderChangeCallback> v = new ArrayList();
    private final List<TSScheduleCallback> w = new ArrayList();
    private final List<TSPlayServicesConnectErrorCallback> x = new ArrayList();
    private final List<TSSecurityExceptionCallback> y = new ArrayList();
    private final List<TSNotificationActionCallback> z = new ArrayList();
    private final List<GeofenceEvent> A = new ArrayList();
    private final List<TSCurrentPositionRequest> B = new ArrayList();

    class A implements PermissionManager.PermissionRequestListener {
        final /* synthetic */ TSRequestPermissionCallback a;

        A(TSRequestPermissionCallback tSRequestPermissionCallback) {
            this.a = tSRequestPermissionCallback;
        }

        @Override // com.intentfilter.androidpermissions.PermissionManager.PermissionRequestListener
        public void onPermissionDenied(DeniedPermissions deniedPermissions) {
            this.a.onFailure(TSProviderManager.ACCURACY_AUTHORIZATION_REDUCED);
        }

        @Override // com.intentfilter.androidpermissions.PermissionManager.PermissionRequestListener
        public void onPermissionGranted() {
            TrackingService.changePace(BackgroundGeolocation.this.g, TSConfig.getInstance(BackgroundGeolocation.this.g).getIsMoving().booleanValue(), null);
            BackgroundGeolocation backgroundGeolocation = BackgroundGeolocation.this;
            backgroundGeolocation.a(new LocationProviderChangeEvent(backgroundGeolocation.g));
            this.a.onSuccess(TSProviderManager.ACCURACY_AUTHORIZATION_FULL);
        }
    }

    class B implements Runnable {
        final /* synthetic */ int a;

        B(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (BackgroundGeolocation.this.x) {
                Iterator it2 = BackgroundGeolocation.this.x.iterator();
                while (it2.hasNext()) {
                    ((TSPlayServicesConnectErrorCallback) it2.next()).onPlayServicesConnectError(this.a);
                }
            }
        }
    }

    class C implements Runnable {
        final /* synthetic */ ScheduleEvent a;

        C(ScheduleEvent scheduleEvent) {
            this.a = scheduleEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (BackgroundGeolocation.this.w) {
                Iterator it2 = BackgroundGeolocation.this.w.iterator();
                while (it2.hasNext()) {
                    ((TSScheduleCallback) it2.next()).onSchedule(this.a);
                }
            }
        }
    }

    public class ChangePaceTask implements Runnable {
        private final Boolean a;
        private final TSCallback b;

        /* JADX INFO: loaded from: classes3.dex */
        class a implements TSLocationCallback {

            /* JADX INFO: renamed from: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation$ChangePaceTask$a$a, reason: collision with other inner class name */
            class RunnableC0120a implements Runnable {
                RunnableC0120a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    ChangePaceTask.this.b.onSuccess();
                }
            }

            class b implements Runnable {
                final /* synthetic */ Integer a;

                b(Integer num) {
                    this.a = num;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ChangePaceTask.this.b.onFailure(this.a.toString());
                }
            }

            a() {
            }

            @Override // com.transistorsoft.locationmanager.adapter.callback.TSLocationCallback
            public void onError(Integer num) {
                BackgroundGeolocation.getUiHandler().post(new b(num));
            }

            @Override // com.transistorsoft.locationmanager.adapter.callback.TSLocationCallback
            public void onLocation(TSLocation tSLocation) {
                BackgroundGeolocation.getUiHandler().post(new RunnableC0120a());
            }
        }

        ChangePaceTask(boolean z, TSCallback tSCallback) {
            this.a = Boolean.valueOf(z);
            this.b = tSCallback;
        }

        public TSCallback getCallback() {
            return this.b;
        }

        public Boolean getIsMoving() {
            return this.a;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = new a();
            if (TSConfig.getInstance(BackgroundGeolocation.this.g).isLocationTrackingMode()) {
                TrackingService.changePace(BackgroundGeolocation.this.g, this.a.booleanValue(), aVar);
            } else {
                GeofencingService.changePace(BackgroundGeolocation.this.g, this.a.booleanValue(), aVar);
            }
        }
    }

    class D implements Runnable {
        final /* synthetic */ ActivityTransitionEvent a;

        D(ActivityTransitionEvent activityTransitionEvent) {
            this.a = activityTransitionEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityChangeEvent activityChangeEvent = new ActivityChangeEvent(this.a);
            synchronized (BackgroundGeolocation.this.t) {
                Iterator it2 = BackgroundGeolocation.this.t.iterator();
                while (it2.hasNext()) {
                    ((TSActivityChangeCallback) it2.next()).onActivityChange(activityChangeEvent);
                }
            }
        }
    }

    class E implements Runnable {
        final /* synthetic */ TSLocation a;

        E(TSLocation tSLocation) {
            this.a = tSLocation;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (BackgroundGeolocation.this.m) {
                Iterator it2 = BackgroundGeolocation.this.m.iterator();
                while (it2.hasNext()) {
                    ((TSLocationCallback) it2.next()).onLocation(this.a);
                }
            }
        }
    }

    class F implements Runnable {
        final /* synthetic */ int a;

        F(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (BackgroundGeolocation.this.m) {
                Iterator it2 = BackgroundGeolocation.this.m.iterator();
                while (it2.hasNext()) {
                    ((TSLocationCallback) it2.next()).onError(Integer.valueOf(this.a));
                }
            }
        }
    }

    class G implements TSConfig.OnChangeCallback {
        G() {
        }

        @Override // com.transistorsoft.locationmanager.adapter.TSConfig.OnChangeCallback
        public void onChange(TSConfig tSConfig) {
            TSLocation.resetLocationTemplate();
        }
    }

    class H implements Runnable {
        final /* synthetic */ String a;

        H(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (BackgroundGeolocation.this.z) {
                Iterator it2 = BackgroundGeolocation.this.z.iterator();
                while (it2.hasNext()) {
                    ((TSNotificationActionCallback) it2.next()).onClick(this.a);
                }
            }
        }
    }

    class I implements Runnable {
        final /* synthetic */ LocationProviderChangeEvent a;

        I(LocationProviderChangeEvent locationProviderChangeEvent) {
            this.a = locationProviderChangeEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (BackgroundGeolocation.this.v) {
                Iterator it2 = BackgroundGeolocation.this.v.iterator();
                while (it2.hasNext()) {
                    ((TSLocationProviderChangeCallback) it2.next()).onLocationProviderChange(this.a);
                }
            }
        }
    }

    class J implements Runnable {
        final /* synthetic */ HeartbeatEvent a;

        J(HeartbeatEvent heartbeatEvent) {
            this.a = heartbeatEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (BackgroundGeolocation.this.s) {
                Iterator it2 = BackgroundGeolocation.this.s.iterator();
                while (it2.hasNext()) {
                    ((TSHeartbeatCallback) it2.next()).onHeartbeat(this.a);
                }
            }
        }
    }

    class K implements Runnable {
        final /* synthetic */ GeofenceEvent a;

        K(GeofenceEvent geofenceEvent) {
            this.a = geofenceEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (BackgroundGeolocation.this.f98o) {
                Iterator it2 = BackgroundGeolocation.this.f98o.iterator();
                while (it2.hasNext()) {
                    ((TSGeofenceCallback) it2.next()).onGeofence(this.a);
                }
            }
        }
    }

    class L implements Runnable {
        final /* synthetic */ MotionChangeEvent a;

        L(MotionChangeEvent motionChangeEvent) {
            this.a = motionChangeEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (BackgroundGeolocation.this.f97n) {
                Iterator it2 = BackgroundGeolocation.this.f97n.iterator();
                while (it2.hasNext()) {
                    ((TSLocationCallback) it2.next()).onLocation(this.a.getLocation());
                }
            }
        }
    }

    class M implements TSConfig.OnChangeCallback {
        M() {
        }

        @Override // com.transistorsoft.locationmanager.adapter.TSConfig.OnChangeCallback
        public void onChange(TSConfig tSConfig) {
            if (!tSConfig.getEnabled().booleanValue() || tSConfig.getIsMoving().booleanValue()) {
                return;
            }
            HeartbeatService.start(BackgroundGeolocation.this.g);
        }
    }

    class N implements TSConfig.OnChangeCallback {
        N() {
        }

        @Override // com.transistorsoft.locationmanager.adapter.TSConfig.OnChangeCallback
        public void onChange(TSConfig tSConfig) {
            if (tSConfig.getEnabled().booleanValue()) {
                ActivityRecognitionService.start(BackgroundGeolocation.this.g);
            }
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    class O implements TSConfig.OnChangeCallback {

        class a implements PermissionManager.PermissionRequestListener {
            a() {
            }

            @Override // com.intentfilter.androidpermissions.PermissionManager.PermissionRequestListener
            public void onPermissionDenied(DeniedPermissions deniedPermissions) {
            }

            @Override // com.intentfilter.androidpermissions.PermissionManager.PermissionRequestListener
            public void onPermissionGranted() {
            }
        }

        O() {
        }

        @Override // com.transistorsoft.locationmanager.adapter.TSConfig.OnChangeCallback
        public void onChange(TSConfig tSConfig) {
            if (tSConfig.getEnabled().booleanValue() && BackgroundGeolocation.this.i.get()) {
                LocationAuthorization.withBackgroundPermission(BackgroundGeolocation.this.g, new a());
            }
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    class P implements TSConfig.OnChangeCallback {

        class a implements PermissionManager.PermissionRequestListener {
            a() {
            }

            @Override // com.intentfilter.androidpermissions.PermissionManager.PermissionRequestListener
            public void onPermissionDenied(DeniedPermissions deniedPermissions) {
            }

            @Override // com.intentfilter.androidpermissions.PermissionManager.PermissionRequestListener
            public void onPermissionGranted() {
            }
        }

        P() {
        }

        @Override // com.transistorsoft.locationmanager.adapter.TSConfig.OnChangeCallback
        public void onChange(TSConfig tSConfig) {
            if (!tSConfig.getEnabled().booleanValue() || !BackgroundGeolocation.this.i.get() || tSConfig.getDisableMotionActivityUpdates().booleanValue() || LocationAuthorization.hasActivityPermission(BackgroundGeolocation.this.g)) {
                return;
            }
            LocationAuthorization.requestActivityPermission(BackgroundGeolocation.this.g, new a());
        }
    }

    class Q implements Runnable {
        final /* synthetic */ TSConfig a;

        Q(TSConfig tSConfig) {
            this.a = tSConfig;
        }

        @Override // java.lang.Runnable
        public void run() {
            SQLiteLocationDAO sQLiteLocationDAOC = BackgroundGeolocation.c(BackgroundGeolocation.this.g);
            sQLiteLocationDAOC.unlock();
            sQLiteLocationDAOC.prune(this.a.getMaxDaysToPersist().intValue());
            BackgroundGeolocation.this.b();
        }
    }

    class R implements Runnable {
        final /* synthetic */ TSCallback a;

        R(TSCallback tSCallback) {
            this.a = tSCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            BackgroundGeolocation.this.ready(this.a);
        }
    }

    class S implements Runnable {
        TSCallback a;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                S.this.a.onSuccess();
            }
        }

        S(TSCallback tSCallback) {
            this.a = tSCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            BackgroundGeolocation.c(BackgroundGeolocation.this.g).clear();
            BackgroundGeolocation.getUiHandler().post(new a());
        }
    }

    class T implements Runnable {
        private TSGetCountCallback a;

        class a implements Runnable {
            final /* synthetic */ int a;

            a(int i) {
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                T.this.a.onSuccess(Integer.valueOf(this.a));
            }
        }

        public T(TSGetCountCallback tSGetCountCallback) {
            this.a = tSGetCountCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            BackgroundGeolocation.getUiHandler().post(new a(BackgroundGeolocation.c(BackgroundGeolocation.this.g).count()));
        }
    }

    class U implements Runnable {
        private final TSGetGeofencesCallback a;

        class a implements Runnable {
            final /* synthetic */ List a;

            a(List list) {
                this.a = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                U.this.a.onSuccess(this.a);
            }
        }

        public U(TSGetGeofencesCallback tSGetGeofencesCallback) {
            this.a = tSGetGeofencesCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            BackgroundGeolocation.getUiHandler().post(new a(GeofenceDAO.getInstance(BackgroundGeolocation.this.g).all()));
        }
    }

    class V implements Runnable {
        private final TSGetLocationsCallback a;

        class a implements Runnable {
            final /* synthetic */ List a;

            a(List list) {
                this.a = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                V.this.a.onSuccess(this.a);
            }
        }

        V(TSGetLocationsCallback tSGetLocationsCallback) {
            this.a = tSGetLocationsCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            BackgroundGeolocation.getUiHandler().post(new a(BackgroundGeolocation.c(BackgroundGeolocation.this.g).all()));
        }
    }

    class W implements Thread.UncaughtExceptionHandler {
        private Thread.UncaughtExceptionHandler a = Thread.getDefaultUncaughtExceptionHandler();

        W() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            TSConfig tSConfig = TSConfig.getInstance(BackgroundGeolocation.this.g);
            if (tSConfig.getIsMoving().booleanValue()) {
                TSLocationManager.getInstance(BackgroundGeolocation.this.g).stopUpdatingLocation();
            }
            TSLog.logger.error(TSLog.error(("Uncaught Exception: " + th.getMessage()) + "\n" + tSConfig.toJson().toString() + "\n"), th);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.a;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            } else {
                System.exit(2);
            }
        }
    }

    class X implements Runnable {
        private final JSONObject a;
        private final TSInsertLocationCallback b;
        private String c;

        class a implements Runnable {
            final /* synthetic */ String a;

            a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                X.this.b.onSuccess(this.a);
            }
        }

        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                X.this.b.onFailure("Insert location failed");
            }
        }

        public X(JSONObject jSONObject, TSInsertLocationCallback tSInsertLocationCallback) {
            this.a = jSONObject;
            this.b = tSInsertLocationCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            String strPersist = SQLiteLocationDAO.getInstance(BackgroundGeolocation.this.g).persist(this.a);
            if (strPersist == null) {
                BackgroundGeolocation.getUiHandler().post(new b());
                return;
            }
            BackgroundGeolocation.getUiHandler().post(new a(strPersist));
            TSConfig tSConfig = TSConfig.getInstance(BackgroundGeolocation.this.g);
            HttpService httpService = HttpService.getInstance(BackgroundGeolocation.this.g);
            if (tSConfig.hasUrl() && tSConfig.getAutoSync().booleanValue() && httpService.isNetworkAvailable()) {
                Integer autoSyncThreshold = tSConfig.getAutoSyncThreshold();
                if (autoSyncThreshold.intValue() <= 0 || SQLiteLocationDAO.getInstance(BackgroundGeolocation.this.g).count() >= autoSyncThreshold.intValue()) {
                    httpService.e();
                }
            }
        }
    }

    class Y implements Runnable {
        private final Object a;

        Y(Object obj) {
            this.a = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BackgroundGeolocation.c(BackgroundGeolocation.this.g).persist((TSLocation) this.a)) {
                if (TSConfig.getInstance(BackgroundGeolocation.this.g).getAutoSync().booleanValue()) {
                    BackgroundGeolocation.this.sync();
                }
            } else {
                Log.w("TSLocationManager", "INSERT FAILURE" + this.a);
            }
        }
    }

    class Z implements Runnable {
        private final String a;
        private final TSCallback b;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Z.this.b.onFailure("LICENSE_VALIDATION_FAILURE");
            }
        }

        class b implements TSLocationCallback {
            b() {
            }

            @Override // com.transistorsoft.locationmanager.adapter.callback.TSLocationCallback
            public void onError(Integer num) {
                BackgroundGeolocation.this.l = null;
            }

            @Override // com.transistorsoft.locationmanager.adapter.callback.TSLocationCallback
            public void onLocation(TSLocation tSLocation) {
                BackgroundGeolocation.this.l = null;
            }
        }

        class c implements Runnable {
            final /* synthetic */ String a;

            c(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Z.this.b.onFailure(this.a);
            }
        }

        class d implements Runnable {
            d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Z.this.b.onSuccess();
            }
        }

        Z(String str, TSCallback tSCallback) {
            this.a = str;
            this.b = tSCallback;
        }

        private void b() {
            BackgroundGeolocation.getUiHandler().post(new d());
        }

        @Override // java.lang.Runnable
        public void run() {
            TSConfig tSConfig = TSConfig.getInstance(BackgroundGeolocation.this.g);
            if (!Settings.isValid(BackgroundGeolocation.this.g)) {
                BackgroundGeolocation.getUiHandler().post(new a());
                return;
            }
            boolean zEqualsIgnoreCase = this.a.equalsIgnoreCase("start");
            boolean z = zEqualsIgnoreCase != tSConfig.getTrackingMode().intValue();
            tSConfig.setTrackingMode(Integer.valueOf(zEqualsIgnoreCase ? 1 : 0));
            Boolean enabled = tSConfig.getEnabled();
            Log.i("TSLocationManager", "- Enable: " + enabled + " → true, trackingMode: " + tSConfig.getTrackingMode());
            b bVar = new b();
            if (z && enabled.booleanValue()) {
                TrackingService.changeTrackingMode(BackgroundGeolocation.this.g, zEqualsIgnoreCase ? 1 : 0, bVar);
            } else {
                TrackingService.start(BackgroundGeolocation.this.g, bVar);
            }
            b();
        }

        public TSCallback a() {
            return this.b;
        }

        private void a(String str) {
            BackgroundGeolocation.getUiHandler().post(new c(str));
        }
    }

    /* JADX INFO: renamed from: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation$a, reason: case insensitive filesystem */
    /* JADX INFO: loaded from: classes3.dex */
    class C0347a implements TSConfig.OnChangeCallback {

        /* JADX INFO: renamed from: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation$a$a, reason: collision with other inner class name */
        class RunnableC0121a implements Runnable {
            RunnableC0121a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Boolean enabled = TSConfig.getInstance(BackgroundGeolocation.this.g).getEnabled();
                if (LifecycleManager.getInstance().isHeadless()) {
                    HeadlessEventBroadcaster.post(new HeadlessEvent(BackgroundGeolocation.this.g, BackgroundGeolocation.EVENT_ENABLEDCHANGE, enabled));
                }
                synchronized (BackgroundGeolocation.this.p) {
                    Iterator it2 = BackgroundGeolocation.this.p.iterator();
                    while (it2.hasNext()) {
                        ((TSEnabledChangeCallback) it2.next()).onEnabledChange(enabled.booleanValue());
                    }
                }
            }
        }

        C0347a() {
        }

        @Override // com.transistorsoft.locationmanager.adapter.TSConfig.OnChangeCallback
        public void onChange(TSConfig tSConfig) {
            BackgroundGeolocation.getUiHandler().post(new RunnableC0121a());
        }
    }

    /* JADX INFO: renamed from: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation$b, reason: case insensitive filesystem */
    class C0348b implements TSCallback {
        final /* synthetic */ Runnable a;

        C0348b(Runnable runnable) {
            this.a = runnable;
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSCallback
        public void onFailure(String str) {
            TSLog.logger.warn(TSLog.warn(str));
            BackgroundGeolocation.getUiHandler().post(this.a);
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSCallback
        public void onSuccess() {
            BackgroundGeolocation.getUiHandler().post(this.a);
        }
    }

    /* JADX INFO: renamed from: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation$c, reason: case insensitive filesystem */
    class C0349c implements PermissionManager.PermissionRequestListener {
        final /* synthetic */ TSCallback a;

        C0349c(TSCallback tSCallback) {
            this.a = tSCallback;
        }

        @Override // com.intentfilter.androidpermissions.PermissionManager.PermissionRequestListener
        public void onPermissionDenied(DeniedPermissions deniedPermissions) {
            if (!LocationAuthorization.hasPermission(BackgroundGeolocation.this.g)) {
                this.a.onFailure(LocationAuthorization.LOCATION_PERMISSION_DENIED);
                BackgroundGeolocation.this.j.set(false);
                return;
            }
            TSConfig tSConfig = TSConfig.getInstance(BackgroundGeolocation.this.g);
            if (BackgroundGeolocation.this.j.get() && tSConfig.getEnabled().booleanValue() && tSConfig.isLocationTrackingMode()) {
                TSLog.logger.warn(TSLog.warn("Already started.  Ignored"));
                this.a.onSuccess();
            } else {
                BackgroundGeolocation backgroundGeolocation = BackgroundGeolocation.this;
                backgroundGeolocation.l = backgroundGeolocation.new Z("start", this.a);
                BackgroundGeolocation.getThreadPool().execute(BackgroundGeolocation.this.l);
            }
        }

        @Override // com.intentfilter.androidpermissions.PermissionManager.PermissionRequestListener
        public void onPermissionGranted() {
            TSConfig tSConfig = TSConfig.getInstance(BackgroundGeolocation.this.g);
            if (BackgroundGeolocation.this.j.get() && tSConfig.getEnabled().booleanValue() && tSConfig.isLocationTrackingMode()) {
                TSLog.logger.warn(TSLog.warn("Already started.  Ignored"));
                this.a.onSuccess();
            } else {
                BackgroundGeolocation backgroundGeolocation = BackgroundGeolocation.this;
                backgroundGeolocation.l = backgroundGeolocation.new Z("start", this.a);
                BackgroundGeolocation.getThreadPool().execute(BackgroundGeolocation.this.l);
            }
        }
    }

    /* JADX INFO: renamed from: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation$d, reason: case insensitive filesystem */
    class C0350d implements TSCallback {
        C0350d() {
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSCallback
        public void onFailure(String str) {
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSCallback
        public void onSuccess() {
        }
    }

    /* JADX INFO: renamed from: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation$e, reason: case insensitive filesystem */
    class C0351e implements TSCallback {
        C0351e() {
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSCallback
        public void onFailure(String str) {
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSCallback
        public void onSuccess() {
        }
    }

    /* JADX INFO: renamed from: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation$f, reason: case insensitive filesystem */
    class C0352f implements PermissionManager.PermissionRequestListener {
        final /* synthetic */ TSCallback a;

        C0352f(TSCallback tSCallback) {
            this.a = tSCallback;
        }

        @Override // com.intentfilter.androidpermissions.PermissionManager.PermissionRequestListener
        public void onPermissionDenied(DeniedPermissions deniedPermissions) {
            this.a.onFailure(LocationAuthorization.LOCATION_PERMISSION_DENIED);
        }

        @Override // com.intentfilter.androidpermissions.PermissionManager.PermissionRequestListener
        public void onPermissionGranted() {
            TSConfig tSConfig = TSConfig.getInstance(BackgroundGeolocation.this.g);
            if (BackgroundGeolocation.this.j.get() && tSConfig.getEnabled().booleanValue() && !tSConfig.isLocationTrackingMode()) {
                TSLog.logger.warn(TSLog.warn("Already started geofences.  Ignored"));
                this.a.onSuccess();
            } else {
                BackgroundGeolocation backgroundGeolocation = BackgroundGeolocation.this;
                backgroundGeolocation.l = backgroundGeolocation.new Z(BackgroundGeolocation.ACTION_START_GEOFENCES, this.a);
                BackgroundGeolocation.getThreadPool().execute(BackgroundGeolocation.this.l);
            }
        }
    }

    /* JADX INFO: renamed from: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation$g, reason: case insensitive filesystem */
    class C0353g implements TSCallback {
        C0353g() {
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSCallback
        public void onFailure(String str) {
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSCallback
        public void onSuccess() {
        }
    }

    /* JADX INFO: renamed from: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation$h, reason: case insensitive filesystem */
    class C0354h implements TSCallback {
        C0354h() {
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSCallback
        public void onFailure(String str) {
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSCallback
        public void onSuccess() {
        }
    }

    /* JADX INFO: renamed from: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation$i, reason: case insensitive filesystem */
    class RunnableC0355i implements Runnable {
        final /* synthetic */ TSCurrentPositionRequest a;

        RunnableC0355i(TSCurrentPositionRequest tSCurrentPositionRequest) {
            this.a = tSCurrentPositionRequest;
        }

        @Override // java.lang.Runnable
        public void run() {
            TSLocationManager.getInstance(BackgroundGeolocation.this.g).getCurrentPosition(this.a);
        }
    }

    /* JADX INFO: renamed from: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation$j, reason: case insensitive filesystem */
    class RunnableC0356j implements Runnable {
        final /* synthetic */ TSWatchPositionRequest a;

        RunnableC0356j(TSWatchPositionRequest tSWatchPositionRequest) {
            this.a = tSWatchPositionRequest;
        }

        @Override // java.lang.Runnable
        public void run() {
            TSLocationManager.getInstance(BackgroundGeolocation.this.g).watchPosition(this.a);
        }
    }

    /* JADX INFO: renamed from: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation$k, reason: case insensitive filesystem */
    class RunnableC0357k implements Runnable {
        RunnableC0357k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TSLocationManager.getInstance(BackgroundGeolocation.this.g).stopWatchPosition();
        }
    }

    /* JADX INFO: renamed from: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation$l, reason: case insensitive filesystem */
    class C0358l implements TSCallback {
        C0358l() {
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSCallback
        public void onFailure(String str) {
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSCallback
        public void onSuccess() {
        }
    }

    /* JADX INFO: renamed from: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation$m, reason: case insensitive filesystem */
    class C0359m implements TSCallback {
        C0359m() {
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSCallback
        public void onFailure(String str) {
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSCallback
        public void onSuccess() {
        }
    }

    /* JADX INFO: renamed from: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation$n, reason: case insensitive filesystem */
    /* JADX INFO: loaded from: classes6.dex */
    class RunnableC0360n implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ TSGetGeofenceCallback b;

        /* JADX INFO: renamed from: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation$n$a */
        class a implements Runnable {
            final /* synthetic */ TSGeofence a;

            a(TSGeofence tSGeofence) {
                this.a = tSGeofence;
            }

            @Override // java.lang.Runnable
            public void run() {
                TSGeofence tSGeofence = this.a;
                if (tSGeofence != null) {
                    RunnableC0360n.this.b.onSuccess(tSGeofence);
                } else {
                    RunnableC0360n.this.b.onFailure("404");
                }
            }
        }

        RunnableC0360n(String str, TSGetGeofenceCallback tSGetGeofenceCallback) {
            this.a = str;
            this.b = tSGetGeofenceCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            BackgroundGeolocation.getUiHandler().post(new a(GeofenceDAO.getInstance(BackgroundGeolocation.this.g).find(this.a)));
        }
    }

    /* JADX INFO: renamed from: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation$p, reason: case insensitive filesystem */
    class C0362p implements TSCallback {
        C0362p() {
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSCallback
        public void onFailure(String str) {
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSCallback
        public void onSuccess() {
        }
    }

    /* JADX INFO: renamed from: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation$q, reason: case insensitive filesystem */
    class C0363q implements TSCallback {
        C0363q() {
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSCallback
        public void onFailure(String str) {
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSCallback
        public void onSuccess() {
        }
    }

    /* JADX INFO: renamed from: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation$r, reason: case insensitive filesystem */
    class C0364r implements TSCallback {
        C0364r() {
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSCallback
        public void onFailure(String str) {
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSCallback
        public void onSuccess() {
        }
    }

    /* JADX INFO: renamed from: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation$s, reason: case insensitive filesystem */
    class RunnableC0365s implements Runnable {
        final /* synthetic */ TSLocationManager a;
        final /* synthetic */ Float b;
        final /* synthetic */ TSLocationCallback c;

        RunnableC0365s(TSLocationManager tSLocationManager, Float f, TSLocationCallback tSLocationCallback) {
            this.a = tSLocationManager;
            this.b = f;
            this.c = tSLocationCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.setOdometer(this.b, this.c);
        }
    }

    /* JADX INFO: renamed from: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation$t, reason: case insensitive filesystem */
    class C0366t implements TSCallback {
        C0366t() {
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSCallback
        public void onFailure(String str) {
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSCallback
        public void onSuccess() {
        }
    }

    /* JADX INFO: renamed from: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation$u, reason: case insensitive filesystem */
    class C0367u implements TSCallback {
        C0367u() {
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSCallback
        public void onFailure(String str) {
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSCallback
        public void onSuccess() {
        }
    }

    /* JADX INFO: renamed from: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation$v, reason: case insensitive filesystem */
    class C0368v implements TSConfig.OnChangeCallback {
        C0368v() {
        }

        @Override // com.transistorsoft.locationmanager.adapter.TSConfig.OnChangeCallback
        public void onChange(TSConfig tSConfig) {
            TSLocation.resetGeofenceTemplate();
        }
    }

    /* JADX INFO: renamed from: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation$w, reason: case insensitive filesystem */
    class C0369w implements TSCallback {
        C0369w() {
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSCallback
        public void onFailure(String str) {
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSCallback
        public void onSuccess() {
        }
    }

    /* JADX INFO: renamed from: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation$x, reason: case insensitive filesystem */
    /* JADX INFO: loaded from: classes6.dex */
    class RunnableC0370x implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ TSCallback b;

        /* JADX INFO: renamed from: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation$x$a */
        class a implements Runnable {
            final /* synthetic */ boolean a;

            a(boolean z) {
                this.a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.a) {
                    RunnableC0370x.this.b.onSuccess();
                } else {
                    RunnableC0370x.this.b.onFailure("");
                }
            }
        }

        RunnableC0370x(String str, TSCallback tSCallback) {
            this.a = str;
            this.b = tSCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            BackgroundGeolocation.getUiHandler().post(new a(BackgroundGeolocation.c(BackgroundGeolocation.this.g).destroy(this.a)));
        }
    }

    /* JADX INFO: renamed from: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation$y, reason: case insensitive filesystem */
    class C0371y implements PermissionManager.PermissionRequestListener {
        final /* synthetic */ TSRequestPermissionCallback a;

        C0371y(TSRequestPermissionCallback tSRequestPermissionCallback) {
            this.a = tSRequestPermissionCallback;
        }

        @Override // com.intentfilter.androidpermissions.PermissionManager.PermissionRequestListener
        public void onPermissionDenied(DeniedPermissions deniedPermissions) {
            this.a.onFailure(TSProviderManager.PERMISSION_DENIED);
        }

        @Override // com.intentfilter.androidpermissions.PermissionManager.PermissionRequestListener
        public void onPermissionGranted() {
            this.a.onSuccess(LocationAuthorization.hasBackgroundPermission(BackgroundGeolocation.this.g) ? TSProviderManager.PERMISSION_ALWAYS : TSProviderManager.PERMISSION_WHEN_IN_USE);
            TSLocationManagerActivity.start(BackgroundGeolocation.this.g, TSLocationManagerActivity.ACTION_LOCATION_SETTINGS);
        }
    }

    /* JADX INFO: renamed from: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation$z, reason: case insensitive filesystem */
    class C0372z implements PermissionManager.PermissionRequestListener {
        final /* synthetic */ TSRequestPermissionCallback a;

        C0372z(TSRequestPermissionCallback tSRequestPermissionCallback) {
            this.a = tSRequestPermissionCallback;
        }

        @Override // com.intentfilter.androidpermissions.PermissionManager.PermissionRequestListener
        public void onPermissionDenied(DeniedPermissions deniedPermissions) {
            this.a.onFailure(TSProviderManager.PERMISSION_DENIED);
        }

        @Override // com.intentfilter.androidpermissions.PermissionManager.PermissionRequestListener
        public void onPermissionGranted() {
            this.a.onSuccess(LocationAuthorization.hasBackgroundPermission(BackgroundGeolocation.this.g) ? TSProviderManager.PERMISSION_ALWAYS : TSProviderManager.PERMISSION_WHEN_IN_USE);
            TSLocationManagerActivity.start(BackgroundGeolocation.this.g, TSLocationManagerActivity.ACTION_LOCATION_SETTINGS);
        }
    }

    public BackgroundGeolocation(Context context) {
        this.g = context.getApplicationContext();
        EventBus eventBus = EventBus.getDefault();
        if (!eventBus.isRegistered(this)) {
            eventBus.register(this);
        }
        Thread.setDefaultUncaughtExceptionHandler(new W());
        if (isOnMainThread()) {
            LifecycleManager.getInstance().run();
        } else {
            getUiHandler().post(LifecycleManager.getInstance());
        }
        TSLog.logger.info(TSLog.ok("Google Play Services: connected (version code:" + GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE + ")"));
    }

    private void c() {
    }

    public static long deltaT(String str) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(Long.parseLong(str) * 1000);
        calendar2.set(11, 0);
        calendar2.set(12, 0);
        calendar2.set(13, 0);
        calendar2.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        return TimeUnit.MILLISECONDS.toDays(calendar2.getTimeInMillis() - timeInMillis);
    }

    public static String getBroadcastAction(String str) {
        return "com.transistorsoft.locationmanager.event." + str.toUpperCase();
    }

    public static BackgroundGeolocation getInstance(Context context, Intent intent) {
        return getInstance(context);
    }

    public static ExecutorService getThreadPool() {
        return c;
    }

    public static Handler getUiHandler() {
        if (d == null) {
            d = new Handler(Looper.getMainLooper());
        }
        return d;
    }

    public static boolean isOnMainThread() {
        return Thread.currentThread().equals(Looper.getMainLooper().getThread());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void _onActivityTransitionEvent(ActivityTransitionEvent activityTransitionEvent) {
        if (LifecycleManager.getInstance().isHeadless()) {
            HeadlessEventBroadcaster.post(new HeadlessEvent(this.g, EVENT_ACTIVITYCHANGE, new ActivityChangeEvent(activityTransitionEvent)));
        }
        a(activityTransitionEvent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void _onGeofenceEvent(GeofenceEvent geofenceEvent) {
        TSConfig.getInstance(this.g);
        if (Settings.isValid(this.g)) {
            synchronized (this.A) {
                this.A.clear();
            }
            this.A.add(geofenceEvent);
            if (LifecycleManager.getInstance().isHeadless()) {
                HeadlessEventBroadcaster.post(new HeadlessEvent(this.g, "geofence", geofenceEvent));
            }
            a(geofenceEvent);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void _onHeartbeat(HeartbeatEvent heartbeatEvent) {
        a(heartbeatEvent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void _onHttpResponse(HttpResponse httpResponse) {
        if (LifecycleManager.getInstance().isHeadless()) {
            HeadlessEventBroadcaster.post(new HeadlessEvent(this.g, "http", httpResponse));
        }
        synchronized (this.r) {
            Iterator<TSHttpResponseCallback> it2 = this.r.iterator();
            while (it2.hasNext()) {
                it2.next().onHttpResponse(httpResponse);
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void _onLocationChange(TSLocation tSLocation) {
        if (LifecycleManager.getInstance().isHeadless()) {
            HeadlessEventBroadcaster.post(new HeadlessEvent(this.g, "location", tSLocation));
        }
        a(tSLocation);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void _onLocationError(LocationErrorEvent locationErrorEvent) {
        TSLog.logger.warn(TSLog.warn("Location error: " + locationErrorEvent.errorCode));
        TSConfig tSConfig = TSConfig.getInstance(this.g);
        TSMediaPlayer.getInstance().debug(this.g, "tslocationmanager_digi_warn");
        if (locationErrorEvent.errorCode == 1 && tSConfig.getDebug().booleanValue()) {
            getUiHandler().post(new TSNotification(this.g, "Location services disabled", locationErrorEvent.message));
        }
        b(locationErrorEvent.errorCode);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void _onLocationProviderChange(LocationProviderChangeEvent locationProviderChangeEvent) {
        this.f = locationProviderChangeEvent;
        if (LifecycleManager.getInstance().isHeadless()) {
            HeadlessEventBroadcaster.post(new HeadlessEvent(this.g, EVENT_PROVIDERCHANGE, locationProviderChangeEvent));
        }
        a(locationProviderChangeEvent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void _onMotionChange(MotionChangeEvent motionChangeEvent) {
        if (LifecycleManager.getInstance().isHeadless()) {
            TSConfig.getInstance(this.g);
            HeadlessEventBroadcaster.post(new HeadlessEvent(this.g, EVENT_MOTIONCHANGE, motionChangeEvent));
        }
        a(motionChangeEvent);
    }

    @Subscribe
    public void _onScheduleEvent(ScheduleEvent scheduleEvent) {
        if (TSConfig.getInstance(this.g).getSchedulerEnabled().booleanValue()) {
            a(scheduleEvent);
            if (LifecycleManager.getInstance().isHeadless()) {
                HeadlessEventBroadcaster.post(new HeadlessEvent(this.g, "schedule", scheduleEvent.getState()));
                return;
            }
            return;
        }
        TSLog.logger.warn(TSLog.warn("Ignored a Schedule event because Scheduler is disabled: " + scheduleEvent));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void _onSecurityException(SecurityExceptionEvent securityExceptionEvent) {
        TSLog.logger.warn(TSLog.warn("BackgroundGeolocation onSecurityException: " + securityExceptionEvent.toString()));
        synchronized (this.y) {
            Iterator<TSSecurityExceptionCallback> it2 = this.y.iterator();
            while (it2.hasNext()) {
                it2.next().onSecurityException(securityExceptionEvent);
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void _onSettingsFailure(SettingsFailureEvent settingsFailureEvent) {
        getUiHandler().post(new TSNotification(this.g, settingsFailureEvent.title, settingsFailureEvent.message));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void _onTemplateError(TemplateErrorEvent templateErrorEvent) {
        TSMediaPlayer.getInstance().debug(this.g, "tslocationmanager_music_timpani_error_01");
        getUiHandler().post(new TSNotification(this.g, "You have an error in your " + templateErrorEvent.getTemplateName(), templateErrorEvent.getError().getMessage()));
    }

    public void addGeofence(TSGeofence tSGeofence, TSCallback tSCallback) {
        TSGeofenceManager.getInstance(this.g).add(tSGeofence, tSCallback);
    }

    public void addGeofences(List<TSGeofence> list, TSCallback tSCallback) {
        TSGeofenceManager.getInstance(this.g).add(list, tSCallback);
    }

    public void changePace(boolean z, TSCallback tSCallback) {
        TSConfig tSConfig = TSConfig.getInstance(this.g);
        if (!tSConfig.getEnabled().booleanValue()) {
            tSCallback.onFailure("BackgroundGeolocation is disabled");
            return;
        }
        if (!tSConfig.isLocationTrackingMode()) {
            z = false;
        }
        getThreadPool().execute(new ChangePaceTask(z, tSCallback));
    }

    public void clearDatabase(TSCallback tSCallback) {
        destroyLocations(tSCallback);
    }

    public void destroyLocation(String str) {
        destroyLocation(str, new C0369w());
    }

    public void destroyLocations(TSCallback tSCallback) {
        getThreadPool().execute(new S(tSCallback));
    }

    public void destroyLog(TSCallback tSCallback) {
        TSLog.destroyLog(tSCallback);
    }

    public void emailLog(String str, Activity activity, TSEmailLogCallback tSEmailLogCallback) {
        TSLog.emailLog(str, activity, tSEmailLogCallback);
    }

    public void fireNotificationActionListeners(String str) {
        if (LifecycleManager.getInstance().isHeadless()) {
            HeadlessEventBroadcaster.post(new HeadlessEvent(this.g, "notificationaction", str));
        }
        getUiHandler().post(new H(str));
    }

    public void geofenceExists(@NonNull String str, TSHasGeofenceCallback tSHasGeofenceCallback) {
        getThreadPool().execute(new RunnableC0361o(str, tSHasGeofenceCallback));
    }

    public Activity getActivity() {
        return this.h;
    }

    public int getCount() {
        return c(this.g).count();
    }

    public void getCurrentPosition(TSCurrentPositionRequest tSCurrentPositionRequest) {
        getThreadPool().execute(new RunnableC0355i(tSCurrentPositionRequest));
    }

    public void getGeofence(@NonNull String str, TSGetGeofenceCallback tSGetGeofenceCallback) {
        getThreadPool().execute(new RunnableC0360n(str, tSGetGeofenceCallback));
    }

    public void getGeofences(TSGetGeofencesCallback tSGetGeofencesCallback) {
        getThreadPool().execute(new U(tSGetGeofencesCallback));
    }

    public JSONArray getLocations() {
        List<LocationModel> listAll = c(this.g).all();
        JSONArray jSONArray = new JSONArray();
        Iterator<LocationModel> it2 = listAll.iterator();
        while (it2.hasNext()) {
            jSONArray.put(it2.next().json);
        }
        return jSONArray;
    }

    public String getLog() {
        return TSLogReader.getLog(new SQLQuery());
    }

    public Float getOdometer() {
        return TSConfig.getInstance(this.g).getOdometer();
    }

    public LocationProviderChangeEvent getProviderState() {
        return new LocationProviderChangeEvent(this.g);
    }

    public Sensors getSensors() {
        return Sensors.getInstance(this.g);
    }

    public void insertLocation(JSONObject jSONObject, TSInsertLocationCallback tSInsertLocationCallback) {
        if (!jSONObject.has("timestamp")) {
            tSInsertLocationCallback.onFailure("insertLocation params must contain timestamp");
        } else if (jSONObject.has("coords")) {
            getThreadPool().execute(new X(jSONObject, tSInsertLocationCallback));
        } else {
            tSInsertLocationCallback.onFailure("insertLocation params must contains a coords {}");
        }
    }

    public boolean isDead() {
        return this.g == null;
    }

    public Boolean isIgnoringBatteryOptimizations() {
        return DeviceSettings.getInstance().isIgnoringBatteryOptimization(this.g);
    }

    public Boolean isPowerSaveMode() {
        return DeviceSettings.getInstance().isPowerSaveMode(this.g);
    }

    public void onActivityChange(TSActivityChangeCallback tSActivityChangeCallback) {
        a(tSActivityChangeCallback);
    }

    public void onActivityDestroy() {
        this.i.set(false);
        this.h = null;
        TSLocationManager.getInstance(this.g).stopWatchPosition();
        LifecycleManager.getInstance().setHeadless(true);
        a();
        getThreadPool().execute(new Runnable() { // from class: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.e();
            }
        });
    }

    public void onActivityResumed() {
        TSScheduleManager.getInstance(this.g).cancelOneShot(TerminateEvent.ACTION);
    }

    public void onActivityStopped() {
        TSConfig tSConfig = TSConfig.getInstance(this.g);
        if (tSConfig.getEnabled().booleanValue() && tSConfig.getEnableHeadless().booleanValue() && !tSConfig.getStopOnTerminate().booleanValue()) {
            TSScheduleManager.getInstance(this.g).oneShot(TerminateEvent.ACTION, 5000L, true, false);
        }
    }

    public void onConnectivityChange(TSConnectivityChangeCallback tSConnectivityChangeCallback) {
        a(tSConnectivityChangeCallback);
    }

    public void onEnabledChange(TSEnabledChangeCallback tSEnabledChangeCallback) {
        a(tSEnabledChangeCallback);
    }

    public void onGeofence(TSGeofenceCallback tSGeofenceCallback) {
        a(tSGeofenceCallback);
    }

    public void onGeofencesChange(TSGeofencesChangeCallback tSGeofencesChangeCallback) {
        a(tSGeofencesChangeCallback);
    }

    public void onHeartbeat(TSHeartbeatCallback tSHeartbeatCallback) {
        a(tSHeartbeatCallback);
    }

    public void onHttp(TSHttpResponseCallback tSHttpResponseCallback) {
        a(tSHttpResponseCallback);
    }

    public void onLocation(TSLocationCallback tSLocationCallback) {
        a(tSLocationCallback);
    }

    public void onLocationProviderChange(TSLocationProviderChangeCallback tSLocationProviderChangeCallback) {
        a(tSLocationProviderChangeCallback);
    }

    public void onMotionChange(TSLocationCallback tSLocationCallback) {
        b(tSLocationCallback);
    }

    public void onNotificationAction(TSNotificationActionCallback tSNotificationActionCallback) {
        a(tSNotificationActionCallback);
    }

    public void onPlayServicesConnectError(TSPlayServicesConnectErrorCallback tSPlayServicesConnectErrorCallback) {
        a(tSPlayServicesConnectErrorCallback);
    }

    public void onPowerSaveChange(TSPowerSaveChangeCallback tSPowerSaveChangeCallback) {
        a(tSPowerSaveChangeCallback);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPowerSaveModeChange(PowerSaveModeChangeEvent powerSaveModeChangeEvent) {
        synchronized (this.u) {
            Iterator<TSPowerSaveChangeCallback> it2 = this.u.iterator();
            if (LifecycleManager.getInstance().isHeadless()) {
                HeadlessEventBroadcaster.post(new HeadlessEvent(this.g, EVENT_POWERSAVECHANGE, powerSaveModeChangeEvent));
            }
            while (it2.hasNext()) {
                it2.next().onPowerSaveChange(powerSaveModeChangeEvent.isPowerSaveMode());
            }
        }
    }

    public void onSchedule(TSScheduleCallback tSScheduleCallback) {
        a(tSScheduleCallback);
    }

    public void onSecurityException(TSSecurityExceptionCallback tSSecurityExceptionCallback) {
        a(tSSecurityExceptionCallback);
    }

    public void persistLocation(TSLocation tSLocation) {
        TSConfig tSConfig = TSConfig.getInstance(this.g);
        if (tSConfig.shouldPersist(tSLocation)) {
            if (EventBus.getDefault().hasSubscriberForEvent(PersistEvent.class)) {
                if (TSPlugin.getInstance().canUsePersistEvent(this.g)) {
                    EventBus.getDefault().post(new PersistEvent(this.g, tSLocation, tSConfig.getParams()));
                    return;
                } else {
                    TSLog.logger.warn(TSLog.warn("Failed to persist location"));
                    return;
                }
            }
            if (tSConfig.getMaxDaysToPersist().intValue() == 0 || !tSConfig.getPersist().booleanValue()) {
                return;
            }
            getThreadPool().execute(new Y(tSLocation));
        }
    }

    public void ready(TSCallback tSCallback) {
        Boolean enabled;
        TSConfig tSConfig = TSConfig.getInstance(this.g);
        if (!this.i.get() && !tSConfig.getConfigUrl().isEmpty() && this.k.compareAndSet(false, true)) {
            tSConfig.loadConfig(new C0348b(new R(tSCallback)));
            return;
        }
        if (this.i.get()) {
            if (tSConfig.getEnabled().booleanValue()) {
                TSLocationManager.getInstance(this.g).getCurrentPosition(new TSCurrentPositionRequest.Builder(this.g).setPersist(false).setSamples(1).setDesiredAccuracy(100).setMaximumAge(60000L).build());
            }
            tSCallback.onSuccess();
            return;
        }
        this.i.set(true);
        TSProviderManager.getInstance(this.g).startMonitoring(this.g);
        if (tSConfig.hasSchedule() && tSConfig.getSchedulerEnabled().booleanValue()) {
            startSchedule();
            enabled = Boolean.FALSE;
        } else {
            tSConfig.setSchedulerEnabled(Boolean.FALSE);
            enabled = tSConfig.getEnabled();
        }
        if (!enabled.booleanValue()) {
            tSCallback.onSuccess();
        } else if (tSConfig.isLocationTrackingMode()) {
            start(tSCallback);
        } else {
            startGeofences(tSCallback);
        }
        EventBus.getDefault().post(new LocationProviderChangeEvent(this.g));
    }

    public void registerPlugin(int i) {
        TSPlugin.getInstance().register(this.g, i);
    }

    public void removeGeofence(String str, TSCallback tSCallback) {
        TSGeofenceManager.getInstance(this.g).remove(str, tSCallback);
    }

    public void removeGeofences(List<String> list, TSCallback tSCallback) {
        TSGeofenceManager.getInstance(this.g).remove(list, tSCallback);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0036  */
    /* JADX WARN: Code duplicated, block: B:14:0x0051  */
    /* JADX WARN: Instruction removed from duplicated block: B:13:0x0036, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:14:0x0051, please report this as an issue */
    public Object removeListener(String str, Object obj) {
        Boolean boolValueOf;
        if (str.equalsIgnoreCase("geofenceschange")) {
            TSGeofenceManager.getInstance(this.g).removeListener(str, obj);
        } else {
            if (!"authorization".equalsIgnoreCase(str)) {
                List listA = a(str);
                boolValueOf = listA != null ? Boolean.valueOf(listA.remove(obj)) : null;
                if (boolValueOf != null) {
                    TSLog.logger.debug(TSLog.ok("removeListener event: " + str));
                } else {
                    TSLog.logger.warn(TSLog.warn("Failed to removeListener, event: " + str));
                }
                return boolValueOf;
            }
            HttpService.getInstance(this.g).removeListener(str, obj);
        }
        if (boolValueOf != null) {
            TSLog.logger.debug(TSLog.ok("removeListener event: " + str));
        } else {
            TSLog.logger.warn(TSLog.warn("Failed to removeListener, event: " + str));
        }
        return boolValueOf;
    }

    public void removeListeners() {
        a();
    }

    public void requestPermission(TSRequestPermissionCallback tSRequestPermissionCallback) {
        LocationAuthorization.withBackgroundPermission(this.g, new C0371y(tSRequestPermissionCallback));
    }

    public DeviceSettingsRequest requestSettings(String str) {
        return DeviceSettings.getInstance().request(this.g, str);
    }

    public void requestTemporaryFullAccuracy(String str, TSRequestPermissionCallback tSRequestPermissionCallback) {
        if (ContextCompat.checkSelfPermission(this.g, RNBackgroundGeolocationModule.ACCESS_FINE_LOCATION) == 0) {
            tSRequestPermissionCallback.onSuccess(TSProviderManager.ACCURACY_AUTHORIZATION_FULL);
        } else {
            LocationAuthorization.requestTemporaryFullAccuracy(this.g, new A(tSRequestPermissionCallback));
        }
    }

    public void setActivity(Activity activity) {
        if (this.h == activity) {
            return;
        }
        this.h = activity;
    }

    public void setBeforeInsertBlock(TSBeforeInsertBlock tSBeforeInsertBlock) {
        SQLiteLocationDAO.getInstance(this.g).setBeforeInsertBlock(tSBeforeInsertBlock);
    }

    public void setOdometer(Float f, TSLocationCallback tSLocationCallback) {
        TSLocationManager tSLocationManager = TSLocationManager.getInstance(this.g);
        if (tSLocationManager.isLocationServicesEnabled().booleanValue()) {
            getThreadPool().execute(new RunnableC0365s(tSLocationManager, f, tSLocationCallback));
        } else {
            tSLocationCallback.onError(1);
            b(1);
        }
    }

    public boolean showSettings(String str) {
        return DeviceSettings.getInstance().show(this.g, str);
    }

    public void start(TSCallback tSCallback) {
        if (this.l != null) {
            tSCallback.onFailure("Waiting for previous start action to complete");
        } else {
            a(tSCallback);
        }
    }

    public void startBackgroundTask(TSBackgroundTaskCallback tSBackgroundTaskCallback) {
        BackgroundTaskManager.getInstance().startBackgroundTask(this.g, tSBackgroundTaskCallback);
    }

    public void startGeofences(TSCallback tSCallback) {
        if (this.l != null) {
            tSCallback.onFailure("Waiting for previous start action to complete");
        } else {
            b(tSCallback);
        }
    }

    public void startOnBoot() {
        TSConfig tSConfig = TSConfig.getInstance(this.g);
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        if (googleApiAvailability.isGooglePlayServicesAvailable(this.g) == 0) {
            TrackingService.start(this.g);
            if (LifecycleManager.getInstance().isHeadless()) {
                HeadlessEventBroadcaster.post(new HeadlessEvent(this.g, EVENT_BOOT, tSConfig.toJson()));
                return;
            }
            return;
        }
        int iIsGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(this.g);
        TSLog.logger.warn(TSLog.warn("GooglePlayServices unavailable.  resultCode: " + iIsGooglePlayServicesAvailable));
    }

    public void startOnSchedule() {
        TSProviderManager.getInstance(this.g).startMonitoring(this.g);
        TrackingService.start(this.g);
    }

    public boolean startSchedule() {
        if (TSConfig.getInstance(this.g).hasSchedule()) {
            TSScheduleManager.getInstance(this.g).start();
            return true;
        }
        TSLog.logger.warn(TSLog.warn("Cannot startSchedule; schedule is null"));
        return false;
    }

    public void startTone(int i) {
    }

    public void stop(final TSCallback tSCallback) {
        if (this.l != null) {
            this.l = null;
        }
        this.j.set(false);
        getThreadPool().execute(new Runnable() { // from class: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c(tSCallback);
            }
        });
    }

    public void stopBackgroundTask(int i) {
        BackgroundTaskManager.getInstance().stopBackgroundTask(this.g, i);
    }

    public void stopOnSchedule() {
        TSConfig.getInstance(this.g).setIsMoving(Boolean.FALSE);
        if (LifecycleManager.getInstance().isHeadless()) {
            TSProviderManager.getInstance(this.g).stopMonitoring(this.g);
        }
        this.j.set(false);
        this.l = null;
        TrackingService.stop(this.g);
    }

    public void stopSchedule() {
        TSScheduleManager.getInstance(this.g).stop();
    }

    public void stopWatchPosition(TSCallback tSCallback) {
        getThreadPool().execute(new RunnableC0357k());
        tSCallback.onSuccess();
    }

    public void sync(TSSyncCallback tSSyncCallback) {
        getThreadPool().execute(new a0(tSSyncCallback));
    }

    public void watchPosition(TSWatchPositionRequest tSWatchPositionRequest) {
        getThreadPool().execute(new RunnableC0356j(tSWatchPositionRequest));
    }

    class a0 implements Runnable {
        private TSSyncCallback a;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a0.this.a.onFailure("HTTPService is busy");
            }
        }

        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a0.this.a.onFailure("No network connection");
            }
        }

        class c implements Runnable {
            final /* synthetic */ List a;

            c(List list) {
                this.a = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                a0.this.a.onSuccess(this.a);
            }
        }

        a0(TSSyncCallback tSSyncCallback) {
            this.a = tSSyncCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TSConfig.getInstance(BackgroundGeolocation.this.g).hasUrl()) {
                if (this.a != null) {
                    SQLiteLocationDAO sQLiteLocationDAOC = BackgroundGeolocation.c(BackgroundGeolocation.this.g);
                    List<LocationModel> listAll = sQLiteLocationDAOC.all();
                    sQLiteLocationDAOC.destroyAll(listAll);
                    BackgroundGeolocation.getUiHandler().post(new c(listAll));
                    return;
                }
                return;
            }
            HttpService httpService = HttpService.getInstance(BackgroundGeolocation.this.g);
            if (!httpService.isNetworkAvailable()) {
                if (this.a != null) {
                    BackgroundGeolocation.getUiHandler().post(new b());
                }
            } else {
                if (!httpService.isBusy()) {
                    httpService.flush(this.a);
                    return;
                }
                TSLog.logger.info(TSLog.notice("HTTPService is busy with an existing request."));
                if (this.a != null) {
                    BackgroundGeolocation.getUiHandler().post(new a());
                }
            }
        }

        a0() {
        }
    }

    private static BackgroundGeolocation b(Context context) {
        BackgroundGeolocation backgroundGeolocation;
        synchronized (BackgroundGeolocation.class) {
            if (b == null) {
                BackgroundGeolocation backgroundGeolocation2 = new BackgroundGeolocation(context);
                b = backgroundGeolocation2;
                backgroundGeolocation2.d();
            }
            backgroundGeolocation = b;
        }
        return backgroundGeolocation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        TSConfig tSConfig = TSConfig.getInstance(this.g);
        if (tSConfig.getStopOnTerminate().booleanValue()) {
            TSScheduleManager.getInstance(this.g).cancelOneShot(TerminateEvent.ACTION);
            if (tSConfig.getEnabled().booleanValue()) {
                tSConfig.setEnabled(Boolean.FALSE);
                TrackingService.stop(this.g);
            }
            this.j.set(false);
            TSProviderManager.getInstance(this.g).stopMonitoring(this.g);
            TSScheduleManager.getInstance(this.g).stop();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(TSLog.header("MainActivity was destroyed"));
        sb.append(TSLog.boxRow("stopOnTerminate: " + tSConfig.getStopOnTerminate()));
        sb.append(TSLog.boxRow("enabled: " + tSConfig.getEnabled()));
        b();
        TSLog.logger.info(sb.toString());
    }

    public static BackgroundGeolocation getInstance(Context context) {
        BackgroundGeolocation backgroundGeolocation = b;
        if (backgroundGeolocation == null || backgroundGeolocation.isDead()) {
            b = b(context);
        }
        if (context instanceof Activity) {
            b.setActivity((Activity) context);
        }
        return b;
    }

    public void addGeofence(TSGeofence tSGeofence) {
        addGeofence(tSGeofence, new C0358l());
    }

    public void addGeofences(List<TSGeofence> list) {
        addGeofences(list, new C0359m());
    }

    void d() {
        TSLocationManager.getInstance(this.g);
        HttpService.getInstance(this.g);
        TSScheduleManager.getInstance(this.g);
        TSGeofenceManager.getInstance(this.g);
        TSConfig tSConfig = TSConfig.getInstance(this.g);
        TSProviderManager.getInstance(this.g).startMonitoring(this.g);
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        if (googleApiAvailability.isGooglePlayServicesAvailable(this.g) != 0) {
            int iIsGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(this.g);
            TSLog.logger.warn(TSLog.warn("GooglePlayServices unavailable.  resultCode: " + iIsGooglePlayServicesAvailable));
        }
        if (tSConfig.getEnabled().booleanValue() && LifecycleManager.getInstance().isHeadless() && !tSConfig.getDidDeviceReboot().booleanValue()) {
            TrackingService.restart(this.g);
        }
        tSConfig.onChange(ViewProps.ENABLED, new C0347a());
        tSConfig.onChange("geofenceTemplate", new C0368v());
        tSConfig.onChange("locationTemplate", new G());
        tSConfig.onChange("heartbeatInterval", new M());
        tSConfig.onChange("notification.sticky", new N());
        tSConfig.onChange("locationAuthorizationRequest", new O());
        tSConfig.onChange("disableMotionActivityUpdates", new P());
        TSMediaPlayer.getInstance().init(this.g);
        c.execute(new Q(tSConfig));
        if (LifecycleManager.getInstance().isHeadless() && tSConfig.getEnabled().booleanValue()) {
            getThreadPool().execute(TSGeofenceManager.getInstance(this.g));
        }
    }

    public void destroyLocation(String str, TSCallback tSCallback) {
        getThreadPool().execute(new RunnableC0370x(str, tSCallback));
    }

    public void destroyLocations() {
        destroyLocations(new C0367u());
    }

    public void destroyLog() {
        destroyLog(new C0366t());
    }

    public void geofenceExists(String str, TSGeofenceExistsCallback tSGeofenceExistsCallback) {
        TSGeofenceManager.getInstance(this.g).geofenceExists(str, tSGeofenceExistsCallback);
    }

    public void getCount(TSGetCountCallback tSGetCountCallback) {
        getThreadPool().execute(new T(tSGetCountCallback));
    }

    public void getLog(TSGetLogCallback tSGetLogCallback) {
        TSLog.getLog(tSGetLogCallback);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onConnectivityChange(ConnectivityChangeEvent connectivityChangeEvent) {
        synchronized (this.q) {
            Iterator<TSConnectivityChangeCallback> it2 = this.q.iterator();
            if (LifecycleManager.getInstance().isHeadless()) {
                HeadlessEventBroadcaster.post(new HeadlessEvent(this.g, EVENT_CONNECTIVITYCHANGE, connectivityChangeEvent));
            }
            while (it2.hasNext()) {
                it2.next().onConnectivityChange(connectivityChangeEvent);
            }
        }
    }

    public void removeGeofence(String str) {
        removeGeofence(str, new C0362p());
    }

    public void removeGeofences(List<String> list) {
        removeGeofences(list, new C0363q());
    }

    public void removeListeners(String str) {
        TSLog.logger.debug(TSLog.ok("event: " + str));
        if (str.equalsIgnoreCase("geofenceschange")) {
            TSGeofenceManager.getInstance(this.g).removeListeners();
            return;
        }
        if ("authorization".equalsIgnoreCase(str)) {
            HttpService.getInstance(this.g).removeListeners();
            return;
        }
        List listA = a(str);
        if (listA != null) {
            synchronized (listA) {
                listA.clear();
            }
        }
    }

    public void requestPermission(String str, TSRequestPermissionCallback tSRequestPermissionCallback) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        LocationAuthorization.requestPermission(this.g, arrayList, new C0372z(tSRequestPermissionCallback));
    }

    public void startTone(String str) {
        try {
            TSMediaPlayer.getInstance().play(this.g, (String) TSMediaPlayer.class.getDeclaredField(str).get(str));
        } catch (Exception unused) {
            TSLog.logger.error(TSLog.error("Unknown sound key: " + str));
        }
    }

    public void sync() {
        getThreadPool().execute(new a0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SQLiteLocationDAO c(Context context) {
        return SQLiteLocationDAO.getInstance(context);
    }

    public void removeGeofences(TSCallback tSCallback) {
        TSGeofenceManager.getInstance(this.g).remove(new ArrayList(), tSCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(final TSCallback tSCallback) {
        TrackingService.stop(this.g);
        Handler uiHandler = getUiHandler();
        Objects.requireNonNull(tSCallback);
        uiHandler.post(new Runnable() { // from class: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                tSCallback.onSuccess();
            }
        });
    }

    public void removeGeofences() {
        removeGeofences(new C0364r());
    }

    private void a(TSCallback tSCallback) {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        if (googleApiAvailability.isGooglePlayServicesAvailable(this.g) != 0) {
            int iIsGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(this.g);
            TSLog.logger.warn(TSLog.warn("GooglePlayServices unavailable.  resultCode: " + iIsGooglePlayServicesAvailable));
            a(iIsGooglePlayServicesAvailable);
            return;
        }
        LocationAuthorization.withBackgroundPermission(this.g, new C0349c(tSCallback));
    }

    public void getLocations(TSGetLocationsCallback tSGetLocationsCallback) {
        getThreadPool().execute(new V(tSGetLocationsCallback));
    }

    public void start() {
        TSCallback c0350d = new C0350d();
        Z z = this.l;
        if (z != null) {
            c0350d = z.a();
            this.l = null;
        }
        a(c0350d);
    }

    public void startGeofences() {
        TSCallback c0351e = new C0351e();
        Z z = this.l;
        if (z != null) {
            c0351e = z.a();
        }
        b(c0351e);
    }

    public void stop() {
        stop(new C0353g());
    }

    private void b(TSCallback tSCallback) {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        if (googleApiAvailability.isGooglePlayServicesAvailable(this.g) != 0) {
            int iIsGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(this.g);
            TSLog.logger.warn(TSLog.warn("GooglePlayServices unavailable.  resultCode: " + iIsGooglePlayServicesAvailable));
            return;
        }
        LocationAuthorization.withBackgroundPermission(this.g, new C0352f(tSCallback));
    }

    public void changePace(boolean z) {
        changePace(z, new C0354h());
    }

    private List a(String str) {
        if ("location".equalsIgnoreCase(str)) {
            return this.m;
        }
        if (EVENT_MOTIONCHANGE.equals(str)) {
            return this.f97n;
        }
        if (EVENT_ACTIVITYCHANGE.equalsIgnoreCase(str)) {
            return this.t;
        }
        if ("geofence".equalsIgnoreCase(str)) {
            return this.f98o;
        }
        if (EVENT_PROVIDERCHANGE.equalsIgnoreCase(str)) {
            return this.v;
        }
        if ("heartbeat".equalsIgnoreCase(str)) {
            return this.s;
        }
        if ("http".equalsIgnoreCase(str)) {
            return this.r;
        }
        if ("schedule".equalsIgnoreCase(str)) {
            return this.w;
        }
        if (EVENT_POWERSAVECHANGE.equalsIgnoreCase(str)) {
            return this.u;
        }
        if (EVENT_ENABLEDCHANGE.equalsIgnoreCase(str)) {
            return this.p;
        }
        if (EVENT_CONNECTIVITYCHANGE.equalsIgnoreCase(str)) {
            return this.q;
        }
        if ("notificationaction".equalsIgnoreCase(str)) {
            return this.z;
        }
        return null;
    }

    private void b(TSLocationCallback tSLocationCallback) {
        synchronized (this.f97n) {
            this.f97n.add(tSLocationCallback);
        }
    }

    private void b(int i) {
        getUiHandler().post(new F(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        new File(this.g.getCacheDir(), TSLog.LOG_FILENAME).delete();
    }

    private void a(TSLocationCallback tSLocationCallback) {
        synchronized (this.m) {
            this.m.add(tSLocationCallback);
        }
    }

    private void a(TSHttpResponseCallback tSHttpResponseCallback) {
        synchronized (this.r) {
            this.r.add(tSHttpResponseCallback);
        }
    }

    private void a(TSHeartbeatCallback tSHeartbeatCallback) {
        synchronized (this.s) {
            this.s.add(tSHeartbeatCallback);
        }
    }

    private void a(TSActivityChangeCallback tSActivityChangeCallback) {
        synchronized (this.t) {
            this.t.add(tSActivityChangeCallback);
        }
    }

    private void a(TSPowerSaveChangeCallback tSPowerSaveChangeCallback) {
        synchronized (this.u) {
            this.u.add(tSPowerSaveChangeCallback);
        }
    }

    private void a(TSLocationProviderChangeCallback tSLocationProviderChangeCallback) {
        synchronized (this.v) {
            this.v.add(tSLocationProviderChangeCallback);
        }
    }

    private void a(TSConnectivityChangeCallback tSConnectivityChangeCallback) {
        synchronized (this.q) {
            this.q.add(tSConnectivityChangeCallback);
        }
    }

    private void a(TSEnabledChangeCallback tSEnabledChangeCallback) {
        synchronized (this.p) {
            this.p.add(tSEnabledChangeCallback);
        }
    }

    private void a(TSScheduleCallback tSScheduleCallback) {
        synchronized (this.w) {
            this.w.add(tSScheduleCallback);
        }
    }

    private void a(TSGeofencesChangeCallback tSGeofencesChangeCallback) {
        TSGeofenceManager.getInstance(this.g).onGeofencesChange(tSGeofencesChangeCallback);
    }

    private void a(TSGeofenceCallback tSGeofenceCallback) {
        synchronized (this.f98o) {
            this.f98o.add(tSGeofenceCallback);
        }
    }

    private void a(TSNotificationActionCallback tSNotificationActionCallback) {
        synchronized (this.z) {
            this.z.add(tSNotificationActionCallback);
        }
    }

    private void a(TSPlayServicesConnectErrorCallback tSPlayServicesConnectErrorCallback) {
        synchronized (this.x) {
            this.x.add(tSPlayServicesConnectErrorCallback);
        }
    }

    private void a(int i) {
        getUiHandler().post(new B(i));
    }

    private void a(TSSecurityExceptionCallback tSSecurityExceptionCallback) {
        synchronized (this.y) {
            this.y.add(tSSecurityExceptionCallback);
        }
    }

    private void a(ScheduleEvent scheduleEvent) {
        getUiHandler().post(new C(scheduleEvent));
    }

    private void a(ActivityTransitionEvent activityTransitionEvent) {
        getUiHandler().post(new D(activityTransitionEvent));
    }

    private void a(TSLocation tSLocation) {
        getUiHandler().post(new E(tSLocation));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LocationProviderChangeEvent locationProviderChangeEvent) {
        getUiHandler().post(new I(locationProviderChangeEvent));
    }

    private void a(HeartbeatEvent heartbeatEvent) {
        getUiHandler().post(new J(heartbeatEvent));
    }

    private void a(GeofenceEvent geofenceEvent) {
        getUiHandler().post(new K(geofenceEvent));
    }

    private void a(MotionChangeEvent motionChangeEvent) {
        getUiHandler().post(new L(motionChangeEvent));
    }

    private void a() {
        TSLog.logger.debug(TSLog.off("Cleared callbacks"));
        if (this.l != null) {
            this.l = null;
        }
        TSGeofenceManager.getInstance(this.g).removeListeners();
        HttpService.getInstance(this.g).removeListeners();
        synchronized (this) {
            this.m.clear();
            this.f97n.clear();
            this.f98o.clear();
            this.r.clear();
            this.s.clear();
            this.t.clear();
            this.u.clear();
            this.w.clear();
            this.x.clear();
            this.v.clear();
            this.q.clear();
            this.p.clear();
            this.z.clear();
        }
    }

    /* JADX INFO: renamed from: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation$o, reason: case insensitive filesystem */
    /* JADX INFO: loaded from: classes6.dex */
    public class RunnableC0361o implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ TSHasGeofenceCallback b;
        private static final byte[] $$c = {5, Ascii.FF, -27, -23};
        private static final int $$d = 15;
        private static int $10 = 0;
        private static int $11 = 1;
        private static final byte[] $$a = {75, 100, -62, Ascii.SYN, -31, -17, -4, 38, -49, -3, -8, 10, -24, Ascii.US, -22, -22, 10, -7, -12, -2, -22, Ascii.DLE, -18, 9, -20, 44, -35, -20, -9, 6, -11, -4, 0, -10, 2, Ascii.GS, -46, 8, -6, -15, 2, -4, 9, -20, Ascii.FS, -26, -18, 10, -5, -11, 2, 19, -39, 6, -6, Ascii.ESC, -46, 8, -6, -15, 2, -4, Ascii.CR, -24, -13, -7, -12, Ascii.FF, -4, 50, -50, -14};
        private static final int $$b = 43;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static char[] ArtificialStackFrames = {44404, 44702, 44405, 44385, 44334, 44400, 44392, 44333, 44393, 44395, 44361, 44699, 44391, 44387, 44390, 44399, 44403, 44388, 44355, 44386, 44700, 44389, 44402, 44696, 44697, 44408, 44384, 44703, 44396, 44698, 44397, 44337, 44398, 44353, 44335, 44394};
        private static char coroutineCreation = 39068;

        /* JADX INFO: renamed from: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation$o$a */
        class a implements Runnable {
            final /* synthetic */ boolean a;

            a(boolean z) {
                this.a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                RunnableC0361o.this.b.onComplete(this.a);
            }
        }

        private static String $$e(int i, int i2, int i3) {
            int i4 = 4 - (i * 2);
            byte[] bArr = $$c;
            int i5 = i3 + 97;
            int i6 = i2 * 4;
            byte[] bArr2 = new byte[1 - i6];
            int i7 = 0 - i6;
            int i8 = -1;
            if (bArr == null) {
                i8 = -1;
                i5 = (-i4) + i5;
                i4++;
            }
            while (true) {
                int i9 = i8 + 1;
                bArr2[i9] = (byte) i5;
                if (i9 == i7) {
                    return new String(bArr2, 0);
                }
                int i10 = i5;
                i8 = i9;
                i5 = (-bArr[i4]) + i10;
                i4++;
            }
        }

        RunnableC0361o(String str, TSHasGeofenceCallback tSHasGeofenceCallback) {
            this.a = str;
            this.b = tSHasGeofenceCallback;
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0022  */
        /* JADX WARN: Code duplicated, block: B:8:0x001a  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0027). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static void d(int r7, byte r8, byte r9, java.lang.Object[] r10) {
            /*
                int r9 = r9 + 66
                int r8 = 69 - r8
                byte[] r0 = com.transistorsoft.locationmanager.adapter.BackgroundGeolocation.RunnableC0361o.$$a
                int r7 = 28 - r7
                byte[] r1 = new byte[r7]
                r2 = 0
                if (r0 != 0) goto L10
                r3 = r7
                r4 = r2
                goto L27
            L10:
                r3 = r2
            L11:
                int r4 = r3 + 1
                byte r5 = (byte) r9
                r1[r3] = r5
                int r8 = r8 + 1
                if (r4 != r7) goto L22
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L22:
                r3 = r0[r8]
                r6 = r3
                r3 = r9
                r9 = r6
            L27:
                int r9 = -r9
                int r3 = r3 + r9
                int r9 = r3 + (-5)
                r3 = r4
                goto L11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation.RunnableC0361o.d(int, byte, byte, java.lang.Object[]):void");
        }

        @Override // java.lang.Runnable
        public void run() {
            BackgroundGeolocation.getUiHandler().post(new a(GeofenceDAO.getInstance(BackgroundGeolocation.this.g).exists(this.a)));
        }

        private static void e(int i, char[] cArr, byte b, Object[] objArr) throws Throwable {
            int i2;
            int i3 = 2 % 2;
            extraCallback extracallback = new extraCallback();
            char[] cArr2 = ArtificialStackFrames;
            int i4 = -1819279892;
            if (cArr2 != null) {
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                int i5 = 0;
                while (i5 < length) {
                    try {
                        Object[] objArr2 = {Integer.valueOf(cArr2[i5])};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i4);
                        if (objAccessartificialFrame == null) {
                            byte b2 = (byte) 0;
                            byte b3 = b2;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(View.MeasureSpec.getSize(0) + 15, (char) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 20488), TextUtils.getCapsMode("", 0, 0) + 2148, 216710116, false, $$e(b2, b3, b3), new Class[]{Integer.TYPE});
                        }
                        cArr3[i5] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                        i5++;
                        int i6 = $10 + 15;
                        $11 = i6 % 128;
                        int i7 = i6 % 2;
                        i4 = -1819279892;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                int i8 = $11 + 105;
                $10 = i8 % 128;
                int i9 = i8 % 2;
                cArr2 = cArr3;
            }
            Object[] objArr3 = {Integer.valueOf(coroutineCreation)};
            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1819279892);
            if (objAccessartificialFrame2 == null) {
                byte b4 = (byte) 0;
                byte b5 = b4;
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(KeyEvent.getDeadChar(0, 0) + 15, (char) (Color.alpha(0) + 20488), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 2148, 216710116, false, $$e(b4, b5, b5), new Class[]{Integer.TYPE});
            }
            char cCharValue = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
            char[] cArr4 = new char[i];
            if (i % 2 != 0) {
                i2 = i - 1;
                cArr4[i2] = (char) (cArr[i2] - b);
            } else {
                i2 = i;
            }
            if (i2 > 1) {
                extracallback.a = 0;
                while (extracallback.a < i2) {
                    extracallback.createBrowser = cArr[extracallback.a];
                    extracallback.c = cArr[extracallback.a + 1];
                    if (extracallback.createBrowser == extracallback.c) {
                        int i10 = $10 + 93;
                        $11 = i10 % 128;
                        int i11 = i10 % 2;
                        cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                        cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                        int i12 = $10 + 63;
                        $11 = i12 % 128;
                        int i13 = i12 % 2;
                    } else {
                        Object[] objArr4 = {extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1894223152);
                        if (objAccessartificialFrame3 == null) {
                            byte b6 = (byte) 0;
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getKeyRepeatDelay() >> 16) + 46, (char) (58859 - (KeyEvent.getMaxKeyCode() >> 16)), (ViewConfiguration.getScrollBarSize() >> 8) + 2464, 276640984, false, $$e(b6, b6, $$c[0]), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                        }
                        if (((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue() == extracallback.g) {
                            Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1361113423);
                            if (objAccessartificialFrame4 == null) {
                                byte b7 = (byte) 0;
                                byte b8 = b7;
                                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(24 - Color.green(0), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)), Color.alpha(0) + 792, -834291897, false, $$e(b7, b8, (byte) (b8 | 8)), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                            }
                            int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                            int i14 = (extracallback.d * cCharValue) + extracallback.g;
                            cArr4[extracallback.a] = cArr2[iIntValue];
                            cArr4[extracallback.a + 1] = cArr2[i14];
                        } else if (extracallback.b == extracallback.d) {
                            extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                            extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                            int i15 = (extracallback.b * cCharValue) + extracallback.j;
                            int i16 = (extracallback.d * cCharValue) + extracallback.g;
                            cArr4[extracallback.a] = cArr2[i15];
                            cArr4[extracallback.a + 1] = cArr2[i16];
                        } else {
                            int i17 = (extracallback.b * cCharValue) + extracallback.g;
                            int i18 = (extracallback.d * cCharValue) + extracallback.j;
                            cArr4[extracallback.a] = cArr2[i17];
                            cArr4[extracallback.a + 1] = cArr2[i18];
                        }
                    }
                    extracallback.a += 2;
                }
            }
            int i19 = 0;
            while (i19 < i) {
                int i20 = $11 + 75;
                $10 = i20 % 128;
                if (i20 % 2 != 0) {
                    cArr4[i19] = (char) (cArr4[i19] ^ 21562);
                    i19 += 24;
                } else {
                    cArr4[i19] = (char) (cArr4[i19] ^ 13722);
                    i19++;
                }
            }
            objArr[0] = new String(cArr4);
        }

        /* JADX WARN: Code duplicated, block: B:49:0x0558  */
        /* JADX WARN: Code duplicated, block: B:51:0x055e  */
        /* JADX WARN: Code duplicated, block: B:53:0x057c  */
        /* JADX WARN: Code duplicated, block: B:54:0x057e  */
        /* JADX WARN: Code duplicated, block: B:57:0x058c  */
        /* JADX WARN: Code duplicated, block: B:58:0x059a  */
        /* JADX WARN: Code duplicated, block: B:61:0x060a  */
        /* JADX WARN: Code duplicated, block: B:62:0x061c  */
        /* JADX WARN: Code restructure failed: missing block: B:94:0x093f, code lost:
        
            if (r0.equals((java.lang.String) r8[0]) != false) goto L95;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.lang.Object[] coroutineBoundary(android.content.Context r29, int r30, int r31, int r32) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 3043
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.adapter.BackgroundGeolocation.RunnableC0361o.coroutineBoundary(android.content.Context, int, int, int):java.lang.Object[]");
        }
    }
}
