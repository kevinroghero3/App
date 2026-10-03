package com.reactnativecommunity.webview;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.FileProvider;
import androidx.core.view.ViewCompat;
import ch.qos.logback.core.net.SyslogConstants;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kotlin.random.RandomKt;
import o.ArtificialStackFrames;
import o.onRelationshipValidationResult;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes6.dex */
public class RNCWebViewFileProvider extends FileProvider {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    private static int artificialFrame;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static long onPostMessage;
    private static final byte[] $$c = {103, -8, -85, 41};
    private static final int $$f = 65;
    private static int $10 = 0;
    private static int $11 = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(byte r6, short r7, int r8) {
        /*
            int r8 = r8 * 3
            int r8 = r8 + 111
            int r6 = r6 * 4
            int r6 = r6 + 4
            byte[] r0 = com.reactnativecommunity.webview.RNCWebViewFileProvider.$$c
            int r7 = r7 * 2
            int r1 = 1 - r7
            byte[] r1 = new byte[r1]
            r2 = 0
            int r7 = 0 - r7
            if (r0 != 0) goto L19
            r4 = r8
            r3 = r2
            r8 = r6
            goto L2c
        L19:
            r3 = r2
        L1a:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L25:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r8
            r8 = r6
            r6 = r5
        L2c:
            int r4 = -r4
            int r6 = r6 + r4
            int r8 = r8 + 1
            r5 = r8
            r8 = r6
            r6 = r5
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.webview.RNCWebViewFileProvider.$$g(byte, short, int):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0020  */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0020 -> B:11:0x0022). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0020
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(byte r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = 112 - r7
            int r8 = 109 - r8
            int r6 = r6 + 8
            byte[] r0 = com.reactnativecommunity.webview.RNCWebViewFileProvider.$$a
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L10
            r3 = r8
            r4 = r2
            goto L22
        L10:
            r3 = r2
        L11:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r6) goto L20
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L20:
            r3 = r0[r8]
        L22:
            int r8 = r8 + 1
            int r7 = r7 + r3
            r3 = r4
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.webview.RNCWebViewFileProvider.b(byte, int, byte, java.lang.Object[]):void");
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
    private static void c(short r5, byte r6, int r7, java.lang.Object[] r8) {
        /*
            int r5 = 702 - r5
            byte[] r0 = com.reactnativecommunity.webview.RNCWebViewFileProvider.$$d
            int r6 = r6 + 36
            int r1 = r7 + 3
            byte[] r1 = new byte[r1]
            int r7 = r7 + 2
            r2 = 0
            if (r0 != 0) goto L12
            r4 = r7
            r3 = r2
            goto L26
        L12:
            r3 = r2
        L13:
            int r5 = r5 + 1
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r7) goto L22
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L22:
            int r3 = r3 + 1
            r4 = r0[r5]
        L26:
            int r6 = r6 + r4
            int r6 = r6 + (-5)
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.webview.RNCWebViewFileProvider.c(short, byte, int, java.lang.Object[]):void");
    }

    private static void a(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        onRelationshipValidationResult onrelationshipvalidationresult = new onRelationshipValidationResult();
        char[] cArrAccessartificialFrame = onRelationshipValidationResult.accessartificialFrame(onPostMessage ^ 2573525503365829440L, cArr, i);
        onrelationshipvalidationresult.e = 4;
        while (onrelationshipvalidationresult.e < cArrAccessartificialFrame.length) {
            int i3 = $10 + 101;
            $11 = i3 % 128;
            int i4 = i3 % 2;
            onrelationshipvalidationresult.d = onrelationshipvalidationresult.e - 4;
            int i5 = onrelationshipvalidationresult.e;
            try {
                Object[] objArr2 = {Long.valueOf(cArrAccessartificialFrame[onrelationshipvalidationresult.e] ^ cArrAccessartificialFrame[onrelationshipvalidationresult.e % 4]), Long.valueOf(onrelationshipvalidationresult.d), Long.valueOf(onPostMessage)};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(797310229);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(27 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), (char) (30689 - TextUtils.indexOf((CharSequence) "", '0')), 188 - View.MeasureSpec.getMode(0), -1327449315, false, "k", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                }
                cArrAccessartificialFrame[i5] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                Object[] objArr3 = {onrelationshipvalidationresult, onrelationshipvalidationresult};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(321542193);
                if (objAccessartificialFrame2 == null) {
                    byte b = (byte) 0;
                    byte b2 = b;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(32 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16), 1483 - KeyEvent.keyCodeFromString(""), -1940971975, false, $$g(b, b2, b2), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                int i6 = $10 + 13;
                $11 = i6 % 128;
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

    /* JADX WARN: Code duplicated, block: B:310:0x2008  */
    /* JADX WARN: Code duplicated, block: B:311:0x2086  */
    /* JADX WARN: Code duplicated, block: B:314:0x2098 A[Catch: all -> 0x2210, TryCatch #0 {all -> 0x2210, blocks: (B:312:0x208b, B:314:0x2098, B:315:0x20cc, B:317:0x20d6, B:319:0x20e3, B:320:0x210b, B:250:0x1a61, B:252:0x1a83, B:253:0x1ad4, B:162:0x11f9, B:164:0x120e, B:165:0x123d, B:127:0x0ddd, B:129:0x0de3, B:130:0x0e0d, B:132:0x0e36, B:133:0x0ec1), top: B:350:0x0ddd }] */
    /* JADX WARN: Code duplicated, block: B:319:0x20e3 A[Catch: all -> 0x2210, TryCatch #0 {all -> 0x2210, blocks: (B:312:0x208b, B:314:0x2098, B:315:0x20cc, B:317:0x20d6, B:319:0x20e3, B:320:0x210b, B:250:0x1a61, B:252:0x1a83, B:253:0x1ad4, B:162:0x11f9, B:164:0x120e, B:165:0x123d, B:127:0x0ddd, B:129:0x0de3, B:130:0x0e0d, B:132:0x0e36, B:133:0x0ec1), top: B:350:0x0ddd }] */
    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public boolean onCreate() throws Throwable {
        Object[] objArr;
        int i;
        Object[] objArr2;
        int i2;
        Object obj;
        Object[] objArr3;
        int i3;
        Object[] objArr4;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object[] objArr5;
        char c;
        int i4;
        Object[] objArr6;
        int i5;
        Object[] objArr7;
        Object[] objArr8;
        int i6;
        int i7;
        Object objAccessartificialFrame;
        Object objAccessartificialFrame2;
        int i8 = 2 % 2;
        Object[] objArr9 = new Object[1];
        a(ViewConfiguration.getDoubleTapTimeout() >> 16, new char[]{58894, 58991, 23792, 23432, 28880, 32408, 49329, 54657, 64057, 30863, 21624, 61701, 57041, 25661, 14442, 36112, 45951, 2021, 7640, 43678, 38659, 9149, 376, 18044, 27605, 53037}, objArr9);
        String str = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        a(Drawable.resolveOpacity(0, 0), new char[]{48584, 48557, 3569, 2699, 40342, 37851, 63529, 60699, 41443, 10624, 47419, 51681, 34077, 13612, 54635, 46511, 59561, 22264, 61578}, objArr10);
        String str2 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        a(ViewConfiguration.getScrollDefaultDelay() >> 16, new char[]{1042, 1144, 46111, 45928, 9767, 10365, 63576, 60795, 6244, 36970, 664, 51628, 15557, 35968, 28402, 46547, 20841, 61186, 19244, 37503}, objArr11);
        String str3 = (String) objArr11[0];
        Object[] objArr12 = new Object[1];
        a(ViewCompat.MEASURED_STATE_MASK - Color.rgb(0, 0, 0), new char[]{34200, 34289, 46759, 45525, 36351, 33718, 13287, 9931, 39348, 37586, 43334, 516, 48480, 36466, 50457, 32381, 53459, 60836, 57574, 22984}, objArr12);
        String str4 = (String) objArr12[0];
        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame3 == null) {
            int scrollBarSize = (ViewConfiguration.getScrollBarSize() >> 8) + 30;
            char cIndexOf = (char) (49361 - TextUtils.indexOf((CharSequence) "", '0'));
            int pressedStateDuration = 684 - (ViewConfiguration.getPressedStateDuration() >> 16);
            byte[] bArr = $$a;
            Object[] objArr13 = new Object[1];
            b(bArr[102], bArr[25], (byte) 105, objArr13);
            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(scrollBarSize, cIndexOf, pressedStateDuration, 752929587, false, (String) objArr13[0], null);
        }
        long j = ((Field) objAccessartificialFrame3).getLong(null);
        if (j == -1 || j + 2030 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr14 = new Object[1];
            a(Drawable.resolveOpacity(0, 0), new char[]{39568, 39665, 64111, 64791, 62449, 64953, 43081, 48505, 34471, 56848, 55129, 39421, 41537, 49825, 47893, 58773, 53209, 41322, 40697, 49770, 60294, 34056, 33345, 11922, 6012, 27057, 26159, 2774, 12513, 19541}, objArr14);
            Class<?> cls = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            a(View.MeasureSpec.getSize(0), new char[]{24205, 24302, 35211, 36584, 17237, 19723, 32948, 38276, 17072, 44520, 26619, 45423, 26189, 45406, 3003, 52527, 3046, 53911, 11851, 60055, 12162, 63216}, objArr15);
            Context applicationContext = (Context) cls.getMethod((String) objArr15[0], new Class[0]).invoke(null, null);
            if (applicationContext != null) {
                applicationContext = (((applicationContext instanceof ContextWrapper) ^ true) || ((ContextWrapper) applicationContext).getBaseContext() != null) ? applicationContext.getApplicationContext() : null;
            }
            try {
                Object[] objArr16 = {applicationContext, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 2022703997};
                byte[] bArr2 = $$d;
                Object[] objArr17 = new Object[1];
                c((short) 699, (byte) (-bArr2[119]), bArr2[438], objArr17);
                Class<?> cls2 = Class.forName((String) objArr17[0]);
                Object[] objArr18 = new Object[1];
                c((short) 630, bArr2[577], bArr2[4], objArr18);
                objArr = (Object[]) cls2.getMethod((String) objArr18[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr16);
                if (applicationContext != null) {
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-326560385);
                    if (objAccessartificialFrame4 == null) {
                        int keyRepeatDelay = 30 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                        char windowTouchSlop = (char) (49362 - (ViewConfiguration.getWindowTouchSlop() >> 8));
                        int offsetAfter = 684 - TextUtils.getOffsetAfter("", 0);
                        byte[] bArr3 = $$a;
                        Object[] objArr19 = new Object[1];
                        b(bArr3[102], bArr3[26], (byte) ($$b + 5), objArr19);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay, windowTouchSlop, offsetAfter, 1944867703, false, (String) objArr19[0], null);
                    }
                    ((Field) objAccessartificialFrame4).set(null, objArr);
                    try {
                        Long lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                        if (objAccessartificialFrame5 == null) {
                            int i9 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 30;
                            char c2 = (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 49363);
                            int trimmedLength = TextUtils.getTrimmedLength("") + 684;
                            byte[] bArr4 = $$a;
                            Object[] objArr20 = new Object[1];
                            b(bArr4[102], bArr4[25], (byte) 105, objArr20);
                            objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i9, c2, trimmedLength, 752929587, false, (String) objArr20[0], null);
                        }
                        ((Field) objAccessartificialFrame5).set(null, lValueOf);
                    } catch (Exception unused) {
                        throw new RuntimeException();
                    }
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } else {
            Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-326560385);
            if (objAccessartificialFrame6 == null) {
                int keyRepeatDelay2 = 30 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                char cArgb = (char) (Color.argb(0, 0, 0, 0) + 49362);
                int maximumDrawingCacheSize = 684 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                byte[] bArr5 = $$a;
                Object[] objArr21 = new Object[1];
                b(bArr5[102], bArr5[26], (byte) ($$b + 5), objArr21);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay2, cArgb, maximumDrawingCacheSize, 1944867703, false, (String) objArr21[0], null);
            }
            Object[] objArr22 = (Object[]) ((Field) objAccessartificialFrame6).get(null);
            objArr = new Object[]{new int[]{((int[]) objArr22[0])[0]}, new int[]{((int[]) objArr22[1])[0]}, new int[1], (String) objArr22[3]};
            int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
            int i10 = (-1020441538) + (((~((~iFreeMemory) | 42123456)) | (-936631519)) * 529) + (((~(iFreeMemory | 42123456)) | (-936500319)) * 529) + 2022703997;
            int i11 = (i10 << 13) ^ i10;
            int i12 = i11 ^ (i11 >>> 17);
            ((int[]) objArr[2])[0] = i12 ^ (i12 << 5);
        }
        int i13 = ((int[]) objArr[1])[0];
        int i14 = ((int[]) objArr[0])[0];
        if (i14 == i13) {
            int i15 = ((int[]) objArr[2])[0];
            Object[] objArr23 = {new int[]{((int[]) objArr[0])[0]}, new int[]{((int[]) objArr[1])[0]}, new int[1], (String) objArr[3]};
            int i16 = ~((~System.identityHashCode(this)) | 636920947);
            int i17 = i15 + ((564266064 | i16) * (-374)) + 157611740 + ((i16 | 72654883) * 374);
            int i18 = (i17 << 13) ^ i17;
            int i19 = i18 ^ (i18 >>> 17);
            ((int[]) objArr23[2])[0] = i19 ^ (i19 << 5);
            i = 0;
        } else {
            long j2 = (((long) (-1992075608)) << 32) ^ ((long) (i13 ^ i14));
            long j3 = -1992075604;
            int i20 = artificialFrame + 65;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i20 % 128;
            int i21 = i20 % 2;
            try {
                Object[] objArr24 = {Long.valueOf(j2), Long.valueOf(j3)};
                short s = (short) TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_TYPE;
                byte[] bArr6 = $$d;
                Object[] objArr25 = new Object[1];
                c(s, (byte) (-bArr6[119]), bArr6[288], objArr25);
                Class<?> cls3 = Class.forName((String) objArr25[0]);
                byte b = bArr6[96];
                Object[] objArr26 = new Object[1];
                c((short) 545, b, b, objArr26);
                cls3.getMethod((String) objArr26[0], Long.TYPE, Long.TYPE).invoke(null, objArr24);
                int i22 = ((int[]) objArr[2])[0];
                Object[] objArr27 = {new int[]{((int[]) objArr[0])[0]}, new int[]{((int[]) objArr[1])[0]}, new int[1], (String) objArr[3]};
                int iIdentityHashCode = System.identityHashCode(this);
                int i23 = i22 + (-1188835266) + (((~(iIdentityHashCode | 904390598)) | (-904919007)) * 305) + (((~((~iIdentityHashCode) | 904390598)) | (-74233177)) * 305);
                int i24 = (i23 << 13) ^ i23;
                int i25 = i24 ^ (i24 >>> 17);
                i = 0;
                ((int[]) objArr27[2])[0] = i25 ^ (i25 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 != null) {
                    throw cause2;
                }
                throw th2;
            }
        }
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame7 == null) {
            int i26 = (ExpandableListView.getPackedPositionForGroup(i) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(i) == 0L ? 0 : -1)) + 30;
            char cGreen = (char) (Color.green(i) + 49362);
            int iIndexOf = 683 - TextUtils.indexOf((CharSequence) "", '0');
            byte[] bArr7 = $$a;
            Object[] objArr28 = new Object[1];
            b(bArr7[17], bArr7[26], (byte) (-bArr7[2]), objArr28);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(i26, cGreen, iIndexOf, -1583976536, false, (String) objArr28[0], null);
        }
        long j4 = ((Field) objAccessartificialFrame7).getLong(null);
        if (j4 == -1 || j4 + 1887 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr29 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -274465041};
            byte[] bArr8 = $$d;
            Object[] objArr30 = new Object[1];
            c((short) 543, (byte) (-bArr8[119]), bArr8[451], objArr30);
            Class<?> cls4 = Class.forName((String) objArr30[0]);
            Object[] objArr31 = new Object[1];
            c((short) 467, (byte) (-bArr8[119]), bArr8[34], objArr31);
            objArr2 = (Object[]) cls4.getMethod((String) objArr31[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr29);
            Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame8 == null) {
                int i27 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 29;
                char gidForName = (char) (49361 - Process.getGidForName(""));
                int iLastIndexOf = 683 - TextUtils.lastIndexOf("", '0');
                byte[] bArr9 = $$a;
                byte b2 = bArr9[110];
                byte b3 = (byte) (-bArr9[18]);
                Object[] objArr32 = new Object[1];
                b(b2, b3, (byte) (b3 | 56), objArr32);
                objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i27, gidForName, iLastIndexOf, -1456483158, false, (String) objArr32[0], null);
            }
            ((Field) objAccessartificialFrame8).set(null, objArr2);
            try {
                Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame9 == null) {
                    int packedPositionGroup = ExpandableListView.getPackedPositionGroup(0L) + 30;
                    char cBlue = (char) (Color.blue(0) + 49362);
                    int capsMode = 684 - TextUtils.getCapsMode("", 0, 0);
                    byte[] bArr10 = $$a;
                    Object[] objArr33 = new Object[1];
                    b(bArr10[17], bArr10[26], (byte) (-bArr10[2]), objArr33);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(packedPositionGroup, cBlue, capsMode, -1583976536, false, (String) objArr33[0], null);
                }
                ((Field) objAccessartificialFrame9).set(null, lValueOf2);
            } catch (Exception unused2) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame10 == null) {
                int iIndexOf2 = TextUtils.indexOf((CharSequence) "", '0') + 31;
                char cMyPid = (char) (49362 - (Process.myPid() >> 22));
                int i28 = 685 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                byte[] bArr11 = $$a;
                byte b4 = bArr11[110];
                byte b5 = (byte) (-bArr11[18]);
                Object[] objArr34 = new Object[1];
                b(b4, b5, (byte) (b5 | 56), objArr34);
                objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iIndexOf2, cMyPid, i28, -1456483158, false, (String) objArr34[0], null);
            }
            Object[] objArr35 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
            objArr2 = new Object[]{new int[]{((int[]) objArr35[0])[0]}, new int[]{((int[]) objArr35[1])[0]}, new int[1], (String) objArr35[3]};
            int iMyPid = Process.myPid();
            int i29 = (-1120881602) + (((~((-471583664) | iMyPid)) | 471384367 | (~((-507040112) | iMyPid))) * (-880));
            int i30 = (~((-471583664) | (~iMyPid))) | 507040111;
            int i31 = ~(iMyPid | 471583663);
            int i32 = ((i29 + ((i30 | i31) * (-880))) + (i31 * 880)) - 274465041;
            int i33 = (i32 << 13) ^ i32;
            int i34 = i33 ^ (i33 >>> 17);
            ((int[]) objArr2[2])[0] = i34 ^ (i34 << 5);
        }
        int i35 = ((int[]) objArr2[1])[0];
        int i36 = ((int[]) objArr2[0])[0];
        if (i36 == i35) {
            int i37 = ((int[]) objArr2[2])[0];
            Object[] objArr36 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i38 = i37 + (-2014000914) + (((~((-249970025) | iIdentityHashCode2)) | 174464288) * 104) + ((~((~iIdentityHashCode2) | 804159486)) * (-104)) + ((iIdentityHashCode2 | 728653750) * 104);
            int i39 = (i38 << 13) ^ i38;
            int i40 = i39 ^ (i39 >>> 17);
            ((int[]) objArr36[2])[0] = i40 ^ (i40 << 5);
            int i41 = getARTIFICIAL_FRAME_PACKAGE_NAME + 23;
            artificialFrame = i41 % 128;
            int i42 = i41 % 2;
            i2 = 0;
        } else {
            new ArrayList().add((String) objArr2[3]);
            Object[] objArr37 = {Long.valueOf(((long) (i35 ^ i36)) ^ (((long) 1583788439) << 32)), Long.valueOf(1583788423)};
            byte[] bArr12 = $$d;
            Object[] objArr38 = new Object[1];
            c((short) 451, (byte) (-bArr12[119]), bArr12[108], objArr38);
            Class<?> cls5 = Class.forName((String) objArr38[0]);
            byte b6 = bArr12[96];
            Object[] objArr39 = new Object[1];
            c((short) 545, b6, b6, objArr39);
            cls5.getMethod((String) objArr39[0], Long.TYPE, Long.TYPE).invoke(null, objArr37);
            int i43 = ((int[]) objArr2[2])[0];
            Object[] objArr40 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int iIdentityHashCode3 = System.identityHashCode(this);
            int i44 = i43 + 844754074 + (((~((-522657656) | iIdentityHashCode3)) | (-455966120)) * (-964)) + (((~((~iIdentityHashCode3) | (-522657656))) | 67240528) * (-964));
            int i45 = (i44 << 13) ^ i44;
            int i46 = i45 ^ (i45 >>> 17);
            i2 = 0;
            ((int[]) objArr40[2])[0] = i46 ^ (i46 << 5);
        }
        Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame11 == null) {
            int iResolveSize = View.resolveSize(i2, i2) + 30;
            char keyRepeatTimeout = (char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 49362);
            int pressedStateDuration2 = 684 - (ViewConfiguration.getPressedStateDuration() >> 16);
            byte[] bArr13 = $$a;
            byte b7 = bArr13[17];
            byte b8 = bArr13[25];
            Object[] objArr41 = new Object[1];
            b(b7, b8, (byte) (b8 | 53), objArr41);
            objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(iResolveSize, keyRepeatTimeout, pressedStateDuration2, 508509282, false, (String) objArr41[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame11).getLong(null);
        if (j5 == -1 || j5 + 2012 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr42 = new Object[1];
            a(1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), new char[]{39568, 39665, 64111, 64791, 62449, 64953, 43081, 48505, 34471, 56848, 55129, 39421, 41537, 49825, 47893, 58773, 53209, 41322, 40697, 49770, 60294, 34056, 33345, 11922, 6012, 27057, 26159, 2774, 12513, 19541}, objArr42);
            Class<?> cls6 = Class.forName((String) objArr42[0]);
            Object[] objArr43 = new Object[1];
            a(Color.rgb(0, 0, 0) + 16777216, new char[]{24205, 24302, 35211, 36584, 17237, 19723, 32948, 38276, 17072, 44520, 26619, 45423, 26189, 45406, 3003, 52527, 3046, 53911, 11851, 60055, 12162, 63216}, objArr43);
            Context applicationContext2 = (Context) cls6.getMethod((String) objArr43[0], new Class[0]).invoke(null, null);
            if (applicationContext2 == null) {
                obj = null;
            } else {
                if (applicationContext2 instanceof ContextWrapper) {
                    int i47 = artificialFrame + 67;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i47 % 128;
                    if (i47 % 2 != 0) {
                        ((ContextWrapper) applicationContext2).getBaseContext();
                        Object obj2 = null;
                        obj2.hashCode();
                        throw null;
                    }
                    if (((ContextWrapper) applicationContext2).getBaseContext() == null) {
                        applicationContext2 = null;
                        obj = null;
                    }
                }
                obj = null;
                applicationContext2 = applicationContext2.getApplicationContext();
            }
            int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(obj, this)).intValue();
            int i48 = getARTIFICIAL_FRAME_PACKAGE_NAME + 47;
            artificialFrame = i48 % 128;
            int i49 = i48 % 2;
            Object[] objArr44 = {applicationContext2, Integer.valueOf(iIntValue), -1580720893};
            byte[] bArr14 = $$d;
            Object[] objArr45 = new Object[1];
            c((short) 427, (byte) (-bArr14[119]), (byte) 100, objArr45);
            Class<?> cls7 = Class.forName((String) objArr45[0]);
            Object[] objArr46 = new Object[1];
            c((short) 325, bArr14[95], bArr14[39], objArr46);
            objArr3 = (Object[]) cls7.getMethod((String) objArr46[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr44);
            if (applicationContext2 != null) {
                Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame12 == null) {
                    int tapTimeout = 30 - (ViewConfiguration.getTapTimeout() >> 16);
                    char maximumDrawingCacheSize2 = (char) (49362 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                    int size = 684 - View.MeasureSpec.getSize(0);
                    byte[] bArr15 = $$a;
                    Object[] objArr47 = new Object[1];
                    b((byte) (bArr15[110] - 1), bArr15[102], (byte) (-bArr15[68]), objArr47);
                    objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(tapTimeout, maximumDrawingCacheSize2, size, -1321816393, false, (String) objArr47[0], null);
                }
                ((Field) objAccessartificialFrame12).set(null, objArr3);
                try {
                    Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                    if (objAccessartificialFrame13 == null) {
                        int iResolveSizeAndState = View.resolveSizeAndState(0, 0, 0) + 30;
                        char scrollBarFadeDuration = (char) ((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 49362);
                        int modifierMetaStateMask = 683 - ((byte) KeyEvent.getModifierMetaStateMask());
                        byte[] bArr16 = $$a;
                        byte b9 = bArr16[17];
                        byte b10 = bArr16[25];
                        Object[] objArr48 = new Object[1];
                        b(b9, b10, (byte) (b10 | 53), objArr48);
                        objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState, scrollBarFadeDuration, modifierMetaStateMask, 508509282, false, (String) objArr48[0], null);
                    }
                    ((Field) objAccessartificialFrame13).set(null, lValueOf3);
                } catch (Exception unused3) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(777251007);
            if (objAccessartificialFrame14 == null) {
                int keyRepeatDelay3 = 30 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                char doubleTapTimeout = (char) (49362 - (ViewConfiguration.getDoubleTapTimeout() >> 16));
                int bitsPerPixel = ImageFormat.getBitsPerPixel(0) + 685;
                byte[] bArr17 = $$a;
                Object[] objArr49 = new Object[1];
                b((byte) (bArr17[110] - 1), bArr17[102], (byte) (-bArr17[68]), objArr49);
                objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay3, doubleTapTimeout, bitsPerPixel, -1321816393, false, (String) objArr49[0], null);
            }
            Object[] objArr50 = (Object[]) ((Field) objAccessartificialFrame14).get(null);
            objArr3 = new Object[]{new int[]{((int[]) objArr50[0])[0]}, new int[]{((int[]) objArr50[1])[0]}, new int[1], (String) objArr50[3]};
            int iIdentityHashCode4 = System.identityHashCode(this);
            int i50 = ~iIdentityHashCode4;
            int i51 = (((2063287008 + (((~((-242167275) | i50)) | 736456500) * 226)) + (((~(i50 | (-67764427))) | ((~((-736456501) | iIdentityHashCode4)) | 562053652)) * (-113))) + ((~(iIdentityHashCode4 | (-242167275))) * 113)) - 1580720893;
            int i52 = (i51 << 13) ^ i51;
            int i53 = i52 ^ (i52 >>> 17);
            ((int[]) objArr3[2])[0] = i53 ^ (i53 << 5);
        }
        int i54 = ((int[]) objArr3[1])[0];
        int i55 = ((int[]) objArr3[0])[0];
        if (i55 == i54) {
            int i56 = ((int[]) objArr3[2])[0];
            Object[] objArr51 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
            int iIdentityHashCode5 = System.identityHashCode(this);
            int i57 = ~iIdentityHashCode5;
            int i58 = i56 + (-2035958225) + (((~((-173350434) | i57)) | (~((-8519709) | iIdentityHashCode5)) | (~((-623403201) | iIdentityHashCode5))) * 765) + ((173350433 | (~((-181870142) | i57))) * 1530) + (((~(iIdentityHashCode5 | (-181870142))) | (~(i57 | (-623403201)))) * 765);
            int i59 = (i58 << 13) ^ i58;
            int i60 = i59 ^ (i59 >>> 17);
            ((int[]) objArr51[2])[0] = i60 ^ (i60 << 5);
            i3 = 0;
        } else {
            Object[] objArr52 = {Long.valueOf(((long) (i54 ^ i55)) ^ (((long) (-1180346123)) << 32)), Long.valueOf(-1180345611)};
            short s2 = (short) TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_TYPE;
            byte[] bArr18 = $$d;
            Object[] objArr53 = new Object[1];
            c(s2, (byte) (-bArr18[119]), bArr18[288], objArr53);
            Class<?> cls8 = Class.forName((String) objArr53[0]);
            byte b11 = bArr18[96];
            Object[] objArr54 = new Object[1];
            c((short) 545, b11, b11, objArr54);
            cls8.getMethod((String) objArr54[0], Long.TYPE, Long.TYPE).invoke(null, objArr52);
            int i61 = ((int[]) objArr3[2])[0];
            Object[] objArr55 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
            int iIdentityHashCode6 = System.identityHashCode(this);
            int i62 = ~iIdentityHashCode6;
            int i63 = i61 + (-1525399594) + (((~(978320382 | i62)) | 303392) * 220) + (((~(i62 | 172880302)) | 805743472) * (-440)) + ((iIdentityHashCode6 | 978320382) * 220);
            int i64 = (i63 << 13) ^ i63;
            int i65 = i64 ^ (i64 >>> 17);
            i3 = 0;
            ((int[]) objArr55[2])[0] = i65 ^ (i65 << 5);
        }
        Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame15 == null) {
            int iIndexOf3 = 35 - TextUtils.indexOf((CharSequence) "", '0', i3);
            char cRed = (char) Color.red(i3);
            int iMyPid2 = (Process.myPid() >> 22) + 540;
            byte[] bArr19 = $$a;
            byte b12 = bArr19[110];
            Object[] objArr56 = new Object[1];
            b(b12, (byte) (b12 - 1), (byte) (-bArr19[21]), objArr56);
            objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(iIndexOf3, cRed, iMyPid2, 624296913, false, (String) objArr56[0], null);
        }
        long j6 = ((Field) objAccessartificialFrame15).getLong(null);
        if (j6 == -1 || j6 + 1940 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            try {
                Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-1717965552);
                if (objAccessartificialFrame16 == null) {
                    objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.NAK, (char) (39515 - MotionEvent.axisFromString("")), Color.red(0) + 982, 117222168, false, null, new Class[0]);
                }
                Object[] objArr57 = {null, ((Constructor) objAccessartificialFrame16).newInstance(null), 395014775, 0};
                Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-501205803);
                if (objAccessartificialFrame17 == null) {
                    int i66 = 37 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                    char cNormalizeMetaState = (char) KeyEvent.normalizeMetaState(0);
                    int iLastIndexOf2 = 539 - TextUtils.lastIndexOf("", '0', 0, 0);
                    byte[] bArr20 = $$a;
                    byte b13 = bArr20[23];
                    Object[] objArr58 = new Object[1];
                    b(b13, (byte) (b13 | 34), bArr20[48], objArr58);
                    objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(i66, cNormalizeMetaState, iLastIndexOf2, 2101703389, false, (String) objArr58[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation((ViewConfiguration.getWindowTouchSlop() >> 8) + 54, (char) (View.combineMeasuredStates(0, 0) + 833), TextUtils.lastIndexOf("", '0') + 577), (Class) ArtificialStackFrames.coroutineCreation(53 - TextUtils.lastIndexOf("", '0'), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 630), Integer.TYPE, Integer.TYPE});
                }
                objArr4 = (Object[]) ((Method) objAccessartificialFrame17).invoke(null, objArr57);
                Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                if (objAccessartificialFrame18 == null) {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0) + 36;
                    char cResolveOpacity = (char) Drawable.resolveOpacity(0, 0);
                    int size2 = View.MeasureSpec.getSize(0) + 540;
                    byte b14 = $$a[110];
                    byte b15 = (byte) (b14 - 1);
                    Object[] objArr59 = new Object[1];
                    b(b14, b15, (byte) (b15 | Ascii.FS), objArr59);
                    objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec, cResolveOpacity, size2, 793268735, false, (String) objArr59[0], null);
                }
                ((Field) objAccessartificialFrame18).set(null, objArr4);
                try {
                    Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                    if (objAccessartificialFrame19 == null) {
                        int iAxisFromString = 35 - MotionEvent.axisFromString("");
                        char size3 = (char) View.MeasureSpec.getSize(0);
                        int i67 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 541;
                        byte[] bArr21 = $$a;
                        byte b16 = bArr21[110];
                        Object[] objArr60 = new Object[1];
                        b(b16, (byte) (b16 - 1), (byte) (-bArr21[21]), objArr60);
                        objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(iAxisFromString, size3, i67, 624296913, false, (String) objArr60[0], null);
                    }
                    ((Field) objAccessartificialFrame19).set(null, lValueOf4);
                } catch (Exception unused4) {
                    throw new RuntimeException();
                }
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 != null) {
                    throw cause3;
                }
                throw th3;
            }
        } else {
            Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame20 == null) {
                int touchSlop = 36 - (ViewConfiguration.getTouchSlop() >> 8);
                char absoluteGravity = (char) Gravity.getAbsoluteGravity(0, 0);
                int iIndexOf4 = TextUtils.indexOf("", "", 0) + 540;
                byte b17 = $$a[110];
                byte b18 = (byte) (b17 - 1);
                Object[] objArr61 = new Object[1];
                b(b17, b18, (byte) (b18 | Ascii.FS), objArr61);
                objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(touchSlop, absoluteGravity, iIndexOf4, 793268735, false, (String) objArr61[0], null);
            }
            Object[] objArr62 = (Object[]) ((Field) objAccessartificialFrame20).get(null);
            objArr4 = new Object[]{new int[1], new int[1], new int[1]};
            int i68 = ((int[]) objArr62[2])[0];
            int i69 = ((int[]) objArr62[1])[0];
            ((int[]) objArr4[2])[0] = i68;
            ((int[]) objArr4[1])[0] = i69;
            int iIdentityHashCode7 = System.identityHashCode(this);
            int i70 = ~iIdentityHashCode7;
            int i71 = 892735870 + ((iIdentityHashCode7 | 38048624) * (-859)) + (((~((-37781761) | iIdentityHashCode7)) | (~(38048624 | i70))) * 859) + (((~((-1313573126) | i70)) | 1275791365) * 859) + 395014775;
            int i72 = (i71 << 13) ^ i71;
            int i73 = i72 ^ (i72 >>> 17);
            ((int[]) objArr4[0])[0] = i73 ^ (i73 << 5);
        }
        Object obj3 = objArr4[1];
        int i74 = ((int[]) obj3)[0];
        Object obj4 = objArr4[2];
        int i75 = ((int[]) obj4)[0];
        if (i75 == i74) {
            Object[] objArr63 = {new int[1], new int[1], new int[1]};
            int i76 = ((int[]) objArr4[0])[0];
            int i77 = ((int[]) obj4)[0];
            int i78 = ((int[]) obj3)[0];
            ((int[]) objArr63[2])[0] = i77;
            ((int[]) objArr63[1])[0] = i78;
            int iUptimeMillis = (int) SystemClock.uptimeMillis();
            int i79 = (~((-293325409) | iUptimeMillis)) | 286278144;
            int i80 = ~iUptimeMillis;
            int i81 = i76 + 1858723217 + ((i79 | (~(1065343605 | i80))) * 886) + (((~(i80 | 293325408)) | 1058296341) * (-1772)) + ((~(i80 | 1058296341)) * 886);
            int i82 = (i81 << 13) ^ i81;
            int i83 = i82 ^ (i82 >>> 17);
            ((int[]) objArr63[0])[0] = i83 ^ (i83 << 5);
        } else {
            Object[] objArr64 = {Long.valueOf(((long) (i74 ^ i75)) ^ (((long) 1168048425) << 32)), Long.valueOf(1168052521)};
            byte[] bArr22 = $$d;
            Object[] objArr65 = new Object[1];
            c((short) 305, (byte) (-bArr22[119]), bArr22[632], objArr65);
            Class<?> cls9 = Class.forName((String) objArr65[0]);
            byte b19 = bArr22[96];
            Object[] objArr66 = new Object[1];
            c((short) 545, b19, b19, objArr66);
            cls9.getMethod((String) objArr66[0], Long.TYPE, Long.TYPE).invoke(null, objArr64);
            Object[] objArr67 = {new int[1], new int[1], new int[1]};
            int i84 = ((int[]) objArr4[0])[0];
            int i85 = ((int[]) objArr4[2])[0];
            int i86 = ((int[]) objArr4[1])[0];
            ((int[]) objArr67[2])[0] = i85;
            ((int[]) objArr67[1])[0] = i86;
            int iIdentityHashCode8 = System.identityHashCode(this);
            int i87 = ~iIdentityHashCode8;
            int i88 = i84 + (-696473972) + ((430490344 | i87) * (-757)) + ((~((-642193670) | iIdentityHashCode8)) * 1514) + (((~(iIdentityHashCode8 | 1072684013)) | (~(i87 | (-921131406))) | 278937736) * 757);
            int i89 = (i88 << 13) ^ i88;
            int i90 = i89 ^ (i89 >>> 17);
            ((int[]) objArr67[0])[0] = i90 ^ (i90 << 5);
        }
        Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame21 == null) {
            int doubleTapTimeout2 = 26 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
            char maximumFlingVelocity = (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16);
            int i91 = 1041 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
            byte[] bArr23 = $$a;
            byte b20 = bArr23[110];
            Object[] objArr68 = new Object[1];
            b(b20, (byte) (b20 - 1), (byte) (-bArr23[21]), objArr68);
            objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout2, maximumFlingVelocity, i91, 2061780482, false, (String) objArr68[0], null);
        }
        long j7 = ((Field) objAccessartificialFrame21).getLong(null);
        if (j7 == -1 || j7 + 1901 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr69 = {-5970367};
            Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame22 == null) {
                objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(7 - TextUtils.lastIndexOf("", '0', 0), (char) (22251 - ExpandableListView.getPackedPositionGroup(0L)), TextUtils.getTrimmedLength("") + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = RandomKt.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame22).newInstance(objArr69), 134018517, false);
            Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame23 == null) {
                int i92 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 25;
                char c3 = (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1);
                int offsetAfter2 = TextUtils.getOffsetAfter("", 0) + 1041;
                byte b21 = $$a[110];
                byte b22 = (byte) (b21 - 1);
                Object[] objArr70 = new Object[1];
                b(b21, b22, (byte) (b22 | Ascii.FS), objArr70);
                objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(i92, c3, offsetAfter2, 1145017376, false, (String) objArr70[0], null);
            }
            ((Field) objAccessartificialFrame23).set(null, objArrAccessartificialFrame$78cbbd35);
            try {
                Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame24 == null) {
                    int i93 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 25;
                    char deadChar = (char) KeyEvent.getDeadChar(0, 0);
                    int i94 = 1042 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                    byte[] bArr24 = $$a;
                    byte b23 = bArr24[110];
                    Object[] objArr71 = new Object[1];
                    b(b23, (byte) (b23 - 1), (byte) (-bArr24[21]), objArr71);
                    objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(i93, deadChar, i94, 2061780482, false, (String) objArr71[0], null);
                }
                ((Field) objAccessartificialFrame24).set(null, lValueOf5);
            } catch (Exception unused5) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame25 == null) {
                int iResolveSizeAndState2 = 26 - View.resolveSizeAndState(0, 0, 0);
                char mode = (char) View.MeasureSpec.getMode(0);
                int iIndexOf5 = 1040 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                byte b24 = $$a[110];
                byte b25 = (byte) (b24 - 1);
                Object[] objArr72 = new Object[1];
                b(b24, b25, (byte) (b25 | Ascii.FS), objArr72);
                objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState2, mode, iIndexOf5, 1145017376, false, (String) objArr72[0], null);
            }
            Object[] objArr73 = (Object[]) ((Field) objAccessartificialFrame25).get(null);
            objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
            int i95 = ((int[]) objArr73[3])[0];
            int i96 = ((int[]) objArr73[2])[0];
            String[] strArr = (String[]) objArr73[0];
            int iIdentityHashCode9 = System.identityHashCode(this);
            int i97 = (((~((-77894253) | iIdentityHashCode9)) * 521) - 1420001776) + (((~((~iIdentityHashCode9) | (-77894253))) | (-536665966)) * 521) + 134018517;
            int i98 = (i97 << 13) ^ i97;
            int i99 = i98 ^ (i98 >>> 17);
            ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i99 ^ (i99 << 5);
        }
        int i100 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i101 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i101 == i100) {
            Object[] objArr74 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i102 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i103 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i104 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int i105 = ~new Random().nextInt();
            int i106 = i102 + (-540139103) + ((~((-555759661) | i105)) * (-783)) + (((~(i105 | (-557398062))) | (-635501869)) * 783);
            int i107 = (i106 << 13) ^ i106;
            int i108 = i107 ^ (i107 >>> 17);
            ((int[]) objArr74[1])[0] = i108 ^ (i108 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr3 != null) {
                int i109 = artificialFrame + b.f40o;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i109 % 128;
                int i110 = i109 % 2;
                for (String str5 : strArr3) {
                    arrayList.add(str5);
                }
            }
            Object[] objArr75 = {Long.valueOf(((long) (i100 ^ i101)) ^ (((long) (-1703377277)) << 32)), Long.valueOf(-1703377279)};
            byte[] bArr25 = $$d;
            Object[] objArr76 = new Object[1];
            c((short) 271, (byte) (-bArr25[119]), bArr25[266], objArr76);
            Class<?> cls10 = Class.forName((String) objArr76[0]);
            byte b26 = bArr25[96];
            Object[] objArr77 = new Object[1];
            c((short) 545, b26, b26, objArr77);
            cls10.getMethod((String) objArr77[0], Long.TYPE, Long.TYPE).invoke(null, objArr75);
            Object[] objArr78 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i111 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i112 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i113 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iNextInt = new Random().nextInt();
            int i114 = (-2454178) + (((~(527117393 | iNextInt)) | (-449013587)) * 672);
            int i115 = ~iNextInt;
            int i116 = i111 + i114 + (((~(iNextInt | (-449013587))) | (~((-527117394) | i115))) * (-672)) + (((~(449013586 | i115)) | (-535523156)) * 672);
            int i117 = (i116 << 13) ^ i116;
            int i118 = i117 ^ (i117 >>> 17);
            ((int[]) objArr78[1])[0] = i118 ^ (i118 << 5);
        }
        Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame26 == null) {
            int doubleTapTimeout3 = 21 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
            char tapTimeout2 = (char) (ViewConfiguration.getTapTimeout() >> 16);
            int iMakeMeasureSpec2 = 465 - View.MeasureSpec.makeMeasureSpec(0, 0);
            byte[] bArr26 = $$a;
            byte b27 = bArr26[110];
            Object[] objArr79 = new Object[1];
            b(b27, (byte) (b27 - 1), (byte) (-bArr26[21]), objArr79);
            objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout3, tapTimeout2, iMakeMeasureSpec2, -785931255, false, (String) objArr79[0], null);
        }
        long j8 = ((Field) objAccessartificialFrame26).getLong(null);
        if (j8 == -1 || j8 + 1963 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr80 = new Object[1];
            a(Color.blue(0), new char[]{39568, 39665, 64111, 64791, 62449, 64953, 43081, 48505, 34471, 56848, 55129, 39421, 41537, 49825, 47893, 58773, 53209, 41322, 40697, 49770, 60294, 34056, 33345, 11922, 6012, 27057, 26159, 2774, 12513, 19541}, objArr80);
            Class<?> cls11 = Class.forName((String) objArr80[0]);
            Object[] objArr81 = new Object[1];
            a(ViewCompat.MEASURED_STATE_MASK - Color.rgb(0, 0, 0), new char[]{24205, 24302, 35211, 36584, 17237, 19723, 32948, 38276, 17072, 44520, 26619, 45423, 26189, 45406, 3003, 52527, 3046, 53911, 11851, 60055, 12162, 63216}, objArr81);
            Method method = cls11.getMethod((String) objArr81[0], new Class[0]);
            Context applicationContext3 = (Context) method.invoke(null, null);
            if (applicationContext3 != null) {
                applicationContext3 = ((applicationContext3 instanceof ContextWrapper) && ((ContextWrapper) applicationContext3).getBaseContext() == null) ? null : applicationContext3.getApplicationContext();
            }
            int iIntValue3 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr82 = new Object[1];
            a((-1) - Process.getGidForName(""), new char[]{19473, 19575, 47991, 48208, 28477, 24870, 41088, 46576, 20602, 40795, 19396, 37165, 29890, 33711, 10191, 60691, 6441, 57464, 554, 51884, 15636, 50242, 7836, 9751, 49564, 10407, 64250, 540, 58934, 3351, 55593, 8162, 35357, 28950, 46551, 31564, 44727, 21939, 37375, 22758, 45873, 47640, 27739, 46268, 22353, 40629, 18652, 36871, 31713, 33466, 9393, 60858, 6231, 59143, 779, 51669, 15440, 52202, 8116, 9563, 49393, 12245, 64443, 759, 58638, 3085, 54806, 7897}, objArr82);
            String str6 = (String) objArr82[0];
            Object[] objArr83 = new Object[1];
            a(TextUtils.indexOf((CharSequence) "", '0', 0) + 1, new char[]{3743, 3754, 31652, 31877, 23904, 21289, 34322, 37685, 4770, 24461, 31133, 47036, 13854, 17274, 5568, 52098, 23457, 8360, 12409, 60513, 32716, 1221, 11412, 213, 33606, 59437, 51448, 9353, 42166, 52631, 60195, 14706, 51347, 45518, 34783, 23946, 60522, 38240, 41975, 32290, 61874, 31434, 24072, 37501, 5590, 24113, 31360, 46738, 14692, 17003, 5866, 52010, 23176, 10112, 12548, 61206, 32389, 2926, 11707, 926, 33325, 61186, 51693, 9267, 42887, 52442, 58395, 14365}, objArr83);
            Object[] objArr84 = {applicationContext3, new String[]{str6, (String) objArr83[0]}, Integer.valueOf(iIntValue3), 1, 1628030023};
            byte[] bArr27 = $$d;
            Object[] objArr85 = new Object[1];
            c((short) 229, (byte) (-bArr27[119]), bArr27[143], objArr85);
            Class<?> cls12 = Class.forName((String) objArr85[0]);
            Object[] objArr86 = new Object[1];
            c((short) 325, bArr27[95], bArr27[39], objArr86);
            objArr5 = (Object[]) cls12.getMethod((String) objArr86[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr84);
            int i119 = ((int[]) objArr5[0])[0];
            int i120 = ((int[]) objArr5[3])[0];
            if (applicationContext3 != null) {
                Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame27 == null) {
                    int trimmedLength2 = 21 - TextUtils.getTrimmedLength("");
                    char absoluteGravity2 = (char) Gravity.getAbsoluteGravity(0, 0);
                    int iRed = Color.red(0) + 465;
                    byte b28 = $$a[110];
                    byte b29 = (byte) (b28 - 1);
                    Object[] objArr87 = new Object[1];
                    b(b28, b29, (byte) (b29 | Ascii.FS), objArr87);
                    objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(trimmedLength2, absoluteGravity2, iRed, -612765161, false, (String) objArr87[0], null);
                }
                ((Field) objAccessartificialFrame27).set(null, objArr5);
                try {
                    Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(1313006081);
                    if (objAccessartificialFrame28 == null) {
                        int i121 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 21;
                        char cMyPid2 = (char) (Process.myPid() >> 22);
                        int capsMode2 = TextUtils.getCapsMode("", 0, 0) + 465;
                        byte[] bArr28 = $$a;
                        byte b30 = bArr28[110];
                        Object[] objArr88 = new Object[1];
                        b(b30, (byte) (b30 - 1), (byte) (-bArr28[21]), objArr88);
                        objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(i121, cMyPid2, capsMode2, -785931255, false, (String) objArr88[0], null);
                    }
                    ((Field) objAccessartificialFrame28).set(null, lValueOf6);
                } catch (Exception unused6) {
                    throw new RuntimeException();
                }
            }
            c = 0;
        } else {
            Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(1142731807);
            if (objAccessartificialFrame29 == null) {
                int touchSlop2 = 21 - (ViewConfiguration.getTouchSlop() >> 8);
                char trimmedLength3 = (char) TextUtils.getTrimmedLength("");
                int iMyTid = (Process.myTid() >> 22) + 465;
                byte b31 = $$a[110];
                byte b32 = (byte) (b31 - 1);
                Object[] objArr89 = new Object[1];
                b(b31, b32, (byte) (b32 | Ascii.FS), objArr89);
                objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(touchSlop2, trimmedLength3, iMyTid, -612765161, false, (String) objArr89[0], null);
            }
            Object[] objArr90 = (Object[]) ((Field) objAccessartificialFrame29).get(null);
            objArr5 = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
            int i122 = ((int[]) objArr90[3])[0];
            int i123 = ((int[]) objArr90[0])[0];
            String[] strArr5 = (String[]) objArr90[1];
            int i124 = ~((int) Process.getStartUptimeMillis());
            int i125 = ~(901454067 | i124);
            int i126 = 212557985 + ((i125 | (-741104342)) * 764) + (((~(i124 | (-741104342))) | 606607569) * (-1528)) + (((-429343271) | i125) * 764) + 1628030023;
            int i127 = (i126 << 13) ^ i126;
            int i128 = i127 ^ (i127 >>> 17);
            ((int[]) objArr5[2])[0] = i128 ^ (i128 << 5);
            c = 0;
        }
        int i129 = ((int[]) objArr5[c])[c];
        int i130 = ((int[]) objArr5[3])[c];
        if (i130 == i129) {
            int i131 = getARTIFICIAL_FRAME_PACKAGE_NAME + 9;
            artificialFrame = i131 % 128;
            int i132 = i131 % 2;
            Object[] objArr91 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i133 = ((int[]) objArr5[2])[0];
            int i134 = ((int[]) objArr5[3])[0];
            int i135 = ((int[]) objArr5[0])[0];
            String[] strArr6 = (String[]) objArr5[1];
            int iIdentityHashCode10 = System.identityHashCode(this);
            int i136 = ~iIdentityHashCode10;
            int i137 = i133 + (-1476990593) + (((~(322949769 | i136)) | (~((-483299496) | iIdentityHashCode10))) * 210) + (((~(iIdentityHashCode10 | 536859311)) | (~(i136 | (-269389954)))) * 210);
            int i138 = (i137 << 13) ^ i137;
            int i139 = i138 ^ (i138 >>> 17);
            ((int[]) objArr91[2])[0] = i139 ^ (i139 << 5);
            i4 = 0;
        } else {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr7 = (String[]) objArr5[1];
            if (strArr7 != null) {
                int i140 = getARTIFICIAL_FRAME_PACKAGE_NAME + 113;
                artificialFrame = i140 % 128;
                for (int i141 = i140 % 2 == 0 ? 1 : 0; i141 < strArr7.length; i141++) {
                    arrayList2.add(strArr7[i141]);
                }
            }
            long j9 = ((long) (i129 ^ i130)) ^ (((long) 1890809160) << 32);
            long j10 = 1890809096;
            int i142 = getARTIFICIAL_FRAME_PACKAGE_NAME + 87;
            artificialFrame = i142 % 128;
            int i143 = i142 % 2;
            Object[] objArr92 = {Long.valueOf(j9), Long.valueOf(j10)};
            short s3 = (short) SyslogConstants.LOG_LOCAL7;
            byte[] bArr29 = $$d;
            byte b33 = (byte) (-bArr29[119]);
            Object[] objArr93 = new Object[1];
            c(s3, b33, b33, objArr93);
            Class<?> cls13 = Class.forName((String) objArr93[0]);
            byte b34 = bArr29[96];
            Object[] objArr94 = new Object[1];
            c((short) 545, b34, b34, objArr94);
            cls13.getMethod((String) objArr94[0], Long.TYPE, Long.TYPE).invoke(null, objArr92);
            Object[] objArr95 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i144 = ((int[]) objArr5[2])[0];
            int i145 = ((int[]) objArr5[3])[0];
            int i146 = ((int[]) objArr5[0])[0];
            String[] strArr8 = (String[]) objArr5[1];
            int iIdentityHashCode11 = System.identityHashCode(this);
            int i147 = ~iIdentityHashCode11;
            int i148 = i144 + 1461474936 + ((951942422 | i147) * (-757)) + ((~(1069547518 | iIdentityHashCode11)) * 1514) + (((~(iIdentityHashCode11 | (-117605097))) | (~(i147 | 791592696)) | 277954822) * 757);
            int i149 = (i148 << 13) ^ i148;
            int i150 = i149 ^ (i149 >>> 17);
            i4 = 0;
            ((int[]) objArr95[2])[0] = i150 ^ (i150 << 5);
        }
        Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame30 == null) {
            int iIndexOf6 = TextUtils.indexOf((CharSequence) "", '0') + 26;
            char bitsPerPixel2 = (char) (ImageFormat.getBitsPerPixel(i4) + 30069);
            int minimumFlingVelocity = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 816;
            byte[] bArr30 = $$a;
            byte b35 = bArr30[110];
            Object[] objArr96 = new Object[1];
            b(b35, (byte) (b35 - 1), (byte) (-bArr30[21]), objArr96);
            objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(iIndexOf6, bitsPerPixel2, minimumFlingVelocity, 721586079, false, (String) objArr96[0], null);
        }
        long j11 = ((Field) objAccessartificialFrame30).getLong(null);
        if (j11 == -1 || j11 + 1954 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr97 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -65708946};
            Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame31 == null) {
                int iIndexOf7 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 26;
                char defaultSize = (char) (View.getDefaultSize(0, 0) + 30068);
                int keyRepeatTimeout2 = 816 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                byte[] bArr31 = $$a;
                byte b36 = bArr31[0];
                Object[] objArr98 = new Object[1];
                b(b36, (byte) (b36 | Ascii.CAN), (byte) (bArr31[110] - 1), objArr98);
                objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(iIndexOf7, defaultSize, keyRepeatTimeout2, -797394565, false, (String) objArr98[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr6 = (Object[]) ((Method) objAccessartificialFrame31).invoke(null, objArr97);
            Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame32 == null) {
                int iMyTid2 = (Process.myTid() >> 22) + 25;
                char longPressTimeout = (char) (30068 - (ViewConfiguration.getLongPressTimeout() >> 16));
                int iKeyCodeFromString = 816 - KeyEvent.keyCodeFromString("");
                byte b37 = $$a[110];
                byte b38 = (byte) (b37 - 1);
                Object[] objArr99 = new Object[1];
                b(b37, b38, (byte) (b38 | Ascii.FS), objArr99);
                objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(iMyTid2, longPressTimeout, iKeyCodeFromString, 891606461, false, (String) objArr99[0], null);
            }
            ((Field) objAccessartificialFrame32).set(null, objArr6);
            try {
                Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame33 == null) {
                    int iIndexOf8 = 25 - TextUtils.indexOf("", "", 0, 0);
                    char cIndexOf2 = (char) (30068 - TextUtils.indexOf("", "", 0));
                    int i151 = 817 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                    byte[] bArr32 = $$a;
                    byte b39 = bArr32[110];
                    Object[] objArr100 = new Object[1];
                    b(b39, (byte) (b39 - 1), (byte) (-bArr32[21]), objArr100);
                    objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(iIndexOf8, cIndexOf2, i151, 721586079, false, (String) objArr100[0], null);
                }
                ((Field) objAccessartificialFrame33).set(null, lValueOf7);
            } catch (Exception unused7) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame34 == null) {
                int i152 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 24;
                char keyRepeatTimeout3 = (char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 30068);
                int i153 = 816 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                byte b40 = $$a[110];
                byte b41 = (byte) (b40 - 1);
                Object[] objArr101 = new Object[1];
                b(b40, b41, (byte) (b41 | Ascii.FS), objArr101);
                objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(i152, keyRepeatTimeout3, i153, 891606461, false, (String) objArr101[0], null);
            }
            Object[] objArr102 = (Object[]) ((Field) objAccessartificialFrame34).get(null);
            objArr6 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i154 = ((int[]) objArr102[0])[0];
            int i155 = ((int[]) objArr102[1])[0];
            String[] strArr9 = (String[]) objArr102[2];
            int iIdentityHashCode12 = System.identityHashCode(this);
            int i156 = ~iIdentityHashCode12;
            int i157 = ~((-649263578) | i156);
            int i158 = ~(451091211 | iIdentityHashCode12);
            int i159 = ((((-2081787814) + ((i157 | i158) * 1150)) + (((~((-451091212) | i156)) | i158) * (-575))) + (((~(iIdentityHashCode12 | (-649263578))) | (~(i156 | 649263577))) * 575)) - 65708946;
            int i160 = (i159 << 13) ^ i159;
            int i161 = i160 ^ (i160 >>> 17);
            ((int[]) objArr6[3])[0] = i161 ^ (i161 << 5);
        }
        int i162 = ((int[]) objArr6[1])[0];
        int i163 = ((int[]) objArr6[0])[0];
        if (i163 == i162) {
            Object[] objArr103 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i164 = ((int[]) objArr6[3])[0];
            int i165 = ((int[]) objArr6[0])[0];
            int i166 = ((int[]) objArr6[1])[0];
            String[] strArr10 = (String[]) objArr6[2];
            int iIdentityHashCode13 = System.identityHashCode(this);
            int i167 = ~(296712526 | iIdentityHashCode13);
            int i168 = i164 + 2036172210 + (((-369097679) | i167) * (-814)) + ((i167 | (~((~iIdentityHashCode13) | 98540160)) | 26155008) * 407) + (((~(iIdentityHashCode13 | (-98540161))) | (~((-296712527) | iIdentityHashCode13)) | 26155008) * 407);
            int i169 = (i168 << 13) ^ i168;
            int i170 = i169 ^ (i169 >>> 17);
            ((int[]) objArr103[3])[0] = i170 ^ (i170 << 5);
        } else {
            ArrayList arrayList3 = new ArrayList();
            String[] strArr11 = (String[]) objArr6[2];
            if (strArr11 != null) {
                for (String str7 : strArr11) {
                    arrayList3.add(str7);
                }
            }
            Object[] objArr104 = {Long.valueOf(((long) (i162 ^ i163)) ^ (((long) (-1884534014)) << 32)), Long.valueOf(-1884534013)};
            byte[] bArr33 = $$d;
            Object[] objArr105 = new Object[1];
            c((short) (-bArr33[3]), (byte) (-bArr33[119]), bArr33[7], objArr105);
            Class<?> cls14 = Class.forName((String) objArr105[0]);
            byte b42 = bArr33[96];
            Object[] objArr106 = new Object[1];
            c((short) 545, b42, b42, objArr106);
            cls14.getMethod((String) objArr106[0], Long.TYPE, Long.TYPE).invoke(null, objArr104);
            Object[] objArr107 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i171 = ((int[]) objArr6[3])[0];
            int i172 = ((int[]) objArr6[0])[0];
            int i173 = ((int[]) objArr6[1])[0];
            String[] strArr12 = (String[]) objArr6[2];
            int iFreeMemory2 = (int) Runtime.getRuntime().freeMemory();
            int i174 = 2017092651 + (((~((-709724512) | iFreeMemory2)) | 511552145) * (-318));
            int i175 = ~(511552145 | iFreeMemory2);
            int i176 = ~iFreeMemory2;
            int i177 = i171 + i174 + ((i175 | (~((-338698881) | i176))) * TypedValues.AttributesType.TYPE_PIVOT_TARGET) + (((~(iFreeMemory2 | (-338698881))) | (~(1048423391 | i176))) * TypedValues.AttributesType.TYPE_PIVOT_TARGET);
            int i178 = (i177 << 13) ^ i177;
            int i179 = i178 ^ (i178 >>> 17);
            ((int[]) objArr107[3])[0] = i179 ^ (i179 << 5);
        }
        boolean zOnCreate = super.onCreate();
        Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame35 == null) {
            int iKeyCodeFromString2 = 17 - KeyEvent.keyCodeFromString("");
            char keyRepeatTimeout4 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
            int offsetBefore = TextUtils.getOffsetBefore("", 0) + 747;
            byte[] bArr34 = $$a;
            byte b43 = bArr34[110];
            Object[] objArr108 = new Object[1];
            b(b43, (byte) (b43 - 1), (byte) (-bArr34[21]), objArr108);
            objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString2, keyRepeatTimeout4, offsetBefore, -144068856, false, (String) objArr108[0], null);
        }
        long j12 = ((Field) objAccessartificialFrame35).getLong(null);
        try {
            if (j12 != -1) {
                i5 = 0;
                if (j12 + 1965 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(1575402270);
                    if (objAccessartificialFrame36 == null) {
                        int iIndexOf9 = 17 - TextUtils.indexOf("", "", 0);
                        char longPressTimeout2 = (char) (ViewConfiguration.getLongPressTimeout() >> 16);
                        int iGreen = Color.green(0) + 747;
                        byte b44 = $$a[110];
                        byte b45 = (byte) (b44 - 1);
                        Object[] objArr109 = new Object[1];
                        b(b44, b45, (byte) (b45 | Ascii.FS), objArr109);
                        objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(iIndexOf9, longPressTimeout2, iGreen, -1031537386, false, (String) objArr109[0], null);
                    }
                    Object[] objArr110 = (Object[]) ((Field) objAccessartificialFrame36).get(null);
                    objArr8 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
                    int i180 = ((int[]) objArr110[3])[0];
                    int i181 = ((int[]) objArr110[4])[0];
                    List list = (List) objArr110[0];
                    List list2 = (List) objArr110[2];
                    int iIdentityHashCode14 = System.identityHashCode(this);
                    int i182 = (-2106216108) + (((~((-612925453) | iIdentityHashCode14)) | (~((-7476995) | iIdentityHashCode14))) * 69) + (((~(iIdentityHashCode14 | (-175593251))) | (~((-781041709) | iIdentityHashCode14)) | 168116256) * (-69)) + 297097633;
                    int i183 = (i182 << 13) ^ i182;
                    int i184 = i183 ^ (i183 >>> 17);
                    ((int[]) objArr8[1])[0] = i184 ^ (i184 << 5);
                }
                i6 = ((int[]) objArr8[4])[0];
                i7 = ((int[]) objArr8[3])[0];
                if (i7 == i6) {
                    Object[] objArr111 = {list, new int[1], list, new int[]{i}, new int[]{i}};
                    int i185 = ((int[]) objArr8[1])[0];
                    int i186 = ((int[]) objArr8[3])[0];
                    int i187 = ((int[]) objArr8[4])[0];
                    List list3 = (List) objArr8[0];
                    List list4 = (List) objArr8[2];
                    int iIdentityHashCode15 = System.identityHashCode(this);
                    int i188 = ~((-4878627) | iIdentityHashCode15);
                    int i189 = ~iIdentityHashCode15;
                    int i190 = i185 + 1938616497 + ((i188 | (~((-25198721) | i189))) * 920) + (((~((-575371112) | i189)) | 4878626) * 920) + (((~(iIdentityHashCode15 | (-25198721))) | (~((-4878627) | i189)) | (~((-570492486) | iIdentityHashCode15))) * 920);
                    int i191 = (i190 << 13) ^ i190;
                    int i192 = i191 ^ (i191 >>> 17);
                    ((int[]) objArr111[1])[0] = i192 ^ (i192 << 5);
                } else {
                    ArrayList arrayList4 = new ArrayList();
                    Object[] objArr112 = {objArr8};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1804664566);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 40, (char) ((Process.myTid() >> 22) + 12468), 3642 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                    }
                    arrayList4.add(((Method) objAccessartificialFrame).invoke(null, objArr112));
                    Object[] objArr113 = {objArr8};
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                    if (objAccessartificialFrame2 == null) {
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(Process.getGidForName("") + 42, (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 12468), 3642 - (Process.myPid() >> 22), 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                    }
                    arrayList4.add(((Method) objAccessartificialFrame2).invoke(null, objArr113));
                    long j13 = ((long) (i6 ^ i7)) ^ (((long) (-220878757)) << 32);
                    long j14 = -220878765;
                    int i193 = getARTIFICIAL_FRAME_PACKAGE_NAME + 31;
                    artificialFrame = i193 % 128;
                    int i194 = i193 % 2;
                    Object[] objArr114 = {Long.valueOf(j13), Long.valueOf(j14)};
                    byte[] bArr35 = $$d;
                    Object[] objArr115 = new Object[1];
                    c(bArr35[96], (byte) (-bArr35[119]), (byte) ($$e & TypedValues.PositionType.TYPE_DRAWPATH), objArr115);
                    Class<?> cls15 = Class.forName((String) objArr115[0]);
                    byte b46 = bArr35[96];
                    Object[] objArr116 = new Object[1];
                    c((short) 545, b46, b46, objArr116);
                    cls15.getMethod((String) objArr116[0], Long.TYPE, Long.TYPE).invoke(null, objArr114);
                    Object[] objArr117 = {list, new int[1], list, new int[]{i}, new int[]{i}};
                    int i195 = ((int[]) objArr8[1])[0];
                    int i196 = ((int[]) objArr8[3])[0];
                    int i197 = ((int[]) objArr8[4])[0];
                    List list5 = (List) objArr8[0];
                    List list6 = (List) objArr8[2];
                    int iIdentityHashCode16 = System.identityHashCode(this);
                    int i198 = ~iIdentityHashCode16;
                    int i199 = i195 + (-719475204) + (((~((-173662068) | i198)) | 431786390) * (-602)) + (((~(iIdentityHashCode16 | (-173662068))) | 135825682 | (~(469622775 | i198))) * (-301)) + ((~(i198 | 431786390)) * 301);
                    int i200 = (i199 << 13) ^ i199;
                    int i201 = i200 ^ (i200 >>> 17);
                    ((int[]) objArr117[1])[0] = i201 ^ (i201 << 5);
                }
                return zOnCreate;
            }
            i5 = 0;
            Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(1745676544);
            if (objAccessartificialFrame37 == null) {
                int scrollBarFadeDuration2 = 17 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                char cNormalizeMetaState2 = (char) KeyEvent.normalizeMetaState(0);
                int i202 = 747 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                byte[] bArr36 = $$a;
                byte b47 = bArr36[110];
                byte b48 = (byte) (-bArr36[21]);
                Object[] objArr118 = new Object[1];
                b(b47, (byte) (b47 - 1), b48, objArr118);
                objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration2, cNormalizeMetaState2, i202, -144068856, false, (String) objArr118[0], null);
            }
            ((Field) objAccessartificialFrame37).set(null, lValueOf8);
            objArr8 = objArr7;
            i6 = ((int[]) objArr8[4])[0];
            i7 = ((int[]) objArr8[3])[0];
            if (i7 == i6) {
                Object[] objArr119 = {list3, new int[1], list4, new int[]{i186}, new int[]{i187}};
                int i1810 = ((int[]) objArr8[1])[0];
                int i1811 = ((int[]) objArr8[3])[0];
                int i1812 = ((int[]) objArr8[4])[0];
                List list7 = (List) objArr8[0];
                List list8 = (List) objArr8[2];
                int iIdentityHashCode17 = System.identityHashCode(this);
                int i1813 = ~((-4878627) | iIdentityHashCode17);
                int i1814 = ~iIdentityHashCode17;
                int i1910 = i1810 + 1938616497 + ((i1813 | (~((-25198721) | i1814))) * 920) + (((~((-575371112) | i1814)) | 4878626) * 920) + (((~(iIdentityHashCode17 | (-25198721))) | (~((-4878627) | i1814)) | (~((-570492486) | iIdentityHashCode17))) * 920);
                int i1911 = (i1910 << 13) ^ i1910;
                int i1912 = i1911 ^ (i1911 >>> 17);
                ((int[]) objArr119[1])[0] = i1912 ^ (i1912 << 5);
            } else {
                ArrayList arrayList5 = new ArrayList();
                Object[] objArr1110 = {objArr8};
                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1804664566);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 40, (char) ((Process.myTid() >> 22) + 12468), 3642 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                }
                arrayList5.add(((Method) objAccessartificialFrame).invoke(null, objArr1110));
                Object[] objArr1111 = {objArr8};
                objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                if (objAccessartificialFrame2 == null) {
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(Process.getGidForName("") + 42, (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 12468), 3642 - (Process.myPid() >> 22), 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                }
                arrayList5.add(((Method) objAccessartificialFrame2).invoke(null, objArr1111));
                long j15 = ((long) (i6 ^ i7)) ^ (((long) (-220878757)) << 32);
                long j16 = -220878765;
                int i1913 = getARTIFICIAL_FRAME_PACKAGE_NAME + 31;
                artificialFrame = i1913 % 128;
                int i1914 = i1913 % 2;
                Object[] objArr1112 = {Long.valueOf(j15), Long.valueOf(j16)};
                byte[] bArr37 = $$d;
                Object[] objArr1113 = new Object[1];
                c(bArr37[96], (byte) (-bArr37[119]), (byte) ($$e & TypedValues.PositionType.TYPE_DRAWPATH), objArr1113);
                Class<?> cls16 = Class.forName((String) objArr1113[0]);
                byte b49 = bArr37[96];
                Object[] objArr1114 = new Object[1];
                c((short) 545, b49, b49, objArr1114);
                cls16.getMethod((String) objArr1114[0], Long.TYPE, Long.TYPE).invoke(null, objArr1112);
                Object[] objArr1115 = {list5, new int[1], list6, new int[]{i196}, new int[]{i197}};
                int i1915 = ((int[]) objArr8[1])[0];
                int i1916 = ((int[]) objArr8[3])[0];
                int i1917 = ((int[]) objArr8[4])[0];
                List list9 = (List) objArr8[0];
                List list10 = (List) objArr8[2];
                int iIdentityHashCode18 = System.identityHashCode(this);
                int i1918 = ~iIdentityHashCode18;
                int i1919 = i1915 + (-719475204) + (((~((-173662068) | i1918)) | 431786390) * (-602)) + (((~(iIdentityHashCode18 | (-173662068))) | 135825682 | (~(469622775 | i1918))) * (-301)) + ((~(i1918 | 431786390)) * 301);
                int i203 = (i1919 << 13) ^ i1919;
                int i204 = i203 ^ (i203 >>> 17);
                ((int[]) objArr1115[1])[0] = i204 ^ (i204 << 5);
            }
            return zOnCreate;
        } catch (Exception unused8) {
            throw new RuntimeException();
        }
        Object[] objArr120 = new Object[1];
        a(View.MeasureSpec.getMode(i5), new char[]{39568, 39665, 64111, 64791, 62449, 64953, 43081, 48505, 34471, 56848, 55129, 39421, 41537, 49825, 47893, 58773, 53209, 41322, 40697, 49770, 60294, 34056, 33345, 11922, 6012, 27057, 26159, 2774, 12513, 19541}, objArr120);
        Class<?> cls17 = Class.forName((String) objArr120[i5]);
        Object[] objArr121 = new Object[1];
        a((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1, new char[]{24205, 24302, 35211, 36584, 17237, 19723, 32948, 38276, 17072, 44520, 26619, 45423, 26189, 45406, 3003, 52527, 3046, 53911, 11851, 60055, 12162, 63216}, objArr121);
        Method method2 = cls17.getMethod((String) objArr121[i5], new Class[i5]);
        Context applicationContext4 = (Context) method2.invoke(null, null);
        if (applicationContext4 != null) {
            applicationContext4 = ((applicationContext4 instanceof ContextWrapper) && ((ContextWrapper) applicationContext4).getBaseContext() == null) ? null : applicationContext4.getApplicationContext();
        }
        int iIntValue4 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
        int i205 = artificialFrame + 5;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i205 % 128;
        int i206 = i205 % 2;
        Object[] objArr122 = {applicationContext4, Integer.valueOf(iIntValue4), 0, -1129686708};
        byte[] bArr38 = $$d;
        Object[] objArr123 = new Object[1];
        c((short) (bArr38[135] - 1), (byte) (-bArr38[119]), (byte) (-bArr38[433]), objArr123);
        Class<?> cls18 = Class.forName((String) objArr123[0]);
        Object[] objArr124 = new Object[1];
        c((short) 630, bArr38[577], bArr38[4], objArr124);
        objArr7 = (Object[]) cls18.getMethod((String) objArr124[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr122);
        Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(1575402270);
        if (objAccessartificialFrame38 == null) {
            int threadPriority = ((Process.getThreadPriority(0) + 20) >> 6) + 17;
            char cResolveSize = (char) View.resolveSize(0, 0);
            int iIndexOf10 = 746 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
            byte b50 = $$a[110];
            byte b51 = (byte) (b50 - 1);
            Object[] objArr125 = new Object[1];
            b(b50, b51, (byte) (b51 | Ascii.FS), objArr125);
            objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(threadPriority, cResolveSize, iIndexOf10, -1031537386, false, (String) objArr125[0], null);
        }
        ((Field) objAccessartificialFrame38).set(null, objArr7);
    }

    static {
        byte[] bArr = new byte[775];
        System.arraycopy("jã\u009b\u0089\u0011\u0003Æ>\r\u0005ý\nþÎ:\u0011\u0003\u0005\u0007\u0004ÅL\u0004ú\bÇ:\u0011\u0004ú\u0017\u0002\u0005ø\u000e\u000b¿*\u0017\u0012\tøÿ\u0007í\u0019\u0012ø\u000b\u0003\u0012·4\u0017\u0012\tøÿ\u0007í\u0019\u0012ø\u000b\u0003\u0012æ&ò\u0018öÄ\u00131\b\u0002\u000b\u0004ú\nüä&\u0002\u0018÷\u0005\u0007\nþé.\u0011\u0003Æ=\u0000\u0007\u0007\u0002\u0012\u0005\u0001ÈIø\u0001\u0007\u0016¿Lù\tù\u0012ø\u000b\u0003\u0012Á0\u001býÿò&ú\u0006ð$\u0005\u0002½\u0005&8\u0001ö\u0012\u0001ø\u0010ì+ú\u000bù\u0002\u0014úÿî\u001a\u0011ú\u0007\u0002Ô\u0005B\u0011\u0003Æ=\u0000\u0007\u0007\u0002\u0012\u0005\u0001È;\u0013ô\u001bó\u0005Î9\u0004\u0007\rÿ\u000eû\u0014ÀGþ\fú\f\u0002\nüÎ'\u001e\fú\f\u0002\nüä3ô\u001bó\u0005ã1\u0004\u000b\u0003\u0002\u0002\u0005þ\u0012Õ8ù\bý\u0006\u0012æ'\u0000\u0005\u0001\u0002\u0001\u0012\u0011\b\u0002\u000b\u0004ú\nüã4ø\u0001\u0018ú\u000b\u0004\u0011\u0003Æ>\r\u0005ý\nþÎ8\u0014þÊ()ÿ\nòô'\u0002\n\u0000\u0011\u0003Æ=\u0000\u0007\u0007\u0002\u0012\u0005\u0001È@\tù\u000b\u0003\u0010þ\fú\f\u0002\nüÎG\u0007\u0002ú\u0016ó\u0007\u0012\u0006À'$\t\u0006\u0001\u0007\u0002ù\u0007\u0013\u0005÷\u0004ã,\u0010þù\u0014â\u001d\r\u0007\b\fÏ#\u0007\n\u0002ð'\u0002ú\u0016ó\u0007\u0012·$#\u0007\n\u0002\u0004ñ$\t\u0006\u0001\u0007\u0002ù\u0007\u0013\u0005\u0001\bÖ1\u0004\n\u0007ýý\u0012\u0007\u0005\u0007\u0013\u0005ó\u0016\u0007ú\u0002\bÿ\u000bý\u0010ß1ô\u0011ý\u0011\u0003Æ=\u0000\u0007\u0007\u0002\u0012\u0005\u0001È8\u0014\u0005\u0001\u0002\n\u0002\rÀ\u00184\u0005á\"\n\u0002Þ\"\u0018òÈ\u0012\nËH\u0003\tÀC\bý\u0000\u0004\u0007\rÈ:\u0011\bøÎJ\u0002þÊ\u001a;ï\u000e\u0002ÿä8ö\u0005\u0004\u0012ç#ô\u0007\rÿ\u0012\u0011\u0003Æ9\b\u0001ÒOú\u0004ÇJ\u0006\u0003ø\u0001\u0011Æ<\u0016ô\u000e\u000b\u0004À\u001c.\u000bú\u0010\nÞ\u0018\u0006\u0004\u0012ø\u000eú\u0007å6ô\u000e\u000b\u0011\u0003Æ>\r\u0005ý\nþÎ:\u0011\u0003\u0005\u0007\u0004Å:\u0011\u0002\u0005þ\u0003\u0016¿$\u0019\u0014â\u0019\u000fÿ\u0012Ü*\u000bö\u0012\u0001ø\u0010æ\u0019\u0014¹\"&\u0016\u0006\u0003ô\u0007\u0016è\u0013\u0001\u000få\u001f\u0019Ñ.\u000b\u0003\f\u0011\u0003Æ=\u0000\u0007\u0007\u0002\u0012\u0005\u0001È@\tù\u000b\u0003\u0010þ\fú\f\u0002\nüÎ:\u0011\bøÎ''\u0002ú\u0016ó\u0007\u0012æ\u0017\u0011\tõ\u000eú\u0007æ \u0007\u0016\u0000\b\f°$1\u0003\bö\u0012\u0000\u000b\u0004\u0011\u0003Æ>\r\u0005ý\nþÎ8\u0012û\u0013\u0002ÿ\u0000Ï;\u0002\u0018ò\u0018\u0003ô\u0012\n\u0002\u0004\b\u0007¿:\u0005\u0016¿@\n\u000bö\u0012\u0001ø\u0010Ç\u001a.\u0002\u0001\u000e\u000bÚ*ý\u000e\u0011\u0003Æ>\r\u0005ý\nþÎ=\b\u000eø\u0002\u0004\u0017÷Î:\u0011\u0003\b\u0004\u0004ü\u000e\u000b\u0004À&&\tú\u000b\u0004ø\u0010é'\u0002\fø\u0000\u0006\u0012·\u0005&8\u0001ö\u0012\u0001ø\u0010ì+ú\u000bù\u0002\u0014úÿî\u001a\u0011ú\u0007\u0002Ö".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 775);
        $$d = bArr;
        $$e = 79;
        $$a = new byte[]{4, -122, -75, -94, -9, Ascii.DC2, -34, Ascii.EM, 4, -17, 19, -15, -1, -18, Ascii.SI, 19, -11, 5, -7, -2, Ascii.SI, -36, Ascii.NAK, Ascii.CR, -15, 2, 9, 6, -34, Ascii.SI, 19, -11, 5, -7, -2, Ascii.SI, -33, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, 10, -31, Ascii.DC4, Ascii.CR, -8, -11, -13, Ascii.ESC, -9, Ascii.DC2, -36, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, -7, Ascii.DC2, -43, Ascii.GS, -4, 17, 2, 5, -1, -33, 33, -2, -9, 5, -7, 5, -1, -50, 39, Ascii.VT, -7, -12, Ascii.SI, 49, 2, -11, -3, 3, -6, 6, -8, Ascii.VT, -25, 33, -19, 2, 8, -37, 44, -17, Ascii.FF, -8, Ascii.SO, Ascii.ESC, 1, -7, -6, -33, 51, -12, 3, -8, 1, Ascii.CR};
        $$b = 85;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        onPostMessage = 6304359093087392854L;
    }
}
