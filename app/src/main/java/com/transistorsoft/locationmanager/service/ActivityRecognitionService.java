package com.transistorsoft.locationmanager.service;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.Nullable;
import ch.qos.logback.core.net.SyslogConstants;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.location.ActivityRecognition;
import com.google.android.gms.location.ActivityRecognitionClient;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.ActivityTransition;
import com.google.android.gms.location.ActivityTransitionEvent;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.ActivityTransitionResult;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.common.base.Ascii;
import com.transistorsoft.locationmanager.adapter.BackgroundGeolocation;
import com.transistorsoft.locationmanager.adapter.TSConfig;
import com.transistorsoft.locationmanager.event.MotionTriggerDelayEvent;
import com.transistorsoft.locationmanager.event.StopTimeoutEvent;
import com.transistorsoft.locationmanager.geofence.TSGeofenceManager;
import com.transistorsoft.locationmanager.lifecycle.LifecycleManager;
import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.locationmanager.logger.TSMediaPlayer;
import com.transistorsoft.locationmanager.scheduler.TSScheduleManager;
import com.transistorsoft.locationmanager.util.LocationAuthorization;
import com.transistorsoft.locationmanager.util.Sensors;
import com.transistorsoft.locationmanager.util.Util;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.io.encoding.Base64;
import kotlin.random.RandomKt;
import net.pluservice.unicoc.R;
import o.ArtificialStackFrames;
import o.build;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes.dex */
public class ActivityRecognitionService extends AbstractService {
    private static char ICustomTabsCallback = 0;
    private static char TopicBuilder = 0;
    private static char extraCallbackWithResult = 0;
    private static char onMessageChannelReady = 0;
    private static final AtomicBoolean q;
    private static final AtomicBoolean r;
    private static final long s = 60000;
    protected static AtomicBoolean t;
    private static ActivityTransitionEvent u;
    private static final String[] v;
    public int mForegroundServiceType = 256;
    private static final byte[] $$c = {Base64.padSymbol, 55, -5, -17};
    private static final int $$f = 243;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$g = {6, 70, -89, 92, -21, -7, 54, -65, -4, -11, -11, -6, -22, -9, -5, 52, -68, -13, 3, -15, -7, -20, -2, -16, 2, -16, -6, -14, 0, 46, -62, -21, -12, 4, 46, -43, -43, -6, 2, -26, 9, -11, -22, Ascii.SYN, -27, -21, -13, 7, -18, 2, -11, Ascii.SYN, -36, -11, -26, -4, -12, -16, 76, -40, -53, -7, -12, 6, -22, -4, -15, -8, -9, -70, -5, -6, -21, -9, -5, 52, -4, -68, -14, -15, 6, -22, -5, 4, -20, 53, -75, -5, 2, -28, 5, -18, -12, -4, 54, -60, -22, 1, -23, -6, -3, -4, 45, -31, -42, -10, -8, -22, -9, 4, -8, 8, -37, 3, -17, -3, -24, 42, -44, -6, -24, -13, 6, -22};
    private static final int $$h = SyslogConstants.LOG_LOCAL7;
    private static final byte[] $$a = {Ascii.DC4, 17, 111, Ascii.ESC, 5, -1, -33, 33, -2, -9, 5, -7, 5, -1, -50, 39, Ascii.VT, -7, -12, Ascii.SI, Ascii.ESC, 1, -7, -6, -33, 51, -12, 3, -8, 1, Ascii.CR};
    private static final int $$b = 61;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;

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
            if (ActivityTransitionResult.hasResult(this.a)) {
                ActivityRecognitionService.this.a(ActivityTransitionResult.extractResult(this.a));
            } else if (ActivityRecognitionResult.hasResult(this.a)) {
                ActivityRecognitionService.this.a(ActivityRecognitionResult.extractResult(this.a));
                ActivityRecognitionService.this.a(false);
            } else {
                ActivityRecognitionService.this.a(false);
            }
            ActivityRecognitionService.this.a(ActivityRecognitionService.r.get());
            ActivityRecognitionService.this.a(this.b);
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002a  */
    /* JADX WARN: Code duplicated, block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x002e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x002a
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$i(short r6, short r7, short r8) {
        /*
            int r6 = r6 * 3
            int r6 = 3 - r6
            int r7 = r7 * 2
            int r7 = 110 - r7
            int r8 = r8 * 4
            int r0 = 1 - r8
            byte[] r1 = com.transistorsoft.locationmanager.service.ActivityRecognitionService.$$c
            byte[] r0 = new byte[r0]
            r2 = 0
            int r8 = 0 - r8
            if (r1 != 0) goto L19
            r7 = r6
            r3 = r8
            r4 = r2
            goto L2e
        L19:
            r3 = r2
            r5 = r7
            r7 = r6
            r6 = r5
        L1d:
            byte r4 = (byte) r6
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            return r6
        L2a:
            int r7 = r7 + 1
            r3 = r1[r7]
        L2e:
            int r6 = r6 + r3
            r3 = r4
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.service.ActivityRecognitionService.$$i(short, short, short):java.lang.String");
    }

    static {
        accessartificialFrame();
        q = new AtomicBoolean(false);
        r = new AtomicBoolean(false);
        t = new AtomicBoolean(false);
        u = new ActivityTransitionEvent(3, 0, 0L);
        v = new String[]{"HUAWEI"};
    }

    private static void b(Context context) {
        ArrayList arrayList = new ArrayList(6);
        arrayList.add(3);
        arrayList.add(2);
        arrayList.add(7);
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(8);
        ArrayList arrayList2 = new ArrayList(12);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            int iIntValue = ((Integer) it2.next()).intValue();
            arrayList2.add(new ActivityTransition.Builder().setActivityType(iIntValue).setActivityTransition(0).build());
            arrayList2.add(new ActivityTransition.Builder().setActivityType(iIntValue).setActivityTransition(1).build());
        }
        ActivityRecognitionClient client = ActivityRecognition.getClient(context);
        PendingIntent pendingIntent = getPendingIntent(context, null);
        client.removeActivityUpdates(pendingIntent);
        client.requestActivityTransitionUpdates(new ActivityTransitionRequest(arrayList2), pendingIntent).addOnFailureListener(new OnFailureListener() { // from class: com.transistorsoft.locationmanager.service.ActivityRecognitionService$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                ActivityRecognitionService.a(exc);
            }
        });
    }

    public static void disableMotionTriggerDelay(Context context) {
        r.set(false);
        stopService(context);
    }

    public static ActivityTransitionEvent getLastActivity() {
        return u;
    }

    public static ActivityTransitionEvent getMostProbableActivity() {
        return u;
    }

    private static PendingIntent getPendingIntent(Context context, @Nullable String str) {
        Context applicationContext = context.getApplicationContext();
        Intent intent = new Intent(applicationContext, (Class<?>) ActivityRecognitionService.class);
        if (str != null) {
            intent.setAction(str);
        }
        return Build.VERSION.SDK_INT >= 26 ? PendingIntent.getForegroundService(applicationContext, 0, intent, Util.getPendingIntentFlags(134217728)) : PendingIntent.getService(applicationContext, 0, intent, 134217728);
    }

    private boolean i() {
        return LifecycleManager.getInstance().isBackground() && !LocationAuthorization.hasBackgroundPermission(getApplicationContext());
    }

    public static boolean isBadVendor() {
        return new ArrayList(Arrays.asList(v)).contains(Build.MANUFACTURER);
    }

    public static boolean isMoving(Context context) {
        return TSConfig.getInstance(context).hasTriggerActivity(u.getActivityType());
    }

    public static boolean isStarted() {
        return t.get();
    }

    public static void start(final Context context) {
        final Context applicationContext = context.getApplicationContext();
        TSConfig tSConfig = TSConfig.getInstance(applicationContext);
        if (tSConfig.getDisableMotionActivityUpdates().booleanValue()) {
            return;
        }
        if (!tSConfig.isLocationTrackingMode()) {
            TSGeofenceManager tSGeofenceManager = TSGeofenceManager.getInstance(applicationContext);
            if (!tSConfig.getGeofenceModeHighAccuracy().booleanValue() || !tSGeofenceManager.hasGeofences()) {
                return;
            }
        }
        if (!LocationAuthorization.hasActivityPermission(applicationContext)) {
            TSLog.logger.warn(TSLog.warn("Cannot start motion-activity updates:  permission is denied"));
            return;
        }
        TSLog.logger.info(TSLog.on("Start motion-activity updates"));
        ActivityRecognitionClient client = ActivityRecognition.getClient(applicationContext);
        if (client == null) {
            return;
        }
        client.requestActivityUpdates(0L, getPendingIntent(applicationContext, null)).addOnSuccessListener(new OnSuccessListener() { // from class: com.transistorsoft.locationmanager.service.ActivityRecognitionService$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                ActivityRecognitionService.a(obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.transistorsoft.locationmanager.service.ActivityRecognitionService$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                ActivityRecognitionService.a(context, applicationContext, exc);
            }
        });
    }

    public static void stop(Context context) {
        TSLog.logger.info(TSLog.off("Stop motion-activity updates"));
        ActivityRecognitionClient client = ActivityRecognition.getClient(context);
        PendingIntent pendingIntent = getPendingIntent(context, null);
        client.removeActivityTransitionUpdates(pendingIntent);
        client.removeActivityUpdates(pendingIntent);
        t.set(false);
        stopService(context);
    }

    private static void stopService(Context context) {
        AbstractService.stop(context, ActivityRecognitionService.class);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002c  */
    /* JADX WARN: Code duplicated, block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x002e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x002c
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void w(int r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.transistorsoft.locationmanager.service.ActivityRecognitionService.$$a
            int r6 = r6 * 3
            int r6 = r6 + 9
            int r8 = r8 * 8
            int r8 = 19 - r8
            int r7 = r7 * 28
            int r7 = 112 - r7
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L17
            r4 = r6
            r7 = r8
            r3 = r2
            goto L2e
        L17:
            r3 = r2
            r5 = r8
            r8 = r7
            r7 = r5
        L1b:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r3 = r3 + 1
            int r7 = r7 + 1
            if (r3 != r6) goto L2c
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2c:
            r4 = r0[r7]
        L2e:
            int r8 = r8 + r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.service.ActivityRecognitionService.w(int, byte, int, java.lang.Object[]):void");
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
    private static void y(short r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 3
            int r8 = 111 - r8
            byte[] r0 = com.transistorsoft.locationmanager.service.ActivityRecognitionService.$$g
            int r7 = r7 + 4
            int r6 = r6 * 2
            int r1 = 65 - r6
            byte[] r1 = new byte[r1]
            int r6 = 64 - r6
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r6
            r8 = r7
            r4 = r2
            goto L2f
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r7 = r7 + 1
            r3 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r3
            r3 = r5
        L2f:
            int r7 = -r7
            int r3 = r3 + r7
            int r7 = r3 + (-9)
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.service.ActivityRecognitionService.y(short, byte, byte, java.lang.Object[]):void");
    }

    @Override // com.transistorsoft.locationmanager.service.AbstractService, android.app.Service
    public void onCreate() {
        if (Build.VERSION.SDK_INT >= 34) {
            super.a(getClass().getSimpleName(), 256);
        } else {
            super.a(getClass().getSimpleName(), 0);
        }
    }

    @Override // com.transistorsoft.locationmanager.service.AbstractService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        boolean zA = super.a(intent, i2, true);
        t.set(zA);
        if (zA) {
            BackgroundGeolocation.getThreadPool().execute(new a(intent, i2));
            return 3;
        }
        r.set(false);
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Object obj) {
        t.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Context context, Context context2, Exception exc) {
        t.set(true);
        try {
            ApiException apiException = (ApiException) ApiException.class.cast(exc);
            TSLog.logger.warn(TSLog.warn("Failed to initiate motion-activity updates (ERROR CODE: " + apiException.getStatusCode() + ", " + apiException.getStatusMessage() + ").  This device does not support the Motion API due to missing sensors (eg: gyroscope, accelerometer)." + Sensors.getInstance(context).print().toString()));
            b(context2);
        } catch (ClassCastException unused) {
            TSLog.logger.warn(TSLog.warn("Failed to initiate motion-activity updates:  " + exc.getMessage() + Sensors.getInstance(context).print().toString()));
            b(context2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:50:0x0135  */
    public void a(ActivityTransitionResult activityTransitionResult) {
        long j;
        Context applicationContext = getApplicationContext();
        if (activityTransitionResult == null) {
            return;
        }
        List<ActivityTransitionEvent> transitionEvents = activityTransitionResult.getTransitionEvents();
        if (transitionEvents == null) {
            TSLog.logger.warn(TSLog.warn("handleActivityTransitionResult received null transitionEvents"));
            return;
        }
        TSConfig tSConfig = TSConfig.getInstance(applicationContext);
        StringBuilder sb = new StringBuilder();
        sb.append(TSLog.header("Motion Transition Result"));
        TSScheduleManager tSScheduleManager = TSScheduleManager.getInstance(applicationContext);
        for (ActivityTransitionEvent activityTransitionEvent : transitionEvents) {
            if (activityTransitionEvent.getTransitionType() == 0) {
                ActivityTransitionEvent activityTransitionEvent2 = u;
                u = activityTransitionEvent;
                sb.append(TSLog.boxRow("🎾  ENTER: " + Util.getActivityName(activityTransitionEvent.getActivityType())));
                EventBus.getDefault().post(activityTransitionEvent);
                boolean zBooleanValue = tSConfig.getIsMoving().booleanValue();
                boolean zHasTriggerActivity = tSConfig.hasTriggerActivity(activityTransitionEvent.getActivityType());
                boolean z = !zBooleanValue && zHasTriggerActivity;
                boolean z2 = zBooleanValue && !zHasTriggerActivity;
                TSLog.logger.debug("*** wasMoving: " + zBooleanValue + ", nowMoving: " + zHasTriggerActivity + ", startedMoving: " + z + ", justStopped; " + z2);
                if (activityTransitionEvent.getActivityType() != 3 && !z2) {
                    if (i() && !tSConfig.getIsMoving().booleanValue()) {
                        TSLog.logger.warn(TSLog.warn("Refused to initiate location-services from MotionTransition event in the background with WhenInUse authorization"));
                    } else if (!z && q.get()) {
                        if (zBooleanValue && tSConfig.isLocationTrackingMode() && tSConfig.getUseSignificantChangesOnly().booleanValue()) {
                            tSScheduleManager.cancelOneShot(StopTimeoutEvent.ACTION);
                            TSMediaPlayer.getInstance().debug(applicationContext, "tslocationmanager_bell_ding_pop");
                        }
                    } else if (tSConfig.isLocationTrackingMode()) {
                        long jLongValue = tSConfig.getMotionTriggerDelay().longValue();
                        if (tSConfig.getUseSignificantChangesOnly().booleanValue()) {
                            j = jLongValue >= 60000 ? jLongValue : 60000L;
                        }
                        if (zHasTriggerActivity && j > 0) {
                            TSMediaPlayer.getInstance().debug(applicationContext, TSMediaPlayer.DOT_RETRY);
                            tSScheduleManager.oneShot(MotionTriggerDelayEvent.ACTION, j, true, true);
                            if (!tSScheduleManager.canScheduleExactAlarms()) {
                                r.set(true);
                            }
                        } else {
                            TrackingService.changePace(applicationContext, zHasTriggerActivity, null);
                        }
                    } else {
                        GeofencingService.changePace(applicationContext, zHasTriggerActivity, null);
                    }
                } else {
                    r.set(false);
                    if (tSConfig.getMotionTriggerDelay().longValue() >= 0 && !zBooleanValue && activityTransitionEvent2.getActivityType() != activityTransitionEvent.getActivityType()) {
                        TSMediaPlayer.getInstance().debug(applicationContext, TSMediaPlayer.DOT_STOP);
                        tSScheduleManager.cancelOneShot(MotionTriggerDelayEvent.ACTION);
                        a(false);
                    }
                    if (tSConfig.getIsMoving().booleanValue()) {
                        if (tSConfig.isLocationTrackingMode()) {
                            if (!q.get()) {
                                TrackingService.changePace(applicationContext, tSConfig.getIsMoving().booleanValue(), null);
                            } else {
                                TrackingService.b(applicationContext);
                            }
                        } else {
                            GeofencingService.changePace(applicationContext, false, null);
                        }
                    }
                }
                q.set(true);
            } else {
                sb.append(TSLog.boxRow("🔴  EXIT: " + Util.getActivityName(activityTransitionEvent.getActivityType())));
            }
        }
        sb.append(TSLog.BOX_BOTTOM);
        TSLog.logger.info(sb.toString());
    }

