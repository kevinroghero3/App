package com.google.firebase;

import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;
import o.ICustomTabsCallbackDefault;
import o.artificialFrame;

/* JADX INFO: loaded from: classes3.dex */
public final class R {
    private R() {
    }

    public static final class raw {
        public static int firebase_common_keep = 0x7f100001;
        private static final byte[] $$c = {71, -70, 54, 33};
        private static final int $$d = 135;
        private static int $10 = 0;
        private static int $11 = 1;
        private static final byte[] $$a = {33, -82, -25, 84, 50, Ascii.SO, 3, Ascii.DC4, -49, Ascii.SYN, -3, 8, -50, Ascii.DLE, 5, 10, Ascii.DC2, Ascii.US, 5, Ascii.DLE, -9, Ascii.SO, -5, 8, 5, -9, 5, Ascii.VT, 32, 8, 6, -5, Ascii.SYN, -16, 36, 8, 3, 10, 4, 0, -8, Ascii.DC4, 10, 2, 5, -2, Ascii.DC2, 3, 1, -6, Ascii.GS, Ascii.ESC, Ascii.SYN, -16};
        private static final int $$b = 132;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static long coroutineBoundary = 175674120741031105L;
        private static int accessartificialFrame = -1151259316;
        private static char CoroutineDebuggingKt = 11596;
        private static int[] ICustomTabsCallbackStub = {126542971, -1094205565, 297133829, -142519640, -559871799, 275665893, 1363595457, -1538981481, 827258241, 1860917492, 1801811169, 675236509, -1429627813, -1297301211, 1674189630, 964888355, 1399762670, 2144397237};

