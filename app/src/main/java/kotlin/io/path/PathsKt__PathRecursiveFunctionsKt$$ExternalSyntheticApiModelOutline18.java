package kotlin.io.path;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.CoreConstants;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import com.google.protobuf.BytesValue;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import kotlin.text.Typography;
import o.ArtificialStackFrames;
import o.asBinder;
import o.extraCallback;
import org.apache.commons.lang3.CharUtils;

/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class PathsKt__PathRecursiveFunctionsKt$$ExternalSyntheticApiModelOutline18 {
    private static final byte[] $$a = {Ascii.FS, 50, 106, -64};
    private static final int $$b = 214;
    private static int $10 = 0;
    private static int $11 = 1;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] ArtificialStackFrames = {44406, 44408, 44341, 44376, 44391, 44393, 44398, 44356, 44385, 44336, 44386, 44699, 44698, 44368, 44384, 44358, 44320, 44373, 44697, 44366, 44332, 44702, 44371, 44361, 44395, 44394, 44389, 44403, 44399, 44387, 44392, 44404, 44353, 44349, 44367, 44696, 44407, 44334, 44402, 44397, 44409, 44388, 44400, 44345, 44396, 44390, 44405, 44354, 44355};
    private static char coroutineCreation = 39069;
    private static long extraCommand = 4391687624364688037L;

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$c(byte r6, byte r7, short r8) {
        /*
            int r8 = r8 * 4
            int r0 = r8 + 1
            int r7 = 118 - r7
            byte[] r1 = kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$$ExternalSyntheticApiModelOutline18.$$a
            int r6 = r6 * 4
            int r6 = 3 - r6
            byte[] r0 = new byte[r0]
            r2 = 0
            if (r1 != 0) goto L15
            r4 = r7
            r3 = r2
            r7 = r6
            goto L2a
        L15:
            r3 = r2
        L16:
            byte r4 = (byte) r7
            r0[r3] = r4
            int r6 = r6 + 1
            if (r3 != r8) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            return r6
        L23:
            int r3 = r3 + 1
            r4 = r1[r6]
            r5 = r7
            r7 = r6
            r6 = r5
        L2a:
            int r6 = r6 + r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$$ExternalSyntheticApiModelOutline18.$$c(byte, byte, short):java.lang.String");
    }

    private static void b(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2;
        int i3 = 2 % 2;
        asBinder asbinder = new asBinder();
        asbinder.c = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        asbinder.d = 0;
        int i4 = $11 + 61;
        $10 = i4 % 128;
        int i5 = i4 % 2;
        while (asbinder.d < cArr.length) {
            int i6 = $10 + 5;
            $11 = i6 % 128;
            if (i6 % i2 == 0) {
                int i7 = asbinder.d;
                char c = cArr[asbinder.d];
                try {
                    Object[] objArr2 = new Object[3];
                    objArr2[i2] = asbinder;
                    objArr2[1] = asbinder;
                    objArr2[0] = Integer.valueOf(c);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1562553046);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) 0;
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 10, (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1), 1408 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 1035473698, false, $$c(b, b2, b2), new Class[]{Integer.TYPE, Object.class, Object.class});
                    }
                    jArr[i7] = ((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue() | (extraCommand / (-2360974883025274865L));
                    Object[] objArr3 = {asbinder, asbinder};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                    if (objAccessartificialFrame2 == null) {
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(8 - TextUtils.getOffsetBefore("", 0), (char) View.MeasureSpec.getSize(0), 250 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), 378009232, false, "w", new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } else {
                int i8 = asbinder.d;
                Object[] objArr4 = {Integer.valueOf(cArr[asbinder.d]), asbinder, asbinder};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1562553046);
                if (objAccessartificialFrame3 == null) {
                    byte b3 = (byte) 0;
                    byte b4 = b3;
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(10 - TextUtils.lastIndexOf("", '0', 0), (char) View.resolveSize(0, 0), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 1407, 1035473698, false, $$c(b3, b4, b4), new Class[]{Integer.TYPE, Object.class, Object.class});
                }
                jArr[i8] = ((Long) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).longValue() ^ (extraCommand ^ (-2360974883025274865L));
                Object[] objArr5 = {asbinder, asbinder};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(MotionEvent.axisFromString("") + 9, (char) (AndroidCharacter.getMirror('0') - '0'), 248 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 378009232, false, "w", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
            }
            i2 = 2;
        }
        char[] cArr2 = new char[length];
        asbinder.d = 0;
        int i9 = $10 + 125;
        $11 = i9 % 128;
        int i10 = i9 % 2;
        while (asbinder.d < cArr.length) {
            cArr2[asbinder.d] = (char) jArr[asbinder.d];
            try {
                Object[] objArr6 = {asbinder, asbinder};
                Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame5 == null) {
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(8 - KeyEvent.getDeadChar(0, 0), (char) (Process.myPid() >> 22), 249 - (ViewConfiguration.getTapTimeout() >> 16), 378009232, false, "w", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame5).invoke(null, objArr6);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        objArr[0] = new String(cArr2);
    }

    private static void a(int i, char[] cArr, byte b, Object[] objArr) throws Throwable {
        int i2;
        Object obj;
        int i3 = 2;
        int i4 = 2 % 2;
        extraCallback extracallback = new extraCallback();
        char[] cArr2 = ArtificialStackFrames;
        int i5 = -1819279892;
        Object obj2 = null;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i6 = 0;
            while (i6 < length) {
                int i7 = $10 + 125;
                $11 = i7 % 128;
                if (i7 % i3 == 0) {
                    try {
                        Object[] objArr2 = {Integer.valueOf(cArr2[i6])};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i5);
                        if (objAccessartificialFrame == null) {
                            byte b2 = (byte) 0;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(15 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 20489), View.MeasureSpec.getMode(0) + 2148, 216710116, false, $$c(b2, (byte) (b2 | Ascii.NAK), b2), new Class[]{Integer.TYPE});
                        }
                        cArr3[i6] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                        i6 >>>= 1;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } else {
                    Object[] objArr3 = {Integer.valueOf(cArr2[i6])};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1819279892);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 0;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 15, (char) ((ViewConfiguration.getTouchSlop() >> 8) + 20488), 2148 - (ViewConfiguration.getPressedStateDuration() >> 16), 216710116, false, $$c(b3, (byte) (b3 | Ascii.NAK), b3), new Class[]{Integer.TYPE});
                    }
                    cArr3[i6] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                    i6++;
                }
                i3 = 2;
                i5 = -1819279892;
            }
            cArr2 = cArr3;
        }
        Object[] objArr4 = {Integer.valueOf(coroutineCreation)};
        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1819279892);
        if (objAccessartificialFrame3 == null) {
            byte b4 = (byte) 0;
            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(14 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) ((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 20488), (Process.myPid() >> 22) + 2148, 216710116, false, $$c(b4, (byte) (b4 | Ascii.NAK), b4), new Class[]{Integer.TYPE});
        }
        char cCharValue = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).charValue();
        char[] cArr4 = new char[i];
        if (i % 2 != 0) {
            int i8 = $10 + b.i;
            $11 = i8 % 128;
            int i9 = i8 % 2;
            i2 = i - 1;
            cArr4[i2] = (char) (cArr[i2] - b);
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
                    obj = obj2;
                } else {
                    Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1894223152);
                    if (objAccessartificialFrame4 == null) {
                        byte b5 = (byte) 0;
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(46 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (58859 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), 2464 - TextUtils.indexOf("", ""), 276640984, false, $$c(b5, (byte) (b5 | Ascii.DLE), b5), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                    }
                    if (((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue() == extracallback.g) {
                        Object[] objArr6 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                        Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1361113423);
                        if (objAccessartificialFrame5 == null) {
                            byte b6 = (byte) 0;
                            objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(24 - (ViewConfiguration.getEdgeSlop() >> 16), (char) KeyEvent.normalizeMetaState(0), 792 - TextUtils.indexOf("", "", 0), -834291897, false, $$c(b6, (byte) (b6 | Ascii.CR), b6), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                        }
                        obj = null;
                        int iIntValue = ((Integer) ((Method) objAccessartificialFrame5).invoke(null, objArr6)).intValue();
                        int i10 = (extracallback.d * cCharValue) + extracallback.g;
                        cArr4[extracallback.a] = cArr2[iIntValue];
                        cArr4[extracallback.a + 1] = cArr2[i10];
                    } else {
                        obj = null;
                        if (extracallback.b == extracallback.d) {
                            extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                            extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                            int i11 = (extracallback.b * cCharValue) + extracallback.j;
                            int i12 = (extracallback.d * cCharValue) + extracallback.g;
                            cArr4[extracallback.a] = cArr2[i11];
                            cArr4[extracallback.a + 1] = cArr2[i12];
                        } else {
                            int i13 = (extracallback.b * cCharValue) + extracallback.g;
                            int i14 = (extracallback.d * cCharValue) + extracallback.j;
                            cArr4[extracallback.a] = cArr2[i13];
                            cArr4[extracallback.a + 1] = cArr2[i14];
                        }
                    }
                }
                extracallback.a += 2;
                obj2 = obj;
            }
        }
        for (int i15 = 0; i15 < i; i15++) {
            cArr4[i15] = (char) (cArr4[i15] ^ 13722);
        }
        String str = new String(cArr4);
        int i16 = $11 + 91;
        $10 = i16 % 128;
        int i17 = i16 % 2;
        objArr[0] = str;
    }

    public static Object[] accessartificialFrame(Context context, int i, int i2) {
        Object[] objArr;
        int i3;
        int i4;
        int i5;
        char[] cArr;
        int i6;
        int i7;
        int i8;
        int i9;
        String str;
        int i10;
        char[] cArr2;
        int keyRepeatDelay;
        int i11;
        int i12;
        int i13;
        int i14;
        Method method;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20 = 2 % 2;
        int i21 = 1;
        if (context == null) {
            int i22 = getARTIFICIAL_FRAME_PACKAGE_NAME;
            int i23 = i22 + 29;
            artificialFrame = i23 % 128;
            int i24 = i23 % 2;
            int[] iArr = new int[1];
            objArr = new Object[]{new int[]{i}, new int[]{i}, iArr, null};
            int i25 = i22 + 29;
            int i26 = i25 % 128;
            artificialFrame = i26;
            int i27 = i25 % 2;
            int i28 = ((((~((-537300500) | i)) | 536903696) * (-283)) - 1696452914) + ((~((-396804) | i)) * 283);
            int i29 = (i28 << 1) - i28;
            int i30 = i26 + 113;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i30 % 128;
            if (i30 % 2 != 0) {
                int i31 = -i2;
                i18 = (((-317) << i29) - (~((i31 ^ 319) + ((i31 & 319) << 1)))) - 1;
                int i32 = ~i29;
                int i33 = ~i2;
                int i34 = (i32 & i33) | (i32 ^ i33);
                i19 = (i34 & i) | (i34 ^ i);
            } else {
                int i35 = i29 * (-317);
                int i36 = -(-(i2 * 319));
                i18 = ((i35 & i36) << 1) + (i35 ^ i36);
                int i37 = ~i29;
                int i38 = ~i2;
                i19 = (i37 & i38) | (i37 ^ i38) | i;
            }
            int i39 = ~i19;
            int i40 = ~i;
            int i41 = ~((i40 & i29) | (i40 ^ i29) | i2);
            int i42 = -(-((-318) * ((i39 & i41) | (i39 ^ i41))));
            int i43 = (i18 & i42) + (i18 | i42);
            int i44 = ~i2;
            int i45 = i43 + (((~((i44 ^ i29) | (i44 & i29))) | (~((i29 ^ i) | (i29 & i)))) * (-318));
            int i46 = ~i29;
            int i47 = ~((i & i46) | (i46 ^ i));
            int i48 = -(-(((i44 & i47) | (i44 ^ i47)) * TypedValues.AttributesType.TYPE_PIVOT_TARGET));
            int i49 = (i45 ^ i48) + ((i48 & i45) << 1);
            int i50 = i49 << 13;
            int i51 = (i50 & (~i49)) | ((~i50) & i49);
            int i52 = i51 >>> 17;
            int i53 = ((~i51) & i52) | ((~i52) & i51);
            iArr[0] = i53 ^ (i53 << 5);
            i3 = 2;
        } else {
            try {
                int i54 = -View.MeasureSpec.getSize(0);
                int i55 = i54 * 495;
                int i56 = (i55 & (-18734)) + (i55 | (-18734)) + (((i54 ^ (-39)) | (i54 & (-39))) * (-988));
                int i57 = ~i54;
                int i58 = ~i;
                int i59 = i56 + (((i57 ^ 38) | (i57 & 38) | i58) * 494);
                int i60 = (~((i57 & (-39)) | (i57 ^ (-39)))) | (~((i58 ^ 38) | (i58 & 38)));
                int i61 = ~((i54 & 38) | (i54 ^ 38));
                int i62 = i59 + (((i61 & i60) | (i60 ^ i61)) * 494);
                char[] cArr3 = {22, 11, 1, 7, 2, '$', 21, 27, ' ', '+', CoreConstants.LEFT_PARENTHESIS_CHAR, 3, '!', Typography.amp, '$', '\t', CoreConstants.DASH_CHAR, ' ', CoreConstants.PERCENT_CHAR, CoreConstants.COMMA_CHAR, 2, 3, 13782, 13782, Typography.amp, 2, '\t', 16, '\n', 7, CoreConstants.LEFT_PARENTHESIS_CHAR, 3, 1, '\"', 0, '/', '\t', '+'};
                int iLastIndexOf = TextUtils.lastIndexOf("", '0');
                Object[] objArr2 = new Object[1];
                a(i62, cArr3, (byte) ((iLastIndexOf ^ 45) + ((iLastIndexOf & 45) << 1)), objArr2);
                Object[] objArr3 = (Object[]) Array.newInstance(Class.forName((String) objArr2[0]), 2);
                int scrollBarSize = ViewConfiguration.getScrollBarSize() >> 8;
                int iINotificationSideChannelStubProxy = BytesValue.Builder.INotificationSideChannelStubProxy();
                int i63 = scrollBarSize * 934;
                int i64 = (i63 & (-56405572)) + (i63 | (-56405572));
                int i65 = ~((~iINotificationSideChannelStubProxy) | (~scrollBarSize));
                int i66 = (((-60522) ^ i65) | (i65 & (-60522))) * (-933);
                int i67 = ((i64 | i66) << 1) - (i64 ^ i66);
                int i68 = ~iINotificationSideChannelStubProxy;
                int i69 = ~((i68 & (-60522)) | ((-60522) ^ i68));
                int i70 = ~(((-60522) & scrollBarSize) | ((-60522) ^ scrollBarSize));
                int i71 = -(-(((i69 & i70) | (i69 ^ i70)) * 933));
                int i72 = ((i67 | i71) << 1) - (i67 ^ i71);
                int i73 = -(-((~((60521 & scrollBarSize) | (scrollBarSize ^ 60521))) * 933));
                Object[] objArr4 = new Object[1];
                b((i72 & i73) + (i73 | i72), new char[]{15081, 54925, 57925, 65488, 35680, 42179, 45230, 19482, 22923, 30079, 1680, 4717, 11811, 15261, 55137, 57578, 64534, 34844, 42485, 45344, 17136, 24147, 27614, 1962, 4891, 11407, 14380, 54778, 57835, 64794, 36535}, objArr4);
                try {
                    Object[] objArr5 = {(String) objArr4[0]};
                    int i74 = -(ViewConfiguration.getEdgeSlop() >> 16);
                    int i75 = i74 * 165;
                    int i76 = ((i75 | (-6194)) << 1) - (i75 ^ (-6194));
                    int i77 = ~i;
                    int i78 = ~((i77 ^ 38) | (i77 & 38));
                    int i79 = i76 + (((i74 ^ i78) | (i78 & i74)) * (-328)) + (((i74 ^ i) | (i74 & i)) * 164);
                    int i80 = ~i74;
                    int i81 = ~((i80 ^ (-39)) | (i80 & (-39)));
                    int i82 = ~(((-39) ^ i) | ((-39) & i));
                    int i83 = (i81 ^ i82) | (i81 & i82);
                    int i84 = (i74 & i77) | (i77 ^ i74);
                    int i85 = ~((i84 & 38) | (i84 ^ 38));
                    int i86 = (i79 - (~(-(-(((i85 & i83) | (i83 ^ i85)) * 164))))) - 1;
                    char[] cArr4 = {22, 11, 1, 7, 2, '$', 21, 27, ' ', '+', CoreConstants.LEFT_PARENTHESIS_CHAR, 3, '!', Typography.amp, '$', '\t', CoreConstants.DASH_CHAR, ' ', CoreConstants.PERCENT_CHAR, CoreConstants.COMMA_CHAR, 2, 3, 13782, 13782, Typography.amp, 2, '\t', 16, '\n', 7, CoreConstants.LEFT_PARENTHESIS_CHAR, 3, 1, '\"', 0, '/', '\t', '+'};
                    int i87 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                    int i88 = ~i87;
                    int i89 = ((i87 * 595) - 51041) + (((~((i88 ^ 43) | (i88 & 43))) | (~(i58 | 43))) * (-1188));
                    int i90 = ~i87;
                    int i91 = (~(((-44) ^ i) | ((-44) & i))) | (~((i90 & 43) | (i90 ^ 43)));
                    int i92 = ~((i58 ^ i87) | (i58 & i87));
                    int i93 = i89 + (((i91 ^ i92) | (i91 & i92)) * 594);
                    int i94 = -(-(((~(((-44) ^ i77) | ((-44) & i77))) | (~(((-44) & i87) | ((-44) ^ i87))) | (~((i77 ^ i87) | (i87 & i77)))) * 594));
                    Object[] objArr6 = new Object[1];
                    a(i86, cArr4, (byte) (((i93 | i94) << 1) - (i94 ^ i93)), objArr6);
                    objArr3[0] = Class.forName((String) objArr6[0]).getDeclaredConstructor(String.class).newInstance(objArr5);
                    int i95 = -Process.getGidForName("");
                    int i96 = (i95 ^ 30) + ((i95 & 30) << 1);
                    char[] cArr5 = {'/', '\"', 15, 24, 27, CoreConstants.RIGHT_PARENTHESIS_CHAR, '\"', '!', CharUtils.CR, '0', '#', 31, 6, CoreConstants.LEFT_PARENTHESIS_CHAR, 27, 6, 26, CoreConstants.LEFT_PARENTHESIS_CHAR, '\"', 4, '#', CoreConstants.SINGLE_QUOTE_CHAR, '!', 0, CoreConstants.PERCENT_CHAR, 20, '\f', 21, 11, CoreConstants.DASH_CHAR, 13876};
                    int i97 = -(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                    Object[] objArr7 = new Object[1];
                    a(i96, cArr5, (byte) ((i97 ^ 55) + ((i97 & 55) << 1)), objArr7);
                    try {
                        Object[] objArr8 = {(String) objArr7[0]};
                        int i98 = -TextUtils.indexOf((CharSequence) "", '0', 0);
                        int i99 = artificialFrame;
                        int i100 = (i99 ^ 93) + ((i99 & 93) << 1);
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i100 % 128;
                        if (i100 % 2 != 0) {
                            i4 = (477 >>> i98) * (-15);
                        } else {
                            int i101 = i98 * 477;
                            i4 = ((i101 | (-17575)) << 1) - (i101 ^ (-17575));
                        }
                        int i102 = ~i98;
                        int i103 = ((-38) & i98) | ((-38) ^ i98);
                        int i104 = i4 + ((-476) * ((~((i102 & 37) | (i102 ^ 37))) | (~((i103 & i) | (i103 ^ i)))));
                        int i105 = ((-38) & i98) | ((-38) ^ i98);
                        int i106 = (~((i105 & i) | (i105 ^ i))) * 952;
                        int i107 = (((i104 ^ i106) + ((i104 & i106) << 1)) - (~((~(i98 | ((-38) | i58))) * 476))) - 1;
                        char[] cArr6 = {22, 11, 1, 7, 2, '$', 21, 27, ' ', '+', CoreConstants.LEFT_PARENTHESIS_CHAR, 3, '!', Typography.amp, '$', '\t', CoreConstants.DASH_CHAR, ' ', CoreConstants.PERCENT_CHAR, CoreConstants.COMMA_CHAR, 2, 3, 13782, 13782, Typography.amp, 2, '\t', 16, '\n', 7, CoreConstants.LEFT_PARENTHESIS_CHAR, 3, 1, '\"', 0, '/', '\t', '+'};
                        int i108 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                        int iINotificationSideChannelStubProxy2 = BytesValue.Builder.INotificationSideChannelStubProxy();
                        int i109 = i108 * 141;
                        int i110 = ((i109 | (-12276)) << 1) - (i109 ^ (-12276));
                        int i111 = (iINotificationSideChannelStubProxy2 | 44) * 140;
                        int i112 = (i110 & i111) + (i111 | i110);
                        int i113 = ~i108;
                        int i114 = ~(i113 | 44);
                        int i115 = ~iINotificationSideChannelStubProxy2;
                        int i116 = ~((i115 ^ 44) | (i115 & 44));
                        int i117 = i112 + (((i114 ^ i116) | (i116 & i114)) * (-280));
                        int i118 = ~(((-45) & i108) | ((-45) ^ i108));
                        int i119 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i120 = (i119 ^ 123) + ((i119 & 123) << 1);
                        artificialFrame = i120 % 128;
                        int i121 = i120 % 2;
                        int i122 = ~(i108 | (~iINotificationSideChannelStubProxy2));
                        int i123 = (i122 & i118) | (i118 ^ i122);
                        int i124 = (i113 ^ 44) | (i113 & 44);
                        int i125 = ~((i124 & iINotificationSideChannelStubProxy2) | (i124 ^ iINotificationSideChannelStubProxy2));
                        int i126 = 140 * ((i123 & i125) | (i123 ^ i125));
                        byte b = (byte) (((i117 | i126) << 1) - (i117 ^ i126));
                        Object[] objArr9 = new Object[1];
                        a(i107, cArr6, b, objArr9);
                        objArr3[1] = Class.forName((String) objArr9[0]).getDeclaredConstructor(String.class).newInstance(objArr8);
                        int i127 = getARTIFICIAL_FRAME_PACKAGE_NAME + 61;
                        artificialFrame = i127 % 128;
                        try {
                            if (i127 % 2 == 0) {
                                i5 = 36 % (ExpandableListView.getPackedPositionForGroup(1) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(1) == 0L ? 0 : -1));
                                cArr = new char[]{CharUtils.CR, 1, '#', CoreConstants.SINGLE_QUOTE_CHAR, '!', 0, '#', Typography.amp, 30, 29, 3, '\"', 27, 5, 30, Typography.amp, '*', '\"', 3, '\"', 22, 5, 13910};
                                int i128 = -(-KeyEvent.getDeadChar(1, 1));
                                i6 = ((i128 | 62) << 1) - (i128 ^ 62);
                            } else {
                                int i129 = -(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                                i5 = ((i129 | 23) << 1) - (i129 ^ 23);
                                cArr = new char[]{CharUtils.CR, 1, '#', CoreConstants.SINGLE_QUOTE_CHAR, '!', 0, '#', Typography.amp, 30, 29, 3, '\"', 27, 5, 30, Typography.amp, '*', '\"', 3, '\"', 22, 5, 13910};
                                i6 = 103 - (~(-KeyEvent.getDeadChar(0, 0)));
                            }
                            byte b2 = (byte) i6;
                            Object[] objArr10 = new Object[1];
                            a(i5, cArr, b2, objArr10);
                            Class<?> cls = Class.forName((String) objArr10[0]);
                            int touchSlop = ViewConfiguration.getTouchSlop() >> 8;
                            int i130 = artificialFrame;
                            int i131 = ((i130 | 65) << 1) - (i130 ^ 65);
                            int i132 = i131 % 128;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i132;
                            int i133 = i131 % 2;
                            int i134 = (touchSlop * (-949)) - 30871919;
                            int i135 = ~((-32532) | i58);
                            int i136 = i132 + 13;
                            int i137 = i136 % 128;
                            artificialFrame = i137;
                            if (i136 % 2 == 0) {
                                int i138 = ~touchSlop;
                                int i139 = ~((i138 & i) | (i138 ^ i));
                                i7 = i134 / (1900 >> ((i139 & i135) | (i135 ^ i139)));
                                i8 = i58 | touchSlop;
                            } else {
                                int i140 = ~touchSlop;
                                int i141 = ~((i140 & i) | (i140 ^ i));
                                int i142 = -(-(((i141 & i135) | (i135 ^ i141)) * 1900));
                                i7 = (i134 & i142) + (i142 | i134);
                                i8 = (i58 ^ touchSlop) | (i58 & touchSlop);
                            }
                            int i143 = i7 + ((-950) * ((~i8) | (~((32531 & i) | (32531 ^ i)))));
                            int i144 = ((i137 | 15) << 1) - (i137 ^ 15);
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i144 % 128;
                            if (i144 % 2 != 0) {
                                int i145 = ~((i58 ^ 32531) | (i58 & 32531));
                                int i146 = ~((touchSlop & i) | (touchSlop ^ i));
                                int i147 = i143 * (((i146 & i145) | (i145 ^ i146)) + 950);
                                Object[] objArr11 = new Object[1];
                                b(i147, new char[]{15053, 17884, 50424, 18371, 50823, 16790, 49331, 17230, 49749, 19812, 52313, 20250, 52768, 18748, 51655, 18642, 52200}, objArr11);
                                str = (String) objArr11[0];
                                i9 = 0;
                            } else {
                                int i148 = ~((i58 ^ 32531) | (i58 & 32531));
                                int i149 = ~(touchSlop | i);
                                int i150 = ((i149 & i148) | (i148 ^ i149)) * 950;
                                Object[] objArr12 = new Object[1];
                                b((i143 ^ i150) + ((i150 & i143) << 1), new char[]{15053, 17884, 50424, 18371, 50823, 16790, 49331, 17230, 49749, 19812, 52313, 20250, 52768, 18748, 51655, 18642, 52200}, objArr12);
                                i9 = 0;
                                str = (String) objArr12[0];
                            }
                            Object objInvoke = cls.getMethod(str, null).invoke(context, null);
                            try {
                                int i151 = -View.getDefaultSize(i9, i9);
                                int i152 = i151 * (-445);
                                int i153 = (i152 ^ (-10235)) + ((i152 & (-10235)) << 1);
                                int i154 = ~i151;
                                int i155 = (i153 - (~(((~((i154 ^ (-24)) | (i154 & (-24)))) | (~(((-24) ^ i58) | ((-24) & i58)))) * 446))) - 1;
                                int i156 = ~((i154 & 23) | (i154 ^ 23));
                                int i157 = (-24) | i151;
                                int i158 = ~((i157 & i) | (i157 ^ i));
                                int i159 = i155 + (((i156 & i158) | (i156 ^ i158)) * 446) + ((~((~i151) | (-24))) * 446);
                                char[] cArr7 = {CharUtils.CR, 1, '#', CoreConstants.SINGLE_QUOTE_CHAR, '!', 0, '#', Typography.amp, 30, 29, 3, '\"', 27, 5, 30, Typography.amp, '*', '\"', 3, '\"', 22, 5, 13910};
                                int i160 = -(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                                int i161 = (i160 * 483) + 25410;
                                int i162 = ~i160;
                                int i163 = ~((i162 & (-106)) | (i162 ^ (-106)));
                                int i164 = ~i160;
                                int i165 = ~((i164 ^ i58) | (i164 & i58));
                                int i166 = -(-(((i163 ^ i165) | (i163 & i165)) * (-241)));
                                int i167 = (i161 & i166) + (i161 | i166);
                                int i168 = (i160 | 105) * (-482);
                                int i169 = ((i167 | i168) << 1) - (i168 ^ i167);
                                int i170 = ~((i160 & (-106)) | ((-106) ^ i160));
                                int i171 = (i164 ^ i58) | (i164 & i58);
                                int i172 = ~((i171 & 105) | (i171 ^ 105));
                                byte b3 = (byte) ((i169 - (~(((i170 & i172) | (i170 ^ i172)) * 241))) - 1);
                                Object[] objArr13 = new Object[1];
                                a(i159, cArr7, b3, objArr13);
                                Class<?> cls2 = Class.forName((String) objArr13[0]);
                                Object[] objArr14 = new Object[1];
                                b(48336 - (~(-(-(ViewConfiguration.getScrollBarSize() >> 8)))), new char[]{15053, 34334, 17276, 3209, 51599, 35548, 22055, 4988, 56389, 39318, 23246, 9776, 58123, 44114}, objArr14);
                                try {
                                    Object[] objArr15 = {cls2.getMethod((String) objArr14[0], null).invoke(context, null), 64};
                                    int i173 = -MotionEvent.axisFromString("");
                                    int iINotificationSideChannelStubProxy3 = BytesValue.Builder.INotificationSideChannelStubProxy();
                                    int i174 = (i173 * 193) - (-7124016);
                                    int i175 = ~iINotificationSideChannelStubProxy3;
                                    int i176 = ~i173;
                                    int i177 = ~((i176 ^ 36912) | (i176 & 36912));
                                    int i178 = -(-(((i175 ^ i177) | (i177 & i175)) * (-192)));
                                    int i179 = (i174 ^ i178) + ((i174 & i178) << 1);
                                    int i180 = ~(i176 | (-36913));
                                    int i181 = ~iINotificationSideChannelStubProxy3;
                                    int i182 = (i179 - (~(((~(((-36913) ^ i181) | ((-36913) & i181))) | i180) * (-384)))) - 1;
                                    int i183 = ~i173;
                                    int i184 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                    int i185 = (i184 & 9) + (i184 | 9);
                                    artificialFrame = i185 % 128;
                                    int i186 = i185 % 2;
                                    int i187 = (i183 & (-36913)) | (i183 ^ (-36913));
                                    int i188 = ~((i187 & iINotificationSideChannelStubProxy3) | (i187 ^ iINotificationSideChannelStubProxy3));
                                    int i189 = (i175 & (-36913)) | ((-36913) ^ i175);
                                    int i190 = ~((i189 & i173) | (i189 ^ i173));
                                    int i191 = (i188 & i190) | (i188 ^ i190);
                                    int i192 = (i173 & 36912) | (i173 ^ 36912);
                                    int i193 = ~((i192 & iINotificationSideChannelStubProxy3) | (i192 ^ iINotificationSideChannelStubProxy3));
                                    int i194 = -(-(JfifUtil.MARKER_SOFn * ((i193 & i191) | (i191 ^ i193))));
                                    Object[] objArr16 = new Object[1];
                                    b((i182 & i194) + (i182 | i194), new char[]{15051, 43765, 6828, 35403, 31233, 59958, 23528, 52179, 47937, 11132, 39726, 2245, 63619, 26809, 55408, 18523, 14794, 43398, 6646, 35161, 31007, 61132, 24311, 52908, 48725, 11782, 40477, 4064, 65432, 28486, 57203, 20256, 15608}, objArr16);
                                    Class<?> cls3 = Class.forName((String) objArr16[0]);
                                    int i195 = -(KeyEvent.getMaxKeyCode() >> 16);
                                    int i196 = i195 * (-963);
                                    int i197 = (i196 & (-964)) + (i196 | (-964)) + 43597735;
                                    int i198 = ~i195;
                                    int i199 = ~(((-45180) ^ i) | ((-45180) & i));
                                    int i200 = -(-(((i198 ^ i199) | (i198 & i199)) * (-964)));
                                    int i201 = (i197 ^ i200) + ((i200 & i197) << 1);
                                    int i202 = ((~(i195 | (-45180))) | (~((-45180) | i58))) * (-964);
                                    Object[] objArr17 = new Object[1];
                                    b(((i201 | i202) << 1) - (i202 ^ i201), new char[]{15053, 35508, 23080, 11147, 64295, 18606, 6179, 59798, 47381, 3740, 56877, 44941, 32520, 52474}, objArr17);
                                    Object objInvoke2 = cls3.getMethod((String) objArr17[0], String.class, Integer.TYPE).invoke(objInvoke, objArr15);
                                    int i203 = 30 - (~(-(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))));
                                    char[] cArr8 = {CharUtils.CR, 1, '#', CoreConstants.SINGLE_QUOTE_CHAR, '!', 0, '#', Typography.amp, 30, 29, 3, '\"', 27, 5, 30, Typography.amp, '.', '#', CoreConstants.RIGHT_PARENTHESIS_CHAR, '\t', 15, '$', 22, '\n', 5, 25, 27, 2, '*', 31};
                                    int size = View.MeasureSpec.getSize(0);
                                    byte b4 = (byte) ((size ^ 76) + ((size & 76) << 1));
                                    Object[] objArr18 = new Object[1];
                                    a(i203, cArr8, b4, objArr18);
                                    Class<?> cls4 = Class.forName((String) objArr18[0]);
                                    int iGreen = Color.green(0) + 10;
                                    char[] cArr9 = {26, 6, 5, 0, '\n', 29, CoreConstants.DASH_CHAR, CoreConstants.SINGLE_QUOTE_CHAR, 27, 21};
                                    int i204 = -(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                                    int i205 = (i204 * (-755)) - 92110;
                                    int i206 = ~((~i204) | (-123));
                                    int i207 = i206 * 1512;
                                    int i208 = (i205 ^ i207) + ((i207 & i205) << 1);
                                    int i209 = (i204 ^ 122) | (i204 & 122);
                                    int i210 = ~((i209 ^ i) | (i209 & i));
                                    int i211 = (i208 - (~(((i210 & i206) | (i206 ^ i210)) * (-756)))) - 1;
                                    int i212 = ((i209 & i77) | (i209 ^ i77)) * 756;
                                    Object[] objArr19 = new Object[1];
                                    a(iGreen, cArr9, (byte) ((i211 & i212) + (i211 | i212)), objArr19);
                                    Object[] objArr20 = (Object[]) cls4.getField((String) objArr19[0]).get(objInvoke2);
                                    int length = objArr20.length;
                                    int i213 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                    int i214 = 5;
                                    int i215 = ((i213 | 5) << 1) - (i213 ^ 5);
                                    artificialFrame = i215 % 128;
                                    if (i215 % 2 == 0) {
                                        int i216 = 4 % 3;
                                    }
                                    int i217 = 0;
                                    while (i217 < length) {
                                        Object obj = objArr20[i217];
                                        int iAlpha = 5 - Color.alpha(0);
                                        char[] cArr10 = new char[i214];
                                        // fill-array-data instruction
                                        cArr10[0] = 2;
                                        cArr10[1] = '&';
                                        cArr10[2] = '\t';
                                        cArr10[3] = 16;
                                        cArr10[4] = 13733;
                                        int i218 = -View.MeasureSpec.getMode(0);
                                        int i219 = i218 * 370;
                                        int i220 = (((i219 & 740) + (i219 | 740)) - (~(-(-((((i218 ^ 2) | (i218 & 2)) | i58) * (-369)))))) - i21;
                                        int i221 = ~i218;
                                        int i222 = ~((i221 ^ i58) | (i221 & i58));
                                        int i223 = i220 + (((i222 ^ 2) | (i222 & 2)) * (-369));
                                        int i224 = ~(((-3) ^ i218) | ((-3) & i218));
                                        int i225 = ~(i218 | i);
                                        int i226 = (i224 ^ i225) | (i224 & i225);
                                        int i227 = i221 | i77;
                                        int i228 = ~((i227 & 2) | (i227 ^ 2));
                                        int i229 = -(-(((i226 & i228) | (i226 ^ i228)) * 369));
                                        byte b5 = (byte) ((i223 ^ i229) + ((i223 & i229) << i21));
                                        Object[] objArr21 = new Object[i21];
                                        a(iAlpha, cArr10, b5, objArr21);
                                        try {
                                            Object[] objArr22 = {(String) objArr21[0]};
                                            int i230 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                                            int i231 = ((i230 | 36) << i21) - (i230 ^ 36);
                                            char[] cArr11 = {22, 11, 1, 7, CoreConstants.RIGHT_PARENTHESIS_CHAR, 23, 22, '!', CoreConstants.DASH_CHAR, CoreConstants.SINGLE_QUOTE_CHAR, 3, '!', CoreConstants.RIGHT_PARENTHESIS_CHAR, Typography.amp, '!', 22, CoreConstants.DASH_CHAR, Typography.amp, CoreConstants.RIGHT_PARENTHESIS_CHAR, CoreConstants.COMMA_CHAR, 24, CoreConstants.LEFT_PARENTHESIS_CHAR, '!', 3, '/', 3, '$', 15, '!', 24, 22, 15, 30, ' ', 31, '#', 13827};
                                            int i232 = getARTIFICIAL_FRAME_PACKAGE_NAME + 1;
                                            artificialFrame = i232 % 128;
                                            int i233 = i232 % 2;
                                            Object[] objArr23 = new Object[i21];
                                            a(i231, cArr11, (byte) (31 - (~KeyEvent.getDeadChar(0, 0))), objArr23);
                                            Class<?> cls5 = Class.forName((String) objArr23[0]);
                                            int fadingEdgeLength = ViewConfiguration.getFadingEdgeLength() >> 16;
                                            int iINotificationSideChannelStubProxy4 = BytesValue.Builder.INotificationSideChannelStubProxy();
                                            int i234 = ~iINotificationSideChannelStubProxy4;
                                            int i235 = (((fadingEdgeLength * (-559)) + 7594257) - (~((~((i234 ^ fadingEdgeLength) | (i234 & fadingEdgeLength))) * (-560)))) - 1;
                                            int i236 = artificialFrame + 61;
                                            Object[] objArr24 = objArr20;
                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i236 % 128;
                                            int i237 = i236 % 2;
                                            int i238 = -(-((-560) * (~(((-13538) & fadingEdgeLength) | ((-13538) ^ fadingEdgeLength) | iINotificationSideChannelStubProxy4))));
                                            int i239 = (i235 ^ i238) + ((i238 & i235) << 1);
                                            int i240 = ~fadingEdgeLength;
                                            int i241 = -(-(((~((i240 & 13537) | (i240 ^ 13537))) | (~(i234 | 13537))) * 560));
                                            int i242 = ((i239 | i241) << 1) - (i241 ^ i239);
                                            Object[] objArr25 = new Object[1];
                                            b(i242, new char[]{15053, 3630, 21276, 42048, 59712, 12988, 1944, 18668, 40396, 57632, 10757}, objArr25);
                                            Object objInvoke3 = cls5.getMethod((String) objArr25[0], String.class).invoke(null, objArr22);
                                            try {
                                                int i243 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                                                int iINotificationSideChannelStubProxy5 = BytesValue.Builder.INotificationSideChannelStubProxy();
                                                int i244 = ~iINotificationSideChannelStubProxy5;
                                                int i245 = ~((i244 & (-30)) | ((-30) ^ i244));
                                                int i246 = ~(((-30) ^ i243) | ((-30) & i243));
                                                int i247 = (((i243 * (-244)) + 7134) - (~(((i245 ^ i246) | (i245 & i246)) * (-245)))) - 1;
                                                int i248 = getARTIFICIAL_FRAME_PACKAGE_NAME + 121;
                                                artificialFrame = i248 % 128;
                                                if (i248 % 2 == 0) {
                                                    int i249 = (iINotificationSideChannelStubProxy5 & (-30)) | ((-30) ^ iINotificationSideChannelStubProxy5);
                                                    int i250 = (-245) % (~i249);
                                                    int i251 = ~i249;
                                                    i10 = (i247 & i250) + (i247 | i250) + (244 - (~(-((i243 & i251) | (i243 ^ i251)))));
                                                    cArr2 = new char[]{CharUtils.CR, 1, '#', CoreConstants.SINGLE_QUOTE_CHAR, '!', 0, '#', Typography.amp, 30, 29, 3, '\"', 27, 5, 30, Typography.amp, '.', '#', '$', 23, 6, 5, 1, CharUtils.CR, ' ', CoreConstants.DASH_CHAR, CoreConstants.LEFT_PARENTHESIS_CHAR, 24};
                                                    keyRepeatDelay = ViewConfiguration.getKeyRepeatDelay();
                                                    i11 = 95;
                                                    i12 = 8;
                                                } else {
                                                    int i252 = (i247 - (~(-(-((~((-30) | iINotificationSideChannelStubProxy5)) * (-245)))))) - 1;
                                                    int i253 = ~((iINotificationSideChannelStubProxy5 & (-30)) | ((-30) ^ iINotificationSideChannelStubProxy5));
                                                    int i254 = -(-(((i243 & i253) | (i243 ^ i253)) * 245));
                                                    i10 = (i252 ^ i254) + ((i254 & i252) << 1);
                                                    cArr2 = new char[]{CharUtils.CR, 1, '#', CoreConstants.SINGLE_QUOTE_CHAR, '!', 0, '#', Typography.amp, 30, 29, 3, '\"', 27, 5, 30, Typography.amp, '.', '#', '$', 23, 6, 5, 1, CharUtils.CR, ' ', CoreConstants.DASH_CHAR, CoreConstants.LEFT_PARENTHESIS_CHAR, 24};
                                                    keyRepeatDelay = ViewConfiguration.getKeyRepeatDelay();
                                                    i11 = 46;
                                                    i12 = 16;
                                                }
                                                int i255 = keyRepeatDelay >> i12;
                                                Object[] objArr26 = new Object[1];
                                                a(i10, cArr2, (byte) ((i11 & i255) + (i255 | i11)), objArr26);
                                                Class<?> cls6 = Class.forName((String) objArr26[0]);
                                                int i256 = -(-((byte) KeyEvent.getModifierMetaStateMask()));
                                                int i257 = (i256 ^ 12) + ((i256 & 12) << 1);
                                                char[] cArr12 = {' ', 29, 5, '/', '!', 24, 31, CoreConstants.SINGLE_QUOTE_CHAR, '$', '\n', 13809};
                                                int i258 = -(ViewConfiguration.getScrollBarFadeDuration() >> 16);
                                                int i259 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                int i260 = (i259 & 67) + (i259 | 67);
                                                int i261 = length;
                                                artificialFrame = i260 % 128;
                                                if (i260 % 2 == 0) {
                                                    i13 = ((i258 & (-523)) + (i258 | (-523))) * 18;
                                                    int i262 = ~i258;
                                                    i14 = (i262 ^ 14) | (i262 & 14);
                                                } else {
                                                    int i263 = i258 * (-523);
                                                    i13 = (i263 | 3682) + (i263 & 3682);
                                                    i14 = (~i258) | 14;
                                                }
                                                int i264 = ~i14;
                                                int i265 = i77;
                                                int i266 = ~((-15) | i258);
                                                int i267 = (i264 ^ i266) | (i266 & i264);
                                                int i268 = ~(((-15) ^ i) | ((-15) & i));
                                                int i269 = -(-(262 * ((i267 ^ i268) | (i267 & i268))));
                                                int i270 = (i13 & i269) + (i13 | i269);
                                                int i271 = i259 + 21;
                                                artificialFrame = i271 % 128;
                                                int i272 = i271 % 2;
                                                int i273 = ~(((-15) & i258) | ((-15) ^ i258));
                                                int i274 = -(-((-786) * i273));
                                                int i275 = (i270 & i274) + (i274 | i270);
                                                int i276 = ~(((-15) & i58) | ((-15) ^ i58));
                                                int i277 = ~i258;
                                                int i278 = ~((i277 & 14) | (i277 ^ 14));
                                                int i279 = (i278 & i276) | (i276 ^ i278);
                                                int i280 = -(-(((i273 & i279) | (i279 ^ i273)) * 262));
                                                Object[] objArr27 = new Object[1];
                                                a(i257, cArr12, (byte) ((i275 & i280) + (i280 | i275)), objArr27);
                                                try {
                                                    Object[] objArr28 = {new ByteArrayInputStream((byte[]) cls6.getMethod((String) objArr27[0], null).invoke(obj, null))};
                                                    int iIndexOf = TextUtils.indexOf((CharSequence) "", '0');
                                                    int i281 = ((iIndexOf | 38) << 1) - (iIndexOf ^ 38);
                                                    char[] cArr13 = {22, 11, 1, 7, CoreConstants.RIGHT_PARENTHESIS_CHAR, 23, 22, '!', CoreConstants.DASH_CHAR, CoreConstants.SINGLE_QUOTE_CHAR, 3, '!', CoreConstants.RIGHT_PARENTHESIS_CHAR, Typography.amp, '!', 22, CoreConstants.DASH_CHAR, Typography.amp, CoreConstants.RIGHT_PARENTHESIS_CHAR, CoreConstants.COMMA_CHAR, 24, CoreConstants.LEFT_PARENTHESIS_CHAR, '!', 3, '/', 3, '$', 15, '!', 24, 22, 15, 30, ' ', 31, '#', 13827};
                                                    int i282 = 16;
                                                    int pressedStateDuration = ViewConfiguration.getPressedStateDuration() >> 16;
                                                    int i283 = pressedStateDuration * 70;
                                                    int i284 = (i283 & (-2176)) + (i283 | (-2176));
                                                    int i285 = (~pressedStateDuration) | (-33);
                                                    int i286 = ~((i285 & i) | (i285 ^ i));
                                                    int i287 = (pressedStateDuration ^ 32) | (pressedStateDuration & 32);
                                                    int i288 = ~((i287 ^ i) | (i287 & i));
                                                    int i289 = ((i286 ^ i288) | (i286 & i288)) * 69;
                                                    int i290 = ((i284 | i289) << 1) - (i289 ^ i284);
                                                    int i291 = ~pressedStateDuration;
                                                    int i292 = artificialFrame + 31;
                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i292 % 128;
                                                    int i293 = i292 % 2;
                                                    int i294 = ~((i291 ^ 32) | (i291 & 32));
                                                    int i295 = ~((i291 & i) | (i291 ^ i));
                                                    int i296 = (i294 & i295) | (i294 ^ i295);
                                                    int i297 = ~((32 & i) | (32 ^ i));
                                                    int i298 = (-69) * ((i296 & i297) | (i296 ^ i297));
                                                    byte b6 = (byte) (((((i290 | i298) << 1) - (i298 ^ i290)) - (~(-(-((~(pressedStateDuration | (-33))) * 69))))) - 1);
                                                    Object[] objArr29 = new Object[1];
                                                    a(i281, cArr13, b6, objArr29);
                                                    Class<?> cls7 = Class.forName((String) objArr29[0]);
                                                    int i299 = artificialFrame;
                                                    int i300 = (i299 & 53) + (i299 | 53);
                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i300 % 128;
                                                    if (i300 % 2 != 0) {
                                                        Object[] objArr30 = new Object[1];
                                                        b(48157 - (ViewConfiguration.getScrollBarSize() % 118), new char[]{15053, 34514, 17150, 3736, 51884, 38490, 21104, 7684, 55809, 42954, 25594, 12257, 60319, 47029, 29525, 16250, 64283, 18227, 197}, objArr30);
                                                        String str2 = (String) objArr30[0];
                                                        Class<?>[] clsArr = new Class[0];
                                                        clsArr[0] = InputStream.class;
                                                        method = cls7.getMethod(str2, clsArr);
                                                    } else {
                                                        int i301 = -(ViewConfiguration.getScrollBarSize() >> 8);
                                                        Object[] objArr31 = new Object[1];
                                                        b((i301 ^ 48157) + ((48157 & i301) << 1), new char[]{15053, 34514, 17150, 3736, 51884, 38490, 21104, 7684, 55809, 42954, 25594, 12257, 60319, 47029, 29525, 16250, 64283, 18227, 197}, objArr31);
                                                        method = cls7.getMethod((String) objArr31[0], InputStream.class);
                                                    }
                                                    Object objInvoke4 = method.invoke(objInvoke3, objArr28);
                                                    int length2 = objArr3.length;
                                                    for (int i302 = 0; i302 < 2; i302 = ((i302 | 1) << 1) - (i302 ^ 1)) {
                                                        int i303 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                        int i304 = (i303 ^ 11) + ((i303 & 11) << 1);
                                                        artificialFrame = i304 % 128;
                                                        if (i304 % 2 == 0) {
                                                            Object obj2 = objArr3[i302];
                                                            Object obj3 = null;
                                                            obj3.hashCode();
                                                            throw null;
                                                        }
                                                        Object obj4 = objArr3[i302];
                                                        int i305 = (i303 & 97) + (i303 | 97);
                                                        artificialFrame = i305 % 128;
                                                        if (i305 % 2 == 0) {
                                                            int i306 = 2 / 4;
                                                        }
                                                        try {
                                                            int iIndexOf2 = TextUtils.indexOf("", "", 0, 0);
                                                            Object[] objArr32 = new Object[1];
                                                            a((iIndexOf2 & 34) + (iIndexOf2 | 34), new char[]{22, 11, 1, 7, CoreConstants.RIGHT_PARENTHESIS_CHAR, 23, 22, '!', CoreConstants.DASH_CHAR, CoreConstants.SINGLE_QUOTE_CHAR, 3, '!', CoreConstants.RIGHT_PARENTHESIS_CHAR, Typography.amp, '!', 22, CoreConstants.DASH_CHAR, Typography.amp, Typography.amp, 2, '\t', 16, CoreConstants.COMMA_CHAR, '*', 24, CoreConstants.LEFT_PARENTHESIS_CHAR, '!', 3, '/', 3, '$', 15, '!', 24}, (byte) (106 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)), objArr32);
                                                            Class<?> cls8 = Class.forName((String) objArr32[0]);
                                                            int i307 = -(PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                                                            int i308 = ((i307 | 23) << 1) - (i307 ^ 23);
                                                            char[] cArr14 = {5, 25, 29, 24, CoreConstants.DASH_CHAR, 11, 26, 27, 30, ' ', 4, 3, 13847, 13847, '\n', CoreConstants.RIGHT_PARENTHESIS_CHAR, 6, 0, '!', 1, '+', 7, 13923};
                                                            int i309 = -(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                                                            Object[] objArr33 = new Object[1];
                                                            a(i308, cArr14, (byte) ((i309 & b.f39n) + (i309 | b.f39n)), objArr33);
                                                            if (!(!obj4.equals(cls8.getMethod((String) objArr33[0], null).invoke(objInvoke4, null)))) {
                                                                int i310 = (i & (-2)) | (i58 & 1);
                                                                objArr = new Object[4];
                                                                int[] iArr2 = new int[1];
                                                                objArr[0] = iArr2;
                                                                int[] iArr3 = new int[1];
                                                                objArr[1] = iArr3;
                                                                int i311 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                                int i312 = (i311 ^ 115) + ((i311 & 115) << 1);
                                                                artificialFrame = i312 % 128;
                                                                if (i312 % 2 == 0) {
                                                                    objArr[2] = new int[0];
                                                                    i282 = 29;
                                                                } else {
                                                                    objArr[2] = new int[1];
                                                                }
                                                                iArr2[0] = i;
                                                                iArr3[0] = i310;
                                                                objArr[3] = null;
                                                                int i313 = (-991129122) + ((i | 422932826) * 140) + (((~(422932826 | i58)) | 537528964) * (-280)) + (((~(555690948 | i58)) | 404770842 | (~((-537528965) | i))) * 140);
                                                                int iINotificationSideChannelStubProxy6 = BytesValue.Builder.INotificationSideChannelStubProxy();
                                                                int i314 = getARTIFICIAL_FRAME_PACKAGE_NAME + 117;
                                                                int i315 = i314 % 128;
                                                                artificialFrame = i315;
                                                                int i316 = i314 % 2;
                                                                int i317 = (i282 * 302) + (i313 * TypedValues.MotionType.TYPE_EASING);
                                                                int i318 = ~i282;
                                                                int i319 = ~iINotificationSideChannelStubProxy6;
                                                                int i320 = ~((i319 & i318) | (i318 ^ i319));
                                                                int i321 = i317 + (((i320 & i313) | (i313 ^ i320)) * (-602));
                                                                int i322 = ~i282;
                                                                int i323 = ~i313;
                                                                int i324 = ~((i322 & i323) | (i322 ^ i323));
                                                                int i325 = ~((i318 & iINotificationSideChannelStubProxy6) | (i318 ^ iINotificationSideChannelStubProxy6));
                                                                int i326 = (i325 & i324) | (i324 ^ i325);
                                                                int i327 = ~iINotificationSideChannelStubProxy6;
                                                                int i328 = (i315 & AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) + (i315 | AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
                                                                int i329 = i328 % 128;
                                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i329;
                                                                if (i328 % 2 != 0) {
                                                                    int i330 = (i327 ^ i282) | (i282 & i327);
                                                                    int i331 = ~((i330 & i313) | (i330 ^ i313));
                                                                    int i332 = i321 << ((-301) >> ((i326 & i331) | (i326 ^ i331)));
                                                                    int i333 = 301 - (~((i327 & i313) | (i327 ^ i313)));
                                                                    i16 = i2 % ((i332 & i333) + (i333 | i332));
                                                                    i15 = 1;
                                                                    i17 = 30;
                                                                } else {
                                                                    int i334 = (i327 ^ i282) | (i282 & i327);
                                                                    int i335 = ~((i334 & i313) | (i334 ^ i313));
                                                                    int i336 = i2 - (~(-(-(((i321 - (~(-(-(((i326 & i335) | (i326 ^ i335)) * (-301)))))) - 1) + ((~((i327 & i313) | (i327 ^ i313))) * 301)))));
                                                                    i15 = 1;
                                                                    i16 = i336 - 1;
                                                                    i17 = 13;
                                                                }
                                                                int i337 = ((i329 | 33) << i15) - (i329 ^ 33);
                                                                artificialFrame = i337 % 128;
                                                                int i338 = i16 << i17;
                                                                if (i337 % 2 == 0) {
                                                                    int i339 = (i16 | i338) & (~(i16 & i338));
                                                                    int i340 = i339 >>> 28;
                                                                    int i341 = ((~i339) & i340) | ((~i340) & i339);
                                                                    int i342 = ((i341 | 4) << 1) - (i341 ^ 4);
                                                                    ((int[]) objArr[2])[0] = (i341 | i342) & (~(i341 & i342));
                                                                } else {
                                                                    int i343 = ((~i16) & i338) | ((~i338) & i16);
                                                                    int i344 = i343 >>> 17;
                                                                    int i345 = (i343 | i344) & (~(i343 & i344));
                                                                    int i346 = i345 << 5;
                                                                    ((int[]) objArr[2])[0] = ((~i345) & i346) | ((~i346) & i345);
                                                                }
                                                                i3 = 2;
                                                            }
                                                        } catch (Throwable th) {
                                                            Throwable cause = th.getCause();
                                                            if (cause != null) {
                                                                throw cause;
                                                            }
                                                            throw th;
                                                        }
                                                    }
                                                    int i347 = i217 + 107;
                                                    i217 = (i347 ^ (-106)) + ((i347 & (-106)) << 1);
                                                    objArr20 = objArr24;
                                                    length = i261;
                                                    i77 = i265;
                                                    i21 = 1;
                                                    i214 = 5;
                                                } catch (Throwable th2) {
                                                    Throwable cause2 = th2.getCause();
                                                    if (cause2 != null) {
                                                        throw cause2;
                                                    }
                                                    throw th2;
                                                }
                                            } catch (Throwable th3) {
                                                Throwable cause3 = th3.getCause();
                                                if (cause3 != null) {
                                                    throw cause3;
                                                }
                                                throw th3;
                                            }
                                        } catch (Throwable th4) {
                                            Throwable cause4 = th4.getCause();
                                            if (cause4 != null) {
                                                throw cause4;
                                            }
                                            throw th4;
                                        }
                                    }
                                } catch (Throwable th5) {
                                    Throwable cause5 = th5.getCause();
                                    if (cause5 != null) {
                                        throw cause5;
                                    }
                                    throw th5;
                                }
                            } catch (Throwable th6) {
                                Throwable cause6 = th6.getCause();
                                if (cause6 != null) {
                                    throw cause6;
                                }
                                throw th6;
                            }
                        } catch (Throwable th7) {
                            Throwable cause7 = th7.getCause();
                            if (cause7 != null) {
                                throw cause7;
                            }
                            throw th7;
                        }
                    } catch (Throwable th8) {
                        Throwable cause8 = th8.getCause();
                        if (cause8 != null) {
                            throw cause8;
                        }
                        throw th8;
                    }
                } catch (Throwable th9) {
                    Throwable cause9 = th9.getCause();
                    if (cause9 != null) {
                        throw cause9;
                    }
                    throw th9;
                }
            } catch (Throwable unused) {
            }
            objArr = new Object[]{new int[]{i}, new int[]{i}, new int[1], null};
            int iMyTid = Process.myTid();
            int i348 = ~iMyTid;
            int i349 = (~((-231808942) | i348)) | 22020748;
            int i350 = ~(iMyTid | (-537026641));
            int i351 = (-1148357062) + ((i349 | i350) * (-713)) + (i350 * 1426) + ((~((-746814834) | i348)) * 713);
            int i352 = (i2 & i351) + (i2 | i351);
            int i353 = i352 << 13;
            int i354 = (i352 | i353) & (~(i352 & i353));
            int i355 = i354 >>> 17;
            int i356 = (i354 | i355) & (~(i354 & i355));
            i3 = 2;
            ((int[]) objArr[2])[0] = i356 ^ (i356 << 5);
        }
        int i357 = getARTIFICIAL_FRAME_PACKAGE_NAME + 39;
        artificialFrame = i357 % 128;
        int i358 = i357 % i3;
        return objArr;
    }
}