    private static void x(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        build buildVar = new build();
        char[] cArr2 = new char[cArr.length];
        buildVar.c = 0;
        char[] cArr3 = new char[2];
        while (buildVar.c < cArr.length) {
            cArr3[0] = cArr[buildVar.c];
            cArr3[1] = cArr[buildVar.c + 1];
            int i3 = $10 + 49;
            $11 = i3 % 128;
            int i4 = i3 % 2;
            int i5 = 58224;
            for (int i6 = 0; i6 < 16; i6++) {
                char c = cArr3[1];
                char c2 = cArr3[0];
                try {
                    Object[] objArr2 = {Integer.valueOf(c), Integer.valueOf((c2 + i5) ^ ((c2 << 4) + ((char) (((long) extraCallbackWithResult) ^ (-4408183324873663413L))))), Integer.valueOf(c2 >>> 5), Integer.valueOf(onMessageChannelReady)};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1585798252);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) 0;
                        byte b2 = (byte) (b + 1);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 27, (char) (TextUtils.getOffsetBefore("", 0) + 17263), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 1066, 1042277788, false, $$i(b, b2, (byte) (b2 - 1)), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    char cCharValue = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    cArr3[1] = cCharValue;
                    Object[] objArr3 = {Integer.valueOf(cArr3[0]), Integer.valueOf((cCharValue + i5) ^ ((cCharValue << 4) + ((char) (((long) TopicBuilder) ^ (-4408183324873663413L))))), Integer.valueOf(cCharValue >>> 5), Integer.valueOf(ICustomTabsCallback)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1585798252);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 0;
                        byte b4 = (byte) (b3 + 1);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(27 - ImageFormat.getBitsPerPixel(0), (char) (17263 - (Process.myTid() >> 22)), 1068 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), 1042277788, false, $$i(b3, b4, (byte) (b4 - 1)), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    cArr3[0] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                    i5 -= 40503;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            cArr2[buildVar.c] = cArr3[0];
            cArr2[buildVar.c + 1] = cArr3[1];
            Object[] objArr4 = {buildVar, buildVar};
            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1010141908);
            if (objAccessartificialFrame3 == null) {
                byte b5 = (byte) 0;
                byte b6 = b5;
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(25 - TextUtils.indexOf("", "", 0), (char) (63928 - Drawable.resolveOpacity(0, 0)), 486 - (ViewConfiguration.getFadingEdgeLength() >> 16), 1554985764, false, $$i(b5, b6, b6), new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame3).invoke(null, objArr4);
        }
        String str = new String(cArr2, 0, i);
        int i7 = $10 + 39;
        $11 = i7 % 128;
        int i8 = i7 % 2;
        objArr[0] = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Exception exc) {
        try {
            ApiException apiException = (ApiException) ApiException.class.cast(exc);
            TSLog.logger.warn(TSLog.warn("Failed to initiate activity-transition updates (ERROR CODE: " + apiException.getStatusCode() + ", " + apiException.getStatusMessage() + ").  This device does not support the Motion API due to missing sensors (eg: gyroscope, accelerometer)."));
        } catch (ClassCastException unused) {
            TSLog.logger.warn(TSLog.warn("Failed to initiate activity-transition updates:  " + exc.getMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(ActivityRecognitionResult activityRecognitionResult) {
        r.set(false);
        DetectedActivity mostProbableActivity = activityRecognitionResult.getMostProbableActivity();
        TSLog.logger.debug(TSLog.activity(mostProbableActivity.toString()));
        TSConfig tSConfig = TSConfig.getInstance(getApplicationContext());
        if (!q.get() && tSConfig.getIsMoving().booleanValue() && mostProbableActivity.getType() == 3) {
            if (tSConfig.isLocationTrackingMode()) {
                TrackingService.b(getApplicationContext());
            } else {
                GeofencingService.changePace(getApplicationContext(), false, null);
            }
        }
        b(getApplicationContext());
        return 3;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:23:0x028e A[Catch: all -> 0x0acc, TryCatch #2 {all -> 0x0acc, blocks: (B:59:0x07a7, B:61:0x07bb, B:62:0x07ee, B:21:0x026e, B:23:0x028e, B:24:0x02db), top: B:103:0x026e }] */
    /* JADX WARN: Code duplicated, block: B:27:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:32:0x03ab  */
    /* JADX WARN: Code duplicated, block: B:58:0x0716  */
    /* JADX WARN: Code duplicated, block: B:61:0x07bb A[Catch: all -> 0x0acc, TryCatch #2 {all -> 0x0acc, blocks: (B:59:0x07a7, B:61:0x07bb, B:62:0x07ee, B:21:0x026e, B:23:0x028e, B:24:0x02db), top: B:103:0x026e }] */
    /* JADX WARN: Code duplicated, block: B:65:0x0804  */
    /* JADX WARN: Code duplicated, block: B:70:0x08c8  */
    @Override // com.transistorsoft.locationmanager.service.AbstractService, android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) throws Throwable {
        Object objAccessartificialFrame;
        Object[] objArr;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        int i = 2 % 2;
        int i2 = artificialFrame + 15;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        if (i2 % 2 != 0) {
            super.attachBaseContext(context);
            Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame7 == null) {
                int maximumFlingVelocity = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 25;
                char c = (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 30067);
                int i3 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 816;
                byte[] bArr = $$a;
                byte b = (byte) (bArr[21] - 1);
                Object[] objArr2 = new Object[1];
                w(b, b, (byte) (-bArr[8]), objArr2);
                objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity, c, i3, 721586079, false, (String) objArr2[0], null);
            }
            ((Field) objAccessartificialFrame7).getLong(null);
            throw null;
        }
        super.attachBaseContext(context);
        Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame8 == null) {
            int i4 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 25;
            char cIndexOf = (char) (TextUtils.indexOf("", "", 0) + 30068);
            int iArgb = 816 - Color.argb(0, 0, 0, 0);
            byte[] bArr2 = $$a;
            byte b2 = (byte) (bArr2[21] - 1);
            Object[] objArr3 = new Object[1];
            w(b2, b2, (byte) (-bArr2[8]), objArr3);
            objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i4, cIndexOf, iArgb, 721586079, false, (String) objArr3[0], null);
        }
        long j = ((Field) objAccessartificialFrame8).getLong(null);
        if (j != -1) {
            long j2 = j + 1986;
            Object[] objArr4 = new Object[1];
            x(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 27, new char[]{51249, 65521, 41339, 18796, 41151, 62690, 45183, 18740, 62748, 58020, 42232, 44354, 44084, 37745, 47092, 65524, 38665, 19095, 37335, 41567, 58181, 39928}, objArr4);
            Class<?> cls = Class.forName((String) objArr4[0]);
            Object[] objArr5 = new Object[1];
            x(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 21, new char[]{33689, 45377, 28773, 1382, 63182, 10604, 44301, 18452, 32147, 8560, 6817, 50149, 36015, 59671, 40980, 34631}, objArr5);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i5 = artificialFrame + 3;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i5 % 128;
                int i6 = i5 % 2;
                Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame9 == null) {
                    int trimmedLength = 25 - TextUtils.getTrimmedLength("");
                    char cIndexOf2 = (char) (30068 - TextUtils.indexOf("", "", 0, 0));
                    int size = 816 - View.MeasureSpec.getSize(0);
                    byte b3 = $$a[21];
                    byte b4 = (byte) (b3 - 1);
                    Object[] objArr6 = new Object[1];
                    w(b4, b4, b3, objArr6);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(trimmedLength, cIndexOf2, size, 891606461, false, (String) objArr6[0], null);
                }
                Object[] objArr7 = (Object[]) ((Field) objAccessartificialFrame9).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i7 = ((int[]) objArr7[0])[0];
                int i8 = ((int[]) objArr7[1])[0];
                String[] strArr = (String[]) objArr7[2];
                int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
                int i9 = (-873753044) + (((~((-337641489) | startElapsedRealtime)) | (~((-139469123) | startElapsedRealtime))) * 69) + (((~(startElapsedRealtime | (-702342979))) | (~((-900515345) | startElapsedRealtime)) | 562873856) * (-69)) + 65046309;
                int i10 = (i9 << 13) ^ i9;
                int i11 = i10 ^ (i10 >>> 17);
                ((int[]) objArr[3])[0] = i11 ^ (i11 << 5);
            } else {
                Object[] objArr8 = new Object[1];
                x(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 12, new char[]{19747, 54688, 35901, 25128, 63514, 20463, 51249, 65521, 26577, 63910, 3237, 1156, 30055, 19298, 38120, 60137}, objArr8);
                Class<?> cls2 = Class.forName((String) objArr8[0]);
                Object[] objArr9 = new Object[1];
                x((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 15, new char[]{65383, 1776, 31533, 2877, 43719, 3304, 2385, 43257, 35093, 63715, 10127, 18292, 31438, 56374, 18786, 55893}, objArr9);
                try {
                    Object[] objArr10 = {Integer.valueOf(((Integer) cls2.getMethod((String) objArr9[0], Object.class).invoke(null, this)).intValue()), 0, -1190469500};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame == null) {
                        int touchSlop = 25 - (ViewConfiguration.getTouchSlop() >> 8);
                        char cResolveSize = (char) (30068 - View.resolveSize(0, 0));
                        int i12 = 817 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                        byte b5 = $$a[21];
                        byte b6 = b5;
                        Object[] objArr11 = new Object[1];
                        w(b5, b6, (byte) (b6 - 1), objArr11);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(touchSlop, cResolveSize, i12, -797394565, false, (String) objArr11[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr10);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame2 == null) {
                        int iBlue = Color.blue(0) + 25;
                        char cResolveOpacity = (char) (Drawable.resolveOpacity(0, 0) + 30068);
                        int deadChar = KeyEvent.getDeadChar(0, 0) + 816;
                        byte b7 = $$a[21];
                        byte b8 = (byte) (b7 - 1);
                        Object[] objArr12 = new Object[1];
                        w(b8, b8, b7, objArr12);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iBlue, cResolveOpacity, deadChar, 891606461, false, (String) objArr12[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArr);
                    try {
                        Object[] objArr13 = new Object[1];
                        x(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 13, new char[]{51249, 65521, 41339, 18796, 41151, 62690, 45183, 18740, 62748, 58020, 42232, 44354, 44084, 37745, 47092, 65524, 38665, 19095, 37335, 41567, 58181, 39928}, objArr13);
                        Class<?> cls3 = Class.forName((String) objArr13[0]);
                        Object[] objArr14 = new Object[1];
                        x(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 20, new char[]{33689, 45377, 28773, 1382, 63182, 10604, 44301, 18452, 32147, 8560, 6817, 50149, 36015, 59671, 40980, 34631}, objArr14);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr14[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame3 == null) {
                            int i13 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 24;
                            char offsetBefore = (char) (TextUtils.getOffsetBefore("", 0) + 30068);
                            int minimumFlingVelocity = 816 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                            byte[] bArr3 = $$a;
                            byte b9 = (byte) (bArr3[21] - 1);
                            Object[] objArr15 = new Object[1];
                            w(b9, b9, (byte) (-bArr3[8]), objArr15);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i13, offsetBefore, minimumFlingVelocity, 721586079, false, (String) objArr15[0], null);
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
            x(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 12, new char[]{19747, 54688, 35901, 25128, 63514, 20463, 51249, 65521, 26577, 63910, 3237, 1156, 30055, 19298, 38120, 60137}, objArr16);
            Class<?> cls4 = Class.forName((String) objArr16[0]);
            Object[] objArr17 = new Object[1];
            x((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 15, new char[]{65383, 1776, 31533, 2877, 43719, 3304, 2385, 43257, 35093, 63715, 10127, 18292, 31438, 56374, 18786, 55893}, objArr17);
            Object[] objArr18 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue()), 0, -1190469500};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame == null) {
                int touchSlop2 = 25 - (ViewConfiguration.getTouchSlop() >> 8);
                char cResolveSize2 = (char) (30068 - View.resolveSize(0, 0));
                int i14 = 817 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                byte b10 = $$a[21];
                byte b11 = b10;
                Object[] objArr19 = new Object[1];
                w(b10, b11, (byte) (b11 - 1), objArr19);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(touchSlop2, cResolveSize2, i14, -797394565, false, (String) objArr19[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr18);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame2 == null) {
                int iBlue2 = Color.blue(0) + 25;
                char cResolveOpacity2 = (char) (Drawable.resolveOpacity(0, 0) + 30068);
                int deadChar2 = KeyEvent.getDeadChar(0, 0) + 816;
                byte b12 = $$a[21];
                byte b13 = (byte) (b12 - 1);
                Object[] objArr110 = new Object[1];
                w(b13, b13, b12, objArr110);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iBlue2, cResolveOpacity2, deadChar2, 891606461, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArr);
            Object[] objArr111 = new Object[1];
            x(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 13, new char[]{51249, 65521, 41339, 18796, 41151, 62690, 45183, 18740, 62748, 58020, 42232, 44354, 44084, 37745, 47092, 65524, 38665, 19095, 37335, 41567, 58181, 39928}, objArr111);
            Class<?> cls5 = Class.forName((String) objArr111[0]);
            Object[] objArr112 = new Object[1];
            x(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 20, new char[]{33689, 45377, 28773, 1382, 63182, 10604, 44301, 18452, 32147, 8560, 6817, 50149, 36015, 59671, 40980, 34631}, objArr112);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr112[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame3 == null) {
                int i15 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 24;
                char offsetBefore2 = (char) (TextUtils.getOffsetBefore("", 0) + 30068);
                int minimumFlingVelocity2 = 816 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                byte[] bArr4 = $$a;
                byte b14 = (byte) (bArr4[21] - 1);
                Object[] objArr113 = new Object[1];
                w(b14, b14, (byte) (-bArr4[8]), objArr113);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i15, offsetBefore2, minimumFlingVelocity2, 721586079, false, (String) objArr113[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i16 = ((int[]) objArr[1])[0];
        int i17 = ((int[]) objArr[0])[0];
        if (i17 == i16) {
            Object[] objArr20 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i18 = ((int[]) objArr[3])[0];
            int i19 = ((int[]) objArr[0])[0];
            int i20 = ((int[]) objArr[1])[0];
            String[] strArr2 = (String[]) objArr[2];
            int i21 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().densityDpi;
            int i22 = ~i21;
            int i23 = i18 + (-1547690546) + (((~(i22 | (-146549302))) | 344721667) * (-1042)) + (((-146549302) | i21) * 521) + (((~(i21 | (-344721668))) | 335544578 | (~(i22 | (-137372213)))) * 521);
            int i24 = (i23 << 13) ^ i23;
            int i25 = i24 ^ (i24 >>> 17);
            ((int[]) objArr20[3])[0] = i25 ^ (i25 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr[2];
            if (strArr3 != null) {
                for (String str : strArr3) {
                    int i26 = artificialFrame + 59;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i26 % 128;
                    int i27 = i26 % 2;
                    arrayList.add(str);
                }
            }
            long j3 = ((long) (i16 ^ i17)) ^ (((long) 292754351) << 32);
            long j4 = 292754350;
            int i28 = getARTIFICIAL_FRAME_PACKAGE_NAME + 3;
            artificialFrame = i28 % 128;
            int i29 = i28 % 2;
            try {
                Object[] objArr21 = {Long.valueOf(j3), Long.valueOf(j4)};
                byte[] bArr5 = $$g;
                Object[] objArr22 = new Object[1];
                y(bArr5[28], (byte) (-bArr5[97]), bArr5[33], objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                byte b15 = (byte) (-bArr5[103]);
                byte b16 = (byte) (b15 | 32);
                Object[] objArr23 = new Object[1];
                y(b15, b16, (byte) (b16 & 89), objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i30 = ((int[]) objArr[3])[0];
                int i31 = ((int[]) objArr[0])[0];
                int i32 = ((int[]) objArr[1])[0];
                String[] strArr4 = (String[]) objArr[2];
                int i33 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().orientation;
                int i34 = ~i33;
                int i35 = i30 + (((~(352255990 | i34)) | (~((-72386613) | i33))) * 988) + 806913961 + (((~(i33 | 81697012)) | 270558978 | (~(i34 | (-72386613)))) * 988);
                int i36 = (i35 << 13) ^ i35;
                int i37 = i36 ^ (i36 >>> 17);
                ((int[]) objArr24[3])[0] = i37 ^ (i37 << 5);
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
            int iMyTid = (Process.myTid() >> 22) + 26;
            char tapTimeout = (char) (ViewConfiguration.getTapTimeout() >> 16);
            int iMyTid2 = (Process.myTid() >> 22) + 1041;
            byte[] bArr6 = $$a;
            byte b17 = (byte) (bArr6[21] - 1);
            Object[] objArr25 = new Object[1];
            w(b17, b17, (byte) (-bArr6[8]), objArr25);
            objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iMyTid, tapTimeout, iMyTid2, 2061780482, false, (String) objArr25[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame10).getLong(null);
        if (j5 != -1) {
            long j6 = j5 + 4611686018427387913L;
            Object[] objArr26 = new Object[1];
            x((ViewConfiguration.getPressedStateDuration() >> 16) + 22, new char[]{51249, 65521, 41339, 18796, 41151, 62690, 45183, 18740, 62748, 58020, 42232, 44354, 44084, 37745, 47092, 65524, 38665, 19095, 37335, 41567, 58181, 39928}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            x(15 - View.resolveSize(0, 0), new char[]{33689, 45377, 28773, 1382, 63182, 10604, 44301, 18452, 32147, 8560, 6817, 50149, 36015, 59671, 40980, 34631}, objArr27);
            if (j6 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame11 == null) {
                    int bitsPerPixel = ImageFormat.getBitsPerPixel(0) + 27;
                    char cIndexOf3 = (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0'));
                    int capsMode = TextUtils.getCapsMode("", 0, 0) + 1041;
                    byte b18 = $$a[21];
                    byte b19 = (byte) (b18 - 1);
                    Object[] objArr28 = new Object[1];
                    w(b19, b19, b18, objArr28);
                    objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(bitsPerPixel, cIndexOf3, capsMode, 1145017376, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame11).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i38 = ((int[]) objArr29[3])[0];
                int i39 = ((int[]) objArr29[2])[0];
                String[] strArr5 = (String[]) objArr29[0];
                int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 1692019152;
                int i40 = ~iCodePointAt;
                int i41 = (-702192220) + (((~(666763328 | i40)) | 744867135) * (-90)) + (((~(666763328 | iCodePointAt)) | 60424256) * (-45)) + (((~(iCodePointAt | (-744867136))) | 666763328 | (~(i40 | 744867135))) * 45) + 2017588400;
                int i42 = (i41 << 13) ^ i41;
                int i43 = i42 ^ (i42 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i43 ^ (i43 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                x(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) - 21, new char[]{19747, 54688, 35901, 25128, 63514, 20463, 51249, 65521, 26577, 63910, 3237, 1156, 30055, 19298, 38120, 60137}, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                x(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 33, new char[]{65383, 1776, 31533, 2877, 43719, 3304, 2385, 43257, 35093, 63715, 10127, 18292, 31438, 56374, 18786, 55893}, objArr31);
                int iIntValue = ((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue();
                Object[] objArr32 = {1315560196};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(8 - Gravity.getAbsoluteGravity(0, 0), (char) (22251 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))), 1033 - (ViewConfiguration.getLongPressTimeout() >> 16), 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = RandomKt.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr32), 2017588400, false);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame5 == null) {
                    int capsMode2 = TextUtils.getCapsMode("", 0, 0) + 26;
                    char maximumFlingVelocity2 = (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                    int i44 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1041;
                    byte b20 = $$a[21];
                    byte b21 = (byte) (b20 - 1);
                    Object[] objArr33 = new Object[1];
                    w(b21, b21, b20, objArr33);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(capsMode2, maximumFlingVelocity2, i44, 1145017376, false, (String) objArr33[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Object[] objArr34 = new Object[1];
                    x(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 13, new char[]{51249, 65521, 41339, 18796, 41151, 62690, 45183, 18740, 62748, 58020, 42232, 44354, 44084, 37745, 47092, 65524, 38665, 19095, 37335, 41567, 58181, 39928}, objArr34);
                    Class<?> cls9 = Class.forName((String) objArr34[0]);
                    Object[] objArr35 = new Object[1];
                    x(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 6, new char[]{33689, 45377, 28773, 1382, 63182, 10604, 44301, 18452, 32147, 8560, 6817, 50149, 36015, 59671, 40980, 34631}, objArr35);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr35[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame6 == null) {
                        int scrollBarSize = (ViewConfiguration.getScrollBarSize() >> 8) + 26;
                        char cNormalizeMetaState = (char) KeyEvent.normalizeMetaState(0);
                        int i45 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 1041;
                        byte[] bArr7 = $$a;
                        byte b22 = (byte) (bArr7[21] - 1);
                        Object[] objArr36 = new Object[1];
                        w(b22, b22, (byte) (-bArr7[8]), objArr36);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(scrollBarSize, cNormalizeMetaState, i45, 2061780482, false, (String) objArr36[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr37 = new Object[1];
            x(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) - 21, new char[]{19747, 54688, 35901, 25128, 63514, 20463, 51249, 65521, 26577, 63910, 3237, 1156, 30055, 19298, 38120, 60137}, objArr37);
            Class<?> cls10 = Class.forName((String) objArr37[0]);
            Object[] objArr38 = new Object[1];
            x(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 33, new char[]{65383, 1776, 31533, 2877, 43719, 3304, 2385, 43257, 35093, 63715, 10127, 18292, 31438, 56374, 18786, 55893}, objArr38);
            int iIntValue2 = ((Integer) cls10.getMethod((String) objArr38[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr39 = {1315560196};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(8 - Gravity.getAbsoluteGravity(0, 0), (char) (22251 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))), 1033 - (ViewConfiguration.getLongPressTimeout() >> 16), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = RandomKt.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr39), 2017588400, false);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame5 == null) {
                int capsMode3 = TextUtils.getCapsMode("", 0, 0) + 26;
                char maximumFlingVelocity3 = (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                int i46 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1041;
                byte b23 = $$a[21];
                byte b24 = (byte) (b23 - 1);
                Object[] objArr310 = new Object[1];
                w(b24, b24, b23, objArr310);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(capsMode3, maximumFlingVelocity3, i46, 1145017376, false, (String) objArr310[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr311 = new Object[1];
            x(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 13, new char[]{51249, 65521, 41339, 18796, 41151, 62690, 45183, 18740, 62748, 58020, 42232, 44354, 44084, 37745, 47092, 65524, 38665, 19095, 37335, 41567, 58181, 39928}, objArr311);
            Class<?> cls11 = Class.forName((String) objArr311[0]);
            Object[] objArr312 = new Object[1];
            x(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 6, new char[]{33689, 45377, 28773, 1382, 63182, 10604, 44301, 18452, 32147, 8560, 6817, 50149, 36015, 59671, 40980, 34631}, objArr312);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr312[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame6 == null) {
                int scrollBarSize2 = (ViewConfiguration.getScrollBarSize() >> 8) + 26;
                char cNormalizeMetaState2 = (char) KeyEvent.normalizeMetaState(0);
                int i47 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 1041;
                byte[] bArr8 = $$a;
                byte b25 = (byte) (bArr8[21] - 1);
                Object[] objArr313 = new Object[1];
                w(b25, b25, (byte) (-bArr8[8]), objArr313);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(scrollBarSize2, cNormalizeMetaState2, i47, 2061780482, false, (String) objArr313[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i48 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i49 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i49 == i48) {
            Object[] objArr40 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i50 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i51 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i52 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr6 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int i53 = ~(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 1159244902);
            int i54 = i50 + 144223304 + (((~((-47280482) | i53)) | (-30823326)) * (-983)) + (((~(i53 | (-30823326))) | android.R.color.lockscreen_clock_am_pm) * 983);
            int i55 = (i54 << 13) ^ i54;
            int i56 = i55 ^ (i55 >>> 17);
            ((int[]) objArr40[1])[0] = i56 ^ (i56 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        if (strArr7 != null) {
            for (String str2 : strArr7) {
                arrayList2.add(str2);
            }
        }
        Object[] objArr41 = {Long.valueOf(((long) (i48 ^ i49)) ^ (((long) 1365703739) << 32)), Long.valueOf(1365703737)};
        byte[] bArr9 = $$g;
        Object[] objArr42 = new Object[1];
        y(bArr9[90], (byte) (-bArr9[7]), bArr9[28], objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        byte b26 = (byte) (-bArr9[103]);
        byte b27 = (byte) (b26 | 32);
        Object[] objArr43 = new Object[1];
        y(b26, b27, (byte) (b27 & 89), objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {strArr, new int[1], new int[]{i}, new int[]{i}};
        int i57 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
        int i58 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        int i59 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        String[] strArr8 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 134456629;
        int i60 = 695066218 + ((length | 174070546) * (-50));
        int i61 = ~((-171968769) | length);
        int i62 = ~length;
        int i63 = i57 + i60 + ((i61 | (~(267935507 | i62))) * 50) + (((~(i62 | 174070546)) | (~(95966739 | i62)) | (-267935508)) * 50);
        int i64 = (i63 << 13) ^ i63;
        int i65 = i64 ^ (i64 >>> 17);
        ((int[]) objArr44[1])[0] = i65 ^ (i65 << 5);
    }

    static void accessartificialFrame() {
        TopicBuilder = (char) 42717;
        ICustomTabsCallback = (char) 36512;
        extraCallbackWithResult = (char) 24010;
        onMessageChannelReady = (char) 55829;
    }
}
