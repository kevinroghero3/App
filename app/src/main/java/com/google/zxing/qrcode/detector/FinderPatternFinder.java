package com.google.zxing.qrcode.detector;

import android.graphics.ImageFormat;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.base.Ascii;
import com.google.crypto.tink.ConfigurationV0$1$$ExternalSyntheticLambda9;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.transistorsoft.locationmanager.location.TSLocationManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import o.ArtificialStackFrames;
import o.onRelationshipValidationResult;

/* JADX INFO: loaded from: classes6.dex */
public class FinderPatternFinder {
    private static final int CENTER_QUORUM = 2;
    protected static final int MAX_MODULES = 97;
    protected static final int MIN_SKIP = 3;
    private final int[] crossCheckStateCount;
    private boolean hasSkipped;
    private final BitMatrix image;
    private final List<FinderPattern> possibleCenters;
    private final ResultPointCallback resultPointCallback;

    public FinderPatternFinder(BitMatrix bitMatrix) {
        this(bitMatrix, null);
    }

    public FinderPatternFinder(BitMatrix bitMatrix, ResultPointCallback resultPointCallback) {
        this.image = bitMatrix;
        this.possibleCenters = new ArrayList();
        this.crossCheckStateCount = new int[5];
        this.resultPointCallback = resultPointCallback;
    }

