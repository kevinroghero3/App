package com.hitachiapp.services;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.net.SyslogConstants;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.common.base.Ascii;
import com.google.firebase.messaging.RemoteMessage;
import com.hitachiapp.services.push.core.ExternalPushProvider;
import com.hitachiapp.services.push.mapp.MappProviderManagerFactory;
import com.hitachiapp.services.push.salesforce.SfmcPushProviderFactory;
import com.salesforce.marketingcloud.analytics.stats.b;
import io.invertase.firebase.messaging.ReactNativeFirebaseMessagingService;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.pluservice.unicoc.R;
import o.ArtificialStackFrames;
import o.onNavigationEvent;
import okio.Utf8;
import org.apache.commons.lang3.CharUtils;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;

/* JADX INFO: loaded from: classes6.dex */
public final class CustomFirebaseMessagingService extends ReactNativeFirebaseMessagingService {
    public static final Companion Companion;
    private static final String TAG = "CustomFCMService";
    private static int setDefaultImpl;
    private final Lazy providers$delegate = LazyKt__LazyJVMKt.lazy(new CustomFirebaseMessagingService$$ExternalSyntheticLambda0(this));
    private static final byte[] $$u = {81, -123, 100, Ascii.RS};
    private static final int $$x = 15;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$s = {96, -63, 33, 4, -2, -3, -18, -6, -2, 55, -1, -65, -11, -12, 9, -19, -2, 7, -17, 56, -79, -2, Utf8.REPLACEMENT_BYTE, -42, -25, -2, -17, Ascii.SI, -20, -3, 9, -34, 6, -14, 0, -21, 74, -57, -33, 3, -17, 9, -19, Ascii.CAN, -19, -24, 2, -6, -67, -18, -4, 57, -62, -1, -8, -8, -3, -19, -6, -2, 55, -65, -10, 6, -12, -4, -17, 1, -13, 5, -13, -3, -11, 3, 49, -59, -18, -9, 7, 49, -40, -40, -3, 5, -23, Ascii.FF, -8, -19, Ascii.EM, -24, -18, -10, 10, -15, 5, -8, Ascii.EM, -33, -8, -23, -1, -9, -13, 79, -37, -50, -4, -9, 9, -19, -1, -12, -5};
    private static final int $$t = 233;
    private static final byte[] $$g = {53, -94, -28, -114, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13};
    private static final int $$h = 18;
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
    private static java.lang.String $$y(byte r6, int r7, short r8) {
        /*
            byte[] r0 = com.hitachiapp.services.CustomFirebaseMessagingService.$$u
            int r6 = r6 + 4
            int r8 = r8 * 2
            int r1 = r8 + 1
            int r7 = r7 * 2
            int r7 = r7 + 114
            byte[] r1 = new byte[r1]
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
            int r7 = r7 + 1
            if (r3 != r8) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L25:
            r4 = r0[r7]
            int r3 = r3 + 1
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
        throw new UnsupportedOperationException("Method not decompiled: com.hitachiapp.services.CustomFirebaseMessagingService.$$y(byte, int, short):java.lang.String");
    }

    static {
        accessartificialFrame();
        Companion = new Companion(null);
    }

    private static void a(byte b, int i, short s, Object[] objArr) {
        byte[] bArr = $$g;
        int i2 = 112 - (b * 28);
        int i3 = (i * 8) + 4;
        int i4 = s * 3;
        byte[] bArr2 = new byte[i4 + 9];
        int i5 = i4 + 8;
        int i6 = -1;
        if (bArr == null) {
            i2 += -i3;
            i3++;
            i6 = -1;
        }
        while (true) {
            int i7 = i6 + 1;
            bArr2[i7] = (byte) i2;
            if (i7 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i8 = i3;
            i2 += -bArr[i3];
            i3 = i8 + 1;
            i6 = i7;
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void i(short r7, int r8, int r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 3
            int r7 = r7 + 36
            int r8 = 65 - r8
            byte[] r0 = com.hitachiapp.services.CustomFirebaseMessagingService.$$s
            int r9 = 48 - r9
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L13
            r7 = r8
            r3 = r9
            r4 = r2
            goto L2a
        L13:
            r3 = r2
        L14:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r8) goto L23
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L23:
            int r9 = r9 + 1
            r3 = r0[r9]
            r6 = r3
            r3 = r9
            r9 = r6
        L2a:
            int r9 = -r9
            int r7 = r7 + r9
            int r7 = r7 + (-6)
            r9 = r3
            r3 = r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hitachiapp.services.CustomFirebaseMessagingService.i(short, int, int, java.lang.Object[]):void");
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final List<ExternalPushProvider> getProviders() {
        return (List) this.providers$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List providers_delegate$lambda$0(CustomFirebaseMessagingService customFirebaseMessagingService) {
        SfmcPushProviderFactory sfmcPushProviderFactory = SfmcPushProviderFactory.INSTANCE;
        Context applicationContext = customFirebaseMessagingService.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        ExternalPushProvider externalPushProviderCreate = sfmcPushProviderFactory.create(applicationContext);
        MappProviderManagerFactory mappProviderManagerFactory = MappProviderManagerFactory.INSTANCE;
        Context applicationContext2 = customFirebaseMessagingService.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
        return CollectionsKt__CollectionsKt.listOf((Object[]) new ExternalPushProvider[]{externalPushProviderCreate, mappProviderManagerFactory.create(applicationContext2)});
    }

    @Override // io.invertase.firebase.messaging.ReactNativeFirebaseMessagingService, com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(@NotNull RemoteMessage remoteMessage) {
        Object next;
        Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
        Timber.tag(TAG).d("=== FCM MESSAGE RECEIVED ===", new Object[0]);
        Timber.tag(TAG).d("From: " + remoteMessage.getFrom(), new Object[0]);
        Timber.tag(TAG).d("Message ID: " + remoteMessage.getMessageId(), new Object[0]);
        Timber.tag(TAG).d("Sent Time: " + remoteMessage.getSentTime(), new Object[0]);
        Timber.tag(TAG).d("Data: " + remoteMessage.getData(), new Object[0]);
        Iterator<T> it2 = getProviders().iterator();
        do {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
        } while (!((ExternalPushProvider) next).canHandle(remoteMessage));
        ExternalPushProvider externalPushProvider = (ExternalPushProvider) next;
        if (externalPushProvider == null || !externalPushProvider.handleMessage(remoteMessage)) {
            super.onMessageReceived(remoteMessage);
        }
    }

    @Override // io.invertase.firebase.messaging.ReactNativeFirebaseMessagingService, com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(@NotNull String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        Timber.tag(TAG).d("New FCM token: " + token, new Object[0]);
        Iterator<T> it2 = getProviders().iterator();
        while (it2.hasNext()) {
            ((ExternalPushProvider) it2.next()).onNewToken(token);
        }
        super.onNewToken(token);
    }

    private static void h(char[] cArr, int i, int i2, int i3, boolean z, Object[] objArr) throws Throwable {
        int i4 = 2 % 2;
        onNavigationEvent onnavigationevent = new onNavigationEvent();
        char[] cArr2 = new char[i];
        onnavigationevent.d = 0;
        int i5 = $11 + 117;
        $10 = i5 % 128;
        int i6 = i5 % 2;
        while (onnavigationevent.d < i) {
            onnavigationevent.c = cArr[onnavigationevent.d];
            cArr2[onnavigationevent.d] = (char) (i3 + onnavigationevent.c);
            int i7 = onnavigationevent.d;
            try {
                Object[] objArr2 = {Integer.valueOf(cArr2[i7]), Integer.valueOf(setDefaultImpl)};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(465886069);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) (-1);
                    byte b2 = (byte) (b + 1);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(22 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 1775, -2069783171, false, $$y(b, b2, b2), new Class[]{Integer.TYPE, Integer.TYPE});
                }
                cArr2[i7] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                Object[] objArr3 = {onnavigationevent, onnavigationevent};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                if (objAccessartificialFrame2 == null) {
                    byte b3 = (byte) (-1);
                    byte b4 = (byte) (-b3);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(37 - Color.green(0), (char) (56277 - View.MeasureSpec.getSize(0)), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 1259, 711931141, false, $$y(b3, b4, (byte) (b4 - 1)), new Class[]{Object.class, Object.class});
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
        if (i2 > 0) {
            onnavigationevent.b = i2;
            char[] cArr3 = new char[i];
            System.arraycopy(cArr2, 0, cArr3, 0, i);
            System.arraycopy(cArr3, 0, cArr2, i - onnavigationevent.b, onnavigationevent.b);
            System.arraycopy(cArr3, onnavigationevent.b, cArr2, 0, i - onnavigationevent.b);
        }
        if (z) {
            char[] cArr4 = new char[i];
            onnavigationevent.d = 0;
            while (onnavigationevent.d < i) {
                int i8 = $10 + 11;
                $11 = i8 % 128;
                int i9 = i8 % 2;
                cArr4[onnavigationevent.d] = cArr2[(i - onnavigationevent.d) - 1];
                Object[] objArr4 = {onnavigationevent, onnavigationevent};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) (-1);
                    byte b6 = (byte) (-b5);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", "") + 37, (char) ((ViewConfiguration.getTouchSlop() >> 8) + 56277), TextUtils.indexOf("", "", 0) + 1259, 711931141, false, $$y(b5, b6, (byte) (b6 - 1)), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
            }
            cArr2 = cArr4;
        }
        String str = new String(cArr2);
        int i10 = $10 + 67;
        $11 = i10 % 128;
        int i11 = i10 % 2;
        objArr[0] = str;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:17:0x0305 A[Catch: all -> 0x0ca0, TryCatch #0 {all -> 0x0ca0, blocks: (B:52:0x08fd, B:54:0x091e, B:55:0x096e, B:15:0x02f1, B:17:0x0305, B:18:0x0335), top: B:92:0x02f1 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x034b  */
    /* JADX WARN: Code duplicated, block: B:26:0x0470  */
    /* JADX WARN: Code duplicated, block: B:51:0x0822  */
    /* JADX WARN: Code duplicated, block: B:54:0x091e A[Catch: all -> 0x0ca0, TryCatch #0 {all -> 0x0ca0, blocks: (B:52:0x08fd, B:54:0x091e, B:55:0x096e, B:15:0x02f1, B:17:0x0305, B:18:0x0335), top: B:92:0x02f1 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0980  */
    /* JADX WARN: Code duplicated, block: B:63:0x0add  */
    @Override // io.invertase.firebase.messaging.ReactNativeFirebaseMessagingService, com.google.firebase.messaging.FirebaseMessagingService, com.google.firebase.messaging.EnhancedIntentService, android.app.Service, android.content.ContextWrapper
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
            int offsetBefore = TextUtils.getOffsetBefore("", 0) + 26;
            char cBlue = (char) Color.blue(0);
            int iResolveSizeAndState = View.resolveSizeAndState(0, 0, 0) + 1041;
            byte b = (byte) ($$g[5] - 1);
            byte b2 = b;
            Object[] objArr2 = new Object[1];
            a(b, b2, b2, objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(offsetBefore, cBlue, iResolveSizeAndState, 2061780482, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 4611686018427387882L;
            Object[] objArr3 = new Object[1];
            h(new char[]{0, '\b', 65534, 11, 1, 15, '\f', 6, 1, 65483, '\f', 16, 65483, 65520, 22, 16, 17, 2, '\n', 65504, '\t', '\f'}, 23 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 33, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + SyslogConstants.LOG_CLOCK, false, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            h(new char[]{2, 6, 65534, 65534, 5, 65530, '\t', '\f', 65534, 65533, 65515, 65534, 65530, 5, CharUtils.CR}, 15 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (Process.myTid() >> 22) + 3, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 107, false, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i2 = artificialFrame + 27;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
                int i3 = i2 % 2;
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame8 == null) {
                    int iGreen = Color.green(0) + 26;
                    char maximumFlingVelocity = (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                    int i4 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 1040;
                    byte b3 = $$g[5];
                    byte b4 = (byte) (b3 - 1);
                    byte b5 = b3;
                    Object[] objArr5 = new Object[1];
                    a(b4, b5, (byte) (b5 - 1), objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iGreen, maximumFlingVelocity, i4, 1145017376, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i5 = ((int[]) objArr6[3])[0];
                int i6 = ((int[]) objArr6[2])[0];
                String[] strArr = (String[]) objArr6[0];
                int iIdentityHashCode = System.identityHashCode(this);
                int i7 = ~((-282117377) | iIdentityHashCode);
                int i8 = ~iIdentityHashCode;
                int i9 = (((1237046318 + ((i7 | (~(536601869 | i8))) * 920)) + ((282117376 | (~((-332588301) | i8))) * 920)) + (((~(iIdentityHashCode | 536601869)) | ((~((-282117377) | i8)) | (~((-50470925) | iIdentityHashCode)))) * 920)) - 521370108;
                int i10 = (i9 << 13) ^ i9;
                int i11 = i10 ^ (i10 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i11 ^ (i11 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                h(new char[]{65535, 20, 65535, 65484, '\n', 65535, '\f', 5, 65484, 65521, 23, 17, 18, 3, 11, '\b'}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 11, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) + 87, false, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                h(new char[]{65535, 65534, '\t', 65501, 2, CharUtils.CR, 65531, 65506, 19, 14, 3, 14, '\b', 65535, 65534, 3}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(13) - 85, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 33, 127 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), true, objArr8);
                int iIntValue = ((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue();
                try {
                    Object[] objArr9 = {1997532888};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 8, (char) (View.resolveSizeAndState(0, 0, 0) + 22251), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = DynamiteModule.LoadingException.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr9), -521370108, false);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame2 == null) {
                        int keyRepeatDelay = 26 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                        char keyRepeatTimeout = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                        int scrollBarSize = (ViewConfiguration.getScrollBarSize() >> 8) + 1041;
                        byte b6 = $$g[5];
                        byte b7 = (byte) (b6 - 1);
                        byte b8 = b6;
                        Object[] objArr10 = new Object[1];
                        a(b7, b8, (byte) (b8 - 1), objArr10);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay, keyRepeatTimeout, scrollBarSize, 1145017376, false, (String) objArr10[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
                    try {
                        Object[] objArr11 = new Object[1];
                        h(new char[]{0, '\b', 65534, 11, 1, 15, '\f', 6, 1, 65483, '\f', 16, 65483, 65520, 22, 16, 17, 2, '\n', 65504, '\t', '\f'}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 13, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 34, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) + 88, false, objArr11);
                        Class<?> cls3 = Class.forName((String) objArr11[0]);
                        Object[] objArr12 = new Object[1];
                        h(new char[]{2, 6, 65534, 65534, 5, 65530, '\t', '\f', 65534, 65533, 65515, 65534, 65530, 5, CharUtils.CR}, 15 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 3 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), 129 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), false, objArr12);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr12[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame3 == null) {
                            int iIndexOf = TextUtils.indexOf("", "", 0, 0) + 26;
                            char cCombineMeasuredStates = (char) View.combineMeasuredStates(0, 0);
                            int iIndexOf2 = 1040 - TextUtils.indexOf((CharSequence) "", '0');
                            byte b9 = (byte) ($$g[5] - 1);
                            byte b10 = b9;
                            Object[] objArr13 = new Object[1];
                            a(b9, b10, b10, objArr13);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iIndexOf, cCombineMeasuredStates, iIndexOf2, 2061780482, false, (String) objArr13[0], null);
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
            h(new char[]{65535, 20, 65535, 65484, '\n', 65535, '\f', 5, 65484, 65521, 23, 17, 18, 3, 11, '\b'}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 11, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) + 87, false, objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            h(new char[]{65535, 65534, '\t', 65501, 2, CharUtils.CR, 65531, 65506, 19, 14, 3, 14, '\b', 65535, 65534, 3}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(13) - 85, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 33, 127 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), true, objArr15);
            int iIntValue2 = ((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr16 = {1997532888};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 8, (char) (View.resolveSizeAndState(0, 0, 0) + 22251), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = DynamiteModule.LoadingException.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr16), -521370108, false);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame2 == null) {
                int keyRepeatDelay2 = 26 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                char keyRepeatTimeout2 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                int scrollBarSize2 = (ViewConfiguration.getScrollBarSize() >> 8) + 1041;
                byte b11 = $$g[5];
                byte b12 = (byte) (b11 - 1);
                byte b13 = b11;
                Object[] objArr17 = new Object[1];
                a(b12, b13, (byte) (b13 - 1), objArr17);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay2, keyRepeatTimeout2, scrollBarSize2, 1145017376, false, (String) objArr17[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr18 = new Object[1];
            h(new char[]{0, '\b', 65534, 11, 1, 15, '\f', 6, 1, 65483, '\f', 16, 65483, 65520, 22, 16, 17, 2, '\n', 65504, '\t', '\f'}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 13, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 34, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) + 88, false, objArr18);
            Class<?> cls5 = Class.forName((String) objArr18[0]);
            Object[] objArr19 = new Object[1];
            h(new char[]{2, 6, 65534, 65534, 5, 65530, '\t', '\f', 65534, 65533, 65515, 65534, 65530, 5, CharUtils.CR}, 15 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 3 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), 129 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), false, objArr19);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr19[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame3 == null) {
                int iIndexOf3 = TextUtils.indexOf("", "", 0, 0) + 26;
                char cCombineMeasuredStates2 = (char) View.combineMeasuredStates(0, 0);
                int iIndexOf4 = 1040 - TextUtils.indexOf((CharSequence) "", '0');
                byte b14 = (byte) ($$g[5] - 1);
                byte b15 = b14;
                Object[] objArr110 = new Object[1];
                a(b14, b15, b15, objArr110);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iIndexOf3, cCombineMeasuredStates2, iIndexOf4, 2061780482, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i12 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i13 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i13 == i12) {
            Object[] objArr20 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i14 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i15 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i16 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int i17 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenHeightDp;
            int i18 = ~i17;
            int i19 = i14 + 1491392654 + (((~((-520659360) | i18)) | 84418847 | (~(442555552 | i18))) * (-1136)) + (((~((-520659360) | i17)) | (~(442555552 | i17)) | (~((-6315041) | i18))) * (-568)) + (((~(i17 | (-84418848))) | (~(i18 | (-442555553))) | (~(520659359 | i18))) * 568);
            int i20 = (i19 << 13) ^ i19;
            int i21 = i20 ^ (i20 >>> 17);
            ((int[]) objArr20[1])[0] = i21 ^ (i21 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr3 != null) {
                int i22 = getARTIFICIAL_FRAME_PACKAGE_NAME + 9;
                artificialFrame = i22 % 128;
                int i23 = 2;
                int i24 = i22 % 2;
                int i25 = 0;
                while (i25 < strArr3.length) {
                    int i26 = getARTIFICIAL_FRAME_PACKAGE_NAME + 27;
                    artificialFrame = i26 % 128;
                    int i27 = i26 % i23;
                    arrayList.add(strArr3[i25]);
                    i25++;
                    i23 = 2;
                }
            }
            long j3 = ((long) (i12 ^ i13)) ^ (((long) (-1699612728)) << 32);
            long j4 = -1699612726;
            int i28 = artificialFrame + 67;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i28 % 128;
            int i29 = i28 % 2;
            try {
                Object[] objArr21 = {Long.valueOf(j3), Long.valueOf(j4)};
                byte[] bArr = $$s;
                Object[] objArr22 = new Object[1];
                i(bArr[88], (byte) (-bArr[35]), (byte) 45, objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                i(bArr[34], (byte) (-bArr[52]), bArr[46], objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i30 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i31 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i32 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int iIdentityHashCode2 = System.identityHashCode(this);
                int i33 = ~iIdentityHashCode2;
                int i34 = i30 + (-702192220) + (((~(643402316 | i33)) | 721506123) * (-90)) + (((~(643402316 | iIdentityHashCode2)) | 72908804) * (-45)) + (((~(iIdentityHashCode2 | (-721506124))) | 643402316 | (~(i33 | 721506123))) * 45);
                int i35 = (i34 << 13) ^ i34;
                int i36 = i35 ^ (i35 >>> 17);
                ((int[]) objArr24[1])[0] = i36 ^ (i36 << 5);
                int i37 = artificialFrame + 105;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i37 % 128;
                int i38 = i37 % 2;
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
            int longPressTimeout = 25 - (ViewConfiguration.getLongPressTimeout() >> 16);
            char cResolveSize = (char) (30068 - View.resolveSize(0, 0));
            int iKeyCodeFromString = KeyEvent.keyCodeFromString("") + 816;
            byte b16 = (byte) ($$g[5] - 1);
            byte b17 = b16;
            Object[] objArr25 = new Object[1];
            a(b16, b17, b17, objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(longPressTimeout, cResolveSize, iKeyCodeFromString, 721586079, false, (String) objArr25[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j5 != -1) {
            int i39 = artificialFrame + 123;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i39 % 128;
            int i40 = i39 % 2;
            long j6 = j5 + 1992;
            Object[] objArr26 = new Object[1];
            h(new char[]{0, '\b', 65534, 11, 1, 15, '\f', 6, 1, 65483, '\f', 16, 65483, 65520, 22, 16, 17, 2, '\n', 65504, '\t', '\f'}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 13, 1 - TextUtils.indexOf((CharSequence) "", '0'), 124 - (ViewConfiguration.getTapTimeout() >> 16), false, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            h(new char[]{2, 6, 65534, 65534, 5, 65530, '\t', '\f', 65534, 65533, 65515, 65534, 65530, 5, CharUtils.CR}, ImageFormat.getBitsPerPixel(0) + 16, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 2, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 93, false, objArr27);
            if (j6 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame10 == null) {
                    int deadChar = 25 - KeyEvent.getDeadChar(0, 0);
                    char tapTimeout = (char) ((ViewConfiguration.getTapTimeout() >> 16) + 30068);
                    int i41 = 817 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                    byte b18 = $$g[5];
                    byte b19 = (byte) (b18 - 1);
                    byte b20 = b18;
                    Object[] objArr28 = new Object[1];
                    a(b19, b20, (byte) (b20 - 1), objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(deadChar, tapTimeout, i41, 891606461, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i42 = ((int[]) objArr29[0])[0];
                int i43 = ((int[]) objArr29[1])[0];
                String[] strArr5 = (String[]) objArr29[2];
                int iIdentityHashCode3 = System.identityHashCode(this);
                int i44 = ~iIdentityHashCode3;
                int i45 = 1264953413 + (((~(829902396 | i44)) | 201335042) * 168) + ((~((-201335043) | iIdentityHashCode3)) * 168) + (((~(iIdentityHashCode3 | 1031237438)) | (~(i44 | (-1028074763))) | 826739720) * 168) + 1376834808;
                int i46 = (i45 << 13) ^ i45;
                int i47 = i46 ^ (i46 >>> 17);
                ((int[]) objArr[3])[0] = i47 ^ (i47 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                h(new char[]{65535, 20, 65535, 65484, '\n', 65535, '\f', 5, 65484, 65521, 23, 17, 18, 3, 11, '\b'}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 12, 15 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), 124 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), false, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                h(new char[]{65535, 65534, '\t', 65501, 2, CharUtils.CR, 65531, 65506, 19, 14, 3, 14, '\b', 65535, 65534, 3}, 15 - ExpandableListView.getPackedPositionChild(0L), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 20, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + b.l, true, objArr31);
                Object[] objArr32 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue()), 0, 1376834808};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame4 == null) {
                    int iNormalizeMetaState = KeyEvent.normalizeMetaState(0) + 25;
                    char c = (char) (30067 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                    int maximumFlingVelocity2 = 816 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                    byte[] bArr2 = $$g;
                    byte b21 = bArr2[5];
                    Object[] objArr33 = new Object[1];
                    a(b21, bArr2[8], b21, objArr33);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState, c, maximumFlingVelocity2, -797394565, false, (String) objArr33[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr32);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame5 == null) {
                    int packedPositionType = 25 - ExpandableListView.getPackedPositionType(0L);
                    char cIndexOf = (char) (TextUtils.indexOf("", "", 0) + 30068);
                    int iLastIndexOf = 815 - TextUtils.lastIndexOf("", '0', 0, 0);
                    byte b22 = $$g[5];
                    byte b23 = (byte) (b22 - 1);
                    byte b24 = b22;
                    Object[] objArr34 = new Object[1];
                    a(b23, b24, (byte) (b24 - 1), objArr34);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(packedPositionType, cIndexOf, iLastIndexOf, 891606461, false, (String) objArr34[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr);
                try {
                    Object[] objArr35 = new Object[1];
                    h(new char[]{0, '\b', 65534, 11, 1, 15, '\f', 6, 1, 65483, '\f', 16, 65483, 65520, 22, 16, 17, 2, '\n', 65504, '\t', '\f'}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 18, 1 - Process.getGidForName(""), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(0) + 87, false, objArr35);
                    Class<?> cls9 = Class.forName((String) objArr35[0]);
                    Object[] objArr36 = new Object[1];
                    h(new char[]{2, 6, 65534, 65534, 5, 65530, '\t', '\f', 65534, 65533, 65515, 65534, 65530, 5, CharUtils.CR}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 20, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) - 34, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(18) + 29, false, objArr36);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr36[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame6 == null) {
                        int minimumFlingVelocity = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 25;
                        char c2 = (char) (30068 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)));
                        int iRed = Color.red(0) + 816;
                        byte b25 = (byte) ($$g[5] - 1);
                        byte b26 = b25;
                        Object[] objArr37 = new Object[1];
                        a(b25, b26, b26, objArr37);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity, c2, iRed, 721586079, false, (String) objArr37[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                    int i48 = artificialFrame + 63;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i48 % 128;
                    int i49 = i48 % 2;
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr38 = new Object[1];
            h(new char[]{65535, 20, 65535, 65484, '\n', 65535, '\f', 5, 65484, 65521, 23, 17, 18, 3, 11, '\b'}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 12, 15 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), 124 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), false, objArr38);
            Class<?> cls10 = Class.forName((String) objArr38[0]);
            Object[] objArr39 = new Object[1];
            h(new char[]{65535, 65534, '\t', 65501, 2, CharUtils.CR, 65531, 65506, 19, 14, 3, 14, '\b', 65535, 65534, 3}, 15 - ExpandableListView.getPackedPositionChild(0L), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 20, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + b.l, true, objArr39);
            Object[] objArr310 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr39[0], Object.class).invoke(null, this)).intValue()), 0, 1376834808};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame4 == null) {
                int iNormalizeMetaState2 = KeyEvent.normalizeMetaState(0) + 25;
                char c3 = (char) (30067 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                int maximumFlingVelocity3 = 816 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                byte[] bArr3 = $$g;
                byte b27 = bArr3[5];
                Object[] objArr311 = new Object[1];
                a(b27, bArr3[8], b27, objArr311);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState2, c3, maximumFlingVelocity3, -797394565, false, (String) objArr311[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr310);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame5 == null) {
                int packedPositionType2 = 25 - ExpandableListView.getPackedPositionType(0L);
                char cIndexOf2 = (char) (TextUtils.indexOf("", "", 0) + 30068);
                int iLastIndexOf2 = 815 - TextUtils.lastIndexOf("", '0', 0, 0);
                byte b28 = $$g[5];
                byte b29 = (byte) (b28 - 1);
                byte b210 = b28;
                Object[] objArr312 = new Object[1];
                a(b29, b210, (byte) (b210 - 1), objArr312);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(packedPositionType2, cIndexOf2, iLastIndexOf2, 891606461, false, (String) objArr312[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr);
            Object[] objArr313 = new Object[1];
            h(new char[]{0, '\b', 65534, 11, 1, 15, '\f', 6, 1, 65483, '\f', 16, 65483, 65520, 22, 16, 17, 2, '\n', 65504, '\t', '\f'}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 18, 1 - Process.getGidForName(""), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(0) + 87, false, objArr313);
            Class<?> cls11 = Class.forName((String) objArr313[0]);
            Object[] objArr314 = new Object[1];
            h(new char[]{2, 6, 65534, 65534, 5, 65530, '\t', '\f', 65534, 65533, 65515, 65534, 65530, 5, CharUtils.CR}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 20, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) - 34, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(18) + 29, false, objArr314);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr314[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame6 == null) {
                int minimumFlingVelocity2 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 25;
                char c4 = (char) (30068 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)));
                int iRed2 = Color.red(0) + 816;
                byte b211 = (byte) ($$g[5] - 1);
                byte b212 = b211;
                Object[] objArr315 = new Object[1];
                a(b211, b212, b212, objArr315);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity2, c4, iRed2, 721586079, false, (String) objArr315[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
            int i410 = artificialFrame + 63;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i410 % 128;
            int i411 = i410 % 2;
        }
        int i50 = ((int[]) objArr[1])[0];
        int i51 = ((int[]) objArr[0])[0];
        if (i51 == i50) {
            Object[] objArr40 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i52 = ((int[]) objArr[3])[0];
            int i53 = ((int[]) objArr[0])[0];
            int i54 = ((int[]) objArr[1])[0];
            String[] strArr6 = (String[]) objArr[2];
            int i55 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1411038133;
            int i56 = i52 + ((((~(503316479 | i55)) | 286203937) * 449) - 759092469) + (((~((~i55) | 503316479)) | 286203937) * 449);
            int i57 = (i56 << 13) ^ i56;
            int i58 = i57 ^ (i57 >>> 17);
            ((int[]) objArr40[3])[0] = i58 ^ (i58 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArr[2];
        if (strArr7 != null) {
            for (String str : strArr7) {
                arrayList2.add(str);
            }
        }
        Object[] objArr41 = {Long.valueOf(((long) (i50 ^ i51)) ^ (((long) 868538066) << 32)), Long.valueOf(868538067)};
        byte[] bArr4 = $$s;
        byte b30 = (byte) (-bArr4[35]);
        byte b31 = bArr4[34];
        Object[] objArr42 = new Object[1];
        i(b30, b31, b31, objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        Object[] objArr43 = new Object[1];
        i(bArr4[34], (byte) (-bArr4[52]), bArr4[46], objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
        int i59 = ((int[]) objArr[3])[0];
        int i60 = ((int[]) objArr[0])[0];
        int i61 = ((int[]) objArr[1])[0];
        String[] strArr8 = (String[]) objArr[2];
        int iMyUid = Process.myUid();
        int i62 = i59 + (((~(iMyUid | (-642565174))) * TypedValues.CycleType.TYPE_EASING) - 614168431) + (((~((~iMyUid) | (-642565174))) | 269492994) * TypedValues.CycleType.TYPE_EASING);
        int i63 = (i62 << 13) ^ i62;
        int i64 = i63 ^ (i63 >>> 17);
        ((int[]) objArr44[3])[0] = i64 ^ (i64 << 5);
    }

    static void accessartificialFrame() {
        setDefaultImpl = -260893972;
    }

    @Override // io.invertase.firebase.messaging.ReactNativeFirebaseMessagingService, com.google.firebase.messaging.FirebaseMessagingService, com.google.firebase.messaging.EnhancedIntentService, android.app.Service
    public void onCreate() {
        int i = 2 % 2;
        int i2 = artificialFrame + 99;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        int i3 = i2 % 2;
        super.onCreate();
        if (i3 != 0) {
            int i4 = 8 / 0;
        }
        int i5 = artificialFrame + 65;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i5 % 128;
        int i6 = i5 % 2;
    }
}
