package com.google.android.gms.auth;

import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import kotlin.io.encoding.Base64;
import o.ArtificialStackFrames;
import o.ICustomTabsCallbackDefault;

/* JADX INFO: loaded from: classes4.dex */
public final class R {
    private static final byte[] $$c = {71, Base64.padSymbol, 39, Base64.padSymbol};
    private static final int $$d = 214;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {46, 73, -9, 38, Ascii.VT, 2, -12};
    private static final int $$b = 34;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static long coroutineBoundary = 6271958752208583L;
    private static int accessartificialFrame = -1151259316;
    private static char CoroutineDebuggingKt = 11596;

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(short r6, byte r7, byte r8) {
        /*
            int r6 = 101 - r6
            int r8 = r8 * 4
            int r0 = 1 - r8
            byte[] r1 = com.google.android.gms.auth.R.$$c
            int r7 = r7 * 3
            int r7 = 3 - r7
            byte[] r0 = new byte[r0]
            r2 = 0
            int r8 = 0 - r8
            if (r1 != 0) goto L16
            r3 = r7
            r4 = r2
            goto L2c
        L16:
            r3 = r2
        L17:
            int r7 = r7 + 1
            byte r4 = (byte) r6
            r0[r3] = r4
            if (r3 != r8) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            return r6
        L24:
            int r3 = r3 + 1
            r4 = r1[r7]
            r5 = r3
            r3 = r7
            r7 = r4
            r4 = r5
        L2c:
            int r7 = -r7
            int r6 = r6 + r7
            r7 = r3
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.R.$$e(short, byte, byte):java.lang.String");
    }

    private R() {
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(int r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 2
            int r8 = r8 + 109
            int r7 = r7 * 3
            int r7 = 4 - r7
            int r6 = r6 * 2
            int r6 = r6 + 4
            byte[] r0 = com.google.android.gms.auth.R.$$a
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r8
            r5 = r2
            r8 = r7
            goto L29
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r8
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r7) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            r3 = r0[r6]
        L29:
            int r8 = r8 + r3
            int r8 = r8 + (-3)
            int r6 = r6 + 1
            r3 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.R.b(int, int, short, java.lang.Object[]):void");
    }

    private static void a(char[] cArr, int i, char[] cArr2, char c, char[] cArr3, Object[] objArr) throws Throwable {
        char c2;
        int i2 = 2 % 2;
        ICustomTabsCallbackDefault iCustomTabsCallbackDefault = new ICustomTabsCallbackDefault();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr.length;
        char[] cArr5 = new char[length2];
        int i3 = 0;
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr3.length;
        char[] cArr6 = new char[length3];
        iCustomTabsCallbackDefault.a = 0;
        int i4 = $10 + 47;
        $11 = i4 % 128;
        int i5 = i4 % 2;
        while (iCustomTabsCallbackDefault.a < length3) {
            int i6 = $11 + 9;
            $10 = i6 % 128;
            int i7 = i6 % 2;
            try {
                Object[] objArr2 = {iCustomTabsCallbackDefault};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-10548171);
                if (objAccessartificialFrame == null) {
                    int i8 = 34 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                    char offsetBefore = (char) TextUtils.getOffsetBefore("", i3);
                    int maximumDrawingCacheSize = 1483 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                    byte b = (byte) ($$d & 11);
                    byte b2 = (byte) (b - 2);
                    String str$$e = $$e(b, b2, b2);
                    Class[] clsArr = new Class[1];
                    clsArr[i3] = Object.class;
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i8, offsetBefore, maximumDrawingCacheSize, 1614432829, false, str$$e, clsArr);
                }
                int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                Object[] objArr3 = {iCustomTabsCallbackDefault};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1818210492);
                if (objAccessartificialFrame2 == null) {
                    byte b3 = (byte) i3;
                    byte b4 = b3;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(TextUtils.getCapsMode("", i3, i3) + 32, (char) (49168 - (ExpandableListView.getPackedPositionForGroup(i3) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(i3) == 0L ? 0 : -1))), 898 - TextUtils.indexOf((CharSequence) "", '0', i3, i3), 214239564, false, $$e(b3, b4, b4), new Class[]{Object.class});
                }
                int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                Object[] objArr4 = {iCustomTabsCallbackDefault, Integer.valueOf(cArr4[iCustomTabsCallbackDefault.a % 4] * 32718), Integer.valueOf(cArr5[iIntValue])};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1532285801);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) 3;
                    byte b6 = (byte) (b5 - 3);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(23 - TextUtils.indexOf("", "", 0), (char) View.MeasureSpec.getSize(0), 2441 - TextUtils.indexOf("", ""), -1003383455, false, $$e(b5, b6, b6), new Class[]{Object.class, Integer.TYPE, Integer.TYPE});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                Object[] objArr5 = {Integer.valueOf(cArr4[iIntValue2] * 32718), Integer.valueOf(cArr5[iIntValue])};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-950633141);
                if (objAccessartificialFrame4 == null) {
                    int windowTouchSlop = 20 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                    char doubleTapTimeout = (char) (29754 - (ViewConfiguration.getDoubleTapTimeout() >> 16));
                    int maximumDrawingCacheSize2 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 1748;
                    byte b7 = (byte) 1;
                    byte b8 = (byte) (b7 - 1);
                    String str$$e2 = $$e(b7, b8, b8);
                    c2 = 2;
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(windowTouchSlop, doubleTapTimeout, maximumDrawingCacheSize2, 1479752515, false, str$$e2, new Class[]{Integer.TYPE, Integer.TYPE});
                } else {
                    c2 = 2;
                }
                cArr5[iIntValue2] = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).charValue();
                cArr4[iIntValue2] = iCustomTabsCallbackDefault.MediaBrowserCompatApi21ConnectionCallback;
                cArr6[iCustomTabsCallbackDefault.a] = (char) (((((long) (cArr4[iIntValue2] ^ cArr3[iCustomTabsCallbackDefault.a])) ^ (coroutineBoundary ^ (-899883803867009716L))) ^ ((long) ((int) (((long) accessartificialFrame) ^ (-899883803867009716L))))) ^ ((long) ((char) (((long) CoroutineDebuggingKt) ^ (-899883803867009716L)))));
                iCustomTabsCallbackDefault.a++;
                i3 = 0;
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

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(Unknown Source)
        	at java.base/java.util.TreeMap.lastKey(Unknown Source)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] coroutineCreation(int r21, int r22) {
        /*
            Method dump skipped, instruction units count: 3532
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.R.coroutineCreation(int, int):java.lang.Object[]");
    }
}
