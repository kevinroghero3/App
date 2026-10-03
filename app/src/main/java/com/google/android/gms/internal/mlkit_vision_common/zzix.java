package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.CoreConstants;
import com.facebook.imageutils.JfifUtil;
import com.google.android.material.datepicker.SmoothCalendarLayoutManager;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import kotlin.text.Typography;
import o.ArtificialStackFrames;
import o._CREATION;
import o.extraCallback;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class zzix {
    private static final byte[] $$a = {96, -63, 33, 4};
    private static final int $$b = 78;
    private static int $10 = 0;
    private static int $11 = 1;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] ArtificialStackFrames = {44397, 44368, 44376, 44392, 44354, 44398, 44361, 44696, 44399, 44403, 44367, 44336, 44408, 44349, 44394, 44334, 44702, 44332, 44390, 44358, 44320, 44402, 44409, 44393, 44341, 44384, 44385, 44400, 44404, 44388, 44396, 44355, 44698, 44353, 44406, 44386, 44387, 44405, 44371, 44389, 44699, 44365, 44395, 44697, 44356, 44373, 44391, 44366, 44345};
    private static char coroutineCreation = 39069;
    private static char[] _CREATION = {6553, 19986, 46744, 7989, 18363, 44080, 5283, 32032, 42449, 2634, 29418, 56188, 1023, 26734, 30135, 8764, 55990, 29467, 11157, 49182, 30861, 4366, 51711, 26212, 7875, 46941, 28634, 1098, 7441, 19095, 45574, 7065, 17211, 43188, 4130, 31201, 41307, 3790, 30276, 57319, 1913, 27883, 54394, 15449, 26000, 52484, 15100, 25099, 52133, 13102, 39133, 49246, 10703, 37236, 65235, 9837, 36842, 63386, 6541, 19998, 46731, 7947, 18363, 44071, 5309, 32051, 42451, 2652, 10220, 28691, 34963, 8479, 31145, 6559, 19993, 46728, 7959, 18357, 44090, 5292, 32111, 42453, 2624, 29386, 56169, 1015, 26725, 53492, 14551, 24862, 51594, 15986, 26246, 53027, 14244, 40022, 50384, 11602, 38378, 64102, 8936, 6553, 19986, 46722, 7936, 18344, 44082, 5308, 32036, 42485, 2634, 29398, 56169, 1019, 26733, 53481, 14490, 24847, 51603, 15929};
    private static long _BOUNDARY = 8122297610734095991L;

    /* JADX WARN: Code duplicated, block: B:10:0x0020  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0020 -> B:11:0x0024). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0020
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$c(byte r5, byte r6, short r7) {
        /*
            int r5 = r5 + 97
            int r7 = r7 * 2
            int r0 = r7 + 1
            int r6 = r6 * 4
            int r6 = r6 + 4
            byte[] r1 = com.google.android.gms.internal.mlkit_vision_common.zzix.$$a
            byte[] r0 = new byte[r0]
            r2 = 0
            if (r1 != 0) goto L14
            r4 = r7
            r3 = r2
            goto L24
        L14:
            r3 = r2
        L15:
            byte r4 = (byte) r5
            r0[r3] = r4
            if (r3 != r7) goto L20
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            return r5
        L20:
            r4 = r1[r6]
            int r3 = r3 + 1
        L24:
            int r5 = r5 + r4
            int r6 = r6 + 1
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzix.$$c(byte, byte, short):java.lang.String");
    }

    private static void b(int i, char c, int i2, Object[] objArr) throws Throwable {
        int i3 = 2 % 2;
        _CREATION _creation = new _CREATION();
        long[] jArr = new long[i];
        _creation.b = 0;
        int i4 = $11 + 81;
        $10 = i4 % 128;
        int i5 = i4 % 2;
        while (_creation.b < i) {
            int i6 = $11 + 107;
            $10 = i6 % 128;
            if (i6 % 2 != 0) {
                int i7 = _creation.b;
                try {
                    Object[] objArr2 = {Integer.valueOf(_CREATION[i2 + i7])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) 0;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(View.MeasureSpec.makeMeasureSpec(0, 0) + 8, (char) (9279 - (ViewConfiguration.getJumpTapTimeout() >> 16)), 1977 - (ViewConfiguration.getTouchSlop() >> 8), 1113883676, false, $$c((byte) 7, b, b), new Class[]{Integer.TYPE});
                    }
                    Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i7), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                    if (objAccessartificialFrame2 == null) {
                        byte b2 = (byte) 0;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(30 - Color.red(0), (char) (49362 - (ViewConfiguration.getTouchSlop() >> 8)), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 684, -115095555, false, $$c((byte) 9, b2, b2), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                    }
                    jArr[i7] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                    Object[] objArr4 = {_creation, _creation};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                    if (objAccessartificialFrame3 == null) {
                        byte b3 = (byte) 0;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(View.combineMeasuredStates(0, 0) + 25, (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 30067), TextUtils.lastIndexOf("", '0', 0) + 817, 1897803493, false, $$c((byte) ($$b & 23), b3, b3), new Class[]{Object.class, Object.class});
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
                int i8 = _creation.b;
                Object[] objArr5 = {Integer.valueOf(_CREATION[i2 + i8])};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-587087340);
                if (objAccessartificialFrame4 == null) {
                    byte b4 = (byte) 0;
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(8 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (9278 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), 1977 - Color.argb(0, 0, 0, 0), 1113883676, false, $$c((byte) 7, b4, b4), new Class[]{Integer.TYPE});
                }
                Object[] objArr6 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).longValue()), Long.valueOf(i8), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1715896821);
                if (objAccessartificialFrame5 == null) {
                    byte b5 = (byte) 0;
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 30, (char) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 49362), 685 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), -115095555, false, $$c((byte) 9, b5, b5), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                }
                jArr[i8] = ((Long) ((Method) objAccessartificialFrame5).invoke(null, objArr6)).longValue();
                Object[] objArr7 = {_creation, _creation};
                Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-293902099);
                if (objAccessartificialFrame6 == null) {
                    byte b6 = (byte) 0;
                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 24, (char) (TextUtils.getCapsMode("", 0, 0) + 30068), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 815, 1897803493, false, $$c((byte) ($$b & 23), b6, b6), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame6).invoke(null, objArr7);
            }
        }
        char[] cArr = new char[i];
        _creation.b = 0;
        int i9 = $11 + 35;
        $10 = i9 % 128;
        int i10 = i9 % 2;
        while (_creation.b < i) {
            int i11 = $10 + 55;
            $11 = i11 % 128;
            int i12 = i11 % 2;
            cArr[_creation.b] = (char) jArr[_creation.b];
            try {
                Object[] objArr8 = {_creation, _creation};
                Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-293902099);
                if (objAccessartificialFrame7 == null) {
                    byte b7 = (byte) 0;
                    objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(AndroidCharacter.getMirror('0') - 23, (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 30069), 817 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 1897803493, false, $$c((byte) ($$b & 23), b7, b7), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame7).invoke(null, objArr8);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        objArr[0] = new String(cArr);
    }

    private static void a(int i, char[] cArr, byte b, Object[] objArr) throws Throwable {
        int i2;
        int i3 = 2;
        int i4 = 2 % 2;
        extraCallback extracallback = new extraCallback();
        char[] cArr2 = ArtificialStackFrames;
        long j = 0;
        float f = 0.0f;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i5 = 0;
            while (i5 < length) {
                int i6 = $10 + 29;
                $11 = i6 % 128;
                if (i6 % i3 == 0) {
                    try {
                        Object[] objArr2 = {Integer.valueOf(cArr2[i5])};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1819279892);
                        if (objAccessartificialFrame == null) {
                            int iResolveSizeAndState = View.resolveSizeAndState(0, 0, 0) + 15;
                            char c = (char) (20489 - (SystemClock.elapsedRealtimeNanos() > j ? 1 : (SystemClock.elapsedRealtimeNanos() == j ? 0 : -1)));
                            int i7 = 2148 - (TypedValue.complexToFraction(0, f, f) > f ? 1 : (TypedValue.complexToFraction(0, f, f) == f ? 0 : -1));
                            byte b2 = (byte) 0;
                            byte b3 = b2;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState, c, i7, 216710116, false, $$c(b2, b3, b3), new Class[]{Integer.TYPE});
                        }
                        cArr3[i5] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                        i5 %= 1;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } else {
                    Object[] objArr3 = {Integer.valueOf(cArr2[i5])};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1819279892);
                    if (objAccessartificialFrame2 == null) {
                        byte b4 = (byte) 0;
                        byte b5 = b4;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(16 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (20488 - TextUtils.getOffsetBefore("", 0)), 2149 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), 216710116, false, $$c(b4, b5, b5), new Class[]{Integer.TYPE});
                    }
                    cArr3[i5] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                    i5++;
                }
                i3 = 2;
                j = 0;
                f = 0.0f;
            }
            cArr2 = cArr3;
        }
        Object[] objArr4 = {Integer.valueOf(coroutineCreation)};
        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1819279892);
        if (objAccessartificialFrame3 == null) {
            byte b6 = (byte) 0;
            byte b7 = b6;
            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(15 - Color.green(0), (char) (TextUtils.lastIndexOf("", '0', 0) + 20489), 2148 - View.combineMeasuredStates(0, 0), 216710116, false, $$c(b6, b7, b7), new Class[]{Integer.TYPE});
        }
        char cCharValue = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).charValue();
        char[] cArr4 = new char[i];
        if (i % 2 != 0) {
            i2 = i - 1;
            cArr4[i2] = (char) (cArr[i2] - b);
        } else {
            i2 = i;
        }
        if (i2 > 1) {
            int i8 = $11 + 75;
            $10 = i8 % 128;
            int i9 = i8 % 2;
            extracallback.a = 0;
            while (extracallback.a < i2) {
                int i10 = $10 + 1;
                $11 = i10 % 128;
                int i11 = i10 % 2;
                extracallback.createBrowser = cArr[extracallback.a];
                extracallback.c = cArr[extracallback.a + 1];
                if (extracallback.createBrowser == extracallback.c) {
                    cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                    cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                } else {
                    Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1894223152);
                    if (objAccessartificialFrame4 == null) {
                        int i12 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 47;
                        char touchSlop = (char) ((ViewConfiguration.getTouchSlop() >> 8) + 58859);
                        int i13 = 2464 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                        byte b8 = (byte) ($$a[3] + 1);
                        byte b9 = (byte) (b8 - 5);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i12, touchSlop, i13, 276640984, false, $$c(b8, b9, b9), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                    }
                    if (((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue() == extracallback.g) {
                        int i14 = $10 + 69;
                        $11 = i14 % 128;
                        int i15 = i14 % 2;
                        try {
                            Object[] objArr6 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                            Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1361113423);
                            if (objAccessartificialFrame5 == null) {
                                byte b10 = (byte) 0;
                                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 24, (char) (TextUtils.indexOf((CharSequence) "", '0') + 1), 792 - KeyEvent.normalizeMetaState(0), -834291897, false, $$c((byte) ($$b & 56), b10, b10), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                            }
                            int iIntValue = ((Integer) ((Method) objAccessartificialFrame5).invoke(null, objArr6)).intValue();
                            int i16 = (extracallback.d * cCharValue) + extracallback.g;
                            cArr4[extracallback.a] = cArr2[iIntValue];
                            cArr4[extracallback.a + 1] = cArr2[i16];
                        } catch (Throwable th2) {
                            Throwable cause2 = th2.getCause();
                            if (cause2 == null) {
                                throw th2;
                            }
                            throw cause2;
                        }
                    } else if (extracallback.b == extracallback.d) {
                        extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                        extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                        int i17 = (extracallback.b * cCharValue) + extracallback.j;
                        int i18 = (extracallback.d * cCharValue) + extracallback.g;
                        cArr4[extracallback.a] = cArr2[i17];
                        cArr4[extracallback.a + 1] = cArr2[i18];
                    } else {
                        int i19 = (extracallback.b * cCharValue) + extracallback.g;
                        int i20 = (extracallback.d * cCharValue) + extracallback.j;
                        cArr4[extracallback.a] = cArr2[i19];
                        cArr4[extracallback.a + 1] = cArr2[i20];
                    }
                }
                extracallback.a += 2;
            }
        }
        for (int i21 = 0; i21 < i; i21++) {
            int i22 = $10 + 121;
            $11 = i22 % 128;
            int i23 = i22 % 2;
            cArr4[i21] = (char) (cArr4[i21] ^ 13722);
        }
        objArr[0] = new String(cArr4);
    }

    public static Object[] accessartificialFrame(Context context, int i, int i2) {
        int i3;
        int iValidateRelationship;
        Object obj;
        int i4;
        char[] cArr;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        Object obj2;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17 = 2 % 2;
        if (context == null) {
            int i18 = artificialFrame + 57;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i18 % 128;
            int i19 = i18 % 2;
            Object[] objArr = {new int[]{i}, new int[]{i}, new int[1], null};
            int i20 = ~((int) SystemClock.uptimeMillis());
            int i21 = (-1986790910) + (((-419961349) | i20) * 494) + (((~(i20 | 548880857)) | (-959060637)) * 494);
            int i22 = (i21 << 1) - i21;
            int iValidateRelationship2 = SmoothCalendarLayoutManager.validateRelationship();
            int i23 = (i22 * (-1529)) + (i2 * (-764));
            int i24 = ~i22;
            int i25 = ~i2;
            int i26 = (i24 ^ i25) | (i24 & i25);
            int i27 = ~iValidateRelationship2;
            int i28 = ~((i26 ^ i27) | (i26 & i27));
            int i29 = (i24 ^ i2) | (i24 & i2);
            int i30 = ~((i29 & iValidateRelationship2) | (i29 ^ iValidateRelationship2));
            int i31 = (i28 & i30) | (i28 ^ i30);
            int i32 = ~((i25 & i22) | (i25 ^ i22) | iValidateRelationship2);
            int i33 = -(-(((i32 & i31) | (i31 ^ i32)) * 765));
            int i34 = (i23 ^ i33) + ((i23 & i33) << 1);
            int i35 = ~i26;
            int i36 = ~(i24 | i27);
            int i37 = -(-(((i35 & i36) | (i35 ^ i36)) * 1530));
            int i38 = (i34 & i37) + (i37 | i34);
            int i39 = ~((i24 ^ iValidateRelationship2) | (i24 & iValidateRelationship2));
            int i40 = ~i2;
            int i41 = ~iValidateRelationship2;
            int i42 = (i38 - (~(((~(i22 | ((i40 & i41) | (i40 ^ i41)))) | i39) * 765))) - 1;
            int i43 = i42 << 13;
            int i44 = (i43 & (~i42)) | ((~i43) & i42);
            int i45 = i44 >>> 17;
            int i46 = ((~i44) & i45) | ((~i45) & i44);
            int i47 = i46 << 5;
            ((int[]) objArr[2])[0] = (i46 | i47) & (~(i46 & i47));
            int i48 = getARTIFICIAL_FRAME_PACKAGE_NAME + 59;
            artificialFrame = i48 % 128;
            int i49 = i48 % 2;
            return objArr;
        }
        try {
            int i50 = -(-View.MeasureSpec.makeMeasureSpec(0, 0));
            int i51 = (i50 & 38) + (i50 | 38);
            char[] cArr2 = {19, 21, '!', 27, '\b', 19, 11, CoreConstants.PERCENT_CHAR, CoreConstants.PERCENT_CHAR, Typography.amp, 22, 24, 29, 21, 19, 22, '#', 30, 1, 17, '\n', 26, 13826, 13826, 16, 1, 25, '\n', '\b', 4, 22, 24, 1, CoreConstants.LEFT_PARENTHESIS_CHAR, 24, 21, 23, '!'};
            int i52 = artificialFrame + 87;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i52 % 128;
            if (i52 % 2 != 0) {
                Object[] objArr2 = new Object[1];
                a(i51, cArr2, (byte) (88 >>> TextUtils.indexOf("", "", 0)), objArr2);
                obj = objArr2[0];
            } else {
                int i53 = -(-TextUtils.indexOf("", "", 0));
                Object[] objArr3 = new Object[1];
                a(i51, cArr2, (byte) ((i53 & 88) + (i53 | 88)), objArr3);
                obj = objArr3[0];
            }
            Object[] objArr4 = (Object[]) Array.newInstance(Class.forName((String) obj), 2);
            int iRgb = (-16777185) - Color.rgb(0, 0, 0);
            char[] cArr3 = {'!', CoreConstants.DASH_CHAR, '\f', '\"', 1, '!', 22, 7, 22, 30, 16, '0', CoreConstants.LEFT_PARENTHESIS_CHAR, '$', CoreConstants.SINGLE_QUOTE_CHAR, CoreConstants.COMMA_CHAR, 24, 17, '\f', '\"', 1, '!', 22, 7, 22, 30, 24, Typography.amp, '\n', '0', 13850};
            int i54 = -(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
            Object[] objArr5 = new Object[1];
            a(iRgb, cArr3, (byte) ((i54 & 82) + (i54 | 82)), objArr5);
            String str = (String) objArr5[0];
            int i55 = getARTIFICIAL_FRAME_PACKAGE_NAME + 17;
            artificialFrame = i55 % 128;
            int i56 = i55 % 2;
            try {
                int i57 = -TextUtils.indexOf((CharSequence) "", '0', 0);
                int iValidateRelationship3 = SmoothCalendarLayoutManager.validateRelationship();
                int i58 = (i57 * 284) - 10434;
                int i59 = ~i57;
                int i60 = ~((i59 ^ 37) | (i59 & 37));
                int i61 = ~i57;
                int i62 = ~((i61 ^ iValidateRelationship3) | (i61 & iValidateRelationship3));
                int i63 = ((i60 ^ i62) | (i62 & i60)) * (-283);
                int i64 = (i58 & i63) + (i63 | i58);
                int i65 = -(-((~((-38) | i57)) * 283));
                int i66 = (i64 & i65) + (i65 | i64);
                int i67 = (i61 ^ (-38)) | (i61 & (-38));
                int i68 = i66 + ((~((i67 & iValidateRelationship3) | (i67 ^ iValidateRelationship3))) * 283);
                char[] cArr4 = {19, 21, '!', 27, '\b', 19, 11, CoreConstants.PERCENT_CHAR, CoreConstants.PERCENT_CHAR, Typography.amp, 22, 24, 29, 21, 19, 22, '#', 30, 1, 17, '\n', 26, 13826, 13826, 16, 1, 25, '\n', '\b', 4, 22, 24, 1, CoreConstants.LEFT_PARENTHESIS_CHAR, 24, 21, 23, '!'};
                int i69 = -TextUtils.indexOf("", "", 0);
                Object[] objArr6 = new Object[1];
                a(i68, cArr4, (byte) ((i69 ^ 88) + ((i69 & 88) << 1)), objArr6);
                objArr4[0] = Class.forName((String) objArr6[0]).getDeclaredConstructor(String.class).newInstance(str);
                int i70 = -TextUtils.indexOf((CharSequence) "", '0', 0);
                int iValidateRelationship4 = SmoothCalendarLayoutManager.validateRelationship();
                int i71 = i70 * JfifUtil.MARKER_EOI;
                int i72 = ((i71 | (-6450)) << 1) - (i71 ^ (-6450));
                int i73 = (~((i70 ^ iValidateRelationship4) | (i70 & iValidateRelationship4))) * JfifUtil.MARKER_SOI;
                int i74 = (i72 ^ i73) + ((i73 & i72) << 1);
                int i75 = (i70 ^ (-31)) | (i70 & (-31));
                int i76 = ~iValidateRelationship4;
                int i77 = (i74 - (~(-(-(((i75 & i76) | (i75 ^ i76)) * (-216)))))) - 1;
                int i78 = ~iValidateRelationship4;
                int i79 = ~((i70 & i78) | (i78 ^ i70));
                Object[] objArr7 = new Object[1];
                a(i77 + (((i79 & 30) | (i79 ^ 30)) * JfifUtil.MARKER_SOI), new char[]{'\"', '\n', 3, CoreConstants.DASH_CHAR, 24, 17, '\f', '\"', 1, '!', 22, 7, 22, 30, 24, Typography.amp, '0', '\f', CoreConstants.LEFT_PARENTHESIS_CHAR, '\f', 28, 22, '\t', 22, '\"', 15, '.', CoreConstants.PERCENT_CHAR, '$', Typography.amp, 13942}, (byte) (120 - (~(-(-KeyEvent.getDeadChar(0, 0))))), objArr7);
                try {
                    Object[] objArr8 = {(String) objArr7[0]};
                    long packedPositionForChild = ExpandableListView.getPackedPositionForChild(0, 0);
                    int i80 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i81 = (i80 & 113) + (i80 | 113);
                    artificialFrame = i81 % 128;
                    if (i81 % 2 == 0) {
                        i4 = 38 - (~(-(packedPositionForChild > 1L ? 1 : (packedPositionForChild == 1L ? 0 : -1))));
                        cArr = new char[]{19, 21, '!', 27, '\b', 19, 11, CoreConstants.PERCENT_CHAR, CoreConstants.PERCENT_CHAR, Typography.amp, 22, 24, 29, 21, 19, 22, '#', 30, 1, 17, '\n', 26, 13826, 13826, 16, 1, 25, '\n', '\b', 4, 22, 24, 1, CoreConstants.LEFT_PARENTHESIS_CHAR, 24, 21, 23, '!'};
                        int i82 = -(SystemClock.elapsedRealtime() > 1L ? 1 : (SystemClock.elapsedRealtime() == 1L ? 0 : -1));
                        i5 = i82 ^ 107;
                        i6 = i82 & 107;
                    } else {
                        i4 = (packedPositionForChild > 0L ? 1 : (packedPositionForChild == 0L ? 0 : -1)) + 39;
                        cArr = new char[]{19, 21, '!', 27, '\b', 19, 11, CoreConstants.PERCENT_CHAR, CoreConstants.PERCENT_CHAR, Typography.amp, 22, 24, 29, 21, 19, 22, '#', 30, 1, 17, '\n', 26, 13826, 13826, 16, 1, 25, '\n', '\b', 4, 22, 24, 1, CoreConstants.LEFT_PARENTHESIS_CHAR, 24, 21, 23, '!'};
                        int i83 = -(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                        i5 = i83 ^ 89;
                        i6 = i83 & 89;
                    }
                    byte b = (byte) (i5 + (i6 << 1));
                    Object[] objArr9 = new Object[1];
                    a(i4, cArr, b, objArr9);
                    Class<?> cls = Class.forName((String) objArr9[0]);
                    Class<?>[] clsArr = new Class[1];
                    int i84 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i85 = (i84 ^ 23) + ((i84 & 23) << 1);
                    artificialFrame = i85 % 128;
                    int i86 = i85 % 2;
                    clsArr[0] = String.class;
                    objArr4[1] = cls.getDeclaredConstructor(clsArr).newInstance(objArr8);
                    try {
                        Object[] objArr10 = new Object[1];
                        a(22 - (~(-KeyEvent.normalizeMetaState(0))), new char[]{'!', '\f', 28, 22, '\t', 22, '$', 22, '+', 15, 0, '!', CoreConstants.LEFT_PARENTHESIS_CHAR, 4, 29, 14, 29, '\n', 0, '!', CoreConstants.LEFT_PARENTHESIS_CHAR, 11, 13906}, (byte) (99 - (~(ViewConfiguration.getKeyRepeatDelay() >> 16))), objArr10);
                        Class<?> cls2 = Class.forName((String) objArr10[0]);
                        int threadPriority = ((Process.getThreadPriority(0) + 20) >> 6) + 17;
                        char[] cArr5 = {4, '.', 29, 0, 22, CoreConstants.LEFT_PARENTHESIS_CHAR, '/', 21, 4, '.', CoreConstants.LEFT_PARENTHESIS_CHAR, 27, '\f', '!', 4, '.', 13902};
                        int i87 = -View.MeasureSpec.getSize(0);
                        int iValidateRelationship5 = SmoothCalendarLayoutManager.validateRelationship();
                        int i88 = getARTIFICIAL_FRAME_PACKAGE_NAME + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                        artificialFrame = i88 % 128;
                        if (i88 % 2 == 0) {
                            i7 = ((-500) % i87) >>> (-4);
                        } else {
                            int i89 = i87 * (-500);
                            i7 = (i89 ^ (-51000)) + ((i89 & (-51000)) << 1);
                        }
                        int i90 = ~(((-103) ^ i87) | ((-103) & i87));
                        int i91 = ~i87;
                        int i92 = ~((i91 ^ 102) | (i91 & 102) | iValidateRelationship5);
                        int i93 = (i7 - (~(TypedValues.PositionType.TYPE_TRANSITION_EASING * ((i90 ^ i92) | (i92 & i90))))) - 1;
                        int i94 = -(-((~((i91 ^ (-103)) | (i91 & (-103)))) * 1002));
                        int i95 = (i93 ^ i94) + ((i94 & i93) << 1);
                        int i96 = (~i87) | (~iValidateRelationship5);
                        Object[] objArr11 = new Object[1];
                        a(threadPriority, cArr5, (byte) (i95 + ((~((i96 & 102) | (i96 ^ 102))) * TypedValues.PositionType.TYPE_TRANSITION_EASING)), objArr11);
                        Method method = cls2.getMethod((String) objArr11[0], null);
                        int i97 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i98 = (i97 ^ 93) + ((i97 & 93) << 1);
                        artificialFrame = i98 % 128;
                        Object obj3 = null;
                        if (i98 % 2 == 0) {
                            method.invoke(context, null);
                            obj3.hashCode();
                            throw null;
                        }
                        Object objInvoke = method.invoke(context, null);
                        try {
                            int i99 = 24 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                            char[] cArr6 = {'!', '\f', 28, 22, '\t', 22, '$', 22, '+', 15, 0, '!', CoreConstants.LEFT_PARENTHESIS_CHAR, 4, 29, 14, 29, '\n', 0, '!', CoreConstants.LEFT_PARENTHESIS_CHAR, 11, 13906};
                            int i100 = -(ViewConfiguration.getKeyRepeatTimeout() >> 16);
                            int iValidateRelationship6 = SmoothCalendarLayoutManager.validateRelationship();
                            int i101 = i100 * 868;
                            int i102 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                            int i103 = ((i102 | 99) << 1) - (i102 ^ 99);
                            artificialFrame = i103 % 128;
                            int i104 = i103 % 2;
                            int i105 = (i101 ^ 86800) + ((i101 & 86800) << 1);
                            int i106 = ~i100;
                            int i107 = ~iValidateRelationship6;
                            int i108 = ~((i106 ^ i107) | (i106 & i107));
                            int i109 = ~iValidateRelationship6;
                            int i110 = -(-((i108 | (~(((-101) ^ i109) | ((-101) & i109)))) * (-867)));
                            int i111 = (i105 ^ i110) + ((i110 & i105) << 1);
                            int i112 = ~i100;
                            int i113 = i102 + 119;
                            artificialFrame = i113 % 128;
                            int i114 = i113 % 2;
                            int i115 = -(-((-1734) * ((~((i106 & iValidateRelationship6) | (i106 ^ iValidateRelationship6))) | (~((i112 ^ (-101)) | (i112 & (-101)))) | (~(((-101) ^ iValidateRelationship6) | ((-101) & iValidateRelationship6))))));
                            int i116 = ((i111 | i115) << 1) - (i111 ^ i115);
                            int i117 = i112 | (-101);
                            int i118 = ~((i117 & i107) | (i117 ^ i107));
                            int i119 = (i112 & 100) | (i112 ^ 100);
                            int i120 = ~((i119 & iValidateRelationship6) | (i119 ^ iValidateRelationship6));
                            int i121 = (i120 & i118) | (i118 ^ i120);
                            int i122 = (i100 & (-101)) | ((-101) ^ i100);
                            int i123 = ~((i122 & iValidateRelationship6) | (i122 ^ iValidateRelationship6));
                            int i124 = -(-(((i123 & i121) | (i121 ^ i123)) * 867));
                            Object[] objArr12 = new Object[1];
                            a(i99, cArr6, (byte) ((i116 ^ i124) + ((i124 & i116) << 1)), objArr12);
                            String str2 = (String) objArr12[0];
                            int i125 = artificialFrame;
                            int i126 = (i125 & 45) + (i125 | 45);
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i126 % 128;
                            int i127 = i126 % 2;
                            Class<?> cls3 = Class.forName(str2);
                            int i128 = -(TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                            int i129 = (i128 & 14) + (i128 | 14);
                            char jumpTapTimeout = (char) (ViewConfiguration.getJumpTapTimeout() >> 16);
                            int threadPriority2 = Process.getThreadPriority(0);
                            int i130 = artificialFrame;
                            int i131 = i130 + 71;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i131 % 128;
                            int i132 = i131 % 2;
                            int i133 = threadPriority2 * (-112);
                            int i134 = ((-2240) ^ i133) + ((i133 & (-2240)) << 1);
                            int i135 = ~threadPriority2;
                            int i136 = ~i;
                            int i137 = ~((i135 ^ i136) | (i135 & i136));
                            int i138 = ((20 ^ i137) | (i137 & 20)) * 226;
                            int i139 = ((i134 | i138) << 1) - (i134 ^ i138);
                            int i140 = ~(((-21) ^ threadPriority2) | ((-21) & threadPriority2));
                            int i141 = ~(((-21) ^ i) | ((-21) & i));
                            int i142 = (i140 ^ i141) | (i141 & i140);
                            int i143 = ~i;
                            int i144 = i135 | i143;
                            int i145 = ~((i144 ^ 20) | (i144 & 20));
                            int i146 = -(-(((i145 & i142) | (i142 ^ i145)) * (-113)));
                            int i147 = ((i139 | i146) << 1) - (i139 ^ i146);
                            int i148 = i130 + 101;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i148 % 128;
                            int i149 = i148 % 2;
                            int i150 = 113 * (~((~threadPriority2) | i));
                            Object[] objArr13 = new Object[1];
                            b(i129, jumpTapTimeout, ((i147 & i150) + (i150 | i147)) >> 6, objArr13);
                            try {
                                Object[] objArr14 = {cls3.getMethod((String) objArr13[0], null).invoke(context, null), 64};
                                int threadPriority3 = Process.getThreadPriority(0);
                                int i151 = -(-(threadPriority3 * 471));
                                int i152 = (4720 ^ i151) + ((i151 & 4720) << 1);
                                int i153 = ~(((-21) & i143) | ((-21) ^ i143));
                                int i154 = i152 + (((i153 & threadPriority3) | (threadPriority3 ^ i153)) * (-235));
                                int i155 = artificialFrame + 29;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i155 % 128;
                                int i156 = i155 % 2;
                                int i157 = ~(((-21) ^ i) | ((-21) & i));
                                int i158 = -(-((-470) * ((i157 & threadPriority3) | (threadPriority3 ^ i157))));
                                int i159 = (i154 ^ i158) + ((i158 & i154) << 1);
                                int i160 = ~((~threadPriority3) | 20);
                                int i161 = (threadPriority3 & (-21)) | ((-21) ^ threadPriority3);
                                int i162 = ~((i161 & i) | (i161 ^ i));
                                int i163 = -(-(((i162 & i160) | (i160 ^ i162)) * 235));
                                int i164 = 33 - (((i159 ^ i163) + ((i163 & i159) << 1)) >> 6);
                                char[] cArr7 = {'!', '\f', 28, 22, '\t', 22, '$', 22, '+', 15, 0, '!', CoreConstants.LEFT_PARENTHESIS_CHAR, 4, 29, 14, 21, 6, 22, '\b', 22, CoreConstants.LEFT_PARENTHESIS_CHAR, '/', 21, 4, '.', CoreConstants.LEFT_PARENTHESIS_CHAR, 27, '\f', '!', 4, '.', 13821};
                                int i165 = -AndroidCharacter.getMirror('0');
                                int i166 = (i165 * (-464)) - 64101;
                                int i167 = ~i165;
                                int i168 = (i ^ 69) | (i & 69);
                                int i169 = ~i168;
                                int i170 = ((i167 ^ i169) | (i169 & i167)) * (-465);
                                int i171 = (i166 & i170) + (i166 | i170);
                                int i172 = ~((i167 ^ i) | (i167 & i));
                                int i173 = ((i172 & 69) | (i172 ^ 69)) * 930;
                                int i174 = (i171 ^ i173) + ((i171 & i173) << 1);
                                int i175 = ((i167 & i168) | (i168 ^ i167)) * 465;
                                Object[] objArr15 = new Object[1];
                                a(i164, cArr7, (byte) ((i174 ^ i175) + ((i175 & i174) << 1)), objArr15);
                                Class<?> cls4 = Class.forName((String) objArr15[0]);
                                int iRgb2 = Color.rgb(0, 0, 0) + 16777230;
                                int i176 = -View.MeasureSpec.getSize(0);
                                int i177 = i176 * (-1965);
                                int i178 = (((i177 & 27250896) + (i177 | 27250896)) - (~((i176 | (-27695)) * 983))) - 1;
                                int i179 = ~i176;
                                int i180 = ~(((-27695) & i136) | ((-27695) ^ i136));
                                int i181 = -(-(((i180 & i179) | (i179 ^ i180)) * (-983)));
                                int i182 = (i178 ^ i181) + ((i181 & i178) << 1);
                                int i183 = ((~((i179 & 27694) | (i179 ^ 27694))) | (~((i179 ^ i136) | (i179 & i136)))) * 983;
                                char c = (char) (((i182 | i183) << 1) - (i183 ^ i182));
                                int offsetBefore = TextUtils.getOffsetBefore("", 0);
                                int i184 = ((offsetBefore * 758) - 10584) + (((offsetBefore ^ i143) | (offsetBefore & i143)) * (-757));
                                int i185 = ((-15) & offsetBefore) | ((-15) ^ offsetBefore);
                                int i186 = (~((i185 & i) | (i185 ^ i))) * 1514;
                                int i187 = (i184 & i186) + (i184 | i186);
                                int i188 = ~((~offsetBefore) | (-15));
                                int i189 = ~(((-15) ^ i136) | ((-15) & i136));
                                int i190 = (i188 ^ i189) | (i188 & i189);
                                int i191 = getARTIFICIAL_FRAME_PACKAGE_NAME + 39;
                                artificialFrame = i191 % 128;
                                int i192 = i191 % 2;
                                int i193 = (offsetBefore ^ 14) | (offsetBefore & 14);
                                int i194 = ~((i193 & i) | (i193 ^ i));
                                int i195 = -(-(757 * ((i194 & i190) | (i190 ^ i194))));
                                Object[] objArr16 = new Object[1];
                                b(iRgb2, c, (i187 & i195) + (i195 | i187), objArr16);
                                Object objInvoke2 = cls4.getMethod((String) objArr16[0], String.class, Integer.TYPE).invoke(objInvoke, objArr14);
                                int i196 = -(ViewConfiguration.getPressedStateDuration() >> 16);
                                int iValidateRelationship7 = SmoothCalendarLayoutManager.validateRelationship();
                                int i197 = i196 * TypedValues.Custom.TYPE_DIMENSION;
                                int i198 = (i197 & (-27090)) + (i197 | (-27090));
                                int i199 = ~i196;
                                int i200 = ~(i199 | iValidateRelationship7);
                                int i201 = ~iValidateRelationship7;
                                int i202 = ~((i201 ^ 30) | (i201 & 30));
                                int i203 = -(-(((i200 & i202) | (i200 ^ i202)) * (-1808)));
                                int i204 = ((i198 | i203) << 1) - (i198 ^ i203);
                                int i205 = ~i196;
                                int i206 = ~((i205 & (-31)) | (i205 ^ (-31)) | iValidateRelationship7);
                                int i207 = (i196 & i201) | (i201 ^ i196);
                                int i208 = ~((i207 ^ 30) | (i207 & 30));
                                int i209 = ((i206 & i208) | (i206 ^ i208)) * TypedValues.Custom.TYPE_BOOLEAN;
                                int i210 = ~((i199 & 30) | (i199 ^ 30));
                                int i211 = ~(iValidateRelationship7 | (-31));
                                int i212 = (i211 & i210) | (i210 ^ i211);
                                int i213 = ~i207;
                                int i214 = (i204 ^ i209) + ((i209 & i204) << 1) + (((i213 & i212) | (i212 ^ i213)) * TypedValues.Custom.TYPE_BOOLEAN);
                                int i215 = artificialFrame + 19;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i215 % 128;
                                int i216 = i215 % 2;
                                Object[] objArr17 = new Object[1];
                                b(i214, (char) (1165 - (~(ViewConfiguration.getEdgeSlop() >> 16))), TextUtils.getOffsetBefore("", 0) + 28, objArr17);
                                Class<?> cls5 = Class.forName((String) objArr17[0]);
                                int i217 = -TextUtils.getOffsetBefore("", 0);
                                int i218 = (i217 & 10) + (i217 | 10);
                                char packedPositionGroup = (char) ExpandableListView.getPackedPositionGroup(0L);
                                int i219 = -Gravity.getAbsoluteGravity(0, 0);
                                Object[] objArr18 = new Object[1];
                                b(i218, packedPositionGroup, (i219 & 58) + (i219 | 58), objArr18);
                                Object[] objArr19 = (Object[]) cls5.getField((String) objArr18[0]).get(objInvoke2);
                                int length = objArr19.length;
                                int i220 = 0;
                                while (i220 < length) {
                                    Object obj4 = objArr19[i220];
                                    int i221 = -(Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                                    int i222 = artificialFrame;
                                    int i223 = i222 + 97;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i223 % 128;
                                    if (i223 % 2 != 0) {
                                        i8 = ((-1939) << i221) / 5;
                                        i9 = ~((-7) | i221);
                                        i10 = i136;
                                    } else {
                                        int i224 = i221 * (-1939);
                                        i8 = ((i224 & 5826) << 1) + (i224 ^ 5826);
                                        i9 = ~(((-7) & i221) | ((-7) ^ i221));
                                        i10 = i143;
                                    }
                                    int i225 = ~((i10 & 6) | (i10 ^ 6));
                                    int i226 = (-970) * ((i9 & i225) | (i9 ^ i225));
                                    int i227 = (i8 & i226) + (i8 | i226);
                                    int i228 = ~i221;
                                    int i229 = (~((i228 ^ 6) | (i228 & 6))) * 1940;
                                    int i230 = (i227 & i229) + (i229 | i227);
                                    int i231 = (i222 & 39) + (i222 | 39);
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i231 % 128;
                                    int i232 = i231 % 2;
                                    int i233 = ~((i228 & (-7)) | (i228 ^ (-7)));
                                    int i234 = ~(i143 | 6);
                                    int i235 = -(-(970 * ((i233 & i234) | (i233 ^ i234))));
                                    int i236 = (i230 & i235) + (i235 | i230);
                                    int i237 = -KeyEvent.normalizeMetaState(0);
                                    int iValidateRelationship8 = SmoothCalendarLayoutManager.validateRelationship();
                                    int i238 = i237 * (-495);
                                    int i239 = (i238 ^ (-7893270)) + ((i238 & (-7893270)) << 1);
                                    int i240 = ~i237;
                                    int i241 = ~((i240 & (-15947)) | (i240 ^ (-15947)));
                                    int i242 = ~i237;
                                    Object[] objArr20 = objArr19;
                                    int i243 = (i239 - (~(-(-(((~(i242 | iValidateRelationship8)) | i241) * 992))))) - 1;
                                    int i244 = (i242 ^ (-15947)) | (i242 & (-15947));
                                    int i245 = getARTIFICIAL_FRAME_PACKAGE_NAME + 31;
                                    int i246 = length;
                                    int i247 = i245 % 128;
                                    artificialFrame = i247;
                                    int i248 = i220;
                                    if (i245 % 2 == 0) {
                                        int i249 = ~i244;
                                        int i250 = ~((i242 ^ iValidateRelationship8) | (i242 & iValidateRelationship8));
                                        int i251 = (i249 & i250) | (i249 ^ i250);
                                        int i252 = ~iValidateRelationship8;
                                        int i253 = (i237 & i252) | (i252 ^ i237);
                                        int i254 = ~((i253 & 15946) | (i253 ^ 15946));
                                        i12 = i243 >>> ((-496) / ((i251 & i254) | (i251 ^ i254)));
                                        i11 = 1;
                                    } else {
                                        int i255 = ~i244;
                                        int i256 = ~(i242 | iValidateRelationship8);
                                        int i257 = (i255 & i256) | (i255 ^ i256);
                                        int i258 = ~iValidateRelationship8;
                                        int i259 = (i237 & i258) | (i258 ^ i237);
                                        int i260 = ~((i259 & 15946) | (i259 ^ 15946));
                                        i11 = 1;
                                        i12 = (i243 - (~(-(-(((i257 & i260) | (i257 ^ i260)) * (-496)))))) - 1;
                                    }
                                    int i261 = (i247 ^ 1) + ((i247 & 1) << i11);
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i261 % 128;
                                    int i262 = (iValidateRelationship8 ^ 15946) | (iValidateRelationship8 & 15946);
                                    if (i261 % 2 != 0) {
                                        Object[] objArr21 = new Object[1];
                                        b(i236, (char) (i12 % (495 - (~i262))), 65 << (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), objArr21);
                                        obj2 = objArr21[0];
                                    } else {
                                        int i263 = -(-(496 * i262));
                                        Object[] objArr22 = new Object[1];
                                        b(i236, (char) (((i12 | i263) << 1) - (i12 ^ i263)), 66 - (~(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), objArr22);
                                        obj2 = objArr22[0];
                                    }
                                    try {
                                        int iKeyCodeFromString = KeyEvent.keyCodeFromString("") + 37;
                                        char[] cArr8 = {19, 21, '!', 27, 16, '\b', CoreConstants.LEFT_PARENTHESIS_CHAR, CoreConstants.PERCENT_CHAR, '#', 23, 21, 30, 29, 22, CoreConstants.PERCENT_CHAR, CoreConstants.LEFT_PARENTHESIS_CHAR, 28, '#', 17, 29, '#', 25, 30, 21, 16, 25, CoreConstants.LEFT_PARENTHESIS_CHAR, 22, ' ', '#', 26, '!', '#', 29, 7, 22, 13876};
                                        int i264 = -(-Color.argb(0, 0, 0, 0));
                                        Object[] objArr23 = new Object[1];
                                        a(iKeyCodeFromString, cArr8, (byte) ((i264 ^ 81) + ((i264 & 81) << 1)), objArr23);
                                        Class<?> cls6 = Class.forName((String) objArr23[0]);
                                        char mirror = AndroidCharacter.getMirror('0');
                                        int i265 = ~mirror;
                                        int i266 = (mirror * 65192) + 12728 + (((~(i265 | 36)) | (~((i265 ^ i) | (i265 & i)))) * 345);
                                        int i267 = ~((i265 & i143) | (i265 ^ i143));
                                        int i268 = ~(('$' & mirror) | ('$' ^ mirror));
                                        int i269 = ~mirror;
                                        int i270 = (i269 & 36) | (i269 ^ 36);
                                        Object[] objArr24 = new Object[1];
                                        a(i266 + (((i267 & i268) | (i267 ^ i268)) * 345) + ((~((i270 & i) | (i270 ^ i))) * 345), new char[]{4, '.', '\"', 0, 2, '\f', '!', 21, 1, CoreConstants.LEFT_PARENTHESIS_CHAR, 13876}, (byte) (53 - (~(-(-((byte) KeyEvent.getModifierMetaStateMask()))))), objArr24);
                                        Object objInvoke3 = cls6.getMethod((String) objArr24[0], String.class).invoke(null, (String) obj2);
                                        try {
                                            int jumpTapTimeout2 = (ViewConfiguration.getJumpTapTimeout() >> 16) + 28;
                                            char size = (char) View.MeasureSpec.getSize(0);
                                            int i271 = -Color.rgb(0, 0, 0);
                                            Object[] objArr25 = new Object[1];
                                            b(jumpTapTimeout2, size, (i271 & (-16777143)) + (i271 | (-16777143)), objArr25);
                                            Class<?> cls7 = Class.forName((String) objArr25[0]);
                                            Object[] objArr26 = new Object[1];
                                            a((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 11, new char[]{29, 7, 1, 25, ' ', '#', 28, 26, 22, 27, 13903}, (byte) (108 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), objArr26);
                                            try {
                                                Object[] objArr27 = {new ByteArrayInputStream((byte[]) cls7.getMethod((String) objArr26[0], null).invoke(obj4, null))};
                                                int bitsPerPixel = 36 - ImageFormat.getBitsPerPixel(0);
                                                char[] cArr9 = {19, 21, '!', 27, 16, '\b', CoreConstants.LEFT_PARENTHESIS_CHAR, CoreConstants.PERCENT_CHAR, '#', 23, 21, 30, 29, 22, CoreConstants.PERCENT_CHAR, CoreConstants.LEFT_PARENTHESIS_CHAR, 28, '#', 17, 29, '#', 25, 30, 21, 16, 25, CoreConstants.LEFT_PARENTHESIS_CHAR, 22, ' ', '#', 26, '!', '#', 29, 7, 22, 13876};
                                                int threadPriority4 = Process.getThreadPriority(0);
                                                int iValidateRelationship9 = SmoothCalendarLayoutManager.validateRelationship();
                                                int i272 = 6380 + (threadPriority4 * (-317));
                                                int i273 = -(-(((~(((-21) ^ iValidateRelationship9) | ((-21) & iValidateRelationship9))) | (~threadPriority4)) * (-318)));
                                                int i274 = (i272 ^ i273) + ((i273 & i272) << 1);
                                                int i275 = ~threadPriority4;
                                                int i276 = ~(i275 | iValidateRelationship9);
                                                int i277 = ~iValidateRelationship9;
                                                int i278 = (i277 ^ 20) | (i277 & 20);
                                                int i279 = -(-((i276 | (~((i278 ^ threadPriority4) | (i278 & threadPriority4)))) * TypedValues.AttributesType.TYPE_PIVOT_TARGET));
                                                int i280 = (i274 & i279) + (i274 | i279);
                                                int i281 = ~iValidateRelationship9;
                                                int i282 = (i275 & i281) | (i275 ^ i281);
                                                int i283 = ~((i282 & 20) | (i282 ^ 20));
                                                int i284 = (threadPriority4 & 20) | (threadPriority4 ^ 20);
                                                int i285 = ~((iValidateRelationship9 & i284) | (i284 ^ iValidateRelationship9));
                                                int i286 = ((i285 & i283) | (i283 ^ i285)) * TypedValues.AttributesType.TYPE_PIVOT_TARGET;
                                                int i287 = (((i280 | i286) << 1) - (i286 ^ i280)) >> 6;
                                                int i288 = (i287 * 628) - (-50868);
                                                int i289 = (i ^ 81) | (i & 81);
                                                int i290 = ~i287;
                                                int i291 = ((i289 & i290) | (i289 ^ i290)) * (-627);
                                                int i292 = (i288 & i291) + (i288 | i291);
                                                int i293 = ~(((-82) & i) | ((-82) ^ i));
                                                int i294 = ((i293 & i287) | (i287 ^ i293)) * (-627);
                                                int i295 = ((i292 | i294) << 1) - (i294 ^ i292);
                                                int i296 = ~((i143 ^ 81) | (i143 & 81));
                                                int i297 = ~((i287 & i) | (i287 ^ i));
                                                byte b2 = (byte) (i295 + (((i297 & i296) | (i296 ^ i297)) * 627));
                                                Object[] objArr28 = new Object[1];
                                                a(bitsPerPixel, cArr9, b2, objArr28);
                                                Class<?> cls8 = Class.forName((String) objArr28[0]);
                                                int i298 = 18 - (~(-View.MeasureSpec.getSize(0)));
                                                char keyRepeatDelay = (char) (ViewConfiguration.getKeyRepeatDelay() >> 16);
                                                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                                                int i299 = ((iMakeMeasureSpec | 101) << 1) - (iMakeMeasureSpec ^ 101);
                                                Object[] objArr29 = new Object[1];
                                                b(i298, keyRepeatDelay, i299, objArr29);
                                                Object objInvoke4 = cls8.getMethod((String) objArr29[0], InputStream.class).invoke(objInvoke3, objArr27);
                                                int length2 = objArr4.length;
                                                int i300 = 0;
                                                while (i300 < 2) {
                                                    Object obj5 = objArr4[i300];
                                                    try {
                                                        int i301 = -TextUtils.indexOf((CharSequence) "", '0');
                                                        int i302 = i301 * (-103);
                                                        int i303 = artificialFrame + 101;
                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i303 % 128;
                                                        if (i303 % 2 != 0) {
                                                            int i304 = i302 + 3399;
                                                            int i305 = ~i301;
                                                            i13 = i304 / (((~((i305 & (-34)) | (i305 ^ (-34)))) | (~(((-34) ^ i) | ((-34) & i)))) + 104);
                                                        } else {
                                                            int i306 = i302 - 3399;
                                                            int i307 = ~i301;
                                                            int i308 = ((~((i307 & (-34)) | (i307 ^ (-34)))) | (~(((-34) & i) | ((-34) ^ i)))) * 104;
                                                            i13 = ((i306 & i308) << 1) + (i306 ^ i308);
                                                        }
                                                        int i309 = (i136 ^ i301) | (i136 & i301);
                                                        int i310 = -(-((~((i309 & 33) | (i309 ^ 33))) * (-104)));
                                                        int i311 = ((i13 | i310) << 1) - (i13 ^ i310);
                                                        int i312 = -(-((i301 | i) * 104));
                                                        int i313 = (i311 & i312) + (i312 | i311);
                                                        char[] cArr10 = {19, 21, '!', 27, 16, '\b', CoreConstants.LEFT_PARENTHESIS_CHAR, CoreConstants.PERCENT_CHAR, '#', 23, 21, 30, 29, 22, CoreConstants.PERCENT_CHAR, CoreConstants.LEFT_PARENTHESIS_CHAR, 28, '#', 16, 1, 25, '\n', CoreConstants.DASH_CHAR, '\"', '#', 25, 30, 21, 16, 25, CoreConstants.LEFT_PARENTHESIS_CHAR, 22, ' ', '#'};
                                                        int i314 = -Gravity.getAbsoluteGravity(0, 0);
                                                        int iValidateRelationship10 = SmoothCalendarLayoutManager.validateRelationship();
                                                        int i315 = (i314 * 673) - 141015;
                                                        int i316 = ~((i314 ^ iValidateRelationship10) | (i314 & iValidateRelationship10));
                                                        int i317 = -(-(((i316 ^ 105) | (i316 & 105)) * 672));
                                                        int i318 = (i315 & i317) + (i315 | i317);
                                                        int i319 = ~i314;
                                                        int i320 = ~iValidateRelationship10;
                                                        int i321 = ~((i319 ^ i320) | (i319 & i320));
                                                        int i322 = getARTIFICIAL_FRAME_PACKAGE_NAME + 75;
                                                        Object[] objArr30 = objArr4;
                                                        artificialFrame = i322 % 128;
                                                        if (i322 % 2 == 0) {
                                                            int i323 = ~((iValidateRelationship10 & 105) | (iValidateRelationship10 ^ 105));
                                                            i14 = i318 << ((-672) / ((i323 & i321) | (i321 ^ i323)));
                                                            i16 = ~(((-106) & i320) | ((-106) ^ i320));
                                                            i15 = -106;
                                                        } else {
                                                            int i324 = ~((iValidateRelationship10 ^ 105) | (iValidateRelationship10 & 105));
                                                            int i325 = -(-(((i324 & i321) | (i321 ^ i324)) * (-672)));
                                                            i14 = ((i318 & i325) << 1) + (i318 ^ i325);
                                                            int i326 = ~iValidateRelationship10;
                                                            i15 = -106;
                                                            i16 = ~((i326 & (-106)) | ((-106) ^ i326));
                                                        }
                                                        int i327 = ~((i314 & i15) | (i15 ^ i314));
                                                        int i328 = 672 * ((i327 & i16) | (i16 ^ i327));
                                                        byte b3 = (byte) ((i14 & i328) + (i14 | i328));
                                                        Object[] objArr31 = new Object[1];
                                                        a(i313, cArr10, b3, objArr31);
                                                        Class<?> cls9 = Class.forName((String) objArr31[0]);
                                                        int i329 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 23;
                                                        char[] cArr11 = {4, '.', 31, '#', Typography.amp, '$', 18, '#', '#', 29, 3, 23, 13851, 13851, 0, 22, 26, 2, CoreConstants.PERCENT_CHAR, 22, 21, 27, 13927};
                                                        int i330 = -(-TextUtils.lastIndexOf("", '0', 0));
                                                        Object[] objArr32 = new Object[1];
                                                        a(i329, cArr11, (byte) ((i330 ^ 114) + ((i330 & 114) << 1)), objArr32);
                                                        if (obj5.equals(cls9.getMethod((String) objArr32[0], null).invoke(objInvoke4, null))) {
                                                            int i331 = artificialFrame + 19;
                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i331 % 128;
                                                            int i332 = i331 % 2;
                                                            Object[] objArr33 = {new int[]{i}, new int[]{(i & (-2)) | (i143 & 1)}, new int[1], null};
                                                            int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
                                                            int i333 = ~startElapsedRealtime;
                                                            int i334 = (i2 - (~(((((-579563586) + ((((~((-38634292) | i333)) | (-939989484)) | (~(38634291 | startElapsedRealtime))) * (-564))) + ((~(startElapsedRealtime | (-939661513))) * 1128)) + (((~((-939989484) | i333)) | (-978295804)) * 564)) + 16))) - 1;
                                                            int i335 = i334 ^ (i334 << 13);
                                                            int i336 = i335 >>> 17;
                                                            int i337 = ((~i335) & i336) | ((~i336) & i335);
                                                            int i338 = i337 << 5;
                                                            ((int[]) objArr33[2])[0] = ((~i337) & i338) | ((~i338) & i337);
                                                            return objArr33;
                                                        }
                                                        i300++;
                                                        objArr4 = objArr30;
                                                    } catch (Throwable th) {
                                                        Throwable cause = th.getCause();
                                                        if (cause != null) {
                                                            throw cause;
                                                        }
                                                        throw th;
                                                    }
                                                }
                                                i220 = (i248 ^ 1) + ((i248 & 1) << 1);
                                                objArr19 = objArr20;
                                                length = i246;
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
                                int i339 = artificialFrame + 3;
                                int i340 = i339 % 128;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i340;
                                int i341 = i339 % 2;
                                Object[] objArr34 = {new int[]{i}, new int[]{i}, new int[1], null};
                                int i342 = (i340 & 21) + (i340 | 21);
                                artificialFrame = i342 % 128;
                                if (i342 % 2 == 0) {
                                    int i343 = ~i;
                                    i3 = 1313543516 + ((968097755 | i343) * (-369)) + (((~((-144818132) | i343)) | 833805643) * (-369)) + (((~(i | 144818131)) | 823279624 | (~(i343 | (-134292113)))) * 369);
                                    iValidateRelationship = SmoothCalendarLayoutManager.validateRelationship();
                                    int i344 = 97 / 0;
                                } else {
                                    int i345 = ~((-937877127) | i);
                                    int i346 = ~i;
                                    i3 = 141377682 + ((i345 | (~(938475166 | i346))) * (-406)) + ((~((-897728519) | i346)) * (-406)) + (((~(i | (-40746649))) | (~(937877126 | i346))) * 406);
                                    iValidateRelationship = SmoothCalendarLayoutManager.validateRelationship();
                                }
                                int i347 = (-1) - (~(i3 * (-209)));
                                int i348 = ~i3;
                                int i349 = (~(((-1) ^ i348) | i348)) * 210;
                                int i350 = ((i347 | i349) << 1) - (i347 ^ i349);
                                int i351 = ~iValidateRelationship;
                                int i352 = ~((i348 ^ i351) | (i348 & i351));
                                int i353 = ~(((-1) ^ iValidateRelationship) | iValidateRelationship);
                                int i354 = -(-(((i352 & i353) | (i352 ^ i353)) * 210));
                                int i355 = ~(i351 | ((-1) ^ i351) | i3);
                                int i356 = ~((iValidateRelationship & i348) | (i348 ^ iValidateRelationship));
                                int i357 = i2 + (((i350 | i354) << 1) - (i354 ^ i350)) + (((i356 & i355) | (i355 ^ i356)) * 210);
                                int i358 = i357 << 13;
                                int i359 = (i357 | i358) & (~(i357 & i358));
                                int i360 = i359 ^ (i359 >>> 17);
                                ((int[]) objArr34[2])[0] = i360 ^ (i360 << 5);
                                return objArr34;
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
    }
}
