package it.aep_italia.vts.sdk.internal;

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
import android.text.AndroidCharacter;
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
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.net.SyslogConstants;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.Typography;
import o.ArtificialStackFrames;
import o.extraCallback;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes6.dex */
public class SdkFileProvider extends FileProvider {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    private static char[] ArtificialStackFrames;
    private static int artificialFrame;
    private static char coroutineCreation;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static final byte[] $$c = {98, -94, 86, -118};
    private static final int $$f = 213;
    private static int $10 = 0;
    private static int $11 = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0027). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(byte r7, short r8, byte r9) {
        /*
            byte[] r0 = it.aep_italia.vts.sdk.internal.SdkFileProvider.$$c
            int r8 = 105 - r8
            int r9 = r9 * 4
            int r9 = r9 + 4
            int r7 = r7 * 3
            int r7 = r7 + 1
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r9
            r5 = r2
            goto L27
        L14:
            r3 = r2
        L15:
            byte r4 = (byte) r8
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r7) goto L22
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            return r7
        L22:
            r3 = r0[r9]
            r6 = r3
            r3 = r9
            r9 = r6
        L27:
            int r8 = r8 + r9
            int r9 = r3 + 1
            r3 = r5
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: it.aep_italia.vts.sdk.internal.SdkFileProvider.$$g(byte, short, byte):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0027). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(byte r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 + 65
            byte[] r0 = it.aep_italia.vts.sdk.internal.SdkFileProvider.$$a
            int r7 = r7 + 8
            int r9 = 112 - r9
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L10
            r3 = r9
            r4 = r2
            goto L27
        L10:
            r3 = r2
        L11:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            int r9 = r9 + 1
            r1[r3] = r5
            if (r4 != r7) goto L22
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L22:
            r3 = r0[r9]
            r6 = r3
            r3 = r9
            r9 = r6
        L27:
            int r9 = -r9
            int r8 = r8 + r9
            r9 = r3
            r3 = r4
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: it.aep_italia.vts.sdk.internal.SdkFileProvider.b(byte, byte, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void c(int r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = it.aep_italia.vts.sdk.internal.SdkFileProvider.$$d
            int r8 = r8 + 36
            int r1 = r7 + 3
            int r6 = r6 + 4
            byte[] r1 = new byte[r1]
            int r7 = r7 + 2
            r2 = -1
            if (r0 != 0) goto L13
            r8 = r6
            r3 = r7
            r4 = r2
            goto L2b
        L13:
            r3 = r2
        L14:
            int r3 = r3 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L24
            java.lang.String r6 = new java.lang.String
            r7 = 0
            r6.<init>(r1, r7)
            r9[r7] = r6
            return
        L24:
            r4 = r0[r6]
            r5 = r8
            r8 = r6
            r6 = r4
            r4 = r3
            r3 = r5
        L2b:
            int r6 = -r6
            int r3 = r3 + r6
            int r6 = r3 + (-1)
            int r8 = r8 + 1
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: it.aep_italia.vts.sdk.internal.SdkFileProvider.c(int, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0120  */
    /* JADX WARN: Code duplicated, block: B:35:0x0136  */
    /* JADX WARN: Code duplicated, block: B:38:0x0182 A[Catch: all -> 0x0342, TryCatch #0 {all -> 0x0342, blocks: (B:7:0x0027, B:9:0x0035, B:10:0x0069, B:14:0x0080, B:17:0x0090, B:18:0x00be, B:36:0x0138, B:38:0x0182, B:39:0x01f4, B:43:0x0213, B:45:0x024e, B:46:0x02b1), top: B:63:0x0027 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0207  */
    /* JADX WARN: Code duplicated, block: B:45:0x024e A[Catch: all -> 0x0342, TryCatch #0 {all -> 0x0342, blocks: (B:7:0x0027, B:9:0x0035, B:10:0x0069, B:14:0x0080, B:17:0x0090, B:18:0x00be, B:36:0x0138, B:38:0x0182, B:39:0x01f4, B:43:0x0213, B:45:0x024e, B:46:0x02b1), top: B:63:0x0027 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:50:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:51:0x030b  */
    private static void a(int i, char[] cArr, byte b, Object[] objArr) throws Throwable {
        int i2;
        Object obj;
        Object[] objArr2;
        Object objAccessartificialFrame;
        Object objAccessartificialFrame2;
        int i3 = 2;
        int i4 = 2 % 2;
        extraCallback extracallback = new extraCallback();
        char[] cArr2 = ArtificialStackFrames;
        long j = 0;
        Object obj2 = null;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i5 = 0;
            while (i5 < length) {
                int i6 = $10 + 59;
                $11 = i6 % 128;
                int i7 = i6 % i3;
                try {
                    Object[] objArr3 = {Integer.valueOf(cArr2[i5])};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1819279892);
                    if (objAccessartificialFrame3 == null) {
                        byte b2 = (byte) 0;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(15 - (ExpandableListView.getPackedPositionForGroup(0) > j ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == j ? 0 : -1)), (char) (View.getDefaultSize(0, 0) + 20488), 2148 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 216710116, false, $$g(b2, (byte) (b2 | 8), b2), new Class[]{Integer.TYPE});
                    }
                    cArr3[i5] = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr3)).charValue();
                    i5++;
                    i3 = 2;
                    j = 0;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            cArr2 = cArr3;
        }
        Object[] objArr4 = {Integer.valueOf(coroutineCreation)};
        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1819279892);
        if (objAccessartificialFrame4 == null) {
            byte b3 = (byte) 0;
            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(Process.getGidForName("") + 16, (char) (KeyEvent.keyCodeFromString("") + 20488), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 2148, 216710116, false, $$g(b3, (byte) (b3 | 8), b3), new Class[]{Integer.TYPE});
        }
        char cCharValue = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr4)).charValue();
        char[] cArr4 = new char[i];
        if (i % 2 != 0) {
            i2 = i - 1;
            cArr4[i2] = (char) (cArr[i2] - b);
        } else {
            i2 = i;
        }
        if (i2 > 1) {
            int i8 = $11 + 101;
            $10 = i8 % 128;
            int i9 = i8 % 2;
            extracallback.a = 0;
            while (extracallback.a < i2) {
                int i10 = $10 + 25;
                $11 = i10 % 128;
                if (i10 % 2 == 0) {
                    extracallback.createBrowser = cArr[extracallback.a];
                    extracallback.c = cArr[extracallback.a / 0];
                    if (extracallback.createBrowser == extracallback.c) {
                        cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                        cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                        obj = obj2;
                    } else {
                        objArr2 = new Object[]{extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                        objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1894223152);
                        if (objAccessartificialFrame == null) {
                            byte b4 = (byte) 0;
                            byte b5 = (byte) (b4 + 3);
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(46 - View.getDefaultSize(0, 0), (char) (TextUtils.indexOf("", "", 0) + 58859), 2464 - ExpandableListView.getPackedPositionGroup(0L), 276640984, false, $$g(b4, b5, (byte) (b5 - 3)), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                        }
                        if (((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue() == extracallback.g) {
                            int i11 = $10 + 15;
                            $11 = i11 % 128;
                            int i12 = i11 % 2;
                            Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1361113423);
                            if (objAccessartificialFrame2 == null) {
                                byte b6 = (byte) 0;
                                byte b7 = b6;
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 23, (char) View.getDefaultSize(0, 0), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 791, -834291897, false, $$g(b6, b7, b7), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                            }
                            obj = null;
                            int iIntValue = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr5)).intValue();
                            int i13 = (extracallback.d * cCharValue) + extracallback.g;
                            cArr4[extracallback.a] = cArr2[iIntValue];
                            cArr4[extracallback.a + 1] = cArr2[i13];
                        } else {
                            obj = null;
                            if (extracallback.b == extracallback.d) {
                                int i14 = $11 + 105;
                                $10 = i14 % 128;
                                int i15 = i14 % 2;
                                extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                                extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                                int i16 = (extracallback.b * cCharValue) + extracallback.j;
                                int i17 = (extracallback.d * cCharValue) + extracallback.g;
                                cArr4[extracallback.a] = cArr2[i16];
                                cArr4[extracallback.a + 1] = cArr2[i17];
                            } else {
                                int i18 = (extracallback.b * cCharValue) + extracallback.g;
                                int i19 = (extracallback.d * cCharValue) + extracallback.j;
                                cArr4[extracallback.a] = cArr2[i18];
                                cArr4[extracallback.a + 1] = cArr2[i19];
                            }
                        }
                    }
                } else {
                    extracallback.createBrowser = cArr[extracallback.a];
                    extracallback.c = cArr[extracallback.a + 1];
                    if (extracallback.createBrowser == extracallback.c) {
                        cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                        cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                        obj = obj2;
                    } else {
                        objArr2 = new Object[]{extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                        objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1894223152);
                        if (objAccessartificialFrame == null) {
                            byte b8 = (byte) 0;
                            byte b9 = (byte) (b8 + 3);
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(46 - View.getDefaultSize(0, 0), (char) (TextUtils.indexOf("", "", 0) + 58859), 2464 - ExpandableListView.getPackedPositionGroup(0L), 276640984, false, $$g(b8, b9, (byte) (b9 - 3)), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                        }
                        if (((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue() == extracallback.g) {
                            int i110 = $10 + 15;
                            $11 = i110 % 128;
                            int i111 = i110 % 2;
                            Object[] objArr6 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1361113423);
                            if (objAccessartificialFrame2 == null) {
                                byte b10 = (byte) 0;
                                byte b11 = b10;
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 23, (char) View.getDefaultSize(0, 0), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 791, -834291897, false, $$g(b10, b11, b11), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                            }
                            obj = null;
                            int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr6)).intValue();
                            int i112 = (extracallback.d * cCharValue) + extracallback.g;
                            cArr4[extracallback.a] = cArr2[iIntValue2];
                            cArr4[extracallback.a + 1] = cArr2[i112];
                        } else {
                            obj = null;
                            if (extracallback.b == extracallback.d) {
                                int i113 = $11 + 105;
                                $10 = i113 % 128;
                                int i114 = i113 % 2;
                                extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                                extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                                int i115 = (extracallback.b * cCharValue) + extracallback.j;
                                int i116 = (extracallback.d * cCharValue) + extracallback.g;
                                cArr4[extracallback.a] = cArr2[i115];
                                cArr4[extracallback.a + 1] = cArr2[i116];
                            } else {
                                int i117 = (extracallback.b * cCharValue) + extracallback.g;
                                int i118 = (extracallback.d * cCharValue) + extracallback.j;
                                cArr4[extracallback.a] = cArr2[i117];
                                cArr4[extracallback.a + 1] = cArr2[i118];
                            }
                        }
                    }
                }
                extracallback.a += 2;
                obj2 = obj;
            }
        }
        for (int i20 = 0; i20 < i; i20++) {
            cArr4[i20] = (char) (cArr4[i20] ^ 13722);
        }
        objArr[0] = new String(cArr4);
    }

    /* JADX WARN: Code duplicated, block: B:117:0x0d7e  */
    /* JADX WARN: Code duplicated, block: B:119:0x0dd3  */
    /* JADX WARN: Code duplicated, block: B:125:0x0de3  */
    /* JADX WARN: Code duplicated, block: B:130:0x0ecf  */
    /* JADX WARN: Code duplicated, block: B:132:0x0ed8  */
    /* JADX WARN: Code duplicated, block: B:137:0x0f3a  */
    /* JADX WARN: Code duplicated, block: B:214:0x1659  */
    /* JADX WARN: Code duplicated, block: B:217:0x1663  */
    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public boolean onCreate() throws Throwable {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Context applicationContext;
        Object[] objArr4;
        Object objAccessartificialFrame;
        Object objAccessartificialFrame2;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object[] objArr5;
        Object[] objArr6;
        Object[] objArr7;
        int i = 2 % 2;
        Object[] objArr8 = new Object[1];
        a(22 - View.MeasureSpec.getSize(0), new char[]{'*', '\b', 24, 19, ' ', CoreConstants.DASH_CHAR, 27, 24, '\"', Typography.amp, 27, CoreConstants.COMMA_CHAR, 20, '0', 2, CoreConstants.PERCENT_CHAR, '+', 28, 17, '\"', 15, '\f'}, (byte) (14 - View.MeasureSpec.getMode(0)), objArr8);
        String str = (String) objArr8[0];
        Object[] objArr9 = new Object[1];
        a(TextUtils.lastIndexOf("", '0') + 16, new char[]{'\"', 16, '0', 29, CoreConstants.PERCENT_CHAR, '\"', 24, '/', 29, CoreConstants.COMMA_CHAR, 16, '0', '/', '+', 13909}, (byte) (85 - MotionEvent.axisFromString("")), objArr9);
        String str2 = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        a(17 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), new char[]{1, CoreConstants.DASH_CHAR, '$', '/', 27, 16, '*', '\b', '\t', 25, 6, 20, CoreConstants.PERCENT_CHAR, '0', 28, CoreConstants.COMMA_CHAR}, (byte) (24 - (ViewConfiguration.getTouchSlop() >> 8)), objArr10);
        String str3 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        a(View.resolveSize(0, 0) + 16, new char[]{'/', 25, 28, '\t', CoreConstants.DASH_CHAR, '/', '0', '\t', 29, '/', '#', CoreConstants.SINGLE_QUOTE_CHAR, 30, ' ', 23, '!'}, (byte) (ImageFormat.getBitsPerPixel(0) + SyslogConstants.LOG_CLOCK), objArr11);
        String str4 = (String) objArr11[0];
        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame3 == null) {
            int size = View.MeasureSpec.getSize(0) + 30;
            char cMyPid = (char) ((Process.myPid() >> 22) + 49362);
            int defaultSize = 684 - View.getDefaultSize(0, 0);
            byte[] bArr = $$a;
            Object[] objArr12 = new Object[1];
            b((byte) (-bArr[14]), (byte) (bArr[54] + 1), (byte) ($$b - 4), objArr12);
            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(size, cMyPid, defaultSize, -1583976536, false, (String) objArr12[0], null);
        }
        long j = ((Field) objAccessartificialFrame3).getLong(null);
        if (j == -1 || j + 1988 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            try {
                Object[] objArr13 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -383384421};
                byte[] bArr2 = $$d;
                Object[] objArr14 = new Object[1];
                c(bArr2[31], bArr2[229], bArr2[430], objArr14);
                Class<?> cls = Class.forName((String) objArr14[0]);
                Object[] objArr15 = new Object[1];
                c(bArr2[594], bArr2[40], bArr2[430], objArr15);
                objArr = (Object[]) cls.getMethod((String) objArr15[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr13);
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame4 == null) {
                    int gidForName = Process.getGidForName("") + 31;
                    char minimumFlingVelocity = (char) (49362 - (ViewConfiguration.getMinimumFlingVelocity() >> 16));
                    int i2 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 683;
                    Object[] objArr16 = new Object[1];
                    b($$a[25], (byte) 40, (byte) ($$b & 495), objArr16);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(gidForName, minimumFlingVelocity, i2, -1456483158, false, (String) objArr16[0], null);
                }
                ((Field) objAccessartificialFrame4).set(null, objArr);
                try {
                    Long lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1056123296);
                    if (objAccessartificialFrame5 == null) {
                        int iIndexOf = TextUtils.indexOf((CharSequence) "", '0') + 31;
                        char cIndexOf = (char) (49362 - TextUtils.indexOf("", "", 0));
                        int iGreen = 684 - Color.green(0);
                        byte[] bArr3 = $$a;
                        Object[] objArr17 = new Object[1];
                        b((byte) (-bArr3[14]), (byte) (bArr3[54] + 1), (byte) ($$b - 4), objArr17);
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iIndexOf, cIndexOf, iGreen, -1583976536, false, (String) objArr17[0], null);
                    }
                    ((Field) objAccessartificialFrame5).set(null, lValueOf);
                } catch (Exception unused) {
                    throw new RuntimeException();
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } else {
            Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame6 == null) {
                int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 30;
                char longPressTimeout = (char) ((ViewConfiguration.getLongPressTimeout() >> 16) + 49362);
                int size2 = View.MeasureSpec.getSize(0) + 684;
                Object[] objArr18 = new Object[1];
                b($$a[25], (byte) 40, (byte) ($$b & 495), objArr18);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay, longPressTimeout, size2, -1456483158, false, (String) objArr18[0], null);
            }
            Object[] objArr19 = (Object[]) ((Field) objAccessartificialFrame6).get(null);
            objArr = new Object[]{new int[]{((int[]) objArr19[0])[0]}, new int[]{((int[]) objArr19[1])[0]}, new int[1], (String) objArr19[3]};
            int iMyTid = Process.myTid();
            int i3 = (-1655782658) + (((~((-741047752) | iMyTid)) | 537026688 | (~(237576023 | iMyTid))) * (-754));
            int i4 = ~((-537026689) | iMyTid);
            int i5 = ~iMyTid;
            int i6 = ((i3 + ((i4 | (~(774602711 | i5))) * (-754))) + ((i5 | (-741047752)) * 754)) - 383384421;
            int i7 = (i6 << 13) ^ i6;
            int i8 = i7 ^ (i7 >>> 17);
            ((int[]) objArr[2])[0] = i8 ^ (i8 << 5);
        }
        int i9 = ((int[]) objArr[1])[0];
        int i10 = ((int[]) objArr[0])[0];
        if (i10 == i9) {
            int i11 = ((int[]) objArr[2])[0];
            Object[] objArr20 = {new int[]{((int[]) objArr[0])[0]}, new int[]{((int[]) objArr[1])[0]}, new int[1], (String) objArr[3]};
            int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
            int i12 = ~((-44343336) | startElapsedRealtime);
            int i13 = ~startElapsedRealtime;
            int i14 = i11 + (-1707083442) + ((i12 | (~((-604636289) | i13))) * 920) + (((~((-329644152) | i13)) | 44343335) * 920) + (((~(startElapsedRealtime | (-604636289))) | (~((-44343336) | i13)) | (~((-285300817) | startElapsedRealtime))) * 920);
            int i15 = (i14 << 13) ^ i14;
            int i16 = i15 ^ (i15 >>> 17);
            ((int[]) objArr20[2])[0] = i16 ^ (i16 << 5);
        } else {
            new ArrayList().add((String) objArr[3]);
            try {
                Object[] objArr21 = {Long.valueOf((((long) 1668995416) << 32) ^ ((long) (i9 ^ i10))), Long.valueOf(1668995400)};
                byte[] bArr4 = $$d;
                Object[] objArr22 = new Object[1];
                c((short) 87, bArr4[53], bArr4[430], objArr22);
                Class<?> cls2 = Class.forName((String) objArr22[0]);
                short s = bArr4[2];
                byte b = bArr4[31];
                Object[] objArr23 = new Object[1];
                c(s, b, b, objArr23);
                cls2.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                int i17 = ((int[]) objArr[2])[0];
                Object[] objArr24 = {new int[]{((int[]) objArr[0])[0]}, new int[]{((int[]) objArr[1])[0]}, new int[1], (String) objArr[3]};
                int i18 = ~((~((int) SystemClock.elapsedRealtime())) | 459960614);
                int i19 = i17 + (((16797702 | i18) * (-970)) - 278769510) + ((i18 | 443162912) * 970);
                int i20 = (i19 << 13) ^ i19;
                int i21 = i20 ^ (i20 >>> 17);
                ((int[]) objArr24[2])[0] = i21 ^ (i21 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 != null) {
                    throw cause2;
                }
                throw th2;
            }
        }
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame7 == null) {
            int maximumFlingVelocity = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 36;
            char touchSlop = (char) (ViewConfiguration.getTouchSlop() >> 8);
            int maximumDrawingCacheSize = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 540;
            byte[] bArr5 = $$a;
            byte b2 = bArr5[25];
            Object[] objArr25 = new Object[1];
            b(b2, (byte) (b2 | 46), (byte) (bArr5[3] + 1), objArr25);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity, touchSlop, maximumDrawingCacheSize, 624296913, false, (String) objArr25[0], null);
        }
        long j2 = ((Field) objAccessartificialFrame7).getLong(null);
        if (j2 == -1 || j2 + 1891 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            try {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1717965552);
                if (objAccessartificialFrame8 == null) {
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(19 - TextUtils.indexOf((CharSequence) "", '0'), (char) ((ViewConfiguration.getScrollBarSize() >> 8) + 39516), View.MeasureSpec.getSize(0) + 982, 117222168, false, null, new Class[0]);
                }
                Object[] objArr26 = {null, ((Constructor) objAccessartificialFrame8).newInstance(null), -11215438, 0};
                Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-501205803);
                if (objAccessartificialFrame9 == null) {
                    int fadingEdgeLength = (ViewConfiguration.getFadingEdgeLength() >> 16) + 36;
                    char offsetBefore = (char) TextUtils.getOffsetBefore("", 0);
                    int packedPositionChild = ExpandableListView.getPackedPositionChild(0L) + 541;
                    byte[] bArr6 = $$a;
                    byte b3 = bArr6[22];
                    byte b4 = (byte) (bArr6[25] - 1);
                    Object[] objArr27 = new Object[1];
                    b(b3, b4, (byte) (b4 | 73), objArr27);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength, offsetBefore, packedPositionChild, 2101703389, false, (String) objArr27[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(54 - (ViewConfiguration.getScrollBarSize() >> 8), (char) (833 - TextUtils.getCapsMode("", 0, 0)), 576 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)), (Class) ArtificialStackFrames.coroutineCreation(54 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) KeyEvent.normalizeMetaState(0), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 630), Integer.TYPE, Integer.TYPE});
                }
                objArr2 = (Object[]) ((Method) objAccessartificialFrame9).invoke(null, objArr26);
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                if (objAccessartificialFrame10 == null) {
                    int scrollBarSize = (ViewConfiguration.getScrollBarSize() >> 8) + 36;
                    char maximumFlingVelocity2 = (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                    int pressedStateDuration = (ViewConfiguration.getPressedStateDuration() >> 16) + 540;
                    byte b5 = $$a[25];
                    Object[] objArr28 = new Object[1];
                    b(b5, (byte) (b5 | 46), (byte) ($$b & 479), objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(scrollBarSize, maximumFlingVelocity2, pressedStateDuration, 793268735, false, (String) objArr28[0], null);
                }
                ((Field) objAccessartificialFrame10).set(null, objArr2);
                try {
                    Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                    if (objAccessartificialFrame11 == null) {
                        int iLastIndexOf = TextUtils.lastIndexOf("", '0', 0) + 37;
                        char longPressTimeout2 = (char) (ViewConfiguration.getLongPressTimeout() >> 16);
                        int scrollBarFadeDuration = 540 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                        byte[] bArr7 = $$a;
                        byte b6 = bArr7[25];
                        Object[] objArr29 = new Object[1];
                        b(b6, (byte) (b6 | 46), (byte) (bArr7[3] + 1), objArr29);
                        objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, longPressTimeout2, scrollBarFadeDuration, 624296913, false, (String) objArr29[0], null);
                    }
                    ((Field) objAccessartificialFrame11).set(null, lValueOf2);
                } catch (Exception unused2) {
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
            Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame12 == null) {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0) + 36;
                char tapTimeout = (char) (ViewConfiguration.getTapTimeout() >> 16);
                int iNormalizeMetaState = KeyEvent.normalizeMetaState(0) + 540;
                byte b7 = $$a[25];
                Object[] objArr30 = new Object[1];
                b(b7, (byte) (b7 | 46), (byte) ($$b & 479), objArr30);
                objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec, tapTimeout, iNormalizeMetaState, 793268735, false, (String) objArr30[0], null);
            }
            Object[] objArr31 = (Object[]) ((Field) objAccessartificialFrame12).get(null);
            objArr2 = new Object[]{new int[1], new int[1], new int[1]};
            int i22 = ((int[]) objArr31[2])[0];
            int i23 = ((int[]) objArr31[1])[0];
            ((int[]) objArr2[2])[0] = i22;
            ((int[]) objArr2[1])[0] = i23;
            int iMyPid = Process.myPid();
            int i24 = ~iMyPid;
            int i25 = ((((-614383018) + (((~((-1049339307) | i24)) | (~(1049622507 | iMyPid))) * (-831))) + ((~((-747340065) | iMyPid)) * (-1662))) + (((~(iMyPid | 1049339306)) | ((~(i24 | (-302282444))) | (~(302282443 | iMyPid)))) * 831)) - 11215438;
            int i26 = (i25 << 13) ^ i25;
            int i27 = i26 ^ (i26 >>> 17);
            ((int[]) objArr2[0])[0] = i27 ^ (i27 << 5);
        }
        Object obj = objArr2[1];
        int i28 = ((int[]) obj)[0];
        Object obj2 = objArr2[2];
        int i29 = ((int[]) obj2)[0];
        if (i29 == i28) {
            Object[] objArr32 = {new int[1], new int[1], new int[1]};
            int i30 = ((int[]) objArr2[0])[0];
            int i31 = ((int[]) obj2)[0];
            int i32 = ((int[]) obj)[0];
            ((int[]) objArr32[2])[0] = i31;
            ((int[]) objArr32[1])[0] = i32;
            int iIdentityHashCode = System.identityHashCode(this);
            int i33 = ~iIdentityHashCode;
            int i34 = i30 + 2106893377 + (((~(1315134429 | i33)) | 36487320) * (-328)) + ((iIdentityHashCode | 36487320) * 164) + (((~(iIdentityHashCode | (-1315134430))) | 35668120 | (~(i33 | 1315953629))) * 164);
            int i35 = (i34 << 13) ^ i34;
            int i36 = i35 ^ (i35 >>> 17);
            ((int[]) objArr32[0])[0] = i36 ^ (i36 << 5);
        } else {
            Object[] objArr33 = {Long.valueOf((((long) (-402540881)) << 32) ^ ((long) (i28 ^ i29))), Long.valueOf(-402544977)};
            byte[] bArr8 = $$d;
            Object[] objArr34 = new Object[1];
            c((short) 87, bArr8[53], bArr8[430], objArr34);
            Class<?> cls3 = Class.forName((String) objArr34[0]);
            short s2 = bArr8[2];
            byte b8 = bArr8[31];
            Object[] objArr35 = new Object[1];
            c(s2, b8, b8, objArr35);
            cls3.getMethod((String) objArr35[0], Long.TYPE, Long.TYPE).invoke(null, objArr33);
            Object[] objArr36 = {new int[1], new int[1], new int[1]};
            int i37 = ((int[]) objArr2[0])[0];
            int i38 = ((int[]) objArr2[2])[0];
            int i39 = ((int[]) objArr2[1])[0];
            ((int[]) objArr36[2])[0] = i38;
            ((int[]) objArr36[1])[0] = i39;
            int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
            int i40 = ~iElapsedRealtime;
            int i41 = (~((-762630009) | i40)) | 207913728 | (~(588991741 | i40));
            int i42 = i37 + 718984175 + (((~(iElapsedRealtime | (-34275462))) | i41) * 590) + (i41 * (-1180)) + (((~((-588991742) | i40)) | (~(i40 | 762630008))) * 590);
            int i43 = i42 ^ (i42 << 13);
            int i44 = i43 ^ (i43 >>> 17);
            ((int[]) objArr36[0])[0] = i44 ^ (i44 << 5);
        }
        Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame13 == null) {
            int mirror = 'I' - AndroidCharacter.getMirror('0');
            char cArgb = (char) (30068 - Color.argb(0, 0, 0, 0));
            int iLastIndexOf2 = 815 - TextUtils.lastIndexOf("", '0', 0, 0);
            byte[] bArr9 = $$a;
            byte b9 = bArr9[25];
            Object[] objArr37 = new Object[1];
            b(b9, (byte) (b9 | 46), (byte) (bArr9[3] + 1), objArr37);
            objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(mirror, cArgb, iLastIndexOf2, 721586079, false, (String) objArr37[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame13).getLong(null);
        if (j3 == -1 || j3 + 2016 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr38 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -303401758};
            Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame14 == null) {
                int iIndexOf2 = 25 - TextUtils.indexOf("", "");
                char cBlue = (char) (Color.blue(0) + 30068);
                int iResolveSizeAndState = View.resolveSizeAndState(0, 0, 0) + 816;
                byte[] bArr10 = $$a;
                Object[] objArr39 = new Object[1];
                b(bArr10[117], bArr10[8], (byte) 53, objArr39);
                objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(iIndexOf2, cBlue, iResolveSizeAndState, -797394565, false, (String) objArr39[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr3 = (Object[]) ((Method) objAccessartificialFrame14).invoke(null, objArr38);
            Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame15 == null) {
                int mirror2 = AndroidCharacter.getMirror('0') - 23;
                char size3 = (char) (30068 - View.MeasureSpec.getSize(0));
                int iLastIndexOf3 = 815 - TextUtils.lastIndexOf("", '0', 0, 0);
                byte b10 = $$a[25];
                Object[] objArr40 = new Object[1];
                b(b10, (byte) (b10 | 46), (byte) ($$b & 479), objArr40);
                objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(mirror2, size3, iLastIndexOf3, 891606461, false, (String) objArr40[0], null);
            }
            ((Field) objAccessartificialFrame15).set(null, objArr3);
            try {
                Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame16 == null) {
                    int iIndexOf3 = 24 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                    char pressedStateDuration2 = (char) (30068 - (ViewConfiguration.getPressedStateDuration() >> 16));
                    int jumpTapTimeout = 816 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                    byte[] bArr11 = $$a;
                    byte b11 = bArr11[25];
                    Object[] objArr41 = new Object[1];
                    b(b11, (byte) (b11 | 46), (byte) (bArr11[3] + 1), objArr41);
                    objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(iIndexOf3, pressedStateDuration2, jumpTapTimeout, 721586079, false, (String) objArr41[0], null);
                }
                ((Field) objAccessartificialFrame16).set(null, lValueOf3);
            } catch (Exception unused3) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame17 == null) {
                int defaultSize2 = View.getDefaultSize(0, 0) + 25;
                char cMyTid = (char) (30068 - (Process.myTid() >> 22));
                int iNormalizeMetaState2 = 816 - KeyEvent.normalizeMetaState(0);
                byte b12 = $$a[25];
                Object[] objArr42 = new Object[1];
                b(b12, (byte) (b12 | 46), (byte) ($$b & 479), objArr42);
                objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(defaultSize2, cMyTid, iNormalizeMetaState2, 891606461, false, (String) objArr42[0], null);
            }
            Object[] objArr43 = (Object[]) ((Field) objAccessartificialFrame17).get(null);
            objArr3 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i45 = ((int[]) objArr43[0])[0];
            int i46 = ((int[]) objArr43[1])[0];
            String[] strArr = (String[]) objArr43[2];
            int i47 = (~((int) Process.getElapsedCpuTime())) | 350947956;
            int i48 = (((-1364244980) + (i47 * 495)) + (((~i47) | 350224464) * 495)) - 303401758;
            int i49 = (i48 << 13) ^ i48;
            int i50 = i49 ^ (i49 >>> 17);
            ((int[]) objArr3[3])[0] = i50 ^ (i50 << 5);
        }
        int i51 = ((int[]) objArr3[1])[0];
        int i52 = ((int[]) objArr3[0])[0];
        if (i52 == i51) {
            int i53 = getARTIFICIAL_FRAME_PACKAGE_NAME + 101;
            artificialFrame = i53 % 128;
            int i54 = i53 % 2;
            Object[] objArr44 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i55 = ((int[]) objArr3[3])[0];
            int i56 = ((int[]) objArr3[0])[0];
            int i57 = ((int[]) objArr3[1])[0];
            String[] strArr2 = (String[]) objArr3[2];
            int i58 = (int) Runtime.getRuntime().totalMemory();
            int i59 = ~i58;
            int i60 = i55 + (-59714970) + (((~(i59 | (-16078114))) | 214250479) * (-1042)) + (((-16078114) | i58) * 521) + (((~(i58 | (-214250480))) | 201335502 | (~(i59 | (-3163137)))) * 521);
            int i61 = (i60 << 13) ^ i60;
            int i62 = i61 ^ (i61 >>> 17);
            ((int[]) objArr44[3])[0] = i62 ^ (i62 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr3[2];
            if (strArr3 != null) {
                for (String str5 : strArr3) {
                    arrayList.add(str5);
                }
            }
            long j4 = (((long) (-191738498)) << 32) ^ ((long) (i51 ^ i52));
            long j5 = -191738497;
            int i63 = getARTIFICIAL_FRAME_PACKAGE_NAME + 83;
            artificialFrame = i63 % 128;
            int i64 = i63 % 2;
            Object[] objArr45 = {Long.valueOf(j4), Long.valueOf(j5)};
            byte[] bArr12 = $$d;
            Object[] objArr46 = new Object[1];
            c((short) 113, (byte) 79, bArr12[430], objArr46);
            Class<?> cls4 = Class.forName((String) objArr46[0]);
            short s3 = bArr12[2];
            byte b13 = bArr12[31];
            Object[] objArr47 = new Object[1];
            c(s3, b13, b13, objArr47);
            cls4.getMethod((String) objArr47[0], Long.TYPE, Long.TYPE).invoke(null, objArr45);
            Object[] objArr48 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i65 = ((int[]) objArr3[3])[0];
            int i66 = ((int[]) objArr3[0])[0];
            int i67 = ((int[]) objArr3[1])[0];
            String[] strArr4 = (String[]) objArr3[2];
            int startUptimeMillis = (int) Process.getStartUptimeMillis();
            int i68 = ~((-985365155) | startUptimeMillis);
            int i69 = (-751818783) + ((715856512 | i68) * (-280)) + ((i68 | (~(787192788 | startUptimeMillis))) * 140);
            int i70 = ~((-269508643) | startUptimeMillis);
            int i71 = ~startUptimeMillis;
            int i72 = i65 + i69 + (((~(i71 | 1056701430)) | i70 | (~((-715856513) | i71))) * 140);
            int i73 = (i72 << 13) ^ i72;
            int i74 = i73 ^ (i73 >>> 17);
            ((int[]) objArr48[3])[0] = i74 ^ (i74 << 5);
        }
        Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame18 == null) {
            int i75 = 22 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
            char cIndexOf2 = (char) TextUtils.indexOf("", "", 0);
            int iRgb = Color.rgb(0, 0, 0) + 16777681;
            byte[] bArr13 = $$a;
            byte b14 = bArr13[25];
            Object[] objArr49 = new Object[1];
            b(b14, (byte) (b14 | 46), (byte) (bArr13[3] + 1), objArr49);
            objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(i75, cIndexOf2, iRgb, -785931255, false, (String) objArr49[0], null);
        }
        long j6 = ((Field) objAccessartificialFrame18).getLong(null);
        if (j6 != -1) {
            int i76 = getARTIFICIAL_FRAME_PACKAGE_NAME + 119;
            artificialFrame = i76 % 128;
            if (i76 % 2 != 0 ? j6 + 1851 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue() : (j6 ^ 1851) < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[1])).longValue()) {
                Object[] objArr50 = new Object[1];
                a((Process.myPid() >> 22) + 26, new char[]{'*', '\b', 24, 19, ' ', CoreConstants.DASH_CHAR, 27, 24, '0', 29, 30, 27, 26, 15, CoreConstants.DASH_CHAR, '/', CoreConstants.SINGLE_QUOTE_CHAR, '/', '0', '\t', 31, '#', 16, 31, '/', 22}, (byte) (KeyEvent.getDeadChar(0, 0) + 53), objArr50);
                Class<?> cls5 = Class.forName((String) objArr50[0]);
                Object[] objArr51 = new Object[1];
                a(18 - Gravity.getAbsoluteGravity(0, 0), new char[]{20, 15, 13903, 13903, 28, '\t', '+', 23, 13905, 13905, 18, '0', 15, '/', CoreConstants.DASH_CHAR, '/', 28, '\n'}, (byte) (103 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1))), objArr51);
                applicationContext = (Context) cls5.getMethod((String) objArr51[0], new Class[0]).invoke(null, null);
                if (applicationContext != null) {
                    if ((applicationContext instanceof ContextWrapper) || ((ContextWrapper) applicationContext).getBaseContext() != null) {
                        applicationContext = applicationContext.getApplicationContext();
                    } else {
                        applicationContext = null;
                    }
                }
                int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                Object[] objArr52 = new Object[1];
                a(TextUtils.getOffsetAfter("", 0) + 64, new char[]{CoreConstants.LEFT_PARENTHESIS_CHAR, '\b', 17, 25, 2, 29, CoreConstants.SINGLE_QUOTE_CHAR, 15, 20, 16, '\b', CoreConstants.DASH_CHAR, 18, 2, 1, CoreConstants.PERCENT_CHAR, '!', 23, 3, 11, '\b', 17, 1, CoreConstants.PERCENT_CHAR, 15, '.', 2, 15, 23, 5, 29, CoreConstants.PERCENT_CHAR, Typography.amp, '\b', '\f', 24, 1, CoreConstants.PERCENT_CHAR, 22, '+', 17, 20, Typography.amp, '\b', 6, 23, 20, 17, '+', 1, '.', 15, 20, 22, 1, '.', 17, 20, CoreConstants.COMMA_CHAR, 29, 19, 20, 22, 5}, (byte) (110 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))), objArr52);
                String str6 = (String) objArr52[0];
                Object[] objArr53 = new Object[1];
                a(Color.red(0) + 64, new char[]{11, 17, 13921, 13921, 29, CoreConstants.PERCENT_CHAR, 20, 23, '\b', 19, 11, '\n', 5, 2, 22, 19, 2, 5, '\t', '!', 1, '+', '\b', CoreConstants.DASH_CHAR, 20, 22, 3, 25, 24, '\f', '\n', 23, '\b', 3, 13834, 13834, '\b', CoreConstants.DASH_CHAR, 31, '\t', 17, 22, 17, 31, 2, 15, 17, 25, 15, 4, 1, '+', 16, CoreConstants.PERCENT_CHAR, 13838, 13838, '\b', CoreConstants.COMMA_CHAR, 3, 2, 15, CoreConstants.COMMA_CHAR, CoreConstants.PERCENT_CHAR, 29}, (byte) (98 - KeyEvent.normalizeMetaState(0)), objArr53);
                String[] strArr5 = {str6, (String) objArr53[0]};
                int i77 = artificialFrame + 83;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i77 % 128;
                int i78 = i77 % 2;
                Object[] objArr54 = {applicationContext, strArr5, Integer.valueOf(iIntValue), 1, -1477518997};
                byte[] bArr14 = $$d;
                Object[] objArr55 = new Object[1];
                c((short) 194, (byte) 86, bArr14[430], objArr55);
                Class<?> cls6 = Class.forName((String) objArr55[0]);
                Object[] objArr56 = new Object[1];
                c((short) 282, bArr14[109], bArr14[143], objArr56);
                objArr4 = (Object[]) cls6.getMethod((String) objArr56[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr54);
                int i79 = ((int[]) objArr4[0])[0];
                int i80 = ((int[]) objArr4[3])[0];
                if (applicationContext != null) {
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1142731807);
                    if (objAccessartificialFrame == null) {
                        int iKeyCodeFromString = KeyEvent.keyCodeFromString("") + 21;
                        char absoluteGravity = (char) Gravity.getAbsoluteGravity(0, 0);
                        int iIndexOf4 = 465 - TextUtils.indexOf("", "", 0);
                        byte b15 = $$a[25];
                        Object[] objArr57 = new Object[1];
                        b(b15, (byte) (b15 | 46), (byte) ($$b & 479), objArr57);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString, absoluteGravity, iIndexOf4, -612765161, false, (String) objArr57[0], null);
                    }
                    ((Field) objAccessartificialFrame).set(null, objArr4);
                    try {
                        Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1313006081);
                        if (objAccessartificialFrame2 == null) {
                            int iNormalizeMetaState3 = 21 - KeyEvent.normalizeMetaState(0);
                            char fadingEdgeLength2 = (char) (ViewConfiguration.getFadingEdgeLength() >> 16);
                            int iResolveOpacity = Drawable.resolveOpacity(0, 0) + 465;
                            byte[] bArr15 = $$a;
                            byte b16 = bArr15[25];
                            Object[] objArr58 = new Object[1];
                            b(b16, (byte) (b16 | 46), (byte) (bArr15[3] + 1), objArr58);
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState3, fadingEdgeLength2, iResolveOpacity, -785931255, false, (String) objArr58[0], null);
                        }
                        ((Field) objAccessartificialFrame2).set(null, lValueOf4);
                    } catch (Exception unused4) {
                        throw new RuntimeException();
                    }
                }
            } else {
                Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame19 == null) {
                    int i81 = 21 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                    char defaultSize3 = (char) View.getDefaultSize(0, 0);
                    int mirror3 = 513 - AndroidCharacter.getMirror('0');
                    byte b17 = $$a[25];
                    Object[] objArr59 = new Object[1];
                    b(b17, (byte) (b17 | 46), (byte) ($$b & 479), objArr59);
                    objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(i81, defaultSize3, mirror3, -612765161, false, (String) objArr59[0], null);
                }
                Object[] objArr60 = (Object[]) ((Field) objAccessartificialFrame19).get(null);
                objArr4 = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
                int i82 = ((int[]) objArr60[3])[0];
                int i83 = ((int[]) objArr60[0])[0];
                String[] strArr6 = (String[]) objArr60[1];
                int i84 = (~System.identityHashCode(this)) | 292270762;
                int i85 = (((-706895794) + (i84 * 495)) + (((~i84) | 270729762) * 495)) - 1477518997;
                int i86 = (i85 << 13) ^ i85;
                int i87 = i86 ^ (i86 >>> 17);
                ((int[]) objArr4[2])[0] = i87 ^ (i87 << 5);
            }
        } else {
            Object[] objArr510 = new Object[1];
            a((Process.myPid() >> 22) + 26, new char[]{'*', '\b', 24, 19, ' ', CoreConstants.DASH_CHAR, 27, 24, '0', 29, 30, 27, 26, 15, CoreConstants.DASH_CHAR, '/', CoreConstants.SINGLE_QUOTE_CHAR, '/', '0', '\t', 31, '#', 16, 31, '/', 22}, (byte) (KeyEvent.getDeadChar(0, 0) + 53), objArr510);
            Class<?> cls7 = Class.forName((String) objArr510[0]);
            Object[] objArr511 = new Object[1];
            a(18 - Gravity.getAbsoluteGravity(0, 0), new char[]{20, 15, 13903, 13903, 28, '\t', '+', 23, 13905, 13905, 18, '0', 15, '/', CoreConstants.DASH_CHAR, '/', 28, '\n'}, (byte) (103 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1))), objArr511);
            applicationContext = (Context) cls7.getMethod((String) objArr511[0], new Class[0]).invoke(null, null);
            if (applicationContext != null) {
                if (applicationContext instanceof ContextWrapper) {
                    applicationContext = applicationContext.getApplicationContext();
                } else {
                    applicationContext = applicationContext.getApplicationContext();
                }
            }
            int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr512 = new Object[1];
            a(TextUtils.getOffsetAfter("", 0) + 64, new char[]{CoreConstants.LEFT_PARENTHESIS_CHAR, '\b', 17, 25, 2, 29, CoreConstants.SINGLE_QUOTE_CHAR, 15, 20, 16, '\b', CoreConstants.DASH_CHAR, 18, 2, 1, CoreConstants.PERCENT_CHAR, '!', 23, 3, 11, '\b', 17, 1, CoreConstants.PERCENT_CHAR, 15, '.', 2, 15, 23, 5, 29, CoreConstants.PERCENT_CHAR, Typography.amp, '\b', '\f', 24, 1, CoreConstants.PERCENT_CHAR, 22, '+', 17, 20, Typography.amp, '\b', 6, 23, 20, 17, '+', 1, '.', 15, 20, 22, 1, '.', 17, 20, CoreConstants.COMMA_CHAR, 29, 19, 20, 22, 5}, (byte) (110 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))), objArr512);
            String str7 = (String) objArr512[0];
            Object[] objArr513 = new Object[1];
            a(Color.red(0) + 64, new char[]{11, 17, 13921, 13921, 29, CoreConstants.PERCENT_CHAR, 20, 23, '\b', 19, 11, '\n', 5, 2, 22, 19, 2, 5, '\t', '!', 1, '+', '\b', CoreConstants.DASH_CHAR, 20, 22, 3, 25, 24, '\f', '\n', 23, '\b', 3, 13834, 13834, '\b', CoreConstants.DASH_CHAR, 31, '\t', 17, 22, 17, 31, 2, 15, 17, 25, 15, 4, 1, '+', 16, CoreConstants.PERCENT_CHAR, 13838, 13838, '\b', CoreConstants.COMMA_CHAR, 3, 2, 15, CoreConstants.COMMA_CHAR, CoreConstants.PERCENT_CHAR, 29}, (byte) (98 - KeyEvent.normalizeMetaState(0)), objArr513);
            String[] strArr7 = {str7, (String) objArr513[0]};
            int i710 = artificialFrame + 83;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i710 % 128;
            int i711 = i710 % 2;
            Object[] objArr514 = {applicationContext, strArr7, Integer.valueOf(iIntValue2), 1, -1477518997};
            byte[] bArr16 = $$d;
            Object[] objArr515 = new Object[1];
            c((short) 194, (byte) 86, bArr16[430], objArr515);
            Class<?> cls8 = Class.forName((String) objArr515[0]);
            Object[] objArr516 = new Object[1];
            c((short) 282, bArr16[109], bArr16[143], objArr516);
            objArr4 = (Object[]) cls8.getMethod((String) objArr516[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr514);
            int i712 = ((int[]) objArr4[0])[0];
            int i88 = ((int[]) objArr4[3])[0];
            if (applicationContext != null) {
                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame == null) {
                    int iKeyCodeFromString2 = KeyEvent.keyCodeFromString("") + 21;
                    char absoluteGravity2 = (char) Gravity.getAbsoluteGravity(0, 0);
                    int iIndexOf5 = 465 - TextUtils.indexOf("", "", 0);
                    byte b18 = $$a[25];
                    Object[] objArr517 = new Object[1];
                    b(b18, (byte) (b18 | 46), (byte) ($$b & 479), objArr517);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString2, absoluteGravity2, iIndexOf5, -612765161, false, (String) objArr517[0], null);
                }
                ((Field) objAccessartificialFrame).set(null, objArr4);
                Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1313006081);
                if (objAccessartificialFrame2 == null) {
                    int iNormalizeMetaState4 = 21 - KeyEvent.normalizeMetaState(0);
                    char fadingEdgeLength3 = (char) (ViewConfiguration.getFadingEdgeLength() >> 16);
                    int iResolveOpacity2 = Drawable.resolveOpacity(0, 0) + 465;
                    byte[] bArr17 = $$a;
                    byte b19 = bArr17[25];
                    Object[] objArr518 = new Object[1];
                    b(b19, (byte) (b19 | 46), (byte) (bArr17[3] + 1), objArr518);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState4, fadingEdgeLength3, iResolveOpacity2, -785931255, false, (String) objArr518[0], null);
                }
                ((Field) objAccessartificialFrame2).set(null, lValueOf5);
            }
        }
        int i89 = ((int[]) objArr4[0])[0];
        int i90 = ((int[]) objArr4[3])[0];
        if (i90 == i89) {
            Object[] objArr61 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i91 = ((int[]) objArr4[2])[0];
            int i92 = ((int[]) objArr4[3])[0];
            int i93 = ((int[]) objArr4[0])[0];
            String[] strArr8 = (String[]) objArr4[1];
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i94 = ~iIdentityHashCode2;
            int i95 = i91 + 549048385 + (((~(767283308 | i94)) | (-1073471215)) * 98) + (((~(i94 | (-927633035))) | 767283308 | (~(927633034 | iIdentityHashCode2))) * (-49)) + (((~(iIdentityHashCode2 | 767283308)) | 145838180) * 49);
            int i96 = (i95 << 13) ^ i95;
            int i97 = i96 ^ (i96 >>> 17);
            ((int[]) objArr61[2])[0] = i97 ^ (i97 << 5);
        } else {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr9 = (String[]) objArr4[1];
            if (strArr9 != null) {
                for (String str8 : strArr9) {
                    arrayList2.add(str8);
                }
            }
            Object[] objArr62 = {Long.valueOf((((long) (-487197992)) << 32) ^ ((long) (i89 ^ i90))), Long.valueOf(-487198056)};
            byte[] bArr18 = $$d;
            Object[] objArr63 = new Object[1];
            c((short) 302, bArr18[545], bArr18[430], objArr63);
            Class<?> cls9 = Class.forName((String) objArr63[0]);
            short s4 = bArr18[2];
            byte b20 = bArr18[31];
            Object[] objArr64 = new Object[1];
            c(s4, b20, b20, objArr64);
            cls9.getMethod((String) objArr64[0], Long.TYPE, Long.TYPE).invoke(null, objArr62);
            Object[] objArr65 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i98 = ((int[]) objArr4[2])[0];
            int i99 = ((int[]) objArr4[3])[0];
            int i100 = ((int[]) objArr4[0])[0];
            String[] strArr10 = (String[]) objArr4[1];
            int i101 = ~System.identityHashCode(this);
            int i102 = i98 + (((720771397 + (((~(i101 | 195028783)) | (~((-34678030) | i101))) * (-184))) + (((160350240 | (~((-195028270) | i101))) | (~(34678543 | i101))) * SyslogConstants.LOG_LOCAL7)) - 94760);
            int i103 = (i102 << 13) ^ i102;
            int i104 = i103 ^ (i103 >>> 17);
            ((int[]) objArr65[2])[0] = i104 ^ (i104 << 5);
        }
        Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame20 == null) {
            int fadingEdgeLength4 = 26 - (ViewConfiguration.getFadingEdgeLength() >> 16);
            char packedPositionType = (char) ExpandableListView.getPackedPositionType(0L);
            int iGreen2 = 1041 - Color.green(0);
            byte[] bArr19 = $$a;
            byte b21 = bArr19[25];
            Object[] objArr66 = new Object[1];
            b(b21, (byte) (b21 | 46), (byte) (bArr19[3] + 1), objArr66);
            objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength4, packedPositionType, iGreen2, 2061780482, false, (String) objArr66[0], null);
        }
        long j7 = ((Field) objAccessartificialFrame20).getLong(null);
        if (j7 == -1 || j7 + 2039 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            int iIntValue3 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr67 = {-938199066};
            Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame21 == null) {
                objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 8, (char) (Color.blue(0) + 22251), 1033 - View.MeasureSpec.getMode(0), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = DynamiteModule.LoadingException.accessartificialFrame$78cbbd35(iIntValue3, 0, ((Constructor) objAccessartificialFrame21).newInstance(objArr67), 797058118, false);
            Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame22 == null) {
                int scrollDefaultDelay = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 26;
                char cLastIndexOf = (char) ((-1) - TextUtils.lastIndexOf("", '0', 0));
                int i105 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 1040;
                byte b22 = $$a[25];
                Object[] objArr68 = new Object[1];
                b(b22, (byte) (b22 | 46), (byte) ($$b & 479), objArr68);
                objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(scrollDefaultDelay, cLastIndexOf, i105, 1145017376, false, (String) objArr68[0], null);
            }
            ((Field) objAccessartificialFrame22).set(null, objArrAccessartificialFrame$78cbbd35);
            try {
                Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame23 == null) {
                    int i106 = 26 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                    char cMyTid2 = (char) (Process.myTid() >> 22);
                    int bitsPerPixel = 1040 - ImageFormat.getBitsPerPixel(0);
                    byte[] bArr20 = $$a;
                    byte b23 = bArr20[25];
                    Object[] objArr69 = new Object[1];
                    b(b23, (byte) (b23 | 46), (byte) (bArr20[3] + 1), objArr69);
                    objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(i106, cMyTid2, bitsPerPixel, 2061780482, false, (String) objArr69[0], null);
                }
                ((Field) objAccessartificialFrame23).set(null, lValueOf6);
            } catch (Exception unused5) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame24 == null) {
                int size4 = View.MeasureSpec.getSize(0) + 26;
                char mode = (char) View.MeasureSpec.getMode(0);
                int i107 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1042;
                byte b24 = $$a[25];
                Object[] objArr70 = new Object[1];
                b(b24, (byte) (b24 | 46), (byte) ($$b & 479), objArr70);
                objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(size4, mode, i107, 1145017376, false, (String) objArr70[0], null);
            }
            Object[] objArr71 = (Object[]) ((Field) objAccessartificialFrame24).get(null);
            objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
            int i108 = ((int[]) objArr71[3])[0];
            int i109 = ((int[]) objArr71[2])[0];
            String[] strArr11 = (String[]) objArr71[0];
            int iIdentityHashCode3 = System.identityHashCode(this);
            int i110 = ~iIdentityHashCode3;
            int i111 = (-1951111082) + (((~((-30264942) | i110)) | 13223425 | (~((-47838866) | i110)) | (~(64880381 | iIdentityHashCode3))) * (-84));
            int i112 = (~(iIdentityHashCode3 | (-47838866))) | 30264941;
            int i113 = ~(i110 | 47838865);
            int i114 = i111 + ((i112 | i113) * (-84)) + (((-64880382) | i113) * 84) + 797058118;
            int i115 = (i114 << 13) ^ i114;
            int i116 = i115 ^ (i115 >>> 17);
            ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i116 ^ (i116 << 5);
        }
        int i117 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i118 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i118 == i117) {
            int i119 = artificialFrame + 29;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i119 % 128;
            int i120 = i119 % 2;
            Object[] objArr72 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i121 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i122 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i123 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr12 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int i124 = (int) Runtime.getRuntime().totalMemory();
            int i125 = i121 + (((~(991154093 | i124)) | (-78142210)) * 398) + 1121574710 + (((~((~i124) | 991154093)) | (-78142210)) * 398);
            int i126 = (i125 << 13) ^ i125;
            int i127 = i126 ^ (i126 >>> 17);
            ((int[]) objArr72[1])[0] = i127 ^ (i127 << 5);
        } else {
            ArrayList arrayList3 = new ArrayList();
            String[] strArr13 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr13 != null) {
                int i128 = getARTIFICIAL_FRAME_PACKAGE_NAME + b.i;
                artificialFrame = i128 % 128;
                for (int i129 = i128 % 2 == 0 ? 1 : 0; i129 < strArr13.length; i129++) {
                    arrayList3.add(strArr13[i129]);
                }
            }
            Object[] objArr73 = {Long.valueOf((((long) 917484794) << 32) ^ ((long) (i117 ^ i118))), Long.valueOf(917484792)};
            byte[] bArr21 = $$d;
            Object[] objArr74 = new Object[1];
            c((short) 344, (byte) (-bArr21[101]), bArr21[56], objArr74);
            Class<?> cls10 = Class.forName((String) objArr74[0]);
            short s5 = bArr21[2];
            byte b25 = bArr21[31];
            Object[] objArr75 = new Object[1];
            c(s5, b25, b25, objArr75);
            cls10.getMethod((String) objArr75[0], Long.TYPE, Long.TYPE).invoke(null, objArr73);
            Object[] objArr76 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i130 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i131 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i132 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr14 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iMyPid2 = Process.myPid();
            int i133 = ~iMyPid2;
            int i134 = i130 + (-2102198530) + ((iMyPid2 | 805507114) * 988) + (((~(951260458 | i133)) | (-1018909996)) * (-1976)) + (((~(iMyPid2 | 873156651)) | 805507114 | (~((-873156652) | i133))) * 988);
            int i135 = (i134 << 13) ^ i134;
            int i136 = i135 ^ (i135 >>> 17);
            ((int[]) objArr76[1])[0] = i136 ^ (i136 << 5);
        }
        Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame25 == null) {
            int i137 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 30;
            char touchSlop2 = (char) ((ViewConfiguration.getTouchSlop() >> 8) + 49362);
            int iResolveSize = View.resolveSize(0, 0) + 684;
            byte b26 = $$a[20];
            byte b27 = (byte) (b26 | 37);
            Object[] objArr77 = new Object[1];
            b(b26, b27, (byte) (b27 - 3), objArr77);
            objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(i137, touchSlop2, iResolveSize, 752929587, false, (String) objArr77[0], null);
        }
        long j8 = ((Field) objAccessartificialFrame25).getLong(null);
        if (j8 == -1 || j8 + 2042 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr78 = new Object[1];
            a(26 - View.getDefaultSize(0, 0), new char[]{'*', '\b', 24, 19, ' ', CoreConstants.DASH_CHAR, 27, 24, '0', 29, 30, 27, 26, 15, CoreConstants.DASH_CHAR, '/', CoreConstants.SINGLE_QUOTE_CHAR, '/', '0', '\t', 31, '#', 16, 31, '/', 22}, (byte) (53 - View.combineMeasuredStates(0, 0)), objArr78);
            Class<?> cls11 = Class.forName((String) objArr78[0]);
            Object[] objArr79 = new Object[1];
            a((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 18, new char[]{20, 15, 13903, 13903, 28, '\t', '+', 23, 13905, 13905, 18, '0', 15, '/', CoreConstants.DASH_CHAR, '/', 28, '\n'}, (byte) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + b.i), objArr79);
            Context applicationContext2 = (Context) cls11.getMethod((String) objArr79[0], new Class[0]).invoke(null, null);
            if (applicationContext2 != null) {
                int i138 = artificialFrame + 99;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i138 % 128;
                if (i138 % 2 != 0) {
                    int i139 = 38 / 0;
                    if (applicationContext2 instanceof ContextWrapper) {
                        if (((ContextWrapper) applicationContext2).getBaseContext() != null) {
                            applicationContext2 = null;
                        }
                    }
                } else if (!(!(applicationContext2 instanceof ContextWrapper))) {
                    if (((ContextWrapper) applicationContext2).getBaseContext() != null) {
                        applicationContext2 = null;
                    }
                }
                applicationContext2 = applicationContext2.getApplicationContext();
            }
            Object[] objArr80 = {applicationContext2, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 775314179};
            byte[] bArr22 = $$d;
            Object[] objArr81 = new Object[1];
            c((short) 398, (byte) 79, bArr22[430], objArr81);
            Class<?> cls12 = Class.forName((String) objArr81[0]);
            Object[] objArr82 = new Object[1];
            c((short) 479, bArr22[1], bArr22[167], objArr82);
            objArr5 = (Object[]) cls12.getMethod((String) objArr82[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr80);
            if (applicationContext2 != null) {
                Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(-326560385);
                if (objAccessartificialFrame26 == null) {
                    int i140 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 30;
                    char touchSlop3 = (char) (49362 - (ViewConfiguration.getTouchSlop() >> 8));
                    int iAxisFromString = MotionEvent.axisFromString("") + 685;
                    byte[] bArr23 = $$a;
                    Object[] objArr83 = new Object[1];
                    b(bArr23[20], (byte) (bArr23[54] + 1), (byte) (-bArr23[23]), objArr83);
                    objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(i140, touchSlop3, iAxisFromString, 1944867703, false, (String) objArr83[0], null);
                }
                ((Field) objAccessartificialFrame26).set(null, objArr5);
                try {
                    Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                    if (objAccessartificialFrame27 == null) {
                        int tapTimeout2 = (ViewConfiguration.getTapTimeout() >> 16) + 30;
                        char c = (char) (49362 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                        int i141 = 684 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                        byte b28 = $$a[20];
                        byte b29 = (byte) (b28 | 37);
                        Object[] objArr84 = new Object[1];
                        b(b28, b29, (byte) (b29 - 3), objArr84);
                        objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(tapTimeout2, c, i141, 752929587, false, (String) objArr84[0], null);
                    }
                    ((Field) objAccessartificialFrame27).set(null, lValueOf7);
                } catch (Exception unused6) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(-326560385);
            if (objAccessartificialFrame28 == null) {
                int i142 = 31 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                char cKeyCodeFromString = (char) (49362 - KeyEvent.keyCodeFromString(""));
                int iNormalizeMetaState5 = 684 - KeyEvent.normalizeMetaState(0);
                byte[] bArr24 = $$a;
                Object[] objArr85 = new Object[1];
                b(bArr24[20], (byte) (bArr24[54] + 1), (byte) (-bArr24[23]), objArr85);
                objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(i142, cKeyCodeFromString, iNormalizeMetaState5, 1944867703, false, (String) objArr85[0], null);
            }
            Object[] objArr86 = (Object[]) ((Field) objAccessartificialFrame28).get(null);
            objArr5 = new Object[]{new int[]{((int[]) objArr86[0])[0]}, new int[]{((int[]) objArr86[1])[0]}, new int[1], (String) objArr86[3]};
            int iIdentityHashCode4 = System.identityHashCode(this);
            int i143 = (-499953058) + (((~(1015987690 | iIdentityHashCode4)) | (-37363916)) * 672);
            int i144 = ~iIdentityHashCode4;
            int i145 = i143 + (((~(iIdentityHashCode4 | (-37363916))) | (~((-1015987691) | i144))) * (-672)) + (((~(37363915 | i144)) | (-1052687852)) * 672) + 775314179;
            int i146 = (i145 << 13) ^ i145;
            int i147 = i146 ^ (i146 >>> 17);
            ((int[]) objArr5[2])[0] = i147 ^ (i147 << 5);
        }
        int i148 = ((int[]) objArr5[1])[0];
        int i149 = ((int[]) objArr5[0])[0];
        if (i149 == i148) {
            int i150 = ((int[]) objArr5[2])[0];
            Object[] objArr87 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int iIdentityHashCode5 = System.identityHashCode(this);
            int i151 = ~iIdentityHashCode5;
            int i152 = (~((-798389126) | i151)) | 177611137;
            int i153 = ~(iIdentityHashCode5 | 801012637);
            int i154 = i150 + (-54898668) + ((i152 | i153) * (-502)) + ((i153 | (~(i151 | (-620777989)))) * TypedValues.PositionType.TYPE_DRAWPATH);
            int i155 = (i154 << 13) ^ i154;
            int i156 = i155 ^ (i155 >>> 17);
            ((int[]) objArr87[2])[0] = i156 ^ (i156 << 5);
        } else {
            Object[] objArr88 = {Long.valueOf((((long) (-1204209778)) << 32) ^ ((long) (i148 ^ i149))), Long.valueOf(-1204209782)};
            byte[] bArr25 = $$d;
            Object[] objArr89 = new Object[1];
            c((short) 87, bArr25[53], bArr25[430], objArr89);
            Class<?> cls13 = Class.forName((String) objArr89[0]);
            short s6 = bArr25[2];
            byte b30 = bArr25[31];
            Object[] objArr90 = new Object[1];
            c(s6, b30, b30, objArr90);
            cls13.getMethod((String) objArr90[0], Long.TYPE, Long.TYPE).invoke(null, objArr88);
            int i157 = ((int[]) objArr5[2])[0];
            Object[] objArr91 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int iIdentityHashCode6 = System.identityHashCode(this);
            int i158 = i157 + 659902834 + (((~(338196776 | iIdentityHashCode6)) | 570688214) * (-140)) + ((~(908884990 | iIdentityHashCode6)) * 70) + (((~(iIdentityHashCode6 | 640426998)) | 839146206) * 70);
            int i159 = (i158 << 13) ^ i158;
            int i160 = i159 ^ (i159 >>> 17);
            ((int[]) objArr91[2])[0] = i160 ^ (i160 << 5);
        }
        Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame29 == null) {
            int iMyTid2 = (Process.myTid() >> 22) + 30;
            char cIndexOf3 = (char) (TextUtils.indexOf("", "", 0) + 49362);
            int i161 = 684 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
            byte[] bArr26 = $$a;
            byte b31 = (byte) (-bArr26[14]);
            Object[] objArr92 = new Object[1];
            b(b31, (byte) (b31 | 40), bArr26[38], objArr92);
            objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(iMyTid2, cIndexOf3, i161, 508509282, false, (String) objArr92[0], null);
        }
        long j9 = ((Field) objAccessartificialFrame29).getLong(null);
        if (j9 == -1 || j9 + 2014 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr93 = new Object[1];
            a(25 - TextUtils.lastIndexOf("", '0', 0, 0), new char[]{'*', '\b', 24, 19, ' ', CoreConstants.DASH_CHAR, 27, 24, '0', 29, 30, 27, 26, 15, CoreConstants.DASH_CHAR, '/', CoreConstants.SINGLE_QUOTE_CHAR, '/', '0', '\t', 31, '#', 16, 31, '/', 22}, (byte) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 52), objArr93);
            Class<?> cls14 = Class.forName((String) objArr93[0]);
            Object[] objArr94 = new Object[1];
            a(18 - TextUtils.indexOf("", ""), new char[]{20, 15, 13903, 13903, 28, '\t', '+', 23, 13905, 13905, 18, '0', 15, '/', CoreConstants.DASH_CHAR, '/', 28, '\n'}, (byte) (103 - (ViewConfiguration.getDoubleTapTimeout() >> 16)), objArr94);
            Context applicationContext3 = (Context) cls14.getMethod((String) objArr94[0], new Class[0]).invoke(null, null);
            if (applicationContext3 != null) {
                applicationContext3 = ((applicationContext3 instanceof ContextWrapper) && ((ContextWrapper) applicationContext3).getBaseContext() == null) ? null : applicationContext3.getApplicationContext();
            }
            Object[] objArr95 = {applicationContext3, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -1505501285};
            byte[] bArr27 = $$d;
            Object[] objArr96 = new Object[1];
            c((short) 498, bArr27[395], bArr27[430], objArr96);
            Class<?> cls15 = Class.forName((String) objArr96[0]);
            Object[] objArr97 = new Object[1];
            c((short) 282, bArr27[109], bArr27[143], objArr97);
            objArr6 = (Object[]) cls15.getMethod((String) objArr97[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr95);
            if (applicationContext3 != null) {
                int i162 = artificialFrame + 69;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i162 % 128;
                int i163 = i162 % 2;
                Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame30 == null) {
                    int windowTouchSlop = (ViewConfiguration.getWindowTouchSlop() >> 8) + 30;
                    char fadingEdgeLength5 = (char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 49362);
                    int iCombineMeasuredStates = View.combineMeasuredStates(0, 0) + 684;
                    byte[] bArr28 = $$a;
                    byte b32 = bArr28[25];
                    Object[] objArr98 = new Object[1];
                    b((byte) (b32 - 1), (byte) (-bArr28[35]), (byte) (b32 - 1), objArr98);
                    objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(windowTouchSlop, fadingEdgeLength5, iCombineMeasuredStates, -1321816393, false, (String) objArr98[0], null);
                }
                ((Field) objAccessartificialFrame30).set(null, objArr6);
                try {
                    Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                    if (objAccessartificialFrame31 == null) {
                        int keyRepeatDelay2 = 30 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                        char cIndexOf4 = (char) (49362 - TextUtils.indexOf("", "", 0, 0));
                        int i164 = 685 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                        byte[] bArr29 = $$a;
                        byte b33 = (byte) (-bArr29[14]);
                        Object[] objArr99 = new Object[1];
                        b(b33, (byte) (b33 | 40), bArr29[38], objArr99);
                        objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay2, cIndexOf4, i164, 508509282, false, (String) objArr99[0], null);
                    }
                    ((Field) objAccessartificialFrame31).set(null, lValueOf8);
                } catch (Exception unused7) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(777251007);
            if (objAccessartificialFrame32 == null) {
                int iCombineMeasuredStates2 = View.combineMeasuredStates(0, 0) + 30;
                char offsetBefore2 = (char) (49362 - TextUtils.getOffsetBefore("", 0));
                int i165 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 685;
                byte[] bArr30 = $$a;
                byte b34 = bArr30[25];
                Object[] objArr100 = new Object[1];
                b((byte) (b34 - 1), (byte) (-bArr30[35]), (byte) (b34 - 1), objArr100);
                objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates2, offsetBefore2, i165, -1321816393, false, (String) objArr100[0], null);
            }
            Object[] objArr101 = (Object[]) ((Field) objAccessartificialFrame32).get(null);
            objArr6 = new Object[]{new int[]{((int[]) objArr101[0])[0]}, new int[]{((int[]) objArr101[1])[0]}, new int[1], (String) objArr101[3]};
            int iIdentityHashCode7 = System.identityHashCode(this);
            int i166 = ~iIdentityHashCode7;
            int i167 = (((373199194 + (((~((-218441617) | i166)) | 760182158) * (-602))) + ((((~(iIdentityHashCode7 | (-218441617))) | 218441088) | (~(760182686 | i166))) * (-301))) + ((~(i166 | 760182158)) * 301)) - 1505501285;
            int i168 = (i167 << 13) ^ i167;
            int i169 = i168 ^ (i168 >>> 17);
            ((int[]) objArr6[2])[0] = i169 ^ (i169 << 5);
        }
        int i170 = ((int[]) objArr6[1])[0];
        int i171 = ((int[]) objArr6[0])[0];
        if (i171 == i170) {
            int i172 = ((int[]) objArr6[2])[0];
            Object[] objArr102 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
            int iIdentityHashCode8 = System.identityHashCode(this);
            int i173 = ~((-42467618) | iIdentityHashCode8);
            int i174 = ~iIdentityHashCode8;
            int i175 = i172 + (-1707083442) + ((i173 | (~((-608178249) | i174))) * 920) + (((~((-327977910) | i174)) | 42467617) * 920) + (((~(iIdentityHashCode8 | (-608178249))) | (~((-42467618) | i174)) | (~((-285510293) | iIdentityHashCode8))) * 920);
            int i176 = (i175 << 13) ^ i175;
            int i177 = i176 ^ (i176 >>> 17);
            ((int[]) objArr102[2])[0] = i177 ^ (i177 << 5);
        } else {
            long j10 = (((long) 1836469849) << 32) ^ ((long) (i170 ^ i171));
            long j11 = 1836469337;
            int i178 = artificialFrame + 35;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i178 % 128;
            int i179 = i178 % 2;
            Object[] objArr103 = {Long.valueOf(j10), Long.valueOf(j11)};
            byte[] bArr31 = $$d;
            Object[] objArr104 = new Object[1];
            c((short) 550, bArr31[20], bArr31[430], objArr104);
            Class<?> cls16 = Class.forName((String) objArr104[0]);
            short s7 = bArr31[2];
            byte b35 = bArr31[31];
            Object[] objArr105 = new Object[1];
            c(s7, b35, b35, objArr105);
            cls16.getMethod((String) objArr105[0], Long.TYPE, Long.TYPE).invoke(null, objArr103);
            int i180 = ((int[]) objArr6[2])[0];
            Object[] objArr106 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
            int i181 = (int) Runtime.getRuntime().totalMemory();
            int i182 = i180 + 1948088930 + (((~((-39919745) | i181)) | (~((~i181) | 938704030))) * (-318)) + (((~(670121088 | i181)) | 268582942) * (-318)) + (((~(i181 | (-670121089))) | (-308502687)) * TypedValues.AttributesType.TYPE_PIVOT_TARGET);
            int i183 = (i182 << 13) ^ i182;
            int i184 = i183 ^ (i183 >>> 17);
            ((int[]) objArr106[2])[0] = i184 ^ (i184 << 5);
        }
        Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame33 == null) {
            int scrollDefaultDelay2 = 17 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
            char c2 = (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
            int iArgb = Color.argb(0, 0, 0, 0) + 747;
            byte[] bArr32 = $$a;
            byte b36 = bArr32[25];
            Object[] objArr107 = new Object[1];
            b(b36, (byte) (b36 | 46), (byte) (bArr32[3] + 1), objArr107);
            objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(scrollDefaultDelay2, c2, iArgb, -144068856, false, (String) objArr107[0], null);
        }
        long j12 = ((Field) objAccessartificialFrame33).getLong(null);
        if (j12 == -1 || j12 + 2033 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr108 = new Object[1];
            a(26 - (ViewConfiguration.getScrollBarSize() >> 8), new char[]{'*', '\b', 24, 19, ' ', CoreConstants.DASH_CHAR, 27, 24, '0', 29, 30, 27, 26, 15, CoreConstants.DASH_CHAR, '/', CoreConstants.SINGLE_QUOTE_CHAR, '/', '0', '\t', 31, '#', 16, 31, '/', 22}, (byte) (52 - ExpandableListView.getPackedPositionChild(0L)), objArr108);
            Class<?> cls17 = Class.forName((String) objArr108[0]);
            Object[] objArr109 = new Object[1];
            a(ExpandableListView.getPackedPositionGroup(0L) + 18, new char[]{20, 15, 13903, 13903, 28, '\t', '+', 23, 13905, 13905, 18, '0', 15, '/', CoreConstants.DASH_CHAR, '/', 28, '\n'}, (byte) (103 - Color.argb(0, 0, 0, 0)), objArr109);
            Context applicationContext4 = (Context) cls17.getMethod((String) objArr109[0], new Class[0]).invoke(null, null);
            if (applicationContext4 != null) {
                applicationContext4 = ((applicationContext4 instanceof ContextWrapper) && ((ContextWrapper) applicationContext4).getBaseContext() == null) ? null : applicationContext4.getApplicationContext();
            }
            Object[] objArr110 = {applicationContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 846845237};
            byte[] bArr33 = $$d;
            Object[] objArr111 = new Object[1];
            c((short) 616, (byte) (-bArr33[582]), bArr33[430], objArr111);
            Class<?> cls18 = Class.forName((String) objArr111[0]);
            Object[] objArr112 = new Object[1];
            c((short) 479, bArr33[1], bArr33[167], objArr112);
            objArr7 = (Object[]) cls18.getMethod((String) objArr112[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr110);
            Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame34 == null) {
                int offsetAfter = 17 - TextUtils.getOffsetAfter("", 0);
                char cLastIndexOf2 = (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1);
                int i185 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 746;
                byte b37 = $$a[25];
                Object[] objArr113 = new Object[1];
                b(b37, (byte) (b37 | 46), (byte) ($$b & 479), objArr113);
                objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(offsetAfter, cLastIndexOf2, i185, -1031537386, false, (String) objArr113[0], null);
            }
            ((Field) objAccessartificialFrame34).set(null, objArr7);
            try {
                Long lValueOf9 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame35 == null) {
                    int iIndexOf6 = TextUtils.indexOf("", "", 0) + 17;
                    char packedPositionGroup = (char) ExpandableListView.getPackedPositionGroup(0L);
                    int scrollBarSize2 = (ViewConfiguration.getScrollBarSize() >> 8) + 747;
                    byte[] bArr34 = $$a;
                    byte b38 = bArr34[25];
                    Object[] objArr114 = new Object[1];
                    b(b38, (byte) (b38 | 46), (byte) (bArr34[3] + 1), objArr114);
                    objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(iIndexOf6, packedPositionGroup, scrollBarSize2, -144068856, false, (String) objArr114[0], null);
                }
                ((Field) objAccessartificialFrame35).set(null, lValueOf9);
            } catch (Exception unused8) {
                throw new RuntimeException();
            }
        } else {
            int i186 = artificialFrame + 43;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i186 % 128;
            int i187 = i186 % 2;
            Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame36 == null) {
                int iIndexOf7 = 17 - TextUtils.indexOf("", "");
                char c3 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                int keyRepeatTimeout = 747 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                byte b39 = $$a[25];
                Object[] objArr115 = new Object[1];
                b(b39, (byte) (b39 | 46), (byte) ($$b & 479), objArr115);
                objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(iIndexOf7, c3, keyRepeatTimeout, -1031537386, false, (String) objArr115[0], null);
            }
            Object[] objArr116 = (Object[]) ((Field) objAccessartificialFrame36).get(null);
            objArr7 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
            int i188 = ((int[]) objArr116[3])[0];
            int i189 = ((int[]) objArr116[4])[0];
            List list = (List) objArr116[0];
            List list2 = (List) objArr116[2];
            int iIdentityHashCode9 = System.identityHashCode(this);
            int i190 = ~iIdentityHashCode9;
            int i191 = (-2076181579) + (((~(127578155 | i190)) | 477870302) * (-328)) + ((iIdentityHashCode9 | 477870302) * 164) + (((~(iIdentityHashCode9 | (-127578156))) | 68857866 | (~(i190 | 536590591))) * 164) + 846845237;
            int i192 = (i191 << 13) ^ i191;
            int i193 = i192 ^ (i192 >>> 17);
            ((int[]) objArr7[1])[0] = i193 ^ (i193 << 5);
        }
        int i194 = ((int[]) objArr7[4])[0];
        int i195 = ((int[]) objArr7[3])[0];
        if (i195 == i194) {
            Object[] objArr117 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i196 = ((int[]) objArr7[1])[0];
            int i197 = ((int[]) objArr7[3])[0];
            int i198 = ((int[]) objArr7[4])[0];
            List list3 = (List) objArr7[0];
            List list4 = (List) objArr7[2];
            int i199 = ~(System.identityHashCode(this) | 3122452);
            int i200 = i196 + (-882432933) + (((-602326006) | i199) * (-220)) + ((i199 | (-602925046)) * 220) + 1619670190;
            int i201 = (i200 << 13) ^ i200;
            int i202 = i201 ^ (i201 >>> 17);
            ((int[]) objArr117[1])[0] = i202 ^ (i202 << 5);
        } else {
            ArrayList arrayList4 = new ArrayList();
            Object[] objArr118 = {objArr7};
            Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(1804664566);
            if (objAccessartificialFrame37 == null) {
                objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0', 0) + 42, (char) (12469 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), 3641 - ((byte) KeyEvent.getModifierMetaStateMask()), -185222914, false, "coroutineCreation", new Class[]{Object[].class});
            }
            arrayList4.add(((Method) objAccessartificialFrame37).invoke(null, objArr118));
            Object[] objArr119 = {objArr7};
            Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(-1243809191);
            if (objAccessartificialFrame38 == null) {
                objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 40, (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 12468), 3641 - TextUtils.indexOf((CharSequence) "", '0', 0), 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
            }
            arrayList4.add(((Method) objAccessartificialFrame38).invoke(null, objArr119));
            Object[] objArr120 = {Long.valueOf((((long) 2144838324) << 32) ^ ((long) (i194 ^ i195))), Long.valueOf(2144838332)};
            byte[] bArr35 = $$d;
            Object[] objArr121 = new Object[1];
            c((short) 662, bArr35[143], bArr35[430], objArr121);
            Class<?> cls19 = Class.forName((String) objArr121[0]);
            short s8 = bArr35[2];
            byte b40 = bArr35[31];
            Object[] objArr122 = new Object[1];
            c(s8, b40, b40, objArr122);
            cls19.getMethod((String) objArr122[0], Long.TYPE, Long.TYPE).invoke(null, objArr120);
            Object[] objArr123 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i203 = ((int[]) objArr7[1])[0];
            int i204 = ((int[]) objArr7[3])[0];
            int i205 = ((int[]) objArr7[4])[0];
            List list5 = (List) objArr7[0];
            List list6 = (List) objArr7[2];
            int iUptimeMillis = (int) SystemClock.uptimeMillis();
            int i206 = i203 + 1558326695 + (((~iUptimeMillis) | (-597051626)) * 1444) + (((~(iUptimeMillis | 583030937)) | (~(22417520 | iUptimeMillis)) | (-601250042)) * (-1444)) + 1574543650;
            int i207 = (i206 << 13) ^ i206;
            int i208 = i207 ^ (i207 >>> 17);
            ((int[]) objArr123[1])[0] = i208 ^ (i208 << 5);
        }
        return super.onCreate();
    }

    static {
        byte[] bArr = new byte[729];
        System.arraycopy("\u0014\u0011o\u001bó\u0001>Æ÷ÿ\u0007ú\u00066Êðø\bû\u0004@¹\nú\u0002<º\n\u0006üþ\u00005½ý\u0002ú\u0004\fì\u000e7Úå\u000bôÿ\u0018ãüý\u000e\u0000\u0016ëðKßÞñ\u000fýö\túú\u0006!Öù\u0001ø%íðóü\u0002ù\u0000\nú\b!Ð\f\u0003ì\nù\u0000ó\u0001>Æ÷ÿ\u0007ú\u00066Ìð\u0006:ÜÛ\u0005ú\u0012\u0010Ý\u0002ú\u0004ÿÂó\u0001>Æ÷ÿ\u0007ú\u00066Ìò\tñ\u0002\u0005\u00045À\u000bì\u000eò\b\u0007ô=Êó\u0002üüC¸\u0000\nü\u0002ô\n\u0003ñDéÊ\n\fó\u0003\u0005\u001fÓ\u0002üüMÿÞÌ\u0003\u000eò\u0003\fô\u0018Ù\nù\u000b\u0002ð\n\u0005\u0016êó\ný\u00020ó\u0001>Æ÷ÿ\u0007ú\u00066Ìò\tñ\u0002\u0005\u00045É\u0002ì\u0012ì\u0001\u0010òú\u0002\u0000üýE»ü\u0006ù\nû\u00076º\u000fú\u0002\u0000î\b\u0002ú\u00068Ãú\fî\u000fú\u0002\u0000î\b\u0002ú\u00068Öçü\u0006!Ú\u0004ô\n\u0007ô\u0002î\u0014ò\u0012\u0018äýî\u0004üøýÿýñÿ\u0011îý\n\u0002ü\u0005ù\u0007ô%Ó\u0010ó\u0007ó\u0001>Åþô\u0012ýúþ\u0007ðÿAÈì\u0014ýôû\nù\u0000úDàÓ5Ù\u0005ýò\u0002)Ì\u0014ýôû\nù\u0000\u0003\u0002óÿ\u0003<\u0004Äúù\u000eò\u0003\fô=½\u0003\nì\röü\u0004>Ìò\tñ\u0002\u0005\u00045éÞþ\u0000òÿ\f\u0000\u0010ã\u000b÷\u0005ð2Ü\u0002ðû\u000eòó\u0001>Ç\u0004ýý\u0002òÿ\u0003<Çó\fñ\u000fó@Ìò\u0004û\u000bì\nù\u0000?Éñ\u0010é\u0015þõ\u00066ìÒ\u0004û\u000bì\u000e\u0000\u001fÑ\u0010é\u0015þõ\u00062\rÿÞÌ\u0003\u000eò\u0003\fô\u0018Ù\nù\u000b\u0002ð\n\u0005\u0016êó\ný\u00020Óü\u0002ù\u0000\nú\b Þ\u0002ì\rÿýú\u0006\u001bÖú9¼\u0001ûDÁü\u0007\u0004\u0000ý÷<Êóü\f6Ãúü\u0010ò?¸\u0000\nü=äÚù\u0001\u0002û\u0002\n\u0001î\nù\u0000(Ì\u0014ýôû\nù\u0000ó\u0001>Ç\u0004ýý\u0002òÿ\u0003<»\f\u0003ýîE¸\u000bû\u000bò\fù\u0001òCÔé\u0007\u0005\u0012Þ\nþ\u0014àÿ\u0002GÿÞÌ\u0003\u000eò\u0003\fô\u0018Ù\nù\u000b\u0002ð\n\u0005\u0016êó\ný\u00020ó\u0001>Æ÷ÿ\u0007ú\u00066Ìò\tñ\u0002\u0005\u00045ÆùùDÊó\u0001ÿý\u0000?Ìð\u0006:Äúù\u000eò\u0003\fô=³\u0018ýìó\u0001>Æ÷ÿ\u0007ú\u00066Ìò\tñ\u0002\u0005\u00045ÆùùDÄúù\u000eò\u0003\fô=À\u0000\u0000\u0001ô\u0014è\fõ\tù\u0000\u000eü\u0000î\u000eó\nþ\u0005üì\u0006\t÷\u0006\u00005³ÿ\u0014".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 729);
        $$d = bArr;
        $$e = 248;
        $$a = new byte[]{Ascii.GS, -31, -116, 88, 2, -15, 33, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, -10, Ascii.US, -20, -13, 8, Ascii.VT, Ascii.CR, -27, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -49, -2, Ascii.VT, 3, -3, 6, -6, 8, -11, Ascii.EM, -33, 19, -2, -8, 37, -44, 17, -12, 8, -14, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13, 9, -18, 34, -25, -4, 17, -19, Ascii.SI, 1, Ascii.DC2, -15, -19, Ascii.VT, -5, 7, 2, -15, 36, -21, -13, Ascii.SI, -2, -9, -6, 34, -15, -19, Ascii.VT, -5, 7, 9, -18, 36, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, 7, -18, 43, -29, 4, -17, -2};
        $$b = 113;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        ArtificialStackFrames = new char[]{39058, 44339, 44344, 44394, 44342, 39068, 39071, 44398, 44395, 44386, 44341, 44391, 44337, 44409, 44405, 44345, 44336, 44402, 44343, 44387, 44396, 39069, 44353, 44334, 44338, 39056, 44388, 44340, 44372, 44355, 44389, 44399, 39064, 44360, 44400, 39065, 44390, 39059, 44392, 39070, 44406, 44403, 44397, 44385, 44404, 44370, 44393, 39067, 44371};
        coroutineCreation = (char) 39069;
    }
}
