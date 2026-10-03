package com.facebook.react.bridge;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.crypto.tink.prf.HmacPrfKey;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;
import net.pluservice.unicoc.R;
import o.ArtificialStackFrames;
import o.onMessageChannelReady;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes.dex */
public abstract class ReactApplicationContext extends ReactContext {
    private static final byte[] $$l = {Ascii.GS, -31, -116, 88};
    private static final int $$o = 85;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$m = {10, -69, -10, 57, Ascii.SI, 1, -60, 60, Ascii.VT, 3, -5, 8, -4, -52, 54, Ascii.DLE, -7, 17, 0, -3, -2, -51, 66, -9, Ascii.SYN, -12, Ascii.DLE, -6, -5, Ascii.SO, -59, 56, Ascii.SI, 0, 6, 6, -65, 74, 2, -8, 6, 0, Ascii.SO, -8, -1, 17, -66, Ascii.EM, 56, -8, -10, Ascii.SI, -1, -3, -29, 47, 0, 6, 6, -75, 3, 36, 54, -1, -12, Ascii.DLE, -1, -10, Ascii.SO, -22, 41, -8, 9, -9, 0, Ascii.DC2, -8, -3, -20, Ascii.CAN, Ascii.SI, -8, 5, 0, -46, 3, SignedBytes.MAX_POWER_OF_TWO, 8, -55, 70, 1, 7, -66, 65, 6, -5, -2, 2, 5, Ascii.VT, -58, 56, Ascii.SI, 6, -10, -52, 72, 0, -4, -56, Ascii.CAN, 57, -19, Ascii.FF, 0, -3, -30, 54, -12, 3, 2, Ascii.DLE, -27, 33, -14, 5, Ascii.VT, -3, Ascii.DLE};
    private static final int $$n = 162;
    private static final byte[] $$d = {67, 111, Ascii.EM, 19, 5, -1, -33, 33, -2, -9, 5, -7, 5, -1, -50, 39, Ascii.VT, -7, -12, Ascii.SI, Ascii.ESC, 1, -7, -6, -33, 51, -12, 3, -8, 1, Ascii.CR};
    private static final int $$e = 226;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] validateRelationship = {56141, 55992, 56130, 55996, 55999, 56133, 56184, 55987, 56147, 55989, 55986, 56129, 55993, 56163, 55994, 56131, 55995, 55998, 56156, 56132, 55984, 56135, 56166, 56134};
    private static int warmup = -1044260050;
    private static boolean requestPostMessageChannelWithExtras = true;
    private static boolean ICustomTabsServiceDefault = true;

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$r(short r6, byte r7, short r8) {
        /*
            int r8 = r8 + 66
            int r6 = r6 * 4
            int r6 = 1 - r6
            byte[] r0 = com.facebook.react.bridge.ReactApplicationContext.$$l
            int r7 = r7 * 2
            int r7 = 3 - r7
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L15
            r4 = r8
            r3 = r2
            r8 = r7
            goto L2a
        L15:
            r3 = r2
        L16:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r7 = r7 + 1
            int r3 = r3 + 1
            if (r3 != r6) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L25:
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r5
        L2a:
            int r4 = -r4
            int r7 = r7 + r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.bridge.ReactApplicationContext.$$r(short, byte, short):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void d(short r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 8
            int r8 = 20 - r8
            byte[] r0 = com.facebook.react.bridge.ReactApplicationContext.$$d
            int r7 = r7 * 3
            int r1 = 12 - r7
            int r6 = r6 * 28
            int r6 = r6 + 84
            byte[] r1 = new byte[r1]
            int r7 = 11 - r7
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r8
            r4 = r2
            goto L2e
        L18:
            r3 = r2
        L19:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r7) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            r4 = r0[r8]
            int r3 = r3 + 1
            r5 = r3
            r3 = r8
            r8 = r4
            r4 = r5
        L2e:
            int r6 = r6 + r8
            int r8 = r3 + 1
            r3 = r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.bridge.ReactApplicationContext.d(short, byte, short, java.lang.Object[]):void");
    }

    private static void f(int i, int i2, byte b, Object[] objArr) {
        int i3 = 99 - (i2 * 63);
        byte[] bArr = $$m;
        int i4 = b + 4;
        byte[] bArr2 = new byte[82 - i];
        int i5 = 81 - i;
        int i6 = -1;
        if (bArr == null) {
            i3 = (i3 + i4) - 3;
            i4 = i4;
            i6 = -1;
        }
        while (true) {
            int i7 = i6 + 1;
            bArr2[i7] = (byte) i3;
            int i8 = i4 + 1;
            if (i7 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            } else {
                i3 = (i3 + bArr[i8]) - 3;
                i4 = i8;
                i6 = i7;
            }
        }
    }

    public ReactApplicationContext(Context context) {
        super(context.getApplicationContext());
    }

    private static void e(char[] cArr, byte[] bArr, int i, int[] iArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        onMessageChannelReady onmessagechannelready = new onMessageChannelReady();
        char[] cArr2 = validateRelationship;
        int i3 = 1;
        int i4 = 0;
        if (cArr2 != null) {
            int i5 = $11 + 35;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i7 = 0;
            while (i7 < length) {
                try {
                    Object[] objArr2 = new Object[i3];
                    objArr2[i4] = Integer.valueOf(cArr2[i7]);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(115862995);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) i4;
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(26 - (ViewConfiguration.getTapTimeout() >> 16), (char) (MotionEvent.axisFromString("") + i3), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 1041, -1719489573, false, $$r(b, b2, (byte) (b2 | 55)), new Class[]{Integer.TYPE});
                    }
                    cArr3[i7] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i7++;
                    int i8 = $11 + 77;
                    $10 = i8 % 128;
                    int i9 = i8 % 2;
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
            byte b4 = b3;
            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0', 0, 0) + 16, (char) (TextUtils.indexOf("", "") + 20488), 2148 - Color.green(0), 216472770, false, $$r(b3, b4, (byte) (b4 + 1)), new Class[]{Integer.TYPE});
        }
        int iIntValue = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
        int i10 = -2083387879;
        if (ICustomTabsServiceDefault) {
            onmessagechannelready.c = bArr.length;
            char[] cArr4 = new char[onmessagechannelready.c];
            onmessagechannelready.a = 0;
            while (onmessagechannelready.a < onmessagechannelready.c) {
                cArr4[onmessagechannelready.a] = (char) (cArr2[bArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] + i] - iIntValue);
                Object[] objArr4 = {onmessagechannelready, onmessagechannelready};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(i10);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) 0;
                    byte b6 = b5;
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(21 - TextUtils.getOffsetAfter("", 0), (char) (59174 - (ViewConfiguration.getScrollBarSize() >> 8)), 1943 - KeyEvent.keyCodeFromString(""), 481771537, false, $$r(b5, b6, b6), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                i10 = -2083387879;
            }
            objArr[0] = new String(cArr4);
            return;
        }
        if (requestPostMessageChannelWithExtras) {
            int i11 = $11 + 5;
            $10 = i11 % 128;
            int i12 = i11 % 2;
            onmessagechannelready.c = cArr.length;
            char[] cArr5 = new char[onmessagechannelready.c];
            onmessagechannelready.a = 0;
            int i13 = $10 + 33;
            $11 = i13 % 128;
            int i14 = i13 % 2;
            while (onmessagechannelready.a < onmessagechannelready.c) {
                cArr5[onmessagechannelready.a] = (char) (cArr2[cArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                Object[] objArr5 = {onmessagechannelready, onmessagechannelready};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                if (objAccessartificialFrame4 == null) {
                    byte b7 = (byte) 0;
                    byte b8 = b7;
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 20, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 59175), 1943 - (ViewConfiguration.getFadingEdgeLength() >> 16), 481771537, false, $$r(b7, b8, b8), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
            }
            objArr[0] = new String(cArr5);
            return;
        }
        int i15 = 0;
        onmessagechannelready.c = iArr.length;
        char[] cArr6 = new char[onmessagechannelready.c];
        while (true) {
            onmessagechannelready.a = i15;
            if (onmessagechannelready.a >= onmessagechannelready.c) {
                objArr[0] = new String(cArr6);
                return;
            }
            int i16 = $10 + 67;
            $11 = i16 % 128;
            if (i16 % 2 == 0) {
                cArr6[onmessagechannelready.a] = (char) (cArr2[iArr[onmessagechannelready.c + onmessagechannelready.a] >> i] % iIntValue);
                i15 = onmessagechannelready.a << 1;
            } else {
                cArr6[onmessagechannelready.a] = (char) (cArr2[iArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                i15 = onmessagechannelready.a + 1;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x014d  */
    /* JADX WARN: Code duplicated, block: B:16:0x01dc A[Catch: all -> 0x09da, TryCatch #0 {all -> 0x09da, blocks: (B:56:0x06f9, B:58:0x070d, B:59:0x0741, B:14:0x01bb, B:16:0x01dc, B:17:0x0226), top: B:96:0x01bb }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0238  */
    /* JADX WARN: Code duplicated, block: B:25:0x030d  */
    /* JADX WARN: Code duplicated, block: B:55:0x0692  */
    /* JADX WARN: Code duplicated, block: B:58:0x070d A[Catch: all -> 0x09da, TryCatch #0 {all -> 0x09da, blocks: (B:56:0x06f9, B:58:0x070d, B:59:0x0741, B:14:0x01bb, B:16:0x01dc, B:17:0x0226), top: B:96:0x01bb }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0757  */
    /* JADX WARN: Code duplicated, block: B:67:0x0816  */
    @Override // com.facebook.react.bridge.ReactContext, android.content.ContextWrapper
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
            int iRed = Color.red(0) + 25;
            char modifierMetaStateMask = (char) (30067 - ((byte) KeyEvent.getModifierMetaStateMask()));
            int i2 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 815;
            byte[] bArr = $$d;
            byte b = bArr[21];
            Object[] objArr2 = new Object[1];
            d(b, b, (byte) (-bArr[8]), objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iRed, modifierMetaStateMask, i2, 721586079, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 2003;
            Object[] objArr3 = new Object[1];
            e(null, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, KeyEvent.getDeadChar(0, 0) + 127, null, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            e(null, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, 127 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), null, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame8 == null) {
                    int i3 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 25;
                    char tapTimeout = (char) (30068 - (ViewConfiguration.getTapTimeout() >> 16));
                    int i4 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 815;
                    byte b2 = $$d[21];
                    byte b3 = b2;
                    Object[] objArr5 = new Object[1];
                    d(b2, b3, b3, objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i3, tapTimeout, i4, 891606461, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i5 = ((int[]) objArr6[0])[0];
                int i6 = ((int[]) objArr6[1])[0];
                String[] strArr = (String[]) objArr6[2];
                int i7 = ~(Process.myTid() | (-559959250));
                int i8 = (((((-762343392) | i7) * (-196)) + 90136725) + ((i7 | 202384142) * 196)) - 451214504;
                int i9 = (i8 << 13) ^ i8;
                int i10 = i9 ^ (i9 >>> 17);
                ((int[]) objArr[3])[0] = i10 ^ (i10 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                e(null, new byte[]{-115, -116, -117, -120, -118, -119, -121, -106, -126, -127, -113, -121, -127, -107, -127, -108}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(0) + 90, null, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                e(null, new byte[]{-116, -125, -123, -114, -104, -120, -127, -105, -118, -117, -122, -117, -126, -116, -125, -122}, 127 - TextUtils.getCapsMode("", 0, 0), null, objArr8);
                try {
                    Object[] objArr9 = {Integer.valueOf(((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue()), 0, -451214504};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame == null) {
                        int i11 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 24;
                        char c = (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 30067);
                        int longPressTimeout = 816 - (ViewConfiguration.getLongPressTimeout() >> 16);
                        byte b4 = (byte) ($$d[21] - 1);
                        byte b5 = b4;
                        Object[] objArr10 = new Object[1];
                        d(b4, b5, b5, objArr10);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i11, c, longPressTimeout, -797394565, false, (String) objArr10[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr9);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame2 == null) {
                        int iIndexOf = 25 - TextUtils.indexOf("", "", 0);
                        char c2 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 30067);
                        int offsetAfter = TextUtils.getOffsetAfter("", 0) + 816;
                        byte b6 = $$d[21];
                        byte b7 = b6;
                        Object[] objArr11 = new Object[1];
                        d(b6, b7, b7, objArr11);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iIndexOf, c2, offsetAfter, 891606461, false, (String) objArr11[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArr);
                    try {
                        Object[] objArr12 = new Object[1];
                        e(null, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) + 78, null, objArr12);
                        Class<?> cls3 = Class.forName((String) objArr12[0]);
                        Object[] objArr13 = new Object[1];
                        e(null, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + b.l, null, objArr13);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr13[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame3 == null) {
                            int absoluteGravity = 25 - Gravity.getAbsoluteGravity(0, 0);
                            char cRgb = (char) (Color.rgb(0, 0, 0) + 16807284);
                            int packedPositionGroup = 816 - ExpandableListView.getPackedPositionGroup(0L);
                            byte[] bArr2 = $$d;
                            byte b8 = bArr2[21];
                            Object[] objArr14 = new Object[1];
                            d(b8, b8, (byte) (-bArr2[8]), objArr14);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(absoluteGravity, cRgb, packedPositionGroup, 721586079, false, (String) objArr14[0], null);
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
            e(null, new byte[]{-115, -116, -117, -120, -118, -119, -121, -106, -126, -127, -113, -121, -127, -107, -127, -108}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(0) + 90, null, objArr15);
            Class<?> cls4 = Class.forName((String) objArr15[0]);
            Object[] objArr16 = new Object[1];
            e(null, new byte[]{-116, -125, -123, -114, -104, -120, -127, -105, -118, -117, -122, -117, -126, -116, -125, -122}, 127 - TextUtils.getCapsMode("", 0, 0), null, objArr16);
            Object[] objArr17 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue()), 0, -451214504};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame == null) {
                int i12 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 24;
                char c3 = (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 30067);
                int longPressTimeout2 = 816 - (ViewConfiguration.getLongPressTimeout() >> 16);
                byte b9 = (byte) ($$d[21] - 1);
                byte b10 = b9;
                Object[] objArr18 = new Object[1];
                d(b9, b10, b10, objArr18);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i12, c3, longPressTimeout2, -797394565, false, (String) objArr18[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr17);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame2 == null) {
                int iIndexOf2 = 25 - TextUtils.indexOf("", "", 0);
                char c4 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 30067);
                int offsetAfter2 = TextUtils.getOffsetAfter("", 0) + 816;
                byte b11 = $$d[21];
                byte b12 = b11;
                Object[] objArr19 = new Object[1];
                d(b11, b12, b12, objArr19);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iIndexOf2, c4, offsetAfter2, 891606461, false, (String) objArr19[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArr);
            Object[] objArr110 = new Object[1];
            e(null, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) + 78, null, objArr110);
            Class<?> cls5 = Class.forName((String) objArr110[0]);
            Object[] objArr111 = new Object[1];
            e(null, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + b.l, null, objArr111);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr111[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame3 == null) {
                int absoluteGravity2 = 25 - Gravity.getAbsoluteGravity(0, 0);
                char cRgb2 = (char) (Color.rgb(0, 0, 0) + 16807284);
                int packedPositionGroup2 = 816 - ExpandableListView.getPackedPositionGroup(0L);
                byte[] bArr3 = $$d;
                byte b13 = bArr3[21];
                Object[] objArr112 = new Object[1];
                d(b13, b13, (byte) (-bArr3[8]), objArr112);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(absoluteGravity2, cRgb2, packedPositionGroup2, 721586079, false, (String) objArr112[0], null);
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
            int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 1411646617;
            int i18 = ~length;
            int i19 = i15 + (-575018877) + (((~((-577297294) | i18)) | (~(379124927 | length))) * JfifUtil.MARKER_EOI) + (((~(length | (-577297294))) | 543163136) * JfifUtil.MARKER_EOI) + (((~(379124927 | i18)) | 577297293) * JfifUtil.MARKER_EOI);
            int i20 = (i19 << 13) ^ i19;
            int i21 = i20 ^ (i20 >>> 17);
            ((int[]) objArr20[3])[0] = i21 ^ (i21 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            int i22 = 2;
            String[] strArr3 = (String[]) objArr[2];
            if (strArr3 != null) {
                int i23 = getARTIFICIAL_FRAME_PACKAGE_NAME + 1;
                artificialFrame = i23 % 128;
                int i24 = i23 % 2;
                int i25 = 0;
                while (i25 < strArr3.length) {
                    int i26 = getARTIFICIAL_FRAME_PACKAGE_NAME + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                    artificialFrame = i26 % 128;
                    if (i26 % i22 == 0) {
                        arrayList.add(strArr3[i25]);
                        i25 += 64;
                    } else {
                        arrayList.add(strArr3[i25]);
                        i25++;
                    }
                    i22 = 2;
                }
            }
            long j3 = (((long) (-683065209)) << 32) ^ ((long) (i13 ^ i14));
            long j4 = -683065210;
            int i27 = getARTIFICIAL_FRAME_PACKAGE_NAME + 65;
            artificialFrame = i27 % 128;
            int i28 = i27 % 2;
            try {
                Object[] objArr21 = {Long.valueOf(j3), Long.valueOf(j4)};
                byte[] bArr4 = $$m;
                byte b14 = bArr4[18];
                Object[] objArr22 = new Object[1];
                f(b14, b14, bArr4[44], objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                f((byte) 79, bArr4[5], (byte) 80, objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i29 = ((int[]) objArr[3])[0];
                int i30 = ((int[]) objArr[0])[0];
                int i31 = ((int[]) objArr[1])[0];
                String[] strArr4 = (String[]) objArr[2];
                int streamVolume = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getStreamVolume(3);
                int i32 = ~streamVolume;
                int i33 = i29 + (-1318513795) + ((~(292179978 | i32)) * (-560)) + ((~(streamVolume | 368734526)) * (-560)) + (((~((-94007613) | i32)) | 17453064) * 560);
                int i34 = (i33 << 13) ^ i33;
                int i35 = i34 ^ (i34 >>> 17);
                ((int[]) objArr24[3])[0] = i35 ^ (i35 << 5);
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
            int iAlpha = 26 - Color.alpha(0);
            char c5 = (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
            int iGreen = Color.green(0) + 1041;
            byte[] bArr5 = $$d;
            byte b15 = bArr5[21];
            Object[] objArr25 = new Object[1];
            d(b15, b15, (byte) (-bArr5[8]), objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(iAlpha, c5, iGreen, 2061780482, false, (String) objArr25[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j5 != -1) {
            long j6 = j5 + 4611686018427387921L;
            Object[] objArr26 = new Object[1];
            e(null, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) + 90, null, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            e(null, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, ExpandableListView.getPackedPositionType(0L) + 127, null, objArr27);
            if (j6 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame10 == null) {
                    int iCombineMeasuredStates = View.combineMeasuredStates(0, 0) + 26;
                    char packedPositionType = (char) ExpandableListView.getPackedPositionType(0L);
                    int maxKeyCode = (KeyEvent.getMaxKeyCode() >> 16) + 1041;
                    byte b16 = $$d[21];
                    byte b17 = b16;
                    Object[] objArr28 = new Object[1];
                    d(b16, b17, b17, objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates, packedPositionType, maxKeyCode, 1145017376, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i36 = ((int[]) objArr29[3])[0];
                int i37 = ((int[]) objArr29[2])[0];
                String[] strArr5 = (String[]) objArr29[0];
                int iIdentityHashCode = System.identityHashCode(this);
                int i38 = ~iIdentityHashCode;
                int i39 = (-255608850) + (((~((-80266497) | i38)) | (~((-19085842) | iIdentityHashCode))) * 520);
                int i40 = ~(19085841 | i38);
                int i41 = ~(iIdentityHashCode | 97189648);
                int i42 = i39 + ((i40 | i41) * (-1040)) + ((i41 | (~(i38 | (-97189649))) | (-99352338)) * 520) + 1909128864;
                int i43 = (i42 << 13) ^ i42;
                int i44 = i43 ^ (i43 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i44 ^ (i44 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                e(null, new byte[]{-115, -116, -117, -120, -118, -119, -121, -106, -126, -127, -113, -121, -127, -107, -127, -108}, (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + WebSocketProtocol.PAYLOAD_SHORT, null, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                e(null, new byte[]{-116, -125, -123, -114, -104, -120, -127, -105, -118, -117, -122, -117, -126, -116, -125, -122}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + b.l, null, objArr31);
                int iIntValue = ((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue();
                Object[] objArr32 = {1791228615};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 7, (char) (22251 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))), 1032 - TextUtils.lastIndexOf("", '0', 0, 0), 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = HmacPrfKey.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr32), 1909128864, false);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame5 == null) {
                    int touchSlop = 26 - (ViewConfiguration.getTouchSlop() >> 8);
                    char c6 = (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1);
                    int iIndexOf3 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1042;
                    byte b18 = $$d[21];
                    byte b19 = b18;
                    Object[] objArr33 = new Object[1];
                    d(b18, b19, b19, objArr33);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(touchSlop, c6, iIndexOf3, 1145017376, false, (String) objArr33[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Object[] objArr34 = new Object[1];
                    e(null, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) + 12, null, objArr34);
                    Class<?> cls9 = Class.forName((String) objArr34[0]);
                    Object[] objArr35 = new Object[1];
                    e(null, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, 127 - (ViewConfiguration.getKeyRepeatDelay() >> 16), null, objArr35);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr35[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame6 == null) {
                        int iRgb = (-16777190) - Color.rgb(0, 0, 0);
                        char capsMode = (char) TextUtils.getCapsMode("", 0, 0);
                        int maximumFlingVelocity = 1041 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                        byte[] bArr6 = $$d;
                        byte b20 = bArr6[21];
                        Object[] objArr36 = new Object[1];
                        d(b20, b20, (byte) (-bArr6[8]), objArr36);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iRgb, capsMode, maximumFlingVelocity, 2061780482, false, (String) objArr36[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr37 = new Object[1];
            e(null, new byte[]{-115, -116, -117, -120, -118, -119, -121, -106, -126, -127, -113, -121, -127, -107, -127, -108}, (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + WebSocketProtocol.PAYLOAD_SHORT, null, objArr37);
            Class<?> cls10 = Class.forName((String) objArr37[0]);
            Object[] objArr38 = new Object[1];
            e(null, new byte[]{-116, -125, -123, -114, -104, -120, -127, -105, -118, -117, -122, -117, -126, -116, -125, -122}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + b.l, null, objArr38);
            int iIntValue2 = ((Integer) cls10.getMethod((String) objArr38[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr39 = {1791228615};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 7, (char) (22251 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))), 1032 - TextUtils.lastIndexOf("", '0', 0, 0), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = HmacPrfKey.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr39), 1909128864, false);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame5 == null) {
                int touchSlop2 = 26 - (ViewConfiguration.getTouchSlop() >> 8);
                char c7 = (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1);
                int iIndexOf4 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1042;
                byte b110 = $$d[21];
                byte b111 = b110;
                Object[] objArr310 = new Object[1];
                d(b110, b111, b111, objArr310);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(touchSlop2, c7, iIndexOf4, 1145017376, false, (String) objArr310[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr311 = new Object[1];
            e(null, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) + 12, null, objArr311);
            Class<?> cls11 = Class.forName((String) objArr311[0]);
            Object[] objArr312 = new Object[1];
            e(null, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, 127 - (ViewConfiguration.getKeyRepeatDelay() >> 16), null, objArr312);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr312[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame6 == null) {
                int iRgb2 = (-16777190) - Color.rgb(0, 0, 0);
                char capsMode2 = (char) TextUtils.getCapsMode("", 0, 0);
                int maximumFlingVelocity2 = 1041 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                byte[] bArr7 = $$d;
                byte b21 = bArr7[21];
                Object[] objArr313 = new Object[1];
                d(b21, b21, (byte) (-bArr7[8]), objArr313);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iRgb2, capsMode2, maximumFlingVelocity2, 2061780482, false, (String) objArr313[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i45 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i46 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i46 == i45) {
            Object[] objArr40 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i47 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i48 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i49 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr6 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int i50 = ~new Random().nextInt();
            int i51 = i47 + ((((~((-983889592) | i50)) | 167822855) * (-241)) - 1384616619) + (((~(i50 | (-816066737))) | (-1073608640)) * 241);
            int i52 = (i51 << 13) ^ i51;
            int i53 = i52 ^ (i52 >>> 17);
            ((int[]) objArr40[1])[0] = i53 ^ (i53 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        if (strArr7 != null) {
            int i54 = 0;
            while (i54 < strArr7.length) {
                arrayList2.add(strArr7[i54]);
                i54++;
                int i55 = artificialFrame + 91;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i55 % 128;
                int i56 = i55 % 2;
            }
        }
        long j7 = (((long) (-410859973)) << 32) ^ ((long) (i45 ^ i46));
        long j8 = -410859975;
        int i57 = artificialFrame + 113;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i57 % 128;
        int i58 = i57 % 2;
        Object[] objArr41 = {Long.valueOf(j7), Long.valueOf(j8)};
        byte[] bArr8 = $$m;
        byte b22 = bArr8[18];
        Object[] objArr42 = new Object[1];
        f((byte) 39, b22, (byte) (b22 | 82), objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        Object[] objArr43 = new Object[1];
        f((byte) 79, bArr8[5], (byte) 80, objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {strArr, new int[1], new int[]{i}, new int[]{i}};
        int i59 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
        int i60 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        int i61 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        String[] strArr8 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        int iMyPid = Process.myPid();
        int i62 = (~(931534359 | iMyPid)) | 136956160;
        int i63 = ~iMyPid;
        int i64 = i59 + (-1138706346) + ((i62 | (~((-58852354) | i63))) * 886) + (((~(i63 | (-931534360))) | 1009638166) * (-1772)) + ((~(i63 | 1009638166)) * 886);
        int i65 = (i64 << 13) ^ i64;
        int i66 = i65 ^ (i65 >>> 17);
        ((int[]) objArr44[1])[0] = i66 ^ (i66 << 5);
    }
}
