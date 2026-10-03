package com.google.android.material.color.utilities;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import o.ArtificialStackFrames;
import o.build;
import o.extraCallback;

/* JADX INFO: loaded from: classes2.dex */
public final class QuantizerCelebi {
    private static final byte[] $$c = {47, 75, -118, 7};
    private static final int $$d = 97;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {4, -24, -50, 10, 10, 4, -5, Ascii.SYN, -16, 3, Ascii.DC4, -50, Ascii.SYN, -3, 8, 1, -6, Ascii.GS, 50, Ascii.SO, 32, 8, 6, Ascii.US, 5, Ascii.DLE, -2, Ascii.DC2, 3, Ascii.DLE, 5, 10, Ascii.DC2, -9, Ascii.SO, -5, 0, -8, Ascii.DC4, Ascii.ESC, Ascii.SYN, -16, 8, 5, 36, 8, 3, -9, 5, Ascii.VT, 10, 2, 5};
    private static final int $$b = 63;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char TopicBuilder = 14552;
    private static char ICustomTabsCallback = 17318;
    private static char extraCallbackWithResult = 24856;
    private static char onMessageChannelReady = 19576;
    private static char[] ArtificialStackFrames = {44392, 44398, 44335, 44390, 44406, 44396, 44342, 44399, 44334, 44386, 44698, 44407, 44702, 44391, 44403, 44383, 44333, 44397, 44395, 44404, 44385, 44389, 44402, 44405, 44699, 44388, 44409, 44400, 44697, 44387, 44696, 44410, 44408, 44393, 44384, 44339};
    private static char coroutineCreation = 39068;

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0027). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(int r5, short r6, short r7) {
        /*
            int r6 = r6 * 4
            int r6 = r6 + 4
            byte[] r0 = com.google.android.material.color.utilities.QuantizerCelebi.$$c
            int r7 = 110 - r7
            int r5 = r5 * 3
            int r1 = r5 + 1
            byte[] r1 = new byte[r1]
            r2 = -1
            if (r0 != 0) goto L14
            r3 = r5
            r7 = r6
            goto L27
        L14:
            r4 = r7
            r7 = r6
            r6 = r4
        L17:
            int r2 = r2 + 1
            byte r3 = (byte) r6
            r1[r2] = r3
            if (r2 != r5) goto L25
            java.lang.String r5 = new java.lang.String
            r6 = 0
            r5.<init>(r1, r6)
            return r5
        L25:
            r3 = r0[r7]
        L27:
            int r6 = r6 + r3
            int r7 = r7 + 1
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.color.utilities.QuantizerCelebi.$$e(int, short, short):java.lang.String");
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
    private static void a(byte r5, byte r6, int r7, java.lang.Object[] r8) {
        /*
            byte[] r0 = com.google.android.material.color.utilities.QuantizerCelebi.$$a
            int r7 = 115 - r7
            int r6 = r6 + 4
            int r1 = r5 + 2
            byte[] r1 = new byte[r1]
            int r5 = r5 + 1
            r2 = 0
            if (r0 != 0) goto L12
            r4 = r5
            r3 = r2
            goto L24
        L12:
            r3 = r2
        L13:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r5) goto L20
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L20:
            r4 = r0[r6]
            int r3 = r3 + 1
        L24:
            int r6 = r6 + 1
            int r7 = r7 + r4
            int r7 = r7 + (-5)
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.color.utilities.QuantizerCelebi.a(byte, byte, int, java.lang.Object[]):void");
    }

    private QuantizerCelebi() {
    }

    public static Map<Integer, Integer> quantize(int[] iArr, int i) {
        Set<Integer> setKeySet = new QuantizerWu().quantize(iArr, i).colorToCount.keySet();
        int[] iArr2 = new int[setKeySet.size()];
        Iterator<Integer> it2 = setKeySet.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            iArr2[i2] = it2.next().intValue();
            i2++;
        }
        return QuantizerWsmeans.quantize(iArr, iArr2, i);
    }

    private static void b(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        build buildVar = new build();
        char[] cArr2 = new char[cArr.length];
        buildVar.c = 0;
        char[] cArr3 = new char[2];
        int i3 = $11 + 53;
        $10 = i3 % 128;
        int i4 = i3 % 2;
        while (buildVar.c < cArr.length) {
            int i5 = $11 + 79;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            cArr3[0] = cArr[buildVar.c];
            cArr3[1] = cArr[buildVar.c + 1];
            int i7 = 58224;
            int i8 = 0;
            while (i8 < 16) {
                int i9 = $10 + 97;
                $11 = i9 % 128;
                int i10 = i9 % 2;
                char c = cArr3[1];
                char c2 = cArr3[0];
                try {
                    Object[] objArr2 = {Integer.valueOf(c), Integer.valueOf((c2 + i7) ^ ((c2 << 4) + ((char) (((long) extraCallbackWithResult) ^ (-4408183324873663413L))))), Integer.valueOf(c2 >>> 5), Integer.valueOf(onMessageChannelReady)};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1585798252);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) 0;
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(29 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) (Drawable.resolveOpacity(0, 0) + 17263), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 1066, 1042277788, false, $$e(b, b2, (byte) (b2 + 2)), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    char cCharValue = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    cArr3[1] = cCharValue;
                    Object[] objArr3 = {Integer.valueOf(cArr3[0]), Integer.valueOf((cCharValue + i7) ^ ((cCharValue << 4) + ((char) (((long) TopicBuilder) ^ (-4408183324873663413L))))), Integer.valueOf(cCharValue >>> 5), Integer.valueOf(ICustomTabsCallback)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1585798252);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 0;
                        byte b4 = b3;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(((Process.getThreadPriority(0) + 20) >> 6) + 28, (char) (17263 - (ViewConfiguration.getKeyRepeatDelay() >> 16)), Gravity.getAbsoluteGravity(0, 0) + 1067, 1042277788, false, $$e(b3, b4, (byte) (b4 + 2)), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    cArr3[0] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                    i7 -= 40503;
                    i8++;
                    int i11 = $11 + 17;
                    $10 = i11 % 128;
                    int i12 = i11 % 2;
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
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 26, (char) (63928 - (ViewConfiguration.getMinimumFlingVelocity() >> 16)), (-16776730) - Color.rgb(0, 0, 0), 1554985764, false, $$e(b5, b6, b6), new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame3).invoke(null, objArr4);
        }
        objArr[0] = new String(cArr2, 0, i);
    }

    private static void c(byte b, int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2;
        int i3 = 2;
        int i4 = 2 % 2;
        extraCallback extracallback = new extraCallback();
        char[] cArr2 = ArtificialStackFrames;
        int i5 = -1819279892;
        char c = '0';
        if (cArr2 != null) {
            int i6 = $10 + 105;
            $11 = i6 % 128;
            int i7 = i6 % 2;
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i8 = 0;
            while (i8 < length) {
                int i9 = $10 + 91;
                $11 = i9 % 128;
                int i10 = i9 % i3;
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr2[i8])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i5);
                    if (objAccessartificialFrame == null) {
                        byte b2 = (byte) 0;
                        byte b3 = b2;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(14 - TextUtils.indexOf("", c, 0, 0), (char) (20487 - TextUtils.indexOf("", c)), 2148 - View.MeasureSpec.getSize(0), 216710116, false, $$e(b2, b3, (byte) (b3 | Ascii.CR)), new Class[]{Integer.TYPE});
                    }
                    cArr3[i8] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i8++;
                    i3 = 2;
                    i5 = -1819279892;
                    c = '0';
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
        try {
            Object[] objArr3 = {Integer.valueOf(coroutineCreation)};
            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1819279892);
            if (objAccessartificialFrame2 == null) {
                byte b4 = (byte) 0;
                byte b5 = b4;
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 14, (char) (TextUtils.getOffsetBefore("", 0) + 20488), TextUtils.lastIndexOf("", '0', 0) + 2149, 216710116, false, $$e(b4, b5, (byte) (b5 | Ascii.CR)), new Class[]{Integer.TYPE});
            }
            char cCharValue = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
            char[] cArr4 = new char[i];
            if (i % 2 != 0) {
                int i11 = $11;
                int i12 = i11 + 9;
                $10 = i12 % 128;
                if (i12 % 2 != 0) {
                    i2 = i + 29;
                    cArr4[i2] = (char) (cArr[i2] % b);
                } else {
                    i2 = i - 1;
                    cArr4[i2] = (char) (cArr[i2] - b);
                }
                int i13 = i11 + 39;
                $10 = i13 % 128;
                int i14 = i13 % 2;
            } else {
                i2 = i;
            }
            if (i2 > 1) {
                extracallback.a = 0;
                while (extracallback.a < i2) {
                    extracallback.createBrowser = cArr[extracallback.a];
                    extracallback.c = cArr[extracallback.a + 1];
                    if (extracallback.createBrowser == extracallback.c) {
                        cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                        cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                        int i15 = $11 + 91;
                        $10 = i15 % 128;
                        int i16 = i15 % 2;
                    } else {
                        Object[] objArr4 = {extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1894223152);
                        if (objAccessartificialFrame3 == null) {
                            byte b6 = (byte) 0;
                            byte b7 = b6;
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", "", 0) + 46, (char) (58859 - View.MeasureSpec.getMode(0)), 2463 - TextUtils.lastIndexOf("", '0', 0, 0), 276640984, false, $$e(b6, b7, (byte) (b7 | 8)), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                        }
                        if (((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue() == extracallback.g) {
                            int i17 = $10 + 13;
                            $11 = i17 % 128;
                            int i18 = i17 % 2;
                            Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1361113423);
                            if (objAccessartificialFrame4 == null) {
                                byte b8 = (byte) 0;
                                byte b9 = b8;
                                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(ImageFormat.getBitsPerPixel(0) + 25, (char) ('0' - AndroidCharacter.getMirror('0')), 792 - Color.red(0), -834291897, false, $$e(b8, b9, (byte) (b9 + 5)), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                            }
                            int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                            int i19 = (extracallback.d * cCharValue) + extracallback.g;
                            cArr4[extracallback.a] = cArr2[iIntValue];
                            cArr4[extracallback.a + 1] = cArr2[i19];
                        } else if (extracallback.b == extracallback.d) {
                            int i20 = $10 + 47;
                            $11 = i20 % 128;
                            int i21 = i20 % 2;
                            extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                            extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                            int i22 = (extracallback.b * cCharValue) + extracallback.j;
                            int i23 = (extracallback.d * cCharValue) + extracallback.g;
                            cArr4[extracallback.a] = cArr2[i22];
                            cArr4[extracallback.a + 1] = cArr2[i23];
                        } else {
                            int i24 = (extracallback.b * cCharValue) + extracallback.g;
                            int i25 = (extracallback.d * cCharValue) + extracallback.j;
                            cArr4[extracallback.a] = cArr2[i24];
                            cArr4[extracallback.a + 1] = cArr2[i25];
                        }
                    }
                    extracallback.a += 2;
                }
            }
            for (int i26 = 0; i26 < i; i26++) {
                cArr4[i26] = (char) (cArr4[i26] ^ 13722);
            }
            objArr[0] = new String(cArr4);
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 == null) {
                throw th2;
            }
            throw cause2;
        }
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(Unknown Source)
        	at java.base/java.util.TreeMap.lastKey(Unknown Source)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] accessartificialFrame$78cbbd35(int r64, int r65, java.lang.Object r66, int r67, boolean r68) {
        /*
            Method dump skipped, instruction units count: 18858
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.color.utilities.QuantizerCelebi.accessartificialFrame$78cbbd35(int, int, java.lang.Object, int, boolean):java.lang.Object[]");
    }
}
