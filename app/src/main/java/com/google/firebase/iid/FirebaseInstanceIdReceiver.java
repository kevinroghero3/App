package com.google.firebase.iid;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.cloudmessaging.CloudMessagingReceiver;
import com.google.android.gms.tasks.Tasks;
import com.google.android.material.color.utilities.QuantizerCelebi;
import com.google.common.base.Ascii;
import com.google.firebase.messaging.FcmBroadcastProcessor;
import com.google.firebase.messaging.MessagingAnalytics;
import com.salesforce.marketingcloud.analytics.stats.b;
import io.sentry.android.core.SentryLogcatAdapter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import o.ArtificialStackFrames;
import o.ICustomTabsCallbackDefault;
import okio.Utf8;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes5.dex */
public final class FirebaseInstanceIdReceiver extends CloudMessagingReceiver {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    private static char CoroutineDebuggingKt = 0;
    private static final String TAG = "FirebaseMessaging";
    private static int accessartificialFrame;
    private static int artificialFrame;
    private static long coroutineBoundary;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static final byte[] $$c = {110, -7, -8, 89};
    private static final int $$f = b.f39n;
    private static int $10 = 0;
    private static int $11 = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(byte r6, short r7, short r8) {
        /*
            int r8 = r8 * 2
            int r0 = 1 - r8
            int r7 = r7 * 3
            int r7 = 3 - r7
            int r6 = 101 - r6
            byte[] r1 = com.google.firebase.iid.FirebaseInstanceIdReceiver.$$c
            byte[] r0 = new byte[r0]
            r2 = 0
            int r8 = 0 - r8
            if (r1 != 0) goto L17
            r3 = r7
            r6 = r8
            r4 = r2
            goto L2c
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r6
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            return r6
        L25:
            int r7 = r7 + 1
            r3 = r1[r7]
            r5 = r3
            r3 = r7
            r7 = r5
        L2c:
            int r7 = -r7
            int r6 = r6 + r7
            r7 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdReceiver.$$g(byte, short, short):java.lang.String");
    }

    private static void b(short s, int i, short s2, Object[] objArr) {
        byte[] bArr = $$a;
        int i2 = 112 - i;
        int i3 = 112 - s2;
        byte[] bArr2 = new byte[s + 8];
        int i4 = s + 7;
        int i5 = -1;
        if (bArr == null) {
            i2++;
            i3 = (-i3) + i4;
            i5 = -1;
        }
        while (true) {
            int i6 = i5 + 1;
            bArr2[i6] = (byte) i3;
            if (i6 == i4) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i2++;
            i3 = (-bArr[i2]) + i3;
            i5 = i6;
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void c(int r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.google.firebase.iid.FirebaseInstanceIdReceiver.$$d
            int r1 = r6 + 3
            int r7 = 649 - r7
            int r8 = 111 - r8
            byte[] r1 = new byte[r1]
            int r6 = r6 + 2
            r2 = 0
            if (r0 != 0) goto L13
            r3 = r6
            r8 = r7
            r4 = r2
            goto L2b
        L13:
            r3 = r2
        L14:
            int r7 = r7 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            r3 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r3
            r3 = r5
        L2b:
            int r7 = -r7
            int r3 = r3 + r7
            int r7 = r3 + (-4)
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdReceiver.c(int, short, byte, java.lang.Object[]):void");
    }

    private static Intent createServiceIntent(@NonNull Context context, @NonNull String str, @NonNull Bundle bundle) {
        return new Intent(str).putExtras(bundle);
    }

    @Override // com.google.android.gms.cloudmessaging.CloudMessagingReceiver
    public int onMessageReceive(@NonNull Context context, @NonNull CloudMessage cloudMessage) {
        try {
            return ((Integer) Tasks.await(new FcmBroadcastProcessor(context).process(cloudMessage.getIntent()))).intValue();
        } catch (InterruptedException | ExecutionException e) {
            SentryLogcatAdapter.e("FirebaseMessaging", "Failed to send message to service.", e);
            return 500;
        }
    }

    @Override // com.google.android.gms.cloudmessaging.CloudMessagingReceiver
    public void onNotificationDismissed(@NonNull Context context, @NonNull Bundle bundle) {
        Intent intentCreateServiceIntent = createServiceIntent(context, CloudMessagingReceiver.IntentActionKeys.NOTIFICATION_DISMISS, bundle);
        if (MessagingAnalytics.shouldUploadScionMetrics(intentCreateServiceIntent)) {
            MessagingAnalytics.logNotificationDismiss(intentCreateServiceIntent);
        }
    }

    private static void a(char[] cArr, int i, char[] cArr2, char c, char[] cArr3, Object[] objArr) throws Throwable {
        int i2 = 2;
        int i3 = 2 % 2;
        ICustomTabsCallbackDefault iCustomTabsCallbackDefault = new ICustomTabsCallbackDefault();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr3.length;
        char[] cArr6 = new char[length3];
        iCustomTabsCallbackDefault.a = 0;
        while (iCustomTabsCallbackDefault.a < length3) {
            int i4 = $10 + 41;
            $11 = i4 % 128;
            int i5 = i4 % i2;
            try {
                Object[] objArr2 = {iCustomTabsCallbackDefault};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-10548171);
                if (objAccessartificialFrame == null) {
                    int iRed = 33 - Color.red(0);
                    char keyRepeatTimeout = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                    int iBlue = 1483 - Color.blue(0);
                    byte b = (byte) ($$f & 3);
                    byte b2 = (byte) (b - 2);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iRed, keyRepeatTimeout, iBlue, 1614432829, false, $$g(b, b2, b2), new Class[]{Object.class});
                }
                int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                Object[] objArr3 = {iCustomTabsCallbackDefault};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1818210492);
                if (objAccessartificialFrame2 == null) {
                    byte b3 = (byte) 0;
                    byte b4 = b3;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getFadingEdgeLength() >> 16) + 32, (char) ((Process.myTid() >> 22) + 49168), (ViewConfiguration.getTapTimeout() >> 16) + 899, 214239564, false, $$g(b3, b4, b4), new Class[]{Object.class});
                }
                int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                Object[] objArr4 = {iCustomTabsCallbackDefault, Integer.valueOf(cArr4[iCustomTabsCallbackDefault.a % 4] * 32718), Integer.valueOf(cArr5[iIntValue])};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1532285801);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) 3;
                    byte b6 = (byte) (b5 - 3);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getTouchSlop() >> 8) + 23, (char) (ViewConfiguration.getEdgeSlop() >> 16), 2441 - (ViewConfiguration.getEdgeSlop() >> 16), -1003383455, false, $$g(b5, b6, b6), new Class[]{Object.class, Integer.TYPE, Integer.TYPE});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                Object[] objArr5 = {Integer.valueOf(cArr4[iIntValue2] * 32718), Integer.valueOf(cArr5[iIntValue])};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-950633141);
                if (objAccessartificialFrame4 == null) {
                    byte b7 = (byte) 1;
                    byte b8 = (byte) (b7 - 1);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(21 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) (29753 - ExpandableListView.getPackedPositionChild(0L)), 1748 - Color.green(0), 1479752515, false, $$g(b7, b8, b8), new Class[]{Integer.TYPE, Integer.TYPE});
                }
                cArr5[iIntValue2] = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).charValue();
                cArr4[iIntValue2] = iCustomTabsCallbackDefault.MediaBrowserCompatApi21ConnectionCallback;
                cArr6[iCustomTabsCallbackDefault.a] = (char) (((((long) (cArr4[iIntValue2] ^ cArr3[iCustomTabsCallbackDefault.a])) ^ (coroutineBoundary ^ (-899883803867009716L))) ^ ((long) ((int) (((long) accessartificialFrame) ^ (-899883803867009716L))))) ^ ((long) ((char) (((long) CoroutineDebuggingKt) ^ (-899883803867009716L)))));
                iCustomTabsCallbackDefault.a++;
                i2 = 2;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        String str = new String(cArr6);
        int i6 = $11 + 95;
        $10 = i6 % 128;
        if (i6 % 2 != 0) {
            throw null;
        }
        objArr[0] = str;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0220 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x0222  */
    /* JADX WARN: Code duplicated, block: B:25:0x0232  */
    /* JADX WARN: Code duplicated, block: B:26:0x0237  */
    /* JADX WARN: Code duplicated, block: B:31:0x0341  */
    /* JADX WARN: Code duplicated, block: B:33:0x034a  */
    /* JADX WARN: Code duplicated, block: B:38:0x03b1  */
    /* JADX WARN: Code duplicated, block: B:67:0x0697  */
    /* JADX WARN: Code duplicated, block: B:70:0x06d6 A[Catch: all -> 0x20f6, TryCatch #4 {all -> 0x20f6, blocks: (B:244:0x17c3, B:246:0x17d0, B:247:0x17fd, B:249:0x1807, B:251:0x1814, B:252:0x1843, B:183:0x123e, B:185:0x1252, B:186:0x1283, B:148:0x0e16, B:150:0x0e1c, B:151:0x0e48, B:153:0x0e71, B:154:0x0efc, B:68:0x06b5, B:70:0x06d6, B:71:0x0725), top: B:363:0x06b5 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0738  */
    /* JADX WARN: Code duplicated, block: B:79:0x07a1  */
    @Override // com.google.android.gms.cloudmessaging.CloudMessagingReceiver, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws Throwable {
        Context applicationContext;
        Object[] objArr;
        Object objAccessartificialFrame;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        Object[] objArr2;
        Object objAccessartificialFrame4;
        Object objAccessartificialFrame5;
        Object[] objArr3;
        Object[] objArr4;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object[] objArr5;
        Object obj;
        Context applicationContext2;
        Object[] objArr6;
        Object[] objArr7;
        int i = 2 % 2;
        Object[] objArr8 = new Object[1];
        a(new char[]{47824, 15414, 6280, 7687}, AndroidCharacter.getMirror('0') - '0', new char[]{51092, 25425, 47536, 33987}, (char) TextUtils.indexOf("", "", 0, 0), new char[]{15346, 13492, 49475, 2469, 24342, 29332, 37464, 61303, 40504, 12893, 58140, 16079, 6101, 2644, 5436, 7158, 12442, 55301, 4985, 39866, 64221, 19451}, objArr8);
        String str = (String) objArr8[0];
        Object[] objArr9 = new Object[1];
        a(new char[]{47824, 15414, 6280, 7687}, 1559809261 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), new char[]{60798, 63692, 52572, 7195}, (char) (7117 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))), new char[]{2844, 18649, 32518, 6982, 48499, 10012, 36959, 25977, 60989, 36316, 50494, 1972, 33421, 14533, 13915}, objArr9);
        String str2 = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        a(new char[]{47824, 15414, 6280, 7687}, ViewConfiguration.getTouchSlop() >> 8, new char[]{58113, 7595, 52528, 6260}, (char) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 29901), new char[]{1218, 29999, 9342, 32966, 64453, 4744, 9000, 35046, 11702, 22435, 11624, 9033, 2523, 53745, 3879, 8892}, objArr10);
        String str3 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        a(new char[]{47824, 15414, 6280, 7687}, KeyEvent.normalizeMetaState(0), new char[]{19388, 6313, 43675, 6326}, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 46761), new char[]{37423, 32023, 48116, 35321, 33189, 60552, 17345, 44362, 21910, 56972, 46653, 63911, 37021, 48246, 3531, 24123}, objArr11);
        String str4 = (String) objArr11[0];
        Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame6 == null) {
            int absoluteGravity = 21 - Gravity.getAbsoluteGravity(0, 0);
            char cIndexOf = (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0));
            int trimmedLength = 465 - TextUtils.getTrimmedLength("");
            Object[] objArr12 = new Object[1];
            b($$a[5], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, (byte) ($$b - 3), objArr12);
            objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(absoluteGravity, cIndexOf, trimmedLength, -785931255, false, (String) objArr12[0], null);
        }
        long j = ((Field) objAccessartificialFrame6).getLong(null);
        if (j != -1) {
            int i2 = artificialFrame + 41;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
            if (i2 % 2 == 0 ? j + 1878 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue() : (j ^ 1878) < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                if (context != null) {
                    applicationContext = context;
                } else if ((context instanceof ContextWrapper) || ((ContextWrapper) context).getBaseContext() != null) {
                    applicationContext = context.getApplicationContext();
                } else {
                    applicationContext = null;
                }
                int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                Object[] objArr13 = new Object[1];
                a(new char[]{47824, 15414, 6280, 7687}, ViewConfiguration.getWindowTouchSlop() >> 8, new char[]{4629, 21560, 50825, 23685}, (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), new char[]{41923, 24490, 40836, 1796, 13842, 59580, 237, 60178, 47282, 1865, 27361, 50022, 50358, 29431, 62825, 16534, 47057, 58661, 48228, 10813, 14502, 32355, 38718, 59783, 64924, 57007, 30454, 32363, 30483, 38800, 2625, 39751, 11732, 38329, 48246, 43123, 21110, 15507, 19663, 45624, 9213, 24874, 8500, 58703, 46317, 32843, 21635, 44361, 60502, 16953, 45227, 4206, 18362, 36274, 47248, 13308, 6935, 48660, 46483, 38253, 25816, 55669, 30896, 13527}, objArr13);
                String str5 = (String) objArr13[0];
                Object[] objArr14 = new Object[1];
                a(new char[]{47824, 15414, 6280, 7687}, View.combineMeasuredStates(0, 0), new char[]{65019, 8999, 10645, 55682}, (char) TextUtils.getTrimmedLength(""), new char[]{50859, 39521, 20161, 45781, 28775, 17351, 52042, 63660, 62021, 53285, 4458, 38473, 49270, 52511, 47220, 6239, 22976, 4073, 32631, 12123, 29696, 34312, 58919, 20978, 14072, 52607, 39511, 8712, 28240, 51528, 4331, 23792, 54440, 17169, 2042, 15344, 42116, 7289, 15617, 17530, 47693, 27427, 11702, 40680, 51911, 34632, 51750, 9826, 40721, 20599, 24920, 23431, 18663, 46990, 54033, 43210, 56112, 49428, 14845, 57554, 6770, 58036, 63385, 36770}, objArr14);
                try {
                    Object[] objArr15 = {applicationContext, new String[]{str5, (String) objArr14[0]}, Integer.valueOf(iIntValue), 1, 474199817};
                    byte[] bArr = $$d;
                    Object[] objArr16 = new Object[1];
                    c((byte) (-bArr[2]), (short) 646, bArr[66], objArr16);
                    Class<?> cls = Class.forName((String) objArr16[0]);
                    Object[] objArr17 = new Object[1];
                    c(bArr[219], (short) 582, bArr[73], objArr17);
                    objArr = (Object[]) cls.getMethod((String) objArr17[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr15);
                    int i3 = ((int[]) objArr[0])[0];
                    int i4 = ((int[]) objArr[3])[0];
                    if (applicationContext != null) {
                        objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1142731807);
                        if (objAccessartificialFrame == null) {
                            int i5 = 22 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                            char doubleTapTimeout = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                            int capsMode = 465 - TextUtils.getCapsMode("", 0, 0);
                            Object[] objArr18 = new Object[1];
                            b($$a[5], (byte) 100, (byte) ($$b - 3), objArr18);
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i5, doubleTapTimeout, capsMode, -612765161, false, (String) objArr18[0], null);
                        }
                        ((Field) objAccessartificialFrame).set(null, objArr);
                        try {
                            Long lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1313006081);
                            if (objAccessartificialFrame2 == null) {
                                int pressedStateDuration = 21 - (ViewConfiguration.getPressedStateDuration() >> 16);
                                char c = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                                int offsetBefore = TextUtils.getOffsetBefore("", 0) + 465;
                                Object[] objArr19 = new Object[1];
                                b($$a[5], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, (byte) ($$b - 3), objArr19);
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(pressedStateDuration, c, offsetBefore, -785931255, false, (String) objArr19[0], null);
                            }
                            ((Field) objAccessartificialFrame2).set(null, lValueOf);
                        } catch (Exception unused) {
                            throw new RuntimeException();
                        }
                    }
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } else {
                Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame7 == null) {
                    int i6 = 21 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                    char packedPositionGroup = (char) ExpandableListView.getPackedPositionGroup(0L);
                    int iIndexOf = TextUtils.indexOf("", "", 0, 0) + 465;
                    Object[] objArr20 = new Object[1];
                    b($$a[5], (byte) 100, (byte) ($$b - 3), objArr20);
                    objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(i6, packedPositionGroup, iIndexOf, -612765161, false, (String) objArr20[0], null);
                }
                Object[] objArr21 = (Object[]) ((Field) objAccessartificialFrame7).get(null);
                objArr = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
                int i7 = ((int[]) objArr21[3])[0];
                int i8 = ((int[]) objArr21[0])[0];
                String[] strArr = (String[]) objArr21[1];
                int iIdentityHashCode = System.identityHashCode(this);
                int i9 = ~iIdentityHashCode;
                int i10 = (-1460931268) + (((~((-302014081) | i9)) | (~((-131097) | iIdentityHashCode)) | (~(443809530 | iIdentityHashCode))) * 765) + ((302014080 | (~((-302145177) | i9))) * 1530) + (((~((-302145177) | iIdentityHashCode)) | (~(443809530 | i9))) * 765) + 474199817;
                int i11 = (i10 << 13) ^ i10;
                int i12 = i11 ^ (i11 >>> 17);
                ((int[]) objArr[2])[0] = i12 ^ (i12 << 5);
            }
        } else {
            if (context != null) {
                applicationContext = context;
            } else if (context instanceof ContextWrapper) {
                applicationContext = context.getApplicationContext();
            } else {
                applicationContext = context.getApplicationContext();
            }
            int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr110 = new Object[1];
            a(new char[]{47824, 15414, 6280, 7687}, ViewConfiguration.getWindowTouchSlop() >> 8, new char[]{4629, 21560, 50825, 23685}, (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), new char[]{41923, 24490, 40836, 1796, 13842, 59580, 237, 60178, 47282, 1865, 27361, 50022, 50358, 29431, 62825, 16534, 47057, 58661, 48228, 10813, 14502, 32355, 38718, 59783, 64924, 57007, 30454, 32363, 30483, 38800, 2625, 39751, 11732, 38329, 48246, 43123, 21110, 15507, 19663, 45624, 9213, 24874, 8500, 58703, 46317, 32843, 21635, 44361, 60502, 16953, 45227, 4206, 18362, 36274, 47248, 13308, 6935, 48660, 46483, 38253, 25816, 55669, 30896, 13527}, objArr110);
            String str6 = (String) objArr110[0];
            Object[] objArr111 = new Object[1];
            a(new char[]{47824, 15414, 6280, 7687}, View.combineMeasuredStates(0, 0), new char[]{65019, 8999, 10645, 55682}, (char) TextUtils.getTrimmedLength(""), new char[]{50859, 39521, 20161, 45781, 28775, 17351, 52042, 63660, 62021, 53285, 4458, 38473, 49270, 52511, 47220, 6239, 22976, 4073, 32631, 12123, 29696, 34312, 58919, 20978, 14072, 52607, 39511, 8712, 28240, 51528, 4331, 23792, 54440, 17169, 2042, 15344, 42116, 7289, 15617, 17530, 47693, 27427, 11702, 40680, 51911, 34632, 51750, 9826, 40721, 20599, 24920, 23431, 18663, 46990, 54033, 43210, 56112, 49428, 14845, 57554, 6770, 58036, 63385, 36770}, objArr111);
            Object[] objArr112 = {applicationContext, new String[]{str6, (String) objArr111[0]}, Integer.valueOf(iIntValue2), 1, 474199817};
            byte[] bArr2 = $$d;
            Object[] objArr113 = new Object[1];
            c((byte) (-bArr2[2]), (short) 646, bArr2[66], objArr113);
            Class<?> cls2 = Class.forName((String) objArr113[0]);
            Object[] objArr114 = new Object[1];
            c(bArr2[219], (short) 582, bArr2[73], objArr114);
            objArr = (Object[]) cls2.getMethod((String) objArr114[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr112);
            int i13 = ((int[]) objArr[0])[0];
            int i14 = ((int[]) objArr[3])[0];
            if (applicationContext != null) {
                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame == null) {
                    int i15 = 22 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                    char doubleTapTimeout2 = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                    int capsMode2 = 465 - TextUtils.getCapsMode("", 0, 0);
                    Object[] objArr115 = new Object[1];
                    b($$a[5], (byte) 100, (byte) ($$b - 3), objArr115);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i15, doubleTapTimeout2, capsMode2, -612765161, false, (String) objArr115[0], null);
                }
                ((Field) objAccessartificialFrame).set(null, objArr);
                Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1313006081);
                if (objAccessartificialFrame2 == null) {
                    int pressedStateDuration2 = 21 - (ViewConfiguration.getPressedStateDuration() >> 16);
                    char c2 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                    int offsetBefore2 = TextUtils.getOffsetBefore("", 0) + 465;
                    Object[] objArr116 = new Object[1];
                    b($$a[5], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, (byte) ($$b - 3), objArr116);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(pressedStateDuration2, c2, offsetBefore2, -785931255, false, (String) objArr116[0], null);
                }
                ((Field) objAccessartificialFrame2).set(null, lValueOf2);
            }
        }
        int i16 = ((int[]) objArr[0])[0];
        int i17 = ((int[]) objArr[3])[0];
        if (i17 == i16) {
            Object[] objArr22 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i18 = ((int[]) objArr[2])[0];
            int i19 = ((int[]) objArr[3])[0];
            int i20 = ((int[]) objArr[0])[0];
            String[] strArr2 = (String[]) objArr[1];
            int i21 = ~((~((int) Process.getElapsedCpuTime())) | (-806906209));
            int i22 = i18 + ((((-968847231) | i21) * (-970)) - 1487595205) + ((i21 | 161941022) * 970);
            int i23 = (i22 << 13) ^ i22;
            int i24 = i23 ^ (i23 >>> 17);
            ((int[]) objArr22[2])[0] = i24 ^ (i24 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr[1];
            if (strArr3 != null) {
                for (String str7 : strArr3) {
                    arrayList.add(str7);
                }
            }
            long j2 = ((long) (i16 ^ i17)) ^ (((long) 61323898) << 32);
            long j3 = 61323834;
            int i25 = getARTIFICIAL_FRAME_PACKAGE_NAME + 5;
            artificialFrame = i25 % 128;
            if (i25 % 2 == 0) {
                int i26 = 4 % 2;
            }
            try {
                Object[] objArr23 = {Long.valueOf(j2), Long.valueOf(j3)};
                byte[] bArr3 = $$d;
                Object[] objArr24 = new Object[1];
                c(bArr3[211], (short) 562, bArr3[66], objArr24);
                Class<?> cls3 = Class.forName((String) objArr24[0]);
                byte b = bArr3[31];
                Object[] objArr25 = new Object[1];
                c(b, (short) (b | Ascii.FF), bArr3[0], objArr25);
                cls3.getMethod((String) objArr25[0], Long.TYPE, Long.TYPE).invoke(null, objArr23);
                Object[] objArr26 = {new int[]{i}, strArr, new int[1], new int[]{i}};
                int i27 = ((int[]) objArr[2])[0];
                int i28 = ((int[]) objArr[3])[0];
                int i29 = ((int[]) objArr[0])[0];
                String[] strArr4 = (String[]) objArr[1];
                int iMyTid = Process.myTid();
                int i30 = (-1064496539) + ((~(iMyTid | 912472100)) * JfifUtil.MARKER_SOI);
                int i31 = ~iMyTid;
                int i32 = i27 + i30 + ((1056406054 | i31) * (-216)) + (((~(i31 | 912472100)) | (-752122375)) * JfifUtil.MARKER_SOI);
                int i33 = (i32 << 13) ^ i32;
                int i34 = i33 ^ (i33 >>> 17);
                ((int[]) objArr26[2])[0] = i34 ^ (i34 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame8 == null) {
            int iKeyCodeFromString = KeyEvent.keyCodeFromString("") + 25;
            char c3 = (char) (30068 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
            int iNormalizeMetaState = KeyEvent.normalizeMetaState(0) + 816;
            Object[] objArr27 = new Object[1];
            b($$a[5], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, (byte) ($$b - 3), objArr27);
            objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString, c3, iNormalizeMetaState, 721586079, false, (String) objArr27[0], null);
        }
        long j4 = ((Field) objAccessartificialFrame8).getLong(null);
        if (j4 != -1) {
            int i35 = artificialFrame + 85;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i35 % 128;
            int i36 = i35 % 2;
            if (j4 + 1992 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame9 == null) {
                    int i37 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 24;
                    char cResolveSize = (char) (30068 - View.resolveSize(0, 0));
                    int iIndexOf2 = TextUtils.indexOf((CharSequence) "", '0', 0) + 817;
                    Object[] objArr28 = new Object[1];
                    b($$a[5], (byte) 100, (byte) ($$b - 3), objArr28);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(i37, cResolveSize, iIndexOf2, 891606461, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame9).get(null);
                objArr2 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i38 = ((int[]) objArr29[0])[0];
                int i39 = ((int[]) objArr29[1])[0];
                String[] strArr5 = (String[]) objArr29[2];
                int iNextInt = new Random().nextInt(1080769193);
                int i40 = (~(838715699 | iNextInt)) | 201334784;
                int i41 = ~iNextInt;
                int i42 = (-609411151) + ((i40 | (~((-3162419) | i41))) * 886) + (((~(i41 | (-838715700))) | 1036888065) * (-1772)) + ((~(i41 | 1036888065)) * 886) + 183081973;
                int i43 = (i42 << 13) ^ i42;
                int i44 = i43 ^ (i43 >>> 17);
                ((int[]) objArr2[3])[0] = i44 ^ (i44 << 5);
            } else {
                try {
                    Object[] objArr30 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 183081973};
                    objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame3 == null) {
                        int touchSlop = 25 - (ViewConfiguration.getTouchSlop() >> 8);
                        char scrollDefaultDelay = (char) (30068 - (ViewConfiguration.getScrollDefaultDelay() >> 16));
                        int iIndexOf3 = 816 - TextUtils.indexOf("", "", 0, 0);
                        byte b2 = $$a[47];
                        byte b3 = (byte) (b2 | 88);
                        Object[] objArr31 = new Object[1];
                        b(b2, b3, (byte) (b3 & Utf8.REPLACEMENT_BYTE), objArr31);
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(touchSlop, scrollDefaultDelay, iIndexOf3, -797394565, false, (String) objArr31[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr2 = (Object[]) ((Method) objAccessartificialFrame3).invoke(null, objArr30);
                    objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame4 == null) {
                        int keyRepeatDelay = 25 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                        char cBlue = (char) (Color.blue(0) + 30068);
                        int i45 = 817 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                        Object[] objArr32 = new Object[1];
                        b($$a[5], (byte) 100, (byte) ($$b - 3), objArr32);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay, cBlue, i45, 891606461, false, (String) objArr32[0], null);
                    }
                    ((Field) objAccessartificialFrame4).set(null, objArr2);
                    try {
                        Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame5 == null) {
                            int iIndexOf4 = 25 - TextUtils.indexOf("", "", 0);
                            char deadChar = (char) (KeyEvent.getDeadChar(0, 0) + 30068);
                            int packedPositionChild = ExpandableListView.getPackedPositionChild(0L) + 817;
                            Object[] objArr33 = new Object[1];
                            b($$a[5], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, (byte) ($$b - 3), objArr33);
                            objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iIndexOf4, deadChar, packedPositionChild, 721586079, false, (String) objArr33[0], null);
                        }
                        ((Field) objAccessartificialFrame5).set(null, lValueOf3);
                    } catch (Exception unused2) {
                        throw new RuntimeException();
                    }
                } catch (Throwable th3) {
                    Throwable cause3 = th3.getCause();
                    if (cause3 == null) {
                        throw th3;
                    }
                    throw cause3;
                }
            }
        } else {
            Object[] objArr34 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 183081973};
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame3 == null) {
                int touchSlop2 = 25 - (ViewConfiguration.getTouchSlop() >> 8);
                char scrollDefaultDelay2 = (char) (30068 - (ViewConfiguration.getScrollDefaultDelay() >> 16));
                int iIndexOf5 = 816 - TextUtils.indexOf("", "", 0, 0);
                byte b4 = $$a[47];
                byte b5 = (byte) (b4 | 88);
                Object[] objArr35 = new Object[1];
                b(b4, b5, (byte) (b5 & Utf8.REPLACEMENT_BYTE), objArr35);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(touchSlop2, scrollDefaultDelay2, iIndexOf5, -797394565, false, (String) objArr35[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr2 = (Object[]) ((Method) objAccessartificialFrame3).invoke(null, objArr34);
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame4 == null) {
                int keyRepeatDelay2 = 25 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                char cBlue2 = (char) (Color.blue(0) + 30068);
                int i46 = 817 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                Object[] objArr36 = new Object[1];
                b($$a[5], (byte) 100, (byte) ($$b - 3), objArr36);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay2, cBlue2, i46, 891606461, false, (String) objArr36[0], null);
            }
            ((Field) objAccessartificialFrame4).set(null, objArr2);
            Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame5 == null) {
                int iIndexOf6 = 25 - TextUtils.indexOf("", "", 0);
                char deadChar2 = (char) (KeyEvent.getDeadChar(0, 0) + 30068);
                int packedPositionChild2 = ExpandableListView.getPackedPositionChild(0L) + 817;
                Object[] objArr37 = new Object[1];
                b($$a[5], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, (byte) ($$b - 3), objArr37);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iIndexOf6, deadChar2, packedPositionChild2, 721586079, false, (String) objArr37[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, lValueOf4);
        }
        int i47 = ((int[]) objArr2[1])[0];
        int i48 = ((int[]) objArr2[0])[0];
        if (i48 == i47) {
            Object[] objArr38 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i49 = ((int[]) objArr2[3])[0];
            int i50 = ((int[]) objArr2[0])[0];
            int i51 = ((int[]) objArr2[1])[0];
            String[] strArr6 = (String[]) objArr2[2];
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i52 = i49 + ((~(iIdentityHashCode2 | 189882289)) * TypedValues.CycleType.TYPE_EASING) + 427092117 + (((~((~iIdentityHashCode2) | 189882289)) | 5267216) * TypedValues.CycleType.TYPE_EASING);
            int i53 = (i52 << 13) ^ i52;
            int i54 = i53 ^ (i53 >>> 17);
            ((int[]) objArr38[3])[0] = i54 ^ (i54 << 5);
        } else {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr7 = (String[]) objArr2[2];
            if (strArr7 != null) {
                int i55 = artificialFrame + 47;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i55 % 128;
                for (int i56 = i55 % 2 != 0 ? 1 : 0; i56 < strArr7.length; i56++) {
                    arrayList2.add(strArr7[i56]);
                }
            }
            Object[] objArr39 = {Long.valueOf(((long) (i47 ^ i48)) ^ (((long) 1426648092) << 32)), Long.valueOf(1426648093)};
            byte[] bArr4 = $$d;
            Object[] objArr40 = new Object[1];
            c((byte) (-bArr4[2]), (short) 522, bArr4[66], objArr40);
            Class<?> cls4 = Class.forName((String) objArr40[0]);
            byte b6 = bArr4[31];
            Object[] objArr41 = new Object[1];
            c(b6, (short) (b6 | Ascii.FF), bArr4[0], objArr41);
            cls4.getMethod((String) objArr41[0], Long.TYPE, Long.TYPE).invoke(null, objArr39);
            Object[] objArr42 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i57 = ((int[]) objArr2[3])[0];
            int i58 = ((int[]) objArr2[0])[0];
            int i59 = ((int[]) objArr2[1])[0];
            String[] strArr8 = (String[]) objArr2[2];
            int iIdentityHashCode3 = System.identityHashCode(this);
            int i60 = 1694903878 + (((~((~iIdentityHashCode3) | 581547934)) | (-788117503)) * (-245));
            int i61 = ~(iIdentityHashCode3 | 581547934);
            int i62 = i57 + i60 + (i61 * (-245)) + ((i61 | 779720300) * 245);
            int i63 = (i62 << 13) ^ i62;
            int i64 = i63 ^ (i63 >>> 17);
            ((int[]) objArr42[3])[0] = i64 ^ (i64 << 5);
        }
        Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame10 == null) {
            int size = View.MeasureSpec.getSize(0) + 30;
            char cKeyCodeFromString = (char) (49362 - KeyEvent.keyCodeFromString(""));
            int iResolveOpacity = Drawable.resolveOpacity(0, 0) + 684;
            byte[] bArr5 = $$a;
            Object[] objArr43 = new Object[1];
            b((byte) (-bArr5[4]), (byte) 81, bArr5[8], objArr43);
            objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(size, cKeyCodeFromString, iResolveOpacity, 508509282, false, (String) objArr43[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame10).getLong(null);
        if (j5 == -1 || j5 + 1907 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context applicationContext3 = context != null ? ((context instanceof ContextWrapper) && ((ContextWrapper) context).getBaseContext() == null) ? null : context.getApplicationContext() : context;
            Object[] objArr44 = {applicationContext3, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -157883064};
            byte[] bArr6 = $$d;
            Object[] objArr45 = new Object[1];
            c(bArr6[182], (short) FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED, bArr6[10], objArr45);
            Class<?> cls5 = Class.forName((String) objArr45[0]);
            Object[] objArr46 = new Object[1];
            c(bArr6[219], (short) 582, bArr6[73], objArr46);
            objArr3 = (Object[]) cls5.getMethod((String) objArr46[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr44);
            if (applicationContext3 != null) {
                Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame11 == null) {
                    int i65 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 30;
                    char cIndexOf2 = (char) (TextUtils.indexOf("", "", 0) + 49362);
                    int pressedStateDuration3 = (ViewConfiguration.getPressedStateDuration() >> 16) + 684;
                    byte b7 = (byte) ($$b - 3);
                    Object[] objArr47 = new Object[1];
                    b(b7, (byte) (b7 | 69), $$a[28], objArr47);
                    objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(i65, cIndexOf2, pressedStateDuration3, -1321816393, false, (String) objArr47[0], null);
                }
                ((Field) objAccessartificialFrame11).set(null, objArr3);
                try {
                    Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                    if (objAccessartificialFrame12 == null) {
                        int packedPositionGroup2 = ExpandableListView.getPackedPositionGroup(0L) + 30;
                        char packedPositionGroup3 = (char) (ExpandableListView.getPackedPositionGroup(0L) + 49362);
                        int i66 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 684;
                        byte[] bArr7 = $$a;
                        Object[] objArr48 = new Object[1];
                        b((byte) (-bArr7[4]), (byte) 81, bArr7[8], objArr48);
                        objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(packedPositionGroup2, packedPositionGroup3, i66, 508509282, false, (String) objArr48[0], null);
                    }
                    ((Field) objAccessartificialFrame12).set(null, lValueOf5);
                } catch (Exception unused3) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(777251007);
            if (objAccessartificialFrame13 == null) {
                int iIndexOf7 = TextUtils.indexOf((CharSequence) "", '0', 0) + 31;
                char cRed = (char) (49362 - Color.red(0));
                int offsetBefore3 = 684 - TextUtils.getOffsetBefore("", 0);
                byte b8 = (byte) ($$b - 3);
                Object[] objArr49 = new Object[1];
                b(b8, (byte) (b8 | 69), $$a[28], objArr49);
                objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(iIndexOf7, cRed, offsetBefore3, -1321816393, false, (String) objArr49[0], null);
            }
            Object[] objArr50 = (Object[]) ((Field) objAccessartificialFrame13).get(null);
            objArr3 = new Object[]{new int[]{((int[]) objArr50[0])[0]}, new int[]{((int[]) objArr50[1])[0]}, new int[1], (String) objArr50[3]};
            int i67 = ~System.identityHashCode(this);
            int i68 = (((-1026835138) + ((~((-536887489) | i67)) * (-783))) + (((~(i67 | 388775743)) | (-589848032)) * 783)) - 157883064;
            int i69 = (i68 << 13) ^ i68;
            int i70 = i69 ^ (i69 >>> 17);
            ((int[]) objArr3[2])[0] = i70 ^ (i70 << 5);
        }
        int i71 = ((int[]) objArr3[1])[0];
        int i72 = ((int[]) objArr3[0])[0];
        if (i72 == i71) {
            int i73 = ((int[]) objArr3[2])[0];
            Object[] objArr51 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
            int i74 = ~((int) Process.getStartUptimeMillis());
            int i75 = i73 + (-1941835826) + (((-624951321) | i74) * SyslogConstants.LOG_LOCAL7) + (((~(i74 | 311597699)) | (-894474265)) * SyslogConstants.LOG_LOCAL7);
            int i76 = (i75 << 13) ^ i75;
            int i77 = i76 ^ (i76 >>> 17);
            ((int[]) objArr51[2])[0] = i77 ^ (i77 << 5);
        } else {
            Object[] objArr52 = {Long.valueOf(((long) (i71 ^ i72)) ^ (((long) (-1577342148)) << 32)), Long.valueOf(-1577342660)};
            byte[] bArr8 = $$d;
            byte b9 = bArr8[302];
            Object[] objArr53 = new Object[1];
            c(b9, (short) (b9 | 311), bArr8[66], objArr53);
            Class<?> cls6 = Class.forName((String) objArr53[0]);
            byte b10 = bArr8[31];
            Object[] objArr54 = new Object[1];
            c(b10, (short) (b10 | Ascii.FF), bArr8[0], objArr54);
            cls6.getMethod((String) objArr54[0], Long.TYPE, Long.TYPE).invoke(null, objArr52);
            int i78 = ((int[]) objArr3[2])[0];
            Object[] objArr55 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
            int iIdentityHashCode4 = System.identityHashCode(this);
            int i79 = 66586014 + ((iIdentityHashCode4 | 909688239) * (-50));
            int i80 = ~((-68721968) | iIdentityHashCode4);
            int i81 = ~iIdentityHashCode4;
            int i82 = i78 + i79 + ((i80 | (~(i81 | (-213569)))) * 50) + (((~(i81 | 909688239)) | (~((-68935536) | i81)) | 213568) * 50);
            int i83 = (i82 << 13) ^ i82;
            int i84 = i83 ^ (i83 >>> 17);
            ((int[]) objArr55[2])[0] = i84 ^ (i84 << 5);
        }
        Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame14 == null) {
            int iIndexOf8 = 35 - TextUtils.indexOf((CharSequence) "", '0');
            char defaultSize = (char) View.getDefaultSize(0, 0);
            int iMyPid = 540 - (Process.myPid() >> 22);
            Object[] objArr56 = new Object[1];
            b($$a[5], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, (byte) ($$b - 3), objArr56);
            objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(iIndexOf8, defaultSize, iMyPid, 624296913, false, (String) objArr56[0], null);
        }
        long j6 = ((Field) objAccessartificialFrame14).getLong(null);
        if (j6 == -1 || j6 + 2036 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-1717965552);
            if (objAccessartificialFrame15 == null) {
                objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", "") + 20, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 39515), 983 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 117222168, false, null, new Class[0]);
            }
            Object[] objArr57 = {null, ((Constructor) objAccessartificialFrame15).newInstance(null), -676799921, 0};
            Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-501205803);
            if (objAccessartificialFrame16 == null) {
                int maximumFlingVelocity = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 36;
                char cIndexOf3 = (char) TextUtils.indexOf("", "", 0, 0);
                int i85 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 540;
                Object[] objArr58 = new Object[1];
                b($$a[118], (byte) 62, (byte) ($$b | 44), objArr58);
                objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity, cIndexOf3, i85, 2101703389, false, (String) objArr58[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(54 - View.combineMeasuredStates(0, 0), (char) (833 - (ViewConfiguration.getFadingEdgeLength() >> 16)), TextUtils.lastIndexOf("", '0', 0) + 577), (Class) ArtificialStackFrames.coroutineCreation(54 - View.combineMeasuredStates(0, 0), (char) TextUtils.indexOf("", "", 0, 0), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 630), Integer.TYPE, Integer.TYPE});
            }
            objArr4 = (Object[]) ((Method) objAccessartificialFrame16).invoke(null, objArr57);
            Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame17 == null) {
                int iLastIndexOf = TextUtils.lastIndexOf("", '0', 0, 0) + 37;
                char scrollBarFadeDuration = (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                int iIndexOf9 = 539 - TextUtils.indexOf((CharSequence) "", '0');
                Object[] objArr59 = new Object[1];
                b($$a[5], (byte) 100, (byte) ($$b - 3), objArr59);
                objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, scrollBarFadeDuration, iIndexOf9, 793268735, false, (String) objArr59[0], null);
            }
            ((Field) objAccessartificialFrame17).set(null, objArr4);
            try {
                Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                if (objAccessartificialFrame18 == null) {
                    int i86 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 35;
                    char mirror = (char) (AndroidCharacter.getMirror('0') - '0');
                    int offsetAfter = TextUtils.getOffsetAfter("", 0) + 540;
                    Object[] objArr60 = new Object[1];
                    b($$a[5], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, (byte) ($$b - 3), objArr60);
                    objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(i86, mirror, offsetAfter, 624296913, false, (String) objArr60[0], null);
                }
                ((Field) objAccessartificialFrame18).set(null, lValueOf6);
            } catch (Exception unused4) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame19 == null) {
                int mode = View.MeasureSpec.getMode(0) + 36;
                char cKeyCodeFromString2 = (char) KeyEvent.keyCodeFromString("");
                int iIndexOf10 = TextUtils.indexOf("", "") + 540;
                Object[] objArr61 = new Object[1];
                b($$a[5], (byte) 100, (byte) ($$b - 3), objArr61);
                objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(mode, cKeyCodeFromString2, iIndexOf10, 793268735, false, (String) objArr61[0], null);
            }
            Object[] objArr62 = (Object[]) ((Field) objAccessartificialFrame19).get(null);
            objArr4 = new Object[]{new int[1], new int[1], new int[1]};
            int i87 = ((int[]) objArr62[2])[0];
            int i88 = ((int[]) objArr62[1])[0];
            ((int[]) objArr4[2])[0] = i87;
            ((int[]) objArr4[1])[0] = i88;
            int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
            int i89 = (((((~((-1155914743) | iMaxMemory)) | 1330617225) * 398) - 1142667515) + (((~((~iMaxMemory) | (-1155914743))) | 1330617225) * 398)) - 676799921;
            int i90 = (i89 << 13) ^ i89;
            int i91 = i90 ^ (i90 >>> 17);
            ((int[]) objArr4[0])[0] = i91 ^ (i91 << 5);
            int i92 = artificialFrame + 51;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i92 % 128;
            int i93 = i92 % 2;
        }
        Object obj2 = objArr4[1];
        int i94 = ((int[]) obj2)[0];
        Object obj3 = objArr4[2];
        int i95 = ((int[]) obj3)[0];
        if (i95 == i94) {
            Object[] objArr63 = {new int[1], new int[1], new int[1]};
            int i96 = ((int[]) objArr4[0])[0];
            int i97 = ((int[]) obj3)[0];
            int i98 = ((int[]) obj2)[0];
            ((int[]) objArr63[2])[0] = i97;
            ((int[]) objArr63[1])[0] = i98;
            int iIdentityHashCode5 = System.identityHashCode(this);
            int i99 = ~iIdentityHashCode5;
            int i100 = i96 + 273629197 + (((~((-568354101) | i99)) | 547366144 | (~((-783267650) | i99))) * (-1136)) + (((~((-568354101) | iIdentityHashCode5)) | (~((-783267650) | iIdentityHashCode5)) | (~(804255605 | i99))) * (-568)) + (((~(iIdentityHashCode5 | (-547366145))) | (~(i99 | 783267649)) | (~(568354100 | i99))) * 568);
            int i101 = (i100 << 13) ^ i100;
            int i102 = i101 ^ (i101 >>> 17);
            ((int[]) objArr63[0])[0] = i102 ^ (i102 << 5);
        } else {
            Object[] objArr64 = {Long.valueOf(((long) (i94 ^ i95)) ^ (((long) (-698062317)) << 32)), Long.valueOf(-698058221)};
            byte[] bArr9 = $$d;
            byte b11 = bArr9[365];
            Object[] objArr65 = new Object[1];
            c(b11, (short) (b11 | Ascii.NAK), bArr9[66], objArr65);
            Class<?> cls7 = Class.forName((String) objArr65[0]);
            byte b12 = bArr9[31];
            Object[] objArr66 = new Object[1];
            c(b12, (short) (b12 | Ascii.FF), bArr9[0], objArr66);
            cls7.getMethod((String) objArr66[0], Long.TYPE, Long.TYPE).invoke(null, objArr64);
            Object[] objArr67 = {new int[1], new int[1], new int[1]};
            int i103 = ((int[]) objArr4[0])[0];
            int i104 = ((int[]) objArr4[2])[0];
            int i105 = ((int[]) objArr4[1])[0];
            ((int[]) objArr67[2])[0] = i104;
            ((int[]) objArr67[1])[0] = i105;
            int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
            int i106 = i103 + 664061299 + (((~(startElapsedRealtime | 921365115)) | 430256634) * 191) + (((~((~startElapsedRealtime) | 921365115)) | 151327104) * 191);
            int i107 = (i106 << 13) ^ i106;
            int i108 = i107 ^ (i107 >>> 17);
            ((int[]) objArr67[0])[0] = i108 ^ (i108 << 5);
        }
        Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame20 == null) {
            int mode2 = View.MeasureSpec.getMode(0) + 26;
            char c4 = (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)));
            int gidForName = Process.getGidForName("") + 1042;
            Object[] objArr68 = new Object[1];
            b($$a[5], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, (byte) ($$b - 3), objArr68);
            objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(mode2, c4, gidForName, 2061780482, false, (String) objArr68[0], null);
        }
        long j7 = ((Field) objAccessartificialFrame20).getLong(null);
        if (j7 == -1 || j7 + 1881 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            int iIntValue3 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr69 = {1785898751};
            Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame21 == null) {
                objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation((KeyEvent.getMaxKeyCode() >> 16) + 8, (char) (22252 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), KeyEvent.getDeadChar(0, 0) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = QuantizerCelebi.accessartificialFrame$78cbbd35(iIntValue3, 0, ((Constructor) objAccessartificialFrame21).newInstance(objArr69), 301123628, false);
            Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame22 == null) {
                int bitsPerPixel = ImageFormat.getBitsPerPixel(0) + 27;
                char c5 = (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                int i109 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 1040;
                Object[] objArr70 = new Object[1];
                b($$a[5], (byte) 100, (byte) ($$b - 3), objArr70);
                objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(bitsPerPixel, c5, i109, 1145017376, false, (String) objArr70[0], null);
            }
            ((Field) objAccessartificialFrame22).set(null, objArrAccessartificialFrame$78cbbd35);
            try {
                Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame23 == null) {
                    int tapTimeout = 26 - (ViewConfiguration.getTapTimeout() >> 16);
                    char maximumDrawingCacheSize = (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                    int iResolveOpacity2 = Drawable.resolveOpacity(0, 0) + 1041;
                    Object[] objArr71 = new Object[1];
                    b($$a[5], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, (byte) ($$b - 3), objArr71);
                    objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(tapTimeout, maximumDrawingCacheSize, iResolveOpacity2, 2061780482, false, (String) objArr71[0], null);
                }
                ((Field) objAccessartificialFrame23).set(null, lValueOf7);
            } catch (Exception unused5) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame24 == null) {
                int minimumFlingVelocity = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 26;
                char minimumFlingVelocity2 = (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                int scrollBarFadeDuration2 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 1041;
                Object[] objArr72 = new Object[1];
                b($$a[5], (byte) 100, (byte) ($$b - 3), objArr72);
                objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity, minimumFlingVelocity2, scrollBarFadeDuration2, 1145017376, false, (String) objArr72[0], null);
            }
            Object[] objArr73 = (Object[]) ((Field) objAccessartificialFrame24).get(null);
            objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
            int i110 = ((int[]) objArr73[3])[0];
            int i111 = ((int[]) objArr73[2])[0];
            String[] strArr9 = (String[]) objArr73[0];
            int iIdentityHashCode6 = System.identityHashCode(this);
            int i112 = ~iIdentityHashCode6;
            int i113 = (-702363266) + ((~(952429299 | i112)) * (-560)) + ((~(iIdentityHashCode6 | 1021177847)) * (-560)) + (((~((-874325493) | i112)) | 805576944) * 560) + 301123628;
            int i114 = (i113 << 13) ^ i113;
            int i115 = i114 ^ (i114 >>> 17);
            ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i115 ^ (i115 << 5);
        }
        int i116 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i117 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i117 == i116) {
            int i118 = artificialFrame + 117;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i118 % 128;
            int i119 = i118 % 2;
            Object[] objArr74 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i120 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i121 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i122 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr10 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iIdentityHashCode7 = System.identityHashCode(this);
            int i123 = ~iIdentityHashCode7;
            int i124 = i120 + (-1803065844) + (((~((-685306939) | i123)) | (-607203132)) * 519) + (((~(i123 | (-537928763))) | (~((-69274370) | iIdentityHashCode7))) * (-519)) + (((~(iIdentityHashCode7 | (-607203132))) | 685306938) * 519);
            int i125 = (i124 << 13) ^ i124;
            int i126 = i125 ^ (i125 >>> 17);
            ((int[]) objArr74[1])[0] = i126 ^ (i126 << 5);
        } else {
            ArrayList arrayList3 = new ArrayList();
            String[] strArr11 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr11 != null) {
                for (String str8 : strArr11) {
                    arrayList3.add(str8);
                }
            }
            Object[] objArr75 = {Long.valueOf(((long) (i116 ^ i117)) ^ (((long) 1977389921) << 32)), Long.valueOf(1977389923)};
            byte[] bArr10 = $$d;
            Object[] objArr76 = new Object[1];
            c((byte) (-bArr10[560]), (short) 275, bArr10[66], objArr76);
            Class<?> cls8 = Class.forName((String) objArr76[0]);
            byte b13 = bArr10[31];
            Object[] objArr77 = new Object[1];
            c(b13, (short) (b13 | Ascii.FF), bArr10[0], objArr77);
            cls8.getMethod((String) objArr77[0], Long.TYPE, Long.TYPE).invoke(null, objArr75);
            Object[] objArr78 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i127 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i128 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i129 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr12 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iIdentityHashCode8 = System.identityHashCode(this);
            int i130 = ~iIdentityHashCode8;
            int i131 = i127 + 673169790 + (((~((-469794833) | i130)) | 547898639) * 220) + (((~(i130 | (-508932721))) | 587036527) * (-440)) + ((iIdentityHashCode8 | (-469794833)) * 220);
            int i132 = (i131 << 13) ^ i131;
            int i133 = i132 ^ (i132 >>> 17);
            ((int[]) objArr78[1])[0] = i133 ^ (i133 << 5);
        }
        Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame25 == null) {
            int trimmedLength2 = TextUtils.getTrimmedLength("") + 17;
            char c6 = (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
            int packedPositionChild3 = 746 - ExpandableListView.getPackedPositionChild(0L);
            Object[] objArr79 = new Object[1];
            b($$a[5], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, (byte) ($$b - 3), objArr79);
            objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(trimmedLength2, c6, packedPositionChild3, -144068856, false, (String) objArr79[0], null);
        }
        long j8 = ((Field) objAccessartificialFrame25).getLong(null);
        if (j8 == -1 || j8 + 1931 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr80 = {context != null ? ((context instanceof ContextWrapper) && ((ContextWrapper) context).getBaseContext() == null) ? null : context.getApplicationContext() : context, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 679515529};
            byte[] bArr11 = $$d;
            byte b14 = bArr11[365];
            Object[] objArr81 = new Object[1];
            c(b14, (short) (b14 | 201), bArr11[66], objArr81);
            Class<?> cls9 = Class.forName((String) objArr81[0]);
            Object[] objArr82 = new Object[1];
            c(bArr11[40], (short) 199, (byte) ($$e + 3), objArr82);
            objArr5 = (Object[]) cls9.getMethod((String) objArr82[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr80);
            Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame26 == null) {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0) + 17;
                char c7 = (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                int packedPositionType = ExpandableListView.getPackedPositionType(0L) + 747;
                Object[] objArr83 = new Object[1];
                b($$a[5], (byte) 100, (byte) ($$b - 3), objArr83);
                objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec, c7, packedPositionType, -1031537386, false, (String) objArr83[0], null);
            }
            ((Field) objAccessartificialFrame26).set(null, objArr5);
            try {
                Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame27 == null) {
                    int iIndexOf11 = 17 - TextUtils.indexOf("", "", 0);
                    char c8 = (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                    int maximumDrawingCacheSize2 = 747 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                    Object[] objArr84 = new Object[1];
                    b($$a[5], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, (byte) ($$b - 3), objArr84);
                    objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(iIndexOf11, c8, maximumDrawingCacheSize2, -144068856, false, (String) objArr84[0], null);
                }
                ((Field) objAccessartificialFrame27).set(null, lValueOf8);
            } catch (Exception unused6) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame28 == null) {
                int packedPositionGroup4 = ExpandableListView.getPackedPositionGroup(0L) + 17;
                char cIndexOf4 = (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0'));
                int packedPositionType2 = 747 - ExpandableListView.getPackedPositionType(0L);
                Object[] objArr85 = new Object[1];
                b($$a[5], (byte) 100, (byte) ($$b - 3), objArr85);
                objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(packedPositionGroup4, cIndexOf4, packedPositionType2, -1031537386, false, (String) objArr85[0], null);
            }
            Object[] objArr86 = (Object[]) ((Field) objAccessartificialFrame28).get(null);
            objArr5 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
            int i134 = ((int[]) objArr86[3])[0];
            int i135 = ((int[]) objArr86[4])[0];
            List list = (List) objArr86[0];
            List list2 = (List) objArr86[2];
            int iIdentityHashCode9 = System.identityHashCode(this);
            int i136 = ~((-809931025) | iIdentityHashCode9);
            int i137 = ~iIdentityHashCode9;
            int i138 = 1938616497 + ((i136 | (~(1065286431 | i137))) * 920) + (((~((-860803866) | i137)) | 809931024) * 920) + (((~(iIdentityHashCode9 | 1065286431)) | (~((-809931025) | i137)) | (~((-50872842) | iIdentityHashCode9))) * 920) + 679515529;
            int i139 = (i138 << 13) ^ i138;
            int i140 = i139 ^ (i139 >>> 17);
            ((int[]) objArr5[1])[0] = i140 ^ (i140 << 5);
        }
        int i141 = ((int[]) objArr5[4])[0];
        int i142 = ((int[]) objArr5[3])[0];
        if (i142 == i141) {
            Object[] objArr87 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i143 = ((int[]) objArr5[1])[0];
            int i144 = ((int[]) objArr5[3])[0];
            int i145 = ((int[]) objArr5[4])[0];
            List list3 = (List) objArr5[0];
            List list4 = (List) objArr5[2];
            int i146 = ~((int) Process.getStartElapsedRealtime());
            int i147 = i143 + 1235824115 + (((-538263570) | i146) * 494) + (((~(i146 | 65050860)) | (-601180402)) * 494);
            int i148 = (i147 << 13) ^ i147;
            int i149 = i148 ^ (i148 >>> 17);
            ((int[]) objArr87[1])[0] = i149 ^ (i149 << 5);
        } else {
            ArrayList arrayList4 = new ArrayList();
            Object[] objArr88 = {objArr5};
            Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(1804664566);
            if (objAccessartificialFrame29 == null) {
                objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(41 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (ImageFormat.getBitsPerPixel(0) + 12469), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 3642, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
            }
            arrayList4.add(((Method) objAccessartificialFrame29).invoke(null, objArr88));
            Object[] objArr89 = {objArr5};
            Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(-1243809191);
            if (objAccessartificialFrame30 == null) {
                objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 41, (char) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 12468), 3642 - TextUtils.indexOf("", "", 0), 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
            }
            arrayList4.add(((Method) objAccessartificialFrame30).invoke(null, objArr89));
            Object[] objArr90 = {Long.valueOf(((long) (i141 ^ i142)) ^ (((long) 1093121732) << 32)), Long.valueOf(1093121740)};
            byte[] bArr12 = $$d;
            Object[] objArr91 = new Object[1];
            c(bArr12[139], (short) RotationOptions.ROTATE_180, bArr12[66], objArr91);
            Class<?> cls10 = Class.forName((String) objArr91[0]);
            byte b15 = bArr12[31];
            Object[] objArr92 = new Object[1];
            c(b15, (short) (b15 | Ascii.FF), bArr12[0], objArr92);
            cls10.getMethod((String) objArr92[0], Long.TYPE, Long.TYPE).invoke(null, objArr90);
            Object[] objArr93 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i150 = ((int[]) objArr5[1])[0];
            int i151 = ((int[]) objArr5[3])[0];
            int i152 = ((int[]) objArr5[4])[0];
            List list5 = (List) objArr5[0];
            List list6 = (List) objArr5[2];
            int iNextInt2 = new Random().nextInt();
            int i153 = ~iNextInt2;
            int i154 = i150 + 1283078155 + (((~(186962537 | i153)) | (~((-792410996) | iNextInt2))) * (-370)) + (((~(iNextInt2 | 186962537)) | (~(i153 | (-792410996))) | 311304) * (-370)) + 115182480;
            int i155 = (i154 << 13) ^ i154;
            int i156 = i155 ^ (i155 >>> 17);
            ((int[]) objArr93[1])[0] = i156 ^ (i156 << 5);
        }
        Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame31 == null) {
            int fadingEdgeLength = 30 - (ViewConfiguration.getFadingEdgeLength() >> 16);
            char cResolveSize2 = (char) (49362 - View.resolveSize(0, 0));
            int i157 = 685 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
            byte[] bArr13 = $$a;
            byte b16 = bArr13[28];
            Object[] objArr94 = new Object[1];
            b(b16, (byte) (b16 | 34), bArr13[8], objArr94);
            objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength, cResolveSize2, i157, 752929587, false, (String) objArr94[0], null);
        }
        long j9 = ((Field) objAccessartificialFrame31).getLong(null);
        if (j9 == -1 || j9 + 2033 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            if (context != null) {
                int i158 = getARTIFICIAL_FRAME_PACKAGE_NAME + 39;
                artificialFrame = i158 % 128;
                if (i158 % 2 == 0) {
                    boolean z = context instanceof ContextWrapper;
                    throw null;
                }
                if ((context instanceof ContextWrapper) && ((ContextWrapper) context).getBaseContext() == null) {
                    obj = null;
                    applicationContext2 = null;
                } else {
                    applicationContext2 = context.getApplicationContext();
                    obj = null;
                }
            } else {
                obj = null;
                applicationContext2 = context;
            }
            Object[] objArr95 = {applicationContext2, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(obj, this)).intValue()), 0, -1019968017};
            byte b17 = (byte) 89;
            byte[] bArr14 = $$d;
            Object[] objArr96 = new Object[1];
            c(b17, (short) (b17 | 32), bArr14[16], objArr96);
            Class<?> cls11 = Class.forName((String) objArr96[0]);
            Object[] objArr97 = new Object[1];
            c(bArr14[40], (short) 199, (byte) ($$e + 3), objArr97);
            objArr6 = (Object[]) cls11.getMethod((String) objArr97[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr95);
            if (applicationContext2 != null) {
                Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(-326560385);
                if (objAccessartificialFrame32 == null) {
                    int iCombineMeasuredStates = 30 - View.combineMeasuredStates(0, 0);
                    char scrollDefaultDelay3 = (char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 49362);
                    int iCombineMeasuredStates2 = 684 - View.combineMeasuredStates(0, 0);
                    byte[] bArr15 = $$a;
                    Object[] objArr98 = new Object[1];
                    b(bArr15[28], (byte) (-bArr15[20]), bArr15[9], objArr98);
                    objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates, scrollDefaultDelay3, iCombineMeasuredStates2, 1944867703, false, (String) objArr98[0], null);
                }
                ((Field) objAccessartificialFrame32).set(null, objArr6);
                try {
                    Long lValueOf9 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                    if (objAccessartificialFrame33 == null) {
                        int iNormalizeMetaState2 = KeyEvent.normalizeMetaState(0) + 30;
                        char maximumDrawingCacheSize3 = (char) (49362 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                        int iIndexOf12 = TextUtils.indexOf("", "", 0) + 684;
                        byte[] bArr16 = $$a;
                        byte b18 = bArr16[28];
                        Object[] objArr99 = new Object[1];
                        b(b18, (byte) (b18 | 34), bArr16[8], objArr99);
                        objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState2, maximumDrawingCacheSize3, iIndexOf12, 752929587, false, (String) objArr99[0], null);
                    }
                    ((Field) objAccessartificialFrame33).set(null, lValueOf9);
                } catch (Exception unused7) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(-326560385);
            if (objAccessartificialFrame34 == null) {
                int bitsPerPixel2 = 29 - ImageFormat.getBitsPerPixel(0);
                char bitsPerPixel3 = (char) (ImageFormat.getBitsPerPixel(0) + 49363);
                int modifierMetaStateMask = 683 - ((byte) KeyEvent.getModifierMetaStateMask());
                byte[] bArr17 = $$a;
                Object[] objArr100 = new Object[1];
                b(bArr17[28], (byte) (-bArr17[20]), bArr17[9], objArr100);
                objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(bitsPerPixel2, bitsPerPixel3, modifierMetaStateMask, 1944867703, false, (String) objArr100[0], null);
            }
            Object[] objArr101 = (Object[]) ((Field) objAccessartificialFrame34).get(null);
            objArr6 = new Object[]{new int[]{((int[]) objArr101[0])[0]}, new int[]{((int[]) objArr101[1])[0]}, new int[1], (String) objArr101[3]};
            int elapsedCpuTime = (int) Process.getElapsedCpuTime();
            int i159 = (-1555495352) + (((~((~elapsedCpuTime) | (-361426865))) | 285360784) * (-245));
            int i160 = ~(elapsedCpuTime | (-361426865));
            int i161 = ((i159 + (i160 * (-245))) + ((i160 | 617196910) * 245)) - 1019968017;
            int i162 = (i161 << 13) ^ i161;
            int i163 = i162 ^ (i162 >>> 17);
            ((int[]) objArr6[2])[0] = i163 ^ (i163 << 5);
        }
        int i164 = ((int[]) objArr6[1])[0];
        int i165 = ((int[]) objArr6[0])[0];
        if (i165 == i164) {
            int i166 = ((int[]) objArr6[2])[0];
            Object[] objArr102 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
            int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
            int i167 = ~((-747818285) | (~iFreeMemory));
            int i168 = i166 + ((((21037778 | i167) | (~(747818284 | iFreeMemory))) * (-338)) - 500541854) + (((~(iFreeMemory | 768856062)) | i167) * 338);
            int i169 = (i168 << 13) ^ i168;
            int i170 = i169 ^ (i169 >>> 17);
            ((int[]) objArr102[2])[0] = i170 ^ (i170 << 5);
        } else {
            long j10 = ((long) (i164 ^ i165)) ^ (((long) 1953295263) << 32);
            long j11 = 1953295259;
            int i171 = artificialFrame + 37;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i171 % 128;
            int i172 = i171 % 2;
            Object[] objArr103 = {Long.valueOf(j10), Long.valueOf(j11)};
            byte[] bArr18 = $$d;
            byte b19 = bArr18[365];
            Object[] objArr104 = new Object[1];
            c(b19, (short) (b19 | Ascii.NAK), bArr18[66], objArr104);
            Class<?> cls12 = Class.forName((String) objArr104[0]);
            byte b20 = bArr18[31];
            Object[] objArr105 = new Object[1];
            c(b20, (short) (b20 | Ascii.FF), bArr18[0], objArr105);
            cls12.getMethod((String) objArr105[0], Long.TYPE, Long.TYPE).invoke(null, objArr103);
            int i173 = ((int[]) objArr6[2])[0];
            Object[] objArr106 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
            int startUptimeMillis = (int) Process.getStartUptimeMillis();
            int i174 = i173 + (-872584314) + ((~((~startUptimeMillis) | 972722174)) * (-116)) + ((819629412 | startUptimeMillis) * 116) + (((~(startUptimeMillis | (-158994363))) | 5901600) * 116);
            int i175 = (i174 << 13) ^ i174;
            int i176 = i175 ^ (i175 >>> 17);
            ((int[]) objArr106[2])[0] = i176 ^ (i176 << 5);
        }
        Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame35 == null) {
            int iRed = 30 - Color.red(0);
            char c9 = (char) (49363 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
            int iResolveOpacity3 = Drawable.resolveOpacity(0, 0) + 684;
            byte[] bArr19 = $$a;
            Object[] objArr107 = new Object[1];
            b((byte) (-bArr19[4]), bArr19[18], bArr19[9], objArr107);
            objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(iRed, c9, iResolveOpacity3, -1583976536, false, (String) objArr107[0], null);
        }
        long j12 = ((Field) objAccessartificialFrame35).getLong(null);
        if (j12 == -1 || j12 + 1895 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            int iIntValue4 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            int i177 = getARTIFICIAL_FRAME_PACKAGE_NAME + 5;
            artificialFrame = i177 % 128;
            int i178 = i177 % 2;
            Object[] objArr108 = {Integer.valueOf(iIntValue4), 941432649};
            byte[] bArr20 = $$d;
            Object[] objArr109 = new Object[1];
            c((byte) (bArr20[404] - 1), bArr20[258], bArr20[31], objArr109);
            Class<?> cls13 = Class.forName((String) objArr109[0]);
            Object[] objArr117 = new Object[1];
            c(bArr20[73], bArr20[31], bArr20[66], objArr117);
            Object[] objArr118 = (Object[]) cls13.getMethod((String) objArr117[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr108);
            Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame36 == null) {
                int iGreen = Color.green(0) + 30;
                char tapTimeout2 = (char) (49362 - (ViewConfiguration.getTapTimeout() >> 16));
                int iRgb = (-16776532) - Color.rgb(0, 0, 0);
                byte[] bArr21 = $$a;
                byte b21 = bArr21[5];
                Object[] objArr119 = new Object[1];
                b(b21, (byte) (b21 - 1), bArr21[11], objArr119);
                objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(iGreen, tapTimeout2, iRgb, -1456483158, false, (String) objArr119[0], null);
            }
            ((Field) objAccessartificialFrame36).set(null, objArr118);
            try {
                Long lValueOf10 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame37 == null) {
                    int iLastIndexOf2 = TextUtils.lastIndexOf("", '0') + 31;
                    char cArgb = (char) (Color.argb(0, 0, 0, 0) + 49362);
                    int iResolveSize = View.resolveSize(0, 0) + 684;
                    byte[] bArr22 = $$a;
                    Object[] objArr120 = new Object[1];
                    b((byte) (-bArr22[4]), bArr22[18], bArr22[9], objArr120);
                    objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(iLastIndexOf2, cArgb, iResolveSize, -1583976536, false, (String) objArr120[0], null);
                }
                ((Field) objAccessartificialFrame37).set(null, lValueOf10);
                objArr7 = objArr118;
            } catch (Exception unused8) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame38 == null) {
                int longPressTimeout = 30 - (ViewConfiguration.getLongPressTimeout() >> 16);
                char maxKeyCode = (char) ((KeyEvent.getMaxKeyCode() >> 16) + 49362);
                int iIndexOf13 = 684 - TextUtils.indexOf("", "");
                byte[] bArr23 = $$a;
                byte b22 = bArr23[5];
                Object[] objArr121 = new Object[1];
                b(b22, (byte) (b22 - 1), bArr23[11], objArr121);
                objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(longPressTimeout, maxKeyCode, iIndexOf13, -1456483158, false, (String) objArr121[0], null);
            }
            Object[] objArr122 = (Object[]) ((Field) objAccessartificialFrame38).get(null);
            objArr7 = new Object[]{new int[]{((int[]) objArr122[0])[0]}, new int[]{((int[]) objArr122[1])[0]}, new int[1], (String) objArr122[3]};
            int i179 = ~((int) Process.getStartUptimeMillis());
            int i180 = 1300475790 + (((~(i179 | (-1083409))) | (~((-92410881) | i179))) * (-184)) + ((442564743 | (~((-534975624) | i179)) | (~((-443648152) | i179))) * SyslogConstants.LOG_LOCAL7) + 792046545;
            int i181 = (i180 << 13) ^ i180;
            int i182 = i181 ^ (i181 >>> 17);
            ((int[]) objArr7[2])[0] = i182 ^ (i182 << 5);
        }
        int i183 = ((int[]) objArr7[1])[0];
        int i184 = ((int[]) objArr7[0])[0];
        if (i184 == i183) {
            int i185 = getARTIFICIAL_FRAME_PACKAGE_NAME + 65;
            artificialFrame = i185 % 128;
            int i186 = i185 % 2;
            int i187 = ((int[]) objArr7[2])[0];
            Object[] objArr123 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
            int iIdentityHashCode10 = System.identityHashCode(this);
            int i188 = i187 + (-381930532) + (((~((-8519809) | (~iIdentityHashCode10))) | (-970103967)) * (-591)) + ((iIdentityHashCode10 | (-8519809)) * 591);
            int i189 = i188 ^ (i188 << 13);
            int i190 = i189 ^ (i189 >>> 17);
            ((int[]) objArr123[2])[0] = i190 ^ (i190 << 5);
        } else {
            new ArrayList().add((String) objArr7[3]);
            Object[] objArr124 = {Long.valueOf(((long) (i183 ^ i184)) ^ (((long) 475447184) << 32)), Long.valueOf(475447168)};
            byte[] bArr24 = $$d;
            byte b23 = bArr24[302];
            Object[] objArr125 = new Object[1];
            c(b23, (short) (b23 | 311), bArr24[66], objArr125);
            Class<?> cls14 = Class.forName((String) objArr125[0]);
            byte b24 = bArr24[31];
            Object[] objArr126 = new Object[1];
            c(b24, (short) (b24 | Ascii.FF), bArr24[0], objArr126);
            cls14.getMethod((String) objArr126[0], Long.TYPE, Long.TYPE).invoke(null, objArr124);
            int i191 = ((int[]) objArr7[2])[0];
            Object[] objArr127 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
            int iUptimeMillis = (int) SystemClock.uptimeMillis();
            int i192 = i191 + (-1639129168) + (((~((-896340974) | iUptimeMillis)) | 73728289) * 345) + (((~((-896340974) | (~iUptimeMillis))) | 8554512) * 345) + ((~(iUptimeMillis | (-73728290))) * 345);
            int i193 = (i192 << 13) ^ i192;
            int i194 = i193 ^ (i193 >>> 17);
            ((int[]) objArr127[2])[0] = i194 ^ (i194 << 5);
        }
        super.onReceive(context, intent);
    }

    static {
        byte[] bArr = new byte[666];
        System.arraycopy("KdÂ\u0016ðþ;Ãôü\u0004÷\u00033Éï\u0006îÿ\u0002\u00012ÃööAÁ÷ö\u000bï\u0000\tñ:½ýýþñ\u0011å\tò\u0006öý\u000bùýë\u000bð\u0007û\u0002ùé\u0003\u0006ô\u0003ý2°ü\f\u0003úüúîü\u000eëú\u0007ÿù\u0002ö\u0004ñ\"Ð\rð\u0004ðþ;Ãôü\u0004÷\u00033½ýýþñBÇðþüúý<·\u000bõþ÷ö\u000bï\u0000\tñ:°ü\u0005ü¿ðþ;Ä\u0001úúÿïü\u00009Áø\böþñ\u0003õ\u0007õÿ÷\u00053Çðù\t3ÚÚÿ\u0007ë\u000eúï\u001bêðø\fó\u0007ú\u001báúë\u0001ùõQÝÐþù\u000bï\u0001öýø÷\u0004ÿ÷<Áö=º\u000bé\b6Úëé\bñ$Ó\u0011ü\u000bëé\b\u0012éþêÿû\u0006ï\r\u001bÍ\u0003\u0007ë\u0007öý÷$ÓLüÛÉ\u0000\u000bï\u0000\tñ\u0015Ö\u0007ö\bÿí\u0007\u0002\u001eÍ\u0003\u0018Ú\u0007ûõ\u0019Öý\u0004ÿ÷\u00050õðþ;Ä\u0001úúÿïü\u00009¸\t\u0000úëBµ\bø\bï\töþï@Ñæ\u0004\u0002\u000fÛ\u0007û\u0011ÝüÿDüÛÉ\u0000\u000bï\u0000\tñ\u0015Ö\u0007ö\bÿí\u0007\u0002\u0013çð\u0007úÿ-ðþ;Ä\u0001úúÿïü\u00009Éíü\u0000ÿ÷ÿôAéÍü ß÷ÿ#ßé\u000f9ï÷6¹þøA¾ù\u0004\u0001ýúô9Çðù\t3·ÿ\u00037çÆ\u0012óÿ\u0002\u001dÉ\u000büýï\u001aÞ\rúô\u0002ïðþ;Ãôü\u0004÷\u00033Çðþüúý<Çðÿü\u0003þëBáÑ\u000bï\rûò\u0003îÐùÿöý\u0007÷\u0005\u001dÛÿé\nüú÷\u0003\u0018Óðþ;¶þ\rï÷\u0006òû\u0001ùû\u0000\u0005îB¾ù\bþé\u0007öýý\bï\töþï@¾ù\u0004üþï@Öýüþ\u0001ßñ\u000b Íü\u0007ó\u0006ûïJ½ö=Á÷ô\rïú\u000fê\n3Äùó\tÿýê\n3Éï\tñï\u0001\u0007\u0002ìAØé\u0000úë\"éé\u0007ï\r\u001bÙó\tÿýê\n Ï\tñï\u0001\u0007\u0002ì\"Ú\u0007ë\u0005\u0003=üÛÉ\u0000\u000bï\u0000\tñ\u0015Ö\u0007ö\bÿí\u0007\u0002\u0013çð\u0007úÿ$\u0000ÿðü\u00009\u0001åË\róö$ßòû\u000bó\u0005ïJÝÐþù\u000bï\u0001öýðùÿöý\u0007÷\u0005\u001eÍ\t\u0000é\u0007öý".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 666);
        $$d = bArr;
        $$e = 41;
        $$a = new byte[]{98, -94, 86, -118, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13, 9, -18, 36, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, 7, -18, 43, -29, 4, -17, -2, -49, -2, Ascii.VT, 3, -3, 6, -6, 8, -11, Ascii.EM, -33, 19, -2, -8, 37, -44, 17, -12, 8, -14, 9, -18, 34, -25, -4, 17, -19, Ascii.SI, 1, Ascii.DC2, -15, -19, Ascii.VT, -5, 7, 2, -15, 36, -21, -13, Ascii.SI, -2, -9, -6, 34, -15, -19, Ascii.VT, -5, 7, 2, -15, 33, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, -10, Ascii.US, -20, -13, 8, Ascii.VT, Ascii.CR, -27};
        $$b = 3;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        coroutineBoundary = -1331410748201003108L;
        accessartificialFrame = -1151259316;
        CoroutineDebuggingKt = (char) 11596;
    }
}
