package com.ReactNativeBlobUtil.Utils;

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
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.PointerIconCompat;
import ch.qos.logback.core.net.SyslogConstants;
import com.google.android.material.carousel.KeylineState;
import com.google.common.base.Ascii;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import o.ArtificialStackFrames;
import o.onNavigationEvent;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.CharUtils;

/* JADX INFO: loaded from: classes4.dex */
public class FileProvider extends androidx.core.content.FileProvider {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    private static int artificialFrame;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static int setDefaultImpl;
    private static final byte[] $$c = {Ascii.SYN, -120, 37, 108};
    private static final int $$f = 8;
    private static int $10 = 0;
    private static int $11 = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0028). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(short r5, short r6, short r7) {
        /*
            int r7 = r7 * 2
            int r7 = 3 - r7
            int r6 = r6 * 2
            int r0 = r6 + 1
            int r5 = r5 * 2
            int r5 = 116 - r5
            byte[] r1 = com.ReactNativeBlobUtil.Utils.FileProvider.$$c
            byte[] r0 = new byte[r0]
            r2 = 0
            if (r1 != 0) goto L16
            r4 = r6
            r3 = r2
            goto L28
        L16:
            r3 = r2
        L17:
            byte r4 = (byte) r5
            r0[r3] = r4
            if (r3 != r6) goto L22
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            return r5
        L22:
            int r7 = r7 + 1
            int r3 = r3 + 1
            r4 = r1[r7]
        L28:
            int r4 = -r4
            int r5 = r5 + r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.Utils.FileProvider.$$g(short, short, short):java.lang.String");
    }

    private static void b(int i, int i2, int i3, Object[] objArr) {
        int i4 = 112 - i2;
        int i5 = i + 4;
        byte[] bArr = $$a;
        byte[] bArr2 = new byte[i3 + 8];
        int i6 = i3 + 7;
        int i7 = -1;
        if (bArr == null) {
            i4 += i6;
        }
        while (true) {
            i7++;
            i5++;
            bArr2[i7] = (byte) i4;
            if (i7 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i4 += bArr[i5];
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    /* JADX WARN: Code duplicated, block: B:8:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void c(int r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.ReactNativeBlobUtil.Utils.FileProvider.$$d
            int r6 = r6 + 36
            int r1 = r8 + 3
            int r7 = r7 + 4
            byte[] r1 = new byte[r1]
            int r8 = r8 + 2
            r2 = 0
            if (r0 != 0) goto L13
            r3 = r7
            r7 = r8
            r4 = r2
            goto L2a
        L13:
            r3 = r2
        L14:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L21
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L21:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r5
        L2a:
            int r6 = -r6
            int r7 = r7 + r6
            int r6 = r7 + (-4)
            int r7 = r3 + 1
            r3 = r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.Utils.FileProvider.c(int, short, int, java.lang.Object[]):void");
    }

    private static void a(boolean z, int i, int i2, int i3, char[] cArr, Object[] objArr) throws Throwable {
        int i4 = 2 % 2;
        onNavigationEvent onnavigationevent = new onNavigationEvent();
        char[] cArr2 = new char[i3];
        onnavigationevent.d = 0;
        while (onnavigationevent.d < i3) {
            onnavigationevent.c = cArr[onnavigationevent.d];
            cArr2[onnavigationevent.d] = (char) (i2 + onnavigationevent.c);
            int i5 = onnavigationevent.d;
            try {
                Object[] objArr2 = {Integer.valueOf(cArr2[i5]), Integer.valueOf(setDefaultImpl)};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(465886069);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) 1;
                    byte b2 = (byte) (b - 1);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(22 - ((Process.getThreadPriority(0) + 20) >> 6), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16), 1775 - View.resolveSizeAndState(0, 0, 0), -2069783171, false, $$g(b, b2, b2), new Class[]{Integer.TYPE, Integer.TYPE});
                }
                cArr2[i5] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                try {
                    Object[] objArr3 = {onnavigationevent, onnavigationevent};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 0;
                        byte b4 = b3;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(37 - View.getDefaultSize(0, 0), (char) (56278 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), Process.getGidForName("") + 1260, 711931141, false, $$g(b3, b4, b4), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        if (i > 0) {
            onnavigationevent.b = i;
            char[] cArr3 = new char[i3];
            System.arraycopy(cArr2, 0, cArr3, 0, i3);
            System.arraycopy(cArr3, 0, cArr2, i3 - onnavigationevent.b, onnavigationevent.b);
            System.arraycopy(cArr3, onnavigationevent.b, cArr2, 0, i3 - onnavigationevent.b);
        }
        if (z) {
            int i6 = $10 + 91;
            $11 = i6 % 128;
            int i7 = i6 % 2;
            char[] cArr4 = new char[i3];
            onnavigationevent.d = 0;
            int i8 = $11 + 37;
            $10 = i8 % 128;
            if (i8 % 2 != 0) {
                int i9 = 5 % 4;
            }
            while (onnavigationevent.d < i3) {
                cArr4[onnavigationevent.d] = cArr2[(i3 - onnavigationevent.d) - 1];
                try {
                    Object[] objArr4 = {onnavigationevent, onnavigationevent};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                    if (objAccessartificialFrame3 == null) {
                        byte b5 = (byte) 0;
                        byte b6 = b5;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollBarSize() >> 8) + 37, (char) (ImageFormat.getBitsPerPixel(0) + 56278), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1259, 711931141, false, $$g(b5, b6, b6), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                    int i10 = $11 + 71;
                    $10 = i10 % 128;
                    int i11 = i10 % 2;
                } catch (Throwable th3) {
                    Throwable cause3 = th3.getCause();
                    if (cause3 == null) {
                        throw th3;
                    }
                    throw cause3;
                }
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }

    /* JADX WARN: Code duplicated, block: B:121:0x0d35  */
    /* JADX WARN: Code duplicated, block: B:123:0x0da8  */
    /* JADX WARN: Code duplicated, block: B:129:0x0db8  */
    /* JADX WARN: Code duplicated, block: B:134:0x0ec2  */
    /* JADX WARN: Code duplicated, block: B:136:0x0ed4  */
    /* JADX WARN: Code duplicated, block: B:141:0x0f3a  */
    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public boolean onCreate() throws Throwable {
        Object[] objArr;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object[] objArr2;
        Context applicationContext;
        Object[] objArr3;
        Object objAccessartificialFrame;
        Object objAccessartificialFrame2;
        Object[] objArr4;
        Object[] objArr5;
        Object[] objArr6;
        Object[] objArr7;
        int i = 2 % 2;
        Object[] objArr8 = new Object[1];
        a(true, 16 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 228 - Color.red(0), View.resolveSizeAndState(0, 0, 0) + 22, new char[]{2, 17, 16, 22, 65520, 65483, 16, '\f', 65483, 1, 6, '\f', 15, 1, 11, 65534, '\b', 0, '\f', '\t', 65504, '\n'}, objArr8);
        String str = (String) objArr8[0];
        Object[] objArr9 = new Object[1];
        a(true, View.getDefaultSize(0, 0) + 13, 232 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), View.MeasureSpec.getMode(0) + 15, new char[]{2, CharUtils.CR, 5, 65530, 65534, 65515, 65533, 65534, '\f', '\t', 65530, 5, 65534, 65534, 6}, objArr9);
        String str2 = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        a(false, 13 - (Process.myPid() >> 22), Color.red(0) + 227, AndroidCharacter.getMirror('0') - ' ', new char[]{65535, 65484, '\n', 65535, '\f', 5, 65484, 65521, 23, 17, 18, 3, 11, '\b', 65535, 20}, objArr10);
        String str3 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        a(true, 15 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 230 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (ViewConfiguration.getFadingEdgeLength() >> 16) + 16, new char[]{65535, 65534, '\t', 65501, 2, CharUtils.CR, 65531, 65506, 19, 14, 3, 14, '\b', 65535, 65534, 3}, objArr11);
        String str4 = (String) objArr11[0];
        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame3 == null) {
            int threadPriority = 30 - ((Process.getThreadPriority(0) + 20) >> 6);
            char doubleTapTimeout = (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 49362);
            int mode = View.MeasureSpec.getMode(0) + 684;
            byte[] bArr = $$a;
            Object[] objArr12 = new Object[1];
            b(bArr[25], bArr[73], bArr[14], objArr12);
            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(threadPriority, doubleTapTimeout, mode, -1583976536, false, (String) objArr12[0], null);
        }
        long j = ((Field) objAccessartificialFrame3).getLong(null);
        if (j == -1 || j + 1866 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 73;
            artificialFrame = i2 % 128;
            int i3 = i2 % 2;
            try {
                Object[] objArr13 = {Integer.valueOf(iIntValue), -102619646};
                byte[] bArr2 = $$d;
                Object[] objArr14 = new Object[1];
                c((byte) (bArr2[10] + 1), bArr2[67], bArr2[341], objArr14);
                Class<?> cls = Class.forName((String) objArr14[0]);
                byte b = (byte) (-bArr2[147]);
                Object[] objArr15 = new Object[1];
                c(b, (short) (b & 244), bArr2[219], objArr15);
                objArr = (Object[]) cls.getMethod((String) objArr15[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr13);
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame4 == null) {
                    int deadChar = 30 - KeyEvent.getDeadChar(0, 0);
                    char jumpTapTimeout = (char) (49362 - (ViewConfiguration.getJumpTapTimeout() >> 16));
                    int minimumFlingVelocity = 684 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                    byte[] bArr3 = $$a;
                    Object[] objArr16 = new Object[1];
                    b(bArr3[36], (byte) (-bArr3[15]), bArr3[41], objArr16);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(deadChar, jumpTapTimeout, minimumFlingVelocity, -1456483158, false, (String) objArr16[0], null);
                }
                ((Field) objAccessartificialFrame4).set(null, objArr);
                try {
                    Long lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1056123296);
                    if (objAccessartificialFrame5 == null) {
                        int deadChar2 = KeyEvent.getDeadChar(0, 0) + 30;
                        char cMyPid = (char) (49362 - (Process.myPid() >> 22));
                        int i4 = 685 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                        byte[] bArr4 = $$a;
                        Object[] objArr17 = new Object[1];
                        b(bArr4[25], bArr4[73], bArr4[14], objArr17);
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(deadChar2, cMyPid, i4, -1583976536, false, (String) objArr17[0], null);
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
                int i5 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 30;
                char minimumFlingVelocity2 = (char) (49362 - (ViewConfiguration.getMinimumFlingVelocity() >> 16));
                int iAlpha = 684 - Color.alpha(0);
                byte[] bArr5 = $$a;
                Object[] objArr18 = new Object[1];
                b(bArr5[36], (byte) (-bArr5[15]), bArr5[41], objArr18);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i5, minimumFlingVelocity2, iAlpha, -1456483158, false, (String) objArr18[0], null);
            }
            Object[] objArr19 = (Object[]) ((Field) objAccessartificialFrame6).get(null);
            objArr = new Object[]{new int[]{((int[]) objArr19[0])[0]}, new int[]{((int[]) objArr19[1])[0]}, new int[1], (String) objArr19[3]};
            int iIdentityHashCode = System.identityHashCode(this);
            int i6 = 1755264798 + (((~(452539716 | iIdentityHashCode)) | 526084058) * 672);
            int i7 = ~iIdentityHashCode;
            int i8 = ((i6 + (((~(iIdentityHashCode | 526084058)) | (~((-452539717) | i7))) * (-672))) + (((~((-526084059) | i7)) | 84034202) * 672)) - 102619646;
            int i9 = (i8 << 13) ^ i8;
            int i10 = i9 ^ (i9 >>> 17);
            ((int[]) objArr[2])[0] = i10 ^ (i10 << 5);
        }
        int i11 = ((int[]) objArr[1])[0];
        int i12 = ((int[]) objArr[0])[0];
        if (i12 == i11) {
            int i13 = getARTIFICIAL_FRAME_PACKAGE_NAME + 13;
            artificialFrame = i13 % 128;
            int i14 = i13 % 2;
            int i15 = ((int[]) objArr[2])[0];
            Object[] objArr20 = {new int[]{((int[]) objArr[0])[0]}, new int[]{((int[]) objArr[1])[0]}, new int[1], (String) objArr[3]};
            int i16 = ~((int) Runtime.getRuntime().freeMemory());
            int i17 = i15 + (-994543266) + (((-805311045) | i16) * 494) + (((~(i16 | 134105530)) | (-900209375)) * 494);
            int i18 = (i17 << 13) ^ i17;
            int i19 = i18 ^ (i18 >>> 17);
            ((int[]) objArr20[2])[0] = i19 ^ (i19 << 5);
        } else {
            new ArrayList().add((String) objArr[3]);
            Object[] objArr21 = objArr;
            try {
                Object[] objArr22 = {Long.valueOf((((long) 1434806047) << 32) ^ ((long) (i11 ^ i12))), Long.valueOf(1434806031)};
                byte[] bArr6 = $$d;
                Object[] objArr23 = new Object[1];
                c((byte) (-bArr6[147]), bArr6[112], bArr6[99], objArr23);
                Class<?> cls2 = Class.forName((String) objArr23[0]);
                byte b2 = bArr6[67];
                byte b3 = b2;
                Object[] objArr24 = new Object[1];
                c(b3, (short) (b3 | 134), b2, objArr24);
                cls2.getMethod((String) objArr24[0], Long.TYPE, Long.TYPE).invoke(null, objArr22);
                int i20 = ((int[]) objArr21[2])[0];
                Object[] objArr25 = {new int[]{((int[]) objArr21[0])[0]}, new int[]{((int[]) objArr21[1])[0]}, new int[1], (String) objArr21[3]};
                int i21 = ~new Random().nextInt();
                int i22 = i20 + (-2138823650) + (((-809500687) | i21) * SyslogConstants.LOG_LOCAL7) + (((~(i21 | 126513040)) | (-893403679)) * SyslogConstants.LOG_LOCAL7);
                int i23 = (i22 << 13) ^ i22;
                int i24 = i23 ^ (i23 >>> 17);
                ((int[]) objArr25[2])[0] = i24 ^ (i24 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 != null) {
                    throw cause2;
                }
                throw th2;
            }
        }
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame7 == null) {
            int iGreen = 26 - Color.green(0);
            char scrollBarSize = (char) (ViewConfiguration.getScrollBarSize() >> 8);
            int iIndexOf = 1041 - TextUtils.indexOf("", "", 0);
            byte[] bArr7 = $$a;
            byte b4 = bArr7[12];
            byte b5 = bArr7[41];
            Object[] objArr26 = new Object[1];
            b(b4, (byte) (b5 - 1), b5, objArr26);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iGreen, scrollBarSize, iIndexOf, 2061780482, false, (String) objArr26[0], null);
        }
        long j2 = ((Field) objAccessartificialFrame7).getLong(null);
        if (j2 == -1 || j2 + 2031 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            try {
                Object[] objArr27 = {1380689620};
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame8 == null) {
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(8 - TextUtils.getOffsetBefore("", 0), (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 22250), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = KeylineState.Keyline.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame8).newInstance(objArr27), 2099127192, false);
                Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame9 == null) {
                    int iIndexOf2 = 26 - TextUtils.indexOf("", "", 0);
                    char cResolveSize = (char) View.resolveSize(0, 0);
                    int i25 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1041;
                    byte[] bArr8 = $$a;
                    byte b6 = bArr8[23];
                    byte b7 = bArr8[41];
                    Object[] objArr28 = new Object[1];
                    b(b6, (byte) (b7 - 1), b7, objArr28);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(iIndexOf2, cResolveSize, i25, 1145017376, false, (String) objArr28[0], null);
                }
                ((Field) objAccessartificialFrame9).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame10 == null) {
                        int i26 = 27 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                        char cResolveOpacity = (char) Drawable.resolveOpacity(0, 0);
                        int maximumDrawingCacheSize = 1041 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                        byte[] bArr9 = $$a;
                        byte b8 = bArr9[12];
                        byte b9 = bArr9[41];
                        Object[] objArr29 = new Object[1];
                        b(b8, (byte) (b9 - 1), b9, objArr29);
                        objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(i26, cResolveOpacity, maximumDrawingCacheSize, 2061780482, false, (String) objArr29[0], null);
                    }
                    ((Field) objAccessartificialFrame10).set(null, lValueOf2);
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
            int i27 = artificialFrame + 19;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i27 % 128;
            int i28 = i27 % 2;
            Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame11 == null) {
                int iNormalizeMetaState = 26 - KeyEvent.normalizeMetaState(0);
                char cResolveSize2 = (char) View.resolveSize(0, 0);
                int packedPositionGroup = ExpandableListView.getPackedPositionGroup(0L) + 1041;
                byte[] bArr10 = $$a;
                byte b10 = bArr10[23];
                byte b11 = bArr10[41];
                Object[] objArr30 = new Object[1];
                b(b10, (byte) (b11 - 1), b11, objArr30);
                objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState, cResolveSize2, packedPositionGroup, 1145017376, false, (String) objArr30[0], null);
            }
            Object[] objArr31 = (Object[]) ((Field) objAccessartificialFrame11).get(null);
            objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
            int i29 = ((int[]) objArr31[3])[0];
            int i30 = ((int[]) objArr31[2])[0];
            String[] strArr = (String[]) objArr31[0];
            int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
            int i31 = (-377502380) + (((~((-153616385) | startElapsedRealtime)) | (~((-75512578) | startElapsedRealtime))) * 69) + (((~(startElapsedRealtime | (-113261360))) | (~((-191365167) | startElapsedRealtime)) | 37748782) * (-69)) + 864432040;
            int i32 = (i31 << 13) ^ i31;
            int i33 = i32 ^ (i32 >>> 17);
            ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i33 ^ (i33 << 5);
        }
        int i34 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i35 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i35 == i34) {
            Object[] objArr32 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i36 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i37 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i38 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i39 = i36 + ((((~(780126597 | iIdentityHashCode2)) | (-492324610)) * 262) - 1353516778) + (((~((~iIdentityHashCode2) | 780126597)) | (-492324610)) * 262);
            int i40 = (i39 << 13) ^ i39;
            int i41 = i40 ^ (i40 >>> 17);
            ((int[]) objArr32[1])[0] = i41 ^ (i41 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr3 != null) {
                for (String str5 : strArr3) {
                    arrayList.add(str5);
                }
            }
            Object[] objArr33 = {Long.valueOf(((long) (i34 ^ i35)) ^ (((long) 1793842852) << 32)), Long.valueOf(1793842854)};
            byte[] bArr11 = $$d;
            Object[] objArr34 = new Object[1];
            c(bArr11[0], (short) ($$e & 908), bArr11[508], objArr34);
            Class<?> cls3 = Class.forName((String) objArr34[0]);
            byte b12 = bArr11[67];
            byte b13 = b12;
            Object[] objArr35 = new Object[1];
            c(b13, (short) (b13 | 134), b12, objArr35);
            cls3.getMethod((String) objArr35[0], Long.TYPE, Long.TYPE).invoke(null, objArr33);
            Object[] objArr36 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i42 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i43 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i44 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iIdentityHashCode3 = System.identityHashCode(this);
            int i45 = ~(814692231 | iIdentityHashCode3);
            int i46 = i42 + (-800186899) + (((-1005549456) | i45) * (-814)) + ((i45 | (~((~iIdentityHashCode3) | 736588424)) | 545731200) * 407) + (((~(iIdentityHashCode3 | (-736588425))) | (~((-814692232) | iIdentityHashCode3)) | 545731200) * 407);
            int i47 = (i46 << 13) ^ i46;
            int i48 = i47 ^ (i47 >>> 17);
            ((int[]) objArr36[1])[0] = i48 ^ (i48 << 5);
        }
        Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame12 == null) {
            int iGreen2 = Color.green(0) + 25;
            char c = (char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 30068);
            int i49 = 817 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
            byte[] bArr12 = $$a;
            byte b14 = bArr12[12];
            byte b15 = bArr12[41];
            Object[] objArr37 = new Object[1];
            b(b14, (byte) (b15 - 1), b15, objArr37);
            objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iGreen2, c, i49, 721586079, false, (String) objArr37[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame12).getLong(null);
        if (j3 == -1 || j3 + 1870 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr38 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -846600656};
            Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame13 == null) {
                int modifierMetaStateMask = 24 - ((byte) KeyEvent.getModifierMetaStateMask());
                char c2 = (char) (30068 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)));
                int iCombineMeasuredStates = 816 - View.combineMeasuredStates(0, 0);
                byte[] bArr13 = $$a;
                Object[] objArr39 = new Object[1];
                b((byte) 35, (byte) (bArr13[96] - 1), bArr13[55], objArr39);
                objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask, c2, iCombineMeasuredStates, -797394565, false, (String) objArr39[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr2 = (Object[]) ((Method) objAccessartificialFrame13).invoke(null, objArr38);
            Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame14 == null) {
                int touchSlop = 25 - (ViewConfiguration.getTouchSlop() >> 8);
                char c3 = (char) (30068 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)));
                int iIndexOf3 = TextUtils.indexOf("", "") + 816;
                byte[] bArr14 = $$a;
                byte b16 = bArr14[23];
                byte b17 = bArr14[41];
                Object[] objArr40 = new Object[1];
                b(b16, (byte) (b17 - 1), b17, objArr40);
                objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(touchSlop, c3, iIndexOf3, 891606461, false, (String) objArr40[0], null);
            }
            ((Field) objAccessartificialFrame14).set(null, objArr2);
            try {
                Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame15 == null) {
                    int i50 = 26 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                    char tapTimeout = (char) ((ViewConfiguration.getTapTimeout() >> 16) + 30068);
                    int iAlpha2 = 816 - Color.alpha(0);
                    byte[] bArr15 = $$a;
                    byte b18 = bArr15[12];
                    byte b19 = bArr15[41];
                    Object[] objArr41 = new Object[1];
                    b(b18, (byte) (b19 - 1), b19, objArr41);
                    objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(i50, tapTimeout, iAlpha2, 721586079, false, (String) objArr41[0], null);
                }
                ((Field) objAccessartificialFrame15).set(null, lValueOf3);
            } catch (Exception unused3) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame16 == null) {
                int i51 = 26 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                char cIndexOf = (char) (30067 - TextUtils.indexOf((CharSequence) "", '0', 0, 0));
                int keyRepeatDelay = 816 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                byte[] bArr16 = $$a;
                byte b20 = bArr16[23];
                byte b21 = bArr16[41];
                Object[] objArr42 = new Object[1];
                b(b20, (byte) (b21 - 1), b21, objArr42);
                objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(i51, cIndexOf, keyRepeatDelay, 891606461, false, (String) objArr42[0], null);
            }
            Object[] objArr43 = (Object[]) ((Field) objAccessartificialFrame16).get(null);
            objArr2 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i52 = ((int[]) objArr43[0])[0];
            int i53 = ((int[]) objArr43[1])[0];
            String[] strArr5 = (String[]) objArr43[2];
            int i54 = ~(System.identityHashCode(this) | (-143455161));
            int i55 = (-1621315653) + (((-341627527) | i54) * (-220)) + ((i54 | 142614840) * 220) + 1813749022;
            int i56 = (i55 << 13) ^ i55;
            int i57 = i56 ^ (i56 >>> 17);
            ((int[]) objArr2[3])[0] = i57 ^ (i57 << 5);
        }
        int i58 = ((int[]) objArr2[1])[0];
        int i59 = ((int[]) objArr2[0])[0];
        if (i59 == i58) {
            Object[] objArr44 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i60 = ((int[]) objArr2[3])[0];
            int i61 = ((int[]) objArr2[0])[0];
            int i62 = ((int[]) objArr2[1])[0];
            String[] strArr6 = (String[]) objArr2[2];
            int iIdentityHashCode4 = System.identityHashCode(this);
            int i63 = i60 + (-285018079) + (((~(442570132 | iIdentityHashCode4)) | (-640742499)) * (-948)) + ((~((~iIdentityHashCode4) | (-605085795))) * (-948)) + 1040372472;
            int i64 = (i63 << 13) ^ i63;
            int i65 = i64 ^ (i64 >>> 17);
            ((int[]) objArr44[3])[0] = i65 ^ (i65 << 5);
        } else {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr7 = (String[]) objArr2[2];
            if (strArr7 != null) {
                for (String str6 : strArr7) {
                    arrayList2.add(str6);
                }
            }
            Object[] objArr45 = {Long.valueOf((((long) (-1410832786)) << 32) ^ ((long) (i58 ^ i59))), Long.valueOf(-1410832785)};
            byte[] bArr17 = $$d;
            Object[] objArr46 = new Object[1];
            c((byte) (-bArr17[147]), (short) ($$e & 951), bArr17[327], objArr46);
            Class<?> cls4 = Class.forName((String) objArr46[0]);
            byte b22 = bArr17[67];
            byte b23 = b22;
            Object[] objArr47 = new Object[1];
            c(b23, (short) (b23 | 134), b22, objArr47);
            cls4.getMethod((String) objArr47[0], Long.TYPE, Long.TYPE).invoke(null, objArr45);
            Object[] objArr48 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i66 = ((int[]) objArr2[3])[0];
            int i67 = ((int[]) objArr2[0])[0];
            int i68 = ((int[]) objArr2[1])[0];
            String[] strArr8 = (String[]) objArr2[2];
            int iIdentityHashCode5 = System.identityHashCode(this);
            int i69 = ~iIdentityHashCode5;
            int i70 = ~((-49640185) | i69);
            int i71 = ~((-148532182) | iIdentityHashCode5);
            int i72 = i66 + (-2081787814) + ((i70 | i71) * 1150) + (((~(148532181 | i69)) | i71) * (-575)) + (((~(iIdentityHashCode5 | (-49640185))) | (~(i69 | 49640184))) * 575);
            int i73 = (i72 << 13) ^ i72;
            int i74 = i73 ^ (i73 >>> 17);
            ((int[]) objArr48[3])[0] = i74 ^ (i74 << 5);
        }
        Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame17 == null) {
            int iIndexOf4 = TextUtils.indexOf((CharSequence) "", '0', 0) + 22;
            char maximumFlingVelocity = (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16);
            int keyRepeatDelay2 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 465;
            byte[] bArr18 = $$a;
            byte b24 = bArr18[12];
            byte b25 = bArr18[41];
            Object[] objArr49 = new Object[1];
            b(b24, (byte) (b25 - 1), b25, objArr49);
            objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(iIndexOf4, maximumFlingVelocity, keyRepeatDelay2, -785931255, false, (String) objArr49[0], null);
        }
        long j4 = ((Field) objAccessartificialFrame17).getLong(null);
        if (j4 != -1) {
            int i75 = getARTIFICIAL_FRAME_PACKAGE_NAME + 71;
            artificialFrame = i75 % 128;
            if (i75 % 2 != 0 ? j4 + 1882 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue() : (j4 ^ 1882) < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[1]).invoke(null, new Object[1])).longValue()) {
                Object[] objArr50 = new Object[1];
                a(false, (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 10, KeyEvent.getDeadChar(0, 0) + 228, 26 - ExpandableListView.getPackedPositionType(0L), new char[]{19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15, '\f', 6, 1, 65483, 65534, CharUtils.CR, CharUtils.CR, 65483, 65502, 0, 17, 6}, objArr50);
                Class<?> cls5 = Class.forName((String) objArr50[0]);
                Object[] objArr51 = new Object[1];
                a(true, 12 - (ViewConfiguration.getTapTimeout() >> 16), 235 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 18 - TextUtils.indexOf("", ""), new char[]{65535, 2, 6, 6, 65495, '\n', 4, 65531, '\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529}, objArr51);
                applicationContext = (Context) cls5.getMethod((String) objArr51[0], new Class[0]).invoke(null, null);
                if (applicationContext != null) {
                    if ((applicationContext instanceof ContextWrapper) || ((ContextWrapper) applicationContext).getBaseContext() != null) {
                        applicationContext = applicationContext.getApplicationContext();
                    } else {
                        applicationContext = null;
                    }
                }
                int iIntValue3 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                Object[] objArr52 = new Object[1];
                a(true, 34 - Color.green(0), (KeyEvent.getMaxKeyCode() >> 16) + 203, 64 - (ViewConfiguration.getEdgeSlop() >> 16), new char[]{65515, 28, 28, 27, 65518, 26, 65510, 65513, 23, 65517, 28, 65518, 65519, 65515, 65515, 65516, 26, 27, 28, 65518, 65516, 65510, 23, 65515, 65519, 25, 65517, 28, 27, 65513, 65512, 65517, 65511, 28, 65513, 26, 25, 65517, 27, 23, 25, 65510, 23, 65516, 65514, 65519, 65517, 23, 23, 28, 65510, 25, 65514, 65518, 65515, 28, 25, 65510, 28, 65519, 28, 65518, 26, 65515}, objArr52);
                String str7 = (String) objArr52[0];
                Object[] objArr53 = new Object[1];
                a(true, TextUtils.getOffsetAfter("", 0) + 15, 198 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), TextUtils.lastIndexOf("", '0') + 65, new char[]{31, 65518, 65521, 29, 65520, 65524, 65516, 65519, 65515, '!', ' ', ' ', ' ', 65522, 65520, ' ', '!', 28, 65515, 65518, 65523, 28, 29, 65521, 65521, ' ', 29, '!', 28, 65518, 65522, 65517, 65522, 65515, 65518, 65517, 65520, 65517, 65524, 65520, ' ', 28, 65520, 65517, 65517, 65518, 65520, 65517, 29, 65520, 31, 65517, 65521, 65519, 65524, 28, 65520, '!', 28, ' ', 65516, 65521, 65518, 65524}, objArr53);
                Object[] objArr54 = {applicationContext, new String[]{str7, (String) objArr53[0]}, Integer.valueOf(iIntValue3), 1, 1220858442};
                byte[] bArr19 = $$d;
                Object[] objArr55 = new Object[1];
                c((byte) (bArr19[10] + 1), (short) ($$e & PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW), bArr19[137], objArr55);
                Class<?> cls6 = Class.forName((String) objArr55[0]);
                Object[] objArr56 = new Object[1];
                c((byte) (-bArr19[359]), (short) 290, bArr19[385], objArr56);
                objArr3 = (Object[]) cls6.getMethod((String) objArr56[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr54);
                int i76 = ((int[]) objArr3[0])[0];
                int i77 = ((int[]) objArr3[3])[0];
                if (applicationContext != null) {
                    int i78 = getARTIFICIAL_FRAME_PACKAGE_NAME + 1;
                    artificialFrame = i78 % 128;
                    int i79 = i78 % 2;
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1142731807);
                    if (objAccessartificialFrame == null) {
                        int scrollDefaultDelay = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 21;
                        char cBlue = (char) Color.blue(0);
                        int offsetAfter = TextUtils.getOffsetAfter("", 0) + 465;
                        byte[] bArr20 = $$a;
                        byte b26 = bArr20[23];
                        byte b27 = bArr20[41];
                        Object[] objArr57 = new Object[1];
                        b(b26, (byte) (b27 - 1), b27, objArr57);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(scrollDefaultDelay, cBlue, offsetAfter, -612765161, false, (String) objArr57[0], null);
                    }
                    ((Field) objAccessartificialFrame).set(null, objArr3);
                    try {
                        Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1313006081);
                        if (objAccessartificialFrame2 == null) {
                            int offsetBefore = TextUtils.getOffsetBefore("", 0) + 21;
                            char packedPositionType = (char) ExpandableListView.getPackedPositionType(0L);
                            int tapTimeout2 = 465 - (ViewConfiguration.getTapTimeout() >> 16);
                            byte[] bArr21 = $$a;
                            byte b28 = bArr21[12];
                            byte b29 = bArr21[41];
                            Object[] objArr58 = new Object[1];
                            b(b28, (byte) (b29 - 1), b29, objArr58);
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(offsetBefore, packedPositionType, tapTimeout2, -785931255, false, (String) objArr58[0], null);
                        }
                        ((Field) objAccessartificialFrame2).set(null, lValueOf4);
                    } catch (Exception unused4) {
                        throw new RuntimeException();
                    }
                }
            } else {
                Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame18 == null) {
                    int i80 = 22 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                    char keyRepeatDelay3 = (char) (ViewConfiguration.getKeyRepeatDelay() >> 16);
                    int i81 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 464;
                    byte[] bArr22 = $$a;
                    byte b30 = bArr22[23];
                    byte b31 = bArr22[41];
                    Object[] objArr59 = new Object[1];
                    b(b30, (byte) (b31 - 1), b31, objArr59);
                    objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(i80, keyRepeatDelay3, i81, -612765161, false, (String) objArr59[0], null);
                }
                Object[] objArr60 = (Object[]) ((Field) objAccessartificialFrame18).get(null);
                objArr3 = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
                int i82 = ((int[]) objArr60[3])[0];
                int i83 = ((int[]) objArr60[0])[0];
                String[] strArr9 = (String[]) objArr60[1];
                int iMyPid = Process.myPid();
                int i84 = ((~((~iMyPid) | 1073446882)) * 130) + 106478947 + (((~(iMyPid | 1073446882)) | 644364544) * 130) + 1220858442;
                int i85 = (i84 << 13) ^ i84;
                int i86 = i85 ^ (i85 >>> 17);
                ((int[]) objArr3[2])[0] = i86 ^ (i86 << 5);
            }
        } else {
            Object[] objArr510 = new Object[1];
            a(false, (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 10, KeyEvent.getDeadChar(0, 0) + 228, 26 - ExpandableListView.getPackedPositionType(0L), new char[]{19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15, '\f', 6, 1, 65483, 65534, CharUtils.CR, CharUtils.CR, 65483, 65502, 0, 17, 6}, objArr510);
            Class<?> cls7 = Class.forName((String) objArr510[0]);
            Object[] objArr511 = new Object[1];
            a(true, 12 - (ViewConfiguration.getTapTimeout() >> 16), 235 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 18 - TextUtils.indexOf("", ""), new char[]{65535, 2, 6, 6, 65495, '\n', 4, 65531, '\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529}, objArr511);
            applicationContext = (Context) cls7.getMethod((String) objArr511[0], new Class[0]).invoke(null, null);
            if (applicationContext != null) {
                if (applicationContext instanceof ContextWrapper) {
                    applicationContext = applicationContext.getApplicationContext();
                } else {
                    applicationContext = applicationContext.getApplicationContext();
                }
            }
            int iIntValue4 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr512 = new Object[1];
            a(true, 34 - Color.green(0), (KeyEvent.getMaxKeyCode() >> 16) + 203, 64 - (ViewConfiguration.getEdgeSlop() >> 16), new char[]{65515, 28, 28, 27, 65518, 26, 65510, 65513, 23, 65517, 28, 65518, 65519, 65515, 65515, 65516, 26, 27, 28, 65518, 65516, 65510, 23, 65515, 65519, 25, 65517, 28, 27, 65513, 65512, 65517, 65511, 28, 65513, 26, 25, 65517, 27, 23, 25, 65510, 23, 65516, 65514, 65519, 65517, 23, 23, 28, 65510, 25, 65514, 65518, 65515, 28, 25, 65510, 28, 65519, 28, 65518, 26, 65515}, objArr512);
            String str8 = (String) objArr512[0];
            Object[] objArr513 = new Object[1];
            a(true, TextUtils.getOffsetAfter("", 0) + 15, 198 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), TextUtils.lastIndexOf("", '0') + 65, new char[]{31, 65518, 65521, 29, 65520, 65524, 65516, 65519, 65515, '!', ' ', ' ', ' ', 65522, 65520, ' ', '!', 28, 65515, 65518, 65523, 28, 29, 65521, 65521, ' ', 29, '!', 28, 65518, 65522, 65517, 65522, 65515, 65518, 65517, 65520, 65517, 65524, 65520, ' ', 28, 65520, 65517, 65517, 65518, 65520, 65517, 29, 65520, 31, 65517, 65521, 65519, 65524, 28, 65520, '!', 28, ' ', 65516, 65521, 65518, 65524}, objArr513);
            Object[] objArr514 = {applicationContext, new String[]{str8, (String) objArr513[0]}, Integer.valueOf(iIntValue4), 1, 1220858442};
            byte[] bArr110 = $$d;
            Object[] objArr515 = new Object[1];
            c((byte) (bArr110[10] + 1), (short) ($$e & PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW), bArr110[137], objArr515);
            Class<?> cls8 = Class.forName((String) objArr515[0]);
            Object[] objArr516 = new Object[1];
            c((byte) (-bArr110[359]), (short) 290, bArr110[385], objArr516);
            objArr3 = (Object[]) cls8.getMethod((String) objArr516[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr514);
            int i710 = ((int[]) objArr3[0])[0];
            int i711 = ((int[]) objArr3[3])[0];
            if (applicationContext != null) {
                int i712 = getARTIFICIAL_FRAME_PACKAGE_NAME + 1;
                artificialFrame = i712 % 128;
                int i713 = i712 % 2;
                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame == null) {
                    int scrollDefaultDelay2 = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 21;
                    char cBlue2 = (char) Color.blue(0);
                    int offsetAfter2 = TextUtils.getOffsetAfter("", 0) + 465;
                    byte[] bArr23 = $$a;
                    byte b210 = bArr23[23];
                    byte b211 = bArr23[41];
                    Object[] objArr517 = new Object[1];
                    b(b210, (byte) (b211 - 1), b211, objArr517);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(scrollDefaultDelay2, cBlue2, offsetAfter2, -612765161, false, (String) objArr517[0], null);
                }
                ((Field) objAccessartificialFrame).set(null, objArr3);
                Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1313006081);
                if (objAccessartificialFrame2 == null) {
                    int offsetBefore2 = TextUtils.getOffsetBefore("", 0) + 21;
                    char packedPositionType2 = (char) ExpandableListView.getPackedPositionType(0L);
                    int tapTimeout3 = 465 - (ViewConfiguration.getTapTimeout() >> 16);
                    byte[] bArr24 = $$a;
                    byte b212 = bArr24[12];
                    byte b213 = bArr24[41];
                    Object[] objArr518 = new Object[1];
                    b(b212, (byte) (b213 - 1), b213, objArr518);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(offsetBefore2, packedPositionType2, tapTimeout3, -785931255, false, (String) objArr518[0], null);
                }
                ((Field) objAccessartificialFrame2).set(null, lValueOf5);
            }
        }
        int i87 = ((int[]) objArr3[0])[0];
        int i88 = ((int[]) objArr3[3])[0];
        if (i88 == i87) {
            int i89 = artificialFrame + 31;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i89 % 128;
            int i90 = i89 % 2;
            Object[] objArr61 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i91 = ((int[]) objArr3[2])[0];
            int i92 = ((int[]) objArr3[3])[0];
            int i93 = ((int[]) objArr3[0])[0];
            String[] strArr10 = (String[]) objArr3[1];
            int iIdentityHashCode6 = System.identityHashCode(this);
            int i94 = i91 + (-1260349191) + ((~((~iIdentityHashCode6) | (-43254275))) * (-116)) + ((493543732 | iIdentityHashCode6) * 116) + (((~(iIdentityHashCode6 | 333194006)) | 203604000) * 116);
            int i95 = (i94 << 13) ^ i94;
            int i96 = i95 ^ (i95 >>> 17);
            ((int[]) objArr61[2])[0] = i96 ^ (i96 << 5);
        } else {
            ArrayList arrayList3 = new ArrayList();
            String[] strArr11 = (String[]) objArr3[1];
            if (strArr11 != null) {
                int i97 = artificialFrame + 117;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i97 % 128;
                int i98 = i97 % 2;
                for (String str9 : strArr11) {
                    arrayList3.add(str9);
                }
            }
            Object[] objArr62 = {Long.valueOf(((long) (i87 ^ i88)) ^ (((long) (-1438451495)) << 32)), Long.valueOf(-1438451559)};
            byte[] bArr25 = $$d;
            Object[] objArr63 = new Object[1];
            c((byte) (-bArr25[147]), (short) 310, (byte) (-bArr25[159]), objArr63);
            Class<?> cls9 = Class.forName((String) objArr63[0]);
            byte b32 = bArr25[67];
            byte b33 = b32;
            Object[] objArr64 = new Object[1];
            c(b33, (short) (b33 | 134), b32, objArr64);
            cls9.getMethod((String) objArr64[0], Long.TYPE, Long.TYPE).invoke(null, objArr62);
            Object[] objArr65 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i99 = ((int[]) objArr3[2])[0];
            int i100 = ((int[]) objArr3[3])[0];
            int i101 = ((int[]) objArr3[0])[0];
            String[] strArr12 = (String[]) objArr3[1];
            int iIdentityHashCode7 = System.identityHashCode(this);
            int i102 = ~(890122422 | iIdentityHashCode7);
            int i103 = ~iIdentityHashCode7;
            int i104 = i102 | (~(1050472148 | i103));
            int i105 = ~((-890122423) | i103);
            int i106 = i99 + (-459068943) + ((i104 | i105) * (-516)) + (((~(iIdentityHashCode7 | (-177262145))) | (~((-873210005) | i103))) * 516) + ((873210004 | i105) * 516);
            int i107 = (i106 << 13) ^ i106;
            int i108 = i107 ^ (i107 >>> 17);
            ((int[]) objArr65[2])[0] = i108 ^ (i108 << 5);
        }
        Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame19 == null) {
            int deadChar3 = 17 - KeyEvent.getDeadChar(0, 0);
            char size = (char) View.MeasureSpec.getSize(0);
            int iRed = 747 - Color.red(0);
            byte[] bArr26 = $$a;
            byte b34 = bArr26[12];
            byte b35 = bArr26[41];
            Object[] objArr66 = new Object[1];
            b(b34, (byte) (b35 - 1), b35, objArr66);
            objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(deadChar3, size, iRed, -144068856, false, (String) objArr66[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame19).getLong(null);
        if (j5 == -1 || j5 + 1877 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr67 = new Object[1];
            a(false, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 9, ImageFormat.getBitsPerPixel(0) + 229, 27 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), new char[]{19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15, '\f', 6, 1, 65483, 65534, CharUtils.CR, CharUtils.CR, 65483, 65502, 0, 17, 6}, objArr67);
            Class<?> cls10 = Class.forName((String) objArr67[0]);
            Object[] objArr68 = new Object[1];
            a(true, 12 - Color.blue(0), View.MeasureSpec.getMode(0) + 235, (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18, new char[]{65535, 2, 6, 6, 65495, '\n', 4, 65531, '\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529}, objArr68);
            Context applicationContext2 = (Context) cls10.getMethod((String) objArr68[0], new Class[0]).invoke(null, null);
            if (applicationContext2 != null) {
                applicationContext2 = ((applicationContext2 instanceof ContextWrapper) && ((ContextWrapper) applicationContext2).getBaseContext() == null) ? null : applicationContext2.getApplicationContext();
            }
            Object[] objArr69 = {applicationContext2, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 2112256657};
            byte[] bArr27 = $$d;
            Object[] objArr70 = new Object[1];
            c((byte) (-bArr27[147]), (short) 352, (byte) (-bArr27[123]), objArr70);
            Class<?> cls11 = Class.forName((String) objArr70[0]);
            Object[] objArr71 = new Object[1];
            c((byte) (-bArr27[174]), (short) 396, bArr27[108], objArr71);
            objArr4 = (Object[]) cls11.getMethod((String) objArr71[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr69);
            Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame20 == null) {
                int touchSlop2 = 17 - (ViewConfiguration.getTouchSlop() >> 8);
                char windowTouchSlop = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                int iMyTid = 747 - (Process.myTid() >> 22);
                byte[] bArr28 = $$a;
                byte b36 = bArr28[23];
                byte b37 = bArr28[41];
                Object[] objArr72 = new Object[1];
                b(b36, (byte) (b37 - 1), b37, objArr72);
                objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(touchSlop2, windowTouchSlop, iMyTid, -1031537386, false, (String) objArr72[0], null);
            }
            ((Field) objAccessartificialFrame20).set(null, objArr4);
            try {
                Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame21 == null) {
                    int iAxisFromString = 16 - MotionEvent.axisFromString("");
                    char mirror = (char) (AndroidCharacter.getMirror('0') - '0');
                    int i109 = 747 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                    byte[] bArr29 = $$a;
                    byte b38 = bArr29[12];
                    byte b39 = bArr29[41];
                    Object[] objArr73 = new Object[1];
                    b(b38, (byte) (b39 - 1), b39, objArr73);
                    objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(iAxisFromString, mirror, i109, -144068856, false, (String) objArr73[0], null);
                }
                ((Field) objAccessartificialFrame21).set(null, lValueOf6);
            } catch (Exception unused5) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame22 == null) {
                int mode2 = 17 - View.MeasureSpec.getMode(0);
                char capsMode = (char) TextUtils.getCapsMode("", 0, 0);
                int i110 = 747 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                byte[] bArr30 = $$a;
                byte b40 = bArr30[23];
                byte b41 = bArr30[41];
                Object[] objArr74 = new Object[1];
                b(b40, (byte) (b41 - 1), b41, objArr74);
                objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(mode2, capsMode, i110, -1031537386, false, (String) objArr74[0], null);
            }
            Object[] objArr75 = (Object[]) ((Field) objAccessartificialFrame22).get(null);
            objArr4 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
            int i111 = ((int[]) objArr75[3])[0];
            int i112 = ((int[]) objArr75[4])[0];
            List list = (List) objArr75[0];
            List list2 = (List) objArr75[2];
            int iIdentityHashCode8 = System.identityHashCode(this);
            int i113 = ~iIdentityHashCode8;
            int i114 = (-902630323) + (((~(600532969 | i113)) | 4915488) * 220) + (((~(i113 | 550183913)) | 55264544) * (-440)) + ((iIdentityHashCode8 | 600532969) * 220) + 2112256657;
            int i115 = (i114 << 13) ^ i114;
            int i116 = i115 ^ (i115 >>> 17);
            ((int[]) objArr4[1])[0] = i116 ^ (i116 << 5);
        }
        int i117 = ((int[]) objArr4[4])[0];
        int i118 = ((int[]) objArr4[3])[0];
        if (i118 == i117) {
            Object[] objArr76 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i119 = ((int[]) objArr4[1])[0];
            int i120 = ((int[]) objArr4[3])[0];
            int i121 = ((int[]) objArr4[4])[0];
            List list3 = (List) objArr4[0];
            List list4 = (List) objArr4[2];
            int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
            int i122 = ~iMaxMemory;
            int i123 = i119 + 783565788 + (((~((-405126723) | i122)) | 268768256) * 98) + (((~(i122 | (-200321736))) | (-405126723) | (~(200321735 | iMaxMemory))) * (-49)) + (((~(iMaxMemory | (-405126723))) | (-469089992)) * 49);
            int i124 = (i123 << 13) ^ i123;
            int i125 = i124 ^ (i124 >>> 17);
            ((int[]) objArr76[1])[0] = i125 ^ (i125 << 5);
        } else {
            ArrayList arrayList4 = new ArrayList();
            Object[] objArr77 = {objArr4};
            Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1804664566);
            if (objAccessartificialFrame23 == null) {
                objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 41, (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 12468), TextUtils.getTrimmedLength("") + 3642, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
            }
            arrayList4.add(((Method) objAccessartificialFrame23).invoke(null, objArr77));
            Object[] objArr78 = {objArr4};
            Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-1243809191);
            if (objAccessartificialFrame24 == null) {
                objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 41, (char) (KeyEvent.keyCodeFromString("") + 12468), 3642 - TextUtils.indexOf("", "", 0), 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
            }
            arrayList4.add(((Method) objAccessartificialFrame24).invoke(null, objArr78));
            long j6 = ((long) (i117 ^ i118)) ^ (((long) 317111680) << 32);
            long j7 = 317111688;
            int i126 = getARTIFICIAL_FRAME_PACKAGE_NAME + 29;
            artificialFrame = i126 % 128;
            int i127 = i126 % 2;
            Object[] objArr79 = {Long.valueOf(j6), Long.valueOf(j7)};
            byte[] bArr31 = $$d;
            Object[] objArr80 = new Object[1];
            c((byte) (-bArr31[147]), (short) 415, bArr31[83], objArr80);
            Class<?> cls12 = Class.forName((String) objArr80[0]);
            byte b42 = bArr31[67];
            byte b43 = b42;
            Object[] objArr81 = new Object[1];
            c(b43, (short) (b43 | 134), b42, objArr81);
            cls12.getMethod((String) objArr81[0], Long.TYPE, Long.TYPE).invoke(null, objArr79);
            Object[] objArr82 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i128 = ((int[]) objArr4[1])[0];
            int i129 = ((int[]) objArr4[3])[0];
            int i130 = ((int[]) objArr4[4])[0];
            List list5 = (List) objArr4[0];
            List list6 = (List) objArr4[2];
            int iMaxMemory2 = (int) Runtime.getRuntime().maxMemory();
            int i131 = ~iMaxMemory2;
            int i132 = i128 + 1065131481 + ((~(164261277 | i131)) * (-560)) + ((~(iMaxMemory2 | (-302092897))) * (-560)) + (((~(441187180 | i131)) | 25166993) * 560);
            int i133 = (i132 << 13) ^ i132;
            int i134 = i133 ^ (i133 >>> 17);
            ((int[]) objArr82[1])[0] = i134 ^ (i134 << 5);
        }
        Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame25 == null) {
            int iIndexOf5 = 29 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
            char size2 = (char) (49362 - View.MeasureSpec.getSize(0));
            int iIndexOf6 = 683 - TextUtils.indexOf((CharSequence) "", '0', 0);
            byte[] bArr32 = $$a;
            Object[] objArr83 = new Object[1];
            b((byte) 46, bArr32[72], bArr32[113], objArr83);
            objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(iIndexOf5, size2, iIndexOf6, 752929587, false, (String) objArr83[0], null);
        }
        long j8 = ((Field) objAccessartificialFrame25).getLong(null);
        if (j8 == -1 || j8 + 1899 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr84 = new Object[1];
            a(false, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 9, 228 - (ViewConfiguration.getPressedStateDuration() >> 16), 26 - (ViewConfiguration.getDoubleTapTimeout() >> 16), new char[]{19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15, '\f', 6, 1, 65483, 65534, CharUtils.CR, CharUtils.CR, 65483, 65502, 0, 17, 6}, objArr84);
            Class<?> cls13 = Class.forName((String) objArr84[0]);
            Object[] objArr85 = new Object[1];
            a(true, 11 - TextUtils.lastIndexOf("", '0', 0, 0), 235 - Color.argb(0, 0, 0, 0), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 19, new char[]{65535, 2, 6, 6, 65495, '\n', 4, 65531, '\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529}, objArr85);
            Context applicationContext3 = (Context) cls13.getMethod((String) objArr85[0], new Class[0]).invoke(null, null);
            if (applicationContext3 != null) {
                applicationContext3 = ((applicationContext3 instanceof ContextWrapper) && ((ContextWrapper) applicationContext3).getBaseContext() == null) ? null : applicationContext3.getApplicationContext();
            }
            int iIntValue5 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            int i135 = artificialFrame + 65;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i135 % 128;
            int i136 = i135 % 2;
            Object[] objArr86 = {applicationContext3, Integer.valueOf(iIntValue5), 0, -1255779190};
            byte[] bArr33 = $$d;
            Object[] objArr87 = new Object[1];
            c((byte) (-bArr33[147]), (short) 474, (byte) (-bArr33[159]), objArr87);
            Class<?> cls14 = Class.forName((String) objArr87[0]);
            Object[] objArr88 = new Object[1];
            c((byte) (-bArr33[174]), (short) 396, bArr33[108], objArr88);
            objArr5 = (Object[]) cls14.getMethod((String) objArr88[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr86);
            if (applicationContext3 != null) {
                Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(-326560385);
                if (objAccessartificialFrame26 == null) {
                    int maximumFlingVelocity2 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 30;
                    char jumpTapTimeout2 = (char) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 49362);
                    int bitsPerPixel = 683 - ImageFormat.getBitsPerPixel(0);
                    byte[] bArr34 = $$a;
                    Object[] objArr89 = new Object[1];
                    b((byte) 61, bArr34[73], bArr34[113], objArr89);
                    objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity2, jumpTapTimeout2, bitsPerPixel, 1944867703, false, (String) objArr89[0], null);
                }
                ((Field) objAccessartificialFrame26).set(null, objArr5);
                try {
                    Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                    if (objAccessartificialFrame27 == null) {
                        int iResolveSize = View.resolveSize(0, 0) + 30;
                        char c4 = (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 49361);
                        int touchSlop3 = 684 - (ViewConfiguration.getTouchSlop() >> 8);
                        byte[] bArr35 = $$a;
                        Object[] objArr90 = new Object[1];
                        b((byte) 46, bArr35[72], bArr35[113], objArr90);
                        objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(iResolveSize, c4, touchSlop3, 752929587, false, (String) objArr90[0], null);
                    }
                    ((Field) objAccessartificialFrame27).set(null, lValueOf7);
                } catch (Exception unused6) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(-326560385);
            if (objAccessartificialFrame28 == null) {
                int iIndexOf7 = TextUtils.indexOf((CharSequence) "", '0') + 31;
                char cResolveSize3 = (char) (View.resolveSize(0, 0) + 49362);
                int i137 = 684 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                byte[] bArr36 = $$a;
                Object[] objArr91 = new Object[1];
                b((byte) 61, bArr36[73], bArr36[113], objArr91);
                objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(iIndexOf7, cResolveSize3, i137, 1944867703, false, (String) objArr91[0], null);
            }
            Object[] objArr92 = (Object[]) ((Field) objAccessartificialFrame28).get(null);
            objArr5 = new Object[]{new int[]{((int[]) objArr92[0])[0]}, new int[]{((int[]) objArr92[1])[0]}, new int[1], (String) objArr92[3]};
            int iMyPid2 = Process.myPid();
            int i138 = ~iMyPid2;
            int i139 = (((-2002800006) + (((~((-474794098) | i138)) | (~((-503829678) | iMyPid2))) * (-370))) + ((((~(iMyPid2 | (-474794098))) | (~(i138 | (-503829678)))) | (-508550398)) * (-370))) - 440865426;
            int i140 = (i139 << 13) ^ i139;
            int i141 = i140 ^ (i140 >>> 17);
            ((int[]) objArr5[2])[0] = i141 ^ (i141 << 5);
        }
        int i142 = ((int[]) objArr5[1])[0];
        int i143 = ((int[]) objArr5[0])[0];
        if (i143 == i142) {
            int i144 = ((int[]) objArr5[2])[0];
            Object[] objArr93 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int iNextInt = new Random().nextInt(1552313946);
            int i145 = i144 + 1676579292 + (((~((-6627713) | (~iNextInt))) | (-971996063)) * (-591)) + ((iNextInt | (-6627713)) * 591);
            int i146 = (i145 << 13) ^ i145;
            int i147 = i146 ^ (i146 >>> 17);
            ((int[]) objArr93[2])[0] = i147 ^ (i147 << 5);
        } else {
            Object[] objArr94 = {Long.valueOf((((long) 1888060446) << 32) ^ ((long) (i142 ^ i143))), Long.valueOf(1888060442)};
            byte[] bArr37 = $$d;
            Object[] objArr95 = new Object[1];
            c((byte) (-bArr37[147]), (short) 516, bArr37[468], objArr95);
            Class<?> cls15 = Class.forName((String) objArr95[0]);
            byte b44 = bArr37[67];
            byte b45 = b44;
            Object[] objArr96 = new Object[1];
            c(b45, (short) (b45 | 134), b44, objArr96);
            cls15.getMethod((String) objArr96[0], Long.TYPE, Long.TYPE).invoke(null, objArr94);
            int i148 = ((int[]) objArr5[2])[0];
            Object[] objArr97 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int iIdentityHashCode9 = System.identityHashCode(this);
            int i149 = ~iIdentityHashCode9;
            int i150 = i148 + 1370957172 + ((~((-70143815) | i149)) * 979) + ((iIdentityHashCode9 | 908479960) * (-979)) + (((~(iIdentityHashCode9 | (-70143815))) | (~(i149 | 908479960))) * 979);
            int i151 = (i150 << 13) ^ i150;
            int i152 = i151 ^ (i151 >>> 17);
            ((int[]) objArr97[2])[0] = i152 ^ (i152 << 5);
        }
        Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame29 == null) {
            int modifierMetaStateMask2 = 29 - ((byte) KeyEvent.getModifierMetaStateMask());
            char windowTouchSlop2 = (char) (49362 - (ViewConfiguration.getWindowTouchSlop() >> 8));
            int packedPositionType3 = ExpandableListView.getPackedPositionType(0L) + 684;
            byte b46 = (byte) ($$b + 1);
            byte[] bArr38 = $$a;
            Object[] objArr98 = new Object[1];
            b(b46, bArr38[72], bArr38[14], objArr98);
            objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask2, windowTouchSlop2, packedPositionType3, 508509282, false, (String) objArr98[0], null);
        }
        long j9 = ((Field) objAccessartificialFrame29).getLong(null);
        if (j9 == -1 || j9 + 1881 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr99 = new Object[1];
            a(false, 10 - Color.green(0), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 228, KeyEvent.keyCodeFromString("") + 26, new char[]{19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15, '\f', 6, 1, 65483, 65534, CharUtils.CR, CharUtils.CR, 65483, 65502, 0, 17, 6}, objArr99);
            Class<?> cls16 = Class.forName((String) objArr99[0]);
            Object[] objArr100 = new Object[1];
            a(true, 11 - Process.getGidForName(""), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 234, 18 - View.resolveSizeAndState(0, 0, 0), new char[]{65535, 2, 6, 6, 65495, '\n', 4, 65531, '\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529}, objArr100);
            Context applicationContext4 = (Context) cls16.getMethod((String) objArr100[0], new Class[0]).invoke(null, null);
            if (applicationContext4 != null) {
                applicationContext4 = ((applicationContext4 instanceof ContextWrapper) && ((ContextWrapper) applicationContext4).getBaseContext() == null) ? null : applicationContext4.getApplicationContext();
            }
            Object[] objArr101 = {applicationContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -847899874};
            byte[] bArr39 = $$d;
            Object[] objArr102 = new Object[1];
            c((byte) (-bArr39[147]), (short) 550, bArr39[468], objArr102);
            Class<?> cls17 = Class.forName((String) objArr102[0]);
            Object[] objArr103 = new Object[1];
            c((byte) (-bArr39[359]), (short) 290, bArr39[385], objArr103);
            objArr6 = (Object[]) cls17.getMethod((String) objArr103[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr101);
            if (applicationContext4 != null) {
                Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame30 == null) {
                    int windowTouchSlop3 = (ViewConfiguration.getWindowTouchSlop() >> 8) + 30;
                    char c5 = (char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 49362);
                    int iAxisFromString2 = 683 - MotionEvent.axisFromString("");
                    byte[] bArr40 = $$a;
                    Object[] objArr104 = new Object[1];
                    b((byte) 88, bArr40[113], (byte) (bArr40[41] - 1), objArr104);
                    objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(windowTouchSlop3, c5, iAxisFromString2, -1321816393, false, (String) objArr104[0], null);
                }
                ((Field) objAccessartificialFrame30).set(null, objArr6);
                try {
                    Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                    if (objAccessartificialFrame31 == null) {
                        int bitsPerPixel2 = ImageFormat.getBitsPerPixel(0) + 31;
                        char offsetAfter3 = (char) (49362 - TextUtils.getOffsetAfter("", 0));
                        int deadChar4 = KeyEvent.getDeadChar(0, 0) + 684;
                        byte b47 = (byte) ($$b + 1);
                        byte[] bArr41 = $$a;
                        Object[] objArr105 = new Object[1];
                        b(b47, bArr41[72], bArr41[14], objArr105);
                        objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(bitsPerPixel2, offsetAfter3, deadChar4, 508509282, false, (String) objArr105[0], null);
                    }
                    ((Field) objAccessartificialFrame31).set(null, lValueOf8);
                } catch (Exception unused7) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(777251007);
            if (objAccessartificialFrame32 == null) {
                int i153 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 31;
                char windowTouchSlop4 = (char) (49362 - (ViewConfiguration.getWindowTouchSlop() >> 8));
                int scrollBarSize2 = (ViewConfiguration.getScrollBarSize() >> 8) + 684;
                byte[] bArr42 = $$a;
                Object[] objArr106 = new Object[1];
                b((byte) 88, bArr42[113], (byte) (bArr42[41] - 1), objArr106);
                objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(i153, windowTouchSlop4, scrollBarSize2, -1321816393, false, (String) objArr106[0], null);
            }
            Object[] objArr107 = (Object[]) ((Field) objAccessartificialFrame32).get(null);
            objArr6 = new Object[]{new int[]{((int[]) objArr107[0])[0]}, new int[]{((int[]) objArr107[1])[0]}, new int[1], (String) objArr107[3]};
            int iUptimeMillis = (int) SystemClock.uptimeMillis();
            int i154 = ~iUptimeMillis;
            int i155 = (((2067020644 + (((~((-583138721) | i154)) | 395485054) * (-90))) + (((~((-583138721) | iUptimeMillis)) | (-936640511)) * (-45))) + ((((~(iUptimeMillis | (-395485055))) | (-583138721)) | (~(i154 | 395485054))) * 45)) - 847899874;
            int i156 = (i155 << 13) ^ i155;
            int i157 = i156 ^ (i156 >>> 17);
            ((int[]) objArr6[2])[0] = i157 ^ (i157 << 5);
        }
        int i158 = ((int[]) objArr6[1])[0];
        int i159 = ((int[]) objArr6[0])[0];
        if (i159 == i158) {
            int i160 = ((int[]) objArr6[2])[0];
            Object[] objArr108 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
            int iIdentityHashCode10 = System.identityHashCode(this);
            int i161 = i160 + ((((-67954274) + (((~((-760691172) | iIdentityHashCode10)) | 206905635) * 576)) + (((~((~iIdentityHashCode10) | (-553785537))) | 11026968) * 576)) - 1081438528);
            int i162 = (i161 << 13) ^ i161;
            int i163 = i162 ^ (i162 >>> 17);
            ((int[]) objArr108[2])[0] = i163 ^ (i163 << 5);
        } else {
            Object[] objArr109 = {Long.valueOf((((long) 2080476045) << 32) ^ ((long) (i158 ^ i159))), Long.valueOf(2080475533)};
            byte[] bArr43 = $$d;
            Object[] objArr110 = new Object[1];
            c((byte) (-bArr43[147]), (short) 516, bArr43[468], objArr110);
            Class<?> cls18 = Class.forName((String) objArr110[0]);
            byte b48 = bArr43[67];
            byte b49 = b48;
            Object[] objArr111 = new Object[1];
            c(b49, (short) (b49 | 134), b48, objArr111);
            cls18.getMethod((String) objArr111[0], Long.TYPE, Long.TYPE).invoke(null, objArr109);
            int i164 = ((int[]) objArr6[2])[0];
            Object[] objArr112 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
            int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
            int i165 = i164 + ((((~((-417401437) | iElapsedRealtime)) | 965908638) * 398) - 1615818154) + (((~((~iElapsedRealtime) | (-417401437))) | 965908638) * 398);
            int i166 = (i165 << 13) ^ i165;
            int i167 = i166 ^ (i166 >>> 17);
            ((int[]) objArr112[2])[0] = i167 ^ (i167 << 5);
        }
        Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame33 == null) {
            int i168 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 35;
            char cBlue3 = (char) Color.blue(0);
            int i169 = 541 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
            byte[] bArr44 = $$a;
            byte b50 = bArr44[12];
            byte b51 = bArr44[41];
            Object[] objArr113 = new Object[1];
            b(b50, (byte) (b51 - 1), b51, objArr113);
            objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(i168, cBlue3, i169, 624296913, false, (String) objArr113[0], null);
        }
        long j10 = ((Field) objAccessartificialFrame33).getLong(null);
        if (j10 == -1 || j10 + 1947 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(-1717965552);
            if (objAccessartificialFrame34 == null) {
                objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(20 - (Process.myPid() >> 22), (char) (39515 - TextUtils.lastIndexOf("", '0', 0)), Color.alpha(0) + 982, 117222168, false, null, new Class[0]);
            }
            Object[] objArr114 = {null, ((Constructor) objAccessartificialFrame34).newInstance(null), -93863527, 0};
            Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(-501205803);
            if (objAccessartificialFrame35 == null) {
                int iKeyCodeFromString = 36 - KeyEvent.keyCodeFromString("");
                char cLastIndexOf = (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0));
                int modifierMetaStateMask3 = ((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.GS;
                byte b52 = (byte) ($$b | 20);
                Object[] objArr115 = new Object[1];
                b(b52, (byte) (b52 >>> 1), $$a[19], objArr115);
                objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString, cLastIndexOf, modifierMetaStateMask3, 2101703389, false, (String) objArr115[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(View.getDefaultSize(0, 0) + 54, (char) (Color.rgb(0, 0, 0) + 16778049), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 576), (Class) ArtificialStackFrames.coroutineCreation(54 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 630), Integer.TYPE, Integer.TYPE});
            }
            Object[] objArr116 = (Object[]) ((Method) objAccessartificialFrame35).invoke(null, objArr114);
            Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame36 == null) {
                int maxKeyCode = 36 - (KeyEvent.getMaxKeyCode() >> 16);
                char c6 = (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
                int iLastIndexOf = TextUtils.lastIndexOf("", '0', 0) + 541;
                byte[] bArr45 = $$a;
                byte b53 = bArr45[23];
                byte b54 = bArr45[41];
                Object[] objArr117 = new Object[1];
                b(b53, (byte) (b54 - 1), b54, objArr117);
                objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(maxKeyCode, c6, iLastIndexOf, 793268735, false, (String) objArr117[0], null);
            }
            ((Field) objAccessartificialFrame36).set(null, objArr116);
            try {
                Long lValueOf9 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                if (objAccessartificialFrame37 == null) {
                    int maximumDrawingCacheSize2 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 36;
                    char tapTimeout4 = (char) (ViewConfiguration.getTapTimeout() >> 16);
                    int touchSlop4 = (ViewConfiguration.getTouchSlop() >> 8) + 540;
                    byte[] bArr46 = $$a;
                    byte b55 = bArr46[12];
                    byte b56 = bArr46[41];
                    Object[] objArr118 = new Object[1];
                    b(b55, (byte) (b56 - 1), b56, objArr118);
                    objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize2, tapTimeout4, touchSlop4, 624296913, false, (String) objArr118[0], null);
                }
                ((Field) objAccessartificialFrame37).set(null, lValueOf9);
                objArr7 = objArr116;
            } catch (Exception unused8) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame38 == null) {
                int doubleTapTimeout2 = 36 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                char mode3 = (char) View.MeasureSpec.getMode(0);
                int i170 = 541 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                byte[] bArr47 = $$a;
                byte b57 = bArr47[23];
                byte b58 = bArr47[41];
                Object[] objArr119 = new Object[1];
                b(b57, (byte) (b58 - 1), b58, objArr119);
                objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout2, mode3, i170, 793268735, false, (String) objArr119[0], null);
            }
            Object[] objArr120 = (Object[]) ((Field) objAccessartificialFrame38).get(null);
            objArr7 = new Object[]{new int[1], new int[1], new int[1]};
            int i171 = ((int[]) objArr120[2])[0];
            int i172 = ((int[]) objArr120[1])[0];
            ((int[]) objArr7[2])[0] = i171;
            ((int[]) objArr7[1])[0] = i172;
            int iUptimeMillis2 = (int) SystemClock.uptimeMillis();
            int i173 = ~((-409833485) | (~iUptimeMillis2));
            int i174 = (((((537005153 | i173) | (~(409833484 | iUptimeMillis2))) * (-338)) - 1824230265) + (((~(iUptimeMillis2 | 946838637)) | i173) * 338)) - 93863527;
            int i175 = (i174 << 13) ^ i174;
            int i176 = i175 ^ (i175 >>> 17);
            ((int[]) objArr7[0])[0] = i176 ^ (i176 << 5);
        }
        Object obj = objArr7[1];
        int i177 = ((int[]) obj)[0];
        Object obj2 = objArr7[2];
        int i178 = ((int[]) obj2)[0];
        if (i178 == i177) {
            int i179 = getARTIFICIAL_FRAME_PACKAGE_NAME + 35;
            artificialFrame = i179 % 128;
            int i180 = i179 % 2;
            Object[] objArr121 = {new int[1], new int[1], new int[1]};
            int i181 = ((int[]) objArr7[0])[0];
            int i182 = ((int[]) obj2)[0];
            int i183 = ((int[]) obj)[0];
            ((int[]) objArr121[2])[0] = i182;
            ((int[]) objArr121[1])[0] = i183;
            int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
            int i184 = i181 + 132762518 + ((~(1073732445 | iFreeMemory)) * (-301)) + (((~((-952031582) | iFreeMemory)) | (~((~iFreeMemory) | 399590168))) * (-301)) + (((~(iFreeMemory | (-399590169))) | (-952031582)) * 301);
            int i185 = (i184 << 13) ^ i184;
            int i186 = i185 ^ (i185 >>> 17);
            ((int[]) objArr121[0])[0] = i186 ^ (i186 << 5);
        } else {
            Object[] objArr122 = {Long.valueOf((((long) (-289655919)) << 32) ^ ((long) (i177 ^ i178))), Long.valueOf(-289660015)};
            byte[] bArr48 = $$d;
            Object[] objArr123 = new Object[1];
            c((byte) (-bArr48[147]), (short) 584, bArr48[3], objArr123);
            Class<?> cls19 = Class.forName((String) objArr123[0]);
            byte b59 = bArr48[67];
            byte b60 = b59;
            Object[] objArr124 = new Object[1];
            c(b60, (short) (b60 | 134), b59, objArr124);
            cls19.getMethod((String) objArr124[0], Long.TYPE, Long.TYPE).invoke(null, objArr122);
            Object[] objArr125 = {new int[1], new int[1], new int[1]};
            int i187 = ((int[]) objArr7[0])[0];
            int i188 = ((int[]) objArr7[2])[0];
            int i189 = ((int[]) objArr7[1])[0];
            ((int[]) objArr125[2])[0] = i188;
            ((int[]) objArr125[1])[0] = i189;
            int iNextInt2 = new Random().nextInt();
            int i190 = i187 + (((438295163 + (((~iNextInt2) | (-1330615106)) * 1444)) + (((~(iNextInt2 | 1101452507)) | ((~(250169242 | iNextInt2)) | (-1341118428))) * (-1444))) - 1368568494);
            int i191 = (i190 << 13) ^ i190;
            int i192 = i191 ^ (i191 >>> 17);
            ((int[]) objArr125[0])[0] = i192 ^ (i192 << 5);
        }
        return super.onCreate();
    }

    static {
        byte[] bArr = new byte[TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID];
        System.arraycopy("KdÂ\u0016ø÷\u0004ÿ÷òF·\nï\u0005\u0004ñÿë\u0015é\u0007öý<Æûî\fí\u0005õø\u0001ùûA×êï\u0005\u0004ñ$Ûî\fí\u0005õø\u0001ùû$Óðùÿöý\u0007÷\u0005\u001eÍ\t\u0000é\u0007öýðþ;Ä\u0001úúÿïü\u00009¸\t\u0000úëBµ\bø\bï\töþï@Ñæ\u0004\u0002\u000fÛ\u0007û\u0011ÝüÿDüÛÉ\u0000\u000bï\u0000\tñ\u0015Ö\u0007ö\bÿí\u0007\u0002\u0013çð\u0007úÿ-ü¿\u0000ÿðü\u00009\u0001Á÷ö\u000bï\u0000\tñ:³\u0000AØé\u0000ñ\u0011îÿ\u000bà\bô\u0002íLÉá\u0005ñ\u000bï\u001aïê\u0004ðþ;Ä\u0001úúÿïü\u00009Áø\böþñ\u0003õ\u0007õÿ÷\u00053Çðù\t3ÚÚÿ\u0007ë\u000eúï\u001bêðø\fó\u0007ú\u001báúë\u0001ùõQÝÐþù\u000bï\u0001öýø÷\u0004ÿ÷<¶\u000bé\u0000B×Ûþ\u0005÷\u0003ð$Ó\u0011ü\bÛþ\u0005÷\u0003\u0015Õ\u0004\u0007ùï+Ðýô\rïû\u0006öý÷$Óúüúîü\u000eëú\u0007ÿù\u0002ö\u0004ñ\"Ð\rð\u0004ðþ;Âûñ\u000fú÷û\u0004íü>Åé\u0011úñø\u0007öý÷AÝÐ2Ö\u0002úïÿ&É\u0011úñø\u0007öýðþ;Ãôü\u0004÷\u00033Çðþüúý<Çðÿü\u0003þëBäÓù÷\u0012ë\n÷÷\u0003\u0010àùú\u000bý\rêíÐùÿöý\u0007÷\u0005\u001dÛÿé\nüú÷\u0003\u0018Óðþ;¶þ\rï÷\u0006òû\u0001ùû\u0000\u0005îB¾ù\bþé\u0007öýý\bï\töþï@¾ù\u0004üþï@Öýüþ\u0001ßñ\u000b Íü\u0007ó\u0006ûïJ½ðþ;Ãôü\u0004÷\u00033Çðþüúý<Çðÿü\u0003þëBéËü\rä)ßòû#Ô\u0005ô\u0007ø\bíðþ;Ä\u0001úúÿïü\u00009Éíü\u0000ÿ÷ÿôAéÍü ß÷ÿ#ßé\u000f9ïðþ;Ãôü\u0004÷\u00033Éï\u0006îÿ\u0002\u00012ÃööAÆç\u0007\tð\u0000ñ\u000b3°ü\u0011ðþ;Ãôü\u0004÷\u00033Éí\u00037ÙØ\u0002÷\u000f\rÚÿ÷\u0001".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID);
        $$d = bArr;
        $$e = 251;
        $$a = new byte[]{125, 126, -45, -128, -2, Ascii.SI, -33, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, 10, -31, Ascii.DC4, Ascii.CR, -8, -11, -13, Ascii.ESC, 5, -1, -33, 33, -2, -9, 5, -7, 5, -1, -50, 39, Ascii.VT, -7, -12, Ascii.SI, Ascii.ESC, 1, -7, -6, -33, 51, -12, 3, -8, 1, Ascii.CR, -9, Ascii.DC2, -34, Ascii.EM, 4, -17, 19, -15, -1, -18, Ascii.SI, 19, -11, 5, -7, -2, Ascii.SI, -36, Ascii.NAK, Ascii.CR, -15, 2, 9, 6, -34, Ascii.SI, 19, -11, 5, -7, -9, Ascii.DC2, -36, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, -7, Ascii.DC2, -43, Ascii.GS, -4, 17, 2, 49, 2, -11, -3, 3, -6, 6, -8, Ascii.VT, -25, 33, -19, 2, 8, -37, 44, -17, Ascii.FF, -8, Ascii.SO};
        $$b = 75;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        setDefaultImpl = -260894092;
    }
}
