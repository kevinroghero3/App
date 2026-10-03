package com.salesforce.marketingcloud;

import android.app.IntentService;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.PowerManager;
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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.zza;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.notifications.NotificationManager;
import com.transistorsoft.locationmanager.location.TSLocationManager;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import o.ArtificialStackFrames;
import o.onPostMessage;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes3.dex */
public class NotificationOpenedService extends IntentService {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    private static char[] IPostMessageService;
    private static final String a;
    private static int artificialFrame;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static final byte[] $$c = {85, -33, -39, -30};
    private static final int $$f = 57;
    private static int $10 = 0;
    private static int $11 = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(int r5, short r6, short r7) {
        /*
            int r7 = r7 * 2
            int r0 = r7 + 1
            byte[] r1 = com.salesforce.marketingcloud.NotificationOpenedService.$$c
            int r5 = r5 * 3
            int r5 = r5 + 65
            int r6 = r6 * 4
            int r6 = 3 - r6
            byte[] r0 = new byte[r0]
            r2 = 0
            if (r1 != 0) goto L17
            r4 = r5
            r5 = r7
            r3 = r2
            goto L29
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r5
            r0[r3] = r4
            if (r3 != r7) goto L23
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            return r5
        L23:
            int r6 = r6 + 1
            r4 = r1[r6]
            int r3 = r3 + 1
        L29:
            int r5 = r5 + r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.NotificationOpenedService.$$g(int, short, short):java.lang.String");
    }

    static {
        byte[] bArr = new byte[734];
        System.arraycopy("{\u0096Ë~þýîúþ7ÿ¿õô\tíþ\u0007ï8±þ?Öçþï\u000fìý\tÞ\u0006ò\u0000ëJÇß\u0003ï\tí\u0018íè\u0002ú½îü9Áòú\u0002õ\u00011Çí\u0004ìý\u0000ÿ0»\u0006ç\tí\u0003\u0002ï8Åîý÷÷>³û\u0005÷ýï\u0005þì?äÅ\u0005\u0007îþ\u0000\u001aÎý÷÷HúÙÇþ\tíþ\u0007ï\u0013Ô\u0005ô\u0006ýë\u0005\u0000\u0011åî\u0005øý+õ4·üö?¼÷\u0002ÿûøò7Åî÷\u00071µý\u00015åÄ\u0010ñý\u0000\u001bÇ\túûí\u0018Ü\u000bøò\u0000íîü9Âÿøøýíúþ7¶\u0007þøé@Äùéýøÿúû÷ø@åÅú)Õõý\u0005üéÿ÷\u001céøò\u0004ôüí)Îûú\u0003üé\u0005ôûDÚÙó\u0001ø\u0000ç\t\u0016Ö÷þøúøìú\féø\u0005ý÷\u0000ô\u0002ï Î\u000bî\u0002îü9Áòú\u0002õ\u00011Åîüúøû:Åîýú\u0001üé@Ûæë\u001dæð\u0000í#Õô\tíþ\u0007ï\u0019æëFÝÙéùü\u000bøé\u0017ìþð\u001aàæ.Ñôüóëú<ºùõ\u0005ýûú1Åî÷\u00071Ü×\u0002úüíÎ÷ýôû\u0005õ\u0003\u001bÙýç\búøõ\u0001\u0016Ñîü9Âÿøøýíúþ7¶\u0007þøé@³\u0006ö\u0006í\u0007ôüí>Ïä\u0002\u0000\rÙ\u0005ù\u000fÛúýBúÙÇþ\tíþ\u0007ï\u0013Ô\u0005ô\u0006ýë\u0005\u0000\u0011åî\u0005øý+îü9Âÿøøýíúþ7¿ö\u0006ôüï\u0001ó\u0005óýõ\u00031¸øý\u0005é\føíù?ãÑ\u0005î\u0005ùû\u001bÜøõý\u0014àæ&Ò\u0003ò\u0005óþ\u0001ç\"Øý\u0005é\føíîü9´ü\u000bíõ\u0004ðùÿ÷ùþ\u0003ì@¼÷\u0006üç\u0005ôûû\u0006í\u0007ôüí>¼÷\u0002úüí>ÔûúüÿÝï\t\u001eËú\u0005ñ\u0004ùíH»îü9Âÿøøýíúþ7¿ö\u0006ôüï\u0001ó\u0005óýõ\u00031Çíÿö\u0006ç\tû0Âÿøéÿ÷óEçÍÿö\u0006ç\tû\u0015Ö\u0006ôü\u0019ßøéÿ÷ó*Ö÷þBíîü9Áòú\u0002õ\u00011Çë\u00015×Ö\u0000õ\r\u000bØýõÿîü9Áòú\u0002õ\u00011Åîüúøû:Åîýú\u0001üé@âÑ÷õ\u0010é\bõõ\u0001\u0010Ö\nê\nîü9Áòú\u0002õ\u00011Åëó\u0003öÿ;´\u0005õý7Çöþ÷0çÖì(Þã'àæOí".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 734);
        $$d = bArr;
        $$e = 78;
        $$a = new byte[]{91, 80, 41, -1, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13, 2, -15, 33, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, -10, Ascii.US, -20, -13, 8, Ascii.VT, Ascii.CR, -27, -49, -2, Ascii.VT, 3, -3, 6, -6, 8, -11, Ascii.EM, -33, 19, -2, -8, 37, -44, 17, -12, 8, -14, 9, -18, 34, -25, -4, 17, -19, Ascii.SI, 1, Ascii.DC2, -15, -19, Ascii.VT, -5, 7, 2, -15, 36, -21, -13, Ascii.SI, -2, -9, -6, 34, -15, -19, Ascii.VT, -5, 7, 9, -18, 36, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, 7, -18, 43, -29, 4, -17, -2};
        $$b = 248;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        accessartificialFrame();
        a = g.a("NotificationOpenedService");
    }

    public NotificationOpenedService() {
        super(a);
    }

    private static void a(Context context, Bundle bundle) {
        context.sendBroadcast(new Intent(com.salesforce.marketingcloud.notifications.a.f77n).putExtras(bundle).setPackage(context.getPackageName()));
    }

    public static Intent b(@NonNull Context context, @NonNull Bundle bundle) {
        return new Intent(context, (Class<?>) NotificationOpenedService.class).setAction(NotificationManager.ACTION_NOTIFICATION_CLICKED).putExtras(bundle);
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
    private static void c(int r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r0 = 21 - r6
            int r8 = r8 + 4
            int r7 = r7 + 65
            byte[] r1 = com.salesforce.marketingcloud.NotificationOpenedService.$$a
            byte[] r0 = new byte[r0]
            int r6 = 20 - r6
            r2 = 0
            if (r1 != 0) goto L13
            r3 = r8
            r4 = r2
            r8 = r6
            goto L2a
        L13:
            r3 = r2
        L14:
            byte r4 = (byte) r7
            r0[r3] = r4
            if (r3 != r6) goto L21
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L21:
            int r3 = r3 + 1
            r4 = r1[r8]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r5
        L2a:
            int r7 = -r7
            int r7 = r7 + r8
            int r8 = r3 + 1
            r3 = r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.NotificationOpenedService.c(int, short, int, java.lang.Object[]):void");
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
    private static void e(int r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 + 4
            int r0 = 82 - r6
            int r7 = r7 + 36
            byte[] r1 = com.salesforce.marketingcloud.NotificationOpenedService.$$d
            byte[] r0 = new byte[r0]
            int r6 = 81 - r6
            r2 = 0
            if (r1 != 0) goto L13
            r3 = r8
            r4 = r2
            r8 = r6
            goto L2b
        L13:
            r3 = r2
        L14:
            int r8 = r8 + 1
            byte r4 = (byte) r7
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L25:
            r3 = r1[r8]
            r5 = r8
            r8 = r7
            r7 = r3
            r3 = r5
        L2b:
            int r7 = -r7
            int r8 = r8 + r7
            int r7 = r8 + (-6)
            r8 = r3
            r3 = r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.NotificationOpenedService.e(int, int, int, java.lang.Object[]):void");
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent == null || intent.getAction() == null) {
            return;
        }
        PowerManager.WakeLock wakeLockNewWakeLock = null;
        try {
            try {
                PowerManager powerManager = (PowerManager) getSystemService("power");
                String str = a;
                wakeLockNewWakeLock = powerManager.newWakeLock(1, str);
                wakeLockNewWakeLock.setReferenceCounted(false);
                wakeLockNewWakeLock.acquire(TimeUnit.SECONDS.toMillis(30L));
                if (!com.salesforce.marketingcloud.util.j.a(500L, 50L) || MarketingCloudSdk.getInstance() == null) {
                    g.e(str, "MarketingCloudSdk#init must be called in your application's onCreate", new Object[0]);
                } else if (NotificationManager.ACTION_NOTIFICATION_CLICKED.equals(intent.getAction())) {
                    a(getApplicationContext(), intent.getExtras());
                }
                if (!wakeLockNewWakeLock.isHeld()) {
                    return;
                }
            } catch (Exception e) {
                g.b(a, e, "Encountered exception while handling action: %s", intent.getAction());
                if (0 == 0 || !wakeLockNewWakeLock.isHeld()) {
                    return;
                }
            }
            try {
                wakeLockNewWakeLock.release();
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            if (0 != 0 && wakeLockNewWakeLock.isHeld()) {
                try {
                    wakeLockNewWakeLock.release();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    private static void d(byte[] bArr, int[] iArr, boolean z, Object[] objArr) throws Throwable {
        int i;
        int i2 = 2;
        int i3 = 2 % 2;
        onPostMessage onpostmessage = new onPostMessage();
        int i4 = 0;
        int i5 = iArr[0];
        int i6 = iArr[1];
        int i7 = iArr[2];
        int i8 = iArr[3];
        char[] cArr = IPostMessageService;
        float f = 0.0f;
        if (cArr != null) {
            int length = cArr.length;
            char[] cArr2 = new char[length];
            int i9 = 0;
            while (i9 < length) {
                int i10 = $11 + 99;
                $10 = i10 % 128;
                if (i10 % i2 != 0) {
                    try {
                        Object[] objArr2 = new Object[1];
                        objArr2[i4] = Integer.valueOf(cArr[i9]);
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1782207618);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) i4;
                            byte b2 = b;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - (AudioTrack.getMinVolume() > f ? 1 : (AudioTrack.getMinVolume() == f ? 0 : -1)), (char) (KeyEvent.getMaxKeyCode() >> 16), ((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.ESC, 178318710, false, $$g(b, b2, b2), new Class[]{Integer.TYPE});
                        }
                        cArr2[i9] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                        i9--;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } else {
                    Object[] objArr3 = {Integer.valueOf(cArr[i9])};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1782207618);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 0;
                        byte b4 = b3;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(11 - (ViewConfiguration.getScrollBarSize() >> 8), (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1), (ViewConfiguration.getJumpTapTimeout() >> 16) + 1562, 178318710, false, $$g(b3, b4, b4), new Class[]{Integer.TYPE});
                    }
                    cArr2[i9] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                    i9++;
                }
                i2 = 2;
                i4 = 0;
                f = 0.0f;
            }
            cArr = cArr2;
        }
        char[] cArr3 = new char[i6];
        System.arraycopy(cArr, i5, cArr3, 0, i6);
        if (bArr != null) {
            char[] cArr4 = new char[i6];
            onpostmessage.a = 0;
            char c = 0;
            while (onpostmessage.a < i6) {
                int i11 = $10 + 53;
                $11 = i11 % 128;
                int i12 = i11 % 2;
                if (bArr[onpostmessage.a] == 1) {
                    int i13 = $11 + 27;
                    $10 = i13 % 128;
                    int i14 = i13 % 2;
                    int i15 = onpostmessage.a;
                    Object[] objArr4 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1378437083);
                    if (objAccessartificialFrame3 == null) {
                        int iAxisFromString = 22 - MotionEvent.axisFromString("");
                        char touchSlop = (char) (ViewConfiguration.getTouchSlop() >> 8);
                        int packedPositionType = 2441 - ExpandableListView.getPackedPositionType(0L);
                        byte b5 = (byte) ($$f & 7);
                        byte b6 = (byte) (b5 - 1);
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iAxisFromString, touchSlop, packedPositionType, -850656813, false, $$g(b5, b6, b6), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr4[i15] = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).charValue();
                } else {
                    int i16 = onpostmessage.a;
                    Object[] objArr5 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-314759072);
                    if (objAccessartificialFrame4 == null) {
                        byte b7 = (byte) 0;
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(11 - Color.argb(0, 0, 0, 0), (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1), View.resolveSizeAndState(0, 0, 0) + 1562, 1918398056, false, $$g((byte) 19, b7, b7), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr4[i16] = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).charValue();
                }
                c = cArr4[onpostmessage.a];
                Object[] objArr6 = {onpostmessage, onpostmessage};
                Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(898481158);
                if (objAccessartificialFrame5 == null) {
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(21 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (29363 - ExpandableListView.getPackedPositionType(0L)), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + JfifUtil.MARKER_RST7, -1427572210, false, "F", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame5).invoke(null, objArr6);
            }
            cArr3 = cArr4;
        }
        if (i8 > 0) {
            char[] cArr5 = new char[i6];
            i = 0;
            System.arraycopy(cArr3, 0, cArr5, 0, i6);
            int i17 = i6 - i8;
            System.arraycopy(cArr5, 0, cArr3, i17, i8);
            System.arraycopy(cArr5, i8, cArr3, 0, i17);
        } else {
            i = 0;
        }
        if (z) {
            char[] cArr6 = new char[i6];
            onpostmessage.a = i;
            int i18 = $10 + 33;
            $11 = i18 % 128;
            int i19 = i18 % 2;
            while (onpostmessage.a < i6) {
                cArr6[onpostmessage.a] = cArr3[(i6 - onpostmessage.a) - 1];
                onpostmessage.a++;
            }
            cArr3 = cArr6;
        }
        if (i7 > 0) {
            int i20 = $11 + 23;
            $10 = i20 % 128;
            int i21 = i20 % 2;
            int i22 = 0;
            loop3: while (true) {
                onpostmessage.a = i22;
                while (true) {
                    if (onpostmessage.a >= i6) {
                        break loop3;
                    }
                    int i23 = $11 + 43;
                    $10 = i23 % 128;
                    if (i23 % 2 != 0) {
                        cArr3[onpostmessage.a] = (char) (cArr3[onpostmessage.a] >>> iArr[3]);
                        onpostmessage.a = onpostmessage.a;
                    }
                }
                cArr3[onpostmessage.a] = (char) (cArr3[onpostmessage.a] - iArr[2]);
                i22 = onpostmessage.a + 1;
            }
        }
        objArr[0] = new String(cArr3);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x015d  */
    /* JADX WARN: Code duplicated, block: B:16:0x01bb A[Catch: all -> 0x08fd, TryCatch #2 {all -> 0x08fd, blocks: (B:54:0x05e7, B:56:0x0607, B:57:0x0656, B:14:0x01a7, B:16:0x01bb, B:17:0x01eb), top: B:98:0x01a7 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0201  */
    /* JADX WARN: Code duplicated, block: B:25:0x028e  */
    /* JADX WARN: Code duplicated, block: B:53:0x059a  */
    /* JADX WARN: Code duplicated, block: B:56:0x0607 A[Catch: all -> 0x08fd, TryCatch #2 {all -> 0x08fd, blocks: (B:54:0x05e7, B:56:0x0607, B:57:0x0656, B:14:0x01a7, B:16:0x01bb, B:17:0x01eb), top: B:98:0x01a7 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0667  */
    /* JADX WARN: Code duplicated, block: B:65:0x06f9  */
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
        int i2 = artificialFrame + 29;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        int i3 = i2 % 2;
        super.attachBaseContext(context);
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame7 == null) {
            int iMyTid = 26 - (Process.myTid() >> 22);
            char longPressTimeout = (char) (ViewConfiguration.getLongPressTimeout() >> 16);
            int packedPositionGroup = ExpandableListView.getPackedPositionGroup(0L) + 1041;
            byte[] bArr = $$a;
            byte b = bArr[18];
            Object[] objArr2 = new Object[1];
            c(b, (byte) (b | 35), (byte) (bArr[5] - 1), objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iMyTid, longPressTimeout, packedPositionGroup, 2061780482, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            int i4 = artificialFrame + 25;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i4 % 128;
            int i5 = i4 % 2;
            long j2 = j + 4611686018427387780L;
            Object[] objArr3 = new Object[1];
            d(new byte[]{1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1}, new int[]{0, 22, 0, 0}, true, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            d(new byte[]{1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1}, new int[]{22, 15, 0, 0}, true, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame8 == null) {
                    int i6 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 25;
                    char cGreen = (char) Color.green(0);
                    int tapTimeout = 1041 - (ViewConfiguration.getTapTimeout() >> 16);
                    byte[] bArr2 = $$a;
                    byte b2 = bArr2[18];
                    Object[] objArr5 = new Object[1];
                    c(b2, (byte) (b2 | 35), bArr2[28], objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i6, cGreen, tapTimeout, 1145017376, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i7 = ((int[]) objArr6[3])[0];
                int i8 = ((int[]) objArr6[2])[0];
                String[] strArr = (String[]) objArr6[0];
                int i9 = ~((int) SystemClock.elapsedRealtime());
                int i10 = ((719376024 + (((~((-729904777) | i9)) | 651800969) * (-933))) + (((~(i9 | 651800969)) | (-802813834)) * 933)) - 1660454740;
                int i11 = (i10 << 13) ^ i10;
                int i12 = i11 ^ (i11 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i12 ^ (i12 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                d(new byte[]{0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1}, new int[]{37, 16, 61, 8}, false, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                d(new byte[]{0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}, new int[]{53, 16, 84, 8}, false, objArr8);
                int iIntValue = ((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue();
                try {
                    Object[] objArr9 = {1698455125};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 9, (char) (View.resolveSizeAndState(0, 0, 0) + 22251), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = zza.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr9), -965128185, false);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame2 == null) {
                        int i13 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 26;
                        char c = (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
                        int edgeSlop = 1041 - (ViewConfiguration.getEdgeSlop() >> 16);
                        byte[] bArr3 = $$a;
                        byte b3 = bArr3[18];
                        Object[] objArr10 = new Object[1];
                        c(b3, (byte) (b3 | 35), bArr3[28], objArr10);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i13, c, edgeSlop, 1145017376, false, (String) objArr10[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
                    try {
                        Object[] objArr11 = new Object[1];
                        d(new byte[]{1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1}, new int[]{0, 22, 0, 0}, true, objArr11);
                        Class<?> cls3 = Class.forName((String) objArr11[0]);
                        Object[] objArr12 = new Object[1];
                        d(new byte[]{1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1}, new int[]{22, 15, 0, 0}, true, objArr12);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr12[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame3 == null) {
                            int i14 = 27 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                            char c2 = (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                            int i15 = 1042 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                            byte[] bArr4 = $$a;
                            byte b4 = bArr4[18];
                            Object[] objArr13 = new Object[1];
                            c(b4, (byte) (b4 | 35), (byte) (bArr4[5] - 1), objArr13);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i14, c2, i15, 2061780482, false, (String) objArr13[0], null);
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
            d(new byte[]{0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1}, new int[]{37, 16, 61, 8}, false, objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            d(new byte[]{0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}, new int[]{53, 16, 84, 8}, false, objArr15);
            int iIntValue2 = ((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr16 = {1698455125};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 9, (char) (View.resolveSizeAndState(0, 0, 0) + 22251), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = zza.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr16), -965128185, false);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame2 == null) {
                int i16 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 26;
                char c3 = (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
                int edgeSlop2 = 1041 - (ViewConfiguration.getEdgeSlop() >> 16);
                byte[] bArr5 = $$a;
                byte b5 = bArr5[18];
                Object[] objArr17 = new Object[1];
                c(b5, (byte) (b5 | 35), bArr5[28], objArr17);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i16, c3, edgeSlop2, 1145017376, false, (String) objArr17[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr18 = new Object[1];
            d(new byte[]{1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1}, new int[]{0, 22, 0, 0}, true, objArr18);
            Class<?> cls5 = Class.forName((String) objArr18[0]);
            Object[] objArr19 = new Object[1];
            d(new byte[]{1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1}, new int[]{22, 15, 0, 0}, true, objArr19);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr19[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame3 == null) {
                int i17 = 27 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                char c4 = (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                int i18 = 1042 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                byte[] bArr6 = $$a;
                byte b6 = bArr6[18];
                Object[] objArr110 = new Object[1];
                c(b6, (byte) (b6 | 35), (byte) (bArr6[5] - 1), objArr110);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i17, c4, i18, 2061780482, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i19 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i20 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i20 == i19) {
            Object[] objArr20 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i21 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i22 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i23 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iIdentityHashCode = System.identityHashCode(this);
            int i24 = 960727958 + ((iIdentityHashCode | 606223893) * (-50));
            int i25 = ~((-536872450) | iIdentityHashCode);
            int i26 = ~iIdentityHashCode;
            int i27 = i21 + i24 + ((i25 | (~(1064992535 | i26))) * 50) + (((~(i26 | 606223893)) | (~(528120086 | i26)) | (-1064992536)) * 50);
            int i28 = (i27 << 13) ^ i27;
            int i29 = i28 ^ (i28 >>> 17);
            ((int[]) objArr20[1])[0] = i29 ^ (i29 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr3 != null) {
                int i30 = getARTIFICIAL_FRAME_PACKAGE_NAME + 69;
                artificialFrame = i30 % 128;
                if (i30 % 2 == 0) {
                    int i31 = 3 / 3;
                }
                for (String str : strArr3) {
                    arrayList.add(str);
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf(((long) (i19 ^ i20)) ^ (((long) (-7639268)) << 32)), Long.valueOf(-7639266)};
                byte[] bArr7 = $$d;
                Object[] objArr22 = new Object[1];
                e(bArr7[487], (byte) (-bArr7[149]), bArr7[10], objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                e(bArr7[732], bArr7[34], bArr7[626], objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i32 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i33 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i34 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
                int i35 = ~startElapsedRealtime;
                int i36 = (-1951111082) + (((~((-185789911) | i35)) | 152093952 | (~(107686103 | i35)) | (~((-73990146) | startElapsedRealtime))) * (-84));
                int i37 = (~(startElapsedRealtime | 107686103)) | 185789910;
                int i38 = ~(i35 | (-107686104));
                int i39 = i32 + i36 + ((i37 | i38) * (-84)) + ((73990145 | i38) * 84);
                int i40 = (i39 << 13) ^ i39;
                int i41 = i40 ^ (i40 >>> 17);
                ((int[]) objArr24[1])[0] = i41 ^ (i41 << 5);
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
            int scrollDefaultDelay = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 25;
            char c5 = (char) (30069 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
            int i42 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 815;
            byte[] bArr8 = $$a;
            byte b7 = bArr8[18];
            Object[] objArr25 = new Object[1];
            c(b7, (byte) (b7 | 35), (byte) (bArr8[5] - 1), objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(scrollDefaultDelay, c5, i42, 721586079, false, (String) objArr25[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j3 != -1) {
            long j4 = j3 + 1922;
            Object[] objArr26 = new Object[1];
            d(new byte[]{1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1}, new int[]{0, 22, 0, 0}, true, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            d(new byte[]{1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1}, new int[]{22, 15, 0, 0}, true, objArr27);
            if (j4 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame10 == null) {
                    int iResolveOpacity = 25 - Drawable.resolveOpacity(0, 0);
                    char cIndexOf = (char) (30067 - TextUtils.indexOf((CharSequence) "", '0'));
                    int packedPositionChild = 815 - ExpandableListView.getPackedPositionChild(0L);
                    byte[] bArr9 = $$a;
                    byte b8 = bArr9[18];
                    Object[] objArr28 = new Object[1];
                    c(b8, (byte) (b8 | 35), bArr9[28], objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iResolveOpacity, cIndexOf, packedPositionChild, 891606461, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i43 = ((int[]) objArr29[0])[0];
                int i44 = ((int[]) objArr29[1])[0];
                String[] strArr5 = (String[]) objArr29[2];
                int i45 = ~((~Process.myTid()) | (-599902009));
                int i46 = (((-802285375) | i45) * (-970)) + 627069787 + ((i45 | 202383366) * 970) + 427363905;
                int i47 = (i46 << 13) ^ i46;
                int i48 = i47 ^ (i47 >>> 17);
                ((int[]) objArr[3])[0] = i48 ^ (i48 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                d(new byte[]{0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1}, new int[]{37, 16, 61, 8}, false, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                d(new byte[]{0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}, new int[]{53, 16, 84, 8}, false, objArr31);
                Object[] objArr32 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue()), 0, 427363905};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame4 == null) {
                    int i49 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 24;
                    char cKeyCodeFromString = (char) (30068 - KeyEvent.keyCodeFromString(""));
                    int iIndexOf = 816 - TextUtils.indexOf("", "");
                    byte[] bArr10 = $$a;
                    byte b9 = bArr10[9];
                    byte b10 = bArr10[35];
                    Object[] objArr33 = new Object[1];
                    c(b9, b10, (byte) (b10 - 3), objArr33);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i49, cKeyCodeFromString, iIndexOf, -797394565, false, (String) objArr33[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                Object[] objArr34 = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr32);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame5 == null) {
                    int i50 = 26 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                    char cAxisFromString = (char) (MotionEvent.axisFromString("") + 30069);
                    int i51 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 816;
                    byte[] bArr11 = $$a;
                    byte b11 = bArr11[18];
                    Object[] objArr35 = new Object[1];
                    c(b11, (byte) (b11 | 35), bArr11[28], objArr35);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i50, cAxisFromString, i51, 891606461, false, (String) objArr35[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr34);
                try {
                    Object[] objArr36 = new Object[1];
                    d(new byte[]{1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1}, new int[]{0, 22, 0, 0}, true, objArr36);
                    Class<?> cls9 = Class.forName((String) objArr36[0]);
                    Object[] objArr37 = new Object[1];
                    d(new byte[]{1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1}, new int[]{22, 15, 0, 0}, true, objArr37);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr37[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame6 == null) {
                        int maxKeyCode = 25 - (KeyEvent.getMaxKeyCode() >> 16);
                        char packedPositionChild2 = (char) (30067 - ExpandableListView.getPackedPositionChild(0L));
                        int offsetBefore = TextUtils.getOffsetBefore("", 0) + 816;
                        byte[] bArr12 = $$a;
                        byte b12 = bArr12[18];
                        Object[] objArr38 = new Object[1];
                        c(b12, (byte) (b12 | 35), (byte) (bArr12[5] - 1), objArr38);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(maxKeyCode, packedPositionChild2, offsetBefore, 721586079, false, (String) objArr38[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                    objArr = objArr34;
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr39 = new Object[1];
            d(new byte[]{0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1}, new int[]{37, 16, 61, 8}, false, objArr39);
            Class<?> cls10 = Class.forName((String) objArr39[0]);
            Object[] objArr310 = new Object[1];
            d(new byte[]{0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}, new int[]{53, 16, 84, 8}, false, objArr310);
            Object[] objArr311 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr310[0], Object.class).invoke(null, this)).intValue()), 0, 427363905};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame4 == null) {
                int i410 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 24;
                char cKeyCodeFromString2 = (char) (30068 - KeyEvent.keyCodeFromString(""));
                int iIndexOf2 = 816 - TextUtils.indexOf("", "");
                byte[] bArr13 = $$a;
                byte b13 = bArr13[9];
                byte b14 = bArr13[35];
                Object[] objArr312 = new Object[1];
                c(b13, b14, (byte) (b14 - 3), objArr312);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i410, cKeyCodeFromString2, iIndexOf2, -797394565, false, (String) objArr312[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            Object[] objArr313 = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr311);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame5 == null) {
                int i52 = 26 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                char cAxisFromString2 = (char) (MotionEvent.axisFromString("") + 30069);
                int i53 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 816;
                byte[] bArr14 = $$a;
                byte b15 = bArr14[18];
                Object[] objArr314 = new Object[1];
                c(b15, (byte) (b15 | 35), bArr14[28], objArr314);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i52, cAxisFromString2, i53, 891606461, false, (String) objArr314[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr313);
            Object[] objArr315 = new Object[1];
            d(new byte[]{1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1}, new int[]{0, 22, 0, 0}, true, objArr315);
            Class<?> cls11 = Class.forName((String) objArr315[0]);
            Object[] objArr316 = new Object[1];
            d(new byte[]{1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1}, new int[]{22, 15, 0, 0}, true, objArr316);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr316[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame6 == null) {
                int maxKeyCode2 = 25 - (KeyEvent.getMaxKeyCode() >> 16);
                char packedPositionChild3 = (char) (30067 - ExpandableListView.getPackedPositionChild(0L));
                int offsetBefore2 = TextUtils.getOffsetBefore("", 0) + 816;
                byte[] bArr15 = $$a;
                byte b16 = bArr15[18];
                Object[] objArr317 = new Object[1];
                c(b16, (byte) (b16 | 35), (byte) (bArr15[5] - 1), objArr317);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(maxKeyCode2, packedPositionChild3, offsetBefore2, 721586079, false, (String) objArr317[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
            objArr = objArr313;
        }
        int i54 = ((int[]) objArr[1])[0];
        int i55 = ((int[]) objArr[0])[0];
        if (i55 == i54) {
            Object[] objArr40 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i56 = ((int[]) objArr[3])[0];
            int i57 = ((int[]) objArr[0])[0];
            int i58 = ((int[]) objArr[1])[0];
            String[] strArr6 = (String[]) objArr[2];
            int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 170426297;
            int i59 = ~length;
            int i60 = ~(324325379 | i59);
            int i61 = i56 + 1580103749 + (((-399831352) | i60) * (-712)) + (((~(length | (-75505973))) | (~(i59 | 399831351))) * (-712)) + ((126153013 | i60) * 712);
            int i62 = (i61 << 13) ^ i61;
            int i63 = i62 ^ (i62 >>> 17);
            ((int[]) objArr40[3])[0] = i63 ^ (i63 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArr[2];
        if (strArr7 != null) {
            for (String str2 : strArr7) {
                arrayList2.add(str2);
            }
        }
        long j5 = (((long) 1945393601) << 32) ^ ((long) (i54 ^ i55));
        long j6 = 1945393600;
        int i64 = getARTIFICIAL_FRAME_PACKAGE_NAME + 117;
        artificialFrame = i64 % 128;
        int i65 = i64 % 2;
        Object[] objArr41 = {Long.valueOf(j5), Long.valueOf(j6)};
        byte[] bArr16 = $$d;
        Object[] objArr42 = new Object[1];
        e(bArr16[34], bArr16[22], (short) (-bArr16[115]), objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        Object[] objArr43 = new Object[1];
        e(bArr16[732], bArr16[34], bArr16[626], objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
        int i66 = ((int[]) objArr[3])[0];
        int i67 = ((int[]) objArr[0])[0];
        int i68 = ((int[]) objArr[1])[0];
        String[] strArr8 = (String[]) objArr[2];
        int i69 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 506409037;
        int i70 = i66 + ((((~((-318767233) | i69)) | (-523263955)) * TypedValues.PositionType.TYPE_TRANSITION_EASING) - 428184516) + ((~((~i69) | (-318767233))) * TypedValues.PositionType.TYPE_TRANSITION_EASING);
        int i71 = (i70 << 13) ^ i70;
        int i72 = i71 ^ (i71 >>> 17);
        ((int[]) objArr44[3])[0] = i72 ^ (i72 << 5);
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0a6a  */
    /* JADX WARN: Code duplicated, block: B:108:0x0ae7  */
    /* JADX WARN: Code duplicated, block: B:113:0x0b55  */
    /* JADX WARN: Code duplicated, block: B:13:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:168:0x127f  */
    /* JADX WARN: Code duplicated, block: B:16:0x01e7 A[Catch: all -> 0x231b, TryCatch #7 {all -> 0x231b, blocks: (B:310:0x205e, B:312:0x2080, B:313:0x20ca, B:194:0x14ad, B:196:0x14ba, B:197:0x14e9, B:199:0x14f3, B:201:0x1500, B:202:0x1531, B:134:0x0e44, B:136:0x0e4a, B:137:0x0e72, B:139:0x0e9c, B:140:0x0f26, B:14:0x01d3, B:16:0x01e7, B:17:0x0216), top: B:376:0x01d3 }] */
    /* JADX WARN: Code duplicated, block: B:170:0x1286  */
    /* JADX WARN: Code duplicated, block: B:172:0x12ca  */
    /* JADX WARN: Code duplicated, block: B:178:0x12da  */
    /* JADX WARN: Code duplicated, block: B:183:0x1375  */
    /* JADX WARN: Code duplicated, block: B:188:0x13db  */
    /* JADX WARN: Code duplicated, block: B:20:0x022c  */
    /* JADX WARN: Code duplicated, block: B:25:0x0292  */
    /* JADX WARN: Code duplicated, block: B:272:0x1c4b  */
    /* JADX WARN: Code duplicated, block: B:275:0x1c55  */
    @Override // android.app.IntentService, android.app.Service
    public void onCreate() throws Throwable {
        Object objAccessartificialFrame;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        Object[] objArr;
        Object[] objArr2;
        Object objAccessartificialFrame4;
        Object objAccessartificialFrame5;
        Object[] objArr3;
        Context baseContext;
        Object[] objArr4;
        Object objAccessartificialFrame6;
        Object objAccessartificialFrame7;
        Object[] objArr5;
        Object[] objArr6;
        Object[] objArr7;
        char c = 2;
        int i = 2 % 2;
        Object[] objArr8 = new Object[1];
        d(new byte[]{1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1}, new int[]{0, 22, 0, 0}, true, objArr8);
        String str = (String) objArr8[0];
        Object[] objArr9 = new Object[1];
        d(new byte[]{1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1}, new int[]{22, 15, 0, 0}, true, objArr9);
        String str2 = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        d(new byte[]{0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1}, new int[]{37, 16, 61, 8}, false, objArr10);
        String str3 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        d(new byte[]{0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}, new int[]{53, 16, 84, 8}, false, objArr11);
        String str4 = (String) objArr11[0];
        Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame8 == null) {
            int jumpTapTimeout = (ViewConfiguration.getJumpTapTimeout() >> 16) + 26;
            char cNormalizeMetaState = (char) KeyEvent.normalizeMetaState(0);
            int keyRepeatTimeout = 1041 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
            byte[] bArr = $$a;
            byte b = bArr[18];
            Object[] objArr12 = new Object[1];
            c(b, (byte) (b | 35), (byte) (bArr[5] - 1), objArr12);
            objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout, cNormalizeMetaState, keyRepeatTimeout, 2061780482, false, (String) objArr12[0], null);
        }
        long j = ((Field) objAccessartificialFrame8).getLong(null);
        if (j != -1) {
            int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 79;
            artificialFrame = i2 % 128;
            int i3 = i2 % 2;
            if (j + 4611686018427387937L >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame9 == null) {
                    int i4 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 25;
                    char cAxisFromString = (char) (MotionEvent.axisFromString("") + 1);
                    int modifierMetaStateMask = 1040 - ((byte) KeyEvent.getModifierMetaStateMask());
                    byte[] bArr2 = $$a;
                    byte b2 = bArr2[18];
                    Object[] objArr13 = new Object[1];
                    c(b2, (byte) (b2 | 35), bArr2[28], objArr13);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(i4, cAxisFromString, modifierMetaStateMask, 1145017376, false, (String) objArr13[0], null);
                }
                Object[] objArr14 = (Object[]) ((Field) objAccessartificialFrame9).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i5 = ((int[]) objArr14[3])[0];
                int i6 = ((int[]) objArr14[2])[0];
                String[] strArr = (String[]) objArr14[0];
                int i7 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().navigationHidden;
                int i8 = 992171518 + (((~((-580736576) | i7)) | 502632768) * (-318));
                int i9 = ~(502632768 | i7);
                int i10 = ~i7;
                int i11 = ((i8 + ((i9 | (~((-492863809) | i10))) * TypedValues.AttributesType.TYPE_PIVOT_TARGET)) + (((~(i7 | (-492863809))) | (~(1073600383 | i10))) * TypedValues.AttributesType.TYPE_PIVOT_TARGET)) - 687548105;
                int i12 = (i11 << 13) ^ i11;
                int i13 = i12 ^ (i12 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i13 ^ (i13 << 5);
            } else {
                int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                try {
                    Object[] objArr15 = {1084083268};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(9 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (Gravity.getAbsoluteGravity(0, 0) + 22251), 1033 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = DynamiteModule.LoadingException.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr15), -687548105, false);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame2 == null) {
                        int iRgb = Color.rgb(0, 0, 0) + 16777242;
                        char absoluteGravity = (char) Gravity.getAbsoluteGravity(0, 0);
                        int edgeSlop = (ViewConfiguration.getEdgeSlop() >> 16) + 1041;
                        byte[] bArr3 = $$a;
                        byte b3 = bArr3[18];
                        Object[] objArr16 = new Object[1];
                        c(b3, (byte) (b3 | 35), bArr3[28], objArr16);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iRgb, absoluteGravity, edgeSlop, 1145017376, false, (String) objArr16[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
                    try {
                        Long lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame3 == null) {
                            int i14 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 27;
                            char cIndexOf = (char) (TextUtils.indexOf((CharSequence) "", '0') + 1);
                            int scrollDefaultDelay = 1041 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                            byte[] bArr4 = $$a;
                            byte b4 = bArr4[18];
                            Object[] objArr17 = new Object[1];
                            c(b4, (byte) (b4 | 35), (byte) (bArr4[5] - 1), objArr17);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i14, cIndexOf, scrollDefaultDelay, 2061780482, false, (String) objArr17[0], null);
                        }
                        ((Field) objAccessartificialFrame3).set(null, lValueOf);
                        c = 2;
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
            int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr18 = {1084083268};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(9 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (Gravity.getAbsoluteGravity(0, 0) + 22251), 1033 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = DynamiteModule.LoadingException.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr18), -687548105, false);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame2 == null) {
                int iRgb2 = Color.rgb(0, 0, 0) + 16777242;
                char absoluteGravity2 = (char) Gravity.getAbsoluteGravity(0, 0);
                int edgeSlop2 = (ViewConfiguration.getEdgeSlop() >> 16) + 1041;
                byte[] bArr5 = $$a;
                byte b5 = bArr5[18];
                Object[] objArr19 = new Object[1];
                c(b5, (byte) (b5 | 35), bArr5[28], objArr19);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iRgb2, absoluteGravity2, edgeSlop2, 1145017376, false, (String) objArr19[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
            Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame3 == null) {
                int i15 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 27;
                char cIndexOf2 = (char) (TextUtils.indexOf((CharSequence) "", '0') + 1);
                int scrollDefaultDelay2 = 1041 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                byte[] bArr6 = $$a;
                byte b6 = bArr6[18];
                Object[] objArr110 = new Object[1];
                c(b6, (byte) (b6 | 35), (byte) (bArr6[5] - 1), objArr110);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i15, cIndexOf2, scrollDefaultDelay2, 2061780482, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
            c = 2;
        }
        int i16 = ((int[]) objArrAccessartificialFrame$78cbbd35[c])[0];
        int i17 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i17 == i16) {
            Object[] objArr20 = new Object[4];
            objArr20[1] = new int[1];
            objArr20[c] = new int[]{i};
            objArr20[3] = new int[]{i};
            int i18 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i19 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i20 = ((int[]) objArrAccessartificialFrame$78cbbd35[c])[0];
            objArr20[0] = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iIdentityHashCode = System.identityHashCode(this);
            int i21 = ~iIdentityHashCode;
            int i22 = i18 + 9329866 + (((~((-981002332) | i21)) | 975218778) * (-108)) + (((~(i21 | 1059106138)) | (~((-1059106139) | iIdentityHashCode)) | (-1064889692)) * 54) + ((iIdentityHashCode | (-1064889692)) * 54);
            int i23 = (i22 << 13) ^ i22;
            int i24 = i23 ^ (i23 >>> 17);
            ((int[]) objArr20[1])[0] = i24 ^ (i24 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr2 != null) {
                for (String str5 : strArr2) {
                    arrayList.add(str5);
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf(((long) (i16 ^ i17)) ^ (((long) 2012427778) << 32)), Long.valueOf(2012427776)};
                byte[] bArr7 = $$d;
                Object[] objArr22 = new Object[1];
                e(bArr7[729], bArr7[22], (short) (bArr7[3] - 1), objArr22);
                Class<?> cls = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                e(bArr7[732], bArr7[34], bArr7[626], objArr23);
                cls.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i25 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i26 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i27 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int iNextInt = new Random().nextInt();
                int i28 = ~iNextInt;
                int i29 = i25 + (-1493751480) + (((~(i28 | (-816784318))) | 894888124) * (-1042)) + (((-816784318) | iNextInt) * 521) + (((~(iNextInt | (-894888125))) | 89180160 | (~(i28 | (-11076354)))) * 521);
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
        Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame10 == null) {
            int packedPositionChild = 20 - ExpandableListView.getPackedPositionChild(0L);
            char keyRepeatTimeout2 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
            int i32 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 465;
            byte[] bArr8 = $$a;
            byte b7 = bArr8[18];
            Object[] objArr25 = new Object[1];
            c(b7, (byte) (b7 | 35), (byte) (bArr8[5] - 1), objArr25);
            objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(packedPositionChild, keyRepeatTimeout2, i32, -785931255, false, (String) objArr25[0], null);
        }
        long j2 = ((Field) objAccessartificialFrame10).getLong(null);
        if (j2 == -1 || j2 + 1898 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext2 = getBaseContext();
            if (baseContext2 == null) {
                Object[] objArr26 = new Object[1];
                d(new byte[]{1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0}, new int[]{69, 26, 0, 1}, true, objArr26);
                Class<?> cls2 = Class.forName((String) objArr26[0]);
                Object[] objArr27 = new Object[1];
                d(new byte[]{1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1}, new int[]{95, 18, 0, 17}, false, objArr27);
                baseContext2 = (Context) cls2.getMethod((String) objArr27[0], new Class[0]).invoke(null, null);
            }
            if (baseContext2 != null) {
                baseContext2 = ((baseContext2 instanceof ContextWrapper) && ((ContextWrapper) baseContext2).getBaseContext() == null) ? null : baseContext2.getApplicationContext();
            }
            int iIntValue3 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr28 = new Object[1];
            d(new byte[]{1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0}, new int[]{113, 64, 0, 43}, false, objArr28);
            String str6 = (String) objArr28[0];
            Object[] objArr29 = new Object[1];
            d(new byte[]{1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0}, new int[]{177, 64, 198, 0}, true, objArr29);
            try {
                Object[] objArr30 = {baseContext2, new String[]{str6, (String) objArr29[0]}, Integer.valueOf(iIntValue3), 1, 1158242497};
                byte[] bArr9 = $$d;
                Object[] objArr31 = new Object[1];
                e(bArr9[14], bArr9[22], (short) 167, objArr31);
                Class<?> cls3 = Class.forName((String) objArr31[0]);
                byte b8 = (byte) (bArr9[81] - 1);
                Object[] objArr32 = new Object[1];
                e(b8, b8, (short) ($$e | 161), objArr32);
                objArr = (Object[]) cls3.getMethod((String) objArr32[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr30);
                int i33 = ((int[]) objArr[0])[0];
                int i34 = ((int[]) objArr[3])[0];
                if (baseContext2 != null) {
                    int i35 = artificialFrame + 37;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i35 % 128;
                    int i36 = i35 % 2;
                    Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(1142731807);
                    if (objAccessartificialFrame11 == null) {
                        int scrollBarSize = 21 - (ViewConfiguration.getScrollBarSize() >> 8);
                        char c2 = (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                        int i37 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 465;
                        byte[] bArr10 = $$a;
                        byte b9 = bArr10[18];
                        Object[] objArr33 = new Object[1];
                        c(b9, (byte) (b9 | 35), bArr10[28], objArr33);
                        objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(scrollBarSize, c2, i37, -612765161, false, (String) objArr33[0], null);
                    }
                    ((Field) objAccessartificialFrame11).set(null, objArr);
                    try {
                        Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(1313006081);
                        if (objAccessartificialFrame12 == null) {
                            int offsetAfter = 21 - TextUtils.getOffsetAfter("", 0);
                            char c3 = (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
                            int bitsPerPixel = 464 - ImageFormat.getBitsPerPixel(0);
                            byte[] bArr11 = $$a;
                            byte b10 = bArr11[18];
                            Object[] objArr34 = new Object[1];
                            c(b10, (byte) (b10 | 35), (byte) (bArr11[5] - 1), objArr34);
                            objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(offsetAfter, c3, bitsPerPixel, -785931255, false, (String) objArr34[0], null);
                        }
                        ((Field) objAccessartificialFrame12).set(null, lValueOf3);
                        int i38 = artificialFrame + 37;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i38 % 128;
                        int i39 = i38 % 2;
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
            Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(1142731807);
            if (objAccessartificialFrame13 == null) {
                int absoluteGravity3 = Gravity.getAbsoluteGravity(0, 0) + 21;
                char cIndexOf3 = (char) (TextUtils.indexOf((CharSequence) "", '0') + 1);
                int pressedStateDuration = 465 - (ViewConfiguration.getPressedStateDuration() >> 16);
                byte[] bArr12 = $$a;
                byte b11 = bArr12[18];
                Object[] objArr35 = new Object[1];
                c(b11, (byte) (b11 | 35), bArr12[28], objArr35);
                objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(absoluteGravity3, cIndexOf3, pressedStateDuration, -612765161, false, (String) objArr35[0], null);
            }
            Object[] objArr36 = (Object[]) ((Field) objAccessartificialFrame13).get(null);
            objArr = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
            int i40 = ((int[]) objArr36[3])[0];
            int i41 = ((int[]) objArr36[0])[0];
            String[] strArr4 = (String[]) objArr36[1];
            int i42 = Settings.System.getInt(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getContentResolver(), "screen_brightness", -1);
            int i43 = ~i42;
            int i44 = 1744607828 + (((~((-54899194) | i43)) | (~((-105450533) | i43))) * (-867)) + (((~((-105450533) | i42)) | 37814304 | (~((-54899194) | i42))) * (-1734)) + (((~(i42 | (-17084890))) | (~((-37814305) | i43)) | (~((-67636229) | i42))) * 867) + 1158242497;
            int i45 = (i44 << 13) ^ i44;
            int i46 = i45 ^ (i45 >>> 17);
            ((int[]) objArr[2])[0] = i46 ^ (i46 << 5);
        }
        int i47 = ((int[]) objArr[0])[0];
        int i48 = ((int[]) objArr[3])[0];
        if (i48 == i47) {
            Object[] objArr37 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i49 = ((int[]) objArr[2])[0];
            int i50 = ((int[]) objArr[3])[0];
            int i51 = ((int[]) objArr[0])[0];
            String[] strArr5 = (String[]) objArr[1];
            int iMyUid = Process.myUid();
            int i52 = i49 + (-913990612) + (((~((~iMyUid) | 603457656)) | 402735618) * 529) + (((~(iMyUid | 603457656)) | 443107930) * 529);
            int i53 = (i52 << 13) ^ i52;
            int i54 = i53 ^ (i53 >>> 17);
            ((int[]) objArr37[2])[0] = i54 ^ (i54 << 5);
        } else {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr6 = (String[]) objArr[1];
            if (strArr6 != null) {
                for (String str7 : strArr6) {
                    arrayList2.add(str7);
                }
            }
            Object[] objArr38 = {Long.valueOf(((long) (i47 ^ i48)) ^ (((long) (-536433399)) << 32)), Long.valueOf(-536433335)};
            byte[] bArr13 = $$d;
            Object[] objArr39 = new Object[1];
            e(bArr13[155], bArr13[22], (short) 259, objArr39);
            Class<?> cls4 = Class.forName((String) objArr39[0]);
            Object[] objArr40 = new Object[1];
            e(bArr13[732], bArr13[34], bArr13[626], objArr40);
            cls4.getMethod((String) objArr40[0], Long.TYPE, Long.TYPE).invoke(null, objArr38);
            Object[] objArr41 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i55 = ((int[]) objArr[2])[0];
            int i56 = ((int[]) objArr[3])[0];
            int i57 = ((int[]) objArr[0])[0];
            String[] strArr7 = (String[]) objArr[1];
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i58 = ~iIdentityHashCode2;
            int i59 = i55 + 133715749 + (((~((-211675182) | i58)) | 67936265) * SyslogConstants.LOG_LOCAL7) + ((iIdentityHashCode2 | (-515763824)) * (-184)) + ((~((-372024908) | i58)) * SyslogConstants.LOG_LOCAL7);
            int i60 = (i59 << 13) ^ i59;
            int i61 = i60 ^ (i60 >>> 17);
            ((int[]) objArr41[2])[0] = i61 ^ (i61 << 5);
        }
        Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame14 == null) {
            int i62 = 31 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
            char c4 = (char) (49363 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0) + 684;
            byte[] bArr14 = $$a;
            Object[] objArr42 = new Object[1];
            c(bArr14[28], (byte) (bArr14[65] + 1), (byte) (-bArr14[20]), objArr42);
            objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(i62, c4, iMakeMeasureSpec, -1583976536, false, (String) objArr42[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame14).getLong(null);
        if (j3 != -1) {
            int i63 = getARTIFICIAL_FRAME_PACKAGE_NAME + 125;
            artificialFrame = i63 % 128;
            if (i63 % 2 != 0 ? j3 + 1873 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue() : j3 % 1873 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[1]).invoke(null, new Object[0])).longValue()) {
                Object[] objArr43 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 156236386};
                byte[] bArr15 = $$d;
                byte b12 = bArr15[712];
                Object[] objArr44 = new Object[1];
                e(b12, (byte) (b12 + 2), (short) 324, objArr44);
                Class<?> cls5 = Class.forName((String) objArr44[0]);
                byte b13 = bArr15[81];
                Object[] objArr45 = new Object[1];
                e(b13, (byte) (b13 >>> 1), (short) 346, objArr45);
                objArr2 = (Object[]) cls5.getMethod((String) objArr45[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr43);
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame4 == null) {
                    int keyRepeatDelay = 30 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                    char mode = (char) (49362 - View.MeasureSpec.getMode(0));
                    int keyRepeatDelay2 = 684 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                    byte[] bArr16 = $$a;
                    Object[] objArr46 = new Object[1];
                    c(bArr16[18], (byte) ($$b & 46), (byte) (-bArr16[15]), objArr46);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay, mode, keyRepeatDelay2, -1456483158, false, (String) objArr46[0], null);
                }
                ((Field) objAccessartificialFrame4).set(null, objArr2);
                try {
                    Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1056123296);
                    if (objAccessartificialFrame5 == null) {
                        int iIndexOf = TextUtils.indexOf((CharSequence) "", '0', 0) + 31;
                        char cIndexOf4 = (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 49363);
                        int i64 = 685 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                        byte[] bArr17 = $$a;
                        Object[] objArr47 = new Object[1];
                        c(bArr17[28], (byte) (bArr17[65] + 1), (byte) (-bArr17[20]), objArr47);
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iIndexOf, cIndexOf4, i64, -1583976536, false, (String) objArr47[0], null);
                    }
                    ((Field) objAccessartificialFrame5).set(null, lValueOf4);
                } catch (Exception unused3) {
                    throw new RuntimeException();
                }
            } else {
                Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame15 == null) {
                    int mirror = 'N' - AndroidCharacter.getMirror('0');
                    char c5 = (char) (49361 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                    int iRgb3 = Color.rgb(0, 0, 0) + 16777900;
                    byte[] bArr18 = $$a;
                    Object[] objArr48 = new Object[1];
                    c(bArr18[18], (byte) ($$b & 46), (byte) (-bArr18[15]), objArr48);
                    objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(mirror, c5, iRgb3, -1456483158, false, (String) objArr48[0], null);
                }
                Object[] objArr49 = (Object[]) ((Field) objAccessartificialFrame15).get(null);
                objArr2 = new Object[]{new int[]{((int[]) objArr49[0])[0]}, new int[]{((int[]) objArr49[1])[0]}, new int[1], (String) objArr49[3]};
                int iIdentityHashCode3 = System.identityHashCode(this);
                int i65 = ~iIdentityHashCode3;
                int i66 = 1879443710 + (((~((-173326721) | i65)) | (~((-564858883) | iIdentityHashCode3)) | (~((-67111453) | iIdentityHashCode3))) * 765) + (((~((-738185603) | i65)) | 173326720) * 1530) + (((~(iIdentityHashCode3 | (-738185603))) | (~(i65 | (-67111453)))) * 765) + 156236386;
                int i67 = (i66 << 13) ^ i66;
                int i68 = i67 ^ (i67 >>> 17);
                ((int[]) objArr2[2])[0] = i68 ^ (i68 << 5);
            }
        } else {
            Object[] objArr410 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 156236386};
            byte[] bArr19 = $$d;
            byte b14 = bArr19[712];
            Object[] objArr411 = new Object[1];
            e(b14, (byte) (b14 + 2), (short) 324, objArr411);
            Class<?> cls6 = Class.forName((String) objArr411[0]);
            byte b15 = bArr19[81];
            Object[] objArr412 = new Object[1];
            e(b15, (byte) (b15 >>> 1), (short) 346, objArr412);
            objArr2 = (Object[]) cls6.getMethod((String) objArr412[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr410);
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame4 == null) {
                int keyRepeatDelay3 = 30 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                char mode2 = (char) (49362 - View.MeasureSpec.getMode(0));
                int keyRepeatDelay4 = 684 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                byte[] bArr110 = $$a;
                Object[] objArr413 = new Object[1];
                c(bArr110[18], (byte) ($$b & 46), (byte) (-bArr110[15]), objArr413);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay3, mode2, keyRepeatDelay4, -1456483158, false, (String) objArr413[0], null);
            }
            ((Field) objAccessartificialFrame4).set(null, objArr2);
            Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1056123296);
            if (objAccessartificialFrame5 == null) {
                int iIndexOf2 = TextUtils.indexOf((CharSequence) "", '0', 0) + 31;
                char cIndexOf5 = (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 49363);
                int i69 = 685 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                byte[] bArr111 = $$a;
                Object[] objArr414 = new Object[1];
                c(bArr111[28], (byte) (bArr111[65] + 1), (byte) (-bArr111[20]), objArr414);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iIndexOf2, cIndexOf5, i69, -1583976536, false, (String) objArr414[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, lValueOf5);
        }
        int i70 = ((int[]) objArr2[1])[0];
        int i71 = ((int[]) objArr2[0])[0];
        if (i71 == i70) {
            int i72 = artificialFrame + 125;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i72 % 128;
            int i73 = i72 % 2;
            int i74 = ((int[]) objArr2[2])[0];
            Object[] objArr50 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int iMyTid = Process.myTid();
            int i75 = ~iMyTid;
            int i76 = i74 + ((((~(i75 | 51066855)) | ((~((-927556920) | i75)) | (~((-51066856) | iMyTid)))) * 959) - 619547708) + (((~(iMyTid | 51066855)) | (~(i75 | (-51066856))) | (~((-927556920) | iMyTid))) * 959);
            int i77 = (i76 << 13) ^ i76;
            int i78 = i77 ^ (i77 >>> 17);
            ((int[]) objArr50[2])[0] = i78 ^ (i78 << 5);
        } else {
            new ArrayList().add((String) objArr2[3]);
            Object[] objArr51 = {Long.valueOf(((long) (i70 ^ i71)) ^ (((long) (-216403904)) << 32)), Long.valueOf(-216403888)};
            byte[] bArr20 = $$d;
            Object[] objArr52 = new Object[1];
            e(bArr20[27], bArr20[22], (short) 365, objArr52);
            Class<?> cls7 = Class.forName((String) objArr52[0]);
            Object[] objArr53 = new Object[1];
            e(bArr20[732], bArr20[34], bArr20[626], objArr53);
            cls7.getMethod((String) objArr53[0], Long.TYPE, Long.TYPE).invoke(null, objArr51);
            int i79 = ((int[]) objArr2[2])[0];
            Object[] objArr54 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int i80 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().orientation;
            int i81 = i79 + 1432252094 + (((~((-44048705) | (~i80))) | (~(934575070 | i80))) * (-272)) + (((~((-379613517) | i80)) | 335564812) * (-272)) + (((~(i80 | 379613516)) | 599010258) * 272);
            int i82 = (i81 << 13) ^ i81;
            int i83 = i82 ^ (i82 >>> 17);
            ((int[]) objArr54[2])[0] = i83 ^ (i83 << 5);
        }
        Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame16 == null) {
            int offsetBefore = 36 - TextUtils.getOffsetBefore("", 0);
            char cRed = (char) Color.red(0);
            int iGreen = Color.green(0) + 540;
            byte[] bArr21 = $$a;
            byte b16 = bArr21[18];
            Object[] objArr55 = new Object[1];
            c(b16, (byte) (b16 | 35), (byte) (bArr21[5] - 1), objArr55);
            objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(offsetBefore, cRed, iGreen, 624296913, false, (String) objArr55[0], null);
        }
        long j4 = ((Field) objAccessartificialFrame16).getLong(null);
        if (j4 == -1 || j4 + 1966 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-1717965552);
            if (objAccessartificialFrame17 == null) {
                objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(View.MeasureSpec.makeMeasureSpec(0, 0) + 20, (char) (39516 - Color.alpha(0)), Gravity.getAbsoluteGravity(0, 0) + 982, 117222168, false, null, new Class[0]);
            }
            Object[] objArr56 = {null, ((Constructor) objAccessartificialFrame17).newInstance(null), 1508975308, 0};
            Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-501205803);
            if (objAccessartificialFrame18 == null) {
                int iIndexOf3 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 37;
                char keyRepeatTimeout3 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                int iIndexOf4 = 540 - TextUtils.indexOf("", "");
                byte b17 = (byte) ($$a[5] - 1);
                byte b18 = b17;
                Object[] objArr57 = new Object[1];
                c(b17, b18, (byte) (b18 | 47), objArr57);
                objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(iIndexOf3, keyRepeatTimeout3, iIndexOf4, 2101703389, false, (String) objArr57[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(54 - View.getDefaultSize(0, 0), (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 834), 576 - TextUtils.indexOf("", "", 0, 0)), (Class) ArtificialStackFrames.coroutineCreation((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 53, (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1), 631 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), Integer.TYPE, Integer.TYPE});
            }
            objArr3 = (Object[]) ((Method) objAccessartificialFrame18).invoke(null, objArr56);
            Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame19 == null) {
                int iRgb4 = (-16777180) - Color.rgb(0, 0, 0);
                char doubleTapTimeout = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                int iResolveSize = View.resolveSize(0, 0) + 540;
                byte[] bArr22 = $$a;
                byte b19 = bArr22[18];
                Object[] objArr58 = new Object[1];
                c(b19, (byte) (b19 | 35), bArr22[28], objArr58);
                objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(iRgb4, doubleTapTimeout, iResolveSize, 793268735, false, (String) objArr58[0], null);
            }
            ((Field) objAccessartificialFrame19).set(null, objArr3);
            try {
                Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                if (objAccessartificialFrame20 == null) {
                    int maxKeyCode = (KeyEvent.getMaxKeyCode() >> 16) + 36;
                    char c6 = (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                    int maximumDrawingCacheSize = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 540;
                    byte[] bArr23 = $$a;
                    byte b20 = bArr23[18];
                    Object[] objArr59 = new Object[1];
                    c(b20, (byte) (b20 | 35), (byte) (bArr23[5] - 1), objArr59);
                    objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(maxKeyCode, c6, maximumDrawingCacheSize, 624296913, false, (String) objArr59[0], null);
                }
                ((Field) objAccessartificialFrame20).set(null, lValueOf6);
            } catch (Exception unused4) {
                throw new RuntimeException();
            }
        } else {
            int i84 = getARTIFICIAL_FRAME_PACKAGE_NAME + 81;
            artificialFrame = i84 % 128;
            int i85 = i84 % 2;
            Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame21 == null) {
                int gidForName = Process.getGidForName("") + 37;
                char c7 = (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                int iResolveSize2 = 540 - View.resolveSize(0, 0);
                byte[] bArr24 = $$a;
                byte b21 = bArr24[18];
                Object[] objArr60 = new Object[1];
                c(b21, (byte) (b21 | 35), bArr24[28], objArr60);
                objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(gidForName, c7, iResolveSize2, 793268735, false, (String) objArr60[0], null);
            }
            Object[] objArr61 = (Object[]) ((Field) objAccessartificialFrame21).get(null);
            objArr3 = new Object[]{new int[1], new int[1], new int[1]};
            int i86 = ((int[]) objArr61[2])[0];
            int i87 = ((int[]) objArr61[1])[0];
            ((int[]) objArr3[2])[0] = i86;
            ((int[]) objArr3[1])[0] = i87;
            int iIdentityHashCode4 = System.identityHashCode(this);
            int i88 = (((~((-239993733) | iIdentityHashCode4)) | 16848897) * TypedValues.PositionType.TYPE_TRANSITION_EASING) + 1522483500 + ((~((~iIdentityHashCode4) | (-239993733))) * TypedValues.PositionType.TYPE_TRANSITION_EASING) + 1508975308;
            int i89 = (i88 << 13) ^ i88;
            int i90 = i89 ^ (i89 >>> 17);
            ((int[]) objArr3[0])[0] = i90 ^ (i90 << 5);
        }
        Object obj = objArr3[1];
        int i91 = ((int[]) obj)[0];
        Object obj2 = objArr3[2];
        int i92 = ((int[]) obj2)[0];
        if (i92 == i91) {
            Object[] objArr62 = {new int[1], new int[1], new int[1]};
            int i93 = ((int[]) objArr3[0])[0];
            int i94 = ((int[]) obj2)[0];
            int i95 = ((int[]) obj)[0];
            ((int[]) objArr62[2])[0] = i94;
            ((int[]) objArr62[1])[0] = i95;
            int i96 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenHeightDp;
            int i97 = i93 + ((((-176256865) + (((~((~i96) | (-290734064))) | 286268550) * 446)) + (((~(i96 | (-4465514))) | 774619136) * 446)) - 1173245580);
            int i98 = (i97 << 13) ^ i97;
            int i99 = i98 ^ (i98 >>> 17);
            ((int[]) objArr62[0])[0] = i99 ^ (i99 << 5);
        } else {
            Object[] objArr63 = {Long.valueOf((((long) 766659436) << 32) ^ ((long) (i91 ^ i92))), Long.valueOf(766663532)};
            byte[] bArr25 = $$d;
            Object[] objArr64 = new Object[1];
            e(bArr25[27], bArr25[22], (short) 365, objArr64);
            Class<?> cls8 = Class.forName((String) objArr64[0]);
            Object[] objArr65 = new Object[1];
            e(bArr25[732], bArr25[34], bArr25[626], objArr65);
            cls8.getMethod((String) objArr65[0], Long.TYPE, Long.TYPE).invoke(null, objArr63);
            Object[] objArr66 = {new int[1], new int[1], new int[1]};
            int i100 = ((int[]) objArr3[0])[0];
            int i101 = ((int[]) objArr3[2])[0];
            int i102 = ((int[]) objArr3[1])[0];
            ((int[]) objArr66[2])[0] = i101;
            ((int[]) objArr66[1])[0] = i102;
            int iIdentityHashCode5 = System.identityHashCode(this);
            int i103 = ~iIdentityHashCode5;
            int i104 = i100 + 1506181703 + (((~((-629126134) | i103)) | (~((-722495617) | iIdentityHashCode5))) * 1900) + (((~(i103 | 722495616)) | (~(iIdentityHashCode5 | 629126133))) * (-950)) + (((~(iIdentityHashCode5 | 722495616)) | (~(i103 | 629126133))) * 950);
            int i105 = i104 ^ (i104 << 13);
            int i106 = i105 ^ (i105 >>> 17);
            ((int[]) objArr66[0])[0] = i106 ^ (i106 << 5);
        }
        Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame22 == null) {
            int iCombineMeasuredStates = View.combineMeasuredStates(0, 0) + 17;
            char c8 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
            int packedPositionChild2 = 746 - ExpandableListView.getPackedPositionChild(0L);
            byte[] bArr26 = $$a;
            byte b22 = bArr26[18];
            Object[] objArr67 = new Object[1];
            c(b22, (byte) (b22 | 35), (byte) (bArr26[5] - 1), objArr67);
            objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates, c8, packedPositionChild2, -144068856, false, (String) objArr67[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame22).getLong(null);
        if (j5 != -1) {
            int i107 = artificialFrame + 95;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i107 % 128;
            int i108 = i107 % 2;
            if (j5 + 4611686018427387870L >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1575402270);
                if (objAccessartificialFrame23 == null) {
                    int trimmedLength = 17 - TextUtils.getTrimmedLength("");
                    char packedPositionChild3 = (char) (ExpandableListView.getPackedPositionChild(0L) + 1);
                    int iResolveSize3 = 747 - View.resolveSize(0, 0);
                    byte[] bArr27 = $$a;
                    byte b23 = bArr27[18];
                    Object[] objArr68 = new Object[1];
                    c(b23, (byte) (b23 | 35), bArr27[28], objArr68);
                    objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(trimmedLength, packedPositionChild3, iResolveSize3, -1031537386, false, (String) objArr68[0], null);
                }
                Object[] objArr69 = (Object[]) ((Field) objAccessartificialFrame23).get(null);
                objArr4 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
                int i109 = ((int[]) objArr69[3])[0];
                int i110 = ((int[]) objArr69[4])[0];
                List list = (List) objArr69[0];
                List list2 = (List) objArr69[2];
                int iMyUid2 = Process.myUid();
                int i111 = 1158376283 + (((~((~iMyUid2) | (-103981721))) | 69370384) * 446) + (((~(iMyUid2 | (-34611337))) | 432096353) * 446) + 391574795;
                int i112 = (i111 << 13) ^ i111;
                int i113 = i112 ^ (i112 >>> 17);
                ((int[]) objArr4[1])[0] = i113 ^ (i113 << 5);
            } else {
                baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr70 = new Object[1];
                    d(new byte[]{1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0}, new int[]{69, 26, 0, 1}, true, objArr70);
                    Class<?> cls9 = Class.forName((String) objArr70[0]);
                    Object[] objArr71 = new Object[1];
                    d(new byte[]{1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1}, new int[]{95, 18, 0, 17}, false, objArr71);
                    Method method = cls9.getMethod((String) objArr71[0], new Class[0]);
                    baseContext = (Context) method.invoke(null, null);
                }
                if (baseContext != null) {
                    if ((baseContext instanceof ContextWrapper) || ((ContextWrapper) baseContext).getBaseContext() != null) {
                        baseContext = baseContext.getApplicationContext();
                    } else {
                        baseContext = null;
                    }
                }
                Object[] objArr72 = {baseContext, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -482845397};
                byte[] bArr28 = $$d;
                Object[] objArr73 = new Object[1];
                e(bArr28[402], bArr28[22], (short) 431, objArr73);
                Class<?> cls10 = Class.forName((String) objArr73[0]);
                byte b24 = bArr28[81];
                Object[] objArr74 = new Object[1];
                e(b24, (byte) (b24 >>> 1), (short) 346, objArr74);
                objArr4 = (Object[]) cls10.getMethod((String) objArr74[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr72);
                objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(1575402270);
                if (objAccessartificialFrame6 == null) {
                    int iLastIndexOf = TextUtils.lastIndexOf("", '0') + 18;
                    char cLastIndexOf = (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0));
                    int iIndexOf5 = TextUtils.indexOf("", "") + 747;
                    byte[] bArr29 = $$a;
                    byte b25 = bArr29[18];
                    Object[] objArr75 = new Object[1];
                    c(b25, (byte) (b25 | 35), bArr29[28], objArr75);
                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, cLastIndexOf, iIndexOf5, -1031537386, false, (String) objArr75[0], null);
                }
                ((Field) objAccessartificialFrame6).set(null, objArr4);
                try {
                    Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(1745676544);
                    if (objAccessartificialFrame7 == null) {
                        int doubleTapTimeout2 = 17 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                        char offsetBefore2 = (char) TextUtils.getOffsetBefore("", 0);
                        int deadChar = KeyEvent.getDeadChar(0, 0) + 747;
                        byte[] bArr30 = $$a;
                        byte b26 = bArr30[18];
                        Object[] objArr76 = new Object[1];
                        c(b26, (byte) (b26 | 35), (byte) (bArr30[5] - 1), objArr76);
                        objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout2, offsetBefore2, deadChar, -144068856, false, (String) objArr76[0], null);
                    }
                    ((Field) objAccessartificialFrame7).set(null, lValueOf7);
                } catch (Exception unused5) {
                    throw new RuntimeException();
                }
            }
        } else {
            baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr77 = new Object[1];
                d(new byte[]{1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0}, new int[]{69, 26, 0, 1}, true, objArr77);
                Class<?> cls11 = Class.forName((String) objArr77[0]);
                Object[] objArr78 = new Object[1];
                d(new byte[]{1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1}, new int[]{95, 18, 0, 17}, false, objArr78);
                Method method2 = cls11.getMethod((String) objArr78[0], new Class[0]);
                baseContext = (Context) method2.invoke(null, null);
            }
            if (baseContext != null) {
                if (baseContext instanceof ContextWrapper) {
                    baseContext = baseContext.getApplicationContext();
                } else {
                    baseContext = baseContext.getApplicationContext();
                }
            }
            Object[] objArr79 = {baseContext, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -482845397};
            byte[] bArr210 = $$d;
            Object[] objArr710 = new Object[1];
            e(bArr210[402], bArr210[22], (short) 431, objArr710);
            Class<?> cls12 = Class.forName((String) objArr710[0]);
            byte b27 = bArr210[81];
            Object[] objArr711 = new Object[1];
            e(b27, (byte) (b27 >>> 1), (short) 346, objArr711);
            objArr4 = (Object[]) cls12.getMethod((String) objArr711[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr79);
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame6 == null) {
                int iLastIndexOf2 = TextUtils.lastIndexOf("", '0') + 18;
                char cLastIndexOf2 = (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0));
                int iIndexOf6 = TextUtils.indexOf("", "") + 747;
                byte[] bArr211 = $$a;
                byte b28 = bArr211[18];
                Object[] objArr712 = new Object[1];
                c(b28, (byte) (b28 | 35), bArr211[28], objArr712);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iLastIndexOf2, cLastIndexOf2, iIndexOf6, -1031537386, false, (String) objArr712[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, objArr4);
            Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(1745676544);
            if (objAccessartificialFrame7 == null) {
                int doubleTapTimeout3 = 17 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                char offsetBefore3 = (char) TextUtils.getOffsetBefore("", 0);
                int deadChar2 = KeyEvent.getDeadChar(0, 0) + 747;
                byte[] bArr31 = $$a;
                byte b29 = bArr31[18];
                Object[] objArr713 = new Object[1];
                c(b29, (byte) (b29 | 35), (byte) (bArr31[5] - 1), objArr713);
                objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout3, offsetBefore3, deadChar2, -144068856, false, (String) objArr713[0], null);
            }
            ((Field) objAccessartificialFrame7).set(null, lValueOf8);
        }
        int i114 = ((int[]) objArr4[4])[0];
        int i115 = ((int[]) objArr4[3])[0];
        if (i115 == i114) {
            Object[] objArr80 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i116 = ((int[]) objArr4[1])[0];
            int i117 = ((int[]) objArr4[3])[0];
            int i118 = ((int[]) objArr4[4])[0];
            List list3 = (List) objArr4[0];
            List list4 = (List) objArr4[2];
            int iIdentityHashCode6 = System.identityHashCode(this);
            int i119 = ~iIdentityHashCode6;
            int i120 = i116 + 34027041 + ((iIdentityHashCode6 | 295211693) * 140) + (((~(295211693 | i119)) | 40191056) * (-280)) + (((~(iIdentityHashCode6 | (-40191057))) | (~(310236764 | i119)) | 25165985) * 140);
            int i121 = (i120 << 13) ^ i120;
            int i122 = i121 ^ (i121 >>> 17);
            ((int[]) objArr80[1])[0] = i122 ^ (i122 << 5);
        } else {
            ArrayList arrayList3 = new ArrayList();
            Object[] objArr81 = {objArr4};
            Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(1804664566);
            if (objAccessartificialFrame24 == null) {
                objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(View.MeasureSpec.makeMeasureSpec(0, 0) + 41, (char) ((ViewConfiguration.getScrollBarSize() >> 8) + 12468), 3642 - (ViewConfiguration.getTouchSlop() >> 8), -185222914, false, "coroutineCreation", new Class[]{Object[].class});
            }
            arrayList3.add(((Method) objAccessartificialFrame24).invoke(null, objArr81));
            Object[] objArr82 = {objArr4};
            Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-1243809191);
            if (objAccessartificialFrame25 == null) {
                objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0', 0, 0) + 42, (char) (12468 - (ViewConfiguration.getTapTimeout() >> 16)), ((byte) KeyEvent.getModifierMetaStateMask()) + 3643, 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
            }
            arrayList3.add(((Method) objAccessartificialFrame25).invoke(null, objArr82));
            Object[] objArr83 = {Long.valueOf(((long) (i114 ^ i115)) ^ (((long) (-847706830)) << 32)), Long.valueOf(-847706822)};
            byte[] bArr32 = $$d;
            Object[] objArr84 = new Object[1];
            e(bArr32[240], bArr32[22], (short) TSLocationManager.LOCATION_ERROR_CANCELLED, objArr84);
            Class<?> cls13 = Class.forName((String) objArr84[0]);
            Object[] objArr85 = new Object[1];
            e(bArr32[732], bArr32[34], bArr32[626], objArr85);
            cls13.getMethod((String) objArr85[0], Long.TYPE, Long.TYPE).invoke(null, objArr83);
            Object[] objArr86 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i123 = ((int[]) objArr4[1])[0];
            int i124 = ((int[]) objArr4[3])[0];
            int i125 = ((int[]) objArr4[4])[0];
            List list5 = (List) objArr4[0];
            List list6 = (List) objArr4[2];
            int iMyUid3 = Process.myUid();
            int i126 = (~((-126724490) | iMyUid3)) | 76065152;
            int i127 = ~((~iMyUid3) | 529383305);
            int i128 = i123 + 1996331529 + ((i126 | i127) * (-470)) + (((~(iMyUid3 | (-50659338))) | i127) * 470);
            int i129 = (i128 << 13) ^ i128;
            int i130 = i129 ^ (i129 >>> 17);
            ((int[]) objArr86[1])[0] = i130 ^ (i130 << 5);
        }
        Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame26 == null) {
            int threadPriority = 30 - ((Process.getThreadPriority(0) + 20) >> 6);
            char minimumFlingVelocity = (char) (49362 - (ViewConfiguration.getMinimumFlingVelocity() >> 16));
            int i131 = 685 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
            byte b30 = (byte) (-$$a[4]);
            Object[] objArr87 = new Object[1];
            c(b30, (byte) (b30 | 40), (byte) 67, objArr87);
            objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(threadPriority, minimumFlingVelocity, i131, 752929587, false, (String) objArr87[0], null);
        }
        long j6 = ((Field) objAccessartificialFrame26).getLong(null);
        if (j6 == -1 || j6 + 1922 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext3 = getBaseContext();
            if (baseContext3 == null) {
                Object[] objArr88 = new Object[1];
                d(new byte[]{1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0}, new int[]{69, 26, 0, 1}, true, objArr88);
                Class<?> cls14 = Class.forName((String) objArr88[0]);
                Object[] objArr89 = new Object[1];
                d(new byte[]{1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1}, new int[]{95, 18, 0, 17}, false, objArr89);
                baseContext3 = (Context) cls14.getMethod((String) objArr89[0], new Class[0]).invoke(null, null);
            }
            if (baseContext3 != null) {
                baseContext3 = ((baseContext3 instanceof ContextWrapper) && ((ContextWrapper) baseContext3).getBaseContext() == null) ? null : baseContext3.getApplicationContext();
            }
            Object[] objArr90 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 522543031};
            byte[] bArr33 = $$d;
            Object[] objArr91 = new Object[1];
            e(bArr33[249], bArr33[22], (short) 558, objArr91);
            Class<?> cls15 = Class.forName((String) objArr91[0]);
            byte b31 = bArr33[81];
            Object[] objArr92 = new Object[1];
            e(b31, (byte) (b31 >>> 1), (short) 346, objArr92);
            objArr5 = (Object[]) cls15.getMethod((String) objArr92[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr90);
            if (baseContext3 != null) {
                Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(-326560385);
                if (objAccessartificialFrame27 == null) {
                    int iLastIndexOf3 = TextUtils.lastIndexOf("", '0', 0) + 31;
                    char cIndexOf6 = (char) (49361 - TextUtils.indexOf((CharSequence) "", '0', 0));
                    int iLastIndexOf4 = 683 - TextUtils.lastIndexOf("", '0', 0, 0);
                    byte[] bArr34 = $$a;
                    Object[] objArr93 = new Object[1];
                    c((byte) (-bArr34[4]), (byte) (bArr34[65] + 1), (byte) 82, objArr93);
                    objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(iLastIndexOf3, cIndexOf6, iLastIndexOf4, 1944867703, false, (String) objArr93[0], null);
                }
                ((Field) objAccessartificialFrame27).set(null, objArr5);
                try {
                    Long lValueOf9 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                    if (objAccessartificialFrame28 == null) {
                        int maximumDrawingCacheSize2 = 30 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                        char cAxisFromString2 = (char) (MotionEvent.axisFromString("") + 49363);
                        int i132 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 684;
                        byte b32 = (byte) (-$$a[4]);
                        Object[] objArr94 = new Object[1];
                        c(b32, (byte) (b32 | 40), (byte) 67, objArr94);
                        objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize2, cAxisFromString2, i132, 752929587, false, (String) objArr94[0], null);
                    }
                    ((Field) objAccessartificialFrame28).set(null, lValueOf9);
                } catch (Exception unused6) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(-326560385);
            if (objAccessartificialFrame29 == null) {
                int iAlpha = Color.alpha(0) + 30;
                char cResolveSize = (char) (View.resolveSize(0, 0) + 49362);
                int i133 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 683;
                byte[] bArr35 = $$a;
                Object[] objArr95 = new Object[1];
                c((byte) (-bArr35[4]), (byte) (bArr35[65] + 1), (byte) 82, objArr95);
                objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(iAlpha, cResolveSize, i133, 1944867703, false, (String) objArr95[0], null);
            }
            Object[] objArr96 = (Object[]) ((Field) objAccessartificialFrame29).get(null);
            objArr5 = new Object[]{new int[]{((int[]) objArr96[0])[0]}, new int[]{((int[]) objArr96[1])[0]}, new int[1], (String) objArr96[3]};
            int i134 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenHeightDp;
            int i135 = ~i134;
            int i136 = (~(48168216 | i135)) | (-1073741632) | (~(1026791991 | i135));
            int i137 = (-1887706434) + (((~(i134 | (-1218577))) | i136) * 590) + (i136 * (-1180)) + (((~((-1026791992) | i135)) | (~(i135 | (-48168217)))) * 590) + 522543031;
            int i138 = (i137 << 13) ^ i137;
            int i139 = i138 ^ (i138 >>> 17);
            ((int[]) objArr5[2])[0] = i139 ^ (i139 << 5);
        }
        int i140 = ((int[]) objArr5[1])[0];
        int i141 = ((int[]) objArr5[0])[0];
        if (i141 == i140) {
            int i142 = getARTIFICIAL_FRAME_PACKAGE_NAME + 25;
            artificialFrame = i142 % 128;
            int i143 = i142 % 2;
            int i144 = ((int[]) objArr5[2])[0];
            Object[] objArr97 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int i145 = ~(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 186666020);
            int i146 = i144 + (((~((-737147754) | i145)) | 174367009) * (-241)) + 1057997275 + (((~(i145 | (-562780745))) | 67109012) * 241);
            int i147 = (i146 << 13) ^ i146;
            int i148 = i147 ^ (i147 >>> 17);
            ((int[]) objArr97[2])[0] = i148 ^ (i148 << 5);
        } else {
            Object[] objArr98 = {Long.valueOf(((long) (i140 ^ i141)) ^ (((long) (-300247780)) << 32)), Long.valueOf(-300247784)};
            byte[] bArr36 = $$d;
            Object[] objArr99 = new Object[1];
            e(bArr36[51], bArr36[22], (short) 627, objArr99);
            Class<?> cls16 = Class.forName((String) objArr99[0]);
            Object[] objArr100 = new Object[1];
            e(bArr36[732], bArr36[34], bArr36[626], objArr100);
            cls16.getMethod((String) objArr100[0], Long.TYPE, Long.TYPE).invoke(null, objArr98);
            int i149 = ((int[]) objArr5[2])[0];
            Object[] objArr101 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int iIdentityHashCode7 = System.identityHashCode(this);
            int i150 = ~(512858633 | iIdentityHashCode7);
            int i151 = i149 + 711375587 + ((21102868 | i150) * (-814)) + ((i150 | (~((~iIdentityHashCode7) | (-465765142))) | 68196360) * 407) + (((~(iIdentityHashCode7 | 465765141)) | (~((-512858634) | iIdentityHashCode7)) | 68196360) * 407);
            int i152 = (i151 << 13) ^ i151;
            int i153 = i152 ^ (i152 >>> 17);
            ((int[]) objArr101[2])[0] = i153 ^ (i153 << 5);
        }
        Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame30 == null) {
            int keyRepeatDelay5 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 30;
            char cArgb = (char) (Color.argb(0, 0, 0, 0) + 49362);
            int offsetBefore4 = TextUtils.getOffsetBefore("", 0) + 684;
            byte b33 = $$a[28];
            Object[] objArr102 = new Object[1];
            c(b33, (byte) (b33 | 37), (byte) 97, objArr102);
            objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay5, cArgb, offsetBefore4, 508509282, false, (String) objArr102[0], null);
        }
        long j7 = ((Field) objAccessartificialFrame30).getLong(null);
        if (j7 == -1 || j7 + 1868 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext4 = getBaseContext();
            if (baseContext4 == null) {
                Object[] objArr103 = new Object[1];
                d(new byte[]{1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0}, new int[]{69, 26, 0, 1}, true, objArr103);
                Class<?> cls17 = Class.forName((String) objArr103[0]);
                Object[] objArr104 = new Object[1];
                d(new byte[]{1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1}, new int[]{95, 18, 0, 17}, false, objArr104);
                baseContext4 = (Context) cls17.getMethod((String) objArr104[0], new Class[0]).invoke(null, null);
            }
            if (baseContext4 != null) {
                int i154 = getARTIFICIAL_FRAME_PACKAGE_NAME + 69;
                artificialFrame = i154 % 128;
                if (i154 % 2 == 0) {
                    int i155 = 51 / 0;
                    if (baseContext4 instanceof ContextWrapper) {
                        if (((ContextWrapper) baseContext4).getBaseContext() != null) {
                            baseContext4 = null;
                        }
                    }
                } else if (baseContext4 instanceof ContextWrapper) {
                    if (((ContextWrapper) baseContext4).getBaseContext() != null) {
                        baseContext4 = null;
                    }
                }
                baseContext4 = baseContext4.getApplicationContext();
            }
            Object[] objArr105 = {baseContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -1051985220};
            byte[] bArr37 = $$d;
            Object[] objArr106 = new Object[1];
            e(bArr37[204], bArr37[22], (short) 651, objArr106);
            Class<?> cls18 = Class.forName((String) objArr106[0]);
            byte b34 = (byte) (bArr37[81] - 1);
            Object[] objArr107 = new Object[1];
            e(b34, b34, (short) ($$e | 161), objArr107);
            objArr6 = (Object[]) cls18.getMethod((String) objArr107[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr105);
            if (baseContext4 != null) {
                Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame31 == null) {
                    int i156 = 31 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                    char longPressTimeout = (char) (49362 - (ViewConfiguration.getLongPressTimeout() >> 16));
                    int longPressTimeout2 = (ViewConfiguration.getLongPressTimeout() >> 16) + 684;
                    byte[] bArr38 = $$a;
                    Object[] objArr108 = new Object[1];
                    c(bArr38[49], (byte) (-bArr38[15]), (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, objArr108);
                    objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(i156, longPressTimeout, longPressTimeout2, -1321816393, false, (String) objArr108[0], null);
                }
                ((Field) objAccessartificialFrame31).set(null, objArr6);
                try {
                    Long lValueOf10 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                    if (objAccessartificialFrame32 == null) {
                        int scrollBarSize2 = 30 - (ViewConfiguration.getScrollBarSize() >> 8);
                        char bitsPerPixel2 = (char) (49361 - ImageFormat.getBitsPerPixel(0));
                        int i157 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 683;
                        byte b35 = $$a[28];
                        Object[] objArr109 = new Object[1];
                        c(b35, (byte) (b35 | 37), (byte) 97, objArr109);
                        objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(scrollBarSize2, bitsPerPixel2, i157, 508509282, false, (String) objArr109[0], null);
                    }
                    ((Field) objAccessartificialFrame32).set(null, lValueOf10);
                } catch (Exception unused7) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(777251007);
            if (objAccessartificialFrame33 == null) {
                int tapTimeout = (ViewConfiguration.getTapTimeout() >> 16) + 30;
                char cNormalizeMetaState2 = (char) (49362 - KeyEvent.normalizeMetaState(0));
                int iKeyCodeFromString = 684 - KeyEvent.keyCodeFromString("");
                byte[] bArr39 = $$a;
                Object[] objArr111 = new Object[1];
                c(bArr39[49], (byte) (-bArr39[15]), (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, objArr111);
                objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(tapTimeout, cNormalizeMetaState2, iKeyCodeFromString, -1321816393, false, (String) objArr111[0], null);
            }
            Object[] objArr112 = (Object[]) ((Field) objAccessartificialFrame33).get(null);
            objArr6 = new Object[]{new int[]{((int[]) objArr112[0])[0]}, new int[]{((int[]) objArr112[1])[0]}, new int[1], (String) objArr112[3]};
            int i158 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().smallestScreenWidthDp;
            int i159 = ~i158;
            int i160 = (((((~(36496546 | i159)) | (~(i158 | 1015120321))) * 959) + 161886585) + (((~(i158 | 36496546)) | (~(i159 | 1015120321))) * 959)) - 1051985220;
            int i161 = (i160 << 13) ^ i160;
            int i162 = i161 ^ (i161 >>> 17);
            ((int[]) objArr6[2])[0] = i162 ^ (i162 << 5);
        }
        int i163 = ((int[]) objArr6[1])[0];
        int i164 = ((int[]) objArr6[0])[0];
        if (i164 == i163) {
            int i165 = ((int[]) objArr6[2])[0];
            Object[] objArr113 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
            int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 746483997;
            int i166 = i165 + 910532742 + (((~(935329054 | length)) | 43294720) * (-756)) + (((~length) | 935329054) * 756);
            int i167 = (i166 << 13) ^ i166;
            int i168 = i167 ^ (i167 >>> 17);
            ((int[]) objArr113[2])[0] = i168 ^ (i168 << 5);
        } else {
            Object[] objArr114 = {Long.valueOf(((long) (i163 ^ i164)) ^ (((long) 968291981) << 32)), Long.valueOf(968291469)};
            byte[] bArr40 = $$d;
            Object[] objArr115 = new Object[1];
            e(bArr40[27], bArr40[22], (short) 365, objArr115);
            Class<?> cls19 = Class.forName((String) objArr115[0]);
            Object[] objArr116 = new Object[1];
            e(bArr40[732], bArr40[34], bArr40[626], objArr116);
            cls19.getMethod((String) objArr116[0], Long.TYPE, Long.TYPE).invoke(null, objArr114);
            int i169 = ((int[]) objArr6[2])[0];
            Object[] objArr117 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
            int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
            int i170 = i169 + (-1332995493) + (((~(iFreeMemory | 11038992)) | 967584782) * 191) + (((~((~iFreeMemory) | 11038992)) | 956566542) * 191);
            int i171 = (i170 << 13) ^ i170;
            int i172 = i171 ^ (i171 >>> 17);
            ((int[]) objArr117[2])[0] = i172 ^ (i172 << 5);
        }
        Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame34 == null) {
            int i173 = 25 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
            char c9 = (char) (30069 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
            int iArgb = 816 - Color.argb(0, 0, 0, 0);
            byte[] bArr41 = $$a;
            byte b36 = bArr41[18];
            Object[] objArr118 = new Object[1];
            c(b36, (byte) (b36 | 35), (byte) (bArr41[5] - 1), objArr118);
            objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(i173, c9, iArgb, 721586079, false, (String) objArr118[0], null);
        }
        long j8 = ((Field) objAccessartificialFrame34).getLong(null);
        if (j8 == -1 || j8 + 1895 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr119 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -962443318};
            Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame35 == null) {
                int touchSlop = (ViewConfiguration.getTouchSlop() >> 8) + 25;
                char cRgb = (char) ((-16747148) - Color.rgb(0, 0, 0));
                int iResolveSizeAndState = 816 - View.resolveSizeAndState(0, 0, 0);
                byte[] bArr42 = $$a;
                byte b37 = bArr42[9];
                byte b38 = bArr42[35];
                Object[] objArr120 = new Object[1];
                c(b37, b38, (byte) (b38 - 3), objArr120);
                objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(touchSlop, cRgb, iResolveSizeAndState, -797394565, false, (String) objArr120[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            Object[] objArr121 = (Object[]) ((Method) objAccessartificialFrame35).invoke(null, objArr119);
            Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame36 == null) {
                int iIndexOf7 = 24 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                char bitsPerPixel3 = (char) (ImageFormat.getBitsPerPixel(0) + 30069);
                int iResolveSizeAndState2 = 816 - View.resolveSizeAndState(0, 0, 0);
                byte[] bArr43 = $$a;
                byte b39 = bArr43[18];
                Object[] objArr122 = new Object[1];
                c(b39, (byte) (b39 | 35), bArr43[28], objArr122);
                objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(iIndexOf7, bitsPerPixel3, iResolveSizeAndState2, 891606461, false, (String) objArr122[0], null);
            }
            ((Field) objAccessartificialFrame36).set(null, objArr121);
            try {
                Long lValueOf11 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame37 == null) {
                    int size = 25 - View.MeasureSpec.getSize(0);
                    char bitsPerPixel4 = (char) (30067 - ImageFormat.getBitsPerPixel(0));
                    int scrollDefaultDelay3 = 816 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                    byte[] bArr44 = $$a;
                    byte b40 = bArr44[18];
                    Object[] objArr123 = new Object[1];
                    c(b40, (byte) (b40 | 35), (byte) (bArr44[5] - 1), objArr123);
                    objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(size, bitsPerPixel4, scrollDefaultDelay3, 721586079, false, (String) objArr123[0], null);
                }
                ((Field) objAccessartificialFrame37).set(null, lValueOf11);
                objArr7 = objArr121;
            } catch (Exception unused8) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame38 == null) {
                int i174 = 26 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                char cCombineMeasuredStates = (char) (View.combineMeasuredStates(0, 0) + 30068);
                int i175 = 816 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                byte[] bArr45 = $$a;
                byte b41 = bArr45[18];
                Object[] objArr124 = new Object[1];
                c(b41, (byte) (b41 | 35), bArr45[28], objArr124);
                objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(i174, cCombineMeasuredStates, i175, 891606461, false, (String) objArr124[0], null);
            }
            Object[] objArr125 = (Object[]) ((Field) objAccessartificialFrame38).get(null);
            objArr7 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i176 = ((int[]) objArr125[0])[0];
            int i177 = ((int[]) objArr125[1])[0];
            String[] strArr8 = (String[]) objArr125[2];
            int iIdentityHashCode8 = System.identityHashCode(this);
            int i178 = ~iIdentityHashCode8;
            int i179 = (((912986639 + (((~(733321856 | i178)) | (~((-931494223) | iIdentityHashCode8))) * 1900)) + (((~(i178 | 931494222)) | (~(iIdentityHashCode8 | (-733321857)))) * (-950))) + (((~(iIdentityHashCode8 | 931494222)) | (~(i178 | (-733321857)))) * 950)) - 962443318;
            int i180 = (i179 << 13) ^ i179;
            int i181 = i180 ^ (i180 >>> 17);
            ((int[]) objArr7[3])[0] = i181 ^ (i181 << 5);
        }
        int i182 = ((int[]) objArr7[1])[0];
        int i183 = ((int[]) objArr7[0])[0];
        if (i183 == i182) {
            Object[] objArr126 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i184 = ((int[]) objArr7[3])[0];
            int i185 = ((int[]) objArr7[0])[0];
            int i186 = ((int[]) objArr7[1])[0];
            String[] strArr9 = (String[]) objArr7[2];
            int iIdentityHashCode9 = System.identityHashCode(this);
            int i187 = ~iIdentityHashCode9;
            int i188 = i184 + 1582810141 + ((iIdentityHashCode9 | 547707401) * 988) + (((~(884300331 | i187)) | (-1022720896)) * (-1976)) + (((~(iIdentityHashCode9 | 686127965)) | 547707401 | (~((-686127966) | i187))) * 988);
            int i189 = (i188 << 13) ^ i188;
            int i190 = i189 ^ (i189 >>> 17);
            ((int[]) objArr126[3])[0] = i190 ^ (i190 << 5);
        } else {
            ArrayList arrayList4 = new ArrayList();
            String[] strArr10 = (String[]) objArr7[2];
            if (strArr10 != null) {
                for (String str8 : strArr10) {
                    int i191 = getARTIFICIAL_FRAME_PACKAGE_NAME + 55;
                    artificialFrame = i191 % 128;
                    int i192 = i191 % 2;
                    arrayList4.add(str8);
                }
            }
            Object[] objArr127 = {Long.valueOf(((long) (i182 ^ i183)) ^ (((long) (-1432015253)) << 32)), Long.valueOf(-1432015254)};
            byte[] bArr46 = $$d;
            Object[] objArr128 = new Object[1];
            e(bArr46[129], bArr46[22], (short) 691, objArr128);
            Class<?> cls20 = Class.forName((String) objArr128[0]);
            Object[] objArr129 = new Object[1];
            e(bArr46[732], bArr46[34], bArr46[626], objArr129);
            cls20.getMethod((String) objArr129[0], Long.TYPE, Long.TYPE).invoke(null, objArr127);
            Object[] objArr130 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i193 = ((int[]) objArr7[3])[0];
            int i194 = ((int[]) objArr7[0])[0];
            int i195 = ((int[]) objArr7[1])[0];
            String[] strArr11 = (String[]) objArr7[2];
            int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
            int i196 = i193 + ((((~((-649978622) | iMaxMemory)) | 44826669) * (-566)) - 199736757) + ((~(iMaxMemory | (-605151953))) * 566);
            int i197 = (i196 << 13) ^ i196;
            int i198 = i197 ^ (i197 >>> 17);
            ((int[]) objArr130[3])[0] = i198 ^ (i198 << 5);
        }
        super.onCreate();
    }

    static void accessartificialFrame() {
        IPostMessageService = new char[]{38282, 38360, 38358, 38354, 38376, 38375, 38358, 38355, 38348, 38345, 38361, 38399, 38383, 38350, 38385, 38390, 38361, 38355, 38351, 38356, 38358, 38360, 38285, 38358, 38356, 38353, 38351, 38361, 38364, 38372, 38372, 38363, 38355, 38350, 38359, 38361, 38359, 38381, 38200, 38338, 38172, 38156, 38159, 38166, 38169, 38167, 38173, 38167, 38167, 38203, 38197, 38172, 38171, 38385, 38167, 38145, 38270, 38166, 38162, 38146, 38151, 38148, 38149, 38151, 38146, 38266, 38269, 38269, 38261, 38287, 38365, 38365, 38364, 38356, 38354, 38369, 38361, 38345, 38353, 38352, 38352, 38353, 38356, 38381, 38280, 38384, 38351, 38359, 38392, 38390, 38361, 38355, 38351, 38356, 38358, 38277, 38348, 38349, 38356, 38358, 38350, 38373, 38375, 38351, 38353, 38357, 38361, 38365, 38357, 38353, 38355, 38353, 38359, 38307, 38279, 38384, 38385, 38387, 38389, 38286, 38389, 38385, 38385, 38362, 38361, 38386, 38282, 38387, 38385, 38384, 38384, 38384, 38388, 38390, 38363, 38386, 38281, 38281, 38388, 38390, 38388, 38364, 38366, 38387, 38279, 38281, 38282, 38388, 38391, 38390, 38365, 38364, 38385, 38386, 38364, 38388, 38387, 38388, 38283, 38283, 38285, 38387, 38362, 38385, 38386, 38385, 38280, 38388, 38391, 38284, 38280, 38384, 38362, 38363, 38386, 38282, 38282, 38186, 38036, 38038, 38065, 38216, 38212, 38061, 38040, 38061, 38211, 38060, 38038, 38037, 38038, 38063, 38212, 38213, 38213, 38214, 38216, 38215, 38214, 38214, 38212, 38210, 38060, 38038, 38062, 38214, 38215, 38215, 38213, 38214, 38063, 38062, 38061, 38062, 38213, 38212, 38211, 38060, 38062, 38060, 38038, 38038, 38062, 38214, 38213, 38211, 38059, 38062, 38213, 38061, 38062, 38210, 38212, 38215, 38215, 38062, 38036, 38036, 38036, 38059, 38211};
    }
}
