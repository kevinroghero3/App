package com.google.android.datatransport.runtime.firebase.transport;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imageutils.JfifUtil;
import com.google.android.material.datepicker.SmoothCalendarLayoutManager;
import com.google.firebase.encoders.annotations.Encodable;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;
import o.onMessageChannelReady;
import o.onPostMessage;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes2.dex */
public final class GlobalMetrics {
    private static final GlobalMetrics DEFAULT_INSTANCE = new Builder().build();
    private final StorageMetrics storage_metrics_;

    GlobalMetrics(StorageMetrics storageMetrics) {
        this.storage_metrics_ = storageMetrics;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Encodable.Ignore
    public StorageMetrics getStorageMetrics() {
        StorageMetrics storageMetrics = this.storage_metrics_;
        return storageMetrics == null ? StorageMetrics.getDefaultInstance() : storageMetrics;
    }

    @Encodable.Field(name = "storageMetrics")
    public StorageMetrics getStorageMetricsInternal() {
        return this.storage_metrics_;
    }

    public static GlobalMetrics getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final class Builder {
        private StorageMetrics storage_metrics_ = null;
        private static final byte[] $$a = {2, -89, -33, -54};
        private static final int $$b = 11;
        private static int $10 = 0;
        private static int $11 = 1;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static char[] IPostMessageService = {38338, 38212, 38221, 38257, 38245, 38210, 38218, 38219, 38213, 38220, 38228, 38220, 38248, 38245, 38220, 38221, 38221, 38227, 38221, 38226, 38224, 38220, 38226, 38224, 38221, 38219, 38231, 38264, 38152, 38150, 38258, 38261, 38153, 38152, 38150, 38242, 38245, 38253, 38285, 38361, 38355, 38351, 38356, 38358, 38360, 38359, 38357, 38357, 38372, 38376, 38361, 38363, 38361, 38360, 38365, 38375, 38272, 38386, 38353, 38384, 38382, 38350, 38358, 38355, 38350, 38353, 38358, 38391, 38346, 38233, 38239, 38237, 38240, 38237, 38227, 38228, 38236, 38235, 38291, 38396, 38286, 38285, 38283, 38285, 38356, 38348, 38382, 38279, 38379, 38356, 38348, 38353, 38360, 38360, 38361, 38365, 38357, 38355, 38378, 38380, 38365, 38356, 38350, 38351, 38346, 38350, 38362, 38356, 38356, 38392, 38383, 38355, 38363, 38355, 38348, 38354, 38353, 38345, 38380, 38391, 38277, 38350, 38375, 38370, 38345, 38355, 38380, 38374, 38349, 38358, 38354};
        private static char[] validateRelationship = {56026, 56023, 56032, 56036, 55863, 55865, 55851, 55862, 55868, 55941, 56025, 55864, 55867, 55848, 55870, 56049, 56022, 56008, 56010, 56004, 56055, 55866, 55849, 55853, 56021, 55858, 56016, 55856, 55861, 56028, 55871, 55850, 55859, 55855, 55852, 56013, 56040, 56053, 56044, 55857};
        private static int warmup = -1044260187;
        private static boolean requestPostMessageChannelWithExtras = true;
        private static boolean ICustomTabsServiceDefault = true;

        /* JADX WARN: Code duplicated, block: B:10:0x0027  */
        /* JADX WARN: Code duplicated, block: B:8:0x0021  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002c). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$c(short r6, short r7, byte r8) {
            /*
                int r8 = 122 - r8
                byte[] r0 = com.google.android.datatransport.runtime.firebase.transport.GlobalMetrics.Builder.$$a
                int r7 = r7 * 2
                int r1 = 1 - r7
                int r6 = r6 * 4
                int r6 = 3 - r6
                byte[] r1 = new byte[r1]
                r2 = 0
                int r7 = 0 - r7
                if (r0 != 0) goto L17
                r8 = r6
                r3 = r7
                r4 = r2
                goto L2c
            L17:
                r3 = r2
            L18:
                int r6 = r6 + 1
                byte r4 = (byte) r8
                r1[r3] = r4
                int r4 = r3 + 1
                if (r3 != r7) goto L27
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                return r6
            L27:
                r3 = r0[r6]
                r5 = r8
                r8 = r6
                r6 = r5
            L2c:
                int r3 = -r3
                int r6 = r6 + r3
                r3 = r4
                r5 = r8
                r8 = r6
                r6 = r5
                goto L18
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.firebase.transport.GlobalMetrics.Builder.$$c(short, short, byte):java.lang.String");
        }

        Builder() {
        }

        public GlobalMetrics build() {
            return new GlobalMetrics(this.storage_metrics_);
        }

        public Builder setStorageMetrics(StorageMetrics storageMetrics) {
            this.storage_metrics_ = storageMetrics;
            return this;
        }

        private static void b(char[] cArr, byte[] bArr, int i, int[] iArr, Object[] objArr) throws Throwable {
            char[] cArr2;
            char[] cArr3;
            int i2 = 2;
            int i3 = 2 % 2;
            onMessageChannelReady onmessagechannelready = new onMessageChannelReady();
            char[] cArr4 = validateRelationship;
            int i4 = 0;
            if (cArr4 != null) {
                int i5 = $10 + 115;
                $11 = i5 % 128;
                int i6 = i5 % 2;
                int length = cArr4.length;
                char[] cArr5 = new char[length];
                int i7 = 0;
                while (i7 < length) {
                    int i8 = $10 + 11;
                    $11 = i8 % 128;
                    if (i8 % i2 == 0) {
                        try {
                            Object[] objArr2 = new Object[1];
                            objArr2[i4] = Integer.valueOf(cArr4[i7]);
                            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(115862995);
                            if (objAccessartificialFrame == null) {
                                byte b = (byte) i4;
                                byte b2 = b;
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(27 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1), 1041 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), -1719489573, false, $$c(b, b2, (byte) (b2 + 1)), new Class[]{Integer.TYPE});
                            }
                            cArr5[i7] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    } else {
                        Object[] objArr3 = {Integer.valueOf(cArr4[i7])};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(115862995);
                        if (objAccessartificialFrame2 == null) {
                            byte b3 = (byte) 0;
                            byte b4 = b3;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(TextUtils.getTrimmedLength("") + 26, (char) ('0' - AndroidCharacter.getMirror('0')), 1041 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), -1719489573, false, $$c(b3, b4, (byte) (b4 + 1)), new Class[]{Integer.TYPE});
                        }
                        cArr5[i7] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                        i7++;
                    }
                    i2 = 2;
                    i4 = 0;
                }
                cArr4 = cArr5;
            }
            Object[] objArr4 = {Integer.valueOf(warmup)};
            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1820173622);
            if (objAccessartificialFrame3 == null) {
                byte b5 = (byte) 0;
                byte b6 = b5;
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(14 - TextUtils.lastIndexOf("", '0', 0), (char) (View.resolveSizeAndState(0, 0, 0) + 20488), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 2148, 216472770, false, $$c(b5, b6, (byte) (b6 | 55)), new Class[]{Integer.TYPE});
            }
            int iIntValue = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
            if (ICustomTabsServiceDefault) {
                int i9 = $10 + 11;
                $11 = i9 % 128;
                if (i9 % 2 == 0) {
                    onmessagechannelready.c = bArr.length;
                    cArr3 = new char[onmessagechannelready.c];
                    onmessagechannelready.a = 1;
                } else {
                    onmessagechannelready.c = bArr.length;
                    cArr3 = new char[onmessagechannelready.c];
                    onmessagechannelready.a = 0;
                }
                while (onmessagechannelready.a < onmessagechannelready.c) {
                    int i10 = $11 + 51;
                    $10 = i10 % 128;
                    if (i10 % 2 != 0) {
                        cArr3[onmessagechannelready.a] = (char) (cArr4[bArr[onmessagechannelready.c - onmessagechannelready.a] << i] + iIntValue);
                        Object[] objArr5 = {onmessagechannelready, onmessagechannelready};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                        if (objAccessartificialFrame4 == null) {
                            byte b7 = (byte) 0;
                            byte b8 = b7;
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation('E' - AndroidCharacter.getMirror('0'), (char) (59174 - KeyEvent.normalizeMetaState(0)), 1943 - (ViewConfiguration.getWindowTouchSlop() >> 8), 481771537, false, $$c(b7, b8, (byte) (b8 | 56)), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                    } else {
                        cArr3[onmessagechannelready.a] = (char) (cArr4[bArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] + i] - iIntValue);
                        Object[] objArr6 = {onmessagechannelready, onmessagechannelready};
                        Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                        if (objAccessartificialFrame5 == null) {
                            byte b9 = (byte) 0;
                            byte b10 = b9;
                            objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getDoubleTapTimeout() >> 16) + 21, (char) (59174 - TextUtils.indexOf("", "", 0, 0)), Gravity.getAbsoluteGravity(0, 0) + 1943, 481771537, false, $$c(b9, b10, (byte) (b10 | 56)), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame5).invoke(null, objArr6);
                    }
                }
                String str = new String(cArr3);
                int i11 = $11 + 11;
                $10 = i11 % 128;
                if (i11 % 2 == 0) {
                    objArr[0] = str;
                    return;
                } else {
                    int i12 = 19 / 0;
                    objArr[0] = str;
                    return;
                }
            }
            if (requestPostMessageChannelWithExtras) {
                int i13 = $11 + 13;
                $10 = i13 % 128;
                if (i13 % 2 != 0) {
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
                    Object[] objArr7 = {onmessagechannelready, onmessagechannelready};
                    Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                    if (objAccessartificialFrame6 == null) {
                        byte b11 = (byte) 0;
                        byte b12 = b11;
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(21 - (Process.myTid() >> 22), (char) (59175 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), 1942 - TextUtils.lastIndexOf("", '0', 0, 0), 481771537, false, $$c(b11, b12, (byte) (b12 | 56)), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame6).invoke(null, objArr7);
                    int i14 = $10 + 7;
                    $11 = i14 % 128;
                    int i15 = i14 % 2;
                }
                objArr[0] = new String(cArr2);
                return;
            }
            int i16 = 0;
            onmessagechannelready.c = iArr.length;
            char[] cArr6 = new char[onmessagechannelready.c];
            while (true) {
                onmessagechannelready.a = i16;
                if (onmessagechannelready.a >= onmessagechannelready.c) {
                    objArr[0] = new String(cArr6);
                    return;
                } else {
                    cArr6[onmessagechannelready.a] = (char) (cArr4[iArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                    i16 = onmessagechannelready.a + 1;
                }
            }
        }

        private static void a(byte[] bArr, int[] iArr, boolean z, Object[] objArr) throws Throwable {
            char[] cArr;
            char[] cArr2;
            char c;
            int i = 2 % 2;
            onPostMessage onpostmessage = new onPostMessage();
            int i2 = 0;
            int i3 = iArr[0];
            int i4 = iArr[1];
            int i5 = iArr[2];
            int i6 = iArr[3];
            char[] cArr3 = IPostMessageService;
            char c2 = '0';
            if (cArr3 != null) {
                int length = cArr3.length;
                char[] cArr4 = new char[length];
                int i7 = $11 + 11;
                $10 = i7 % 128;
                int i8 = i7 % 2;
                int i9 = 0;
                while (i9 < length) {
                    try {
                        Object[] objArr2 = new Object[1];
                        objArr2[i2] = Integer.valueOf(cArr3[i9]);
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1782207618);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) i2;
                            byte b2 = b;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(AndroidCharacter.getMirror(c2) - '%', (char) Color.argb(i2, i2, i2, i2), 1562 - (Process.myPid() >> 22), 178318710, false, $$c(b, b2, (byte) (b2 | 57)), new Class[]{Integer.TYPE});
                        }
                        cArr4[i9] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                        i9++;
                        i2 = 0;
                        c2 = '0';
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                cArr3 = cArr4;
            }
            char[] cArr5 = new char[i4];
            System.arraycopy(cArr3, i3, cArr5, 0, i4);
            if (bArr != null) {
                int i10 = $10 + 81;
                $11 = i10 % 128;
                if (i10 % 2 == 0) {
                    cArr2 = new char[i4];
                    onpostmessage.a = 1;
                    c = 1;
                } else {
                    cArr2 = new char[i4];
                    onpostmessage.a = 0;
                    c = 0;
                }
                while (onpostmessage.a < i4) {
                    int i11 = $10 + 71;
                    $11 = i11 % 128;
                    int i12 = i11 % 2;
                    if (bArr[onpostmessage.a] == 1) {
                        int i13 = $11 + 65;
                        $10 = i13 % 128;
                        if (i13 % 2 != 0) {
                            int i14 = onpostmessage.a;
                            Object[] objArr3 = {Integer.valueOf(cArr5[onpostmessage.a]), Integer.valueOf(c)};
                            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1378437083);
                            if (objAccessartificialFrame2 == null) {
                                byte b3 = (byte) 0;
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(23 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1), TextUtils.indexOf((CharSequence) "", '0', 0) + 2442, -850656813, false, $$c(b3, b3, (byte) (-$$a[3])), new Class[]{Integer.TYPE, Integer.TYPE});
                            }
                            Object obj = null;
                            cArr2[i14] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                            obj.hashCode();
                            throw null;
                        }
                        int i15 = onpostmessage.a;
                        Object[] objArr4 = {Integer.valueOf(cArr5[onpostmessage.a]), Integer.valueOf(c)};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1378437083);
                        if (objAccessartificialFrame3 == null) {
                            byte b4 = (byte) 0;
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(23 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (ViewConfiguration.getTouchSlop() >> 8), 2441 - Color.blue(0), -850656813, false, $$c(b4, b4, (byte) (-$$a[3])), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        cArr2[i15] = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).charValue();
                    } else {
                        int i16 = onpostmessage.a;
                        Object[] objArr5 = {Integer.valueOf(cArr5[onpostmessage.a]), Integer.valueOf(c)};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-314759072);
                        if (objAccessartificialFrame4 == null) {
                            byte b5 = (byte) 0;
                            byte b6 = b5;
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(11 - Color.green(0), (char) View.resolveSizeAndState(0, 0, 0), 1562 - (ViewConfiguration.getEdgeSlop() >> 16), 1918398056, false, $$c(b5, b6, b6), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        cArr2[i16] = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).charValue();
                    }
                    c = cArr2[onpostmessage.a];
                    Object[] objArr6 = {onpostmessage, onpostmessage};
                    Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(898481158);
                    if (objAccessartificialFrame5 == null) {
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(22 - KeyEvent.normalizeMetaState(0), (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 29362), 215 - TextUtils.getOffsetAfter("", 0), -1427572210, false, "F", new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame5).invoke(null, objArr6);
                }
                cArr5 = cArr2;
            }
            if (i6 > 0) {
                int i17 = $11 + 43;
                $10 = i17 % 128;
                if (i17 % 2 != 0) {
                    char[] cArr6 = new char[i4];
                    System.arraycopy(cArr5, 1, cArr6, 0, i4);
                    System.arraycopy(cArr6, 0, cArr5, i4 - i6, i6);
                    System.arraycopy(cArr6, i6, cArr5, 1, i4 * i6);
                } else {
                    char[] cArr7 = new char[i4];
                    System.arraycopy(cArr5, 0, cArr7, 0, i4);
                    int i18 = i4 - i6;
                    System.arraycopy(cArr7, 0, cArr5, i18, i6);
                    System.arraycopy(cArr7, i6, cArr5, 0, i18);
                }
            }
            if (!(!z)) {
                int i19 = $11 + 115;
                $10 = i19 % 128;
                if (i19 % 2 != 0) {
                    cArr = new char[i4];
                    onpostmessage.a = 1;
                } else {
                    cArr = new char[i4];
                    onpostmessage.a = 0;
                }
                while (onpostmessage.a < i4) {
                    int i20 = $11 + 75;
                    $10 = i20 % 128;
                    int i21 = i20 % 2;
                    cArr[onpostmessage.a] = cArr5[(i4 - onpostmessage.a) - 1];
                    onpostmessage.a++;
                }
                int i22 = $10 + 113;
                $11 = i22 % 128;
                int i23 = i22 % 2;
                cArr5 = cArr;
            }
            if (i5 > 0) {
                int i24 = 0;
                while (true) {
                    onpostmessage.a = i24;
                    if (onpostmessage.a >= i4) {
                        break;
                    }
                    cArr5[onpostmessage.a] = (char) (cArr5[onpostmessage.a] - iArr[2]);
                    i24 = onpostmessage.a + 1;
                }
            }
            objArr[0] = new String(cArr5);
        }

        public static Object[] accessartificialFrame(Context context, int i, int i2) {
            int i3;
            int i4;
            int i5;
            Object objInvoke;
            Class<?> cls;
            Object obj;
            char c;
            String str;
            Class<?>[] clsArr;
            byte[] bArr;
            int iLastIndexOf;
            char c2;
            String str2;
            int i6;
            int i7 = 2 % 2;
            int i8 = artificialFrame;
            int i9 = 1;
            int i10 = ((i8 | 87) << 1) - (i8 ^ 87);
            getARTIFICIAL_FRAME_PACKAGE_NAME = i10 % 128;
            char[] cArr = null;
            if (i10 % 2 != 0) {
                cArr.hashCode();
                throw null;
            }
            if (context == null) {
                Object[] objArr = {new int[]{i}, new int[]{i}, new int[1], null};
                int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
                int i11 = (-1349337666) + (((~((-176726081) | (~iElapsedRealtime))) | (~(801897694 | iElapsedRealtime))) * (-272)) + (((~((-248177733) | iElapsedRealtime)) | 71451652) * (-272)) + (((~(iElapsedRealtime | 248177732)) | 730446042) * 272);
                int i12 = ~i;
                int i13 = ~((i12 ^ i2) | (i12 & i2));
                int i14 = (i11 * 165) + (i2 * (-163)) + (((i13 & i11) | (i11 ^ i13)) * (-328));
                int i15 = -(-(((i11 ^ i) | (i11 & i)) * 164));
                int i16 = (i14 & i15) + (i14 | i15);
                int i17 = ~i11;
                int i18 = ~i2;
                int i19 = ~((i17 & i18) | (i17 ^ i18));
                int i20 = ~i2;
                int i21 = ~((i & i20) | (i20 ^ i));
                int i22 = (i21 & i19) | (i19 ^ i21);
                int i23 = (i12 ^ i11) | (i12 & i11);
                int i24 = ~((i2 & i23) | (i23 ^ i2));
                int i25 = -(-(((i22 & i24) | (i22 ^ i24)) * 164));
                int i26 = (i16 & i25) + (i25 | i16);
                int i27 = i26 << 13;
                int i28 = (i27 & (~i26)) | ((~i27) & i26);
                int i29 = i28 >>> 17;
                int i30 = (i28 | i29) & (~(i28 & i29));
                ((int[]) objArr[2])[0] = i30 ^ (i30 << 5);
                return objArr;
            }
            try {
                Object[] objArr2 = new Object[1];
                a(new byte[]{1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0}, new int[]{0, 38, 135, 18}, true, objArr2);
                Object[] objArr3 = (Object[]) Array.newInstance(Class.forName((String) objArr2[0]), 2);
                int i31 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                int iValidateRelationship = SmoothCalendarLayoutManager.validateRelationship();
                int i32 = i31 * 71;
                int i33 = (i32 ^ (-8694)) + ((i32 & (-8694)) << 1);
                int i34 = ~i31;
                int i35 = ~((i34 & WebSocketProtocol.PAYLOAD_SHORT) | (i34 ^ WebSocketProtocol.PAYLOAD_SHORT));
                int i36 = ~((iValidateRelationship ^ WebSocketProtocol.PAYLOAD_SHORT) | (iValidateRelationship & WebSocketProtocol.PAYLOAD_SHORT));
                int i37 = i33 + (((i35 & i36) | (i35 ^ i36)) * (-140));
                int i38 = (i31 ^ WebSocketProtocol.PAYLOAD_SHORT) | (i31 & WebSocketProtocol.PAYLOAD_SHORT);
                int i39 = (~((i38 & iValidateRelationship) | (i38 ^ iValidateRelationship))) * 70;
                int i40 = (i37 ^ i39) + ((i39 & i37) << 1);
                int i41 = ~((~i31) | WebSocketProtocol.PAYLOAD_SHORT);
                int i42 = ~((-127) | i31);
                int i43 = (i41 ^ i42) | (i41 & i42);
                int i44 = ~((i31 & iValidateRelationship) | (i31 ^ iValidateRelationship));
                int i45 = -(-(((i44 & i43) | (i43 ^ i44)) * 70));
                int i46 = ((i40 | i45) << 1) - (i45 ^ i40);
                Object[] objArr4 = new Object[1];
                b(null, new byte[]{-109, -110, -125, -127, -112, -122, -119, -120, -121, -122, -123, -124, -125, -111, -112, -113, -114, -115, -116, -117, -118, -122, -119, -120, -121, -122, -123, -124, -125, -126, -127}, i46, null, objArr4);
                try {
                    Object[] objArr5 = {(String) objArr4[0]};
                    Object[] objArr6 = new Object[1];
                    a(new byte[]{1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0}, new int[]{0, 38, 135, 18}, true, objArr6);
                    objArr3[0] = Class.forName((String) objArr6[0]).getDeclaredConstructor(String.class).newInstance(objArr5);
                    Object[] objArr7 = new Object[1];
                    b(null, new byte[]{-113, -114, -115, -116, -117, -118, -122, -119, -120, -121, -122, -123, -124, -125, -126, -127, -112, -122, -119, -120, -121, -122, -123, -124, -125, -111, -112, -109, -110, -125, -127}, 126 - (~(-(-(ViewConfiguration.getScrollBarFadeDuration() >> 16)))), null, objArr7);
                    String str3 = (String) objArr7[0];
                    int i47 = artificialFrame + 57;
                    int i48 = i47 % 128;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i48;
                    int i49 = i47 % 2;
                    int i50 = ((i48 | b.i) << 1) - (i48 ^ b.i);
                    artificialFrame = i50 % 128;
                    int i51 = i50 % 2;
                    try {
                        Object[] objArr8 = new Object[1];
                        a(new byte[]{1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0}, new int[]{0, 38, 135, 18}, true, objArr8);
                        Object objNewInstance = Class.forName((String) objArr8[0]).getDeclaredConstructor(String.class).newInstance(str3);
                        int i52 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i53 = ((i52 | 93) << 1) - (i52 ^ 93);
                        artificialFrame = i53 % 128;
                        int i54 = i53 % 2;
                        objArr3[1] = objNewInstance;
                        int i55 = ((i52 | 35) << 1) - (i52 ^ 35);
                        artificialFrame = i55 % 128;
                        int i56 = i55 % 2;
                        try {
                            int i57 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                            int i58 = (i57 & 127) + (i57 | 127);
                            Object[] objArr9 = new Object[1];
                            b(null, new byte[]{-105, -104, -116, -105, -123, -120, -127, -107, -105, -123, -116, -105, -123, -120, -106, -107, -122, -119, -120, -121, -122, -123, -108}, i58, null, objArr9);
                            Class<?> cls2 = Class.forName((String) objArr9[0]);
                            int iResolveOpacity = Drawable.resolveOpacity(0, 0);
                            int i59 = (iResolveOpacity * (-813)) - (-51816);
                            int i60 = ~((-128) | iResolveOpacity);
                            int i61 = iResolveOpacity | i;
                            int i62 = ~i61;
                            int i63 = -(-(((i60 ^ i62) | (i60 & i62)) * (-814)));
                            int i64 = (i59 ^ i63) + ((i63 & i59) << 1);
                            int i65 = ~i;
                            int i66 = ~(((-128) ^ i65) | ((-128) & i65));
                            int i67 = ~iResolveOpacity;
                            int i68 = (~((i67 ^ 127) | (i67 & 127))) | i66;
                            int i69 = ~i61;
                            int i70 = ((i68 & i69) | (i68 ^ i69)) * 407;
                            int i71 = (i64 & i70) + (i70 | i64);
                            int i72 = ~((~iResolveOpacity) | 127);
                            int i73 = ~(i67 | i);
                            int i74 = (i73 & i72) | (i72 ^ i73);
                            int i75 = ~((i ^ 127) | (i & 127));
                            int i76 = -(-(((i74 & i75) | (i74 ^ i75)) * 407));
                            int i77 = ((i71 | i76) << 1) - (i76 ^ i71);
                            Object[] objArr10 = new Object[1];
                            b(null, new byte[]{-121, -116, -113, -108, -123, -108, -101, -116, -113, -108, -102, -106, -108, -103, -105, -116, -113}, i77, null, objArr10);
                            Object objInvoke2 = cls2.getMethod((String) objArr10[0], null).invoke(context, null);
                            int i78 = artificialFrame + 87;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i78 % 128;
                            int i79 = i78 % 2;
                            try {
                                int i80 = -(-MotionEvent.axisFromString(""));
                                int i81 = (i80 ^ 128) + ((i80 & 128) << 1);
                                Object[] objArr11 = new Object[1];
                                b(null, new byte[]{-105, -104, -116, -105, -123, -120, -127, -107, -105, -123, -116, -105, -123, -120, -106, -107, -122, -119, -120, -121, -122, -123, -108}, i81, null, objArr11);
                                Class<?> cls3 = Class.forName((String) objArr11[0]);
                                byte[] bArr2 = {-116, -100, -108, -126, -116, -113, -108, -102, -106, -108, -103, -105, -116, -113};
                                int iRgb = Color.rgb(0, 0, 0);
                                int i82 = artificialFrame;
                                int i83 = ((i82 | 91) << 1) - (i82 ^ 91);
                                int i84 = i83 % 128;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i84;
                                int i85 = i83 % 2;
                                int i86 = iRgb * (-167);
                                int i87 = i84 + 67;
                                artificialFrame = i87 % 128;
                                if (i87 % 2 == 0) {
                                    i3 = i86 >> (-16777510);
                                    i4 = (~iRgb) | (-16777344);
                                } else {
                                    i3 = ((i86 & 1493151015) << 1) + (i86 ^ 1493151015);
                                    int i88 = ~iRgb;
                                    i4 = (i88 & (-16777344)) | (i88 ^ (-16777344));
                                }
                                int i89 = ~i4;
                                int i90 = ((i84 | 57) << 1) - (i84 ^ 57);
                                artificialFrame = i90 % 128;
                                int i91 = i90 % 2;
                                int i92 = -(-(336 * ((~(((-16777344) & i) | ((-16777344) ^ i))) | i89)));
                                int i93 = (i3 ^ i92) + ((i92 & i3) << 1);
                                int i94 = ~((16777343 & iRgb) | (iRgb ^ 16777343));
                                int i95 = ~(iRgb | i);
                                int i96 = (i93 - (~(-(-(((i94 & i95) | (i94 ^ i95)) * (-168)))))) - 1;
                                int i97 = ~i;
                                int i98 = -(-(((~(iRgb | i97)) | (-16777344)) * 168));
                                int i99 = ((i96 | i98) << 1) - (i98 ^ i96);
                                Object[] objArr12 = new Object[1];
                                b(null, bArr2, i99, null, objArr12);
                                String str4 = (String) objArr12[0];
                                int i100 = getARTIFICIAL_FRAME_PACKAGE_NAME + 5;
                                artificialFrame = i100 % 128;
                                int i101 = i100 % 2;
                                try {
                                    Object[] objArr13 = {cls3.getMethod(str4, null).invoke(context, null), 64};
                                    byte[] bArr3 = {-121, -116, -113, -108, -123, -108, -101, -116, -113, -108, -102, -106, -108, -103, -107, -100, -99, -107, -105, -123, -116, -105, -123, -120, -106, -107, -122, -119, -120, -121, -122, -123, -108};
                                    int i102 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                                    int i103 = (i102 * 477) - 60325;
                                    int i104 = ~i102;
                                    int i105 = (-128) | i102;
                                    int i106 = (~((i104 & 127) | (i104 ^ 127))) | (~((i105 & i) | (i105 ^ i)));
                                    int i107 = getARTIFICIAL_FRAME_PACKAGE_NAME + 15;
                                    artificialFrame = i107 % 128;
                                    if (i107 % 2 == 0) {
                                        i5 = (i103 % ((-476) / i106)) << ((~((((-128) & i102) | ((-128) ^ i102)) | i)) * 952);
                                    } else {
                                        int i108 = (i103 - (~(-(-(i106 * (-476)))))) - 1;
                                        int i109 = ((-128) & i102) | ((-128) ^ i102);
                                        int i110 = -(-((~((i109 & i) | (i109 ^ i))) * 952));
                                        i5 = ((i108 & i110) << 1) + (i108 ^ i110);
                                    }
                                    int i111 = ((-128) & i65) | ((-128) ^ i65);
                                    int i112 = -(-(476 * (~((i102 & i111) | (i111 ^ i102)))));
                                    int i113 = ((i5 | i112) << 1) - (i112 ^ i5);
                                    Object[] objArr14 = new Object[1];
                                    b(null, bArr3, i113, null, objArr14);
                                    Class<?> cls4 = Class.forName((String) objArr14[0]);
                                    int iArgb = Color.argb(0, 0, 0, 0);
                                    int i114 = (iArgb ^ 127) + ((iArgb & 127) << 1);
                                    Object[] objArr15 = new Object[1];
                                    b(null, new byte[]{-120, -97, -123, -98, -116, -113, -108, -102, -106, -108, -103, -105, -116, -113}, i114, null, objArr15);
                                    Method method = cls4.getMethod((String) objArr15[0], String.class, Integer.TYPE);
                                    int i115 = ~(1396569317 | i);
                                    int i116 = (i115 & (-1400895232)) | ((-1400895232) ^ i115);
                                    int i117 = ~((275948186 & i) | (275948186 ^ i));
                                    int i118 = (-1434956186) - (~(((i116 & i117) | (i116 ^ i117)) * (-744)));
                                    int i119 = ((i97 & 271622272) | (i97 ^ 271622272)) * 744;
                                    int i120 = (((i118 & i119) + (i119 | i118)) - (~(((1400895231 & i) | (1400895231 ^ i)) * 744))) - 1;
                                    int iValidateRelationship2 = SmoothCalendarLayoutManager.validateRelationship();
                                    int i121 = ~iValidateRelationship2;
                                    int i122 = ((~((i121 & 1274075903) | (1274075903 ^ i121))) | 33554609) * (-591);
                                    int i123 = ((-16307652) & i122) + (i122 | (-16307652));
                                    int i124 = -(-(((iValidateRelationship2 & 185617145) | (iValidateRelationship2 ^ 185617145) | 1122013367) * 591));
                                    if (i120 <= (i123 & i124) + (i124 | i123)) {
                                        objInvoke = method.invoke(objInvoke2, objArr13);
                                        Object[] objArr16 = new Object[1];
                                        a(new byte[]{0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1}, new int[]{38, 30, 0, 7}, false, objArr16);
                                        cls = Class.forName((String) objArr16[0]);
                                        Object[] objArr17 = new Object[1];
                                        a(new byte[]{1, 0, 0, 1, 1, 1, 1, 1, 1, 0}, new int[]{68, 10, SyslogConstants.LOG_CLOCK, 0}, true, objArr17);
                                        obj = objArr17[0];
                                    } else {
                                        objInvoke = method.invoke(objInvoke2, objArr13);
                                        Object[] objArr18 = new Object[1];
                                        a(new byte[]{0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1}, new int[]{38, 30, 0, 7}, true, objArr18);
                                        cls = Class.forName((String) objArr18[0]);
                                        Object[] objArr19 = new Object[1];
                                        a(new byte[]{1, 0, 0, 1, 1, 1, 1, 1, 1, 0}, new int[]{68, 10, SyslogConstants.LOG_CLOCK, 0}, false, objArr19);
                                        obj = objArr19[0];
                                    }
                                    Object[] objArr20 = (Object[]) cls.getField((String) obj).get(objInvoke);
                                    int length = objArr20.length;
                                    int i125 = 0;
                                    while (i125 < length) {
                                        SmoothCalendarLayoutManager.validateRelationship();
                                        SmoothCalendarLayoutManager.validateRelationship();
                                        Object obj2 = objArr20[i125];
                                        Object[] objArr21 = new Object[i9];
                                        a(new byte[]{0, 0, 1, 1, 1}, new int[]{78, 5, 0, 0}, false, objArr21);
                                        try {
                                            Object[] objArr22 = {(String) objArr21[0]};
                                            byte[] bArr4 = {1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1};
                                            int[] iArr = {83, 37, 0, 22};
                                            int i126 = artificialFrame + 77;
                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i126 % 128;
                                            int i127 = i126 % 2;
                                            Object[] objArr23 = new Object[i9];
                                            a(bArr4, iArr, false, objArr23);
                                            Class<?> cls5 = Class.forName((String) objArr23[0]);
                                            byte[] bArr5 = {-116, -106, -123, -108, -105, -96, -123, -98, -105, -116, -113};
                                            int maximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
                                            int i128 = getARTIFICIAL_FRAME_PACKAGE_NAME + 15;
                                            artificialFrame = i128 % 128;
                                            if (i128 % 2 == 0) {
                                                Object[] objArr24 = new Object[i9];
                                                b(cArr, bArr5, 127 / (((maximumFlingVelocity | (-21)) << i9) - (maximumFlingVelocity ^ (-21))), cArr, objArr24);
                                                str = (String) objArr24[0];
                                                clsArr = new Class[i9];
                                                c = 0;
                                            } else {
                                                Object[] objArr25 = new Object[i9];
                                                b(cArr, bArr5, 126 - (~(-(maximumFlingVelocity >> 16))), cArr, objArr25);
                                                c = 0;
                                                str = (String) objArr25[0];
                                                clsArr = new Class[i9];
                                            }
                                            clsArr[c] = String.class;
                                            Object objInvoke3 = cls5.getMethod(str, clsArr).invoke(cArr, objArr22);
                                            int i129 = artificialFrame + 53;
                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i129 % 128;
                                            if (i129 % 2 != 0) {
                                                try {
                                                    bArr = new byte[]{-116, -121, -114, -105, -108, -123, -113, -119, -109, -107, -100, -99, -107, -105, -123, -116, -105, -123, -120, -106, -107, -122, -119, -120, -121, -122, -123, -108};
                                                    iLastIndexOf = 22 / TextUtils.lastIndexOf("", 'x');
                                                } catch (Throwable th) {
                                                    Throwable cause = th.getCause();
                                                    if (cause != null) {
                                                        throw cause;
                                                    }
                                                    throw th;
                                                }
                                            } else {
                                                bArr = new byte[]{-116, -121, -114, -105, -108, -123, -113, -119, -109, -107, -100, -99, -107, -105, -123, -116, -105, -123, -120, -106, -107, -122, -119, -120, -121, -122, -123, -108};
                                                iLastIndexOf = 125 - (~(-TextUtils.lastIndexOf("", '0')));
                                            }
                                            Object[] objArr26 = new Object[i9];
                                            b(cArr, bArr, iLastIndexOf, cArr, objArr26);
                                            Class<?> cls6 = Class.forName((String) objArr26[0]);
                                            Object[] objArr27 = new Object[i9];
                                            a(new byte[]{0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0}, new int[]{SyslogConstants.LOG_CLOCK, 11, 0, 0}, false, objArr27);
                                            try {
                                                Object[] objArr28 = {new ByteArrayInputStream((byte[]) cls6.getMethod((String) objArr27[0], null).invoke(obj2, null))};
                                                Object[] objArr29 = new Object[i9];
                                                a(new byte[]{1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1}, new int[]{83, 37, 0, 22}, false, objArr29);
                                                String str5 = (String) objArr29[0];
                                                int i130 = getARTIFICIAL_FRAME_PACKAGE_NAME + 93;
                                                artificialFrame = i130 % 128;
                                                int i131 = i130 % 2;
                                                Class<?> cls7 = Class.forName(str5);
                                                byte[] bArr6 = {-116, -105, -108, -106, -119, -97, -119, -105, -121, -116, -127, -116, -105, -108, -121, -116, -123, -116, -113};
                                                int i132 = -TextUtils.getTrimmedLength("");
                                                int iValidateRelationship3 = SmoothCalendarLayoutManager.validateRelationship();
                                                int i133 = i132 * JfifUtil.MARKER_EOI;
                                                int i134 = artificialFrame;
                                                int i135 = (i134 ^ 95) + ((i134 & 95) << i9);
                                                int i136 = i135 % 128;
                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i136;
                                                int i137 = i135 % 2;
                                                int i138 = ((i133 - 27305) - (~((~((i132 ^ iValidateRelationship3) | (i132 & iValidateRelationship3))) * JfifUtil.MARKER_SOI))) - 1;
                                                int i139 = (i132 ^ (-128)) | (i132 & (-128));
                                                Object[] objArr30 = objArr20;
                                                int i140 = ~iValidateRelationship3;
                                                int i141 = (i138 - (~(-(-(((i139 ^ i140) | (i139 & i140)) * (-216)))))) - 1;
                                                int i142 = ((i136 | 77) << 1) - (i136 ^ 77);
                                                artificialFrame = i142 % 128;
                                                if (i142 % 2 == 0) {
                                                    int i143 = ~((i140 & i132) | (i140 ^ i132));
                                                    Object[] objArr31 = new Object[1];
                                                    b(null, bArr6, i141 << (((i143 & 127) | (i143 ^ 127)) * JfifUtil.MARKER_SOI), null, objArr31);
                                                    str2 = (String) objArr31[0];
                                                    c2 = 0;
                                                    i6 = 0;
                                                } else {
                                                    int i144 = ~((~iValidateRelationship3) | i132);
                                                    int i145 = i141 + (((i144 & 127) | (i144 ^ 127)) * JfifUtil.MARKER_SOI);
                                                    Object[] objArr32 = new Object[1];
                                                    b(null, bArr6, i145, null, objArr32);
                                                    c2 = 0;
                                                    str2 = (String) objArr32[0];
                                                    i6 = 1;
                                                }
                                                Class<?>[] clsArr2 = new Class[i6];
                                                clsArr2[c2] = InputStream.class;
                                                Object objInvoke4 = cls7.getMethod(str2, clsArr2).invoke(objInvoke3, objArr28);
                                                int length2 = objArr3.length;
                                                int i146 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                int i147 = ((i146 | 107) << 1) - (i146 ^ 107);
                                                artificialFrame = i147 % 128;
                                                int i148 = i147 % 2;
                                                int i149 = 0;
                                                for (int i150 = 2; i149 < i150; i150 = 2) {
                                                    int i151 = getARTIFICIAL_FRAME_PACKAGE_NAME + 75;
                                                    artificialFrame = i151 % 128;
                                                    int i152 = i151 % i150;
                                                    Object obj3 = objArr3[i149];
                                                    try {
                                                        int i153 = -TextUtils.lastIndexOf("", '0');
                                                        int iValidateRelationship4 = SmoothCalendarLayoutManager.validateRelationship();
                                                        int i154 = i153 * (-523);
                                                        int i155 = ((i154 | 33138) << 1) - (i154 ^ 33138);
                                                        int i156 = ~((~i153) | WebSocketProtocol.PAYLOAD_SHORT);
                                                        int i157 = ~(((-127) ^ i153) | ((-127) & i153));
                                                        int i158 = (i156 ^ i157) | (i157 & i156);
                                                        int i159 = ~((-127) | iValidateRelationship4);
                                                        int i160 = -(-(((i158 & i159) | (i158 ^ i159)) * 262));
                                                        int i161 = (((i155 ^ i160) + ((i160 & i155) << 1)) - (~(-(-((~((-127) | i153)) * (-786)))))) - 1;
                                                        int i162 = ~iValidateRelationship4;
                                                        int i163 = ~((i162 & (-127)) | ((-127) ^ i162));
                                                        int i164 = ~i153;
                                                        int i165 = ~((i164 & WebSocketProtocol.PAYLOAD_SHORT) | (i164 ^ WebSocketProtocol.PAYLOAD_SHORT));
                                                        int i166 = (i163 & i165) | (i163 ^ i165);
                                                        int i167 = ~((i153 & (-127)) | ((-127) ^ i153));
                                                        int i168 = i161 + (((i167 & i166) | (i166 ^ i167)) * 262);
                                                        Object[] objArr33 = new Object[1];
                                                        b(null, new byte[]{-116, -105, -108, -106, -119, -97, -119, -105, -121, -116, -127, -89, -90, -91, -92, -107, -105, -121, -116, -106, -107, -93, -105, -119, -121, -114, -106, -116, -96, -107, -108, -94, -108, -95}, i168, null, objArr33);
                                                        Class<?> cls8 = Class.forName((String) objArr33[0]);
                                                        int i169 = -KeyEvent.normalizeMetaState(0);
                                                        int iValidateRelationship5 = SmoothCalendarLayoutManager.validateRelationship();
                                                        int i170 = ~iValidateRelationship5;
                                                        int i171 = ~(((-128) ^ i170) | ((-128) & i170));
                                                        int i172 = ~i169;
                                                        int i173 = ~((i172 ^ iValidateRelationship5) | (i172 & iValidateRelationship5));
                                                        int i174 = (i171 ^ i173) | (i173 & i171);
                                                        int i175 = ~iValidateRelationship5;
                                                        int i176 = length;
                                                        int i177 = ~((i175 ^ i169) | (i175 & i169));
                                                        int i178 = (((i169 * (-958)) - 121666) - (~(((i174 ^ i177) | (i177 & i174)) * 959))) - 1;
                                                        int i179 = -(-((~((i169 ^ 127) | (i169 & 127))) * (-959)));
                                                        int i180 = (i178 ^ i179) + ((i179 & i178) << 1);
                                                        int i181 = ~i169;
                                                        int i182 = i180 + (((~((i181 & i175) | (i181 ^ i175))) | (~(((-128) ^ iValidateRelationship5) | ((-128) & iValidateRelationship5))) | (~((i169 & iValidateRelationship5) | (i169 ^ iValidateRelationship5)))) * 959);
                                                        Object[] objArr34 = new Object[1];
                                                        b(null, new byte[]{-88, -108, -99, -119, -106, -123, -119, -121, -103, -90, -90, -91, -92, -105, -106, -116, -95, -115, -114, -109, -105, -116, -113}, i182, null, objArr34);
                                                        if (!(!obj3.equals(cls8.getMethod((String) objArr34[0], null).invoke(objInvoke4, null)))) {
                                                            int i183 = (~(i & 1)) & (i | 1);
                                                            Object[] objArr35 = new Object[4];
                                                            int[] iArr2 = new int[1];
                                                            objArr35[0] = iArr2;
                                                            int[] iArr3 = new int[1];
                                                            objArr35[1] = iArr3;
                                                            objArr35[2] = new int[1];
                                                            int i184 = artificialFrame;
                                                            int i185 = ((i184 | 121) << 1) - (i184 ^ 121);
                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i185 % 128;
                                                            int i186 = i185 % 2;
                                                            iArr2[0] = i;
                                                            iArr3[0] = i183;
                                                            objArr35[3] = null;
                                                            int i187 = 215617938 + (((~((-6857025) | i)) | (~(971766750 | i65))) * (-318)) + (((~(963228108 | i)) | 8538642) * (-318)) + (((~((-963228109) | i)) | (-15395667)) * TypedValues.AttributesType.TYPE_PIVOT_TARGET);
                                                            int iValidateRelationship6 = SmoothCalendarLayoutManager.validateRelationship();
                                                            int i188 = ~i187;
                                                            int i189 = ~((-17) | iValidateRelationship6);
                                                            int i190 = 5104 + (i187 * (-317)) + (((i189 & i188) | (i188 ^ i189)) * (-318));
                                                            int i191 = artificialFrame + 5;
                                                            int i192 = i191 % 128;
                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i192;
                                                            int i193 = i191 % 2;
                                                            int i194 = ~((i188 ^ iValidateRelationship6) | (i188 & iValidateRelationship6));
                                                            int i195 = ~iValidateRelationship6;
                                                            int i196 = (i195 & 16) | (i195 ^ 16);
                                                            int i197 = ~((i196 & i187) | (i196 ^ i187));
                                                            int i198 = -(-(TypedValues.AttributesType.TYPE_PIVOT_TARGET * ((i194 & i197) | (i194 ^ i197))));
                                                            int i199 = (i190 & i198) + (i190 | i198);
                                                            int i200 = ~iValidateRelationship6;
                                                            int i201 = (i188 & i200) | (i188 ^ i200);
                                                            int i202 = (i187 & 16) | (i187 ^ 16);
                                                            int i203 = (i2 - (~(-(-(i199 + (((~((iValidateRelationship6 & i202) | (i202 ^ iValidateRelationship6))) | (~((i201 & 16) | (i201 ^ 16)))) * TypedValues.AttributesType.TYPE_PIVOT_TARGET)))))) - 1;
                                                            int i204 = i203 ^ (i203 << 13);
                                                            int i205 = ((i192 | 75) << 1) - (i192 ^ 75);
                                                            artificialFrame = i205 % 128;
                                                            if (i205 % 2 == 0) {
                                                                int i206 = i204 * 31;
                                                                int i207 = ((~i204) & i206) | ((~i206) & i204);
                                                                int i208 = i207 >>> 2;
                                                                ((int[]) objArr35[3])[0] = ((~i207) & i208) | ((~i208) & i207);
                                                            } else {
                                                                int i209 = i204 >>> 17;
                                                                int i210 = ((~i204) & i209) | ((~i209) & i204);
                                                                int i211 = i210 << 5;
                                                                ((int[]) objArr35[2])[0] = ((~i210) & i211) | ((~i211) & i210);
                                                            }
                                                            return objArr35;
                                                        }
                                                        i149 = (i149 & 1) + (i149 | 1);
                                                        length = i176;
                                                    } catch (Throwable th2) {
                                                        Throwable cause2 = th2.getCause();
                                                        if (cause2 != null) {
                                                            throw cause2;
                                                        }
                                                        throw th2;
                                                    }
                                                }
                                                i125++;
                                                objArr20 = objArr30;
                                                cArr = null;
                                                i9 = 1;
                                            } catch (Throwable th3) {
                                                Throwable cause3 = th3.getCause();
                                                if (cause3 != null) {
                                                    throw cause3;
                                                }
                                                throw th3;
                                            }
                                        } catch (Throwable th4) {
                                            Throwable cause4 = th4.getCause();
                                            if (cause4 != null) {
                                                throw cause4;
                                            }
                                            throw th4;
                                        }
                                    }
                                } catch (Throwable th5) {
                                    Throwable cause5 = th5.getCause();
                                    if (cause5 != null) {
                                        throw cause5;
                                    }
                                    throw th5;
                                }
                            } catch (Throwable th6) {
                                Throwable cause6 = th6.getCause();
                                if (cause6 != null) {
                                    throw cause6;
                                }
                                throw th6;
                            }
                        } catch (Throwable th7) {
                            Throwable cause7 = th7.getCause();
                            if (cause7 != null) {
                                throw cause7;
                            }
                            throw th7;
                        }
                    } catch (Throwable th8) {
                        Throwable cause8 = th8.getCause();
                        if (cause8 != null) {
                            throw cause8;
                        }
                        throw th8;
                    }
                } catch (Throwable th9) {
                    Throwable cause9 = th9.getCause();
                    if (cause9 != null) {
                        throw cause9;
                    }
                    throw th9;
                }
            } catch (Throwable unused) {
            }
            Object[] objArr36 = {new int[]{i}, new int[]{i}, new int[]{i ^ (i << 5)}, null};
            int i212 = i2 + (-1911695090) + (((-894589649) | i) * 376) + (((~((~i) | 126951847)) | (-936606712)) * (-376)) + (((~(i | (-126951848))) | 851671927) * 376);
            int i213 = i212 << 13;
            int i214 = (i212 | i213) & (~(i212 & i213));
            int i215 = i214 >>> 17;
            int i216 = (i214 | i215) & (~(i214 & i215));
            int i217 = getARTIFICIAL_FRAME_PACKAGE_NAME + 3;
            artificialFrame = i217 % 128;
            int i218 = i217 % 2;
            return objArr36;
        }
    }
}
