package com.transistorsoft.locationmanager.scheduler;

import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Build;
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
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.net.SyslogConstants;
import com.google.android.material.carousel.KeylineState;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.analytics.stats.b;
import com.transistorsoft.locationmanager.service.AbstractService;
import com.transistorsoft.locationmanager.util.Util;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kotlin.random.RandomKt;
import net.pluservice.unicoc.R;
import o.ArtificialStackFrames;
import o.onRelationshipValidationResult;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes.dex */
public class ScheduleService extends AbstractService {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$g;
    private static final int $$h;
    private static int artificialFrame;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static long onPostMessage;
    private static final byte[] $$c = {2, -89, -33, -54};
    private static final int $$f = 18;
    private static int $10 = 0;
    private static int $11 = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0028  */
    /* JADX WARN: Code duplicated, block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x002d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0028
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$i(short r7, short r8, byte r9) {
        /*
            int r8 = r8 * 3
            int r8 = r8 + 4
            int r9 = r9 * 2
            int r9 = 111 - r9
            int r7 = r7 * 2
            int r7 = r7 + 1
            byte[] r0 = com.transistorsoft.locationmanager.scheduler.ScheduleService.$$c
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r9
            r4 = r2
            r9 = r8
            goto L2d
        L17:
            r3 = r2
        L18:
            r6 = r9
            r9 = r8
            r8 = r6
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r7) goto L28
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            return r7
        L28:
            r3 = r0[r9]
            r6 = r9
            r9 = r8
            r8 = r6
        L2d:
            int r8 = r8 + 1
            int r3 = -r3
            int r9 = r9 + r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.scheduler.ScheduleService.$$i(short, short, byte):java.lang.String");
    }

    static PendingIntent b(Context context, Intent intent) {
        return Build.VERSION.SDK_INT >= 26 ? PendingIntent.getForegroundService(context, 0, intent, Util.getPendingIntentFlags(134217728)) : PendingIntent.getService(context, 0, intent, 134217728);
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
    private static void q(short r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = 112 - r6
            int r7 = 100 - r7
            byte[] r0 = com.transistorsoft.locationmanager.scheduler.ScheduleService.$$a
            int r8 = r8 + 8
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L10
            r3 = r8
            r4 = r2
            goto L22
        L10:
            r3 = r2
        L11:
            int r4 = r3 + 1
            byte r5 = (byte) r6
            r1[r3] = r5
            if (r4 != r8) goto L20
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L20:
            r3 = r0[r7]
        L22:
            int r3 = -r3
            int r6 = r6 + r3
            int r7 = r7 + 1
            r3 = r4
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.scheduler.ScheduleService.q(short, byte, int, java.lang.Object[]):void");
    }

    private static void t(short s, int i, short s2, Object[] objArr) {
        int i2 = 111 - s2;
        int i3 = s + 4;
        byte[] bArr = $$g;
        byte[] bArr2 = new byte[i + 3];
        int i4 = i + 2;
        int i5 = -1;
        if (bArr == null) {
            i2 = (i3 + i4) - 4;
            i3++;
        }
        while (true) {
            i5++;
            bArr2[i5] = (byte) i2;
            if (i5 == i4) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i6 = i2;
            i2 = (i6 + bArr[i3]) - 4;
            i3++;
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (!a(intent, i2, false)) {
            return 2;
        }
        if (intent.hasExtra("schedule_enabled")) {
            ScheduleEvent.a(getApplicationContext(), intent.getBooleanExtra("schedule_enabled", false), intent.getIntExtra("trackingMode", 1));
        }
        a(i2);
        return 3;
    }

    private static void s(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        onRelationshipValidationResult onrelationshipvalidationresult = new onRelationshipValidationResult();
        char[] cArrAccessartificialFrame = onRelationshipValidationResult.accessartificialFrame(onPostMessage ^ 2573525503365829440L, cArr, i);
        onrelationshipvalidationresult.e = 4;
        int i3 = $10 + 25;
        $11 = i3 % 128;
        if (i3 % 2 == 0) {
            int i4 = 5 % 2;
        }
        while (onrelationshipvalidationresult.e < cArrAccessartificialFrame.length) {
            int i5 = $11 + 11;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            onrelationshipvalidationresult.d = onrelationshipvalidationresult.e - 4;
            int i7 = onrelationshipvalidationresult.e;
            try {
                Object[] objArr2 = {Long.valueOf(cArrAccessartificialFrame[onrelationshipvalidationresult.e] ^ cArrAccessartificialFrame[onrelationshipvalidationresult.e % 4]), Long.valueOf(onrelationshipvalidationresult.d), Long.valueOf(onPostMessage)};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(797310229);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(View.resolveSizeAndState(0, 0, 0) + 27, (char) (30690 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 188, -1327449315, false, "k", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                }
                cArrAccessartificialFrame[i7] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                Object[] objArr3 = {onrelationshipvalidationresult, onrelationshipvalidationresult};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(321542193);
                if (objAccessartificialFrame2 == null) {
                    byte b = (byte) 0;
                    byte b2 = b;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 33, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16), 1483 - TextUtils.getTrimmedLength(""), -1940971975, false, $$i(b, b2, b2), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame2).invoke(null, objArr3);
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

    /* JADX WARN: Code duplicated, block: B:13:0x0158  */
    /* JADX WARN: Code duplicated, block: B:16:0x01ed A[Catch: all -> 0x09f5, TryCatch #2 {all -> 0x09f5, blocks: (B:54:0x06d7, B:56:0x06eb, B:57:0x0717, B:14:0x01cd, B:16:0x01ed, B:17:0x023d), top: B:98:0x01cd }] */
    /* JADX WARN: Code duplicated, block: B:20:0x024f  */
    /* JADX WARN: Code duplicated, block: B:25:0x031c  */
    /* JADX WARN: Code duplicated, block: B:53:0x0691  */
    /* JADX WARN: Code duplicated, block: B:56:0x06eb A[Catch: all -> 0x09f5, TryCatch #2 {all -> 0x09f5, blocks: (B:54:0x06d7, B:56:0x06eb, B:57:0x0717, B:14:0x01cd, B:16:0x01ed, B:17:0x023d), top: B:98:0x01cd }] */
    /* JADX WARN: Code duplicated, block: B:60:0x072d  */
    /* JADX WARN: Code duplicated, block: B:65:0x07d6  */
    @Override // com.transistorsoft.locationmanager.service.AbstractService, android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) throws Throwable {
        Object objAccessartificialFrame;
        Object[] objArr;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        int i = 2 % 2;
        super.attachBaseContext(context);
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame7 == null) {
            int iAlpha = 25 - Color.alpha(0);
            char c = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 30067);
            int iBlue = 816 - Color.blue(0);
            byte b = $$a[5];
            byte b2 = (byte) (b - 1);
            Object[] objArr2 = new Object[1];
            q(b2, (byte) (b2 | 96), b, objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iAlpha, c, iBlue, 721586079, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 2005;
            Object[] objArr3 = new Object[1];
            s(-TextUtils.lastIndexOf("", '0', 0, 0), new char[]{230, 19144, 33440, 29577, 135, 57465, 55162, 29542, 44021, 7418, 33790, 57278, 22129, 19308, 11832, 9295, 747, 59368, 56038, 28925, 44411, 4676, 33122, 56683, 23017, 20200}, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            s(-TextUtils.indexOf((CharSequence) "", '0', 0), new char[]{36776, 17829, 24512, 9434, 36813, 61206, 2591, 9271, 9383, 5019, 24222, 34961, 55605, 17427, 62234, 29499, 36277, 59547, 1943}, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame8 == null) {
                    int i2 = 25 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                    char cNormalizeMetaState = (char) (30068 - KeyEvent.normalizeMetaState(0));
                    int absoluteGravity = Gravity.getAbsoluteGravity(0, 0) + 816;
                    byte b3 = $$a[5];
                    byte b4 = (byte) (b3 - 1);
                    Object[] objArr5 = new Object[1];
                    q(b4, (byte) (b4 | 88), b3, objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i2, cNormalizeMetaState, absoluteGravity, 891606461, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i3 = ((int[]) objArr6[0])[0];
                int i4 = ((int[]) objArr6[1])[0];
                String[] strArr = (String[]) objArr6[2];
                int elapsedCpuTime = (int) Process.getElapsedCpuTime();
                int i5 = 1534048739 + (((~((-156028864) | elapsedCpuTime)) | (-198168512)) * (-502)) + ((~((~elapsedCpuTime) | (-156025010))) * (-502)) + (((~(elapsedCpuTime | (-42143503))) | (-156028864)) * TypedValues.PositionType.TYPE_DRAWPATH) + 48819414;
                int i6 = (i5 << 13) ^ i5;
                int i7 = i6 ^ (i6 >>> 17);
                ((int[]) objArr[3])[0] = i7 ^ (i7 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 20, new char[]{49793, 42076, 15428, 9264, 49899, 3810, 27020, 9420, 27091, 62059, 15647, 34887, 37918, 42405, 37025, 29660, 49286, 2427, 25619, 10060}, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 34, new char[]{3531, 46524, 55838, 45917, 3490, 7943, 36805, 45998, 42691, 58254, 56144, 7997, 23419, 46090, 30427, 58528, 4092, 6272, 33352, 45097}, objArr8);
                try {
                    Object[] objArr9 = {Integer.valueOf(((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue()), 0, 48819414};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame == null) {
                        int maximumDrawingCacheSize = 25 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                        char c2 = (char) (30069 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                        int tapTimeout = 816 - (ViewConfiguration.getTapTimeout() >> 16);
                        Object[] objArr10 = new Object[1];
                        q((byte) 28, (byte) 80, $$a[47], objArr10);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize, c2, tapTimeout, -797394565, false, (String) objArr10[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr9);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame2 == null) {
                        int edgeSlop = (ViewConfiguration.getEdgeSlop() >> 16) + 25;
                        char size = (char) (View.MeasureSpec.getSize(0) + 30068);
                        int deadChar = KeyEvent.getDeadChar(0, 0) + 816;
                        byte b5 = $$a[5];
                        byte b6 = (byte) (b5 - 1);
                        Object[] objArr11 = new Object[1];
                        q(b6, (byte) (b6 | 88), b5, objArr11);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(edgeSlop, size, deadChar, 891606461, false, (String) objArr11[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArr);
                    try {
                        Object[] objArr12 = new Object[1];
                        s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 34, new char[]{230, 19144, 33440, 29577, 135, 57465, 55162, 29542, 44021, 7418, 33790, 57278, 22129, 19308, 11832, 9295, 747, 59368, 56038, 28925, 44411, 4676, 33122, 56683, 23017, 20200}, objArr12);
                        Class<?> cls3 = Class.forName((String) objArr12[0]);
                        Object[] objArr13 = new Object[1];
                        s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 3, new char[]{36776, 17829, 24512, 9434, 36813, 61206, 2591, 9271, 9383, 5019, 24222, 34961, 55605, 17427, 62234, 29499, 36277, 59547, 1943}, objArr13);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr13[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame3 == null) {
                            int maximumDrawingCacheSize2 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 25;
                            char c3 = (char) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 30068);
                            int capsMode = 816 - TextUtils.getCapsMode("", 0, 0);
                            byte b7 = $$a[5];
                            byte b8 = (byte) (b7 - 1);
                            Object[] objArr14 = new Object[1];
                            q(b8, (byte) (b8 | 96), b7, objArr14);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize2, c3, capsMode, 721586079, false, (String) objArr14[0], null);
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
            Object[] objArr15 = new Object[1];
            s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 20, new char[]{49793, 42076, 15428, 9264, 49899, 3810, 27020, 9420, 27091, 62059, 15647, 34887, 37918, 42405, 37025, 29660, 49286, 2427, 25619, 10060}, objArr15);
            Class<?> cls4 = Class.forName((String) objArr15[0]);
            Object[] objArr16 = new Object[1];
            s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 34, new char[]{3531, 46524, 55838, 45917, 3490, 7943, 36805, 45998, 42691, 58254, 56144, 7997, 23419, 46090, 30427, 58528, 4092, 6272, 33352, 45097}, objArr16);
            Object[] objArr17 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue()), 0, 48819414};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame == null) {
                int maximumDrawingCacheSize3 = 25 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                char c4 = (char) (30069 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                int tapTimeout2 = 816 - (ViewConfiguration.getTapTimeout() >> 16);
                Object[] objArr18 = new Object[1];
                q((byte) 28, (byte) 80, $$a[47], objArr18);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize3, c4, tapTimeout2, -797394565, false, (String) objArr18[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr17);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame2 == null) {
                int edgeSlop2 = (ViewConfiguration.getEdgeSlop() >> 16) + 25;
                char size2 = (char) (View.MeasureSpec.getSize(0) + 30068);
                int deadChar2 = KeyEvent.getDeadChar(0, 0) + 816;
                byte b9 = $$a[5];
                byte b10 = (byte) (b9 - 1);
                Object[] objArr19 = new Object[1];
                q(b10, (byte) (b10 | 88), b9, objArr19);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(edgeSlop2, size2, deadChar2, 891606461, false, (String) objArr19[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArr);
            Object[] objArr110 = new Object[1];
            s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 34, new char[]{230, 19144, 33440, 29577, 135, 57465, 55162, 29542, 44021, 7418, 33790, 57278, 22129, 19308, 11832, 9295, 747, 59368, 56038, 28925, 44411, 4676, 33122, 56683, 23017, 20200}, objArr110);
            Class<?> cls5 = Class.forName((String) objArr110[0]);
            Object[] objArr111 = new Object[1];
            s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 3, new char[]{36776, 17829, 24512, 9434, 36813, 61206, 2591, 9271, 9383, 5019, 24222, 34961, 55605, 17427, 62234, 29499, 36277, 59547, 1943}, objArr111);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr111[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame3 == null) {
                int maximumDrawingCacheSize4 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 25;
                char c5 = (char) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 30068);
                int capsMode2 = 816 - TextUtils.getCapsMode("", 0, 0);
                byte b11 = $$a[5];
                byte b12 = (byte) (b11 - 1);
                Object[] objArr112 = new Object[1];
                q(b12, (byte) (b12 | 96), b11, objArr112);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize4, c5, capsMode2, 721586079, false, (String) objArr112[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i8 = ((int[]) objArr[1])[0];
        int i9 = ((int[]) objArr[0])[0];
        if (i9 == i8) {
            int i10 = getARTIFICIAL_FRAME_PACKAGE_NAME + 71;
            artificialFrame = i10 % 128;
            int i11 = i10 % 2;
            Object[] objArr20 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i12 = ((int[]) objArr[3])[0];
            int i13 = ((int[]) objArr[0])[0];
            int i14 = ((int[]) objArr[1])[0];
            String[] strArr2 = (String[]) objArr[2];
            int iIdentityHashCode = System.identityHashCode(this);
            int i15 = i12 + 813473156 + ((~((~iIdentityHashCode) | (-888866))) * 433) + (((~(138261541 | iIdentityHashCode)) | (-336433908)) * (-433)) + (((~(iIdentityHashCode | (-336433908))) | 137372676) * 433);
            int i16 = (i15 << 13) ^ i15;
            int i17 = i16 ^ (i16 >>> 17);
            ((int[]) objArr20[3])[0] = i17 ^ (i17 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr[2];
            if (strArr3 != null) {
                int i18 = 0;
                while (i18 < strArr3.length) {
                    int i19 = artificialFrame + 77;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i19 % 128;
                    if (i19 % 2 != 0) {
                        arrayList.add(strArr3[i18]);
                        i18 += 101;
                    } else {
                        arrayList.add(strArr3[i18]);
                        i18++;
                    }
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf((((long) 1764763137) << 32) ^ ((long) (i8 ^ i9))), Long.valueOf(1764763136)};
                byte[] bArr = $$g;
                Object[] objArr22 = new Object[1];
                t(bArr[14], bArr[640], bArr[82], objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                t((short) (-bArr[219]), bArr[14], bArr[210], objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i20 = ((int[]) objArr[3])[0];
                int i21 = ((int[]) objArr[0])[0];
                int i22 = ((int[]) objArr[1])[0];
                String[] strArr4 = (String[]) objArr[2];
                int iNextInt = new Random().nextInt(81246920);
                int i23 = ~iNextInt;
                int i24 = (-911072207) + (((~(148626553 | i23)) | 35914244) * (-1188));
                int i25 = (~(iNextInt | (-148626554))) | 35914244;
                int i26 = ~(49545812 | i23);
                int i27 = i20 + i24 + ((i25 | i26) * 594) + (((~((-148626554) | i23)) | 134994985 | i26) * 594);
                int i28 = (i27 << 13) ^ i27;
                int i29 = i28 ^ (i28 >>> 17);
                ((int[]) objArr24[3])[0] = i29 ^ (i29 << 5);
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
            int iIndexOf = 25 - TextUtils.indexOf((CharSequence) "", '0');
            char c6 = (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
            int mirror = AndroidCharacter.getMirror('0') + 993;
            byte b13 = $$a[5];
            byte b14 = (byte) (b13 - 1);
            Object[] objArr25 = new Object[1];
            q(b14, (byte) (b14 | 96), b13, objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(iIndexOf, c6, mirror, 2061780482, false, (String) objArr25[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j3 != -1) {
            int i30 = getARTIFICIAL_FRAME_PACKAGE_NAME + 119;
            artificialFrame = i30 % 128;
            int i31 = i30 % 2;
            long j4 = j3 + 4611686018427387851L;
            Object[] objArr26 = new Object[1];
            s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 3, new char[]{230, 19144, 33440, 29577, 135, 57465, 55162, 29542, 44021, 7418, 33790, 57278, 22129, 19308, 11832, 9295, 747, 59368, 56038, 28925, 44411, 4676, 33122, 56683, 23017, 20200}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 34, new char[]{36776, 17829, 24512, 9434, 36813, 61206, 2591, 9271, 9383, 5019, 24222, 34961, 55605, 17427, 62234, 29499, 36277, 59547, 1943}, objArr27);
            if (j4 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame10 == null) {
                    int scrollBarSize = (ViewConfiguration.getScrollBarSize() >> 8) + 26;
                    char edgeSlop3 = (char) (ViewConfiguration.getEdgeSlop() >> 16);
                    int i32 = 1042 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                    byte b15 = $$a[5];
                    byte b16 = (byte) (b15 - 1);
                    Object[] objArr28 = new Object[1];
                    q(b16, (byte) (b16 | 88), b15, objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(scrollBarSize, edgeSlop3, i32, 1145017376, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i33 = ((int[]) objArr29[3])[0];
                int i34 = ((int[]) objArr29[2])[0];
                String[] strArr5 = (String[]) objArr29[0];
                int i35 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().keyboard;
                int i36 = ~i35;
                int i37 = (((1352744734 + ((((~(112121900 | i36)) | (-190225708)) | (~((-112121901) | i35))) * (-564))) + ((~(i35 | (-33986601))) * 1128)) + (((~((-190225708) | i36)) | 78135300) * 564)) - 1934247541;
                int i38 = (i37 << 13) ^ i37;
                int i39 = i38 ^ (i38 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i39 ^ (i39 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                s((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 1, new char[]{49793, 42076, 15428, 9264, 49899, 3810, 27020, 9420, 27091, 62059, 15647, 34887, 37918, 42405, 37025, 29660, 49286, 2427, 25619, 10060}, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                s(-ImageFormat.getBitsPerPixel(0), new char[]{3531, 46524, 55838, 45917, 3490, 7943, 36805, 45998, 42691, 58254, 56144, 7997, 23419, 46090, 30427, 58528, 4092, 6272, 33352, 45097}, objArr31);
                int iIntValue = ((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue();
                Object[] objArr32 = {-1032668413};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(7 - ExpandableListView.getPackedPositionChild(0L), (char) (22250 - MotionEvent.axisFromString("")), 1032 - Process.getGidForName(""), 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = KeylineState.Keyline.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr32), -1934247541, false);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame5 == null) {
                    int iIndexOf2 = 26 - TextUtils.indexOf("", "");
                    char minimumFlingVelocity = (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                    int iCombineMeasuredStates = View.combineMeasuredStates(0, 0) + 1041;
                    byte b17 = $$a[5];
                    byte b18 = (byte) (b17 - 1);
                    Object[] objArr33 = new Object[1];
                    q(b18, (byte) (b18 | 88), b17, objArr33);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iIndexOf2, minimumFlingVelocity, iCombineMeasuredStates, 1145017376, false, (String) objArr33[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Object[] objArr34 = new Object[1];
                    s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 34, new char[]{230, 19144, 33440, 29577, 135, 57465, 55162, 29542, 44021, 7418, 33790, 57278, 22129, 19308, 11832, 9295, 747, 59368, 56038, 28925, 44411, 4676, 33122, 56683, 23017, 20200}, objArr34);
                    Class<?> cls9 = Class.forName((String) objArr34[0]);
                    Object[] objArr35 = new Object[1];
                    s(-TextUtils.indexOf((CharSequence) "", '0', 0, 0), new char[]{36776, 17829, 24512, 9434, 36813, 61206, 2591, 9271, 9383, 5019, 24222, 34961, 55605, 17427, 62234, 29499, 36277, 59547, 1943}, objArr35);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr35[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame6 == null) {
                        int packedPositionChild = ExpandableListView.getPackedPositionChild(0L) + 27;
                        char modifierMetaStateMask = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1);
                        int offsetBefore = TextUtils.getOffsetBefore("", 0) + 1041;
                        byte b19 = $$a[5];
                        byte b20 = (byte) (b19 - 1);
                        Object[] objArr36 = new Object[1];
                        q(b20, (byte) (b20 | 96), b19, objArr36);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(packedPositionChild, modifierMetaStateMask, offsetBefore, 2061780482, false, (String) objArr36[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr37 = new Object[1];
            s((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 1, new char[]{49793, 42076, 15428, 9264, 49899, 3810, 27020, 9420, 27091, 62059, 15647, 34887, 37918, 42405, 37025, 29660, 49286, 2427, 25619, 10060}, objArr37);
            Class<?> cls10 = Class.forName((String) objArr37[0]);
            Object[] objArr38 = new Object[1];
            s(-ImageFormat.getBitsPerPixel(0), new char[]{3531, 46524, 55838, 45917, 3490, 7943, 36805, 45998, 42691, 58254, 56144, 7997, 23419, 46090, 30427, 58528, 4092, 6272, 33352, 45097}, objArr38);
            int iIntValue2 = ((Integer) cls10.getMethod((String) objArr38[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr39 = {-1032668413};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(7 - ExpandableListView.getPackedPositionChild(0L), (char) (22250 - MotionEvent.axisFromString("")), 1032 - Process.getGidForName(""), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = KeylineState.Keyline.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr39), -1934247541, false);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame5 == null) {
                int iIndexOf3 = 26 - TextUtils.indexOf("", "");
                char minimumFlingVelocity2 = (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                int iCombineMeasuredStates2 = View.combineMeasuredStates(0, 0) + 1041;
                byte b110 = $$a[5];
                byte b111 = (byte) (b110 - 1);
                Object[] objArr310 = new Object[1];
                q(b111, (byte) (b111 | 88), b110, objArr310);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iIndexOf3, minimumFlingVelocity2, iCombineMeasuredStates2, 1145017376, false, (String) objArr310[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr311 = new Object[1];
            s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 34, new char[]{230, 19144, 33440, 29577, 135, 57465, 55162, 29542, 44021, 7418, 33790, 57278, 22129, 19308, 11832, 9295, 747, 59368, 56038, 28925, 44411, 4676, 33122, 56683, 23017, 20200}, objArr311);
            Class<?> cls11 = Class.forName((String) objArr311[0]);
            Object[] objArr312 = new Object[1];
            s(-TextUtils.indexOf((CharSequence) "", '0', 0, 0), new char[]{36776, 17829, 24512, 9434, 36813, 61206, 2591, 9271, 9383, 5019, 24222, 34961, 55605, 17427, 62234, 29499, 36277, 59547, 1943}, objArr312);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr312[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame6 == null) {
                int packedPositionChild2 = ExpandableListView.getPackedPositionChild(0L) + 27;
                char modifierMetaStateMask2 = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1);
                int offsetBefore2 = TextUtils.getOffsetBefore("", 0) + 1041;
                byte b112 = $$a[5];
                byte b21 = (byte) (b112 - 1);
                Object[] objArr313 = new Object[1];
                q(b21, (byte) (b21 | 96), b112, objArr313);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(packedPositionChild2, modifierMetaStateMask2, offsetBefore2, 2061780482, false, (String) objArr313[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i40 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i41 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i41 == i40) {
            Object[] objArr40 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i42 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i43 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i44 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr6 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int streamVolume = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getStreamVolume(3);
            int i45 = ~streamVolume;
            int i46 = (-1951111082) + (((~((-657449030) | i45)) | 86499329 | (~(579345222 | i45)) | (~((-8395523) | streamVolume))) * (-84));
            int i47 = (~(streamVolume | 579345222)) | 657449029;
            int i48 = ~(i45 | (-579345223));
            int i49 = i42 + i46 + ((i47 | i48) * (-84)) + ((8395522 | i48) * 84);
            int i50 = (i49 << 13) ^ i49;
            int i51 = i50 ^ (i50 >>> 17);
            ((int[]) objArr40[1])[0] = i51 ^ (i51 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        if (strArr7 != null) {
            int i52 = getARTIFICIAL_FRAME_PACKAGE_NAME + 3;
            artificialFrame = i52 % 128;
            int i53 = i52 % 2;
            for (String str : strArr7) {
                arrayList2.add(str);
            }
        }
        long j5 = (((long) 1391609190) << 32) ^ ((long) (i40 ^ i41));
        long j6 = 1391609188;
        int i54 = getARTIFICIAL_FRAME_PACKAGE_NAME + 15;
        int i55 = i54 % 128;
        artificialFrame = i55;
        int i56 = i54 % 2;
        int i57 = i55 + b.f40o;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i57 % 128;
        int i58 = i57 % 2;
        Object[] objArr41 = {Long.valueOf(j5), Long.valueOf(j6)};
        byte[] bArr2 = $$g;
        Object[] objArr42 = new Object[1];
        t(bArr2[76], bArr2[162], bArr2[82], objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        Object[] objArr43 = new Object[1];
        t((short) (-bArr2[219]), bArr2[14], bArr2[210], objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {strArr, new int[1], new int[]{i}, new int[]{i}};
        int i59 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
        int i60 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        int i61 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        String[] strArr8 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        int i62 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().densityDpi;
        int i63 = ~i62;
        int i64 = i59 + 1491392654 + (((~((-960523427) | i63)) | 155207680 | (~(882419619 | i63))) * (-1136)) + (((~((-960523427) | i62)) | (~(882419619 | i62)) | (~((-77103874) | i63))) * (-568)) + (((~(i62 | (-155207681))) | (~(i63 | (-882419620))) | (~(960523426 | i63))) * 568);
        int i65 = (i64 << 13) ^ i64;
        int i66 = i65 ^ (i65 >>> 17);
        ((int[]) objArr44[1])[0] = i66 ^ (i66 << 5);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:16:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:18:0x0261  */
    /* JADX WARN: Code duplicated, block: B:236:0x1883  */
    /* JADX WARN: Code duplicated, block: B:240:0x1915  */
    /* JADX WARN: Code duplicated, block: B:245:0x1988  */
    /* JADX WARN: Code duplicated, block: B:24:0x0271  */
    /* JADX WARN: Code duplicated, block: B:28:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:30:0x0303  */
    /* JADX WARN: Code duplicated, block: B:35:0x0375  */
    /* JADX WARN: Code duplicated, block: B:36:0x03be  */
    /* JADX WARN: Code duplicated, block: B:40:0x03cd  */
    @Override // com.transistorsoft.locationmanager.service.AbstractService, android.app.Service
    public void onCreate() throws Throwable {
        Context baseContext;
        Object[] objArr;
        Object[] objArr2;
        Object objAccessartificialFrame;
        Object objAccessartificialFrame2;
        Object[] objArr3;
        Object[] objArr4;
        int i;
        int i2;
        Object[] objArrAccessartificialFrame$78cbbd35;
        int i3;
        Object[] objArr5;
        Object[] objArr6;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        int i4;
        Object[] objArr7;
        int i5;
        Object obj;
        Object[] objArr8;
        char c;
        int i6 = 2 % 2;
        Object[] objArr9 = new Object[1];
        s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 34, new char[]{230, 19144, 33440, 29577, 135, 57465, 55162, 29542, 44021, 7418, 33790, 57278, 22129, 19308, 11832, 9295, 747, 59368, 56038, 28925, 44411, 4676, 33122, 56683, 23017, 20200}, objArr9);
        String str = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        s(Gravity.getAbsoluteGravity(0, 0) + 1, new char[]{36776, 17829, 24512, 9434, 36813, 61206, 2591, 9271, 9383, 5019, 24222, 34961, 55605, 17427, 62234, 29499, 36277, 59547, 1943}, objArr10);
        String str2 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 48, new char[]{49793, 42076, 15428, 9264, 49899, 3810, 27020, 9420, 27091, 62059, 15647, 34887, 37918, 42405, 37025, 29660, 49286, 2427, 25619, 10060}, objArr11);
        String str3 = (String) objArr11[0];
        Object[] objArr12 = new Object[1];
        s((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), new char[]{3531, 46524, 55838, 45917, 3490, 7943, 36805, 45998, 42691, 58254, 56144, 7997, 23419, 46090, 30427, 58528, 4092, 6272, 33352, 45097}, objArr12);
        String str4 = (String) objArr12[0];
        Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame5 == null) {
            int i7 = 31 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
            char fadingEdgeLength = (char) (49362 - (ViewConfiguration.getFadingEdgeLength() >> 16));
            int iIndexOf = TextUtils.indexOf("", "", 0) + 684;
            byte[] bArr = $$a;
            Object[] objArr13 = new Object[1];
            q(bArr[8], (byte) 69, (byte) (-bArr[4]), objArr13);
            objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i7, fadingEdgeLength, iIndexOf, 508509282, false, (String) objArr13[0], null);
        }
        long j = ((Field) objAccessartificialFrame5).getLong(null);
        if (j != -1) {
            int i8 = getARTIFICIAL_FRAME_PACKAGE_NAME + 83;
            artificialFrame = i8 % 128;
            int i9 = i8 % 2;
            if (j + 1948 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i10 = artificialFrame + 33;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i10 % 128;
                int i11 = i10 % 2;
                Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame6 == null) {
                    int i12 = 31 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                    char cIndexOf = (char) (49361 - TextUtils.indexOf((CharSequence) "", '0', 0));
                    int i13 = 685 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                    byte[] bArr2 = $$a;
                    byte b = bArr2[28];
                    Object[] objArr14 = new Object[1];
                    q(b, (byte) (b | 49), (byte) (bArr2[5] - 1), objArr14);
                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i12, cIndexOf, i13, -1321816393, false, (String) objArr14[0], null);
                }
                Object[] objArr15 = (Object[]) ((Field) objAccessartificialFrame6).get(null);
                objArr2 = new Object[]{new int[]{((int[]) objArr15[0])[0]}, new int[]{((int[]) objArr15[1])[0]}, new int[1], (String) objArr15[3]};
                int elapsedCpuTime = (int) Process.getElapsedCpuTime();
                int i14 = ~elapsedCpuTime;
                int i15 = 1685767660 + (((~(852085715 | i14)) | 84021256) * (-108)) + (((~(i14 | 126538059)) | (~((-126538060) | elapsedCpuTime)) | 809568912) * 54) + ((elapsedCpuTime | 809568912) * 54) + 400229928;
                int i16 = (i15 << 13) ^ i15;
                int i17 = i16 ^ (i16 >>> 17);
                ((int[]) objArr2[2])[0] = i17 ^ (i17 << 5);
            } else {
                baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr16 = new Object[1];
                    s(Color.rgb(0, 0, 0) + 16777217, new char[]{16903, 27626, 48158, 56933, 16998, 49499, 59844, 56970, 59668, 15832, 48448, 29266, 5278, 27213, 4312, 35294, 16434, 50906, 58456, 56605, 61313, 13132, 49092, 28817, 6975, 28617, 4934, 33801, 18062, 50249}, objArr16);
                    Class<?> cls = Class.forName((String) objArr16[0]);
                    Object[] objArr17 = new Object[1];
                    s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 3, new char[]{52626, 42466, 44196, 12614, 52721, 3912, 63848, 12713, 26251, 62423, 44522, 40222, 39706, 42053, '~', 26298, 53125, 2256, 62690, 12862, 24589, 64835}, objArr17);
                    baseContext = (Context) cls.getMethod((String) objArr17[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    if ((baseContext instanceof ContextWrapper) || ((ContextWrapper) baseContext).getBaseContext() != null) {
                        baseContext = baseContext.getApplicationContext();
                    } else {
                        baseContext = null;
                    }
                }
                try {
                    Object[] objArr18 = {baseContext, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 400229928};
                    short s = (short) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR;
                    byte[] bArr3 = $$g;
                    Object[] objArr19 = new Object[1];
                    t(s, bArr3[94], bArr3[82], objArr19);
                    Class<?> cls2 = Class.forName((String) objArr19[0]);
                    Object[] objArr20 = new Object[1];
                    t((short) 168, bArr3[175], bArr3[368], objArr20);
                    objArr = (Object[]) cls2.getMethod((String) objArr20[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr18);
                    if (baseContext != null) {
                        objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(777251007);
                        if (objAccessartificialFrame == null) {
                            int i18 = 30 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                            char c2 = (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 49361);
                            int deadChar = KeyEvent.getDeadChar(0, 0) + 684;
                            byte[] bArr4 = $$a;
                            byte b2 = bArr4[28];
                            Object[] objArr21 = new Object[1];
                            q(b2, (byte) (b2 | 49), (byte) (bArr4[5] - 1), objArr21);
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i18, c2, deadChar, -1321816393, false, (String) objArr21[0], null);
                        }
                        ((Field) objAccessartificialFrame).set(null, objArr);
                        try {
                            Long lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                            if (objAccessartificialFrame2 == null) {
                                int iRed = Color.red(0) + 30;
                                char edgeSlop = (char) ((ViewConfiguration.getEdgeSlop() >> 16) + 49362);
                                int packedPositionChild = 683 - ExpandableListView.getPackedPositionChild(0L);
                                byte[] bArr5 = $$a;
                                Object[] objArr22 = new Object[1];
                                q(bArr5[8], (byte) 69, (byte) (-bArr5[4]), objArr22);
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iRed, edgeSlop, packedPositionChild, 508509282, false, (String) objArr22[0], null);
                            }
                            ((Field) objAccessartificialFrame2).set(null, lValueOf);
                        } catch (Exception unused) {
                            throw new RuntimeException();
                        }
                    } else {
                        objArr = objArr;
                    }
                    objArr2 = objArr;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
        } else {
            baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr110 = new Object[1];
                s(Color.rgb(0, 0, 0) + 16777217, new char[]{16903, 27626, 48158, 56933, 16998, 49499, 59844, 56970, 59668, 15832, 48448, 29266, 5278, 27213, 4312, 35294, 16434, 50906, 58456, 56605, 61313, 13132, 49092, 28817, 6975, 28617, 4934, 33801, 18062, 50249}, objArr110);
                Class<?> cls3 = Class.forName((String) objArr110[0]);
                Object[] objArr111 = new Object[1];
                s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 3, new char[]{52626, 42466, 44196, 12614, 52721, 3912, 63848, 12713, 26251, 62423, 44522, 40222, 39706, 42053, '~', 26298, 53125, 2256, 62690, 12862, 24589, 64835}, objArr111);
                baseContext = (Context) cls3.getMethod((String) objArr111[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                if (baseContext instanceof ContextWrapper) {
                    baseContext = baseContext.getApplicationContext();
                } else {
                    baseContext = baseContext.getApplicationContext();
                }
            }
            Object[] objArr112 = {baseContext, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 400229928};
            short s2 = (short) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR;
            byte[] bArr6 = $$g;
            Object[] objArr113 = new Object[1];
            t(s2, bArr6[94], bArr6[82], objArr113);
            Class<?> cls4 = Class.forName((String) objArr113[0]);
            Object[] objArr23 = new Object[1];
            t((short) 168, bArr6[175], bArr6[368], objArr23);
            objArr = (Object[]) cls4.getMethod((String) objArr23[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr112);
            if (baseContext != null) {
                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame == null) {
                    int i19 = 30 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                    char c3 = (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 49361);
                    int deadChar2 = KeyEvent.getDeadChar(0, 0) + 684;
                    byte[] bArr7 = $$a;
                    byte b3 = bArr7[28];
                    Object[] objArr24 = new Object[1];
                    q(b3, (byte) (b3 | 49), (byte) (bArr7[5] - 1), objArr24);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i19, c3, deadChar2, -1321816393, false, (String) objArr24[0], null);
                }
                ((Field) objAccessartificialFrame).set(null, objArr);
                Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                if (objAccessartificialFrame2 == null) {
                    int iRed2 = Color.red(0) + 30;
                    char edgeSlop2 = (char) ((ViewConfiguration.getEdgeSlop() >> 16) + 49362);
                    int packedPositionChild2 = 683 - ExpandableListView.getPackedPositionChild(0L);
                    byte[] bArr8 = $$a;
                    Object[] objArr25 = new Object[1];
                    q(bArr8[8], (byte) 69, (byte) (-bArr8[4]), objArr25);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iRed2, edgeSlop2, packedPositionChild2, 508509282, false, (String) objArr25[0], null);
                }
                ((Field) objAccessartificialFrame2).set(null, lValueOf2);
            } else {
                objArr = objArr;
            }
            objArr2 = objArr;
        }
        int i20 = ((int[]) objArr2[1])[0];
        int i21 = ((int[]) objArr2[0])[0];
        if (i21 == i20) {
            int i22 = artificialFrame + 121;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i22 % 128;
            int i23 = i22 % 2;
            int i24 = ((int[]) objArr2[2])[0];
            Object[] objArr26 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int iUptimeMillis = (int) SystemClock.uptimeMillis();
            int i25 = ~iUptimeMillis;
            int i26 = i24 + (-1770111306) + (((~(366748052 | i25)) | 611875722) * (-328)) + ((iUptimeMillis | 611875722) * 164) + (((~(iUptimeMillis | (-366748053))) | 72884608 | (~(i25 | 905739166))) * 164);
            int i27 = (i26 << 13) ^ i26;
            int i28 = i27 ^ (i27 >>> 17);
            ((int[]) objArr26[2])[0] = i28 ^ (i28 << 5);
        } else {
            try {
                Object[] objArr27 = {Long.valueOf((((long) (-260580291)) << 32) ^ ((long) (i20 ^ i21))), Long.valueOf(-260579779)};
                short s3 = (short) ($$h + 5);
                byte[] bArr9 = $$g;
                Object[] objArr28 = new Object[1];
                t(s3, (byte) (-bArr9[219]), bArr9[82], objArr28);
                Class<?> cls5 = Class.forName((String) objArr28[0]);
                Object[] objArr29 = new Object[1];
                t((short) (-bArr9[219]), bArr9[14], bArr9[210], objArr29);
                cls5.getMethod((String) objArr29[0], Long.TYPE, Long.TYPE).invoke(null, objArr27);
                int i29 = ((int[]) objArr2[2])[0];
                Object[] objArr30 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
                int layoutDirection = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().getLayoutDirection();
                int i30 = i29 + (-1841967829) + (((~(layoutDirection | 108111205)) | (-870512570)) * (-465)) + ((108111205 | (~((-870512570) | layoutDirection))) * 930) + ((layoutDirection | (-830624409)) * 465);
                int i31 = (i30 << 13) ^ i30;
                int i32 = i31 ^ (i31 >>> 17);
                ((int[]) objArr30[2])[0] = i32 ^ (i32 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame7 == null) {
            int iIndexOf2 = TextUtils.indexOf((CharSequence) r14, (CharSequence) r14, 0, 0) + 25;
            char gidForName = (char) (30067 - Process.getGidForName(""));
            int size = 816 - View.MeasureSpec.getSize(0);
            byte b4 = $$a[5];
            byte b5 = (byte) (b4 - 1);
            Object[] objArr31 = new Object[1];
            q(b5, (byte) (b5 | 96), b4, objArr31);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iIndexOf2, gidForName, size, 721586079, false, (String) objArr31[0], null);
        }
        long j2 = ((Field) objAccessartificialFrame7).getLong(null);
        if (j2 == -1 || j2 + 1951 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            try {
                Object[] objArr32 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 251935740};
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame8 == null) {
                    int i33 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 26;
                    char scrollDefaultDelay = (char) (30068 - (ViewConfiguration.getScrollDefaultDelay() >> 16));
                    int i34 = 817 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                    Object[] objArr33 = new Object[1];
                    q((byte) 28, (byte) 80, $$a[47], objArr33);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i33, scrollDefaultDelay, i34, -797394565, false, (String) objArr33[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                Object[] objArr34 = (Object[]) ((Method) objAccessartificialFrame8).invoke(null, objArr32);
                Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame9 == null) {
                    int fadingEdgeLength2 = 25 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                    char c4 = (char) (30068 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                    int iMyPid = (Process.myPid() >> 22) + 816;
                    byte b6 = $$a[5];
                    byte b7 = (byte) (b6 - 1);
                    Object[] objArr35 = new Object[1];
                    q(b7, (byte) (b7 | 88), b6, objArr35);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength2, c4, iMyPid, 891606461, false, (String) objArr35[0], null);
                }
                ((Field) objAccessartificialFrame9).set(null, objArr34);
                try {
                    Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame10 == null) {
                        int iNormalizeMetaState = 25 - KeyEvent.normalizeMetaState(0);
                        char cIndexOf2 = (char) (TextUtils.indexOf((CharSequence) r14, '0', 0) + 30069);
                        int iBlue = 816 - Color.blue(0);
                        byte b8 = $$a[5];
                        byte b9 = (byte) (b8 - 1);
                        Object[] objArr36 = new Object[1];
                        q(b9, (byte) (b9 | 96), b8, objArr36);
                        objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState, cIndexOf2, iBlue, 721586079, false, (String) objArr36[0], null);
                    }
                    ((Field) objAccessartificialFrame10).set(null, lValueOf3);
                    objArr3 = objArr34;
                } catch (Exception unused2) {
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
            Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame11 == null) {
                int i35 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 25;
                char tapTimeout = (char) ((ViewConfiguration.getTapTimeout() >> 16) + 30068);
                int iGreen = Color.green(0) + 816;
                byte b10 = $$a[5];
                byte b11 = (byte) (b10 - 1);
                Object[] objArr37 = new Object[1];
                q(b11, (byte) (b11 | 88), b10, objArr37);
                objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(i35, tapTimeout, iGreen, 891606461, false, (String) objArr37[0], null);
            }
            Object[] objArr38 = (Object[]) ((Field) objAccessartificialFrame11).get(null);
            objArr3 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i36 = ((int[]) objArr38[0])[0];
            int i37 = ((int[]) objArr38[1])[0];
            String[] strArr = (String[]) objArr38[2];
            int elapsedCpuTime2 = (int) Process.getElapsedCpuTime();
            int i38 = ~elapsedCpuTime2;
            int i39 = (-390953528) + ((1029178750 | i38) * (-757)) + ((~(1037576190 | elapsedCpuTime2)) * 1514) + (((~(elapsedCpuTime2 | (-8397441))) | (~(i38 | 831006384)) | 206569806) * 757) + 251935740;
            int i40 = (i39 << 13) ^ i39;
            int i41 = i40 ^ (i40 >>> 17);
            ((int[]) objArr3[3])[0] = i41 ^ (i41 << 5);
        }
        int i42 = ((int[]) objArr3[1])[0];
        int i43 = ((int[]) objArr3[0])[0];
        if (i43 == i42) {
            Object[] objArr39 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i44 = ((int[]) objArr3[3])[0];
            int i45 = ((int[]) objArr3[0])[0];
            int i46 = ((int[]) objArr3[1])[0];
            String[] strArr2 = (String[]) objArr3[2];
            int iIdentityHashCode = System.identityHashCode(this);
            int i47 = ~iIdentityHashCode;
            int i48 = i44 + 1984365353 + ((iIdentityHashCode | 558220420) * 988) + (((~(759547044 | i47)) | (-762701303)) * (-1976)) + (((~(iIdentityHashCode | 561374678)) | 558220420 | (~((-561374679) | i47))) * 988);
            int i49 = (i48 << 13) ^ i48;
            int i50 = i49 ^ (i49 >>> 17);
            ((int[]) objArr39[3])[0] = i50 ^ (i50 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr3[2];
            if (strArr3 != null) {
                for (String str5 : strArr3) {
                    arrayList.add(str5);
                }
            }
            Object[] objArr40 = {Long.valueOf((((long) (-1832323686)) << 32) ^ ((long) (i42 ^ i43))), Long.valueOf(-1832323685)};
            byte[] bArr10 = $$g;
            Object[] objArr41 = new Object[1];
            t(bArr10[14], bArr10[640], bArr10[82], objArr41);
            Class<?> cls6 = Class.forName((String) objArr41[0]);
            Object[] objArr42 = new Object[1];
            t((short) (-bArr10[219]), bArr10[14], bArr10[210], objArr42);
            cls6.getMethod((String) objArr42[0], Long.TYPE, Long.TYPE).invoke(null, objArr40);
            Object[] objArr43 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i51 = ((int[]) objArr3[3])[0];
            int i52 = ((int[]) objArr3[0])[0];
            int i53 = ((int[]) objArr3[1])[0];
            String[] strArr4 = (String[]) objArr3[2];
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i54 = i51 + (-101806364) + (((-35901446) | iIdentityHashCode2) * (-627)) + (((~((-94112633) | iIdentityHashCode2)) | 104059733) * (-627)) + (((~(iIdentityHashCode2 | 104059733)) | (~((~iIdentityHashCode2) | 94112632))) * 627);
            int i55 = (i54 << 13) ^ i54;
            int i56 = i55 ^ (i55 >>> 17);
            ((int[]) objArr43[3])[0] = i56 ^ (i56 << 5);
        }
        Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame12 == null) {
            int doubleTapTimeout = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 17;
            char c5 = (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1);
            int size2 = 747 - View.MeasureSpec.getSize(0);
            byte b12 = $$a[5];
            byte b13 = (byte) (b12 - 1);
            Object[] objArr44 = new Object[1];
            q(b13, (byte) (b13 | 96), b12, objArr44);
            objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout, c5, size2, -144068856, false, (String) objArr44[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame12).getLong(null);
        if (j3 == -1 || j3 + 4611686018427387813L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext2 = getBaseContext();
            if (baseContext2 == null) {
                Object[] objArr45 = new Object[1];
                s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 3, new char[]{16903, 27626, 48158, 56933, 16998, 49499, 59844, 56970, 59668, 15832, 48448, 29266, 5278, 27213, 4312, 35294, 16434, 50906, 58456, 56605, 61313, 13132, 49092, 28817, 6975, 28617, 4934, 33801, 18062, 50249}, objArr45);
                Class<?> cls7 = Class.forName((String) objArr45[0]);
                Object[] objArr46 = new Object[1];
                s((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 1, new char[]{52626, 42466, 44196, 12614, 52721, 3912, 63848, 12713, 26251, 62423, 44522, 40222, 39706, 42053, '~', 26298, 53125, 2256, 62690, 12862, 24589, 64835}, objArr46);
                baseContext2 = (Context) cls7.getMethod((String) objArr46[0], new Class[0]).invoke(null, null);
            }
            if (baseContext2 != null) {
                baseContext2 = ((baseContext2 instanceof ContextWrapper) && ((ContextWrapper) baseContext2).getBaseContext() == null) ? null : baseContext2.getApplicationContext();
            }
            int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            int i57 = artificialFrame + 121;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i57 % 128;
            int i58 = i57 % 2;
            Object[] objArr47 = {baseContext2, Integer.valueOf(iIntValue), 0, 1876447150};
            byte[] bArr11 = $$g;
            Object[] objArr48 = new Object[1];
            t((short) 254, (byte) (-bArr11[346]), bArr11[14], objArr48);
            Class<?> cls8 = Class.forName((String) objArr48[0]);
            Object[] objArr49 = new Object[1];
            t((short) 306, bArr11[12], (byte) (bArr11[305] - 1), objArr49);
            Object[] objArr50 = (Object[]) cls8.getMethod((String) objArr49[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr47);
            Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame13 == null) {
                int iIndexOf3 = TextUtils.indexOf((CharSequence) r14, '0') + 18;
                char cResolveSize = (char) View.resolveSize(0, 0);
                int iMyPid2 = (Process.myPid() >> 22) + 747;
                byte b14 = $$a[5];
                byte b15 = (byte) (b14 - 1);
                Object[] objArr51 = new Object[1];
                q(b15, (byte) (b15 | 88), b14, objArr51);
                objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(iIndexOf3, cResolveSize, iMyPid2, -1031537386, false, (String) objArr51[0], null);
            }
            ((Field) objAccessartificialFrame13).set(null, objArr50);
            try {
                Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame14 == null) {
                    int trimmedLength = TextUtils.getTrimmedLength(r14) + 17;
                    char cIndexOf3 = (char) ((-1) - TextUtils.indexOf((CharSequence) r14, '0'));
                    int scrollBarFadeDuration = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 747;
                    byte b16 = $$a[5];
                    byte b17 = (byte) (b16 - 1);
                    Object[] objArr52 = new Object[1];
                    q(b17, (byte) (b17 | 96), b16, objArr52);
                    objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(trimmedLength, cIndexOf3, scrollBarFadeDuration, -144068856, false, (String) objArr52[0], null);
                }
                ((Field) objAccessartificialFrame14).set(null, lValueOf4);
                objArr4 = objArr50;
            } catch (Exception unused3) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame15 == null) {
                int iAlpha = Color.alpha(0) + 17;
                char cRed = (char) Color.red(0);
                int i59 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 746;
                byte b18 = $$a[5];
                byte b19 = (byte) (b18 - 1);
                Object[] objArr53 = new Object[1];
                q(b19, (byte) (b19 | 88), b18, objArr53);
                objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(iAlpha, cRed, i59, -1031537386, false, (String) objArr53[0], null);
            }
            Object[] objArr54 = (Object[]) ((Field) objAccessartificialFrame15).get(null);
            objArr4 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
            int i60 = ((int[]) objArr54[3])[0];
            int i61 = ((int[]) objArr54[4])[0];
            List list = (List) objArr54[0];
            List list2 = (List) objArr54[2];
            int i62 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenHeightDp;
            int i63 = ~i62;
            int i64 = (~((-1906642) | i63)) | 1642768;
            int i65 = ~(i62 | 603805689);
            int i66 = ((i64 | i65) * (-252)) + 1019425993 + ((i65 | (~(i63 | (-263874)))) * 252) + 1876447150;
            int i67 = (i66 << 13) ^ i66;
            int i68 = i67 ^ (i67 >>> 17);
            ((int[]) objArr4[1])[0] = i68 ^ (i68 << 5);
        }
        int i69 = ((int[]) objArr4[4])[0];
        int i70 = ((int[]) objArr4[3])[0];
        if (i70 == i69) {
            Object[] objArr55 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i71 = ((int[]) objArr4[1])[0];
            int i72 = ((int[]) objArr4[3])[0];
            int i73 = ((int[]) objArr4[4])[0];
            List list3 = (List) objArr4[0];
            List list4 = (List) objArr4[2];
            int iIdentityHashCode3 = System.identityHashCode(this);
            int i74 = i71 + ((((~((-34160649) | iIdentityHashCode3)) | 4289) * 449) - 1851632129) + (((~((~iIdentityHashCode3) | (-34160649))) | 4289) * 449);
            int i75 = (i74 << 13) ^ i74;
            int i76 = i75 ^ (i75 >>> 17);
            ((int[]) objArr55[1])[0] = i76 ^ (i76 << 5);
            i2 = 0;
            i = 1;
        } else {
            ArrayList arrayList2 = new ArrayList();
            Object[] objArr56 = {objArr4};
            Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1804664566);
            if (objAccessartificialFrame16 == null) {
                objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(41 - View.resolveSize(0, 0), (char) (12468 - (ViewConfiguration.getTouchSlop() >> 8)), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 3642, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
            }
            arrayList2.add(((Method) objAccessartificialFrame16).invoke(null, objArr56));
            Object[] objArr57 = {objArr4};
            Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-1243809191);
            if (objAccessartificialFrame17 == null) {
                objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 42, (char) (12468 - View.MeasureSpec.makeMeasureSpec(0, 0)), 3643 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
            }
            arrayList2.add(((Method) objAccessartificialFrame17).invoke(null, objArr57));
            Object[] objArr58 = {Long.valueOf((((long) 1453933399) << 32) ^ ((long) (i69 ^ i70))), Long.valueOf(1453933407)};
            byte[] bArr12 = $$g;
            Object[] objArr59 = new Object[1];
            t((short) 325, bArr12[115], bArr12[82], objArr59);
            Class<?> cls9 = Class.forName((String) objArr59[0]);
            Object[] objArr60 = new Object[1];
            t((short) (-bArr12[219]), bArr12[14], bArr12[210], objArr60);
            cls9.getMethod((String) objArr60[0], Long.TYPE, Long.TYPE).invoke(null, objArr58);
            Object[] objArr61 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i77 = ((int[]) objArr4[1])[0];
            int i78 = ((int[]) objArr4[3])[0];
            int i79 = ((int[]) objArr4[4])[0];
            List list5 = (List) objArr4[0];
            List list6 = (List) objArr4[2];
            int i80 = ~(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(16) - 1267341244);
            int i81 = i77 + ((((-594402779) + (((~(603872511 | i80)) | 1575946) * (-828))) + ((i80 | 603872511) * (-828))) - 1790233600);
            int i82 = (i81 << 13) ^ i81;
            int i83 = i82 ^ (i82 >>> 17);
            i = 1;
            i2 = 0;
            ((int[]) objArr61[1])[0] = i83 ^ (i83 << 5);
        }
        Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame18 == null) {
            int iIndexOf4 = TextUtils.indexOf((CharSequence) r14, (CharSequence) r14, i2, i2) + 26;
            char cAxisFromString = (char) (MotionEvent.axisFromString(r14) + i);
            int scrollDefaultDelay2 = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 1041;
            byte b20 = $$a[5];
            byte b21 = (byte) (b20 - 1);
            Object[] objArr62 = new Object[1];
            q(b21, (byte) (b21 | 96), b20, objArr62);
            objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(iIndexOf4, cAxisFromString, scrollDefaultDelay2, 2061780482, false, (String) objArr62[0], null);
        }
        long j4 = ((Field) objAccessartificialFrame18).getLong(null);
        if (j4 == -1 || j4 + 4611686018427387935L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr63 = {-115692991};
            Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame19 == null) {
                objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(7 - TextUtils.indexOf((CharSequence) r14, '0'), (char) (22251 - Color.blue(0)), TextUtils.indexOf((CharSequence) r14, '0', 0, 0) + 1034, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = RandomKt.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame19).newInstance(objArr63), -1330867734, false);
            Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame20 == null) {
                int iBlue2 = 26 - Color.blue(0);
                char keyRepeatTimeout = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                int size3 = 1041 - View.MeasureSpec.getSize(0);
                byte b22 = $$a[5];
                byte b23 = (byte) (b22 - 1);
                Object[] objArr64 = new Object[1];
                q(b23, (byte) (b23 | 88), b22, objArr64);
                objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(iBlue2, keyRepeatTimeout, size3, 1145017376, false, (String) objArr64[0], null);
            }
            ((Field) objAccessartificialFrame20).set(null, objArrAccessartificialFrame$78cbbd35);
            try {
                Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame21 == null) {
                    int size4 = 26 - View.MeasureSpec.getSize(0);
                    char offsetAfter = (char) TextUtils.getOffsetAfter(r14, 0);
                    int iIndexOf5 = TextUtils.indexOf((CharSequence) r14, '0') + 1042;
                    byte b24 = $$a[5];
                    byte b25 = (byte) (b24 - 1);
                    Object[] objArr65 = new Object[1];
                    q(b25, (byte) (b25 | 96), b24, objArr65);
                    objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(size4, offsetAfter, iIndexOf5, 2061780482, false, (String) objArr65[0], null);
                }
                ((Field) objAccessartificialFrame21).set(null, lValueOf5);
            } catch (Exception unused4) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame22 == null) {
                int i84 = 27 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                char c6 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                int mode = 1041 - View.MeasureSpec.getMode(0);
                byte b26 = $$a[5];
                byte b27 = (byte) (b26 - 1);
                Object[] objArr66 = new Object[1];
                q(b27, (byte) (b27 | 88), b26, objArr66);
                objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(i84, c6, mode, 1145017376, false, (String) objArr66[0], null);
            }
            Object[] objArr67 = (Object[]) ((Field) objAccessartificialFrame22).get(null);
            objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
            int i85 = ((int[]) objArr67[3])[0];
            int i86 = ((int[]) objArr67[2])[0];
            String[] strArr5 = (String[]) objArr67[0];
            int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(1) + 508472209;
            int i87 = ~iCodePointAt;
            int i88 = ((1406123029 + ((((~(i87 | (-554974091))) | 15106) | (~((-78118914) | iCodePointAt))) * 717)) + (((~(iCodePointAt | (-554974091))) | ((~(i87 | (-78118914))) | 15106)) * 717)) - 1330867734;
            int i89 = (i88 << 13) ^ i88;
            int i90 = i89 ^ (i89 >>> 17);
            ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i90 ^ (i90 << 5);
        }
        int i91 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i92 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i92 == i91) {
            Object[] objArr68 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i93 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i94 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i95 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr6 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iMyPid3 = Process.myPid();
            int i96 = 75251726 + ((iMyPid3 | 253771747) * (-50));
            int i97 = ~((-83887364) | iMyPid3);
            int i98 = ~iMyPid3;
            int i99 = i93 + i96 + ((i97 | (~(259555303 | i98))) * 50) + (((~(i98 | 253771747)) | (~(175667940 | i98)) | (-259555304)) * 50);
            int i100 = (i99 << 13) ^ i99;
            int i101 = i100 ^ (i100 >>> 17);
            ((int[]) objArr68[1])[0] = i101 ^ (i101 << 5);
            i3 = 0;
        } else {
            ArrayList arrayList3 = new ArrayList();
            String[] strArr7 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr7 != null) {
                for (String str6 : strArr7) {
                    arrayList3.add(str6);
                }
            }
            Object[] objArr69 = {Long.valueOf((((long) (-37856877)) << 32) ^ ((long) (i91 ^ i92))), Long.valueOf(-37856879)};
            byte[] bArr13 = $$g;
            Object[] objArr70 = new Object[1];
            t((short) 388, bArr13[142], bArr13[14], objArr70);
            Class<?> cls10 = Class.forName((String) objArr70[0]);
            Object[] objArr71 = new Object[1];
            t((short) (-bArr13[219]), bArr13[14], bArr13[210], objArr71);
            cls10.getMethod((String) objArr71[0], Long.TYPE, Long.TYPE).invoke(null, objArr69);
            Object[] objArr72 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i102 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i103 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i104 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr8 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int i105 = ~(System.identityHashCode(this) | (-919668337));
            int i106 = i102 + (((-1073336192) | i105) * (-196)) + 103479170 + ((i105 | 153667855) * 196);
            int i107 = (i106 << 13) ^ i106;
            int i108 = i107 ^ (i107 >>> 17);
            i3 = 0;
            ((int[]) objArr72[1])[0] = i108 ^ (i108 << 5);
        }
        Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame23 == null) {
            int offsetBefore = 30 - TextUtils.getOffsetBefore(r14, i3);
            char tapTimeout2 = (char) ((ViewConfiguration.getTapTimeout() >> 16) + 49362);
            int doubleTapTimeout2 = 684 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
            byte[] bArr14 = $$a;
            Object[] objArr73 = new Object[1];
            q(bArr14[8], bArr14[14], bArr14[28], objArr73);
            objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(offsetBefore, tapTimeout2, doubleTapTimeout2, 752929587, false, (String) objArr73[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame23).getLong(null);
        if (j5 == -1 || j5 + 1874 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext3 = getBaseContext();
            if (baseContext3 == null) {
                Object[] objArr74 = new Object[1];
                s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 114, new char[]{16903, 27626, 48158, 56933, 16998, 49499, 59844, 56970, 59668, 15832, 48448, 29266, 5278, 27213, 4312, 35294, 16434, 50906, 58456, 56605, 61313, 13132, 49092, 28817, 6975, 28617, 4934, 33801, 18062, 50249}, objArr74);
                Class<?> cls11 = Class.forName((String) objArr74[0]);
                Object[] objArr75 = new Object[1];
                s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 3, new char[]{52626, 42466, 44196, 12614, 52721, 3912, 63848, 12713, 26251, 62423, 44522, 40222, 39706, 42053, '~', 26298, 53125, 2256, 62690, 12862, 24589, 64835}, objArr75);
                baseContext3 = (Context) cls11.getMethod((String) objArr75[0], new Class[0]).invoke(null, null);
            }
            if (baseContext3 != null) {
                baseContext3 = ((baseContext3 instanceof ContextWrapper) && ((ContextWrapper) baseContext3).getBaseContext() == null) ? null : baseContext3.getApplicationContext();
            }
            Object[] objArr76 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1472785776};
            byte[] bArr15 = $$g;
            Object[] objArr77 = new Object[1];
            t((short) 431, bArr15[30], bArr15[82], objArr77);
            Class<?> cls12 = Class.forName((String) objArr77[0]);
            Object[] objArr78 = new Object[1];
            t((short) 306, bArr15[12], (byte) (bArr15[305] - 1), objArr78);
            objArr5 = (Object[]) cls12.getMethod((String) objArr78[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr76);
            if (baseContext3 != null) {
                Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-326560385);
                if (objAccessartificialFrame24 == null) {
                    int touchSlop = (ViewConfiguration.getTouchSlop() >> 8) + 30;
                    char c7 = (char) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 49362);
                    int longPressTimeout = 684 - (ViewConfiguration.getLongPressTimeout() >> 16);
                    byte[] bArr16 = $$a;
                    Object[] objArr79 = new Object[1];
                    q(bArr16[9], (byte) (bArr16[33] - 1), bArr16[28], objArr79);
                    objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(touchSlop, c7, longPressTimeout, 1944867703, false, (String) objArr79[0], null);
                }
                ((Field) objAccessartificialFrame24).set(null, objArr5);
                try {
                    Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                    if (objAccessartificialFrame25 == null) {
                        int fadingEdgeLength3 = 30 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                        char touchSlop2 = (char) ((ViewConfiguration.getTouchSlop() >> 8) + 49362);
                        int edgeSlop3 = (ViewConfiguration.getEdgeSlop() >> 16) + 684;
                        byte[] bArr17 = $$a;
                        Object[] objArr80 = new Object[1];
                        q(bArr17[8], bArr17[14], bArr17[28], objArr80);
                        objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength3, touchSlop2, edgeSlop3, 752929587, false, (String) objArr80[0], null);
                    }
                    ((Field) objAccessartificialFrame25).set(null, lValueOf6);
                } catch (Exception unused5) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(-326560385);
            if (objAccessartificialFrame26 == null) {
                int maxKeyCode = (KeyEvent.getMaxKeyCode() >> 16) + 30;
                char doubleTapTimeout3 = (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 49362);
                int mirror = AndroidCharacter.getMirror('0') + 636;
                byte[] bArr18 = $$a;
                Object[] objArr81 = new Object[1];
                q(bArr18[9], (byte) (bArr18[33] - 1), bArr18[28], objArr81);
                objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(maxKeyCode, doubleTapTimeout3, mirror, 1944867703, false, (String) objArr81[0], null);
            }
            Object[] objArr82 = (Object[]) ((Field) objAccessartificialFrame26).get(null);
            objArr5 = new Object[]{new int[]{((int[]) objArr82[0])[0]}, new int[]{((int[]) objArr82[1])[0]}, new int[1], (String) objArr82[3]};
            int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
            int i109 = ((((~((-215590870) | iElapsedRealtime)) | 8454804) * (-283)) - 923633990) + ((~(iElapsedRealtime | (-207136066))) * 283) + 1472785776;
            int i110 = (i109 << 13) ^ i109;
            int i111 = i110 ^ (i110 >>> 17);
            ((int[]) objArr5[2])[0] = i111 ^ (i111 << 5);
        }
        int i112 = ((int[]) objArr5[1])[0];
        int i113 = ((int[]) objArr5[0])[0];
        if (i113 == i112) {
            int i114 = getARTIFICIAL_FRAME_PACKAGE_NAME + 27;
            artificialFrame = i114 % 128;
            int i115 = i114 % 2;
            int i116 = ((int[]) objArr5[2])[0];
            Object[] objArr83 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int i117 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().densityDpi;
            int i118 = i116 + (-1427426690) + (((~(i117 | 236530562)) | (-742093213)) * (-465)) + ((236530562 | (~((-742093213) | i117))) * 930) + ((i117 | (-539119645)) * 465);
            int i119 = (i118 << 13) ^ i118;
            int i120 = i119 ^ (i119 >>> 17);
            ((int[]) objArr83[2])[0] = i120 ^ (i120 << 5);
        } else {
            Object[] objArr84 = {Long.valueOf(((long) (i112 ^ i113)) ^ (((long) (-865398173)) << 32)), Long.valueOf(-865398169)};
            byte[] bArr19 = $$g;
            Object[] objArr85 = new Object[1];
            t((short) 490, bArr19[44], bArr19[82], objArr85);
            Class<?> cls13 = Class.forName((String) objArr85[0]);
            Object[] objArr86 = new Object[1];
            t((short) (-bArr19[219]), bArr19[14], bArr19[210], objArr86);
            cls13.getMethod((String) objArr86[0], Long.TYPE, Long.TYPE).invoke(null, objArr84);
            int i121 = ((int[]) objArr5[2])[0];
            Object[] objArr87 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
            int i122 = ~startElapsedRealtime;
            int i123 = (~((-907421943) | i122)) | 68558880;
            int i124 = ~(startElapsedRealtime | 910064894);
            int i125 = i121 + ((i123 | i124) * (-252)) + 1075592350 + ((i124 | (~(i122 | (-838863063)))) * 252);
            int i126 = (i125 << 13) ^ i125;
            int i127 = i126 ^ (i126 >>> 17);
            ((int[]) objArr87[2])[0] = i127 ^ (i127 << 5);
        }
        Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame27 == null) {
            int packedPositionGroup = ExpandableListView.getPackedPositionGroup(0L) + 30;
            char pressedStateDuration = (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 49362);
            int mirror2 = 732 - AndroidCharacter.getMirror('0');
            byte[] bArr20 = $$a;
            Object[] objArr88 = new Object[1];
            q(bArr20[9], (byte) (-bArr20[94]), (byte) (-bArr20[4]), objArr88);
            objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(packedPositionGroup, pressedStateDuration, mirror2, -1583976536, false, (String) objArr88[0], null);
        }
        long j6 = ((Field) objAccessartificialFrame27).getLong(null);
        if (j6 != -1) {
            int i128 = artificialFrame + 19;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i128 % 128;
            if (i128 % 2 == 0 ? j6 + 1940 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue() : (j6 & 1940) < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                int iIntValue3 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                int i129 = getARTIFICIAL_FRAME_PACKAGE_NAME + 39;
                artificialFrame = i129 % 128;
                int i130 = i129 % 2;
                Object[] objArr89 = {Integer.valueOf(iIntValue3), 1619027806};
                short s4 = (short) SyslogConstants.SYSLOG_PORT;
                byte[] bArr21 = $$g;
                Object[] objArr90 = new Object[1];
                t(s4, (byte) (bArr21[220] - 1), bArr21[82], objArr90);
                Class<?> cls14 = Class.forName((String) objArr90[0]);
                Object[] objArr91 = new Object[1];
                t((short) 562, bArr21[368], bArr21[82], objArr91);
                objArr6 = (Object[]) cls14.getMethod((String) objArr91[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr89);
                objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame3 == null) {
                    int i131 = 31 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                    char cRgb = (char) (Color.rgb(0, 0, 0) + 16826578);
                    int longPressTimeout2 = (ViewConfiguration.getLongPressTimeout() >> 16) + 684;
                    byte[] bArr22 = $$a;
                    Object[] objArr92 = new Object[1];
                    q(bArr22[11], bArr22[28], bArr22[5], objArr92);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i131, cRgb, longPressTimeout2, -1456483158, false, (String) objArr92[0], null);
                }
                ((Field) objAccessartificialFrame3).set(null, objArr6);
                try {
                    Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1056123296);
                    if (objAccessartificialFrame4 == null) {
                        int i132 = 31 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                        char scrollBarFadeDuration2 = (char) (49362 - (ViewConfiguration.getScrollBarFadeDuration() >> 16));
                        int iIndexOf6 = TextUtils.indexOf((CharSequence) r14, '0', 0) + 685;
                        byte[] bArr23 = $$a;
                        Object[] objArr93 = new Object[1];
                        q(bArr23[9], (byte) (-bArr23[94]), (byte) (-bArr23[4]), objArr93);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i132, scrollBarFadeDuration2, iIndexOf6, -1583976536, false, (String) objArr93[0], null);
                    }
                    ((Field) objAccessartificialFrame4).set(null, lValueOf7);
                } catch (Exception unused6) {
                    throw new RuntimeException();
                }
            } else {
                Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame28 == null) {
                    int iMyTid = (Process.myTid() >> 22) + 30;
                    char windowTouchSlop = (char) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 49362);
                    int i133 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 684;
                    byte[] bArr24 = $$a;
                    Object[] objArr94 = new Object[1];
                    q(bArr24[11], bArr24[28], bArr24[5], objArr94);
                    objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(iMyTid, windowTouchSlop, i133, -1456483158, false, (String) objArr94[0], null);
                }
                Object[] objArr95 = (Object[]) ((Field) objAccessartificialFrame28).get(null);
                objArr6 = new Object[]{new int[]{((int[]) objArr95[0])[0]}, new int[]{((int[]) objArr95[1])[0]}, new int[1], (String) objArr95[3]};
                int i134 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().densityDpi;
                int i135 = (-221413010) + (((~(82480560 | i134)) | 991240783) * 336) + (((~(i134 | 1061104335)) | 12617008) * (-168)) + (((~((~i134) | 1061104335)) | 82480560) * 168) + 1619027806;
                int i136 = (i135 << 13) ^ i135;
                int i137 = i136 ^ (i136 >>> 17);
                ((int[]) objArr6[2])[0] = i137 ^ (i137 << 5);
            }
        } else {
            int iIntValue4 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            int i1210 = getARTIFICIAL_FRAME_PACKAGE_NAME + 39;
            artificialFrame = i1210 % 128;
            int i138 = i1210 % 2;
            Object[] objArr810 = {Integer.valueOf(iIntValue4), 1619027806};
            short s5 = (short) SyslogConstants.SYSLOG_PORT;
            byte[] bArr25 = $$g;
            Object[] objArr96 = new Object[1];
            t(s5, (byte) (bArr25[220] - 1), bArr25[82], objArr96);
            Class<?> cls15 = Class.forName((String) objArr96[0]);
            Object[] objArr97 = new Object[1];
            t((short) 562, bArr25[368], bArr25[82], objArr97);
            objArr6 = (Object[]) cls15.getMethod((String) objArr97[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr810);
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame3 == null) {
                int i139 = 31 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                char cRgb2 = (char) (Color.rgb(0, 0, 0) + 16826578);
                int longPressTimeout3 = (ViewConfiguration.getLongPressTimeout() >> 16) + 684;
                byte[] bArr26 = $$a;
                Object[] objArr98 = new Object[1];
                q(bArr26[11], bArr26[28], bArr26[5], objArr98);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i139, cRgb2, longPressTimeout3, -1456483158, false, (String) objArr98[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, objArr6);
            Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1056123296);
            if (objAccessartificialFrame4 == null) {
                int i1310 = 31 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                char scrollBarFadeDuration3 = (char) (49362 - (ViewConfiguration.getScrollBarFadeDuration() >> 16));
                int iIndexOf7 = TextUtils.indexOf((CharSequence) r14, '0', 0) + 685;
                byte[] bArr27 = $$a;
                Object[] objArr99 = new Object[1];
                q(bArr27[9], (byte) (-bArr27[94]), (byte) (-bArr27[4]), objArr99);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i1310, scrollBarFadeDuration3, iIndexOf7, -1583976536, false, (String) objArr99[0], null);
            }
            ((Field) objAccessartificialFrame4).set(null, lValueOf8);
        }
        int i140 = ((int[]) objArr6[1])[0];
        int i141 = ((int[]) objArr6[0])[0];
        if (i141 == i140) {
            int i142 = ((int[]) objArr6[2])[0];
            Object[] objArr100 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
            int iIdentityHashCode4 = System.identityHashCode(this);
            int i143 = ~iIdentityHashCode4;
            int i144 = i142 + (-1836177502) + ((iIdentityHashCode4 | 476075409) * 140) + (((~(476075409 | i143)) | 26477068) * (-280)) + (((~(iIdentityHashCode4 | (-26477069))) | (~(502548365 | i143)) | 4112) * 140);
            int i145 = (i144 << 13) ^ i144;
            int i146 = i145 ^ (i145 >>> 17);
            i4 = 0;
            ((int[]) objArr100[2])[0] = i146 ^ (i146 << 5);
        } else {
            new ArrayList().add((String) objArr6[3]);
            long j7 = ((long) (i140 ^ i141)) ^ (((long) 683839186) << 32);
            long j8 = 683839170;
            int i147 = getARTIFICIAL_FRAME_PACKAGE_NAME + 91;
            artificialFrame = i147 % 128;
            int i148 = i147 % 2;
            Object[] objArr101 = {Long.valueOf(j7), Long.valueOf(j8)};
            short s6 = (short) ($$h + 5);
            byte[] bArr28 = $$g;
            Object[] objArr102 = new Object[1];
            t(s6, (byte) (-bArr28[219]), bArr28[82], objArr102);
            Class<?> cls16 = Class.forName((String) objArr102[0]);
            Object[] objArr103 = new Object[1];
            t((short) (-bArr28[219]), bArr28[14], bArr28[210], objArr103);
            cls16.getMethod((String) objArr103[0], Long.TYPE, Long.TYPE).invoke(null, objArr101);
            int i149 = ((int[]) objArr6[2])[0];
            Object[] objArr104 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
            int iIdentityHashCode5 = System.identityHashCode(this);
            int i150 = ~iIdentityHashCode5;
            int i151 = i149 + 2063287008 + (((~((-921011222) | i150)) | 57612553) * 226) + (((~(i150 | (-880837653))) | (~((-57612554) | iIdentityHashCode5)) | 17438984) * (-113)) + ((~(iIdentityHashCode5 | (-921011222))) * 113);
            int i152 = (i151 << 13) ^ i151;
            int i153 = i152 ^ (i152 >>> 17);
            i4 = 0;
            ((int[]) objArr104[2])[0] = i153 ^ (i153 << 5);
        }
        Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame29 == null) {
            int iGreen2 = Color.green(i4) + 36;
            char cIndexOf4 = (char) (TextUtils.indexOf((CharSequence) r14, '0', i4, i4) + 1);
            int touchSlop3 = 540 - (ViewConfiguration.getTouchSlop() >> 8);
            byte b28 = $$a[5];
            byte b29 = (byte) (b28 - 1);
            Object[] objArr105 = new Object[1];
            q(b29, (byte) (b29 | 96), b28, objArr105);
            objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(iGreen2, cIndexOf4, touchSlop3, 624296913, false, (String) objArr105[0], null);
        }
        long j9 = ((Field) objAccessartificialFrame29).getLong(null);
        if (j9 == -1 || j9 + 1877 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(-1717965552);
            if (objAccessartificialFrame30 == null) {
                objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(20 - (ViewConfiguration.getTapTimeout() >> 16), (char) (39516 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))), 982 - TextUtils.indexOf((CharSequence) r14, (CharSequence) r14, 0, 0), 117222168, false, null, new Class[0]);
            }
            Object[] objArr106 = {null, ((Constructor) objAccessartificialFrame30).newInstance(null), 365820608, 0};
            Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(-501205803);
            if (objAccessartificialFrame31 == null) {
                int mirror3 = 'T' - AndroidCharacter.getMirror('0');
                char c8 = (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                int minimumFlingVelocity = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 540;
                byte[] bArr29 = $$a;
                Object[] objArr107 = new Object[1];
                q((byte) 47, (byte) (bArr29[5] - 1), bArr29[98], objArr107);
                objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(mirror3, c8, minimumFlingVelocity, 2101703389, false, (String) objArr107[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(View.resolveSizeAndState(0, 0, 0) + 54, (char) (833 - (ViewConfiguration.getScrollDefaultDelay() >> 16)), 576 - TextUtils.getCapsMode(r14, 0, 0)), (Class) ArtificialStackFrames.coroutineCreation(View.resolveSizeAndState(0, 0, 0) + 54, (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), 630 - (ViewConfiguration.getTapTimeout() >> 16)), Integer.TYPE, Integer.TYPE});
            }
            objArr7 = (Object[]) ((Method) objAccessartificialFrame31).invoke(null, objArr106);
            Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame32 == null) {
                int iResolveSize = 36 - View.resolveSize(0, 0);
                char longPressTimeout4 = (char) (ViewConfiguration.getLongPressTimeout() >> 16);
                int iNormalizeMetaState2 = 540 - KeyEvent.normalizeMetaState(0);
                byte b30 = $$a[5];
                byte b31 = (byte) (b30 - 1);
                Object[] objArr108 = new Object[1];
                q(b31, (byte) (b31 | 88), b30, objArr108);
                objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(iResolveSize, longPressTimeout4, iNormalizeMetaState2, 793268735, false, (String) objArr108[0], null);
            }
            ((Field) objAccessartificialFrame32).set(null, objArr7);
            try {
                Long lValueOf9 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                if (objAccessartificialFrame33 == null) {
                    int absoluteGravity = 36 - Gravity.getAbsoluteGravity(0, 0);
                    char offsetBefore2 = (char) TextUtils.getOffsetBefore(r14, 0);
                    int packedPositionType = 540 - ExpandableListView.getPackedPositionType(0L);
                    byte b32 = $$a[5];
                    byte b33 = (byte) (b32 - 1);
                    Object[] objArr109 = new Object[1];
                    q(b33, (byte) (b33 | 96), b32, objArr109);
                    objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(absoluteGravity, offsetBefore2, packedPositionType, 624296913, false, (String) objArr109[0], null);
                }
                ((Field) objAccessartificialFrame33).set(null, lValueOf9);
            } catch (Exception unused7) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame34 == null) {
                int pressedStateDuration2 = 36 - (ViewConfiguration.getPressedStateDuration() >> 16);
                char cMyPid = (char) (Process.myPid() >> 22);
                int packedPositionGroup2 = 540 - ExpandableListView.getPackedPositionGroup(0L);
                byte b34 = $$a[5];
                byte b35 = (byte) (b34 - 1);
                Object[] objArr114 = new Object[1];
                q(b35, (byte) (b35 | 88), b34, objArr114);
                objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(pressedStateDuration2, cMyPid, packedPositionGroup2, 793268735, false, (String) objArr114[0], null);
            }
            Object[] objArr115 = (Object[]) ((Field) objAccessartificialFrame34).get(null);
            objArr7 = new Object[]{new int[1], new int[1], new int[1]};
            int i154 = ((int[]) objArr115[2])[0];
            int i155 = ((int[]) objArr115[1])[0];
            ((int[]) objArr7[2])[0] = i154;
            ((int[]) objArr7[1])[0] = i155;
            int iIdentityHashCode6 = System.identityHashCode(this);
            int i156 = ~iIdentityHashCode6;
            int i157 = 730378488 + ((647032198 | i156) * (-757)) + ((~((-158270058) | iIdentityHashCode6)) * 1514) + (((~(iIdentityHashCode6 | 805302255)) | (~(i156 | (-704589552))) | 546319494) * 757) + 365820608;
            int i158 = (i157 << 13) ^ i157;
            int i159 = i158 ^ (i158 >>> 17);
            ((int[]) objArr7[0])[0] = i159 ^ (i159 << 5);
        }
        Object obj2 = objArr7[1];
        int i160 = ((int[]) obj2)[0];
        Object obj3 = objArr7[2];
        int i161 = ((int[]) obj3)[0];
        if (i161 == i160) {
            Object[] objArr116 = {new int[1], new int[1], new int[1]};
            int i162 = ((int[]) objArr7[0])[0];
            int i163 = ((int[]) obj3)[0];
            int i164 = ((int[]) obj2)[0];
            ((int[]) objArr116[2])[0] = i163;
            ((int[]) objArr116[1])[0] = i164;
            int iUptimeMillis2 = (int) SystemClock.uptimeMillis();
            int i165 = i162 + 1279395388 + (((~(iUptimeMillis2 | 441822284)) | (-1048575086)) * 305) + (((~((~iUptimeMillis2) | 441822284)) | (-909799466)) * 305);
            int i166 = (i165 << 13) ^ i165;
            int i167 = i166 ^ (i166 >>> 17);
            i5 = 0;
            ((int[]) objArr116[0])[0] = i167 ^ (i167 << 5);
        } else {
            Object[] objArr117 = {Long.valueOf(((long) (i160 ^ i161)) ^ (((long) 528031935) << 32)), Long.valueOf(528036031)};
            byte[] bArr30 = $$g;
            Object[] objArr118 = new Object[1];
            t((short) 490, bArr30[44], bArr30[82], objArr118);
            Class<?> cls17 = Class.forName((String) objArr118[0]);
            Object[] objArr119 = new Object[1];
            t((short) (-bArr30[219]), bArr30[14], bArr30[210], objArr119);
            cls17.getMethod((String) objArr119[0], Long.TYPE, Long.TYPE).invoke(null, objArr117);
            Object[] objArr120 = {new int[1], new int[1], new int[1]};
            int i168 = ((int[]) objArr7[0])[0];
            int i169 = ((int[]) objArr7[2])[0];
            int i170 = ((int[]) objArr7[1])[0];
            ((int[]) objArr120[2])[0] = i169;
            ((int[]) objArr120[1])[0] = i170;
            int i171 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().densityDpi;
            int i172 = ~i171;
            int i173 = i168 + (-1452293851) + (((~(i172 | 881058302)) | (~((-470563448) | i172)) | 135010817) * 464) + (((-335552631) | i171) * (-464)) + (((~(i171 | 881058302)) | 135010817) * 464);
            int i174 = (i173 << 13) ^ i173;
            int i175 = i174 ^ (i174 >>> 17);
            i5 = 0;
            ((int[]) objArr120[0])[0] = i175 ^ (i175 << 5);
        }
        super.onCreate();
        Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame35 == null) {
            int iResolveSizeAndState = 21 - View.resolveSizeAndState(i5, i5, i5);
            char keyRepeatTimeout2 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
            int edgeSlop4 = 465 - (ViewConfiguration.getEdgeSlop() >> 16);
            byte b36 = $$a[5];
            byte b37 = (byte) (b36 - 1);
            Object[] objArr121 = new Object[1];
            q(b37, (byte) (b37 | 96), b36, objArr121);
            objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState, keyRepeatTimeout2, edgeSlop4, -785931255, false, (String) objArr121[0], null);
        }
        long j10 = ((Field) objAccessartificialFrame35).getLong(null);
        if (j10 == -1 || j10 + 1898 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext4 = getBaseContext();
            if (baseContext4 == null) {
                Object[] objArr122 = new Object[1];
                s(Color.green(0) + 1, new char[]{16903, 27626, 48158, 56933, 16998, 49499, 59844, 56970, 59668, 15832, 48448, 29266, 5278, 27213, 4312, 35294, 16434, 50906, 58456, 56605, 61313, 13132, 49092, 28817, 6975, 28617, 4934, 33801, 18062, 50249}, objArr122);
                Class<?> cls18 = Class.forName((String) objArr122[0]);
                Object[] objArr123 = new Object[1];
                s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 35, new char[]{52626, 42466, 44196, 12614, 52721, 3912, 63848, 12713, 26251, 62423, 44522, 40222, 39706, 42053, '~', 26298, 53125, 2256, 62690, 12862, 24589, 64835}, objArr123);
                baseContext4 = (Context) cls18.getMethod((String) objArr123[0], new Class[0]).invoke(null, null);
            }
            if (baseContext4 != null) {
                int i176 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i177 = i176 + 83;
                artificialFrame = i177 % 128;
                int i178 = i177 % 2;
                if (baseContext4 instanceof ContextWrapper) {
                    int i179 = i176 + 5;
                    artificialFrame = i179 % 128;
                    if (i179 % 2 == 0) {
                        ((ContextWrapper) baseContext4).getBaseContext();
                        throw null;
                    }
                    if (((ContextWrapper) baseContext4).getBaseContext() == null) {
                        baseContext4 = null;
                        obj = null;
                    }
                }
                obj = null;
                baseContext4 = baseContext4.getApplicationContext();
            } else {
                obj = null;
            }
            int iIntValue5 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(obj, this)).intValue();
            Object[] objArr124 = new Object[1];
            s(1 - TextUtils.indexOf((CharSequence) r14, (CharSequence) r14), new char[]{30210, 44508, 19110, 1601, 30308, 1842, 7983, 1774, 56653, 64482, 19450, 43631, 8345, 44082, 58917, 20917, 29766, 185, 4780, 1334, 56215, 62839, 18750, 43257, 12123, 43438, 58804, 23598, 29405, 634, 4147, 1012, 50690, 63143, 19681, 46886, 11652, 43862, 64269, 23128, 29030, 8065, 6021, 478, 50410, 61448, 16982, 46337, 10350, 42203, 65239, 22656, 32692, 6418, 5449, 3099, 50039, 52675, 16794, 46025, 5882, 42520, 64577, 26433, 31345, 6812, 10432, 2707}, objArr124);
            String str7 = (String) objArr124[0];
            Object[] objArr125 = new Object[1];
            s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 34, new char[]{22330, 8101, 17171, 51641, 22287, 46413, 5832, 51521, 64547, 18840, 16921, 26004, 499, 7755, 61328, 40526, 21880, 45765, 6981, 51857, 64249, 18268, 16524, 26449, 3639, 7048, 60428, 37841, 21483, 45142, 6531, 52238, 59194, 17619, 17747, 30858, 3311, 6441, 62143, 38390, 20563, 44543, 7788, 52853, 58843, 16928, 19376, 31486, 2397, 5798, 63286, 38778, 24285, 43833, 7420, 50098, 57876, 32747, 18479, 31846, 14224, 5219, 62893, 43247, 23374, 43239, 8567, 50493}, objArr125);
            Object[] objArr126 = {baseContext4, new String[]{str7, (String) objArr125[0]}, Integer.valueOf(iIntValue5), 1, 694519636};
            byte[] bArr31 = $$g;
            Object[] objArr127 = new Object[1];
            t((short) 578, (byte) (-bArr31[260]), bArr31[368], objArr127);
            Class<?> cls19 = Class.forName((String) objArr127[0]);
            Object[] objArr128 = new Object[1];
            t((short) 168, bArr31[175], bArr31[368], objArr128);
            objArr8 = (Object[]) cls19.getMethod((String) objArr128[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr126);
            int i180 = ((int[]) objArr8[0])[0];
            int i181 = ((int[]) objArr8[3])[0];
            if (baseContext4 != null) {
                Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame36 == null) {
                    int i182 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 21;
                    char packedPositionChild3 = (char) (ExpandableListView.getPackedPositionChild(0L) + 1);
                    int offsetAfter2 = TextUtils.getOffsetAfter(r14, 0) + 465;
                    byte b38 = $$a[5];
                    byte b39 = (byte) (b38 - 1);
                    Object[] objArr129 = new Object[1];
                    q(b39, (byte) (b39 | 88), b38, objArr129);
                    objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(i182, packedPositionChild3, offsetAfter2, -612765161, false, (String) objArr129[0], null);
                }
                ((Field) objAccessartificialFrame36).set(null, objArr8);
                try {
                    Long lValueOf10 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(1313006081);
                    if (objAccessartificialFrame37 == null) {
                        int i183 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 20;
                        char packedPositionType2 = (char) ExpandableListView.getPackedPositionType(0L);
                        int iBlue3 = Color.blue(0) + 465;
                        byte b40 = $$a[5];
                        byte b41 = (byte) (b40 - 1);
                        Object[] objArr130 = new Object[1];
                        q(b41, (byte) (b41 | 96), b40, objArr130);
                        objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(i183, packedPositionType2, iBlue3, -785931255, false, (String) objArr130[0], null);
                    }
                    ((Field) objAccessartificialFrame37).set(null, lValueOf10);
                } catch (Exception unused8) {
                    throw new RuntimeException();
                }
            }
            c = 0;
        } else {
            Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(1142731807);
            if (objAccessartificialFrame38 == null) {
                int keyRepeatTimeout3 = 21 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                char keyRepeatDelay = (char) (ViewConfiguration.getKeyRepeatDelay() >> 16);
                int iIndexOf8 = TextUtils.indexOf((CharSequence) r14, (CharSequence) r14, 0, 0) + 465;
                byte b42 = $$a[5];
                byte b43 = (byte) (b42 - 1);
                Object[] objArr131 = new Object[1];
                q(b43, (byte) (b43 | 88), b42, objArr131);
                objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout3, keyRepeatDelay, iIndexOf8, -612765161, false, (String) objArr131[0], null);
            }
            Object[] objArr132 = (Object[]) ((Field) objAccessartificialFrame38).get(null);
            objArr8 = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
            int i184 = ((int[]) objArr132[3])[0];
            int i185 = ((int[]) objArr132[0])[0];
            String[] strArr9 = (String[]) objArr132[1];
            int i186 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1632539235;
            int i187 = ~i186;
            int i188 = (-779300016) + (((~(454543340 | i187)) | 614893066) * 226) + (((~(i187 | 1069008878)) | (~((-614893067) | i186)) | 427528) * (-113)) + ((~(i186 | 454543340)) * 113) + 694519636;
            int i189 = (i188 << 13) ^ i188;
            int i190 = i189 ^ (i189 >>> 17);
            ((int[]) objArr8[2])[0] = i190 ^ (i190 << 5);
            c = 0;
        }
        int i191 = ((int[]) objArr8[c])[c];
        int i192 = ((int[]) objArr8[3])[c];
        if (i192 == i191) {
            Object[] objArr133 = new Object[4];
            int[] iArr = new int[1];
            objArr133[c] = iArr;
            objArr133[2] = new int[1];
            int[] iArr2 = new int[1];
            objArr133[3] = iArr2;
            int i193 = ((int[]) objArr8[2])[c];
            int i194 = ((int[]) objArr8[3])[c];
            int i195 = ((int[]) objArr8[c])[c];
            String[] strArr10 = (String[]) objArr8[1];
            iArr2[c] = i194;
            iArr[c] = i195;
            int elapsedCpuTime3 = (int) Process.getElapsedCpuTime();
            int i196 = ~elapsedCpuTime3;
            int i197 = i193 + (-65425111) + (((~((-148483) | i196)) | 160498208) * 220) + (((~(i196 | (-270718428))) | 431068153) * (-440)) + ((elapsedCpuTime3 | (-148483)) * 220);
            int i198 = (i197 << 13) ^ i197;
            int i199 = i198 ^ (i198 >>> 17);
            ((int[]) objArr133[2])[0] = i199 ^ (i199 << 5);
            objArr133[1] = strArr10;
            return;
        }
        ArrayList arrayList4 = new ArrayList();
        String[] strArr11 = (String[]) objArr8[1];
        if (strArr11 != null) {
            for (String str8 : strArr11) {
                arrayList4.add(str8);
            }
        }
        Object[] objArr134 = {Long.valueOf((((long) (-202522330)) << 32) ^ ((long) (i191 ^ i192))), Long.valueOf(-202522266)};
        byte[] bArr32 = $$g;
        Object[] objArr135 = new Object[1];
        t((short) 633, bArr32[162], bArr32[82], objArr135);
        Class<?> cls20 = Class.forName((String) objArr135[0]);
        Object[] objArr136 = new Object[1];
        t((short) (-bArr32[219]), bArr32[14], bArr32[210], objArr136);
        cls20.getMethod((String) objArr136[0], Long.TYPE, Long.TYPE).invoke(null, objArr134);
        Object[] objArr137 = {new int[]{i}, strArr, new int[1], new int[]{i}};
        int i200 = ((int[]) objArr8[2])[0];
        int i201 = ((int[]) objArr8[3])[0];
        int i202 = ((int[]) objArr8[0])[0];
        String[] strArr12 = (String[]) objArr8[1];
        int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 727247130;
        int i203 = (~(576654503 | length)) | 161530432;
        int i204 = ~((~length) | (-1180707));
        int i205 = i200 + (-1229758563) + ((i203 | i204) * (-470)) + (((~(length | 738184935)) | i204) * 470);
        int i206 = (i205 << 13) ^ i205;
        int i207 = i206 ^ (i206 >>> 17);
        ((int[]) objArr137[2])[0] = i207 ^ (i207 << 5);
    }

    static {
        byte[] bArr = new byte[679];
        System.arraycopy("bÂ\u008aÞ\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000Ç?\bø\n\u0002\u000fý\u000bù\u000b\u0001\tûÍ9\u0010\u0007÷Í&&\u0001ù\u0015ò\u0006\u0011å\u0016\u0010\bô\rù\u0006å\u001f\u0006\u0015ÿ\u0007\u000b¯#0\u0002\u0007õ\u0011ÿ\n\u0003\u0004A\tÊG\u0002\b¿B\u0007üÿ\u0003\u0006\fÇ9\u0010\u0007÷ÍI\u0001ýÉ\u0019:î\r\u0001þã7õ\u0004\u0003\u0011æ\"ó\u0006\fþ\u0011\u0010\u0002Å=\f\u0004ü\týÍ<\u0007\r÷\u0001\u0003\u0016öÍ9\u0010\u0003ù\u0016\u0001\u0004÷\r\n¾)\u0016\u0010\bô\r\nùü\u000fÝ7ñ\u0002\u0016\u0003ÿ\u0007¶1(ô\u0014ôö\u001c\u0007ýþ\u0011\u0006\u0004\u0006\u0012\u0004ò\u0015\u0006ù\u0001\u0007þ\nü\u000fÞ0ó\u0010ü\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000ÇH÷\u0000\u0006\u0015¾Kø\bø\u0011÷\n\u0002\u0011À/\u001aüþñ%ù\u0005ï#\u0004\u0001¼\u0004%7\u0000õ\u0011\u0000÷\u000fë*ù\nø\u0001\u0013ùþí\u0019\u0010ù\u0006\u0001Ó\u0007ùËIú\b\u0007\u0000ý\u0005\u0010ó\u0010ü\u0016ü\u0007ýÇNù\u0003ÆJ\u0002ó\u0011\t÷\r\u0007ÿÅ\u001a!\u0017õó)ûùÃ$!\u0017õå-\u0007ÿø\u00170\u0007\u0001\n\u0003ù\tûã%\u0001\u0017ö\u0004\u0006\týè-\u0010\u0002Å=\f\u0004ü\týÍ7\u0011ú\u0012\u0001þÿÎ=\n\n¿?\t\nõ\u0011\u0000÷\u000fÆC\u0003\u0003\u0002\u000fï\u001b÷\u000eú\n\u0003õ\u0007\u0003\u0015õ\u0010ù\u0005þ\u0007\u0017ýú\fý\u0003ÎP\u0004ï\u0000\u0001\u0010\u0004\u0000Çÿ?\t\nõ\u0011\u0000÷\u000fÆM\u0000¿(\u0017\u0000\u000fï\u0012\u0001õ ø\fþ\u0013´7\u001fû\u000fõ\u0011æ\u0011\u0016ü\u0010\u0002ÅJ\u0002ó\u0011\tú\u000e\u0005ÿ\u0007\u0005\u0000û\u0012¾J\u0003ó\u0003\u0006\f\u0000\u000f\u0001\nýú\u0006\u0003\u0013ó\tÊ\u0018#\u0006\f\u0000\u000f\u0001\nýúæ#\u0013ó\tß0\u0003ü\u0007\u0002Á\u0011\u0010\u0002Å=\f\u0004ü\týÍ7\u0013ýÉ'(þ\tñó&\u0001\tÿ\u0010\u0002Å=\f\u0004ü\týÍ7\u0011ú\u0012\u0001þÿÎ:\u0001\u0017ñ\u0017\u0002ó\u0011\t\u0001\u0003\u0007\u0006¾9\u0004\u0015¾)%\u0002û\týê\u001c\u0011ù\u0002\u0011\u0010\u0007\u0001\n\u0003ù\tûâ3÷\u0000\u0017ù\n\u0003\u0011ú\u0012\u0001þÿÎI\u0006ÿ\u0004\u0003\u0007\u0006¾LÂþCü\u0003\tüÑ#\u001c\u0003\tüå4\u0001\f\u0000ö\u0011Õ0\u0002\u0007õ\u0017´3&ñ\u0015ô\u0013û\u000b\bù\n\u0003\u0010\u0002Å>\u0005\u000fñ\u0006\t\u0005ü\u0013\u0004Â;\u0017ï\u0006\u000f\bù\n\u0003\t¿#0Î*þ\u0006\u0011\u0001Ú7ï\u0006\u000f\bù\n\u0003".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 679);
        $$g = bArr;
        $$h = 183;
        $$a = new byte[]{Ascii.SYN, -120, 37, 108, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13, 9, -18, 36, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, 7, -18, 43, -29, 4, -17, -2, 9, -18, 34, -25, -4, 17, -19, Ascii.SI, 1, Ascii.DC2, -15, -19, Ascii.VT, -5, 7, 2, -15, 36, -21, -13, Ascii.SI, -2, -9, -6, 34, -15, -19, Ascii.VT, -5, 7, 2, -15, 33, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, -10, Ascii.US, -20, -13, 8, Ascii.VT, Ascii.CR, -27, -49, -2, Ascii.VT, 3, -3, 6, -6, 8, -11, Ascii.EM, -33, 19, -2, -8, 37, -44, 17, -12, 8, -14};
        $$b = 194;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        onPostMessage = 3967590842549139871L;
    }
}
