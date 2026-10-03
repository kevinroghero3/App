package com.transistorsoft.locationmanager.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.core.app.NotificationCompat;
import com.facebook.fresco.urimod.UriModifierInterface;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.GeofencingEvent;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationServices;
import com.google.common.base.Ascii;
import com.transistorsoft.locationmanager.adapter.BackgroundGeolocation;
import com.transistorsoft.locationmanager.adapter.TSConfig;
import com.transistorsoft.locationmanager.config.TSNotification;
import com.transistorsoft.locationmanager.event.LaunchForegroundServiceEvent;
import com.transistorsoft.locationmanager.location.TSLocationManager;
import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.locationmanager.scheduler.TSScheduleManager;
import com.transistorsoft.locationmanager.util.Util;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import o.ArtificialStackFrames;
import o.onPostMessage;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractService extends Service {
    private static char[] IPostMessageService = null;
    private static final AtomicBoolean k;
    private static final AtomicBoolean l;
    private static final String m = "ForegroundServiceStartNotAllowedException";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f122n = "TSLocationManager::FOREGROUND_SERVICE_GEOFENCE";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final List<String> f123o;
    private static final List<Intent> p;
    private long a;
    protected Date i;
    private static final byte[] $$l = {123, -106, -53, 126};
    private static final int $$m = 158;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$j = {87, 9, 66, Ascii.SYN, Ascii.DC2, 4, -57, 62, 1, 8, 8, 3, 19, 6, 2, -55, 65, 10, -6, Ascii.FF, 4, 17, -1, Ascii.CR, -5, Ascii.CR, 3, Ascii.VT, -3, -49, 59, Ascii.DC2, 9, -7, -49, 40, 40, 3, -5, Ascii.ETB, -12, 8, 19, -25, Ascii.CAN, Ascii.DC2, 10, -10, Ascii.SI, -5, 8, -25, 33, 8, Ascii.ETB, 1, 9, Ascii.CR, -79, 37, 50, 4, 9, -9, 19, 1, Ascii.FF, 5, 6, 67, 2, 3, Ascii.DC2, 6, 2, -55, 1, 65, Ascii.VT, Ascii.FF, -9, 19, 2, -7, 17, -56, 79, 2, -63, 42, Ascii.EM, 2, 17, -15, Ascii.DC4, 3, -9, 34, -6, Ascii.SO, 0, Ascii.NAK, -74, 57, 33, -3, 17, -9, 19, -24, 19, Ascii.CAN, -2};
    private static final int $$k = 212;
    private static final byte[] $$d = {122, -14, -75, -84, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13};
    private static final int $$e = 185;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private int b = 0;
    private final Handler c = new Handler(Looper.getMainLooper());
    private final AtomicInteger d = new AtomicInteger(0);
    private final AtomicInteger e = new AtomicInteger(0);
    private final AtomicBoolean f = new AtomicBoolean(false);
    private final AtomicReference<Runnable> g = new AtomicReference<>();
    protected final List<Intent> h = new ArrayList();
    private String j = "AbstractService";

    class a implements TSLocationManager.LocationCallback {
        final /* synthetic */ Context a;
        final /* synthetic */ Intent b;

        a(Context context, Intent intent) {
            this.a = context;
            this.b = intent;
        }

        @Override // com.transistorsoft.locationmanager.location.TSLocationManager.LocationCallback
        public void onFailure(String str) {
            TSLog.logger.info(TSLog.warn("Failed to fetch lastLocation to create TSLocationManager::FOREGROUND_SERVICE_GEOFENCE"));
            AbstractService.startForegroundService(this.a, this.b);
        }

        @Override // com.transistorsoft.locationmanager.location.TSLocationManager.LocationCallback
        public void onLocation(Location location) {
            TSLog.logger.debug(TSLog.pin(location.toString()));
            GeofencingClient geofencingClient = LocationServices.getGeofencingClient(this.a);
            geofencingClient.addGeofences(new GeofencingRequest.Builder().setInitialTrigger(1).addGeofence(new Geofence.Builder().setRequestId(AbstractService.f122n).setCircularRegion(location.getLatitude(), location.getLongitude(), location.hasAccuracy() ? 200.0f + location.getAccuracy() : 200.0f).setExpirationDuration(120000L).setTransitionTypes(1).setLoiteringDelay(0).setNotificationResponsiveness(0).build()).build(), PendingIntent.getForegroundService(this.a, 0, this.b, Util.getPendingIntentFlags(134217728)));
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    /* JADX WARN: Code duplicated, block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$n(byte r6, byte r7, short r8) {
        /*
            int r6 = r6 * 2
            int r0 = r6 + 1
            byte[] r1 = com.transistorsoft.locationmanager.service.AbstractService.$$l
            int r7 = r7 * 4
            int r7 = 3 - r7
            int r8 = r8 * 3
            int r8 = r8 + 65
            byte[] r0 = new byte[r0]
            r2 = 0
            if (r1 != 0) goto L17
            r3 = r6
            r8 = r7
            r4 = r2
            goto L2d
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r8
            r0[r3] = r4
            int r4 = r3 + 1
            int r7 = r7 + 1
            if (r3 != r6) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            return r6
        L27:
            r3 = r1[r7]
            r5 = r8
            r8 = r7
            r7 = r3
            r3 = r5
        L2d:
            int r7 = -r7
            int r7 = r7 + r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.service.AbstractService.$$n(byte, byte, short):java.lang.String");
    }

    static {
        accessartificialFrame();
        k = new AtomicBoolean(false);
        l = new AtomicBoolean(false);
        f123o = new ArrayList();
        p = new ArrayList();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void C(byte r5, byte r6, short r7, java.lang.Object[] r8) {
        /*
            int r6 = r6 * 8
            int r6 = r6 + 4
            byte[] r0 = com.transistorsoft.locationmanager.service.AbstractService.$$d
            int r5 = r5 * 3
            int r1 = r5 + 9
            int r7 = r7 * 28
            int r7 = 112 - r7
            byte[] r1 = new byte[r1]
            int r5 = r5 + 8
            r2 = 0
            if (r0 != 0) goto L19
            r7 = r5
            r4 = r6
            r3 = r2
            goto L2b
        L19:
            r3 = r2
        L1a:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r5) goto L27
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L27:
            int r3 = r3 + 1
            r4 = r0[r6]
        L2b:
            int r6 = r6 + 1
            int r4 = -r4
            int r7 = r7 + r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.service.AbstractService.C(byte, byte, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0028). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void E(short r5, short r6, int r7, java.lang.Object[] r8) {
        /*
            byte[] r0 = com.transistorsoft.locationmanager.service.AbstractService.$$j
            int r6 = r6 * 2
            int r6 = 70 - r6
            int r1 = r7 + 3
            int r5 = r5 * 3
            int r5 = 111 - r5
            byte[] r1 = new byte[r1]
            int r7 = r7 + 2
            r2 = 0
            if (r0 != 0) goto L16
            r4 = r7
            r3 = r2
            goto L28
        L16:
            r3 = r2
        L17:
            byte r4 = (byte) r5
            r1[r3] = r4
            if (r3 != r7) goto L24
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L24:
            int r3 = r3 + 1
            r4 = r0[r6]
        L28:
            int r6 = r6 + 1
            int r5 = r5 + r4
            int r5 = r5 + (-6)
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.service.AbstractService.E(short, short, int, java.lang.Object[]):void");
    }

    static boolean a() {
        boolean zIsEmpty;
        List<String> list = f123o;
        synchronized (list) {
            zIsEmpty = list.isEmpty();
        }
        return !zIsEmpty;
    }

    private static void b(String str) {
        List<String> list = f123o;
        synchronized (list) {
            if (!list.contains(str)) {
                list.add(str);
            }
        }
    }

    private static void c(String str) {
        List<String> list = f123o;
        synchronized (list) {
            list.remove(str);
        }
    }

    private static List<Intent> d() {
        ArrayList arrayList;
        List<Intent> list = p;
        synchronized (list) {
            arrayList = new ArrayList(list);
            list.clear();
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        BackgroundGeolocation.getInstance(getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        if (this.f.get()) {
            b();
            return;
        }
        if (this.d.get() <= 0) {
            boolean zStopSelfResult = stopSelfResult(this.e.get());
            TSLog.logger.debug("\n  ⚙️︎  " + this.j + ".stopSelfResult(" + this.e.get() + "): " + zStopSelfResult);
        }
    }

    private boolean g() {
        return k.get() && l.get();
    }

    public static void launchQueuedServices(Context context) {
        Iterator<Intent> it2 = d().iterator();
        while (it2.hasNext()) {
            startForegroundService(context, it2.next());
        }
    }

    public static void launchService(Context context, Class<?> cls, String str) {
        Intent intent = new Intent(context, cls);
        intent.setAction(str);
        startForegroundService(context, intent);
    }

    public static void r(boolean z) {
        k.set(true);
        l.set(z);
    }

    public static void startForegroundService(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT < 26) {
            context.startService(intent);
            return;
        }
        try {
            context.startForegroundService(intent);
        } catch (Exception e) {
            if (Build.VERSION.SDK_INT < 31 || !e.getClass().getSimpleName().equalsIgnoreCase(m)) {
                TSLog.logger.error(TSLog.error("[startForegroundService] ERROR: " + intent + StringUtils.SPACE + intent.getExtras() + ", error: " + e.getMessage()), (Throwable) e);
                return;
            }
            int intExtra = intent.getIntExtra("launch_failures", 0) + 1;
            if (intExtra > 1) {
                TSLog.logger.error(TSLog.warn("[startForegroundService] LAUNCH DENIED (2nd try). Giving up. " + intent), (Throwable) e);
                return;
            }
            intent.putExtra("launch_failures", intExtra);
            a(intent);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            if (Build.VERSION.SDK_INT <= 33) {
                TSLog.logger.warn(TSLog.info("Background FGS launch denied:  Retrying with AlarmManager..." + intent));
                TSScheduleManager.getInstance(context).oneShot(LaunchForegroundServiceEvent.ACTION, 0L, true, true);
                return;
            }
            if (alarmManager.canScheduleExactAlarms()) {
                TSLog.logger.warn(TSLog.info("Background FGS launch denied:  Retrying with AlarmManager..." + intent));
                TSScheduleManager.getInstance(context).oneShot(LaunchForegroundServiceEvent.ACTION, 0L, true, true);
                return;
            }
            TSLog.logger.warn(TSLog.info("Background FGS launch denied:  Retrying with TSLocationManager::FOREGROUND_SERVICE_GEOFENCE..." + intent));
            a(context, intent);
        }
    }

    public static void stop(Context context, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        if (a(cls.getSimpleName())) {
            intent.setAction("stop");
            startForegroundService(context, intent);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        b();
        c(this.j);
        TSLog.logger.debug(TSLog.off(this.j + " stopped"));
    }

    public void onTimeout(int i, int i2) {
        TSLog.logger.warn(TSLog.warn("Force stopping Service"));
        a(false);
        a(i);
        super.onTimeout(i, i2);
    }

    static boolean a(String str) {
        boolean zContains;
        List<String> list = f123o;
        synchronized (list) {
            zContains = list.contains(str);
        }
        return zContains;
    }

    private void c() {
        if (this.f.get() && this.i == null) {
            this.i = new Date();
        }
        try {
            if (this.a >= 0) {
                long jCurrentTimeMillis = System.currentTimeMillis() - this.a;
                if (jCurrentTimeMillis > 250) {
                    TSLog.logger.debug("\n  ⚙️︎   dt " + this.j + ".onCreate -> startForeground(): " + jCurrentTimeMillis + "ms");
                }
                this.a = -1L;
            }
            if (Build.VERSION.SDK_INT >= 34) {
                startForeground(ForegroundNotification.NOTIFICATION_ID, ForegroundNotification.build(this), -1);
            } else {
                startForeground(ForegroundNotification.NOTIFICATION_ID, ForegroundNotification.build(this));
            }
        } catch (Exception e) {
            stopSelf();
            TSLog.logger.error(TSLog.error(e.getMessage()), (Throwable) e);
        }
    }

    private static void a(Intent intent) {
        List<Intent> list = p;
        synchronized (list) {
            list.add(intent);
        }
    }

    private void b(int i) {
        TSLog.logger.debug(TSLog.on("STOP [" + this.j + " startId: " + i + ", eventCount: " + this.d.get() + "]"));
        this.f.set(false);
        a(i);
    }

    private void b() {
        synchronized (this.g) {
            if (this.g.get() != null) {
                this.c.removeCallbacks(this.g.get());
                this.g.set(null);
            }
        }
    }

    private static void a(Context context, Intent intent) {
        TSLocationManager.getInstance(context).getLastLocation(new a(context, intent));
    }

    protected void a(String str, int i) {
        this.b = i;
        this.a = System.currentTimeMillis();
        super.onCreate();
        this.j = str;
        c();
        b(str);
        BackgroundGeolocation.getThreadPool().execute(new Runnable() { // from class: com.transistorsoft.locationmanager.service.AbstractService$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.e();
            }
        });
    }

    public boolean a(Intent intent, int i, boolean z) {
        this.e.set(i);
        this.d.incrementAndGet();
        TSConfig tSConfig = TSConfig.getInstance(getApplicationContext());
        if (!g()) {
            tSConfig.reset();
            stopSelf();
            return false;
        }
        c();
        String action = intent.getAction();
        if (action != null) {
            if (action.equalsIgnoreCase("stop")) {
                b(i);
                return false;
            }
            if (action.equalsIgnoreCase("start")) {
                GeofencingEvent geofencingEventFromIntent = GeofencingEvent.fromIntent(intent);
                if (geofencingEventFromIntent != null) {
                    a(geofencingEventFromIntent);
                }
                a(true);
            } else if (action.equalsIgnoreCase("notificationaction")) {
                TSLog.logger.debug("[notificationaction] " + intent.getStringExtra("id"));
                if (intent.hasExtra("id")) {
                    String stringExtra = intent.getStringExtra("id");
                    if (tSConfig.getNotification().getLayout().equalsIgnoreCase("default")) {
                        if (stringExtra.equalsIgnoreCase("notificationButtonPause")) {
                            TrackingService.changePace(getApplicationContext(), false);
                        }
                    } else if (TSNotification.NAME.equalsIgnoreCase(stringExtra)) {
                        startActivity(getApplicationContext().getPackageManager().getLaunchIntentForPackage(getApplicationContext().getPackageName()));
                    }
                    BackgroundGeolocation.getInstance(getApplicationContext()).fireNotificationActionListeners(stringExtra);
                } else {
                    TSLog.logger.warn(TSLog.warn("Notification action received with no id"));
                }
            }
        }
        if (z && !tSConfig.getEnabled().booleanValue()) {
            TSLog.logger.warn(TSLog.warn("Refusing to start " + this.j + ", enabled: false"));
            b(i);
            return false;
        }
        if (action == null) {
            action = "start";
        }
        TSLog.logger.debug(TSLog.on(action + " [" + this.j + "  startId: " + i + ", eventCount: " + this.d.get() + "]"));
        if (this.f.get() && !this.h.contains(intent)) {
            this.h.add(intent);
        }
        return true;
    }

    private void a(GeofencingEvent geofencingEvent) {
        if (geofencingEvent.hasError()) {
            TSLog.logger.info("TSLocationManager::FOREGROUND_SERVICE_GEOFENCE Error: " + geofencingEvent.getErrorCode());
            return;
        }
        List<Geofence> triggeringGeofences = geofencingEvent.getTriggeringGeofences();
        if (triggeringGeofences != null) {
            Iterator<Geofence> it2 = triggeringGeofences.iterator();
            while (it2.hasNext()) {
                if (it2.next().getRequestId().equals(f122n)) {
                    TSLog.logger.info(TSLog.info("👍 Foreground-service launched with TSLocationManager::FOREGROUND_SERVICE_GEOFENCE"));
                    a(getApplicationContext());
                    return;
                }
            }
        }
    }

    private static void a(Context context) {
        GeofencingClient geofencingClient = LocationServices.getGeofencingClient(context);
        if (geofencingClient == null) {
            TSLog.logger.warn(TSLog.warn("GeofencingClient is null"));
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(f122n);
        geofencingClient.removeGeofences(arrayList);
    }

    protected void a(boolean z) {
        this.f.set(z);
    }

    public void a(int i) {
        int iDecrementAndGet = this.d.decrementAndGet();
        TSLog.logger.debug("\n  ⚙️︎   FINISH [" + this.j + " startId: " + i + ", eventCount: " + Math.max(iDecrementAndGet, 0) + ", sticky: " + this.f.get() + "]");
        if (!this.f.get() && this.d.get() <= 0) {
            a(200L);
        }
    }

    private void a(long j) {
        b();
        synchronized (this.g) {
            this.g.set(new Runnable() { // from class: com.transistorsoft.locationmanager.service.AbstractService$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.f();
                }
            });
            this.c.postDelayed(this.g.get(), j);
        }
    }

    private static void D(boolean z, byte[] bArr, int[] iArr, Object[] objArr) throws Throwable {
        int length;
        char[] cArr;
        int i = 2;
        int i2 = 2 % 2;
        onPostMessage onpostmessage = new onPostMessage();
        int i3 = 0;
        int i4 = iArr[0];
        int i5 = 1;
        int i6 = iArr[1];
        int i7 = iArr[2];
        int i8 = iArr[3];
        char[] cArr2 = IPostMessageService;
        char c = '0';
        if (cArr2 != null) {
            int i9 = $11 + 37;
            $10 = i9 % 128;
            if (i9 % 2 != 0) {
                length = cArr2.length;
                cArr = new char[length];
            } else {
                length = cArr2.length;
                cArr = new char[length];
            }
            int i10 = 0;
            while (i10 < length) {
                int i11 = $11 + 71;
                $10 = i11 % 128;
                if (i11 % i != 0) {
                    try {
                        Object[] objArr2 = new Object[i5];
                        objArr2[i3] = Integer.valueOf(cArr2[i10]);
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1782207618);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) i3;
                            byte b2 = b;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - Color.green(i3), (char) ((-1) - TextUtils.lastIndexOf("", c, i3, i3)), 1562 - (Process.myPid() >> 22), 178318710, false, $$n(b, b2, b2), new Class[]{Integer.TYPE});
                        }
                        cArr[i10] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                        i10 >>>= 1;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } else {
                    try {
                        Object[] objArr3 = {Integer.valueOf(cArr2[i10])};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1782207618);
                        if (objAccessartificialFrame2 == null) {
                            byte b3 = (byte) 0;
                            byte b4 = b3;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(12 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) View.resolveSize(0, 0), 1561 - ((byte) KeyEvent.getModifierMetaStateMask()), 178318710, false, $$n(b3, b4, b4), new Class[]{Integer.TYPE});
                        }
                        cArr[i10] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                        i10++;
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 == null) {
                            throw th2;
                        }
                        throw cause2;
                    }
                }
                i = 2;
                i3 = 0;
                i5 = 1;
                c = '0';
            }
            cArr2 = cArr;
        }
        char[] cArr3 = new char[i6];
        System.arraycopy(cArr2, i4, cArr3, 0, i6);
        if (bArr != null) {
            int i12 = $11 + 19;
            $10 = i12 % 128;
            int i13 = i12 % 2;
            char[] cArr4 = new char[i6];
            onpostmessage.a = 0;
            char c2 = 0;
            while (onpostmessage.a < i6) {
                if (bArr[onpostmessage.a] == 1) {
                    int i14 = onpostmessage.a;
                    Object[] objArr4 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c2)};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1378437083);
                    if (objAccessartificialFrame3 == null) {
                        byte b5 = (byte) 0;
                        byte b6 = b5;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(KeyEvent.keyCodeFromString("") + 23, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), 2441 - Color.argb(0, 0, 0, 0), -850656813, false, $$n(b5, b6, (byte) (b6 + 1)), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr4[i14] = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).charValue();
                } else {
                    int i15 = onpostmessage.a;
                    Object[] objArr5 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c2)};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-314759072);
                    if (objAccessartificialFrame4 == null) {
                        byte b7 = (byte) 0;
                        byte b8 = b7;
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(11 - (ViewConfiguration.getTapTimeout() >> 16), (char) ((-1) - TextUtils.lastIndexOf("", '0')), 1562 - (KeyEvent.getMaxKeyCode() >> 16), 1918398056, false, $$n(b7, b8, (byte) (b8 | 19)), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr4[i15] = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).charValue();
                }
                c2 = cArr4[onpostmessage.a];
                Object[] objArr6 = {onpostmessage, onpostmessage};
                Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(898481158);
                if (objAccessartificialFrame5 == null) {
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(22 - TextUtils.getTrimmedLength(""), (char) (29363 - (ViewConfiguration.getTouchSlop() >> 8)), 216 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), -1427572210, false, "F", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame5).invoke(null, objArr6);
            }
            cArr3 = cArr4;
        }
        if (i8 > 0) {
            char[] cArr5 = new char[i6];
            System.arraycopy(cArr3, 0, cArr5, 0, i6);
            int i16 = i6 - i8;
            System.arraycopy(cArr5, 0, cArr3, i16, i8);
            System.arraycopy(cArr5, i8, cArr3, 0, i16);
            int i17 = $10 + 55;
            $11 = i17 % 128;
            int i18 = i17 % 2;
        }
        if (z) {
            char[] cArr6 = new char[i6];
            int i19 = 0;
            while (true) {
                onpostmessage.a = i19;
                if (onpostmessage.a >= i6) {
                    break;
                }
                cArr6[onpostmessage.a] = cArr3[(i6 - onpostmessage.a) - 1];
                i19 = onpostmessage.a + 1;
            }
            cArr3 = cArr6;
        }
        if (i7 > 0) {
            int i20 = $10 + 31;
            $11 = i20 % 128;
            int i21 = i20 % 2;
            int i22 = 0;
            loop3: while (true) {
                onpostmessage.a = i22;
                while (true) {
                    if (onpostmessage.a >= i6) {
                        break loop3;
                    }
                    int i23 = $10 + 69;
                    $11 = i23 % 128;
                    if (i23 % 2 == 0) {
                        cArr3[onpostmessage.a] = (char) (cArr3[onpostmessage.a] >> iArr[3]);
                        onpostmessage.a >>= 1;
                    }
                }
                cArr3[onpostmessage.a] = (char) (cArr3[onpostmessage.a] - iArr[2]);
                i22 = onpostmessage.a + 1;
            }
        }
        objArr[0] = new String(cArr3);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0189  */
    /* JADX WARN: Code duplicated, block: B:16:0x01f0 A[Catch: all -> 0x0927, TryCatch #0 {all -> 0x0927, blocks: (B:54:0x0678, B:56:0x068c, B:57:0x06bb, B:14:0x01d0, B:16:0x01f0, B:17:0x0237), top: B:96:0x01d0 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0249  */
    /* JADX WARN: Code duplicated, block: B:25:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:53:0x062e  */
    /* JADX WARN: Code duplicated, block: B:56:0x068c A[Catch: all -> 0x0927, TryCatch #0 {all -> 0x0927, blocks: (B:54:0x0678, B:56:0x068c, B:57:0x06bb, B:14:0x01d0, B:16:0x01f0, B:17:0x0237), top: B:96:0x01d0 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x06d1  */
    /* JADX WARN: Code duplicated, block: B:65:0x0764  */
    @Override // android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object objAccessartificialFrame;
        Object[] objArr;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        Object[] objArr2;
        int i = 2 % 2;
        int i2 = artificialFrame + 13;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        int i3 = i2 % 2;
        super.attachBaseContext(context);
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame7 == null) {
            int minimumFlingVelocity = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 25;
            char cRed = (char) (Color.red(0) + 30068);
            int i4 = 817 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
            byte b = (byte) ($$d[5] - 1);
            byte b2 = b;
            Object[] objArr3 = new Object[1];
            C(b, b2, b2, objArr3);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity, cRed, i4, 721586079, false, (String) objArr3[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 2032;
            Object[] objArr4 = new Object[1];
            D(true, new byte[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0}, new int[]{0, 22, 0, 19}, objArr4);
            Class<?> cls = Class.forName((String) objArr4[0]);
            Object[] objArr5 = new Object[1];
            D(false, new byte[]{1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0}, new int[]{22, 15, 188, 0}, objArr5);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i5 = artificialFrame + 51;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i5 % 128;
                int i6 = i5 % 2;
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame8 == null) {
                    int minimumFlingVelocity2 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 25;
                    char trimmedLength = (char) (30068 - TextUtils.getTrimmedLength(""));
                    int maximumDrawingCacheSize = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 816;
                    byte b3 = $$d[5];
                    byte b4 = (byte) (b3 - 1);
                    byte b5 = b3;
                    Object[] objArr6 = new Object[1];
                    C(b4, b5, (byte) (b5 - 1), objArr6);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity2, trimmedLength, maximumDrawingCacheSize, 891606461, false, (String) objArr6[0], null);
                }
                Object[] objArr7 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i7 = ((int[]) objArr7[0])[0];
                int i8 = ((int[]) objArr7[1])[0];
                String[] strArr = (String[]) objArr7[2];
                int i9 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().touchscreen;
                int i10 = ~i9;
                int i11 = ((((-962255719) + ((((~(160859033 | i10)) | (-359031400)) | (~((-160859034) | i9))) * (-564))) + ((~(i9 | (-17170946))) * 1128)) + (((~((-359031400) | i10)) | 143688088) * 564)) - 313614530;
                int i12 = (i11 << 13) ^ i11;
                int i13 = i12 ^ (i12 >>> 17);
                ((int[]) objArr[3])[0] = i13 ^ (i13 << 5);
            } else {
                Object[] objArr8 = new Object[1];
                D(true, new byte[]{1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1}, new int[]{37, 16, 0, 0}, objArr8);
                Class<?> cls2 = Class.forName((String) objArr8[0]);
                Object[] objArr9 = new Object[1];
                D(true, new byte[]{1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0}, new int[]{53, 16, 73, 15}, objArr9);
                try {
                    Object[] objArr10 = {Integer.valueOf(((Integer) cls2.getMethod((String) objArr9[0], Object.class).invoke(null, this)).intValue()), 0, -313614530};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame == null) {
                        int windowTouchSlop = 25 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                        char cResolveSizeAndState = (char) (30068 - View.resolveSizeAndState(0, 0, 0));
                        int absoluteGravity = Gravity.getAbsoluteGravity(0, 0) + 816;
                        byte[] bArr = $$d;
                        byte b6 = bArr[5];
                        Object[] objArr11 = new Object[1];
                        C(b6, bArr[8], b6, objArr11);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(windowTouchSlop, cResolveSizeAndState, absoluteGravity, -797394565, false, (String) objArr11[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr10);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame2 == null) {
                        int touchSlop = 25 - (ViewConfiguration.getTouchSlop() >> 8);
                        char pressedStateDuration = (char) (30068 - (ViewConfiguration.getPressedStateDuration() >> 16));
                        int scrollBarFadeDuration = 816 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                        byte b7 = $$d[5];
                        byte b8 = (byte) (b7 - 1);
                        byte b9 = b7;
                        Object[] objArr12 = new Object[1];
                        C(b8, b9, (byte) (b9 - 1), objArr12);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(touchSlop, pressedStateDuration, scrollBarFadeDuration, 891606461, false, (String) objArr12[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArr);
                    try {
                        Object[] objArr13 = new Object[1];
                        D(true, new byte[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0}, new int[]{0, 22, 0, 19}, objArr13);
                        Class<?> cls3 = Class.forName((String) objArr13[0]);
                        Object[] objArr14 = new Object[1];
                        D(false, new byte[]{1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0}, new int[]{22, 15, 188, 0}, objArr14);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr14[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame3 == null) {
                            int size = View.MeasureSpec.getSize(0) + 25;
                            char cResolveSize = (char) (View.resolveSize(0, 0) + 30068);
                            int modifierMetaStateMask = ((byte) KeyEvent.getModifierMetaStateMask()) + 817;
                            byte b10 = (byte) ($$d[5] - 1);
                            byte b11 = b10;
                            Object[] objArr15 = new Object[1];
                            C(b10, b11, b11, objArr15);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(size, cResolveSize, modifierMetaStateMask, 721586079, false, (String) objArr15[0], null);
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
            D(true, new byte[]{1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1}, new int[]{37, 16, 0, 0}, objArr16);
            Class<?> cls4 = Class.forName((String) objArr16[0]);
            Object[] objArr17 = new Object[1];
            D(true, new byte[]{1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0}, new int[]{53, 16, 73, 15}, objArr17);
            Object[] objArr18 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue()), 0, -313614530};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame == null) {
                int windowTouchSlop2 = 25 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                char cResolveSizeAndState2 = (char) (30068 - View.resolveSizeAndState(0, 0, 0));
                int absoluteGravity2 = Gravity.getAbsoluteGravity(0, 0) + 816;
                byte[] bArr2 = $$d;
                byte b12 = bArr2[5];
                Object[] objArr19 = new Object[1];
                C(b12, bArr2[8], b12, objArr19);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(windowTouchSlop2, cResolveSizeAndState2, absoluteGravity2, -797394565, false, (String) objArr19[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr18);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame2 == null) {
                int touchSlop2 = 25 - (ViewConfiguration.getTouchSlop() >> 8);
                char pressedStateDuration2 = (char) (30068 - (ViewConfiguration.getPressedStateDuration() >> 16));
                int scrollBarFadeDuration2 = 816 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                byte b13 = $$d[5];
                byte b14 = (byte) (b13 - 1);
                byte b15 = b13;
                Object[] objArr110 = new Object[1];
                C(b14, b15, (byte) (b15 - 1), objArr110);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(touchSlop2, pressedStateDuration2, scrollBarFadeDuration2, 891606461, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArr);
            Object[] objArr111 = new Object[1];
            D(true, new byte[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0}, new int[]{0, 22, 0, 19}, objArr111);
            Class<?> cls5 = Class.forName((String) objArr111[0]);
            Object[] objArr112 = new Object[1];
            D(false, new byte[]{1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0}, new int[]{22, 15, 188, 0}, objArr112);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr112[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame3 == null) {
                int size2 = View.MeasureSpec.getSize(0) + 25;
                char cResolveSize2 = (char) (View.resolveSize(0, 0) + 30068);
                int modifierMetaStateMask2 = ((byte) KeyEvent.getModifierMetaStateMask()) + 817;
                byte b16 = (byte) ($$d[5] - 1);
                byte b17 = b16;
                Object[] objArr113 = new Object[1];
                C(b16, b17, b17, objArr113);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(size2, cResolveSize2, modifierMetaStateMask2, 721586079, false, (String) objArr113[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i14 = ((int[]) objArr[1])[0];
        int i15 = ((int[]) objArr[0])[0];
        if (i15 == i14) {
            int i16 = artificialFrame + 63;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i16 % 128;
            int i17 = i16 % 2;
            Object[] objArr20 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i18 = ((int[]) objArr[3])[0];
            int i19 = ((int[]) objArr[0])[0];
            int i20 = ((int[]) objArr[1])[0];
            String[] strArr2 = (String[]) objArr[2];
            int streamMaxVolume = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getStreamMaxVolume(3);
            int i21 = ~streamMaxVolume;
            int i22 = i18 + (-1864217090) + ((streamMaxVolume | 442883096) * (-859)) + (((~(streamMaxVolume | (-274726929))) | (~(442883096 | i21))) * 859) + (((~(244710730 | i21)) | (-519437659)) * 859);
            int i23 = (i22 << 13) ^ i22;
            int i24 = i23 ^ (i23 >>> 17);
            ((int[]) objArr20[3])[0] = i24 ^ (i24 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr[2];
            if (strArr3 != null) {
                int i25 = artificialFrame + 23;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i25 % 128;
                int i26 = i25 % 2;
                int i27 = 0;
                while (i27 < strArr3.length) {
                    int i28 = getARTIFICIAL_FRAME_PACKAGE_NAME + 77;
                    artificialFrame = i28 % 128;
                    if (i28 % 2 == 0) {
                        arrayList.add(strArr3[i27]);
                        i27 += 40;
                    } else {
                        arrayList.add(strArr3[i27]);
                        i27++;
                    }
                }
            }
            long j3 = ((long) (i14 ^ i15)) ^ (((long) (-2077752924)) << 32);
            long j4 = -2077752923;
            int i29 = artificialFrame + 59;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i29 % 128;
            int i30 = i29 % 2;
            try {
                Object[] objArr21 = {Long.valueOf(j3), Long.valueOf(j4)};
                byte[] bArr3 = $$j;
                Object[] objArr22 = new Object[1];
                E(bArr3[5], bArr3[52], bArr3[7], objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                E(bArr3[90], bArr3[8], bArr3[100], objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i31 = ((int[]) objArr[3])[0];
                int i32 = ((int[]) objArr[0])[0];
                int i33 = ((int[]) objArr[1])[0];
                String[] strArr4 = (String[]) objArr[2];
                int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
                int i34 = i31 + ((((-1148354397) + (((~startElapsedRealtime) | (-3137166)) * 1444)) + (((~(startElapsedRealtime | 99697320)) | ((~(98475045 | startElapsedRealtime)) | (-100654766))) * (-1444))) - 2029934166);
                int i35 = (i34 << 13) ^ i34;
                int i36 = i35 ^ (i35 >>> 17);
                ((int[]) objArr24[3])[0] = i36 ^ (i36 << 5);
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
            int windowTouchSlop3 = 26 - (ViewConfiguration.getWindowTouchSlop() >> 8);
            char c = (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
            int i37 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1042;
            byte b18 = (byte) ($$d[5] - 1);
            byte b19 = b18;
            Object[] objArr25 = new Object[1];
            C(b18, b19, b19, objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(windowTouchSlop3, c, i37, 2061780482, false, (String) objArr25[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j5 != -1) {
            long j6 = j5 + 4611686018427387951L;
            Object[] objArr26 = new Object[1];
            D(true, new byte[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0}, new int[]{0, 22, 0, 19}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            D(false, new byte[]{1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0}, new int[]{22, 15, 188, 0}, objArr27);
            if (j6 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i38 = artificialFrame + 107;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i38 % 128;
                int i39 = i38 % 2;
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame10 == null) {
                    int touchSlop3 = 26 - (ViewConfiguration.getTouchSlop() >> 8);
                    char scrollBarFadeDuration3 = (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    int iRed = Color.red(0) + 1041;
                    byte b20 = $$d[5];
                    byte b21 = (byte) (b20 - 1);
                    byte b22 = b20;
                    Object[] objArr28 = new Object[1];
                    C(b21, b22, (byte) (b22 - 1), objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(touchSlop3, scrollBarFadeDuration3, iRed, 1145017376, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr2 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i40 = ((int[]) objArr29[3])[0];
                int i41 = ((int[]) objArr29[2])[0];
                String[] strArr5 = (String[]) objArr29[0];
                int i42 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().keyboard;
                int i43 = ~i42;
                int i44 = 1637399214 + (((~((-279496961) | i43)) | (~((-756495590) | i42))) * 520);
                int i45 = ~(756495589 | i43);
                int i46 = ~(i42 | 834599396);
                int i47 = i44 + ((i45 | i46) * (-1040)) + ((i46 | (~(i43 | (-834599397))) | (-1035992550)) * 520) + 1809840988;
                int i48 = (i47 << 13) ^ i47;
                int i49 = i48 ^ (i48 >>> 17);
                ((int[]) objArr2[1])[0] = i49 ^ (i49 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                D(true, new byte[]{1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1}, new int[]{37, 16, 0, 0}, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                D(true, new byte[]{1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0}, new int[]{53, 16, 73, 15}, objArr31);
                int iIntValue = ((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue();
                Object[] objArr32 = {1955402534};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(7 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 22251), Drawable.resolveOpacity(0, 0) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
                }
                Object[] objArrAccessartificialFrame$78cbbd35 = UriModifierInterface.ModificationResult.Modified.ModifiedToMaxDimens.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr32), 1809840988, false);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame5 == null) {
                    int longPressTimeout = (ViewConfiguration.getLongPressTimeout() >> 16) + 26;
                    char c2 = (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1);
                    int iIndexOf = TextUtils.indexOf((CharSequence) "", '0') + 1042;
                    byte b23 = $$d[5];
                    byte b24 = (byte) (b23 - 1);
                    byte b25 = b23;
                    Object[] objArr33 = new Object[1];
                    C(b24, b25, (byte) (b25 - 1), objArr33);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(longPressTimeout, c2, iIndexOf, 1145017376, false, (String) objArr33[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Object[] objArr34 = new Object[1];
                    D(true, new byte[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0}, new int[]{0, 22, 0, 19}, objArr34);
                    Class<?> cls9 = Class.forName((String) objArr34[0]);
                    Object[] objArr35 = new Object[1];
                    D(false, new byte[]{1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0}, new int[]{22, 15, 188, 0}, objArr35);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr35[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame6 == null) {
                        int iIndexOf2 = 26 - TextUtils.indexOf("", "");
                        char cNormalizeMetaState = (char) KeyEvent.normalizeMetaState(0);
                        int iIndexOf3 = 1040 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                        byte b26 = (byte) ($$d[5] - 1);
                        byte b27 = b26;
                        Object[] objArr36 = new Object[1];
                        C(b26, b27, b27, objArr36);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iIndexOf2, cNormalizeMetaState, iIndexOf3, 2061780482, false, (String) objArr36[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                    objArr2 = objArrAccessartificialFrame$78cbbd35;
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr37 = new Object[1];
            D(true, new byte[]{1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1}, new int[]{37, 16, 0, 0}, objArr37);
            Class<?> cls10 = Class.forName((String) objArr37[0]);
            Object[] objArr38 = new Object[1];
            D(true, new byte[]{1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0}, new int[]{53, 16, 73, 15}, objArr38);
            int iIntValue2 = ((Integer) cls10.getMethod((String) objArr38[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr39 = {1955402534};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(7 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 22251), Drawable.resolveOpacity(0, 0) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            Object[] objArrAccessartificialFrame$78cbbd36 = UriModifierInterface.ModificationResult.Modified.ModifiedToMaxDimens.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr39), 1809840988, false);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame5 == null) {
                int longPressTimeout2 = (ViewConfiguration.getLongPressTimeout() >> 16) + 26;
                char c3 = (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1);
                int iIndexOf4 = TextUtils.indexOf((CharSequence) "", '0') + 1042;
                byte b28 = $$d[5];
                byte b29 = (byte) (b28 - 1);
                byte b210 = b28;
                Object[] objArr310 = new Object[1];
                C(b29, b210, (byte) (b210 - 1), objArr310);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(longPressTimeout2, c3, iIndexOf4, 1145017376, false, (String) objArr310[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd36);
            Object[] objArr311 = new Object[1];
            D(true, new byte[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0}, new int[]{0, 22, 0, 19}, objArr311);
            Class<?> cls11 = Class.forName((String) objArr311[0]);
            Object[] objArr312 = new Object[1];
            D(false, new byte[]{1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0}, new int[]{22, 15, 188, 0}, objArr312);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr312[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame6 == null) {
                int iIndexOf5 = 26 - TextUtils.indexOf("", "");
                char cNormalizeMetaState2 = (char) KeyEvent.normalizeMetaState(0);
                int iIndexOf6 = 1040 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                byte b211 = (byte) ($$d[5] - 1);
                byte b212 = b211;
                Object[] objArr313 = new Object[1];
                C(b211, b212, b212, objArr313);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iIndexOf5, cNormalizeMetaState2, iIndexOf6, 2061780482, false, (String) objArr313[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
            objArr2 = objArrAccessartificialFrame$78cbbd36;
        }
        int i50 = ((int[]) objArr2[2])[0];
        int i51 = ((int[]) objArr2[3])[0];
        if (i51 == i50) {
            int i52 = getARTIFICIAL_FRAME_PACKAGE_NAME + 47;
            artificialFrame = i52 % 128;
            int i53 = i52 % 2;
            Object[] objArr40 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i54 = ((int[]) objArr2[1])[0];
            int i55 = ((int[]) objArr2[3])[0];
            int i56 = ((int[]) objArr2[2])[0];
            String[] strArr6 = (String[]) objArr2[0];
            int iNextInt = new Random().nextInt(1322799557);
            int i57 = ~iNextInt;
            int i58 = i54 + 1439415162 + (((~((-857269300) | i57)) | 855679026) * (-108)) + (((~(i57 | 935373106)) | (~((-935373107) | iNextInt)) | (-936963380)) * 54) + ((iNextInt | (-936963380)) * 54);
            int i59 = (i58 << 13) ^ i58;
            int i60 = i59 ^ (i59 >>> 17);
            ((int[]) objArr40[1])[0] = i60 ^ (i60 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArr2[0];
        if (strArr7 != null) {
            for (String str : strArr7) {
                arrayList2.add(str);
            }
        }
        long j7 = ((long) (i50 ^ i51)) ^ (((long) 760806695) << 32);
        long j8 = 760806693;
        int i61 = getARTIFICIAL_FRAME_PACKAGE_NAME + 113;
        artificialFrame = i61 % 128;
        int i62 = i61 % 2;
        Object[] objArr41 = {Long.valueOf(j7), Long.valueOf(j8)};
        byte[] bArr4 = $$j;
        byte b30 = bArr4[100];
        byte b31 = b30;
        Object[] objArr42 = new Object[1];
        E(b30, b31, (byte) (b31 | 41), objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        Object[] objArr43 = new Object[1];
        E(bArr4[90], bArr4[8], bArr4[100], objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {strArr, new int[1], new int[]{i}, new int[]{i}};
        int i63 = ((int[]) objArr2[1])[0];
        int i64 = ((int[]) objArr2[3])[0];
        int i65 = ((int[]) objArr2[2])[0];
        String[] strArr8 = (String[]) objArr2[0];
        int iIdentityHashCode = System.identityHashCode(this);
        int i66 = ~(528207843 | iIdentityHashCode);
        int i67 = i63 + (-1397829266) + ((1050848 | i66) * (-476)) + (i66 * 952) + ((~((~iIdentityHashCode) | 528207843)) * 476);
        int i68 = (i67 << 13) ^ i67;
        int i69 = i68 ^ (i68 >>> 17);
        ((int[]) objArr44[1])[0] = i69 ^ (i69 << 5);
        int i70 = getARTIFICIAL_FRAME_PACKAGE_NAME + 71;
        artificialFrame = i70 % 128;
        if (i70 % 2 == 0) {
            int i71 = 2 / 2;
        }
    }

    static void accessartificialFrame() {
        IPostMessageService = new char[]{38281, 38376, 38375, 38358, 38355, 38348, 38345, 38361, 38399, 38383, 38350, 38385, 38390, 38361, 38355, 38351, 38356, 38358, 38360, 38361, 38360, 38358, 38191, 38043, 38045, 38043, 38034, 38039, 38047, 38056, 38056, 38048, 38045, 38035, 38037, 38040, 38042, 38281, 38358, 38355, 38348, 38345, 38361, 38399, 38389, 38357, 38360, 38361, 38386, 38392, 38356, 38356, 38362, 38377, 38157, 38173, 38177, 38153, 38156, 38178, 38166, 38144, 38152, 38152, 38149, 38157, 38162, 38160, 38159};
    }

    @Override // android.app.Service
    public void onCreate() {
        int i = 2 % 2;
        int i2 = artificialFrame + 97;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        int i3 = i2 % 2;
        super.onCreate();
        int i4 = artificialFrame + 125;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i4 % 128;
        if (i4 % 2 == 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }
}
