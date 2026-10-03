package com.salesforce.marketingcloud;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.firebase.messaging.FirebaseMessaging;
import com.swmansion.gesturehandler.core.NativeViewGestureHandler;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import o.ArtificialStackFrames;
import o.onMessageChannelReady;

/* JADX INFO: loaded from: classes3.dex */
public class MCService extends c {
    static final String k = "com.salesforce.marketingcloud.HTTP_REQUEST";
    static final String l = "com.salesforce.marketingcloud.ALARM_WAKE";
    static final String m = "com.salesforce.marketingcloud.SYSTEM_BEHAVIOR";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static final String f25n = "com.salesforce.marketingcloud.TOKEN_REQUEST";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f26o = "behavior";
    private static final String p = "data";
    private static final String q = "alarmName";
    private static final String r = "senderId";
    private static final int s = 3000;
    private static final byte[] $$c = {114, 98, 44, 76};
    private static final int $$f = 57;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$g = {73, -128, -106, 120, Ascii.SI, 1, -60, 60, Ascii.VT, 3, -5, 8, -4, -52, 54, Ascii.DLE, -7, 17, 0, -3, -2, -51, 66, -9, Ascii.SYN, -12, Ascii.DLE, -6, -5, Ascii.SO, -59, 56, Ascii.SI, 0, 6, 6, -65, 74, 2, -8, 6, 0, Ascii.SO, -8, -1, 17, -66, Ascii.EM, 56, -8, -10, Ascii.SI, -1, -3, -29, 47, 0, 6, 6, -75, 3, 36, 54, -1, -12, Ascii.DLE, -1, -10, Ascii.SO, -22, 41, -8, 9, -9, 0, Ascii.DC2, -8, -3, -20, Ascii.CAN, Ascii.SI, -8, 5, 0, -46, 3, SignedBytes.MAX_POWER_OF_TWO, -1, 0, Ascii.SI, 3, -1, -58, -2, 62, 8, 9, -12, Ascii.DLE, -1, -10, Ascii.SO, -59, 76, -1, -66, 39, Ascii.SYN, -1, Ascii.SO, -18, 17, 0, -12, Ascii.US, -9, Ascii.VT, -3, Ascii.DC2, -77, 54, Ascii.RS, -6, Ascii.SO, -12, Ascii.DLE, -27, Ascii.DLE, Ascii.NAK, -5};
    private static final int $$h = 253;
    private static final byte[] $$a = {5, Ascii.ESC, -76, Ascii.CR, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13};
    private static final int $$b = 100;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] validateRelationship = {56001, 55868, 56006, 55856, 55859, 55865, 56060, 55863, 56023, 55849, 55862, 56005, 55869, 56039, 55870, 56007, 55871, 55858, 56016, 55864, 55860, 55867, 56026, 55866};
    private static int warmup = -1044260190;
    private static boolean requestPostMessageChannelWithExtras = true;
    private static boolean ICustomTabsServiceDefault = true;

    class a implements OnCompleteListener<String> {
        final /* synthetic */ String[] a;
        final /* synthetic */ Context b;
        final /* synthetic */ String c;

        a(String[] strArr, Context context, String str) {
            this.a = strArr;
            this.b = context;
            this.c = str;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public void onComplete(@NonNull Task<String> task) {
            if (task.isSuccessful()) {
                this.a[0] = task.getResult();
            }
            com.salesforce.marketingcloud.messages.push.a.a(this.b, !TextUtils.isEmpty(this.a[0]), this.c, this.a[0]);
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$i(byte r7, int r8, short r9) {
        /*
            int r8 = r8 * 2
            int r8 = r8 + 4
            int r7 = 121 - r7
            byte[] r0 = com.salesforce.marketingcloud.MCService.$$c
            int r9 = r9 * 4
            int r9 = 1 - r9
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r8
            r4 = r2
            goto L2a
        L14:
            r3 = r2
            r6 = r8
            r8 = r7
            r7 = r6
        L18:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r9) goto L25
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            return r7
        L25:
            r3 = r0[r7]
            r6 = r3
            r3 = r7
            r7 = r6
        L2a:
            int r7 = -r7
            int r8 = r8 + r7
            int r7 = r3 + 1
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.MCService.$$i(byte, int, short):java.lang.String");
    }

    public static void a(@NonNull Context context, @NonNull com.salesforce.marketingcloud.http.c cVar) {
        g.d(c.h, "enqueue handleHttpRequest - %s", cVar.s());
        a(context, k, cVar.h());
    }

    private static void t(short s2, byte b, byte b2, Object[] objArr) {
        byte[] bArr = $$a;
        int i = 20 - (b * 8);
        int i2 = (b2 * 28) + 84;
        int i3 = s2 * 3;
        byte[] bArr2 = new byte[12 - i3];
        int i4 = 11 - i3;
        int i5 = -1;
        if (bArr == null) {
            i2 += -i4;
            i++;
        }
        while (true) {
            i5++;
            bArr2[i5] = (byte) i2;
            if (i5 == i4) {
                objArr[0] = new String(bArr2, 0);
                return;
            } else {
                i2 += -bArr[i];
                i++;
            }
        }
    }

    private static void v(short s2, byte b, int i, Object[] objArr) {
        int i2 = 111 - (i * 3);
        byte[] bArr = $$g;
        int i3 = 87 - s2;
        byte[] bArr2 = new byte[82 - b];
        int i4 = 81 - b;
        int i5 = -1;
        if (bArr == null) {
            i3++;
            i2 = (i2 + i4) - 3;
        }
        while (true) {
            i5++;
            bArr2[i5] = (byte) i2;
            if (i5 == i4) {
                objArr[0] = new String(bArr2, 0);
                return;
            } else {
                byte b2 = bArr[i3];
                i3++;
                i2 = (i2 + b2) - 3;
            }
        }
    }

    @Override // com.salesforce.marketingcloud.c
    public /* bridge */ /* synthetic */ void b(boolean z) {
        super.b(z);
    }

    @Override // com.salesforce.marketingcloud.c
    public /* bridge */ /* synthetic */ boolean c() {
        return super.c();
    }

    @Override // com.salesforce.marketingcloud.c
    public /* bridge */ /* synthetic */ boolean d() {
        return super.d();
    }

    @Override // com.salesforce.marketingcloud.c, android.app.Service
    public /* bridge */ /* synthetic */ IBinder onBind(@NonNull Intent intent) {
        return super.onBind(intent);
    }

    @Override // com.salesforce.marketingcloud.c, android.app.Service
    public /* bridge */ /* synthetic */ void onCreate() {
        super.onCreate();
    }

    @Override // com.salesforce.marketingcloud.c, android.app.Service
    public /* bridge */ /* synthetic */ void onDestroy() {
        super.onDestroy();
    }

    @Override // com.salesforce.marketingcloud.c, android.app.Service
    public /* bridge */ /* synthetic */ int onStartCommand(@Nullable Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    public static void b(@NonNull Context context, @NonNull String str) {
        g.d(c.h, "enqueueTokenRequest", new Object[0]);
        Bundle bundle = new Bundle();
        bundle.putString(r, str);
        a(context, f25n, bundle);
    }

    private static void c(Context context, String str) {
        if (str == null) {
            g.d(c.h, "alarm name not provided", new Object[0]);
        } else {
            g.d(c.h, "handleAlarmWakeup - %s", str);
            context.sendBroadcast(new Intent(com.salesforce.marketingcloud.alarms.b.j).putExtra("com.salesforce.marketingcloud.WAKE_FOR_ALARM", str).setPackage(context.getPackageName()));
        }
    }

    static void d(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            g.a(c.h, "Unable to refresh system token.  SenderId was invalid", new Object[0]);
            return;
        }
        g.d(c.h, "handleTokenRequest", new Object[0]);
        try {
            FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new a(new String[]{null}, context, str));
        } catch (Exception e) {
            g.b(c.h, e, "Failed to retrieve InstanceId from Firebase.", new Object[0]);
        }
    }

    public static void a(@NonNull Context context, String str) {
        g.d(c.h, "enqueueAlarmWake - %s", str);
        Bundle bundle = new Bundle();
        bundle.putString(q, str);
        a(context, l, bundle);
    }

    static void b(Context context, com.salesforce.marketingcloud.http.c cVar) throws Throwable {
        com.salesforce.marketingcloud.http.f fVarA;
        if (cVar == null) {
            g.d(c.h, "request was null", new Object[0]);
            return;
        }
        g.d(c.h, "handleHttpRequest - %s", cVar.s());
        if (a(context)) {
            fVarA = cVar.k();
        } else {
            fVarA = com.salesforce.marketingcloud.http.f.a("No connectivity", -1);
        }
        context.sendBroadcast(new Intent(com.salesforce.marketingcloud.http.e.j).putExtra(com.salesforce.marketingcloud.http.e.l, cVar.h()).putExtra(com.salesforce.marketingcloud.http.e.k, fVarA).setPackage(context.getPackageName()));
    }

    static void a(@NonNull Context context, @NonNull com.salesforce.marketingcloud.behaviors.a aVar, @Nullable Bundle bundle) {
        g.d(c.h, "enqueueSystemBehavior - %s", aVar);
        Bundle bundle2 = new Bundle();
        bundle2.putString(f26o, aVar.b);
        bundle2.putBundle("data", bundle);
        a(context, m, bundle2);
    }

    private static void a(Context context, String str, Bundle bundle) {
        c.a(context, MCService.class, 3000, new Intent(str).putExtras(bundle));
    }

    private static boolean a(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnectedOrConnecting()) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:26:0x0050  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.salesforce.marketingcloud.c
    protected void a(@NonNull Intent intent) throws Throwable {
        String action = intent.getAction();
        if (action == null) {
            return;
        }
        Context applicationContext = getApplicationContext();
        byte b = 0;
        if (!com.salesforce.marketingcloud.util.j.a(3000L, 50L) || MarketingCloudSdk.getInstance() == null) {
            g.e(c.h, "MarketingCloudSdk#init must be called in your application's onCreate", new Object[0]);
            return;
        }
        switch (action.hashCode()) {
            case -1341919505:
                if (!action.equals(l)) {
                    b = -1;
                }
                break;
            case -525195028:
                if (!action.equals(f25n)) {
                    b = -1;
                } else {
                    b = 1;
                }
                break;
            case 352488053:
                if (!action.equals(k)) {
                    b = -1;
                } else {
                    b = 2;
                }
                break;
            case 848031877:
                if (!action.equals(m)) {
                    b = -1;
                } else {
                    b = 3;
                }
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            c(applicationContext, intent.getStringExtra(q));
            return;
        }
        if (b == 1) {
            d(applicationContext, intent.getStringExtra(r));
            return;
        }
        if (b != 2) {
            if (b != 3) {
                return;
            }
            b(applicationContext, com.salesforce.marketingcloud.behaviors.a.a(intent.getStringExtra(f26o)), intent.getBundleExtra("data"));
        } else {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                b(applicationContext, com.salesforce.marketingcloud.http.c.a(extras));
            }
        }
    }

    private static void b(Context context, com.salesforce.marketingcloud.behaviors.a aVar, Bundle bundle) {
        if (aVar == null) {
            g.d(c.h, "Behavior was null", new Object[0]);
        } else {
            g.d(c.h, "handleSystemBehavior - %s", aVar);
            com.salesforce.marketingcloud.behaviors.c.a(context, aVar, bundle);
        }
    }

    private static void u(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        onMessageChannelReady onmessagechannelready = new onMessageChannelReady();
        char[] cArr2 = validateRelationship;
        long j = 0;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i3 = 0;
            while (i3 < length) {
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr2[i3])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(115862995);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) 0;
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((KeyEvent.getMaxKeyCode() >> 16) + 26, (char) ExpandableListView.getPackedPositionGroup(j), 1041 - Gravity.getAbsoluteGravity(0, 0), -1719489573, false, $$i(b, b2, b2), new Class[]{Integer.TYPE});
                    }
                    cArr3[i3] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i3++;
                    j = 0;
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
        try {
            Object[] objArr3 = {Integer.valueOf(warmup)};
            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1820173622);
            if (objAccessartificialFrame2 == null) {
                byte b3 = (byte) 0;
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(ImageFormat.getBitsPerPixel(0) + 16, (char) (TextUtils.indexOf("", "") + 20488), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 2147, 216472770, false, $$i((byte) ($$f - 3), b3, b3), new Class[]{Integer.TYPE});
            }
            int iIntValue = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
            int i4 = 59174;
            int i5 = -2083387879;
            if (ICustomTabsServiceDefault) {
                int i6 = $10 + 9;
                $11 = i6 % 128;
                int i7 = i6 % 2;
                onmessagechannelready.c = bArr.length;
                char[] cArr4 = new char[onmessagechannelready.c];
                onmessagechannelready.a = 0;
                while (onmessagechannelready.a < onmessagechannelready.c) {
                    cArr4[onmessagechannelready.a] = (char) (cArr2[bArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] + i] - iIntValue);
                    Object[] objArr4 = {onmessagechannelready, onmessagechannelready};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(i5);
                    if (objAccessartificialFrame3 == null) {
                        byte b4 = (byte) 0;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(TextUtils.getTrimmedLength("") + 21, (char) ((ViewConfiguration.getEdgeSlop() >> 16) + i4), 1942 - ExpandableListView.getPackedPositionChild(0L), 481771537, false, $$i((byte) ($$f - 2), b4, b4), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                    i4 = 59174;
                    i5 = -2083387879;
                }
                objArr[0] = new String(cArr4);
                return;
            }
            if (!requestPostMessageChannelWithExtras) {
                onmessagechannelready.c = iArr.length;
                char[] cArr5 = new char[onmessagechannelready.c];
                onmessagechannelready.a = 0;
                while (onmessagechannelready.a < onmessagechannelready.c) {
                    cArr5[onmessagechannelready.a] = (char) (cArr2[iArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                    onmessagechannelready.a++;
                }
                objArr[0] = new String(cArr5);
                return;
            }
            onmessagechannelready.c = cArr.length;
            char[] cArr6 = new char[onmessagechannelready.c];
            onmessagechannelready.a = 0;
            while (onmessagechannelready.a < onmessagechannelready.c) {
                int i8 = $10 + 81;
                $11 = i8 % 128;
                if (i8 % 2 == 0) {
                    cArr6[onmessagechannelready.a] = (char) (cArr2[cArr[(onmessagechannelready.c / 0) >>> onmessagechannelready.a] << i] % iIntValue);
                    Object[] objArr5 = {onmessagechannelready, onmessagechannelready};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                    if (objAccessartificialFrame4 == null) {
                        byte b5 = (byte) 0;
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(TextUtils.getCapsMode("", 0, 0) + 21, (char) (Gravity.getAbsoluteGravity(0, 0) + 59174), 1943 - (ViewConfiguration.getTapTimeout() >> 16), 481771537, false, $$i((byte) ($$f - 2), b5, b5), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                } else {
                    cArr6[onmessagechannelready.a] = (char) (cArr2[cArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                    Object[] objArr6 = {onmessagechannelready, onmessagechannelready};
                    Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                    if (objAccessartificialFrame5 == null) {
                        byte b6 = (byte) 0;
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(21 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) (59174 - ExpandableListView.getPackedPositionType(0L)), 1943 - View.MeasureSpec.getSize(0), 481771537, false, $$i((byte) ($$f - 2), b6, b6), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame5).invoke(null, objArr6);
                }
            }
            objArr[0] = new String(cArr6);
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 == null) {
                throw th2;
            }
            throw cause2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x018a  */
    /* JADX WARN: Code duplicated, block: B:16:0x0214 A[Catch: all -> 0x09be, TryCatch #2 {all -> 0x09be, blocks: (B:51:0x06d7, B:53:0x06eb, B:54:0x0717, B:14:0x01f4, B:16:0x0214, B:17:0x0256), top: B:95:0x01f4 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0268  */
    /* JADX WARN: Code duplicated, block: B:25:0x0331  */
    /* JADX WARN: Code duplicated, block: B:50:0x0675  */
    /* JADX WARN: Code duplicated, block: B:53:0x06eb A[Catch: all -> 0x09be, TryCatch #2 {all -> 0x09be, blocks: (B:51:0x06d7, B:53:0x06eb, B:54:0x0717, B:14:0x01f4, B:16:0x0214, B:17:0x0256), top: B:95:0x01f4 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x072d  */
    /* JADX WARN: Code duplicated, block: B:62:0x07d8  */
    @Override // com.salesforce.marketingcloud.c, android.app.Service, android.content.ContextWrapper
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
            int iAxisFromString = 24 - MotionEvent.axisFromString("");
            char bitsPerPixel = (char) (30067 - ImageFormat.getBitsPerPixel(0));
            int iRgb = (-16776400) - Color.rgb(0, 0, 0);
            byte[] bArr = $$a;
            byte b = bArr[5];
            Object[] objArr2 = new Object[1];
            t(b, bArr[8], b, objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iAxisFromString, bitsPerPixel, iRgb, 721586079, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 2050;
            Object[] objArr3 = new Object[1];
            u(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 92, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            u(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + com.salesforce.marketingcloud.analytics.stats.b.l, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, null, null, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame8 == null) {
                    int iIndexOf = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 26;
                    char pressedStateDuration = (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 30068);
                    int iMyPid = 816 - (Process.myPid() >> 22);
                    byte b2 = $$a[5];
                    byte b3 = b2;
                    Object[] objArr5 = new Object[1];
                    t(b2, b3, b3, objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iIndexOf, pressedStateDuration, iMyPid, 891606461, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i2 = ((int[]) objArr6[0])[0];
                int i3 = ((int[]) objArr6[1])[0];
                String[] strArr = (String[]) objArr6[2];
                int iIdentityHashCode = System.identityHashCode(this);
                int i4 = ~iIdentityHashCode;
                int i5 = (((1264953413 + (((~((-6464519) | i4)) | 6299654) * 168)) + ((~((-6299655) | iIdentityHashCode)) * 168)) + (((~(iIdentityHashCode | (-164865))) | ((~(i4 | (-191707848))) | 185408193)) * 168)) - 1550015594;
                int i6 = (i5 << 13) ^ i5;
                int i7 = i6 ^ (i6 >>> 17);
                ((int[]) objArr[3])[0] = i7 ^ (i7 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                u(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 91, new byte[]{-115, -116, -117, -120, -118, -119, -121, -106, -126, -127, -113, -121, -127, -107, -127, -108}, null, null, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                u(127 - Color.green(0), new byte[]{-116, -125, -123, -114, -104, -120, -127, -105, -118, -117, -122, -117, -126, -116, -125, -122}, null, null, objArr8);
                try {
                    Object[] objArr9 = {Integer.valueOf(((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue()), 0, -1550015594};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame == null) {
                        int iResolveSizeAndState = View.resolveSizeAndState(0, 0, 0) + 25;
                        char cCombineMeasuredStates = (char) (View.combineMeasuredStates(0, 0) + 30068);
                        int offsetBefore = TextUtils.getOffsetBefore("", 0) + 816;
                        byte b4 = (byte) ($$a[5] - 1);
                        byte b5 = b4;
                        Object[] objArr10 = new Object[1];
                        t(b4, b5, b5, objArr10);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState, cCombineMeasuredStates, offsetBefore, -797394565, false, (String) objArr10[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr9);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame2 == null) {
                        int longPressTimeout = 25 - (ViewConfiguration.getLongPressTimeout() >> 16);
                        char maximumFlingVelocity = (char) (30068 - (ViewConfiguration.getMaximumFlingVelocity() >> 16));
                        int iGreen = Color.green(0) + 816;
                        byte b6 = $$a[5];
                        byte b7 = b6;
                        Object[] objArr11 = new Object[1];
                        t(b6, b7, b7, objArr11);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(longPressTimeout, maximumFlingVelocity, iGreen, 891606461, false, (String) objArr11[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArr);
                    try {
                        Object[] objArr12 = new Object[1];
                        u(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(2) + 11, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr12);
                        Class<?> cls3 = Class.forName((String) objArr12[0]);
                        Object[] objArr13 = new Object[1];
                        u(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) + 90, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, null, null, objArr13);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr13[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame3 == null) {
                            int iMyTid = (Process.myTid() >> 22) + 25;
                            char c = (char) (30069 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                            int capsMode = 816 - TextUtils.getCapsMode("", 0, 0);
                            byte[] bArr2 = $$a;
                            byte b8 = bArr2[5];
                            Object[] objArr14 = new Object[1];
                            t(b8, bArr2[8], b8, objArr14);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iMyTid, c, capsMode, 721586079, false, (String) objArr14[0], null);
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
            u(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 91, new byte[]{-115, -116, -117, -120, -118, -119, -121, -106, -126, -127, -113, -121, -127, -107, -127, -108}, null, null, objArr15);
            Class<?> cls4 = Class.forName((String) objArr15[0]);
            Object[] objArr16 = new Object[1];
            u(127 - Color.green(0), new byte[]{-116, -125, -123, -114, -104, -120, -127, -105, -118, -117, -122, -117, -126, -116, -125, -122}, null, null, objArr16);
            Object[] objArr17 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue()), 0, -1550015594};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame == null) {
                int iResolveSizeAndState2 = View.resolveSizeAndState(0, 0, 0) + 25;
                char cCombineMeasuredStates2 = (char) (View.combineMeasuredStates(0, 0) + 30068);
                int offsetBefore2 = TextUtils.getOffsetBefore("", 0) + 816;
                byte b9 = (byte) ($$a[5] - 1);
                byte b10 = b9;
                Object[] objArr18 = new Object[1];
                t(b9, b10, b10, objArr18);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState2, cCombineMeasuredStates2, offsetBefore2, -797394565, false, (String) objArr18[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr17);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame2 == null) {
                int longPressTimeout2 = 25 - (ViewConfiguration.getLongPressTimeout() >> 16);
                char maximumFlingVelocity2 = (char) (30068 - (ViewConfiguration.getMaximumFlingVelocity() >> 16));
                int iGreen2 = Color.green(0) + 816;
                byte b11 = $$a[5];
                byte b12 = b11;
                Object[] objArr19 = new Object[1];
                t(b11, b12, b12, objArr19);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(longPressTimeout2, maximumFlingVelocity2, iGreen2, 891606461, false, (String) objArr19[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArr);
            Object[] objArr110 = new Object[1];
            u(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(2) + 11, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr110);
            Class<?> cls5 = Class.forName((String) objArr110[0]);
            Object[] objArr111 = new Object[1];
            u(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) + 90, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, null, null, objArr111);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr111[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame3 == null) {
                int iMyTid2 = (Process.myTid() >> 22) + 25;
                char c2 = (char) (30069 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                int capsMode2 = 816 - TextUtils.getCapsMode("", 0, 0);
                byte[] bArr3 = $$a;
                byte b13 = bArr3[5];
                Object[] objArr112 = new Object[1];
                t(b13, bArr3[8], b13, objArr112);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iMyTid2, c2, capsMode2, 721586079, false, (String) objArr112[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i8 = ((int[]) objArr[1])[0];
        int i9 = ((int[]) objArr[0])[0];
        if (i9 == i8) {
            Object[] objArr20 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i10 = ((int[]) objArr[3])[0];
            int i11 = ((int[]) objArr[0])[0];
            int i12 = ((int[]) objArr[1])[0];
            String[] strArr2 = (String[]) objArr[2];
            int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 1948316742;
            int i13 = 535149528 + (((~((~length) | 846871961)) | (-1048198656)) * (-245));
            int i14 = ~(length | 846871961);
            int i15 = i10 + i13 + (i14 * (-245)) + ((i14 | 1045044327) * 245);
            int i16 = (i15 << 13) ^ i15;
            int i17 = i16 ^ (i16 >>> 17);
            ((int[]) objArr20[3])[0] = i17 ^ (i17 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr[2];
            if (strArr3 != null) {
                for (String str : strArr3) {
                    int i18 = artificialFrame + 5;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i18 % 128;
                    int i19 = i18 % 2;
                    arrayList.add(str);
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf((((long) (-536416261)) << 32) ^ ((long) (i8 ^ i9))), Long.valueOf(-536416262)};
                byte[] bArr4 = $$g;
                Object[] objArr22 = new Object[1];
                v((byte) 83, bArr4[18], (byte) (-bArr4[12]), objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                byte b14 = bArr4[38];
                Object[] objArr23 = new Object[1];
                v(b14, (byte) (b14 | 77), bArr4[47], objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i20 = ((int[]) objArr[3])[0];
                int i21 = ((int[]) objArr[0])[0];
                int i22 = ((int[]) objArr[1])[0];
                String[] strArr4 = (String[]) objArr[2];
                int i23 = (int) Runtime.getRuntime().totalMemory();
                int i24 = i20 + (-101806364) + (((-271062209) | i23) * (-627)) + (((~(304879090 | i23)) | 503051456) * (-627)) + (((~(i23 | 503051456)) | (~((~i23) | (-304879091)))) * 627);
                int i25 = (i24 << 13) ^ i24;
                int i26 = i25 ^ (i25 >>> 17);
                ((int[]) objArr24[3])[0] = i26 ^ (i26 << 5);
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
            int keyRepeatDelay = 26 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
            char trimmedLength = (char) TextUtils.getTrimmedLength("");
            int iCombineMeasuredStates = 1041 - View.combineMeasuredStates(0, 0);
            byte[] bArr5 = $$a;
            byte b15 = bArr5[5];
            Object[] objArr25 = new Object[1];
            t(b15, bArr5[8], b15, objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay, trimmedLength, iCombineMeasuredStates, 2061780482, false, (String) objArr25[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j3 != -1) {
            long j4 = j3 + 4611686018427387841L;
            Object[] objArr26 = new Object[1];
            u(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) + 12, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            u(Color.argb(0, 0, 0, 0) + 127, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, null, null, objArr27);
            if (j4 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame10 == null) {
                    int iCombineMeasuredStates2 = 26 - View.combineMeasuredStates(0, 0);
                    char windowTouchSlop = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                    int fadingEdgeLength = 1041 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                    byte b16 = $$a[5];
                    byte b17 = b16;
                    Object[] objArr28 = new Object[1];
                    t(b16, b17, b17, objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates2, windowTouchSlop, fadingEdgeLength, 1145017376, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i27 = ((int[]) objArr29[3])[0];
                int i28 = ((int[]) objArr29[2])[0];
                String[] strArr5 = (String[]) objArr29[0];
                int i29 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenWidthDp;
                int i30 = ~i29;
                int i31 = 593417054 + ((~(644488974 | i30)) * (-560)) + ((~(i29 | 669671183)) * (-560)) + (((~((-566385168) | i30)) | 541202958) * 560) + 1757771145;
                int i32 = (i31 << 13) ^ i31;
                int i33 = i32 ^ (i32 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i33 ^ (i33 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                u((ViewConfiguration.getFadingEdgeLength() >> 16) + 127, new byte[]{-115, -116, -117, -120, -118, -119, -121, -106, -126, -127, -113, -121, -127, -107, -127, -108}, null, null, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                u(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 92, new byte[]{-116, -125, -123, -114, -104, -120, -127, -105, -118, -117, -122, -117, -126, -116, -125, -122}, null, null, objArr31);
                int iIntValue = ((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue();
                Object[] objArr32 = {-1331026461};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(8 - (Process.myPid() >> 22), (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 22250), View.MeasureSpec.makeMeasureSpec(0, 0) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr32), 1757771145, false);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame5 == null) {
                    int doubleTapTimeout = 26 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                    char gidForName = (char) ((-1) - Process.getGidForName(""));
                    int i34 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 1041;
                    byte b18 = $$a[5];
                    byte b19 = b18;
                    Object[] objArr33 = new Object[1];
                    t(b18, b19, b19, objArr33);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout, gidForName, i34, 1145017376, false, (String) objArr33[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Object[] objArr34 = new Object[1];
                    u(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + com.salesforce.marketingcloud.analytics.stats.b.l, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr34);
                    Class<?> cls9 = Class.forName((String) objArr34[0]);
                    Object[] objArr35 = new Object[1];
                    u(KeyEvent.keyCodeFromString("") + 127, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, null, null, objArr35);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr35[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame6 == null) {
                        int keyRepeatDelay2 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 26;
                        char longPressTimeout3 = (char) (ViewConfiguration.getLongPressTimeout() >> 16);
                        int i35 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 1041;
                        byte[] bArr6 = $$a;
                        byte b20 = bArr6[5];
                        Object[] objArr36 = new Object[1];
                        t(b20, bArr6[8], b20, objArr36);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay2, longPressTimeout3, i35, 2061780482, false, (String) objArr36[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr37 = new Object[1];
            u((ViewConfiguration.getFadingEdgeLength() >> 16) + 127, new byte[]{-115, -116, -117, -120, -118, -119, -121, -106, -126, -127, -113, -121, -127, -107, -127, -108}, null, null, objArr37);
            Class<?> cls10 = Class.forName((String) objArr37[0]);
            Object[] objArr38 = new Object[1];
            u(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 92, new byte[]{-116, -125, -123, -114, -104, -120, -127, -105, -118, -117, -122, -117, -126, -116, -125, -122}, null, null, objArr38);
            int iIntValue2 = ((Integer) cls10.getMethod((String) objArr38[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr39 = {-1331026461};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(8 - (Process.myPid() >> 22), (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 22250), View.MeasureSpec.makeMeasureSpec(0, 0) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr39), 1757771145, false);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame5 == null) {
                int doubleTapTimeout2 = 26 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                char gidForName2 = (char) ((-1) - Process.getGidForName(""));
                int i36 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 1041;
                byte b110 = $$a[5];
                byte b111 = b110;
                Object[] objArr310 = new Object[1];
                t(b110, b111, b111, objArr310);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout2, gidForName2, i36, 1145017376, false, (String) objArr310[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr311 = new Object[1];
            u(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + com.salesforce.marketingcloud.analytics.stats.b.l, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr311);
            Class<?> cls11 = Class.forName((String) objArr311[0]);
            Object[] objArr312 = new Object[1];
            u(KeyEvent.keyCodeFromString("") + 127, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, null, null, objArr312);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr312[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame6 == null) {
                int keyRepeatDelay3 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 26;
                char longPressTimeout4 = (char) (ViewConfiguration.getLongPressTimeout() >> 16);
                int i37 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 1041;
                byte[] bArr7 = $$a;
                byte b21 = bArr7[5];
                Object[] objArr313 = new Object[1];
                t(b21, bArr7[8], b21, objArr313);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay3, longPressTimeout4, i37, 2061780482, false, (String) objArr313[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i38 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i39 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i39 == i38) {
            int i40 = artificialFrame + 101;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i40 % 128;
            int i41 = i40 % 2;
            Object[] objArr40 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i42 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i43 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i44 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr6 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i45 = ~iIdentityHashCode2;
            int i46 = i42 + ((((-1088259046) + (((~(947045082 | i45)) | (~((-1025148890) | iIdentityHashCode2))) * (-370))) + ((((~(iIdentityHashCode2 | 947045082)) | (~(i45 | (-1025148890)))) | 6307842) * (-370))) - 1961065756);
            int i47 = (i46 << 13) ^ i46;
            int i48 = i47 ^ (i47 >>> 17);
            ((int[]) objArr40[1])[0] = i48 ^ (i48 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        if (strArr7 != null) {
            int i49 = getARTIFICIAL_FRAME_PACKAGE_NAME + 73;
            artificialFrame = i49 % 128;
            int i50 = i49 % 2;
            for (String str2 : strArr7) {
                arrayList2.add(str2);
            }
        }
        long j5 = ((long) (i38 ^ i39)) ^ (((long) 522902171) << 32);
        long j6 = 522902169;
        int i51 = artificialFrame + 63;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i51 % 128;
        int i52 = i51 % 2;
        Object[] objArr41 = {Long.valueOf(j5), Long.valueOf(j6)};
        byte[] bArr8 = $$g;
        byte b22 = bArr8[18];
        byte b23 = b22;
        Object[] objArr42 = new Object[1];
        v(b23, (byte) (b23 | 38), b22, objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        byte b24 = bArr8[38];
        Object[] objArr43 = new Object[1];
        v(b24, (byte) (b24 | 77), bArr8[47], objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {strArr, new int[1], new int[]{i}, new int[]{i}};
        int i53 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
        int i54 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        int i55 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        String[] strArr8 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) + 212591181;
        int i56 = i53 + 204476696 + (((~(iCodePointAt | (-447835128))) | (-525938935)) * (-465)) + (((-447835128) | (~((-525938935) | iCodePointAt))) * 930) + ((iCodePointAt | (-437330167)) * 465);
        int i57 = (i56 << 13) ^ i56;
        int i58 = i57 ^ (i57 >>> 17);
        ((int[]) objArr44[1])[0] = i58 ^ (i58 << 5);
    }
}
