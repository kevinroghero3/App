package com.reactnative.ivpusic.imagepicker;

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
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.FileProvider;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import com.google.common.collect.CompactHashMap;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.ArtificialStackFrames;
import o.onPostMessage;
import okio.Utf8;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes6.dex */
public class IvpusicImagePickerFileProvider extends FileProvider {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    private static char[] IPostMessageService;
    private static int artificialFrame;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static final byte[] $$c = {84, -77, Utf8.REPLACEMENT_BYTE, -18};
    private static final int $$f = 79;
    private static int $10 = 0;
    private static int $11 = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0027). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(byte r5, short r6, byte r7) {
        /*
            int r7 = r7 * 3
            int r7 = r7 + 65
            int r5 = r5 * 2
            int r0 = r5 + 1
            int r6 = r6 * 4
            int r6 = 4 - r6
            byte[] r1 = com.reactnative.ivpusic.imagepicker.IvpusicImagePickerFileProvider.$$c
            byte[] r0 = new byte[r0]
            r2 = 0
            if (r1 != 0) goto L17
            r3 = r5
            r7 = r6
            r4 = r2
            goto L27
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r7
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r5) goto L25
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            return r5
        L25:
            r3 = r1[r6]
        L27:
            int r6 = r6 + 1
            int r7 = r7 + r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnative.ivpusic.imagepicker.IvpusicImagePickerFileProvider.$$g(byte, short, byte):java.lang.String");
    }

    private static void b(int i, short s, int i2, Object[] objArr) {
        int i3 = 104 - s;
        byte[] bArr = $$a;
        int i4 = i2 + 65;
        byte[] bArr2 = new byte[i + 8];
        int i5 = i + 7;
        int i6 = -1;
        if (bArr == null) {
            i6 = -1;
            i4 = i3 + i4;
            i3 = i3;
        }
        while (true) {
            int i7 = i6 + 1;
            bArr2[i7] = (byte) i4;
            int i8 = i3 + 1;
            if (i7 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            } else {
                i6 = i7;
                i4 = bArr[i8] + i4;
                i3 = i8;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    /* JADX WARN: Code duplicated, block: B:8:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void c(byte r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = 617 - r7
            byte[] r0 = com.reactnative.ivpusic.imagepicker.IvpusicImagePickerFileProvider.$$d
            int r1 = 87 - r6
            int r8 = r8 + 36
            byte[] r1 = new byte[r1]
            int r6 = 86 - r6
            r2 = 0
            if (r0 != 0) goto L13
            r3 = r6
            r8 = r7
            r4 = r2
            goto L2c
        L13:
            r3 = r2
        L14:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L21
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L21:
            int r3 = r3 + 1
            int r7 = r7 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r5
        L2c:
            int r7 = -r7
            int r3 = r3 + r7
            int r7 = r3 + (-4)
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnative.ivpusic.imagepicker.IvpusicImagePickerFileProvider.c(byte, int, short, java.lang.Object[]):void");
    }

    private static void a(byte[] bArr, int[] iArr, boolean z, Object[] objArr) throws Throwable {
        int i;
        int i2 = 2 % 2;
        onPostMessage onpostmessage = new onPostMessage();
        int i3 = 0;
        int i4 = iArr[0];
        int i5 = 1;
        int i6 = iArr[1];
        int i7 = iArr[2];
        int i8 = iArr[3];
        char[] cArr = IPostMessageService;
        if (cArr != null) {
            int length = cArr.length;
            char[] cArr2 = new char[length];
            int i9 = 0;
            while (i9 < length) {
                try {
                    Object[] objArr2 = new Object[i5];
                    objArr2[i3] = Integer.valueOf(cArr[i9]);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1782207618);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) i3;
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", "", i3, i3) + 11, (char) Color.argb(i3, i3, i3, i3), 1562 - (ViewConfiguration.getWindowTouchSlop() >> 8), 178318710, false, $$g(b, b2, b2), new Class[]{Integer.TYPE});
                    }
                    cArr2[i9] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i9++;
                    i3 = 0;
                    i5 = 1;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            cArr = cArr2;
        }
        char[] cArr3 = new char[i6];
        System.arraycopy(cArr, i4, cArr3, 0, i6);
        if (bArr != null) {
            int i10 = $10 + 21;
            $11 = i10 % 128;
            int i11 = i10 % 2;
            char[] cArr4 = new char[i6];
            onpostmessage.a = 0;
            char c = 0;
            while (onpostmessage.a < i6) {
                if (bArr[onpostmessage.a] != 1) {
                    int i12 = onpostmessage.a;
                    try {
                        Object[] objArr3 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-314759072);
                        if (objAccessartificialFrame2 == null) {
                            byte b3 = (byte) 0;
                            byte b4 = b3;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(Color.green(0) + 11, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1), 1562 - TextUtils.getTrimmedLength(""), 1918398056, false, $$g(b3, b4, (byte) (b4 | 19)), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        cArr4[i12] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 == null) {
                            throw th2;
                        }
                        throw cause2;
                    }
                } else {
                    int i13 = $10 + 107;
                    $11 = i13 % 128;
                    if (i13 % 2 == 0) {
                        int i14 = onpostmessage.a;
                        Object[] objArr4 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1378437083);
                        if (objAccessartificialFrame3 == null) {
                            byte b5 = (byte) 0;
                            byte b6 = b5;
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(23 - TextUtils.getTrimmedLength(""), (char) Drawable.resolveOpacity(0, 0), TextUtils.indexOf((CharSequence) "", '0', 0) + 2442, -850656813, false, $$g(b5, b6, (byte) (b6 + 1)), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        Object obj = null;
                        cArr4[i14] = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).charValue();
                        obj.hashCode();
                        throw null;
                    }
                    int i15 = onpostmessage.a;
                    Object[] objArr5 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1378437083);
                    if (objAccessartificialFrame4 == null) {
                        byte b7 = (byte) 0;
                        byte b8 = b7;
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(23 - Color.alpha(0), (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 2441, -850656813, false, $$g(b7, b8, (byte) (b8 + 1)), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr4[i15] = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).charValue();
                }
                c = cArr4[onpostmessage.a];
                Object[] objArr6 = {onpostmessage, onpostmessage};
                Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(898481158);
                if (objAccessartificialFrame5 == null) {
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(21 - TextUtils.lastIndexOf("", '0', 0), (char) (MotionEvent.axisFromString("") + 29364), 215 - (ViewConfiguration.getJumpTapTimeout() >> 16), -1427572210, false, "F", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame5).invoke(null, objArr6);
            }
            cArr3 = cArr4;
        }
        if (i8 > 0) {
            char[] cArr5 = new char[i6];
            i = 0;
            System.arraycopy(cArr3, 0, cArr5, 0, i6);
            int i16 = i6 - i8;
            System.arraycopy(cArr5, 0, cArr3, i16, i8);
            System.arraycopy(cArr5, i8, cArr3, 0, i16);
        } else {
            i = 0;
        }
        if (!(!z)) {
            char[] cArr6 = new char[i6];
            while (true) {
                onpostmessage.a = i;
                if (onpostmessage.a >= i6) {
                    break;
                }
                cArr6[onpostmessage.a] = cArr3[(i6 - onpostmessage.a) - 1];
                i = onpostmessage.a + 1;
            }
            cArr3 = cArr6;
        }
        if (i7 > 0) {
            onpostmessage.a = 0;
            while (onpostmessage.a < i6) {
                cArr3[onpostmessage.a] = (char) (cArr3[onpostmessage.a] - iArr[2]);
                onpostmessage.a++;
                int i17 = $10 + 17;
                $11 = i17 % 128;
                int i18 = i17 % 2;
            }
        }
        objArr[0] = new String(cArr3);
    }

    /* JADX WARN: Code duplicated, block: B:200:0x1574  */
    /* JADX WARN: Code duplicated, block: B:203:0x157e  */
    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public boolean onCreate() throws Throwable {
        Object[] objArr;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        Object[] objArr5;
        Context context;
        Object[] objArr6;
        Object[] objArr7;
        int i = 2 % 2;
        Object[] objArr8 = new Object[1];
        a(new byte[]{1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, new int[]{0, 22, 174, 0}, false, objArr8);
        String str = (String) objArr8[0];
        Object[] objArr9 = new Object[1];
        a(new byte[]{1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0}, new int[]{22, 15, 0, 0}, false, objArr9);
        String str2 = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        a(new byte[]{1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1}, new int[]{37, 16, 168, 0}, true, objArr10);
        String str3 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        a(new byte[]{1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1}, new int[]{53, 16, 38, 0}, false, objArr11);
        String str4 = (String) objArr11[0];
        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame == null) {
            int i2 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 36;
            char cIndexOf = (char) TextUtils.indexOf("", "", 0);
            int iMakeMeasureSpec = 540 - View.MeasureSpec.makeMeasureSpec(0, 0);
            byte b = $$a[80];
            Object[] objArr12 = new Object[1];
            b(b, (byte) (b | 100), (byte) 47, objArr12);
            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i2, cIndexOf, iMakeMeasureSpec, 624296913, false, (String) objArr12[0], null);
        }
        long j = ((Field) objAccessartificialFrame).getLong(null);
        if (j == -1 || j + 1987 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            try {
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1717965552);
                if (objAccessartificialFrame2 == null) {
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(20 - Color.green(0), (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 39517), 982 - ExpandableListView.getPackedPositionType(0L), 117222168, false, null, new Class[0]);
                }
                Object[] objArr13 = {null, ((Constructor) objAccessartificialFrame2).newInstance(null), 2080196508, 0};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-501205803);
                if (objAccessartificialFrame3 == null) {
                    int i3 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 35;
                    char scrollBarFadeDuration = (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    int iIndexOf = TextUtils.indexOf("", "", 0) + 540;
                    byte[] bArr = $$a;
                    Object[] objArr14 = new Object[1];
                    b(bArr[55], (byte) ($$b | 17), (byte) (bArr[80] - 1), objArr14);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i3, scrollBarFadeDuration, iIndexOf, 2101703389, false, (String) objArr14[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(53 - TextUtils.lastIndexOf("", '0', 0, 0), (char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 833), 575 - TextUtils.indexOf((CharSequence) "", '0', 0)), (Class) ArtificialStackFrames.coroutineCreation(54 - (ViewConfiguration.getTapTimeout() >> 16), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16), View.MeasureSpec.getMode(0) + 630), Integer.TYPE, Integer.TYPE});
                }
                objArr = (Object[]) ((Method) objAccessartificialFrame3).invoke(null, objArr13);
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                if (objAccessartificialFrame4 == null) {
                    int i4 = 36 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                    char cKeyCodeFromString = (char) KeyEvent.keyCodeFromString("");
                    int iArgb = Color.argb(0, 0, 0, 0) + 540;
                    byte b2 = $$a[80];
                    Object[] objArr15 = new Object[1];
                    b(b2, (byte) (b2 | 92), (byte) 47, objArr15);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i4, cKeyCodeFromString, iArgb, 793268735, false, (String) objArr15[0], null);
                }
                ((Field) objAccessartificialFrame4).set(null, objArr);
                try {
                    Long lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                    if (objAccessartificialFrame5 == null) {
                        int doubleTapTimeout = 36 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                        char defaultSize = (char) View.getDefaultSize(0, 0);
                        int maximumDrawingCacheSize = 540 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                        byte b3 = $$a[80];
                        Object[] objArr16 = new Object[1];
                        b(b3, (byte) (b3 | 100), (byte) 47, objArr16);
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout, defaultSize, maximumDrawingCacheSize, 624296913, false, (String) objArr16[0], null);
                    }
                    ((Field) objAccessartificialFrame5).set(null, lValueOf);
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
            Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame6 == null) {
                int trimmedLength = TextUtils.getTrimmedLength("") + 36;
                char cLastIndexOf = (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1);
                int edgeSlop = 540 - (ViewConfiguration.getEdgeSlop() >> 16);
                byte b4 = $$a[80];
                Object[] objArr17 = new Object[1];
                b(b4, (byte) (b4 | 92), (byte) 47, objArr17);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(trimmedLength, cLastIndexOf, edgeSlop, 793268735, false, (String) objArr17[0], null);
            }
            Object[] objArr18 = (Object[]) ((Field) objAccessartificialFrame6).get(null);
            objArr = new Object[]{new int[1], new int[1], new int[1]};
            int i5 = ((int[]) objArr18[2])[0];
            int i6 = ((int[]) objArr18[1])[0];
            ((int[]) objArr[2])[0] = i5;
            ((int[]) objArr[1])[0] = i6;
            int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
            int i7 = 1692746699 + (((-287317259) | (~iElapsedRealtime)) * (-490)) + (((~(iElapsedRealtime | (-1026072364))) | 738755105) * 490) + 1474786830;
            int i8 = (i7 << 13) ^ i7;
            int i9 = i8 ^ (i8 >>> 17);
            ((int[]) objArr[0])[0] = i9 ^ (i9 << 5);
        }
        Object obj = objArr[1];
        int i10 = ((int[]) obj)[0];
        Object obj2 = objArr[2];
        int i11 = ((int[]) obj2)[0];
        if (i11 == i10) {
            int i12 = getARTIFICIAL_FRAME_PACKAGE_NAME + 91;
            artificialFrame = i12 % 128;
            int i13 = i12 % 2;
            Object[] objArr19 = {new int[1], new int[1], new int[1]};
            int i14 = ((int[]) objArr[0])[0];
            int i15 = ((int[]) obj2)[0];
            int i16 = ((int[]) obj)[0];
            ((int[]) objArr19[2])[0] = i15;
            ((int[]) objArr19[1])[0] = i16;
            int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
            int i17 = ~iFreeMemory;
            int i18 = i14 + (-785747105) + (((~((-470112281) | i17)) | 881509469) * (-602)) + (((~(iFreeMemory | (-470112281))) | 335560728 | (~(1016061021 | i17))) * (-301)) + ((~(i17 | 881509469)) * 301);
            int i19 = (i18 << 13) ^ i18;
            int i20 = i19 ^ (i19 >>> 17);
            ((int[]) objArr19[0])[0] = i20 ^ (i20 << 5);
        } else {
            try {
                Object[] objArr20 = {Long.valueOf((((long) (-1321145489)) << 32) ^ ((long) (i10 ^ i11))), Long.valueOf(-1321141393)};
                byte[] bArr2 = $$d;
                Object[] objArr21 = new Object[1];
                c(bArr2[631], (short) 614, (byte) (-bArr2[306]), objArr21);
                Class<?> cls = Class.forName((String) objArr21[0]);
                Object[] objArr22 = new Object[1];
                c((byte) 84, (short) 590, bArr2[77], objArr22);
                cls.getMethod((String) objArr22[0], Long.TYPE, Long.TYPE).invoke(null, objArr20);
                Object[] objArr23 = {new int[1], new int[1], new int[1]};
                int i21 = ((int[]) objArr[0])[0];
                int i22 = ((int[]) objArr[2])[0];
                int i23 = ((int[]) objArr[1])[0];
                ((int[]) objArr23[2])[0] = i22;
                ((int[]) objArr23[1])[0] = i23;
                int iFreeMemory2 = (int) Runtime.getRuntime().freeMemory();
                int i24 = ~((-35684865) | iFreeMemory2);
                int i25 = ~iFreeMemory2;
                int i26 = i21 + 166018896 + ((i24 | (~((-1212420130) | i25))) * 497) + (((~(iFreeMemory2 | (-1212420130))) | (~((-103516757) | i25)) | 67831892) * 497);
                int i27 = i26 ^ (i26 << 13);
                int i28 = i27 ^ (i27 >>> 17);
                ((int[]) objArr23[0])[0] = i28 ^ (i28 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 != null) {
                    throw cause2;
                }
                throw th2;
            }
        }
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame7 == null) {
            int i29 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 26;
            char modifierMetaStateMask = (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask()));
            int i30 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1041;
            byte b5 = $$a[80];
            Object[] objArr24 = new Object[1];
            b(b5, (byte) (b5 | 100), (byte) 47, objArr24);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(i29, modifierMetaStateMask, i30, 2061780482, false, (String) objArr24[0], null);
        }
        long j2 = ((Field) objAccessartificialFrame7).getLong(null);
        if (j2 == -1 || j2 + 2001 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr25 = {1348721476};
            Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame8 == null) {
                objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf(r12, '0', 0, 0) + 9, (char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 22251), Gravity.getAbsoluteGravity(0, 0) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = CompactHashMap.Itr.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame8).newInstance(objArr25), -1950428349, false);
            Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame9 == null) {
                int packedPositionChild = ExpandableListView.getPackedPositionChild(0L) + 27;
                char cLastIndexOf2 = (char) (TextUtils.lastIndexOf(r12, '0', 0, 0) + 1);
                int iAlpha = Color.alpha(0) + 1041;
                byte b6 = $$a[80];
                Object[] objArr26 = new Object[1];
                b(b6, (byte) (b6 | 92), (byte) 47, objArr26);
                objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(packedPositionChild, cLastIndexOf2, iAlpha, 1145017376, false, (String) objArr26[0], null);
            }
            ((Field) objAccessartificialFrame9).set(null, objArrAccessartificialFrame$78cbbd35);
            try {
                Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame10 == null) {
                    int i31 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 25;
                    char c = (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                    int longPressTimeout = (ViewConfiguration.getLongPressTimeout() >> 16) + 1041;
                    byte b7 = $$a[80];
                    Object[] objArr27 = new Object[1];
                    b(b7, (byte) (b7 | 100), (byte) 47, objArr27);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(i31, c, longPressTimeout, 2061780482, false, (String) objArr27[0], null);
                }
                ((Field) objAccessartificialFrame10).set(null, lValueOf2);
            } catch (Exception unused2) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame11 == null) {
                int iRed = Color.red(0) + 26;
                char c2 = (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                int packedPositionGroup = ExpandableListView.getPackedPositionGroup(0L) + 1041;
                byte b8 = $$a[80];
                Object[] objArr28 = new Object[1];
                b(b8, (byte) (b8 | 92), (byte) 47, objArr28);
                objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(iRed, c2, packedPositionGroup, 1145017376, false, (String) objArr28[0], null);
            }
            Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame11).get(null);
            objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
            int i32 = ((int[]) objArr29[3])[0];
            int i33 = ((int[]) objArr29[2])[0];
            String[] strArr = (String[]) objArr29[0];
            int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
            int i34 = 89976350 + (((~((-907771740) | startElapsedRealtime)) | 101205251 | (~(829667932 | startElapsedRealtime))) * (-880));
            int i35 = (~((-907771740) | (~startElapsedRealtime))) | (-829667933);
            int i36 = ~(startElapsedRealtime | 907771739);
            int i37 = ((i34 + ((i35 | i36) * (-880))) + (i36 * 880)) - 1950428349;
            int i38 = (i37 << 13) ^ i37;
            int i39 = i38 ^ (i38 >>> 17);
            ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i39 ^ (i39 << 5);
        }
        int i40 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i41 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i41 == i40) {
            int i42 = getARTIFICIAL_FRAME_PACKAGE_NAME + 115;
            artificialFrame = i42 % 128;
            int i43 = i42 % 2;
            Object[] objArr30 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i44 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i45 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i46 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iIdentityHashCode = System.identityHashCode(this);
            int i47 = ~iIdentityHashCode;
            int i48 = i44 + (((~(402258857 | i47)) | (~((-2661122) | iIdentityHashCode))) * 988) + 1552306490 + (((~(iIdentityHashCode | 321493929)) | 80764928 | (~(i47 | (-2661122)))) * 988);
            int i49 = (i48 << 13) ^ i48;
            int i50 = i49 ^ (i49 >>> 17);
            ((int[]) objArr30[1])[0] = i50 ^ (i50 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr3 != null) {
                for (String str5 : strArr3) {
                    arrayList.add(str5);
                }
            }
            long j3 = (((long) 1033569124) << 32) ^ ((long) (i40 ^ i41));
            long j4 = 1033569126;
            int i51 = getARTIFICIAL_FRAME_PACKAGE_NAME + 45;
            artificialFrame = i51 % 128;
            int i52 = i51 % 2;
            Object[] objArr31 = {Long.valueOf(j3), Long.valueOf(j4)};
            byte[] bArr3 = $$d;
            Object[] objArr32 = new Object[1];
            c((byte) (bArr3[232] - 1), (short) 588, (byte) (-bArr3[306]), objArr32);
            Class<?> cls2 = Class.forName((String) objArr32[0]);
            Object[] objArr33 = new Object[1];
            c((byte) 84, (short) 590, bArr3[77], objArr33);
            cls2.getMethod((String) objArr33[0], Long.TYPE, Long.TYPE).invoke(null, objArr31);
            Object[] objArr34 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i53 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i54 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i55 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int i56 = ~((int) Runtime.getRuntime().totalMemory());
            int i57 = i53 + ((((-771041146) + (((~((-54708724) | i56)) | (-23395084)) * (-933))) + (((~(i56 | (-23395084))) | 2372104) * 933)) - 1716804972);
            int i58 = i57 ^ (i57 << 13);
            int i59 = i58 ^ (i58 >>> 17);
            ((int[]) objArr34[1])[0] = i59 ^ (i59 << 5);
        }
        Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame12 == null) {
            int absoluteGravity = 30 - Gravity.getAbsoluteGravity(0, 0);
            char packedPositionChild2 = (char) (49361 - ExpandableListView.getPackedPositionChild(0L));
            int doubleTapTimeout2 = 684 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
            byte[] bArr4 = $$a;
            Object[] objArr35 = new Object[1];
            b(bArr4[4], (byte) ($$b - 3), (byte) (bArr4[15] - 1), objArr35);
            objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(absoluteGravity, packedPositionChild2, doubleTapTimeout2, -1583976536, false, (String) objArr35[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame12).getLong(null);
        if (j5 == -1 || j5 + 1887 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            try {
                Object[] objArr36 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -337030006};
                byte[] bArr5 = $$d;
                byte b9 = bArr5[77];
                Object[] objArr37 = new Object[1];
                c(b9, (short) (b9 | 546), (byte) (-bArr5[306]), objArr37);
                Class<?> cls3 = Class.forName((String) objArr37[0]);
                Object[] objArr38 = new Object[1];
                c((byte) (-bArr5[583]), (short) 460, (byte) (-bArr5[306]), objArr38);
                objArr2 = (Object[]) cls3.getMethod((String) objArr38[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr36);
                Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame13 == null) {
                    int i60 = 30 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                    char cAxisFromString = (char) (MotionEvent.axisFromString(r12) + 49363);
                    int bitsPerPixel = 683 - ImageFormat.getBitsPerPixel(0);
                    byte[] bArr6 = $$a;
                    Object[] objArr39 = new Object[1];
                    b(bArr6[80], bArr6[0], (byte) (bArr6[15] + 1), objArr39);
                    objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(i60, cAxisFromString, bitsPerPixel, -1456483158, false, (String) objArr39[0], null);
                }
                ((Field) objAccessartificialFrame13).set(null, objArr2);
                try {
                    Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(1056123296);
                    if (objAccessartificialFrame14 == null) {
                        int iIndexOf2 = 30 - TextUtils.indexOf((CharSequence) r12, (CharSequence) r12, 0);
                        char windowTouchSlop = (char) (49362 - (ViewConfiguration.getWindowTouchSlop() >> 8));
                        int offsetAfter = TextUtils.getOffsetAfter(r12, 0) + 684;
                        byte[] bArr7 = $$a;
                        Object[] objArr40 = new Object[1];
                        b(bArr7[4], (byte) ($$b - 3), (byte) (bArr7[15] - 1), objArr40);
                        objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(iIndexOf2, windowTouchSlop, offsetAfter, -1583976536, false, (String) objArr40[0], null);
                    }
                    ((Field) objAccessartificialFrame14).set(null, lValueOf3);
                } catch (Exception unused3) {
                    throw new RuntimeException();
                }
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 != null) {
                    throw cause3;
                }
                throw th3;
            }
        } else {
            Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame15 == null) {
                int fadingEdgeLength = (ViewConfiguration.getFadingEdgeLength() >> 16) + 30;
                char scrollDefaultDelay = (char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 49362);
                int i61 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 683;
                byte[] bArr8 = $$a;
                Object[] objArr41 = new Object[1];
                b(bArr8[80], bArr8[0], (byte) (bArr8[15] + 1), objArr41);
                objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength, scrollDefaultDelay, i61, -1456483158, false, (String) objArr41[0], null);
            }
            Object[] objArr42 = (Object[]) ((Field) objAccessartificialFrame15).get(null);
            objArr2 = new Object[]{new int[]{((int[]) objArr42[0])[0]}, new int[]{((int[]) objArr42[1])[0]}, new int[1], (String) objArr42[3]};
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i62 = ~iIdentityHashCode2;
            int i63 = ((((-104172642) + ((84504 | i62) * (-192))) + (((~((-766685671) | i62)) | 211853600) * (-384))) + (((~(iIdentityHashCode2 | 766770174)) | ((~(i62 | (-554832071))) | (~((-211853601) | iIdentityHashCode2)))) * JfifUtil.MARKER_SOFn)) - 337030006;
            int i64 = (i63 << 13) ^ i63;
            int i65 = i64 ^ (i64 >>> 17);
            ((int[]) objArr2[2])[0] = i65 ^ (i65 << 5);
        }
        int i66 = ((int[]) objArr2[1])[0];
        int i67 = ((int[]) objArr2[0])[0];
        if (i67 == i66) {
            int i68 = ((int[]) objArr2[2])[0];
            Object[] objArr43 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int iIdentityHashCode3 = System.identityHashCode(this);
            int i69 = i68 + (-488687538) + (((~((-573407540) | iIdentityHashCode3)) | (-976198652)) * (-502)) + ((~((~iIdentityHashCode3) | (-570982417))) * (-502)) + (((~(iIdentityHashCode3 | (-405216236))) | (-573407540)) * TypedValues.PositionType.TYPE_DRAWPATH);
            int i70 = (i69 << 13) ^ i69;
            int i71 = i70 ^ (i70 >>> 17);
            ((int[]) objArr43[2])[0] = i71 ^ (i71 << 5);
        } else {
            new ArrayList().add((String) objArr2[3]);
            long j6 = (((long) (-1558605676)) << 32) ^ ((long) (i66 ^ i67));
            long j7 = -1558605692;
            int i72 = getARTIFICIAL_FRAME_PACKAGE_NAME + 69;
            artificialFrame = i72 % 128;
            int i73 = i72 % 2;
            Object[] objArr44 = {Long.valueOf(j6), Long.valueOf(j7)};
            byte[] bArr9 = $$d;
            Object[] objArr45 = new Object[1];
            c(bArr9[631], (short) 614, (byte) (-bArr9[306]), objArr45);
            Class<?> cls4 = Class.forName((String) objArr45[0]);
            Object[] objArr46 = new Object[1];
            c((byte) 84, (short) 590, bArr9[77], objArr46);
            cls4.getMethod((String) objArr46[0], Long.TYPE, Long.TYPE).invoke(null, objArr44);
            int i74 = ((int[]) objArr2[2])[0];
            Object[] objArr47 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int i75 = ~System.identityHashCode(this);
            int i76 = i74 + (-436060114) + ((~((-419449537) | i75)) * (-783)) + (((~(i75 | 552579375)) | (-426044400)) * 783);
            int i77 = (i76 << 13) ^ i76;
            int i78 = i77 ^ (i77 >>> 17);
            ((int[]) objArr47[2])[0] = i78 ^ (i78 << 5);
        }
        Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame16 == null) {
            int iLastIndexOf = TextUtils.lastIndexOf("", '0') + 31;
            char windowTouchSlop2 = (char) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 49362);
            int touchSlop = (ViewConfiguration.getTouchSlop() >> 8) + 684;
            byte b10 = $$a[4];
            byte b11 = (byte) (b10 | 40);
            Object[] objArr48 = new Object[1];
            b(b10, b11, b11, objArr48);
            objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, windowTouchSlop2, touchSlop, 508509282, false, (String) objArr48[0], null);
        }
        long j8 = ((Field) objAccessartificialFrame16).getLong(null);
        if (j8 == -1 || j8 + 1957 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr49 = new Object[1];
            a(null, new int[]{69, 26, 27, 24}, true, objArr49);
            Class<?> cls5 = Class.forName((String) objArr49[0]);
            Object[] objArr50 = new Object[1];
            a(new byte[]{0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1}, new int[]{95, 18, 0, 10}, true, objArr50);
            Context applicationContext = (Context) cls5.getMethod((String) objArr50[0], new Class[0]).invoke(null, null);
            if (applicationContext != null) {
                applicationContext = (!((applicationContext instanceof ContextWrapper) ^ true) && ((ContextWrapper) applicationContext).getBaseContext() == null) ? null : applicationContext.getApplicationContext();
            }
            Object[] objArr51 = {applicationContext, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 2137939808};
            byte[] bArr10 = $$d;
            byte b12 = (byte) (-bArr10[1]);
            Object[] objArr52 = new Object[1];
            c(b12, (short) (b12 | 424), (byte) (-bArr10[306]), objArr52);
            Class<?> cls6 = Class.forName((String) objArr52[0]);
            byte b13 = bArr10[524];
            Object[] objArr53 = new Object[1];
            c(b13, (short) (b13 | 312), bArr10[123], objArr53);
            objArr3 = (Object[]) cls6.getMethod((String) objArr53[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr51);
            if (applicationContext != null) {
                int i79 = getARTIFICIAL_FRAME_PACKAGE_NAME + 85;
                artificialFrame = i79 % 128;
                int i80 = i79 % 2;
                Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame17 == null) {
                    int offsetAfter2 = 30 - TextUtils.getOffsetAfter(r12, 0);
                    char mode = (char) (View.MeasureSpec.getMode(0) + 49362);
                    int iIndexOf3 = 683 - TextUtils.indexOf((CharSequence) r12, '0', 0, 0);
                    byte[] bArr11 = $$a;
                    Object[] objArr54 = new Object[1];
                    b((byte) (bArr11[80] - 1), bArr11[7], bArr11[15], objArr54);
                    objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(offsetAfter2, mode, iIndexOf3, -1321816393, false, (String) objArr54[0], null);
                }
                ((Field) objAccessartificialFrame17).set(null, objArr3);
                try {
                    Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                    if (objAccessartificialFrame18 == null) {
                        int iMyTid = (Process.myTid() >> 22) + 30;
                        char windowTouchSlop3 = (char) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 49362);
                        int iIndexOf4 = 683 - TextUtils.indexOf((CharSequence) r12, '0');
                        byte b14 = $$a[4];
                        byte b15 = (byte) (b14 | 40);
                        Object[] objArr55 = new Object[1];
                        b(b14, b15, b15, objArr55);
                        objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(iMyTid, windowTouchSlop3, iIndexOf4, 508509282, false, (String) objArr55[0], null);
                    }
                    ((Field) objAccessartificialFrame18).set(null, lValueOf4);
                } catch (Exception unused4) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(777251007);
            if (objAccessartificialFrame19 == null) {
                int i81 = 29 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                char gidForName = (char) (Process.getGidForName(r12) + 49363);
                int i82 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 684;
                byte[] bArr12 = $$a;
                Object[] objArr56 = new Object[1];
                b((byte) (bArr12[80] - 1), bArr12[7], bArr12[15], objArr56);
                objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(i81, gidForName, i82, -1321816393, false, (String) objArr56[0], null);
            }
            Object[] objArr57 = (Object[]) ((Field) objAccessartificialFrame19).get(null);
            objArr3 = new Object[]{new int[]{((int[]) objArr57[0])[0]}, new int[]{((int[]) objArr57[1])[0]}, new int[1], (String) objArr57[3]};
            int iMyPid = Process.myPid();
            int i83 = ~iMyPid;
            int i84 = (-1001025590) + (((~(72098375 | i83)) | (~((-1050722151) | iMyPid))) * 1900) + (((~(iMyPid | (-72098376))) | (~(i83 | 1050722150))) * (-950)) + (((~(iMyPid | 1050722150)) | (~(i83 | (-72098376)))) * 950) + 2137939808;
            int i85 = (i84 << 13) ^ i84;
            int i86 = i85 ^ (i85 >>> 17);
            ((int[]) objArr3[2])[0] = i86 ^ (i86 << 5);
        }
        int i87 = ((int[]) objArr3[1])[0];
        int i88 = ((int[]) objArr3[0])[0];
        if (i88 == i87) {
            int i89 = ((int[]) objArr3[2])[0];
            Object[] objArr58 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
            int iElapsedRealtime2 = (int) SystemClock.elapsedRealtime();
            int i90 = ~((-102911264) | iElapsedRealtime2);
            int i91 = ~iElapsedRealtime2;
            int i92 = i89 + 753929694 + ((i90 | (~(909266943 | i91))) * (-406)) + ((~((-33554433) | i91)) * (-406)) + (((~(iElapsedRealtime2 | (-875712512))) | (~(102911263 | i91))) * 406);
            int i93 = (i92 << 13) ^ i92;
            int i94 = i93 ^ (i93 >>> 17);
            ((int[]) objArr58[2])[0] = i94 ^ (i94 << 5);
        } else {
            Object[] objArr59 = {Long.valueOf((((long) (-1740996757)) << 32) ^ ((long) (i87 ^ i88))), Long.valueOf(-1740997269)};
            byte[] bArr13 = $$d;
            Object[] objArr60 = new Object[1];
            c(bArr13[591], (short) 358, (byte) (-bArr13[306]), objArr60);
            Class<?> cls7 = Class.forName((String) objArr60[0]);
            Object[] objArr61 = new Object[1];
            c((byte) 84, (short) 590, bArr13[77], objArr61);
            cls7.getMethod((String) objArr61[0], Long.TYPE, Long.TYPE).invoke(null, objArr59);
            int i95 = ((int[]) objArr3[2])[0];
            Object[] objArr62 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
            int iIdentityHashCode4 = System.identityHashCode(this);
            int i96 = i95 + (((~((-137473) | iIdentityHashCode4)) * 521) - 669237488) + (((~((~iIdentityHashCode4) | (-137473))) | 975781918) * 521);
            int i97 = (i96 << 13) ^ i96;
            int i98 = i97 ^ (i97 >>> 17);
            ((int[]) objArr62[2])[0] = i98 ^ (i98 << 5);
        }
        Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame20 == null) {
            int i99 = 26 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
            char cLastIndexOf3 = (char) (30067 - TextUtils.lastIndexOf(r12, '0'));
            int iIndexOf5 = 816 - TextUtils.indexOf((CharSequence) r12, (CharSequence) r12, 0, 0);
            byte b16 = $$a[80];
            Object[] objArr63 = new Object[1];
            b(b16, (byte) (b16 | 100), (byte) 47, objArr63);
            objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(i99, cLastIndexOf3, iIndexOf5, 721586079, false, (String) objArr63[0], null);
        }
        long j9 = ((Field) objAccessartificialFrame20).getLong(null);
        if (j9 == -1 || j9 + 1997 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr64 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1055560618};
            Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame21 == null) {
                int i100 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 25;
                char tapTimeout = (char) ((ViewConfiguration.getTapTimeout() >> 16) + 30068);
                int minimumFlingVelocity = 816 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                byte[] bArr14 = $$a;
                Object[] objArr65 = new Object[1];
                b(bArr14[94], (byte) (bArr14[59] - 1), bArr14[48], objArr65);
                objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(i100, tapTimeout, minimumFlingVelocity, -797394565, false, (String) objArr65[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr4 = (Object[]) ((Method) objAccessartificialFrame21).invoke(null, objArr64);
            Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame22 == null) {
                int packedPositionType = ExpandableListView.getPackedPositionType(0L) + 25;
                char cLastIndexOf4 = (char) (30067 - TextUtils.lastIndexOf(r12, '0'));
                int i101 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 815;
                byte b17 = $$a[80];
                Object[] objArr66 = new Object[1];
                b(b17, (byte) (b17 | 92), (byte) 47, objArr66);
                objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(packedPositionType, cLastIndexOf4, i101, 891606461, false, (String) objArr66[0], null);
            }
            ((Field) objAccessartificialFrame22).set(null, objArr4);
            try {
                Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame23 == null) {
                    int packedPositionChild3 = 24 - ExpandableListView.getPackedPositionChild(0L);
                    char mode2 = (char) (30068 - View.MeasureSpec.getMode(0));
                    int keyRepeatDelay = 816 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                    byte b18 = $$a[80];
                    Object[] objArr67 = new Object[1];
                    b(b18, (byte) (b18 | 100), (byte) 47, objArr67);
                    objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(packedPositionChild3, mode2, keyRepeatDelay, 721586079, false, (String) objArr67[0], null);
                }
                ((Field) objAccessartificialFrame23).set(null, lValueOf5);
                int i102 = artificialFrame + 91;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i102 % 128;
                int i103 = i102 % 2;
            } catch (Exception unused5) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame24 == null) {
                int i104 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 25;
                char cIndexOf2 = (char) (TextUtils.indexOf((CharSequence) r12, (CharSequence) r12) + 30068);
                int mode3 = 816 - View.MeasureSpec.getMode(0);
                byte b19 = $$a[80];
                Object[] objArr68 = new Object[1];
                b(b19, (byte) (b19 | 92), (byte) 47, objArr68);
                objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(i104, cIndexOf2, mode3, 891606461, false, (String) objArr68[0], null);
            }
            Object[] objArr69 = (Object[]) ((Field) objAccessartificialFrame24).get(null);
            objArr4 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i105 = ((int[]) objArr69[0])[0];
            int i106 = ((int[]) objArr69[1])[0];
            String[] strArr5 = (String[]) objArr69[2];
            int i107 = ~(((int) Process.getElapsedCpuTime()) | 90596741);
            int i108 = ((17171589 | i107) * (-196)) + 2057375905 + ((i107 | 73425152) * 196) + 1055560618;
            int i109 = (i108 << 13) ^ i108;
            int i110 = i109 ^ (i109 >>> 17);
            ((int[]) objArr4[3])[0] = i110 ^ (i110 << 5);
        }
        int i111 = ((int[]) objArr4[1])[0];
        int i112 = ((int[]) objArr4[0])[0];
        if (i112 == i111) {
            Object[] objArr70 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i113 = ((int[]) objArr4[3])[0];
            int i114 = ((int[]) objArr4[0])[0];
            int i115 = ((int[]) objArr4[1])[0];
            String[] strArr6 = (String[]) objArr4[2];
            int iMyUid = Process.myUid();
            int i116 = i113 + ((((-435295631) + (((~(229713250 | iMyUid)) | (-427885617)) * (-948))) + ((~((~iMyUid) | (-268435473))) * (-948))) - 201414104);
            int i117 = (i116 << 13) ^ i116;
            int i118 = i117 ^ (i117 >>> 17);
            ((int[]) objArr70[3])[0] = i118 ^ (i118 << 5);
        } else {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr7 = (String[]) objArr4[2];
            if (strArr7 != null) {
                for (String str6 : strArr7) {
                    arrayList2.add(str6);
                }
            }
            Object[] objArr71 = {Long.valueOf((((long) (-1412325432)) << 32) ^ ((long) (i111 ^ i112))), Long.valueOf(-1412325431)};
            byte[] bArr15 = $$d;
            Object[] objArr72 = new Object[1];
            c((byte) (-bArr15[334]), (short) 324, (byte) (-bArr15[306]), objArr72);
            Class<?> cls8 = Class.forName((String) objArr72[0]);
            Object[] objArr73 = new Object[1];
            c((byte) 84, (short) 590, bArr15[77], objArr73);
            cls8.getMethod((String) objArr73[0], Long.TYPE, Long.TYPE).invoke(null, objArr71);
            Object[] objArr74 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i119 = ((int[]) objArr4[3])[0];
            int i120 = ((int[]) objArr4[0])[0];
            int i121 = ((int[]) objArr4[1])[0];
            String[] strArr8 = (String[]) objArr4[2];
            int iElapsedRealtime3 = (int) SystemClock.elapsedRealtime();
            int i122 = ~((-172195215) | iElapsedRealtime3);
            int i123 = (-806135295) + ((172170368 | i122) * (-280)) + ((i122 | (~((-25977152) | iElapsedRealtime3))) * 140);
            int i124 = ~((-24847) | iElapsedRealtime3);
            int i125 = ~iElapsedRealtime3;
            int i126 = i119 + i123 + (((~(i125 | (-25952306))) | i124 | (~((-172170369) | i125))) * 140);
            int i127 = (i126 << 13) ^ i126;
            int i128 = i127 ^ (i127 >>> 17);
            ((int[]) objArr74[3])[0] = i128 ^ (i128 << 5);
        }
        Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame25 == null) {
            int packedPositionChild4 = ExpandableListView.getPackedPositionChild(0L) + 18;
            char packedPositionGroup2 = (char) ExpandableListView.getPackedPositionGroup(0L);
            int windowTouchSlop4 = 747 - (ViewConfiguration.getWindowTouchSlop() >> 8);
            byte b20 = $$a[80];
            Object[] objArr75 = new Object[1];
            b(b20, (byte) (b20 | 100), (byte) 47, objArr75);
            objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(packedPositionChild4, packedPositionGroup2, windowTouchSlop4, -144068856, false, (String) objArr75[0], null);
        }
        long j10 = ((Field) objAccessartificialFrame25).getLong(null);
        if (j10 == -1 || j10 + 1904 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr76 = new Object[1];
            a(null, new int[]{69, 26, 27, 24}, true, objArr76);
            Class<?> cls9 = Class.forName((String) objArr76[0]);
            Object[] objArr77 = new Object[1];
            a(new byte[]{0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1}, new int[]{95, 18, 0, 10}, true, objArr77);
            Context applicationContext2 = (Context) cls9.getMethod((String) objArr77[0], new Class[0]).invoke(null, null);
            if (applicationContext2 != null) {
                int i129 = getARTIFICIAL_FRAME_PACKAGE_NAME + 113;
                artificialFrame = i129 % 128;
                if (i129 % 2 == 0) {
                    int i130 = 31 / 0;
                    if (applicationContext2 instanceof ContextWrapper) {
                        if (((ContextWrapper) applicationContext2).getBaseContext() != null) {
                            applicationContext2 = null;
                        }
                    }
                } else if (applicationContext2 instanceof ContextWrapper) {
                    if (((ContextWrapper) applicationContext2).getBaseContext() != null) {
                        applicationContext2 = null;
                    }
                }
                applicationContext2 = applicationContext2.getApplicationContext();
            }
            Object[] objArr78 = {applicationContext2, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -135178974};
            byte[] bArr16 = $$d;
            Object[] objArr79 = new Object[1];
            c(bArr16[631], (short) 260, (byte) (bArr16[547] + 1), objArr79);
            Class<?> cls10 = Class.forName((String) objArr79[0]);
            Object[] objArr80 = new Object[1];
            c((byte) (-bArr16[432]), (short) 236, (byte) (-bArr16[206]), objArr80);
            objArr5 = (Object[]) cls10.getMethod((String) objArr80[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr78);
            Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame26 == null) {
                int jumpTapTimeout = (ViewConfiguration.getJumpTapTimeout() >> 16) + 17;
                char mirror = (char) ('0' - AndroidCharacter.getMirror('0'));
                int gidForName2 = Process.getGidForName(r12) + 748;
                byte b21 = $$a[80];
                Object[] objArr81 = new Object[1];
                b(b21, (byte) (b21 | 92), (byte) 47, objArr81);
                objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout, mirror, gidForName2, -1031537386, false, (String) objArr81[0], null);
            }
            ((Field) objAccessartificialFrame26).set(null, objArr5);
            try {
                Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame27 == null) {
                    int iBlue = 17 - Color.blue(0);
                    char size = (char) View.MeasureSpec.getSize(0);
                    int i131 = 748 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                    byte b22 = $$a[80];
                    Object[] objArr82 = new Object[1];
                    b(b22, (byte) (b22 | 100), (byte) 47, objArr82);
                    objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(iBlue, size, i131, -144068856, false, (String) objArr82[0], null);
                }
                ((Field) objAccessartificialFrame27).set(null, lValueOf6);
            } catch (Exception unused6) {
                throw new RuntimeException();
            }
        } else {
            int i132 = getARTIFICIAL_FRAME_PACKAGE_NAME + 75;
            artificialFrame = i132 % 128;
            int i133 = i132 % 2;
            Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame28 == null) {
                int deadChar = 17 - KeyEvent.getDeadChar(0, 0);
                char cLastIndexOf5 = (char) (TextUtils.lastIndexOf(r12, '0', 0) + 1);
                int i134 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 747;
                byte b23 = $$a[80];
                Object[] objArr83 = new Object[1];
                b(b23, (byte) (b23 | 92), (byte) 47, objArr83);
                objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(deadChar, cLastIndexOf5, i134, -1031537386, false, (String) objArr83[0], null);
            }
            Object[] objArr84 = (Object[]) ((Field) objAccessartificialFrame28).get(null);
            objArr5 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
            int i135 = ((int[]) objArr84[3])[0];
            int i136 = ((int[]) objArr84[4])[0];
            List list = (List) objArr84[0];
            List list2 = (List) objArr84[2];
            int iMyUid2 = Process.myUid();
            int i137 = ~((-312508426) | iMyUid2);
            int i138 = ((((-1232734003) + ((155255008 | i137) * (-476))) + (i137 * 952)) + ((~((~iMyUid2) | (-312508426))) * 476)) - 135178974;
            int i139 = (i138 << 13) ^ i138;
            int i140 = i139 ^ (i139 >>> 17);
            ((int[]) objArr5[1])[0] = i140 ^ (i140 << 5);
        }
        int i141 = ((int[]) objArr5[4])[0];
        int i142 = ((int[]) objArr5[3])[0];
        if (i142 == i141) {
            Object[] objArr85 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i143 = ((int[]) objArr5[1])[0];
            int i144 = ((int[]) objArr5[3])[0];
            int i145 = ((int[]) objArr5[4])[0];
            List list3 = (List) objArr5[0];
            List list4 = (List) objArr5[2];
            int iUptimeMillis = (int) SystemClock.uptimeMillis();
            int i146 = i143 + ((((~((-450413450) | iUptimeMillis)) | 333800969) * 398) - 1330393075) + (((~((~iUptimeMillis) | (-450413450))) | 333800969) * 398);
            int i147 = (i146 << 13) ^ i146;
            int i148 = i147 ^ (i147 >>> 17);
            ((int[]) objArr85[1])[0] = i148 ^ (i148 << 5);
        } else {
            ArrayList arrayList3 = new ArrayList();
            Object[] objArr86 = {objArr5};
            Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(1804664566);
            if (objAccessartificialFrame29 == null) {
                objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(41 - View.getDefaultSize(0, 0), (char) ((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 12468), 3641 - Process.getGidForName(r12), -185222914, false, "coroutineCreation", new Class[]{Object[].class});
            }
            arrayList3.add(((Method) objAccessartificialFrame29).invoke(null, objArr86));
            Object[] objArr87 = {objArr5};
            Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(-1243809191);
            if (objAccessartificialFrame30 == null) {
                objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(Color.red(0) + 41, (char) (12468 - TextUtils.indexOf((CharSequence) r12, (CharSequence) r12, 0, 0)), 3642 - ExpandableListView.getPackedPositionGroup(0L), 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
            }
            arrayList3.add(((Method) objAccessartificialFrame30).invoke(null, objArr87));
            long j11 = ((long) (i141 ^ i142)) ^ (((long) 954974849) << 32);
            long j12 = 954974857;
            int i149 = artificialFrame + 45;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i149 % 128;
            int i150 = i149 % 2;
            Object[] objArr88 = {Long.valueOf(j11), Long.valueOf(j12)};
            byte[] bArr17 = $$d;
            Object[] objArr89 = new Object[1];
            c(bArr17[614], (short) ($$e | 24), (byte) (-bArr17[306]), objArr89);
            Class<?> cls11 = Class.forName((String) objArr89[0]);
            Object[] objArr90 = new Object[1];
            c((byte) 84, (short) 590, bArr17[77], objArr90);
            cls11.getMethod((String) objArr90[0], Long.TYPE, Long.TYPE).invoke(null, objArr88);
            Object[] objArr91 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i151 = ((int[]) objArr5[1])[0];
            int i152 = ((int[]) objArr5[3])[0];
            int i153 = ((int[]) objArr5[4])[0];
            List list5 = (List) objArr5[0];
            List list6 = (List) objArr5[2];
            int startUptimeMillis = (int) Process.getStartUptimeMillis();
            int i154 = ~startUptimeMillis;
            int i155 = i151 + 1752310712 + ((~((-205622379) | i154)) * 979) + ((startUptimeMillis | 399826079) * (-979)) + (((~((-205622379) | startUptimeMillis)) | (~(i154 | 399826079))) * 979);
            int i156 = (i155 << 13) ^ i155;
            int i157 = i156 ^ (i156 >>> 17);
            ((int[]) objArr91[1])[0] = i157 ^ (i157 << 5);
        }
        boolean zOnCreate = super.onCreate();
        Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame31 == null) {
            int fadingEdgeLength2 = (ViewConfiguration.getFadingEdgeLength() >> 16) + 30;
            char mirror2 = (char) (49410 - AndroidCharacter.getMirror('0'));
            int packedPositionChild5 = 683 - ExpandableListView.getPackedPositionChild(0L);
            byte[] bArr18 = $$a;
            Object[] objArr92 = new Object[1];
            b(bArr18[33], bArr18[19], (byte) (bArr18[35] + 1), objArr92);
            objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength2, mirror2, packedPositionChild5, 752929587, false, (String) objArr92[0], null);
        }
        long j13 = ((Field) objAccessartificialFrame31).getLong(null);
        if (j13 == -1 || j13 + 2035 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr93 = new Object[1];
            a(null, new int[]{69, 26, 27, 24}, true, objArr93);
            Class<?> cls12 = Class.forName((String) objArr93[0]);
            Object[] objArr94 = new Object[1];
            a(new byte[]{0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1}, new int[]{95, 18, 0, 10}, true, objArr94);
            Context applicationContext3 = (Context) cls12.getMethod((String) objArr94[0], new Class[0]).invoke(null, null);
            if (applicationContext3 == null) {
                context = applicationContext3;
            } else if ((applicationContext3 instanceof ContextWrapper) && ((ContextWrapper) applicationContext3).getBaseContext() == null) {
                context = null;
            } else {
                applicationContext3 = applicationContext3.getApplicationContext();
                context = applicationContext3;
            }
            Object[] objArr95 = {context, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 2062468063};
            byte[] bArr19 = $$d;
            Object[] objArr96 = new Object[1];
            c((byte) (-bArr19[368]), (short) 154, (byte) (-bArr19[306]), objArr96);
            Class<?> cls13 = Class.forName((String) objArr96[0]);
            Object[] objArr97 = new Object[1];
            c((byte) (-bArr19[432]), (short) 236, (byte) (-bArr19[206]), objArr97);
            Object[] objArr98 = (Object[]) cls13.getMethod((String) objArr97[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr95);
            if (context != null) {
                Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(-326560385);
                if (objAccessartificialFrame32 == null) {
                    int iArgb2 = Color.argb(0, 0, 0, 0) + 30;
                    char size2 = (char) (49362 - View.MeasureSpec.getSize(0));
                    int packedPositionGroup3 = 684 - ExpandableListView.getPackedPositionGroup(0L);
                    byte[] bArr20 = $$a;
                    byte b24 = bArr20[33];
                    byte b25 = (byte) (bArr20[80] - 1);
                    Object[] objArr99 = new Object[1];
                    b(b24, b25, (byte) (b25 | 38), objArr99);
                    objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(iArgb2, size2, packedPositionGroup3, 1944867703, false, (String) objArr99[0], null);
                }
                ((Field) objAccessartificialFrame32).set(null, objArr98);
                try {
                    Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                    if (objAccessartificialFrame33 == null) {
                        int iIndexOf6 = TextUtils.indexOf((CharSequence) r12, '0') + 31;
                        char size3 = (char) (View.MeasureSpec.getSize(0) + 49362);
                        int longPressTimeout2 = 684 - (ViewConfiguration.getLongPressTimeout() >> 16);
                        byte[] bArr21 = $$a;
                        Object[] objArr100 = new Object[1];
                        b(bArr21[33], bArr21[19], (byte) (bArr21[35] + 1), objArr100);
                        objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(iIndexOf6, size3, longPressTimeout2, 752929587, false, (String) objArr100[0], null);
                    }
                    ((Field) objAccessartificialFrame33).set(null, lValueOf7);
                } catch (Exception unused7) {
                    throw new RuntimeException();
                }
            }
            objArr6 = objArr98;
        } else {
            Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(-326560385);
            if (objAccessartificialFrame34 == null) {
                int i158 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 30;
                char c3 = (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 49361);
                int iMyTid2 = (Process.myTid() >> 22) + 684;
                byte[] bArr22 = $$a;
                byte b26 = bArr22[33];
                byte b27 = (byte) (bArr22[80] - 1);
                Object[] objArr101 = new Object[1];
                b(b26, b27, (byte) (b27 | 38), objArr101);
                objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(i158, c3, iMyTid2, 1944867703, false, (String) objArr101[0], null);
            }
            Object[] objArr102 = (Object[]) ((Field) objAccessartificialFrame34).get(null);
            objArr6 = new Object[]{new int[]{((int[]) objArr102[0])[0]}, new int[]{((int[]) objArr102[1])[0]}, new int[1], (String) objArr102[3]};
            int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
            int i159 = 1669747082 + (((~iMaxMemory) | 211353920) * 1324) + (((~(iMaxMemory | 228170572)) | (~(750453202 | iMaxMemory))) * (-1324)) + 711628915;
            int i160 = (i159 << 13) ^ i159;
            int i161 = i160 ^ (i160 >>> 17);
            ((int[]) objArr6[2])[0] = i161 ^ (i161 << 5);
        }
        int i162 = ((int[]) objArr6[1])[0];
        int i163 = ((int[]) objArr6[0])[0];
        if (i163 == i162) {
            int i164 = ((int[]) objArr6[2])[0];
            Object[] objArr103 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
            int i165 = ~((int) Process.getStartUptimeMillis());
            int i166 = i164 + 1300475790 + (((~(i165 | (-76235413))) | (~((-824184905) | i165))) * (-184)) + ((39101729 | (~((-863286634) | i165)) | (~((-115337142) | i165))) * SyslogConstants.LOG_LOCAL7) + 1073364440;
            int i167 = (i166 << 13) ^ i166;
            int i168 = i167 ^ (i167 >>> 17);
            ((int[]) objArr103[2])[0] = i168 ^ (i168 << 5);
        } else {
            Object[] objArr104 = {Long.valueOf(((long) (i162 ^ i163)) ^ (((long) 1963630474) << 32)), Long.valueOf(1963630478)};
            byte[] bArr23 = $$d;
            Object[] objArr105 = new Object[1];
            c((byte) (-bArr23[1]), (short) b.f40o, (byte) (-bArr23[306]), objArr105);
            Class<?> cls14 = Class.forName((String) objArr105[0]);
            Object[] objArr106 = new Object[1];
            c((byte) 84, (short) 590, bArr23[77], objArr106);
            cls14.getMethod((String) objArr106[0], Long.TYPE, Long.TYPE).invoke(null, objArr104);
            int i169 = ((int[]) objArr6[2])[0];
            Object[] objArr107 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
            int i170 = (int) Runtime.getRuntime().totalMemory();
            int i171 = i169 + (-1267991058) + (((~(979353828 | i170)) | 8961 | (~((-730054) | i170))) * (-744)) + (((~i170) | 978632736) * 744) + ((i170 | (-8962)) * 744);
            int i172 = (i171 << 13) ^ i171;
            int i173 = i172 ^ (i172 >>> 17);
            ((int[]) objArr107[2])[0] = i173 ^ (i173 << 5);
        }
        Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame35 == null) {
            int i174 = 22 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
            char cIndexOf3 = (char) (TextUtils.indexOf((CharSequence) r12, '0', 0) + 1);
            int iMyPid2 = (Process.myPid() >> 22) + 465;
            byte b28 = $$a[80];
            Object[] objArr108 = new Object[1];
            b(b28, (byte) (b28 | 100), (byte) 47, objArr108);
            objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(i174, cIndexOf3, iMyPid2, -785931255, false, (String) objArr108[0], null);
        }
        long j14 = ((Field) objAccessartificialFrame35).getLong(null);
        if (j14 == -1 || j14 + 1990 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr109 = new Object[1];
            a(null, new int[]{69, 26, 27, 24}, true, objArr109);
            Class<?> cls15 = Class.forName((String) objArr109[0]);
            Object[] objArr110 = new Object[1];
            a(new byte[]{0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1}, new int[]{95, 18, 0, 10}, true, objArr110);
            Context applicationContext4 = (Context) cls15.getMethod((String) objArr110[0], new Class[0]).invoke(null, null);
            if (applicationContext4 != null) {
                applicationContext4 = ((applicationContext4 instanceof ContextWrapper) && ((ContextWrapper) applicationContext4).getBaseContext() == null) ? null : applicationContext4.getApplicationContext();
            }
            int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr111 = new Object[1];
            a(new byte[]{0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0}, new int[]{113, 64, 149, 20}, true, objArr111);
            String str7 = (String) objArr111[0];
            Object[] objArr112 = new Object[1];
            a(new byte[]{1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1}, new int[]{177, 64, 0, 0}, false, objArr112);
            Object[] objArr113 = {applicationContext4, new String[]{str7, (String) objArr112[0]}, Integer.valueOf(iIntValue2), 1, -1184214080};
            byte[] bArr24 = $$d;
            Object[] objArr114 = new Object[1];
            c(bArr24[218], bArr24[232], (byte) (-bArr24[306]), objArr114);
            Class<?> cls16 = Class.forName((String) objArr114[0]);
            byte b29 = bArr24[524];
            Object[] objArr115 = new Object[1];
            c(b29, (short) (b29 | 312), bArr24[123], objArr115);
            Object[] objArr116 = (Object[]) cls16.getMethod((String) objArr115[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr113);
            int i175 = ((int[]) objArr116[0])[0];
            int i176 = ((int[]) objArr116[3])[0];
            if (applicationContext4 != null) {
                Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame36 == null) {
                    int packedPositionChild6 = 20 - ExpandableListView.getPackedPositionChild(0L);
                    char cIndexOf4 = (char) TextUtils.indexOf((CharSequence) r12, (CharSequence) r12, 0);
                    int iLastIndexOf2 = 464 - TextUtils.lastIndexOf(r12, '0');
                    byte b30 = $$a[80];
                    Object[] objArr117 = new Object[1];
                    b(b30, (byte) (b30 | 92), (byte) 47, objArr117);
                    objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(packedPositionChild6, cIndexOf4, iLastIndexOf2, -612765161, false, (String) objArr117[0], null);
                }
                ((Field) objAccessartificialFrame36).set(null, objArr116);
                try {
                    Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(1313006081);
                    if (objAccessartificialFrame37 == null) {
                        int iMakeMeasureSpec2 = 21 - View.MeasureSpec.makeMeasureSpec(0, 0);
                        char c4 = (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                        int i177 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 464;
                        byte b31 = $$a[80];
                        Object[] objArr118 = new Object[1];
                        b(b31, (byte) (b31 | 100), (byte) 47, objArr118);
                        objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec2, c4, i177, -785931255, false, (String) objArr118[0], null);
                    }
                    ((Field) objAccessartificialFrame37).set(null, lValueOf8);
                } catch (Exception unused8) {
                    throw new RuntimeException();
                }
            }
            objArr7 = objArr116;
        } else {
            Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(1142731807);
            if (objAccessartificialFrame38 == null) {
                int keyRepeatDelay2 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 21;
                char cRed = (char) Color.red(0);
                int scrollBarFadeDuration2 = 465 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                byte b32 = $$a[80];
                Object[] objArr119 = new Object[1];
                b(b32, (byte) (b32 | 92), (byte) 47, objArr119);
                objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay2, cRed, scrollBarFadeDuration2, -612765161, false, (String) objArr119[0], null);
            }
            Object[] objArr120 = (Object[]) ((Field) objAccessartificialFrame38).get(null);
            objArr7 = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
            int i178 = ((int[]) objArr120[3])[0];
            int i179 = ((int[]) objArr120[0])[0];
            String[] strArr9 = (String[]) objArr120[1];
            int iIdentityHashCode5 = System.identityHashCode(this);
            int i180 = ~(1035983847 | iIdentityHashCode5);
            int i181 = ((((-1594813239) + ((70162821 | i180) * (-476))) + (i180 * 952)) + ((~((~iIdentityHashCode5) | 1035983847)) * 476)) - 1184214080;
            int i182 = (i181 << 13) ^ i181;
            int i183 = i182 ^ (i182 >>> 17);
            ((int[]) objArr7[2])[0] = i183 ^ (i183 << 5);
        }
        int i184 = ((int[]) objArr7[0])[0];
        int i185 = ((int[]) objArr7[3])[0];
        if (i185 == i184) {
            Object[] objArr121 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i186 = ((int[]) objArr7[2])[0];
            int i187 = ((int[]) objArr7[3])[0];
            int i188 = ((int[]) objArr7[0])[0];
            String[] strArr10 = (String[]) objArr7[1];
            int i189 = (~Process.myUid()) | 1002166971;
            int i190 = i186 + (-2033622962) + (i189 * 495) + (((~i189) | 160612898) * 495);
            int i191 = (i190 << 13) ^ i190;
            int i192 = i191 ^ (i191 >>> 17);
            ((int[]) objArr121[2])[0] = i192 ^ (i192 << 5);
        } else {
            ArrayList arrayList4 = new ArrayList();
            String[] strArr11 = (String[]) objArr7[1];
            if (strArr11 != null) {
                int i193 = 0;
                while (i193 < strArr11.length) {
                    int i194 = artificialFrame + 69;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i194 % 128;
                    if (i194 % 2 != 0) {
                        arrayList4.add(strArr11[i193]);
                        i193 += 24;
                    } else {
                        arrayList4.add(strArr11[i193]);
                        i193++;
                    }
                }
            }
            Object[] objArr122 = {Long.valueOf(((long) (i184 ^ i185)) ^ (((long) 1155035371) << 32)), Long.valueOf(1155035307)};
            byte[] bArr25 = $$d;
            Object[] objArr123 = new Object[1];
            c((byte) (bArr25[232] - 1), bArr25[77], (byte) (-bArr25[306]), objArr123);
            Class<?> cls17 = Class.forName((String) objArr123[0]);
            Object[] objArr124 = new Object[1];
            c((byte) 84, (short) 590, bArr25[77], objArr124);
            cls17.getMethod((String) objArr124[0], Long.TYPE, Long.TYPE).invoke(null, objArr122);
            Object[] objArr125 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i195 = ((int[]) objArr7[2])[0];
            int i196 = ((int[]) objArr7[3])[0];
            int i197 = ((int[]) objArr7[0])[0];
            String[] strArr12 = (String[]) objArr7[1];
            int iIdentityHashCode6 = System.identityHashCode(this);
            int i198 = ~iIdentityHashCode6;
            int i199 = i195 + (-1903868346) + (((~(430157733 | i198)) | (~((-411140645) | iIdentityHashCode6))) * (-831)) + ((~(1001648103 | iIdentityHashCode6)) * (-1662)) + (((~(iIdentityHashCode6 | (-430157734))) | (~(i198 | (-590507460))) | (~(590507459 | iIdentityHashCode6))) * 831);
            int i200 = (i199 << 13) ^ i199;
            int i201 = i200 ^ (i200 >>> 17);
            ((int[]) objArr125[2])[0] = i201 ^ (i201 << 5);
        }
        return zOnCreate;
    }

    static {
        byte[] bArr = new byte[660];
        System.arraycopy("\u0012ì|5ðþ;Ãôü\u0004÷\u00033Éí\u00037ÙØ\u0002÷\u000f\rÚÿ÷\u0001ü¿÷6¹þøA¾ù\u0004\u0001ýúô9Çðù\t3·ÿ\u00037çÆ\u0012óÿ\u0002\u001dÉ\u000büýï\u001aÞ\rúô\u0002ïðþ;¸\t\u0000úë\u0002\té\u0007ï\rþðþüô\u0003\u0001ñ÷GÇþð\u0004ï\rëÿÿü:çÞð\u0004ï\r\u000bßÿü\u001bÚ\u0007ë\u0005\u0003=üÛÉ\u0000\u000bï\u0000\tñ\u0015Ö\u0007ö\bÿí\u0007\u0002\u001eÍ\u0003\u0018Ú\u0007ûõ\u0019Öý\u0004ÿ÷\u00051ðùÿöý\u0007÷\u0005\u001eÍ\t\u0000é\u0007öýðþ;Ä\u0001úúÿïü\u00009¾ù\u0004ú÷<ÞÙ\u0004ú÷\u001dèï\töþïJÚáúúÿïü\u0000\u001bÙ\u0004ú÷)Úë\u0007ï\tñ÷#éîú\u0005ô-Ðýöþ\rúëúüúîü\u000eëú\u0007ÿù\u0002ö\u0004ñ\"Ð\rð\u0004ðþ;Ä\u0001úúÿïü\u00009Éíü\u0000ÿ÷ÿôAéÍü ß÷ÿ#ßé\u000f9ïðþ;Ä\u0001úúÿïü\u00009Áø\böþñ\u0003õ\u0007õÿ÷\u00053Çðù\t3ÚÚÿ\u0007ë\u000eúï\u001bêðø\fó\u0007ú\u001báúë\u0001ùõQÝÐþù\u000bï\u0001öýö=·\nóöþõGâÕøû\u0002\tð\u0004\u001eÞú÷ÿ=ïÐùÿöý\u0007÷\u0005\u001dÛÿé\nüú÷\u0003\u0018Óðþ;Ãôü\u0004÷\u00033Éï\u0006îÿ\u0002\u00012ÃööAÁ÷ö\u000bï\u0000\tñ:½ýýþñ\u0011å\tò\u0006öý\u000bùýë\u000bð\u0007û\u0002ùé\u0003\u0006ô\u0003ý2°ü\u0011ðþ;Ãôü\u0004÷\u00033Éï\u0006îÿ\u0002\u00012½\bé\u000bï\u0005\u0004ñ:Çðÿùù@çÐÿùù\u001cßÿ\u0003îðþ;Ä\u0001úúÿïü\u00009¸\t\u0000úëBµ\bø\bï\töþï@Ñæ\u0004\u0002\u000fÛ\u0007û\u0011ÝüÿDüÛÉ\u0000\u000bï\u0000\tñ\u0015Ö\u0007ö\bÿí\u0007\u0002\u0013çð\u0007úÿ-ðþ;Ãôü\u0004÷\u00033ºúÿ÷\u0001\té\u000b4Õãýú\u0007÷ÿù\u0004ûò\u0003\u0015çãý\"Ûþ\u0005÷\u0003\u0017ßòûðþ;Âûñ\u000fú÷û\u0004íü>Åé\u0011úñø\u0007öý÷AÝÐ2Ö\u0002úïÿ&É\u0011úñø\u0007öý".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 660);
        $$d = bArr;
        $$e = 193;
        $$a = new byte[]{53, -94, -28, -114, 5, -1, -33, 33, -2, -9, 5, -7, 5, -1, -50, 39, Ascii.VT, -7, -12, Ascii.SI, 49, 2, -11, -3, 3, -6, 6, -8, Ascii.VT, -25, 33, -19, 2, 8, -37, 44, -17, Ascii.FF, -8, Ascii.SO, -2, Ascii.SI, -33, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, 10, -31, Ascii.DC4, Ascii.CR, -8, -11, -13, Ascii.ESC, -9, Ascii.DC2, -36, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, -7, Ascii.DC2, -43, Ascii.GS, -4, 17, 2, Ascii.ESC, 1, -7, -6, -33, 51, -12, 3, -8, 1, Ascii.CR, -9, Ascii.DC2, -34, Ascii.EM, 4, -17, 19, -15, -1, -18, Ascii.SI, 19, -11, 5, -7, -2, Ascii.SI, -36, Ascii.NAK, Ascii.CR, -15, 2, 9, 6, -34, Ascii.SI, 19, -11, 5, -7};
        $$b = 68;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        IPostMessageService = new char[]{38200, 38058, 38056, 38054, 38049, 38053, 38059, 38216, 38211, 38048, 38209, 38225, 38059, 38043, 38046, 38053, 38056, 38073, 38074, 38052, 38056, 38058, 38285, 38359, 38361, 38359, 38350, 38355, 38363, 38372, 38372, 38364, 38361, 38351, 38353, 38356, 38358, 38197, 38062, 38059, 38052, 38049, 38065, 38231, 38221, 38061, 38064, 38065, 38218, 38224, 38060, 38060, 38066, 38392, 38195, 38197, 38192, 38184, 38187, 38187, 38179, 38201, 38341, 38191, 38188, 38340, 38336, 38192, 38197, 38207, 38194, 38204, 38352, 38187, 38192, 38203, 38190, 38203, 38192, 38337, 38371, 38390, 38196, 38196, 38339, 38390, 38336, 38203, 38197, 38194, 38336, 38198, 38339, 38336, 38339, 38279, 38351, 38375, 38373, 38350, 38358, 38356, 38349, 38348, 38355, 38359, 38353, 38355, 38353, 38357, 38365, 38361, 38357, 38362, 38261, 38237, 38214, 38213, 38235, 38259, 38263, 38242, 38239, 38259, 38236, 38237, 38236, 38213, 38238, 38264, 38262, 38262, 38239, 38238, 38239, 38215, 38237, 38236, 38215, 38216, 38241, 38242, 38239, 38261, 38260, 38258, 38238, 38217, 38215, 38239, 38241, 38239, 38260, 38260, 38237, 38214, 38241, 38239, 38235, 38235, 38235, 38236, 38238, 38261, 38237, 38212, 38213, 38236, 38236, 38240, 38265, 38240, 38238, 38236, 38235, 38258, 38259, 38309, 38281, 38385, 38362, 38362, 38362, 38388, 38285, 38285, 38282, 38280, 38388, 38387, 38283, 38388, 38385, 38281, 38283, 38284, 38388, 38364, 38364, 38386, 38388, 38386, 38281, 38282, 38283, 38388, 38387, 38388, 38389, 38284, 38283, 38285, 38285, 38284, 38388, 38364, 38386, 38280, 38282, 38284, 38284, 38285, 38286, 38284, 38283, 38283, 38282, 38389, 38364, 38363, 38364, 38386, 38281, 38387, 38366, 38387, 38282, 38286, 38391, 38364, 38362};
    }
}
