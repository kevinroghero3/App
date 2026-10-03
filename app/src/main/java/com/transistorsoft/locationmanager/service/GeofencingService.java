package com.transistorsoft.locationmanager.service;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.GeofencingEvent;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.common.base.Ascii;
import com.google.maps.android.ui.AnimationUtil;
import com.transistorsoft.locationmanager.adapter.BackgroundGeolocation;
import com.transistorsoft.locationmanager.adapter.TSConfig;
import com.transistorsoft.locationmanager.adapter.callback.TSLocationCallback;
import com.transistorsoft.locationmanager.data.sqlite.GeofenceDAO;
import com.transistorsoft.locationmanager.data.sqlite.SQLiteLocationDAO;
import com.transistorsoft.locationmanager.event.GeofenceEvent;
import com.transistorsoft.locationmanager.event.MotionChangeEvent;
import com.transistorsoft.locationmanager.event.PersistEvent;
import com.transistorsoft.locationmanager.geofence.TSGeofence;
import com.transistorsoft.locationmanager.geofence.TSGeofenceManager;
import com.transistorsoft.locationmanager.http.HttpService;
import com.transistorsoft.locationmanager.location.TSLocation;
import com.transistorsoft.locationmanager.location.TSLocationManager;
import com.transistorsoft.locationmanager.location.TSMotionChangeRequest;
import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.locationmanager.logger.TSMediaPlayer;
import com.transistorsoft.locationmanager.plugin.TSPlugin;
import com.transistorsoft.locationmanager.util.LocationAuthorization;
import com.transistorsoft.locationmanager.util.Util;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import net.pluservice.unicoc.R;
import o.ArtificialStackFrames;
import o.artificialFrame;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes.dex */
public class GeofencingService extends AbstractService {
    private static int[] ICustomTabsCallbackStub;
    private static final AtomicInteger r;
    private StopTimeoutEvaluator q;
    private static final byte[] $$c = {Ascii.FS, 50, 106, -64};
    private static final int $$f = 214;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$g = {71, -70, 54, 33, -15, -1, 60, -60, -11, -3, 5, -8, 4, 52, -54, -16, 7, -17, 0, 3, 2, 51, -66, 9, -22, Ascii.FF, -16, 6, 5, -14, 59, -56, -15, 0, -6, -6, 65, -74, -2, 8, -6, 0, -14, 8, 1, -17, 66, -25, -56, 8, 10, -15, 1, 3, Ascii.GS, -47, 0, -6, -6, 75, -3, -36, -54, 1, Ascii.FF, -16, 1, 10, -14, Ascii.SYN, -41, 8, -9, 9, 0, -18, 8, 3, Ascii.DC4, -24, -15, 8, -5, 0, 46, -3, -64, 1, 0, -15, -3, 1, 58, 2, -62, -8, -9, Ascii.FF, -16, 1, 10, -14, 59, -69, 1, 8, -22, Ascii.VT, -12, -6, 2, 60, -54, -16, 7, -17, 0, 3, 2, 51, -25, -36, -4, -2, -16, -3, 10, -2, Ascii.SO, -31, 9, -11, 3, -18, 48, -38, 0, -18, -7, Ascii.FF, -16};
    private static final int $$h = 17;
    private static final byte[] $$a = {52, -111, -122, 98, 5, -1, -33, 33, -2, -9, 5, -7, 5, -1, -50, 39, Ascii.VT, -7, -12, Ascii.SI, Ascii.ESC, 1, -7, -6, -33, 51, -12, 3, -8, 1, Ascii.CR};
    private static final int $$b = JfifUtil.MARKER_SOI;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;

    /* JADX INFO: loaded from: classes3.dex */
    class a implements Runnable {
        private final Intent a;
        private final int b;

        a(Intent intent, int i) {
            this.b = i;
            this.a = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context applicationContext = GeofencingService.this.getApplicationContext();
            String action = this.a.getAction();
            TSConfig tSConfig = TSConfig.getInstance(applicationContext);
            TSGeofenceManager tSGeofenceManager = TSGeofenceManager.getInstance(applicationContext);
            if (!tSConfig.isLocationTrackingMode() && ((tSConfig.getIsMoving().booleanValue() && tSConfig.getGeofenceModeHighAccuracy().booleanValue() && tSGeofenceManager.isMonitoringGeofencesInProximity()) || tSConfig.getNotification().getSticky().booleanValue())) {
                GeofencingService.this.a(true);
            }
            if (action != null) {
                if (!action.equalsIgnoreCase("start") && action.equalsIgnoreCase(TSGeofenceManager.ACTION_STATIONARY_GEOFENCE)) {
                    GeofencingEvent geofencingEventFromIntent = GeofencingEvent.fromIntent(this.a);
                    if (geofencingEventFromIntent.getTriggeringGeofences() != null) {
                        GeofencingService.this.b(geofencingEventFromIntent);
                    }
                }
                GeofencingService.this.a(this.b);
                return;
            }
            if (LocationResult.hasResult(this.a)) {
                GeofencingService.this.a(LocationResult.extractResult(this.a));
                GeofencingService.this.a(this.b);
            } else if (LocationAvailability.hasLocationAvailability(this.a)) {
                GeofencingService.this.a(LocationAvailability.extractLocationAvailability(this.a));
                GeofencingService.this.a(this.b);
            } else if (GeofencingEvent.fromIntent(this.a) != null) {
                TSLocationManager.getInstance(applicationContext).getLastLocation(new C0129a());
            }
        }

        /* JADX INFO: renamed from: com.transistorsoft.locationmanager.service.GeofencingService$a$a, reason: collision with other inner class name */
        class C0129a implements TSLocationManager.LocationCallback {
            C0129a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void a(Location location) {
                a aVar = a.this;
                GeofencingService.this.a(GeofencingEvent.fromIntent(aVar.a), location);
                a aVar2 = a.this;
                GeofencingService.this.a(aVar2.b);
            }

            @Override // com.transistorsoft.locationmanager.location.TSLocationManager.LocationCallback
            public void onFailure(String str) {
                BackgroundGeolocation.getThreadPool().execute(new Runnable() { // from class: com.transistorsoft.locationmanager.service.GeofencingService$a$a$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a();
                    }
                });
            }

