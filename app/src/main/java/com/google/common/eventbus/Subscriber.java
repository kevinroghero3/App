package com.google.common.eventbus;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.salesforce.marketingcloud.analytics.stats.b;
import io.sentry.ndk.BuildConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;
import kotlin.text.Typography;
import o.ArtificialStackFrames;
import o.ICustomTabsCallback;

/* JADX INFO: loaded from: classes5.dex */
@ElementTypesAreNonnullByDefault
public class Subscriber {
    private static short[] ICustomTabsService;
    private EventBus bus;
    private final Executor executor;
    private final Method method;
    final Object target;
    private static final byte[] $$c = {32, -58, -29, Ascii.ETB};
    private static final int $$d = AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {5, Ascii.FF, -27, -23, -11, -2, Ascii.FF};
    private static final int $$b = 34;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static int onTransact = -717383618;
    private static int mayLaunchUrl = -81862452;
    private static int getInterfaceDescriptor = 713612964;
    private static byte[] ICustomTabsCallbackStubProxy = {116, 122, -102, 117, 124, -117, 116, -89, 90, -122, 117, -117, 121, -104, 118, -86, 90, -127, -122, 117, -117, 121, -104, 118, -86, 89, -120, -94, 84, 114, -114, 126, -128, -125, 97, 121, -104, 118, -86, -99, 48, -113, -54, 65, 112, 113, 118, -123, 125, -122, -122, -119, -119, 100, 117, -98, 96, -115, -126, 120, -117, 118, -103, -65, 67, 114, -114, -115, -119, 100, 117, -50, 67, 121, -104, 118, -118, -66, 72, -116, 124, 119, -122, 113, -73, 55, 113, -115, -49, -118, -118, 116, 114, -127, -118, 120, -126, -115, 113, -119, -119, 100, 117, -123, -68, 72, -116, 124, 119, -122, 113, -73, 55, 113, -115, -49, 71, 127, 118, -119, -54, 116, -101, 115, 114, -114, -115, -119, 100, 117, -50, 67, 114, -114, -115, -119, 100, 117, -50, 67, 121, -104, 118, -118, -66, 72, -116, 124, 119, -122, 113, -73, 55, 113, -115, -49, -117, -117, -117, -117, -117, -117, -117, -117};

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(short r6, short r7, byte r8) {
        /*
            int r6 = r6 * 4
            int r6 = 4 - r6
            byte[] r0 = com.google.common.eventbus.Subscriber.$$c
            int r7 = r7 * 5
            int r7 = r7 + 112
            int r8 = r8 * 2
            int r1 = r8 + 1
            byte[] r1 = new byte[r1]
            r2 = 0
            if (r0 != 0) goto L17
            r4 = r7
            r3 = r2
            r7 = r6
            goto L2d
        L17:
            r3 = r2
        L18:
            r5 = r7
            r7 = r6
            r6 = r5
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L26:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r5
        L2d:
            int r6 = r6 + 1
            int r4 = -r4
            int r7 = r7 + r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.eventbus.Subscriber.$$e(short, short, byte):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0029  */
    /* JADX WARN: Code duplicated, block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x002f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0029
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(short r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 4
            int r6 = 4 - r6
            int r8 = r8 * 3
            int r0 = r8 + 4
            byte[] r1 = com.google.common.eventbus.Subscriber.$$a
            int r7 = r7 * 4
            int r7 = 109 - r7
            byte[] r0 = new byte[r0]
            int r8 = r8 + 3
            r2 = 0
            if (r1 != 0) goto L19
            r3 = r7
            r4 = r2
            r7 = r6
            goto L2f
        L19:
            r3 = r2
        L1a:
            byte r4 = (byte) r7
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L29:
            r3 = r1[r6]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r5
        L2f:
            int r6 = -r6
            int r7 = r7 + 1
            int r3 = r3 + r6
            int r6 = r3 + (-3)
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.eventbus.Subscriber.b(short, int, short, java.lang.Object[]):void");
    }

    static Subscriber create(EventBus eventBus, Object obj, Method method) {
        if (isDeclaredThreadSafe(method)) {
            return new Subscriber(eventBus, obj, method);
        }
        return new SynchronizedSubscriber(eventBus, obj, method);
    }

    private Subscriber(EventBus eventBus, Object obj, Method method) {
        this.bus = eventBus;
        this.target = Preconditions.checkNotNull(obj);
        this.method = method;
        method.setAccessible(true);
        this.executor = eventBus.executor();
    }

    final void dispatchEvent(final Object obj) {
        this.executor.execute(new Runnable() { // from class: com.google.common.eventbus.Subscriber$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$dispatchEvent$0(obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dispatchEvent$0(Object obj) {
        try {
            invokeSubscriberMethod(obj);
        } catch (InvocationTargetException e) {
            this.bus.handleSubscriberException(e.getCause(), context(obj));
        }
    }

    void invokeSubscriberMethod(Object obj) throws InvocationTargetException {
        try {
            this.method.invoke(this.target, Preconditions.checkNotNull(obj));
        } catch (IllegalAccessException e) {
            String strValueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 28);
            sb.append("Method became inaccessible: ");
            sb.append(strValueOf);
            throw new Error(sb.toString(), e);
        } catch (IllegalArgumentException e2) {
            String strValueOf2 = String.valueOf(obj);
            StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 33);
            sb2.append("Method rejected target/argument: ");
            sb2.append(strValueOf2);
            throw new Error(sb2.toString(), e2);
        } catch (InvocationTargetException e3) {
            if (e3.getCause() instanceof Error) {
                throw ((Error) e3.getCause());
            }
            throw e3;
        }
    }

    private SubscriberExceptionContext context(Object obj) {
        return new SubscriberExceptionContext(this.bus, obj, this.target, this.method);
    }

    public final int hashCode() {
        return ((this.method.hashCode() + 31) * 31) + System.identityHashCode(this.target);
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof Subscriber) {
            Subscriber subscriber = (Subscriber) obj;
            if (this.target == subscriber.target && this.method.equals(subscriber.method)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDeclaredThreadSafe(Method method) {
        return method.getAnnotation(AllowConcurrentEvents.class) != null;
    }

    static final class SynchronizedSubscriber extends Subscriber {
        private SynchronizedSubscriber(EventBus eventBus, Object obj, Method method) {
            super(eventBus, obj, method);
        }

        @Override // com.google.common.eventbus.Subscriber
        void invokeSubscriberMethod(Object obj) throws InvocationTargetException {
            synchronized (this) {
                super.invokeSubscriberMethod(obj);
            }
        }
    }

    private static void a(int i, byte b, int i2, short s, int i3, Object[] objArr) throws Throwable {
        boolean z;
        int i4;
        int i5 = 2;
        int i6 = 2 % 2;
        ICustomTabsCallback iCustomTabsCallback = new ICustomTabsCallback();
        StringBuilder sb = new StringBuilder();
        try {
            Object[] objArr2 = {Integer.valueOf(i2), Integer.valueOf(mayLaunchUrl)};
            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1991297565);
            if (objAccessartificialFrame == null) {
                byte b2 = (byte) 0;
                byte b3 = b2;
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 40, (char) (AndroidCharacter.getMirror('0') + 36193), Drawable.resolveOpacity(0, 0) + 2342, 371880939, false, $$e(b2, b3, b3), new Class[]{Integer.TYPE, Integer.TYPE});
            }
            int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
            if (iIntValue == -1) {
                int i7 = $11 + 89;
                $10 = i7 % 128;
                int i8 = i7 % 2;
                z = true;
            } else {
                z = false;
            }
            if (z) {
                int i9 = $11 + 59;
                $10 = i9 % 128;
                if (i9 % 2 != 0) {
                    throw null;
                }
                byte[] bArr = ICustomTabsCallbackStubProxy;
                if (bArr != null) {
                    int length = bArr.length;
                    byte[] bArr2 = new byte[length];
                    int i10 = 0;
                    while (i10 < length) {
                        int i11 = $11 + 39;
                        $10 = i11 % 128;
                        int i12 = i11 % i5;
                        Object[] objArr3 = {Integer.valueOf(bArr[i10])};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1557994855);
                        if (objAccessartificialFrame2 == null) {
                            byte b4 = (byte) 0;
                            byte b5 = (byte) (b4 + 1);
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(44 - (ViewConfiguration.getScrollBarSize() >> 8), (char) View.MeasureSpec.getSize(0), 1215 - KeyEvent.keyCodeFromString(""), 1011328145, false, $$e(b4, b5, (byte) (b5 - 1)), new Class[]{Integer.TYPE});
                        }
                        bArr2[i10] = ((Byte) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).byteValue();
                        i10++;
                        i5 = 2;
                    }
                    bArr = bArr2;
                }
                if (bArr != null) {
                    byte[] bArr3 = ICustomTabsCallbackStubProxy;
                    Object[] objArr4 = {Integer.valueOf(i3), Integer.valueOf(onTransact)};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1991297565);
                    if (objAccessartificialFrame3 == null) {
                        byte b6 = (byte) 0;
                        byte b7 = b6;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(40 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (36241 - (ViewConfiguration.getScrollBarFadeDuration() >> 16)), 2342 - TextUtils.getOffsetBefore("", 0), 371880939, false, $$e(b6, b7, b7), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    iIntValue = (byte) (((byte) (((long) bArr3[((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue()]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                } else {
                    iIntValue = (short) (((short) (((long) ICustomTabsService[i3 + ((int) (((long) onTransact) ^ (-4629754035390455669L)))]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                }
            }
            if (iIntValue > 0) {
                int i13 = ((i3 + iIntValue) - 2) + ((int) (((long) onTransact) ^ (-4629754035390455669L)));
                if (z) {
                    int i14 = $10 + 29;
                    $11 = i14 % 128;
                    int i15 = i14 % 2;
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                iCustomTabsCallback.c = i13 + i4;
                Object[] objArr5 = {iCustomTabsCallback, Integer.valueOf(i), Integer.valueOf(getInterfaceDescriptor), sb};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(216546027);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(41 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) Color.alpha(0), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 4065, -1819443997, false, "x", new Class[]{Object.class, Integer.TYPE, Integer.TYPE, Object.class});
                }
                ((StringBuilder) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).append(iCustomTabsCallback.createConnectionCallback);
                iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                byte[] bArr4 = ICustomTabsCallbackStubProxy;
                if (bArr4 != null) {
                    int length2 = bArr4.length;
                    byte[] bArr5 = new byte[length2];
                    for (int i16 = 0; i16 < length2; i16++) {
                        bArr5[i16] = (byte) (((long) bArr4[i16]) ^ (-4629754035390455669L));
                    }
                    bArr4 = bArr5;
                }
                boolean z2 = bArr4 != null;
                iCustomTabsCallback.a = 1;
                while (iCustomTabsCallback.a < iIntValue) {
                    int i17 = $11 + 125;
                    $10 = i17 % 128;
                    int i18 = i17 % 2;
                    if (z2) {
                        byte[] bArr6 = ICustomTabsCallbackStubProxy;
                        int i19 = iCustomTabsCallback.c;
                        iCustomTabsCallback.c = i19 - 1;
                        iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((byte) (((byte) (((long) bArr6[i19]) ^ (-4629754035390455669L))) + s)) ^ b));
                    } else {
                        short[] sArr = ICustomTabsService;
                        int i20 = iCustomTabsCallback.c;
                        iCustomTabsCallback.c = i20 - 1;
                        iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((short) (((short) (((long) sArr[i20]) ^ (-4629754035390455669L))) + s)) ^ b));
                        int i21 = $10 + 31;
                        $11 = i21 % 128;
                        int i22 = i21 % 2;
                    }
                    sb.append(iCustomTabsCallback.createConnectionCallback);
                    iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                    iCustomTabsCallback.a++;
                }
            }
            objArr[0] = sb.toString();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0a30  */
    /* JADX WARN: Code duplicated, block: B:102:0x0a40 A[Catch: Exception -> 0x0cf3, TRY_ENTER, TRY_LEAVE, TryCatch #7 {Exception -> 0x0cf3, blocks: (B:98:0x099c, B:102:0x0a40, B:104:0x0b1b, B:128:0x0cec, B:129:0x0cf2, B:103:0x0a4a), top: B:159:0x099c, inners: #6 }] */
    /* JADX WARN: Code duplicated, block: B:110:0x0bbf  */
    /* JADX WARN: Code duplicated, block: B:111:0x0bc0 A[Catch: Exception -> 0x0c36, TRY_LEAVE, TryCatch #5 {Exception -> 0x0c36, blocks: (B:106:0x0b23, B:108:0x0bb9, B:111:0x0bc0, B:115:0x0c1a, B:117:0x0c2a, B:119:0x0c2f, B:120:0x0c35, B:112:0x0bca, B:114:0x0bfe), top: B:156:0x0b23, inners: #8 }] */
    /* JADX WARN: Code duplicated, block: B:132:0x0d6c  */
    /* JADX WARN: Code duplicated, block: B:133:0x0d87  */
    /* JADX WARN: Code duplicated, block: B:136:0x0dd0  */
    /* JADX WARN: Code duplicated, block: B:137:0x0de2  */
    /* JADX WARN: Code duplicated, block: B:156:0x0b23 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x05d5 A[PHI: r5
  0x05d5: PHI (r5v39 int A[IMMUTABLE_TYPE]) = (r5v38 int), (r5v144 int) binds: [B:44:0x05d3, B:41:0x05cd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:47:0x05f5  */
    /* JADX WARN: Code duplicated, block: B:48:0x05f8  */
    /* JADX WARN: Code duplicated, block: B:51:0x0607  */
    /* JADX WARN: Code duplicated, block: B:52:0x060f  */
    /* JADX WARN: Code duplicated, block: B:54:0x066e  */
    public static Object[] coroutineCreation(int i, int i2) throws Throwable {
        Object[] objArr;
        int i3;
        char c;
        int i4;
        int[] iArr;
        int[] iArr2;
        int i5;
        int i6;
        int i7;
        char c2;
        char c3;
        Object[] objArr2;
        String str;
        Object[] objArr3;
        int i8;
        int iMediaBrowserCompatMediaBrowserImplApi216;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        File file;
        FileReader fileReader;
        BufferedReader bufferedReader;
        boolean zEquals;
        boolean zEquals2;
        File file2;
        FileReader fileReader2;
        BufferedReader bufferedReader2;
        int i16;
        byte offsetAfter;
        int iLastIndexOf;
        int i17;
        int iMediaBrowserCompatMediaBrowserImplApi217;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23 = 2 % 2;
        float f = 0.0f;
        int i24 = 16;
        int i25 = 0;
        int i26 = 1;
        try {
            String[] strArr = new String[2];
            int i27 = -Process.getGidForName("");
            int iMediaBrowserCompatMediaBrowserImplApi218 = BuildConfig.MediaBrowserCompatMediaBrowserImplApi216();
            int i28 = (i27 * (-519)) - (-1966884353);
            int i29 = ~i27;
            int i30 = ~iMediaBrowserCompatMediaBrowserImplApi218;
            int i31 = ~((i29 ^ (-778682938)) | (i29 & (-778682938)) | i30);
            int i32 = ~((iMediaBrowserCompatMediaBrowserImplApi218 ^ 778682937) | (iMediaBrowserCompatMediaBrowserImplApi218 & 778682937));
            int i33 = ((i31 ^ i32) | (i32 & i31)) * 520;
            int i34 = (i28 & i33) + (i33 | i28);
            int i35 = ~(((-778682938) ^ i30) | ((-778682938) & i30));
            int i36 = ~((i27 ^ iMediaBrowserCompatMediaBrowserImplApi218) | (iMediaBrowserCompatMediaBrowserImplApi218 & i27));
            int i37 = -(-((i35 | i36) * (-1040)));
            int i38 = ((i34 | i37) << 1) - (i37 ^ i34);
            int i39 = ~i27;
            int i40 = ~((i30 & i39) | (i39 ^ i30));
            int i41 = ~(((-778682938) & i27) | ((-778682938) ^ i27));
            int i42 = (i40 & i41) | (i40 ^ i41);
            int i43 = ((i42 & i36) | (i42 ^ i36)) * 520;
            Object[] objArr4 = new Object[1];
            a(((i38 | i43) << 1) - (i38 ^ i43), (byte) (Process.myTid() >> 22), (ViewConfiguration.getKeyRepeatDelay() >> 16) - 52, (short) Color.blue(0), (-774076598) - (~(PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))), objArr4);
            strArr[0] = (String) objArr4[0];
            int i44 = -Color.alpha(0);
            int iMediaBrowserCompatMediaBrowserImplApi219 = BuildConfig.MediaBrowserCompatMediaBrowserImplApi216();
            int i45 = i44 * 50;
            int i46 = ((i45 | 1777164984) << 1) - (i45 ^ 1777164984);
            int i47 = ~iMediaBrowserCompatMediaBrowserImplApi219;
            int i48 = ~((i47 & (-778682953)) | ((-778682953) ^ i47));
            int i49 = ~(((-778682953) ^ i44) | ((-778682953) & i44));
            int i50 = (i46 - (~(-(-(((i48 ^ i49) | (i48 & i49)) * 98))))) - 1;
            int i51 = ~i44;
            int i52 = ~iMediaBrowserCompatMediaBrowserImplApi219;
            int i53 = ~((i51 ^ i52) | (i51 & i52));
            int i54 = (i53 & (-778682953)) | ((-778682953) ^ i53) | (~((i44 ^ iMediaBrowserCompatMediaBrowserImplApi219) | (i44 & iMediaBrowserCompatMediaBrowserImplApi219)));
            int i55 = artificialFrame + 95;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i55 % 128;
            int i56 = i55 % 2;
            int i57 = (-49) * i54;
            int i58 = ~(iMediaBrowserCompatMediaBrowserImplApi219 | (-778682953));
            int i59 = ~((i44 & 778682952) | (i44 ^ 778682952));
            int i60 = (i50 ^ i57) + ((i57 & i50) << 1) + (((i59 & i58) | (i58 ^ i59)) * 49);
            int iAxisFromString = MotionEvent.axisFromString("");
            int i61 = iAxisFromString * (-947);
            int i62 = (i61 ^ 949) + ((i61 & 949) << 1);
            int i63 = ~iAxisFromString;
            int i64 = ~(((-2) ^ i) | ((-2) & i));
            int i65 = ((i64 & i63) | (i63 ^ i64)) * (-948);
            int i66 = (i62 & i65) + (i62 | i65);
            int i67 = (i63 & (-2)) | (i63 ^ (-2));
            int i68 = ~i;
            int i69 = i66 + ((~((i67 & i68) | (i67 ^ i68))) * (-948));
            int i70 = -(-(((iAxisFromString & (-2)) | (iAxisFromString ^ (-2))) * 948));
            Object[] objArr5 = new Object[1];
            a(i60, (byte) ((i69 & i70) + (i70 | i69)), (-53) - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (short) ((-2) - (~(-Process.getGidForName("")))), (-774076579) - View.getDefaultSize(0, 0), objArr5);
            strArr[1] = (String) objArr5[0];
            int i71 = 0;
            while (true) {
                if (i71 >= 2) {
                    objArr = new Object[]{new int[]{i}, new int[]{i}, new int[1], null};
                    int i72 = ~((~new Random().nextInt()) | 794770446);
                    int i73 = ((621419534 | i72) * (-374)) + 1052563858 + ((i72 | 173350912) * 374);
                    int iMediaBrowserCompatMediaBrowserImplApi2110 = BuildConfig.MediaBrowserCompatMediaBrowserImplApi216();
                    int i74 = ~i2;
                    int i75 = (i73 * (-391)) + (i2 * (-195)) + (((~((i74 & i73) | (i74 ^ i73))) | (~(i2 | iMediaBrowserCompatMediaBrowserImplApi2110))) * (-196));
                    int i76 = (i73 | i2) * 392;
                    int i77 = (i75 ^ i76) + ((i75 & i76) << 1);
                    int i78 = ~i73;
                    int i79 = ~i2;
                    int i80 = ~((i78 & i79) | (i78 ^ i79));
                    int i81 = ~((iMediaBrowserCompatMediaBrowserImplApi2110 & i2) | (i2 ^ iMediaBrowserCompatMediaBrowserImplApi2110));
                    int i82 = -(-(((i81 & i80) | (i80 ^ i81)) * 196));
                    int i83 = (i77 & i82) + (i82 | i77);
                    int i84 = i83 << 13;
                    int i85 = (i84 | i83) & (~(i83 & i84));
                    int i86 = i85 ^ (i85 >>> 17);
                    int i87 = i86 << 5;
                    ((int[]) objArr[2])[0] = (i86 | i87) & (~(i86 & i87));
                    break;
                }
                String str2 = strArr[i71];
                int maximumDrawingCacheSize = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 778682930;
                byte b = (byte) (AudioTrack.getMinVolume() > f ? 1 : (AudioTrack.getMinVolume() == f ? 0 : -1));
                int jumpTapTimeout = ViewConfiguration.getJumpTapTimeout() >> i24;
                int i88 = artificialFrame + 99;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i88 % 128;
                if (i88 % 2 != 0) {
                    iMediaBrowserCompatMediaBrowserImplApi217 = BuildConfig.MediaBrowserCompatMediaBrowserImplApi216();
                    i18 = 20629 - (~(-(-jumpTapTimeout)));
                    int i89 = (iMediaBrowserCompatMediaBrowserImplApi217 ^ (-55)) | (iMediaBrowserCompatMediaBrowserImplApi217 & (-55));
                    int i90 = ~jumpTapTimeout;
                    i19 = i89 ^ i90;
                    i20 = i89 & i90;
                } else {
                    iMediaBrowserCompatMediaBrowserImplApi217 = BuildConfig.MediaBrowserCompatMediaBrowserImplApi216();
                    int i91 = jumpTapTimeout * (-380);
                    i18 = ((i91 | (-21010)) << i26) - (i91 ^ (-21010));
                    int i92 = iMediaBrowserCompatMediaBrowserImplApi217 | (-55);
                    int i93 = ~jumpTapTimeout;
                    i19 = i92 ^ i93;
                    i20 = i92 & i93;
                }
                int i94 = i18 + ((-381) * (i19 | i20));
                int i95 = ~jumpTapTimeout;
                int i96 = ~((i95 & 54) | (i95 ^ 54));
                int i97 = ~iMediaBrowserCompatMediaBrowserImplApi217;
                int i98 = ~((i97 & (-55)) | (i97 ^ (-55)));
                int i99 = (i96 & i98) | (i96 ^ i98);
                int i100 = ~((jumpTapTimeout ^ (-55)) | (jumpTapTimeout & (-55)));
                int i101 = -(-(((i99 & i100) | (i99 ^ i100)) * 381));
                int i102 = (i94 ^ i101) + ((i101 & i94) << i26);
                int i103 = ~jumpTapTimeout;
                int i104 = i102 + ((~((i103 & (-55)) | (i103 ^ (-55)))) * 381);
                short sResolveSizeAndState = (short) View.resolveSizeAndState(i25, i25, i25);
                long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
                int i105 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i106 = (i105 ^ 31) + ((i105 & 31) << i26);
                int i107 = i106 % 128;
                artificialFrame = i107;
                if (i106 % 2 == 0) {
                    i21 = -(jCurrentThreadTimeMillis > (-1L) ? 1 : (jCurrentThreadTimeMillis == (-1L) ? 0 : -1));
                    int i108 = 450 % i21;
                    i22 = (i108 & 774077009) + (i108 | 774077009);
                } else {
                    i21 = -(jCurrentThreadTimeMillis > (-1L) ? 1 : (jCurrentThreadTimeMillis == (-1L) ? 0 : -1));
                    int i109 = i21 * 450;
                    i22 = ((i109 | (-1106051648)) << 1) - (i109 ^ (-1106051648));
                }
                int i110 = ~(((i21 ^ (-1)) & (-774076561)) | (774076560 ^ i21));
                int i111 = (774076560 ^ i21) | (774076560 & i21);
                int i112 = ~((i111 ^ i) | (i111 & i));
                int i113 = 449 * ((i110 ^ i112) | (i110 & i112));
                int i114 = ((i22 | i113) << i26) - (i22 ^ i113);
                int i115 = ~i21;
                int i116 = ~((i115 ^ (-774076561)) | (i115 & (-774076561)));
                int i117 = (i107 & 35) + (i107 | 35);
                getARTIFICIAL_FRAME_PACKAGE_NAME = i117 % 128;
                int i118 = i117 % 2;
                int i119 = -(-((-1347) * i116));
                int i120 = (i114 & i119) + (i119 | i114);
                int i121 = ~((i115 ^ (-774076561)) | (i115 & (-774076561)));
                int i122 = (774076560 & i68) | (774076560 ^ i68);
                int i123 = ~((i122 & i21) | (i122 ^ i21));
                int i124 = -(-(((i121 & i123) | (i121 ^ i123)) * 449));
                int i125 = (i120 ^ i124) + ((i124 & i120) << 1);
                Object[] objArr6 = new Object[1];
                a(maximumDrawingCacheSize, b, i104, sResolveSizeAndState, i125, objArr6);
                Class<?> cls = Class.forName((String) objArr6[0]);
                if (((Boolean) cls.getMethod(str2, new Class[0]).invoke(cls, null)).booleanValue()) {
                    objArr = new Object[]{new int[]{i}, new int[]{(~(i & 1)) & (i | 1)}, new int[1], null};
                    int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
                    int i126 = 1801947142 + ((872619228 | iElapsedRealtime) * 614);
                    int i127 = ~iElapsedRealtime;
                    int i128 = i126 + (((~((-388553966) | i127)) | 335551692 | (~(590069809 | i127))) * (-1228)) + (((~(i127 | 925621501)) | (~((-53002274) | i127))) * 614);
                    int i129 = i128 * 521;
                    int i130 = (((-8304) | i129) << 1) - (i129 ^ (-8304));
                    int i131 = ~i128;
                    int i132 = (i131 & (-17)) | ((-17) ^ i131);
                    int i133 = -(-(((~((i132 & i68) | (i132 ^ i68))) | (~(i128 | i))) * 520));
                    int i134 = (i130 ^ i133) + ((i133 & i130) << 1);
                    int i135 = ~i128;
                    int i136 = ~((i135 ^ i68) | (i135 & i68));
                    int i137 = i | 16;
                    int i138 = ~i137;
                    int i139 = -(-(((i136 & i138) | (i136 ^ i138)) * (-1040)));
                    int i140 = (i134 ^ i139) + ((i139 & i134) << 1) + (((~((i135 & 16) | (i135 ^ 16))) | (~((-17) | i68)) | (~i137)) * 520);
                    int iMediaBrowserCompatMediaBrowserImplApi2111 = BuildConfig.MediaBrowserCompatMediaBrowserImplApi216();
                    int i141 = ((i140 * 370) - (~(i2 * 370))) - 1;
                    int i142 = (i140 ^ i2) | (i140 & i2);
                    int i143 = ~iMediaBrowserCompatMediaBrowserImplApi2111;
                    int i144 = -(-(((i142 & i143) | (i142 ^ i143)) * (-369)));
                    int i145 = (i141 & i144) + (i141 | i144);
                    int i146 = ~i140;
                    int i147 = ~iMediaBrowserCompatMediaBrowserImplApi2111;
                    int i148 = ~(i146 | i147);
                    int i149 = -(-(((i148 & i2) | (i2 ^ i148)) * (-369)));
                    int i150 = (i145 ^ i149) + ((i145 & i149) << 1);
                    int i151 = ~i2;
                    int i152 = ~((i151 & i140) | (i151 ^ i140));
                    int i153 = ~((iMediaBrowserCompatMediaBrowserImplApi2111 & i140) | (i140 ^ iMediaBrowserCompatMediaBrowserImplApi2111));
                    int i154 = (i153 & i152) | (i152 ^ i153);
                    int i155 = (i146 & i147) | (i146 ^ i147);
                    int i156 = ~((i155 & i2) | (i155 ^ i2));
                    int i157 = -(-(((i154 & i156) | (i154 ^ i156)) * 369));
                    int i158 = (i150 ^ i157) + ((i157 & i150) << 1);
                    int i159 = i158 << 13;
                    int i160 = (i159 | i158) & (~(i158 & i159));
                    int i161 = i160 >>> 17;
                    int i162 = ((~i160) & i161) | ((~i161) & i160);
                    int i163 = i162 << 5;
                    ((int[]) objArr[2])[0] = (i162 | i163) & (~(i162 & i163));
                    int i164 = artificialFrame + 27;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i164 % 128;
                    int i165 = i164 % 2;
                    break;
                }
                i71++;
                f = 0.0f;
                i24 = 16;
                i25 = 0;
                i26 = 1;
            }
            c = 1;
            i3 = 0;
        } catch (Exception unused) {
            objArr = new Object[]{new int[]{i}, new int[]{(i & (-3)) | ((~i) & 2)}, new int[1], null};
            int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
            int i166 = -(-((-1188835266) + (((~(startElapsedRealtime | 936346438)) | (-936352735)) * 305) + (((~((~startElapsedRealtime) | 936346438)) | (-42277337)) * 305) + 16));
            int i167 = ((i2 | i166) << 1) - (i166 ^ i2);
            int i168 = i167 << 13;
            int i169 = (i168 | i167) & (~(i167 & i168));
            int i170 = i169 >>> 17;
            int i171 = (i169 | i170) & (~(i169 & i170));
            int i172 = i171 << 5;
            i3 = 0;
            ((int[]) objArr[2])[0] = (i171 | i172) & (~(i171 & i172));
            c = 1;
        }
        if (i != ((int[]) objArr[c])[i3]) {
            return objArr;
        }
        try {
            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(590025679);
            if (objAccessartificialFrame == null) {
                int iGreen = 9 - Color.green(i3);
                char jumpTapTimeout2 = (char) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 64610);
                int capsMode = 1806 - TextUtils.getCapsMode("", i3, i3);
                byte b2 = (byte) i3;
                byte b3 = b2;
                Object[] objArr7 = new Object[1];
                b(b2, b3, b3, objArr7);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iGreen, jumpTapTimeout2, capsMode, -1135716921, false, (String) objArr7[i3], new Class[i3]);
            }
            long jLongValue = ((Long) ((Method) objAccessartificialFrame).invoke(null, null)).longValue();
            long j = 275884752;
            long j2 = -344;
            long j3 = (j2 * j) + (j2 * jLongValue);
            long j4 = 345;
            long j5 = -1;
            long j6 = j ^ j5;
            long j7 = jLongValue ^ j5;
            long j8 = j6 | j7;
            long j9 = i;
            long j10 = j3 + (((j8 ^ j5) | ((j6 | j9) ^ j5)) * j4) + ((((j6 | (j9 ^ j5)) ^ j5) | ((j7 | j) ^ j5)) * j4) + (j4 * ((j8 | j9) ^ j5)) + ((long) 64323282);
            int i173 = ~(new Random().nextInt(319387994) | (-1196225195));
            int i174 = ((int) (j10 >> 32)) & (((1079573418 + ((1661515690 | i173) * (-220))) + ((i173 | 1124643498) * 220)) - 1789549056);
            int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
            int i175 = ((int) j10) & ((((~((-155982932) | iFreeMemory)) | (-1471835567)) * 262) + 766632573 + (((~((~iFreeMemory) | (-155982932))) | (-1471835567)) * 262));
            int i176 = (i174 & i175) | (i174 ^ i175);
            int i177 = getARTIFICIAL_FRAME_PACKAGE_NAME;
            int i178 = (i177 & 11) + (i177 | 11);
            int i179 = i178 % 128;
            artificialFrame = i179;
            if (i178 % 2 == 0) {
                i4 = 1;
                if (i176 == 1) {
                    int i180 = ~i;
                    int i181 = (i & (-11)) | (i180 & 10);
                    Object[] objArr8 = new Object[4];
                    iArr = new int[i4];
                    objArr8[0] = iArr;
                    iArr2 = new int[i4];
                    objArr8[i4] = iArr2;
                    int[] iArr3 = new int[i4];
                    objArr8[2] = iArr3;
                    i5 = i179 + 35;
                    int i182 = i5 % 128;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i182;
                    if (i5 % 2 != 0) {
                        i6 = 125;
                    } else {
                        i6 = 16;
                    }
                    i7 = (i182 & 73) + (i182 | 73);
                    artificialFrame = i7 % 128;
                    if (i7 % 2 == 0) {
                        iArr2[1] = i;
                        c2 = 0;
                    } else {
                        c2 = 0;
                        iArr[0] = i;
                    }
                    iArr2[c2] = i181;
                    objArr8[3] = null;
                    int i183 = 1300475790 + (((~((-605241479) | i180)) | (~(i180 | (-25165913)))) * (-184)) + (((~((-779349671) | i180)) | 174108192 | (~((-199274105) | i180))) * SyslogConstants.LOG_LOCAL7) + 2001979024;
                    int i184 = -(-i6);
                    int i185 = (i183 ^ i184) + ((i184 & i183) << 1);
                    int i186 = ((i2 | i185) << 1) - (i185 ^ i2);
                    int i187 = i186 << 13;
                    int i188 = ((~i186) & i187) | ((~i187) & i186);
                    int i189 = i188 >>> 17;
                    int i190 = (i188 | i189) & (~(i188 & i189));
                    int i191 = i190 << 5;
                    iArr3[0] = (i190 | i191) & (~(i190 & i191));
                    c3 = 0;
                    objArr2 = objArr8;
                } else {
                    Object[] objArr9 = {new int[]{i}, new int[]{i}, new int[1], null};
                    int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
                    int i192 = (-1267991058) + (((~(865833419 | iMaxMemory)) | (-935042012) | (~(112790355 | iMaxMemory))) * (-744)) + (((~iMaxMemory) | 43581763) * 744) + ((iMaxMemory | 935042011) * 744);
                    int i193 = i192 * (-445);
                    int i194 = -(-(i2 * (-445)));
                    int i195 = ((i193 | i194) << 1) - (i193 ^ i194);
                    int i196 = ~i192;
                    int i197 = ~i2;
                    int i198 = ~((i197 & i196) | (i196 ^ i197));
                    int i199 = ~i2;
                    int i200 = ~i;
                    int i201 = ~((i200 & i199) | (i199 ^ i200));
                    int i202 = -(-(((i198 & i201) | (i198 ^ i201)) * 446));
                    int i203 = (i195 & i202) + (i202 | i195);
                    int i204 = ~((i196 & i2) | (i196 ^ i2));
                    int i205 = (i199 ^ i192) | (i199 & i192);
                    int i206 = ~((i205 & i) | (i205 ^ i));
                    int i207 = -(-(((i204 & i206) | (i204 ^ i206)) * 446));
                    int i208 = (i203 & i207) + (i207 | i203) + ((~((~i192) | i199)) * 446);
                    int i209 = i208 << 13;
                    int i210 = (i209 | i208) & (~(i208 & i209));
                    int i211 = i210 >>> 17;
                    int i212 = (i210 | i211) & (~(i210 & i211));
                    int i213 = i212 << 5;
                    int i214 = (i212 | i213) & (~(i212 & i213));
                    c3 = 0;
                    ((int[]) objArr9[2])[0] = i214;
                    objArr2 = objArr9;
                }
            } else {
                i4 = 1;
                if (i176 == 1) {
                    int i1810 = ~i;
                    int i1811 = (i & (-11)) | (i1810 & 10);
                    Object[] objArr10 = new Object[4];
                    iArr = new int[i4];
                    objArr10[0] = iArr;
                    iArr2 = new int[i4];
                    objArr10[i4] = iArr2;
                    int[] iArr4 = new int[i4];
                    objArr10[2] = iArr4;
                    i5 = i179 + 35;
                    int i1812 = i5 % 128;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i1812;
                    if (i5 % 2 != 0) {
                        i6 = 125;
                    } else {
                        i6 = 16;
                    }
                    i7 = (i1812 & 73) + (i1812 | 73);
                    artificialFrame = i7 % 128;
                    if (i7 % 2 == 0) {
                        iArr2[1] = i;
                        c2 = 0;
                    } else {
                        c2 = 0;
                        iArr[0] = i;
                    }
                    iArr2[c2] = i1811;
                    objArr10[3] = null;
                    int i1813 = 1300475790 + (((~((-605241479) | i1810)) | (~(i1810 | (-25165913)))) * (-184)) + (((~((-779349671) | i1810)) | 174108192 | (~((-199274105) | i1810))) * SyslogConstants.LOG_LOCAL7) + 2001979024;
                    int i1814 = -(-i6);
                    int i1815 = (i1813 ^ i1814) + ((i1814 & i1813) << 1);
                    int i1816 = ((i2 | i1815) << 1) - (i1815 ^ i2);
                    int i1817 = i1816 << 13;
                    int i1818 = ((~i1816) & i1817) | ((~i1817) & i1816);
                    int i1819 = i1818 >>> 17;
                    int i1910 = (i1818 | i1819) & (~(i1818 & i1819));
                    int i1911 = i1910 << 5;
                    iArr4[0] = (i1910 | i1911) & (~(i1910 & i1911));
                    c3 = 0;
                    objArr2 = objArr10;
                } else {
                    Object[] objArr11 = {new int[]{i}, new int[]{i}, new int[1], null};
                    int iMaxMemory2 = (int) Runtime.getRuntime().maxMemory();
                    int i1912 = (-1267991058) + (((~(865833419 | iMaxMemory2)) | (-935042012) | (~(112790355 | iMaxMemory2))) * (-744)) + (((~iMaxMemory2) | 43581763) * 744) + ((iMaxMemory2 | 935042011) * 744);
                    int i1913 = i1912 * (-445);
                    int i1914 = -(-(i2 * (-445)));
                    int i1915 = ((i1913 | i1914) << 1) - (i1913 ^ i1914);
                    int i1916 = ~i1912;
                    int i1917 = ~i2;
                    int i1918 = ~((i1917 & i1916) | (i1916 ^ i1917));
                    int i1919 = ~i2;
                    int i2010 = ~i;
                    int i2011 = ~((i2010 & i1919) | (i1919 ^ i2010));
                    int i2012 = -(-(((i1918 & i2011) | (i1918 ^ i2011)) * 446));
                    int i2013 = (i1915 & i2012) + (i2012 | i1915);
                    int i2014 = ~((i1916 & i2) | (i1916 ^ i2));
                    int i2015 = (i1919 ^ i1912) | (i1919 & i1912);
                    int i2016 = ~((i2015 & i) | (i2015 ^ i));
                    int i2017 = -(-(((i2014 & i2016) | (i2014 ^ i2016)) * 446));
                    int i2018 = (i2013 & i2017) + (i2017 | i2013) + ((~((~i1912) | i1919)) * 446);
                    int i2019 = i2018 << 13;
                    int i215 = (i2019 | i2018) & (~(i2018 & i2019));
                    int i216 = i215 >>> 17;
                    int i217 = (i215 | i216) & (~(i215 & i216));
                    int i218 = i217 << 5;
                    int i219 = (i217 | i218) & (~(i217 & i218));
                    c3 = 0;
                    ((int[]) objArr11[2])[0] = i219;
                    objArr2 = objArr11;
                }
            }
            if (i != ((int[]) objArr2[1])[c3]) {
                int i220 = artificialFrame;
                int i221 = (i220 & 41) + (i220 | 41);
                getARTIFICIAL_FRAME_PACKAGE_NAME = i221 % 128;
                int i222 = i221 % 2;
                return objArr2;
            }
            try {
                try {
                    int i223 = -(ViewConfiguration.getJumpTapTimeout() >> 16);
                    int i224 = (i223 * (-209)) + 464035328;
                    int i225 = ~i223;
                    int i226 = -(-((~((i225 ^ (-778682881)) | (i225 & (-778682881)))) * 210));
                    int i227 = (i224 & i226) + (i224 | i226);
                    int i228 = ~i;
                    int i229 = -(-(((~((i225 & i) | (i225 ^ i))) | (~((-778682881) | i228))) * 210));
                    int i230 = (i227 & i229) + (i229 | i227);
                    int i231 = ~i223;
                    int i232 = (i231 & i228) | (i231 ^ i228);
                    int i233 = ~((i232 & 778682880) | (i232 ^ 778682880));
                    int i234 = (i223 & (-778682881)) | ((-778682881) ^ i223);
                    int i235 = ~((i234 & i) | (i234 ^ i));
                    int i236 = ((i235 & i233) | (i233 ^ i235)) * 210;
                    int i237 = (i230 & i236) + (i236 | i230);
                    int iIndexOf = TextUtils.indexOf((CharSequence) "", '0', 0);
                    byte b4 = (byte) ((iIndexOf ^ 1) + ((iIndexOf & 1) << 1));
                    int gidForName = Process.getGidForName("");
                    int i238 = (gidForName * 69) + 2010;
                    int i239 = ~gidForName;
                    int i240 = (i239 & 29) | (i239 ^ 29);
                    int i241 = ~i;
                    int i242 = ~((i240 & i241) | (i240 ^ i241));
                    int i243 = ~(gidForName | (-30));
                    int i244 = (i242 & i243) | (i242 ^ i243);
                    int i245 = ~((i ^ (-30)) | (i & (-30)));
                    int i246 = -(-(((i244 & i245) | (i244 ^ i245)) * (-68)));
                    int i247 = ((i238 | i246) << 1) - (i238 ^ i246);
                    int i248 = ~gidForName;
                    int i249 = (i248 ^ i228) | (i248 & i228);
                    int i250 = (~((i249 & (-30)) | (i249 ^ (-30)))) * (-68);
                    int i251 = ((i247 | i250) << 1) - (i250 ^ i247);
                    int i252 = ~(29 | i241);
                    int i253 = ((i248 & i252) | (i248 ^ i252)) * 68;
                    int i254 = (i251 ^ i253) + ((i253 & i251) << 1);
                    short s = (short) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                    int i255 = -KeyEvent.getDeadChar(0, 0);
                    Object[] objArr12 = new Object[1];
                    a(i237, b4, i254, s, (i255 & (-774076547)) + (i255 | (-774076547)), objArr12);
                    File file3 = new File((String) objArr12[0]);
                    int i256 = artificialFrame;
                    int i257 = (i256 ^ 107) + ((i256 & 107) << 1);
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i257 % 128;
                    if (i257 % 2 != 0) {
                        file3.canRead();
                        Object obj = null;
                        try {
                            obj.hashCode();
                            throw null;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (file3.canRead()) {
                        FileReader fileReader3 = new FileReader(file3);
                        BufferedReader bufferedReader3 = new BufferedReader(fileReader3);
                        try {
                            String line = bufferedReader3.readLine();
                            int iNormalizeMetaState = KeyEvent.normalizeMetaState(0);
                            int iMediaBrowserCompatMediaBrowserImplApi2112 = BuildConfig.MediaBrowserCompatMediaBrowserImplApi216();
                            int i258 = iNormalizeMetaState * (-1965);
                            int i259 = (i258 & 1719837224) + (i258 | 1719837224);
                            int i260 = artificialFrame;
                            int i261 = ((i260 | 57) << 1) - (i260 ^ 57);
                            int i262 = i261 % 128;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i262;
                            int i263 = i261 % 2;
                            int i264 = 983 * (iNormalizeMetaState | (-778682944));
                            int i265 = ((i259 | i264) << 1) - (i259 ^ i264);
                            int i266 = ~iNormalizeMetaState;
                            int i267 = ~iMediaBrowserCompatMediaBrowserImplApi2112;
                            int i268 = ~(((-778682944) & i267) | ((-778682944) ^ i267));
                            int i269 = ((i268 & i266) | (i266 ^ i268)) * (-983);
                            int i270 = ((i265 | i269) << 1) - (i269 ^ i265);
                            int i271 = i262 + 91;
                            artificialFrame = i271 % 128;
                            if (i271 % 2 == 0) {
                                int i272 = -(983 / ((~((i267 & i266) | (i266 ^ i267))) | (~((i266 ^ 778682943) | (i266 & 778682943)))));
                                i16 = (i270 & i272) + (i272 | i270);
                                offsetAfter = (byte) TextUtils.getOffsetAfter("", 0);
                                iLastIndexOf = TextUtils.lastIndexOf("", Typography.greater, 0);
                                i17 = 7;
                            } else {
                                int i273 = ~((i267 & i266) | (i266 ^ i267));
                                int i274 = ~iNormalizeMetaState;
                                int i275 = ~((i274 & 778682943) | (i274 ^ 778682943));
                                i16 = (i270 - (~(((i273 & i275) | (i273 ^ i275)) * 983))) - 1;
                                offsetAfter = (byte) TextUtils.getOffsetAfter("", 0);
                                iLastIndexOf = TextUtils.lastIndexOf("", '0', 0);
                                i17 = -67;
                            }
                            int i276 = i16;
                            byte b5 = offsetAfter;
                            int i277 = getARTIFICIAL_FRAME_PACKAGE_NAME + 93;
                            artificialFrame = i277 % 128;
                            int i278 = i277 % 2;
                            int i279 = -(-iLastIndexOf);
                            int i280 = (i17 & i279) + (i17 | i279);
                            short sMyTid = (short) (Process.myTid() >> 22);
                            int iMyTid = Process.myTid() >> 22;
                            int i281 = artificialFrame + 117;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i281 % 128;
                            int i282 = i281 % 2;
                            int i283 = ((-51) * iMyTid) - (-1923618036);
                            int i284 = (i228 ^ iMyTid) | (i228 & iMyTid);
                            int i285 = -(-((~((i284 ^ (-774076508)) | (i284 & (-774076508)))) * 52));
                            int i286 = (i283 ^ i285) + ((i283 & i285) << 1);
                            int i287 = (~(774076507 | iMyTid)) | (~((774076507 ^ i228) | (774076507 & i228)));
                            int i288 = ~i284;
                            int i289 = -(-(((i287 & i288) | (i287 ^ i288)) * (-52)));
                            int i290 = ~iMyTid;
                            int i291 = ((((i286 | i289) << 1) - (i289 ^ i286)) - (~(((~((i228 & i290) | (i290 ^ i228))) | (~((i290 & (-774076508)) | (i290 ^ (-774076508))))) * 52))) - 1;
                            Object[] objArr13 = new Object[1];
                            a(i276, b5, i280, sMyTid, i291, objArr13);
                            if (line.equals((String) objArr13[0])) {
                                fileReader3.close();
                                bufferedReader3.close();
                            } else {
                                fileReader3.close();
                                bufferedReader3.close();
                                str = line;
                            }
                            int i292 = -(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                            int iMediaBrowserCompatMediaBrowserImplApi2113 = BuildConfig.MediaBrowserCompatMediaBrowserImplApi216();
                            int i293 = i292 * (-500);
                            int i294 = (i293 ^ 1500583436) + ((i293 & 1500583436) << 1);
                            int i295 = ~((-778682882) | i292);
                            int i296 = ~i292;
                            int i297 = (i296 & 778682881) | (i296 ^ 778682881);
                            int i298 = ~((i297 & iMediaBrowserCompatMediaBrowserImplApi2113) | (i297 ^ iMediaBrowserCompatMediaBrowserImplApi2113));
                            int i299 = -(-(((i295 & i298) | (i295 ^ i298)) * TypedValues.PositionType.TYPE_TRANSITION_EASING));
                            int i300 = ~i292;
                            int i301 = (((i294 | i299) << 1) - (i299 ^ i294)) + ((~((-778682882) | i300)) * 1002);
                            int i302 = ~iMediaBrowserCompatMediaBrowserImplApi2113;
                            int i303 = (~((i300 & i302) | (i300 ^ i302) | 778682881)) * TypedValues.PositionType.TYPE_TRANSITION_EASING;
                            int i304 = (i301 ^ i303) + ((i303 & i301) << 1);
                            byte b6 = (byte) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1);
                            int edgeSlop = (ViewConfiguration.getEdgeSlop() >> 16) - 40;
                            short sMyTid2 = (short) (Process.myTid() >> 22);
                            int i305 = -(-(ViewConfiguration.getEdgeSlop() >> 16));
                            int i306 = ((i305 | (-774076506)) << 1) - (i305 ^ (-774076506));
                            Object[] objArr14 = new Object[1];
                            a(i304, b6, edgeSlop, sMyTid2, i306, objArr14);
                            file = new File((String) objArr14[0]);
                            if (!file.canRead()) {
                                int i307 = artificialFrame;
                                int i308 = ((i307 | 33) << 1) - (i307 ^ 33);
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i308 % 128;
                                int i309 = i308 % 2;
                            } else {
                                fileReader = new FileReader(file);
                                bufferedReader = new BufferedReader(fileReader);
                                try {
                                    String line2 = bufferedReader.readLine();
                                    int i310 = -(ViewConfiguration.getLongPressTimeout() >> 16);
                                    int iMediaBrowserCompatMediaBrowserImplApi2114 = BuildConfig.MediaBrowserCompatMediaBrowserImplApi216();
                                    int i311 = (i310 * (-1335)) + 309560522;
                                    int i312 = (i310 ^ iMediaBrowserCompatMediaBrowserImplApi2114) | (i310 & iMediaBrowserCompatMediaBrowserImplApi2114);
                                    int i313 = ~i312;
                                    int i314 = ((i313 & (-778682883)) | ((-778682883) ^ i313)) * (-668);
                                    int i315 = ~((iMediaBrowserCompatMediaBrowserImplApi2114 & (-778682883)) | ((-778682883) ^ iMediaBrowserCompatMediaBrowserImplApi2114));
                                    int i316 = (((i311 | i314) << 1) - (i311 ^ i314)) + (((i310 & i315) | (i310 ^ i315)) * 1336);
                                    int i317 = -(-((i312 | (-778682883)) * 668));
                                    int i318 = ((i316 | i317) << 1) - (i317 ^ i316);
                                    byte absoluteGravity = (byte) Gravity.getAbsoluteGravity(0, 0);
                                    int i319 = -(-(ViewConfiguration.getTapTimeout() >> 16));
                                    int i320 = (i319 ^ (-70)) + ((i319 & (-70)) << 1);
                                    int threadPriority = Process.getThreadPriority(0);
                                    int i321 = -(-(threadPriority * (-518)));
                                    int i322 = ((-10360) & i321) + (i321 | (-10360));
                                    int i323 = ~i;
                                    int i324 = ~((i323 & (-21)) | ((-21) ^ i323));
                                    int i325 = ((i324 & threadPriority) | (threadPriority ^ i324)) * 519;
                                    int i326 = (i322 & i325) + (i325 | i322);
                                    int i327 = ~i;
                                    int i328 = (i327 & (-21)) | ((-21) ^ i327);
                                    int i329 = (threadPriority ^ 20) | (threadPriority & 20);
                                    int i330 = ((~((i328 & threadPriority) | (i328 ^ threadPriority))) | (~((i329 & i) | (i329 ^ i)))) * (-519);
                                    Object[] objArr15 = new Object[1];
                                    a(i318, absoluteGravity, i320, (short) (((((i326 ^ i330) + ((i330 & i326) << 1)) - (~(-(-(((~((threadPriority ^ i) | (threadPriority & i))) | 20) * 519))))) - 1) >> 6), (-774076476) - (Process.myTid() >> 22), objArr15);
                                    zEquals = line2.equals((String) objArr15[0]);
                                    fileReader.close();
                                    bufferedReader.close();
                                    if (zEquals) {
                                        try {
                                            int i331 = -TextUtils.indexOf((CharSequence) "", '0');
                                            int i332 = ~i331;
                                            int i333 = ~((i332 & 778682879) | (i332 ^ 778682879));
                                            int i334 = ((-778682880) & i331) | ((-778682880) ^ i331);
                                            int i335 = ~((i334 & i) | (i334 ^ i));
                                            int i336 = ((i331 * 477) - 507180069) + (((i333 & i335) | (i333 ^ i335)) * (-476)) + ((~(((-778682880) ^ i331) | ((-778682880) & i331) | i)) * 952);
                                            int i337 = ~i;
                                            int i338 = ((-778682880) & i337) | ((-778682880) ^ i337);
                                            int i339 = (~((i331 & i338) | (i338 ^ i331))) * 476;
                                            int i340 = (i336 ^ i339) + ((i339 & i336) << 1);
                                            byte bCombineMeasuredStates = (byte) View.combineMeasuredStates(0, 0);
                                            int i341 = -(-(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                                            short touchSlop = (short) (ViewConfiguration.getTouchSlop() >> 8);
                                            int i342 = -(-TextUtils.lastIndexOf("", '0', 0));
                                            int i343 = (i342 ^ (-774076475)) + ((i342 & (-774076475)) << 1);
                                            Object[] objArr16 = new Object[1];
                                            a(i340, bCombineMeasuredStates, ((i341 | (-36)) << 1) - (i341 ^ (-36)), touchSlop, i343, objArr16);
                                            file2 = new File((String) objArr16[0]);
                                            int i344 = artificialFrame;
                                            int i345 = ((i344 | 119) << 1) - (i344 ^ 119);
                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i345 % 128;
                                            int i346 = i345 % 2;
                                            if (file2.canRead()) {
                                                fileReader2 = new FileReader(file2);
                                                bufferedReader2 = new BufferedReader(fileReader2);
                                                try {
                                                    String line3 = bufferedReader2.readLine();
                                                    int maximumDrawingCacheSize2 = 778682882 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                                                    byte bRed = (byte) Color.red(0);
                                                    int iIndexOf2 = TextUtils.indexOf("", "", 0, 0);
                                                    int i347 = ((iIndexOf2 | (-70)) << 1) - (iIndexOf2 ^ (-70));
                                                    short keyRepeatDelay = (short) (ViewConfiguration.getKeyRepeatDelay() >> 16);
                                                    int i348 = artificialFrame + b.f40o;
                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i348 % 128;
                                                    int i349 = i348 % 2;
                                                    int offsetAfter2 = TextUtils.getOffsetAfter("", 0);
                                                    Object[] objArr17 = new Object[1];
                                                    a(maximumDrawingCacheSize2, bRed, i347, keyRepeatDelay, (offsetAfter2 & (-774076476)) + (offsetAfter2 | (-774076476)), objArr17);
                                                    zEquals2 = line3.equals((String) objArr17[0]);
                                                    fileReader2.close();
                                                    int i350 = artificialFrame;
                                                    int i351 = (i350 & 51) + (i350 | 51);
                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i351 % 128;
                                                    int i352 = i351 % 2;
                                                    bufferedReader2.close();
                                                } catch (Throwable th2) {
                                                    fileReader2.close();
                                                    bufferedReader2.close();
                                                    throw th2;
                                                }
                                            } else {
                                                zEquals2 = false;
                                            }
                                        } catch (Exception unused2) {
                                        }
                                        if (!(!zEquals2) && str != null) {
                                            int i353 = artificialFrame;
                                            int i354 = ((i353 | 49) << 1) - (i353 ^ 49);
                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i354 % 128;
                                            int i355 = i354 % 2;
                                            Object[] objArr18 = {new int[]{i}, new int[]{(i & (-21)) | ((~i) & 20)}, new int[1], str};
                                            int i356 = ~((int) Runtime.getRuntime().totalMemory());
                                            int i357 = (-23324166) + ((~(i356 | (-65))) * (-783)) + (((~(i356 | 771463099)) | (-207160676)) * 783);
                                            int iMediaBrowserCompatMediaBrowserImplApi2115 = BuildConfig.MediaBrowserCompatMediaBrowserImplApi216();
                                            int i358 = (-6097) - (~(i357 * JfifUtil.MARKER_SOFn));
                                            int i359 = ((i358 | 3247) << 1) - (i358 ^ 3247);
                                            int i360 = -(-(((~((i357 ^ iMediaBrowserCompatMediaBrowserImplApi2115) | (i357 & iMediaBrowserCompatMediaBrowserImplApi2115))) | 16) * 191));
                                            int i361 = (i359 & i360) + (i360 | i359);
                                            int i362 = ~(((-17) & i357) | ((-17) ^ i357));
                                            int i363 = ~iMediaBrowserCompatMediaBrowserImplApi2115;
                                            int i364 = ~((i363 & i357) | (i363 ^ i357));
                                            int i365 = -(-(((i364 & i362) | (i362 ^ i364)) * 191));
                                            int i366 = ((i361 | i365) << 1) - (i365 ^ i361);
                                            int i367 = ((i2 | i366) << 1) - (i366 ^ i2);
                                            int i368 = i367 << 13;
                                            int i369 = (i367 | i368) & (~(i367 & i368));
                                            int i370 = i369 >>> 17;
                                            int i371 = ((~i369) & i370) | ((~i370) & i369);
                                            ((int[]) objArr18[2])[0] = i371 ^ (i371 << 5);
                                            return objArr18;
                                        }
                                    }
                                } catch (Throwable th3) {
                                    fileReader.close();
                                    bufferedReader.close();
                                    throw th3;
                                }
                            }
                            int i372 = artificialFrame + 13;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i372 % 128;
                            int i373 = i372 % 2;
                            objArr3 = new Object[]{new int[]{i}, new int[]{i}, new int[1], null};
                            int startElapsedRealtime2 = (int) Process.getStartElapsedRealtime();
                            int i374 = ~startElapsedRealtime2;
                            int i375 = (-1679982946) + ((~(357467915 | i374)) * (-560)) + ((~(startElapsedRealtime2 | (-536875025))) * (-560)) + (((~(621155859 | i374)) | 273187080) * 560);
                            i8 = (i375 << 1) - i375;
                            iMediaBrowserCompatMediaBrowserImplApi216 = BuildConfig.MediaBrowserCompatMediaBrowserImplApi216();
                            int i376 = artificialFrame;
                            int i377 = ((i376 | 89) << 1) - (i376 ^ 89);
                            int i378 = i377 % 128;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i378;
                            int i379 = i377 % 2;
                            i9 = ((i8 * (-500)) - (~(i2 * (-500)))) - 1;
                            i10 = ~i2;
                            i11 = ~(i10 | i8);
                            i12 = i378 + 43;
                            artificialFrame = i12 % 128;
                            if (i12 % 2 == 0) {
                                int i380 = ~i8;
                                int i381 = (i380 & i2) | (i380 ^ i2);
                                int i382 = i9 >>> (TypedValues.PositionType.TYPE_TRANSITION_EASING >> ((~((i381 & iMediaBrowserCompatMediaBrowserImplApi216) | (i381 ^ iMediaBrowserCompatMediaBrowserImplApi216))) | i11));
                                int i383 = ~i8;
                                int i384 = ~i2;
                                i13 = i382 % (1002 / (~((i383 & i384) | (i383 ^ i384))));
                            } else {
                                int i385 = ~i8;
                                int i386 = i385 | i2;
                                int i387 = ~((i386 & iMediaBrowserCompatMediaBrowserImplApi216) | (i386 ^ iMediaBrowserCompatMediaBrowserImplApi216));
                                int i388 = -(-(((i11 & i387) | (i11 ^ i387)) * TypedValues.PositionType.TYPE_TRANSITION_EASING));
                                int i389 = ((i9 | i388) << 1) - (i9 ^ i388);
                                int i390 = (~((i385 & i10) | (i385 ^ i10))) * 1002;
                                i13 = (i390 | i389) + (i389 & i390);
                            }
                            BuildConfig.MediaBrowserCompatMediaBrowserImplApi216();
                            int i391 = ~i8;
                            int i392 = ~iMediaBrowserCompatMediaBrowserImplApi216;
                            int i393 = (i391 & i392) | (i391 ^ i392);
                            int i394 = TypedValues.PositionType.TYPE_TRANSITION_EASING * (~((i393 & i2) | (i393 ^ i2)));
                            int i395 = ((i13 | i394) << 1) - (i13 ^ i394);
                            int i396 = i395 << 13;
                            i14 = ((~i395) & i396) | ((~i396) & i395);
                            i15 = artificialFrame + 17;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i15 % 128;
                            if (i15 % 2 != 0) {
                                int i397 = i14 * 17;
                                int i398 = (i14 | i397) & (~(i14 & i397));
                                ((int[]) objArr3[2])[0] = i398 ^ (i398 << 4);
                                return objArr3;
                            }
                            int i399 = i14 ^ (i14 >>> 17);
                            int i400 = i399 << 5;
                            ((int[]) objArr3[2])[0] = ((~i399) & i400) | ((~i400) & i399);
                            return objArr3;
                        } catch (Throwable th4) {
                            fileReader3.close();
                            bufferedReader3.close();
                            throw th4;
                        }
                    }
                    int i401 = artificialFrame;
                    int i402 = (i401 & 3) + (i401 | 3);
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i402 % 128;
                    if (i402 % 2 != 0) {
                        try {
                            throw null;
                        } catch (Throwable th5) {
                            throw th5;
                        }
                    }
                } catch (Exception unused3) {
                }
                int i2910 = -(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                int iMediaBrowserCompatMediaBrowserImplApi2116 = BuildConfig.MediaBrowserCompatMediaBrowserImplApi216();
                int i2911 = i2910 * (-500);
                int i2912 = (i2911 ^ 1500583436) + ((i2911 & 1500583436) << 1);
                int i2913 = ~((-778682882) | i2910);
                int i2914 = ~i2910;
                int i2915 = (i2914 & 778682881) | (i2914 ^ 778682881);
                int i2916 = ~((i2915 & iMediaBrowserCompatMediaBrowserImplApi2116) | (i2915 ^ iMediaBrowserCompatMediaBrowserImplApi2116));
                int i2917 = -(-(((i2913 & i2916) | (i2913 ^ i2916)) * TypedValues.PositionType.TYPE_TRANSITION_EASING));
                int i3010 = ~i2910;
                int i3011 = (((i2912 | i2917) << 1) - (i2917 ^ i2912)) + ((~((-778682882) | i3010)) * 1002);
                int i3012 = ~iMediaBrowserCompatMediaBrowserImplApi2116;
                int i3013 = (~((i3010 & i3012) | (i3010 ^ i3012) | 778682881)) * TypedValues.PositionType.TYPE_TRANSITION_EASING;
                int i3014 = (i3011 ^ i3013) + ((i3013 & i3011) << 1);
                byte b7 = (byte) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1);
                int edgeSlop2 = (ViewConfiguration.getEdgeSlop() >> 16) - 40;
                short sMyTid3 = (short) (Process.myTid() >> 22);
                int i3015 = -(-(ViewConfiguration.getEdgeSlop() >> 16));
                int i3016 = ((i3015 | (-774076506)) << 1) - (i3015 ^ (-774076506));
                Object[] objArr19 = new Object[1];
                a(i3014, b7, edgeSlop2, sMyTid3, i3016, objArr19);
                file = new File((String) objArr19[0]);
                if (!file.canRead()) {
                    int i3017 = artificialFrame;
                    int i3018 = ((i3017 | 33) << 1) - (i3017 ^ 33);
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i3018 % 128;
                    int i3019 = i3018 % 2;
                } else {
                    fileReader = new FileReader(file);
                    bufferedReader = new BufferedReader(fileReader);
                    String line4 = bufferedReader.readLine();
                    int i3110 = -(ViewConfiguration.getLongPressTimeout() >> 16);
                    int iMediaBrowserCompatMediaBrowserImplApi2117 = BuildConfig.MediaBrowserCompatMediaBrowserImplApi216();
                    int i3111 = (i3110 * (-1335)) + 309560522;
                    int i3112 = (i3110 ^ iMediaBrowserCompatMediaBrowserImplApi2117) | (i3110 & iMediaBrowserCompatMediaBrowserImplApi2117);
                    int i3113 = ~i3112;
                    int i3114 = ((i3113 & (-778682883)) | ((-778682883) ^ i3113)) * (-668);
                    int i3115 = ~((iMediaBrowserCompatMediaBrowserImplApi2117 & (-778682883)) | ((-778682883) ^ iMediaBrowserCompatMediaBrowserImplApi2117));
                    int i3116 = (((i3111 | i3114) << 1) - (i3111 ^ i3114)) + (((i3110 & i3115) | (i3110 ^ i3115)) * 1336);
                    int i3117 = -(-((i3112 | (-778682883)) * 668));
                    int i3118 = ((i3116 | i3117) << 1) - (i3117 ^ i3116);
                    byte absoluteGravity2 = (byte) Gravity.getAbsoluteGravity(0, 0);
                    int i3119 = -(-(ViewConfiguration.getTapTimeout() >> 16));
                    int i3210 = (i3119 ^ (-70)) + ((i3119 & (-70)) << 1);
                    int threadPriority2 = Process.getThreadPriority(0);
                    int i3211 = -(-(threadPriority2 * (-518)));
                    int i3212 = ((-10360) & i3211) + (i3211 | (-10360));
                    int i3213 = ~i;
                    int i3214 = ~((i3213 & (-21)) | ((-21) ^ i3213));
                    int i3215 = ((i3214 & threadPriority2) | (threadPriority2 ^ i3214)) * 519;
                    int i3216 = (i3212 & i3215) + (i3215 | i3212);
                    int i3217 = ~i;
                    int i3218 = (i3217 & (-21)) | ((-21) ^ i3217);
                    int i3219 = (threadPriority2 ^ 20) | (threadPriority2 & 20);
                    int i3310 = ((~((i3218 & threadPriority2) | (i3218 ^ threadPriority2))) | (~((i3219 & i) | (i3219 ^ i)))) * (-519);
                    Object[] objArr110 = new Object[1];
                    a(i3118, absoluteGravity2, i3210, (short) (((((i3216 ^ i3310) + ((i3310 & i3216) << 1)) - (~(-(-(((~((threadPriority2 ^ i) | (threadPriority2 & i))) | 20) * 519))))) - 1) >> 6), (-774076476) - (Process.myTid() >> 22), objArr110);
                    zEquals = line4.equals((String) objArr110[0]);
                    fileReader.close();
                    bufferedReader.close();
                    if (zEquals) {
                        int i3311 = -TextUtils.indexOf((CharSequence) "", '0');
                        int i3312 = ~i3311;
                        int i3313 = ~((i3312 & 778682879) | (i3312 ^ 778682879));
                        int i3314 = ((-778682880) & i3311) | ((-778682880) ^ i3311);
                        int i3315 = ~((i3314 & i) | (i3314 ^ i));
                        int i3316 = ((i3311 * 477) - 507180069) + (((i3313 & i3315) | (i3313 ^ i3315)) * (-476)) + ((~(((-778682880) ^ i3311) | ((-778682880) & i3311) | i)) * 952);
                        int i3317 = ~i;
                        int i3318 = ((-778682880) & i3317) | ((-778682880) ^ i3317);
                        int i3319 = (~((i3311 & i3318) | (i3318 ^ i3311))) * 476;
                        int i3410 = (i3316 ^ i3319) + ((i3319 & i3316) << 1);
                        byte bCombineMeasuredStates2 = (byte) View.combineMeasuredStates(0, 0);
                        int i3411 = -(-(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                        short touchSlop2 = (short) (ViewConfiguration.getTouchSlop() >> 8);
                        int i3412 = -(-TextUtils.lastIndexOf("", '0', 0));
                        int i3413 = (i3412 ^ (-774076475)) + ((i3412 & (-774076475)) << 1);
                        Object[] objArr111 = new Object[1];
                        a(i3410, bCombineMeasuredStates2, ((i3411 | (-36)) << 1) - (i3411 ^ (-36)), touchSlop2, i3413, objArr111);
                        file2 = new File((String) objArr111[0]);
                        int i3414 = artificialFrame;
                        int i3415 = ((i3414 | 119) << 1) - (i3414 ^ 119);
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i3415 % 128;
                        int i3416 = i3415 % 2;
                        if (file2.canRead()) {
                            zEquals2 = false;
                        } else {
                            fileReader2 = new FileReader(file2);
                            bufferedReader2 = new BufferedReader(fileReader2);
                            String line5 = bufferedReader2.readLine();
                            int maximumDrawingCacheSize3 = 778682882 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                            byte bRed2 = (byte) Color.red(0);
                            int iIndexOf3 = TextUtils.indexOf("", "", 0, 0);
                            int i3417 = ((iIndexOf3 | (-70)) << 1) - (iIndexOf3 ^ (-70));
                            short keyRepeatDelay2 = (short) (ViewConfiguration.getKeyRepeatDelay() >> 16);
                            int i3418 = artificialFrame + b.f40o;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i3418 % 128;
                            int i3419 = i3418 % 2;
                            int offsetAfter3 = TextUtils.getOffsetAfter("", 0);
                            Object[] objArr112 = new Object[1];
                            a(maximumDrawingCacheSize3, bRed2, i3417, keyRepeatDelay2, (offsetAfter3 & (-774076476)) + (offsetAfter3 | (-774076476)), objArr112);
                            zEquals2 = line5.equals((String) objArr112[0]);
                            fileReader2.close();
                            int i3510 = artificialFrame;
                            int i3511 = (i3510 & 51) + (i3510 | 51);
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i3511 % 128;
                            int i3512 = i3511 % 2;
                            bufferedReader2.close();
                        }
                        if (!(!zEquals2)) {
                            int i3513 = artificialFrame;
                            int i3514 = ((i3513 | 49) << 1) - (i3513 ^ 49);
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i3514 % 128;
                            int i3515 = i3514 % 2;
                            Object[] objArr113 = {new int[]{i}, new int[]{(i & (-21)) | ((~i) & 20)}, new int[1], str};
                            int i3516 = ~((int) Runtime.getRuntime().totalMemory());
                            int i3517 = (-23324166) + ((~(i3516 | (-65))) * (-783)) + (((~(i3516 | 771463099)) | (-207160676)) * 783);
                            int iMediaBrowserCompatMediaBrowserImplApi2118 = BuildConfig.MediaBrowserCompatMediaBrowserImplApi216();
                            int i3518 = (-6097) - (~(i3517 * JfifUtil.MARKER_SOFn));
                            int i3519 = ((i3518 | 3247) << 1) - (i3518 ^ 3247);
                            int i3610 = -(-(((~((i3517 ^ iMediaBrowserCompatMediaBrowserImplApi2118) | (i3517 & iMediaBrowserCompatMediaBrowserImplApi2118))) | 16) * 191));
                            int i3611 = (i3519 & i3610) + (i3610 | i3519);
                            int i3612 = ~(((-17) & i3517) | ((-17) ^ i3517));
                            int i3613 = ~iMediaBrowserCompatMediaBrowserImplApi2118;
                            int i3614 = ~((i3613 & i3517) | (i3613 ^ i3517));
                            int i3615 = -(-(((i3614 & i3612) | (i3612 ^ i3614)) * 191));
                            int i3616 = ((i3611 | i3615) << 1) - (i3615 ^ i3611);
                            int i3617 = ((i2 | i3616) << 1) - (i3616 ^ i2);
                            int i3618 = i3617 << 13;
                            int i3619 = (i3617 | i3618) & (~(i3617 & i3618));
                            int i3710 = i3619 >>> 17;
                            int i3711 = ((~i3619) & i3710) | ((~i3710) & i3619);
                            ((int[]) objArr113[2])[0] = i3711 ^ (i3711 << 5);
                            return objArr113;
                        }
                    }
                }
            } catch (Exception unused4) {
            }
            str = null;
            int i3712 = artificialFrame + 13;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i3712 % 128;
            int i3713 = i3712 % 2;
            objArr3 = new Object[]{new int[]{i}, new int[]{i}, new int[1], null};
            int startElapsedRealtime3 = (int) Process.getStartElapsedRealtime();
            int i3714 = ~startElapsedRealtime3;
            int i3715 = (-1679982946) + ((~(357467915 | i3714)) * (-560)) + ((~(startElapsedRealtime3 | (-536875025))) * (-560)) + (((~(621155859 | i3714)) | 273187080) * 560);
            i8 = (i3715 << 1) - i3715;
            iMediaBrowserCompatMediaBrowserImplApi216 = BuildConfig.MediaBrowserCompatMediaBrowserImplApi216();
            int i3716 = artificialFrame;
            int i3717 = ((i3716 | 89) << 1) - (i3716 ^ 89);
            int i3718 = i3717 % 128;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i3718;
            int i3719 = i3717 % 2;
            i9 = ((i8 * (-500)) - (~(i2 * (-500)))) - 1;
            i10 = ~i2;
            i11 = ~(i10 | i8);
            i12 = i3718 + 43;
            artificialFrame = i12 % 128;
            if (i12 % 2 == 0) {
                int i3810 = ~i8;
                int i3811 = (i3810 & i2) | (i3810 ^ i2);
                int i3812 = i9 >>> (TypedValues.PositionType.TYPE_TRANSITION_EASING >> ((~((i3811 & iMediaBrowserCompatMediaBrowserImplApi216) | (i3811 ^ iMediaBrowserCompatMediaBrowserImplApi216))) | i11));
                int i3813 = ~i8;
                int i3814 = ~i2;
                i13 = i3812 % (1002 / (~((i3813 & i3814) | (i3813 ^ i3814))));
            } else {
                int i3815 = ~i8;
                int i3816 = i3815 | i2;
                int i3817 = ~((i3816 & iMediaBrowserCompatMediaBrowserImplApi216) | (i3816 ^ iMediaBrowserCompatMediaBrowserImplApi216));
                int i3818 = -(-(((i11 & i3817) | (i11 ^ i3817)) * TypedValues.PositionType.TYPE_TRANSITION_EASING));
                int i3819 = ((i9 | i3818) << 1) - (i9 ^ i3818);
                int i3910 = (~((i3815 & i10) | (i3815 ^ i10))) * 1002;
                i13 = (i3910 | i3819) + (i3819 & i3910);
            }
            BuildConfig.MediaBrowserCompatMediaBrowserImplApi216();
            int i3911 = ~i8;
            int i3912 = ~iMediaBrowserCompatMediaBrowserImplApi216;
            int i3913 = (i3911 & i3912) | (i3911 ^ i3912);
            int i3914 = TypedValues.PositionType.TYPE_TRANSITION_EASING * (~((i3913 & i2) | (i3913 ^ i2)));
            int i3915 = ((i13 | i3914) << 1) - (i13 ^ i3914);
            int i3916 = i3915 << 13;
            i14 = ((~i3915) & i3916) | ((~i3916) & i3915);
            i15 = artificialFrame + 17;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i15 % 128;
            if (i15 % 2 != 0) {
                int i3917 = i14 * 17;
                int i3918 = (i14 | i3917) & (~(i14 & i3917));
                ((int[]) objArr3[2])[0] = i3918 ^ (i3918 << 4);
                return objArr3;
            }
            int i3919 = i14 ^ (i14 >>> 17);
            int i403 = i3919 << 5;
            ((int[]) objArr3[2])[0] = ((~i3919) & i403) | ((~i403) & i3919);
            return objArr3;
        } catch (Throwable th6) {
            Throwable cause = th6.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th6;
        }
    }
}
