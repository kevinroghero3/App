package com.google.crypto.tink.prf;

import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.util.SecretBytes;
import com.google.errorprone.annotations.Immutable;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;
import o.ArtificialStackFrames;
import o._CREATION;
import o.asBinder;

/* JADX INFO: loaded from: classes2.dex */
@Immutable
public final class HmacPrfKey extends PrfKey {
    private final SecretBytes keyBytes;
    private final HmacPrfParameters parameters;
    private static final byte[] $$c = {67, 111, Ascii.EM, 19};
    private static final int $$d = b.i;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {122, -14, -75, -84, -50, -14, -3, -20, 50, 5, -22, Ascii.DLE, -22, 3, -8, -1, 6, -29, -1, -10, -18, 0, 8, -20, -27, -22, Ascii.DLE, -16, -5, 9, -5, -11, -10, -2, -5, -31, -5, -16, -36, -8, -3, -32, -8, -6, -8, -5, -10, -4, 9, -14, 5, 2, -18, -3};
    private static final int $$b = JfifUtil.MARKER_APP1;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] _CREATION = {59658, 19962, 41100, 2007, 31405, 53675, 13458, 27508, 52849, 9567, 39007, 12067, 35782, 26354, 49639, 48278, 6028, 62137, 44375, 6540, 48508, 20490, 63305, 35384, 8496, 50196, 39920, 16117, 54751, 26770, 4028, 41603, 31129, 7549, 45179, 22351, 59936, 33056, 9244, 64264, 40682, 13778, 6609, 48502, 20560, 63322, 35429, 8502, 50206, 39916, 16098, 54660, 26832, 4029, 41609, 31123, 7461, 45177, 22347, 59937, 33057, 9230, 64285, 40686, 13762, 51417, 28579, 757, 55710, 32098, 24440, 64392, 5886, 45481, 52443, 26569, 33521, 56598, 30725, 37694, 11818, 18761, 58483, 6607, 29780, 53436, 15757, 39597, 59370, 19697, 43458, 63037, 2480, 44372, 16507, 59232, 39429, 12551, 54334, 13400, 37046, 32135, 55947, 42990, 3308, 59847, 46625, 4901, 6546, 48508, 20547, 63305, 35375, 8493, 50179, 39916, 16101, 54751, 26770, 4002, 41622, 31126, 7546, 45161, 46907, 5076, 65278, 23023, 9357, 36747, 27307, 13659, 6541, 48487, 20549, 63307, 35390, 8448, 50183, 39916, 16098, 54723, 26851, 4029, 41613, 31124, 7523, 45180, 22345, 59942, 33082, 9245, 48590, 6436, 62485, 21275, 11882, 34169, 36672, 11179, 6538, 48481, 20549, 63322, 35375, 8495, 50193, 39921, 16126, 54685, 6538, 48481, 20549, 63322, 35375, 8493, 50207, 39920, 16098, 54734, 26762, 38388, 12614, 56435, 31603, 1548, 44373, 18470, 6085, 45791, 23016, 58550, 33671, 11955, 62899, 37209, 15437, 56184, 6609, 48503, 20545, 63311, 52574, 27119, 34002, 9157, 24241, 62901, 4242, 28121, 51560, 9301, 33602, 65078, 21810, 45077, 61346, 19196, 41418, 7386, 34777, 9064, 52821, 26946, 5174, 48946, 23061, 1442, 41197, 19393, 63197, 37303, 39424, 16052, 54160, 29830, 2559, 41697, 18387, 6267, 48421, 22035, 60163, 31757, 55484, 13722, 37516, 61432, 6540, 48486, 20554, 63319, 35363, 8497, 50199, 14433, 40135, 29173, 55037, 43931, 192, 58796, 47706, 8005, 62586, 18784, 11854, 33578, 22565, 15569, 37315, 30385, 18944, 61105, 919, 42113, 55797, 29345, 6609, 48480, 20573, 63306, 35390, 8506, 50205, 39850, 16116, 54722, 26834, 4094, 41676, 31122, 7536, 45161, 22273, 6609, 48480, 20573, 63306, 35390, 8506, 50205, 39850, 16110, 54729, 26837, 4031, 41677, 64674, 22547, 46370, 4709, 28507, 50245, 8557, 32473, 58999, 17112, 45037, 2282, 30082, 56973, 15269, 9027, 34789, 27347, 52701, 45303, 7095, 65179, 41328, 1133, 61258, 21061};
    private static long _BOUNDARY = 1282310848557333779L;
    private static long extraCommand = -3845952227562467084L;

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0025). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(byte r5, short r6, int r7) {
        /*
            int r5 = r5 + 103
            int r7 = r7 * 2
            int r0 = r7 + 1
            byte[] r1 = com.google.crypto.tink.prf.HmacPrfKey.$$c
            int r6 = r6 * 3
            int r6 = r6 + 4
            byte[] r0 = new byte[r0]
            r2 = 0
            if (r1 != 0) goto L15
            r4 = r5
            r5 = r7
            r3 = r2
            goto L25
        L15:
            r3 = r2
        L16:
            byte r4 = (byte) r5
            r0[r3] = r4
            if (r3 != r7) goto L21
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            return r5
        L21:
            r4 = r1[r6]
            int r3 = r3 + 1
        L25:
            int r5 = r5 + r4
            int r6 = r6 + 1
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.prf.HmacPrfKey.$$e(byte, short, int):java.lang.String");
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
    private static void b(byte r5, int r6, int r7, java.lang.Object[] r8) {
        /*
            int r7 = 115 - r7
            int r0 = 4 - r6
            int r5 = 50 - r5
            byte[] r1 = com.google.crypto.tink.prf.HmacPrfKey.$$a
            byte[] r0 = new byte[r0]
            int r6 = 3 - r6
            r2 = 0
            if (r1 != 0) goto L12
            r3 = r6
            r4 = r2
            goto L26
        L12:
            r3 = r2
        L13:
            int r5 = r5 + 1
            byte r4 = (byte) r7
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L24
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            r8[r2] = r5
            return
        L24:
            r3 = r1[r5]
        L26:
            int r3 = -r3
            int r7 = r7 + r3
            int r7 = r7 + (-5)
            r3 = r4
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.prf.HmacPrfKey.b(byte, int, int, java.lang.Object[]):void");
    }

    @Override // com.google.crypto.tink.Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return null;
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class Builder {

        @Nullable
        private SecretBytes keyBytes;

        @Nullable
        private HmacPrfParameters parameters;

        private Builder() {
            this.parameters = null;
            this.keyBytes = null;
        }

        public Builder setParameters(HmacPrfParameters hmacPrfParameters) {
            this.parameters = hmacPrfParameters;
            return this;
        }

        public Builder setKeyBytes(SecretBytes secretBytes) {
            this.keyBytes = secretBytes;
            return this;
        }

        public HmacPrfKey build() throws GeneralSecurityException {
            HmacPrfParameters hmacPrfParameters = this.parameters;
            if (hmacPrfParameters == null || this.keyBytes == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            }
            if (hmacPrfParameters.getKeySizeBytes() != this.keyBytes.size()) {
                throw new GeneralSecurityException("Key size mismatch");
            }
            return new HmacPrfKey(this.parameters, this.keyBytes);
        }
    }

    private HmacPrfKey(HmacPrfParameters hmacPrfParameters, SecretBytes secretBytes) {
        this.parameters = hmacPrfParameters;
        this.keyBytes = secretBytes;
    }

    public static Builder builder() {
        return new Builder();
    }

    private static void c(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2;
        int i3 = 2 % 2;
        asBinder asbinder = new asBinder();
        asbinder.c = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        asbinder.d = 0;
        while (asbinder.d < cArr.length) {
            int i4 = $11 + 29;
            $10 = i4 % 128;
            int i5 = i4 % i2;
            int i6 = asbinder.d;
            char c = cArr[asbinder.d];
            try {
                Object[] objArr2 = new Object[3];
                objArr2[i2] = asbinder;
                objArr2[1] = asbinder;
                objArr2[0] = Integer.valueOf(c);
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1562553046);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) 0;
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 11, (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1), 1407 - TextUtils.getTrimmedLength(""), 1035473698, false, $$e((byte) 15, b, b), new Class[]{Integer.TYPE, Object.class, Object.class});
                }
                jArr[i6] = ((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue() ^ (extraCommand ^ (-2360974883025274865L));
                Object[] objArr3 = {asbinder, asbinder};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame2 == null) {
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 8, (char) (TextUtils.lastIndexOf("", '0') + 1), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 248, 378009232, false, "w", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                i2 = 2;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        char[] cArr2 = new char[length];
        asbinder.d = 0;
        while (asbinder.d < cArr.length) {
            cArr2[asbinder.d] = (char) jArr[asbinder.d];
            Object[] objArr4 = {asbinder, asbinder};
            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1981632360);
            if (objAccessartificialFrame3 == null) {
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(8 - Gravity.getAbsoluteGravity(0, 0), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 249, 378009232, false, "w", new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame3).invoke(null, objArr4);
            int i7 = $10 + 17;
            $11 = i7 % 128;
            int i8 = i7 % 2;
        }
        objArr[0] = new String(cArr2);
    }

    public SecretBytes getKeyBytes() {
        return this.keyBytes;
    }

    @Override // com.google.crypto.tink.prf.PrfKey, com.google.crypto.tink.Key
    public HmacPrfParameters getParameters() {
        return this.parameters;
    }

    private static void a(char c, int i, int i2, Object[] objArr) throws Throwable {
        int i3 = 2 % 2;
        _CREATION _creation = new _CREATION();
        long[] jArr = new long[i2];
        _creation.b = 0;
        while (_creation.b < i2) {
            int i4 = _creation.b;
            try {
                Object[] objArr2 = {Integer.valueOf(_CREATION[i + i4])};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                if (objAccessartificialFrame == null) {
                    int modifierMetaStateMask = 7 - ((byte) KeyEvent.getModifierMetaStateMask());
                    char threadPriority = (char) (((Process.getThreadPriority(0) + 20) >> 6) + 9279);
                    int capsMode = 1977 - TextUtils.getCapsMode("", 0, 0);
                    byte b = (byte) ($$d & 1);
                    byte b2 = (byte) (b - 1);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask, threadPriority, capsMode, 1113883676, false, $$e(b, b2, b2), new Class[]{Integer.TYPE});
                }
                Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i4), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                if (objAccessartificialFrame2 == null) {
                    int scrollBarSize = 30 - (ViewConfiguration.getScrollBarSize() >> 8);
                    char modifierMetaStateMask2 = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 49363);
                    int tapTimeout = 684 - (ViewConfiguration.getTapTimeout() >> 16);
                    byte b3 = (byte) ($$d & 11);
                    byte b4 = (byte) (b3 - 3);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(scrollBarSize, modifierMetaStateMask2, tapTimeout, -115095555, false, $$e(b3, b4, b4), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                }
                jArr[i4] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                Object[] objArr4 = {_creation, _creation};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) 0;
                    byte b6 = b5;
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(TextUtils.getOffsetBefore("", 0) + 25, (char) ((ViewConfiguration.getScrollBarSize() >> 8) + 30068), 816 - ExpandableListView.getPackedPositionType(0L), 1897803493, false, $$e(b5, b6, b6), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        char[] cArr = new char[i2];
        _creation.b = 0;
        while (_creation.b < i2) {
            int i5 = $10 + 121;
            $11 = i5 % 128;
            int i6 = i5 % 2;
            cArr[_creation.b] = (char) jArr[_creation.b];
            Object[] objArr5 = {_creation, _creation};
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-293902099);
            if (objAccessartificialFrame4 == null) {
                byte b7 = (byte) 0;
                byte b8 = b7;
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 24, (char) (30068 - (ViewConfiguration.getScrollBarFadeDuration() >> 16)), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 816, 1897803493, false, $$e(b7, b8, b8), new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame4).invoke(null, objArr5);
            int i7 = $11 + 97;
            $10 = i7 % 128;
            int i8 = i7 % 2;
        }
        objArr[0] = new String(cArr);
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key key) {
        if (!(key instanceof HmacPrfKey)) {
            return false;
        }
        HmacPrfKey hmacPrfKey = (HmacPrfKey) key;
        return hmacPrfKey.parameters.equals(this.parameters) && hmacPrfKey.keyBytes.equalsSecretBytes(this.keyBytes);
    }

    /* JADX WARN: Multi-variable search skipped. Vars limit reached: 7357 (expected less than 5000) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1258 */
    /* JADX WARN: Type inference failed for: r2v478 */
    /* JADX WARN: Type inference failed for: r2v479, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v524, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r3v366, types: [java.util.regex.Pattern] */
    /* JADX WARN: Type inference failed for: r44v10 */
    /* JADX WARN: Type inference failed for: r44v11 */
    /* JADX WARN: Type inference failed for: r44v12 */
    /* JADX WARN: Type inference failed for: r44v13 */
    /* JADX WARN: Type inference failed for: r44v14 */
    /* JADX WARN: Type inference failed for: r44v15 */
    /* JADX WARN: Type inference failed for: r44v16 */
    /* JADX WARN: Type inference failed for: r44v17 */
    /* JADX WARN: Type inference failed for: r44v18 */
    /* JADX WARN: Type inference failed for: r44v19 */
    /* JADX WARN: Type inference failed for: r44v20 */
    /* JADX WARN: Type inference failed for: r44v21 */
    /* JADX WARN: Type inference failed for: r44v22 */
    /* JADX WARN: Type inference failed for: r44v23, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r44v25 */
    /* JADX WARN: Type inference failed for: r44v26 */
    /* JADX WARN: Type inference failed for: r44v27 */
    /* JADX WARN: Type inference failed for: r44v29 */
    /* JADX WARN: Type inference failed for: r44v30 */
    /* JADX WARN: Type inference failed for: r44v31 */
    /* JADX WARN: Type inference failed for: r44v32 */
    /* JADX WARN: Type inference failed for: r44v33 */
    /* JADX WARN: Type inference failed for: r44v34 */
    /* JADX WARN: Type inference failed for: r44v35 */
    /* JADX WARN: Type inference failed for: r44v36 */
    /* JADX WARN: Type inference failed for: r44v37 */
    /* JADX WARN: Type inference failed for: r44v38 */
    /* JADX WARN: Type inference failed for: r44v39 */
    /* JADX WARN: Type inference failed for: r44v4 */
    /* JADX WARN: Type inference failed for: r44v40 */
    /* JADX WARN: Type inference failed for: r44v41 */
    /* JADX WARN: Type inference failed for: r44v42 */
    /* JADX WARN: Type inference failed for: r44v5 */
    /* JADX WARN: Type inference failed for: r44v6 */
    /* JADX WARN: Type inference failed for: r44v8 */
    /* JADX WARN: Type inference failed for: r4v1113 */
    /* JADX WARN: Type inference failed for: r4v249, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r4v401 */
    /* JADX WARN: Type inference failed for: r4v402, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v470, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r8v169 */
    /* JADX WARN: Type inference failed for: r8v170 */
    /* JADX WARN: Type inference failed for: r8v171, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v172, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r8v194 */
    /* JADX WARN: Type inference failed for: r8v195 */
    /* JADX WARN: Type inference failed for: r8v305 */
    /* JADX WARN: Type inference failed for: r8v306 */
    /* JADX WARN: Type inference failed for: r8v368, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r8v407 */
    /* JADX WARN: Type inference failed for: r8v408 */
    /* JADX WARN: Type inference failed for: r8v418 */
    /* JADX WARN: Type inference failed for: r8v419, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r8v665 */
    /* JADX WARN: Type inference failed for: r8v666 */
    /* JADX WARN: Type inference failed for: r8v668 */
    /* JADX WARN: Type inference failed for: r8v669 */
    /* JADX WARN: Type inference failed for: r8v670 */
    /* JADX WARN: Type inference failed for: r8v671 */
    /* JADX WARN: Type inference failed for: r8v672 */
    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(Unknown Source)
        	at java.base/java.util.TreeMap.lastKey(Unknown Source)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] accessartificialFrame$78cbbd35(int r63, int r64, java.lang.Object r65, int r66, boolean r67) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 18817
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.prf.HmacPrfKey.accessartificialFrame$78cbbd35(int, int, java.lang.Object, int, boolean):java.lang.Object[]");
    }
}
