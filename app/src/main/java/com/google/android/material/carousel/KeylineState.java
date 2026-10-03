package com.google.android.material.carousel;

import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.FloatRange;
import com.facebook.imageutils.JfifUtil;
import com.google.android.material.animation.AnimationUtils;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import o.ArtificialStackFrames;
import o.ICustomTabsCallbackDefault;
import o.asBinder;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public final class KeylineState {
    private final int firstFocalKeylineIndex;
    private final float itemSize;
    private final List<Keyline> keylines;
    private final int lastFocalKeylineIndex;

    private KeylineState(float f, List<Keyline> list, int i, int i2) {
        this.itemSize = f;
        this.keylines = Collections.unmodifiableList(list);
        this.firstFocalKeylineIndex = i;
        this.lastFocalKeylineIndex = i2;
    }

    public static final class Keyline {
        final float cutoff;
        final boolean isAnchor;
        final float leftOrTopPaddingShift;
        final float loc;
        final float locOffset;
        final float mask;
        final float maskedItemSize;
        final float rightOrBottomPaddingShift;
        private static final byte[] $$c = {65, Ascii.SYN, 92, -30};
        private static final int $$d = JfifUtil.MARKER_SOS;
        private static int $10 = 0;
        private static int $11 = 1;
        private static final byte[] $$a = {35, -18, 33, -64, -10, -4, -50, -14, -3, -20, 50, -1, 6, -29, -16, -5, -10, -18, 0, 8, -20, -31, -5, -16, 9, -14, 5, -27, -22, Ascii.DLE, 9, -5, -11, -22, 3, -8, 5, -22, Ascii.DLE, -1, 2, -18, -3, 49, -10, -2, -5, -8, -5, -36, -8, -3, -32, -8, -6};
        private static final int $$b = 123;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static long coroutineBoundary = -899883803867009716L;
        private static int accessartificialFrame = -1151259316;
        private static char CoroutineDebuggingKt = 48468;
        private static long extraCommand = 3106448336101590922L;

        /* JADX WARN: Code duplicated, block: B:10:0x0022  */
        /* JADX WARN: Code duplicated, block: B:8:0x001c  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x002a). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$e(int r6, int r7, int r8) {
            /*
                byte[] r0 = com.google.android.material.carousel.KeylineState.Keyline.$$c
                int r7 = r7 + 98
                int r6 = r6 * 4
                int r1 = 1 - r6
                int r8 = r8 * 2
                int r8 = 4 - r8
                byte[] r1 = new byte[r1]
                r2 = 0
                int r6 = 0 - r6
                if (r0 != 0) goto L16
                r3 = r8
                r4 = r2
                goto L2a
            L16:
                r3 = r2
            L17:
                byte r4 = (byte) r7
                r1[r3] = r4
                if (r3 != r6) goto L22
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                return r6
            L22:
                r4 = r0[r8]
                int r3 = r3 + 1
                r5 = r3
                r3 = r7
                r7 = r4
                r4 = r5
            L2a:
                int r8 = r8 + 1
                int r7 = -r7
                int r7 = r7 + r3
                r3 = r4
                goto L17
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.carousel.KeylineState.Keyline.$$e(int, int, int):java.lang.String");
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0024  */
        /* JADX WARN: Code duplicated, block: B:8:0x001c  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0026). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static void a(byte r7, byte r8, short r9, java.lang.Object[] r10) {
            /*
                byte[] r0 = com.google.android.material.carousel.KeylineState.Keyline.$$a
                int r7 = r7 + 4
                int r8 = r8 + 2
                int r9 = r9 + 66
                byte[] r1 = new byte[r8]
                r2 = 0
                if (r0 != 0) goto L11
                r9 = r7
                r3 = r8
                r4 = r2
                goto L26
            L11:
                r3 = r2
                r6 = r9
                r9 = r7
                r7 = r6
            L15:
                int r4 = r3 + 1
                byte r5 = (byte) r7
                r1[r3] = r5
                if (r4 != r8) goto L24
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L24:
                r3 = r0[r9]
            L26:
                int r3 = -r3
                int r7 = r7 + r3
                int r7 = r7 + (-5)
                int r9 = r9 + 1
                r3 = r4
                goto L15
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.carousel.KeylineState.Keyline.a(byte, byte, short, java.lang.Object[]):void");
        }

        /* JADX WARN: Code duplicated, block: B:51:0x025b  */
        /* JADX WARN: Code duplicated, block: B:52:0x025c  */
        private static void c(int i, char[] cArr, Object[] objArr) throws Throwable {
            Object obj;
            Throwable cause;
            int i2 = 2 % 2;
            asBinder asbinder = new asBinder();
            asbinder.c = i;
            int length = cArr.length;
            long[] jArr = new long[length];
            asbinder.d = 0;
            while (true) {
                obj = null;
                if (asbinder.d >= cArr.length) {
                    break;
                }
                int i3 = $11 + 27;
                $10 = i3 % 128;
                if (i3 % 2 != 0) {
                    int i4 = asbinder.d;
                    try {
                        Object[] objArr2 = {Integer.valueOf(cArr[asbinder.d]), asbinder, asbinder};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1562553046);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) 0;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getEdgeSlop() >> 16) + 11, (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 1407, 1035473698, false, $$e(b, (byte) (b | Ascii.DC4), b), new Class[]{Integer.TYPE, Object.class, Object.class});
                        }
                        jArr[i4] = ((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue() + (extraCommand & (-2360974883025274865L));
                        Object[] objArr3 = {asbinder, asbinder};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                        if (objAccessartificialFrame2 == null) {
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0', 0, 0) + 9, (char) (Process.myTid() >> 22), TextUtils.indexOf("", "", 0) + 249, 378009232, false, "w", new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                    } catch (Throwable th) {
                        cause = th.getCause();
                        if (cause != null) {
                            throw th;
                        }
                        throw cause;
                    }
                } else {
                    int i5 = asbinder.d;
                    Object[] objArr4 = {Integer.valueOf(cArr[asbinder.d]), asbinder, asbinder};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1562553046);
                    if (objAccessartificialFrame3 == null) {
                        byte b2 = (byte) 0;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 10, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), 1407 - ExpandableListView.getPackedPositionType(0L), 1035473698, false, $$e(b2, (byte) (b2 | Ascii.DC4), b2), new Class[]{Integer.TYPE, Object.class, Object.class});
                    }
                    jArr[i5] = ((Long) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).longValue() ^ (extraCommand ^ (-2360974883025274865L));
                    Object[] objArr5 = {asbinder, asbinder};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                    if (objAccessartificialFrame4 == null) {
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(((Process.getThreadPriority(0) + 20) >> 6) + 8, (char) (ViewConfiguration.getWindowTouchSlop() >> 8), ((Process.getThreadPriority(0) + 20) >> 6) + 249, 378009232, false, "w", new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                }
                cause = th.getCause();
                if (cause != null) {
                    throw th;
                }
                throw cause;
            }
            char[] cArr2 = new char[length];
            asbinder.d = 0;
            int i6 = $10 + 67;
            $11 = i6 % 128;
            int i7 = i6 % 2;
            while (asbinder.d < cArr.length) {
                int i8 = $10 + 61;
                $11 = i8 % 128;
                if (i8 % 2 == 0) {
                    cArr2[asbinder.d] = (char) jArr[asbinder.d];
                    Object[] objArr6 = {asbinder, asbinder};
                    Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                    if (objAccessartificialFrame5 == null) {
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(TextUtils.getOffsetAfter("", 0) + 8, (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1), KeyEvent.normalizeMetaState(0) + 249, 378009232, false, "w", new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame5).invoke(null, objArr6);
                    obj.hashCode();
                    throw null;
                }
                cArr2[asbinder.d] = (char) jArr[asbinder.d];
                Object[] objArr7 = {asbinder, asbinder};
                Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame6 == null) {
                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(7 - TextUtils.indexOf((CharSequence) "", '0'), (char) View.combineMeasuredStates(0, 0), 249 - (Process.myPid() >> 22), 378009232, false, "w", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame6).invoke(null, objArr7);
            }
            objArr[0] = new String(cArr2);
        }

        private static void b(char[] cArr, int i, char[] cArr2, char c, char[] cArr3, Object[] objArr) throws Throwable {
            int i2 = 2;
            int i3 = 2 % 2;
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
            while (iCustomTabsCallbackDefault.a < length3) {
                int i4 = $10 + 63;
                $11 = i4 % 128;
                int i5 = i4 % i2;
                try {
                    Object[] objArr2 = {iCustomTabsCallbackDefault};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-10548171);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) 0;
                        byte b2 = (byte) (b + 1);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(33 - (ViewConfiguration.getTapTimeout() >> 16), (char) Gravity.getAbsoluteGravity(0, 0), 1483 - KeyEvent.getDeadChar(0, 0), 1614432829, false, $$e(b, b2, (byte) (b2 - 1)), new Class[]{Object.class});
                    }
                    int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                    try {
                        Object[] objArr3 = {iCustomTabsCallbackDefault};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1818210492);
                        if (objAccessartificialFrame2 == null) {
                            byte b3 = (byte) 0;
                            byte b4 = (byte) (b3 + 3);
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(32 - KeyEvent.keyCodeFromString(""), (char) (49169 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), View.combineMeasuredStates(0, 0) + 899, 214239564, false, $$e(b3, b4, (byte) (b4 - 3)), new Class[]{Object.class});
                        }
                        int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                        try {
                            Object[] objArr4 = {iCustomTabsCallbackDefault, Integer.valueOf(cArr4[iCustomTabsCallbackDefault.a % 4] * 32718), Integer.valueOf(cArr5[iIntValue])};
                            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1532285801);
                            if (objAccessartificialFrame3 == null) {
                                byte b5 = (byte) 0;
                                byte b6 = b5;
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(Gravity.getAbsoluteGravity(0, 0) + 23, (char) View.getDefaultSize(0, 0), 2441 - (ViewConfiguration.getLongPressTimeout() >> 16), -1003383455, false, $$e(b5, b6, b6), new Class[]{Object.class, Integer.TYPE, Integer.TYPE});
                            }
                            ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                            try {
                                Object[] objArr5 = {Integer.valueOf(cArr4[iIntValue2] * 32718), Integer.valueOf(cArr5[iIntValue])};
                                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-950633141);
                                if (objAccessartificialFrame4 == null) {
                                    byte b7 = (byte) 0;
                                    byte b8 = (byte) (b7 + 2);
                                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(21 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 29753), View.resolveSizeAndState(0, 0, 0) + 1748, 1479752515, false, $$e(b7, b8, (byte) (b8 - 2)), new Class[]{Integer.TYPE, Integer.TYPE});
                                }
                                cArr5[iIntValue2] = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).charValue();
                                cArr4[iIntValue2] = iCustomTabsCallbackDefault.MediaBrowserCompatApi21ConnectionCallback;
                                cArr6[iCustomTabsCallbackDefault.a] = (char) (((((long) (cArr3[iCustomTabsCallbackDefault.a] ^ cArr4[iIntValue2])) ^ (coroutineBoundary ^ (-899883803867009716L))) ^ ((long) ((int) (((long) accessartificialFrame) ^ (-899883803867009716L))))) ^ ((long) ((char) (((long) CoroutineDebuggingKt) ^ (-899883803867009716L)))));
                                iCustomTabsCallbackDefault.a++;
                                int i6 = $11 + 95;
                                $10 = i6 % 128;
                                int i7 = i6 % 2;
                                i2 = 2;
                            } catch (Throwable th) {
                                Throwable cause = th.getCause();
                                if (cause == null) {
                                    throw th;
                                }
                                throw cause;
                            }
                        } catch (Throwable th2) {
                            Throwable cause2 = th2.getCause();
                            if (cause2 == null) {
                                throw th2;
                            }
                            throw cause2;
                        }
                    } catch (Throwable th3) {
                        Throwable cause3 = th3.getCause();
                        if (cause3 == null) {
                            throw th3;
                        }
                        throw cause3;
                    }
                } catch (Throwable th4) {
                    Throwable cause4 = th4.getCause();
                    if (cause4 == null) {
                        throw th4;
                    }
                    throw cause4;
                }
            }
            objArr[0] = new String(cArr6);
        }

        Keyline(float f, float f2, float f3, float f4) {
            this(f, f2, f3, f4, false, 0.0f, 0.0f, 0.0f);
        }

        Keyline(float f, float f2, float f3, float f4, boolean z, float f5, float f6, float f7) {
            this.loc = f;
            this.locOffset = f2;
            this.mask = f3;
            this.maskedItemSize = f4;
            this.isAnchor = z;
            this.cutoff = f5;
            this.leftOrTopPaddingShift = f6;
            this.rightOrBottomPaddingShift = f7;
        }

        static Keyline lerp(Keyline keyline, Keyline keyline2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
            return new Keyline(AnimationUtils.lerp(keyline.loc, keyline2.loc, f), AnimationUtils.lerp(keyline.locOffset, keyline2.locOffset, f), AnimationUtils.lerp(keyline.mask, keyline2.mask, f), AnimationUtils.lerp(keyline.maskedItemSize, keyline2.maskedItemSize, f));
        }

        /* JADX WARN: Multi-variable search skipped. Vars limit reached: 7324 (expected less than 5000) */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v692 */
        /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
            java.util.NoSuchElementException
            	at java.base/java.util.TreeMap.key(Unknown Source)
            	at java.base/java.util.TreeMap.lastKey(Unknown Source)
            	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
            	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
            	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
            */
        public static java.lang.Object[] accessartificialFrame$78cbbd35(int r65, int r66, java.lang.Object r67, int r68, boolean r69) {
            /*
                Method dump skipped, instruction units count: 20873
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.carousel.KeylineState.Keyline.accessartificialFrame$78cbbd35(int, int, java.lang.Object, int, boolean):java.lang.Object[]");
        }
    }

    float getItemSize() {
        return this.itemSize;
    }

    List<Keyline> getKeylines() {
        return this.keylines;
    }

    Keyline getFirstFocalKeyline() {
        return this.keylines.get(this.firstFocalKeylineIndex);
    }

    int getFirstFocalKeylineIndex() {
        return this.firstFocalKeylineIndex;
    }

    Keyline getLastFocalKeyline() {
        return this.keylines.get(this.lastFocalKeylineIndex);
    }

    int getLastFocalKeylineIndex() {
        return this.lastFocalKeylineIndex;
    }

    List<Keyline> getFocalKeylines() {
        return this.keylines.subList(this.firstFocalKeylineIndex, this.lastFocalKeylineIndex + 1);
    }

    Keyline getFirstKeyline() {
        return this.keylines.get(0);
    }

    Keyline getLastKeyline() {
        List<Keyline> list = this.keylines;
        return list.get(list.size() - 1);
    }

    Keyline getFirstNonAnchorKeyline() {
        for (int i = 0; i < this.keylines.size(); i++) {
            Keyline keyline = this.keylines.get(i);
            if (!keyline.isAnchor) {
                return keyline;
            }
        }
        return null;
    }

    Keyline getLastNonAnchorKeyline() {
        for (int size = this.keylines.size() - 1; size >= 0; size--) {
            Keyline keyline = this.keylines.get(size);
            if (!keyline.isAnchor) {
                return keyline;
            }
        }
        return null;
    }

    int getNumberOfNonAnchorKeylines() {
        Iterator<Keyline> it2 = this.keylines.iterator();
        int i = 0;
        while (it2.hasNext()) {
            if (it2.next().isAnchor) {
                i++;
            }
        }
        return this.keylines.size() - i;
    }

    static KeylineState lerp(KeylineState keylineState, KeylineState keylineState2, float f) {
        if (keylineState.getItemSize() != keylineState2.getItemSize()) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same item size.");
        }
        List<Keyline> keylines = keylineState.getKeylines();
        List<Keyline> keylines2 = keylineState2.getKeylines();
        if (keylines.size() != keylines2.size()) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same number of keylines.");
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < keylineState.getKeylines().size(); i++) {
            arrayList.add(Keyline.lerp(keylines.get(i), keylines2.get(i), f));
        }
        return new KeylineState(keylineState.getItemSize(), arrayList, AnimationUtils.lerp(keylineState.getFirstFocalKeylineIndex(), keylineState2.getFirstFocalKeylineIndex(), f), AnimationUtils.lerp(keylineState.getLastFocalKeylineIndex(), keylineState2.getLastFocalKeylineIndex(), f));
    }

    static KeylineState reverse(KeylineState keylineState, float f) {
        Builder builder = new Builder(keylineState.getItemSize(), f);
        float f2 = (f - keylineState.getLastKeyline().locOffset) - (keylineState.getLastKeyline().maskedItemSize / 2.0f);
        int size = keylineState.getKeylines().size() - 1;
        while (size >= 0) {
            Keyline keyline = keylineState.getKeylines().get(size);
            builder.addKeyline(f2 + (keyline.maskedItemSize / 2.0f), keyline.mask, keyline.maskedItemSize, size >= keylineState.getFirstFocalKeylineIndex() && size <= keylineState.getLastFocalKeylineIndex(), keyline.isAnchor);
            f2 += keyline.maskedItemSize;
            size--;
        }
        return builder.build();
    }

    /* JADX INFO: loaded from: classes5.dex */
    static final class Builder {
        private static final int NO_INDEX = -1;
        private static final float UNKNOWN_LOC = Float.MIN_VALUE;
        private final float availableSpace;
        private final float itemSize;
        private Keyline tmpFirstFocalKeyline;
        private Keyline tmpLastFocalKeyline;
        private final List<Keyline> tmpKeylines = new ArrayList();
        private int firstFocalKeylineIndex = -1;
        private int lastFocalKeylineIndex = -1;
        private float lastKeylineMaskedSize = 0.0f;
        private int latestAnchorKeylineIndex = -1;

        private static float calculateKeylineLocationForItemPosition(float f, float f2, int i, int i2) {
            return (f - (i * f2)) + (i2 * f2);
        }

        Builder(float f, float f2) {
            this.itemSize = f;
            this.availableSpace = f2;
        }

        Builder addKeyline(float f, @FloatRange(from = 0.0d, to = 1.0d) float f2, float f3, boolean z) {
            return addKeyline(f, f2, f3, z, false);
        }

        Builder addKeyline(float f, @FloatRange(from = 0.0d, to = 1.0d) float f2, float f3) {
            return addKeyline(f, f2, f3, false);
        }

        Builder addKeyline(float f, @FloatRange(from = 0.0d, to = 1.0d) float f2, float f3, boolean z, boolean z2, float f4, float f5, float f6) {
            if (f3 <= 0.0f) {
                return this;
            }
            if (z2) {
                if (z) {
                    throw new IllegalArgumentException("Anchor keylines cannot be focal.");
                }
                int i = this.latestAnchorKeylineIndex;
                if (i != -1 && i != 0) {
                    throw new IllegalArgumentException("Anchor keylines must be either the first or last keyline.");
                }
                this.latestAnchorKeylineIndex = this.tmpKeylines.size();
            }
            Keyline keyline = new Keyline(Float.MIN_VALUE, f, f2, f3, z2, f4, f5, f6);
            if (z) {
                if (this.tmpFirstFocalKeyline == null) {
                    this.tmpFirstFocalKeyline = keyline;
                    this.firstFocalKeylineIndex = this.tmpKeylines.size();
                }
                if (this.lastFocalKeylineIndex != -1 && this.tmpKeylines.size() - this.lastFocalKeylineIndex > 1) {
                    throw new IllegalArgumentException("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
                }
                if (f3 != this.tmpFirstFocalKeyline.maskedItemSize) {
                    throw new IllegalArgumentException("Keylines that are marked as focal must all have the same masked item size.");
                }
                this.tmpLastFocalKeyline = keyline;
                this.lastFocalKeylineIndex = this.tmpKeylines.size();
            } else {
                if (this.tmpFirstFocalKeyline == null && keyline.maskedItemSize < this.lastKeylineMaskedSize) {
                    throw new IllegalArgumentException("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
                }
                if (this.tmpLastFocalKeyline != null && keyline.maskedItemSize > this.lastKeylineMaskedSize) {
                    throw new IllegalArgumentException("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
                }
            }
            this.lastKeylineMaskedSize = keyline.maskedItemSize;
            this.tmpKeylines.add(keyline);
            return this;
        }

        Builder addKeyline(float f, @FloatRange(from = 0.0d, to = 1.0d) float f2, float f3, boolean z, boolean z2, float f4) {
            return addKeyline(f, f2, f3, z, z2, f4, 0.0f, 0.0f);
        }

        Builder addKeyline(float f, @FloatRange(from = 0.0d, to = 1.0d) float f2, float f3, boolean z, boolean z2) {
            float fAbs;
            float f4 = f3 / 2.0f;
            float f5 = f - f4;
            float f6 = f4 + f;
            float f7 = this.availableSpace;
            if (f6 > f7) {
                fAbs = Math.abs(f6 - Math.max(f6 - f3, f7));
            } else {
                fAbs = 0.0f;
                if (f5 < 0.0f) {
                    fAbs = Math.abs(f5 - Math.min(f5 + f3, 0.0f));
                }
            }
            return addKeyline(f, f2, f3, z, z2, fAbs);
        }

        Builder addAnchorKeyline(float f, @FloatRange(from = 0.0d, to = 1.0d) float f2, float f3) {
            return addKeyline(f, f2, f3, false, true);
        }

        Builder addKeylineRange(float f, @FloatRange(from = 0.0d, to = 1.0d) float f2, float f3, int i) {
            return addKeylineRange(f, f2, f3, i, false);
        }

        Builder addKeylineRange(float f, @FloatRange(from = 0.0d, to = 1.0d) float f2, float f3, int i, boolean z) {
            if (i > 0 && f3 > 0.0f) {
                for (int i2 = 0; i2 < i; i2++) {
                    addKeyline((i2 * f3) + f, f2, f3, z);
                }
            }
            return this;
        }

        KeylineState build() {
            if (this.tmpFirstFocalKeyline == null) {
                throw new IllegalStateException("There must be a keyline marked as focal.");
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.tmpKeylines.size(); i++) {
                Keyline keyline = this.tmpKeylines.get(i);
                arrayList.add(new Keyline(calculateKeylineLocationForItemPosition(this.tmpFirstFocalKeyline.locOffset, this.itemSize, this.firstFocalKeylineIndex, i), keyline.locOffset, keyline.mask, keyline.maskedItemSize, keyline.isAnchor, keyline.cutoff, keyline.leftOrTopPaddingShift, keyline.rightOrBottomPaddingShift));
            }
            return new KeylineState(this.itemSize, arrayList, this.firstFocalKeylineIndex, this.lastFocalKeylineIndex);
        }
    }
}
