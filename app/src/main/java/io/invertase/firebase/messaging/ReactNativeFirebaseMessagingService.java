package io.invertase.firebase.messaging;

import android.content.Context;
import android.graphics.Color;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import ch.qos.logback.core.net.SyslogConstants;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.salesforce.marketingcloud.analytics.stats.b;
import com.swmansion.gesturehandler.core.NativeViewGestureHandler;
import io.invertase.firebase.common.ReactNativeFirebaseEventEmitter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import o.ArtificialStackFrames;
import o.build;

/* JADX INFO: loaded from: classes6.dex */
public class ReactNativeFirebaseMessagingService extends FirebaseMessagingService {
    private static final byte[] $$z = {Ascii.GS, -31, -116, 88};
    private static final int $$A = 0;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$v = {45, 100, 38, 47, -3, -4, -19, -7, -3, 54, -2, -66, -12, -13, 8, -20, -3, 6, -18, 55, -73, -3, 4, -26, 7, -16, -10, -2, 56, -58, -20, 3, -21, -4, -1, -2, 47, -29, -40, -8, -6, -20, -7, 6, -6, 10, -35, 5, -15, -1, -22, 44, -42, -4, -22, -11, 8, -20, -7, -68, -19, -5, 56, -64, -15, -7, 1, -12, 0, 48, -60, -22, -14, 2, -11, -2, 58, -77, 4, -12, -4, 54, -58, -11, -3, -10, 47, -26, -43, -21, 39, -35, -30, 38, -33, -27, 78, -20};
    private static final int $$w = 185;
    private static final byte[] $$j = {Ascii.EM, -12, SignedBytes.MAX_POWER_OF_TWO, 107, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13};
    private static final int $$k = 191;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char TopicBuilder = 2327;
    private static char ICustomTabsCallback = 42585;
    private static char extraCallbackWithResult = 12695;
    private static char onMessageChannelReady = 27974;

