package com.google.firebase.sessions;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.os.IResultReceiver2;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.firebase.sessions.settings.SessionsSettings;
import com.salesforce.marketingcloud.analytics.stats.b;
import io.sentry.android.core.SentryLogcatAdapter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import o.ArtificialStackFrames;
import o.onRelationshipValidationResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class SessionLifecycleService extends Service {
    public static final int BACKGROUNDED = 2;
    private static final int CLIENT_BOUND = 4;
    public static final String CLIENT_CALLBACK_MESSENGER = "ClientCallbackMessenger";
    public static final Companion Companion;
    public static final int FOREGROUNDED = 1;
    public static final int SESSION_UPDATED = 3;
    public static final String SESSION_UPDATE_EXTRA = "SessionUpdateExtra";
    public static final String TAG = "SessionLifecycleService";
    private static long onPostMessage;
    private final HandlerThread handlerThread = new HandlerThread("FirebaseSessions_HandlerThread");
    private MessageHandler messageHandler;
    private Messenger messenger;
    private static final byte[] $$c = {Ascii.ESC, -99, -92, 1};
    private static final int $$f = 204;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$d = {49, Ascii.SUB, -88, -35, 3, 4, 19, 7, 3, -54, 2, 66, Ascii.FF, Ascii.CR, -8, Ascii.DC4, 3, -6, Ascii.DC2, -55, 73, 3, -4, Ascii.SUB, -7, Ascii.DLE, 10, 2, -56, 58, Ascii.DC4, -3, Ascii.NAK, 4, 1, 2, -47, Ascii.GS, 40, 8, 6, Ascii.DC4, 7, -6, 6, -10, 35, -5, Ascii.SI, 1, Ascii.SYN, -44, 42, 4, Ascii.SYN, Ascii.VT, -8, Ascii.DC4, 7, 68, 19, 5, -56, SignedBytes.MAX_POWER_OF_TWO, Ascii.SI, 7, -1, Ascii.FF, 0, -48, 60, Ascii.SYN, Ascii.SO, -2, Ascii.VT, 2, -58, 77, -4, Ascii.FF, 4, -54, 58, Ascii.VT, 3, 10, -47, Ascii.SUB, 43, Ascii.NAK, -39, 35, Ascii.RS, -38, 33, Ascii.ESC, -78, Ascii.DC4};
    private static final int $$e = 16;
    private static final byte[] $$a = {Ascii.EM, 104, 41, -86, 5, -1, -33, 33, -2, -9, 5, -7, 5, -1, -50, 39, Ascii.VT, -7, -12, Ascii.SI, Ascii.ESC, 1, -7, -6, -33, 51, -12, 3, -8, 1, Ascii.CR};
    private static final int $$b = 158;
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
    private static java.lang.String $$g(int r6, int r7, int r8) {
        /*
            int r8 = r8 * 2
            int r8 = 4 - r8
            byte[] r0 = com.google.firebase.sessions.SessionLifecycleService.$$c
            int r7 = r7 * 4
            int r1 = r7 + 1
            int r6 = r6 * 2
            int r6 = 111 - r6
            byte[] r1 = new byte[r1]
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r8
            r4 = r2
            goto L2d
        L16:
            r3 = r2
            r5 = r8
            r8 = r6
            r6 = r5
        L1a:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L25:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r3
            r3 = r6
            r6 = r4
            r4 = r5
        L2d:
            int r8 = r8 + r6
            int r6 = r3 + 1
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SessionLifecycleService.$$g(int, int, int):java.lang.String");
    }

    static {
        accessartificialFrame();
        Companion = new Companion(null);
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
    private static void a(short r5, short r6, int r7, java.lang.Object[] r8) {
        /*
            byte[] r0 = com.google.firebase.sessions.SessionLifecycleService.$$a
            int r7 = r7 * 28
            int r7 = r7 + 84
            int r5 = r5 * 3
            int r1 = 12 - r5
            int r6 = r6 * 8
            int r6 = 20 - r6
            byte[] r1 = new byte[r1]
            int r5 = 11 - r5
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r5
            r4 = r2
            goto L2a
        L18:
            r3 = r2
        L19:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r5) goto L28
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L28:
            r3 = r0[r6]
        L2a:
            int r7 = r7 + r3
            int r6 = r6 + 1
            r3 = r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SessionLifecycleService.a(short, short, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void c(short r7, short r8, byte r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = com.google.firebase.sessions.SessionLifecycleService.$$d
            int r9 = r9 + 4
            int r7 = r7 * 3
            int r7 = 111 - r7
            int r8 = r8 * 4
            int r8 = 55 - r8
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r8
            r7 = r9
            r4 = r2
            goto L2c
        L15:
            r3 = r2
        L16:
            int r9 = r9 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r8) goto L27
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L27:
            r3 = r0[r9]
            r6 = r9
            r9 = r7
            r7 = r6
        L2c:
            int r9 = r9 + r3
            int r9 = r9 + (-7)
            r3 = r4
            r6 = r9
            r9 = r7
            r7 = r6
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SessionLifecycleService.c(short, short, byte, java.lang.Object[]):void");
    }

    public final HandlerThread getHandlerThread$com_google_firebase_firebase_sessions() {
        return this.handlerThread;
    }

    public static final class MessageHandler extends Handler {
        private final ArrayList<Messenger> boundClients;
        private boolean hasForegrounded;
        private long lastMsgTimeMs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MessageHandler(@NotNull Looper looper) {
            super(looper);
            Intrinsics.checkNotNullParameter(looper, "looper");
            this.boundClients = new ArrayList<>();
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            if (this.lastMsgTimeMs > msg.getWhen()) {
                Log.d(SessionLifecycleService.TAG, "Ignoring old message from " + msg.getWhen() + " which is older than " + this.lastMsgTimeMs + '.');
                return;
            }
            int i = msg.what;
            if (i == 1) {
                handleForegrounding(msg);
                return;
            }
            if (i == 2) {
                handleBackgrounding(msg);
                return;
            }
            if (i == 4) {
                handleClientBound(msg);
                return;
            }
            SentryLogcatAdapter.w(SessionLifecycleService.TAG, "Received unexpected event from the SessionLifecycleClient: " + msg);
            super.handleMessage(msg);
        }

        private final void handleForegrounding(Message message) {
            Log.d(SessionLifecycleService.TAG, "Activity foregrounding at " + message.getWhen() + '.');
            if (!this.hasForegrounded) {
                Log.d(SessionLifecycleService.TAG, "Cold start detected.");
                this.hasForegrounded = true;
                newSession();
            } else if (isSessionRestart(message.getWhen())) {
                Log.d(SessionLifecycleService.TAG, "Session too long in background. Creating new session.");
                newSession();
            }
            this.lastMsgTimeMs = message.getWhen();
        }

        private final void handleBackgrounding(Message message) {
            Log.d(SessionLifecycleService.TAG, "Activity backgrounding at " + message.getWhen());
            this.lastMsgTimeMs = message.getWhen();
        }

        private final void handleClientBound(Message message) {
            this.boundClients.add(message.replyTo);
            Messenger messenger = message.replyTo;
            Intrinsics.checkNotNullExpressionValue(messenger, "msg.replyTo");
            maybeSendSessionToClient(messenger);
            Log.d(SessionLifecycleService.TAG, "Client " + message.replyTo + " bound at " + message.getWhen() + ". Clients: " + this.boundClients.size());
        }

        private final void newSession() {
            SessionGenerator.Companion companion = SessionGenerator.Companion;
            companion.getInstance().generateNewSession();
            Log.d(SessionLifecycleService.TAG, "Generated new session " + companion.getInstance().getCurrentSession().getSessionId());
            broadcastSession();
            SessionDatastore.Companion.getInstance().updateSessionId(companion.getInstance().getCurrentSession().getSessionId());
        }

        private final void broadcastSession() {
            StringBuilder sb = new StringBuilder();
            sb.append("Broadcasting new session: ");
            SessionGenerator.Companion companion = SessionGenerator.Companion;
            sb.append(companion.getInstance().getCurrentSession());
            Log.d(SessionLifecycleService.TAG, sb.toString());
            SessionFirelogPublisher.Companion.getInstance().logSession(companion.getInstance().getCurrentSession());
            for (Messenger it2 : new ArrayList(this.boundClients)) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                maybeSendSessionToClient(it2);
            }
        }

        private final void maybeSendSessionToClient(Messenger messenger) {
            if (this.hasForegrounded) {
                sendSessionToClient(messenger, SessionGenerator.Companion.getInstance().getCurrentSession().getSessionId());
                return;
            }
            String currentSessionId = SessionDatastore.Companion.getInstance().getCurrentSessionId();
            Log.d(SessionLifecycleService.TAG, "App has not yet foregrounded. Using previously stored session: " + currentSessionId);
            if (currentSessionId != null) {
                sendSessionToClient(messenger, currentSessionId);
            }
        }

        private final void sendSessionToClient(Messenger messenger, String str) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString(SessionLifecycleService.SESSION_UPDATE_EXTRA, str);
                Message messageObtain = Message.obtain(null, 3, 0, 0);
                messageObtain.setData(bundle);
                messenger.send(messageObtain);
            } catch (DeadObjectException unused) {
                Log.d(SessionLifecycleService.TAG, "Removing dead client from list: " + messenger);
                this.boundClients.remove(messenger);
            } catch (Exception e) {
                SentryLogcatAdapter.w(SessionLifecycleService.TAG, "Unable to push new session to " + messenger + '.', e);
            }
        }

        private final boolean isSessionRestart(long j) {
            return j - this.lastMsgTimeMs > Duration.m6842getInWholeMillisecondsimpl(SessionsSettings.Companion.getInstance().m5019getSessionRestartTimeoutUwyO8pc());
        }
    }

    private static void b(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        onRelationshipValidationResult onrelationshipvalidationresult = new onRelationshipValidationResult();
        char[] cArrAccessartificialFrame = onRelationshipValidationResult.accessartificialFrame(onPostMessage ^ 2573525503365829440L, cArr, i);
        onrelationshipvalidationresult.e = 4;
        int i3 = $10 + 113;
        $11 = i3 % 128;
        int i4 = i3 % 2;
        while (onrelationshipvalidationresult.e < cArrAccessartificialFrame.length) {
            int i5 = $11 + b.i;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            onrelationshipvalidationresult.d = onrelationshipvalidationresult.e - 4;
            int i7 = onrelationshipvalidationresult.e;
            try {
                Object[] objArr2 = {Long.valueOf(cArrAccessartificialFrame[onrelationshipvalidationresult.e] ^ cArrAccessartificialFrame[onrelationshipvalidationresult.e % 4]), Long.valueOf(onrelationshipvalidationresult.d), Long.valueOf(onPostMessage)};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(797310229);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(28 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 30689), (Process.myPid() >> 22) + 188, -1327449315, false, "k", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                }
                cArrAccessartificialFrame[i7] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                Object[] objArr3 = {onrelationshipvalidationresult, onrelationshipvalidationresult};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(321542193);
                if (objAccessartificialFrame2 == null) {
                    int mode = View.MeasureSpec.getMode(0) + 33;
                    char c = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1);
                    int iResolveSizeAndState = View.resolveSizeAndState(0, 0, 0) + 1483;
                    byte b = (byte) ($$c[3] - 1);
                    byte b2 = b;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(mode, c, iResolveSizeAndState, -1940971975, false, $$g(b, b2, b2), new Class[]{Object.class, Object.class});
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
        objArr[0] = new String(cArrAccessartificialFrame, 4, cArrAccessartificialFrame.length - 4);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.handlerThread.start();
        Looper looper = this.handlerThread.getLooper();
        Intrinsics.checkNotNullExpressionValue(looper, "handlerThread.looper");
        this.messageHandler = new MessageHandler(looper);
        this.messenger = new Messenger(this.messageHandler);
    }

    @Override // android.app.Service
    public IBinder onBind(@Nullable Intent intent) {
        if (intent == null) {
            Log.d(TAG, "Service bound with null intent. Ignoring.");
            return null;
        }
        Log.d(TAG, "Service bound to new client on process " + intent.getAction());
        Messenger clientCallback = getClientCallback(intent);
        if (clientCallback != null) {
            Message messageObtain = Message.obtain(null, 4, 0, 0);
            messageObtain.replyTo = clientCallback;
            MessageHandler messageHandler = this.messageHandler;
            if (messageHandler != null) {
                messageHandler.sendMessage(messageObtain);
            }
        }
        Messenger messenger = this.messenger;
        if (messenger != null) {
            return messenger.getBinder();
        }
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.handlerThread.quit();
    }

    private final Messenger getClientCallback(Intent intent) {
        if (Build.VERSION.SDK_INT >= 33) {
            return (Messenger) intent.getParcelableExtra(CLIENT_CALLBACK_MESSENGER, Messenger.class);
        }
        return (Messenger) intent.getParcelableExtra(CLIENT_CALLBACK_MESSENGER);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0153  */
    /* JADX WARN: Code duplicated, block: B:16:0x01ab A[Catch: all -> 0x092f, TryCatch #3 {all -> 0x092f, blocks: (B:51:0x0626, B:53:0x0646, B:54:0x0690, B:14:0x0197, B:16:0x01ab, B:17:0x01db), top: B:97:0x0197 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:25:0x027b  */
    /* JADX WARN: Code duplicated, block: B:50:0x05c2  */
    /* JADX WARN: Code duplicated, block: B:53:0x0646 A[Catch: all -> 0x092f, TryCatch #3 {all -> 0x092f, blocks: (B:51:0x0626, B:53:0x0646, B:54:0x0690, B:14:0x0197, B:16:0x01ab, B:17:0x01db), top: B:97:0x0197 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x06a2  */
    /* JADX WARN: Code duplicated, block: B:62:0x0749  */
    @Override // android.app.Service, android.content.ContextWrapper
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
            int iNormalizeMetaState = 26 - KeyEvent.normalizeMetaState(0);
            char maximumDrawingCacheSize = (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
            int scrollDefaultDelay = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 1041;
            byte[] bArr = $$a;
            byte b = bArr[21];
            Object[] objArr2 = new Object[1];
            a(b, (byte) (-bArr[8]), b, objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState, maximumDrawingCacheSize, scrollDefaultDelay, 2061780482, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + b.f40o;
            artificialFrame = i2 % 128;
            int i3 = i2 % 2;
            long j2 = j + 4611686018427387782L;
            Object[] objArr3 = new Object[1];
            b(Color.rgb(0, 0, 0) + 16777216, new char[]{9061, 8964, 21725, 54387, 15165, 2827, 17123, 3131, 40242, 5778, 38459, 20015, 24442, 53424, 20649, 35242, 6580, 37240, 4795, 52180, 56296, 21264, 56475, 1286, 37918, 7664}, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            b(ViewConfiguration.getPressedStateDuration() >> 16, new char[]{55428, 55521, 34304, 44115, 59874, 29486, 48238, 62132, 26319, 50241, 60958, 45278, 42129, 637, 10446, 30464, 57925, 17337, 27279}, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame8 == null) {
                    int defaultSize = View.getDefaultSize(0, 0) + 26;
                    char cLastIndexOf = (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0));
                    int i4 = 1041 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                    byte b2 = $$a[21];
                    byte b3 = b2;
                    Object[] objArr5 = new Object[1];
                    a(b2, b3, b3, objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(defaultSize, cLastIndexOf, i4, 1145017376, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i5 = ((int[]) objArr6[3])[0];
                int i6 = ((int[]) objArr6[2])[0];
                String[] strArr = (String[]) objArr6[0];
                int iIdentityHashCode = System.identityHashCode(this);
                int i7 = (((-1554654722) + (((~((~iIdentityHashCode) | 353285064)) | 6310913) * 529)) + (((~(iIdentityHashCode | 353285064)) | 275181257) * 529)) - 664087938;
                int i8 = (i7 << 13) ^ i7;
                int i9 = i8 ^ (i8 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i9 ^ (i9 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                b((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), new char[]{40653, 40615, 43814, 48683, 50377, 24897, 979, 19736, 8411, 59747, 64628, 3935, 58074, 12057, 15006, 51376, 42006, 28299, 30944, 35564}, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                b(Color.alpha(0), new char[]{59314, 59355, 37882, 47220, 64528, 26381, 4656, 23796, 23038, 53695, 64045, 7851, 39818, 6031, 15602, 55618, 56665, 22089, 32429, 39687}, objArr8);
                int iIntValue = ((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue();
                try {
                    Object[] objArr9 = {-921630005};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(8 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (22251 - (ViewConfiguration.getFadingEdgeLength() >> 16)), 1032 - TextUtils.indexOf((CharSequence) "", '0', 0), 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = IResultReceiver2._Parcel.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr9), -664087938, false);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame2 == null) {
                        int offsetAfter = TextUtils.getOffsetAfter("", 0) + 26;
                        char c = (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0) + 1041;
                        byte b4 = $$a[21];
                        byte b5 = b4;
                        Object[] objArr10 = new Object[1];
                        a(b4, b5, b5, objArr10);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(offsetAfter, c, iMakeMeasureSpec, 1145017376, false, (String) objArr10[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
                    try {
                        Object[] objArr11 = new Object[1];
                        b(TextUtils.getOffsetAfter("", 0), new char[]{9061, 8964, 21725, 54387, 15165, 2827, 17123, 3131, 40242, 5778, 38459, 20015, 24442, 53424, 20649, 35242, 6580, 37240, 4795, 52180, 56296, 21264, 56475, 1286, 37918, 7664}, objArr11);
                        Class<?> cls3 = Class.forName((String) objArr11[0]);
                        Object[] objArr12 = new Object[1];
                        b((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), new char[]{55428, 55521, 34304, 44115, 59874, 29486, 48238, 62132, 26319, 50241, 60958, 45278, 42129, 637, 10446, 30464, 57925, 17337, 27279}, objArr12);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr12[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame3 == null) {
                            int mode = 26 - View.MeasureSpec.getMode(0);
                            char offsetBefore = (char) TextUtils.getOffsetBefore("", 0);
                            int i10 = 1042 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                            byte[] bArr2 = $$a;
                            byte b6 = bArr2[21];
                            Object[] objArr13 = new Object[1];
                            a(b6, (byte) (-bArr2[8]), b6, objArr13);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(mode, offsetBefore, i10, 2061780482, false, (String) objArr13[0], null);
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
            b((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), new char[]{40653, 40615, 43814, 48683, 50377, 24897, 979, 19736, 8411, 59747, 64628, 3935, 58074, 12057, 15006, 51376, 42006, 28299, 30944, 35564}, objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            b(Color.alpha(0), new char[]{59314, 59355, 37882, 47220, 64528, 26381, 4656, 23796, 23038, 53695, 64045, 7851, 39818, 6031, 15602, 55618, 56665, 22089, 32429, 39687}, objArr15);
            int iIntValue2 = ((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr16 = {-921630005};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(8 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (22251 - (ViewConfiguration.getFadingEdgeLength() >> 16)), 1032 - TextUtils.indexOf((CharSequence) "", '0', 0), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = IResultReceiver2._Parcel.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr16), -664087938, false);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame2 == null) {
                int offsetAfter2 = TextUtils.getOffsetAfter("", 0) + 26;
                char c2 = (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1);
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0) + 1041;
                byte b7 = $$a[21];
                byte b8 = b7;
                Object[] objArr17 = new Object[1];
                a(b7, b8, b8, objArr17);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(offsetAfter2, c2, iMakeMeasureSpec2, 1145017376, false, (String) objArr17[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr18 = new Object[1];
            b(TextUtils.getOffsetAfter("", 0), new char[]{9061, 8964, 21725, 54387, 15165, 2827, 17123, 3131, 40242, 5778, 38459, 20015, 24442, 53424, 20649, 35242, 6580, 37240, 4795, 52180, 56296, 21264, 56475, 1286, 37918, 7664}, objArr18);
            Class<?> cls5 = Class.forName((String) objArr18[0]);
            Object[] objArr19 = new Object[1];
            b((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), new char[]{55428, 55521, 34304, 44115, 59874, 29486, 48238, 62132, 26319, 50241, 60958, 45278, 42129, 637, 10446, 30464, 57925, 17337, 27279}, objArr19);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr19[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame3 == null) {
                int mode2 = 26 - View.MeasureSpec.getMode(0);
                char offsetBefore2 = (char) TextUtils.getOffsetBefore("", 0);
                int i11 = 1042 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                byte[] bArr3 = $$a;
                byte b9 = bArr3[21];
                Object[] objArr110 = new Object[1];
                a(b9, (byte) (-bArr3[8]), b9, objArr110);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(mode2, offsetBefore2, i11, 2061780482, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i12 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i13 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i13 == i12) {
            int i14 = artificialFrame + 89;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i14 % 128;
            int i15 = i14 % 2;
            Object[] objArr20 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i16 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i17 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i18 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i19 = ~iIdentityHashCode2;
            int i20 = i16 + 458890764 + (((~((-214925229) | i19)) | 4670632) * (-108)) + (((~(i19 | 293029035)) | (~((-293029036) | iIdentityHashCode2)) | (-503283632)) * 54) + ((iIdentityHashCode2 | (-503283632)) * 54);
            int i21 = i20 ^ (i20 << 13);
            int i22 = i21 ^ (i21 >>> 17);
            ((int[]) objArr20[1])[0] = i22 ^ (i22 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr3 != null) {
                for (String str : strArr3) {
                    arrayList.add(str);
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf(((long) (i12 ^ i13)) ^ (((long) (-1291083021)) << 32)), Long.valueOf(-1291083023)};
                byte[] bArr4 = $$d;
                byte b10 = bArr4[68];
                Object[] objArr22 = new Object[1];
                c(b10, b10, bArr4[66], objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                int i23 = $$e;
                Object[] objArr23 = new Object[1];
                c((byte) (i23 | 9), bArr4[13], (byte) (i23 | 37), objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i24 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i25 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i26 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 1759246999;
                int i27 = ~iCodePointAt;
                int i28 = i24 + (-158433714) + (((~(422813600 | i27)) | 80240671) * 168) + ((~((-80240672) | iCodePointAt)) * 168) + (((~(iCodePointAt | 503054271)) | (~(i27 | (-500917408))) | 420676736) * 168);
                int i29 = (i28 << 13) ^ i28;
                int i30 = i29 ^ (i29 >>> 17);
                ((int[]) objArr24[1])[0] = i30 ^ (i30 << 5);
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
            int mirror = 'I' - AndroidCharacter.getMirror('0');
            char longPressTimeout = (char) ((ViewConfiguration.getLongPressTimeout() >> 16) + 30068);
            int touchSlop = 816 - (ViewConfiguration.getTouchSlop() >> 8);
            byte[] bArr5 = $$a;
            byte b11 = bArr5[21];
            byte b12 = b11;
            byte b13 = (byte) (-bArr5[8]);
            byte b14 = b11;
            Object[] objArr25 = new Object[1];
            a(b12, b13, b14, objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(mirror, longPressTimeout, touchSlop, 721586079, false, (String) objArr25[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j3 != -1) {
            long j4 = j3 + 1939;
            Object[] objArr26 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(0) - 37, new char[]{9061, 8964, 21725, 54387, 15165, 2827, 17123, 3131, 40242, 5778, 38459, 20015, 24442, 53424, 20649, 35242, 6580, 37240, 4795, 52180, 56296, 21264, 56475, 1286, 37918, 7664}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            b((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), new char[]{55428, 55521, 34304, 44115, 59874, 29486, 48238, 62132, 26319, 50241, 60958, 45278, 42129, 637, 10446, 30464, 57925, 17337, 27279}, objArr27);
            if (j4 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame10 == null) {
                    int deadChar = 25 - KeyEvent.getDeadChar(0, 0);
                    char windowTouchSlop = (char) (30068 - (ViewConfiguration.getWindowTouchSlop() >> 8));
                    int iRgb = (-16776400) - Color.rgb(0, 0, 0);
                    byte b15 = $$a[21];
                    byte b16 = b15;
                    Object[] objArr28 = new Object[1];
                    a(b15, b16, b16, objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(deadChar, windowTouchSlop, iRgb, 891606461, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i31 = ((int[]) objArr29[0])[0];
                int i32 = ((int[]) objArr29[1])[0];
                String[] strArr5 = (String[]) objArr29[2];
                int iIdentityHashCode3 = System.identityHashCode(this);
                int i33 = ((2015007117 + (((~(863740008 | iIdentityHashCode3)) | 201350934) * 576)) + (((~((~iIdentityHashCode3) | 1065090942)) | 860561440) * 576)) - 398949216;
                int i34 = (i33 << 13) ^ i33;
                int i35 = i34 ^ (i34 >>> 17);
                ((int[]) objArr[3])[0] = i35 ^ (i35 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(4) - 112, new char[]{40653, 40615, 43814, 48683, 50377, 24897, 979, 19736, 8411, 59747, 64628, 3935, 58074, 12057, 15006, 51376, 42006, 28299, 30944, 35564}, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                b((-1) - TextUtils.indexOf((CharSequence) "", '0', 0), new char[]{59314, 59355, 37882, 47220, 64528, 26381, 4656, 23796, 23038, 53695, 64045, 7851, 39818, 6031, 15602, 55618, 56665, 22089, 32429, 39687}, objArr31);
                Object[] objArr32 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue()), 0, -412970208};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame4 == null) {
                    int iIndexOf = 24 - TextUtils.indexOf((CharSequence) "", '0', 0);
                    char cMakeMeasureSpec = (char) (30068 - View.MeasureSpec.makeMeasureSpec(0, 0));
                    int edgeSlop = (ViewConfiguration.getEdgeSlop() >> 16) + 816;
                    byte b17 = (byte) ($$a[21] - 1);
                    byte b18 = b17;
                    Object[] objArr33 = new Object[1];
                    a(b17, b18, b18, objArr33);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iIndexOf, cMakeMeasureSpec, edgeSlop, -797394565, false, (String) objArr33[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr32);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame5 == null) {
                    int iRgb2 = Color.rgb(0, 0, 0) + 16777241;
                    char touchSlop2 = (char) ((ViewConfiguration.getTouchSlop() >> 8) + 30068);
                    int bitsPerPixel = 815 - ImageFormat.getBitsPerPixel(0);
                    byte b19 = $$a[21];
                    byte b20 = b19;
                    Object[] objArr34 = new Object[1];
                    a(b19, b20, b20, objArr34);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iRgb2, touchSlop2, bitsPerPixel, 891606461, false, (String) objArr34[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr);
                try {
                    Object[] objArr35 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35, new char[]{9061, 8964, 21725, 54387, 15165, 2827, 17123, 3131, 40242, 5778, 38459, 20015, 24442, 53424, 20649, 35242, 6580, 37240, 4795, 52180, 56296, 21264, 56475, 1286, 37918, 7664}, objArr35);
                    Class<?> cls9 = Class.forName((String) objArr35[0]);
                    Object[] objArr36 = new Object[1];
                    b(TextUtils.indexOf("", "", 0, 0), new char[]{55428, 55521, 34304, 44115, 59874, 29486, 48238, 62132, 26319, 50241, 60958, 45278, 42129, 637, 10446, 30464, 57925, 17337, 27279}, objArr36);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr36[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame6 == null) {
                        int packedPositionType = 25 - ExpandableListView.getPackedPositionType(0L);
                        char cRgb = (char) (Color.rgb(0, 0, 0) + 16807284);
                        int iIndexOf2 = 815 - TextUtils.indexOf((CharSequence) "", '0', 0);
                        byte[] bArr6 = $$a;
                        byte b21 = bArr6[21];
                        Object[] objArr37 = new Object[1];
                        a(b21, (byte) (-bArr6[8]), b21, objArr37);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(packedPositionType, cRgb, iIndexOf2, 721586079, false, (String) objArr37[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr38 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(4) - 112, new char[]{40653, 40615, 43814, 48683, 50377, 24897, 979, 19736, 8411, 59747, 64628, 3935, 58074, 12057, 15006, 51376, 42006, 28299, 30944, 35564}, objArr38);
            Class<?> cls10 = Class.forName((String) objArr38[0]);
            Object[] objArr39 = new Object[1];
            b((-1) - TextUtils.indexOf((CharSequence) "", '0', 0), new char[]{59314, 59355, 37882, 47220, 64528, 26381, 4656, 23796, 23038, 53695, 64045, 7851, 39818, 6031, 15602, 55618, 56665, 22089, 32429, 39687}, objArr39);
            Object[] objArr310 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr39[0], Object.class).invoke(null, this)).intValue()), 0, -412970208};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame4 == null) {
                int iIndexOf3 = 24 - TextUtils.indexOf((CharSequence) "", '0', 0);
                char cMakeMeasureSpec2 = (char) (30068 - View.MeasureSpec.makeMeasureSpec(0, 0));
                int edgeSlop2 = (ViewConfiguration.getEdgeSlop() >> 16) + 816;
                byte b110 = (byte) ($$a[21] - 1);
                byte b111 = b110;
                Object[] objArr311 = new Object[1];
                a(b110, b111, b111, objArr311);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iIndexOf3, cMakeMeasureSpec2, edgeSlop2, -797394565, false, (String) objArr311[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr310);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame5 == null) {
                int iRgb3 = Color.rgb(0, 0, 0) + 16777241;
                char touchSlop3 = (char) ((ViewConfiguration.getTouchSlop() >> 8) + 30068);
                int bitsPerPixel2 = 815 - ImageFormat.getBitsPerPixel(0);
                byte b112 = $$a[21];
                byte b22 = b112;
                Object[] objArr312 = new Object[1];
                a(b112, b22, b22, objArr312);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iRgb3, touchSlop3, bitsPerPixel2, 891606461, false, (String) objArr312[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr);
            Object[] objArr313 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35, new char[]{9061, 8964, 21725, 54387, 15165, 2827, 17123, 3131, 40242, 5778, 38459, 20015, 24442, 53424, 20649, 35242, 6580, 37240, 4795, 52180, 56296, 21264, 56475, 1286, 37918, 7664}, objArr313);
            Class<?> cls11 = Class.forName((String) objArr313[0]);
            Object[] objArr314 = new Object[1];
            b(TextUtils.indexOf("", "", 0, 0), new char[]{55428, 55521, 34304, 44115, 59874, 29486, 48238, 62132, 26319, 50241, 60958, 45278, 42129, 637, 10446, 30464, 57925, 17337, 27279}, objArr314);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr314[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame6 == null) {
                int packedPositionType2 = 25 - ExpandableListView.getPackedPositionType(0L);
                char cRgb2 = (char) (Color.rgb(0, 0, 0) + 16807284);
                int iIndexOf4 = 815 - TextUtils.indexOf((CharSequence) "", '0', 0);
                byte[] bArr7 = $$a;
                byte b23 = bArr7[21];
                Object[] objArr315 = new Object[1];
                a(b23, (byte) (-bArr7[8]), b23, objArr315);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(packedPositionType2, cRgb2, iIndexOf4, 721586079, false, (String) objArr315[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i36 = ((int[]) objArr[1])[0];
        int i37 = ((int[]) objArr[0])[0];
        if (i37 == i36) {
            Object[] objArr40 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i38 = ((int[]) objArr[3])[0];
            int i39 = ((int[]) objArr[0])[0];
            int i40 = ((int[]) objArr[1])[0];
            String[] strArr6 = (String[]) objArr[2];
            int i41 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().densityDpi;
            int i42 = ~i41;
            int i43 = i38 + 214920980 + (((~((-1036706349) | i42)) | (~(838533982 | i42))) * (-867)) + (((~((-1036706349) | i41)) | 201383968 | (~(838533982 | i41))) * (-1734)) + (((~(i41 | 1039917950)) | (~(i42 | (-201383969))) | (~((-835322381) | i41))) * 867);
            int i44 = (i43 << 13) ^ i43;
            int i45 = i44 ^ (i44 >>> 17);
            ((int[]) objArr40[3])[0] = i45 ^ (i45 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArr[2];
        if (strArr7 != null) {
            for (String str2 : strArr7) {
                arrayList2.add(str2);
            }
        }
        long j5 = ((long) (i36 ^ i37)) ^ (((long) 1943761239) << 32);
        long j6 = 1943761238;
        int i46 = getARTIFICIAL_FRAME_PACKAGE_NAME + 95;
        artificialFrame = i46 % 128;
        int i47 = i46 % 2;
        Object[] objArr41 = {Long.valueOf(j5), Long.valueOf(j6)};
        byte[] bArr8 = $$d;
        byte b24 = bArr8[5];
        Object[] objArr42 = new Object[1];
        c(b24, b24, (byte) (-bArr8[19]), objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        int i48 = $$e;
        Object[] objArr43 = new Object[1];
        c((byte) (i48 | 9), bArr8[13], (byte) (i48 | 37), objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
        int i49 = ((int[]) objArr[3])[0];
        int i50 = ((int[]) objArr[0])[0];
        int i51 = ((int[]) objArr[1])[0];
        String[] strArr8 = (String[]) objArr[2];
        int iIdentityHashCode4 = System.identityHashCode(this);
        int i52 = (-629749629) + ((iIdentityHashCode4 | 692102384) * (-50));
        int i53 = ~((-536879313) | iIdentityHashCode4);
        int i54 = ~iIdentityHashCode4;
        int i55 = i49 + i52 + ((i53 | (~(1030809330 | i54))) * 50) + (((~(i54 | 692102384)) | (~(493930018 | i54)) | (-1030809331)) * 50);
        int i56 = (i55 << 13) ^ i55;
        int i57 = i56 ^ (i56 >>> 17);
        ((int[]) objArr44[3])[0] = i57 ^ (i57 << 5);
    }

    static void accessartificialFrame() {
        onPostMessage = -4994585869805536050L;
    }
}
