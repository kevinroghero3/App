package cl.json;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
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
import kotlin.io.path.ExceptionsCollector$$ExternalSyntheticApiModelOutline6;
import o.ArtificialStackFrames;
import o._CREATION;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes4.dex */
public class RNShareFileProvider extends FileProvider {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    private static long _BOUNDARY;
    private static char[] _CREATION;
    private static int artificialFrame;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static final byte[] $$c = {123, -106, -53, 126};
    private static final int $$f = 92;
    private static int $10 = 0;
    private static int $11 = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(short r7, byte r8, short r9) {
        /*
            int r7 = r7 * 4
            int r7 = 4 - r7
            int r9 = r9 * 3
            int r9 = r9 + 1
            byte[] r0 = cl.json.RNShareFileProvider.$$c
            int r8 = 106 - r8
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r8
            r5 = r2
            r8 = r7
            goto L2b
        L15:
            r3 = r2
        L16:
            r6 = r8
            r8 = r7
            r7 = r6
            byte r4 = (byte) r7
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r9) goto L26
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            return r7
        L26:
            r3 = r0[r8]
            r6 = r8
            r8 = r7
            r7 = r6
        L2b:
            int r7 = r7 + 1
            int r3 = -r3
            int r8 = r8 + r3
            r3 = r5
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: cl.json.RNShareFileProvider.$$g(short, byte, short):java.lang.String");
    }

    private static void b(byte b, int i, short s, Object[] objArr) {
        int i2 = 100 - i;
        int i3 = 112 - s;
        byte[] bArr = $$a;
        byte[] bArr2 = new byte[b + 8];
        int i4 = b + 7;
        int i5 = -1;
        if (bArr == null) {
            i2++;
            i3 = i2 + i4;
        }
        while (true) {
            int i6 = i3;
            int i7 = i2;
            i5++;
            bArr2[i5] = (byte) i6;
            if (i5 == i4) {
                objArr[0] = new String(bArr2, 0);
                return;
            } else {
                i2 = i7 + 1;
                i3 = i6 + bArr[i7];
            }
        }
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
    private static void c(byte r5, int r6, short r7, java.lang.Object[] r8) {
        /*
            int r6 = 581 - r6
            byte[] r0 = cl.json.RNShareFileProvider.$$d
            int r5 = r5 + 36
            int r1 = 82 - r7
            byte[] r1 = new byte[r1]
            int r7 = 81 - r7
            r2 = 0
            if (r0 != 0) goto L13
            r4 = r6
            r5 = r7
            r3 = r2
            goto L25
        L13:
            r3 = r2
        L14:
            byte r4 = (byte) r5
            r1[r3] = r4
            if (r3 != r7) goto L21
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L21:
            int r3 = r3 + 1
            r4 = r0[r6]
        L25:
            int r6 = r6 + 1
            int r5 = r5 + r4
            int r5 = r5 + (-3)
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: cl.json.RNShareFileProvider.c(byte, int, short, java.lang.Object[]):void");
    }

    private static void a(char c, int i, int i2, Object[] objArr) throws Throwable {
        int i3 = 2 % 2;
        _CREATION _creation = new _CREATION();
        long[] jArr = new long[i2];
        _creation.b = 0;
        while (_creation.b < i2) {
            int i4 = _creation.b;
            try {
                Object[] objArr2 = {Integer.valueOf(_CREATION[i + i4])};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) 0;
                    byte b2 = (byte) (b + 2);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.getTrimmedLength("") + 8, (char) (KeyEvent.getDeadChar(0, 0) + 9279), 1977 - TextUtils.getTrimmedLength(""), 1113883676, false, $$g(b, b2, (byte) (b2 - 2)), new Class[]{Integer.TYPE});
                }
                Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i4), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                if (objAccessartificialFrame2 == null) {
                    byte b3 = (byte) 0;
                    byte b4 = b3;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(29 - MotionEvent.axisFromString(""), (char) (49362 - (ViewConfiguration.getLongPressTimeout() >> 16)), 684 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), -115095555, false, $$g(b3, b4, b4), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                }
                jArr[i4] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                Object[] objArr4 = {_creation, _creation};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) 0;
                    byte b6 = (byte) (b5 + 3);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(25 - (ViewConfiguration.getTapTimeout() >> 16), (char) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 30068), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 816, 1897803493, false, $$g(b5, b6, (byte) (b6 - 3)), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        char[] cArr = new char[i2];
        _creation.b = 0;
        int i5 = $10 + 23;
        $11 = i5 % 128;
        int i6 = i5 % 2;
        while (_creation.b < i2) {
            int i7 = $10 + 39;
            $11 = i7 % 128;
            if (i7 % 2 == 0) {
                cArr[_creation.b] = (char) jArr[_creation.b];
                Object[] objArr5 = {_creation, _creation};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-293902099);
                if (objAccessartificialFrame4 == null) {
                    byte b7 = (byte) 0;
                    byte b8 = (byte) (b7 + 3);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(24 - Process.getGidForName(""), (char) (30068 - (ViewConfiguration.getScrollBarSize() >> 8)), 815 - ExpandableListView.getPackedPositionChild(0L), 1897803493, false, $$g(b7, b8, (byte) (b8 - 3)), new Class[]{Object.class, Object.class});
                }
                Object obj = null;
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                obj.hashCode();
                throw null;
            }
            cArr[_creation.b] = (char) jArr[_creation.b];
            Object[] objArr6 = {_creation, _creation};
            Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-293902099);
            if (objAccessartificialFrame5 == null) {
                byte b9 = (byte) 0;
                byte b10 = (byte) (b9 + 3);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(25 - Color.alpha(0), (char) (30068 - ExpandableListView.getPackedPositionGroup(0L)), 816 - TextUtils.getCapsMode("", 0, 0), 1897803493, false, $$g(b9, b10, (byte) (b10 - 3)), new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame5).invoke(null, objArr6);
        }
        objArr[0] = new String(cArr);
    }

    /* JADX WARN: Code duplicated, block: B:253:0x1b19  */
    /* JADX WARN: Code duplicated, block: B:256:0x1b22 A[Catch: all -> 0x219b, TryCatch #9 {all -> 0x219b, blocks: (B:289:0x1f1e, B:291:0x1f32, B:292:0x1f62, B:254:0x1b1c, B:256:0x1b22, B:257:0x1b53, B:259:0x1b7c, B:260:0x1c01, B:150:0x1003, B:152:0x1010, B:153:0x103c, B:155:0x1046, B:157:0x1053, B:158:0x1085, B:42:0x0594, B:44:0x05b5, B:45:0x0605), top: B:359:0x0594 }] */
    /* JADX WARN: Code duplicated, block: B:259:0x1b7c A[Catch: all -> 0x219b, TryCatch #9 {all -> 0x219b, blocks: (B:289:0x1f1e, B:291:0x1f32, B:292:0x1f62, B:254:0x1b1c, B:256:0x1b22, B:257:0x1b53, B:259:0x1b7c, B:260:0x1c01, B:150:0x1003, B:152:0x1010, B:153:0x103c, B:155:0x1046, B:157:0x1053, B:158:0x1085, B:42:0x0594, B:44:0x05b5, B:45:0x0605), top: B:359:0x0594 }] */
    /* JADX WARN: Code duplicated, block: B:263:0x1c14  */
    /* JADX WARN: Code duplicated, block: B:268:0x1c77  */
    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public boolean onCreate() throws Throwable {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        Object[] objArr5;
        Object[] objArr6;
        Object objAccessartificialFrame;
        Object objAccessartificialFrame2;
        Object[] objArr7;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        Object[] objArr8;
        int i = 2 % 2;
        Object[] objArr9 = new Object[1];
        a((char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), (Process.getThreadPriority(0) + 20) >> 6, 23 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), objArr9);
        String str = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        a((char) (View.MeasureSpec.getSize(0) + 28504), TextUtils.indexOf((CharSequence) "", '0') + 23, 15 - (ViewConfiguration.getScrollBarSize() >> 8), objArr10);
        String str2 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        a((char) KeyEvent.getDeadChar(0, 0), 38 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), TextUtils.indexOf("", "", 0) + 16, objArr11);
        String str3 = (String) objArr11[0];
        Object[] objArr12 = new Object[1];
        a((char) (Color.red(0) + 51144), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 53, 16 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), objArr12);
        String str4 = (String) objArr12[0];
        Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame5 == null) {
            int iIndexOf = 30 - TextUtils.indexOf("", "");
            char cIndexOf = (char) (49362 - TextUtils.indexOf("", "", 0));
            int i2 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 683;
            byte[] bArr = $$a;
            byte b = bArr[14];
            byte b2 = (byte) ($$b & 480);
            byte b3 = bArr[73];
            Object[] objArr13 = new Object[1];
            b(b, b2, b3, objArr13);
            objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iIndexOf, cIndexOf, i2, -1583976536, false, (String) objArr13[0], null);
        }
        long j = ((Field) objAccessartificialFrame5).getLong(null);
        if (j == -1 || j + 2035 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            try {
                Object[] objArr14 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -1425815683};
                byte[] bArr2 = $$d;
                Object[] objArr15 = new Object[1];
                c((byte) (bArr2[73] - 1), (short) 577, (byte) (bArr2[14] - 1), objArr15);
                Class<?> cls = Class.forName((String) objArr15[0]);
                Object[] objArr16 = new Object[1];
                c((byte) (bArr2[73] - 1), (short) 549, bArr2[587], objArr16);
                objArr = (Object[]) cls.getMethod((String) objArr16[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr14);
                Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame6 == null) {
                    int touchSlop = (ViewConfiguration.getTouchSlop() >> 8) + 30;
                    char packedPositionChild = (char) (ExpandableListView.getPackedPositionChild(0L) + 49363);
                    int i3 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 683;
                    byte[] bArr3 = $$a;
                    Object[] objArr17 = new Object[1];
                    b(bArr3[41], (byte) 84, (byte) (-bArr3[15]), objArr17);
                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(touchSlop, packedPositionChild, i3, -1456483158, false, (String) objArr17[0], null);
                }
                ((Field) objAccessartificialFrame6).set(null, objArr);
                try {
                    Long lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(1056123296);
                    if (objAccessartificialFrame7 == null) {
                        int capsMode = 30 - TextUtils.getCapsMode("", 0, 0);
                        char cIndexOf2 = (char) (49361 - TextUtils.indexOf((CharSequence) "", '0'));
                        int iResolveOpacity = Drawable.resolveOpacity(0, 0) + 684;
                        byte[] bArr4 = $$a;
                        Object[] objArr18 = new Object[1];
                        b(bArr4[14], (byte) ($$b & 480), bArr4[73], objArr18);
                        objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(capsMode, cIndexOf2, iResolveOpacity, -1583976536, false, (String) objArr18[0], null);
                    }
                    ((Field) objAccessartificialFrame7).set(null, lValueOf);
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
            Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame8 == null) {
                int fadingEdgeLength = 30 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                char c = (char) (49362 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)));
                int i4 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 684;
                byte[] bArr5 = $$a;
                Object[] objArr19 = new Object[1];
                b(bArr5[41], (byte) 84, (byte) (-bArr5[15]), objArr19);
                objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength, c, i4, -1456483158, false, (String) objArr19[0], null);
            }
            Object[] objArr20 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
            objArr = new Object[]{new int[]{((int[]) objArr20[0])[0]}, new int[]{((int[]) objArr20[1])[0]}, new int[1], (String) objArr20[3]};
            int iIdentityHashCode = System.identityHashCode(this);
            int i5 = ~iIdentityHashCode;
            int i6 = ((((-917385778) + (((~(iIdentityHashCode | 155866073)) | ((~((-17449282) | i5)) | (-961174494))) * (-68))) + ((~((-805308421) | i5)) * (-68))) + (((~((-155866074) | i5)) | (-822757702)) * 68)) - 1425815683;
            int i7 = (i6 << 13) ^ i6;
            int i8 = i7 ^ (i7 >>> 17);
            ((int[]) objArr[2])[0] = i8 ^ (i8 << 5);
        }
        int i9 = ((int[]) objArr[1])[0];
        int i10 = ((int[]) objArr[0])[0];
        if (i10 == i9) {
            int i11 = ((int[]) objArr[2])[0];
            Object[] objArr21 = {new int[]{((int[]) objArr[0])[0]}, new int[]{((int[]) objArr[1])[0]}, new int[1], (String) objArr[3]};
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i12 = ~((-347903473) | iIdentityHashCode2);
            int i13 = ~iIdentityHashCode2;
            int i14 = i12 | (~(630720302 | i13));
            int i15 = ~(347903472 | i13);
            int i16 = i11 + 1074027558 + ((i14 | i15) * (-516)) + (((~(iIdentityHashCode2 | (-77071649))) | (~((-553648655) | i13))) * 516) + ((553648654 | i15) * 516);
            int i17 = (i16 << 13) ^ i16;
            int i18 = i17 ^ (i17 >>> 17);
            ((int[]) objArr21[2])[0] = i18 ^ (i18 << 5);
        } else {
            new ArrayList().add((String) objArr[3]);
            try {
                Object[] objArr22 = {Long.valueOf((((long) (-109256707)) << 32) ^ ((long) (i9 ^ i10))), Long.valueOf(-109256723)};
                byte[] bArr6 = $$d;
                Object[] objArr23 = new Object[1];
                c((byte) (bArr6[73] - 1), (short) 533, bArr6[605], objArr23);
                Class<?> cls2 = Class.forName((String) objArr23[0]);
                byte b4 = bArr6[18];
                Object[] objArr24 = new Object[1];
                c(b4, (short) (b4 | 509), (byte) 79, objArr24);
                cls2.getMethod((String) objArr24[0], Long.TYPE, Long.TYPE).invoke(null, objArr22);
                int i19 = ((int[]) objArr[2])[0];
                Object[] objArr25 = {new int[]{((int[]) objArr[0])[0]}, new int[]{((int[]) objArr[1])[0]}, new int[1], (String) objArr[3]};
                int iNextInt = new Random().nextInt();
                int i20 = i19 + 1803133114 + (((~((-647904828) | iNextInt)) | (-330718948)) * (-964)) + (((~((~iNextInt) | (-647904828))) | 604512280) * (-964));
                int i21 = (i20 << 13) ^ i20;
                int i22 = i21 ^ (i21 >>> 17);
                ((int[]) objArr25[2])[0] = i22 ^ (i22 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 != null) {
                    throw cause2;
                }
                throw th2;
            }
        }
        Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame9 == null) {
            int capsMode2 = 25 - TextUtils.getCapsMode("", 0, 0);
            char modifierMetaStateMask = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 30069);
            int touchSlop2 = 816 - (ViewConfiguration.getTouchSlop() >> 8);
            byte b5 = $$a[41];
            Object[] objArr26 = new Object[1];
            b(b5, (byte) 76, (byte) (b5 - 1), objArr26);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(capsMode2, modifierMetaStateMask, touchSlop2, 721586079, false, (String) objArr26[0], null);
        }
        long j2 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j2 == -1 || j2 + 1997 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            try {
                Object[] objArr27 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 293206593};
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame10 == null) {
                    int i23 = 25 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                    char cResolveOpacity = (char) (30068 - Drawable.resolveOpacity(0, 0));
                    int windowTouchSlop = (ViewConfiguration.getWindowTouchSlop() >> 8) + 816;
                    byte b6 = $$a[55];
                    byte b7 = (byte) (b6 | 56);
                    Object[] objArr28 = new Object[1];
                    b(b6, b7, (byte) (b7 & 95), objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(i23, cResolveOpacity, windowTouchSlop, -797394565, false, (String) objArr28[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr2 = (Object[]) ((Method) objAccessartificialFrame10).invoke(null, objArr27);
                Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame11 == null) {
                    int windowTouchSlop2 = 25 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                    char c2 = (char) (30069 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
                    int i24 = 817 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                    byte b8 = $$a[41];
                    Object[] objArr29 = new Object[1];
                    b(b8, (byte) 68, (byte) (b8 - 1), objArr29);
                    objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(windowTouchSlop2, c2, i24, 891606461, false, (String) objArr29[0], null);
                }
                ((Field) objAccessartificialFrame11).set(null, objArr2);
                try {
                    Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame12 == null) {
                        int iIndexOf2 = 25 - TextUtils.indexOf("", "", 0, 0);
                        char cNormalizeMetaState = (char) (30068 - KeyEvent.normalizeMetaState(0));
                        int i25 = 816 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                        byte b9 = $$a[41];
                        Object[] objArr30 = new Object[1];
                        b(b9, (byte) 76, (byte) (b9 - 1), objArr30);
                        objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iIndexOf2, cNormalizeMetaState, i25, 721586079, false, (String) objArr30[0], null);
                    }
                    ((Field) objAccessartificialFrame12).set(null, lValueOf2);
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
            Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame13 == null) {
                int iIndexOf3 = 25 - TextUtils.indexOf("", "");
                char c3 = (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 30069);
                int iRgb = (-16776400) - Color.rgb(0, 0, 0);
                byte b10 = $$a[41];
                Object[] objArr31 = new Object[1];
                b(b10, (byte) 68, (byte) (b10 - 1), objArr31);
                objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(iIndexOf3, c3, iRgb, 891606461, false, (String) objArr31[0], null);
            }
            Object[] objArr32 = (Object[]) ((Field) objAccessartificialFrame13).get(null);
            objArr2 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i26 = ((int[]) objArr32[0])[0];
            int i27 = ((int[]) objArr32[1])[0];
            String[] strArr = (String[]) objArr32[2];
            int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
            int i28 = 844196767 + (((~(802897955 | iMaxMemory)) | 72368130) * (-502)) + ((~((~iMaxMemory) | 1073438451)) * (-502)) + (((~(iMaxMemory | (-1001070322))) | 802897955) * TypedValues.PositionType.TYPE_DRAWPATH) + 293206593;
            int i29 = (i28 << 13) ^ i28;
            int i30 = i29 ^ (i29 >>> 17);
            ((int[]) objArr2[3])[0] = i30 ^ (i30 << 5);
        }
        int i31 = ((int[]) objArr2[1])[0];
        int i32 = ((int[]) objArr2[0])[0];
        if (i32 == i31) {
            Object[] objArr33 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i33 = ((int[]) objArr2[3])[0];
            int i34 = ((int[]) objArr2[0])[0];
            int i35 = ((int[]) objArr2[1])[0];
            String[] strArr2 = (String[]) objArr2[2];
            int elapsedCpuTime = (int) Process.getElapsedCpuTime();
            int i36 = ~elapsedCpuTime;
            int i37 = i33 + 724417667 + (((~((-43239548) | i36)) | 33783881) * (-108)) + (((~(i36 | 241411913)) | (~((-241411914) | elapsedCpuTime)) | (-250867580)) * 54) + ((elapsedCpuTime | (-250867580)) * 54);
            int i38 = (i37 << 13) ^ i37;
            int i39 = i38 ^ (i38 >>> 17);
            ((int[]) objArr33[3])[0] = i39 ^ (i39 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr2[2];
            if (strArr3 != null) {
                for (String str5 : strArr3) {
                    int i40 = getARTIFICIAL_FRAME_PACKAGE_NAME + 61;
                    artificialFrame = i40 % 128;
                    int i41 = i40 % 2;
                    arrayList.add(str5);
                }
            }
            long j3 = ((long) (i31 ^ i32)) ^ (((long) (-288027228)) << 32);
            long j4 = -288027227;
            int i42 = artificialFrame + 49;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i42 % 128;
            int i43 = i42 % 2;
            Object[] objArr34 = {Long.valueOf(j3), Long.valueOf(j4)};
            byte[] bArr7 = $$d;
            Object[] objArr35 = new Object[1];
            c((byte) (bArr7[73] - 1), (short) ($$e | 344), bArr7[18], objArr35);
            Class<?> cls3 = Class.forName((String) objArr35[0]);
            byte b11 = bArr7[18];
            Object[] objArr36 = new Object[1];
            c(b11, (short) (b11 | 509), (byte) 79, objArr36);
            cls3.getMethod((String) objArr36[0], Long.TYPE, Long.TYPE).invoke(null, objArr34);
            Object[] objArr37 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i44 = ((int[]) objArr2[3])[0];
            int i45 = ((int[]) objArr2[0])[0];
            int i46 = ((int[]) objArr2[1])[0];
            String[] strArr4 = (String[]) objArr2[2];
            int iIdentityHashCode3 = System.identityHashCode(this);
            int i47 = ~iIdentityHashCode3;
            int i48 = i44 + 1503083027 + (((~((-336593683) | iIdentityHashCode3)) | (~(i47 | (-164115533))) | 138421316) * 717) + (((~((-336593683) | i47)) | 138421316 | (~(iIdentityHashCode3 | (-164115533)))) * 717);
            int i49 = (i48 << 13) ^ i48;
            int i50 = i49 ^ (i49 >>> 17);
            ((int[]) objArr37[3])[0] = i50 ^ (i50 << 5);
            int i51 = artificialFrame + 71;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i51 % 128;
            int i52 = i51 % 2;
        }
        Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame14 == null) {
            int packedPositionChild2 = 20 - ExpandableListView.getPackedPositionChild(0L);
            char threadPriority = (char) ((Process.getThreadPriority(0) + 20) >> 6);
            int iGreen = Color.green(0) + 465;
            byte b12 = $$a[41];
            Object[] objArr38 = new Object[1];
            b(b12, (byte) 76, (byte) (b12 - 1), objArr38);
            objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(packedPositionChild2, threadPriority, iGreen, -785931255, false, (String) objArr38[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame14).getLong(null);
        if (j5 == -1 || j5 + 1913 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr39 = new Object[1];
            a((char) (ViewConfiguration.getWindowTouchSlop() >> 8), 69 - (ViewConfiguration.getFadingEdgeLength() >> 16), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 26, objArr39);
            Class<?> cls4 = Class.forName((String) objArr39[0]);
            Object[] objArr40 = new Object[1];
            a((char) (View.MeasureSpec.getSize(0) + 58350), Drawable.resolveOpacity(0, 0) + 95, Color.green(0) + 18, objArr40);
            Context applicationContext = (Context) cls4.getMethod((String) objArr40[0], new Class[0]).invoke(null, null);
            if (applicationContext != null) {
                applicationContext = ((applicationContext instanceof ContextWrapper) && ((ContextWrapper) applicationContext).getBaseContext() == null) ? null : applicationContext.getApplicationContext();
            }
            int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr41 = new Object[1];
            a((char) (23374 - (ViewConfiguration.getLongPressTimeout() >> 16)), Color.red(0) + 113, 64 - TextUtils.getCapsMode("", 0, 0), objArr41);
            String str6 = (String) objArr41[0];
            Object[] objArr42 = new Object[1];
            a((char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 177 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 63 - ExpandableListView.getPackedPositionChild(0L), objArr42);
            Object[] objArr43 = {applicationContext, new String[]{str6, (String) objArr42[0]}, Integer.valueOf(iIntValue), 1, -1072117555};
            byte[] bArr8 = $$d;
            Object[] objArr44 = new Object[1];
            c((byte) (bArr8[73] - 1), (short) 426, bArr8[462], objArr44);
            Class<?> cls5 = Class.forName((String) objArr44[0]);
            byte b13 = bArr8[171];
            Object[] objArr45 = new Object[1];
            c((byte) (-b13), (short) 364, (byte) (-b13), objArr45);
            objArr3 = (Object[]) cls5.getMethod((String) objArr45[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr43);
            int i53 = ((int[]) objArr3[0])[0];
            int i54 = ((int[]) objArr3[3])[0];
            if (applicationContext != null) {
                Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame15 == null) {
                    int gidForName = Process.getGidForName("") + 22;
                    char cGreen = (char) Color.green(0);
                    int packedPositionChild3 = 464 - ExpandableListView.getPackedPositionChild(0L);
                    byte b14 = $$a[41];
                    Object[] objArr46 = new Object[1];
                    b(b14, (byte) 68, (byte) (b14 - 1), objArr46);
                    objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(gidForName, cGreen, packedPositionChild3, -612765161, false, (String) objArr46[0], null);
                }
                ((Field) objAccessartificialFrame15).set(null, objArr3);
                try {
                    Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1313006081);
                    if (objAccessartificialFrame16 == null) {
                        int iAlpha = Color.alpha(0) + 21;
                        char modifierMetaStateMask2 = (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask()));
                        int scrollBarSize = 465 - (ViewConfiguration.getScrollBarSize() >> 8);
                        byte b15 = $$a[41];
                        Object[] objArr47 = new Object[1];
                        b(b15, (byte) 76, (byte) (b15 - 1), objArr47);
                        objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(iAlpha, modifierMetaStateMask2, scrollBarSize, -785931255, false, (String) objArr47[0], null);
                    }
                    ((Field) objAccessartificialFrame16).set(null, lValueOf3);
                } catch (Exception unused3) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(1142731807);
            if (objAccessartificialFrame17 == null) {
                int iAxisFromString = 20 - MotionEvent.axisFromString("");
                char cMakeMeasureSpec = (char) View.MeasureSpec.makeMeasureSpec(0, 0);
                int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 465;
                byte b16 = $$a[41];
                Object[] objArr48 = new Object[1];
                b(b16, (byte) 68, (byte) (b16 - 1), objArr48);
                objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(iAxisFromString, cMakeMeasureSpec, keyRepeatDelay, -612765161, false, (String) objArr48[0], null);
            }
            Object[] objArr49 = (Object[]) ((Field) objAccessartificialFrame17).get(null);
            objArr3 = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
            int i55 = ((int[]) objArr49[3])[0];
            int i56 = ((int[]) objArr49[0])[0];
            String[] strArr5 = (String[]) objArr49[1];
            int iIdentityHashCode4 = System.identityHashCode(this);
            int i57 = ~iIdentityHashCode4;
            int i58 = (((1762189828 + (((~((-992229683) | i57)) | 831879956) * (-865))) + ((~(iIdentityHashCode4 | 992229682)) * 865)) + (((~(831879956 | i57)) | (~(i57 | 992229682))) * 865)) - 1072117555;
            int i59 = (i58 << 13) ^ i58;
            int i60 = i59 ^ (i59 >>> 17);
            ((int[]) objArr3[2])[0] = i60 ^ (i60 << 5);
        }
        int i61 = ((int[]) objArr3[0])[0];
        int i62 = ((int[]) objArr3[3])[0];
        if (i62 == i61) {
            int i63 = getARTIFICIAL_FRAME_PACKAGE_NAME + 5;
            artificialFrame = i63 % 128;
            int i64 = i63 % 2;
            Object[] objArr50 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i65 = ((int[]) objArr3[2])[0];
            int i66 = ((int[]) objArr3[3])[0];
            int i67 = ((int[]) objArr3[0])[0];
            String[] strArr6 = (String[]) objArr3[1];
            int iIdentityHashCode5 = System.identityHashCode(this);
            int i68 = i65 + 1553107679 + (((~((-68728505) | iIdentityHashCode5)) | (-92190718)) * (-502)) + ((~((~iIdentityHashCode5) | (-569497))) * (-502)) + (((~(iIdentityHashCode5 | (-91621222))) | (-68728505)) * TypedValues.PositionType.TYPE_DRAWPATH);
            int i69 = (i68 << 13) ^ i68;
            int i70 = i69 ^ (i69 >>> 17);
            ((int[]) objArr50[2])[0] = i70 ^ (i70 << 5);
        } else {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr7 = (String[]) objArr3[1];
            if (strArr7 != null) {
                for (String str7 : strArr7) {
                    arrayList2.add(str7);
                }
            }
            Object[] objArr51 = {Long.valueOf((((long) (-771246479)) << 32) ^ ((long) (i61 ^ i62))), Long.valueOf(-771246543)};
            byte[] bArr9 = $$d;
            Object[] objArr52 = new Object[1];
            c((byte) (bArr9[73] - 1), (short) 344, bArr9[15], objArr52);
            Class<?> cls6 = Class.forName((String) objArr52[0]);
            byte b17 = bArr9[18];
            Object[] objArr53 = new Object[1];
            c(b17, (short) (b17 | 509), (byte) 79, objArr53);
            cls6.getMethod((String) objArr53[0], Long.TYPE, Long.TYPE).invoke(null, objArr51);
            Object[] objArr54 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i71 = ((int[]) objArr3[2])[0];
            int i72 = ((int[]) objArr3[3])[0];
            int i73 = ((int[]) objArr3[0])[0];
            String[] strArr8 = (String[]) objArr3[1];
            int iIdentityHashCode6 = System.identityHashCode(this);
            int i74 = ~iIdentityHashCode6;
            int i75 = i71 + (-1307956939) + (((~((-904188071) | i74)) | 895516804) * SyslogConstants.LOG_LOCAL7) + ((iIdentityHashCode6 | (-1073209063)) * (-184)) + ((~((-1064537797) | i74)) * SyslogConstants.LOG_LOCAL7);
            int i76 = (i75 << 13) ^ i75;
            int i77 = i76 ^ (i76 >>> 17);
            ((int[]) objArr54[2])[0] = i77 ^ (i77 << 5);
        }
        Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame18 == null) {
            int iCombineMeasuredStates = 17 - View.combineMeasuredStates(0, 0);
            char cLastIndexOf = (char) ((-1) - TextUtils.lastIndexOf("", '0', 0));
            int pressedStateDuration = (ViewConfiguration.getPressedStateDuration() >> 16) + 747;
            byte b18 = $$a[41];
            Object[] objArr55 = new Object[1];
            b(b18, (byte) 76, (byte) (b18 - 1), objArr55);
            objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates, cLastIndexOf, pressedStateDuration, -144068856, false, (String) objArr55[0], null);
        }
        long j6 = ((Field) objAccessartificialFrame18).getLong(null);
        if (j6 == -1 || j6 + 1970 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr56 = new Object[1];
            a((char) Color.blue(0), TextUtils.lastIndexOf("", '0', 0, 0) + 70, 26 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), objArr56);
            Class<?> cls7 = Class.forName((String) objArr56[0]);
            Object[] objArr57 = new Object[1];
            a((char) (58349 - TextUtils.lastIndexOf("", '0', 0)), (KeyEvent.getMaxKeyCode() >> 16) + 95, 18 - (Process.myPid() >> 22), objArr57);
            Context applicationContext2 = (Context) cls7.getMethod((String) objArr57[0], new Class[0]).invoke(null, null);
            if (applicationContext2 != null) {
                applicationContext2 = ((applicationContext2 instanceof ContextWrapper) && ((ContextWrapper) applicationContext2).getBaseContext() == null) ? null : applicationContext2.getApplicationContext();
            }
            Object[] objArr58 = {applicationContext2, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 476452734};
            byte[] bArr10 = $$d;
            Object[] objArr59 = new Object[1];
            c((byte) (bArr10[73] - 1), (short) 279, (byte) (-bArr10[40]), objArr59);
            Class<?> cls8 = Class.forName((String) objArr59[0]);
            Object[] objArr60 = new Object[1];
            c((byte) (-bArr10[40]), (short) 229, bArr10[534], objArr60);
            objArr4 = (Object[]) cls8.getMethod((String) objArr60[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr58);
            Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame19 == null) {
                int iNormalizeMetaState = 17 - KeyEvent.normalizeMetaState(0);
                char scrollBarSize2 = (char) (ViewConfiguration.getScrollBarSize() >> 8);
                int i78 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 746;
                byte b19 = $$a[41];
                Object[] objArr61 = new Object[1];
                b(b19, (byte) 68, (byte) (b19 - 1), objArr61);
                objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState, scrollBarSize2, i78, -1031537386, false, (String) objArr61[0], null);
            }
            ((Field) objAccessartificialFrame19).set(null, objArr4);
            try {
                Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame20 == null) {
                    int iIndexOf4 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 18;
                    char cArgb = (char) Color.argb(0, 0, 0, 0);
                    int iIndexOf5 = 747 - TextUtils.indexOf("", "", 0, 0);
                    byte b20 = $$a[41];
                    Object[] objArr62 = new Object[1];
                    b(b20, (byte) 76, (byte) (b20 - 1), objArr62);
                    objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(iIndexOf4, cArgb, iIndexOf5, -144068856, false, (String) objArr62[0], null);
                }
                ((Field) objAccessartificialFrame20).set(null, lValueOf4);
            } catch (Exception unused4) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame21 == null) {
                int iIndexOf6 = 17 - TextUtils.indexOf("", "", 0);
                char edgeSlop = (char) (ViewConfiguration.getEdgeSlop() >> 16);
                int fadingEdgeLength2 = 747 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                byte b21 = $$a[41];
                Object[] objArr63 = new Object[1];
                b(b21, (byte) 68, (byte) (b21 - 1), objArr63);
                objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(iIndexOf6, edgeSlop, fadingEdgeLength2, -1031537386, false, (String) objArr63[0], null);
            }
            Object[] objArr64 = (Object[]) ((Field) objAccessartificialFrame21).get(null);
            objArr4 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
            int i79 = ((int[]) objArr64[3])[0];
            int i80 = ((int[]) objArr64[4])[0];
            List list = (List) objArr64[0];
            List list2 = (List) objArr64[2];
            int iIdentityHashCode7 = System.identityHashCode(this);
            int i81 = (-607165333) + (((~((-302181001) | iIdentityHashCode7)) | 302006912) * (-140)) + ((~((-174089) | iIdentityHashCode7)) * 70) + (((~(iIdentityHashCode7 | 907629458)) | (-605796635)) * 70) + 476452734;
            int i82 = (i81 << 13) ^ i81;
            int i83 = i82 ^ (i82 >>> 17);
            ((int[]) objArr4[1])[0] = i83 ^ (i83 << 5);
        }
        int i84 = ((int[]) objArr4[4])[0];
        int i85 = ((int[]) objArr4[3])[0];
        if (i85 == i84) {
            Object[] objArr65 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i86 = ((int[]) objArr4[1])[0];
            int i87 = ((int[]) objArr4[3])[0];
            int i88 = ((int[]) objArr4[4])[0];
            List list3 = (List) objArr4[0];
            List list4 = (List) objArr4[2];
            int i89 = ~System.identityHashCode(this);
            int i90 = ~(801832166 | i89);
            int i91 = i86 + (-1548503415) + ((i90 | (-196383709)) * 764) + (((~(i89 | (-196383709))) | 192975044) * (-1528)) + (((-612265787) | i90) * 764);
            int i92 = (i91 << 13) ^ i91;
            int i93 = i92 ^ (i92 >>> 17);
            ((int[]) objArr65[1])[0] = i93 ^ (i93 << 5);
        } else {
            ArrayList arrayList3 = new ArrayList();
            Object[] objArr66 = {objArr4};
            Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(1804664566);
            if (objAccessartificialFrame22 == null) {
                objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(41 - View.resolveSize(0, 0), (char) (12468 - KeyEvent.normalizeMetaState(0)), 3642 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), -185222914, false, "coroutineCreation", new Class[]{Object[].class});
            }
            arrayList3.add(((Method) objAccessartificialFrame22).invoke(null, objArr66));
            Object[] objArr67 = {objArr4};
            Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(-1243809191);
            if (objAccessartificialFrame23 == null) {
                objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(42 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) (12468 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 3641, 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
            }
            arrayList3.add(((Method) objAccessartificialFrame23).invoke(null, objArr67));
            Object[] objArr68 = {Long.valueOf((((long) 761448390) << 32) ^ ((long) (i84 ^ i85))), Long.valueOf(761448398)};
            byte[] bArr11 = $$d;
            Object[] objArr69 = new Object[1];
            c((byte) (bArr11[73] - 1), (short) 210, bArr11[23], objArr69);
            Class<?> cls9 = Class.forName((String) objArr69[0]);
            byte b22 = bArr11[18];
            Object[] objArr70 = new Object[1];
            c(b22, (short) (b22 | 509), (byte) 79, objArr70);
            cls9.getMethod((String) objArr70[0], Long.TYPE, Long.TYPE).invoke(null, objArr68);
            Object[] objArr71 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i94 = ((int[]) objArr4[1])[0];
            int i95 = ((int[]) objArr4[3])[0];
            int i96 = ((int[]) objArr4[4])[0];
            List list5 = (List) objArr4[0];
            List list6 = (List) objArr4[2];
            int elapsedCpuTime2 = (int) Process.getElapsedCpuTime();
            int i97 = ~elapsedCpuTime2;
            int i98 = (~((-47578894) | i97)) | 43357697 | (~(557869564 | i97));
            int i99 = i94 + 181663287 + (((~(elapsedCpuTime2 | (-553648369))) | i98) * 590) + (i98 * (-1180)) + (((~((-557869565) | i97)) | (~(i97 | 47578893))) * 590);
            int i100 = (i99 << 13) ^ i99;
            int i101 = i100 ^ (i100 >>> 17);
            ((int[]) objArr71[1])[0] = i101 ^ (i101 << 5);
        }
        Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame24 == null) {
            int iMyTid = (Process.myTid() >> 22) + 30;
            char cAlpha = (char) (Color.alpha(0) + 49362);
            int iArgb = 684 - Color.argb(0, 0, 0, 0);
            byte[] bArr12 = $$a;
            Object[] objArr72 = new Object[1];
            b(bArr12[113], bArr12[100], bArr12[72], objArr72);
            objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(iMyTid, cAlpha, iArgb, 752929587, false, (String) objArr72[0], null);
        }
        long j7 = ((Field) objAccessartificialFrame24).getLong(null);
        if (j7 == -1 || j7 + 2022 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr73 = new Object[1];
            a((char) TextUtils.indexOf("", "", 0, 0), 70 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), Color.red(0) + 26, objArr73);
            Class<?> cls10 = Class.forName((String) objArr73[0]);
            Object[] objArr74 = new Object[1];
            a((char) (58350 - View.resolveSize(0, 0)), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 95, 18 - TextUtils.indexOf("", "", 0), objArr74);
            Context applicationContext3 = (Context) cls10.getMethod((String) objArr74[0], new Class[0]).invoke(null, null);
            if (applicationContext3 != null) {
                applicationContext3 = ((applicationContext3 instanceof ContextWrapper) && ((ContextWrapper) applicationContext3).getBaseContext() == null) ? null : applicationContext3.getApplicationContext();
            }
            int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            int i102 = getARTIFICIAL_FRAME_PACKAGE_NAME + 19;
            artificialFrame = i102 % 128;
            int i103 = i102 % 2;
            Object[] objArr75 = {applicationContext3, Integer.valueOf(iIntValue2), 0, -602682777};
            byte[] bArr13 = $$d;
            Object[] objArr76 = new Object[1];
            c((byte) (bArr13[73] - 1), (short) 138, bArr13[131], objArr76);
            Class<?> cls11 = Class.forName((String) objArr76[0]);
            Object[] objArr77 = new Object[1];
            c((byte) (-bArr13[40]), (short) 229, bArr13[534], objArr77);
            objArr5 = (Object[]) cls11.getMethod((String) objArr77[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr75);
            if (applicationContext3 != null) {
                Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-326560385);
                if (objAccessartificialFrame25 == null) {
                    int iGreen2 = Color.green(0) + 30;
                    char cArgb2 = (char) (49362 - Color.argb(0, 0, 0, 0));
                    int gidForName2 = 683 - Process.getGidForName("");
                    byte[] bArr14 = $$a;
                    Object[] objArr78 = new Object[1];
                    b(bArr14[113], (byte) (-bArr14[53]), bArr14[73], objArr78);
                    objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(iGreen2, cArgb2, gidForName2, 1944867703, false, (String) objArr78[0], null);
                }
                ((Field) objAccessartificialFrame25).set(null, objArr5);
                try {
                    Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                    if (objAccessartificialFrame26 == null) {
                        int i104 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 29;
                        char touchSlop3 = (char) ((ViewConfiguration.getTouchSlop() >> 8) + 49362);
                        int longPressTimeout = (ViewConfiguration.getLongPressTimeout() >> 16) + 684;
                        byte[] bArr15 = $$a;
                        Object[] objArr79 = new Object[1];
                        b(bArr15[113], bArr15[100], bArr15[72], objArr79);
                        objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(i104, touchSlop3, longPressTimeout, 752929587, false, (String) objArr79[0], null);
                    }
                    ((Field) objAccessartificialFrame26).set(null, lValueOf5);
                } catch (Exception unused5) {
                    throw new RuntimeException();
                }
            }
        } else {
            int i105 = getARTIFICIAL_FRAME_PACKAGE_NAME + 121;
            artificialFrame = i105 % 128;
            int i106 = i105 % 2;
            Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(-326560385);
            if (objAccessartificialFrame27 == null) {
                int i107 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 31;
                char fadingEdgeLength3 = (char) (49362 - (ViewConfiguration.getFadingEdgeLength() >> 16));
                int i108 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 684;
                byte[] bArr16 = $$a;
                Object[] objArr80 = new Object[1];
                b(bArr16[113], (byte) (-bArr16[53]), bArr16[73], objArr80);
                objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(i107, fadingEdgeLength3, i108, 1944867703, false, (String) objArr80[0], null);
            }
            Object[] objArr81 = (Object[]) ((Field) objAccessartificialFrame27).get(null);
            objArr5 = new Object[]{new int[]{((int[]) objArr81[0])[0]}, new int[]{((int[]) objArr81[1])[0]}, new int[1], (String) objArr81[3]};
            int iIdentityHashCode8 = System.identityHashCode(this);
            int i109 = ((((-1866765146) + (((~(iIdentityHashCode8 | 1018809236)) | 40185461) * (-668))) + ((1018809236 | (~(40185461 | iIdentityHashCode8))) * 1336)) + ((iIdentityHashCode8 | 1056829429) * 668)) - 602682777;
            int i110 = (i109 << 13) ^ i109;
            int i111 = i110 ^ (i110 >>> 17);
            ((int[]) objArr5[2])[0] = i111 ^ (i111 << 5);
        }
        int i112 = ((int[]) objArr5[1])[0];
        int i113 = ((int[]) objArr5[0])[0];
        if (i113 == i112) {
            int i114 = ((int[]) objArr5[2])[0];
            Object[] objArr82 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
            int i115 = i114 + (-2014000914) + (((~((-144650246) | iFreeMemory)) | 9773057) * 104) + ((~((~iFreeMemory) | 968850717)) * (-104)) + ((iFreeMemory | 833973529) * 104);
            int i116 = (i115 << 13) ^ i115;
            int i117 = i116 ^ (i116 >>> 17);
            ((int[]) objArr82[2])[0] = i117 ^ (i117 << 5);
        } else {
            Object[] objArr83 = {Long.valueOf((((long) 1172432474) << 32) ^ ((long) (i112 ^ i113))), Long.valueOf(1172432478)};
            byte[] bArr17 = $$d;
            Object[] objArr84 = new Object[1];
            c((byte) (bArr17[73] - 1), (short) 93, bArr17[2], objArr84);
            Class<?> cls12 = Class.forName((String) objArr84[0]);
            byte b23 = bArr17[18];
            Object[] objArr85 = new Object[1];
            c(b23, (short) (b23 | 509), (byte) 79, objArr85);
            cls12.getMethod((String) objArr85[0], Long.TYPE, Long.TYPE).invoke(null, objArr83);
            int i118 = ((int[]) objArr5[2])[0];
            Object[] objArr86 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int iIdentityHashCode9 = System.identityHashCode(this);
            int i119 = 1734527634 + ((iIdentityHashCode9 | 67374196) * (-50));
            int i120 = ~((-67108897) | iIdentityHashCode9);
            int i121 = ~iIdentityHashCode9;
            int i122 = i118 + i119 + ((i120 | (~((-844140683) | i121))) * 50) + (((~(i121 | 67374196)) | (~((-911249579) | i121)) | 844140682) * 50);
            int i123 = (i122 << 13) ^ i122;
            int i124 = i123 ^ (i123 >>> 17);
            ((int[]) objArr86[2])[0] = i124 ^ (i124 << 5);
        }
        Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame28 == null) {
            int iArgb2 = Color.argb(0, 0, 0, 0) + 30;
            char packedPositionGroup = (char) (49362 - ExpandableListView.getPackedPositionGroup(0L));
            int capsMode3 = 684 - TextUtils.getCapsMode("", 0, 0);
            byte[] bArr18 = $$a;
            Object[] objArr87 = new Object[1];
            b(bArr18[14], bArr18[12], bArr18[72], objArr87);
            objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(iArgb2, packedPositionGroup, capsMode3, 508509282, false, (String) objArr87[0], null);
        }
        long j8 = ((Field) objAccessartificialFrame28).getLong(null);
        if (j8 == -1 || j8 + 1963 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr88 = new Object[1];
            a((char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), 70 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), ExpandableListView.getPackedPositionType(0L) + 26, objArr88);
            Class<?> cls13 = Class.forName((String) objArr88[0]);
            Object[] objArr89 = new Object[1];
            a((char) ((ViewConfiguration.getTapTimeout() >> 16) + 58350), 95 - Drawable.resolveOpacity(0, 0), 18 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), objArr89);
            Context applicationContext4 = (Context) cls13.getMethod((String) objArr89[0], new Class[0]).invoke(null, null);
            if (applicationContext4 != null) {
                int i125 = getARTIFICIAL_FRAME_PACKAGE_NAME + 81;
                artificialFrame = i125 % 128;
                int i126 = i125 % 2;
                applicationContext4 = ((applicationContext4 instanceof ContextWrapper) && ((ContextWrapper) applicationContext4).getBaseContext() == null) ? null : applicationContext4.getApplicationContext();
            }
            int iIntValue3 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            int i127 = getARTIFICIAL_FRAME_PACKAGE_NAME + b.i;
            artificialFrame = i127 % 128;
            int i128 = i127 % 2;
            Object[] objArr90 = {applicationContext4, Integer.valueOf(iIntValue3), 442724384};
            byte[] bArr19 = $$d;
            Object[] objArr91 = new Object[1];
            c((byte) (bArr19[73] - 1), bArr19[305], bArr19[44], objArr91);
            Class<?> cls14 = Class.forName((String) objArr91[0]);
            byte b24 = bArr19[171];
            Object[] objArr92 = new Object[1];
            c((byte) (-b24), (short) 364, (byte) (-b24), objArr92);
            objArr6 = (Object[]) cls14.getMethod((String) objArr92[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr90);
            if (applicationContext4 != null) {
                Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame29 == null) {
                    int windowTouchSlop3 = (ViewConfiguration.getWindowTouchSlop() >> 8) + 30;
                    char maximumFlingVelocity = (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 49362);
                    int touchSlop4 = (ViewConfiguration.getTouchSlop() >> 8) + 684;
                    byte[] bArr20 = $$a;
                    Object[] objArr93 = new Object[1];
                    b((byte) (bArr20[41] - 1), (byte) (-bArr20[15]), bArr20[113], objArr93);
                    objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(windowTouchSlop3, maximumFlingVelocity, touchSlop4, -1321816393, false, (String) objArr93[0], null);
                }
                ((Field) objAccessartificialFrame29).set(null, objArr6);
                try {
                    Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                    if (objAccessartificialFrame30 == null) {
                        int iMyTid2 = (Process.myTid() >> 22) + 30;
                        char longPressTimeout2 = (char) ((ViewConfiguration.getLongPressTimeout() >> 16) + 49362);
                        int pressedStateDuration2 = 684 - (ViewConfiguration.getPressedStateDuration() >> 16);
                        byte[] bArr21 = $$a;
                        Object[] objArr94 = new Object[1];
                        b(bArr21[14], bArr21[12], bArr21[72], objArr94);
                        objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(iMyTid2, longPressTimeout2, pressedStateDuration2, 508509282, false, (String) objArr94[0], null);
                    }
                    ((Field) objAccessartificialFrame30).set(null, lValueOf6);
                } catch (Exception unused6) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(777251007);
            if (objAccessartificialFrame31 == null) {
                int iAlpha2 = Color.alpha(0) + 30;
                char c4 = (char) (49363 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                int tapTimeout = 684 - (ViewConfiguration.getTapTimeout() >> 16);
                byte[] bArr22 = $$a;
                Object[] objArr95 = new Object[1];
                b((byte) (bArr22[41] - 1), (byte) (-bArr22[15]), bArr22[113], objArr95);
                objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(iAlpha2, c4, tapTimeout, -1321816393, false, (String) objArr95[0], null);
            }
            Object[] objArr96 = (Object[]) ((Field) objAccessartificialFrame31).get(null);
            objArr6 = new Object[]{new int[]{((int[]) objArr96[0])[0]}, new int[]{((int[]) objArr96[1])[0]}, new int[1], (String) objArr96[3]};
            int iIdentityHashCode10 = System.identityHashCode(this);
            int i129 = 1186371578 + (((~(iIdentityHashCode10 | 988520305)) | 9896530) * (-668)) + ((988520305 | (~(9896530 | iIdentityHashCode10))) * 1336) + ((iIdentityHashCode10 | 989831027) * 668) + 442724384;
            int i130 = (i129 << 13) ^ i129;
            int i131 = i130 ^ (i130 >>> 17);
            ((int[]) objArr6[2])[0] = i131 ^ (i131 << 5);
        }
        int i132 = ((int[]) objArr6[1])[0];
        int i133 = ((int[]) objArr6[0])[0];
        if (i133 == i132) {
            int i134 = ((int[]) objArr6[2])[0];
            Object[] objArr97 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
            int iIdentityHashCode11 = System.identityHashCode(this);
            int i135 = ~iIdentityHashCode11;
            int i136 = i134 + (-1300119514) + ((iIdentityHashCode11 | 948044368) * 988) + (((~(954412912 | i135)) | 17842318) * (-1976)) + (((~(iIdentityHashCode11 | (-24210863))) | 948044368 | (~(24210862 | i135))) * 988);
            int i137 = (i136 << 13) ^ i136;
            int i138 = i137 ^ (i137 >>> 17);
            ((int[]) objArr97[2])[0] = i138 ^ (i138 << 5);
        } else {
            Object[] objArr98 = {Long.valueOf((((long) (-1890021509)) << 32) ^ ((long) (i132 ^ i133))), Long.valueOf(-1890022021)};
            byte[] bArr23 = $$d;
            Object[] objArr99 = new Object[1];
            c((byte) (bArr23[73] - 1), (short) 93, bArr23[2], objArr99);
            Class<?> cls15 = Class.forName((String) objArr99[0]);
            byte b25 = bArr23[18];
            Object[] objArr100 = new Object[1];
            c(b25, (short) (b25 | 509), (byte) 79, objArr100);
            cls15.getMethod((String) objArr100[0], Long.TYPE, Long.TYPE).invoke(null, objArr98);
            int i139 = ((int[]) objArr6[2])[0];
            Object[] objArr101 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
            int iNextInt2 = new Random().nextInt(814998199);
            int i140 = i139 + ((~((-264385) | iNextInt2)) * 521) + 64348514 + (((~((~iNextInt2) | (-264385))) | (-987753444)) * 521);
            int i141 = (i140 << 13) ^ i140;
            int i142 = i141 ^ (i141 >>> 17);
            ((int[]) objArr101[2])[0] = i142 ^ (i142 << 5);
        }
        Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame32 == null) {
            int size = View.MeasureSpec.getSize(0) + 36;
            char cRgb = (char) (ViewCompat.MEASURED_STATE_MASK - Color.rgb(0, 0, 0));
            int touchSlop5 = 540 - (ViewConfiguration.getTouchSlop() >> 8);
            byte b26 = $$a[41];
            Object[] objArr102 = new Object[1];
            b(b26, (byte) 76, (byte) (b26 - 1), objArr102);
            objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(size, cRgb, touchSlop5, 624296913, false, (String) objArr102[0], null);
        }
        long j9 = ((Field) objAccessartificialFrame32).getLong(null);
        if (j9 != -1) {
            int i143 = artificialFrame + 37;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i143 % 128;
            int i144 = i143 % 2;
            if (j9 + 1927 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                if (objAccessartificialFrame33 == null) {
                    int i145 = 37 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                    char c5 = (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
                    int mode = View.MeasureSpec.getMode(0) + 540;
                    byte b27 = $$a[41];
                    Object[] objArr103 = new Object[1];
                    b(b27, (byte) 68, (byte) (b27 - 1), objArr103);
                    objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(i145, c5, mode, 793268735, false, (String) objArr103[0], null);
                }
                Object[] objArr104 = (Object[]) ((Field) objAccessartificialFrame33).get(null);
                objArr7 = new Object[]{new int[1], new int[1], new int[1]};
                int i146 = ((int[]) objArr104[2])[0];
                int i147 = ((int[]) objArr104[1])[0];
                ((int[]) objArr7[2])[0] = i146;
                ((int[]) objArr7[1])[0] = i147;
                int iIdentityHashCode12 = System.identityHashCode(this);
                int i148 = (((((~((-28460354) | iIdentityHashCode12)) | 19005505) * (-283)) - 1859754928) + ((~(iIdentityHashCode12 | (-9454849))) * 283)) - 924265966;
                int i149 = (i148 << 13) ^ i148;
                int i150 = i149 ^ (i149 >>> 17);
                ((int[]) objArr7[0])[0] = i150 ^ (i150 << 5);
            } else {
                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1717965552);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(20 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), (char) (39517 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), 981 - ((byte) KeyEvent.getModifierMetaStateMask()), 117222168, false, null, new Class[0]);
                }
                Object[] objArr105 = {null, ((Constructor) objAccessartificialFrame).newInstance(null), -924265966, 0};
                objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-501205803);
                if (objAccessartificialFrame2 == null) {
                    int i151 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 36;
                    char deadChar = (char) KeyEvent.getDeadChar(0, 0);
                    int iIndexOf7 = 540 - TextUtils.indexOf("", "");
                    byte[] bArr24 = $$a;
                    byte b28 = bArr24[19];
                    byte b29 = (byte) (bArr24[41] - 1);
                    Object[] objArr106 = new Object[1];
                    b(b28, b29, (byte) (b29 | 47), objArr106);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i151, deadChar, iIndexOf7, 2101703389, false, (String) objArr106[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(54 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) ((ViewConfiguration.getTouchSlop() >> 8) + 833), TextUtils.getOffsetAfter("", 0) + 576), (Class) ArtificialStackFrames.coroutineCreation(54 - View.resolveSize(0, 0), (char) (MotionEvent.axisFromString("") + 1), 630 - (ViewConfiguration.getLongPressTimeout() >> 16)), Integer.TYPE, Integer.TYPE});
                }
                objArr7 = (Object[]) ((Method) objAccessartificialFrame2).invoke(null, objArr105);
                objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                if (objAccessartificialFrame3 == null) {
                    int iCombineMeasuredStates2 = 36 - View.combineMeasuredStates(0, 0);
                    char cMyPid = (char) (Process.myPid() >> 22);
                    int i152 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 540;
                    byte b30 = $$a[41];
                    Object[] objArr107 = new Object[1];
                    b(b30, (byte) 68, (byte) (b30 - 1), objArr107);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates2, cMyPid, i152, 793268735, false, (String) objArr107[0], null);
                }
                ((Field) objAccessartificialFrame3).set(null, objArr7);
                try {
                    Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                    if (objAccessartificialFrame4 == null) {
                        int iIndexOf8 = TextUtils.indexOf((CharSequence) "", '0') + 37;
                        char packedPositionGroup2 = (char) ExpandableListView.getPackedPositionGroup(0L);
                        int i153 = 541 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                        byte b31 = $$a[41];
                        Object[] objArr108 = new Object[1];
                        b(b31, (byte) 76, (byte) (b31 - 1), objArr108);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iIndexOf8, packedPositionGroup2, i153, 624296913, false, (String) objArr108[0], null);
                    }
                    ((Field) objAccessartificialFrame4).set(null, lValueOf7);
                } catch (Exception unused7) {
                    throw new RuntimeException();
                }
            }
        } else {
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1717965552);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(20 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), (char) (39517 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), 981 - ((byte) KeyEvent.getModifierMetaStateMask()), 117222168, false, null, new Class[0]);
            }
            Object[] objArr109 = {null, ((Constructor) objAccessartificialFrame).newInstance(null), -924265966, 0};
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-501205803);
            if (objAccessartificialFrame2 == null) {
                int i154 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 36;
                char deadChar2 = (char) KeyEvent.getDeadChar(0, 0);
                int iIndexOf9 = 540 - TextUtils.indexOf("", "");
                byte[] bArr25 = $$a;
                byte b210 = bArr25[19];
                byte b211 = (byte) (bArr25[41] - 1);
                Object[] objArr1010 = new Object[1];
                b(b210, b211, (byte) (b211 | 47), objArr1010);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i154, deadChar2, iIndexOf9, 2101703389, false, (String) objArr1010[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(54 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) ((ViewConfiguration.getTouchSlop() >> 8) + 833), TextUtils.getOffsetAfter("", 0) + 576), (Class) ArtificialStackFrames.coroutineCreation(54 - View.resolveSize(0, 0), (char) (MotionEvent.axisFromString("") + 1), 630 - (ViewConfiguration.getLongPressTimeout() >> 16)), Integer.TYPE, Integer.TYPE});
            }
            objArr7 = (Object[]) ((Method) objAccessartificialFrame2).invoke(null, objArr109);
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame3 == null) {
                int iCombineMeasuredStates3 = 36 - View.combineMeasuredStates(0, 0);
                char cMyPid2 = (char) (Process.myPid() >> 22);
                int i155 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 540;
                byte b32 = $$a[41];
                Object[] objArr1011 = new Object[1];
                b(b32, (byte) 68, (byte) (b32 - 1), objArr1011);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates3, cMyPid2, i155, 793268735, false, (String) objArr1011[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, objArr7);
            Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1168947751);
            if (objAccessartificialFrame4 == null) {
                int iIndexOf10 = TextUtils.indexOf((CharSequence) "", '0') + 37;
                char packedPositionGroup3 = (char) ExpandableListView.getPackedPositionGroup(0L);
                int i156 = 541 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                byte b33 = $$a[41];
                Object[] objArr1012 = new Object[1];
                b(b33, (byte) 76, (byte) (b33 - 1), objArr1012);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iIndexOf10, packedPositionGroup3, i156, 624296913, false, (String) objArr1012[0], null);
            }
            ((Field) objAccessartificialFrame4).set(null, lValueOf8);
        }
        Object obj = objArr7[1];
        int i157 = ((int[]) obj)[0];
        Object obj2 = objArr7[2];
        int i158 = ((int[]) obj2)[0];
        if (i158 == i157) {
            Object[] objArr110 = {new int[1], new int[1], new int[1]};
            int i159 = ((int[]) objArr7[0])[0];
            int i160 = ((int[]) obj2)[0];
            int i161 = ((int[]) obj)[0];
            ((int[]) objArr110[2])[0] = i160;
            ((int[]) objArr110[1])[0] = i161;
            int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
            int i162 = 627488692 + (((~((~startElapsedRealtime) | (-560384941))) | 4623140) * (-245));
            int i163 = ~(startElapsedRealtime | (-560384941));
            int i164 = i159 + i162 + (i163 * (-245)) + ((i163 | 791236809) * 245);
            int i165 = (i164 << 13) ^ i164;
            int i166 = i165 ^ (i165 >>> 17);
            ((int[]) objArr110[0])[0] = i166 ^ (i166 << 5);
        } else {
            Object[] objArr111 = {Long.valueOf((((long) 1008488631) << 32) ^ ((long) (i157 ^ i158))), Long.valueOf(1008484535)};
            byte[] bArr26 = $$d;
            Object[] objArr112 = new Object[1];
            c((byte) (bArr26[73] - 1), (short) 533, bArr26[605], objArr112);
            Class<?> cls16 = Class.forName((String) objArr112[0]);
            byte b34 = bArr26[18];
            Object[] objArr113 = new Object[1];
            c(b34, (short) (b34 | 509), (byte) 79, objArr113);
            cls16.getMethod((String) objArr113[0], Long.TYPE, Long.TYPE).invoke(null, objArr111);
            Object[] objArr114 = {new int[1], new int[1], new int[1]};
            int i167 = ((int[]) objArr7[0])[0];
            int i168 = ((int[]) objArr7[2])[0];
            int i169 = ((int[]) objArr7[1])[0];
            ((int[]) objArr114[2])[0] = i168;
            ((int[]) objArr114[1])[0] = i169;
            int iUptimeMillis = (int) SystemClock.uptimeMillis();
            int i170 = ~iUptimeMillis;
            int i171 = i167 + 2014410297 + (((~((-1213269366) | i170)) | (-138352385) | (~(1213269365 | iUptimeMillis))) * (-564)) + ((~(iUptimeMillis | (-3019265))) * 1128) + (((~((-138352385) | i170)) | (-1216288630)) * 564);
            int i172 = (i171 << 13) ^ i171;
            int i173 = i172 ^ (i172 >>> 17);
            ((int[]) objArr114[0])[0] = i173 ^ (i173 << 5);
        }
        Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame34 == null) {
            int mirror = AndroidCharacter.getMirror('0') - 22;
            char defaultSize = (char) View.getDefaultSize(0, 0);
            int i174 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 1040;
            byte b35 = $$a[41];
            Object[] objArr115 = new Object[1];
            b(b35, (byte) 76, (byte) (b35 - 1), objArr115);
            objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(mirror, defaultSize, i174, 2061780482, false, (String) objArr115[0], null);
        }
        long j10 = ((Field) objAccessartificialFrame34).getLong(null);
        if (j10 == -1 || j10 + 1906 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            int iIntValue4 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr116 = {276066335};
            Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame35 == null) {
                objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(8 - KeyEvent.keyCodeFromString(""), (char) (22251 - (ViewConfiguration.getKeyRepeatDelay() >> 16)), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 1032, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            Object[] objArrAccessartificialFrame$78cbbd35 = ExceptionsCollector$$ExternalSyntheticApiModelOutline6.accessartificialFrame$78cbbd35(iIntValue4, 0, ((Constructor) objAccessartificialFrame35).newInstance(objArr116), -2086015522, false);
            Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame36 == null) {
                int longPressTimeout3 = 26 - (ViewConfiguration.getLongPressTimeout() >> 16);
                char minimumFlingVelocity = (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                int maxKeyCode = (KeyEvent.getMaxKeyCode() >> 16) + 1041;
                byte b36 = $$a[41];
                Object[] objArr117 = new Object[1];
                b(b36, (byte) 68, (byte) (b36 - 1), objArr117);
                objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(longPressTimeout3, minimumFlingVelocity, maxKeyCode, 1145017376, false, (String) objArr117[0], null);
            }
            ((Field) objAccessartificialFrame36).set(null, objArrAccessartificialFrame$78cbbd35);
            try {
                Long lValueOf9 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame37 == null) {
                    int iLastIndexOf = TextUtils.lastIndexOf("", '0', 0) + 27;
                    char mode2 = (char) View.MeasureSpec.getMode(0);
                    int keyRepeatTimeout = 1041 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                    byte b37 = $$a[41];
                    Object[] objArr118 = new Object[1];
                    b(b37, (byte) 76, (byte) (b37 - 1), objArr118);
                    objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, mode2, keyRepeatTimeout, 2061780482, false, (String) objArr118[0], null);
                }
                ((Field) objAccessartificialFrame37).set(null, lValueOf9);
                objArr8 = objArrAccessartificialFrame$78cbbd35;
            } catch (Exception unused8) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame38 == null) {
                int i175 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 26;
                char cKeyCodeFromString = (char) KeyEvent.keyCodeFromString("");
                int defaultSize2 = View.getDefaultSize(0, 0) + 1041;
                byte b38 = $$a[41];
                Object[] objArr119 = new Object[1];
                b(b38, (byte) 68, (byte) (b38 - 1), objArr119);
                objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(i175, cKeyCodeFromString, defaultSize2, 1145017376, false, (String) objArr119[0], null);
            }
            Object[] objArr120 = (Object[]) ((Field) objAccessartificialFrame38).get(null);
            objArr8 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
            int i176 = ((int[]) objArr120[3])[0];
            int i177 = ((int[]) objArr120[2])[0];
            String[] strArr9 = (String[]) objArr120[0];
            int iFreeMemory2 = (int) Runtime.getRuntime().freeMemory();
            int i178 = (((-1287218886) + (((~((-103302402) | (~iFreeMemory2))) | 25198594) * (-591))) + ((iFreeMemory2 | (-103302402)) * 591)) - 2086015522;
            int i179 = (i178 << 13) ^ i178;
            int i180 = i179 ^ (i179 >>> 17);
            ((int[]) objArr8[1])[0] = i180 ^ (i180 << 5);
        }
        int i181 = ((int[]) objArr8[2])[0];
        int i182 = ((int[]) objArr8[3])[0];
        if (i182 == i181) {
            Object[] objArr121 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i183 = ((int[]) objArr8[1])[0];
            int i184 = ((int[]) objArr8[3])[0];
            int i185 = ((int[]) objArr8[2])[0];
            String[] strArr10 = (String[]) objArr8[0];
            int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
            int i186 = ~iElapsedRealtime;
            int i187 = i183 + 674890651 + (((~((-147850754) | i186)) | (~((-587344097) | iElapsedRealtime)) | (~(804941795 | iElapsedRealtime))) * 765) + (((~((-735194850) | i186)) | 147850753) * 1530) + (((~(iElapsedRealtime | (-735194850))) | (~(i186 | 804941795))) * 765);
            int i188 = (i187 << 13) ^ i187;
            int i189 = i188 ^ (i188 >>> 17);
            ((int[]) objArr121[1])[0] = i189 ^ (i189 << 5);
        } else {
            ArrayList arrayList4 = new ArrayList();
            String[] strArr11 = (String[]) objArr8[0];
            if (strArr11 != null) {
                for (String str8 : strArr11) {
                    int i190 = artificialFrame + 91;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i190 % 128;
                    int i191 = i190 % 2;
                    arrayList4.add(str8);
                }
            }
            Object[] objArr122 = {Long.valueOf(((long) (i181 ^ i182)) ^ (((long) (-26408378)) << 32)), Long.valueOf(-26408380)};
            byte[] bArr27 = $$d;
            Object[] objArr123 = new Object[1];
            c((byte) (bArr27[73] - 1), bArr27[18], bArr27[31], objArr123);
            Class<?> cls17 = Class.forName((String) objArr123[0]);
            byte b39 = bArr27[18];
            Object[] objArr124 = new Object[1];
            c(b39, (short) (b39 | 509), (byte) 79, objArr124);
            cls17.getMethod((String) objArr124[0], Long.TYPE, Long.TYPE).invoke(null, objArr122);
            Object[] objArr125 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i192 = ((int[]) objArr8[1])[0];
            int i193 = ((int[]) objArr8[3])[0];
            int i194 = ((int[]) objArr8[2])[0];
            String[] strArr12 = (String[]) objArr8[0];
            int i195 = ~Process.myPid();
            int i196 = i192 + 1195915122 + ((~((-35131465) | i195)) * (-783)) + (((~(i195 | (-104337741))) | (-182441548)) * 783);
            int i197 = (i196 << 13) ^ i196;
            int i198 = i197 ^ (i197 >>> 17);
            ((int[]) objArr125[1])[0] = i198 ^ (i198 << 5);
        }
        return super.onCreate();
    }

    static {
        byte[] bArr = new byte[623];
        System.arraycopy("\u00182/k\u000f\u0001Ä<\u000b\u0003û\büÌ6\u0010ù\u0011\u0000ýþÍ<\t\t¾6\u0017\u0002÷É'\u000f\u0006\u0000\t\u0002ø\búá2öÿ\u0016ø\t\u0002\u000f\u0001Ä<\u000b\u0003û\büÌ6\u0012üÈ&'ý\bðò%\u0000\bþ\u0003@\u000f\u0001Ä<\u000b\u0003û\büÌ6\u0010ù\u0011\u0000ýþÍB÷\u0016ô\u0010úû\u000eÅ8\u000f\u0000\u0006\u0006¿J\u0002ø\u0006\u0000\u000eøÿ\u0011¾\u00198øö\u000fÿýã/\u0000\u0006\u0006µ\u0003$6ÿô\u0010ÿö\u000eê)ø\t÷\u0000\u0012øýì\u0018\u000fø\u0005\u0000Ò\u000f\u0001Ä<\u000b\u0003û\büÌ8\u000f\u0001\u0003\u0005\u0002Ã8\u000f\u0000\u0003ü\u0001\u0014½()øø\b\r\u0000\u0002þ\u0014î\u0002Ã2)øø\b\r\u0000\u0002þ\u0014î\u0002í\u0016\u0018ö\u0001ý\u0004\rüë\u0017\u0012\u0005\u0003\u0005\u0011\u0003ñ\u0014\u0005ø\u0000\u0006ý\tû\u000eÝ/ò\u000fû\u000f\u0001Ä<\u000b\u0003û\büÌ8\u000f\u0001\u0003\u0005\u0002Ã8\u000f\u0000\u0003ü\u0001\u0014½\"\u0017\u0012à\u0017\rý\u0010Ú(\tô\u0010ÿö\u000eä\u0017\u0012· $\u0014\u0004\u0001ò\u0005\u0014æ\u0011ÿ\rã\u001d\u0017Ï,\t\u0001\n\u000f\u0001Ä;þ\u0005\u0005\u0000\u0010\u0003ÿÆ;\u000fö\u0011ó\u000fÂJ÷È8\u000f\u0001\u0003\u0005\u0002Ã\u001e'÷\t\u0001î\u0018\u0010÷á \u0016ðð$\bø\u0000\u0006ÿ\u0010/\u0006\u0000\t\u0002ø\búâ$\u0000\u0016õ\u0003\u0005\büç,\u000f\u0001Ä<\u000b\u0003û\büÌ;\u0006\fö\u0000\u0002\u0015õÌ8\u000f\u0001\u0006\u0002\u0002ú\f\t\u0002¾$$\u0007ø\t\u0002ö\u000eç%\u0000\nöþ\u0004\u0010µ\u0003$6ÿô\u0010ÿö\u000eê)ø\t÷\u0000\u0012øýì\u0018\u000fø\u0005\u0000Ô\u000f\u0001Ä;þ\u0005\u0005\u0000\u0010\u0003ÿÆGöÿ\u0005\u0014½7\u0013úþ\u0006\u0001Ì'\u0016ÿ\u0005\u0014Ò8\u0003Ð0\u0003\u0000\u0006Ù\u001c\u0010ù\u000bü\u0010\u000f\u0001Ä;þ\u0005\u0005\u0000\u0010\u0003ÿÆ6\u0012\u0003ÿ\u0000\b\u0000\u000b¾\u00162\u0003ß \b\u0000Ü \u0016ðÆ\u0010\u000f\u0001Ä;þ\u0005\u0005\u0000\u0010\u0003ÿÆ>\b\tô\u0010ÿö\u000eÅ\u001b&\u0006üê)\u0006Ñ!\u0005\b\u0000Â\u0003$6ÿô\u0010ÿö\u000eê)ø\t÷\u0000\u0012øýì\u0018\u000fø\u0005\u0000Ó\bÉF\u0001\u0007¾A\u0006ûþ\u0002\u0005\u000bÆ8\u000f\u0006öÌH\u0000üÈ\u00189í\f\u0000ýâ6ô\u0003\u0002\u0010å!ò\u0005\u000bý\u0010".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 623);
        $$d = bArr;
        $$e = 163;
        $$a = new byte[]{65, Ascii.SYN, 92, -30, -2, Ascii.SI, -33, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, 10, -31, Ascii.DC4, Ascii.CR, -8, -11, -13, Ascii.ESC, 5, -1, -33, 33, -2, -9, 5, -7, 5, -1, -50, 39, Ascii.VT, -7, -12, Ascii.SI, Ascii.ESC, 1, -7, -6, -33, 51, -12, 3, -8, 1, Ascii.CR, -9, Ascii.DC2, -34, Ascii.EM, 4, -17, 19, -15, -1, -18, Ascii.SI, 19, -11, 5, -7, -2, Ascii.SI, -36, Ascii.NAK, Ascii.CR, -15, 2, 9, 6, -34, Ascii.SI, 19, -11, 5, -7, -9, Ascii.DC2, -36, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, -7, Ascii.DC2, -43, Ascii.GS, -4, 17, 2, 49, 2, -11, -3, 3, -6, 6, -8, Ascii.VT, -25, 33, -19, 2, 8, -37, 44, -17, Ascii.FF, -8, Ascii.SO};
        $$b = 121;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        _CREATION = new char[]{6559, 42324, 24594, 12224, 60033, 46659, 29954, 12428, 65457, 47977, 18040, 1473, 49335, 35961, 19250, 5863, 54739, 37049, 23642, 6941, 42701, 25985, 30403, 51726, 3919, 16538, 34245, 55575, 6746, 24488, 37091, 54307, 10594, 27326, 45055, 58175, 9339, 6548, 42331, 24576, 12243, 60096, 46662, 29959, 12492, 65465, 47924, 17925, 1515, 49341, 35966, 19235, 5871, 56927, 25238, 42971, 59412, 11602, 29067, 45786, 63251, 14430, 31923, 33261, 49714, 1861, 19373, 36074, 53551, 6559, 42324, 24594, 12224, 60033, 46659, 29954, 12428, 65471, 47978, 17958, 1468, 49295, 35945, 19250, 5867, 54728, 37011, 23618, 6923, 42746, 25986, 8532, 60423, 44031, 30398, 64115, 18081, 33770, 52270, 2405, 21930, 38652, 54029, 7232, 22660, 42452, 58901, 9027, 28549, 43228, 62725, 13887, 29562, 17110, 65093, 15119, 29902, 45459, 60673, 11854, 27611, 42227, 57453, 7469, 24253, 39856, 55154, 4144, 19882, 36501, 52176, 1870, 16393, 64981, 16029, 31312, 46922, 61671, 11765, 26987, 43564, 59300, 8380, 23597, 39274, 55894, 6081, 20621, 35864, 51480, 2690, 18321, 33546, 15392, 31159, 47870, 63081, 13112, 27888, 43499, 58748, 9750, 25429, 40089, 55691, 5465, 22032, 37854, 52429, 2144, 17783, 34489, 50169, 32631, 47207, 62892, 14015, 6603, 42253, 24595, 12247, 60043, 46668, 30038, 12438, 65519, 47907, 18019, 1520, 49400, 35897, 19234, 5819, 54669, 37068, 23559, 6935, 42703, 25996, 8467, 60419, 43943, 30446, 12832, 61792, 48362, 31743, 1892, 49776, 33099, 19593, 3012, 55040, 37467, 20939, 7299, 55319, 26471, 8872, 57827, 44320, 26749, 14266, 62193, 48688, 32009, 14409, 51159, 33428, 20044, 3343, 51344, 38868, 21372, 7739, 56750, 39137, 9278, 58155, 44768, 28071};
        _BOUNDARY = -6284841731272956614L;
    }
}
