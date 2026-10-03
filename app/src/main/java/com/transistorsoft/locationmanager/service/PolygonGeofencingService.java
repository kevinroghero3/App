package com.transistorsoft.locationmanager.service;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.Nullable;
import ch.qos.logback.core.net.SyslogConstants;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager$$ExternalSyntheticLambda5;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.common.base.Ascii;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.salesforce.marketingcloud.analytics.stats.b;
import com.transistorsoft.locationmanager.adapter.BackgroundGeolocation;
import com.transistorsoft.locationmanager.adapter.TSConfig;
import com.transistorsoft.locationmanager.data.sqlite.GeofenceDAO;
import com.transistorsoft.locationmanager.data.sqlite.SQLiteLocationDAO;
import com.transistorsoft.locationmanager.event.GeofenceEvent;
import com.transistorsoft.locationmanager.event.PersistEvent;
import com.transistorsoft.locationmanager.geofence.TSGeofence;
import com.transistorsoft.locationmanager.geofence.TSGeofenceManager;
import com.transistorsoft.locationmanager.http.HttpService;
import com.transistorsoft.locationmanager.location.TSLocation;
import com.transistorsoft.locationmanager.location.TSLocationManager;
import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.locationmanager.logger.TSMediaPlayer;
import com.transistorsoft.locationmanager.plugin.TSPlugin;
import com.transistorsoft.locationmanager.util.LocationAuthorization;
import com.transistorsoft.locationmanager.util.Util;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.io.encoding.Base64;
import net.pluservice.unicoc.R;
import o.ArtificialStackFrames;
import o.onMessageChannelReady;
import okio.Utf8;
import org.greenrobot.eventbus.EventBus;
import org.slf4j.Logger;

