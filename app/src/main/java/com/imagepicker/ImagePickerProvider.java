package com.imagepicker;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.FileProvider;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import com.google.crypto.tink.hybrid.internal.HpkePrivateKeyManager$$ExternalSyntheticLambda2;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import o.ArtificialStackFrames;
import o.ICustomTabsCallbackDefault;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes6.dex */
public class ImagePickerProvider extends FileProvider {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    private static char CoroutineDebuggingKt;
    private static int accessartificialFrame;
    private static int artificialFrame;
    private static long coroutineBoundary;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static final byte[] $$c = {52, -35, -61, -47};
    private static final int $$f = SyslogConstants.LOG_LOCAL7;
    private static int $10 = 0;
    private static int $11 = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0027). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(byte r7, byte r8, int r9) {
        /*
            byte[] r0 = com.imagepicker.ImagePickerProvider.$$c
            int r8 = r8 * 2
            int r8 = 1 - r8
            int r7 = r7 + 98
            int r9 = r9 * 2
            int r9 = r9 + 4
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r9
            r5 = r2
            goto L27
        L14:
            r3 = r2
        L15:
            byte r4 = (byte) r7
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r8) goto L22
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            return r7
        L22:
            r3 = r0[r9]
            r6 = r3
            r3 = r9
            r9 = r6
        L27:
            int r9 = -r9
            int r3 = r3 + 1
            int r7 = r7 + r9
            r9 = r3
            r3 = r5
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.imagepicker.ImagePickerProvider.$$g(byte, byte, int):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(byte r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.imagepicker.ImagePickerProvider.$$a
            int r6 = r6 + 4
            int r8 = r8 + 8
            int r7 = 112 - r7
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L11
            r7 = r6
            r3 = r8
            r4 = r2
            goto L2a
        L11:
            r3 = r2
        L12:
            int r6 = r6 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r8) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L23:
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r5
        L2a:
            int r6 = r6 + r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.imagepicker.ImagePickerProvider.b(byte, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0020  */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0020 -> B:11:0x0024). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0020
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void c(int r5, byte r6, short r7, java.lang.Object[] r8) {
        /*
            int r0 = r5 + 3
            byte[] r1 = com.imagepicker.ImagePickerProvider.$$d
            int r7 = r7 + 4
            int r6 = 105 - r6
            byte[] r0 = new byte[r0]
            int r5 = r5 + 2
            r2 = 0
            if (r1 != 0) goto L12
            r4 = r5
            r3 = r2
            goto L24
        L12:
            r3 = r2
        L13:
            byte r4 = (byte) r6
            r0[r3] = r4
            if (r3 != r5) goto L20
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            r8[r2] = r5
            return
        L20:
            int r3 = r3 + 1
            r4 = r1[r7]
        L24:
            int r6 = r6 + r4
            int r7 = r7 + 1
            int r6 = r6 + (-1)
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.imagepicker.ImagePickerProvider.c(int, byte, short, java.lang.Object[]):void");
    }

    private static void a(char[] cArr, int i, char[] cArr2, char c, char[] cArr3, Object[] objArr) throws Throwable {
        char c2;
        int i2 = 2 % 2;
        ICustomTabsCallbackDefault iCustomTabsCallbackDefault = new ICustomTabsCallbackDefault();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr3.length;
        char[] cArr6 = new char[length3];
        iCustomTabsCallbackDefault.a = 0;
        int i3 = $11 + 93;
        $10 = i3 % 128;
        int i4 = i3 % 2;
        while (iCustomTabsCallbackDefault.a < length3) {
            int i5 = $10 + 45;
            $11 = i5 % 128;
            int i6 = i5 % 2;
            try {
                Object[] objArr2 = {iCustomTabsCallbackDefault};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-10548171);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) 1;
                    byte b2 = (byte) (b - 1);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 33, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16), 1483 - ((Process.getThreadPriority(0) + 20) >> 6), 1614432829, false, $$g(b, b2, b2), new Class[]{Object.class});
                }
                int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                Object[] objArr3 = {iCustomTabsCallbackDefault};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1818210492);
                if (objAccessartificialFrame2 == null) {
                    byte b3 = (byte) 3;
                    byte b4 = (byte) (b3 - 3);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(33 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) ((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 49168), TextUtils.getOffsetBefore("", 0) + 899, 214239564, false, $$g(b3, b4, b4), new Class[]{Object.class});
                }
                int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                Object[] objArr4 = {iCustomTabsCallbackDefault, Integer.valueOf(cArr4[iCustomTabsCallbackDefault.a % 4] * 32718), Integer.valueOf(cArr5[iIntValue])};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1532285801);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) 0;
                    byte b6 = b5;
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(TextUtils.getOffsetBefore("", 0) + 23, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 2441, -1003383455, false, $$g(b5, b6, b6), new Class[]{Object.class, Integer.TYPE, Integer.TYPE});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                Object[] objArr5 = {Integer.valueOf(cArr4[iIntValue2] * 32718), Integer.valueOf(cArr5[iIntValue])};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-950633141);
                if (objAccessartificialFrame4 == null) {
                    c2 = 2;
                    byte b7 = (byte) 2;
                    byte b8 = (byte) (b7 - 2);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(View.MeasureSpec.makeMeasureSpec(0, 0) + 20, (char) (29754 - (ViewConfiguration.getEdgeSlop() >> 16)), 1748 - (ViewConfiguration.getEdgeSlop() >> 16), 1479752515, false, $$g(b7, b8, b8), new Class[]{Integer.TYPE, Integer.TYPE});
                } else {
                    c2 = 2;
                }
                cArr5[iIntValue2] = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).charValue();
                cArr4[iIntValue2] = iCustomTabsCallbackDefault.MediaBrowserCompatApi21ConnectionCallback;
                cArr6[iCustomTabsCallbackDefault.a] = (char) (((((long) (cArr4[iIntValue2] ^ cArr3[iCustomTabsCallbackDefault.a])) ^ (coroutineBoundary ^ (-899883803867009716L))) ^ ((long) ((int) (((long) accessartificialFrame) ^ (-899883803867009716L))))) ^ ((long) ((char) (((long) CoroutineDebuggingKt) ^ (-899883803867009716L)))));
                iCustomTabsCallbackDefault.a++;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        objArr[0] = new String(cArr6);
    }

    /* JADX WARN: Code duplicated, block: B:142:0x0f03  */
    /* JADX WARN: Code duplicated, block: B:145:0x0f0c A[Catch: all -> 0x2365, TryCatch #5 {all -> 0x2365, blocks: (B:238:0x1990, B:240:0x199d, B:241:0x19c9, B:243:0x19d3, B:245:0x19e0, B:246:0x1a0e, B:177:0x134b, B:179:0x136c, B:180:0x13c1, B:143:0x0f06, B:145:0x0f0c, B:146:0x0f3b, B:148:0x0f64, B:149:0x0fef, B:15:0x0204, B:17:0x0218, B:18:0x0247), top: B:360:0x0204 }] */
    /* JADX WARN: Code duplicated, block: B:148:0x0f64 A[Catch: all -> 0x2365, TryCatch #5 {all -> 0x2365, blocks: (B:238:0x1990, B:240:0x199d, B:241:0x19c9, B:243:0x19d3, B:245:0x19e0, B:246:0x1a0e, B:177:0x134b, B:179:0x136c, B:180:0x13c1, B:143:0x0f06, B:145:0x0f0c, B:146:0x0f3b, B:148:0x0f64, B:149:0x0fef, B:15:0x0204, B:17:0x0218, B:18:0x0247), top: B:360:0x0204 }] */
    /* JADX WARN: Code duplicated, block: B:152:0x1002  */
    /* JADX WARN: Code duplicated, block: B:157:0x1070  */
    /* JADX WARN: Code duplicated, block: B:266:0x1c3a  */
    /* JADX WARN: Code duplicated, block: B:270:0x1cba  */
    /* JADX WARN: Code duplicated, block: B:275:0x1d25  */
    /* JADX WARN: Code duplicated, block: B:294:0x1ffd  */
    /* JADX WARN: Code duplicated, block: B:296:0x207a  */
    /* JADX WARN: Code duplicated, block: B:302:0x208a  */
    /* JADX WARN: Code duplicated, block: B:306:0x2119  */
    /* JADX WARN: Code duplicated, block: B:308:0x2122  */
    /* JADX WARN: Code duplicated, block: B:313:0x2191  */
    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public boolean onCreate() throws Throwable {
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object[] objArr;
        Object[] objArr2;
        Object objAccessartificialFrame;
        Object objAccessartificialFrame2;
        Object[] objArr3;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        Object[] objArr4;
        Object[] objArr5;
        Object[] objArr6;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        Context applicationContext;
        Object[] objArr7;
        Object[] objArr8;
        Object objAccessartificialFrame7;
        Object objAccessartificialFrame8;
        int i = 2 % 2;
        Object[] objArr9 = new Object[1];
        a(new char[]{46518, 47971, 10370, 8454}, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), new char[]{13820, 48031, 2559, 2675}, (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), new char[]{3562, 34828, 6640, 34936, 42410, 42649, 39722, 4663, 53532, 18173, 43184, 44706, 63995, 15048, 1775, 59298, 20901, 46400, 25434, 40754, 13309, 19957}, objArr9);
        String str = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        a(new char[]{46518, 47971, 10370, 8454}, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 843309563, new char[]{64287, 17377, 15154, 6507}, (char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 27451), new char[]{40632, 55675, 24680, 35180, 10643, 62662, 52866, 39443, 48510, 49195, 61416, 42457, 62078, 9804, 10360}, objArr10);
        String str2 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        a(new char[]{46518, 47971, 10370, 8454}, ViewConfiguration.getMaximumFlingVelocity() >> 16, new char[]{50257, 8306, 31359, 3466}, (char) (TextUtils.getOffsetBefore("", 0) + 35450), new char[]{16126, 30055, 17055, 40147, 20321, 17853, 50226, 49650, 44464, 17142, 46133, 47065, 55244, 1969, 41365, 14796}, objArr11);
        String str3 = (String) objArr11[0];
        Object[] objArr12 = new Object[1];
        a(new char[]{46518, 47971, 10370, 8454}, TextUtils.getOffsetBefore("", 0), new char[]{46693, 64804, 40571, 41210}, (char) (64158 - ExpandableListView.getPackedPositionGroup(0L)), new char[]{28725, 59493, 46164, 36004, 1512, 8939, 42118, 17742, 22008, 46237, 65432, 663, 36278, 15127, 47670, 29171}, objArr12);
        String str4 = (String) objArr12[0];
        Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame9 == null) {
            int i2 = 27 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
            char c = (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1);
            int iIndexOf = 1040 - TextUtils.indexOf((CharSequence) "", '0');
            byte[] bArr = $$a;
            byte b = bArr[5];
            Object[] objArr13 = new Object[1];
            b(b, (byte) (b + 1), bArr[71], objArr13);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(i2, c, iIndexOf, 2061780482, false, (String) objArr13[0], null);
        }
        long j = ((Field) objAccessartificialFrame9).getLong(null);
        if (j == -1 || j + 1920 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            try {
                Object[] objArr14 = {188025071};
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame10 == null) {
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(8 - View.MeasureSpec.getSize(0), (char) (22252 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), 1033 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = HpkePrivateKeyManager$$ExternalSyntheticLambda2.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame10).newInstance(objArr14), 544314737, false);
                Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame11 == null) {
                    int i3 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 25;
                    char c2 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                    int i4 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 1040;
                    byte[] bArr2 = $$a;
                    byte b2 = (byte) (-bArr2[11]);
                    byte b3 = bArr2[71];
                    Object[] objArr15 = new Object[1];
                    b(b2, (byte) (b3 - 1), b3, objArr15);
                    objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(i3, c2, i4, 1145017376, false, (String) objArr15[0], null);
                }
                ((Field) objAccessartificialFrame11).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Long lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame12 == null) {
                        int iIndexOf2 = 26 - TextUtils.indexOf("", "", 0, 0);
                        char bitsPerPixel = (char) ((-1) - ImageFormat.getBitsPerPixel(0));
                        int iIndexOf3 = TextUtils.indexOf("", "") + 1041;
                        byte[] bArr3 = $$a;
                        byte b4 = bArr3[5];
                        Object[] objArr16 = new Object[1];
                        b(b4, (byte) (b4 + 1), bArr3[71], objArr16);
                        objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iIndexOf2, bitsPerPixel, iIndexOf3, 2061780482, false, (String) objArr16[0], null);
                    }
                    ((Field) objAccessartificialFrame12).set(null, lValueOf);
                } catch (Exception unused) {
                    throw new RuntimeException();
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } else {
            Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame13 == null) {
                int trimmedLength = TextUtils.getTrimmedLength("") + 26;
                char modifierMetaStateMask = (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask()));
                int tapTimeout = (ViewConfiguration.getTapTimeout() >> 16) + 1041;
                byte[] bArr4 = $$a;
                byte b5 = (byte) (-bArr4[11]);
                byte b6 = bArr4[71];
                Object[] objArr17 = new Object[1];
                b(b5, (byte) (b6 - 1), b6, objArr17);
                objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(trimmedLength, modifierMetaStateMask, tapTimeout, 1145017376, false, (String) objArr17[0], null);
            }
            Object[] objArr18 = (Object[]) ((Field) objAccessartificialFrame13).get(null);
            objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
            int i5 = ((int[]) objArr18[3])[0];
            int i6 = ((int[]) objArr18[2])[0];
            String[] strArr = (String[]) objArr18[0];
            int iIdentityHashCode = System.identityHashCode(this);
            int i7 = (-1097905488) + (((~((-123261470) | iIdentityHashCode)) | 88658433) * 345) + (((~((-123261470) | (~iIdentityHashCode))) | (-133816096)) * 345) + ((~(iIdentityHashCode | (-88658434))) * 345) + 544314737;
            int i8 = (i7 << 13) ^ i7;
            int i9 = i8 ^ (i8 >>> 17);
            ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i9 ^ (i9 << 5);
        }
        int i10 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i11 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i11 == i10) {
            int i12 = artificialFrame + 9;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i12 % 128;
            int i13 = i12 % 2;
            Object[] objArr19 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i14 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i15 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i16 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int i17 = ~((int) Process.getElapsedCpuTime());
            int i18 = i14 + 571522302 + ((100128573 | i17) * SyslogConstants.LOG_LOCAL7) + (((~(i17 | 93836860)) | 90687233) * SyslogConstants.LOG_LOCAL7);
            int i19 = (i18 << 13) ^ i18;
            int i20 = i19 ^ (i19 >>> 17);
            ((int[]) objArr19[1])[0] = i20 ^ (i20 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr3 != null) {
                for (String str5 : strArr3) {
                    arrayList.add(str5);
                }
            }
            try {
                Object[] objArr20 = {Long.valueOf((((long) (-1896511200)) << 32) ^ ((long) (i10 ^ i11))), Long.valueOf(-1896511198)};
                byte[] bArr5 = $$d;
                Object[] objArr21 = new Object[1];
                c((byte) (-bArr5[612]), bArr5[4], bArr5[14], objArr21);
                Class<?> cls = Class.forName((String) objArr21[0]);
                Object[] objArr22 = new Object[1];
                c(bArr5[14], bArr5[538], bArr5[210], objArr22);
                cls.getMethod((String) objArr22[0], Long.TYPE, Long.TYPE).invoke(null, objArr20);
                Object[] objArr23 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i21 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i22 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i23 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int iIdentityHashCode2 = System.identityHashCode(this);
                int i24 = i21 + (-1514059266) + (((~((-134221832) | (~iIdentityHashCode2))) | (~((-56118025) | iIdentityHashCode2))) * (-272)) + (((~((-1015125032) | iIdentityHashCode2)) | 880903200) * (-272)) + (((~(iIdentityHashCode2 | 1015125031)) | (-937021225)) * 272);
                int i25 = (i24 << 13) ^ i24;
                int i26 = i25 ^ (i25 >>> 17);
                ((int[]) objArr23[1])[0] = i26 ^ (i26 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 != null) {
                    throw cause2;
                }
                throw th2;
            }
        }
        Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame14 == null) {
            int pressedStateDuration = (ViewConfiguration.getPressedStateDuration() >> 16) + 21;
            char scrollDefaultDelay = (char) (ViewConfiguration.getScrollDefaultDelay() >> 16);
            int minimumFlingVelocity = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 465;
            byte[] bArr6 = $$a;
            byte b7 = bArr6[5];
            Object[] objArr24 = new Object[1];
            b(b7, (byte) (b7 + 1), bArr6[71], objArr24);
            objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(pressedStateDuration, scrollDefaultDelay, minimumFlingVelocity, -785931255, false, (String) objArr24[0], null);
        }
        long j2 = ((Field) objAccessartificialFrame14).getLong(null);
        if (j2 == -1 || j2 + 1959 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr25 = new Object[1];
            a(new char[]{46518, 47971, 10370, 8454}, Gravity.getAbsoluteGravity(0, 0), new char[]{32026, 11577, 60216, 38564}, (char) (42219 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), new char[]{12777, 47487, 17566, 12729, 14072, 11387, 24025, 10468, 14598, 22255, 27869, 3275, 22513, 32447, 44666, 3537, 45728, 41313, 31607, 5386, 60608, 15960, 49632, 40669, 57448, 673}, objArr25);
            Class<?> cls2 = Class.forName((String) objArr25[0]);
            Object[] objArr26 = new Object[1];
            a(new char[]{46518, 47971, 10370, 8454}, ViewConfiguration.getScrollBarFadeDuration() >> 16, new char[]{29502, 17003, 45716, 7110}, (char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 50866), new char[]{47128, 988, 26405, 17350, 6102, 30177, 31899, 8390, 31328, 22464, 45883, 34843, 9202, 9983, 51879, 53016, 8100, 40206}, objArr26);
            Context applicationContext2 = (Context) cls2.getMethod((String) objArr26[0], new Class[0]).invoke(null, null);
            if (applicationContext2 != null) {
                int i27 = getARTIFICIAL_FRAME_PACKAGE_NAME + 75;
                artificialFrame = i27 % 128;
                if (i27 % 2 == 0) {
                    boolean z = applicationContext2 instanceof ContextWrapper;
                    throw null;
                }
                applicationContext2 = ((applicationContext2 instanceof ContextWrapper) && ((ContextWrapper) applicationContext2).getBaseContext() == null) ? null : applicationContext2.getApplicationContext();
            }
            int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr27 = new Object[1];
            a(new char[]{46518, 47971, 10370, 8454}, TextUtils.indexOf("", "", 0, 0), new char[]{52268, 64950, 22581, 60724}, (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1), new char[]{6152, 53773, 25116, 21696, 37699, 36886, 4367, 22997, 5890, 1939, 54764, 57418, 45302, 40515, 65393, 38700, 33106, 46984, 59288, 52214, 10380, 36621, 47354, 65447, 23410, 431, 33441, 59146, 35332, 30788, 54820, 30281, 60335, 65035, 41217, 55701, 29509, 36310, 'j', 44038, 54620, 641, 43202, 5398, 12170, 9435, 31554, 62233, 137, 28510, 38163, 25547, 54293, 45343, 18465, 34005, 45849, 4146, 15799, 780, 12716, 4470, 49987, 32973}, objArr27);
            String str6 = (String) objArr27[0];
            Object[] objArr28 = new Object[1];
            a(new char[]{46518, 47971, 10370, 8454}, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), new char[]{6346, 19976, 12967, 52107}, (char) TextUtils.indexOf("", ""), new char[]{59629, 64130, 29912, 41934, 59382, 61199, 54612, 19370, 19806, 50651, 48626, 10212, 29455, 61412, 18045, 43749, 64173, 28955, 44957, 40590, 15943, 44712, 51744, 42306, 28771, 41490, 60771, 20459, 52280, 1882, 43720, 11277, 53868, 36200, 40107, 49977, 32580, 2195, 4891, 60270, 6131, 37108, 13844, 23982, 18353, 60116, 39908, 55793, 45306, 46558, 821, 12815, 4440, 4150, 36852, 16283, 6713, 45434, 44017, 11580, 26875, 18408, 20385, 3761}, objArr28);
            try {
                Object[] objArr29 = {applicationContext2, new String[]{str6, (String) objArr28[0]}, Integer.valueOf(iIntValue2), 1, 1329362544};
                byte[] bArr7 = $$d;
                byte b8 = bArr7[226];
                byte b9 = bArr7[14];
                Object[] objArr30 = new Object[1];
                c(b8, b9, (short) (b9 | 44), objArr30);
                Class<?> cls3 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                c(bArr7[79], bArr7[84], (short) (bArr7[0] - 1), objArr31);
                objArr = (Object[]) cls3.getMethod((String) objArr31[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr29);
                int i28 = ((int[]) objArr[0])[0];
                int i29 = ((int[]) objArr[3])[0];
                if (applicationContext2 != null) {
                    Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1142731807);
                    if (objAccessartificialFrame15 == null) {
                        int iRgb = (-16777195) - Color.rgb(0, 0, 0);
                        char cIndexOf = (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0'));
                        int i30 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 464;
                        byte[] bArr8 = $$a;
                        byte b10 = (byte) (-bArr8[11]);
                        byte b11 = bArr8[71];
                        Object[] objArr32 = new Object[1];
                        b(b10, (byte) (b11 - 1), b11, objArr32);
                        objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(iRgb, cIndexOf, i30, -612765161, false, (String) objArr32[0], null);
                    }
                    ((Field) objAccessartificialFrame15).set(null, objArr);
                    try {
                        Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1313006081);
                        if (objAccessartificialFrame16 == null) {
                            int jumpTapTimeout = 21 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                            char scrollBarSize = (char) (ViewConfiguration.getScrollBarSize() >> 8);
                            int packedPositionChild = 464 - ExpandableListView.getPackedPositionChild(0L);
                            byte[] bArr9 = $$a;
                            byte b12 = bArr9[5];
                            Object[] objArr33 = new Object[1];
                            b(b12, (byte) (b12 + 1), bArr9[71], objArr33);
                            objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout, scrollBarSize, packedPositionChild, -785931255, false, (String) objArr33[0], null);
                        }
                        ((Field) objAccessartificialFrame16).set(null, lValueOf2);
                    } catch (Exception unused2) {
                        throw new RuntimeException();
                    }
                }
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 != null) {
                    throw cause3;
                }
                throw th3;
            }
        } else {
            Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(1142731807);
            if (objAccessartificialFrame17 == null) {
                int iLastIndexOf = 20 - TextUtils.lastIndexOf("", '0', 0);
                char c3 = (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
                int scrollDefaultDelay2 = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 465;
                byte[] bArr10 = $$a;
                byte b13 = (byte) (-bArr10[11]);
                byte b14 = bArr10[71];
                Object[] objArr34 = new Object[1];
                b(b13, (byte) (b14 - 1), b14, objArr34);
                objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, c3, scrollDefaultDelay2, -612765161, false, (String) objArr34[0], null);
            }
            Object[] objArr35 = (Object[]) ((Field) objAccessartificialFrame17).get(null);
            objArr = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
            int i31 = ((int[]) objArr35[3])[0];
            int i32 = ((int[]) objArr35[0])[0];
            String[] strArr5 = (String[]) objArr35[1];
            int iIdentityHashCode3 = System.identityHashCode(this);
            int i33 = ((((~((-767781965) | iIdentityHashCode3)) | 603991052) * (-283)) - 708874399) + ((~(iIdentityHashCode3 | (-163790913))) * 283) + 1329362544;
            int i34 = (i33 << 13) ^ i33;
            int i35 = i34 ^ (i34 >>> 17);
            ((int[]) objArr[2])[0] = i35 ^ (i35 << 5);
        }
        int i36 = ((int[]) objArr[0])[0];
        int i37 = ((int[]) objArr[3])[0];
        if (i37 == i36) {
            Object[] objArr36 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i38 = ((int[]) objArr[2])[0];
            int i39 = ((int[]) objArr[3])[0];
            int i40 = ((int[]) objArr[0])[0];
            String[] strArr6 = (String[]) objArr[1];
            int iIdentityHashCode4 = System.identityHashCode(this);
            int i41 = ~iIdentityHashCode4;
            int i42 = i38 + (-800143894) + (((-142737957) | i41) * (-369)) + (((~((-840490452) | i41)) | (-680140726)) * (-369)) + (((~(iIdentityHashCode4 | 840490451)) | (-983228408) | (~(i41 | (-537402770)))) * 369);
            int i43 = (i42 << 13) ^ i42;
            int i44 = i43 ^ (i43 >>> 17);
            ((int[]) objArr36[2])[0] = i44 ^ (i44 << 5);
        } else {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr7 = (String[]) objArr[1];
            if (strArr7 != null) {
                int i45 = getARTIFICIAL_FRAME_PACKAGE_NAME + 89;
                artificialFrame = i45 % 128;
                int i46 = i45 % 2;
                for (String str7 : strArr7) {
                    arrayList2.add(str7);
                }
            }
            Object[] objArr37 = {Long.valueOf((((long) 1339247262) << 32) ^ ((long) (i36 ^ i37))), Long.valueOf(1339247326)};
            byte[] bArr11 = $$d;
            byte b15 = bArr11[225];
            byte b16 = bArr11[4];
            Object[] objArr38 = new Object[1];
            c(b15, b16, (short) (b16 | 97), objArr38);
            Class<?> cls4 = Class.forName((String) objArr38[0]);
            Object[] objArr39 = new Object[1];
            c(bArr11[14], bArr11[538], bArr11[210], objArr39);
            cls4.getMethod((String) objArr39[0], Long.TYPE, Long.TYPE).invoke(null, objArr37);
            Object[] objArr40 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i47 = ((int[]) objArr[2])[0];
            int i48 = ((int[]) objArr[3])[0];
            int i49 = ((int[]) objArr[0])[0];
            String[] strArr8 = (String[]) objArr[1];
            int i50 = ~System.identityHashCode(this);
            int i51 = i47 + (-1222835690) + (((~(177480618 | i50)) | (-337830345)) * (-983)) + (((~(i50 | (-337830345))) | 8584) * 983);
            int i52 = (i51 << 13) ^ i51;
            int i53 = i52 ^ (i52 >>> 17);
            ((int[]) objArr40[2])[0] = i53 ^ (i53 << 5);
        }
        Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame18 == null) {
            int bitsPerPixel2 = 29 - ImageFormat.getBitsPerPixel(0);
            char cResolveOpacity = (char) (Drawable.resolveOpacity(0, 0) + 49362);
            int i54 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 685;
            byte[] bArr12 = $$a;
            Object[] objArr41 = new Object[1];
            b(bArr12[19], bArr12[41], bArr12[63], objArr41);
            objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(bitsPerPixel2, cResolveOpacity, i54, 752929587, false, (String) objArr41[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame18).getLong(null);
        if (j3 == -1 || j3 + 1916 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr42 = new Object[1];
            a(new char[]{46518, 47971, 10370, 8454}, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), new char[]{32026, 11577, 60216, 38564}, (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 42218), new char[]{12777, 47487, 17566, 12729, 14072, 11387, 24025, 10468, 14598, 22255, 27869, 3275, 22513, 32447, 44666, 3537, 45728, 41313, 31607, 5386, 60608, 15960, 49632, 40669, 57448, 673}, objArr42);
            Class<?> cls5 = Class.forName((String) objArr42[0]);
            Object[] objArr43 = new Object[1];
            a(new char[]{46518, 47971, 10370, 8454}, ViewConfiguration.getMinimumFlingVelocity() >> 16, new char[]{29502, 17003, 45716, 7110}, (char) (50866 - View.getDefaultSize(0, 0)), new char[]{47128, 988, 26405, 17350, 6102, 30177, 31899, 8390, 31328, 22464, 45883, 34843, 9202, 9983, 51879, 53016, 8100, 40206}, objArr43);
            Context applicationContext3 = (Context) cls5.getMethod((String) objArr43[0], new Class[0]).invoke(null, null);
            if (applicationContext3 != null) {
                applicationContext3 = ((applicationContext3 instanceof ContextWrapper) && ((ContextWrapper) applicationContext3).getBaseContext() == null) ? null : applicationContext3.getApplicationContext();
            }
            Object[] objArr44 = {applicationContext3, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1226553108};
            byte[] bArr13 = $$d;
            byte b17 = bArr13[103];
            byte b18 = bArr13[4];
            int i55 = $$e;
            Object[] objArr45 = new Object[1];
            c(b17, b18, (short) (i55 & 973), objArr45);
            Class<?> cls6 = Class.forName((String) objArr45[0]);
            Object[] objArr46 = new Object[1];
            c(bArr13[383], bArr13[387], (short) (i55 - 3), objArr46);
            objArr2 = (Object[]) cls6.getMethod((String) objArr46[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr44);
            if (applicationContext3 != null) {
                Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-326560385);
                if (objAccessartificialFrame19 == null) {
                    int iIndexOf4 = TextUtils.indexOf((CharSequence) "", '0') + 31;
                    char offsetBefore = (char) (49362 - TextUtils.getOffsetBefore("", 0));
                    int i56 = 684 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                    byte[] bArr14 = $$a;
                    Object[] objArr47 = new Object[1];
                    b((byte) (bArr14[116] + 1), bArr14[42], bArr14[63], objArr47);
                    objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(iIndexOf4, offsetBefore, i56, 1944867703, false, (String) objArr47[0], null);
                }
                ((Field) objAccessartificialFrame19).set(null, objArr2);
                try {
                    Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                    if (objAccessartificialFrame20 == null) {
                        int longPressTimeout = (ViewConfiguration.getLongPressTimeout() >> 16) + 30;
                        char cIndexOf2 = (char) (TextUtils.indexOf("", "", 0) + 49362);
                        int threadPriority = 684 - ((Process.getThreadPriority(0) + 20) >> 6);
                        byte[] bArr15 = $$a;
                        Object[] objArr48 = new Object[1];
                        b(bArr15[19], bArr15[41], bArr15[63], objArr48);
                        objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(longPressTimeout, cIndexOf2, threadPriority, 752929587, false, (String) objArr48[0], null);
                    }
                    ((Field) objAccessartificialFrame20).set(null, lValueOf3);
                } catch (Exception unused3) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(-326560385);
            if (objAccessartificialFrame21 == null) {
                int iResolveSize = 30 - View.resolveSize(0, 0);
                char cLastIndexOf = (char) (TextUtils.lastIndexOf("", '0') + 49363);
                int minimumFlingVelocity2 = 684 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                byte[] bArr16 = $$a;
                Object[] objArr49 = new Object[1];
                b((byte) (bArr16[116] + 1), bArr16[42], bArr16[63], objArr49);
                objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(iResolveSize, cLastIndexOf, minimumFlingVelocity2, 1944867703, false, (String) objArr49[0], null);
            }
            Object[] objArr50 = (Object[]) ((Field) objAccessartificialFrame21).get(null);
            objArr2 = new Object[]{new int[]{((int[]) objArr50[0])[0]}, new int[]{((int[]) objArr50[1])[0]}, new int[1], (String) objArr50[3]};
            int iNextInt = new Random().nextInt();
            int i57 = ~iNextInt;
            int i58 = 2067020644 + (((~(45104677 | i57)) | 1023728452) * (-90)) + (((~(45104677 | iNextInt)) | 45098017) * (-45)) + (((~(iNextInt | (-1023728453))) | 45104677 | (~(i57 | 1023728452))) * 45) + 1226553108;
            int i59 = (i58 << 13) ^ i58;
            int i60 = i59 ^ (i59 >>> 17);
            ((int[]) objArr2[2])[0] = i60 ^ (i60 << 5);
        }
        int i61 = ((int[]) objArr2[1])[0];
        int i62 = ((int[]) objArr2[0])[0];
        if (i62 == i61) {
            int i63 = ((int[]) objArr2[2])[0];
            Object[] objArr51 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int iIdentityHashCode5 = System.identityHashCode(this);
            int i64 = i63 + (-147699354) + (((~(iIdentityHashCode5 | 270403140)) | (-708220635)) * (-668)) + ((270403140 | (~((-708220635) | iIdentityHashCode5))) * 1336) + ((iIdentityHashCode5 | (-706777243)) * 668);
            int i65 = (i64 << 13) ^ i64;
            int i66 = i65 ^ (i65 >>> 17);
            ((int[]) objArr51[2])[0] = i66 ^ (i66 << 5);
        } else {
            Object[] objArr52 = {Long.valueOf((((long) 965655056) << 32) ^ ((long) (i61 ^ i62))), Long.valueOf(965655060)};
            byte[] bArr17 = $$d;
            byte b19 = bArr17[27];
            byte b20 = bArr17[4];
            Object[] objArr53 = new Object[1];
            c(b19, b20, (short) (b20 | 201), objArr53);
            Class<?> cls7 = Class.forName((String) objArr53[0]);
            Object[] objArr54 = new Object[1];
            c(bArr17[14], bArr17[538], bArr17[210], objArr54);
            cls7.getMethod((String) objArr54[0], Long.TYPE, Long.TYPE).invoke(null, objArr52);
            int i67 = ((int[]) objArr2[2])[0];
            Object[] objArr55 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int iIdentityHashCode6 = System.identityHashCode(this);
            int i68 = i67 + (((~(iIdentityHashCode6 | 1006311686)) | (-27687912)) * 56) + 1994169686 + (((~((~iIdentityHashCode6) | (-27687912))) | 1006311686) * 56);
            int i69 = (i68 << 13) ^ i68;
            int i70 = i69 ^ (i69 >>> 17);
            ((int[]) objArr55[2])[0] = i70 ^ (i70 << 5);
        }
        Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame22 == null) {
            int modifierMetaStateMask2 = ((byte) KeyEvent.getModifierMetaStateMask()) + 37;
            char maximumFlingVelocity = (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16);
            int i71 = 541 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
            byte[] bArr18 = $$a;
            byte b21 = bArr18[5];
            Object[] objArr56 = new Object[1];
            b(b21, (byte) (b21 + 1), bArr18[71], objArr56);
            objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask2, maximumFlingVelocity, i71, 624296913, false, (String) objArr56[0], null);
        }
        long j4 = ((Field) objAccessartificialFrame22).getLong(null);
        if (j4 != -1) {
            int i72 = getARTIFICIAL_FRAME_PACKAGE_NAME + 89;
            artificialFrame = i72 % 128;
            int i73 = i72 % 2;
            if (j4 + 2020 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                if (objAccessartificialFrame23 == null) {
                    int iMyTid = 36 - (Process.myTid() >> 22);
                    char c4 = (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                    int i74 = 541 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                    byte[] bArr19 = $$a;
                    byte b22 = (byte) (-bArr19[11]);
                    byte b23 = bArr19[71];
                    Object[] objArr57 = new Object[1];
                    b(b22, (byte) (b23 - 1), b23, objArr57);
                    objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(iMyTid, c4, i74, 793268735, false, (String) objArr57[0], null);
                }
                Object[] objArr58 = (Object[]) ((Field) objAccessartificialFrame23).get(null);
                objArr3 = new Object[]{new int[1], new int[1], new int[1]};
                int i75 = ((int[]) objArr58[2])[0];
                int i76 = ((int[]) objArr58[1])[0];
                ((int[]) objArr3[2])[0] = i75;
                ((int[]) objArr3[1])[0] = i76;
                int iIdentityHashCode7 = System.identityHashCode(this);
                int i77 = ~iIdentityHashCode7;
                int i78 = (-1130007499) + ((168563300 | i77) * (-192)) + (((~((-636732690) | i77)) | 546325760) * (-384)) + (((~(iIdentityHashCode7 | 805295989)) | (~(i77 | (-90406930))) | (~((-546325761) | iIdentityHashCode7))) * JfifUtil.MARKER_SOFn) + 1942224284;
                int i79 = (i78 << 13) ^ i78;
                int i80 = i79 ^ (i79 >>> 17);
                ((int[]) objArr3[0])[0] = i80 ^ (i80 << 5);
            } else {
                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1717965552);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 21, (char) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 39516), TextUtils.getCapsMode("", 0, 0) + 982, 117222168, false, null, new Class[0]);
                }
                Object[] objArr59 = {null, ((Constructor) objAccessartificialFrame).newInstance(null), 1942224284, 0};
                objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-501205803);
                if (objAccessartificialFrame2 == null) {
                    int capsMode = TextUtils.getCapsMode("", 0, 0) + 36;
                    char cAlpha = (char) Color.alpha(0);
                    int iIndexOf5 = 540 - TextUtils.indexOf("", "");
                    byte b24 = (byte) ($$b - 3);
                    Object[] objArr60 = new Object[1];
                    b(b24, (byte) (b24 + 2), $$a[39], objArr60);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(capsMode, cAlpha, iIndexOf5, 2101703389, false, (String) objArr60[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(55 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (832 - MotionEvent.axisFromString("")), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 577), (Class) ArtificialStackFrames.coroutineCreation(54 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 630), Integer.TYPE, Integer.TYPE});
                }
                objArr3 = (Object[]) ((Method) objAccessartificialFrame2).invoke(null, objArr59);
                objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                if (objAccessartificialFrame3 == null) {
                    int i81 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 36;
                    char scrollDefaultDelay3 = (char) (ViewConfiguration.getScrollDefaultDelay() >> 16);
                    int i82 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 539;
                    byte[] bArr20 = $$a;
                    byte b25 = (byte) (-bArr20[11]);
                    byte b26 = bArr20[71];
                    Object[] objArr61 = new Object[1];
                    b(b25, (byte) (b26 - 1), b26, objArr61);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i81, scrollDefaultDelay3, i82, 793268735, false, (String) objArr61[0], null);
                }
                ((Field) objAccessartificialFrame3).set(null, objArr3);
                try {
                    Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                    if (objAccessartificialFrame4 == null) {
                        int i83 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 35;
                        char c5 = (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                        int iKeyCodeFromString = 540 - KeyEvent.keyCodeFromString("");
                        byte[] bArr21 = $$a;
                        byte b27 = bArr21[5];
                        Object[] objArr62 = new Object[1];
                        b(b27, (byte) (b27 + 1), bArr21[71], objArr62);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i83, c5, iKeyCodeFromString, 624296913, false, (String) objArr62[0], null);
                    }
                    ((Field) objAccessartificialFrame4).set(null, lValueOf4);
                } catch (Exception unused4) {
                    throw new RuntimeException();
                }
            }
        } else {
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1717965552);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 21, (char) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 39516), TextUtils.getCapsMode("", 0, 0) + 982, 117222168, false, null, new Class[0]);
            }
            Object[] objArr510 = {null, ((Constructor) objAccessartificialFrame).newInstance(null), 1942224284, 0};
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-501205803);
            if (objAccessartificialFrame2 == null) {
                int capsMode2 = TextUtils.getCapsMode("", 0, 0) + 36;
                char cAlpha2 = (char) Color.alpha(0);
                int iIndexOf6 = 540 - TextUtils.indexOf("", "");
                byte b28 = (byte) ($$b - 3);
                Object[] objArr63 = new Object[1];
                b(b28, (byte) (b28 + 2), $$a[39], objArr63);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(capsMode2, cAlpha2, iIndexOf6, 2101703389, false, (String) objArr63[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(55 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (832 - MotionEvent.axisFromString("")), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 577), (Class) ArtificialStackFrames.coroutineCreation(54 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 630), Integer.TYPE, Integer.TYPE});
            }
            objArr3 = (Object[]) ((Method) objAccessartificialFrame2).invoke(null, objArr510);
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame3 == null) {
                int i84 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 36;
                char scrollDefaultDelay4 = (char) (ViewConfiguration.getScrollDefaultDelay() >> 16);
                int i85 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 539;
                byte[] bArr22 = $$a;
                byte b29 = (byte) (-bArr22[11]);
                byte b210 = bArr22[71];
                Object[] objArr64 = new Object[1];
                b(b29, (byte) (b210 - 1), b210, objArr64);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i84, scrollDefaultDelay4, i85, 793268735, false, (String) objArr64[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, objArr3);
            Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1168947751);
            if (objAccessartificialFrame4 == null) {
                int i86 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 35;
                char c6 = (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                int iKeyCodeFromString2 = 540 - KeyEvent.keyCodeFromString("");
                byte[] bArr23 = $$a;
                byte b211 = bArr23[5];
                Object[] objArr65 = new Object[1];
                b(b211, (byte) (b211 + 1), bArr23[71], objArr65);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i86, c6, iKeyCodeFromString2, 624296913, false, (String) objArr65[0], null);
            }
            ((Field) objAccessartificialFrame4).set(null, lValueOf5);
        }
        Object obj = objArr3[1];
        int i87 = ((int[]) obj)[0];
        Object obj2 = objArr3[2];
        int i88 = ((int[]) obj2)[0];
        if (i88 == i87) {
            Object[] objArr66 = {new int[1], new int[1], new int[1]};
            int i89 = ((int[]) objArr3[0])[0];
            int i90 = ((int[]) obj2)[0];
            int i91 = ((int[]) obj)[0];
            ((int[]) objArr66[2])[0] = i90;
            ((int[]) objArr66[1])[0] = i91;
            int iIdentityHashCode8 = System.identityHashCode(this);
            int i92 = ~iIdentityHashCode8;
            int i93 = i89 + 681606324 + (((~((-433663666) | i92)) | (~((-917958085) | i92))) * (-867)) + (((~((-433663666) | iIdentityHashCode8)) | 277884032 | (~((-917958085) | iIdentityHashCode8))) * (-1734)) + (((~(iIdentityHashCode8 | (-640074053))) | (~(i92 | (-277884033))) | (~((-155779634) | iIdentityHashCode8))) * 867);
            int i94 = (i93 << 13) ^ i93;
            int i95 = i94 ^ (i94 >>> 17);
            ((int[]) objArr66[0])[0] = i95 ^ (i95 << 5);
        } else {
            Object[] objArr67 = {Long.valueOf((((long) 854702430) << 32) ^ ((long) (i87 ^ i88))), Long.valueOf(854698334)};
            byte[] bArr24 = $$d;
            byte b30 = bArr24[81];
            byte b31 = bArr24[4];
            Object[] objArr68 = new Object[1];
            c(b30, b31, (short) (b31 | 225), objArr68);
            Class<?> cls8 = Class.forName((String) objArr68[0]);
            Object[] objArr69 = new Object[1];
            c(bArr24[14], bArr24[538], bArr24[210], objArr69);
            cls8.getMethod((String) objArr69[0], Long.TYPE, Long.TYPE).invoke(null, objArr67);
            Object[] objArr70 = {new int[1], new int[1], new int[1]};
            int i96 = ((int[]) objArr3[0])[0];
            int i97 = ((int[]) objArr3[2])[0];
            int i98 = ((int[]) objArr3[1])[0];
            ((int[]) objArr70[2])[0] = i97;
            ((int[]) objArr70[1])[0] = i98;
            int iIdentityHashCode9 = System.identityHashCode(this);
            int i99 = (~((-971070505) | iIdentityHashCode9)) | 278937608;
            int i100 = i96 + 962132421 + (i99 * 992) + ((i99 | (~((~iIdentityHashCode9) | 1072684141))) * (-496)) + ((iIdentityHashCode9 | 380551245) * 496);
            int i101 = (i100 << 13) ^ i100;
            int i102 = i101 ^ (i101 >>> 17);
            ((int[]) objArr70[0])[0] = i102 ^ (i102 << 5);
        }
        Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame24 == null) {
            int i103 = 25 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
            char maxKeyCode = (char) (30068 - (KeyEvent.getMaxKeyCode() >> 16));
            int longPressTimeout2 = 816 - (ViewConfiguration.getLongPressTimeout() >> 16);
            byte[] bArr25 = $$a;
            byte b32 = bArr25[5];
            Object[] objArr71 = new Object[1];
            b(b32, (byte) (b32 + 1), bArr25[71], objArr71);
            objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(i103, maxKeyCode, longPressTimeout2, 721586079, false, (String) objArr71[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame24).getLong(null);
        if (j5 == -1 || j5 + 1947 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr72 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -418893131};
            Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame25 == null) {
                int iLastIndexOf2 = TextUtils.lastIndexOf("", '0', 0) + 26;
                char cMyPid = (char) (30068 - (Process.myPid() >> 22));
                int i104 = 817 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                byte[] bArr26 = $$a;
                Object[] objArr73 = new Object[1];
                b((byte) 65, (byte) (bArr26[116] - 1), bArr26[24], objArr73);
                objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(iLastIndexOf2, cMyPid, i104, -797394565, false, (String) objArr73[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr4 = (Object[]) ((Method) objAccessartificialFrame25).invoke(null, objArr72);
            Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame26 == null) {
                int windowTouchSlop = 25 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                char cMyTid = (char) (30068 - (Process.myTid() >> 22));
                int offsetBefore2 = 816 - TextUtils.getOffsetBefore("", 0);
                byte[] bArr27 = $$a;
                byte b33 = (byte) (-bArr27[11]);
                byte b34 = bArr27[71];
                Object[] objArr74 = new Object[1];
                b(b33, (byte) (b34 - 1), b34, objArr74);
                objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(windowTouchSlop, cMyTid, offsetBefore2, 891606461, false, (String) objArr74[0], null);
            }
            ((Field) objAccessartificialFrame26).set(null, objArr4);
            try {
                Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame27 == null) {
                    int iAxisFromString = 24 - MotionEvent.axisFromString("");
                    char modifierMetaStateMask3 = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 30069);
                    int i105 = 816 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                    byte[] bArr28 = $$a;
                    byte b35 = bArr28[5];
                    Object[] objArr75 = new Object[1];
                    b(b35, (byte) (b35 + 1), bArr28[71], objArr75);
                    objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(iAxisFromString, modifierMetaStateMask3, i105, 721586079, false, (String) objArr75[0], null);
                }
                ((Field) objAccessartificialFrame27).set(null, lValueOf6);
            } catch (Exception unused5) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame28 == null) {
                int i106 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 24;
                char c7 = (char) (30067 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                int i107 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 816;
                byte[] bArr29 = $$a;
                byte b36 = (byte) (-bArr29[11]);
                byte b37 = bArr29[71];
                Object[] objArr76 = new Object[1];
                b(b36, (byte) (b37 - 1), b37, objArr76);
                objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(i106, c7, i107, 891606461, false, (String) objArr76[0], null);
            }
            Object[] objArr77 = (Object[]) ((Field) objAccessartificialFrame28).get(null);
            objArr4 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i108 = ((int[]) objArr77[0])[0];
            int i109 = ((int[]) objArr77[1])[0];
            String[] strArr9 = (String[]) objArr77[2];
            int iMyUid = Process.myUid();
            int i110 = ~iMyUid;
            int i111 = (((((~(494235382 | i110)) | (~((-70273029) | iMyUid))) * 988) - 769892823) + ((((~(iMyUid | 225789988)) | 268445394) | (~(i110 | (-70273029)))) * 988)) - 418893131;
            int i112 = (i111 << 13) ^ i111;
            int i113 = i112 ^ (i112 >>> 17);
            ((int[]) objArr4[3])[0] = i113 ^ (i113 << 5);
        }
        int i114 = ((int[]) objArr4[1])[0];
        int i115 = ((int[]) objArr4[0])[0];
        if (i115 == i114) {
            Object[] objArr78 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i116 = ((int[]) objArr4[3])[0];
            int i117 = ((int[]) objArr4[0])[0];
            int i118 = ((int[]) objArr4[1])[0];
            String[] strArr10 = (String[]) objArr4[2];
            int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
            int i119 = ~iFreeMemory;
            int i120 = i116 + (-1458772415) + (((~(iFreeMemory | 111269600)) | (~((-69207777) | i119)) | (-128964590)) * (-68)) + ((~((-17694990) | i119)) * (-68)) + (((~((-111269601) | i119)) | (-86902766)) * 68);
            int i121 = (i120 << 13) ^ i120;
            int i122 = i121 ^ (i121 >>> 17);
            ((int[]) objArr78[3])[0] = i122 ^ (i122 << 5);
        } else {
            ArrayList arrayList3 = new ArrayList();
            String[] strArr11 = (String[]) objArr4[2];
            if (strArr11 != null) {
                for (String str8 : strArr11) {
                    arrayList3.add(str8);
                }
            }
            Object[] objArr79 = {Long.valueOf((((long) 202205384) << 32) ^ ((long) (i114 ^ i115))), Long.valueOf(202205385)};
            byte[] bArr30 = $$d;
            Object[] objArr80 = new Object[1];
            c((byte) 79, bArr30[4], (short) 265, objArr80);
            Class<?> cls9 = Class.forName((String) objArr80[0]);
            Object[] objArr81 = new Object[1];
            c(bArr30[14], bArr30[538], bArr30[210], objArr81);
            cls9.getMethod((String) objArr81[0], Long.TYPE, Long.TYPE).invoke(null, objArr79);
            Object[] objArr82 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i123 = ((int[]) objArr4[3])[0];
            int i124 = ((int[]) objArr4[0])[0];
            int i125 = ((int[]) objArr4[1])[0];
            String[] strArr12 = (String[]) objArr4[2];
            int iIdentityHashCode10 = System.identityHashCode(this);
            int i126 = i123 + 1496409245 + (((~((-494759937) | iIdentityHashCode10)) | 206594048) * 1504) + ((~(iIdentityHashCode10 | (-288165889))) * (-1504)) + 1516927536;
            int i127 = (i126 << 13) ^ i126;
            int i128 = i127 ^ (i127 >>> 17);
            ((int[]) objArr82[3])[0] = i128 ^ (i128 << 5);
        }
        Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame29 == null) {
            int iIndexOf7 = 17 - TextUtils.indexOf("", "", 0, 0);
            char bitsPerPixel3 = (char) (ImageFormat.getBitsPerPixel(0) + 1);
            int i129 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 747;
            byte[] bArr31 = $$a;
            byte b38 = bArr31[5];
            Object[] objArr83 = new Object[1];
            b(b38, (byte) (b38 + 1), bArr31[71], objArr83);
            objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(iIndexOf7, bitsPerPixel3, i129, -144068856, false, (String) objArr83[0], null);
        }
        long j6 = ((Field) objAccessartificialFrame29).getLong(null);
        if (j6 == -1 || j6 + 1884 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr84 = new Object[1];
            a(new char[]{46518, 47971, 10370, 8454}, ExpandableListView.getPackedPositionType(0L), new char[]{32026, 11577, 60216, 38564}, (char) (42219 - Drawable.resolveOpacity(0, 0)), new char[]{12777, 47487, 17566, 12729, 14072, 11387, 24025, 10468, 14598, 22255, 27869, 3275, 22513, 32447, 44666, 3537, 45728, 41313, 31607, 5386, 60608, 15960, 49632, 40669, 57448, 673}, objArr84);
            Class<?> cls10 = Class.forName((String) objArr84[0]);
            Object[] objArr85 = new Object[1];
            a(new char[]{46518, 47971, 10370, 8454}, TextUtils.getCapsMode("", 0, 0), new char[]{29502, 17003, 45716, 7110}, (char) (View.resolveSizeAndState(0, 0, 0) + 50866), new char[]{47128, 988, 26405, 17350, 6102, 30177, 31899, 8390, 31328, 22464, 45883, 34843, 9202, 9983, 51879, 53016, 8100, 40206}, objArr85);
            Context applicationContext4 = (Context) cls10.getMethod((String) objArr85[0], new Class[0]).invoke(null, null);
            if (applicationContext4 != null) {
                int i130 = artificialFrame + 115;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i130 % 128;
                int i131 = i130 % 2;
                applicationContext4 = ((applicationContext4 instanceof ContextWrapper) && ((ContextWrapper) applicationContext4).getBaseContext() == null) ? null : applicationContext4.getApplicationContext();
            }
            Object[] objArr86 = {applicationContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -1103904743};
            byte[] bArr32 = $$d;
            Object[] objArr87 = new Object[1];
            c((byte) 89, bArr32[4], (short) 346, objArr87);
            Class<?> cls11 = Class.forName((String) objArr87[0]);
            Object[] objArr88 = new Object[1];
            c(bArr32[383], bArr32[387], (short) ($$e - 3), objArr88);
            objArr5 = (Object[]) cls11.getMethod((String) objArr88[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr86);
            Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame30 == null) {
                int i132 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 16;
                char cGreen = (char) Color.green(0);
                int packedPositionType = 747 - ExpandableListView.getPackedPositionType(0L);
                byte[] bArr33 = $$a;
                byte b39 = (byte) (-bArr33[11]);
                byte b40 = bArr33[71];
                Object[] objArr89 = new Object[1];
                b(b39, (byte) (b40 - 1), b40, objArr89);
                objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(i132, cGreen, packedPositionType, -1031537386, false, (String) objArr89[0], null);
            }
            ((Field) objAccessartificialFrame30).set(null, objArr5);
            try {
                Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame31 == null) {
                    int iIndexOf8 = TextUtils.indexOf("", "") + 17;
                    char cAxisFromString = (char) (MotionEvent.axisFromString("") + 1);
                    int iIndexOf9 = TextUtils.indexOf("", "", 0) + 747;
                    byte[] bArr34 = $$a;
                    byte b41 = bArr34[5];
                    Object[] objArr90 = new Object[1];
                    b(b41, (byte) (b41 + 1), bArr34[71], objArr90);
                    objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(iIndexOf8, cAxisFromString, iIndexOf9, -144068856, false, (String) objArr90[0], null);
                }
                ((Field) objAccessartificialFrame31).set(null, lValueOf7);
            } catch (Exception unused6) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame32 == null) {
                int maxKeyCode2 = 17 - (KeyEvent.getMaxKeyCode() >> 16);
                char cBlue = (char) Color.blue(0);
                int mode = 747 - View.MeasureSpec.getMode(0);
                byte[] bArr35 = $$a;
                byte b42 = (byte) (-bArr35[11]);
                byte b43 = bArr35[71];
                Object[] objArr91 = new Object[1];
                b(b42, (byte) (b43 - 1), b43, objArr91);
                objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(maxKeyCode2, cBlue, mode, -1031537386, false, (String) objArr91[0], null);
            }
            Object[] objArr92 = (Object[]) ((Field) objAccessartificialFrame32).get(null);
            objArr5 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
            int i133 = ((int[]) objArr92[3])[0];
            int i134 = ((int[]) objArr92[4])[0];
            List list = (List) objArr92[0];
            List list2 = (List) objArr92[2];
            int elapsedCpuTime = (int) Process.getElapsedCpuTime();
            int i135 = ~elapsedCpuTime;
            int i136 = (((902788353 + ((((~((-155164892) | i135)) | 135692298) | (~((-450283567) | i135))) * (-1136))) + ((((~((-155164892) | elapsedCpuTime)) | (~((-450283567) | elapsedCpuTime))) | (~(469756159 | i135))) * (-568))) + (((~(elapsedCpuTime | (-135692299))) | ((~(i135 | 450283566)) | (~(155164891 | i135)))) * 568)) - 1103904743;
            int i137 = (i136 << 13) ^ i136;
            int i138 = i137 ^ (i137 >>> 17);
            ((int[]) objArr5[1])[0] = i138 ^ (i138 << 5);
        }
        int i139 = ((int[]) objArr5[4])[0];
        int i140 = ((int[]) objArr5[3])[0];
        if (i140 == i139) {
            Object[] objArr93 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i141 = ((int[]) objArr5[1])[0];
            int i142 = ((int[]) objArr5[3])[0];
            int i143 = ((int[]) objArr5[4])[0];
            List list3 = (List) objArr5[0];
            List list4 = (List) objArr5[2];
            int iIdentityHashCode11 = System.identityHashCode(this);
            int i144 = ~iIdentityHashCode11;
            int i145 = i141 + 887435209 + ((23463077 | i144) * (-192)) + (((~(23577773 | i144)) | 605563154) * (-384)) + (((~(iIdentityHashCode11 | (-114697))) | (~(i144 | 629140927)) | (~((-605563155) | iIdentityHashCode11))) * JfifUtil.MARKER_SOFn);
            int i146 = (i145 << 13) ^ i145;
            int i147 = i146 ^ (i146 >>> 17);
            ((int[]) objArr93[1])[0] = i147 ^ (i147 << 5);
        } else {
            ArrayList arrayList4 = new ArrayList();
            Object[] objArr94 = {objArr5};
            Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(1804664566);
            if (objAccessartificialFrame33 == null) {
                objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getTouchSlop() >> 8) + 41, (char) (12468 - View.MeasureSpec.getMode(0)), 3642 - View.getDefaultSize(0, 0), -185222914, false, "coroutineCreation", new Class[]{Object[].class});
            }
            arrayList4.add(((Method) objAccessartificialFrame33).invoke(null, objArr94));
            Object[] objArr95 = {objArr5};
            Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(-1243809191);
            if (objAccessartificialFrame34 == null) {
                objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(Color.red(0) + 41, (char) (12468 - (ViewConfiguration.getDoubleTapTimeout() >> 16)), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 3642, 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
            }
            arrayList4.add(((Method) objAccessartificialFrame34).invoke(null, objArr95));
            Object[] objArr96 = {Long.valueOf((((long) 1595697352) << 32) ^ ((long) (i139 ^ i140))), Long.valueOf(1595697344)};
            byte[] bArr36 = $$d;
            Object[] objArr97 = new Object[1];
            c(bArr36[238], bArr36[4], (short) 437, objArr97);
            Class<?> cls12 = Class.forName((String) objArr97[0]);
            Object[] objArr98 = new Object[1];
            c(bArr36[14], bArr36[538], bArr36[210], objArr98);
            cls12.getMethod((String) objArr98[0], Long.TYPE, Long.TYPE).invoke(null, objArr96);
            Object[] objArr99 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i148 = ((int[]) objArr5[1])[0];
            int i149 = ((int[]) objArr5[3])[0];
            int i150 = ((int[]) objArr5[4])[0];
            List list5 = (List) objArr5[0];
            List list6 = (List) objArr5[2];
            int i151 = ~(((int) Process.getStartElapsedRealtime()) | 210004886);
            int i152 = i148 + (((134480516 | i151) * (-196)) - 724048815) + ((i151 | 75524370) * 196);
            int i153 = (i152 << 13) ^ i152;
            int i154 = i153 ^ (i153 >>> 17);
            ((int[]) objArr99[1])[0] = i154 ^ (i154 << 5);
        }
        boolean zOnCreate = super.onCreate();
        Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame35 == null) {
            int edgeSlop = (ViewConfiguration.getEdgeSlop() >> 16) + 30;
            char deadChar = (char) (49362 - KeyEvent.getDeadChar(0, 0));
            int iIndexOf10 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 685;
            byte[] bArr37 = $$a;
            Object[] objArr100 = new Object[1];
            b((byte) 76, bArr37[42], bArr37[4], objArr100);
            objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(edgeSlop, deadChar, iIndexOf10, -1583976536, false, (String) objArr100[0], null);
        }
        long j7 = ((Field) objAccessartificialFrame35).getLong(null);
        if (j7 != -1) {
            int i155 = getARTIFICIAL_FRAME_PACKAGE_NAME + 3;
            artificialFrame = i155 % 128;
            if (i155 % 2 != 0 ? j7 + 1898 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue() : (j7 | 1898) < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[1])).longValue()) {
                Object[] objArr101 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -1831734345};
                byte[] bArr38 = $$d;
                Object[] objArr102 = new Object[1];
                c(bArr38[226], bArr38[4], (short) 496, objArr102);
                Class<?> cls13 = Class.forName((String) objArr102[0]);
                byte b44 = bArr38[433];
                byte b45 = bArr38[61];
                Object[] objArr103 = new Object[1];
                c(b44, b45, (short) (b45 | Ascii.NAK), objArr103);
                objArr6 = (Object[]) cls13.getMethod((String) objArr103[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr101);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame5 == null) {
                    int doubleTapTimeout = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 30;
                    char cResolveSizeAndState = (char) (View.resolveSizeAndState(0, 0, 0) + 49362);
                    int defaultSize = View.getDefaultSize(0, 0) + 684;
                    byte[] bArr39 = $$a;
                    Object[] objArr104 = new Object[1];
                    b((byte) 88, (byte) (-bArr39[11]), bArr39[71], objArr104);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout, cResolveSizeAndState, defaultSize, -1456483158, false, (String) objArr104[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr6);
                try {
                    Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(1056123296);
                    if (objAccessartificialFrame6 == null) {
                        int iMyPid = (Process.myPid() >> 22) + 30;
                        char absoluteGravity = (char) (49362 - Gravity.getAbsoluteGravity(0, 0));
                        int iMakeMeasureSpec = 684 - View.MeasureSpec.makeMeasureSpec(0, 0);
                        byte[] bArr40 = $$a;
                        Object[] objArr105 = new Object[1];
                        b((byte) 76, bArr40[42], bArr40[4], objArr105);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iMyPid, absoluteGravity, iMakeMeasureSpec, -1583976536, false, (String) objArr105[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf8);
                } catch (Exception unused7) {
                    throw new RuntimeException();
                }
            } else {
                Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame36 == null) {
                    int touchSlop = 30 - (ViewConfiguration.getTouchSlop() >> 8);
                    char cIndexOf3 = (char) (49361 - TextUtils.indexOf((CharSequence) "", '0', 0));
                    int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 684;
                    byte[] bArr41 = $$a;
                    Object[] objArr106 = new Object[1];
                    b((byte) 88, (byte) (-bArr41[11]), bArr41[71], objArr106);
                    objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(touchSlop, cIndexOf3, keyRepeatDelay, -1456483158, false, (String) objArr106[0], null);
                }
                Object[] objArr107 = (Object[]) ((Field) objAccessartificialFrame36).get(null);
                objArr6 = new Object[]{new int[]{((int[]) objArr107[0])[0]}, new int[]{((int[]) objArr107[1])[0]}, new int[1], (String) objArr107[3]};
                int iMyTid2 = Process.myTid();
                int i156 = (((-205232482) + (((~((-641932103) | iMyTid2)) | 336691672) * (-366))) + (((~(iMyTid2 | (-574757383))) | 269516952) * 366)) - 1831734345;
                int i157 = (i156 << 13) ^ i156;
                int i158 = i157 ^ (i157 >>> 17);
                ((int[]) objArr6[2])[0] = i158 ^ (i158 << 5);
            }
        } else {
            Object[] objArr108 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -1831734345};
            byte[] bArr310 = $$d;
            Object[] objArr109 = new Object[1];
            c(bArr310[226], bArr310[4], (short) 496, objArr109);
            Class<?> cls14 = Class.forName((String) objArr109[0]);
            byte b46 = bArr310[433];
            byte b47 = bArr310[61];
            Object[] objArr1010 = new Object[1];
            c(b46, b47, (short) (b47 | Ascii.NAK), objArr1010);
            objArr6 = (Object[]) cls14.getMethod((String) objArr1010[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr108);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame5 == null) {
                int doubleTapTimeout2 = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 30;
                char cResolveSizeAndState2 = (char) (View.resolveSizeAndState(0, 0, 0) + 49362);
                int defaultSize2 = View.getDefaultSize(0, 0) + 684;
                byte[] bArr311 = $$a;
                Object[] objArr1011 = new Object[1];
                b((byte) 88, (byte) (-bArr311[11]), bArr311[71], objArr1011);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout2, cResolveSizeAndState2, defaultSize2, -1456483158, false, (String) objArr1011[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr6);
            Long lValueOf9 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(1056123296);
            if (objAccessartificialFrame6 == null) {
                int iMyPid2 = (Process.myPid() >> 22) + 30;
                char absoluteGravity2 = (char) (49362 - Gravity.getAbsoluteGravity(0, 0));
                int iMakeMeasureSpec2 = 684 - View.MeasureSpec.makeMeasureSpec(0, 0);
                byte[] bArr42 = $$a;
                Object[] objArr1012 = new Object[1];
                b((byte) 76, bArr42[42], bArr42[4], objArr1012);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iMyPid2, absoluteGravity2, iMakeMeasureSpec2, -1583976536, false, (String) objArr1012[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf9);
        }
        int i159 = ((int[]) objArr6[1])[0];
        int i160 = ((int[]) objArr6[0])[0];
        if (i160 == i159) {
            int i161 = ((int[]) objArr6[2])[0];
            Object[] objArr110 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
            int iUptimeMillis = (int) SystemClock.uptimeMillis();
            int i162 = ~iUptimeMillis;
            int i163 = i161 + 1539884528 + (((~((-186545857) | i162)) | (~((-792077919) | iUptimeMillis))) * JfifUtil.MARKER_EOI) + (((~(iUptimeMillis | (-186545857))) | 186000960) * JfifUtil.MARKER_EOI) + (((~((-792077919) | i162)) | 186545856) * JfifUtil.MARKER_EOI);
            int i164 = (i163 << 13) ^ i163;
            int i165 = i164 ^ (i164 >>> 17);
            ((int[]) objArr110[2])[0] = i165 ^ (i165 << 5);
        } else {
            new ArrayList().add((String) objArr6[3]);
            long j8 = ((long) (i159 ^ i160)) ^ (((long) 1994385906) << 32);
            long j9 = 1994385890;
            int i166 = getARTIFICIAL_FRAME_PACKAGE_NAME + 47;
            artificialFrame = i166 % 128;
            int i167 = i166 % 2;
            Object[] objArr111 = {Long.valueOf(j8), Long.valueOf(j9)};
            byte[] bArr43 = $$d;
            byte b48 = bArr43[81];
            byte b49 = bArr43[4];
            Object[] objArr112 = new Object[1];
            c(b48, b49, (short) (b49 | 225), objArr112);
            Class<?> cls15 = Class.forName((String) objArr112[0]);
            Object[] objArr113 = new Object[1];
            c(bArr43[14], bArr43[538], bArr43[210], objArr113);
            cls15.getMethod((String) objArr113[0], Long.TYPE, Long.TYPE).invoke(null, objArr111);
            int i168 = ((int[]) objArr6[2])[0];
            Object[] objArr114 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
            int iIdentityHashCode12 = System.identityHashCode(this);
            int i169 = i168 + (-1639129168) + (((~((-147392183) | iIdentityHashCode12)) | 8980000) * 345) + (((~((-147392183) | (~iIdentityHashCode12))) | 822251592) * 345) + ((~(iIdentityHashCode12 | (-8980001))) * 345);
            int i170 = (i169 << 13) ^ i169;
            int i171 = i170 ^ (i170 >>> 17);
            ((int[]) objArr114[2])[0] = i171 ^ (i171 << 5);
        }
        Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame37 == null) {
            int iBlue = Color.blue(0) + 30;
            char cIndexOf4 = (char) (TextUtils.indexOf("", "", 0) + 49362);
            int tapTimeout2 = 684 - (ViewConfiguration.getTapTimeout() >> 16);
            byte b50 = (byte) ($$b << 1);
            byte[] bArr44 = $$a;
            Object[] objArr115 = new Object[1];
            b(b50, bArr44[41], bArr44[4], objArr115);
            objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(iBlue, cIndexOf4, tapTimeout2, 508509282, false, (String) objArr115[0], null);
        }
        long j10 = ((Field) objAccessartificialFrame37).getLong(null);
        if (j10 != -1) {
            int i172 = artificialFrame + 51;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i172 % 128;
            int i173 = i172 % 2;
            if (j10 + 1856 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i174 = artificialFrame + 125;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i174 % 128;
                int i175 = i174 % 2;
                Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame38 == null) {
                    int iRed = Color.red(0) + 30;
                    char tapTimeout3 = (char) ((ViewConfiguration.getTapTimeout() >> 16) + 49362);
                    int touchSlop2 = (ViewConfiguration.getTouchSlop() >> 8) + 684;
                    byte b51 = (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR;
                    byte[] bArr45 = $$a;
                    Object[] objArr116 = new Object[1];
                    b(b51, bArr45[63], (byte) (bArr45[71] - 1), objArr116);
                    objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(iRed, tapTimeout3, touchSlop2, -1321816393, false, (String) objArr116[0], null);
                }
                Object[] objArr117 = (Object[]) ((Field) objAccessartificialFrame38).get(null);
                objArr8 = new Object[]{new int[]{((int[]) objArr117[0])[0]}, new int[]{((int[]) objArr117[1])[0]}, new int[1], (String) objArr117[3]};
                int i176 = ~(System.identityHashCode(this) | 521456131);
                int i177 = (((-539577138) + (((-457167644) | i176) * (-220))) + ((i176 | (-524278556)) * 220)) - 903051788;
                int i178 = (i177 << 13) ^ i177;
                int i179 = i178 ^ (i178 >>> 17);
                ((int[]) objArr8[2])[0] = i179 ^ (i179 << 5);
            } else {
                Object[] objArr118 = new Object[1];
                a(new char[]{46518, 47971, 10370, 8454}, View.MeasureSpec.makeMeasureSpec(0, 0), new char[]{32026, 11577, 60216, 38564}, (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 42218), new char[]{12777, 47487, 17566, 12729, 14072, 11387, 24025, 10468, 14598, 22255, 27869, 3275, 22513, 32447, 44666, 3537, 45728, 41313, 31607, 5386, 60608, 15960, 49632, 40669, 57448, 673}, objArr118);
                Class<?> cls16 = Class.forName((String) objArr118[0]);
                Object[] objArr119 = new Object[1];
                a(new char[]{46518, 47971, 10370, 8454}, TextUtils.getOffsetAfter("", 0), new char[]{29502, 17003, 45716, 7110}, (char) (50866 - Drawable.resolveOpacity(0, 0)), new char[]{47128, 988, 26405, 17350, 6102, 30177, 31899, 8390, 31328, 22464, 45883, 34843, 9202, 9983, 51879, 53016, 8100, 40206}, objArr119);
                applicationContext = (Context) cls16.getMethod((String) objArr119[0], new Class[0]).invoke(null, null);
                if (applicationContext != null) {
                    if ((applicationContext instanceof ContextWrapper) || ((ContextWrapper) applicationContext).getBaseContext() != null) {
                        applicationContext = applicationContext.getApplicationContext();
                    } else {
                        applicationContext = null;
                    }
                }
                int iIntValue3 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                int i180 = getARTIFICIAL_FRAME_PACKAGE_NAME + 31;
                artificialFrame = i180 % 128;
                int i181 = i180 % 2;
                Object[] objArr120 = {applicationContext, Integer.valueOf(iIntValue3), -5784156};
                byte[] bArr46 = $$d;
                Object[] objArr121 = new Object[1];
                c((byte) (-bArr46[301]), bArr46[4], (short) 548, objArr121);
                Class<?> cls17 = Class.forName((String) objArr121[0]);
                Object[] objArr122 = new Object[1];
                c(bArr46[79], bArr46[84], (short) (bArr46[0] - 1), objArr122);
                objArr7 = (Object[]) cls17.getMethod((String) objArr122[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr120);
                if (applicationContext != null) {
                    objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(777251007);
                    if (objAccessartificialFrame7 == null) {
                        int doubleTapTimeout3 = 30 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                        char cIndexOf5 = (char) (49361 - TextUtils.indexOf((CharSequence) "", '0', 0));
                        int maximumDrawingCacheSize = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 684;
                        byte b52 = (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR;
                        byte[] bArr47 = $$a;
                        Object[] objArr123 = new Object[1];
                        b(b52, bArr47[63], (byte) (bArr47[71] - 1), objArr123);
                        objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout3, cIndexOf5, maximumDrawingCacheSize, -1321816393, false, (String) objArr123[0], null);
                    }
                    ((Field) objAccessartificialFrame7).set(null, objArr7);
                    try {
                        Long lValueOf10 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                        if (objAccessartificialFrame8 == null) {
                            int doubleTapTimeout4 = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 30;
                            char cIndexOf6 = (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 49363);
                            int i182 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 683;
                            byte b53 = (byte) ($$b << 1);
                            byte[] bArr48 = $$a;
                            Object[] objArr124 = new Object[1];
                            b(b53, bArr48[41], bArr48[4], objArr124);
                            objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout4, cIndexOf6, i182, 508509282, false, (String) objArr124[0], null);
                        }
                        ((Field) objAccessartificialFrame8).set(null, lValueOf10);
                    } catch (Exception unused8) {
                        throw new RuntimeException();
                    }
                }
                objArr8 = objArr7;
            }
        } else {
            Object[] objArr1110 = new Object[1];
            a(new char[]{46518, 47971, 10370, 8454}, View.MeasureSpec.makeMeasureSpec(0, 0), new char[]{32026, 11577, 60216, 38564}, (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 42218), new char[]{12777, 47487, 17566, 12729, 14072, 11387, 24025, 10468, 14598, 22255, 27869, 3275, 22513, 32447, 44666, 3537, 45728, 41313, 31607, 5386, 60608, 15960, 49632, 40669, 57448, 673}, objArr1110);
            Class<?> cls18 = Class.forName((String) objArr1110[0]);
            Object[] objArr1111 = new Object[1];
            a(new char[]{46518, 47971, 10370, 8454}, TextUtils.getOffsetAfter("", 0), new char[]{29502, 17003, 45716, 7110}, (char) (50866 - Drawable.resolveOpacity(0, 0)), new char[]{47128, 988, 26405, 17350, 6102, 30177, 31899, 8390, 31328, 22464, 45883, 34843, 9202, 9983, 51879, 53016, 8100, 40206}, objArr1111);
            applicationContext = (Context) cls18.getMethod((String) objArr1111[0], new Class[0]).invoke(null, null);
            if (applicationContext != null) {
                if (applicationContext instanceof ContextWrapper) {
                    applicationContext = applicationContext.getApplicationContext();
                } else {
                    applicationContext = applicationContext.getApplicationContext();
                }
            }
            int iIntValue4 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            int i183 = getARTIFICIAL_FRAME_PACKAGE_NAME + 31;
            artificialFrame = i183 % 128;
            int i184 = i183 % 2;
            Object[] objArr125 = {applicationContext, Integer.valueOf(iIntValue4), -5784156};
            byte[] bArr49 = $$d;
            Object[] objArr126 = new Object[1];
            c((byte) (-bArr49[301]), bArr49[4], (short) 548, objArr126);
            Class<?> cls19 = Class.forName((String) objArr126[0]);
            Object[] objArr127 = new Object[1];
            c(bArr49[79], bArr49[84], (short) (bArr49[0] - 1), objArr127);
            objArr7 = (Object[]) cls19.getMethod((String) objArr127[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr125);
            if (applicationContext != null) {
                objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame7 == null) {
                    int doubleTapTimeout5 = 30 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                    char cIndexOf7 = (char) (49361 - TextUtils.indexOf((CharSequence) "", '0', 0));
                    int maximumDrawingCacheSize2 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 684;
                    byte b54 = (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR;
                    byte[] bArr410 = $$a;
                    Object[] objArr128 = new Object[1];
                    b(b54, bArr410[63], (byte) (bArr410[71] - 1), objArr128);
                    objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout5, cIndexOf7, maximumDrawingCacheSize2, -1321816393, false, (String) objArr128[0], null);
                }
                ((Field) objAccessartificialFrame7).set(null, objArr7);
                Long lValueOf11 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                if (objAccessartificialFrame8 == null) {
                    int doubleTapTimeout6 = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 30;
                    char cIndexOf8 = (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 49363);
                    int i185 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 683;
                    byte b55 = (byte) ($$b << 1);
                    byte[] bArr411 = $$a;
                    Object[] objArr129 = new Object[1];
                    b(b55, bArr411[41], bArr411[4], objArr129);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout6, cIndexOf8, i185, 508509282, false, (String) objArr129[0], null);
                }
                ((Field) objAccessartificialFrame8).set(null, lValueOf11);
            }
            objArr8 = objArr7;
        }
        int i186 = ((int[]) objArr8[1])[0];
        int i187 = ((int[]) objArr8[0])[0];
        if (i187 == i186) {
            int i188 = ((int[]) objArr8[2])[0];
            Object[] objArr130 = {new int[]{((int[]) objArr8[0])[0]}, new int[]{((int[]) objArr8[1])[0]}, new int[1], (String) objArr8[3]};
            int iNextInt2 = new Random().nextInt();
            int i189 = i188 + ((((-1213104510) + (((~iNextInt2) | (-967528961)) * 1444)) + (((~(iNextInt2 | 410363791)) | ((~(568259983 | iNextInt2)) | (-973076368))) * (-1444))) - 1523760128);
            int i190 = (i189 << 13) ^ i189;
            int i191 = i190 ^ (i190 >>> 17);
            ((int[]) objArr130[2])[0] = i191 ^ (i191 << 5);
        } else {
            Object[] objArr131 = {Long.valueOf((((long) 634729687) << 32) ^ ((long) (i186 ^ i187))), Long.valueOf(634730199)};
            byte[] bArr50 = $$d;
            byte b56 = bArr50[81];
            byte b57 = bArr50[4];
            Object[] objArr132 = new Object[1];
            c(b56, b57, (short) (b57 | 225), objArr132);
            Class<?> cls20 = Class.forName((String) objArr132[0]);
            Object[] objArr133 = new Object[1];
            c(bArr50[14], bArr50[538], bArr50[210], objArr133);
            cls20.getMethod((String) objArr133[0], Long.TYPE, Long.TYPE).invoke(null, objArr131);
            int i192 = ((int[]) objArr8[2])[0];
            Object[] objArr134 = {new int[]{((int[]) objArr8[0])[0]}, new int[]{((int[]) objArr8[1])[0]}, new int[1], (String) objArr8[3]};
            int iNextInt3 = new Random().nextInt();
            int i193 = ~iNextInt3;
            int i194 = i192 + ((((-2002800006) + (((~((-674675676) | i193)) | (~((-303948100) | iNextInt3))) * (-370))) + ((((~(iNextInt3 | (-674675676))) | (~(i193 | (-303948100)))) | (-977271772)) * (-370))) - 813302776);
            int i195 = (i194 << 13) ^ i194;
            int i196 = i195 ^ (i195 >>> 17);
            ((int[]) objArr134[2])[0] = i196 ^ (i196 << 5);
        }
        return zOnCreate;
    }

    static {
        byte[] bArr = new byte[621];
        System.arraycopy("T³?î\u0006ÇDÿ\u0005¼?\u0004ùü\u0000\u0003\tÄ6\r\u0004ôÊFþúÆ\u00167ë\nþûà4ò\u0001\u0000\u000eã\u001fð\u0003\tû\u000e\u0001>\u0007À<\u0006\tð\u000e\u0003î\u0013óÊA\u0002\u0006öþ\u0000\u0001Ê!\"\u0006öþ\u0000\u0001î\u0014ý\u0003\u0012â ö\u0004\b²\u000f\u0003\u0001\u0003\u000f\u0001ï\u0012\u0003öþ\u0004û\u0007ù\fÛ-ð\rù\rÿÂ:\t\u0001ù\u0006úÊ@\u0000\u0000ÿ\f»6\rÿ\u0001\u0003\u0000ÁFò\bÿ\u0006\u0007ò\u000eýô\fÃM\u0001ø\rÿÂ:\t\u0001ù\u0006úÊ4\u000e÷\u000fþûüË:\u0007\u0007¼<\u0006\u0007ò\u000eýô\fÃ@ùý\u0013\u0003þô\tù\n\u0007»M\u0001íý-\u0004þ\u0007\u0000ö\u0006øà\"þ\u0014ó\u0001\u0003\u0006úå*\rÿÂ:\t\u0001ù\u0006úÊ4\u0010úÆ$%û\u0006îð#þ\u0006ü\rÿÂ9ü\u0003\u0003þ\u000e\u0001ýÄ4\u0010\u0001ýþ\u0006þ\t¼\u00140\u0001Ý\u001e\u0006þÚ\u001e\u0014îÄ\u000e\rÿÂ:\t\u0001ù\u0006úÊ4\u000e÷\u000fþûüË@õ\u0014ò\u000eøù\fÃ6\rþ\u0004\u0004½H\u0000ö\u0004þ\föý\u000f¼\u00176öô\rýûá-þ\u0004\u0004³\u0001\"4ýò\u000eýô\fè'ö\u0007õþ\u0010öûê\u0016\rö\u0003þÐ\rÿÂFï\fú\u000fô\n\u0004ò\u0003Ê@õ\u0012úû\u0010ö\u0006úý\n\u0004\u0007ðËFô\b÷\u0011ò\bÄ&ô\b÷\u0011\u0012\bº -ÿ\u0004ò\u000eü\u0007\u0000·K\u0002\u0006öþ\u0014Ñ&ü\föù\fþ\u0012è\u0014ö\u0007\u0000æ\"î\u0014\u0002ÿÚ\u001e\u000b\u0002ò\nø\u000e³\u000e\rÿÂGÿð\u000e\u0006÷\u000b\u0002ü\u0004\u0002ýø\u000f»?\u0004õÿ\u0014ö\u0007\u0000\u0000õ\u000eô\u0007ÿ\u000e½?\u0004ù\u0001ÿ\u000e½'\u0000\u0001ÿü\u001e\fòÝ0\u0001ö\n÷\u0002\u000e³@\rÿÂFï\fú\u000fô\n\u0004ò\u0003Ê@õ\u0012úû\u0010ö\u0006úý\n\u0004\u0007ðË4\fö\u0012ü\u0007¼4ÄEÿ\u0010Ñ\"\u0002ü\u0015ø\tÖ%\u0004ý\rÿÂEôý\u0003\u0012ûô\u0014ö\u000eðÿ\rÿ\u0001\túü\f\u0006¶Aø\u0010ö\u0006ù\nÀ\u0014-õ\u001aö\u0000Ù$\nôà\"\u0012ôû\u0003ß-\u0000\u0001øÿ\u0012ö\u000eô\f\u0006Ø þ\u0001ú\u000e¼\u001dù".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 621);
        $$d = bArr;
        $$e = 191;
        $$a = new byte[]{6, 70, -89, 92, 5, -1, -33, 33, -2, -9, 5, -7, 5, -1, -50, 39, Ascii.VT, -7, -12, Ascii.SI, -9, Ascii.DC2, -34, Ascii.EM, 4, -17, 19, -15, -1, -18, Ascii.SI, 19, -11, 5, -7, -2, Ascii.SI, -36, Ascii.NAK, Ascii.CR, -15, 2, 9, 6, -34, Ascii.SI, 19, -11, 5, -7, 49, 2, -11, -3, 3, -6, 6, -8, Ascii.VT, -25, 33, -19, 2, 8, -37, 44, -17, Ascii.FF, -8, Ascii.SO, Ascii.ESC, 1, -7, -6, -33, 51, -12, 3, -8, 1, Ascii.CR, -2, Ascii.SI, -33, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, 10, -31, Ascii.DC4, Ascii.CR, -8, -11, -13, Ascii.ESC, -9, Ascii.DC2, -36, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, -7, Ascii.DC2, -43, Ascii.GS, -4, 17, 2};
        $$b = 48;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        coroutineBoundary = -3277264899607979782L;
        accessartificialFrame = -1151259316;
        CoroutineDebuggingKt = (char) 11596;
    }
}
