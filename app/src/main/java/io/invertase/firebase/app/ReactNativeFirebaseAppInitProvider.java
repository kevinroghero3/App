package io.invertase.firebase.app;

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
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.internal.b;
import io.invertase.firebase.common.ReactNativeFirebaseInitProvider;
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

/* JADX INFO: loaded from: classes6.dex */
public class ReactNativeFirebaseAppInitProvider extends ReactNativeFirebaseInitProvider {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    private static int artificialFrame;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static int setDefaultImpl;
    private static final byte[] $$c = {52, -35, -61, -47};
    private static final int $$f = 68;
    private static int $10 = 0;
    private static int $11 = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(int r6, short r7, short r8) {
        /*
            int r7 = r7 * 2
            int r7 = r7 + 114
            int r8 = r8 * 3
            int r0 = r8 + 1
            byte[] r1 = io.invertase.firebase.app.ReactNativeFirebaseAppInitProvider.$$c
            int r6 = r6 * 4
            int r6 = r6 + 4
            byte[] r0 = new byte[r0]
            r2 = 0
            if (r1 != 0) goto L17
            r7 = r6
            r3 = r8
            r4 = r2
            goto L2c
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r7
            r0[r3] = r4
            if (r3 != r8) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            return r6
        L23:
            int r3 = r3 + 1
            r4 = r1[r6]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r5
        L2c:
            int r6 = r6 + r3
            int r7 = r7 + 1
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: io.invertase.firebase.app.ReactNativeFirebaseAppInitProvider.$$g(int, short, short):java.lang.String");
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
    private static void b(int r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r0 = r6 + 8
            int r8 = 112 - r8
            byte[] r1 = io.invertase.firebase.app.ReactNativeFirebaseAppInitProvider.$$a
            int r7 = r7 + 4
            byte[] r0 = new byte[r0]
            int r6 = r6 + 7
            r2 = 0
            if (r1 != 0) goto L13
            r4 = r6
            r8 = r7
            r3 = r2
            goto L2a
        L13:
            r3 = r2
        L14:
            byte r4 = (byte) r8
            r0[r3] = r4
            if (r3 != r6) goto L21
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L21:
            int r7 = r7 + 1
            int r3 = r3 + 1
            r4 = r1[r7]
            r5 = r8
            r8 = r7
            r7 = r5
        L2a:
            int r7 = r7 + r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: io.invertase.firebase.app.ReactNativeFirebaseAppInitProvider.b(int, byte, byte, java.lang.Object[]):void");
    }

    private static void c(short s, int i, byte b, Object[] objArr) {
        int i2 = 573 - s;
        byte[] bArr = $$d;
        int i3 = i + 36;
        byte[] bArr2 = new byte[81 - b];
        int i4 = 80 - b;
        int i5 = -1;
        if (bArr == null) {
            i2++;
            i3 = (i3 + i2) - 4;
        }
        while (true) {
            i5++;
            bArr2[i5] = (byte) i3;
            if (i5 == i4) {
                objArr[0] = new String(bArr2, 0);
                return;
            } else {
                byte b2 = bArr[i2];
                i2++;
                i3 = (i3 + b2) - 4;
            }
        }
    }

    private static void a(boolean z, int i, int i2, int i3, char[] cArr, Object[] objArr) throws Throwable {
        int i4 = 2 % 2;
        onNavigationEvent onnavigationevent = new onNavigationEvent();
        char[] cArr2 = new char[i3];
        onnavigationevent.d = 0;
        while (onnavigationevent.d < i3) {
            int i5 = $10 + 51;
            $11 = i5 % 128;
            int i6 = i5 % 2;
            onnavigationevent.c = cArr[onnavigationevent.d];
            cArr2[onnavigationevent.d] = (char) (i2 + onnavigationevent.c);
            int i7 = onnavigationevent.d;
            try {
                Object[] objArr2 = {Integer.valueOf(cArr2[i7]), Integer.valueOf(setDefaultImpl)};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(465886069);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) 0;
                    byte b2 = b;
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 22, (char) Gravity.getAbsoluteGravity(0, 0), (ViewConfiguration.getScrollBarSize() >> 8) + 1775, -2069783171, false, $$g(b, b2, b2), new Class[]{Integer.TYPE, Integer.TYPE});
                }
                cArr2[i7] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                Object[] objArr3 = {onnavigationevent, onnavigationevent};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                if (objAccessartificialFrame2 == null) {
                    byte b3 = (byte) 0;
                    byte b4 = (byte) (b3 + 1);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(Color.alpha(0) + 37, (char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 56277), Gravity.getAbsoluteGravity(0, 0) + 1259, 711931141, false, $$g(b3, b4, (byte) (b4 - 1)), new Class[]{Object.class, Object.class});
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
        if (i > 0) {
            int i8 = $11 + 83;
            $10 = i8 % 128;
            int i9 = i8 % 2;
            onnavigationevent.b = i;
            char[] cArr3 = new char[i3];
            System.arraycopy(cArr2, 0, cArr3, 0, i3);
            System.arraycopy(cArr3, 0, cArr2, i3 - onnavigationevent.b, onnavigationevent.b);
            System.arraycopy(cArr3, onnavigationevent.b, cArr2, 0, i3 - onnavigationevent.b);
        }
        if (z) {
            char[] cArr4 = new char[i3];
            onnavigationevent.d = 0;
            while (onnavigationevent.d < i3) {
                cArr4[onnavigationevent.d] = cArr2[(i3 - onnavigationevent.d) - 1];
                Object[] objArr4 = {onnavigationevent, onnavigationevent};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) 0;
                    byte b6 = (byte) (b5 + 1);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(TextUtils.getCapsMode("", 0, 0) + 37, (char) (56277 - Color.blue(0)), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 1259, 711931141, false, $$g(b5, b6, (byte) (b6 - 1)), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }

    /* JADX WARN: Code duplicated, block: B:243:0x1aac  */
    /* JADX WARN: Code duplicated, block: B:245:0x1b20  */
    /* JADX WARN: Code duplicated, block: B:247:0x1b24  */
    /* JADX WARN: Code duplicated, block: B:249:0x1b30  */
    /* JADX WARN: Code duplicated, block: B:252:0x1b3d  */
    /* JADX WARN: Code duplicated, block: B:255:0x1b47  */
    /* JADX WARN: Code duplicated, block: B:256:0x1b49  */
    /* JADX WARN: Code duplicated, block: B:261:0x1c45  */
    /* JADX WARN: Code duplicated, block: B:263:0x1c4e  */
    /* JADX WARN: Code duplicated, block: B:268:0x1cb6  */
    @Override // io.invertase.firebase.common.ReactNativeFirebaseInitProvider, android.content.ContentProvider
    public boolean onCreate() throws Throwable {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArrCoroutineCreation$78cbbd35;
        Object[] objArr3;
        Object[] objArr4;
        Object obj;
        Object[] objArr5;
        Context applicationContext;
        Object[] objArr6;
        Object objAccessartificialFrame;
        Object objAccessartificialFrame2;
        int i;
        Object[] objArr7;
        int i2 = 2 % 2;
        Object[] objArr8 = new Object[1];
        a(false, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 4, 134 - ((byte) KeyEvent.getModifierMetaStateMask()), TextUtils.indexOf("", "") + 22, new char[]{65504, '\t', '\f', 0, '\b', 65534, 11, 1, 15, '\f', 6, 1, 65483, '\f', 16, 65483, 65520, 22, 16, 17, 2, '\n'}, objArr8);
        String str = (String) objArr8[0];
        Object[] objArr9 = new Object[1];
        a(true, TextUtils.getCapsMode("", 0, 0) + 11, 139 - KeyEvent.keyCodeFromString(""), TextUtils.indexOf("", "", 0) + 15, new char[]{5, 65530, 65534, 65515, 65533, 65534, '\f', '\t', 65530, 5, 65534, 65534, 6, 2, CharUtils.CR}, objArr9);
        String str2 = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        a(true, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 2, 134 - ExpandableListView.getPackedPositionType(0L), (ViewConfiguration.getTouchSlop() >> 8) + 16, new char[]{65535, '\b', 11, 3, 18, 17, 23, 65521, 65484, 5, '\f', 65535, '\n', 65484, 65535, 20}, objArr10);
        String str3 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        a(false, 13 - View.resolveSizeAndState(0, 0, 0), (ViewConfiguration.getJumpTapTimeout() >> 16) + 138, MotionEvent.axisFromString("") + 17, new char[]{'\b', 14, 3, 14, 19, 65506, 65531, CharUtils.CR, 2, 65501, '\t', 65534, 65535, 3, 65534, 65535}, objArr11);
        String str4 = (String) objArr11[0];
        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame3 == null) {
            int gidForName = 29 - Process.getGidForName("");
            char cAxisFromString = (char) (49361 - MotionEvent.axisFromString(""));
            int mode = 684 - View.MeasureSpec.getMode(0);
            byte[] bArr = $$a;
            Object[] objArr12 = new Object[1];
            b(bArr[14], bArr[25], bArr[82], objArr12);
            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(gidForName, cAxisFromString, mode, -1583976536, false, (String) objArr12[0], null);
        }
        long j = ((Field) objAccessartificialFrame3).getLong(null);
        if (j == -1 || j + 1949 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            try {
                Object[] objArr13 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -1946123144};
                byte[] bArr2 = $$d;
                Object[] objArr14 = new Object[1];
                c((short) 569, bArr2[146], bArr2[552], objArr14);
                Class<?> cls = Class.forName((String) objArr14[0]);
                Object[] objArr15 = new Object[1];
                c((short) 518, bArr2[146], bArr2[281], objArr15);
                objArr = (Object[]) cls.getMethod((String) objArr15[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr13);
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame4 == null) {
                    int longPressTimeout = (ViewConfiguration.getLongPressTimeout() >> 16) + 30;
                    char fadingEdgeLength = (char) (49362 - (ViewConfiguration.getFadingEdgeLength() >> 16));
                    int i3 = 685 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                    byte[] bArr3 = $$a;
                    Object[] objArr16 = new Object[1];
                    b(bArr3[91], bArr3[36], bArr3[3], objArr16);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(longPressTimeout, fadingEdgeLength, i3, -1456483158, false, (String) objArr16[0], null);
                }
                ((Field) objAccessartificialFrame4).set(null, objArr);
                try {
                    Long lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1056123296);
                    if (objAccessartificialFrame5 == null) {
                        int size = 30 - View.MeasureSpec.getSize(0);
                        char c = (char) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 49362);
                        int i4 = 683 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                        byte[] bArr4 = $$a;
                        Object[] objArr17 = new Object[1];
                        b(bArr4[14], bArr4[25], bArr4[82], objArr17);
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(size, c, i4, -1583976536, false, (String) objArr17[0], null);
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
                int iResolveOpacity = Drawable.resolveOpacity(0, 0) + 30;
                char scrollDefaultDelay = (char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 49362);
                int iLastIndexOf = 683 - TextUtils.lastIndexOf("", '0', 0, 0);
                byte[] bArr5 = $$a;
                Object[] objArr18 = new Object[1];
                b(bArr5[91], bArr5[36], bArr5[3], objArr18);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iResolveOpacity, scrollDefaultDelay, iLastIndexOf, -1456483158, false, (String) objArr18[0], null);
            }
            Object[] objArr19 = (Object[]) ((Field) objAccessartificialFrame6).get(null);
            objArr = new Object[]{new int[]{((int[]) objArr19[0])[0]}, new int[]{((int[]) objArr19[1])[0]}, new int[1], (String) objArr19[3]};
            int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
            int i5 = ~startElapsedRealtime;
            int i6 = ((((-704478228) + (((~((-592609879) | i5)) | (-386013897)) * (-865))) + ((~(startElapsedRealtime | 592609878)) * 865)) + (((~((-386013897) | i5)) | (~(i5 | 592609878))) * 865)) - 1946123144;
            int i7 = (i6 << 13) ^ i6;
            int i8 = i7 ^ (i7 >>> 17);
            ((int[]) objArr[2])[0] = i8 ^ (i8 << 5);
        }
        int i9 = ((int[]) objArr[1])[0];
        int i10 = ((int[]) objArr[0])[0];
        if (i10 == i9) {
            int i11 = ((int[]) objArr[2])[0];
            Object[] objArr20 = {new int[]{((int[]) objArr[0])[0]}, new int[]{((int[]) objArr[1])[0]}, new int[1], (String) objArr[3]};
            int iIdentityHashCode = System.identityHashCode(this);
            int i12 = i11 + 1150927704 + ((~(525336286 | iIdentityHashCode)) * (-301)) + (((~((-525270593) | iIdentityHashCode)) | (~((~iIdentityHashCode) | 453353182))) * (-301)) + (((~(iIdentityHashCode | (-453353183))) | (-525270593)) * 301);
            int i13 = (i12 << 13) ^ i12;
            int i14 = i13 ^ (i13 >>> 17);
            ((int[]) objArr20[2])[0] = i14 ^ (i14 << 5);
        } else {
            new ArrayList().add((String) objArr[3]);
            Object[] objArr21 = objArr;
            try {
                Object[] objArr22 = {Long.valueOf(((long) (i9 ^ i10)) ^ (((long) (-485509696)) << 32)), Long.valueOf(-485509680)};
                short s = (short) TypedValues.PositionType.TYPE_DRAWPATH;
                byte[] bArr6 = $$d;
                Object[] objArr23 = new Object[1];
                c(s, bArr6[146], bArr6[316], objArr23);
                Class<?> cls2 = Class.forName((String) objArr23[0]);
                byte b = bArr6[32];
                Object[] objArr24 = new Object[1];
                c((short) 436, b, (byte) (b | 78), objArr24);
                cls2.getMethod((String) objArr24[0], Long.TYPE, Long.TYPE).invoke(null, objArr22);
                int i15 = ((int[]) objArr21[2])[0];
                Object[] objArr25 = {new int[]{((int[]) objArr21[0])[0]}, new int[]{((int[]) objArr21[1])[0]}, new int[1], (String) objArr21[3]};
                int i16 = ~(((int) Runtime.getRuntime().freeMemory()) | 608202234);
                int i17 = i15 + (((1364696338 + (((-370421541) | i16) * (-220))) + ((i16 | (-911503359)) * 220)) - 1607156892);
                int i18 = (i17 << 13) ^ i17;
                int i19 = i18 ^ (i18 >>> 17);
                ((int[]) objArr25[2])[0] = i19 ^ (i19 << 5);
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
            int iAlpha = Color.alpha(0) + 36;
            char scrollBarFadeDuration = (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16);
            int iLastIndexOf2 = TextUtils.lastIndexOf("", '0') + 541;
            byte[] bArr7 = $$a;
            byte b2 = bArr7[91];
            Object[] objArr26 = new Object[1];
            b(b2, bArr7[12], (byte) (b2 - 1), objArr26);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iAlpha, scrollBarFadeDuration, iLastIndexOf2, 624296913, false, (String) objArr26[0], null);
        }
        long j2 = ((Field) objAccessartificialFrame7).getLong(null);
        if (j2 == -1 || j2 + 2041 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            try {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1717965552);
                if (objAccessartificialFrame8 == null) {
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getTouchSlop() >> 8) + 20, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 39515), 982 - TextUtils.getTrimmedLength(""), 117222168, false, null, new Class[0]);
                }
                Object[] objArr27 = {null, ((Constructor) objAccessartificialFrame8).newInstance(null), -1626885553, 0};
                Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-501205803);
                if (objAccessartificialFrame9 == null) {
                    int iLastIndexOf3 = TextUtils.lastIndexOf("", '0', 0, 0) + 37;
                    char jumpTapTimeout = (char) (ViewConfiguration.getJumpTapTimeout() >> 16);
                    int packedPositionGroup = ExpandableListView.getPackedPositionGroup(0L) + 540;
                    byte[] bArr8 = $$a;
                    Object[] objArr28 = new Object[1];
                    b(bArr8[19], (byte) 35, bArr8[0], objArr28);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(iLastIndexOf3, jumpTapTimeout, packedPositionGroup, 2101703389, false, (String) objArr28[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(54 - TextUtils.getTrimmedLength(""), (char) (833 - ((Process.getThreadPriority(0) + 20) >> 6)), TextUtils.getOffsetAfter("", 0) + 576), (Class) ArtificialStackFrames.coroutineCreation(((Process.getThreadPriority(0) + 20) >> 6) + 54, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 629), Integer.TYPE, Integer.TYPE});
                }
                objArr2 = (Object[]) ((Method) objAccessartificialFrame9).invoke(null, objArr27);
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                if (objAccessartificialFrame10 == null) {
                    int absoluteGravity = 36 - Gravity.getAbsoluteGravity(0, 0);
                    char fadingEdgeLength2 = (char) (ViewConfiguration.getFadingEdgeLength() >> 16);
                    int deadChar = 540 - KeyEvent.getDeadChar(0, 0);
                    byte[] bArr9 = $$a;
                    byte b3 = bArr9[91];
                    Object[] objArr29 = new Object[1];
                    b(b3, bArr9[23], (byte) (b3 - 1), objArr29);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(absoluteGravity, fadingEdgeLength2, deadChar, 793268735, false, (String) objArr29[0], null);
                }
                ((Field) objAccessartificialFrame10).set(null, objArr2);
                try {
                    Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                    if (objAccessartificialFrame11 == null) {
                        int maxKeyCode = 36 - (KeyEvent.getMaxKeyCode() >> 16);
                        char cRgb = (char) (ViewCompat.MEASURED_STATE_MASK - Color.rgb(0, 0, 0));
                        int i20 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 539;
                        byte[] bArr10 = $$a;
                        byte b4 = bArr10[91];
                        Object[] objArr30 = new Object[1];
                        b(b4, bArr10[12], (byte) (b4 - 1), objArr30);
                        objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(maxKeyCode, cRgb, i20, 624296913, false, (String) objArr30[0], null);
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
                int iLastIndexOf4 = TextUtils.lastIndexOf("", '0', 0, 0) + 37;
                char scrollDefaultDelay2 = (char) (ViewConfiguration.getScrollDefaultDelay() >> 16);
                int threadPriority = 540 - ((Process.getThreadPriority(0) + 20) >> 6);
                byte[] bArr11 = $$a;
                byte b5 = bArr11[91];
                Object[] objArr31 = new Object[1];
                b(b5, bArr11[23], (byte) (b5 - 1), objArr31);
                objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iLastIndexOf4, scrollDefaultDelay2, threadPriority, 793268735, false, (String) objArr31[0], null);
            }
            Object[] objArr32 = (Object[]) ((Field) objAccessartificialFrame12).get(null);
            objArr2 = new Object[]{new int[1], new int[1], new int[1]};
            int i21 = ((int[]) objArr32[2])[0];
            int i22 = ((int[]) objArr32[1])[0];
            ((int[]) objArr2[2])[0] = i21;
            ((int[]) objArr2[1])[0] = i22;
            int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
            int i23 = ~((-187583343) | iMaxMemory);
            int i24 = 2086866121 + ((168692328 | i23) * (-280)) + ((i23 | (~((-1164038408) | iMaxMemory))) * 140);
            int i25 = ~((-18891015) | iMaxMemory);
            int i26 = ~iMaxMemory;
            int i27 = (i24 + (((~(i26 | (-1145147394))) | (i25 | (~((-168692329) | i26)))) * 140)) - 1626885553;
            int i28 = (i27 << 13) ^ i27;
            int i29 = i28 ^ (i28 >>> 17);
            ((int[]) objArr2[0])[0] = i29 ^ (i29 << 5);
        }
        Object obj2 = objArr2[1];
        int i30 = ((int[]) obj2)[0];
        Object obj3 = objArr2[2];
        int i31 = ((int[]) obj3)[0];
        if (i31 == i30) {
            Object[] objArr33 = {new int[1], new int[1], new int[1]};
            int i32 = ((int[]) objArr2[0])[0];
            int i33 = ((int[]) obj3)[0];
            int i34 = ((int[]) obj2)[0];
            ((int[]) objArr33[2])[0] = i33;
            ((int[]) objArr33[1])[0] = i34;
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i35 = i32 + 514083701 + (((~((-1201300690) | iIdentityHashCode2)) | 150321060) * (-366)) + (((~(iIdentityHashCode2 | (-1191854162))) | 140874532) * 366);
            int i36 = (i35 << 13) ^ i35;
            int i37 = i36 ^ (i36 >>> 17);
            ((int[]) objArr33[0])[0] = i37 ^ (i37 << 5);
        } else {
            Object[] objArr34 = {Long.valueOf(((long) (i30 ^ i31)) ^ (((long) (-1799117959)) << 32)), Long.valueOf(-1799113863)};
            short s2 = (short) TypedValues.PositionType.TYPE_DRAWPATH;
            byte[] bArr12 = $$d;
            Object[] objArr35 = new Object[1];
            c(s2, bArr12[146], bArr12[316], objArr35);
            Class<?> cls3 = Class.forName((String) objArr35[0]);
            byte b6 = bArr12[32];
            Object[] objArr36 = new Object[1];
            c((short) 436, b6, (byte) (b6 | 78), objArr36);
            cls3.getMethod((String) objArr36[0], Long.TYPE, Long.TYPE).invoke(null, objArr34);
            Object[] objArr37 = {new int[1], new int[1], new int[1]};
            int i38 = ((int[]) objArr2[0])[0];
            int i39 = ((int[]) objArr2[2])[0];
            int i40 = ((int[]) objArr2[1])[0];
            ((int[]) objArr37[2])[0] = i39;
            ((int[]) objArr37[1])[0] = i40;
            int iIdentityHashCode3 = System.identityHashCode(this);
            int i41 = i38 + 1912434605 + (((~((-646941322) | iIdentityHashCode3)) | 570458248) * 336) + (((-781163502) | (~(iIdentityHashCode3 | 704680428))) * (-168)) + (((~((~iIdentityHashCode3) | 704680428)) | (-646941322)) * 168);
            int i42 = (i41 << 13) ^ i41;
            int i43 = i42 ^ (i42 >>> 17);
            ((int[]) objArr37[0])[0] = i43 ^ (i43 << 5);
        }
        Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame13 == null) {
            int iLastIndexOf5 = 25 - TextUtils.lastIndexOf("", '0', 0, 0);
            char c2 = (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1);
            int mode2 = View.MeasureSpec.getMode(0) + 1041;
            byte[] bArr13 = $$a;
            byte b7 = bArr13[91];
            Object[] objArr38 = new Object[1];
            b(b7, bArr13[12], (byte) (b7 - 1), objArr38);
            objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(iLastIndexOf5, c2, mode2, 2061780482, false, (String) objArr38[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame13).getLong(null);
        if (j3 == -1 || j3 + 4611686018427387800L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr39 = {-244006505};
            Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame14 == null) {
                objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getPressedStateDuration() >> 16) + 8, (char) (TextUtils.indexOf("", "") + 22251), TextUtils.lastIndexOf("", '0') + 1034, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrCoroutineCreation$78cbbd35 = b.coroutineCreation$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame14).newInstance(objArr39), -813404762, false);
            Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame15 == null) {
                int iArgb = Color.argb(0, 0, 0, 0) + 26;
                char cLastIndexOf = (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0));
                int iIndexOf = TextUtils.indexOf((CharSequence) "", '0', 0) + 1042;
                byte[] bArr14 = $$a;
                byte b8 = bArr14[91];
                Object[] objArr40 = new Object[1];
                b(b8, bArr14[23], (byte) (b8 - 1), objArr40);
                objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(iArgb, cLastIndexOf, iIndexOf, 1145017376, false, (String) objArr40[0], null);
            }
            ((Field) objAccessartificialFrame15).set(null, objArrCoroutineCreation$78cbbd35);
            try {
                Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame16 == null) {
                    int iRed = Color.red(0) + 26;
                    char c3 = (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
                    int iRgb = (-16776175) - Color.rgb(0, 0, 0);
                    byte[] bArr15 = $$a;
                    byte b9 = bArr15[91];
                    Object[] objArr41 = new Object[1];
                    b(b9, bArr15[12], (byte) (b9 - 1), objArr41);
                    objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(iRed, c3, iRgb, 2061780482, false, (String) objArr41[0], null);
                }
                ((Field) objAccessartificialFrame16).set(null, lValueOf3);
            } catch (Exception unused3) {
                throw new RuntimeException();
            }
        } else {
            int i44 = artificialFrame + 95;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i44 % 128;
            int i45 = i44 % 2;
            Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame17 == null) {
                int scrollBarSize = (ViewConfiguration.getScrollBarSize() >> 8) + 26;
                char maximumFlingVelocity = (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                int iRgb2 = (-16776175) - Color.rgb(0, 0, 0);
                byte[] bArr16 = $$a;
                byte b10 = bArr16[91];
                Object[] objArr42 = new Object[1];
                b(b10, bArr16[23], (byte) (b10 - 1), objArr42);
                objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(scrollBarSize, maximumFlingVelocity, iRgb2, 1145017376, false, (String) objArr42[0], null);
            }
            Object[] objArr43 = (Object[]) ((Field) objAccessartificialFrame17).get(null);
            objArrCoroutineCreation$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
            int i46 = ((int[]) objArr43[3])[0];
            int i47 = ((int[]) objArr43[2])[0];
            String[] strArr = (String[]) objArr43[0];
            int iNextInt = new Random().nextInt(1249135218);
            int i48 = ~(1006338047 | iNextInt);
            int i49 = (((1222600062 + ((809697504 | i48) * (-476))) + (i48 * 952)) + ((~((~iNextInt) | 1006338047)) * 476)) - 813404762;
            int i50 = (i49 << 13) ^ i49;
            int i51 = i50 ^ (i50 >>> 17);
            ((int[]) objArrCoroutineCreation$78cbbd35[1])[0] = i51 ^ (i51 << 5);
        }
        int i52 = ((int[]) objArrCoroutineCreation$78cbbd35[2])[0];
        int i53 = ((int[]) objArrCoroutineCreation$78cbbd35[3])[0];
        if (i53 == i52) {
            int i54 = getARTIFICIAL_FRAME_PACKAGE_NAME + 113;
            artificialFrame = i54 % 128;
            int i55 = i54 % 2;
            Object[] objArr44 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i56 = ((int[]) objArrCoroutineCreation$78cbbd35[1])[0];
            int i57 = ((int[]) objArrCoroutineCreation$78cbbd35[3])[0];
            int i58 = ((int[]) objArrCoroutineCreation$78cbbd35[2])[0];
            String[] strArr2 = (String[]) objArrCoroutineCreation$78cbbd35[0];
            int iIdentityHashCode4 = System.identityHashCode(this);
            int i59 = i56 + 622631182 + (((~((-151112196) | iIdentityHashCode4)) | (~((~iIdentityHashCode4) | (-73008389)))) * (-318)) + (((~(186763779 | iIdentityHashCode4)) | (-259772168)) * (-318)) + (((~(iIdentityHashCode4 | (-186763780))) | 108659972) * TypedValues.AttributesType.TYPE_PIVOT_TARGET);
            int i60 = (i59 << 13) ^ i59;
            int i61 = i60 ^ (i60 >>> 17);
            ((int[]) objArr44[1])[0] = i61 ^ (i61 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArrCoroutineCreation$78cbbd35[0];
            if (strArr3 != null) {
                int i62 = getARTIFICIAL_FRAME_PACKAGE_NAME + 115;
                artificialFrame = i62 % 128;
                int i63 = i62 % 2;
                for (String str5 : strArr3) {
                    arrayList.add(str5);
                }
            }
            Object[] objArr45 = {Long.valueOf((((long) (-917236828)) << 32) ^ ((long) (i52 ^ i53))), Long.valueOf(-917236826)};
            byte[] bArr17 = $$d;
            Object[] objArr46 = new Object[1];
            c((short) 434, bArr17[89], bArr17[100], objArr46);
            Class<?> cls4 = Class.forName((String) objArr46[0]);
            byte b11 = bArr17[32];
            Object[] objArr47 = new Object[1];
            c((short) 436, b11, (byte) (b11 | 78), objArr47);
            cls4.getMethod((String) objArr47[0], Long.TYPE, Long.TYPE).invoke(null, objArr45);
            Object[] objArr48 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i64 = ((int[]) objArrCoroutineCreation$78cbbd35[1])[0];
            int i65 = ((int[]) objArrCoroutineCreation$78cbbd35[3])[0];
            int i66 = ((int[]) objArrCoroutineCreation$78cbbd35[2])[0];
            String[] strArr4 = (String[]) objArrCoroutineCreation$78cbbd35[0];
            int i67 = ~System.identityHashCode(this);
            int i68 = ~(438278083 | i67);
            int i69 = i64 + 505591498 + ((i68 | (-360174277)) * 764) + (((~(i67 | (-360174277))) | 269980352) * (-1528)) + (((-258491656) | i68) * 764);
            int i70 = (i69 << 13) ^ i69;
            int i71 = i70 ^ (i70 >>> 17);
            ((int[]) objArr48[1])[0] = i71 ^ (i71 << 5);
        }
        Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame18 == null) {
            int pressedStateDuration = 30 - (ViewConfiguration.getPressedStateDuration() >> 16);
            char packedPositionType = (char) (49362 - ExpandableListView.getPackedPositionType(0L));
            int scrollBarFadeDuration2 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 684;
            byte[] bArr18 = $$a;
            Object[] objArr49 = new Object[1];
            b(bArr18[53], (byte) 55, bArr18[41], objArr49);
            objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(pressedStateDuration, packedPositionType, scrollBarFadeDuration2, 752929587, false, (String) objArr49[0], null);
        }
        long j4 = ((Field) objAccessartificialFrame18).getLong(null);
        if (j4 == -1 || j4 + 2036 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr50 = new Object[1];
            a(false, 20 - (ViewConfiguration.getTapTimeout() >> 16), 135 - TextUtils.indexOf("", ""), 26 - TextUtils.getTrimmedLength(""), new char[]{1, 65483, 65534, CharUtils.CR, CharUtils.CR, 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15, '\f', 6}, objArr50);
            Class<?> cls5 = Class.forName((String) objArr50[0]);
            Object[] objArr51 = new Object[1];
            a(true, Gravity.getAbsoluteGravity(0, 0) + 11, (ViewConfiguration.getTapTimeout() >> 16) + 142, 18 - ExpandableListView.getPackedPositionType(0L), new char[]{2, 6, 6, 65495, '\n', 4, 65531, '\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529, 65535}, objArr51);
            Method method = cls5.getMethod((String) objArr51[0], new Class[0]);
            Context applicationContext2 = (Context) method.invoke(null, null);
            if (applicationContext2 != null) {
                applicationContext2 = ((applicationContext2 instanceof ContextWrapper) && ((ContextWrapper) applicationContext2).getBaseContext() == null) ? null : applicationContext2.getApplicationContext();
            }
            Object[] objArr52 = {applicationContext2, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -1555706975};
            byte[] bArr19 = $$d;
            Object[] objArr53 = new Object[1];
            c((short) 380, (byte) (bArr19[26] - 1), (byte) ($$e & 124), objArr53);
            Class<?> cls6 = Class.forName((String) objArr53[0]);
            Object[] objArr54 = new Object[1];
            c((short) 352, (byte) (-bArr19[317]), bArr19[243], objArr54);
            objArr3 = (Object[]) cls6.getMethod((String) objArr54[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr52);
            if (applicationContext2 != null) {
                Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-326560385);
                if (objAccessartificialFrame19 == null) {
                    int iIndexOf2 = 30 - TextUtils.indexOf("", "", 0);
                    char cMyPid = (char) ((Process.myPid() >> 22) + 49362);
                    int size2 = View.MeasureSpec.getSize(0) + 684;
                    byte[] bArr20 = $$a;
                    Object[] objArr55 = new Object[1];
                    b(bArr20[53], (byte) 70, bArr20[82], objArr55);
                    objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(iIndexOf2, cMyPid, size2, 1944867703, false, (String) objArr55[0], null);
                }
                ((Field) objAccessartificialFrame19).set(null, objArr3);
                try {
                    Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                    if (objAccessartificialFrame20 == null) {
                        int i72 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 29;
                        char c4 = (char) (49363 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
                        int iIndexOf3 = 684 - TextUtils.indexOf("", "");
                        byte[] bArr21 = $$a;
                        Object[] objArr56 = new Object[1];
                        b(bArr21[53], (byte) 55, bArr21[41], objArr56);
                        objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(i72, c4, iIndexOf3, 752929587, false, (String) objArr56[0], null);
                    }
                    ((Field) objAccessartificialFrame20).set(null, lValueOf4);
                } catch (Exception unused4) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(-326560385);
            if (objAccessartificialFrame21 == null) {
                int packedPositionType2 = 30 - ExpandableListView.getPackedPositionType(0L);
                char c5 = (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 49361);
                int doubleTapTimeout = 684 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                byte[] bArr22 = $$a;
                Object[] objArr57 = new Object[1];
                b(bArr22[53], (byte) 70, bArr22[82], objArr57);
                objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(packedPositionType2, c5, doubleTapTimeout, 1944867703, false, (String) objArr57[0], null);
            }
            Object[] objArr58 = (Object[]) ((Field) objAccessartificialFrame21).get(null);
            objArr3 = new Object[]{new int[]{((int[]) objArr58[0])[0]}, new int[]{((int[]) objArr58[1])[0]}, new int[1], (String) objArr58[3]};
            int iUptimeMillis = (int) SystemClock.uptimeMillis();
            int i73 = ~iUptimeMillis;
            int i74 = (-2002800006) + (((~((-225803819) | i73)) | (~((-752819957) | iUptimeMillis))) * (-370)) + (((~(iUptimeMillis | (-225803819))) | (~(i73 | (-752819957))) | (-771718911)) * (-370)) + 671104787;
            int i75 = (i74 << 13) ^ i74;
            int i76 = i75 ^ (i75 >>> 17);
            ((int[]) objArr3[2])[0] = i76 ^ (i76 << 5);
        }
        int i77 = ((int[]) objArr3[1])[0];
        int i78 = ((int[]) objArr3[0])[0];
        if (i78 == i77) {
            int i79 = ((int[]) objArr3[2])[0];
            Object[] objArr59 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
            int iMaxMemory2 = (int) Runtime.getRuntime().maxMemory();
            int i80 = ~iMaxMemory2;
            int i81 = i79 + (-104172642) + ((571629774 | i80) * (-192)) + (((~((-205627185) | i80)) | 201366816) * (-384)) + (((~(iMaxMemory2 | 777256958)) | (~(i80 | (-4260369))) | (~((-201366817) | iMaxMemory2))) * JfifUtil.MARKER_SOFn);
            int i82 = (i81 << 13) ^ i81;
            int i83 = i82 ^ (i82 >>> 17);
            ((int[]) objArr59[2])[0] = i83 ^ (i83 << 5);
        } else {
            Object[] objArr60 = {Long.valueOf((((long) (-370796649)) << 32) ^ ((long) (i77 ^ i78))), Long.valueOf(-370796653)};
            short s3 = (short) TypedValues.PositionType.TYPE_DRAWPATH;
            byte[] bArr23 = $$d;
            Object[] objArr61 = new Object[1];
            c(s3, bArr23[146], bArr23[316], objArr61);
            Class<?> cls7 = Class.forName((String) objArr61[0]);
            byte b12 = bArr23[32];
            Object[] objArr62 = new Object[1];
            c((short) 436, b12, (byte) (b12 | 78), objArr62);
            cls7.getMethod((String) objArr62[0], Long.TYPE, Long.TYPE).invoke(null, objArr60);
            int i84 = ((int[]) objArr3[2])[0];
            Object[] objArr63 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
            int startElapsedRealtime2 = (int) Process.getStartElapsedRealtime();
            int i85 = i84 + ((((~((-539234497) | startElapsedRealtime2)) | 33587224) * 449) - 716052434) + (((~((~startElapsedRealtime2) | (-539234497))) | 33587224) * 449);
            int i86 = (i85 << 13) ^ i85;
            int i87 = i86 ^ (i86 >>> 17);
            ((int[]) objArr63[2])[0] = i87 ^ (i87 << 5);
        }
        Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame22 == null) {
            int scrollBarSize2 = (ViewConfiguration.getScrollBarSize() >> 8) + 25;
            char cIndexOf = (char) (30067 - TextUtils.indexOf((CharSequence) "", '0', 0));
            int iRgb3 = Color.rgb(0, 0, 0) + 16778032;
            byte[] bArr24 = $$a;
            byte b13 = bArr24[91];
            Object[] objArr64 = new Object[1];
            b(b13, bArr24[12], (byte) (b13 - 1), objArr64);
            objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(scrollBarSize2, cIndexOf, iRgb3, 721586079, false, (String) objArr64[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame22).getLong(null);
        if (j5 == -1 || j5 + 2036 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr65 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -1852192221};
            Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame23 == null) {
                int maxKeyCode2 = 25 - (KeyEvent.getMaxKeyCode() >> 16);
                char keyRepeatTimeout = (char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 30068);
                int i88 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 816;
                byte[] bArr25 = $$a;
                byte b14 = bArr25[64];
                Object[] objArr66 = new Object[1];
                b(b14, (byte) (b14 | 81), (byte) (bArr25[116] - 1), objArr66);
                objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(maxKeyCode2, keyRepeatTimeout, i88, -797394565, false, (String) objArr66[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr4 = (Object[]) ((Method) objAccessartificialFrame23).invoke(null, objArr65);
            Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame24 == null) {
                int keyRepeatTimeout2 = 25 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                char keyRepeatTimeout3 = (char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 30068);
                int offsetBefore = 816 - TextUtils.getOffsetBefore("", 0);
                byte[] bArr26 = $$a;
                byte b15 = bArr26[91];
                Object[] objArr67 = new Object[1];
                b(b15, bArr26[23], (byte) (b15 - 1), objArr67);
                objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout2, keyRepeatTimeout3, offsetBefore, 891606461, false, (String) objArr67[0], null);
            }
            ((Field) objAccessartificialFrame24).set(null, objArr4);
            try {
                Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame25 == null) {
                    int maximumFlingVelocity2 = 25 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                    char c6 = (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 30067);
                    int i89 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 816;
                    byte[] bArr27 = $$a;
                    byte b16 = bArr27[91];
                    Object[] objArr68 = new Object[1];
                    b(b16, bArr27[12], (byte) (b16 - 1), objArr68);
                    objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity2, c6, i89, 721586079, false, (String) objArr68[0], null);
                }
                ((Field) objAccessartificialFrame25).set(null, lValueOf5);
            } catch (Exception unused5) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame26 == null) {
                int iIndexOf4 = TextUtils.indexOf((CharSequence) "", '0') + 26;
                char c7 = (char) (30069 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                int offsetBefore2 = 816 - TextUtils.getOffsetBefore("", 0);
                byte[] bArr28 = $$a;
                byte b17 = bArr28[91];
                Object[] objArr69 = new Object[1];
                b(b17, bArr28[23], (byte) (b17 - 1), objArr69);
                objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(iIndexOf4, c7, offsetBefore2, 891606461, false, (String) objArr69[0], null);
            }
            Object[] objArr70 = (Object[]) ((Field) objAccessartificialFrame26).get(null);
            objArr4 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i90 = ((int[]) objArr70[0])[0];
            int i91 = ((int[]) objArr70[1])[0];
            String[] strArr5 = (String[]) objArr70[2];
            int iIdentityHashCode5 = System.identityHashCode(this);
            int i92 = ~iIdentityHashCode5;
            int i93 = (~((-163882537) | i92)) | 8224;
            int i94 = ~(iIdentityHashCode5 | 198164141);
            int i95 = ((((i93 | i94) * (-252)) + 200244813) + ((i94 | (~(i92 | (-163874313)))) * 252)) - 1852192221;
            int i96 = (i95 << 13) ^ i95;
            int i97 = i96 ^ (i96 >>> 17);
            ((int[]) objArr4[3])[0] = i97 ^ (i97 << 5);
        }
        int i98 = ((int[]) objArr4[1])[0];
        int i99 = ((int[]) objArr4[0])[0];
        if (i99 == i98) {
            Object[] objArr71 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i100 = ((int[]) objArr4[3])[0];
            int i101 = ((int[]) objArr4[0])[0];
            int i102 = ((int[]) objArr4[1])[0];
            String[] strArr6 = (String[]) objArr4[2];
            int i103 = ~((int) Process.getElapsedCpuTime());
            int i104 = i100 + (((~((-84189866) | i103)) | 67117088) * (-241)) + 783858985 + (((~(i103 | (-17072778))) | 46865412) * 241);
            int i105 = (i104 << 13) ^ i104;
            int i106 = i105 ^ (i105 >>> 17);
            ((int[]) objArr71[3])[0] = i106 ^ (i106 << 5);
        } else {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr7 = (String[]) objArr4[2];
            if (strArr7 != null) {
                int i107 = artificialFrame + 53;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i107 % 128;
                int i108 = i107 % 2;
                for (String str6 : strArr7) {
                    arrayList2.add(str6);
                }
            }
            Object[] objArr72 = {Long.valueOf((((long) (-167625610)) << 32) ^ ((long) (i98 ^ i99))), Long.valueOf(-167625609)};
            byte[] bArr29 = $$d;
            Object[] objArr73 = new Object[1];
            c((short) 333, bArr29[146], bArr29[122], objArr73);
            Class<?> cls8 = Class.forName((String) objArr73[0]);
            byte b18 = bArr29[32];
            Object[] objArr74 = new Object[1];
            c((short) 436, b18, (byte) (b18 | 78), objArr74);
            cls8.getMethod((String) objArr74[0], Long.TYPE, Long.TYPE).invoke(null, objArr72);
            Object[] objArr75 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i109 = ((int[]) objArr4[3])[0];
            int i110 = ((int[]) objArr4[0])[0];
            int i111 = ((int[]) objArr4[1])[0];
            String[] strArr8 = (String[]) objArr4[2];
            int iIdentityHashCode6 = System.identityHashCode(this);
            int i112 = ~iIdentityHashCode6;
            int i113 = i109 + (-1896966497) + (((~(iIdentityHashCode6 | (-529602957))) | (~((-727775323) | i112))) * 333) + (((~(iIdentityHashCode6 | (-727775323))) | (~(i112 | (-529602957)))) * 333);
            int i114 = (i113 << 13) ^ i113;
            int i115 = i114 ^ (i114 >>> 17);
            ((int[]) objArr75[3])[0] = i115 ^ (i115 << 5);
        }
        Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame27 == null) {
            int i116 = 17 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
            char scrollDefaultDelay3 = (char) (ViewConfiguration.getScrollDefaultDelay() >> 16);
            int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 747;
            byte[] bArr30 = $$a;
            byte b19 = bArr30[91];
            Object[] objArr76 = new Object[1];
            b(b19, bArr30[12], (byte) (b19 - 1), objArr76);
            objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(i116, scrollDefaultDelay3, keyRepeatDelay, -144068856, false, (String) objArr76[0], null);
        }
        long j6 = ((Field) objAccessartificialFrame27).getLong(null);
        if (j6 == -1 || j6 + 4611686018427387889L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr77 = new Object[1];
            a(false, 19 - ImageFormat.getBitsPerPixel(0), 135 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), View.MeasureSpec.getSize(0) + 26, new char[]{1, 65483, 65534, CharUtils.CR, CharUtils.CR, 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15, '\f', 6}, objArr77);
            Class<?> cls9 = Class.forName((String) objArr77[0]);
            Object[] objArr78 = new Object[1];
            a(true, 11 - View.MeasureSpec.getMode(0), 142 - Color.argb(0, 0, 0, 0), 18 - Drawable.resolveOpacity(0, 0), new char[]{2, 6, 6, 65495, '\n', 4, 65531, '\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529, 65535}, objArr78);
            Context applicationContext3 = (Context) cls9.getMethod((String) objArr78[0], new Class[0]).invoke(null, null);
            if (applicationContext3 == null) {
                obj = null;
            } else {
                if (applicationContext3 instanceof ContextWrapper) {
                    int i117 = artificialFrame + 61;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i117 % 128;
                    if (i117 % 2 != 0) {
                        ((ContextWrapper) applicationContext3).getBaseContext();
                        Object obj4 = null;
                        obj4.hashCode();
                        throw null;
                    }
                    if (((ContextWrapper) applicationContext3).getBaseContext() == null) {
                        applicationContext3 = null;
                        obj = null;
                    }
                }
                obj = null;
                applicationContext3 = applicationContext3.getApplicationContext();
            }
            Object[] objArr79 = {applicationContext3, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(obj, this)).intValue()), 0, -1858961058};
            byte[] bArr31 = $$d;
            Object[] objArr80 = new Object[1];
            c((short) 295, bArr31[89], bArr31[2], objArr80);
            Class<?> cls10 = Class.forName((String) objArr80[0]);
            Object[] objArr81 = new Object[1];
            c((short) 352, (byte) (-bArr31[317]), bArr31[243], objArr81);
            objArr5 = (Object[]) cls10.getMethod((String) objArr81[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr79);
            Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame28 == null) {
                int i118 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 16;
                char gidForName2 = (char) ((-1) - Process.getGidForName(""));
                int mode3 = View.MeasureSpec.getMode(0) + 747;
                byte[] bArr32 = $$a;
                byte b20 = bArr32[91];
                Object[] objArr82 = new Object[1];
                b(b20, bArr32[23], (byte) (b20 - 1), objArr82);
                objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(i118, gidForName2, mode3, -1031537386, false, (String) objArr82[0], null);
            }
            ((Field) objAccessartificialFrame28).set(null, objArr5);
            try {
                Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame29 == null) {
                    int iResolveSize = 17 - View.resolveSize(0, 0);
                    char c8 = (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                    int bitsPerPixel = 746 - ImageFormat.getBitsPerPixel(0);
                    byte[] bArr33 = $$a;
                    byte b21 = bArr33[91];
                    Object[] objArr83 = new Object[1];
                    b(b21, bArr33[12], (byte) (b21 - 1), objArr83);
                    objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(iResolveSize, c8, bitsPerPixel, -144068856, false, (String) objArr83[0], null);
                }
                ((Field) objAccessartificialFrame29).set(null, lValueOf6);
            } catch (Exception unused6) {
                throw new RuntimeException();
            }
        } else {
            int i119 = artificialFrame + 87;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i119 % 128;
            int i120 = i119 % 2;
            Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame30 == null) {
                int i121 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 17;
                char c9 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                int defaultSize = View.getDefaultSize(0, 0) + 747;
                byte[] bArr34 = $$a;
                byte b22 = bArr34[91];
                Object[] objArr84 = new Object[1];
                b(b22, bArr34[23], (byte) (b22 - 1), objArr84);
                objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(i121, c9, defaultSize, -1031537386, false, (String) objArr84[0], null);
            }
            Object[] objArr85 = (Object[]) ((Field) objAccessartificialFrame30).get(null);
            objArr5 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
            int i122 = ((int[]) objArr85[3])[0];
            int i123 = ((int[]) objArr85[4])[0];
            List list = (List) objArr85[0];
            List list2 = (List) objArr85[2];
            int iIdentityHashCode7 = System.identityHashCode(this);
            int i124 = ~((-944844502) | iIdentityHashCode7);
            int i125 = 10498325 + ((269485249 | i124) * (-280)) + ((i124 | (~(339396043 | iIdentityHashCode7))) * 140);
            int i126 = ~((-675359253) | iIdentityHashCode7);
            int i127 = ~iIdentityHashCode7;
            int i128 = (i125 + (((~(i127 | 1014755295)) | (i126 | (~((-269485250) | i127)))) * 140)) - 1858961058;
            int i129 = (i128 << 13) ^ i128;
            int i130 = i129 ^ (i129 >>> 17);
            ((int[]) objArr5[1])[0] = i130 ^ (i130 << 5);
        }
        int i131 = ((int[]) objArr5[4])[0];
        int i132 = ((int[]) objArr5[3])[0];
        if (i132 == i131) {
            int i133 = artificialFrame + 39;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i133 % 128;
            int i134 = i133 % 2;
            Object[] objArr86 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i135 = ((int[]) objArr5[1])[0];
            int i136 = ((int[]) objArr5[3])[0];
            int i137 = ((int[]) objArr5[4])[0];
            List list3 = (List) objArr5[0];
            List list4 = (List) objArr5[2];
            int i138 = ~System.identityHashCode(this);
            int i139 = i135 + (((872082065 + (((~(i138 | 765370230)) | (~((-159909473) | i138))) * (-184))) + (((605454608 | (~((-765364081) | i138))) | (~(159915622 | i138))) * SyslogConstants.LOG_LOCAL7)) - 1131784);
            int i140 = (i139 << 13) ^ i139;
            int i141 = i140 ^ (i140 >>> 17);
            ((int[]) objArr86[1])[0] = i141 ^ (i141 << 5);
        } else {
            ArrayList arrayList3 = new ArrayList();
            Object[] objArr87 = {objArr5};
            Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(1804664566);
            if (objAccessartificialFrame31 == null) {
                objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(42 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) (12468 - ExpandableListView.getPackedPositionGroup(0L)), 3641 - ExpandableListView.getPackedPositionChild(0L), -185222914, false, "coroutineCreation", new Class[]{Object[].class});
            }
            arrayList3.add(((Method) objAccessartificialFrame31).invoke(null, objArr87));
            Object[] objArr88 = {objArr5};
            Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(-1243809191);
            if (objAccessartificialFrame32 == null) {
                objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(42 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) (12468 - View.resolveSizeAndState(0, 0, 0)), 3642 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
            }
            arrayList3.add(((Method) objAccessartificialFrame32).invoke(null, objArr88));
            Object[] objArr89 = {Long.valueOf((((long) (-459538881)) << 32) ^ ((long) (i131 ^ i132))), Long.valueOf(-459538889)};
            byte[] bArr35 = $$d;
            Object[] objArr90 = new Object[1];
            c((short) 248, bArr35[146], bArr35[31], objArr90);
            Class<?> cls11 = Class.forName((String) objArr90[0]);
            byte b23 = bArr35[32];
            Object[] objArr91 = new Object[1];
            c((short) 436, b23, (byte) (b23 | 78), objArr91);
            cls11.getMethod((String) objArr91[0], Long.TYPE, Long.TYPE).invoke(null, objArr89);
            Object[] objArr92 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i142 = ((int[]) objArr5[1])[0];
            int i143 = ((int[]) objArr5[3])[0];
            int i144 = ((int[]) objArr5[4])[0];
            List list5 = (List) objArr5[0];
            List list6 = (List) objArr5[2];
            int iUptimeMillis2 = (int) SystemClock.uptimeMillis();
            int i145 = ~iUptimeMillis2;
            int i146 = ~((-130739998) | i145);
            int i147 = ~((-474708461) | iUptimeMillis2);
            int i148 = i142 + 364936658 + ((i146 | i147) * 1150) + (((~(474708460 | i145)) | i147) * (-575)) + (((~(iUptimeMillis2 | (-130739998))) | (~(i145 | 130739997))) * 575);
            int i149 = (i148 << 13) ^ i148;
            int i150 = i149 ^ (i149 >>> 17);
            ((int[]) objArr92[1])[0] = i150 ^ (i150 << 5);
        }
        Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame33 == null) {
            int i151 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 21;
            char packedPositionGroup2 = (char) ExpandableListView.getPackedPositionGroup(0L);
            int iMyTid = 465 - (Process.myTid() >> 22);
            byte[] bArr36 = $$a;
            byte b24 = bArr36[91];
            Object[] objArr93 = new Object[1];
            b(b24, bArr36[12], (byte) (b24 - 1), objArr93);
            objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(i151, packedPositionGroup2, iMyTid, -785931255, false, (String) objArr93[0], null);
        }
        long j7 = ((Field) objAccessartificialFrame33).getLong(null);
        if (j7 != -1) {
            int i152 = getARTIFICIAL_FRAME_PACKAGE_NAME + 13;
            artificialFrame = i152 % 128;
            int i153 = i152 % 2;
            if (j7 + 1878 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame34 == null) {
                    int iKeyCodeFromString = KeyEvent.keyCodeFromString("") + 21;
                    char minimumFlingVelocity = (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                    int capsMode = TextUtils.getCapsMode("", 0, 0) + 465;
                    byte[] bArr37 = $$a;
                    byte b25 = bArr37[91];
                    Object[] objArr94 = new Object[1];
                    b(b25, bArr37[23], (byte) (b25 - 1), objArr94);
                    objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString, minimumFlingVelocity, capsMode, -612765161, false, (String) objArr94[0], null);
                }
                Object[] objArr95 = (Object[]) ((Field) objAccessartificialFrame34).get(null);
                objArr6 = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
                int i154 = ((int[]) objArr95[3])[0];
                int i155 = ((int[]) objArr95[0])[0];
                String[] strArr9 = (String[]) objArr95[1];
                int iMyPid = Process.myPid();
                int i156 = ~iMyPid;
                int i157 = (-1188632055) + (((~((-109346819) | i156)) | 269696544) * 220) + (((~(i156 | (-648855968))) | 809205693) * (-440)) + ((iMyPid | (-109346819)) * 220) + 477768328;
                int i158 = (i157 << 13) ^ i157;
                int i159 = i158 ^ (i158 >>> 17);
                ((int[]) objArr6[2])[0] = i159 ^ (i159 << 5);
            } else {
                Object[] objArr96 = new Object[1];
                a(false, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 19, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 134, 26 - TextUtils.getTrimmedLength(""), new char[]{1, 65483, 65534, CharUtils.CR, CharUtils.CR, 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15, '\f', 6}, objArr96);
                Class<?> cls12 = Class.forName((String) objArr96[0]);
                Object[] objArr97 = new Object[1];
                a(true, TextUtils.lastIndexOf("", '0', 0, 0) + 12, 142 - View.resolveSizeAndState(0, 0, 0), 18 - Color.green(0), new char[]{2, 6, 6, 65495, '\n', 4, 65531, '\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529, 65535}, objArr97);
                applicationContext = (Context) cls12.getMethod((String) objArr97[0], new Class[0]).invoke(null, null);
                if (applicationContext != null) {
                    if (applicationContext instanceof ContextWrapper) {
                        i = artificialFrame + 17;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i % 128;
                        if (i % 2 != 0) {
                            int i160 = 25 / 0;
                            if (((ContextWrapper) applicationContext).getBaseContext() != null) {
                                applicationContext = applicationContext.getApplicationContext();
                            } else {
                                applicationContext = null;
                            }
                        } else if (((ContextWrapper) applicationContext).getBaseContext() != null) {
                            applicationContext = applicationContext.getApplicationContext();
                        } else {
                            applicationContext = null;
                        }
                    } else {
                        applicationContext = applicationContext.getApplicationContext();
                    }
                }
                int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                Object[] objArr98 = new Object[1];
                a(true, TextUtils.getTrimmedLength("") + 50, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + com.salesforce.marketingcloud.analytics.stats.b.f39n, KeyEvent.keyCodeFromString("") + 64, new char[]{23, 28, 65510, 25, 65514, 65518, 65515, 28, 25, 65510, 28, 65519, 28, 65518, 26, 65515, 65515, 28, 28, 27, 65518, 26, 65510, 65513, 23, 65517, 28, 65518, 65519, 65515, 65515, 65516, 26, 27, 28, 65518, 65516, 65510, 23, 65515, 65519, 25, 65517, 28, 27, 65513, 65512, 65517, 65511, 28, 65513, 26, 25, 65517, 27, 23, 25, 65510, 23, 65516, 65514, 65519, 65517, 23}, objArr98);
                String str7 = (String) objArr98[0];
                Object[] objArr99 = new Object[1];
                a(false, TextUtils.lastIndexOf("", '0', 0) + 28, View.MeasureSpec.makeMeasureSpec(0, 0) + 105, 63 - TextUtils.lastIndexOf("", '0', 0, 0), new char[]{28, ' ', 65520, 65524, 65517, 65520, 65517, 65518, 65515, 65522, 65517, 65522, 65518, 28, '!', 29, ' ', 65521, 65521, 29, 28, 65523, 65518, 65515, 28, '!', ' ', 65520, 65522, ' ', ' ', ' ', '!', 65515, 65519, 65516, 65524, 65520, 29, 65521, 65518, 31, 65524, 65518, 65521, 65516, ' ', 28, '!', 65520, 28, 65524, 65519, 65521, 65517, 31, 65520, 29, 65517, 65520, 65518, 65517, 65517, 65520}, objArr99);
                Object[] objArr100 = {applicationContext, new String[]{str7, (String) objArr99[0]}, Integer.valueOf(iIntValue2), 1, 477768328};
                short s4 = (short) ($$e + 2);
                byte[] bArr38 = $$d;
                Object[] objArr101 = new Object[1];
                c(s4, bArr38[6], bArr38[2], objArr101);
                Class<?> cls13 = Class.forName((String) objArr101[0]);
                Object[] objArr102 = new Object[1];
                c((short) 138, bArr38[243], bArr38[74], objArr102);
                objArr6 = (Object[]) cls13.getMethod((String) objArr102[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr100);
                int i161 = ((int[]) objArr6[0])[0];
                int i162 = ((int[]) objArr6[3])[0];
                if (applicationContext != null) {
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1142731807);
                    if (objAccessartificialFrame == null) {
                        int minimumFlingVelocity2 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 21;
                        char cMyTid = (char) (Process.myTid() >> 22);
                        int minimumFlingVelocity3 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 465;
                        byte[] bArr39 = $$a;
                        byte b26 = bArr39[91];
                        Object[] objArr103 = new Object[1];
                        b(b26, bArr39[23], (byte) (b26 - 1), objArr103);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity2, cMyTid, minimumFlingVelocity3, -612765161, false, (String) objArr103[0], null);
                    }
                    ((Field) objAccessartificialFrame).set(null, objArr6);
                    try {
                        Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1313006081);
                        if (objAccessartificialFrame2 == null) {
                            int iLastIndexOf6 = 20 - TextUtils.lastIndexOf("", '0');
                            char gidForName3 = (char) ((-1) - Process.getGidForName(""));
                            int iIndexOf5 = TextUtils.indexOf((CharSequence) "", '0') + 466;
                            byte[] bArr40 = $$a;
                            byte b27 = bArr40[91];
                            Object[] objArr104 = new Object[1];
                            b(b27, bArr40[12], (byte) (b27 - 1), objArr104);
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iLastIndexOf6, gidForName3, iIndexOf5, -785931255, false, (String) objArr104[0], null);
                        }
                        ((Field) objAccessartificialFrame2).set(null, lValueOf7);
                    } catch (Exception unused7) {
                        throw new RuntimeException();
                    }
                }
            }
        } else {
            Object[] objArr910 = new Object[1];
            a(false, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 19, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 134, 26 - TextUtils.getTrimmedLength(""), new char[]{1, 65483, 65534, CharUtils.CR, CharUtils.CR, 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15, '\f', 6}, objArr910);
            Class<?> cls14 = Class.forName((String) objArr910[0]);
            Object[] objArr911 = new Object[1];
            a(true, TextUtils.lastIndexOf("", '0', 0, 0) + 12, 142 - View.resolveSizeAndState(0, 0, 0), 18 - Color.green(0), new char[]{2, 6, 6, 65495, '\n', 4, 65531, '\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529, 65535}, objArr911);
            applicationContext = (Context) cls14.getMethod((String) objArr911[0], new Class[0]).invoke(null, null);
            if (applicationContext != null) {
                if (applicationContext instanceof ContextWrapper) {
                    i = artificialFrame + 17;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i % 128;
                    if (i % 2 != 0) {
                        int i163 = 25 / 0;
                        if (((ContextWrapper) applicationContext).getBaseContext() != null) {
                            applicationContext = applicationContext.getApplicationContext();
                        } else {
                            applicationContext = null;
                        }
                    } else if (((ContextWrapper) applicationContext).getBaseContext() != null) {
                        applicationContext = applicationContext.getApplicationContext();
                    } else {
                        applicationContext = null;
                    }
                } else {
                    applicationContext = applicationContext.getApplicationContext();
                }
            }
            int iIntValue3 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr912 = new Object[1];
            a(true, TextUtils.getTrimmedLength("") + 50, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + com.salesforce.marketingcloud.analytics.stats.b.f39n, KeyEvent.keyCodeFromString("") + 64, new char[]{23, 28, 65510, 25, 65514, 65518, 65515, 28, 25, 65510, 28, 65519, 28, 65518, 26, 65515, 65515, 28, 28, 27, 65518, 26, 65510, 65513, 23, 65517, 28, 65518, 65519, 65515, 65515, 65516, 26, 27, 28, 65518, 65516, 65510, 23, 65515, 65519, 25, 65517, 28, 27, 65513, 65512, 65517, 65511, 28, 65513, 26, 25, 65517, 27, 23, 25, 65510, 23, 65516, 65514, 65519, 65517, 23}, objArr912);
            String str8 = (String) objArr912[0];
            Object[] objArr913 = new Object[1];
            a(false, TextUtils.lastIndexOf("", '0', 0) + 28, View.MeasureSpec.makeMeasureSpec(0, 0) + 105, 63 - TextUtils.lastIndexOf("", '0', 0, 0), new char[]{28, ' ', 65520, 65524, 65517, 65520, 65517, 65518, 65515, 65522, 65517, 65522, 65518, 28, '!', 29, ' ', 65521, 65521, 29, 28, 65523, 65518, 65515, 28, '!', ' ', 65520, 65522, ' ', ' ', ' ', '!', 65515, 65519, 65516, 65524, 65520, 29, 65521, 65518, 31, 65524, 65518, 65521, 65516, ' ', 28, '!', 65520, 28, 65524, 65519, 65521, 65517, 31, 65520, 29, 65517, 65520, 65518, 65517, 65517, 65520}, objArr913);
            Object[] objArr105 = {applicationContext, new String[]{str8, (String) objArr913[0]}, Integer.valueOf(iIntValue3), 1, 477768328};
            short s5 = (short) ($$e + 2);
            byte[] bArr310 = $$d;
            Object[] objArr106 = new Object[1];
            c(s5, bArr310[6], bArr310[2], objArr106);
            Class<?> cls15 = Class.forName((String) objArr106[0]);
            Object[] objArr107 = new Object[1];
            c((short) 138, bArr310[243], bArr310[74], objArr107);
            objArr6 = (Object[]) cls15.getMethod((String) objArr107[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr105);
            int i164 = ((int[]) objArr6[0])[0];
            int i165 = ((int[]) objArr6[3])[0];
            if (applicationContext != null) {
                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame == null) {
                    int minimumFlingVelocity4 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 21;
                    char cMyTid2 = (char) (Process.myTid() >> 22);
                    int minimumFlingVelocity5 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 465;
                    byte[] bArr311 = $$a;
                    byte b28 = bArr311[91];
                    Object[] objArr108 = new Object[1];
                    b(b28, bArr311[23], (byte) (b28 - 1), objArr108);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity4, cMyTid2, minimumFlingVelocity5, -612765161, false, (String) objArr108[0], null);
                }
                ((Field) objAccessartificialFrame).set(null, objArr6);
                Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1313006081);
                if (objAccessartificialFrame2 == null) {
                    int iLastIndexOf7 = 20 - TextUtils.lastIndexOf("", '0');
                    char gidForName4 = (char) ((-1) - Process.getGidForName(""));
                    int iIndexOf6 = TextUtils.indexOf((CharSequence) "", '0') + 466;
                    byte[] bArr41 = $$a;
                    byte b29 = bArr41[91];
                    Object[] objArr109 = new Object[1];
                    b(b29, bArr41[12], (byte) (b29 - 1), objArr109);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iLastIndexOf7, gidForName4, iIndexOf6, -785931255, false, (String) objArr109[0], null);
                }
                ((Field) objAccessartificialFrame2).set(null, lValueOf8);
            }
        }
        int i166 = ((int[]) objArr6[0])[0];
        int i167 = ((int[]) objArr6[3])[0];
        if (i167 == i166) {
            Object[] objArr110 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i168 = ((int[]) objArr6[2])[0];
            int i169 = ((int[]) objArr6[3])[0];
            int i170 = ((int[]) objArr6[0])[0];
            String[] strArr10 = (String[]) objArr6[1];
            int iIdentityHashCode8 = System.identityHashCode(this);
            int i171 = ~(455631487 | iIdentityHashCode8);
            int i172 = ~iIdentityHashCode8;
            int i173 = i171 | (~(615981213 | i172));
            int i174 = ~((-455631488) | i172);
            int i175 = i168 + 1258977193 + ((i173 | i174) * (-516)) + (((~(iIdentityHashCode8 | (-613875841))) | (~((-2105374) | i172))) * 516) + ((2105373 | i174) * 516);
            int i176 = (i175 << 13) ^ i175;
            int i177 = i176 ^ (i176 >>> 17);
            ((int[]) objArr110[2])[0] = i177 ^ (i177 << 5);
        } else {
            ArrayList arrayList4 = new ArrayList();
            String[] strArr11 = (String[]) objArr6[1];
            if (strArr11 != null) {
                int i178 = artificialFrame + 87;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i178 % 128;
                int i179 = i178 % 2;
                for (String str9 : strArr11) {
                    arrayList4.add(str9);
                }
            }
            Object[] objArr111 = {Long.valueOf((((long) (-1113510838)) << 32) ^ ((long) (i166 ^ i167))), Long.valueOf(-1113510902)};
            byte[] bArr42 = $$d;
            Object[] objArr112 = new Object[1];
            c((short) 118, bArr42[146], bArr42[122], objArr112);
            Class<?> cls16 = Class.forName((String) objArr112[0]);
            byte b30 = bArr42[32];
            Object[] objArr113 = new Object[1];
            c((short) 436, b30, (byte) (b30 | 78), objArr113);
            cls16.getMethod((String) objArr113[0], Long.TYPE, Long.TYPE).invoke(null, objArr111);
            Object[] objArr114 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i180 = ((int[]) objArr6[2])[0];
            int i181 = ((int[]) objArr6[3])[0];
            int i182 = ((int[]) objArr6[0])[0];
            String[] strArr12 = (String[]) objArr6[1];
            int i183 = ~(System.identityHashCode(this) | (-734848567));
            int i184 = i180 + ((((-1071638135) | i183) * (-196)) - 1013573119) + ((i183 | 336789568) * 196);
            int i185 = (i184 << 13) ^ i184;
            int i186 = i185 ^ (i185 >>> 17);
            ((int[]) objArr114[2])[0] = i186 ^ (i186 << 5);
        }
        boolean zOnCreate = super.onCreate();
        Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame35 == null) {
            int iIndexOf7 = 29 - TextUtils.indexOf((CharSequence) "", '0');
            char scrollDefaultDelay4 = (char) (49362 - (ViewConfiguration.getScrollDefaultDelay() >> 16));
            int i187 = 685 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
            byte[] bArr43 = $$a;
            Object[] objArr115 = new Object[1];
            b(bArr43[14], (byte) ($$b & 496), bArr43[41], objArr115);
            objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(iIndexOf7, scrollDefaultDelay4, i187, 508509282, false, (String) objArr115[0], null);
        }
        long j8 = ((Field) objAccessartificialFrame35).getLong(null);
        if (j8 == -1 || j8 + 1936 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr116 = new Object[1];
            a(false, View.resolveSizeAndState(0, 0, 0) + 20, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 135, 25 - TextUtils.indexOf((CharSequence) "", '0'), new char[]{1, 65483, 65534, CharUtils.CR, CharUtils.CR, 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15, '\f', 6}, objArr116);
            Class<?> cls17 = Class.forName((String) objArr116[0]);
            Object[] objArr117 = new Object[1];
            a(true, 10 - MotionEvent.axisFromString(""), 142 - ((Process.getThreadPriority(0) + 20) >> 6), MotionEvent.axisFromString("") + 19, new char[]{2, 6, 6, 65495, '\n', 4, 65531, '\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529, 65535}, objArr117);
            Context applicationContext4 = (Context) cls17.getMethod((String) objArr117[0], new Class[0]).invoke(null, null);
            if (applicationContext4 != null) {
                applicationContext4 = ((applicationContext4 instanceof ContextWrapper) && ((ContextWrapper) applicationContext4).getBaseContext() == null) ? null : applicationContext4.getApplicationContext();
            }
            Object[] objArr118 = {applicationContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 740460175};
            byte[] bArr44 = $$d;
            Object[] objArr119 = new Object[1];
            c(bArr44[385], bArr44[146], bArr44[32], objArr119);
            Class<?> cls18 = Class.forName((String) objArr119[0]);
            Object[] objArr120 = new Object[1];
            c((short) 138, bArr44[243], bArr44[74], objArr120);
            Object[] objArr121 = (Object[]) cls18.getMethod((String) objArr120[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr118);
            if (applicationContext4 != null) {
                Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame36 == null) {
                    int i188 = 31 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                    char c10 = (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 49361);
                    int mode4 = 684 - View.MeasureSpec.getMode(0);
                    byte[] bArr45 = $$a;
                    Object[] objArr122 = new Object[1];
                    b((byte) (bArr45[91] - 1), (byte) $$b, bArr45[53], objArr122);
                    objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(i188, c10, mode4, -1321816393, false, (String) objArr122[0], null);
                }
                ((Field) objAccessartificialFrame36).set(null, objArr121);
                try {
                    Long lValueOf9 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                    if (objAccessartificialFrame37 == null) {
                        int i189 = 30 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                        char cKeyCodeFromString = (char) (KeyEvent.keyCodeFromString("") + 49362);
                        int i190 = 685 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                        byte[] bArr46 = $$a;
                        Object[] objArr123 = new Object[1];
                        b(bArr46[14], (byte) ($$b & 496), bArr46[41], objArr123);
                        objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(i189, cKeyCodeFromString, i190, 508509282, false, (String) objArr123[0], null);
                    }
                    ((Field) objAccessartificialFrame37).set(null, lValueOf9);
                } catch (Exception unused8) {
                    throw new RuntimeException();
                }
            }
            objArr7 = objArr121;
        } else {
            Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(777251007);
            if (objAccessartificialFrame38 == null) {
                int iLastIndexOf8 = TextUtils.lastIndexOf("", '0', 0) + 31;
                char offsetAfter = (char) (TextUtils.getOffsetAfter("", 0) + 49362);
                int i191 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 684;
                byte[] bArr47 = $$a;
                Object[] objArr124 = new Object[1];
                b((byte) (bArr47[91] - 1), (byte) $$b, bArr47[53], objArr124);
                objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(iLastIndexOf8, offsetAfter, i191, -1321816393, false, (String) objArr124[0], null);
            }
            Object[] objArr125 = (Object[]) ((Field) objAccessartificialFrame38).get(null);
            objArr7 = new Object[]{new int[]{((int[]) objArr125[0])[0]}, new int[]{((int[]) objArr125[1])[0]}, new int[1], (String) objArr125[3]};
            int iIdentityHashCode9 = System.identityHashCode(this);
            int i192 = ~iIdentityHashCode9;
            int i193 = (~((-264288026) | i192)) | 88084760;
            int i194 = ~(iIdentityHashCode9 | (-538132485));
            int i195 = (-2077823534) + ((i193 | i194) * (-713)) + (i194 * 1426) + ((~((-714335750) | i192)) * 713) + 740460175;
            int i196 = (i195 << 13) ^ i195;
            int i197 = i196 ^ (i196 >>> 17);
            ((int[]) objArr7[2])[0] = i197 ^ (i197 << 5);
        }
        int i198 = ((int[]) objArr7[1])[0];
        int i199 = ((int[]) objArr7[0])[0];
        if (i199 == i198) {
            int i200 = ((int[]) objArr7[2])[0];
            Object[] objArr126 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
            int iMyPid2 = Process.myPid();
            int i201 = i200 + 1669747082 + (((~iMyPid2) | 72687136) * 1324) + (((~(iMyPid2 | 350035628)) | (~(628588146 | iMyPid2))) * (-1324)) + 1855356436;
            int i202 = (i201 << 13) ^ i201;
            int i203 = i202 ^ (i202 >>> 17);
            ((int[]) objArr126[2])[0] = i203 ^ (i203 << 5);
        } else {
            Object[] objArr127 = {Long.valueOf((((long) (-1442191863)) << 32) ^ ((long) (i198 ^ i199))), Long.valueOf(-1442192375)};
            byte[] bArr48 = $$d;
            short s6 = bArr48[32];
            byte b31 = bArr48[146];
            Object[] objArr128 = new Object[1];
            c(s6, b31, (byte) (b31 & 248), objArr128);
            Class<?> cls19 = Class.forName((String) objArr128[0]);
            byte b32 = bArr48[32];
            Object[] objArr129 = new Object[1];
            c((short) 436, b32, (byte) (b32 | 78), objArr129);
            cls19.getMethod((String) objArr129[0], Long.TYPE, Long.TYPE).invoke(null, objArr127);
            int i204 = ((int[]) objArr7[2])[0];
            Object[] objArr130 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
            int i205 = ~(Process.myUid() | 735626967);
            int i206 = i204 + (-666633474) + (((-242996808) | i205) * (-220)) + ((i205 | (-805033688)) * 220) + 739319264;
            int i207 = (i206 << 13) ^ i206;
            int i208 = i207 ^ (i207 >>> 17);
            ((int[]) objArr130[2])[0] = i208 ^ (i208 << 5);
        }
        return zOnCreate;
    }

    static {
        byte[] bArr = new byte[597];
        System.arraycopy("#î!À\tÊG\u0002\b¿B\u0007üÿ\u0003\u0006\fÇ9\rù\u0016\u0004úþÏFõ\u0017\u0004õ\u0011\u0000Ä(\u0017\u000bù\u0017ù\u0011óó\u0019\büâ0\u0003\fó\u0011\u0006õ\u0011\u0010\u0007\u0001\n\u0003ù\tûâ3÷\u0000\u0017ù\n\u0003\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000ÇH÷\u0000\u0006\u0015¾Kø\bø\u0011÷\n\u0002\u0011À/\u001aüþñ%ù\u0005ï#\u0004\u0001¼\u0004%7\u0000õ\u0011\u0000÷\u000fë*ù\nø\u0001\u0013ùþí\u0019\u0010ù\u0006\u0001Ó\u0004A\u0000\u0001\u0010\u0004\u0000Çÿ?\t\nõ\u0011\u0000÷\u000fÆF\u0000ù\u0017ö\r\u0007ÿÅ7\u0011ú\u0012\u0001þÿÎ\u001a%\u0005\u0003\u0011\u0004÷\u0003ó ø\fþ\u0013Ñ'\u0001\u0013\bõ\u0011\nÃIö\r\n\u0002\u000b¹)\u0016\r\n\u0002\u000bÚ%\bù\n\u0003\tµ0&\u0001\r\u00050\u0007\u0001\n\u0003ù\tûã%\u0001\u0017ö\u0004\u0006\týè-\u0010\u0002Å=\f\u0004ü\týÍ9\u0013\u000bû\bÿÃJù\t\u0001Ç7\b\u0000\u0007Î\u0017(\u0012Ö \u001b×\u001e\u0018¯\u0011\u0007ùË@\tù\u0001ÑJù\büÍ\u001a!\u0017õó\u0019\büô#ù\u0007\u000bµ/\u001b\u0004\u0011ö\u0013Ý \u0007\u0004\u0001\u000eá&\u0001\u000b÷ÿ\u0005\u0011\u0010\u0002Å=\f\u0004ü\týÍ7\u0011ú\u0012\u0001þÿÎ=\n\n¿?\t\nõ\u0011\u0000÷\u000fÆC\u0003\u0003\u0002\u000fï\u001b÷\u000eú\n\u0003õ\u0007\u0003\u0015õ\u0010ù\u0005þ\u0007\u0017ýú\fý\u0003ÎP\u0004ï\b\tü\u0001\tÄJõ\u0017\u0000¾)%\u0002û\tý\u0010Ü-ï\u0004ø%\u0002û\týë+üù\u0007\u0011Õ0\u0003\fó\u0011\u0005ú\n\u0003\tÜ-\u0006\u0004\u0006\u0012\u0004ò\u0015\u0006ù\u0001\u0007þ\nü\u000fÞ0ó\u0010ü\u0010\u0002Å=\f\u0004ü\týÍC\u0003\u0003\u0002\u000f¾9\u0010\u0002\u0004\u0006\u0003ÄIõ\u000b\u0002\t\nõ\u0011\u0000÷\u000fÆP\u0004û\u0010\u0002Å=\f\u0004ü\týÍ7\u0011ú\u0012\u0001þÿÎ:\u0001\u0017ñ\u0017\u0002ó\u0011\t\u0001\u0003\u0007\u0006¾H\u0007ý\nù\büÍ<\u0007\r÷\u0001\u0003\u0016öÍJ\u0002ó\u0011\t\u0001\u0003\u0007\u0006¾\u001d)\u0007÷\u0003\u000få\u001c\u0013\u0002ûþ\u0014µ\"7ø\u0007ü\u0005\u0011\u0010\u0002Å=\f\u0004ü\týÍ7\u0013ýÉ'(þ\tñó&\u0001\tÿ".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 597);
        $$d = bArr;
        $$e = 183;
        $$a = new byte[]{47, 75, -118, 7, -2, Ascii.SI, -33, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, 10, -31, Ascii.DC4, Ascii.CR, -8, -11, -13, Ascii.ESC, 5, -1, -33, 33, -2, -9, 5, -7, 5, -1, -50, 39, Ascii.VT, -7, -12, Ascii.SI, 49, 2, -11, -3, 3, -6, 6, -8, Ascii.VT, -25, 33, -19, 2, 8, -37, 44, -17, Ascii.FF, -8, Ascii.SO, -9, Ascii.DC2, -34, Ascii.EM, 4, -17, 19, -15, -1, -18, Ascii.SI, 19, -11, 5, -7, -2, Ascii.SI, -36, Ascii.NAK, Ascii.CR, -15, 2, 9, 6, -34, Ascii.SI, 19, -11, 5, -7, Ascii.ESC, 1, -7, -6, -33, 51, -12, 3, -8, 1, Ascii.CR, -9, Ascii.DC2, -36, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, -7, Ascii.DC2, -43, Ascii.GS, -4, 17, 2};
        $$b = AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        setDefaultImpl = -260893999;
    }
}
