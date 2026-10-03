package com.transistorsoft.locationmanager.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.facebook.react.uimanager.ViewProps;
import com.transistorsoft.locationmanager.a.A;
import com.transistorsoft.locationmanager.event.SettingsFailureEvent;
import com.transistorsoft.locationmanager.location.TSLocation;
import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.locationmanager.util.Util;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Settings {
    public static final long DEFAULT_ACTIVITY_RECOGNITION_INTERVAL = 10000;
    public static final Boolean DEFAULT_ALLOW_IDENTICAL_LOCATIONS;
    public static final boolean DEFAULT_AUTO_SYNC = true;
    public static final Integer DEFAULT_AUTO_SYNC_THRESHOLD;
    public static final boolean DEFAULT_BATCH_SYNC = false;
    public static final boolean DEFAULT_DEBUG = false;
    public static final long DEFAULT_DEFER_TIME = 0;
    public static final int DEFAULT_DESIRED_ACCURACY = 0;
    public static final float DEFAULT_DESIRED_ODOMETER_ACCURACY = 100.0f;
    public static final boolean DEFAULT_DISABLE_ELASTICITY = false;
    public static final boolean DEFAULT_DISABLE_STOP_DETECTION = false;
    public static final Float DEFAULT_DISTANCE_FILTER;
    public static final Float DEFAULT_ELASTICITY_MULTIPLIER;
    public static final long DEFAULT_FASTEST_LOCATION_UPDATE_INTERVAL = 10000;
    public static final boolean DEFAULT_FORCE_RELOAD = false;
    public static final boolean DEFAULT_FOREGROUND_SERVICE = false;
    public static final boolean DEFAULT_GEOFENCE_INITIAL_TRIGGER_ENTRY = true;
    public static final long DEFAULT_GEOFENCE_PROXIMITY_RADIUS = 1000;
    public static final String DEFAULT_GEOFENCE_TEMPLATE = "";
    public static final int DEFAULT_HEARTBEAT_INTERVAL = -1;
    public static final String DEFAULT_HTTP_METHOD = "POST";
    public static final String DEFAULT_HTTP_ROOT_PROPERTY = "location";
    public static final Integer DEFAULT_HTTP_TIMEOUT;
    public static final String DEFAULT_LOCATIONS_ORDER_DIRECTION = "ASC";
    public static final String DEFAULT_LOCATION_TEMPLATE = "";
    public static final Integer DEFAULT_LOCATION_TIMEOUT;
    public static final long DEFAULT_LOCATION_UPDATE_INTERVAL = 1000;
    public static final int DEFAULT_LOG_LEVEL = 5;
    public static final int DEFAULT_LOG_MAX_DAYS = 3;
    public static final int DEFAULT_MAX_BATCH_SIZE = -1;
    public static final int DEFAULT_MAX_DAYS_TO_PERSIST = 1;
    public static final int DEFAULT_MAX_RECORDS_TO_PERSIST = -1;
    public static final int DEFAULT_MINIMUM_ACTIVITY_RECOGNITION_CONFIDENCE = 75;
    public static final String DEFAULT_NOTIFICATION_COLOR = "";
    public static final String DEFAULT_NOTIFICATION_ICON = "";
    public static final Integer DEFAULT_NOTIFICATION_PRIORITY;
    public static final String DEFAULT_NOTIFICATION_TEXT = "Location Service activated";
    public static final String DEFAULT_NOTIFICATION_TITLE = "";
    public static final String DEFAULT_SCHEDULE;
    public static final boolean DEFAULT_START_ON_BOOT = false;
    public static final int DEFAULT_STATIONARY_RADIUS = 25;
    public static final int DEFAULT_STOP_AFTER_ELAPSED_MINUTES = 0;
    public static final boolean DEFAULT_STOP_ON_STATIONARY = false;
    public static final boolean DEFAULT_STOP_ON_TERMINATE = true;
    public static final long DEFAULT_STOP_TIMEOUT = 5;
    public static final String DEFAULT_TRIGGER_ACTIVITIES = "in_vehicle, on_bicycle, on_foot, running, walking";
    public static final String DEFAULT_URL = "";
    public static final Float MAXIMUM_LOCATION_ACCURACY;
    public static final Integer MINIMUM_STATIONARY_RADIUS;
    public static final String TAG = "TSLocationManager";
    public static final String TRACKING_MODE_GEOFENCE = "geofence";
    public static final String TRACKING_MODE_LOCATION = "location";
    private static SharedPreferences a;
    public static Long activityRecognitionInterval;
    public static Boolean allowIdenticalLocations;
    public static Boolean autoSync;
    public static Integer autoSyncThreshold;
    private static boolean b;
    public static Boolean batchSync;
    private static boolean c;
    public static ArrayList<String> changed;
    public static Integer configureInterval;
    public static String configureUrl;
    private static boolean d;
    public static Boolean debug;
    public static Long deferTime;
    public static Integer desiredAccuracy;
    public static Float desiredOdometerAccuracy;
    public static Boolean disableElasticity;
    public static Boolean disableStopDetection;
    public static Float distanceFilter;
    private static boolean e;
    public static Float elasticityMultiplier;
    public static Boolean enableHeadless;
    public static Boolean enabled;
    public static JSONObject extras;
    private static boolean f;
    public static Long fastestLocationUpdateInterval;
    public static Boolean forceReloadOnBoot;
    public static Boolean forceReloadOnGeofence;
    public static Boolean forceReloadOnHeartbeat;
    public static Boolean forceReloadOnLocationChange;
    public static Boolean forceReloadOnMotionChange;
    public static Boolean forceReloadOnSchedule;
    public static Boolean foregroundService;
    private static boolean g;
    public static Boolean geofenceInitialTriggerEntry;
    public static Long geofenceProximityRadius;
    public static String geofenceTemplate;
    private static boolean h;
    public static JSONObject headers;
    public static String headlessJobService;
    public static Integer heartbeatInterval;
    public static String httpRootProperty;
    public static Integer httpTimeout;
    public static Boolean isMoving;
    public static String locationTemplate;
    public static Integer locationTimeout;
    public static Long locationUpdateInterval;
    public static String locationsOrderDirection;
    public static Integer logLevel;
    public static Integer logMaxDays;
    public static Integer maxBatchSize;
    public static Integer maxDaysToPersist;
    public static Integer maxRecordsToPersist;
    public static String method;
    public static Integer minimumActivityRecognitionConfidence;
    public static String notificationColor;
    public static String notificationIcon;
    public static String notificationLargeIcon;
    public static Integer notificationPriority;
    public static String notificationSmallIcon;
    public static String notificationText;
    public static String notificationTitle;
    public static Float odometer;
    public static JSONObject params;
    public static Boolean persist;
    public static JSONArray schedule;
    public static Boolean schedulerEnabled;
    public static ArrayList<a> settings;
    public static Boolean startOnBoot;
    public static Integer stationaryRadius;
    public static Integer stopAfterElapsedMinutes;
    public static Boolean stopOnStationary;
    public static Boolean stopOnTerminate;
    public static Long stopTimeout;
    public static String trackingMode;
    public static ArrayList<Integer> triggerActivities;
    public static String url;

    static {
        System.loadLibrary("tslocationmanager");
        MAXIMUM_LOCATION_ACCURACY = Float.valueOf(100.0f);
        settings = new ArrayList<>();
        changed = new ArrayList<>();
        b = false;
        c = false;
        d = false;
        e = false;
        f = false;
        g = false;
        h = false;
        DEFAULT_DISTANCE_FILTER = Float.valueOf(10.0f);
        DEFAULT_LOCATION_TIMEOUT = 60;
        DEFAULT_ELASTICITY_MULTIPLIER = Float.valueOf(1.0f);
        MINIMUM_STATIONARY_RADIUS = 25;
        Boolean bool = Boolean.FALSE;
        DEFAULT_ALLOW_IDENTICAL_LOCATIONS = bool;
        DEFAULT_AUTO_SYNC_THRESHOLD = 0;
        DEFAULT_HTTP_TIMEOUT = 60000;
        DEFAULT_NOTIFICATION_PRIORITY = 0;
        DEFAULT_SCHEDULE = null;
        debug = bool;
        logLevel = 5;
        logMaxDays = 3;
    }

    private static boolean A() {
        if (Build.VERSION.SDK_INT >= 26) {
            foregroundService = Boolean.TRUE;
        }
        return foregroundService.booleanValue();
    }

    private static boolean B() {
        return geofenceInitialTriggerEntry.booleanValue();
    }

    private static long C() {
        return geofenceProximityRadius.longValue();
    }

    private static String D() {
        if (geofenceTemplate.isEmpty()) {
            return null;
        }
        return geofenceTemplate;
    }

    private static JSONObject E() {
        return headers;
    }

    private static String F() {
        return headlessJobService;
    }

    private static Integer G() {
        return heartbeatInterval;
    }

    private static String H() {
        String str = method;
        return str != null ? str : "POST";
    }

    private static String I() {
        return httpRootProperty;
    }

    private static Integer J() {
        return httpTimeout;
    }

    private static boolean K() {
        return isMoving.booleanValue();
    }

    private static String L() {
        if (locationTemplate.isEmpty()) {
            return null;
        }
        return locationTemplate;
    }

    private static Integer M() {
        return locationTimeout;
    }

    private static long N() {
        return locationUpdateInterval.longValue();
    }

    private static String O() {
        if (!locationsOrderDirection.equalsIgnoreCase("ASC") && !locationsOrderDirection.equalsIgnoreCase("DESC")) {
            TSLog.logger.warn(TSLog.warn("Invalid value for locationsOrderDirection: " + locationsOrderDirection));
            locationsOrderDirection = "ASC";
        }
        return locationsOrderDirection;
    }

    private static int P() {
        return logLevel.intValue();
    }

    private static int Q() {
        return logMaxDays.intValue();
    }

    private static int R() {
        return maxBatchSize.intValue();
    }

    private static int S() {
        return maxDaysToPersist.intValue();
    }

    private static Integer T() {
        return maxRecordsToPersist;
    }

    private static Integer U() {
        return minimumActivityRecognitionConfidence;
    }

    private static String V() {
        return notificationColor;
    }

    private static String W() {
        return notificationIcon;
    }

    private static String X() {
        return notificationLargeIcon;
    }

    private static Integer Y() {
        return notificationPriority;
    }

    private static String Z() {
        return !notificationSmallIcon.isEmpty() ? notificationSmallIcon : notificationIcon;
    }

    private static void a(JSONObject jSONObject) {
        changed.clear();
        SharedPreferences.Editor editorEdit = a.edit();
        for (int i = 0; i < settings.size(); i++) {
            a aVar = settings.get(i);
            if (!aVar.h.booleanValue() && jSONObject.has(aVar.b)) {
                try {
                    changed.add(aVar.b);
                    Object objA = a(jSONObject, aVar);
                    b(a(objA, aVar), aVar);
                    a(objA, aVar, editorEdit);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        TSLog.setLogLevel(P());
        TSLog.setMaxHistory(Q());
        editorEdit.apply();
        h = true;
    }

    private static String a0() {
        return notificationText;
    }

    private static void b(boolean z) {
        enabled = Boolean.valueOf(z);
        SharedPreferences.Editor editorEdit = a.edit();
        editorEdit.putBoolean(ViewProps.ENABLED, z);
        editorEdit.apply();
    }

    private static String b0() {
        return notificationTitle;
    }

    private static void c(boolean z) {
        schedulerEnabled = Boolean.valueOf(z);
        SharedPreferences.Editor editorEdit = a.edit();
        editorEdit.putBoolean("schedulerEnabled", z);
        editorEdit.apply();
    }

    private static Float c0() {
        return odometer;
    }

    private static Integer d() {
        return autoSyncThreshold;
    }

    private static JSONObject d0() {
        return params;
    }

    private static boolean e() {
        return batchSync.booleanValue();
    }

    private static boolean e0() {
        return persist.booleanValue() && maxRecordsToPersist.intValue() != 0;
    }

    private static Integer f() {
        return configureInterval;
    }

    private static JSONArray f0() {
        return schedule;
    }

    private static String g() {
        return configureUrl;
    }

    private static boolean g0() {
        return schedulerEnabled.booleanValue();
    }

    private static boolean h() {
        return debug.booleanValue();
    }

    private static boolean h0() {
        return startOnBoot.booleanValue();
    }

    private static long i() {
        return deferTime.longValue();
    }

    private static JSONObject i0() {
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < settings.size(); i++) {
            a aVar = settings.get(i);
            if (a.contains(aVar.b)) {
                Object objA = a(aVar);
                if (aVar.a == 2) {
                    objA = Double.valueOf(objA.toString());
                }
                try {
                    jSONObject.put(aVar.b, objA);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    TSLog.logger.error(TSLog.error("Failed to set '" + aVar.b + "'"), (Throwable) e2);
                }
            }
        }
        return jSONObject;
    }

    public static boolean isLoaded() {
        return h;
    }

    public static boolean isValid(Context context) {
        return A.d(context);
    }

    private static Integer j() {
        return desiredAccuracy;
    }

    private static Integer j0() {
        return stationaryRadius;
    }

    private static float k() {
        return desiredOdometerAccuracy.floatValue();
    }

    private static Integer k0() {
        return stopAfterElapsedMinutes;
    }

    private static boolean l() {
        return b;
    }

    private static boolean l0() {
        return stopOnStationary.booleanValue();
    }

    public static void load(Context context) {
        A.c(context);
    }

    private static boolean m() {
        return disableElasticity.booleanValue();
    }

    private static boolean m0() {
        return stopOnTerminate.booleanValue();
    }

    private static boolean n() {
        return disableStopDetection.booleanValue();
    }

    private static long n0() {
        return stopTimeout.longValue();
    }

    private static float o() {
        return distanceFilter.floatValue();
    }

    private static String o0() {
        return trackingMode;
    }

    private static float p() {
        return elasticityMultiplier.floatValue();
    }

    private static ArrayList<Integer> p0() {
        return triggerActivities;
    }

    private static boolean q() {
        return enableHeadless.booleanValue();
    }

    private static String q0() {
        return url;
    }

    private static boolean r() {
        return enabled.booleanValue();
    }

    private static void r0() {
    }

    private static JSONObject s() {
        return extras;
    }

    private static boolean s0() {
        return trackingMode.equalsIgnoreCase("location");
    }

    private static long t() {
        return fastestLocationUpdateInterval.longValue();
    }

    private static void t0() {
        StringBuffer stringBuffer = new StringBuffer(4096);
        stringBuffer.append(TSLog.header("BackgroundGeolocation Settings"));
        try {
            stringBuffer.append(i0().toString(2));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        stringBuffer.append(TSLog.BOX_BOTTOM);
        TSLog.logger.info(stringBuffer.toString());
    }

    private static boolean u() {
        return forceReloadOnBoot.booleanValue();
    }

    private static void u0() {
        SharedPreferences.Editor editorEdit = a.edit();
        for (int i = 0; i < settings.size(); i++) {
            a aVar = settings.get(i);
            if (!a.contains(aVar.b) || !aVar.g.booleanValue()) {
                b(a(aVar.c, aVar), aVar);
                a(aVar.c, aVar, editorEdit);
            }
        }
        editorEdit.apply();
    }

    private static boolean v() {
        return forceReloadOnGeofence.booleanValue();
    }

    private static void v0() {
        c = true;
    }

    private static boolean w() {
        return forceReloadOnHeartbeat.booleanValue();
    }

    private static boolean x() {
        return forceReloadOnLocationChange.booleanValue();
    }

    private static boolean y() {
        return forceReloadOnMotionChange.booleanValue();
    }

    private static boolean z() {
        return forceReloadOnSchedule.booleanValue();
    }

    private static ArrayList<Integer> d(String str) {
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
            }
        }
        return arrayList;
    }

    private static void b(String str) {
        trackingMode = str;
        SharedPreferences.Editor editorEdit = a.edit();
        editorEdit.putString("trackingMode", trackingMode);
        editorEdit.apply();
    }

    private static void c(String str) {
        url = str;
    }

    private static boolean c() {
        return autoSync.booleanValue() && !b;
    }

    private static boolean c(Context context) {
        g = b(context);
        String packageName = context.getPackageName();
        String strA = a(context);
        if (strA == null) {
            a("LICENSE VALIDATION FAILURE", "Failed to find license key in AndroidManifest.  Ensure you've added the key within <application><meta-data android:name=\"com.transistorsoft.locationmanager.license\" android:value=\"<YOUR LICENSE KEY>\" />");
            return false;
        }
        v0();
        try {
            if (String.format("%0" + (packageName + "--0bac1f565ffae900738c8ed2c2b59f56aea65a86375a27a90a0741693a3e4282"), new Object[0]).equalsIgnoreCase(strA)) {
                return true;
            }
        } catch (Exception unused) {
            TSLog.logger.error(TSLog.error("License validation error"));
        }
        a("LICENSE VALIDATION FAILURE", packageName);
        return false;
    }

    private static void b(float f2) {
        distanceFilter = Float.valueOf(f2);
    }

    private static boolean b() {
        return allowIdenticalLocations.booleanValue();
    }

    private static boolean b(Context context) {
        String packageName = context.getPackageName();
        try {
            try {
                Field declaredField = ApplicationInfo.class.getDeclaredField("FLAG_DEBUGGABLE");
                return (context.getPackageManager().getApplicationInfo(packageName, 0).flags & declaredField.getInt(declaredField)) != 0;
            } catch (IllegalAccessException e2) {
                TSLog.logger.error(TSLog.error(e2.getMessage()));
                return false;
            } catch (NoSuchFieldException e3) {
                TSLog.logger.error(TSLog.error(e3.getMessage()));
                return false;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    private static Integer b(Integer num) {
        int iIntValue = num.intValue();
        if (iIntValue == -2 || iIntValue == -1 || iIntValue == 0) {
            return 100;
        }
        if (iIntValue == 10) {
            return 102;
        }
        if (iIntValue == 100) {
            return 104;
        }
        if (iIntValue != 1000 && iIntValue != 3000) {
            return 102;
        }
        return 105;
    }

    private static Boolean a(String str) {
        return Boolean.valueOf(changed.contains(str));
    }

    private static Integer c(Integer num) {
        int iIntValue = num.intValue();
        if (iIntValue == -2) {
            return -2;
        }
        if (iIntValue == -1) {
            return -1;
        }
        if (iIntValue == 0) {
            return 0;
        }
        if (iIntValue == 1) {
            return 1;
        }
        if (iIntValue != 2) {
            return num;
        }
        return 2;
    }

    private static void a(Float f2) {
        odometer = f2;
        SharedPreferences.Editor editorEdit = a.edit();
        editorEdit.putFloat(TSLocation.LOCATION_OPTIONS_ODOMETER, odometer.floatValue());
        editorEdit.apply();
    }

    private static float a(float f2) {
        if (f2 > 0.0f && !m()) {
            float fFloor = (float) ((Math.floor((((double) f2) / 5.0d) + 0.5d) * 5.0d) / 5.0d);
            return distanceFilter.floatValue() + (distanceFilter.floatValue() * elasticityMultiplier.floatValue() * (fFloor >= 0.0f ? fFloor : 0.0f));
        }
        return distanceFilter.floatValue();
    }

    private static void a(long j) {
        geofenceProximityRadius = Long.valueOf(j);
        SharedPreferences.Editor editorEdit = a.edit();
        editorEdit.putLong("geofenceProximityRadius", geofenceProximityRadius.longValue());
        editorEdit.apply();
    }

    private static void a(boolean z) {
        b = z;
    }

    private static void a(Boolean bool) {
        SharedPreferences.Editor editorEdit = a.edit();
        isMoving = bool;
        editorEdit.putBoolean("isMoving", bool.booleanValue());
        editorEdit.apply();
    }

    private static void b(Object obj, a aVar) {
        try {
            Field declaredField = Settings.class.getDeclaredField(aVar.b);
            declaredField.set(declaredField, obj);
        } catch (IllegalAccessException e2) {
            TSLog.logger.error(TSLog.error("Failed to set field: " + aVar.b));
            e2.printStackTrace();
        } catch (NoSuchFieldException e3) {
            TSLog.logger.error(TSLog.error("Failed to find field: " + aVar.b));
            e3.printStackTrace();
        }
    }

    private static void a(Integer num) {
        stationaryRadius = num;
    }

    private static long a() {
        return activityRecognitionInterval.longValue();
    }

    private static String a(Context context) {
        try {
            String string = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("com.transistorsoft.locationmanager.license");
            if (string == null) {
                return null;
            }
            f = true;
            return string;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static void a(String str, String str2) {
        if (g) {
            str = "License Validation Failure";
            str2 = "BackgroundGeolocation is running in evaluation mode.";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(TSLog.header(str));
        stringBuffer.append(TSLog.boxRow(str2));
        Log.i("TSLocationManager", stringBuffer.toString());
        EventBus.getDefault().post(new SettingsFailureEvent(str, str2));
    }

    private static Object a(JSONObject jSONObject, a aVar) throws JSONException {
        Object objValueOf = jSONObject.get(aVar.b);
        Object obj = null;
        if (objValueOf.equals(null)) {
            return aVar.c;
        }
        try {
            int i = aVar.a;
            if (i == 1) {
                objValueOf = Integer.valueOf(jSONObject.getInt(aVar.b));
            } else if (i == 2) {
                objValueOf = Float.valueOf((float) jSONObject.getDouble(aVar.b));
            } else if (i == 3) {
                objValueOf = Boolean.valueOf(jSONObject.getBoolean(aVar.b));
            } else if (i == 4) {
                objValueOf = Long.valueOf(jSONObject.getLong(aVar.b));
            }
            if (aVar.d == null) {
                return objValueOf;
            }
            int i2 = aVar.a;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 4 && ((Long) objValueOf).longValue() < ((Long) aVar.d).longValue()) {
                        obj = aVar.d;
                    }
                } else if (((Float) objValueOf).floatValue() < ((Float) aVar.d).floatValue()) {
                    obj = aVar.d;
                }
            } else if (((Integer) objValueOf).intValue() < ((Integer) aVar.d).intValue()) {
                obj = aVar.d;
            }
            if (obj == null) {
                return objValueOf;
            }
            TSLog.logger.warn(TSLog.warn("Enforced minimumValue, " + aVar.b + ": " + objValueOf + " -> " + obj));
            return obj;
        } catch (NumberFormatException unused) {
            TSLog.logger.warn(TSLog.warn("Invalid number format for setting " + aVar.b + ": " + objValueOf + " (Using defaultValue: " + aVar.c + ")"));
            return aVar.c;
        }
    }

    private static Object a(Object obj, a aVar) {
        Method method2;
        if (obj == null) {
            obj = aVar.c;
        }
        String str = aVar.f;
        if (str == null) {
            return obj;
        }
        try {
            int i = aVar.a;
            if (i == 0) {
                method2 = Settings.class.getMethod(str, String.class);
            } else if (i == 1) {
                method2 = Settings.class.getMethod(str, Integer.class);
            } else if (i != 2) {
                method2 = i != 4 ? null : Settings.class.getMethod(str, Long.class);
            } else {
                method2 = Settings.class.getMethod(str, Float.class);
            }
            if (method2 != null) {
                return method2.invoke(Settings.class, obj);
            }
            return aVar.c;
        } catch (IllegalAccessException e2) {
            TSLog.logger.error(TSLog.error(e2.getMessage()));
            e2.printStackTrace();
            return null;
        } catch (NoSuchMethodException e3) {
            TSLog.logger.error(TSLog.error(e3.getMessage()));
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            TSLog.logger.error(TSLog.error(e4.getMessage()));
            e4.printStackTrace();
            return null;
        }
    }

    private static Object a(a aVar) {
        try {
            switch (aVar.a) {
                case 0:
                    SharedPreferences sharedPreferences = a;
                    String str = aVar.b;
                    Object obj = aVar.c;
                    return sharedPreferences.getString(str, obj != null ? obj.toString() : null);
                case 1:
                    return Integer.valueOf(a.getInt(aVar.b, ((Integer) aVar.c).intValue()));
                case 2:
                    return Float.valueOf(a.getFloat(aVar.b, ((Float) aVar.c).floatValue()));
                case 3:
                    return Boolean.valueOf(a.getBoolean(aVar.b, ((Boolean) aVar.c).booleanValue()));
                case 4:
                    return Long.valueOf(a.getLong(aVar.b, ((Long) aVar.c).longValue()));
                case 5:
                    try {
                        return new JSONObject(a.getString(aVar.b, aVar.c.toString()));
                    } catch (JSONException e2) {
                        TSLog.logger.error(TSLog.error("Failed to decode JSONObject " + aVar.b));
                        JSONObject jSONObject = new JSONObject();
                        e2.printStackTrace();
                        return jSONObject;
                    }
                case 6:
                    try {
                        return new JSONArray(a.getString(aVar.b, aVar.c.toString()));
                    } catch (JSONException e3) {
                        TSLog.logger.error(TSLog.error("Failed to decode JSONArray " + aVar.b));
                        JSONArray jSONArray = new JSONArray();
                        e3.printStackTrace();
                        return jSONArray;
                    }
                default:
                    return null;
            }
        } catch (ClassCastException unused) {
            TSLog.logger.warn(TSLog.warn("Failed to cast setting " + aVar.b + ".  Applying defaultValue"));
            return aVar.c;
        }
        TSLog.logger.warn(TSLog.warn("Failed to cast setting " + aVar.b + ".  Applying defaultValue"));
        return aVar.c;
    }

    private static void a(Object obj, a aVar, SharedPreferences.Editor editor) {
        switch (aVar.a) {
            case 0:
                editor.putString(aVar.b, obj != null ? obj.toString() : null);
                break;
            case 1:
                editor.putInt(aVar.b, ((Integer) obj).intValue());
                break;
            case 2:
                editor.putFloat(aVar.b, ((Float) obj).floatValue());
                break;
            case 3:
                editor.putBoolean(aVar.b, ((Boolean) obj).booleanValue());
                break;
            case 4:
                editor.putLong(aVar.b, ((Long) obj).longValue());
                break;
            case 5:
                editor.putString(aVar.b, obj.toString());
                break;
            case 6:
                editor.putString(aVar.b, obj.toString());
                break;
        }
    }
}
