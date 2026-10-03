package com.salesforce.marketingcloud.messages.push;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.os.Process;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.base.Ascii;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.salesforce.marketingcloud.MCService;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.g;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.util.j;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import kotlinx.serialization.internal.HashMapClassDesc;
import net.pluservice.unicoc.R;
import o.ArtificialStackFrames;
import o.onRelationshipValidationResult;

/* JADX INFO: loaded from: classes6.dex */
public class MCFirebaseMessagingService extends FirebaseMessagingService {
    private static final String a;
    private static long onPostMessage;
    private static final byte[] $$s = {87, 9, 66, Ascii.SYN};
    private static final int $$t = 200;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$j = {Ascii.DC4, 17, 111, Ascii.ESC, 1, 0, -15, -3, 1, 58, 2, -62, -8, -9, Ascii.FF, -16, 1, 10, -14, 59, -76, 1, 66, -39, -22, 1, -14, Ascii.DC2, -17, 0, Ascii.FF, -31, 9, -11, 3, -18, 77, -54, -30, 6, -14, Ascii.FF, -16, Ascii.ESC, -16, -21, 5, -3, -64, -15, -1, 60, -60, -11, -3, 5, -8, 4, 52, -54, -16, 7, -17, 0, 3, 2, 51, -66, 9, -22, Ascii.FF, -16, 6, 5, -14, 59, -56, -15, 0, -6, -6, 65, -74, -2, 8, -6, 0, -14, 8, 1, -17, 66, -25, -56, 8, 10, -15, 1, 3, Ascii.GS, -47, 0, -6, -6, 75, -3, -36, -54, 1, Ascii.FF, -16, 1, 10, -14, Ascii.SYN, -41, 8, -9, 9, 0, -18, 8, 3, Ascii.DC4, -24, -15, 8, -5, 0, 46};
    private static final int $$k = 14;
    private static final byte[] $$g = {84, -108, -95, 40, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13};
    private static final int $$h = com.salesforce.marketingcloud.analytics.stats.b.i;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$u(byte r6, int r7, int r8) {
        /*
            byte[] r0 = com.salesforce.marketingcloud.messages.push.MCFirebaseMessagingService.$$s
            int r8 = r8 * 4
            int r8 = r8 + 1
            int r6 = r6 + 4
            int r7 = r7 * 2
            int r7 = 111 - r7
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r6
            r4 = r2
            goto L2d
        L14:
            r3 = r2
            r5 = r7
            r7 = r6
            r6 = r5
        L18:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r8) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L25:
            int r7 = r7 + 1
            r4 = r0[r7]
            r5 = r3
            r3 = r7
            r7 = r4
            r4 = r5
        L2d:
            int r7 = -r7
            int r6 = r6 + r7
            r7 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.messages.push.MCFirebaseMessagingService.$$u(byte, int, int):java.lang.String");
    }

    static {
        accessartificialFrame();
        a = g.a("MCFirebaseMessagingService");
    }

    static void a(@NonNull Context context) {
        MarketingCloudSdk marketingCloudSdkA = a();
        if (marketingCloudSdkA == null) {
            g.e(a, "Marketing Cloud SDK init failed.  Unable to update push token.", new Object[0]);
            return;
        }
        String strSenderId = marketingCloudSdkA.getMarketingCloudConfig().senderId();
        if (strSenderId != null) {
            MCService.b(context, strSenderId);
        } else {
            g.a(a, "Received new token intent but senderId was not set.", new Object[0]);
        }
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
    private static void h(short r7, short r8, int r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = com.salesforce.marketingcloud.messages.push.MCFirebaseMessagingService.$$g
            int r8 = r8 * 3
            int r8 = 12 - r8
            int r9 = r9 * 8
            int r9 = 19 - r9
            int r7 = r7 * 28
            int r7 = r7 + 84
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r9
            r4 = r2
            r9 = r8
            goto L2f
        L17:
            r3 = r2
        L18:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            int r9 = r9 + 1
            if (r4 != r8) goto L29
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L29:
            r3 = r0[r9]
            r6 = r9
            r9 = r7
            r7 = r3
            r3 = r6
        L2f:
            int r7 = -r7
            int r7 = r7 + r9
            r9 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.messages.push.MCFirebaseMessagingService.h(short, short, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x0028). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void j(int r5, byte r6, int r7, java.lang.Object[] r8) {
        /*
            int r7 = r7 * 3
            int r7 = 111 - r7
            byte[] r0 = com.salesforce.marketingcloud.messages.push.MCFirebaseMessagingService.$$j
            int r1 = 82 - r6
            int r5 = 48 - r5
            byte[] r1 = new byte[r1]
            int r6 = 81 - r6
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r6
            r4 = r2
            goto L28
        L14:
            r3 = r2
        L15:
            int r5 = r5 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L26
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L26:
            r3 = r0[r5]
        L28:
            int r3 = -r3
            int r7 = r7 + r3
            int r7 = r7 + (-3)
            r3 = r4
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.messages.push.MCFirebaseMessagingService.j(int, byte, int, java.lang.Object[]):void");
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        g.d(a, "onMessageReceived()", new Object[0]);
        a(remoteMessage);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String str) {
        a(this);
    }

    static void a(@Nullable RemoteMessage remoteMessage) {
        String str;
        if (remoteMessage == null) {
            g.e(a, "RemoteMessage was null.", new Object[0]);
            return;
        }
        if (remoteMessage.getData() != null && remoteMessage.getData().containsKey(NotificationMessage.NOTIF_KEY_ID)) {
            str = remoteMessage.getData().get(NotificationMessage.NOTIF_KEY_ID);
        } else {
            str = "Unknown Message";
        }
        String str2 = a;
        g.d(str2, "onMessageReceived() for MessageID: '%s'", str);
        MarketingCloudSdk marketingCloudSdkA = a();
        if (marketingCloudSdkA == null) {
            g.e(str2, "Marketing Cloud SDK init failed.  Push message ignored.", new Object[0]);
        } else {
            marketingCloudSdkA.getPushMessageManager().handleMessage(remoteMessage);
        }
    }

    private static MarketingCloudSdk a() {
        if (j.a(3000L, 50L) && MarketingCloudSdk.getInstance() != null) {
            return MarketingCloudSdk.getInstance();
        }
        g.e(a, "MarketingCloudSdk#init must be called in your application's onCreate", new Object[0]);
        return null;
    }

    private static void i(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        onRelationshipValidationResult onrelationshipvalidationresult = new onRelationshipValidationResult();
        char[] cArrAccessartificialFrame = onRelationshipValidationResult.accessartificialFrame(onPostMessage ^ 2573525503365829440L, cArr, i);
        onrelationshipvalidationresult.e = 4;
        while (onrelationshipvalidationresult.e < cArrAccessartificialFrame.length) {
            int i3 = $10 + 55;
            $11 = i3 % 128;
            int i4 = i3 % 2;
            onrelationshipvalidationresult.d = onrelationshipvalidationresult.e - 4;
            int i5 = onrelationshipvalidationresult.e;
            try {
                Object[] objArr2 = {Long.valueOf(cArrAccessartificialFrame[onrelationshipvalidationresult.e] ^ cArrAccessartificialFrame[onrelationshipvalidationresult.e % 4]), Long.valueOf(onrelationshipvalidationresult.d), Long.valueOf(onPostMessage)};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(797310229);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(27 - ExpandableListView.getPackedPositionGroup(0L), (char) (30690 - View.resolveSize(0, 0)), 188 - (ViewConfiguration.getDoubleTapTimeout() >> 16), -1327449315, false, "k", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                }
                cArrAccessartificialFrame[i5] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                Object[] objArr3 = {onrelationshipvalidationresult, onrelationshipvalidationresult};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(321542193);
                if (objAccessartificialFrame2 == null) {
                    byte b = (byte) (-1);
                    byte b2 = (byte) (b + 1);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(View.MeasureSpec.makeMeasureSpec(0, 0) + 33, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), View.combineMeasuredStates(0, 0) + 1483, -1940971975, false, $$u(b, b2, b2), new Class[]{Object.class, Object.class});
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
        String str = new String(cArrAccessartificialFrame, 4, cArrAccessartificialFrame.length - 4);
        int i6 = $10 + 19;
        $11 = i6 % 128;
        int i7 = i6 % 2;
        objArr[0] = str;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x018c  */
    /* JADX WARN: Code duplicated, block: B:17:0x0226 A[Catch: all -> 0x099e, TryCatch #2 {all -> 0x099e, blocks: (B:55:0x0699, B:57:0x06ba, B:58:0x0704, B:15:0x0212, B:17:0x0226, B:18:0x0252), top: B:99:0x0212 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0268  */
    /* JADX WARN: Code duplicated, block: B:26:0x0334  */
    /* JADX WARN: Code duplicated, block: B:54:0x0650  */
    /* JADX WARN: Code duplicated, block: B:57:0x06ba A[Catch: all -> 0x099e, TryCatch #2 {all -> 0x099e, blocks: (B:55:0x0699, B:57:0x06ba, B:58:0x0704, B:15:0x0212, B:17:0x0226, B:18:0x0252), top: B:99:0x0212 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x0716  */
    /* JADX WARN: Code duplicated, block: B:66:0x07bc  */
    @Override // com.google.firebase.messaging.FirebaseMessagingService, com.google.firebase.messaging.EnhancedIntentService, android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) throws Throwable {
        Object objAccessartificialFrame;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        Object[] objArr;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        int i = 2 % 2;
        super.attachBaseContext(context);
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame7 == null) {
            int i2 = 25 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
            char c = (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
            int doubleTapTimeout = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 1041;
            byte[] bArr = $$g;
            byte b = bArr[5];
            Object[] objArr2 = new Object[1];
            h(b, b, bArr[8], objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(i2, c, doubleTapTimeout, 2061780482, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 4611686018427387830L;
            Object[] objArr3 = new Object[1];
            i(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4, new char[]{44656, 44561, 38193, 55877, 3430, 37686, 12117, 49769, 37495, 7898, 18894, 1741, 54991, 21160, 33820, 18712, 6961, 37136, 49198, 36278, 24509, 54728, 7310, 61908, 32795, 59512}, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            i(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35, new char[]{18862, 18891, 11287, 25441, 53860, 19505, 11455, 49537, 30133, 42992, 38601, 1371, 12571, 60316, 23385, 19157, 64767, 10280, 7992}, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame8 == null) {
                    int iGreen = 26 - Color.green(0);
                    char jumpTapTimeout = (char) (ViewConfiguration.getJumpTapTimeout() >> 16);
                    int i3 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 1041;
                    byte b2 = $$g[5];
                    byte b3 = b2;
                    Object[] objArr5 = new Object[1];
                    h(b2, b3, b3, objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iGreen, jumpTapTimeout, i3, 1145017376, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i4 = ((int[]) objArr6[3])[0];
                int i5 = ((int[]) objArr6[2])[0];
                String[] strArr = (String[]) objArr6[0];
                int elapsedCpuTime = (int) Process.getElapsedCpuTime();
                int i6 = ((((~((~elapsedCpuTime) | 226219905)) * 130) - 1008937982) + (((~(elapsedCpuTime | 226219905)) | 135467136) * 130)) - 385823706;
                int i7 = (i6 << 13) ^ i6;
                int i8 = i7 ^ (i7 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i8 ^ (i8 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                i(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 115, new char[]{28471, 28509, 18390, 2221, 2588, 37982, 12367, 56672, 21361, 52280, 20131, 6551, 6016, 32786, 33545, 22056, 55932, 17392, 51031, 37540}, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                i(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35, new char[]{36385, 36424, 35490, 50652, 12710, 45047, 18690, 42018, 45629, 329, 29983, 24781, 63161, 19753, 47232, 12148, 15194, 36511, 64767, 60385}, objArr8);
                int iIntValue = ((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue();
                try {
                    Object[] objArr9 = {-108469344};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(View.getDefaultSize(0, 0) + 8, (char) (22251 - KeyEvent.getDeadChar(0, 0)), 1033 - TextUtils.getOffsetBefore("", 0), 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = HashMapClassDesc.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr9), -385823706, false);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame2 == null) {
                        int iMyTid = (Process.myTid() >> 22) + 26;
                        char c2 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1);
                        int i9 = 1042 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                        byte b4 = $$g[5];
                        byte b5 = b4;
                        Object[] objArr10 = new Object[1];
                        h(b4, b5, b5, objArr10);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iMyTid, c2, i9, 1145017376, false, (String) objArr10[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
                    try {
                        Object[] objArr11 = new Object[1];
                        i(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35, new char[]{44656, 44561, 38193, 55877, 3430, 37686, 12117, 49769, 37495, 7898, 18894, 1741, 54991, 21160, 33820, 18712, 6961, 37136, 49198, 36278, 24509, 54728, 7310, 61908, 32795, 59512}, objArr11);
                        Class<?> cls3 = Class.forName((String) objArr11[0]);
                        Object[] objArr12 = new Object[1];
                        i(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 4, new char[]{18862, 18891, 11287, 25441, 53860, 19505, 11455, 49537, 30133, 42992, 38601, 1371, 12571, 60316, 23385, 19157, 64767, 10280, 7992}, objArr12);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr12[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame3 == null) {
                            int scrollBarSize = 26 - (ViewConfiguration.getScrollBarSize() >> 8);
                            char absoluteGravity = (char) Gravity.getAbsoluteGravity(0, 0);
                            int doubleTapTimeout2 = 1041 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                            byte[] bArr2 = $$g;
                            byte b6 = bArr2[5];
                            Object[] objArr13 = new Object[1];
                            h(b6, b6, bArr2[8], objArr13);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(scrollBarSize, absoluteGravity, doubleTapTimeout2, 2061780482, false, (String) objArr13[0], null);
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
            Object[] objArr14 = new Object[1];
            i(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 115, new char[]{28471, 28509, 18390, 2221, 2588, 37982, 12367, 56672, 21361, 52280, 20131, 6551, 6016, 32786, 33545, 22056, 55932, 17392, 51031, 37540}, objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            i(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35, new char[]{36385, 36424, 35490, 50652, 12710, 45047, 18690, 42018, 45629, 329, 29983, 24781, 63161, 19753, 47232, 12148, 15194, 36511, 64767, 60385}, objArr15);
            int iIntValue2 = ((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr16 = {-108469344};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(View.getDefaultSize(0, 0) + 8, (char) (22251 - KeyEvent.getDeadChar(0, 0)), 1033 - TextUtils.getOffsetBefore("", 0), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = HashMapClassDesc.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr16), -385823706, false);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame2 == null) {
                int iMyTid2 = (Process.myTid() >> 22) + 26;
                char c3 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1);
                int i10 = 1042 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                byte b7 = $$g[5];
                byte b8 = b7;
                Object[] objArr17 = new Object[1];
                h(b7, b8, b8, objArr17);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iMyTid2, c3, i10, 1145017376, false, (String) objArr17[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr18 = new Object[1];
            i(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35, new char[]{44656, 44561, 38193, 55877, 3430, 37686, 12117, 49769, 37495, 7898, 18894, 1741, 54991, 21160, 33820, 18712, 6961, 37136, 49198, 36278, 24509, 54728, 7310, 61908, 32795, 59512}, objArr18);
            Class<?> cls5 = Class.forName((String) objArr18[0]);
            Object[] objArr19 = new Object[1];
            i(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 4, new char[]{18862, 18891, 11287, 25441, 53860, 19505, 11455, 49537, 30133, 42992, 38601, 1371, 12571, 60316, 23385, 19157, 64767, 10280, 7992}, objArr19);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr19[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame3 == null) {
                int scrollBarSize2 = 26 - (ViewConfiguration.getScrollBarSize() >> 8);
                char absoluteGravity2 = (char) Gravity.getAbsoluteGravity(0, 0);
                int doubleTapTimeout3 = 1041 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                byte[] bArr3 = $$g;
                byte b9 = bArr3[5];
                Object[] objArr110 = new Object[1];
                h(b9, b9, bArr3[8], objArr110);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(scrollBarSize2, absoluteGravity2, doubleTapTimeout3, 2061780482, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i11 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i12 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i12 == i11) {
            Object[] objArr20 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i13 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i14 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i15 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iIdentityHashCode = System.identityHashCode(this);
            int i16 = i13 + (((1473583838 + (((~((-446948349) | iIdentityHashCode)) | 168026368) * 1504)) + ((~(iIdentityHashCode | (-278921981))) * (-1504))) - 704067040);
            int i17 = (i16 << 13) ^ i16;
            int i18 = i17 ^ (i17 >>> 17);
            ((int[]) objArr20[1])[0] = i18 ^ (i18 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr3 != null) {
                int i19 = 0;
                while (i19 < strArr3.length) {
                    int i20 = artificialFrame + 95;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i20 % 128;
                    if (i20 % 2 != 0) {
                        arrayList.add(strArr3[i19]);
                        i19 += com.salesforce.marketingcloud.analytics.stats.b.f40o;
                    } else {
                        arrayList.add(strArr3[i19]);
                        i19++;
                    }
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf(((long) (i11 ^ i12)) ^ (((long) (-816362285)) << 32)), Long.valueOf(-816362287)};
                byte[] bArr4 = $$j;
                Object[] objArr22 = new Object[1];
                j((byte) (bArr4[129] - 1), (byte) 38, bArr4[5], objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                byte b10 = bArr4[10];
                Object[] objArr23 = new Object[1];
                j(b10, (byte) (b10 | 77), (byte) (-bArr4[92]), objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i21 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i22 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i23 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
                int i24 = i21 + (-527560762) + (((~((-539494402) | startElapsedRealtime)) | (~((~startElapsedRealtime) | (-461390595)))) * (-318)) + (((~(539733105 | startElapsedRealtime)) | (-1001123700)) * (-318)) + (((~(startElapsedRealtime | (-539733106))) | 461629298) * TypedValues.AttributesType.TYPE_PIVOT_TARGET);
                int i25 = (i24 << 13) ^ i24;
                int i26 = i25 ^ (i25 >>> 17);
                ((int[]) objArr24[1])[0] = i26 ^ (i26 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame9 == null) {
            int iCombineMeasuredStates = View.combineMeasuredStates(0, 0) + 25;
            char cIndexOf = (char) (30067 - TextUtils.indexOf((CharSequence) "", '0'));
            int iIndexOf = TextUtils.indexOf((CharSequence) "", '0', 0) + 817;
            byte[] bArr5 = $$g;
            byte b11 = bArr5[5];
            Object[] objArr25 = new Object[1];
            h(b11, b11, bArr5[8], objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates, cIndexOf, iIndexOf, 721586079, false, (String) objArr25[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j3 != -1) {
            int i27 = getARTIFICIAL_FRAME_PACKAGE_NAME + 65;
            artificialFrame = i27 % 128;
            int i28 = i27 % 2;
            long j4 = j3 + 2005;
            Object[] objArr26 = new Object[1];
            i((-1) - TextUtils.indexOf((CharSequence) "", '0'), new char[]{44656, 44561, 38193, 55877, 3430, 37686, 12117, 49769, 37495, 7898, 18894, 1741, 54991, 21160, 33820, 18712, 6961, 37136, 49198, 36278, 24509, 54728, 7310, 61908, 32795, 59512}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            i(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 21, new char[]{18862, 18891, 11287, 25441, 53860, 19505, 11455, 49537, 30133, 42992, 38601, 1371, 12571, 60316, 23385, 19157, 64767, 10280, 7992}, objArr27);
            if (j4 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame10 == null) {
                    int trimmedLength = TextUtils.getTrimmedLength("") + 25;
                    char scrollBarFadeDuration = (char) (30068 - (ViewConfiguration.getScrollBarFadeDuration() >> 16));
                    int iKeyCodeFromString = 816 - KeyEvent.keyCodeFromString("");
                    byte b12 = $$g[5];
                    byte b13 = b12;
                    Object[] objArr28 = new Object[1];
                    h(b12, b13, b13, objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(trimmedLength, scrollBarFadeDuration, iKeyCodeFromString, 891606461, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i29 = ((int[]) objArr29[0])[0];
                int i30 = ((int[]) objArr29[1])[0];
                String[] strArr5 = (String[]) objArr29[2];
                int iIdentityHashCode2 = System.identityHashCode(this);
                int i31 = (((1775964187 + (((~((-464393840) | iIdentityHashCode2)) | 53220397) * (-140))) + ((~((-411173443) | iIdentityHashCode2)) * 70)) + (((~(iIdentityHashCode2 | 662566205)) | (-1020519251)) * 70)) - 2103673688;
                int i32 = (i31 << 13) ^ i31;
                int i33 = i32 ^ (i32 >>> 17);
                ((int[]) objArr[3])[0] = i33 ^ (i33 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                i((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), new char[]{28471, 28509, 18390, 2221, 2588, 37982, 12367, 56672, 21361, 52280, 20131, 6551, 6016, 32786, 33545, 22056, 55932, 17392, 51031, 37540}, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                i((Process.getThreadPriority(0) + 20) >> 6, new char[]{36385, 36424, 35490, 50652, 12710, 45047, 18690, 42018, 45629, 329, 29983, 24781, 63161, 19753, 47232, 12148, 15194, 36511, 64767, 60385}, objArr31);
                Object[] objArr32 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue()), 0, -2103673688};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame4 == null) {
                    int iIndexOf2 = 24 - TextUtils.indexOf((CharSequence) "", '0', 0);
                    char bitsPerPixel = (char) (ImageFormat.getBitsPerPixel(0) + 30069);
                    int i34 = 816 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                    byte b14 = (byte) ($$g[5] - 1);
                    byte b15 = b14;
                    Object[] objArr33 = new Object[1];
                    h(b14, b15, b15, objArr33);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iIndexOf2, bitsPerPixel, i34, -797394565, false, (String) objArr33[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr32);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame5 == null) {
                    int i35 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 24;
                    char scrollDefaultDelay = (char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 30068);
                    int i36 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 815;
                    byte b16 = $$g[5];
                    byte b17 = b16;
                    Object[] objArr34 = new Object[1];
                    h(b16, b17, b17, objArr34);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i35, scrollDefaultDelay, i36, 891606461, false, (String) objArr34[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr);
                try {
                    Object[] objArr35 = new Object[1];
                    i(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35, new char[]{44656, 44561, 38193, 55877, 3430, 37686, 12117, 49769, 37495, 7898, 18894, 1741, 54991, 21160, 33820, 18712, 6961, 37136, 49198, 36278, 24509, 54728, 7310, 61908, 32795, 59512}, objArr35);
                    Class<?> cls9 = Class.forName((String) objArr35[0]);
                    Object[] objArr36 = new Object[1];
                    i(View.combineMeasuredStates(0, 0), new char[]{18862, 18891, 11287, 25441, 53860, 19505, 11455, 49537, 30133, 42992, 38601, 1371, 12571, 60316, 23385, 19157, 64767, 10280, 7992}, objArr36);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr36[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame6 == null) {
                        int iBlue = 25 - Color.blue(0);
                        char maximumFlingVelocity = (char) (30068 - (ViewConfiguration.getMaximumFlingVelocity() >> 16));
                        int keyRepeatDelay = 816 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                        byte[] bArr6 = $$g;
                        byte b18 = bArr6[5];
                        Object[] objArr37 = new Object[1];
                        h(b18, b18, bArr6[8], objArr37);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iBlue, maximumFlingVelocity, keyRepeatDelay, 721586079, false, (String) objArr37[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr38 = new Object[1];
            i((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), new char[]{28471, 28509, 18390, 2221, 2588, 37982, 12367, 56672, 21361, 52280, 20131, 6551, 6016, 32786, 33545, 22056, 55932, 17392, 51031, 37540}, objArr38);
            Class<?> cls10 = Class.forName((String) objArr38[0]);
            Object[] objArr39 = new Object[1];
            i((Process.getThreadPriority(0) + 20) >> 6, new char[]{36385, 36424, 35490, 50652, 12710, 45047, 18690, 42018, 45629, 329, 29983, 24781, 63161, 19753, 47232, 12148, 15194, 36511, 64767, 60385}, objArr39);
            Object[] objArr310 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr39[0], Object.class).invoke(null, this)).intValue()), 0, -2103673688};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame4 == null) {
                int iIndexOf3 = 24 - TextUtils.indexOf((CharSequence) "", '0', 0);
                char bitsPerPixel2 = (char) (ImageFormat.getBitsPerPixel(0) + 30069);
                int i37 = 816 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                byte b19 = (byte) ($$g[5] - 1);
                byte b110 = b19;
                Object[] objArr311 = new Object[1];
                h(b19, b110, b110, objArr311);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iIndexOf3, bitsPerPixel2, i37, -797394565, false, (String) objArr311[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr310);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame5 == null) {
                int i38 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 24;
                char scrollDefaultDelay2 = (char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 30068);
                int i39 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 815;
                byte b111 = $$g[5];
                byte b112 = b111;
                Object[] objArr312 = new Object[1];
                h(b111, b112, b112, objArr312);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i38, scrollDefaultDelay2, i39, 891606461, false, (String) objArr312[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr);
            Object[] objArr313 = new Object[1];
            i(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35, new char[]{44656, 44561, 38193, 55877, 3430, 37686, 12117, 49769, 37495, 7898, 18894, 1741, 54991, 21160, 33820, 18712, 6961, 37136, 49198, 36278, 24509, 54728, 7310, 61908, 32795, 59512}, objArr313);
            Class<?> cls11 = Class.forName((String) objArr313[0]);
            Object[] objArr314 = new Object[1];
            i(View.combineMeasuredStates(0, 0), new char[]{18862, 18891, 11287, 25441, 53860, 19505, 11455, 49537, 30133, 42992, 38601, 1371, 12571, 60316, 23385, 19157, 64767, 10280, 7992}, objArr314);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr314[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame6 == null) {
                int iBlue2 = 25 - Color.blue(0);
                char maximumFlingVelocity2 = (char) (30068 - (ViewConfiguration.getMaximumFlingVelocity() >> 16));
                int keyRepeatDelay2 = 816 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                byte[] bArr7 = $$g;
                byte b113 = bArr7[5];
                Object[] objArr315 = new Object[1];
                h(b113, b113, bArr7[8], objArr315);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iBlue2, maximumFlingVelocity2, keyRepeatDelay2, 721586079, false, (String) objArr315[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i40 = ((int[]) objArr[1])[0];
        int i41 = ((int[]) objArr[0])[0];
        if (i41 == i40) {
            Object[] objArr40 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i42 = ((int[]) objArr[3])[0];
            int i43 = ((int[]) objArr[0])[0];
            int i44 = ((int[]) objArr[1])[0];
            String[] strArr6 = (String[]) objArr[2];
            int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 1596988074;
            int i45 = i42 + 606641709 + (((~((~iCodePointAt) | (-376330107))) | (-178157741)) * (-235)) + (((~((-376330107) | iCodePointAt)) | (-178157741)) * (-470)) + (((~(iCodePointAt | (-34492457))) | (-519995391)) * 235);
            int i46 = (i45 << 13) ^ i45;
            int i47 = i46 ^ (i46 >>> 17);
            ((int[]) objArr40[3])[0] = i47 ^ (i47 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArr[2];
        if (strArr7 != null) {
            for (String str : strArr7) {
                int i48 = artificialFrame + 35;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i48 % 128;
                int i49 = i48 % 2;
                arrayList2.add(str);
            }
        }
        Object[] objArr41 = {Long.valueOf(((long) (i40 ^ i41)) ^ (((long) (-1397393274)) << 32)), Long.valueOf(-1397393273)};
        byte[] bArr8 = $$j;
        byte b20 = bArr8[5];
        Object[] objArr42 = new Object[1];
        j(b20, b20, bArr8[57], objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        byte b21 = bArr8[10];
        Object[] objArr43 = new Object[1];
        j(b21, (byte) (b21 | 77), (byte) (-bArr8[92]), objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
        int i50 = ((int[]) objArr[3])[0];
        int i51 = ((int[]) objArr[0])[0];
        int i52 = ((int[]) objArr[1])[0];
        String[] strArr8 = (String[]) objArr[2];
        int iIdentityHashCode3 = System.identityHashCode(this);
        int i53 = (~((-242807503) | iIdentityHashCode3)) | 206627534;
        int i54 = i50 + 688927133 + (i53 * 992) + ((i53 | (~((~iIdentityHashCode3) | (-8455169)))) * (-496)) + ((iIdentityHashCode3 | (-44635137)) * 496);
        int i55 = (i54 << 13) ^ i54;
        int i56 = i55 ^ (i55 >>> 17);
        ((int[]) objArr44[3])[0] = i56 ^ (i56 << 5);
    }

    static void accessartificialFrame() {
        onPostMessage = 2187283106205867098L;
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService, com.google.firebase.messaging.EnhancedIntentService, android.app.Service
    public void onCreate() throws Throwable {
        int i = 2 % 2;
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 117;
        artificialFrame = i2 % 128;
        int i3 = i2 % 2;
        super.onCreate();
        if (i3 == 0) {
            throw null;
        }
    }
}
