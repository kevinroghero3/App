package com.transistorsoft.locationmanager.util;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.graphics.ImageFormat;
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
import androidx.core.content.FileProvider;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager$$ExternalSyntheticLambda5;
import com.google.common.base.Ascii;
import com.google.mlkit.common.MlKitException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import o.ArtificialStackFrames;
import o.onMessageChannelReady;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes6.dex */
public class LogFileProvider extends FileProvider {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    private static boolean ICustomTabsServiceDefault;
    private static int artificialFrame;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static boolean requestPostMessageChannelWithExtras;
    private static char[] validateRelationship;
    private static int warmup;
    private static final byte[] $$c = {6, Ascii.FS, 8, -86};
    private static final int $$f = 194;
    private static int $10 = 0;
    private static int $11 = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(byte r7, byte r8, byte r9) {
        /*
            int r7 = r7 + 4
            byte[] r0 = com.transistorsoft.locationmanager.util.LogFileProvider.$$c
            int r8 = r8 * 4
            int r8 = r8 + 1
            int r9 = 121 - r9
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L13
            r9 = r7
            r3 = r8
            r4 = r2
            goto L29
        L13:
            r3 = r2
        L14:
            int r4 = r3 + 1
            int r7 = r7 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r8) goto L23
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            return r7
        L23:
            r3 = r0[r7]
            r6 = r9
            r9 = r7
            r7 = r3
            r3 = r6
        L29:
            int r7 = r7 + r3
            r3 = r4
            r6 = r9
            r9 = r7
            r7 = r6
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.util.LogFileProvider.$$g(byte, byte, byte):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(short r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 + 65
            int r0 = r8 + 8
            int r6 = r6 + 4
            byte[] r1 = com.transistorsoft.locationmanager.util.LogFileProvider.$$a
            byte[] r0 = new byte[r0]
            int r8 = r8 + 7
            r2 = 0
            if (r1 != 0) goto L13
            r7 = r6
            r3 = r8
            r4 = r2
            goto L2b
        L13:
            r3 = r2
        L14:
            int r6 = r6 + 1
            byte r4 = (byte) r7
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L25:
            r3 = r1[r6]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r5
        L2b:
            int r6 = r6 + r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.util.LogFileProvider.b(short, byte, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0024). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void c(short r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = 618 - r6
            byte[] r0 = com.transistorsoft.locationmanager.util.LogFileProvider.$$d
            int r7 = r7 + 36
            int r8 = 82 - r8
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L10
            r3 = r8
            r4 = r2
            goto L24
        L10:
            r3 = r2
        L11:
            int r6 = r6 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r8) goto L22
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L22:
            r3 = r0[r6]
        L24:
            int r3 = -r3
            int r7 = r7 + r3
            int r7 = r7 + (-1)
            r3 = r4
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.util.LogFileProvider.c(short, byte, short, java.lang.Object[]):void");
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) throws Throwable {
        char[] cArr2;
        char[] cArr3;
        int i2 = 2;
        int i3 = 2 % 2;
        onMessageChannelReady onmessagechannelready = new onMessageChannelReady();
        char[] cArr4 = validateRelationship;
        int i4 = -1;
        int i5 = 0;
        if (cArr4 != null) {
            int length = cArr4.length;
            char[] cArr5 = new char[length];
            int i6 = 0;
            while (i6 < length) {
                int i7 = $10 + 81;
                $11 = i7 % 128;
                if (i7 % i2 == 0) {
                    try {
                        Object[] objArr2 = new Object[1];
                        objArr2[i5] = Integer.valueOf(cArr4[i6]);
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(115862995);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) i4;
                            byte b2 = (byte) (b + 1);
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(26 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) View.resolveSize(i5, i5), 1041 - (KeyEvent.getMaxKeyCode() >> 16), -1719489573, false, $$g(b, b2, b2), new Class[]{Integer.TYPE});
                        }
                        cArr5[i6] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } else {
                    Object[] objArr3 = {Integer.valueOf(cArr4[i6])};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(115862995);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) (-1);
                        byte b4 = (byte) (b3 + 1);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(TextUtils.getOffsetBefore("", 0) + 26, (char) (ViewConfiguration.getPressedStateDuration() >> 16), 1041 - TextUtils.getOffsetBefore("", 0), -1719489573, false, $$g(b3, b4, b4), new Class[]{Integer.TYPE});
                    }
                    cArr5[i6] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                    i6++;
                }
                i2 = 2;
                i4 = -1;
                i5 = 0;
            }
            cArr4 = cArr5;
        }
        Object[] objArr4 = {Integer.valueOf(warmup)};
        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1820173622);
        if (objAccessartificialFrame3 == null) {
            byte b5 = (byte) (-1);
            byte b6 = (byte) (b5 + 1);
            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(15 - TextUtils.getOffsetBefore("", 0), (char) (20488 - KeyEvent.normalizeMetaState(0)), Color.green(0) + 2148, 216472770, false, $$g(b5, b6, (byte) (b6 | 54)), new Class[]{Integer.TYPE});
        }
        int iIntValue = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
        if (ICustomTabsServiceDefault) {
            int i8 = $10 + 79;
            $11 = i8 % 128;
            if (i8 % 2 == 0) {
                onmessagechannelready.c = bArr.length;
                cArr3 = new char[onmessagechannelready.c];
                onmessagechannelready.a = 1;
            } else {
                onmessagechannelready.c = bArr.length;
                cArr3 = new char[onmessagechannelready.c];
                onmessagechannelready.a = 0;
            }
            while (onmessagechannelready.a < onmessagechannelready.c) {
                cArr3[onmessagechannelready.a] = (char) (cArr4[bArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] + i] - iIntValue);
                Object[] objArr5 = {onmessagechannelready, onmessagechannelready};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                if (objAccessartificialFrame4 == null) {
                    byte b7 = (byte) (-1);
                    byte b8 = (byte) (b7 + 1);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(21 - (ViewConfiguration.getScrollBarSize() >> 8), (char) (59173 - ((byte) KeyEvent.getModifierMetaStateMask())), 1943 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 481771537, false, $$g(b7, b8, (byte) (b8 | 55)), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
            }
            objArr[0] = new String(cArr3);
            return;
        }
        if (requestPostMessageChannelWithExtras) {
            int i9 = $11 + 55;
            $10 = i9 % 128;
            if (i9 % 2 != 0) {
                onmessagechannelready.c = cArr.length;
                cArr2 = new char[onmessagechannelready.c];
                onmessagechannelready.a = 1;
            } else {
                onmessagechannelready.c = cArr.length;
                cArr2 = new char[onmessagechannelready.c];
                onmessagechannelready.a = 0;
            }
            while (onmessagechannelready.a < onmessagechannelready.c) {
                cArr2[onmessagechannelready.a] = (char) (cArr4[cArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                Object[] objArr6 = {onmessagechannelready, onmessagechannelready};
                Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                if (objAccessartificialFrame5 == null) {
                    byte b9 = (byte) (-1);
                    byte b10 = (byte) (b9 + 1);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(21 - TextUtils.getOffsetBefore("", 0), (char) (59174 - TextUtils.getTrimmedLength("")), TextUtils.getTrimmedLength("") + 1943, 481771537, false, $$g(b9, b10, (byte) (b10 | 55)), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame5).invoke(null, objArr6);
            }
            objArr[0] = new String(cArr2);
            return;
        }
        int i10 = 0;
        onmessagechannelready.c = iArr.length;
        char[] cArr6 = new char[onmessagechannelready.c];
        while (true) {
            onmessagechannelready.a = i10;
            if (onmessagechannelready.a >= onmessagechannelready.c) {
                objArr[0] = new String(cArr6);
                return;
            } else {
                cArr6[onmessagechannelready.a] = (char) (cArr4[iArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                i10 = onmessagechannelready.a + 1;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:137:0x0e39  */
    /* JADX WARN: Code duplicated, block: B:141:0x0ec1  */
    /* JADX WARN: Code duplicated, block: B:146:0x0f2d  */
    /* JADX WARN: Code duplicated, block: B:245:0x1a65  */
    /* JADX WARN: Code duplicated, block: B:248:0x1a96 A[Catch: all -> 0x21ac, TryCatch #9 {all -> 0x21ac, blocks: (B:307:0x2030, B:309:0x203d, B:310:0x2062, B:312:0x206c, B:314:0x2079, B:315:0x20a8, B:246:0x1a82, B:248:0x1a96, B:249:0x1ac0, B:206:0x15fa, B:208:0x1600, B:209:0x162d, B:211:0x1655, B:212:0x16e4, B:101:0x0a61, B:103:0x0a82, B:104:0x0ad2), top: B:363:0x0a61 }] */
    /* JADX WARN: Code duplicated, block: B:252:0x1ad6  */
    /* JADX WARN: Code duplicated, block: B:257:0x1b42  */
    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public boolean onCreate() throws Throwable {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        Object objAccessartificialFrame;
        Object objAccessartificialFrame2;
        Object[] objArr5;
        Object[] objArr6;
        Object objAccessartificialFrame3;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object objAccessartificialFrame4;
        Object objAccessartificialFrame5;
        Object[] objArr7;
        int i = 2 % 2;
        Object[] objArr8 = new Object[1];
        a(127 - Color.argb(0, 0, 0, 0), new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr8);
        String str = (String) objArr8[0];
        Object[] objArr9 = new Object[1];
        a(TextUtils.indexOf("", "", 0) + 127, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, null, null, objArr9);
        String str2 = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        a(127 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), new byte[]{-115, -116, -117, -120, -118, -119, -121, -102, -126, -127, -113, -121, -127, -107, -127, -103}, null, null, objArr10);
        String str3 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        a(TextUtils.indexOf("", "", 0, 0) + 127, new byte[]{-116, -125, -123, -114, -105, -120, -127, -101, -118, -117, -122, -117, -126, -116, -125, -122}, null, null, objArr11);
        String str4 = (String) objArr11[0];
        Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame6 == null) {
            int iIndexOf = 20 - TextUtils.indexOf((CharSequence) "", '0');
            char cIndexOf = (char) TextUtils.indexOf("", "", 0, 0);
            int edgeSlop = 465 - (ViewConfiguration.getEdgeSlop() >> 16);
            byte[] bArr = $$a;
            byte b = bArr[5];
            Object[] objArr12 = new Object[1];
            b(b, (byte) (b & 47), bArr[51], objArr12);
            objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iIndexOf, cIndexOf, edgeSlop, -785931255, false, (String) objArr12[0], null);
        }
        long j = ((Field) objAccessartificialFrame6).getLong(null);
        if (j == -1 || j + 1886 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr13 = new Object[1];
            a(127 - TextUtils.indexOf("", "", 0, 0), new byte[]{-125, -127, -116, -124, -105, -106, -118, -117, -122, -107, -122, -117, -112, -108, -121, -110, -110, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr13);
            Class<?> cls = Class.forName((String) objArr13[0]);
            Object[] objArr14 = new Object[1];
            a(128 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), new byte[]{-126, -123, -122, -117, -127, -112, -122, -113, -110, -110, -108, -117, -126, -116, -124, -124, -104, -112}, null, null, objArr14);
            Context applicationContext = (Context) cls.getMethod((String) objArr14[0], new Class[0]).invoke(null, null);
            if (applicationContext != null) {
                applicationContext = ((applicationContext instanceof ContextWrapper) && ((ContextWrapper) applicationContext).getBaseContext() == null) ? null : applicationContext.getApplicationContext();
            }
            int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr15 = new Object[1];
            a(127 - KeyEvent.normalizeMetaState(0), new byte[]{-96, -125, -112, -98, -116, -127, -112, -93, -127, -92, -90, -95, -98, -127, -127, -100, -93, -112, -90, -91, -94, -100, -112, -93, -100, -95, -100, -91, -125, -94, -94, -100, -100, -116, -91, -125, -93, -96, -127, -98, -100, -91, -95, -94, -94, -92, -125, -116, -100, -91, -92, -93, -127, -94, -95, -112, -98, -100, -116, -96, -97, -98, -99, -100}, null, null, objArr15);
            String str5 = (String) objArr15[0];
            Object[] objArr16 = new Object[1];
            a(127 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), new byte[]{-116, -100, -127, -93, -96, -91, -127, -89, -92, -92, -116, -89, -100, -127, -96, -98, -97, -98, -93, -96, -97, -94, -97, -95, -94, -116, -127, -94, -97, -97, -96, -94, -97, -89, -94, -125, -97, -92, -90, -95, -127, -94, -100, -127, -116, -99, -92, -96, -95, -125, -96, -92, -89, -94, -95, -99, -90, -93, -100, -116, -116, -116, -98, -94}, null, null, objArr16);
            try {
                Object[] objArr17 = {applicationContext, new String[]{str5, (String) objArr16[0]}, Integer.valueOf(iIntValue), 1, -929557793};
                byte[] bArr2 = $$d;
                Object[] objArr18 = new Object[1];
                c((short) 615, bArr2[89], bArr2[46], objArr18);
                Class<?> cls2 = Class.forName((String) objArr18[0]);
                byte b2 = bArr2[162];
                Object[] objArr19 = new Object[1];
                c((short) 566, b2, b2, objArr19);
                objArr = (Object[]) cls2.getMethod((String) objArr19[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr17);
                int i2 = ((int[]) objArr[0])[0];
                int i3 = ((int[]) objArr[3])[0];
                if (applicationContext != null) {
                    Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(1142731807);
                    if (objAccessartificialFrame7 == null) {
                        int i4 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 21;
                        char doubleTapTimeout = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                        int mode = View.MeasureSpec.getMode(0) + 465;
                        byte[] bArr3 = $$a;
                        byte b3 = (byte) (-bArr3[11]);
                        Object[] objArr20 = new Object[1];
                        b(b3, (byte) (b3 | 40), bArr3[51], objArr20);
                        objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(i4, doubleTapTimeout, mode, -612765161, false, (String) objArr20[0], null);
                    }
                    ((Field) objAccessartificialFrame7).set(null, objArr);
                    try {
                        Long lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(1313006081);
                        if (objAccessartificialFrame8 == null) {
                            int i5 = 22 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                            char c = (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1);
                            int defaultSize = 465 - View.getDefaultSize(0, 0);
                            byte[] bArr4 = $$a;
                            byte b4 = bArr4[5];
                            Object[] objArr21 = new Object[1];
                            b(b4, (byte) (b4 & 47), bArr4[51], objArr21);
                            objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i5, c, defaultSize, -785931255, false, (String) objArr21[0], null);
                        }
                        ((Field) objAccessartificialFrame8).set(null, lValueOf);
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
            int i6 = artificialFrame + 21;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i6 % 128;
            int i7 = i6 % 2;
            Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(1142731807);
            if (objAccessartificialFrame9 == null) {
                int trimmedLength = TextUtils.getTrimmedLength("") + 21;
                char c2 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                int iRgb = (-16776751) - Color.rgb(0, 0, 0);
                byte[] bArr5 = $$a;
                byte b5 = (byte) (-bArr5[11]);
                Object[] objArr22 = new Object[1];
                b(b5, (byte) (b5 | 40), bArr5[51], objArr22);
                objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(trimmedLength, c2, iRgb, -612765161, false, (String) objArr22[0], null);
            }
            Object[] objArr23 = (Object[]) ((Field) objAccessartificialFrame9).get(null);
            objArr = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
            int i8 = ((int[]) objArr23[3])[0];
            int i9 = ((int[]) objArr23[0])[0];
            String[] strArr = (String[]) objArr23[1];
            int iIdentityHashCode = System.identityHashCode(this);
            int i10 = ~iIdentityHashCode;
            int i11 = (((1487302125 + ((~(539165151 | i10)) * (-560))) + ((~(iIdentityHashCode | 917980127)) * (-560))) + (((~((-378815426) | i10)) | 449) * 560)) - 929557793;
            int i12 = i11 ^ (i11 << 13);
            int i13 = i12 ^ (i12 >>> 17);
            ((int[]) objArr[2])[0] = i13 ^ (i13 << 5);
        }
        int i14 = ((int[]) objArr[0])[0];
        int i15 = ((int[]) objArr[3])[0];
        if (i15 == i14) {
            Object[] objArr24 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i16 = ((int[]) objArr[2])[0];
            int i17 = ((int[]) objArr[3])[0];
            int i18 = ((int[]) objArr[0])[0];
            String[] strArr2 = (String[]) objArr[1];
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i19 = ~iIdentityHashCode2;
            int i20 = i16 + (-800143894) + (((-110232677) | i19) * (-369)) + (((~((-405654172) | i19)) | (-245304446)) * (-369)) + (((~(iIdentityHashCode2 | 405654171)) | (-515886848) | (~(i19 | (-135071770)))) * 369);
            int i21 = (i20 << 13) ^ i20;
            int i22 = i21 ^ (i21 >>> 17);
            ((int[]) objArr24[2])[0] = i22 ^ (i22 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr[1];
            if (strArr3 != null) {
                for (String str6 : strArr3) {
                    arrayList.add(str6);
                }
            }
            try {
                Object[] objArr25 = {Long.valueOf((((long) (-295502135)) << 32) ^ ((long) (i14 ^ i15))), Long.valueOf(-295502199)};
                byte[] bArr6 = $$d;
                Object[] objArr26 = new Object[1];
                c((short) 546, bArr6[89], bArr6[25], objArr26);
                Class<?> cls3 = Class.forName((String) objArr26[0]);
                byte b6 = bArr6[88];
                Object[] objArr27 = new Object[1];
                c((short) 481, b6, (byte) (b6 | 79), objArr27);
                cls3.getMethod((String) objArr27[0], Long.TYPE, Long.TYPE).invoke(null, objArr25);
                Object[] objArr28 = {new int[]{i}, strArr, new int[1], new int[]{i}};
                int i23 = ((int[]) objArr[2])[0];
                int i24 = ((int[]) objArr[3])[0];
                int i25 = ((int[]) objArr[0])[0];
                String[] strArr4 = (String[]) objArr[1];
                int iIdentityHashCode3 = System.identityHashCode(this);
                int i26 = i23 + 674269448 + (((~((-621579439) | iIdentityHashCode3)) | 603979822) * 345) + (((~((-621579439) | (~iIdentityHashCode3))) | (-1065209535)) * 345) + ((~(iIdentityHashCode3 | (-603979823))) * 345);
                int i27 = (i26 << 13) ^ i26;
                int i28 = i27 ^ (i27 >>> 17);
                ((int[]) objArr28[2])[0] = i28 ^ (i28 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 != null) {
                    throw cause2;
                }
                throw th2;
            }
        }
        Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame10 == null) {
            int iMyPid = 30 - (Process.myPid() >> 22);
            char edgeSlop2 = (char) ((ViewConfiguration.getEdgeSlop() >> 16) + 49362);
            int iArgb = Color.argb(0, 0, 0, 0) + 684;
            byte[] bArr7 = $$a;
            Object[] objArr29 = new Object[1];
            b(bArr7[19], (byte) ($$b + 5), bArr7[113], objArr29);
            objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iMyPid, edgeSlop2, iArgb, 752929587, false, (String) objArr29[0], null);
        }
        long j2 = ((Field) objAccessartificialFrame10).getLong(null);
        if (j2 == -1 || j2 + 2045 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr30 = new Object[1];
            a((ViewConfiguration.getTouchSlop() >> 8) + 127, new byte[]{-125, -127, -116, -124, -105, -106, -118, -117, -122, -107, -122, -117, -112, -108, -121, -110, -110, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr30);
            Class<?> cls4 = Class.forName((String) objArr30[0]);
            Object[] objArr31 = new Object[1];
            a(TextUtils.indexOf("", "") + 127, new byte[]{-126, -123, -122, -117, -127, -112, -122, -113, -110, -110, -108, -117, -126, -116, -124, -124, -104, -112}, null, null, objArr31);
            Context applicationContext2 = (Context) cls4.getMethod((String) objArr31[0], new Class[0]).invoke(null, null);
            if (applicationContext2 != null) {
                applicationContext2 = ((applicationContext2 instanceof ContextWrapper) && ((ContextWrapper) applicationContext2).getBaseContext() == null) ? null : applicationContext2.getApplicationContext();
            }
            Object[] objArr32 = {applicationContext2, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1094604658};
            byte[] bArr8 = $$d;
            Object[] objArr33 = new Object[1];
            c((short) 479, bArr8[117], bArr8[106], objArr33);
            Class<?> cls5 = Class.forName((String) objArr33[0]);
            Object[] objArr34 = new Object[1];
            c((short) ($$e | 256), bArr8[130], bArr8[6], objArr34);
            objArr2 = (Object[]) cls5.getMethod((String) objArr34[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr32);
            if (applicationContext2 != null) {
                Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-326560385);
                if (objAccessartificialFrame11 == null) {
                    int i29 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 29;
                    char c3 = (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 49361);
                    int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 684;
                    byte[] bArr9 = $$a;
                    Object[] objArr35 = new Object[1];
                    b((byte) (bArr9[96] + 1), (byte) ($$b - 2), bArr9[113], objArr35);
                    objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(i29, c3, keyRepeatDelay, 1944867703, false, (String) objArr35[0], null);
                }
                ((Field) objAccessartificialFrame11).set(null, objArr2);
                try {
                    Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                    if (objAccessartificialFrame12 == null) {
                        int i30 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 29;
                        char c4 = (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 49361);
                        int iArgb2 = 684 - Color.argb(0, 0, 0, 0);
                        byte[] bArr10 = $$a;
                        Object[] objArr36 = new Object[1];
                        b(bArr10[19], (byte) ($$b + 5), bArr10[113], objArr36);
                        objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(i30, c4, iArgb2, 752929587, false, (String) objArr36[0], null);
                    }
                    ((Field) objAccessartificialFrame12).set(null, lValueOf2);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-326560385);
            if (objAccessartificialFrame13 == null) {
                int modifierMetaStateMask = 29 - ((byte) KeyEvent.getModifierMetaStateMask());
                char c5 = (char) (49363 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                int scrollDefaultDelay = 684 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                byte[] bArr11 = $$a;
                Object[] objArr37 = new Object[1];
                b((byte) (bArr11[96] + 1), (byte) ($$b - 2), bArr11[113], objArr37);
                objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask, c5, scrollDefaultDelay, 1944867703, false, (String) objArr37[0], null);
            }
            Object[] objArr38 = (Object[]) ((Field) objAccessartificialFrame13).get(null);
            objArr2 = new Object[]{new int[]{((int[]) objArr38[0])[0]}, new int[]{((int[]) objArr38[1])[0]}, new int[1], (String) objArr38[3]};
            int iIdentityHashCode4 = System.identityHashCode(this);
            int i31 = ~iIdentityHashCode4;
            int i32 = (-1508821074) + (((~((-48599408) | i31)) | 40173871 | (~((-930024368) | i31))) * (-1136)) + (((~((-48599408) | iIdentityHashCode4)) | (~((-930024368) | iIdentityHashCode4)) | (~(938449903 | i31))) * (-568)) + (((~(iIdentityHashCode4 | (-40173872))) | (~(i31 | 930024367)) | (~(48599407 | i31))) * 568) + 1094604658;
            int i33 = (i32 << 13) ^ i32;
            int i34 = i33 ^ (i33 >>> 17);
            ((int[]) objArr2[2])[0] = i34 ^ (i34 << 5);
        }
        int i35 = ((int[]) objArr2[1])[0];
        int i36 = ((int[]) objArr2[0])[0];
        if (i36 == i35) {
            int i37 = ((int[]) objArr2[2])[0];
            Object[] objArr39 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int startUptimeMillis = (int) Process.getStartUptimeMillis();
            int i38 = i37 + ((((-507046658) + (((~((-226061115) | startUptimeMillis)) | 207167776) * 1504)) + ((~(startUptimeMillis | (-18893339))) * (-1504))) - 857019360);
            int i39 = (i38 << 13) ^ i38;
            int i40 = i39 ^ (i39 >>> 17);
            ((int[]) objArr39[2])[0] = i40 ^ (i40 << 5);
        } else {
            long j3 = (((long) 1768349948) << 32) ^ ((long) (i35 ^ i36));
            long j4 = 1768349944;
            int i41 = artificialFrame + 81;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i41 % 128;
            int i42 = i41 % 2;
            Object[] objArr40 = {Long.valueOf(j3), Long.valueOf(j4)};
            byte[] bArr12 = $$d;
            Object[] objArr41 = new Object[1];
            c((short) 419, bArr12[89], (byte) (-bArr12[56]), objArr41);
            Class<?> cls6 = Class.forName((String) objArr41[0]);
            byte b7 = bArr12[88];
            Object[] objArr42 = new Object[1];
            c((short) 481, b7, (byte) (b7 | 79), objArr42);
            cls6.getMethod((String) objArr42[0], Long.TYPE, Long.TYPE).invoke(null, objArr40);
            int i43 = ((int[]) objArr2[2])[0];
            Object[] objArr43 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int iIdentityHashCode5 = System.identityHashCode(this);
            int i44 = ~((-67656727) | iIdentityHashCode5);
            int i45 = i43 + 2047037206 + ((539099400 | i44) * (-476)) + (i44 * 952) + ((~((~iIdentityHashCode5) | (-67656727))) * 476);
            int i46 = (i45 << 13) ^ i45;
            int i47 = i46 ^ (i46 >>> 17);
            ((int[]) objArr43[2])[0] = i47 ^ (i47 << 5);
        }
        Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame14 == null) {
            int i48 = 26 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
            char packedPositionChild = (char) (30067 - ExpandableListView.getPackedPositionChild(0L));
            int iArgb3 = 816 - Color.argb(0, 0, 0, 0);
            byte[] bArr13 = $$a;
            byte b8 = bArr13[5];
            Object[] objArr44 = new Object[1];
            b(b8, (byte) (b8 & 47), bArr13[51], objArr44);
            objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(i48, packedPositionChild, iArgb3, 721586079, false, (String) objArr44[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame14).getLong(null);
        if (j5 == -1 || j5 + 1950 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            try {
                Object[] objArr45 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1032001901};
                Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame15 == null) {
                    int minimumFlingVelocity = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 25;
                    char absoluteGravity = (char) (Gravity.getAbsoluteGravity(0, 0) + 30068);
                    int mirror = AndroidCharacter.getMirror('0') + 768;
                    byte b9 = (byte) ($$b + 5);
                    byte[] bArr14 = $$a;
                    Object[] objArr46 = new Object[1];
                    b(b9, bArr14[26], bArr14[3], objArr46);
                    objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity, absoluteGravity, mirror, -797394565, false, (String) objArr46[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr3 = (Object[]) ((Method) objAccessartificialFrame15).invoke(null, objArr45);
                Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame16 == null) {
                    int iCombineMeasuredStates = 25 - View.combineMeasuredStates(0, 0);
                    char bitsPerPixel = (char) (30067 - ImageFormat.getBitsPerPixel(0));
                    int iIndexOf2 = 816 - TextUtils.indexOf("", "", 0, 0);
                    byte[] bArr15 = $$a;
                    byte b10 = (byte) (-bArr15[11]);
                    Object[] objArr47 = new Object[1];
                    b(b10, (byte) (b10 | 40), bArr15[51], objArr47);
                    objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates, bitsPerPixel, iIndexOf2, 891606461, false, (String) objArr47[0], null);
                }
                ((Field) objAccessartificialFrame16).set(null, objArr3);
                try {
                    Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame17 == null) {
                        int i49 = 26 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                        char cRed = (char) (30068 - Color.red(0));
                        int defaultSize2 = View.getDefaultSize(0, 0) + 816;
                        byte[] bArr16 = $$a;
                        byte b11 = bArr16[5];
                        Object[] objArr48 = new Object[1];
                        b(b11, (byte) (b11 & 47), bArr16[51], objArr48);
                        objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(i49, cRed, defaultSize2, 721586079, false, (String) objArr48[0], null);
                    }
                    ((Field) objAccessartificialFrame17).set(null, lValueOf3);
                } catch (Exception unused3) {
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
            Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame18 == null) {
                int longPressTimeout = 25 - (ViewConfiguration.getLongPressTimeout() >> 16);
                char cIndexOf2 = (char) (TextUtils.indexOf("", "") + 30068);
                int deadChar = 816 - KeyEvent.getDeadChar(0, 0);
                byte[] bArr17 = $$a;
                byte b12 = (byte) (-bArr17[11]);
                Object[] objArr49 = new Object[1];
                b(b12, (byte) (b12 | 40), bArr17[51], objArr49);
                objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(longPressTimeout, cIndexOf2, deadChar, 891606461, false, (String) objArr49[0], null);
            }
            Object[] objArr50 = (Object[]) ((Field) objAccessartificialFrame18).get(null);
            objArr3 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i50 = ((int[]) objArr50[0])[0];
            int i51 = ((int[]) objArr50[1])[0];
            String[] strArr5 = (String[]) objArr50[2];
            int iUptimeMillis = (int) SystemClock.uptimeMillis();
            int i52 = ~iUptimeMillis;
            int i53 = (-1989647674) + (((~(504352565 | i52)) | (~((-369115445) | iUptimeMillis))) * (-831)) + ((~(1071640375 | iUptimeMillis)) * (-1662)) + (((~(iUptimeMillis | (-504352566))) | (~(i52 | (-702524932))) | (~(702524931 | iUptimeMillis))) * 831) + 1032001901;
            int i54 = (i53 << 13) ^ i53;
            int i55 = i54 ^ (i54 >>> 17);
            ((int[]) objArr3[3])[0] = i55 ^ (i55 << 5);
        }
        int i56 = ((int[]) objArr3[1])[0];
        int i57 = ((int[]) objArr3[0])[0];
        if (i57 == i56) {
            int i58 = artificialFrame + 31;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i58 % 128;
            int i59 = i58 % 2;
            Object[] objArr51 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i60 = ((int[]) objArr3[3])[0];
            int i61 = ((int[]) objArr3[0])[0];
            int i62 = ((int[]) objArr3[1])[0];
            String[] strArr6 = (String[]) objArr3[2];
            int iIdentityHashCode6 = System.identityHashCode(this);
            int i63 = i60 + 1073861177 + (((~(iIdentityHashCode6 | (-43035257))) | (-241207623)) * (-465)) + (((-43035257) | (~((-241207623) | iIdentityHashCode6))) * 930) + ((iIdentityHashCode6 | (-33589313)) * 465);
            int i64 = (i63 << 13) ^ i63;
            int i65 = i64 ^ (i64 >>> 17);
            ((int[]) objArr51[3])[0] = i65 ^ (i65 << 5);
        } else {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr7 = (String[]) objArr3[2];
            if (strArr7 != null) {
                int i66 = getARTIFICIAL_FRAME_PACKAGE_NAME + 83;
                artificialFrame = i66 % 128;
                int i67 = i66 % 2;
                for (String str7 : strArr7) {
                    arrayList2.add(str7);
                }
            }
            Object[] objArr52 = {Long.valueOf((((long) 312625439) << 32) ^ ((long) (i56 ^ i57))), Long.valueOf(312625438)};
            byte[] bArr18 = $$d;
            Object[] objArr53 = new Object[1];
            c((short) 353, bArr18[89], bArr18[88], objArr53);
            Class<?> cls7 = Class.forName((String) objArr53[0]);
            byte b13 = bArr18[88];
            Object[] objArr54 = new Object[1];
            c((short) 481, b13, (byte) (b13 | 79), objArr54);
            cls7.getMethod((String) objArr54[0], Long.TYPE, Long.TYPE).invoke(null, objArr52);
            Object[] objArr55 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i68 = ((int[]) objArr3[3])[0];
            int i69 = ((int[]) objArr3[0])[0];
            int i70 = ((int[]) objArr3[1])[0];
            String[] strArr8 = (String[]) objArr3[2];
            int iNextInt = new Random().nextInt(724980205);
            int i71 = i68 + ((((-2142914385) + (((~iNextInt) | 67108880) * 1324)) + (((~(iNextInt | 71949365)) | (~(126223000 | iNextInt))) * (-1324))) - 611724450);
            int i72 = (i71 << 13) ^ i71;
            int i73 = i72 ^ (i72 >>> 17);
            ((int[]) objArr55[3])[0] = i73 ^ (i73 << 5);
        }
        Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame19 == null) {
            int iMakeMeasureSpec = 30 - View.MeasureSpec.makeMeasureSpec(0, 0);
            char c6 = (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 49361);
            int gidForName = Process.getGidForName("") + 685;
            int i74 = $$b;
            Object[] objArr56 = new Object[1];
            b((byte) (i74 | 16), (byte) (i74 - 2), $$a[4], objArr56);
            objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec, c6, gidForName, -1583976536, false, (String) objArr56[0], null);
        }
        long j6 = ((Field) objAccessartificialFrame19).getLong(null);
        if (j6 != -1) {
            int i75 = getARTIFICIAL_FRAME_PACKAGE_NAME + 25;
            artificialFrame = i75 % 128;
            int i76 = i75 % 2;
            if (j6 + 1874 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame20 == null) {
                    int capsMode = 30 - TextUtils.getCapsMode("", 0, 0);
                    char threadPriority = (char) (49362 - ((Process.getThreadPriority(0) + 20) >> 6));
                    int threadPriority2 = 684 - ((Process.getThreadPriority(0) + 20) >> 6);
                    Object[] objArr57 = new Object[1];
                    b((byte) 68, (byte) $$b, $$a[51], objArr57);
                    objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(capsMode, threadPriority, threadPriority2, -1456483158, false, (String) objArr57[0], null);
                }
                Object[] objArr58 = (Object[]) ((Field) objAccessartificialFrame20).get(null);
                objArr4 = new Object[]{new int[]{((int[]) objArr58[0])[0]}, new int[]{((int[]) objArr58[1])[0]}, new int[1], (String) objArr58[3]};
                int iMyUid = Process.myUid();
                int i77 = ~iMyUid;
                int i78 = (-1687235878) + (((~(609696720 | i77)) | 296239118) * (-1188));
                int i79 = (~(iMyUid | (-609696721))) | 296239118;
                int i80 = ~(368927054 | i77);
                int i81 = i78 + ((i79 | i80) * 594) + (((~((-609696721) | i77)) | 537008784 | i80) * 594) + 1077749052;
                int i82 = (i81 << 13) ^ i81;
                int i83 = i82 ^ (i82 >>> 17);
                ((int[]) objArr4[2])[0] = i83 ^ (i83 << 5);
            } else {
                int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                int i84 = artificialFrame + 65;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i84 % 128;
                int i85 = i84 % 2;
                Object[] objArr59 = {Integer.valueOf(iIntValue2), 1077749052};
                byte[] bArr19 = $$d;
                Object[] objArr60 = new Object[1];
                c((short) 272, bArr19[89], bArr19[109], objArr60);
                Class<?> cls8 = Class.forName((String) objArr60[0]);
                short s = (short) MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR;
                byte b14 = bArr19[89];
                Object[] objArr61 = new Object[1];
                c(s, b14, (byte) (b14 + 2), objArr61);
                objArr4 = (Object[]) cls8.getMethod((String) objArr61[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr59);
                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame == null) {
                    int i86 = 31 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                    char pressedStateDuration = (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 49362);
                    int iBlue = Color.blue(0) + 684;
                    Object[] objArr62 = new Object[1];
                    b((byte) 68, (byte) $$b, $$a[51], objArr62);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i86, pressedStateDuration, iBlue, -1456483158, false, (String) objArr62[0], null);
                }
                ((Field) objAccessartificialFrame).set(null, objArr4);
                try {
                    Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1056123296);
                    if (objAccessartificialFrame2 == null) {
                        int absoluteGravity2 = Gravity.getAbsoluteGravity(0, 0) + 30;
                        char c7 = (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 49361);
                        int packedPositionType = 684 - ExpandableListView.getPackedPositionType(0L);
                        int i87 = $$b;
                        Object[] objArr63 = new Object[1];
                        b((byte) (i87 | 16), (byte) (i87 - 2), $$a[4], objArr63);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(absoluteGravity2, c7, packedPositionType, -1583976536, false, (String) objArr63[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, lValueOf4);
                } catch (Exception unused4) {
                    throw new RuntimeException();
                }
            }
        } else {
            int iIntValue3 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            int i88 = artificialFrame + 65;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i88 % 128;
            int i89 = i88 % 2;
            Object[] objArr510 = {Integer.valueOf(iIntValue3), 1077749052};
            byte[] bArr110 = $$d;
            Object[] objArr64 = new Object[1];
            c((short) 272, bArr110[89], bArr110[109], objArr64);
            Class<?> cls9 = Class.forName((String) objArr64[0]);
            short s2 = (short) MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR;
            byte b15 = bArr110[89];
            Object[] objArr65 = new Object[1];
            c(s2, b15, (byte) (b15 + 2), objArr65);
            objArr4 = (Object[]) cls9.getMethod((String) objArr65[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr510);
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame == null) {
                int i810 = 31 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                char pressedStateDuration2 = (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 49362);
                int iBlue2 = Color.blue(0) + 684;
                Object[] objArr66 = new Object[1];
                b((byte) 68, (byte) $$b, $$a[51], objArr66);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i810, pressedStateDuration2, iBlue2, -1456483158, false, (String) objArr66[0], null);
            }
            ((Field) objAccessartificialFrame).set(null, objArr4);
            Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1056123296);
            if (objAccessartificialFrame2 == null) {
                int absoluteGravity3 = Gravity.getAbsoluteGravity(0, 0) + 30;
                char c8 = (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 49361);
                int packedPositionType2 = 684 - ExpandableListView.getPackedPositionType(0L);
                int i811 = $$b;
                Object[] objArr67 = new Object[1];
                b((byte) (i811 | 16), (byte) (i811 - 2), $$a[4], objArr67);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(absoluteGravity3, c8, packedPositionType2, -1583976536, false, (String) objArr67[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, lValueOf5);
        }
        int i90 = ((int[]) objArr4[1])[0];
        int i91 = ((int[]) objArr4[0])[0];
        if (i91 == i90) {
            int i92 = ((int[]) objArr4[2])[0];
            Object[] objArr68 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
            int i93 = ~System.identityHashCode(this);
            int i94 = ~(490805465 | i93);
            int i95 = i92 + (-65189662) + ((i94 | 487818309) * 764) + (((~(i93 | 487818309)) | 4200600) * (-1528)) + ((5414044 | i94) * 764);
            int i96 = (i95 << 13) ^ i95;
            int i97 = i96 ^ (i96 >>> 17);
            ((int[]) objArr68[2])[0] = i97 ^ (i97 << 5);
        } else {
            new ArrayList().add((String) objArr4[3]);
            Object[] objArr69 = {Long.valueOf((((long) 890992301) << 32) ^ ((long) (i90 ^ i91))), Long.valueOf(890992317)};
            byte[] bArr20 = $$d;
            Object[] objArr70 = new Object[1];
            c((short) 189, bArr20[89], bArr20[531], objArr70);
            Class<?> cls10 = Class.forName((String) objArr70[0]);
            byte b16 = bArr20[88];
            Object[] objArr71 = new Object[1];
            c((short) 481, b16, (byte) (b16 | 79), objArr71);
            cls10.getMethod((String) objArr71[0], Long.TYPE, Long.TYPE).invoke(null, objArr69);
            int i98 = ((int[]) objArr4[2])[0];
            Object[] objArr72 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
            int iIdentityHashCode7 = System.identityHashCode(this);
            int i99 = ~iIdentityHashCode7;
            int i100 = i98 + 1234739574 + (((~(904888030 | i99)) | 73735744) * 220) + (((~(i99 | 342310466)) | 636313308) * (-440)) + ((iIdentityHashCode7 | 904888030) * 220);
            int i101 = (i100 << 13) ^ i100;
            int i102 = i101 ^ (i101 >>> 17);
            ((int[]) objArr72[2])[0] = i102 ^ (i102 << 5);
        }
        Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame21 == null) {
            int i103 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 29;
            char cCombineMeasuredStates = (char) (View.combineMeasuredStates(0, 0) + 49362);
            int iMyTid = 684 - (Process.myTid() >> 22);
            Object[] objArr73 = new Object[1];
            b((byte) 76, (byte) ($$b + 5), $$a[4], objArr73);
            objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(i103, cCombineMeasuredStates, iMyTid, 508509282, false, (String) objArr73[0], null);
        }
        long j7 = ((Field) objAccessartificialFrame21).getLong(null);
        if (j7 == -1 || j7 + 1875 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr74 = new Object[1];
            a(127 - (ViewConfiguration.getPressedStateDuration() >> 16), new byte[]{-125, -127, -116, -124, -105, -106, -118, -117, -122, -107, -122, -117, -112, -108, -121, -110, -110, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr74);
            Class<?> cls11 = Class.forName((String) objArr74[0]);
            Object[] objArr75 = new Object[1];
            a((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 127, new byte[]{-126, -123, -122, -117, -127, -112, -122, -113, -110, -110, -108, -117, -126, -116, -124, -124, -104, -112}, null, null, objArr75);
            Context applicationContext3 = (Context) cls11.getMethod((String) objArr75[0], new Class[0]).invoke(null, null);
            if (applicationContext3 != null) {
                applicationContext3 = ((applicationContext3 instanceof ContextWrapper) && ((ContextWrapper) applicationContext3).getBaseContext() == null) ? null : applicationContext3.getApplicationContext();
            }
            Object[] objArr76 = {applicationContext3, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 1055400378};
            byte[] bArr21 = $$d;
            Object[] objArr77 = new Object[1];
            c((short) 165, bArr21[97], (byte) (-bArr21[251]), objArr77);
            Class<?> cls12 = Class.forName((String) objArr77[0]);
            byte b17 = bArr21[162];
            Object[] objArr78 = new Object[1];
            c((short) 566, b17, b17, objArr78);
            objArr5 = (Object[]) cls12.getMethod((String) objArr78[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr76);
            if (applicationContext3 != null) {
                Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame22 == null) {
                    int pressedStateDuration3 = 30 - (ViewConfiguration.getPressedStateDuration() >> 16);
                    char packedPositionType3 = (char) (ExpandableListView.getPackedPositionType(0L) + 49362);
                    int longPressTimeout2 = (ViewConfiguration.getLongPressTimeout() >> 16) + 684;
                    byte[] bArr22 = $$a;
                    Object[] objArr79 = new Object[1];
                    b((byte) 88, bArr22[15], (byte) (bArr22[51] - 1), objArr79);
                    objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(pressedStateDuration3, packedPositionType3, longPressTimeout2, -1321816393, false, (String) objArr79[0], null);
                }
                ((Field) objAccessartificialFrame22).set(null, objArr5);
                try {
                    Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                    if (objAccessartificialFrame23 == null) {
                        int i104 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 29;
                        char cIndexOf3 = (char) (49361 - TextUtils.indexOf((CharSequence) "", '0'));
                        int trimmedLength2 = TextUtils.getTrimmedLength("") + 684;
                        Object[] objArr80 = new Object[1];
                        b((byte) 76, (byte) ($$b + 5), $$a[4], objArr80);
                        objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(i104, cIndexOf3, trimmedLength2, 508509282, false, (String) objArr80[0], null);
                    }
                    ((Field) objAccessartificialFrame23).set(null, lValueOf6);
                } catch (Exception unused5) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(777251007);
            if (objAccessartificialFrame24 == null) {
                int jumpTapTimeout = 30 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                char modifierMetaStateMask2 = (char) (49361 - ((byte) KeyEvent.getModifierMetaStateMask()));
                int iCombineMeasuredStates2 = 684 - View.combineMeasuredStates(0, 0);
                byte[] bArr23 = $$a;
                Object[] objArr81 = new Object[1];
                b((byte) 88, bArr23[15], (byte) (bArr23[51] - 1), objArr81);
                objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout, modifierMetaStateMask2, iCombineMeasuredStates2, -1321816393, false, (String) objArr81[0], null);
            }
            Object[] objArr82 = (Object[]) ((Field) objAccessartificialFrame24).get(null);
            objArr5 = new Object[]{new int[]{((int[]) objArr82[0])[0]}, new int[]{((int[]) objArr82[1])[0]}, new int[1], (String) objArr82[3]};
            int elapsedCpuTime = (int) Process.getElapsedCpuTime();
            int i105 = ~elapsedCpuTime;
            int i106 = 1578642166 + (((~((-186575663) | i105)) | 185901344 | (~((-792048113) | i105)) | (~(792722430 | elapsedCpuTime))) * (-84));
            int i107 = (~(elapsedCpuTime | (-792048113))) | 186575662;
            int i108 = ~(i105 | 792048112);
            int i109 = i106 + ((i107 | i108) * (-84)) + (((-792722431) | i108) * 84) + 1055400378;
            int i110 = (i109 << 13) ^ i109;
            int i111 = i110 ^ (i110 >>> 17);
            ((int[]) objArr5[2])[0] = i111 ^ (i111 << 5);
        }
        int i112 = ((int[]) objArr5[1])[0];
        int i113 = ((int[]) objArr5[0])[0];
        if (i113 == i112) {
            int i114 = ((int[]) objArr5[2])[0];
            Object[] objArr83 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int iIdentityHashCode8 = System.identityHashCode(this);
            int i115 = i114 + 2097223454 + (((~((-10617232) | (~iIdentityHashCode8))) | (-968006544)) * (-591)) + ((iIdentityHashCode8 | (-10617232)) * 591);
            int i116 = (i115 << 13) ^ i115;
            int i117 = i116 ^ (i116 >>> 17);
            ((int[]) objArr83[2])[0] = i117 ^ (i117 << 5);
        } else {
            Object[] objArr84 = {Long.valueOf((((long) 1619982791) << 32) ^ ((long) (i112 ^ i113))), Long.valueOf(1619983303)};
            byte[] bArr24 = $$d;
            byte b18 = bArr24[89];
            Object[] objArr85 = new Object[1];
            c((short) 123, b18, (byte) (b18 & 239), objArr85);
            Class<?> cls13 = Class.forName((String) objArr85[0]);
            byte b19 = bArr24[88];
            Object[] objArr86 = new Object[1];
            c((short) 481, b19, (byte) (b19 | 79), objArr86);
            cls13.getMethod((String) objArr86[0], Long.TYPE, Long.TYPE).invoke(null, objArr84);
            int i118 = ((int[]) objArr5[2])[0];
            Object[] objArr87 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
            int i119 = i118 + (-2014000914) + (((~((-566347736) | iMaxMemory)) | 8439111) * 104) + ((~((~iMaxMemory) | 970184663)) * (-104)) + ((iMaxMemory | 412276039) * 104);
            int i120 = (i119 << 13) ^ i119;
            int i121 = i120 ^ (i120 >>> 17);
            ((int[]) objArr87[2])[0] = i121 ^ (i121 << 5);
        }
        Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame25 == null) {
            int minimumFlingVelocity2 = 36 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
            char c9 = (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1);
            int i122 = 541 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
            byte[] bArr25 = $$a;
            byte b20 = bArr25[5];
            Object[] objArr88 = new Object[1];
            b(b20, (byte) (b20 & 47), bArr25[51], objArr88);
            objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity2, c9, i122, 624296913, false, (String) objArr88[0], null);
        }
        long j8 = ((Field) objAccessartificialFrame25).getLong(null);
        if (j8 == -1 || j8 + 2016 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(-1717965552);
            if (objAccessartificialFrame26 == null) {
                objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(20 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (ExpandableListView.getPackedPositionType(0L) + 39516), Drawable.resolveOpacity(0, 0) + 982, 117222168, false, null, new Class[0]);
            }
            Object[] objArr89 = {null, ((Constructor) objAccessartificialFrame26).newInstance(null), 892478804, 0};
            Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(-501205803);
            if (objAccessartificialFrame27 == null) {
                int pressedStateDuration4 = 36 - (ViewConfiguration.getPressedStateDuration() >> 16);
                char maxKeyCode = (char) (KeyEvent.getMaxKeyCode() >> 16);
                int i123 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 539;
                byte[] bArr26 = $$a;
                Object[] objArr90 = new Object[1];
                b((byte) (bArr26[0] - 1), (byte) (bArr26[51] - 1), bArr26[39], objArr90);
                objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(pressedStateDuration4, maxKeyCode, i123, 2101703389, false, (String) objArr90[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 54, (char) (833 - View.resolveSizeAndState(0, 0, 0)), KeyEvent.normalizeMetaState(0) + 576), (Class) ArtificialStackFrames.coroutineCreation(54 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) (ViewConfiguration.getLongPressTimeout() >> 16), 630 - (KeyEvent.getMaxKeyCode() >> 16)), Integer.TYPE, Integer.TYPE});
            }
            objArr6 = (Object[]) ((Method) objAccessartificialFrame27).invoke(null, objArr89);
            Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame28 == null) {
                int i124 = 37 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                char cIndexOf4 = (char) TextUtils.indexOf("", "", 0, 0);
                int iIndexOf3 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 541;
                byte[] bArr27 = $$a;
                byte b21 = (byte) (-bArr27[11]);
                Object[] objArr91 = new Object[1];
                b(b21, (byte) (b21 | 40), bArr27[51], objArr91);
                objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(i124, cIndexOf4, iIndexOf3, 793268735, false, (String) objArr91[0], null);
            }
            ((Field) objAccessartificialFrame28).set(null, objArr6);
            try {
                Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                if (objAccessartificialFrame29 == null) {
                    int i125 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 37;
                    char scrollBarFadeDuration = (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    int edgeSlop3 = 540 - (ViewConfiguration.getEdgeSlop() >> 16);
                    byte[] bArr28 = $$a;
                    byte b22 = bArr28[5];
                    Object[] objArr92 = new Object[1];
                    b(b22, (byte) (b22 & 47), bArr28[51], objArr92);
                    objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(i125, scrollBarFadeDuration, edgeSlop3, 624296913, false, (String) objArr92[0], null);
                }
                ((Field) objAccessartificialFrame29).set(null, lValueOf7);
            } catch (Exception unused6) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame30 == null) {
                int i126 = 36 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                char scrollDefaultDelay2 = (char) (ViewConfiguration.getScrollDefaultDelay() >> 16);
                int iLastIndexOf = TextUtils.lastIndexOf("", '0', 0) + 541;
                byte[] bArr29 = $$a;
                byte b23 = (byte) (-bArr29[11]);
                Object[] objArr93 = new Object[1];
                b(b23, (byte) (b23 | 40), bArr29[51], objArr93);
                objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(i126, scrollDefaultDelay2, iLastIndexOf, 793268735, false, (String) objArr93[0], null);
            }
            Object[] objArr94 = (Object[]) ((Field) objAccessartificialFrame30).get(null);
            objArr6 = new Object[]{new int[1], new int[1], new int[1]};
            int i127 = ((int[]) objArr94[2])[0];
            int i128 = ((int[]) objArr94[1])[0];
            ((int[]) objArr6[2])[0] = i127;
            ((int[]) objArr6[1])[0] = i128;
            int iIdentityHashCode9 = System.identityHashCode(this);
            int i129 = (((-68778521) + (((~iIdentityHashCode9) | 277880838) * 1324)) + (((~(iIdentityHashCode9 | 431808519)) | (~(919813230 | iIdentityHashCode9))) * (-1324))) - 529130278;
            int i130 = (i129 << 13) ^ i129;
            int i131 = i130 ^ (i130 >>> 17);
            ((int[]) objArr6[0])[0] = i131 ^ (i131 << 5);
        }
        Object obj = objArr6[1];
        int i132 = ((int[]) obj)[0];
        Object obj2 = objArr6[2];
        int i133 = ((int[]) obj2)[0];
        if (i133 == i132) {
            Object[] objArr95 = {new int[1], new int[1], new int[1]};
            int i134 = ((int[]) objArr6[0])[0];
            int i135 = ((int[]) obj2)[0];
            int i136 = ((int[]) obj)[0];
            ((int[]) objArr95[2])[0] = i135;
            ((int[]) objArr95[1])[0] = i136;
            int elapsedCpuTime2 = (int) Process.getElapsedCpuTime();
            int i137 = ~elapsedCpuTime2;
            int i138 = i134 + 1506181703 + (((~((-825838385) | i137)) | (~((-525783366) | elapsedCpuTime2))) * 1900) + (((~(elapsedCpuTime2 | 825838384)) | (~(i137 | 525783365))) * (-950)) + (((~(elapsedCpuTime2 | 525783365)) | (~(i137 | 825838384))) * 950);
            int i139 = (i138 << 13) ^ i138;
            int i140 = i139 ^ (i139 >>> 17);
            ((int[]) objArr95[0])[0] = i140 ^ (i140 << 5);
            int i141 = getARTIFICIAL_FRAME_PACKAGE_NAME + 51;
            artificialFrame = i141 % 128;
            int i142 = i141 % 2;
        } else {
            Object[] objArr96 = {Long.valueOf((((long) (-531639612)) << 32) ^ ((long) (i132 ^ i133))), Long.valueOf(-531643708)};
            byte[] bArr30 = $$d;
            Object[] objArr97 = new Object[1];
            c((short) 419, bArr30[89], (byte) (-bArr30[56]), objArr97);
            Class<?> cls14 = Class.forName((String) objArr97[0]);
            byte b24 = bArr30[88];
            Object[] objArr98 = new Object[1];
            c((short) 481, b24, (byte) (b24 | 79), objArr98);
            cls14.getMethod((String) objArr98[0], Long.TYPE, Long.TYPE).invoke(null, objArr96);
            Object[] objArr99 = {new int[1], new int[1], new int[1]};
            int i143 = ((int[]) objArr6[0])[0];
            int i144 = ((int[]) objArr6[2])[0];
            int i145 = ((int[]) objArr6[1])[0];
            ((int[]) objArr99[2])[0] = i144;
            ((int[]) objArr99[1])[0] = i145;
            int iMyTid2 = Process.myTid();
            int i146 = (-803104333) + ((789568357 | iMyTid2) * 614);
            int i147 = ~iMyTid2;
            int i148 = i143 + i146 + (((~((-499179694) | i147)) | 218152997 | (~(852442056 | i147))) * (-1228)) + (((~(i147 | 1070595053)) | (~((-281026697) | i147))) * 614);
            int i149 = (i148 << 13) ^ i148;
            int i150 = i149 ^ (i149 >>> 17);
            ((int[]) objArr99[0])[0] = i150 ^ (i150 << 5);
        }
        Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame31 == null) {
            int iGreen = 26 - Color.green(0);
            char cRed2 = (char) Color.red(0);
            int iResolveSizeAndState = 1041 - View.resolveSizeAndState(0, 0, 0);
            byte[] bArr31 = $$a;
            byte b25 = bArr31[5];
            Object[] objArr100 = new Object[1];
            b(b25, (byte) (b25 & 47), bArr31[51], objArr100);
            objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(iGreen, cRed2, iResolveSizeAndState, 2061780482, false, (String) objArr100[0], null);
        }
        long j9 = ((Field) objAccessartificialFrame31).getLong(null);
        if (j9 != -1) {
            int i151 = artificialFrame + 89;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i151 % 128;
            if (i151 % 2 == 0 ? j9 + 2000 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue() : j9 + 2000 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[1]).invoke(null, new Object[0])).longValue()) {
                int iIntValue4 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                Object[] objArr101 = {-614921763};
                objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame3 == null) {
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(8 - Color.red(0), (char) (MotionEvent.axisFromString("") + 22252), Color.argb(0, 0, 0, 0) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = SchemaManager$$ExternalSyntheticLambda5.accessartificialFrame$78cbbd35(iIntValue4, 0, ((Constructor) objAccessartificialFrame3).newInstance(objArr101), 963825332, false);
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame4 == null) {
                    int mirror2 = 'J' - AndroidCharacter.getMirror('0');
                    char c10 = (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                    int iLastIndexOf2 = TextUtils.lastIndexOf("", '0', 0) + 1042;
                    byte[] bArr32 = $$a;
                    byte b26 = (byte) (-bArr32[11]);
                    Object[] objArr102 = new Object[1];
                    b(b26, (byte) (b26 | 40), bArr32[51], objArr102);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(mirror2, c10, iLastIndexOf2, 1145017376, false, (String) objArr102[0], null);
                }
                ((Field) objAccessartificialFrame4).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame5 == null) {
                        int threadPriority3 = ((Process.getThreadPriority(0) + 20) >> 6) + 26;
                        char cGreen = (char) Color.green(0);
                        int absoluteGravity4 = Gravity.getAbsoluteGravity(0, 0) + 1041;
                        byte[] bArr33 = $$a;
                        byte b27 = bArr33[5];
                        Object[] objArr103 = new Object[1];
                        b(b27, (byte) (b27 & 47), bArr33[51], objArr103);
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(threadPriority3, cGreen, absoluteGravity4, 2061780482, false, (String) objArr103[0], null);
                    }
                    ((Field) objAccessartificialFrame5).set(null, lValueOf8);
                } catch (Exception unused7) {
                    throw new RuntimeException();
                }
            } else {
                int i152 = artificialFrame + 83;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i152 % 128;
                int i153 = i152 % 2;
                Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame32 == null) {
                    int i154 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 25;
                    char cCombineMeasuredStates2 = (char) View.combineMeasuredStates(0, 0);
                    int jumpTapTimeout2 = 1041 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                    byte[] bArr34 = $$a;
                    byte b28 = (byte) (-bArr34[11]);
                    Object[] objArr104 = new Object[1];
                    b(b28, (byte) (b28 | 40), bArr34[51], objArr104);
                    objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(i154, cCombineMeasuredStates2, jumpTapTimeout2, 1145017376, false, (String) objArr104[0], null);
                }
                Object[] objArr105 = (Object[]) ((Field) objAccessartificialFrame32).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i155 = ((int[]) objArr105[3])[0];
                int i156 = ((int[]) objArr105[2])[0];
                String[] strArr9 = (String[]) objArr105[0];
                int iNextInt2 = new Random().nextInt(1669755995);
                int i157 = ~((-908058372) | iNextInt2);
                int i158 = (-1413221026) + ((806885888 | i157) * (-280)) + ((i157 | (~(829954564 | iNextInt2))) * 140);
                int i159 = ~((-101172484) | iNextInt2);
                int i160 = ~iNextInt2;
                int i161 = i158 + (((~(i160 | 931127047)) | i159 | (~((-806885889) | i160))) * 140) + 963825332;
                int i162 = (i161 << 13) ^ i161;
                int i163 = i162 ^ (i162 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i163 ^ (i163 << 5);
            }
        } else {
            int iIntValue5 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr106 = {-614921763};
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame3 == null) {
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(8 - Color.red(0), (char) (MotionEvent.axisFromString("") + 22252), Color.argb(0, 0, 0, 0) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = SchemaManager$$ExternalSyntheticLambda5.accessartificialFrame$78cbbd35(iIntValue5, 0, ((Constructor) objAccessartificialFrame3).newInstance(objArr106), 963825332, false);
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame4 == null) {
                int mirror3 = 'J' - AndroidCharacter.getMirror('0');
                char c11 = (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                int iLastIndexOf3 = TextUtils.lastIndexOf("", '0', 0) + 1042;
                byte[] bArr35 = $$a;
                byte b29 = (byte) (-bArr35[11]);
                Object[] objArr107 = new Object[1];
                b(b29, (byte) (b29 | 40), bArr35[51], objArr107);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(mirror3, c11, iLastIndexOf3, 1145017376, false, (String) objArr107[0], null);
            }
            ((Field) objAccessartificialFrame4).set(null, objArrAccessartificialFrame$78cbbd35);
            Long lValueOf9 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame5 == null) {
                int threadPriority4 = ((Process.getThreadPriority(0) + 20) >> 6) + 26;
                char cGreen2 = (char) Color.green(0);
                int absoluteGravity5 = Gravity.getAbsoluteGravity(0, 0) + 1041;
                byte[] bArr36 = $$a;
                byte b210 = bArr36[5];
                Object[] objArr108 = new Object[1];
                b(b210, (byte) (b210 & 47), bArr36[51], objArr108);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(threadPriority4, cGreen2, absoluteGravity5, 2061780482, false, (String) objArr108[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, lValueOf9);
        }
        int i164 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i165 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i165 == i164) {
            Object[] objArr109 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i166 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i167 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i168 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr10 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iIdentityHashCode10 = System.identityHashCode(this);
            int i169 = ~iIdentityHashCode10;
            int i170 = (~((-259790968) | i169)) | 173281392;
            int i171 = ~(iIdentityHashCode10 | 268196735);
            int i172 = i166 + 1319396462 + ((i170 | i171) * (-713)) + (i171 * 1426) + ((~(181687160 | i169)) * 713);
            int i173 = (i172 << 13) ^ i172;
            int i174 = i173 ^ (i173 >>> 17);
            ((int[]) objArr109[1])[0] = i174 ^ (i174 << 5);
        } else {
            ArrayList arrayList3 = new ArrayList();
            String[] strArr11 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr11 != null) {
                for (String str8 : strArr11) {
                    arrayList3.add(str8);
                }
            }
            long j10 = ((long) (i164 ^ i165)) ^ (((long) 1799252171) << 32);
            long j11 = 1799252169;
            int i175 = artificialFrame + 57;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i175 % 128;
            int i176 = i175 % 2;
            Object[] objArr110 = {Long.valueOf(j10), Long.valueOf(j11)};
            byte[] bArr37 = $$d;
            Object[] objArr111 = new Object[1];
            c((short) 89, bArr37[89], (byte) (-bArr37[251]), objArr111);
            Class<?> cls15 = Class.forName((String) objArr111[0]);
            byte b30 = bArr37[88];
            Object[] objArr112 = new Object[1];
            c((short) 481, b30, (byte) (b30 | 79), objArr112);
            cls15.getMethod((String) objArr112[0], Long.TYPE, Long.TYPE).invoke(null, objArr110);
            Object[] objArr113 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i177 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i178 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i179 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr12 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
            int i180 = i177 + 2015702758 + (((~((-10519554) | iFreeMemory)) | 88623360) * (-756)) + (((~iFreeMemory) | (-10519554)) * 756);
            int i181 = (i180 << 13) ^ i180;
            int i182 = i181 ^ (i181 >>> 17);
            ((int[]) objArr113[1])[0] = i182 ^ (i182 << 5);
        }
        boolean zOnCreate = super.onCreate();
        Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame33 == null) {
            int i183 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 16;
            char cLastIndexOf = (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1);
            int trimmedLength3 = 747 - TextUtils.getTrimmedLength("");
            byte[] bArr38 = $$a;
            byte b31 = bArr38[5];
            Object[] objArr114 = new Object[1];
            b(b31, (byte) (b31 & 47), bArr38[51], objArr114);
            objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(i183, cLastIndexOf, trimmedLength3, -144068856, false, (String) objArr114[0], null);
        }
        long j12 = ((Field) objAccessartificialFrame33).getLong(null);
        if (j12 == -1 || j12 + 1860 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr115 = new Object[1];
            a(127 - View.MeasureSpec.getSize(0), new byte[]{-125, -127, -116, -124, -105, -106, -118, -117, -122, -107, -122, -117, -112, -108, -121, -110, -110, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr115);
            Class<?> cls16 = Class.forName((String) objArr115[0]);
            Object[] objArr116 = new Object[1];
            a((ViewConfiguration.getTouchSlop() >> 8) + 127, new byte[]{-126, -123, -122, -117, -127, -112, -122, -113, -110, -110, -108, -117, -126, -116, -124, -124, -104, -112}, null, null, objArr116);
            Context applicationContext4 = (Context) cls16.getMethod((String) objArr116[0], new Class[0]).invoke(null, null);
            if (applicationContext4 != null) {
                applicationContext4 = ((applicationContext4 instanceof ContextWrapper) && ((ContextWrapper) applicationContext4).getBaseContext() == null) ? null : applicationContext4.getApplicationContext();
            }
            Object[] objArr117 = {applicationContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1424545556};
            byte[] bArr39 = $$d;
            Object[] objArr118 = new Object[1];
            c((short) (bArr39[265] - 1), bArr39[89], bArr39[101], objArr118);
            Class<?> cls17 = Class.forName((String) objArr118[0]);
            Object[] objArr119 = new Object[1];
            c((short) ($$e | 256), bArr39[130], bArr39[6], objArr119);
            objArr7 = (Object[]) cls17.getMethod((String) objArr119[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr117);
            Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame34 == null) {
                int bitsPerPixel2 = 16 - ImageFormat.getBitsPerPixel(0);
                char c12 = (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                int iRgb2 = Color.rgb(0, 0, 0) + 16777963;
                byte[] bArr40 = $$a;
                byte b32 = (byte) (-bArr40[11]);
                Object[] objArr120 = new Object[1];
                b(b32, (byte) (b32 | 40), bArr40[51], objArr120);
                objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(bitsPerPixel2, c12, iRgb2, -1031537386, false, (String) objArr120[0], null);
            }
            ((Field) objAccessartificialFrame34).set(null, objArr7);
            try {
                Long lValueOf10 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame35 == null) {
                    int iAxisFromString = MotionEvent.axisFromString("") + 18;
                    char c13 = (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                    int maximumFlingVelocity = 747 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                    byte[] bArr41 = $$a;
                    byte b33 = bArr41[5];
                    Object[] objArr121 = new Object[1];
                    b(b33, (byte) (b33 & 47), bArr41[51], objArr121);
                    objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(iAxisFromString, c13, maximumFlingVelocity, -144068856, false, (String) objArr121[0], null);
                }
                ((Field) objAccessartificialFrame35).set(null, lValueOf10);
            } catch (Exception unused8) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame36 == null) {
                int tapTimeout = 17 - (ViewConfiguration.getTapTimeout() >> 16);
                char cArgb = (char) Color.argb(0, 0, 0, 0);
                int i184 = 748 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                byte[] bArr42 = $$a;
                byte b34 = (byte) (-bArr42[11]);
                Object[] objArr122 = new Object[1];
                b(b34, (byte) (b34 | 40), bArr42[51], objArr122);
                objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(tapTimeout, cArgb, i184, -1031537386, false, (String) objArr122[0], null);
            }
            Object[] objArr123 = (Object[]) ((Field) objAccessartificialFrame36).get(null);
            objArr7 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
            int i185 = ((int[]) objArr123[3])[0];
            int i186 = ((int[]) objArr123[4])[0];
            List list = (List) objArr123[0];
            List list2 = (List) objArr123[2];
            int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
            int i187 = 1229562215 + (((~((-223265470) | iElapsedRealtime)) | 21234309) * (-140)) + ((~((-202031161) | iElapsedRealtime)) * 70) + (((~(iElapsedRealtime | 828713927)) | (-1009510779)) * 70) + 1424545556;
            int i188 = (i187 << 13) ^ i187;
            int i189 = i188 ^ (i188 >>> 17);
            ((int[]) objArr7[1])[0] = i189 ^ (i189 << 5);
        }
        int i190 = ((int[]) objArr7[4])[0];
        int i191 = ((int[]) objArr7[3])[0];
        if (i191 == i190) {
            Object[] objArr124 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i192 = ((int[]) objArr7[1])[0];
            int i193 = ((int[]) objArr7[3])[0];
            int i194 = ((int[]) objArr7[4])[0];
            List list3 = (List) objArr7[0];
            List list4 = (List) objArr7[2];
            int iIdentityHashCode11 = System.identityHashCode(this);
            int i195 = i192 + 56373322 + (((~((~iIdentityHashCode11) | (-299410576))) | 306037882) * (-235)) + (((~((-299410576) | iIdentityHashCode11)) | 306037882) * (-470)) + (((~(iIdentityHashCode11 | (-29368454))) | 35995760) * 235);
            int i196 = (i195 << 13) ^ i195;
            int i197 = i196 ^ (i196 >>> 17);
            ((int[]) objArr124[1])[0] = i197 ^ (i197 << 5);
        } else {
            ArrayList arrayList4 = new ArrayList();
            Object[] objArr125 = {objArr7};
            Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(1804664566);
            if (objAccessartificialFrame37 == null) {
                objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(41 - View.MeasureSpec.getSize(0), (char) (MotionEvent.axisFromString("") + 12469), 3641 - ImageFormat.getBitsPerPixel(0), -185222914, false, "coroutineCreation", new Class[]{Object[].class});
            }
            arrayList4.add(((Method) objAccessartificialFrame37).invoke(null, objArr125));
            Object[] objArr126 = {objArr7};
            Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(-1243809191);
            if (objAccessartificialFrame38 == null) {
                objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(41 - (KeyEvent.getMaxKeyCode() >> 16), (char) (12469 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), (ViewConfiguration.getTapTimeout() >> 16) + 3642, 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
            }
            arrayList4.add(((Method) objAccessartificialFrame38).invoke(null, objArr126));
            Object[] objArr127 = {Long.valueOf(((long) (i190 ^ i191)) ^ (((long) (-1030020238)) << 32)), Long.valueOf(-1030020230)};
            byte[] bArr43 = $$d;
            Object[] objArr128 = new Object[1];
            c(bArr43[88], bArr43[89], bArr43[259], objArr128);
            Class<?> cls18 = Class.forName((String) objArr128[0]);
            byte b35 = bArr43[88];
            Object[] objArr129 = new Object[1];
            c((short) 481, b35, (byte) (b35 | 79), objArr129);
            cls18.getMethod((String) objArr129[0], Long.TYPE, Long.TYPE).invoke(null, objArr127);
            Object[] objArr130 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i198 = ((int[]) objArr7[1])[0];
            int i199 = ((int[]) objArr7[3])[0];
            int i200 = ((int[]) objArr7[4])[0];
            List list5 = (List) objArr7[0];
            List list6 = (List) objArr7[2];
            int iIdentityHashCode12 = System.identityHashCode(this);
            int i201 = ~(282654709 | iIdentityHashCode12);
            int i202 = ~iIdentityHashCode12;
            int i203 = i201 | (~(888103167 | i202));
            int i204 = ~((-282654710) | i202);
            int i205 = i198 + 2084772661 + ((i203 | i204) * (-516)) + (((~(iIdentityHashCode12 | (-606535691))) | (~((-281567478) | i202))) * 516) + ((281567477 | i204) * 516);
            int i206 = (i205 << 13) ^ i205;
            int i207 = i206 ^ (i206 >>> 17);
            ((int[]) objArr130[1])[0] = i207 ^ (i207 << 5);
        }
        return zOnCreate;
    }

    static {
        byte[] bArr = new byte[678];
        System.arraycopy("bÂ\u008aÞó\u0001>º\nøþ\u0006\u0002ìJ»\f\u0003ýî\u0005\fì\nò\u00106º\u0007\u0001\u00072×ì\u0003í#ïð\fÿöú\nøú íòû\f\u0005ýýÿýñÿ\u0011îý\n\u0002ü\u0005ù\u0007ô%Ó\u0010ó\u0007ó\u0001>Æ÷ÿ\u0007ú\u00066Êó\u0001ÿý\u0000?Êó\u0002ÿ\u0006\u0001îEàëð\"ëõ\u0005ò(Úù\u000eò\u0003\fô\u001eëðKâÞîþ\u0001\u0010ýî\u001cñ\u0003õ\u001fåë3Öù\u0001øÿÂü\n8º\tûü\u0003\u0006þó\u0010ó\u0007í\u0007ü\u0006<µ\n\u0000=Çüü÷\u000eòCÚÞ\u0012ý÷$Üü÷\u000eòÓü\u0002ù\u0000\nú\b Þ\u0002ì\rÿýú\u0006\u001bÖó\u0001>Ç\u0004ýý\u0002òÿ\u0003<»\f\u0003ýîE¸\u000bû\u000bò\fù\u0001òCÔé\u0007\u0005\u0012Þ\nþ\u0014àÿ\u0002GÿÞÌ\u0003\u000eò\u0003\fô\u0018Ù\nù\u000b\u0002ð\n\u0005\u0016êó\ný\u00020ó\u0001>Æ÷ÿ\u0007ú\u00066Ìò\tñ\u0002\u0005\u00045À\u000bì\u000eò\b\u0007ô=Êó\u0002üüC¸\u0000\nü\u0002ô\n\u0003ñDéÊ\n\fó\u0003\u0005\u001fÓ\u0002üüMÿÞÌ\u0003\u000eò\u0003\fô\u0018Ù\nù\u000b\u0002ð\n\u0005\u0016êó\ný\u00020ó\u0001>Æ÷ÿ\u0007ú\u00066Ìò\tñ\u0002\u0005\u00045É\u0002ì\u0012ì\u0001\u0010òú\u0002\u0000üýEÊÿîEÄúù\u000eò\u0003\fô=èÌ\u0003\u000eò\u0003\fô\u001bÝ\bò\u0014ýé5Ó\u0000ù\u000eì\u0003óü\u0002ù\u0000\nú\b!Ð\f\u0003ì\nù\u0000ó\u0001>Æ÷ÿ\u0007ú\u00066Ìð\u0006:ÜÛ\u0005ú\u0012\u0010Ý\u0002ú\u0004ù@º\röù\u0001øJÚíöù\u0001ø3Ö÷\u0010øüþ\n\u001câ\u0003üþòMßÞñ\rò\b\u0007ô\u0002î\u0014òó\u0001>Ç\u0004ýý\u0002òÿ\u0003<Ìðÿ\u0003\u0002ú\u0002÷DìÐÿ#âú\u0002&âì\u0012<òú9¼\u0001ûDÁü\u0007\u0004\u0000ý÷<Êóü\f6º\u0002\u0006:êÉ\u0015ö\u0002\u0005 Ì\u000eÿ\u0000ò\u001dá\u0010ý÷\u0005òó\u0001>Æ÷ÿ\u0007ú\u00066Ìò\tñ\u0002\u0005\u00045ÆùùDÄúù\u000eò\u0003\fô=À\u0007\u0003íý\u0002\f÷\u0007öùE³ÿ\u0016ûó\u0001>¹\u0001\u0010òú\tõþ\u0004üþ\u0003\bñEÁü\u000b\u0001ì\nù\u0000\u0000\u000bò\fù\u0001òCÁü\u0007ÿ\u0001òCÙ\u0000ÿ\u0001\u0004âô\u000e#Ðÿ\nö\tþòMÀ".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 678);
        $$d = bArr;
        $$e = 182;
        $$a = new byte[]{96, -63, 33, 4, 5, -1, -33, 33, -2, -9, 5, -7, 5, -1, -50, 39, Ascii.VT, -7, -12, Ascii.SI, -9, Ascii.DC2, -34, Ascii.EM, 4, -17, 19, -15, -1, -18, Ascii.SI, 19, -11, 5, -7, -2, Ascii.SI, -36, Ascii.NAK, Ascii.CR, -15, 2, 9, 6, -34, Ascii.SI, 19, -11, 5, -7, Ascii.ESC, 1, -7, -6, -33, 51, -12, 3, -8, 1, Ascii.CR, -2, Ascii.SI, -33, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, 10, -31, Ascii.DC4, Ascii.CR, -8, -11, -13, Ascii.ESC, -9, Ascii.DC2, -36, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, -7, Ascii.DC2, -43, Ascii.GS, -4, 17, 2, 49, 2, -11, -3, 3, -6, 6, -8, Ascii.VT, -25, 33, -19, 2, 8, -37, 44, -17, Ascii.FF, -8, Ascii.SO};
        $$b = 40;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        validateRelationship = new char[]{56055, 56034, 56052, 56038, 56033, 56047, 55970, 56037, 55941, 56031, 56036, 56043, 56035, 55957, 56044, 56053, 56045, 56032, 55942, 55959, 56026, 55940, 56040, 56027, 56046, 56041, 55944, 56042, 55975, 55961, 55974, 55973, 55967, 55963, 55968, 55962, 55960, 55972, 56054};
        warmup = -1044260016;
        requestPostMessageChannelWithExtras = true;
        ICustomTabsServiceDefault = true;
    }
}
