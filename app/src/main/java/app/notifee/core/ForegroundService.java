package app.notifee.core;

import android.app.Notification;
import android.app.Service;
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
import android.os.IBinder;
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
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationManagerCompat;
import app.notifee.core.event.ForegroundServiceEvent;
import app.notifee.core.event.NotificationEvent;
import app.notifee.core.interfaces.MethodCallResult;
import app.notifee.core.model.NotificationModel;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.net.SyslogConstants;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager$$ExternalSyntheticLambda5;
import com.google.common.base.Ascii;
import com.transistorsoft.locationmanager.config.TSNotification;
import com.transistorsoft.locationmanager.location.TSLocationManager;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kotlin.text.Typography;
import n.o.t.i.f.e.e.e;
import n.o.t.i.f.e.e.f;
import o.ArtificialStackFrames;
import o.extraCallback;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.CharUtils;

/* JADX INFO: loaded from: classes4.dex */
public class ForegroundService extends Service {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    private static char[] ArtificialStackFrames;
    public static String a;
    private static int artificialFrame;
    private static char coroutineCreation;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static final byte[] $$c = {53, 69, 94, -115};
    private static final int $$f = 28;
    private static int $10 = 0;
    private static int $11 = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0025). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(short r5, int r6, short r7) {
        /*
            int r6 = r6 * 3
            int r0 = r6 + 1
            int r7 = r7 + 97
            int r5 = r5 * 3
            int r5 = r5 + 4
            byte[] r1 = app.notifee.core.ForegroundService.$$c
            byte[] r0 = new byte[r0]
            r2 = 0
            if (r1 != 0) goto L15
            r3 = r5
            r7 = r6
            r4 = r2
            goto L25
        L15:
            r3 = r2
        L16:
            byte r4 = (byte) r7
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L23
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            return r5
        L23:
            r3 = r1[r5]
        L25:
            int r5 = r5 + 1
            int r7 = r7 + r3
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: app.notifee.core.ForegroundService.$$g(short, int, short):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Exception exc, Void r2) {
        stopForeground(true);
        a = null;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    /* JADX WARN: Code duplicated, block: B:8:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0025). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(short r5, int r6, short r7, java.lang.Object[] r8) {
        /*
            int r0 = 21 - r7
            int r5 = 100 - r5
            byte[] r1 = app.notifee.core.ForegroundService.$$a
            int r6 = r6 + 65
            byte[] r0 = new byte[r0]
            int r7 = 20 - r7
            r2 = 0
            if (r1 != 0) goto L13
            r4 = r5
            r6 = r7
            r3 = r2
            goto L25
        L13:
            r3 = r2
        L14:
            byte r4 = (byte) r6
            r0[r3] = r4
            if (r3 != r7) goto L21
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            r8[r2] = r5
            return
        L21:
            int r3 = r3 + 1
            r4 = r1[r5]
        L25:
            int r5 = r5 + 1
            int r4 = -r4
            int r6 = r6 + r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: app.notifee.core.ForegroundService.b(short, int, short, java.lang.Object[]):void");
    }

    private static void d(int i, byte b, int i2, Object[] objArr) {
        int i3 = 111 - i2;
        byte[] bArr = $$d;
        int i4 = i + 4;
        byte[] bArr2 = new byte[85 - b];
        int i5 = 84 - b;
        int i6 = -1;
        if (bArr == null) {
            i6 = -1;
            i3 = (i3 + i4) - 4;
            i4++;
        }
        while (true) {
            int i7 = i6 + 1;
            bArr2[i7] = (byte) i3;
            if (i7 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i8 = i3;
            int i9 = i4 + 1;
            i6 = i7;
            i3 = (i8 + bArr[i4]) - 4;
            i4 = i9;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null || "app.notifee.core.ForegroundService.STOP".equals(intent.getAction())) {
            stopSelf();
            a = null;
            return 0;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return 2;
        }
        int i3 = extras.getInt("hashCode");
        Notification notification = (Notification) extras.getParcelable(TSNotification.NAME);
        Bundle bundle = extras.getBundle("notificationBundle");
        if (!(bundle != null) || !(notification != null)) {
            return 2;
        }
        NotificationModel notificationModel = new NotificationModel(bundle);
        String str = a;
        if (str == null) {
            a = notificationModel.c();
            startForeground(i3, notification);
            f.a(new ForegroundServiceEvent(notificationModel, new MethodCallResult() { // from class: app.notifee.core.ForegroundService$$ExternalSyntheticLambda0
                @Override // app.notifee.core.interfaces.MethodCallResult
                public final void onComplete(Exception exc, Object obj) {
                    this.f$0.a(exc, (Void) obj);
                }
            }));
            return 2;
        }
        if (str.equals(notificationModel.c())) {
            NotificationManagerCompat.from(e.a).notify(i3, notification);
            return 2;
        }
        f.a(new NotificationEvent(8, notificationModel));
        return 2;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0114  */
    /* JADX WARN: Code duplicated, block: B:34:0x0134 A[Catch: all -> 0x035c, TRY_ENTER, TryCatch #0 {all -> 0x035c, blocks: (B:7:0x0020, B:9:0x002e, B:10:0x0060, B:14:0x007a, B:16:0x008b, B:17:0x00bb, B:34:0x0134, B:36:0x017f, B:37:0x01f2, B:41:0x0211, B:43:0x024b, B:44:0x02af), top: B:61:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x017f A[Catch: all -> 0x035c, TryCatch #0 {all -> 0x035c, blocks: (B:7:0x0020, B:9:0x002e, B:10:0x0060, B:14:0x007a, B:16:0x008b, B:17:0x00bb, B:34:0x0134, B:36:0x017f, B:37:0x01f2, B:41:0x0211, B:43:0x024b, B:44:0x02af), top: B:61:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x0205  */
    /* JADX WARN: Code duplicated, block: B:43:0x024b A[Catch: all -> 0x035c, TryCatch #0 {all -> 0x035c, blocks: (B:7:0x0020, B:9:0x002e, B:10:0x0060, B:14:0x007a, B:16:0x008b, B:17:0x00bb, B:34:0x0134, B:36:0x017f, B:37:0x01f2, B:41:0x0211, B:43:0x024b, B:44:0x02af), top: B:61:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:48:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:49:0x0309  */
    private static void c(int i, char[] cArr, byte b, Object[] objArr) throws Throwable {
        int i2;
        Object obj;
        Object[] objArr2;
        Object objAccessartificialFrame;
        Object objAccessartificialFrame2;
        int i3 = 2 % 2;
        extraCallback extracallback = new extraCallback();
        char[] cArr2 = ArtificialStackFrames;
        int i4 = -1819279892;
        long j = 0;
        Object obj2 = null;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i5 = 0;
            while (i5 < length) {
                try {
                    Object[] objArr3 = {Integer.valueOf(cArr2[i5])};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(i4);
                    if (objAccessartificialFrame3 == null) {
                        byte b2 = (byte) 0;
                        byte b3 = b2;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(TextUtils.getOffsetBefore("", 0) + 15, (char) (ExpandableListView.getPackedPositionType(j) + 20488), 2148 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 216710116, false, $$g(b2, b3, b3), new Class[]{Integer.TYPE});
                    }
                    cArr3[i5] = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr3)).charValue();
                    i5++;
                    i4 = -1819279892;
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
        Object[] objArr4 = {Integer.valueOf(coroutineCreation)};
        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1819279892);
        if (objAccessartificialFrame4 == null) {
            byte b4 = (byte) 0;
            byte b5 = b4;
            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getTapTimeout() >> 16) + 15, (char) (20487 - ExpandableListView.getPackedPositionChild(0L)), 2149 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 216710116, false, $$g(b4, b5, b5), new Class[]{Integer.TYPE});
        }
        char cCharValue = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr4)).charValue();
        char[] cArr4 = new char[i];
        if (i % 2 != 0) {
            i2 = i - 1;
            cArr4[i2] = (char) (cArr[i2] - b);
        } else {
            i2 = i;
        }
        if (i2 > 1) {
            extracallback.a = 0;
            while (extracallback.a < i2) {
                int i6 = $11 + 81;
                $10 = i6 % 128;
                if (i6 % 2 != 0) {
                    extracallback.createBrowser = cArr[extracallback.a];
                    int i7 = extracallback.a;
                    extracallback.c = cArr[0];
                    if (extracallback.createBrowser == extracallback.c) {
                        int i8 = $11 + 61;
                        $10 = i8 % 128;
                        int i9 = i8 % 2;
                        cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                        cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                        obj = obj2;
                    } else {
                        objArr2 = new Object[]{extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                        objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1894223152);
                        if (objAccessartificialFrame == null) {
                            byte b6 = (byte) 0;
                            byte b7 = b6;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(46 - View.MeasureSpec.getMode(0), (char) (((Process.getThreadPriority(0) + 20) >> 6) + 58859), 2464 - (Process.myTid() >> 22), 276640984, false, $$g(b6, b7, (byte) (b7 + 5)), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                        }
                        if (((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue() == extracallback.g) {
                            int i10 = $10 + 33;
                            $11 = i10 % 128;
                            int i11 = i10 % 2;
                            Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1361113423);
                            if (objAccessartificialFrame2 == null) {
                                byte b8 = (byte) 0;
                                byte b9 = b8;
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((Process.myTid() >> 22) + 24, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16), 791 - TextUtils.indexOf((CharSequence) "", '0'), -834291897, false, $$g(b8, b9, (byte) (b9 | 8)), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                            }
                            obj = null;
                            int iIntValue = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr5)).intValue();
                            int i12 = (extracallback.d * cCharValue) + extracallback.g;
                            cArr4[extracallback.a] = cArr2[iIntValue];
                            cArr4[extracallback.a + 1] = cArr2[i12];
                        } else {
                            obj = null;
                            if (extracallback.b == extracallback.d) {
                                int i13 = $10 + 35;
                                $11 = i13 % 128;
                                int i14 = i13 % 2;
                                extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                                extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                                int i15 = (extracallback.b * cCharValue) + extracallback.j;
                                int i16 = (extracallback.d * cCharValue) + extracallback.g;
                                cArr4[extracallback.a] = cArr2[i15];
                                cArr4[extracallback.a + 1] = cArr2[i16];
                            } else {
                                int i17 = (extracallback.b * cCharValue) + extracallback.g;
                                int i18 = (extracallback.d * cCharValue) + extracallback.j;
                                cArr4[extracallback.a] = cArr2[i17];
                                cArr4[extracallback.a + 1] = cArr2[i18];
                            }
                        }
                    }
                } else {
                    extracallback.createBrowser = cArr[extracallback.a];
                    extracallback.c = cArr[extracallback.a + 1];
                    if (extracallback.createBrowser == extracallback.c) {
                        int i19 = $11 + 61;
                        $10 = i19 % 128;
                        int i20 = i19 % 2;
                        cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                        cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                        obj = obj2;
                    } else {
                        objArr2 = new Object[]{extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                        objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1894223152);
                        if (objAccessartificialFrame == null) {
                            byte b10 = (byte) 0;
                            byte b11 = b10;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(46 - View.MeasureSpec.getMode(0), (char) (((Process.getThreadPriority(0) + 20) >> 6) + 58859), 2464 - (Process.myTid() >> 22), 276640984, false, $$g(b10, b11, (byte) (b11 + 5)), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                        }
                        if (((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue() == extracallback.g) {
                            int i110 = $10 + 33;
                            $11 = i110 % 128;
                            int i111 = i110 % 2;
                            Object[] objArr6 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1361113423);
                            if (objAccessartificialFrame2 == null) {
                                byte b12 = (byte) 0;
                                byte b13 = b12;
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((Process.myTid() >> 22) + 24, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16), 791 - TextUtils.indexOf((CharSequence) "", '0'), -834291897, false, $$g(b12, b13, (byte) (b13 | 8)), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                            }
                            obj = null;
                            int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr6)).intValue();
                            int i112 = (extracallback.d * cCharValue) + extracallback.g;
                            cArr4[extracallback.a] = cArr2[iIntValue2];
                            cArr4[extracallback.a + 1] = cArr2[i112];
                        } else {
                            obj = null;
                            if (extracallback.b == extracallback.d) {
                                int i113 = $10 + 35;
                                $11 = i113 % 128;
                                int i114 = i113 % 2;
                                extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                                extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                                int i115 = (extracallback.b * cCharValue) + extracallback.j;
                                int i116 = (extracallback.d * cCharValue) + extracallback.g;
                                cArr4[extracallback.a] = cArr2[i115];
                                cArr4[extracallback.a + 1] = cArr2[i116];
                            } else {
                                int i117 = (extracallback.b * cCharValue) + extracallback.g;
                                int i118 = (extracallback.d * cCharValue) + extracallback.j;
                                cArr4[extracallback.a] = cArr2[i117];
                                cArr4[extracallback.a + 1] = cArr2[i118];
                            }
                        }
                    }
                }
                extracallback.a += 2;
                int i21 = $11 + 13;
                $10 = i21 % 128;
                int i22 = i21 % 2;
                obj2 = obj;
            }
        }
        int i23 = $11 + 31;
        $10 = i23 % 128;
        int i24 = i23 % 2;
        int i25 = 0;
        while (i25 < i) {
            cArr4[i25] = (char) (cArr4[i25] ^ 13722);
            i25++;
            int i26 = $11 + 77;
            $10 = i26 % 128;
            int i27 = i26 % 2;
        }
        objArr[0] = new String(cArr4);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x01db  */
    /* JADX WARN: Code duplicated, block: B:23:0x0290 A[Catch: all -> 0x0b71, TryCatch #0 {all -> 0x0b71, blocks: (B:61:0x0818, B:63:0x0838, B:64:0x088b, B:21:0x027c, B:23:0x0290, B:24:0x02c0), top: B:101:0x027c }] */
    /* JADX WARN: Code duplicated, block: B:27:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:32:0x03cd  */
    /* JADX WARN: Code duplicated, block: B:60:0x0777  */
    /* JADX WARN: Code duplicated, block: B:63:0x0838 A[Catch: all -> 0x0b71, TryCatch #0 {all -> 0x0b71, blocks: (B:61:0x0818, B:63:0x0838, B:64:0x088b, B:21:0x027c, B:23:0x0290, B:24:0x02c0), top: B:101:0x027c }] */
    /* JADX WARN: Code duplicated, block: B:67:0x089c  */
    /* JADX WARN: Code duplicated, block: B:72:0x097d  */
    @Override // android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) throws Throwable {
        Object objAccessartificialFrame;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        Object[] objArr;
        int i = 2 % 2;
        int i2 = artificialFrame + 31;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        if (i2 % 2 != 0) {
            super.attachBaseContext(context);
            Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame7 == null) {
                int absoluteGravity = 26 - Gravity.getAbsoluteGravity(0, 0);
                char jumpTapTimeout = (char) (ViewConfiguration.getJumpTapTimeout() >> 16);
                int iBlue = Color.blue(0) + 1041;
                Object[] objArr2 = new Object[1];
                b((byte) 96, (byte) 47, $$a[18], objArr2);
                objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(absoluteGravity, jumpTapTimeout, iBlue, 2061780482, false, (String) objArr2[0], null);
            }
            ((Field) objAccessartificialFrame7).getLong(null);
            throw null;
        }
        super.attachBaseContext(context);
        Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame8 == null) {
            int i3 = 27 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
            char mode = (char) View.MeasureSpec.getMode(0);
            int longPressTimeout = (ViewConfiguration.getLongPressTimeout() >> 16) + 1041;
            Object[] objArr3 = new Object[1];
            b((byte) 96, (byte) 47, $$a[18], objArr3);
            objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i3, mode, longPressTimeout, 2061780482, false, (String) objArr3[0], null);
        }
        long j = ((Field) objAccessartificialFrame8).getLong(null);
        if (j != -1) {
            long j2 = j + 4611686018427387883L;
            Object[] objArr4 = new Object[1];
            c(KeyEvent.normalizeMetaState(0) + 22, new char[]{17, 5, '0', CoreConstants.DASH_CHAR, '$', ' ', CoreConstants.DASH_CHAR, 19, CoreConstants.LEFT_PARENTHESIS_CHAR, ' ', 19, 24, CoreConstants.LEFT_PARENTHESIS_CHAR, 30, 29, 3, 23, '\n', ' ', CoreConstants.RIGHT_PARENTHESIS_CHAR, ' ', 7}, (byte) (KeyEvent.getDeadChar(0, 0) + 57), objArr4);
            Class<?> cls = Class.forName((String) objArr4[0]);
            Object[] objArr5 = new Object[1];
            c(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 16, new char[]{6, 29, 20, 26, 29, 5, '.', 19, 5, 15, 28, ' ', 31, 22, 13835}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 23), objArr5);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i4 = artificialFrame + 73;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i4 % 128;
                int i5 = i4 % 2;
                Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame9 == null) {
                    int i6 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 25;
                    char longPressTimeout2 = (char) (ViewConfiguration.getLongPressTimeout() >> 16);
                    int keyRepeatTimeout = 1041 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                    Object[] objArr6 = new Object[1];
                    b((byte) 88, (byte) 47, $$a[18], objArr6);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(i6, longPressTimeout2, keyRepeatTimeout, 1145017376, false, (String) objArr6[0], null);
                }
                Object[] objArr7 = (Object[]) ((Field) objAccessartificialFrame9).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i7 = ((int[]) objArr7[3])[0];
                int i8 = ((int[]) objArr7[2])[0];
                String[] strArr = (String[]) objArr7[0];
                int iIdentityHashCode = System.identityHashCode(this);
                int i9 = ~iIdentityHashCode;
                int i10 = ((((-279211218) + ((266076119 | iIdentityHashCode) * (-676))) + (((~(172211157 | i9)) | (-266076120)) * 676)) + (((~(iIdentityHashCode | (-93864963))) | ((~(i9 | 94107350)) | 171968769)) * 676)) - 2108330584;
                int i11 = (i10 << 13) ^ i10;
                int i12 = i11 ^ (i11 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i12 ^ (i12 << 5);
            } else {
                Object[] objArr8 = new Object[1];
                c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 20, new char[]{'/', 26, '/', 18, 20, 31, 17, 5, 17, 18, 23, CoreConstants.LEFT_PARENTHESIS_CHAR, '\"', ' ', 3, 22}, (byte) (ExpandableListView.getPackedPositionChild(0L) + 24), objArr8);
                Class<?> cls2 = Class.forName((String) objArr8[0]);
                Object[] objArr9 = new Object[1];
                c((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 16, new char[]{'!', '+', 2, 4, ' ', 30, 30, Typography.amp, '/', 14, 29, 19, 11, CoreConstants.PERCENT_CHAR, '+', 5}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 55), objArr9);
                int iIntValue = ((Integer) cls2.getMethod((String) objArr9[0], Object.class).invoke(null, this)).intValue();
                try {
                    Object[] objArr10 = {-1044316973};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(8 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 22252), 1033 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = com.google.firebase.R.raw.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr10), -2108330584, false);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame2 == null) {
                        int absoluteGravity2 = 26 - Gravity.getAbsoluteGravity(0, 0);
                        char c = (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                        int windowTouchSlop = 1041 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                        Object[] objArr11 = new Object[1];
                        b((byte) 88, (byte) 47, $$a[18], objArr11);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(absoluteGravity2, c, windowTouchSlop, 1145017376, false, (String) objArr11[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
                    try {
                        Object[] objArr12 = new Object[1];
                        c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 1, new char[]{17, 5, '0', CoreConstants.DASH_CHAR, '$', ' ', CoreConstants.DASH_CHAR, 19, CoreConstants.LEFT_PARENTHESIS_CHAR, ' ', 19, 24, CoreConstants.LEFT_PARENTHESIS_CHAR, 30, 29, 3, 23, '\n', ' ', CoreConstants.RIGHT_PARENTHESIS_CHAR, ' ', 7}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 21), objArr12);
                        Class<?> cls3 = Class.forName((String) objArr12[0]);
                        Object[] objArr13 = new Object[1];
                        c(Gravity.getAbsoluteGravity(0, 0) + 15, new char[]{6, 29, 20, 26, 29, 5, '.', 19, 5, 15, 28, ' ', 31, 22, 13835}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(1) - 89), objArr13);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr13[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame3 == null) {
                            int maximumDrawingCacheSize = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 26;
                            char cIndexOf = (char) TextUtils.indexOf("", "");
                            int i13 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 1040;
                            Object[] objArr14 = new Object[1];
                            b((byte) 96, (byte) 47, $$a[18], objArr14);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize, cIndexOf, i13, 2061780482, false, (String) objArr14[0], null);
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
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 20, new char[]{'/', 26, '/', 18, 20, 31, 17, 5, 17, 18, 23, CoreConstants.LEFT_PARENTHESIS_CHAR, '\"', ' ', 3, 22}, (byte) (ExpandableListView.getPackedPositionChild(0L) + 24), objArr15);
            Class<?> cls4 = Class.forName((String) objArr15[0]);
            Object[] objArr16 = new Object[1];
            c((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 16, new char[]{'!', '+', 2, 4, ' ', 30, 30, Typography.amp, '/', 14, 29, 19, 11, CoreConstants.PERCENT_CHAR, '+', 5}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 55), objArr16);
            int iIntValue2 = ((Integer) cls4.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr17 = {-1044316973};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(8 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 22252), 1033 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = com.google.firebase.R.raw.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr17), -2108330584, false);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame2 == null) {
                int absoluteGravity3 = 26 - Gravity.getAbsoluteGravity(0, 0);
                char c2 = (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                int windowTouchSlop2 = 1041 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                Object[] objArr18 = new Object[1];
                b((byte) 88, (byte) 47, $$a[18], objArr18);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(absoluteGravity3, c2, windowTouchSlop2, 1145017376, false, (String) objArr18[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr19 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 1, new char[]{17, 5, '0', CoreConstants.DASH_CHAR, '$', ' ', CoreConstants.DASH_CHAR, 19, CoreConstants.LEFT_PARENTHESIS_CHAR, ' ', 19, 24, CoreConstants.LEFT_PARENTHESIS_CHAR, 30, 29, 3, 23, '\n', ' ', CoreConstants.RIGHT_PARENTHESIS_CHAR, ' ', 7}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 21), objArr19);
            Class<?> cls5 = Class.forName((String) objArr19[0]);
            Object[] objArr110 = new Object[1];
            c(Gravity.getAbsoluteGravity(0, 0) + 15, new char[]{6, 29, 20, 26, 29, 5, '.', 19, 5, 15, 28, ' ', 31, 22, 13835}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(1) - 89), objArr110);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr110[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame3 == null) {
                int maximumDrawingCacheSize2 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 26;
                char cIndexOf2 = (char) TextUtils.indexOf("", "");
                int i14 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 1040;
                Object[] objArr111 = new Object[1];
                b((byte) 96, (byte) 47, $$a[18], objArr111);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize2, cIndexOf2, i14, 2061780482, false, (String) objArr111[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i15 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i16 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i16 == i15) {
            int i17 = artificialFrame + 115;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i17 % 128;
            int i18 = i17 % 2;
            Object[] objArr20 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i19 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i20 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i21 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int i22 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().orientation;
            int i23 = i19 + 1934846134 + (((~((~i22) | (-277160129))) | (~((-6851331) | i22))) * (-302)) + ((~((-277160129) | i22)) * (-604)) + (((~(i22 | (-284011459))) | (-368966596)) * 302);
            int i24 = (i23 << 13) ^ i23;
            int i25 = i24 ^ (i24 >>> 17);
            ((int[]) objArr20[1])[0] = i25 ^ (i25 << 5);
            int i26 = getARTIFICIAL_FRAME_PACKAGE_NAME + 3;
            artificialFrame = i26 % 128;
            int i27 = i26 % 2;
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr3 != null) {
                int i28 = artificialFrame + 9;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i28 % 128;
                for (int i29 = i28 % 2 != 0 ? 1 : 0; i29 < strArr3.length; i29++) {
                    arrayList.add(strArr3[i29]);
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf((((long) 926542628) << 32) ^ ((long) (i15 ^ i16))), Long.valueOf(926542630)};
                byte[] bArr = $$d;
                byte b = bArr[4];
                Object[] objArr22 = new Object[1];
                d(b, bArr[137], b, objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                short s = (short) (-bArr[384]);
                int i30 = $$e;
                Object[] objArr23 = new Object[1];
                d(s, (byte) (i30 | 80), (byte) (i30 | 73), objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i31 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i32 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i33 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
                int i34 = (~((-470343293) | iMaxMemory)) | 134792704;
                int i35 = i31 + (-6678306) + (i34 * 992) + ((i34 | (~((~iMaxMemory) | (-56688898)))) * (-496)) + ((iMaxMemory | (-392239486)) * 496);
                int i36 = (i35 << 13) ^ i35;
                int i37 = i36 ^ (i36 >>> 17);
                ((int[]) objArr24[1])[0] = i37 ^ (i37 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame10 == null) {
            int i38 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 25;
            char cNormalizeMetaState = (char) (30068 - KeyEvent.normalizeMetaState(0));
            int modifierMetaStateMask = ((byte) KeyEvent.getModifierMetaStateMask()) + 817;
            Object[] objArr25 = new Object[1];
            b((byte) 96, (byte) 47, $$a[18], objArr25);
            objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(i38, cNormalizeMetaState, modifierMetaStateMask, 721586079, false, (String) objArr25[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame10).getLong(null);
        if (j3 != -1) {
            int i39 = getARTIFICIAL_FRAME_PACKAGE_NAME + 85;
            artificialFrame = i39 % 128;
            int i40 = i39 % 2;
            long j4 = j3 + 1958;
            Object[] objArr26 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 18, new char[]{17, 5, '0', CoreConstants.DASH_CHAR, '$', ' ', CoreConstants.DASH_CHAR, 19, CoreConstants.LEFT_PARENTHESIS_CHAR, ' ', 19, 24, CoreConstants.LEFT_PARENTHESIS_CHAR, 30, 29, 3, 23, '\n', ' ', CoreConstants.RIGHT_PARENTHESIS_CHAR, ' ', 7}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 36), objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            c((ViewConfiguration.getJumpTapTimeout() >> 16) + 15, new char[]{6, 29, 20, 26, 29, 5, '.', 19, 5, 15, 28, ' ', 31, 22, 13835}, (byte) (View.MeasureSpec.makeMeasureSpec(0, 0) + 12), objArr27);
            if (j4 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i41 = getARTIFICIAL_FRAME_PACKAGE_NAME + 37;
                artificialFrame = i41 % 128;
                int i42 = i41 % 2;
                Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame11 == null) {
                    int maxKeyCode = 25 - (KeyEvent.getMaxKeyCode() >> 16);
                    char c3 = (char) (30068 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                    int iIndexOf = 815 - TextUtils.indexOf((CharSequence) "", '0', 0);
                    Object[] objArr28 = new Object[1];
                    b((byte) 88, (byte) 47, $$a[18], objArr28);
                    objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(maxKeyCode, c3, iIndexOf, 891606461, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame11).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i43 = ((int[]) objArr29[0])[0];
                int i44 = ((int[]) objArr29[1])[0];
                String[] strArr5 = (String[]) objArr29[2];
                int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 1610868819;
                int i45 = ((((-875176517) + (((~(274156350 | length)) | 5259570) * (-502))) + ((~((~length) | 477588286)) * (-502))) + (((~(length | (-472328717))) | 274156350) * TypedValues.PositionType.TYPE_DRAWPATH)) - 1013714002;
                int i46 = (i45 << 13) ^ i45;
                int i47 = i46 ^ (i46 >>> 17);
                ((int[]) objArr[3])[0] = i47 ^ (i47 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 12, new char[]{'/', 26, '/', 18, 20, 31, 17, 5, 17, 18, 23, CoreConstants.LEFT_PARENTHESIS_CHAR, '\"', ' ', 3, 22}, (byte) (Color.red(0) + 23), objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                c(View.resolveSize(0, 0) + 16, new char[]{'!', '+', 2, 4, ' ', 30, 30, Typography.amp, '/', 14, 29, 19, 11, CoreConstants.PERCENT_CHAR, '+', 5}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 56), objArr31);
                Object[] objArr32 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue()), 0, -1013714002};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame4 == null) {
                    int i48 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 24;
                    char trimmedLength = (char) (30068 - TextUtils.getTrimmedLength(""));
                    int fadingEdgeLength = (ViewConfiguration.getFadingEdgeLength() >> 16) + 816;
                    byte[] bArr2 = $$a;
                    Object[] objArr33 = new Object[1];
                    b((byte) 80, bArr2[35], bArr2[9], objArr33);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i48, trimmedLength, fadingEdgeLength, -797394565, false, (String) objArr33[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                Object[] objArr34 = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr32);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame5 == null) {
                    int iLastIndexOf = TextUtils.lastIndexOf("", '0') + 26;
                    char scrollBarSize = (char) ((ViewConfiguration.getScrollBarSize() >> 8) + 30068);
                    int jumpTapTimeout2 = (ViewConfiguration.getJumpTapTimeout() >> 16) + 816;
                    Object[] objArr35 = new Object[1];
                    b((byte) 88, (byte) 47, $$a[18], objArr35);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, scrollBarSize, jumpTapTimeout2, 891606461, false, (String) objArr35[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr34);
                try {
                    Object[] objArr36 = new Object[1];
                    c(22 - View.MeasureSpec.makeMeasureSpec(0, 0), new char[]{17, 5, '0', CoreConstants.DASH_CHAR, '$', ' ', CoreConstants.DASH_CHAR, 19, CoreConstants.LEFT_PARENTHESIS_CHAR, ' ', 19, 24, CoreConstants.LEFT_PARENTHESIS_CHAR, 30, 29, 3, 23, '\n', ' ', CoreConstants.RIGHT_PARENTHESIS_CHAR, ' ', 7}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) + 21), objArr36);
                    Class<?> cls9 = Class.forName((String) objArr36[0]);
                    Object[] objArr37 = new Object[1];
                    c(15 - Color.green(0), new char[]{6, 29, 20, 26, 29, 5, '.', 19, 5, 15, 28, ' ', 31, 22, 13835}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 23), objArr37);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr37[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame6 == null) {
                        int i49 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 24;
                        char cResolveOpacity = (char) (30068 - Drawable.resolveOpacity(0, 0));
                        int iRed = 816 - Color.red(0);
                        Object[] objArr38 = new Object[1];
                        b((byte) 96, (byte) 47, $$a[18], objArr38);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i49, cResolveOpacity, iRed, 721586079, false, (String) objArr38[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                    objArr = objArr34;
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr39 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 12, new char[]{'/', 26, '/', 18, 20, 31, 17, 5, 17, 18, 23, CoreConstants.LEFT_PARENTHESIS_CHAR, '\"', ' ', 3, 22}, (byte) (Color.red(0) + 23), objArr39);
            Class<?> cls10 = Class.forName((String) objArr39[0]);
            Object[] objArr310 = new Object[1];
            c(View.resolveSize(0, 0) + 16, new char[]{'!', '+', 2, 4, ' ', 30, 30, Typography.amp, '/', 14, 29, 19, 11, CoreConstants.PERCENT_CHAR, '+', 5}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 56), objArr310);
            Object[] objArr311 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr310[0], Object.class).invoke(null, this)).intValue()), 0, -1013714002};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame4 == null) {
                int i410 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 24;
                char trimmedLength2 = (char) (30068 - TextUtils.getTrimmedLength(""));
                int fadingEdgeLength2 = (ViewConfiguration.getFadingEdgeLength() >> 16) + 816;
                byte[] bArr3 = $$a;
                Object[] objArr312 = new Object[1];
                b((byte) 80, bArr3[35], bArr3[9], objArr312);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i410, trimmedLength2, fadingEdgeLength2, -797394565, false, (String) objArr312[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            Object[] objArr313 = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr311);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame5 == null) {
                int iLastIndexOf2 = TextUtils.lastIndexOf("", '0') + 26;
                char scrollBarSize2 = (char) ((ViewConfiguration.getScrollBarSize() >> 8) + 30068);
                int jumpTapTimeout3 = (ViewConfiguration.getJumpTapTimeout() >> 16) + 816;
                Object[] objArr314 = new Object[1];
                b((byte) 88, (byte) 47, $$a[18], objArr314);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iLastIndexOf2, scrollBarSize2, jumpTapTimeout3, 891606461, false, (String) objArr314[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr313);
            Object[] objArr315 = new Object[1];
            c(22 - View.MeasureSpec.makeMeasureSpec(0, 0), new char[]{17, 5, '0', CoreConstants.DASH_CHAR, '$', ' ', CoreConstants.DASH_CHAR, 19, CoreConstants.LEFT_PARENTHESIS_CHAR, ' ', 19, 24, CoreConstants.LEFT_PARENTHESIS_CHAR, 30, 29, 3, 23, '\n', ' ', CoreConstants.RIGHT_PARENTHESIS_CHAR, ' ', 7}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) + 21), objArr315);
            Class<?> cls11 = Class.forName((String) objArr315[0]);
            Object[] objArr316 = new Object[1];
            c(15 - Color.green(0), new char[]{6, 29, 20, 26, 29, 5, '.', 19, 5, 15, 28, ' ', 31, 22, 13835}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 23), objArr316);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr316[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame6 == null) {
                int i411 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 24;
                char cResolveOpacity2 = (char) (30068 - Drawable.resolveOpacity(0, 0));
                int iRed2 = 816 - Color.red(0);
                Object[] objArr317 = new Object[1];
                b((byte) 96, (byte) 47, $$a[18], objArr317);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i411, cResolveOpacity2, iRed2, 721586079, false, (String) objArr317[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
            objArr = objArr313;
        }
        int i50 = ((int[]) objArr[1])[0];
        int i51 = ((int[]) objArr[0])[0];
        if (i51 == i50) {
            int i52 = getARTIFICIAL_FRAME_PACKAGE_NAME + 107;
            artificialFrame = i52 % 128;
            int i53 = i52 % 2;
            Object[] objArr40 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i54 = ((int[]) objArr[3])[0];
            int i55 = ((int[]) objArr[0])[0];
            int i56 = ((int[]) objArr[1])[0];
            String[] strArr6 = (String[]) objArr[2];
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i57 = ~iIdentityHashCode2;
            int i58 = i54 + 1476814001 + ((494729167 | iIdentityHashCode2) * (-676)) + (((~(357348751 | i57)) | (-494729168)) * 676) + (((~(iIdentityHashCode2 | (-137380417))) | (~(i57 | 159176385)) | 335552782) * 676);
            int i59 = (i58 << 13) ^ i58;
            int i60 = i59 ^ (i59 >>> 17);
            ((int[]) objArr40[3])[0] = i60 ^ (i60 << 5);
            int i61 = getARTIFICIAL_FRAME_PACKAGE_NAME + 43;
            artificialFrame = i61 % 128;
            int i62 = i61 % 2;
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArr[2];
        if (strArr7 != null) {
            int i63 = artificialFrame + 27;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i63 % 128;
            int i64 = i63 % 2;
            for (String str : strArr7) {
                arrayList2.add(str);
            }
        }
        Object[] objArr41 = {Long.valueOf(((long) (i50 ^ i51)) ^ (((long) (-1602356381)) << 32)), Long.valueOf(-1602356382)};
        byte[] bArr4 = $$d;
        Object[] objArr42 = new Object[1];
        d(bArr4[369], bArr4[530], bArr4[33], objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        short s2 = (short) (-bArr4[384]);
        int i65 = $$e;
        Object[] objArr43 = new Object[1];
        d(s2, (byte) (i65 | 80), (byte) (i65 | 73), objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
        int i66 = ((int[]) objArr[3])[0];
        int i67 = ((int[]) objArr[0])[0];
        int i68 = ((int[]) objArr[1])[0];
        String[] strArr8 = (String[]) objArr[2];
        int i69 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().heightPixels;
        int i70 = ~((-336592999) | i69);
        int i71 = ~i69;
        int i72 = i66 + (-1731777003) + ((i70 | (~(1031335422 | i71))) * 920) + (((~((-892914791) | i71)) | 336592998) * 920) + (((~(i69 | 1031335422)) | (~((-336592999) | i71)) | (~((-556321793) | i69))) * 920);
        int i73 = (i72 << 13) ^ i72;
        int i74 = i73 ^ (i73 >>> 17);
        ((int[]) objArr44[3])[0] = i74 ^ (i74 << 5);
    }

    /* JADX WARN: Code duplicated, block: B:237:0x1900  */
    /* JADX WARN: Code duplicated, block: B:238:0x199e  */
    /* JADX WARN: Code duplicated, block: B:243:0x1a9c  */
    /* JADX WARN: Code duplicated, block: B:246:0x1af1  */
    /* JADX WARN: Code duplicated, block: B:258:0x1c21  */
    /* JADX WARN: Code duplicated, block: B:262:0x1cac  */
    /* JADX WARN: Code duplicated, block: B:267:0x1d1e  */
    /* JADX WARN: Code duplicated, block: B:271:0x1d81  */
    /* JADX WARN: Code duplicated, block: B:272:0x1df6  */
    /* JADX WARN: Code duplicated, block: B:277:0x1efb  */
    /* JADX WARN: Code duplicated, block: B:280:0x1f46  */
    /* JADX WARN: Code duplicated, block: B:282:0x1f6f  */
    /* JADX WARN: Code duplicated, block: B:284:0x1f78  */
    /* JADX WARN: Code duplicated, block: B:287:0x2032  */
    /* JADX WARN: Code duplicated, block: B:291:0x203c A[Catch: all -> 0x2768, TryCatch #5 {all -> 0x2768, blocks: (B:324:0x2481, B:326:0x24a4, B:327:0x24eb, B:289:0x2036, B:291:0x203c, B:292:0x2069, B:294:0x2094, B:295:0x211e, B:186:0x13fd, B:188:0x140a, B:189:0x143d, B:191:0x1447, B:193:0x1454, B:194:0x1484, B:123:0x0d91, B:125:0x0da6, B:126:0x0dd3), top: B:385:0x0d91 }] */
    /* JADX WARN: Code duplicated, block: B:294:0x2094 A[Catch: all -> 0x2768, TryCatch #5 {all -> 0x2768, blocks: (B:324:0x2481, B:326:0x24a4, B:327:0x24eb, B:289:0x2036, B:291:0x203c, B:292:0x2069, B:294:0x2094, B:295:0x211e, B:186:0x13fd, B:188:0x140a, B:189:0x143d, B:191:0x1447, B:193:0x1454, B:194:0x1484, B:123:0x0d91, B:125:0x0da6, B:126:0x0dd3), top: B:385:0x0d91 }] */
    /* JADX WARN: Code duplicated, block: B:298:0x2131  */
    /* JADX WARN: Code duplicated, block: B:303:0x2196  */
    /* JADX WARN: Code duplicated, block: B:307:0x21ef  */
    /* JADX WARN: Code duplicated, block: B:308:0x2251  */
    /* JADX WARN: Code duplicated, block: B:313:0x233c  */
    /* JADX WARN: Code duplicated, block: B:316:0x238b  */
    /* JADX WARN: Code duplicated, block: B:318:0x23b4  */
    /* JADX WARN: Code duplicated, block: B:320:0x23bd  */
    /* JADX WARN: Code duplicated, block: B:323:0x2463  */
    /* JADX WARN: Code duplicated, block: B:326:0x24a4 A[Catch: all -> 0x2768, TryCatch #5 {all -> 0x2768, blocks: (B:324:0x2481, B:326:0x24a4, B:327:0x24eb, B:289:0x2036, B:291:0x203c, B:292:0x2069, B:294:0x2094, B:295:0x211e, B:186:0x13fd, B:188:0x140a, B:189:0x143d, B:191:0x1447, B:193:0x1454, B:194:0x1484, B:123:0x0d91, B:125:0x0da6, B:126:0x0dd3), top: B:385:0x0d91 }] */
    /* JADX WARN: Code duplicated, block: B:330:0x24fe  */
    /* JADX WARN: Code duplicated, block: B:335:0x2565  */
    /* JADX WARN: Code duplicated, block: B:339:0x25ba  */
    /* JADX WARN: Code duplicated, block: B:340:0x2623  */
    /* JADX WARN: Code duplicated, block: B:342:0x262f  */
    /* JADX WARN: Code duplicated, block: B:345:0x2633 A[LOOP:0: B:343:0x2630->B:345:0x2633, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:77:0x08ab  */
    /* JADX WARN: Code duplicated, block: B:80:0x08b5  */
    @Override // android.app.Service
    public void onCreate() throws Throwable {
        Object[] objArr;
        Long lValueOf;
        Object objAccessartificialFrame;
        int iLastIndexOf;
        char jumpTapTimeout;
        int capsMode;
        int i;
        boolean z;
        Object obj;
        int i2;
        Object[] objArr2;
        char c;
        Object[] objArrAccessartificialFrame$78cbbd35;
        int i3;
        Object[] objArr3;
        int i4;
        int i5;
        Object[] objArr4;
        int i6;
        int i7;
        Object objAccessartificialFrame2;
        long j;
        Object[] objArr5;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        int i8;
        int i9;
        int i10;
        Object objAccessartificialFrame5;
        long j2;
        int i11;
        Object objAccessartificialFrame6;
        Object objAccessartificialFrame7;
        Object[] objArr6;
        Object objAccessartificialFrame8;
        Object objAccessartificialFrame9;
        Object obj2;
        int i12;
        Object obj3;
        int i13;
        int i14;
        Object objAccessartificialFrame10;
        long j3;
        Object objAccessartificialFrame11;
        Object[] objArr7;
        Object objAccessartificialFrame12;
        Object objAccessartificialFrame13;
        int i15;
        int i16;
        ArrayList arrayList;
        String[] strArr;
        int i17;
        Object objAccessartificialFrame14;
        Object objAccessartificialFrame15;
        int i18;
        int i19 = 2 % 2;
        Object[] objArr8 = new Object[1];
        c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 13, new char[]{17, 5, '0', CoreConstants.DASH_CHAR, '$', ' ', CoreConstants.DASH_CHAR, 19, CoreConstants.LEFT_PARENTHESIS_CHAR, ' ', 19, 24, CoreConstants.LEFT_PARENTHESIS_CHAR, 30, 29, 3, 23, '\n', ' ', CoreConstants.RIGHT_PARENTHESIS_CHAR, ' ', 7}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 36), objArr8);
        String str = (String) objArr8[0];
        Object[] objArr9 = new Object[1];
        c(KeyEvent.keyCodeFromString("") + 15, new char[]{6, 29, 20, 26, 29, 5, '.', 19, 5, 15, 28, ' ', 31, 22, 13835}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 8), objArr9);
        String str2 = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        c((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 15, new char[]{'/', 26, '/', 18, 20, 31, 17, 5, 17, 18, 23, CoreConstants.LEFT_PARENTHESIS_CHAR, '\"', ' ', 3, 22}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 19), objArr10);
        String str3 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 33, new char[]{'!', '+', 2, 4, ' ', 30, 30, Typography.amp, '/', 14, 29, 19, 11, CoreConstants.PERCENT_CHAR, '+', 5}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 25), objArr11);
        String str4 = (String) objArr11[0];
        Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame16 == null) {
            int scrollBarSize = 30 - (ViewConfiguration.getScrollBarSize() >> 8);
            char mirror = (char) (AndroidCharacter.getMirror('0') + 49314);
            int i20 = 685 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
            byte[] bArr = $$a;
            Object[] objArr12 = new Object[1];
            b((byte) (bArr[1] + 1), (byte) 45, bArr[28], objArr12);
            objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(scrollBarSize, mirror, i20, 508509282, false, (String) objArr12[0], null);
        }
        long j4 = ((Field) objAccessartificialFrame16).getLong(null);
        if (j4 == -1 || j4 + 1902 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr13 = new Object[1];
                c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 22, new char[]{17, 5, '0', CoreConstants.DASH_CHAR, '$', ' ', CoreConstants.DASH_CHAR, 19, 20, 26, 24, 20, 14, '\"', ' ', 30, '+', ' ', 30, Typography.amp, '+', 17, '+', 2, 26, 5}, (byte) (16 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), objArr13);
                Class<?> cls = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                c((ViewConfiguration.getScrollBarSize() >> 8) + 18, new char[]{'\"', '#', 13880, 13880, 2, 4, '\"', 17, 13882, 13882, 28, 30, '!', 14, ' ', 30, Typography.amp, 4}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 35), objArr14);
                baseContext = (Context) cls.getMethod((String) objArr14[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = ((baseContext instanceof ContextWrapper) && ((ContextWrapper) baseContext).getBaseContext() == null) ? null : baseContext.getApplicationContext();
            }
            try {
                Object[] objArr15 = {baseContext, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 185758376};
                short s = (short) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                int i21 = $$e;
                byte[] bArr2 = $$d;
                Object[] objArr16 = new Object[1];
                d(s, (byte) (i21 | 44), bArr2[4], objArr16);
                Class<?> cls2 = Class.forName((String) objArr16[0]);
                short s2 = (short) (i21 | 145);
                byte b = bArr2[116];
                byte b2 = bArr2[128];
                Object[] objArr17 = new Object[1];
                d(s2, b, b2, objArr17);
                objArr = (Object[]) cls2.getMethod((String) objArr17[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr15);
                if (baseContext != null) {
                    int i22 = getARTIFICIAL_FRAME_PACKAGE_NAME + 37;
                    artificialFrame = i22 % 128;
                    try {
                        if (i22 % 2 == 0) {
                            Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(777251007);
                            if (objAccessartificialFrame17 == null) {
                                int iIndexOf = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 31;
                                char cCombineMeasuredStates = (char) (49362 - View.combineMeasuredStates(0, 0));
                                int i23 = 685 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                                byte[] bArr3 = $$a;
                                Object[] objArr18 = new Object[1];
                                b((byte) 57, (byte) (-bArr3[15]), bArr3[98], objArr18);
                                objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(iIndexOf, cCombineMeasuredStates, i23, -1321816393, false, (String) objArr18[0], null);
                            }
                            ((Field) objAccessartificialFrame17).set(null, objArr);
                            lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[1]).invoke(null, new Object[1])).longValue());
                            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-2127922582);
                            if (objAccessartificialFrame == null) {
                                iLastIndexOf = 30 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                                jumpTapTimeout = (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 49361);
                                capsMode = 684 - TextUtils.getCapsMode("", 0, 0);
                                i = 508509282;
                                z = false;
                                byte[] bArr4 = $$a;
                                Object[] objArr19 = new Object[1];
                                b((byte) (bArr4[1] + 1), (byte) 45, bArr4[28], objArr19);
                                obj = objArr19[0];
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iLastIndexOf, jumpTapTimeout, capsMode, i, z, (String) obj, null);
                            }
                        } else {
                            Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(777251007);
                            if (objAccessartificialFrame18 == null) {
                                int i24 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 29;
                                char c2 = (char) (49362 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)));
                                int fadingEdgeLength = 684 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                                byte[] bArr5 = $$a;
                                Object[] objArr20 = new Object[1];
                                b((byte) 57, (byte) (-bArr5[15]), bArr5[98], objArr20);
                                objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(i24, c2, fadingEdgeLength, -1321816393, false, (String) objArr20[0], null);
                            }
                            ((Field) objAccessartificialFrame18).set(null, objArr);
                            lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-2127922582);
                            if (objAccessartificialFrame == null) {
                                iLastIndexOf = TextUtils.lastIndexOf("", '0', 0) + 31;
                                jumpTapTimeout = (char) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 49362);
                                capsMode = 683 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                                i = 508509282;
                                z = false;
                                byte[] bArr6 = $$a;
                                Object[] objArr21 = new Object[1];
                                b((byte) (bArr6[1] + 1), (byte) 45, bArr6[28], objArr21);
                                obj = objArr21[0];
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iLastIndexOf, jumpTapTimeout, capsMode, i, z, (String) obj, null);
                            }
                        }
                        ((Field) objAccessartificialFrame).set(null, lValueOf);
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
            Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(777251007);
            if (objAccessartificialFrame19 == null) {
                int i25 = 31 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                char c3 = (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 49361);
                int scrollBarSize2 = (ViewConfiguration.getScrollBarSize() >> 8) + 684;
                byte[] bArr7 = $$a;
                Object[] objArr22 = new Object[1];
                b((byte) 57, (byte) (-bArr7[15]), bArr7[98], objArr22);
                objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(i25, c3, scrollBarSize2, -1321816393, false, (String) objArr22[0], null);
            }
            Object[] objArr23 = (Object[]) ((Field) objAccessartificialFrame19).get(null);
            objArr = new Object[]{new int[]{((int[]) objArr23[0])[0]}, new int[]{((int[]) objArr23[1])[0]}, new int[1], (String) objArr23[3]};
            int i26 = ~((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().touchscreen;
            int i27 = (-1760936450) + (((~(i26 | 584017510)) | (-936343295)) * (-160)) + (((~(i26 | (-394606265))) | 584017510) * SyslogConstants.LOG_LOCAL4) + 185758376;
            int i28 = (i27 << 13) ^ i27;
            int i29 = i28 ^ (i28 >>> 17);
            ((int[]) objArr[2])[0] = i29 ^ (i29 << 5);
        }
        int i30 = ((int[]) objArr[1])[0];
        int i31 = ((int[]) objArr[0])[0];
        if (i31 == i30) {
            int i32 = ((int[]) objArr[2])[0];
            Object[] objArr24 = {new int[]{((int[]) objArr[0])[0]}, new int[]{((int[]) objArr[1])[0]}, new int[1], (String) objArr[3]};
            int iNextInt = new Random().nextInt(1534511166);
            int i33 = i32 + (((~((-621023873) | iNextInt)) | 273678432) * 449) + 361683422 + (((~((~iNextInt) | (-621023873))) | 273678432) * 449);
            int i34 = (i33 << 13) ^ i33;
            int i35 = i34 ^ (i34 >>> 17);
            i2 = 0;
            ((int[]) objArr24[2])[0] = i35 ^ (i35 << 5);
        } else {
            try {
                Object[] objArr25 = {Long.valueOf(((long) (i30 ^ i31)) ^ (((long) (-919150628)) << 32)), Long.valueOf(-919151140)};
                int i36 = $$e;
                byte[] bArr8 = $$d;
                Object[] objArr26 = new Object[1];
                d((short) (i36 | 165), bArr8[52], bArr8[33], objArr26);
                Class<?> cls3 = Class.forName((String) objArr26[0]);
                Object[] objArr27 = new Object[1];
                d((short) (-bArr8[384]), (byte) (i36 | 80), (byte) (i36 | 73), objArr27);
                cls3.getMethod((String) objArr27[0], Long.TYPE, Long.TYPE).invoke(null, objArr25);
                int i37 = ((int[]) objArr[2])[0];
                Object[] objArr28 = {new int[]{((int[]) objArr[0])[0]}, new int[]{((int[]) objArr[1])[0]}, new int[1], (String) objArr[3]};
                int i38 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenHeightDp;
                int i39 = i37 + (-1564573156) + ((~((-69750815) | i38)) * 623) + (((~i38) | 562037248) * (-623)) + (((~(i38 | 735455104)) | (~((-243168671) | i38)) | 69750814) * 623);
                int i40 = (i39 << 13) ^ i39;
                int i41 = i40 ^ (i40 >>> 17);
                i2 = 0;
                ((int[]) objArr28[2])[0] = i41 ^ (i41 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame20 == null) {
            int iResolveSizeAndState = 21 - View.resolveSizeAndState(i2, i2, i2);
            char cLastIndexOf = (char) (TextUtils.lastIndexOf("", '0', i2, i2) + 1);
            int iMyPid = (Process.myPid() >> 22) + 465;
            Object[] objArr29 = new Object[1];
            b((byte) 96, (byte) 47, $$a[18], objArr29);
            objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState, cLastIndexOf, iMyPid, -785931255, false, (String) objArr29[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame20).getLong(null);
        if (j5 == -1 || j5 + 1954 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext2 = getBaseContext();
            if (baseContext2 == null) {
                Object[] objArr30 = new Object[1];
                c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 9, new char[]{17, 5, '0', CoreConstants.DASH_CHAR, '$', ' ', CoreConstants.DASH_CHAR, 19, 20, 26, 24, 20, 14, '\"', ' ', 30, '+', ' ', 30, Typography.amp, '+', 17, '+', 2, 26, 5}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 20), objArr30);
                Class<?> cls4 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                c(((Process.getThreadPriority(0) + 20) >> 6) + 18, new char[]{'\"', '#', 13880, 13880, 2, 4, '\"', 17, 13882, 13882, 28, 30, '!', 14, ' ', 30, Typography.amp, 4}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) + 31), objArr31);
                baseContext2 = (Context) cls4.getMethod((String) objArr31[0], new Class[0]).invoke(null, null);
            }
            if (baseContext2 != null) {
                int i42 = artificialFrame + 93;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i42 % 128;
                if (i42 % 2 != 0) {
                    int i43 = 79 / 0;
                    if (baseContext2 instanceof ContextWrapper) {
                        if (((ContextWrapper) baseContext2).getBaseContext() != null) {
                            baseContext2 = null;
                        }
                    }
                } else if (baseContext2 instanceof ContextWrapper) {
                    if (((ContextWrapper) baseContext2).getBaseContext() != null) {
                        baseContext2 = null;
                    }
                }
                baseContext2 = baseContext2.getApplicationContext();
            }
            int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr32 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 29, new char[]{3, 11, 7, 15, 29, '\b', 1, 11, '\"', 7, '\f', 26, 7, CoreConstants.LEFT_PARENTHESIS_CHAR, '.', 1, 5, '+', CoreConstants.LEFT_PARENTHESIS_CHAR, 0, 6, '\f', '.', 1, '\f', 15, 26, '\b', '0', CoreConstants.COMMA_CHAR, 2, 5, 5, 6, '\f', 5, '.', 1, 11, 6, 7, '!', 5, 6, '*', '\b', '!', 7, 5, 18, 15, '\f', 7, '\b', CoreConstants.LEFT_PARENTHESIS_CHAR, 14, 7, '!', 15, 5, 7, 29, '+', 26}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 7), objArr32);
            String str5 = (String) objArr32[0];
            Object[] objArr33 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 51, new char[]{1, '\f', 13874, 13874, 2, 5, CharUtils.CR, '\b', 11, 7, 0, 26, '$', 21, '0', '\f', 21, '$', '\b', 3, 18, 5, '\f', 26, 7, '\b', '*', 21, 5, '\f', 28, 21, 1, 26, 13787, 13787, '\f', 26, 2, 6, 7, 20, 0, 19, 26, '\b', 7, 15, 15, 29, 18, 5, 22, 0, 13791, 13791, 26, 14, 1, 29, 19, 26, 5, 2}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 64), objArr33);
            Object[] objArr34 = {baseContext2, new String[]{str5, (String) objArr33[0]}, Integer.valueOf(iIntValue), 1, 64090586};
            int i44 = $$e;
            byte[] bArr9 = $$d;
            Object[] objArr35 = new Object[1];
            d((short) (i44 | 189), bArr9[4], bArr9[33], objArr35);
            Class<?> cls5 = Class.forName((String) objArr35[0]);
            Object[] objArr36 = new Object[1];
            d((short) (i44 | 145), bArr9[116], bArr9[128], objArr36);
            objArr2 = (Object[]) cls5.getMethod((String) objArr36[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr34);
            int i45 = ((int[]) objArr2[0])[0];
            int i46 = ((int[]) objArr2[3])[0];
            if (baseContext2 != null) {
                Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame21 == null) {
                    int i47 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 20;
                    char modifierMetaStateMask = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1);
                    int fadingEdgeLength2 = 465 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                    Object[] objArr37 = new Object[1];
                    b((byte) 88, (byte) 47, $$a[18], objArr37);
                    objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(i47, modifierMetaStateMask, fadingEdgeLength2, -612765161, false, (String) objArr37[0], null);
                }
                ((Field) objAccessartificialFrame21).set(null, objArr2);
                try {
                    Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(1313006081);
                    if (objAccessartificialFrame22 == null) {
                        int iRed = 21 - Color.red(0);
                        char cMyTid = (char) (Process.myTid() >> 22);
                        int scrollBarSize3 = (ViewConfiguration.getScrollBarSize() >> 8) + 465;
                        Object[] objArr38 = new Object[1];
                        b((byte) 96, (byte) 47, $$a[18], objArr38);
                        objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(iRed, cMyTid, scrollBarSize3, -785931255, false, (String) objArr38[0], null);
                    }
                    ((Field) objAccessartificialFrame22).set(null, lValueOf2);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
            c = 0;
        } else {
            Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1142731807);
            if (objAccessartificialFrame23 == null) {
                int keyRepeatTimeout = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 21;
                char longPressTimeout = (char) (ViewConfiguration.getLongPressTimeout() >> 16);
                int iKeyCodeFromString = 465 - KeyEvent.keyCodeFromString("");
                Object[] objArr39 = new Object[1];
                b((byte) 88, (byte) 47, $$a[18], objArr39);
                objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout, longPressTimeout, iKeyCodeFromString, -612765161, false, (String) objArr39[0], null);
            }
            Object[] objArr40 = (Object[]) ((Field) objAccessartificialFrame23).get(null);
            objArr2 = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
            int i48 = ((int[]) objArr40[3])[0];
            int i49 = ((int[]) objArr40[0])[0];
            String[] strArr2 = (String[]) objArr40[1];
            int i50 = ~((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().uiMode;
            int i51 = (-1408035227) + ((1073348390 | i50) * SyslogConstants.LOG_LOCAL7) + (((~(i50 | 927510308)) | 452025890) * SyslogConstants.LOG_LOCAL7) + 64090586;
            int i52 = (i51 << 13) ^ i51;
            int i53 = i52 ^ (i52 >>> 17);
            ((int[]) objArr2[2])[0] = i53 ^ (i53 << 5);
            c = 0;
        }
        int i54 = ((int[]) objArr2[c])[c];
        int i55 = ((int[]) objArr2[3])[c];
        if (i55 == i54) {
            Object[] objArr41 = new Object[4];
            int[] iArr = new int[1];
            objArr41[c] = iArr;
            objArr41[2] = new int[1];
            int[] iArr2 = new int[1];
            objArr41[3] = iArr2;
            int i56 = ((int[]) objArr2[2])[c];
            int i57 = ((int[]) objArr2[3])[c];
            int i58 = ((int[]) objArr2[c])[c];
            String[] strArr3 = (String[]) objArr2[1];
            iArr2[c] = i57;
            iArr[c] = i58;
            int iIdentityHashCode = System.identityHashCode(this);
            int i59 = i56 + (((~((-4200906) | iIdentityHashCode)) | (-1070586864)) * TypedValues.PositionType.TYPE_TRANSITION_EASING) + 1843770480 + ((~((~iIdentityHashCode) | (-4200906))) * TypedValues.PositionType.TYPE_TRANSITION_EASING);
            int i60 = (i59 << 13) ^ i59;
            int i61 = i60 ^ (i60 >>> 17);
            ((int[]) objArr41[2])[0] = i61 ^ (i61 << 5);
            objArr41[1] = strArr3;
        } else {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr4 = (String[]) objArr2[1];
            if (strArr4 != null) {
                for (String str6 : strArr4) {
                    arrayList2.add(str6);
                }
            }
            Object[] objArr42 = {Long.valueOf(((long) (i54 ^ i55)) ^ (((long) 1824332709) << 32)), Long.valueOf(1824332773)};
            int i62 = $$e;
            byte[] bArr10 = $$d;
            Object[] objArr43 = new Object[1];
            d((short) (i62 | 273), bArr10[307], bArr10[33], objArr43);
            Class<?> cls6 = Class.forName((String) objArr43[0]);
            Object[] objArr44 = new Object[1];
            d((short) (-bArr10[384]), (byte) (i62 | 80), (byte) (i62 | 73), objArr44);
            cls6.getMethod((String) objArr44[0], Long.TYPE, Long.TYPE).invoke(null, objArr42);
            Object[] objArr45 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i63 = ((int[]) objArr2[2])[0];
            int i64 = ((int[]) objArr2[3])[0];
            int i65 = ((int[]) objArr2[0])[0];
            String[] strArr5 = (String[]) objArr2[1];
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i66 = ~iIdentityHashCode2;
            int i67 = i63 + 59590892 + (((~((-509613351) | i66)) | 349263624) * (-865)) + ((~(iIdentityHashCode2 | 509613350)) * 865) + (((~(349263624 | i66)) | (~(i66 | 509613350))) * 865);
            int i68 = (i67 << 13) ^ i67;
            int i69 = i68 ^ (i68 >>> 17);
            ((int[]) objArr45[2])[0] = i69 ^ (i69 << 5);
        }
        Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame24 == null) {
            int modifierMetaStateMask2 = 25 - ((byte) KeyEvent.getModifierMetaStateMask());
            char scrollBarSize4 = (char) (ViewConfiguration.getScrollBarSize() >> 8);
            int i70 = 1042 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
            Object[] objArr46 = new Object[1];
            b((byte) 96, (byte) 47, $$a[18], objArr46);
            objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask2, scrollBarSize4, i70, 2061780482, false, (String) objArr46[0], null);
        }
        long j6 = ((Field) objAccessartificialFrame24).getLong(null);
        if (j6 == -1 || j6 + 4611686018427387827L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            try {
                Object[] objArr47 = {770731742};
                Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame25 == null) {
                    objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(TextUtils.getOffsetAfter("", 0) + 8, (char) (22251 - View.getDefaultSize(0, 0)), 1032 - ExpandableListView.getPackedPositionChild(0L), 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = SchemaManager$$ExternalSyntheticLambda5.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame25).newInstance(objArr47), 778844076, false);
                Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame26 == null) {
                    int bitsPerPixel = 25 - ImageFormat.getBitsPerPixel(0);
                    char c4 = (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                    int i71 = 1042 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                    Object[] objArr48 = new Object[1];
                    b((byte) 88, (byte) 47, $$a[18], objArr48);
                    objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(bitsPerPixel, c4, i71, 1145017376, false, (String) objArr48[0], null);
                }
                ((Field) objAccessartificialFrame26).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame27 == null) {
                        int keyRepeatTimeout2 = 26 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                        char cRgb = (char) (Color.rgb(0, 0, 0) + 16777216);
                        int offsetBefore = TextUtils.getOffsetBefore("", 0) + 1041;
                        Object[] objArr49 = new Object[1];
                        b((byte) 96, (byte) 47, $$a[18], objArr49);
                        objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout2, cRgb, offsetBefore, 2061780482, false, (String) objArr49[0], null);
                    }
                    ((Field) objAccessartificialFrame27).set(null, lValueOf3);
                } catch (Exception unused3) {
                    throw new RuntimeException();
                }
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        } else {
            Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame28 == null) {
                int absoluteGravity = Gravity.getAbsoluteGravity(0, 0) + 26;
                char gidForName = (char) ((-1) - Process.getGidForName(""));
                int packedPositionType = ExpandableListView.getPackedPositionType(0L) + 1041;
                Object[] objArr50 = new Object[1];
                b((byte) 88, (byte) 47, $$a[18], objArr50);
                objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(absoluteGravity, gidForName, packedPositionType, 1145017376, false, (String) objArr50[0], null);
            }
            Object[] objArr51 = (Object[]) ((Field) objAccessartificialFrame28).get(null);
            objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
            int i72 = ((int[]) objArr51[3])[0];
            int i73 = ((int[]) objArr51[2])[0];
            String[] strArr6 = (String[]) objArr51[0];
            int iIdentityHashCode3 = System.identityHashCode(this);
            int i74 = 2098414286 + (((~(495080371 | iIdentityHashCode3)) | 5803012 | (~((-416976565) | iIdentityHashCode3))) * (-744)) + (((~iIdentityHashCode3) | 83906819) * 744) + ((iIdentityHashCode3 | (-5803013)) * 744) + 778844076;
            int i75 = (i74 << 13) ^ i74;
            int i76 = i75 ^ (i75 >>> 17);
            ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i76 ^ (i76 << 5);
        }
        int i77 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i78 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i78 == i77) {
            Object[] objArr52 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i79 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i80 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i81 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr7 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int i82 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().mnc;
            int i83 = i79 + 158051226 + (((~(212634484 | i82)) | (-290738292)) * (-964)) + (((~((~i82) | 212634484)) | (-503110520)) * (-964));
            int i84 = (i83 << 13) ^ i83;
            int i85 = i84 ^ (i84 >>> 17);
            ((int[]) objArr52[1])[0] = i85 ^ (i85 << 5);
            i3 = 0;
        } else {
            ArrayList arrayList3 = new ArrayList();
            String[] strArr8 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr8 != null) {
                for (String str7 : strArr8) {
                    arrayList3.add(str7);
                }
            }
            Object[] objArr53 = {Long.valueOf((((long) (-2127846103)) << 32) ^ ((long) (i77 ^ i78))), Long.valueOf(-2127846101)};
            byte[] bArr11 = $$d;
            byte b3 = bArr11[4];
            Object[] objArr54 = new Object[1];
            d(b3, bArr11[137], b3, objArr54);
            Class<?> cls7 = Class.forName((String) objArr54[0]);
            short s3 = (short) (-bArr11[384]);
            int i86 = $$e;
            Object[] objArr55 = new Object[1];
            d(s3, (byte) (i86 | 80), (byte) (i86 | 73), objArr55);
            cls7.getMethod((String) objArr55[0], Long.TYPE, Long.TYPE).invoke(null, objArr53);
            Object[] objArr56 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i87 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i88 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i89 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr9 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int i90 = ~Process.myPid();
            int i91 = i87 + (-1662602546) + ((~((-58736899) | i90)) * 52) + (((~(675255901 | i90)) | (~(597152094 | i90)) | (-733992800)) * (-52)) + (((~(i90 | (-675255902))) | 538415196) * 52);
            int i92 = (i91 << 13) ^ i91;
            int i93 = i92 ^ (i92 >>> 17);
            i3 = 0;
            ((int[]) objArr56[1])[0] = i93 ^ (i93 << 5);
        }
        Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame29 == null) {
            int i94 = (TypedValue.complexToFraction(i3, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(i3, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 17;
            char cMyPid = (char) (Process.myPid() >> 22);
            int mirror2 = 795 - AndroidCharacter.getMirror('0');
            Object[] objArr57 = new Object[1];
            b((byte) 96, (byte) 47, $$a[18], objArr57);
            objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(i94, cMyPid, mirror2, -144068856, false, (String) objArr57[0], null);
        }
        long j7 = ((Field) objAccessartificialFrame29).getLong(null);
        if (j7 == -1 || j7 + 4611686018427387843L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext3 = getBaseContext();
            if (baseContext3 == null) {
                Object[] objArr58 = new Object[1];
                c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 9, new char[]{17, 5, '0', CoreConstants.DASH_CHAR, '$', ' ', CoreConstants.DASH_CHAR, 19, 20, 26, 24, 20, 14, '\"', ' ', 30, '+', ' ', 30, Typography.amp, '+', 17, '+', 2, 26, 5}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 11), objArr58);
                Class<?> cls8 = Class.forName((String) objArr58[0]);
                Object[] objArr59 = new Object[1];
                c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(9) - 96, new char[]{'\"', '#', 13880, 13880, 2, 4, '\"', 17, 13882, 13882, 28, 30, '!', 14, ' ', 30, Typography.amp, 4}, (byte) (81 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), objArr59);
                baseContext3 = (Context) cls8.getMethod((String) objArr59[0], new Class[0]).invoke(null, null);
            }
            if (baseContext3 != null) {
                baseContext3 = ((baseContext3 instanceof ContextWrapper) && ((ContextWrapper) baseContext3).getBaseContext() == null) ? null : baseContext3.getApplicationContext();
            }
            int iIntValue3 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            int i95 = getARTIFICIAL_FRAME_PACKAGE_NAME + 123;
            artificialFrame = i95 % 128;
            int i96 = i95 % 2;
            Object[] objArr60 = {baseContext3, Integer.valueOf(iIntValue3), 0, 1102319771};
            short s4 = (short) TypedValues.AttributesType.TYPE_EASING;
            byte[] bArr12 = $$d;
            Object[] objArr61 = new Object[1];
            d(s4, bArr12[33], bArr12[5], objArr61);
            Class<?> cls9 = Class.forName((String) objArr61[0]);
            Object[] objArr62 = new Object[1];
            d((short) 389, bArr12[48], (byte) (-bArr12[597]), objArr62);
            objArr3 = (Object[]) cls9.getMethod((String) objArr62[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr60);
            Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame30 == null) {
                int i97 = 17 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                char cAxisFromString = (char) ((-1) - MotionEvent.axisFromString(""));
                int packedPositionGroup = ExpandableListView.getPackedPositionGroup(0L) + 747;
                Object[] objArr63 = new Object[1];
                b((byte) 88, (byte) 47, $$a[18], objArr63);
                objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(i97, cAxisFromString, packedPositionGroup, -1031537386, false, (String) objArr63[0], null);
            }
            ((Field) objAccessartificialFrame30).set(null, objArr3);
            try {
                Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame31 == null) {
                    int iMakeMeasureSpec = 17 - View.MeasureSpec.makeMeasureSpec(0, 0);
                    char cAxisFromString2 = (char) (MotionEvent.axisFromString("") + 1);
                    int iNormalizeMetaState = 747 - KeyEvent.normalizeMetaState(0);
                    Object[] objArr64 = new Object[1];
                    b((byte) 96, (byte) 47, $$a[18], objArr64);
                    objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec, cAxisFromString2, iNormalizeMetaState, -144068856, false, (String) objArr64[0], null);
                }
                ((Field) objAccessartificialFrame31).set(null, lValueOf4);
            } catch (Exception unused4) {
                throw new RuntimeException();
            }
        } else {
            int i98 = getARTIFICIAL_FRAME_PACKAGE_NAME + 51;
            artificialFrame = i98 % 128;
            int i99 = i98 % 2;
            Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame32 == null) {
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0) + 17;
                char tapTimeout = (char) (ViewConfiguration.getTapTimeout() >> 16);
                int tapTimeout2 = 747 - (ViewConfiguration.getTapTimeout() >> 16);
                Object[] objArr65 = new Object[1];
                b((byte) 88, (byte) 47, $$a[18], objArr65);
                objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec2, tapTimeout, tapTimeout2, -1031537386, false, (String) objArr65[0], null);
            }
            Object[] objArr66 = (Object[]) ((Field) objAccessartificialFrame32).get(null);
            objArr3 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
            int i100 = ((int[]) objArr66[3])[0];
            int i101 = ((int[]) objArr66[4])[0];
            List list = (List) objArr66[0];
            List list2 = (List) objArr66[2];
            int iIdentityHashCode4 = System.identityHashCode(this);
            int i102 = ~iIdentityHashCode4;
            int i103 = (-89688118) + (((~((-396033070) | i102)) | 209415388) * 519) + (((~(i102 | (-327192610))) | (~(536607997 | iIdentityHashCode4))) * (-519)) + (((~(iIdentityHashCode4 | 209415388)) | 396033069) * 519) + 1102319771;
            int i104 = (i103 << 13) ^ i103;
            int i105 = i104 ^ (i104 >>> 17);
            ((int[]) objArr3[1])[0] = i105 ^ (i105 << 5);
        }
        int i106 = ((int[]) objArr3[4])[0];
        int i107 = ((int[]) objArr3[3])[0];
        if (i107 == i106) {
            Object[] objArr67 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i108 = ((int[]) objArr3[1])[0];
            int i109 = ((int[]) objArr3[3])[0];
            int i110 = ((int[]) objArr3[4])[0];
            List list3 = (List) objArr3[0];
            List list4 = (List) objArr3[2];
            int iIdentityHashCode5 = System.identityHashCode(this);
            int i111 = i108 + (-884399847) + (((~((-605585933) | (~iIdentityHashCode5))) | (~((-137475) | iIdentityHashCode5))) * (-272)) + (((~((-773695166) | iIdentityHashCode5)) | 168109233) * (-272)) + (((~(iIdentityHashCode5 | 773695165)) | (-168246708)) * 272);
            int i112 = (i111 << 13) ^ i111;
            int i113 = i112 ^ (i112 >>> 17);
            ((int[]) objArr67[1])[0] = i113 ^ (i113 << 5);
            i4 = 0;
        } else {
            ArrayList arrayList4 = new ArrayList();
            Object[] objArr68 = {objArr3};
            Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(1804664566);
            if (objAccessartificialFrame33 == null) {
                objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(41 - Color.argb(0, 0, 0, 0), (char) (12468 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 3642, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
            }
            arrayList4.add(((Method) objAccessartificialFrame33).invoke(null, objArr68));
            Object[] objArr69 = {objArr3};
            Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(-1243809191);
            if (objAccessartificialFrame34 == null) {
                objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(41 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (12468 - KeyEvent.keyCodeFromString("")), 3642 - (Process.myPid() >> 22), 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
            }
            arrayList4.add(((Method) objAccessartificialFrame34).invoke(null, objArr69));
            Object[] objArr70 = {Long.valueOf(((long) (i106 ^ i107)) ^ (((long) (-284371955)) << 32)), Long.valueOf(-284371963)};
            short s5 = (short) TSLocationManager.LOCATION_ERROR_TIMEOUT;
            byte[] bArr13 = $$d;
            byte b4 = bArr13[33];
            Object[] objArr71 = new Object[1];
            d(s5, b4, b4, objArr71);
            Class<?> cls10 = Class.forName((String) objArr71[0]);
            short s6 = (short) (-bArr13[384]);
            int i114 = $$e;
            Object[] objArr72 = new Object[1];
            d(s6, (byte) (i114 | 80), (byte) (i114 | 73), objArr72);
            cls10.getMethod((String) objArr72[0], Long.TYPE, Long.TYPE).invoke(null, objArr70);
            Object[] objArr73 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i115 = ((int[]) objArr3[1])[0];
            int i116 = ((int[]) objArr3[3])[0];
            int i117 = ((int[]) objArr3[4])[0];
            List list5 = (List) objArr3[0];
            List list6 = (List) objArr3[2];
            int i118 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenWidthDp;
            int i119 = i115 + (((~((-308121767) | i118)) | 65358021) * 398) + 16256929 + (((~((~i118) | (-308121767))) | 65358021) * 398);
            int i120 = (i119 << 13) ^ i119;
            int i121 = i120 ^ (i120 >>> 17);
            i4 = 0;
            ((int[]) objArr73[1])[0] = i121 ^ (i121 << 5);
        }
        Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame35 == null) {
            int iIndexOf2 = 29 - TextUtils.indexOf((CharSequence) "", '0', i4);
            char absoluteGravity2 = (char) (Gravity.getAbsoluteGravity(i4, i4) + 49362);
            int mirror3 = 732 - AndroidCharacter.getMirror('0');
            byte[] bArr14 = $$a;
            byte b5 = bArr14[14];
            Object[] objArr74 = new Object[1];
            b(b5, (byte) (b5 - 5), (byte) (-bArr14[4]), objArr74);
            objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(iIndexOf2, absoluteGravity2, mirror3, 752929587, false, (String) objArr74[0], null);
        }
        long j8 = ((Field) objAccessartificialFrame35).getLong(null);
        try {
            if (j8 != -1) {
                int i122 = artificialFrame + 99;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i122 % 128;
                int i123 = i122 % 2;
                i5 = 0;
                if (j8 + 1892 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(-326560385);
                    if (objAccessartificialFrame36 == null) {
                        int offsetAfter = TextUtils.getOffsetAfter("", 0) + 30;
                        char minimumFlingVelocity = (char) ((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 49362);
                        int iIndexOf3 = TextUtils.indexOf("", "") + 684;
                        byte[] bArr15 = $$a;
                        byte b6 = (byte) (bArr15[33] - 1);
                        Object[] objArr75 = new Object[1];
                        b(b6, (byte) (b6 + 3), (byte) (-bArr15[4]), objArr75);
                        objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(offsetAfter, minimumFlingVelocity, iIndexOf3, 1944867703, false, (String) objArr75[0], null);
                    }
                    Object[] objArr76 = (Object[]) ((Field) objAccessartificialFrame36).get(null);
                    objArr4 = new Object[]{new int[]{((int[]) objArr76[0])[0]}, new int[]{((int[]) objArr76[1])[0]}, new int[1], (String) objArr76[3]};
                    int i124 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().navigationHidden;
                    int i125 = ~i124;
                    int i126 = (-662582322) + (((~(i124 | 469798937)) | (~((-469762050) | i125)) | (-508861726)) * (-68)) + ((~((-39062789) | i125)) * (-68)) + (((~((-469798938) | i125)) | (-508824838)) * 68) + 857588439;
                    int i127 = (i126 << 13) ^ i126;
                    int i128 = i127 ^ (i127 >>> 17);
                    ((int[]) objArr4[2])[0] = i128 ^ (i128 << 5);
                }
                i6 = ((int[]) objArr4[1])[0];
                i7 = ((int[]) objArr4[0])[0];
                if (i7 == i6) {
                    int i129 = ((int[]) objArr4[2])[0];
                    Object[] objArr77 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
                    int ringerMode = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getRingerMode();
                    int i130 = ~ringerMode;
                    int i131 = i129 + (-1508821074) + (((~((-12598341) | i130)) | 8396864 | (~((-966025435) | i130))) * (-1136)) + (((~((-12598341) | ringerMode)) | (~((-966025435) | ringerMode)) | (~(970226910 | i130))) * (-568)) + (((~(ringerMode | (-8396865))) | (~(i130 | 966025434)) | (~(12598340 | i130))) * 568);
                    int i132 = (i131 << 13) ^ i131;
                    int i133 = i132 ^ (i132 >>> 17);
                    ((int[]) objArr77[2])[0] = i133 ^ (i133 << 5);
                } else {
                    Object[] objArr78 = {Long.valueOf(((long) (i6 ^ i7)) ^ (((long) (-1993740083)) << 32)), Long.valueOf(-1993740087)};
                    int i134 = $$e;
                    byte[] bArr16 = $$d;
                    Object[] objArr79 = new Object[1];
                    d((short) (i134 | 525), (byte) (-bArr16[212]), bArr16[33], objArr79);
                    Class<?> cls11 = Class.forName((String) objArr79[0]);
                    Object[] objArr80 = new Object[1];
                    d((short) (-bArr16[384]), (byte) (i134 | 80), (byte) (i134 | 73), objArr80);
                    cls11.getMethod((String) objArr80[0], Long.TYPE, Long.TYPE).invoke(null, objArr78);
                    int i135 = ((int[]) objArr4[2])[0];
                    Object[] objArr81 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
                    int streamVolume = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getStreamVolume(3);
                    int i136 = i135 + (-609636322) + (((~((-8455464) | (~streamVolume))) | (~(970168311 | streamVolume))) * (-272)) + (((~((-281118120) | streamVolume)) | 272662656) * (-272)) + (((~(streamVolume | 281118119)) | 697505655) * 272);
                    int i137 = (i136 << 13) ^ i136;
                    int i138 = i137 ^ (i137 >>> 17);
                    ((int[]) objArr81[2])[0] = i138 ^ (i138 << 5);
                }
                super.onCreate();
                objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame2 == null) {
                    int iMyTid = (Process.myTid() >> 22) + 30;
                    char touchSlop = (char) ((ViewConfiguration.getTouchSlop() >> 8) + 49362);
                    int absoluteGravity3 = Gravity.getAbsoluteGravity(0, 0) + 684;
                    byte[] bArr17 = $$a;
                    Object[] objArr82 = new Object[1];
                    b((byte) (-bArr17[94]), (byte) ($$b >>> 2), bArr17[28], objArr82);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iMyTid, touchSlop, absoluteGravity3, -1583976536, false, (String) objArr82[0], null);
                }
                j = ((Field) objAccessartificialFrame2).getLong(null);
                if (j != -1) {
                    i18 = getARTIFICIAL_FRAME_PACKAGE_NAME + 81;
                    artificialFrame = i18 % 128;
                    if (i18 % 2 == 0 ? j + 1866 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue() : j / 1866 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                        Object[] objArr83 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 2066552710};
                        byte[] bArr18 = $$d;
                        Object[] objArr84 = new Object[1];
                        d((short) 561, bArr18[13], bArr18[33], objArr84);
                        Class<?> cls12 = Class.forName((String) objArr84[0]);
                        Object[] objArr85 = new Object[1];
                        d((short) ($$e | 633), (byte) (bArr18[324] - 1), bArr18[33], objArr85);
                        objArr5 = (Object[]) cls12.getMethod((String) objArr85[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr83);
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(910856866);
                        if (objAccessartificialFrame3 == null) {
                            int scrollBarFadeDuration = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 30;
                            char c5 = (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 49361);
                            int iResolveSizeAndState2 = 684 - View.resolveSizeAndState(0, 0, 0);
                            byte[] bArr19 = $$a;
                            byte b7 = bArr19[28];
                            Object[] objArr86 = new Object[1];
                            b(b7, (byte) (b7 | 32), bArr19[18], objArr86);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration, c5, iResolveSizeAndState2, -1456483158, false, (String) objArr86[0], null);
                        }
                        ((Field) objAccessartificialFrame3).set(null, objArr5);
                        try {
                            Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1056123296);
                            if (objAccessartificialFrame4 == null) {
                                int scrollBarFadeDuration2 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 30;
                                char c6 = (char) (49363 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                                int i139 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 683;
                                byte[] bArr20 = $$a;
                                Object[] objArr87 = new Object[1];
                                b((byte) (-bArr20[94]), (byte) ($$b >>> 2), bArr20[28], objArr87);
                                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration2, c6, i139, -1583976536, false, (String) objArr87[0], null);
                            }
                            ((Field) objAccessartificialFrame4).set(null, lValueOf5);
                        } catch (Exception unused5) {
                            throw new RuntimeException();
                        }
                    } else {
                        Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(910856866);
                        if (objAccessartificialFrame37 == null) {
                            int packedPositionGroup2 = ExpandableListView.getPackedPositionGroup(0L) + 30;
                            char maxKeyCode = (char) ((KeyEvent.getMaxKeyCode() >> 16) + 49362);
                            int iCombineMeasuredStates = 684 - View.combineMeasuredStates(0, 0);
                            byte[] bArr21 = $$a;
                            byte b8 = bArr21[28];
                            Object[] objArr88 = new Object[1];
                            b(b8, (byte) (b8 | 32), bArr21[18], objArr88);
                            objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(packedPositionGroup2, maxKeyCode, iCombineMeasuredStates, -1456483158, false, (String) objArr88[0], null);
                        }
                        Object[] objArr89 = (Object[]) ((Field) objAccessartificialFrame37).get(null);
                        objArr5 = new Object[]{new int[]{((int[]) objArr89[0])[0]}, new int[]{((int[]) objArr89[1])[0]}, new int[1], (String) objArr89[3]};
                        int i140 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 546653393;
                        int i141 = ~i140;
                        int i142 = (-1478108986) + (((-67639427) | i140) * (-676)) + (((~(868704892 | i141)) | 67639426) * 676) + (((~(i140 | 936344318)) | (~(i141 | (-109918883))) | 42279456) * 676) + 2066552710;
                        int i143 = (i142 << 13) ^ i142;
                        int i144 = i143 ^ (i143 >>> 17);
                        ((int[]) objArr5[2])[0] = i144 ^ (i144 << 5);
                    }
                } else {
                    Object[] objArr810 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 2066552710};
                    byte[] bArr110 = $$d;
                    Object[] objArr811 = new Object[1];
                    d((short) 561, bArr110[13], bArr110[33], objArr811);
                    Class<?> cls13 = Class.forName((String) objArr811[0]);
                    Object[] objArr812 = new Object[1];
                    d((short) ($$e | 633), (byte) (bArr110[324] - 1), bArr110[33], objArr812);
                    objArr5 = (Object[]) cls13.getMethod((String) objArr812[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr810);
                    objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(910856866);
                    if (objAccessartificialFrame3 == null) {
                        int scrollBarFadeDuration3 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 30;
                        char c7 = (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 49361);
                        int iResolveSizeAndState3 = 684 - View.resolveSizeAndState(0, 0, 0);
                        byte[] bArr111 = $$a;
                        byte b9 = bArr111[28];
                        Object[] objArr813 = new Object[1];
                        b(b9, (byte) (b9 | 32), bArr111[18], objArr813);
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration3, c7, iResolveSizeAndState3, -1456483158, false, (String) objArr813[0], null);
                    }
                    ((Field) objAccessartificialFrame3).set(null, objArr5);
                    Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1056123296);
                    if (objAccessartificialFrame4 == null) {
                        int scrollBarFadeDuration4 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 30;
                        char c8 = (char) (49363 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                        int i1310 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 683;
                        byte[] bArr22 = $$a;
                        Object[] objArr814 = new Object[1];
                        b((byte) (-bArr22[94]), (byte) ($$b >>> 2), bArr22[28], objArr814);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration4, c8, i1310, -1583976536, false, (String) objArr814[0], null);
                    }
                    ((Field) objAccessartificialFrame4).set(null, lValueOf6);
                }
                i8 = ((int[]) objArr5[1])[0];
                i9 = ((int[]) objArr5[0])[0];
                if (i9 == i8) {
                    int i145 = ((int[]) objArr5[2])[0];
                    Object[] objArr90 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
                    int i146 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().navigation;
                    int i147 = i145 + (-1862065554) + (((~(903075741 | i146)) | 75548033) * (-756)) + (((~i146) | 903075741) * 756);
                    int i148 = (i147 << 13) ^ i147;
                    int i149 = i148 ^ (i148 >>> 17);
                    i10 = 0;
                    ((int[]) objArr90[2])[0] = i149 ^ (i149 << 5);
                } else {
                    new ArrayList().add((String) objArr5[3]);
                    long j9 = ((long) (i8 ^ i9)) ^ (((long) 857192602) << 32);
                    long j10 = 857192586;
                    int i150 = getARTIFICIAL_FRAME_PACKAGE_NAME + 119;
                    artificialFrame = i150 % 128;
                    int i151 = i150 % 2;
                    Object[] objArr91 = {Long.valueOf(j9), Long.valueOf(j10)};
                    int i152 = $$e;
                    byte[] bArr23 = $$d;
                    Object[] objArr92 = new Object[1];
                    d((short) (i152 | 525), (byte) (-bArr23[212]), bArr23[33], objArr92);
                    Class<?> cls14 = Class.forName((String) objArr92[0]);
                    Object[] objArr93 = new Object[1];
                    d((short) (-bArr23[384]), (byte) (i152 | 80), (byte) (i152 | 73), objArr93);
                    cls14.getMethod((String) objArr93[0], Long.TYPE, Long.TYPE).invoke(null, objArr91);
                    int i153 = ((int[]) objArr5[2])[0];
                    Object[] objArr94 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
                    int iIdentityHashCode6 = System.identityHashCode(this);
                    int i154 = ~((-519338764) | iIdentityHashCode6);
                    int i155 = ~iIdentityHashCode6;
                    int i156 = i153 + (-567359266) + ((i154 | (~(459285011 | i155))) * (-1808)) + (((~((-442507780) | iIdentityHashCode6)) | (~(i155 | 536115995))) * TypedValues.Custom.TYPE_BOOLEAN) + (((~(iIdentityHashCode6 | (-459285012))) | 76830984 | (~(519338763 | i155))) * TypedValues.Custom.TYPE_BOOLEAN);
                    int i157 = (i156 << 13) ^ i156;
                    int i158 = i157 ^ (i157 >>> 17);
                    i10 = 0;
                    ((int[]) objArr94[2])[0] = i158 ^ (i158 << 5);
                }
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                if (objAccessartificialFrame5 == null) {
                    int modifierMetaStateMask3 = 35 - ((byte) KeyEvent.getModifierMetaStateMask());
                    char mode = (char) View.MeasureSpec.getMode(i10);
                    int doubleTapTimeout = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 540;
                    Object[] objArr95 = new Object[1];
                    b((byte) 96, (byte) 47, $$a[18], objArr95);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask3, mode, doubleTapTimeout, 624296913, false, (String) objArr95[0], null);
                }
                j2 = ((Field) objAccessartificialFrame5).getLong(null);
                if (j2 != -1) {
                    int i159 = artificialFrame + 35;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i159 % 128;
                    int i160 = i159 % 2;
                    i11 = 0;
                    if (j2 + 1887 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                        objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                        if (objAccessartificialFrame15 == null) {
                            int deadChar = KeyEvent.getDeadChar(0, 0) + 36;
                            char c9 = (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                            int maximumDrawingCacheSize = 540 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                            Object[] objArr96 = new Object[1];
                            b((byte) 88, (byte) 47, $$a[18], objArr96);
                            objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(deadChar, c9, maximumDrawingCacheSize, 793268735, false, (String) objArr96[0], null);
                        }
                        Object[] objArr97 = (Object[]) ((Field) objAccessartificialFrame15).get(null);
                        objArr6 = new Object[]{new int[1], new int[1], new int[1]};
                        int i161 = ((int[]) objArr97[2])[0];
                        int i162 = ((int[]) objArr97[1])[0];
                        ((int[]) objArr6[2])[0] = i161;
                        ((int[]) objArr6[1])[0] = i162;
                        int i163 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenLayout;
                        int i164 = 1279395388 + (((~(i163 | 687431762)) | (-805305460)) * 305) + (((~((~i163) | 687431762)) | (-664189988)) * 305) + 913739567;
                        int i165 = (i164 << 13) ^ i164;
                        int i166 = i165 ^ (i165 >>> 17);
                        ((int[]) objArr6[0])[0] = i166 ^ (i166 << 5);
                    }
                    obj2 = objArr6[1];
                    i12 = ((int[]) obj2)[0];
                    obj3 = objArr6[2];
                    i13 = ((int[]) obj3)[0];
                    if (i13 == i12) {
                        Object[] objArr98 = {new int[1], new int[1], new int[1]};
                        int i167 = ((int[]) objArr6[0])[0];
                        int i168 = ((int[]) obj3)[0];
                        int i169 = ((int[]) obj2)[0];
                        ((int[]) objArr98[2])[0] = i168;
                        ((int[]) objArr98[1])[0] = i169;
                        int iUptimeMillis = (int) SystemClock.uptimeMillis();
                        int i170 = i167 + 767387757 + (((~(30291077 | iUptimeMillis)) | (-1339029494) | (~(1321330672 | iUptimeMillis))) * (-744)) + (((~iUptimeMillis) | 12592256) * 744) + ((iUptimeMillis | 1339029493) * 744);
                        int i171 = (i170 << 13) ^ i170;
                        int i172 = i171 ^ (i171 >>> 17);
                        i14 = 0;
                        ((int[]) objArr98[0])[0] = i172 ^ (i172 << 5);
                    } else {
                        Object[] objArr99 = {Long.valueOf(((long) (i12 ^ i13)) ^ (((long) (-2102054361)) << 32)), Long.valueOf(-2102058457)};
                        int i173 = $$e;
                        byte[] bArr24 = $$d;
                        Object[] objArr100 = new Object[1];
                        d((short) (i173 | 525), (byte) (-bArr24[212]), bArr24[33], objArr100);
                        Class<?> cls15 = Class.forName((String) objArr100[0]);
                        Object[] objArr101 = new Object[1];
                        d((short) (-bArr24[384]), (byte) (i173 | 80), (byte) (i173 | 73), objArr101);
                        cls15.getMethod((String) objArr101[0], Long.TYPE, Long.TYPE).invoke(null, objArr99);
                        Object[] objArr102 = {new int[1], new int[1], new int[1]};
                        int i174 = ((int[]) objArr6[0])[0];
                        int i175 = ((int[]) objArr6[2])[0];
                        int i176 = ((int[]) objArr6[1])[0];
                        ((int[]) objArr102[2])[0] = i175;
                        ((int[]) objArr102[1])[0] = i176;
                        int streamVolume2 = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getStreamVolume(3);
                        int i177 = ~streamVolume2;
                        int i178 = i174 + (-837753602) + ((~((-1245058018) | i177)) * 979) + ((streamVolume2 | 106563732) * (-979)) + (((~(streamVolume2 | (-1245058018))) | (~(i177 | 106563732))) * 979);
                        int i179 = (i178 << 13) ^ i178;
                        int i180 = i179 ^ (i179 >>> 17);
                        i14 = 0;
                        ((int[]) objArr102[0])[0] = i180 ^ (i180 << 5);
                    }
                    objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame10 == null) {
                        int i181 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 24;
                        char cResolveOpacity = (char) (Drawable.resolveOpacity(i14, i14) + 30068);
                        int maximumDrawingCacheSize2 = 816 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                        Object[] objArr103 = new Object[1];
                        b((byte) 96, (byte) 47, $$a[18], objArr103);
                        objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(i181, cResolveOpacity, maximumDrawingCacheSize2, 721586079, false, (String) objArr103[0], null);
                    }
                    j3 = ((Field) objAccessartificialFrame10).getLong(null);
                    if (j3 != -1) {
                        int i182 = getARTIFICIAL_FRAME_PACKAGE_NAME + 17;
                        artificialFrame = i182 % 128;
                        int i183 = i182 % 2;
                        if (j3 + 1889 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                            objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                            if (objAccessartificialFrame14 == null) {
                                int packedPositionGroup3 = ExpandableListView.getPackedPositionGroup(0L) + 25;
                                char mirror4 = (char) (30116 - AndroidCharacter.getMirror('0'));
                                int iResolveOpacity = Drawable.resolveOpacity(0, 0) + 816;
                                Object[] objArr104 = new Object[1];
                                b((byte) 88, (byte) 47, $$a[18], objArr104);
                                objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(packedPositionGroup3, mirror4, iResolveOpacity, 891606461, false, (String) objArr104[0], null);
                            }
                            Object[] objArr105 = (Object[]) ((Field) objAccessartificialFrame14).get(null);
                            objArr7 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                            int i184 = ((int[]) objArr105[0])[0];
                            int i185 = ((int[]) objArr105[1])[0];
                            String[] strArr10 = (String[]) objArr105[2];
                            int iIdentityHashCode7 = System.identityHashCode(this);
                            int i186 = 736166445 + (((~(279340396 | iIdentityHashCode7)) | (-477512763)) * (-964)) + (((~((~iIdentityHashCode7) | 279340396)) | (-485909887)) * (-964)) + 1411491212;
                            int i187 = (i186 << 13) ^ i186;
                            int i188 = i187 ^ (i187 >>> 17);
                            ((int[]) objArr7[3])[0] = i188 ^ (i188 << 5);
                        } else {
                            Object[] objArr106 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1411491212};
                            objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(1327366003);
                            if (objAccessartificialFrame11 == null) {
                                int iAlpha = Color.alpha(0) + 25;
                                char offsetAfter2 = (char) (TextUtils.getOffsetAfter("", 0) + 30068);
                                int bitsPerPixel2 = ImageFormat.getBitsPerPixel(0) + 817;
                                byte[] bArr25 = $$a;
                                Object[] objArr107 = new Object[1];
                                b((byte) 80, bArr25[35], bArr25[9], objArr107);
                                objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(iAlpha, offsetAfter2, bitsPerPixel2, -797394565, false, (String) objArr107[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                            }
                            objArr7 = (Object[]) ((Method) objAccessartificialFrame11).invoke(null, objArr106);
                            objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                            if (objAccessartificialFrame12 == null) {
                                int i189 = 25 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                                char keyRepeatTimeout3 = (char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 30068);
                                int maximumDrawingCacheSize3 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 816;
                                Object[] objArr108 = new Object[1];
                                b((byte) 88, (byte) 47, $$a[18], objArr108);
                                objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(i189, keyRepeatTimeout3, maximumDrawingCacheSize3, 891606461, false, (String) objArr108[0], null);
                            }
                            ((Field) objAccessartificialFrame12).set(null, objArr7);
                            try {
                                Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                                objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                                if (objAccessartificialFrame13 == null) {
                                    int i190 = 25 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                                    char scrollBarSize5 = (char) ((ViewConfiguration.getScrollBarSize() >> 8) + 30068);
                                    int doubleTapTimeout2 = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 816;
                                    Object[] objArr109 = new Object[1];
                                    b((byte) 96, (byte) 47, $$a[18], objArr109);
                                    objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(i190, scrollBarSize5, doubleTapTimeout2, 721586079, false, (String) objArr109[0], null);
                                }
                                ((Field) objAccessartificialFrame13).set(null, lValueOf7);
                            } catch (Exception unused6) {
                                throw new RuntimeException();
                            }
                        }
                    } else {
                        Object[] objArr1010 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1411491212};
                        objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(1327366003);
                        if (objAccessartificialFrame11 == null) {
                            int iAlpha2 = Color.alpha(0) + 25;
                            char offsetAfter3 = (char) (TextUtils.getOffsetAfter("", 0) + 30068);
                            int bitsPerPixel3 = ImageFormat.getBitsPerPixel(0) + 817;
                            byte[] bArr26 = $$a;
                            Object[] objArr1011 = new Object[1];
                            b((byte) 80, bArr26[35], bArr26[9], objArr1011);
                            objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(iAlpha2, offsetAfter3, bitsPerPixel3, -797394565, false, (String) objArr1011[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                        }
                        objArr7 = (Object[]) ((Method) objAccessartificialFrame11).invoke(null, objArr1010);
                        objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                        if (objAccessartificialFrame12 == null) {
                            int i1810 = 25 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                            char keyRepeatTimeout4 = (char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 30068);
                            int maximumDrawingCacheSize4 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 816;
                            Object[] objArr1012 = new Object[1];
                            b((byte) 88, (byte) 47, $$a[18], objArr1012);
                            objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(i1810, keyRepeatTimeout4, maximumDrawingCacheSize4, 891606461, false, (String) objArr1012[0], null);
                        }
                        ((Field) objAccessartificialFrame12).set(null, objArr7);
                        Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame13 == null) {
                            int i191 = 25 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                            char scrollBarSize6 = (char) ((ViewConfiguration.getScrollBarSize() >> 8) + 30068);
                            int doubleTapTimeout3 = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 816;
                            Object[] objArr1013 = new Object[1];
                            b((byte) 96, (byte) 47, $$a[18], objArr1013);
                            objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(i191, scrollBarSize6, doubleTapTimeout3, 721586079, false, (String) objArr1013[0], null);
                        }
                        ((Field) objAccessartificialFrame13).set(null, lValueOf8);
                    }
                    i15 = ((int[]) objArr7[1])[0];
                    i16 = ((int[]) objArr7[0])[0];
                    if (i16 == i15) {
                        Object[] objArr110 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                        int i192 = ((int[]) objArr7[3])[0];
                        int i193 = ((int[]) objArr7[0])[0];
                        int i194 = ((int[]) objArr7[1])[0];
                        String[] strArr11 = (String[]) objArr7[2];
                        int iIdentityHashCode8 = System.identityHashCode(this);
                        int i195 = (~((-317348151) | iIdentityHashCode8)) | 283115798;
                        int i196 = i192 + 688927133 + (i195 * 992) + ((i195 | (~((~iIdentityHashCode8) | (-84943433)))) * (-496)) + ((iIdentityHashCode8 | (-119175785)) * 496);
                        int i197 = (i196 << 13) ^ i196;
                        int i198 = i197 ^ (i197 >>> 17);
                        ((int[]) objArr110[3])[0] = i198 ^ (i198 << 5);
                        return;
                    }
                    arrayList = new ArrayList();
                    strArr = (String[]) objArr7[2];
                    if (strArr != null) {
                        for (String str8 : strArr) {
                            arrayList.add(str8);
                        }
                    }
                    long j11 = (((long) (-1925467315)) << 32) ^ ((long) (i15 ^ i16));
                    long j12 = -1925467316;
                    int i199 = artificialFrame + 115;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i199 % 128;
                    int i200 = i199 % 2;
                    Object[] objArr111 = {Long.valueOf(j11), Long.valueOf(j12)};
                    byte[] bArr27 = $$d;
                    Object[] objArr112 = new Object[1];
                    d(bArr27[369], bArr27[530], bArr27[33], objArr112);
                    Class<?> cls16 = Class.forName((String) objArr112[0]);
                    short s7 = (short) (-bArr27[384]);
                    int i201 = $$e;
                    Object[] objArr113 = new Object[1];
                    d(s7, (byte) (i201 | 80), (byte) (i201 | 73), objArr113);
                    cls16.getMethod((String) objArr113[0], Long.TYPE, Long.TYPE).invoke(null, objArr111);
                    Object[] objArr114 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                    int i202 = ((int[]) objArr7[3])[0];
                    int i203 = ((int[]) objArr7[0])[0];
                    int i204 = ((int[]) objArr7[1])[0];
                    String[] strArr12 = (String[]) objArr7[2];
                    int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 430336816;
                    int i205 = ~length;
                    int i206 = i202 + (((((~(529670845 | i205)) | (~((-727843212) | length))) | (~(i205 | 727843211))) * 959) - 1003742194) + (((~(length | 727843211)) | (~(i205 | (-727843212))) | (~(529670845 | length))) * 959);
                    int i207 = (i206 << 13) ^ i206;
                    int i208 = i207 ^ (i207 >>> 17);
                    ((int[]) objArr114[3])[0] = i208 ^ (i208 << 5);
                    return;
                }
                i11 = 0;
                objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1717965552);
                if (objAccessartificialFrame6 == null) {
                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(20 - TextUtils.getOffsetBefore("", i11), (char) (MotionEvent.axisFromString("") + 39517), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 981, 117222168, false, null, new Class[0]);
                }
                Object[] objArr115 = {null, ((Constructor) objAccessartificialFrame6).newInstance(null), 913739567, 0};
                objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-501205803);
                if (objAccessartificialFrame7 == null) {
                    int maximumFlingVelocity = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 36;
                    char offsetAfter4 = (char) TextUtils.getOffsetAfter("", 0);
                    int capsMode2 = TextUtils.getCapsMode("", 0, 0) + 540;
                    byte b10 = (byte) ($$a[5] - 1);
                    byte b11 = b10;
                    Object[] objArr116 = new Object[1];
                    b(b10, b11, b11, objArr116);
                    objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity, offsetAfter4, capsMode2, 2101703389, false, (String) objArr116[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(54 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 834), 576 - (ViewConfiguration.getPressedStateDuration() >> 16)), (Class) ArtificialStackFrames.coroutineCreation(View.MeasureSpec.makeMeasureSpec(0, 0) + 54, (char) (TextUtils.lastIndexOf("", '0', 0) + 1), Color.rgb(0, 0, 0) + 16777846), Integer.TYPE, Integer.TYPE});
                }
                objArr6 = (Object[]) ((Method) objAccessartificialFrame7).invoke(null, objArr115);
                objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                if (objAccessartificialFrame8 == null) {
                    int iCombineMeasuredStates2 = 36 - View.combineMeasuredStates(0, 0);
                    char capsMode3 = (char) TextUtils.getCapsMode("", 0, 0);
                    int iIndexOf4 = 540 - TextUtils.indexOf("", "", 0);
                    Object[] objArr117 = new Object[1];
                    b((byte) 88, (byte) 47, $$a[18], objArr117);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates2, capsMode3, iIndexOf4, 793268735, false, (String) objArr117[0], null);
                }
                ((Field) objAccessartificialFrame8).set(null, objArr6);
                Long lValueOf9 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                if (objAccessartificialFrame9 == null) {
                    int jumpTapTimeout2 = 36 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                    char maxKeyCode2 = (char) (KeyEvent.getMaxKeyCode() >> 16);
                    int bitsPerPixel4 = ImageFormat.getBitsPerPixel(0) + 541;
                    Object[] objArr118 = new Object[1];
                    b((byte) 96, (byte) 47, $$a[18], objArr118);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout2, maxKeyCode2, bitsPerPixel4, 624296913, false, (String) objArr118[0], null);
                }
                ((Field) objAccessartificialFrame9).set(null, lValueOf9);
                obj2 = objArr6[1];
                i12 = ((int[]) obj2)[0];
                obj3 = objArr6[2];
                i13 = ((int[]) obj3)[0];
                if (i13 == i12) {
                    Object[] objArr910 = {new int[1], new int[1], new int[1]};
                    int i1610 = ((int[]) objArr6[0])[0];
                    int i1611 = ((int[]) obj3)[0];
                    int i1612 = ((int[]) obj2)[0];
                    ((int[]) objArr910[2])[0] = i1611;
                    ((int[]) objArr910[1])[0] = i1612;
                    int iUptimeMillis2 = (int) SystemClock.uptimeMillis();
                    int i1710 = i1610 + 767387757 + (((~(30291077 | iUptimeMillis2)) | (-1339029494) | (~(1321330672 | iUptimeMillis2))) * (-744)) + (((~iUptimeMillis2) | 12592256) * 744) + ((iUptimeMillis2 | 1339029493) * 744);
                    int i1711 = (i1710 << 13) ^ i1710;
                    int i1712 = i1711 ^ (i1711 >>> 17);
                    i14 = 0;
                    ((int[]) objArr910[0])[0] = i1712 ^ (i1712 << 5);
                } else {
                    Object[] objArr911 = {Long.valueOf(((long) (i12 ^ i13)) ^ (((long) (-2102054361)) << 32)), Long.valueOf(-2102058457)};
                    int i1713 = $$e;
                    byte[] bArr28 = $$d;
                    Object[] objArr1014 = new Object[1];
                    d((short) (i1713 | 525), (byte) (-bArr28[212]), bArr28[33], objArr1014);
                    Class<?> cls17 = Class.forName((String) objArr1014[0]);
                    Object[] objArr1015 = new Object[1];
                    d((short) (-bArr28[384]), (byte) (i1713 | 80), (byte) (i1713 | 73), objArr1015);
                    cls17.getMethod((String) objArr1015[0], Long.TYPE, Long.TYPE).invoke(null, objArr911);
                    Object[] objArr1016 = {new int[1], new int[1], new int[1]};
                    int i1714 = ((int[]) objArr6[0])[0];
                    int i1715 = ((int[]) objArr6[2])[0];
                    int i1716 = ((int[]) objArr6[1])[0];
                    ((int[]) objArr1016[2])[0] = i1715;
                    ((int[]) objArr1016[1])[0] = i1716;
                    int streamVolume3 = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getStreamVolume(3);
                    int i1717 = ~streamVolume3;
                    int i1718 = i1714 + (-837753602) + ((~((-1245058018) | i1717)) * 979) + ((streamVolume3 | 106563732) * (-979)) + (((~(streamVolume3 | (-1245058018))) | (~(i1717 | 106563732))) * 979);
                    int i1719 = (i1718 << 13) ^ i1718;
                    int i1811 = i1719 ^ (i1719 >>> 17);
                    i14 = 0;
                    ((int[]) objArr1016[0])[0] = i1811 ^ (i1811 << 5);
                }
                objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame10 == null) {
                    int i1812 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 24;
                    char cResolveOpacity2 = (char) (Drawable.resolveOpacity(i14, i14) + 30068);
                    int maximumDrawingCacheSize5 = 816 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                    Object[] objArr1017 = new Object[1];
                    b((byte) 96, (byte) 47, $$a[18], objArr1017);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(i1812, cResolveOpacity2, maximumDrawingCacheSize5, 721586079, false, (String) objArr1017[0], null);
                }
                j3 = ((Field) objAccessartificialFrame10).getLong(null);
                if (j3 != -1) {
                    int i1813 = getARTIFICIAL_FRAME_PACKAGE_NAME + 17;
                    artificialFrame = i1813 % 128;
                    int i1814 = i1813 % 2;
                    if (j3 + 1889 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                        objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                        if (objAccessartificialFrame14 == null) {
                            int packedPositionGroup4 = ExpandableListView.getPackedPositionGroup(0L) + 25;
                            char mirror5 = (char) (30116 - AndroidCharacter.getMirror('0'));
                            int iResolveOpacity2 = Drawable.resolveOpacity(0, 0) + 816;
                            Object[] objArr1018 = new Object[1];
                            b((byte) 88, (byte) 47, $$a[18], objArr1018);
                            objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(packedPositionGroup4, mirror5, iResolveOpacity2, 891606461, false, (String) objArr1018[0], null);
                        }
                        Object[] objArr1019 = (Object[]) ((Field) objAccessartificialFrame14).get(null);
                        objArr7 = new Object[]{new int[]{i184}, new int[]{i185}, strArr10, new int[1]};
                        int i1815 = ((int[]) objArr1019[0])[0];
                        int i1816 = ((int[]) objArr1019[1])[0];
                        String[] strArr13 = (String[]) objArr1019[2];
                        int iIdentityHashCode9 = System.identityHashCode(this);
                        int i1817 = 736166445 + (((~(279340396 | iIdentityHashCode9)) | (-477512763)) * (-964)) + (((~((~iIdentityHashCode9) | 279340396)) | (-485909887)) * (-964)) + 1411491212;
                        int i1818 = (i1817 << 13) ^ i1817;
                        int i1819 = i1818 ^ (i1818 >>> 17);
                        ((int[]) objArr7[3])[0] = i1819 ^ (i1819 << 5);
                    } else {
                        Object[] objArr10110 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1411491212};
                        objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(1327366003);
                        if (objAccessartificialFrame11 == null) {
                            int iAlpha3 = Color.alpha(0) + 25;
                            char offsetAfter5 = (char) (TextUtils.getOffsetAfter("", 0) + 30068);
                            int bitsPerPixel5 = ImageFormat.getBitsPerPixel(0) + 817;
                            byte[] bArr29 = $$a;
                            Object[] objArr10111 = new Object[1];
                            b((byte) 80, bArr29[35], bArr29[9], objArr10111);
                            objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(iAlpha3, offsetAfter5, bitsPerPixel5, -797394565, false, (String) objArr10111[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                        }
                        objArr7 = (Object[]) ((Method) objAccessartificialFrame11).invoke(null, objArr10110);
                        objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                        if (objAccessartificialFrame12 == null) {
                            int i18110 = 25 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                            char keyRepeatTimeout5 = (char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 30068);
                            int maximumDrawingCacheSize6 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 816;
                            Object[] objArr10112 = new Object[1];
                            b((byte) 88, (byte) 47, $$a[18], objArr10112);
                            objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(i18110, keyRepeatTimeout5, maximumDrawingCacheSize6, 891606461, false, (String) objArr10112[0], null);
                        }
                        ((Field) objAccessartificialFrame12).set(null, objArr7);
                        Long lValueOf10 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame13 == null) {
                            int i1910 = 25 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                            char scrollBarSize7 = (char) ((ViewConfiguration.getScrollBarSize() >> 8) + 30068);
                            int doubleTapTimeout4 = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 816;
                            Object[] objArr10113 = new Object[1];
                            b((byte) 96, (byte) 47, $$a[18], objArr10113);
                            objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(i1910, scrollBarSize7, doubleTapTimeout4, 721586079, false, (String) objArr10113[0], null);
                        }
                        ((Field) objAccessartificialFrame13).set(null, lValueOf10);
                    }
                } else {
                    Object[] objArr10114 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1411491212};
                    objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame11 == null) {
                        int iAlpha4 = Color.alpha(0) + 25;
                        char offsetAfter6 = (char) (TextUtils.getOffsetAfter("", 0) + 30068);
                        int bitsPerPixel6 = ImageFormat.getBitsPerPixel(0) + 817;
                        byte[] bArr210 = $$a;
                        Object[] objArr10115 = new Object[1];
                        b((byte) 80, bArr210[35], bArr210[9], objArr10115);
                        objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(iAlpha4, offsetAfter6, bitsPerPixel6, -797394565, false, (String) objArr10115[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr7 = (Object[]) ((Method) objAccessartificialFrame11).invoke(null, objArr10114);
                    objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame12 == null) {
                        int i18111 = 25 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                        char keyRepeatTimeout6 = (char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 30068);
                        int maximumDrawingCacheSize7 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 816;
                        Object[] objArr10116 = new Object[1];
                        b((byte) 88, (byte) 47, $$a[18], objArr10116);
                        objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(i18111, keyRepeatTimeout6, maximumDrawingCacheSize7, 891606461, false, (String) objArr10116[0], null);
                    }
                    ((Field) objAccessartificialFrame12).set(null, objArr7);
                    Long lValueOf11 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame13 == null) {
                        int i1911 = 25 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                        char scrollBarSize8 = (char) ((ViewConfiguration.getScrollBarSize() >> 8) + 30068);
                        int doubleTapTimeout5 = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 816;
                        Object[] objArr10117 = new Object[1];
                        b((byte) 96, (byte) 47, $$a[18], objArr10117);
                        objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(i1911, scrollBarSize8, doubleTapTimeout5, 721586079, false, (String) objArr10117[0], null);
                    }
                    ((Field) objAccessartificialFrame13).set(null, lValueOf11);
                }
                i15 = ((int[]) objArr7[1])[0];
                i16 = ((int[]) objArr7[0])[0];
                if (i16 == i15) {
                    Object[] objArr119 = {new int[]{i193}, new int[]{i194}, strArr11, new int[1]};
                    int i1912 = ((int[]) objArr7[3])[0];
                    int i1913 = ((int[]) objArr7[0])[0];
                    int i1914 = ((int[]) objArr7[1])[0];
                    String[] strArr14 = (String[]) objArr7[2];
                    int iIdentityHashCode10 = System.identityHashCode(this);
                    int i1915 = (~((-317348151) | iIdentityHashCode10)) | 283115798;
                    int i1916 = i1912 + 688927133 + (i1915 * 992) + ((i1915 | (~((~iIdentityHashCode10) | (-84943433)))) * (-496)) + ((iIdentityHashCode10 | (-119175785)) * 496);
                    int i1917 = (i1916 << 13) ^ i1916;
                    int i1918 = i1917 ^ (i1917 >>> 17);
                    ((int[]) objArr119[3])[0] = i1918 ^ (i1918 << 5);
                    return;
                }
                arrayList = new ArrayList();
                strArr = (String[]) objArr7[2];
                if (strArr != null) {
                    while (i17 < strArr.length) {
                        arrayList.add(str8);
                    }
                }
                long j13 = (((long) (-1925467315)) << 32) ^ ((long) (i15 ^ i16));
                long j14 = -1925467316;
                int i1919 = artificialFrame + 115;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i1919 % 128;
                int i209 = i1919 % 2;
                Object[] objArr1110 = {Long.valueOf(j13), Long.valueOf(j14)};
                byte[] bArr211 = $$d;
                Object[] objArr1111 = new Object[1];
                d(bArr211[369], bArr211[530], bArr211[33], objArr1111);
                Class<?> cls18 = Class.forName((String) objArr1111[0]);
                short s8 = (short) (-bArr211[384]);
                int i2010 = $$e;
                Object[] objArr1112 = new Object[1];
                d(s8, (byte) (i2010 | 80), (byte) (i2010 | 73), objArr1112);
                cls18.getMethod((String) objArr1112[0], Long.TYPE, Long.TYPE).invoke(null, objArr1110);
                Object[] objArr1113 = {new int[]{i203}, new int[]{i204}, strArr12, new int[1]};
                int i2011 = ((int[]) objArr7[3])[0];
                int i2012 = ((int[]) objArr7[0])[0];
                int i2013 = ((int[]) objArr7[1])[0];
                String[] strArr15 = (String[]) objArr7[2];
                int length2 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 430336816;
                int i2014 = ~length2;
                int i2015 = i2011 + (((((~(529670845 | i2014)) | (~((-727843212) | length2))) | (~(i2014 | 727843211))) * 959) - 1003742194) + (((~(length2 | 727843211)) | (~(i2014 | (-727843212))) | (~(529670845 | length2))) * 959);
                int i2016 = (i2015 << 13) ^ i2015;
                int i2017 = i2016 ^ (i2016 >>> 17);
                ((int[]) objArr1113[3])[0] = i2017 ^ (i2017 << 5);
                return;
            }
            i5 = 0;
            if (j2 != -1) {
                int i1510 = artificialFrame + 35;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i1510 % 128;
                int i1613 = i1510 % 2;
                i11 = 0;
                if (j2 + 1887 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                    if (objAccessartificialFrame15 == null) {
                        int deadChar2 = KeyEvent.getDeadChar(0, 0) + 36;
                        char c10 = (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                        int maximumDrawingCacheSize8 = 540 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                        Object[] objArr912 = new Object[1];
                        b((byte) 88, (byte) 47, $$a[18], objArr912);
                        objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(deadChar2, c10, maximumDrawingCacheSize8, 793268735, false, (String) objArr912[0], null);
                    }
                    Object[] objArr913 = (Object[]) ((Field) objAccessartificialFrame15).get(null);
                    objArr6 = new Object[]{new int[1], new int[1], new int[1]};
                    int i1614 = ((int[]) objArr913[2])[0];
                    int i1615 = ((int[]) objArr913[1])[0];
                    ((int[]) objArr6[2])[0] = i1614;
                    ((int[]) objArr6[1])[0] = i1615;
                    int i1616 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenLayout;
                    int i1617 = 1279395388 + (((~(i1616 | 687431762)) | (-805305460)) * 305) + (((~((~i1616) | 687431762)) | (-664189988)) * 305) + 913739567;
                    int i1618 = (i1617 << 13) ^ i1617;
                    int i1619 = i1618 ^ (i1618 >>> 17);
                    ((int[]) objArr6[0])[0] = i1619 ^ (i1619 << 5);
                }
                obj2 = objArr6[1];
                i12 = ((int[]) obj2)[0];
                obj3 = objArr6[2];
                i13 = ((int[]) obj3)[0];
                if (i13 == i12) {
                    Object[] objArr914 = {new int[1], new int[1], new int[1]};
                    int i16110 = ((int[]) objArr6[0])[0];
                    int i16111 = ((int[]) obj3)[0];
                    int i16112 = ((int[]) obj2)[0];
                    ((int[]) objArr914[2])[0] = i16111;
                    ((int[]) objArr914[1])[0] = i16112;
                    int iUptimeMillis3 = (int) SystemClock.uptimeMillis();
                    int i17110 = i16110 + 767387757 + (((~(30291077 | iUptimeMillis3)) | (-1339029494) | (~(1321330672 | iUptimeMillis3))) * (-744)) + (((~iUptimeMillis3) | 12592256) * 744) + ((iUptimeMillis3 | 1339029493) * 744);
                    int i17111 = (i17110 << 13) ^ i17110;
                    int i17112 = i17111 ^ (i17111 >>> 17);
                    i14 = 0;
                    ((int[]) objArr914[0])[0] = i17112 ^ (i17112 << 5);
                } else {
                    Object[] objArr915 = {Long.valueOf(((long) (i12 ^ i13)) ^ (((long) (-2102054361)) << 32)), Long.valueOf(-2102058457)};
                    int i17113 = $$e;
                    byte[] bArr212 = $$d;
                    Object[] objArr10118 = new Object[1];
                    d((short) (i17113 | 525), (byte) (-bArr212[212]), bArr212[33], objArr10118);
                    Class<?> cls19 = Class.forName((String) objArr10118[0]);
                    Object[] objArr10119 = new Object[1];
                    d((short) (-bArr212[384]), (byte) (i17113 | 80), (byte) (i17113 | 73), objArr10119);
                    cls19.getMethod((String) objArr10119[0], Long.TYPE, Long.TYPE).invoke(null, objArr915);
                    Object[] objArr10120 = {new int[1], new int[1], new int[1]};
                    int i17114 = ((int[]) objArr6[0])[0];
                    int i17115 = ((int[]) objArr6[2])[0];
                    int i17116 = ((int[]) objArr6[1])[0];
                    ((int[]) objArr10120[2])[0] = i17115;
                    ((int[]) objArr10120[1])[0] = i17116;
                    int streamVolume4 = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getStreamVolume(3);
                    int i17117 = ~streamVolume4;
                    int i17118 = i17114 + (-837753602) + ((~((-1245058018) | i17117)) * 979) + ((streamVolume4 | 106563732) * (-979)) + (((~(streamVolume4 | (-1245058018))) | (~(i17117 | 106563732))) * 979);
                    int i17119 = (i17118 << 13) ^ i17118;
                    int i18112 = i17119 ^ (i17119 >>> 17);
                    i14 = 0;
                    ((int[]) objArr10120[0])[0] = i18112 ^ (i18112 << 5);
                }
                objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame10 == null) {
                    int i18113 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 24;
                    char cResolveOpacity3 = (char) (Drawable.resolveOpacity(i14, i14) + 30068);
                    int maximumDrawingCacheSize9 = 816 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                    Object[] objArr10121 = new Object[1];
                    b((byte) 96, (byte) 47, $$a[18], objArr10121);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(i18113, cResolveOpacity3, maximumDrawingCacheSize9, 721586079, false, (String) objArr10121[0], null);
                }
                j3 = ((Field) objAccessartificialFrame10).getLong(null);
                if (j3 != -1) {
                    int i18114 = getARTIFICIAL_FRAME_PACKAGE_NAME + 17;
                    artificialFrame = i18114 % 128;
                    int i18115 = i18114 % 2;
                    if (j3 + 1889 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                        objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                        if (objAccessartificialFrame14 == null) {
                            int packedPositionGroup5 = ExpandableListView.getPackedPositionGroup(0L) + 25;
                            char mirror6 = (char) (30116 - AndroidCharacter.getMirror('0'));
                            int iResolveOpacity3 = Drawable.resolveOpacity(0, 0) + 816;
                            Object[] objArr10122 = new Object[1];
                            b((byte) 88, (byte) 47, $$a[18], objArr10122);
                            objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(packedPositionGroup5, mirror6, iResolveOpacity3, 891606461, false, (String) objArr10122[0], null);
                        }
                        Object[] objArr10123 = (Object[]) ((Field) objAccessartificialFrame14).get(null);
                        objArr7 = new Object[]{new int[]{i1815}, new int[]{i1816}, strArr13, new int[1]};
                        int i18116 = ((int[]) objArr10123[0])[0];
                        int i18117 = ((int[]) objArr10123[1])[0];
                        String[] strArr16 = (String[]) objArr10123[2];
                        int iIdentityHashCode11 = System.identityHashCode(this);
                        int i18118 = 736166445 + (((~(279340396 | iIdentityHashCode11)) | (-477512763)) * (-964)) + (((~((~iIdentityHashCode11) | 279340396)) | (-485909887)) * (-964)) + 1411491212;
                        int i18119 = (i18118 << 13) ^ i18118;
                        int i18120 = i18119 ^ (i18119 >>> 17);
                        ((int[]) objArr7[3])[0] = i18120 ^ (i18120 << 5);
                    } else {
                        Object[] objArr101110 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1411491212};
                        objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(1327366003);
                        if (objAccessartificialFrame11 == null) {
                            int iAlpha5 = Color.alpha(0) + 25;
                            char offsetAfter7 = (char) (TextUtils.getOffsetAfter("", 0) + 30068);
                            int bitsPerPixel7 = ImageFormat.getBitsPerPixel(0) + 817;
                            byte[] bArr213 = $$a;
                            Object[] objArr101111 = new Object[1];
                            b((byte) 80, bArr213[35], bArr213[9], objArr101111);
                            objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(iAlpha5, offsetAfter7, bitsPerPixel7, -797394565, false, (String) objArr101111[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                        }
                        objArr7 = (Object[]) ((Method) objAccessartificialFrame11).invoke(null, objArr101110);
                        objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                        if (objAccessartificialFrame12 == null) {
                            int i181110 = 25 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                            char keyRepeatTimeout7 = (char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 30068);
                            int maximumDrawingCacheSize10 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 816;
                            Object[] objArr101112 = new Object[1];
                            b((byte) 88, (byte) 47, $$a[18], objArr101112);
                            objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(i181110, keyRepeatTimeout7, maximumDrawingCacheSize10, 891606461, false, (String) objArr101112[0], null);
                        }
                        ((Field) objAccessartificialFrame12).set(null, objArr7);
                        Long lValueOf12 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame13 == null) {
                            int i19110 = 25 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                            char scrollBarSize9 = (char) ((ViewConfiguration.getScrollBarSize() >> 8) + 30068);
                            int doubleTapTimeout6 = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 816;
                            Object[] objArr101113 = new Object[1];
                            b((byte) 96, (byte) 47, $$a[18], objArr101113);
                            objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(i19110, scrollBarSize9, doubleTapTimeout6, 721586079, false, (String) objArr101113[0], null);
                        }
                        ((Field) objAccessartificialFrame13).set(null, lValueOf12);
                    }
                } else {
                    Object[] objArr101114 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1411491212};
                    objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame11 == null) {
                        int iAlpha6 = Color.alpha(0) + 25;
                        char offsetAfter8 = (char) (TextUtils.getOffsetAfter("", 0) + 30068);
                        int bitsPerPixel8 = ImageFormat.getBitsPerPixel(0) + 817;
                        byte[] bArr214 = $$a;
                        Object[] objArr101115 = new Object[1];
                        b((byte) 80, bArr214[35], bArr214[9], objArr101115);
                        objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(iAlpha6, offsetAfter8, bitsPerPixel8, -797394565, false, (String) objArr101115[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr7 = (Object[]) ((Method) objAccessartificialFrame11).invoke(null, objArr101114);
                    objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame12 == null) {
                        int i181111 = 25 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                        char keyRepeatTimeout8 = (char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 30068);
                        int maximumDrawingCacheSize11 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 816;
                        Object[] objArr101116 = new Object[1];
                        b((byte) 88, (byte) 47, $$a[18], objArr101116);
                        objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(i181111, keyRepeatTimeout8, maximumDrawingCacheSize11, 891606461, false, (String) objArr101116[0], null);
                    }
                    ((Field) objAccessartificialFrame12).set(null, objArr7);
                    Long lValueOf13 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame13 == null) {
                        int i19111 = 25 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                        char scrollBarSize10 = (char) ((ViewConfiguration.getScrollBarSize() >> 8) + 30068);
                        int doubleTapTimeout7 = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 816;
                        Object[] objArr101117 = new Object[1];
                        b((byte) 96, (byte) 47, $$a[18], objArr101117);
                        objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(i19111, scrollBarSize10, doubleTapTimeout7, 721586079, false, (String) objArr101117[0], null);
                    }
                    ((Field) objAccessartificialFrame13).set(null, lValueOf13);
                }
                i15 = ((int[]) objArr7[1])[0];
                i16 = ((int[]) objArr7[0])[0];
                if (i16 == i15) {
                    Object[] objArr1114 = {new int[]{i1913}, new int[]{i1914}, strArr14, new int[1]};
                    int i19112 = ((int[]) objArr7[3])[0];
                    int i19113 = ((int[]) objArr7[0])[0];
                    int i19114 = ((int[]) objArr7[1])[0];
                    String[] strArr17 = (String[]) objArr7[2];
                    int iIdentityHashCode12 = System.identityHashCode(this);
                    int i19115 = (~((-317348151) | iIdentityHashCode12)) | 283115798;
                    int i19116 = i19112 + 688927133 + (i19115 * 992) + ((i19115 | (~((~iIdentityHashCode12) | (-84943433)))) * (-496)) + ((iIdentityHashCode12 | (-119175785)) * 496);
                    int i19117 = (i19116 << 13) ^ i19116;
                    int i19118 = i19117 ^ (i19117 >>> 17);
                    ((int[]) objArr1114[3])[0] = i19118 ^ (i19118 << 5);
                    return;
                }
                arrayList = new ArrayList();
                strArr = (String[]) objArr7[2];
                if (strArr != null) {
                    while (i17 < strArr.length) {
                        arrayList.add(str8);
                    }
                }
                long j15 = (((long) (-1925467315)) << 32) ^ ((long) (i15 ^ i16));
                long j16 = -1925467316;
                int i19119 = artificialFrame + 115;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i19119 % 128;
                int i2018 = i19119 % 2;
                Object[] objArr1115 = {Long.valueOf(j15), Long.valueOf(j16)};
                byte[] bArr215 = $$d;
                Object[] objArr1116 = new Object[1];
                d(bArr215[369], bArr215[530], bArr215[33], objArr1116);
                Class<?> cls110 = Class.forName((String) objArr1116[0]);
                short s9 = (short) (-bArr215[384]);
                int i2019 = $$e;
                Object[] objArr1117 = new Object[1];
                d(s9, (byte) (i2019 | 80), (byte) (i2019 | 73), objArr1117);
                cls110.getMethod((String) objArr1117[0], Long.TYPE, Long.TYPE).invoke(null, objArr1115);
                Object[] objArr1118 = {new int[]{i2012}, new int[]{i2013}, strArr15, new int[1]};
                int i20110 = ((int[]) objArr7[3])[0];
                int i20111 = ((int[]) objArr7[0])[0];
                int i20112 = ((int[]) objArr7[1])[0];
                String[] strArr18 = (String[]) objArr7[2];
                int length3 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 430336816;
                int i20113 = ~length3;
                int i20114 = i20110 + (((((~(529670845 | i20113)) | (~((-727843212) | length3))) | (~(i20113 | 727843211))) * 959) - 1003742194) + (((~(length3 | 727843211)) | (~(i20113 | (-727843212))) | (~(529670845 | length3))) * 959);
                int i20115 = (i20114 << 13) ^ i20114;
                int i20116 = i20115 ^ (i20115 >>> 17);
                ((int[]) objArr1118[3])[0] = i20116 ^ (i20116 << 5);
                return;
            }
            i11 = 0;
            Long lValueOf14 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1168947751);
            if (objAccessartificialFrame9 == null) {
                int jumpTapTimeout3 = 36 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                char maxKeyCode3 = (char) (KeyEvent.getMaxKeyCode() >> 16);
                int bitsPerPixel9 = ImageFormat.getBitsPerPixel(0) + 541;
                Object[] objArr1119 = new Object[1];
                b((byte) 96, (byte) 47, $$a[18], objArr1119);
                objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout3, maxKeyCode3, bitsPerPixel9, 624296913, false, (String) objArr1119[0], null);
            }
            ((Field) objAccessartificialFrame9).set(null, lValueOf14);
            obj2 = objArr6[1];
            i12 = ((int[]) obj2)[0];
            obj3 = objArr6[2];
            i13 = ((int[]) obj3)[0];
            if (i13 == i12) {
                Object[] objArr916 = {new int[1], new int[1], new int[1]};
                int i16113 = ((int[]) objArr6[0])[0];
                int i16114 = ((int[]) obj3)[0];
                int i16115 = ((int[]) obj2)[0];
                ((int[]) objArr916[2])[0] = i16114;
                ((int[]) objArr916[1])[0] = i16115;
                int iUptimeMillis4 = (int) SystemClock.uptimeMillis();
                int i171110 = i16113 + 767387757 + (((~(30291077 | iUptimeMillis4)) | (-1339029494) | (~(1321330672 | iUptimeMillis4))) * (-744)) + (((~iUptimeMillis4) | 12592256) * 744) + ((iUptimeMillis4 | 1339029493) * 744);
                int i171111 = (i171110 << 13) ^ i171110;
                int i171112 = i171111 ^ (i171111 >>> 17);
                i14 = 0;
                ((int[]) objArr916[0])[0] = i171112 ^ (i171112 << 5);
            } else {
                Object[] objArr917 = {Long.valueOf(((long) (i12 ^ i13)) ^ (((long) (-2102054361)) << 32)), Long.valueOf(-2102058457)};
                int i171113 = $$e;
                byte[] bArr216 = $$d;
                Object[] objArr101118 = new Object[1];
                d((short) (i171113 | 525), (byte) (-bArr216[212]), bArr216[33], objArr101118);
                Class<?> cls111 = Class.forName((String) objArr101118[0]);
                Object[] objArr101119 = new Object[1];
                d((short) (-bArr216[384]), (byte) (i171113 | 80), (byte) (i171113 | 73), objArr101119);
                cls111.getMethod((String) objArr101119[0], Long.TYPE, Long.TYPE).invoke(null, objArr917);
                Object[] objArr10124 = {new int[1], new int[1], new int[1]};
                int i171114 = ((int[]) objArr6[0])[0];
                int i171115 = ((int[]) objArr6[2])[0];
                int i171116 = ((int[]) objArr6[1])[0];
                ((int[]) objArr10124[2])[0] = i171115;
                ((int[]) objArr10124[1])[0] = i171116;
                int streamVolume5 = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getStreamVolume(3);
                int i171117 = ~streamVolume5;
                int i171118 = i171114 + (-837753602) + ((~((-1245058018) | i171117)) * 979) + ((streamVolume5 | 106563732) * (-979)) + (((~(streamVolume5 | (-1245058018))) | (~(i171117 | 106563732))) * 979);
                int i171119 = (i171118 << 13) ^ i171118;
                int i181112 = i171119 ^ (i171119 >>> 17);
                i14 = 0;
                ((int[]) objArr10124[0])[0] = i181112 ^ (i181112 << 5);
            }
            objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame10 == null) {
                int i181113 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 24;
                char cResolveOpacity4 = (char) (Drawable.resolveOpacity(i14, i14) + 30068);
                int maximumDrawingCacheSize12 = 816 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                Object[] objArr10125 = new Object[1];
                b((byte) 96, (byte) 47, $$a[18], objArr10125);
                objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(i181113, cResolveOpacity4, maximumDrawingCacheSize12, 721586079, false, (String) objArr10125[0], null);
            }
            j3 = ((Field) objAccessartificialFrame10).getLong(null);
            if (j3 != -1) {
                int i181114 = getARTIFICIAL_FRAME_PACKAGE_NAME + 17;
                artificialFrame = i181114 % 128;
                int i181115 = i181114 % 2;
                if (j3 + 1889 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame14 == null) {
                        int packedPositionGroup6 = ExpandableListView.getPackedPositionGroup(0L) + 25;
                        char mirror7 = (char) (30116 - AndroidCharacter.getMirror('0'));
                        int iResolveOpacity4 = Drawable.resolveOpacity(0, 0) + 816;
                        Object[] objArr10126 = new Object[1];
                        b((byte) 88, (byte) 47, $$a[18], objArr10126);
                        objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(packedPositionGroup6, mirror7, iResolveOpacity4, 891606461, false, (String) objArr10126[0], null);
                    }
                    Object[] objArr10127 = (Object[]) ((Field) objAccessartificialFrame14).get(null);
                    objArr7 = new Object[]{new int[]{i18116}, new int[]{i18117}, strArr16, new int[1]};
                    int i181116 = ((int[]) objArr10127[0])[0];
                    int i181117 = ((int[]) objArr10127[1])[0];
                    String[] strArr19 = (String[]) objArr10127[2];
                    int iIdentityHashCode13 = System.identityHashCode(this);
                    int i181118 = 736166445 + (((~(279340396 | iIdentityHashCode13)) | (-477512763)) * (-964)) + (((~((~iIdentityHashCode13) | 279340396)) | (-485909887)) * (-964)) + 1411491212;
                    int i181119 = (i181118 << 13) ^ i181118;
                    int i18121 = i181119 ^ (i181119 >>> 17);
                    ((int[]) objArr7[3])[0] = i18121 ^ (i18121 << 5);
                } else {
                    Object[] objArr1011110 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1411491212};
                    objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame11 == null) {
                        int iAlpha7 = Color.alpha(0) + 25;
                        char offsetAfter9 = (char) (TextUtils.getOffsetAfter("", 0) + 30068);
                        int bitsPerPixel10 = ImageFormat.getBitsPerPixel(0) + 817;
                        byte[] bArr217 = $$a;
                        Object[] objArr1011111 = new Object[1];
                        b((byte) 80, bArr217[35], bArr217[9], objArr1011111);
                        objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(iAlpha7, offsetAfter9, bitsPerPixel10, -797394565, false, (String) objArr1011111[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr7 = (Object[]) ((Method) objAccessartificialFrame11).invoke(null, objArr1011110);
                    objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame12 == null) {
                        int i1811110 = 25 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                        char keyRepeatTimeout9 = (char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 30068);
                        int maximumDrawingCacheSize13 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 816;
                        Object[] objArr1011112 = new Object[1];
                        b((byte) 88, (byte) 47, $$a[18], objArr1011112);
                        objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(i1811110, keyRepeatTimeout9, maximumDrawingCacheSize13, 891606461, false, (String) objArr1011112[0], null);
                    }
                    ((Field) objAccessartificialFrame12).set(null, objArr7);
                    Long lValueOf15 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame13 == null) {
                        int i191110 = 25 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                        char scrollBarSize11 = (char) ((ViewConfiguration.getScrollBarSize() >> 8) + 30068);
                        int doubleTapTimeout8 = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 816;
                        Object[] objArr1011113 = new Object[1];
                        b((byte) 96, (byte) 47, $$a[18], objArr1011113);
                        objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(i191110, scrollBarSize11, doubleTapTimeout8, 721586079, false, (String) objArr1011113[0], null);
                    }
                    ((Field) objAccessartificialFrame13).set(null, lValueOf15);
                }
            } else {
                Object[] objArr1011114 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1411491212};
                objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame11 == null) {
                    int iAlpha8 = Color.alpha(0) + 25;
                    char offsetAfter10 = (char) (TextUtils.getOffsetAfter("", 0) + 30068);
                    int bitsPerPixel11 = ImageFormat.getBitsPerPixel(0) + 817;
                    byte[] bArr218 = $$a;
                    Object[] objArr1011115 = new Object[1];
                    b((byte) 80, bArr218[35], bArr218[9], objArr1011115);
                    objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(iAlpha8, offsetAfter10, bitsPerPixel11, -797394565, false, (String) objArr1011115[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr7 = (Object[]) ((Method) objAccessartificialFrame11).invoke(null, objArr1011114);
                objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame12 == null) {
                    int i1811111 = 25 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                    char keyRepeatTimeout10 = (char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 30068);
                    int maximumDrawingCacheSize14 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 816;
                    Object[] objArr1011116 = new Object[1];
                    b((byte) 88, (byte) 47, $$a[18], objArr1011116);
                    objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(i1811111, keyRepeatTimeout10, maximumDrawingCacheSize14, 891606461, false, (String) objArr1011116[0], null);
                }
                ((Field) objAccessartificialFrame12).set(null, objArr7);
                Long lValueOf16 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame13 == null) {
                    int i191111 = 25 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                    char scrollBarSize12 = (char) ((ViewConfiguration.getScrollBarSize() >> 8) + 30068);
                    int doubleTapTimeout9 = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 816;
                    Object[] objArr1011117 = new Object[1];
                    b((byte) 96, (byte) 47, $$a[18], objArr1011117);
                    objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(i191111, scrollBarSize12, doubleTapTimeout9, 721586079, false, (String) objArr1011117[0], null);
                }
                ((Field) objAccessartificialFrame13).set(null, lValueOf16);
            }
            i15 = ((int[]) objArr7[1])[0];
            i16 = ((int[]) objArr7[0])[0];
            if (i16 == i15) {
                Object[] objArr11110 = {new int[]{i19113}, new int[]{i19114}, strArr17, new int[1]};
                int i191112 = ((int[]) objArr7[3])[0];
                int i191113 = ((int[]) objArr7[0])[0];
                int i191114 = ((int[]) objArr7[1])[0];
                String[] strArr110 = (String[]) objArr7[2];
                int iIdentityHashCode14 = System.identityHashCode(this);
                int i191115 = (~((-317348151) | iIdentityHashCode14)) | 283115798;
                int i191116 = i191112 + 688927133 + (i191115 * 992) + ((i191115 | (~((~iIdentityHashCode14) | (-84943433)))) * (-496)) + ((iIdentityHashCode14 | (-119175785)) * 496);
                int i191117 = (i191116 << 13) ^ i191116;
                int i191118 = i191117 ^ (i191117 >>> 17);
                ((int[]) objArr11110[3])[0] = i191118 ^ (i191118 << 5);
                return;
            }
            arrayList = new ArrayList();
            strArr = (String[]) objArr7[2];
            if (strArr != null) {
                while (i17 < strArr.length) {
                    arrayList.add(str8);
                }
            }
            long j17 = (((long) (-1925467315)) << 32) ^ ((long) (i15 ^ i16));
            long j18 = -1925467316;
            int i191119 = artificialFrame + 115;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i191119 % 128;
            int i20117 = i191119 % 2;
            Object[] objArr11111 = {Long.valueOf(j17), Long.valueOf(j18)};
            byte[] bArr219 = $$d;
            Object[] objArr11112 = new Object[1];
            d(bArr219[369], bArr219[530], bArr219[33], objArr11112);
            Class<?> cls112 = Class.forName((String) objArr11112[0]);
            short s10 = (short) (-bArr219[384]);
            int i20118 = $$e;
            Object[] objArr11113 = new Object[1];
            d(s10, (byte) (i20118 | 80), (byte) (i20118 | 73), objArr11113);
            cls112.getMethod((String) objArr11113[0], Long.TYPE, Long.TYPE).invoke(null, objArr11111);
            Object[] objArr11114 = {new int[]{i20111}, new int[]{i20112}, strArr18, new int[1]};
            int i20119 = ((int[]) objArr7[3])[0];
            int i201110 = ((int[]) objArr7[0])[0];
            int i201111 = ((int[]) objArr7[1])[0];
            String[] strArr111 = (String[]) objArr7[2];
            int length4 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 430336816;
            int i201112 = ~length4;
            int i201113 = i20119 + (((((~(529670845 | i201112)) | (~((-727843212) | length4))) | (~(i201112 | 727843211))) * 959) - 1003742194) + (((~(length4 | 727843211)) | (~(i201112 | (-727843212))) | (~(529670845 | length4))) * 959);
            int i201114 = (i201113 << 13) ^ i201113;
            int i201115 = i201114 ^ (i201114 >>> 17);
            ((int[]) objArr11114[3])[0] = i201115 ^ (i201115 << 5);
            return;
        } catch (Exception unused7) {
            throw new RuntimeException();
        }
        Context baseContext4 = getBaseContext();
        if (baseContext4 == null) {
            Object[] objArr120 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i5]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(i5) - 84, new char[]{17, 5, '0', CoreConstants.DASH_CHAR, '$', ' ', CoreConstants.DASH_CHAR, 19, 20, 26, 24, 20, 14, '\"', ' ', 30, '+', ' ', 30, Typography.amp, '+', 17, '+', 2, 26, 5}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i5]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(i5, 4).length() + 11), objArr120);
            Class<?> cls20 = Class.forName((String) objArr120[i5]);
            Object[] objArr121 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i5]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 17, new char[]{'\"', '#', 13880, 13880, 2, 4, '\"', 17, 13882, 13882, 28, 30, '!', 14, ' ', 30, Typography.amp, 4}, (byte) (80 - Color.red(0)), objArr121);
            baseContext4 = (Context) cls20.getMethod((String) objArr121[0], new Class[0]).invoke(null, null);
        }
        if (baseContext4 != null) {
            baseContext4 = ((baseContext4 instanceof ContextWrapper) && ((ContextWrapper) baseContext4).getBaseContext() == null) ? null : baseContext4.getApplicationContext();
        }
        Object[] objArr122 = {baseContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 857588439};
        byte[] bArr30 = $$d;
        Object[] objArr123 = new Object[1];
        d((short) 480, bArr30[148], bArr30[33], objArr123);
        Class<?> cls21 = Class.forName((String) objArr123[0]);
        Object[] objArr124 = new Object[1];
        d((short) 389, bArr30[48], (byte) (-bArr30[597]), objArr124);
        objArr4 = (Object[]) cls21.getMethod((String) objArr124[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr122);
        if (baseContext4 != null) {
            Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(-326560385);
            if (objAccessartificialFrame38 == null) {
                int jumpTapTimeout4 = 30 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                char c11 = (char) (49362 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)));
                int i210 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 683;
                byte[] bArr31 = $$a;
                byte b12 = (byte) (bArr31[33] - 1);
                Object[] objArr125 = new Object[1];
                b(b12, (byte) (b12 + 3), (byte) (-bArr31[4]), objArr125);
                objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout4, c11, i210, 1944867703, false, (String) objArr125[0], null);
            }
            ((Field) objAccessartificialFrame38).set(null, objArr4);
            try {
                Long lValueOf17 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame39 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                if (objAccessartificialFrame39 == null) {
                    int doubleTapTimeout10 = 30 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                    char c12 = (char) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 49362);
                    int i211 = 684 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                    byte[] bArr32 = $$a;
                    byte b13 = bArr32[14];
                    Object[] objArr126 = new Object[1];
                    b(b13, (byte) (b13 - 5), (byte) (-bArr32[4]), objArr126);
                    objAccessartificialFrame39 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout10, c12, i211, 752929587, false, (String) objArr126[0], null);
                }
                ((Field) objAccessartificialFrame39).set(null, lValueOf17);
            } catch (Exception unused8) {
                throw new RuntimeException();
            }
        }
        i6 = ((int[]) objArr4[1])[0];
        i7 = ((int[]) objArr4[0])[0];
        if (i7 == i6) {
            int i1210 = ((int[]) objArr4[2])[0];
            Object[] objArr710 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
            int ringerMode2 = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getRingerMode();
            int i1311 = ~ringerMode2;
            int i1312 = i1210 + (-1508821074) + (((~((-12598341) | i1311)) | 8396864 | (~((-966025435) | i1311))) * (-1136)) + (((~((-12598341) | ringerMode2)) | (~((-966025435) | ringerMode2)) | (~(970226910 | i1311))) * (-568)) + (((~(ringerMode2 | (-8396865))) | (~(i1311 | 966025434)) | (~(12598340 | i1311))) * 568);
            int i1313 = (i1312 << 13) ^ i1312;
            int i1314 = i1313 ^ (i1313 >>> 17);
            ((int[]) objArr710[2])[0] = i1314 ^ (i1314 << 5);
        } else {
            Object[] objArr711 = {Long.valueOf(((long) (i6 ^ i7)) ^ (((long) (-1993740083)) << 32)), Long.valueOf(-1993740087)};
            int i1315 = $$e;
            byte[] bArr112 = $$d;
            Object[] objArr712 = new Object[1];
            d((short) (i1315 | 525), (byte) (-bArr112[212]), bArr112[33], objArr712);
            Class<?> cls113 = Class.forName((String) objArr712[0]);
            Object[] objArr815 = new Object[1];
            d((short) (-bArr112[384]), (byte) (i1315 | 80), (byte) (i1315 | 73), objArr815);
            cls113.getMethod((String) objArr815[0], Long.TYPE, Long.TYPE).invoke(null, objArr711);
            int i1316 = ((int[]) objArr4[2])[0];
            Object[] objArr816 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
            int streamVolume6 = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getStreamVolume(3);
            int i1317 = i1316 + (-609636322) + (((~((-8455464) | (~streamVolume6))) | (~(970168311 | streamVolume6))) * (-272)) + (((~((-281118120) | streamVolume6)) | 272662656) * (-272)) + (((~(streamVolume6 | 281118119)) | 697505655) * 272);
            int i1318 = (i1317 << 13) ^ i1317;
            int i1319 = i1318 ^ (i1318 >>> 17);
            ((int[]) objArr816[2])[0] = i1319 ^ (i1319 << 5);
        }
        super.onCreate();
        objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame2 == null) {
            int iMyTid2 = (Process.myTid() >> 22) + 30;
            char touchSlop2 = (char) ((ViewConfiguration.getTouchSlop() >> 8) + 49362);
            int absoluteGravity4 = Gravity.getAbsoluteGravity(0, 0) + 684;
            byte[] bArr113 = $$a;
            Object[] objArr817 = new Object[1];
            b((byte) (-bArr113[94]), (byte) ($$b >>> 2), bArr113[28], objArr817);
            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iMyTid2, touchSlop2, absoluteGravity4, -1583976536, false, (String) objArr817[0], null);
        }
        j = ((Field) objAccessartificialFrame2).getLong(null);
        if (j != -1) {
            i18 = getARTIFICIAL_FRAME_PACKAGE_NAME + 81;
            artificialFrame = i18 % 128;
            if (i18 % 2 == 0) {
                Object[] objArr818 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 2066552710};
                byte[] bArr114 = $$d;
                Object[] objArr819 = new Object[1];
                d((short) 561, bArr114[13], bArr114[33], objArr819);
                Class<?> cls114 = Class.forName((String) objArr819[0]);
                Object[] objArr8110 = new Object[1];
                d((short) ($$e | 633), (byte) (bArr114[324] - 1), bArr114[33], objArr8110);
                objArr5 = (Object[]) cls114.getMethod((String) objArr8110[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr818);
                objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame3 == null) {
                    int scrollBarFadeDuration5 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 30;
                    char c13 = (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 49361);
                    int iResolveSizeAndState4 = 684 - View.resolveSizeAndState(0, 0, 0);
                    byte[] bArr115 = $$a;
                    byte b14 = bArr115[28];
                    Object[] objArr8111 = new Object[1];
                    b(b14, (byte) (b14 | 32), bArr115[18], objArr8111);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration5, c13, iResolveSizeAndState4, -1456483158, false, (String) objArr8111[0], null);
                }
                ((Field) objAccessartificialFrame3).set(null, objArr5);
                Long lValueOf18 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame4 == null) {
                    int scrollBarFadeDuration6 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 30;
                    char c14 = (char) (49363 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                    int i13110 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 683;
                    byte[] bArr220 = $$a;
                    Object[] objArr8112 = new Object[1];
                    b((byte) (-bArr220[94]), (byte) ($$b >>> 2), bArr220[28], objArr8112);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration6, c14, i13110, -1583976536, false, (String) objArr8112[0], null);
                }
                ((Field) objAccessartificialFrame4).set(null, lValueOf18);
            } else {
                Object[] objArr8113 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 2066552710};
                byte[] bArr116 = $$d;
                Object[] objArr8114 = new Object[1];
                d((short) 561, bArr116[13], bArr116[33], objArr8114);
                Class<?> cls115 = Class.forName((String) objArr8114[0]);
                Object[] objArr8115 = new Object[1];
                d((short) ($$e | 633), (byte) (bArr116[324] - 1), bArr116[33], objArr8115);
                objArr5 = (Object[]) cls115.getMethod((String) objArr8115[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr8113);
                objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame3 == null) {
                    int scrollBarFadeDuration7 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 30;
                    char c15 = (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 49361);
                    int iResolveSizeAndState5 = 684 - View.resolveSizeAndState(0, 0, 0);
                    byte[] bArr117 = $$a;
                    byte b15 = bArr117[28];
                    Object[] objArr8116 = new Object[1];
                    b(b15, (byte) (b15 | 32), bArr117[18], objArr8116);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration7, c15, iResolveSizeAndState5, -1456483158, false, (String) objArr8116[0], null);
                }
                ((Field) objAccessartificialFrame3).set(null, objArr5);
                Long lValueOf19 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame4 == null) {
                    int scrollBarFadeDuration8 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 30;
                    char c16 = (char) (49363 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                    int i13111 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 683;
                    byte[] bArr221 = $$a;
                    Object[] objArr8117 = new Object[1];
                    b((byte) (-bArr221[94]), (byte) ($$b >>> 2), bArr221[28], objArr8117);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration8, c16, i13111, -1583976536, false, (String) objArr8117[0], null);
                }
                ((Field) objAccessartificialFrame4).set(null, lValueOf19);
            }
        } else {
            Object[] objArr8118 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 2066552710};
            byte[] bArr118 = $$d;
            Object[] objArr8119 = new Object[1];
            d((short) 561, bArr118[13], bArr118[33], objArr8119);
            Class<?> cls116 = Class.forName((String) objArr8119[0]);
            Object[] objArr81110 = new Object[1];
            d((short) ($$e | 633), (byte) (bArr118[324] - 1), bArr118[33], objArr81110);
            objArr5 = (Object[]) cls116.getMethod((String) objArr81110[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr8118);
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame3 == null) {
                int scrollBarFadeDuration9 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 30;
                char c17 = (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 49361);
                int iResolveSizeAndState6 = 684 - View.resolveSizeAndState(0, 0, 0);
                byte[] bArr119 = $$a;
                byte b16 = bArr119[28];
                Object[] objArr81111 = new Object[1];
                b(b16, (byte) (b16 | 32), bArr119[18], objArr81111);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration9, c17, iResolveSizeAndState6, -1456483158, false, (String) objArr81111[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, objArr5);
            Long lValueOf110 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1056123296);
            if (objAccessartificialFrame4 == null) {
                int scrollBarFadeDuration10 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 30;
                char c18 = (char) (49363 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                int i13112 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 683;
                byte[] bArr222 = $$a;
                Object[] objArr81112 = new Object[1];
                b((byte) (-bArr222[94]), (byte) ($$b >>> 2), bArr222[28], objArr81112);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration10, c18, i13112, -1583976536, false, (String) objArr81112[0], null);
            }
            ((Field) objAccessartificialFrame4).set(null, lValueOf110);
        }
        i8 = ((int[]) objArr5[1])[0];
        i9 = ((int[]) objArr5[0])[0];
        if (i9 == i8) {
            int i1410 = ((int[]) objArr5[2])[0];
            Object[] objArr918 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int i1411 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().navigation;
            int i1412 = i1410 + (-1862065554) + (((~(903075741 | i1411)) | 75548033) * (-756)) + (((~i1411) | 903075741) * 756);
            int i1413 = (i1412 << 13) ^ i1412;
            int i1414 = i1413 ^ (i1413 >>> 17);
            i10 = 0;
            ((int[]) objArr918[2])[0] = i1414 ^ (i1414 << 5);
        } else {
            new ArrayList().add((String) objArr5[3]);
            long j19 = ((long) (i8 ^ i9)) ^ (((long) 857192602) << 32);
            long j110 = 857192586;
            int i1511 = getARTIFICIAL_FRAME_PACKAGE_NAME + 119;
            artificialFrame = i1511 % 128;
            int i1512 = i1511 % 2;
            Object[] objArr919 = {Long.valueOf(j19), Long.valueOf(j110)};
            int i1513 = $$e;
            byte[] bArr223 = $$d;
            Object[] objArr920 = new Object[1];
            d((short) (i1513 | 525), (byte) (-bArr223[212]), bArr223[33], objArr920);
            Class<?> cls117 = Class.forName((String) objArr920[0]);
            Object[] objArr921 = new Object[1];
            d((short) (-bArr223[384]), (byte) (i1513 | 80), (byte) (i1513 | 73), objArr921);
            cls117.getMethod((String) objArr921[0], Long.TYPE, Long.TYPE).invoke(null, objArr919);
            int i1514 = ((int[]) objArr5[2])[0];
            Object[] objArr922 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int iIdentityHashCode15 = System.identityHashCode(this);
            int i1515 = ~((-519338764) | iIdentityHashCode15);
            int i1516 = ~iIdentityHashCode15;
            int i1517 = i1514 + (-567359266) + ((i1515 | (~(459285011 | i1516))) * (-1808)) + (((~((-442507780) | iIdentityHashCode15)) | (~(i1516 | 536115995))) * TypedValues.Custom.TYPE_BOOLEAN) + (((~(iIdentityHashCode15 | (-459285012))) | 76830984 | (~(519338763 | i1516))) * TypedValues.Custom.TYPE_BOOLEAN);
            int i1518 = (i1517 << 13) ^ i1517;
            int i1519 = i1518 ^ (i1518 >>> 17);
            i10 = 0;
            ((int[]) objArr922[2])[0] = i1519 ^ (i1519 << 5);
        }
        objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame5 == null) {
            int modifierMetaStateMask4 = 35 - ((byte) KeyEvent.getModifierMetaStateMask());
            char mode2 = (char) View.MeasureSpec.getMode(i10);
            int doubleTapTimeout11 = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 540;
            Object[] objArr923 = new Object[1];
            b((byte) 96, (byte) 47, $$a[18], objArr923);
            objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask4, mode2, doubleTapTimeout11, 624296913, false, (String) objArr923[0], null);
        }
        j2 = ((Field) objAccessartificialFrame5).getLong(null);
        objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1717965552);
        if (objAccessartificialFrame6 == null) {
            objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(20 - TextUtils.getOffsetBefore("", i11), (char) (MotionEvent.axisFromString("") + 39517), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 981, 117222168, false, null, new Class[0]);
        }
        Object[] objArr1120 = {null, ((Constructor) objAccessartificialFrame6).newInstance(null), 913739567, 0};
        objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-501205803);
        if (objAccessartificialFrame7 == null) {
            int maximumFlingVelocity2 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 36;
            char offsetAfter11 = (char) TextUtils.getOffsetAfter("", 0);
            int capsMode4 = TextUtils.getCapsMode("", 0, 0) + 540;
            byte b17 = (byte) ($$a[5] - 1);
            byte b18 = b17;
            Object[] objArr1121 = new Object[1];
            b(b17, b18, b18, objArr1121);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity2, offsetAfter11, capsMode4, 2101703389, false, (String) objArr1121[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(54 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 834), 576 - (ViewConfiguration.getPressedStateDuration() >> 16)), (Class) ArtificialStackFrames.coroutineCreation(View.MeasureSpec.makeMeasureSpec(0, 0) + 54, (char) (TextUtils.lastIndexOf("", '0', 0) + 1), Color.rgb(0, 0, 0) + 16777846), Integer.TYPE, Integer.TYPE});
        }
        objArr6 = (Object[]) ((Method) objAccessartificialFrame7).invoke(null, objArr1120);
        objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1339222025);
        if (objAccessartificialFrame8 == null) {
            int iCombineMeasuredStates3 = 36 - View.combineMeasuredStates(0, 0);
            char capsMode5 = (char) TextUtils.getCapsMode("", 0, 0);
            int iIndexOf5 = 540 - TextUtils.indexOf("", "", 0);
            Object[] objArr1122 = new Object[1];
            b((byte) 88, (byte) 47, $$a[18], objArr1122);
            objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates3, capsMode5, iIndexOf5, 793268735, false, (String) objArr1122[0], null);
        }
        ((Field) objAccessartificialFrame8).set(null, objArr6);
    }

    static {
        byte[] bArr = new byte[655];
        System.arraycopy("7u3õ\u0000\u0001\u0010\u0004\u0000Çÿ?\t\nõ\u0011\u0000÷\u000fÆM\u0000¿(\u0017\u0000\u000fï\u0012\u0001õ ø\fþ\u0013´7\u001fû\u000fõ\u0011æ\u0011\u0016ü\u0004A\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000Ç?\bø\n\u0002\u000fý\u000bù\u000b\u0001\tûÍ9\u0010\u0007÷Í&&\u0001ù\u0015ò\u0006\u0011å\u0016\u0010\bô\rù\u0006å\u001f\u0006\u0015ÿ\u0007\u000b¯#0\u0002\u0007õ\u0011ÿ\n\u0003\u0007ùË@\tù\u0001ÑJù\büÍ9\t\u000e\u0001\u0003\u0005Ã\u001f\u000e\u0000ø)\u000e\u0001\u0003\u0005\u0001\u0007ü\u0016¯3%\u0005ñ\u0006\u0004\u0006\u0012\u0004ò\u0015\u0006ù\u0001\u0007þ\nü\u000fÞ0ó\u0010ü\u0010\u0002Å=\f\u0004ü\týÍ7\u0013ýÉ'(þ\tñó&\u0001\tÿ\u0010\u0002Å=\f\u0004ü\týÍ7\u0011ú\u0012\u0001þÿÎCø\u0017õ\u0011ûü\u000fÆC\u0006\tù\n\u0003Ä#\u0018\u0017õ\u0011ûü\u000fÚ#\u0006\fè'õ\t\u0001\u0012\u0005\u0002ó\u0017ÿ\u0007¶!3ýÎ\u0004\u0013#\u0006\fÜ\"\u000f\u0004ú\u0003\u0006\fÝ%\u000bý\u0006þ\u0017õ\u0010\u0002Å>\u0005\u000fñ\u0006\t\u0005ü\u0013\u0004Â;\u0017ï\u0006\u000f\bù\n\u0003\t¿#0Î*þ\u0006\u0011\u0001Ú7ï\u0006\u000f\bù\n\u0003û\u0013¾E\u0005ù\rÿÿÎ7\u0013\u0004õ\u0018\u0003øÊ\u00178\u0003ø\u000b\u0007û\u0015ë\u0017ù\n\u0003é\u0016\u0011\b÷þ\u0006ã)\u000eô\u0010\u000bó\u0011\u000b¯- \u000e\u0004ú\týÞ5ù\u0012üü\r\nÕ7ï\u0006\u000f\bù\n\u00030\u0007\u0001\n\u0003ù\tûã%\u0001\u0017ö\u0004\u0006\týè-\u0010\u0002Å=\f\u0004ü\týÍ<\u0007\r÷\u0001\u0003\u0016öÍ9\u0010\u0002\u0007\u0003\u0003û\r\n\u0003¿%%\bù\n\u0003÷\u000fè&\u0001\u000b÷ÿ\u0005\u0011¶\u0004%7\u0000õ\u0011\u0000÷\u000fë*ù\nø\u0001\u0013ùþí\u0019\u0010ù\u0006\u0001Õ\u0010\u0002Å=\f\u0004ü\týÍ7\u0011ú\u0012\u0001þÿÎ=\n\n¿Cü\u0000\u0016\u0006\u0001÷\fü\r\n¾?\t\nõ\u0011\u0000÷\u000fÆP\u0004ò\u0014\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000Ç7\u0013\u0004\u0000\u0001\t\u0001\f¿\u00173\u0004à!\t\u0001Ý!\u0017ñÇ\u0011\u0010\u0002Å=\f\u0004ü\týÍ9\u0013\u000bû\bÿÃJù\t\u0001ÇI\u0006ñ\u0016üýÍ\u0017(\u0012Ô5\u0002Ú)ø\u0006ô%\u0002÷\u0000\u0010\u0000\týÁ!(\u0012Ô5\u0002Ú)ø\u0006ô%\u0002÷\u0000\u0010Ü-ù\u0013\u000bû\bõ\u0011\u0010\u0007\u0001\n\u0003ù\tûâ3÷\u0000\u0017ù\n\u0003".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 655);
        $$d = bArr;
        $$e = 2;
        $$a = new byte[]{91, 68, -61, -13, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13, 9, -18, 36, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, 7, -18, 43, -29, 4, -17, -2, 9, -18, 34, -25, -4, 17, -19, Ascii.SI, 1, Ascii.DC2, -15, -19, Ascii.VT, -5, 7, 2, -15, 36, -21, -13, Ascii.SI, -2, -9, -6, 34, -15, -19, Ascii.VT, -5, 7, 2, -15, 33, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, -10, Ascii.US, -20, -13, 8, Ascii.VT, Ascii.CR, -27, -49, -2, Ascii.VT, 3, -3, 6, -6, 8, -11, Ascii.EM, -33, 19, -2, -8, 37, -44, 17, -12, 8, -14};
        $$b = 153;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        ArtificialStackFrames = new char[]{39059, 44389, 39064, 44398, 44390, 44341, 39067, 44340, 44343, 44355, 44337, 44395, 44336, 44345, 44338, 44392, 44391, 44334, 44370, 44385, 44353, 44386, 44339, 39069, 44397, 39058, 44371, 44400, 44387, 44393, 39056, 44404, 39071, 44403, 44396, 44342, 39068, 44409, 39065, 44399, 44394, 44405, 44360, 44344, 44402, 44372, 44406, 44388, 39070};
        coroutineCreation = (char) 39069;
    }
}
