package app.notifee.core;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.RemoteInput;
import app.notifee.core.event.NotificationEvent;
import app.notifee.core.model.NotificationAndroidModel;
import app.notifee.core.model.NotificationAndroidPressActionModel;
import app.notifee.core.model.NotificationModel;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.appevents.ondeviceprocessing.RemoteServiceWrapper;
import com.google.android.gms.dynamite.zza;
import com.google.common.base.Ascii;
import com.transistorsoft.locationmanager.config.TSNotification;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import n.o.t.i.f.e.e.e;
import n.o.t.i.f.e.e.f;
import n.o.t.i.f.e.e.g;
import n.o.t.i.f.e.e.h;
import n.o.t.i.f.e.e.i;
import o.ArtificialStackFrames;
import o.onRelationshipValidationResult;
import org.apache.commons.lang3.CharEncoding;
import org.joda.time.LocalDateTime;

/* JADX INFO: loaded from: classes4.dex */
public class ReceiverService extends Service {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    public static final AtomicInteger a;
    private static int artificialFrame;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static long onPostMessage;
    private static final byte[] $$c = {Ascii.EM, 104, 41, -86};
    private static final int $$f = 85;
    private static int $10 = 0;
    private static int $11 = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0026). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(byte r6, byte r7, short r8) {
        /*
            byte[] r0 = app.notifee.core.ReceiverService.$$c
            int r8 = r8 * 3
            int r8 = r8 + 1
            int r6 = r6 * 4
            int r6 = 111 - r6
            int r7 = r7 * 3
            int r7 = 4 - r7
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r8
            r4 = r2
            goto L26
        L16:
            r3 = r2
        L17:
            int r4 = r3 + 1
            byte r5 = (byte) r6
            r1[r3] = r5
            if (r4 != r8) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L24:
            r3 = r0[r7]
        L26:
            int r7 = r7 + 1
            int r6 = r6 + r3
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: app.notifee.core.ReceiverService.$$g(byte, byte, short):java.lang.String");
    }

    static {
        byte[] bArr = new byte[674];
        System.arraycopy("@à(\u0099\u0003\u0002óÿ\u0003<\u0004Äúù\u000eò\u0003\fô=¶\u0003DÛì\u0003ô\u0014ñ\u0002\u000eã\u000b÷\u0005ðOÌä\bô\u000eò\u001dòí\u0007ÿÂó\u0001>Æ÷ÿ\u0007ú\u00066Êðø\bû\u0004@¹\nú\u0002<Ìû\u0003ü5ìÛñ-ãè,åëTòó\u0001>º\u0011ô\u0006ñ\föü\u000eý6À\u000bî\u0006\u0005ð\nú\u0006\u0003öüù\u00105¸\u0000\nü=Æóü\u0002ù\u0000\nú\b!Ð\f\u0003ì\nù\u0000ó\u0001>Ç\u0004ýý\u0002òÿ\u0003<Ìðÿ\u0003\u0002ú\u0002÷DìÐÿ#âú\u0002&âì\u0012<òó\u0001>Æ÷ÿ\u0007ú\u00066Êó\u0001ÿý\u0000?Ë\u0000í\r6ÝÝ\f\u0001ó\u0000\túô\nù\u0000úó\u0001>Ç\u0004ýý\u0002òÿ\u0003<»\f\u0003ýîE¸\u000bû\u000bò\fù\u0001òCÔé\u0007\u0005\u0012Þ\nþ\u0014àÿ\u0002GÿÞÌ\u0003\u000eò\u0003\fô\u0018Ù\nù\u000b\u0002ð\n\u0005\u0016êó\ný\u00020ó\u0001>Æ÷ÿ\u0007ú\u00066Êðø\bû\u0004@¹\nú\u0002<ºþ\u0001\f\u0003ó\u0003ú\u0006\u0005û\u0003ü5Äúù\u000eò\u0003\fô=ìÛñ+ãõ$Ü\u0006ý\u0012Þ\u0001\f\u0003ó\u0003ú\u0006\u0016Ý\u0002ú\u0004\u001bíò\b\u0007ô\u0002î\u0018ì\nù\u0000IÿÞÌ\u0003\u000eò\u0003\fô\u0018Ù\nù\u000b\u0002ð\n\u0005\u0016êó\ný\u0002/Óü\u0002ù\u0000\nú\b Þ\u0002ì\rÿýú\u0006\u001bÖó\u0001>¹\u0001\u0010òú\tõþ\u0004üþ\u0003\bñEÁü\u000b\u0001ì\nù\u0000\u0000\u000bò\fù\u0001òCÁü\u0007ÿ\u0001òCÙ\u0000ÿ\u0001\u0004âô\u000e#Ðÿ\nö\tþòMÀûú\u0007\u0002úõIÊóü\u0002ù\u0000\nú\bñDÇùü÷HçÙü÷+Ö\u0014ÿ\u001aÞø\nç-ÖO¿þ\u0002òù\u0006\ný\u001bÚù\u000eò\u0003\fôGò\f\u00ad\u0014ôö\u000fñNòýÿýñÿ\u0011îý\n\u0002ü\u0005ù\u0007ô%Ó\u0010ó\u0007ú9¼\u0001ûDÁü\u0007\u0004\u0000ý÷<Êóü\f6º\u0002\u0006:êÉ\u0015ö\u0002\u0005 Ì\u000eÿ\u0000ò\u001dá\u0010ý÷\u0005òó\u0001>Æ÷ÿ\u0007ú\u00066½ý\u0002ú\u0004\fì\u000e7Øæ\u0000ý\nú\u0002ü\u0007þõ\u0006\u0018êæ\u0000%Þ\u0001\bú\u0006\u001aâõþó\u0001>Åþô\u0012ýúþ\u0007ðÿAÈì\u0014ýôû\nù\u0000úDàÓ5Ù\u0005ýò\u0002)Ì\u0014ýôû\nù\u0000".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 674);
        $$d = bArr;
        $$e = 63;
        $$a = new byte[]{Ascii.ESC, -99, -92, 1, 5, -1, -33, 33, -2, -9, 5, -7, 5, -1, -50, 39, Ascii.VT, -7, -12, Ascii.SI, Ascii.ESC, 1, -7, -6, -33, 51, -12, 3, -8, 1, Ascii.CR, -9, Ascii.DC2, -34, Ascii.EM, 4, -17, 19, -15, -1, -18, Ascii.SI, 19, -11, 5, -7, -2, Ascii.SI, -36, Ascii.NAK, Ascii.CR, -15, 2, 9, 6, -34, Ascii.SI, 19, -11, 5, -7, -2, Ascii.SI, -33, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, 10, -31, Ascii.DC4, Ascii.CR, -8, -11, -13, Ascii.ESC, -9, Ascii.DC2, -36, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, -7, Ascii.DC2, -43, Ascii.GS, -4, 17, 2, 49, 2, -11, -3, 3, -6, 6, -8, Ascii.VT, -25, 33, -19, 2, 8, -37, 44, -17, Ascii.FF, -8, Ascii.SO};
        $$b = 199;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        accessartificialFrame();
        a = new AtomicInteger(0);
    }

    public static PendingIntent a(String str, String[] strArr, Bundle... bundleArr) {
        Context context = e.a;
        Intent intent = new Intent(context, (Class<?>) ReceiverService.class);
        intent.setAction(str);
        for (int i = 0; i < strArr.length; i++) {
            String str2 = strArr[i];
            if (i <= bundleArr.length - 1) {
                intent.putExtra(str2, bundleArr[i]);
            } else {
                intent.putExtra(str2, (String) null);
            }
        }
        return PendingIntent.getService(context, a.getAndIncrement(), intent, 167772160);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    /* JADX WARN: Code duplicated, block: B:8:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0028). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(short r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = app.notifee.core.ReceiverService.$$a
            int r7 = r7 + 4
            int r6 = 21 - r6
            int r8 = r8 + 65
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L11
            r3 = r8
            r4 = r2
            r8 = r7
            goto L28
        L11:
            r3 = r2
        L12:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r6) goto L21
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L21:
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r5
        L28:
            int r7 = r7 + r3
            int r8 = r8 + 1
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: app.notifee.core.ReceiverService.b(short, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void d(int r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = 111 - r6
            int r7 = 631 - r7
            int r0 = r8 + 3
            byte[] r1 = app.notifee.core.ReceiverService.$$d
            byte[] r0 = new byte[r0]
            int r8 = r8 + 2
            r2 = -1
            if (r1 != 0) goto L12
            r3 = r7
            r4 = r2
            goto L2b
        L12:
            r3 = r2
        L13:
            int r3 = r3 + 1
            int r7 = r7 + 1
            byte r4 = (byte) r6
            r0[r3] = r4
            if (r3 != r8) goto L25
            java.lang.String r6 = new java.lang.String
            r7 = 0
            r6.<init>(r0, r7)
            r9[r7] = r6
            return
        L25:
            r4 = r1[r7]
            r5 = r3
            r3 = r7
            r7 = r4
            r4 = r5
        L2b:
            int r7 = -r7
            int r6 = r6 + r7
            int r6 = r6 + r2
            r7 = r3
            r3 = r4
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: app.notifee.core.ReceiverService.d(int, int, byte, java.lang.Object[]):void");
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x003c  */
    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        byte b;
        CharSequence charSequence;
        Bundle bundleExtra;
        NotificationAndroidPressActionModel notificationAndroidPressActionModelFromBundle;
        String action = intent.getAction();
        if (action == null) {
            return 2;
        }
        int iHashCode = action.hashCode();
        if (iHashCode != -2049703147) {
            if (iHashCode != -2034314204) {
                if (iHashCode == -1961135292 && action.equals("app.notifee.core.ReceiverService.PRESS_INTENT")) {
                    b = 2;
                } else {
                    b = -1;
                }
            } else if (action.equals("app.notifee.core.ReceiverService.DELETE_INTENT")) {
                b = 1;
            } else {
                b = -1;
            }
        } else if (action.equals("app.notifee.core.ReceiverService.ACTION_PRESS_INTENT")) {
            b = 0;
        } else {
            b = -1;
        }
        if (b == 0) {
            Bundle bundleExtra2 = intent.getBundleExtra(TSNotification.NAME);
            Bundle bundleExtra3 = intent.getBundleExtra("pressAction");
            if (bundleExtra2 != null && bundleExtra3 != null) {
                NotificationModel notificationModel = new NotificationModel(bundleExtra2);
                NotificationAndroidModel notificationAndroidModelA = notificationModel.a();
                NotificationAndroidPressActionModel notificationAndroidPressActionModelFromBundle2 = NotificationAndroidPressActionModel.fromBundle(bundleExtra3);
                Bundle bundle = new Bundle();
                bundle.putBundle("pressAction", notificationAndroidPressActionModelFromBundle2.toBundle());
                Bundle resultsFromIntent = RemoteInput.getResultsFromIntent(intent);
                if (resultsFromIntent != null && (charSequence = resultsFromIntent.getCharSequence("app.notifee.core.ReceiverService.REMOTE_INPUT_RECEIVER_KEY")) != null) {
                    bundle.putString("input", charSequence.toString());
                }
                f.a(new NotificationEvent(2, notificationModel, bundle));
                if (notificationModel.a().getAutoCancel().booleanValue()) {
                    NotificationManagerCompat.from(getApplicationContext()).cancel(notificationAndroidModelA.getTag(), notificationModel.c().hashCode());
                }
                String launchActivity = notificationAndroidPressActionModelFromBundle2.getLaunchActivity();
                String mainComponent = notificationAndroidPressActionModelFromBundle2.getMainComponent();
                if (launchActivity != null || mainComponent != null) {
                    a(new g(notificationModel, bundle), launchActivity, mainComponent, notificationAndroidPressActionModelFromBundle2.getLaunchActivityFlags());
                    int i3 = e.a.getApplicationInfo().targetSdkVersion;
                    if (Build.VERSION.SDK_INT < 31) {
                        e.a.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
                    }
                }
            }
        } else if (b == 1) {
            Bundle bundleExtra4 = intent.getBundleExtra(TSNotification.NAME);
            if (bundleExtra4 != null) {
                f.a(new NotificationEvent(0, new NotificationModel(bundleExtra4)));
            }
        } else if (b == 2 && (bundleExtra = intent.getBundleExtra(TSNotification.NAME)) != null) {
            NotificationModel notificationModel2 = new NotificationModel(bundleExtra);
            Bundle bundleExtra5 = intent.getBundleExtra("pressAction");
            Bundle bundle2 = new Bundle();
            if (bundleExtra5 != null) {
                notificationAndroidPressActionModelFromBundle = NotificationAndroidPressActionModel.fromBundle(bundleExtra5);
                bundle2.putBundle("pressAction", notificationAndroidPressActionModelFromBundle.toBundle());
            } else {
                notificationAndroidPressActionModelFromBundle = null;
            }
            f.a(new NotificationEvent(1, notificationModel2, bundle2));
            if (notificationAndroidPressActionModelFromBundle != null) {
                String launchActivity2 = notificationAndroidPressActionModelFromBundle.getLaunchActivity();
                String mainComponent2 = notificationAndroidPressActionModelFromBundle.getMainComponent();
                if (launchActivity2 != null || mainComponent2 != null) {
                    a(new g(notificationModel2, bundle2), launchActivity2, mainComponent2, notificationAndroidPressActionModelFromBundle.getLaunchActivityFlags());
                }
            }
        }
        return 2;
    }

    public final void a(g gVar, @Nullable String str, @Nullable String str2, int i) {
        Class<?> clsA = h.a(str);
        if (clsA == null) {
            Logger.e(RemoteServiceWrapper.RECEIVER_SERVICE_ACTION, "Failed to get launch activity");
            return;
        }
        Intent intent = new Intent(getApplicationContext(), clsA);
        if (i != -1) {
            intent.addFlags(i);
        }
        if (str2 != null) {
            intent.putExtra("mainComponent", str2);
        }
        try {
            PendingIntent.getActivity(getApplicationContext(), gVar.a.b().intValue(), intent, 167772160).send();
            f.b(gVar);
            if (str2 != null) {
                f.b(new i(str2));
            }
        } catch (Exception e) {
            Logger.e(RemoteServiceWrapper.RECEIVER_SERVICE_ACTION, "Failed to send PendingIntent from launchPendingIntentActivity for notification " + gVar.a.c(), e);
        }
    }

    private static void c(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        onRelationshipValidationResult onrelationshipvalidationresult = new onRelationshipValidationResult();
        char[] cArrAccessartificialFrame = onRelationshipValidationResult.accessartificialFrame(onPostMessage ^ 2573525503365829440L, cArr, i);
        onrelationshipvalidationresult.e = 4;
        int i3 = $10 + 23;
        $11 = i3 % 128;
        int i4 = i3 % 2;
        while (onrelationshipvalidationresult.e < cArrAccessartificialFrame.length) {
            int i5 = $11 + 101;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            onrelationshipvalidationresult.d = onrelationshipvalidationresult.e - 4;
            int i7 = onrelationshipvalidationresult.e;
            try {
                Object[] objArr2 = {Long.valueOf(cArrAccessartificialFrame[onrelationshipvalidationresult.e] ^ cArrAccessartificialFrame[onrelationshipvalidationresult.e % 4]), Long.valueOf(onrelationshipvalidationresult.d), Long.valueOf(onPostMessage)};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(797310229);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0') + 28, (char) (30691 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), 187 - ((byte) KeyEvent.getModifierMetaStateMask()), -1327449315, false, "k", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                }
                cArrAccessartificialFrame[i7] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                Object[] objArr3 = {onrelationshipvalidationresult, onrelationshipvalidationresult};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(321542193);
                if (objAccessartificialFrame2 == null) {
                    byte b = (byte) 0;
                    byte b2 = b;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(MotionEvent.axisFromString("") + 34, (char) (ViewConfiguration.getFadingEdgeLength() >> 16), (-16775733) - Color.rgb(0, 0, 0), -1940971975, false, $$g(b, b2, b2), new Class[]{Object.class, Object.class});
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

    /* JADX WARN: Code duplicated, block: B:14:0x0180  */
    /* JADX WARN: Code duplicated, block: B:17:0x020b A[Catch: all -> 0x09e7, TryCatch #0 {all -> 0x09e7, blocks: (B:52:0x06c0, B:54:0x06e1, B:55:0x0737, B:15:0x01f7, B:17:0x020b, B:18:0x0239), top: B:93:0x01f7 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x024f  */
    /* JADX WARN: Code duplicated, block: B:26:0x030a  */
    /* JADX WARN: Code duplicated, block: B:51:0x065b  */
    /* JADX WARN: Code duplicated, block: B:54:0x06e1 A[Catch: all -> 0x09e7, TryCatch #0 {all -> 0x09e7, blocks: (B:52:0x06c0, B:54:0x06e1, B:55:0x0737, B:15:0x01f7, B:17:0x020b, B:18:0x0239), top: B:93:0x01f7 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0749  */
    /* JADX WARN: Code duplicated, block: B:63:0x0829  */
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
            int iAxisFromString = MotionEvent.axisFromString("") + 27;
            char cIndexOf = (char) TextUtils.indexOf("", "");
            int iMakeMeasureSpec = 1041 - View.MeasureSpec.makeMeasureSpec(0, 0);
            byte[] bArr = $$a;
            byte b = bArr[117];
            byte b2 = (byte) (bArr[3] - 1);
            Object[] objArr2 = new Object[1];
            b(b, b2, (byte) (b2 | 47), objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iAxisFromString, cIndexOf, iMakeMeasureSpec, 2061780482, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 4611686018427387796L;
            Object[] objArr3 = new Object[1];
            c((ViewConfiguration.getFadingEdgeLength() >> 16) + 1, new char[]{22249, 24611, 22152, 46174, 43994, 920, 2652, 1738, 17429, 21452, 30231, 47804, 63006, 5371, 58186, 27285, 42612, 42151, 12964, 7023, 6068, 29987, 17120, 51985, 51190, 1479}, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            c((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), new char[]{56582, 31833, 56675, 43046, 61508, 22531, 48476, 36153, 22627, 2130, 49429, 3522, 32251, 2195, 47254, 56752, 11659, 47299, 26923}, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame8 == null) {
                    int scrollDefaultDelay = 26 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                    char c = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                    int scrollDefaultDelay2 = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 1041;
                    byte[] bArr2 = $$a;
                    byte b3 = bArr2[117];
                    byte b4 = bArr2[113];
                    Object[] objArr5 = new Object[1];
                    b(b3, b4, (byte) (b4 | 39), objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(scrollDefaultDelay, c, scrollDefaultDelay2, 1145017376, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i2 = ((int[]) objArr6[3])[0];
                int i3 = ((int[]) objArr6[2])[0];
                String[] strArr = (String[]) objArr6[0];
                int ringerMode = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getRingerMode();
                int i4 = ~ringerMode;
                int i5 = ((((-1166362852) + (((-75565833) | i4) * (-369))) + (((~((-696046728) | i4)) | (-617942921)) * (-369))) + ((((~(ringerMode | 696046727)) | (-771612560)) | (~(i4 | (-542377089)))) * 369)) - 1878230208;
                int i6 = (i5 << 13) ^ i5;
                int i7 = i6 ^ (i6 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i7 ^ (i7 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 34, new char[]{878, 8432, 772, 62594, 26359, 52903, 62170, 21260, 1219, 40676, 36482, 17001, 41873, 21621, 11802, 37418, 62457, 58483, 65432, 58354}, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 34, new char[]{6565, 10515, 6604, 64868, 21000, 64075, 58778, 18845, 3365, 43534, 39373, 21809, 47477, 24025, 6853, 34164, 59650, 60811, 52070, 62645}, objArr8);
                int iIntValue = ((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue();
                try {
                    Object[] objArr9 = {-424209113};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(8 - TextUtils.getOffsetAfter("", 0), (char) ((ViewConfiguration.getEdgeSlop() >> 16) + 22251), 1033 - (Process.myTid() >> 22), 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = LocalDateTime.Property.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr9), -1878230208, false);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame2 == null) {
                        int i8 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 25;
                        char c2 = (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                        int i9 = 1041 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                        byte[] bArr3 = $$a;
                        byte b5 = bArr3[117];
                        byte b6 = bArr3[113];
                        Object[] objArr10 = new Object[1];
                        b(b5, b6, (byte) (b6 | 39), objArr10);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i8, c2, i9, 1145017376, false, (String) objArr10[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
                    try {
                        Object[] objArr11 = new Object[1];
                        c(-TextUtils.lastIndexOf("", '0'), new char[]{22249, 24611, 22152, 46174, 43994, 920, 2652, 1738, 17429, 21452, 30231, 47804, 63006, 5371, 58186, 27285, 42612, 42151, 12964, 7023, 6068, 29987, 17120, 51985, 51190, 1479}, objArr11);
                        Class<?> cls3 = Class.forName((String) objArr11[0]);
                        Object[] objArr12 = new Object[1];
                        c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 48, new char[]{56582, 31833, 56675, 43046, 61508, 22531, 48476, 36153, 22627, 2130, 49429, 3522, 32251, 2195, 47254, 56752, 11659, 47299, 26923}, objArr12);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr12[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame3 == null) {
                            int minimumFlingVelocity = 26 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                            char longPressTimeout = (char) (ViewConfiguration.getLongPressTimeout() >> 16);
                            int trimmedLength = TextUtils.getTrimmedLength("") + 1041;
                            byte[] bArr4 = $$a;
                            byte b7 = bArr4[117];
                            byte b8 = (byte) (bArr4[3] - 1);
                            Object[] objArr13 = new Object[1];
                            b(b7, b8, (byte) (b8 | 47), objArr13);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity, longPressTimeout, trimmedLength, 2061780482, false, (String) objArr13[0], null);
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
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 34, new char[]{878, 8432, 772, 62594, 26359, 52903, 62170, 21260, 1219, 40676, 36482, 17001, 41873, 21621, 11802, 37418, 62457, 58483, 65432, 58354}, objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 34, new char[]{6565, 10515, 6604, 64868, 21000, 64075, 58778, 18845, 3365, 43534, 39373, 21809, 47477, 24025, 6853, 34164, 59650, 60811, 52070, 62645}, objArr15);
            int iIntValue2 = ((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr16 = {-424209113};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(8 - TextUtils.getOffsetAfter("", 0), (char) ((ViewConfiguration.getEdgeSlop() >> 16) + 22251), 1033 - (Process.myTid() >> 22), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = LocalDateTime.Property.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr16), -1878230208, false);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame2 == null) {
                int i10 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 25;
                char c3 = (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                int i11 = 1041 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                byte[] bArr5 = $$a;
                byte b9 = bArr5[117];
                byte b10 = bArr5[113];
                Object[] objArr17 = new Object[1];
                b(b9, b10, (byte) (b10 | 39), objArr17);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i10, c3, i11, 1145017376, false, (String) objArr17[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr18 = new Object[1];
            c(-TextUtils.lastIndexOf("", '0'), new char[]{22249, 24611, 22152, 46174, 43994, 920, 2652, 1738, 17429, 21452, 30231, 47804, 63006, 5371, 58186, 27285, 42612, 42151, 12964, 7023, 6068, 29987, 17120, 51985, 51190, 1479}, objArr18);
            Class<?> cls5 = Class.forName((String) objArr18[0]);
            Object[] objArr19 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 48, new char[]{56582, 31833, 56675, 43046, 61508, 22531, 48476, 36153, 22627, 2130, 49429, 3522, 32251, 2195, 47254, 56752, 11659, 47299, 26923}, objArr19);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr19[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame3 == null) {
                int minimumFlingVelocity2 = 26 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                char longPressTimeout2 = (char) (ViewConfiguration.getLongPressTimeout() >> 16);
                int trimmedLength2 = TextUtils.getTrimmedLength("") + 1041;
                byte[] bArr6 = $$a;
                byte b11 = bArr6[117];
                byte b12 = (byte) (bArr6[3] - 1);
                Object[] objArr110 = new Object[1];
                b(b11, b12, (byte) (b12 | 47), objArr110);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity2, longPressTimeout2, trimmedLength2, 2061780482, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i12 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i13 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i13 == i12) {
            int i14 = artificialFrame + 67;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i14 % 128;
            int i15 = i14 % 2;
            Object[] objArr20 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i16 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i17 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i18 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int i19 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 1851727353;
            int i20 = i16 + (-603951386) + (((~((-265218) | i19)) | 78369024) * (-756)) + (((~i19) | (-265218)) * 756);
            int i21 = (i20 << 13) ^ i20;
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
            long j3 = (((long) (-1426126487)) << 32) ^ ((long) (i12 ^ i13));
            long j4 = -1426126485;
            int i23 = artificialFrame + 77;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i23 % 128;
            int i24 = i23 % 2;
            try {
                Object[] objArr21 = {Long.valueOf(j3), Long.valueOf(j4)};
                byte[] bArr7 = $$d;
                byte b13 = bArr7[117];
                Object[] objArr22 = new Object[1];
                d(b13, (short) (b13 | 628), bArr7[665], objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                d((byte) 75, (short) 585, bArr7[117], objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i25 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i26 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i27 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int iIdentityHashCode = System.identityHashCode(this);
                int i28 = ~(620939140 | iIdentityHashCode);
                int i29 = i25 + (-450864068) + (((-626771846) | i28) * (-814)) + ((i28 | (~((~iIdentityHashCode) | 542835333)) | 537002628) * 407) + (((~(iIdentityHashCode | (-542835334))) | (~((-620939141) | iIdentityHashCode)) | 537002628) * 407);
                int i30 = (i29 << 13) ^ i29;
                int i31 = i30 ^ (i30 >>> 17);
                ((int[]) objArr24[1])[0] = i31 ^ (i31 << 5);
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
            int gidForName = 24 - Process.getGidForName("");
            char modifierMetaStateMask = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 30069);
            int iKeyCodeFromString = KeyEvent.keyCodeFromString("") + 816;
            byte[] bArr8 = $$a;
            byte b14 = bArr8[117];
            byte b15 = (byte) (bArr8[3] - 1);
            Object[] objArr25 = new Object[1];
            b(b14, b15, (byte) (b15 | 47), objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(gidForName, modifierMetaStateMask, iKeyCodeFromString, 721586079, false, (String) objArr25[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j5 != -1) {
            long j6 = j5 + 2044;
            Object[] objArr26 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 114, new char[]{22249, 24611, 22152, 46174, 43994, 920, 2652, 1738, 17429, 21452, 30231, 47804, 63006, 5371, 58186, 27285, 42612, 42151, 12964, 7023, 6068, 29987, 17120, 51985, 51190, 1479}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 34, new char[]{56582, 31833, 56675, 43046, 61508, 22531, 48476, 36153, 22627, 2130, 49429, 3522, 32251, 2195, 47254, 56752, 11659, 47299, 26923}, objArr27);
            if (j6 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i32 = artificialFrame + 37;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i32 % 128;
                int i33 = i32 % 2;
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame10 == null) {
                    int minimumFlingVelocity3 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 25;
                    char cRed = (char) (Color.red(0) + 30068);
                    int maximumDrawingCacheSize = 816 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                    byte[] bArr9 = $$a;
                    byte b16 = bArr9[117];
                    byte b17 = bArr9[113];
                    Object[] objArr28 = new Object[1];
                    b(b16, b17, (byte) (b17 | 39), objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity3, cRed, maximumDrawingCacheSize, 891606461, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i34 = ((int[]) objArr29[0])[0];
                int i35 = ((int[]) objArr29[1])[0];
                String[] strArr5 = (String[]) objArr29[2];
                int iIdentityHashCode2 = System.identityHashCode(this);
                int i36 = ~iIdentityHashCode2;
                int i37 = (((-1018310497) + (((~(137739425 | i36)) | (~((-335911792) | iIdentityHashCode2))) * 210)) + (((~(iIdentityHashCode2 | 473284591)) | (~(i36 | (-366626)))) * 210)) - 1950423193;
                int i38 = (i37 << 13) ^ i37;
                int i39 = i38 ^ (i38 >>> 17);
                ((int[]) objArr[3])[0] = i39 ^ (i39 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                c((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 1, new char[]{878, 8432, 772, 62594, 26359, 52903, 62170, 21260, 1219, 40676, 36482, 17001, 41873, 21621, 11802, 37418, 62457, 58483, 65432, 58354}, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 20, new char[]{6565, 10515, 6604, 64868, 21000, 64075, 58778, 18845, 3365, 43534, 39373, 21809, 47477, 24025, 6853, 34164, 59650, 60811, 52070, 62645}, objArr31);
                Object[] objArr32 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue()), 0, -1950423193};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame4 == null) {
                    int i40 = 26 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                    char capsMode = (char) (TextUtils.getCapsMode("", 0, 0) + 30068);
                    int iMyTid = 816 - (Process.myTid() >> 22);
                    byte[] bArr10 = $$a;
                    Object[] objArr33 = new Object[1];
                    b(bArr10[53], (byte) (bArr10[66] - 1), bArr10[37], objArr33);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i40, capsMode, iMyTid, -797394565, false, (String) objArr33[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr32);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame5 == null) {
                    int i41 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 24;
                    char windowTouchSlop = (char) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 30068);
                    int defaultSize = 816 - View.getDefaultSize(0, 0);
                    byte[] bArr11 = $$a;
                    byte b18 = bArr11[117];
                    byte b19 = bArr11[113];
                    Object[] objArr34 = new Object[1];
                    b(b18, b19, (byte) (b19 | 39), objArr34);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i41, windowTouchSlop, defaultSize, 891606461, false, (String) objArr34[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr);
                try {
                    Object[] objArr35 = new Object[1];
                    c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 3, new char[]{22249, 24611, 22152, 46174, 43994, 920, 2652, 1738, 17429, 21452, 30231, 47804, 63006, 5371, 58186, 27285, 42612, 42151, 12964, 7023, 6068, 29987, 17120, 51985, 51190, 1479}, objArr35);
                    Class<?> cls9 = Class.forName((String) objArr35[0]);
                    Object[] objArr36 = new Object[1];
                    c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 3, new char[]{56582, 31833, 56675, 43046, 61508, 22531, 48476, 36153, 22627, 2130, 49429, 3522, 32251, 2195, 47254, 56752, 11659, 47299, 26923}, objArr36);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr36[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame6 == null) {
                        int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 25;
                        char c4 = (char) ((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 30068);
                        int mode = 816 - View.MeasureSpec.getMode(0);
                        byte[] bArr12 = $$a;
                        byte b20 = bArr12[117];
                        byte b21 = (byte) (bArr12[3] - 1);
                        Object[] objArr37 = new Object[1];
                        b(b20, b21, (byte) (b21 | 47), objArr37);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay, c4, mode, 721586079, false, (String) objArr37[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr38 = new Object[1];
            c((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 1, new char[]{878, 8432, 772, 62594, 26359, 52903, 62170, 21260, 1219, 40676, 36482, 17001, 41873, 21621, 11802, 37418, 62457, 58483, 65432, 58354}, objArr38);
            Class<?> cls10 = Class.forName((String) objArr38[0]);
            Object[] objArr39 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 20, new char[]{6565, 10515, 6604, 64868, 21000, 64075, 58778, 18845, 3365, 43534, 39373, 21809, 47477, 24025, 6853, 34164, 59650, 60811, 52070, 62645}, objArr39);
            Object[] objArr310 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr39[0], Object.class).invoke(null, this)).intValue()), 0, -1950423193};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame4 == null) {
                int i42 = 26 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                char capsMode2 = (char) (TextUtils.getCapsMode("", 0, 0) + 30068);
                int iMyTid2 = 816 - (Process.myTid() >> 22);
                byte[] bArr13 = $$a;
                Object[] objArr311 = new Object[1];
                b(bArr13[53], (byte) (bArr13[66] - 1), bArr13[37], objArr311);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i42, capsMode2, iMyTid2, -797394565, false, (String) objArr311[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr310);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame5 == null) {
                int i43 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 24;
                char windowTouchSlop2 = (char) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 30068);
                int defaultSize2 = 816 - View.getDefaultSize(0, 0);
                byte[] bArr14 = $$a;
                byte b110 = bArr14[117];
                byte b111 = bArr14[113];
                Object[] objArr312 = new Object[1];
                b(b110, b111, (byte) (b111 | 39), objArr312);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i43, windowTouchSlop2, defaultSize2, 891606461, false, (String) objArr312[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr);
            Object[] objArr313 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 3, new char[]{22249, 24611, 22152, 46174, 43994, 920, 2652, 1738, 17429, 21452, 30231, 47804, 63006, 5371, 58186, 27285, 42612, 42151, 12964, 7023, 6068, 29987, 17120, 51985, 51190, 1479}, objArr313);
            Class<?> cls11 = Class.forName((String) objArr313[0]);
            Object[] objArr314 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 3, new char[]{56582, 31833, 56675, 43046, 61508, 22531, 48476, 36153, 22627, 2130, 49429, 3522, 32251, 2195, 47254, 56752, 11659, 47299, 26923}, objArr314);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr314[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame6 == null) {
                int keyRepeatDelay2 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 25;
                char c5 = (char) ((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 30068);
                int mode2 = 816 - View.MeasureSpec.getMode(0);
                byte[] bArr15 = $$a;
                byte b22 = bArr15[117];
                byte b23 = (byte) (bArr15[3] - 1);
                Object[] objArr315 = new Object[1];
                b(b22, b23, (byte) (b23 | 47), objArr315);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay2, c5, mode2, 721586079, false, (String) objArr315[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i44 = ((int[]) objArr[1])[0];
        int i45 = ((int[]) objArr[0])[0];
        if (i45 == i44) {
            Object[] objArr40 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i46 = ((int[]) objArr[3])[0];
            int i47 = ((int[]) objArr[0])[0];
            int i48 = ((int[]) objArr[1])[0];
            String[] strArr6 = (String[]) objArr[2];
            int streamMaxVolume = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getStreamMaxVolume(3);
            int i49 = i46 + (((~((-999627955) | streamMaxVolume)) | 730143904) * (-283)) + 670466989 + ((~(streamMaxVolume | (-269484051))) * 283);
            int i50 = (i49 << 13) ^ i49;
            int i51 = i50 ^ (i50 >>> 17);
            ((int[]) objArr40[3])[0] = i51 ^ (i51 << 5);
        } else {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr7 = (String[]) objArr[2];
            if (strArr7 != null) {
                for (String str2 : strArr7) {
                    arrayList2.add(str2);
                }
            }
            Object[] objArr41 = {Long.valueOf((((long) (-2030463387)) << 32) ^ ((long) (i44 ^ i45))), Long.valueOf(-2030463388)};
            byte[] bArr16 = $$d;
            Object[] objArr42 = new Object[1];
            d(bArr16[17], (short) 583, bArr16[324], objArr42);
            Class<?> cls12 = Class.forName((String) objArr42[0]);
            Object[] objArr43 = new Object[1];
            d((byte) 75, (short) 585, bArr16[117], objArr43);
            cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
            Object[] objArr44 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i52 = ((int[]) objArr[3])[0];
            int i53 = ((int[]) objArr[0])[0];
            int i54 = ((int[]) objArr[1])[0];
            String[] strArr8 = (String[]) objArr[2];
            int i55 = ~((int) SystemClock.uptimeMillis());
            int i56 = i52 + 167511639 + (((-587925506) | i55) * 494) + (((~(i55 | (-593201546))) | 208724446) * 494);
            int i57 = (i56 << 13) ^ i56;
            int i58 = i57 ^ (i57 >>> 17);
            ((int[]) objArr44[3])[0] = i58 ^ (i58 << 5);
        }
        int i59 = getARTIFICIAL_FRAME_PACKAGE_NAME + 15;
        artificialFrame = i59 % 128;
        int i60 = i59 % 2;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x026e  */
    /* JADX WARN: Code duplicated, block: B:29:0x0270  */
    @Override // android.app.Service
    public void onCreate() throws Throwable {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        int i;
        Object[] objArr5;
        int i2;
        Object[] objArr6;
        int i3;
        Object[] objArrAccessartificialFrame$78cbbd35;
        int i4;
        Object[] objArr7;
        char c;
        int i5 = 2 % 2;
        Object[] objArr8 = new Object[1];
        c(1 - TextUtils.getOffsetBefore("", 0), new char[]{22249, 24611, 22152, 46174, 43994, 920, 2652, 1738, 17429, 21452, 30231, 47804, 63006, 5371, 58186, 27285, 42612, 42151, 12964, 7023, 6068, 29987, 17120, 51985, 51190, 1479}, objArr8);
        String str = (String) objArr8[0];
        Object[] objArr9 = new Object[1];
        c(ExpandableListView.getPackedPositionGroup(0L) + 1, new char[]{56582, 31833, 56675, 43046, 61508, 22531, 48476, 36153, 22627, 2130, 49429, 3522, 32251, 2195, 47254, 56752, 11659, 47299, 26923}, objArr9);
        String str2 = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        c(1 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), new char[]{878, 8432, 772, 62594, 26359, 52903, 62170, 21260, 1219, 40676, 36482, 17001, 41873, 21621, 11802, 37418, 62457, 58483, 65432, 58354}, objArr10);
        String str3 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        c((ViewConfiguration.getScrollBarSize() >> 8) + 1, new char[]{6565, 10515, 6604, 64868, 21000, 64075, 58778, 18845, 3365, 43534, 39373, 21809, 47477, 24025, 6853, 34164, 59650, 60811, 52070, 62645}, objArr11);
        String str4 = (String) objArr11[0];
        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame == null) {
            int packedPositionGroup = ExpandableListView.getPackedPositionGroup(0L) + 30;
            char deadChar = (char) (KeyEvent.getDeadChar(0, 0) + 49362);
            int doubleTapTimeout = 684 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
            byte[] bArr = $$a;
            Object[] objArr12 = new Object[1];
            b(bArr[4], bArr[0], (byte) (bArr[115] + 1), objArr12);
            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(packedPositionGroup, deadChar, doubleTapTimeout, 752929587, false, (String) objArr12[0], null);
        }
        long j = ((Field) objAccessartificialFrame).getLong(null);
        if (j == -1 || j + 2030 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr13 = new Object[1];
                c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 34, new char[]{12441, 43650, 12536, 32511, 46894, 8044, 62037, 24762, 36532, 20280, 36382, 17077, 36960, 56921, 65504, 37601, 49212, 28182, 11856, 58218, 29151, 49064, 24076, 13070, 41393, 53093, 36606, 33742, 53552, 7997}, objArr13);
                Class<?> cls = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 35, new char[]{12605, 39587, 12638, 20165, 33755, 11151, 63252, 24852, 48786, 31709, 35679, 18331, 37333, 61048, 51977, 38887, 49594, 24117, 6821, 58923, 28770, 36750}, objArr14);
                baseContext = (Context) cls.getMethod((String) objArr14[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                if (baseContext instanceof ContextWrapper) {
                    int i6 = getARTIFICIAL_FRAME_PACKAGE_NAME + 85;
                    artificialFrame = i6 % 128;
                    if (i6 % 2 == 0) {
                        int i7 = 92 / 0;
                        if (((ContextWrapper) baseContext).getBaseContext() != null) {
                            baseContext = baseContext.getApplicationContext();
                        } else {
                            baseContext = null;
                        }
                    } else if (((ContextWrapper) baseContext).getBaseContext() != null) {
                        baseContext = baseContext.getApplicationContext();
                    } else {
                        baseContext = null;
                    }
                } else {
                    baseContext = baseContext.getApplicationContext();
                }
            }
            try {
                Object[] objArr15 = {baseContext, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -1973934234};
                byte[] bArr2 = $$d;
                Object[] objArr16 = new Object[1];
                d(bArr2[17], (short) 545, bArr2[130], objArr16);
                Class<?> cls2 = Class.forName((String) objArr16[0]);
                byte b = bArr2[17];
                Object[] objArr17 = new Object[1];
                d(b, (short) (b | 498), bArr2[14], objArr17);
                Object[] objArr18 = (Object[]) cls2.getMethod((String) objArr17[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr15);
                if (baseContext != null) {
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-326560385);
                    if (objAccessartificialFrame2 == null) {
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0) + 30;
                        char c2 = (char) (49362 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                        int windowTouchSlop = (ViewConfiguration.getWindowTouchSlop() >> 8) + 684;
                        byte b2 = (byte) 42;
                        Object[] objArr19 = new Object[1];
                        b($$a[4], b2, (byte) (b2 - 4), objArr19);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec, c2, windowTouchSlop, 1944867703, false, (String) objArr19[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArr18);
                    try {
                        Long lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                        if (objAccessartificialFrame3 == null) {
                            int iArgb = Color.argb(0, 0, 0, 0) + 30;
                            char cArgb = (char) (Color.argb(0, 0, 0, 0) + 49362);
                            int packedPositionType = ExpandableListView.getPackedPositionType(0L) + 684;
                            byte[] bArr3 = $$a;
                            Object[] objArr20 = new Object[1];
                            b(bArr3[4], bArr3[0], (byte) (bArr3[115] + 1), objArr20);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iArgb, cArgb, packedPositionType, 752929587, false, (String) objArr20[0], null);
                        }
                        ((Field) objAccessartificialFrame3).set(null, lValueOf);
                    } catch (Exception unused) {
                        throw new RuntimeException();
                    }
                } else {
                    objArr18 = objArr18;
                }
                objArr = objArr18;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        } else {
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-326560385);
            if (objAccessartificialFrame4 == null) {
                int size = 30 - View.MeasureSpec.getSize(0);
                char c3 = (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 49361);
                int iIndexOf = 683 - TextUtils.indexOf((CharSequence) "", '0');
                byte b3 = (byte) 42;
                Object[] objArr21 = new Object[1];
                b($$a[4], b3, (byte) (b3 - 4), objArr21);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(size, c3, iIndexOf, 1944867703, false, (String) objArr21[0], null);
            }
            Object[] objArr22 = (Object[]) ((Field) objAccessartificialFrame4).get(null);
            objArr = new Object[]{new int[]{((int[]) objArr22[0])[0]}, new int[]{((int[]) objArr22[1])[0]}, new int[1], (String) objArr22[3]};
            int i8 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().keyboard;
            int i9 = ~i8;
            int i10 = ((((-958088776) + (((~((-346385034) | i9)) | (~((-632238742) | i9))) * (-867))) + ((((~((-632238742) | i8)) | 77931137) | (~((-346385034) | i8))) * (-1734))) + ((((~((-77931138) | i9)) | (~((-554307605) | i8))) | (~(i8 | (-268453897)))) * 867)) - 1973934234;
            int i11 = (i10 << 13) ^ i10;
            int i12 = i11 ^ (i11 >>> 17);
            ((int[]) objArr[2])[0] = i12 ^ (i12 << 5);
        }
        int i13 = ((int[]) objArr[1])[0];
        int i14 = ((int[]) objArr[0])[0];
        if (i14 == i13) {
            int i15 = ((int[]) objArr[2])[0];
            Object[] objArr23 = {new int[]{((int[]) objArr[0])[0]}, new int[]{((int[]) objArr[1])[0]}, new int[1], (String) objArr[3]};
            int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
            int i16 = i15 + (-507046658) + (((~((-271529316) | startElapsedRealtime)) | 2434339) * 1504) + ((~(startElapsedRealtime | (-269094977))) * (-1504)) + 2119391872;
            int i17 = (i16 << 13) ^ i16;
            int i18 = i17 ^ (i17 >>> 17);
            ((int[]) objArr23[2])[0] = i18 ^ (i18 << 5);
        } else {
            try {
                Object[] objArr24 = {Long.valueOf(((long) (i13 ^ i14)) ^ (((long) (-330323721)) << 32)), Long.valueOf(-330323725)};
                byte[] bArr4 = $$d;
                byte b4 = bArr4[17];
                Object[] objArr25 = new Object[1];
                d(b4, (short) (b4 | 482), bArr4[389], objArr25);
                Class<?> cls3 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                d((byte) 75, (short) 585, bArr4[117], objArr26);
                cls3.getMethod((String) objArr26[0], Long.TYPE, Long.TYPE).invoke(null, objArr24);
                int i19 = ((int[]) objArr[2])[0];
                Object[] objArr27 = {new int[]{((int[]) objArr[0])[0]}, new int[]{((int[]) objArr[1])[0]}, new int[1], (String) objArr[3]};
                int iIdentityHashCode = System.identityHashCode(this);
                int i20 = i19 + (-237881441) + (((~((~iIdentityHashCode) | (-1048601338))) | (-69977563)) * (-235)) + (((~((-1048601338) | iIdentityHashCode)) | (-69977563)) * (-470)) + (((~(iIdentityHashCode | (-67125465))) | (-1051453436)) * 235);
                int i21 = (i20 << 13) ^ i20;
                int i22 = i21 ^ (i21 >>> 17);
                ((int[]) objArr27[2])[0] = i22 ^ (i22 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame5 == null) {
            int offsetAfter = TextUtils.getOffsetAfter("", 0) + 30;
            char packedPositionChild = (char) (ExpandableListView.getPackedPositionChild(0L) + 49363);
            int doubleTapTimeout2 = 684 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
            byte[] bArr5 = $$a;
            byte b5 = bArr5[113];
            Object[] objArr28 = new Object[1];
            b(b5, (byte) (b5 | 49), (byte) (bArr5[15] - 1), objArr28);
            objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(offsetAfter, packedPositionChild, doubleTapTimeout2, -1583976536, false, (String) objArr28[0], null);
        }
        long j2 = ((Field) objAccessartificialFrame5).getLong(null);
        if (j2 == -1 || j2 + 1860 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr29 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 1985777974};
            byte[] bArr6 = $$d;
            byte b6 = bArr6[17];
            Object[] objArr30 = new Object[1];
            d(b6, (short) (b6 | 448), bArr6[130], objArr30);
            Class<?> cls4 = Class.forName((String) objArr30[0]);
            byte b7 = bArr6[17];
            Object[] objArr31 = new Object[1];
            d(b7, (short) (b7 | 498), bArr6[14], objArr31);
            Object[] objArr32 = (Object[]) cls4.getMethod((String) objArr31[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr29);
            Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame6 == null) {
                int i23 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 30;
                char doubleTapTimeout3 = (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 49362);
                int doubleTapTimeout4 = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 684;
                byte[] bArr7 = $$a;
                Object[] objArr33 = new Object[1];
                b(bArr7[117], (byte) ($$b & 381), (byte) (bArr7[15] + 1), objArr33);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i23, doubleTapTimeout3, doubleTapTimeout4, -1456483158, false, (String) objArr33[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, objArr32);
            try {
                Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame7 == null) {
                    int threadPriority = ((Process.getThreadPriority(0) + 20) >> 6) + 30;
                    char maxKeyCode = (char) (49362 - (KeyEvent.getMaxKeyCode() >> 16));
                    int jumpTapTimeout = 684 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                    byte[] bArr8 = $$a;
                    byte b8 = bArr8[113];
                    Object[] objArr34 = new Object[1];
                    b(b8, (byte) (b8 | 49), (byte) (bArr8[15] - 1), objArr34);
                    objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(threadPriority, maxKeyCode, jumpTapTimeout, -1583976536, false, (String) objArr34[0], null);
                }
                ((Field) objAccessartificialFrame7).set(null, lValueOf2);
                objArr2 = objArr32;
            } catch (Exception unused2) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame8 == null) {
                int packedPositionChild2 = 29 - ExpandableListView.getPackedPositionChild(0L);
                char c4 = (char) ((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 49362);
                int offsetBefore = TextUtils.getOffsetBefore("", 0) + 684;
                byte[] bArr9 = $$a;
                Object[] objArr35 = new Object[1];
                b(bArr9[117], (byte) ($$b & 381), (byte) (bArr9[15] + 1), objArr35);
                objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(packedPositionChild2, c4, offsetBefore, -1456483158, false, (String) objArr35[0], null);
            }
            Object[] objArr36 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
            objArr2 = new Object[]{new int[]{((int[]) objArr36[0])[0]}, new int[]{((int[]) objArr36[1])[0]}, new int[1], (String) objArr36[3]};
            int startElapsedRealtime2 = (int) Process.getStartElapsedRealtime();
            int i24 = 1185328424 + (((-541344327) | startElapsedRealtime2) * (-381)) + (((~((~startElapsedRealtime2) | 235943352)) | (-575951583)) * 381) + 2079535972;
            int i25 = (i24 << 13) ^ i24;
            int i26 = i25 ^ (i25 >>> 17);
            ((int[]) objArr2[2])[0] = i26 ^ (i26 << 5);
        }
        int i27 = ((int[]) objArr2[1])[0];
        int i28 = ((int[]) objArr2[0])[0];
        if (i28 == i27) {
            int i29 = ((int[]) objArr2[2])[0];
            Object[] objArr37 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int i30 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 252750904;
            int i31 = i29 + (-1188835266) + (((~(i30 | 253737890)) | (-792722431)) * 305) + (((~((~i30) | 253737890)) | (-724885885)) * 305);
            int i32 = (i31 << 13) ^ i31;
            int i33 = i32 ^ (i32 >>> 17);
            ((int[]) objArr37[2])[0] = i33 ^ (i33 << 5);
        } else {
            new ArrayList().add((String) objArr2[3]);
            Object[] objArr38 = {Long.valueOf(((long) (i27 ^ i28)) ^ (((long) (-1209942733)) << 32)), Long.valueOf(-1209942749)};
            byte[] bArr10 = $$d;
            Object[] objArr39 = new Object[1];
            d(bArr10[17], (short) TypedValues.CycleType.TYPE_WAVE_PHASE, bArr10[0], objArr39);
            Class<?> cls5 = Class.forName((String) objArr39[0]);
            Object[] objArr40 = new Object[1];
            d((byte) 75, (short) 585, bArr10[117], objArr40);
            cls5.getMethod((String) objArr40[0], Long.TYPE, Long.TYPE).invoke(null, objArr38);
            int i34 = ((int[]) objArr2[2])[0];
            Object[] objArr41 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int streamVolume = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getStreamVolume(3);
            int i35 = i34 + (((~((-876681375) | streamVolume)) | 656448) * 449) + 1896187776 + (((~((~streamVolume) | (-876681375))) | 656448) * 449);
            int i36 = (i35 << 13) ^ i35;
            int i37 = i36 ^ (i36 >>> 17);
            ((int[]) objArr41[2])[0] = i37 ^ (i37 << 5);
        }
        Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame9 == null) {
            int iRed = Color.red(0) + 17;
            char packedPositionType2 = (char) ExpandableListView.getPackedPositionType(0L);
            int packedPositionType3 = 747 - ExpandableListView.getPackedPositionType(0L);
            byte[] bArr11 = $$a;
            byte b9 = bArr11[117];
            byte b10 = (byte) (bArr11[3] - 1);
            Object[] objArr42 = new Object[1];
            b(b9, b10, (byte) (b10 | 47), objArr42);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(iRed, packedPositionType2, packedPositionType3, -144068856, false, (String) objArr42[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j3 == -1 || j3 + 4611686018427387861L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext2 = getBaseContext();
            if (baseContext2 == null) {
                Object[] objArr43 = new Object[1];
                c((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 1, new char[]{12441, 43650, 12536, 32511, 46894, 8044, 62037, 24762, 36532, 20280, 36382, 17077, 36960, 56921, 65504, 37601, 49212, 28182, 11856, 58218, 29151, 49064, 24076, 13070, 41393, 53093, 36606, 33742, 53552, 7997}, objArr43);
                Class<?> cls6 = Class.forName((String) objArr43[0]);
                Object[] objArr44 = new Object[1];
                c(KeyEvent.normalizeMetaState(0) + 1, new char[]{12605, 39587, 12638, 20165, 33755, 11151, 63252, 24852, 48786, 31709, 35679, 18331, 37333, 61048, 51977, 38887, 49594, 24117, 6821, 58923, 28770, 36750}, objArr44);
                baseContext2 = (Context) cls6.getMethod((String) objArr44[0], new Class[0]).invoke(null, null);
            }
            if (baseContext2 != null) {
                baseContext2 = ((baseContext2 instanceof ContextWrapper) && ((ContextWrapper) baseContext2).getBaseContext() == null) ? null : baseContext2.getApplicationContext();
            }
            int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            int i38 = artificialFrame + 61;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i38 % 128;
            int i39 = i38 % 2;
            Object[] objArr45 = {baseContext2, Integer.valueOf(iIntValue), 0, 316983887};
            byte[] bArr12 = $$d;
            Object[] objArr46 = new Object[1];
            d(bArr12[17], (short) 359, (byte) com.salesforce.marketingcloud.analytics.stats.b.l, objArr46);
            Class<?> cls7 = Class.forName((String) objArr46[0]);
            Object[] objArr47 = new Object[1];
            d(bArr12[82], (short) 251, bArr12[91], objArr47);
            Object[] objArr48 = (Object[]) cls7.getMethod((String) objArr47[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr45);
            Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame10 == null) {
                int threadPriority2 = 17 - ((Process.getThreadPriority(0) + 20) >> 6);
                char longPressTimeout = (char) (ViewConfiguration.getLongPressTimeout() >> 16);
                int size2 = View.MeasureSpec.getSize(0) + 747;
                byte[] bArr13 = $$a;
                byte b11 = bArr13[117];
                byte b12 = bArr13[113];
                Object[] objArr49 = new Object[1];
                b(b11, b12, (byte) (b12 | 39), objArr49);
                objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(threadPriority2, longPressTimeout, size2, -1031537386, false, (String) objArr49[0], null);
            }
            ((Field) objAccessartificialFrame10).set(null, objArr48);
            try {
                Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame11 == null) {
                    int i40 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 17;
                    char defaultSize = (char) View.getDefaultSize(0, 0);
                    int absoluteGravity = 747 - Gravity.getAbsoluteGravity(0, 0);
                    byte[] bArr14 = $$a;
                    byte b13 = bArr14[117];
                    byte b14 = (byte) (bArr14[3] - 1);
                    Object[] objArr50 = new Object[1];
                    b(b13, b14, (byte) (b14 | 47), objArr50);
                    objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(i40, defaultSize, absoluteGravity, -144068856, false, (String) objArr50[0], null);
                }
                ((Field) objAccessartificialFrame11).set(null, lValueOf3);
                objArr3 = objArr48;
            } catch (Exception unused3) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame12 == null) {
                int i41 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 18;
                char c5 = (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                int absoluteGravity2 = Gravity.getAbsoluteGravity(0, 0) + 747;
                byte[] bArr15 = $$a;
                byte b15 = bArr15[117];
                byte b16 = bArr15[113];
                Object[] objArr51 = new Object[1];
                b(b15, b16, (byte) (b16 | 39), objArr51);
                objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(i41, c5, absoluteGravity2, -1031537386, false, (String) objArr51[0], null);
            }
            Object[] objArr52 = (Object[]) ((Field) objAccessartificialFrame12).get(null);
            objArr3 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
            int i42 = ((int[]) objArr52[3])[0];
            int i43 = ((int[]) objArr52[4])[0];
            List list = (List) objArr52[0];
            List list2 = (List) objArr52[2];
            int i44 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().touchscreen;
            int i45 = ~i44;
            int i46 = 1969322785 + (((~((-526125629) | i45)) | 68684300) * 168) + ((~((-68684301) | i44)) * 168) + (((~(i44 | (-457441329))) | (~(i45 | (-79322830))) | 10638529) * 168) + 316983887;
            int i47 = (i46 << 13) ^ i46;
            int i48 = i47 ^ (i47 >>> 17);
            ((int[]) objArr3[1])[0] = i48 ^ (i48 << 5);
        }
        int i49 = ((int[]) objArr3[4])[0];
        int i50 = ((int[]) objArr3[3])[0];
        if (i50 == i49) {
            Object[] objArr53 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i51 = ((int[]) objArr3[1])[0];
            int i52 = ((int[]) objArr3[3])[0];
            int i53 = ((int[]) objArr3[4])[0];
            List list3 = (List) objArr3[0];
            List list4 = (List) objArr3[2];
            int i54 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().uiMode;
            int i55 = ~i54;
            int i56 = ~(1065581293 | i55);
            int i57 = i51 + 923714497 + (((-1072659440) | i56) * (-712)) + (((~(i54 | (-7078147))) | (~(i55 | 1072659439))) * (-712)) + ((460132835 | i56) * 712);
            int i58 = (i57 << 13) ^ i57;
            int i59 = i58 ^ (i58 >>> 17);
            ((int[]) objArr53[1])[0] = i59 ^ (i59 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            try {
                Object[] objArr54 = {objArr3};
                Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(1804664566);
                if (objAccessartificialFrame13 == null) {
                    objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 40, (char) (12468 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))), 3642 - (ViewConfiguration.getTapTimeout() >> 16), -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                }
                arrayList.add(((Method) objAccessartificialFrame13).invoke(null, objArr54));
                Object[] objArr55 = {objArr3};
                Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                if (objAccessartificialFrame14 == null) {
                    objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(41 - KeyEvent.normalizeMetaState(0), (char) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 12468), 3642 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                }
                arrayList.add(((Method) objAccessartificialFrame14).invoke(null, objArr55));
                long j4 = ((long) (i49 ^ i50)) ^ (((long) 300288511) << 32);
                long j5 = 300288503;
                int i60 = artificialFrame + 67;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i60 % 128;
                int i61 = i60 % 2;
                Object[] objArr56 = {Long.valueOf(j4), Long.valueOf(j5)};
                byte[] bArr16 = $$d;
                Object[] objArr57 = new Object[1];
                d(bArr16[17], (short) 232, bArr16[546], objArr57);
                Class<?> cls8 = Class.forName((String) objArr57[0]);
                Object[] objArr58 = new Object[1];
                d((byte) 75, (short) 585, bArr16[117], objArr58);
                cls8.getMethod((String) objArr58[0], Long.TYPE, Long.TYPE).invoke(null, objArr56);
                Object[] objArr59 = {list, new int[1], list, new int[]{i}, new int[]{i}};
                int i62 = ((int[]) objArr3[1])[0];
                int i63 = ((int[]) objArr3[3])[0];
                int i64 = ((int[]) objArr3[4])[0];
                List list5 = (List) objArr3[0];
                List list6 = (List) objArr3[2];
                int i65 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().widthPixels;
                int i66 = ~i65;
                int i67 = i62 + 1740055496 + ((811266998 | i66) * (-757)) + ((~(1012857790 | i65)) * 1514) + (((~(i65 | (-201590793))) | (~(i66 | 205818540)) | 807039250) * 757);
                int i68 = (i67 << 13) ^ i67;
                int i69 = i68 ^ (i68 >>> 17);
                ((int[]) objArr59[1])[0] = i69 ^ (i69 << 5);
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        }
        Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame15 == null) {
            int fadingEdgeLength = 30 - (ViewConfiguration.getFadingEdgeLength() >> 16);
            char c6 = (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 49361);
            int maximumFlingVelocity = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 684;
            byte[] bArr17 = $$a;
            byte b17 = bArr17[113];
            Object[] objArr60 = new Object[1];
            b(b17, (byte) (b17 | 69), (byte) (bArr17[115] + 1), objArr60);
            objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength, c6, maximumFlingVelocity, 508509282, false, (String) objArr60[0], null);
        }
        long j6 = ((Field) objAccessartificialFrame15).getLong(null);
        if (j6 == -1 || j6 + 1897 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext3 = getBaseContext();
            if (baseContext3 == null) {
                int i70 = artificialFrame + 119;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i70 % 128;
                int i71 = i70 % 2;
                Object[] objArr61 = new Object[1];
                c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 20, new char[]{12441, 43650, 12536, 32511, 46894, 8044, 62037, 24762, 36532, 20280, 36382, 17077, 36960, 56921, 65504, 37601, 49212, 28182, 11856, 58218, 29151, 49064, 24076, 13070, 41393, 53093, 36606, 33742, 53552, 7997}, objArr61);
                Class<?> cls9 = Class.forName((String) objArr61[0]);
                Object[] objArr62 = new Object[1];
                c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 3, new char[]{12605, 39587, 12638, 20165, 33755, 11151, 63252, 24852, 48786, 31709, 35679, 18331, 37333, 61048, 51977, 38887, 49594, 24117, 6821, 58923, 28770, 36750}, objArr62);
                baseContext3 = (Context) cls9.getMethod((String) objArr62[0], new Class[0]).invoke(null, null);
            }
            if (baseContext3 != null) {
                baseContext3 = ((baseContext3 instanceof ContextWrapper) && ((ContextWrapper) baseContext3).getBaseContext() == null) ? null : baseContext3.getApplicationContext();
            }
            Object[] objArr63 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -1481950444};
            byte[] bArr18 = $$d;
            byte b18 = bArr18[10];
            Object[] objArr64 = new Object[1];
            d(b18, (short) (b18 | 169), bArr18[0], objArr64);
            Class<?> cls10 = Class.forName((String) objArr64[0]);
            Object[] objArr65 = new Object[1];
            d(bArr18[14], (short) 107, bArr18[169], objArr65);
            objArr4 = (Object[]) cls10.getMethod((String) objArr65[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr63);
            if (baseContext3 != null) {
                int i72 = artificialFrame + 49;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i72 % 128;
                int i73 = i72 % 2;
                Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame16 == null) {
                    int defaultSize2 = 30 - View.getDefaultSize(0, 0);
                    char absoluteGravity3 = (char) (Gravity.getAbsoluteGravity(0, 0) + 49362);
                    int modifierMetaStateMask = 683 - ((byte) KeyEvent.getModifierMetaStateMask());
                    byte[] bArr19 = $$a;
                    Object[] objArr66 = new Object[1];
                    b(bArr19[30], (byte) 89, bArr19[15], objArr66);
                    objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(defaultSize2, absoluteGravity3, modifierMetaStateMask, -1321816393, false, (String) objArr66[0], null);
                }
                ((Field) objAccessartificialFrame16).set(null, objArr4);
                try {
                    Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                    if (objAccessartificialFrame17 == null) {
                        int i74 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 29;
                        char cIndexOf = (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 49363);
                        int deadChar2 = KeyEvent.getDeadChar(0, 0) + 684;
                        byte[] bArr20 = $$a;
                        byte b19 = bArr20[113];
                        Object[] objArr67 = new Object[1];
                        b(b19, (byte) (b19 | 69), (byte) (bArr20[115] + 1), objArr67);
                        objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(i74, cIndexOf, deadChar2, 508509282, false, (String) objArr67[0], null);
                    }
                    ((Field) objAccessartificialFrame17).set(null, lValueOf4);
                } catch (Exception unused4) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(777251007);
            if (objAccessartificialFrame18 == null) {
                int iRgb = (-16777186) - Color.rgb(0, 0, 0);
                char c7 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 49361);
                int touchSlop = 684 - (ViewConfiguration.getTouchSlop() >> 8);
                byte[] bArr21 = $$a;
                Object[] objArr68 = new Object[1];
                b(bArr21[30], (byte) 89, bArr21[15], objArr68);
                objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(iRgb, c7, touchSlop, -1321816393, false, (String) objArr68[0], null);
            }
            Object[] objArr69 = (Object[]) ((Field) objAccessartificialFrame18).get(null);
            objArr4 = new Object[]{new int[]{((int[]) objArr69[0])[0]}, new int[]{((int[]) objArr69[1])[0]}, new int[1], (String) objArr69[3]};
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i75 = ~iIdentityHashCode2;
            int i76 = (-1969816638) + (((~((-52948300) | i75)) | 19171402) * (-1188));
            int i77 = (~(iIdentityHashCode2 | 52948299)) | 19171402;
            int i78 = ~(1031572074 | i75);
            int i79 = ((i76 + ((i77 | i78) * 594)) + ((((~(52948299 | i75)) | (-1065348972)) | i78) * 594)) - 1481950444;
            int i80 = (i79 << 13) ^ i79;
            int i81 = i80 ^ (i80 >>> 17);
            ((int[]) objArr4[2])[0] = i81 ^ (i81 << 5);
        }
        int i82 = ((int[]) objArr4[1])[0];
        int i83 = ((int[]) objArr4[0])[0];
        if (i83 == i82) {
            int i84 = getARTIFICIAL_FRAME_PACKAGE_NAME + 55;
            artificialFrame = i84 % 128;
            int i85 = i84 % 2;
            int i86 = ((int[]) objArr4[2])[0];
            Object[] objArr70 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
            int iIdentityHashCode3 = System.identityHashCode(this);
            int i87 = i86 + (((~((-731429301) | iIdentityHashCode3)) | 623074014) * 262) + 1572976630 + (((~((~iIdentityHashCode3) | (-731429301))) | 623074014) * 262);
            int i88 = (i87 << 13) ^ i87;
            int i89 = i88 ^ (i88 >>> 17);
            ((int[]) objArr70[2])[0] = i89 ^ (i89 << 5);
            i = 0;
        } else {
            Object[] objArr71 = {Long.valueOf((((long) (-1800005437)) << 32) ^ ((long) (i82 ^ i83))), Long.valueOf(-1800004925)};
            byte[] bArr22 = $$d;
            byte b20 = bArr22[17];
            Object[] objArr72 = new Object[1];
            d(b20, (short) (b20 | 482), bArr22[389], objArr72);
            Class<?> cls11 = Class.forName((String) objArr72[0]);
            Object[] objArr73 = new Object[1];
            d((byte) 75, (short) 585, bArr22[117], objArr73);
            cls11.getMethod((String) objArr73[0], Long.TYPE, Long.TYPE).invoke(null, objArr71);
            int i90 = ((int[]) objArr4[2])[0];
            Object[] objArr74 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
            int i91 = ~((int) Runtime.getRuntime().maxMemory());
            int i92 = i90 + 2105301966 + ((~(934050557 | i91)) * 52) + (((~(313287393 | i91)) | (~((-665336382) | i91)) | 620763164) * (-52)) + (((~(i91 | (-313287394))) | 268714176) * 52);
            int i93 = (i92 << 13) ^ i92;
            int i94 = i93 ^ (i93 >>> 17);
            i = 0;
            ((int[]) objArr74[2])[0] = i94 ^ (i94 << 5);
        }
        Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame19 == null) {
            int windowTouchSlop2 = 36 - (ViewConfiguration.getWindowTouchSlop() >> 8);
            char absoluteGravity4 = (char) Gravity.getAbsoluteGravity(i, i);
            int defaultSize3 = View.getDefaultSize(i, i) + 540;
            byte[] bArr23 = $$a;
            byte b21 = bArr23[117];
            byte b22 = (byte) (bArr23[3] - 1);
            Object[] objArr75 = new Object[1];
            b(b21, b22, (byte) (b22 | 47), objArr75);
            objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(windowTouchSlop2, absoluteGravity4, defaultSize3, 624296913, false, (String) objArr75[0], null);
        }
        long j7 = ((Field) objAccessartificialFrame19).getLong(null);
        if (j7 == -1 || j7 + 1897 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-1717965552);
            if (objAccessartificialFrame20 == null) {
                objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getLongPressTimeout() >> 16) + 20, (char) (39516 - (ViewConfiguration.getLongPressTimeout() >> 16)), Color.green(0) + 982, 117222168, false, null, new Class[0]);
            }
            Object[] objArr76 = {null, ((Constructor) objAccessartificialFrame20).newInstance(null), 252544203, 0};
            Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(-501205803);
            if (objAccessartificialFrame21 == null) {
                int iNormalizeMetaState = 36 - KeyEvent.normalizeMetaState(0);
                char cIndexOf2 = (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0));
                int i95 = 541 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                byte b23 = $$a[3];
                byte b24 = (byte) (b23 - 1);
                Object[] objArr77 = new Object[1];
                b(b24, (byte) (b24 | 96), (byte) (b23 - 1), objArr77);
                objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState, cIndexOf2, i95, 2101703389, false, (String) objArr77[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(54 - View.resolveSize(0, 0), (char) (832 - TextUtils.lastIndexOf("", '0', 0, 0)), 576 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), (Class) ArtificialStackFrames.coroutineCreation(View.MeasureSpec.makeMeasureSpec(0, 0) + 54, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), Color.blue(0) + 630), Integer.TYPE, Integer.TYPE});
            }
            objArr5 = (Object[]) ((Method) objAccessartificialFrame21).invoke(null, objArr76);
            Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame22 == null) {
                int tapTimeout = (ViewConfiguration.getTapTimeout() >> 16) + 36;
                char mirror = (char) ('0' - AndroidCharacter.getMirror('0'));
                int iArgb2 = 540 - Color.argb(0, 0, 0, 0);
                byte[] bArr24 = $$a;
                byte b25 = bArr24[117];
                byte b26 = bArr24[113];
                Object[] objArr78 = new Object[1];
                b(b25, b26, (byte) (b26 | 39), objArr78);
                objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(tapTimeout, mirror, iArgb2, 793268735, false, (String) objArr78[0], null);
            }
            ((Field) objAccessartificialFrame22).set(null, objArr5);
            try {
                Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                if (objAccessartificialFrame23 == null) {
                    int modifierMetaStateMask2 = 35 - ((byte) KeyEvent.getModifierMetaStateMask());
                    char maxKeyCode2 = (char) (KeyEvent.getMaxKeyCode() >> 16);
                    int iAxisFromString = MotionEvent.axisFromString("") + 541;
                    byte[] bArr25 = $$a;
                    byte b27 = bArr25[117];
                    byte b28 = (byte) (bArr25[3] - 1);
                    Object[] objArr79 = new Object[1];
                    b(b27, b28, (byte) (b28 | 47), objArr79);
                    objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask2, maxKeyCode2, iAxisFromString, 624296913, false, (String) objArr79[0], null);
                }
                ((Field) objAccessartificialFrame23).set(null, lValueOf5);
            } catch (Exception unused5) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame24 == null) {
                int iAxisFromString2 = 35 - MotionEvent.axisFromString("");
                char doubleTapTimeout5 = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                int modifierMetaStateMask3 = 539 - ((byte) KeyEvent.getModifierMetaStateMask());
                byte[] bArr26 = $$a;
                byte b29 = bArr26[117];
                byte b30 = bArr26[113];
                Object[] objArr80 = new Object[1];
                b(b29, b30, (byte) (b30 | 39), objArr80);
                objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(iAxisFromString2, doubleTapTimeout5, modifierMetaStateMask3, 793268735, false, (String) objArr80[0], null);
            }
            Object[] objArr81 = (Object[]) ((Field) objAccessartificialFrame24).get(null);
            objArr5 = new Object[]{new int[1], new int[1], new int[1]};
            int i96 = ((int[]) objArr81[2])[0];
            int i97 = ((int[]) objArr81[1])[0];
            ((int[]) objArr5[2])[0] = i96;
            ((int[]) objArr5[1])[0] = i97;
            int iNextInt = new Random().nextInt();
            int i98 = ~iNextInt;
            int i99 = (-60396734) + (((~((-179560330) | i98)) | 1172061420) * 519) + (((~(i98 | (-170115842))) | (~(1342177261 | iNextInt))) * (-519)) + (((~(iNextInt | 1172061420)) | 179560329) * 519) + 252544203;
            int i100 = (i99 << 13) ^ i99;
            int i101 = i100 ^ (i100 >>> 17);
            ((int[]) objArr5[0])[0] = i101 ^ (i101 << 5);
        }
        Object obj = objArr5[1];
        int i102 = ((int[]) obj)[0];
        Object obj2 = objArr5[2];
        int i103 = ((int[]) obj2)[0];
        if (i103 == i102) {
            Object[] objArr82 = {new int[1], new int[1], new int[1]};
            int i104 = ((int[]) objArr5[0])[0];
            int i105 = ((int[]) obj2)[0];
            int i106 = ((int[]) obj)[0];
            ((int[]) objArr82[2])[0] = i105;
            ((int[]) objArr82[1])[0] = i106;
            int i107 = ~((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getStreamMaxVolume(3);
            int i108 = i104 + (((1761323101 + (((~(i107 | (-101257473))) | (~((-694583814) | i107))) * (-184))) + (((277890232 | (~((-972474046) | i107))) | (~((-379147705) | i107))) * SyslogConstants.LOG_LOCAL7)) - 1896488);
            int i109 = (i108 << 13) ^ i108;
            int i110 = i109 ^ (i109 >>> 17);
            i2 = 0;
            ((int[]) objArr82[0])[0] = i110 ^ (i110 << 5);
        } else {
            Object[] objArr83 = {Long.valueOf(((long) (i102 ^ i103)) ^ (((long) 904450963) << 32)), Long.valueOf(904446867)};
            byte[] bArr27 = $$d;
            Object[] objArr84 = new Object[1];
            d(bArr27[17], (short) TypedValues.CycleType.TYPE_WAVE_PHASE, bArr27[0], objArr84);
            Class<?> cls12 = Class.forName((String) objArr84[0]);
            Object[] objArr85 = new Object[1];
            d((byte) 75, (short) 585, bArr27[117], objArr85);
            cls12.getMethod((String) objArr85[0], Long.TYPE, Long.TYPE).invoke(null, objArr83);
            Object[] objArr86 = {new int[1], new int[1], new int[1]};
            int i111 = ((int[]) objArr5[0])[0];
            int i112 = ((int[]) objArr5[2])[0];
            int i113 = ((int[]) objArr5[1])[0];
            ((int[]) objArr86[2])[0] = i112;
            ((int[]) objArr86[1])[0] = i113;
            int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
            int i114 = i111 + (-1101413688) + (((~((-933405742) | iFreeMemory)) | 278929416) * 345) + (((~((-933405742) | (~iFreeMemory))) | 139286592) * 345) + ((~(iFreeMemory | (-278929417))) * 345);
            int i115 = (i114 << 13) ^ i114;
            int i116 = i115 ^ (i115 >>> 17);
            i2 = 0;
            ((int[]) objArr86[0])[0] = i116 ^ (i116 << 5);
        }
        super.onCreate();
        Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame25 == null) {
            int longPressTimeout2 = 25 - (ViewConfiguration.getLongPressTimeout() >> 16);
            char cBlue = (char) (Color.blue(i2) + 30068);
            int iIndexOf2 = TextUtils.indexOf("", "", i2, i2) + 816;
            byte[] bArr28 = $$a;
            byte b31 = bArr28[117];
            byte b32 = (byte) (bArr28[3] - 1);
            Object[] objArr87 = new Object[1];
            b(b31, b32, (byte) (b32 | 47), objArr87);
            objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(longPressTimeout2, cBlue, iIndexOf2, 721586079, false, (String) objArr87[0], null);
        }
        long j8 = ((Field) objAccessartificialFrame25).getLong(null);
        if (j8 == -1 || j8 + 1870 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr88 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -1968183936};
            Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame26 == null) {
                int modifierMetaStateMask4 = 24 - ((byte) KeyEvent.getModifierMetaStateMask());
                char scrollBarFadeDuration = (char) ((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 30068);
                int iIndexOf3 = TextUtils.indexOf((CharSequence) "", '0') + 817;
                byte[] bArr29 = $$a;
                Object[] objArr89 = new Object[1];
                b(bArr29[53], (byte) (bArr29[66] - 1), bArr29[37], objArr89);
                objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask4, scrollBarFadeDuration, iIndexOf3, -797394565, false, (String) objArr89[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr6 = (Object[]) ((Method) objAccessartificialFrame26).invoke(null, objArr88);
            Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame27 == null) {
                int iAlpha = 25 - Color.alpha(0);
                char cMyPid = (char) ((Process.myPid() >> 22) + 30068);
                int i117 = 817 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                byte[] bArr30 = $$a;
                byte b33 = bArr30[117];
                byte b34 = bArr30[113];
                Object[] objArr90 = new Object[1];
                b(b33, b34, (byte) (b34 | 39), objArr90);
                objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(iAlpha, cMyPid, i117, 891606461, false, (String) objArr90[0], null);
            }
            ((Field) objAccessartificialFrame27).set(null, objArr6);
            try {
                Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame28 == null) {
                    int iIndexOf4 = TextUtils.indexOf("", "") + 25;
                    char defaultSize4 = (char) (View.getDefaultSize(0, 0) + 30068);
                    int threadPriority3 = 816 - ((Process.getThreadPriority(0) + 20) >> 6);
                    byte[] bArr31 = $$a;
                    byte b35 = bArr31[117];
                    byte b36 = (byte) (bArr31[3] - 1);
                    Object[] objArr91 = new Object[1];
                    b(b35, b36, (byte) (b36 | 47), objArr91);
                    objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(iIndexOf4, defaultSize4, threadPriority3, 721586079, false, (String) objArr91[0], null);
                }
                ((Field) objAccessartificialFrame28).set(null, lValueOf6);
            } catch (Exception unused6) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame29 == null) {
                int minimumFlingVelocity = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 25;
                char cIndexOf3 = (char) (30068 - TextUtils.indexOf("", ""));
                int mode = 816 - View.MeasureSpec.getMode(0);
                byte[] bArr32 = $$a;
                byte b37 = bArr32[117];
                byte b38 = bArr32[113];
                Object[] objArr92 = new Object[1];
                b(b37, b38, (byte) (b38 | 39), objArr92);
                objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity, cIndexOf3, mode, 891606461, false, (String) objArr92[0], null);
            }
            Object[] objArr93 = (Object[]) ((Field) objAccessartificialFrame29).get(null);
            objArr6 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i118 = ((int[]) objArr93[0])[0];
            int i119 = ((int[]) objArr93[1])[0];
            String[] strArr = (String[]) objArr93[2];
            int iMyTid = Process.myTid();
            int i120 = (((548183176 + (((~((-669488387) | iMyTid)) | 601882882) * 345)) + (((~((-669488387) | (~iMyTid))) | (-1073198903)) * 345)) + ((~(iMyTid | (-601882883))) * 345)) - 1968183936;
            int i121 = (i120 << 13) ^ i120;
            int i122 = i121 ^ (i121 >>> 17);
            ((int[]) objArr6[3])[0] = i122 ^ (i122 << 5);
        }
        int i123 = ((int[]) objArr6[1])[0];
        int i124 = ((int[]) objArr6[0])[0];
        if (i124 == i123) {
            Object[] objArr94 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i125 = ((int[]) objArr6[3])[0];
            int i126 = ((int[]) objArr6[0])[0];
            int i127 = ((int[]) objArr6[1])[0];
            String[] strArr2 = (String[]) objArr6[2];
            int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 790846840;
            int i128 = i125 + (((~((-600799632) | length)) | 63903873) * (-566)) + 2008026115 + ((~(length | (-536895759))) * 566);
            int i129 = (i128 << 13) ^ i128;
            int i130 = i129 ^ (i129 >>> 17);
            i3 = 0;
            ((int[]) objArr94[3])[0] = i130 ^ (i130 << 5);
        } else {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr3 = (String[]) objArr6[2];
            if (strArr3 != null) {
                int i131 = artificialFrame + com.salesforce.marketingcloud.analytics.stats.b.f40o;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i131 % 128;
                int i132 = i131 % 2 != 0 ? 1 : 0;
                while (i132 < strArr3.length) {
                    int i133 = getARTIFICIAL_FRAME_PACKAGE_NAME + 35;
                    artificialFrame = i133 % 128;
                    if (i133 % 2 == 0) {
                        arrayList2.add(strArr3[i132]);
                        i132 += 46;
                    } else {
                        arrayList2.add(strArr3[i132]);
                        i132++;
                    }
                }
            }
            long j9 = ((long) (i123 ^ i124)) ^ (((long) 119013002) << 32);
            long j10 = 119013003;
            int i134 = getARTIFICIAL_FRAME_PACKAGE_NAME + 123;
            artificialFrame = i134 % 128;
            int i135 = i134 % 2;
            Object[] objArr95 = {Long.valueOf(j9), Long.valueOf(j10)};
            byte[] bArr33 = $$d;
            Object[] objArr96 = new Object[1];
            d(bArr33[17], (short) 583, bArr33[324], objArr96);
            Class<?> cls13 = Class.forName((String) objArr96[0]);
            Object[] objArr97 = new Object[1];
            d((byte) 75, (short) 585, bArr33[117], objArr97);
            cls13.getMethod((String) objArr97[0], Long.TYPE, Long.TYPE).invoke(null, objArr95);
            Object[] objArr98 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i136 = ((int[]) objArr6[3])[0];
            int i137 = ((int[]) objArr6[0])[0];
            int i138 = ((int[]) objArr6[1])[0];
            String[] strArr4 = (String[]) objArr6[2];
            int i139 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenHeightDp;
            int i140 = i136 + 1396364701 + (((~(i139 | 629451271)) | 431278905) * (-668)) + ((629451271 | (~(431278905 | i139))) * 1336) + ((i139 | 1035266879) * 668);
            int i141 = (i140 << 13) ^ i140;
            int i142 = i141 ^ (i141 >>> 17);
            i3 = 0;
            ((int[]) objArr98[3])[0] = i142 ^ (i142 << 5);
        }
        Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame30 == null) {
            int threadPriority4 = ((Process.getThreadPriority(i3) + 20) >> 6) + 26;
            char cBlue2 = (char) Color.blue(i3);
            int mode2 = 1041 - View.MeasureSpec.getMode(i3);
            byte[] bArr34 = $$a;
            byte b39 = bArr34[117];
            byte b40 = (byte) (bArr34[3] - 1);
            Object[] objArr99 = new Object[1];
            b(b39, b40, (byte) (b40 | 47), objArr99);
            objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(threadPriority4, cBlue2, mode2, 2061780482, false, (String) objArr99[0], null);
        }
        long j11 = ((Field) objAccessartificialFrame30).getLong(null);
        if (j11 == -1 || j11 + 4611686018427387854L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr100 = {847607174};
            Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame31 == null) {
                objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(8 - ((Process.getThreadPriority(0) + 20) >> 6), (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 22250), 1033 - Drawable.resolveOpacity(0, 0), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = zza.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame31).newInstance(objArr100), -272275843, false);
            Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame32 == null) {
                int iResolveSizeAndState = View.resolveSizeAndState(0, 0, 0) + 26;
                char mode3 = (char) View.MeasureSpec.getMode(0);
                int i143 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 1041;
                byte[] bArr35 = $$a;
                byte b41 = bArr35[117];
                byte b42 = bArr35[113];
                Object[] objArr101 = new Object[1];
                b(b41, b42, (byte) (b42 | 39), objArr101);
                objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState, mode3, i143, 1145017376, false, (String) objArr101[0], null);
            }
            ((Field) objAccessartificialFrame32).set(null, objArrAccessartificialFrame$78cbbd35);
            try {
                Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame33 == null) {
                    int threadPriority5 = ((Process.getThreadPriority(0) + 20) >> 6) + 26;
                    char c8 = (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1);
                    int longPressTimeout3 = 1041 - (ViewConfiguration.getLongPressTimeout() >> 16);
                    byte[] bArr36 = $$a;
                    byte b43 = bArr36[117];
                    byte b44 = (byte) (bArr36[3] - 1);
                    Object[] objArr102 = new Object[1];
                    b(b43, b44, (byte) (b44 | 47), objArr102);
                    objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(threadPriority5, c8, longPressTimeout3, 2061780482, false, (String) objArr102[0], null);
                }
                ((Field) objAccessartificialFrame33).set(null, lValueOf7);
            } catch (Exception unused7) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame34 == null) {
                int mode4 = 26 - View.MeasureSpec.getMode(0);
                char cKeyCodeFromString = (char) KeyEvent.keyCodeFromString("");
                int i144 = 1042 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                byte[] bArr37 = $$a;
                byte b45 = bArr37[117];
                byte b46 = bArr37[113];
                Object[] objArr103 = new Object[1];
                b(b45, b46, (byte) (b46 | 39), objArr103);
                objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(mode4, cKeyCodeFromString, i144, 1145017376, false, (String) objArr103[0], null);
            }
            Object[] objArr104 = (Object[]) ((Field) objAccessartificialFrame34).get(null);
            objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
            int i145 = ((int[]) objArr104[3])[0];
            int i146 = ((int[]) objArr104[2])[0];
            String[] strArr5 = (String[]) objArr104[0];
            int streamVolume2 = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getStreamVolume(3);
            int i147 = 1473583838 + (((~((-922811919) | streamVolume2)) | 83936768) * 1504) + ((~(streamVolume2 | (-838875151))) * (-1504)) + 940363933;
            int i148 = (i147 << 13) ^ i147;
            int i149 = i148 ^ (i148 >>> 17);
            ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i149 ^ (i149 << 5);
        }
        int i150 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i151 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i151 == i150) {
            Object[] objArr105 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i152 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i153 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i154 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr6 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iIdentityHashCode4 = System.identityHashCode(this);
            int i155 = i152 + (-1017943854) + (((~(496771761 | iIdentityHashCode4)) | 496762881) * (-502)) + ((~((~iIdentityHashCode4) | 1071638449)) * (-502)) + (((~(iIdentityHashCode4 | (-574875569))) | 496771761) * TypedValues.PositionType.TYPE_DRAWPATH);
            int i156 = (i155 << 13) ^ i155;
            int i157 = i156 ^ (i156 >>> 17);
            ((int[]) objArr105[1])[0] = i157 ^ (i157 << 5);
            i4 = 0;
        } else {
            ArrayList arrayList3 = new ArrayList();
            String[] strArr7 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr7 != null) {
                for (String str5 : strArr7) {
                    arrayList3.add(str5);
                }
            }
            Object[] objArr106 = {Long.valueOf((((long) (-839355873)) << 32) ^ ((long) (i150 ^ i151))), Long.valueOf(-839355875)};
            byte[] bArr38 = $$d;
            Object[] objArr107 = new Object[1];
            d(bArr38[17], (short) 87, bArr38[2], objArr107);
            Class<?> cls14 = Class.forName((String) objArr107[0]);
            Object[] objArr108 = new Object[1];
            d((byte) 75, (short) 585, bArr38[117], objArr108);
            cls14.getMethod((String) objArr108[0], Long.TYPE, Long.TYPE).invoke(null, objArr106);
            Object[] objArr109 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i158 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i159 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i160 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr8 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) + 275696007;
            int i161 = i158 + 1473583838 + (((~((-981449363) | iCodePointAt)) | 170396160) * 1504) + ((~(iCodePointAt | (-811053203))) * (-1504)) + 26733088;
            int i162 = (i161 << 13) ^ i161;
            int i163 = i162 ^ (i162 >>> 17);
            i4 = 0;
            ((int[]) objArr109[1])[0] = i163 ^ (i163 << 5);
        }
        Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame35 == null) {
            int iGreen = Color.green(i4) + 21;
            char cIndexOf4 = (char) TextUtils.indexOf("", "", i4);
            int iAxisFromString3 = 464 - MotionEvent.axisFromString("");
            byte[] bArr39 = $$a;
            byte b47 = bArr39[117];
            byte b48 = (byte) (bArr39[3] - 1);
            Object[] objArr110 = new Object[1];
            b(b47, b48, (byte) (b48 | 47), objArr110);
            objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(iGreen, cIndexOf4, iAxisFromString3, -785931255, false, (String) objArr110[0], null);
        }
        long j12 = ((Field) objAccessartificialFrame35).getLong(null);
        if (j12 == -1 || j12 + 1937 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext4 = getBaseContext();
            if (baseContext4 == null) {
                Object[] objArr111 = new Object[1];
                c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 34, new char[]{12441, 43650, 12536, 32511, 46894, 8044, 62037, 24762, 36532, 20280, 36382, 17077, 36960, 56921, 65504, 37601, 49212, 28182, 11856, 58218, 29151, 49064, 24076, 13070, 41393, 53093, 36606, 33742, 53552, 7997}, objArr111);
                Class<?> cls15 = Class.forName((String) objArr111[0]);
                Object[] objArr112 = new Object[1];
                c(1 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), new char[]{12605, 39587, 12638, 20165, 33755, 11151, 63252, 24852, 48786, 31709, 35679, 18331, 37333, 61048, 51977, 38887, 49594, 24117, 6821, 58923, 28770, 36750}, objArr112);
                baseContext4 = (Context) cls15.getMethod((String) objArr112[0], new Class[0]).invoke(null, null);
            }
            if (baseContext4 != null) {
                baseContext4 = ((baseContext4 instanceof ContextWrapper) && ((ContextWrapper) baseContext4).getBaseContext() == null) ? null : baseContext4.getApplicationContext();
            }
            int iIntValue3 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr113 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 3, new char[]{47140, 64166, 47170, 11908, 17248, 60273, 50724, 59483, 56988, 47988, 47663, 30365, 6367, 36404, 3051, 42655, 18672, 15975, 55890, 55124, 63857, 61313, 43520, 1907, 10605, 40720, 31482, 47100, 23003, 20252, 51901, 58398, 35412, 64697, 39231, 5124, 14882, 44256, 27091, 17618, 27312, 23679, 14731, 62636, 39660, 3534, 34840, 9515, 52056, 48581, 22633, 21858, 31698, 28004, 10423, 34257, 43969, 7549, 65364, 10843, 56380, 49918, 20303, 23083, 3175, 29250, 8094, 35505}, objArr113);
            String str6 = (String) objArr113[0];
            Object[] objArr114 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 34, new char[]{57923, 31607, 57974, 44883, 37347, 14752, 16338, 45674, 24398, 27041, 17294, 36671, 17130, 4069, 55656, 24381, 4753, 49075, 2189, 11946, 41792, 28162, 30852, 65154, 29534, 7838, 43124, 20058, 946, 52888, 6203, 7613, 53299, 32101, 19387, 60913, 24598, 11575, 47959, 48421, 12506, 56745, 60244, 3422, 49282, 35918, 23240, 56461, 37172, 15376, 35518, 44225, 8676, 60647, 64052, 31777, 61949, 40189, 11735, 54189, 34313, 17197, 40341, 41948, 22023, 62353, 52511, 29510}, objArr114);
            Object[] objArr115 = {baseContext4, new String[]{str6, (String) objArr114[0]}, Integer.valueOf(iIntValue3), 1, 720222220};
            byte[] bArr40 = $$d;
            Object[] objArr116 = new Object[1];
            d(bArr40[17], bArr40[79], bArr40[321], objArr116);
            Class<?> cls16 = Class.forName((String) objArr116[0]);
            Object[] objArr117 = new Object[1];
            d(bArr40[14], (short) 107, bArr40[169], objArr117);
            Object[] objArr118 = (Object[]) cls16.getMethod((String) objArr117[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr115);
            int i164 = ((int[]) objArr118[0])[0];
            int i165 = ((int[]) objArr118[3])[0];
            if (baseContext4 != null) {
                int i166 = artificialFrame + 33;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i166 % 128;
                int i167 = i166 % 2;
                Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame36 == null) {
                    int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 21;
                    char offsetAfter2 = (char) TextUtils.getOffsetAfter("", 0);
                    int iCombineMeasuredStates = View.combineMeasuredStates(0, 0) + 465;
                    byte[] bArr41 = $$a;
                    byte b49 = bArr41[117];
                    byte b50 = bArr41[113];
                    Object[] objArr119 = new Object[1];
                    b(b49, b50, (byte) (b50 | 39), objArr119);
                    objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay, offsetAfter2, iCombineMeasuredStates, -612765161, false, (String) objArr119[0], null);
                }
                ((Field) objAccessartificialFrame36).set(null, objArr118);
                try {
                    Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(1313006081);
                    if (objAccessartificialFrame37 == null) {
                        int i168 = 22 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                        char c9 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1);
                        int fadingEdgeLength2 = 465 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                        byte[] bArr42 = $$a;
                        byte b51 = bArr42[117];
                        byte b52 = (byte) (bArr42[3] - 1);
                        Object[] objArr120 = new Object[1];
                        b(b51, b52, (byte) (b52 | 47), objArr120);
                        objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(i168, c9, fadingEdgeLength2, -785931255, false, (String) objArr120[0], null);
                    }
                    ((Field) objAccessartificialFrame37).set(null, lValueOf8);
                } catch (Exception unused8) {
                    throw new RuntimeException();
                }
            }
            objArr7 = objArr118;
            c = 0;
        } else {
            Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(1142731807);
            if (objAccessartificialFrame38 == null) {
                int i169 = 22 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                char c10 = (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                int iLastIndexOf = TextUtils.lastIndexOf("", '0', 0) + 466;
                byte[] bArr43 = $$a;
                byte b53 = bArr43[117];
                byte b54 = bArr43[113];
                Object[] objArr121 = new Object[1];
                b(b53, b54, (byte) (b54 | 39), objArr121);
                objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(i169, c10, iLastIndexOf, -612765161, false, (String) objArr121[0], null);
            }
            Object[] objArr122 = (Object[]) ((Field) objAccessartificialFrame38).get(null);
            objArr7 = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
            int i170 = ((int[]) objArr122[3])[0];
            int i171 = ((int[]) objArr122[0])[0];
            String[] strArr9 = (String[]) objArr122[1];
            int i172 = ~Settings.System.getInt(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getContentResolver(), "screen_brightness", -1);
            int i173 = 1966259260 + ((~((-537399761) | i172)) * (-783)) + (((~(i172 | (-681203155))) | (-841552881)) * 783) + 720222220;
            int i174 = (i173 << 13) ^ i173;
            int i175 = i174 ^ (i174 >>> 17);
            ((int[]) objArr7[2])[0] = i175 ^ (i175 << 5);
            c = 0;
        }
        int i176 = ((int[]) objArr7[c])[c];
        int i177 = ((int[]) objArr7[3])[c];
        if (i177 == i176) {
            Object[] objArr123 = new Object[4];
            int[] iArr = new int[1];
            objArr123[c] = iArr;
            objArr123[2] = new int[1];
            int[] iArr2 = new int[1];
            objArr123[3] = iArr2;
            int i178 = ((int[]) objArr7[2])[c];
            int i179 = ((int[]) objArr7[3])[c];
            int i180 = ((int[]) objArr7[c])[c];
            String[] strArr10 = (String[]) objArr7[1];
            iArr2[c] = i179;
            iArr[c] = i180;
            int iIdentityHashCode5 = System.identityHashCode(this);
            int i181 = ~iIdentityHashCode5;
            int i182 = i178 + (-1153305531) + (((~(i181 | 56615145)) | (-125828606) | (~((-34521121) | iIdentityHashCode5))) * 717) + (((~(iIdentityHashCode5 | 56615145)) | (~(i181 | (-34521121))) | (-125828606)) * 717);
            int i183 = (i182 << 13) ^ i182;
            int i184 = i183 ^ (i183 >>> 17);
            ((int[]) objArr123[2])[0] = i184 ^ (i184 << 5);
            objArr123[1] = strArr10;
            return;
        }
        ArrayList arrayList4 = new ArrayList();
        String[] strArr11 = (String[]) objArr7[1];
        if (strArr11 != null) {
            for (String str7 : strArr11) {
                arrayList4.add(str7);
            }
        }
        Object[] objArr124 = {Long.valueOf(((long) (i176 ^ i177)) ^ (((long) (-1106019891)) << 32)), Long.valueOf(-1106019955)};
        byte[] bArr44 = $$d;
        Object[] objArr125 = new Object[1];
        d(bArr44[17], bArr44[117], bArr44[2], objArr125);
        Class<?> cls17 = Class.forName((String) objArr125[0]);
        Object[] objArr126 = new Object[1];
        d((byte) 75, (short) 585, bArr44[117], objArr126);
        cls17.getMethod((String) objArr126[0], Long.TYPE, Long.TYPE).invoke(null, objArr124);
        Object[] objArr127 = {new int[]{i}, strArr, new int[1], new int[]{i}};
        int i185 = ((int[]) objArr7[2])[0];
        int i186 = ((int[]) objArr7[3])[0];
        int i187 = ((int[]) objArr7[0])[0];
        String[] strArr12 = (String[]) objArr7[1];
        int i188 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().uiMode;
        int i189 = ~i188;
        int i190 = i185 + (-1848033665) + (((~((-86794997) | i189)) | (~((-73554730) | i188))) * 1900) + (((~(i189 | 73554729)) | (~(i188 | 86794996))) * (-950)) + (((~(i188 | 73554729)) | (~(i189 | 86794996))) * 950);
        int i191 = (i190 << 13) ^ i190;
        int i192 = i191 ^ (i191 >>> 17);
        ((int[]) objArr127[2])[0] = i192 ^ (i192 << 5);
    }

    static void accessartificialFrame() {
        onPostMessage = -5828069270127671469L;
    }
}
