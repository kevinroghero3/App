package com.google.android.odml.image;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.base.Ascii;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;
import o.build;
import o.onRelationshipValidationResult;

/* JADX INFO: loaded from: classes5.dex */
public final class R {
    private static final byte[] $$a = {75, 100, -62, Ascii.SYN};
    private static final int $$b = 34;
    private static int $10 = 0;
    private static int $11 = 1;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static long onPostMessage = 2043184632937575172L;
    private static char TopicBuilder = 52735;
    private static char ICustomTabsCallback = 6788;
    private static char extraCallbackWithResult = 5805;
    private static char onMessageChannelReady = 52361;

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0028). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$c(byte r7, int r8, short r9) {
        /*
            int r9 = r9 * 3
            int r9 = 1 - r9
            byte[] r0 = com.google.android.odml.image.R.$$a
            int r7 = 111 - r7
            int r8 = r8 + 4
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L12
            r3 = r8
            r4 = r2
            goto L28
        L12:
            r3 = r2
        L13:
            int r8 = r8 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r9) goto L22
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            return r7
        L22:
            r3 = r0[r8]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r6
        L28:
            int r7 = r7 + r8
            r8 = r3
            r3 = r4
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.odml.image.R.$$c(byte, int, short):java.lang.String");
    }

    private R() {
    }

    private static void a(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        onRelationshipValidationResult onrelationshipvalidationresult = new onRelationshipValidationResult();
        char[] cArrAccessartificialFrame = onRelationshipValidationResult.accessartificialFrame(onPostMessage ^ 2573525503365829440L, cArr, i);
        onrelationshipvalidationresult.e = 4;
        while (onrelationshipvalidationresult.e < cArrAccessartificialFrame.length) {
            int i3 = $10 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
            $11 = i3 % 128;
            int i4 = i3 % 2;
            onrelationshipvalidationresult.d = onrelationshipvalidationresult.e - 4;
            int i5 = onrelationshipvalidationresult.e;
            try {
                Object[] objArr2 = {Long.valueOf(cArrAccessartificialFrame[onrelationshipvalidationresult.e] ^ cArrAccessartificialFrame[onrelationshipvalidationresult.e % 4]), Long.valueOf(onrelationshipvalidationresult.d), Long.valueOf(onPostMessage)};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(797310229);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(27 - (Process.myTid() >> 22), (char) (30690 - ExpandableListView.getPackedPositionGroup(0L)), (ViewConfiguration.getTapTimeout() >> 16) + 188, -1327449315, false, "k", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                }
                cArrAccessartificialFrame[i5] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                Object[] objArr3 = {onrelationshipvalidationresult, onrelationshipvalidationresult};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(321542193);
                if (objAccessartificialFrame2 == null) {
                    byte b = (byte) 0;
                    byte b2 = (byte) (b - 1);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(33 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (TextUtils.lastIndexOf("", '0') + 1), ((Process.getThreadPriority(0) + 20) >> 6) + 1483, -1940971975, false, $$c(b, b2, (byte) (b2 + 1)), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                int i6 = $11 + 5;
                $10 = i6 % 128;
                int i7 = i6 % 2;
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

    private static void b(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        build buildVar = new build();
        char[] cArr2 = new char[cArr.length];
        int i3 = 0;
        buildVar.c = 0;
        char[] cArr3 = new char[2];
        while (buildVar.c < cArr.length) {
            cArr3[i3] = cArr[buildVar.c];
            char c = 1;
            cArr3[1] = cArr[buildVar.c + 1];
            int i4 = 58224;
            int i5 = i3;
            while (i5 < 16) {
                char c2 = cArr3[c];
                char c3 = cArr3[i3];
                char[] cArr4 = cArr3;
                int i6 = (c3 + i4) ^ ((c3 << 4) + ((char) (((long) extraCallbackWithResult) ^ (-4408183324873663413L))));
                int i7 = c3 >>> 5;
                try {
                    Object[] objArr2 = new Object[4];
                    objArr2[3] = Integer.valueOf(onMessageChannelReady);
                    objArr2[2] = Integer.valueOf(i7);
                    objArr2[c] = Integer.valueOf(i6);
                    objArr2[0] = Integer.valueOf(c2);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1585798252);
                    if (objAccessartificialFrame == null) {
                        int iAlpha = Color.alpha(0) + 28;
                        char c4 = (char) (17263 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                        int iIndexOf = 1067 - TextUtils.indexOf("", "", 0);
                        byte b = (byte) 3;
                        byte b2 = (byte) (b - 4);
                        String str$$c = $$c(b, b2, (byte) (b2 + 1));
                        Class[] clsArr = new Class[4];
                        clsArr[0] = Integer.TYPE;
                        clsArr[c] = Integer.TYPE;
                        clsArr[2] = Integer.TYPE;
                        clsArr[3] = Integer.TYPE;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iAlpha, c4, iIndexOf, 1042277788, false, str$$c, clsArr);
                    }
                    char cCharValue = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    cArr4[c] = cCharValue;
                    int i8 = i5;
                    Object[] objArr3 = {Integer.valueOf(cArr4[0]), Integer.valueOf((cCharValue + i4) ^ ((cCharValue << 4) + ((char) (((long) TopicBuilder) ^ (-4408183324873663413L))))), Integer.valueOf(cCharValue >>> 5), Integer.valueOf(ICustomTabsCallback)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1585798252);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 3;
                        byte b4 = (byte) (b3 - 4);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 27, (char) ((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 17263), Color.green(0) + 1067, 1042277788, false, $$c(b3, b4, (byte) (b4 + 1)), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    cArr4[0] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                    i4 -= 40503;
                    i5 = i8 + 1;
                    cArr3 = cArr4;
                    i3 = 0;
                    c = 1;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            char[] cArr5 = cArr3;
            cArr2[buildVar.c] = cArr5[0];
            cArr2[buildVar.c + 1] = cArr5[1];
            Object[] objArr4 = {buildVar, buildVar};
            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1010141908);
            if (objAccessartificialFrame3 == null) {
                byte b5 = (byte) 1;
                byte b6 = (byte) (-b5);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(25 - KeyEvent.getDeadChar(0, 0), (char) (63928 - (KeyEvent.getMaxKeyCode() >> 16)), 486 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 1554985764, false, $$c(b5, b6, (byte) (b6 + 1)), new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame3).invoke(null, objArr4);
            int i9 = $11 + 83;
            $10 = i9 % 128;
            if (i9 % 2 != 0) {
                int i10 = 4 % 5;
            }
            cArr3 = cArr5;
            i3 = 0;
        }
        String str = new String(cArr2, 0, i);
        int i11 = $10 + 117;
        $11 = i11 % 128;
        if (i11 % 2 != 0) {
            objArr[0] = str;
        } else {
            int i12 = 50 / 0;
            objArr[0] = str;
        }
    }

    public static Object[] accessartificialFrame(Context context, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Class<?> cls;
        Object obj;
        int i9 = 2 % 2;
        int i10 = artificialFrame;
        int i11 = (i10 ^ 71) + ((i10 & 71) << 1);
        int i12 = i11 % 128;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i12;
        int i13 = i11 % 2;
        int i14 = i12 + 59;
        artificialFrame = i14 % 128;
        int i15 = i14 % 2;
        int i16 = (i12 ^ 91) + ((i12 & 91) << 1);
        int i17 = i16 % 128;
        artificialFrame = i17;
        int i18 = i16 % 2;
        int i19 = 0;
        if (context == null) {
            int i20 = i17 + 107;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i20 % 128;
            int i21 = i20 % 2;
            Object[] objArr = {new int[]{i}, new int[]{i}, new int[1], null};
            int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
            int i22 = (-609511562) + (((~((-954016370) | startElapsedRealtime)) | (-973044478)) * (-502)) + ((~((~startElapsedRealtime) | (-948437073))) * (-502)) + (((~(startElapsedRealtime | (-24607406))) | (-954016370)) * TypedValues.PositionType.TYPE_DRAWPATH);
            int iP = FirebaseAnalytics.Event.P();
            int i23 = -(-(i22 * (-747)));
            int i24 = ((i23 << 1) - i23) + ((~(~iP)) * (-374));
            int i25 = ~i22;
            int i26 = -(-((~i25) * 748));
            int i27 = ~(i25 | ((-1) ^ i25));
            int i28 = ~(~iP);
            int i29 = (i24 & i26) + (i24 | i26) + (((i28 & i27) | (i27 ^ i28)) * 374);
            int i30 = i29 * 367;
            int i31 = i2 * 367;
            int i32 = (((i30 & i31) + (i30 | i31)) - (~(-(-(((i29 ^ i2) | (i29 & i2)) * (-366)))))) - 1;
            int i33 = ~i2;
            int i34 = ~((i33 & i) | (i33 ^ i));
            int i35 = ((i34 & i29) | (i29 ^ i34)) * (-366);
            int i36 = (i32 ^ i35) + ((i35 & i32) << 1);
            int i37 = ~i29;
            int i38 = ~((i37 & i2) | (i37 ^ i2));
            int i39 = ~(i | (~i2) | i29);
            int i40 = (i36 - (~(-(-(((i39 & i38) | (i38 ^ i39)) * 366))))) - 1;
            int i41 = i40 << 13;
            int i42 = (i41 | i40) & (~(i40 & i41));
            int i43 = i42 ^ (i42 >>> 17);
            ((int[]) objArr[2])[0] = i43 ^ (i43 << 5);
            return objArr;
        }
        try {
            Object[] objArr2 = new Object[1];
            a((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), new char[]{15930, 3179, 15952, 6138, 60811, 44110, 22276, 3366, 48978, 11537, 54801, 35890, 15481, 44666, 21792, 3854, 48510, 12134, 54380, 36374, 14863, 43163, 21338, 2217, 47890, 10698, 53778, 35751, 14452, 43671, 20775, 2711, 47482, 11151, 53360, 34270, 14036, 42188, 24219, 1207, 47051, 9683}, objArr2);
            Object[] objArr3 = (Object[]) Array.newInstance(Class.forName((String) objArr2[0]), 2);
            Object[] objArr4 = new Object[1];
            a(TextUtils.getOffsetAfter("", 0), new char[]{57126, 46863, 57189, 41852, 47347, 5893, 58313, 22654, 24152, 38463, 25238, 55616, 56687, 5391, 57844, 23131, 23667, 37913, 24753, 56168, 56138, 5060, 59273, 23998, 23064, 37631, 26326, 56960, 55599, 4559, 58808, 24476, 22635, 37102, 25815}, objArr4);
            try {
                Object[] objArr5 = {(String) objArr4[0]};
                Object[] objArr6 = new Object[1];
                a(Color.alpha(0), new char[]{15930, 3179, 15952, 6138, 60811, 44110, 22276, 3366, 48978, 11537, 54801, 35890, 15481, 44666, 21792, 3854, 48510, 12134, 54380, 36374, 14863, 43163, 21338, 2217, 47890, 10698, 53778, 35751, 14452, 43671, 20775, 2711, 47482, 11151, 53360, 34270, 14036, 42188, 24219, 1207, 47051, 9683}, objArr6);
                objArr3[0] = Class.forName((String) objArr6[0]).getDeclaredConstructor(String.class).newInstance(objArr5);
                Object[] objArr7 = new Object[1];
                a(ViewConfiguration.getScrollBarFadeDuration() >> 16, new char[]{41022, 35163, 41085, 58846, 12488, 10530, 42243, 53335, 8450, 43072, 9339, 20821, 41584, 11099, 42756, 53835, 9063, 43595, 9802, 21367, 42032, 11746, 41303, 54698, 9482, 44221, 8297, 22205, 42554, 12255, 41842, 55169, 10028, 44698, 8769}, objArr7);
                String str = (String) objArr7[0];
                int i44 = getARTIFICIAL_FRAME_PACKAGE_NAME + 61;
                artificialFrame = i44 % 128;
                int i45 = i44 % 2;
                try {
                    Object[] objArr8 = {str};
                    float length = PointF.length(0.0f, 0.0f);
                    int i46 = getARTIFICIAL_FRAME_PACKAGE_NAME + 69;
                    artificialFrame = i46 % 128;
                    int i47 = i46 % 2;
                    Object[] objArr9 = new Object[1];
                    a((length > 0.0f ? 1 : (length == 0.0f ? 0 : -1)), new char[]{15930, 3179, 15952, 6138, 60811, 44110, 22276, 3366, 48978, 11537, 54801, 35890, 15481, 44666, 21792, 3854, 48510, 12134, 54380, 36374, 14863, 43163, 21338, 2217, 47890, 10698, 53778, 35751, 14452, 43671, 20775, 2711, 47482, 11151, 53360, 34270, 14036, 42188, 24219, 1207, 47051, 9683}, objArr9);
                    Object objNewInstance = Class.forName((String) objArr9[0]).getDeclaredConstructor(String.class).newInstance(objArr8);
                    int i48 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i49 = ((i48 | 37) << 1) - (i48 ^ 37);
                    artificialFrame = i49 % 128;
                    if (i49 % 2 == 0) {
                        objArr3[1] = objNewInstance;
                        int i50 = 85 / 0;
                    } else {
                        objArr3[1] = objNewInstance;
                    }
                    int i51 = i48 + 7;
                    artificialFrame = i51 % 128;
                    int i52 = i51 % 2;
                    try {
                        int i53 = -(-(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                        Object[] objArr10 = new Object[1];
                        b((i53 & 24) + (i53 | 24), new char[]{56948, 12126, 54919, 5115, 40414, 28432, 50307, 65110, 29493, 42430, 61262, 34728, 61929, 40528, 22218, 9303, 16135, 22431, 61262, 34728, 33296, 22364, 54841, 41971}, objArr10);
                        Class<?> cls2 = Class.forName((String) objArr10[0]);
                        int scrollBarFadeDuration = ViewConfiguration.getScrollBarFadeDuration();
                        int i54 = artificialFrame + 107;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i54 % 128;
                        int i55 = i54 % 2;
                        int i56 = scrollBarFadeDuration >> 16;
                        int iP2 = FirebaseAnalytics.Event.P();
                        int i57 = (i56 * (-919)) - 15623;
                        int i58 = ~i56;
                        int i59 = (i58 ^ (-18)) | (i58 & (-18));
                        int i60 = ~((i59 ^ iP2) | (i59 & iP2));
                        int i61 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i62 = (i61 & 9) + (i61 | 9);
                        artificialFrame = i62 % 128;
                        if (i62 % 2 == 0) {
                            i6 = i57 >>> (920 / ((~(((~iP2) | (-18)) | i56)) | i60));
                            i7 = ~i56;
                        } else {
                            int i63 = ~iP2;
                            int i64 = ((-18) ^ i63) | (i63 & (-18));
                            int i65 = ~((i64 ^ i56) | (i64 & i56));
                            int i66 = -(-(((i60 ^ i65) | (i65 & i60)) * 920));
                            i6 = ((i57 | i66) << 1) - (i66 ^ i57);
                            i7 = i58;
                        }
                        int i67 = ~(i7 | (-18));
                        int i68 = ~iP2;
                        int i69 = ~((i58 ^ i68) | (i58 & i68));
                        int i70 = i6 + (920 * ((i67 ^ i69) | (i67 & i69)));
                        int i71 = (~i56) | (-18);
                        int i72 = ~((i71 & i68) | (i71 ^ i68));
                        int i73 = (i61 ^ 59) + ((i61 & 59) << 1);
                        int i74 = i73 % 128;
                        artificialFrame = i74;
                        if (i73 % 2 == 0) {
                            int i75 = ~((i58 & 17) | (i58 ^ 17) | iP2);
                            int i76 = (i72 & i75) | (i72 ^ i75);
                            int i77 = (i56 & (-18)) | ((-18) ^ i56);
                            int i78 = ~((i77 & iP2) | (i77 ^ iP2));
                            i8 = i70 >>> (919 - (~(-((i76 & i78) | (i76 ^ i78)))));
                        } else {
                            int i79 = ~(i58 | 17 | iP2);
                            int i80 = (i56 & (-18)) | ((-18) ^ i56);
                            int i81 = ((i72 & i79) | (i72 ^ i79) | (~((i80 & iP2) | (i80 ^ iP2)))) * 920;
                            i8 = ((i70 | i81) << 1) - (i70 ^ i81);
                        }
                        int i82 = (i74 & 79) + (i74 | 79);
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i82 % 128;
                        int i83 = i82 % 2;
                        Object[] objArr11 = new Object[1];
                        b(i8, new char[]{41622, 36186, 40657, 43528, 12009, 2027, 24670, 25763, 41622, 36186, 25668, 4489, 35079, 12494, 41622, 36186, 60552, 49594}, objArr11);
                        Object objInvoke = cls2.getMethod((String) objArr11[0], null).invoke(context, null);
                        try {
                            int iBlue = Color.blue(0);
                            int i84 = artificialFrame;
                            int i85 = (i84 & 53) + (i84 | 53);
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i85 % 128;
                            int i86 = i85 % 2;
                            int i87 = (iBlue * 236) + 10833;
                            int i88 = ~iBlue;
                            int i89 = ~i;
                            int i90 = ~((i88 ^ i89) | (i88 & i89));
                            int i91 = -(-(((i90 & 23) | (i90 ^ 23)) * (-235)));
                            int i92 = ((i87 | i91) << 1) - (i87 ^ i91);
                            int i93 = (i84 & 97) + (i84 | 97);
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i93 % 128;
                            int i94 = i93 % 2;
                            int i95 = ~iBlue;
                            int i96 = ((~((i95 & i) | (i95 ^ i))) | 23) * (-470);
                            int i97 = i84 + 113;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i97 % 128;
                            int i98 = i97 % 2;
                            int i99 = ~((iBlue & (-24)) | ((-24) ^ iBlue));
                            int i100 = (i88 ^ 23) | (i88 & 23);
                            int i101 = ~((i100 & i) | (i100 ^ i));
                            int i102 = i92 + i96 + (((i99 & i101) | (i99 ^ i101)) * 235);
                            Object[] objArr12 = new Object[1];
                            b(i102, new char[]{56948, 12126, 54919, 5115, 40414, 28432, 50307, 65110, 29493, 42430, 61262, 34728, 61929, 40528, 22218, 9303, 16135, 22431, 61262, 34728, 33296, 22364, 54841, 41971}, objArr12);
                            String str2 = (String) objArr12[0];
                            int i103 = artificialFrame;
                            int i104 = (i103 & 19) + (i103 | 19);
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i104 % 128;
                            if (i104 % 2 != 0) {
                                cls = Class.forName(str2);
                                Object[] objArr13 = new Object[1];
                                b(7 >>> (ViewConfiguration.getMaximumDrawingCacheSize() / 43), new char[]{41622, 36186, 40657, 43528, 12009, 2027, 24670, 25763, 41622, 36186, 38889, 8125, 43141, 6549}, objArr13);
                                obj = objArr13[0];
                            } else {
                                cls = Class.forName(str2);
                                int i105 = -(ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                                Object[] objArr14 = new Object[1];
                                b((i105 & 14) + (i105 | 14), new char[]{41622, 36186, 40657, 43528, 12009, 2027, 24670, 25763, 41622, 36186, 38889, 8125, 43141, 6549}, objArr14);
                                obj = objArr14[0];
                            }
                            Object objInvoke2 = cls.getMethod((String) obj, null).invoke(context, null);
                            int i106 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                            int i107 = (i106 ^ 47) + ((i106 & 47) << 1);
                            artificialFrame = i107 % 128;
                            int i108 = i107 % 2;
                            try {
                                Object[] objArr15 = {objInvoke2, 64};
                                int i109 = 37;
                                Object[] objArr16 = new Object[1];
                                a(ViewConfiguration.getPressedStateDuration() >> 16, new char[]{30443, 36213, 30346, 36632, 43516, 11615, 53236, 18754, 63380, 44104, 20196, 51214, 29864, 12158, 52702, 19300, 62910, 44655, 19668, 51758, 29403, 10652, 52222, 19616, 62426, 43138, 19115, 53121, 28908, 11188, 51645, 20145, 61941, 43680, 18567, 49573, 32281}, objArr16);
                                Class<?> cls3 = Class.forName((String) objArr16[0]);
                                Object[] objArr17 = new Object[1];
                                a(View.MeasureSpec.makeMeasureSpec(0, 0), new char[]{13113, 28041, 13150, 20564, 55663, 52648, 4264, 14835, 45640, 19646, 37287, 47314, 12670, 53128, 4789, 15341, 45167, 20114}, objArr17);
                                String str3 = (String) objArr17[0];
                                int i110 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                int i111 = ((i110 | 121) << 1) - (i110 ^ 121);
                                artificialFrame = i111 % 128;
                                int i112 = i111 % 2;
                                Object objInvoke3 = cls3.getMethod(str3, String.class, Integer.TYPE).invoke(objInvoke, objArr15);
                                int maxKeyCode = KeyEvent.getMaxKeyCode() >> 16;
                                int i113 = artificialFrame;
                                int i114 = (i113 ^ 55) + ((i113 & 55) << 1);
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i114 % 128;
                                int i115 = i114 % 2;
                                Object[] objArr18 = new Object[1];
                                a(maxKeyCode, new char[]{37090, 48475, 36995, 41368, 5848, 7537, 57716, 63078, 4509, 40038, 24676, 30506, 37537, 8016, 58206, 62528, 5047, 40513, 25172, 29962, 38098, 6578, 58750, 62340, 5587, 39084, 25643, 28837, 38629, 7066, 59193, 61850, 6132, 39552}, objArr18);
                                Class<?> cls4 = Class.forName((String) objArr18[0]);
                                int packedPositionGroup = ExpandableListView.getPackedPositionGroup(0L);
                                int i116 = artificialFrame;
                                int i117 = ((i116 | AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) << 1) - (i116 ^ AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i117 % 128;
                                int i118 = i117 % 2;
                                int i119 = -packedPositionGroup;
                                Object[] objArr19 = new Object[1];
                                b((10 ^ i119) + ((i119 & 10) << 1), new char[]{36843, 41966, 13921, 25027, 30334, 59703, 45732, 35597, 44620, 5057}, objArr19);
                                Object[] objArr20 = (Object[]) cls4.getField((String) objArr19[0]).get(objInvoke3);
                                int i120 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                int i121 = (i120 ^ 49) + ((i120 & 49) << 1);
                                artificialFrame = i121 % 128;
                                int i122 = i121 % 2;
                                int length2 = objArr20.length;
                                int i123 = 0;
                                while (i123 < length2) {
                                    Object obj2 = objArr20[i123];
                                    Object[] objArr21 = new Object[1];
                                    a(Process.myTid() >> 22, new char[]{34173, 42390, 34085, 16673, 63570, 1532, 412, 6318, 1108}, objArr21);
                                    try {
                                        Object[] objArr22 = {(String) objArr21[i19]};
                                        int i124 = -(-Color.red(i19));
                                        Object[] objArr23 = new Object[1];
                                        b((i124 & 37) + (i124 | i109), new char[]{6479, 8435, 42376, 16060, 381, 57498, 28705, 44242, 45732, 35597, 50460, 32808, 46220, 53185, 39520, 14000, 56476, 56761, 26072, 61392, 31661, 19496, 37807, 49957, 34724, 56455, 47770, 29362, 16833, 57975, 11975, 47869, 37341, 37830, 30892, 39602, 39004, 55181}, objArr23);
                                        Class<?> cls5 = Class.forName((String) objArr23[i19]);
                                        int i125 = (TypedValue.complexToFloat(i19) > 0.0f ? 1 : (TypedValue.complexToFloat(i19) == 0.0f ? 0 : -1));
                                        Object[] objArr24 = new Object[1];
                                        b((i125 & 11) + (i125 | 11), new char[]{41622, 36186, 48963, 47036, 10058, 41667, 38113, 30754, 3267, 20093, 7285, 46922}, objArr24);
                                        String str4 = (String) objArr24[i19];
                                        Class<?>[] clsArr = new Class[1];
                                        clsArr[i19] = String.class;
                                        Object objInvoke4 = cls5.getMethod(str4, clsArr).invoke(null, objArr22);
                                        try {
                                            int threadPriority = Process.getThreadPriority(i19);
                                            int iP3 = FirebaseAnalytics.Event.P();
                                            int i126 = threadPriority * (-743);
                                            int i127 = (((-14860) | i126) << 1) - ((-14860) ^ i126);
                                            int i128 = ~(threadPriority | 20);
                                            int i129 = ~((iP3 ^ 20) | (iP3 & 20));
                                            int i130 = (i128 ^ i129) | (i129 & i128);
                                            int i131 = ~((threadPriority ^ iP3) | (threadPriority & iP3));
                                            int i132 = -(-(((i130 ^ i131) | (i130 & i131)) * (-744)));
                                            int i133 = (i127 ^ i132) + ((i127 & i132) << 1);
                                            int i134 = ~iP3;
                                            int i135 = ~threadPriority;
                                            int i136 = (i134 | (~(((-21) ^ i135) | ((-21) & i135)))) * 744;
                                            int i137 = ((i133 | i136) << 1) - (i136 ^ i133);
                                            int i138 = (threadPriority ^ 20) | (threadPriority & 20);
                                            int i139 = ((i138 & iP3) | (i138 ^ iP3)) * 744;
                                            Object[] objArr25 = new Object[1];
                                            a(((i137 & i139) + (i139 | i137)) >> 6, new char[]{20123, 62665, 20218, 56783, 25201, 21731, 40227, 33487, 53220, 54772, 7219, 899, 19672, 22210, 40713, 33001, 52686, 55251, 7683, 419, 19115, 20512, 39209, 34606, 52130, 53562, 6265, 1036, 18575, 21016, 39765, 34104}, objArr25);
                                            Class<?> cls6 = Class.forName((String) objArr25[0]);
                                            Object[] objArr26 = new Object[1];
                                            b(10 - (~(-(ViewConfiguration.getScrollDefaultDelay() >> 16))), new char[]{8455, 19511, 12988, 7253, 16833, 57975, 1550, 9185, 26625, 52355, 39004, 55181}, objArr26);
                                            try {
                                                Object[] objArr27 = {new ByteArrayInputStream((byte[]) cls6.getMethod((String) objArr26[0], null).invoke(obj2, null))};
                                                int i140 = -(ViewConfiguration.getMinimumFlingVelocity() >> 16);
                                                Object[] objArr28 = new Object[1];
                                                b((i140 ^ 37) + ((i140 & 37) << 1), new char[]{6479, 8435, 42376, 16060, 381, 57498, 28705, 44242, 45732, 35597, 50460, 32808, 46220, 53185, 39520, 14000, 56476, 56761, 26072, 61392, 31661, 19496, 37807, 49957, 34724, 56455, 47770, 29362, 16833, 57975, 11975, 47869, 37341, 37830, 30892, 39602, 39004, 55181}, objArr28);
                                                Class<?> cls7 = Class.forName((String) objArr28[0]);
                                                Object[] objArr29 = new Object[1];
                                                a(ExpandableListView.getPackedPositionType(0L), new char[]{49119, 53700, 49080, 58594, 42080, 29157, 41988, 17609, 16061, 61681, 9486, 50649, 48572, 29637, 42552, 18168, 15494, 62166, 10035, 51199, 48126, 30004, 41039}, objArr29);
                                                Object objInvoke5 = cls7.getMethod((String) objArr29[0], InputStream.class).invoke(objInvoke4, objArr27);
                                                int length3 = objArr3.length;
                                                int i141 = 0;
                                                for (int i142 = 2; i141 < i142; i142 = 2) {
                                                    Object obj3 = objArr3[i141];
                                                    try {
                                                        Object[] objArr30 = new Object[1];
                                                        a(ViewConfiguration.getTouchSlop() >> 8, new char[]{42321, 10532, 42299, 11250, 63334, 35073, 27404, 6091, 9327, 2051, 59919, 38617, 42756, 35634, 26931, 5630, 9752, 2686, 59433, 38143, 41315, 36308, 28436, 4658, 8244, 3200, 60947, 37177, 41812, 36850, 28014, 4131, 8775, 3833, 60521, 40763, 44453, 33157}, objArr30);
                                                        Class<?> cls8 = Class.forName((String) objArr30[0]);
                                                        int i143 = getARTIFICIAL_FRAME_PACKAGE_NAME + 59;
                                                        artificialFrame = i143 % 128;
                                                        int i144 = i143 % 2;
                                                        Object[] objArr31 = new Object[1];
                                                        a(Drawable.resolveOpacity(0, 0), new char[]{24663, 782, 24624, 19018, 8878, 41775, 2742, 49713, 57650, 8760, 35768, 17175, 25108, 41246, 2234, 49271, 58199, 8266, 35234, 16672, 25726, 42980, 3809, 51147, 58743, 9979, 36862}, objArr31);
                                                        if (obj3.equals(cls8.getMethod((String) objArr31[0], null).invoke(objInvoke5, null))) {
                                                            int i145 = artificialFrame + 117;
                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i145 % 128;
                                                            int i146 = i145 % 2;
                                                            int i147 = ~i;
                                                            Object[] objArr32 = {new int[]{i}, new int[]{(i & (-2)) | (i147 & 1)}, new int[1], null};
                                                            int startElapsedRealtime2 = (int) Process.getStartElapsedRealtime();
                                                            int i148 = 395406744 + (((-276856861) | startElapsedRealtime2) * (-627)) + (((~((-662379458) | startElapsedRealtime2)) | 316244317) * (-627)) + (((~(startElapsedRealtime2 | 316244317)) | (~((~startElapsedRealtime2) | 662379457))) * 627);
                                                            int i149 = 5103 - (~(i148 * (-317)));
                                                            int i150 = ~i148;
                                                            int i151 = ((~(((-17) & i) | ((-17) ^ i))) | i150) * (-318);
                                                            int i152 = (i149 ^ i151) + ((i149 & i151) << 1);
                                                            int i153 = ~((i150 ^ i) | (i150 & i));
                                                            int i154 = (i89 ^ 16) | (i89 & 16);
                                                            int i155 = ~((i154 & i148) | (i154 ^ i148));
                                                            int i156 = ((i153 & i155) | (i153 ^ i155)) * TypedValues.AttributesType.TYPE_PIVOT_TARGET;
                                                            int i157 = ((i152 | i156) << 1) - (i156 ^ i152);
                                                            int i158 = (~i148) | i147;
                                                            int i159 = (i148 ^ 16) | (i148 & 16);
                                                            int i160 = ((~((i158 & 16) | (i158 ^ 16))) | (~((i159 & i) | (i159 ^ i)))) * TypedValues.AttributesType.TYPE_PIVOT_TARGET;
                                                            int i161 = (i2 - (~(-(-(((i157 | i160) << 1) - (i160 ^ i157)))))) - 1;
                                                            int i162 = i161 << 13;
                                                            int i163 = ((~i161) & i162) | ((~i162) & i161);
                                                            int i164 = i163 >>> 17;
                                                            int i165 = (i163 | i164) & (~(i163 & i164));
                                                            ((int[]) objArr32[2])[0] = i165 ^ (i165 << 5);
                                                            return objArr32;
                                                        }
                                                        i141 = (i141 ^ (-99)) + ((i141 & (-99)) << 1) + 100;
                                                        int i166 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                        int i167 = ((i166 | 63) << 1) - (i166 ^ 63);
                                                        artificialFrame = i167 % 128;
                                                        if (i167 % 2 == 0) {
                                                            int i168 = 3 / 3;
                                                        }
                                                    } catch (Throwable th) {
                                                        Throwable cause = th.getCause();
                                                        if (cause != null) {
                                                            throw cause;
                                                        }
                                                        throw th;
                                                    }
                                                }
                                                i123 = ((i123 & 1) << 1) + (i123 ^ 1);
                                                i109 = 37;
                                                i19 = 0;
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
        Object[] objArr33 = {new int[]{i}, new int[]{i}, new int[1], null};
        int i169 = ~(((int) SystemClock.uptimeMillis()) | 240800817);
        int i170 = ((67114000 | i169) * (-196)) + 1565188122 + ((i169 | 173686817) * 196);
        int iP4 = FirebaseAnalytics.Event.P();
        int i171 = (-1) - (~(-(-(i170 * (-518)))));
        int i172 = ~iP4;
        int i173 = (i171 - (~(((~(((-1) ^ i172) | i172)) | i170) * 519))) - 1;
        int i174 = ((-1) ^ i172) | i172;
        int i175 = ~((i174 & i170) | (i174 ^ i170));
        int i176 = ~(i170 | iP4);
        int i177 = ((i175 & i176) | (i175 ^ i176)) * (-519);
        int i178 = (i173 & i177) + (i173 | i177);
        int i179 = (~(iP4 | i170)) * 519;
        int i180 = ((i178 | i179) << 1) - (i179 ^ i178);
        int i181 = i180 * (-129);
        int i182 = -(-(i2 * 131));
        int i183 = (i181 & i182) + (i181 | i182);
        int i184 = ~i2;
        int i185 = (~i) | i184;
        int i186 = ~((i185 & i180) | (i185 ^ i180));
        int i187 = artificialFrame + 47;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i187 % 128;
        int i188 = i186 * 130;
        if (i187 % 2 != 0) {
            int i189 = i183 % i188;
            int i190 = ~i2;
            int i191 = -(~((i190 & i180) | (i190 ^ i180)));
            i3 = i189 - ((i191 ^ (-260)) + ((i191 & (-260)) << 1));
            int i192 = ~i180;
            i5 = ~((i2 & i192) | (i192 ^ i2));
            int i193 = (i184 & i180) | (i184 ^ i180);
            i4 = ~((i & i193) | (i193 ^ i));
        } else {
            int i194 = (i183 & i188) + (i188 | i183);
            int i195 = (~((i184 & i180) | (i184 ^ i180))) * (-260);
            i3 = (i194 ^ i195) + ((i195 & i194) << 1);
            int i196 = ~i180;
            int i197 = ~((i196 & i2) | (i196 ^ i2));
            int i198 = ~i2;
            int i199 = (i198 & i180) | (i198 ^ i180);
            i4 = ~((i & i199) | (i199 ^ i));
            i5 = i197;
        }
        int i200 = -(-(130 * ((i4 & i5) | (i5 ^ i4))));
        int i201 = ((i3 | i200) << 1) - (i200 ^ i3);
        int i202 = i201 << 13;
        int i203 = (i202 | i201) & (~(i201 & i202));
        int i204 = i203 >>> 17;
        int i205 = ((~i203) & i204) | ((~i204) & i203);
        int i206 = i205 << 5;
        ((int[]) objArr33[2])[0] = ((~i205) & i206) | ((~i206) & i205);
        return objArr33;
    }
}
