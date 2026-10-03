package net.time4j.android;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import com.google.android.gms.stats.zza;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import io.sentry.android.core.performance.AppStartMetrics;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import o.ArtificialStackFrames;
import o.onRelationshipValidationResult;

/* JADX INFO: loaded from: classes6.dex */
public abstract class TimeApplication extends Application {
    private static final byte[] $$c = {Ascii.EM, -12, SignedBytes.MAX_POWER_OF_TWO, 107};
    private static final int $$f = 240;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$d = {73, -128, -106, 120, -3, -4, -19, -7, -3, 54, -2, -66, -12, -13, 8, -20, -3, 6, -18, 55, -73, -3, 4, -26, 7, -16, -10, -2, 56, -58, -20, 3, -21, -4, -1, -2, 47, -29, -40, -8, -6, -20, -7, 6, -6, 10, -35, 5, -15, -1, -22, 44, -42, -4, -22, -11, 8, -20, -7, -68, -19, -5, 56, -64, -15, -7, 1, -12, 0, 48, -60, -22, -14, 2, -11, -2, 58, -77, 4, -12, -4, 54, -58, -11, -3, -10, 47, -26, -43, -21, 39, -35, -30, 38, -33, -27, 78, -20};
    private static final int $$e = 171;
    private static final byte[] $$a = {67, 111, Ascii.EM, 19, 5, -1, -33, 33, -2, -9, 5, -7, 5, -1, -50, 39, Ascii.VT, -7, -12, Ascii.SI, Ascii.ESC, 1, -7, -6, -33, 51, -12, 3, -8, 1, Ascii.CR};
    private static final int $$b = 196;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static long onPostMessage = 46624862796373488L;

    private static String $$g(short s, short s2, short s3) {
        int i = 111 - (s * 4);
        int i2 = s3 * 4;
        int i3 = 4 - (s2 * 2);
        byte[] bArr = $$c;
        byte[] bArr2 = new byte[1 - i2];
        int i4 = 0 - i2;
        int i5 = -1;
        if (bArr == null) {
            i3++;
            i = (-i) + i3;
            i5 = -1;
        }
        while (true) {
            int i6 = i5 + 1;
            bArr2[i6] = (byte) i;
            if (i6 == i4) {
                return new String(bArr2, 0);
            }
            i3++;
            i = (-bArr[i3]) + i;
            i5 = i6;
        }
    }

