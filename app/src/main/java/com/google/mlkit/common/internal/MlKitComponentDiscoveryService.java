package com.google.mlkit.common.internal;

import android.app.Service;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.IBinder;
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
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imageutils.JfifUtil;
import com.google.android.material.color.utilities.QuantizerCelebi;
import com.google.common.base.Ascii;
import com.google.crypto.tink.prf.HmacPrfKey;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.Typography;
import net.pluservice.unicoc.R;
import o.ArtificialStackFrames;
import o.onRelationshipValidationResult;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes5.dex */
public class MlKitComponentDiscoveryService extends Service {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    private static int artificialFrame;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static long onPostMessage;
    private static final byte[] $$c = {68, 66, 84, 89};
    private static final int $$f = 12;
    private static int $10 = 0;
    private static int $11 = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x002a  */
    /* JADX WARN: Code duplicated, block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x002e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x002a
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(byte r6, byte r7, byte r8) {
        /*
            byte[] r0 = com.google.mlkit.common.internal.MlKitComponentDiscoveryService.$$c
            int r8 = r8 * 4
            int r1 = 1 - r8
            int r7 = r7 * 3
            int r7 = 3 - r7
            int r6 = r6 * 2
            int r6 = 111 - r6
            byte[] r1 = new byte[r1]
            r2 = 0
            int r8 = 0 - r8
            if (r0 != 0) goto L19
            r6 = r7
            r3 = r8
            r4 = r2
            goto L2e
        L19:
            r3 = r2
            r5 = r7
            r7 = r6
            r6 = r5
        L1d:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L2a:
            int r6 = r6 + 1
            r3 = r0[r6]
        L2e:
            int r7 = r7 + r3
            r3 = r4
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.internal.MlKitComponentDiscoveryService.$$g(byte, byte, byte):java.lang.String");
    }

    private static void a(short s, byte b, int i, Object[] objArr) {
        byte[] bArr = $$a;
        int i2 = b + 65;
        int i3 = 99 - s;
        byte[] bArr2 = new byte[21 - i];
        int i4 = 20 - i;
        int i5 = -1;
        if (bArr == null) {
            i2 = i3 + i4;
            i3 = i3;
        }
        while (true) {
            i5++;
            bArr2[i5] = (byte) i2;
            int i6 = i3 + 1;
            if (i5 == i4) {
                objArr[0] = new String(bArr2, 0);
                return;
            } else {
                i2 += bArr[i6];
                i3 = i6;
            }
        }
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
    private static void c(int r5, short r6, int r7, java.lang.Object[] r8) {
        /*
            int r6 = r6 + 36
            int r0 = 86 - r5
            byte[] r1 = com.google.mlkit.common.internal.MlKitComponentDiscoveryService.$$d
            int r7 = 747 - r7
            byte[] r0 = new byte[r0]
            int r5 = 85 - r5
            r2 = 0
            if (r1 != 0) goto L12
            r3 = r5
            r4 = r2
            goto L24
        L12:
            r3 = r2
        L13:
            byte r4 = (byte) r6
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r5) goto L22
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            r8[r2] = r5
            return
        L22:
            r3 = r1[r7]
        L24:
            int r7 = r7 + 1
            int r3 = -r3
            int r6 = r6 + r3
            int r6 = r6 + (-4)
            r3 = r4
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.internal.MlKitComponentDiscoveryService.c(int, short, int, java.lang.Object[]):void");
    }

    @Override // android.app.Service
    public final IBinder onBind(@NonNull Intent intent) {
        return null;
    }

    private static void b(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        onRelationshipValidationResult onrelationshipvalidationresult = new onRelationshipValidationResult();
        char[] cArrAccessartificialFrame = onRelationshipValidationResult.accessartificialFrame(onPostMessage ^ 2573525503365829440L, cArr, i);
        onrelationshipvalidationresult.e = 4;
        int i3 = $11 + 73;
        $10 = i3 % 128;
        int i4 = i3 % 2;
        while (onrelationshipvalidationresult.e < cArrAccessartificialFrame.length) {
            int i5 = $11 + 31;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            onrelationshipvalidationresult.d = onrelationshipvalidationresult.e - 4;
            int i7 = onrelationshipvalidationresult.e;
            try {
                Object[] objArr2 = {Long.valueOf(cArrAccessartificialFrame[onrelationshipvalidationresult.e] ^ cArrAccessartificialFrame[onrelationshipvalidationresult.e % 4]), Long.valueOf(onrelationshipvalidationresult.d), Long.valueOf(onPostMessage)};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(797310229);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(27 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) (30690 - (ViewConfiguration.getKeyRepeatDelay() >> 16)), 188 - ExpandableListView.getPackedPositionType(0L), -1327449315, false, "k", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                }
                cArrAccessartificialFrame[i7] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                Object[] objArr3 = {onrelationshipvalidationresult, onrelationshipvalidationresult};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(321542193);
                if (objAccessartificialFrame2 == null) {
                    byte b = (byte) 0;
                    byte b2 = b;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(32 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 1482 - TextUtils.lastIndexOf("", '0', 0), -1940971975, false, $$g(b, b2, b2), new Class[]{Object.class, Object.class});
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

    /* JADX WARN: Code duplicated, block: B:20:0x01da  */
    /* JADX WARN: Code duplicated, block: B:23:0x0268 A[Catch: all -> 0x0a71, TryCatch #0 {all -> 0x0a71, blocks: (B:62:0x0778, B:64:0x078c, B:65:0x07bb, B:21:0x0248, B:23:0x0268, B:24:0x02ba), top: B:102:0x0248 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:32:0x039c  */
    /* JADX WARN: Code duplicated, block: B:61:0x06f2  */
    /* JADX WARN: Code duplicated, block: B:64:0x078c A[Catch: all -> 0x0a71, TryCatch #0 {all -> 0x0a71, blocks: (B:62:0x0778, B:64:0x078c, B:65:0x07bb, B:21:0x0248, B:23:0x0268, B:24:0x02ba), top: B:102:0x0248 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x07d1  */
    /* JADX WARN: Code duplicated, block: B:73:0x088d  */
    @Override // android.app.Service, android.content.ContextWrapper
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
        int i2 = artificialFrame + 47;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        if (i2 % 2 != 0) {
            super.attachBaseContext(context);
            Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame7 == null) {
                int iMakeMeasureSpec = 25 - View.MeasureSpec.makeMeasureSpec(0, 0);
                char threadPriority = (char) (((Process.getThreadPriority(0) + 20) >> 6) + 30068);
                int i3 = 816 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                Object[] objArr2 = new Object[1];
                a((byte) ($$b & 480), (byte) 47, $$a[117], objArr2);
                objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec, threadPriority, i3, 721586079, false, (String) objArr2[0], null);
            }
            ((Field) objAccessartificialFrame7).getLong(null);
            throw null;
        }
        super.attachBaseContext(context);
        Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame8 == null) {
            int iMyTid = (Process.myTid() >> 22) + 25;
            char c = (char) (30069 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)));
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0) + 816;
            Object[] objArr3 = new Object[1];
            a((byte) ($$b & 480), (byte) 47, $$a[117], objArr3);
            objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iMyTid, c, iMakeMeasureSpec2, 721586079, false, (String) objArr3[0], null);
        }
        long j = ((Field) objAccessartificialFrame8).getLong(null);
        if (j != -1) {
            long j2 = j + 2008;
            Object[] objArr4 = new Object[1];
            b(-MotionEvent.axisFromString(""), new char[]{31610, 31515, 39276, 32103, 44339, 26013, 30225, 56140, 60033, 60668, 16295, 18684, 22589, 40594, 36417, 42517, 53183, Typography.greater, 6255, 6047, 15687, 45978, 27371, 34049, 44285, 9550}, objArr4);
            Class<?> cls = Class.forName((String) objArr4[0]);
            Object[] objArr5 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 3, new char[]{9564, 9529, 61238, 2879, 42677, 28190, 38385, 14510, 46267, 39594, 13348, 43872, 1553, 59610, 34176, 17874, 37257, 30330, 5117}, objArr5);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i4 = getARTIFICIAL_FRAME_PACKAGE_NAME + 39;
                artificialFrame = i4 % 128;
                int i5 = i4 % 2;
                Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame9 == null) {
                    int iLastIndexOf = 24 - TextUtils.lastIndexOf("", '0');
                    char threadPriority2 = (char) (((Process.getThreadPriority(0) + 20) >> 6) + 30068);
                    int iMakeMeasureSpec3 = 816 - View.MeasureSpec.makeMeasureSpec(0, 0);
                    Object[] objArr6 = new Object[1];
                    a((byte) ($$b & 476), (byte) 47, $$a[117], objArr6);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, threadPriority2, iMakeMeasureSpec3, 891606461, false, (String) objArr6[0], null);
                }
                Object[] objArr7 = (Object[]) ((Field) objAccessartificialFrame9).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i6 = ((int[]) objArr7[0])[0];
                int i7 = ((int[]) objArr7[1])[0];
                String[] strArr = (String[]) objArr7[2];
                int i8 = ~((~Process.myUid()) | 449216796);
                int i9 = ((((180781068 | i8) * (-374)) + 1775067893) + ((i8 | 268435728) * 374)) - 113522044;
                int i10 = (i9 << 13) ^ i9;
                int i11 = i10 ^ (i10 >>> 17);
                ((int[]) objArr[3])[0] = i11 ^ (i11 << 5);
            } else {
                Object[] objArr8 = new Object[1];
                b((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), new char[]{33172, 33278, 48124, 24568, 40456, 22196, 50184, 26950, 4142, 52841, 3211, 64165, 41691, 48223, 48405, 5158, 13659, 8873, 11095, 42382}, objArr8);
                Class<?> cls2 = Class.forName((String) objArr8[0]);
                Object[] objArr9 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 35, new char[]{44641, 44552, 37514, 30347, 48424, 30087, 18076, 60381, 16257, 59162, 12205, 30758, 36097, 38246, 40454, 38563, 6814, 3012, 2149, 10002}, objArr9);
                try {
                    Object[] objArr10 = {Integer.valueOf(((Integer) cls2.getMethod((String) objArr9[0], Object.class).invoke(null, this)).intValue()), 0, -113522044};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame == null) {
                        int jumpTapTimeout = (ViewConfiguration.getJumpTapTimeout() >> 16) + 25;
                        char jumpTapTimeout2 = (char) (30068 - (ViewConfiguration.getJumpTapTimeout() >> 16));
                        int threadPriority3 = 816 - ((Process.getThreadPriority(0) + 20) >> 6);
                        byte b = (byte) ($$b & 468);
                        byte[] bArr = $$a;
                        Object[] objArr11 = new Object[1];
                        a(b, bArr[37], bArr[1], objArr11);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(jumpTapTimeout, jumpTapTimeout2, threadPriority3, -797394565, false, (String) objArr11[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr10);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame2 == null) {
                        int iIndexOf = 24 - TextUtils.indexOf((CharSequence) "", '0');
                        char maximumDrawingCacheSize = (char) (30068 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                        int offsetAfter = TextUtils.getOffsetAfter("", 0) + 816;
                        Object[] objArr12 = new Object[1];
                        a((byte) ($$b & 476), (byte) 47, $$a[117], objArr12);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iIndexOf, maximumDrawingCacheSize, offsetAfter, 891606461, false, (String) objArr12[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArr);
                    try {
                        Object[] objArr13 = new Object[1];
                        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 34, new char[]{31610, 31515, 39276, 32103, 44339, 26013, 30225, 56140, 60033, 60668, 16295, 18684, 22589, 40594, 36417, 42517, 53183, Typography.greater, 6255, 6047, 15687, 45978, 27371, 34049, 44285, 9550}, objArr13);
                        Class<?> cls3 = Class.forName((String) objArr13[0]);
                        Object[] objArr14 = new Object[1];
                        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 3, new char[]{9564, 9529, 61238, 2879, 42677, 28190, 38385, 14510, 46267, 39594, 13348, 43872, 1553, 59610, 34176, 17874, 37257, 30330, 5117}, objArr14);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr14[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame3 == null) {
                            int i12 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 24;
                            char cIndexOf = (char) (30068 - TextUtils.indexOf("", "", 0, 0));
                            int iGreen = 816 - Color.green(0);
                            Object[] objArr15 = new Object[1];
                            a((byte) ($$b & 480), (byte) 47, $$a[117], objArr15);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i12, cIndexOf, iGreen, 721586079, false, (String) objArr15[0], null);
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
            b((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), new char[]{33172, 33278, 48124, 24568, 40456, 22196, 50184, 26950, 4142, 52841, 3211, 64165, 41691, 48223, 48405, 5158, 13659, 8873, 11095, 42382}, objArr16);
            Class<?> cls4 = Class.forName((String) objArr16[0]);
            Object[] objArr17 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 35, new char[]{44641, 44552, 37514, 30347, 48424, 30087, 18076, 60381, 16257, 59162, 12205, 30758, 36097, 38246, 40454, 38563, 6814, 3012, 2149, 10002}, objArr17);
            Object[] objArr18 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue()), 0, -113522044};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame == null) {
                int jumpTapTimeout3 = (ViewConfiguration.getJumpTapTimeout() >> 16) + 25;
                char jumpTapTimeout4 = (char) (30068 - (ViewConfiguration.getJumpTapTimeout() >> 16));
                int threadPriority4 = 816 - ((Process.getThreadPriority(0) + 20) >> 6);
                byte b2 = (byte) ($$b & 468);
                byte[] bArr2 = $$a;
                Object[] objArr19 = new Object[1];
                a(b2, bArr2[37], bArr2[1], objArr19);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(jumpTapTimeout3, jumpTapTimeout4, threadPriority4, -797394565, false, (String) objArr19[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr18);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame2 == null) {
                int iIndexOf2 = 24 - TextUtils.indexOf((CharSequence) "", '0');
                char maximumDrawingCacheSize2 = (char) (30068 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                int offsetAfter2 = TextUtils.getOffsetAfter("", 0) + 816;
                Object[] objArr110 = new Object[1];
                a((byte) ($$b & 476), (byte) 47, $$a[117], objArr110);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iIndexOf2, maximumDrawingCacheSize2, offsetAfter2, 891606461, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArr);
            Object[] objArr111 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 34, new char[]{31610, 31515, 39276, 32103, 44339, 26013, 30225, 56140, 60033, 60668, 16295, 18684, 22589, 40594, 36417, 42517, 53183, Typography.greater, 6255, 6047, 15687, 45978, 27371, 34049, 44285, 9550}, objArr111);
            Class<?> cls5 = Class.forName((String) objArr111[0]);
            Object[] objArr112 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 3, new char[]{9564, 9529, 61238, 2879, 42677, 28190, 38385, 14510, 46267, 39594, 13348, 43872, 1553, 59610, 34176, 17874, 37257, 30330, 5117}, objArr112);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr112[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame3 == null) {
                int i13 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 24;
                char cIndexOf2 = (char) (30068 - TextUtils.indexOf("", "", 0, 0));
                int iGreen2 = 816 - Color.green(0);
                Object[] objArr113 = new Object[1];
                a((byte) ($$b & 480), (byte) 47, $$a[117], objArr113);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i13, cIndexOf2, iGreen2, 721586079, false, (String) objArr113[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i14 = ((int[]) objArr[1])[0];
        int i15 = ((int[]) objArr[0])[0];
        if (i15 == i14) {
            Object[] objArr20 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i16 = ((int[]) objArr[3])[0];
            int i17 = ((int[]) objArr[0])[0];
            int i18 = ((int[]) objArr[1])[0];
            String[] strArr2 = (String[]) objArr[2];
            int layoutDirection = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().getLayoutDirection();
            int i19 = i16 + (-294524567) + (((~((-8499) | layoutDirection)) | 198180864) * (-756)) + (((~layoutDirection) | (-8499)) * 756);
            int i20 = (i19 << 13) ^ i19;
            int i21 = i20 ^ (i20 >>> 17);
            ((int[]) objArr20[3])[0] = i21 ^ (i21 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr[2];
            if (strArr3 != null) {
                int i22 = artificialFrame + 3;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i22 % 128;
                for (int i23 = i22 % 2 != 0 ? 1 : 0; i23 < strArr3.length; i23++) {
                    arrayList.add(strArr3[i23]);
                }
            }
            long j3 = ((long) (i14 ^ i15)) ^ (((long) (-707448775)) << 32);
            long j4 = -707448776;
            int i24 = getARTIFICIAL_FRAME_PACKAGE_NAME + 89;
            artificialFrame = i24 % 128;
            int i25 = i24 % 2;
            try {
                Object[] objArr21 = {Long.valueOf(j3), Long.valueOf(j4)};
                byte[] bArr3 = $$d;
                Object[] objArr22 = new Object[1];
                c(bArr3[91], (byte) (-bArr3[51]), (short) 743, objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                byte b3 = bArr3[28];
                Object[] objArr23 = new Object[1];
                c((byte) 83, b3, (short) (b3 | 705), objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i26 = ((int[]) objArr[3])[0];
                int i27 = ((int[]) objArr[0])[0];
                int i28 = ((int[]) objArr[1])[0];
                String[] strArr4 = (String[]) objArr[2];
                int layoutDirection2 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().getLayoutDirection();
                int i29 = ~layoutDirection2;
                int i30 = i26 + (-2130083259) + (((~((-1048577) | layoutDirection2)) | (~(i29 | 52265609)) | (-197123790)) * 717) + (((~((-1048577) | i29)) | (-197123790) | (~(layoutDirection2 | 52265609))) * 717);
                int i31 = (i30 << 13) ^ i30;
                int i32 = i31 ^ (i31 >>> 17);
                ((int[]) objArr24[3])[0] = i32 ^ (i32 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame10 == null) {
            int iIndexOf3 = TextUtils.indexOf((CharSequence) "", '0') + 27;
            char defaultSize = (char) View.getDefaultSize(0, 0);
            int maxKeyCode = (KeyEvent.getMaxKeyCode() >> 16) + 1041;
            Object[] objArr25 = new Object[1];
            a((byte) ($$b & 480), (byte) 47, $$a[117], objArr25);
            objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iIndexOf3, defaultSize, maxKeyCode, 2061780482, false, (String) objArr25[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame10).getLong(null);
        if (j5 != -1) {
            long j6 = j5 + 4611686018427387875L;
            Object[] objArr26 = new Object[1];
            b((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), new char[]{31610, 31515, 39276, 32103, 44339, 26013, 30225, 56140, 60033, 60668, 16295, 18684, 22589, 40594, 36417, 42517, 53183, Typography.greater, 6255, 6047, 15687, 45978, 27371, 34049, 44285, 9550}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 35, new char[]{9564, 9529, 61238, 2879, 42677, 28190, 38385, 14510, 46267, 39594, 13348, 43872, 1553, 59610, 34176, 17874, 37257, 30330, 5117}, objArr27);
            if (j6 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame11 == null) {
                    int i33 = 27 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                    char cBlue = (char) Color.blue(0);
                    int windowTouchSlop = 1041 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                    Object[] objArr28 = new Object[1];
                    a((byte) ($$b & 476), (byte) 47, $$a[117], objArr28);
                    objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(i33, cBlue, windowTouchSlop, 1145017376, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame11).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i34 = ((int[]) objArr29[3])[0];
                int i35 = ((int[]) objArr29[2])[0];
                String[] strArr5 = (String[]) objArr29[0];
                int elapsedCpuTime = (int) Process.getElapsedCpuTime();
                int i36 = ~elapsedCpuTime;
                int i37 = ~(139712916 | i36);
                int i38 = ((((-1529257938) + (((-201317782) | i37) * (-712))) + (((~(elapsedCpuTime | (-61604866))) | (~(i36 | 201317781))) * (-712))) + ((61609109 | i37) * 712)) - 147328158;
                int i39 = (i38 << 13) ^ i38;
                int i40 = i39 ^ (i39 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i40 ^ (i40 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 34, new char[]{33172, 33278, 48124, 24568, 40456, 22196, 50184, 26950, 4142, 52841, 3211, 64165, 41691, 48223, 48405, 5158, 13659, 8873, 11095, 42382}, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 114, new char[]{44641, 44552, 37514, 30347, 48424, 30087, 18076, 60381, 16257, 59162, 12205, 30758, 36097, 38246, 40454, 38563, 6814, 3012, 2149, 10002}, objArr31);
                int iIntValue = ((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue();
                Object[] objArr32 = {1495442857};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(8 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) (22251 - Color.argb(0, 0, 0, 0)), 1033 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = QuantizerCelebi.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr32), -147328158, false);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame5 == null) {
                    int scrollDefaultDelay = 26 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                    char offsetAfter3 = (char) TextUtils.getOffsetAfter("", 0);
                    int deadChar = 1041 - KeyEvent.getDeadChar(0, 0);
                    Object[] objArr33 = new Object[1];
                    a((byte) ($$b & 476), (byte) 47, $$a[117], objArr33);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(scrollDefaultDelay, offsetAfter3, deadChar, 1145017376, false, (String) objArr33[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Object[] objArr34 = new Object[1];
                    b((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), new char[]{31610, 31515, 39276, 32103, 44339, 26013, 30225, 56140, 60033, 60668, 16295, 18684, 22589, 40594, 36417, 42517, 53183, Typography.greater, 6255, 6047, 15687, 45978, 27371, 34049, 44285, 9550}, objArr34);
                    Class<?> cls9 = Class.forName((String) objArr34[0]);
                    Object[] objArr35 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 35, new char[]{9564, 9529, 61238, 2879, 42677, 28190, 38385, 14510, 46267, 39594, 13348, 43872, 1553, 59610, 34176, 17874, 37257, 30330, 5117}, objArr35);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr35[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame6 == null) {
                        int iLastIndexOf2 = 25 - TextUtils.lastIndexOf("", '0', 0, 0);
                        char offsetBefore = (char) TextUtils.getOffsetBefore("", 0);
                        int iIndexOf4 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1042;
                        Object[] objArr36 = new Object[1];
                        a((byte) ($$b & 480), (byte) 47, $$a[117], objArr36);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iLastIndexOf2, offsetBefore, iIndexOf4, 2061780482, false, (String) objArr36[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr37 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 34, new char[]{33172, 33278, 48124, 24568, 40456, 22196, 50184, 26950, 4142, 52841, 3211, 64165, 41691, 48223, 48405, 5158, 13659, 8873, 11095, 42382}, objArr37);
            Class<?> cls10 = Class.forName((String) objArr37[0]);
            Object[] objArr38 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 114, new char[]{44641, 44552, 37514, 30347, 48424, 30087, 18076, 60381, 16257, 59162, 12205, 30758, 36097, 38246, 40454, 38563, 6814, 3012, 2149, 10002}, objArr38);
            int iIntValue2 = ((Integer) cls10.getMethod((String) objArr38[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr39 = {1495442857};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(8 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) (22251 - Color.argb(0, 0, 0, 0)), 1033 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = QuantizerCelebi.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr39), -147328158, false);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame5 == null) {
                int scrollDefaultDelay2 = 26 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                char offsetAfter4 = (char) TextUtils.getOffsetAfter("", 0);
                int deadChar2 = 1041 - KeyEvent.getDeadChar(0, 0);
                Object[] objArr310 = new Object[1];
                a((byte) ($$b & 476), (byte) 47, $$a[117], objArr310);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(scrollDefaultDelay2, offsetAfter4, deadChar2, 1145017376, false, (String) objArr310[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr311 = new Object[1];
            b((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), new char[]{31610, 31515, 39276, 32103, 44339, 26013, 30225, 56140, 60033, 60668, 16295, 18684, 22589, 40594, 36417, 42517, 53183, Typography.greater, 6255, 6047, 15687, 45978, 27371, 34049, 44285, 9550}, objArr311);
            Class<?> cls11 = Class.forName((String) objArr311[0]);
            Object[] objArr312 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 35, new char[]{9564, 9529, 61238, 2879, 42677, 28190, 38385, 14510, 46267, 39594, 13348, 43872, 1553, 59610, 34176, 17874, 37257, 30330, 5117}, objArr312);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr312[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame6 == null) {
                int iLastIndexOf3 = 25 - TextUtils.lastIndexOf("", '0', 0, 0);
                char offsetBefore2 = (char) TextUtils.getOffsetBefore("", 0);
                int iIndexOf5 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1042;
                Object[] objArr313 = new Object[1];
                a((byte) ($$b & 480), (byte) 47, $$a[117], objArr313);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iLastIndexOf3, offsetBefore2, iIndexOf5, 2061780482, false, (String) objArr313[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i41 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i42 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i42 == i41) {
            Object[] objArr40 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i43 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i44 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i45 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr6 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int layoutDirection3 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().getLayoutDirection();
            int i46 = i43 + ((((~(layoutDirection3 | 485494368)) | (-407390562)) * 56) - 31034058) + (((~((~layoutDirection3) | (-407390562))) | 485494368) * 56);
            int i47 = (i46 << 13) ^ i46;
            int i48 = i47 ^ (i47 >>> 17);
            ((int[]) objArr40[1])[0] = i48 ^ (i48 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        if (strArr7 != null) {
            int i49 = 0;
            while (i49 < strArr7.length) {
                arrayList2.add(strArr7[i49]);
                i49++;
                int i50 = getARTIFICIAL_FRAME_PACKAGE_NAME + 99;
                artificialFrame = i50 % 128;
                int i51 = i50 % 2;
            }
        }
        Object[] objArr41 = {Long.valueOf(((long) (i41 ^ i42)) ^ (((long) 1434328209) << 32)), Long.valueOf(1434328211)};
        byte[] bArr4 = $$d;
        Object[] objArr42 = new Object[1];
        c(bArr4[191], bArr4[737], (short) 703, objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        byte b4 = bArr4[28];
        Object[] objArr43 = new Object[1];
        c((byte) 83, b4, (short) (b4 | 705), objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {strArr, new int[1], new int[]{i}, new int[]{i}};
        int i52 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
        int i53 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        int i54 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        String[] strArr8 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        int i55 = ~((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().keyboard;
        int i56 = i52 + (-1408094610) + (((~(i55 | 502947829)) | (~((-16913653) | i55))) * (-184)) + ((282068992 | (~((-298982645) | i55)) | (~(220878837 | i55))) * SyslogConstants.LOG_LOCAL7) + 1125111440;
        int i57 = (i56 << 13) ^ i56;
        int i58 = i57 ^ (i57 >>> 17);
        ((int[]) objArr44[1])[0] = i58 ^ (i58 << 5);
    }

    /* JADX WARN: Code duplicated, block: B:242:0x19bd  */
    /* JADX WARN: Code duplicated, block: B:243:0x1a24  */
    /* JADX WARN: Code duplicated, block: B:248:0x1af6  */
    /* JADX WARN: Code duplicated, block: B:258:0x1c46  */
    /* JADX WARN: Code duplicated, block: B:261:0x1c87 A[Catch: all -> 0x2522, TryCatch #1 {all -> 0x2522, blocks: (B:259:0x1c64, B:261:0x1c87, B:262:0x1cdc, B:224:0x17fb, B:226:0x1801, B:227:0x182f, B:229:0x185a, B:230:0x18e5, B:125:0x0cf4, B:127:0x0d01, B:128:0x0d33, B:130:0x0d3d, B:132:0x0d4a, B:133:0x0d7e, B:15:0x01f4, B:17:0x0208, B:18:0x0235), top: B:374:0x01f4 }] */
    /* JADX WARN: Code duplicated, block: B:265:0x1cef  */
    /* JADX WARN: Code duplicated, block: B:270:0x1d5b  */
    /* JADX WARN: Code duplicated, block: B:274:0x1db3  */
    /* JADX WARN: Code duplicated, block: B:275:0x1e17  */
    /* JADX WARN: Code duplicated, block: B:277:0x1e23  */
    /* JADX WARN: Code duplicated, block: B:280:0x1e27 A[LOOP:1: B:278:0x1e24->B:280:0x1e27, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:286:0x1f1d  */
    /* JADX WARN: Code duplicated, block: B:289:0x1f6b  */
    /* JADX WARN: Code duplicated, block: B:291:0x1f89  */
    /* JADX WARN: Code duplicated, block: B:293:0x1f92  */
    /* JADX WARN: Code duplicated, block: B:295:0x2049  */
    /* JADX WARN: Code duplicated, block: B:298:0x2050  */
    /* JADX WARN: Code duplicated, block: B:300:0x20ce  */
    /* JADX WARN: Code duplicated, block: B:306:0x20de  */
    /* JADX WARN: Code duplicated, block: B:311:0x21e3  */
    /* JADX WARN: Code duplicated, block: B:313:0x21ef  */
    /* JADX WARN: Code duplicated, block: B:315:0x21f8  */
    /* JADX WARN: Code duplicated, block: B:320:0x225d  */
    /* JADX WARN: Code duplicated, block: B:321:0x228f  */
    /* JADX WARN: Code duplicated, block: B:323:0x2298  */
    /* JADX WARN: Code duplicated, block: B:328:0x2305  */
    /* JADX WARN: Code duplicated, block: B:336:0x235b  */
    /* JADX WARN: Code duplicated, block: B:337:0x23e4  */
    /* JADX WARN: Code duplicated, block: B:339:0x23f0  */
    /* JADX WARN: Code duplicated, block: B:342:0x23f4 A[LOOP:0: B:340:0x23f1->B:342:0x23f4, LOOP_END] */
    @Override // android.app.Service
    public void onCreate() throws Throwable {
        Object[] objArr;
        int i;
        Object[] objArr2;
        int i2;
        Object[] objArr3;
        int i3;
        Object[] objArr4;
        int i4;
        Object[] objArr5;
        int i5;
        int i6;
        Object[] objArr6;
        Object obj;
        int i7;
        Object obj2;
        int i8;
        int i9;
        Object objAccessartificialFrame;
        long j;
        Object objAccessartificialFrame2;
        Object[] objArr7;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        int i10;
        int i11;
        ArrayList arrayList;
        String[] strArr;
        int i12;
        int i13;
        Object objAccessartificialFrame5;
        long j2;
        int i14;
        Context baseContext;
        Object[] objArr8;
        int i15;
        int i16;
        Object objAccessartificialFrame6;
        Long lValueOf;
        Object objAccessartificialFrame7;
        int iResolveSizeAndState;
        char cIndexOf;
        int iAxisFromString;
        int i17;
        boolean z;
        Object obj3;
        Object objAccessartificialFrame8;
        int i18;
        int i19;
        ArrayList arrayList2;
        String[] strArr2;
        int i20;
        Object objAccessartificialFrame9;
        int i21 = 2 % 2;
        int i22 = artificialFrame + 123;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i22 % 128;
        int i23 = i22 % 2;
        Object[] objArr9 = new Object[1];
        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 34, new char[]{31610, 31515, 39276, 32103, 44339, 26013, 30225, 56140, 60033, 60668, 16295, 18684, 22589, 40594, 36417, 42517, 53183, Typography.greater, 6255, 6047, 15687, 45978, 27371, 34049, 44285, 9550}, objArr9);
        String str = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        b((ViewConfiguration.getDoubleTapTimeout() >> 16) + 1, new char[]{9564, 9529, 61238, 2879, 42677, 28190, 38385, 14510, 46267, 39594, 13348, 43872, 1553, 59610, 34176, 17874, 37257, 30330, 5117}, objArr10);
        String str2 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 3, new char[]{33172, 33278, 48124, 24568, 40456, 22196, 50184, 26950, 4142, 52841, 3211, 64165, 41691, 48223, 48405, 5158, 13659, 8873, 11095, 42382}, objArr11);
        String str3 = (String) objArr11[0];
        Object[] objArr12 = new Object[1];
        b(1 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), new char[]{44641, 44552, 37514, 30347, 48424, 30087, 18076, 60381, 16257, 59162, 12205, 30758, 36097, 38246, 40454, 38563, 6814, 3012, 2149, 10002}, objArr12);
        String str4 = (String) objArr12[0];
        Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame10 == null) {
            int touchSlop = 26 - (ViewConfiguration.getTouchSlop() >> 8);
            char cResolveOpacity = (char) Drawable.resolveOpacity(0, 0);
            int iKeyCodeFromString = 1041 - KeyEvent.keyCodeFromString("");
            Object[] objArr13 = new Object[1];
            a((byte) ($$b & 480), (byte) 47, $$a[117], objArr13);
            objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(touchSlop, cResolveOpacity, iKeyCodeFromString, 2061780482, false, (String) objArr13[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame10).getLong(null);
        if (j3 == -1 || j3 + 4611686018427387852L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            try {
                Object[] objArr14 = {1774369384};
                Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame11 == null) {
                    objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(Drawable.resolveOpacity(0, 0) + 8, (char) (22251 - (ViewConfiguration.getPressedStateDuration() >> 16)), View.resolveSizeAndState(0, 0, 0) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
                }
                Object[] objArrAccessartificialFrame$78cbbd35 = HmacPrfKey.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame11).newInstance(objArr14), -1064287395, false);
                Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame12 == null) {
                    int i24 = 27 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                    char cMakeMeasureSpec = (char) View.MeasureSpec.makeMeasureSpec(0, 0);
                    int iResolveSize = 1041 - View.resolveSize(0, 0);
                    Object[] objArr15 = new Object[1];
                    a((byte) ($$b & 476), (byte) 47, $$a[117], objArr15);
                    objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(i24, cMakeMeasureSpec, iResolveSize, 1145017376, false, (String) objArr15[0], null);
                }
                ((Field) objAccessartificialFrame12).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame13 == null) {
                        int maximumFlingVelocity = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 26;
                        char maximumDrawingCacheSize = (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                        int maximumFlingVelocity2 = 1041 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                        Object[] objArr16 = new Object[1];
                        a((byte) ($$b & 480), (byte) 47, $$a[117], objArr16);
                        objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity, maximumDrawingCacheSize, maximumFlingVelocity2, 2061780482, false, (String) objArr16[0], null);
                    }
                    ((Field) objAccessartificialFrame13).set(null, lValueOf2);
                    objArr = objArrAccessartificialFrame$78cbbd35;
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
        } else {
            Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame14 == null) {
                int maxKeyCode = (KeyEvent.getMaxKeyCode() >> 16) + 26;
                char c = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                int i25 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 1040;
                Object[] objArr17 = new Object[1];
                a((byte) ($$b & 476), (byte) 47, $$a[117], objArr17);
                objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(maxKeyCode, c, i25, 1145017376, false, (String) objArr17[0], null);
            }
            Object[] objArr18 = (Object[]) ((Field) objAccessartificialFrame14).get(null);
            objArr = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
            int i26 = ((int[]) objArr18[3])[0];
            int i27 = ((int[]) objArr18[2])[0];
            String[] strArr3 = (String[]) objArr18[0];
            int elapsedCpuTime = (int) Process.getElapsedCpuTime();
            int i28 = ~elapsedCpuTime;
            int i29 = (((((~(i28 | (-664786664))) | ((~((-742890471) | i28)) | 604476134)) * (-397)) + 1121320902) + ((elapsedCpuTime | (-198724866)) * 397)) - 1064287395;
            int i30 = (i29 << 13) ^ i29;
            int i31 = i30 ^ (i30 >>> 17);
            ((int[]) objArr[1])[0] = i31 ^ (i31 << 5);
        }
        int i32 = ((int[]) objArr[2])[0];
        int i33 = ((int[]) objArr[3])[0];
        if (i33 == i32) {
            Object[] objArr19 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i34 = ((int[]) objArr[1])[0];
            int i35 = ((int[]) objArr[3])[0];
            int i36 = ((int[]) objArr[2])[0];
            String[] strArr4 = (String[]) objArr[0];
            int i37 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 1976140319;
            int i38 = i34 + 1802124666 + ((~((~i37) | (-323289313))) * 433) + (((~(390437858 | i37)) | (-468541666)) * (-433)) + (((~(i37 | (-468541666))) | 67148546) * 433);
            int i39 = (i38 << 13) ^ i38;
            int i40 = i39 ^ (i39 >>> 17);
            ((int[]) objArr19[1])[0] = i40 ^ (i40 << 5);
            i = 0;
        } else {
            ArrayList arrayList3 = new ArrayList();
            String[] strArr5 = (String[]) objArr[0];
            if (strArr5 != null) {
                int i41 = 0;
                while (i41 < strArr5.length) {
                    int i42 = artificialFrame + 67;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i42 % 128;
                    if (i42 % 2 != 0) {
                        arrayList3.add(strArr5[i41]);
                        i41 += 34;
                    } else {
                        arrayList3.add(strArr5[i41]);
                        i41++;
                    }
                }
            }
            try {
                Object[] objArr20 = {Long.valueOf(((long) (i32 ^ i33)) ^ (((long) 1155305088) << 32)), Long.valueOf(1155305090)};
                byte[] bArr = $$d;
                Object[] objArr21 = new Object[1];
                c(bArr[368], (byte) (-bArr[51]), (short) 649, objArr21);
                Class<?> cls = Class.forName((String) objArr21[0]);
                byte b = bArr[28];
                Object[] objArr22 = new Object[1];
                c((byte) 83, b, (short) (b | 705), objArr22);
                cls.getMethod((String) objArr22[0], Long.TYPE, Long.TYPE).invoke(null, objArr20);
                Object[] objArr23 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i43 = ((int[]) objArr[1])[0];
                int i44 = ((int[]) objArr[3])[0];
                int i45 = ((int[]) objArr[2])[0];
                String[] strArr6 = (String[]) objArr[0];
                int i46 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().mcc;
                int i47 = i43 + ((((-1960015490) + (((~(926202420 | i46)) | 147342595) * 576)) + (((~((~i46) | 1073545015)) | 856963632) * 576)) - 1030011200);
                int i48 = (i47 << 13) ^ i47;
                int i49 = i48 ^ (i48 >>> 17);
                i = 0;
                ((int[]) objArr23[1])[0] = i49 ^ (i49 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame15 == null) {
            int defaultSize = View.getDefaultSize(i, i) + 30;
            char jumpTapTimeout = (char) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 49362);
            int trimmedLength = 684 - TextUtils.getTrimmedLength("");
            byte[] bArr2 = $$a;
            Object[] objArr24 = new Object[1];
            a((byte) 69, (byte) (bArr2[115] + 1), bArr2[4], objArr24);
            objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(defaultSize, jumpTapTimeout, trimmedLength, 752929587, false, (String) objArr24[0], null);
        }
        long j4 = ((Field) objAccessartificialFrame15).getLong(null);
        if (j4 == -1 || j4 + 1942 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext2 = getBaseContext();
            if (baseContext2 == null) {
                Object[] objArr25 = new Object[1];
                b(1 - (KeyEvent.getMaxKeyCode() >> 16), new char[]{19170, 19075, 30120, 37283, 1365, 52731, 19664, 57741, 56089, '8', 38849, 29245, 27051, 29269, 9849, 40105, 65055, 60650, 45065, 11602, 3268, 24436, 49813, 49110, 40274, 51593, 27943, 51622, 9211, 14353}, objArr25);
                Class<?> cls2 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(3) - 45, new char[]{42214, 42117, 17350, 42966, 20158, 34310, 491, 44214, 13591, 13905, 56364, 16233, 34750, 17467, 28056, 53717, 4153, 55942, 64500, 24681, 58073, 26909}, objArr26);
                baseContext2 = (Context) cls2.getMethod((String) objArr26[0], new Class[0]).invoke(null, null);
            }
            if (baseContext2 != null) {
                baseContext2 = (((baseContext2 instanceof ContextWrapper) ^ true) || ((ContextWrapper) baseContext2).getBaseContext() != null) ? baseContext2.getApplicationContext() : null;
            }
            int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            int i50 = artificialFrame + 77;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i50 % 128;
            int i51 = i50 % 2;
            try {
                Object[] objArr27 = {baseContext2, Integer.valueOf(iIntValue2), 0, 1411648264};
                byte[] bArr3 = $$d;
                Object[] objArr28 = new Object[1];
                c(bArr3[34], (byte) (-bArr3[51]), (short) TypedValues.MotionType.TYPE_PATHMOTION_ARC, objArr28);
                Class<?> cls3 = Class.forName((String) objArr28[0]);
                Object[] objArr29 = new Object[1];
                c((byte) (bArr3[613] + 1), (byte) (-bArr3[51]), (short) 564, objArr29);
                objArr2 = (Object[]) cls3.getMethod((String) objArr29[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr27);
                if (baseContext2 != null) {
                    Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-326560385);
                    if (objAccessartificialFrame16 == null) {
                        int packedPositionType = ExpandableListView.getPackedPositionType(0L) + 30;
                        char threadPriority = (char) (49362 - ((Process.getThreadPriority(0) + 20) >> 6));
                        int windowTouchSlop = 684 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                        byte b2 = (byte) 54;
                        Object[] objArr30 = new Object[1];
                        a(b2, (byte) (b2 & 239), $$a[4], objArr30);
                        objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(packedPositionType, threadPriority, windowTouchSlop, 1944867703, false, (String) objArr30[0], null);
                    }
                    ((Field) objAccessartificialFrame16).set(null, objArr2);
                    try {
                        Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                        if (objAccessartificialFrame17 == null) {
                            int i52 = 31 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                            char c2 = (char) (49363 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
                            int iLastIndexOf = TextUtils.lastIndexOf("", '0', 0, 0) + 685;
                            byte[] bArr4 = $$a;
                            Object[] objArr31 = new Object[1];
                            a((byte) 69, (byte) (bArr4[115] + 1), bArr4[4], objArr31);
                            objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(i52, c2, iLastIndexOf, 752929587, false, (String) objArr31[0], null);
                        }
                        ((Field) objAccessartificialFrame17).set(null, lValueOf3);
                    } catch (Exception unused2) {
                        throw new RuntimeException();
                    }
                }
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        } else {
            Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-326560385);
            if (objAccessartificialFrame18 == null) {
                int offsetAfter = 30 - TextUtils.getOffsetAfter("", 0);
                char c3 = (char) (49363 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
                int packedPositionChild = 683 - ExpandableListView.getPackedPositionChild(0L);
                byte b3 = (byte) 54;
                Object[] objArr32 = new Object[1];
                a(b3, (byte) (b3 & 239), $$a[4], objArr32);
                objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(offsetAfter, c3, packedPositionChild, 1944867703, false, (String) objArr32[0], null);
            }
            Object[] objArr33 = (Object[]) ((Field) objAccessartificialFrame18).get(null);
            objArr2 = new Object[]{new int[]{((int[]) objArr33[0])[0]}, new int[]{((int[]) objArr33[1])[0]}, new int[1], (String) objArr33[3]};
            int iIdentityHashCode = System.identityHashCode(this);
            int i53 = ((1669747082 + (((~iIdentityHashCode) | 17080608) * 1324)) + (((~(iIdentityHashCode | 957277024)) | (~(21346750 | iIdentityHashCode))) * (-1324))) - 419363556;
            int i54 = (i53 << 13) ^ i53;
            int i55 = i54 ^ (i54 >>> 17);
            ((int[]) objArr2[2])[0] = i55 ^ (i55 << 5);
        }
        int i56 = ((int[]) objArr2[1])[0];
        int i57 = ((int[]) objArr2[0])[0];
        if (i57 == i56) {
            int i58 = artificialFrame + 3;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i58 % 128;
            int i59 = i58 % 2;
            int i60 = ((int[]) objArr2[2])[0];
            Object[] objArr34 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i61 = i60 + 22664028 + ((~(491953054 | iIdentityHashCode2)) * (-301)) + (((~((-487723915) | iIdentityHashCode2)) | (~((~iIdentityHashCode2) | 490899860))) * (-301)) + (((~(iIdentityHashCode2 | (-490899861))) | (-487723915)) * 301);
            int i62 = (i61 << 13) ^ i61;
            int i63 = i62 ^ (i62 >>> 17);
            ((int[]) objArr34[2])[0] = i63 ^ (i63 << 5);
            i2 = 0;
        } else {
            Object[] objArr35 = {Long.valueOf(((long) (i56 ^ i57)) ^ (((long) (-1029556441)) << 32)), Long.valueOf(-1029556445)};
            byte[] bArr5 = $$d;
            Object[] objArr36 = new Object[1];
            c(bArr5[13], (byte) (-bArr5[51]), (short) 548, objArr36);
            Class<?> cls4 = Class.forName((String) objArr36[0]);
            byte b4 = bArr5[28];
            Object[] objArr37 = new Object[1];
            c((byte) 83, b4, (short) (b4 | 705), objArr37);
            cls4.getMethod((String) objArr37[0], Long.TYPE, Long.TYPE).invoke(null, objArr35);
            int i64 = ((int[]) objArr2[2])[0];
            Object[] objArr38 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int i65 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().smallestScreenWidthDp;
            int i66 = ~i65;
            int i67 = i64 + (-958088776) + (((~((-180053447) | i66)) | (~((-798570329) | i66))) * (-867)) + (((~((-798570329) | i65)) | 177808704 | (~((-180053447) | i65))) * (-1734)) + (((~(i65 | (-2244743))) | (~((-177808705) | i66)) | (~((-620761625) | i65))) * 867);
            int i68 = (i67 << 13) ^ i67;
            int i69 = i68 ^ (i68 >>> 17);
            i2 = 0;
            ((int[]) objArr38[2])[0] = i69 ^ (i69 << 5);
        }
        Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame19 == null) {
            int offsetAfter2 = 17 - TextUtils.getOffsetAfter("", i2);
            char c4 = (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1);
            int i70 = 746 - (ExpandableListView.getPackedPositionForChild(i2, i2) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(i2, i2) == 0L ? 0 : -1));
            Object[] objArr39 = new Object[1];
            a((byte) ($$b & 480), (byte) 47, $$a[117], objArr39);
            objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(offsetAfter2, c4, i70, -144068856, false, (String) objArr39[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame19).getLong(null);
        if (j5 == -1 || j5 + 4611686018427387946L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext3 = getBaseContext();
            if (baseContext3 == null) {
                Object[] objArr40 = new Object[1];
                b(-Process.getGidForName(""), new char[]{19170, 19075, 30120, 37283, 1365, 52731, 19664, 57741, 56089, '8', 38849, 29245, 27051, 29269, 9849, 40105, 65055, 60650, 45065, 11602, 3268, 24436, 49813, 49110, 40274, 51593, 27943, 51622, 9211, 14353}, objArr40);
                Class<?> cls5 = Class.forName((String) objArr40[0]);
                Object[] objArr41 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 20, new char[]{42214, 42117, 17350, 42966, 20158, 34310, 491, 44214, 13591, 13905, 56364, 16233, 34750, 17467, 28056, 53717, 4153, 55942, 64500, 24681, 58073, 26909}, objArr41);
                baseContext3 = (Context) cls5.getMethod((String) objArr41[0], new Class[0]).invoke(null, null);
            }
            if (baseContext3 != null) {
                int i71 = artificialFrame + 89;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i71 % 128;
                int i72 = i71 % 2;
                baseContext3 = ((baseContext3 instanceof ContextWrapper) && ((ContextWrapper) baseContext3).getBaseContext() == null) ? null : baseContext3.getApplicationContext();
            }
            Object[] objArr42 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 855285740};
            byte[] bArr6 = $$d;
            Object[] objArr43 = new Object[1];
            c((byte) (-bArr6[32]), (byte) (-bArr6[51]), (short) SyslogConstants.SYSLOG_PORT, objArr43);
            Class<?> cls6 = Class.forName((String) objArr43[0]);
            Object[] objArr44 = new Object[1];
            c(bArr6[250], bArr6[191], (short) 469, objArr44);
            objArr3 = (Object[]) cls6.getMethod((String) objArr44[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr42);
            Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame20 == null) {
                int trimmedLength2 = TextUtils.getTrimmedLength("") + 17;
                char offsetAfter3 = (char) TextUtils.getOffsetAfter("", 0);
                int scrollBarFadeDuration = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 747;
                Object[] objArr45 = new Object[1];
                a((byte) ($$b & 476), (byte) 47, $$a[117], objArr45);
                objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(trimmedLength2, offsetAfter3, scrollBarFadeDuration, -1031537386, false, (String) objArr45[0], null);
            }
            ((Field) objAccessartificialFrame20).set(null, objArr3);
            try {
                Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame21 == null) {
                    int iLastIndexOf2 = TextUtils.lastIndexOf("", '0') + 18;
                    char maximumFlingVelocity3 = (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                    int iRed = 747 - Color.red(0);
                    Object[] objArr46 = new Object[1];
                    a((byte) ($$b & 480), (byte) 47, $$a[117], objArr46);
                    objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(iLastIndexOf2, maximumFlingVelocity3, iRed, -144068856, false, (String) objArr46[0], null);
                }
                ((Field) objAccessartificialFrame21).set(null, lValueOf4);
            } catch (Exception unused3) {
                throw new RuntimeException();
            }
        } else {
            int i73 = getARTIFICIAL_FRAME_PACKAGE_NAME + 93;
            artificialFrame = i73 % 128;
            int i74 = i73 % 2;
            Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame22 == null) {
                int iGreen = Color.green(0) + 17;
                char c5 = (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1);
                int deadChar = KeyEvent.getDeadChar(0, 0) + 747;
                Object[] objArr47 = new Object[1];
                a((byte) ($$b & 476), (byte) 47, $$a[117], objArr47);
                objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(iGreen, c5, deadChar, -1031537386, false, (String) objArr47[0], null);
            }
            Object[] objArr48 = (Object[]) ((Field) objAccessartificialFrame22).get(null);
            objArr3 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
            int i75 = ((int[]) objArr48[3])[0];
            int i76 = ((int[]) objArr48[4])[0];
            List list = (List) objArr48[0];
            List list2 = (List) objArr48[2];
            int iIdentityHashCode3 = System.identityHashCode(this);
            int i77 = ~iIdentityHashCode3;
            int i78 = (-783354267) + (((~((-687558087) | i77)) | (-82109629)) * (-602)) + (((~(iIdentityHashCode3 | (-687558087))) | 672860482 | (~((-67412025) | i77))) * (-301)) + ((~(i77 | (-82109629))) * 301) + 855285740;
            int i79 = i78 ^ (i78 << 13);
            int i80 = i79 ^ (i79 >>> 17);
            ((int[]) objArr3[1])[0] = i80 ^ (i80 << 5);
        }
        int i81 = ((int[]) objArr3[4])[0];
        int i82 = ((int[]) objArr3[3])[0];
        if (i82 == i81) {
            Object[] objArr49 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i83 = ((int[]) objArr3[1])[0];
            int i84 = ((int[]) objArr3[3])[0];
            int i85 = ((int[]) objArr3[4])[0];
            List list3 = (List) objArr3[0];
            List list4 = (List) objArr3[2];
            int i86 = ~((int) Process.getElapsedCpuTime());
            int i87 = i83 + (-364922453) + (((-314905781) | i86) * 494) + (((~(i86 | (-382670005))) | 740976906) * 494);
            int i88 = (i87 << 13) ^ i87;
            int i89 = i88 ^ (i88 >>> 17);
            ((int[]) objArr49[1])[0] = i89 ^ (i89 << 5);
            i3 = 0;
        } else {
            ArrayList arrayList4 = new ArrayList();
            Object[] objArr50 = {objArr3};
            Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1804664566);
            if (objAccessartificialFrame23 == null) {
                objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(TextUtils.getOffsetBefore("", 0) + 41, (char) (12468 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 3642, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
            }
            arrayList4.add(((Method) objAccessartificialFrame23).invoke(null, objArr50));
            Object[] objArr51 = {objArr3};
            Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-1243809191);
            if (objAccessartificialFrame24 == null) {
                objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(41 - (Process.myPid() >> 22), (char) (12468 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))), TextUtils.indexOf("", "", 0) + 3642, 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
            }
            arrayList4.add(((Method) objAccessartificialFrame24).invoke(null, objArr51));
            long j6 = ((long) (i81 ^ i82)) ^ (((long) 1684753655) << 32);
            long j7 = 1684753663;
            int i90 = artificialFrame + 23;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i90 % 128;
            int i91 = i90 % 2;
            Object[] objArr52 = {Long.valueOf(j6), Long.valueOf(j7)};
            byte[] bArr7 = $$d;
            Object[] objArr53 = new Object[1];
            c(bArr7[85], (byte) (-bArr7[51]), (short) 450, objArr53);
            Class<?> cls7 = Class.forName((String) objArr53[0]);
            byte b5 = bArr7[28];
            Object[] objArr54 = new Object[1];
            c((byte) 83, b5, (short) (b5 | 705), objArr54);
            cls7.getMethod((String) objArr54[0], Long.TYPE, Long.TYPE).invoke(null, objArr52);
            Object[] objArr55 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i92 = ((int[]) objArr3[1])[0];
            int i93 = ((int[]) objArr3[3])[0];
            int i94 = ((int[]) objArr3[4])[0];
            List list5 = (List) objArr3[0];
            List list6 = (List) objArr3[2];
            int iMyPid = Process.myPid();
            int i95 = ~iMyPid;
            int i96 = i92 + ((((~((-59381622) | i95)) | (~(iMyPid | 546066836))) * 959) - 814864663) + (((~(iMyPid | (-59381622))) | (~(i95 | 546066836))) * 959);
            int i97 = (i96 << 13) ^ i96;
            int i98 = i97 ^ (i97 >>> 17);
            i3 = 0;
            ((int[]) objArr55[1])[0] = i98 ^ (i98 << 5);
        }
        Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame25 == null) {
            int absoluteGravity = 30 - Gravity.getAbsoluteGravity(i3, i3);
            char windowTouchSlop2 = (char) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 49362);
            int doubleTapTimeout = 684 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
            byte[] bArr8 = $$a;
            byte b6 = bArr8[15];
            Object[] objArr56 = new Object[1];
            a(b6, (byte) (b6 - 1), bArr8[113], objArr56);
            objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(absoluteGravity, windowTouchSlop2, doubleTapTimeout, -1583976536, false, (String) objArr56[0], null);
        }
        long j8 = ((Field) objAccessartificialFrame25).getLong(null);
        if (j8 == -1 || j8 + 1929 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr57 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -527583040};
            byte[] bArr9 = $$d;
            Object[] objArr58 = new Object[1];
            c(bArr9[28], (byte) (-bArr9[51]), (short) 378, objArr58);
            Class<?> cls8 = Class.forName((String) objArr58[0]);
            Object[] objArr59 = new Object[1];
            c((byte) (bArr9[613] + 1), (byte) (-bArr9[51]), (short) 293, objArr59);
            objArr4 = (Object[]) cls8.getMethod((String) objArr59[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr57);
            Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame26 == null) {
                int iRgb = Color.rgb(0, 0, 0) + 16777246;
                char mode = (char) (49362 - View.MeasureSpec.getMode(0));
                int iIndexOf = TextUtils.indexOf((CharSequence) "", '0', 0) + 685;
                byte[] bArr10 = $$a;
                Object[] objArr60 = new Object[1];
                a(bArr10[20], (byte) ($$b & 172), bArr10[117], objArr60);
                objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(iRgb, mode, iIndexOf, -1456483158, false, (String) objArr60[0], null);
            }
            ((Field) objAccessartificialFrame26).set(null, objArr4);
            try {
                Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame27 == null) {
                    int iArgb = 30 - Color.argb(0, 0, 0, 0);
                    char cKeyCodeFromString = (char) (KeyEvent.keyCodeFromString("") + 49362);
                    int iResolveSizeAndState2 = 684 - View.resolveSizeAndState(0, 0, 0);
                    byte[] bArr11 = $$a;
                    byte b7 = bArr11[15];
                    Object[] objArr61 = new Object[1];
                    a(b7, (byte) (b7 - 1), bArr11[113], objArr61);
                    objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(iArgb, cKeyCodeFromString, iResolveSizeAndState2, -1583976536, false, (String) objArr61[0], null);
                }
                ((Field) objAccessartificialFrame27).set(null, lValueOf5);
            } catch (Exception unused4) {
                throw new RuntimeException();
            }
        } else {
            int i99 = getARTIFICIAL_FRAME_PACKAGE_NAME + 105;
            artificialFrame = i99 % 128;
            int i100 = i99 % 2;
            Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame28 == null) {
                int i101 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 29;
                char deadChar2 = (char) (KeyEvent.getDeadChar(0, 0) + 49362);
                int iResolveSize2 = View.resolveSize(0, 0) + 684;
                byte[] bArr12 = $$a;
                Object[] objArr62 = new Object[1];
                a(bArr12[20], (byte) ($$b & 172), bArr12[117], objArr62);
                objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(i101, deadChar2, iResolveSize2, -1456483158, false, (String) objArr62[0], null);
            }
            Object[] objArr63 = (Object[]) ((Field) objAccessartificialFrame28).get(null);
            objArr4 = new Object[]{new int[]{((int[]) objArr63[0])[0]}, new int[]{((int[]) objArr63[1])[0]}, new int[1], (String) objArr63[3]};
            int iIdentityHashCode4 = System.identityHashCode(this);
            int i102 = ~iIdentityHashCode4;
            int i103 = (((890480512 + ((((~((-43565121) | i102)) | (~((-622926873) | iIdentityHashCode4))) | (~((-268566663) | iIdentityHashCode4))) * 765)) + (((~((-666491993) | i102)) | 43565120) * 1530)) + (((~(iIdentityHashCode4 | (-666491993))) | (~(i102 | (-268566663)))) * 765)) - 527583040;
            int i104 = (i103 << 13) ^ i103;
            int i105 = i104 ^ (i104 >>> 17);
            ((int[]) objArr4[2])[0] = i105 ^ (i105 << 5);
        }
        int i106 = ((int[]) objArr4[1])[0];
        int i107 = ((int[]) objArr4[0])[0];
        if (i107 == i106) {
            int i108 = artificialFrame + 85;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i108 % 128;
            int i109 = i108 % 2;
            int i110 = ((int[]) objArr4[2])[0];
            Object[] objArr64 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
            int iUptimeMillis = (int) SystemClock.uptimeMillis();
            int i111 = i110 + (-1639129168) + (((~((-685966581) | iUptimeMillis)) | 6357024) * 345) + (((~((-685966581) | (~iUptimeMillis))) | 286300170) * 345) + ((~(iUptimeMillis | (-6357025))) * 345);
            int i112 = (i111 << 13) ^ i111;
            int i113 = i112 ^ (i112 >>> 17);
            ((int[]) objArr64[2])[0] = i113 ^ (i113 << 5);
            i4 = 0;
        } else {
            new ArrayList().add((String) objArr4[3]);
            Object[] objArr65 = {Long.valueOf(((long) (i106 ^ i107)) ^ (((long) (-2059086297)) << 32)), Long.valueOf(-2059086281)};
            byte[] bArr13 = $$d;
            Object[] objArr66 = new Object[1];
            c(bArr13[20], (byte) (-bArr13[51]), (short) 277, objArr66);
            Class<?> cls9 = Class.forName((String) objArr66[0]);
            byte b8 = bArr13[28];
            Object[] objArr67 = new Object[1];
            c((byte) 83, b8, (short) (b8 | 705), objArr67);
            cls9.getMethod((String) objArr67[0], Long.TYPE, Long.TYPE).invoke(null, objArr65);
            int i114 = ((int[]) objArr4[2])[0];
            Object[] objArr68 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
            int iMyUid = Process.myUid();
            int i115 = i114 + 1465633430 + ((~((-71338505) | iMyUid)) * 623) + (((~iMyUid) | 554700816) * (-623)) + (((~(iMyUid | 730993043)) | (~((-247630732) | iMyUid)) | 71338504) * 623);
            int i116 = (i115 << 13) ^ i115;
            int i117 = i116 ^ (i116 >>> 17);
            i4 = 0;
            ((int[]) objArr68[2])[0] = i117 ^ (i117 << 5);
        }
        Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame29 == null) {
            int iIndexOf2 = TextUtils.indexOf((CharSequence) "", '0') + 31;
            char c6 = (char) ((CdmaCellLocation.convertQuartSecToDecDegrees(i4) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(i4) == 0.0d ? 0 : -1)) + 49362);
            int threadPriority2 = 684 - ((Process.getThreadPriority(i4) + 20) >> 6);
            byte[] bArr14 = $$a;
            Object[] objArr69 = new Object[1];
            a(bArr14[37], (byte) (bArr14[115] + 1), bArr14[113], objArr69);
            objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(iIndexOf2, c6, threadPriority2, 508509282, false, (String) objArr69[0], null);
        }
        long j9 = ((Field) objAccessartificialFrame29).getLong(null);
        if (j9 == -1 || j9 + 1961 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext4 = getBaseContext();
            if (baseContext4 == null) {
                Object[] objArr70 = new Object[1];
                b((KeyEvent.getMaxKeyCode() >> 16) + 1, new char[]{19170, 19075, 30120, 37283, 1365, 52731, 19664, 57741, 56089, '8', 38849, 29245, 27051, 29269, 9849, 40105, 65055, 60650, 45065, 11602, 3268, 24436, 49813, 49110, 40274, 51593, 27943, 51622, 9211, 14353}, objArr70);
                Class<?> cls10 = Class.forName((String) objArr70[0]);
                Object[] objArr71 = new Object[1];
                b(1 - (ViewConfiguration.getKeyRepeatDelay() >> 16), new char[]{42214, 42117, 17350, 42966, 20158, 34310, 491, 44214, 13591, 13905, 56364, 16233, 34750, 17467, 28056, 53717, 4153, 55942, 64500, 24681, 58073, 26909}, objArr71);
                baseContext4 = (Context) cls10.getMethod((String) objArr71[0], new Class[0]).invoke(null, null);
            }
            if (baseContext4 != null) {
                baseContext4 = ((baseContext4 instanceof ContextWrapper) && ((ContextWrapper) baseContext4).getBaseContext() == null) ? null : baseContext4.getApplicationContext();
            }
            Object[] objArr72 = {baseContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 1387287835};
            byte[] bArr15 = $$d;
            Object[] objArr73 = new Object[1];
            c(bArr15[133], (byte) (-bArr15[51]), (short) ($$e | 49), objArr73);
            Class<?> cls11 = Class.forName((String) objArr73[0]);
            Object[] objArr74 = new Object[1];
            c(bArr15[103], bArr15[20], (short) 194, objArr74);
            objArr5 = (Object[]) cls11.getMethod((String) objArr74[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr72);
            if (baseContext4 != null) {
                Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame30 == null) {
                    int fadingEdgeLength = 30 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                    char touchSlop2 = (char) (49362 - (ViewConfiguration.getTouchSlop() >> 8));
                    int jumpTapTimeout2 = (ViewConfiguration.getJumpTapTimeout() >> 16) + 684;
                    byte[] bArr16 = $$a;
                    Object[] objArr75 = new Object[1];
                    a((byte) (-bArr16[11]), bArr16[15], bArr16[30], objArr75);
                    objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength, touchSlop2, jumpTapTimeout2, -1321816393, false, (String) objArr75[0], null);
                }
                ((Field) objAccessartificialFrame30).set(null, objArr5);
                try {
                    Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                    if (objAccessartificialFrame31 == null) {
                        int jumpTapTimeout3 = 30 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                        char scrollBarSize = (char) (49362 - (ViewConfiguration.getScrollBarSize() >> 8));
                        int iAxisFromString2 = 683 - MotionEvent.axisFromString("");
                        byte[] bArr17 = $$a;
                        Object[] objArr76 = new Object[1];
                        a(bArr17[37], (byte) (bArr17[115] + 1), bArr17[113], objArr76);
                        objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout3, scrollBarSize, iAxisFromString2, 508509282, false, (String) objArr76[0], null);
                    }
                    ((Field) objAccessartificialFrame31).set(null, lValueOf6);
                } catch (Exception unused5) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(777251007);
            if (objAccessartificialFrame32 == null) {
                int i118 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 29;
                char doubleTapTimeout2 = (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 49362);
                int iArgb2 = Color.argb(0, 0, 0, 0) + 684;
                byte[] bArr18 = $$a;
                Object[] objArr77 = new Object[1];
                a((byte) (-bArr18[11]), bArr18[15], bArr18[30], objArr77);
                objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(i118, doubleTapTimeout2, iArgb2, -1321816393, false, (String) objArr77[0], null);
            }
            Object[] objArr78 = (Object[]) ((Field) objAccessartificialFrame32).get(null);
            objArr5 = new Object[]{new int[]{((int[]) objArr78[0])[0]}, new int[]{((int[]) objArr78[1])[0]}, new int[1], (String) objArr78[3]};
            int iIdentityHashCode5 = System.identityHashCode(this);
            int i119 = ((((~(iIdentityHashCode5 | 864815634)) | 113808140) * 56) - 1399575210) + (((~((~iIdentityHashCode5) | 113808140)) | 864815634) * 56) + 1387287835;
            int i120 = (i119 << 13) ^ i119;
            int i121 = i120 ^ (i120 >>> 17);
            ((int[]) objArr5[2])[0] = i121 ^ (i121 << 5);
        }
        int i122 = ((int[]) objArr5[1])[0];
        int i123 = ((int[]) objArr5[0])[0];
        if (i123 == i122) {
            int i124 = ((int[]) objArr5[2])[0];
            Object[] objArr79 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int i125 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().mcc;
            int i126 = i124 + (((~((-268453061) | i125)) | 698357786) * 449) + 642217510 + (((~((~i125) | (-268453061))) | 698357786) * 449);
            int i127 = (i126 << 13) ^ i126;
            int i128 = i127 ^ (i127 >>> 17);
            i5 = 0;
            ((int[]) objArr79[2])[0] = i128 ^ (i128 << 5);
        } else {
            Object[] objArr80 = {Long.valueOf(((long) (i122 ^ i123)) ^ (((long) (-2067382072)) << 32)), Long.valueOf(-2067381560)};
            byte[] bArr19 = $$d;
            Object[] objArr81 = new Object[1];
            c(bArr19[362], (byte) (-bArr19[51]), (short) 174, objArr81);
            Class<?> cls12 = Class.forName((String) objArr81[0]);
            byte b9 = bArr19[28];
            Object[] objArr82 = new Object[1];
            c((byte) 83, b9, (short) (b9 | 705), objArr82);
            cls12.getMethod((String) objArr82[0], Long.TYPE, Long.TYPE).invoke(null, objArr80);
            int i129 = ((int[]) objArr5[2])[0];
            Object[] objArr83 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
            int i130 = 1231926046 + ((~(iElapsedRealtime | 738449583)) * JfifUtil.MARKER_SOI);
            int i131 = ~iElapsedRealtime;
            int i132 = i129 + i130 + (((-38798401) | i131) * (-216)) + (((~(i131 | 738449583)) | 240174191) * JfifUtil.MARKER_SOI);
            int i133 = (i132 << 13) ^ i132;
            int i134 = i133 ^ (i133 >>> 17);
            i5 = 0;
            ((int[]) objArr83[2])[0] = i134 ^ (i134 << 5);
        }
        Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame33 == null) {
            int iRgb2 = (-16777180) - Color.rgb(i5, i5, i5);
            char cIndexOf2 = (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0'));
            int defaultSize2 = View.getDefaultSize(i5, i5) + 540;
            Object[] objArr84 = new Object[1];
            a((byte) ($$b & 480), (byte) 47, $$a[117], objArr84);
            objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(iRgb2, cIndexOf2, defaultSize2, 624296913, false, (String) objArr84[0], null);
        }
        long j10 = ((Field) objAccessartificialFrame33).getLong(null);
        try {
            if (j10 != -1) {
                if (j10 + 1860 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                    if (objAccessartificialFrame34 == null) {
                        int i135 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 36;
                        char cNormalizeMetaState = (char) KeyEvent.normalizeMetaState(0);
                        int i136 = 540 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                        Object[] objArr85 = new Object[1];
                        a((byte) ($$b & 476), (byte) 47, $$a[117], objArr85);
                        objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(i135, cNormalizeMetaState, i136, 793268735, false, (String) objArr85[0], null);
                    }
                    Object[] objArr86 = (Object[]) ((Field) objAccessartificialFrame34).get(null);
                    objArr6 = new Object[]{new int[1], new int[1], new int[1]};
                    int i137 = ((int[]) objArr86[2])[0];
                    int i138 = ((int[]) objArr86[1])[0];
                    ((int[]) objArr6[2])[0] = i137;
                    ((int[]) objArr6[1])[0] = i138;
                    int iIdentityHashCode6 = System.identityHashCode(this);
                    int i139 = (((834414088 + ((~((-1258558245) | iIdentityHashCode6)) * 623)) + (((~iIdentityHashCode6) | 71958593) * (-623))) + (((~(iIdentityHashCode6 | 82511049)) | ((~((-1269110701) | iIdentityHashCode6)) | 1258558244)) * 623)) - 1763289887;
                    int i140 = (i139 << 13) ^ i139;
                    int i141 = i140 ^ (i140 >>> 17);
                    ((int[]) objArr6[0])[0] = i141 ^ (i141 << 5);
                } else {
                    i6 = 0;
                }
                obj = objArr6[1];
                i7 = ((int[]) obj)[0];
                obj2 = objArr6[2];
                i8 = ((int[]) obj2)[0];
                if (i8 == i7) {
                    Object[] objArr87 = {new int[1], new int[1], new int[1]};
                    int i142 = ((int[]) objArr6[0])[0];
                    int i143 = ((int[]) obj2)[0];
                    int i144 = ((int[]) obj)[0];
                    ((int[]) objArr87[2])[0] = i143;
                    ((int[]) objArr87[1])[0] = i144;
                    int i145 = ~System.identityHashCode(this);
                    int i146 = i142 + (-1909421495) + ((~(1342176191 | i145)) * 52) + (((~(211593910 | i145)) | (~((-1140027840) | i145)) | 1130582281) * (-52)) + (((~(i145 | (-211593911))) | 202148352) * 52);
                    int i147 = (i146 << 13) ^ i146;
                    int i148 = i147 ^ (i147 >>> 17);
                    i9 = 0;
                    ((int[]) objArr87[0])[0] = i148 ^ (i148 << 5);
                } else {
                    Object[] objArr88 = {Long.valueOf(((long) (i7 ^ i8)) ^ (((long) 606969568) << 32)), Long.valueOf(606965472)};
                    byte[] bArr20 = $$d;
                    Object[] objArr89 = new Object[1];
                    c(bArr20[13], (byte) (-bArr20[51]), (short) 548, objArr89);
                    Class<?> cls13 = Class.forName((String) objArr89[0]);
                    byte b10 = bArr20[28];
                    Object[] objArr90 = new Object[1];
                    c((byte) 83, b10, (short) (b10 | 705), objArr90);
                    cls13.getMethod((String) objArr90[0], Long.TYPE, Long.TYPE).invoke(null, objArr88);
                    Object[] objArr91 = {new int[1], new int[1], new int[1]};
                    int i149 = ((int[]) objArr6[0])[0];
                    int i150 = ((int[]) objArr6[2])[0];
                    int i151 = ((int[]) objArr6[1])[0];
                    ((int[]) objArr91[2])[0] = i150;
                    ((int[]) objArr91[1])[0] = i151;
                    int iMyPid2 = Process.myPid();
                    int i152 = i149 + ((((-176256865) + (((~((~iMyPid2) | (-350515623))) | 278929542) * 446)) + (((~(iMyPid2 | (-71586081))) | 722176585) * 446)) - 151475852);
                    int i153 = (i152 << 13) ^ i152;
                    int i154 = i153 ^ (i153 >>> 17);
                    i9 = 0;
                    ((int[]) objArr91[0])[0] = i154 ^ (i154 << 5);
                }
                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame == null) {
                    int capsMode = 25 - TextUtils.getCapsMode("", i9, i9);
                    char offsetBefore = (char) (TextUtils.getOffsetBefore("", i9) + 30068);
                    int absoluteGravity2 = 816 - Gravity.getAbsoluteGravity(i9, i9);
                    Object[] objArr92 = new Object[1];
                    a((byte) ($$b & 480), (byte) 47, $$a[117], objArr92);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(capsMode, offsetBefore, absoluteGravity2, 721586079, false, (String) objArr92[0], null);
                }
                j = ((Field) objAccessartificialFrame).getLong(null);
                if (j != -1 || j + 1932 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    Object[] objArr93 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -1139360697};
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame2 == null) {
                        int iLastIndexOf3 = 24 - TextUtils.lastIndexOf("", '0', 0);
                        char packedPositionChild2 = (char) (30067 - ExpandableListView.getPackedPositionChild(0L));
                        int doubleTapTimeout3 = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 816;
                        byte b11 = (byte) ($$b & 468);
                        byte[] bArr21 = $$a;
                        Object[] objArr94 = new Object[1];
                        a(b11, bArr21[37], bArr21[1], objArr94);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iLastIndexOf3, packedPositionChild2, doubleTapTimeout3, -797394565, false, (String) objArr94[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr7 = (Object[]) ((Method) objAccessartificialFrame2).invoke(null, objArr93);
                    objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame3 == null) {
                        int packedPositionType2 = 25 - ExpandableListView.getPackedPositionType(0L);
                        char cAxisFromString = (char) (30067 - MotionEvent.axisFromString(""));
                        int iIndexOf3 = TextUtils.indexOf((CharSequence) "", '0') + 817;
                        Object[] objArr95 = new Object[1];
                        a((byte) ($$b & 476), (byte) 47, $$a[117], objArr95);
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(packedPositionType2, cAxisFromString, iIndexOf3, 891606461, false, (String) objArr95[0], null);
                    }
                    ((Field) objAccessartificialFrame3).set(null, objArr7);
                    try {
                        Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame4 == null) {
                            int touchSlop3 = (ViewConfiguration.getTouchSlop() >> 8) + 25;
                            char defaultSize3 = (char) (View.getDefaultSize(0, 0) + 30068);
                            int iIndexOf4 = 816 - TextUtils.indexOf("", "", 0, 0);
                            Object[] objArr96 = new Object[1];
                            a((byte) ($$b & 480), (byte) 47, $$a[117], objArr96);
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(touchSlop3, defaultSize3, iIndexOf4, 721586079, false, (String) objArr96[0], null);
                        }
                        ((Field) objAccessartificialFrame4).set(null, lValueOf7);
                    } catch (Exception unused6) {
                        throw new RuntimeException();
                    }
                } else {
                    Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame35 == null) {
                        int i155 = 26 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                        char c7 = (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 30067);
                        int maximumFlingVelocity4 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 816;
                        Object[] objArr97 = new Object[1];
                        a((byte) ($$b & 476), (byte) 47, $$a[117], objArr97);
                        objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(i155, c7, maximumFlingVelocity4, 891606461, false, (String) objArr97[0], null);
                    }
                    Object[] objArr98 = (Object[]) ((Field) objAccessartificialFrame35).get(null);
                    objArr7 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                    int i156 = ((int[]) objArr98[0])[0];
                    int i157 = ((int[]) objArr98[1])[0];
                    String[] strArr7 = (String[]) objArr98[2];
                    int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 1094078869;
                    int i158 = ~iCodePointAt;
                    int i159 = (((-568387341) + (((~((-990185353) | i158)) | (~(iCodePointAt | (-792012987)))) * 333)) + (((~(iCodePointAt | (-990185353))) | (~(i158 | (-792012987)))) * 333)) - 1139360697;
                    int i160 = (i159 << 13) ^ i159;
                    int i161 = i160 ^ (i160 >>> 17);
                    ((int[]) objArr7[3])[0] = i161 ^ (i161 << 5);
                }
                i10 = ((int[]) objArr7[1])[0];
                i11 = ((int[]) objArr7[0])[0];
                if (i11 == i10) {
                    Object[] objArr99 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                    int i162 = ((int[]) objArr7[3])[0];
                    int i163 = ((int[]) objArr7[0])[0];
                    int i164 = ((int[]) objArr7[1])[0];
                    String[] strArr8 = (String[]) objArr7[2];
                    int i165 = ~System.identityHashCode(this);
                    int i166 = i162 + (((1076133337 + (((~((-70273077) | i165)) | 268445442) * (-828))) + ((i165 | (-70273077)) * (-828))) - 1943435216);
                    int i167 = (i166 << 13) ^ i166;
                    int i168 = i167 ^ (i167 >>> 17);
                    i12 = 0;
                    ((int[]) objArr99[3])[0] = i168 ^ (i168 << 5);
                } else {
                    arrayList = new ArrayList();
                    strArr = (String[]) objArr7[2];
                    if (strArr != null) {
                        for (String str5 : strArr) {
                            arrayList.add(str5);
                        }
                    }
                    Object[] objArr100 = {Long.valueOf(((long) (i10 ^ i11)) ^ (((long) 114022906) << 32)), Long.valueOf(114022907)};
                    byte[] bArr22 = $$d;
                    Object[] objArr101 = new Object[1];
                    c(bArr22[353], (byte) (-bArr22[51]), (short) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, objArr101);
                    Class<?> cls14 = Class.forName((String) objArr101[0]);
                    byte b12 = bArr22[28];
                    Object[] objArr102 = new Object[1];
                    c((byte) 83, b12, (short) (b12 | 705), objArr102);
                    cls14.getMethod((String) objArr102[0], Long.TYPE, Long.TYPE).invoke(null, objArr100);
                    Object[] objArr103 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                    int i169 = ((int[]) objArr7[3])[0];
                    int i170 = ((int[]) objArr7[0])[0];
                    int i171 = ((int[]) objArr7[1])[0];
                    String[] strArr9 = (String[]) objArr7[2];
                    int i172 = ~(((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getStreamMaxVolume(3) | 531603311);
                    int i173 = i169 + (((-208691151) | i172) * (-658)) + 1386689439 + ((i172 | (-536862704)) * 658);
                    int i174 = (i173 << 13) ^ i173;
                    int i175 = i174 ^ (i174 >>> 17);
                    i12 = 0;
                    ((int[]) objArr103[3])[0] = i175 ^ (i175 << 5);
                }
                super.onCreate();
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1313006081);
                if (objAccessartificialFrame5 == null) {
                    int iArgb3 = Color.argb(i12, i12, i12, i12) + 21;
                    char c8 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1);
                    int iGreen2 = Color.green(i12) + 465;
                    Object[] objArr104 = new Object[1];
                    a((byte) ($$b & 480), (byte) 47, $$a[117], objArr104);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iArgb3, c8, iGreen2, -785931255, false, (String) objArr104[0], null);
                }
                j2 = ((Field) objAccessartificialFrame5).getLong(null);
                if (j2 != -1) {
                    i14 = 0;
                    if (j2 + 2019 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                        objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(1142731807);
                        if (objAccessartificialFrame9 == null) {
                            int bitsPerPixel = 20 - ImageFormat.getBitsPerPixel(0);
                            char mirror = (char) (AndroidCharacter.getMirror('0') - '0');
                            int iResolveSize3 = 465 - View.resolveSize(0, 0);
                            Object[] objArr105 = new Object[1];
                            a((byte) ($$b & 476), (byte) 47, $$a[117], objArr105);
                            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(bitsPerPixel, mirror, iResolveSize3, -612765161, false, (String) objArr105[0], null);
                        }
                        Object[] objArr106 = (Object[]) ((Field) objAccessartificialFrame9).get(null);
                        objArr8 = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
                        int i176 = ((int[]) objArr106[3])[0];
                        int i177 = ((int[]) objArr106[0])[0];
                        String[] strArr10 = (String[]) objArr106[1];
                        int iIdentityHashCode7 = System.identityHashCode(this);
                        int i178 = ~iIdentityHashCode7;
                        int i179 = 2142836089 + ((396319358 | iIdentityHashCode7) * (-676)) + (((~(278599758 | i178)) | (-396319359)) * 676) + (((~(iIdentityHashCode7 | (-117719601))) | (~(i178 | 118250032)) | 278069326) * 676) + 219477040;
                        int i180 = (i179 << 13) ^ i179;
                        int i181 = i180 ^ (i180 >>> 17);
                        ((int[]) objArr8[2])[0] = i181 ^ (i181 << 5);
                        i15 = 0;
                    }
                    i18 = ((int[]) objArr8[i15])[i15];
                    i19 = ((int[]) objArr8[3])[i15];
                    if (i19 == i18) {
                        Object[] objArr107 = new Object[4];
                        int[] iArr = new int[1];
                        objArr107[i15] = iArr;
                        objArr107[2] = new int[1];
                        int[] iArr2 = new int[1];
                        objArr107[3] = iArr2;
                        int i182 = ((int[]) objArr8[2])[i15];
                        int i183 = ((int[]) objArr8[3])[i15];
                        int i184 = ((int[]) objArr8[i15])[i15];
                        String[] strArr11 = (String[]) objArr8[1];
                        iArr2[i15] = i183;
                        iArr[i15] = i184;
                        int i185 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i15]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 381570740;
                        int i186 = ~i185;
                        int i187 = i182 + (-639794169) + (((~(17250958 | i186)) | (~((-177600685) | i185))) * (-370)) + (((~(i185 | 17250958)) | (~(i186 | (-177600685))) | android.R.id.alerted_icon) * (-370)) + 1961289444;
                        int i188 = (i187 << 13) ^ i187;
                        int i189 = i188 ^ (i188 >>> 17);
                        ((int[]) objArr107[2])[0] = i189 ^ (i189 << 5);
                        objArr107[1] = strArr11;
                        return;
                    }
                    arrayList2 = new ArrayList();
                    strArr2 = (String[]) objArr8[1];
                    if (strArr2 != null) {
                        for (String str6 : strArr2) {
                            arrayList2.add(str6);
                        }
                    }
                    Object[] objArr108 = {Long.valueOf((((long) 1477841798) << 32) ^ ((long) (i18 ^ i19))), Long.valueOf(1477841862)};
                    byte[] bArr23 = $$d;
                    Object[] objArr109 = new Object[1];
                    c(bArr23[91], (byte) (-bArr23[51]), bArr23[28], objArr109);
                    Class<?> cls15 = Class.forName((String) objArr109[0]);
                    byte b13 = bArr23[28];
                    Object[] objArr110 = new Object[1];
                    c((byte) 83, b13, (short) (b13 | 705), objArr110);
                    cls15.getMethod((String) objArr110[0], Long.TYPE, Long.TYPE).invoke(null, objArr108);
                    Object[] objArr111 = {new int[]{i}, strArr, new int[1], new int[]{i}};
                    int i190 = ((int[]) objArr8[2])[0];
                    int i191 = ((int[]) objArr8[3])[0];
                    int i192 = ((int[]) objArr8[0])[0];
                    String[] strArr12 = (String[]) objArr8[1];
                    int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 1882858929;
                    int i193 = ~length;
                    int i194 = i190 + ((((-639794169) + (((~(833130080 | i193)) | (~((-993479807) | length))) * (-370))) + ((((~(length | 833130080)) | (~(i193 | (-993479807)))) | 8946176) * (-370))) - 984882176);
                    int i195 = (i194 << 13) ^ i194;
                    int i196 = i195 ^ (i195 >>> 17);
                    ((int[]) objArr111[2])[0] = i196 ^ (i196 << 5);
                    return;
                }
                i14 = 0;
                baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr112 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i14]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 34, new char[]{19170, 19075, 30120, 37283, 1365, 52731, 19664, 57741, 56089, '8', 38849, 29245, 27051, 29269, 9849, 40105, 65055, 60650, 45065, 11602, 3268, 24436, 49813, 49110, 40274, 51593, 27943, 51622, 9211, 14353}, objArr112);
                    Class<?> cls16 = Class.forName((String) objArr112[0]);
                    Object[] objArr113 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 48, new char[]{42214, 42117, 17350, 42966, 20158, 34310, 491, 44214, 13591, 13905, 56364, 16233, 34750, 17467, 28056, 53717, 4153, 55942, 64500, 24681, 58073, 26909}, objArr113);
                    baseContext = (Context) cls16.getMethod((String) objArr113[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    if ((baseContext instanceof ContextWrapper) || ((ContextWrapper) baseContext).getBaseContext() != null) {
                        baseContext = baseContext.getApplicationContext();
                    } else {
                        baseContext = null;
                    }
                }
                int iIntValue3 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                Object[] objArr114 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 48, new char[]{26415, 26441, 52560, 10500, 31221, 45320, 54860, 31569, 63112, 47308, 60208, 59576, 17508, 51940, 23247, 1658, 54179, 21575, 52406, 47041, 8474, 59265, 48676, 9478, 45310, 28960, 4510, 21305, 3680, 33004, 33657, 49371, 40007, 4633, 29371, 32273, 60393, 48224, 58455, 61415, 31011, 53167, 22479, 7497, 51415, 22814, 51708, 35470, 9803, 59557, 47949, 14583, 46521, 31332, 10963, 22116, 914, 34189, 40048, 51102, 37127, 5966, 3979, 30062, 57524, 41250, 57626, 58020}, objArr114);
                String str7 = (String) objArr114[0];
                Object[] objArr115 = new Object[1];
                b(Color.red(0) + 1, new char[]{27127, 27074, 5912, 62282, 45433, 31190, 56823, 28861, 63494, 25223, 9144, 58112, 19182, 4268, 37393, 3522, 56701, 36362, 1076, 48165, 12180, 15771, 30461, 12013, 48754, 43831, 55629, 22661, Typography.paragraph, 23281, 19362, 52066, 37535, 51292, 47714, 30206, 58722, 26158, 11406, 58378, 30710, 5600, 40781, 5793, 50694, 33543, 369, 33074, 10392, 13033, 29639, 13134, 47920, 41086, 57869, 23950, 3345, 24468, 21678, 52338, 40845, 52484, 50956, 32387, 61035, 31592, 10694, 59721}, objArr115);
                Object[] objArr116 = {baseContext, new String[]{str7, (String) objArr115[0]}, Integer.valueOf(iIntValue3), 1, 219477040};
                byte[] bArr24 = $$d;
                byte b14 = bArr24[37];
                byte b15 = (byte) (-bArr24[51]);
                Object[] objArr117 = new Object[1];
                c(b14, b15, (short) (b15 & 236), objArr117);
                Class<?> cls17 = Class.forName((String) objArr117[0]);
                Object[] objArr118 = new Object[1];
                c(bArr24[103], bArr24[20], (short) 194, objArr118);
                objArr8 = (Object[]) cls17.getMethod((String) objArr118[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr116);
                int i197 = ((int[]) objArr8[0])[0];
                int i198 = ((int[]) objArr8[3])[0];
                if (baseContext != null) {
                    i16 = artificialFrame + 93;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i16 % 128;
                    try {
                        if (i16 % 2 != 0) {
                            objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(1142731807);
                            if (objAccessartificialFrame8 == null) {
                                int mode2 = 21 - View.MeasureSpec.getMode(0);
                                char trimmedLength3 = (char) TextUtils.getTrimmedLength("");
                                int i199 = 464 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                                Object[] objArr119 = new Object[1];
                                a((byte) ($$b & 476), (byte) 47, $$a[117], objArr119);
                                objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(mode2, trimmedLength3, i199, -612765161, false, (String) objArr119[0], null);
                            }
                            ((Field) objAccessartificialFrame8).set(null, objArr8);
                            lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[1])).longValue());
                            objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(1313006081);
                            if (objAccessartificialFrame7 == null) {
                                iResolveSizeAndState = 21 - View.MeasureSpec.getMode(0);
                                cIndexOf = (char) (Process.myTid() >> 22);
                                iAxisFromString = 464 - MotionEvent.axisFromString("");
                                i17 = -785931255;
                                z = false;
                                Object[] objArr120 = new Object[1];
                                a((byte) ($$b & 480), (byte) 47, $$a[117], objArr120);
                                obj3 = objArr120[0];
                                objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState, cIndexOf, iAxisFromString, i17, z, (String) obj3, null);
                            }
                        } else {
                            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(1142731807);
                            if (objAccessartificialFrame6 == null) {
                                int i200 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 20;
                                char c9 = (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                                int doubleTapTimeout4 = 465 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                                Object[] objArr121 = new Object[1];
                                a((byte) ($$b & 476), (byte) 47, $$a[117], objArr121);
                                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i200, c9, doubleTapTimeout4, -612765161, false, (String) objArr121[0], null);
                            }
                            ((Field) objAccessartificialFrame6).set(null, objArr8);
                            lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(1313006081);
                            if (objAccessartificialFrame7 == null) {
                                iResolveSizeAndState = 21 - View.resolveSizeAndState(0, 0, 0);
                                cIndexOf = (char) TextUtils.indexOf("", "");
                                iAxisFromString = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 464;
                                i17 = -785931255;
                                z = false;
                                Object[] objArr122 = new Object[1];
                                a((byte) ($$b & 480), (byte) 47, $$a[117], objArr122);
                                obj3 = objArr122[0];
                                objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState, cIndexOf, iAxisFromString, i17, z, (String) obj3, null);
                            }
                        }
                        ((Field) objAccessartificialFrame7).set(null, lValueOf);
                    } catch (Exception unused7) {
                        throw new RuntimeException();
                    }
                }
                i15 = 0;
                i18 = ((int[]) objArr8[i15])[i15];
                i19 = ((int[]) objArr8[3])[i15];
                if (i19 == i18) {
                    Object[] objArr1010 = new Object[4];
                    int[] iArr3 = new int[1];
                    objArr1010[i15] = iArr3;
                    objArr1010[2] = new int[1];
                    int[] iArr4 = new int[1];
                    objArr1010[3] = iArr4;
                    int i1810 = ((int[]) objArr8[2])[i15];
                    int i1811 = ((int[]) objArr8[3])[i15];
                    int i1812 = ((int[]) objArr8[i15])[i15];
                    String[] strArr13 = (String[]) objArr8[1];
                    iArr4[i15] = i1811;
                    iArr3[i15] = i1812;
                    int i1813 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i15]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 381570740;
                    int i1814 = ~i1813;
                    int i1815 = i1810 + (-639794169) + (((~(17250958 | i1814)) | (~((-177600685) | i1813))) * (-370)) + (((~(i1813 | 17250958)) | (~(i1814 | (-177600685))) | android.R.id.alerted_icon) * (-370)) + 1961289444;
                    int i1816 = (i1815 << 13) ^ i1815;
                    int i1817 = i1816 ^ (i1816 >>> 17);
                    ((int[]) objArr1010[2])[0] = i1817 ^ (i1817 << 5);
                    objArr1010[1] = strArr13;
                    return;
                }
                arrayList2 = new ArrayList();
                strArr2 = (String[]) objArr8[1];
                if (strArr2 != null) {
                    while (i20 < strArr2.length) {
                        arrayList2.add(str6);
                    }
                }
                Object[] objArr1011 = {Long.valueOf((((long) 1477841798) << 32) ^ ((long) (i18 ^ i19))), Long.valueOf(1477841862)};
                byte[] bArr25 = $$d;
                Object[] objArr1012 = new Object[1];
                c(bArr25[91], (byte) (-bArr25[51]), bArr25[28], objArr1012);
                Class<?> cls18 = Class.forName((String) objArr1012[0]);
                byte b16 = bArr25[28];
                Object[] objArr1110 = new Object[1];
                c((byte) 83, b16, (short) (b16 | 705), objArr1110);
                cls18.getMethod((String) objArr1110[0], Long.TYPE, Long.TYPE).invoke(null, objArr1011);
                Object[] objArr1111 = {new int[]{i192}, strArr12, new int[1], new int[]{i191}};
                int i1910 = ((int[]) objArr8[2])[0];
                int i1911 = ((int[]) objArr8[3])[0];
                int i1912 = ((int[]) objArr8[0])[0];
                String[] strArr14 = (String[]) objArr8[1];
                int length2 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 1882858929;
                int i1913 = ~length2;
                int i1914 = i1910 + ((((-639794169) + (((~(833130080 | i1913)) | (~((-993479807) | length2))) * (-370))) + ((((~(length2 | 833130080)) | (~(i1913 | (-993479807)))) | 8946176) * (-370))) - 984882176);
                int i1915 = (i1914 << 13) ^ i1914;
                int i1916 = i1915 ^ (i1915 >>> 17);
                ((int[]) objArr1111[2])[0] = i1916 ^ (i1916 << 5);
                return;
            }
            i6 = 0;
            Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(-1168947751);
            if (objAccessartificialFrame36 == null) {
                int absoluteGravity3 = Gravity.getAbsoluteGravity(0, 0) + 36;
                char cMakeMeasureSpec2 = (char) View.MeasureSpec.makeMeasureSpec(0, 0);
                int jumpTapTimeout4 = (ViewConfiguration.getJumpTapTimeout() >> 16) + 540;
                Object[] objArr123 = new Object[1];
                a((byte) ($$b & 480), (byte) 47, $$a[117], objArr123);
                objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(absoluteGravity3, cMakeMeasureSpec2, jumpTapTimeout4, 624296913, false, (String) objArr123[0], null);
            }
            ((Field) objAccessartificialFrame36).set(null, lValueOf8);
            obj = objArr6[1];
            i7 = ((int[]) obj)[0];
            obj2 = objArr6[2];
            i8 = ((int[]) obj2)[0];
            if (i8 == i7) {
                Object[] objArr810 = {new int[1], new int[1], new int[1]};
                int i1410 = ((int[]) objArr6[0])[0];
                int i1411 = ((int[]) obj2)[0];
                int i1412 = ((int[]) obj)[0];
                ((int[]) objArr810[2])[0] = i1411;
                ((int[]) objArr810[1])[0] = i1412;
                int i1413 = ~System.identityHashCode(this);
                int i1414 = i1410 + (-1909421495) + ((~(1342176191 | i1413)) * 52) + (((~(211593910 | i1413)) | (~((-1140027840) | i1413)) | 1130582281) * (-52)) + (((~(i1413 | (-211593911))) | 202148352) * 52);
                int i1415 = (i1414 << 13) ^ i1414;
                int i1416 = i1415 ^ (i1415 >>> 17);
                i9 = 0;
                ((int[]) objArr810[0])[0] = i1416 ^ (i1416 << 5);
            } else {
                Object[] objArr811 = {Long.valueOf(((long) (i7 ^ i8)) ^ (((long) 606969568) << 32)), Long.valueOf(606965472)};
                byte[] bArr26 = $$d;
                Object[] objArr812 = new Object[1];
                c(bArr26[13], (byte) (-bArr26[51]), (short) 548, objArr812);
                Class<?> cls19 = Class.forName((String) objArr812[0]);
                byte b17 = bArr26[28];
                Object[] objArr910 = new Object[1];
                c((byte) 83, b17, (short) (b17 | 705), objArr910);
                cls19.getMethod((String) objArr910[0], Long.TYPE, Long.TYPE).invoke(null, objArr811);
                Object[] objArr911 = {new int[1], new int[1], new int[1]};
                int i1417 = ((int[]) objArr6[0])[0];
                int i1510 = ((int[]) objArr6[2])[0];
                int i1511 = ((int[]) objArr6[1])[0];
                ((int[]) objArr911[2])[0] = i1510;
                ((int[]) objArr911[1])[0] = i1511;
                int iMyPid3 = Process.myPid();
                int i1512 = i1417 + ((((-176256865) + (((~((~iMyPid3) | (-350515623))) | 278929542) * 446)) + (((~(iMyPid3 | (-71586081))) | 722176585) * 446)) - 151475852);
                int i1513 = (i1512 << 13) ^ i1512;
                int i1514 = i1513 ^ (i1513 >>> 17);
                i9 = 0;
                ((int[]) objArr911[0])[0] = i1514 ^ (i1514 << 5);
            }
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame == null) {
                int capsMode2 = 25 - TextUtils.getCapsMode("", i9, i9);
                char offsetBefore2 = (char) (TextUtils.getOffsetBefore("", i9) + 30068);
                int absoluteGravity4 = 816 - Gravity.getAbsoluteGravity(i9, i9);
                Object[] objArr912 = new Object[1];
                a((byte) ($$b & 480), (byte) 47, $$a[117], objArr912);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(capsMode2, offsetBefore2, absoluteGravity4, 721586079, false, (String) objArr912[0], null);
            }
            j = ((Field) objAccessartificialFrame).getLong(null);
            if (j != -1) {
                Object[] objArr913 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -1139360697};
                objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame2 == null) {
                    int iLastIndexOf4 = 24 - TextUtils.lastIndexOf("", '0', 0);
                    char packedPositionChild3 = (char) (30067 - ExpandableListView.getPackedPositionChild(0L));
                    int doubleTapTimeout5 = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 816;
                    byte b18 = (byte) ($$b & 468);
                    byte[] bArr27 = $$a;
                    Object[] objArr914 = new Object[1];
                    a(b18, bArr27[37], bArr27[1], objArr914);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iLastIndexOf4, packedPositionChild3, doubleTapTimeout5, -797394565, false, (String) objArr914[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr7 = (Object[]) ((Method) objAccessartificialFrame2).invoke(null, objArr913);
                objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame3 == null) {
                    int packedPositionType3 = 25 - ExpandableListView.getPackedPositionType(0L);
                    char cAxisFromString2 = (char) (30067 - MotionEvent.axisFromString(""));
                    int iIndexOf5 = TextUtils.indexOf((CharSequence) "", '0') + 817;
                    Object[] objArr915 = new Object[1];
                    a((byte) ($$b & 476), (byte) 47, $$a[117], objArr915);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(packedPositionType3, cAxisFromString2, iIndexOf5, 891606461, false, (String) objArr915[0], null);
                }
                ((Field) objAccessartificialFrame3).set(null, objArr7);
                Long lValueOf9 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame4 == null) {
                    int touchSlop4 = (ViewConfiguration.getTouchSlop() >> 8) + 25;
                    char defaultSize4 = (char) (View.getDefaultSize(0, 0) + 30068);
                    int iIndexOf6 = 816 - TextUtils.indexOf("", "", 0, 0);
                    Object[] objArr916 = new Object[1];
                    a((byte) ($$b & 480), (byte) 47, $$a[117], objArr916);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(touchSlop4, defaultSize4, iIndexOf6, 721586079, false, (String) objArr916[0], null);
                }
                ((Field) objAccessartificialFrame4).set(null, lValueOf9);
            } else {
                Object[] objArr917 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -1139360697};
                objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame2 == null) {
                    int iLastIndexOf5 = 24 - TextUtils.lastIndexOf("", '0', 0);
                    char packedPositionChild4 = (char) (30067 - ExpandableListView.getPackedPositionChild(0L));
                    int doubleTapTimeout6 = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 816;
                    byte b19 = (byte) ($$b & 468);
                    byte[] bArr28 = $$a;
                    Object[] objArr918 = new Object[1];
                    a(b19, bArr28[37], bArr28[1], objArr918);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iLastIndexOf5, packedPositionChild4, doubleTapTimeout6, -797394565, false, (String) objArr918[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr7 = (Object[]) ((Method) objAccessartificialFrame2).invoke(null, objArr917);
                objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame3 == null) {
                    int packedPositionType4 = 25 - ExpandableListView.getPackedPositionType(0L);
                    char cAxisFromString3 = (char) (30067 - MotionEvent.axisFromString(""));
                    int iIndexOf7 = TextUtils.indexOf((CharSequence) "", '0') + 817;
                    Object[] objArr919 = new Object[1];
                    a((byte) ($$b & 476), (byte) 47, $$a[117], objArr919);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(packedPositionType4, cAxisFromString3, iIndexOf7, 891606461, false, (String) objArr919[0], null);
                }
                ((Field) objAccessartificialFrame3).set(null, objArr7);
                Long lValueOf10 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame4 == null) {
                    int touchSlop5 = (ViewConfiguration.getTouchSlop() >> 8) + 25;
                    char defaultSize5 = (char) (View.getDefaultSize(0, 0) + 30068);
                    int iIndexOf8 = 816 - TextUtils.indexOf("", "", 0, 0);
                    Object[] objArr9110 = new Object[1];
                    a((byte) ($$b & 480), (byte) 47, $$a[117], objArr9110);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(touchSlop5, defaultSize5, iIndexOf8, 721586079, false, (String) objArr9110[0], null);
                }
                ((Field) objAccessartificialFrame4).set(null, lValueOf10);
            }
            i10 = ((int[]) objArr7[1])[0];
            i11 = ((int[]) objArr7[0])[0];
            if (i11 == i10) {
                Object[] objArr920 = {new int[]{i163}, new int[]{i164}, strArr8, new int[1]};
                int i1610 = ((int[]) objArr7[3])[0];
                int i1611 = ((int[]) objArr7[0])[0];
                int i1612 = ((int[]) objArr7[1])[0];
                String[] strArr15 = (String[]) objArr7[2];
                int i1613 = ~System.identityHashCode(this);
                int i1614 = i1610 + (((1076133337 + (((~((-70273077) | i1613)) | 268445442) * (-828))) + ((i1613 | (-70273077)) * (-828))) - 1943435216);
                int i1615 = (i1614 << 13) ^ i1614;
                int i1616 = i1615 ^ (i1615 >>> 17);
                i12 = 0;
                ((int[]) objArr920[3])[0] = i1616 ^ (i1616 << 5);
            } else {
                arrayList = new ArrayList();
                strArr = (String[]) objArr7[2];
                if (strArr != null) {
                    while (i13 < strArr.length) {
                        arrayList.add(str5);
                    }
                }
                Object[] objArr1013 = {Long.valueOf(((long) (i10 ^ i11)) ^ (((long) 114022906) << 32)), Long.valueOf(114022907)};
                byte[] bArr29 = $$d;
                Object[] objArr1014 = new Object[1];
                c(bArr29[353], (byte) (-bArr29[51]), (short) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, objArr1014);
                Class<?> cls110 = Class.forName((String) objArr1014[0]);
                byte b110 = bArr29[28];
                Object[] objArr1015 = new Object[1];
                c((byte) 83, b110, (short) (b110 | 705), objArr1015);
                cls110.getMethod((String) objArr1015[0], Long.TYPE, Long.TYPE).invoke(null, objArr1013);
                Object[] objArr1016 = {new int[]{i170}, new int[]{i171}, strArr9, new int[1]};
                int i1617 = ((int[]) objArr7[3])[0];
                int i1710 = ((int[]) objArr7[0])[0];
                int i1711 = ((int[]) objArr7[1])[0];
                String[] strArr16 = (String[]) objArr7[2];
                int i1712 = ~(((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getStreamMaxVolume(3) | 531603311);
                int i1713 = i1617 + (((-208691151) | i1712) * (-658)) + 1386689439 + ((i1712 | (-536862704)) * 658);
                int i1714 = (i1713 << 13) ^ i1713;
                int i1715 = i1714 ^ (i1714 >>> 17);
                i12 = 0;
                ((int[]) objArr1016[3])[0] = i1715 ^ (i1715 << 5);
            }
            super.onCreate();
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1313006081);
            if (objAccessartificialFrame5 == null) {
                int iArgb4 = Color.argb(i12, i12, i12, i12) + 21;
                char c10 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1);
                int iGreen3 = Color.green(i12) + 465;
                Object[] objArr1017 = new Object[1];
                a((byte) ($$b & 480), (byte) 47, $$a[117], objArr1017);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iArgb4, c10, iGreen3, -785931255, false, (String) objArr1017[0], null);
            }
            j2 = ((Field) objAccessartificialFrame5).getLong(null);
            if (j2 != -1) {
                i14 = 0;
                if (j2 + 2019 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(1142731807);
                    if (objAccessartificialFrame9 == null) {
                        int bitsPerPixel2 = 20 - ImageFormat.getBitsPerPixel(0);
                        char mirror2 = (char) (AndroidCharacter.getMirror('0') - '0');
                        int iResolveSize4 = 465 - View.resolveSize(0, 0);
                        Object[] objArr1018 = new Object[1];
                        a((byte) ($$b & 476), (byte) 47, $$a[117], objArr1018);
                        objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(bitsPerPixel2, mirror2, iResolveSize4, -612765161, false, (String) objArr1018[0], null);
                    }
                    Object[] objArr1019 = (Object[]) ((Field) objAccessartificialFrame9).get(null);
                    objArr8 = new Object[]{new int[]{i177}, strArr10, new int[1], new int[]{i176}};
                    int i1716 = ((int[]) objArr1019[3])[0];
                    int i1717 = ((int[]) objArr1019[0])[0];
                    String[] strArr17 = (String[]) objArr1019[1];
                    int iIdentityHashCode8 = System.identityHashCode(this);
                    int i1718 = ~iIdentityHashCode8;
                    int i1719 = 2142836089 + ((396319358 | iIdentityHashCode8) * (-676)) + (((~(278599758 | i1718)) | (-396319359)) * 676) + (((~(iIdentityHashCode8 | (-117719601))) | (~(i1718 | 118250032)) | 278069326) * 676) + 219477040;
                    int i1818 = (i1719 << 13) ^ i1719;
                    int i1819 = i1818 ^ (i1818 >>> 17);
                    ((int[]) objArr8[2])[0] = i1819 ^ (i1819 << 5);
                    i15 = 0;
                }
                i18 = ((int[]) objArr8[i15])[i15];
                i19 = ((int[]) objArr8[3])[i15];
                if (i19 == i18) {
                    Object[] objArr10110 = new Object[4];
                    int[] iArr5 = new int[1];
                    objArr10110[i15] = iArr5;
                    objArr10110[2] = new int[1];
                    int[] iArr6 = new int[1];
                    objArr10110[3] = iArr6;
                    int i18110 = ((int[]) objArr8[2])[i15];
                    int i18111 = ((int[]) objArr8[3])[i15];
                    int i18112 = ((int[]) objArr8[i15])[i15];
                    String[] strArr18 = (String[]) objArr8[1];
                    iArr6[i15] = i18111;
                    iArr5[i15] = i18112;
                    int i18113 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i15]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 381570740;
                    int i18114 = ~i18113;
                    int i18115 = i18110 + (-639794169) + (((~(17250958 | i18114)) | (~((-177600685) | i18113))) * (-370)) + (((~(i18113 | 17250958)) | (~(i18114 | (-177600685))) | android.R.id.alerted_icon) * (-370)) + 1961289444;
                    int i18116 = (i18115 << 13) ^ i18115;
                    int i18117 = i18116 ^ (i18116 >>> 17);
                    ((int[]) objArr10110[2])[0] = i18117 ^ (i18117 << 5);
                    objArr10110[1] = strArr18;
                    return;
                }
                arrayList2 = new ArrayList();
                strArr2 = (String[]) objArr8[1];
                if (strArr2 != null) {
                    while (i20 < strArr2.length) {
                        arrayList2.add(str6);
                    }
                }
                Object[] objArr10111 = {Long.valueOf((((long) 1477841798) << 32) ^ ((long) (i18 ^ i19))), Long.valueOf(1477841862)};
                byte[] bArr210 = $$d;
                Object[] objArr10112 = new Object[1];
                c(bArr210[91], (byte) (-bArr210[51]), bArr210[28], objArr10112);
                Class<?> cls111 = Class.forName((String) objArr10112[0]);
                byte b111 = bArr210[28];
                Object[] objArr1112 = new Object[1];
                c((byte) 83, b111, (short) (b111 | 705), objArr1112);
                cls111.getMethod((String) objArr1112[0], Long.TYPE, Long.TYPE).invoke(null, objArr10111);
                Object[] objArr1113 = {new int[]{i1912}, strArr14, new int[1], new int[]{i1911}};
                int i1917 = ((int[]) objArr8[2])[0];
                int i1918 = ((int[]) objArr8[3])[0];
                int i1919 = ((int[]) objArr8[0])[0];
                String[] strArr19 = (String[]) objArr8[1];
                int length3 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 1882858929;
                int i19110 = ~length3;
                int i19111 = i1917 + ((((-639794169) + (((~(833130080 | i19110)) | (~((-993479807) | length3))) * (-370))) + ((((~(length3 | 833130080)) | (~(i19110 | (-993479807)))) | 8946176) * (-370))) - 984882176);
                int i19112 = (i19111 << 13) ^ i19111;
                int i19113 = i19112 ^ (i19112 >>> 17);
                ((int[]) objArr1113[2])[0] = i19113 ^ (i19113 << 5);
                return;
            }
            i14 = 0;
            baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr1114 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i14]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 34, new char[]{19170, 19075, 30120, 37283, 1365, 52731, 19664, 57741, 56089, '8', 38849, 29245, 27051, 29269, 9849, 40105, 65055, 60650, 45065, 11602, 3268, 24436, 49813, 49110, 40274, 51593, 27943, 51622, 9211, 14353}, objArr1114);
                Class<?> cls112 = Class.forName((String) objArr1114[0]);
                Object[] objArr1115 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 48, new char[]{42214, 42117, 17350, 42966, 20158, 34310, 491, 44214, 13591, 13905, 56364, 16233, 34750, 17467, 28056, 53717, 4153, 55942, 64500, 24681, 58073, 26909}, objArr1115);
                baseContext = (Context) cls112.getMethod((String) objArr1115[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                if (baseContext instanceof ContextWrapper) {
                    baseContext = baseContext.getApplicationContext();
                } else {
                    baseContext = baseContext.getApplicationContext();
                }
            }
            int iIntValue4 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr1116 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 48, new char[]{26415, 26441, 52560, 10500, 31221, 45320, 54860, 31569, 63112, 47308, 60208, 59576, 17508, 51940, 23247, 1658, 54179, 21575, 52406, 47041, 8474, 59265, 48676, 9478, 45310, 28960, 4510, 21305, 3680, 33004, 33657, 49371, 40007, 4633, 29371, 32273, 60393, 48224, 58455, 61415, 31011, 53167, 22479, 7497, 51415, 22814, 51708, 35470, 9803, 59557, 47949, 14583, 46521, 31332, 10963, 22116, 914, 34189, 40048, 51102, 37127, 5966, 3979, 30062, 57524, 41250, 57626, 58020}, objArr1116);
            String str8 = (String) objArr1116[0];
            Object[] objArr1117 = new Object[1];
            b(Color.red(0) + 1, new char[]{27127, 27074, 5912, 62282, 45433, 31190, 56823, 28861, 63494, 25223, 9144, 58112, 19182, 4268, 37393, 3522, 56701, 36362, 1076, 48165, 12180, 15771, 30461, 12013, 48754, 43831, 55629, 22661, Typography.paragraph, 23281, 19362, 52066, 37535, 51292, 47714, 30206, 58722, 26158, 11406, 58378, 30710, 5600, 40781, 5793, 50694, 33543, 369, 33074, 10392, 13033, 29639, 13134, 47920, 41086, 57869, 23950, 3345, 24468, 21678, 52338, 40845, 52484, 50956, 32387, 61035, 31592, 10694, 59721}, objArr1117);
            Object[] objArr1118 = {baseContext, new String[]{str8, (String) objArr1117[0]}, Integer.valueOf(iIntValue4), 1, 219477040};
            byte[] bArr211 = $$d;
            byte b112 = bArr211[37];
            byte b113 = (byte) (-bArr211[51]);
            Object[] objArr1119 = new Object[1];
            c(b112, b113, (short) (b113 & 236), objArr1119);
            Class<?> cls113 = Class.forName((String) objArr1119[0]);
            Object[] objArr1120 = new Object[1];
            c(bArr211[103], bArr211[20], (short) 194, objArr1120);
            objArr8 = (Object[]) cls113.getMethod((String) objArr1120[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr1118);
            int i1920 = ((int[]) objArr8[0])[0];
            int i1921 = ((int[]) objArr8[3])[0];
            if (baseContext != null) {
                i16 = artificialFrame + 93;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i16 % 128;
                if (i16 % 2 != 0) {
                    objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(1142731807);
                    if (objAccessartificialFrame8 == null) {
                        int mode3 = 21 - View.MeasureSpec.getMode(0);
                        char trimmedLength4 = (char) TextUtils.getTrimmedLength("");
                        int i1922 = 464 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                        Object[] objArr1121 = new Object[1];
                        a((byte) ($$b & 476), (byte) 47, $$a[117], objArr1121);
                        objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(mode3, trimmedLength4, i1922, -612765161, false, (String) objArr1121[0], null);
                    }
                    ((Field) objAccessartificialFrame8).set(null, objArr8);
                    lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[1])).longValue());
                    objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(1313006081);
                    if (objAccessartificialFrame7 == null) {
                        iResolveSizeAndState = 21 - View.MeasureSpec.getMode(0);
                        cIndexOf = (char) (Process.myTid() >> 22);
                        iAxisFromString = 464 - MotionEvent.axisFromString("");
                        i17 = -785931255;
                        z = false;
                        Object[] objArr124 = new Object[1];
                        a((byte) ($$b & 480), (byte) 47, $$a[117], objArr124);
                        obj3 = objArr124[0];
                        objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState, cIndexOf, iAxisFromString, i17, z, (String) obj3, null);
                    }
                } else {
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(1142731807);
                    if (objAccessartificialFrame6 == null) {
                        int i201 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 20;
                        char c11 = (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                        int doubleTapTimeout7 = 465 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                        Object[] objArr125 = new Object[1];
                        a((byte) ($$b & 476), (byte) 47, $$a[117], objArr125);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i201, c11, doubleTapTimeout7, -612765161, false, (String) objArr125[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, objArr8);
                    lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(1313006081);
                    if (objAccessartificialFrame7 == null) {
                        iResolveSizeAndState = 21 - View.resolveSizeAndState(0, 0, 0);
                        cIndexOf = (char) TextUtils.indexOf("", "");
                        iAxisFromString = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 464;
                        i17 = -785931255;
                        z = false;
                        Object[] objArr126 = new Object[1];
                        a((byte) ($$b & 480), (byte) 47, $$a[117], objArr126);
                        obj3 = objArr126[0];
                        objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState, cIndexOf, iAxisFromString, i17, z, (String) obj3, null);
                    }
                }
                ((Field) objAccessartificialFrame7).set(null, lValueOf);
            }
            i15 = 0;
            i18 = ((int[]) objArr8[i15])[i15];
            i19 = ((int[]) objArr8[3])[i15];
            if (i19 == i18) {
                Object[] objArr10113 = new Object[4];
                int[] iArr7 = new int[1];
                objArr10113[i15] = iArr7;
                objArr10113[2] = new int[1];
                int[] iArr8 = new int[1];
                objArr10113[3] = iArr8;
                int i18118 = ((int[]) objArr8[2])[i15];
                int i18119 = ((int[]) objArr8[3])[i15];
                int i181110 = ((int[]) objArr8[i15])[i15];
                String[] strArr110 = (String[]) objArr8[1];
                iArr8[i15] = i18119;
                iArr7[i15] = i181110;
                int i181111 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i15]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 381570740;
                int i181112 = ~i181111;
                int i181113 = i18118 + (-639794169) + (((~(17250958 | i181112)) | (~((-177600685) | i181111))) * (-370)) + (((~(i181111 | 17250958)) | (~(i181112 | (-177600685))) | android.R.id.alerted_icon) * (-370)) + 1961289444;
                int i181114 = (i181113 << 13) ^ i181113;
                int i181115 = i181114 ^ (i181114 >>> 17);
                ((int[]) objArr10113[2])[0] = i181115 ^ (i181115 << 5);
                objArr10113[1] = strArr110;
                return;
            }
            arrayList2 = new ArrayList();
            strArr2 = (String[]) objArr8[1];
            if (strArr2 != null) {
                while (i20 < strArr2.length) {
                    arrayList2.add(str6);
                }
            }
            Object[] objArr10114 = {Long.valueOf((((long) 1477841798) << 32) ^ ((long) (i18 ^ i19))), Long.valueOf(1477841862)};
            byte[] bArr212 = $$d;
            Object[] objArr10115 = new Object[1];
            c(bArr212[91], (byte) (-bArr212[51]), bArr212[28], objArr10115);
            Class<?> cls114 = Class.forName((String) objArr10115[0]);
            byte b114 = bArr212[28];
            Object[] objArr11110 = new Object[1];
            c((byte) 83, b114, (short) (b114 | 705), objArr11110);
            cls114.getMethod((String) objArr11110[0], Long.TYPE, Long.TYPE).invoke(null, objArr10114);
            Object[] objArr11111 = {new int[]{i1919}, strArr19, new int[1], new int[]{i1918}};
            int i19114 = ((int[]) objArr8[2])[0];
            int i19115 = ((int[]) objArr8[3])[0];
            int i19116 = ((int[]) objArr8[0])[0];
            String[] strArr111 = (String[]) objArr8[1];
            int length4 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 1882858929;
            int i19117 = ~length4;
            int i19118 = i19114 + ((((-639794169) + (((~(833130080 | i19117)) | (~((-993479807) | length4))) * (-370))) + ((((~(length4 | 833130080)) | (~(i19117 | (-993479807)))) | 8946176) * (-370))) - 984882176);
            int i19119 = (i19118 << 13) ^ i19118;
            int i191110 = i19119 ^ (i19119 >>> 17);
            ((int[]) objArr11111[2])[0] = i191110 ^ (i191110 << 5);
            return;
        } catch (Exception unused8) {
            throw new RuntimeException();
        }
        Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(-1717965552);
        if (objAccessartificialFrame37 == null) {
            objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(20 - View.MeasureSpec.getSize(i6), (char) (((Process.getThreadPriority(i6) + 20) >> 6) + 39516), 981 - MotionEvent.axisFromString(""), 117222168, false, null, new Class[0]);
        }
        Object[] objArr127 = {null, ((Constructor) objAccessartificialFrame37).newInstance(null), -1763289887, 0};
        Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(-501205803);
        if (objAccessartificialFrame38 == null) {
            int fadingEdgeLength2 = (ViewConfiguration.getFadingEdgeLength() >> 16) + 36;
            char cNormalizeMetaState2 = (char) KeyEvent.normalizeMetaState(0);
            int packedPositionType5 = ExpandableListView.getPackedPositionType(0L) + 540;
            byte b20 = (byte) ($$a[21] - 1);
            byte b21 = b20;
            Object[] objArr128 = new Object[1];
            a(b20, b21, b21, objArr128);
            objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength2, cNormalizeMetaState2, packedPositionType5, 2101703389, false, (String) objArr128[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(53 - Process.getGidForName(""), (char) (833 - Drawable.resolveOpacity(0, 0)), 577 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), (Class) ArtificialStackFrames.coroutineCreation(54 - ((Process.getThreadPriority(0) + 20) >> 6), (char) (ImageFormat.getBitsPerPixel(0) + 1), (Process.myTid() >> 22) + 630), Integer.TYPE, Integer.TYPE});
        }
        objArr6 = (Object[]) ((Method) objAccessartificialFrame38).invoke(null, objArr127);
        Object objAccessartificialFrame39 = ArtificialStackFrames.accessartificialFrame(-1339222025);
        if (objAccessartificialFrame39 == null) {
            int i202 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 35;
            char capsMode3 = (char) TextUtils.getCapsMode("", 0, 0);
            int iIndexOf9 = TextUtils.indexOf((CharSequence) "", '0', 0) + 541;
            Object[] objArr129 = new Object[1];
            a((byte) ($$b & 476), (byte) 47, $$a[117], objArr129);
            objAccessartificialFrame39 = ArtificialStackFrames.coroutineCreation(i202, capsMode3, iIndexOf9, 793268735, false, (String) objArr129[0], null);
        }
        ((Field) objAccessartificialFrame39).set(null, objArr6);
    }

    static {
        byte[] bArr = new byte[785];
        System.arraycopy("4ÝÃÑðþ;Ãôü\u0004÷\u00033Çíõ\u0005ø\u0001=¶\u0007÷ÿ9Éø\u0000ù2éØî*àå)âèQïü¿\u0000ÿðü\u00009\u0001Á÷ö\u000bï\u0000\tñ:º\u0000\u0007é\nóù\u0001;Éï\u0006îÿ\u0002\u00012æÛûýïü\tý\rà\bô\u0002í/Ùÿíø\u000bï÷6¹þøA¾ù\u0004\u0001ýúô9Çðù\t3·ÿ\u00037çÆ\u0012óÿ\u0002\u001dÉ\u000büýï\u001aÞ\rúô\u0002ïðþ;·\u000eñ\u0003î\tóù\u000bú3½\bë\u0003\u0002í\u0007÷\u0003\u0000óùö\r2¸\túúòûþ\ré\u0007öý<Èðùÿöý\u0007÷\u0005\u001fÏö\u0003\u0006ÿëõðþ;Ä\u0001úúÿïü\u00009Éíü\u0000ÿ÷ÿôAéÍü ß÷ÿ#ßé\u000f9ïðþ;Ä\u0001úúÿïü\u00009¸\t\u0000úëBÈì\u0005\u0001ùþ3àåç\u0011\u0010äí\bõ\u0007\tá\ríü\u0007ïJïýÐùÿöý\u0007÷\u0005\u001dÛÿé\nüú÷\u0003\u0018Óðþ;Ãôü\u0004÷\u00033Äùó\tÿýê\n3Çðþùýý\u0005óöýAÛÛø\u0007öý\tñ\u0018Úÿõ\t\u0001ûïJüÛÉ\u0000\u000bï\u0000\tñ\u0015Ö\u0007ö\bÿí\u0007\u0002\u0013çð\u0007úÿ+ðþ;·ø\u0006\bï÷\u0006öý<¸\t\u0000ï\u0001ø\bé\u000bý2¾\u0007ä\u0006öý\u001eé\u0000ï\u0001ø\bé\u0007öý<×ç\u0003ë\tý\fÞ\rï÷\u0006ñ\u0007öý\u001dèï\töþïJÍá\tíù\u0007õ÷\u001cÞ\tü\u000béò\u0006ñ\u0001ùðùÿöý\u0007÷\u0005\u001eÍ\t\u0000é\u0007öýðþ;Ãôü\u0004÷\u00033Éí\u00037ÙØ\u0002÷\u000f\rÚÿ÷\u0001ðþ;Ãôü\u0004÷\u00033Çíõ\u0005ø\u0001=¶\u0007÷ÿ9·\u0007\u0003ùûý2ºúÿ÷\u0001\té\u000b4×Ûþù\u000eëûÿ\rñ\u001bäîü\u000eöþ\u0018×\u0004óúüúîü\u000eëú\u0007ÿù\u0002ö\u0004ñ\"Ð\rð\u0004ðþ;Ä\u0001úúÿïü\u00009¸\t\u0000úëBµ\bø\bï\töþï@Ñæ\u0004\u0002\u000fÛ\u0007û\u0011ÝüÿDüÛÉ\u0000\u000bï\u0000\tñ\u0015Ö\u0007ö\bÿí\u0007\u0002\u0013çð\u0007úÿ-ðþ;Ä\u0001úúÿïü\u00009Áø\böþñ\u0003õ\u0007õÿ÷\u00053Çðù\t3ÚÚÿ\u0007ë\u000eúï\u001bêðø\fó\u0007ú\u001báúë\u0001ùõQÝÐþù\u000bï\u0001öýðþ;Ä\u0001úúÿïü\u00009ÈïÿôýAéÏ\u0006îÿ\u0002\u0001\u001bÉ\u000fþêý\u0001ùûKÝÐþù\u000bï\u0001öýðþ;Ãôü\u0004÷\u00033½ýýþñBÇðþüúý<·\u000bõþ÷ö\u000bï\u0000\tñ:°ü\u0005".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 785);
        $$d = bArr;
        $$e = 204;
        $$a = new byte[]{87, 9, 66, Ascii.SYN, 5, -1, -33, 33, -2, -9, 5, -7, 5, -1, -50, 39, Ascii.VT, -7, -12, Ascii.SI, Ascii.ESC, 1, -7, -6, -33, 51, -12, 3, -8, 1, Ascii.CR, -9, Ascii.DC2, -34, Ascii.EM, 4, -17, 19, -15, -1, -18, Ascii.SI, 19, -11, 5, -7, -2, Ascii.SI, -36, Ascii.NAK, Ascii.CR, -15, 2, 9, 6, -34, Ascii.SI, 19, -11, 5, -7, -2, Ascii.SI, -33, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, 10, -31, Ascii.DC4, Ascii.CR, -8, -11, -13, Ascii.ESC, -9, Ascii.DC2, -36, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, -7, Ascii.DC2, -43, Ascii.GS, -4, 17, 2, 49, 2, -11, -3, 3, -6, 6, -8, Ascii.VT, -25, 33, -19, 2, 8, -37, 44, -17, Ascii.FF, -8, Ascii.SO};
        $$b = 122;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        onPostMessage = -694808411287144667L;
    }
}
