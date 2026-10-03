package com.transistorsoft.locationmanager.service;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.os.IResultReceiver2;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import ch.qos.logback.core.net.SyslogConstants;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.salesforce.marketingcloud.analytics.stats.b;
import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.locationmanager.util.BackgroundTaskManager;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import net.pluservice.unicoc.R;
import o.ArtificialStackFrames;
import o.asBinder;

/* JADX INFO: loaded from: classes6.dex */
public class BackgroundTaskService extends AbstractService {
    private static final byte[] $$c = {84, 120, -38, -81};
    private static final int $$f = 243;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$g = {7, 40, -110, -80, Ascii.SI, 1, -60, 60, Ascii.VT, 3, -5, 8, -4, -52, 54, Ascii.DLE, -7, 17, 0, -3, -2, -51, 66, -9, Ascii.SYN, -12, Ascii.DLE, -6, -5, Ascii.SO, -59, 56, Ascii.SI, 0, 6, 6, -65, 74, 2, -8, 6, 0, Ascii.SO, -8, -1, 17, -66, Ascii.EM, 56, -8, -10, Ascii.SI, -1, -3, -29, 47, 0, 6, 6, -75, 3, 36, 54, -1, -12, Ascii.DLE, -1, -10, Ascii.SO, -22, 41, -8, 9, -9, 0, Ascii.DC2, -8, -3, -20, Ascii.CAN, Ascii.SI, -8, 5, 0, -46, 3, SignedBytes.MAX_POWER_OF_TWO, -1, 0, Ascii.SI, 3, -1, -58, -2, 62, 8, 9, -12, Ascii.DLE, -1, -10, Ascii.SO, -59, 76, -1, -66, 39, Ascii.SYN, -1, Ascii.SO, -18, 17, 0, -12, Ascii.US, -9, Ascii.VT, -3, Ascii.DC2, -77, 54, Ascii.RS, -6, Ascii.SO, -12, Ascii.DLE, -27, Ascii.DLE, Ascii.NAK, -5};
    private static final int $$h = SyslogConstants.LOG_LOCAL1;
    private static final byte[] $$a = {70, -105, 85, -56, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13};
    private static final int $$b = 151;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static long extraCommand = 7040303705113737951L;

    private static String $$i(byte b, int i, byte b2) {
        int i2 = b + 4;
        int i3 = i * 2;
        byte[] bArr = $$c;
        int i4 = (b2 * 3) + 118;
        byte[] bArr2 = new byte[1 - i3];
        int i5 = 0 - i3;
        int i6 = -1;
        if (bArr == null) {
            i6 = -1;
            i4 = (-i2) + i5;
            i2 = i2;
        }
        while (true) {
            int i7 = i6 + 1;
            int i8 = i2 + 1;
            bArr2[i7] = (byte) i4;
            if (i7 == i5) {
                return new String(bArr2, 0);
            }
            i6 = i7;
            i4 = (-bArr[i8]) + i4;
            i2 = i8;
        }
    }