    private static void a(int i, int i2, byte b, Object[] objArr) {
        int i3 = (i * 28) + 84;
        int i4 = i2 + 4;
        byte[] bArr = $$a;
        int i5 = b * 3;
        byte[] bArr2 = new byte[i5 + 9];
        int i6 = i5 + 8;
        int i7 = -1;
        if (bArr == null) {
            i3 += i6;
        }
        while (true) {
            i7++;
            i4++;
            bArr2[i7] = (byte) i3;
            if (i7 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i3 += bArr[i4];
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0029  */
    /* JADX WARN: Code duplicated, block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0034). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0029
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void c(byte r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = net.time4j.android.TimeApplication.$$d
            int r8 = r8 * 2
            int r8 = 59 - r8
            int r7 = r7 * 4
            int r1 = 55 - r7
            int r6 = r6 * 3
            int r6 = 111 - r6
            byte[] r1 = new byte[r1]
            int r7 = 54 - r7
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r8
            r4 = r2
            goto L34
        L18:
            r3 = r2
        L19:
            r5 = r8
            r8 = r6
            r6 = r5
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            int r6 = r6 + 1
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r8
            r8 = r6
            r6 = r4
            r4 = r3
            r3 = r5
        L34:
            int r6 = -r6
            int r3 = r3 + r6
            int r6 = r3 + (-7)
            r3 = r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.android.TimeApplication.c(byte, short, byte, java.lang.Object[]):void");
    }

    @Override // android.app.Application
    public void onCreate() {
        AppStartMetrics.onApplicationCreate(this);
        super.onCreate();
        ApplicationStarter.initialize((Context) this, false);
        AppStartMetrics.onApplicationPostCreate(this);
    }

    private static void b(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        onRelationshipValidationResult onrelationshipvalidationresult = new onRelationshipValidationResult();
        char[] cArrAccessartificialFrame = onRelationshipValidationResult.accessartificialFrame(onPostMessage ^ 2573525503365829440L, cArr, i);
        onrelationshipvalidationresult.e = 4;
        int i3 = $10 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
        $11 = i3 % 128;
        int i4 = i3 % 2;
        while (onrelationshipvalidationresult.e < cArrAccessartificialFrame.length) {
            int i5 = $10 + 33;
            $11 = i5 % 128;
            int i6 = i5 % 2;
            onrelationshipvalidationresult.d = onrelationshipvalidationresult.e - 4;
            int i7 = onrelationshipvalidationresult.e;
            try {
                Object[] objArr2 = {Long.valueOf(cArrAccessartificialFrame[onrelationshipvalidationresult.e] ^ cArrAccessartificialFrame[onrelationshipvalidationresult.e % 4]), Long.valueOf(onrelationshipvalidationresult.d), Long.valueOf(onPostMessage)};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(797310229);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(27 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) (30690 - ExpandableListView.getPackedPositionGroup(0L)), TextUtils.indexOf((CharSequence) "", '0', 0) + 189, -1327449315, false, "k", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                }
                cArrAccessartificialFrame[i7] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                Object[] objArr3 = {onrelationshipvalidationresult, onrelationshipvalidationresult};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(321542193);
                if (objAccessartificialFrame2 == null) {
                    byte b = (byte) 0;
                    byte b2 = b;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(33 - Color.alpha(0), (char) ((-1) - MotionEvent.axisFromString("")), ((Process.getThreadPriority(0) + 20) >> 6) + 1483, -1940971975, false, $$g(b, b2, b2), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame2).invoke(null, objArr3);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        objArr[0] = new String(cArrAccessartificialFrame, 4, cArrAccessartificialFrame.length - 4);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x017f  */
    /* JADX WARN: Code duplicated, block: B:17:0x01ff A[Catch: all -> 0x09e1, TryCatch #0 {all -> 0x09e1, blocks: (B:52:0x06ca, B:54:0x06eb, B:55:0x073e, B:15:0x01eb, B:17:0x01ff, B:18:0x0229), top: B:92:0x01eb }] */
    /* JADX WARN: Code duplicated, block: B:21:0x023f  */
    /* JADX WARN: Code duplicated, block: B:26:0x0311  */
    /* JADX WARN: Code duplicated, block: B:51:0x0668  */
    /* JADX WARN: Code duplicated, block: B:54:0x06eb A[Catch: all -> 0x09e1, TryCatch #0 {all -> 0x09e1, blocks: (B:52:0x06ca, B:54:0x06eb, B:55:0x073e, B:15:0x01eb, B:17:0x01ff, B:18:0x0229), top: B:92:0x01eb }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0750  */
    /* JADX WARN: Code duplicated, block: B:63:0x080c  */
    @Override // android.content.ContextWrapper
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
            int tapTimeout = 26 - (ViewConfiguration.getTapTimeout() >> 16);
            char cNormalizeMetaState = (char) KeyEvent.normalizeMetaState(0);
            int i2 = 1042 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
            byte[] bArr = $$a;
            byte b = bArr[21];
            byte b2 = bArr[5];
            Object[] objArr2 = new Object[1];
            a(b, b2, (byte) (b2 + 1), objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(tapTimeout, cNormalizeMetaState, i2, 2061780482, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 2003;
            Object[] objArr3 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 49, new char[]{3185, 16505, 42397, 1092, 3088, 52903, 47257, 43046, 14046, 35168, 64985, 58042, 31134, 17466, 14163, 9607, 48200, 32506, 26697, 22641, 59164, 14730, 44433, 37691, 10706, 62562}, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            b(1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), new char[]{24768, 63938, 17330, 60884, 24741, 30494, 24243, 16820, 23155, 12503, 7158, 2902, 5413, 64915, 53566, 52272, 53481, 51039, 36471}, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame8 == null) {
                    int trimmedLength = 26 - TextUtils.getTrimmedLength("");
                    char keyRepeatTimeout = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                    int mode = 1041 - View.MeasureSpec.getMode(0);
                    byte[] bArr2 = $$a;
                    byte b3 = bArr2[21];
                    Object[] objArr5 = new Object[1];
                    a(b3, (byte) (-bArr2[11]), (byte) (b3 - 1), objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(trimmedLength, keyRepeatTimeout, mode, 1145017376, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i3 = ((int[]) objArr6[3])[0];
                int i4 = ((int[]) objArr6[2])[0];
                String[] strArr = (String[]) objArr6[0];
                int iIdentityHashCode = System.identityHashCode(this);
                int i5 = (((((~((-652403135) | iIdentityHashCode)) | 572653758) * (-566)) + 2077583634) + ((~(iIdentityHashCode | (-79749377))) * 566)) - 184614448;
                int i6 = (i5 << 13) ^ i5;
                int i7 = i6 ^ (i6 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i7 ^ (i7 << 5);
                int i8 = getARTIFICIAL_FRAME_PACKAGE_NAME + 31;
                artificialFrame = i8 % 128;
                int i9 = i8 % 2;
            } else {
                Object[] objArr7 = new Object[1];
                b(TextUtils.getCapsMode("", 0, 0), new char[]{8344, 22407, 45496, 48881, 8434, 55638, 44206, 4736, 6774, 40603, 59897, 22607, 21887, 21401, 8971, 40728, 37035, 26883, 31869, 58060}, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4, new char[]{27524, 64135, 12125, 41651, 27629, 29779, 12888, 3789, 20784, 13214, 30473, 17434, 7756, 65238, 48590, 33611, 56199, 50200, 58009, 65158}, objArr8);
                int iIntValue = ((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue();
                try {
                    Object[] objArr9 = {1423125811};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(ExpandableListView.getPackedPositionType(0L) + 8, (char) (TextUtils.getOffsetBefore("", 0) + 22251), 1033 - View.MeasureSpec.getMode(0), 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = zza.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr9), -184614448, false);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame2 == null) {
                        int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 26;
                        char c = (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
                        int iLastIndexOf = 1040 - TextUtils.lastIndexOf("", '0', 0);
                        byte[] bArr3 = $$a;
                        byte b4 = bArr3[21];
                        Object[] objArr10 = new Object[1];
                        a(b4, (byte) (-bArr3[11]), (byte) (b4 - 1), objArr10);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay, c, iLastIndexOf, 1145017376, false, (String) objArr10[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
                    try {
                        Object[] objArr11 = new Object[1];
                        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35, new char[]{3185, 16505, 42397, 1092, 3088, 52903, 47257, 43046, 14046, 35168, 64985, 58042, 31134, 17466, 14163, 9607, 48200, 32506, 26697, 22641, 59164, 14730, 44433, 37691, 10706, 62562}, objArr11);
                        Class<?> cls3 = Class.forName((String) objArr11[0]);
                        Object[] objArr12 = new Object[1];
                        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4, new char[]{24768, 63938, 17330, 60884, 24741, 30494, 24243, 16820, 23155, 12503, 7158, 2902, 5413, 64915, 53566, 52272, 53481, 51039, 36471}, objArr12);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr12[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame3 == null) {
                            int iAxisFromString = 25 - MotionEvent.axisFromString("");
                            char maxKeyCode = (char) (KeyEvent.getMaxKeyCode() >> 16);
                            int scrollBarFadeDuration = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 1041;
                            byte[] bArr4 = $$a;
                            byte b5 = bArr4[21];
                            byte b6 = bArr4[5];
                            Object[] objArr13 = new Object[1];
                            a(b5, b6, (byte) (b6 + 1), objArr13);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iAxisFromString, maxKeyCode, scrollBarFadeDuration, 2061780482, false, (String) objArr13[0], null);
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
            b(TextUtils.getCapsMode("", 0, 0), new char[]{8344, 22407, 45496, 48881, 8434, 55638, 44206, 4736, 6774, 40603, 59897, 22607, 21887, 21401, 8971, 40728, 37035, 26883, 31869, 58060}, objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4, new char[]{27524, 64135, 12125, 41651, 27629, 29779, 12888, 3789, 20784, 13214, 30473, 17434, 7756, 65238, 48590, 33611, 56199, 50200, 58009, 65158}, objArr15);
            int iIntValue2 = ((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr16 = {1423125811};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(ExpandableListView.getPackedPositionType(0L) + 8, (char) (TextUtils.getOffsetBefore("", 0) + 22251), 1033 - View.MeasureSpec.getMode(0), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = zza.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr16), -184614448, false);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame2 == null) {
                int keyRepeatDelay2 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 26;
                char c2 = (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
                int iLastIndexOf2 = 1040 - TextUtils.lastIndexOf("", '0', 0);
                byte[] bArr5 = $$a;
                byte b7 = bArr5[21];
                Object[] objArr17 = new Object[1];
                a(b7, (byte) (-bArr5[11]), (byte) (b7 - 1), objArr17);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay2, c2, iLastIndexOf2, 1145017376, false, (String) objArr17[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr18 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35, new char[]{3185, 16505, 42397, 1092, 3088, 52903, 47257, 43046, 14046, 35168, 64985, 58042, 31134, 17466, 14163, 9607, 48200, 32506, 26697, 22641, 59164, 14730, 44433, 37691, 10706, 62562}, objArr18);
            Class<?> cls5 = Class.forName((String) objArr18[0]);
            Object[] objArr19 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4, new char[]{24768, 63938, 17330, 60884, 24741, 30494, 24243, 16820, 23155, 12503, 7158, 2902, 5413, 64915, 53566, 52272, 53481, 51039, 36471}, objArr19);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr19[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame3 == null) {
                int iAxisFromString2 = 25 - MotionEvent.axisFromString("");
                char maxKeyCode2 = (char) (KeyEvent.getMaxKeyCode() >> 16);
                int scrollBarFadeDuration2 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 1041;
                byte[] bArr6 = $$a;
                byte b8 = bArr6[21];
                byte b9 = bArr6[5];
                Object[] objArr110 = new Object[1];
                a(b8, b9, (byte) (b9 + 1), objArr110);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iAxisFromString2, maxKeyCode2, scrollBarFadeDuration2, 2061780482, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i10 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i11 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i11 == i10) {
            int i12 = artificialFrame + 99;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i12 % 128;
            int i13 = i12 % 2;
            Object[] objArr20 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i14 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i15 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i16 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int mode2 = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getMode();
            int i17 = ~mode2;
            int i18 = i14 + (-1088259046) + (((~((-12746214) | mode2)) | (~((-65357594) | i17))) * (-370)) + (((~(mode2 | (-65357594))) | (~(i17 | (-12746214))) | (-65503230)) * (-370)) + 1533608676;
            int i19 = (i18 << 13) ^ i18;
            int i20 = i19 ^ (i19 >>> 17);
            ((int[]) objArr20[1])[0] = i20 ^ (i20 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr3 != null) {
                for (String str : strArr3) {
                    arrayList.add(str);
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf((((long) (-1321950455)) << 32) ^ ((long) (i10 ^ i11))), Long.valueOf(-1321950453)};
                byte[] bArr7 = $$d;
                byte b10 = bArr7[68];
                byte b11 = b10;
                Object[] objArr22 = new Object[1];
                c(b10, b11, (byte) (b11 | Ascii.FS), objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                c((byte) 25, (byte) (-bArr7[13]), bArr7[66], objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i21 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i22 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i23 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int iMyTid = Process.myTid();
                int i24 = i21 + 1625555234 + ((~(75478269 | iMyTid)) * (-301)) + (((~((-70160410) | iMyTid)) | (~((~iMyTid) | 7943397))) * (-301)) + (((~(iMyTid | (-7943398))) | (-70160410)) * 301);
                int i25 = (i24 << 13) ^ i24;
                int i26 = i25 ^ (i25 >>> 17);
                ((int[]) objArr24[1])[0] = i26 ^ (i26 << 5);
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
            int scrollBarSize = 25 - (ViewConfiguration.getScrollBarSize() >> 8);
            char tapTimeout2 = (char) ((ViewConfiguration.getTapTimeout() >> 16) + 30068);
            int i27 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 816;
            byte[] bArr8 = $$a;
            byte b12 = bArr8[21];
            byte b13 = bArr8[5];
            Object[] objArr25 = new Object[1];
            a(b12, b13, (byte) (b13 + 1), objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(scrollBarSize, tapTimeout2, i27, 721586079, false, (String) objArr25[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j3 != -1) {
            long j4 = j3 + 1948;
            Object[] objArr26 = new Object[1];
            b(ViewConfiguration.getMaximumFlingVelocity() >> 16, new char[]{3185, 16505, 42397, 1092, 3088, 52903, 47257, 43046, 14046, 35168, 64985, 58042, 31134, 17466, 14163, 9607, 48200, 32506, 26697, 22641, 59164, 14730, 44433, 37691, 10706, 62562}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4, new char[]{24768, 63938, 17330, 60884, 24741, 30494, 24243, 16820, 23155, 12503, 7158, 2902, 5413, 64915, 53566, 52272, 53481, 51039, 36471}, objArr27);
            if (j4 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i28 = artificialFrame + 25;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i28 % 128;
                int i29 = i28 % 2;
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame10 == null) {
                    int i30 = 25 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                    char cRed = (char) (30068 - Color.red(0));
                    int iIndexOf = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 817;
                    byte[] bArr9 = $$a;
                    byte b14 = bArr9[21];
                    Object[] objArr28 = new Object[1];
                    a(b14, (byte) (-bArr9[11]), (byte) (b14 - 1), objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(i30, cRed, iIndexOf, 891606461, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i31 = ((int[]) objArr29[0])[0];
                int i32 = ((int[]) objArr29[1])[0];
                String[] strArr5 = (String[]) objArr29[2];
                int i33 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().mcc;
                int i34 = (((~((-136625366) | i33)) | 193961261) * 262) + 1090032081 + (((~((~i33) | (-136625366))) | 193961261) * 262) + 606370174;
                int i35 = (i34 << 13) ^ i34;
                int i36 = i35 ^ (i35 >>> 17);
                ((int[]) objArr[3])[0] = i36 ^ (i36 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                b(ViewConfiguration.getDoubleTapTimeout() >> 16, new char[]{8344, 22407, 45496, 48881, 8434, 55638, 44206, 4736, 6774, 40603, 59897, 22607, 21887, 21401, 8971, 40728, 37035, 26883, 31869, 58060}, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35, new char[]{27524, 64135, 12125, 41651, 27629, 29779, 12888, 3789, 20784, 13214, 30473, 17434, 7756, 65238, 48590, 33611, 56199, 50200, 58009, 65158}, objArr31);
                Object[] objArr32 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue()), 0, 606370174};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame4 == null) {
                    int packedPositionType = 25 - ExpandableListView.getPackedPositionType(0L);
                    char modifierMetaStateMask = (char) (30067 - ((byte) KeyEvent.getModifierMetaStateMask()));
                    int i37 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 815;
                    byte[] bArr10 = $$a;
                    byte b15 = bArr10[21];
                    Object[] objArr33 = new Object[1];
                    a((byte) (b15 - 1), bArr10[19], b15, objArr33);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(packedPositionType, modifierMetaStateMask, i37, -797394565, false, (String) objArr33[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr32);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame5 == null) {
                    int iLastIndexOf3 = 24 - TextUtils.lastIndexOf("", '0', 0, 0);
                    char cMyPid = (char) ((Process.myPid() >> 22) + 30068);
                    int i38 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 816;
                    byte[] bArr11 = $$a;
                    byte b16 = bArr11[21];
                    Object[] objArr34 = new Object[1];
                    a(b16, (byte) (-bArr11[11]), (byte) (b16 - 1), objArr34);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iLastIndexOf3, cMyPid, i38, 891606461, false, (String) objArr34[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr);
                try {
                    Object[] objArr35 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 4, new char[]{3185, 16505, 42397, 1092, 3088, 52903, 47257, 43046, 14046, 35168, 64985, 58042, 31134, 17466, 14163, 9607, 48200, 32506, 26697, 22641, 59164, 14730, 44433, 37691, 10706, 62562}, objArr35);
                    Class<?> cls9 = Class.forName((String) objArr35[0]);
                    Object[] objArr36 = new Object[1];
                    b(ViewConfiguration.getFadingEdgeLength() >> 16, new char[]{24768, 63938, 17330, 60884, 24741, 30494, 24243, 16820, 23155, 12503, 7158, 2902, 5413, 64915, 53566, 52272, 53481, 51039, 36471}, objArr36);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr36[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame6 == null) {
                        int i39 = 26 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                        char cIndexOf = (char) (TextUtils.indexOf("", "") + 30068);
                        int packedPositionType2 = ExpandableListView.getPackedPositionType(0L) + 816;
                        byte[] bArr12 = $$a;
                        byte b17 = bArr12[21];
                        byte b18 = bArr12[5];
                        Object[] objArr37 = new Object[1];
                        a(b17, b18, (byte) (b18 + 1), objArr37);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i39, cIndexOf, packedPositionType2, 721586079, false, (String) objArr37[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr38 = new Object[1];
            b(ViewConfiguration.getDoubleTapTimeout() >> 16, new char[]{8344, 22407, 45496, 48881, 8434, 55638, 44206, 4736, 6774, 40603, 59897, 22607, 21887, 21401, 8971, 40728, 37035, 26883, 31869, 58060}, objArr38);
            Class<?> cls10 = Class.forName((String) objArr38[0]);
            Object[] objArr39 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35, new char[]{27524, 64135, 12125, 41651, 27629, 29779, 12888, 3789, 20784, 13214, 30473, 17434, 7756, 65238, 48590, 33611, 56199, 50200, 58009, 65158}, objArr39);
            Object[] objArr310 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr39[0], Object.class).invoke(null, this)).intValue()), 0, 606370174};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame4 == null) {
                int packedPositionType3 = 25 - ExpandableListView.getPackedPositionType(0L);
                char modifierMetaStateMask2 = (char) (30067 - ((byte) KeyEvent.getModifierMetaStateMask()));
                int i310 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 815;
                byte[] bArr13 = $$a;
                byte b19 = bArr13[21];
                Object[] objArr311 = new Object[1];
                a((byte) (b19 - 1), bArr13[19], b19, objArr311);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(packedPositionType3, modifierMetaStateMask2, i310, -797394565, false, (String) objArr311[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr310);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame5 == null) {
                int iLastIndexOf4 = 24 - TextUtils.lastIndexOf("", '0', 0, 0);
                char cMyPid2 = (char) ((Process.myPid() >> 22) + 30068);
                int i311 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 816;
                byte[] bArr14 = $$a;
                byte b110 = bArr14[21];
                Object[] objArr312 = new Object[1];
                a(b110, (byte) (-bArr14[11]), (byte) (b110 - 1), objArr312);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iLastIndexOf4, cMyPid2, i311, 891606461, false, (String) objArr312[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr);
            Object[] objArr313 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 4, new char[]{3185, 16505, 42397, 1092, 3088, 52903, 47257, 43046, 14046, 35168, 64985, 58042, 31134, 17466, 14163, 9607, 48200, 32506, 26697, 22641, 59164, 14730, 44433, 37691, 10706, 62562}, objArr313);
            Class<?> cls11 = Class.forName((String) objArr313[0]);
            Object[] objArr314 = new Object[1];
            b(ViewConfiguration.getFadingEdgeLength() >> 16, new char[]{24768, 63938, 17330, 60884, 24741, 30494, 24243, 16820, 23155, 12503, 7158, 2902, 5413, 64915, 53566, 52272, 53481, 51039, 36471}, objArr314);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr314[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame6 == null) {
                int i312 = 26 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                char cIndexOf2 = (char) (TextUtils.indexOf("", "") + 30068);
                int packedPositionType4 = ExpandableListView.getPackedPositionType(0L) + 816;
                byte[] bArr15 = $$a;
                byte b111 = bArr15[21];
                byte b112 = bArr15[5];
                Object[] objArr315 = new Object[1];
                a(b111, b112, (byte) (b112 + 1), objArr315);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i312, cIndexOf2, packedPositionType4, 721586079, false, (String) objArr315[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i40 = ((int[]) objArr[1])[0];
        int i41 = ((int[]) objArr[0])[0];
        if (i41 == i40) {
            Object[] objArr40 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i42 = ((int[]) objArr[3])[0];
            int i43 = ((int[]) objArr[0])[0];
            int i44 = ((int[]) objArr[1])[0];
            String[] strArr6 = (String[]) objArr[2];
            int i45 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().densityDpi;
            int i46 = (-1040776307) + (((~(397805368 | i45)) | (-199633003)) * 672);
            int i47 = ~i45;
            int i48 = i42 + i46 + (((~(i45 | (-199633003))) | (~((-397805369) | i47))) * (-672)) + (((~(199633002 | i47)) | (-536227707)) * 672);
            int i49 = (i48 << 13) ^ i48;
            int i50 = i49 ^ (i49 >>> 17);
            ((int[]) objArr40[3])[0] = i50 ^ (i50 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArr[2];
        if (strArr7 != null) {
            int i51 = artificialFrame + 25;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i51 % 128;
            int i52 = i51 % 2;
            for (String str2 : strArr7) {
                arrayList2.add(str2);
            }
        }
        Object[] objArr41 = {Long.valueOf(((long) (i40 ^ i41)) ^ (((long) (-17135788)) << 32)), Long.valueOf(-17135787)};
        byte[] bArr16 = $$d;
        byte b20 = bArr16[22];
        Object[] objArr42 = new Object[1];
        c(b20, b20, bArr16[68], objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        Object[] objArr43 = new Object[1];
        c((byte) 25, (byte) (-bArr16[13]), bArr16[66], objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
        int i53 = ((int[]) objArr[3])[0];
        int i54 = ((int[]) objArr[0])[0];
        int i55 = ((int[]) objArr[1])[0];
        String[] strArr8 = (String[]) objArr[2];
        int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
        int i56 = i53 + 511202156 + (((~(iMaxMemory | 190889783)) | (-191872952)) * 305) + (((~((~iMaxMemory) | 190889783)) | (-7282583)) * 305);
        int i57 = (i56 << 13) ^ i56;
        int i58 = i57 ^ (i57 >>> 17);
        ((int[]) objArr44[3])[0] = i58 ^ (i58 << 5);
    }
}
