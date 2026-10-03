package com.google.crypto.tink.proto;

import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.google.common.base.Ascii;
import com.google.crypto.tink.shaded.protobuf.Internal;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;
import o.ICustomTabsCallbackDefault;

/* JADX INFO: loaded from: classes5.dex */
public enum EcdsaSignatureEncoding implements Internal.EnumLite {
    UNKNOWN_ENCODING(0),
    IEEE_P1363(1),
    DER(2),
    UNRECOGNIZED(-1);

    public static final int DER_VALUE = 2;
    public static final int IEEE_P1363_VALUE = 1;
    public static final int UNKNOWN_ENCODING_VALUE = 0;
    private static final Internal.EnumLiteMap<EcdsaSignatureEncoding> internalValueMap = new Internal.EnumLiteMap<EcdsaSignatureEncoding>() { // from class: com.google.crypto.tink.proto.EcdsaSignatureEncoding.1
        private static final byte[] $$c = {104, 117, 100, 60};
        private static final int $$d = 142;
        private static int $10 = 0;
        private static int $11 = 1;
        private static final byte[] $$a = {Ascii.DC2, -20, 124, 53, 9, -20, Ascii.FS, -26, -18, 10, -5, -11, 2, 19, -39, 6, -6, Ascii.ESC, -46, 8, -6, -15, 2, -4, Ascii.CR, -24, -13, -7, -12, Ascii.FF, -4, 50, -50, -14, -31, -17, -4, 38, -49, -3, -8, 10, -24, Ascii.US, -22, -22, 10, -7, -12, -2, -22, Ascii.DLE, -18, 9, -20, 44, -35, -20, -9, 6, -11, -4, 0, -10, 2, Ascii.GS, -46, 8, -6, -15, 2, -4};
        private static final int $$b = 25;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static long coroutineBoundary = -899883803867009716L;
        private static int accessartificialFrame = -1151259316;
        private static char CoroutineDebuggingKt = 43561;

        /* JADX WARN: Code duplicated, block: B:10:0x0021  */
        /* JADX WARN: Code duplicated, block: B:8:0x001b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x002a). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$e(int r6, byte r7, short r8) {
            /*
                int r6 = r6 + 98
                int r8 = r8 * 3
                int r8 = r8 + 4
                byte[] r0 = com.google.crypto.tink.proto.EcdsaSignatureEncoding.AnonymousClass1.$$c
                int r7 = r7 * 2
                int r1 = r7 + 1
                byte[] r1 = new byte[r1]
                r2 = 0
                if (r0 != 0) goto L15
                r3 = r8
                r4 = r2
                r8 = r7
                goto L2a
            L15:
                r3 = r2
            L16:
                byte r4 = (byte) r6
                r1[r3] = r4
                if (r3 != r7) goto L21
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                return r6
            L21:
                r4 = r0[r8]
                int r3 = r3 + 1
                r5 = r8
                r8 = r6
                r6 = r4
                r4 = r3
                r3 = r5
            L2a:
                int r3 = r3 + 1
                int r6 = -r6
                int r6 = r6 + r8
                r8 = r3
                r3 = r4
                goto L16
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.proto.EcdsaSignatureEncoding.AnonymousClass1.$$e(int, byte, short):java.lang.String");
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0022  */
        /* JADX WARN: Code duplicated, block: B:8:0x001a  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0026). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static void a(byte r5, int r6, byte r7, java.lang.Object[] r8) {
            /*
                int r0 = 28 - r5
                int r7 = r7 + 66
                byte[] r1 = com.google.crypto.tink.proto.EcdsaSignatureEncoding.AnonymousClass1.$$a
                int r6 = 52 - r6
                byte[] r0 = new byte[r0]
                int r5 = 27 - r5
                r2 = 0
                if (r1 != 0) goto L12
                r3 = r5
                r4 = r2
                goto L26
            L12:
                r3 = r2
            L13:
                byte r4 = (byte) r7
                r0[r3] = r4
                int r4 = r3 + 1
                if (r3 != r5) goto L22
                java.lang.String r5 = new java.lang.String
                r5.<init>(r0, r2)
                r8[r2] = r5
                return
            L22:
                int r6 = r6 + 1
                r3 = r1[r6]
            L26:
                int r3 = -r3
                int r7 = r7 + r3
                int r7 = r7 + (-5)
                r3 = r4
                goto L13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.proto.EcdsaSignatureEncoding.AnonymousClass1.a(byte, int, byte, java.lang.Object[]):void");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
        public EcdsaSignatureEncoding findValueByNumber(int i) {
            return EcdsaSignatureEncoding.forNumber(i);
        }

        private static void b(char[] cArr, int i, char[] cArr2, char c, char[] cArr3, Object[] objArr) throws Throwable {
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
            int i3 = $11 + 13;
            $10 = i3 % 128;
            int i4 = i3 % 2;
            while (iCustomTabsCallbackDefault.a < length3) {
                int i5 = $11 + 5;
                $10 = i5 % 128;
                int i6 = i5 % 2;
                try {
                    Object[] objArr2 = {iCustomTabsCallbackDefault};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-10548171);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) 1;
                        byte b2 = (byte) (b - 1);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(33 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16), 1482 - ImageFormat.getBitsPerPixel(0), 1614432829, false, $$e(b, b2, b2), new Class[]{Object.class});
                    }
                    int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                    Object[] objArr3 = {iCustomTabsCallbackDefault};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1818210492);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 3;
                        byte b4 = (byte) (b3 - 3);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getFadingEdgeLength() >> 16) + 32, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 49167), TextUtils.indexOf((CharSequence) "", '0') + 900, 214239564, false, $$e(b3, b4, b4), new Class[]{Object.class});
                    }
                    int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                    Object[] objArr4 = {iCustomTabsCallbackDefault, Integer.valueOf(cArr4[iCustomTabsCallbackDefault.a % 4] * 32718), Integer.valueOf(cArr5[iIntValue])};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1532285801);
                    if (objAccessartificialFrame3 == null) {
                        byte b5 = (byte) 0;
                        byte b6 = b5;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(24 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 2440, -1003383455, false, $$e(b5, b6, b6), new Class[]{Object.class, Integer.TYPE, Integer.TYPE});
                    }
                    ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                    Object[] objArr5 = {Integer.valueOf(cArr4[iIntValue2] * 32718), Integer.valueOf(cArr5[iIntValue])};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-950633141);
                    if (objAccessartificialFrame4 == null) {
                        int i7 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 19;
                        char c2 = (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 29753);
                        int doubleTapTimeout = 1748 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                        byte b7 = (byte) ($$d & 3);
                        byte b8 = (byte) (b7 - 2);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i7, c2, doubleTapTimeout, 1479752515, false, $$e(b7, b8, b8), new Class[]{Integer.TYPE, Integer.TYPE});
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
            String str = new String(cArr6);
            int i8 = $11 + b.f40o;
            $10 = i8 % 128;
            if (i8 % 2 == 0) {
                objArr[0] = str;
            } else {
                int i9 = 33 / 0;
                objArr[0] = str;
            }
        }

        /* JADX WARN: Code duplicated, block: B:118:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:30:0x0467  */
        /* JADX WARN: Code duplicated, block: B:32:0x0476  */
        /* JADX WARN: Code duplicated, block: B:33:0x047c  */
        /* JADX WARN: Code duplicated, block: B:36:0x0495 A[Catch: all -> 0x0b0a, TryCatch #2 {all -> 0x0b0a, blocks: (B:34:0x048d, B:36:0x0495, B:37:0x04dc), top: B:112:0x048d }] */
        /* JADX WARN: Code duplicated, block: B:40:0x04f0  */
        /* JADX WARN: Code duplicated, block: B:43:0x053d  */
        /* JADX WARN: Code duplicated, block: B:45:0x0554  */
        /* JADX WARN: Code duplicated, block: B:48:0x05a3  */
        /* JADX WARN: Code duplicated, block: B:50:0x05a9  */
        /* JADX WARN: Code duplicated, block: B:53:0x0686  */
        /* JADX WARN: Code duplicated, block: B:55:0x0696 A[Catch: Exception -> 0x0a64, TRY_ENTER, TryCatch #4 {Exception -> 0x0a64, blocks: (B:55:0x0696, B:62:0x06b0, B:71:0x07cb, B:73:0x07d1, B:74:0x07d2, B:75:0x07d3, B:81:0x086c, B:85:0x0a5c, B:87:0x0a62, B:88:0x0a63, B:58:0x069d, B:63:0x06f0, B:65:0x06fd, B:66:0x0746, B:76:0x0811, B:78:0x081e, B:79:0x0864), top: B:116:0x0694, inners: #1, #3 }] */
        /* JADX WARN: Code duplicated, block: B:57:0x069c  */
        /* JADX WARN: Code duplicated, block: B:58:0x069d A[Catch: Exception -> 0x0a64, TRY_LEAVE, TryCatch #4 {Exception -> 0x0a64, blocks: (B:55:0x0696, B:62:0x06b0, B:71:0x07cb, B:73:0x07d1, B:74:0x07d2, B:75:0x07d3, B:81:0x086c, B:85:0x0a5c, B:87:0x0a62, B:88:0x0a63, B:58:0x069d, B:63:0x06f0, B:65:0x06fd, B:66:0x0746, B:76:0x0811, B:78:0x081e, B:79:0x0864), top: B:116:0x0694, inners: #1, #3 }] */
        /* JADX WARN: Code duplicated, block: B:61:0x06a3  */
        /* JADX WARN: Code duplicated, block: B:65:0x06fd A[Catch: all -> 0x07ca, TryCatch #1 {all -> 0x07ca, blocks: (B:63:0x06f0, B:65:0x06fd, B:66:0x0746), top: B:110:0x06f0, outer: #4 }] */
        /* JADX WARN: Code duplicated, block: B:75:0x07d3 A[Catch: Exception -> 0x0a64, TRY_LEAVE, TryCatch #4 {Exception -> 0x0a64, blocks: (B:55:0x0696, B:62:0x06b0, B:71:0x07cb, B:73:0x07d1, B:74:0x07d2, B:75:0x07d3, B:81:0x086c, B:85:0x0a5c, B:87:0x0a62, B:88:0x0a63, B:58:0x069d, B:63:0x06f0, B:65:0x06fd, B:66:0x0746, B:76:0x0811, B:78:0x081e, B:79:0x0864), top: B:116:0x0694, inners: #1, #3 }] */
        /* JADX WARN: Code duplicated, block: B:78:0x081e A[Catch: all -> 0x0a5b, TryCatch #3 {all -> 0x0a5b, blocks: (B:76:0x0811, B:78:0x081e, B:79:0x0864), top: B:114:0x0811, outer: #4 }] */
        /* JADX WARN: Code duplicated, block: B:90:0x0a66  */
        /* JADX WARN: Code duplicated, block: B:93:0x0a7b  */
        /* JADX WARN: Code duplicated, block: B:94:0x0a85  */
        /* JADX WARN: Code restructure failed: missing block: B:121:?, code lost:
        
            return r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x07c6, code lost:
        
            if (((r3 & r4) | (r3 ^ r4)) == 1) goto L83;
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x092a, code lost:
        
            if (r4.equals((java.lang.String) r3[0]) != false) goto L83;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x092c, code lost:
        
            r4 = new java.lang.Object[]{new int[]{r29}, new int[]{r29 ^ 10}, new int[1], null};
            r6 = ((1405982232 + (((~(r0 | 447683258)) | 530940516) * (-1042))) + ((447683258 | r29) * 521)) + (((~(r0 | 531602174)) | ((~(r29 | (-530940517))) | 447021600)) * 521);
            r0 = com.salesforce.marketingcloud.sfmcsdk.components.events.EventManager.Companion.onLoadChildren();
            r1 = com.google.crypto.tink.proto.EcdsaSignatureEncoding.AnonymousClass1.artificialFrame;
            r3 = r1 + 95;
            com.google.crypto.tink.proto.EcdsaSignatureEncoding.AnonymousClass1.getARTIFICIAL_FRAME_PACKAGE_NAME = r3 % 128;
            r3 = r3 % 2;
            r3 = -(-((-67) * r6));
            r7 = (1104 & r3) + (r3 | 1104);
            r3 = ~r6;
            r5 = ((-17) & r3) | ((-17) ^ r3);
            r8 = ~r0;
            r5 = ~((r5 & r8) | (r5 ^ r8));
            r9 = ~((16 & r6) | (16 ^ r6));
            r5 = (r5 & r9) | (r5 ^ r9);
            r9 = ~((r6 ^ r0) | (r6 & r0));
            r5 = ((r5 & r9) | (r5 ^ r9)) * (-68);
            r9 = ((r7 | r5) << 1) - (r5 ^ r7);
            r1 = r1 + 7;
            com.google.crypto.tink.proto.EcdsaSignatureEncoding.AnonymousClass1.getARTIFICIAL_FRAME_PACKAGE_NAME = r1 % 128;
            r1 = r1 % 2;
            r5 = (-17) | r8;
            r9 = r9 + ((-68) * (~((r5 & r6) | (r5 ^ r6))));
            r0 = ~r0;
            r0 = ~((r0 & r3) | (r3 ^ r0));
            r0 = -(-(((r0 & (-17)) | ((-17) ^ r0)) * 68));
            r1 = (r9 & r0) + (r0 | r9);
            r0 = com.salesforce.marketingcloud.sfmcsdk.components.events.EventManager.Companion.onLoadChildren();
            r3 = r1 * 319;
            r5 = r31 * (-317);
            r6 = (r3 & r5) + (r3 | r5);
            r3 = ~r31;
            r5 = ~r1;
            r5 = ~((r5 & r0) | (r5 ^ r0));
            r3 = -(-(((r3 & r5) | (r3 ^ r5)) * (-318)));
            r5 = (r6 & r3) + (r3 | r6);
            r3 = ~r31;
            r6 = ~((r3 ^ r0) | (r3 & r0));
            r7 = ~r0;
            r8 = (r7 ^ r1) | (r7 & r1);
            r8 = ~((r8 & r31) | (r8 ^ r31));
            r5 = (r5 - (~(((r6 & r8) | (r6 ^ r8)) * androidx.constraintlayout.core.motion.utils.TypedValues.AttributesType.TYPE_PIVOT_TARGET))) - 1;
            r3 = r3 | r7;
            r3 = ~((r3 & r1) | (r3 ^ r1));
            r1 = (r1 & r31) | (r1 ^ r31);
            r0 = ~((r0 & r1) | (r1 ^ r0));
            r1 = com.google.crypto.tink.proto.EcdsaSignatureEncoding.AnonymousClass1.getARTIFICIAL_FRAME_PACKAGE_NAME + 53;
            com.google.crypto.tink.proto.EcdsaSignatureEncoding.AnonymousClass1.artificialFrame = r1 % 128;
            r1 = r1 % 2;
            r5 = (r5 - (~(androidx.constraintlayout.core.motion.utils.TypedValues.AttributesType.TYPE_PIVOT_TARGET * ((r0 & r3) | (r3 ^ r0))))) - 1;
            r0 = r5 << 13;
            r0 = (r0 & (~r5)) | ((~r0) & r5);
            r1 = r0 >>> 17;
            r0 = ((~r0) & r1) | ((~r1) & r0);
            r1 = r0 << 5;
            ((int[]) r4[2])[0] = (r0 | r1) & (~(r0 & r1));
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r28, int r29, int r30, int r31) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 3104
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.proto.EcdsaSignatureEncoding.AnonymousClass1.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
        }
    };
    private final int value;

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this == UNRECOGNIZED) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.value;
    }

    @Deprecated
    public static EcdsaSignatureEncoding valueOf(int i) {
        return forNumber(i);
    }

    public static EcdsaSignatureEncoding forNumber(int i) {
        if (i == 0) {
            return UNKNOWN_ENCODING;
        }
        if (i == 1) {
            return IEEE_P1363;
        }
        if (i != 2) {
            return null;
        }
        return DER;
    }

    public static Internal.EnumLiteMap<EcdsaSignatureEncoding> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return EcdsaSignatureEncodingVerifier.INSTANCE;
    }

    static final class EcdsaSignatureEncodingVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new EcdsaSignatureEncodingVerifier();

        private EcdsaSignatureEncodingVerifier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return EcdsaSignatureEncoding.forNumber(i) != null;
        }
    }

    EcdsaSignatureEncoding(int i) {
        this.value = i;
    }
}
