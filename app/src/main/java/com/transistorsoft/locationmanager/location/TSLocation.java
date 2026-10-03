package com.transistorsoft.locationmanager.location;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.compose.animation.core.AnimationKt;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.location.ActivityTransitionEvent;
import com.google.android.gms.location.DetectedActivity;
import com.transistorsoft.locationmanager.adapter.BackgroundGeolocation;
import com.transistorsoft.locationmanager.adapter.TSConfig;
import com.transistorsoft.locationmanager.event.LocationProviderChangeEvent;
import com.transistorsoft.locationmanager.event.TemplateErrorEvent;
import com.transistorsoft.locationmanager.geofence.TSGeofence;
import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.locationmanager.util.TSTemplate;
import com.transistorsoft.locationmanager.util.Util;
import io.sentry.protocol.Device;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TSLocation {
    public static final String LOCATION_OPTIONS_ODOMETER = "odometer";
    private static final String a = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static final ThreadLocal<SimpleDateFormat> b = new a();
    private static TSTemplate c;
    private static TSTemplate d;
    private static DecimalFormat e;
    private static DecimalFormat f;
    private Integer A;
    private Boolean B;
    private Double C;
    private TSGeofence D;
    private String E;
    private String F;
    private JSONObject G;
    private LocationProviderChangeEvent H;
    private String g;
    private String h;
    private Long i;
    private boolean j;
    private Double k;
    private Double l;
    private Double m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Double f115n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Double f116o;
    private Double p;
    private Double q;
    private Double r;
    private Double s;
    private Float u;
    private Boolean v;
    private Boolean w;
    private Boolean x;
    private DetectedActivity y;
    private String z;
    public Integer id = null;
    public Location mLocation = null;
    public JSONObject json = null;
    private String t = "";

    class a extends ThreadLocal<SimpleDateFormat> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TSLocation.a, Locale.ENGLISH);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return simpleDateFormat;
        }
    }

    static {
        e();
    }

    public TSLocation(Context context, Location location, ActivityTransitionEvent activityTransitionEvent) {
        Boolean bool = Boolean.FALSE;
        this.w = bool;
        this.x = bool;
        this.B = bool;
        this.C = Double.valueOf(-1.0d);
        a(context, location, activityTransitionEvent);
    }

    private static String a(long j) {
        return b.get().format(new Date(j));
    }

    public static Location applyExtras(Context context, Location location) {
        synchronized (TSLocation.class) {
            Bundle extras = location.getExtras();
            TSConfig tSConfig = TSConfig.getInstance(context);
            if (extras == null) {
                extras = new Bundle();
            }
            extras.putFloat(LOCATION_OPTIONS_ODOMETER, tSConfig.getOdometer().floatValue());
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterReceiver != null) {
                extras.putFloat(Device.JsonKeys.BATTERY_LEVEL, intentRegisterReceiver.getIntExtra("level", -1) / intentRegisterReceiver.getIntExtra("scale", -1));
                int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
                extras.putBoolean("is_charging", intExtra == 2 || intExtra == 5);
            }
            location.setExtras(extras);
        }
        return location;
    }

    private HashMap<String, String> b() {
        HashMap<String, String> mapC = c();
        mapC.put("geofence.identifier", this.D.getIdentifier());
        mapC.put("geofence.action", this.E);
        mapC.put("geofence.timestamp", this.F);
        return mapC;
    }

    public static TSLocation buildFromJson(Context context, JSONObject jSONObject) throws JSONException {
        Location location = new Location("fused");
        Bundle bundle = new Bundle();
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("coords");
            jSONObject.getJSONObject("activity");
            jSONObject.getJSONObject("battery");
            ActivityTransitionEvent activityTransitionEvent = new ActivityTransitionEvent(3, 0, 0L);
            bundle.putFloat(LOCATION_OPTIONS_ODOMETER, (float) jSONObject.getDouble(LOCATION_OPTIONS_ODOMETER));
            bundle.putBoolean("sample", false);
            bundle.putString(NotificationCompat.CATEGORY_EVENT, jSONObject.getString(NotificationCompat.CATEGORY_EVENT));
            location.setLatitude(jSONObject2.getDouble("latitude"));
            location.setLongitude(jSONObject2.getDouble("longitude"));
            location.setAccuracy((float) jSONObject2.getDouble("accuracy"));
            location.setSpeed((float) jSONObject2.getDouble("speed"));
            location.setBearing((float) jSONObject2.getDouble("heading"));
            location.setAltitude(jSONObject2.getDouble("altitude"));
            return new TSLocation(context, location, activityTransitionEvent);
        } catch (JSONException e2) {
            TSLog.logger.error("Error building TSLocation from json: " + e2.getMessage());
            e2.printStackTrace();
            throw e2;
        }
    }

    private HashMap<String, String> c() {
        HashMap<String, String> map = new HashMap<>();
        map.put("mock", this.w.toString());
        map.put("timestamp", this.h);
        map.put("age", this.i.toString());
        map.put("uuid", this.g);
        map.put("latitude", this.q.toString());
        map.put("longitude", this.r.toString());
        map.put("speed", this.s.toString());
        map.put("speed_accuracy", this.l.toString());
        map.put("heading", this.f116o.toString());
        map.put("heading_accuracy", this.p.toString());
        map.put("accuracy", this.k.toString());
        map.put("altitude", this.m.toString());
        map.put("ellipsoidal_altitude", this.m.toString());
        map.put("altitude_accuracy", this.f115n.toString());
        map.put("is_moving", this.v.toString());
        map.put(NotificationCompat.CATEGORY_EVENT, this.t);
        map.put(LOCATION_OPTIONS_ODOMETER, this.u.toString());
        map.put("activity.type", this.z);
        map.put("activity.confidence", this.A.toString());
        map.put("battery.level", this.C.toString());
        map.put("battery.is_charging", this.B.toString());
        try {
            map.put("timestampMeta", d().toString());
        } catch (JSONException unused) {
        }
        return map;
    }

    private JSONObject d() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("time", a(this.mLocation));
        jSONObject.put("systemTime", System.currentTimeMillis());
        jSONObject.put("systemClockElapsedRealtime", SystemClock.elapsedRealtimeNanos() / AnimationKt.MillisToNanos);
        jSONObject.put("elapsedRealtime", this.mLocation.getElapsedRealtimeNanos() / AnimationKt.MillisToNanos);
        return jSONObject;
    }

    private static void e() {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.US);
        e = new DecimalFormat("#.##", decimalFormatSymbols);
        f = new DecimalFormat("#.#", decimalFormatSymbols);
    }

    public static void resetGeofenceTemplate() {
        d = null;
    }

    public static void resetLocationTemplate() {
        c = null;
    }

    public void addGeofencingEvent(int i, TSGeofence tSGeofence) {
        this.t = "geofence";
        this.D = tSGeofence;
        if (i == 1) {
            this.E = "ENTER";
        } else if (i == 2) {
            this.E = "EXIT";
        } else if (i == 4) {
            this.E = "DWELL";
        }
        this.F = a(System.currentTimeMillis());
    }

    public int getActivityConfidence() {
        return this.A.intValue();
    }

    public String getActivityName() {
        return this.z;
    }

    public long getAge() {
        return this.i.longValue();
    }

    public boolean getBatteryIsCharging() {
        return this.B.booleanValue();
    }

    public double getBatteryLevel() {
        return this.C.doubleValue();
    }

    public DetectedActivity getDetectedActivity() {
        return this.y;
    }

    public String getEvent() {
        return this.t;
    }

    public JSONObject getExtras() {
        return this.G;
    }

    public TSGeofence getGeofence() {
        return this.D;
    }

    public String getGeofenceAction() {
        return this.E;
    }

    public JSONObject getGeofenceExtras() {
        return this.D.getExtras();
    }

    public String getGeofenceIdentifier() {
        return this.D.getIdentifier();
    }

    public String getGeofenceTimestamp() {
        return this.F;
    }

    public boolean getIsMoving() {
        return this.v.booleanValue();
    }

    public Object getJson() throws JSONException {
        return toJson();
    }

    public Location getLocation() {
        return this.mLocation;
    }

    public Float getOdometer() {
        return this.u;
    }

    public String getTimestamp() {
        return this.h;
    }

    public String getUUID() {
        return this.g;
    }

    public boolean hasGeofence() {
        return this.D != null;
    }

    public boolean isSample() {
        return this.x.booleanValue();
    }

    public Object renderJson(Context context) throws Exception {
        TSTemplate tSTemplateA;
        LocationProviderChangeEvent locationProviderChangeEvent;
        LocationProviderChangeEvent locationProviderChangeEvent2;
        TSConfig tSConfig = TSConfig.getInstance(context);
        HashMap<String, String> map = new HashMap<>();
        if (this.D == null) {
            tSTemplateA = b(tSConfig);
            if (tSTemplateA != null) {
                map = c();
            }
        } else {
            tSTemplateA = a(tSConfig);
            if (tSTemplateA != null) {
                map = b();
            }
        }
        if (tSTemplateA == null) {
            return toJson();
        }
        try {
            String strRender = tSTemplateA.render(map);
            try {
                char cCharAt = strRender.charAt(0);
                TSGeofence tSGeofence = this.D;
                if (tSGeofence != null && tSGeofence.getExtras() != null) {
                    if (this.G == null) {
                        this.G = new JSONObject();
                    }
                    this.G = Util.mergeJson(this.G, this.D.getExtras());
                }
                if (cCharAt == '{') {
                    JSONObject jSONObject = new JSONObject(strRender);
                    if (jSONObject.has(NotificationCompat.CATEGORY_EVENT) && jSONObject.getString(NotificationCompat.CATEGORY_EVENT).isEmpty()) {
                        jSONObject.remove(NotificationCompat.CATEGORY_EVENT);
                    }
                    if (this.t.equalsIgnoreCase(BackgroundGeolocation.EVENT_PROVIDERCHANGE) && (locationProviderChangeEvent2 = this.H) != null) {
                        jSONObject.put("provider", locationProviderChangeEvent2.toJson());
                    }
                    if (this.w.booleanValue()) {
                        jSONObject.put("mock", this.w);
                    }
                    JSONObject jSONObject2 = this.G;
                    return jSONObject2 != null ? Util.mergeJson(jSONObject, jSONObject2) : jSONObject;
                }
                if (cCharAt != '[') {
                    throw new JSONException("Invalid JSON: " + strRender);
                }
                JSONArray jSONArray = new JSONArray(strRender);
                if (this.w.booleanValue()) {
                    TSLog.logger.warn(TSLog.warn("Appending #isMock to last index of [Array] in JSON template"));
                    jSONArray.put(this.w);
                }
                if (this.G != null) {
                    TSLog.logger.warn(TSLog.warn("Appending #extras to last index of [Array] in JSON template"));
                    jSONArray.put(this.G);
                }
                if (!this.t.equalsIgnoreCase(BackgroundGeolocation.EVENT_PROVIDERCHANGE) || (locationProviderChangeEvent = this.H) == null) {
                    return jSONArray;
                }
                jSONArray.put(locationProviderChangeEvent.toJson());
                return jSONArray;
            } catch (JSONException e2) {
                a(tSConfig, tSTemplateA, e2);
                throw e2;
            }
        } catch (IllegalArgumentException e3) {
            a(tSConfig, tSTemplateA, e3);
            throw e3;
        }
    }

    public void setEvent(String str) {
        this.t = str;
    }

    public void setExtras(JSONObject jSONObject) {
        JSONObject jSONObject2 = this.G;
        if (jSONObject2 == null) {
            this.G = jSONObject;
            return;
        }
        try {
            this.G = Util.mergeJson(jSONObject2, jSONObject);
        } catch (JSONException e2) {
            TSLog.logger.error(TSLog.error(e2.getMessage()));
            e2.printStackTrace();
        }
    }

    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject;
        synchronized (this) {
            if (this.json == null) {
                this.json = a();
            }
            jSONObject = new JSONObject(this.json.toString());
        }
        return jSONObject;
    }

    public Map<String, Object> toMap() throws JSONException {
        return Util.toMap(toJson());
    }

    private void a(Context context, Location location, ActivityTransitionEvent activityTransitionEvent) {
        this.mLocation = location;
        TSConfig tSConfig = TSConfig.getInstance(context);
        Bundle extras = location.getExtras();
        if (extras == null) {
            extras = new Bundle();
            location.setExtras(extras);
        }
        if (Build.VERSION.SDK_INT >= 31) {
            if (location.isMock()) {
                this.w = Boolean.TRUE;
            }
        } else if (location.isFromMockProvider()) {
            this.w = Boolean.TRUE;
        }
        this.g = UUID.randomUUID().toString();
        this.h = a(a(this.mLocation));
        this.i = Long.valueOf(TSLocationManager.locationAge(this.mLocation));
        this.j = tSConfig.getEnableTimestampMeta().booleanValue();
        this.q = Double.valueOf(location.getLatitude());
        this.r = Double.valueOf(location.getLongitude());
        try {
            this.k = Double.valueOf((!location.hasAccuracy() || Float.isNaN(location.getAccuracy())) ? -1.0d : Double.valueOf(e.format(location.getAccuracy())).doubleValue());
        } catch (NumberFormatException unused) {
            this.k = Double.valueOf(-1.0d);
        }
        try {
            this.m = Double.valueOf((!location.hasAltitude() || Double.isNaN(location.getAltitude())) ? -1.0d : Double.valueOf(e.format(location.getAltitude())).doubleValue());
        } catch (NumberFormatException unused2) {
            this.m = Double.valueOf(-1.0d);
        }
        this.f115n = Double.valueOf(-1.0d);
        if (Build.VERSION.SDK_INT >= 26 && location.hasVerticalAccuracy() && !Double.isNaN(location.getVerticalAccuracyMeters())) {
            try {
                this.f115n = Double.valueOf(e.format(location.getVerticalAccuracyMeters()));
            } catch (NumberFormatException unused3) {
                this.f115n = Double.valueOf(-1.0d);
            }
        }
        try {
            this.s = Double.valueOf((!location.hasSpeed() || Float.isNaN(location.getSpeed())) ? -1.0d : Double.valueOf(e.format(location.getSpeed())).doubleValue());
        } catch (NumberFormatException unused4) {
            this.s = Double.valueOf(-1.0d);
        }
        this.l = Double.valueOf(-1.0d);
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                this.l = Double.valueOf((!location.hasSpeedAccuracy() || Float.isNaN(location.getSpeedAccuracyMetersPerSecond())) ? -1.0d : Double.valueOf(e.format(location.getSpeedAccuracyMetersPerSecond())).doubleValue());
            } catch (NumberFormatException unused5) {
                this.l = Double.valueOf(-1.0d);
            }
        }
        try {
            this.f116o = Double.valueOf((!location.hasBearing() || Float.isNaN(location.getBearing())) ? -1.0d : Double.valueOf(e.format(location.getBearing())).doubleValue());
        } catch (NumberFormatException unused6) {
            this.f116o = Double.valueOf(-1.0d);
        }
        this.p = Double.valueOf(-1.0d);
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                this.p = Double.valueOf((!location.hasBearingAccuracy() || Float.isNaN(location.getBearingAccuracyDegrees())) ? -1.0d : Double.valueOf(e.format(location.getBearingAccuracyDegrees())).doubleValue());
            } catch (NumberFormatException unused7) {
                this.p = Double.valueOf(-1.0d);
            }
        }
        if (activityTransitionEvent != null) {
            this.z = Util.getActivityName(activityTransitionEvent.getActivityType());
            this.A = 100;
        } else {
            this.z = "unknown";
            this.A = 100;
        }
        this.v = tSConfig.getIsMoving();
        if (extras.containsKey("sample")) {
            this.x = Boolean.TRUE;
        }
        if (extras.containsKey(NotificationCompat.CATEGORY_EVENT)) {
            this.t = extras.getString(NotificationCompat.CATEGORY_EVENT);
        }
        if (extras.containsKey("is_heartbeat")) {
            this.t = "heartbeat";
        }
        this.u = Float.valueOf(f.format(tSConfig.getOdometer()));
        a(context);
        this.G = tSConfig.getExtras();
    }

    private static TSTemplate b(TSConfig tSConfig) {
        if (c == null && tSConfig.hasLocationTemplate()) {
            String locationTemplate = tSConfig.getLocationTemplate();
            if (locationTemplate == null) {
                return null;
            }
            c = new TSTemplate(locationTemplate);
        }
        return c;
    }

    public TSLocation(Context context, Location location, ActivityTransitionEvent activityTransitionEvent, LocationProviderChangeEvent locationProviderChangeEvent) {
        Boolean bool = Boolean.FALSE;
        this.w = bool;
        this.x = bool;
        this.B = bool;
        this.C = Double.valueOf(-1.0d);
        this.H = locationProviderChangeEvent;
        a(context, location, activityTransitionEvent);
    }

    static long a(Location location) {
        long time = location.getTime();
        if (time == 0) {
            time = System.currentTimeMillis();
        }
        return (time <= 0 || time >= 1546300800000L) ? time : time + 619315200000L;
    }

    private void a(Context context) {
        int i = Build.VERSION.SDK_INT;
        Double dValueOf = Double.valueOf(-1.0d);
        if (i >= 26) {
            BatteryManager batteryManager = (BatteryManager) context.getSystemService("batterymanager");
            int intProperty = batteryManager.getIntProperty(4);
            int intProperty2 = batteryManager.getIntProperty(6);
            try {
                this.C = Double.valueOf(e.format(intProperty / 100.0f));
            } catch (NumberFormatException unused) {
                this.C = dValueOf;
            }
            this.B = Boolean.valueOf(intProperty2 == 2 || intProperty2 == 5);
            return;
        }
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver == null || !intentRegisterReceiver.hasExtra("level")) {
            return;
        }
        try {
            this.C = Double.valueOf(e.format(intentRegisterReceiver.getIntExtra("level", -1) / intentRegisterReceiver.getIntExtra("scale", -1)));
        } catch (NumberFormatException unused2) {
            this.C = dValueOf;
        }
        int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
        this.B = Boolean.valueOf(intExtra == 2 || intExtra == 5);
    }

    private JSONObject a() throws JSONException {
        LocationProviderChangeEvent locationProviderChangeEvent;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            if (!this.t.isEmpty()) {
                jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.t);
                if (this.t.equalsIgnoreCase(BackgroundGeolocation.EVENT_PROVIDERCHANGE) && (locationProviderChangeEvent = this.H) != null) {
                    jSONObject.put("provider", locationProviderChangeEvent.toJson());
                }
            }
            jSONObject.put("is_moving", this.v);
            jSONObject.put("uuid", this.g);
            jSONObject.put("timestamp", this.h);
            jSONObject.put("age", this.i);
            if (this.j) {
                jSONObject.put("timestampMeta", d());
            }
            jSONObject.put(LOCATION_OPTIONS_ODOMETER, this.u);
            if (this.w.booleanValue()) {
                jSONObject.put("mock", this.w);
            }
            if (this.x.booleanValue()) {
                jSONObject.put("sample", this.x);
            }
            jSONObject2.put("latitude", this.q);
            jSONObject2.put("longitude", this.r);
            jSONObject2.put("accuracy", this.k);
            jSONObject2.put("speed", this.s);
            jSONObject2.put("speed_accuracy", this.l);
            jSONObject2.put("heading", this.f116o);
            jSONObject2.put("heading_accuracy", this.p);
            jSONObject2.put("altitude", this.m);
            jSONObject2.put("ellipsoidal_altitude", this.m);
            jSONObject2.put("altitude_accuracy", this.f115n);
            jSONObject.put("coords", jSONObject2);
            jSONObject3.put("type", this.z);
            jSONObject3.put("confidence", this.A);
            jSONObject.put("activity", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("is_charging", this.B);
            jSONObject4.put("level", this.C);
            jSONObject.put("battery", jSONObject4);
            if (this.D != null) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("identifier", this.D.getIdentifier());
                jSONObject5.put("action", this.E);
                jSONObject5.put("timestamp", this.F);
                if (this.D.getExtras() != null) {
                    jSONObject5.put("extras", this.D.getExtras());
                }
                jSONObject.put("geofence", jSONObject5);
            }
            JSONObject jSONObject6 = this.G;
            if (jSONObject6 != null) {
                jSONObject.put("extras", jSONObject6);
            }
            return jSONObject;
        } catch (JSONException e2) {
            TSLog.logger.error(TSLog.error("JSON Error"), (Throwable) e2);
            e2.printStackTrace();
            throw e2;
        }
    }

    private static TSTemplate a(TSConfig tSConfig) {
        if (d == null && tSConfig.hasGeofenceTemplate()) {
            String geofenceTemplate = tSConfig.getGeofenceTemplate();
            if (geofenceTemplate == null) {
                return null;
            }
            d = new TSTemplate(geofenceTemplate);
        }
        return d;
    }

    private void a(TSConfig tSConfig, TSTemplate tSTemplate, Exception exc) {
        String str = tSTemplate == b(tSConfig) ? "locationTemplate" : "geofenceTemplate";
        if (tSConfig.getDebug().booleanValue()) {
            EventBus.getDefault().post(new TemplateErrorEvent(str, exc));
        }
        TSLog.logger.error(TSLog.error("You have an error in your " + str + ":\n\"" + exc.getMessage() + "\""));
    }
}