        /* JADX WARN: Code duplicated, block: B:10:0x0023  */
        /* JADX WARN: Code duplicated, block: B:8:0x001d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0029). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$e(byte r7, int r8, int r9) {
            /*
                int r9 = r9 * 4
                int r9 = 1 - r9
                int r7 = r7 * 4
                int r7 = r7 + 4
                int r8 = r8 + 98
                byte[] r0 = com.google.firebase.R.raw.$$c
                byte[] r1 = new byte[r9]
                r2 = 0
                if (r0 != 0) goto L15
                r8 = r7
                r3 = r9
                r4 = r2
                goto L29
            L15:
                r3 = r2
            L16:
                int r4 = r3 + 1
                byte r5 = (byte) r8
                r1[r3] = r5
                if (r4 != r9) goto L23
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                return r7
            L23:
                r3 = r0[r7]
                r6 = r8
                r8 = r7
                r7 = r3
                r3 = r6
            L29:
                int r7 = -r7
                int r7 = r7 + r3
                int r8 = r8 + 1
                r3 = r4
                r6 = r8
                r8 = r7
                r7 = r6
                goto L16
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.R.raw.$$e(byte, int, int):java.lang.String");
        }

        private raw() {
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0022  */
        /* JADX WARN: Code duplicated, block: B:8:0x001a  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0027). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static void b(short r6, short r7, int r8, java.lang.Object[] r9) {
            /*
                int r7 = 51 - r7
                int r6 = r6 + 66
                byte[] r0 = com.google.firebase.R.raw.$$a
                int r1 = r8 + 2
                byte[] r1 = new byte[r1]
                int r8 = r8 + 1
                r2 = 0
                if (r0 != 0) goto L12
                r3 = r7
                r4 = r2
                goto L27
            L12:
                r3 = r2
            L13:
                byte r4 = (byte) r6
                r1[r3] = r4
                int r4 = r3 + 1
                if (r3 != r8) goto L22
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L22:
                r3 = r0[r7]
                r5 = r3
                r3 = r7
                r7 = r5
            L27:
                int r6 = r6 + r7
                int r7 = r3 + 1
                int r6 = r6 + (-5)
                r3 = r4
                goto L13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.R.raw.b(short, short, int, java.lang.Object[]):void");
        }

        private static void a(char[] cArr, int i, char[] cArr2, char c, char[] cArr3, Object[] objArr) throws Throwable {
            int i2;
            int i3 = 2;
            int i4 = 2 % 2;
            ICustomTabsCallbackDefault iCustomTabsCallbackDefault = new ICustomTabsCallbackDefault();
            int length = cArr2.length;
            char[] cArr4 = new char[length];
            int length2 = cArr.length;
            char[] cArr5 = new char[length2];
            int i5 = 0;
            System.arraycopy(cArr2, 0, cArr4, 0, length);
            System.arraycopy(cArr, 0, cArr5, 0, length2);
            cArr4[0] = (char) (cArr4[0] ^ c);
            cArr5[2] = (char) (cArr5[2] + ((char) i));
            int length3 = cArr3.length;
            char[] cArr6 = new char[length3];
            iCustomTabsCallbackDefault.a = 0;
            int i6 = $10 + 39;
            $11 = i6 % 128;
            int i7 = i6 % 2;
            while (iCustomTabsCallbackDefault.a < length3) {
                int i8 = $11 + 27;
                $10 = i8 % 128;
                int i9 = i8 % i3;
                try {
                    Object[] objArr2 = {iCustomTabsCallbackDefault};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-10548171);
                    if (objAccessartificialFrame == null) {
                        int iIndexOf = TextUtils.indexOf((CharSequence) "", '0', i5, i5) + 34;
                        char c2 = (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1);
                        int i10 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 1482;
                        byte b = (byte) i5;
                        byte b2 = (byte) (b + 1);
                        String str$$e = $$e(b, b2, (byte) (b2 - 1));
                        Class[] clsArr = new Class[1];
                        clsArr[i5] = Object.class;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iIndexOf, c2, i10, 1614432829, false, str$$e, clsArr);
                    }
                    int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                    Object[] objArr3 = {iCustomTabsCallbackDefault};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1818210492);
                    if (objAccessartificialFrame2 == null) {
                        int i11 = 33 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                        char touchSlop = (char) (49168 - (ViewConfiguration.getTouchSlop() >> 8));
                        int scrollDefaultDelay = 899 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                        byte b3 = (byte) i5;
                        byte b4 = (byte) (b3 + 3);
                        String str$$e2 = $$e(b3, b4, (byte) (b4 - 3));
                        Class[] clsArr2 = new Class[1];
                        clsArr2[i5] = Object.class;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i11, touchSlop, scrollDefaultDelay, 214239564, false, str$$e2, clsArr2);
                    }
                    int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                    int i12 = cArr4[iCustomTabsCallbackDefault.a % 4] * 32718;
                    Object[] objArr4 = new Object[3];
                    objArr4[2] = Integer.valueOf(cArr5[iIntValue]);
                    objArr4[1] = Integer.valueOf(i12);
                    objArr4[i5] = iCustomTabsCallbackDefault;
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1532285801);
                    if (objAccessartificialFrame3 == null) {
                        byte b5 = (byte) i5;
                        byte b6 = b5;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(KeyEvent.normalizeMetaState(i5) + 23, (char) (ExpandableListView.getPackedPositionChild(0L) + 1), 2489 - AndroidCharacter.getMirror('0'), -1003383455, false, $$e(b5, b6, b6), new Class[]{Object.class, Integer.TYPE, Integer.TYPE});
                    }
                    ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                    Object[] objArr5 = {Integer.valueOf(cArr4[iIntValue2] * 32718), Integer.valueOf(cArr5[iIntValue])};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-950633141);
                    if (objAccessartificialFrame4 == null) {
                        int offsetAfter = 20 - TextUtils.getOffsetAfter("", 0);
                        char cCombineMeasuredStates = (char) (View.combineMeasuredStates(0, 0) + 29754);
                        int doubleTapTimeout = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 1748;
                        byte b7 = (byte) 0;
                        byte b8 = (byte) (b7 + 2);
                        String str$$e3 = $$e(b7, b8, (byte) (b8 - 2));
                        i2 = 2;
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(offsetAfter, cCombineMeasuredStates, doubleTapTimeout, 1479752515, false, str$$e3, new Class[]{Integer.TYPE, Integer.TYPE});
                    } else {
                        i2 = 2;
                    }
                    cArr5[iIntValue2] = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).charValue();
                    cArr4[iIntValue2] = iCustomTabsCallbackDefault.MediaBrowserCompatApi21ConnectionCallback;
                    cArr6[iCustomTabsCallbackDefault.a] = (char) (((((long) (cArr4[iIntValue2] ^ cArr3[iCustomTabsCallbackDefault.a])) ^ (coroutineBoundary ^ (-899883803867009716L))) ^ ((long) ((int) (((long) accessartificialFrame) ^ (-899883803867009716L))))) ^ ((long) ((char) (((long) CoroutineDebuggingKt) ^ (-899883803867009716L)))));
                    iCustomTabsCallbackDefault.a++;
                    int i13 = $11 + 19;
                    $10 = i13 % 128;
                    int i14 = i13 % 2;
                    i3 = i2;
                    i5 = 0;
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

        private static void c(int i, int[] iArr, Object[] objArr) throws Throwable {
            int i2 = 2;
            int i3 = 2 % 2;
            artificialFrame artificialframe = new artificialFrame();
            char[] cArr = new char[4];
            char[] cArr2 = new char[iArr.length * 2];
            int[] iArr2 = ICustomTabsCallbackStub;
            int i4 = -1780896814;
            char c = '0';
            int i5 = 1;
            int i6 = 0;
            if (iArr2 != null) {
                int length = iArr2.length;
                int[] iArr3 = new int[length];
                int i7 = $11 + 123;
                $10 = i7 % 128;
                int i8 = i7 % 2;
                int i9 = 0;
                while (i9 < length) {
                    int i10 = $11 + 41;
                    $10 = i10 % 128;
                    int i11 = i10 % i2;
                    try {
                        Object[] objArr2 = {Integer.valueOf(iArr2[i9])};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i4);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) 0;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(Gravity.getAbsoluteGravity(0, 0) + 11, (char) (TextUtils.lastIndexOf("", c) + 1), 1562 - (Process.myTid() >> 22), 180153818, false, $$e(b, (byte) (b | Ascii.VT), b), new Class[]{Integer.TYPE});
                        }
                        iArr3[i9] = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                        i9++;
                        i2 = 2;
                        i4 = -1780896814;
                        c = '0';
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                iArr2 = iArr3;
            }
            int length2 = iArr2.length;
            int[] iArr4 = new int[length2];
            int[] iArr5 = ICustomTabsCallbackStub;
            if (iArr5 != null) {
                int length3 = iArr5.length;
                int[] iArr6 = new int[length3];
                int i12 = 0;
                while (i12 < length3) {
                    try {
                        Object[] objArr3 = new Object[i5];
                        objArr3[i6] = Integer.valueOf(iArr5[i12]);
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                        if (objAccessartificialFrame2 == null) {
                            byte b2 = (byte) i6;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(View.MeasureSpec.getMode(i6) + 11, (char) (ViewConfiguration.getLongPressTimeout() >> 16), AndroidCharacter.getMirror('0') + 1514, 180153818, false, $$e(b2, (byte) (b2 | Ascii.VT), b2), new Class[]{Integer.TYPE});
                        }
                        iArr6[i12] = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                        i12++;
                        i5 = 1;
                        i6 = 0;
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 == null) {
                            throw th2;
                        }
                        throw cause2;
                    }
                }
                iArr5 = iArr6;
            }
            int i13 = i6;
            System.arraycopy(iArr5, i13, iArr4, i13, length2);
            artificialframe.e = i13;
            while (artificialframe.e < iArr.length) {
                cArr[i13] = (char) (iArr[artificialframe.e] >> 16);
                cArr[1] = (char) iArr[artificialframe.e];
                cArr[2] = (char) (iArr[artificialframe.e + 1] >> 16);
                cArr[3] = (char) iArr[artificialframe.e + 1];
                artificialframe.c = (cArr[0] << 16) + cArr[1];
                artificialframe.b = (cArr[2] << 16) + cArr[3];
                artificialFrame.coroutineBoundary(iArr4);
                int i14 = 0;
                for (int i15 = 16; i14 < i15; i15 = 16) {
                    artificialframe.c ^= iArr4[i14];
                    Object[] objArr4 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                    if (objAccessartificialFrame3 == null) {
                        byte b3 = (byte) 0;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(26 - View.MeasureSpec.getMode(0), (char) View.getDefaultSize(0, 0), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1042, 995482881, false, $$e(b3, (byte) (b3 | 17), b3), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                    }
                    int iIntValue = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
                    artificialframe.c = artificialframe.b;
                    artificialframe.b = iIntValue;
                    i14++;
                }
                int i16 = artificialframe.c;
                artificialframe.c = artificialframe.b;
                artificialframe.b = i16;
                artificialframe.b ^= iArr4[16];
                artificialframe.c ^= iArr4[17];
                int i17 = artificialframe.c;
                int i18 = artificialframe.b;
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
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(36 - Process.getGidForName(""), (char) (View.MeasureSpec.getSize(0) + 28010), (ViewConfiguration.getTouchSlop() >> 8) + 306, -818175402, false, "q", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                i13 = 0;
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
        public static java.lang.Object[] accessartificialFrame$78cbbd35(int r68, int r69, java.lang.Object r70, int r71, boolean r72) {
            /*
                Method dump skipped, instruction units count: 20677
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.R.raw.accessartificialFrame$78cbbd35(int, int, java.lang.Object, int, boolean):java.lang.Object[]");
        }
    }
}