    /* JADX INFO: renamed from: com.google.zxing.qrcode.detector.FinderPatternFinder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        private static final byte[] $$c = {125, -90, -45, 56};
        private static final int $$d = 214;
        private static int $10 = 0;
        private static int $11 = 1;
        private static final byte[] $$a = {75, 100, -62, Ascii.SYN, Ascii.VT, 2, -12};
        private static final int $$b = 18;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static long onPostMessage = -7698721372927354962L;

        /* JADX WARN: Code duplicated, block: B:10:0x0024  */
        /* JADX WARN: Code duplicated, block: B:8:0x001e  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002a). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$e(int r6, short r7, short r8) {
            /*
                int r7 = r7 * 2
                int r7 = r7 + 111
                byte[] r0 = com.google.zxing.qrcode.detector.FinderPatternFinder.AnonymousClass1.$$c
                int r6 = r6 * 3
                int r6 = r6 + 1
                int r8 = r8 + 4
                byte[] r1 = new byte[r6]
                r2 = 0
                if (r0 != 0) goto L14
                r3 = r8
                r4 = r2
                goto L2a
            L14:
                r3 = r2
            L15:
                int r8 = r8 + 1
                byte r4 = (byte) r7
                r1[r3] = r4
                int r3 = r3 + 1
                if (r3 != r6) goto L24
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                return r6
            L24:
                r4 = r0[r8]
                r5 = r3
                r3 = r8
                r8 = r4
                r4 = r5
            L2a:
                int r8 = -r8
                int r7 = r7 + r8
                r8 = r3
                r3 = r4
                goto L15
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.detector.FinderPatternFinder.AnonymousClass1.$$e(int, short, short):java.lang.String");
        }

        private static void b(byte b, byte b2, int i, Object[] objArr) {
            byte[] bArr = $$a;
            int i2 = b + 4;
            int i3 = b2 * 2;
            int i4 = 109 - (i * 3);
            byte[] bArr2 = new byte[i3 + 4];
            int i5 = i3 + 3;
            int i6 = -1;
            if (bArr == null) {
                i6 = -1;
                i4 = (i4 + i2) - 3;
                i2 = i2;
            }
            while (true) {
                int i7 = i6 + 1;
                int i8 = i2 + 1;
                bArr2[i7] = (byte) i4;
                if (i7 == i5) {
                    objArr[0] = new String(bArr2, 0);
                    return;
                }
                i6 = i7;
                i4 = (i4 + bArr[i8]) - 3;
                i2 = i8;
            }
        }

        private static void a(int i, char[] cArr, Object[] objArr) throws Throwable {
            int i2 = 2 % 2;
            onRelationshipValidationResult onrelationshipvalidationresult = new onRelationshipValidationResult();
            char[] cArrAccessartificialFrame = onRelationshipValidationResult.accessartificialFrame(onPostMessage ^ 2573525503365829440L, cArr, i);
            onrelationshipvalidationresult.e = 4;
            while (onrelationshipvalidationresult.e < cArrAccessartificialFrame.length) {
                int i3 = $10 + 63;
                $11 = i3 % 128;
                int i4 = i3 % 2;
                onrelationshipvalidationresult.d = onrelationshipvalidationresult.e - 4;
                int i5 = onrelationshipvalidationresult.e;
                try {
                    Object[] objArr2 = {Long.valueOf(cArrAccessartificialFrame[onrelationshipvalidationresult.e] ^ cArrAccessartificialFrame[onrelationshipvalidationresult.e % 4]), Long.valueOf(onrelationshipvalidationresult.d), Long.valueOf(onPostMessage)};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(797310229);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(27 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) (30690 - (ViewConfiguration.getEdgeSlop() >> 16)), (Process.myTid() >> 22) + 188, -1327449315, false, "k", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                    }
                    cArrAccessartificialFrame[i5] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    try {
                        Object[] objArr3 = {onrelationshipvalidationresult, onrelationshipvalidationresult};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(321542193);
                        if (objAccessartificialFrame2 == null) {
                            byte b = (byte) 0;
                            byte b2 = b;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(33 - View.combineMeasuredStates(0, 0), (char) View.combineMeasuredStates(0, 0), View.resolveSizeAndState(0, 0, 0) + 1483, -1940971975, false, $$e(b, b2, (byte) (b2 - 1)), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame2).invoke(null, objArr3);
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
            }
            String str = new String(cArrAccessartificialFrame, 4, cArrAccessartificialFrame.length - 4);
            int i6 = $10 + 37;
            $11 = i6 % 128;
            int i7 = i6 % 2;
            objArr[0] = str;
        }

        /* JADX WARN: Code duplicated, block: B:96:0x0898 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:97:0x089a  */
        public static Object[] coroutineCreation(int i, int i2) throws Throwable {
            Object[] objArr;
            Object[] objArr2;
            String str;
            int threadPriority;
            String str2;
            int i3;
            int i4;
            int i5 = 2 % 2;
            int i6 = 20;
            long j = 0;
            int i7 = -1;
            Object obj = null;
            try {
                Object[] objArr3 = new Object[1];
                a(ViewConfiguration.getJumpTapTimeout() >> 16, new char[]{31829, 31804, 7352, 9814, 22565, 64279, 28559, 246, 45006, 13752, 12861, 55133, 23360, 13321, 7873, 50157, 18195, 55389, 27311, 15401, 12993, 52110, 30486}, objArr3);
                Object[] objArr4 = new Object[1];
                a(KeyEvent.normalizeMetaState(0), new char[]{25132, 25179, 59149, 48259, 41858, 39096, 29181, 64330, 13622, 22022, 43205, 46274, 17715, 53166, 33854, 41049, 22886, 9185, 61525, 24467, 11433, 12350}, objArr4);
                String[] strArr = {(String) objArr3[0], (String) objArr4[0]};
                int i8 = 0;
                while (true) {
                    if (i8 >= 2) {
                        int[] iArr = new int[1];
                        objArr = new Object[]{new int[]{i}, new int[]{i}, iArr, null};
                        int i9 = ~i;
                        int i10 = 533802334 + (((-67240081) | i9) * 494) + (((~(734615150 | i9)) | (-625086687)) * 494);
                        int i11 = i10 * 465;
                        int i12 = -(-(i2 * (-463)));
                        int i13 = ((i11 | i12) << 1) - (i11 ^ i12);
                        int i14 = ~i2;
                        int i15 = ~((i14 ^ i9) | (i14 & i9));
                        int i16 = ~((i14 & i10) | (i14 ^ i10));
                        int i17 = (i15 & i16) | (i15 ^ i16);
                        int i18 = ~((i9 & i10) | (i9 ^ i10));
                        int i19 = i13 + (((i18 & i17) | (i17 ^ i18)) * 464);
                        int i20 = (~i10) | i;
                        int i21 = ~i2;
                        int i22 = i19 + (((i20 & i21) | (i20 ^ i21)) * (-464));
                        int i23 = ~(i10 | i);
                        int i24 = i22 + (((i23 & i16) | (i16 ^ i23)) * 464);
                        int i25 = i24 << 13;
                        int i26 = (i25 | i24) & (~(i24 & i25));
                        int i27 = i26 >>> 17;
                        int i28 = ((~i26) & i27) | ((~i27) & i26);
                        int i29 = i28 << 5;
                        iArr[0] = (i28 | i29) & (~(i28 & i29));
                        break;
                    }
                    String str3 = strArr[i8];
                    int i30 = (-2) - ((-(-(SystemClock.uptimeMillis() > j ? 1 : (SystemClock.uptimeMillis() == j ? 0 : -1)))) ^ i7);
                    char[] cArr = new char[i6];
                    // fill-array-data instruction
                    cArr[0] = 34756;
                    cArr[1] = 34725;
                    cArr[2] = 39810;
                    cArr[3] = 62843;
                    cArr[4] = 57090;
                    cArr[5] = 5080;
                    cArr[6] = 37907;
                    cArr[7] = 34765;
                    cArr[8] = 31939;
                    cArr[9] = 56672;
                    cArr[10] = 57651;
                    cArr[11] = 16332;
                    cArr[12] = 41179;
                    cArr[13] = 45871;
                    cArr[14] = 52641;
                    cArr[15] = 11038;
                    cArr[16] = 48265;
                    cArr[17] = 24438;
                    cArr[18] = 47538;
                    cArr[19] = 54517;
                    Object[] objArr5 = new Object[1];
                    a(i30, cArr, objArr5);
                    Class<?> cls = Class.forName((String) objArr5[0]);
                    Class<?>[] clsArr = new Class[0];
                    int i31 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i32 = (i31 & 69) + (i31 | 69);
                    artificialFrame = i32 % 128;
                    if (i32 % 2 == 0) {
                        ((Boolean) cls.getMethod(str3, clsArr).invoke(cls, null)).booleanValue();
                        try {
                            obj.hashCode();
                            throw null;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (!(!((Boolean) cls.getMethod(str3, clsArr).invoke(cls, null)).booleanValue())) {
                        int i33 = (i & (-2)) | ((~i) & 1);
                        objArr = new Object[4];
                        int i34 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i35 = (i34 & 15) + (i34 | 15);
                        int i36 = i35 % 128;
                        artificialFrame = i36;
                        if (i35 % 2 == 0) {
                            objArr[1] = new int[1];
                            objArr[0] = new int[1];
                            objArr[4] = new int[1];
                        } else {
                            objArr[0] = new int[1];
                            objArr[1] = new int[1];
                            objArr[2] = new int[1];
                        }
                        ((int[]) objArr[0])[0] = i;
                        int i37 = ((i36 | 37) << 1) - (i36 ^ 37);
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i37 % 128;
                        int i38 = i37 % 2;
                        ((int[]) objArr[1])[0] = i33;
                        objArr[3] = null;
                        int i39 = i36 + 57;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i39 % 128;
                        if (i39 % 2 != 0) {
                            int i40 = ~new Random().nextInt(394194639);
                            int i41 = (((-469710298) + (((~((-2909187) | i40)) | 981532961) * (-828))) + ((i40 | (-2909187)) * (-828))) - 1886161288;
                            i4 = (i41 ^ (-16)) + ((i41 & (-16)) << 1);
                        } else {
                            int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
                            i4 = (-872584314) + ((~((~startElapsedRealtime) | 973044990)) * (-116)) + ((276127980 | startElapsedRealtime) * 116) + (((~(startElapsedRealtime | (-702495795))) | 5578784) * 116) + 16;
                        }
                        int i42 = (i2 - (~i4)) - 1;
                        int i43 = i42 << 13;
                        int i44 = (i42 | i43) & (~(i42 & i43));
                        int i45 = i44 >>> 17;
                        int i46 = (i44 | i45) & (~(i44 & i45));
                        ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
                        ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
                        int i47 = i46 << 5;
                        ((int[]) objArr[2])[0] = (i46 | i47) & (~(i46 & i47));
                        break;
                    }
                    i8 = ((i8 | 1) << 1) - (i8 ^ 1);
                    int i48 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i49 = (i48 & 61) + (i48 | 61);
                    artificialFrame = i49 % 128;
                    if (i49 % 2 == 0) {
                        int i50 = 3 % 2;
                    }
                    i6 = 20;
                    j = 0;
                    i7 = -1;
                }
            } catch (Exception unused) {
                objArr = new Object[]{new int[]{i}, new int[]{(i & (-3)) | ((~i) & 2)}, new int[1], null};
                int i51 = (((-1691067880) + (((~((-2400545) | i)) | (~(976223230 | i))) * 69)) + ((((~((-3122025) | i)) | 721480) | (~(975501750 | i))) * (-69))) - 1575493522;
                int iIPostMessageServiceStubProxy = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
                int i52 = -(-(i51 * 471));
                int i53 = (3776 & i52) + (i52 | 3776);
                int i54 = ~iIPostMessageServiceStubProxy;
                int i55 = (i53 - (~(-(-(((~((i54 & (-17)) | ((-17) ^ i54))) | i51) * (-235)))))) - 1;
                int i56 = ~(((-17) ^ iIPostMessageServiceStubProxy) | ((-17) & iIPostMessageServiceStubProxy));
                int i57 = i55 + (((i56 & i51) | (i51 ^ i56)) * (-470));
                int i58 = ~((~i51) | 16);
                int i59 = i51 | (-17);
                int i60 = ~((iIPostMessageServiceStubProxy & i59) | (i59 ^ iIPostMessageServiceStubProxy));
                int i61 = -(-(((i60 & i58) | (i58 ^ i60)) * 235));
                int i62 = ((i57 | i61) << 1) - (i61 ^ i57);
                int iIPostMessageServiceStubProxy2 = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
                int i63 = i62 * (-813);
                int i64 = i2 * TSLocationManager.LOCATION_ERROR_TIMEOUT;
                int i65 = (i63 & i64) + (i63 | i64);
                int i66 = ~((~i2) | i62);
                int i67 = ~((i62 ^ iIPostMessageServiceStubProxy2) | (i62 & iIPostMessageServiceStubProxy2));
                int i68 = ((i66 & i67) | (i66 ^ i67)) * (-814);
                int i69 = ((i65 | i68) << 1) - (i68 ^ i65);
                int i70 = ~i2;
                int i71 = ~iIPostMessageServiceStubProxy2;
                int i72 = ~((i70 & i71) | (i70 ^ i71));
                int i73 = ~i62;
                int i74 = i72 | (~((i73 & i2) | (i73 ^ i2)));
                int i75 = ~(i62 | iIPostMessageServiceStubProxy2);
                int i76 = -(-(((i74 & i75) | (i74 ^ i75)) * 407));
                int i77 = (i69 ^ i76) + ((i76 & i69) << 1);
                int i78 = ~i62;
                int i79 = ~((i78 ^ i2) | (i78 & i2));
                int i80 = ~((i78 & iIPostMessageServiceStubProxy2) | (i78 ^ iIPostMessageServiceStubProxy2));
                int i81 = (i80 & i79) | (i79 ^ i80);
                int i82 = ~((iIPostMessageServiceStubProxy2 & i2) | (i2 ^ iIPostMessageServiceStubProxy2));
                int i83 = (i77 - (~(-(-(((i82 & i81) | (i81 ^ i82)) * 407))))) - 1;
                int i84 = i83 << 13;
                int i85 = (i84 | i83) & (~(i83 & i84));
                int i86 = i85 ^ (i85 >>> 17);
                int i87 = i86 << 5;
                ((int[]) objArr[2])[0] = (i86 | i87) & (~(i86 & i87));
            }
            if (i != ((int[]) objArr[1])[0]) {
                return objArr;
            }
            try {
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(590025679);
                if (objAccessartificialFrame == null) {
                    int mirror = AndroidCharacter.getMirror('0') - '\'';
                    char c = (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 64609);
                    int iAxisFromString = MotionEvent.axisFromString("") + 1807;
                    byte b = (byte) (-1);
                    byte b2 = (byte) (b + 1);
                    Object[] objArr6 = new Object[1];
                    b(b, b2, b2, objArr6);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(mirror, c, iAxisFromString, -1135716921, false, (String) objArr6[0], new Class[0]);
                }
                long jLongValue = ((Long) ((Method) objAccessartificialFrame).invoke(null, null)).longValue();
                int iIPostMessageServiceStubProxy3 = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
                int i88 = ~((-819335202) | (~iIPostMessageServiceStubProxy3));
                int i89 = -(-(((i88 & (-688278078)) | ((-688278078) ^ i88) | (~(819335201 | iIPostMessageServiceStubProxy3))) * (-564)));
                int i90 = ((-1885580114) ^ i89) + ((i89 & (-1885580114)) << 1) + ((~(((-151013917) & iIPostMessageServiceStubProxy3) | ((-151013917) ^ iIPostMessageServiceStubProxy3))) * 1128);
                int i91 = ~iIPostMessageServiceStubProxy3;
                int i92 = ~((i91 & (-688278078)) | ((-688278078) ^ i91));
                int i93 = ((i92 & (-970349118)) | (i92 ^ (-970349118))) * 564;
                int i94 = (i90 & i93) + (i93 | i90);
                int iIPostMessageServiceStubProxy4 = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
                int i95 = ~iIPostMessageServiceStubProxy4;
                int i96 = (-1059666338) - (~(-(-((((~(((-221228533) ^ i95) | ((-221228533) & i95))) | 201469280) | (~((1898807452 ^ i95) | (1898807452 & i95)))) * (-1136)))));
                int i97 = ~((-221228533) | iIPostMessageServiceStubProxy4);
                int i98 = ~(1898807452 | iIPostMessageServiceStubProxy4);
                int i99 = (i97 ^ i98) | (i97 & i98);
                int i100 = (i95 ^ 221228532) | (i95 & 221228532);
                int i101 = ~((i100 ^ (-1898807453)) | (i100 & (-1898807453)));
                int i102 = i96 + (((i99 ^ i101) | (i101 & i99)) * (-568));
                int i103 = ~iIPostMessageServiceStubProxy4;
                int i104 = ~((i103 & 221228532) | (i103 ^ 221228532));
                int i105 = ~(i95 | (-1898807453));
                int i106 = (i105 & i104) | (i104 ^ i105);
                int i107 = ~(iIPostMessageServiceStubProxy4 | (-201469281));
                int i108 = -(-(((i107 & i106) | (i106 ^ i107)) * 568));
                if (i94 <= (i102 & i108) + (i108 | i102)) {
                    SystemClock.uptimeMillis();
                    Object obj2 = null;
                    obj2.hashCode();
                    throw null;
                }
                long j2 = -301971810;
                long j3 = 253;
                long j4 = (j3 * j2) + (j3 * jLongValue);
                long j5 = -252;
                long j6 = -1;
                long j7 = jLongValue ^ j6;
                long j8 = ((j2 ^ j6) | j7) ^ j6;
                long j9 = (int) Runtime.getRuntime().totalMemory();
                long j10 = j7 | (j9 ^ j6);
                long j11 = jLongValue | j2;
                long j12 = (j9 | j11) ^ j6;
                long j13 = j4 + ((j8 | (j10 ^ j6) | j12) * j5) + (j11 * j5) + (((long) 252) * (((j10 | j2) ^ j6) | j12)) + ((long) 642179844);
                int i109 = ~i;
                int i110 = ((int) (j13 >> 32)) & (1786374150 + ((571626026 | i) * 614) + (((~(1176763933 | i109)) | 537919522 | (~((-1680976952) | i109))) * (-1228)) + (((~(1714683455 | i109)) | (~((-1143057430) | i109))) * 614));
                int i111 = ((int) j13) & (2055568080 + (((~(541155120 | i109)) | (-896071290)) * 226) + (((~(896071289 | i)) | 67840 | (~((-354984010) | i109))) * (-113)) + ((~(541155120 | i)) * 113));
                if (((i110 & i111) | (i110 ^ i111)) == 1) {
                    int i112 = artificialFrame + 123;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i112 % 128;
                    int i113 = i112 % 2;
                    objArr2 = new Object[]{new int[]{i}, new int[]{(i & (-11)) | (i109 & 10)}, new int[1], null};
                    int i114 = 1060937410 + (((~((-447406077) | i109)) | (~((-531217699) | i))) * 210) + (((~((-83959811) | i109)) | (~((-148189) | i))) * 210);
                    int iIPostMessageServiceStubProxy5 = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
                    int i115 = (-14704) + (i114 * (-919));
                    int i116 = ~i114;
                    int i117 = ((-17) ^ i116) | ((-17) & i116);
                    int i118 = ~((i117 & iIPostMessageServiceStubProxy5) | (i117 ^ iIPostMessageServiceStubProxy5));
                    int i119 = ~iIPostMessageServiceStubProxy5;
                    int i120 = (i116 ^ i119) | (i116 & i119);
                    int i121 = ~((i120 & 16) | (i120 ^ 16));
                    int i122 = -(-(((i118 & i121) | (i118 ^ i121)) * 920));
                    int i123 = ((i115 | i122) << 1) - (i115 ^ i122);
                    int i124 = ~i114;
                    int i125 = ~(((-17) ^ i124) | ((-17) & i124));
                    int i126 = ~(((-17) ^ i119) | ((-17) & i119));
                    int i127 = ((i125 ^ i126) | (i126 & i125)) * 920;
                    int i128 = ((i123 | i127) << 1) - (i123 ^ i127);
                    int i129 = i124 | (-17);
                    int i130 = (i114 & (-17)) | ((-17) ^ i114);
                    int i131 = ((~(iIPostMessageServiceStubProxy5 | (i116 & 16) | (i116 ^ 16))) | (~((i130 & iIPostMessageServiceStubProxy5) | (i130 ^ iIPostMessageServiceStubProxy5))) | (~((i129 & i119) | (i129 ^ i119)))) * 920;
                    int i132 = (i128 & i131) + (i128 | i131);
                    int i133 = i132 * 319;
                    int i134 = -(-(i2 * (-317)));
                    int i135 = (i133 ^ i134) + ((i133 & i134) << 1);
                    int i136 = ~i2;
                    int i137 = ~i132;
                    int i138 = ~((i137 & i) | (i137 ^ i));
                    int i139 = ((i138 & i136) | (i136 ^ i138)) * (-318);
                    int i140 = (i135 ^ i139) + ((i139 & i135) << 1);
                    int i141 = ~i2;
                    int i142 = ~((i141 & i) | (i141 ^ i));
                    int i143 = ~i;
                    int i144 = (i143 & i132) | (i143 ^ i132);
                    int i145 = (i142 | (~((i144 & i2) | (i144 ^ i2)))) * TypedValues.AttributesType.TYPE_PIVOT_TARGET;
                    int i146 = (i140 ^ i145) + ((i145 & i140) << 1);
                    int i147 = (i136 & i109) | (i136 ^ i109);
                    int i148 = ~((i147 & i132) | (i147 ^ i132));
                    int i149 = (i132 & i2) | (i132 ^ i2);
                    int i150 = (i148 | (~((i149 & i) | (i149 ^ i)))) * TypedValues.AttributesType.TYPE_PIVOT_TARGET;
                    int i151 = (i146 & i150) + (i150 | i146);
                    int i152 = i151 << 13;
                    int i153 = (i152 & (~i151)) | ((~i152) & i151);
                    int i154 = i153 >>> 17;
                    int i155 = ((~i153) & i154) | ((~i154) & i153);
                    int i156 = i155 << 5;
                    ((int[]) objArr2[2])[0] = (i155 | i156) & (~(i155 & i156));
                    int i157 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i158 = (i157 & 15) + (i157 | 15);
                    artificialFrame = i158 % 128;
                    int i159 = i158 % 2;
                } else {
                    int[] iArr2 = new int[1];
                    int i160 = 2063287008 + (((~((-610582056) | i109)) | 368041719) * 226) + (((~((-368041720) | i)) | 294338768 | (~((-536879105) | i109))) * (-113)) + ((~((-610582056) | i)) * 113);
                    int i161 = i160 * (-751);
                    int i162 = ~i160;
                    int i163 = ~(i162 | ((-1) ^ i162));
                    int i164 = ~(((-1) ^ i) | i);
                    int i165 = ((i163 & i164) | (i163 ^ i164)) * 1504;
                    int i166 = ((i161 | i165) << 1) - (i161 ^ i165);
                    int i167 = -(-((~(((-1) ^ i160) | i160 | i)) * (-1504)));
                    int i168 = (i166 ^ i167) + ((i167 & i166) << 1);
                    int i169 = ~(((-1) ^ i160) | i160);
                    int i170 = ~(~i160);
                    int i171 = -(-(((i169 & i170) | (i169 ^ i170)) * 752));
                    int i172 = i2 + (i168 & i171) + (i171 | i168);
                    int i173 = i172 << 13;
                    int i174 = (i172 | i173) & (~(i172 & i173));
                    int i175 = i174 >>> 17;
                    int i176 = (i174 | i175) & (~(i174 & i175));
                    int i177 = i176 << 5;
                    iArr2[0] = ((~i176) & i177) | ((~i177) & i176);
                    objArr2 = new Object[]{new int[]{i}, new int[]{i}, iArr2, null};
                }
                int[] iArr3 = (int[]) objArr2[1];
                int i178 = artificialFrame;
                int i179 = (i178 ^ 125) + ((i178 & 125) << 1);
                int i180 = i179 % 128;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i180;
                int i181 = i179 % 2;
                if (i != iArr3[0]) {
                    int i182 = (i180 ^ AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) + ((i180 & AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) << 1);
                    artificialFrame = i182 % 128;
                    int i183 = i182 % 2;
                    int i184 = ((i180 | 61) << 1) - (i180 ^ 61);
                    artificialFrame = i184 % 128;
                    int i185 = i184 % 2;
                    return objArr2;
                }
                try {
                    Object[] objArr7 = new Object[1];
                    a(ViewConfiguration.getKeyRepeatDelay() >> 16, new char[]{53775, 53792, 42786, 47342, 58303, 47054, 49560, 47986, 12619, 31095, 44218, 39815, 62737, 36740, 32875, 36706, 59715, 25548, 62509, 28912, 40072, 28766, 59779, 25775, 45302, 17498, 56662, 18555, 42040, 22702, 12548, 15384, 22645, 11579, 8906, 8651, 20411, 334, 5795, 5519, 25366, 5562, 2682, 63815}, objArr7);
                    File file = new File((String) objArr7[0]);
                    if (!file.canRead()) {
                        int i186 = artificialFrame;
                        int i187 = (i186 & 65) + (i186 | 65);
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i187 % 128;
                        int i188 = i187 % 2;
                        str = null;
                    } else {
                        FileReader fileReader = new FileReader(file);
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        int i189 = getARTIFICIAL_FRAME_PACKAGE_NAME + 47;
                        artificialFrame = i189 % 128;
                        try {
                            if (i189 % 2 == 0) {
                                String line = bufferedReader.readLine();
                                threadPriority = Process.getThreadPriority(1);
                                str2 = line;
                                i3 = 18;
                            } else {
                                String line2 = bufferedReader.readLine();
                                threadPriority = Process.getThreadPriority(0);
                                str2 = line2;
                                i3 = 20;
                            }
                            int iIPostMessageServiceStubProxy6 = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
                            int i190 = i3 * (-344);
                            int i191 = threadPriority * (-344);
                            int i192 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                            int i193 = i192 + 117;
                            artificialFrame = i193 % 128;
                            int i194 = i193 % 2;
                            int i195 = (i190 ^ i191) + ((i190 & i191) << 1);
                            int i196 = ~i3;
                            int i197 = ~((~threadPriority) | i196);
                            int i198 = i192 + 41;
                            artificialFrame = i198 % 128;
                            int i199 = i198 % 2;
                            int i200 = ~i3;
                            int i201 = ~((i200 ^ iIPostMessageServiceStubProxy6) | (i200 & iIPostMessageServiceStubProxy6));
                            int i202 = -(-(((i197 ^ i201) | (i201 & i197)) * 345));
                            int i203 = (i195 & i202) + (i202 | i195);
                            int i204 = i192 + 59;
                            artificialFrame = i204 % 128;
                            int i205 = i204 % 2;
                            int i206 = ~((~iIPostMessageServiceStubProxy6) | i196);
                            int i207 = ~threadPriority;
                            int i208 = ~((i3 & i207) | (i207 ^ i3));
                            int i209 = i203 + (((i208 & i206) | (i206 ^ i208)) * 345);
                            int i210 = i200 | i207;
                            int i211 = -(-((~((i210 & iIPostMessageServiceStubProxy6) | (i210 ^ iIPostMessageServiceStubProxy6))) * 345));
                            Object[] objArr8 = new Object[1];
                            a(((i209 ^ i211) + ((i211 & i209) << 1)) >> 6, new char[]{10654, 10736, 29327, 14773, 13838, 45081, 19167}, objArr8);
                            if (str2.equals((String) objArr8[0])) {
                                fileReader.close();
                                bufferedReader.close();
                                int i212 = getARTIFICIAL_FRAME_PACKAGE_NAME + 117;
                                artificialFrame = i212 % 128;
                                int i213 = i212 % 2;
                                str = null;
                            } else {
                                int i214 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                int i215 = (i214 & 117) + (i214 | 117);
                                artificialFrame = i215 % 128;
                                int i216 = i215 % 2;
                                fileReader.close();
                                bufferedReader.close();
                                str = str2;
                            }
                        } catch (Throwable th2) {
                            fileReader.close();
                            bufferedReader.close();
                            throw th2;
                        }
                    }
                } catch (Exception unused2) {
                }
                try {
                    Object[] objArr9 = new Object[1];
                    a((-1) - ImageFormat.getBitsPerPixel(0), new char[]{480, 463, 28420, 31353, 11162, 14906, 4667, 29459, 62423, 62623, 28208, 5732, 9955, 18411, 17136, 704, 15034, 44002, 14006, 64769, 20271, 47154, 11039, 59719, 25369, 35967, 8134, 50594, 30677, 37066, 62362, 45543, 35716, 58633, 57431}, objArr9);
                    File file2 = new File((String) objArr9[0]);
                    int i217 = artificialFrame + 37;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i217 % 128;
                    int i218 = i217 % 2;
                    if (file2.canRead()) {
                        FileReader fileReader2 = new FileReader(file2);
                        BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
                        try {
                            String line3 = bufferedReader2.readLine();
                            Object[] objArr10 = new Object[1];
                            a(View.resolveSize(0, 0), new char[]{60398, 60383, 38886, 6981, 51367}, objArr10);
                            boolean zEquals = line3.equals((String) objArr10[0]);
                            fileReader2.close();
                            bufferedReader2.close();
                            if (zEquals) {
                                int i219 = -ExpandableListView.getPackedPositionChild(0L);
                                Object[] objArr11 = new Object[1];
                                a((i219 ^ (-1)) + (i219 << 1), new char[]{46667, 46692, 58768, 14640, 41229, 26452, 42460, 63936, 45205, 43501, 11620, 19229, 37205, 52534, 437, 24568, 36103, 8574, 30195, 41066, 63692, 13036, 26717, 46133, 54450, 1768, 23688, 39137, 49276, 6684, 45261, 60549, 15394, 28568, 41752, 61777, 11244, 17404, 38758, 50441}, objArr11);
                                File file3 = new File((String) objArr11[0]);
                                if (file3.canRead()) {
                                    FileReader fileReader3 = new FileReader(file3);
                                    BufferedReader bufferedReader3 = new BufferedReader(fileReader3);
                                    try {
                                        String line4 = bufferedReader3.readLine();
                                        Object[] objArr12 = new Object[1];
                                        a(ViewConfiguration.getScrollBarFadeDuration() >> 16, new char[]{60398, 60383, 38886, 6981, 51367}, objArr12);
                                        boolean zEquals2 = line4.equals((String) objArr12[0]);
                                        fileReader3.close();
                                        bufferedReader3.close();
                                        if (zEquals2) {
                                            if (str != null) {
                                                Object[] objArr13 = {new int[]{i}, new int[]{(~(i & 20)) & (i | 20)}, new int[1], str};
                                                int i220 = (-1188835266) + (((~(i | 784516551)) | (-802412504)) * 305) + (((~(784516551 | i109)) | (-194107224)) * 305);
                                                int iIPostMessageServiceStubProxy7 = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
                                                int i221 = -(-(i220 * (-743)));
                                                int i222 = (((-11888) | i221) << 1) - (i221 ^ (-11888));
                                                int i223 = ~((i220 ^ 16) | (i220 & 16));
                                                int i224 = ~((iIPostMessageServiceStubProxy7 ^ 16) | (iIPostMessageServiceStubProxy7 & 16));
                                                int i225 = i222 + (((i223 & i224) | (i223 ^ i224) | (~(i220 | iIPostMessageServiceStubProxy7))) * (-744));
                                                int i226 = ~iIPostMessageServiceStubProxy7;
                                                int i227 = ~i220;
                                                int i228 = ~((i227 & (-17)) | ((-17) ^ i227));
                                                int i229 = (i225 - (~(((i226 & i228) | (i226 ^ i228)) * 744))) - 1;
                                                int i230 = i220 | 16;
                                                int i231 = i229 + (((iIPostMessageServiceStubProxy7 & i230) | (i230 ^ iIPostMessageServiceStubProxy7)) * 744);
                                                int i232 = i231 * 624;
                                                int i233 = -(-(i2 * (-622)));
                                                int i234 = (i232 ^ i233) + ((i232 & i233) << 1);
                                                int i235 = ~i2;
                                                int i236 = (i235 ^ i231) | (i235 & i231);
                                                int i237 = -(-((~((i236 & i) | (i236 ^ i))) * 623));
                                                int i238 = ((i234 | i237) << 1) - (i237 ^ i234);
                                                int i239 = ~i231;
                                                int i240 = ~((i239 & i2) | (i239 ^ i2));
                                                int i241 = -(-(((i240 & i109) | (i109 ^ i240)) * (-623)));
                                                int i242 = ~(i235 | i231);
                                                int i243 = ~i2;
                                                int i244 = (((i238 & i241) + (i241 | i238)) - (~(-(-(((i242 | (~((i243 & i) | (i243 ^ i)))) | (~(i | i231))) * 623))))) - 1;
                                                int i245 = (i244 << 13) ^ i244;
                                                int i246 = i245 >>> 17;
                                                int i247 = ((~i245) & i246) | ((~i246) & i245);
                                                ((int[]) objArr13[2])[0] = i247 ^ (i247 << 5);
                                                return objArr13;
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        fileReader3.close();
                                        bufferedReader3.close();
                                        throw th3;
                                    }
                                } else {
                                    int i248 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                    int i249 = ((i248 | 89) << 1) - (i248 ^ 89);
                                    artificialFrame = i249 % 128;
                                    if (i249 % 2 == 0) {
                                        if (str != null) {
                                            Object[] objArr14 = {new int[]{i}, new int[]{(~(i & 20)) & (i | 20)}, new int[1], str};
                                            int i2210 = (-1188835266) + (((~(i | 784516551)) | (-802412504)) * 305) + (((~(784516551 | i109)) | (-194107224)) * 305);
                                            int iIPostMessageServiceStubProxy8 = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
                                            int i2211 = -(-(i2210 * (-743)));
                                            int i2212 = (((-11888) | i2211) << 1) - (i2211 ^ (-11888));
                                            int i2213 = ~((i2210 ^ 16) | (i2210 & 16));
                                            int i2214 = ~((iIPostMessageServiceStubProxy8 ^ 16) | (iIPostMessageServiceStubProxy8 & 16));
                                            int i2215 = i2212 + (((i2213 & i2214) | (i2213 ^ i2214) | (~(i2210 | iIPostMessageServiceStubProxy8))) * (-744));
                                            int i2216 = ~iIPostMessageServiceStubProxy8;
                                            int i2217 = ~i2210;
                                            int i2218 = ~((i2217 & (-17)) | ((-17) ^ i2217));
                                            int i2219 = (i2215 - (~(((i2216 & i2218) | (i2216 ^ i2218)) * 744))) - 1;
                                            int i2310 = i2210 | 16;
                                            int i2311 = i2219 + (((iIPostMessageServiceStubProxy8 & i2310) | (i2310 ^ iIPostMessageServiceStubProxy8)) * 744);
                                            int i2312 = i2311 * 624;
                                            int i2313 = -(-(i2 * (-622)));
                                            int i2314 = (i2312 ^ i2313) + ((i2312 & i2313) << 1);
                                            int i2315 = ~i2;
                                            int i2316 = (i2315 ^ i2311) | (i2315 & i2311);
                                            int i2317 = -(-((~((i2316 & i) | (i2316 ^ i))) * 623));
                                            int i2318 = ((i2314 | i2317) << 1) - (i2317 ^ i2314);
                                            int i2319 = ~i2311;
                                            int i2410 = ~((i2319 & i2) | (i2319 ^ i2));
                                            int i2411 = -(-(((i2410 & i109) | (i109 ^ i2410)) * (-623)));
                                            int i2412 = ~(i2315 | i2311);
                                            int i2413 = ~i2;
                                            int i2414 = (((i2318 & i2411) + (i2411 | i2318)) - (~(-(-(((i2412 | (~((i2413 & i) | (i2413 ^ i)))) | (~(i | i2311))) * 623))))) - 1;
                                            int i2415 = (i2414 << 13) ^ i2414;
                                            int i2416 = i2415 >>> 17;
                                            int i2417 = ((~i2415) & i2416) | ((~i2416) & i2415);
                                            ((int[]) objArr14[2])[0] = i2417 ^ (i2417 << 5);
                                            return objArr14;
                                        }
                                    }
                                }
                            }
                        } catch (Throwable th4) {
                            fileReader2.close();
                            bufferedReader2.close();
                            throw th4;
                        }
                    } else {
                        int i250 = getARTIFICIAL_FRAME_PACKAGE_NAME + 87;
                        artificialFrame = i250 % 128;
                        int i251 = i250 % 2;
                    }
                } catch (Exception unused3) {
                }
                Object[] objArr15 = {new int[]{i}, new int[]{i}, new int[1], null};
                int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
                int i252 = i2 + (-1639129168) + (((~((-1055173007) | iMaxMemory)) | 979673472) * 345) + (((~((-1055173007) | (~iMaxMemory))) | (-1056222704)) * 345) + ((~(iMaxMemory | (-979673473))) * 345);
                int i253 = i252 << 13;
                int i254 = (i252 | i253) & (~(i252 & i253));
                int i255 = i254 ^ (i254 >>> 17);
                int i256 = i255 << 5;
                ((int[]) objArr15[2])[0] = ((~i255) & i256) | ((~i256) & i255);
                return objArr15;
            } catch (Throwable th5) {
                Throwable cause = th5.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th5;
            }
        }
    }

    public final BitMatrix getImage() {
        return this.image;
    }

    public final List<FinderPattern> getPossibleCenters() {
        return this.possibleCenters;
    }

    final FinderPatternInfo find(Map<DecodeHintType, ?> map) throws NotFoundException {
        boolean z = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i = (height * 3) / 388;
        if (i < 3 || z) {
            i = 3;
        }
        int[] iArr = new int[5];
        int i2 = i - 1;
        boolean zHaveMultiplyConfirmedCenters = false;
        while (i2 < height && !zHaveMultiplyConfirmedCenters) {
            clearCounts(iArr);
            int i3 = 0;
            int i4 = 0;
            while (i3 < width) {
                if (this.image.get(i3, i2)) {
                    if ((i4 & 1) == 1) {
                        i4++;
                    }
                    iArr[i4] = iArr[i4] + 1;
                } else if ((i4 & 1) != 0) {
                    iArr[i4] = iArr[i4] + 1;
                } else if (i4 == 4) {
                    if (foundPatternCross(iArr) && handlePossibleCenter(iArr, i2, i3)) {
                        if (this.hasSkipped) {
                            zHaveMultiplyConfirmedCenters = haveMultiplyConfirmedCenters();
                        } else {
                            int iFindRowSkip = findRowSkip();
                            int i5 = iArr[2];
                            if (iFindRowSkip > i5) {
                                i2 += (iFindRowSkip - i5) - 2;
                                i3 = width - 1;
                            }
                        }
                        clearCounts(iArr);
                        i = 2;
                        i4 = 0;
                    } else {
                        shiftCounts2(iArr);
                        i4 = 3;
                    }
                } else {
                    i4++;
                    iArr[i4] = iArr[i4] + 1;
                }
                i3++;
            }
            if (foundPatternCross(iArr) && handlePossibleCenter(iArr, i2, width)) {
                i = iArr[0];
                if (this.hasSkipped) {
                    zHaveMultiplyConfirmedCenters = haveMultiplyConfirmedCenters();
                }
            }
            i2 += i;
        }
        FinderPattern[] finderPatternArrSelectBestPatterns = selectBestPatterns();
        ResultPoint.orderBestPatterns(finderPatternArrSelectBestPatterns);
        return new FinderPatternInfo(finderPatternArrSelectBestPatterns);
    }

    private static float centerFromEnd(int[] iArr, int i) {
        return ((i - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    public static boolean foundPatternCross(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = i / 7.0f;
        float f2 = f / 2.0f;
        if (Math.abs(f - iArr[0]) < f2 && Math.abs(f - iArr[1]) < f2) {
            if (Math.abs((f * 3.0f) - iArr[2]) < 3.0f * f2 && Math.abs(f - iArr[3]) < f2 && Math.abs(f - iArr[4]) < f2) {
                return true;
            }
        }
        return false;
    }

    protected static boolean foundPatternDiagonal(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = i / 7.0f;
        float f2 = f / 1.333f;
        if (Math.abs(f - iArr[0]) < f2 && Math.abs(f - iArr[1]) < f2) {
            if (Math.abs((f * 3.0f) - iArr[2]) < 3.0f * f2 && Math.abs(f - iArr[3]) < f2 && Math.abs(f - iArr[4]) < f2) {
                return true;
            }
        }
        return false;
    }

    private int[] getCrossCheckStateCount() {
        clearCounts(this.crossCheckStateCount);
        return this.crossCheckStateCount;
    }

    public final void clearCounts(int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = 0;
        }
    }

    public final void shiftCounts2(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    private boolean crossCheckDiagonal(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i6 = 0;
        while (i >= i6 && i2 >= i6 && this.image.get(i2 - i6, i - i6)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i6++;
        }
        if (crossCheckStateCount[2] == 0) {
            return false;
        }
        while (i >= i6 && i2 >= i6 && !this.image.get(i2 - i6, i - i6)) {
            crossCheckStateCount[1] = crossCheckStateCount[1] + 1;
            i6++;
        }
        if (crossCheckStateCount[1] == 0) {
            return false;
        }
        while (i >= i6 && i2 >= i6 && this.image.get(i2 - i6, i - i6)) {
            crossCheckStateCount[0] = crossCheckStateCount[0] + 1;
            i6++;
        }
        if (crossCheckStateCount[0] == 0) {
            return false;
        }
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i7 = 1;
        while (true) {
            int i8 = i + i7;
            if (i8 >= height || (i5 = i2 + i7) >= width || !this.image.get(i5, i8)) {
                break;
            }
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i7++;
        }
        while (true) {
            int i9 = i + i7;
            if (i9 >= height || (i4 = i2 + i7) >= width || this.image.get(i4, i9)) {
                break;
            }
            crossCheckStateCount[3] = crossCheckStateCount[3] + 1;
            i7++;
        }
        if (crossCheckStateCount[3] == 0) {
            return false;
        }
        while (true) {
            int i10 = i + i7;
            if (i10 >= height || (i3 = i2 + i7) >= width || !this.image.get(i3, i10)) {
                break;
            }
            crossCheckStateCount[4] = crossCheckStateCount[4] + 1;
            i7++;
        }
        if (crossCheckStateCount[4] == 0) {
            return false;
        }
        return foundPatternDiagonal(crossCheckStateCount);
    }

    private float crossCheckVertical(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        BitMatrix bitMatrix = this.image;
        int height = bitMatrix.getHeight();
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i8 = i;
        while (i8 >= 0 && bitMatrix.get(i2, i8)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i8--;
        }
        if (i8 < 0) {
            return Float.NaN;
        }
        while (i8 >= 0 && !bitMatrix.get(i2, i8)) {
            int i9 = crossCheckStateCount[1];
            if (i9 > i3) {
                break;
            }
            crossCheckStateCount[1] = i9 + 1;
            i8--;
        }
        if (i8 >= 0 && crossCheckStateCount[1] <= i3) {
            while (i8 >= 0 && bitMatrix.get(i2, i8) && (i7 = crossCheckStateCount[0]) <= i3) {
                crossCheckStateCount[0] = i7 + 1;
                i8--;
            }
            if (crossCheckStateCount[0] > i3) {
                return Float.NaN;
            }
            int i10 = i + 1;
            while (i10 < height && bitMatrix.get(i2, i10)) {
                crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
                i10++;
            }
            if (i10 == height) {
                return Float.NaN;
            }
            while (i10 < height && !bitMatrix.get(i2, i10) && (i6 = crossCheckStateCount[3]) < i3) {
                crossCheckStateCount[3] = i6 + 1;
                i10++;
            }
            if (i10 != height && crossCheckStateCount[3] < i3) {
                while (i10 < height && bitMatrix.get(i2, i10) && (i5 = crossCheckStateCount[4]) < i3) {
                    crossCheckStateCount[4] = i5 + 1;
                    i10++;
                }
                int i11 = crossCheckStateCount[4];
                if (i11 >= i3) {
                    return Float.NaN;
                }
                if (Math.abs(((((crossCheckStateCount[0] + crossCheckStateCount[1]) + crossCheckStateCount[2]) + crossCheckStateCount[3]) + i11) - i4) * 5 < i4 * 2 && foundPatternCross(crossCheckStateCount)) {
                    return centerFromEnd(crossCheckStateCount, i10);
                }
            }
        }
        return Float.NaN;
    }

    private float crossCheckHorizontal(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        BitMatrix bitMatrix = this.image;
        int width = bitMatrix.getWidth();
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i8 = i;
        while (i8 >= 0 && bitMatrix.get(i8, i2)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i8--;
        }
        if (i8 < 0) {
            return Float.NaN;
        }
        while (i8 >= 0 && !bitMatrix.get(i8, i2)) {
            int i9 = crossCheckStateCount[1];
            if (i9 > i3) {
                break;
            }
            crossCheckStateCount[1] = i9 + 1;
            i8--;
        }
        if (i8 >= 0 && crossCheckStateCount[1] <= i3) {
            while (i8 >= 0 && bitMatrix.get(i8, i2) && (i7 = crossCheckStateCount[0]) <= i3) {
                crossCheckStateCount[0] = i7 + 1;
                i8--;
            }
            if (crossCheckStateCount[0] > i3) {
                return Float.NaN;
            }
            int i10 = i + 1;
            while (i10 < width && bitMatrix.get(i10, i2)) {
                crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
                i10++;
            }
            if (i10 == width) {
                return Float.NaN;
            }
            while (i10 < width && !bitMatrix.get(i10, i2) && (i6 = crossCheckStateCount[3]) < i3) {
                crossCheckStateCount[3] = i6 + 1;
                i10++;
            }
            if (i10 != width && crossCheckStateCount[3] < i3) {
                while (i10 < width && bitMatrix.get(i10, i2) && (i5 = crossCheckStateCount[4]) < i3) {
                    crossCheckStateCount[4] = i5 + 1;
                    i10++;
                }
                int i11 = crossCheckStateCount[4];
                if (i11 >= i3) {
                    return Float.NaN;
                }
                if (Math.abs(((((crossCheckStateCount[0] + crossCheckStateCount[1]) + crossCheckStateCount[2]) + crossCheckStateCount[3]) + i11) - i4) * 5 < i4 && foundPatternCross(crossCheckStateCount)) {
                    return centerFromEnd(crossCheckStateCount, i10);
                }
            }
        }
        return Float.NaN;
    }

    @Deprecated
    protected final boolean handlePossibleCenter(int[] iArr, int i, int i2, boolean z) {
        return handlePossibleCenter(iArr, i, i2);
    }

    public final boolean handlePossibleCenter(int[] iArr, int i, int i2) {
        int i3 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int iCenterFromEnd = (int) centerFromEnd(iArr, i2);
        float fCrossCheckVertical = crossCheckVertical(i, iCenterFromEnd, iArr[2], i3);
        if (!Float.isNaN(fCrossCheckVertical)) {
            int i4 = (int) fCrossCheckVertical;
            float fCrossCheckHorizontal = crossCheckHorizontal(iCenterFromEnd, i4, iArr[2], i3);
            if (!Float.isNaN(fCrossCheckHorizontal) && crossCheckDiagonal(i4, (int) fCrossCheckHorizontal)) {
                float f = i3 / 7.0f;
                for (int i5 = 0; i5 < this.possibleCenters.size(); i5++) {
                    FinderPattern finderPattern = this.possibleCenters.get(i5);
                    if (finderPattern.aboutEquals(f, fCrossCheckVertical, fCrossCheckHorizontal)) {
                        this.possibleCenters.set(i5, finderPattern.combineEstimate(fCrossCheckVertical, fCrossCheckHorizontal, f));
                        return true;
                    }
                }
                FinderPattern finderPattern2 = new FinderPattern(fCrossCheckHorizontal, fCrossCheckVertical, f);
                this.possibleCenters.add(finderPattern2);
                ResultPointCallback resultPointCallback = this.resultPointCallback;
                if (resultPointCallback != null) {
                    resultPointCallback.foundPossibleResultPoint(finderPattern2);
                }
                return true;
            }
        }
        return false;
    }

    private int findRowSkip() {
        if (this.possibleCenters.size() <= 1) {
            return 0;
        }
        FinderPattern finderPattern = null;
        for (FinderPattern finderPattern2 : this.possibleCenters) {
            if (finderPattern2.getCount() >= 2) {
                if (finderPattern != null) {
                    this.hasSkipped = true;
                    return ((int) (Math.abs(finderPattern.getX() - finderPattern2.getX()) - Math.abs(finderPattern.getY() - finderPattern2.getY()))) / 2;
                }
                finderPattern = finderPattern2;
            }
        }
        return 0;
    }

    private boolean haveMultiplyConfirmedCenters() {
        int size = this.possibleCenters.size();
        float fAbs = 0.0f;
        float estimatedModuleSize = 0.0f;
        int i = 0;
        for (FinderPattern finderPattern : this.possibleCenters) {
            if (finderPattern.getCount() >= 2) {
                i++;
                estimatedModuleSize += finderPattern.getEstimatedModuleSize();
            }
        }
        if (i < 3) {
            return false;
        }
        float f = estimatedModuleSize / size;
        Iterator<FinderPattern> it2 = this.possibleCenters.iterator();
        while (it2.hasNext()) {
            fAbs += Math.abs(it2.next().getEstimatedModuleSize() - f);
        }
        return fAbs <= estimatedModuleSize * 0.05f;
    }

    private FinderPattern[] selectBestPatterns() throws NotFoundException {
        int size = this.possibleCenters.size();
        if (size < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        AnonymousClass1 anonymousClass1 = null;
        float estimatedModuleSize = 0.0f;
        if (size > 3) {
            Iterator<FinderPattern> it2 = this.possibleCenters.iterator();
            float f = 0.0f;
            float f2 = 0.0f;
            while (it2.hasNext()) {
                float estimatedModuleSize2 = it2.next().getEstimatedModuleSize();
                f += estimatedModuleSize2;
                f2 += estimatedModuleSize2 * estimatedModuleSize2;
            }
            float f3 = size;
            float f4 = f / f3;
            float fSqrt = (float) Math.sqrt((f2 / f3) - (f4 * f4));
            Collections.sort(this.possibleCenters, new FurthestFromAverageComparator(f4, anonymousClass1));
            float fMax = Math.max(0.2f * f4, fSqrt);
            int i = 0;
            while (i < this.possibleCenters.size() && this.possibleCenters.size() > 3) {
                if (Math.abs(this.possibleCenters.get(i).getEstimatedModuleSize() - f4) > fMax) {
                    this.possibleCenters.remove(i);
                    i--;
                }
                i++;
            }
        }
        if (this.possibleCenters.size() > 3) {
            Iterator<FinderPattern> it3 = this.possibleCenters.iterator();
            while (it3.hasNext()) {
                estimatedModuleSize += it3.next().getEstimatedModuleSize();
            }
            Collections.sort(this.possibleCenters, new CenterComparator(estimatedModuleSize / this.possibleCenters.size(), anonymousClass1));
            List<FinderPattern> list = this.possibleCenters;
            list.subList(3, list.size()).clear();
        }
        return new FinderPattern[]{this.possibleCenters.get(0), this.possibleCenters.get(1), this.possibleCenters.get(2)};
    }

    static final class FurthestFromAverageComparator implements Serializable, Comparator<FinderPattern> {
        private final float average;

        /* synthetic */ FurthestFromAverageComparator(float f, AnonymousClass1 anonymousClass1) {
            this(f);
        }

        private FurthestFromAverageComparator(float f) {
            this.average = f;
        }

        @Override // java.util.Comparator
        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            return Float.compare(Math.abs(finderPattern2.getEstimatedModuleSize() - this.average), Math.abs(finderPattern.getEstimatedModuleSize() - this.average));
        }
    }

    static final class CenterComparator implements Serializable, Comparator<FinderPattern> {
        private final float average;

        /* synthetic */ CenterComparator(float f, AnonymousClass1 anonymousClass1) {
            this(f);
        }

        private CenterComparator(float f) {
            this.average = f;
        }

        @Override // java.util.Comparator
        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            int iCompare = Integer.compare(finderPattern2.getCount(), finderPattern.getCount());
            return iCompare == 0 ? Float.compare(Math.abs(finderPattern.getEstimatedModuleSize() - this.average), Math.abs(finderPattern2.getEstimatedModuleSize() - this.average)) : iCompare;
        }
    }
}
