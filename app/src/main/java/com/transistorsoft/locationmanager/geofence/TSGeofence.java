package com.transistorsoft.locationmanager.geofence;

import com.google.android.gms.location.Geofence;
import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.locationmanager.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TSGeofence {
    public static final String FIELD_EXTRAS = "extras";
    public static final String FIELD_IDENTIFIER = "identifier";
    public static final String FIELD_LATITUDE = "latitude";
    public static final String FIELD_LOITERING_DELAY = "loiteringDelay";
    public static final String FIELD_LONGITUDE = "longitude";
    public static final String FIELD_NOTIFY_ON_DWELL = "notifyOnDwell";
    public static final String FIELD_NOTIFY_ON_ENTRY = "notifyOnEntry";
    public static final String FIELD_NOTIFY_ON_EXIT = "notifyOnExit";
    public static final String FIELD_RADIUS = "radius";
    public static final String FIELD_VERTICES = "vertices";
    public static final float MINIMUM_RADIUS = 150.0f;
    private static final Object a;
    private static final String b = "Latitude is required";
    private static final String c = "Longitude is required";
    private static final String d = "Radius is required";
    private static final String e = "Identifier is required";
    private static final String f = "A transition-type is required (notifyOnEntry | notifyOnExit | notifyOnDwell)";
    private static final String g = "Invalid JSON for extras";
    private final String h;
    private final Double i;
    private final Double j;
    private final Float k;
    private final Boolean l;
    private final Boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Boolean f109n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Integer f110o;
    private final Integer p;
    private final JSONObject q;
    private final List<List<Double>> r;
    private Geofence s;
    private IllegalArgumentException t;

    /* JADX INFO: loaded from: classes3.dex */
    public static class Builder {
        private String a;
        private Double b;
        private Double c;
        private Float d;
        private Boolean e;
        private Boolean f;
        private Boolean g;
        private Integer h;
        private Integer i;
        private JSONObject j;
        private List<List<Double>> k;

        public Builder() {
            Boolean bool = Boolean.FALSE;
            this.e = bool;
            this.f = bool;
            this.g = bool;
            this.j = null;
            this.k = new ArrayList();
            this.d = Float.valueOf(200.0f);
            this.h = 0;
        }

        public TSGeofence build() throws Exception {
            if (!this.k.isEmpty() && (this.b == null || this.c == null)) {
                double[] dArrNativeMinimumEnclosingCircle = TSGeofence.nativeMinimumEnclosingCircle(TSGeofence.b(this.k));
                TSLog.logger.debug("[MiniBall] Minimum Enclosing Circle: " + dArrNativeMinimumEnclosingCircle[0] + " / " + dArrNativeMinimumEnclosingCircle[1] + ", radius: " + dArrNativeMinimumEnclosingCircle[2]);
                this.b = Double.valueOf(dArrNativeMinimumEnclosingCircle[0]);
                this.c = Double.valueOf(dArrNativeMinimumEnclosingCircle[1]);
                this.d = Float.valueOf((float) Math.round(dArrNativeMinimumEnclosingCircle[2]));
                Boolean bool = Boolean.TRUE;
                this.e = bool;
                this.f = bool;
            }
            if (this.b == null) {
                throw new Exception(TSGeofence.b);
            }
            if (this.c == null) {
                throw new Exception(TSGeofence.c);
            }
            Float f = this.d;
            if (f == null) {
                throw new Exception(TSGeofence.d);
            }
            if (f.floatValue() < 150.0f) {
                TSLog.logger.warn(TSLog.warn("Geofence radius: " + this.d + ":  recommended geofence radius is >= 150.0meters"));
            }
            if (this.a == null) {
                throw new Exception(TSGeofence.e);
            }
            if (this.e.booleanValue() || this.f.booleanValue() || this.g.booleanValue()) {
                return new TSGeofence(this);
            }
            throw new Exception(TSGeofence.f);
        }

        public Builder setExtras(JSONObject jSONObject) {
            this.j = jSONObject;
            return this;
        }

        public Builder setIdentifier(String str) {
            this.a = str;
            return this;
        }

        public Builder setLatitude(double d) {
            this.b = Double.valueOf(d);
            return this;
        }

        public Builder setLoiteringDelay(int i) {
            this.h = Integer.valueOf(i);
            return this;
        }

        public Builder setLongitude(double d) {
            this.c = Double.valueOf(d);
            return this;
        }

        public Builder setNotificationResponsiveness(int i) {
            this.i = Integer.valueOf(i);
            return this;
        }

        public Builder setNotifyOnDwell(boolean z) {
            this.g = Boolean.valueOf(z);
            return this;
        }

        public Builder setNotifyOnEntry(boolean z) {
            this.e = Boolean.valueOf(z);
            return this;
        }

        public Builder setNotifyOnExit(boolean z) {
            this.f = Boolean.valueOf(z);
            return this;
        }

        public Builder setRadius(float f) {
            this.d = Float.valueOf(f);
            return this;
        }

        public Builder setVertices(List<List<Double>> list) {
            this.k = list;
            return this;
        }

        public Builder setExtras(String str) {
            if (str != null) {
                try {
                    this.j = new JSONObject(str);
                } catch (JSONException e) {
                    TSLog.logger.error(TSLog.error("Invalid JSON provided to TSGeofence#setExtras: " + e.getMessage()));
                }
            }
            return this;
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static class Exception extends Throwable {
        public Exception(String str) {
            super(str);
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static class LocationInPolygonResult {
        public final boolean centerIsInPolygon;
        public final float confidence;

        LocationInPolygonResult(float f, boolean z) {
            this.confidence = Math.round(((double) f) * 100.0d) / 100.0f;
            this.centerIsInPolygon = z;
        }
    }

    static {
        System.loadLibrary("tslocationmanager");
        a = new Object();
    }

    public TSGeofence(Builder builder) {
        this.h = builder.a;
        this.i = builder.b;
        this.j = builder.c;
        this.k = builder.d;
        this.l = builder.e;
        this.m = builder.f;
        this.f109n = builder.g;
        this.f110o = builder.h;
        this.q = builder.j;
        this.r = builder.k;
        this.p = builder.i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double[][] b(List<List<Double>> list) {
        double[][] dArr = new double[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            List<Double> list2 = list.get(i);
            dArr[i] = new double[]{list2.get(1).doubleValue(), list2.get(0).doubleValue()};
        }
        return dArr;
    }

    public static void clearPolygon(String str) {
        synchronized (a) {
            nativeClearPolygon(str);
        }
    }

    public static LocationInPolygonResult isLocationInPolygon(String str, double d2, double d3, float f2) {
        LocationInPolygonResult locationInPolygonResult;
        synchronized (a) {
            float[] fArrNativeIsLocationInPolygon = nativeIsLocationInPolygon(str, d2, d3, f2);
            locationInPolygonResult = new LocationInPolygonResult(fArrNativeIsLocationInPolygon[0], fArrNativeIsLocationInPolygon[1] != 0.0f);
            TSLog.logger.debug("--> " + str + ": " + (locationInPolygonResult.confidence * 100.0f) + "%");
        }
        return locationInPolygonResult;
    }

    public static native void nativeClearPolygon(String str);

    public static native float[] nativeIsLocationInPolygon(String str, double d2, double d3, float f2);

    public static native void nativeLoadPolygon(String str, double[][] dArr);

    public static native double[] nativeMinimumEnclosingCircle(double[][] dArr);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v2 */
    public Geofence build() throws IllegalArgumentException {
        boolean zBooleanValue = this.l.booleanValue();
        ?? r0 = zBooleanValue;
        if (this.m.booleanValue()) {
            r0 = (zBooleanValue ? 1 : 0) | 2;
        }
        int i = r0;
        if (this.f109n.booleanValue() && !isPolygon()) {
            i = r0;
            i = (r0 == true ? 1 : 0) | 4;
        }
        i = r0;
        Geofence geofenceBuild = new Geofence.Builder().setRequestId(this.h).setCircularRegion(this.i.doubleValue(), this.j.doubleValue(), this.k.floatValue()).setExpirationDuration(-1L).setTransitionTypes(i).setLoiteringDelay(this.f110o.intValue()).setNotificationResponsiveness(0).build();
        this.s = geofenceBuild;
        return geofenceBuild;
    }

    public JSONObject getExtras() {
        return this.q;
    }

    public String getIdentifier() {
        return this.h;
    }

    public double getLatitude() {
        return this.i.doubleValue();
    }

    public int getLoiteringDelay() {
        return this.f110o.intValue();
    }

    public double getLongitude() {
        return this.j.doubleValue();
    }

    public int getNoificationResponsiveness() {
        return this.p.intValue();
    }

    public boolean getNotifyOnDwell() {
        return this.f109n.booleanValue();
    }

    public boolean getNotifyOnEntry() {
        return this.l.booleanValue();
    }

    public boolean getNotifyOnExit() {
        return this.m.booleanValue();
    }

    public float getRadius() {
        return this.k.floatValue();
    }

    public List<List<Double>> getVertices() {
        return this.r;
    }

    public boolean isPolygon() {
        return this.r.size() > 0;
    }

    public void startMonitoringPolygon() {
        a(this.h, b(this.r));
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("identifier", this.h);
            jSONObject.put(FIELD_RADIUS, this.k.floatValue());
            jSONObject.put("latitude", this.i);
            jSONObject.put("longitude", this.j);
            jSONObject.put(FIELD_NOTIFY_ON_ENTRY, this.l);
            jSONObject.put(FIELD_NOTIFY_ON_EXIT, this.m);
            jSONObject.put(FIELD_NOTIFY_ON_DWELL, this.f109n);
            jSONObject.put(FIELD_LOITERING_DELAY, this.f110o);
            jSONObject.put("extras", this.q);
            JSONArray jSONArray = new JSONArray();
            for (List<Double> list : this.r) {
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(0, list.get(0));
                jSONArray2.put(1, list.get(1));
                jSONArray.put(jSONArray2);
            }
            jSONObject.put(FIELD_VERTICES, jSONArray);
        } catch (JSONException e2) {
            TSLog.logger.error(e2.getMessage());
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public Map<String, Object> toMap() {
        HashMap map = new HashMap();
        map.put("identifier", this.h);
        map.put(FIELD_RADIUS, Double.valueOf(this.k.floatValue()));
        map.put("latitude", this.i);
        map.put("longitude", this.j);
        map.put(FIELD_NOTIFY_ON_ENTRY, this.l);
        map.put(FIELD_NOTIFY_ON_EXIT, this.m);
        map.put(FIELD_NOTIFY_ON_DWELL, this.f109n);
        map.put(FIELD_LOITERING_DELAY, this.f110o);
        map.put(FIELD_VERTICES, this.r);
        JSONObject jSONObject = this.q;
        if (jSONObject != null) {
            try {
                map.put("extras", Util.toMap(jSONObject));
            } catch (JSONException e2) {
                TSLog.logger.warn(TSLog.warn("Failed to convert TSGeofence extras toMap"));
                e2.printStackTrace();
            }
        }
        return map;
    }

    private static void a(String str, double[][] dArr) {
        synchronized (a) {
            nativeLoadPolygon(str, dArr);
        }
    }

    boolean b() {
        try {
            build();
            return true;
        } catch (IllegalArgumentException e2) {
            this.t = e2;
            return false;
        }
    }

    IllegalArgumentException a() {
        return this.t;
    }
}
