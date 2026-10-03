package com.google.android.gms.auth.api.signin;

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
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.Log;
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
import com.google.android.gms.auth.api.signin.internal.zbt;
import com.google.android.material.color.utilities.QuantizerCelebi;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.swmansion.gesturehandler.core.NativeViewGestureHandler;
import io.sentry.android.core.SentryLogcatAdapter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.io.encoding.Base64;
import net.pluservice.unicoc.R;
import o.ArtificialStackFrames;
import o.ICustomTabsCallback;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes4.dex */
public final class RevocationBoundService extends Service {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    private static byte[] ICustomTabsCallbackStubProxy;
    private static short[] ICustomTabsService;
    private static int artificialFrame;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static int getInterfaceDescriptor;
    private static int mayLaunchUrl;
    private static int onTransact;
    private static final byte[] $$c = {103, 5, 74, Ascii.SYN};
    private static final int $$f = 97;
    private static int $10 = 0;
    private static int $11 = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    /* JADX WARN: Code duplicated, block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0031). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(byte r6, int r7, short r8) {
        /*
            int r6 = r6 * 3
            int r0 = 1 - r6
            byte[] r1 = com.google.android.gms.auth.api.signin.RevocationBoundService.$$c
            int r7 = r7 * 3
            int r7 = 3 - r7
            int r8 = r8 * 5
            int r8 = r8 + 112
            byte[] r0 = new byte[r0]
            r2 = 0
            int r6 = 0 - r6
            if (r1 != 0) goto L18
            r3 = r7
            r4 = r2
            goto L31
        L18:
            r3 = r2
            r5 = r8
            r8 = r7
            r7 = r5
        L1c:
            byte r4 = (byte) r7
            r0[r3] = r4
            if (r3 != r6) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            return r6
        L27:
            int r8 = r8 + 1
            int r3 = r3 + 1
            r4 = r1[r8]
            r5 = r3
            r3 = r8
            r8 = r4
            r4 = r5
        L31:
            int r8 = -r8
            int r7 = r7 + r8
            r8 = r3
            r3 = r4
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.RevocationBoundService.$$g(byte, int, short):java.lang.String");
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
    private static void a(int r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = 112 - r7
            int r0 = r8 + 8
            byte[] r1 = com.google.android.gms.auth.api.signin.RevocationBoundService.$$a
            int r6 = r6 + 65
            byte[] r0 = new byte[r0]
            int r8 = r8 + 7
            r2 = 0
            if (r1 != 0) goto L13
            r3 = r7
            r7 = r8
            r4 = r2
            goto L2a
        L13:
            r3 = r2
        L14:
            byte r4 = (byte) r6
            r0[r3] = r4
            if (r3 != r8) goto L21
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L21:
            int r3 = r3 + 1
            r4 = r1[r7]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r5
        L2a:
            int r6 = -r6
            int r6 = r6 + r7
            int r7 = r3 + 1
            r3 = r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.RevocationBoundService.a(int, int, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0025). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void c(byte r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = 763 - r7
            int r6 = 111 - r6
            int r8 = 82 - r8
            byte[] r0 = com.google.android.gms.auth.api.signin.RevocationBoundService.$$d
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L11
            r3 = r6
            r6 = r8
            r4 = r2
            goto L25
        L11:
            r3 = r2
        L12:
            int r7 = r7 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r6
            r1[r3] = r5
            if (r4 != r8) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L23:
            r3 = r0[r7]
        L25:
            int r6 = r6 + r3
            int r6 = r6 + (-5)
            r3 = r4
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.RevocationBoundService.c(byte, int, int, java.lang.Object[]):void");
    }

    @Override // android.app.Service
    public IBinder onBind(@NonNull Intent intent) {
        if (!"com.google.android.gms.auth.api.signin.RevocationBoundService.disconnect".equals(intent.getAction()) && !"com.google.android.gms.auth.api.signin.RevocationBoundService.clearClientState".equals(intent.getAction())) {
            SentryLogcatAdapter.w("RevocationService", "Unknown action sent to RevocationBoundService: ".concat(String.valueOf(intent.getAction())));
            return null;
        }
        if (Log.isLoggable("RevocationService", 2)) {
            Log.v("RevocationService", "RevocationBoundService handling ".concat(String.valueOf(intent.getAction())));
        }
        return new zbt(this);
    }

    private static void b(int i, byte b, int i2, short s, int i3, Object[] objArr) throws Throwable {
        long j;
        boolean z;
        int i4 = 2;
        int i5 = 2 % 2;
        ICustomTabsCallback iCustomTabsCallback = new ICustomTabsCallback();
        StringBuilder sb = new StringBuilder();
        try {
            Object[] objArr2 = {Integer.valueOf(i2), Integer.valueOf(mayLaunchUrl)};
            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1991297565);
            float f = 0.0f;
            if (objAccessartificialFrame == null) {
                byte b2 = (byte) 0;
                byte b3 = b2;
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(40 - Gravity.getAbsoluteGravity(0, 0), (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 36240), 2342 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 371880939, false, $$g(b2, b3, b3), new Class[]{Integer.TYPE, Integer.TYPE});
            }
            int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
            boolean z2 = iIntValue == -1;
            if (z2) {
                byte[] bArr = ICustomTabsCallbackStubProxy;
                if (bArr != null) {
                    int length = bArr.length;
                    byte[] bArr2 = new byte[length];
                    int i6 = 0;
                    while (i6 < length) {
                        int i7 = $11 + 35;
                        $10 = i7 % 128;
                        int i8 = i7 % i4;
                        Object[] objArr3 = {Integer.valueOf(bArr[i6])};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1557994855);
                        if (objAccessartificialFrame2 == null) {
                            int tapTimeout = 44 - (ViewConfiguration.getTapTimeout() >> 16);
                            char cNormalizeMetaState = (char) KeyEvent.normalizeMetaState(0);
                            int i9 = 1216 - (AudioTrack.getMaxVolume() > f ? 1 : (AudioTrack.getMaxVolume() == f ? 0 : -1));
                            byte b4 = (byte) 0;
                            byte b5 = b4;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(tapTimeout, cNormalizeMetaState, i9, 1011328145, false, $$g(b4, b5, (byte) (b5 + 1)), new Class[]{Integer.TYPE});
                        }
                        bArr2[i6] = ((Byte) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).byteValue();
                        i6++;
                        i4 = 2;
                        f = 0.0f;
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
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(40 - KeyEvent.keyCodeFromString(""), (char) (36242 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), (ViewConfiguration.getPressedStateDuration() >> 16) + 2342, 371880939, false, $$g(b6, b7, b7), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    iIntValue = (byte) (((byte) (((long) bArr3[((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue()]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                    int i10 = $10 + 53;
                    $11 = i10 % 128;
                    if (i10 % 2 == 0) {
                        int i11 = 2 % 3;
                    }
                    j = -4629754035390455669L;
                } else {
                    j = -4629754035390455669L;
                    iIntValue = (short) (((short) (((long) ICustomTabsService[i3 + ((int) (((long) onTransact) ^ (-4629754035390455669L)))]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                }
            } else {
                j = -4629754035390455669L;
            }
            if (iIntValue > 0) {
                iCustomTabsCallback.c = ((i3 + iIntValue) - 2) + ((int) (((long) onTransact) ^ j)) + (!(z2 ^ true) ? 1 : 0);
                Object[] objArr5 = {iCustomTabsCallback, Integer.valueOf(i), Integer.valueOf(getInterfaceDescriptor), sb};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(216546027);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(View.MeasureSpec.makeMeasureSpec(0, 0) + 41, (char) Color.blue(0), 4066 - Drawable.resolveOpacity(0, 0), -1819443997, false, "x", new Class[]{Object.class, Integer.TYPE, Integer.TYPE, Object.class});
                }
                ((StringBuilder) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).append(iCustomTabsCallback.createConnectionCallback);
                iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                byte[] bArr4 = ICustomTabsCallbackStubProxy;
                if (bArr4 != null) {
                    int length2 = bArr4.length;
                    byte[] bArr5 = new byte[length2];
                    int i12 = 0;
                    while (i12 < length2) {
                        int i13 = $10 + 113;
                        $11 = i13 % 128;
                        if (i13 % 2 == 0) {
                            bArr5[i12] = (byte) (((long) bArr4[i12]) % (-4629754035390455669L));
                        } else {
                            bArr5[i12] = (byte) (((long) bArr4[i12]) ^ (-4629754035390455669L));
                            i12++;
                        }
                    }
                    bArr4 = bArr5;
                }
                if (bArr4 != null) {
                    z = true;
                } else {
                    int i14 = $11 + 3;
                    $10 = i14 % 128;
                    int i15 = i14 % 2;
                    z = false;
                }
                iCustomTabsCallback.a = 1;
                while (iCustomTabsCallback.a < iIntValue) {
                    if (z) {
                        byte[] bArr6 = ICustomTabsCallbackStubProxy;
                        int i16 = iCustomTabsCallback.c;
                        iCustomTabsCallback.c = i16 - 1;
                        iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((byte) (((byte) (((long) bArr6[i16]) ^ (-4629754035390455669L))) + s)) ^ b));
                    } else {
                        short[] sArr = ICustomTabsService;
                        int i17 = iCustomTabsCallback.c;
                        iCustomTabsCallback.c = i17 - 1;
                        iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((short) (((short) (((long) sArr[i17]) ^ (-4629754035390455669L))) + s)) ^ b));
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

    /* JADX WARN: Code duplicated, block: B:13:0x0227  */
    /* JADX WARN: Code duplicated, block: B:16:0x033f A[Catch: all -> 0x0e2a, TryCatch #0 {all -> 0x0e2a, blocks: (B:51:0x0a50, B:53:0x0a64, B:54:0x0a94, B:14:0x031f, B:16:0x033f, B:17:0x038c), top: B:91:0x031f }] */
    /* JADX WARN: Code duplicated, block: B:20:0x039e  */
    /* JADX WARN: Code duplicated, block: B:25:0x054a  */
    /* JADX WARN: Code duplicated, block: B:50:0x0936  */
    /* JADX WARN: Code duplicated, block: B:53:0x0a64 A[Catch: all -> 0x0e2a, TryCatch #0 {all -> 0x0e2a, blocks: (B:51:0x0a50, B:53:0x0a64, B:54:0x0a94, B:14:0x031f, B:16:0x033f, B:17:0x038c), top: B:91:0x031f }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0aaa  */
    /* JADX WARN: Code duplicated, block: B:62:0x0c51  */
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
        super.attachBaseContext(context);
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame7 == null) {
            int iIndexOf = 24 - TextUtils.indexOf((CharSequence) "", '0', 0);
            char c = (char) (30069 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
            int iIndexOf2 = TextUtils.indexOf("", "", 0) + 816;
            Object[] objArr2 = new Object[1];
            a((byte) ($$b | 8), (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, $$a[5], objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iIndexOf, c, iIndexOf2, 721586079, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            int i2 = artificialFrame + 31;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
            int i3 = i2 % 2;
            long j2 = j + 1902;
            Object[] objArr3 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 1767076794, (byte) (Color.green(0) + 54), (-20) - TextUtils.indexOf("", "", 0, 0), (short) ((-1) - TextUtils.lastIndexOf("", '0')), (-1862024204) - TextUtils.getOffsetAfter("", 0), objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1767076821, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 71), Color.green(0) - 20, (short) View.resolveSize(0, 0), (-1862024183) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame8 == null) {
                    int packedPositionGroup = ExpandableListView.getPackedPositionGroup(0L) + 25;
                    char minimumFlingVelocity = (char) ((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 30068);
                    int defaultSize = View.getDefaultSize(0, 0) + 816;
                    Object[] objArr5 = new Object[1];
                    a((byte) ($$b | 8), (byte) 100, $$a[5], objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(packedPositionGroup, minimumFlingVelocity, defaultSize, 891606461, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i4 = ((int[]) objArr6[0])[0];
                int i5 = ((int[]) objArr6[1])[0];
                String[] strArr = (String[]) objArr6[2];
                int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) + 678157425;
                int i6 = 280225672 + ((~((~iCodePointAt) | (-46137346))) * 433) + (((~(183513219 | iCodePointAt)) | (-381685586)) * (-433)) + (((~(iCodePointAt | (-381685586))) | 137375874) * 433) + 14240247;
                int i7 = (i6 << 13) ^ i6;
                int i8 = i7 ^ (i7 >>> 17);
                ((int[]) objArr[3])[0] = i8 ^ (i8 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                b((-1767076780) - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (byte) (81 - (ViewConfiguration.getTouchSlop() >> 8)), (-19) - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (short) Color.blue(0), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1862024202, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1767076817, (byte) ((-12) - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), Drawable.resolveOpacity(0, 0) - 20, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 21), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 1862024187, objArr8);
                try {
                    Object[] objArr9 = {Integer.valueOf(((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue()), 0, 14240247};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame == null) {
                        int keyRepeatDelay = 25 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                        char cArgb = (char) (Color.argb(0, 0, 0, 0) + 30068);
                        int edgeSlop = (ViewConfiguration.getEdgeSlop() >> 16) + 816;
                        byte[] bArr = $$a;
                        Object[] objArr10 = new Object[1];
                        a(bArr[35], (byte) 92, bArr[47], objArr10);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(keyRepeatDelay, cArgb, edgeSlop, -797394565, false, (String) objArr10[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr9);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame2 == null) {
                        int fadingEdgeLength = (ViewConfiguration.getFadingEdgeLength() >> 16) + 25;
                        char offsetBefore = (char) (TextUtils.getOffsetBefore("", 0) + 30068);
                        int keyRepeatTimeout = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 816;
                        Object[] objArr11 = new Object[1];
                        a((byte) ($$b | 8), (byte) 100, $$a[5], objArr11);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength, offsetBefore, keyRepeatTimeout, 891606461, false, (String) objArr11[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArr);
                    try {
                        Object[] objArr12 = new Object[1];
                        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 1767076839, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) + 18), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 55, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) - 37), (-1862024204) - (ViewConfiguration.getJumpTapTimeout() >> 16), objArr12);
                        Class<?> cls3 = Class.forName((String) objArr12[0]);
                        Object[] objArr13 = new Object[1];
                        b((-1767076786) - Color.green(0), (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 56), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 55, (short) ((-1) - TextUtils.lastIndexOf("", '0', 0)), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(4) - 1862024294, objArr13);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr13[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame3 == null) {
                            int i9 = 26 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                            char cIndexOf = (char) (30067 - TextUtils.indexOf((CharSequence) "", '0', 0));
                            int i10 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 817;
                            Object[] objArr14 = new Object[1];
                            a((byte) ($$b | 8), (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, $$a[5], objArr14);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i9, cIndexOf, i10, 721586079, false, (String) objArr14[0], null);
                        }
                        ((Field) objAccessartificialFrame3).set(null, lValueOf);
                        int i11 = getARTIFICIAL_FRAME_PACKAGE_NAME + 63;
                        artificialFrame = i11 % 128;
                        int i12 = i11 % 2;
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
            b((-1767076780) - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (byte) (81 - (ViewConfiguration.getTouchSlop() >> 8)), (-19) - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (short) Color.blue(0), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1862024202, objArr15);
            Class<?> cls4 = Class.forName((String) objArr15[0]);
            Object[] objArr16 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1767076817, (byte) ((-12) - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), Drawable.resolveOpacity(0, 0) - 20, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 21), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 1862024187, objArr16);
            Object[] objArr17 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue()), 0, 14240247};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame == null) {
                int keyRepeatDelay2 = 25 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                char cArgb2 = (char) (Color.argb(0, 0, 0, 0) + 30068);
                int edgeSlop2 = (ViewConfiguration.getEdgeSlop() >> 16) + 816;
                byte[] bArr2 = $$a;
                Object[] objArr18 = new Object[1];
                a(bArr2[35], (byte) 92, bArr2[47], objArr18);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(keyRepeatDelay2, cArgb2, edgeSlop2, -797394565, false, (String) objArr18[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr17);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame2 == null) {
                int fadingEdgeLength2 = (ViewConfiguration.getFadingEdgeLength() >> 16) + 25;
                char offsetBefore2 = (char) (TextUtils.getOffsetBefore("", 0) + 30068);
                int keyRepeatTimeout2 = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 816;
                Object[] objArr19 = new Object[1];
                a((byte) ($$b | 8), (byte) 100, $$a[5], objArr19);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength2, offsetBefore2, keyRepeatTimeout2, 891606461, false, (String) objArr19[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArr);
            Object[] objArr110 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 1767076839, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) + 18), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 55, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) - 37), (-1862024204) - (ViewConfiguration.getJumpTapTimeout() >> 16), objArr110);
            Class<?> cls5 = Class.forName((String) objArr110[0]);
            Object[] objArr111 = new Object[1];
            b((-1767076786) - Color.green(0), (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 56), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 55, (short) ((-1) - TextUtils.lastIndexOf("", '0', 0)), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(4) - 1862024294, objArr111);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr111[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame3 == null) {
                int i13 = 26 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                char cIndexOf2 = (char) (30067 - TextUtils.indexOf((CharSequence) "", '0', 0));
                int i14 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 817;
                Object[] objArr112 = new Object[1];
                a((byte) ($$b | 8), (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, $$a[5], objArr112);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i13, cIndexOf2, i14, 721586079, false, (String) objArr112[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
            int i15 = getARTIFICIAL_FRAME_PACKAGE_NAME + 63;
            artificialFrame = i15 % 128;
            int i16 = i15 % 2;
        }
        int i17 = ((int[]) objArr[1])[0];
        int i18 = ((int[]) objArr[0])[0];
        if (i18 == i17) {
            Object[] objArr20 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i19 = ((int[]) objArr[3])[0];
            int i20 = ((int[]) objArr[0])[0];
            int i21 = ((int[]) objArr[1])[0];
            String[] strArr2 = (String[]) objArr[2];
            int iIdentityHashCode = System.identityHashCode(this);
            int i22 = i19 + (-1300192843) + ((267398994 | iIdentityHashCode) * 376) + (((~((~iIdentityHashCode) | 769804093)) | 34613314) * (-376)) + (((~(iIdentityHashCode | (-769804094))) | (-571631728)) * 376);
            int i23 = (i22 << 13) ^ i22;
            int i24 = i23 ^ (i23 >>> 17);
            ((int[]) objArr20[3])[0] = i24 ^ (i24 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr[2];
            if (strArr3 != null) {
                int i25 = artificialFrame + 37;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i25 % 128;
                int i26 = i25 % 2;
                for (String str : strArr3) {
                    arrayList.add(str);
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf((((long) 828228893) << 32) ^ ((long) (i17 ^ i18))), Long.valueOf(828228892)};
                byte[] bArr3 = $$d;
                Object[] objArr22 = new Object[1];
                c(bArr3[16], (short) 760, bArr3[164], objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                c(bArr3[21], (short) 722, bArr3[722], objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i27 = ((int[]) objArr[3])[0];
                int i28 = ((int[]) objArr[0])[0];
                int i29 = ((int[]) objArr[1])[0];
                String[] strArr4 = (String[]) objArr[2];
                int i30 = ~((int) Runtime.getRuntime().freeMemory());
                int i31 = i27 + (-1683492082) + (((~(572382953 | i30)) | (-770555320)) * (-983)) + (((~(i30 | (-770555320))) | 537762977) * 983);
                int i32 = (i31 << 13) ^ i31;
                int i33 = i32 ^ (i32 >>> 17);
                ((int[]) objArr24[3])[0] = i33 ^ (i33 << 5);
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
            int capsMode = TextUtils.getCapsMode("", 0, 0) + 26;
            char edgeSlop3 = (char) (ViewConfiguration.getEdgeSlop() >> 16);
            int i34 = 1042 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
            Object[] objArr25 = new Object[1];
            a((byte) ($$b | 8), (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, $$a[5], objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(capsMode, edgeSlop3, i34, 2061780482, false, (String) objArr25[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j3 != -1) {
            long j4 = j3 + 1990;
            Object[] objArr26 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 1767076811, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 33), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 55, (short) Gravity.getAbsoluteGravity(0, 0), ImageFormat.getBitsPerPixel(0) - 1862024203, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(5) - 1767076894, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(2) - 151), (-20) - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 49), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1862024217, objArr27);
            if (j4 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame10 == null) {
                    int iArgb = 26 - Color.argb(0, 0, 0, 0);
                    char cKeyCodeFromString = (char) KeyEvent.keyCodeFromString("");
                    int iMakeMeasureSpec = 1041 - View.MeasureSpec.makeMeasureSpec(0, 0);
                    Object[] objArr28 = new Object[1];
                    a((byte) ($$b | 8), (byte) 100, $$a[5], objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iArgb, cKeyCodeFromString, iMakeMeasureSpec, 1145017376, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i35 = ((int[]) objArr29[3])[0];
                int i36 = ((int[]) objArr29[2])[0];
                String[] strArr5 = (String[]) objArr29[0];
                int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
                int i37 = ~startElapsedRealtime;
                int i38 = ((((-1106067862) + (((~(374888332 | i37)) | (~((-452992140) | startElapsedRealtime))) * 1900)) + (((~(i37 | 452992139)) | (~(startElapsedRealtime | (-374888333)))) * (-950))) + (((~(startElapsedRealtime | 452992139)) | (~(i37 | (-374888333)))) * 950)) - 1520170449;
                int i39 = (i38 << 13) ^ i38;
                int i40 = i39 ^ (i39 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i40 ^ (i40 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                b(TextUtils.getOffsetAfter("", 0) - 1767076781, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 45), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 24, (short) TextUtils.indexOf("", ""), (-1862024167) - TextUtils.getOffsetBefore("", 0), objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1767076817, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 49), TextUtils.getCapsMode("", 0, 0) - 20, (short) KeyEvent.keyCodeFromString(""), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1862024186, objArr31);
                int iIntValue = ((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue();
                Object[] objArr32 = {-2018094028};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getLongPressTimeout() >> 16) + 8, (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 22250), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 1032, 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = QuantizerCelebi.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr32), -1520170449, false);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame5 == null) {
                    int maximumFlingVelocity = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 26;
                    char cIndexOf3 = (char) TextUtils.indexOf("", "");
                    int iResolveSize = 1041 - View.resolveSize(0, 0);
                    Object[] objArr33 = new Object[1];
                    a((byte) ($$b | 8), (byte) 100, $$a[5], objArr33);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity, cIndexOf3, iResolveSize, 1145017376, false, (String) objArr33[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Object[] objArr34 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(2) - 1767076906, (byte) (54 - View.getDefaultSize(0, 0)), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 69, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1862024239, objArr34);
                    Class<?> cls9 = Class.forName((String) objArr34[0]);
                    Object[] objArr35 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1767076821, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 70), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 135, (short) TextUtils.getTrimmedLength(""), (-1862024182) - ExpandableListView.getPackedPositionType(0L), objArr35);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr35[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame6 == null) {
                        int i41 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 26;
                        char capsMode2 = (char) TextUtils.getCapsMode("", 0, 0);
                        int scrollDefaultDelay = 1041 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                        Object[] objArr36 = new Object[1];
                        a((byte) ($$b | 8), (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, $$a[5], objArr36);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i41, capsMode2, scrollDefaultDelay, 2061780482, false, (String) objArr36[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                    int i42 = getARTIFICIAL_FRAME_PACKAGE_NAME + 31;
                    artificialFrame = i42 % 128;
                    int i43 = i42 % 2;
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr37 = new Object[1];
            b(TextUtils.getOffsetAfter("", 0) - 1767076781, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 45), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 24, (short) TextUtils.indexOf("", ""), (-1862024167) - TextUtils.getOffsetBefore("", 0), objArr37);
            Class<?> cls10 = Class.forName((String) objArr37[0]);
            Object[] objArr38 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1767076817, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 49), TextUtils.getCapsMode("", 0, 0) - 20, (short) KeyEvent.keyCodeFromString(""), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1862024186, objArr38);
            int iIntValue2 = ((Integer) cls10.getMethod((String) objArr38[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr39 = {-2018094028};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getLongPressTimeout() >> 16) + 8, (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 22250), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 1032, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = QuantizerCelebi.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr39), -1520170449, false);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame5 == null) {
                int maximumFlingVelocity2 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 26;
                char cIndexOf4 = (char) TextUtils.indexOf("", "");
                int iResolveSize2 = 1041 - View.resolveSize(0, 0);
                Object[] objArr310 = new Object[1];
                a((byte) ($$b | 8), (byte) 100, $$a[5], objArr310);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity2, cIndexOf4, iResolveSize2, 1145017376, false, (String) objArr310[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr311 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(2) - 1767076906, (byte) (54 - View.getDefaultSize(0, 0)), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 69, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1862024239, objArr311);
            Class<?> cls11 = Class.forName((String) objArr311[0]);
            Object[] objArr312 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1767076821, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 70), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 135, (short) TextUtils.getTrimmedLength(""), (-1862024182) - ExpandableListView.getPackedPositionType(0L), objArr312);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr312[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame6 == null) {
                int i44 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 26;
                char capsMode3 = (char) TextUtils.getCapsMode("", 0, 0);
                int scrollDefaultDelay2 = 1041 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                Object[] objArr313 = new Object[1];
                a((byte) ($$b | 8), (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, $$a[5], objArr313);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i44, capsMode3, scrollDefaultDelay2, 2061780482, false, (String) objArr313[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
            int i45 = getARTIFICIAL_FRAME_PACKAGE_NAME + 31;
            artificialFrame = i45 % 128;
            int i46 = i45 % 2;
        }
        int i47 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i48 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i48 == i47) {
            Object[] objArr40 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i49 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i50 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i51 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr6 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
            int i52 = i49 + (-1424951024) + (((~((-138955009) | iElapsedRealtime)) | (~((-60851202) | iElapsedRealtime))) * 69) + (((~(iElapsedRealtime | (-665884278))) | (~((-743988085) | iElapsedRealtime)) | 605033076) * (-69)) + 300664114;
            int i53 = (i52 << 13) ^ i52;
            int i54 = i53 ^ (i53 >>> 17);
            ((int[]) objArr40[1])[0] = i54 ^ (i54 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        if (strArr7 != null) {
            for (String str2 : strArr7) {
                arrayList2.add(str2);
            }
        }
        Object[] objArr41 = {Long.valueOf(((long) (i47 ^ i48)) ^ (((long) 704172995) << 32)), Long.valueOf(704172993)};
        byte[] bArr4 = $$d;
        byte b = bArr4[19];
        Object[] objArr42 = new Object[1];
        c(b, (short) (b | 720), bArr4[77], objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        Object[] objArr43 = new Object[1];
        c(bArr4[21], (short) 722, bArr4[722], objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {strArr, new int[1], new int[]{i}, new int[]{i}};
        int i55 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
        int i56 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        int i57 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        String[] strArr8 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        int i58 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenWidthDp;
        int i59 = ~i58;
        int i60 = i55 + (-1106067862) + (((~((-47653333) | i59)) | (~((-30450475) | i58))) * 1900) + (((~(i59 | 30450474)) | (~(i58 | 47653332))) * (-950)) + (((~(i58 | 30450474)) | (~(i59 | 47653332))) * 950);
        int i61 = (i60 << 13) ^ i60;
        int i62 = i61 ^ (i61 >>> 17);
        ((int[]) objArr44[1])[0] = i62 ^ (i62 << 5);
    }

    @Override // android.app.Service
    public void onCreate() throws Throwable {
        Object[] objArr;
        int i;
        Object[] objArr2;
        int i2;
        Object[] objArr3;
        int i3;
        Object[] objArr4;
        char c;
        int i4;
        Object[] objArr5;
        int i5;
        Object[] objArr6;
        int i6;
        Object[] objArr7;
        int i7;
        Object[] objArr8;
        int i8 = 2 % 2;
        Object[] objArr9 = new Object[1];
        b((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1767076791, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 50), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 69, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) - 37), (-1862024204) - Drawable.resolveOpacity(0, 0), objArr9);
        String str = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 1767076835, (byte) ((-36) - MotionEvent.axisFromString("")), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 55, (short) TextUtils.indexOf("", ""), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1862024217, objArr10);
        String str2 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        b((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) - 1767076781, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 60), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 24, (short) Color.blue(0), KeyEvent.normalizeMetaState(0) - 1862024167, objArr11);
        String str3 = (String) objArr11[0];
        Object[] objArr12 = new Object[1];
        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1767076817, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) - 50), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(18) - 119, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 21), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 1862024200, objArr12);
        String str4 = (String) objArr12[0];
        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame == null) {
            int iMyPid = (Process.myPid() >> 22) + 25;
            char scrollBarFadeDuration = (char) (30068 - (ViewConfiguration.getScrollBarFadeDuration() >> 16));
            int i9 = 816 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
            Object[] objArr13 = new Object[1];
            a((byte) ($$b | 8), (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, $$a[5], objArr13);
            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iMyPid, scrollBarFadeDuration, i9, 721586079, false, (String) objArr13[0], null);
        }
        long j = ((Field) objAccessartificialFrame).getLong(null);
        if (j == -1 || j + 1851 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            try {
                Object[] objArr14 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1787736448};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame2 == null) {
                    int offsetBefore = TextUtils.getOffsetBefore("", 0) + 25;
                    char c2 = (char) (30069 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
                    int i10 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 815;
                    byte[] bArr = $$a;
                    Object[] objArr15 = new Object[1];
                    a(bArr[35], (byte) 92, bArr[47], objArr15);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(offsetBefore, c2, i10, -797394565, false, (String) objArr15[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                Object[] objArr16 = (Object[]) ((Method) objAccessartificialFrame2).invoke(null, objArr14);
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame3 == null) {
                    int offsetBefore2 = TextUtils.getOffsetBefore("", 0) + 25;
                    char pressedStateDuration = (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 30068);
                    int defaultSize = View.getDefaultSize(0, 0) + 816;
                    Object[] objArr17 = new Object[1];
                    a((byte) ($$b | 8), (byte) 100, $$a[5], objArr17);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(offsetBefore2, pressedStateDuration, defaultSize, 891606461, false, (String) objArr17[0], null);
                }
                ((Field) objAccessartificialFrame3).set(null, objArr16);
                try {
                    Long lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame4 == null) {
                        int mirror = 'I' - AndroidCharacter.getMirror('0');
                        char cNormalizeMetaState = (char) (30068 - KeyEvent.normalizeMetaState(0));
                        int iGreen = 816 - Color.green(0);
                        Object[] objArr18 = new Object[1];
                        a((byte) ($$b | 8), (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, $$a[5], objArr18);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(mirror, cNormalizeMetaState, iGreen, 721586079, false, (String) objArr18[0], null);
                    }
                    ((Field) objAccessartificialFrame4).set(null, lValueOf);
                    objArr = objArr16;
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
            int i11 = getARTIFICIAL_FRAME_PACKAGE_NAME + 7;
            artificialFrame = i11 % 128;
            int i12 = i11 % 2;
            Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame5 == null) {
                int modifierMetaStateMask = ((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.SUB;
                char threadPriority = (char) (((Process.getThreadPriority(0) + 20) >> 6) + 30068);
                int iNormalizeMetaState = 816 - KeyEvent.normalizeMetaState(0);
                Object[] objArr19 = new Object[1];
                a((byte) ($$b | 8), (byte) 100, $$a[5], objArr19);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask, threadPriority, iNormalizeMetaState, 891606461, false, (String) objArr19[0], null);
            }
            Object[] objArr20 = (Object[]) ((Field) objAccessartificialFrame5).get(null);
            objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i13 = ((int[]) objArr20[0])[0];
            int i14 = ((int[]) objArr20[1])[0];
            String[] strArr = (String[]) objArr20[2];
            int i15 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().navigationHidden;
            int i16 = ~i15;
            int i17 = (-720468400) + (((~(73731444 | i16)) | 271903810) * 226) + (((~(i16 | 343272822)) | 2362432 | (~((-271903811) | i15))) * (-113)) + ((~(i15 | 73731444)) * 113) + 1787736448;
            int i18 = (i17 << 13) ^ i17;
            int i19 = i18 ^ (i18 >>> 17);
            ((int[]) objArr[3])[0] = i19 ^ (i19 << 5);
        }
        int i20 = ((int[]) objArr[1])[0];
        int i21 = ((int[]) objArr[0])[0];
        if (i21 == i20) {
            Object[] objArr21 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i22 = ((int[]) objArr[3])[0];
            int i23 = ((int[]) objArr[0])[0];
            int i24 = ((int[]) objArr[1])[0];
            String[] strArr2 = (String[]) objArr[2];
            int i25 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenLayout;
            int i26 = ~i25;
            int i27 = i22 + (-2075947801) + (((~((-198189135) | i25)) | (~(i26 | (-805327793))) | 16768) * 717) + (((~(i25 | (-805327793))) | (~((-198189135) | i26)) | 16768) * 717);
            int i28 = (i27 << 13) ^ i27;
            int i29 = i28 ^ (i28 >>> 17);
            ((int[]) objArr21[3])[0] = i29 ^ (i29 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr[2];
            if (strArr3 != null) {
                for (String str5 : strArr3) {
                    arrayList.add(str5);
                }
            }
            try {
                Object[] objArr22 = {Long.valueOf(((long) (i20 ^ i21)) ^ (((long) (-829663158)) << 32)), Long.valueOf(-829663157)};
                byte[] bArr2 = $$d;
                Object[] objArr23 = new Object[1];
                c(bArr2[16], (short) 666, bArr2[19], objArr23);
                Class<?> cls = Class.forName((String) objArr23[0]);
                Object[] objArr24 = new Object[1];
                c(bArr2[21], (short) 722, bArr2[722], objArr24);
                cls.getMethod((String) objArr24[0], Long.TYPE, Long.TYPE).invoke(null, objArr22);
                Object[] objArr25 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i30 = ((int[]) objArr[3])[0];
                int i31 = ((int[]) objArr[0])[0];
                int i32 = ((int[]) objArr[1])[0];
                String[] strArr4 = (String[]) objArr[2];
                int iIdentityHashCode = System.identityHashCode(this);
                int i33 = ~iIdentityHashCode;
                int i34 = ~(142380207 | i33);
                int i35 = i30 + (-1322976379) + ((50549264 | i34) * (-712)) + (((~(iIdentityHashCode | 192929471)) | (~(i33 | (-50549265)))) * (-712)) + (((-55792159) | i34) * 712);
                int i36 = (i35 << 13) ^ i35;
                int i37 = i36 ^ (i36 >>> 17);
                ((int[]) objArr25[3])[0] = i37 ^ (i37 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame6 == null) {
            int fadingEdgeLength = 30 - (ViewConfiguration.getFadingEdgeLength() >> 16);
            char cKeyCodeFromString = (char) (KeyEvent.keyCodeFromString("") + 49362);
            int iIndexOf = 683 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
            Object[] objArr26 = new Object[1];
            a((byte) 45, (byte) 81, (byte) (-$$a[4]), objArr26);
            objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength, cKeyCodeFromString, iIndexOf, 508509282, false, (String) objArr26[0], null);
        }
        long j2 = ((Field) objAccessartificialFrame6).getLong(null);
        if (j2 == -1 || j2 + 1882 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                int i38 = ((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1767076825;
                byte b = (byte) (121 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                int iResolveSize = View.resolveSize(0, 0) - 20;
                short sCodePointAt = (short) (((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 49);
                int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(20) - 1862024234;
                Object[] objArr27 = new Object[1];
                b(i38, b, iResolveSize, sCodePointAt, iCodePointAt, objArr27);
                Class<?> cls2 = Class.forName((String) objArr27[0]);
                Object[] objArr28 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 1767076837, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 2), (-20) - View.MeasureSpec.makeMeasureSpec(0, 0), (short) (KeyEvent.getMaxKeyCode() >> 16), ((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(7) - 1862024224, objArr28);
                baseContext = (Context) cls2.getMethod((String) objArr28[0], new Class[0]).invoke(null, null);
                int i39 = artificialFrame + 97;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i39 % 128;
                i = 2;
                int i40 = i39 % 2;
            } else {
                i = 2;
            }
            if (baseContext != null) {
                int i41 = getARTIFICIAL_FRAME_PACKAGE_NAME + 9;
                artificialFrame = i41 % 128;
                int i42 = i41 % i;
                baseContext = (!((baseContext instanceof ContextWrapper) ^ true) && ((ContextWrapper) baseContext).getBaseContext() == null) ? null : baseContext.getApplicationContext();
            }
            try {
                Object[] objArr29 = {baseContext, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 320936420};
                byte[] bArr3 = $$d;
                byte b2 = bArr3[16];
                Object[] objArr30 = new Object[1];
                c(b2, (short) 585, b2, objArr30);
                Class<?> cls3 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                c(bArr3[65], (short) 516, bArr3[271], objArr31);
                objArr2 = (Object[]) cls3.getMethod((String) objArr31[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr29);
                if (baseContext != null) {
                    Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(777251007);
                    if (objAccessartificialFrame7 == null) {
                        int iCombineMeasuredStates = View.combineMeasuredStates(0, 0) + 30;
                        char mode = (char) (View.MeasureSpec.getMode(0) + 49362);
                        int maximumDrawingCacheSize = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 684;
                        Object[] objArr32 = new Object[1];
                        a((byte) $$b, (byte) 69, (byte) ($$a[5] - 1), objArr32);
                        objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates, mode, maximumDrawingCacheSize, -1321816393, false, (String) objArr32[0], null);
                    }
                    ((Field) objAccessartificialFrame7).set(null, objArr2);
                    try {
                        Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                        if (objAccessartificialFrame8 == null) {
                            int i43 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 29;
                            char cBlue = (char) (49362 - Color.blue(0));
                            int offsetBefore3 = TextUtils.getOffsetBefore("", 0) + 684;
                            Object[] objArr33 = new Object[1];
                            a((byte) 45, (byte) 81, (byte) (-$$a[4]), objArr33);
                            objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i43, cBlue, offsetBefore3, 508509282, false, (String) objArr33[0], null);
                        }
                        ((Field) objAccessartificialFrame8).set(null, lValueOf2);
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
            Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(777251007);
            if (objAccessartificialFrame9 == null) {
                int iMyPid2 = 30 - (Process.myPid() >> 22);
                char cResolveSizeAndState = (char) (49362 - View.resolveSizeAndState(0, 0, 0));
                int i44 = 685 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                Object[] objArr34 = new Object[1];
                a((byte) $$b, (byte) 69, (byte) ($$a[5] - 1), objArr34);
                objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(iMyPid2, cResolveSizeAndState, i44, -1321816393, false, (String) objArr34[0], null);
            }
            Object[] objArr35 = (Object[]) ((Field) objAccessartificialFrame9).get(null);
            objArr2 = new Object[]{new int[]{((int[]) objArr35[0])[0]}, new int[]{((int[]) objArr35[1])[0]}, new int[1], (String) objArr35[3]};
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i45 = (-1911695090) + (((-965908701) | iIdentityHashCode2) * 376) + (((~((~iIdentityHashCode2) | 31529521)) | (-972266238)) * (-376)) + (((~(iIdentityHashCode2 | (-31529522))) | 947094253) * 376) + 320936420;
            int i46 = (i45 << 13) ^ i45;
            int i47 = i46 ^ (i46 >>> 17);
            ((int[]) objArr2[2])[0] = i47 ^ (i47 << 5);
        }
        int i48 = ((int[]) objArr2[1])[0];
        int i49 = ((int[]) objArr2[0])[0];
        if (i49 == i48) {
            int i50 = ((int[]) objArr2[2])[0];
            Object[] objArr36 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
            int i51 = ~iFreeMemory;
            int i52 = i50 + (-958088776) + (((~((-805061237) | i51)) | (~((-173562539) | i51))) * (-867)) + (((~((-173562539) | iFreeMemory)) | 173556256 | (~((-805061237) | iFreeMemory))) * (-1734)) + (((~((-173556257) | i51)) | (~((-6283) | iFreeMemory)) | (~(iFreeMemory | (-631504981)))) * 867);
            int i53 = (i52 << 13) ^ i52;
            int i54 = i53 ^ (i53 >>> 17);
            ((int[]) objArr36[2])[0] = i54 ^ (i54 << 5);
            i2 = 0;
        } else {
            Object[] objArr37 = {Long.valueOf(((long) (i48 ^ i49)) ^ (((long) (-900692120)) << 32)), Long.valueOf(-900692632)};
            byte[] bArr4 = $$d;
            Object[] objArr38 = new Object[1];
            c(bArr4[16], (short) 496, bArr4[216], objArr38);
            Class<?> cls4 = Class.forName((String) objArr38[0]);
            Object[] objArr39 = new Object[1];
            c(bArr4[21], (short) 722, bArr4[722], objArr39);
            cls4.getMethod((String) objArr39[0], Long.TYPE, Long.TYPE).invoke(null, objArr37);
            int i55 = ((int[]) objArr2[2])[0];
            Object[] objArr40 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int i56 = ((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getResources().getConfiguration().uiMode;
            int i57 = ~i56;
            int i58 = i55 + (-1157866988) + ((i56 | 915565040) * (-859)) + (((~(i56 | (-42082593))) | (~(915565040 | i57))) * 859) + (((~((-63058735) | i57)) | 20976142) * 859);
            int i59 = (i58 << 13) ^ i58;
            int i60 = i59 ^ (i59 >>> 17);
            i2 = 0;
            ((int[]) objArr40[2])[0] = i60 ^ (i60 << 5);
        }
        Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame10 == null) {
            int absoluteGravity = Gravity.getAbsoluteGravity(i2, i2) + 36;
            char c3 = (char) (TypedValue.complexToFloat(i2) > 0.0f ? 1 : (TypedValue.complexToFloat(i2) == 0.0f ? 0 : -1));
            int fadingEdgeLength2 = 540 - (ViewConfiguration.getFadingEdgeLength() >> 16);
            Object[] objArr41 = new Object[1];
            a((byte) ($$b | 8), (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, $$a[5], objArr41);
            objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(absoluteGravity, c3, fadingEdgeLength2, 624296913, false, (String) objArr41[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame10).getLong(null);
        if (j3 == -1 || j3 + 1857 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-1717965552);
            if (objAccessartificialFrame11 == null) {
                objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(20 - Color.alpha(0), (char) (39515 - TextUtils.indexOf((CharSequence) "", '0')), 982 - Color.argb(0, 0, 0, 0), 117222168, false, null, new Class[0]);
            }
            Object[] objArr42 = {null, ((Constructor) objAccessartificialFrame11).newInstance(null), 863526522, 0};
            Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-501205803);
            if (objAccessartificialFrame12 == null) {
                int capsMode = TextUtils.getCapsMode("", 0, 0) + 36;
                char c4 = (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                int scrollBarFadeDuration2 = 540 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                byte[] bArr5 = $$a;
                byte b3 = (byte) (bArr5[5] - 1);
                Object[] objArr43 = new Object[1];
                a(b3, (byte) (b3 | 62), bArr5[118], objArr43);
                objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(capsMode, c4, scrollBarFadeDuration2, 2101703389, false, (String) objArr43[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation((ViewConfiguration.getKeyRepeatDelay() >> 16) + 54, (char) (Color.blue(0) + 833), ImageFormat.getBitsPerPixel(0) + 577), (Class) ArtificialStackFrames.coroutineCreation(53 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (Process.myTid() >> 22), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 629), Integer.TYPE, Integer.TYPE});
            }
            objArr3 = (Object[]) ((Method) objAccessartificialFrame12).invoke(null, objArr42);
            Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame13 == null) {
                int iIndexOf2 = TextUtils.indexOf((CharSequence) "", '0') + 37;
                char longPressTimeout = (char) (ViewConfiguration.getLongPressTimeout() >> 16);
                int jumpTapTimeout = 540 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                Object[] objArr44 = new Object[1];
                a((byte) ($$b | 8), (byte) 100, $$a[5], objArr44);
                objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(iIndexOf2, longPressTimeout, jumpTapTimeout, 793268735, false, (String) objArr44[0], null);
            }
            ((Field) objAccessartificialFrame13).set(null, objArr3);
            try {
                Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                if (objAccessartificialFrame14 == null) {
                    int bitsPerPixel = ImageFormat.getBitsPerPixel(0) + 37;
                    char cAxisFromString = (char) ((-1) - MotionEvent.axisFromString(""));
                    int iCombineMeasuredStates2 = View.combineMeasuredStates(0, 0) + 540;
                    Object[] objArr45 = new Object[1];
                    a((byte) ($$b | 8), (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, $$a[5], objArr45);
                    objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(bitsPerPixel, cAxisFromString, iCombineMeasuredStates2, 624296913, false, (String) objArr45[0], null);
                }
                ((Field) objAccessartificialFrame14).set(null, lValueOf3);
            } catch (Exception unused3) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame15 == null) {
                int mirror2 = AndroidCharacter.getMirror('0') - '\f';
                char packedPositionType = (char) ExpandableListView.getPackedPositionType(0L);
                int capsMode2 = 540 - TextUtils.getCapsMode("", 0, 0);
                Object[] objArr46 = new Object[1];
                a((byte) ($$b | 8), (byte) 100, $$a[5], objArr46);
                objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(mirror2, packedPositionType, capsMode2, 793268735, false, (String) objArr46[0], null);
            }
            Object[] objArr47 = (Object[]) ((Field) objAccessartificialFrame15).get(null);
            objArr3 = new Object[]{new int[1], new int[1], new int[1]};
            int i61 = ((int[]) objArr47[2])[0];
            int i62 = ((int[]) objArr47[1])[0];
            ((int[]) objArr3[2])[0] = i61;
            ((int[]) objArr3[1])[0] = i62;
            int i63 = ~System.identityHashCode(this);
            int i64 = ~(574611820 | i63);
            int i65 = 408190221 + ((i64 | 777009929) * 764) + (((~(i63 | 777009929)) | 3129444) * (-1528)) + ((208656997 | i64) * 764) + 863526522;
            int i66 = (i65 << 13) ^ i65;
            int i67 = i66 ^ (i66 >>> 17);
            ((int[]) objArr3[0])[0] = i67 ^ (i67 << 5);
        }
        Object obj = objArr3[1];
        int i68 = ((int[]) obj)[0];
        Object obj2 = objArr3[2];
        int i69 = ((int[]) obj2)[0];
        if (i69 == i68) {
            Object[] objArr48 = {new int[1], new int[1], new int[1]};
            int i70 = ((int[]) objArr3[0])[0];
            int i71 = ((int[]) obj2)[0];
            int i72 = ((int[]) obj)[0];
            ((int[]) objArr48[2])[0] = i71;
            ((int[]) objArr48[1])[0] = i72;
            int i73 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().keyboardHidden;
            int i74 = i70 + (-743863973) + (((~(629421954 | i73)) | 168542321) * (-140)) + ((~(797964275 | i73)) * 70) + (((~(i73 | 722199795)) | 244306801) * 70);
            int i75 = (i74 << 13) ^ i74;
            int i76 = i75 ^ (i75 >>> 17);
            ((int[]) objArr48[0])[0] = i76 ^ (i76 << 5);
            i3 = 0;
        } else {
            Object[] objArr49 = {Long.valueOf(((long) (i68 ^ i69)) ^ (((long) 2042139461) << 32)), Long.valueOf(2042135365)};
            byte[] bArr6 = $$d;
            byte b4 = bArr6[16];
            Object[] objArr50 = new Object[1];
            c(b4, (short) (b4 | 418), (byte) (-bArr6[477]), objArr50);
            Class<?> cls5 = Class.forName((String) objArr50[0]);
            Object[] objArr51 = new Object[1];
            c(bArr6[21], (short) 722, bArr6[722], objArr51);
            cls5.getMethod((String) objArr51[0], Long.TYPE, Long.TYPE).invoke(null, objArr49);
            Object[] objArr52 = {new int[1], new int[1], new int[1]};
            int i77 = ((int[]) objArr3[0])[0];
            int i78 = ((int[]) objArr3[2])[0];
            int i79 = ((int[]) objArr3[1])[0];
            ((int[]) objArr52[2])[0] = i78;
            ((int[]) objArr52[1])[0] = i79;
            int i80 = (int) Runtime.getRuntime().totalMemory();
            int i81 = ~i80;
            int i82 = (-2109244819) + (((~((-279052347) | i81)) | (~(870712378 | i80))) * 520);
            int i83 = ~((-870712379) | i81);
            int i84 = ~(i80 | 480909371);
            int i85 = i77 + i82 + ((i83 | i84) * (-1040)) + ((i84 | (~(i81 | (-480909372))) | 591660032) * 520);
            int i86 = (i85 << 13) ^ i85;
            int i87 = i86 ^ (i86 >>> 17);
            i3 = 0;
            ((int[]) objArr52[0])[0] = i87 ^ (i87 << 5);
        }
        Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame16 == null) {
            int iResolveSize2 = View.resolveSize(i3, i3) + 21;
            char cResolveSizeAndState2 = (char) View.resolveSizeAndState(i3, i3, i3);
            int pressedStateDuration2 = (ViewConfiguration.getPressedStateDuration() >> 16) + 465;
            Object[] objArr53 = new Object[1];
            a((byte) ($$b | 8), (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, $$a[5], objArr53);
            objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(iResolveSize2, cResolveSizeAndState2, pressedStateDuration2, -785931255, false, (String) objArr53[0], null);
        }
        long j4 = ((Field) objAccessartificialFrame16).getLong(null);
        if (j4 == -1 || j4 + 1872 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext2 = getBaseContext();
            if (baseContext2 == null) {
                Object[] objArr54 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1767076825, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 86), ((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 24, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 4), ((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 1862024171, objArr54);
                Class<?> cls6 = Class.forName((String) objArr54[0]);
                Object[] objArr55 = new Object[1];
                b((-1767076788) - (ViewConfiguration.getPressedStateDuration() >> 16), (byte) (37 - View.combineMeasuredStates(0, 0)), (-20) - Color.alpha(0), (short) (((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 4), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1862024110, objArr55);
                baseContext2 = (Context) cls6.getMethod((String) objArr55[0], new Class[0]).invoke(null, null);
            }
            if (baseContext2 != null) {
                baseContext2 = ((baseContext2 instanceof ContextWrapper) && ((ContextWrapper) baseContext2).getBaseContext() == null) ? null : baseContext2.getApplicationContext();
            }
            int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr56 = new Object[1];
            b((-1767076785) - (ViewConfiguration.getPressedStateDuration() >> 16), (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 65), ((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 55, (short) View.getDefaultSize(0, 0), ((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1862024126, objArr56);
            String str6 = (String) objArr56[0];
            Object[] objArr57 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(19) - 1767076945, (byte) (Color.argb(0, 0, 0, 0) - 111), ((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 55, (short) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), ((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 1862024048, objArr57);
            Object[] objArr58 = {baseContext2, new String[]{str6, (String) objArr57[0]}, Integer.valueOf(iIntValue), 1, 1595558797};
            byte[] bArr7 = $$d;
            byte b5 = bArr7[16];
            Object[] objArr59 = new Object[1];
            c(b5, (short) (b5 | 384), (byte) (bArr7[3] - 1), objArr59);
            Class<?> cls7 = Class.forName((String) objArr59[0]);
            Object[] objArr60 = new Object[1];
            c(bArr7[65], (short) 516, bArr7[271], objArr60);
            objArr4 = (Object[]) cls7.getMethod((String) objArr60[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr58);
            int i88 = ((int[]) objArr4[0])[0];
            int i89 = ((int[]) objArr4[3])[0];
            if (baseContext2 != null) {
                Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame17 == null) {
                    int iLastIndexOf = 20 - TextUtils.lastIndexOf("", '0', 0);
                    char cBlue2 = (char) Color.blue(0);
                    int iIndexOf3 = TextUtils.indexOf((CharSequence) "", '0') + 466;
                    Object[] objArr61 = new Object[1];
                    a((byte) ($$b | 8), (byte) 100, $$a[5], objArr61);
                    objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, cBlue2, iIndexOf3, -612765161, false, (String) objArr61[0], null);
                }
                ((Field) objAccessartificialFrame17).set(null, objArr4);
                try {
                    Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(1313006081);
                    if (objAccessartificialFrame18 == null) {
                        int jumpTapTimeout2 = (ViewConfiguration.getJumpTapTimeout() >> 16) + 21;
                        char c5 = (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                        int iIndexOf4 = 465 - TextUtils.indexOf("", "", 0, 0);
                        Object[] objArr62 = new Object[1];
                        a((byte) ($$b | 8), (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, $$a[5], objArr62);
                        objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout2, c5, iIndexOf4, -785931255, false, (String) objArr62[0], null);
                    }
                    ((Field) objAccessartificialFrame18).set(null, lValueOf4);
                } catch (Exception unused4) {
                    throw new RuntimeException();
                }
            }
            c = 0;
        } else {
            int i90 = artificialFrame + 61;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i90 % 128;
            int i91 = i90 % 2;
            Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(1142731807);
            if (objAccessartificialFrame19 == null) {
                int i92 = 22 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                char gidForName = (char) ((-1) - Process.getGidForName(""));
                int windowTouchSlop = (ViewConfiguration.getWindowTouchSlop() >> 8) + 465;
                Object[] objArr63 = new Object[1];
                a((byte) ($$b | 8), (byte) 100, $$a[5], objArr63);
                objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(i92, gidForName, windowTouchSlop, -612765161, false, (String) objArr63[0], null);
            }
            Object[] objArr64 = (Object[]) ((Field) objAccessartificialFrame19).get(null);
            objArr4 = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
            int i93 = ((int[]) objArr64[3])[0];
            int i94 = ((int[]) objArr64[0])[0];
            String[] strArr5 = (String[]) objArr64[1];
            int iIdentityHashCode3 = System.identityHashCode(this);
            int i95 = ~iIdentityHashCode3;
            int i96 = (-2062543900) + (((~((-45242572) | i95)) | (~(117341659 | iIdentityHashCode3))) * (-831)) + ((~((-2234506) | iIdentityHashCode3)) * (-1662)) + (((~(iIdentityHashCode3 | 45242571)) | (~(i95 | (-115107155))) | (~(115107154 | iIdentityHashCode3))) * 831) + 1595558797;
            int i97 = (i96 << 13) ^ i96;
            int i98 = i97 ^ (i97 >>> 17);
            ((int[]) objArr4[2])[0] = i98 ^ (i98 << 5);
            c = 0;
        }
        int i99 = ((int[]) objArr4[c])[c];
        int i100 = ((int[]) objArr4[3])[c];
        if (i100 == i99) {
            Object[] objArr65 = new Object[4];
            int[] iArr = new int[1];
            objArr65[c] = iArr;
            objArr65[2] = new int[1];
            int[] iArr2 = new int[1];
            objArr65[3] = iArr2;
            int i101 = ((int[]) objArr4[2])[c];
            int i102 = ((int[]) objArr4[3])[c];
            int i103 = ((int[]) objArr4[c])[c];
            String[] strArr6 = (String[]) objArr4[1];
            iArr2[c] = i102;
            iArr[c] = i103;
            int iIdentityHashCode4 = System.identityHashCode(this);
            int i104 = ~iIdentityHashCode4;
            int i105 = i101 + (-1778030654) + (((~((-1044801394) | i104)) | 884451667) * (-865)) + ((~(iIdentityHashCode4 | 1044801393)) * 865) + (((~(884451667 | i104)) | (~(i104 | 1044801393))) * 865);
            int i106 = (i105 << 13) ^ i105;
            int i107 = i106 ^ (i106 >>> 17);
            ((int[]) objArr65[2])[0] = i107 ^ (i107 << 5);
            objArr65[1] = strArr6;
            i4 = 0;
        } else {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr7 = (String[]) objArr4[1];
            if (strArr7 != null) {
                for (String str7 : strArr7) {
                    arrayList2.add(str7);
                }
            }
            long j5 = ((long) (i99 ^ i100)) ^ (((long) (-1386029292)) << 32);
            long j6 = -1386029228;
            int i108 = getARTIFICIAL_FRAME_PACKAGE_NAME + 41;
            artificialFrame = i108 % 128;
            int i109 = i108 % 2;
            Object[] objArr66 = {Long.valueOf(j5), Long.valueOf(j6)};
            byte[] bArr8 = $$d;
            Object[] objArr67 = new Object[1];
            c(bArr8[16], (short) 347, bArr8[58], objArr67);
            Class<?> cls8 = Class.forName((String) objArr67[0]);
            Object[] objArr68 = new Object[1];
            c(bArr8[21], (short) 722, bArr8[722], objArr68);
            cls8.getMethod((String) objArr68[0], Long.TYPE, Long.TYPE).invoke(null, objArr66);
            Object[] objArr69 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i110 = ((int[]) objArr4[2])[0];
            int i111 = ((int[]) objArr4[3])[0];
            int i112 = ((int[]) objArr4[0])[0];
            String[] strArr8 = (String[]) objArr4[1];
            int i113 = ((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 1604513965;
            int i114 = ~i113;
            int i115 = i110 + 1725927007 + (((~((-160481831) | i113)) | (~(i114 | (-807613577))) | 132104) * 717) + (((~(i113 | (-807613577))) | (~((-160481831) | i114)) | 132104) * 717);
            int i116 = (i115 << 13) ^ i115;
            int i117 = i116 ^ (i116 >>> 17);
            i4 = 0;
            ((int[]) objArr69[2])[0] = i117 ^ (i117 << 5);
        }
        Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame20 == null) {
            int defaultSize2 = View.getDefaultSize(i4, i4) + 17;
            char windowTouchSlop2 = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
            int i118 = 748 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
            Object[] objArr70 = new Object[1];
            a((byte) ($$b | 8), (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, $$a[5], objArr70);
            objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(defaultSize2, windowTouchSlop2, i118, -144068856, false, (String) objArr70[0], null);
        }
        long j7 = ((Field) objAccessartificialFrame20).getLong(null);
        if (j7 == -1 || j7 + 1934 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext3 = getBaseContext();
            if (baseContext3 == null) {
                Object[] objArr71 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 1767076794, (byte) (KeyEvent.getDeadChar(0, 0) + 121), ((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 41, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 4), ((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 1862024171, objArr71);
                Class<?> cls9 = Class.forName((String) objArr71[0]);
                Object[] objArr72 = new Object[1];
                b((-1767076789) - MotionEvent.axisFromString(""), (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) + 1), (-20) - (ViewConfiguration.getScrollBarSize() >> 8), (short) TextUtils.indexOf("", "", 0, 0), ((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1862024144, objArr72);
                baseContext3 = (Context) cls9.getMethod((String) objArr72[0], new Class[0]).invoke(null, null);
            }
            if (baseContext3 != null) {
                baseContext3 = ((baseContext3 instanceof ContextWrapper) && ((ContextWrapper) baseContext3).getBaseContext() == null) ? null : baseContext3.getApplicationContext();
            }
            Object[] objArr73 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -1596476532};
            byte[] bArr9 = $$d;
            Object[] objArr74 = new Object[1];
            c(bArr9[16], (short) 282, bArr9[18], objArr74);
            Class<?> cls10 = Class.forName((String) objArr74[0]);
            Object[] objArr75 = new Object[1];
            c((byte) (-bArr9[178]), (short) 210, bArr9[7], objArr75);
            objArr5 = (Object[]) cls10.getMethod((String) objArr75[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr73);
            Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame21 == null) {
                int iIndexOf5 = TextUtils.indexOf((CharSequence) "", '0') + 18;
                char packedPositionType2 = (char) ExpandableListView.getPackedPositionType(0L);
                int iNormalizeMetaState2 = 747 - KeyEvent.normalizeMetaState(0);
                Object[] objArr76 = new Object[1];
                a((byte) ($$b | 8), (byte) 100, $$a[5], objArr76);
                objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(iIndexOf5, packedPositionType2, iNormalizeMetaState2, -1031537386, false, (String) objArr76[0], null);
            }
            ((Field) objAccessartificialFrame21).set(null, objArr5);
            try {
                Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame22 == null) {
                    int scrollBarFadeDuration3 = 17 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    char c6 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                    int i119 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 746;
                    Object[] objArr77 = new Object[1];
                    a((byte) ($$b | 8), (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, $$a[5], objArr77);
                    objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration3, c6, i119, -144068856, false, (String) objArr77[0], null);
                }
                ((Field) objAccessartificialFrame22).set(null, lValueOf5);
            } catch (Exception unused5) {
                throw new RuntimeException();
            }
        } else {
            int i120 = getARTIFICIAL_FRAME_PACKAGE_NAME + 15;
            artificialFrame = i120 % 128;
            int i121 = i120 % 2;
            Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame23 == null) {
                int iMyPid3 = (Process.myPid() >> 22) + 17;
                char edgeSlop = (char) (ViewConfiguration.getEdgeSlop() >> 16);
                int iLastIndexOf2 = TextUtils.lastIndexOf("", '0', 0, 0) + 748;
                Object[] objArr78 = new Object[1];
                a((byte) ($$b | 8), (byte) 100, $$a[5], objArr78);
                objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(iMyPid3, edgeSlop, iLastIndexOf2, -1031537386, false, (String) objArr78[0], null);
            }
            Object[] objArr79 = (Object[]) ((Field) objAccessartificialFrame23).get(null);
            objArr5 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
            int i122 = ((int[]) objArr79[3])[0];
            int i123 = ((int[]) objArr79[4])[0];
            List list = (List) objArr79[0];
            List list2 = (List) objArr79[2];
            int iCodePointAt2 = ((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 1588513089;
            int i124 = ~iCodePointAt2;
            int i125 = (((2026667609 + ((~(270776945 | i124)) * (-560))) + ((~(iCodePointAt2 | (-63964297))) * (-560))) + (((~(334671512 | i124)) | 69729) * 560)) - 1596476532;
            int i126 = (i125 << 13) ^ i125;
            int i127 = i126 ^ (i126 >>> 17);
            ((int[]) objArr5[1])[0] = i127 ^ (i127 << 5);
        }
        int i128 = ((int[]) objArr5[4])[0];
        int i129 = ((int[]) objArr5[3])[0];
        if (i129 == i128) {
            Object[] objArr80 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i130 = ((int[]) objArr5[1])[0];
            int i131 = ((int[]) objArr5[3])[0];
            int i132 = ((int[]) objArr5[4])[0];
            List list3 = (List) objArr5[0];
            List list4 = (List) objArr5[2];
            int i133 = ~((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getResources().getConfiguration().keyboard;
            int i134 = i130 + ((((-594402779) + (((~(603717625 | i133)) | 1730832) * (-828))) + ((i133 | 603717625) * (-828))) - 1661987992);
            int i135 = (i134 << 13) ^ i134;
            int i136 = i135 ^ (i135 >>> 17);
            ((int[]) objArr80[1])[0] = i136 ^ (i136 << 5);
            i5 = 0;
        } else {
            ArrayList arrayList3 = new ArrayList();
            Object[] objArr81 = {objArr5};
            Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(1804664566);
            if (objAccessartificialFrame24 == null) {
                objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(((byte) KeyEvent.getModifierMetaStateMask()) + 42, (char) (12469 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), Process.getGidForName("") + 3643, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
            }
            arrayList3.add(((Method) objAccessartificialFrame24).invoke(null, objArr81));
            Object[] objArr82 = {objArr5};
            Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-1243809191);
            if (objAccessartificialFrame25 == null) {
                objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(Color.argb(0, 0, 0, 0) + 41, (char) (Process.getGidForName("") + 12469), View.getDefaultSize(0, 0) + 3642, 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
            }
            arrayList3.add(((Method) objAccessartificialFrame25).invoke(null, objArr82));
            long j8 = ((long) (i128 ^ i129)) ^ (((long) (-575956989)) << 32);
            long j9 = -575956981;
            int i137 = getARTIFICIAL_FRAME_PACKAGE_NAME + 83;
            artificialFrame = i137 % 128;
            int i138 = i137 % 2;
            Object[] objArr83 = {Long.valueOf(j8), Long.valueOf(j9)};
            byte[] bArr10 = $$d;
            byte b6 = bArr10[16];
            Object[] objArr84 = new Object[1];
            c(b6, (short) (b6 | 179), bArr10[18], objArr84);
            Class<?> cls11 = Class.forName((String) objArr84[0]);
            Object[] objArr85 = new Object[1];
            c(bArr10[21], (short) 722, bArr10[722], objArr85);
            cls11.getMethod((String) objArr85[0], Long.TYPE, Long.TYPE).invoke(null, objArr83);
            Object[] objArr86 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i139 = ((int[]) objArr5[1])[0];
            int i140 = ((int[]) objArr5[3])[0];
            int i141 = ((int[]) objArr5[4])[0];
            List list5 = (List) objArr5[0];
            List list6 = (List) objArr5[2];
            int iIdentityHashCode5 = System.identityHashCode(this);
            int i142 = i139 + (((574742169 + (((~((-217098104) | iIdentityHashCode5)) | 69239058) * 1504)) + ((~(iIdentityHashCode5 | (-147859046))) * (-1504))) - 1025621840);
            int i143 = (i142 << 13) ^ i142;
            int i144 = i143 ^ (i143 >>> 17);
            i5 = 0;
            ((int[]) objArr86[1])[0] = i144 ^ (i144 << 5);
        }
        Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame26 == null) {
            int iCombineMeasuredStates3 = 30 - View.combineMeasuredStates(i5, i5);
            char cIndexOf = (char) (TextUtils.indexOf("", "", i5) + 49362);
            int bitsPerPixel2 = 683 - ImageFormat.getBitsPerPixel(i5);
            byte b7 = (byte) 45;
            Object[] objArr87 = new Object[1];
            a(b7, (byte) (b7 - 3), $$a[28], objArr87);
            objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates3, cIndexOf, bitsPerPixel2, 752929587, false, (String) objArr87[0], null);
        }
        long j10 = ((Field) objAccessartificialFrame26).getLong(null);
        if (j10 == -1 || j10 + 1908 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext4 = getBaseContext();
            if (baseContext4 == null) {
                Object[] objArr88 = new Object[1];
                b((-1767076791) - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 86), (-20) - (ViewConfiguration.getTouchSlop() >> 8), (short) (((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35), (ViewConfiguration.getKeyRepeatDelay() >> 16) - 1862024135, objArr88);
                Class<?> cls12 = Class.forName((String) objArr88[0]);
                Object[] objArr89 = new Object[1];
                b((-1767076789) - MotionEvent.axisFromString(""), (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 2), ((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 55, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 21), (-1862024108) - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), objArr89);
                baseContext4 = (Context) cls12.getMethod((String) objArr89[0], new Class[0]).invoke(null, null);
            }
            if (baseContext4 != null) {
                int i145 = artificialFrame + 57;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i145 % 128;
                if (i145 % 2 != 0) {
                    boolean z = baseContext4 instanceof ContextWrapper;
                    Object obj3 = null;
                    obj3.hashCode();
                    throw null;
                }
                baseContext4 = ((baseContext4 instanceof ContextWrapper) && ((ContextWrapper) baseContext4).getBaseContext() == null) ? null : baseContext4.getApplicationContext();
            }
            Object[] objArr90 = {baseContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1708992260};
            byte[] bArr11 = $$d;
            Object[] objArr91 = new Object[1];
            c(bArr11[16], (short) 119, bArr11[399], objArr91);
            Class<?> cls13 = Class.forName((String) objArr91[0]);
            Object[] objArr92 = new Object[1];
            c((byte) (-bArr11[178]), (short) 210, bArr11[7], objArr92);
            objArr6 = (Object[]) cls13.getMethod((String) objArr92[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr90);
            if (baseContext4 != null) {
                int i146 = getARTIFICIAL_FRAME_PACKAGE_NAME + 41;
                artificialFrame = i146 % 128;
                int i147 = i146 % 2;
                Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(-326560385);
                if (objAccessartificialFrame27 == null) {
                    int maximumDrawingCacheSize2 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 30;
                    char c7 = (char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 49362);
                    int iNormalizeMetaState3 = KeyEvent.normalizeMetaState(0) + 684;
                    byte b8 = (byte) ($$b - 1);
                    byte[] bArr12 = $$a;
                    Object[] objArr93 = new Object[1];
                    a(b8, (byte) (-bArr12[20]), bArr12[28], objArr93);
                    objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize2, c7, iNormalizeMetaState3, 1944867703, false, (String) objArr93[0], null);
                }
                ((Field) objAccessartificialFrame27).set(null, objArr6);
                try {
                    Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                    if (objAccessartificialFrame28 == null) {
                        int iIndexOf6 = 29 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                        char trimmedLength = (char) (TextUtils.getTrimmedLength("") + 49362);
                        int pressedStateDuration3 = (ViewConfiguration.getPressedStateDuration() >> 16) + 684;
                        byte b9 = (byte) 45;
                        Object[] objArr94 = new Object[1];
                        a(b9, (byte) (b9 - 3), $$a[28], objArr94);
                        objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(iIndexOf6, trimmedLength, pressedStateDuration3, 752929587, false, (String) objArr94[0], null);
                    }
                    ((Field) objAccessartificialFrame28).set(null, lValueOf6);
                } catch (Exception unused6) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(-326560385);
            if (objAccessartificialFrame29 == null) {
                int i148 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 29;
                char doubleTapTimeout = (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 49362);
                int i149 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 683;
                byte b10 = (byte) ($$b - 1);
                byte[] bArr13 = $$a;
                Object[] objArr95 = new Object[1];
                a(b10, (byte) (-bArr13[20]), bArr13[28], objArr95);
                objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(i148, doubleTapTimeout, i149, 1944867703, false, (String) objArr95[0], null);
            }
            Object[] objArr96 = (Object[]) ((Field) objAccessartificialFrame29).get(null);
            objArr6 = new Object[]{new int[]{((int[]) objArr96[0])[0]}, new int[]{((int[]) objArr96[1])[0]}, new int[1], (String) objArr96[3]};
            int iCodePointAt3 = ((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(19) + 2040578327;
            int i150 = ~((-881187512) | iCodePointAt3);
            int i151 = ~iCodePointAt3;
            int i152 = 820148126 + ((i150 | (~(97436263 | i151))) * (-1808)) + (((~((-75809320) | iCodePointAt3)) | (~(i151 | 902814455))) * TypedValues.Custom.TYPE_BOOLEAN) + (((~(iCodePointAt3 | (-97436264))) | 805378192 | (~(881187511 | i151))) * TypedValues.Custom.TYPE_BOOLEAN) + 1708992260;
            int i153 = (i152 << 13) ^ i152;
            int i154 = i153 ^ (i153 >>> 17);
            ((int[]) objArr6[2])[0] = i154 ^ (i154 << 5);
        }
        int i155 = ((int[]) objArr6[1])[0];
        int i156 = ((int[]) objArr6[0])[0];
        if (i156 == i155) {
            int i157 = ((int[]) objArr6[2])[0];
            Object[] objArr97 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
            int i158 = ~(((int) Process.getStartElapsedRealtime()) | 372882323);
            int i159 = i157 + (((841177624 | i158) * (-658)) - 748053954) + ((i158 | 537018376) * 658);
            int i160 = (i159 << 13) ^ i159;
            int i161 = i160 ^ (i160 >>> 17);
            ((int[]) objArr97[2])[0] = i161 ^ (i161 << 5);
            i6 = 0;
        } else {
            long j11 = (((long) (-2007724724)) << 32) ^ ((long) (i155 ^ i156));
            long j12 = -2007724728;
            int i162 = artificialFrame + 119;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i162 % 128;
            int i163 = i162 % 2;
            Object[] objArr98 = {Long.valueOf(j11), Long.valueOf(j12)};
            byte[] bArr14 = $$d;
            Object[] objArr99 = new Object[1];
            c(bArr14[16], (short) 496, bArr14[216], objArr99);
            Class<?> cls14 = Class.forName((String) objArr99[0]);
            Object[] objArr100 = new Object[1];
            c(bArr14[21], (short) 722, bArr14[722], objArr100);
            cls14.getMethod((String) objArr100[0], Long.TYPE, Long.TYPE).invoke(null, objArr98);
            int i164 = ((int[]) objArr6[2])[0];
            Object[] objArr101 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
            int i165 = ((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1606351163;
            int i166 = i164 + 395406744 + (((-17858705) | i165) * (-627)) + (((~((-954404456) | i165)) | 24219319) * (-627)) + (((~(i165 | 24219319)) | (~((~i165) | 954404455))) * 627);
            int i167 = (i166 << 13) ^ i166;
            int i168 = i167 ^ (i167 >>> 17);
            i6 = 0;
            ((int[]) objArr101[2])[0] = i168 ^ (i168 << 5);
        }
        Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame30 == null) {
            int trimmedLength2 = 30 - TextUtils.getTrimmedLength("");
            char cNormalizeMetaState2 = (char) (KeyEvent.normalizeMetaState(i6) + 49362);
            int size = 684 - View.MeasureSpec.getSize(i6);
            byte b11 = (byte) ($$b - 1);
            byte[] bArr15 = $$a;
            Object[] objArr102 = new Object[1];
            a(b11, bArr15[18], (byte) (-bArr15[4]), objArr102);
            objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(trimmedLength2, cNormalizeMetaState2, size, -1583976536, false, (String) objArr102[0], null);
        }
        long j13 = ((Field) objAccessartificialFrame30).getLong(null);
        if (j13 == -1 || j13 + 1992 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr103 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 2034142834};
            byte[] bArr16 = $$d;
            Object[] objArr104 = new Object[1];
            c(bArr16[19], bArr16[271], bArr16[305], objArr104);
            Class<?> cls15 = Class.forName((String) objArr104[0]);
            Object[] objArr105 = new Object[1];
            c(bArr16[16], bArr16[58], (byte) (-bArr16[285]), objArr105);
            objArr7 = (Object[]) cls15.getMethod((String) objArr105[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr103);
            Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame31 == null) {
                int edgeSlop2 = (ViewConfiguration.getEdgeSlop() >> 16) + 30;
                char minimumFlingVelocity = (char) ((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 49362);
                int i169 = 684 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                byte b12 = (byte) ($$b + 1);
                byte b13 = $$a[5];
                Object[] objArr106 = new Object[1];
                a(b12, (byte) (b13 - 1), b13, objArr106);
                objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(edgeSlop2, minimumFlingVelocity, i169, -1456483158, false, (String) objArr106[0], null);
            }
            ((Field) objAccessartificialFrame31).set(null, objArr7);
            try {
                Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame32 == null) {
                    int iResolveSizeAndState = 30 - View.resolveSizeAndState(0, 0, 0);
                    char cGreen = (char) (49362 - Color.green(0));
                    int iResolveOpacity = Drawable.resolveOpacity(0, 0) + 684;
                    byte b14 = (byte) ($$b - 1);
                    byte[] bArr17 = $$a;
                    Object[] objArr107 = new Object[1];
                    a(b14, bArr17[18], (byte) (-bArr17[4]), objArr107);
                    objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState, cGreen, iResolveOpacity, -1583976536, false, (String) objArr107[0], null);
                }
                ((Field) objAccessartificialFrame32).set(null, lValueOf7);
            } catch (Exception unused7) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame33 == null) {
                int iBlue = Color.blue(0) + 30;
                char c8 = (char) (49363 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
                int i170 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 684;
                byte b15 = (byte) ($$b + 1);
                byte b16 = $$a[5];
                Object[] objArr108 = new Object[1];
                a(b15, (byte) (b16 - 1), b16, objArr108);
                objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(iBlue, c8, i170, -1456483158, false, (String) objArr108[0], null);
            }
            Object[] objArr109 = (Object[]) ((Field) objAccessartificialFrame33).get(null);
            objArr7 = new Object[]{new int[]{((int[]) objArr109[0])[0]}, new int[]{((int[]) objArr109[1])[0]}, new int[1], (String) objArr109[3]};
            int i171 = ((Context) Class.forName("android.app.ActivityThread").getMethod(r12, new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().densityDpi;
            int i172 = ((((~((-530975895) | i171)) | 84450334) * 262) - 1496281930) + (((~((~i171) | (-530975895))) | 84450334) * 262) + 2034142834;
            int i173 = (i172 << 13) ^ i172;
            int i174 = i173 ^ (i173 >>> 17);
            ((int[]) objArr7[2])[0] = i174 ^ (i174 << 5);
        }
        int i175 = ((int[]) objArr7[1])[0];
        int i176 = ((int[]) objArr7[0])[0];
        if (i176 == i175) {
            int i177 = ((int[]) objArr7[2])[0];
            Object[] objArr110 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
            int elapsedCpuTime = (int) Process.getElapsedCpuTime();
            int i178 = i177 + (-1213104510) + (((~elapsedCpuTime) | (-84630749)) * 1444) + (((~(elapsedCpuTime | 447078501)) | (~(531545273 | elapsedCpuTime)) | (-531627262)) * (-1444)) + 973857912;
            int i179 = (i178 << 13) ^ i178;
            int i180 = i179 ^ (i179 >>> 17);
            ((int[]) objArr110[2])[0] = i180 ^ (i180 << 5);
            i7 = 0;
        } else {
            new ArrayList().add((String) objArr7[3]);
            Object[] objArr111 = {Long.valueOf(((long) (i175 ^ i176)) ^ (((long) (-1467345104)) << 32)), Long.valueOf(-1467345120)};
            byte[] bArr18 = $$d;
            byte b17 = bArr18[16];
            Object[] objArr112 = new Object[1];
            c(b17, (short) (b17 | 418), (byte) (-bArr18[477]), objArr112);
            Class<?> cls16 = Class.forName((String) objArr112[0]);
            Object[] objArr113 = new Object[1];
            c(bArr18[21], (short) 722, bArr18[722], objArr113);
            cls16.getMethod((String) objArr113[0], Long.TYPE, Long.TYPE).invoke(null, objArr111);
            int i181 = ((int[]) objArr7[2])[0];
            Object[] objArr114 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
            int iIdentityHashCode6 = System.identityHashCode(this);
            int i182 = i181 + (((~(iIdentityHashCode6 | 346971527)) | 631652247) * 56) + 905848782 + (((~((~iIdentityHashCode6) | 631652247)) | 346971527) * 56);
            int i183 = (i182 << 13) ^ i182;
            int i184 = i183 ^ (i183 >>> 17);
            i7 = 0;
            ((int[]) objArr114[2])[0] = i184 ^ (i184 << 5);
        }
        Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame34 == null) {
            int iMyTid = 26 - (Process.myTid() >> 22);
            char mode2 = (char) View.MeasureSpec.getMode(i7);
            int edgeSlop3 = 1041 - (ViewConfiguration.getEdgeSlop() >> 16);
            Object[] objArr115 = new Object[1];
            a((byte) ($$b | 8), (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, $$a[5], objArr115);
            objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(iMyTid, mode2, edgeSlop3, 2061780482, false, (String) objArr115[0], null);
        }
        long j14 = ((Field) objAccessartificialFrame34).getLong(null);
        if (j14 == -1 || j14 + 1999 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr116 = {-884876430};
            Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame35 == null) {
                objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", "") + 8, (char) (View.combineMeasuredStates(0, 0) + 22251), 1033 - ExpandableListView.getPackedPositionType(0L), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            Object[] objArrAccessartificialFrame$78cbbd35 = NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame35).newInstance(objArr116), -52183491, false);
            Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame36 == null) {
                int iRgb = Color.rgb(0, 0, 0) + 16777242;
                char doubleTapTimeout2 = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                int iMyPid4 = (Process.myPid() >> 22) + 1041;
                Object[] objArr117 = new Object[1];
                a((byte) ($$b | 8), (byte) 100, $$a[5], objArr117);
                objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(iRgb, doubleTapTimeout2, iMyPid4, 1145017376, false, (String) objArr117[0], null);
            }
            ((Field) objAccessartificialFrame36).set(null, objArrAccessartificialFrame$78cbbd35);
            try {
                Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame37 == null) {
                    int iResolveOpacity2 = Drawable.resolveOpacity(0, 0) + 26;
                    char offsetBefore4 = (char) TextUtils.getOffsetBefore("", 0);
                    int iGreen2 = Color.green(0) + 1041;
                    Object[] objArr118 = new Object[1];
                    a((byte) ($$b | 8), (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, $$a[5], objArr118);
                    objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(iResolveOpacity2, offsetBefore4, iGreen2, 2061780482, false, (String) objArr118[0], null);
                }
                ((Field) objAccessartificialFrame37).set(null, lValueOf8);
                objArr8 = objArrAccessartificialFrame$78cbbd35;
            } catch (Exception unused8) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame38 == null) {
                int mirror3 = 'J' - AndroidCharacter.getMirror('0');
                char c9 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                int iRed = 1041 - Color.red(0);
                Object[] objArr119 = new Object[1];
                a((byte) ($$b | 8), (byte) 100, $$a[5], objArr119);
                objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(mirror3, c9, iRed, 1145017376, false, (String) objArr119[0], null);
            }
            Object[] objArr120 = (Object[]) ((Field) objAccessartificialFrame38).get(null);
            objArr8 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
            int i185 = ((int[]) objArr120[3])[0];
            int i186 = ((int[]) objArr120[2])[0];
            String[] strArr9 = (String[]) objArr120[0];
            int iIdentityHashCode7 = System.identityHashCode(this);
            int i187 = ((((~((-33689779) | iIdentityHashCode7)) * 521) - 2145073136) + (((~((~iIdentityHashCode7) | (-33689779))) | (-111859636)) * 521)) - 52183491;
            int i188 = (i187 << 13) ^ i187;
            int i189 = i188 ^ (i188 >>> 17);
            ((int[]) objArr8[1])[0] = i189 ^ (i189 << 5);
        }
        int i190 = ((int[]) objArr8[2])[0];
        int i191 = ((int[]) objArr8[3])[0];
        if (i191 == i190) {
            Object[] objArr121 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i192 = ((int[]) objArr8[1])[0];
            int i193 = ((int[]) objArr8[3])[0];
            int i194 = ((int[]) objArr8[2])[0];
            String[] strArr10 = (String[]) objArr8[0];
            int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
            int i195 = 1953428870 + (((-215600388) | iMaxMemory) * 614);
            int i196 = ~iMaxMemory;
            int i197 = i192 + i195 + (((~((-684124630) | i196)) | 537272532 | (~((-606020823) | i196))) * (-1228)) + (((~(i196 | (-68748291))) | (~((-146852098) | i196))) * 614);
            int i198 = (i197 << 13) ^ i197;
            int i199 = i198 ^ (i198 >>> 17);
            ((int[]) objArr121[1])[0] = i199 ^ (i199 << 5);
        } else {
            ArrayList arrayList4 = new ArrayList();
            String[] strArr11 = (String[]) objArr8[0];
            if (strArr11 != null) {
                for (String str8 : strArr11) {
                    arrayList4.add(str8);
                }
            }
            Object[] objArr122 = {Long.valueOf(((long) (i190 ^ i191)) ^ (((long) (-268802493)) << 32)), Long.valueOf(-268802495)};
            byte[] bArr19 = $$d;
            Object[] objArr123 = new Object[1];
            c(bArr19[16], bArr19[19], bArr19[612], objArr123);
            Class<?> cls17 = Class.forName((String) objArr123[0]);
            Object[] objArr124 = new Object[1];
            c(bArr19[21], (short) 722, bArr19[722], objArr124);
            cls17.getMethod((String) objArr124[0], Long.TYPE, Long.TYPE).invoke(null, objArr122);
            Object[] objArr125 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i200 = ((int[]) objArr8[1])[0];
            int i201 = ((int[]) objArr8[3])[0];
            int i202 = ((int[]) objArr8[2])[0];
            String[] strArr12 = (String[]) objArr8[0];
            int iIdentityHashCode8 = System.identityHashCode(this);
            int i203 = ~iIdentityHashCode8;
            int i204 = i200 + 2063013822 + (((~(i203 | 804843405)) | (~(726739598 | i203)) | (-804908944)) * 464) + (((-78169346) | iIdentityHashCode8) * (-464)) + (((~(iIdentityHashCode8 | 804843405)) | (-804908944)) * 464);
            int i205 = (i204 << 13) ^ i204;
            int i206 = i205 ^ (i205 >>> 17);
            ((int[]) objArr125[1])[0] = i206 ^ (i206 << 5);
        }
        super.onCreate();
    }

    static {
        byte[] bArr = new byte[806];
        System.arraycopy("\u0013ï]!\u0011\u0003Æ>\r\u0005ý\nþÎ:\u0014\fü\t\u0000ÄKú\n\u0002È8\t\u0001\bÏ\u0018)\u0013×!\u001cØ\u001f\u0019°\u0012\u0005B\u0001\u0002\u0011\u0005\u0001È\u0000@\n\u000bö\u0012\u0001ø\u0010ÇG\u0001ú\u0018÷\u000e\b\u0000Æ8\u0012û\u0013\u0002ÿ\u0000Ï\u001b&\u0006\u0004\u0012\u0005ø\u0004ô!ù\rÿ\u0014Ò(\u0002\u0014\tö\u0012\u0011\u0003Æ>\r\u0005ý\nþÎ8\u0012û\u0013\u0002ÿ\u0000ÏDù\u0018ö\u0012üý\u0010Ç:\u0011\u0002\b\bÁL\u0004ú\b\u0002\u0010ú\u0001\u0013À\u001b:úø\u0011\u0001ÿå1\u0002\b\b·\u0005&8\u0001ö\u0012\u0001ø\u0010ì+ú\u000bù\u0002\u0014úÿî\u001a\u0011ú\u0007\u0002Ô\u0011\u0003ÆD\n\u0002\u000b\u0003ó\u001a\bº:\u0003\u0011ý\u0012ôÒ:\u0011\bøÎ<\u0018\u0001ö\u000e\nû\u000b\u0004\nÀ#\"\u000f\u0006ö\u000eø\u0006\u000fþæ4\u0004\u0006\u0002øÿ\u0007\u001bï\r\u0010Ü.µB\u001bï\r\u0010µ\u0013÷\u0012\u0007\u0005\u0007\u0013\u0005ó\u0016\u0007ú\u0002\bÿ\u000bý\u0010ß1ô\u0011ý\u0011\u0003Æ=\u0000\u0007\u0007\u0002\u0012\u0005\u0001ÈIø\u0001\u0007\u0016¿Lù\tù\u0012ø\u000b\u0003\u0012Á0\u001býÿò&ú\u0006ð$\u0005\u0002½\u0005&8\u0001ö\u0012\u0001ø\u0010ì+ú\u000bù\u0002\u0014úÿî\u001a\u0011ú\u0007\u0002Ô\u0011\u0003Æ=\u0000\u0007\u0007\u0002\u0012\u0005\u0001È8\u0014\u0005\u0001\u0002\n\u0002\rÀ\u00184\u0005á\"\n\u0002Þ\"\u0018òÈ\u0012\u0011\u0003ÆJú\f\u0006þ\u0002\u0018ºIø\u0001\u0007\u0016ÿø\u0018ú\u0012ôÎJý\u0003ýÒ-\u0018\u0001\u0017á\u0015\u0014ø\u0005\u000e\nú\f\nä\u0017\u0012\tøÿ\u0007\u0011\u0003Æ>\r\u0005ý\nþÎ:\u0011\u0003\u0005\u0007\u0004Å:\u0011\u0002\u0005þ\u0003\u0016¿$\u0019\u0014â\u0019\u000fÿ\u0012Ü*\u000bö\u0012\u0001ø\u0010æ\u0019\u0014¹\"&\u0016\u0006\u0003ô\u0007\u0016è\u0013\u0001\u000få\u001f\u0019Ñ.\u000b\u0003\f\u0011\u0003Æ>\r\u0005ý\nþÎ=\b\u000eø\u0002\u0004\u0017÷Î:\u0011\u0003\b\u0004\u0004ü\u000e\u000b\u0004À\u001a1\u0003\b\u0004\u0004ü\u000e\u000bã(þ\u000bú\týÄ\u0005&8\u0001ö\u0012\u0001ø\u0010ì+ú\u000bù\u0002\u0014úÿî\u001a\u0011ú\u0007\u0002Ô1\b\u0002\u000b\u0004ú\nüä&\u0002\u0018÷\u0005\u0007\nþé.\u0011\u0003Æ>\r\u0005ý\nþÎ=\b\u000eø\u0002\u0004\u0017÷Î:\u0011\u0003\b\u0004\u0004ü\u000e\u000b\u0004À&&\tú\u000b\u0004ø\u0010é'\u0002\fø\u0000\u0006\u0012·\u0005&8\u0001ö\u0012\u0001ø\u0010ì+ú\u000bù\u0002\u0014úÿî\u001a\u0011ú\u0007\u0002Ö\u0011\u0003Æ>\r\u0005ý\nþÎ:\u0011\u0003\u0005\u0007\u0004Å:\u0011\u0002\u0005þ\u0003\u0016¿)\u0014\u0012þ\u0003ç5\u0002ä\u0017\u0012üý\u0010\u0002\u0016ì\u0018ú\u000b\u0004Û&\u0010ú\u000eû\u0006\u000eú\u000b\u0001\u0013\búÌJû\t\b\u0001þ\u0006\u0011ô\u0011ý\u0017ý\bþÈOú\u0004ÇK\u0003ô\u0012\nø\u000e\b\u0000Æ\u00186\u0005ô\u001dÙ\u0019\u0018ô\n\u0002\u0012\u0011\b\u0002\u000b\u0004ú\nüã4ø\u0001\u0018ú\u000b\u0004\nËH\u0003\tÀC\bý\u0000\u0004\u0007\rÈ:\u0011\bøÎJ\u0002þÊ\u001a;ï\u000e\u0002ÿä8ö\u0005\u0004\u0012ç#ô\u0007\rÿ\u0012".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 806);
        $$d = bArr;
        $$e = 76;
        $$a = new byte[]{49, Ascii.SUB, -88, -35, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13, 9, -18, 36, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, 7, -18, 43, -29, 4, -17, -2, -49, -2, Ascii.VT, 3, -3, 6, -6, 8, -11, Ascii.EM, -33, 19, -2, -8, 37, -44, 17, -12, 8, -14, 9, -18, 34, -25, -4, 17, -19, Ascii.SI, 1, Ascii.DC2, -15, -19, Ascii.VT, -5, 7, 2, -15, 36, -21, -13, Ascii.SI, -2, -9, -6, 34, -15, -19, Ascii.VT, -5, 7, 2, -15, 33, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, -10, Ascii.US, -20, -13, 8, Ascii.VT, Ascii.CR, -27};
        $$b = 39;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        onTransact = -1780294521;
        mayLaunchUrl = -81862504;
        getInterfaceDescriptor = -1840409444;
        ICustomTabsCallbackStubProxy = new byte[]{-120, -75, 73, -66, -108, 107, -75, 76, -68, 71, -101, -104, 6, -71, -4, 119, 70, 71, SignedBytes.MAX_POWER_OF_TWO, -77, 75, -80, 119, -82, 82, -93, 94, 93, -86, 69, -72, -87, -92, 85, 89, -93, 81, 118, -46, 43, -37, 32, -4, -1, Ascii.GS, 35, -41, 47, -28, Ascii.ETB, 49, -49, 45, 118, 121, -115, 84, -93, -115, 106, 97, -73, 125, 115, -115, 126, 113, 121, -125, -116, -15, Ascii.SO, 1, -8, -26, 41, -9, -7, 1, -1, 7, -29, -48, -31, 76, -14, -3, -63, 56, 9, 8, Ascii.SI, -4, 4, -1, 116, 81, -88, 91, -67, 80, 84, 83, 82, -82, -127, 99, -88, -89, 93, -82, 83, -68, -90, 32, -18, -61, Base64.padSymbol, -21, 17, -36, 32, -60, -19, Ascii.DC4, -19, 57, -17, Ascii.DC4, -39, 34, -64, 19, -20, 32, -20, -36, 37, -62, 60, -63, 59, -64, -17, 32, -17, -18, -62, 59, -37, Ascii.DC2, Base64.padSymbol, -59, 62, -63, Ascii.DLE, -21, -17, Ascii.DLE, Base64.padSymbol, Ascii.DLE, Ascii.DLE, -63, -19, -23, 32, -61, 19, 57, -61, 62, -18, -35, -18, Ascii.DC4, -23, 36, -90, -27, Ascii.US, 43, -25, -31, -51, -27, 54, Ascii.SUB, -53, Ascii.EM, -26, Ascii.US, 52, -26, Ascii.US, -31, Ascii.GS, -25, Ascii.ESC, -25, Ascii.EM, -29, Ascii.RS, -54, Ascii.RS, 54, Ascii.EM, Ascii.SUB, -27, -28, Ascii.EM, -54, 55, -53, 40, -26, Ascii.CAN, -31, -62, 54, -43, Ascii.US, -26, 46, -31, Ascii.EM, -32, -49, 43, -25, -50, 55, -26, Ascii.DC2, -25, Ascii.RS, -48, Ascii.ESC, Ascii.SUB, Ascii.SUB, 52, Ascii.CAN};
    }
}
