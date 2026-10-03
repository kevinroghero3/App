package com.transistorsoft.locationmanager.service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.Nullable;
import androidx.work.PeriodicWorkRequest;
import com.google.android.gms.location.ActivityTransitionEvent;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.intentfilter.androidpermissions.PermissionManager;
import com.intentfilter.androidpermissions.models.DeniedPermissions;
import com.swmansion.gesturehandler.core.NativeViewGestureHandler;
import com.transistorsoft.locationmanager.activity.TSLocationManagerActivity;
import com.transistorsoft.locationmanager.adapter.BackgroundGeolocation;
import com.transistorsoft.locationmanager.adapter.TSConfig;
import com.transistorsoft.locationmanager.adapter.callback.TSLocationCallback;
import com.transistorsoft.locationmanager.config.TSNotification;
import com.transistorsoft.locationmanager.device.DeviceSettings;
import com.transistorsoft.locationmanager.event.ConfigChangeEvent;
import com.transistorsoft.locationmanager.event.MotionActivityCheckEvent;
import com.transistorsoft.locationmanager.event.MotionTriggerDelayEvent;
import com.transistorsoft.locationmanager.event.StopAfterElapsedMinutesEvent;
import com.transistorsoft.locationmanager.event.StopTimeoutEvent;
import com.transistorsoft.locationmanager.geofence.TSGeofenceManager;
import com.transistorsoft.locationmanager.http.HttpService;
import com.transistorsoft.locationmanager.lifecycle.LifecycleManager;
import com.transistorsoft.locationmanager.location.TSLocation;
import com.transistorsoft.locationmanager.location.TSLocationManager;
import com.transistorsoft.locationmanager.location.TSMotionChangeRequest;
import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.locationmanager.logger.TSMediaPlayer;
import com.transistorsoft.locationmanager.scheduler.TSScheduleManager;
import com.transistorsoft.locationmanager.util.LocationAuthorization;
import com.transistorsoft.locationmanager.util.Util;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.io.encoding.Base64;
import net.pluservice.unicoc.R;
import o.ArtificialStackFrames;
import o.asBinder;
import o.onMessageChannelReady;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
public class TrackingService extends AbstractService {
    private static final int A = 1200000;
    private static final Handler B;
    private static long extraCommand;
    private static final AtomicInteger z;
    private Date t;
    private LocationAvailability v;
    private LocationResult w;
    private Runnable x;
    private Runnable y;
    private static final byte[] $$c = {104, 117, 100, 60};
    private static final int $$f = 72;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$g = {70, -123, Ascii.CR, 112, Ascii.CR, -50, 75, 6, Ascii.FF, -61, 70, Ascii.VT, 0, 3, 7, 10, Ascii.DLE, -53, Base64.padSymbol, Ascii.DC4, Ascii.VT, -5, -47, 77, 5, 1, -51, Ascii.GS, 62, -14, 17, 5, 2, -25, 59, -7, 8, 7, Ascii.NAK, -22, 38, -9, 10, Ascii.DLE, 2, Ascii.NAK, 8, 69, Ascii.DC4, 6, -55, SignedBytes.MAX_POWER_OF_TWO, 3, 10, 10, 5, Ascii.NAK, 8, 4, -53, 67, Ascii.FF, -4, Ascii.SO, 6, 19, 1, Ascii.SI, -3, Ascii.SI, 5, Ascii.CR, -1, -47, Base64.padSymbol, Ascii.DC4, Ascii.VT, -5, -47, 42, 42, 5, -3, Ascii.EM, -10, 10, Ascii.NAK, -23, Ascii.SUB, Ascii.DC4, Ascii.FF, -8, 17, -3, 10, -23, 35, 10, Ascii.EM, 3, Ascii.VT, Ascii.SI, -77, 39, 52, 6, Ascii.VT, -7, Ascii.NAK, 3, Ascii.SO, 7};
    private static final int $$h = 240;
    private static final byte[] $$a = {52, -111, -122, 98, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13};
    private static final int $$b = 24;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private boolean q = false;
    private Location r = null;
    private Location s = null;
    private boolean u = false;

    class a implements TSLocationManager.LocationCallback {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // com.transistorsoft.locationmanager.location.TSLocationManager.LocationCallback
        public void onFailure(String str) {
            TSLog.warn(TSLog.warn("Failed fetch last known location to start-monitoring stationary-geofence after app restart"));
        }

        @Override // com.transistorsoft.locationmanager.location.TSLocationManager.LocationCallback
        public void onLocation(Location location) {
            TSGeofenceManager.getInstance(this.a).startMonitoringStationaryRegion(location);
        }
    }

    class b implements PermissionManager.PermissionRequestListener {
        final /* synthetic */ Context a;
        final /* synthetic */ boolean b;
        final /* synthetic */ TSLocationCallback c;

        b(Context context, boolean z, TSLocationCallback tSLocationCallback) {
            this.a = context;
            this.b = z;
            this.c = tSLocationCallback;
        }

        @Override // com.intentfilter.androidpermissions.PermissionManager.PermissionRequestListener
        public void onPermissionDenied(DeniedPermissions deniedPermissions) {
            TSLocationCallback tSLocationCallback = this.c;
            if (tSLocationCallback != null) {
                tSLocationCallback.onError(3);
            }
        }

        @Override // com.intentfilter.androidpermissions.PermissionManager.PermissionRequestListener
        public void onPermissionGranted() {
            if (LocationAuthorization.hasBackgroundPermission(this.a)) {
                TrackingService.changePace(this.a, this.b, this.c);
                return;
            }
            TSLocationCallback tSLocationCallback = this.c;
            if (tSLocationCallback != null) {
                tSLocationCallback.onError(3);
            }
        }
    }

    class c implements TSLocationManager.LocationCallback {
        c() {
        }

        @Override // com.transistorsoft.locationmanager.location.TSLocationManager.LocationCallback
        public void onFailure(String str) {
        }

        @Override // com.transistorsoft.locationmanager.location.TSLocationManager.LocationCallback
        public void onLocation(Location location) {
            TrackingService.this.a(location);
        }
    }

    class e implements TSLocationManager.LocationCallback {
        e() {
        }

        @Override // com.transistorsoft.locationmanager.location.TSLocationManager.LocationCallback
        public void onFailure(String str) {
            TSLog.logger.warn(TSLog.warn("MotionActivityCheck failed to retrieve lastLocation"));
        }

        @Override // com.transistorsoft.locationmanager.location.TSLocationManager.LocationCallback
        public void onLocation(Location location) {
            if (location == null || TrackingService.this.s == null) {
                TSLog.logger.warn(TSLog.warn("MotionActivityCheck failed with null location.  Retrying.\n- lastLocation: " + location + "\nmotionActivityCheckLocation: " + TrackingService.this.s));
                TSLocationManager.getInstance(TrackingService.this.getApplicationContext()).updateLocationRequest();
                return;
            }
            float fDistanceTo = (location.distanceTo(TrackingService.this.s) - TrackingService.this.s.getAccuracy()) - location.getAccuracy();
            long jElapsedTimeMillis = TSLocationManager.elapsedTimeMillis(location, TrackingService.this.s);
            TrackingService.this.s = null;
            TSLog.logger.info(TSLog.info("Distance from motion-activity check location: " + fDistanceTo));
            TSConfig tSConfig = TSConfig.getInstance(TrackingService.this.getApplicationContext());
            int iIntValue = tSConfig.getStationaryRadius().intValue();
            if (iIntValue < 25) {
                iIntValue = 25;
            }
            if (tSConfig.getDistanceFilter().floatValue() > 0.0f || fDistanceTo <= iIntValue) {
                if (TrackingService.this.a(location)) {
                    return;
                }
                TrackingService trackingService = TrackingService.this;
                trackingService.a(jElapsedTimeMillis, trackingService.s);
                return;
            }
            if (TrackingService.this.v != null && TrackingService.this.v.isLocationAvailable()) {
                TSLocationManager.getInstance(TrackingService.this.getApplicationContext()).updateLocationRequest();
                return;
            }
            TSLog.logger.warn(TSLog.warn("MotionActivityCheck fired with no location availability:  Retrying"));
            TrackingService trackingService2 = TrackingService.this;
            trackingService2.a(jElapsedTimeMillis, trackingService2.s);
        }
    }

    static class f implements TSLocationCallback {
        private final boolean a;
        private final Context b;
        private final TSLocationCallback c;

