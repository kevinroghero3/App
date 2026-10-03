package com.transistorsoft.locationmanager.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import app.notifee.core.event.LogEvent;
import com.facebook.react.uimanager.ViewProps;
import com.transistorsoft.locationmanager.adapter.callback.TSCallback;
import com.transistorsoft.locationmanager.config.TSAuthorization;
import com.transistorsoft.locationmanager.config.TSBackgroundPermissionRationale;
import com.transistorsoft.locationmanager.config.TSCrashDetector;
import com.transistorsoft.locationmanager.config.TSNotification;
import com.transistorsoft.locationmanager.device.DeviceInfo;
import com.transistorsoft.locationmanager.event.ConfigChangeEvent;
import com.transistorsoft.locationmanager.http.HttpService;
import com.transistorsoft.locationmanager.lifecycle.LifecycleManager;
import com.transistorsoft.locationmanager.location.TSLocation;
import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.locationmanager.logger.TSMediaPlayer;
import com.transistorsoft.locationmanager.plugin.TSPlugin;
import com.transistorsoft.locationmanager.service.ForegroundNotification;
import com.transistorsoft.locationmanager.service.TrackingService;
import com.transistorsoft.locationmanager.settings.Settings;
import com.transistorsoft.locationmanager.util.LocationAuthorization;
import com.transistorsoft.locationmanager.util.Sensors;
import com.transistorsoft.locationmanager.util.Util;
import com.transistorsoft.tsbackgroundfetch.BackgroundFetchConfig;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TSConfig {
    public static final long DEFAULT_ACTIVITY_RECOGNITION_INTERVAL = 10000;
    public static final boolean DEFAULT_ALLOW_IDENTICAL_LOCATIONS = false;
    public static final boolean DEFAULT_AUTO_SYNC = true;
    public static final boolean DEFAULT_BATCH_SYNC = false;
    public static final boolean DEFAULT_DEBUG = false;
    public static final long DEFAULT_DEFER_TIME = 0;
    public static final int DEFAULT_DESIRED_ACCURACY = 100;
    public static final float DEFAULT_DESIRED_ODOMETER_ACCURACY = 100.0f;
    public static final boolean DEFAULT_DISABLE_ELASTICITY = false;
    public static final boolean DEFAULT_DISABLE_STOP_DETECTION = false;
    public static final float DEFAULT_DISTANCE_FILTER = 10.0f;
    public static final float DEFAULT_ELASTICITY_MULTIPLIER = 1.0f;
    public static final long DEFAULT_FASTEST_LOCATION_UPDATE_INTERVAL = -1;
    public static final boolean DEFAULT_FOREGROUND_SERVICE = true;
    public static final boolean DEFAULT_GEOFENCE_INITIAL_TRIGGER_ENTRY = true;
    public static final long DEFAULT_GEOFENCE_PROXIMITY_RADIUS = 1000;
    public static final String DEFAULT_GEOFENCE_TEMPLATE = "";
    public static final int DEFAULT_HEARTBEAT_INTERVAL = -1;
    public static final String DEFAULT_HTTP_METHOD = "POST";
    public static final String DEFAULT_HTTP_ROOT_PROPERTY = "location";
    public static final int DEFAULT_HTTP_TIMEOUT = 60000;
    public static final String DEFAULT_LOCATIONS_ORDER_DIRECTION = "ASC";
    public static final String DEFAULT_LOCATION_TEMPLATE = "";
    public static final int DEFAULT_LOCATION_TIMEOUT = 60;
    public static final long DEFAULT_LOCATION_UPDATE_INTERVAL = 1000;
    public static final int DEFAULT_LOG_LEVEL = 0;
    public static final int DEFAULT_LOG_MAX_DAYS = 3;
    public static final int DEFAULT_MAX_BATCH_SIZE = -1;
    public static final int DEFAULT_MAX_DAYS_TO_PERSIST = 1;
    public static final int DEFAULT_MAX_RECORDS_TO_PERSIST = -1;
    public static final int DEFAULT_MINIMUM_ACTIVITY_RECOGNITION_CONFIDENCE = 75;
    public static final int DEFAULT_SPEED_JUMP_FILTER = 300;
    public static final boolean DEFAULT_START_ON_BOOT = false;
    public static final int DEFAULT_STATIONARY_RADIUS = 25;
    public static final int DEFAULT_STOP_AFTER_ELAPSED_MINUTES = 0;
    public static final boolean DEFAULT_STOP_ON_STATIONARY = false;
    public static final boolean DEFAULT_STOP_ON_TERMINATE = true;
    public static final long DEFAULT_STOP_TIMEOUT = 5;
    public static final String DEFAULT_TRIGGER_ACTIVITIES = "in_vehicle, on_bicycle, on_foot, running, walking";
    public static final String DEFAULT_URL = "";
    public static final int MINIMUM_STATIONARY_RADIUS = 25;
    public static final int PERSIST_MODE_ALL = 2;
    public static final int PERSIST_MODE_GEOFENCE = -1;
    public static final int PERSIST_MODE_LOCATION = 1;
    public static final int PERSIST_MODE_NONE = 0;
    public static final int TRACKING_MODE_GEOFENCE = 0;
    public static final int TRACKING_MODE_LOCATION = 1;
    private Builder f;
    private Context g;
    private Boolean i;
    private Integer j;
    private Boolean k;
    private Boolean l;
    private Boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Float f99n;
    private boolean p;
    private Boolean q;
    private Boolean r;
    private String s;
    private JSONObject t;
    private ArrayList<Integer> u;
    private static final AtomicBoolean a = new AtomicBoolean(false);
    private static final AtomicBoolean b = new AtomicBoolean(false);
    private static TSConfig c = null;
    private static String d = "TSLocationManager:TSConfig";
    public static final Float MAXIMUM_LOCATION_ACCURACY = Float.valueOf(100.0f);
    public static final Integer DEFAULT_AUTO_SYNC_THRESHOLD = 0;
    public static final String DEFAULT_MAIN_ACTIVITY_NAME = null;
    public static final ArrayList<String> DEFAULT_SCHEDULE = new ArrayList<>();
    private static AtomicBoolean e = new AtomicBoolean(false);
    private AtomicBoolean h = new AtomicBoolean(false);
    private final Map<String, ArrayList<OnChangeCallback>> v = new HashMap();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Boolean f100o = Boolean.TRUE;

    /* JADX INFO: loaded from: classes3.dex */
    public static class Builder {
        private static final Set<String> IGNORED_FIELDS = new HashSet(Arrays.asList("dirtyFields"));
        private Long activityRecognitionInterval;
        private Boolean allowIdenticalLocations;
        private TSAuthorization authorization;
        private Boolean autoSync;
        private Integer autoSyncThreshold;
        private TSBackgroundPermissionRationale backgroundPermissionRationale;
        private Boolean batchSync;
        private String configUrl;
        private TSCrashDetector crashDetector;
        private Boolean debug;
        private Long deferTime;
        private Integer desiredAccuracy;
        private Float desiredOdometerAccuracy;
        private final List<String> dirtyFields = new ArrayList();
        private Boolean disableAutoSyncOnCellular;
        private Boolean disableElasticity;
        private Boolean disableLocationAuthorizationAlert;
        private Boolean disableMotionActivityUpdates;
        private Boolean disableProviderChangeRecord;
        private Boolean disableStopDetection;
        private Float distanceFilter;
        private Float elasticityMultiplier;
        private Boolean enableHeadless;
        private Boolean enableTimestampMeta;
        private JSONObject extras;
        private Long fastestLocationUpdateInterval;
        private Boolean foregroundService;
        private Boolean geofenceInitialTriggerEntry;
        private Boolean geofenceModeHighAccuracy;
        private Long geofenceProximityRadius;
        private String geofenceTemplate;
        private JSONObject headers;
        private String headlessJobService;
        private Integer heartbeatInterval;
        private String httpRootProperty;
        private Integer httpTimeout;
        private Boolean isMoving;
        private String locationAuthorizationRequest;
        private String locationTemplate;
        private Integer locationTimeout;
        private Long locationUpdateInterval;
        private String locationsOrderDirection;
        private Integer logLevel;
        private Integer logMaxDays;
        private Integer maxBatchSize;
        private Integer maxDaysToPersist;
        private Integer maxMonitoredGeofences;
        private Integer maxRecordsToPersist;
        private String method;
        private Integer minimumActivityRecognitionConfidence;
        private Long motionTriggerDelay;
        private TSNotification notification;
        private JSONObject params;
        private Boolean persist;
        private Integer persistMode;
        private List<String> schedule;
        private Boolean scheduleUseAlarmManager;
        private Integer speedJumpFilter;
        private Boolean startOnBoot;
        private Integer stationaryRadius;
        private Integer stopAfterElapsedMinutes;
        private Boolean stopOnStationary;
        private Boolean stopOnTerminate;
        private Long stopTimeout;
        private String triggerActivities;
        private String url;
        private Boolean useSignificantChangesOnly;

        public Builder() {
            a();
        }

        public void commit() {
            if (TSConfig.c != null) {
                TSConfig.c.c();
            }
        }

        public Builder setActivityRecognitionInterval(Long l) {
            this.activityRecognitionInterval = a("activityRecognitionInterval", l, this.activityRecognitionInterval);
            return this;
        }

        public Builder setAllowIdenticalLocations(Boolean bool) {
            this.allowIdenticalLocations = a("allowIdenticalLocations", bool, this.allowIdenticalLocations);
            return this;
        }

        public Builder setAuthorization(TSAuthorization tSAuthorization) {
            if (this.authorization.update(tSAuthorization)) {
                a("authorization");
                a((List<String>) this.authorization.getDirtyFields());
            }
            this.authorization.applyDefaults();
            return this;
        }

        public Builder setAutoSync(Boolean bool) {
            this.autoSync = a("autoSync", bool, this.autoSync);
            return this;
        }

        public Builder setAutoSyncThreshold(Integer num) {
            this.autoSyncThreshold = a("autoSyncThreshold", num, this.autoSyncThreshold);
            return this;
        }

        public Builder setBackgroundPermissionRationale(TSBackgroundPermissionRationale tSBackgroundPermissionRationale) {
            if (this.backgroundPermissionRationale.update(tSBackgroundPermissionRationale)) {
                a(TSBackgroundPermissionRationale.NAME);
                a((List<String>) this.backgroundPermissionRationale.getDirtyFields());
            }
            this.backgroundPermissionRationale.applyDefaults();
            return this;
        }

        public Builder setBatchSync(Boolean bool) {
            this.batchSync = a("batchSync", bool, this.batchSync);
            return this;
        }

        public Builder setConfigUrl(String str) {
            this.configUrl = a("configUrl", str, this.configUrl);
            return this;
        }

        public Builder setCrashDetector(TSCrashDetector tSCrashDetector) {
            if (this.crashDetector.update(tSCrashDetector)) {
                a(TSCrashDetector.NAME);
                a((List<String>) this.crashDetector.getDirtyFields());
            }
            this.crashDetector.applyDefaults();
            return this;
        }

        public Builder setDebug(Boolean bool) {
            this.debug = a(LogEvent.LEVEL_DEBUG, bool, this.debug);
            return this;
        }

        public Builder setDeferTime(Long l) {
            if (l.longValue() < 0) {
                l = 0L;
            }
            this.deferTime = a("deferTime", l, this.deferTime);
            return this;
        }

        public Builder setDesiredAccuracy(Integer num) {
            this.desiredAccuracy = a("desiredAccuracy", num, this.desiredAccuracy);
            return this;
        }

        public Builder setDesiredOdometerAccuracy(Float f) {
            this.desiredOdometerAccuracy = a("desiredOdometerAccuracy", f, this.desiredOdometerAccuracy);
            return this;
        }

        public Builder setDisableAutoSyncOnCellular(Boolean bool) {
            this.disableAutoSyncOnCellular = a("disableAutoSyncOnCellular", bool, this.disableAutoSyncOnCellular);
            return this;
        }

        public Builder setDisableElasticity(Boolean bool) {
            this.disableElasticity = a("disableElasticity", bool, this.disableElasticity);
            return this;
        }

        public Builder setDisableLocationAuthorizationAlert(Boolean bool) {
            this.disableLocationAuthorizationAlert = a("disableLocationAuthorizationAlert", bool, this.disableLocationAuthorizationAlert);
            return this;
        }

        public Builder setDisableMotionActivityUpdates(Boolean bool) {
            this.disableMotionActivityUpdates = a("disableMotionActivityUpdates", bool, this.disableMotionActivityUpdates);
            return this;
        }

        public Builder setDisableProviderChangeRecord(Boolean bool) {
            this.disableProviderChangeRecord = a("disableProviderChangeRecord", bool, this.disableProviderChangeRecord);
            return this;
        }

        public Builder setDisableStopDetection(Boolean bool) {
            this.disableStopDetection = a("disableStopDetection", bool, this.disableStopDetection);
            return this;
        }

        public Builder setDistanceFilter(Float f) {
            if (f.floatValue() < 0.0f) {
                TSLog.logger.warn(TSLog.warn("Invalid distanceFilter: " + f + ".  Applying DEFAULT_DISTANCE_FILTER: 10.0"));
                f = Float.valueOf(10.0f);
            }
            this.distanceFilter = a("distanceFilter", f, this.distanceFilter);
            return this;
        }

        public Builder setElasticityMultiplier(Float f) {
            this.elasticityMultiplier = a("elasticityMultiplier", f, this.elasticityMultiplier);
            return this;
        }

        public Builder setEnableHeadless(Boolean bool) {
            this.enableHeadless = a("enableHeadless", bool, this.enableHeadless);
            return this;
        }

        public Builder setEnableTimestampMeta(Boolean bool) {
            this.enableTimestampMeta = a("enableTimestampMeta", bool, this.enableTimestampMeta);
            return this;
        }

        public Builder setExtras(JSONObject jSONObject) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            this.extras = a("extras", jSONObject, this.extras);
            return this;
        }

        public Builder setFastestLocationUpdateInterval(Long l) {
            this.fastestLocationUpdateInterval = a("fastestLocationUpdateInterval", l, this.fastestLocationUpdateInterval);
            return this;
        }

        public Builder setForegroundService(Boolean bool) {
            this.foregroundService = a("foregroundService", bool, this.foregroundService);
            return this;
        }

        public Builder setGeofenceInitialTriggerEntry(Boolean bool) {
            this.geofenceInitialTriggerEntry = a("geofenceInitialTriggerEntry", bool, this.geofenceInitialTriggerEntry);
            return this;
        }

        public Builder setGeofenceModeHighAccuracy(Boolean bool) {
            this.geofenceModeHighAccuracy = a("geofenceModeHighAccuracy", bool, this.geofenceModeHighAccuracy);
            return this;
        }

        public Builder setGeofenceProximityRadius(Long l) {
            this.geofenceProximityRadius = a("geofenceProximityRadius", Long.valueOf(l.longValue() >= 1000 ? l.longValue() : 1000L), this.geofenceProximityRadius);
            return this;
        }

        public Builder setGeofenceTemplate(String str) {
            if (str == null) {
                str = "";
            }
            this.geofenceTemplate = a("geofenceTemplate", str, this.geofenceTemplate);
            return this;
        }

        public Builder setHeader(String str, String str2) {
            if (this.headers == null) {
                this.headers = new JSONObject();
            }
            try {
                this.headers.put(str, str2);
                a("headers");
            } catch (JSONException e) {
                TSLog.logger.error(TSLog.error(e.getMessage()), (Throwable) e);
            }
            return this;
        }

        public Builder setHeaders(JSONObject jSONObject) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            this.headers = a("headers", jSONObject, this.headers);
            return this;
        }

        public Builder setHeadlessJobService(String str) {
            this.headlessJobService = a("headlessJobService", str, this.headlessJobService);
            return this;
        }

        public Builder setHeartbeatInterval(Integer num) {
            this.heartbeatInterval = a("heartbeatInterval", num, this.heartbeatInterval);
            return this;
        }

        public Builder setHttpRootProperty(String str) {
            this.httpRootProperty = a("httpRootProperty", str, this.httpRootProperty);
            return this;
        }

        public Builder setHttpTimeout(Integer num) {
            this.httpTimeout = a("httpTimeout", num, this.httpTimeout);
            return this;
        }

        public Builder setIsMoving(Boolean bool) {
            this.isMoving = a("isMoving", bool, this.isMoving);
            return this;
        }

        public Builder setLocationAuthorizationRequest(String str) {
            this.locationAuthorizationRequest = a("locationAuthorizationRequest", str, this.locationAuthorizationRequest);
            return this;
        }

        public Builder setLocationTemplate(String str) {
            if (str == null) {
                str = "";
            }
            this.locationTemplate = a("locationTemplate", str, this.locationTemplate);
            return this;
        }

        public Builder setLocationTimeout(Integer num) {
            this.locationTimeout = a("locationTimeout", num, this.locationTimeout);
            return this;
        }

        public Builder setLocationUpdateInterval(Long l) {
            this.locationUpdateInterval = a("locationUpdateInterval", l, this.locationUpdateInterval);
            return this;
        }

        public Builder setLocationsOrderDirection(String str) {
            this.locationsOrderDirection = a("locationsOrderDirection", str, this.locationsOrderDirection);
            return this;
        }

        public Builder setLogLevel(Integer num) {
            this.logLevel = a("logLevel", num, this.logLevel);
            return this;
        }

        public Builder setLogMaxDays(Integer num) {
            this.logMaxDays = a("logMaxDays", num, this.logMaxDays);
            return this;
        }

        public Builder setMaxBatchSize(Integer num) {
            this.maxBatchSize = a(com.salesforce.marketingcloud.config.a.k, num, this.maxBatchSize);
            return this;
        }

        public Builder setMaxDaysToPersist(Integer num) {
            this.maxDaysToPersist = a("maxDaysToPersist", num, this.maxDaysToPersist);
            return this;
        }

        public Builder setMaxMonitoredGeofences(Integer num) {
            this.maxMonitoredGeofences = a("maxMonitoredGeofences", Integer.valueOf(num.intValue() <= 97 ? num.intValue() : 97), this.maxMonitoredGeofences);
            return this;
        }

        public Builder setMaxRecordsToPersist(Integer num) {
            this.maxRecordsToPersist = a("maxRecordsToPersist", num, this.maxRecordsToPersist);
            return this;
        }

        public Builder setMethod(String str) {
            this.method = a("method", str, this.method);
            return this;
        }

        public Builder setMinimumActivityRecognitionConfidence(Integer num) {
            this.minimumActivityRecognitionConfidence = a("minimumActivityRecognitionConfidence", num, this.minimumActivityRecognitionConfidence);
            return this;
        }

        public Builder setMotionTriggerDelay(Long l) {
            this.motionTriggerDelay = a("motionTriggerDelay", l, this.motionTriggerDelay);
            return this;
        }

        public Builder setNotification(TSNotification tSNotification) {
            if (this.notification.update(tSNotification)) {
                a(TSNotification.NAME);
                a((List<String>) this.notification.getDirtyFields());
            }
            this.notification.applyDefaults();
            return this;
        }

        public Builder setParams(JSONObject jSONObject) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            this.params = a("params", jSONObject, this.params);
            return this;
        }

        public Builder setPersist(Boolean bool) {
            this.persist = a("persist", bool, this.persist);
            return this;
        }

        public Builder setPersistMode(Integer num) {
            int iIntValue = num.intValue();
            if (iIntValue != -1 && iIntValue != 0 && iIntValue != 1 && iIntValue != 2) {
                TSLog.logger.warn(TSLog.warn("Invalid value for persistMode: " + num + ".  Using default value: 2"));
                num = 2;
            }
            this.persistMode = a("persistMode", num, this.persistMode);
            return this;
        }

        public Builder setSchedule(List<String> list) {
            this.schedule = a("schedule", list, this.schedule);
            return this;
        }

        public Builder setScheduleUseAlarmManager(Boolean bool) {
            this.scheduleUseAlarmManager = a("scheduleUseAlarmManager", bool, this.scheduleUseAlarmManager);
            return this;
        }

        public Builder setSpeedJumpFilter(Integer num) {
            this.speedJumpFilter = a("speedJumpFilter", num, this.speedJumpFilter);
            return this;
        }

        public Builder setStartOnBoot(Boolean bool) {
            this.startOnBoot = a("startOnBoot", bool, this.startOnBoot);
            return this;
        }

        public Builder setStationaryRadius(Integer num) {
            this.stationaryRadius = a("stationaryRadius", num, this.stationaryRadius);
            return this;
        }

        public Builder setStopAfterElapsedMinutes(Integer num) {
            this.stopAfterElapsedMinutes = a("stopAfterElapsedMinutes", num, this.stopAfterElapsedMinutes);
            return this;
        }

        public Builder setStopOnStationary(Boolean bool) {
            this.stopOnStationary = a("stopOnStationary", bool, this.stopOnStationary);
            return this;
        }

        public Builder setStopOnTerminate(Boolean bool) {
            this.stopOnTerminate = a(BackgroundFetchConfig.FIELD_STOP_ON_TERMINATE, bool, this.stopOnTerminate);
            return this;
        }

        public Builder setStopTimeout(Long l) {
            this.stopTimeout = a("stopTimeout", l, this.stopTimeout);
            return this;
        }

        public Builder setTriggerActivities(String str) {
            this.triggerActivities = a("triggerActivities", str, this.triggerActivities);
            return this;
        }

        public Builder setUrl(String str) {
            this.url = a("url", str, this.url);
            return this;
        }

        public Builder setUseSignificantChangesOnly(Boolean bool) {
            this.useSignificantChangesOnly = a("useSignificantChangesOnly", bool, this.useSignificantChangesOnly);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Builder b() {
            synchronized (this.dirtyFields) {
                this.dirtyFields.clear();
            }
            return this;
        }

        private void a() {
            this.distanceFilter = Float.valueOf(10.0f);
            this.desiredAccuracy = 100;
            if (TSConfig.c != null && TSConfig.c.r.booleanValue()) {
                this.desiredAccuracy = 0;
            }
            this.desiredOdometerAccuracy = Float.valueOf(100.0f);
            this.locationUpdateInterval = 1000L;
            this.fastestLocationUpdateInterval = -1L;
            this.locationTimeout = 60;
            this.deferTime = 0L;
            Boolean bool = Boolean.FALSE;
            this.disableElasticity = bool;
            this.elasticityMultiplier = Float.valueOf(1.0f);
            this.allowIdenticalLocations = bool;
            this.enableTimestampMeta = bool;
            this.speedJumpFilter = 300;
            this.useSignificantChangesOnly = bool;
            this.locationAuthorizationRequest = LocationAuthorization.AUTHORIZATION_REQUEST_ALWAYS;
            this.disableLocationAuthorizationAlert = bool;
            this.isMoving = bool;
            this.activityRecognitionInterval = 10000L;
            this.minimumActivityRecognitionConfidence = 75;
            this.triggerActivities = "in_vehicle, on_bicycle, on_foot, running, walking";
            this.disableStopDetection = bool;
            this.disableMotionActivityUpdates = bool;
            this.stationaryRadius = 25;
            this.stopTimeout = 5L;
            this.stopOnStationary = bool;
            this.motionTriggerDelay = 0L;
            Boolean bool2 = Boolean.TRUE;
            this.persist = bool2;
            this.persistMode = 2;
            this.maxDaysToPersist = 1;
            this.maxRecordsToPersist = -1;
            this.url = "";
            this.method = "POST";
            this.autoSync = bool2;
            this.autoSyncThreshold = TSConfig.DEFAULT_AUTO_SYNC_THRESHOLD;
            this.batchSync = bool;
            this.maxBatchSize = -1;
            this.params = new JSONObject();
            this.headers = new JSONObject();
            this.extras = new JSONObject();
            this.httpRootProperty = "location";
            this.locationTemplate = "";
            this.geofenceTemplate = "";
            this.locationsOrderDirection = "ASC";
            this.httpTimeout = 60000;
            this.disableAutoSyncOnCellular = bool;
            this.disableProviderChangeRecord = bool;
            TSAuthorization tSAuthorization = new TSAuthorization();
            this.authorization = tSAuthorization;
            tSAuthorization.applyDefaults();
            this.geofenceProximityRadius = 1000L;
            this.maxMonitoredGeofences = 97;
            this.geofenceInitialTriggerEntry = bool2;
            this.geofenceModeHighAccuracy = bool;
            this.stopOnTerminate = bool2;
            this.startOnBoot = bool;
            this.stopAfterElapsedMinutes = 0;
            this.heartbeatInterval = -1;
            this.foregroundService = bool2;
            TSNotification tSNotification = new TSNotification();
            this.notification = tSNotification;
            tSNotification.applyDefaults();
            TSCrashDetector tSCrashDetector = new TSCrashDetector();
            this.crashDetector = tSCrashDetector;
            tSCrashDetector.applyDefaults();
            TSBackgroundPermissionRationale tSBackgroundPermissionRationale = new TSBackgroundPermissionRationale();
            this.backgroundPermissionRationale = tSBackgroundPermissionRationale;
            tSBackgroundPermissionRationale.applyDefaults();
            this.configUrl = "";
            this.schedule = TSConfig.DEFAULT_SCHEDULE;
            this.scheduleUseAlarmManager = bool;
            this.headlessJobService = "";
            this.enableHeadless = bool;
            this.debug = bool;
            this.logLevel = 0;
            this.logMaxDays = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject b(boolean z) {
            JSONObject jSONObject = new JSONObject();
            try {
                for (Field field : getClass().getDeclaredFields()) {
                    if (a(field)) {
                        String name = field.getName();
                        Object obj = field.get(this);
                        if (obj != null) {
                            if (field.getType() == Map.class) {
                                jSONObject.put(name, new JSONObject((Map) obj));
                            } else if (field.getType() == List.class) {
                                JSONArray jSONArray = new JSONArray();
                                if (obj.getClass() == ArrayList.class) {
                                    Iterator it2 = ((List) obj).iterator();
                                    while (it2.hasNext()) {
                                        jSONArray.put(it2.next());
                                    }
                                    jSONObject.put(name, jSONArray);
                                }
                            } else if (field.getType() == Integer.class) {
                                jSONObject.put(name, ((Integer) obj).intValue());
                            } else if (field.getType() == Long.class) {
                                jSONObject.put(name, ((Long) obj).longValue());
                            } else if (field.getType() == Double.class) {
                                jSONObject.put(name, ((Double) obj).doubleValue());
                            } else if (field.getType() == Float.class) {
                                jSONObject.put(name, ((Float) obj).doubleValue());
                            } else if (field.getType() == TSNotification.class) {
                                jSONObject.put(name, ((TSNotification) obj).toJson(z));
                            } else if (field.getType() == TSCrashDetector.class) {
                                jSONObject.put(name, ((TSCrashDetector) obj).toJson(false));
                            } else if (field.getType() == TSAuthorization.class) {
                                jSONObject.put(name, ((TSAuthorization) obj).toJson(z));
                            } else if (field.getType() == TSBackgroundPermissionRationale.class) {
                                jSONObject.put(name, ((TSBackgroundPermissionRationale) obj).toJson(z));
                            } else {
                                jSONObject.put(name, obj);
                            }
                        }
                    }
                }
            } catch (IllegalAccessException e) {
                Log.i("TSLocationManager", TSLog.error(e.getMessage()));
                TSLog.logger.error(TSLog.error(e.getMessage()), (Throwable) e);
            } catch (JSONException e2) {
                Log.i("TSLocationManager", TSLog.error(e2.getMessage()));
                TSLog.logger.error(TSLog.error(e2.getMessage()), (Throwable) e2);
            }
            return jSONObject;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(boolean z) {
            Builder builder = new Builder();
            for (Field field : getClass().getDeclaredFields()) {
                if (a(field)) {
                    String name = field.getName();
                    try {
                        Method method = getClass().getMethod("set" + name.substring(0, 1).toUpperCase(Locale.ENGLISH) + name.substring(1), field.getType());
                        Object obj = field.get(builder);
                        if (obj != null) {
                            method.invoke(this, obj);
                        }
                    } catch (IllegalAccessException e) {
                        Log.e("TSLocationManager", TSLog.error(e.getMessage()), e);
                    } catch (NoSuchMethodException e2) {
                        Log.e("TSLocationManager", TSLog.error(e2.getMessage()), e2);
                    } catch (InvocationTargetException e3) {
                        Log.e("TSLocationManager", TSLog.error(e3.getMessage()), e3);
                    }
                }
            }
            if (z) {
                synchronized (this.dirtyFields) {
                    this.dirtyFields.clear();
                }
            }
            commit();
        }

        public Builder(JSONObject jSONObject) {
            a();
            for (Field field : getClass().getDeclaredFields()) {
                String name = field.getName();
                Class<?> type = field.getType();
                if (jSONObject.has(name) && a(field)) {
                    if (type == Boolean.class) {
                        try {
                            field.set(this, Boolean.valueOf(jSONObject.getBoolean(name)));
                        } catch (IllegalAccessException e) {
                            TSLog.logger.error(TSLog.error(e.getMessage()), (Throwable) e);
                        } catch (JSONException e2) {
                            TSLog.logger.error(TSLog.error(e2.getMessage()), (Throwable) e2);
                        }
                    } else if (type == Long.class) {
                        field.set(this, Long.valueOf(jSONObject.getLong(name)));
                    } else if (type == Integer.class) {
                        field.set(this, Integer.valueOf(jSONObject.getInt(name)));
                    } else if (type == Float.class) {
                        field.set(this, Float.valueOf((float) jSONObject.getDouble(name)));
                    } else if (type == Double.class) {
                        field.set(this, Double.valueOf(jSONObject.getDouble(name)));
                    } else if (type == JSONObject.class) {
                        field.set(this, jSONObject.getJSONObject(name));
                    } else if (type == JSONArray.class) {
                        field.set(this, jSONObject.getJSONArray(name));
                    } else if (type == List.class) {
                        JSONArray jSONArray = jSONObject.getJSONArray(name);
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            arrayList.add(jSONArray.getString(i));
                        }
                        field.set(this, arrayList);
                    } else if (type == Map.class) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject(name);
                        HashMap map = new HashMap();
                        Iterator<String> itKeys = jSONObject2.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            map.put(next, jSONObject2.getString(next));
                        }
                        field.set(this, map);
                    } else if (type == TSNotification.class) {
                        field.set(this, new TSNotification(jSONObject.getJSONObject(name), true));
                    } else if (type == TSCrashDetector.class) {
                        field.set(this, new TSCrashDetector(jSONObject.getJSONObject(name), true));
                    } else if (type == TSAuthorization.class) {
                        field.set(this, new TSAuthorization(jSONObject.getJSONObject(name), true));
                    } else if (type == TSBackgroundPermissionRationale.class) {
                        field.set(this, new TSBackgroundPermissionRationale(jSONObject.getJSONObject(name), true));
                    } else {
                        field.set(this, jSONObject.get(name));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(JSONObject jSONObject) {
            if (TSConfig.f()) {
                synchronized (this.dirtyFields) {
                    this.dirtyFields.clear();
                }
                for (Field field : getClass().getDeclaredFields()) {
                    String name = field.getName();
                    if (jSONObject.has(name) && a(field)) {
                        try {
                            Method method = getClass().getMethod("set" + name.substring(0, 1).toUpperCase(Locale.ENGLISH) + name.substring(1), field.getType());
                            if (field.getType() == Boolean.class) {
                                method.invoke(this, Boolean.valueOf(jSONObject.getBoolean(name)));
                            } else if (field.getType() == Long.class) {
                                method.invoke(this, Long.valueOf(jSONObject.getLong(name)));
                            } else if (field.getType() == Integer.class) {
                                method.invoke(this, Integer.valueOf(jSONObject.getInt(name)));
                            } else if (field.getType() == Float.class) {
                                method.invoke(this, Float.valueOf((float) jSONObject.getDouble(name)));
                            } else if (field.getType() == Double.class) {
                                method.invoke(this, Double.valueOf(jSONObject.getDouble(name)));
                            } else if (field.getType() == String.class) {
                                method.invoke(this, jSONObject.getString(name));
                            } else if (field.getType() == JSONObject.class) {
                                method.invoke(this, jSONObject.getJSONObject(name));
                            } else if (field.getType() == JSONArray.class) {
                                method.invoke(this, jSONObject.getJSONArray(name));
                            } else if (field.getType() == List.class) {
                                JSONArray jSONArray = jSONObject.getJSONArray(name);
                                ArrayList arrayList = new ArrayList();
                                for (int i = 0; i < jSONArray.length(); i++) {
                                    arrayList.add(jSONArray.getString(i));
                                }
                                method.invoke(this, arrayList);
                            } else if (field.getType() == Map.class) {
                                JSONObject jSONObject2 = jSONObject.getJSONObject(name);
                                HashMap map = new HashMap();
                                Iterator<String> itKeys = jSONObject2.keys();
                                while (itKeys.hasNext()) {
                                    String next = itKeys.next();
                                    map.put(next, jSONObject2.getString(next));
                                }
                                method.invoke(this, map);
                            } else if (field.getType() == TSNotification.class) {
                                method.invoke(this, new TSNotification(jSONObject.getJSONObject(name), false));
                            } else if (field.getType() == TSCrashDetector.class) {
                                method.invoke(this, new TSCrashDetector(jSONObject.getJSONObject(name), false));
                            } else if (field.getType() == TSAuthorization.class) {
                                method.invoke(this, new TSAuthorization(jSONObject.getJSONObject(name), false));
                            } else if (field.getType() == TSBackgroundPermissionRationale.class) {
                                method.invoke(this, new TSBackgroundPermissionRationale(jSONObject.getJSONObject(name), false));
                            } else {
                                method.invoke(this, jSONObject.get(name));
                            }
                        } catch (IllegalAccessException e) {
                            Log.i("TSLocationManager", TSLog.error(e.getMessage()), e);
                        } catch (NoSuchMethodException e2) {
                            Log.i("TSLocationManager", TSLog.error(e2.getMessage()), e2);
                        } catch (InvocationTargetException e3) {
                            Log.i("TSLocationManager", TSLog.error(e3.getMessage()), e3);
                        } catch (JSONException e4) {
                            Log.e("TSLocationManager", TSLog.error(e4.getMessage()), e4);
                        }
                    }
                }
            }
        }

        private void a(String str) {
            synchronized (this.dirtyFields) {
                if (this.dirtyFields.contains(str)) {
                    return;
                }
                this.dirtyFields.add(str);
            }
        }

        private void a(List<String> list) {
            synchronized (this.dirtyFields) {
                this.dirtyFields.addAll(list);
            }
        }

        private Boolean a(String str, Boolean bool, Boolean bool2) {
            if (!bool.equals(bool2)) {
                a(str);
            }
            return bool;
        }

        private String a(String str, String str2, String str3) {
            if (!str2.equals(str3)) {
                a(str);
            }
            return str2;
        }

        private Integer a(String str, Integer num, Integer num2) {
            if (!num.equals(num2)) {
                a(str);
            }
            return num;
        }

        private Long a(String str, Long l, Long l2) {
            if (!l.equals(l2)) {
                a(str);
            }
            return l;
        }

        private Double a(String str, Double d, Double d2) {
            if (!d.equals(d2)) {
                a(str);
            }
            return d;
        }

        private Float a(String str, Float f, Float f2) {
            if (!f.equals(f2)) {
                a(str);
            }
            return f;
        }

        private JSONObject a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            if (!jSONObject.equals(jSONObject2)) {
                a(str);
            }
            return jSONObject;
        }

        private JSONArray a(String str, JSONArray jSONArray, JSONArray jSONArray2) {
            if (!jSONArray.equals(jSONArray2)) {
                a(str);
            }
            return jSONArray;
        }

        private List<String> a(String str, List<String> list, List<String> list2) {
            if (!list2.containsAll(list) || list.isEmpty()) {
                if (list == null) {
                    list = list2;
                }
                a(str);
            }
            return list;
        }

        private Map<String, String> a(String str, Map<String, String> map, Map<String, String> map2) {
            if (map2 == null || !map2.equals(map)) {
                a(str);
            }
            return map;
        }

        private boolean a(Field field) {
            return (IGNORED_FIELDS.contains(field.getName()) || Modifier.isStatic(field.getModifiers())) ? false : true;
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public interface OnChangeCallback {
        void onChange(TSConfig tSConfig);
    }

    class a implements TSCallback {
        a() {
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSCallback
        public void onFailure(String str) {
            TSLog.logger.warn(TSLog.warn(str));
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSCallback
        public void onSuccess() {
            TSLog.logger.debug(TSLog.ok("loadConfig success"));
        }
    }

    class b implements Callback {
        final /* synthetic */ TSCallback a;

        b(TSCallback tSCallback) {
            this.a = tSCallback;
        }

        @Override // okhttp3.Callback
        public void onFailure(@NotNull Call call, IOException iOException) {
            this.a.onFailure("Failed to load configUrl: " + iOException.getMessage());
        }

        @Override // okhttp3.Callback
        public void onResponse(@NotNull Call call, @NotNull Response response) {
            try {
                if (!response.isSuccessful()) {
                    throw new IOException("Received unexpected code " + response + " from configUrl");
                }
                try {
                    ResponseBody responseBodyBody = response.body();
                    if (responseBodyBody == null) {
                        this.a.onFailure("Received empty response body from configUrl");
                        return;
                    }
                    TSConfig.this.updateWithJSONObject(new JSONObject(responseBodyBody.string()));
                    TSLog.logger.debug(TSLog.ok("loadConfig success"));
                    this.a.onSuccess();
                } catch (JSONException e) {
                    this.a.onFailure("Invalid JSON from configUrl: " + e.getMessage());
                }
            } catch (IOException unused) {
                this.a.onFailure("IOException from configUrl: " + response);
            }
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    class c implements Runnable {
        private c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(boolean z) {
            if (TSConfig.this.i.booleanValue() && TSConfig.this.getStopOnTerminate().booleanValue()) {
                TSConfig.this.setEnabled(Boolean.FALSE);
                TSLog.logger.info(TSLog.warn("Tracking initiated in background with stopOnTerminate: true.  Launch refused."));
                TrackingService.stop(TSConfig.this.g);
                if (z) {
                    BackgroundGeolocation.getInstance(TSConfig.this.g).onActivityDestroy();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            LifecycleManager.getInstance().onHeadlessChange(new LifecycleManager.OnHeadlessChangeCallback() { // from class: com.transistorsoft.locationmanager.adapter.TSConfig$c$$ExternalSyntheticLambda0
                @Override // com.transistorsoft.locationmanager.lifecycle.LifecycleManager.OnHeadlessChangeCallback
                public final void onChange(boolean z) {
                    this.f$0.a(z);
                }
            });
        }

        /* synthetic */ c(TSConfig tSConfig, a aVar) {
            this();
        }
    }

    public TSConfig(Context context) {
        this.g = context;
        Boolean bool = Boolean.FALSE;
        this.q = bool;
        this.i = bool;
        this.l = bool;
        this.j = 1;
        this.k = bool;
        this.p = false;
        this.f99n = Float.valueOf(0.0f);
        this.r = bool;
        this.s = DEFAULT_MAIN_ACTIVITY_NAME;
        this.t = new JSONObject();
        Settings.load(context);
        load();
        Builder builder = this.f;
        if (builder != null) {
            this.u = a(builder.triggerActivities);
        }
    }

    private void e() {
        synchronized (this.f.dirtyFields) {
            TSLog.logger.debug("ℹ️   Persist config, dirty: " + this.f.dirtyFields.toString());
            SharedPreferences.Editor editorEdit = this.g.getSharedPreferences(d, 0).edit();
            editorEdit.putString(Builder.class.getName(), this.f.b(false).toString());
            editorEdit.apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean f() {
        return a.get() && b.get();
    }

    public static TSConfig getInstance(Context context) {
        if (c == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            c = a(context);
        }
        return c;
    }

    public static boolean isLoaded() {
        return e.get();
    }

    public static void r(boolean z) {
        a.set(true);
        b.set(z);
    }

    public float calculateDistanceFilter(float f) {
        if (f <= 0.0f || getDisableElasticity().booleanValue()) {
            return this.f.distanceFilter.floatValue();
        }
        float fFloor = (float) ((Math.floor((((double) f) / 5.0d) + 0.5d) * 5.0d) / 5.0d);
        return this.f.distanceFilter.floatValue() + (this.f.distanceFilter.floatValue() * this.f.elasticityMultiplier.floatValue() * (fFloor >= 0.0f ? fFloor : 0.0f));
    }

    public Long getActivityRecognitionInterval() {
        return this.f.activityRecognitionInterval;
    }

    public Boolean getAllowIdenticalLocations() {
        return this.f.allowIdenticalLocations;
    }

    public TSAuthorization getAuthorization() {
        return this.f.authorization;
    }

    public Boolean getAutoSync() {
        return this.f.autoSync;
    }

    public Integer getAutoSyncThreshold() {
        return this.f.autoSyncThreshold;
    }

    public TSBackgroundPermissionRationale getBackgroundPermissionRationale() {
        return this.f.backgroundPermissionRationale;
    }

    public Boolean getBatchSync() {
        return this.f.batchSync;
    }

    public String getConfigUrl() {
        return this.f.configUrl;
    }

    public TSCrashDetector getCrashDetector() {
        return this.f.crashDetector;
    }

    public Boolean getDebug() {
        return this.f.debug;
    }

    public Long getDeferTime() {
        return this.f.deferTime;
    }

    public Integer getDesiredAccuracy() {
        return translateDesiredAccuracy(this.f.desiredAccuracy);
    }

    public Float getDesiredOdometerAccuracy() {
        return this.f.desiredOdometerAccuracy;
    }

    public Boolean getDidDeviceReboot() {
        return Boolean.valueOf(this.p);
    }

    public Boolean getDidShowBackgroundPermissionRationale() {
        return this.k;
    }

    public boolean getDisableAutoSyncOnCellular() {
        return this.f.disableAutoSyncOnCellular.booleanValue();
    }

    public Boolean getDisableElasticity() {
        return this.f.disableElasticity;
    }

    public Boolean getDisableLocationAuthorizationAlert() {
        return this.f.disableLocationAuthorizationAlert;
    }

    public Boolean getDisableMotionActivityUpdates() {
        return this.f.disableMotionActivityUpdates;
    }

    public boolean getDisableProviderChangeRecord() {
        return this.f.disableProviderChangeRecord.booleanValue();
    }

    public Boolean getDisableStopDetection() {
        return this.f.disableStopDetection;
    }

    public Float getDistanceFilter() {
        return this.f.distanceFilter;
    }

    public Float getElasticityMultiplier() {
        return this.f.elasticityMultiplier;
    }

    public Boolean getEnableHeadless() {
        return this.f.enableHeadless;
    }

    public Boolean getEnableTimestampMeta() {
        return this.f.enableTimestampMeta;
    }

    public Boolean getEnabled() {
        return this.i;
    }

    public JSONObject getExtras() {
        return this.f.extras;
    }

    public Long getFastestLocationUpdateInterval() {
        return this.f.fastestLocationUpdateInterval;
    }

    public Boolean getForegroundService() {
        return this.f.foregroundService;
    }

    public Boolean getGeofenceInitialTriggerEntry() {
        return this.f.geofenceInitialTriggerEntry;
    }

    public Boolean getGeofenceModeHighAccuracy() {
        return this.f.geofenceModeHighAccuracy;
    }

    public Long getGeofenceProximityRadius() {
        return this.f.geofenceProximityRadius;
    }

    public String getGeofenceTemplate() {
        return this.f.geofenceTemplate;
    }

    public JSONObject getHeaders() {
        return this.f.headers;
    }

    public String getHeadlessJobService() {
        return this.f.headlessJobService;
    }

    public Integer getHeartbeatInterval() {
        return this.f.heartbeatInterval;
    }

    public String getHttpRootProperty() {
        return this.f.httpRootProperty;
    }

    public Integer getHttpTimeout() {
        return this.f.httpTimeout;
    }

    public Boolean getIsMoving() {
        return this.f.isMoving;
    }

    public String getLocationAuthorizationRequest() {
        return this.f.locationAuthorizationRequest;
    }

    public String getLocationTemplate() {
        return this.f.locationTemplate;
    }

    public Integer getLocationTimeout() {
        return this.f.locationTimeout;
    }

    public Long getLocationUpdateInterval() {
        return this.f.locationUpdateInterval;
    }

    public String getLocationsOrderDirection() {
        return this.f.locationsOrderDirection;
    }

    public Integer getLogLevel() {
        return this.f.logLevel;
    }

    public Integer getLogMaxDays() {
        return this.f.logMaxDays;
    }

    public String getMainActivityName() {
        return this.s;
    }

    public Integer getMaxBatchSize() {
        return this.f.maxBatchSize;
    }

    public Integer getMaxDaysToPersist() {
        return this.f.maxDaysToPersist;
    }

    public Integer getMaxMonitoredGeofences() {
        return this.f.maxMonitoredGeofences;
    }

    public Integer getMaxRecordsToPersist() {
        return this.f.maxRecordsToPersist;
    }

    public String getMethod() {
        return this.f.method;
    }

    public Integer getMinimumActivityRecognitionConfidence() {
        return this.f.minimumActivityRecognitionConfidence;
    }

    public Long getMotionTriggerDelay() {
        return this.f.motionTriggerDelay;
    }

    public TSNotification getNotification() {
        return this.f.notification;
    }

    public Float getOdometer() {
        return this.f99n;
    }

    public JSONObject getParams() {
        return this.f.params;
    }

    public Boolean getPersist() {
        return this.f.persist;
    }

    public Integer getPersistMode() {
        return this.f.persistMode;
    }

    public int getPluginForEvent(String str) {
        try {
            if (this.t.has(str)) {
                return this.t.getInt(str);
            }
            return -1;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public List<String> getSchedule() {
        return this.f.schedule;
    }

    public Boolean getScheduleUseAlarmManager() {
        return this.f.scheduleUseAlarmManager;
    }

    public Boolean getSchedulerEnabled() {
        return this.l;
    }

    public Integer getSpeedJumpFilter() {
        return this.f.speedJumpFilter;
    }

    public Boolean getStartOnBoot() {
        return this.f.startOnBoot;
    }

    public Integer getStationaryRadius() {
        return this.f.stationaryRadius;
    }

    public Integer getStopAfterElapsedMinutes() {
        return this.f.stopAfterElapsedMinutes;
    }

    public Boolean getStopOnStationary() {
        return this.f.stopOnStationary;
    }

    public Boolean getStopOnTerminate() {
        return this.f.stopOnTerminate;
    }

    public Long getStopTimeout() {
        return this.f.stopTimeout;
    }

    public Integer getTrackingMode() {
        return this.j;
    }

    public String getTriggerActivities() {
        return this.f.triggerActivities;
    }

    public String getUrl() {
        return this.f.url;
    }

    public Boolean getUseSignificantChangesOnly() {
        return this.f.useSignificantChangesOnly;
    }

    public boolean hasGeofenceTemplate() {
        return !this.f.geofenceTemplate.isEmpty();
    }

    public boolean hasHeadlessJobService() {
        return !this.f.headlessJobService.isEmpty();
    }

    public boolean hasLocationTemplate() {
        return !this.f.locationTemplate.isEmpty();
    }

    public boolean hasSchedule() {
        return this.f.schedule.size() > 0;
    }

    public boolean hasTriggerActivity(int i) {
        return this.u.contains(Integer.valueOf(i));
    }

    public boolean hasUrl() {
        return (this.f.url == null || this.f.url.isEmpty()) ? false : true;
    }

    public Float incrementOdometer(Float f) {
        Float fValueOf = Float.valueOf(this.f99n.floatValue() + f.floatValue());
        this.f99n = fValueOf;
        a(TSLocation.LOCATION_OPTIONS_ODOMETER, fValueOf);
        return this.f99n;
    }

    public boolean isDirty(String str) {
        boolean zContains;
        synchronized (this.f.dirtyFields) {
            zContains = this.f.dirtyFields.contains(str);
        }
        return zContains;
    }

    public Boolean isFirstBoot() {
        return this.f100o;
    }

    public boolean isLocationTrackingMode() {
        return this.j.intValue() == 1;
    }

    public void load() {
        SharedPreferences sharedPreferences = this.g.getSharedPreferences(d, 0);
        if (!f() && sharedPreferences.contains(Builder.class.getName())) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.remove(Builder.class.getName());
            editorEdit.apply();
        }
        if (!sharedPreferences.contains(Builder.class.getName())) {
            this.f100o = Boolean.TRUE;
            this.f = new Builder();
            TSLog.initialize(getLogLevel().intValue(), getLogMaxDays().intValue());
            e();
            e.set(true);
            return;
        }
        this.r = Boolean.valueOf(sharedPreferences.getBoolean("useCLLocationAccuracy", false));
        this.s = sharedPreferences.getString("mainActivityName", null);
        this.i = Boolean.valueOf(sharedPreferences.getBoolean(ViewProps.ENABLED, false));
        this.l = Boolean.valueOf(sharedPreferences.getBoolean("schedulerEnabled", false));
        this.j = Integer.valueOf(sharedPreferences.getInt("trackingMode", 1));
        this.k = Boolean.valueOf(sharedPreferences.getBoolean("didShowBackgroundPermissionRationale", false));
        this.p = sharedPreferences.getBoolean("didDeviceReboot", false);
        this.f99n = Float.valueOf(sharedPreferences.getFloat(TSLocation.LOCATION_OPTIONS_ODOMETER, 0.0f));
        try {
            this.t = new JSONObject(sharedPreferences.getString("plugins", "{}"));
        } catch (JSONException unused) {
            this.t = new JSONObject();
        }
        String string = sharedPreferences.getString(Builder.class.getName(), null);
        if (string != null) {
            this.f100o = Boolean.TRUE;
            try {
                this.f = new Builder(new JSONObject(string));
                this.f100o = Boolean.FALSE;
                e.set(true);
            } catch (JSONException e2) {
                Log.i("TSLocationManager", TSLog.error(e2.getMessage()));
                TSLog.logger.error(TSLog.error(e2.getMessage()), (Throwable) e2);
                this.f = new Builder();
                e();
            }
        } else {
            this.f = new Builder();
            e();
        }
        TSLog.initialize(getLogLevel().intValue(), getLogMaxDays().intValue());
        TSPlugin.getInstance().subscribe(this.g, this.t);
        print();
        Sensors.getInstance(this.g).print();
        d();
    }

    public void loadConfig(TSCallback tSCallback) {
        if (this.f.configUrl.isEmpty()) {
            return;
        }
        OkHttpClient client = HttpService.getInstance(this.g).getClient();
        Request.Builder builder = new Request.Builder().url(this.f.configUrl).get();
        JSONObject jSONObject = this.f.headers;
        if (jSONObject != null) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                try {
                    String next = itKeys.next();
                    if (!next.equalsIgnoreCase("content-type")) {
                        builder.header(next, jSONObject.getString(next));
                    }
                } catch (JSONException e2) {
                    tSCallback.onFailure("Error parsing headers: " + e2.getMessage());
                    return;
                }
            }
        }
        client.newCall(builder.build()).enqueue(new b(tSCallback));
    }

    public void onChange(String str, OnChangeCallback onChangeCallback) {
        if (!this.v.containsKey(str)) {
            this.v.put(str, new ArrayList<>());
        }
        this.v.get(str).add(onChangeCallback);
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(TSLog.header("TSLocationManager version: 3.7.0 (444)"));
        sb.append(TSLog.boxRow(DeviceInfo.getInstance(this.g).print()));
        try {
            sb.append(toJson(true).toString(2));
        } catch (JSONException e2) {
            Log.i("TSLocationManager", TSLog.error(e2.getMessage()));
            e2.printStackTrace();
        }
        TSLog.logger.info(sb.toString());
        TSLog.logger.info(Sensors.getInstance(this.g).print().toString());
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0032  */
    public boolean removeListener(String str, OnChangeCallback onChangeCallback) {
        boolean z;
        OnChangeCallback next;
        synchronized (this.v) {
            if (this.v.containsKey(str)) {
                ArrayList<OnChangeCallback> arrayList = this.v.get(str);
                Iterator<OnChangeCallback> it2 = arrayList.iterator();
                do {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                } while (!next.equals(onChangeCallback));
                if (next != null) {
                    arrayList.remove(next);
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
        }
        return z;
    }

    public void removeListeners() {
        this.v.clear();
    }

    public boolean requestsLocationAlways() {
        return this.f.locationAuthorizationRequest.equalsIgnoreCase(LocationAuthorization.AUTHORIZATION_REQUEST_ALWAYS);
    }

    public void reset(boolean z) {
        this.f.a(z);
    }

    public void setDidDeviceReboot(boolean z) {
        if (this.p != z) {
            this.p = z;
            a("didDeviceReboot", Boolean.valueOf(z));
        }
    }

    public void setDidShowBackgroundPermissionRationale(Boolean bool) {
        if (this.k.equals(bool)) {
            return;
        }
        this.k = bool;
        a("didShowBackgroundPermissionRationale", bool);
    }

    public void setEnabled(Boolean bool) {
        setEnabled(bool, false);
    }

    public void setIsMoving(Boolean bool) {
        this.f.setIsMoving(bool);
        c();
    }

    public void setMainActivityName(String str) {
        if (this.s != str) {
            a("mainActivityName", str);
        }
        this.s = str;
    }

    public void setOdometer(Float f) {
        if (this.f99n.equals(f)) {
            return;
        }
        this.f99n = f;
        a(TSLocation.LOCATION_OPTIONS_ODOMETER, f);
    }

    public void setPluginForEvent(int i, String str) {
        try {
            this.t.put(str, i);
            a("plugins", this.t);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void setSchedulerEnabled(Boolean bool) {
        if (this.l != bool) {
            this.l = bool;
            a("schedulerEnabled", bool);
        }
    }

    public void setTrackingMode(Integer num) {
        if (this.j.equals(num)) {
            return;
        }
        this.j = num;
        a("trackingMode", num);
    }

    public boolean shouldPersist(TSLocation tSLocation) {
        if (!this.f.persist.booleanValue() || this.f.maxRecordsToPersist.intValue() == 0) {
            return false;
        }
        int iIntValue = getPersistMode().intValue();
        if (iIntValue == 2) {
            return true;
        }
        if (iIntValue == 0) {
            return false;
        }
        if (tSLocation.getGeofence() != null) {
            return iIntValue == -1;
        }
        return iIntValue == 1;
    }

    public JSONObject toJson(boolean z) {
        JSONObject jSONObjectB = this.f.b(z);
        try {
            jSONObjectB.put(ViewProps.ENABLED, getEnabled().booleanValue());
            jSONObjectB.put("schedulerEnabled", getSchedulerEnabled().booleanValue());
            jSONObjectB.put("heartbeatEnabled", this.m);
            jSONObjectB.put("trackingMode", getTrackingMode());
            jSONObjectB.put("didShowBackgroundPermissionRationale", getDidShowBackgroundPermissionRationale());
            jSONObjectB.put(TSLocation.LOCATION_OPTIONS_ODOMETER, getOdometer().doubleValue());
            jSONObjectB.put("isFirstBoot", this.f100o);
            jSONObjectB.put("didLaunchInBackground", this.q);
            jSONObjectB.put("didDeviceReboot", this.p);
        } catch (JSONException e2) {
            TSLog.logger.error(TSLog.error(e2.getMessage()), (Throwable) e2);
            e2.printStackTrace();
        }
        return jSONObjectB;
    }

    public Integer translateDesiredAccuracy(Integer num) {
        TSLog.logger.debug("translateDesiredAccuracy (" + this.r + "): " + num);
        if (!this.r.booleanValue()) {
            return num;
        }
        int iIntValue = num.intValue();
        if (iIntValue == -2 || iIntValue == -1 || iIntValue == 0) {
            return 100;
        }
        if (iIntValue == 10) {
            return 102;
        }
        if (iIntValue != 100) {
            return (iIntValue == 1000 || iIntValue == 3000) ? 105 : 102;
        }
        return 104;
    }

    public Builder updateWithBuilder() {
        return this.f.b();
    }

    public void updateWithJSONObject(JSONObject jSONObject) {
        this.f.a(jSONObject);
        c();
    }

    public void useCLLocationAccuracy(Boolean bool) {
        if (this.r != bool) {
            a("useCLLocationAccuracy", bool);
            this.f.desiredAccuracy = Integer.valueOf(bool.booleanValue() ? 0 : 100);
        }
        this.r = bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (f()) {
            synchronized (this.f.dirtyFields) {
                if (!Settings.isValid(this.g)) {
                    this.f.dirtyFields.clear();
                    return;
                }
                if (this.f.dirtyFields.isEmpty()) {
                    return;
                }
                if (isDirty("logLevel")) {
                    TSLog.setLogLevel(this.f.logLevel.intValue());
                }
                if (isDirty("logMaxDays")) {
                    TSLog.setMaxHistory(this.f.logMaxDays.intValue());
                }
                if (isDirty("notification.channelId")) {
                    ForegroundNotification.onUpdateChannelId(this.g);
                }
                if (isDirty("notification.channelName")) {
                    ForegroundNotification.onUpdateChannelName(this.g);
                }
                if (isDirty("configUrl") && !this.f.configUrl.isEmpty()) {
                    loadConfig(new a());
                }
                e();
                EventBus.getDefault().post(new ConfigChangeEvent(this.g, this.f.dirtyFields));
                for (String str : this.f.dirtyFields) {
                    if (str.equalsIgnoreCase("triggerActivities")) {
                        this.u = a(this.f.triggerActivities);
                    }
                    b(str);
                }
                this.f.dirtyFields.clear();
            }
        }
    }

    private void d() {
        BackgroundGeolocation.getThreadPool().execute(new c(this, null));
    }

    public void reset() {
        reset(false);
    }

    public void setEnabled(Boolean bool, boolean z) {
        if (this.i != bool) {
            this.i = bool;
            a(ViewProps.ENABLED, bool);
            if (z) {
                return;
            }
            b(ViewProps.ENABLED);
        }
    }

    private static TSConfig a(Context context) {
        TSConfig tSConfig;
        synchronized (TSConfig.class) {
            if (c == null) {
                c = new TSConfig(context);
            }
            tSConfig = c;
        }
        return tSConfig;
    }

    private void b(String str) {
        if (this.v.containsKey(str)) {
            Iterator<OnChangeCallback> it2 = this.v.get(str).iterator();
            while (it2.hasNext()) {
                it2.next().onChange(this);
            }
        }
    }

    private void a(String str, Object obj) {
        SharedPreferences.Editor editorEdit = this.g.getSharedPreferences(d, 0).edit();
        if (obj != null) {
            Class<?> cls = obj.getClass();
            if (cls == Boolean.class) {
                editorEdit.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (cls == String.class) {
                editorEdit.putString(str, (String) obj);
            } else if (cls == Double.class) {
                editorEdit.putLong(str, Double.doubleToRawLongBits(((Double) obj).doubleValue()));
            } else if (cls == Integer.class) {
                editorEdit.putInt(str, ((Integer) obj).intValue());
            } else if (cls == Float.class) {
                editorEdit.putFloat(str, ((Float) obj).floatValue());
            } else if (cls == JSONObject.class) {
                editorEdit.putString(str, obj.toString());
            } else {
                TSLog.logger.error(TSLog.error("Unknown state Type: " + cls.getName()));
                TSMediaPlayer.getInstance().debug(this.g, "tslocationmanager_music_timpani_error_01");
            }
        } else {
            editorEdit.remove(str);
        }
        editorEdit.apply();
    }

    public JSONObject toJson() {
        return toJson(false);
    }

    private ArrayList<Integer> a(String str) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (String str2 : Arrays.asList(str.replaceAll("\\s+", "").split(","))) {
            if (str2.equalsIgnoreCase(Util.ACTIVITY_NAME_IN_VEHICLE)) {
                arrayList.add(0);
            } else if (str2.equalsIgnoreCase(Util.ACTIVITY_NAME_ON_BICYCLE)) {
                arrayList.add(1);
            } else if (str2.equalsIgnoreCase(Util.ACTIVITY_NAME_ON_FOOT)) {
                arrayList.add(2);
            } else if (str2.equalsIgnoreCase(Util.ACTIVITY_NAME_RUNNING)) {
                arrayList.add(8);
            } else if (str2.equalsIgnoreCase(Util.ACTIVITY_NAME_WALKING)) {
                arrayList.add(7);
            } else {
                TSLog.logger.warn(TSLog.error("CONFIGURE ERROR: Unknown activity-name in #triggerActivities: " + str2));
                TSMediaPlayer.getInstance().debug(this.g, "tslocationmanager_digi_warn");
            }
        }
        return arrayList;
    }
}
