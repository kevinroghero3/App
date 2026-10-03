package com.google.firebase.components;

import android.app.Service;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.IBinder;
import android.os.Process;
import android.os.SystemClock;
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
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import com.reactnativekeyboardcontroller.listeners.FocusedInputObserver;
import com.swmansion.gesturehandler.core.NativeViewGestureHandler;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import o.ArtificialStackFrames;
import o.artificialFrame;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes5.dex */
public class ComponentDiscoveryService extends Service {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    private static int[] ICustomTabsCallbackStub;
    private static int artificialFrame;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static final byte[] $$c = {5, -37, 48, 84};
    private static final int $$f = 214;
    private static int $10 = 0;
    private static int $11 = 1;

    private static String $$g(short s, short s2, short s3) {
        byte[] bArr = $$c;
        int i = 4 - (s2 * 4);
        int i2 = s * 3;
        int i3 = 115 - (s3 * 6);
        byte[] bArr2 = new byte[i2 + 1];
        int i4 = -1;
        if (bArr == null) {
            i++;
            i3 = i + i3;
        }
        while (true) {
            int i5 = i3;
            int i6 = i;
            i4++;
            bArr2[i4] = (byte) i5;
            if (i4 == i2) {
                return new String(bArr2, 0);
            }
            i = i6 + 1;
            i3 = i5 + bArr[i6];
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x0028). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(byte r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 + 4
            int r0 = 21 - r7
            byte[] r1 = com.google.firebase.components.ComponentDiscoveryService.$$a
            int r8 = r8 + 65
            byte[] r0 = new byte[r0]
            int r7 = 20 - r7
            r2 = 0
            if (r1 != 0) goto L13
            r3 = r8
            r4 = r2
            r8 = r6
            goto L28
        L13:
            r3 = r2
            r5 = r8
            r8 = r6
            r6 = r5
        L17:
            byte r4 = (byte) r6
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L26:
            r3 = r1[r8]
        L28:
            int r6 = r6 + r3
            int r8 = r8 + 1
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.components.ComponentDiscoveryService.a(byte, int, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0028). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void c(int r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r0 = 89 - r8
            byte[] r1 = com.google.firebase.components.ComponentDiscoveryService.$$d
            int r6 = 111 - r6
            int r7 = 784 - r7
            byte[] r0 = new byte[r0]
            int r8 = 88 - r8
            r2 = 0
            if (r1 != 0) goto L13
            r3 = r7
            r6 = r8
            r4 = r2
            goto L28
        L13:
            r3 = r2
        L14:
            byte r4 = (byte) r6
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L23:
            r3 = r1[r7]
            r5 = r3
            r3 = r7
            r7 = r5
        L28:
            int r7 = -r7
            int r6 = r6 + r7
            int r7 = r3 + 1
            int r6 = r6 + (-4)
            r3 = r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.components.ComponentDiscoveryService.c(int, int, byte, java.lang.Object[]):void");
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    private static void b(int i, int[] iArr, Object[] objArr) throws Throwable {
        int length;
        int[] iArr2;
        int i2;
        int i3 = 2 % 2;
        artificialFrame artificialframe = new artificialFrame();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr3 = ICustomTabsCallbackStub;
        int i4 = -1780896814;
        long j = 0;
        int i5 = 1;
        int i6 = 0;
        if (iArr3 != null) {
            int i7 = $10 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
            $11 = i7 % 128;
            if (i7 % 2 == 0) {
                length = iArr3.length;
                iArr2 = new int[length];
                i2 = 1;
            } else {
                length = iArr3.length;
                iArr2 = new int[length];
                i2 = 0;
            }
            while (i2 < length) {
                try {
                    Object[] objArr2 = {Integer.valueOf(iArr3[i2])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i4);
                    if (objAccessartificialFrame == null) {
                        int i8 = 12 - (SystemClock.uptimeMillis() > j ? 1 : (SystemClock.uptimeMillis() == j ? 0 : -1));
                        char absoluteGravity = (char) Gravity.getAbsoluteGravity(0, 0);
                        int i9 = (SystemClock.elapsedRealtime() > j ? 1 : (SystemClock.elapsedRealtime() == j ? 0 : -1)) + 1561;
                        byte b = (byte) 0;
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i8, absoluteGravity, i9, 180153818, false, $$g(b, b2, (byte) (b2 + 1)), new Class[]{Integer.TYPE});
                    }
                    iArr2[i2] = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                    i2++;
                    i4 = -1780896814;
                    j = 0;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            iArr3 = iArr2;
        }
        int length2 = iArr3.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = ICustomTabsCallbackStub;
        int i10 = 16;
        if (iArr5 != null) {
            int i11 = $10 + 75;
            $11 = i11 % 128;
            int i12 = i11 % 2;
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            int i13 = 0;
            while (i13 < length3) {
                Object[] objArr3 = new Object[i5];
                objArr3[i6] = Integer.valueOf(iArr5[i13]);
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                if (objAccessartificialFrame2 == null) {
                    byte b3 = (byte) i6;
                    byte b4 = b3;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0') + 12, (char) (ViewConfiguration.getKeyRepeatTimeout() >> i10), 1562 - ExpandableListView.getPackedPositionGroup(0L), 180153818, false, $$g(b3, b4, (byte) (b4 + 1)), new Class[]{Integer.TYPE});
                }
                iArr6[i13] = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                i13++;
                i10 = 16;
                i5 = 1;
                i6 = 0;
            }
            iArr5 = iArr6;
        }
        int i14 = i6;
        System.arraycopy(iArr5, i14, iArr4, i14, length2);
        artificialframe.e = i14;
        while (artificialframe.e < iArr.length) {
            int i15 = $10 + 23;
            $11 = i15 % 128;
            int i16 = i15 % 2;
            cArr[0] = (char) (iArr[artificialframe.e] >> 16);
            cArr[1] = (char) iArr[artificialframe.e];
            cArr[2] = (char) (iArr[artificialframe.e + 1] >> 16);
            cArr[3] = (char) iArr[artificialframe.e + 1];
            artificialframe.c = (cArr[0] << 16) + cArr[1];
            artificialframe.b = (cArr[2] << 16) + cArr[3];
            artificialFrame.coroutineBoundary(iArr4);
            int i17 = 0;
            for (int i18 = 16; i17 < i18; i18 = 16) {
                int i19 = $10 + 47;
                $11 = i19 % 128;
                int i20 = i19 % 2;
                artificialframe.c ^= iArr4[i17];
                Object[] objArr4 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) 0;
                    byte b6 = b5;
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(26 - (KeyEvent.getMaxKeyCode() >> 16), (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 1040, 995482881, false, $$g(b5, b6, b6), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                }
                int iIntValue = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
                artificialframe.c = artificialframe.b;
                artificialframe.b = iIntValue;
                i17++;
            }
            int i21 = artificialframe.c;
            artificialframe.c = artificialframe.b;
            artificialframe.b = i21;
            artificialframe.b ^= iArr4[16];
            artificialframe.c ^= iArr4[17];
            int i22 = artificialframe.c;
            int i23 = artificialframe.b;
            cArr[0] = (char) (artificialframe.c >>> 16);
            cArr[1] = (char) artificialframe.c;
            cArr[2] = (char) (artificialframe.b >>> 16);
            cArr[3] = (char) artificialframe.b;
            artificialFrame.coroutineBoundary(iArr4);
            cArr2[artificialframe.e * 2] = cArr[0];
            cArr2[(artificialframe.e * 2) + 1] = cArr[1];
            cArr2[(artificialframe.e * 2) + 2] = cArr[2];
            cArr2[(artificialframe.e * 2) + 3] = cArr[3];
            Object[] objArr5 = {artificialframe, artificialframe};
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1348396126);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 36, (char) (28010 - View.MeasureSpec.getSize(0)), 306 - (ViewConfiguration.getJumpTapTimeout() >> 16), -818175402, false, "q", new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame4).invoke(null, objArr5);
        }
        objArr[0] = new String(cArr2, 0, i);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:16:0x0242 A[Catch: all -> 0x0a58, TryCatch #0 {all -> 0x0a58, blocks: (B:54:0x070b, B:56:0x072b, B:57:0x077c, B:14:0x022d, B:16:0x0242, B:17:0x0274), top: B:94:0x022d }] */
    /* JADX WARN: Code duplicated, block: B:20:0x028a  */
    /* JADX WARN: Code duplicated, block: B:25:0x0339  */
    /* JADX WARN: Code duplicated, block: B:53:0x069a  */
    /* JADX WARN: Code duplicated, block: B:56:0x072b A[Catch: all -> 0x0a58, TryCatch #0 {all -> 0x0a58, blocks: (B:54:0x070b, B:56:0x072b, B:57:0x077c, B:14:0x022d, B:16:0x0242, B:17:0x0274), top: B:94:0x022d }] */
    /* JADX WARN: Code duplicated, block: B:60:0x078e  */
    /* JADX WARN: Code duplicated, block: B:65:0x0874  */
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
        int i2 = artificialFrame + 43;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        int i3 = i2 % 2;
        super.attachBaseContext(context);
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame7 == null) {
            int maximumDrawingCacheSize = 26 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
            char jumpTapTimeout = (char) (ViewConfiguration.getJumpTapTimeout() >> 16);
            int iBlue = 1041 - Color.blue(0);
            byte[] bArr = $$a;
            byte b = (byte) (bArr[21] - 1);
            byte b2 = bArr[117];
            Object[] objArr2 = new Object[1];
            a(b, b2, (byte) (b2 | 35), objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize, jumpTapTimeout, iBlue, 2061780482, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            int i4 = getARTIFICIAL_FRAME_PACKAGE_NAME + 11;
            artificialFrame = i4 % 128;
            int i5 = i4 % 2;
            long j2 = j + 4611686018427387936L;
            Object[] objArr3 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 18, new int[]{1802067637, 221425841, -1999815928, -1714467939, -1126996722, 390396655, -52104403, -1235866967, -1081997611, -1559699111, -2125258089, 1758934596}, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(0) - 22, new int[]{2050249073, 296820352, 717637726, 1991410281, -641435488, 1676159735, -817338408, -116535386}, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i6 = artificialFrame + 75;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i6 % 128;
                int i7 = i6 % 2;
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame8 == null) {
                    int jumpTapTimeout2 = (ViewConfiguration.getJumpTapTimeout() >> 16) + 26;
                    char keyRepeatTimeout = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                    int iBlue2 = Color.blue(0) + 1041;
                    byte[] bArr2 = $$a;
                    byte b3 = bArr2[113];
                    byte b4 = bArr2[117];
                    Object[] objArr5 = new Object[1];
                    a(b3, b4, (byte) (b4 | 35), objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout2, keyRepeatTimeout, iBlue2, 1145017376, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i8 = ((int[]) objArr6[3])[0];
                int i9 = ((int[]) objArr6[2])[0];
                String[] strArr = (String[]) objArr6[0];
                int iIdentityHashCode = System.identityHashCode(this);
                int i10 = (-1816673330) + (((~((~iIdentityHashCode) | (-877052301))) | (-798948494)) * (-235)) + (((~((-877052301) | iIdentityHashCode)) | (-798948494)) * (-470)) + (((~(iIdentityHashCode | (-604422285))) | (-1071578510)) * 235) + 1458220788;
                int i11 = (i10 << 13) ^ i10;
                int i12 = i11 ^ (i11 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i12 ^ (i12 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 12, new int[]{268866862, -659541228, 1238501072, -523834731, 350923996, -1296905456, 1129350738, -817311259}, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                b(((Process.getThreadPriority(0) + 20) >> 6) + 16, new int[]{-182193589, 1929305075, 440705564, -1487796834, 1599643372, -262802111, 1666267226, 1915679190}, objArr8);
                int iIntValue = ((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue();
                try {
                    Object[] objArr9 = {-306085745};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 8, (char) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 22251), 1033 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = FocusedInputObserver.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr9), 1458220788, false);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame2 == null) {
                        int capsMode = TextUtils.getCapsMode("", 0, 0) + 26;
                        char c = (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
                        int iArgb = Color.argb(0, 0, 0, 0) + 1041;
                        byte[] bArr3 = $$a;
                        byte b5 = bArr3[113];
                        byte b6 = bArr3[117];
                        Object[] objArr10 = new Object[1];
                        a(b5, b6, (byte) (b6 | 35), objArr10);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(capsMode, c, iArgb, 1145017376, false, (String) objArr10[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
                    try {
                        Object[] objArr11 = new Object[1];
                        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 13, new int[]{1802067637, 221425841, -1999815928, -1714467939, -1126996722, 390396655, -52104403, -1235866967, -1081997611, -1559699111, -2125258089, 1758934596}, objArr11);
                        Class<?> cls3 = Class.forName((String) objArr11[0]);
                        Object[] objArr12 = new Object[1];
                        b(16 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), new int[]{2050249073, 296820352, 717637726, 1991410281, -641435488, 1676159735, -817338408, -116535386}, objArr12);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr12[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame3 == null) {
                            int longPressTimeout = (ViewConfiguration.getLongPressTimeout() >> 16) + 26;
                            char cIndexOf = (char) TextUtils.indexOf("", "", 0, 0);
                            int deadChar = KeyEvent.getDeadChar(0, 0) + 1041;
                            byte[] bArr4 = $$a;
                            byte b7 = (byte) (bArr4[21] - 1);
                            byte b8 = bArr4[117];
                            Object[] objArr13 = new Object[1];
                            a(b7, b8, (byte) (b8 | 35), objArr13);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(longPressTimeout, cIndexOf, deadChar, 2061780482, false, (String) objArr13[0], null);
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
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 12, new int[]{268866862, -659541228, 1238501072, -523834731, 350923996, -1296905456, 1129350738, -817311259}, objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            b(((Process.getThreadPriority(0) + 20) >> 6) + 16, new int[]{-182193589, 1929305075, 440705564, -1487796834, 1599643372, -262802111, 1666267226, 1915679190}, objArr15);
            int iIntValue2 = ((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr16 = {-306085745};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 8, (char) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 22251), 1033 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = FocusedInputObserver.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr16), 1458220788, false);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame2 == null) {
                int capsMode2 = TextUtils.getCapsMode("", 0, 0) + 26;
                char c2 = (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
                int iArgb2 = Color.argb(0, 0, 0, 0) + 1041;
                byte[] bArr5 = $$a;
                byte b9 = bArr5[113];
                byte b10 = bArr5[117];
                Object[] objArr17 = new Object[1];
                a(b9, b10, (byte) (b10 | 35), objArr17);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(capsMode2, c2, iArgb2, 1145017376, false, (String) objArr17[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr18 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 13, new int[]{1802067637, 221425841, -1999815928, -1714467939, -1126996722, 390396655, -52104403, -1235866967, -1081997611, -1559699111, -2125258089, 1758934596}, objArr18);
            Class<?> cls5 = Class.forName((String) objArr18[0]);
            Object[] objArr19 = new Object[1];
            b(16 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), new int[]{2050249073, 296820352, 717637726, 1991410281, -641435488, 1676159735, -817338408, -116535386}, objArr19);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr19[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame3 == null) {
                int longPressTimeout2 = (ViewConfiguration.getLongPressTimeout() >> 16) + 26;
                char cIndexOf2 = (char) TextUtils.indexOf("", "", 0, 0);
                int deadChar2 = KeyEvent.getDeadChar(0, 0) + 1041;
                byte[] bArr6 = $$a;
                byte b11 = (byte) (bArr6[21] - 1);
                byte b12 = bArr6[117];
                Object[] objArr110 = new Object[1];
                a(b11, b12, (byte) (b12 | 35), objArr110);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(longPressTimeout2, cIndexOf2, deadChar2, 2061780482, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i13 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i14 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i14 == i13) {
            int i15 = artificialFrame + 97;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i15 % 128;
            int i16 = i15 % 2;
            Object[] objArr20 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i17 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i18 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i19 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int i20 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().widthPixels;
            int i21 = ~((-212303394) | i20);
            int i22 = ~i20;
            int i23 = i17 + (-215814882) + ((i21 | (~((-134199587) | i22))) * (-1808)) + (((~((-134235650) | i20)) | (~(i22 | (-56131843)))) * TypedValues.Custom.TYPE_BOOLEAN) + (((~(i20 | 134199586)) | 78067744 | (~(212303393 | i22))) * TypedValues.Custom.TYPE_BOOLEAN);
            int i24 = (i23 << 13) ^ i23;
            int i25 = i24 ^ (i24 >>> 17);
            ((int[]) objArr20[1])[0] = i25 ^ (i25 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr3 != null) {
                int i26 = 0;
                while (i26 < strArr3.length) {
                    int i27 = artificialFrame + 3;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i27 % 128;
                    if (i27 % 2 != 0) {
                        arrayList.add(strArr3[i26]);
                        i26 += 127;
                    } else {
                        arrayList.add(strArr3[i26]);
                        i26++;
                    }
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf((((long) (-860275164)) << 32) ^ ((long) (i13 ^ i14))), Long.valueOf(-860275162)};
                byte[] bArr7 = $$d;
                byte b13 = bArr7[4];
                Object[] objArr22 = new Object[1];
                c(b13, (short) (b13 | Ascii.FF), bArr7[193], objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                c((byte) (-bArr7[146]), (short) 737, (byte) 86, objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i28 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i29 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i30 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int iIdentityHashCode2 = System.identityHashCode(this);
                int i31 = (-705741234) + ((~(iIdentityHashCode2 | 693413006)) * JfifUtil.MARKER_SOI);
                int i32 = ~iIdentityHashCode2;
                int i33 = i28 + i31 + ((771555215 | i32) * (-216)) + (((~(i32 | 693413006)) | (-615309200)) * JfifUtil.MARKER_SOI);
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
            int scrollBarSize = (ViewConfiguration.getScrollBarSize() >> 8) + 25;
            char deadChar3 = (char) (KeyEvent.getDeadChar(0, 0) + 30068);
            int longPressTimeout3 = (ViewConfiguration.getLongPressTimeout() >> 16) + 816;
            byte[] bArr8 = $$a;
            byte b14 = (byte) (bArr8[21] - 1);
            byte b15 = bArr8[117];
            Object[] objArr25 = new Object[1];
            a(b14, b15, (byte) (b15 | 35), objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(scrollBarSize, deadChar3, longPressTimeout3, 721586079, false, (String) objArr25[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j3 != -1) {
            long j4 = j3 + 1851;
            Object[] objArr26 = new Object[1];
            b(22 - (ViewConfiguration.getTapTimeout() >> 16), new int[]{1802067637, 221425841, -1999815928, -1714467939, -1126996722, 390396655, -52104403, -1235866967, -1081997611, -1559699111, -2125258089, 1758934596}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 11, new int[]{2050249073, 296820352, 717637726, 1991410281, -641435488, 1676159735, -817338408, -116535386}, objArr27);
            if (j4 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i36 = getARTIFICIAL_FRAME_PACKAGE_NAME + 53;
                artificialFrame = i36 % 128;
                int i37 = i36 % 2;
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame10 == null) {
                    int iBlue3 = 25 - Color.blue(0);
                    char pressedStateDuration = (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 30068);
                    int i38 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 815;
                    byte[] bArr9 = $$a;
                    byte b16 = bArr9[113];
                    byte b17 = bArr9[117];
                    Object[] objArr28 = new Object[1];
                    a(b16, b17, (byte) (b17 | 35), objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iBlue3, pressedStateDuration, i38, 891606461, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i39 = ((int[]) objArr29[0])[0];
                int i40 = ((int[]) objArr29[1])[0];
                String[] strArr5 = (String[]) objArr29[2];
                int i41 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().navigation;
                int i42 = 1951699385 + (((~((-47909643) | i41)) | (-150262724)) * (-948)) + ((~((~i41) | (-13632259))) * (-948)) + 1446515955;
                int i43 = (i42 << 13) ^ i42;
                int i44 = i43 ^ (i43 >>> 17);
                ((int[]) objArr[3])[0] = i44 ^ (i44 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 12, new int[]{268866862, -659541228, 1238501072, -523834731, 350923996, -1296905456, 1129350738, -817311259}, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                b((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 16, new int[]{-182193589, 1929305075, 440705564, -1487796834, 1599643372, -262802111, 1666267226, 1915679190}, objArr31);
                Object[] objArr32 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue()), 0, -418261433};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame4 == null) {
                    int iCombineMeasuredStates = 25 - View.combineMeasuredStates(0, 0);
                    char c3 = (char) (30069 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                    int size = 816 - View.MeasureSpec.getSize(0);
                    byte b18 = (byte) ($$b & 124);
                    byte[] bArr10 = $$a;
                    Object[] objArr33 = new Object[1];
                    a(b18, bArr10[53], bArr10[37], objArr33);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates, c3, size, -797394565, false, (String) objArr33[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr32);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame5 == null) {
                    int i45 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 24;
                    char c4 = (char) (30068 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)));
                    int iMyPid = (Process.myPid() >> 22) + 816;
                    byte[] bArr11 = $$a;
                    byte b19 = bArr11[113];
                    byte b20 = bArr11[117];
                    Object[] objArr34 = new Object[1];
                    a(b19, b20, (byte) (b20 | 35), objArr34);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i45, c4, iMyPid, 891606461, false, (String) objArr34[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr);
                try {
                    Object[] objArr35 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 14, new int[]{1802067637, 221425841, -1999815928, -1714467939, -1126996722, 390396655, -52104403, -1235866967, -1081997611, -1559699111, -2125258089, 1758934596}, objArr35);
                    Class<?> cls9 = Class.forName((String) objArr35[0]);
                    Object[] objArr36 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 11, new int[]{2050249073, 296820352, 717637726, 1991410281, -641435488, 1676159735, -817338408, -116535386}, objArr36);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr36[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame6 == null) {
                        int iResolveOpacity = Drawable.resolveOpacity(0, 0) + 25;
                        char absoluteGravity = (char) (30068 - Gravity.getAbsoluteGravity(0, 0));
                        int scrollBarSize2 = (ViewConfiguration.getScrollBarSize() >> 8) + 816;
                        byte[] bArr12 = $$a;
                        byte b21 = (byte) (bArr12[21] - 1);
                        byte b22 = bArr12[117];
                        Object[] objArr37 = new Object[1];
                        a(b21, b22, (byte) (b22 | 35), objArr37);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iResolveOpacity, absoluteGravity, scrollBarSize2, 721586079, false, (String) objArr37[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr38 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 12, new int[]{268866862, -659541228, 1238501072, -523834731, 350923996, -1296905456, 1129350738, -817311259}, objArr38);
            Class<?> cls10 = Class.forName((String) objArr38[0]);
            Object[] objArr39 = new Object[1];
            b((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 16, new int[]{-182193589, 1929305075, 440705564, -1487796834, 1599643372, -262802111, 1666267226, 1915679190}, objArr39);
            Object[] objArr310 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr39[0], Object.class).invoke(null, this)).intValue()), 0, -418261433};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame4 == null) {
                int iCombineMeasuredStates2 = 25 - View.combineMeasuredStates(0, 0);
                char c5 = (char) (30069 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                int size2 = 816 - View.MeasureSpec.getSize(0);
                byte b110 = (byte) ($$b & 124);
                byte[] bArr13 = $$a;
                Object[] objArr311 = new Object[1];
                a(b110, bArr13[53], bArr13[37], objArr311);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates2, c5, size2, -797394565, false, (String) objArr311[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr310);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame5 == null) {
                int i46 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 24;
                char c6 = (char) (30068 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)));
                int iMyPid2 = (Process.myPid() >> 22) + 816;
                byte[] bArr14 = $$a;
                byte b111 = bArr14[113];
                byte b23 = bArr14[117];
                Object[] objArr312 = new Object[1];
                a(b111, b23, (byte) (b23 | 35), objArr312);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i46, c6, iMyPid2, 891606461, false, (String) objArr312[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr);
            Object[] objArr313 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 14, new int[]{1802067637, 221425841, -1999815928, -1714467939, -1126996722, 390396655, -52104403, -1235866967, -1081997611, -1559699111, -2125258089, 1758934596}, objArr313);
            Class<?> cls11 = Class.forName((String) objArr313[0]);
            Object[] objArr314 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 11, new int[]{2050249073, 296820352, 717637726, 1991410281, -641435488, 1676159735, -817338408, -116535386}, objArr314);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr314[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame6 == null) {
                int iResolveOpacity2 = Drawable.resolveOpacity(0, 0) + 25;
                char absoluteGravity2 = (char) (30068 - Gravity.getAbsoluteGravity(0, 0));
                int scrollBarSize3 = (ViewConfiguration.getScrollBarSize() >> 8) + 816;
                byte[] bArr15 = $$a;
                byte b24 = (byte) (bArr15[21] - 1);
                byte b25 = bArr15[117];
                Object[] objArr315 = new Object[1];
                a(b24, b25, (byte) (b25 | 35), objArr315);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iResolveOpacity2, absoluteGravity2, scrollBarSize3, 721586079, false, (String) objArr315[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i47 = ((int[]) objArr[1])[0];
        int i48 = ((int[]) objArr[0])[0];
        if (i48 == i47) {
            Object[] objArr40 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i49 = ((int[]) objArr[3])[0];
            int i50 = ((int[]) objArr[0])[0];
            int i51 = ((int[]) objArr[1])[0];
            String[] strArr6 = (String[]) objArr[2];
            int i52 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().navigation;
            int i53 = ~i52;
            int i54 = i49 + 1090925989 + (((~((-1003379783) | i53)) | 268435462 | (~(805207416 | i53))) * (-1136)) + (((~((-1003379783) | i52)) | (~(805207416 | i52)) | (~((-70263097) | i53))) * (-568)) + (((~(i52 | (-268435463))) | (~(i53 | (-805207417))) | (~(1003379782 | i53))) * 568);
            int i55 = (i54 << 13) ^ i54;
            int i56 = i55 ^ (i55 >>> 17);
            ((int[]) objArr40[3])[0] = i56 ^ (i56 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArr[2];
        if (strArr7 != null) {
            int i57 = getARTIFICIAL_FRAME_PACKAGE_NAME + 25;
            artificialFrame = i57 % 128;
            int i58 = i57 % 2;
            for (String str : strArr7) {
                arrayList2.add(str);
            }
        }
        Object[] objArr41 = {Long.valueOf(((long) (i47 ^ i48)) ^ (((long) (-1287735884)) << 32)), Long.valueOf(-1287735883)};
        byte[] bArr16 = $$d;
        byte b26 = bArr16[92];
        Object[] objArr42 = new Object[1];
        c(b26, (short) (b26 | 723), bArr16[263], objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        Object[] objArr43 = new Object[1];
        c((byte) (-bArr16[146]), (short) 737, (byte) 86, objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
        int i59 = ((int[]) objArr[3])[0];
        int i60 = ((int[]) objArr[0])[0];
        int i61 = ((int[]) objArr[1])[0];
        String[] strArr8 = (String[]) objArr[2];
        int iMyUid = Process.myUid();
        int i62 = (~(101832569 | iMyUid)) | 299900934;
        int i63 = ~((~iMyUid) | (-101728569));
        int i64 = i59 + (-582309423) + ((i62 | i63) * (-470)) + (((~(iMyUid | 401733503)) | i63) * 470);
        int i65 = (i64 << 13) ^ i64;
        int i66 = i65 ^ (i65 >>> 17);
        ((int[]) objArr44[3])[0] = i66 ^ (i66 << 5);
    }

    /* JADX WARN: Code duplicated, block: B:263:0x1d1c  */
    /* JADX WARN: Code duplicated, block: B:266:0x1d25 A[Catch: all -> 0x2424, TryCatch #3 {all -> 0x2424, blocks: (B:299:0x2197, B:301:0x21ac, B:302:0x21df, B:264:0x1d1f, B:266:0x1d25, B:267:0x1d52, B:269:0x1d7c, B:270:0x1e03, B:198:0x15b6, B:200:0x15c3, B:201:0x15f1, B:203:0x15fb, B:205:0x1608, B:206:0x1639, B:14:0x01f8, B:16:0x0219, B:17:0x0269), top: B:356:0x01f8 }] */
    /* JADX WARN: Code duplicated, block: B:269:0x1d7c A[Catch: all -> 0x2424, TryCatch #3 {all -> 0x2424, blocks: (B:299:0x2197, B:301:0x21ac, B:302:0x21df, B:264:0x1d1f, B:266:0x1d25, B:267:0x1d52, B:269:0x1d7c, B:270:0x1e03, B:198:0x15b6, B:200:0x15c3, B:201:0x15f1, B:203:0x15fb, B:205:0x1608, B:206:0x1639, B:14:0x01f8, B:16:0x0219, B:17:0x0269), top: B:356:0x01f8 }] */
    /* JADX WARN: Code duplicated, block: B:273:0x1e16  */
    /* JADX WARN: Code duplicated, block: B:278:0x1e7e  */
    /* JADX WARN: Code duplicated, block: B:298:0x217a  */
    /* JADX WARN: Code duplicated, block: B:301:0x21ac A[Catch: all -> 0x2424, TryCatch #3 {all -> 0x2424, blocks: (B:299:0x2197, B:301:0x21ac, B:302:0x21df, B:264:0x1d1f, B:266:0x1d25, B:267:0x1d52, B:269:0x1d7c, B:270:0x1e03, B:198:0x15b6, B:200:0x15c3, B:201:0x15f1, B:203:0x15fb, B:205:0x1608, B:206:0x1639, B:14:0x01f8, B:16:0x0219, B:17:0x0269), top: B:356:0x01f8 }] */
    /* JADX WARN: Code duplicated, block: B:305:0x21f6  */
    /* JADX WARN: Code duplicated, block: B:310:0x2259  */
    @Override // android.app.Service
    public void onCreate() throws Throwable {
        Object[] objArr;
        int i;
        Object[] objArr2;
        int i2;
        Object[] objArr3;
        int i3;
        Object[] objArr4;
        char c;
        Object[] objArr5;
        int i4;
        Object[] objArr6;
        int i5;
        Object objAccessartificialFrame;
        Object objAccessartificialFrame2;
        Object[] objArr7;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        int i6;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        Object objAccessartificialFrame7;
        Object[] objArr8;
        int i7 = 2 % 2;
        Object[] objArr9 = new Object[1];
        b(Color.blue(0) + 22, new int[]{1802067637, 221425841, -1999815928, -1714467939, -1126996722, 390396655, -52104403, -1235866967, -1081997611, -1559699111, -2125258089, 1758934596}, objArr9);
        String str = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 11, new int[]{2050249073, 296820352, 717637726, 1991410281, -641435488, 1676159735, -817338408, -116535386}, objArr10);
        String str2 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 5, new int[]{268866862, -659541228, 1238501072, -523834731, 350923996, -1296905456, 1129350738, -817311259}, objArr11);
        String str3 = (String) objArr11[0];
        Object[] objArr12 = new Object[1];
        b((ViewConfiguration.getTapTimeout() >> 16) + 16, new int[]{-182193589, 1929305075, 440705564, -1487796834, 1599643372, -262802111, 1666267226, 1915679190}, objArr12);
        String str4 = (String) objArr12[0];
        Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame8 == null) {
            int touchSlop = 25 - (ViewConfiguration.getTouchSlop() >> 8);
            char cAlpha = (char) (Color.alpha(0) + 30068);
            int iGreen = 816 - Color.green(0);
            byte[] bArr = $$a;
            byte b = (byte) (bArr[21] - 1);
            byte b2 = bArr[117];
            Object[] objArr13 = new Object[1];
            a(b, b2, (byte) (b2 | 35), objArr13);
            objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(touchSlop, cAlpha, iGreen, 721586079, false, (String) objArr13[0], null);
        }
        long j = ((Field) objAccessartificialFrame8).getLong(null);
        if (j == -1 || j + 1983 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            try {
                Object[] objArr14 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1380516536};
                Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame9 == null) {
                    int capsMode = 25 - TextUtils.getCapsMode("", 0, 0);
                    char absoluteGravity = (char) (Gravity.getAbsoluteGravity(0, 0) + 30068);
                    int iMyTid = 816 - (Process.myTid() >> 22);
                    byte b3 = (byte) ($$b & 124);
                    byte[] bArr2 = $$a;
                    Object[] objArr15 = new Object[1];
                    a(b3, bArr2[53], bArr2[37], objArr15);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(capsMode, absoluteGravity, iMyTid, -797394565, false, (String) objArr15[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                Object[] objArr16 = (Object[]) ((Method) objAccessartificialFrame9).invoke(null, objArr14);
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame10 == null) {
                    int i8 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 25;
                    char c2 = (char) ((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 30068);
                    int iLastIndexOf = TextUtils.lastIndexOf("", '0', 0, 0) + 817;
                    byte[] bArr3 = $$a;
                    byte b4 = bArr3[113];
                    byte b5 = bArr3[117];
                    Object[] objArr17 = new Object[1];
                    a(b4, b5, (byte) (b5 | 35), objArr17);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(i8, c2, iLastIndexOf, 891606461, false, (String) objArr17[0], null);
                }
                ((Field) objAccessartificialFrame10).set(null, objArr16);
                try {
                    Long lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame11 == null) {
                        int i9 = 25 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                        char offsetAfter = (char) (TextUtils.getOffsetAfter("", 0) + 30068);
                        int keyRepeatDelay = 816 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                        byte[] bArr4 = $$a;
                        byte b6 = (byte) (bArr4[21] - 1);
                        byte b7 = bArr4[117];
                        Object[] objArr18 = new Object[1];
                        a(b6, b7, (byte) (b7 | 35), objArr18);
                        objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(i9, offsetAfter, keyRepeatDelay, 721586079, false, (String) objArr18[0], null);
                    }
                    ((Field) objAccessartificialFrame11).set(null, lValueOf);
                    objArr = objArr16;
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
        } else {
            Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame12 == null) {
                int i10 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 24;
                char mirror = (char) (AndroidCharacter.getMirror('0') + 30020);
                int i11 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 816;
                byte[] bArr5 = $$a;
                byte b8 = bArr5[113];
                byte b9 = bArr5[117];
                Object[] objArr19 = new Object[1];
                a(b8, b9, (byte) (b9 | 35), objArr19);
                objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(i10, mirror, i11, 891606461, false, (String) objArr19[0], null);
            }
            Object[] objArr20 = (Object[]) ((Field) objAccessartificialFrame12).get(null);
            objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i12 = ((int[]) objArr20[0])[0];
            int i13 = ((int[]) objArr20[1])[0];
            String[] strArr = (String[]) objArr20[2];
            int i14 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().keyboard;
            int i15 = ((((~((-196203993) | i14)) | 195155208) * (-283)) - 407478619) + ((~(i14 | (-1048785))) * 283) + 1380516536;
            int i16 = (i15 << 13) ^ i15;
            int i17 = i16 ^ (i16 >>> 17);
            ((int[]) objArr[3])[0] = i17 ^ (i17 << 5);
        }
        int i18 = ((int[]) objArr[1])[0];
        int i19 = ((int[]) objArr[0])[0];
        if (i19 == i18) {
            Object[] objArr21 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i20 = ((int[]) objArr[3])[0];
            int i21 = ((int[]) objArr[0])[0];
            int i22 = ((int[]) objArr[1])[0];
            String[] strArr2 = (String[]) objArr[2];
            int i23 = ~((int) Process.getElapsedCpuTime());
            int i24 = i20 + ((((~((-794410637) | i23)) | 206577664) * (-241)) - 1351106148) + (((~(i23 | (-587832973))) | (-802815935)) * 241);
            int i25 = (i24 << 13) ^ i24;
            int i26 = i25 ^ (i25 >>> 17);
            ((int[]) objArr21[3])[0] = i26 ^ (i26 << 5);
            i = 0;
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr[2];
            if (strArr3 != null) {
                int i27 = artificialFrame + 25;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i27 % 128;
                int i28 = i27 % 2;
                for (String str5 : strArr3) {
                    arrayList.add(str5);
                }
            }
            try {
                Object[] objArr22 = {Long.valueOf(((long) (i18 ^ i19)) ^ (((long) 366814553) << 32)), Long.valueOf(366814552)};
                byte[] bArr6 = $$d;
                byte b10 = bArr6[92];
                Object[] objArr23 = new Object[1];
                c(b10, (short) (b10 | 659), bArr6[69], objArr23);
                Class<?> cls = Class.forName((String) objArr23[0]);
                Object[] objArr24 = new Object[1];
                c((byte) (-bArr6[146]), (short) 737, (byte) 86, objArr24);
                cls.getMethod((String) objArr24[0], Long.TYPE, Long.TYPE).invoke(null, objArr22);
                Object[] objArr25 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i29 = ((int[]) objArr[3])[0];
                int i30 = ((int[]) objArr[0])[0];
                int i31 = ((int[]) objArr[1])[0];
                String[] strArr4 = (String[]) objArr[2];
                int iMyTid2 = Process.myTid();
                int i32 = ~iMyTid2;
                int i33 = i29 + 1264953413 + (((~((-163363174) | i32)) | 1057120) * 168) + ((~((-1057121) | iMyTid2)) * 168) + (((~(iMyTid2 | (-162306054))) | (~(i32 | (-34809193))) | 33752072) * 168);
                int i34 = (i33 << 13) ^ i33;
                int i35 = i34 ^ (i34 >>> 17);
                i = 0;
                ((int[]) objArr25[3])[0] = i35 ^ (i35 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame13 == null) {
            int iBlue = Color.blue(i) + 30;
            char cCombineMeasuredStates = (char) (49362 - View.combineMeasuredStates(i, i));
            int i36 = (TypedValue.complexToFloat(i) > 0.0f ? 1 : (TypedValue.complexToFloat(i) == 0.0f ? 0 : -1)) + 684;
            byte[] bArr7 = $$a;
            byte b11 = bArr7[20];
            byte b12 = bArr7[4];
            Object[] objArr26 = new Object[1];
            a(b11, b12, (byte) (b12 | 40), objArr26);
            objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(iBlue, cCombineMeasuredStates, i36, 752929587, false, (String) objArr26[0], null);
        }
        long j2 = ((Field) objAccessartificialFrame13).getLong(null);
        if (j2 == -1 || j2 + 1939 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr27 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 22, new int[]{1802067637, 221425841, -1999815928, -1714467939, -1514225663, -94003247, 501629826, -1597986539, -811983246, -806166646, -1821279575, -85405290, 632551908, 1440286877}, objArr27);
                Class<?> cls2 = Class.forName((String) objArr27[0]);
                Object[] objArr28 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 17, new int[]{392675646, 1913551018, -836993068, -1677433158, -1755266560, 535029861, 238626251, 1402487628, 73550449, -1948801812}, objArr28);
                baseContext = (Context) cls2.getMethod((String) objArr28[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = ((baseContext instanceof ContextWrapper) && ((ContextWrapper) baseContext).getBaseContext() == null) ? null : baseContext.getApplicationContext();
            }
            int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            int i37 = getARTIFICIAL_FRAME_PACKAGE_NAME + 101;
            artificialFrame = i37 % 128;
            int i38 = i37 % 2;
            try {
                Object[] objArr29 = {baseContext, Integer.valueOf(iIntValue), 0, -1639589132};
                byte[] bArr8 = $$d;
                byte b13 = bArr8[92];
                Object[] objArr30 = new Object[1];
                c(b13, (short) (b13 | 578), (byte) (bArr8[546] - 1), objArr30);
                Class<?> cls3 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                c((byte) (-bArr8[371]), (short) 538, (byte) (-bArr8[579]), objArr31);
                objArr2 = (Object[]) cls3.getMethod((String) objArr31[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr29);
                if (baseContext != null) {
                    Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-326560385);
                    if (objAccessartificialFrame14 == null) {
                        int packedPositionType = 30 - ExpandableListView.getPackedPositionType(0L);
                        char c3 = (char) (49363 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                        int i39 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 683;
                        byte[] bArr9 = $$a;
                        Object[] objArr32 = new Object[1];
                        a((byte) 42, bArr9[4], (byte) (bArr9[15] - 1), objArr32);
                        objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(packedPositionType, c3, i39, 1944867703, false, (String) objArr32[0], null);
                    }
                    ((Field) objAccessartificialFrame14).set(null, objArr2);
                    try {
                        Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                        if (objAccessartificialFrame15 == null) {
                            int i40 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 29;
                            char c4 = (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 49361);
                            int iNormalizeMetaState = 684 - KeyEvent.normalizeMetaState(0);
                            byte[] bArr10 = $$a;
                            byte b14 = bArr10[20];
                            byte b15 = bArr10[4];
                            Object[] objArr33 = new Object[1];
                            a(b14, b15, (byte) (b15 | 40), objArr33);
                            objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(i40, c4, iNormalizeMetaState, 752929587, false, (String) objArr33[0], null);
                        }
                        ((Field) objAccessartificialFrame15).set(null, lValueOf2);
                    } catch (Exception unused2) {
                        throw new RuntimeException();
                    }
                }
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        } else {
            int i41 = getARTIFICIAL_FRAME_PACKAGE_NAME + 9;
            artificialFrame = i41 % 128;
            int i42 = i41 % 2;
            Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-326560385);
            if (objAccessartificialFrame16 == null) {
                int longPressTimeout = (ViewConfiguration.getLongPressTimeout() >> 16) + 30;
                char windowTouchSlop = (char) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 49362);
                int keyRepeatDelay2 = 684 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                byte[] bArr11 = $$a;
                Object[] objArr34 = new Object[1];
                a((byte) 42, bArr11[4], (byte) (bArr11[15] - 1), objArr34);
                objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(longPressTimeout, windowTouchSlop, keyRepeatDelay2, 1944867703, false, (String) objArr34[0], null);
            }
            Object[] objArr35 = (Object[]) ((Field) objAccessartificialFrame16).get(null);
            objArr2 = new Object[]{new int[]{((int[]) objArr35[0])[0]}, new int[]{((int[]) objArr35[1])[0]}, new int[1], (String) objArr35[3]};
            int i43 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().widthPixels;
            int i44 = (((-1188835266) + (((~(i43 | 506872814)) | (-507403263)) * 305)) + (((~((~i43) | 506872814)) | (-471750961)) * 305)) - 1639589132;
            int i45 = (i44 << 13) ^ i44;
            int i46 = i45 ^ (i45 >>> 17);
            ((int[]) objArr2[2])[0] = i46 ^ (i46 << 5);
        }
        int i47 = ((int[]) objArr2[1])[0];
        int i48 = ((int[]) objArr2[0])[0];
        if (i48 == i47) {
            int i49 = ((int[]) objArr2[2])[0];
            Object[] objArr36 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int i50 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().mcc;
            int i51 = i49 + (-1013658914) + (((~((-686065781) | i50)) | 292557994) * (-366)) + (((~(i50 | (-679774293))) | 286266506) * 366);
            int i52 = (i51 << 13) ^ i51;
            int i53 = i52 ^ (i52 >>> 17);
            i2 = 0;
            ((int[]) objArr36[2])[0] = i53 ^ (i53 << 5);
        } else {
            Object[] objArr37 = {Long.valueOf(((long) (i47 ^ i48)) ^ (((long) (-222140192)) << 32)), Long.valueOf(-222140188)};
            byte[] bArr12 = $$d;
            Object[] objArr38 = new Object[1];
            c(bArr12[92], (short) 519, bArr12[229], objArr38);
            Class<?> cls4 = Class.forName((String) objArr38[0]);
            Object[] objArr39 = new Object[1];
            c((byte) (-bArr12[146]), (short) 737, (byte) 86, objArr39);
            cls4.getMethod((String) objArr39[0], Long.TYPE, Long.TYPE).invoke(null, objArr37);
            int i54 = ((int[]) objArr2[2])[0];
            Object[] objArr40 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int iUptimeMillis = (int) SystemClock.uptimeMillis();
            int i55 = i54 + ((~((-88709) | iUptimeMillis)) * 521) + 887140176 + (((~((~iUptimeMillis) | (-88709))) | 832700506) * 521);
            int i56 = (i55 << 13) ^ i55;
            int i57 = i56 ^ (i56 >>> 17);
            i2 = 0;
            ((int[]) objArr40[2])[0] = i57 ^ (i57 << 5);
        }
        Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame17 == null) {
            int iAxisFromString = MotionEvent.axisFromString("") + 31;
            char cIndexOf = (char) (TextUtils.indexOf((CharSequence) "", '0', i2) + 49363);
            int i58 = (TypedValue.complexToFraction(i2, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(i2, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 684;
            byte[] bArr13 = $$a;
            Object[] objArr41 = new Object[1];
            a((byte) 57, bArr13[113], (byte) (bArr13[15] - 1), objArr41);
            objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(iAxisFromString, cIndexOf, i58, -1583976536, false, (String) objArr41[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame17).getLong(null);
        if (j3 == -1 || j3 + 1910 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr42 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -843398027};
            byte[] bArr14 = $$d;
            Object[] objArr43 = new Object[1];
            c(bArr14[125], (short) 453, bArr14[229], objArr43);
            Class<?> cls5 = Class.forName((String) objArr43[0]);
            Object[] objArr44 = new Object[1];
            c((byte) (-bArr14[6]), (short) 387, (byte) (-bArr14[663]), objArr44);
            objArr3 = (Object[]) cls5.getMethod((String) objArr44[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr42);
            Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame18 == null) {
                int bitsPerPixel = ImageFormat.getBitsPerPixel(0) + 31;
                char c5 = (char) (49362 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)));
                int i59 = 685 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                byte[] bArr15 = $$a;
                Object[] objArr45 = new Object[1];
                a((byte) 69, bArr15[117], (byte) (bArr15[15] + 1), objArr45);
                objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(bitsPerPixel, c5, i59, -1456483158, false, (String) objArr45[0], null);
            }
            ((Field) objAccessartificialFrame18).set(null, objArr3);
            try {
                Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame19 == null) {
                    int gidForName = Process.getGidForName("") + 31;
                    char c6 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 49361);
                    int i60 = 685 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                    byte[] bArr16 = $$a;
                    Object[] objArr46 = new Object[1];
                    a((byte) 57, bArr16[113], (byte) (bArr16[15] - 1), objArr46);
                    objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(gidForName, c6, i60, -1583976536, false, (String) objArr46[0], null);
                }
                ((Field) objAccessartificialFrame19).set(null, lValueOf3);
            } catch (Exception unused3) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame20 == null) {
                int i61 = 31 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                char cGreen = (char) (49362 - Color.green(0));
                int iLastIndexOf2 = TextUtils.lastIndexOf("", '0') + 685;
                byte[] bArr17 = $$a;
                Object[] objArr47 = new Object[1];
                a((byte) 69, bArr17[117], (byte) (bArr17[15] + 1), objArr47);
                objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(i61, cGreen, iLastIndexOf2, -1456483158, false, (String) objArr47[0], null);
            }
            Object[] objArr48 = (Object[]) ((Field) objAccessartificialFrame20).get(null);
            objArr3 = new Object[]{new int[]{((int[]) objArr48[0])[0]}, new int[]{((int[]) objArr48[1])[0]}, new int[1], (String) objArr48[3]};
            int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
            int i62 = (((-846980954) + (((-6365218) | (~iFreeMemory)) * (-490))) + (((~(iFreeMemory | (-434200694))) | 427835476) * 490)) - 1322735855;
            int i63 = (i62 << 13) ^ i62;
            int i64 = i63 ^ (i63 >>> 17);
            ((int[]) objArr3[2])[0] = i64 ^ (i64 << 5);
        }
        int i65 = ((int[]) objArr3[1])[0];
        int i66 = ((int[]) objArr3[0])[0];
        if (i66 == i65) {
            int i67 = ((int[]) objArr3[2])[0];
            Object[] objArr49 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
            int iUptimeMillis2 = (int) SystemClock.uptimeMillis();
            int i68 = (~((-3850084) | iUptimeMillis2)) | 1613091;
            int i69 = ~iUptimeMillis2;
            int i70 = i67 + (-1710422304) + ((i68 | (~(977010683 | i69))) * 886) + (((~(i69 | 3850083)) | 974773691) * (-1772)) + ((~(i69 | 974773691)) * 886);
            int i71 = (i70 << 13) ^ i70;
            int i72 = i71 ^ (i71 >>> 17);
            i3 = 0;
            ((int[]) objArr49[2])[0] = i72 ^ (i72 << 5);
        } else {
            new ArrayList().add((String) objArr3[3]);
            Object[] objArr50 = {Long.valueOf(((long) (i65 ^ i66)) ^ (((long) 298902215) << 32)), Long.valueOf(298902231)};
            byte[] bArr18 = $$d;
            Object[] objArr51 = new Object[1];
            c(bArr18[92], (short) 519, bArr18[229], objArr51);
            Class<?> cls6 = Class.forName((String) objArr51[0]);
            Object[] objArr52 = new Object[1];
            c((byte) (-bArr18[146]), (short) 737, (byte) 86, objArr52);
            cls6.getMethod((String) objArr52[0], Long.TYPE, Long.TYPE).invoke(null, objArr50);
            int i73 = ((int[]) objArr3[2])[0];
            Object[] objArr53 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
            int iIdentityHashCode = System.identityHashCode(this);
            int i74 = i73 + (-2063565966) + (((~(iIdentityHashCode | 401863039)) | (-576760736)) * (-668)) + ((401863039 | (~((-576760736) | iIdentityHashCode))) * 1336) + ((iIdentityHashCode | (-536873601)) * 668);
            int i75 = (i74 << 13) ^ i74;
            int i76 = i75 ^ (i75 >>> 17);
            i3 = 0;
            ((int[]) objArr53[2])[0] = i76 ^ (i76 << 5);
        }
        Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame21 == null) {
            int iIndexOf = TextUtils.indexOf("", "", i3, i3) + 21;
            char cResolveSize = (char) View.resolveSize(i3, i3);
            int minimumFlingVelocity = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 465;
            byte[] bArr19 = $$a;
            byte b16 = (byte) (bArr19[21] - 1);
            byte b17 = bArr19[117];
            Object[] objArr54 = new Object[1];
            a(b16, b17, (byte) (b17 | 35), objArr54);
            objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(iIndexOf, cResolveSize, minimumFlingVelocity, -785931255, false, (String) objArr54[0], null);
        }
        long j4 = ((Field) objAccessartificialFrame21).getLong(null);
        if (j4 == -1 || j4 + 1881 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext2 = getBaseContext();
            if (baseContext2 == null) {
                Object[] objArr55 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 9, new int[]{1802067637, 221425841, -1999815928, -1714467939, -1514225663, -94003247, 501629826, -1597986539, -811983246, -806166646, -1821279575, -85405290, 632551908, 1440286877}, objArr55);
                Class<?> cls7 = Class.forName((String) objArr55[0]);
                Object[] objArr56 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 3, new int[]{392675646, 1913551018, -836993068, -1677433158, -1755266560, 535029861, 238626251, 1402487628, 73550449, -1948801812}, objArr56);
                baseContext2 = (Context) cls7.getMethod((String) objArr56[0], new Class[0]).invoke(null, null);
            }
            if (baseContext2 != null) {
                if ((baseContext2 instanceof ContextWrapper) && ((ContextWrapper) baseContext2).getBaseContext() == null) {
                    int i77 = artificialFrame + 119;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i77 % 128;
                    int i78 = i77 % 2;
                    baseContext2 = null;
                } else {
                    baseContext2 = baseContext2.getApplicationContext();
                }
            }
            int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr57 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 29, new int[]{-1201697438, 2077093507, 2015348969, 1201785110, -1716755548, 1764031969, 818642712, 1650558353, -824734123, -363031318, -1850839463, 6720769, -623405891, -355628060, -88291983, 1740895252, 1394371531, 1846928806, -1753172757, -1926846043, -720960733, 944981972, -1422981953, -1931555872, -145567152, 1585375812, 676591458, 183034465, 1794917175, 844513680, 369636985, -1120676659}, objArr57);
            String str6 = (String) objArr57[0];
            Object[] objArr58 = new Object[1];
            b(View.MeasureSpec.makeMeasureSpec(0, 0) + 64, new int[]{88055856, 678030105, 1611817985, -1713189554, -1390246152, 1535071673, -1753551234, -1637773803, -860832357, 98028298, -357519446, -2137644441, 822426622, -984747514, 270982958, 2025203429, -116790558, -670508273, 2096901255, -744098249, -1270303973, 1483571445, -225673274, -894283541, 595511508, 2132391015, 1035033194, 1212540856, -1060891440, 282494447, -930782016, -734273124}, objArr58);
            Object[] objArr59 = {baseContext2, new String[]{str6, (String) objArr58[0]}, Integer.valueOf(iIntValue2), 1, -1122184701};
            byte[] bArr20 = $$d;
            Object[] objArr60 = new Object[1];
            c(bArr20[92], (short) 379, bArr20[4], objArr60);
            Class<?> cls8 = Class.forName((String) objArr60[0]);
            Object[] objArr61 = new Object[1];
            c(bArr20[85], (short) 291, bArr20[305], objArr61);
            objArr4 = (Object[]) cls8.getMethod((String) objArr61[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr59);
            int i79 = ((int[]) objArr4[0])[0];
            int i80 = ((int[]) objArr4[3])[0];
            if (baseContext2 != null) {
                Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame22 == null) {
                    int windowTouchSlop2 = 21 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                    char modifierMetaStateMask = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1);
                    int touchSlop2 = 465 - (ViewConfiguration.getTouchSlop() >> 8);
                    byte[] bArr21 = $$a;
                    byte b18 = bArr21[113];
                    byte b19 = bArr21[117];
                    Object[] objArr62 = new Object[1];
                    a(b18, b19, (byte) (b19 | 35), objArr62);
                    objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(windowTouchSlop2, modifierMetaStateMask, touchSlop2, -612765161, false, (String) objArr62[0], null);
                }
                ((Field) objAccessartificialFrame22).set(null, objArr4);
                try {
                    Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1313006081);
                    if (objAccessartificialFrame23 == null) {
                        int i81 = 22 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                        char c7 = (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                        int iIndexOf2 = TextUtils.indexOf("", "", 0, 0) + 465;
                        byte[] bArr22 = $$a;
                        byte b20 = (byte) (bArr22[21] - 1);
                        byte b21 = bArr22[117];
                        Object[] objArr63 = new Object[1];
                        a(b20, b21, (byte) (b21 | 35), objArr63);
                        objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(i81, c7, iIndexOf2, -785931255, false, (String) objArr63[0], null);
                    }
                    ((Field) objAccessartificialFrame23).set(null, lValueOf4);
                } catch (Exception unused4) {
                    throw new RuntimeException();
                }
            }
            c = 0;
        } else {
            Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(1142731807);
            if (objAccessartificialFrame24 == null) {
                int packedPositionGroup = ExpandableListView.getPackedPositionGroup(0L) + 21;
                char c8 = (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                int iLastIndexOf3 = TextUtils.lastIndexOf("", '0', 0) + 466;
                byte[] bArr23 = $$a;
                byte b22 = bArr23[113];
                byte b23 = bArr23[117];
                Object[] objArr64 = new Object[1];
                a(b22, b23, (byte) (b23 | 35), objArr64);
                objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(packedPositionGroup, c8, iLastIndexOf3, -612765161, false, (String) objArr64[0], null);
            }
            Object[] objArr65 = (Object[]) ((Field) objAccessartificialFrame24).get(null);
            objArr4 = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
            int i82 = ((int[]) objArr65[3])[0];
            int i83 = ((int[]) objArr65[0])[0];
            String[] strArr5 = (String[]) objArr65[1];
            int elapsedCpuTime = (int) Process.getElapsedCpuTime();
            int i84 = 173190301 + (((~(912212554 | elapsedCpuTime)) | (-751862829)) * 672);
            int i85 = ~elapsedCpuTime;
            int i86 = ((i84 + (((~(elapsedCpuTime | (-751862829))) | (~((-912212555) | i85))) * (-672))) + (((~(751862828 | i85)) | (-1054852719)) * 672)) - 1122184701;
            int i87 = (i86 << 13) ^ i86;
            int i88 = i87 ^ (i87 >>> 17);
            ((int[]) objArr4[2])[0] = i88 ^ (i88 << 5);
            c = 0;
        }
        int i89 = ((int[]) objArr4[c])[c];
        int i90 = ((int[]) objArr4[3])[c];
        if (i90 == i89) {
            Object[] objArr66 = new Object[4];
            int[] iArr = new int[1];
            objArr66[c] = iArr;
            objArr66[2] = new int[1];
            int[] iArr2 = new int[1];
            objArr66[3] = iArr2;
            int i91 = ((int[]) objArr4[2])[c];
            int i92 = ((int[]) objArr4[3])[c];
            int i93 = ((int[]) objArr4[c])[c];
            String[] strArr6 = (String[]) objArr4[1];
            iArr2[c] = i92;
            iArr[c] = i93;
            int i94 = ~((~new Random().nextInt(2089330277)) | (-395382384));
            int i95 = i91 + ((((-933220080) | i94) * (-970)) - 836550723) + ((i94 | 537837696) * 970);
            int i96 = (i95 << 13) ^ i95;
            int i97 = i96 ^ (i96 >>> 17);
            ((int[]) objArr66[2])[0] = i97 ^ (i97 << 5);
            objArr66[1] = strArr6;
        } else {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr7 = (String[]) objArr4[1];
            if (strArr7 != null) {
                for (String str7 : strArr7) {
                    arrayList2.add(str7);
                }
            }
            Object[] objArr67 = {Long.valueOf(((long) (i89 ^ i90)) ^ (((long) 694446717) << 32)), Long.valueOf(694446653)};
            byte[] bArr24 = $$d;
            byte b24 = bArr24[92];
            Object[] objArr68 = new Object[1];
            c(b24, (short) (b24 | Ascii.ETX), (byte) (-bArr24[24]), objArr68);
            Class<?> cls9 = Class.forName((String) objArr68[0]);
            Object[] objArr69 = new Object[1];
            c((byte) (-bArr24[146]), (short) 737, (byte) 86, objArr69);
            cls9.getMethod((String) objArr69[0], Long.TYPE, Long.TYPE).invoke(null, objArr67);
            Object[] objArr70 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i98 = ((int[]) objArr4[2])[0];
            int i99 = ((int[]) objArr4[3])[0];
            int i100 = ((int[]) objArr4[0])[0];
            String[] strArr8 = (String[]) objArr4[1];
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i101 = ~iIdentityHashCode2;
            int i102 = i98 + (-1008600299) + (((~(441192549 | i101)) | 563269250) * 168) + ((~((-563269251) | iIdentityHashCode2)) * 168) + (((~(iIdentityHashCode2 | 1004461799)) | (~(i101 | (-601542276))) | 38273025) * 168);
            int i103 = (i102 << 13) ^ i102;
            int i104 = i103 ^ (i103 >>> 17);
            ((int[]) objArr70[2])[0] = i104 ^ (i104 << 5);
        }
        Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame25 == null) {
            int maximumDrawingCacheSize = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 17;
            char minimumFlingVelocity2 = (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16);
            int doubleTapTimeout = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 747;
            byte[] bArr25 = $$a;
            byte b25 = (byte) (bArr25[21] - 1);
            byte b26 = bArr25[117];
            Object[] objArr71 = new Object[1];
            a(b25, b26, (byte) (b26 | 35), objArr71);
            objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize, minimumFlingVelocity2, doubleTapTimeout, -144068856, false, (String) objArr71[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame25).getLong(null);
        if (j5 == -1 || j5 + 4611686018427387869L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext3 = getBaseContext();
            if (baseContext3 == null) {
                Object[] objArr72 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 9, new int[]{1802067637, 221425841, -1999815928, -1714467939, -1514225663, -94003247, 501629826, -1597986539, -811983246, -806166646, -1821279575, -85405290, 632551908, 1440286877}, objArr72);
                Class<?> cls10 = Class.forName((String) objArr72[0]);
                Object[] objArr73 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 14, new int[]{392675646, 1913551018, -836993068, -1677433158, -1755266560, 535029861, 238626251, 1402487628, 73550449, -1948801812}, objArr73);
                baseContext3 = (Context) cls10.getMethod((String) objArr73[0], new Class[0]).invoke(null, null);
            }
            if (baseContext3 != null) {
                baseContext3 = ((baseContext3 instanceof ContextWrapper) && ((ContextWrapper) baseContext3).getBaseContext() == null) ? null : baseContext3.getApplicationContext();
            }
            Object[] objArr74 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -502713876};
            byte[] bArr26 = $$d;
            Object[] objArr75 = new Object[1];
            c(bArr26[10], (short) 206, bArr26[168], objArr75);
            Class<?> cls11 = Class.forName((String) objArr75[0]);
            Object[] objArr76 = new Object[1];
            c(bArr26[88], (short) JfifUtil.MARKER_SOFn, (byte) (-bArr26[20]), objArr76);
            objArr5 = (Object[]) cls11.getMethod((String) objArr76[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr74);
            Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame26 == null) {
                int i105 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 17;
                char cAlpha2 = (char) Color.alpha(0);
                int iLastIndexOf4 = TextUtils.lastIndexOf("", '0', 0) + 748;
                byte[] bArr27 = $$a;
                byte b27 = bArr27[113];
                byte b28 = bArr27[117];
                Object[] objArr77 = new Object[1];
                a(b27, b28, (byte) (b28 | 35), objArr77);
                objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(i105, cAlpha2, iLastIndexOf4, -1031537386, false, (String) objArr77[0], null);
            }
            ((Field) objAccessartificialFrame26).set(null, objArr5);
            try {
                Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame27 == null) {
                    int modifierMetaStateMask2 = ((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.DC2;
                    char mirror2 = (char) (AndroidCharacter.getMirror('0') - '0');
                    int jumpTapTimeout = 747 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                    byte[] bArr28 = $$a;
                    byte b29 = (byte) (bArr28[21] - 1);
                    byte b30 = bArr28[117];
                    Object[] objArr78 = new Object[1];
                    a(b29, b30, (byte) (b30 | 35), objArr78);
                    objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask2, mirror2, jumpTapTimeout, -144068856, false, (String) objArr78[0], null);
                }
                ((Field) objAccessartificialFrame27).set(null, lValueOf5);
            } catch (Exception unused5) {
                throw new RuntimeException();
            }
        } else {
            int i106 = getARTIFICIAL_FRAME_PACKAGE_NAME + 107;
            artificialFrame = i106 % 128;
            int i107 = i106 % 2;
            Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame28 == null) {
                int i108 = 18 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                char c9 = (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                int i109 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 747;
                byte[] bArr29 = $$a;
                byte b31 = bArr29[113];
                byte b32 = bArr29[117];
                Object[] objArr79 = new Object[1];
                a(b31, b32, (byte) (b32 | 35), objArr79);
                objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(i108, c9, i109, -1031537386, false, (String) objArr79[0], null);
            }
            Object[] objArr80 = (Object[]) ((Field) objAccessartificialFrame28).get(null);
            objArr5 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
            int i110 = ((int[]) objArr80[3])[0];
            int i111 = ((int[]) objArr80[4])[0];
            List list = (List) objArr80[0];
            List list2 = (List) objArr80[2];
            int i112 = ~((~Process.myUid()) | 263494186);
            int i113 = ((((194252832 | i112) * (-970)) + 1607497829) + ((i112 | 69241354) * 970)) - 502713876;
            int i114 = (i113 << 13) ^ i113;
            int i115 = i114 ^ (i114 >>> 17);
            ((int[]) objArr5[1])[0] = i115 ^ (i115 << 5);
        }
        int i116 = ((int[]) objArr5[4])[0];
        int i117 = ((int[]) objArr5[3])[0];
        if (i117 == i116) {
            Object[] objArr81 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i118 = ((int[]) objArr5[1])[0];
            int i119 = ((int[]) objArr5[3])[0];
            int i120 = ((int[]) objArr5[4])[0];
            List list3 = (List) objArr5[0];
            List list4 = (List) objArr5[2];
            int iNextInt = new Random().nextInt(614860746);
            int i121 = ~iNextInt;
            int i122 = i118 + 1615661230 + (((~((-165726493) | i121)) | 29376528) * 98) + (((~(i121 | (-439721966))) | (-165726493) | (~(439721965 | iNextInt))) * (-49)) + (((~(iNextInt | (-165726493))) | (-469098494)) * 49);
            int i123 = (i122 << 13) ^ i122;
            int i124 = i123 ^ (i123 >>> 17);
            ((int[]) objArr81[1])[0] = i124 ^ (i124 << 5);
            i4 = 0;
        } else {
            ArrayList arrayList3 = new ArrayList();
            Object[] objArr82 = {objArr5};
            Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(1804664566);
            if (objAccessartificialFrame29 == null) {
                objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(41 - TextUtils.getOffsetBefore("", 0), (char) ((ViewConfiguration.getLongPressTimeout() >> 16) + 12468), ExpandableListView.getPackedPositionType(0L) + 3642, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
            }
            arrayList3.add(((Method) objAccessartificialFrame29).invoke(null, objArr82));
            Object[] objArr83 = {objArr5};
            Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(-1243809191);
            if (objAccessartificialFrame30 == null) {
                objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 42, (char) (12468 - (KeyEvent.getMaxKeyCode() >> 16)), 3641 - ImageFormat.getBitsPerPixel(0), 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
            }
            arrayList3.add(((Method) objAccessartificialFrame30).invoke(null, objArr83));
            long j6 = ((long) (i116 ^ i117)) ^ (((long) 250506954) << 32);
            long j7 = 250506946;
            int i125 = getARTIFICIAL_FRAME_PACKAGE_NAME + 93;
            artificialFrame = i125 % 128;
            int i126 = i125 % 2;
            Object[] objArr84 = {Long.valueOf(j6), Long.valueOf(j7)};
            byte[] bArr30 = $$d;
            Object[] objArr85 = new Object[1];
            c(bArr30[92], (short) ($$e | SyslogConstants.LOG_LOCAL4), bArr30[566], objArr85);
            Class<?> cls12 = Class.forName((String) objArr85[0]);
            Object[] objArr86 = new Object[1];
            c((byte) (-bArr30[146]), (short) 737, (byte) 86, objArr86);
            cls12.getMethod((String) objArr86[0], Long.TYPE, Long.TYPE).invoke(null, objArr84);
            Object[] objArr87 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i127 = ((int[]) objArr5[1])[0];
            int i128 = ((int[]) objArr5[3])[0];
            int i129 = ((int[]) objArr5[4])[0];
            List list5 = (List) objArr5[0];
            List list6 = (List) objArr5[2];
            int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
            int i130 = ~startElapsedRealtime;
            int i131 = ~(26339644 | i130);
            int i132 = i127 + (-959894447) + ((570693313 | i131) * (-712)) + (((~(startElapsedRealtime | 597032957)) | (~(i130 | (-570693314)))) * (-712)) + (((-579108814) | i131) * 712);
            int i133 = (i132 << 13) ^ i132;
            int i134 = i133 ^ (i133 >>> 17);
            i4 = 0;
            ((int[]) objArr87[1])[0] = i134 ^ (i134 << 5);
        }
        Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame31 == null) {
            int tapTimeout = 30 - (ViewConfiguration.getTapTimeout() >> 16);
            char size = (char) (View.MeasureSpec.getSize(i4) + 49362);
            int touchSlop3 = (ViewConfiguration.getTouchSlop() >> 8) + 684;
            byte b33 = $$a[113];
            Object[] objArr88 = new Object[1];
            a((byte) 77, b33, (byte) (b33 | 37), objArr88);
            objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(tapTimeout, size, touchSlop3, 508509282, false, (String) objArr88[0], null);
        }
        long j8 = ((Field) objAccessartificialFrame31).getLong(null);
        if (j8 == -1 || j8 + 1970 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext4 = getBaseContext();
            if (baseContext4 == null) {
                Object[] objArr89 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 89, new int[]{1802067637, 221425841, -1999815928, -1714467939, -1514225663, -94003247, 501629826, -1597986539, -811983246, -806166646, -1821279575, -85405290, 632551908, 1440286877}, objArr89);
                Class<?> cls13 = Class.forName((String) objArr89[0]);
                Object[] objArr90 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 18, new int[]{392675646, 1913551018, -836993068, -1677433158, -1755266560, 535029861, 238626251, 1402487628, 73550449, -1948801812}, objArr90);
                baseContext4 = (Context) cls13.getMethod((String) objArr90[0], new Class[0]).invoke(null, null);
            }
            if (baseContext4 != null) {
                baseContext4 = ((baseContext4 instanceof ContextWrapper) && ((ContextWrapper) baseContext4).getBaseContext() == null) ? null : baseContext4.getApplicationContext();
            }
            Object[] objArr91 = {baseContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 1841640724};
            byte[] bArr31 = $$d;
            Object[] objArr92 = new Object[1];
            c(bArr31[92], (short) 118, bArr31[163], objArr92);
            Class<?> cls14 = Class.forName((String) objArr92[0]);
            Object[] objArr93 = new Object[1];
            c(bArr31[85], (short) 291, bArr31[305], objArr93);
            objArr6 = (Object[]) cls14.getMethod((String) objArr93[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr91);
            if (baseContext4 != null) {
                Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame32 == null) {
                    int keyRepeatDelay3 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 30;
                    char cMyTid = (char) ((Process.myTid() >> 22) + 49362);
                    int i135 = 684 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                    byte[] bArr32 = $$a;
                    Object[] objArr94 = new Object[1];
                    a((byte) 89, bArr32[30], bArr32[15], objArr94);
                    objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay3, cMyTid, i135, -1321816393, false, (String) objArr94[0], null);
                }
                ((Field) objAccessartificialFrame32).set(null, objArr6);
                try {
                    Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                    if (objAccessartificialFrame33 == null) {
                        int i136 = 30 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                        char cIndexOf2 = (char) (TextUtils.indexOf("", "", 0, 0) + 49362);
                        int mirror3 = 732 - AndroidCharacter.getMirror('0');
                        byte b34 = $$a[113];
                        Object[] objArr95 = new Object[1];
                        a((byte) 77, b34, (byte) (b34 | 37), objArr95);
                        objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(i136, cIndexOf2, mirror3, 508509282, false, (String) objArr95[0], null);
                    }
                    ((Field) objAccessartificialFrame33).set(null, lValueOf6);
                } catch (Exception unused6) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(777251007);
            if (objAccessartificialFrame34 == null) {
                int fadingEdgeLength = (ViewConfiguration.getFadingEdgeLength() >> 16) + 30;
                char c10 = (char) (49362 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                int deadChar = 684 - KeyEvent.getDeadChar(0, 0);
                byte[] bArr33 = $$a;
                Object[] objArr96 = new Object[1];
                a((byte) 89, bArr33[30], bArr33[15], objArr96);
                objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength, c10, deadChar, -1321816393, false, (String) objArr96[0], null);
            }
            Object[] objArr97 = (Object[]) ((Field) objAccessartificialFrame34).get(null);
            objArr6 = new Object[]{new int[]{((int[]) objArr97[0])[0]}, new int[]{((int[]) objArr97[1])[0]}, new int[1], (String) objArr97[3]};
            int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
            int i137 = (~((-799459734) | iMaxMemory)) | 178569601;
            int i138 = 912536318 + (i137 * 992) + ((i137 | (~((~iMaxMemory) | 800054173))) * (-496)) + ((iMaxMemory | 179164041) * 496) + 1841640724;
            int i139 = (i138 << 13) ^ i138;
            int i140 = i139 ^ (i139 >>> 17);
            ((int[]) objArr6[2])[0] = i140 ^ (i140 << 5);
        }
        int i141 = ((int[]) objArr6[1])[0];
        int i142 = ((int[]) objArr6[0])[0];
        if (i142 == i141) {
            int i143 = ((int[]) objArr6[2])[0];
            Object[] objArr98 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
            int i144 = (int) Runtime.getRuntime().totalMemory();
            int i145 = ~((-531520537) | i144);
            int i146 = ~i144;
            int i147 = i145 | (~(447103238 | i146));
            int i148 = ~(531520536 | i146);
            int i149 = i143 + 1588276582 + ((i147 | i148) * (-516)) + (((~(i144 | (-447102977))) | (~(i146 | (-263)))) * 516) + ((262 | i148) * 516);
            int i150 = (i149 << 13) ^ i149;
            int i151 = i150 ^ (i150 >>> 17);
            i5 = 0;
            ((int[]) objArr98[2])[0] = i151 ^ (i151 << 5);
        } else {
            long j9 = ((long) (i141 ^ i142)) ^ (((long) (-268156503)) << 32);
            long j10 = -268155991;
            int i152 = getARTIFICIAL_FRAME_PACKAGE_NAME + 55;
            artificialFrame = i152 % 128;
            int i153 = i152 % 2;
            Object[] objArr99 = {Long.valueOf(j9), Long.valueOf(j10)};
            byte[] bArr34 = $$d;
            Object[] objArr100 = new Object[1];
            c(bArr34[92], bArr34[19], bArr34[785], objArr100);
            Class<?> cls15 = Class.forName((String) objArr100[0]);
            Object[] objArr101 = new Object[1];
            c((byte) (-bArr34[146]), (short) 737, (byte) 86, objArr101);
            cls15.getMethod((String) objArr101[0], Long.TYPE, Long.TYPE).invoke(null, objArr99);
            int i154 = ((int[]) objArr6[2])[0];
            Object[] objArr102 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
            int iIdentityHashCode3 = System.identityHashCode(this);
            int i155 = ~iIdentityHashCode3;
            int i156 = i154 + (-1508821074) + (((~((-1037659434) | i155)) | 1012477217 | (~(59035658 | i155))) * (-1136)) + (((~((-1037659434) | iIdentityHashCode3)) | (~(59035658 | iIdentityHashCode3)) | (~((-33853443) | i155))) * (-568)) + (((~(iIdentityHashCode3 | (-1012477218))) | (~(i155 | (-59035659))) | (~(1037659433 | i155))) * 568);
            int i157 = (i156 << 13) ^ i156;
            int i158 = i157 ^ (i157 >>> 17);
            i5 = 0;
            ((int[]) objArr102[2])[0] = i158 ^ (i158 << 5);
        }
        Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame35 == null) {
            int iResolveSizeAndState = View.resolveSizeAndState(i5, i5, i5) + 36;
            char c11 = (char) ((ExpandableListView.getPackedPositionForChild(i5, i5) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(i5, i5) == 0L ? 0 : -1)) + 1);
            int deadChar2 = KeyEvent.getDeadChar(i5, i5) + 540;
            byte[] bArr35 = $$a;
            byte b35 = (byte) (bArr35[21] - 1);
            byte b36 = bArr35[117];
            Object[] objArr103 = new Object[1];
            a(b35, b36, (byte) (b36 | 35), objArr103);
            objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState, c11, deadChar2, 624296913, false, (String) objArr103[0], null);
        }
        long j11 = ((Field) objAccessartificialFrame35).getLong(null);
        if (j11 != -1) {
            int i159 = artificialFrame + 37;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i159 % 128;
            int i160 = i159 % 2;
            if (j11 + 1997 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                if (objAccessartificialFrame36 == null) {
                    int i161 = 37 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                    char cMakeMeasureSpec = (char) View.MeasureSpec.makeMeasureSpec(0, 0);
                    int i162 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 540;
                    byte[] bArr36 = $$a;
                    byte b37 = bArr36[113];
                    byte b38 = bArr36[117];
                    Object[] objArr104 = new Object[1];
                    a(b37, b38, (byte) (b38 | 35), objArr104);
                    objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(i161, cMakeMeasureSpec, i162, 793268735, false, (String) objArr104[0], null);
                }
                Object[] objArr105 = (Object[]) ((Field) objAccessartificialFrame36).get(null);
                objArr7 = new Object[]{new int[1], new int[1], new int[1]};
                int i163 = ((int[]) objArr105[2])[0];
                int i164 = ((int[]) objArr105[1])[0];
                ((int[]) objArr7[2])[0] = i163;
                ((int[]) objArr7[1])[0] = i164;
                int iMaxMemory2 = (int) Runtime.getRuntime().maxMemory();
                int i165 = ~iMaxMemory2;
                int i166 = (-1076268327) + (((~((-603031514) | i165)) | 546342040 | (~((-748590237) | i165)) | (~(805279709 | iMaxMemory2))) * (-84));
                int i167 = (~(iMaxMemory2 | (-748590237))) | 603031513;
                int i168 = ~(i165 | 748590236);
                int i169 = ((i166 + ((i167 | i168) * (-84))) + (((-805279710) | i168) * 84)) - 940958572;
                int i170 = (i169 << 13) ^ i169;
                int i171 = i170 ^ (i170 >>> 17);
                ((int[]) objArr7[0])[0] = i171 ^ (i171 << 5);
            } else {
                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1717965552);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(21 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (View.getDefaultSize(0, 0) + 39516), 982 - View.resolveSizeAndState(0, 0, 0), 117222168, false, null, new Class[0]);
                }
                Object[] objArr106 = {null, ((Constructor) objAccessartificialFrame).newInstance(null), -940958572, 0};
                objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-501205803);
                if (objAccessartificialFrame2 == null) {
                    int iNormalizeMetaState2 = KeyEvent.normalizeMetaState(0) + 36;
                    char scrollDefaultDelay = (char) (ViewConfiguration.getScrollDefaultDelay() >> 16);
                    int minimumFlingVelocity3 = 540 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                    byte b39 = (byte) ($$a[21] - 1);
                    Object[] objArr107 = new Object[1];
                    a((byte) 96, b39, b39, objArr107);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState2, scrollDefaultDelay, minimumFlingVelocity3, 2101703389, false, (String) objArr107[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(55 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 832), 576 - (Process.myTid() >> 22)), (Class) ArtificialStackFrames.coroutineCreation(54 - Color.blue(0), (char) (ViewConfiguration.getTapTimeout() >> 16), Gravity.getAbsoluteGravity(0, 0) + 630), Integer.TYPE, Integer.TYPE});
                }
                objArr7 = (Object[]) ((Method) objAccessartificialFrame2).invoke(null, objArr106);
                objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                if (objAccessartificialFrame3 == null) {
                    int maximumDrawingCacheSize2 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 36;
                    char cKeyCodeFromString = (char) KeyEvent.keyCodeFromString("");
                    int bitsPerPixel2 = 539 - ImageFormat.getBitsPerPixel(0);
                    byte[] bArr37 = $$a;
                    byte b40 = bArr37[113];
                    byte b41 = bArr37[117];
                    Object[] objArr108 = new Object[1];
                    a(b40, b41, (byte) (b41 | 35), objArr108);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize2, cKeyCodeFromString, bitsPerPixel2, 793268735, false, (String) objArr108[0], null);
                }
                ((Field) objAccessartificialFrame3).set(null, objArr7);
                try {
                    Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                    if (objAccessartificialFrame4 == null) {
                        int maximumFlingVelocity = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 36;
                        char maximumDrawingCacheSize3 = (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                        int maxKeyCode = 540 - (KeyEvent.getMaxKeyCode() >> 16);
                        byte[] bArr38 = $$a;
                        byte b42 = (byte) (bArr38[21] - 1);
                        byte b43 = bArr38[117];
                        Object[] objArr109 = new Object[1];
                        a(b42, b43, (byte) (b43 | 35), objArr109);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity, maximumDrawingCacheSize3, maxKeyCode, 624296913, false, (String) objArr109[0], null);
                    }
                    ((Field) objAccessartificialFrame4).set(null, lValueOf7);
                } catch (Exception unused7) {
                    throw new RuntimeException();
                }
            }
        } else {
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1717965552);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(21 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (View.getDefaultSize(0, 0) + 39516), 982 - View.resolveSizeAndState(0, 0, 0), 117222168, false, null, new Class[0]);
            }
            Object[] objArr1010 = {null, ((Constructor) objAccessartificialFrame).newInstance(null), -940958572, 0};
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-501205803);
            if (objAccessartificialFrame2 == null) {
                int iNormalizeMetaState3 = KeyEvent.normalizeMetaState(0) + 36;
                char scrollDefaultDelay2 = (char) (ViewConfiguration.getScrollDefaultDelay() >> 16);
                int minimumFlingVelocity4 = 540 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                byte b310 = (byte) ($$a[21] - 1);
                Object[] objArr1011 = new Object[1];
                a((byte) 96, b310, b310, objArr1011);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState3, scrollDefaultDelay2, minimumFlingVelocity4, 2101703389, false, (String) objArr1011[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(55 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 832), 576 - (Process.myTid() >> 22)), (Class) ArtificialStackFrames.coroutineCreation(54 - Color.blue(0), (char) (ViewConfiguration.getTapTimeout() >> 16), Gravity.getAbsoluteGravity(0, 0) + 630), Integer.TYPE, Integer.TYPE});
            }
            objArr7 = (Object[]) ((Method) objAccessartificialFrame2).invoke(null, objArr1010);
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame3 == null) {
                int maximumDrawingCacheSize4 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 36;
                char cKeyCodeFromString2 = (char) KeyEvent.keyCodeFromString("");
                int bitsPerPixel3 = 539 - ImageFormat.getBitsPerPixel(0);
                byte[] bArr39 = $$a;
                byte b44 = bArr39[113];
                byte b45 = bArr39[117];
                Object[] objArr1012 = new Object[1];
                a(b44, b45, (byte) (b45 | 35), objArr1012);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize4, cKeyCodeFromString2, bitsPerPixel3, 793268735, false, (String) objArr1012[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, objArr7);
            Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1168947751);
            if (objAccessartificialFrame4 == null) {
                int maximumFlingVelocity2 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 36;
                char maximumDrawingCacheSize5 = (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                int maxKeyCode2 = 540 - (KeyEvent.getMaxKeyCode() >> 16);
                byte[] bArr310 = $$a;
                byte b46 = (byte) (bArr310[21] - 1);
                byte b47 = bArr310[117];
                Object[] objArr1013 = new Object[1];
                a(b46, b47, (byte) (b47 | 35), objArr1013);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity2, maximumDrawingCacheSize5, maxKeyCode2, 624296913, false, (String) objArr1013[0], null);
            }
            ((Field) objAccessartificialFrame4).set(null, lValueOf8);
        }
        Object obj = objArr7[1];
        int i172 = ((int[]) obj)[0];
        Object obj2 = objArr7[2];
        int i173 = ((int[]) obj2)[0];
        if (i173 == i172) {
            Object[] objArr110 = {new int[1], new int[1], new int[1]};
            int i174 = ((int[]) objArr7[0])[0];
            int i175 = ((int[]) obj2)[0];
            int i176 = ((int[]) obj)[0];
            ((int[]) objArr110[2])[0] = i175;
            ((int[]) objArr110[1])[0] = i176;
            int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 1445509130;
            int i177 = i174 + (-1785142263) + (((~((-556866799) | length)) | 794754951) * (-366)) + (((~(length | (-2162793))) | 240050945) * 366);
            int i178 = (i177 << 13) ^ i177;
            int i179 = i178 ^ (i178 >>> 17);
            ((int[]) objArr110[0])[0] = i179 ^ (i179 << 5);
            i6 = 0;
        } else {
            Object[] objArr111 = {Long.valueOf(((long) (i172 ^ i173)) ^ (((long) (-1479301435)) << 32)), Long.valueOf(-1479297339)};
            byte[] bArr40 = $$d;
            Object[] objArr112 = new Object[1];
            c(bArr40[92], bArr40[263], bArr40[145], objArr112);
            Class<?> cls16 = Class.forName((String) objArr112[0]);
            Object[] objArr113 = new Object[1];
            c((byte) (-bArr40[146]), (short) 737, (byte) 86, objArr113);
            cls16.getMethod((String) objArr113[0], Long.TYPE, Long.TYPE).invoke(null, objArr111);
            Object[] objArr114 = {new int[1], new int[1], new int[1]};
            int i180 = ((int[]) objArr7[0])[0];
            int i181 = ((int[]) objArr7[2])[0];
            int i182 = ((int[]) objArr7[1])[0];
            ((int[]) objArr114[2])[0] = i181;
            ((int[]) objArr114[1])[0] = i182;
            int i183 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenHeightDp;
            int i184 = ~((-806348099) | i183);
            int i185 = ~i183;
            int i186 = i180 + (-26335169) + ((i184 | (~(814741363 | i185))) * (-406)) + ((~((-269467713) | i185)) * (-406)) + (((~(i183 | (-545273652))) | (~(806348098 | i185))) * 406);
            int i187 = (i186 << 13) ^ i186;
            int i188 = i187 ^ (i187 >>> 17);
            i6 = 0;
            ((int[]) objArr114[0])[0] = i188 ^ (i188 << 5);
        }
        super.onCreate();
        Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame37 == null) {
            int i189 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 26;
            char cAlpha3 = (char) Color.alpha(i6);
            int i190 = 1042 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
            byte[] bArr41 = $$a;
            byte b48 = (byte) (bArr41[21] - 1);
            byte b49 = bArr41[117];
            Object[] objArr115 = new Object[1];
            a(b48, b49, (byte) (b49 | 35), objArr115);
            objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(i189, cAlpha3, i190, 2061780482, false, (String) objArr115[0], null);
        }
        long j12 = ((Field) objAccessartificialFrame37).getLong(null);
        if (j12 != -1) {
            int i191 = artificialFrame + 23;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i191 % 128;
            int i192 = i191 % 2;
            if (j12 + 4611686018427387762L >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i193 = getARTIFICIAL_FRAME_PACKAGE_NAME + 73;
                artificialFrame = i193 % 128;
                int i194 = i193 % 2;
                Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame38 == null) {
                    int scrollBarSize = 26 - (ViewConfiguration.getScrollBarSize() >> 8);
                    char c12 = (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                    int i195 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 1040;
                    byte[] bArr42 = $$a;
                    byte b50 = bArr42[113];
                    byte b51 = bArr42[117];
                    Object[] objArr116 = new Object[1];
                    a(b50, b51, (byte) (b51 | 35), objArr116);
                    objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(scrollBarSize, c12, i195, 1145017376, false, (String) objArr116[0], null);
                }
                Object[] objArr117 = (Object[]) ((Field) objAccessartificialFrame38).get(null);
                objArr8 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i196 = ((int[]) objArr117[3])[0];
                int i197 = ((int[]) objArr117[2])[0];
                String[] strArr9 = (String[]) objArr117[0];
                int iIdentityHashCode4 = System.identityHashCode(this);
                int i198 = (-1510926618) + (((~((-11027714) | iIdentityHashCode4)) | 89131520) * (-756)) + (((~iIdentityHashCode4) | (-11027714)) * 756) + 406101178;
                int i199 = (i198 << 13) ^ i198;
                int i200 = i199 ^ (i199 >>> 17);
                ((int[]) objArr8[1])[0] = i200 ^ (i200 << 5);
            } else {
                int iIntValue3 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                Object[] objArr118 = {-118350338};
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame5 == null) {
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation((Process.myTid() >> 22) + 8, (char) (22299 - AndroidCharacter.getMirror('0')), 1032 - TextUtils.indexOf((CharSequence) "", '0', 0), 47343338, false, null, new Class[]{Integer.TYPE});
                }
                Object[] objArrAccessartificialFrame$78cbbd35 = NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.accessartificialFrame$78cbbd35(iIntValue3, 0, ((Constructor) objAccessartificialFrame5).newInstance(objArr118), 406101178, false);
                objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame6 == null) {
                    int offsetAfter2 = TextUtils.getOffsetAfter("", 0) + 26;
                    char size2 = (char) View.MeasureSpec.getSize(0);
                    int iMyTid3 = (Process.myTid() >> 22) + 1041;
                    byte[] bArr43 = $$a;
                    byte b52 = bArr43[113];
                    byte b53 = bArr43[117];
                    Object[] objArr119 = new Object[1];
                    a(b52, b53, (byte) (b53 | 35), objArr119);
                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(offsetAfter2, size2, iMyTid3, 1145017376, false, (String) objArr119[0], null);
                }
                ((Field) objAccessartificialFrame6).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Long lValueOf9 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame7 == null) {
                        int i201 = 26 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                        char windowTouchSlop3 = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                        int bitsPerPixel4 = ImageFormat.getBitsPerPixel(0) + 1042;
                        byte[] bArr44 = $$a;
                        byte b54 = (byte) (bArr44[21] - 1);
                        byte b55 = bArr44[117];
                        Object[] objArr120 = new Object[1];
                        a(b54, b55, (byte) (b55 | 35), objArr120);
                        objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(i201, windowTouchSlop3, bitsPerPixel4, 2061780482, false, (String) objArr120[0], null);
                    }
                    ((Field) objAccessartificialFrame7).set(null, lValueOf9);
                    objArr8 = objArrAccessartificialFrame$78cbbd35;
                } catch (Exception unused8) {
                    throw new RuntimeException();
                }
            }
        } else {
            int iIntValue4 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr1110 = {-118350338};
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame5 == null) {
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation((Process.myTid() >> 22) + 8, (char) (22299 - AndroidCharacter.getMirror('0')), 1032 - TextUtils.indexOf((CharSequence) "", '0', 0), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            Object[] objArrAccessartificialFrame$78cbbd36 = NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.accessartificialFrame$78cbbd35(iIntValue4, 0, ((Constructor) objAccessartificialFrame5).newInstance(objArr1110), 406101178, false);
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame6 == null) {
                int offsetAfter3 = TextUtils.getOffsetAfter("", 0) + 26;
                char size3 = (char) View.MeasureSpec.getSize(0);
                int iMyTid4 = (Process.myTid() >> 22) + 1041;
                byte[] bArr45 = $$a;
                byte b56 = bArr45[113];
                byte b57 = bArr45[117];
                Object[] objArr1111 = new Object[1];
                a(b56, b57, (byte) (b57 | 35), objArr1111);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(offsetAfter3, size3, iMyTid4, 1145017376, false, (String) objArr1111[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, objArrAccessartificialFrame$78cbbd36);
            Long lValueOf10 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame7 == null) {
                int i202 = 26 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                char windowTouchSlop4 = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                int bitsPerPixel5 = ImageFormat.getBitsPerPixel(0) + 1042;
                byte[] bArr46 = $$a;
                byte b58 = (byte) (bArr46[21] - 1);
                byte b59 = bArr46[117];
                Object[] objArr121 = new Object[1];
                a(b58, b59, (byte) (b59 | 35), objArr121);
                objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(i202, windowTouchSlop4, bitsPerPixel5, 2061780482, false, (String) objArr121[0], null);
            }
            ((Field) objAccessartificialFrame7).set(null, lValueOf10);
            objArr8 = objArrAccessartificialFrame$78cbbd36;
        }
        int i203 = ((int[]) objArr8[2])[0];
        int i204 = ((int[]) objArr8[3])[0];
        if (i204 == i203) {
            Object[] objArr122 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i205 = ((int[]) objArr8[1])[0];
            int i206 = ((int[]) objArr8[3])[0];
            int i207 = ((int[]) objArr8[2])[0];
            String[] strArr10 = (String[]) objArr8[0];
            int iNextInt2 = new Random().nextInt(1622478087);
            int i208 = i205 + (((~((-421902545) | iNextInt2)) * 521) - 523213682) + (((~((~iNextInt2) | (-421902545))) | (-503185376)) * 521);
            int i209 = (i208 << 13) ^ i208;
            int i210 = i209 ^ (i209 >>> 17);
            ((int[]) objArr122[1])[0] = i210 ^ (i210 << 5);
            return;
        }
        ArrayList arrayList4 = new ArrayList();
        String[] strArr11 = (String[]) objArr8[0];
        if (strArr11 != null) {
            for (String str8 : strArr11) {
                arrayList4.add(str8);
            }
        }
        Object[] objArr123 = {Long.valueOf(((long) (i203 ^ i204)) ^ (((long) 175695329) << 32)), Long.valueOf(175695331)};
        byte[] bArr47 = $$d;
        byte b60 = bArr47[92];
        short s = bArr47[4];
        Object[] objArr124 = new Object[1];
        c(b60, s, (byte) (s | 46), objArr124);
        Class<?> cls17 = Class.forName((String) objArr124[0]);
        Object[] objArr125 = new Object[1];
        c((byte) (-bArr47[146]), (short) 737, (byte) 86, objArr125);
        cls17.getMethod((String) objArr125[0], Long.TYPE, Long.TYPE).invoke(null, objArr123);
        Object[] objArr126 = {strArr, new int[1], new int[]{i}, new int[]{i}};
        int i211 = ((int[]) objArr8[1])[0];
        int i212 = ((int[]) objArr8[3])[0];
        int i213 = ((int[]) objArr8[2])[0];
        String[] strArr12 = (String[]) objArr8[0];
        int i214 = ~(System.identityHashCode(this) | (-635635309));
        int i215 = i211 + 1970772526 + (((-713739116) | i214) * (-220)) + ((i214 | 90244100) * 220) + 1619650192;
        int i216 = (i215 << 13) ^ i215;
        int i217 = i216 ^ (i216 >>> 17);
        ((int[]) objArr126[1])[0] = i217 ^ (i217 << 5);
    }

    static {
        byte[] bArr = new byte[826];
        System.arraycopy("\u0005Û0T\u0000ÿðü\u00009\u0001Á÷ö\u000bï\u0000\tñ:³\u0000AØé\u0000ñ\u0011îÿ\u000bà\bô\u0002íLÉá\u0005ñ\u000bï\u001aïê\u0004ü¿ðþ;Ä\u0001úúÿïü\u00009Áø\böþñ\u0003õ\u0007õÿ÷\u00053Çðù\t3ÚÚÿ\u0007ë\u000eúï\u001bêðø\fó\u0007ú\u001báúë\u0001ùõQÝÐþù\u000bï\u0001öýðþ;Ãôü\u0004÷\u00033Éï\u0006îÿ\u0002\u00012½\bé\u000bï\u0005\u0004ñ:Çðÿùù@µý\u0007ùÿñ\u0007\u0000îAæÇ\u0007\tð\u0000\u0002\u001cÐÿùùJüÛÉ\u0000\u000bï\u0000\tñ\u0015Ö\u0007ö\bÿí\u0007\u0002\u0013çð\u0007úÿ-ðþ;Ãôü\u0004÷\u00033½ýýþñB´\tò\u0006öý<Èýë\u000bð\u0007û3Ðçüþ\u0016Ú\nüþîû\u0007öý\u001bÛø\u0007öý÷Ðùÿöý\u0007÷\u0005\u001dÛÿé\nüú÷\u0003\u0018Óðþ;Ä\u0001úúÿïü\u00009¸\t\u0000úëBµ\bø\bï\töþï@Ñæ\u0004\u0002\u000fÛ\u0007û\u0011ÝüÿDüÛÉ\u0000\u000bï\u0000\tñ\u0015Ö\u0007ö\bÿí\u0007\u0002\u0013çð\u0007úÿ-ñBÉøñ\ròñ\u000fñÿ\u0004/´þýA·\u000bõ9Æì\u0001=·\u0000\ní>¸\tîÿýý÷\nîAÔÞý\u001cà\ní#×\u0001ñ\u001dêîü\u0006öý\u0018éîÿýý÷\n\u0018í\t\u0000é\u0007öýðþ;Ãôü\u0004÷\u00033Éï\u0006îÿ\u0002\u00012Æÿé\u000féþ\rï÷ÿýùúB¸ù\u0003ö\u0007ø\u00043·\f÷ÿýë\u0005ÿ÷\u00035À÷\të\f÷ÿýë\u0005ÿ÷\u00035Óäù\u0003\u001e×\u0001ñ\u0007\u0004ñÿë\u0011ï\u000f\u0015áúë\u0001ùõúüúîü\u000eëú\u0007ÿù\u0002ö\u0004ñ\"Ð\rð\u0004ðþ;Ãôü\u0004÷\u00033Çðþüúý<Çðÿü\u0003þëBÝèí\u001fèò\u0002ï%×ö\u000bï\u0000\tñ\u001bèíHßÛëûþ\rúë\u0019î\u0000ò\u001câè0Óöþõ<»=¶BÁ7Ä4Å3Å3¹áû\u0003\u0002\u001dÉ\bù\u0004ûïðþ;Ãôü\u0004÷\u00033Éï\u0006îÿ\u0002\u00012ÃööAÁ÷ö\u000bï\u0000\tñ:½ýýþñ\u0011å\tò\u0006öý\u000bùýë\u000bð\u0007û\u0002ùé\u0003\u0006ô\u0003ý2°ü\u0011ðþ;Ä\u0001úúÿïü\u00009Ã\u0002ð\u0000÷\u0003ð\nïø\t\u0002úîAÇóùö\rù\u0002ð\u0000÷\u00035ãâð\u0004\u001bÝ\u0000éûÿ\tî#ß\u0003ì\rëõQïðþ;Ä\u0001úúÿïü\u00009Éíü\u0000ÿ÷ÿôAéÍü ß÷ÿ#ßé\u000f9ïðþ;Ãôü\u0004÷\u00033Éí\u00037ÙØ\u0002÷\u000f\rÚÿ÷\u0001÷6¹þøA¾ù\u0004\u0001ýúô9Çðù\t3·ÿ\u00037çÆ\u0012óÿ\u0002\u001dÉ\u000büýï\u001aÞ\rúô\u0002ï".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 826);
        $$d = bArr;
        $$e = 21;
        $$a = new byte[]{106, -29, -101, -119, 5, -1, -33, 33, -2, -9, 5, -7, 5, -1, -50, 39, Ascii.VT, -7, -12, Ascii.SI, Ascii.ESC, 1, -7, -6, -33, 51, -12, 3, -8, 1, Ascii.CR, -9, Ascii.DC2, -34, Ascii.EM, 4, -17, 19, -15, -1, -18, Ascii.SI, 19, -11, 5, -7, -2, Ascii.SI, -36, Ascii.NAK, Ascii.CR, -15, 2, 9, 6, -34, Ascii.SI, 19, -11, 5, -7, -2, Ascii.SI, -33, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, 10, -31, Ascii.DC4, Ascii.CR, -8, -11, -13, Ascii.ESC, -9, Ascii.DC2, -36, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, -7, Ascii.DC2, -43, Ascii.GS, -4, 17, 2, 49, 2, -11, -3, 3, -6, 6, -8, Ascii.VT, -25, 33, -19, 2, 8, -37, 44, -17, Ascii.FF, -8, Ascii.SO};
        $$b = SyslogConstants.LOG_LOCAL2;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        ICustomTabsCallbackStub = new int[]{1691942635, 1102066282, 890389037, -1714398265, -1475422032, 694474357, 682618673, -1978907050, 1162875163, -1167830456, -774262958, 833018030, 230191476, 196362059, 1038535689, 909503649, 138762734, -1090009296};
    }
}
