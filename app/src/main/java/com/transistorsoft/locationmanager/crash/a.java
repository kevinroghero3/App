package com.transistorsoft.locationmanager.crash;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import com.transistorsoft.locationmanager.adapter.TSConfig;
import com.transistorsoft.locationmanager.config.TSCrashDetector;
import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.locationmanager.logger.TSMediaPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class a implements SensorEventListener {
    private static final double a = 9.80665d;
    private static final double b = 50.0d;
    private static final double c = 45.0d;
    private static final long d = 100;
    private static a e = null;
    private static final int f = 1000000;
    private static final double g = 23.0d;
    private static final double h = 18.0d;
    private static final double i = 65.5d;
    private final AtomicReference<Double> C;
    private final AtomicReference<Double> D;
    private Long E;
    private Long F;
    private List<Map<EnumC0123a, Double>> G;
    private Context j;
    private SensorManager k;
    private final AtomicBoolean l = new AtomicBoolean(false);
    private double m = 20.0d;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private double f107n = 4.5d;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private double f108o = 20.0d;
    private double p = 4.5d;
    private double q = 15.0d;
    private double r = 15.0d;
    private long s = 0;
    private long t = 0;
    private long u = 0;
    private final AtomicBoolean v = new AtomicBoolean(false);
    private final AtomicBoolean w = new AtomicBoolean(false);
    private final AtomicBoolean x = new AtomicBoolean(false);
    private final AtomicBoolean y = new AtomicBoolean(false);
    private final Handler z = new Handler(Looper.getMainLooper());
    private final Runnable A = new Runnable() { // from class: com.transistorsoft.locationmanager.crash.a$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.c();
        }
    };
    private final List<b> B = new ArrayList();

    /* JADX INFO: renamed from: com.transistorsoft.locationmanager.crash.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes6.dex */
    public enum EnumC0123a {
        X,
        Y,
        Z,
        ACCELERATION
    }

    private a(Context context) {
        Double dValueOf = Double.valueOf(0.0d);
        this.C = new AtomicReference<>(dValueOf);
        this.D = new AtomicReference<>(dValueOf);
        this.F = 1000L;
        this.G = new ArrayList();
        this.j = context;
    }

    public static a a(Context context) {
        if (e == null) {
            e = b(context.getApplicationContext());
        }
        return e;
    }

    private static a b(Context context) {
        a aVar;
        synchronized (a.class) {
            if (e == null) {
                e = new a(context.getApplicationContext());
            }
            aVar = e;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        boolean z = this.x.get();
        boolean z2 = this.y.get();
        this.v.set(false);
        this.x.set(false);
        AtomicReference<Double> atomicReference = this.C;
        Double dValueOf = Double.valueOf(0.0d);
        atomicReference.set(dValueOf);
        this.w.set(false);
        this.y.set(false);
        this.D.set(dValueOf);
        if (TSConfig.getInstance(this.j).getDebug().booleanValue()) {
            e();
        }
        synchronized (this.B) {
            this.B.clear();
        }
        if (!z || !z2) {
            TSLog.logger.debug(TSLog.header("Crash Analyzer: NO CRASH"));
        } else {
            TSLog.logger.debug(TSLog.header("Crash Analyzer:  CRASH DETECTED!"));
            TSMediaPlayer.getInstance().debug(this.j, "tslocationmanager_music_timpani_error_01");
        }
    }

    private boolean d() {
        Long l = this.E;
        return l == null || l.longValue() + this.F.longValue() < System.currentTimeMillis();
    }

    private void e() {
        TSLog.logger.debug(TSLog.header("Crash Analyzer: Data"));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\nTIMESTAMP,ACCELEROMETER,GYROSCOPE\n");
        Iterator<b> it2 = this.B.iterator();
        while (it2.hasNext()) {
            stringBuffer.append(it2.next().toString());
        }
        TSLog.logger.debug(stringBuffer.toString());
    }

    private void g() {
        synchronized (this.A) {
            this.z.removeCallbacks(this.A);
            this.z.postDelayed(this.A, 250L);
        }
    }

    public void f() {
        TSCrashDetector crashDetector = TSConfig.getInstance(this.j).getCrashDetector();
        if (crashDetector.getEnabled().booleanValue()) {
            this.m = crashDetector.getAccelerometerThresholdHigh().doubleValue();
            this.f107n = crashDetector.getAccelerometerThresholdLow().doubleValue();
            this.f108o = crashDetector.getGyroscopeThresholdHigh().doubleValue();
            this.p = crashDetector.getGyroscopeThresholdLow().doubleValue();
            SensorManager sensorManager = (SensorManager) this.j.getSystemService("sensor");
            this.k = sensorManager;
            if (sensorManager != null) {
                Sensor defaultSensor = sensorManager.getDefaultSensor(1);
                Sensor defaultSensor2 = this.k.getDefaultSensor(4);
                this.k.registerListener(this, defaultSensor, 0);
                this.k.registerListener(this, defaultSensor2, 0);
                this.l.set(true);
                TSLog.logger.debug(TSLog.on("Start crash-detector"));
            }
        }
    }

    public void h() {
        if (this.l.compareAndSet(true, false)) {
            try {
                this.k.unregisterListener(this);
                TSLog.logger.debug(TSLog.off("Stop crash-detector"));
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor = sensorEvent.sensor;
        if (sensor.getType() == 1) {
            a(sensorEvent.values, sensorEvent.timestamp);
        } else if (sensor.getType() == 4) {
            b(sensorEvent.values, sensorEvent.timestamp);
        } else {
            sensor.getType();
        }
    }

    private void b(float[] fArr, long j) {
        float f2 = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[2];
        double dSqrt = Math.sqrt((f2 * f2) + (f3 * f3) + (f4 * f4));
        boolean z = this.w.get();
        boolean z2 = this.v.get();
        if (z || z2) {
            this.D.set(Double.valueOf(dSqrt));
        }
        if (dSqrt <= this.f108o && (!z || dSqrt <= this.p)) {
            if (z) {
                this.w.set(false);
                TSLog.logger.debug(TSLog.off("Gyroscope triggered OFF"));
                return;
            }
            return;
        }
        if (!z) {
            this.D.set(Double.valueOf(dSqrt));
            this.w.set(true);
            this.t = j;
            TSLog.logger.debug(TSLog.on("Gyroscope triggered ON"));
        } else {
            long j2 = ((j - this.t) / 1000) / 1000;
            TSLog.logger.debug("- [Gyroscope] " + dSqrt + ", hysteresis dt: " + j2);
            if (j2 > this.r) {
                this.y.set(true);
            }
        }
        a(j);
        g();
    }

    private void a(float[] fArr, long j) {
        double d2 = fArr[0];
        double d3 = fArr[1];
        double d4 = fArr[2];
        double dSqrt = Math.sqrt(((d2 * d2) + (d3 * d3)) + (d4 * d4)) / 9.806650161743164d;
        boolean z = this.v.get();
        boolean z2 = this.w.get();
        if (z || z2) {
            this.C.set(Double.valueOf(dSqrt));
        }
        if (dSqrt <= this.m && (!z || dSqrt <= this.f107n)) {
            if (z) {
                this.v.set(false);
                TSLog.logger.debug(TSLog.off("Accelerometer triggered OFF"));
                return;
            }
            return;
        }
        if (!z) {
            this.C.set(Double.valueOf(dSqrt));
            this.v.set(true);
            this.s = j;
            TSLog.logger.debug(TSLog.on("Accelerometer triggered ON"));
        } else {
            long j2 = ((j - this.s) / 1000) / 1000;
            TSLog.logger.debug("- [Accelerometer] " + dSqrt + ", hysteresis dt: " + j2);
            if (j2 > this.q) {
                this.x.set(true);
            }
        }
        a(j);
        g();
    }

    private boolean b(double d2, double d3, double d4) {
        double dA = a(d2, d3, d4);
        a(d2, d3, d4, dA);
        StringBuilder sb = new StringBuilder("x: ");
        sb.append(d2);
        sb.append(" y: ");
        sb.append(d3);
        sb.append(" z: ");
        sb.append(d4);
        sb.append(" acc: ");
        sb.append(dA);
        if (dA <= g || a() <= h || b() <= i) {
            return false;
        }
        sb.append(System.currentTimeMillis());
        TSLog.logger.debug(sb.toString());
        return true;
    }

    private void a(long j) {
        synchronized (this.B) {
            this.B.add(new b(j, this.C.get().doubleValue(), this.D.get().doubleValue()));
        }
    }

    private double a() {
        int size = this.G.size();
        if (size < 2) {
            return -1.0d;
        }
        Map<EnumC0123a, Double> map = this.G.get(size - 2);
        Map<EnumC0123a, Double> map2 = this.G.get(size - 1);
        EnumC0123a enumC0123a = EnumC0123a.X;
        double dDoubleValue = map.get(enumC0123a).doubleValue();
        double dDoubleValue2 = map2.get(enumC0123a).doubleValue();
        EnumC0123a enumC0123a2 = EnumC0123a.Y;
        double dDoubleValue3 = map.get(enumC0123a2).doubleValue();
        double dDoubleValue4 = map2.get(enumC0123a2).doubleValue();
        EnumC0123a enumC0123a3 = EnumC0123a.Z;
        return Math.acos((((dDoubleValue2 * dDoubleValue) + (dDoubleValue3 * dDoubleValue4)) + (map.get(enumC0123a3).doubleValue() * map2.get(enumC0123a3).doubleValue())) / (Math.sqrt((Math.pow(map.get(enumC0123a).doubleValue(), 2.0d) + Math.pow(map.get(enumC0123a2).doubleValue(), 2.0d)) + Math.pow(map.get(enumC0123a3).doubleValue(), 2.0d)) * Math.sqrt((Math.pow(map2.get(enumC0123a).doubleValue(), 2.0d) + Math.pow(map2.get(enumC0123a2).doubleValue(), 2.0d)) + Math.pow(map2.get(enumC0123a3).doubleValue(), 2.0d)))) * 57.29577951308232d;
    }

    private double b() {
        if (this.G.size() < 4) {
            return -1.0d;
        }
        Map<EnumC0123a, Double> map = this.G.get(0);
        Map<EnumC0123a, Double> map2 = this.G.get(3);
        EnumC0123a enumC0123a = EnumC0123a.X;
        double dDoubleValue = map.get(enumC0123a).doubleValue() * map2.get(enumC0123a).doubleValue();
        EnumC0123a enumC0123a2 = EnumC0123a.Y;
        double dDoubleValue2 = map.get(enumC0123a2).doubleValue() * map2.get(enumC0123a2).doubleValue();
        EnumC0123a enumC0123a3 = EnumC0123a.Z;
        double dDoubleValue3 = map.get(enumC0123a3).doubleValue() * map2.get(enumC0123a3).doubleValue();
        return Math.acos(((dDoubleValue + dDoubleValue2) + dDoubleValue3) / ((Math.sqrt(Math.pow(dDoubleValue, 2.0d)) + Math.sqrt(Math.pow(dDoubleValue2, 2.0d))) + Math.sqrt(Math.pow(dDoubleValue3, 2.0d)))) * 57.29577951308232d;
    }

    private void a(double d2, double d3, double d4, double d5) {
        if (this.G.size() >= 4) {
            this.G.remove(0);
        }
        HashMap map = new HashMap();
        map.put(EnumC0123a.X, Double.valueOf(d2));
        map.put(EnumC0123a.Y, Double.valueOf(d3));
        map.put(EnumC0123a.Z, Double.valueOf(d4));
        map.put(EnumC0123a.ACCELERATION, Double.valueOf(d5));
        this.G.add(map);
    }

    private double a(double d2, double d3, double d4) {
        return Math.abs(d2) + Math.abs(d3) + Math.abs(d4);
    }
}
