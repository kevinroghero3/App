package com.transistorsoft.locationmanager.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.transistorsoft.locationmanager.logger.TSLog;

/* JADX INFO: loaded from: classes.dex */
public class Sensors {
    private static Sensors i;
    private final Sensor a;
    private final Sensor b;
    private final Sensor c;
    private final Sensor d;
    private final Sensor e;
    private final Sensor f;
    private final Sensor g;
    private final Sensor h;

    public Sensors(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.c = sensorManager.getDefaultSensor(4);
        this.b = sensorManager.getDefaultSensor(2);
        this.a = sensorManager.getDefaultSensor(1);
        this.d = sensorManager.getDefaultSensor(17);
        this.e = sensorManager.getDefaultSensor(9);
        this.f = sensorManager.getDefaultSensor(11);
        this.g = sensorManager.getDefaultSensor(19);
        this.h = sensorManager.getDefaultSensor(18);
    }

    public static Sensors getInstance(Context context) {
        if (i == null) {
            i = new Sensors(context.getApplicationContext());
        }
        return i;
    }

    public boolean hasAccelerometer() {
        return this.a != null;
    }

    public boolean hasAllActivityRecognitionSensors() {
        return hasGyroscope() && hasAccelerometer() && hasMagnetometer();
    }

    public boolean hasGravity() {
        return this.e != null;
    }

    public boolean hasGyroscope() {
        return this.c != null;
    }

    public boolean hasMagnetometer() {
        return this.b != null;
    }

    public boolean hasRotation() {
        return this.f != null;
    }

    public boolean hasSignificantMotion() {
        return this.d != null;
    }

    public boolean hasStepCounter() {
        return this.g != null;
    }

    public boolean hasStepDetector() {
        return this.h != null;
    }

    public StringBuffer print() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(TSLog.header("DEVICE SENSORS"));
        if (hasAccelerometer()) {
            stringBuffer.append(TSLog.boxRow("✅  ACCELEROMETER: " + this.a));
        } else {
            stringBuffer.append(TSLog.boxRow("⚠️  ACCELEROMETER:  none.  Motion-detection system performance will be degraded"));
        }
        if (hasGyroscope()) {
            stringBuffer.append(TSLog.boxRow("✅  GYROSCOPE: " + this.c));
        } else {
            stringBuffer.append(TSLog.boxRow("⚠️  GYROSCOPE:  none.  Motion-detection system performance will be degraded"));
        }
        if (hasMagnetometer()) {
            stringBuffer.append(TSLog.boxRow("✅  MAGNETOMETER: " + this.b));
        } else {
            stringBuffer.append(TSLog.boxRow("⚠️  MAGNETOMETER:  none.  Motion-detection system performance will be degraded"));
        }
        if (hasSignificantMotion()) {
            stringBuffer.append(TSLog.boxRow("✅  SIGNIFICANT_MOTION: " + this.d));
        } else {
            stringBuffer.append(TSLog.boxRow("⚠️  SIGNIFICANT_MOTION:  none.  Motion-detection system performance will be degraded"));
        }
        stringBuffer.append(TSLog.BOX_BOTTOM);
        return stringBuffer;
    }
}