    /* JADX WARN: Code duplicated, block: B:10:0x0029  */
    /* JADX WARN: Code duplicated, block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x002f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0029
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$B(byte r6, byte r7, int r8) {
        /*
            int r6 = r6 * 2
            int r6 = r6 + 108
            int r8 = r8 * 2
            int r0 = 1 - r8
            int r7 = r7 * 3
            int r7 = 3 - r7
            byte[] r1 = io.invertase.firebase.messaging.ReactNativeFirebaseMessagingService.$$z
            byte[] r0 = new byte[r0]
            r2 = 0
            int r8 = 0 - r8
            if (r1 != 0) goto L19
            r3 = r7
            r7 = r8
            r4 = r2
            goto L2f
        L19:
            r3 = r2
        L1a:
            byte r4 = (byte) r6
            r0[r3] = r4
            int r7 = r7 + 1
            int r4 = r3 + 1
            if (r3 != r8) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            return r6
        L29:
            r3 = r1[r7]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r5
        L2f:
            int r6 = -r6
            int r6 = r6 + r7
            r7 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: io.invertase.firebase.messaging.ReactNativeFirebaseMessagingService.$$B(byte, byte, int):java.lang.String");
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
    private static void j(short r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 3
            int r0 = r7 + 9
            int r8 = r8 * 28
            int r8 = r8 + 84
            byte[] r1 = io.invertase.firebase.messaging.ReactNativeFirebaseMessagingService.$$j
            int r6 = r6 + 4
            byte[] r0 = new byte[r0]
            int r7 = r7 + 8
            r2 = 0
            if (r1 != 0) goto L17
            r8 = r6
            r3 = r7
            r4 = r2
            goto L2f
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r8
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L27:
            int r6 = r6 + 1
            r3 = r1[r6]
            r5 = r8
            r8 = r6
            r6 = r3
            r3 = r5
        L2f:
            int r6 = -r6
            int r6 = r6 + r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: io.invertase.firebase.messaging.ReactNativeFirebaseMessagingService.j(short, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void l(int r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 2
            int r7 = 59 - r7
            int r6 = r6 * 3
            int r6 = r6 + 36
            byte[] r0 = io.invertase.firebase.messaging.ReactNativeFirebaseMessagingService.$$v
            int r8 = r8 * 4
            int r8 = 55 - r8
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r8
            r4 = r2
            goto L2a
        L16:
            r3 = r2
        L17:
            int r4 = r3 + 1
            byte r5 = (byte) r6
            r1[r3] = r5
            if (r4 != r8) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            int r7 = r7 + 1
            r3 = r0[r7]
        L2a:
            int r3 = -r3
            int r6 = r6 + r3
            int r6 = r6 + (-7)
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: io.invertase.firebase.messaging.ReactNativeFirebaseMessagingService.l(int, int, short, java.lang.Object[]):void");
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onSendError(String str, Exception exc) {
        ReactNativeFirebaseEventEmitter.getSharedInstance().sendEvent(ReactNativeFirebaseMessagingSerializer.messageSendErrorToEvent(str, exc));
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onDeletedMessages() {
        ReactNativeFirebaseEventEmitter.getSharedInstance().sendEvent(ReactNativeFirebaseMessagingSerializer.messagesDeletedToEvent());
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageSent(String str) {
        ReactNativeFirebaseEventEmitter.getSharedInstance().sendEvent(ReactNativeFirebaseMessagingSerializer.messageSentToEvent(str));
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String str) {
        ReactNativeFirebaseEventEmitter.getSharedInstance().sendEvent(ReactNativeFirebaseMessagingSerializer.newTokenToTokenEvent(str));
    }

    private static void k(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        build buildVar = new build();
        char[] cArr2 = new char[cArr.length];
        int i3 = 0;
        buildVar.c = 0;
        char[] cArr3 = new char[2];
        while (buildVar.c < cArr.length) {
            int i4 = $10 + 49;
            $11 = i4 % 128;
            int i5 = i4 % 2;
            cArr3[i3] = cArr[buildVar.c];
            cArr3[1] = cArr[buildVar.c + 1];
            int i6 = 58224;
            int i7 = i3;
            while (i7 < 16) {
                char c = cArr3[1];
                char c2 = cArr3[i3];
                int i8 = (c2 + i6) ^ ((c2 << 4) + ((char) (((long) extraCallbackWithResult) ^ (-4408183324873663413L))));
                int i9 = c2 >>> 5;
                try {
                    Object[] objArr2 = new Object[4];
                    objArr2[3] = Integer.valueOf(onMessageChannelReady);
                    objArr2[2] = Integer.valueOf(i9);
                    objArr2[1] = Integer.valueOf(i8);
                    objArr2[i3] = Integer.valueOf(c);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1585798252);
                    if (objAccessartificialFrame == null) {
                        int gidForName = 27 - Process.getGidForName("");
                        char mirror = (char) (AndroidCharacter.getMirror('0') + 17215);
                        int iRgb = (-16776149) - Color.rgb(i3, i3, i3);
                        byte b = (byte) $$A;
                        byte b2 = b;
                        String str$$B = $$B(b, b2, b2);
                        Class[] clsArr = new Class[4];
                        clsArr[i3] = Integer.TYPE;
                        clsArr[1] = Integer.TYPE;
                        clsArr[2] = Integer.TYPE;
                        clsArr[3] = Integer.TYPE;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(gidForName, mirror, iRgb, 1042277788, false, str$$B, clsArr);
                    }
                    char cCharValue = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    cArr3[1] = cCharValue;
                    char[] cArr4 = cArr3;
                    Object[] objArr3 = {Integer.valueOf(cArr3[i3]), Integer.valueOf((cCharValue + i6) ^ ((cCharValue << 4) + ((char) (((long) TopicBuilder) ^ (-4408183324873663413L))))), Integer.valueOf(cCharValue >>> 5), Integer.valueOf(ICustomTabsCallback)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1585798252);
                    if (objAccessartificialFrame2 == null) {
                        int doubleTapTimeout = 28 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                        char keyRepeatDelay = (char) ((ViewConfiguration.getKeyRepeatDelay() >> 16) + 17263);
                        int keyRepeatTimeout = 1067 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                        byte b3 = (byte) $$A;
                        byte b4 = b3;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout, keyRepeatDelay, keyRepeatTimeout, 1042277788, false, $$B(b3, b4, b4), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    cArr4[0] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                    i6 -= 40503;
                    i7++;
                    int i10 = $11 + b.f40o;
                    $10 = i10 % 128;
                    if (i10 % 2 != 0) {
                        int i11 = 2 / 4;
                    }
                    cArr3 = cArr4;
                    i3 = 0;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            char[] cArr5 = cArr3;
            cArr2[buildVar.c] = cArr5[0];
            cArr2[buildVar.c + 1] = cArr5[1];
            Object[] objArr4 = {buildVar, buildVar};
            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1010141908);
            if (objAccessartificialFrame3 == null) {
                int i12 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 25;
                char c3 = (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 63927);
                int i13 = 485 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                int i14 = $$A;
                byte b5 = (byte) (i14 + 1);
                byte b6 = (byte) i14;
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i12, c3, i13, 1554985764, false, $$B(b5, b6, b6), new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame3).invoke(null, objArr4);
            int i15 = $11 + 53;
            $10 = i15 % 128;
            int i16 = i15 % 2;
            cArr3 = cArr5;
            i3 = 0;
        }
        objArr[0] = new String(cArr2, 0, i);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:16:0x0221 A[Catch: all -> 0x09d6, TryCatch #1 {all -> 0x09d6, blocks: (B:51:0x06c6, B:53:0x06e6, B:54:0x073b, B:14:0x020d, B:16:0x0221, B:17:0x0251), top: B:93:0x020d }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0267  */
    /* JADX WARN: Code duplicated, block: B:25:0x031f  */
    /* JADX WARN: Code duplicated, block: B:50:0x0640  */
    /* JADX WARN: Code duplicated, block: B:53:0x06e6 A[Catch: all -> 0x09d6, TryCatch #1 {all -> 0x09d6, blocks: (B:51:0x06c6, B:53:0x06e6, B:54:0x073b, B:14:0x020d, B:16:0x0221, B:17:0x0251), top: B:93:0x020d }] */
    /* JADX WARN: Code duplicated, block: B:57:0x074d  */
    /* JADX WARN: Code duplicated, block: B:62:0x07ff  */
    @Override // com.google.firebase.messaging.FirebaseMessagingService, com.google.firebase.messaging.EnhancedIntentService, android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
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
            int pressedStateDuration = (ViewConfiguration.getPressedStateDuration() >> 16) + 26;
            char c = (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
            int i2 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 1040;
            byte[] bArr = $$j;
            byte b = bArr[21];
            Object[] objArr2 = new Object[1];
            j(b, (byte) (b + 1), bArr[5], objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(pressedStateDuration, c, i2, 2061780482, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            int i3 = getARTIFICIAL_FRAME_PACKAGE_NAME + 113;
            artificialFrame = i3 % 128;
            int i4 = i3 % 2;
            long j2 = j + 4611686018427387933L;
            Object[] objArr3 = new Object[1];
            k(MotionEvent.axisFromString("") + 23, new char[]{55981, 25981, 7024, 23012, 5827, 44509, 12648, 2928, 57520, 53986, 38123, 57462, 64355, 44524, 1531, 51819, 54221, 4735, 62063, 12350, 56040, 48671}, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            k(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 34, new char[]{31806, 21986, 27945, 2915, 42480, 26339, 57649, 15456, 36088, 29664, 38498, 7316, 7953, 58716, 13120, 6370}, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame8 == null) {
                    int i5 = 26 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                    char c2 = (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                    int i6 = 1040 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                    byte[] bArr2 = $$j;
                    byte b2 = bArr2[11];
                    byte b3 = bArr2[5];
                    Object[] objArr5 = new Object[1];
                    j(b2, (byte) (b3 - 1), b3, objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i5, c2, i6, 1145017376, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i7 = ((int[]) objArr6[3])[0];
                int i8 = ((int[]) objArr6[2])[0];
                String[] strArr = (String[]) objArr6[0];
                int i9 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().navigationHidden;
                int i10 = (~((-881105977) | i9)) | 268437504;
                int i11 = ((((-6678306) + (i10 * 992)) + ((i10 | (~((~i9) | (-190333698)))) * (-496))) + ((i9 | (-803002170)) * 496)) - 1162075765;
                int i12 = (i11 << 13) ^ i11;
                int i13 = i12 ^ (i12 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i13 ^ (i13 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                k(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(1) - 85, new char[]{54112, 42450, 58490, 460, 44501, 9387, 55981, 25981, 34711, 12251, 51559, 5529, 58615, 52007, 25037, 38451}, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                k(17 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), new char[]{63177, 19995, 38152, 36197, 25964, 36411, 43657, 9454, 58731, 1311, 31731, 22804, 21709, 38113, 30024, 14584}, objArr8);
                int iIntValue = ((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue();
                try {
                    Object[] objArr9 = {-914042404};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(8 - (ViewConfiguration.getScrollBarSize() >> 8), (char) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 22251), TextUtils.lastIndexOf("", '0') + 1034, 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr9), -1162075765, false);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame2 == null) {
                        int iLastIndexOf = TextUtils.lastIndexOf("", '0', 0, 0) + 27;
                        char scrollDefaultDelay = (char) (ViewConfiguration.getScrollDefaultDelay() >> 16);
                        int gidForName = 1040 - Process.getGidForName("");
                        byte[] bArr3 = $$j;
                        byte b4 = bArr3[11];
                        byte b5 = bArr3[5];
                        Object[] objArr10 = new Object[1];
                        j(b4, (byte) (b5 - 1), b5, objArr10);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, scrollDefaultDelay, gidForName, 1145017376, false, (String) objArr10[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
                    try {
                        Object[] objArr11 = new Object[1];
                        k(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 27, new char[]{55981, 25981, 7024, 23012, 5827, 44509, 12648, 2928, 57520, 53986, 38123, 57462, 64355, 44524, 1531, 51819, 54221, 4735, 62063, 12350, 56040, 48671}, objArr11);
                        Class<?> cls3 = Class.forName((String) objArr11[0]);
                        Object[] objArr12 = new Object[1];
                        k(TextUtils.indexOf("", "") + 15, new char[]{31806, 21986, 27945, 2915, 42480, 26339, 57649, 15456, 36088, 29664, 38498, 7316, 7953, 58716, 13120, 6370}, objArr12);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr12[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame3 == null) {
                            int iIndexOf = 26 - TextUtils.indexOf("", "");
                            char mirror = (char) (AndroidCharacter.getMirror('0') - '0');
                            int iMyPid = (Process.myPid() >> 22) + 1041;
                            byte[] bArr4 = $$j;
                            byte b6 = bArr4[21];
                            Object[] objArr13 = new Object[1];
                            j(b6, (byte) (b6 + 1), bArr4[5], objArr13);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iIndexOf, mirror, iMyPid, 2061780482, false, (String) objArr13[0], null);
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
            k(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(1) - 85, new char[]{54112, 42450, 58490, 460, 44501, 9387, 55981, 25981, 34711, 12251, 51559, 5529, 58615, 52007, 25037, 38451}, objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            k(17 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), new char[]{63177, 19995, 38152, 36197, 25964, 36411, 43657, 9454, 58731, 1311, 31731, 22804, 21709, 38113, 30024, 14584}, objArr15);
            int iIntValue2 = ((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr16 = {-914042404};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(8 - (ViewConfiguration.getScrollBarSize() >> 8), (char) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 22251), TextUtils.lastIndexOf("", '0') + 1034, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr16), -1162075765, false);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame2 == null) {
                int iLastIndexOf2 = TextUtils.lastIndexOf("", '0', 0, 0) + 27;
                char scrollDefaultDelay2 = (char) (ViewConfiguration.getScrollDefaultDelay() >> 16);
                int gidForName2 = 1040 - Process.getGidForName("");
                byte[] bArr5 = $$j;
                byte b7 = bArr5[11];
                byte b8 = bArr5[5];
                Object[] objArr17 = new Object[1];
                j(b7, (byte) (b8 - 1), b8, objArr17);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iLastIndexOf2, scrollDefaultDelay2, gidForName2, 1145017376, false, (String) objArr17[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr18 = new Object[1];
            k(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 27, new char[]{55981, 25981, 7024, 23012, 5827, 44509, 12648, 2928, 57520, 53986, 38123, 57462, 64355, 44524, 1531, 51819, 54221, 4735, 62063, 12350, 56040, 48671}, objArr18);
            Class<?> cls5 = Class.forName((String) objArr18[0]);
            Object[] objArr19 = new Object[1];
            k(TextUtils.indexOf("", "") + 15, new char[]{31806, 21986, 27945, 2915, 42480, 26339, 57649, 15456, 36088, 29664, 38498, 7316, 7953, 58716, 13120, 6370}, objArr19);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr19[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame3 == null) {
                int iIndexOf2 = 26 - TextUtils.indexOf("", "");
                char mirror2 = (char) (AndroidCharacter.getMirror('0') - '0');
                int iMyPid2 = (Process.myPid() >> 22) + 1041;
                byte[] bArr6 = $$j;
                byte b9 = bArr6[21];
                Object[] objArr110 = new Object[1];
                j(b9, (byte) (b9 + 1), bArr6[5], objArr110);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iIndexOf2, mirror2, iMyPid2, 2061780482, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i14 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i15 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i15 == i14) {
            Object[] objArr20 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i16 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i17 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i18 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int i19 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().densityDpi;
            int i20 = ~((-88606722) | i19);
            int i21 = ~i19;
            int i22 = i16 + 1003085265 + ((i20 | (~(367587315 | i21))) * 497) + (((~(i19 | 367587315)) | (~((-357084402) | i21)) | 268477680) * 497);
            int i23 = (i22 << 13) ^ i22;
            int i24 = i23 ^ (i23 >>> 17);
            ((int[]) objArr20[1])[0] = i24 ^ (i24 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr3 != null) {
                int i25 = getARTIFICIAL_FRAME_PACKAGE_NAME + 13;
                artificialFrame = i25 % 128;
                int i26 = i25 % 2;
                for (String str : strArr3) {
                    int i27 = artificialFrame + 9;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i27 % 128;
                    int i28 = i27 % 2;
                    arrayList.add(str);
                }
            }
            long j3 = ((long) (i14 ^ i15)) ^ (((long) 238884497) << 32);
            long j4 = 238884499;
            int i29 = artificialFrame + 87;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i29 % 128;
            int i30 = i29 % 2;
            try {
                Object[] objArr21 = {Long.valueOf(j3), Long.valueOf(j4)};
                byte b10 = (byte) ($$w & 95);
                byte[] bArr7 = $$v;
                Object[] objArr22 = new Object[1];
                l(b10, (byte) (b10 + 3), bArr7[68], objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                l(bArr7[68], bArr7[66], (byte) (-bArr7[13]), objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i31 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i32 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i33 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int startUptimeMillis = (int) Process.getStartUptimeMillis();
                int i34 = ~startUptimeMillis;
                int i35 = i31 + (-15064148) + (((~((-265023869) | i34)) | 71544952) * (-108)) + (((~(i34 | 343127675)) | (~((-343127676) | startUptimeMillis)) | (-536606592)) * 54) + ((startUptimeMillis | (-536606592)) * 54);
                int i36 = (i35 << 13) ^ i35;
                int i37 = i36 ^ (i36 >>> 17);
                ((int[]) objArr24[1])[0] = i37 ^ (i37 << 5);
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
            int i38 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 24;
            char cIndexOf = (char) (TextUtils.indexOf("", "", 0, 0) + 30068);
            int offsetAfter = TextUtils.getOffsetAfter("", 0) + 816;
            byte[] bArr8 = $$j;
            byte b11 = bArr8[21];
            Object[] objArr25 = new Object[1];
            j(b11, (byte) (b11 + 1), bArr8[5], objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(i38, cIndexOf, offsetAfter, 721586079, false, (String) objArr25[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j5 != -1) {
            long j6 = j5 + 1871;
            Object[] objArr26 = new Object[1];
            k(Color.red(0) + 22, new char[]{55981, 25981, 7024, 23012, 5827, 44509, 12648, 2928, 57520, 53986, 38123, 57462, 64355, 44524, 1531, 51819, 54221, 4735, 62063, 12350, 56040, 48671}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            k(15 - View.MeasureSpec.getMode(0), new char[]{31806, 21986, 27945, 2915, 42480, 26339, 57649, 15456, 36088, 29664, 38498, 7316, 7953, 58716, 13120, 6370}, objArr27);
            if (j6 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame10 == null) {
                    int iIndexOf3 = 25 - TextUtils.indexOf("", "", 0, 0);
                    char offsetBefore = (char) (TextUtils.getOffsetBefore("", 0) + 30068);
                    int pressedStateDuration2 = 816 - (ViewConfiguration.getPressedStateDuration() >> 16);
                    byte[] bArr9 = $$j;
                    byte b12 = bArr9[11];
                    byte b13 = bArr9[5];
                    Object[] objArr28 = new Object[1];
                    j(b12, (byte) (b13 - 1), b13, objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iIndexOf3, offsetBefore, pressedStateDuration2, 891606461, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i39 = ((int[]) objArr29[0])[0];
                int i40 = ((int[]) objArr29[1])[0];
                String[] strArr5 = (String[]) objArr29[2];
                int iIdentityHashCode = System.identityHashCode(this);
                int i41 = (-1148354397) + (((~iIdentityHashCode) | 472923990) * 1444) + (((~(iIdentityHashCode | (-704557285))) | (~(902729650 | iIdentityHashCode)) | 137375812) * (-1444)) + 1118246655;
                int i42 = (i41 << 13) ^ i41;
                int i43 = i42 ^ (i42 >>> 17);
                ((int[]) objArr[3])[0] = i43 ^ (i43 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                k(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, new char[]{54112, 42450, 58490, 460, 44501, 9387, 55981, 25981, 34711, 12251, 51559, 5529, 58615, 52007, 25037, 38451}, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                k(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 33, new char[]{63177, 19995, 38152, 36197, 25964, 36411, 43657, 9454, 58731, 1311, 31731, 22804, 21709, 38113, 30024, 14584}, objArr31);
                Object[] objArr32 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue()), 0, -1028015523};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame4 == null) {
                    int i44 = 24 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                    char cMyPid = (char) (30068 - (Process.myPid() >> 22));
                    int scrollBarFadeDuration = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 816;
                    byte[] bArr10 = $$j;
                    byte b14 = (byte) (-bArr10[19]);
                    byte b15 = bArr10[5];
                    Object[] objArr33 = new Object[1];
                    j(b14, b15, (byte) (b15 - 1), objArr33);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i44, cMyPid, scrollBarFadeDuration, -797394565, false, (String) objArr33[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr32);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame5 == null) {
                    int scrollBarFadeDuration2 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 25;
                    char packedPositionGroup = (char) (30068 - ExpandableListView.getPackedPositionGroup(0L));
                    int iRgb = (-16776400) - Color.rgb(0, 0, 0);
                    byte[] bArr11 = $$j;
                    byte b16 = bArr11[11];
                    byte b17 = bArr11[5];
                    Object[] objArr34 = new Object[1];
                    j(b16, (byte) (b17 - 1), b17, objArr34);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration2, packedPositionGroup, iRgb, 891606461, false, (String) objArr34[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr);
                try {
                    Object[] objArr35 = new Object[1];
                    k(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 13, new char[]{55981, 25981, 7024, 23012, 5827, 44509, 12648, 2928, 57520, 53986, 38123, 57462, 64355, 44524, 1531, 51819, 54221, 4735, 62063, 12350, 56040, 48671}, objArr35);
                    Class<?> cls9 = Class.forName((String) objArr35[0]);
                    Object[] objArr36 = new Object[1];
                    k(14 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), new char[]{31806, 21986, 27945, 2915, 42480, 26339, 57649, 15456, 36088, 29664, 38498, 7316, 7953, 58716, 13120, 6370}, objArr36);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr36[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame6 == null) {
                        int iRgb2 = Color.rgb(0, 0, 0) + 16777241;
                        char maximumFlingVelocity = (char) (30068 - (ViewConfiguration.getMaximumFlingVelocity() >> 16));
                        int iResolveSizeAndState = 816 - View.resolveSizeAndState(0, 0, 0);
                        byte[] bArr12 = $$j;
                        byte b18 = bArr12[21];
                        Object[] objArr37 = new Object[1];
                        j(b18, (byte) (b18 + 1), bArr12[5], objArr37);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iRgb2, maximumFlingVelocity, iResolveSizeAndState, 721586079, false, (String) objArr37[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr38 = new Object[1];
            k(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, new char[]{54112, 42450, 58490, 460, 44501, 9387, 55981, 25981, 34711, 12251, 51559, 5529, 58615, 52007, 25037, 38451}, objArr38);
            Class<?> cls10 = Class.forName((String) objArr38[0]);
            Object[] objArr39 = new Object[1];
            k(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 33, new char[]{63177, 19995, 38152, 36197, 25964, 36411, 43657, 9454, 58731, 1311, 31731, 22804, 21709, 38113, 30024, 14584}, objArr39);
            Object[] objArr310 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr39[0], Object.class).invoke(null, this)).intValue()), 0, -1028015523};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame4 == null) {
                int i45 = 24 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                char cMyPid2 = (char) (30068 - (Process.myPid() >> 22));
                int scrollBarFadeDuration3 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 816;
                byte[] bArr13 = $$j;
                byte b19 = (byte) (-bArr13[19]);
                byte b110 = bArr13[5];
                Object[] objArr311 = new Object[1];
                j(b19, b110, (byte) (b110 - 1), objArr311);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i45, cMyPid2, scrollBarFadeDuration3, -797394565, false, (String) objArr311[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr310);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame5 == null) {
                int scrollBarFadeDuration4 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 25;
                char packedPositionGroup2 = (char) (30068 - ExpandableListView.getPackedPositionGroup(0L));
                int iRgb3 = (-16776400) - Color.rgb(0, 0, 0);
                byte[] bArr14 = $$j;
                byte b111 = bArr14[11];
                byte b112 = bArr14[5];
                Object[] objArr312 = new Object[1];
                j(b111, (byte) (b112 - 1), b112, objArr312);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration4, packedPositionGroup2, iRgb3, 891606461, false, (String) objArr312[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr);
            Object[] objArr313 = new Object[1];
            k(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 13, new char[]{55981, 25981, 7024, 23012, 5827, 44509, 12648, 2928, 57520, 53986, 38123, 57462, 64355, 44524, 1531, 51819, 54221, 4735, 62063, 12350, 56040, 48671}, objArr313);
            Class<?> cls11 = Class.forName((String) objArr313[0]);
            Object[] objArr314 = new Object[1];
            k(14 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), new char[]{31806, 21986, 27945, 2915, 42480, 26339, 57649, 15456, 36088, 29664, 38498, 7316, 7953, 58716, 13120, 6370}, objArr314);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr314[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame6 == null) {
                int iRgb4 = Color.rgb(0, 0, 0) + 16777241;
                char maximumFlingVelocity2 = (char) (30068 - (ViewConfiguration.getMaximumFlingVelocity() >> 16));
                int iResolveSizeAndState2 = 816 - View.resolveSizeAndState(0, 0, 0);
                byte[] bArr15 = $$j;
                byte b113 = bArr15[21];
                Object[] objArr315 = new Object[1];
                j(b113, (byte) (b113 + 1), bArr15[5], objArr315);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iRgb4, maximumFlingVelocity2, iResolveSizeAndState2, 721586079, false, (String) objArr315[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i46 = ((int[]) objArr[1])[0];
        int i47 = ((int[]) objArr[0])[0];
        if (i47 == i46) {
            int i48 = getARTIFICIAL_FRAME_PACKAGE_NAME + 17;
            artificialFrame = i48 % 128;
            int i49 = i48 % 2;
            Object[] objArr40 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i50 = ((int[]) objArr[3])[0];
            int i51 = ((int[]) objArr[0])[0];
            int i52 = ((int[]) objArr[1])[0];
            String[] strArr6 = (String[]) objArr[2];
            int i53 = ~System.identityHashCode(this);
            int i54 = i50 + (-1905804427) + (((~(i53 | (-172527649))) | (~((-25644162) | i53))) * (-184)) + ((278 | (~((-25644440) | i53)) | (~((-172527927) | i53))) * SyslogConstants.LOG_LOCAL7) + 2103925640;
            int i55 = (i54 << 13) ^ i54;
            int i56 = i55 ^ (i55 >>> 17);
            ((int[]) objArr40[3])[0] = i56 ^ (i56 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArr[2];
        if (strArr7 != null) {
            for (String str2 : strArr7) {
                arrayList2.add(str2);
            }
        }
        long j7 = ((long) (i46 ^ i47)) ^ (((long) (-1696076939)) << 32);
        long j8 = -1696076940;
        int i57 = artificialFrame + 15;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i57 % 128;
        int i58 = i57 % 2;
        Object[] objArr41 = {Long.valueOf(j7), Long.valueOf(j8)};
        byte[] bArr16 = $$v;
        Object[] objArr42 = new Object[1];
        l((byte) (-bArr16[32]), bArr16[68], bArr16[22], objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        byte b20 = bArr16[68];
        byte b21 = bArr16[66];
        byte b22 = (byte) (-bArr16[13]);
        Object[] objArr43 = new Object[1];
        l(b20, b21, b22, objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
        int i59 = ((int[]) objArr[3])[0];
        int i60 = ((int[]) objArr[0])[0];
        int i61 = ((int[]) objArr[1])[0];
        String[] strArr8 = (String[]) objArr[2];
        int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
        int i62 = ~iMaxMemory;
        int i63 = i59 + 1252087578 + (((~(i62 | (-289379116))) | 487551481) * (-1042)) + (((-289379116) | iMaxMemory) * 521) + (((~(iMaxMemory | (-487551482))) | 201351376 | (~(i62 | (-3179011)))) * 521);
        int i64 = (i63 << 13) ^ i63;
        int i65 = i64 ^ (i64 >>> 17);
        ((int[]) objArr44[3])[0] = i65 ^ (i65 << 5);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService, com.google.firebase.messaging.EnhancedIntentService, android.app.Service
    public void onCreate() {
        int i = 2 % 2;
        int i2 = artificialFrame + 21;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        int i3 = i2 % 2;
        super.onCreate();
        int i4 = getARTIFICIAL_FRAME_PACKAGE_NAME + 39;
        artificialFrame = i4 % 128;
        int i5 = i4 % 2;
    }
}