        f(Context context, boolean z, TSLocationCallback tSLocationCallback) {
            this.b = context;
            this.a = z;
            this.c = tSLocationCallback;
            if (z) {
                com.transistorsoft.locationmanager.crash.a.a(context).f();
            } else {
                com.transistorsoft.locationmanager.crash.a.a(context).h();
            }
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSLocationCallback
        public void onError(Integer num) {
            TrackingService.z.set(0);
            TSLocationCallback tSLocationCallback = this.c;
            if (tSLocationCallback != null) {
                tSLocationCallback.onError(num);
            }
            if (TSConfig.getInstance(this.b).getEnabled().booleanValue()) {
                if (this.a) {
                    TSLocationManager.getInstance(this.b).requestLocationUpdates();
                    return;
                }
                if (LocationAuthorization.hasActivityPermission(this.b) || -1 == num.intValue() || 1 == num.intValue() || 499 == num.intValue() || 3 == num.intValue()) {
                    return;
                }
                TSLog.logger.warn(TSLog.warn("TSMotionChangeCallback received error: " + num + ".  Re-executing .changePace(" + this.a + ")"));
                TrackingService.changePace(this.b, this.a, null);
            }
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSLocationCallback
        public void onLocation(TSLocation tSLocation) {
            TrackingService.z.set(0);
            TSGeofenceManager tSGeofenceManager = TSGeofenceManager.getInstance(this.b);
            TSLocationCallback tSLocationCallback = this.c;
            if (tSLocationCallback != null) {
                tSLocationCallback.onLocation(tSLocation);
            }
            if (this.a) {
                ActivityRecognitionService.start(this.b);
                return;
            }
            tSGeofenceManager.startMonitoringStationaryRegion(tSLocation.getLocation());
            if (TSConfig.getInstance(this.b).getUseSignificantChangesOnly().booleanValue()) {
                return;
            }
            TrackingService.b(this.b, BackgroundGeolocation.EVENT_MOTIONCHANGE);
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$i(short r6, short r7, int r8) {
        /*
            int r8 = r8 * 2
            int r8 = 3 - r8
            byte[] r0 = com.transistorsoft.locationmanager.service.TrackingService.$$c
            int r7 = r7 * 2
            int r7 = r7 + 118
            int r6 = r6 * 2
            int r1 = r6 + 1
            byte[] r1 = new byte[r1]
            r2 = 0
            if (r0 != 0) goto L17
            r7 = r6
            r3 = r8
            r4 = r2
            goto L2c
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L25:
            int r8 = r8 + 1
            r3 = r0[r8]
            r5 = r3
            r3 = r8
            r8 = r5
        L2c:
            int r7 = r7 + r8
            r8 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.service.TrackingService.$$i(short, short, int):java.lang.String");
    }

    static {
        accessartificialFrame();
        z = new AtomicInteger(0);
        B = new Handler(Looper.getMainLooper());
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0029  */
    /* JADX WARN: Code duplicated, block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x002f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0029
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void F(short r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 * 8
            int r9 = r9 + 4
            int r8 = r8 * 3
            int r8 = 12 - r8
            int r7 = r7 * 28
            int r7 = 112 - r7
            byte[] r0 = com.transistorsoft.locationmanager.service.TrackingService.$$a
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r9
            r5 = r2
            goto L2f
        L16:
            r3 = r2
        L17:
            r6 = r9
            r9 = r7
            r7 = r6
            byte r4 = (byte) r9
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r8) goto L29
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L29:
            r3 = r0[r7]
            r6 = r9
            r9 = r7
            r7 = r3
            r3 = r6
        L2f:
            int r9 = r9 + 1
            int r7 = -r7
            int r7 = r7 + r3
            r3 = r5
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.service.TrackingService.F(short, byte, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0029  */
    /* JADX WARN: Code duplicated, block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x002e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0029
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void H(int r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 63
            int r8 = r8 + 36
            int r7 = r7 * 2
            int r7 = 48 - r7
            int r6 = r6 * 2
            int r0 = 65 - r6
            byte[] r1 = com.transistorsoft.locationmanager.service.TrackingService.$$g
            byte[] r0 = new byte[r0]
            int r6 = 64 - r6
            r2 = 0
            if (r1 != 0) goto L19
            r3 = r6
            r8 = r7
            r4 = r2
            goto L2e
        L19:
            r3 = r2
        L1a:
            byte r4 = (byte) r8
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L29:
            r3 = r1[r7]
            r5 = r8
            r8 = r7
            r7 = r5
        L2e:
            int r7 = r7 + r3
            int r8 = r8 + 1
            int r7 = r7 + (-8)
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.service.TrackingService.H(int, int, byte, java.lang.Object[]):void");
    }

    private void c(Intent intent) {
        TSConfig tSConfig = TSConfig.getInstance(getApplicationContext());
        if (LocationAvailability.hasLocationAvailability(intent)) {
            LocationAvailability locationAvailabilityExtractLocationAvailability = LocationAvailability.extractLocationAvailability(intent);
            TSLog.logger.info(TSLog.info("Location availability: " + locationAvailabilityExtractLocationAvailability.isLocationAvailable()));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(TSLog.header("TrackingService: LocationResult"));
        final LocationResult locationResultExtractResult = LocationResult.extractResult(intent);
        TSGeofenceManager.getInstance(this).setLocation(locationResultExtractResult.getLastLocation(), tSConfig.getIsMoving().booleanValue());
        if (locationResultExtractResult.getLastLocation() == null) {
            TSLog.logger.warn(TSLog.error("Unexpected null from LocationResult.getLastLocation() while trying to determine distance from stoppedAtLocation"));
            return;
        }
        for (Location location : locationResultExtractResult.getLocations()) {
            if (location.getExtras() == null) {
                location.setExtras(new Bundle());
            }
            long jLocationAge = TSLocationManager.locationAge(location);
            sb.append(TSLog.boxRow(TSLog.ICON_PIN + location));
            sb.append(TSLog.boxRow("Age: " + jLocationAge + "ms, time: " + location.getTime()));
        }
        TSLog.logger.debug(sb.toString());
        final TSLocationManager tSLocationManager = TSLocationManager.getInstance(getApplicationContext());
        BackgroundGeolocation.getThreadPool().execute(new Runnable() { // from class: com.transistorsoft.locationmanager.service.TrackingService$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                tSLocationManager.onLocationResult(locationResultExtractResult);
            }
        });
        if (!tSConfig.getDisableStopDetection().booleanValue()) {
            b(locationResultExtractResult.getLastLocation());
        }
        this.w = locationResultExtractResult;
    }

    public static void changePace(Context context, boolean z2, @Nullable TSLocationCallback tSLocationCallback) {
        TSConfig tSConfig = TSConfig.getInstance(context);
        if (!tSConfig.getEnabled().booleanValue()) {
            TSLog.warn(TSLog.warn("Refused attempt to execute changePace while disabled <IGNORED>"));
            if (tSLocationCallback != null) {
                tSLocationCallback.onError(-1);
                return;
            }
            return;
        }
        boolean zHasBackgroundPermission = LocationAuthorization.hasBackgroundPermission(context);
        if (LifecycleManager.getInstance().isBackground() && !tSConfig.getIsMoving().booleanValue() && z2 && !zHasBackgroundPermission) {
            TSLog.logger.warn(TSLog.warn("Cannot changePace(true) while in the background with WhenInUse authorization"));
            if (tSConfig.requestsLocationAlways()) {
                LocationAuthorization.withBackgroundPermission(context, new b(context, z2, tSLocationCallback));
                return;
            } else {
                if (tSLocationCallback != null) {
                    tSLocationCallback.onError(3);
                    return;
                }
                return;
            }
        }
        if (tSConfig.getMotionTriggerDelay().longValue() >= 0) {
            TSScheduleManager.getInstance(context).cancelOneShot(MotionTriggerDelayEvent.ACTION);
        }
        TSLocationManager tSLocationManager = TSLocationManager.getInstance(context);
        boolean zBooleanValue = tSConfig.getIsMoving().booleanValue();
        if (tSLocationCallback == null && isAcquiringMotionChange()) {
            AtomicInteger atomicInteger = z;
            if (tSLocationManager.getRequest(atomicInteger.get()) != null && z2 == zBooleanValue) {
                TSLog.logger.debug(TSLog.warn("Waiting for existing motionchange request #" + atomicInteger.get() + " to complete"));
                return;
            }
        }
        tSConfig.setIsMoving(Boolean.valueOf(z2));
        TSGeofenceManager tSGeofenceManager = TSGeofenceManager.getInstance(context);
        if (z2) {
            HeartbeatService.stop(context);
            tSGeofenceManager.startMonitoringSignificantLocationChanges();
            tSGeofenceManager.stopMonitoringStationaryRegion();
            if (!tSConfig.getUseSignificantChangesOnly().booleanValue()) {
                b(context, BackgroundGeolocation.EVENT_MOTIONCHANGE);
            }
        } else {
            TSScheduleManager.getInstance(context).cancelOneShot(MotionActivityCheckEvent.ACTION);
            tSGeofenceManager.stopMonitoringSignificantLocationChanges();
            HeartbeatService.start(context);
        }
        if (isAcquiringMotionChange()) {
            AtomicInteger atomicInteger2 = z;
            tSLocationManager.cancelRequest(atomicInteger2.get());
            atomicInteger2.set(0);
        }
        TSMotionChangeRequest tSMotionChangeRequestBuild = new TSMotionChangeRequest.Builder(context).setCallback(new f(context, z2, tSLocationCallback)).build();
        z.set(tSMotionChangeRequestBuild.getId());
        tSLocationManager.getCurrentPosition(tSMotionChangeRequestBuild);
        if (zBooleanValue && !z2) {
            tSLocationManager.stopUpdatingLocation();
            TSScheduleManager.getInstance(context).cancelOneShot(StopTimeoutEvent.ACTION);
        }
        TSLog.logger.info(TSLog.notice("setPace: " + zBooleanValue + " → " + z2));
    }

    public static void changeTrackingMode(Context context, int i, TSLocationCallback tSLocationCallback) {
        TSLocationManager tSLocationManager = TSLocationManager.getInstance(context);
        TSConfig tSConfig = TSConfig.getInstance(context);
        tSLocationManager.stopUpdatingLocation();
        ActivityRecognitionService.stop(context);
        if (isAcquiringMotionChange()) {
            AtomicInteger atomicInteger = z;
            tSLocationManager.cancelRequest(atomicInteger.get());
            atomicInteger.set(0);
        }
        tSConfig.setEnabled(Boolean.FALSE, true);
        start(context, tSLocationCallback);
    }

    public static Intent getIntent(Context context) {
        return new Intent(context, (Class<?>) TrackingService.class);
    }

    public static PendingIntent getPendingIntent(Context context) {
        return getPendingIntent(context, null);
    }

    private void i() {
        TSScheduleManager.getInstance(getApplicationContext()).cancelOneShot(MotionActivityCheckEvent.ACTION);
        this.s = null;
    }

    public static boolean isAcquiringMotionChange() {
        return z.get() != 0;
    }

    private void j() {
        Context applicationContext = getApplicationContext();
        TSScheduleManager.getInstance(applicationContext).cancelOneShot(StopTimeoutEvent.ACTION);
        this.q = false;
        this.r = null;
        if (TSConfig.getInstance(applicationContext).getIsMoving().booleanValue()) {
            TSMediaPlayer.getInstance().debug(applicationContext, "tslocationmanager_bell_ding_pop");
        }
    }

    private void k() {
        TSConfig tSConfig = TSConfig.getInstance(getApplicationContext());
        TSLog.logger.info(TSLog.header("TrackingService motionchange: " + tSConfig.getIsMoving()));
        if (this.q && !tSConfig.getIsMoving().booleanValue()) {
            j();
        }
        if (!tSConfig.getIsMoving().booleanValue()) {
            if (this.u) {
                TSLog.logger.info(TSLog.info("Stopping on stationary"));
                stop(getApplicationContext());
                return;
            }
            a(false);
            this.t = null;
            j();
            i();
            TSLocationManager.getInstance(getApplicationContext()).stopUpdatingLocation();
            return;
        }
        if (tSConfig.getStopAfterElapsedMinutes().intValue() > 0 && this.t == null) {
            long jIntValue = ((long) tSConfig.getStopAfterElapsedMinutes().intValue()) * 60000;
            this.t = new Date(System.currentTimeMillis() + jIntValue);
            TSScheduleManager.getInstance(getApplicationContext()).oneShot(StopAfterElapsedMinutesEvent.ACTION, jIntValue, true, true);
        }
        if (tSConfig.getStopOnStationary().booleanValue()) {
            this.u = true;
            EventBus eventBus = EventBus.getDefault();
            if (eventBus.isRegistered(this)) {
                return;
            }
            eventBus.register(this);
        }
    }

    public static void restart(Context context) {
        TSConfig tSConfig = TSConfig.getInstance(context);
        if (Build.VERSION.SDK_INT <= 31) {
            ActivityRecognitionService.start(context);
        }
        if (tSConfig.getIsMoving().booleanValue()) {
            TSLocationManager.getInstance(context).requestLocationUpdates();
        } else {
            TSLocationManager.getInstance(context).getLastLocation(new a(context));
        }
    }

    public static void start(Context context) {
        start(context, null);
    }

    public static void stop(Context context) {
        TSConfig tSConfig = TSConfig.getInstance(context);
        TSScheduleManager tSScheduleManager = TSScheduleManager.getInstance(context);
        if (tSConfig.getIsMoving().booleanValue()) {
            tSScheduleManager.cancelOneShot(StopTimeoutEvent.ACTION);
        } else {
            tSScheduleManager.cancelOneShot(MotionTriggerDelayEvent.ACTION);
        }
        Boolean bool = Boolean.FALSE;
        tSConfig.setEnabled(bool);
        tSConfig.setIsMoving(bool);
        TSLocationManager tSLocationManager = TSLocationManager.getInstance(context);
        TSGeofenceManager tSGeofenceManager = TSGeofenceManager.getInstance(context);
        if (isAcquiringMotionChange()) {
            AtomicInteger atomicInteger = z;
            tSLocationManager.cancelRequest(atomicInteger.get());
            atomicInteger.set(0);
        }
        if (tSConfig.getStopAfterElapsedMinutes().intValue() > 0) {
            TSScheduleManager.getInstance(context).cancelOneShot(StopAfterElapsedMinutesEvent.ACTION);
        }
        stopService(context);
        tSLocationManager.stop();
        tSGeofenceManager.stop();
        tSGeofenceManager.stopMonitoringStationaryRegion();
        ActivityRecognitionService.stop(context);
        HeartbeatService.stop(context);
        HttpService.getInstance(context).stopMonitoringConnectivityChanges(context);
        DeviceSettings.getInstance().stopMonitoringPowerSaveChanges(context);
        com.transistorsoft.locationmanager.crash.a.a(context).h();
    }

    public static void stopService(Context context) {
        AbstractService.stop(context, TrackingService.class);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onActivityTransitionEvent(ActivityTransitionEvent activityTransitionEvent) {
        if (TSConfig.getInstance(getApplicationContext()).isLocationTrackingMode() && activityTransitionEvent.getTransitionType() == 0 && activityTransitionEvent.getActivityType() != 3 && this.q) {
            j();
        }
    }

    @Override // com.transistorsoft.locationmanager.service.AbstractService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onConfigChange(ConfigChangeEvent configChangeEvent) {
        TSConfig tSConfig = TSConfig.getInstance(this);
        if (configChangeEvent.isDirty("foregroundService") && Build.VERSION.SDK_INT < 26) {
            if (tSConfig.getForegroundService().booleanValue()) {
                startForeground(ForegroundNotification.NOTIFICATION_ID, ForegroundNotification.build(this));
            } else {
                stopForeground(true);
            }
        }
        if (tSConfig.getForegroundService().booleanValue() && configChangeEvent.isDirty(TSNotification.NAME)) {
            ((NotificationManager) getSystemService(TSNotification.NAME)).notify(ForegroundNotification.NOTIFICATION_ID, ForegroundNotification.build(getApplicationContext()));
        }
        if (configChangeEvent.isDirty("heartbeatInterval") && !tSConfig.getIsMoving().booleanValue()) {
            if (tSConfig.getHeartbeatInterval().intValue() > 0) {
                HeartbeatService.start(getApplicationContext());
            } else {
                HeartbeatService.stop(getApplicationContext());
            }
        }
        if (configChangeEvent.isDirty("stopTimeout") && this.q) {
            j();
            TSLocationManager.getInstance(getApplicationContext()).getLastGoodLocation(new d());
        }
        if (configChangeEvent.isDirty("stopAfterElapsedMinutes")) {
            int iIntValue = tSConfig.getStopAfterElapsedMinutes().intValue();
            TSScheduleManager tSScheduleManager = TSScheduleManager.getInstance(getApplicationContext());
            tSScheduleManager.cancelOneShot(StopAfterElapsedMinutesEvent.ACTION);
            this.t = null;
            if (iIntValue > 0) {
                long j = ((long) iIntValue) * 60000;
                this.t = new Date(System.currentTimeMillis() + j);
                tSScheduleManager.oneShot(StopAfterElapsedMinutesEvent.ACTION, j, true, true);
            }
        }
        if (configChangeEvent.isDirty("useSignificantChangesOnly") && tSConfig.getUseSignificantChangesOnly().booleanValue() && tSConfig.getIsMoving().booleanValue()) {
            a(false);
        }
        if (configChangeEvent.isDirty("disableStopDetection")) {
            if (tSConfig.getDisableStopDetection().booleanValue()) {
                i();
                j();
            } else {
                if (this.w == null) {
                    TSLocationManager.getInstance(getApplicationContext()).updateLocationRequest();
                    return;
                }
                Location location = new Location("TSLocationManager");
                location.set(this.w.getLastLocation());
                location.setTime(System.currentTimeMillis());
                b(location);
            }
        }
    }

    @Override // com.transistorsoft.locationmanager.service.AbstractService, android.app.Service
    public void onCreate() {
        if (Build.VERSION.SDK_INT >= 29) {
            super.a(getClass().getSimpleName(), 8);
        } else {
            super.a(getClass().getSimpleName(), 0);
        }
    }

    @Override // com.transistorsoft.locationmanager.service.AbstractService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        TSConfig tSConfig = TSConfig.getInstance(getApplicationContext());
        if (this.q && !tSConfig.getUseSignificantChangesOnly().booleanValue()) {
            j();
        }
        TSScheduleManager.getInstance(getApplicationContext()).cancelOneShot(MotionActivityCheckEvent.ACTION);
        EventBus eventBus = EventBus.getDefault();
        if (eventBus.isRegistered(this)) {
            eventBus.unregister(this);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMotionActivityCheckEvent(MotionActivityCheckEvent motionActivityCheckEvent) {
        if (this.q) {
            return;
        }
        TSConfig tSConfig = TSConfig.getInstance(getApplicationContext());
        if (LocationAuthorization.hasActivityPermission(getApplicationContext()) && !tSConfig.getDisableMotionActivityUpdates().booleanValue()) {
            ActivityRecognitionService.start(getApplicationContext());
        } else if (this.w != null) {
            TSLocationManager.getInstance(getApplicationContext()).getLastLocation(new e());
        } else {
            TSLog.logger.warn(TSLog.warn("onMotionActivityCheckEvent fired but found a null mLastLocationResult"));
            TSLocationManager.getInstance(getApplicationContext()).updateLocationRequest();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (!a(intent, i2, true)) {
            return 3;
        }
        EventBus eventBus = EventBus.getDefault();
        if (!eventBus.isRegistered(this)) {
            eventBus.register(this);
        }
        String action = intent.getAction();
        TSConfig tSConfig = TSConfig.getInstance(getApplicationContext());
        if (action != null) {
            if (action.contains(BackgroundGeolocation.EVENT_MOTIONCHANGE)) {
                if ((tSConfig.getIsMoving().booleanValue() && !tSConfig.getUseSignificantChangesOnly().booleanValue()) || tSConfig.getNotification().getSticky().booleanValue()) {
                    a(true);
                }
                if (tSConfig.getIsMoving().booleanValue()) {
                    ForegroundNotification.a(new Date().getTime());
                } else {
                    ForegroundNotification.a(0L);
                }
                k();
            } else if (action.equalsIgnoreCase(StopTimeoutEvent.ACTION)) {
                if (!tSConfig.isLocationTrackingMode() || !tSConfig.getIsMoving().booleanValue()) {
                    a(false);
                } else if (!isAcquiringMotionChange()) {
                    TSLocationManager.getInstance(getApplicationContext()).getLastGoodLocation(new c());
                }
            } else if (action.equalsIgnoreCase("start")) {
                TSLog.logger.debug("action: start");
                a(true);
            }
        } else if (LocationResult.hasResult(intent)) {
            if (tSConfig.getIsMoving().booleanValue() && !tSConfig.getUseSignificantChangesOnly().booleanValue()) {
                a(true);
            }
            c(intent);
        } else if (LocationAvailability.hasLocationAvailability(intent)) {
            b(intent);
        } else {
            TSLog.logger.warn(TSLog.warn("UNKNOWN INTENT RECEIVED: " + intent.toString() + ", " + intent.getExtras()));
        }
        if (tSConfig.getEnabled().booleanValue() && tSConfig.getNotification().getSticky().booleanValue()) {
            a(true);
        }
        a(i2);
        return 3;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onStopAfterElapsedMinutesEvent(StopAfterElapsedMinutesEvent stopAfterElapsedMinutesEvent) {
        this.t = null;
    }

    public static PendingIntent getPendingIntent(Context context, @Nullable String str) {
        Context applicationContext = context.getApplicationContext();
        return Build.VERSION.SDK_INT >= 26 ? PendingIntent.getForegroundService(applicationContext, 0, getIntent(applicationContext), Util.getPendingIntentFlags(134217728)) : PendingIntent.getService(applicationContext, 0, getIntent(applicationContext), 134217728);
    }

    public static void start(Context context, TSLocationCallback tSLocationCallback) {
        TSConfig tSConfig = TSConfig.getInstance(context);
        boolean zBooleanValue = tSConfig.getEnabled().booleanValue();
        tSConfig.setEnabled(Boolean.TRUE);
        TSLocationManagerActivity.startIfEnabled(context, TSLocationManagerActivity.ACTION_LOCATION_SETTINGS);
        TSGeofenceManager.getInstance(context).start();
        HttpService.getInstance(context).startMonitoringConnectivityChanges(context);
        DeviceSettings.getInstance().startMonitoringPowerSaveChanges(context);
        if (!tSConfig.isLocationTrackingMode()) {
            GeofencingService.changePace(context, tSConfig.getIsMoving().booleanValue(), tSLocationCallback);
            return;
        }
        ActivityRecognitionService.start(context);
        if (!zBooleanValue) {
            changePace(context, tSConfig.getIsMoving().booleanValue(), tSLocationCallback);
            return;
        }
        TSMotionChangeRequest tSMotionChangeRequestBuild = new TSMotionChangeRequest.Builder(context).setCallback(new f(context, tSConfig.getIsMoving().booleanValue(), tSLocationCallback)).setSamples(3).setPersist(false).build();
        z.set(tSMotionChangeRequestBuild.getId());
        TSLocationManager.getInstance(context).getCurrentPosition(tSMotionChangeRequestBuild);
        if (tSConfig.getIsMoving().booleanValue()) {
            return;
        }
        HeartbeatService.start(context);
    }

    static void b(Context context) {
        if (TSConfig.getInstance(context).getDisableStopDetection().booleanValue()) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) TrackingService.class);
        intent.setAction(StopTimeoutEvent.ACTION);
        AbstractService.startForegroundService(context, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, Location location) {
        if (location == null) {
            TSLog.logger.warn(TSLog.warn("beginMotionActivityCheckTimer was provided null location"));
            return;
        }
        TSConfig tSConfig = TSConfig.getInstance(getApplicationContext());
        if (tSConfig.getDisableStopDetection().booleanValue()) {
            return;
        }
        if (this.s == null || tSConfig.getDistanceFilter().floatValue() > 0.0f) {
            this.s = location;
            long j2 = j + 60000;
            long j3 = j2 > PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS ? 300000L : j2;
            TSScheduleManager tSScheduleManager = TSScheduleManager.getInstance(getApplicationContext());
            tSScheduleManager.cancelOneShot(MotionActivityCheckEvent.ACTION);
            tSScheduleManager.oneShot(MotionActivityCheckEvent.ACTION, j3, true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str) {
        AbstractService.launchService(context, TrackingService.class, str);
    }

    private void b(Location location) {
        if (this.q && this.r == null) {
            TSLog.logger.debug("Received stoppedAt location");
            this.r = location;
        }
        LocationResult locationResult = this.w;
        if (locationResult == null) {
            return;
        }
        long jElapsedTimeMillis = TSLocationManager.elapsedTimeMillis(location, locationResult.getLastLocation());
        if (LocationAuthorization.hasActivityPermission(getApplicationContext())) {
            if (ActivityRecognitionService.getLastActivity().getActivityType() != 3) {
                if (this.q) {
                    return;
                }
                a(jElapsedTimeMillis, location);
                return;
            } else if (!this.q && a(location)) {
                return;
            }
        } else if (!this.q) {
            a(jElapsedTimeMillis, location);
            return;
        }
        if (this.r == null) {
            TSLog.logger.warn(TSLog.warn("performStopDetection found mStoppedAtLocation == null"));
            return;
        }
        TSConfig tSConfig = TSConfig.getInstance(getApplicationContext());
        float fDistanceTo = (location.distanceTo(this.r) - this.r.getAccuracy()) - location.getAccuracy();
        float fIntValue = tSConfig.getStationaryRadius().intValue();
        if (fIntValue <= 25.0f) {
            fIntValue = 25.0f;
        }
        TSLog.logger.info(TSLog.info("Distance from stoppedAtLocation: " + fDistanceTo));
        if (fDistanceTo > fIntValue) {
            TSLog.logger.debug(TSLog.info("Force cancel cancel stopTimeout due to apparent movement beyond stoppedAt location"));
            if (this.q) {
                j();
            }
            a(jElapsedTimeMillis, location);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Location location) {
        if (this.q) {
            return true;
        }
        TSConfig tSConfig = TSConfig.getInstance(getApplicationContext());
        if (tSConfig.getDisableStopDetection().booleanValue()) {
            return false;
        }
        int i = Build.VERSION.SDK_INT;
        if (location != null && location.isFromMockProvider()) {
            TSLog.logger.debug("🐞 Mock location detected with motion-activity STILL:  stopTimeout timer would normally be initiated here 🐞.");
            return false;
        }
        this.q = true;
        long jLongValue = tSConfig.getStopTimeout().longValue() * 60000;
        if (i >= 26 && tSConfig.getIsMoving().booleanValue() && tSConfig.getUseSignificantChangesOnly().booleanValue()) {
            jLongValue = 1200000;
        }
        long j = jLongValue;
        if (j <= 0) {
            TSLog.logger.debug(TSLog.notice("Stop-timeout elapsed!"));
            changePace(getApplicationContext(), false, null);
            return true;
        }
        TSMediaPlayer.getInstance().debug(getApplicationContext(), "tslocationmanager_chime_bell_confirm");
        TSScheduleManager tSScheduleManager = TSScheduleManager.getInstance(getApplicationContext());
        tSScheduleManager.oneShot(StopTimeoutEvent.ACTION, j, true, true);
        tSScheduleManager.cancelOneShot(MotionActivityCheckEvent.ACTION);
        LocationAvailability locationAvailability = this.v;
        if (locationAvailability != null && locationAvailability.isLocationAvailable()) {
            TSLocationManager.getInstance(getApplicationContext()).requestLocationUpdates();
        } else {
            this.r = location;
        }
        return true;
    }

    private static void G(int i, char[] cArr, Object[] objArr) throws Throwable {
        char c2 = 2;
        int i2 = 2 % 2;
        asBinder asbinder = new asBinder();
        asbinder.c = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        asbinder.d = 0;
        while (asbinder.d < cArr.length) {
            int i3 = asbinder.d;
            char c3 = cArr[asbinder.d];
            try {
                Object[] objArr2 = new Object[3];
                objArr2[c2] = asbinder;
                objArr2[1] = asbinder;
                objArr2[0] = Integer.valueOf(c3);
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1562553046);
                if (objAccessartificialFrame == null) {
                    byte b2 = (byte) 0;
                    byte b3 = b2;
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", "", 0, 0) + 11, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16), TextUtils.getOffsetBefore("", 0) + 1407, 1035473698, false, $$i(b2, b3, b3), new Class[]{Integer.TYPE, Object.class, Object.class});
                }
                jArr[i3] = ((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue() ^ (extraCommand ^ (-2360974883025274865L));
                Object[] objArr3 = {asbinder, asbinder};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame2 == null) {
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(7 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (KeyEvent.getMaxKeyCode() >> 16), 249 - (ViewConfiguration.getScrollBarSize() >> 8), 378009232, false, "w", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                int i4 = $11 + 33;
                $10 = i4 % 128;
                int i5 = i4 % 2;
                c2 = 2;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        char[] cArr2 = new char[length];
        asbinder.d = 0;
        while (asbinder.d < cArr.length) {
            int i6 = $10 + 3;
            $11 = i6 % 128;
            int i7 = i6 % 2;
            cArr2[asbinder.d] = (char) jArr[asbinder.d];
            try {
                Object[] objArr4 = {asbinder, asbinder};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame3 == null) {
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(Color.argb(0, 0, 0, 0) + 8, (char) Color.red(0), 249 - (ViewConfiguration.getKeyRepeatDelay() >> 16), 378009232, false, "w", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        objArr[0] = new String(cArr2);
    }

    private void b(Intent intent) {
        LocationAvailability locationAvailabilityExtractLocationAvailability = LocationAvailability.extractLocationAvailability(intent);
        if (this.v == null || locationAvailabilityExtractLocationAvailability.isLocationAvailable() != this.v.isLocationAvailable()) {
            TSLog.logger.info(TSLog.info("Location availability: " + locationAvailabilityExtractLocationAvailability.isLocationAvailable()));
        }
        this.v = locationAvailabilityExtractLocationAvailability;
    }

    public static void changePace(Context context, boolean z2) {
        changePace(context, z2, null);
    }

    public class d implements TSLocationManager.LocationCallback {
        private static final byte[] $$c = {66, -107, -4, -33};
        private static final int $$d = 171;
        private static int $10 = 0;
        private static int $11 = 1;
        private static final byte[] $$a = {96, -63, 33, 4, -11, -2, Ascii.FF};
        private static final int $$b = 35;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static char[] validateRelationship = {56067, 56185, 56104, 56079, 56074, 56191, 56077, 56186, 56105, 56069, 56070, 56073, 56184, 56072, 56189, 56075, 56110, 56262, 56261, 56179, 56065, 56064, 56085, 56068, 56078, 56123};
        private static int warmup = -1044259852;
        private static boolean requestPostMessageChannelWithExtras = true;
        private static boolean ICustomTabsServiceDefault = true;

        /* JADX WARN: Code duplicated, block: B:10:0x0023  */
        /* JADX WARN: Code duplicated, block: B:8:0x001d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002a). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$e(byte r6, short r7, int r8) {
            /*
                int r7 = r7 + 66
                int r6 = r6 * 4
                int r6 = 3 - r6
                byte[] r0 = com.transistorsoft.locationmanager.service.TrackingService.d.$$c
                int r8 = r8 * 3
                int r1 = r8 + 1
                byte[] r1 = new byte[r1]
                r2 = 0
                if (r0 != 0) goto L15
                r4 = r7
                r3 = r2
                r7 = r6
                goto L2a
            L15:
                r3 = r2
            L16:
                byte r4 = (byte) r7
                r1[r3] = r4
                int r6 = r6 + 1
                if (r3 != r8) goto L23
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                return r6
            L23:
                int r3 = r3 + 1
                r4 = r0[r6]
                r5 = r7
                r7 = r6
                r6 = r5
            L2a:
                int r6 = r6 + r4
                r5 = r7
                r7 = r6
                r6 = r5
                goto L16
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.service.TrackingService.d.$$e(byte, short, int):java.lang.String");
        }

        d() {
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0027  */
        /* JADX WARN: Code duplicated, block: B:8:0x001f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0030). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static void c(int r6, int r7, byte r8, java.lang.Object[] r9) {
            /*
                int r8 = r8 * 2
                int r8 = 4 - r8
                int r7 = r7 * 4
                int r0 = 4 - r7
                byte[] r1 = com.transistorsoft.locationmanager.service.TrackingService.d.$$a
                int r6 = r6 * 4
                int r6 = 109 - r6
                byte[] r0 = new byte[r0]
                int r7 = 3 - r7
                r2 = 0
                if (r1 != 0) goto L19
                r3 = r8
                r4 = r2
                r8 = r7
                goto L30
            L19:
                r3 = r2
            L1a:
                byte r4 = (byte) r6
                r0[r3] = r4
                if (r3 != r7) goto L27
                java.lang.String r6 = new java.lang.String
                r6.<init>(r0, r2)
                r9[r2] = r6
                return
            L27:
                int r3 = r3 + 1
                r4 = r1[r8]
                r5 = r8
                r8 = r6
                r6 = r4
                r4 = r3
                r3 = r5
            L30:
                int r6 = -r6
                int r8 = r8 + r6
                int r6 = r8 + (-3)
                int r8 = r3 + 1
                r3 = r4
                goto L1a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.service.TrackingService.d.c(int, int, byte, java.lang.Object[]):void");
        }

        @Override // com.transistorsoft.locationmanager.location.TSLocationManager.LocationCallback
        public void onFailure(String str) {
        }

        @Override // com.transistorsoft.locationmanager.location.TSLocationManager.LocationCallback
        public void onLocation(Location location) {
            TrackingService.this.a(location);
        }

        private static void b(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) throws Throwable {
            int i2 = 2 % 2;
            onMessageChannelReady onmessagechannelready = new onMessageChannelReady();
            char[] cArr2 = validateRelationship;
            int i3 = 0;
            if (cArr2 != null) {
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                int i4 = $10 + 83;
                $11 = i4 % 128;
                int i5 = i4 % 2;
                int i6 = 0;
                while (i6 < length) {
                    try {
                        Object[] objArr2 = new Object[1];
                        objArr2[i3] = Integer.valueOf(cArr2[i6]);
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(115862995);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) i3;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(26 - KeyEvent.getDeadChar(i3, i3), (char) View.resolveSize(i3, i3), 1041 - TextUtils.getOffsetAfter("", i3), -1719489573, false, $$e(b, (byte) (b | 55), b), new Class[]{Integer.TYPE});
                        }
                        cArr3[i6] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                        i6++;
                        i3 = 0;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                cArr2 = cArr3;
            }
            Object[] objArr3 = {Integer.valueOf(warmup)};
            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1820173622);
            if (objAccessartificialFrame2 == null) {
                byte b2 = (byte) 0;
                byte b3 = (byte) (b2 + 1);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 15, (char) (AndroidCharacter.getMirror('0') + 20440), TextUtils.lastIndexOf("", '0', 0, 0) + 2149, 216472770, false, $$e(b2, b3, (byte) (b3 - 1)), new Class[]{Integer.TYPE});
            }
            int iIntValue = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
            int i7 = 59174;
            int i8 = -2083387879;
            if (ICustomTabsServiceDefault) {
                onmessagechannelready.c = bArr.length;
                char[] cArr4 = new char[onmessagechannelready.c];
                onmessagechannelready.a = 0;
                int i9 = $11 + 19;
                $10 = i9 % 128;
                int i10 = i9 % 2;
                while (onmessagechannelready.a < onmessagechannelready.c) {
                    int i11 = $10 + 1;
                    $11 = i11 % 128;
                    int i12 = i11 % 2;
                    cArr4[onmessagechannelready.a] = (char) (cArr2[bArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] + i] - iIntValue);
                    Object[] objArr4 = {onmessagechannelready, onmessagechannelready};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(i8);
                    if (objAccessartificialFrame3 == null) {
                        byte b4 = (byte) 0;
                        byte b5 = b4;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", "", 0, 0) + 21, (char) (i7 - View.combineMeasuredStates(0, 0)), 1943 - (ViewConfiguration.getEdgeSlop() >> 16), 481771537, false, $$e(b4, b5, b5), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                    i7 = 59174;
                    i8 = -2083387879;
                }
                objArr[0] = new String(cArr4);
                return;
            }
            if (requestPostMessageChannelWithExtras) {
                onmessagechannelready.c = cArr.length;
                char[] cArr5 = new char[onmessagechannelready.c];
                onmessagechannelready.a = 0;
                while (onmessagechannelready.a < onmessagechannelready.c) {
                    int i13 = $10 + 61;
                    $11 = i13 % 128;
                    int i14 = i13 % 2;
                    cArr5[onmessagechannelready.a] = (char) (cArr2[cArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                    try {
                        Object[] objArr5 = {onmessagechannelready, onmessagechannelready};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                        if (objAccessartificialFrame4 == null) {
                            byte b6 = (byte) 0;
                            byte b7 = b6;
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(21 - Color.argb(0, 0, 0, 0), (char) (View.MeasureSpec.getMode(0) + 59174), 1943 - (Process.myPid() >> 22), 481771537, false, $$e(b6, b7, b7), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                        int i15 = $10 + 85;
                        $11 = i15 % 128;
                        int i16 = i15 % 2;
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 == null) {
                            throw th2;
                        }
                        throw cause2;
                    }
                }
                objArr[0] = new String(cArr5);
                return;
            }
            int i17 = 0;
            onmessagechannelready.c = iArr.length;
            char[] cArr6 = new char[onmessagechannelready.c];
            while (true) {
                onmessagechannelready.a = i17;
                if (onmessagechannelready.a >= onmessagechannelready.c) {
                    objArr[0] = new String(cArr6);
                    return;
                } else {
                    cArr6[onmessagechannelready.a] = (char) (cArr2[iArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                    i17 = onmessagechannelready.a + 1;
                }
            }
        }

        /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
            java.util.NoSuchElementException
            	at java.base/java.util.TreeMap.key(Unknown Source)
            	at java.base/java.util.TreeMap.lastKey(Unknown Source)
            	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
            	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
            	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
            */
        public static java.lang.Object[] CoroutineDebuggingKt(int r32, int r33) {
            /*
                Method dump skipped, instruction units count: 2626
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.service.TrackingService.d.CoroutineDebuggingKt(int, int):java.lang.Object[]");
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x018b  */
    /* JADX WARN: Code duplicated, block: B:16:0x0226 A[Catch: all -> 0x09dd, TryCatch #2 {all -> 0x09dd, blocks: (B:51:0x06d0, B:53:0x06f0, B:54:0x0740, B:14:0x0212, B:16:0x0226, B:17:0x0258), top: B:98:0x0212 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x026e  */
    /* JADX WARN: Code duplicated, block: B:25:0x0342  */
    /* JADX WARN: Code duplicated, block: B:50:0x0650  */
    /* JADX WARN: Code duplicated, block: B:53:0x06f0 A[Catch: all -> 0x09dd, TryCatch #2 {all -> 0x09dd, blocks: (B:51:0x06d0, B:53:0x06f0, B:54:0x0740, B:14:0x0212, B:16:0x0226, B:17:0x0258), top: B:98:0x0212 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0752  */
    /* JADX WARN: Code duplicated, block: B:62:0x07eb  */
    @Override // com.transistorsoft.locationmanager.service.AbstractService, android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) throws Throwable {
        Object objAccessartificialFrame;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        Object[] objArr;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        int i = 2 % 2;
        super.attachBaseContext(context);
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame7 == null) {
            int scrollBarFadeDuration = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 26;
            char fadingEdgeLength = (char) (ViewConfiguration.getFadingEdgeLength() >> 16);
            int iIndexOf = 1041 - TextUtils.indexOf("", "");
            byte b2 = $$a[5];
            byte b3 = (byte) (b2 - 1);
            byte b4 = b2;
            Object[] objArr2 = new Object[1];
            F(b3, b4, (byte) (b4 - 1), objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration, fadingEdgeLength, iIndexOf, 2061780482, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 4611686018427387936L;
            Object[] objArr3 = new Object[1];
            G(TextUtils.indexOf("", "", 0, 0) + 52709, new char[]{33446, 20300, 6505, 60186, 46396, 34775, 20989, 9130, 60800, 49081, 34843, 23107, 9218, 62997, 49205, 37577, 23802, 11953, 63665, 50519, 38720, 24933}, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            G(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 43868, new char[]{33442, 10714, 54340, 32996, 12144, 56215, 34309, 12930, 55594, 33887, 12481, 57192, 35810, 13847, 57996}, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 35;
                artificialFrame = i2 % 128;
                int i3 = i2 % 2;
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame8 == null) {
                    int i4 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 25;
                    char windowTouchSlop = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                    int i5 = 1042 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                    byte b5 = $$a[5];
                    byte b6 = (byte) (b5 - 1);
                    byte b7 = b5;
                    Object[] objArr5 = new Object[1];
                    F(b6, b7, b7, objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i4, windowTouchSlop, i5, 1145017376, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i6 = ((int[]) objArr6[3])[0];
                int i7 = ((int[]) objArr6[2])[0];
                String[] strArr = (String[]) objArr6[0];
                int iIdentityHashCode = System.identityHashCode(this);
                int i8 = ~iIdentityHashCode;
                int i9 = (-681914690) + ((901447679 | iIdentityHashCode) * (-676)) + (((~(893035767 | i8)) | (-901447680)) * 676) + (((~(iIdentityHashCode | (-8411913))) | (~(i8 | 814931960)) | 86515719) * 676) + 66162843;
                int i10 = (i9 << 13) ^ i9;
                int i11 = i10 ^ (i10 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i11 ^ (i11 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                G(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 61322, new char[]{33453, 27915, 24043, 19873, 15453, 11466, 7336, 3858, 65480, 61436, 56918, 52945, 48808, 43386, 39380, 35209}, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                G(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 8383, new char[]{33454, 41536, 50020, 57344, 319, 9921, 18401, 25739, 34199, 42333, 51818, 60270, 2080, 10543, 20169, 28655}, objArr8);
                int iIntValue = ((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue();
                try {
                    Object[] objArr9 = {691696177};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 9, (char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 22251), 1034 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr9), 66162843, false);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame2 == null) {
                        int i12 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 25;
                        char maxKeyCode = (char) (KeyEvent.getMaxKeyCode() >> 16);
                        int maximumDrawingCacheSize = 1041 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                        byte b8 = $$a[5];
                        byte b9 = (byte) (b8 - 1);
                        byte b10 = b8;
                        Object[] objArr10 = new Object[1];
                        F(b9, b10, b10, objArr10);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i12, maxKeyCode, maximumDrawingCacheSize, 1145017376, false, (String) objArr10[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
                    try {
                        Object[] objArr11 = new Object[1];
                        G(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 52674, new char[]{33446, 20300, 6505, 60186, 46396, 34775, 20989, 9130, 60800, 49081, 34843, 23107, 9218, 62997, 49205, 37577, 23802, 11953, 63665, 50519, 38720, 24933}, objArr11);
                        Class<?> cls3 = Class.forName((String) objArr11[0]);
                        Object[] objArr12 = new Object[1];
                        G(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 43885, new char[]{33442, 10714, 54340, 32996, 12144, 56215, 34309, 12930, 55594, 33887, 12481, 57192, 35810, 13847, 57996}, objArr12);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr12[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame3 == null) {
                            int i13 = 26 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                            char scrollBarFadeDuration2 = (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                            int i14 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 1040;
                            byte b11 = $$a[5];
                            byte b12 = (byte) (b11 - 1);
                            byte b13 = b11;
                            Object[] objArr13 = new Object[1];
                            F(b12, b13, (byte) (b13 - 1), objArr13);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i13, scrollBarFadeDuration2, i14, 2061780482, false, (String) objArr13[0], null);
                        }
                        ((Field) objAccessartificialFrame3).set(null, lValueOf);
                    } catch (Exception unused) {
                        throw new RuntimeException();
                    }
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
        } else {
            Object[] objArr14 = new Object[1];
            G(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 61322, new char[]{33453, 27915, 24043, 19873, 15453, 11466, 7336, 3858, 65480, 61436, 56918, 52945, 48808, 43386, 39380, 35209}, objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            G(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 8383, new char[]{33454, 41536, 50020, 57344, 319, 9921, 18401, 25739, 34199, 42333, 51818, 60270, 2080, 10543, 20169, 28655}, objArr15);
            int iIntValue2 = ((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr16 = {691696177};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 9, (char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 22251), 1034 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr16), 66162843, false);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame2 == null) {
                int i15 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 25;
                char maxKeyCode2 = (char) (KeyEvent.getMaxKeyCode() >> 16);
                int maximumDrawingCacheSize2 = 1041 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                byte b14 = $$a[5];
                byte b15 = (byte) (b14 - 1);
                byte b16 = b14;
                Object[] objArr17 = new Object[1];
                F(b15, b16, b16, objArr17);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i15, maxKeyCode2, maximumDrawingCacheSize2, 1145017376, false, (String) objArr17[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr18 = new Object[1];
            G(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 52674, new char[]{33446, 20300, 6505, 60186, 46396, 34775, 20989, 9130, 60800, 49081, 34843, 23107, 9218, 62997, 49205, 37577, 23802, 11953, 63665, 50519, 38720, 24933}, objArr18);
            Class<?> cls5 = Class.forName((String) objArr18[0]);
            Object[] objArr19 = new Object[1];
            G(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 43885, new char[]{33442, 10714, 54340, 32996, 12144, 56215, 34309, 12930, 55594, 33887, 12481, 57192, 35810, 13847, 57996}, objArr19);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr19[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame3 == null) {
                int i16 = 26 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                char scrollBarFadeDuration3 = (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                int i17 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 1040;
                byte b17 = $$a[5];
                byte b18 = (byte) (b17 - 1);
                byte b19 = b17;
                Object[] objArr110 = new Object[1];
                F(b18, b19, (byte) (b19 - 1), objArr110);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i16, scrollBarFadeDuration3, i17, 2061780482, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i18 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i19 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i19 == i18) {
            Object[] objArr20 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i20 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i21 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i22 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int i23 = ~System.identityHashCode(this);
            int i24 = i20 + ((((~((-290535732) | i23)) | 290457859) * (-241)) - 1998642551) + (((~(i23 | (-77873))) | (-502889784)) * 241);
            int i25 = (i24 << 13) ^ i24;
            int i26 = i25 ^ (i25 >>> 17);
            ((int[]) objArr20[1])[0] = i26 ^ (i26 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr3 != null) {
                int i27 = artificialFrame + 77;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i27 % 128;
                int i28 = i27 % 2;
                for (String str : strArr3) {
                    arrayList.add(str);
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf((((long) 804807117) << 32) ^ ((long) (i18 ^ i19))), Long.valueOf(804807119)};
                byte[] bArr = $$g;
                Object[] objArr22 = new Object[1];
                H(bArr[11], (byte) (-bArr[39]), bArr[25], objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                H((byte) 31, bArr[25], bArr[12], objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i29 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i30 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i31 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int iMyPid = Process.myPid();
                int i32 = ~(768623193 | iMyPid);
                int i33 = ~iMyPid;
                int i34 = i32 | (~(846727000 | i33));
                int i35 = ~((-768623194) | i33);
                int i36 = i29 + (-218940874) + ((i34 | i35) * (-516)) + (((~(iMyPid | (-304612609))) | (~((-542114393) | i33))) * 516) + ((542114392 | i35) * 516);
                int i37 = (i36 << 13) ^ i36;
                int i38 = i37 ^ (i37 >>> 17);
                ((int[]) objArr24[1])[0] = i38 ^ (i38 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame9 == null) {
            int i39 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 24;
            char longPressTimeout = (char) ((ViewConfiguration.getLongPressTimeout() >> 16) + 30068);
            int bitsPerPixel = 815 - ImageFormat.getBitsPerPixel(0);
            byte b20 = $$a[5];
            byte b21 = (byte) (b20 - 1);
            byte b22 = b20;
            Object[] objArr25 = new Object[1];
            F(b21, b22, (byte) (b22 - 1), objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(i39, longPressTimeout, bitsPerPixel, 721586079, false, (String) objArr25[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j3 != -1) {
            long j4 = j3 + 1861;
            Object[] objArr26 = new Object[1];
            G(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 52674, new char[]{33446, 20300, 6505, 60186, 46396, 34775, 20989, 9130, 60800, 49081, 34843, 23107, 9218, 62997, 49205, 37577, 23802, 11953, 63665, 50519, 38720, 24933}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            G(43888 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), new char[]{33442, 10714, 54340, 32996, 12144, 56215, 34309, 12930, 55594, 33887, 12481, 57192, 35810, 13847, 57996}, objArr27);
            if (j4 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i40 = getARTIFICIAL_FRAME_PACKAGE_NAME + 35;
                artificialFrame = i40 % 128;
                int i41 = i40 % 2;
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame10 == null) {
                    int iIndexOf2 = 24 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                    char c2 = (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 30067);
                    int size = 816 - View.MeasureSpec.getSize(0);
                    byte b23 = $$a[5];
                    byte b24 = (byte) (b23 - 1);
                    byte b25 = b23;
                    Object[] objArr28 = new Object[1];
                    F(b24, b25, b25, objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iIndexOf2, c2, size, 891606461, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i42 = ((int[]) objArr29[0])[0];
                int i43 = ((int[]) objArr29[1])[0];
                String[] strArr5 = (String[]) objArr29[2];
                int iIdentityHashCode2 = System.identityHashCode(this);
                int i44 = (-1657291259) + (((~(432064065 | iIdentityHashCode2)) | (-630236432)) * (-964)) + (((~((~iIdentityHashCode2) | 432064065)) | (-1037100880)) * (-964)) + 2138891862;
                int i45 = (i44 << 13) ^ i44;
                int i46 = i45 ^ (i45 >>> 17);
                ((int[]) objArr[3])[0] = i46 ^ (i46 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                G(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 61336, new char[]{33453, 27915, 24043, 19873, 15453, 11466, 7336, 3858, 65480, 61436, 56918, 52945, 48808, 43386, 39380, 35209}, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                G(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(11) + 8314, new char[]{33454, 41536, 50020, 57344, 319, 9921, 18401, 25739, 34199, 42333, 51818, 60270, 2080, 10543, 20169, 28655}, objArr31);
                Object[] objArr32 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue()), 0, 2138891862};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame4 == null) {
                    int bitsPerPixel2 = ImageFormat.getBitsPerPixel(0) + 26;
                    char cLastIndexOf = (char) (30067 - TextUtils.lastIndexOf("", '0', 0));
                    int threadPriority = 816 - ((Process.getThreadPriority(0) + 20) >> 6);
                    byte[] bArr2 = $$a;
                    byte b26 = bArr2[5];
                    Object[] objArr33 = new Object[1];
                    F(b26, (byte) (b26 - 1), bArr2[8], objArr33);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(bitsPerPixel2, cLastIndexOf, threadPriority, -797394565, false, (String) objArr33[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr32);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame5 == null) {
                    int i47 = 25 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                    char cMakeMeasureSpec = (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 30068);
                    int i48 = 817 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                    byte b27 = $$a[5];
                    byte b28 = (byte) (b27 - 1);
                    byte b29 = b27;
                    Object[] objArr34 = new Object[1];
                    F(b28, b29, b29, objArr34);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i47, cMakeMeasureSpec, i48, 891606461, false, (String) objArr34[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr);
                try {
                    Object[] objArr35 = new Object[1];
                    G(TextUtils.indexOf("", "", 0, 0) + 52709, new char[]{33446, 20300, 6505, 60186, 46396, 34775, 20989, 9130, 60800, 49081, 34843, 23107, 9218, 62997, 49205, 37577, 23802, 11953, 63665, 50519, 38720, 24933}, objArr35);
                    Class<?> cls9 = Class.forName((String) objArr35[0]);
                    Object[] objArr36 = new Object[1];
                    G((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 43888, new char[]{33442, 10714, 54340, 32996, 12144, 56215, 34309, 12930, 55594, 33887, 12481, 57192, 35810, 13847, 57996}, objArr36);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr36[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame6 == null) {
                        int offsetAfter = TextUtils.getOffsetAfter("", 0) + 25;
                        char c3 = (char) (30069 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
                        int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 816;
                        byte b30 = $$a[5];
                        byte b31 = (byte) (b30 - 1);
                        byte b32 = b30;
                        Object[] objArr37 = new Object[1];
                        F(b31, b32, (byte) (b32 - 1), objArr37);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(offsetAfter, c3, keyRepeatDelay, 721586079, false, (String) objArr37[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                    int i49 = getARTIFICIAL_FRAME_PACKAGE_NAME + 29;
                    artificialFrame = i49 % 128;
                    int i50 = i49 % 2;
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr38 = new Object[1];
            G(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 61336, new char[]{33453, 27915, 24043, 19873, 15453, 11466, 7336, 3858, 65480, 61436, 56918, 52945, 48808, 43386, 39380, 35209}, objArr38);
            Class<?> cls10 = Class.forName((String) objArr38[0]);
            Object[] objArr39 = new Object[1];
            G(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(11) + 8314, new char[]{33454, 41536, 50020, 57344, 319, 9921, 18401, 25739, 34199, 42333, 51818, 60270, 2080, 10543, 20169, 28655}, objArr39);
            Object[] objArr310 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr39[0], Object.class).invoke(null, this)).intValue()), 0, 2138891862};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame4 == null) {
                int bitsPerPixel3 = ImageFormat.getBitsPerPixel(0) + 26;
                char cLastIndexOf2 = (char) (30067 - TextUtils.lastIndexOf("", '0', 0));
                int threadPriority2 = 816 - ((Process.getThreadPriority(0) + 20) >> 6);
                byte[] bArr3 = $$a;
                byte b210 = bArr3[5];
                Object[] objArr311 = new Object[1];
                F(b210, (byte) (b210 - 1), bArr3[8], objArr311);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(bitsPerPixel3, cLastIndexOf2, threadPriority2, -797394565, false, (String) objArr311[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr310);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame5 == null) {
                int i410 = 25 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                char cMakeMeasureSpec2 = (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 30068);
                int i411 = 817 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                byte b211 = $$a[5];
                byte b212 = (byte) (b211 - 1);
                byte b213 = b211;
                Object[] objArr312 = new Object[1];
                F(b212, b213, b213, objArr312);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i410, cMakeMeasureSpec2, i411, 891606461, false, (String) objArr312[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr);
            Object[] objArr313 = new Object[1];
            G(TextUtils.indexOf("", "", 0, 0) + 52709, new char[]{33446, 20300, 6505, 60186, 46396, 34775, 20989, 9130, 60800, 49081, 34843, 23107, 9218, 62997, 49205, 37577, 23802, 11953, 63665, 50519, 38720, 24933}, objArr313);
            Class<?> cls11 = Class.forName((String) objArr313[0]);
            Object[] objArr314 = new Object[1];
            G((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 43888, new char[]{33442, 10714, 54340, 32996, 12144, 56215, 34309, 12930, 55594, 33887, 12481, 57192, 35810, 13847, 57996}, objArr314);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr314[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame6 == null) {
                int offsetAfter2 = TextUtils.getOffsetAfter("", 0) + 25;
                char c4 = (char) (30069 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
                int keyRepeatDelay2 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 816;
                byte b33 = $$a[5];
                byte b34 = (byte) (b33 - 1);
                byte b35 = b33;
                Object[] objArr315 = new Object[1];
                F(b34, b35, (byte) (b35 - 1), objArr315);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(offsetAfter2, c4, keyRepeatDelay2, 721586079, false, (String) objArr315[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
            int i412 = getARTIFICIAL_FRAME_PACKAGE_NAME + 29;
            artificialFrame = i412 % 128;
            int i51 = i412 % 2;
        }
        int i52 = ((int[]) objArr[1])[0];
        int i53 = ((int[]) objArr[0])[0];
        if (i53 == i52) {
            Object[] objArr40 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i54 = ((int[]) objArr[3])[0];
            int i55 = ((int[]) objArr[0])[0];
            int i56 = ((int[]) objArr[1])[0];
            String[] strArr6 = (String[]) objArr[2];
            int iIdentityHashCode3 = System.identityHashCode(this);
            int i57 = i54 + (-101806364) + (((-25182465) | iIdentityHashCode3) * (-627)) + (((~(363884802 | iIdentityHashCode3)) | 562057168) * (-627)) + (((~(iIdentityHashCode3 | 562057168)) | (~((~iIdentityHashCode3) | (-363884803)))) * 627);
            int i58 = (i57 << 13) ^ i57;
            int i59 = i58 ^ (i58 >>> 17);
            ((int[]) objArr40[3])[0] = i59 ^ (i59 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArr[2];
        if (strArr7 != null) {
            int i60 = 0;
            while (i60 < strArr7.length) {
                int i61 = getARTIFICIAL_FRAME_PACKAGE_NAME + 83;
                artificialFrame = i61 % 128;
                if (i61 % 2 == 0) {
                    arrayList2.add(strArr7[i60]);
                    i60 += 104;
                } else {
                    arrayList2.add(strArr7[i60]);
                    i60++;
                }
            }
        }
        long j5 = ((long) (i52 ^ i53)) ^ (((long) (-2122369946)) << 32);
        long j6 = -2122369945;
        int i62 = artificialFrame + 81;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i62 % 128;
        int i63 = i62 % 2;
        Object[] objArr41 = {Long.valueOf(j5), Long.valueOf(j6)};
        byte[] bArr4 = $$g;
        byte b36 = bArr4[12];
        Object[] objArr42 = new Object[1];
        H(b36, b36, bArr4[25], objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        Object[] objArr43 = new Object[1];
        H((byte) 31, bArr4[25], bArr4[12], objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
        int i64 = ((int[]) objArr[3])[0];
        int i65 = ((int[]) objArr[0])[0];
        int i66 = ((int[]) objArr[1])[0];
        String[] strArr8 = (String[]) objArr[2];
        int i67 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().densityDpi;
        int i68 = ~((-273678339) | i67);
        int i69 = ~i67;
        int i70 = i64 + (-1731777003) + ((i68 | (~(1072849846 | i69))) * 920) + (((~((-997343875) | i69)) | 273678338) * 920) + (((~(i67 | 1072849846)) | (~((-273678339) | i69)) | (~((-723665537) | i67))) * 920);
        int i71 = (i70 << 13) ^ i70;
        int i72 = i71 ^ (i71 >>> 17);
        ((int[]) objArr44[3])[0] = i72 ^ (i72 << 5);
    }

    static void accessartificialFrame() {
        extraCommand = -6363844027565589816L;
    }
}
