package com.google.android.datatransport.runtime.backends;

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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.facebook.fresco.urimod.UriModifierInterface;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager$$ExternalSyntheticLambda5;
import com.google.common.base.Ascii;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import net.pluservice.unicoc.R;
import o.ArtificialStackFrames;
import o.asBinder;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes2.dex */
public class TransportBackendDiscovery extends Service {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    private static int artificialFrame;
    private static long extraCommand;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static final byte[] $$c = {113, 6, -112, 1};
    private static final int $$f = 7;
    private static int $10 = 0;
    private static int $11 = 1;

    private static String $$g(byte b, byte b2, short s) {
        int i = (b2 * 2) + 118;
        byte[] bArr = $$c;
        int i2 = (b * 2) + 4;
        int i3 = s * 2;
        byte[] bArr2 = new byte[i3 + 1];
        int i4 = -1;
        if (bArr == null) {
            i = i2 + i3;
            i2++;
        }
        while (true) {
            i4++;
            bArr2[i4] = (byte) i;
            if (i4 == i3) {
                return new String(bArr2, 0);
            }
            int i5 = i;
            int i6 = i2 + 1;
            i = i5 + bArr[i2];
            i2 = i6;
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0027). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(int r5, short r6, int r7, java.lang.Object[] r8) {
        /*
            int r6 = r6 + 4
            int r5 = r5 + 65
            int r0 = 21 - r7
            byte[] r1 = com.google.android.datatransport.runtime.backends.TransportBackendDiscovery.$$a
            byte[] r0 = new byte[r0]
            int r7 = 20 - r7
            r2 = -1
            if (r1 != 0) goto L12
            r5 = r6
            r3 = r7
            goto L27
        L12:
            r4 = r6
            r6 = r5
            r5 = r4
        L15:
            int r2 = r2 + 1
            byte r3 = (byte) r6
            r0[r2] = r3
            if (r2 != r7) goto L25
            java.lang.String r5 = new java.lang.String
            r6 = 0
            r5.<init>(r0, r6)
            r8[r6] = r5
            return
        L25:
            r3 = r1[r5]
        L27:
            int r6 = r6 + r3
            int r5 = r5 + 1
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.backends.TransportBackendDiscovery.a(int, short, int, java.lang.Object[]):void");
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
    private static void c(short r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 + 4
            int r8 = r8 + 36
            byte[] r0 = com.google.android.datatransport.runtime.backends.TransportBackendDiscovery.$$d
            int r7 = 71 - r7
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L10
            r3 = r7
            r4 = r2
            goto L24
        L10:
            r3 = r2
        L11:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            int r6 = r6 + 1
            r1[r3] = r5
            if (r4 != r7) goto L22
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L22:
            r3 = r0[r6]
        L24:
            int r3 = -r3
            int r8 = r8 + r3
            int r8 = r8 + (-4)
            r3 = r4
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.backends.TransportBackendDiscovery.c(short, short, short, java.lang.Object[]):void");
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    private static void b(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        asBinder asbinder = new asBinder();
        asbinder.c = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        asbinder.d = 0;
        while (asbinder.d < cArr.length) {
            int i3 = $10 + 35;
            $11 = i3 % 128;
            if (i3 % 2 == 0) {
                int i4 = asbinder.d;
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr[asbinder.d]), asbinder, asbinder};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1562553046);
                    if (objAccessartificialFrame == null) {
                        int longPressTimeout = 11 - (ViewConfiguration.getLongPressTimeout() >> 16);
                        char pressedStateDuration = (char) (ViewConfiguration.getPressedStateDuration() >> 16);
                        int absoluteGravity = 1407 - Gravity.getAbsoluteGravity(0, 0);
                        byte b = (byte) ($$c[3] - 1);
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(longPressTimeout, pressedStateDuration, absoluteGravity, 1035473698, false, $$g(b, b2, b2), new Class[]{Integer.TYPE, Object.class, Object.class});
                    }
                    jArr[i4] = ((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue() % (extraCommand / (-2360974883025274865L));
                    Object[] objArr3 = {asbinder, asbinder};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                    if (objAccessartificialFrame2 == null) {
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(8 - Color.green(0), (char) Color.green(0), TextUtils.indexOf((CharSequence) "", '0', 0) + ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 378009232, false, "w", new Class[]{Object.class, Object.class});
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
                int i5 = asbinder.d;
                Object[] objArr4 = {Integer.valueOf(cArr[asbinder.d]), asbinder, asbinder};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1562553046);
                if (objAccessartificialFrame3 == null) {
                    int trimmedLength = 11 - TextUtils.getTrimmedLength("");
                    char c = (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1);
                    int iResolveSizeAndState = View.resolveSizeAndState(0, 0, 0) + 1407;
                    byte b3 = (byte) ($$c[3] - 1);
                    byte b4 = b3;
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(trimmedLength, c, iResolveSizeAndState, 1035473698, false, $$g(b3, b4, b4), new Class[]{Integer.TYPE, Object.class, Object.class});
                }
                jArr[i5] = ((Long) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).longValue() ^ (extraCommand ^ (-2360974883025274865L));
                Object[] objArr5 = {asbinder, asbinder};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(8 - Drawable.resolveOpacity(0, 0), (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), 249 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 378009232, false, "w", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
            }
        }
        char[] cArr2 = new char[length];
        asbinder.d = 0;
        int i6 = $10 + 81;
        $11 = i6 % 128;
        int i7 = i6 % 2;
        while (asbinder.d < cArr.length) {
            cArr2[asbinder.d] = (char) jArr[asbinder.d];
            Object[] objArr6 = {asbinder, asbinder};
            Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1981632360);
            if (objAccessartificialFrame5 == null) {
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(7 - TextUtils.lastIndexOf("", '0', 0), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), 249 - View.MeasureSpec.makeMeasureSpec(0, 0), 378009232, false, "w", new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame5).invoke(null, objArr6);
        }
        objArr[0] = new String(cArr2);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:16:0x025b A[Catch: all -> 0x0abd, TryCatch #2 {all -> 0x0abd, blocks: (B:51:0x079e, B:53:0x07b2, B:54:0x07e0, B:14:0x023b, B:16:0x025b, B:17:0x02ab), top: B:95:0x023b }] */
    /* JADX WARN: Code duplicated, block: B:20:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:25:0x039c  */
    /* JADX WARN: Code duplicated, block: B:50:0x0731  */
    /* JADX WARN: Code duplicated, block: B:53:0x07b2 A[Catch: all -> 0x0abd, TryCatch #2 {all -> 0x0abd, blocks: (B:51:0x079e, B:53:0x07b2, B:54:0x07e0, B:14:0x023b, B:16:0x025b, B:17:0x02ab), top: B:95:0x023b }] */
    /* JADX WARN: Code duplicated, block: B:57:0x07f6  */
    /* JADX WARN: Code duplicated, block: B:62:0x08c9  */
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
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 45;
        artificialFrame = i2 % 128;
        int i3 = i2 % 2;
        super.attachBaseContext(context);
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame7 == null) {
            int fadingEdgeLength = (ViewConfiguration.getFadingEdgeLength() >> 16) + 25;
            char defaultSize = (char) (30068 - View.getDefaultSize(0, 0));
            int fadingEdgeLength2 = (ViewConfiguration.getFadingEdgeLength() >> 16) + 816;
            byte[] bArr = $$a;
            Object[] objArr2 = new Object[1];
            a((byte) 47, (byte) (bArr[21] - 1), bArr[117], objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength, defaultSize, fadingEdgeLength2, 721586079, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 1880;
            Object[] objArr3 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 54085, new char[]{13749, 59091, 37730, 20381, 30751, 5296, 49606, 61989, 44787, 23318, 30688, 8196, 56641, 35314, 47646, 22166, 809, 15470, 59610, 34160, 45443, 25122}, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            b(11743 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), new char[]{13745, 6247, 28171, 48185, 33499, 53482, 9866, 29855, 23369, 43362, 65294, 52533, 5065, 25066, 46979}, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame8 == null) {
                    int tapTimeout = 25 - (ViewConfiguration.getTapTimeout() >> 16);
                    char minimumFlingVelocity = (char) ((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 30068);
                    int iResolveSize = 816 - View.resolveSize(0, 0);
                    byte[] bArr2 = $$a;
                    Object[] objArr5 = new Object[1];
                    a((byte) 47, bArr2[113], bArr2[117], objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(tapTimeout, minimumFlingVelocity, iResolveSize, 891606461, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i4 = ((int[]) objArr6[0])[0];
                int i5 = ((int[]) objArr6[1])[0];
                String[] strArr = (String[]) objArr6[2];
                int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) + 1149806139;
                int i6 = (-1213179131) + (((~(506918221 | iCodePointAt)) | 4260402 | (~((-308745856) | iCodePointAt))) * (-744)) + (((~iCodePointAt) | 202432768) * 744) + ((iCodePointAt | (-4260403)) * 744) + 1049394456;
                int i7 = (i6 << 13) ^ i6;
                int i8 = i7 ^ (i7 >>> 17);
                ((int[]) objArr[3])[0] = i8 ^ (i8 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) + 20734, new char[]{13758, 25796, 38720, 49638, 28734, 41613, 56595, 4013, 48699, 59651, 7149, 19062, 58603, 5917, 16799, 61478}, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 3338, new char[]{13757, 14511, 12175, 4839, 476, 29734, 31514, 28276, 23908, 17314, 46737, 42473, 43235, 40744, 33282, 61792}, objArr8);
                try {
                    Object[] objArr9 = {Integer.valueOf(((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue()), 0, 1049394456};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame == null) {
                        int i9 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 25;
                        char cCombineMeasuredStates = (char) (View.combineMeasuredStates(0, 0) + 30068);
                        int iIndexOf = 815 - TextUtils.indexOf((CharSequence) "", '0');
                        byte[] bArr3 = $$a;
                        byte b = bArr3[37];
                        Object[] objArr10 = new Object[1];
                        a(b, (byte) (b - 3), bArr3[53], objArr10);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i9, cCombineMeasuredStates, iIndexOf, -797394565, false, (String) objArr10[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr9);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame2 == null) {
                        int defaultSize2 = View.getDefaultSize(0, 0) + 25;
                        char capsMode = (char) (TextUtils.getCapsMode("", 0, 0) + 30068);
                        int scrollDefaultDelay = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 816;
                        byte[] bArr4 = $$a;
                        Object[] objArr11 = new Object[1];
                        a((byte) 47, bArr4[113], bArr4[117], objArr11);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(defaultSize2, capsMode, scrollDefaultDelay, 891606461, false, (String) objArr11[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArr);
                    try {
                        Object[] objArr12 = new Object[1];
                        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 54117, new char[]{13749, 59091, 37730, 20381, 30751, 5296, 49606, 61989, 44787, 23318, 30688, 8196, 56641, 35314, 47646, 22166, 809, 15470, 59610, 34160, 45443, 25122}, objArr12);
                        Class<?> cls3 = Class.forName((String) objArr12[0]);
                        Object[] objArr13 = new Object[1];
                        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 11739, new char[]{13745, 6247, 28171, 48185, 33499, 53482, 9866, 29855, 23369, 43362, 65294, 52533, 5065, 25066, 46979}, objArr13);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr13[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame3 == null) {
                            int iLastIndexOf = 24 - TextUtils.lastIndexOf("", '0');
                            char trimmedLength = (char) (30068 - TextUtils.getTrimmedLength(""));
                            int iAlpha = Color.alpha(0) + 816;
                            byte[] bArr5 = $$a;
                            Object[] objArr14 = new Object[1];
                            a((byte) 47, (byte) (bArr5[21] - 1), bArr5[117], objArr14);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, trimmedLength, iAlpha, 721586079, false, (String) objArr14[0], null);
                        }
                        ((Field) objAccessartificialFrame3).set(null, lValueOf);
                        int i10 = getARTIFICIAL_FRAME_PACKAGE_NAME + 81;
                        artificialFrame = i10 % 128;
                        int i11 = i10 % 2;
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
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) + 20734, new char[]{13758, 25796, 38720, 49638, 28734, 41613, 56595, 4013, 48699, 59651, 7149, 19062, 58603, 5917, 16799, 61478}, objArr15);
            Class<?> cls4 = Class.forName((String) objArr15[0]);
            Object[] objArr16 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 3338, new char[]{13757, 14511, 12175, 4839, 476, 29734, 31514, 28276, 23908, 17314, 46737, 42473, 43235, 40744, 33282, 61792}, objArr16);
            Object[] objArr17 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue()), 0, 1049394456};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame == null) {
                int i12 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 25;
                char cCombineMeasuredStates2 = (char) (View.combineMeasuredStates(0, 0) + 30068);
                int iIndexOf2 = 815 - TextUtils.indexOf((CharSequence) "", '0');
                byte[] bArr6 = $$a;
                byte b2 = bArr6[37];
                Object[] objArr18 = new Object[1];
                a(b2, (byte) (b2 - 3), bArr6[53], objArr18);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i12, cCombineMeasuredStates2, iIndexOf2, -797394565, false, (String) objArr18[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr17);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame2 == null) {
                int defaultSize3 = View.getDefaultSize(0, 0) + 25;
                char capsMode2 = (char) (TextUtils.getCapsMode("", 0, 0) + 30068);
                int scrollDefaultDelay2 = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 816;
                byte[] bArr7 = $$a;
                Object[] objArr19 = new Object[1];
                a((byte) 47, bArr7[113], bArr7[117], objArr19);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(defaultSize3, capsMode2, scrollDefaultDelay2, 891606461, false, (String) objArr19[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArr);
            Object[] objArr110 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 54117, new char[]{13749, 59091, 37730, 20381, 30751, 5296, 49606, 61989, 44787, 23318, 30688, 8196, 56641, 35314, 47646, 22166, 809, 15470, 59610, 34160, 45443, 25122}, objArr110);
            Class<?> cls5 = Class.forName((String) objArr110[0]);
            Object[] objArr111 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 11739, new char[]{13745, 6247, 28171, 48185, 33499, 53482, 9866, 29855, 23369, 43362, 65294, 52533, 5065, 25066, 46979}, objArr111);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr111[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame3 == null) {
                int iLastIndexOf2 = 24 - TextUtils.lastIndexOf("", '0');
                char trimmedLength2 = (char) (30068 - TextUtils.getTrimmedLength(""));
                int iAlpha2 = Color.alpha(0) + 816;
                byte[] bArr8 = $$a;
                Object[] objArr112 = new Object[1];
                a((byte) 47, (byte) (bArr8[21] - 1), bArr8[117], objArr112);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iLastIndexOf2, trimmedLength2, iAlpha2, 721586079, false, (String) objArr112[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
            int i13 = getARTIFICIAL_FRAME_PACKAGE_NAME + 81;
            artificialFrame = i13 % 128;
            int i14 = i13 % 2;
        }
        int i15 = ((int[]) objArr[1])[0];
        int i16 = ((int[]) objArr[0])[0];
        if (i16 == i15) {
            int i17 = artificialFrame + 3;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i17 % 128;
            int i18 = i17 % 2;
            Object[] objArr20 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i19 = ((int[]) objArr[3])[0];
            int i20 = ((int[]) objArr[0])[0];
            int i21 = ((int[]) objArr[1])[0];
            String[] strArr2 = (String[]) objArr[2];
            int i22 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1390174957;
            int i23 = ~i22;
            int i24 = (~((-1049400124) | i23)) | 201327378;
            int i25 = ~(i22 | (-3155013));
            int i26 = i19 + (-1814698983) + ((i24 | i25) * (-502)) + ((i25 | (~(i23 | (-848072746)))) * TypedValues.PositionType.TYPE_DRAWPATH);
            int i27 = (i26 << 13) ^ i26;
            int i28 = i27 ^ (i27 >>> 17);
            ((int[]) objArr20[3])[0] = i28 ^ (i28 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr[2];
            if (strArr3 != null) {
                int i29 = artificialFrame + 43;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i29 % 128;
                int i30 = i29 % 2;
                int i31 = 0;
                while (i31 < strArr3.length) {
                    arrayList.add(strArr3[i31]);
                    i31++;
                    int i32 = getARTIFICIAL_FRAME_PACKAGE_NAME + 57;
                    artificialFrame = i32 % 128;
                    int i33 = i32 % 2;
                }
            }
            long j3 = ((long) (i15 ^ i16)) ^ (((long) (-416268655)) << 32);
            long j4 = -416268656;
            int i34 = getARTIFICIAL_FRAME_PACKAGE_NAME + 95;
            artificialFrame = i34 % 128;
            int i35 = i34 % 2;
            try {
                Object[] objArr21 = {Long.valueOf(j3), Long.valueOf(j4)};
                byte[] bArr9 = $$d;
                Object[] objArr22 = new Object[1];
                c(bArr9[24], bArr9[197], (byte) (-bArr9[51]), objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                c(bArr9[493], bArr9[635], bArr9[28], objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i36 = ((int[]) objArr[3])[0];
                int i37 = ((int[]) objArr[0])[0];
                int i38 = ((int[]) objArr[1])[0];
                String[] strArr4 = (String[]) objArr[2];
                int iIdentityHashCode = System.identityHashCode(this);
                int i39 = ~((-942865624) | (~iIdentityHashCode));
                int i40 = i36 + (((-1014234848) | i39 | (~(942865623 | iIdentityHashCode))) * (-338)) + 984177421 + (((~(iIdentityHashCode | (-71369225))) | i39) * 338);
                int i41 = (i40 << 13) ^ i40;
                int i42 = i41 ^ (i41 >>> 17);
                ((int[]) objArr24[3])[0] = i42 ^ (i42 << 5);
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
            int iLastIndexOf3 = 25 - TextUtils.lastIndexOf("", '0');
            char packedPositionGroup = (char) ExpandableListView.getPackedPositionGroup(0L);
            int iIndexOf3 = TextUtils.indexOf((CharSequence) "", '0', 0) + 1042;
            byte[] bArr10 = $$a;
            Object[] objArr25 = new Object[1];
            a((byte) 47, (byte) (bArr10[21] - 1), bArr10[117], objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(iLastIndexOf3, packedPositionGroup, iIndexOf3, 2061780482, false, (String) objArr25[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j5 != -1) {
            int i43 = getARTIFICIAL_FRAME_PACKAGE_NAME + 11;
            artificialFrame = i43 % 128;
            int i44 = i43 % 2;
            long j6 = j5 + 4611686018427387817L;
            Object[] objArr26 = new Object[1];
            b(View.MeasureSpec.makeMeasureSpec(0, 0) + 54121, new char[]{13749, 59091, 37730, 20381, 30751, 5296, 49606, 61989, 44787, 23318, 30688, 8196, 56641, 35314, 47646, 22166, 809, 15470, 59610, 34160, 45443, 25122}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 11739, new char[]{13745, 6247, 28171, 48185, 33499, 53482, 9866, 29855, 23369, 43362, 65294, 52533, 5065, 25066, 46979}, objArr27);
            if (j6 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame10 == null) {
                    int iIndexOf4 = 26 - TextUtils.indexOf("", "", 0, 0);
                    char cRed = (char) Color.red(0);
                    int offsetAfter = 1041 - TextUtils.getOffsetAfter("", 0);
                    byte[] bArr11 = $$a;
                    Object[] objArr28 = new Object[1];
                    a((byte) 47, bArr11[113], bArr11[117], objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iIndexOf4, cRed, offsetAfter, 1145017376, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i45 = ((int[]) objArr29[3])[0];
                int i46 = ((int[]) objArr29[2])[0];
                String[] strArr5 = (String[]) objArr29[0];
                int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 1304391590;
                int i47 = ~length;
                int i48 = 1491392654 + (((~((-899942053) | i47)) | 83887616 | (~(821838245 | i47))) * (-1136)) + (((~((-899942053) | length)) | (~(821838245 | length)) | (~((-5783810) | i47))) * (-568)) + (((~(length | (-83887617))) | (~(i47 | (-821838246))) | (~(899942052 | i47))) * 568) + 2071458114;
                int i49 = (i48 << 13) ^ i48;
                int i50 = i49 ^ (i49 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i50 ^ (i50 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 20845, new char[]{13758, 25796, 38720, 49638, 28734, 41613, 56595, 4013, 48699, 59651, 7149, 19062, 58603, 5917, 16799, 61478}, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                b(TextUtils.getCapsMode("", 0, 0) + 3359, new char[]{13757, 14511, 12175, 4839, 476, 29734, 31514, 28276, 23908, 17314, 46737, 42473, 43235, 40744, 33282, 61792}, objArr31);
                int iIntValue = ((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue();
                Object[] objArr32 = {-1594756574};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(9 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) (22251 - TextUtils.getOffsetAfter("", 0)), 1033 - View.resolveSize(0, 0), 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = SchemaManager$$ExternalSyntheticLambda5.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr32), 2071458114, false);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame5 == null) {
                    int maxKeyCode = (KeyEvent.getMaxKeyCode() >> 16) + 26;
                    char cIndexOf = (char) TextUtils.indexOf("", "");
                    int absoluteGravity = Gravity.getAbsoluteGravity(0, 0) + 1041;
                    byte[] bArr12 = $$a;
                    Object[] objArr33 = new Object[1];
                    a((byte) 47, bArr12[113], bArr12[117], objArr33);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(maxKeyCode, cIndexOf, absoluteGravity, 1145017376, false, (String) objArr33[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Object[] objArr34 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 54117, new char[]{13749, 59091, 37730, 20381, 30751, 5296, 49606, 61989, 44787, 23318, 30688, 8196, 56641, 35314, 47646, 22166, 809, 15470, 59610, 34160, 45443, 25122}, objArr34);
                    Class<?> cls9 = Class.forName((String) objArr34[0]);
                    Object[] objArr35 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 11722, new char[]{13745, 6247, 28171, 48185, 33499, 53482, 9866, 29855, 23369, 43362, 65294, 52533, 5065, 25066, 46979}, objArr35);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr35[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame6 == null) {
                        int iMyPid = (Process.myPid() >> 22) + 26;
                        char c = (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)));
                        int iGreen = 1041 - Color.green(0);
                        byte[] bArr13 = $$a;
                        Object[] objArr36 = new Object[1];
                        a((byte) 47, (byte) (bArr13[21] - 1), bArr13[117], objArr36);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iMyPid, c, iGreen, 2061780482, false, (String) objArr36[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr37 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 20845, new char[]{13758, 25796, 38720, 49638, 28734, 41613, 56595, 4013, 48699, 59651, 7149, 19062, 58603, 5917, 16799, 61478}, objArr37);
            Class<?> cls10 = Class.forName((String) objArr37[0]);
            Object[] objArr38 = new Object[1];
            b(TextUtils.getCapsMode("", 0, 0) + 3359, new char[]{13757, 14511, 12175, 4839, 476, 29734, 31514, 28276, 23908, 17314, 46737, 42473, 43235, 40744, 33282, 61792}, objArr38);
            int iIntValue2 = ((Integer) cls10.getMethod((String) objArr38[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr39 = {-1594756574};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(9 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) (22251 - TextUtils.getOffsetAfter("", 0)), 1033 - View.resolveSize(0, 0), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = SchemaManager$$ExternalSyntheticLambda5.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr39), 2071458114, false);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame5 == null) {
                int maxKeyCode2 = (KeyEvent.getMaxKeyCode() >> 16) + 26;
                char cIndexOf2 = (char) TextUtils.indexOf("", "");
                int absoluteGravity2 = Gravity.getAbsoluteGravity(0, 0) + 1041;
                byte[] bArr14 = $$a;
                Object[] objArr310 = new Object[1];
                a((byte) 47, bArr14[113], bArr14[117], objArr310);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(maxKeyCode2, cIndexOf2, absoluteGravity2, 1145017376, false, (String) objArr310[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr311 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 54117, new char[]{13749, 59091, 37730, 20381, 30751, 5296, 49606, 61989, 44787, 23318, 30688, 8196, 56641, 35314, 47646, 22166, 809, 15470, 59610, 34160, 45443, 25122}, objArr311);
            Class<?> cls11 = Class.forName((String) objArr311[0]);
            Object[] objArr312 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 11722, new char[]{13745, 6247, 28171, 48185, 33499, 53482, 9866, 29855, 23369, 43362, 65294, 52533, 5065, 25066, 46979}, objArr312);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr312[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame6 == null) {
                int iMyPid2 = (Process.myPid() >> 22) + 26;
                char c2 = (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)));
                int iGreen2 = 1041 - Color.green(0);
                byte[] bArr15 = $$a;
                Object[] objArr313 = new Object[1];
                a((byte) 47, (byte) (bArr15[21] - 1), bArr15[117], objArr313);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iMyPid2, c2, iGreen2, 2061780482, false, (String) objArr313[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i51 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i52 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i52 == i51) {
            Object[] objArr40 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i53 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i54 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i55 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr6 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
            int i56 = i53 + 790277148 + (((~(iFreeMemory | (-107344828))) | (-185448635)) * (-465)) + (((-107344828) | (~((-185448635) | iFreeMemory))) * 930) + ((iFreeMemory | (-33927355)) * 465);
            int i57 = (i56 << 13) ^ i56;
            int i58 = i57 ^ (i57 >>> 17);
            ((int[]) objArr40[1])[0] = i58 ^ (i58 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        if (strArr7 != null) {
            for (String str : strArr7) {
                arrayList2.add(str);
            }
        }
        Object[] objArr41 = {Long.valueOf(((long) (i51 ^ i52)) ^ (((long) 1707647259) << 32)), Long.valueOf(1707647257)};
        byte[] bArr16 = $$d;
        Object[] objArr42 = new Object[1];
        c((short) (-bArr16[92]), (byte) (-bArr16[4]), (byte) (-bArr16[116]), objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        Object[] objArr43 = new Object[1];
        c(bArr16[493], bArr16[635], bArr16[28], objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {strArr, new int[1], new int[]{i}, new int[]{i}};
        int i59 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
        int i60 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        int i61 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        String[] strArr8 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        int length2 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 7685080;
        int i62 = ~length2;
        int i63 = i59 + (-925373128) + (((~((-836989556) | i62)) | (~(758885748 | i62))) * (-867)) + (((~((-836989556) | length2)) | 281039363 | (~(758885748 | length2))) * (-1734)) + (((~(length2 | 1039925111)) | (~(i62 | (-281039364))) | (~((-555950193) | length2))) * 867);
        int i64 = (i63 << 13) ^ i63;
        int i65 = i64 ^ (i64 >>> 17);
        ((int[]) objArr44[1])[0] = i65 ^ (i65 << 5);
    }

    /* JADX WARN: Code duplicated, block: B:124:0x0e67  */
    /* JADX WARN: Code duplicated, block: B:126:0x0e6d  */
    /* JADX WARN: Code duplicated, block: B:128:0x0eff  */
    /* JADX WARN: Code duplicated, block: B:130:0x0f0b  */
    /* JADX WARN: Code duplicated, block: B:133:0x0f13  */
    /* JADX WARN: Code duplicated, block: B:135:0x0f17  */
    /* JADX WARN: Code duplicated, block: B:138:0x0f21  */
    /* JADX WARN: Code duplicated, block: B:144:0x0fc3  */
    /* JADX WARN: Code duplicated, block: B:149:0x102c  */
    /* JADX WARN: Code duplicated, block: B:242:0x195a  */
    /* JADX WARN: Code duplicated, block: B:245:0x198c A[Catch: all -> 0x2514, TryCatch #2 {all -> 0x2514, blocks: (B:324:0x2218, B:326:0x221e, B:327:0x2244, B:329:0x226e, B:330:0x22e9, B:243:0x1978, B:245:0x198c, B:246:0x19bd, B:155:0x1116, B:157:0x1123, B:158:0x1155, B:160:0x115f, B:162:0x116c, B:163:0x119a, B:15:0x01d4, B:17:0x01f6, B:18:0x0249), top: B:377:0x01d4 }] */
    /* JADX WARN: Code duplicated, block: B:249:0x19d3  */
    /* JADX WARN: Code duplicated, block: B:254:0x1a39  */
    @Override // android.app.Service
    public void onCreate() throws Throwable {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Context baseContext;
        Object[] objArr4;
        Object objAccessartificialFrame;
        Object objAccessartificialFrame2;
        int i;
        Object[] objArr5;
        Object[] objArr6;
        Object objAccessartificialFrame3;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object objAccessartificialFrame4;
        Object objAccessartificialFrame5;
        Object[] objArr7;
        Object[] objArr8;
        int i2 = 2 % 2;
        Object[] objArr9 = new Object[1];
        b(54121 - (ViewConfiguration.getFadingEdgeLength() >> 16), new char[]{13749, 59091, 37730, 20381, 30751, 5296, 49606, 61989, 44787, 23318, 30688, 8196, 56641, 35314, 47646, 22166, 809, 15470, 59610, 34160, 45443, 25122}, objArr9);
        String str = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        b(ExpandableListView.getPackedPositionGroup(0L) + 11743, new char[]{13745, 6247, 28171, 48185, 33499, 53482, 9866, 29855, 23369, 43362, 65294, 52533, 5065, 25066, 46979}, objArr10);
        String str2 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        b(20849 - (Process.myPid() >> 22), new char[]{13758, 25796, 38720, 49638, 28734, 41613, 56595, 4013, 48699, 59651, 7149, 19062, 58603, 5917, 16799, 61478}, objArr11);
        String str3 = (String) objArr11[0];
        Object[] objArr12 = new Object[1];
        b(3360 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), new char[]{13757, 14511, 12175, 4839, 476, 29734, 31514, 28276, 23908, 17314, 46737, 42473, 43235, 40744, 33282, 61792}, objArr12);
        String str4 = (String) objArr12[0];
        Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame6 == null) {
            int windowTouchSlop = (ViewConfiguration.getWindowTouchSlop() >> 8) + 25;
            char cLastIndexOf = (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 30069);
            int iBlue = 816 - Color.blue(0);
            byte[] bArr = $$a;
            Object[] objArr13 = new Object[1];
            a((byte) 47, (byte) (bArr[21] - 1), bArr[117], objArr13);
            objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(windowTouchSlop, cLastIndexOf, iBlue, 721586079, false, (String) objArr13[0], null);
        }
        long j = ((Field) objAccessartificialFrame6).getLong(null);
        if (j == -1 || j + 1956 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            try {
                Object[] objArr14 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1015074014};
                Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame7 == null) {
                    int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 25;
                    char pressedStateDuration = (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 30068);
                    int i3 = 817 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                    byte[] bArr2 = $$a;
                    byte b = bArr2[37];
                    Object[] objArr15 = new Object[1];
                    a(b, (byte) (b - 3), bArr2[53], objArr15);
                    objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay, pressedStateDuration, i3, -797394565, false, (String) objArr15[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr = (Object[]) ((Method) objAccessartificialFrame7).invoke(null, objArr14);
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame8 == null) {
                    int bitsPerPixel = 24 - ImageFormat.getBitsPerPixel(0);
                    char keyRepeatDelay2 = (char) ((ViewConfiguration.getKeyRepeatDelay() >> 16) + 30068);
                    int i4 = 817 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                    byte[] bArr3 = $$a;
                    Object[] objArr16 = new Object[1];
                    a((byte) 47, bArr3[113], bArr3[117], objArr16);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(bitsPerPixel, keyRepeatDelay2, i4, 891606461, false, (String) objArr16[0], null);
                }
                ((Field) objAccessartificialFrame8).set(null, objArr);
                try {
                    Long lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame9 == null) {
                        int scrollBarFadeDuration = 25 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                        char cResolveSize = (char) (30068 - View.resolveSize(0, 0));
                        int iAxisFromString = 815 - MotionEvent.axisFromString("");
                        byte[] bArr4 = $$a;
                        Object[] objArr17 = new Object[1];
                        a((byte) 47, (byte) (bArr4[21] - 1), bArr4[117], objArr17);
                        objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration, cResolveSize, iAxisFromString, 721586079, false, (String) objArr17[0], null);
                    }
                    ((Field) objAccessartificialFrame9).set(null, lValueOf);
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
            Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame10 == null) {
                int iIndexOf = TextUtils.indexOf((CharSequence) "", '0') + 26;
                char keyRepeatTimeout = (char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 30068);
                int iIndexOf2 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 817;
                byte[] bArr5 = $$a;
                Object[] objArr18 = new Object[1];
                a((byte) 47, bArr5[113], bArr5[117], objArr18);
                objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iIndexOf, keyRepeatTimeout, iIndexOf2, 891606461, false, (String) objArr18[0], null);
            }
            Object[] objArr19 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
            objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i5 = ((int[]) objArr19[0])[0];
            int i6 = ((int[]) objArr19[1])[0];
            String[] strArr = (String[]) objArr19[2];
            int layoutDirection = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().getLayoutDirection();
            int i7 = ~(859692719 | layoutDirection);
            int i8 = ~layoutDirection;
            int i9 = (-941215889) + ((i7 | (~((-3162755) | i8))) * (-406)) + ((~(1061027839 | i8)) * (-406)) + (((~(layoutDirection | (-1057865086))) | (~((-859692720) | i8))) * 406) + 1015074014;
            int i10 = (i9 << 13) ^ i9;
            int i11 = i10 ^ (i10 >>> 17);
            ((int[]) objArr[3])[0] = i11 ^ (i11 << 5);
        }
        int i12 = ((int[]) objArr[1])[0];
        int i13 = ((int[]) objArr[0])[0];
        if (i13 == i12) {
            Object[] objArr20 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i14 = ((int[]) objArr[3])[0];
            int i15 = ((int[]) objArr[0])[0];
            int i16 = ((int[]) objArr[1])[0];
            String[] strArr2 = (String[]) objArr[2];
            int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(9) + 1076865128;
            int i17 = ~iCodePointAt;
            int i18 = i14 + 525994198 + (((~((-33998055) | i17)) | 164174311) * (-90)) + (((~((-33998055) | iCodePointAt)) | (-198172136)) * (-45)) + (((~(iCodePointAt | (-164174312))) | (-33998055) | (~(i17 | 164174311))) * 45);
            int i19 = (i18 << 13) ^ i18;
            int i20 = i19 ^ (i19 >>> 17);
            ((int[]) objArr20[3])[0] = i20 ^ (i20 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr[2];
            if (strArr3 != null) {
                for (String str5 : strArr3) {
                    arrayList.add(str5);
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf((((long) 1365491724) << 32) ^ ((long) (i12 ^ i13))), Long.valueOf(1365491725)};
                byte[] bArr6 = $$d;
                Object[] objArr22 = new Object[1];
                c(bArr6[24], bArr6[197], (byte) (-bArr6[51]), objArr22);
                Class<?> cls = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                c(bArr6[493], bArr6[635], bArr6[28], objArr23);
                cls.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i21 = ((int[]) objArr[3])[0];
                int i22 = ((int[]) objArr[0])[0];
                int i23 = ((int[]) objArr[1])[0];
                String[] strArr4 = (String[]) objArr[2];
                int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
                int i24 = (~(823982909 | iElapsedRealtime)) | 216006658;
                int i25 = ~iElapsedRealtime;
                int i26 = i21 + (-1114461307) + ((i24 | (~((-17834293) | i25))) * 886) + (((~(i25 | (-823982910))) | 1022155275) * (-1772)) + ((~(i25 | 1022155275)) * 886);
                int i27 = (i26 << 13) ^ i26;
                int i28 = i27 ^ (i27 >>> 17);
                ((int[]) objArr24[3])[0] = i28 ^ (i28 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame11 == null) {
            int iRgb = (-16777186) - Color.rgb(0, 0, 0);
            char packedPositionGroup = (char) (ExpandableListView.getPackedPositionGroup(0L) + 49362);
            int iLastIndexOf = TextUtils.lastIndexOf("", '0') + 685;
            byte[] bArr7 = $$a;
            Object[] objArr25 = new Object[1];
            a((byte) (bArr7[115] + 1), bArr7[20], bArr7[4], objArr25);
            objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(iRgb, packedPositionGroup, iLastIndexOf, 752929587, false, (String) objArr25[0], null);
        }
        long j2 = ((Field) objAccessartificialFrame11).getLong(null);
        if (j2 == -1 || j2 + 2018 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext2 = getBaseContext();
            if (baseContext2 == null) {
                Object[] objArr26 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 49822, new char[]{13749, 63241, 45270, 32191, 16247, 63682, 42370, 26399, 8237, 60911, 44890, 26699, 5617, 54944, 36970, 24000, 7826, 55390, 34102, 18148, '|', 52499, 36548, 19364, 30077, 14027}, objArr26);
                Class<?> cls2 = Class.forName((String) objArr26[0]);
                Object[] objArr27 = new Object[1];
                b((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 63197, new char[]{13751, 50044, 55324, 53553, 61125, 59371, 64654, 62878, 33612, 39009, 37146, 44738, 42987, 48268, 46518, 17230, 22635, 20759}, objArr27);
                baseContext2 = (Context) cls2.getMethod((String) objArr27[0], new Class[0]).invoke(null, null);
            }
            if (baseContext2 != null) {
                baseContext2 = ((baseContext2 instanceof ContextWrapper) && ((ContextWrapper) baseContext2).getBaseContext() == null) ? null : baseContext2.getApplicationContext();
            }
            int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            int i29 = artificialFrame + 125;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i29 % 128;
            int i30 = i29 % 2;
            try {
                Object[] objArr28 = {baseContext2, Integer.valueOf(iIntValue), 0, -1020729778};
                byte[] bArr8 = $$d;
                Object[] objArr29 = new Object[1];
                c((short) 93, bArr8[445], (byte) (-bArr8[51]), objArr29);
                Class<?> cls3 = Class.forName((String) objArr29[0]);
                Object[] objArr30 = new Object[1];
                c((short) 149, bArr8[13], bArr8[488], objArr30);
                objArr2 = (Object[]) cls3.getMethod((String) objArr30[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr28);
                if (baseContext2 != null) {
                    Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-326560385);
                    if (objAccessartificialFrame12 == null) {
                        int offsetBefore = 30 - TextUtils.getOffsetBefore("", 0);
                        char size = (char) (View.MeasureSpec.getSize(0) + 49362);
                        int iMyTid = 684 - (Process.myTid() >> 22);
                        byte[] bArr9 = $$a;
                        byte b2 = (byte) (bArr9[15] - 1);
                        Object[] objArr31 = new Object[1];
                        a(b2, (byte) (b2 + 4), bArr9[4], objArr31);
                        objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(offsetBefore, size, iMyTid, 1944867703, false, (String) objArr31[0], null);
                    }
                    ((Field) objAccessartificialFrame12).set(null, objArr2);
                    try {
                        Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                        if (objAccessartificialFrame13 == null) {
                            int iLastIndexOf2 = TextUtils.lastIndexOf("", '0', 0, 0) + 31;
                            char cMyTid = (char) ((Process.myTid() >> 22) + 49362);
                            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0) + 684;
                            byte[] bArr10 = $$a;
                            Object[] objArr32 = new Object[1];
                            a((byte) (bArr10[115] + 1), bArr10[20], bArr10[4], objArr32);
                            objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(iLastIndexOf2, cMyTid, iMakeMeasureSpec, 752929587, false, (String) objArr32[0], null);
                        }
                        ((Field) objAccessartificialFrame13).set(null, lValueOf2);
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
            Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-326560385);
            if (objAccessartificialFrame14 == null) {
                int mirror = AndroidCharacter.getMirror('0') - 18;
                char cMyTid2 = (char) ((Process.myTid() >> 22) + 49362);
                int iIndexOf3 = 684 - TextUtils.indexOf("", "", 0, 0);
                byte[] bArr11 = $$a;
                byte b3 = (byte) (bArr11[15] - 1);
                Object[] objArr33 = new Object[1];
                a(b3, (byte) (b3 + 4), bArr11[4], objArr33);
                objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(mirror, cMyTid2, iIndexOf3, 1944867703, false, (String) objArr33[0], null);
            }
            Object[] objArr34 = (Object[]) ((Field) objAccessartificialFrame14).get(null);
            objArr2 = new Object[]{new int[]{((int[]) objArr34[0])[0]}, new int[]{((int[]) objArr34[1])[0]}, new int[1], (String) objArr34[3]};
            int iIdentityHashCode = System.identityHashCode(this);
            int i31 = ((((-618787690) + (((~(iIdentityHashCode | 881345770)) | (-97278005)) * (-465))) + ((881345770 | (~((-97278005) | iIdentityHashCode))) * 930)) + ((iIdentityHashCode | (-21239829)) * 465)) - 1020729778;
            int i32 = (i31 << 13) ^ i31;
            int i33 = i32 ^ (i32 >>> 17);
            ((int[]) objArr2[2])[0] = i33 ^ (i33 << 5);
        }
        int i34 = ((int[]) objArr2[1])[0];
        int i35 = ((int[]) objArr2[0])[0];
        if (i35 == i34) {
            int i36 = getARTIFICIAL_FRAME_PACKAGE_NAME + 121;
            artificialFrame = i36 % 128;
            int i37 = i36 % 2;
            int i38 = ((int[]) objArr2[2])[0];
            Object[] objArr35 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i39 = ~iIdentityHashCode2;
            int i40 = i38 + (-120974004) + (((~((-936580166) | i39)) | 42043609) * 519) + (((~(i39 | (-894571525))) | (~(936615133 | iIdentityHashCode2))) * (-519)) + (((~(iIdentityHashCode2 | 42043609)) | 936580165) * 519);
            int i41 = (i40 << 13) ^ i40;
            int i42 = i41 ^ (i41 >>> 17);
            ((int[]) objArr35[2])[0] = i42 ^ (i42 << 5);
        } else {
            Object[] objArr36 = {Long.valueOf((((long) (-1869392651)) << 32) ^ ((long) (i34 ^ i35))), Long.valueOf(-1869392655)};
            byte b4 = (byte) ($$e << 1);
            byte[] bArr12 = $$d;
            Object[] objArr37 = new Object[1];
            c((short) 168, b4, (byte) (-bArr12[51]), objArr37);
            Class<?> cls4 = Class.forName((String) objArr37[0]);
            Object[] objArr38 = new Object[1];
            c(bArr12[493], bArr12[635], bArr12[28], objArr38);
            cls4.getMethod((String) objArr38[0], Long.TYPE, Long.TYPE).invoke(null, objArr36);
            int i43 = ((int[]) objArr2[2])[0];
            Object[] objArr39 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int iIdentityHashCode3 = System.identityHashCode(this);
            int i44 = ~((-16908291) | iIdentityHashCode3);
            int i45 = i43 + 1642414710 + ((72441052 | i44) * (-476)) + (i44 * 952) + ((~((~iIdentityHashCode3) | (-16908291))) * 476);
            int i46 = (i45 << 13) ^ i45;
            int i47 = i46 ^ (i46 >>> 17);
            ((int[]) objArr39[2])[0] = i47 ^ (i47 << 5);
        }
        Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame15 == null) {
            int keyRepeatTimeout2 = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 30;
            char cRed = (char) (Color.red(0) + 49362);
            int maximumDrawingCacheSize = 684 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
            byte[] bArr13 = $$a;
            Object[] objArr40 = new Object[1];
            a((byte) (bArr13[15] - 1), (byte) 57, bArr13[113], objArr40);
            objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout2, cRed, maximumDrawingCacheSize, -1583976536, false, (String) objArr40[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame15).getLong(null);
        if (j3 == -1 || j3 + 2045 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr41 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -1686016689};
            byte[] bArr14 = $$d;
            Object[] objArr42 = new Object[1];
            c((short) 202, bArr14[445], (byte) (-bArr14[51]), objArr42);
            Class<?> cls5 = Class.forName((String) objArr42[0]);
            Object[] objArr43 = new Object[1];
            c((short) 258, bArr14[574], (byte) (-bArr14[51]), objArr43);
            objArr3 = (Object[]) cls5.getMethod((String) objArr43[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr41);
            Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame16 == null) {
                int size2 = 30 - View.MeasureSpec.getSize(0);
                char cKeyCodeFromString = (char) (KeyEvent.keyCodeFromString("") + 49362);
                int i48 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 683;
                byte[] bArr15 = $$a;
                Object[] objArr44 = new Object[1];
                a((byte) (bArr15[15] + 1), (byte) 69, bArr15[117], objArr44);
                objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(size2, cKeyCodeFromString, i48, -1456483158, false, (String) objArr44[0], null);
            }
            ((Field) objAccessartificialFrame16).set(null, objArr3);
            try {
                Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame17 == null) {
                    int iIndexOf4 = 29 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                    char maximumFlingVelocity = (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 49362);
                    int iArgb = 684 - Color.argb(0, 0, 0, 0);
                    byte[] bArr16 = $$a;
                    Object[] objArr45 = new Object[1];
                    a((byte) (bArr16[15] - 1), (byte) 57, bArr16[113], objArr45);
                    objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(iIndexOf4, maximumFlingVelocity, iArgb, -1583976536, false, (String) objArr45[0], null);
                }
                ((Field) objAccessartificialFrame17).set(null, lValueOf3);
            } catch (Exception unused3) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame18 == null) {
                int iMyPid = 30 - (Process.myPid() >> 22);
                char fadingEdgeLength = (char) (49362 - (ViewConfiguration.getFadingEdgeLength() >> 16));
                int trimmedLength = TextUtils.getTrimmedLength("") + 684;
                byte[] bArr17 = $$a;
                Object[] objArr46 = new Object[1];
                a((byte) (bArr17[15] + 1), (byte) 69, bArr17[117], objArr46);
                objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(iMyPid, fadingEdgeLength, trimmedLength, -1456483158, false, (String) objArr46[0], null);
            }
            Object[] objArr47 = (Object[]) ((Field) objAccessartificialFrame18).get(null);
            objArr3 = new Object[]{new int[]{((int[]) objArr47[0])[0]}, new int[]{((int[]) objArr47[1])[0]}, new int[1], (String) objArr47[3]};
            int iIdentityHashCode4 = System.identityHashCode(this);
            int i49 = ~((-50339105) | iIdentityHashCode4);
            int i50 = ~iIdentityHashCode4;
            int i51 = (((-817356544) + ((i49 | (~((-336855259) | i50))) * 497)) + (((~(iIdentityHashCode4 | (-336855259))) | ((~((-591429413) | i50)) | 541090308)) * 497)) - 1686016689;
            int i52 = (i51 << 13) ^ i51;
            int i53 = i52 ^ (i52 >>> 17);
            ((int[]) objArr3[2])[0] = i53 ^ (i53 << 5);
        }
        int i54 = ((int[]) objArr3[1])[0];
        int i55 = ((int[]) objArr3[0])[0];
        if (i55 == i54) {
            int i56 = ((int[]) objArr3[2])[0];
            Object[] objArr48 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
            int i57 = ~(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(5) - 848658370);
            int i58 = i56 + 363853591 + (((~(15399465 | i57)) | (-994023241)) * (-983)) + (((~(i57 | (-994023241))) | 2789896) * 983);
            int i59 = (i58 << 13) ^ i58;
            int i60 = i59 ^ (i59 >>> 17);
            ((int[]) objArr48[2])[0] = i60 ^ (i60 << 5);
        } else {
            new ArrayList().add((String) objArr3[3]);
            long j4 = (((long) (-617788979)) << 32) ^ ((long) (i54 ^ i55));
            long j5 = -617788963;
            int i61 = artificialFrame + 123;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i61 % 128;
            int i62 = i61 % 2;
            Object[] objArr49 = {Long.valueOf(j4), Long.valueOf(j5)};
            byte b5 = (byte) ($$e << 1);
            byte[] bArr18 = $$d;
            Object[] objArr50 = new Object[1];
            c((short) 168, b5, (byte) (-bArr18[51]), objArr50);
            Class<?> cls6 = Class.forName((String) objArr50[0]);
            Object[] objArr51 = new Object[1];
            c(bArr18[493], bArr18[635], bArr18[28], objArr51);
            cls6.getMethod((String) objArr51[0], Long.TYPE, Long.TYPE).invoke(null, objArr49);
            int i63 = ((int[]) objArr3[2])[0];
            Object[] objArr52 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
            int iElapsedRealtime2 = (int) SystemClock.elapsedRealtime();
            int i64 = ~iElapsedRealtime2;
            int i65 = ~(486850291 | i64);
            int i66 = i63 + 188969182 + ((4931592 | i65) * (-712)) + (((~(iElapsedRealtime2 | 491781883)) | (~(i64 | (-4931593)))) * (-712)) + (((-491773484) | i65) * 712);
            int i67 = (i66 << 13) ^ i66;
            int i68 = i67 ^ (i67 >>> 17);
            ((int[]) objArr52[2])[0] = i68 ^ (i68 << 5);
        }
        Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame19 == null) {
            int i69 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 16;
            char c = (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
            int maximumDrawingCacheSize2 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 747;
            byte[] bArr19 = $$a;
            Object[] objArr53 = new Object[1];
            a((byte) 47, (byte) (bArr19[21] - 1), bArr19[117], objArr53);
            objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(i69, c, maximumDrawingCacheSize2, -144068856, false, (String) objArr53[0], null);
        }
        long j6 = ((Field) objAccessartificialFrame19).getLong(null);
        if (j6 != -1) {
            int i70 = getARTIFICIAL_FRAME_PACKAGE_NAME + 37;
            artificialFrame = i70 % 128;
            int i71 = i70 % 2;
            if (j6 + 4611686018427387799L >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(1575402270);
                if (objAccessartificialFrame20 == null) {
                    int keyRepeatTimeout3 = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 17;
                    char cIndexOf = (char) TextUtils.indexOf("", "", 0);
                    int size3 = 747 - View.MeasureSpec.getSize(0);
                    byte[] bArr20 = $$a;
                    Object[] objArr54 = new Object[1];
                    a((byte) 47, bArr20[113], bArr20[117], objArr54);
                    objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout3, cIndexOf, size3, -1031537386, false, (String) objArr54[0], null);
                }
                Object[] objArr55 = (Object[]) ((Field) objAccessartificialFrame20).get(null);
                objArr4 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
                int i72 = ((int[]) objArr55[3])[0];
                int i73 = ((int[]) objArr55[4])[0];
                List list = (List) objArr55[0];
                List list2 = (List) objArr55[2];
                int i74 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().densityDpi;
                int i75 = (((328252997 + (((~(i74 | 153658334)) | (-451790124)) * (-668))) + ((153658334 | (~((-451790124) | i74))) * 1336)) + ((i74 | (-314917922)) * 668)) - 1579870343;
                int i76 = (i75 << 13) ^ i75;
                int i77 = i76 ^ (i76 >>> 17);
                ((int[]) objArr4[1])[0] = i77 ^ (i77 << 5);
            } else {
                baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr56 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) + 49806, new char[]{13749, 63241, 45270, 32191, 16247, 63682, 42370, 26399, 8237, 60911, 44890, 26699, 5617, 54944, 36970, 24000, 7826, 55390, 34102, 18148, '|', 52499, 36548, 19364, 30077, 14027}, objArr56);
                    Class<?> cls7 = Class.forName((String) objArr56[0]);
                    Object[] objArr57 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 63193, new char[]{13751, 50044, 55324, 53553, 61125, 59371, 64654, 62878, 33612, 39009, 37146, 44738, 42987, 48268, 46518, 17230, 22635, 20759}, objArr57);
                    baseContext = (Context) cls7.getMethod((String) objArr57[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    i = getARTIFICIAL_FRAME_PACKAGE_NAME + 73;
                    artificialFrame = i % 128;
                    if (i % 2 == 0) {
                        int i78 = 45 / 0;
                        if (baseContext instanceof ContextWrapper) {
                            if (((ContextWrapper) baseContext).getBaseContext() != null) {
                                baseContext = null;
                            }
                        }
                    } else if (baseContext instanceof ContextWrapper) {
                        if (((ContextWrapper) baseContext).getBaseContext() != null) {
                            baseContext = null;
                        }
                    }
                    baseContext = baseContext.getApplicationContext();
                }
                Object[] objArr58 = {baseContext, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -1579870343};
                short s = (short) ($$e | 256);
                byte[] bArr21 = $$d;
                Object[] objArr59 = new Object[1];
                c(s, bArr21[579], (byte) (-bArr21[51]), objArr59);
                Class<?> cls8 = Class.forName((String) objArr59[0]);
                Object[] objArr60 = new Object[1];
                c((short) 149, bArr21[13], bArr21[488], objArr60);
                objArr4 = (Object[]) cls8.getMethod((String) objArr60[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr58);
                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1575402270);
                if (objAccessartificialFrame == null) {
                    int i79 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 17;
                    char defaultSize = (char) View.getDefaultSize(0, 0);
                    int mirror2 = 795 - AndroidCharacter.getMirror('0');
                    byte[] bArr22 = $$a;
                    Object[] objArr61 = new Object[1];
                    a((byte) 47, bArr22[113], bArr22[117], objArr61);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i79, defaultSize, mirror2, -1031537386, false, (String) objArr61[0], null);
                }
                ((Field) objAccessartificialFrame).set(null, objArr4);
                try {
                    Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1745676544);
                    if (objAccessartificialFrame2 == null) {
                        int jumpTapTimeout = 17 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                        char cLastIndexOf2 = (char) ((-1) - TextUtils.lastIndexOf("", '0', 0));
                        int fadingEdgeLength2 = 747 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                        byte[] bArr23 = $$a;
                        Object[] objArr62 = new Object[1];
                        a((byte) 47, (byte) (bArr23[21] - 1), bArr23[117], objArr62);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout, cLastIndexOf2, fadingEdgeLength2, -144068856, false, (String) objArr62[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, lValueOf4);
                } catch (Exception unused4) {
                    throw new RuntimeException();
                }
            }
        } else {
            baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr510 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) + 49806, new char[]{13749, 63241, 45270, 32191, 16247, 63682, 42370, 26399, 8237, 60911, 44890, 26699, 5617, 54944, 36970, 24000, 7826, 55390, 34102, 18148, '|', 52499, 36548, 19364, 30077, 14027}, objArr510);
                Class<?> cls9 = Class.forName((String) objArr510[0]);
                Object[] objArr511 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 63193, new char[]{13751, 50044, 55324, 53553, 61125, 59371, 64654, 62878, 33612, 39009, 37146, 44738, 42987, 48268, 46518, 17230, 22635, 20759}, objArr511);
                baseContext = (Context) cls9.getMethod((String) objArr511[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                i = getARTIFICIAL_FRAME_PACKAGE_NAME + 73;
                artificialFrame = i % 128;
                if (i % 2 == 0) {
                    int i710 = 45 / 0;
                    if (baseContext instanceof ContextWrapper) {
                        if (((ContextWrapper) baseContext).getBaseContext() != null) {
                            baseContext = null;
                        }
                    }
                } else if (baseContext instanceof ContextWrapper) {
                    if (((ContextWrapper) baseContext).getBaseContext() != null) {
                        baseContext = null;
                    }
                }
                baseContext = baseContext.getApplicationContext();
            }
            Object[] objArr512 = {baseContext, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -1579870343};
            short s2 = (short) ($$e | 256);
            byte[] bArr24 = $$d;
            Object[] objArr513 = new Object[1];
            c(s2, bArr24[579], (byte) (-bArr24[51]), objArr513);
            Class<?> cls10 = Class.forName((String) objArr513[0]);
            Object[] objArr63 = new Object[1];
            c((short) 149, bArr24[13], bArr24[488], objArr63);
            objArr4 = (Object[]) cls10.getMethod((String) objArr63[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr512);
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame == null) {
                int i711 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 17;
                char defaultSize2 = (char) View.getDefaultSize(0, 0);
                int mirror3 = 795 - AndroidCharacter.getMirror('0');
                byte[] bArr25 = $$a;
                Object[] objArr64 = new Object[1];
                a((byte) 47, bArr25[113], bArr25[117], objArr64);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i711, defaultSize2, mirror3, -1031537386, false, (String) objArr64[0], null);
            }
            ((Field) objAccessartificialFrame).set(null, objArr4);
            Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1745676544);
            if (objAccessartificialFrame2 == null) {
                int jumpTapTimeout2 = 17 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                char cLastIndexOf3 = (char) ((-1) - TextUtils.lastIndexOf("", '0', 0));
                int fadingEdgeLength3 = 747 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                byte[] bArr26 = $$a;
                Object[] objArr65 = new Object[1];
                a((byte) 47, (byte) (bArr26[21] - 1), bArr26[117], objArr65);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout2, cLastIndexOf3, fadingEdgeLength3, -144068856, false, (String) objArr65[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, lValueOf5);
        }
        int i80 = ((int[]) objArr4[4])[0];
        int i81 = ((int[]) objArr4[3])[0];
        if (i81 == i80) {
            Object[] objArr66 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i82 = ((int[]) objArr4[1])[0];
            int i83 = ((int[]) objArr4[3])[0];
            int i84 = ((int[]) objArr4[4])[0];
            List list3 = (List) objArr4[0];
            List list4 = (List) objArr4[2];
            int iIdentityHashCode5 = System.identityHashCode(this);
            int i85 = ~iIdentityHashCode5;
            int i86 = i82 + 902788353 + (((~((-920791081) | i85)) | 606076960 | (~(315342622 | i85))) * (-1136)) + (((~((-920791081) | iIdentityHashCode5)) | (~(315342622 | iIdentityHashCode5)) | (~((-628503) | i85))) * (-568)) + (((~(iIdentityHashCode5 | (-606076961))) | (~(i85 | (-315342623))) | (~(920791080 | i85))) * 568);
            int i87 = (i86 << 13) ^ i86;
            int i88 = i87 ^ (i87 >>> 17);
            ((int[]) objArr66[1])[0] = i88 ^ (i88 << 5);
        } else {
            ArrayList arrayList2 = new ArrayList();
            Object[] objArr67 = {objArr4};
            Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(1804664566);
            if (objAccessartificialFrame21 == null) {
                objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(41 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 12469), (Process.myPid() >> 22) + 3642, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
            }
            arrayList2.add(((Method) objAccessartificialFrame21).invoke(null, objArr67));
            Object[] objArr68 = {objArr4};
            Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-1243809191);
            if (objAccessartificialFrame22 == null) {
                objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 41, (char) (12468 - TextUtils.indexOf("", "", 0, 0)), View.resolveSizeAndState(0, 0, 0) + 3642, 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
            }
            arrayList2.add(((Method) objAccessartificialFrame22).invoke(null, objArr68));
            Object[] objArr69 = {Long.valueOf(((long) (i80 ^ i81)) ^ (((long) 1851958904) << 32)), Long.valueOf(1851958896)};
            byte[] bArr27 = $$d;
            Object[] objArr70 = new Object[1];
            c((short) 321, bArr27[2], (byte) (-bArr27[51]), objArr70);
            Class<?> cls11 = Class.forName((String) objArr70[0]);
            Object[] objArr71 = new Object[1];
            c(bArr27[493], bArr27[635], bArr27[28], objArr71);
            cls11.getMethod((String) objArr71[0], Long.TYPE, Long.TYPE).invoke(null, objArr69);
            Object[] objArr72 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i89 = ((int[]) objArr4[1])[0];
            int i90 = ((int[]) objArr4[3])[0];
            int i91 = ((int[]) objArr4[4])[0];
            List list5 = (List) objArr4[0];
            List list6 = (List) objArr4[2];
            int iIdentityHashCode6 = System.identityHashCode(this);
            int i92 = i89 + (((~(iIdentityHashCode6 | 502338242)) | 103110215) * 56) + 1020947153 + (((~((~iIdentityHashCode6) | 103110215)) | 502338242) * 56);
            int i93 = (i92 << 13) ^ i92;
            int i94 = i93 ^ (i93 >>> 17);
            ((int[]) objArr72[1])[0] = i94 ^ (i94 << 5);
        }
        Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame23 == null) {
            int maximumDrawingCacheSize3 = 21 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
            char c2 = (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
            int i95 = 465 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
            byte[] bArr28 = $$a;
            Object[] objArr73 = new Object[1];
            a((byte) 47, (byte) (bArr28[21] - 1), bArr28[117], objArr73);
            objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize3, c2, i95, -785931255, false, (String) objArr73[0], null);
        }
        long j7 = ((Field) objAccessartificialFrame23).getLong(null);
        if (j7 == -1 || j7 + 2011 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext3 = getBaseContext();
            if (baseContext3 == null) {
                Object[] objArr74 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 49839, new char[]{13749, 63241, 45270, 32191, 16247, 63682, 42370, 26399, 8237, 60911, 44890, 26699, 5617, 54944, 36970, 24000, 7826, 55390, 34102, 18148, '|', 52499, 36548, 19364, 30077, 14027}, objArr74);
                Class<?> cls12 = Class.forName((String) objArr74[0]);
                Object[] objArr75 = new Object[1];
                b(Drawable.resolveOpacity(0, 0) + 63197, new char[]{13751, 50044, 55324, 53553, 61125, 59371, 64654, 62878, 33612, 39009, 37146, 44738, 42987, 48268, 46518, 17230, 22635, 20759}, objArr75);
                baseContext3 = (Context) cls12.getMethod((String) objArr75[0], new Class[0]).invoke(null, null);
            }
            if (baseContext3 != null) {
                int i96 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i97 = i96 + 37;
                artificialFrame = i97 % 128;
                if (i97 % 2 == 0) {
                    boolean z = baseContext3 instanceof ContextWrapper;
                    throw null;
                }
                if (baseContext3 instanceof ContextWrapper) {
                    int i98 = i96 + 37;
                    artificialFrame = i98 % 128;
                    if (i98 % 2 == 0) {
                        ((ContextWrapper) baseContext3).getBaseContext();
                        throw null;
                    }
                    if (((ContextWrapper) baseContext3).getBaseContext() == null) {
                        baseContext3 = null;
                        objArr5 = null;
                    }
                }
                objArr5 = null;
                baseContext3 = baseContext3.getApplicationContext();
            } else {
                objArr5 = null;
            }
            int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(objArr5, this)).intValue();
            Object[] objArr76 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(objArr5, objArr5)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) + 10594, new char[]{13746, 7216, 26185, 18585, 37555, 58520, 53068, 4400, 31519, 19856, 38835, 63890, 49176, 10803, 31818, 18121, 43233, 62101, 50456, 12078, 28997, 23444, 44450, 63377, 56859, 8312, 2629, 23699, 42748, 35021, 54087, 9593, 3858, 20884, 48043, 36271, 54296, 15995, 's', 27329, 48300, 34474, 59712, 13094, 1392, 28561, 45553, 39935, 57922, 13424, 7727, 24716, 19113, 40185, 59148, 51574, 4988, 26074, 20471, 37286, 63503, 49782, 5158, 32396}, objArr76);
            String str6 = (String) objArr76[0];
            Object[] objArr77 = new Object[1];
            b(51721 - AndroidCharacter.getMirror('0'), new char[]{13793, 64570, 42499, 26682, 4821, 50319, 36594, 45327, 31533, 11596, 55195, 39397, 17358, 30178, 15470, 58970, 43127, 21131, 1191, 52906, 61761, 47999, 27975, 6090, 55733, 33745, 46568, 31749, 9740, 59508, 37592, 17569, 3777, 12574, 64308, 44365, 22373, 6632, 50055, 62958, 48133, 26151, 10363, 53909, 33963, 20161, 28957, 15153, 60755, 38766, 22999, 905, 13730, 64604, 42532, 26749, 4814, 50404, 36550, 45284, 31544, 11520, 55100, 39382}, objArr77);
            Object[] objArr78 = {baseContext3, new String[]{str6, (String) objArr77[0]}, Integer.valueOf(iIntValue2), 1, -834219266};
            short s3 = (short) BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT;
            byte[] bArr29 = $$d;
            Object[] objArr79 = new Object[1];
            c(s3, bArr29[654], (byte) (bArr29[635] + 1), objArr79);
            Class<?> cls13 = Class.forName((String) objArr79[0]);
            Object[] objArr80 = new Object[1];
            c((short) ($$e | 417), bArr29[30], bArr29[20], objArr80);
            objArr6 = (Object[]) cls13.getMethod((String) objArr80[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr78);
            int i99 = ((int[]) objArr6[0])[0];
            int i100 = ((int[]) objArr6[3])[0];
            if (baseContext3 != null) {
                Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame24 == null) {
                    int touchSlop = (ViewConfiguration.getTouchSlop() >> 8) + 21;
                    char edgeSlop = (char) (ViewConfiguration.getEdgeSlop() >> 16);
                    int iArgb2 = Color.argb(0, 0, 0, 0) + 465;
                    byte[] bArr30 = $$a;
                    Object[] objArr81 = new Object[1];
                    a((byte) 47, bArr30[113], bArr30[117], objArr81);
                    objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(touchSlop, edgeSlop, iArgb2, -612765161, false, (String) objArr81[0], null);
                }
                ((Field) objAccessartificialFrame24).set(null, objArr6);
                try {
                    Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(1313006081);
                    if (objAccessartificialFrame25 == null) {
                        int touchSlop2 = 21 - (ViewConfiguration.getTouchSlop() >> 8);
                        char threadPriority = (char) ((Process.getThreadPriority(0) + 20) >> 6);
                        int iMyTid2 = (Process.myTid() >> 22) + 465;
                        byte[] bArr31 = $$a;
                        Object[] objArr82 = new Object[1];
                        a((byte) 47, (byte) (bArr31[21] - 1), bArr31[117], objArr82);
                        objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(touchSlop2, threadPriority, iMyTid2, -785931255, false, (String) objArr82[0], null);
                    }
                    ((Field) objAccessartificialFrame25).set(null, lValueOf6);
                } catch (Exception unused5) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(1142731807);
            if (objAccessartificialFrame26 == null) {
                int scrollBarSize = (ViewConfiguration.getScrollBarSize() >> 8) + 21;
                char cResolveSize2 = (char) View.resolveSize(0, 0);
                int i101 = 465 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                byte[] bArr32 = $$a;
                Object[] objArr83 = new Object[1];
                a((byte) 47, bArr32[113], bArr32[117], objArr83);
                objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(scrollBarSize, cResolveSize2, i101, -612765161, false, (String) objArr83[0], null);
            }
            Object[] objArr84 = (Object[]) ((Field) objAccessartificialFrame26).get(null);
            objArr6 = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
            int i102 = ((int[]) objArr84[3])[0];
            int i103 = ((int[]) objArr84[0])[0];
            String[] strArr5 = (String[]) objArr84[1];
            int iIdentityHashCode7 = System.identityHashCode(this);
            int i104 = (((446369251 + (((~((-658148242) | iIdentityHashCode7)) | 537397633) * (-140))) + ((~((-120750609) | iIdentityHashCode7)) * 70)) + (((~(iIdentityHashCode7 | 818497967)) | (-401850943)) * 70)) - 834219266;
            int i105 = (i104 << 13) ^ i104;
            int i106 = i105 ^ (i105 >>> 17);
            ((int[]) objArr6[2])[0] = i106 ^ (i106 << 5);
        }
        int i107 = ((int[]) objArr6[0])[0];
        int i108 = ((int[]) objArr6[3])[0];
        if (i108 == i107) {
            Object[] objArr85 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i109 = ((int[]) objArr6[2])[0];
            int i110 = ((int[]) objArr6[3])[0];
            int i111 = ((int[]) objArr6[0])[0];
            String[] strArr6 = (String[]) objArr6[1];
            int i112 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenLayout;
            int i113 = i109 + 1119238613 + (((~(293341613 | i112)) | 109134338 | (~((-132991888) | i112))) * (-744)) + (((~i112) | 269484064) * 744) + ((i112 | (-109134339)) * 744);
            int i114 = (i113 << 13) ^ i113;
            int i115 = i114 ^ (i114 >>> 17);
            ((int[]) objArr85[2])[0] = i115 ^ (i115 << 5);
        } else {
            ArrayList arrayList3 = new ArrayList();
            String[] strArr7 = (String[]) objArr6[1];
            if (strArr7 != null) {
                for (String str7 : strArr7) {
                    arrayList3.add(str7);
                }
            }
            Object[] objArr86 = {Long.valueOf(((long) (i107 ^ i108)) ^ (((long) 963195652) << 32)), Long.valueOf(963195716)};
            byte[] bArr33 = $$d;
            Object[] objArr87 = new Object[1];
            c((short) 455, bArr33[17], (byte) (-bArr33[51]), objArr87);
            Class<?> cls14 = Class.forName((String) objArr87[0]);
            Object[] objArr88 = new Object[1];
            c(bArr33[493], bArr33[635], bArr33[28], objArr88);
            cls14.getMethod((String) objArr88[0], Long.TYPE, Long.TYPE).invoke(null, objArr86);
            Object[] objArr89 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i116 = ((int[]) objArr6[2])[0];
            int i117 = ((int[]) objArr6[3])[0];
            int i118 = ((int[]) objArr6[0])[0];
            String[] strArr8 = (String[]) objArr6[1];
            int i119 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().densityDpi;
            int i120 = ~((-269500963) | i119);
            int i121 = ~i119;
            int i122 = i116 + (-1332509211) + ((i120 | (~(1070718694 | i121))) * 920) + (((~((-961567459) | i121)) | 269500962) * 920) + (((~(i119 | 1070718694)) | (~((-269500963) | i121)) | (~((-692066497) | i119))) * 920);
            int i123 = (i122 << 13) ^ i122;
            int i124 = i123 ^ (i123 >>> 17);
            ((int[]) objArr89[2])[0] = i124 ^ (i124 << 5);
        }
        Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame27 == null) {
            int bitsPerPixel2 = ImageFormat.getBitsPerPixel(0) + 27;
            char modifierMetaStateMask = (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask()));
            int iKeyCodeFromString = 1041 - KeyEvent.keyCodeFromString("");
            byte[] bArr34 = $$a;
            Object[] objArr90 = new Object[1];
            a((byte) 47, (byte) (bArr34[21] - 1), bArr34[117], objArr90);
            objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(bitsPerPixel2, modifierMetaStateMask, iKeyCodeFromString, 2061780482, false, (String) objArr90[0], null);
        }
        long j8 = ((Field) objAccessartificialFrame27).getLong(null);
        if (j8 != -1) {
            int i125 = artificialFrame + 13;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i125 % 128;
            if (i125 % 2 == 0 ? j8 + 4611686018427387867L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue() : j8 - 4611686018427387867L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[1])).longValue()) {
                int iIntValue3 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                Object[] objArr91 = {-1130793684};
                objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame3 == null) {
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 8, (char) (Process.getGidForName("") + 22252), 1033 - (ViewConfiguration.getJumpTapTimeout() >> 16), 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = UriModifierInterface.ModificationResult.Modified.ModifiedToMaxDimens.accessartificialFrame$78cbbd35(iIntValue3, 0, ((Constructor) objAccessartificialFrame3).newInstance(objArr91), 639555738, false);
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame4 == null) {
                    int iArgb3 = 26 - Color.argb(0, 0, 0, 0);
                    char absoluteGravity = (char) Gravity.getAbsoluteGravity(0, 0);
                    int mirror4 = 1089 - AndroidCharacter.getMirror('0');
                    byte[] bArr35 = $$a;
                    Object[] objArr92 = new Object[1];
                    a((byte) 47, bArr35[113], bArr35[117], objArr92);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iArgb3, absoluteGravity, mirror4, 1145017376, false, (String) objArr92[0], null);
                }
                ((Field) objAccessartificialFrame4).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame5 == null) {
                        int bitsPerPixel3 = ImageFormat.getBitsPerPixel(0) + 27;
                        char cArgb = (char) Color.argb(0, 0, 0, 0);
                        int i126 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 1040;
                        byte[] bArr36 = $$a;
                        Object[] objArr93 = new Object[1];
                        a((byte) 47, (byte) (bArr36[21] - 1), bArr36[117], objArr93);
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(bitsPerPixel3, cArgb, i126, 2061780482, false, (String) objArr93[0], null);
                    }
                    ((Field) objAccessartificialFrame5).set(null, lValueOf7);
                } catch (Exception unused6) {
                    throw new RuntimeException();
                }
            } else {
                int i127 = artificialFrame + 1;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i127 % 128;
                int i128 = i127 % 2;
                Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame28 == null) {
                    int i129 = 26 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                    char c3 = (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
                    int offsetBefore2 = TextUtils.getOffsetBefore("", 0) + 1041;
                    byte[] bArr37 = $$a;
                    Object[] objArr94 = new Object[1];
                    a((byte) 47, bArr37[113], bArr37[117], objArr94);
                    objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(i129, c3, offsetBefore2, 1145017376, false, (String) objArr94[0], null);
                }
                Object[] objArr95 = (Object[]) ((Field) objAccessartificialFrame28).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i130 = ((int[]) objArr95[3])[0];
                int i131 = ((int[]) objArr95[2])[0];
                String[] strArr9 = (String[]) objArr95[0];
                int streamMaxVolume = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getStreamMaxVolume(3);
                int i132 = ~streamMaxVolume;
                int i133 = 652131638 + (((~((-342436144) | i132)) | 420539950) * (-328)) + ((streamMaxVolume | 420539950) * 164) + (((~(streamMaxVolume | 342436143)) | 152094208 | (~(i132 | (-73990402)))) * 164) + 639555738;
                int i134 = (i133 << 13) ^ i133;
                int i135 = i134 ^ (i134 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i135 ^ (i135 << 5);
            }
        } else {
            int iIntValue4 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr96 = {-1130793684};
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame3 == null) {
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 8, (char) (Process.getGidForName("") + 22252), 1033 - (ViewConfiguration.getJumpTapTimeout() >> 16), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = UriModifierInterface.ModificationResult.Modified.ModifiedToMaxDimens.accessartificialFrame$78cbbd35(iIntValue4, 0, ((Constructor) objAccessartificialFrame3).newInstance(objArr96), 639555738, false);
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame4 == null) {
                int iArgb4 = 26 - Color.argb(0, 0, 0, 0);
                char absoluteGravity2 = (char) Gravity.getAbsoluteGravity(0, 0);
                int mirror5 = 1089 - AndroidCharacter.getMirror('0');
                byte[] bArr38 = $$a;
                Object[] objArr97 = new Object[1];
                a((byte) 47, bArr38[113], bArr38[117], objArr97);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iArgb4, absoluteGravity2, mirror5, 1145017376, false, (String) objArr97[0], null);
            }
            ((Field) objAccessartificialFrame4).set(null, objArrAccessartificialFrame$78cbbd35);
            Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame5 == null) {
                int bitsPerPixel4 = ImageFormat.getBitsPerPixel(0) + 27;
                char cArgb2 = (char) Color.argb(0, 0, 0, 0);
                int i1210 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 1040;
                byte[] bArr39 = $$a;
                Object[] objArr98 = new Object[1];
                a((byte) 47, (byte) (bArr39[21] - 1), bArr39[117], objArr98);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(bitsPerPixel4, cArgb2, i1210, 2061780482, false, (String) objArr98[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, lValueOf8);
        }
        int i136 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i137 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i137 == i136) {
            Object[] objArr99 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i138 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i139 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i140 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr10 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int elapsedCpuTime = (int) Process.getElapsedCpuTime();
            int i141 = i138 + (-934207170) + (((~((-78119170) | (~elapsedCpuTime))) | (~((-15363) | elapsedCpuTime))) * (-272)) + (((~((-1039876418) | elapsedCpuTime)) | 961757248) * (-272)) + (((~(elapsedCpuTime | 1039876417)) | (-961772611)) * 272);
            int i142 = (i141 << 13) ^ i141;
            int i143 = i142 ^ (i142 >>> 17);
            ((int[]) objArr99[1])[0] = i143 ^ (i143 << 5);
        } else {
            ArrayList arrayList4 = new ArrayList();
            String[] strArr11 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr11 != null) {
                for (String str8 : strArr11) {
                    arrayList4.add(str8);
                }
            }
            Object[] objArr100 = {Long.valueOf(((long) (i136 ^ i137)) ^ (((long) (-2029513295)) << 32)), Long.valueOf(-2029513293)};
            byte[] bArr40 = $$d;
            Object[] objArr101 = new Object[1];
            c((short) (-bArr40[92]), (byte) (-bArr40[4]), (byte) (-bArr40[116]), objArr101);
            Class<?> cls15 = Class.forName((String) objArr101[0]);
            Object[] objArr102 = new Object[1];
            c(bArr40[493], bArr40[635], bArr40[28], objArr102);
            cls15.getMethod((String) objArr102[0], Long.TYPE, Long.TYPE).invoke(null, objArr100);
            Object[] objArr103 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i144 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i145 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i146 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr12 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
            int i147 = 944366102 + (((~((-939632758) | iMaxMemory)) | 805412980 | (~((-861528951) | iMaxMemory))) * (-754));
            int i148 = ~((-805412981) | iMaxMemory);
            int i149 = ~iMaxMemory;
            int i150 = i144 + i147 + ((i148 | (~((-56115971) | i149))) * (-754)) + ((i149 | (-939632758)) * 754);
            int i151 = (i150 << 13) ^ i150;
            int i152 = i151 ^ (i151 >>> 17);
            ((int[]) objArr103[1])[0] = i152 ^ (i152 << 5);
        }
        Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame29 == null) {
            int maximumFlingVelocity2 = 30 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
            char cResolveOpacity = (char) (Drawable.resolveOpacity(0, 0) + 49362);
            int iIndexOf5 = 683 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
            byte[] bArr41 = $$a;
            Object[] objArr104 = new Object[1];
            a((byte) (bArr41[115] + 1), (byte) 77, bArr41[113], objArr104);
            objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity2, cResolveOpacity, iIndexOf5, 508509282, false, (String) objArr104[0], null);
        }
        long j9 = ((Field) objAccessartificialFrame29).getLong(null);
        if (j9 == -1 || j9 + 1989 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext4 = getBaseContext();
            if (baseContext4 == null) {
                Object[] objArr105 = new Object[1];
                b(49843 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), new char[]{13749, 63241, 45270, 32191, 16247, 63682, 42370, 26399, 8237, 60911, 44890, 26699, 5617, 54944, 36970, 24000, 7826, 55390, 34102, 18148, '|', 52499, 36548, 19364, 30077, 14027}, objArr105);
                Class<?> cls16 = Class.forName((String) objArr105[0]);
                Object[] objArr106 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 63193, new char[]{13751, 50044, 55324, 53553, 61125, 59371, 64654, 62878, 33612, 39009, 37146, 44738, 42987, 48268, 46518, 17230, 22635, 20759}, objArr106);
                baseContext4 = (Context) cls16.getMethod((String) objArr106[0], new Class[0]).invoke(null, null);
            }
            if (baseContext4 != null) {
                baseContext4 = ((baseContext4 instanceof ContextWrapper) && ((ContextWrapper) baseContext4).getBaseContext() == null) ? null : baseContext4.getApplicationContext();
            }
            Object[] objArr107 = {baseContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 1093656730};
            byte[] bArr42 = $$d;
            Object[] objArr108 = new Object[1];
            c((short) 520, bArr42[28], (byte) (-bArr42[51]), objArr108);
            Class<?> cls17 = Class.forName((String) objArr108[0]);
            Object[] objArr109 = new Object[1];
            c((short) ($$e | 417), bArr42[30], bArr42[20], objArr109);
            objArr7 = (Object[]) cls17.getMethod((String) objArr109[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr107);
            if (baseContext4 != null) {
                Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame30 == null) {
                    int edgeSlop2 = 30 - (ViewConfiguration.getEdgeSlop() >> 16);
                    char packedPositionChild = (char) (49361 - ExpandableListView.getPackedPositionChild(0L));
                    int i153 = 685 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                    byte[] bArr43 = $$a;
                    Object[] objArr110 = new Object[1];
                    a(bArr43[15], (byte) 89, bArr43[30], objArr110);
                    objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(edgeSlop2, packedPositionChild, i153, -1321816393, false, (String) objArr110[0], null);
                }
                ((Field) objAccessartificialFrame30).set(null, objArr7);
                try {
                    Long lValueOf9 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                    if (objAccessartificialFrame31 == null) {
                        int edgeSlop3 = (ViewConfiguration.getEdgeSlop() >> 16) + 30;
                        char cResolveSizeAndState = (char) (49362 - View.resolveSizeAndState(0, 0, 0));
                        int iMyTid3 = (Process.myTid() >> 22) + 684;
                        byte[] bArr44 = $$a;
                        Object[] objArr111 = new Object[1];
                        a((byte) (bArr44[115] + 1), (byte) 77, bArr44[113], objArr111);
                        objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(edgeSlop3, cResolveSizeAndState, iMyTid3, 508509282, false, (String) objArr111[0], null);
                    }
                    ((Field) objAccessartificialFrame31).set(null, lValueOf9);
                } catch (Exception unused7) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(777251007);
            if (objAccessartificialFrame32 == null) {
                int fadingEdgeLength4 = (ViewConfiguration.getFadingEdgeLength() >> 16) + 30;
                char tapTimeout = (char) (49362 - (ViewConfiguration.getTapTimeout() >> 16));
                int i154 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 684;
                byte[] bArr45 = $$a;
                Object[] objArr112 = new Object[1];
                a(bArr45[15], (byte) 89, bArr45[30], objArr112);
                objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength4, tapTimeout, i154, -1321816393, false, (String) objArr112[0], null);
            }
            Object[] objArr113 = (Object[]) ((Field) objAccessartificialFrame32).get(null);
            objArr7 = new Object[]{new int[]{((int[]) objArr113[0])[0]}, new int[]{((int[]) objArr113[1])[0]}, new int[1], (String) objArr113[3]};
            int streamVolume = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getStreamVolume(3);
            int i155 = ~streamVolume;
            int i156 = (-1508821074) + (((~((-944461023) | i155)) | 606272 | (~((-34162753) | i155))) * (-1136)) + (((~((-944461023) | streamVolume)) | (~((-34162753) | streamVolume)) | (~(978017502 | i155))) * (-568)) + (((~(streamVolume | (-606273))) | (~(i155 | 34162752)) | (~(944461022 | i155))) * 568) + 1093656730;
            int i157 = (i156 << 13) ^ i156;
            int i158 = i157 ^ (i157 >>> 17);
            ((int[]) objArr7[2])[0] = i158 ^ (i158 << 5);
        }
        int i159 = ((int[]) objArr7[1])[0];
        int i160 = ((int[]) objArr7[0])[0];
        if (i160 == i159) {
            int i161 = ((int[]) objArr7[2])[0];
            Object[] objArr114 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
            int i162 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().touchscreen;
            int i163 = ~i162;
            int i164 = i161 + (-1771752788) + (((~(i163 | 809333824)) | 169289950) * (-1042)) + ((809333824 | i162) * 521) + (((~(i162 | (-169289951))) | 1384512 | (~(i163 | 977239262))) * 521);
            int i165 = (i164 << 13) ^ i164;
            int i166 = i165 ^ (i165 >>> 17);
            ((int[]) objArr114[2])[0] = i166 ^ (i166 << 5);
        } else {
            Object[] objArr115 = {Long.valueOf(((long) (i159 ^ i160)) ^ (((long) 1939081454) << 32)), Long.valueOf(1939081966)};
            byte[] bArr46 = $$d;
            Object[] objArr116 = new Object[1];
            c((short) 590, bArr46[10], (byte) (-bArr46[51]), objArr116);
            Class<?> cls18 = Class.forName((String) objArr116[0]);
            Object[] objArr117 = new Object[1];
            c(bArr46[493], bArr46[635], bArr46[28], objArr117);
            cls18.getMethod((String) objArr117[0], Long.TYPE, Long.TYPE).invoke(null, objArr115);
            int i167 = ((int[]) objArr7[2])[0];
            Object[] objArr118 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
            int i168 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().mcc;
            int i169 = (~((-904019927) | i168)) | 73538880;
            int i170 = i167 + 912536318 + (i169 * 992) + ((i169 | (~((~i168) | 905084894))) * (-496)) + ((i168 | 74603848) * 496);
            int i171 = (i170 << 13) ^ i170;
            int i172 = i171 ^ (i171 >>> 17);
            ((int[]) objArr118[2])[0] = i172 ^ (i172 << 5);
        }
        Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame33 == null) {
            int jumpTapTimeout3 = (ViewConfiguration.getJumpTapTimeout() >> 16) + 36;
            char c4 = (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
            int touchSlop3 = (ViewConfiguration.getTouchSlop() >> 8) + 540;
            byte[] bArr47 = $$a;
            Object[] objArr119 = new Object[1];
            a((byte) 47, (byte) (bArr47[21] - 1), bArr47[117], objArr119);
            objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout3, c4, touchSlop3, 624296913, false, (String) objArr119[0], null);
        }
        long j10 = ((Field) objAccessartificialFrame33).getLong(null);
        if (j10 == -1 || j10 + 1880 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(-1717965552);
            if (objAccessartificialFrame34 == null) {
                objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0') + 21, (char) ((Process.myPid() >> 22) + 39516), 982 - Color.red(0), 117222168, false, null, new Class[0]);
            }
            Object[] objArr120 = {null, ((Constructor) objAccessartificialFrame34).newInstance(null), -1133171233, 0};
            Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(-501205803);
            if (objAccessartificialFrame35 == null) {
                int iBlue2 = 36 - Color.blue(0);
                char mode = (char) View.MeasureSpec.getMode(0);
                int i173 = 541 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                byte b6 = $$a[21];
                byte b7 = (byte) (b6 - 1);
                Object[] objArr121 = new Object[1];
                a(b7, (byte) (b7 | 96), (byte) (b6 - 1), objArr121);
                objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(iBlue2, mode, i173, 2101703389, false, (String) objArr121[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(54 - Color.red(0), (char) (832 - ((byte) KeyEvent.getModifierMetaStateMask())), TextUtils.lastIndexOf("", '0', 0, 0) + 577), (Class) ArtificialStackFrames.coroutineCreation(54 - TextUtils.getCapsMode("", 0, 0), (char) View.MeasureSpec.makeMeasureSpec(0, 0), 630 - View.getDefaultSize(0, 0)), Integer.TYPE, Integer.TYPE});
            }
            Object[] objArr122 = (Object[]) ((Method) objAccessartificialFrame35).invoke(null, objArr120);
            Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame36 == null) {
                int iRgb2 = (-16777180) - Color.rgb(0, 0, 0);
                char maximumFlingVelocity3 = (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                int iLastIndexOf3 = TextUtils.lastIndexOf("", '0', 0) + 541;
                byte[] bArr48 = $$a;
                Object[] objArr123 = new Object[1];
                a((byte) 47, bArr48[113], bArr48[117], objArr123);
                objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(iRgb2, maximumFlingVelocity3, iLastIndexOf3, 793268735, false, (String) objArr123[0], null);
            }
            ((Field) objAccessartificialFrame36).set(null, objArr122);
            try {
                Long lValueOf10 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                if (objAccessartificialFrame37 == null) {
                    int iLastIndexOf4 = TextUtils.lastIndexOf("", '0') + 37;
                    char c5 = (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                    int i174 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 540;
                    byte[] bArr49 = $$a;
                    Object[] objArr124 = new Object[1];
                    a((byte) 47, (byte) (bArr49[21] - 1), bArr49[117], objArr124);
                    objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(iLastIndexOf4, c5, i174, 624296913, false, (String) objArr124[0], null);
                }
                ((Field) objAccessartificialFrame37).set(null, lValueOf10);
                objArr8 = objArr122;
            } catch (Exception unused8) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame38 == null) {
                int i175 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 35;
                char gidForName = (char) (Process.getGidForName("") + 1);
                int i176 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 540;
                byte[] bArr50 = $$a;
                Object[] objArr125 = new Object[1];
                a((byte) 47, bArr50[113], bArr50[117], objArr125);
                objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(i175, gidForName, i176, 793268735, false, (String) objArr125[0], null);
            }
            Object[] objArr126 = (Object[]) ((Field) objAccessartificialFrame38).get(null);
            objArr8 = new Object[]{new int[1], new int[1], new int[1]};
            int i177 = ((int[]) objArr126[2])[0];
            int i178 = ((int[]) objArr126[1])[0];
            ((int[]) objArr8[2])[0] = i177;
            ((int[]) objArr8[1])[0] = i178;
            int layoutDirection2 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().getLayoutDirection();
            int i179 = (((((~((-655102053) | layoutDirection2)) | 140642321) * TypedValues.PositionType.TYPE_TRANSITION_EASING) + 2115649404) + ((~((~layoutDirection2) | (-655102053))) * TypedValues.PositionType.TYPE_TRANSITION_EASING)) - 1133171233;
            int i180 = (i179 << 13) ^ i179;
            int i181 = i180 ^ (i180 >>> 17);
            ((int[]) objArr8[0])[0] = i181 ^ (i181 << 5);
            int i182 = getARTIFICIAL_FRAME_PACKAGE_NAME + 87;
            artificialFrame = i182 % 128;
            int i183 = i182 % 2;
        }
        Object obj = objArr8[1];
        int i184 = ((int[]) obj)[0];
        Object obj2 = objArr8[2];
        int i185 = ((int[]) obj2)[0];
        if (i185 == i184) {
            Object[] objArr127 = {new int[1], new int[1], new int[1]};
            int i186 = ((int[]) objArr8[0])[0];
            int i187 = ((int[]) obj2)[0];
            int i188 = ((int[]) obj)[0];
            ((int[]) objArr127[2])[0] = i187;
            ((int[]) objArr127[1])[0] = i188;
            int iMyTid4 = Process.myTid();
            int i189 = (-401075209) + (((~((-406925184) | iMyTid4)) | 66313 | (~(944696566 | iMyTid4))) * (-754));
            int i190 = ~((-66314) | iMyTid4);
            int i191 = ~iMyTid4;
            int i192 = i186 + i189 + ((i190 | (~(944762879 | i191))) * (-754)) + ((i191 | (-406925184)) * 754);
            int i193 = (i192 << 13) ^ i192;
            int i194 = i193 ^ (i193 >>> 17);
            ((int[]) objArr127[0])[0] = i194 ^ (i194 << 5);
        } else {
            Object[] objArr128 = {Long.valueOf(((long) (i184 ^ i185)) ^ (((long) 1494014828) << 32)), Long.valueOf(1494010732)};
            byte b8 = (byte) ($$e << 1);
            byte[] bArr51 = $$d;
            Object[] objArr129 = new Object[1];
            c((short) 168, b8, (byte) (-bArr51[51]), objArr129);
            Class<?> cls19 = Class.forName((String) objArr129[0]);
            Object[] objArr130 = new Object[1];
            c(bArr51[493], bArr51[635], bArr51[28], objArr130);
            cls19.getMethod((String) objArr130[0], Long.TYPE, Long.TYPE).invoke(null, objArr128);
            Object[] objArr131 = {new int[1], new int[1], new int[1]};
            int i195 = ((int[]) objArr8[0])[0];
            int i196 = ((int[]) objArr8[2])[0];
            int i197 = ((int[]) objArr8[1])[0];
            ((int[]) objArr131[2])[0] = i196;
            ((int[]) objArr131[1])[0] = i197;
            int i198 = ~System.identityHashCode(this);
            int i199 = i195 + (-492034335) + (((~(1073740911 | i198)) | 277880838) * (-828)) + ((i198 | 1073740911) * (-828)) + 755136;
            int i200 = i199 ^ (i199 << 13);
            int i201 = i200 ^ (i200 >>> 17);
            ((int[]) objArr131[0])[0] = i201 ^ (i201 << 5);
        }
        super.onCreate();
    }

    static {
        byte[] bArr = new byte[661];
        System.arraycopy("4ì\u0007\u0088ðþ;Ãôü\u0004÷\u00033Çíõ\u0005ø\u0001=¶\u0007÷ÿ9Éø\u0000ù2éØî*àå)âèQïü¿\u0000ÿðü\u00009\u0001Á÷ö\u000bï\u0000\tñ:º\u0000\u0007é\nóù\u0001;Éï\u0006îÿ\u0002\u00012æÛûýïü\tý\rà\bô\u0002í/Ùÿíø\u000bïðþ;Ä\u0001úúÿïü\u00009¸\t\u0000úëBµ\bø\bï\töþï@Øé\u0000úë/Úüúîü\u0006\u0003õùÿñ÷1Ûõ\u0003ú\u0002é\u000b=îÐùÿöý\u0007÷\u0005\u001dÛÿé\nüú÷\u0003\u0018Óðþ;Ä\u0001úúÿïü\u00009Éíü\u0000ÿ÷ÿôAéÍü ß÷ÿ#ßé\u000f9ïðþ;Ãôü\u0004÷\u00033Éï\u0006îÿ\u0002\u00012ÃööAÁ÷ö\u000bï\u0000\tñ:½ýýþñ\u0011å\tò\u0006öý\u000bùýë\u000bð\u0007û3°ü\u0012ëðùÿöý\u0007÷\u0005\u001eÍ\t\u0000é\u0007öýðþ;Ãôü\u0004÷\u00033Éï\u0006îÿ\u0002\u00012ÃööAÁ÷ö\u000bï\u0000\tñ:½\u0004\u0000êúÿ\tô\u0004óöB°ü\b÷ðþ;Ãôü\u0004÷\u00033Éï\u0006îÿ\u0002\u00012ÃööAÁ÷ö\u000bï\u0000\tñ:½ýýþñ\u0011å\tò\u0006öý\u000bùýë\u000bð\u0007û\u0002ùé\u0003\u0006ô\u0003ý2°ü\u0011ö=·\nóöþõGÉï\u0006îÿ\u0002\u00012Çðù\t3Á÷ö\u000bï\u0000\tñ:µý\u0007ù:×ìí\tüó÷\u0007õ÷\u001bÝ\u0007ùõúüúîü\u000eëú\u0007ÿù\u0002ö\u0004ñ\"Ð\rð\u0004ðþ;Ãôü\u0004÷\u00033Çðþüúý<Çðÿü\u0003þëBÝèí\u001fèò\u0002ï%×ö\u000bï\u0000\tñ\u001bèíHßÛëûþ\rúë\u0019î\u0000ò\u001câè0Óöþõðþ;·\u000eñ\u0003î\tóù\u000bú3½\bë\u0003\u0002í\u0007÷\u0003\u0000óùö\r2·\tõ\u0006ì\u000bõ9½ú\u0007ë\u0005\u0003îAº÷þ\u00076Ú×þ\u0007\u0017Ú\u0007ë\u0005\u0003=ÝÐþù\u000bï\u0001öýðþ;Ä\u0001úúÿïü\u00009¸\t\u0000úëBµ\bø\bï\töþï@Ñæ\u0004\u0002\u000fÛ\u0007û\u0011ÝüÿDüÛÉ\u0000\u000bï\u0000\tñ\u0015Ö\u0007ö\bÿí\u0007\u0002\u0013çð\u0007úÿ-".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 661);
        $$d = bArr;
        $$e = 18;
        $$a = new byte[]{92, 127, 52, -8, 5, -1, -33, 33, -2, -9, 5, -7, 5, -1, -50, 39, Ascii.VT, -7, -12, Ascii.SI, Ascii.ESC, 1, -7, -6, -33, 51, -12, 3, -8, 1, Ascii.CR, -9, Ascii.DC2, -34, Ascii.EM, 4, -17, 19, -15, -1, -18, Ascii.SI, 19, -11, 5, -7, -2, Ascii.SI, -36, Ascii.NAK, Ascii.CR, -15, 2, 9, 6, -34, Ascii.SI, 19, -11, 5, -7, -2, Ascii.SI, -33, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, 10, -31, Ascii.DC4, Ascii.CR, -8, -11, -13, Ascii.ESC, -9, Ascii.DC2, -36, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, -7, Ascii.DC2, -43, Ascii.GS, -4, 17, 2, 49, 2, -11, -3, 3, -6, 6, -8, Ascii.VT, -25, 33, -19, 2, 8, -37, 44, -17, Ascii.FF, -8, Ascii.SO};
        $$b = 98;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        extraCommand = -4003698965548397093L;
    }
}