    private static Intent a(Context context, @Nullable String str) {
        Intent intent = new Intent(context, (Class<?>) BackgroundTaskService.class);
        if (str != null) {
            intent.setAction(str);
        }
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(int i) {
        a(i);
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
    private static void q(byte r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 8
            int r7 = 20 - r7
            byte[] r0 = com.transistorsoft.locationmanager.service.BackgroundTaskService.$$a
            int r6 = r6 * 28
            int r6 = 112 - r6
            int r8 = r8 * 3
            int r8 = 12 - r8
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r7
            r6 = r8
            r4 = r2
            goto L2d
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r8) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            r4 = r0[r7]
            r5 = r3
            r3 = r7
            r7 = r4
            r4 = r5
        L2d:
            int r7 = -r7
            int r6 = r6 + r7
            int r7 = r3 + 1
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.service.BackgroundTaskService.q(byte, byte, int, java.lang.Object[]):void");
    }

    public static void start(Context context, int i) {
        Intent intentA = a(context, (String) null);
        intentA.putExtra(BackgroundTaskManager.TASK_ID_FIELD, i);
        AbstractService.startForegroundService(context, intentA);
    }

    public static void stop(Context context) {
        AbstractService.stop(context, BackgroundTaskService.class);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0028  */
    /* JADX WARN: Code duplicated, block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0028
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void t(byte r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.transistorsoft.locationmanager.service.BackgroundTaskService.$$g
            int r6 = 82 - r6
            int r7 = 86 - r7
            int r8 = r8 * 3
            int r8 = 111 - r8
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L13
            r4 = r6
            r8 = r7
            r3 = r2
            goto L2a
        L13:
            r3 = r2
            r5 = r8
            r8 = r7
            r7 = r5
        L17:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r3 = r3 + 1
            int r8 = r8 + 1
            if (r3 != r6) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            r4 = r0[r8]
        L2a:
            int r7 = r7 + r4
            int r7 = r7 + (-3)
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.service.BackgroundTaskService.t(byte, short, int, java.lang.Object[]):void");
    }

    @Override // com.transistorsoft.locationmanager.service.AbstractService, android.app.Service
    public void onCreate() {
        if (Build.VERSION.SDK_INT >= 29) {
            super.a(getClass().getSimpleName(), 2048);
        } else {
            super.a(getClass().getSimpleName(), 0);
        }
    }

    @Override // com.transistorsoft.locationmanager.service.AbstractService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, final int i2) {
        if (!a(intent, i2, false)) {
            return 2;
        }
        if (intent.hasExtra(BackgroundTaskManager.TASK_ID_FIELD)) {
            BackgroundTaskManager.getInstance().onStartJob(getApplicationContext(), intent.getIntExtra(BackgroundTaskManager.TASK_ID_FIELD, 0), new BackgroundTaskManager.Callback() { // from class: com.transistorsoft.locationmanager.service.BackgroundTaskService$$ExternalSyntheticLambda0
                @Override // com.transistorsoft.locationmanager.util.BackgroundTaskManager.Callback
                public final void onFinish() {
                    this.f$0.c(i2);
                }
            });
            return 3;
        }
        TSLog.logger.warn(TSLog.warn("BackgroundTaskService called with no taskId"));
        a(i2);
        return 3;
    }

    private static void s(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        asBinder asbinder = new asBinder();
        asbinder.c = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        asbinder.d = 0;
        while (asbinder.d < cArr.length) {
            int i3 = $10 + 117;
            $11 = i3 % 128;
            if (i3 % 2 == 0) {
                int i4 = asbinder.d;
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr[asbinder.d]), asbinder, asbinder};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1562553046);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) (-1);
                        byte b2 = (byte) (b + 1);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 10, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 1407 - ((Process.getThreadPriority(0) + 20) >> 6), 1035473698, false, $$i(b, b2, b2), new Class[]{Integer.TYPE, Object.class, Object.class});
                    }
                    jArr[i4] = ((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue() + (extraCommand ^ (-2360974883025274865L));
                    Object[] objArr3 = {asbinder, asbinder};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                    if (objAccessartificialFrame2 == null) {
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(7 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16), TextUtils.indexOf((CharSequence) "", '0', 0) + ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 378009232, false, "w", new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } else {
                int i5 = asbinder.d;
                Object[] objArr4 = {Integer.valueOf(cArr[asbinder.d]), asbinder, asbinder};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1562553046);
                if (objAccessartificialFrame3 == null) {
                    byte b3 = (byte) (-1);
                    byte b4 = (byte) (b3 + 1);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(11 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) ExpandableListView.getPackedPositionGroup(0L), 1407 - View.resolveSizeAndState(0, 0, 0), 1035473698, false, $$i(b3, b4, b4), new Class[]{Integer.TYPE, Object.class, Object.class});
                }
                jArr[i5] = ((Long) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).longValue() ^ (extraCommand ^ (-2360974883025274865L));
                Object[] objArr5 = {asbinder, asbinder};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(8 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) Gravity.getAbsoluteGravity(0, 0), 249 - (ViewConfiguration.getTapTimeout() >> 16), 378009232, false, "w", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
            }
        }
        char[] cArr2 = new char[length];
        asbinder.d = 0;
        int i6 = $11 + 17;
        $10 = i6 % 128;
        int i7 = i6 % 2;
        while (asbinder.d < cArr.length) {
            int i8 = $11 + 15;
            $10 = i8 % 128;
            if (i8 % 2 != 0) {
                cArr2[asbinder.d] = (char) jArr[asbinder.d];
                Object[] objArr6 = {asbinder, asbinder};
                Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame5 == null) {
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(TextUtils.getOffsetAfter("", 0) + 8, (char) ('0' - AndroidCharacter.getMirror('0')), (-16776967) - Color.rgb(0, 0, 0), 378009232, false, "w", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame5).invoke(null, objArr6);
                throw null;
            }
            cArr2[asbinder.d] = (char) jArr[asbinder.d];
            Object[] objArr7 = {asbinder, asbinder};
            Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1981632360);
            if (objAccessartificialFrame6 == null) {
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getLongPressTimeout() >> 16) + 8, (char) (TextUtils.indexOf((CharSequence) "", '0') + 1), 249 - Drawable.resolveOpacity(0, 0), 378009232, false, "w", new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame6).invoke(null, objArr7);
        }
        objArr[0] = new String(cArr2);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:16:0x020b A[Catch: all -> 0x0a39, TryCatch #0 {all -> 0x0a39, blocks: (B:55:0x0724, B:57:0x0738, B:58:0x0768, B:14:0x01ea, B:16:0x020b, B:17:0x0254), top: B:98:0x01ea }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0266  */
    /* JADX WARN: Code duplicated, block: B:25:0x0339  */
    /* JADX WARN: Code duplicated, block: B:54:0x068f  */
    /* JADX WARN: Code duplicated, block: B:57:0x0738 A[Catch: all -> 0x0a39, TryCatch #0 {all -> 0x0a39, blocks: (B:55:0x0724, B:57:0x0738, B:58:0x0768, B:14:0x01ea, B:16:0x020b, B:17:0x0254), top: B:98:0x01ea }] */
    /* JADX WARN: Code duplicated, block: B:61:0x077e  */
    /* JADX WARN: Code duplicated, block: B:66:0x083b  */
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
        super.attachBaseContext(context);
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame7 == null) {
            int i2 = 25 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
            char maximumFlingVelocity = (char) (30068 - (ViewConfiguration.getMaximumFlingVelocity() >> 16));
            int iIndexOf = TextUtils.indexOf("", "", 0) + 816;
            byte[] bArr = $$a;
            byte b = bArr[5];
            Object[] objArr2 = new Object[1];
            q((byte) (b - 1), bArr[8], b, objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(i2, maximumFlingVelocity, iIndexOf, 721586079, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 1977;
            Object[] objArr3 = new Object[1];
            s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 41906, new char[]{689, 41323, 17694, 59869, 36331, 12688, 54346, 30765, 7191, 49374, 25772, 2212, 44885, 21362, 63234, 39886, 16365, 58294, 34374, 10864, 52759, 29378}, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            s(2729 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), new char[]{693, 2069, 6115, 7515, 10247, 14328, 15682, 18461, 22525, 23872, 26662, 30695, 32085, 34856, 38795}, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame8 == null) {
                    int offsetAfter = TextUtils.getOffsetAfter("", 0) + 25;
                    char tapTimeout = (char) (30068 - (ViewConfiguration.getTapTimeout() >> 16));
                    int iIndexOf2 = 816 - TextUtils.indexOf("", "", 0);
                    byte b2 = $$a[5];
                    byte b3 = (byte) (b2 - 1);
                    byte b4 = b2;
                    Object[] objArr5 = new Object[1];
                    q(b3, b4, b4, objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(offsetAfter, tapTimeout, iIndexOf2, 891606461, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i3 = ((int[]) objArr6[0])[0];
                int i4 = ((int[]) objArr6[1])[0];
                String[] strArr = (String[]) objArr6[2];
                int layoutDirection = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().getLayoutDirection();
                int i5 = ~layoutDirection;
                int i6 = (((525994198 + (((~((-122643900) | i5)) | 75528466) * (-90))) + (((~((-122643900) | layoutDirection)) | (-131038652)) * (-45))) + ((((~(layoutDirection | (-75528467))) | (-122643900)) | (~(i5 | 75528466))) * 45)) - 1042477652;
                int i7 = i6 ^ (i6 << 13);
                int i8 = i7 ^ (i7 >>> 17);
                ((int[]) objArr[3])[0] = i8 ^ (i8 << 5);
                int i9 = getARTIFICIAL_FRAME_PACKAGE_NAME + 41;
                artificialFrame = i9 % 128;
                int i10 = i9 % 2;
            } else {
                Object[] objArr7 = new Object[1];
                s((ViewConfiguration.getWindowTouchSlop() >> 8) + 29363, new char[]{698, 28674, 59328, 23208, 51250, 16323, 45699, 8283, 38703, 2741, 30845, 61208, 25287, 53683, 18303, 47808}, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                s((ViewConfiguration.getScrollBarSize() >> 8) + 59183, new char[]{697, 58779, 52459, 46899, 40472, 33106, 27070, 20704, 15328, 8726, 1397, 60861, 54439, 49116, 42534, 35188}, objArr8);
                try {
                    Object[] objArr9 = {Integer.valueOf(((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue()), 0, -1042477652};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame == null) {
                        int iGreen = 25 - Color.green(0);
                        char touchSlop = (char) ((ViewConfiguration.getTouchSlop() >> 8) + 30068);
                        int jumpTapTimeout = 816 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                        byte b5 = $$a[5];
                        byte b6 = (byte) (b5 - 1);
                        Object[] objArr10 = new Object[1];
                        q(b5, b6, b6, objArr10);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iGreen, touchSlop, jumpTapTimeout, -797394565, false, (String) objArr10[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr9);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame2 == null) {
                        int minimumFlingVelocity = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 25;
                        char cIndexOf = (char) (30067 - TextUtils.indexOf((CharSequence) "", '0'));
                        int iCombineMeasuredStates = View.combineMeasuredStates(0, 0) + 816;
                        byte b7 = $$a[5];
                        byte b8 = (byte) (b7 - 1);
                        byte b9 = b7;
                        Object[] objArr11 = new Object[1];
                        q(b8, b9, b9, objArr11);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity, cIndexOf, iCombineMeasuredStates, 891606461, false, (String) objArr11[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArr);
                    try {
                        Object[] objArr12 = new Object[1];
                        s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(14) + 41895, new char[]{689, 41323, 17694, 59869, 36331, 12688, 54346, 30765, 7191, 49374, 25772, 2212, 44885, 21362, 63234, 39886, 16365, 58294, 34374, 10864, 52759, 29378}, objArr12);
                        Class<?> cls3 = Class.forName((String) objArr12[0]);
                        Object[] objArr13 = new Object[1];
                        s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 2725, new char[]{693, 2069, 6115, 7515, 10247, 14328, 15682, 18461, 22525, 23872, 26662, 30695, 32085, 34856, 38795}, objArr13);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr13[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame3 == null) {
                            int packedPositionGroup = 25 - ExpandableListView.getPackedPositionGroup(0L);
                            char cMakeMeasureSpec = (char) (30068 - View.MeasureSpec.makeMeasureSpec(0, 0));
                            int i11 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 815;
                            byte[] bArr2 = $$a;
                            byte b10 = bArr2[5];
                            Object[] objArr14 = new Object[1];
                            q((byte) (b10 - 1), bArr2[8], b10, objArr14);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(packedPositionGroup, cMakeMeasureSpec, i11, 721586079, false, (String) objArr14[0], null);
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
            Object[] objArr15 = new Object[1];
            s((ViewConfiguration.getWindowTouchSlop() >> 8) + 29363, new char[]{698, 28674, 59328, 23208, 51250, 16323, 45699, 8283, 38703, 2741, 30845, 61208, 25287, 53683, 18303, 47808}, objArr15);
            Class<?> cls4 = Class.forName((String) objArr15[0]);
            Object[] objArr16 = new Object[1];
            s((ViewConfiguration.getScrollBarSize() >> 8) + 59183, new char[]{697, 58779, 52459, 46899, 40472, 33106, 27070, 20704, 15328, 8726, 1397, 60861, 54439, 49116, 42534, 35188}, objArr16);
            Object[] objArr17 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue()), 0, -1042477652};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame == null) {
                int iGreen2 = 25 - Color.green(0);
                char touchSlop2 = (char) ((ViewConfiguration.getTouchSlop() >> 8) + 30068);
                int jumpTapTimeout2 = 816 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                byte b11 = $$a[5];
                byte b12 = (byte) (b11 - 1);
                Object[] objArr18 = new Object[1];
                q(b11, b12, b12, objArr18);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iGreen2, touchSlop2, jumpTapTimeout2, -797394565, false, (String) objArr18[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr17);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame2 == null) {
                int minimumFlingVelocity2 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 25;
                char cIndexOf2 = (char) (30067 - TextUtils.indexOf((CharSequence) "", '0'));
                int iCombineMeasuredStates2 = View.combineMeasuredStates(0, 0) + 816;
                byte b13 = $$a[5];
                byte b14 = (byte) (b13 - 1);
                byte b15 = b13;
                Object[] objArr19 = new Object[1];
                q(b14, b15, b15, objArr19);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity2, cIndexOf2, iCombineMeasuredStates2, 891606461, false, (String) objArr19[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArr);
            Object[] objArr110 = new Object[1];
            s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(14) + 41895, new char[]{689, 41323, 17694, 59869, 36331, 12688, 54346, 30765, 7191, 49374, 25772, 2212, 44885, 21362, 63234, 39886, 16365, 58294, 34374, 10864, 52759, 29378}, objArr110);
            Class<?> cls5 = Class.forName((String) objArr110[0]);
            Object[] objArr111 = new Object[1];
            s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 2725, new char[]{693, 2069, 6115, 7515, 10247, 14328, 15682, 18461, 22525, 23872, 26662, 30695, 32085, 34856, 38795}, objArr111);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr111[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame3 == null) {
                int packedPositionGroup2 = 25 - ExpandableListView.getPackedPositionGroup(0L);
                char cMakeMeasureSpec2 = (char) (30068 - View.MeasureSpec.makeMeasureSpec(0, 0));
                int i12 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 815;
                byte[] bArr3 = $$a;
                byte b16 = bArr3[5];
                Object[] objArr112 = new Object[1];
                q((byte) (b16 - 1), bArr3[8], b16, objArr112);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(packedPositionGroup2, cMakeMeasureSpec2, i12, 721586079, false, (String) objArr112[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i13 = ((int[]) objArr[1])[0];
        int i14 = ((int[]) objArr[0])[0];
        if (i14 == i13) {
            Object[] objArr20 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i15 = ((int[]) objArr[3])[0];
            int i16 = ((int[]) objArr[0])[0];
            int i17 = ((int[]) objArr[1])[0];
            String[] strArr2 = (String[]) objArr[2];
            int i18 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenWidthDp;
            int i19 = i15 + 739269057 + (((~(219331496 | i18)) | 417503862) * (-366)) + (((~(i18 | 502447102)) | 134388256) * 366);
            int i20 = (i19 << 13) ^ i19;
            int i21 = i20 ^ (i20 >>> 17);
            ((int[]) objArr20[3])[0] = i21 ^ (i21 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr[2];
            if (strArr3 != null) {
                int i22 = getARTIFICIAL_FRAME_PACKAGE_NAME + b.i;
                artificialFrame = i22 % 128;
                for (int i23 = i22 % 2 == 0 ? 1 : 0; i23 < strArr3.length; i23++) {
                    int i24 = getARTIFICIAL_FRAME_PACKAGE_NAME + 17;
                    artificialFrame = i24 % 128;
                    int i25 = i24 % 2;
                    arrayList.add(strArr3[i23]);
                }
            }
            long j3 = (((long) (-2080516713)) << 32) ^ ((long) (i13 ^ i14));
            long j4 = -2080516714;
            int i26 = getARTIFICIAL_FRAME_PACKAGE_NAME + 61;
            artificialFrame = i26 % 128;
            int i27 = i26 % 2;
            try {
                Object[] objArr21 = {Long.valueOf(j3), Long.valueOf(j4)};
                byte[] bArr4 = $$g;
                byte b17 = bArr4[18];
                Object[] objArr22 = new Object[1];
                t(b17, (byte) (b17 | 83), (byte) (-bArr4[12]), objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                t((byte) 79, bArr4[38], bArr4[47], objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i28 = ((int[]) objArr[3])[0];
                int i29 = ((int[]) objArr[0])[0];
                int i30 = ((int[]) objArr[1])[0];
                String[] strArr4 = (String[]) objArr[2];
                int iMyPid = Process.myPid();
                int i31 = i28 + 548183176 + (((~((-246246990) | iMyPid)) | 203448320) * 345) + (((~((-246246990) | (~iMyPid))) | (-251522944)) * 345) + ((~(iMyPid | (-203448321))) * 345);
                int i32 = (i31 << 13) ^ i31;
                int i33 = i32 ^ (i32 >>> 17);
                ((int[]) objArr24[3])[0] = i33 ^ (i33 << 5);
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
            int bitsPerPixel = 25 - ImageFormat.getBitsPerPixel(0);
            char touchSlop3 = (char) (ViewConfiguration.getTouchSlop() >> 8);
            int iAxisFromString = 1040 - MotionEvent.axisFromString("");
            byte[] bArr5 = $$a;
            byte b18 = bArr5[5];
            Object[] objArr25 = new Object[1];
            q((byte) (b18 - 1), bArr5[8], b18, objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(bitsPerPixel, touchSlop3, iAxisFromString, 2061780482, false, (String) objArr25[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j5 != -1) {
            long j6 = j5 + 4611686018427387909L;
            Object[] objArr26 = new Object[1];
            s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(19) + 41830, new char[]{689, 41323, 17694, 59869, 36331, 12688, 54346, 30765, 7191, 49374, 25772, 2212, 44885, 21362, 63234, 39886, 16365, 58294, 34374, 10864, 52759, 29378}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 2694, new char[]{693, 2069, 6115, 7515, 10247, 14328, 15682, 18461, 22525, 23872, 26662, 30695, 32085, 34856, 38795}, objArr27);
            if (j6 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame10 == null) {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0) + 26;
                    char c = (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                    int i34 = 1041 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                    byte b19 = $$a[5];
                    byte b20 = (byte) (b19 - 1);
                    byte b21 = b19;
                    Object[] objArr28 = new Object[1];
                    q(b20, b21, b21, objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec, c, i34, 1145017376, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i35 = ((int[]) objArr29[3])[0];
                int i36 = ((int[]) objArr29[2])[0];
                String[] strArr5 = (String[]) objArr29[0];
                int iIdentityHashCode = System.identityHashCode(this);
                int i37 = ~iIdentityHashCode;
                int i38 = (-1106067862) + (((~(753966481 | i37)) | (~((-832070289) | iIdentityHashCode))) * 1900) + (((~(i37 | 832070288)) | (~(iIdentityHashCode | (-753966482)))) * (-950)) + (((~(iIdentityHashCode | 832070288)) | (~(i37 | (-753966482)))) * 950) + 505370657;
                int i39 = (i38 << 13) ^ i38;
                int i40 = i39 ^ (i39 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i40 ^ (i40 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) + 29314, new char[]{698, 28674, 59328, 23208, 51250, 16323, 45699, 8283, 38703, 2741, 30845, 61208, 25287, 53683, 18303, 47808}, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 59179, new char[]{697, 58779, 52459, 46899, 40472, 33106, 27070, 20704, 15328, 8726, 1397, 60861, 54439, 49116, 42534, 35188}, objArr31);
                int iIntValue = ((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue();
                Object[] objArr32 = {681977553};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(7 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (View.combineMeasuredStates(0, 0) + 22251), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 1032, 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = IResultReceiver2._Parcel.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr32), 505370657, false);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame5 == null) {
                    int fadingEdgeLength = (ViewConfiguration.getFadingEdgeLength() >> 16) + 26;
                    char c2 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                    int i41 = 1041 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                    byte b22 = $$a[5];
                    byte b23 = (byte) (b22 - 1);
                    byte b24 = b22;
                    Object[] objArr33 = new Object[1];
                    q(b23, b24, b24, objArr33);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength, c2, i41, 1145017376, false, (String) objArr33[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Object[] objArr34 = new Object[1];
                    s(41942 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), new char[]{689, 41323, 17694, 59869, 36331, 12688, 54346, 30765, 7191, 49374, 25772, 2212, 44885, 21362, 63234, 39886, 16365, 58294, 34374, 10864, 52759, 29378}, objArr34);
                    Class<?> cls9 = Class.forName((String) objArr34[0]);
                    Object[] objArr35 = new Object[1];
                    s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) + 2680, new char[]{693, 2069, 6115, 7515, 10247, 14328, 15682, 18461, 22525, 23872, 26662, 30695, 32085, 34856, 38795}, objArr35);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr35[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame6 == null) {
                        int keyRepeatTimeout = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 26;
                        char maximumDrawingCacheSize = (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                        int iKeyCodeFromString = KeyEvent.keyCodeFromString("") + 1041;
                        byte[] bArr6 = $$a;
                        byte b25 = bArr6[5];
                        Object[] objArr36 = new Object[1];
                        q((byte) (b25 - 1), bArr6[8], b25, objArr36);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout, maximumDrawingCacheSize, iKeyCodeFromString, 2061780482, false, (String) objArr36[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr37 = new Object[1];
            s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) + 29314, new char[]{698, 28674, 59328, 23208, 51250, 16323, 45699, 8283, 38703, 2741, 30845, 61208, 25287, 53683, 18303, 47808}, objArr37);
            Class<?> cls10 = Class.forName((String) objArr37[0]);
            Object[] objArr38 = new Object[1];
            s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 59179, new char[]{697, 58779, 52459, 46899, 40472, 33106, 27070, 20704, 15328, 8726, 1397, 60861, 54439, 49116, 42534, 35188}, objArr38);
            int iIntValue2 = ((Integer) cls10.getMethod((String) objArr38[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr39 = {681977553};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(7 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (View.combineMeasuredStates(0, 0) + 22251), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 1032, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = IResultReceiver2._Parcel.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr39), 505370657, false);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame5 == null) {
                int fadingEdgeLength2 = (ViewConfiguration.getFadingEdgeLength() >> 16) + 26;
                char c3 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                int i42 = 1041 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                byte b26 = $$a[5];
                byte b27 = (byte) (b26 - 1);
                byte b28 = b26;
                Object[] objArr310 = new Object[1];
                q(b27, b28, b28, objArr310);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength2, c3, i42, 1145017376, false, (String) objArr310[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr311 = new Object[1];
            s(41942 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), new char[]{689, 41323, 17694, 59869, 36331, 12688, 54346, 30765, 7191, 49374, 25772, 2212, 44885, 21362, 63234, 39886, 16365, 58294, 34374, 10864, 52759, 29378}, objArr311);
            Class<?> cls11 = Class.forName((String) objArr311[0]);
            Object[] objArr312 = new Object[1];
            s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) + 2680, new char[]{693, 2069, 6115, 7515, 10247, 14328, 15682, 18461, 22525, 23872, 26662, 30695, 32085, 34856, 38795}, objArr312);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr312[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame6 == null) {
                int keyRepeatTimeout2 = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 26;
                char maximumDrawingCacheSize2 = (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                int iKeyCodeFromString2 = KeyEvent.keyCodeFromString("") + 1041;
                byte[] bArr7 = $$a;
                byte b29 = bArr7[5];
                Object[] objArr313 = new Object[1];
                q((byte) (b29 - 1), bArr7[8], b29, objArr313);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout2, maximumDrawingCacheSize2, iKeyCodeFromString2, 2061780482, false, (String) objArr313[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i43 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i44 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i44 == i43) {
            Object[] objArr40 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i45 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i46 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i47 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr6 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int i48 = (int) Runtime.getRuntime().totalMemory();
            int i49 = i45 + 2098414286 + (((~(502190663 | i48)) | 68872 | (~((-424086857) | i48))) * (-744)) + (((~i48) | 78172679) * 744) + ((i48 | (-68873)) * 744);
            int i50 = (i49 << 13) ^ i49;
            int i51 = i50 ^ (i50 >>> 17);
            ((int[]) objArr40[1])[0] = i51 ^ (i51 << 5);
            int i52 = getARTIFICIAL_FRAME_PACKAGE_NAME + b.f40o;
            artificialFrame = i52 % 128;
            int i53 = i52 % 2;
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        if (strArr7 != null) {
            int i54 = 0;
            while (i54 < strArr7.length) {
                int i55 = getARTIFICIAL_FRAME_PACKAGE_NAME + 33;
                artificialFrame = i55 % 128;
                if (i55 % 2 == 0) {
                    arrayList2.add(strArr7[i54]);
                    i54 += 25;
                } else {
                    arrayList2.add(strArr7[i54]);
                    i54++;
                }
            }
        }
        long j7 = ((long) (i43 ^ i44)) ^ (((long) (-1846723014)) << 32);
        long j8 = -1846723016;
        int i56 = getARTIFICIAL_FRAME_PACKAGE_NAME + 119;
        artificialFrame = i56 % 128;
        int i57 = i56 % 2;
        Object[] objArr41 = {Long.valueOf(j7), Long.valueOf(j8)};
        byte[] bArr8 = $$g;
        byte b30 = (byte) (bArr8[106] - 1);
        byte b31 = bArr8[18];
        Object[] objArr42 = new Object[1];
        t(b30, b31, b31, objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        Object[] objArr43 = new Object[1];
        t((byte) 79, bArr8[38], bArr8[47], objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {strArr, new int[1], new int[]{i}, new int[]{i}};
        int i58 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
        int i59 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        int i60 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        String[] strArr8 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        int i61 = ~((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getRingerMode();
        int i62 = i58 + (-1107076850) + ((~((-75514627) | i61)) * 52) + (((~(958998645 | i61)) | (~(880894838 | i61)) | (-1034513272)) * (-52)) + (((~(i61 | (-958998646))) | 805380212) * 52);
        int i63 = (i62 << 13) ^ i62;
        int i64 = i63 ^ (i63 >>> 17);
        ((int[]) objArr44[1])[0] = i64 ^ (i64 << 5);
    }
}
