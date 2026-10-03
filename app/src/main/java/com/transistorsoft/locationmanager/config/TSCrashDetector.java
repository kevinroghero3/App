package com.transistorsoft.locationmanager.config;

import android.util.Log;
import com.facebook.react.uimanager.ViewProps;
import com.transistorsoft.locationmanager.logger.TSLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class TSCrashDetector extends a implements IModule {
    public static final String NAME = "crashDetector";
    private Boolean c;
    private Double d;
    private Double e;
    private Double f;
    private Double g;

    public TSCrashDetector() {
        super(NAME);
        applyDefaults();
    }

    @Override // com.transistorsoft.locationmanager.config.IModule
    public void applyDefaults() {
        if (this.c == null) {
            this.c = Boolean.FALSE;
        }
        if (this.d == null) {
            this.d = Double.valueOf(20.0d);
        }
        if (this.e == null) {
            this.e = Double.valueOf(4.5d);
        }
        if (this.f == null) {
            this.f = Double.valueOf(20.0d);
        }
        if (this.g == null) {
            this.g = Double.valueOf(4.5d);
        }
    }

    public boolean equals(TSCrashDetector tSCrashDetector) {
        Double d;
        Double d2;
        Double d3;
        Double d4;
        Boolean bool = this.c;
        return bool != null && bool.equals(tSCrashDetector.getEnabled()) && (d = this.d) != null && d.equals(tSCrashDetector.getAccelerometerThresholdHigh()) && (d2 = this.e) != null && d2.equals(tSCrashDetector.getAccelerometerThresholdLow()) && (d3 = this.f) != null && d3.equals(tSCrashDetector.getGyroscopeThresholdHigh()) && (d4 = this.g) != null && d4.equals(tSCrashDetector.getGyroscopeThresholdLow());
    }

    public Double getAccelerometerThresholdHigh() {
        return this.d;
    }

    public Double getAccelerometerThresholdLow() {
        return this.e;
    }

    @Override // com.transistorsoft.locationmanager.config.a
    public /* bridge */ /* synthetic */ List getDirtyFields() {
        return super.getDirtyFields();
    }

    public Boolean getEnabled() {
        return this.c;
    }

    public Double getGyroscopeThresholdHigh() {
        return this.f;
    }

    public Double getGyroscopeThresholdLow() {
        return this.g;
    }

    public void setAccelerometerThresholdHigh(Double d) {
        this.d = d;
    }

    public void setAccelerometerThresholdLow(Double d) {
        this.e = d;
    }

    public void setEnabled(Boolean bool) {
        this.c = bool;
    }

    public void setGyroscopeThresholdHigh(Double d) {
        this.f = d;
    }

    public void setGyroscopeThresholdLow(Double d) {
        this.g = d;
    }

    @Override // com.transistorsoft.locationmanager.config.IModule
    public JSONObject toJson(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ViewProps.ENABLED, this.c);
            jSONObject.put("accelerometerThresholdHigh", this.d);
            jSONObject.put("accelerometerThresholdLow", this.e);
            jSONObject.put("gyroscopeThresholdHigh", this.f);
            jSONObject.put("gyroscopeThresholdLow", this.g);
        } catch (JSONException e) {
            Log.i("TSLocationManager", TSLog.error(e.getMessage()));
            TSLog.logger.error(TSLog.error(e.getMessage()), (Throwable) e);
            e.printStackTrace();
        }
        return jSONObject;
    }

    public Map<String, Object> toMap() {
        HashMap map = new HashMap();
        map.put(ViewProps.ENABLED, this.c);
        map.put("accelerometerThresholdHigh", this.d);
        map.put("accelerometerThresholdLow", this.e);
        map.put("gyroscopeThresholdHigh", this.f);
        map.put("gyroscopeThresholdLow", this.g);
        return map;
    }

    public boolean update(TSCrashDetector tSCrashDetector) {
        a();
        if (tSCrashDetector.getEnabled() != null && !tSCrashDetector.getEnabled().equals(this.c)) {
            this.c = tSCrashDetector.getEnabled();
            a(ViewProps.ENABLED);
        }
        if (tSCrashDetector.getAccelerometerThresholdHigh() != null && !tSCrashDetector.getAccelerometerThresholdHigh().equals(this.d)) {
            this.d = tSCrashDetector.getAccelerometerThresholdHigh();
            a("accelerometerThresholdHigh");
        }
        if (tSCrashDetector.getAccelerometerThresholdLow() != null && !tSCrashDetector.getAccelerometerThresholdLow().equals(this.e)) {
            this.e = tSCrashDetector.getAccelerometerThresholdLow();
            a("accelerometerThresholdLow");
        }
        if (tSCrashDetector.getGyroscopeThresholdHigh() != null && !tSCrashDetector.getGyroscopeThresholdHigh().equals(this.f)) {
            this.f = tSCrashDetector.getGyroscopeThresholdHigh();
            a("gyroscopeThresholdHigh");
        }
        if (tSCrashDetector.getGyroscopeThresholdLow() != null && !tSCrashDetector.getGyroscopeThresholdLow().equals(this.g)) {
            this.g = tSCrashDetector.getGyroscopeThresholdLow();
            a("gyroscopeThresholdLow");
        }
        return !getDirtyFields().isEmpty();
    }

    public TSCrashDetector(JSONObject jSONObject, boolean z) throws JSONException {
        super(NAME);
        if (jSONObject.has(ViewProps.ENABLED)) {
            this.c = Boolean.valueOf(jSONObject.getBoolean(ViewProps.ENABLED));
        }
        if (jSONObject.has("accelerometerThresholdHigh")) {
            this.d = Double.valueOf(jSONObject.getDouble("accelerometerThresholdHigh"));
        }
        if (jSONObject.has("accelerometerThresholdLow")) {
            this.e = Double.valueOf(jSONObject.getDouble("accelerometerThresholdLow"));
        }
        if (jSONObject.has("gyroscopeThresholdHigh")) {
            this.f = Double.valueOf(jSONObject.getDouble("gyroscopeThresholdHigh"));
        }
        if (jSONObject.has("gyroscopeThresholdLow")) {
            this.g = Double.valueOf(jSONObject.getDouble("gyroscopeThresholdLow"));
        }
        if (z) {
            applyDefaults();
        }
    }
}
