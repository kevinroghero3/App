package com.transistorsoft.locationmanager.location;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.intentfilter.androidpermissions.PermissionManager;
import com.intentfilter.androidpermissions.models.DeniedPermissions;
import com.transistorsoft.locationmanager.adapter.BackgroundGeolocation;
import com.transistorsoft.locationmanager.adapter.TSConfig;
import com.transistorsoft.locationmanager.adapter.callback.TSLocationCallback;
import com.transistorsoft.locationmanager.event.SecurityExceptionEvent;
import com.transistorsoft.locationmanager.lifecycle.LifecycleManager;
import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.locationmanager.service.AbstractService;
import com.transistorsoft.locationmanager.service.LocationRequestService;
import com.transistorsoft.locationmanager.util.LocationAuthorization;
import com.transistorsoft.locationmanager.util.Util;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SingleLocationRequest {
    public static final int ACTION_GET_CURRENT_POSITION = 2;
    public static final int ACTION_GET_CURRENT_STATE = 4;
    public static final int ACTION_MOTION_CHANGE = 1;
    public static final int ACTION_PROVIDER_CHANGE = 3;
    public static final int ACTION_WATCH_POSITION = 5;
    public static final Float GOOD_ACCURACY_THRESHOLD = Float.valueOf(10.0f);
    private static final Integer s = 5;
    private static final AtomicInteger t = new AtomicInteger();
    protected int a;
    protected Context b;
    protected long c;
    protected final AtomicInteger d;
    protected boolean e;
    protected int f;
    protected JSONObject g;
    protected TSLocationCallback h;
    private TSLocationCallback i;
    private int j;
    private final AtomicInteger k;
    private final AtomicBoolean l;
    private long m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final AtomicBoolean f113n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final AtomicBoolean f114o;
    private final Handler p;
    private Runnable q;
    private final ArrayList<Location> r;

    public static class Builder<T extends Builder<T>> {
        Context a;
        int b;
        boolean c;
        int d;
        int e;
        private JSONObject f;
        private TSLocationCallback g;
        protected int h;

        class a implements TSLocationCallback {
            a() {
            }

            @Override // com.transistorsoft.locationmanager.adapter.callback.TSLocationCallback
            public void onError(Integer num) {
            }

            @Override // com.transistorsoft.locationmanager.adapter.callback.TSLocationCallback
            public void onLocation(TSLocation tSLocation) {
            }
        }

        public Builder(Context context) {
            TSConfig tSConfig = TSConfig.getInstance(context);
            this.a = context;
            this.c = tSConfig.getEnabled().booleanValue();
            this.b = tSConfig.getLocationTimeout().intValue();
            this.d = 3;
            this.e = tSConfig.getStationaryRadius().intValue();
            this.g = new a();
        }

        public SingleLocationRequest build() {
            return new SingleLocationRequest(this);
        }

        public int getAction() {
            return this.h;
        }

        public T setCallback(TSLocationCallback tSLocationCallback) {
            this.g = tSLocationCallback;
            return this;
        }

        public T setDesiredAccuracy(int i) {
            this.e = i;
            return this;
        }

        public T setExtras(JSONObject jSONObject) {
            this.f = jSONObject;
            return this;
        }

        public T setPersist(boolean z) {
            this.c = z;
            return this;
        }

        public T setSamples(int i) {
            this.d = i;
            return this;
        }

        public T setTimeout(int i) {
            this.b = i;
            return this;
        }
    }

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

    class b implements PermissionManager.PermissionRequestListener {
        b() {
        }

        @Override // com.intentfilter.androidpermissions.PermissionManager.PermissionRequestListener
        public void onPermissionDenied(DeniedPermissions deniedPermissions) {
            SingleLocationRequest.this.onError(1);
        }

        @Override // com.intentfilter.androidpermissions.PermissionManager.PermissionRequestListener
        public void onPermissionGranted() {
            TSLocationManager tSLocationManager = TSLocationManager.getInstance(SingleLocationRequest.this.b);
            if (tSLocationManager == null) {
                SingleLocationRequest.this.onError(-1);
                return;
            }
            if (!tSLocationManager.isLocationServicesEnabled().booleanValue()) {
                SingleLocationRequest.this.onError(1);
                return;
            }
            Intent intent = new Intent(SingleLocationRequest.this.b, (Class<?>) LocationRequestService.class);
            intent.setAction("start");
            intent.putExtra("id", SingleLocationRequest.this.j);
            AbstractService.startForegroundService(SingleLocationRequest.this.b, intent);
        }
    }

    SingleLocationRequest(Builder<?> builder) {
        this.a = 0;
        AtomicInteger atomicInteger = new AtomicInteger(3);
        this.d = atomicInteger;
        this.k = new AtomicInteger(0);
        this.l = new AtomicBoolean(false);
        this.f113n = new AtomicBoolean(false);
        this.f114o = new AtomicBoolean(false);
        this.r = new ArrayList<>();
        this.b = builder.a;
        this.c = builder.b;
        this.e = builder.c;
        atomicInteger.set(builder.d);
        this.f = builder.e;
        this.g = ((Builder) builder).f;
        this.h = ((Builder) builder).g;
        this.a = builder.getAction();
        this.m = System.currentTimeMillis();
        this.j = c();
        Handler handler = new Handler(Looper.getMainLooper());
        this.p = handler;
        int i = this.a;
        if (i == 1 || i == 5) {
            return;
        }
        Runnable runnableA = a();
        this.q = runnableA;
        handler.postDelayed(runnableA, this.c * 1000);
    }

    private static int c() {
        return t.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        this.k.set(TSLocationManager.LOCATION_ERROR_TIMEOUT);
        this.l.set(true);
        finish();
    }

    public static void forceStop(Context context, int i, int i2) {
        FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
        PendingIntent pendingIntent = getPendingIntent(context, i, i2);
        fusedLocationProviderClient.removeLocationUpdates(pendingIntent);
        pendingIntent.cancel();
    }

    public static Intent getIntent(Context context, int i, int i2) {
        Intent intent = new Intent(context, (Class<?>) LocationRequestService.class);
        intent.setAction(i + ":" + i2);
        return intent;
    }

    public static PendingIntent getPendingIntent(Context context, int i, int i2) {
        Intent intent = getIntent(context, i, i2);
        return Build.VERSION.SDK_INT >= 26 ? PendingIntent.getForegroundService(context, 0, intent, Util.getPendingIntentFlags(268435456)) : PendingIntent.getService(context, 0, intent, Util.getPendingIntentFlags(268435456));
    }

    void b(int i) {
        this.d.set(i);
    }

    boolean d() {
        return this.k.get() != 0;
    }

    public boolean didTimeout() {
        return this.l.get();
    }

    boolean e() {
        boolean z;
        synchronized (this.r) {
            z = this.r.size() >= this.d.get();
        }
        return z;
    }

    public void finish() {
        int size;
        TSLocationCallback tSLocationCallback;
        if (this.f113n.get()) {
            return;
        }
        this.f113n.set(true);
        Runnable runnable = this.q;
        if (runnable != null) {
            this.p.removeCallbacks(runnable);
        }
        this.d.set(0);
        LocationServices.getFusedLocationProviderClient(this.b).removeLocationUpdates(getPendingIntent(this.b, this.a, getId())).addOnSuccessListener(new OnSuccessListener() { // from class: com.transistorsoft.locationmanager.location.SingleLocationRequest$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                this.f$0.a((Void) obj);
            }
        });
        if (d()) {
            final TSLocationManager tSLocationManager = TSLocationManager.getInstance(this.b);
            if (this.l.get()) {
                TSLog.logger.warn(TSLog.warn("📍  SingleLocationRequest TIMEOUT: " + this.j));
            } else {
                TSLog.logger.warn(TSLog.warn("📍  SingleLocaitonRequest ERROR: " + this.k.get()));
            }
            synchronized (this.r) {
                size = this.r.size();
            }
            if (size > 0) {
                TSLog.logger.info(TSLog.notice("Found previous sample"));
                this.d.set(size);
                this.l.set(false);
                final SingleLocationResult singleLocationResult = new SingleLocationResult(this.j, getBestLocation());
                BackgroundGeolocation.getThreadPool().execute(new Runnable() { // from class: com.transistorsoft.locationmanager.location.SingleLocationRequest$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        tSLocationManager.onSingleLocationResult(singleLocationResult);
                    }
                });
                return;
            }
            tSLocationManager.onLocationError(this);
            if (!this.f114o.compareAndSet(false, true) || (tSLocationCallback = this.h) == null) {
                return;
            }
            tSLocationCallback.onError(Integer.valueOf(this.k.get()));
        }
    }

    void g() {
        if (this.d.get() <= 0) {
            return;
        }
        TSConfig tSConfig = TSConfig.getInstance(this.b);
        boolean zHasBackgroundPermission = LocationAuthorization.hasBackgroundPermission(this.b);
        boolean zIsBackground = LifecycleManager.getInstance().isBackground();
        boolean zBooleanValue = TSLocationManager.getInstance(this.b).isUpdatingLocation().booleanValue();
        boolean zBooleanValue2 = tSConfig.getUseSignificantChangesOnly().booleanValue();
        if ((zBooleanValue && !zBooleanValue2) || zHasBackgroundPermission || !zIsBackground) {
            LocationAuthorization.withPermission(this.b, new b());
            return;
        }
        TSLog.logger.warn(LocationAuthorization.logBackgroundWarning(this.b));
        onError(3);
        if (tSConfig.requestsLocationAlways()) {
            LocationAuthorization.withBackgroundPermission(this.b, new a());
        }
    }

    public int getAction() {
        return this.a;
    }

    public Location getBestLocation() {
        Location location;
        synchronized (this.r) {
            location = null;
            for (Location location2 : this.r) {
                if (location == null) {
                    location = location2;
                }
                long jLocationAge = TSLocationManager.locationAge(location2);
                long jLocationAge2 = TSLocationManager.locationAge(location);
                location2.distanceTo(location);
                location2.getAccuracy();
                location.getAccuracy();
                if (jLocationAge < jLocationAge2 || location2.getAccuracy() < location.getAccuracy()) {
                    location = location2;
                }
            }
            if (location != null) {
                Bundle extras = location.getExtras();
                if (extras == null) {
                    extras = new Bundle();
                    location.setExtras(extras);
                }
                extras.remove("sample");
                extras.putBoolean("persist", this.e);
            }
        }
        return location;
    }

    public long getElapsed() {
        return System.currentTimeMillis() - this.m;
    }

    public int getErrorCode() {
        return this.k.get();
    }

    public JSONObject getExtras() {
        return this.g;
    }

    public int getId() {
        return this.j;
    }

    public boolean getPersist() {
        return this.e;
    }

    public int getSamples() {
        return this.d.get();
    }

    public long getStartedAt() {
        return this.m;
    }

    public boolean hasExtras() {
        return this.g != null;
    }

    public boolean hasSample() {
        boolean zIsEmpty;
        synchronized (this.r) {
            zIsEmpty = this.r.isEmpty();
        }
        return !zIsEmpty;
    }

    public boolean isFinished() {
        return this.f113n.get();
    }

    public void onError(int i) {
        TSLocationCallback tSLocationCallback;
        this.k.set(i);
        if (hasSample()) {
            finish();
        } else {
            if (!this.f114o.compareAndSet(false, true) || (tSLocationCallback = this.h) == null) {
                return;
            }
            tSLocationCallback.onError(Integer.valueOf(i));
        }
    }

    public void onSuccess(TSLocation tSLocation) {
        TSLocationCallback tSLocationCallback;
        if (!this.f114o.compareAndSet(false, true) || (tSLocationCallback = this.h) == null) {
            return;
        }
        tSLocationCallback.onLocation(tSLocation);
    }

    public void startUpdatingLocation() {
        TSLog.logger.info(TSLog.notice("[SingleLocationRequest start, action: " + this.a) + ", requestId: " + this.j + "]");
        FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this.b);
        long j = this.c;
        LocationRequest smallestDisplacement = LocationRequest.create().setPriority(100).setInterval(0L).setFastestInterval(0L).setSmallestDisplacement(0.0f);
        if (this.a != 1) {
            smallestDisplacement.setExpirationDuration(j * 1000);
        }
        try {
            fusedLocationProviderClient.requestLocationUpdates(smallestDisplacement, getPendingIntent(this.b, this.a, getId()));
        } catch (SecurityException e) {
            TSLog.logger.error(TSLog.error("SecurityException while attempting to fetch location: " + e.getMessage()));
            EventBus.getDefault().post(new SecurityExceptionEvent(e, Integer.valueOf(this.a)));
            Runnable runnable = this.q;
            if (runnable != null) {
                this.p.removeCallbacks(runnable);
            }
        }
    }

    private TSLocationCallback b() {
        return this.h;
    }

    void a(int i) {
        this.j = i;
    }

    private Runnable a() {
        return new Runnable() { // from class: com.transistorsoft.locationmanager.location.SingleLocationRequest$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.f();
            }
        };
    }

    void a(Location location) {
        int size;
        synchronized (this.r) {
            this.r.add(location);
            size = this.r.size();
        }
        long jLocationAge = TSLocationManager.locationAge(location);
        if (this.f > 0 && location.hasAccuracy() && location.getAccuracy() <= this.f && size > 1 && jLocationAge <= 30000) {
            this.d.set(0);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            extras = new Bundle();
            location.setExtras(extras);
        }
        if (e()) {
            return;
        }
        extras.putBoolean("sample", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Void r1) {
        LocationRequestService.stopService(this.b);
    }
}
