package com.google.firebase.messaging;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Bundle;
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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.net.SyslogConstants;
import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.cloudmessaging.Rpc;
import com.google.common.base.Ascii;
import com.google.crypto.tink.prf.HmacPrfKey;
import com.salesforce.marketingcloud.analytics.stats.b;
import io.sentry.android.core.SentryLogcatAdapter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import o.ArtificialStackFrames;
import o.onMessageChannelReady;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.commons.lang3.CharEncoding;
import org.joda.time.LocalDateTime;

/* JADX INFO: loaded from: classes5.dex */
public class FirebaseMessagingService extends EnhancedIntentService {
    private static final byte[] $$d;
    private static final int $$e;
    private static final byte[] $$p;
    private static final int $$q;
    public static final String ACTION_DIRECT_BOOT_REMOTE_INTENT = "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT";
    static final String ACTION_NEW_TOKEN = "com.google.firebase.messaging.NEW_TOKEN";
    static final String ACTION_REMOTE_INTENT = "com.google.android.c2dm.intent.RECEIVE";
    static final String EXTRA_TOKEN = "token";
    private static boolean ICustomTabsServiceDefault = false;
    private static final int RECENTLY_RECEIVED_MESSAGE_IDS_MAX_SIZE = 10;
    private static int artificialFrame;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static final Queue<String> recentlyReceivedMessageIds;
    private static boolean requestPostMessageChannelWithExtras;
    private static char[] validateRelationship;
    private static int warmup;
    private Rpc rpc;
    private static final byte[] $$l = {126, 117, -109, 43};
    private static final int $$o = 158;
    private static int $10 = 0;
    private static int $11 = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0026). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$r(short r5, byte r6, int r7) {
        /*
            int r6 = r6 * 3
            int r6 = 4 - r6
            int r7 = r7 * 3
            int r0 = 1 - r7
            int r5 = r5 + 66
            byte[] r1 = com.google.firebase.messaging.FirebaseMessagingService.$$l
            byte[] r0 = new byte[r0]
            r2 = 0
            int r7 = 0 - r7
            if (r1 != 0) goto L16
            r4 = r7
            r3 = r2
            goto L26
        L16:
            r3 = r2
        L17:
            byte r4 = (byte) r5
            r0[r3] = r4
            if (r3 != r7) goto L22
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            return r5
        L22:
            int r3 = r3 + 1
            r4 = r1[r6]
        L26:
            int r5 = r5 + r4
            int r6 = r6 + 1
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FirebaseMessagingService.$$r(short, byte, int):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0028  */
    /* JADX WARN: Code duplicated, block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0028
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void e(short r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = 99 - r7
            int r6 = r6 + 65
            int r0 = r8 + 8
            byte[] r1 = com.google.firebase.messaging.FirebaseMessagingService.$$d
            byte[] r0 = new byte[r0]
            int r8 = r8 + 7
            r2 = 0
            if (r1 != 0) goto L13
            r6 = r7
            r3 = r8
            r4 = r2
            goto L2a
        L13:
            r3 = r2
            r5 = r7
            r7 = r6
            r6 = r5
        L17:
            byte r4 = (byte) r7
            r0[r3] = r4
            int r6 = r6 + 1
            int r4 = r3 + 1
            if (r3 != r8) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L28:
            r3 = r1[r6]
        L2a:
            int r3 = -r3
            int r7 = r7 + r3
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FirebaseMessagingService.e(short, int, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0024). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void g(byte r5, byte r6, int r7, java.lang.Object[] r8) {
        /*
            int r7 = 790 - r7
            int r0 = r6 + 3
            int r5 = 111 - r5
            byte[] r1 = com.google.firebase.messaging.FirebaseMessagingService.$$p
            byte[] r0 = new byte[r0]
            int r6 = r6 + 2
            r2 = 0
            if (r1 != 0) goto L12
            r3 = r6
            r4 = r2
            goto L24
        L12:
            r3 = r2
        L13:
            byte r4 = (byte) r5
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L22
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            r8[r2] = r5
            return
        L22:
            r3 = r1[r7]
        L24:
            int r5 = r5 + r3
            int r5 = r5 + (-3)
            int r7 = r7 + 1
            r3 = r4
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FirebaseMessagingService.g(byte, byte, int, java.lang.Object[]):void");
    }

    public void onDeletedMessages() {
    }

    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
    }

    public void onMessageSent(@NonNull String str) {
    }

    public void onNewToken(@NonNull String str) {
    }

    public void onSendError(@NonNull String str, @NonNull Exception exc) {
    }

    static {
        byte[] bArr = new byte[828];
        System.arraycopy("Gº6!\u000f\u0001Ä<\u000b\u0003û\büÌ6\u0010ù\u0011\u0000ýþÍB÷\u0016ô\u0010úû\u000eÅ8\u000f\u0000\u0006\u0006¿J\u0002ø\u0006\u0000\u000eøÿ\u0011¾\u00198øö\u000fÿýã/\u0000\u0006\u0006µ\u0003$6ÿô\u0010ÿö\u000eê)ø\t÷\u0000\u0012øýì\u0018\u000fø\u0005\u0000Ò\u0003@ÿ\u0000\u000f\u0003ÿÆþ>\b\tô\u0010ÿö\u000eÅEÿø\u0016õ\f\u0006þÄ6\u0010ù\u0011\u0000ýþÍ\u0019$\u0004\u0002\u0010\u0003ö\u0002ò\u001f÷\u000bý\u0012Ð&\u0000\u0012\u0007ô\u0010\u0007\bû\u0000\bÃ>\b\tô\u0010ÿö\u000eÅ?ý\nÐù\u001fý\nð\u001b\u001fø\u0016õ\f\u0006þß'\u0006ÿü\u000bû\f\tð\u0016ø\t\u0002\b´\u0003$6ÿô\u0010ÿö\u000eê)ø\t÷\u0000\u0012øýá2üç%ø\u0004\næ)\u0002û\u0000\búÐ/\u0006\u0000\t\u0002ø\búâ$\u0000\u0016õ\u0003\u0005\büç,\u000f\u0001Ä<\u000b\u0003û\büÌ6\u0010ù\u0011\u0000ýþÍ<\t\t¾>\b\tô\u0010ÿö\u000eÅB\u0002\u0002\u0001\u000eî\u001aö\rù\t\u0002ô\u0006\u0002\u0014ô\u000fø\u0004ý\u0006\u0016üù\u000bü\u0002ÍO\u0003î\u000f\u0001Ä;þ\u0005\u0005\u0000\u0010\u0003ÿÆ>\u0007÷\t\u0001\u000eü\nø\n\u0000\búÌ8\u000f\u0006öÌ%%\u0000ø\u0014ñ\u0005\u0010ä\u0015\u000f\u0007ó\fø\u0005ä\u001e\u0005\u0014þ\u0006\n®\"/\u0001\u0006ô\u0010þ\t\u0002ÿ\u0001\tÂ\u0002\u001d6ò\næ\u0019\b\u0000Ý6ÿô\f\bù\t\u0002\b\u000f\u0001Ä<\u000b\u0003û\büÌ6\u0012üÈ&'ý\bðò%\u0000\bþÿ\u0000\u000f\u0003ÿÆþ>\b\tô\u0010ÿö\u000eÅLÿ¾'\u0016ÿ\u000eî\u0011\u0000ô\u001f÷\u000bý\u0012³6\u001eú\u000eô\u0010å\u0010\u0015û\u000f\u0001ÄHñ\u000eü\u0011ö\f\u0006ô\u0005ÌB÷\u0014üý\u0012ø\büÿ\f\u0006\tòÍHö\nù\u0013ô\nÆ8\u000f\u0001\u0006\u0002\u0002ú\f\t\u0002¾7\u0006\u0006ü\u0018ö\t\u0006\u0004¾\u0017&\u0006ü\u0018ö\t\u0006Þ\u0017\u0010ö\t\u0001\u0010Ú'\u0006ÿ»Qö\u0005\u0005\r\u0004ô\u0010×,\u0006Ó&\u0006ü\u0018ö\t\u0006\u0004´\u0010ö\u0010ö\u0010\u0005\u0003\u0005\u0011\u0003ñ\u0014\u0005ø\u0000\u0006ý\tû\u000eÝ/ò\u000fû\u000f\u0001Ä;þ\u0005\u0005\u0000\u0010\u0003ÿÆGöÿ\u0005\u0014½J÷\u0007÷\u0010ö\t\u0001\u0010¿.\u0019ûýð$ø\u0004î\"\u0003\u0000»\u0003$6ÿô\u0010ÿö\u000eê)ø\t÷\u0000\u0012øýì\u0018\u000fø\u0005\u0000Ò\u000e½6\u0007\u000eò\r\u000eð\u000e\u0000ûÐK\u0001\u0002¾Hô\nÆ'ÕH\b\tô\u0005\u0001\u0010\u000f\u0006\u0000\t\u0002ø\búá2öÿ\u0016ø\t\u0002\u000f\u0001Ä;þ\u0005\u0005\u0000\u0010\u0003ÿÆ6\u0012\u0003ÿ\u0000\b\u0000\u000b¾\u00162\u0003ß \b\u0000Ü \u0016ðÆ\u0010\u000f\u0001Ä;þ\u0005\u0005\u0000\u0010\u0003ÿÆGöÿ\u0005\u0014½'\u0016ÿ\u0005\u0014Ø(\b\u0004ð\u0010ø\u0005ë\u0017\u0010ö\t\u0001\u0010µ1\u0016ÿ\u0005\u0014Ò/\u0002\tô\u0016ÿØ(þ\u000eß\u0014\u0014ò\u000f\t\u000f\u0001Ä<\u000b\u0003û\büÌB\u0002\u0002\u0001\u000e½8\u000f\u0001\u0003\u0005\u0002ÃHô\n\u0001\b\tô\u0010ÿö\u000eÅO\u0003ú".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 828);
        $$p = bArr;
        $$q = 55;
        $$d = new byte[]{122, -14, -75, -84, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13, 9, -18, 34, -25, -4, 17, -19, Ascii.SI, 1, Ascii.DC2, -15, -19, Ascii.VT, -5, 7, 2, -15, 36, -21, -13, Ascii.SI, -2, -9, -6, 34, -15, -19, Ascii.VT, -5, 7, 9, -18, 36, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, 7, -18, 43, -29, 4, -17, -2, 2, -15, 33, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, -10, Ascii.US, -20, -13, 8, Ascii.VT, Ascii.CR, -27, -49, -2, Ascii.VT, 3, -3, 6, -6, 8, -11, Ascii.EM, -33, 19, -2, -8, 37, -44, 17, -12, 8, -14};
        $$e = 179;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        accessartificialFrame();
        recentlyReceivedMessageIds = new ArrayDeque(10);
    }

    @Override // com.google.firebase.messaging.EnhancedIntentService
    protected Intent getStartCommandIntent(Intent intent) {
        return ServiceStarter.getInstance().getMessagingEvent();
    }

    @Override // com.google.firebase.messaging.EnhancedIntentService
    public void handleIntent(Intent intent) {
        String action = intent.getAction();
        if (ACTION_REMOTE_INTENT.equals(action) || ACTION_DIRECT_BOOT_REMOTE_INTENT.equals(action)) {
            handleMessageIntent(intent);
            return;
        }
        if (ACTION_NEW_TOKEN.equals(action)) {
            onNewToken(intent.getStringExtra("token"));
            return;
        }
        Log.d(Constants.TAG, "Unknown intent action: " + intent.getAction());
    }

    private static void f(char[] cArr, byte[] bArr, int i, int[] iArr, Object[] objArr) throws Throwable {
        int i2 = 2;
        int i3 = 2 % 2;
        onMessageChannelReady onmessagechannelready = new onMessageChannelReady();
        char[] cArr2 = validateRelationship;
        int i4 = 0;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i5 = 0;
            while (i5 < length) {
                int i6 = $10 + 71;
                $11 = i6 % 128;
                int i7 = i6 % i2;
                try {
                    Object[] objArr2 = new Object[1];
                    objArr2[i4] = Integer.valueOf(cArr2[i5]);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(115862995);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) i4;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(26 - KeyEvent.getDeadChar(i4, i4), (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), 1040 - ((byte) KeyEvent.getModifierMetaStateMask()), -1719489573, false, $$r((byte) 55, b, b), new Class[]{Integer.TYPE});
                    }
                    cArr3[i5] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i5++;
                    i2 = 2;
                    i4 = 0;
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
                byte b2 = (byte) 1;
                byte b3 = (byte) (b2 - 1);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(15 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) (20488 - TextUtils.getTrimmedLength("")), ExpandableListView.getPackedPositionGroup(0L) + 2148, 216472770, false, $$r(b2, b3, b3), new Class[]{Integer.TYPE});
            }
            int iIntValue = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
            int i8 = -2083387879;
            if (ICustomTabsServiceDefault) {
                onmessagechannelready.c = bArr.length;
                char[] cArr4 = new char[onmessagechannelready.c];
                onmessagechannelready.a = 0;
                int i9 = $10 + 45;
                $11 = i9 % 128;
                int i10 = i9 % 2;
                while (onmessagechannelready.a < onmessagechannelready.c) {
                    int i11 = $11 + 31;
                    $10 = i11 % 128;
                    if (i11 % 2 != 0) {
                        cArr4[onmessagechannelready.a] = (char) (cArr2[bArr[onmessagechannelready.c - onmessagechannelready.a] / i] / iIntValue);
                        Object[] objArr4 = {onmessagechannelready, onmessagechannelready};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(i8);
                        if (objAccessartificialFrame3 == null) {
                            byte b4 = (byte) 0;
                            byte b5 = b4;
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(20 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 59173), 1943 - Color.blue(0), 481771537, false, $$r(b4, b5, b5), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                    } else {
                        cArr4[onmessagechannelready.a] = (char) (cArr2[bArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] + i] - iIntValue);
                        Object[] objArr5 = {onmessagechannelready, onmessagechannelready};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                        if (objAccessartificialFrame4 == null) {
                            byte b6 = (byte) 0;
                            byte b7 = b6;
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 20, (char) (59175 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), 1943 - (KeyEvent.getMaxKeyCode() >> 16), 481771537, false, $$r(b6, b7, b7), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                    }
                    i8 = -2083387879;
                }
                objArr[0] = new String(cArr4);
                return;
            }
            if (requestPostMessageChannelWithExtras) {
                onmessagechannelready.c = cArr.length;
                char[] cArr5 = new char[onmessagechannelready.c];
                onmessagechannelready.a = 0;
                while (onmessagechannelready.a < onmessagechannelready.c) {
                    cArr5[onmessagechannelready.a] = (char) (cArr2[cArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                    Object[] objArr6 = {onmessagechannelready, onmessagechannelready};
                    Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                    if (objAccessartificialFrame5 == null) {
                        byte b8 = (byte) 0;
                        byte b9 = b8;
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(21 - View.combineMeasuredStates(0, 0), (char) (Color.red(0) + 59174), KeyEvent.getDeadChar(0, 0) + 1943, 481771537, false, $$r(b8, b9, b9), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame5).invoke(null, objArr6);
                }
                objArr[0] = new String(cArr5);
                return;
            }
            int i12 = 0;
            onmessagechannelready.c = iArr.length;
            char[] cArr6 = new char[onmessagechannelready.c];
            while (true) {
                onmessagechannelready.a = i12;
                if (onmessagechannelready.a >= onmessagechannelready.c) {
                    objArr[0] = new String(cArr6);
                    return;
                }
                int i13 = $10 + 1;
                $11 = i13 % 128;
                if (i13 % 2 == 0) {
                    cArr6[onmessagechannelready.a] = (char) (cArr2[iArr[(onmessagechannelready.c % 1) % onmessagechannelready.a] << i] * iIntValue);
                } else {
                    cArr6[onmessagechannelready.a] = (char) (cArr2[iArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                }
                i12 = onmessagechannelready.a + 1;
            }
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 == null) {
                throw th2;
            }
            throw cause2;
        }
    }

    private void handleMessageIntent(Intent intent) {
        if (!alreadyReceivedMessage(intent.getStringExtra(Constants.MessagePayloadKeys.MSGID))) {
            passMessageIntentToSdk(intent);
        }
        getRpc(this).messageHandled(new CloudMessage(intent));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:24:0x0040  */
    private void passMessageIntentToSdk(Intent intent) {
        byte b;
        String stringExtra = intent.getStringExtra("message_type");
        if (stringExtra == null) {
            stringExtra = Constants.MessageTypes.MESSAGE;
        }
        switch (stringExtra) {
            case "deleted_messages":
                b = 0;
                break;
            case "gcm":
                b = 1;
                break;
            case "send_error":
                b = 2;
                break;
            case "send_event":
                b = 3;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            onDeletedMessages();
            return;
        }
        if (b == 1) {
            MessagingAnalytics.logNotificationReceived(intent);
            dispatchMessage(intent);
        } else {
            if (b == 2) {
                onSendError(getMessageId(intent), new SendException(intent.getStringExtra("error")));
                return;
            }
            if (b == 3) {
                onMessageSent(intent.getStringExtra(Constants.MessagePayloadKeys.MSGID));
                return;
            }
            SentryLogcatAdapter.w(Constants.TAG, "Received message with unknown type: " + stringExtra);
        }
    }

    private void dispatchMessage(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.remove("androidx.content.wakelockid");
        if (NotificationParams.isNotification(extras)) {
            NotificationParams notificationParams = new NotificationParams(extras);
            ExecutorService executorServiceNewNetworkIOExecutor = FcmExecutors.newNetworkIOExecutor();
            try {
                if (new DisplayNotification(this, notificationParams, executorServiceNewNetworkIOExecutor).handleNotification()) {
                    executorServiceNewNetworkIOExecutor.shutdown();
                    return;
                } else {
                    executorServiceNewNetworkIOExecutor.shutdown();
                    if (MessagingAnalytics.shouldUploadScionMetrics(intent)) {
                        MessagingAnalytics.logNotificationForeground(intent);
                    }
                }
            } catch (Throwable th) {
                executorServiceNewNetworkIOExecutor.shutdown();
                throw th;
            }
        }
        onMessageReceived(new RemoteMessage(extras));
    }

    private boolean alreadyReceivedMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Queue<String> queue = recentlyReceivedMessageIds;
        if (queue.contains(str)) {
            if (!Log.isLoggable(Constants.TAG, 3)) {
                return true;
            }
            Log.d(Constants.TAG, "Received duplicate message: " + str);
            return true;
        }
        if (queue.size() >= 10) {
            queue.remove();
        }
        queue.add(str);
        return false;
    }

    private String getMessageId(Intent intent) {
        String stringExtra = intent.getStringExtra(Constants.MessagePayloadKeys.MSGID);
        return stringExtra == null ? intent.getStringExtra(Constants.MessagePayloadKeys.MSGID_SERVER) : stringExtra;
    }

    private Rpc getRpc(Context context) {
        if (this.rpc == null) {
            this.rpc = new Rpc(context.getApplicationContext());
        }
        return this.rpc;
    }

    static void resetForTesting() {
        recentlyReceivedMessageIds.clear();
    }

    void setRpcForTesting(Rpc rpc) {
        this.rpc = rpc;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0185  */
    /* JADX WARN: Code duplicated, block: B:16:0x020c A[Catch: all -> 0x0954, TryCatch #2 {all -> 0x0954, blocks: (B:51:0x067e, B:53:0x0692, B:54:0x06c1, B:14:0x01ec, B:16:0x020c, B:17:0x0255), top: B:95:0x01ec }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0267  */
    /* JADX WARN: Code duplicated, block: B:25:0x0315  */
    /* JADX WARN: Code duplicated, block: B:50:0x0619  */
    /* JADX WARN: Code duplicated, block: B:53:0x0692 A[Catch: all -> 0x0954, TryCatch #2 {all -> 0x0954, blocks: (B:51:0x067e, B:53:0x0692, B:54:0x06c1, B:14:0x01ec, B:16:0x020c, B:17:0x0255), top: B:95:0x01ec }] */
    /* JADX WARN: Code duplicated, block: B:57:0x06d7  */
    /* JADX WARN: Code duplicated, block: B:62:0x0792  */
    @Override // com.google.firebase.messaging.EnhancedIntentService, android.app.Service, android.content.ContextWrapper
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
            int mirror = AndroidCharacter.getMirror('0') - 23;
            char jumpTapTimeout = (char) (30068 - (ViewConfiguration.getJumpTapTimeout() >> 16));
            int i2 = 816 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
            Object[] objArr2 = new Object[1];
            e((byte) 47, (byte) 96, $$d[5], objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(mirror, jumpTapTimeout, i2, 721586079, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 1884;
            Object[] objArr3 = new Object[1];
            f(null, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 127, null, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            f(null, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 92, null, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i3 = artificialFrame + 105;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i3 % 128;
                int i4 = i3 % 2;
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame8 == null) {
                    int iLastIndexOf = TextUtils.lastIndexOf("", '0') + 26;
                    char packedPositionChild = (char) (ExpandableListView.getPackedPositionChild(0L) + 30069);
                    int iAlpha = Color.alpha(0) + 816;
                    Object[] objArr5 = new Object[1];
                    e((byte) 47, (byte) 88, $$d[5], objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, packedPositionChild, iAlpha, 891606461, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i5 = ((int[]) objArr6[0])[0];
                int i6 = ((int[]) objArr6[1])[0];
                String[] strArr = (String[]) objArr6[2];
                int i7 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().navigation;
                int i8 = ((1975201960 + (((-184811594) | i7) * (-381))) + (((~((~i7) | 11235202)) | (-193921226)) * 381)) - 399409905;
                int i9 = (i8 << 13) ^ i8;
                int i10 = i9 ^ (i9 >>> 17);
                ((int[]) objArr[3])[0] = i10 ^ (i10 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                f(null, new byte[]{-115, -116, -117, -120, -118, -119, -121, -106, -126, -127, -113, -121, -127, -107, -127, -108}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + b.l, null, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                f(null, new byte[]{-116, -125, -123, -114, -104, -120, -127, -105, -118, -117, -122, -117, -126, -116, -125, -122}, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + WebSocketProtocol.PAYLOAD_SHORT, null, objArr8);
                try {
                    Object[] objArr9 = {Integer.valueOf(((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue()), 0, -2093150102};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame == null) {
                        int absoluteGravity = Gravity.getAbsoluteGravity(0, 0) + 25;
                        char cAxisFromString = (char) (30067 - MotionEvent.axisFromString(""));
                        int jumpTapTimeout2 = (ViewConfiguration.getJumpTapTimeout() >> 16) + 816;
                        byte[] bArr = $$d;
                        Object[] objArr10 = new Object[1];
                        e(bArr[65], (byte) 80, bArr[77], objArr10);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(absoluteGravity, cAxisFromString, jumpTapTimeout2, -797394565, false, (String) objArr10[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr9);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame2 == null) {
                        int i11 = 26 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                        char c = (char) (30068 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)));
                        int scrollBarFadeDuration = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 816;
                        Object[] objArr11 = new Object[1];
                        e((byte) 47, (byte) 88, $$d[5], objArr11);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i11, c, scrollBarFadeDuration, 891606461, false, (String) objArr11[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArr);
                    try {
                        Object[] objArr12 = new Object[1];
                        f(null, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + WebSocketProtocol.PAYLOAD_SHORT, null, objArr12);
                        Class<?> cls3 = Class.forName((String) objArr12[0]);
                        Object[] objArr13 = new Object[1];
                        f(null, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 92, null, objArr13);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr13[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame3 == null) {
                            int iLastIndexOf2 = TextUtils.lastIndexOf("", '0', 0, 0) + 26;
                            char jumpTapTimeout3 = (char) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 30068);
                            int iLastIndexOf3 = TextUtils.lastIndexOf("", '0', 0, 0) + 817;
                            Object[] objArr14 = new Object[1];
                            e((byte) 47, (byte) 96, $$d[5], objArr14);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iLastIndexOf2, jumpTapTimeout3, iLastIndexOf3, 721586079, false, (String) objArr14[0], null);
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
            f(null, new byte[]{-115, -116, -117, -120, -118, -119, -121, -106, -126, -127, -113, -121, -127, -107, -127, -108}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + b.l, null, objArr15);
            Class<?> cls4 = Class.forName((String) objArr15[0]);
            Object[] objArr16 = new Object[1];
            f(null, new byte[]{-116, -125, -123, -114, -104, -120, -127, -105, -118, -117, -122, -117, -126, -116, -125, -122}, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + WebSocketProtocol.PAYLOAD_SHORT, null, objArr16);
            Object[] objArr17 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue()), 0, -2093150102};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame == null) {
                int absoluteGravity2 = Gravity.getAbsoluteGravity(0, 0) + 25;
                char cAxisFromString2 = (char) (30067 - MotionEvent.axisFromString(""));
                int jumpTapTimeout4 = (ViewConfiguration.getJumpTapTimeout() >> 16) + 816;
                byte[] bArr2 = $$d;
                Object[] objArr18 = new Object[1];
                e(bArr2[65], (byte) 80, bArr2[77], objArr18);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(absoluteGravity2, cAxisFromString2, jumpTapTimeout4, -797394565, false, (String) objArr18[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr17);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame2 == null) {
                int i12 = 26 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                char c2 = (char) (30068 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)));
                int scrollBarFadeDuration2 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 816;
                Object[] objArr19 = new Object[1];
                e((byte) 47, (byte) 88, $$d[5], objArr19);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i12, c2, scrollBarFadeDuration2, 891606461, false, (String) objArr19[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArr);
            Object[] objArr110 = new Object[1];
            f(null, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + WebSocketProtocol.PAYLOAD_SHORT, null, objArr110);
            Class<?> cls5 = Class.forName((String) objArr110[0]);
            Object[] objArr111 = new Object[1];
            f(null, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 92, null, objArr111);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr111[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame3 == null) {
                int iLastIndexOf4 = TextUtils.lastIndexOf("", '0', 0, 0) + 26;
                char jumpTapTimeout5 = (char) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 30068);
                int iLastIndexOf5 = TextUtils.lastIndexOf("", '0', 0, 0) + 817;
                Object[] objArr112 = new Object[1];
                e((byte) 47, (byte) 96, $$d[5], objArr112);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iLastIndexOf4, jumpTapTimeout5, iLastIndexOf5, 721586079, false, (String) objArr112[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i13 = ((int[]) objArr[1])[0];
        int i14 = ((int[]) objArr[0])[0];
        if (i14 == i13) {
            Object[] objArr20 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i15 = ((int[]) objArr[3])[0];
            int i16 = ((int[]) objArr[0])[0];
            int i17 = ((int[]) objArr[1])[0];
            String[] strArr2 = (String[]) objArr[2];
            int iIdentityHashCode = System.identityHashCode(this);
            int i18 = i15 + (((244139326 + (((~((-68157441) | iIdentityHashCode)) | (~(130014925 | iIdentityHashCode))) * 69)) + (((~(iIdentityHashCode | 129876040)) | ((~((-68296326) | iIdentityHashCode)) | 138885)) * (-69))) - 36383896);
            int i19 = (i18 << 13) ^ i18;
            int i20 = i19 ^ (i19 >>> 17);
            ((int[]) objArr20[3])[0] = i20 ^ (i20 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr[2];
            if (strArr3 != null) {
                for (String str : strArr3) {
                    arrayList.add(str);
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf((((long) 1674231265) << 32) ^ ((long) (i13 ^ i14))), Long.valueOf(1674231264)};
                byte[] bArr3 = $$p;
                Object[] objArr22 = new Object[1];
                g(bArr3[108], bArr3[302], (short) 786, objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                byte b = bArr3[662];
                byte b2 = bArr3[18];
                Object[] objArr23 = new Object[1];
                g(b, b2, (short) (b2 | 705), objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i21 = ((int[]) objArr[3])[0];
                int i22 = ((int[]) objArr[0])[0];
                int i23 = ((int[]) objArr[1])[0];
                String[] strArr4 = (String[]) objArr[2];
                int startUptimeMillis = (int) Process.getStartUptimeMillis();
                int i24 = ~startUptimeMillis;
                int i25 = i21 + (-720468400) + (((~(353848950 | i24)) | 552021316) * 226) + (((~(i24 | 905408374)) | (~((-552021317) | startUptimeMillis)) | 461892) * (-113)) + ((~(startUptimeMillis | 353848950)) * 113);
                int i26 = (i25 << 13) ^ i25;
                int i27 = i26 ^ (i26 >>> 17);
                ((int[]) objArr24[3])[0] = i27 ^ (i27 << 5);
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
            int i28 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 26;
            char c3 = (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
            int defaultSize = 1041 - View.getDefaultSize(0, 0);
            Object[] objArr25 = new Object[1];
            e((byte) 47, (byte) 96, $$d[5], objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(i28, c3, defaultSize, 2061780482, false, (String) objArr25[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j3 != -1) {
            long j4 = j3 + 4611686018427387931L;
            Object[] objArr26 = new Object[1];
            f(null, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, 127 - (ViewConfiguration.getDoubleTapTimeout() >> 16), null, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            f(null, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) + 78, null, objArr27);
            if (j4 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame10 == null) {
                    int i29 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 26;
                    char offsetBefore = (char) TextUtils.getOffsetBefore("", 0);
                    int i30 = 1040 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                    Object[] objArr28 = new Object[1];
                    e((byte) 47, (byte) 88, $$d[5], objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(i29, offsetBefore, i30, 1145017376, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i31 = ((int[]) objArr29[3])[0];
                int i32 = ((int[]) objArr29[2])[0];
                String[] strArr5 = (String[]) objArr29[0];
                int iIdentityHashCode2 = System.identityHashCode(this);
                int i33 = ((((~(iIdentityHashCode2 | (-156419213))) * TypedValues.CycleType.TYPE_EASING) + 355370594) + (((~((~iIdentityHashCode2) | (-156419213))) | 78121219) * TypedValues.CycleType.TYPE_EASING)) - 803560704;
                int i34 = (i33 << 13) ^ i33;
                int i35 = i34 ^ (i34 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i35 ^ (i35 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                f(null, new byte[]{-115, -116, -117, -120, -118, -119, -121, -106, -126, -127, -113, -121, -127, -107, -127, -108}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 92, null, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                f(null, new byte[]{-116, -125, -123, -114, -104, -120, -127, -105, -118, -117, -122, -117, -126, -116, -125, -122}, ImageFormat.getBitsPerPixel(0) + 128, null, objArr31);
                int iIntValue = ((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue();
                Object[] objArr32 = {1548911309};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 8, (char) ((-16754965) - Color.rgb(0, 0, 0)), 1032 - TextUtils.lastIndexOf("", '0', 0), 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = HmacPrfKey.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr32), -803560704, false);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame5 == null) {
                    int packedPositionChild2 = 25 - ExpandableListView.getPackedPositionChild(0L);
                    char cIndexOf = (char) (TextUtils.indexOf((CharSequence) "", '0') + 1);
                    int maximumFlingVelocity = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 1041;
                    Object[] objArr33 = new Object[1];
                    e((byte) 47, (byte) 88, $$d[5], objArr33);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(packedPositionChild2, cIndexOf, maximumFlingVelocity, 1145017376, false, (String) objArr33[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Object[] objArr34 = new Object[1];
                    f(null, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) + 78, null, objArr34);
                    Class<?> cls9 = Class.forName((String) objArr34[0]);
                    Object[] objArr35 = new Object[1];
                    f(null, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, 126 - ExpandableListView.getPackedPositionChild(0L), null, objArr35);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr35[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame6 == null) {
                        int iResolveSizeAndState = 26 - View.resolveSizeAndState(0, 0, 0);
                        char cBlue = (char) Color.blue(0);
                        int i36 = 1042 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                        Object[] objArr36 = new Object[1];
                        e((byte) 47, (byte) 96, $$d[5], objArr36);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState, cBlue, i36, 2061780482, false, (String) objArr36[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr37 = new Object[1];
            f(null, new byte[]{-115, -116, -117, -120, -118, -119, -121, -106, -126, -127, -113, -121, -127, -107, -127, -108}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 92, null, objArr37);
            Class<?> cls10 = Class.forName((String) objArr37[0]);
            Object[] objArr38 = new Object[1];
            f(null, new byte[]{-116, -125, -123, -114, -104, -120, -127, -105, -118, -117, -122, -117, -126, -116, -125, -122}, ImageFormat.getBitsPerPixel(0) + 128, null, objArr38);
            int iIntValue2 = ((Integer) cls10.getMethod((String) objArr38[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr39 = {1548911309};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 8, (char) ((-16754965) - Color.rgb(0, 0, 0)), 1032 - TextUtils.lastIndexOf("", '0', 0), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = HmacPrfKey.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr39), -803560704, false);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame5 == null) {
                int packedPositionChild3 = 25 - ExpandableListView.getPackedPositionChild(0L);
                char cIndexOf2 = (char) (TextUtils.indexOf((CharSequence) "", '0') + 1);
                int maximumFlingVelocity2 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 1041;
                Object[] objArr310 = new Object[1];
                e((byte) 47, (byte) 88, $$d[5], objArr310);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(packedPositionChild3, cIndexOf2, maximumFlingVelocity2, 1145017376, false, (String) objArr310[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr311 = new Object[1];
            f(null, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) + 78, null, objArr311);
            Class<?> cls11 = Class.forName((String) objArr311[0]);
            Object[] objArr312 = new Object[1];
            f(null, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, 126 - ExpandableListView.getPackedPositionChild(0L), null, objArr312);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr312[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame6 == null) {
                int iResolveSizeAndState2 = 26 - View.resolveSizeAndState(0, 0, 0);
                char cBlue2 = (char) Color.blue(0);
                int i37 = 1042 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                Object[] objArr313 = new Object[1];
                e((byte) 47, (byte) 96, $$d[5], objArr313);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState2, cBlue2, i37, 2061780482, false, (String) objArr313[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i38 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i39 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i39 == i38) {
            int i40 = artificialFrame + 33;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i40 % 128;
            int i41 = i40 % 2;
            Object[] objArr40 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i42 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i43 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i44 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr6 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int i45 = ~System.identityHashCode(this);
            int i46 = i42 + (-1408094610) + (((~(i45 | 750673371)) | (~((-538312923) | i45))) * (-184)) + ((145232128 | (~((-683545051) | i45)) | (~(605441243 | i45))) * SyslogConstants.LOG_LOCAL7) + 533290640;
            int i47 = (i46 << 13) ^ i46;
            int i48 = i47 ^ (i47 >>> 17);
            ((int[]) objArr40[1])[0] = i48 ^ (i48 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        if (strArr7 != null) {
            for (String str2 : strArr7) {
                int i49 = artificialFrame + 51;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i49 % 128;
                int i50 = i49 % 2;
                arrayList2.add(str2);
            }
        }
        long j5 = ((long) (i38 ^ i39)) ^ (((long) 1116119527) << 32);
        long j6 = 1116119525;
        int i51 = artificialFrame + 27;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i51 % 128;
        int i52 = i51 % 2;
        Object[] objArr41 = {Long.valueOf(j5), Long.valueOf(j6)};
        byte[] bArr4 = $$p;
        byte b3 = bArr4[18];
        byte b4 = (byte) (-bArr4[13]);
        Object[] objArr42 = new Object[1];
        g(b3, b4, (short) (b4 | 651), objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        byte b5 = bArr4[662];
        byte b6 = bArr4[18];
        Object[] objArr43 = new Object[1];
        g(b5, b6, (short) (b6 | 705), objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {strArr, new int[1], new int[]{i}, new int[]{i}};
        int i53 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
        int i54 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        int i55 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        String[] strArr8 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        int iIdentityHashCode3 = System.identityHashCode(this);
        int i56 = i53 + (-968144468) + (((~((~iIdentityHashCode3) | (-87553907))) | (-9450100)) * (-235)) + (((~((-87553907) | iIdentityHashCode3)) | (-9450100)) * (-470)) + (((~(iIdentityHashCode3 | (-1061491))) | (-95942516)) * 235);
        int i57 = (i56 << 13) ^ i56;
        int i58 = i57 ^ (i57 >>> 17);
        ((int[]) objArr44[1])[0] = i58 ^ (i58 << 5);
    }

    /* JADX WARN: Code duplicated, block: B:199:0x1447  */
    /* JADX WARN: Code duplicated, block: B:25:0x0279  */
    /* JADX WARN: Code duplicated, block: B:262:0x1c45  */
    /* JADX WARN: Code duplicated, block: B:265:0x1c4e A[Catch: all -> 0x2471, TryCatch #2 {all -> 0x2471, blocks: (B:263:0x1c48, B:265:0x1c4e, B:266:0x1c7e, B:268:0x1ca9, B:269:0x1d38, B:153:0x0fc8, B:155:0x0fdd, B:156:0x1010, B:70:0x0757, B:72:0x0779, B:73:0x07d0, B:46:0x0461, B:48:0x046e, B:49:0x04a2, B:51:0x04ac, B:53:0x04b9, B:54:0x04e8), top: B:366:0x0461 }] */
    /* JADX WARN: Code duplicated, block: B:268:0x1ca9 A[Catch: all -> 0x2471, TryCatch #2 {all -> 0x2471, blocks: (B:263:0x1c48, B:265:0x1c4e, B:266:0x1c7e, B:268:0x1ca9, B:269:0x1d38, B:153:0x0fc8, B:155:0x0fdd, B:156:0x1010, B:70:0x0757, B:72:0x0779, B:73:0x07d0, B:46:0x0461, B:48:0x046e, B:49:0x04a2, B:51:0x04ac, B:53:0x04b9, B:54:0x04e8), top: B:366:0x0461 }] */
    /* JADX WARN: Code duplicated, block: B:272:0x1d4b  */
    /* JADX WARN: Code duplicated, block: B:277:0x1db1  */
    /* JADX WARN: Code duplicated, block: B:28:0x0283  */
    /* JADX WARN: Code duplicated, block: B:69:0x0739  */
    /* JADX WARN: Code duplicated, block: B:72:0x0779 A[Catch: all -> 0x2471, TryCatch #2 {all -> 0x2471, blocks: (B:263:0x1c48, B:265:0x1c4e, B:266:0x1c7e, B:268:0x1ca9, B:269:0x1d38, B:153:0x0fc8, B:155:0x0fdd, B:156:0x1010, B:70:0x0757, B:72:0x0779, B:73:0x07d0, B:46:0x0461, B:48:0x046e, B:49:0x04a2, B:51:0x04ac, B:53:0x04b9, B:54:0x04e8), top: B:366:0x0461 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x07e3  */
    /* JADX WARN: Code duplicated, block: B:81:0x084c  */
    @Override // com.google.firebase.messaging.EnhancedIntentService, android.app.Service
    public void onCreate() throws Throwable {
        Object[] objArr;
        Object objAccessartificialFrame;
        Object[] objArr2;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        int i;
        Object[] objArr3;
        int i2;
        Object[] objArrAccessartificialFrame$78cbbd35;
        int i3;
        Object[] objArr4;
        Object[] objArr5;
        int i4;
        Object objAccessartificialFrame4;
        Object objAccessartificialFrame5;
        Object[] objArr6;
        Object objAccessartificialFrame6;
        Object objAccessartificialFrame7;
        int i5;
        Object[] objArr7;
        int i6 = 2 % 2;
        Object[] objArr8 = new Object[1];
        f(null, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 92, null, objArr8);
        String str = (String) objArr8[0];
        Object[] objArr9 = new Object[1];
        f(null, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 92, null, objArr9);
        String str2 = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        f(null, new byte[]{-115, -116, -117, -120, -118, -119, -121, -106, -126, -127, -113, -121, -127, -107, -127, -108}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) + 78, null, objArr10);
        String str3 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        f(null, new byte[]{-116, -125, -123, -114, -104, -120, -127, -105, -118, -117, -122, -117, -126, -116, -125, -122}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 91, null, objArr11);
        String str4 = (String) objArr11[0];
        Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame8 == null) {
            int i7 = 18 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
            char touchSlop = (char) (ViewConfiguration.getTouchSlop() >> 8);
            int iAlpha = Color.alpha(0) + 747;
            Object[] objArr12 = new Object[1];
            e((byte) 47, (byte) 96, $$d[5], objArr12);
            objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i7, touchSlop, iAlpha, -144068856, false, (String) objArr12[0], null);
        }
        long j = ((Field) objAccessartificialFrame8).getLong(null);
        if (j == -1 || j + 4611686018427387759L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr13 = new Object[1];
                f(null, new byte[]{-125, -127, -116, -124, -104, -102, -118, -117, -122, -107, -122, -117, -112, -103, -121, -110, -110, -127, -121, -125, -122, -123, -124, -125, -126, -127}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 92, null, objArr13);
                Class<?> cls = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                f(null, new byte[]{-126, -123, -122, -117, -127, -112, -122, -113, -110, -110, -103, -117, -126, -116, -124, -124, -101, -112}, 127 - (ViewConfiguration.getTapTimeout() >> 16), null, objArr14);
                baseContext = (Context) cls.getMethod((String) objArr14[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                int i8 = artificialFrame + 119;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i8 % 128;
                if (i8 % 2 != 0) {
                    int i9 = 69 / 0;
                    if (baseContext instanceof ContextWrapper) {
                        if (((ContextWrapper) baseContext).getBaseContext() != null) {
                            baseContext = null;
                        }
                    }
                } else if (baseContext instanceof ContextWrapper) {
                    if (((ContextWrapper) baseContext).getBaseContext() != null) {
                        baseContext = null;
                    }
                }
                baseContext = baseContext.getApplicationContext();
            }
            try {
                Object[] objArr15 = {baseContext, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -1492318965};
                byte[] bArr = $$p;
                Object[] objArr16 = new Object[1];
                g(bArr[122], (byte) (bArr[537] - 1), (short) 649, objArr16);
                Class<?> cls2 = Class.forName((String) objArr16[0]);
                byte b = bArr[241];
                byte b2 = bArr[17];
                Object[] objArr17 = new Object[1];
                g(b, b2, (short) (b2 | 550), objArr17);
                Object[] objArr18 = (Object[]) cls2.getMethod((String) objArr17[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr15);
                Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(1575402270);
                if (objAccessartificialFrame9 == null) {
                    int iGreen = 17 - Color.green(0);
                    char cBlue = (char) Color.blue(0);
                    int iLastIndexOf = 746 - TextUtils.lastIndexOf("", '0', 0);
                    Object[] objArr19 = new Object[1];
                    e((byte) 47, (byte) 88, $$d[5], objArr19);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(iGreen, cBlue, iLastIndexOf, -1031537386, false, (String) objArr19[0], null);
                }
                ((Field) objAccessartificialFrame9).set(null, objArr18);
                try {
                    Long lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(1745676544);
                    if (objAccessartificialFrame10 == null) {
                        int i10 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 16;
                        char packedPositionGroup = (char) ExpandableListView.getPackedPositionGroup(0L);
                        int threadPriority = 747 - ((Process.getThreadPriority(0) + 20) >> 6);
                        Object[] objArr20 = new Object[1];
                        e((byte) 47, (byte) 96, $$d[5], objArr20);
                        objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(i10, packedPositionGroup, threadPriority, -144068856, false, (String) objArr20[0], null);
                    }
                    ((Field) objAccessartificialFrame10).set(null, lValueOf);
                    objArr = objArr18;
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
            Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame11 == null) {
                int iAlpha2 = 17 - Color.alpha(0);
                char c = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                int i11 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 746;
                Object[] objArr21 = new Object[1];
                e((byte) 47, (byte) 88, $$d[5], objArr21);
                objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(iAlpha2, c, i11, -1031537386, false, (String) objArr21[0], null);
            }
            Object[] objArr22 = (Object[]) ((Field) objAccessartificialFrame11).get(null);
            objArr = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
            int i12 = ((int[]) objArr22[3])[0];
            int i13 = ((int[]) objArr22[4])[0];
            List list = (List) objArr22[0];
            List list2 = (List) objArr22[2];
            int iIdentityHashCode = System.identityHashCode(this);
            int i14 = (((((~(350313952 | iIdentityHashCode)) | (-739678987)) * 398) - 412986447) + (((~((~iIdentityHashCode) | 350313952)) | (-739678987)) * 398)) - 1492318965;
            int i15 = (i14 << 13) ^ i14;
            int i16 = i15 ^ (i15 >>> 17);
            ((int[]) objArr[1])[0] = i16 ^ (i16 << 5);
        }
        int i17 = ((int[]) objArr[4])[0];
        int i18 = ((int[]) objArr[3])[0];
        if (i18 == i17) {
            Object[] objArr23 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i19 = ((int[]) objArr[1])[0];
            int i20 = ((int[]) objArr[3])[0];
            int i21 = ((int[]) objArr[4])[0];
            List list3 = (List) objArr[0];
            List list4 = (List) objArr[2];
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i22 = (-1397823857) + ((iIdentityHashCode2 | 669238562) * (-50));
            int i23 = ~((-606241059) | iIdentityHashCode2);
            int i24 = ~iIdentityHashCode2;
            int i25 = i19 + i22 + (((~(i24 | 670031162)) | i23) * 50) + (((~(63790104 | i24)) | (-670031163) | (~(i24 | 669238562))) * 50);
            int i26 = (i25 << 13) ^ i25;
            int i27 = i26 ^ (i26 >>> 17);
            ((int[]) objArr23[1])[0] = i27 ^ (i27 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            try {
                Object[] objArr24 = {objArr};
                Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(1804664566);
                if (objAccessartificialFrame12 == null) {
                    objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(40 - TextUtils.lastIndexOf("", '0'), (char) (12468 - (ViewConfiguration.getMaximumFlingVelocity() >> 16)), 3642 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                }
                arrayList.add(((Method) objAccessartificialFrame12).invoke(null, objArr24));
                Object[] objArr25 = {objArr};
                Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                if (objAccessartificialFrame13 == null) {
                    objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(40 - Process.getGidForName(""), (char) (View.getDefaultSize(0, 0) + 12468), TextUtils.lastIndexOf("", '0', 0) + 3643, 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                }
                arrayList.add(((Method) objAccessartificialFrame13).invoke(null, objArr25));
                try {
                    Object[] objArr26 = {Long.valueOf((((long) 1077114907) << 32) ^ ((long) (i17 ^ i18))), Long.valueOf(1077114899)};
                    byte[] bArr2 = $$p;
                    Object[] objArr27 = new Object[1];
                    g(bArr2[108], (byte) (-bArr2[146]), (short) 548, objArr27);
                    Class<?> cls3 = Class.forName((String) objArr27[0]);
                    byte b3 = bArr2[662];
                    byte b4 = bArr2[18];
                    Object[] objArr28 = new Object[1];
                    g(b3, b4, (short) (b4 | 705), objArr28);
                    cls3.getMethod((String) objArr28[0], Long.TYPE, Long.TYPE).invoke(null, objArr26);
                    Object[] objArr29 = {list, new int[1], list, new int[]{i}, new int[]{i}};
                    int i28 = ((int[]) objArr[1])[0];
                    int i29 = ((int[]) objArr[3])[0];
                    int i30 = ((int[]) objArr[4])[0];
                    List list5 = (List) objArr[0];
                    List list6 = (List) objArr[2];
                    int i31 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().widthPixels;
                    int i32 = i28 + (-1099871879) + (((~((-673350161) | (~i31))) | (~((-67901703) | i31))) * (-272)) + (((~((-962782929) | i31)) | 289432768) * (-272)) + (((~(i31 | 962782928)) | (-357334471)) * 272);
                    int i33 = (i32 << 13) ^ i32;
                    int i34 = i33 ^ (i33 >>> 17);
                    ((int[]) objArr29[1])[0] = i34 ^ (i34 << 5);
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        }
        Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame14 == null) {
            int iMyTid = (Process.myTid() >> 22) + 25;
            char cLastIndexOf = (char) (30067 - TextUtils.lastIndexOf("", '0'));
            int iAxisFromString = MotionEvent.axisFromString("") + 817;
            Object[] objArr30 = new Object[1];
            e((byte) 47, (byte) 96, $$d[5], objArr30);
            objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(iMyTid, cLastIndexOf, iAxisFromString, 721586079, false, (String) objArr30[0], null);
        }
        long j2 = ((Field) objAccessartificialFrame14).getLong(null);
        if (j2 != -1) {
            int i35 = getARTIFICIAL_FRAME_PACKAGE_NAME + 37;
            artificialFrame = i35 % 128;
            int i36 = i35 % 2;
            if (j2 + 2020 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame15 == null) {
                    int iIndexOf = TextUtils.indexOf("", "", 0) + 25;
                    char defaultSize = (char) (30068 - View.getDefaultSize(0, 0));
                    int mode = 816 - View.MeasureSpec.getMode(0);
                    Object[] objArr31 = new Object[1];
                    e((byte) 47, (byte) 88, $$d[5], objArr31);
                    objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(iIndexOf, defaultSize, mode, 891606461, false, (String) objArr31[0], null);
                }
                Object[] objArr32 = (Object[]) ((Field) objAccessartificialFrame15).get(null);
                objArr2 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i37 = ((int[]) objArr32[0])[0];
                int i38 = ((int[]) objArr32[1])[0];
                String[] strArr = (String[]) objArr32[2];
                int i39 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().mnc;
                int i40 = (((1717597967 + (((~((-68157703) | i39)) | (~((~i39) | 130014663))) * (-318))) + (((~(110203335 | i39)) | 19811328) * (-318))) + (((~(i39 | (-110203336))) | (-87969031)) * TypedValues.AttributesType.TYPE_PIVOT_TARGET)) - 1391347770;
                int i41 = (i40 << 13) ^ i40;
                int i42 = i41 ^ (i41 >>> 17);
                ((int[]) objArr2[3])[0] = i42 ^ (i42 << 5);
            } else {
                Object[] objArr33 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -1391347770};
                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame == null) {
                    int longPressTimeout = 25 - (ViewConfiguration.getLongPressTimeout() >> 16);
                    char c2 = (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 30069);
                    int i43 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 816;
                    byte[] bArr3 = $$d;
                    Object[] objArr34 = new Object[1];
                    e(bArr3[65], (byte) 80, bArr3[77], objArr34);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(longPressTimeout, c2, i43, -797394565, false, (String) objArr34[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr2 = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr33);
                objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame2 == null) {
                    int scrollBarFadeDuration = 25 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    char mode2 = (char) (30068 - View.MeasureSpec.getMode(0));
                    int maxKeyCode = (KeyEvent.getMaxKeyCode() >> 16) + 816;
                    Object[] objArr35 = new Object[1];
                    e((byte) 47, (byte) 88, $$d[5], objArr35);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration, mode2, maxKeyCode, 891606461, false, (String) objArr35[0], null);
                }
                ((Field) objAccessartificialFrame2).set(null, objArr2);
                try {
                    Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame3 == null) {
                        int i44 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 24;
                        char c3 = (char) (30068 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)));
                        int iKeyCodeFromString = 816 - KeyEvent.keyCodeFromString("");
                        Object[] objArr36 = new Object[1];
                        e((byte) 47, (byte) 96, $$d[5], objArr36);
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i44, c3, iKeyCodeFromString, 721586079, false, (String) objArr36[0], null);
                    }
                    ((Field) objAccessartificialFrame3).set(null, lValueOf2);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr37 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -1391347770};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame == null) {
                int longPressTimeout2 = 25 - (ViewConfiguration.getLongPressTimeout() >> 16);
                char c4 = (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 30069);
                int i45 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 816;
                byte[] bArr4 = $$d;
                Object[] objArr38 = new Object[1];
                e(bArr4[65], (byte) 80, bArr4[77], objArr38);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(longPressTimeout2, c4, i45, -797394565, false, (String) objArr38[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr2 = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr37);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame2 == null) {
                int scrollBarFadeDuration2 = 25 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                char mode3 = (char) (30068 - View.MeasureSpec.getMode(0));
                int maxKeyCode2 = (KeyEvent.getMaxKeyCode() >> 16) + 816;
                Object[] objArr39 = new Object[1];
                e((byte) 47, (byte) 88, $$d[5], objArr39);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration2, mode3, maxKeyCode2, 891606461, false, (String) objArr39[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArr2);
            Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame3 == null) {
                int i46 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 24;
                char c5 = (char) (30068 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)));
                int iKeyCodeFromString2 = 816 - KeyEvent.keyCodeFromString("");
                Object[] objArr310 = new Object[1];
                e((byte) 47, (byte) 96, $$d[5], objArr310);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i46, c5, iKeyCodeFromString2, 721586079, false, (String) objArr310[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf3);
        }
        int i47 = ((int[]) objArr2[1])[0];
        int i48 = ((int[]) objArr2[0])[0];
        if (i48 == i47) {
            Object[] objArr40 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i49 = ((int[]) objArr2[3])[0];
            int i50 = ((int[]) objArr2[0])[0];
            int i51 = ((int[]) objArr2[1])[0];
            String[] strArr2 = (String[]) objArr2[2];
            int i52 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenLayout;
            int i53 = ~i52;
            int i54 = i49 + ((((~(i53 | (-853225927))) | ((~((-1051398293) | i53)) | 847974532)) * (-397)) - 1218696904) + ((i52 | (-208675155)) * 397);
            int i55 = (i54 << 13) ^ i54;
            int i56 = i55 ^ (i55 >>> 17);
            i = 0;
            ((int[]) objArr40[3])[0] = i56 ^ (i56 << 5);
        } else {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr3 = (String[]) objArr2[2];
            if (strArr3 != null) {
                int i57 = getARTIFICIAL_FRAME_PACKAGE_NAME + 69;
                artificialFrame = i57 % 128;
                for (int i58 = i57 % 2 == 0 ? 1 : 0; i58 < strArr3.length; i58++) {
                    arrayList2.add(strArr3[i58]);
                }
            }
            Object[] objArr41 = {Long.valueOf((((long) (-1617220738)) << 32) ^ ((long) (i47 ^ i48))), Long.valueOf(-1617220737)};
            byte[] bArr5 = $$p;
            Object[] objArr42 = new Object[1];
            g(bArr5[108], bArr5[94], (short) 485, objArr42);
            Class<?> cls4 = Class.forName((String) objArr42[0]);
            byte b5 = bArr5[662];
            byte b6 = bArr5[18];
            Object[] objArr43 = new Object[1];
            g(b5, b6, (short) (b6 | 705), objArr43);
            cls4.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
            Object[] objArr44 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i59 = ((int[]) objArr2[3])[0];
            int i60 = ((int[]) objArr2[0])[0];
            int i61 = ((int[]) objArr2[1])[0];
            String[] strArr4 = (String[]) objArr2[2];
            int iIdentityHashCode3 = System.identityHashCode(this);
            int i62 = i59 + 1148797787 + (((~((-459914080) | iIdentityHashCode3)) | 53058061) * (-140)) + ((~((-406856019) | iIdentityHashCode3)) * 70) + (((~(iIdentityHashCode3 | 658086445)) | (-1011884403)) * 70);
            int i63 = (i62 << 13) ^ i62;
            int i64 = i63 ^ (i63 >>> 17);
            i = 0;
            ((int[]) objArr44[3])[0] = i64 ^ (i64 << 5);
        }
        Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame16 == null) {
            int pressedStateDuration = 30 - (ViewConfiguration.getPressedStateDuration() >> 16);
            char cResolveSize = (char) (View.resolveSize(i, i) + 49362);
            int bitsPerPixel = ImageFormat.getBitsPerPixel(i) + 685;
            Object[] objArr45 = new Object[1];
            e((byte) 45, (byte) 69, $$d[28], objArr45);
            objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(pressedStateDuration, cResolveSize, bitsPerPixel, 752929587, false, (String) objArr45[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame16).getLong(null);
        if (j3 == -1 || j3 + 1984 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext2 = getBaseContext();
            if (baseContext2 == null) {
                Object[] objArr46 = new Object[1];
                f(null, new byte[]{-125, -127, -116, -124, -104, -102, -118, -117, -122, -107, -122, -117, -112, -103, -121, -110, -110, -127, -121, -125, -122, -123, -124, -125, -126, -127}, Process.getGidForName("") + 128, null, objArr46);
                Class<?> cls5 = Class.forName((String) objArr46[0]);
                Object[] objArr47 = new Object[1];
                f(null, new byte[]{-126, -123, -122, -117, -127, -112, -122, -113, -110, -110, -103, -117, -126, -116, -124, -124, -101, -112}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + b.l, null, objArr47);
                baseContext2 = (Context) cls5.getMethod((String) objArr47[0], new Class[0]).invoke(null, null);
            }
            if (baseContext2 != null) {
                baseContext2 = ((baseContext2 instanceof ContextWrapper) && ((ContextWrapper) baseContext2).getBaseContext() == null) ? null : baseContext2.getApplicationContext();
            }
            Object[] objArr48 = {baseContext2, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -1543955288};
            byte[] bArr6 = $$p;
            Object[] objArr49 = new Object[1];
            g(bArr6[18], bArr6[345], (short) 421, objArr49);
            Class<?> cls6 = Class.forName((String) objArr49[0]);
            byte b7 = bArr6[241];
            byte b8 = bArr6[17];
            Object[] objArr50 = new Object[1];
            g(b7, b8, (short) (b8 | 550), objArr50);
            objArr3 = (Object[]) cls6.getMethod((String) objArr50[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr48);
            if (baseContext2 != null) {
                Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-326560385);
                if (objAccessartificialFrame17 == null) {
                    int i65 = 31 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                    char cKeyCodeFromString = (char) (KeyEvent.keyCodeFromString("") + 49362);
                    int maximumDrawingCacheSize = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 684;
                    byte[] bArr7 = $$d;
                    byte b9 = (byte) (bArr7[114] + 1);
                    Object[] objArr51 = new Object[1];
                    e(b9, (byte) (b9 | Ascii.DLE), bArr7[28], objArr51);
                    objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(i65, cKeyCodeFromString, maximumDrawingCacheSize, 1944867703, false, (String) objArr51[0], null);
                }
                ((Field) objAccessartificialFrame17).set(null, objArr3);
                try {
                    Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                    if (objAccessartificialFrame18 == null) {
                        int doubleTapTimeout = 30 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                        char cResolveOpacity = (char) (Drawable.resolveOpacity(0, 0) + 49362);
                        int scrollDefaultDelay = 684 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                        Object[] objArr52 = new Object[1];
                        e((byte) 45, (byte) 69, $$d[28], objArr52);
                        objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout, cResolveOpacity, scrollDefaultDelay, 752929587, false, (String) objArr52[0], null);
                    }
                    ((Field) objAccessartificialFrame18).set(null, lValueOf4);
                } catch (Exception unused3) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-326560385);
            if (objAccessartificialFrame19 == null) {
                int capsMode = 30 - TextUtils.getCapsMode("", 0, 0);
                char c6 = (char) (49362 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)));
                int modifierMetaStateMask = 683 - ((byte) KeyEvent.getModifierMetaStateMask());
                byte[] bArr8 = $$d;
                byte b10 = (byte) (bArr8[114] + 1);
                Object[] objArr53 = new Object[1];
                e(b10, (byte) (b10 | Ascii.DLE), bArr8[28], objArr53);
                objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(capsMode, c6, modifierMetaStateMask, 1944867703, false, (String) objArr53[0], null);
            }
            Object[] objArr54 = (Object[]) ((Field) objAccessartificialFrame19).get(null);
            objArr3 = new Object[]{new int[]{((int[]) objArr54[0])[0]}, new int[]{((int[]) objArr54[1])[0]}, new int[1], (String) objArr54[3]};
            int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
            int i66 = ((((-1828867718) + (((~((~iElapsedRealtime) | (-8209))) | (~(792624926 | iElapsedRealtime))) * (-302))) + ((~((-8209) | iElapsedRealtime)) * (-604))) + (((~(iElapsedRealtime | 792616718)) | 606617870) * 302)) - 1543955288;
            int i67 = (i66 << 13) ^ i66;
            int i68 = i67 ^ (i67 >>> 17);
            ((int[]) objArr3[2])[0] = i68 ^ (i68 << 5);
        }
        int i69 = ((int[]) objArr3[1])[0];
        int i70 = ((int[]) objArr3[0])[0];
        if (i70 == i69) {
            int i71 = ((int[]) objArr3[2])[0];
            Object[] objArr55 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
            int i72 = ~((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getStreamVolume(3);
            int i73 = i71 + (((31749760 + (((~((-180377005) | i72)) | (-798246771)) * (-933))) + (((~(i72 | (-798246771))) | 622068306) * 933)) - 1357165659);
            int i74 = (i73 << 13) ^ i73;
            int i75 = i74 ^ (i74 >>> 17);
            i2 = 0;
            ((int[]) objArr55[2])[0] = i75 ^ (i75 << 5);
        } else {
            Object[] objArr56 = {Long.valueOf(((long) (i69 ^ i70)) ^ (((long) 1037127145) << 32)), Long.valueOf(1037127149)};
            byte[] bArr9 = $$p;
            Object[] objArr57 = new Object[1];
            g(bArr9[108], bArr9[24], (short) 398, objArr57);
            Class<?> cls7 = Class.forName((String) objArr57[0]);
            byte b11 = bArr9[662];
            byte b12 = bArr9[18];
            Object[] objArr58 = new Object[1];
            g(b11, b12, (short) (b12 | 705), objArr58);
            cls7.getMethod((String) objArr58[0], Long.TYPE, Long.TYPE).invoke(null, objArr56);
            int i76 = ((int[]) objArr3[2])[0];
            Object[] objArr59 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
            int iIdentityHashCode4 = System.identityHashCode(this);
            int i77 = ~iIdentityHashCode4;
            int i78 = i76 + (-1309603026) + (((~(i77 | 891513712)) | (-892566527) | (~((-86057249) | iIdentityHashCode4))) * 717) + (((~(iIdentityHashCode4 | 891513712)) | (~(i77 | (-86057249))) | (-892566527)) * 717);
            int i79 = (i78 << 13) ^ i78;
            int i80 = i79 ^ (i79 >>> 17);
            i2 = 0;
            ((int[]) objArr59[2])[0] = i80 ^ (i80 << 5);
        }
        Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame20 == null) {
            int packedPositionType = ExpandableListView.getPackedPositionType(0L) + 26;
            char cArgb = (char) Color.argb(i2, i2, i2, i2);
            int keyRepeatTimeout = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 1041;
            Object[] objArr60 = new Object[1];
            e((byte) 47, (byte) 96, $$d[5], objArr60);
            objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(packedPositionType, cArgb, keyRepeatTimeout, 2061780482, false, (String) objArr60[0], null);
        }
        long j4 = ((Field) objAccessartificialFrame20).getLong(null);
        if (j4 == -1 || j4 + 4611686018427387810L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr61 = {-1058806081};
            Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame21 == null) {
                objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(8 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) (22251 - (ViewConfiguration.getLongPressTimeout() >> 16)), 1033 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = LocalDateTime.Property.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame21).newInstance(objArr61), -755593598, false);
            Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame22 == null) {
                int defaultSize2 = View.getDefaultSize(0, 0) + 26;
                char offsetAfter = (char) TextUtils.getOffsetAfter("", 0);
                int longPressTimeout3 = (ViewConfiguration.getLongPressTimeout() >> 16) + 1041;
                Object[] objArr62 = new Object[1];
                e((byte) 47, (byte) 88, $$d[5], objArr62);
                objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(defaultSize2, offsetAfter, longPressTimeout3, 1145017376, false, (String) objArr62[0], null);
            }
            ((Field) objAccessartificialFrame22).set(null, objArrAccessartificialFrame$78cbbd35);
            try {
                Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame23 == null) {
                    int iMyPid = 26 - (Process.myPid() >> 22);
                    char c7 = (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                    int iRed = 1041 - Color.red(0);
                    Object[] objArr63 = new Object[1];
                    e((byte) 47, (byte) 96, $$d[5], objArr63);
                    objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(iMyPid, c7, iRed, 2061780482, false, (String) objArr63[0], null);
                }
                ((Field) objAccessartificialFrame23).set(null, lValueOf5);
            } catch (Exception unused4) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame24 == null) {
                int threadPriority2 = ((Process.getThreadPriority(0) + 20) >> 6) + 26;
                char threadPriority3 = (char) ((Process.getThreadPriority(0) + 20) >> 6);
                int i81 = 1041 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                Object[] objArr64 = new Object[1];
                e((byte) 47, (byte) 88, $$d[5], objArr64);
                objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(threadPriority2, threadPriority3, i81, 1145017376, false, (String) objArr64[0], null);
            }
            Object[] objArr65 = (Object[]) ((Field) objAccessartificialFrame24).get(null);
            objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
            int i82 = ((int[]) objArr65[3])[0];
            int i83 = ((int[]) objArr65[2])[0];
            String[] strArr5 = (String[]) objArr65[0];
            int iMyPid2 = Process.myPid();
            int i84 = ~iMyPid2;
            int i85 = (~(854914889 | i84)) | 84412416;
            int i86 = ~(iMyPid2 | (-6308610));
            int i87 = ((((i85 | i86) * (-252)) - 124803842) + ((i86 | (~(i84 | 939327305))) * 252)) - 755593598;
            int i88 = (i87 << 13) ^ i87;
            int i89 = i88 ^ (i88 >>> 17);
            ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i89 ^ (i89 << 5);
        }
        int i90 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i91 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i91 == i90) {
            Object[] objArr66 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i92 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i93 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i94 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr6 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int i95 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenLayout;
            int i96 = (~(950846177 | i95)) | 89130240;
            int i97 = ~((~i95) | (-11026434));
            int i98 = i92 + (-980356354) + ((i96 | i97) * (-470)) + (((~(i95 | 1039976417)) | i97) * 470);
            int i99 = (i98 << 13) ^ i98;
            int i100 = i99 ^ (i99 >>> 17);
            ((int[]) objArr66[1])[0] = i100 ^ (i100 << 5);
            i3 = 0;
        } else {
            ArrayList arrayList3 = new ArrayList();
            String[] strArr7 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr7 != null) {
                for (String str5 : strArr7) {
                    int i101 = artificialFrame + 93;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i101 % 128;
                    int i102 = i101 % 2;
                    arrayList3.add(str5);
                }
            }
            Object[] objArr67 = {Long.valueOf((((long) (-313030360)) << 32) ^ ((long) (i90 ^ i91))), Long.valueOf(-313030358)};
            byte[] bArr10 = $$p;
            Object[] objArr68 = new Object[1];
            g(bArr10[18], bArr10[70], (short) 374, objArr68);
            Class<?> cls8 = Class.forName((String) objArr68[0]);
            byte b13 = bArr10[662];
            byte b14 = bArr10[18];
            Object[] objArr69 = new Object[1];
            g(b13, b14, (short) (b14 | 705), objArr69);
            cls8.getMethod((String) objArr69[0], Long.TYPE, Long.TYPE).invoke(null, objArr67);
            Object[] objArr70 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i103 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i104 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i105 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr8 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int i106 = ~(System.identityHashCode(this) | 327082473);
            int i107 = i103 + (((-497679620) | i106) * (-658)) + 95820110 + ((i106 | (-536870380)) * 658);
            int i108 = (i107 << 13) ^ i107;
            int i109 = i108 ^ (i108 >>> 17);
            i3 = 0;
            ((int[]) objArr70[1])[0] = i109 ^ (i109 << 5);
        }
        Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame25 == null) {
            int capsMode2 = 30 - TextUtils.getCapsMode("", i3, i3);
            char c8 = (char) (49363 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
            int iLastIndexOf2 = TextUtils.lastIndexOf("", '0', i3) + 685;
            byte[] bArr11 = $$d;
            Object[] objArr71 = new Object[1];
            e((byte) 45, (byte) (-bArr11[15]), (byte) (-bArr11[4]), objArr71);
            objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(capsMode2, c8, iLastIndexOf2, 508509282, false, (String) objArr71[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame25).getLong(null);
        if (j5 == -1 || j5 + 1930 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext3 = getBaseContext();
            if (baseContext3 == null) {
                Object[] objArr72 = new Object[1];
                f(null, new byte[]{-125, -127, -116, -124, -104, -102, -118, -117, -122, -107, -122, -117, -112, -103, -121, -110, -110, -127, -121, -125, -122, -123, -124, -125, -126, -127}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) + 91, null, objArr72);
                Class<?> cls9 = Class.forName((String) objArr72[0]);
                Object[] objArr73 = new Object[1];
                f(null, new byte[]{-126, -123, -122, -117, -127, -112, -122, -113, -110, -110, -103, -117, -126, -116, -124, -124, -101, -112}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 92, null, objArr73);
                baseContext3 = (Context) cls9.getMethod((String) objArr73[0], new Class[0]).invoke(null, null);
            }
            if (baseContext3 != null) {
                int i110 = artificialFrame;
                int i111 = i110 + 59;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i111 % 128;
                int i112 = i111 % 2;
                if (!(baseContext3 instanceof ContextWrapper)) {
                    baseContext3 = baseContext3.getApplicationContext();
                } else {
                    int i113 = i110 + 25;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i113 % 128;
                    int i114 = i113 % 2;
                    if (((ContextWrapper) baseContext3).getBaseContext() != null) {
                        baseContext3 = baseContext3.getApplicationContext();
                    } else {
                        baseContext3 = null;
                    }
                }
            }
            int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            int i115 = getARTIFICIAL_FRAME_PACKAGE_NAME + 45;
            artificialFrame = i115 % 128;
            int i116 = i115 % 2;
            Object[] objArr74 = {baseContext3, Integer.valueOf(iIntValue2), 1600408043};
            byte[] bArr12 = $$p;
            Object[] objArr75 = new Object[1];
            g(bArr12[108], (byte) 102, (short) 331, objArr75);
            Class<?> cls10 = Class.forName((String) objArr75[0]);
            Object[] objArr76 = new Object[1];
            g(bArr12[29], bArr12[75], (short) 227, objArr76);
            objArr4 = (Object[]) cls10.getMethod((String) objArr76[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr74);
            if (baseContext3 != null) {
                Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame26 == null) {
                    int minimumFlingVelocity = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 30;
                    char cBlue2 = (char) (Color.blue(0) + 49362);
                    int touchSlop2 = (ViewConfiguration.getTouchSlop() >> 8) + 684;
                    byte[] bArr13 = $$d;
                    Object[] objArr77 = new Object[1];
                    e((byte) (-bArr13[15]), (byte) (-bArr13[20]), (byte) (bArr13[5] - 1), objArr77);
                    objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity, cBlue2, touchSlop2, -1321816393, false, (String) objArr77[0], null);
                }
                ((Field) objAccessartificialFrame26).set(null, objArr4);
                try {
                    Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                    if (objAccessartificialFrame27 == null) {
                        int maximumFlingVelocity = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 30;
                        char capsMode3 = (char) (TextUtils.getCapsMode("", 0, 0) + 49362);
                        int iLastIndexOf3 = TextUtils.lastIndexOf("", '0', 0) + 685;
                        byte[] bArr14 = $$d;
                        Object[] objArr78 = new Object[1];
                        e((byte) 45, (byte) (-bArr14[15]), (byte) (-bArr14[4]), objArr78);
                        objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity, capsMode3, iLastIndexOf3, 508509282, false, (String) objArr78[0], null);
                    }
                    ((Field) objAccessartificialFrame27).set(null, lValueOf6);
                } catch (Exception unused5) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(777251007);
            if (objAccessartificialFrame28 == null) {
                int trimmedLength = 30 - TextUtils.getTrimmedLength("");
                char c9 = (char) (49362 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                int i117 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 684;
                byte[] bArr15 = $$d;
                Object[] objArr79 = new Object[1];
                e((byte) (-bArr15[15]), (byte) (-bArr15[20]), (byte) (bArr15[5] - 1), objArr79);
                objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(trimmedLength, c9, i117, -1321816393, false, (String) objArr79[0], null);
            }
            Object[] objArr80 = (Object[]) ((Field) objAccessartificialFrame28).get(null);
            objArr4 = new Object[]{new int[]{((int[]) objArr80[0])[0]}, new int[]{((int[]) objArr80[1])[0]}, new int[1], (String) objArr80[3]};
            int iNextInt = new Random().nextInt(883595226);
            int i118 = ~iNextInt;
            int i119 = (-221413010) + (((~((-904320200) | i118)) | 73711687) * 168) + ((~((-73711688) | iNextInt)) * 168) + (((~(iNextInt | (-830608513))) | (~(i118 | (-74303576))) | 591888) * 168) + 1600408043;
            int i120 = (i119 << 13) ^ i119;
            int i121 = i120 ^ (i120 >>> 17);
            ((int[]) objArr4[2])[0] = i121 ^ (i121 << 5);
        }
        int i122 = ((int[]) objArr4[1])[0];
        int i123 = ((int[]) objArr4[0])[0];
        if (i123 == i122) {
            int i124 = ((int[]) objArr4[2])[0];
            Object[] objArr81 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
            int startUptimeMillis = (int) Process.getStartUptimeMillis();
            int i125 = i124 + 1666050426 + (((~((-39321602) | (~startUptimeMillis))) | (-939302174)) * (-591)) + ((startUptimeMillis | (-39321602)) * 591);
            int i126 = (i125 << 13) ^ i125;
            int i127 = i126 ^ (i126 >>> 17);
            ((int[]) objArr81[2])[0] = i127 ^ (i127 << 5);
        } else {
            Object[] objArr82 = {Long.valueOf(((long) (i122 ^ i123)) ^ (((long) 599023807) << 32)), Long.valueOf(599024319)};
            byte[] bArr16 = $$p;
            byte b15 = bArr16[108];
            byte b16 = bArr16[86];
            Object[] objArr83 = new Object[1];
            g(b15, b16, (short) (b16 | 143), objArr83);
            Class<?> cls11 = Class.forName((String) objArr83[0]);
            byte b17 = bArr16[662];
            byte b18 = bArr16[18];
            Object[] objArr84 = new Object[1];
            g(b17, b18, (short) (b18 | 705), objArr84);
            cls11.getMethod((String) objArr84[0], Long.TYPE, Long.TYPE).invoke(null, objArr82);
            int i128 = ((int[]) objArr4[2])[0];
            Object[] objArr85 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
            int iMyUid = Process.myUid();
            int i129 = ~iMyUid;
            int i130 = ~(329447137 | i129);
            int i131 = i128 + 992761086 + ((605093916 | i130) * (-712)) + (((~(iMyUid | 934541053)) | (~(i129 | (-605093917)))) * (-712)) + (((-649176638) | i130) * 712);
            int i132 = (i131 << 13) ^ i131;
            int i133 = i132 ^ (i132 >>> 17);
            ((int[]) objArr85[2])[0] = i133 ^ (i133 << 5);
        }
        super.onCreate();
        Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame29 == null) {
            int pressedStateDuration2 = (ViewConfiguration.getPressedStateDuration() >> 16) + 30;
            char maximumDrawingCacheSize2 = (char) ((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 49362);
            int i134 = 685 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
            byte[] bArr17 = $$d;
            Object[] objArr86 = new Object[1];
            e((byte) (bArr17[114] + 1), (byte) (-bArr17[94]), (byte) (-bArr17[4]), objArr86);
            objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(pressedStateDuration2, maximumDrawingCacheSize2, i134, -1583976536, false, (String) objArr86[0], null);
        }
        long j6 = ((Field) objAccessartificialFrame29).getLong(null);
        if (j6 == -1 || j6 + 1958 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            int iIntValue3 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            int i135 = artificialFrame + 113;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i135 % 128;
            int i136 = i135 % 2;
            Object[] objArr87 = {Integer.valueOf(iIntValue3), 1515025681};
            byte[] bArr18 = $$p;
            Object[] objArr88 = new Object[1];
            g(bArr18[34], (byte) (-bArr18[344]), (short) 141, objArr88);
            Class<?> cls12 = Class.forName((String) objArr88[0]);
            byte b19 = bArr18[108];
            byte b20 = bArr18[29];
            Object[] objArr89 = new Object[1];
            g(b19, b20, (short) (b20 | 97), objArr89);
            objArr5 = (Object[]) cls12.getMethod((String) objArr89[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr87);
            Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame30 == null) {
                int i137 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 29;
                char modifierMetaStateMask2 = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 49363);
                int i138 = 685 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                byte[] bArr19 = $$d;
                Object[] objArr90 = new Object[1];
                e((byte) 40, bArr19[28], bArr19[5], objArr90);
                objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(i137, modifierMetaStateMask2, i138, -1456483158, false, (String) objArr90[0], null);
            }
            ((Field) objAccessartificialFrame30).set(null, objArr5);
            try {
                Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame31 == null) {
                    int iArgb = Color.argb(0, 0, 0, 0) + 30;
                    char keyRepeatTimeout2 = (char) (49362 - (ViewConfiguration.getKeyRepeatTimeout() >> 16));
                    int iBlue = Color.blue(0) + 684;
                    byte[] bArr20 = $$d;
                    Object[] objArr91 = new Object[1];
                    e((byte) (bArr20[114] + 1), (byte) (-bArr20[94]), (byte) (-bArr20[4]), objArr91);
                    objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(iArgb, keyRepeatTimeout2, iBlue, -1583976536, false, (String) objArr91[0], null);
                }
                ((Field) objAccessartificialFrame31).set(null, lValueOf7);
            } catch (Exception unused6) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame32 == null) {
                int i139 = 31 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                char capsMode4 = (char) (TextUtils.getCapsMode("", 0, 0) + 49362);
                int iIndexOf2 = TextUtils.indexOf("", "", 0) + 684;
                byte[] bArr21 = $$d;
                Object[] objArr92 = new Object[1];
                e((byte) 40, bArr21[28], bArr21[5], objArr92);
                objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(i139, capsMode4, iIndexOf2, -1456483158, false, (String) objArr92[0], null);
            }
            Object[] objArr93 = (Object[]) ((Field) objAccessartificialFrame32).get(null);
            objArr5 = new Object[]{new int[]{((int[]) objArr93[0])[0]}, new int[]{((int[]) objArr93[1])[0]}, new int[1], (String) objArr93[3]};
            int i140 = (int) Runtime.getRuntime().totalMemory();
            int i141 = ~i140;
            int i142 = (-1448718146) + (((~(i141 | 532978192)) | (~((-445645583) | i141)) | 1048846) * 464) + (((-444596737) | i140) * (-464)) + (((~(i140 | 532978192)) | 1048846) * 464) + 1515025681;
            int i143 = (i142 << 13) ^ i142;
            int i144 = i143 ^ (i143 >>> 17);
            ((int[]) objArr5[2])[0] = i144 ^ (i144 << 5);
        }
        int i145 = ((int[]) objArr5[1])[0];
        int i146 = ((int[]) objArr5[0])[0];
        if (i146 == i145) {
            int i147 = ((int[]) objArr5[2])[0];
            Object[] objArr94 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int iIdentityHashCode5 = System.identityHashCode(this);
            int i148 = ~iIdentityHashCode5;
            int i149 = i147 + 286780524 + ((619349306 | i148) * (-757)) + ((~((-285217477) | iIdentityHashCode5)) * 1514) + (((~(iIdentityHashCode5 | 904566782)) | (~(i148 | (-359274469))) | 74056992) * 757);
            int i150 = (i149 << 13) ^ i149;
            int i151 = i150 ^ (i150 >>> 17);
            i4 = 0;
            ((int[]) objArr94[2])[0] = i151 ^ (i151 << 5);
        } else {
            new ArrayList().add((String) objArr5[3]);
            Object[] objArr95 = {Long.valueOf(((long) (i145 ^ i146)) ^ (((long) (-1685509474)) << 32)), Long.valueOf(-1685509490)};
            byte[] bArr22 = $$p;
            Object[] objArr96 = new Object[1];
            g(bArr22[108], bArr22[720], (short) 95, objArr96);
            Class<?> cls13 = Class.forName((String) objArr96[0]);
            byte b21 = bArr22[662];
            byte b22 = bArr22[18];
            Object[] objArr97 = new Object[1];
            g(b21, b22, (short) (b22 | 705), objArr97);
            cls13.getMethod((String) objArr97[0], Long.TYPE, Long.TYPE).invoke(null, objArr95);
            int i152 = ((int[]) objArr5[2])[0];
            Object[] objArr98 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int i153 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 610703053;
            int i154 = i152 + 182054866 + (((~((~i153) | (-352309025))) | 626314750) * (-235)) + (((~((-352309025) | i153)) | 626314750) * (-470)) + (((~(i153 | (-279642625))) | 553648350) * 235);
            int i155 = (i154 << 13) ^ i154;
            int i156 = i155 ^ (i155 >>> 17);
            i4 = 0;
            ((int[]) objArr98[2])[0] = i156 ^ (i156 << 5);
        }
        Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame33 == null) {
            int pressedStateDuration3 = (ViewConfiguration.getPressedStateDuration() >> 16) + 36;
            char cGreen = (char) Color.green(i4);
            int gidForName = Process.getGidForName("") + 541;
            Object[] objArr99 = new Object[1];
            e((byte) 47, (byte) 96, $$d[5], objArr99);
            objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(pressedStateDuration3, cGreen, gidForName, 624296913, false, (String) objArr99[0], null);
        }
        long j7 = ((Field) objAccessartificialFrame33).getLong(null);
        if (j7 != -1) {
            int i157 = artificialFrame + b.i;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i157 % 128;
            int i158 = i157 % 2;
            if (j7 + 1906 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                if (objAccessartificialFrame34 == null) {
                    int iAxisFromString2 = MotionEvent.axisFromString("") + 37;
                    char c10 = (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1);
                    int scrollDefaultDelay2 = 540 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                    Object[] objArr100 = new Object[1];
                    e((byte) 47, (byte) 88, $$d[5], objArr100);
                    objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(iAxisFromString2, c10, scrollDefaultDelay2, 793268735, false, (String) objArr100[0], null);
                }
                Object[] objArr101 = (Object[]) ((Field) objAccessartificialFrame34).get(null);
                objArr6 = new Object[]{new int[1], new int[1], new int[1]};
                int i159 = ((int[]) objArr101[2])[0];
                int i160 = ((int[]) objArr101[1])[0];
                ((int[]) objArr6[2])[0] = i159;
                ((int[]) objArr6[1])[0] = i160;
                int iMyUid2 = Process.myUid();
                int i161 = ~iMyUid2;
                int i162 = (((1494110369 + (((-6636402) | iMyUid2) * (-676))) + (((~(790279300 | i161)) | 6636401) * 676)) + (((~(iMyUid2 | 796915701)) | ((~(i161 | (-561342450))) | 554706048)) * 676)) - 1078351194;
                int i163 = (i162 << 13) ^ i162;
                int i164 = i163 ^ (i163 >>> 17);
                ((int[]) objArr6[0])[0] = i164 ^ (i164 << 5);
            } else {
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1717965552);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(20 - (Process.myPid() >> 22), (char) (Color.rgb(0, 0, 0) + 16816732), 983 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 117222168, false, null, new Class[0]);
                }
                Object[] objArr102 = {null, ((Constructor) objAccessartificialFrame4).newInstance(null), -1078351194, 0};
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-501205803);
                if (objAccessartificialFrame5 == null) {
                    int iMyTid2 = (Process.myTid() >> 22) + 36;
                    char packedPositionGroup2 = (char) ExpandableListView.getPackedPositionGroup(0L);
                    int iMyTid3 = 540 - (Process.myTid() >> 22);
                    byte[] bArr23 = $$d;
                    byte b23 = (byte) (bArr23[5] - 1);
                    Object[] objArr103 = new Object[1];
                    e(b23, b23, bArr23[98], objArr103);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iMyTid2, packedPositionGroup2, iMyTid3, 2101703389, false, (String) objArr103[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(ImageFormat.getBitsPerPixel(0) + 55, (char) (833 - (ViewConfiguration.getFadingEdgeLength() >> 16)), TextUtils.indexOf((CharSequence) "", '0') + 577), (Class) ArtificialStackFrames.coroutineCreation((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 54, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 630 - (ViewConfiguration.getWindowTouchSlop() >> 8)), Integer.TYPE, Integer.TYPE});
                }
                objArr6 = (Object[]) ((Method) objAccessartificialFrame5).invoke(null, objArr102);
                objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                if (objAccessartificialFrame6 == null) {
                    int iGreen2 = Color.green(0) + 36;
                    char cAlpha = (char) Color.alpha(0);
                    int iMyTid4 = (Process.myTid() >> 22) + 540;
                    Object[] objArr104 = new Object[1];
                    e((byte) 47, (byte) 88, $$d[5], objArr104);
                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iGreen2, cAlpha, iMyTid4, 793268735, false, (String) objArr104[0], null);
                }
                ((Field) objAccessartificialFrame6).set(null, objArr6);
                try {
                    Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                    if (objAccessartificialFrame7 == null) {
                        int size = 36 - View.MeasureSpec.getSize(0);
                        char cGreen2 = (char) Color.green(0);
                        int keyRepeatDelay = 540 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                        Object[] objArr105 = new Object[1];
                        e((byte) 47, (byte) 96, $$d[5], objArr105);
                        objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(size, cGreen2, keyRepeatDelay, 624296913, false, (String) objArr105[0], null);
                    }
                    ((Field) objAccessartificialFrame7).set(null, lValueOf8);
                } catch (Exception unused7) {
                    throw new RuntimeException();
                }
            }
        } else {
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1717965552);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(20 - (Process.myPid() >> 22), (char) (Color.rgb(0, 0, 0) + 16816732), 983 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 117222168, false, null, new Class[0]);
            }
            Object[] objArr106 = {null, ((Constructor) objAccessartificialFrame4).newInstance(null), -1078351194, 0};
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-501205803);
            if (objAccessartificialFrame5 == null) {
                int iMyTid5 = (Process.myTid() >> 22) + 36;
                char packedPositionGroup3 = (char) ExpandableListView.getPackedPositionGroup(0L);
                int iMyTid6 = 540 - (Process.myTid() >> 22);
                byte[] bArr24 = $$d;
                byte b24 = (byte) (bArr24[5] - 1);
                Object[] objArr107 = new Object[1];
                e(b24, b24, bArr24[98], objArr107);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iMyTid5, packedPositionGroup3, iMyTid6, 2101703389, false, (String) objArr107[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(ImageFormat.getBitsPerPixel(0) + 55, (char) (833 - (ViewConfiguration.getFadingEdgeLength() >> 16)), TextUtils.indexOf((CharSequence) "", '0') + 577), (Class) ArtificialStackFrames.coroutineCreation((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 54, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 630 - (ViewConfiguration.getWindowTouchSlop() >> 8)), Integer.TYPE, Integer.TYPE});
            }
            objArr6 = (Object[]) ((Method) objAccessartificialFrame5).invoke(null, objArr106);
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame6 == null) {
                int iGreen3 = Color.green(0) + 36;
                char cAlpha2 = (char) Color.alpha(0);
                int iMyTid7 = (Process.myTid() >> 22) + 540;
                Object[] objArr108 = new Object[1];
                e((byte) 47, (byte) 88, $$d[5], objArr108);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iGreen3, cAlpha2, iMyTid7, 793268735, false, (String) objArr108[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, objArr6);
            Long lValueOf9 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1168947751);
            if (objAccessartificialFrame7 == null) {
                int size2 = 36 - View.MeasureSpec.getSize(0);
                char cGreen3 = (char) Color.green(0);
                int keyRepeatDelay2 = 540 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                Object[] objArr109 = new Object[1];
                e((byte) 47, (byte) 96, $$d[5], objArr109);
                objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(size2, cGreen3, keyRepeatDelay2, 624296913, false, (String) objArr109[0], null);
            }
            ((Field) objAccessartificialFrame7).set(null, lValueOf9);
        }
        Object obj = objArr6[1];
        int i165 = ((int[]) obj)[0];
        Object obj2 = objArr6[2];
        int i166 = ((int[]) obj2)[0];
        if (i166 == i165) {
            int i167 = artificialFrame + 7;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i167 % 128;
            int i168 = i167 % 2;
            Object[] objArr110 = {new int[1], new int[1], new int[1]};
            int i169 = ((int[]) objArr6[0])[0];
            int i170 = ((int[]) obj2)[0];
            int i171 = ((int[]) obj)[0];
            ((int[]) objArr110[2])[0] = i170;
            ((int[]) objArr110[1])[0] = i171;
            int i172 = ~((~((int) Process.getStartElapsedRealtime())) | 1291285343);
            int i173 = i169 + (((1281839689 | i172) * (-970)) - 1376745549) + ((i172 | 9445654) * 970);
            int i174 = (i173 << 13) ^ i173;
            int i175 = i174 ^ (i174 >>> 17);
            i5 = 0;
            ((int[]) objArr110[0])[0] = i175 ^ (i175 << 5);
        } else {
            Object[] objArr111 = {Long.valueOf((((long) (-1193175714)) << 32) ^ ((long) (i165 ^ i166))), Long.valueOf(-1193179810)};
            byte[] bArr25 = $$p;
            Object[] objArr112 = new Object[1];
            g(bArr25[108], bArr25[720], (short) 95, objArr112);
            Class<?> cls14 = Class.forName((String) objArr112[0]);
            byte b25 = bArr25[662];
            byte b26 = bArr25[18];
            Object[] objArr113 = new Object[1];
            g(b25, b26, (short) (b26 | 705), objArr113);
            cls14.getMethod((String) objArr113[0], Long.TYPE, Long.TYPE).invoke(null, objArr111);
            Object[] objArr114 = {new int[1], new int[1], new int[1]};
            int i176 = ((int[]) objArr6[0])[0];
            int i177 = ((int[]) objArr6[2])[0];
            int i178 = ((int[]) objArr6[1])[0];
            ((int[]) objArr114[2])[0] = i177;
            ((int[]) objArr114[1])[0] = i178;
            int i179 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 1644396898;
            int i180 = ~((-654039344) | (~i179));
            int i181 = i176 + ((151257664 | i180 | (~(654039343 | i179))) * (-338)) + 937104629 + (((~(i179 | 805297007)) | i180) * 338);
            int i182 = (i181 << 13) ^ i181;
            int i183 = i182 ^ (i182 >>> 17);
            i5 = 0;
            ((int[]) objArr114[0])[0] = i183 ^ (i183 << 5);
        }
        Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame35 == null) {
            int i184 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 21;
            char cNormalizeMetaState = (char) KeyEvent.normalizeMetaState(i5);
            int maxKeyCode3 = 465 - (KeyEvent.getMaxKeyCode() >> 16);
            Object[] objArr115 = new Object[1];
            e((byte) 47, (byte) 96, $$d[5], objArr115);
            objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(i184, cNormalizeMetaState, maxKeyCode3, -785931255, false, (String) objArr115[0], null);
        }
        long j8 = ((Field) objAccessartificialFrame35).getLong(null);
        if (j8 == -1 || j8 + 2005 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext4 = getBaseContext();
            if (baseContext4 == null) {
                Object[] objArr116 = new Object[1];
                f(null, new byte[]{-125, -127, -116, -124, -104, -102, -118, -117, -122, -107, -122, -117, -112, -103, -121, -110, -110, -127, -121, -125, -122, -123, -124, -125, -126, -127}, 126 - Process.getGidForName(""), null, objArr116);
                Class<?> cls15 = Class.forName((String) objArr116[0]);
                Object[] objArr117 = new Object[1];
                f(null, new byte[]{-126, -123, -122, -117, -127, -112, -122, -113, -110, -110, -103, -117, -126, -116, -124, -124, -101, -112}, 127 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), null, objArr117);
                baseContext4 = (Context) cls15.getMethod((String) objArr117[0], new Class[0]).invoke(null, null);
            }
            if (baseContext4 != null) {
                baseContext4 = ((baseContext4 instanceof ContextWrapper) && ((ContextWrapper) baseContext4).getBaseContext() == null) ? null : baseContext4.getApplicationContext();
            }
            int iIntValue4 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr118 = new Object[1];
            f(null, new byte[]{-96, -125, -112, -98, -116, -127, -112, -93, -127, -92, -90, -95, -98, -127, -127, -100, -93, -112, -90, -91, -94, -100, -112, -93, -100, -95, -100, -91, -125, -94, -94, -100, -100, -116, -91, -125, -93, -96, -127, -98, -100, -91, -95, -94, -94, -92, -125, -116, -100, -91, -92, -93, -127, -94, -95, -112, -98, -100, -116, -96, -97, -98, -99, -100}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(3) + 81, null, objArr118);
            String str6 = (String) objArr118[0];
            Object[] objArr119 = new Object[1];
            f(null, new byte[]{-116, -100, -127, -93, -96, -91, -127, -89, -92, -92, -116, -89, -100, -127, -96, -98, -97, -98, -93, -96, -97, -94, -97, -95, -94, -116, -127, -94, -97, -97, -96, -94, -97, -89, -94, -125, -97, -92, -90, -95, -127, -94, -100, -127, -116, -99, -92, -96, -95, -125, -96, -92, -89, -94, -95, -99, -90, -93, -100, -116, -116, -116, -98, -94}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 92, null, objArr119);
            Object[] objArr120 = {baseContext4, new String[]{str6, (String) objArr119[0]}, Integer.valueOf(iIntValue4), 1, 667125387};
            byte[] bArr26 = $$p;
            Object[] objArr121 = new Object[1];
            g(bArr26[108], bArr26[308], (short) (-bArr26[146]), objArr121);
            Class<?> cls16 = Class.forName((String) objArr121[0]);
            Object[] objArr122 = new Object[1];
            g(bArr26[29], bArr26[75], (short) 227, objArr122);
            Object[] objArr123 = (Object[]) cls16.getMethod((String) objArr122[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr120);
            int i185 = ((int[]) objArr123[0])[0];
            int i186 = ((int[]) objArr123[3])[0];
            if (baseContext4 != null) {
                Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame36 == null) {
                    int iMyPid3 = (Process.myPid() >> 22) + 21;
                    char threadPriority4 = (char) ((Process.getThreadPriority(0) + 20) >> 6);
                    int edgeSlop = (ViewConfiguration.getEdgeSlop() >> 16) + 465;
                    Object[] objArr124 = new Object[1];
                    e((byte) 47, (byte) 88, $$d[5], objArr124);
                    objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(iMyPid3, threadPriority4, edgeSlop, -612765161, false, (String) objArr124[0], null);
                }
                ((Field) objAccessartificialFrame36).set(null, objArr123);
                try {
                    Long lValueOf10 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(1313006081);
                    if (objAccessartificialFrame37 == null) {
                        int scrollBarFadeDuration3 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 21;
                        char cBlue3 = (char) Color.blue(0);
                        int iAxisFromString3 = 464 - MotionEvent.axisFromString("");
                        Object[] objArr125 = new Object[1];
                        e((byte) 47, (byte) 96, $$d[5], objArr125);
                        objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration3, cBlue3, iAxisFromString3, -785931255, false, (String) objArr125[0], null);
                    }
                    ((Field) objAccessartificialFrame37).set(null, lValueOf10);
                } catch (Exception unused8) {
                    throw new RuntimeException();
                }
            }
            objArr7 = objArr123;
        } else {
            Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(1142731807);
            if (objAccessartificialFrame38 == null) {
                int pressedStateDuration4 = (ViewConfiguration.getPressedStateDuration() >> 16) + 21;
                char touchSlop3 = (char) (ViewConfiguration.getTouchSlop() >> 8);
                int offsetBefore = TextUtils.getOffsetBefore("", 0) + 465;
                Object[] objArr126 = new Object[1];
                e((byte) 47, (byte) 88, $$d[5], objArr126);
                objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(pressedStateDuration4, touchSlop3, offsetBefore, -612765161, false, (String) objArr126[0], null);
            }
            Object[] objArr127 = (Object[]) ((Field) objAccessartificialFrame38).get(null);
            objArr7 = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
            int i187 = ((int[]) objArr127[3])[0];
            int i188 = ((int[]) objArr127[0])[0];
            String[] strArr9 = (String[]) objArr127[1];
            int iIdentityHashCode6 = System.identityHashCode(this);
            int i189 = ~iIdentityHashCode6;
            int i190 = (-1982584431) + (((~((-18121251) | i189)) | 178470976) * 220) + (((~(i189 | (-559199927))) | 719549652) * (-440)) + ((iIdentityHashCode6 | (-18121251)) * 220) + 667125387;
            int i191 = (i190 << 13) ^ i190;
            int i192 = i191 ^ (i191 >>> 17);
            ((int[]) objArr7[2])[0] = i192 ^ (i192 << 5);
        }
        int i193 = ((int[]) objArr7[0])[0];
        int i194 = ((int[]) objArr7[3])[0];
        if (i194 == i193) {
            Object[] objArr128 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i195 = ((int[]) objArr7[2])[0];
            int i196 = ((int[]) objArr7[3])[0];
            int i197 = ((int[]) objArr7[0])[0];
            String[] strArr10 = (String[]) objArr7[1];
            int i198 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenLayout;
            int i199 = ~(117100473 | i198);
            int i200 = ~i198;
            int i201 = i195 + (-1113433561) + ((i199 | (~((-108151337) | i200))) * (-406)) + ((~(385601535 | i200)) * (-406)) + (((~(i198 | (-277450200))) | (~((-117100474) | i200))) * 406);
            int i202 = (i201 << 13) ^ i201;
            int i203 = i202 ^ (i202 >>> 17);
            ((int[]) objArr128[2])[0] = i203 ^ (i203 << 5);
            return;
        }
        ArrayList arrayList4 = new ArrayList();
        String[] strArr11 = (String[]) objArr7[1];
        if (strArr11 != null) {
            for (String str7 : strArr11) {
                arrayList4.add(str7);
            }
        }
        Object[] objArr129 = {Long.valueOf(((long) (i193 ^ i194)) ^ (((long) (-386877985)) << 32)), Long.valueOf(-386878049)};
        byte[] bArr27 = $$p;
        Object[] objArr130 = new Object[1];
        g(bArr27[108], bArr27[61], bArr27[18], objArr130);
        Class<?> cls17 = Class.forName((String) objArr130[0]);
        byte b27 = bArr27[662];
        byte b28 = bArr27[18];
        Object[] objArr131 = new Object[1];
        g(b27, b28, (short) (b28 | 705), objArr131);
        cls17.getMethod((String) objArr131[0], Long.TYPE, Long.TYPE).invoke(null, objArr129);
        Object[] objArr132 = {new int[]{i}, strArr, new int[1], new int[]{i}};
        int i204 = ((int[]) objArr7[2])[0];
        int i205 = ((int[]) objArr7[3])[0];
        int i206 = ((int[]) objArr7[0])[0];
        String[] strArr12 = (String[]) objArr7[1];
        int i207 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().mcc;
        int i208 = ~i207;
        int i209 = i204 + (((((~(396892694 | i208)) | (~((-557242421) | i207))) | (~(i208 | 557242420))) * 959) - 732624388) + (((~(i207 | 557242420)) | (~(i208 | (-557242421))) | (~(396892694 | i207))) * 959);
        int i210 = (i209 << 13) ^ i209;
        int i211 = i210 ^ (i210 >>> 17);
        ((int[]) objArr132[2])[0] = i211 ^ (i211 << 5);
    }

    static void accessartificialFrame() {
        validateRelationship = new char[]{55996, 55983, 55985, 55971, 55982, 55988, 56175, 55970, 56130, 55972, 55969, 55984, 55976, 56146, 55977, 55986, 55978, 55981, 56131, 55979, 55975, 55990, 56149, 55989, 56156, 56129, 55968, 55991, 56172, 56166, 56163, 56162, 56164, 56160, 56173, 56167, 56165, 56161, 55987};
        warmup = -1044260067;
        requestPostMessageChannelWithExtras = true;
        ICustomTabsServiceDefault = true;
    }
}
