package com.google.firebase.iid;

import android.app.Service;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.IBinder;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.stats.zza;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kotlin.text.Typography;
import o.ArtificialStackFrames;
import o.extraCallback;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.CharUtils;
import org.joda.time.LocalDateTime;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class FirebaseInstanceIdService extends Service {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    private static char[] ArtificialStackFrames;
    private static int artificialFrame;
    private static char coroutineCreation;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static final byte[] $$c = {84, -108, -95, 40};
    private static final int $$f = 128;
    private static int $10 = 0;
    private static int $11 = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0024). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(byte r5, short r6, int r7) {
        /*
            int r6 = r6 * 3
            int r6 = r6 + 4
            byte[] r0 = com.google.firebase.iid.FirebaseInstanceIdService.$$c
            int r5 = r5 * 3
            int r5 = 1 - r5
            int r7 = 105 - r7
            byte[] r1 = new byte[r5]
            r2 = 0
            if (r0 != 0) goto L14
            r4 = r5
            r3 = r2
            goto L24
        L14:
            r3 = r2
        L15:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r5) goto L22
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            return r5
        L22:
            r4 = r0[r6]
        L24:
            int r4 = -r4
            int r7 = r7 + r4
            int r6 = r6 + 1
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdService.$$g(byte, short, int):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0020  */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0020 -> B:11:0x0027). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0020
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(short r7, short r8, int r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 + 4
            int r9 = r9 + 65
            int r7 = r7 + 8
            byte[] r0 = com.google.firebase.iid.FirebaseInstanceIdService.$$a
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L10
            r3 = r7
            r5 = r2
            goto L27
        L10:
            r3 = r2
        L11:
            byte r4 = (byte) r9
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r7) goto L20
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L20:
            int r8 = r8 + 1
            r3 = r0[r8]
            r6 = r3
            r3 = r9
            r9 = r6
        L27:
            int r9 = -r9
            int r9 = r9 + r3
            r3 = r5
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdService.a(short, short, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    /* JADX WARN: Code duplicated, block: B:8:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0025). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void c(int r5, short r6, int r7, java.lang.Object[] r8) {
        /*
            int r0 = 92 - r6
            byte[] r1 = com.google.firebase.iid.FirebaseInstanceIdService.$$d
            int r7 = r7 + 36
            int r5 = r5 + 4
            byte[] r0 = new byte[r0]
            int r6 = 91 - r6
            r2 = 0
            if (r1 != 0) goto L13
            r4 = r7
            r3 = r2
            r7 = r5
            goto L25
        L13:
            r3 = r2
        L14:
            byte r4 = (byte) r7
            r0[r3] = r4
            if (r3 != r6) goto L21
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            r8[r2] = r5
            return
        L21:
            int r3 = r3 + 1
            r4 = r1[r5]
        L25:
            int r5 = r5 + 1
            int r7 = r7 + r4
            int r7 = r7 + (-4)
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdService.c(int, short, int, java.lang.Object[]):void");
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Deprecated
    public void onTokenRefresh() {
    }

    private static void b(int i, char[] cArr, byte b, Object[] objArr) throws Throwable {
        int i2;
        int i3 = 2 % 2;
        extraCallback extracallback = new extraCallback();
        char[] cArr2 = ArtificialStackFrames;
        int i4 = -1819279892;
        if (cArr2 != null) {
            int i5 = $11 + 55;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i7 = 0;
            while (i7 < length) {
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr2[i7])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i4);
                    if (objAccessartificialFrame == null) {
                        byte b2 = (byte) 0;
                        byte b3 = b2;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((Process.myTid() >> 22) + 15, (char) (TextUtils.getOffsetBefore("", 0) + 20488), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 2148, 216710116, false, $$g(b2, b3, (byte) (b3 | 8)), new Class[]{Integer.TYPE});
                    }
                    cArr3[i7] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i7++;
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
            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(16 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (20488 - Color.argb(0, 0, 0, 0)), 2148 - (KeyEvent.getMaxKeyCode() >> 16), 216710116, false, $$g(b4, b5, (byte) (b5 | 8)), new Class[]{Integer.TYPE});
        }
        char cCharValue = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
        char[] cArr4 = new char[i];
        if (i % 2 != 0) {
            i2 = i - 1;
            cArr4[i2] = (char) (cArr[i2] - b);
        } else {
            i2 = i;
        }
        if (i2 > 1) {
            extracallback.a = 0;
            while (extracallback.a < i2) {
                int i8 = $10 + 123;
                $11 = i8 % 128;
                int i9 = i8 % 2;
                extracallback.createBrowser = cArr[extracallback.a];
                extracallback.c = cArr[extracallback.a + 1];
                if (extracallback.createBrowser == extracallback.c) {
                    cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                    cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                } else {
                    Object[] objArr4 = {extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1894223152);
                    if (objAccessartificialFrame3 == null) {
                        byte b6 = (byte) 0;
                        byte b7 = b6;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(46 - (Process.myTid() >> 22), (char) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 58859), (ViewConfiguration.getEdgeSlop() >> 16) + 2464, 276640984, false, $$g(b6, b7, (byte) (b7 + 3)), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                    }
                    if (((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue() == extracallback.g) {
                        Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1361113423);
                        if (objAccessartificialFrame4 == null) {
                            byte b8 = (byte) 0;
                            byte b9 = b8;
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(TextUtils.getOffsetAfter("", 0) + 24, (char) (ViewConfiguration.getTapTimeout() >> 16), 792 - (ViewConfiguration.getFadingEdgeLength() >> 16), -834291897, false, $$g(b8, b9, b9), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                        }
                        int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                        int i10 = (extracallback.d * cCharValue) + extracallback.g;
                        cArr4[extracallback.a] = cArr2[iIntValue];
                        cArr4[extracallback.a + 1] = cArr2[i10];
                    } else if (extracallback.b == extracallback.d) {
                        extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                        extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                        int i11 = (extracallback.b * cCharValue) + extracallback.j;
                        int i12 = (extracallback.d * cCharValue) + extracallback.g;
                        cArr4[extracallback.a] = cArr2[i11];
                        cArr4[extracallback.a + 1] = cArr2[i12];
                        int i13 = $10 + 29;
                        $11 = i13 % 128;
                        int i14 = i13 % 2;
                    } else {
                        int i15 = (extracallback.b * cCharValue) + extracallback.g;
                        int i16 = (extracallback.d * cCharValue) + extracallback.j;
                        cArr4[extracallback.a] = cArr2[i15];
                        cArr4[extracallback.a + 1] = cArr2[i16];
                    }
                }
                extracallback.a += 2;
                int i17 = $11 + 35;
                $10 = i17 % 128;
                int i18 = i17 % 2;
            }
        }
        for (int i19 = 0; i19 < i; i19++) {
            cArr4[i19] = (char) (cArr4[i19] ^ 13722);
        }
        objArr[0] = new String(cArr4);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:16:0x02c2 A[Catch: all -> 0x0afa, TryCatch #0 {all -> 0x0afa, blocks: (B:52:0x07ba, B:54:0x07ce, B:55:0x07fe, B:14:0x02a1, B:16:0x02c2, B:17:0x0312), top: B:92:0x02a1 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0324  */
    /* JADX WARN: Code duplicated, block: B:25:0x03f1  */
    /* JADX WARN: Code duplicated, block: B:51:0x075f  */
    /* JADX WARN: Code duplicated, block: B:54:0x07ce A[Catch: all -> 0x0afa, TryCatch #0 {all -> 0x0afa, blocks: (B:52:0x07ba, B:54:0x07ce, B:55:0x07fe, B:14:0x02a1, B:16:0x02c2, B:17:0x0312), top: B:92:0x02a1 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0814  */
    /* JADX WARN: Code duplicated, block: B:63:0x0913  */
    @Override // android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) throws Throwable {
        Object objAccessartificialFrame;
        Object[] objArr;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        String str;
        Object objAccessartificialFrame4;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        Object[] objArr2;
        int i = 2 % 2;
        int i2 = artificialFrame + 77;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        int i3 = i2 % 2;
        super.attachBaseContext(context);
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame7 == null) {
            int bitsPerPixel = 24 - ImageFormat.getBitsPerPixel(0);
            char mirror = (char) (AndroidCharacter.getMirror('0') + 30020);
            int iIndexOf = TextUtils.indexOf((CharSequence) "", '0') + 817;
            byte[] bArr = $$a;
            byte b = bArr[5];
            byte b2 = bArr[21];
            Object[] objArr3 = new Object[1];
            a(b, b2, (byte) (b2 & 47), objArr3);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(bitsPerPixel, mirror, iIndexOf, 721586079, false, (String) objArr3[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 1940;
            Object[] objArr4 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 18, new char[]{18, 3, 25, '.', CoreConstants.DASH_CHAR, CoreConstants.SINGLE_QUOTE_CHAR, 16, '.', '/', '+', 2, 23, '#', CoreConstants.COMMA_CHAR, 30, CharUtils.CR, '\b', Typography.amp, CoreConstants.COMMA_CHAR, '/', 2, 26}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 41), objArr4);
            Class<?> cls = Class.forName((String) objArr4[0]);
            Object[] objArr5 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 11, new char[]{'\b', CoreConstants.COMMA_CHAR, 20, CoreConstants.DASH_CHAR, CoreConstants.COMMA_CHAR, 7, 19, 16, '\n', 16, '0', 29, CoreConstants.DASH_CHAR, 17, 13844}, (byte) (TextUtils.getTrimmedLength("") + 21), objArr5);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame8 == null) {
                    int i4 = 26 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                    char c = (char) (30067 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                    int i5 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 816;
                    byte[] bArr2 = $$a;
                    byte b3 = bArr2[5];
                    byte b4 = bArr2[11];
                    Object[] objArr6 = new Object[1];
                    a(b3, b4, (byte) (b4 | 40), objArr6);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i4, c, i5, 891606461, false, (String) objArr6[0], null);
                }
                Object[] objArr7 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i6 = ((int[]) objArr7[0])[0];
                int i7 = ((int[]) objArr7[1])[0];
                String[] strArr = (String[]) objArr7[2];
                int iIdentityHashCode = System.identityHashCode(this);
                int i8 = ~((-868463300) | iIdentityHashCode);
                int i9 = ~iIdentityHashCode;
                int i10 = (-337404907) + ((i8 | (~((-670290934) | i9))) * (-1808)) + (((~((-268443651) | iIdentityHashCode)) | (~(i9 | (-70271285)))) * TypedValues.Custom.TYPE_BOOLEAN) + (((~(iIdentityHashCode | 670290933)) | 600019649 | (~(868463299 | i9))) * TypedValues.Custom.TYPE_BOOLEAN) + 1409967022;
                int i11 = (i10 << 13) ^ i10;
                int i12 = i11 ^ (i11 >>> 17);
                ((int[]) objArr[3])[0] = i12 ^ (i12 << 5);
            } else {
                Object[] objArr8 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(2) - 100, new char[]{CoreConstants.DASH_CHAR, 19, 24, 14, CoreConstants.DASH_CHAR, CoreConstants.COMMA_CHAR, 18, 3, '.', CoreConstants.DASH_CHAR, 23, CoreConstants.COMMA_CHAR, '0', 28, '\n', 11}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 26), objArr8);
                Class<?> cls2 = Class.forName((String) objArr8[0]);
                Object[] objArr9 = new Object[1];
                b((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 15, new char[]{CoreConstants.SINGLE_QUOTE_CHAR, 17, 11, 2, 31, CoreConstants.RIGHT_PARENTHESIS_CHAR, 30, CoreConstants.RIGHT_PARENTHESIS_CHAR, '\n', 19, '0', 21, CoreConstants.SINGLE_QUOTE_CHAR, '+', 16, 11}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 59), objArr9);
                try {
                    Object[] objArr10 = {Integer.valueOf(((Integer) cls2.getMethod((String) objArr9[0], Object.class).invoke(null, this)).intValue()), 0, 1409967022};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame == null) {
                        int pressedStateDuration = (ViewConfiguration.getPressedStateDuration() >> 16) + 25;
                        char cAxisFromString = (char) (30067 - MotionEvent.axisFromString(""));
                        int minimumFlingVelocity = 816 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                        byte[] bArr3 = $$a;
                        Object[] objArr11 = new Object[1];
                        a(bArr3[0], bArr3[38], bArr3[65], objArr11);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(pressedStateDuration, cAxisFromString, minimumFlingVelocity, -797394565, false, (String) objArr11[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr10);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame2 == null) {
                        int iNormalizeMetaState = KeyEvent.normalizeMetaState(0) + 25;
                        char c2 = (char) (30069 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                        int touchSlop = (ViewConfiguration.getTouchSlop() >> 8) + 816;
                        byte[] bArr4 = $$a;
                        byte b5 = bArr4[5];
                        byte b6 = bArr4[11];
                        Object[] objArr12 = new Object[1];
                        a(b5, b6, (byte) (b6 | 40), objArr12);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState, c2, touchSlop, 891606461, false, (String) objArr12[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArr);
                    try {
                        Object[] objArr13 = new Object[1];
                        b(22 - (KeyEvent.getMaxKeyCode() >> 16), new char[]{18, 3, 25, '.', CoreConstants.DASH_CHAR, CoreConstants.SINGLE_QUOTE_CHAR, 16, '.', '/', '+', 2, 23, '#', CoreConstants.COMMA_CHAR, 30, CharUtils.CR, '\b', Typography.amp, CoreConstants.COMMA_CHAR, '/', 2, 26}, (byte) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 8), objArr13);
                        Class<?> cls3 = Class.forName((String) objArr13[0]);
                        Object[] objArr14 = new Object[1];
                        b(15 - (ViewConfiguration.getTapTimeout() >> 16), new char[]{'\b', CoreConstants.COMMA_CHAR, 20, CoreConstants.DASH_CHAR, CoreConstants.COMMA_CHAR, 7, 19, 16, '\n', 16, '0', 29, CoreConstants.DASH_CHAR, 17, 13844}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 17), objArr14);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr14[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame3 == null) {
                            int scrollBarFadeDuration = 25 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                            char c3 = (char) (30069 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                            int iIndexOf2 = 815 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                            byte[] bArr5 = $$a;
                            byte b7 = bArr5[5];
                            byte b8 = bArr5[21];
                            Object[] objArr15 = new Object[1];
                            a(b7, b8, (byte) (b8 & 47), objArr15);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration, c3, iIndexOf2, 721586079, false, (String) objArr15[0], null);
                        }
                        ((Field) objAccessartificialFrame3).set(null, lValueOf);
                    } catch (Exception unused) {
                        throw new RuntimeException();
                    }
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
        } else {
            Object[] objArr16 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(2) - 100, new char[]{CoreConstants.DASH_CHAR, 19, 24, 14, CoreConstants.DASH_CHAR, CoreConstants.COMMA_CHAR, 18, 3, '.', CoreConstants.DASH_CHAR, 23, CoreConstants.COMMA_CHAR, '0', 28, '\n', 11}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 26), objArr16);
            Class<?> cls4 = Class.forName((String) objArr16[0]);
            Object[] objArr17 = new Object[1];
            b((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 15, new char[]{CoreConstants.SINGLE_QUOTE_CHAR, 17, 11, 2, 31, CoreConstants.RIGHT_PARENTHESIS_CHAR, 30, CoreConstants.RIGHT_PARENTHESIS_CHAR, '\n', 19, '0', 21, CoreConstants.SINGLE_QUOTE_CHAR, '+', 16, 11}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 59), objArr17);
            Object[] objArr18 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue()), 0, 1409967022};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame == null) {
                int pressedStateDuration2 = (ViewConfiguration.getPressedStateDuration() >> 16) + 25;
                char cAxisFromString2 = (char) (30067 - MotionEvent.axisFromString(""));
                int minimumFlingVelocity2 = 816 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                byte[] bArr6 = $$a;
                Object[] objArr19 = new Object[1];
                a(bArr6[0], bArr6[38], bArr6[65], objArr19);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(pressedStateDuration2, cAxisFromString2, minimumFlingVelocity2, -797394565, false, (String) objArr19[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr18);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame2 == null) {
                int iNormalizeMetaState2 = KeyEvent.normalizeMetaState(0) + 25;
                char c4 = (char) (30069 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                int touchSlop2 = (ViewConfiguration.getTouchSlop() >> 8) + 816;
                byte[] bArr7 = $$a;
                byte b9 = bArr7[5];
                byte b10 = bArr7[11];
                Object[] objArr110 = new Object[1];
                a(b9, b10, (byte) (b10 | 40), objArr110);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState2, c4, touchSlop2, 891606461, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArr);
            Object[] objArr111 = new Object[1];
            b(22 - (KeyEvent.getMaxKeyCode() >> 16), new char[]{18, 3, 25, '.', CoreConstants.DASH_CHAR, CoreConstants.SINGLE_QUOTE_CHAR, 16, '.', '/', '+', 2, 23, '#', CoreConstants.COMMA_CHAR, 30, CharUtils.CR, '\b', Typography.amp, CoreConstants.COMMA_CHAR, '/', 2, 26}, (byte) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 8), objArr111);
            Class<?> cls5 = Class.forName((String) objArr111[0]);
            Object[] objArr112 = new Object[1];
            b(15 - (ViewConfiguration.getTapTimeout() >> 16), new char[]{'\b', CoreConstants.COMMA_CHAR, 20, CoreConstants.DASH_CHAR, CoreConstants.COMMA_CHAR, 7, 19, 16, '\n', 16, '0', 29, CoreConstants.DASH_CHAR, 17, 13844}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 17), objArr112);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr112[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame3 == null) {
                int scrollBarFadeDuration2 = 25 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                char c5 = (char) (30069 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                int iIndexOf3 = 815 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                byte[] bArr8 = $$a;
                byte b11 = bArr8[5];
                byte b12 = bArr8[21];
                Object[] objArr113 = new Object[1];
                a(b11, b12, (byte) (b12 & 47), objArr113);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration2, c5, iIndexOf3, 721586079, false, (String) objArr113[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i13 = ((int[]) objArr[1])[0];
        int i14 = ((int[]) objArr[0])[0];
        if (i14 == i13) {
            Object[] objArr20 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i15 = ((int[]) objArr[3])[0];
            int i16 = ((int[]) objArr[0])[0];
            int i17 = ((int[]) objArr[1])[0];
            String[] strArr2 = (String[]) objArr[2];
            int i18 = ~((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().orientation;
            int i19 = i15 + 1425332373 + (((-52435201) | i18) * SyslogConstants.LOG_LOCAL7) + (((~(i18 | 73327869)) | (-53353774)) * SyslogConstants.LOG_LOCAL7);
            int i20 = (i19 << 13) ^ i19;
            int i21 = i20 ^ (i20 >>> 17);
            ((int[]) objArr20[3])[0] = i21 ^ (i21 << 5);
            str = "currentApplication";
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr[2];
            if (strArr3 != null) {
                int i22 = 0;
                while (i22 < strArr3.length) {
                    arrayList.add(strArr3[i22]);
                    i22++;
                    int i23 = getARTIFICIAL_FRAME_PACKAGE_NAME + 99;
                    artificialFrame = i23 % 128;
                    int i24 = i23 % 2;
                }
            }
            str = "currentApplication";
            try {
                Object[] objArr21 = {Long.valueOf((((long) 1830189913) << 32) ^ ((long) (i13 ^ i14))), Long.valueOf(1830189912)};
                byte[] bArr9 = $$d;
                Object[] objArr22 = new Object[1];
                c(bArr9[28], (byte) (-bArr9[327]), bArr9[51], objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                c(bArr9[173], (byte) 89, bArr9[28], objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i25 = ((int[]) objArr[3])[0];
                int i26 = ((int[]) objArr[0])[0];
                int i27 = ((int[]) objArr[1])[0];
                String[] strArr4 = (String[]) objArr[2];
                int i28 = ((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 888138978;
                int i29 = i25 + (((2007610791 + (((~((~i28) | 242453081)) | 268460326) * 446)) + (((~(i28 | 510913407)) | 172165121) * 446)) - 525778892);
                int i30 = (i29 << 13) ^ i29;
                int i31 = i30 ^ (i30 >>> 17);
                ((int[]) objArr24[3])[0] = i31 ^ (i31 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame9 == null) {
            int mirror2 = AndroidCharacter.getMirror('0') - 22;
            char doubleTapTimeout = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
            int i32 = 1042 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
            byte[] bArr10 = $$a;
            byte b13 = bArr10[5];
            byte b14 = bArr10[21];
            Object[] objArr25 = new Object[1];
            a(b13, b14, (byte) (b14 & 47), objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(mirror2, doubleTapTimeout, i32, 2061780482, false, (String) objArr25[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j3 != -1) {
            long j4 = j3 + 4611686018427387912L;
            Object[] objArr26 = new Object[1];
            b(22 - Color.argb(0, 0, 0, 0), new char[]{18, 3, 25, '.', CoreConstants.DASH_CHAR, CoreConstants.SINGLE_QUOTE_CHAR, 16, '.', '/', '+', 2, 23, '#', CoreConstants.COMMA_CHAR, 30, CharUtils.CR, '\b', Typography.amp, CoreConstants.COMMA_CHAR, '/', 2, 26}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 41), objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            b(15 - TextUtils.getTrimmedLength(""), new char[]{'\b', CoreConstants.COMMA_CHAR, 20, CoreConstants.DASH_CHAR, CoreConstants.COMMA_CHAR, 7, 19, 16, '\n', 16, '0', 29, CoreConstants.DASH_CHAR, 17, 13844}, (byte) (View.resolveSizeAndState(0, 0, 0) + 21), objArr27);
            if (j4 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i33 = artificialFrame + 5;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i33 % 128;
                int i34 = i33 % 2;
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame10 == null) {
                    int iRgb = (-16777190) - Color.rgb(0, 0, 0);
                    char offsetAfter = (char) TextUtils.getOffsetAfter("", 0);
                    int capsMode = TextUtils.getCapsMode("", 0, 0) + 1041;
                    byte[] bArr11 = $$a;
                    byte b15 = bArr11[5];
                    byte b16 = bArr11[11];
                    Object[] objArr28 = new Object[1];
                    a(b15, b16, (byte) (b16 | 40), objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iRgb, offsetAfter, capsMode, 1145017376, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr2 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i35 = ((int[]) objArr29[3])[0];
                int i36 = ((int[]) objArr29[2])[0];
                String[] strArr5 = (String[]) objArr29[0];
                int iIdentityHashCode2 = System.identityHashCode(this);
                int i37 = 2098414286 + (((~(680330335 | iIdentityHashCode2)) | 56638240 | (~((-602226529) | iIdentityHashCode2))) * (-744)) + (((~iIdentityHashCode2) | 134742047) * 744) + ((iIdentityHashCode2 | (-56638241)) * 744) + 1577283401;
                int i38 = (i37 << 13) ^ i37;
                int i39 = i38 ^ (i38 >>> 17);
                ((int[]) objArr2[1])[0] = i39 ^ (i39 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                b((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 15, new char[]{CoreConstants.DASH_CHAR, 19, 24, 14, CoreConstants.DASH_CHAR, CoreConstants.COMMA_CHAR, 18, 3, '.', CoreConstants.DASH_CHAR, 23, CoreConstants.COMMA_CHAR, '0', 28, '\n', 11}, (byte) (Color.argb(0, 0, 0, 0) + 23), objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                b(View.resolveSizeAndState(0, 0, 0) + 16, new char[]{CoreConstants.SINGLE_QUOTE_CHAR, 17, 11, 2, 31, CoreConstants.RIGHT_PARENTHESIS_CHAR, 30, CoreConstants.RIGHT_PARENTHESIS_CHAR, '\n', 19, '0', 21, CoreConstants.SINGLE_QUOTE_CHAR, '+', 16, 11}, (byte) (80 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)), objArr31);
                int iIntValue = ((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue();
                Object[] objArr32 = {-1336425581};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getTouchSlop() >> 8) + 8, (char) ((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 22251), TextUtils.lastIndexOf("", '0') + 1034, 47343338, false, null, new Class[]{Integer.TYPE});
                }
                Object[] objArrAccessartificialFrame$78cbbd35 = LocalDateTime.Property.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr32), 1577283401, false);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame5 == null) {
                    int maximumFlingVelocity = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 26;
                    char c6 = (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                    int iBlue = Color.blue(0) + 1041;
                    byte[] bArr12 = $$a;
                    byte b17 = bArr12[5];
                    byte b18 = bArr12[11];
                    Object[] objArr33 = new Object[1];
                    a(b17, b18, (byte) (b18 | 40), objArr33);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity, c6, iBlue, 1145017376, false, (String) objArr33[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Object[] objArr34 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 18, new char[]{18, 3, 25, '.', CoreConstants.DASH_CHAR, CoreConstants.SINGLE_QUOTE_CHAR, 16, '.', '/', '+', 2, 23, '#', CoreConstants.COMMA_CHAR, 30, CharUtils.CR, '\b', Typography.amp, CoreConstants.COMMA_CHAR, '/', 2, 26}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 13), objArr34);
                    Class<?> cls9 = Class.forName((String) objArr34[0]);
                    Object[] objArr35 = new Object[1];
                    b(TextUtils.indexOf((CharSequence) "", '0', 0) + 16, new char[]{'\b', CoreConstants.COMMA_CHAR, 20, CoreConstants.DASH_CHAR, CoreConstants.COMMA_CHAR, 7, 19, 16, '\n', 16, '0', 29, CoreConstants.DASH_CHAR, 17, 13844}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 14), objArr35);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr35[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame6 == null) {
                        int minimumFlingVelocity3 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 26;
                        char cResolveSizeAndState = (char) View.resolveSizeAndState(0, 0, 0);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0) + 1041;
                        byte[] bArr13 = $$a;
                        byte b19 = bArr13[5];
                        byte b20 = bArr13[21];
                        Object[] objArr36 = new Object[1];
                        a(b19, b20, (byte) (b20 & 47), objArr36);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity3, cResolveSizeAndState, iMakeMeasureSpec, 2061780482, false, (String) objArr36[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                    objArr2 = objArrAccessartificialFrame$78cbbd35;
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr37 = new Object[1];
            b((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 15, new char[]{CoreConstants.DASH_CHAR, 19, 24, 14, CoreConstants.DASH_CHAR, CoreConstants.COMMA_CHAR, 18, 3, '.', CoreConstants.DASH_CHAR, 23, CoreConstants.COMMA_CHAR, '0', 28, '\n', 11}, (byte) (Color.argb(0, 0, 0, 0) + 23), objArr37);
            Class<?> cls10 = Class.forName((String) objArr37[0]);
            Object[] objArr38 = new Object[1];
            b(View.resolveSizeAndState(0, 0, 0) + 16, new char[]{CoreConstants.SINGLE_QUOTE_CHAR, 17, 11, 2, 31, CoreConstants.RIGHT_PARENTHESIS_CHAR, 30, CoreConstants.RIGHT_PARENTHESIS_CHAR, '\n', 19, '0', 21, CoreConstants.SINGLE_QUOTE_CHAR, '+', 16, 11}, (byte) (80 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)), objArr38);
            int iIntValue2 = ((Integer) cls10.getMethod((String) objArr38[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr39 = {-1336425581};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getTouchSlop() >> 8) + 8, (char) ((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 22251), TextUtils.lastIndexOf("", '0') + 1034, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            Object[] objArrAccessartificialFrame$78cbbd36 = LocalDateTime.Property.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr39), 1577283401, false);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame5 == null) {
                int maximumFlingVelocity2 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 26;
                char c7 = (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                int iBlue2 = Color.blue(0) + 1041;
                byte[] bArr14 = $$a;
                byte b110 = bArr14[5];
                byte b111 = bArr14[11];
                Object[] objArr310 = new Object[1];
                a(b110, b111, (byte) (b111 | 40), objArr310);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity2, c7, iBlue2, 1145017376, false, (String) objArr310[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd36);
            Object[] objArr311 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 18, new char[]{18, 3, 25, '.', CoreConstants.DASH_CHAR, CoreConstants.SINGLE_QUOTE_CHAR, 16, '.', '/', '+', 2, 23, '#', CoreConstants.COMMA_CHAR, 30, CharUtils.CR, '\b', Typography.amp, CoreConstants.COMMA_CHAR, '/', 2, 26}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 13), objArr311);
            Class<?> cls11 = Class.forName((String) objArr311[0]);
            Object[] objArr312 = new Object[1];
            b(TextUtils.indexOf((CharSequence) "", '0', 0) + 16, new char[]{'\b', CoreConstants.COMMA_CHAR, 20, CoreConstants.DASH_CHAR, CoreConstants.COMMA_CHAR, 7, 19, 16, '\n', 16, '0', 29, CoreConstants.DASH_CHAR, 17, 13844}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 14), objArr312);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr312[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame6 == null) {
                int minimumFlingVelocity4 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 26;
                char cResolveSizeAndState2 = (char) View.resolveSizeAndState(0, 0, 0);
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0) + 1041;
                byte[] bArr15 = $$a;
                byte b112 = bArr15[5];
                byte b21 = bArr15[21];
                Object[] objArr313 = new Object[1];
                a(b112, b21, (byte) (b21 & 47), objArr313);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity4, cResolveSizeAndState2, iMakeMeasureSpec2, 2061780482, false, (String) objArr313[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
            objArr2 = objArrAccessartificialFrame$78cbbd36;
        }
        int i40 = ((int[]) objArr2[2])[0];
        int i41 = ((int[]) objArr2[3])[0];
        if (i41 == i40) {
            Object[] objArr40 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i42 = ((int[]) objArr2[1])[0];
            int i43 = ((int[]) objArr2[3])[0];
            int i44 = ((int[]) objArr2[2])[0];
            String[] strArr6 = (String[]) objArr2[0];
            int i45 = ~((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getResources().getConfiguration().smallestScreenWidthDp;
            int i46 = i42 + 1830234910 + (((~(i45 | 165646021)) | 69222658) * (-160)) + (((~(i45 | 87542214)) | 165646021) * SyslogConstants.LOG_LOCAL4);
            int i47 = (i46 << 13) ^ i46;
            int i48 = i47 ^ (i47 >>> 17);
            ((int[]) objArr40[1])[0] = i48 ^ (i48 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArr2[0];
        if (strArr7 != null) {
            for (String str2 : strArr7) {
                int i49 = getARTIFICIAL_FRAME_PACKAGE_NAME + 31;
                artificialFrame = i49 % 128;
                int i50 = i49 % 2;
                arrayList2.add(str2);
            }
        }
        long j5 = ((long) (i40 ^ i41)) ^ (((long) (-1860037085)) << 32);
        long j6 = -1860037087;
        int i51 = getARTIFICIAL_FRAME_PACKAGE_NAME + 19;
        artificialFrame = i51 % 128;
        int i52 = i51 % 2;
        Object[] objArr41 = {Long.valueOf(j5), Long.valueOf(j6)};
        byte[] bArr16 = $$d;
        Object[] objArr42 = new Object[1];
        c(bArr16[32], bArr16[134], bArr16[453], objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        Object[] objArr43 = new Object[1];
        c(bArr16[173], (byte) 89, bArr16[28], objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {strArr, new int[1], new int[]{i}, new int[]{i}};
        int i53 = ((int[]) objArr2[1])[0];
        int i54 = ((int[]) objArr2[3])[0];
        int i55 = ((int[]) objArr2[2])[0];
        String[] strArr8 = (String[]) objArr2[0];
        int i56 = ((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().densityDpi;
        int i57 = i53 + (-198251778) + (((~(697850085 | i56)) | 775953892) * (-366)) + (((~(i56 | 802708965)) | 671095012) * 366);
        int i58 = (i57 << 13) ^ i57;
        int i59 = i58 ^ (i58 >>> 17);
        ((int[]) objArr44[1])[0] = i59 ^ (i59 << 5);
    }

    @Override // android.app.Service
    public void onCreate() throws Throwable {
        Object[] objArr;
        int i;
        Object[] objArr2;
        Object[] objArrAccessartificialFrame$78cbbd35;
        int i2;
        Object[] objArr3;
        Object[] objArr4;
        int i3;
        Object[] objArr5;
        char c;
        Object[] objArr6;
        Object[] objArr7;
        int i4 = 2 % 2;
        Object[] objArr8 = new Object[1];
        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 14, new char[]{18, 3, 25, '.', CoreConstants.DASH_CHAR, CoreConstants.SINGLE_QUOTE_CHAR, 16, '.', '/', '+', 2, 23, '#', CoreConstants.COMMA_CHAR, 30, CharUtils.CR, '\b', Typography.amp, CoreConstants.COMMA_CHAR, '/', 2, 26}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(17) - 97), objArr8);
        String str = (String) objArr8[0];
        Object[] objArr9 = new Object[1];
        b((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 15, new char[]{'\b', CoreConstants.COMMA_CHAR, 20, CoreConstants.DASH_CHAR, CoreConstants.COMMA_CHAR, 7, 19, 16, '\n', 16, '0', 29, CoreConstants.DASH_CHAR, 17, 13844}, (byte) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 20), objArr9);
        String str2 = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        b((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 15, new char[]{CoreConstants.DASH_CHAR, 19, 24, 14, CoreConstants.DASH_CHAR, CoreConstants.COMMA_CHAR, 18, 3, '.', CoreConstants.DASH_CHAR, 23, CoreConstants.COMMA_CHAR, '0', 28, '\n', 11}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 92), objArr10);
        String str3 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 20, new char[]{CoreConstants.SINGLE_QUOTE_CHAR, 17, 11, 2, 31, CoreConstants.RIGHT_PARENTHESIS_CHAR, 30, CoreConstants.RIGHT_PARENTHESIS_CHAR, '\n', 19, '0', 21, CoreConstants.SINGLE_QUOTE_CHAR, '+', 16, 11}, (byte) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 80), objArr11);
        String str4 = (String) objArr11[0];
        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame == null) {
            int deadChar = KeyEvent.getDeadChar(0, 0) + 30;
            char c2 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 49361);
            int packedPositionGroup = 684 - ExpandableListView.getPackedPositionGroup(0L);
            byte b = $$a[28];
            Object[] objArr12 = new Object[1];
            a(b, (byte) (b | Ascii.DC2), (byte) 45, objArr12);
            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(deadChar, c2, packedPositionGroup, 752929587, false, (String) objArr12[0], null);
        }
        long j = ((Field) objAccessartificialFrame).getLong(null);
        if (j == -1 || j + 1866 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr13 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 5, new char[]{18, 3, 25, '.', CoreConstants.DASH_CHAR, CoreConstants.SINGLE_QUOTE_CHAR, 16, '.', 20, CoreConstants.DASH_CHAR, '*', CoreConstants.DASH_CHAR, '\f', 1, 31, CoreConstants.RIGHT_PARENTHESIS_CHAR, 24, '#', 30, CoreConstants.RIGHT_PARENTHESIS_CHAR, CoreConstants.RIGHT_PARENTHESIS_CHAR, 26, CoreConstants.PERCENT_CHAR, 11, 18, 19}, (byte) (KeyEvent.normalizeMetaState(0) + 101), objArr13);
                Class<?> cls = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b(TextUtils.lastIndexOf("", '0', 0) + 19, new char[]{6, 4, 13816, 13816, 11, 2, 29, CharUtils.CR, 13818, 13818, CoreConstants.DASH_CHAR, '$', 3, 19, 31, CoreConstants.RIGHT_PARENTHESIS_CHAR, 4, 11}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 20), objArr14);
                baseContext = (Context) cls.getMethod((String) objArr14[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = ((baseContext instanceof ContextWrapper) && ((ContextWrapper) baseContext).getBaseContext() == null) ? null : baseContext.getApplicationContext();
            }
            try {
                Object[] objArr15 = {baseContext, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -663178077};
                byte[] bArr = $$d;
                Object[] objArr16 = new Object[1];
                c((short) 83, (byte) (bArr[129] - 1), (byte) (bArr[652] - 1), objArr16);
                Class<?> cls2 = Class.forName((String) objArr16[0]);
                Object[] objArr17 = new Object[1];
                c((short) 130, bArr[652], bArr[78], objArr17);
                objArr = (Object[]) cls2.getMethod((String) objArr17[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr15);
                if (baseContext != null) {
                    int i5 = getARTIFICIAL_FRAME_PACKAGE_NAME + 79;
                    artificialFrame = i5 % 128;
                    int i6 = i5 % 2;
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-326560385);
                    if (objAccessartificialFrame2 == null) {
                        int i7 = 31 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                        char packedPositionType = (char) (ExpandableListView.getPackedPositionType(0L) + 49362);
                        int doubleTapTimeout = 684 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                        byte b2 = $$a[28];
                        byte b3 = (byte) (b2 | 33);
                        Object[] objArr18 = new Object[1];
                        a(b2, b3, (byte) (b3 - 3), objArr18);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i7, packedPositionType, doubleTapTimeout, 1944867703, false, (String) objArr18[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArr);
                    try {
                        Long lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                        if (objAccessartificialFrame3 == null) {
                            int jumpTapTimeout = (ViewConfiguration.getJumpTapTimeout() >> 16) + 30;
                            char edgeSlop = (char) ((ViewConfiguration.getEdgeSlop() >> 16) + 49362);
                            int i8 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 683;
                            byte b4 = $$a[28];
                            Object[] objArr19 = new Object[1];
                            a(b4, (byte) (b4 | Ascii.DC2), (byte) 45, objArr19);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout, edgeSlop, i8, 752929587, false, (String) objArr19[0], null);
                        }
                        ((Field) objAccessartificialFrame3).set(null, lValueOf);
                    } catch (Exception unused) {
                        throw new RuntimeException();
                    }
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        } else {
            int i9 = artificialFrame + 39;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i9 % 128;
            int i10 = i9 % 2;
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-326560385);
            if (objAccessartificialFrame4 == null) {
                int windowTouchSlop = (ViewConfiguration.getWindowTouchSlop() >> 8) + 30;
                char scrollBarFadeDuration = (char) (49362 - (ViewConfiguration.getScrollBarFadeDuration() >> 16));
                int i11 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 684;
                byte b5 = $$a[28];
                byte b6 = (byte) (b5 | 33);
                Object[] objArr20 = new Object[1];
                a(b5, b6, (byte) (b6 - 3), objArr20);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(windowTouchSlop, scrollBarFadeDuration, i11, 1944867703, false, (String) objArr20[0], null);
            }
            Object[] objArr21 = (Object[]) ((Field) objAccessartificialFrame4).get(null);
            objArr = new Object[]{new int[]{((int[]) objArr21[0])[0]}, new int[]{((int[]) objArr21[1])[0]}, new int[1], (String) objArr21[3]};
            int iMyUid = Process.myUid();
            int i12 = ~iMyUid;
            int i13 = (((1316476840 + ((603008416 | i12) * (-757))) + ((~((-335692383) | iMyUid)) * 1514)) + (((~(iMyUid | 938700798)) | ((~(i12 | (-375615359))) | 39922976)) * 757)) - 663178077;
            int i14 = (i13 << 13) ^ i13;
            int i15 = i14 ^ (i14 >>> 17);
            ((int[]) objArr[2])[0] = i15 ^ (i15 << 5);
        }
        int i16 = ((int[]) objArr[1])[0];
        int i17 = ((int[]) objArr[0])[0];
        if (i17 == i16) {
            int i18 = ((int[]) objArr[2])[0];
            Object[] objArr22 = {new int[]{((int[]) objArr[0])[0]}, new int[]{((int[]) objArr[1])[0]}, new int[1], (String) objArr[3]};
            int i19 = ~(Process.myPid() | 877922103);
            int i20 = i18 + ((810811920 | i19) * (-196)) + 715276162 + ((i19 | 67110183) * 196);
            int i21 = (i20 << 13) ^ i20;
            int i22 = i21 ^ (i21 >>> 17);
            i = 0;
            ((int[]) objArr22[2])[0] = i22 ^ (i22 << 5);
        } else {
            try {
                Object[] objArr23 = {Long.valueOf(((long) (i16 ^ i17)) ^ (((long) 635347957) << 32)), Long.valueOf(635347953)};
                byte[] bArr2 = $$d;
                Object[] objArr24 = new Object[1];
                c((short) 149, bArr2[0], bArr2[51], objArr24);
                Class<?> cls3 = Class.forName((String) objArr24[0]);
                Object[] objArr25 = new Object[1];
                c(bArr2[173], (byte) 89, bArr2[28], objArr25);
                cls3.getMethod((String) objArr25[0], Long.TYPE, Long.TYPE).invoke(null, objArr23);
                int i23 = ((int[]) objArr[2])[0];
                Object[] objArr26 = {new int[]{((int[]) objArr[0])[0]}, new int[]{((int[]) objArr[1])[0]}, new int[1], (String) objArr[3]};
                int i24 = ~((~Process.myTid()) | (-68083814));
                int i25 = i23 + (((-1047526886) | i24) * (-970)) + 1912786082 + ((i24 | 979443072) * 970);
                int i26 = (i25 << 13) ^ i25;
                int i27 = i26 ^ (i26 >>> 17);
                i = 0;
                ((int[]) objArr26[2])[0] = i27 ^ (i27 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame5 == null) {
            int iBlue = Color.blue(i) + 30;
            char cResolveOpacity = (char) (Drawable.resolveOpacity(i, i) + 49362);
            int gidForName = Process.getGidForName("") + 685;
            byte[] bArr3 = $$a;
            Object[] objArr27 = new Object[1];
            a((byte) (-bArr3[4]), (byte) ($$b & 122), (byte) (bArr3[114] + 1), objArr27);
            objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iBlue, cResolveOpacity, gidForName, -1583976536, false, (String) objArr27[0], null);
        }
        long j2 = ((Field) objAccessartificialFrame5).getLong(null);
        if (j2 == -1 || j2 + 1909 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr28 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 461727106};
            byte[] bArr4 = $$d;
            Object[] objArr29 = new Object[1];
            c((short) 173, bArr4[227], (byte) (-bArr4[182]), objArr29);
            Class<?> cls4 = Class.forName((String) objArr29[0]);
            Object[] objArr30 = new Object[1];
            c((short) 204, bArr4[453], bArr4[51], objArr30);
            objArr2 = (Object[]) cls4.getMethod((String) objArr30[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr28);
            Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame6 == null) {
                int touchSlop = 30 - (ViewConfiguration.getTouchSlop() >> 8);
                char cNormalizeMetaState = (char) (KeyEvent.normalizeMetaState(0) + 49362);
                int mirror = AndroidCharacter.getMirror('0') + 636;
                Object[] objArr31 = new Object[1];
                a($$a[5], (byte) 68, (byte) ($$b & b.l), objArr31);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(touchSlop, cNormalizeMetaState, mirror, -1456483158, false, (String) objArr31[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, objArr2);
            try {
                Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame7 == null) {
                    int i28 = 30 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                    char minimumFlingVelocity = (char) (49362 - (ViewConfiguration.getMinimumFlingVelocity() >> 16));
                    int iIndexOf = TextUtils.indexOf("", "") + 684;
                    byte[] bArr5 = $$a;
                    Object[] objArr32 = new Object[1];
                    a((byte) (-bArr5[4]), (byte) ($$b & 122), (byte) (bArr5[114] + 1), objArr32);
                    objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(i28, minimumFlingVelocity, iIndexOf, -1583976536, false, (String) objArr32[0], null);
                }
                ((Field) objAccessartificialFrame7).set(null, lValueOf2);
            } catch (Exception unused2) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame8 == null) {
                int i29 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 29;
                char c3 = (char) (49362 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)));
                int capsMode = 684 - TextUtils.getCapsMode("", 0, 0);
                Object[] objArr33 = new Object[1];
                a($$a[5], (byte) 68, (byte) ($$b & b.l), objArr33);
                objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i29, c3, capsMode, -1456483158, false, (String) objArr33[0], null);
            }
            Object[] objArr34 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
            objArr2 = new Object[]{new int[]{((int[]) objArr34[0])[0]}, new int[]{((int[]) objArr34[1])[0]}, new int[1], (String) objArr34[3]};
            int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
            int i30 = 512609598 + (((~(509445203 | iMaxMemory)) | 469178571) * 672);
            int i31 = ~iMaxMemory;
            int i32 = i30 + (((~(iMaxMemory | 469178571)) | (~((-509445204) | i31))) * (-672)) + (((~((-469178572) | i31)) | 27400328) * 672) + 461727106;
            int i33 = (i32 << 13) ^ i32;
            int i34 = i33 ^ (i33 >>> 17);
            ((int[]) objArr2[2])[0] = i34 ^ (i34 << 5);
        }
        int i35 = ((int[]) objArr2[1])[0];
        int i36 = ((int[]) objArr2[0])[0];
        if (i36 == i35) {
            int i37 = ((int[]) objArr2[2])[0];
            Object[] objArr35 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int iNextInt = new Random().nextInt(1449323408);
            int i38 = ~iNextInt;
            int i39 = i37 + 553445384 + (((~(i38 | 440608690)) | (-978548735) | (~((-75041) | iNextInt))) * 717) + (((~(iNextInt | 440608690)) | (~(i38 | (-75041))) | (-978548735)) * 717);
            int i40 = (i39 << 13) ^ i39;
            int i41 = i40 ^ (i40 >>> 17);
            ((int[]) objArr35[2])[0] = i41 ^ (i41 << 5);
        } else {
            new ArrayList().add((String) objArr2[3]);
            Object[] objArr36 = {Long.valueOf(((long) (i35 ^ i36)) ^ (((long) 238725705) << 32)), Long.valueOf(238725721)};
            byte[] bArr6 = $$d;
            Object[] objArr37 = new Object[1];
            c((short) 220, bArr6[14], bArr6[51], objArr37);
            Class<?> cls5 = Class.forName((String) objArr37[0]);
            Object[] objArr38 = new Object[1];
            c(bArr6[173], (byte) 89, bArr6[28], objArr38);
            cls5.getMethod((String) objArr38[0], Long.TYPE, Long.TYPE).invoke(null, objArr36);
            int i42 = ((int[]) objArr2[2])[0];
            Object[] objArr39 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int i43 = ~((int) Process.getStartElapsedRealtime());
            int i44 = i42 + (-469710298) + (((~(771464463 | i43)) | 207159311) * (-828)) + ((i43 | 771464463) * (-828)) + 1177550912;
            int i45 = (i44 << 13) ^ i44;
            int i46 = i45 ^ (i45 >>> 17);
            ((int[]) objArr39[2])[0] = i46 ^ (i46 << 5);
        }
        Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame9 == null) {
            int maximumFlingVelocity = 26 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
            char cMyPid = (char) (Process.myPid() >> 22);
            int threadPriority = 1041 - ((Process.getThreadPriority(0) + 20) >> 6);
            byte[] bArr7 = $$a;
            byte b7 = bArr7[5];
            byte b8 = bArr7[21];
            Object[] objArr40 = new Object[1];
            a(b7, b8, (byte) (b8 & 47), objArr40);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity, cMyPid, threadPriority, 2061780482, false, (String) objArr40[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j3 == -1 || j3 + 4611686018427387785L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            try {
                Object[] objArr41 = {-1738251855};
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame10 == null) {
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 7, (char) (ExpandableListView.getPackedPositionGroup(0L) + 22251), 1033 - ((Process.getThreadPriority(0) + 20) >> 6), 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = zza.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame10).newInstance(objArr41), 842364327, false);
                Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame11 == null) {
                    int i47 = 27 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                    char cArgb = (char) Color.argb(0, 0, 0, 0);
                    int iLastIndexOf = TextUtils.lastIndexOf("", '0', 0, 0) + 1042;
                    byte[] bArr8 = $$a;
                    byte b9 = bArr8[5];
                    byte b10 = bArr8[11];
                    Object[] objArr42 = new Object[1];
                    a(b9, b10, (byte) (b10 | 40), objArr42);
                    objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(i47, cArgb, iLastIndexOf, 1145017376, false, (String) objArr42[0], null);
                }
                ((Field) objAccessartificialFrame11).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame12 == null) {
                        int doubleTapTimeout2 = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 26;
                        char cIndexOf = (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0'));
                        int windowTouchSlop2 = 1041 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                        byte[] bArr9 = $$a;
                        byte b11 = bArr9[5];
                        byte b12 = bArr9[21];
                        Object[] objArr43 = new Object[1];
                        a(b11, b12, (byte) (b12 & 47), objArr43);
                        objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout2, cIndexOf, windowTouchSlop2, 2061780482, false, (String) objArr43[0], null);
                    }
                    ((Field) objAccessartificialFrame12).set(null, lValueOf3);
                } catch (Exception unused3) {
                    throw new RuntimeException();
                }
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        } else {
            Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame13 == null) {
                int touchSlop2 = 26 - (ViewConfiguration.getTouchSlop() >> 8);
                char cCombineMeasuredStates = (char) View.combineMeasuredStates(0, 0);
                int iLastIndexOf2 = TextUtils.lastIndexOf("", '0') + 1042;
                byte[] bArr10 = $$a;
                byte b13 = bArr10[5];
                byte b14 = bArr10[11];
                Object[] objArr44 = new Object[1];
                a(b13, b14, (byte) (b14 | 40), objArr44);
                objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(touchSlop2, cCombineMeasuredStates, iLastIndexOf2, 1145017376, false, (String) objArr44[0], null);
            }
            Object[] objArr45 = (Object[]) ((Field) objAccessartificialFrame13).get(null);
            objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
            int i48 = ((int[]) objArr45[3])[0];
            int i49 = ((int[]) objArr45[2])[0];
            String[] strArr = (String[]) objArr45[0];
            int i50 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().smallestScreenWidthDp;
            int i51 = (((-321632492) + (((~((-80234753) | i50)) | (~((-2130946) | i50))) * 69)) + (((~(i50 | (-20297360))) | ((~((-98401167) | i50)) | 18166414)) * (-69))) - 1799384105;
            int i52 = (i51 << 13) ^ i51;
            int i53 = i52 ^ (i52 >>> 17);
            ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i53 ^ (i53 << 5);
        }
        int i54 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i55 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i55 == i54) {
            int i56 = artificialFrame + 75;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i56 % 128;
            int i57 = i56 % 2;
            Object[] objArr46 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i58 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i59 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i60 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int startUptimeMillis = (int) Process.getStartUptimeMillis();
            int i61 = i58 + (((~(startUptimeMillis | 140034108)) | (-61930302)) * 56) + 887604534 + (((~((~startUptimeMillis) | (-61930302))) | 140034108) * 56);
            int i62 = (i61 << 13) ^ i61;
            int i63 = i62 ^ (i62 >>> 17);
            ((int[]) objArr46[1])[0] = i63 ^ (i63 << 5);
            i2 = 0;
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr3 != null) {
                int i64 = artificialFrame + 21;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i64 % 128;
                for (int i65 = i64 % 2 != 0 ? 1 : 0; i65 < strArr3.length; i65++) {
                    arrayList.add(strArr3[i65]);
                }
            }
            Object[] objArr47 = {Long.valueOf((((long) 372378177) << 32) ^ ((long) (i54 ^ i55))), Long.valueOf(372378179)};
            byte[] bArr11 = $$d;
            Object[] objArr48 = new Object[1];
            c((short) 254, bArr11[143], bArr11[453], objArr48);
            Class<?> cls6 = Class.forName((String) objArr48[0]);
            Object[] objArr49 = new Object[1];
            c(bArr11[173], (byte) 89, bArr11[28], objArr49);
            cls6.getMethod((String) objArr49[0], Long.TYPE, Long.TYPE).invoke(null, objArr47);
            Object[] objArr50 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i66 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i67 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i68 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iIdentityHashCode = System.identityHashCode(this);
            int i69 = ~iIdentityHashCode;
            int i70 = i66 + (-1081371221) + (((~((-45994254) | i69)) | (~((-32109554) | iIdentityHashCode))) * JfifUtil.MARKER_EOI) + (((~(iIdentityHashCode | (-45994254))) | 11129089) * JfifUtil.MARKER_EOI) + (((~((-32109554) | i69)) | 45994253) * JfifUtil.MARKER_EOI);
            int i71 = (i70 << 13) ^ i70;
            int i72 = i71 ^ (i71 >>> 17);
            i2 = 0;
            ((int[]) objArr50[1])[0] = i72 ^ (i72 << 5);
        }
        Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame14 == null) {
            int bitsPerPixel = 16 - ImageFormat.getBitsPerPixel(i2);
            char keyRepeatTimeout = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
            int minimumFlingVelocity2 = 747 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
            byte[] bArr12 = $$a;
            byte b15 = bArr12[5];
            byte b16 = bArr12[21];
            Object[] objArr51 = new Object[1];
            a(b15, b16, (byte) (b16 & 47), objArr51);
            objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(bitsPerPixel, keyRepeatTimeout, minimumFlingVelocity2, -144068856, false, (String) objArr51[0], null);
        }
        long j4 = ((Field) objAccessartificialFrame14).getLong(null);
        if (j4 == -1 || j4 + 4611686018427387894L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext2 = getBaseContext();
            if (baseContext2 == null) {
                Object[] objArr52 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 9, new char[]{18, 3, 25, '.', CoreConstants.DASH_CHAR, CoreConstants.SINGLE_QUOTE_CHAR, 16, '.', 20, CoreConstants.DASH_CHAR, '*', CoreConstants.DASH_CHAR, '\f', 1, 31, CoreConstants.RIGHT_PARENTHESIS_CHAR, 24, '#', 30, CoreConstants.RIGHT_PARENTHESIS_CHAR, CoreConstants.RIGHT_PARENTHESIS_CHAR, 26, CoreConstants.PERCENT_CHAR, 11, 18, 19}, (byte) (TextUtils.indexOf("", "") + 101), objArr52);
                Class<?> cls7 = Class.forName((String) objArr52[0]);
                Object[] objArr53 = new Object[1];
                b(18 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), new char[]{6, 4, 13816, 13816, 11, 2, 29, CharUtils.CR, 13818, 13818, CoreConstants.DASH_CHAR, '$', 3, 19, 31, CoreConstants.RIGHT_PARENTHESIS_CHAR, 4, 11}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19), objArr53);
                baseContext2 = (Context) cls7.getMethod((String) objArr53[0], new Class[0]).invoke(null, null);
            }
            if (baseContext2 != null) {
                baseContext2 = ((baseContext2 instanceof ContextWrapper) && ((ContextWrapper) baseContext2).getBaseContext() == null) ? null : baseContext2.getApplicationContext();
            }
            Object[] objArr54 = {baseContext2, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1320063466};
            byte[] bArr13 = $$d;
            Object[] objArr55 = new Object[1];
            c((short) 308, (byte) (bArr13[668] - 1), bArr13[51], objArr55);
            Class<?> cls8 = Class.forName((String) objArr55[0]);
            Object[] objArr56 = new Object[1];
            c((short) 130, bArr13[652], bArr13[78], objArr56);
            objArr3 = (Object[]) cls8.getMethod((String) objArr56[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr54);
            Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame15 == null) {
                int maxKeyCode = (KeyEvent.getMaxKeyCode() >> 16) + 17;
                char c4 = (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1);
                int capsMode2 = TextUtils.getCapsMode("", 0, 0) + 747;
                byte[] bArr14 = $$a;
                byte b17 = bArr14[5];
                byte b18 = bArr14[11];
                Object[] objArr57 = new Object[1];
                a(b17, b18, (byte) (b18 | 40), objArr57);
                objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(maxKeyCode, c4, capsMode2, -1031537386, false, (String) objArr57[0], null);
            }
            ((Field) objAccessartificialFrame15).set(null, objArr3);
            try {
                Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame16 == null) {
                    int jumpTapTimeout2 = (ViewConfiguration.getJumpTapTimeout() >> 16) + 17;
                    char cResolveSizeAndState = (char) View.resolveSizeAndState(0, 0, 0);
                    int packedPositionType2 = ExpandableListView.getPackedPositionType(0L) + 747;
                    byte[] bArr15 = $$a;
                    byte b19 = bArr15[5];
                    byte b20 = bArr15[21];
                    Object[] objArr58 = new Object[1];
                    a(b19, b20, (byte) (b20 & 47), objArr58);
                    objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout2, cResolveSizeAndState, packedPositionType2, -144068856, false, (String) objArr58[0], null);
                }
                ((Field) objAccessartificialFrame16).set(null, lValueOf4);
            } catch (Exception unused4) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame17 == null) {
                int scrollBarSize = 17 - (ViewConfiguration.getScrollBarSize() >> 8);
                char cBlue = (char) Color.blue(0);
                int i73 = 748 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                byte[] bArr16 = $$a;
                byte b21 = bArr16[5];
                byte b22 = bArr16[11];
                Object[] objArr59 = new Object[1];
                a(b21, b22, (byte) (b22 | 40), objArr59);
                objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(scrollBarSize, cBlue, i73, -1031537386, false, (String) objArr59[0], null);
            }
            Object[] objArr60 = (Object[]) ((Field) objAccessartificialFrame17).get(null);
            objArr3 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
            int i74 = ((int[]) objArr60[3])[0];
            int i75 = ((int[]) objArr60[4])[0];
            List list = (List) objArr60[0];
            List list2 = (List) objArr60[2];
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i76 = (((~((-266939696) | iIdentityHashCode2)) | 465835765) * 398) + 1449212337 + (((~((~iIdentityHashCode2) | (-266939696))) | 465835765) * 398) + 1320063466;
            int i77 = (i76 << 13) ^ i76;
            int i78 = i77 ^ (i77 >>> 17);
            ((int[]) objArr3[1])[0] = i78 ^ (i78 << 5);
        }
        int i79 = ((int[]) objArr3[4])[0];
        int i80 = ((int[]) objArr3[3])[0];
        if (i80 == i79) {
            Object[] objArr61 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i81 = ((int[]) objArr3[1])[0];
            int i82 = ((int[]) objArr3[3])[0];
            int i83 = ((int[]) objArr3[4])[0];
            List list3 = (List) objArr3[0];
            List list4 = (List) objArr3[2];
            int i84 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().densityDpi;
            int i85 = (-337684703) + ((~(i84 | 419845697)) * JfifUtil.MARKER_SOI);
            int i86 = ~i84;
            int i87 = i81 + i85 + (((-34603145) | i86) * (-216)) + (((~(i86 | 419845697)) | 185602760) * JfifUtil.MARKER_SOI);
            int i88 = (i87 << 13) ^ i87;
            int i89 = i88 ^ (i88 >>> 17);
            ((int[]) objArr61[1])[0] = i89 ^ (i89 << 5);
        } else {
            ArrayList arrayList2 = new ArrayList();
            Object[] objArr62 = {objArr3};
            Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(1804664566);
            if (objAccessartificialFrame18 == null) {
                objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(41 - TextUtils.getOffsetBefore("", 0), (char) (TextUtils.getTrimmedLength("") + 12468), 3642 - TextUtils.getOffsetBefore("", 0), -185222914, false, "coroutineCreation", new Class[]{Object[].class});
            }
            arrayList2.add(((Method) objAccessartificialFrame18).invoke(null, objArr62));
            Object[] objArr63 = {objArr3};
            Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-1243809191);
            if (objAccessartificialFrame19 == null) {
                objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(41 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 12468), TextUtils.indexOf("", "", 0) + 3642, 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
            }
            arrayList2.add(((Method) objAccessartificialFrame19).invoke(null, objArr63));
            Object[] objArr64 = {Long.valueOf(((long) (i79 ^ i80)) ^ (((long) 869559913) << 32)), Long.valueOf(869559905)};
            byte[] bArr17 = $$d;
            Object[] objArr65 = new Object[1];
            c((short) 353, bArr17[193], bArr17[51], objArr65);
            Class<?> cls9 = Class.forName((String) objArr65[0]);
            Object[] objArr66 = new Object[1];
            c(bArr17[173], (byte) 89, bArr17[28], objArr66);
            cls9.getMethod((String) objArr66[0], Long.TYPE, Long.TYPE).invoke(null, objArr64);
            Object[] objArr67 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i90 = ((int[]) objArr3[1])[0];
            int i91 = ((int[]) objArr3[3])[0];
            int i92 = ((int[]) objArr3[4])[0];
            List list5 = (List) objArr3[0];
            List list6 = (List) objArr3[2];
            int i93 = ~(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 2048615911);
            int i94 = i90 + (-1078332451) + ((~((-104727) | i93)) * 52) + (((~(897083104 | i93)) | (~(291634646 | i93)) | (-897187831)) * (-52)) + (((~(i93 | (-897083105))) | 291529920) * 52);
            int i95 = (i94 << 13) ^ i94;
            int i96 = i95 ^ (i95 >>> 17);
            ((int[]) objArr67[1])[0] = i96 ^ (i96 << 5);
        }
        Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame20 == null) {
            int gidForName2 = 24 - Process.getGidForName("");
            char maxKeyCode2 = (char) ((KeyEvent.getMaxKeyCode() >> 16) + 30068);
            int i97 = 816 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
            byte[] bArr18 = $$a;
            byte b23 = bArr18[5];
            byte b24 = bArr18[21];
            Object[] objArr68 = new Object[1];
            a(b23, b24, (byte) (b24 & 47), objArr68);
            objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(gidForName2, maxKeyCode2, i97, 721586079, false, (String) objArr68[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame20).getLong(null);
        if (j5 == -1 || j5 + 1977 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr69 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 859476947};
            Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame21 == null) {
                int scrollBarFadeDuration2 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 25;
                char cNormalizeMetaState2 = (char) (KeyEvent.normalizeMetaState(0) + 30068);
                int iAlpha = 816 - Color.alpha(0);
                byte[] bArr19 = $$a;
                Object[] objArr70 = new Object[1];
                a(bArr19[0], bArr19[38], bArr19[65], objArr70);
                objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration2, cNormalizeMetaState2, iAlpha, -797394565, false, (String) objArr70[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr4 = (Object[]) ((Method) objAccessartificialFrame21).invoke(null, objArr69);
            Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame22 == null) {
                int edgeSlop2 = (ViewConfiguration.getEdgeSlop() >> 16) + 25;
                char scrollDefaultDelay = (char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 30068);
                int iKeyCodeFromString = KeyEvent.keyCodeFromString("") + 816;
                byte[] bArr20 = $$a;
                byte b25 = bArr20[5];
                byte b26 = bArr20[11];
                Object[] objArr71 = new Object[1];
                a(b25, b26, (byte) (b26 | 40), objArr71);
                objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(edgeSlop2, scrollDefaultDelay, iKeyCodeFromString, 891606461, false, (String) objArr71[0], null);
            }
            ((Field) objAccessartificialFrame22).set(null, objArr4);
            try {
                Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame23 == null) {
                    int scrollBarSize2 = 25 - (ViewConfiguration.getScrollBarSize() >> 8);
                    char mode = (char) (View.MeasureSpec.getMode(0) + 30068);
                    int iIndexOf2 = TextUtils.indexOf("", "", 0, 0) + 816;
                    byte[] bArr21 = $$a;
                    byte b27 = bArr21[5];
                    byte b28 = bArr21[21];
                    Object[] objArr72 = new Object[1];
                    a(b27, b28, (byte) (b28 & 47), objArr72);
                    objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(scrollBarSize2, mode, iIndexOf2, 721586079, false, (String) objArr72[0], null);
                }
                ((Field) objAccessartificialFrame23).set(null, lValueOf5);
            } catch (Exception unused5) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame24 == null) {
                int keyRepeatTimeout2 = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 25;
                char packedPositionType3 = (char) (ExpandableListView.getPackedPositionType(0L) + 30068);
                int iIndexOf3 = 816 - TextUtils.indexOf("", "");
                byte[] bArr22 = $$a;
                byte b29 = bArr22[5];
                byte b30 = bArr22[11];
                Object[] objArr73 = new Object[1];
                a(b29, b30, (byte) (b30 | 40), objArr73);
                objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout2, packedPositionType3, iIndexOf3, 891606461, false, (String) objArr73[0], null);
            }
            Object[] objArr74 = (Object[]) ((Field) objAccessartificialFrame24).get(null);
            objArr4 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i98 = ((int[]) objArr74[0])[0];
            int i99 = ((int[]) objArr74[1])[0];
            String[] strArr5 = (String[]) objArr74[2];
            int i100 = Settings.System.getInt(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getContentResolver(), "screen_brightness", -1);
            int i101 = 551050819 + (((~(i100 | (-428428437))) | 626600802) * 191) + (((~((~i100) | (-428428437))) | 17369088) * 191) + 859476947;
            int i102 = (i101 << 13) ^ i101;
            int i103 = i102 ^ (i102 >>> 17);
            ((int[]) objArr4[3])[0] = i103 ^ (i103 << 5);
        }
        int i104 = ((int[]) objArr4[1])[0];
        int i105 = ((int[]) objArr4[0])[0];
        if (i105 == i104) {
            Object[] objArr75 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i106 = ((int[]) objArr4[3])[0];
            int i107 = ((int[]) objArr4[0])[0];
            int i108 = ((int[]) objArr4[1])[0];
            String[] strArr6 = (String[]) objArr4[2];
            int i109 = ~System.identityHashCode(this);
            int i110 = i106 + (((~((-549110059) | i109)) | 537919778) * (-241)) + 454105694 + (((~(i109 | (-11190281))) | (-888857471)) * 241);
            int i111 = (i110 << 13) ^ i110;
            int i112 = i111 ^ (i111 >>> 17);
            i3 = 0;
            ((int[]) objArr75[3])[0] = i112 ^ (i112 << 5);
        } else {
            ArrayList arrayList3 = new ArrayList();
            String[] strArr7 = (String[]) objArr4[2];
            if (strArr7 != null) {
                for (String str5 : strArr7) {
                    arrayList3.add(str5);
                }
            }
            Object[] objArr76 = {Long.valueOf(((long) (i104 ^ i105)) ^ (((long) 337524662) << 32)), Long.valueOf(337524663)};
            byte[] bArr23 = $$d;
            Object[] objArr77 = new Object[1];
            c(bArr23[28], (byte) (-bArr23[327]), bArr23[51], objArr77);
            Class<?> cls10 = Class.forName((String) objArr77[0]);
            Object[] objArr78 = new Object[1];
            c(bArr23[173], (byte) 89, bArr23[28], objArr78);
            cls10.getMethod((String) objArr78[0], Long.TYPE, Long.TYPE).invoke(null, objArr76);
            Object[] objArr79 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i113 = ((int[]) objArr4[3])[0];
            int i114 = ((int[]) objArr4[0])[0];
            int i115 = ((int[]) objArr4[1])[0];
            String[] strArr8 = (String[]) objArr4[2];
            int i116 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenLayout;
            int i117 = i113 + ((~((-67716174) | i116)) * 521) + 126321048 + (((~((~i116) | (-67716174))) | (-1073309568)) * 521);
            int i118 = (i117 << 13) ^ i117;
            int i119 = i118 ^ (i118 >>> 17);
            i3 = 0;
            ((int[]) objArr79[3])[0] = i119 ^ (i119 << 5);
        }
        super.onCreate();
        Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame25 == null) {
            int iMyTid = (Process.myTid() >> 22) + 21;
            char cRgb = (char) (ViewCompat.MEASURED_STATE_MASK - Color.rgb(i3, i3, i3));
            int i120 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 464;
            byte[] bArr24 = $$a;
            byte b31 = bArr24[5];
            byte b32 = bArr24[21];
            Object[] objArr80 = new Object[1];
            a(b31, b32, (byte) (b32 & 47), objArr80);
            objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(iMyTid, cRgb, i120, -785931255, false, (String) objArr80[0], null);
        }
        long j6 = ((Field) objAccessartificialFrame25).getLong(null);
        if (j6 == -1 || j6 + 1930 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext3 = getBaseContext();
            if (baseContext3 == null) {
                Object[] objArr81 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 5, new char[]{18, 3, 25, '.', CoreConstants.DASH_CHAR, CoreConstants.SINGLE_QUOTE_CHAR, 16, '.', 20, CoreConstants.DASH_CHAR, '*', CoreConstants.DASH_CHAR, '\f', 1, 31, CoreConstants.RIGHT_PARENTHESIS_CHAR, 24, '#', 30, CoreConstants.RIGHT_PARENTHESIS_CHAR, CoreConstants.RIGHT_PARENTHESIS_CHAR, 26, CoreConstants.PERCENT_CHAR, 11, 18, 19}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 80), objArr81);
                Class<?> cls11 = Class.forName((String) objArr81[0]);
                Object[] objArr82 = new Object[1];
                b(18 - (ViewConfiguration.getTapTimeout() >> 16), new char[]{6, 4, 13816, 13816, 11, 2, 29, CharUtils.CR, 13818, 13818, CoreConstants.DASH_CHAR, '$', 3, 19, 31, CoreConstants.RIGHT_PARENTHESIS_CHAR, 4, 11}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19), objArr82);
                baseContext3 = (Context) cls11.getMethod((String) objArr82[0], new Class[0]).invoke(null, null);
            }
            if (baseContext3 != null) {
                baseContext3 = ((baseContext3 instanceof ContextWrapper) && ((ContextWrapper) baseContext3).getBaseContext() == null) ? null : baseContext3.getApplicationContext();
            }
            int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr83 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(17) - 41, new char[]{21, Typography.amp, 21, 14, 30, '\f', 21, 17, 6, 19, Typography.amp, 24, 6, '#', 31, 23, 11, 16, Typography.amp, '\"', '\"', 17, 31, 23, 15, 18, 28, 5, 16, ' ', '\n', 23, 31, Typography.amp, ' ', 17, 31, 23, 17, 27, 1, 6, 31, Typography.amp, 31, '!', 6, 1, 31, 24, 18, 15, 18, '\"', Typography.amp, 20, 1, 6, 16, '\n', 19, 0, 19, ' '}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 97), objArr83);
            String str6 = (String) objArr83[0];
            Object[] objArr84 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 43, new char[]{28, 17, 13855, 13855, '\n', 23, 4, 28, CoreConstants.RIGHT_PARENTHESIS_CHAR, 14, ' ', 29, CoreConstants.LEFT_PARENTHESIS_CHAR, '\"', 19, 14, '\"', CoreConstants.LEFT_PARENTHESIS_CHAR, CoreConstants.PERCENT_CHAR, 7, 24, 31, Typography.amp, 24, 18, '\"', '#', CharUtils.CR, 17, ' ', '#', 14, ' ', '\"', 13768, 13768, Typography.amp, 24, '\n', 30, 14, CharUtils.CR, 28, '\n', 28, 5, 21, 14, 19, 28, 24, 31, 30, 7, 13772, 13772, 31, 14, 31, '\"', 3, 14, 23, '\n'}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 83), objArr84);
            Object[] objArr85 = {baseContext3, new String[]{str6, (String) objArr84[0]}, Integer.valueOf(iIntValue2), 1, 944460953};
            short s = (short) TypedValues.CycleType.TYPE_PATH_ROTATE;
            byte[] bArr25 = $$d;
            Object[] objArr86 = new Object[1];
            c(s, bArr25[28], bArr25[51], objArr86);
            Class<?> cls12 = Class.forName((String) objArr86[0]);
            Object[] objArr87 = new Object[1];
            c((short) TypedValues.PositionType.TYPE_PERCENT_Y, (byte) (bArr25[652] - 1), bArr25[7], objArr87);
            objArr5 = (Object[]) cls12.getMethod((String) objArr87[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr85);
            int i121 = ((int[]) objArr5[0])[0];
            int i122 = ((int[]) objArr5[3])[0];
            if (baseContext3 != null) {
                Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame26 == null) {
                    int i123 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 22;
                    char cLastIndexOf = (char) (TextUtils.lastIndexOf("", '0') + 1);
                    int iResolveOpacity = Drawable.resolveOpacity(0, 0) + 465;
                    byte[] bArr26 = $$a;
                    byte b33 = bArr26[5];
                    byte b34 = bArr26[11];
                    Object[] objArr88 = new Object[1];
                    a(b33, b34, (byte) (b34 | 40), objArr88);
                    objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(i123, cLastIndexOf, iResolveOpacity, -612765161, false, (String) objArr88[0], null);
                }
                ((Field) objAccessartificialFrame26).set(null, objArr5);
                try {
                    Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(1313006081);
                    if (objAccessartificialFrame27 == null) {
                        int mode2 = 21 - View.MeasureSpec.getMode(0);
                        char c5 = (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1);
                        int offsetAfter = 465 - TextUtils.getOffsetAfter("", 0);
                        byte[] bArr27 = $$a;
                        byte b35 = bArr27[5];
                        byte b36 = bArr27[21];
                        Object[] objArr89 = new Object[1];
                        a(b35, b36, (byte) (b36 & 47), objArr89);
                        objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(mode2, c5, offsetAfter, -785931255, false, (String) objArr89[0], null);
                    }
                    ((Field) objAccessartificialFrame27).set(null, lValueOf6);
                } catch (Exception unused6) {
                    throw new RuntimeException();
                }
            }
            c = 0;
        } else {
            Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(1142731807);
            if (objAccessartificialFrame28 == null) {
                int i124 = 22 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                char cBlue2 = (char) Color.blue(0);
                int capsMode3 = 465 - TextUtils.getCapsMode("", 0, 0);
                byte[] bArr28 = $$a;
                byte b37 = bArr28[5];
                byte b38 = bArr28[11];
                Object[] objArr90 = new Object[1];
                a(b37, b38, (byte) (b38 | 40), objArr90);
                objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(i124, cBlue2, capsMode3, -612765161, false, (String) objArr90[0], null);
            }
            Object[] objArr91 = (Object[]) ((Field) objAccessartificialFrame28).get(null);
            objArr5 = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
            int i125 = ((int[]) objArr91[3])[0];
            int i126 = ((int[]) objArr91[0])[0];
            String[] strArr9 = (String[]) objArr91[1];
            int startUptimeMillis2 = (int) Process.getStartUptimeMillis();
            int i127 = ~startUptimeMillis2;
            int i128 = 1935924018 + ((248720863 | i127) * (-757)) + ((~(265777119 | startUptimeMillis2)) * 1514) + (((~(startUptimeMillis2 | (-17056257))) | (~(i127 | 88371137)) | 177405982) * 757) + 944460953;
            int i129 = (i128 << 13) ^ i128;
            int i130 = i129 ^ (i129 >>> 17);
            ((int[]) objArr5[2])[0] = i130 ^ (i130 << 5);
            c = 0;
        }
        int i131 = ((int[]) objArr5[c])[c];
        int i132 = ((int[]) objArr5[3])[c];
        if (i132 == i131) {
            int i133 = artificialFrame + 95;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i133 % 128;
            int i134 = i133 % 2;
            Object[] objArr92 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i135 = ((int[]) objArr5[2])[0];
            int i136 = ((int[]) objArr5[3])[0];
            int i137 = ((int[]) objArr5[0])[0];
            String[] strArr10 = (String[]) objArr5[1];
            int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 428042583;
            int i138 = ~((-124872415) | length);
            int i139 = (-209237743) + ((90185920 | i138) * (-280)) + ((i138 | (~((-35477312) | length))) * 140);
            int i140 = ~((-34686495) | length);
            int i141 = ~length;
            int i142 = i135 + i139 + (((~(i141 | (-790818))) | i140 | (~((-90185921) | i141))) * 140);
            int i143 = (i142 << 13) ^ i142;
            int i144 = i143 ^ (i143 >>> 17);
            ((int[]) objArr92[2])[0] = i144 ^ (i144 << 5);
        } else {
            ArrayList arrayList4 = new ArrayList();
            String[] strArr11 = (String[]) objArr5[1];
            if (strArr11 != null) {
                for (String str7 : strArr11) {
                    arrayList4.add(str7);
                }
            }
            long j7 = (((long) 1454069661) << 32) ^ ((long) (i131 ^ i132));
            long j8 = 1454069725;
            int i145 = artificialFrame + 89;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i145 % 128;
            int i146 = i145 % 2;
            Object[] objArr93 = {Long.valueOf(j7), Long.valueOf(j8)};
            byte[] bArr29 = $$d;
            Object[] objArr94 = new Object[1];
            c((short) 527, bArr29[291], bArr29[51], objArr94);
            Class<?> cls13 = Class.forName((String) objArr94[0]);
            Object[] objArr95 = new Object[1];
            c(bArr29[173], (byte) 89, bArr29[28], objArr95);
            cls13.getMethod((String) objArr95[0], Long.TYPE, Long.TYPE).invoke(null, objArr93);
            Object[] objArr96 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i147 = ((int[]) objArr5[2])[0];
            int i148 = ((int[]) objArr5[3])[0];
            int i149 = ((int[]) objArr5[0])[0];
            String[] strArr12 = (String[]) objArr5[1];
            int iMaxMemory2 = (int) Runtime.getRuntime().maxMemory();
            int i150 = i147 + (-945512746) + (((~((-177652481) | iMaxMemory2)) | (~((-17302755) | iMaxMemory2))) * 69) + (((~(iMaxMemory2 | (-627639524))) | (~((-787989250) | iMaxMemory2)) | 610336769) * (-69)) + 269426572;
            int i151 = (i150 << 13) ^ i150;
            int i152 = i151 ^ (i151 >>> 17);
            ((int[]) objArr96[2])[0] = i152 ^ (i152 << 5);
        }
        Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame29 == null) {
            int fadingEdgeLength = (ViewConfiguration.getFadingEdgeLength() >> 16) + 30;
            char pressedStateDuration = (char) (49362 - (ViewConfiguration.getPressedStateDuration() >> 16));
            int packedPositionChild = 683 - ExpandableListView.getPackedPositionChild(0L);
            Object[] objArr97 = new Object[1];
            a((byte) (-$$a[4]), (byte) 76, (byte) 45, objArr97);
            objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength, pressedStateDuration, packedPositionChild, 508509282, false, (String) objArr97[0], null);
        }
        long j9 = ((Field) objAccessartificialFrame29).getLong(null);
        if (j9 == -1 || j9 + 1914 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext4 = getBaseContext();
            if (baseContext4 == null) {
                Object[] objArr98 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 23, new char[]{18, 3, 25, '.', CoreConstants.DASH_CHAR, CoreConstants.SINGLE_QUOTE_CHAR, 16, '.', 20, CoreConstants.DASH_CHAR, '*', CoreConstants.DASH_CHAR, '\f', 1, 31, CoreConstants.RIGHT_PARENTHESIS_CHAR, 24, '#', 30, CoreConstants.RIGHT_PARENTHESIS_CHAR, CoreConstants.RIGHT_PARENTHESIS_CHAR, 26, CoreConstants.PERCENT_CHAR, 11, 18, 19}, (byte) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 101), objArr98);
                Class<?> cls14 = Class.forName((String) objArr98[0]);
                Object[] objArr99 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 14, new char[]{6, 4, 13816, 13816, 11, 2, 29, CharUtils.CR, 13818, 13818, CoreConstants.DASH_CHAR, '$', 3, 19, 31, CoreConstants.RIGHT_PARENTHESIS_CHAR, 4, 11}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19), objArr99);
                baseContext4 = (Context) cls14.getMethod((String) objArr99[0], new Class[0]).invoke(null, null);
            }
            if (baseContext4 != null) {
                baseContext4 = ((baseContext4 instanceof ContextWrapper) && ((ContextWrapper) baseContext4).getBaseContext() == null) ? null : baseContext4.getApplicationContext();
            }
            int iIntValue3 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            int i153 = artificialFrame + 57;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i153 % 128;
            int i154 = i153 % 2;
            Object[] objArr100 = {baseContext4, Integer.valueOf(iIntValue3), -1679844139};
            byte[] bArr30 = $$d;
            Object[] objArr101 = new Object[1];
            c((short) 592, bArr30[668], bArr30[21], objArr101);
            Class<?> cls15 = Class.forName((String) objArr101[0]);
            Object[] objArr102 = new Object[1];
            c((short) TypedValues.PositionType.TYPE_PERCENT_Y, (byte) (bArr30[652] - 1), bArr30[7], objArr102);
            objArr6 = (Object[]) cls15.getMethod((String) objArr102[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr100);
            if (baseContext4 != null) {
                int i155 = artificialFrame + 7;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i155 % 128;
                int i156 = i155 % 2;
                Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame30 == null) {
                    int iAxisFromString = MotionEvent.axisFromString("") + 31;
                    char maximumDrawingCacheSize = (char) ((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 49362);
                    int iBlue2 = Color.blue(0) + 684;
                    byte[] bArr31 = $$a;
                    byte b39 = (byte) (bArr31[5] - 1);
                    Object[] objArr103 = new Object[1];
                    a(b39, (byte) (b39 | 88), (byte) (-bArr31[15]), objArr103);
                    objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(iAxisFromString, maximumDrawingCacheSize, iBlue2, -1321816393, false, (String) objArr103[0], null);
                }
                ((Field) objAccessartificialFrame30).set(null, objArr6);
                try {
                    Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                    if (objAccessartificialFrame31 == null) {
                        int iNormalizeMetaState = 30 - KeyEvent.normalizeMetaState(0);
                        char cLastIndexOf2 = (char) (TextUtils.lastIndexOf("", '0') + 49363);
                        int iGreen = 684 - Color.green(0);
                        Object[] objArr104 = new Object[1];
                        a((byte) (-$$a[4]), (byte) 76, (byte) 45, objArr104);
                        objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState, cLastIndexOf2, iGreen, 508509282, false, (String) objArr104[0], null);
                    }
                    ((Field) objAccessartificialFrame31).set(null, lValueOf7);
                } catch (Exception unused7) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(777251007);
            if (objAccessartificialFrame32 == null) {
                int doubleTapTimeout3 = 30 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                char cRed = (char) (Color.red(0) + 49362);
                int i157 = 684 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                byte[] bArr32 = $$a;
                byte b40 = (byte) (bArr32[5] - 1);
                Object[] objArr105 = new Object[1];
                a(b40, (byte) (b40 | 88), (byte) (-bArr32[15]), objArr105);
                objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout3, cRed, i157, -1321816393, false, (String) objArr105[0], null);
            }
            Object[] objArr106 = (Object[]) ((Field) objAccessartificialFrame32).get(null);
            objArr6 = new Object[]{new int[]{((int[]) objArr106[0])[0]}, new int[]{((int[]) objArr106[1])[0]}, new int[1], (String) objArr106[3]};
            int iIdentityHashCode3 = System.identityHashCode(this);
            int i158 = (((-1020441538) + (((~((~iIdentityHashCode3) | 515890736)) | (-532676351)) * 529)) + (((~(iIdentityHashCode3 | 515890736)) | (-462733039)) * 529)) - 1679844139;
            int i159 = (i158 << 13) ^ i158;
            int i160 = i159 ^ (i159 >>> 17);
            ((int[]) objArr6[2])[0] = i160 ^ (i160 << 5);
        }
        int i161 = ((int[]) objArr6[1])[0];
        int i162 = ((int[]) objArr6[0])[0];
        if (i162 == i161) {
            int i163 = getARTIFICIAL_FRAME_PACKAGE_NAME + 25;
            artificialFrame = i163 % 128;
            int i164 = i163 % 2;
            int i165 = ((int[]) objArr6[2])[0];
            Object[] objArr107 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
            int iIdentityHashCode4 = System.identityHashCode(this);
            int i166 = ~iIdentityHashCode4;
            int i167 = i165 + (-1001025590) + (((~(20542813 | i166)) | (~((-999166589) | iIdentityHashCode4))) * 1900) + (((~(i166 | 999166588)) | (~(iIdentityHashCode4 | (-20542814)))) * (-950)) + (((~(iIdentityHashCode4 | 999166588)) | (~(i166 | (-20542814)))) * 950);
            int i168 = (i167 << 13) ^ i167;
            int i169 = i168 ^ (i168 >>> 17);
            ((int[]) objArr107[2])[0] = i169 ^ (i169 << 5);
        } else {
            Object[] objArr108 = {Long.valueOf((((long) 872097591) << 32) ^ ((long) (i161 ^ i162))), Long.valueOf(872097079)};
            byte[] bArr33 = $$d;
            Object[] objArr109 = new Object[1];
            c((short) 220, bArr33[14], bArr33[51], objArr109);
            Class<?> cls16 = Class.forName((String) objArr109[0]);
            Object[] objArr110 = new Object[1];
            c(bArr33[173], (byte) 89, bArr33[28], objArr110);
            cls16.getMethod((String) objArr110[0], Long.TYPE, Long.TYPE).invoke(null, objArr108);
            int i170 = ((int[]) objArr6[2])[0];
            Object[] objArr111 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
            int i171 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().touchscreen;
            int i172 = i170 + 1126768862 + (((~((-929721) | i171)) | 977694054) * (-366)) + (((~(i171 | (-524953))) | 977289286) * 366);
            int i173 = (i172 << 13) ^ i172;
            int i174 = i173 ^ (i173 >>> 17);
            ((int[]) objArr111[2])[0] = i174 ^ (i174 << 5);
        }
        Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame33 == null) {
            int i175 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 35;
            char c6 = (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
            int tapTimeout = 540 - (ViewConfiguration.getTapTimeout() >> 16);
            byte[] bArr34 = $$a;
            byte b41 = bArr34[5];
            byte b42 = bArr34[21];
            Object[] objArr112 = new Object[1];
            a(b41, b42, (byte) (b42 & 47), objArr112);
            objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(i175, c6, tapTimeout, 624296913, false, (String) objArr112[0], null);
        }
        long j10 = ((Field) objAccessartificialFrame33).getLong(null);
        if (j10 == -1 || j10 + 1906 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(-1717965552);
            if (objAccessartificialFrame34 == null) {
                objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(19 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (View.combineMeasuredStates(0, 0) + 39516), 982 - View.MeasureSpec.makeMeasureSpec(0, 0), 117222168, false, null, new Class[0]);
            }
            Object[] objArr113 = {null, ((Constructor) objAccessartificialFrame34).newInstance(null), -1013976526, 0};
            Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(-501205803);
            if (objAccessartificialFrame35 == null) {
                int packedPositionType4 = ExpandableListView.getPackedPositionType(0L) + 36;
                char cIndexOf2 = (char) TextUtils.indexOf("", "");
                int i176 = 540 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                byte[] bArr35 = $$a;
                byte b43 = bArr35[79];
                Object[] objArr114 = new Object[1];
                a(b43, (byte) (b43 | 82), (byte) (bArr35[5] - 1), objArr114);
                objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(packedPositionType4, cIndexOf2, i176, 2101703389, false, (String) objArr114[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(53 - TextUtils.indexOf((CharSequence) "", '0'), (char) (834 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), 575 - TextUtils.lastIndexOf("", '0', 0, 0)), (Class) ArtificialStackFrames.coroutineCreation(54 - ExpandableListView.getPackedPositionGroup(0L), (char) (KeyEvent.getMaxKeyCode() >> 16), KeyEvent.normalizeMetaState(0) + 630), Integer.TYPE, Integer.TYPE});
            }
            objArr7 = (Object[]) ((Method) objAccessartificialFrame35).invoke(null, objArr113);
            Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame36 == null) {
                int iRgb = (-16777180) - Color.rgb(0, 0, 0);
                char trimmedLength = (char) TextUtils.getTrimmedLength("");
                int iLastIndexOf3 = TextUtils.lastIndexOf("", '0', 0) + 541;
                byte[] bArr36 = $$a;
                byte b44 = bArr36[5];
                byte b45 = bArr36[11];
                Object[] objArr115 = new Object[1];
                a(b44, b45, (byte) (b45 | 40), objArr115);
                objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(iRgb, trimmedLength, iLastIndexOf3, 793268735, false, (String) objArr115[0], null);
            }
            ((Field) objAccessartificialFrame36).set(null, objArr7);
            try {
                Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                if (objAccessartificialFrame37 == null) {
                    int i177 = 37 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                    char c7 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1);
                    int minimumFlingVelocity3 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 540;
                    byte[] bArr37 = $$a;
                    byte b46 = bArr37[5];
                    byte b47 = bArr37[21];
                    Object[] objArr116 = new Object[1];
                    a(b46, b47, (byte) (b47 & 47), objArr116);
                    objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(i177, c7, minimumFlingVelocity3, 624296913, false, (String) objArr116[0], null);
                }
                ((Field) objAccessartificialFrame37).set(null, lValueOf8);
            } catch (Exception unused8) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame38 == null) {
                int iIndexOf4 = 36 - TextUtils.indexOf("", "");
                char c8 = (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1);
                int maximumFlingVelocity2 = 540 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                byte[] bArr38 = $$a;
                byte b48 = bArr38[5];
                byte b49 = bArr38[11];
                Object[] objArr117 = new Object[1];
                a(b48, b49, (byte) (b49 | 40), objArr117);
                objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(iIndexOf4, c8, maximumFlingVelocity2, 793268735, false, (String) objArr117[0], null);
            }
            Object[] objArr118 = (Object[]) ((Field) objAccessartificialFrame38).get(null);
            objArr7 = new Object[]{new int[1], new int[1], new int[1]};
            int i178 = ((int[]) objArr118[2])[0];
            int i179 = ((int[]) objArr118[1])[0];
            ((int[]) objArr7[2])[0] = i178;
            ((int[]) objArr7[1])[0] = i179;
            int iIdentityHashCode5 = System.identityHashCode(this);
            int i180 = ~((-1242362013) | iIdentityHashCode5);
            int i181 = ~iIdentityHashCode5;
            int i182 = i180 | (~(109259737 | i181));
            int i183 = ~(1242362012 | i181);
            int i184 = (((1916843393 + ((i182 | i183) * (-516))) + (((~(iIdentityHashCode5 | (-33562777))) | (~((-75696962) | i181))) * 516)) + ((75696961 | i183) * 516)) - 1013976526;
            int i185 = (i184 << 13) ^ i184;
            int i186 = i185 ^ (i185 >>> 17);
            ((int[]) objArr7[0])[0] = i186 ^ (i186 << 5);
        }
        Object obj = objArr7[1];
        int i187 = ((int[]) obj)[0];
        Object obj2 = objArr7[2];
        int i188 = ((int[]) obj2)[0];
        if (i188 == i187) {
            Object[] objArr119 = {new int[1], new int[1], new int[1]};
            int i189 = ((int[]) objArr7[0])[0];
            int i190 = ((int[]) obj2)[0];
            int i191 = ((int[]) obj)[0];
            ((int[]) objArr119[2])[0] = i190;
            ((int[]) objArr119[1])[0] = i191;
            int iIdentityHashCode6 = System.identityHashCode(this);
            int i192 = ~iIdentityHashCode6;
            int i193 = (-1597963319) + (((~(418453065 | i192)) | 655228964) * (-1188));
            int i194 = (~(iIdentityHashCode6 | (-418453066))) | 655228964;
            int i195 = ~(933168684 | i192);
            int i196 = i189 + i193 + ((i194 | i195) * 594) + (((~((-418453066) | i192)) | 140513345 | i195) * 594);
            int i197 = i196 ^ (i196 << 13);
            int i198 = i197 ^ (i197 >>> 17);
            ((int[]) objArr119[0])[0] = i198 ^ (i198 << 5);
            return;
        }
        long j11 = ((long) (i187 ^ i188)) ^ (((long) 1365959174) << 32);
        long j12 = 1365963270;
        int i199 = artificialFrame + 97;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i199 % 128;
        int i200 = i199 % 2;
        Object[] objArr120 = {Long.valueOf(j11), Long.valueOf(j12)};
        byte[] bArr39 = $$d;
        Object[] objArr121 = new Object[1];
        c((short) 636, bArr39[114], bArr39[51], objArr121);
        Class<?> cls17 = Class.forName((String) objArr121[0]);
        Object[] objArr122 = new Object[1];
        c(bArr39[173], (byte) 89, bArr39[28], objArr122);
        cls17.getMethod((String) objArr122[0], Long.TYPE, Long.TYPE).invoke(null, objArr120);
        Object[] objArr123 = {new int[1], new int[1], new int[1]};
        int i201 = ((int[]) objArr7[0])[0];
        int i202 = ((int[]) objArr7[2])[0];
        int i203 = ((int[]) objArr7[1])[0];
        ((int[]) objArr123[2])[0] = i202;
        ((int[]) objArr123[1])[0] = i203;
        int i204 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().widthPixels;
        int i205 = i201 + (-1778086675) + (((~((-382560355) | i204)) | 281026562) * 104) + ((~((~i204) | 1070595187)) * (-104)) + ((i204 | 969061395) * 104);
        int i206 = (i205 << 13) ^ i205;
        int i207 = i206 ^ (i206 >>> 17);
        ((int[]) objArr123[0])[0] = i207 ^ (i207 << 5);
    }

    static {
        byte[] bArr = new byte[TypedValues.TransitionType.TYPE_STAGGERED];
        System.arraycopy("C î\t\u0010\u0002Å=\f\u0004ü\týÍ9\u0013\u000bû\bÿÃJù\t\u0001Ç7\b\u0000\u0007Î\u0017(\u0012Ö \u001b×\u001e\u0018¯\u0011\u0004A\u0000\u0001\u0010\u0004\u0000Çÿ?\t\nõ\u0011\u0000÷\u000fÆM\u0000¿(\u0017\u0000\u000fï\u0012\u0001õ ø\fþ\u0013´7\u001fû\u000fõ\u0011æ\u0011\u0016ü\b\tü\u0001\t\u000eº9\u0010\u0007\u0001\n\u0003ù\tû\u0012¿9\tý\u0011\u0004û\u000b\u000b¿\u0019)ý\u0011\u0004û\u000bê\u0017\u0012\u0006û\f´#-\u0007\bö\u00030\u0007\u0001\n\u0003ù\tûã%\u0001\u0017ö\u0004\u0006\týè-\u0010\u0002Å=\f\u0004ü\týÍ7\u0013ýÉ'(þ\tñó&\u0001\tÿ\u0001\n\u0004\u0002\u0011À?\t\nõ\u0011\u0000÷\u000fÆ#\u001c\fù\u0007\u0011\u0005Ú)\u0000ÿ\u0002\u0015ÿ\u0007\u0005\u0010\u0007\u0001\n\u0003ù\tûâ3÷\u0000\u0017ù\n\u0003\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000Ç7\u0013\u0004\u0000\u0001\t\u0001\f¿\u00173\u0004à!\t\u0001Ý!\u0017ñÇ\u0011\u0000\u0001\u0010\u0004\u0000Çÿ?\t\nõ\u0011\u0000÷\u000fÆF\u0000ù\u0017ö\r\u0007ÿÅ7\u0011ú\u0012\u0001þÿÎ\u001a%\u0005\u0003\u0011\u0004÷\u0003ó ø\fþ\u0013Ñ'\u0001\u0013\bõ\u0011\u0010\u0002Å=\f\u0004ü\týÍP\u0002õ\týË:\u0001\u0017ñ\u0010ø\u0017\u0002û\u0013º;\rù\u0010ù\u0005\u0011À\u0019õ\u0000\u0019-ù\u0010ù\u0005\u0011\u0010\u0002Å=\f\u0004ü\týÍ7\u0011ú\u0012\u0001þÿÎ=\n\n¿?\t\nõ\u0011\u0000÷\u000fÆC\u0003\u0003\u0002\u000fï\u001b÷\u000eú\n\u0003õ\u0007\u0003\u0015õ\u0010ù\u0005þ\u0007\u0017ýú\fý\u0003ÎP\u0004ï\u0010\u0002Å=\f\u0004ü\týÍ7\u0011ú\u0012\u0001þÿÎCø\u0017õ\u0011ûü\u000fÆ9\u0010\u0001\u0007\u0007ÀK\u0003ù\u0007\u0001\u000fù\u0000\u0012¿#\u0018\u0017õ\u0011ûü\u000fÜ9ù÷\u0010\u0000þä0\u0001\u0007\u0007\u0005µ\u0004%7\u0000õ\u0011\u0000÷\u000fë*ù\nø\u0001\u0013ùþí\u0019\u0010ù\u0006\u0001×\u0004\u0006\u0004\u0006\u0012\u0004ò\u0015\u0006ù\u0001\u0007þ\nü\u000fÞ0ó\u0010ü\u0010\u0002Å=\f\u0004ü\týÍ9\u0010\u0002\u0004\u0006\u0003Ä9\u0010\u0001\u0004ý\u0002\u0015¾#\u0018\u0013á\u0018\u000eþ\u0011Û)\nõ\u0011\u0000÷\u000få\u0018\u0013¸!%\u0015\u0005\u0002ó\u0006\u0015ç\u0012\u0000\u000eä\u001e\u0018Ð-\n\u0002\u000bû\u0013¾Jù\büÓ:È9\u0002\u000fý\rú\u0001\u0015À\u00190\u0002\u0004\u0006\u0003Û+ý\fü\r\n\u0003µ7\u0012\u0004\nþ\rý\u0006\tû\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000ÇH÷\u0000\u0006\u0015¾Kø\bø\u0011÷\n\u0002\u0011À/\u001aüþñ%ù\u0005ï#\u0004\u0001¼\u0004%7\u0000õ\u0011\u0000÷\u000fë*ù\nø\u0001\u0013ùþí\u0019\u0010ù\u0006\u0001Ó".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, TypedValues.TransitionType.TYPE_STAGGERED);
        $$d = bArr;
        $$e = 197;
        $$a = new byte[]{4, -24, -50, 10, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13, 9, -18, 34, -25, -4, 17, -19, Ascii.SI, 1, Ascii.DC2, -15, -19, Ascii.VT, -5, 7, 2, -15, 36, -21, -13, Ascii.SI, -2, -9, -6, 34, -15, -19, Ascii.VT, -5, 7, 2, -15, 33, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, -10, Ascii.US, -20, -13, 8, Ascii.VT, Ascii.CR, -27, 9, -18, 36, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, 7, -18, 43, -29, 4, -17, -2, -49, -2, Ascii.VT, 3, -3, 6, -6, 8, -11, Ascii.EM, -33, 19, -2, -8, 37, -44, 17, -12, 8, -14};
        $$b = 188;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        ArtificialStackFrames = new char[]{44336, 44332, 44330, 44405, 44398, 44387, 44328, 44338, 44353, 44389, 44397, 44333, 44360, 44322, 44343, 44370, 44371, 44385, 44388, 44329, 44345, 44406, 44320, 44395, 44390, 44331, 44335, 44392, 44386, 44323, 44344, 44341, 44340, 44339, 44404, 44337, 44355, 44409, 44393, 44402, 44372, 44342, 44403, 44396, 44334, 44391, 44399, 44394, 44400};
        coroutineCreation = (char) 39069;
    }
}