            @Override // com.transistorsoft.locationmanager.location.TSLocationManager.LocationCallback
            public void onLocation(final Location location) {
                BackgroundGeolocation.getThreadPool().execute(new Runnable() { // from class: com.transistorsoft.locationmanager.service.GeofencingService$a$a$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(location);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void a() {
                a aVar = a.this;
                GeofencingService.this.a(GeofencingEvent.fromIntent(aVar.a), (Location) null);
                a aVar2 = a.this;
                GeofencingService.this.a(aVar2.b);
            }
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    static class b implements TSLocationCallback {
        private final TSLocationCallback a;
        private final boolean b;
        private final Context c;

        b(Context context, boolean z, @Nullable TSLocationCallback tSLocationCallback) {
            this.c = context;
            this.b = z;
            this.a = tSLocationCallback;
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSLocationCallback
        public void onError(Integer num) {
            TSLocationCallback tSLocationCallback = this.a;
            if (tSLocationCallback != null) {
                tSLocationCallback.onError(num);
            }
            if (this.b) {
                return;
            }
            ActivityRecognitionService.start(this.c);
        }

        @Override // com.transistorsoft.locationmanager.adapter.callback.TSLocationCallback
        public void onLocation(TSLocation tSLocation) {
            GeofencingService.r.set(0);
            TSLocationCallback tSLocationCallback = this.a;
            if (tSLocationCallback != null) {
                tSLocationCallback.onLocation(tSLocation);
            }
            TSGeofenceManager.getInstance(this.c).startMonitoringStationaryRegion(tSLocation.getLocation());
            if (this.b) {
                return;
            }
            ActivityRecognitionService.start(this.c);
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
    private static java.lang.String $$i(short r6, byte r7, byte r8) {
        /*
            int r7 = r7 * 6
            int r7 = r7 + 109
            int r8 = r8 * 2
            int r0 = 1 - r8
            int r6 = r6 + 4
            byte[] r1 = com.transistorsoft.locationmanager.service.GeofencingService.$$c
            byte[] r0 = new byte[r0]
            r2 = 0
            int r8 = 0 - r8
            if (r1 != 0) goto L17
            r4 = r7
            r3 = r2
            r7 = r6
            goto L2c
        L17:
            r3 = r2
        L18:
            int r6 = r6 + 1
            byte r4 = (byte) r7
            r0[r3] = r4
            if (r3 != r8) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            return r6
        L25:
            int r3 = r3 + 1
            r4 = r1[r6]
            r5 = r7
            r7 = r6
            r6 = r5
        L2c:
            int r4 = -r4
            int r6 = r6 + r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.service.GeofencingService.$$i(short, byte, byte):java.lang.String");
    }

    static {
        accessartificialFrame();
        r = new AtomicInteger(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LocationAvailability locationAvailability) {
    }

    public static void changePace(Context context, boolean z, @Nullable TSLocationCallback tSLocationCallback) {
        TSConfig tSConfig = TSConfig.getInstance(context);
        if (!tSConfig.getGeofenceModeHighAccuracy().booleanValue()) {
            z = false;
        }
        tSConfig.setIsMoving(Boolean.valueOf(z));
        TSGeofenceManager tSGeofenceManager = TSGeofenceManager.getInstance(context);
        if (z) {
            HeartbeatService.stop(context);
            tSGeofenceManager.startMonitoringSignificantLocationChanges();
        } else {
            if (tSConfig.getNotification().getSticky().booleanValue()) {
                AbstractService.launchService(context, GeofencingService.class, "start");
            } else {
                stopService(context);
            }
            HeartbeatService.start(context);
            tSGeofenceManager.stopMonitoringSignificantLocationChanges();
            tSGeofenceManager.setIsMoving(false);
        }
        if (tSConfig.getGeofenceModeHighAccuracy().booleanValue()) {
            ForegroundNotification.a(z ? new Date().getTime() : 0L);
        }
        TSLocationManager tSLocationManager = TSLocationManager.getInstance(context);
        if (isAcquiringMotionChange()) {
            AtomicInteger atomicInteger = r;
            tSLocationManager.cancelRequest(atomicInteger.get());
            atomicInteger.set(0);
        }
        TSMotionChangeRequest tSMotionChangeRequestBuild = new TSMotionChangeRequest.Builder(context).setCallback(new b(context, z, tSLocationCallback)).build();
        r.set(tSMotionChangeRequestBuild.getId());
        tSLocationManager.getCurrentPosition(tSMotionChangeRequestBuild);
    }

    public static PendingIntent getPendingIntent(Context context) {
        return getPendingIntent(context, null);
    }

    public static boolean isAcquiringMotionChange() {
        return r.get() != 0;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0029  */
    /* JADX WARN: Code duplicated, block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x002b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0029
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void s(short r5, short r6, int r7, java.lang.Object[] r8) {
        /*
            byte[] r0 = com.transistorsoft.locationmanager.service.GeofencingService.$$a
            int r5 = r5 * 28
            int r5 = r5 + 84
            int r7 = r7 * 3
            int r7 = r7 + 9
            int r6 = r6 * 8
            int r6 = 19 - r6
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L17
            r4 = r5
            r5 = r7
            r3 = r2
            goto L2b
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r5
            int r6 = r6 + 1
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r7) goto L29
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L29:
            r4 = r0[r6]
        L2b:
            int r5 = r5 + r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.service.GeofencingService.s(short, short, int, java.lang.Object[]):void");
    }

    public static void stop(Context context) {
        stopService(context);
        if (isAcquiringMotionChange()) {
            TSLocationManager tSLocationManager = TSLocationManager.getInstance(context);
            AtomicInteger atomicInteger = r;
            tSLocationManager.cancelRequest(atomicInteger.get());
            atomicInteger.set(0);
        }
    }

    public static void stopService(Context context) {
        AbstractService.stop(context, GeofencingService.class);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void u(short r7, short r8, int r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 + 3
            byte[] r0 = com.transistorsoft.locationmanager.service.GeofencingService.$$g
            int r9 = r9 + 4
            int r7 = r7 * 3
            int r7 = r7 + 36
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L13
            r3 = r8
            r7 = r9
            r4 = r2
            goto L2b
        L13:
            r3 = r2
        L14:
            r6 = r9
            r9 = r7
            r7 = r6
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r8) goto L26
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L26:
            r3 = r0[r7]
            r6 = r9
            r9 = r7
            r7 = r6
        L2b:
            int r3 = -r3
            int r9 = r9 + 1
            int r7 = r7 + r3
            int r7 = r7 + (-3)
            r3 = r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.service.GeofencingService.u(short, short, int, java.lang.Object[]):void");
    }

    @Override // com.transistorsoft.locationmanager.service.AbstractService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.transistorsoft.locationmanager.service.AbstractService, android.app.Service
    public void onCreate() {
        if (Build.VERSION.SDK_INT >= 29) {
            super.a(getClass().getSimpleName(), 8);
        } else {
            super.a(getClass().getSimpleName(), 0);
        }
        final Context applicationContext = getApplicationContext();
        this.q = new StopTimeoutEvaluator(1200000, new StopTimeoutEvaluator.a() { // from class: com.transistorsoft.locationmanager.service.GeofencingService$$ExternalSyntheticLambda0
            @Override // com.transistorsoft.locationmanager.service.StopTimeoutEvaluator.a
            public final void a() {
                GeofencingService.changePace(applicationContext, false, null);
            }
        });
    }

    @Override // com.transistorsoft.locationmanager.service.AbstractService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (!a(intent, i2, true)) {
            return 2;
        }
        BackgroundGeolocation.getThreadPool().execute(new a(intent, i2));
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(GeofencingEvent geofencingEvent) {
        int activityType;
        boolean zHasTriggerActivity;
        Context applicationContext = getApplicationContext();
        TSGeofenceManager tSGeofenceManager = TSGeofenceManager.getInstance(applicationContext);
        TSConfig tSConfig = TSConfig.getInstance(applicationContext);
        if (!tSConfig.getEnabled().booleanValue()) {
            TSLog.logger.warn(TSLog.warn("Stationary geofence exit fired while disabled <IGNORED>"));
            tSGeofenceManager.stopMonitoringStationaryRegion();
            return;
        }
        Location stationaryLocation = tSGeofenceManager.getStationaryLocation();
        Location triggeringLocation = geofencingEvent.getTriggeringLocation();
        if (triggeringLocation != null && stationaryLocation != null) {
            float fDistanceTo = triggeringLocation.distanceTo(stationaryLocation);
            float fIntValue = tSConfig.getStationaryRadius().intValue();
            if (!tSConfig.isLocationTrackingMode() && !tSConfig.getGeofenceModeHighAccuracy().booleanValue()) {
                fIntValue = tSConfig.getGeofenceProximityRadius().longValue() / 2.0f;
            } else if (fIntValue < 150.0f) {
                fIntValue = 150.0f;
            }
            float accuracy = triggeringLocation.hasAccuracy() ? triggeringLocation.getAccuracy() : 0.0f;
            StringBuilder sb = new StringBuilder();
            sb.append(TSLog.header("Stationary EXIT distance evaluation"));
            sb.append(TSLog.boxRow("distance=" + fDistanceTo + "m, accuracy=" + accuracy + "m, radius=" + fIntValue + "m"));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("📍  Stationary=");
            sb2.append(stationaryLocation);
            sb.append(TSLog.boxRow(sb2.toString()));
            StringBuilder sb3 = new StringBuilder();
            sb3.append("📍  Trigger=");
            sb3.append(triggeringLocation);
            sb.append(TSLog.boxRow(sb3.toString()));
            sb.append(TSLog.BOX_BOTTOM);
            TSLog.logger.debug(sb.toString());
            if (fIntValue > 0.0f && fDistanceTo < fIntValue) {
                TSLog.logger.warn(TSLog.warn("Ignoring spurious stationary geofence EXIT"));
                tSGeofenceManager.startMonitoringStationaryRegion(stationaryLocation);
                return;
            }
        }
        Location triggeringLocation2 = geofencingEvent.getTriggeringLocation();
        tSGeofenceManager.setLocation(triggeringLocation2, tSConfig.getIsMoving().booleanValue());
        if (tSConfig.isLocationTrackingMode()) {
            if (LocationAuthorization.hasActivityPermission(applicationContext)) {
                activityType = ActivityRecognitionService.getLastActivity().getActivityType();
                zHasTriggerActivity = tSConfig.hasTriggerActivity(activityType);
            } else {
                activityType = 3;
                zHasTriggerActivity = true;
            }
            if (zHasTriggerActivity || activityType == 3) {
                TrackingService.changePace(applicationContext, true);
            }
        } else {
            TSLocation.applyExtras(applicationContext, triggeringLocation2);
            triggeringLocation2.getExtras().putString(NotificationCompat.CATEGORY_EVENT, BackgroundGeolocation.EVENT_MOTIONCHANGE);
            triggeringLocation2.getExtras().remove("sample");
            EventBus.getDefault().post(new MotionChangeEvent(new TSLocation(applicationContext, triggeringLocation2, ActivityRecognitionService.getMostProbableActivity())));
            if (tSConfig.getGeofenceModeHighAccuracy().booleanValue()) {
                a(true);
                changePace(getApplicationContext(), true, null);
            } else {
                tSGeofenceManager.startMonitoringStationaryRegion(triggeringLocation2);
            }
        }
        TSMediaPlayer.getInstance().debug(getApplicationContext(), "tslocationmanager_zap_fast");
        StringBuilder sb4 = new StringBuilder();
        sb4.append(TSLog.header("GeofencingService: Stationary geofence EXIT"));
        sb4.append(TSLog.boxRow(TSLog.ICON_PIN + triggeringLocation2));
        TSLog.logger.info(sb4.toString());
    }

    public static PendingIntent getPendingIntent(Context context, @Nullable String str) {
        Intent intent = new Intent(context, (Class<?>) GeofencingService.class);
        if (str != null) {
            intent.setAction(str);
        }
        return Build.VERSION.SDK_INT >= 26 ? PendingIntent.getForegroundService(context, 0, intent, Util.getPendingIntentFlags(134217728)) : PendingIntent.getService(context, 0, intent, 134217728);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GeofencingEvent geofencingEvent, Location location) {
        String str;
        String str2;
        int i;
        Context applicationContext = getApplicationContext();
        if (geofencingEvent.hasError()) {
            TSLog.logger.warn(TSLog.warn("Geofencing error: " + geofencingEvent.getErrorCode()));
            if (geofencingEvent.getErrorCode() == 1000) {
                TSGeofenceManager.getInstance(applicationContext).reset();
                return;
            }
            return;
        }
        if (geofencingEvent.getTriggeringGeofences() == null) {
            TSLog.logger.warn(TSLog.warn("GeofencingEvent.getTriggeringGeofences() returned null <IGNORED>"));
            return;
        }
        int geofenceTransition = geofencingEvent.getGeofenceTransition();
        int i2 = 2;
        int i3 = 1;
        if (geofenceTransition == 1 || geofenceTransition == 2 || geofenceTransition == 4) {
            int geofenceTransition2 = geofencingEvent.getGeofenceTransition();
            if (geofenceTransition2 == 1) {
                str2 = "tslocationmanager_beep_trip_up_dry";
                str = "ENTER";
            } else if (geofenceTransition2 == 2) {
                str2 = "tslocationmanager_beep_trip_dry";
                str = "EXIT";
            } else if (geofenceTransition2 != 4) {
                str = "UNKNOWN";
                str2 = "";
            } else {
                str2 = "tslocationmanager_beep_trip_up_echo";
                str = "DWELL";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(TSLog.header("Geofencing Event: " + str));
            TSGeofenceManager tSGeofenceManager = TSGeofenceManager.getInstance(getApplicationContext());
            GeofenceDAO geofenceDAO = GeofenceDAO.getInstance(getApplicationContext());
            ArrayList arrayList = new ArrayList();
            List<Geofence> triggeringGeofences = geofencingEvent.getTriggeringGeofences();
            Location triggeringLocation = geofencingEvent.getTriggeringLocation();
            Iterator<Geofence> it2 = triggeringGeofences.iterator();
            while (it2.hasNext()) {
                Geofence next = it2.next();
                TSGeofence tSGeofenceFind = geofenceDAO.find(next.getRequestId());
                if (tSGeofenceFind != null && geofenceTransition2 == i2 && !tSGeofenceFind.isPolygon() && triggeringLocation != null) {
                    float[] fArr = new float[i3];
                    Location.distanceBetween(triggeringLocation.getLatitude(), triggeringLocation.getLongitude(), tSGeofenceFind.getLatitude(), tSGeofenceFind.getLongitude(), fArr);
                    float f = fArr[0];
                    float radius = tSGeofenceFind.getRadius();
                    float accuracy = triggeringLocation.hasAccuracy() ? triggeringLocation.getAccuracy() : 0.0f;
                    if (radius > 0.0f && f + accuracy < radius) {
                        StringBuilder sb2 = new StringBuilder();
                        Iterator<Geofence> it3 = it2;
                        sb2.append(TSLog.header("Ignoring spurious geofence EXIT"));
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("id=");
                        sb3.append(next.getRequestId());
                        sb2.append(TSLog.boxRow(sb3.toString()));
                        sb2.append(TSLog.boxRow("distance=" + f + "m, accuracy=" + accuracy + "m, radius=" + radius + "m"));
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("📍  Trigger=");
                        sb4.append(triggeringLocation);
                        sb2.append(TSLog.boxRow(sb4.toString()));
                        sb2.append(TSLog.BOX_BOTTOM);
                        TSLog.logger.warn(sb2.toString());
                        arrayList.add(next);
                        it2 = it3;
                        geofenceDAO = geofenceDAO;
                        i2 = 2;
                        i3 = 1;
                    }
                }
                GeofenceDAO geofenceDAO2 = geofenceDAO;
                Iterator<Geofence> it4 = it2;
                if (tSGeofenceFind != null) {
                    if (tSGeofenceFind.isPolygon()) {
                        arrayList.add(next);
                        i = 1;
                        if (geofenceTransition2 == 1) {
                            TSMediaPlayer.getInstance().debug(applicationContext, "tslocationmanager_chime_short_on");
                            tSGeofenceManager.startMonitoringPolygon(tSGeofenceFind);
                            sb.append(TSLog.boxRow("ENTER containing geofence of Polygon: " + next.getRequestId()));
                        } else {
                            TSMediaPlayer.getInstance().debug(applicationContext, "tslocationmanager_chime_short_off");
                            String identifier = tSGeofenceFind.getIdentifier();
                            if (tSGeofenceManager.getPolygonState(identifier)) {
                                tSGeofenceManager.setPolygonState(identifier, false);
                                PolygonGeofencingService.handleGeofencingEvent(getApplicationContext(), identifier, geofencingEvent.getTriggeringLocation(), geofenceTransition2);
                            }
                            tSGeofenceManager.stopMonitoringPolygon(tSGeofenceFind.getIdentifier());
                            sb.append(TSLog.boxRow("EXIT containing geofence of Polygon: " + next.getRequestId()));
                        }
                    } else {
                        i = 1;
                        TSMediaPlayer.getInstance().debug(applicationContext, str2);
                        sb.append(TSLog.boxRow(next.getRequestId()));
                    }
                } else {
                    i = 1;
                    GeofencingClient geofencingClient = LocationServices.getGeofencingClient(getApplicationContext());
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(next.getRequestId());
                    geofencingClient.removeGeofences(arrayList2);
                    TSLog.logger.error(TSLog.warn("Failed to find Geofence: " + next.getRequestId()));
                }
                i3 = i;
                it2 = it4;
                geofenceDAO = geofenceDAO2;
                i2 = 2;
            }
            GeofenceDAO geofenceDAO3 = geofenceDAO;
            triggeringGeofences.removeAll(arrayList);
            sb.append(TSLog.BOX_BOTTOM);
            TSLog.logger.info(sb.toString());
            if (triggeringGeofences.isEmpty()) {
                return;
            }
            TSConfig tSConfig = TSConfig.getInstance(applicationContext);
            Location triggeringLocation2 = geofencingEvent.getTriggeringLocation();
            TSLocation.applyExtras(applicationContext, triggeringLocation2);
            tSGeofenceManager.setLocation(triggeringLocation2, tSConfig.getIsMoving().booleanValue());
            TSLocationManager tSLocationManager = TSLocationManager.getInstance(applicationContext);
            Bundle extras = triggeringLocation2.getExtras();
            extras.putBoolean("isMoving", tSConfig.getIsMoving().booleanValue());
            extras.putFloat(TSLocation.LOCATION_OPTIONS_ODOMETER, tSConfig.getOdometer().floatValue());
            EventBus.getDefault().post(new TSLocation(applicationContext, triggeringLocation2, ActivityRecognitionService.getMostProbableActivity(), tSLocationManager.getCurrentLocationProvider()));
            for (Geofence geofence : triggeringGeofences) {
                GeofenceDAO geofenceDAO4 = geofenceDAO3;
                TSGeofence tSGeofenceFind2 = geofenceDAO4.find(geofence.getRequestId());
                if (tSGeofenceFind2 == null) {
                    TSLog.logger.error("Failed to find geofence record in database: " + geofence.getRequestId());
                } else {
                    GeofenceEvent geofenceEvent = new GeofenceEvent(geofenceTransition2, tSGeofenceFind2, new TSLocation(applicationContext, triggeringLocation2, ActivityRecognitionService.getMostProbableActivity()));
                    if (tSConfig.getMaxRecordsToPersist().intValue() != 0) {
                        a(geofenceEvent.getLocation());
                    }
                    EventBus.getDefault().post(geofenceEvent);
                }
                geofenceDAO3 = geofenceDAO4;
            }
        }
    }

    private static void t(int i, int[] iArr, Object[] objArr) throws Throwable {
        int length;
        int[] iArr2;
        int i2;
        int i3 = 2;
        int i4 = 2 % 2;
        artificialFrame artificialframe = new artificialFrame();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr3 = ICustomTabsCallbackStub;
        int i5 = -1780896814;
        int i6 = 16;
        int i7 = 1;
        int i8 = 0;
        if (iArr3 != null) {
            int length2 = iArr3.length;
            int[] iArr4 = new int[length2];
            int i9 = 0;
            while (i9 < length2) {
                int i10 = $11 + 53;
                $10 = i10 % 128;
                if (i10 % i3 != 0) {
                    try {
                        Object[] objArr2 = new Object[1];
                        objArr2[i8] = Integer.valueOf(iArr3[i9]);
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i5);
                        if (objAccessartificialFrame == null) {
                            byte b2 = (byte) (-1);
                            byte b3 = (byte) (b2 + 1);
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - TextUtils.getOffsetBefore("", i8), (char) (ViewConfiguration.getMaximumFlingVelocity() >> i6), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 1561, 180153818, false, $$i(b2, b3, b3), new Class[]{Integer.TYPE});
                        }
                        iArr4[i9] = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } else {
                    Object[] objArr3 = {Integer.valueOf(iArr3[i9])};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                    if (objAccessartificialFrame2 == null) {
                        byte b4 = (byte) (-1);
                        byte b5 = (byte) (b4 + 1);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(12 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 1561, 180153818, false, $$i(b4, b5, b5), new Class[]{Integer.TYPE});
                    }
                    iArr4[i9] = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                    i9++;
                }
                i3 = 2;
                i5 = -1780896814;
                i6 = 16;
                i8 = 0;
            }
            int i11 = $11 + 37;
            $10 = i11 % 128;
            int i12 = i11 % 2;
            iArr3 = iArr4;
        }
        int length3 = iArr3.length;
        int[] iArr5 = new int[length3];
        int[] iArr6 = ICustomTabsCallbackStub;
        if (iArr6 != null) {
            int i13 = $11 + 85;
            $10 = i13 % 128;
            if (i13 % 2 != 0) {
                length = iArr6.length;
                iArr2 = new int[length];
                i2 = 1;
            } else {
                length = iArr6.length;
                iArr2 = new int[length];
                i2 = 0;
            }
            while (i2 < length) {
                Object[] objArr4 = new Object[i7];
                objArr4[0] = Integer.valueOf(iArr6[i2]);
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                if (objAccessartificialFrame3 == null) {
                    byte b6 = (byte) (-1);
                    byte b7 = (byte) (b6 + 1);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getPressedStateDuration() >> 16) + 11, (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), 1562 - ((Process.getThreadPriority(0) + 20) >> 6), 180153818, false, $$i(b6, b7, b7), new Class[]{Integer.TYPE});
                }
                iArr2[i2] = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
                i2++;
                iArr6 = iArr6;
                i7 = 1;
            }
            iArr6 = iArr2;
        }
        char c = 0;
        System.arraycopy(iArr6, 0, iArr5, 0, length3);
        artificialframe.e = 0;
        while (artificialframe.e < iArr.length) {
            cArr[c] = (char) (iArr[artificialframe.e] >> 16);
            cArr[1] = (char) iArr[artificialframe.e];
            cArr[2] = (char) (iArr[artificialframe.e + 1] >> 16);
            cArr[3] = (char) iArr[artificialframe.e + 1];
            artificialframe.c = (cArr[0] << 16) + cArr[1];
            artificialframe.b = (cArr[2] << 16) + cArr[3];
            artificialFrame.coroutineBoundary(iArr5);
            int i14 = 0;
            for (int i15 = 16; i14 < i15; i15 = 16) {
                int i16 = $10 + 27;
                $11 = i16 % 128;
                int i17 = i16 % 2;
                artificialframe.c ^= iArr5[i14];
                try {
                    Object[] objArr5 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                    if (objAccessartificialFrame4 == null) {
                        byte b8 = (byte) (-1);
                        byte b9 = (byte) (-b8);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(26 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) View.getDefaultSize(0, 0), 1040 - Process.getGidForName(""), 995482881, false, $$i(b8, b9, (byte) (b9 - 1)), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                    }
                    int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                    artificialframe.c = artificialframe.b;
                    artificialframe.b = iIntValue;
                    i14++;
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            }
            int i18 = artificialframe.c;
            artificialframe.c = artificialframe.b;
            artificialframe.b = i18;
            artificialframe.b ^= iArr5[16];
            artificialframe.c ^= iArr5[17];
            int i19 = artificialframe.c;
            int i20 = artificialframe.b;
            cArr[0] = (char) (artificialframe.c >>> 16);
            cArr[1] = (char) artificialframe.c;
            cArr[2] = (char) (artificialframe.b >>> 16);
            cArr[3] = (char) artificialframe.b;
            artificialFrame.coroutineBoundary(iArr5);
            cArr2[artificialframe.e * 2] = cArr[0];
            cArr2[(artificialframe.e * 2) + 1] = cArr[1];
            cArr2[(artificialframe.e * 2) + 2] = cArr[2];
            cArr2[(artificialframe.e * 2) + 3] = cArr[3];
            Object[] objArr6 = {artificialframe, artificialframe};
            Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1348396126);
            if (objAccessartificialFrame5 == null) {
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(37 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 28010), Color.argb(0, 0, 0, 0) + 306, -818175402, false, "q", new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame5).invoke(null, objArr6);
            c = 0;
        }
        objArr[0] = new String(cArr2, 0, i);
    }

    private void a(TSLocation tSLocation) {
        Context applicationContext = getApplicationContext();
        TSConfig tSConfig = TSConfig.getInstance(applicationContext);
        if (tSConfig.shouldPersist(tSLocation)) {
            if (EventBus.getDefault().hasSubscriberForEvent(PersistEvent.class)) {
                if (TSPlugin.getInstance().canUsePersistEvent(applicationContext)) {
                    EventBus.getDefault().post(new PersistEvent(applicationContext, tSLocation, tSConfig.getParams()));
                    return;
                } else {
                    TSLog.logger.warn(TSLog.warn("Failed to persist location"));
                    return;
                }
            }
            if (tSConfig.getMaxDaysToPersist().intValue() == 0 || !tSConfig.getPersist().booleanValue()) {
                return;
            }
            if (SQLiteLocationDAO.getInstance(applicationContext).persist(tSLocation)) {
                if (tSConfig.getAutoSync().booleanValue() && tSConfig.hasUrl()) {
                    HttpService.getInstance(applicationContext).flush(true);
                    return;
                }
                return;
            }
            TSLog.logger.error(TSLog.error("INSERT FAILURE" + tSLocation));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LocationResult locationResult) {
        Context applicationContext = getApplicationContext();
        Location lastLocation = locationResult.getLastLocation();
        TSConfig tSConfig = TSConfig.getInstance(applicationContext);
        TSGeofenceManager.getInstance(this).setLocation(lastLocation, tSConfig.getIsMoving().booleanValue());
        long jLocationAge = TSLocationManager.locationAge(lastLocation);
        StringBuilder sb = new StringBuilder();
        sb.append(TSLog.header("GeofencingService: Proximity evaluator"));
        sb.append(TSLog.boxRow(TSLog.ICON_PIN + lastLocation.toString() + ", age: " + jLocationAge + "ms, time: " + lastLocation.getTime()));
        TSLog.logger.info(sb.toString());
        TSMediaPlayer.getInstance().debug(applicationContext, "tslocationmanager_click_tap_done_checkbox5_full_vol");
        if (tSConfig.getIsMoving().booleanValue() && !tSConfig.isLocationTrackingMode() && tSConfig.getGeofenceModeHighAccuracy().booleanValue()) {
            if (!LocationAuthorization.hasActivityPermission(getApplicationContext()) || tSConfig.getDisableMotionActivityUpdates().booleanValue()) {
                if (!lastLocation.hasSpeed()) {
                    if (this.q.b()) {
                        return;
                    }
                    this.q.d();
                } else {
                    if (this.q.a(lastLocation) < 1.4d) {
                        if (this.q.b()) {
                            return;
                        }
                        this.q.d();
                        return;
                    }
                    this.q.a();
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:16:0x023d A[Catch: all -> 0x09ac, TryCatch #2 {all -> 0x09ac, blocks: (B:54:0x06e0, B:56:0x06f4, B:57:0x0723, B:14:0x021c, B:16:0x023d, B:17:0x0289), top: B:98:0x021c }] */
    /* JADX WARN: Code duplicated, block: B:20:0x029b  */
    /* JADX WARN: Code duplicated, block: B:25:0x0341  */
    /* JADX WARN: Code duplicated, block: B:53:0x0679  */
    /* JADX WARN: Code duplicated, block: B:56:0x06f4 A[Catch: all -> 0x09ac, TryCatch #2 {all -> 0x09ac, blocks: (B:54:0x06e0, B:56:0x06f4, B:57:0x0723, B:14:0x021c, B:16:0x023d, B:17:0x0289), top: B:98:0x021c }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0739  */
    /* JADX WARN: Code duplicated, block: B:65:0x07ca  */
    @Override // com.transistorsoft.locationmanager.service.AbstractService, android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) throws Throwable {
        Object objAccessartificialFrame;
        Object[] objArr;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        Object[] objArr2;
        int i = 2 % 2;
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 45;
        artificialFrame = i2 % 128;
        int i3 = i2 % 2;
        super.attachBaseContext(context);
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame7 == null) {
            int iArgb = Color.argb(0, 0, 0, 0) + 25;
            char modifierMetaStateMask = (char) (30067 - ((byte) KeyEvent.getModifierMetaStateMask()));
            int iIndexOf = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 817;
            byte[] bArr = $$a;
            byte b2 = bArr[21];
            byte b3 = (byte) (-bArr[8]);
            Object[] objArr3 = new Object[1];
            s(b2, b3, (byte) (b3 - 2), objArr3);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iArgb, modifierMetaStateMask, iIndexOf, 721586079, false, (String) objArr3[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            int i4 = getARTIFICIAL_FRAME_PACKAGE_NAME + 69;
            artificialFrame = i4 % 128;
            int i5 = i4 % 2;
            long j2 = j + 2023;
            Object[] objArr4 = new Object[1];
            t(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 1, new int[]{-387231065, -857419535, -1927994204, 1801495560, 756591806, 1916204312, 498646961, -872358320, -452620179, 1820650643, 318593834, -289291430}, objArr4);
            Class<?> cls = Class.forName((String) objArr4[0]);
            Object[] objArr5 = new Object[1];
            t(15 - Drawable.resolveOpacity(0, 0), new int[]{-848663477, -1738083905, 2131694592, 371590180, -1122344499, 1258695840, 836544551, -1317060524}, objArr5);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame8 == null) {
                    int iBlue = Color.blue(0) + 25;
                    char cLastIndexOf = (char) (30067 - TextUtils.lastIndexOf("", '0', 0, 0));
                    int i6 = 817 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                    byte b4 = $$a[21];
                    byte b5 = b4;
                    Object[] objArr6 = new Object[1];
                    s(b4, b5, (byte) (b5 - 1), objArr6);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iBlue, cLastIndexOf, i6, 891606461, false, (String) objArr6[0], null);
                }
                Object[] objArr7 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i7 = ((int[]) objArr7[0])[0];
                int i8 = ((int[]) objArr7[1])[0];
                String[] strArr = (String[]) objArr7[2];
                int i9 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().navigationHidden;
                int i10 = (-1053628557) + (((~((-981173757) | i9)) | 707495212 | (~((-783001391) | i9))) * (-754));
                int i11 = ~((-707495213) | i9);
                int i12 = ~i9;
                int i13 = i10 + ((i11 | (~((-75506179) | i12))) * (-754)) + ((i12 | (-981173757)) * 754) + 1023464645;
                int i14 = (i13 << 13) ^ i13;
                int i15 = i14 ^ (i14 >>> 17);
                ((int[]) objArr[3])[0] = i15 ^ (i15 << 5);
                int i16 = getARTIFICIAL_FRAME_PACKAGE_NAME + 1;
                artificialFrame = i16 % 128;
                int i17 = i16 % 2;
            } else {
                Object[] objArr8 = new Object[1];
                t(16 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), new int[]{1681514986, -418354040, -1817702144, 43840913, 262877288, 1551198604, 984797162, 1586664896}, objArr8);
                Class<?> cls2 = Class.forName((String) objArr8[0]);
                Object[] objArr9 = new Object[1];
                t(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(0) - 21, new int[]{-1157055809, 763852358, -511553225, 261450241, -1950949730, -252283174, 1420358305, 1625593276}, objArr9);
                try {
                    Object[] objArr10 = {Integer.valueOf(((Integer) cls2.getMethod((String) objArr9[0], Object.class).invoke(null, this)).intValue()), 0, 1023464645};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame == null) {
                        int maximumDrawingCacheSize = 25 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                        char c = (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 30067);
                        int packedPositionChild = 815 - ExpandableListView.getPackedPositionChild(0L);
                        byte b6 = $$a[21];
                        byte b7 = (byte) (b6 - 1);
                        Object[] objArr11 = new Object[1];
                        s(b7, b7, b6, objArr11);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize, c, packedPositionChild, -797394565, false, (String) objArr11[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr10);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame2 == null) {
                        int packedPositionGroup = ExpandableListView.getPackedPositionGroup(0L) + 25;
                        char bitsPerPixel = (char) (30067 - ImageFormat.getBitsPerPixel(0));
                        int size = 816 - View.MeasureSpec.getSize(0);
                        byte b8 = $$a[21];
                        byte b9 = b8;
                        Object[] objArr12 = new Object[1];
                        s(b8, b9, (byte) (b9 - 1), objArr12);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(packedPositionGroup, bitsPerPixel, size, 891606461, false, (String) objArr12[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArr);
                    try {
                        Object[] objArr13 = new Object[1];
                        t(TextUtils.indexOf("", "") + 22, new int[]{-387231065, -857419535, -1927994204, 1801495560, 756591806, 1916204312, 498646961, -872358320, -452620179, 1820650643, 318593834, -289291430}, objArr13);
                        Class<?> cls3 = Class.forName((String) objArr13[0]);
                        Object[] objArr14 = new Object[1];
                        t(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(6) - 102, new int[]{-848663477, -1738083905, 2131694592, 371590180, -1122344499, 1258695840, 836544551, -1317060524}, objArr14);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr14[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame3 == null) {
                            int i18 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 24;
                            char trimmedLength = (char) (30068 - TextUtils.getTrimmedLength(""));
                            int tapTimeout = 816 - (ViewConfiguration.getTapTimeout() >> 16);
                            byte[] bArr2 = $$a;
                            byte b10 = bArr2[21];
                            byte b11 = (byte) (-bArr2[8]);
                            Object[] objArr15 = new Object[1];
                            s(b10, b11, (byte) (b11 - 2), objArr15);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i18, trimmedLength, tapTimeout, 721586079, false, (String) objArr15[0], null);
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
            Object[] objArr16 = new Object[1];
            t(16 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), new int[]{1681514986, -418354040, -1817702144, 43840913, 262877288, 1551198604, 984797162, 1586664896}, objArr16);
            Class<?> cls4 = Class.forName((String) objArr16[0]);
            Object[] objArr17 = new Object[1];
            t(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(0) - 21, new int[]{-1157055809, 763852358, -511553225, 261450241, -1950949730, -252283174, 1420358305, 1625593276}, objArr17);
            Object[] objArr18 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue()), 0, 1023464645};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame == null) {
                int maximumDrawingCacheSize2 = 25 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                char c2 = (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 30067);
                int packedPositionChild2 = 815 - ExpandableListView.getPackedPositionChild(0L);
                byte b12 = $$a[21];
                byte b13 = (byte) (b12 - 1);
                Object[] objArr19 = new Object[1];
                s(b13, b13, b12, objArr19);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize2, c2, packedPositionChild2, -797394565, false, (String) objArr19[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr18);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame2 == null) {
                int packedPositionGroup2 = ExpandableListView.getPackedPositionGroup(0L) + 25;
                char bitsPerPixel2 = (char) (30067 - ImageFormat.getBitsPerPixel(0));
                int size2 = 816 - View.MeasureSpec.getSize(0);
                byte b14 = $$a[21];
                byte b15 = b14;
                Object[] objArr110 = new Object[1];
                s(b14, b15, (byte) (b15 - 1), objArr110);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(packedPositionGroup2, bitsPerPixel2, size2, 891606461, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArr);
            Object[] objArr111 = new Object[1];
            t(TextUtils.indexOf("", "") + 22, new int[]{-387231065, -857419535, -1927994204, 1801495560, 756591806, 1916204312, 498646961, -872358320, -452620179, 1820650643, 318593834, -289291430}, objArr111);
            Class<?> cls5 = Class.forName((String) objArr111[0]);
            Object[] objArr112 = new Object[1];
            t(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(6) - 102, new int[]{-848663477, -1738083905, 2131694592, 371590180, -1122344499, 1258695840, 836544551, -1317060524}, objArr112);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr112[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame3 == null) {
                int i19 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 24;
                char trimmedLength2 = (char) (30068 - TextUtils.getTrimmedLength(""));
                int tapTimeout2 = 816 - (ViewConfiguration.getTapTimeout() >> 16);
                byte[] bArr3 = $$a;
                byte b16 = bArr3[21];
                byte b17 = (byte) (-bArr3[8]);
                Object[] objArr113 = new Object[1];
                s(b16, b17, (byte) (b17 - 2), objArr113);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i19, trimmedLength2, tapTimeout2, 721586079, false, (String) objArr113[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i20 = ((int[]) objArr[1])[0];
        int i21 = ((int[]) objArr[0])[0];
        if (i21 == i20) {
            Object[] objArr20 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i22 = ((int[]) objArr[3])[0];
            int i23 = ((int[]) objArr[0])[0];
            int i24 = ((int[]) objArr[1])[0];
            String[] strArr2 = (String[]) objArr[2];
            int i25 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().touchscreen;
            int i26 = ~((-1054722) | i25);
            int i27 = i22 + (-1653642943) + ((186648204 | i26) * (-476)) + (i26 * 952) + ((~((~i25) | (-1054722))) * 476);
            int i28 = (i27 << 13) ^ i27;
            int i29 = i28 ^ (i28 >>> 17);
            ((int[]) objArr20[3])[0] = i29 ^ (i29 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr[2];
            if (strArr3 != null) {
                for (String str : strArr3) {
                    arrayList.add(str);
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf((((long) (-1081528938)) << 32) ^ ((long) (i20 ^ i21))), Long.valueOf(-1081528937)};
                byte[] bArr4 = $$g;
                Object[] objArr22 = new Object[1];
                u((byte) ($$h + 4), (byte) 79, bArr4[18], objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                byte b18 = bArr4[18];
                byte b19 = b18;
                Object[] objArr23 = new Object[1];
                u(b18, b19, (byte) (b19 | 81), objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i30 = ((int[]) objArr[3])[0];
                int i31 = ((int[]) objArr[0])[0];
                int i32 = ((int[]) objArr[1])[0];
                String[] strArr4 = (String[]) objArr[2];
                int i33 = ~System.identityHashCode(this);
                int i34 = ~(353944388 | i33);
                int i35 = i30 + 1825195013 + ((i34 | (-155772023)) * 764) + (((~(i33 | (-155772023))) | 17350724) * (-1528)) + (((-475014963) | i34) * 764);
                int i36 = (i35 << 13) ^ i35;
                int i37 = i36 ^ (i36 >>> 17);
                ((int[]) objArr24[3])[0] = i37 ^ (i37 << 5);
                int i38 = artificialFrame + 45;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i38 % 128;
                if (i38 % 2 != 0) {
                    int i39 = 5 % 3;
                }
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame9 == null) {
            int jumpTapTimeout = 26 - (ViewConfiguration.getJumpTapTimeout() >> 16);
            char cGreen = (char) Color.green(0);
            int iIndexOf2 = TextUtils.indexOf("", "") + 1041;
            byte[] bArr5 = $$a;
            byte b20 = bArr5[21];
            byte b21 = (byte) (-bArr5[8]);
            Object[] objArr25 = new Object[1];
            s(b20, b21, (byte) (b21 - 2), objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout, cGreen, iIndexOf2, 2061780482, false, (String) objArr25[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j3 != -1) {
            int i40 = getARTIFICIAL_FRAME_PACKAGE_NAME + 57;
            artificialFrame = i40 % 128;
            int i41 = i40 % 2;
            long j4 = j3 + 4611686018427387787L;
            Object[] objArr26 = new Object[1];
            t(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(6) - 95, new int[]{-387231065, -857419535, -1927994204, 1801495560, 756591806, 1916204312, 498646961, -872358320, -452620179, 1820650643, 318593834, -289291430}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            t((ViewConfiguration.getKeyRepeatDelay() >> 16) + 15, new int[]{-848663477, -1738083905, 2131694592, 371590180, -1122344499, 1258695840, 836544551, -1317060524}, objArr27);
            if (j4 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame10 == null) {
                    int iKeyCodeFromString = KeyEvent.keyCodeFromString("") + 26;
                    char c3 = (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                    int bitsPerPixel3 = ImageFormat.getBitsPerPixel(0) + 1042;
                    byte b22 = $$a[21];
                    byte b23 = b22;
                    Object[] objArr28 = new Object[1];
                    s(b22, b23, (byte) (b23 - 1), objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString, c3, bitsPerPixel3, 1145017376, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr2 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i42 = ((int[]) objArr29[3])[0];
                int i43 = ((int[]) objArr29[2])[0];
                String[] strArr5 = (String[]) objArr29[0];
                int iNextInt = new Random().nextInt();
                int i44 = ~iNextInt;
                int i45 = (-1138234524) + (((~((-184803629) | i44)) | (~(106699821 | iNextInt))) * JfifUtil.MARKER_EOI) + (((~(iNextInt | (-184803629))) | 151249152) * JfifUtil.MARKER_EOI) + (((~(106699821 | i44)) | 184803628) * JfifUtil.MARKER_EOI) + 975422357;
                int i46 = (i45 << 13) ^ i45;
                int i47 = i46 ^ (i46 >>> 17);
                ((int[]) objArr2[1])[0] = i47 ^ (i47 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                t(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 17, new int[]{1681514986, -418354040, -1817702144, 43840913, 262877288, 1551198604, 984797162, 1586664896}, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                t(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(9) - 98, new int[]{-1157055809, 763852358, -511553225, 261450241, -1950949730, -252283174, 1420358305, 1625593276}, objArr31);
                int iIntValue = ((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue();
                Object[] objArr32 = {-2084196039};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(TextUtils.getOffsetBefore("", 0) + 8, (char) (22251 - TextUtils.getOffsetAfter("", 0)), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
                }
                Object[] objArrAccessartificialFrame$78cbbd35 = AnimationUtil.LatLngInterpolator.Linear.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr32), 975422357, false);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame5 == null) {
                    int i48 = 27 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                    char cGreen2 = (char) Color.green(0);
                    int scrollDefaultDelay = 1041 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                    byte b24 = $$a[21];
                    byte b25 = b24;
                    Object[] objArr33 = new Object[1];
                    s(b24, b25, (byte) (b25 - 1), objArr33);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i48, cGreen2, scrollDefaultDelay, 1145017376, false, (String) objArr33[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Object[] objArr34 = new Object[1];
                    t(View.MeasureSpec.makeMeasureSpec(0, 0) + 22, new int[]{-387231065, -857419535, -1927994204, 1801495560, 756591806, 1916204312, 498646961, -872358320, -452620179, 1820650643, 318593834, -289291430}, objArr34);
                    Class<?> cls9 = Class.forName((String) objArr34[0]);
                    Object[] objArr35 = new Object[1];
                    t(16 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), new int[]{-848663477, -1738083905, 2131694592, 371590180, -1122344499, 1258695840, 836544551, -1317060524}, objArr35);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr35[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame6 == null) {
                        int maximumFlingVelocity = 26 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                        char cArgb = (char) Color.argb(0, 0, 0, 0);
                        int scrollBarFadeDuration = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 1041;
                        byte[] bArr6 = $$a;
                        byte b26 = bArr6[21];
                        byte b27 = (byte) (-bArr6[8]);
                        Object[] objArr36 = new Object[1];
                        s(b26, b27, (byte) (b27 - 2), objArr36);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity, cArgb, scrollBarFadeDuration, 2061780482, false, (String) objArr36[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                    objArr2 = objArrAccessartificialFrame$78cbbd35;
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr37 = new Object[1];
            t(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 17, new int[]{1681514986, -418354040, -1817702144, 43840913, 262877288, 1551198604, 984797162, 1586664896}, objArr37);
            Class<?> cls10 = Class.forName((String) objArr37[0]);
            Object[] objArr38 = new Object[1];
            t(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(9) - 98, new int[]{-1157055809, 763852358, -511553225, 261450241, -1950949730, -252283174, 1420358305, 1625593276}, objArr38);
            int iIntValue2 = ((Integer) cls10.getMethod((String) objArr38[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr39 = {-2084196039};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(TextUtils.getOffsetBefore("", 0) + 8, (char) (22251 - TextUtils.getOffsetAfter("", 0)), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            Object[] objArrAccessartificialFrame$78cbbd36 = AnimationUtil.LatLngInterpolator.Linear.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr39), 975422357, false);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame5 == null) {
                int i49 = 27 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                char cGreen3 = (char) Color.green(0);
                int scrollDefaultDelay2 = 1041 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                byte b28 = $$a[21];
                byte b29 = b28;
                Object[] objArr310 = new Object[1];
                s(b28, b29, (byte) (b29 - 1), objArr310);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i49, cGreen3, scrollDefaultDelay2, 1145017376, false, (String) objArr310[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd36);
            Object[] objArr311 = new Object[1];
            t(View.MeasureSpec.makeMeasureSpec(0, 0) + 22, new int[]{-387231065, -857419535, -1927994204, 1801495560, 756591806, 1916204312, 498646961, -872358320, -452620179, 1820650643, 318593834, -289291430}, objArr311);
            Class<?> cls11 = Class.forName((String) objArr311[0]);
            Object[] objArr312 = new Object[1];
            t(16 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), new int[]{-848663477, -1738083905, 2131694592, 371590180, -1122344499, 1258695840, 836544551, -1317060524}, objArr312);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr312[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame6 == null) {
                int maximumFlingVelocity2 = 26 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                char cArgb2 = (char) Color.argb(0, 0, 0, 0);
                int scrollBarFadeDuration2 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 1041;
                byte[] bArr7 = $$a;
                byte b210 = bArr7[21];
                byte b211 = (byte) (-bArr7[8]);
                Object[] objArr313 = new Object[1];
                s(b210, b211, (byte) (b211 - 2), objArr313);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity2, cArgb2, scrollBarFadeDuration2, 2061780482, false, (String) objArr313[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
            objArr2 = objArrAccessartificialFrame$78cbbd36;
        }
        int i50 = ((int[]) objArr2[2])[0];
        int i51 = ((int[]) objArr2[3])[0];
        if (i51 == i50) {
            Object[] objArr40 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i52 = ((int[]) objArr2[1])[0];
            int i53 = ((int[]) objArr2[3])[0];
            int i54 = ((int[]) objArr2[2])[0];
            String[] strArr6 = (String[]) objArr2[0];
            int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) + 1498511087;
            int i55 = ~iCodePointAt;
            int i56 = i52 + (((~(528206639 | i55)) | (~((-90194690) | iCodePointAt))) * 988) + 267024994 + (((~(iCodePointAt | 359908143)) | 168298496 | (~(i55 | (-90194690)))) * 988);
            int i57 = (i56 << 13) ^ i56;
            int i58 = i57 ^ (i57 >>> 17);
            ((int[]) objArr40[1])[0] = i58 ^ (i58 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArr2[0];
        if (strArr7 != null) {
            int i59 = artificialFrame + 99;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i59 % 128;
            int i60 = i59 % 2;
            for (String str2 : strArr7) {
                arrayList2.add(str2);
            }
        }
        Object[] objArr41 = {Long.valueOf(((long) (i50 ^ i51)) ^ (((long) (-1071374090)) << 32)), Long.valueOf(-1071374092)};
        byte[] bArr8 = $$g;
        Object[] objArr42 = new Object[1];
        u((byte) (-bArr8[47]), bArr8[13], (byte) ($$h | 66), objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        byte b30 = bArr8[18];
        byte b31 = b30;
        Object[] objArr43 = new Object[1];
        u(b30, b31, (byte) (b31 | 81), objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {strArr, new int[1], new int[]{i}, new int[]{i}};
        int i61 = ((int[]) objArr2[1])[0];
        int i62 = ((int[]) objArr2[3])[0];
        int i63 = ((int[]) objArr2[2])[0];
        String[] strArr8 = (String[]) objArr2[0];
        int iIdentityHashCode = System.identityHashCode(this);
        int i64 = i61 + (((47713270 + (((~(296225285 | iIdentityHashCode)) | (-374329093)) * (-948))) + ((~((~iIdentityHashCode) | (-105366785))) * (-948))) - 1542807932);
        int i65 = (i64 << 13) ^ i64;
        int i66 = i65 ^ (i65 >>> 17);
        ((int[]) objArr44[1])[0] = i66 ^ (i66 << 5);
    }

    static void accessartificialFrame() {
        ICustomTabsCallbackStub = new int[]{517938439, -1863754704, 2046251594, 242853486, -1073899903, 2054193918, -1389705932, 347254653, 576757085, -67398915, 2140057345, -302099561, 800839085, 2078482506, 937699356, -656984074, -1316168187, -1915905467};
    }
}