/* JADX INFO: loaded from: classes.dex */
public class PolygonGeofencingService extends AbstractService {
    private static final String t = "stopMonitoringPolygons";
    private final AtomicBoolean q = new AtomicBoolean(false);
    private final AtomicInteger r = new AtomicInteger(0);
    private StopTimeoutEvaluator s;
    private static final byte[] $$c = {Utf8.REPLACEMENT_BYTE, -116, -22, -37};
    private static final int $$f = 123;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$g = {96, -63, 33, 4, -20, -6, 55, -64, -3, -10, -10, -5, -21, -8, -4, 53, -67, -12, 4, -14, -6, -19, -1, -15, 3, -15, -5, -13, 1, 47, -61, -20, -11, 5, 47, -42, -42, -5, 3, -25, 10, -10, -21, Ascii.ETB, -26, -20, -12, 8, -17, 3, -10, Ascii.ETB, -35, -10, -25, -3, -11, -15, 77, -39, -52, -6, -11, 7, -21, -3, -14, -7, -8, -69, -13, 50, -75, -6, -12, Base64.padSymbol, -70, -11, 0, -3, -7, -10, -16, 53, -61, -20, -11, 5, 47, -77, -5, -1, 51, -29, -62, Ascii.SO, -17, -5, -2, Ascii.EM, -59, 7, -8, -7, -21, Ascii.SYN, -38, 9, -10, -16, -2, -21};
    private static final int $$h = 161;
    private static final byte[] $$a = {Ascii.SYN, -120, 37, 108, 5, -1, -33, 33, -2, -9, 5, -7, 5, -1, -50, 39, Ascii.VT, -7, -12, Ascii.SI, Ascii.ESC, 1, -7, -6, -33, 51, -12, 3, -8, 1, Ascii.CR};
    private static final int $$b = 153;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] validateRelationship = {56002, 55869, 56007, 55857, 55868, 55866, 56061, 55856, 56016, 55850, 55863, 56006, 55870, 56032, 55871, 56000, 55864, 55859, 56017, 55865, 55861, 56004, 56027, 55867};
    private static int warmup = -1044260189;
    private static boolean requestPostMessageChannelWithExtras = true;
    private static boolean ICustomTabsServiceDefault = true;

    /* JADX INFO: loaded from: classes3.dex */
    class a implements Runnable {
        private final Intent a;
        private final int b;

        a(Intent intent, int i) {
            this.a = intent;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            String action = this.a.getAction();
            if (action != null) {
                if (action.equalsIgnoreCase("start")) {
                    if (PolygonGeofencingService.this.q.compareAndSet(false, true)) {
                        PolygonGeofencingService.e(PolygonGeofencingService.this.getApplicationContext());
                    }
                } else if (action.equalsIgnoreCase("stop")) {
                    if (PolygonGeofencingService.this.q.compareAndSet(true, false)) {
                        PolygonGeofencingService.f(PolygonGeofencingService.this.getApplicationContext());
                    }
                    PolygonGeofencingService.this.a(false);
                    return;
                }
            }
            if (LocationResult.hasResult(this.a)) {
                PolygonGeofencingService.this.c(this.a);
                TSGeofenceManager tSGeofenceManager = TSGeofenceManager.getInstance(PolygonGeofencingService.this.getApplicationContext());
                TSConfig tSConfig = TSConfig.getInstance(PolygonGeofencingService.this.getApplicationContext());
                boolean z = LocationAuthorization.hasActivityPermission(PolygonGeofencingService.this.getApplicationContext()) && !tSConfig.getDisableMotionActivityUpdates().booleanValue();
                boolean zIsEmpty = StateChange.isEmpty();
                boolean zIsLoitering = LoiteringEvent.isLoitering();
                if ((!tSGeofenceManager.isMonitoringPolygons() || (z && !tSConfig.getIsMoving().booleanValue() && zIsEmpty && !zIsLoitering)) && PolygonGeofencingService.this.q.compareAndSet(true, false)) {
                    PolygonGeofencingService.f(PolygonGeofencingService.this.getApplicationContext());
                }
                if (!tSGeofenceManager.isMonitoringPolygons() && PolygonGeofencingService.this.q.compareAndSet(true, false)) {
                    PolygonGeofencingService.f(PolygonGeofencingService.this.getApplicationContext());
                }
                PolygonGeofencingService polygonGeofencingService = PolygonGeofencingService.this;
                polygonGeofencingService.a(polygonGeofencingService.q.get());
            } else if (LocationAvailability.hasLocationAvailability(this.a)) {
                PolygonGeofencingService.this.b(this.a);
            }
            PolygonGeofencingService.this.a(this.b);
        }
    }

    private static String $$i(int i, byte b, int i2) {
        int i3 = i2 * 3;
        int i4 = 121 - i;
        byte[] bArr = $$c;
        int i5 = 4 - (b * 4);
        byte[] bArr2 = new byte[1 - i3];
        int i6 = 0 - i3;
        int i7 = -1;
        if (bArr == null) {
            i4 = (-i4) + i6;
            i5++;
            i7 = -1;
        }
        while (true) {
            int i8 = i7 + 1;
            bArr2[i8] = (byte) i4;
            if (i8 == i6) {
                return new String(bArr2, 0);
            }
            i4 = (-bArr[i5]) + i4;
            i5++;
            i7 = i8;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(Context context) {
        TSLog.logger.debug(TSLog.calendar("Halting polygon monitoring after timeout"));
        f(context);
        stopSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(Context context) {
        TSLog.logger.debug(TSLog.on("startUpdatingLocation"));
        try {
            LocationServices.getFusedLocationProviderClient(context).requestLocationUpdates(LocationRequest.create().setPriority(100).setInterval(0L).setFastestInterval(0L).setSmallestDisplacement(0.0f), getPendingIntent(context));
        } catch (SecurityException e) {
            TSLog.logger.error(TSLog.error("SecurityException while attempting to fetch location: " + e.getMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(Context context) {
        TSLog.logger.debug(TSLog.off("stopUpdatingLocation"));
        LocationServices.getFusedLocationProviderClient(context).removeLocationUpdates(getPendingIntent(context));
    }

    public static PendingIntent getPendingIntent(Context context) {
        return getPendingIntent(context, null);
    }

    public static void handleGeofencingEvent(final Context context, String str, Location location, int i) {
        String str2;
        String str3;
        LoiteringEvent loiteringEventA;
        TSGeofence tSGeofenceFind = GeofenceDAO.getInstance(context).find(str);
        if (tSGeofenceFind == null) {
            TSLog.logger.error("Failed to find geofence record in database: " + str);
            return;
        }
        if (i == 1) {
            if (tSGeofenceFind.getNotifyOnDwell()) {
                StateChange.a(str, location, 1);
                LoiteringEvent.a(new LoiteringEvent(tSGeofenceFind, new LoiteringEvent.a() { // from class: com.transistorsoft.locationmanager.service.PolygonGeofencingService$$ExternalSyntheticLambda2
                    @Override // com.transistorsoft.locationmanager.service.PolygonGeofencingService.LoiteringEvent.a
                    public final void a(TSGeofence tSGeofence) {
                        PolygonGeofencingService.a(context, tSGeofence);
                    }
                }));
            }
            str3 = "tslocationmanager_beep_trip_up_dry";
            str2 = "ENTER";
        } else if (i == 2) {
            if (tSGeofenceFind.getNotifyOnDwell() && (loiteringEventA = LoiteringEvent.a(str)) != null) {
                loiteringEventA.a();
                LoiteringEvent.b(str);
            }
            str3 = "tslocationmanager_beep_trip_dry";
            str2 = "EXIT";
        } else if (i == 4) {
            LoiteringEvent.b(str);
            StateChange.remove(str);
            str3 = "tslocationmanager_beep_trip_up_echo";
            str2 = "DWELL";
        } else {
            str2 = "UNKNOWN";
            str3 = "";
        }
        TSMediaPlayer.getInstance().debug(context, str3);
        StringBuilder sb = new StringBuilder();
        sb.append(TSLog.header("Geofencing Event: " + str2));
        sb.append(TSLog.boxRow(str));
        sb.append(TSLog.BOX_BOTTOM);
        TSLog.logger.info(sb.toString());
        if (location == null) {
            TSLog.logger.error(TSLog.warn("Failed to receive location during Polygon geofence event."));
            return;
        }
        TSLocation.applyExtras(context, location);
        TSConfig tSConfig = TSConfig.getInstance(context);
        TSGeofenceManager.getInstance(context).setLocation(location, tSConfig.getIsMoving().booleanValue());
        TSLocationManager tSLocationManager = TSLocationManager.getInstance(context);
        Bundle extras = location.getExtras();
        extras.putBoolean("isMoving", tSConfig.getIsMoving().booleanValue());
        extras.putFloat(TSLocation.LOCATION_OPTIONS_ODOMETER, tSConfig.getOdometer().floatValue());
        EventBus.getDefault().post(new TSLocation(context, location, ActivityRecognitionService.getMostProbableActivity(), tSLocationManager.getCurrentLocationProvider()));
        GeofenceEvent geofenceEvent = new GeofenceEvent(i, tSGeofenceFind, new TSLocation(context, location, ActivityRecognitionService.getMostProbableActivity()));
        if (tSConfig.getMaxRecordsToPersist().intValue() != 0) {
            a(context, geofenceEvent.getLocation());
        }
        EventBus.getDefault().post(geofenceEvent);
    }

    public static void startMonitoring(Context context) {
        Intent intent = new Intent(context, (Class<?>) PolygonGeofencingService.class);
        intent.setAction("start");
        AbstractService.startForegroundService(context, intent);
    }

    public static void stop(Context context) {
        f(context);
        StateChange.a();
        stopService(context);
    }

    private static void stopService(Context context) {
        AbstractService.stop(context, PolygonGeofencingService.class);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void u(short r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 28
            int r6 = 112 - r6
            int r8 = r8 * 8
            int r8 = 20 - r8
            byte[] r0 = com.transistorsoft.locationmanager.service.PolygonGeofencingService.$$a
            int r7 = r7 * 3
            int r1 = r7 + 9
            byte[] r1 = new byte[r1]
            int r7 = r7 + 8
            r2 = 0
            if (r0 != 0) goto L19
            r6 = r7
            r3 = r8
            r4 = r2
            goto L2f
        L19:
            r3 = r2
        L1a:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r7) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            r4 = r0[r8]
            int r3 = r3 + 1
            r5 = r3
            r3 = r8
            r8 = r4
            r4 = r5
        L2f:
            int r6 = r6 + r8
            int r8 = r3 + 1
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.service.PolygonGeofencingService.u(short, byte, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void w(int r7, int r8, short r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 63
            int r8 = 99 - r8
            int r7 = r7 * 2
            int r7 = r7 + 3
            int r9 = r9 * 2
            int r9 = r9 + 4
            byte[] r0 = com.transistorsoft.locationmanager.service.PolygonGeofencingService.$$g
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r9
            r4 = r2
            r9 = r7
            goto L2d
        L17:
            r3 = r2
        L18:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r7) goto L27
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L27:
            r3 = r0[r9]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r6
        L2d:
            int r3 = r3 + 1
            int r8 = -r8
            int r9 = r9 + r8
            int r8 = r9 + (-8)
            r9 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.service.PolygonGeofencingService.w(int, int, short, java.lang.Object[]):void");
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
        this.s = new StopTimeoutEvaluator(1200000, new StopTimeoutEvaluator.a() { // from class: com.transistorsoft.locationmanager.service.PolygonGeofencingService$$ExternalSyntheticLambda0
            @Override // com.transistorsoft.locationmanager.service.StopTimeoutEvaluator.a
            public final void a() {
                this.f$0.d(applicationContext);
            }
        });
    }

    @Override // com.transistorsoft.locationmanager.service.AbstractService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.s.a();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        boolean zA = a(intent, i2, false);
        if (!zA) {
            LoiteringEvent.d();
        }
        BackgroundGeolocation.getThreadPool().execute(new a(intent, i2));
        return zA ? 3 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:36:0x0102 A[PHI: r4
  0x0102: PHI (r4v11 float) = (r4v10 float), (r4v18 float) binds: [B:32:0x00f5, B:34:0x00fe] A[DONT_GENERATE, DONT_INLINE]] */
    public void c(Intent intent) {
        float f;
        LocationResult locationResultExtractResult = LocationResult.extractResult(intent);
        if (locationResultExtractResult == null) {
            TSLog.logger.warn(TSLog.warn("handleLocationResult received a null LocationResult"));
            return;
        }
        Location lastLocation = locationResultExtractResult.getLastLocation();
        this.r.incrementAndGet();
        TSConfig tSConfig = TSConfig.getInstance(getApplicationContext());
        if (!LocationAuthorization.hasActivityPermission(getApplicationContext()) || tSConfig.getDisableMotionActivityUpdates().booleanValue()) {
            if (lastLocation.hasSpeed()) {
                if (this.s.a(lastLocation) >= 1.4d) {
                    this.s.a();
                } else if (!this.s.b()) {
                    this.s.d();
                }
            } else if (!this.s.b()) {
                this.s.d();
            }
        }
        TSGeofenceManager tSGeofenceManager = TSGeofenceManager.getInstance(getApplicationContext());
        for (Location location : locationResultExtractResult.getLocations()) {
            Logger logger = TSLog.logger;
            StringBuilder sb = new StringBuilder();
            sb.append("isInPolygon: 📍  ");
            sb.append(location.getLatitude());
            sb.append(", ");
            sb.append(location.getLongitude());
            sb.append(", acy: ");
            sb.append(location.getAccuracy());
            sb.append("m, spd: ");
            sb.append(location.hasSpeed() ? Float.valueOf(location.getSpeed()) : "-1");
            logger.debug(TSLog.header(sb.toString()));
            for (String str : tSGeofenceManager.getMonitoredPolygonIdentifiers()) {
                boolean polygonState = tSGeofenceManager.getPolygonState(str);
                float accuracy = location.getAccuracy();
                if (polygonState) {
                    accuracy += 2.0f;
                    if (accuracy > 50.0f) {
                        f = 50.0f;
                    } else {
                        f = accuracy;
                    }
                } else {
                    f = accuracy;
                }
                TSGeofence.LocationInPolygonResult locationInPolygonResultIsLocationInPolygon = TSGeofence.isLocationInPolygon(str, location.getLatitude(), location.getLongitude(), f);
                float f2 = locationInPolygonResultIsLocationInPolygon.confidence;
                boolean z = false;
                boolean z2 = f2 == 0.0f && !locationInPolygonResultIsLocationInPolygon.centerIsInPolygon;
                if (f2 >= 0.4f && locationInPolygonResultIsLocationInPolygon.centerIsInPolygon) {
                    z = true;
                }
                if (!(polygonState && z2) && (polygonState || !z)) {
                    StateChange.remove(str);
                } else {
                    StateChange stateChangeA = StateChange.a(str, location, 3);
                    stateChangeA.d();
                    if (stateChangeA.b()) {
                        StateChange.remove(str);
                        tSGeofenceManager.setPolygonState(str, !polygonState);
                        handleGeofencingEvent(getApplicationContext(), str, stateChangeA.location, polygonState ? 2 : 1);
                    }
                }
            }
        }
    }

    public static PendingIntent getPendingIntent(Context context, @Nullable String str) {
        Intent intent = new Intent(context, (Class<?>) PolygonGeofencingService.class);
        if (str != null) {
            intent.setAction(str);
        }
        return Build.VERSION.SDK_INT >= 26 ? PendingIntent.getForegroundService(context, 0, intent, Util.getPendingIntentFlags(134217728)) : PendingIntent.getService(context, 0, intent, 134217728);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(final Context context, final TSGeofence tSGeofence) {
        LocationServices.getFusedLocationProviderClient(context).getLastLocation().addOnSuccessListener(new OnSuccessListener() { // from class: com.transistorsoft.locationmanager.service.PolygonGeofencingService$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                PolygonGeofencingService.b(context, tSGeofence, (Location) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(final Context context, final TSGeofence tSGeofence, final Location location) {
        BackgroundGeolocation.getThreadPool().execute(new Runnable() { // from class: com.transistorsoft.locationmanager.service.PolygonGeofencingService$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                PolygonGeofencingService.a(context, tSGeofence, location);
            }
        });
    }

    public static class LoiteringEvent implements Runnable {
        private static final Handler c = new Handler(Looper.getMainLooper());
        private static final Map<String, LoiteringEvent> d = new HashMap();
        private final TSGeofence a;
        private final a b;

        /* JADX INFO: loaded from: classes3.dex */
        interface a {
            void a(TSGeofence tSGeofence);
        }

        LoiteringEvent(TSGeofence tSGeofence, a aVar) {
            this.a = tSGeofence;
            this.b = aVar;
            c.postDelayed(this, tSGeofence.getLoiteringDelay());
        }

        static void a(LoiteringEvent loiteringEvent) {
            Map<String, LoiteringEvent> map = d;
            synchronized (map) {
                map.put(loiteringEvent.b().getIdentifier(), loiteringEvent);
            }
        }

        static LoiteringEvent b(String str) {
            LoiteringEvent loiteringEvent;
            Map<String, LoiteringEvent> map = d;
            synchronized (map) {
                loiteringEvent = map.get(str);
                map.remove(str);
            }
            return loiteringEvent;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            this.b.a(this.a);
        }

        static void d() {
            Map<String, LoiteringEvent> map = d;
            synchronized (map) {
                Iterator<Map.Entry<String, LoiteringEvent>> it2 = map.entrySet().iterator();
                while (it2.hasNext()) {
                    it2.next().getValue().a();
                    it2.remove();
                }
            }
        }

        public static boolean isLoitering() {
            return !d.isEmpty();
        }

        @Override // java.lang.Runnable
        public void run() {
            BackgroundGeolocation.getThreadPool().execute(new Runnable() { // from class: com.transistorsoft.locationmanager.service.PolygonGeofencingService$LoiteringEvent$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.c();
                }
            });
            c.removeCallbacks(this);
        }

        static LoiteringEvent a(String str) {
            LoiteringEvent loiteringEvent;
            Map<String, LoiteringEvent> map = d;
            synchronized (map) {
                loiteringEvent = map.get(str);
            }
            return loiteringEvent;
        }

        TSGeofence b() {
            return this.a;
        }

        void a() {
            c.removeCallbacks(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Intent intent) {
        LocationAvailability locationAvailabilityExtractLocationAvailability = LocationAvailability.extractLocationAvailability(intent);
        TSLog.logger.info(TSLog.info("Location availability: " + locationAvailabilityExtractLocationAvailability.isLocationAvailable()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Context context, TSGeofence tSGeofence, Location location) {
        handleGeofencingEvent(context, tSGeofence.getIdentifier(), location, 4);
    }

    private static void a(Context context, TSLocation tSLocation) {
        TSConfig tSConfig = TSConfig.getInstance(context);
        if (tSConfig.shouldPersist(tSLocation)) {
            if (EventBus.getDefault().hasSubscriberForEvent(PersistEvent.class)) {
                if (TSPlugin.getInstance().canUsePersistEvent(context)) {
                    EventBus.getDefault().post(new PersistEvent(context, tSLocation, tSConfig.getParams()));
                    return;
                } else {
                    TSLog.logger.warn(TSLog.warn("Failed to persist location"));
                    return;
                }
            }
            if (tSConfig.getMaxDaysToPersist().intValue() == 0 || !tSConfig.getPersist().booleanValue()) {
                return;
            }
            if (SQLiteLocationDAO.getInstance(context).persist(tSLocation)) {
                if (tSConfig.getAutoSync().booleanValue() && tSConfig.hasUrl()) {
                    HttpService.getInstance(context).flush(true);
                    return;
                }
                return;
            }
            TSLog.logger.error(TSLog.error("INSERT FAILURE" + tSLocation));
        }
    }

    public static class StateChange {
        private static final HashMap<String, StateChange> c = new HashMap<>();
        private int a;
        private int b;
        public final String identifier;
        public final Location location;

        StateChange(String str, Location location, int i) {
            this.identifier = str;
            this.location = location;
            this.b = i;
        }

        static StateChange a(String str, Location location, int i) {
            StateChange stateChange;
            HashMap<String, StateChange> map = c;
            synchronized (map) {
                stateChange = map.get(str);
            }
            if (stateChange != null) {
                return stateChange;
            }
            StateChange stateChange2 = new StateChange(str, location, i);
            synchronized (map) {
                map.put(str, stateChange2);
            }
            return stateChange2;
        }

        public static StateChange findByIdentifier(String str) {
            StateChange stateChange;
            HashMap<String, StateChange> map = c;
            synchronized (map) {
                stateChange = map.get(str);
            }
            return stateChange;
        }

        public static boolean isEmpty() {
            boolean zIsEmpty;
            HashMap<String, StateChange> map = c;
            synchronized (map) {
                zIsEmpty = map.isEmpty();
            }
            return zIsEmpty;
        }

        public static void remove(String str) {
            HashMap<String, StateChange> map = c;
            synchronized (map) {
                map.remove(str);
            }
        }

        boolean b() {
            return this.a >= this.b;
        }

        int c() {
            return this.a;
        }

        void d() {
            this.a++;
        }

        public String toString() {
            return "[StateChange identifier: " + this.identifier + ", score: " + this.a + RemoteSettings.FORWARD_SLASH_STRING + this.b + ", location: " + this.location + "]";
        }

        static void a() {
            HashMap<String, StateChange> map = c;
            synchronized (map) {
                map.clear();
            }
        }
    }

    private static void v(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        onMessageChannelReady onmessagechannelready = new onMessageChannelReady();
        char[] cArr2 = validateRelationship;
        int i3 = 1;
        int i4 = 0;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i5 = 0;
            while (i5 < length) {
                try {
                    Object[] objArr2 = new Object[i3];
                    objArr2[i4] = Integer.valueOf(cArr2[i5]);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(115862995);
                    if (objAccessartificialFrame == null) {
                        int maximumDrawingCacheSize = 26 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                        char cAxisFromString = (char) (MotionEvent.axisFromString("") + i3);
                        int iCombineMeasuredStates = 1041 - View.combineMeasuredStates(i4, i4);
                        byte b = (byte) i4;
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize, cAxisFromString, iCombineMeasuredStates, -1719489573, false, $$i(b, b2, b2), new Class[]{Integer.TYPE});
                    }
                    cArr3[i5] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i5++;
                    i3 = 1;
                    i4 = 0;
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
            byte b3 = (byte) 0;
            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", "", 0, 0) + 15, (char) (Color.green(0) + 20488), (Process.myPid() >> 22) + 2148, 216472770, false, $$i((byte) 54, b3, b3), new Class[]{Integer.TYPE});
        }
        int iIntValue = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
        int i6 = 59174;
        int i7 = 55;
        if (!(!ICustomTabsServiceDefault)) {
            onmessagechannelready.c = bArr.length;
            char[] cArr4 = new char[onmessagechannelready.c];
            onmessagechannelready.a = 0;
            while (onmessagechannelready.a < onmessagechannelready.c) {
                int i8 = $11 + 85;
                $10 = i8 % 128;
                if (i8 % 2 != 0) {
                    cArr4[onmessagechannelready.a] = (char) (cArr2[bArr[onmessagechannelready.c << onmessagechannelready.a] >> i] >> iIntValue);
                    Object[] objArr4 = {onmessagechannelready, onmessagechannelready};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                    if (objAccessartificialFrame3 == null) {
                        byte b4 = (byte) 0;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(21 - TextUtils.getOffsetAfter("", 0), (char) (i6 - (ViewConfiguration.getScrollDefaultDelay() >> 16)), 1943 - View.MeasureSpec.getSize(0), 481771537, false, $$i((byte) i7, b4, b4), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                } else {
                    cArr4[onmessagechannelready.a] = (char) (cArr2[bArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] + i] - iIntValue);
                    Object[] objArr5 = {onmessagechannelready, onmessagechannelready};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                    if (objAccessartificialFrame4 == null) {
                        byte b5 = (byte) 0;
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(21 - TextUtils.indexOf("", "", 0), (char) (59175 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 1943, 481771537, false, $$i((byte) 55, b5, b5), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                }
                i6 = 59174;
                i7 = 55;
            }
            String str = new String(cArr4);
            int i9 = $11 + 71;
            $10 = i9 % 128;
            int i10 = i9 % 2;
            objArr[0] = str;
            return;
        }
        if (requestPostMessageChannelWithExtras) {
            onmessagechannelready.c = cArr.length;
            char[] cArr5 = new char[onmessagechannelready.c];
            onmessagechannelready.a = 0;
            while (onmessagechannelready.a < onmessagechannelready.c) {
                cArr5[onmessagechannelready.a] = (char) (cArr2[cArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                Object[] objArr6 = {onmessagechannelready, onmessagechannelready};
                Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                if (objAccessartificialFrame5 == null) {
                    byte b6 = (byte) 0;
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 20, (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 59174), 1943 - (ViewConfiguration.getLongPressTimeout() >> 16), 481771537, false, $$i((byte) 55, b6, b6), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame5).invoke(null, objArr6);
            }
            objArr[0] = new String(cArr5);
            return;
        }
        int i11 = 0;
        onmessagechannelready.c = iArr.length;
        char[] cArr6 = new char[onmessagechannelready.c];
        while (true) {
            onmessagechannelready.a = i11;
            if (onmessagechannelready.a >= onmessagechannelready.c) {
                objArr[0] = new String(cArr6);
                return;
            } else {
                cArr6[onmessagechannelready.a] = (char) (cArr2[iArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                i11 = onmessagechannelready.a + 1;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x01df  */
    /* JADX WARN: Code duplicated, block: B:23:0x0283 A[Catch: all -> 0x0a5d, TryCatch #2 {all -> 0x0a5d, blocks: (B:58:0x075a, B:60:0x076e, B:61:0x07a5, B:21:0x0263, B:23:0x0283, B:24:0x02ce), top: B:102:0x0263 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:32:0x038b  */
    /* JADX WARN: Code duplicated, block: B:57:0x06d2  */
    /* JADX WARN: Code duplicated, block: B:60:0x076e A[Catch: all -> 0x0a5d, TryCatch #2 {all -> 0x0a5d, blocks: (B:58:0x075a, B:60:0x076e, B:61:0x07a5, B:21:0x0263, B:23:0x0283, B:24:0x02ce), top: B:102:0x0263 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x07bb  */
    /* JADX WARN: Code duplicated, block: B:69:0x0894  */
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
        int i2 = artificialFrame + 25;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        if (i2 % 2 != 0) {
            super.attachBaseContext(context);
            Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame7 == null) {
                int mode = View.MeasureSpec.getMode(0) + 25;
                char defaultSize = (char) (View.getDefaultSize(0, 0) + 30068);
                int doubleTapTimeout = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 816;
                byte[] bArr = $$a;
                byte b = (byte) (bArr[21] - 1);
                Object[] objArr3 = new Object[1];
                u(b, b, (byte) (-bArr[8]), objArr3);
                objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(mode, defaultSize, doubleTapTimeout, 721586079, false, (String) objArr3[0], null);
            }
            ((Field) objAccessartificialFrame7).getLong(null);
            throw null;
        }
        super.attachBaseContext(context);
        Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame8 == null) {
            int bitsPerPixel = ImageFormat.getBitsPerPixel(0) + 26;
            char cArgb = (char) (Color.argb(0, 0, 0, 0) + 30068);
            int i3 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 816;
            byte[] bArr2 = $$a;
            byte b2 = (byte) (bArr2[21] - 1);
            Object[] objArr4 = new Object[1];
            u(b2, b2, (byte) (-bArr2[8]), objArr4);
            objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(bitsPerPixel, cArgb, i3, 721586079, false, (String) objArr4[0], null);
        }
        long j = ((Field) objAccessartificialFrame8).getLong(null);
        if (j != -1) {
            long j2 = j + 1875;
            Object[] objArr5 = new Object[1];
            v(127 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr5);
            Class<?> cls = Class.forName((String) objArr5[0]);
            Object[] objArr6 = new Object[1];
            v(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) + 78, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, null, null, objArr6);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame9 == null) {
                    int windowTouchSlop = (ViewConfiguration.getWindowTouchSlop() >> 8) + 25;
                    char cIndexOf = (char) (TextUtils.indexOf("", "", 0) + 30068);
                    int i4 = 817 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                    byte b3 = $$a[21];
                    byte b4 = (byte) (b3 - 1);
                    Object[] objArr7 = new Object[1];
                    u(b4, b4, b3, objArr7);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(windowTouchSlop, cIndexOf, i4, 891606461, false, (String) objArr7[0], null);
                }
                Object[] objArr8 = (Object[]) ((Field) objAccessartificialFrame9).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i5 = ((int[]) objArr8[0])[0];
                int i6 = ((int[]) objArr8[1])[0];
                String[] strArr = (String[]) objArr8[2];
                int i7 = ~((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenWidthDp;
                int i8 = 1237348365 + (((~(i7 | 466429630)) | 70271296) * (-160)) + (((~(i7 | 268257264)) | 466429630) * SyslogConstants.LOG_LOCAL4) + 28718933;
                int i9 = (i8 << 13) ^ i8;
                int i10 = i9 ^ (i9 >>> 17);
                ((int[]) objArr[3])[0] = i10 ^ (i10 << 5);
            } else {
                Object[] objArr9 = new Object[1];
                v(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 92, new byte[]{-115, -116, -117, -120, -118, -119, -121, -106, -126, -127, -113, -121, -127, -107, -127, -108}, null, null, objArr9);
                Class<?> cls2 = Class.forName((String) objArr9[0]);
                Object[] objArr10 = new Object[1];
                v(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 123, new byte[]{-116, -125, -123, -114, -104, -120, -127, -105, -118, -117, -122, -117, -126, -116, -125, -122}, null, null, objArr10);
                try {
                    Object[] objArr11 = {Integer.valueOf(((Integer) cls2.getMethod((String) objArr10[0], Object.class).invoke(null, this)).intValue()), 0, 28718933};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame == null) {
                        int capsMode = TextUtils.getCapsMode("", 0, 0) + 25;
                        char offsetBefore = (char) (30068 - TextUtils.getOffsetBefore("", 0));
                        int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 816;
                        byte b5 = $$a[21];
                        byte b6 = b5;
                        Object[] objArr12 = new Object[1];
                        u(b5, b6, (byte) (b6 - 1), objArr12);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(capsMode, offsetBefore, keyRepeatDelay, -797394565, false, (String) objArr12[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr11);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame2 == null) {
                        int windowTouchSlop2 = 25 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                        char maxKeyCode = (char) (30068 - (KeyEvent.getMaxKeyCode() >> 16));
                        int iMyPid = (Process.myPid() >> 22) + 816;
                        byte b7 = $$a[21];
                        byte b8 = (byte) (b7 - 1);
                        Object[] objArr13 = new Object[1];
                        u(b8, b8, b7, objArr13);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(windowTouchSlop2, maxKeyCode, iMyPid, 891606461, false, (String) objArr13[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArr);
                    try {
                        Object[] objArr14 = new Object[1];
                        v(Process.getGidForName("") + 128, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr14);
                        Class<?> cls3 = Class.forName((String) objArr14[0]);
                        Object[] objArr15 = new Object[1];
                        v(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 92, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, null, null, objArr15);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr15[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame3 == null) {
                            int threadPriority = 25 - ((Process.getThreadPriority(0) + 20) >> 6);
                            char pressedStateDuration = (char) (30068 - (ViewConfiguration.getPressedStateDuration() >> 16));
                            int windowTouchSlop3 = 816 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                            byte[] bArr3 = $$a;
                            byte b9 = (byte) (bArr3[21] - 1);
                            Object[] objArr16 = new Object[1];
                            u(b9, b9, (byte) (-bArr3[8]), objArr16);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(threadPriority, pressedStateDuration, windowTouchSlop3, 721586079, false, (String) objArr16[0], null);
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
            Object[] objArr17 = new Object[1];
            v(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 92, new byte[]{-115, -116, -117, -120, -118, -119, -121, -106, -126, -127, -113, -121, -127, -107, -127, -108}, null, null, objArr17);
            Class<?> cls4 = Class.forName((String) objArr17[0]);
            Object[] objArr18 = new Object[1];
            v(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 123, new byte[]{-116, -125, -123, -114, -104, -120, -127, -105, -118, -117, -122, -117, -126, -116, -125, -122}, null, null, objArr18);
            Object[] objArr19 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr18[0], Object.class).invoke(null, this)).intValue()), 0, 28718933};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame == null) {
                int capsMode2 = TextUtils.getCapsMode("", 0, 0) + 25;
                char offsetBefore2 = (char) (30068 - TextUtils.getOffsetBefore("", 0));
                int keyRepeatDelay2 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 816;
                byte b10 = $$a[21];
                byte b11 = b10;
                Object[] objArr110 = new Object[1];
                u(b10, b11, (byte) (b11 - 1), objArr110);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(capsMode2, offsetBefore2, keyRepeatDelay2, -797394565, false, (String) objArr110[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr19);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame2 == null) {
                int windowTouchSlop4 = 25 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                char maxKeyCode2 = (char) (30068 - (KeyEvent.getMaxKeyCode() >> 16));
                int iMyPid2 = (Process.myPid() >> 22) + 816;
                byte b12 = $$a[21];
                byte b13 = (byte) (b12 - 1);
                Object[] objArr111 = new Object[1];
                u(b13, b13, b12, objArr111);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(windowTouchSlop4, maxKeyCode2, iMyPid2, 891606461, false, (String) objArr111[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArr);
            Object[] objArr112 = new Object[1];
            v(Process.getGidForName("") + 128, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr112);
            Class<?> cls5 = Class.forName((String) objArr112[0]);
            Object[] objArr113 = new Object[1];
            v(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 92, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, null, null, objArr113);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr113[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame3 == null) {
                int threadPriority2 = 25 - ((Process.getThreadPriority(0) + 20) >> 6);
                char pressedStateDuration2 = (char) (30068 - (ViewConfiguration.getPressedStateDuration() >> 16));
                int windowTouchSlop5 = 816 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                byte[] bArr4 = $$a;
                byte b14 = (byte) (bArr4[21] - 1);
                Object[] objArr114 = new Object[1];
                u(b14, b14, (byte) (-bArr4[8]), objArr114);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(threadPriority2, pressedStateDuration2, windowTouchSlop5, 721586079, false, (String) objArr114[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i11 = ((int[]) objArr[1])[0];
        int i12 = ((int[]) objArr[0])[0];
        if (i12 == i11) {
            Object[] objArr20 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i13 = ((int[]) objArr[3])[0];
            int i14 = ((int[]) objArr[0])[0];
            int i15 = ((int[]) objArr[1])[0];
            String[] strArr2 = (String[]) objArr[2];
            int i16 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenLayout;
            int i17 = ~i16;
            int i18 = (-1892990091) + (((~((-207627025) | i17)) | (~((-311772399) | i16))) * 520);
            int i19 = ~(311772398 | i17);
            int i20 = ~(i16 | 509944764);
            int i21 = i13 + i18 + ((i19 | i20) * (-1040)) + ((i20 | (~(i17 | (-509944765))) | (-519399423)) * 520);
            int i22 = (i21 << 13) ^ i21;
            int i23 = i22 ^ (i22 >>> 17);
            ((int[]) objArr20[3])[0] = i23 ^ (i23 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr[2];
            if (strArr3 != null) {
                for (String str : strArr3) {
                    arrayList.add(str);
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf(((long) (i11 ^ i12)) ^ (((long) (-605561172)) << 32)), Long.valueOf(-605561171)};
                byte[] bArr5 = $$g;
                byte b15 = bArr5[78];
                Object[] objArr22 = new Object[1];
                w((byte) 31, b15, b15, objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                w(bArr5[78], bArr5[28], (byte) ($$h & SyslogConstants.LOG_CLOCK), objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i24 = ((int[]) objArr[3])[0];
                int i25 = ((int[]) objArr[0])[0];
                int i26 = ((int[]) objArr[1])[0];
                String[] strArr4 = (String[]) objArr[2];
                int i27 = ~(System.identityHashCode(this) | 196113255);
                int i28 = i24 + 69291835 + (((-2059111) | i27) * (-220)) + ((i27 | (-197098344)) * 220) + 87838830;
                int i29 = (i28 << 13) ^ i28;
                int i30 = i29 ^ (i29 >>> 17);
                ((int[]) objArr24[3])[0] = i30 ^ (i30 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame10 == null) {
            int maximumFlingVelocity = 26 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
            char c = (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1);
            int iResolveSizeAndState = View.resolveSizeAndState(0, 0, 0) + 1041;
            byte[] bArr6 = $$a;
            byte b16 = (byte) (bArr6[21] - 1);
            Object[] objArr25 = new Object[1];
            u(b16, b16, (byte) (-bArr6[8]), objArr25);
            objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity, c, iResolveSizeAndState, 2061780482, false, (String) objArr25[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame10).getLong(null);
        if (j3 != -1) {
            long j4 = j3 + 4611686018427387792L;
            Object[] objArr26 = new Object[1];
            v(127 - TextUtils.getOffsetAfter("", 0), new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            v(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + b.l, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, null, null, objArr27);
            if (j4 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i31 = artificialFrame + 9;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i31 % 128;
                int i32 = i31 % 2;
                Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame11 == null) {
                    int i33 = 25 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                    char jumpTapTimeout = (char) (ViewConfiguration.getJumpTapTimeout() >> 16);
                    int pressedStateDuration3 = (ViewConfiguration.getPressedStateDuration() >> 16) + 1041;
                    byte b17 = $$a[21];
                    byte b18 = (byte) (b17 - 1);
                    Object[] objArr28 = new Object[1];
                    u(b18, b18, b17, objArr28);
                    objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(i33, jumpTapTimeout, pressedStateDuration3, 1145017376, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame11).get(null);
                objArr2 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i34 = ((int[]) objArr29[3])[0];
                int i35 = ((int[]) objArr29[2])[0];
                String[] strArr5 = (String[]) objArr29[0];
                int i36 = Settings.System.getInt(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getContentResolver(), "screen_brightness", -1);
                int i37 = ~i36;
                int i38 = (-1362509906) + (((~((-787802846) | i37)) | 580168412) * (-1188));
                int i39 = (~(i36 | 787802845)) | 580168412;
                int i40 = ~(865906652 | i37);
                int i41 = ((i38 + ((i39 | i40) * 594)) + ((((~(787802845 | i37)) | (-1073541086)) | i40) * 594)) - 1231602415;
                int i42 = (i41 << 13) ^ i41;
                int i43 = i42 ^ (i42 >>> 17);
                ((int[]) objArr2[1])[0] = i43 ^ (i43 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                v(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(19) + 16, new byte[]{-115, -116, -117, -120, -118, -119, -121, -106, -126, -127, -113, -121, -127, -107, -127, -108}, null, null, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                v(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 123, new byte[]{-116, -125, -123, -114, -104, -120, -127, -105, -118, -117, -122, -117, -126, -116, -125, -122}, null, null, objArr31);
                int iIntValue = ((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue();
                Object[] objArr32 = {634550211};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getDoubleTapTimeout() >> 16) + 8, (char) (((Process.getThreadPriority(0) + 20) >> 6) + 22251), 1033 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 47343338, false, null, new Class[]{Integer.TYPE});
                }
                Object[] objArrAccessartificialFrame$78cbbd35 = SchemaManager$$ExternalSyntheticLambda5.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr32), -1231602415, false);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame5 == null) {
                    int iArgb = 26 - Color.argb(0, 0, 0, 0);
                    char edgeSlop = (char) (ViewConfiguration.getEdgeSlop() >> 16);
                    int iResolveOpacity = Drawable.resolveOpacity(0, 0) + 1041;
                    byte b19 = $$a[21];
                    byte b20 = (byte) (b19 - 1);
                    Object[] objArr33 = new Object[1];
                    u(b20, b20, b19, objArr33);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iArgb, edgeSlop, iResolveOpacity, 1145017376, false, (String) objArr33[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Object[] objArr34 = new Object[1];
                    v(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 123, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr34);
                    Class<?> cls9 = Class.forName((String) objArr34[0]);
                    Object[] objArr35 = new Object[1];
                    v(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 123, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, null, null, objArr35);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr35[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame6 == null) {
                        int capsMode3 = 26 - TextUtils.getCapsMode("", 0, 0);
                        char cMyTid = (char) (Process.myTid() >> 22);
                        int iResolveSizeAndState2 = View.resolveSizeAndState(0, 0, 0) + 1041;
                        byte[] bArr7 = $$a;
                        byte b21 = (byte) (bArr7[21] - 1);
                        Object[] objArr36 = new Object[1];
                        u(b21, b21, (byte) (-bArr7[8]), objArr36);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(capsMode3, cMyTid, iResolveSizeAndState2, 2061780482, false, (String) objArr36[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                    objArr2 = objArrAccessartificialFrame$78cbbd35;
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr37 = new Object[1];
            v(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(19) + 16, new byte[]{-115, -116, -117, -120, -118, -119, -121, -106, -126, -127, -113, -121, -127, -107, -127, -108}, null, null, objArr37);
            Class<?> cls10 = Class.forName((String) objArr37[0]);
            Object[] objArr38 = new Object[1];
            v(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 123, new byte[]{-116, -125, -123, -114, -104, -120, -127, -105, -118, -117, -122, -117, -126, -116, -125, -122}, null, null, objArr38);
            int iIntValue2 = ((Integer) cls10.getMethod((String) objArr38[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr39 = {634550211};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getDoubleTapTimeout() >> 16) + 8, (char) (((Process.getThreadPriority(0) + 20) >> 6) + 22251), 1033 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            Object[] objArrAccessartificialFrame$78cbbd36 = SchemaManager$$ExternalSyntheticLambda5.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr39), -1231602415, false);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame5 == null) {
                int iArgb2 = 26 - Color.argb(0, 0, 0, 0);
                char edgeSlop2 = (char) (ViewConfiguration.getEdgeSlop() >> 16);
                int iResolveOpacity2 = Drawable.resolveOpacity(0, 0) + 1041;
                byte b110 = $$a[21];
                byte b22 = (byte) (b110 - 1);
                Object[] objArr310 = new Object[1];
                u(b22, b22, b110, objArr310);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iArgb2, edgeSlop2, iResolveOpacity2, 1145017376, false, (String) objArr310[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd36);
            Object[] objArr311 = new Object[1];
            v(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 123, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr311);
            Class<?> cls11 = Class.forName((String) objArr311[0]);
            Object[] objArr312 = new Object[1];
            v(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 123, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, null, null, objArr312);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr312[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame6 == null) {
                int capsMode4 = 26 - TextUtils.getCapsMode("", 0, 0);
                char cMyTid2 = (char) (Process.myTid() >> 22);
                int iResolveSizeAndState3 = View.resolveSizeAndState(0, 0, 0) + 1041;
                byte[] bArr8 = $$a;
                byte b23 = (byte) (bArr8[21] - 1);
                Object[] objArr313 = new Object[1];
                u(b23, b23, (byte) (-bArr8[8]), objArr313);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(capsMode4, cMyTid2, iResolveSizeAndState3, 2061780482, false, (String) objArr313[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
            objArr2 = objArrAccessartificialFrame$78cbbd36;
        }
        int i44 = ((int[]) objArr2[2])[0];
        int i45 = ((int[]) objArr2[3])[0];
        if (i45 == i44) {
            Object[] objArr40 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i46 = ((int[]) objArr2[1])[0];
            int i47 = ((int[]) objArr2[3])[0];
            int i48 = ((int[]) objArr2[2])[0];
            String[] strArr6 = (String[]) objArr2[0];
            int i49 = ~System.identityHashCode(this);
            int i50 = i46 + 402821534 + (((~(i49 | 909531427)) | 25723908) * (-160)) + (((~(i49 | 831427620)) | 909531427) * SyslogConstants.LOG_LOCAL4);
            int i51 = (i50 << 13) ^ i50;
            int i52 = i51 ^ (i51 >>> 17);
            ((int[]) objArr40[1])[0] = i52 ^ (i52 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArr2[0];
        if (strArr7 != null) {
            for (String str2 : strArr7) {
                int i53 = getARTIFICIAL_FRAME_PACKAGE_NAME + 29;
                artificialFrame = i53 % 128;
                int i54 = i53 % 2;
                arrayList2.add(str2);
            }
        }
        long j5 = ((long) (i44 ^ i45)) ^ (((long) (-132825581)) << 32);
        long j6 = -132825583;
        int i55 = getARTIFICIAL_FRAME_PACKAGE_NAME + 97;
        artificialFrame = i55 % 128;
        int i56 = i55 % 2;
        Object[] objArr41 = {Long.valueOf(j5), Long.valueOf(j6)};
        byte[] bArr9 = $$g;
        Object[] objArr42 = new Object[1];
        w((byte) (-bArr9[4]), bArr9[78], bArr9[2], objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        Object[] objArr43 = new Object[1];
        w(bArr9[78], bArr9[28], (byte) ($$h & SyslogConstants.LOG_CLOCK), objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {strArr, new int[1], new int[]{i}, new int[]{i}};
        int i57 = ((int[]) objArr2[1])[0];
        int i58 = ((int[]) objArr2[3])[0];
        int i59 = ((int[]) objArr2[2])[0];
        String[] strArr8 = (String[]) objArr2[0];
        int i60 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().keyboardHidden;
        int i61 = (~((-732008487) | i60)) | 150999040;
        int i62 = i57 + (-6678306) + (i61 * 992) + ((i61 | (~((~i60) | (-72895234)))) * (-496)) + ((i60 | (-653904680)) * 496);
        int i63 = (i62 << 13) ^ i62;
        int i64 = i63 ^ (i63 >>> 17);
        ((int[]) objArr44[1])[0] = i64 ^ (i64 << 5);
    }
}
