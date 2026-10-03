package kotlin.random;

import android.graphics.Color;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import o.ArtificialStackFrames;
import o.ICustomTabsCallback;
import o.onRelationshipValidationResult;
import org.apache.commons.lang3.CharEncoding;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class RandomKt {
    private static byte[] ICustomTabsCallbackStubProxy;
    private static short[] ICustomTabsService;
    private static final byte[] $$c = {92, 49, Ascii.ETB, -93};
    private static final int $$d = 100;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {53, -94, -28, -114, -10, -4, -3, -20, -50, -14, 50, 5, -22, Ascii.DLE, 49, -32, -8, -6, -36, -8, -3, 0, 8, -20, 9, -14, 5, -27, -22, Ascii.DLE, 2, -18, -3, 9, -5, -11, -10, -2, -5, -10, -18, -22, 3, -8, -1, 6, -29, -31, -5, -16, -16, -5, -8, -5};
    private static final int $$b = 77;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static long onPostMessage = 3108036720571748152L;
    private static int onTransact = -313464221;
    private static int mayLaunchUrl = -81862434;
    private static int getInterfaceDescriptor = -269149534;

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(byte r6, int r7, byte r8) {
        /*
            int r6 = r6 * 4
            int r6 = r6 + 4
            int r8 = r8 + 111
            int r7 = r7 * 4
            int r7 = r7 + 1
            byte[] r0 = kotlin.random.RandomKt.$$c
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L15
            r8 = r6
            r3 = r7
            r4 = r2
            goto L2a
        L15:
            r3 = r2
        L16:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r7) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L23:
            r4 = r0[r6]
            r5 = r8
            r8 = r6
            r6 = r4
            r4 = r3
            r3 = r5
        L2a:
            int r6 = -r6
            int r6 = r6 + r3
            int r8 = r8 + 1
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r5
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.random.RandomKt.$$e(byte, int, byte):java.lang.String");
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
    private static void a(int r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = kotlin.random.RandomKt.$$a
            int r1 = 4 - r6
            int r8 = 52 - r8
            int r7 = r7 + 66
            byte[] r1 = new byte[r1]
            int r6 = 3 - r6
            r2 = 0
            if (r0 != 0) goto L13
            r7 = r6
            r3 = r8
            r4 = r2
            goto L28
        L13:
            r3 = r2
        L14:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L23:
            r3 = r0[r8]
            r5 = r3
            r3 = r8
            r8 = r5
        L28:
            int r8 = -r8
            int r7 = r7 + r8
            int r7 = r7 + (-5)
            int r8 = r3 + 1
            r3 = r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.random.RandomKt.a(int, short, byte, java.lang.Object[]):void");
    }

    public static final int takeUpperBits(int i, int i2) {
        return (i >>> (32 - i2)) & ((-i2) >> 31);
    }

    private static void b(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        onRelationshipValidationResult onrelationshipvalidationresult = new onRelationshipValidationResult();
        char[] cArrAccessartificialFrame = onRelationshipValidationResult.accessartificialFrame(onPostMessage ^ 2573525503365829440L, cArr, i);
        onrelationshipvalidationresult.e = 4;
        int i3 = $11 + 115;
        $10 = i3 % 128;
        int i4 = i3 % 2;
        while (onrelationshipvalidationresult.e < cArrAccessartificialFrame.length) {
            int i5 = $11 + 33;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            onrelationshipvalidationresult.d = onrelationshipvalidationresult.e - 4;
            int i7 = onrelationshipvalidationresult.e;
            try {
                Object[] objArr2 = {Long.valueOf(cArrAccessartificialFrame[onrelationshipvalidationresult.e] ^ cArrAccessartificialFrame[onrelationshipvalidationresult.e % 4]), Long.valueOf(onrelationshipvalidationresult.d), Long.valueOf(onPostMessage)};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(797310229);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(26 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) (30690 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))), 189 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), -1327449315, false, "k", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                }
                cArrAccessartificialFrame[i7] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                Object[] objArr3 = {onrelationshipvalidationresult, onrelationshipvalidationresult};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(321542193);
                if (objAccessartificialFrame2 == null) {
                    byte b = (byte) 0;
                    byte b2 = b;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 33, (char) TextUtils.indexOf("", "", 0), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 1483, -1940971975, false, $$e(b, b2, b2), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame2).invoke(null, objArr3);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        objArr[0] = new String(cArrAccessartificialFrame, 4, cArrAccessartificialFrame.length - 4);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:59:0x0276  */
    private static void c(int i, short s, byte b, int i2, int i3, Object[] objArr) throws Throwable {
        boolean z;
        int i4;
        boolean z2;
        int i5;
        int i6 = 2 % 2;
        ICustomTabsCallback iCustomTabsCallback = new ICustomTabsCallback();
        StringBuilder sb = new StringBuilder();
        try {
            Object[] objArr2 = {Integer.valueOf(i2), Integer.valueOf(mayLaunchUrl)};
            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1991297565);
            long j = 0;
            if (objAccessartificialFrame == null) {
                byte b2 = (byte) 0;
                byte b3 = b2;
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(Color.blue(0) + 40, (char) (36242 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 2341, 371880939, false, $$e(b2, b3, (byte) (b3 + 1)), new Class[]{Integer.TYPE, Integer.TYPE});
            }
            int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
            if (iIntValue == -1) {
                int i7 = $11 + 59;
                $10 = i7 % 128;
                int i8 = i7 % 2;
                z = true;
            } else {
                z = false;
            }
            if (z) {
                byte[] bArr = ICustomTabsCallbackStubProxy;
                if (bArr != null) {
                    int length = bArr.length;
                    byte[] bArr2 = new byte[length];
                    int i9 = $11 + 75;
                    $10 = i9 % 128;
                    int i10 = i9 % 2;
                    int i11 = 0;
                    while (i11 < length) {
                        Object[] objArr3 = {Integer.valueOf(bArr[i11])};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1557994855);
                        if (objAccessartificialFrame2 == null) {
                            int windowTouchSlop = 44 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                            char c = (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > j ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == j ? 0 : -1)) + 1);
                            int i12 = (ExpandableListView.getPackedPositionForChild(0, 0) > j ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == j ? 0 : -1)) + 1216;
                            byte b4 = (byte) 0;
                            byte b5 = b4;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(windowTouchSlop, c, i12, 1011328145, false, $$e(b4, b5, (byte) (b5 | 6)), new Class[]{Integer.TYPE});
                        }
                        bArr2[i11] = ((Byte) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).byteValue();
                        i11++;
                        j = 0;
                    }
                    int i13 = $10 + 123;
                    $11 = i13 % 128;
                    i5 = 2;
                    int i14 = i13 % 2;
                    bArr = bArr2;
                } else {
                    i5 = 2;
                }
                if (bArr != null) {
                    byte[] bArr3 = ICustomTabsCallbackStubProxy;
                    Object[] objArr4 = new Object[i5];
                    objArr4[1] = Integer.valueOf(onTransact);
                    objArr4[0] = Integer.valueOf(i);
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1991297565);
                    if (objAccessartificialFrame3 == null) {
                        byte b6 = (byte) 0;
                        byte b7 = b6;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0', 0) + 41, (char) (AndroidCharacter.getMirror('0') + 36193), 2342 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 371880939, false, $$e(b6, b7, (byte) (b7 + 1)), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    iIntValue = (byte) (((byte) (((long) bArr3[((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue()]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                } else {
                    iIntValue = (short) (((short) (((long) ICustomTabsService[i + ((int) (((long) onTransact) ^ (-4629754035390455669L)))]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                }
            }
            if (iIntValue > 0) {
                int i15 = $11;
                int i16 = i15 + 69;
                $10 = i16 % 128;
                int i17 = i16 % 2;
                int i18 = ((i + iIntValue) - 2) + ((int) (((long) onTransact) ^ (-4629754035390455669L)));
                if (z) {
                    int i19 = i15 + 29;
                    $10 = i19 % 128;
                    if (i19 % 2 != 0) {
                        i4 = 0;
                    } else {
                        i4 = 1;
                    }
                } else {
                    i4 = 0;
                }
                iCustomTabsCallback.c = i18 + i4;
                Object[] objArr5 = {iCustomTabsCallback, Integer.valueOf(i3), Integer.valueOf(getInterfaceDescriptor), sb};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(216546027);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(41 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (AndroidCharacter.getMirror('0') - '0'), 4067 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), -1819443997, false, "x", new Class[]{Object.class, Integer.TYPE, Integer.TYPE, Object.class});
                }
                ((StringBuilder) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).append(iCustomTabsCallback.createConnectionCallback);
                iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                byte[] bArr4 = ICustomTabsCallbackStubProxy;
                if (bArr4 != null) {
                    int length2 = bArr4.length;
                    byte[] bArr5 = new byte[length2];
                    int i20 = 0;
                    while (i20 < length2) {
                        int i21 = $11 + 5;
                        $10 = i21 % 128;
                        if (i21 % 2 != 0) {
                            bArr5[i20] = (byte) (((long) bArr4[i20]) / (-4629754035390455669L));
                        } else {
                            bArr5[i20] = (byte) (((long) bArr4[i20]) ^ (-4629754035390455669L));
                            i20++;
                        }
                    }
                    bArr4 = bArr5;
                }
                if (bArr4 != null) {
                    int i22 = $11 + 21;
                    $10 = i22 % 128;
                    if (i22 % 2 != 0) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                } else {
                    z2 = false;
                }
                iCustomTabsCallback.a = 1;
                while (iCustomTabsCallback.a < iIntValue) {
                    if (z2) {
                        byte[] bArr6 = ICustomTabsCallbackStubProxy;
                        int i23 = iCustomTabsCallback.c;
                        iCustomTabsCallback.c = i23 - 1;
                        iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((byte) (((byte) (((long) bArr6[i23]) ^ (-4629754035390455669L))) + s)) ^ b));
                    } else {
                        short[] sArr = ICustomTabsService;
                        int i24 = iCustomTabsCallback.c;
                        iCustomTabsCallback.c = i24 - 1;
                        iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((short) (((short) (((long) sArr[i24]) ^ (-4629754035390455669L))) + s)) ^ b));
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

    public static final Random Random(int i) {
        return new XorWowRandom(i, i >> 31);
    }

    public static final Random Random(long j) {
        return new XorWowRandom((int) j, (int) (j >> 32));
    }

    public static final int nextInt(@NotNull Random random, @NotNull IntRange range) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + range);
        }
        if (range.getLast() < Integer.MAX_VALUE) {
            return random.nextInt(range.getFirst(), range.getLast() + 1);
        }
        return range.getFirst() > Integer.MIN_VALUE ? random.nextInt(range.getFirst() - 1, range.getLast()) + 1 : random.nextInt();
    }

    public static final long nextLong(@NotNull Random random, @NotNull LongRange range) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (!range.isEmpty()) {
            if (range.getLast() < Long.MAX_VALUE) {
                return random.nextLong(range.getFirst(), range.getLast() + 1);
            }
            return range.getFirst() > Long.MIN_VALUE ? random.nextLong(range.getFirst() - 1, range.getLast()) + 1 : random.nextLong();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    public static final int fastLog2(int i) {
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    public static final void checkRangeBounds(int i, int i2) {
        if (i2 <= i) {
            throw new IllegalArgumentException(boundsErrorMessage(Integer.valueOf(i), Integer.valueOf(i2)).toString());
        }
    }

    public static final void checkRangeBounds(long j, long j2) {
        if (j2 <= j) {
            throw new IllegalArgumentException(boundsErrorMessage(Long.valueOf(j), Long.valueOf(j2)).toString());
        }
    }

    public static final void checkRangeBounds(double d, double d2) {
        if (d2 <= d) {
            throw new IllegalArgumentException(boundsErrorMessage(Double.valueOf(d), Double.valueOf(d2)).toString());
        }
    }

    public static final String boundsErrorMessage(@NotNull Object from, @NotNull Object until) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(until, "until");
        return "Random range is empty: [" + from + ", " + until + ").";
    }

    static {
        byte[] bArr = new byte[521];
        System.arraycopy("8~\u0081\u0088\u0089sv\u0083LzÏBr\u0081\u008aq\u008by\u0098v\u008a¼Brt\u008b¶0\u0080p\u008e±Gd\u0084½'8q\u009fq\u0087vu\u00889y\u0086yu\u0083\u0082;\u008ap\u008e\u008d:F\u007f\u0086~\u008c&\u00850\u0089\u009af\u008aÎ1\u008a\u0081}\u008a\u0086~\u0082s\u00882s\u009ad\u009aur\u008bv\u0087v|v\u00899\u0084\u007f}\u0083\u008c~9Ez\u0080vpu4\u008d\u0082u\u008d}\u0083\u007f\u0088\u0086|\u007f\u0080y\u0093`\u0089\u009af\u008a:\u0089\u0089du\u008a0u\u008a\u0098f\u008aÍ0\u0086`\u009a~\u0080p\u0086e?\u007f\u0098z\u0080\u0089\u0089du>E\u007f\u0098z\u0080\u0089\u0089du=Zzt\u008dv\u0086\u0089\u0089du1\u0082s\u008e\u0081s\u0089x\u0098p}\u008ey\u0082r<J\u008e\u008c¸I\u0083z\u008aq\u008dÏI\u0089z\u0088\u0082s\u0082½<\u0088\u008c\u008ev\u008cyÏ7\u0086¼7q\u008dÏ<\u008e\u008cdÏI\u0083z\u008aq\u008dÏ;\u008e\u008cdÏ$d\u0084½3\u008a\u008f\u008c±As\u0088\u007f\u0098¿4v=~\u0089t\u0082us\u008a\u0086c\u009d6t\u0089\u0083\u008fv\u008ea\u0089Î@f\u0088Î1\u0080p\u008e9r\u008ep\u008br\u0088I\u008b\u0085\u0089\u008b\u0089\u0089`\u008e\u008bvÏ0q\u008dÎ1\u008a\u0081}\u008a\u0086~<H\u0080u\u007f\u0088¶Ef\u0098v¾0J\u008e\u008c¸H\u0080u\u007f\u0088¶Ef\u0098v¾7J\u008e\u008caÂH\u0080u\u007f\u0088¶Ef\u0098v¾:J\u008e\u008cdÏ70w\u0098¼tJ\u008e\u008c¸I\u0083z\u008aq\u008dÏ0J\u008e\u008caÂ@zÏI\u0083z\u008aq\u008dÏO0\u008e\u008bvÎBt\u008b|ÊCeÃ6tuÍI\u0083z\u008aq\u008dÏ3J\u008e\u008caÂI\u0083z\u008aq\u008dÏ?J\u008e\u008c¸6tuÍ8J\u008e\u008c¸1\u0089Ï7t\u008dr\u008d\u0089µBq\u008cyÏG\u007fv\u0089Ê:E¯\u0087v^=s\u0081\u0089etÀ2\u009a\u008a¾0\u0088wx\u0081\u009f\u00adLr\u0086~µF`\u009e|%r\u0088;\u0089\u009af\u008a".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 521);
        ICustomTabsCallbackStubProxy = bArr;
    }

    /* JADX WARN: Multi-variable search skipped. Vars limit reached: 7721 (expected less than 5000) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r1v659 */
    /* JADX WARN: Type inference failed for: r1v660 */
    /* JADX WARN: Type inference failed for: r1v661 */
    /* JADX WARN: Type inference failed for: r1v662 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r33v3 */
    /* JADX WARN: Type inference failed for: r40v35, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r40v36 */
    /* JADX WARN: Type inference failed for: r40v40 */
    /* JADX WARN: Type inference failed for: r40v45 */
    /* JADX WARN: Type inference failed for: r40v46 */
    /* JADX WARN: Type inference failed for: r40v48 */
    /* JADX WARN: Type inference failed for: r40v90 */
    /* JADX WARN: Type inference failed for: r40v91 */
    /* JADX WARN: Type inference failed for: r40v92 */
    /* JADX WARN: Type inference failed for: r40v93 */
    /* JADX WARN: Type inference failed for: r43v13 */
    /* JADX WARN: Type inference failed for: r43v16 */
    /* JADX WARN: Type inference failed for: r43v18, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r43v38 */
    /* JADX WARN: Type inference failed for: r43v47 */
    /* JADX WARN: Type inference failed for: r5v257 */
    /* JADX WARN: Type inference failed for: r5v258, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v277 */
    /* JADX WARN: Type inference failed for: r5v278 */
    /* JADX WARN: Type inference failed for: r5v286, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r5v457 */
    /* JADX WARN: Type inference failed for: r5v458 */
    /* JADX WARN: Type inference failed for: r5v482, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r5v494 */
    /* JADX WARN: Type inference failed for: r5v71 */
    /* JADX WARN: Type inference failed for: r5v72 */
    /* JADX WARN: Type inference failed for: r5v73, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v74 */
    /* JADX WARN: Type inference failed for: r5v75, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r5v813 */
    /* JADX WARN: Type inference failed for: r5v814 */
    /* JADX WARN: Type inference failed for: r5v815 */
    /* JADX WARN: Type inference failed for: r5v816 */
    /* JADX WARN: Type inference failed for: r5v817 */
    /* JADX WARN: Type inference failed for: r5v88 */
    /* JADX WARN: Type inference failed for: r6v347 */
    /* JADX WARN: Type inference failed for: r6v348 */
    /* JADX WARN: Type inference failed for: r6v357, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r6v690 */
    /* JADX WARN: Type inference failed for: r7v1111 */
    /* JADX WARN: Type inference failed for: r7v1112 */
    /* JADX WARN: Type inference failed for: r7v333, types: [java.util.regex.Pattern] */
    /* JADX WARN: Type inference failed for: r7v558 */
    /* JADX WARN: Type inference failed for: r7v559, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r7v637 */
    /* JADX WARN: Type inference failed for: r7v638 */
    /* JADX WARN: Type inference failed for: r7v650, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r9v275, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v276 */
    /* JADX WARN: Type inference failed for: r9v277, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r9v528 */
    /* JADX WARN: Type inference failed for: r9v530 */
    /* JADX WARN: Type inference failed for: r9v708 */
    /* JADX WARN: Type inference failed for: r9v709 */
    /* JADX WARN: Type inference failed for: r9v710 */
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
            Method dump skipped, instruction units count: 20072
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.random.RandomKt.accessartificialFrame$78cbbd35(int, int, java.lang.Object, int, boolean):java.lang.Object[]");
    }
}
