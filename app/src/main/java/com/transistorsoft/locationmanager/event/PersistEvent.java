package com.transistorsoft.locationmanager.event;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.os.Process;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.common.base.Ascii;
import com.transistorsoft.locationmanager.location.TSLocation;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;
import o.extraCallback;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PersistEvent {
    private final TSLocation a;
    private final JSONObject b;
    private final Context c;
    private static final byte[] $$c = {110, Ascii.GS, -86, 74};
    private static final int $$d = 131;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {Ascii.FS, 50, 106, -64, -9, Ascii.DC4, -28, Ascii.SUB, Ascii.DC2, -10, 5, Ascii.VT, -2, -19, 39, -6, 6, -27, 46, -8, 6, Ascii.SI, -2, 4, -13, Ascii.CAN, Ascii.CR, 7, Ascii.FF, -12, 4, Ascii.US, 17, 4, -38, 49, 3, 8, -10, Ascii.CAN, -31, Ascii.SYN, Ascii.SYN, -10, 7, Ascii.FF, 2, Ascii.SYN, -16, Ascii.DC2, -9, Ascii.DC4, -44, 35, Ascii.DC4, 9, -6, Ascii.VT, 4, 0, 10, -2, -29, 46, -8, 6, Ascii.SI, -2, 4, -50, 50, Ascii.SO};
    private static final int $$b = 10;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] ArtificialStackFrames = {44399, 44389, 44395, 44408, 44701, 44390, 44400, 44699, 44690, 44702, 44391, 44696, 44698, 44355, 44396, 44393, 44353, 44703, 44333, 44387, 44386, 44334, 44385, 44405, 44397, 44700, 44361, 44402, 44404, 44384, 44388, 44337, 44335, 44403, 44398, 44697};
    private static char coroutineCreation = 39068;

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0028). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(int r6, int r7, short r8) {
        /*
            int r7 = r7 + 97
            byte[] r0 = com.transistorsoft.locationmanager.event.PersistEvent.$$c
            int r6 = r6 * 3
            int r6 = r6 + 4
            int r8 = r8 * 3
            int r1 = r8 + 1
            byte[] r1 = new byte[r1]
            r2 = 0
            if (r0 != 0) goto L15
            r4 = r7
            r3 = r2
            r7 = r6
            goto L28
        L15:
            r3 = r2
        L16:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r8) goto L21
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L21:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r5
        L28:
            int r4 = -r4
            int r6 = r6 + r4
            int r7 = r7 + 1
            r5 = r7
            r7 = r6
            r6 = r5
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.event.PersistEvent.$$e(int, int, short):java.lang.String");
    }

    public PersistEvent(Context context, TSLocation tSLocation, JSONObject jSONObject) {
        this.c = context;
        this.b = jSONObject;
        this.a = tSLocation;
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
    private static void d(short r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = 28 - r6
            byte[] r0 = com.transistorsoft.locationmanager.event.PersistEvent.$$a
            int r8 = 115 - r8
            int r7 = 70 - r7
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L10
            r3 = r6
            r4 = r2
            goto L22
        L10:
            r3 = r2
        L11:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r6) goto L20
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L20:
            r3 = r0[r7]
        L22:
            int r8 = r8 + r3
            int r8 = r8 + (-5)
            int r7 = r7 + 1
            r3 = r4
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.event.PersistEvent.d(short, int, int, java.lang.Object[]):void");
    }

    public Context getContext() {
        return this.c;
    }

    public TSLocation getLocation() {
        return this.a;
    }

    public JSONObject getParams() {
        return this.b;
    }

    private static void e(int i, char[] cArr, byte b, Object[] objArr) throws Throwable {
        int i2;
        Object obj;
        int i3 = 2 % 2;
        extraCallback extracallback = new extraCallback();
        char[] cArr2 = ArtificialStackFrames;
        long j = 0;
        int i4 = -1819279892;
        Object obj2 = null;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i5 = 0;
            while (i5 < length) {
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr2[i5])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i4);
                    if (objAccessartificialFrame == null) {
                        int iResolveSizeAndState = View.resolveSizeAndState(0, 0, 0) + 15;
                        char bitsPerPixel = (char) (ImageFormat.getBitsPerPixel(0) + 20489);
                        int packedPositionType = ExpandableListView.getPackedPositionType(j) + 2148;
                        byte b2 = (byte) 0;
                        byte b3 = b2;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState, bitsPerPixel, packedPositionType, 216710116, false, $$e(b2, b3, b3), new Class[]{Integer.TYPE});
                    }
                    cArr3[i5] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i5++;
                    j = 0;
                    i4 = -1819279892;
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
        Object[] objArr3 = {Integer.valueOf(coroutineCreation)};
        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1819279892);
        if (objAccessartificialFrame2 == null) {
            byte b4 = (byte) 0;
            byte b5 = b4;
            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(15 - View.MeasureSpec.getSize(0), (char) ((Process.myPid() >> 22) + 20488), KeyEvent.keyCodeFromString("") + 2148, 216710116, false, $$e(b4, b5, b5), new Class[]{Integer.TYPE});
        }
        char cCharValue = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
        char[] cArr4 = new char[i];
        if (i % 2 != 0) {
            i2 = i - 1;
            cArr4[i2] = (char) (cArr[i2] - b);
            int i6 = $11 + 121;
            $10 = i6 % 128;
            int i7 = i6 % 2;
        } else {
            i2 = i;
        }
        if (i2 > 1) {
            extracallback.a = 0;
            while (extracallback.a < i2) {
                extracallback.createBrowser = cArr[extracallback.a];
                extracallback.c = cArr[extracallback.a + 1];
                if (extracallback.createBrowser == extracallback.c) {
                    int i8 = $11 + 27;
                    $10 = i8 % 128;
                    int i9 = i8 % 2;
                    cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                    cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                    obj = obj2;
                } else {
                    Object[] objArr4 = {extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1894223152);
                    if (objAccessartificialFrame3 == null) {
                        byte b6 = (byte) 0;
                        byte b7 = (byte) (b6 + 5);
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(47 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 58859), Color.green(0) + 2464, 276640984, false, $$e(b6, b7, (byte) (b7 - 5)), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                    }
                    if (((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue() == extracallback.g) {
                        try {
                            Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1361113423);
                            if (objAccessartificialFrame4 == null) {
                                byte b8 = (byte) 0;
                                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((KeyEvent.getMaxKeyCode() >> 16) + 24, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), 792 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), -834291897, false, $$e(b8, (byte) (b8 | 8), b8), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                            }
                            obj = null;
                            int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                            int i10 = (extracallback.d * cCharValue) + extracallback.g;
                            cArr4[extracallback.a] = cArr2[iIntValue];
                            cArr4[extracallback.a + 1] = cArr2[i10];
                        } catch (Throwable th2) {
                            Throwable cause2 = th2.getCause();
                            if (cause2 == null) {
                                throw th2;
                            }
                            throw cause2;
                        }
                    } else {
                        obj = null;
                        if (extracallback.b == extracallback.d) {
                            int i11 = $10 + 63;
                            $11 = i11 % 128;
                            int i12 = i11 % 2;
                            extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                            extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                            int i13 = (extracallback.b * cCharValue) + extracallback.j;
                            int i14 = (extracallback.d * cCharValue) + extracallback.g;
                            cArr4[extracallback.a] = cArr2[i13];
                            cArr4[extracallback.a + 1] = cArr2[i14];
                        } else {
                            int i15 = (extracallback.b * cCharValue) + extracallback.g;
                            int i16 = (extracallback.d * cCharValue) + extracallback.j;
                            cArr4[extracallback.a] = cArr2[i15];
                            cArr4[extracallback.a + 1] = cArr2[i16];
                        }
                    }
                }
                extracallback.a += 2;
                obj2 = obj;
            }
        }
        for (int i17 = 0; i17 < i; i17++) {
            cArr4[i17] = (char) (cArr4[i17] ^ 13722);
        }
        objArr[0] = new String(cArr4);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 30351. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public static java.lang.Object[] coroutineBoundary(android.content.Context r31, int r32, int r33, int r34) {
        /*
            Method dump skipped, instruction units count: 3035
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.event.PersistEvent.coroutineBoundary(android.content.Context, int, int, int):java.lang.Object[]");
    }
}
