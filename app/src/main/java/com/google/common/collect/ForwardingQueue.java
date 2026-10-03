package com.google.common.collect;

import android.graphics.ImageFormat;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import java.util.Queue;
import javax.annotation.CheckForNull;
import kotlin.text.Typography;
import o.ArtificialStackFrames;
import o.ICustomTabsCallback;
import o._CREATION;

/* JADX INFO: loaded from: classes5.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingQueue<E> extends ForwardingCollection<E> implements Queue<E> {
    private static short[] ICustomTabsService;
    private static final byte[] $$a = {87, 9, 66, Ascii.SYN};
    private static final int $$b = JfifUtil.MARKER_RST0;
    private static int $10 = 0;
    private static int $11 = 1;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] _CREATION = {6548, 39799, 7256, 37159, 4646, 38744, 2301, 36291, 3805, 33699, 1180, 34415, 15210, 48207, 12640, 45575, 14091, 43234, 11718, 44776, 9126, 42179, 9790, 56086, 23568, 53518, 21083, 55222, 18606, 52710, 20156, 50063, 17552, 50805, 31559, 64566, 28991, 61978, 56734, 24328, 55384, 21814, 54865, 21274, 52368, 18884, 51955, 18321, 49343, 16970, 65364, 30833, 62785, 30214, 62227, 27784, 59852, 27275, 59289, 24743, 57922, 8044, 39033, 5461, 38409, 5056, 36063, 2528, 35466, 6559, 39800, 7242, 37172, 4657, 38687, 2282, 36232, 3805, 33721, 1152, 34418, 15227, 48216, 12602, 45640, 14141, 43257, 11712, 44722, 9147, 42126, 9850, 15870, 48916, 14397, 46449, 13912, 45938, 11394, 43424, 10942, 42964, 8388, 41472, 7959, 38960, 5454, 38500, 4971, 10242, 43749, 11735, 41129, 9132, 42626, 14711, 48149, 16192, 45604, 13597, 47087, 2790, 36293, Typography.section, 33749, 1683, 39270, 7197, 40715, 4642, 38152, 6136, 60122, 28100, 57518, 25534, 59002, 31085, 64586, 32564, 61982, 29969, 14537, 47674, 15663, 45180, 13161, 46672, 10636, 44183, 12175, 41716, 9684, 10865, 43163, 12200, 41675, 8644, 42239, 15122, 48683, 15637, 45147, 14196, 46490, 2207, 36792, 719, 33261, 1271, 39690, 7715, 33407, 149, 34748, 2803, 35277, 3314, 37634, 5669, 38203, 6212, 40784, 7637, 41160, 10208, 43768, 10738, 44273, 13086, 46635, 13641, 47176, 16241, 48516};
    private static long _BOUNDARY = 4978211497469123350L;
    private static int onTransact = -1406924344;
    private static int mayLaunchUrl = -81862463;
    private static int getInterfaceDescriptor = 1808610309;
    private static byte[] ICustomTabsCallbackStubProxy = {94, 117, -109, 113, -100, 67, 112, 113, 118, -123, 125, -90, -113, 101, -88, 78, 121, -104, 118, -86, -81, 55, 112, 113, 118, -123, 125, -90, -113, 100, -128, 79, 115, -121, -104, 98, 117, -115, 125, -125, -119, -102, 87, -124, 117, 79, -126, 115, -82, 111, 117, -115, 125, -125, -119, -102, 87, -124, 117, 95, -126, 115, -82, 111, 117, -115, 125, -125, -119, -102, -87, 74, 118, -55, 49, -115, -126, 122, -115, 116, -121, -66, 65, 112, 113, 118, -123, 125, -122, 75, -123, 120, 118, -118, -104, 120, -116, 117, 125, 48, -126, 112, -116, 93, 80, -116, -120, 112, -102, -119, -112, 106, 122, -104, 117, 113, -120, 118, 126, -119, -122, -87, -98, 49, -119, -122, -119, -66, 62, -114, -128, 124, 118, -103, 117, 121, -50, 70, 96, -98, 124, 74, -119, 126, -122, 102, -118, -114, -82, 94, -124, 117, 89, 120, 118, -118, -104, 120, -116, 117, -99, -82, 74, 118, -55, 49, -115, -126, 122, -115, 116, -121, -66, 65, 112, 113, 118, -123, 125, -122, 83, 122, -104, 117, 113, -120, 118, 126, -119, -122, -87, -127, -126, 112, 86, -95, 49, -119, -122, -119, -66, 62, -114, -128, 124, 118, -103, 117, 121, -50, 70, 96, -98, 124};

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0027). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$c(int r7, byte r8, short r9) {
        /*
            int r7 = 117 - r7
            int r8 = r8 * 4
            int r8 = r8 + 1
            byte[] r0 = com.google.common.collect.ForwardingQueue.$$a
            int r9 = r9 * 4
            int r9 = 4 - r9
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
            r3 = r7
            r7 = r6
        L27:
            int r9 = r9 + 1
            int r7 = r7 + r3
            r3 = r5
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ForwardingQueue.$$c(int, byte, short):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract Queue<E> delegate();

    public boolean offer(@ParametricNullness E e) {
        return delegate().offer(e);
    }

    @Override // java.util.Queue
    @CheckForNull
    public E poll() {
        return delegate().poll();
    }

    @Override // java.util.Queue
    @ParametricNullness
    public E remove() {
        return delegate().remove();
    }

    @Override // java.util.Queue
    @CheckForNull
    public E peek() {
        return delegate().peek();
    }

    @Override // java.util.Queue
    @ParametricNullness
    public E element() {
        return delegate().element();
    }

    private static void a(char c, int i, int i2, Object[] objArr) throws Throwable {
        int i3 = 2;
        int i4 = 2 % 2;
        _CREATION _creation = new _CREATION();
        long[] jArr = new long[i2];
        _creation.b = 0;
        while (_creation.b < i2) {
            int i5 = $11 + 17;
            $10 = i5 % 128;
            if (i5 % i3 != 0) {
                int i6 = _creation.b;
                try {
                    Object[] objArr2 = {Integer.valueOf(_CREATION[i * i6])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) 0;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getTapTimeout() >> 16) + 8, (char) (9278 - TextUtils.lastIndexOf("", '0')), 1978 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 1113883676, false, $$c((byte) 13, b, b), new Class[]{Integer.TYPE});
                    }
                    Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i6), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                    if (objAccessartificialFrame2 == null) {
                        byte b2 = (byte) 0;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(30 - Gravity.getAbsoluteGravity(0, 0), (char) (49362 - (ViewConfiguration.getLongPressTimeout() >> 16)), (ViewConfiguration.getTapTimeout() >> 16) + 684, -115095555, false, $$c((byte) 11, b2, b2), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                    }
                    jArr[i6] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                    Object[] objArr4 = {_creation, _creation};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                    if (objAccessartificialFrame3 == null) {
                        byte b3 = (byte) 0;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(ExpandableListView.getPackedPositionGroup(0L) + 25, (char) (30067 - TextUtils.lastIndexOf("", '0')), 816 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 1897803493, false, $$c((byte) 14, b3, b3), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } else {
                int i7 = _creation.b;
                try {
                    Object[] objArr5 = {Integer.valueOf(_CREATION[i + i7])};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-587087340);
                    if (objAccessartificialFrame4 == null) {
                        byte b4 = (byte) 0;
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(8 - TextUtils.indexOf("", ""), (char) (9278 - ImageFormat.getBitsPerPixel(0)), 1977 - (ViewConfiguration.getLongPressTimeout() >> 16), 1113883676, false, $$c((byte) 13, b4, b4), new Class[]{Integer.TYPE});
                    }
                    try {
                        Object[] objArr6 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).longValue()), Long.valueOf(i7), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                        Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1715896821);
                        if (objAccessartificialFrame5 == null) {
                            byte b5 = (byte) 0;
                            objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(29 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) (49362 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), 684 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), -115095555, false, $$c((byte) 11, b5, b5), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                        }
                        jArr[i7] = ((Long) ((Method) objAccessartificialFrame5).invoke(null, objArr6)).longValue();
                        try {
                            Object[] objArr7 = {_creation, _creation};
                            Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-293902099);
                            if (objAccessartificialFrame6 == null) {
                                byte b6 = (byte) 0;
                                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(ExpandableListView.getPackedPositionChild(0L) + 26, (char) (ExpandableListView.getPackedPositionType(0L) + 30068), 816 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 1897803493, false, $$c((byte) 14, b6, b6), new Class[]{Object.class, Object.class});
                            }
                            ((Method) objAccessartificialFrame6).invoke(null, objArr7);
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
            i3 = 2;
        }
        char[] cArr = new char[i2];
        _creation.b = 0;
        int i8 = $11 + 15;
        $10 = i8 % 128;
        int i9 = i8 % 2;
        while (_creation.b < i2) {
            cArr[_creation.b] = (char) jArr[_creation.b];
            Object[] objArr8 = {_creation, _creation};
            Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-293902099);
            if (objAccessartificialFrame7 == null) {
                byte b7 = (byte) 0;
                objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(View.MeasureSpec.getSize(0) + 25, (char) (View.resolveSizeAndState(0, 0, 0) + 30068), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 816, 1897803493, false, $$c((byte) 14, b7, b7), new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame7).invoke(null, objArr8);
        }
        objArr[0] = new String(cArr);
    }

    protected boolean standardOffer(@ParametricNullness E e) {
        try {
            return add(e);
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @CheckForNull
    protected E standardPeek() {
        try {
            return element();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }

    @CheckForNull
    protected E standardPoll() {
        try {
            return remove();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x019a  */
    private static void b(int i, short s, byte b, int i2, int i3, Object[] objArr) throws Throwable {
        long j;
        int i4;
        int i5 = 2 % 2;
        ICustomTabsCallback iCustomTabsCallback = new ICustomTabsCallback();
        StringBuilder sb = new StringBuilder();
        try {
            Object[] objArr2 = {Integer.valueOf(i2), Integer.valueOf(mayLaunchUrl)};
            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1991297565);
            if (objAccessartificialFrame == null) {
                byte b2 = (byte) 5;
                byte b3 = (byte) (b2 - 5);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 39, (char) (KeyEvent.getDeadChar(0, 0) + 36241), 2342 - ExpandableListView.getPackedPositionType(0L), 371880939, false, $$c(b2, b3, b3), new Class[]{Integer.TYPE, Integer.TYPE});
            }
            int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
            boolean z = iIntValue == -1;
            char c = '0';
            if (z) {
                byte[] bArr = ICustomTabsCallbackStubProxy;
                if (bArr != null) {
                    int length = bArr.length;
                    byte[] bArr2 = new byte[length];
                    int i6 = 0;
                    while (i6 < length) {
                        Object[] objArr3 = {Integer.valueOf(bArr[i6])};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1557994855);
                        if (objAccessartificialFrame2 == null) {
                            int i7 = 44 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                            char scrollDefaultDelay = (char) (ViewConfiguration.getScrollDefaultDelay() >> 16);
                            int iLastIndexOf = TextUtils.lastIndexOf("", c, 0) + 1216;
                            byte b4 = (byte) 0;
                            byte b5 = b4;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i7, scrollDefaultDelay, iLastIndexOf, 1011328145, false, $$c(b4, b5, b5), new Class[]{Integer.TYPE});
                        }
                        bArr2[i6] = ((Byte) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).byteValue();
                        i6++;
                        c = '0';
                    }
                    bArr = bArr2;
                }
                if (bArr != null) {
                    byte[] bArr3 = ICustomTabsCallbackStubProxy;
                    Object[] objArr4 = {Integer.valueOf(i), Integer.valueOf(onTransact)};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1991297565);
                    if (objAccessartificialFrame3 == null) {
                        byte b6 = (byte) 5;
                        byte b7 = (byte) (b6 - 5);
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(40 - TextUtils.getCapsMode("", 0, 0), (char) (MotionEvent.axisFromString("") + 36242), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 2341, 371880939, false, $$c(b6, b7, b7), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    iIntValue = (byte) (((byte) (((long) bArr3[((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue()]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                    j = -4629754035390455669L;
                } else {
                    j = -4629754035390455669L;
                    iIntValue = (short) (((short) (((long) ICustomTabsService[i + ((int) (((long) onTransact) ^ (-4629754035390455669L)))]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                }
            } else {
                j = -4629754035390455669L;
            }
            if (iIntValue > 0) {
                int i8 = ((i + iIntValue) - 2) + ((int) (((long) onTransact) ^ j));
                if (z) {
                    int i9 = $10 + 91;
                    $11 = i9 % 128;
                    if (i9 % 2 == 0) {
                        i4 = 0;
                    } else {
                        i4 = 1;
                    }
                } else {
                    i4 = 0;
                }
                iCustomTabsCallback.c = i8 + i4;
                Object[] objArr5 = {iCustomTabsCallback, Integer.valueOf(i3), Integer.valueOf(getInterfaceDescriptor), sb};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(216546027);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(40 - ExpandableListView.getPackedPositionChild(0L), (char) (AndroidCharacter.getMirror('0') - '0'), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 4067, -1819443997, false, "x", new Class[]{Object.class, Integer.TYPE, Integer.TYPE, Object.class});
                }
                ((StringBuilder) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).append(iCustomTabsCallback.createConnectionCallback);
                iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                byte[] bArr4 = ICustomTabsCallbackStubProxy;
                if (bArr4 != null) {
                    int i10 = $10 + 63;
                    $11 = i10 % 128;
                    int i11 = i10 % 2;
                    int length2 = bArr4.length;
                    byte[] bArr5 = new byte[length2];
                    for (int i12 = 0; i12 < length2; i12++) {
                        bArr5[i12] = (byte) (((long) bArr4[i12]) ^ (-4629754035390455669L));
                    }
                    bArr4 = bArr5;
                }
                boolean z2 = bArr4 != null;
                iCustomTabsCallback.a = 1;
                while (iCustomTabsCallback.a < iIntValue) {
                    if (z2) {
                        byte[] bArr6 = ICustomTabsCallbackStubProxy;
                        int i13 = iCustomTabsCallback.c;
                        iCustomTabsCallback.c = i13 - 1;
                        iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((byte) (((byte) (((long) bArr6[i13]) ^ (-4629754035390455669L))) + s)) ^ b));
                    } else {
                        short[] sArr = ICustomTabsService;
                        int i14 = iCustomTabsCallback.c;
                        iCustomTabsCallback.c = i14 - 1;
                        iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((short) (((short) (((long) sArr[i14]) ^ (-4629754035390455669L))) + s)) ^ b));
                    }
                    sb.append(iCustomTabsCallback.createConnectionCallback);
                    iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                    iCustomTabsCallback.a++;
                }
            }
            objArr[0] = sb.toString();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
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
    public static java.lang.Object[] accessartificialFrame(android.content.Context r39, int r40, int r41) {
        /*
            Method dump skipped, instruction units count: 3935
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ForwardingQueue.accessartificialFrame(android.content.Context, int, int):java.lang.Object[]");
    }
}
