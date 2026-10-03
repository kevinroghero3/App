package org.simpleframework.xml.transform;

import android.graphics.Color;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;
import o.artificialFrame;

/* JADX INFO: loaded from: classes6.dex */
public class ArrayMatcher implements Matcher {
    private final Matcher primary;
    private static final byte[] $$c = {17, Ascii.ETB, -20, 88};
    private static final int $$d = 171;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {47, 75, -118, 7, -11, -2, Ascii.FF};
    private static final int $$b = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static int[] ICustomTabsCallbackStub = {-1224522450, -672292736, -829426655, 314934318, 1238099054, 234860945, -1173749731, -1679185040, 2108006206, -676197266, -2093493241, 125448419, 2128835037, 1967654369, 282316884, 1136378482, 1522726756, 2062896520};

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(short r7, short r8, short r9) {
        /*
            int r7 = r7 * 6
            int r7 = 115 - r7
            int r8 = r8 * 3
            int r8 = 1 - r8
            byte[] r0 = org.simpleframework.xml.transform.ArrayMatcher.$$c
            int r9 = r9 * 2
            int r9 = 4 - r9
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r9
            r4 = r2
            goto L29
        L16:
            r3 = r2
        L17:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r8) goto L24
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            return r7
        L24:
            r3 = r0[r9]
            r6 = r3
            r3 = r9
            r9 = r6
        L29:
            int r7 = r7 + r9
            int r9 = r3 + 1
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: org.simpleframework.xml.transform.ArrayMatcher.$$e(short, short, short):java.lang.String");
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
    private static void b(byte r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 2
            int r0 = 4 - r7
            byte[] r1 = org.simpleframework.xml.transform.ArrayMatcher.$$a
            int r8 = r8 * 3
            int r8 = 109 - r8
            int r6 = r6 * 4
            int r6 = r6 + 4
            byte[] r0 = new byte[r0]
            int r7 = 3 - r7
            r2 = 0
            if (r1 != 0) goto L18
            r3 = r7
            r4 = r2
            goto L2e
        L18:
            r3 = r2
        L19:
            byte r4 = (byte) r8
            r0[r3] = r4
            if (r3 != r7) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L26:
            int r3 = r3 + 1
            r4 = r1[r6]
            r5 = r3
            r3 = r8
            r8 = r4
            r4 = r5
        L2e:
            int r6 = r6 + 1
            int r8 = -r8
            int r3 = r3 + r8
            int r8 = r3 + (-3)
            r3 = r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: org.simpleframework.xml.transform.ArrayMatcher.b(byte, byte, short, java.lang.Object[]):void");
    }

    public ArrayMatcher(Matcher matcher) {
        this.primary = matcher;
    }

    @Override // org.simpleframework.xml.transform.Matcher
    public Transform match(Class cls) throws Exception {
        Class<?> componentType = cls.getComponentType();
        if (componentType == Character.TYPE) {
            return new CharacterArrayTransform(componentType);
        }
        if (componentType == Character.class) {
            return new CharacterArrayTransform(componentType);
        }
        if (componentType == String.class) {
            return new StringArrayTransform();
        }
        return matchArray(componentType);
    }

    private Transform matchArray(Class cls) throws Exception {
        Transform transformMatch = this.primary.match(cls);
        if (transformMatch == null) {
            return null;
        }
        return new ArrayTransform(transformMatch, cls);
    }

    private static void a(int i, int[] iArr, Object[] objArr) throws Throwable {
        int length;
        int[] iArr2;
        int i2;
        int i3 = 2 % 2;
        artificialFrame artificialframe = new artificialFrame();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr3 = ICustomTabsCallbackStub;
        int i4 = -1780896814;
        int i5 = 16;
        int i6 = 1;
        int i7 = 0;
        if (iArr3 != null) {
            int i8 = $11 + 117;
            $10 = i8 % 128;
            if (i8 % 2 != 0) {
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
                        int i9 = 12 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                        char scrollBarFadeDuration = (char) (ViewConfiguration.getScrollBarFadeDuration() >> i5);
                        int minimumFlingVelocity = 1562 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                        byte b = (byte) ($$d & 5);
                        byte b2 = (byte) (b - 1);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i9, scrollBarFadeDuration, minimumFlingVelocity, 180153818, false, $$e(b, b2, b2), new Class[]{Integer.TYPE});
                    }
                    iArr2[i2] = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                    i2++;
                    i4 = -1780896814;
                    i5 = 16;
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
        if (iArr5 != null) {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            int i10 = $10 + 59;
            $11 = i10 % 128;
            int i11 = i10 % 2;
            int i12 = 0;
            while (i12 < length3) {
                Object[] objArr3 = new Object[i6];
                objArr3[i7] = Integer.valueOf(iArr5[i12]);
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                if (objAccessartificialFrame2 == null) {
                    int scrollBarFadeDuration2 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 11;
                    char gidForName = (char) ((-1) - Process.getGidForName(""));
                    int iArgb = Color.argb(i7, i7, i7, i7) + 1562;
                    byte b3 = (byte) ($$d & 5);
                    byte b4 = (byte) (b3 - 1);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration2, gidForName, iArgb, 180153818, false, $$e(b3, b4, b4), new Class[]{Integer.TYPE});
                }
                iArr6[i12] = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                i12++;
                int i13 = $10 + 59;
                $11 = i13 % 128;
                int i14 = i13 % 2;
                iArr5 = iArr5;
                i6 = 1;
                i7 = 0;
            }
            iArr5 = iArr6;
        }
        int i15 = i7;
        System.arraycopy(iArr5, i15, iArr4, i15, length2);
        artificialframe.e = i15;
        while (artificialframe.e < iArr.length) {
            cArr[i15] = (char) (iArr[artificialframe.e] >> 16);
            cArr[1] = (char) iArr[artificialframe.e];
            cArr[2] = (char) (iArr[artificialframe.e + 1] >> 16);
            cArr[3] = (char) iArr[artificialframe.e + 1];
            artificialframe.c = (cArr[0] << 16) + cArr[1];
            artificialframe.b = (cArr[2] << 16) + cArr[3];
            artificialFrame.coroutineBoundary(iArr4);
            int i16 = 0;
            for (int i17 = 16; i16 < i17; i17 = 16) {
                artificialframe.c ^= iArr4[i16];
                Object[] objArr4 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) 0;
                    byte b6 = b5;
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 26, (char) (Color.rgb(0, 0, 0) + 16777216), 1041 - View.MeasureSpec.makeMeasureSpec(0, 0), 995482881, false, $$e(b5, b6, b6), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                }
                int iIntValue = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
                artificialframe.c = artificialframe.b;
                artificialframe.b = iIntValue;
                i16++;
            }
            int i18 = artificialframe.c;
            artificialframe.c = artificialframe.b;
            artificialframe.b = i18;
            artificialframe.b ^= iArr4[16];
            artificialframe.c ^= iArr4[17];
            int i19 = artificialframe.c;
            int i20 = artificialframe.b;
            cArr[0] = (char) (artificialframe.c >>> 16);
            cArr[1] = (char) artificialframe.c;
            cArr[2] = (char) (artificialframe.b >>> 16);
            cArr[3] = (char) artificialframe.b;
            artificialFrame.coroutineBoundary(iArr4);
            cArr2[artificialframe.e * 2] = cArr[0];
            cArr2[(artificialframe.e * 2) + 1] = cArr[1];
            cArr2[(artificialframe.e * 2) + 2] = cArr[2];
            cArr2[(artificialframe.e * 2) + 3] = cArr[3];
            try {
                Object[] objArr5 = {artificialframe, artificialframe};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1348396126);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(((Process.getThreadPriority(0) + 20) >> 6) + 37, (char) (28010 - (ViewConfiguration.getDoubleTapTimeout() >> 16)), TextUtils.indexOf((CharSequence) "", '0') + 307, -818175402, false, "q", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                int i21 = $11 + 43;
                $10 = i21 % 128;
                int i22 = i21 % 2;
                i15 = 0;
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        objArr[0] = new String(cArr2, 0, i);
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(Unknown Source)
        	at java.base/java.util.TreeMap.lastKey(Unknown Source)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] coroutineCreation(int r24, int r25) {
        /*
            Method dump skipped, instruction units count: 2848
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.simpleframework.xml.transform.ArrayMatcher.coroutineCreation(int, int):java.lang.Object[]");
    }
}
