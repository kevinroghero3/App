package com.google.firebase.messaging;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.privacysandbox.ads.adservices.adid.AdIdManager$Api33Ext4Impl$$ExternalSyntheticLambda6;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.material.carousel.KeylineState;
import com.google.common.base.Ascii;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import o.ArtificialStackFrames;
import o.onRelationshipValidationResult;

/* JADX INFO: loaded from: classes5.dex */
public abstract class EnhancedIntentService extends Service {
    static final long MESSAGE_TIMEOUT_S = 20;
    private static final String TAG = "EnhancedIntentService";
    private Binder binder;
    private int lastStartId;
    private static final byte[] $$c = {75, -114, 87, -99};
    private static final int $$f = 91;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$m = {2, -89, -33, -54, 2, 3, Ascii.DC2, 6, 2, -55, 1, 65, Ascii.VT, Ascii.FF, -9, 19, 2, -7, 17, -56, 79, 2, -63, 42, Ascii.EM, 2, 17, -15, Ascii.DC4, 3, -9, 34, -6, Ascii.SO, 0, Ascii.NAK, -74, 57, 33, -3, 17, -9, 19, -24, 19, Ascii.CAN, -2, 6, 67, Ascii.DC2, 4, -57, 62, 1, 8, 8, 3, 19, 6, 2, -55, 65, 10, -6, Ascii.FF, 4, 17, -1, Ascii.CR, -5, Ascii.CR, 3, Ascii.VT, -3, -49, 59, Ascii.DC2, 9, -7, -49, 40, 40, 3, -5, Ascii.ETB, -12, 8, 19, -25, Ascii.CAN, Ascii.DC2, 10, -10, Ascii.SI, -5, 8, -25, 33, 8, Ascii.ETB, 1, 9, Ascii.CR, -79, 37, 50, 4, 9, -9, 19, 1, Ascii.FF, 5};
    private static final int $$n = 114;
    private static final byte[] $$a = {38, -81, -30, 49, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13};
    private static final int $$b = 7;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static long onPostMessage = -3977197489521286329L;
    final ExecutorService executor = FcmExecutors.newIntentHandleExecutor();
    private final Object lock = new Object();
    private int runningTasks = 0;

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$i(short r6, short r7, int r8) {
        /*
            int r8 = r8 * 4
            int r8 = 4 - r8
            int r7 = r7 * 2
            int r7 = r7 + 111
            int r6 = r6 * 2
            int r0 = r6 + 1
            byte[] r1 = com.google.firebase.messaging.EnhancedIntentService.$$c
            byte[] r0 = new byte[r0]
            r2 = 0
            if (r1 != 0) goto L16
            r3 = r8
            r4 = r2
            goto L2a
        L16:
            r3 = r2
        L17:
            byte r4 = (byte) r7
            r0[r3] = r4
            if (r3 != r6) goto L22
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            return r6
        L22:
            int r3 = r3 + 1
            r4 = r1[r8]
            r5 = r3
            r3 = r8
            r8 = r4
            r4 = r5
        L2a:
            int r8 = -r8
            int r3 = r3 + 1
            int r7 = r7 + r8
            r8 = r3
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.EnhancedIntentService.$$i(short, short, int):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002d  */
    /* JADX WARN: Code duplicated, block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x0033). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x002d
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(byte r5, byte r6, int r7, java.lang.Object[] r8) {
        /*
            int r5 = r5 * 8
            int r5 = 19 - r5
            int r7 = r7 * 3
            int r0 = r7 + 9
            int r6 = r6 * 28
            int r6 = 112 - r6
            byte[] r1 = com.google.firebase.messaging.EnhancedIntentService.$$a
            byte[] r0 = new byte[r0]
            int r7 = r7 + 8
            r2 = -1
            if (r1 != 0) goto L18
            r3 = r2
            r2 = r5
            goto L33
        L18:
            r4 = r6
            r6 = r5
            r5 = r4
        L1b:
            int r2 = r2 + 1
            byte r3 = (byte) r5
            r0[r2] = r3
            int r6 = r6 + 1
            if (r2 != r7) goto L2d
            java.lang.String r5 = new java.lang.String
            r6 = 0
            r5.<init>(r0, r6)
            r8[r6] = r5
            return
        L2d:
            r3 = r1[r6]
            r4 = r2
            r2 = r6
            r6 = r3
            r3 = r4
        L33:
            int r6 = -r6
            int r5 = r5 + r6
            r6 = r2
            r2 = r3
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.EnhancedIntentService.b(byte, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void d(short r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.google.firebase.messaging.EnhancedIntentService.$$m
            int r8 = r8 * 3
            int r8 = 111 - r8
            int r1 = 65 - r7
            int r6 = r6 + 4
            byte[] r1 = new byte[r1]
            int r7 = 64 - r7
            r2 = 0
            if (r0 != 0) goto L15
            r8 = r6
            r4 = r7
            r3 = r2
            goto L2c
        L15:
            r3 = r2
        L16:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r6 = r6 + 1
            if (r3 != r7) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r8
            r8 = r6
            r6 = r5
        L2c:
            int r6 = r6 + r4
            int r6 = r6 + (-6)
            r5 = r8
            r8 = r6
            r6 = r5
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.EnhancedIntentService.d(short, int, byte, java.lang.Object[]):void");
    }

    protected Intent getStartCommandIntent(Intent intent) {
        return intent;
    }

    public abstract void handleIntent(Intent intent);

    public boolean handleIntentOnMainThread(Intent intent) {
        return false;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        Binder binder;
        synchronized (this) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Service received bind request");
            }
            if (this.binder == null) {
                this.binder = new WithinAppServiceBinder(new WithinAppServiceBinder.IntentHandler() { // from class: com.google.firebase.messaging.EnhancedIntentService.1
                    @Override // com.google.firebase.messaging.WithinAppServiceBinder.IntentHandler
                    public Task<Void> handle(Intent intent2) {
                        return EnhancedIntentService.this.processIntent(intent2);
                    }
                });
            }
            binder = this.binder;
        }
        return binder;
    }

    private static void c(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        onRelationshipValidationResult onrelationshipvalidationresult = new onRelationshipValidationResult();
        char[] cArrAccessartificialFrame = onRelationshipValidationResult.accessartificialFrame(onPostMessage ^ 2573525503365829440L, cArr, i);
        onrelationshipvalidationresult.e = 4;
        int i3 = $10 + 75;
        $11 = i3 % 128;
        int i4 = i3 % 2;
        while (onrelationshipvalidationresult.e < cArrAccessartificialFrame.length) {
            int i5 = $11 + 47;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            onrelationshipvalidationresult.d = onrelationshipvalidationresult.e - 4;
            int i7 = onrelationshipvalidationresult.e;
            try {
                Object[] objArr2 = {Long.valueOf(cArrAccessartificialFrame[onrelationshipvalidationresult.e] ^ cArrAccessartificialFrame[onrelationshipvalidationresult.e % 4]), Long.valueOf(onrelationshipvalidationresult.d), Long.valueOf(onPostMessage)};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(797310229);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0', 0) + 28, (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 30689), TextUtils.indexOf((CharSequence) "", '0') + 189, -1327449315, false, "k", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                }
                cArrAccessartificialFrame[i7] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                try {
                    Object[] objArr3 = {onrelationshipvalidationresult, onrelationshipvalidationresult};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(321542193);
                    if (objAccessartificialFrame2 == null) {
                        byte b = (byte) 0;
                        byte b2 = b;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(33 - View.resolveSizeAndState(0, 0, 0), (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1), 1483 - View.resolveSize(0, 0), -1940971975, false, $$i(b, b2, b2), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        objArr[0] = new String(cArrAccessartificialFrame, 4, cArrAccessartificialFrame.length - 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task<Void> processIntent(final Intent intent) {
        if (handleIntentOnMainThread(intent)) {
            return Tasks.forResult(null);
        }
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.executor.execute(new Runnable() { // from class: com.google.firebase.messaging.EnhancedIntentService$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processIntent$0(intent, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processIntent$0(Intent intent, TaskCompletionSource taskCompletionSource) {
        try {
            handleIntent(intent);
        } finally {
            taskCompletionSource.setResult(null);
        }
    }

    @Override // android.app.Service
    public final int onStartCommand(final Intent intent, int i, int i2) {
        synchronized (this.lock) {
            this.lastStartId = i2;
            this.runningTasks++;
        }
        Intent startCommandIntent = getStartCommandIntent(intent);
        if (startCommandIntent == null) {
            finishTask(intent);
            return 2;
        }
        Task<Void> taskProcessIntent = processIntent(startCommandIntent);
        if (taskProcessIntent.isComplete()) {
            finishTask(intent);
            return 2;
        }
        taskProcessIntent.addOnCompleteListener(new AdIdManager$Api33Ext4Impl$$ExternalSyntheticLambda6(), new OnCompleteListener() { // from class: com.google.firebase.messaging.EnhancedIntentService$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f$0.lambda$onStartCommand$1(intent, task);
            }
        });
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStartCommand$1(Intent intent, Task task) {
        finishTask(intent);
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.executor.shutdown();
        super.onDestroy();
    }

    private void finishTask(Intent intent) {
        if (intent != null) {
            WakeLockHolder.completeWakefulIntent(intent);
        }
        synchronized (this.lock) {
            int i = this.runningTasks - 1;
            this.runningTasks = i;
            if (i == 0) {
                stopSelfResultHook(this.lastStartId);
            }
        }
    }

    boolean stopSelfResultHook(int i) {
        return stopSelfResult(i);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x017b  */
    /* JADX WARN: Code duplicated, block: B:16:0x0213 A[Catch: all -> 0x09db, TryCatch #2 {all -> 0x09db, blocks: (B:54:0x06df, B:56:0x06ff, B:57:0x074b, B:14:0x01ff, B:16:0x0213, B:17:0x0247), top: B:98:0x01ff }] */
    /* JADX WARN: Code duplicated, block: B:20:0x025d  */
    /* JADX WARN: Code duplicated, block: B:25:0x0309  */
    /* JADX WARN: Code duplicated, block: B:53:0x0657  */
    /* JADX WARN: Code duplicated, block: B:56:0x06ff A[Catch: all -> 0x09db, TryCatch #2 {all -> 0x09db, blocks: (B:54:0x06df, B:56:0x06ff, B:57:0x074b, B:14:0x01ff, B:16:0x0213, B:17:0x0247), top: B:98:0x01ff }] */
    /* JADX WARN: Code duplicated, block: B:60:0x075d  */
    /* JADX WARN: Code duplicated, block: B:65:0x082d  */
    @Override // android.app.Service, android.content.ContextWrapper
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
            int iIndexOf = TextUtils.indexOf((CharSequence) "", '0') + 27;
            char c = (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
            int i2 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 1040;
            byte b = $$a[8];
            byte b2 = (byte) (b - 2);
            Object[] objArr2 = new Object[1];
            b(b, b2, b2, objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iIndexOf, c, i2, 2061780482, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 4611686018427387883L;
            Object[] objArr3 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 34, new char[]{30752, 50754, 32690, 30785, 46635, 40920, 33589, 47187, 62984, 57340, 49997, 63607, 54098, 13838, 8154, 844, 14349, 30314, 24484, 17246, 30781, 46710, 40864, 33720, 47311, 63162}, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            c(1 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), new char[]{58875, 10713, 8326, 58782, 22962, 49385, 58379, 9620, 6559, 32968, 41997, 26022, 46190, 55687, 16556, 25687, 42438, 39407, 129}, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i3 = getARTIFICIAL_FRAME_PACKAGE_NAME + 19;
                artificialFrame = i3 % 128;
                int i4 = i3 % 2;
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame8 == null) {
                    int iMyPid = 26 - (Process.myPid() >> 22);
                    char fadingEdgeLength = (char) (ViewConfiguration.getFadingEdgeLength() >> 16);
                    int bitsPerPixel = ImageFormat.getBitsPerPixel(0) + 1042;
                    byte b3 = $$a[5];
                    byte b4 = (byte) (b3 - 1);
                    Object[] objArr5 = new Object[1];
                    b(b3, b4, b4, objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iMyPid, fadingEdgeLength, bitsPerPixel, 1145017376, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i5 = ((int[]) objArr6[3])[0];
                int i6 = ((int[]) objArr6[2])[0];
                String[] strArr = (String[]) objArr6[0];
                int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
                int i7 = 456950926 + ((~(iElapsedRealtime | 29986810)) * JfifUtil.MARKER_SOI);
                int i8 = ~iElapsedRealtime;
                int i9 = i7 + (((-35008517) | i8) * (-216)) + (((~(i8 | 29986810)) | 48116996) * JfifUtil.MARKER_SOI) + 1133386410;
                int i10 = (i9 << 13) ^ i9;
                int i11 = i10 ^ (i10 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i11 ^ (i11 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 3, new char[]{54037, 36080, 11154, 54143, 64662, 52202, 54580, 4903, 48319, 35801, 38175, 21322, 34112, 31969, 19335, 21876, 37682, 15583, 2965, 5444}, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 34, new char[]{41400, 37476, 11326, 41425, 57863, 52309, 14302, 25040, 41518, 35936, 30701, 8648, 26533, 25146, 19467, 46976, 57775, 8784, 3128, 63401}, objArr8);
                int iIntValue = ((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue();
                try {
                    Object[] objArr9 = {1151321646};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(9 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (((Process.getThreadPriority(0) + 20) >> 6) + 22251), (-16776183) - Color.rgb(0, 0, 0), 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = KeylineState.Keyline.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr9), 1133386410, false);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame2 == null) {
                        int iBlue = 26 - Color.blue(0);
                        char cResolveSize = (char) View.resolveSize(0, 0);
                        int iIndexOf2 = TextUtils.indexOf("", "") + 1041;
                        byte b5 = $$a[5];
                        byte b6 = (byte) (b5 - 1);
                        Object[] objArr10 = new Object[1];
                        b(b5, b6, b6, objArr10);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iBlue, cResolveSize, iIndexOf2, 1145017376, false, (String) objArr10[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
                    try {
                        Object[] objArr11 = new Object[1];
                        c((ViewConfiguration.getWindowTouchSlop() >> 8) + 1, new char[]{30752, 50754, 32690, 30785, 46635, 40920, 33589, 47187, 62984, 57340, 49997, 63607, 54098, 13838, 8154, 844, 14349, 30314, 24484, 17246, 30781, 46710, 40864, 33720, 47311, 63162}, objArr11);
                        Class<?> cls3 = Class.forName((String) objArr11[0]);
                        Object[] objArr12 = new Object[1];
                        c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 3, new char[]{58875, 10713, 8326, 58782, 22962, 49385, 58379, 9620, 6559, 32968, 41997, 26022, 46190, 55687, 16556, 25687, 42438, 39407, 129}, objArr12);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr12[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame3 == null) {
                            int deadChar = KeyEvent.getDeadChar(0, 0) + 26;
                            char c2 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                            int i12 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 1040;
                            byte b7 = $$a[8];
                            byte b8 = (byte) (b7 - 2);
                            Object[] objArr13 = new Object[1];
                            b(b7, b8, b8, objArr13);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(deadChar, c2, i12, 2061780482, false, (String) objArr13[0], null);
                        }
                        ((Field) objAccessartificialFrame3).set(null, lValueOf);
                        int i13 = getARTIFICIAL_FRAME_PACKAGE_NAME + 83;
                        artificialFrame = i13 % 128;
                        int i14 = i13 % 2;
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
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 3, new char[]{54037, 36080, 11154, 54143, 64662, 52202, 54580, 4903, 48319, 35801, 38175, 21322, 34112, 31969, 19335, 21876, 37682, 15583, 2965, 5444}, objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 34, new char[]{41400, 37476, 11326, 41425, 57863, 52309, 14302, 25040, 41518, 35936, 30701, 8648, 26533, 25146, 19467, 46976, 57775, 8784, 3128, 63401}, objArr15);
            int iIntValue2 = ((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr16 = {1151321646};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(9 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (((Process.getThreadPriority(0) + 20) >> 6) + 22251), (-16776183) - Color.rgb(0, 0, 0), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = KeylineState.Keyline.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr16), 1133386410, false);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame2 == null) {
                int iBlue2 = 26 - Color.blue(0);
                char cResolveSize2 = (char) View.resolveSize(0, 0);
                int iIndexOf3 = TextUtils.indexOf("", "") + 1041;
                byte b9 = $$a[5];
                byte b10 = (byte) (b9 - 1);
                Object[] objArr17 = new Object[1];
                b(b9, b10, b10, objArr17);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iBlue2, cResolveSize2, iIndexOf3, 1145017376, false, (String) objArr17[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr18 = new Object[1];
            c((ViewConfiguration.getWindowTouchSlop() >> 8) + 1, new char[]{30752, 50754, 32690, 30785, 46635, 40920, 33589, 47187, 62984, 57340, 49997, 63607, 54098, 13838, 8154, 844, 14349, 30314, 24484, 17246, 30781, 46710, 40864, 33720, 47311, 63162}, objArr18);
            Class<?> cls5 = Class.forName((String) objArr18[0]);
            Object[] objArr19 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 3, new char[]{58875, 10713, 8326, 58782, 22962, 49385, 58379, 9620, 6559, 32968, 41997, 26022, 46190, 55687, 16556, 25687, 42438, 39407, 129}, objArr19);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr19[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame3 == null) {
                int deadChar2 = KeyEvent.getDeadChar(0, 0) + 26;
                char c3 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                int i15 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 1040;
                byte b11 = $$a[8];
                byte b12 = (byte) (b11 - 2);
                Object[] objArr110 = new Object[1];
                b(b11, b12, b12, objArr110);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(deadChar2, c3, i15, 2061780482, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
            int i16 = getARTIFICIAL_FRAME_PACKAGE_NAME + 83;
            artificialFrame = i16 % 128;
            int i17 = i16 % 2;
        }
        int i18 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i19 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i19 == i18) {
            Object[] objArr20 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i20 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i21 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i22 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iIdentityHashCode = System.identityHashCode(this);
            int i23 = i20 + 629010982 + (((-839362649) | iIdentityHashCode) * (-381)) + (((~((~iIdentityHashCode) | (-845146205))) | 89670919) * 381) + 1969588984;
            int i24 = (i23 << 13) ^ i23;
            int i25 = i24 ^ (i24 >>> 17);
            ((int[]) objArr20[1])[0] = i25 ^ (i25 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr3 != null) {
                int i26 = getARTIFICIAL_FRAME_PACKAGE_NAME + 117;
                artificialFrame = i26 % 128;
                for (int i27 = i26 % 2 == 0 ? 1 : 0; i27 < strArr3.length; i27++) {
                    arrayList.add(strArr3[i27]);
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf(((long) (i18 ^ i19)) ^ (((long) (-971385756)) << 32)), Long.valueOf(-971385754)};
                byte[] bArr = $$m;
                Object[] objArr22 = new Object[1];
                d(bArr[67], bArr[35], bArr[34], objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                d(bArr[23], bArr[52], bArr[24], objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i28 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i29 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i30 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int i31 = (int) Runtime.getRuntime().totalMemory();
                int i32 = ~i31;
                int i33 = i28 + (-2105834626) + ((541102274 | i32) * (-192)) + (((~(608751811 | i32)) | 145753344) * (-384)) + (((~(i31 | (-67649538))) | (~(i32 | 754505155)) | (~((-145753345) | i31))) * JfifUtil.MARKER_SOFn);
                int i34 = (i33 << 13) ^ i33;
                int i35 = i34 ^ (i34 >>> 17);
                ((int[]) objArr24[1])[0] = i35 ^ (i35 << 5);
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
            int iLastIndexOf = TextUtils.lastIndexOf("", '0') + 26;
            char longPressTimeout = (char) (30068 - (ViewConfiguration.getLongPressTimeout() >> 16));
            int packedPositionChild = 815 - ExpandableListView.getPackedPositionChild(0L);
            byte b13 = $$a[8];
            byte b14 = (byte) (b13 - 2);
            Object[] objArr25 = new Object[1];
            b(b13, b14, b14, objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, longPressTimeout, packedPositionChild, 721586079, false, (String) objArr25[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j3 != -1) {
            long j4 = j3 + 2010;
            Object[] objArr26 = new Object[1];
            c(View.resolveSizeAndState(0, 0, 0) + 1, new char[]{30752, 50754, 32690, 30785, 46635, 40920, 33589, 47187, 62984, 57340, 49997, 63607, 54098, 13838, 8154, 844, 14349, 30314, 24484, 17246, 30781, 46710, 40864, 33720, 47311, 63162}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 20, new char[]{58875, 10713, 8326, 58782, 22962, 49385, 58379, 9620, 6559, 32968, 41997, 26022, 46190, 55687, 16556, 25687, 42438, 39407, 129}, objArr27);
            if (j4 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i36 = getARTIFICIAL_FRAME_PACKAGE_NAME + 101;
                artificialFrame = i36 % 128;
                int i37 = i36 % 2;
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame10 == null) {
                    int maximumDrawingCacheSize = 25 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                    char cMyPid = (char) (30068 - (Process.myPid() >> 22));
                    int size = 816 - View.MeasureSpec.getSize(0);
                    byte b15 = $$a[5];
                    byte b16 = (byte) (b15 - 1);
                    Object[] objArr28 = new Object[1];
                    b(b15, b16, b16, objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize, cMyPid, size, 891606461, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i38 = ((int[]) objArr29[0])[0];
                int i39 = ((int[]) objArr29[1])[0];
                String[] strArr5 = (String[]) objArr29[2];
                int mode = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getMode();
                int i40 = ~mode;
                int i41 = (((1090925989 + ((((~((-1009454672) | i40)) | 203423822) | (~(811282305 | i40))) * (-1136))) + ((((~((-1009454672) | mode)) | (~(811282305 | mode))) | (~((-5251457) | i40))) * (-568))) + (((~(mode | (-203423823))) | ((~(i40 | (-811282306))) | (~(1009454671 | i40)))) * 568)) - 484726979;
                int i42 = (i41 << 13) ^ i41;
                int i43 = i42 ^ (i42 >>> 17);
                ((int[]) objArr[3])[0] = i43 ^ (i43 << 5);
                int i44 = getARTIFICIAL_FRAME_PACKAGE_NAME + 107;
                artificialFrame = i44 % 128;
                int i45 = i44 % 2;
            } else {
                Object[] objArr30 = new Object[1];
                c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 3, new char[]{54037, 36080, 11154, 54143, 64662, 52202, 54580, 4903, 48319, 35801, 38175, 21322, 34112, 31969, 19335, 21876, 37682, 15583, 2965, 5444}, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 20, new char[]{41400, 37476, 11326, 41425, 57863, 52309, 14302, 25040, 41518, 35936, 30701, 8648, 26533, 25146, 19467, 46976, 57775, 8784, 3128, 63401}, objArr31);
                Object[] objArr32 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue()), 0, -484726979};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame4 == null) {
                    int gidForName = 24 - Process.getGidForName("");
                    char c4 = (char) (30069 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                    int keyRepeatTimeout = 816 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                    byte b17 = $$a[5];
                    byte b18 = (byte) (b17 - 1);
                    byte b19 = b17;
                    Object[] objArr33 = new Object[1];
                    b(b18, b19, b19, objArr33);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(gidForName, c4, keyRepeatTimeout, -797394565, false, (String) objArr33[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr32);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame5 == null) {
                    int iLastIndexOf2 = TextUtils.lastIndexOf("", '0', 0) + 26;
                    char cIndexOf = (char) (30068 - TextUtils.indexOf("", ""));
                    int packedPositionGroup = 816 - ExpandableListView.getPackedPositionGroup(0L);
                    byte b20 = $$a[5];
                    byte b21 = (byte) (b20 - 1);
                    Object[] objArr34 = new Object[1];
                    b(b20, b21, b21, objArr34);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iLastIndexOf2, cIndexOf, packedPositionGroup, 891606461, false, (String) objArr34[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr);
                try {
                    Object[] objArr35 = new Object[1];
                    c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(18) - 98, new char[]{30752, 50754, 32690, 30785, 46635, 40920, 33589, 47187, 62984, 57340, 49997, 63607, 54098, 13838, 8154, 844, 14349, 30314, 24484, 17246, 30781, 46710, 40864, 33720, 47311, 63162}, objArr35);
                    Class<?> cls9 = Class.forName((String) objArr35[0]);
                    Object[] objArr36 = new Object[1];
                    c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 3, new char[]{58875, 10713, 8326, 58782, 22962, 49385, 58379, 9620, 6559, 32968, 41997, 26022, 46190, 55687, 16556, 25687, 42438, 39407, 129}, objArr36);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr36[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame6 == null) {
                        int iCombineMeasuredStates = 25 - View.combineMeasuredStates(0, 0);
                        char scrollBarSize = (char) (30068 - (ViewConfiguration.getScrollBarSize() >> 8));
                        int packedPositionGroup2 = 816 - ExpandableListView.getPackedPositionGroup(0L);
                        byte b22 = $$a[8];
                        byte b23 = (byte) (b22 - 2);
                        Object[] objArr37 = new Object[1];
                        b(b22, b23, b23, objArr37);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates, scrollBarSize, packedPositionGroup2, 721586079, false, (String) objArr37[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr38 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 3, new char[]{54037, 36080, 11154, 54143, 64662, 52202, 54580, 4903, 48319, 35801, 38175, 21322, 34112, 31969, 19335, 21876, 37682, 15583, 2965, 5444}, objArr38);
            Class<?> cls10 = Class.forName((String) objArr38[0]);
            Object[] objArr39 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 20, new char[]{41400, 37476, 11326, 41425, 57863, 52309, 14302, 25040, 41518, 35936, 30701, 8648, 26533, 25146, 19467, 46976, 57775, 8784, 3128, 63401}, objArr39);
            Object[] objArr310 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr39[0], Object.class).invoke(null, this)).intValue()), 0, -484726979};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame4 == null) {
                int gidForName2 = 24 - Process.getGidForName("");
                char c5 = (char) (30069 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                int keyRepeatTimeout2 = 816 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                byte b110 = $$a[5];
                byte b111 = (byte) (b110 - 1);
                byte b112 = b110;
                Object[] objArr311 = new Object[1];
                b(b111, b112, b112, objArr311);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(gidForName2, c5, keyRepeatTimeout2, -797394565, false, (String) objArr311[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr310);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame5 == null) {
                int iLastIndexOf3 = TextUtils.lastIndexOf("", '0', 0) + 26;
                char cIndexOf2 = (char) (30068 - TextUtils.indexOf("", ""));
                int packedPositionGroup3 = 816 - ExpandableListView.getPackedPositionGroup(0L);
                byte b24 = $$a[5];
                byte b25 = (byte) (b24 - 1);
                Object[] objArr312 = new Object[1];
                b(b24, b25, b25, objArr312);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iLastIndexOf3, cIndexOf2, packedPositionGroup3, 891606461, false, (String) objArr312[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr);
            Object[] objArr313 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(18) - 98, new char[]{30752, 50754, 32690, 30785, 46635, 40920, 33589, 47187, 62984, 57340, 49997, 63607, 54098, 13838, 8154, 844, 14349, 30314, 24484, 17246, 30781, 46710, 40864, 33720, 47311, 63162}, objArr313);
            Class<?> cls11 = Class.forName((String) objArr313[0]);
            Object[] objArr314 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 3, new char[]{58875, 10713, 8326, 58782, 22962, 49385, 58379, 9620, 6559, 32968, 41997, 26022, 46190, 55687, 16556, 25687, 42438, 39407, 129}, objArr314);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr314[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame6 == null) {
                int iCombineMeasuredStates2 = 25 - View.combineMeasuredStates(0, 0);
                char scrollBarSize2 = (char) (30068 - (ViewConfiguration.getScrollBarSize() >> 8));
                int packedPositionGroup4 = 816 - ExpandableListView.getPackedPositionGroup(0L);
                byte b26 = $$a[8];
                byte b27 = (byte) (b26 - 2);
                Object[] objArr315 = new Object[1];
                b(b26, b27, b27, objArr315);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates2, scrollBarSize2, packedPositionGroup4, 721586079, false, (String) objArr315[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i46 = ((int[]) objArr[1])[0];
        int i47 = ((int[]) objArr[0])[0];
        if (i47 == i46) {
            Object[] objArr40 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i48 = ((int[]) objArr[3])[0];
            int i49 = ((int[]) objArr[0])[0];
            int i50 = ((int[]) objArr[1])[0];
            String[] strArr6 = (String[]) objArr[2];
            int startUptimeMillis = (int) Process.getStartUptimeMillis();
            int i51 = ~((-366909685) | startUptimeMillis);
            int i52 = ~startUptimeMillis;
            int i53 = i48 + (-908241371) + ((i51 | (~((-168737319) | i52))) * (-1808)) + (((~((-365953233) | startUptimeMillis)) | (~(i52 | (-167780867)))) * TypedValues.Custom.TYPE_BOOLEAN) + (((~(startUptimeMillis | 168737318)) | 956452 | (~(366909684 | i52))) * TypedValues.Custom.TYPE_BOOLEAN);
            int i54 = (i53 << 13) ^ i53;
            int i55 = i54 ^ (i54 >>> 17);
            ((int[]) objArr40[3])[0] = i55 ^ (i55 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArr[2];
        if (strArr7 != null) {
            for (String str : strArr7) {
                arrayList2.add(str);
            }
        }
        Object[] objArr41 = {Long.valueOf(((long) (i46 ^ i47)) ^ (((long) (-315840229)) << 32)), Long.valueOf(-315840230)};
        byte[] bArr2 = $$m;
        Object[] objArr42 = new Object[1];
        d((byte) 44, bArr2[34], bArr2[50], objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        Object[] objArr43 = new Object[1];
        d(bArr2[23], bArr2[52], bArr2[24], objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
        int i56 = ((int[]) objArr[3])[0];
        int i57 = ((int[]) objArr[0])[0];
        int i58 = ((int[]) objArr[1])[0];
        String[] strArr8 = (String[]) objArr[2];
        int i59 = ~(System.identityHashCode(this) | (-701244037));
        int i60 = i56 + (((219183211 + (((-899416403) | i59) * (-220))) + ((i59 | 138420868) * 220)) - 711943778);
        int i61 = (i60 << 13) ^ i60;
        int i62 = i61 ^ (i61 >>> 17);
        ((int[]) objArr44[3])[0] = i62 ^ (i62 << 5);
    }

    @Override // android.app.Service
    public void onCreate() {
        int i = 2 % 2;
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 119;
        artificialFrame = i2 % 128;
        int i3 = i2 % 2;
        super.onCreate();
        int i4 = getARTIFICIAL_FRAME_PACKAGE_NAME + 9;
        artificialFrame = i4 % 128;
        int i5 = i4 % 2;
    }
}
