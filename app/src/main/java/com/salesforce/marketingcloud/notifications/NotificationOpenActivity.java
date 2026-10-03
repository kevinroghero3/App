package com.salesforce.marketingcloud.notifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.PowerManager;
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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.stats.zza;
import com.google.common.base.Ascii;
import com.google.common.collect.CompactHashMap;
import com.google.common.primitives.SignedBytes;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.g;
import com.salesforce.marketingcloud.util.j;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import net.pluservice.unicoc.R;
import o.ArtificialStackFrames;
import o.build;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes3.dex */
public class NotificationOpenActivity extends FragmentActivity {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    private static char ICustomTabsCallback;
    private static char TopicBuilder;
    private static int artificialFrame;
    private static final String b;
    private static char extraCallbackWithResult;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static char onMessageChannelReady;
    private BroadcastReceiver a;
    private static final byte[] $$c = {98, -62, -118, -34};
    private static final int $$f = SyslogConstants.LOG_LOCAL7;
    private static int $10 = 0;
    private static int $11 = 1;

    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            NotificationOpenActivity.this.a();
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    /* JADX WARN: Code duplicated, block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(int r6, byte r7, byte r8) {
        /*
            int r7 = r7 * 2
            int r7 = r7 + 108
            byte[] r0 = com.salesforce.marketingcloud.notifications.NotificationOpenActivity.$$c
            int r6 = r6 * 2
            int r1 = r6 + 1
            int r8 = r8 * 4
            int r8 = 3 - r8
            byte[] r1 = new byte[r1]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r6
            r7 = r8
            r4 = r2
            goto L2c
        L17:
            r3 = r2
        L18:
            int r8 = r8 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L27:
            r3 = r0[r8]
            r5 = r8
            r8 = r7
            r7 = r5
        L2c:
            int r3 = -r3
            int r8 = r8 + r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.notifications.NotificationOpenActivity.$$g(int, byte, byte):java.lang.String");
    }

    static {
        byte[] bArr = new byte[766];
        System.arraycopy("W\tB\u0016\u0010\u0002Å8\u0007\u0000ÑNù\u0003ÆI\u0005\u0002÷\u0000\u0010Å;\u0015ó\r\n\u0003¿\u001b-\nù\u000f\tÝ\u0017\u0005\u0003\u0011÷\rù\u0006ä5ó\r\n\u0006\u0004\u0006\u0012\u0004ò\u0015\u0006ù\u0001\u0007þ\nü\u000fÞ0ó\u0010ü\u0010\u0002Å=\f\u0004ü\týÍ9\u0010\u0002\u0004\u0006\u0003Ä9\u0010\u0001\u0004ý\u0002\u0015¾#\u0018\u0013á\u0018\u000eþ\u0011Û)\nõ\u0011\u0000÷\u000få\u0018\u0013¸!%\u0015\u0005\u0002ó\u0006\u0015ç\u0012\u0000\u000eä\u001e\u0018Ð-\n\u0002\u000b\u0004A\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000ÇH÷\u0000\u0006\u0015¾Kø\bø\u0011÷\n\u0002\u0011À/\u001aüþñ%ù\u0005ï#\u0004\u0001¼\u0004%7\u0000õ\u0011\u0000÷\u000fë*ù\nø\u0001\u0013ùþí\u0019\u0010ù\u0006\u0001Ó\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000Ç?\bø\n\u0002\u000fý\u000bù\u000b\u0001\tûÍ9\u0010\u0007÷Í&&\u0001ù\u0015ò\u0006\u0011å\u0016\u0010\bô\rù\u0006å\u001f\u0006\u0015ÿ\u0007\u000b¯#0\u0002\u0007õ\u0011ÿ\n\u0003\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000ÇIùý\u0015÷Í?\t\nõ\u0011\u0000÷\u000fÆ)\u0019ý\u0015÷â0\u0003\nõ\r\næ\u000f\u000f\u0001ÿ\u0001\u0017ù\n\u0003º6\u000f\u000f\u0001ÿ\u0001\u0017ÿ\u0007\u0010\u0007\u0001\n\u0003ù\tûâ3÷\u0000\u0017ù\n\u0003\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000Ç7\u0013\u0004\u0000\u0001\t\u0001\f¿\u00173\u0004à!\t\u0001Ý!\u0017ñÇ\u0011\u0010\u0002Å=\f\u0004ü\týÍ9\u0013\u000bû\bÿÃJù\t\u0001ÇIùý\u0007\u0005\u0003ÎF\u0006\u0001\tÿ÷\u0017õÌ+\u001d\u0003\u0006ù\t\u0001\u0007ü\u0005\u000eýë\u0019\u001d\u0003Þ%\u0002û\týé!\u000e\u0005´\u0012\u0010\u0002Å=\f\u0004ü\týÍ7\u0013ýÉ'(þ\tñó&\u0001\tÿ\u0010\u0002Å=\f\u0004ü\týÍ7\u0011ú\u0012\u0001þÿÎ=\n\n¿?\t\nõ\u0011\u0000÷\u000fÆCü\u0000\u0016\u0006\u0001÷\fü\r\n¾P\u0004í\b0\u0007\u0001\n\u0003ù\tûã%\u0001\u0017ö\u0004\u0006\týè-\u0010\u0002Å=\f\u0004ü\týÍ<\u0007\r÷\u0001\u0003\u0016öÍ9\u0010\u0002\u0007\u0003\u0003û\r\n\u0003¿%%\bù\n\u0003÷\u000fè&\u0001\u000b÷ÿ\u0005\u0011¶\u0004%7\u0000õ\u0011\u0000÷\u000fë*ù\nø\u0001\u0013ùþí\u0019\u0010ù\u0006\u0001Õ\u0000\u0001\u0010\u0004\u0000Çÿ?\t\nõ\u0011\u0000÷\u000fÆM\u0000¿(\u0017\u0000\u000fï\u0012\u0001õ ø\fþ\u0013´7\u001fû\u000fõ\u0011æ\u0011\u0016ü\u0010\u0002Å=\f\u0004ü\týÍ9\u0010\u0002\u0004\u0006\u0003ÄK\u0003ù\u0007Æ9\u0010\u0003ù\u0016\u0001\u0004÷\r\n¾\u0017%\u0015\u0005\u0002ó\u0006\u0015ã\u0014\t\u0001\u0003\u0015ûý\u0003ó\u0016\u0011\b÷þ\u0006Ã#6\u0002\u0005ÿ\u0002ê\u0014\t\u0001\u0003\u0015ûý\u0011¶3\u0014\t\u0001\u0003\u0015ûý\u0010\u0002Å=\f\u0004ü\týÍ9\u0013\u000bû\bÿÃJù\t\u0001Ç7\b\u0000\u0007Î\u0017(\u0012Ö \u001b×\u001e\u0018¯\u0011".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 766);
        $$d = bArr;
        $$e = 1;
        $$a = new byte[]{52, -20, 7, -120, 5, -1, -33, 33, -2, -9, 5, -7, 5, -1, -50, 39, Ascii.VT, -7, -12, Ascii.SI, 49, 2, -11, -3, 3, -6, 6, -8, Ascii.VT, -25, 33, -19, 2, 8, -37, 44, -17, Ascii.FF, -8, Ascii.SO, Ascii.ESC, 1, -7, -6, -33, 51, -12, 3, -8, 1, Ascii.CR, -2, Ascii.SI, -33, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, 10, -31, Ascii.DC4, Ascii.CR, -8, -11, -13, Ascii.ESC, -9, Ascii.DC2, -36, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, -7, Ascii.DC2, -43, Ascii.GS, -4, 17, 2, -9, Ascii.DC2, -34, Ascii.EM, 4, -17, 19, -15, -1, -18, Ascii.SI, 19, -11, 5, -7, -2, Ascii.SI, -36, Ascii.NAK, Ascii.CR, -15, 2, 9, 6, -34, Ascii.SI, 19, -11, 5, -7};
        $$b = 75;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        accessartificialFrame();
        b = g.a("NotificationOpenActivity");
    }

    public static Intent a(@NonNull Context context, @NonNull Bundle bundle) {
        return new Intent(context, (Class<?>) NotificationOpenActivity.class).setAction(NotificationManager.ACTION_NOTIFICATION_CLICKED).putExtras(bundle).setFlags(8388608);
    }

    private void b(Context context, Bundle bundle) {
        context.sendBroadcast(new Intent(com.salesforce.marketingcloud.notifications.a.f77n).putExtras(bundle).setPackage(context.getPackageName()));
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
    private static void d(short r5, short r6, byte r7, java.lang.Object[] r8) {
        /*
            byte[] r0 = com.salesforce.marketingcloud.notifications.NotificationOpenActivity.$$a
            int r1 = r7 + 8
            int r6 = r6 + 4
            int r5 = 112 - r5
            byte[] r1 = new byte[r1]
            int r7 = r7 + 7
            r2 = 0
            if (r0 != 0) goto L12
            r3 = r6
            r4 = r2
            goto L24
        L12:
            r3 = r2
        L13:
            byte r4 = (byte) r5
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L22
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L22:
            r3 = r0[r6]
        L24:
            int r6 = r6 + 1
            int r5 = r5 + r3
            r3 = r4
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.notifications.NotificationOpenActivity.d(short, short, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void e(short r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = 728 - r7
            int r0 = 83 - r6
            int r8 = 111 - r8
            byte[] r1 = com.salesforce.marketingcloud.notifications.NotificationOpenActivity.$$d
            byte[] r0 = new byte[r0]
            int r6 = 82 - r6
            r2 = 0
            if (r1 != 0) goto L13
            r4 = r6
            r8 = r7
            r3 = r2
            goto L2b
        L13:
            r3 = r2
        L14:
            r5 = r8
            r8 = r7
            r7 = r5
            byte r4 = (byte) r7
            r0[r3] = r4
            if (r3 != r6) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L24:
            int r3 = r3 + 1
            r4 = r1[r8]
            r5 = r8
            r8 = r7
            r7 = r5
        L2b:
            int r7 = r7 + 1
            int r8 = r8 + r4
            int r8 = r8 + (-4)
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.notifications.NotificationOpenActivity.e(short, int, short, java.lang.Object[]):void");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() == null) {
            a();
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(com.salesforce.marketingcloud.notifications.a.f78o);
        intentFilter.setPriority(999);
        a aVar = new a();
        this.a = aVar;
        ContextCompat.registerReceiver(this, aVar, intentFilter, 4);
        PowerManager.WakeLock wakeLockNewWakeLock = null;
        try {
            try {
                PowerManager powerManager = (PowerManager) getSystemService("power");
                String str = b;
                wakeLockNewWakeLock = powerManager.newWakeLock(1, str);
                wakeLockNewWakeLock.setReferenceCounted(false);
                wakeLockNewWakeLock.acquire(TimeUnit.SECONDS.toMillis(30L));
                if (!j.a(500L, 50L) || MarketingCloudSdk.getInstance() == null) {
                    g.e(str, "MarketingCloudSdk#init must be called in your application's onCreate", new Object[0]);
                } else if (NotificationManager.ACTION_NOTIFICATION_CLICKED.equals(getIntent().getAction())) {
                    b(getApplicationContext(), getIntent().getExtras());
                }
                if (!wakeLockNewWakeLock.isHeld()) {
                    return;
                }
            } catch (Exception e) {
                g.b(b, e, "Encountered exception while handling action: %s", getIntent().getAction());
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

    protected void a() {
        BroadcastReceiver broadcastReceiver = this.a;
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException unused) {
                g.e(b, "com.salesforce.marketingcloud.notifications.open.RECEIVED Receiver is not registered.", new Object[0]);
            }
        }
        if (isFinishing()) {
            return;
        }
        finish();
    }

    private static void c(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        build buildVar = new build();
        char[] cArr2 = new char[cArr.length];
        buildVar.c = 0;
        char[] cArr3 = new char[2];
        while (buildVar.c < cArr.length) {
            int i3 = $10 + 57;
            $11 = i3 % 128;
            int i4 = 58224;
            if (i3 % 2 == 0) {
                cArr3[0] = cArr[buildVar.c];
                cArr3[0] = cArr[buildVar.c];
            } else {
                cArr3[0] = cArr[buildVar.c];
                cArr3[1] = cArr[buildVar.c + 1];
            }
            int i5 = 0;
            while (i5 < 16) {
                char c = cArr3[1];
                char c2 = cArr3[0];
                try {
                    Object[] objArr2 = {Integer.valueOf(c), Integer.valueOf((c2 + i4) ^ ((c2 << 4) + ((char) (((long) extraCallbackWithResult) ^ (-4408183324873663413L))))), Integer.valueOf(c2 >>> 5), Integer.valueOf(onMessageChannelReady)};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1585798252);
                    if (objAccessartificialFrame == null) {
                        byte b2 = (byte) 0;
                        byte b3 = b2;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(27 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 17264), 1066 - TextUtils.indexOf((CharSequence) "", '0', 0), 1042277788, false, $$g(b2, b3, b3), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    char cCharValue = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    cArr3[1] = cCharValue;
                    Object[] objArr3 = {Integer.valueOf(cArr3[0]), Integer.valueOf((cCharValue + i4) ^ ((cCharValue << 4) + ((char) (((long) TopicBuilder) ^ (-4408183324873663413L))))), Integer.valueOf(cCharValue >>> 5), Integer.valueOf(ICustomTabsCallback)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1585798252);
                    if (objAccessartificialFrame2 == null) {
                        byte b4 = (byte) 0;
                        byte b5 = b4;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 29, (char) (17263 - (ViewConfiguration.getMaximumFlingVelocity() >> 16)), 1067 - View.resolveSizeAndState(0, 0, 0), 1042277788, false, $$g(b4, b5, b5), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    cArr3[0] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                    i4 -= 40503;
                    i5++;
                    int i6 = $10 + 25;
                    $11 = i6 % 128;
                    int i7 = i6 % 2;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            cArr2[buildVar.c] = cArr3[0];
            cArr2[buildVar.c + 1] = cArr3[1];
            Object[] objArr4 = {buildVar, buildVar};
            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1010141908);
            if (objAccessartificialFrame3 == null) {
                byte b6 = (byte) 0;
                byte b7 = (byte) (b6 + 1);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getJumpTapTimeout() >> 16) + 25, (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 63927), View.resolveSize(0, 0) + 486, 1554985764, false, $$g(b6, b7, (byte) (b7 - 1)), new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame3).invoke(null, objArr4);
        }
        objArr[0] = new String(cArr2, 0, i);
    }

    /* JADX WARN: Code duplicated, block: B:149:0x0fec  */
    /* JADX WARN: Code duplicated, block: B:153:0x1076  */
    /* JADX WARN: Code duplicated, block: B:158:0x10e6  */
    /* JADX WARN: Code duplicated, block: B:247:0x1a41  */
    /* JADX WARN: Code duplicated, block: B:248:0x1aba  */
    /* JADX WARN: Code duplicated, block: B:24:0x0283  */
    /* JADX WARN: Code duplicated, block: B:251:0x1acd A[Catch: all -> 0x2527, TryCatch #6 {all -> 0x2527, blocks: (B:274:0x1db8, B:276:0x1dcd, B:277:0x1e00, B:249:0x1ac0, B:251:0x1acd, B:252:0x1b02, B:254:0x1b0c, B:256:0x1b19, B:257:0x1b4e, B:107:0x0b9e, B:109:0x0bc1, B:110:0x0c1a, B:71:0x0721, B:73:0x0727, B:74:0x0753, B:76:0x077d, B:77:0x0810), top: B:380:0x0721 }] */
    /* JADX WARN: Code duplicated, block: B:256:0x1b19 A[Catch: all -> 0x2527, TryCatch #6 {all -> 0x2527, blocks: (B:274:0x1db8, B:276:0x1dcd, B:277:0x1e00, B:249:0x1ac0, B:251:0x1acd, B:252:0x1b02, B:254:0x1b0c, B:256:0x1b19, B:257:0x1b4e, B:107:0x0b9e, B:109:0x0bc1, B:110:0x0c1a, B:71:0x0721, B:73:0x0727, B:74:0x0753, B:76:0x077d, B:77:0x0810), top: B:380:0x0721 }] */
    /* JADX WARN: Code duplicated, block: B:263:0x1c42  */
    /* JADX WARN: Code duplicated, block: B:273:0x1d9a  */
    /* JADX WARN: Code duplicated, block: B:276:0x1dcd A[Catch: all -> 0x2527, TryCatch #6 {all -> 0x2527, blocks: (B:274:0x1db8, B:276:0x1dcd, B:277:0x1e00, B:249:0x1ac0, B:251:0x1acd, B:252:0x1b02, B:254:0x1b0c, B:256:0x1b19, B:257:0x1b4e, B:107:0x0b9e, B:109:0x0bc1, B:110:0x0c1a, B:71:0x0721, B:73:0x0727, B:74:0x0753, B:76:0x077d, B:77:0x0810), top: B:380:0x0721 }] */
    /* JADX WARN: Code duplicated, block: B:280:0x1e17  */
    /* JADX WARN: Code duplicated, block: B:285:0x1e85  */
    /* JADX WARN: Code duplicated, block: B:289:0x1edc  */
    /* JADX WARN: Code duplicated, block: B:290:0x1f5d  */
    /* JADX WARN: Code duplicated, block: B:292:0x1f69  */
    /* JADX WARN: Code duplicated, block: B:295:0x1f6d A[LOOP:0: B:293:0x1f6a->B:295:0x1f6d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:301:0x2081  */
    /* JADX WARN: Code duplicated, block: B:311:0x21bb  */
    /* JADX WARN: Code duplicated, block: B:313:0x21c1  */
    /* JADX WARN: Code duplicated, block: B:315:0x2228  */
    /* JADX WARN: Code duplicated, block: B:317:0x222c  */
    /* JADX WARN: Code duplicated, block: B:321:0x2238  */
    /* JADX WARN: Code duplicated, block: B:325:0x22d2  */
    /* JADX WARN: Code duplicated, block: B:327:0x22db  */
    /* JADX WARN: Code duplicated, block: B:332:0x2341  */
    /* JADX WARN: Code duplicated, block: B:338:0x23a0  */
    /* JADX WARN: Code duplicated, block: B:339:0x240b  */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onStart() throws Throwable {
        Object[] objArr;
        Object[] objArr2;
        int i;
        Object[] objArr3;
        int i2;
        Object[] objArr4;
        Object objAccessartificialFrame;
        Object objAccessartificialFrame2;
        int i3;
        Object[] objArr5;
        int i4;
        int i5;
        Object[] objArr6;
        int i6;
        int i7;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        Object objAccessartificialFrame5;
        long j;
        Object objAccessartificialFrame6;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object objAccessartificialFrame7;
        Object objAccessartificialFrame8;
        int i8;
        int i9;
        ArrayList arrayList;
        String[] strArr;
        int i10;
        int i11;
        Object objAccessartificialFrame9;
        long j2;
        Context baseContext;
        Object[] objArr7;
        Object objAccessartificialFrame10;
        Object objAccessartificialFrame11;
        int i12;
        int i13;
        int i14 = 2 % 2;
        Object[] objArr8 = new Object[1];
        c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 18, new char[]{57631, 61071, 36952, 26761, 5232, 31878, 20130, 63362, 14733, 15725, 18217, 60514, 28007, 24679, 5635, 2103, 20858, 57853, 35298, 20729, 7430, 6879}, objArr8);
        String str = (String) objArr8[0];
        Object[] objArr9 = new Object[1];
        c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 20, new char[]{51634, 29782, 12652, 31534, 59157, 53799, 50610, 52678, 59347, 44447, 56995, 45228, 57438, 51892, 56210, 16421}, objArr9);
        String str2 = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 12, new char[]{41507, 24851, 55413, 52357, 56506, 28864, 57631, 61071, 57587, 17809, 39971, 33402, 5586, 53666, 32652, 52968}, objArr10);
        String str3 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        c(16 - Color.blue(0), new char[]{32295, 7395, 46780, 59300, 60778, 12295, 10526, 35859, 26965, 4945, 7929, 14137, 27319, 41952, 27403, 30102}, objArr11);
        String str4 = (String) objArr11[0];
        Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame12 == null) {
            int mirror = 'E' - AndroidCharacter.getMirror('0');
            char cMyPid = (char) (Process.myPid() >> 22);
            int mode = View.MeasureSpec.getMode(0) + 465;
            byte b2 = $$a[41];
            byte b3 = (byte) (b2 - 1);
            Object[] objArr12 = new Object[1];
            d(b3, b3, b2, objArr12);
            objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(mirror, cMyPid, mode, -785931255, false, (String) objArr12[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame12).getLong(null);
        if (j3 == -1 || j3 + 1985 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext2 = getBaseContext();
            if (baseContext2 == null) {
                Object[] objArr13 = new Object[1];
                c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(12) - 73, new char[]{57631, 61071, 36952, 26761, 5232, 31878, 20130, 63362, 12652, 31534, 54301, 17857, 16596, 8428, 60778, 12295, 4863, 44707, 10526, 35859, 42827, 63995, 17151, 15956, 3566, 12072}, objArr13);
                Class<?> cls = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                c((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 18, new char[]{5920, 19153, 54432, 7807, 46780, 59300, 2357, 27956, 59956, 26081, 50825, 56996, 20737, 35954, 60778, 12295, 59104, 18621}, objArr14);
                baseContext2 = (Context) cls.getMethod((String) objArr14[0], new Class[0]).invoke(null, null);
            }
            if (baseContext2 != null) {
                if (!(baseContext2 instanceof ContextWrapper)) {
                    baseContext2 = baseContext2.getApplicationContext();
                } else {
                    int i15 = artificialFrame + 107;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i15 % 128;
                    if (i15 % 2 != 0) {
                        ((ContextWrapper) baseContext2).getBaseContext();
                        throw null;
                    }
                    if (((ContextWrapper) baseContext2).getBaseContext() != null) {
                        baseContext2 = baseContext2.getApplicationContext();
                    } else {
                        baseContext2 = null;
                    }
                }
            }
            int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr15 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(5) - 44, new char[]{7185, 25835, 48045, 44375, 48714, 47481, 47994, 37814, 50532, 14789, 7475, 31756, 3938, 36864, 55094, 54707, 31267, 12738, 7551, 42867, 43891, 32200, 55094, 54707, 18879, 61604, 2600, 29651, 29286, 58872, 15842, 48833, 30350, 58894, 43278, 38671, 55094, 54707, 3556, 54337, 11920, 10649, 30350, 58894, 53933, 19484, 63573, 14059, 49603, 56688, 39446, 9280, 49567, 16001, 63221, 10991, 11920, 10649, 4088, 26912, 57990, 20697, 13239, 12530}, objArr15);
            String str5 = (String) objArr15[0];
            Object[] objArr16 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(12) - 35, new char[]{40914, 41226, 31956, 16357, 15842, 48833, 40072, 14769, 61940, 12522, 32306, 56194, 5700, 31547, 62212, 43187, 50075, 30246, 32854, 49407, 34206, 65307, 7475, 31756, 49567, 16001, 60949, 38318, 51396, 57206, 5501, 27844, 36671, 29037, 14987, 12243, 7475, 31756, 49641, 24822, 8360, 15528, 43000, 41356, 2600, 29651, 48045, 44375, 59555, 32752, 34206, 65307, 41583, 21898, 21095, 29024, 38430, 56824, 22945, 823, 54957, 24095, 15473, 15233}, objArr16);
            try {
                Object[] objArr17 = {baseContext2, new String[]{str5, (String) objArr16[0]}, Integer.valueOf(iIntValue), 1, 1353189583};
                byte[] bArr = $$d;
                Object[] objArr18 = new Object[1];
                e(bArr[115], (short) 724, bArr[73], objArr18);
                Class<?> cls2 = Class.forName((String) objArr18[0]);
                Object[] objArr19 = new Object[1];
                e((byte) (bArr[214] - 1), (short) ($$e | 678), bArr[99], objArr19);
                Object[] objArr20 = (Object[]) cls2.getMethod((String) objArr19[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr17);
                int i16 = ((int[]) objArr20[0])[0];
                int i17 = ((int[]) objArr20[3])[0];
                if (baseContext2 != null) {
                    Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(1142731807);
                    if (objAccessartificialFrame13 == null) {
                        int scrollBarSize = 21 - (ViewConfiguration.getScrollBarSize() >> 8);
                        char cResolveSizeAndState = (char) View.resolveSizeAndState(0, 0, 0);
                        int iArgb = Color.argb(0, 0, 0, 0) + 465;
                        byte[] bArr2 = $$a;
                        byte b4 = bArr2[41];
                        Object[] objArr21 = new Object[1];
                        d((byte) (b4 - 1), bArr2[33], b4, objArr21);
                        objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(scrollBarSize, cResolveSizeAndState, iArgb, -612765161, false, (String) objArr21[0], null);
                    }
                    ((Field) objAccessartificialFrame13).set(null, objArr20);
                    try {
                        Long lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(1313006081);
                        if (objAccessartificialFrame14 == null) {
                            int doubleTapTimeout = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 21;
                            char cLastIndexOf = (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1);
                            int packedPositionChild = ExpandableListView.getPackedPositionChild(0L) + 466;
                            byte b5 = $$a[41];
                            byte b6 = (byte) (b5 - 1);
                            Object[] objArr22 = new Object[1];
                            d(b6, b6, b5, objArr22);
                            objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout, cLastIndexOf, packedPositionChild, -785931255, false, (String) objArr22[0], null);
                        }
                        ((Field) objAccessartificialFrame14).set(null, lValueOf);
                    } catch (Exception unused) {
                        throw new RuntimeException();
                    }
                } else {
                    objArr20 = objArr20;
                }
                objArr = objArr20;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        } else {
            Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1142731807);
            if (objAccessartificialFrame15 == null) {
                int pressedStateDuration = 21 - (ViewConfiguration.getPressedStateDuration() >> 16);
                char keyRepeatDelay = (char) (ViewConfiguration.getKeyRepeatDelay() >> 16);
                int scrollBarSize2 = (ViewConfiguration.getScrollBarSize() >> 8) + 465;
                byte[] bArr3 = $$a;
                byte b7 = bArr3[41];
                Object[] objArr23 = new Object[1];
                d((byte) (b7 - 1), bArr3[33], b7, objArr23);
                objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(pressedStateDuration, keyRepeatDelay, scrollBarSize2, -612765161, false, (String) objArr23[0], null);
            }
            Object[] objArr24 = (Object[]) ((Field) objAccessartificialFrame15).get(null);
            objArr = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
            int i18 = ((int[]) objArr24[3])[0];
            int i19 = ((int[]) objArr24[0])[0];
            String[] strArr2 = (String[]) objArr24[1];
            int i20 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().smallestScreenWidthDp;
            int i21 = ~i20;
            int i22 = (~(157054586 | i21)) | (-469726971) | (~(317404312 | i21));
            int i23 = (-597526445) + (((~(i20 | (-4731929))) | i22) * 590) + (i22 * (-1180)) + (((~((-317404313) | i21)) | (~(i21 | (-157054587)))) * 590) + 1353189583;
            int i24 = (i23 << 13) ^ i23;
            int i25 = i24 ^ (i24 >>> 17);
            ((int[]) objArr[2])[0] = i25 ^ (i25 << 5);
        }
        int i26 = ((int[]) objArr[0])[0];
        int i27 = ((int[]) objArr[3])[0];
        if (i27 == i26) {
            Object[] objArr25 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i28 = ((int[]) objArr[2])[0];
            int i29 = ((int[]) objArr[3])[0];
            int i30 = ((int[]) objArr[0])[0];
            String[] strArr3 = (String[]) objArr[1];
            int i31 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().densityDpi;
            int i32 = ~i31;
            int i33 = i28 + 239047048 + ((~(82187893 | i32)) * 979) + ((i31 | 242537619) * (-979)) + (((~(i31 | 82187893)) | (~(i32 | 242537619))) * 979);
            int i34 = (i33 << 13) ^ i33;
            int i35 = i34 ^ (i34 >>> 17);
            ((int[]) objArr25[2])[0] = i35 ^ (i35 << 5);
        } else {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr4 = (String[]) objArr[1];
            if (strArr4 != null) {
                int i36 = getARTIFICIAL_FRAME_PACKAGE_NAME + 43;
                artificialFrame = i36 % 128;
                int i37 = i36 % 2;
                for (String str6 : strArr4) {
                    arrayList2.add(str6);
                }
            }
            try {
                Object[] objArr26 = {Long.valueOf(((long) (i26 ^ i27)) ^ (((long) 1347335212) << 32)), Long.valueOf(1347335276)};
                byte[] bArr4 = $$d;
                byte b8 = bArr4[39];
                Object[] objArr27 = new Object[1];
                e(b8, (short) (b8 | 642), bArr4[73], objArr27);
                Class<?> cls3 = Class.forName((String) objArr27[0]);
                byte b9 = bArr4[508];
                Object[] objArr28 = new Object[1];
                e(b9, (short) (b9 | Ascii.STX), bArr4[154], objArr28);
                cls3.getMethod((String) objArr28[0], Long.TYPE, Long.TYPE).invoke(null, objArr26);
                Object[] objArr29 = {new int[]{i}, strArr, new int[1], new int[]{i}};
                int i38 = ((int[]) objArr[2])[0];
                int i39 = ((int[]) objArr[3])[0];
                int i40 = ((int[]) objArr[0])[0];
                String[] strArr5 = (String[]) objArr[1];
                int ringerMode = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getRingerMode();
                int i41 = ~ringerMode;
                int i42 = i38 + (-273849032) + (((~(498728185 | i41)) | (-1073348608)) * 98) + (((~(i41 | (-659077912))) | 498728185 | (~(659077911 | ringerMode))) * (-49)) + (((~(ringerMode | 498728185)) | 414270696) * 49);
                int i43 = (i42 << 13) ^ i42;
                int i44 = i43 ^ (i43 >>> 17);
                ((int[]) objArr29[2])[0] = i44 ^ (i44 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame16 == null) {
            int i45 = 37 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
            char c = (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
            int iResolveOpacity = 540 - Drawable.resolveOpacity(0, 0);
            byte b10 = $$a[41];
            byte b11 = (byte) (b10 - 1);
            Object[] objArr30 = new Object[1];
            d(b11, b11, b10, objArr30);
            objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(i45, c, iResolveOpacity, 624296913, false, (String) objArr30[0], null);
        }
        long j4 = ((Field) objAccessartificialFrame16).getLong(null);
        if (j4 == -1 || j4 + 1863 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            try {
                Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-1717965552);
                if (objAccessartificialFrame17 == null) {
                    objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(TextUtils.getTrimmedLength("") + 20, (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 39517), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 981, 117222168, false, null, new Class[0]);
                }
                Object[] objArr31 = {null, ((Constructor) objAccessartificialFrame17).newInstance(null), 1299146560, 0};
                Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-501205803);
                if (objAccessartificialFrame18 == null) {
                    int minimumFlingVelocity = 36 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                    char c2 = (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                    int i46 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 539;
                    byte[] bArr5 = $$a;
                    Object[] objArr32 = new Object[1];
                    d((byte) 47, (byte) (bArr5[56] - 1), bArr5[50], objArr32);
                    objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity, c2, i46, 2101703389, false, (String) objArr32[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(54 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (((Process.getThreadPriority(0) + 20) >> 6) + 833), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 576), (Class) ArtificialStackFrames.coroutineCreation((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 54, (char) Color.green(0), 630 - (ViewConfiguration.getKeyRepeatDelay() >> 16)), Integer.TYPE, Integer.TYPE});
                }
                Object[] objArr33 = (Object[]) ((Method) objAccessartificialFrame18).invoke(null, objArr31);
                Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                if (objAccessartificialFrame19 == null) {
                    int deadChar = KeyEvent.getDeadChar(0, 0) + 36;
                    char cGreen = (char) Color.green(0);
                    int fadingEdgeLength = 540 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                    byte[] bArr6 = $$a;
                    byte b12 = bArr6[41];
                    Object[] objArr34 = new Object[1];
                    d((byte) (b12 - 1), bArr6[33], b12, objArr34);
                    objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(deadChar, cGreen, fadingEdgeLength, 793268735, false, (String) objArr34[0], null);
                }
                ((Field) objAccessartificialFrame19).set(null, objArr33);
                try {
                    Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                    if (objAccessartificialFrame20 == null) {
                        int i47 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 36;
                        char offsetBefore = (char) TextUtils.getOffsetBefore("", 0);
                        int i48 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 539;
                        byte b13 = $$a[41];
                        byte b14 = (byte) (b13 - 1);
                        Object[] objArr35 = new Object[1];
                        d(b14, b14, b13, objArr35);
                        objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(i47, offsetBefore, i48, 624296913, false, (String) objArr35[0], null);
                    }
                    ((Field) objAccessartificialFrame20).set(null, lValueOf2);
                    objArr2 = objArr33;
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
        } else {
            Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame21 == null) {
                int deadChar2 = KeyEvent.getDeadChar(0, 0) + 36;
                char c3 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                int iResolveSize = 540 - View.resolveSize(0, 0);
                byte[] bArr7 = $$a;
                byte b15 = bArr7[41];
                Object[] objArr36 = new Object[1];
                d((byte) (b15 - 1), bArr7[33], b15, objArr36);
                objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(deadChar2, c3, iResolveSize, 793268735, false, (String) objArr36[0], null);
            }
            Object[] objArr37 = (Object[]) ((Field) objAccessartificialFrame21).get(null);
            objArr2 = new Object[]{new int[1], new int[1], new int[1]};
            int i49 = ((int[]) objArr37[2])[0];
            int i50 = ((int[]) objArr37[1])[0];
            ((int[]) objArr2[2])[0] = i49;
            ((int[]) objArr2[1])[0] = i50;
            int iIdentityHashCode = System.identityHashCode(this);
            int i51 = (-52014947) + (((-1326441334) | iIdentityHashCode) * 376) + (((~((~iIdentityHashCode) | 113835173)) | (-1339031542)) * (-376)) + (((~(iIdentityHashCode | (-113835174))) | 1237786576) * 376) + 1299146560;
            int i52 = (i51 << 13) ^ i51;
            int i53 = i52 ^ (i52 >>> 17);
            ((int[]) objArr2[0])[0] = i53 ^ (i53 << 5);
        }
        Object obj = objArr2[1];
        int i54 = ((int[]) obj)[0];
        Object obj2 = objArr2[2];
        int i55 = ((int[]) obj2)[0];
        if (i55 == i54) {
            Object[] objArr38 = {new int[1], new int[1], new int[1]};
            int i56 = ((int[]) objArr2[0])[0];
            int i57 = ((int[]) obj2)[0];
            int i58 = ((int[]) obj)[0];
            ((int[]) objArr38[2])[0] = i57;
            ((int[]) objArr38[1])[0] = i58;
            int i59 = ~System.identityHashCode(this);
            int i60 = i56 + (-1594496042) + (((~((-486587902) | i59)) | (-865033849)) * (-983)) + (((~(i59 | (-865033849))) | 579813888) * 983);
            int i61 = (i60 << 13) ^ i60;
            int i62 = i61 ^ (i61 >>> 17);
            ((int[]) objArr38[0])[0] = i62 ^ (i62 << 5);
            i = 0;
        } else {
            Object[] objArr39 = {Long.valueOf(((long) (i54 ^ i55)) ^ (((long) 367543934) << 32)), Long.valueOf(367548030)};
            byte[] bArr8 = $$d;
            byte b16 = bArr8[4];
            Object[] objArr40 = new Object[1];
            e(b16, (short) (b16 | SignedBytes.MAX_POWER_OF_TWO), bArr8[73], objArr40);
            Class<?> cls4 = Class.forName((String) objArr40[0]);
            byte b17 = bArr8[508];
            Object[] objArr41 = new Object[1];
            e(b17, (short) (b17 | Ascii.STX), bArr8[154], objArr41);
            cls4.getMethod((String) objArr41[0], Long.TYPE, Long.TYPE).invoke(null, objArr39);
            Object[] objArr42 = {new int[1], new int[1], new int[1]};
            int i63 = ((int[]) objArr2[0])[0];
            int i64 = ((int[]) objArr2[2])[0];
            int i65 = ((int[]) objArr2[1])[0];
            ((int[]) objArr42[2])[0] = i64;
            ((int[]) objArr42[1])[0] = i65;
            int i66 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().orientation;
            int i67 = i63 + ((((-68778521) + (((~i66) | 303071384) * 1324)) + (((~(i66 | 842567833)) | (~(509053916 | i66))) * (-1324))) - 414153618);
            int i68 = (i67 << 13) ^ i67;
            int i69 = i68 ^ (i68 >>> 17);
            i = 0;
            ((int[]) objArr42[0])[0] = i69 ^ (i69 << 5);
        }
        Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame22 == null) {
            int i70 = (ExpandableListView.getPackedPositionForGroup(i) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(i) == 0L ? 0 : -1)) + 25;
            char scrollBarFadeDuration = (char) (30068 - (ViewConfiguration.getScrollBarFadeDuration() >> 16));
            int windowTouchSlop = (ViewConfiguration.getWindowTouchSlop() >> 8) + 816;
            byte b18 = $$a[41];
            byte b19 = (byte) (b18 - 1);
            Object[] objArr43 = new Object[1];
            d(b19, b19, b18, objArr43);
            objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(i70, scrollBarFadeDuration, windowTouchSlop, 721586079, false, (String) objArr43[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame22).getLong(null);
        if (j5 == -1 || j5 + 1950 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr44 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 811388670};
            Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame23 == null) {
                int touchSlop = (ViewConfiguration.getTouchSlop() >> 8) + 25;
                char cIndexOf = (char) (30067 - TextUtils.indexOf((CharSequence) "", '0', 0, 0));
                int iAxisFromString = MotionEvent.axisFromString("") + 817;
                byte[] bArr9 = $$a;
                Object[] objArr45 = new Object[1];
                d((byte) (bArr9[86] - 1), (byte) (-bArr9[73]), bArr9[94], objArr45);
                objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(touchSlop, cIndexOf, iAxisFromString, -797394565, false, (String) objArr45[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr3 = (Object[]) ((Method) objAccessartificialFrame23).invoke(null, objArr44);
            Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame24 == null) {
                int i71 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 24;
                char c4 = (char) (30067 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                int i72 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 815;
                byte[] bArr10 = $$a;
                byte b20 = bArr10[41];
                Object[] objArr46 = new Object[1];
                d((byte) (b20 - 1), bArr10[33], b20, objArr46);
                objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(i71, c4, i72, 891606461, false, (String) objArr46[0], null);
            }
            ((Field) objAccessartificialFrame24).set(null, objArr3);
            try {
                Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame25 == null) {
                    int packedPositionGroup = ExpandableListView.getPackedPositionGroup(0L) + 25;
                    char bitsPerPixel = (char) (30067 - ImageFormat.getBitsPerPixel(0));
                    int iIndexOf = 815 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                    byte b21 = $$a[41];
                    byte b22 = (byte) (b21 - 1);
                    Object[] objArr47 = new Object[1];
                    d(b22, b22, b21, objArr47);
                    objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(packedPositionGroup, bitsPerPixel, iIndexOf, 721586079, false, (String) objArr47[0], null);
                }
                ((Field) objAccessartificialFrame25).set(null, lValueOf3);
            } catch (Exception unused3) {
                throw new RuntimeException();
            }
        } else {
            int i73 = getARTIFICIAL_FRAME_PACKAGE_NAME + 45;
            artificialFrame = i73 % 128;
            int i74 = i73 % 2;
            Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame26 == null) {
                int modifierMetaStateMask = 24 - ((byte) KeyEvent.getModifierMetaStateMask());
                char c5 = (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 30069);
                int iRed = 816 - Color.red(0);
                byte[] bArr11 = $$a;
                byte b23 = bArr11[41];
                Object[] objArr48 = new Object[1];
                d((byte) (b23 - 1), bArr11[33], b23, objArr48);
                objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask, c5, iRed, 891606461, false, (String) objArr48[0], null);
            }
            Object[] objArr49 = (Object[]) ((Field) objAccessartificialFrame26).get(null);
            objArr3 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i75 = ((int[]) objArr49[0])[0];
            int i76 = ((int[]) objArr49[1])[0];
            String[] strArr6 = (String[]) objArr49[2];
            int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 1498939612;
            int i77 = ~length;
            int i78 = ((((~(i77 | (-560368259))) | ((~((-758540625) | i77)) | 556140544)) * (-397)) - 1925475068) + ((length | (-206627795)) * 397) + 811388670;
            int i79 = (i78 << 13) ^ i78;
            int i80 = i79 ^ (i79 >>> 17);
            ((int[]) objArr3[3])[0] = i80 ^ (i80 << 5);
        }
        int i81 = ((int[]) objArr3[1])[0];
        int i82 = ((int[]) objArr3[0])[0];
        if (i82 == i81) {
            Object[] objArr50 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i83 = ((int[]) objArr3[3])[0];
            int i84 = ((int[]) objArr3[0])[0];
            int i85 = ((int[]) objArr3[1])[0];
            String[] strArr7 = (String[]) objArr3[2];
            int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
            int i86 = (-1477938569) + ((iFreeMemory | 254123765) * (-50));
            int i87 = ~((-203431633) | iFreeMemory);
            int i88 = ~iFreeMemory;
            int i89 = i83 + i86 + ((i87 | (~(259383031 | i88))) * 50) + (((~(i88 | 254123765)) | (~(55951399 | i88)) | (-259383032)) * 50);
            int i90 = (i89 << 13) ^ i89;
            int i91 = i90 ^ (i90 >>> 17);
            i2 = 0;
            ((int[]) objArr50[3])[0] = i91 ^ (i91 << 5);
        } else {
            ArrayList arrayList3 = new ArrayList();
            String[] strArr8 = (String[]) objArr3[2];
            if (strArr8 != null) {
                for (String str7 : strArr8) {
                    arrayList3.add(str7);
                }
            }
            Object[] objArr51 = {Long.valueOf((((long) 701776237) << 32) ^ ((long) (i81 ^ i82))), Long.valueOf(701776236)};
            byte[] bArr12 = $$d;
            Object[] objArr52 = new Object[1];
            e(bArr12[52], (short) 526, bArr12[73], objArr52);
            Class<?> cls5 = Class.forName((String) objArr52[0]);
            byte b24 = bArr12[508];
            Object[] objArr53 = new Object[1];
            e(b24, (short) (b24 | Ascii.STX), bArr12[154], objArr53);
            cls5.getMethod((String) objArr53[0], Long.TYPE, Long.TYPE).invoke(null, objArr51);
            Object[] objArr54 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i92 = ((int[]) objArr3[3])[0];
            int i93 = ((int[]) objArr3[0])[0];
            int i94 = ((int[]) objArr3[1])[0];
            String[] strArr9 = (String[]) objArr3[2];
            int iNextInt = new Random().nextInt(1160894996);
            int i95 = i92 + (-2104139724) + ((~((-4392961) | iNextInt)) * 623) + (((~iNextInt) | 193729673) * (-623)) + (((~(iNextInt | 193754539)) | (~((-4417827) | iNextInt)) | 4392960) * 623);
            int i96 = (i95 << 13) ^ i95;
            int i97 = i96 ^ (i96 >>> 17);
            i2 = 0;
            ((int[]) objArr54[3])[0] = i97 ^ (i97 << 5);
        }
        Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame27 == null) {
            int iResolveSizeAndState = 30 - View.resolveSizeAndState(i2, i2, i2);
            char c6 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 49361);
            int iKeyCodeFromString = KeyEvent.keyCodeFromString("") + 684;
            byte[] bArr13 = $$a;
            byte b25 = bArr13[112];
            Object[] objArr55 = new Object[1];
            d(b25, (byte) (b25 | 38), bArr13[4], objArr55);
            objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState, c6, iKeyCodeFromString, -1583976536, false, (String) objArr55[0], null);
        }
        long j6 = ((Field) objAccessartificialFrame27).getLong(null);
        if (j6 != -1) {
            int i98 = artificialFrame + 115;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i98 % 128;
            if (i98 % 2 == 0 ? j6 + 1878 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue() : (j6 ^ 1878) < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object[] objArr56 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -1010417159};
                byte[] bArr14 = $$d;
                Object[] objArr57 = new Object[1];
                e(bArr14[36], (short) 462, bArr14[73], objArr57);
                Class<?> cls6 = Class.forName((String) objArr57[0]);
                Object[] objArr58 = new Object[1];
                e(bArr14[2], (short) ($$e | TypedValues.CycleType.TYPE_VISIBILITY), bArr14[73], objArr58);
                objArr4 = (Object[]) cls6.getMethod((String) objArr58[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr56);
                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame == null) {
                    int mirror2 = AndroidCharacter.getMirror('0') - 18;
                    char scrollDefaultDelay = (char) (49362 - (ViewConfiguration.getScrollDefaultDelay() >> 16));
                    int iRgb = Color.rgb(0, 0, 0) + 16777900;
                    byte[] bArr15 = $$a;
                    Object[] objArr59 = new Object[1];
                    d(bArr15[2], (byte) 59, bArr15[41], objArr59);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(mirror2, scrollDefaultDelay, iRgb, -1456483158, false, (String) objArr59[0], null);
                }
                ((Field) objAccessartificialFrame).set(null, objArr4);
                try {
                    Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1056123296);
                    if (objAccessartificialFrame2 == null) {
                        int defaultSize = 30 - View.getDefaultSize(0, 0);
                        char c7 = (char) (49363 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
                        int iIndexOf2 = TextUtils.indexOf("", "", 0) + 684;
                        byte[] bArr16 = $$a;
                        byte b26 = bArr16[112];
                        Object[] objArr60 = new Object[1];
                        d(b26, (byte) (b26 | 38), bArr16[4], objArr60);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(defaultSize, c7, iIndexOf2, -1583976536, false, (String) objArr60[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, lValueOf4);
                } catch (Exception unused4) {
                    throw new RuntimeException();
                }
            } else {
                Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame28 == null) {
                    int keyRepeatTimeout = 30 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                    char deadChar3 = (char) (KeyEvent.getDeadChar(0, 0) + 49362);
                    int touchSlop2 = 684 - (ViewConfiguration.getTouchSlop() >> 8);
                    byte[] bArr17 = $$a;
                    Object[] objArr61 = new Object[1];
                    d(bArr17[2], (byte) 59, bArr17[41], objArr61);
                    objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout, deadChar3, touchSlop2, -1456483158, false, (String) objArr61[0], null);
                }
                Object[] objArr62 = (Object[]) ((Field) objAccessartificialFrame28).get(null);
                objArr4 = new Object[]{new int[]{((int[]) objArr62[0])[0]}, new int[]{((int[]) objArr62[1])[0]}, new int[1], (String) objArr62[3]};
                int streamVolume = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getStreamVolume(3);
                int i99 = ~streamVolume;
                int i100 = (-1025164404) + (((~(170669717 | i99)) | 805322760) * (-1188));
                int i101 = (~(streamVolume | (-170669718))) | 805322760;
                int i102 = ~(807954057 | i99);
                int i103 = ((i100 + ((i101 | i102) * 594)) + ((((~((-170669718) | i99)) | 168038420) | i102) * 594)) - 1010417159;
                int i104 = (i103 << 13) ^ i103;
                int i105 = i104 ^ (i104 >>> 17);
                ((int[]) objArr4[2])[0] = i105 ^ (i105 << 5);
            }
        } else {
            Object[] objArr510 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -1010417159};
            byte[] bArr18 = $$d;
            Object[] objArr511 = new Object[1];
            e(bArr18[36], (short) 462, bArr18[73], objArr511);
            Class<?> cls7 = Class.forName((String) objArr511[0]);
            Object[] objArr512 = new Object[1];
            e(bArr18[2], (short) ($$e | TypedValues.CycleType.TYPE_VISIBILITY), bArr18[73], objArr512);
            objArr4 = (Object[]) cls7.getMethod((String) objArr512[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr510);
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame == null) {
                int mirror3 = AndroidCharacter.getMirror('0') - 18;
                char scrollDefaultDelay2 = (char) (49362 - (ViewConfiguration.getScrollDefaultDelay() >> 16));
                int iRgb2 = Color.rgb(0, 0, 0) + 16777900;
                byte[] bArr19 = $$a;
                Object[] objArr513 = new Object[1];
                d(bArr19[2], (byte) 59, bArr19[41], objArr513);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(mirror3, scrollDefaultDelay2, iRgb2, -1456483158, false, (String) objArr513[0], null);
            }
            ((Field) objAccessartificialFrame).set(null, objArr4);
            Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1056123296);
            if (objAccessartificialFrame2 == null) {
                int defaultSize2 = 30 - View.getDefaultSize(0, 0);
                char c8 = (char) (49363 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
                int iIndexOf3 = TextUtils.indexOf("", "", 0) + 684;
                byte[] bArr110 = $$a;
                byte b27 = bArr110[112];
                Object[] objArr63 = new Object[1];
                d(b27, (byte) (b27 | 38), bArr110[4], objArr63);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(defaultSize2, c8, iIndexOf3, -1583976536, false, (String) objArr63[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, lValueOf5);
        }
        int i106 = ((int[]) objArr4[1])[0];
        int i107 = ((int[]) objArr4[0])[0];
        if (i107 == i106) {
            int i108 = ((int[]) objArr4[2])[0];
            Object[] objArr64 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
            int length2 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 1760634754;
            int i109 = i108 + (-1639129168) + (((~((-23122448) | length2)) | 6341135) * 345) + (((~((-23122448) | (~length2))) | 949160192) * 345) + ((~(length2 | (-6341136))) * 345);
            int i110 = (i109 << 13) ^ i109;
            int i111 = i110 ^ (i110 >>> 17);
            i3 = 0;
            ((int[]) objArr64[2])[0] = i111 ^ (i111 << 5);
        } else {
            new ArrayList().add((String) objArr4[3]);
            Object[] objArr65 = {Long.valueOf(((long) (i106 ^ i107)) ^ (((long) (-1093841363)) << 32)), Long.valueOf(-1093841347)};
            byte[] bArr20 = $$d;
            Object[] objArr66 = new Object[1];
            e(bArr20[65], (short) ($$e | 386), bArr20[73], objArr66);
            Class<?> cls8 = Class.forName((String) objArr66[0]);
            byte b28 = bArr20[508];
            Object[] objArr67 = new Object[1];
            e(b28, (short) (b28 | Ascii.STX), bArr20[154], objArr67);
            cls8.getMethod((String) objArr67[0], Long.TYPE, Long.TYPE).invoke(null, objArr65);
            int i112 = ((int[]) objArr4[2])[0];
            Object[] objArr68 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i113 = i112 + (-223261262) + (((~(iIdentityHashCode2 | 958482575)) | (-20141200)) * (-668)) + ((958482575 | (~((-20141200) | iIdentityHashCode2))) * 1336) + ((iIdentityHashCode2 | (-1184769)) * 668);
            int i114 = (i113 << 13) ^ i113;
            int i115 = i114 ^ (i114 >>> 17);
            i3 = 0;
            ((int[]) objArr68[2])[0] = i115 ^ (i115 << 5);
        }
        Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame29 == null) {
            int packedPositionGroup2 = ExpandableListView.getPackedPositionGroup(0L) + 30;
            char cLastIndexOf2 = (char) (TextUtils.lastIndexOf("", '0', i3) + 49363);
            int iLastIndexOf = 683 - TextUtils.lastIndexOf("", '0', i3, i3);
            byte[] bArr21 = $$a;
            byte b29 = bArr21[21];
            Object[] objArr69 = new Object[1];
            d(b29, (byte) (b29 | 65), bArr21[4], objArr69);
            objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(packedPositionGroup2, cLastIndexOf2, iLastIndexOf, 508509282, false, (String) objArr69[0], null);
        }
        long j7 = ((Field) objAccessartificialFrame29).getLong(null);
        if (j7 == -1 || j7 + 2012 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext3 = getBaseContext();
            if (baseContext3 == null) {
                Object[] objArr70 = new Object[1];
                c((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 27, new char[]{57631, 61071, 36952, 26761, 5232, 31878, 20130, 63362, 12652, 31534, 54301, 17857, 16596, 8428, 60778, 12295, 4863, 44707, 10526, 35859, 42827, 63995, 17151, 15956, 3566, 12072}, objArr70);
                Class<?> cls9 = Class.forName((String) objArr70[0]);
                Object[] objArr71 = new Object[1];
                c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 97, new char[]{5920, 19153, 54432, 7807, 46780, 59300, 2357, 27956, 59956, 26081, 50825, 56996, 20737, 35954, 60778, 12295, 59104, 18621}, objArr71);
                baseContext3 = (Context) cls9.getMethod((String) objArr71[0], new Class[0]).invoke(null, null);
            }
            if (baseContext3 != null) {
                int i116 = artificialFrame + 83;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i116 % 128;
                int i117 = i116 % 2;
                baseContext3 = ((baseContext3 instanceof ContextWrapper) && ((ContextWrapper) baseContext3).getBaseContext() == null) ? null : baseContext3.getApplicationContext();
            }
            Object[] objArr72 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 1351761597};
            byte[] bArr22 = $$d;
            byte b30 = bArr22[4];
            int i118 = $$e;
            Object[] objArr73 = new Object[1];
            e(b30, (short) (i118 | 352), bArr22[73], objArr73);
            Class<?> cls10 = Class.forName((String) objArr73[0]);
            Object[] objArr74 = new Object[1];
            e((byte) (bArr22[214] - 1), (short) (i118 | 678), bArr22[99], objArr74);
            objArr5 = (Object[]) cls10.getMethod((String) objArr74[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr72);
            if (baseContext3 != null) {
                Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame30 == null) {
                    int doubleTapTimeout2 = 30 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                    char cIndexOf2 = (char) (49361 - TextUtils.indexOf((CharSequence) "", '0'));
                    int capsMode = 684 - TextUtils.getCapsMode("", 0, 0);
                    byte[] bArr23 = $$a;
                    byte b31 = bArr23[33];
                    Object[] objArr75 = new Object[1];
                    d(b31, (byte) (b31 | 71), (byte) (bArr23[41] - 1), objArr75);
                    objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout2, cIndexOf2, capsMode, -1321816393, false, (String) objArr75[0], null);
                }
                ((Field) objAccessartificialFrame30).set(null, objArr5);
                try {
                    Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                    if (objAccessartificialFrame31 == null) {
                        int fadingEdgeLength2 = 30 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                        char tapTimeout = (char) (49362 - (ViewConfiguration.getTapTimeout() >> 16));
                        int jumpTapTimeout = (ViewConfiguration.getJumpTapTimeout() >> 16) + 684;
                        byte[] bArr24 = $$a;
                        byte b32 = bArr24[21];
                        Object[] objArr76 = new Object[1];
                        d(b32, (byte) (b32 | 65), bArr24[4], objArr76);
                        objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength2, tapTimeout, jumpTapTimeout, 508509282, false, (String) objArr76[0], null);
                    }
                    ((Field) objAccessartificialFrame31).set(null, lValueOf6);
                } catch (Exception unused5) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(777251007);
            if (objAccessartificialFrame32 == null) {
                int i119 = 31 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                char cIndexOf3 = (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 49363);
                int packedPositionGroup3 = ExpandableListView.getPackedPositionGroup(0L) + 684;
                byte[] bArr25 = $$a;
                byte b33 = bArr25[33];
                Object[] objArr77 = new Object[1];
                d(b33, (byte) (b33 | 71), (byte) (bArr25[41] - 1), objArr77);
                objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(i119, cIndexOf3, packedPositionGroup3, -1321816393, false, (String) objArr77[0], null);
            }
            Object[] objArr78 = (Object[]) ((Field) objAccessartificialFrame32).get(null);
            objArr5 = new Object[]{new int[]{((int[]) objArr78[0])[0]}, new int[]{((int[]) objArr78[1])[0]}, new int[1], (String) objArr78[3]};
            int i120 = ~(System.identityHashCode(this) | 818332567);
            int i121 = (((809632272 | i120) * (-196)) - 952498686) + ((i120 | 8700295) * 196) + 1351761597;
            int i122 = (i121 << 13) ^ i121;
            int i123 = i122 ^ (i122 >>> 17);
            ((int[]) objArr5[2])[0] = i123 ^ (i123 << 5);
        }
        int i124 = ((int[]) objArr5[1])[0];
        int i125 = ((int[]) objArr5[0])[0];
        if (i125 == i124) {
            int i126 = ((int[]) objArr5[2])[0];
            Object[] objArr79 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
            int i127 = ~startElapsedRealtime;
            int i128 = (~((-545732434) | i127)) | 537006608;
            int i129 = ~(startElapsedRealtime | (-424165517));
            int i130 = i126 + (-170056254) + ((i128 | i129) * (-713)) + (i129 * 1426) + ((~((-432891342) | i127)) * 713);
            int i131 = (i130 << 13) ^ i130;
            int i132 = i131 ^ (i131 >>> 17);
            i4 = 0;
            ((int[]) objArr79[2])[0] = i132 ^ (i132 << 5);
        } else {
            Object[] objArr80 = {Long.valueOf((((long) (-1888999650)) << 32) ^ ((long) (i124 ^ i125))), Long.valueOf(-1889000162)};
            byte[] bArr26 = $$d;
            Object[] objArr81 = new Object[1];
            e((byte) (-bArr26[14]), (short) ($$e | 286), bArr26[73], objArr81);
            Class<?> cls11 = Class.forName((String) objArr81[0]);
            byte b34 = bArr26[508];
            Object[] objArr82 = new Object[1];
            e(b34, (short) (b34 | Ascii.STX), bArr26[154], objArr82);
            cls11.getMethod((String) objArr82[0], Long.TYPE, Long.TYPE).invoke(null, objArr80);
            int i133 = ((int[]) objArr5[2])[0];
            Object[] objArr83 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int iIdentityHashCode3 = System.identityHashCode(this);
            int i134 = i133 + 449826570 + (((~(iIdentityHashCode3 | 353093333)) | (-625530442)) * (-668)) + ((353093333 | (~((-625530442) | iIdentityHashCode3))) * 1336) + ((iIdentityHashCode3 | (-541069321)) * 668);
            int i135 = (i134 << 13) ^ i134;
            int i136 = i135 ^ (i135 >>> 17);
            i4 = 0;
            ((int[]) objArr83[2])[0] = i136 ^ (i136 << 5);
        }
        super.onStart();
        Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame33 == null) {
            int i137 = (TypedValue.complexToFloat(i4) > 0.0f ? 1 : (TypedValue.complexToFloat(i4) == 0.0f ? 0 : -1)) + 17;
            char cResolveOpacity = (char) Drawable.resolveOpacity(i4, i4);
            int i138 = (TypedValue.complexToFraction(i4, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(i4, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 747;
            byte b35 = $$a[41];
            byte b36 = (byte) (b35 - 1);
            Object[] objArr84 = new Object[1];
            d(b36, b36, b35, objArr84);
            objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(i137, cResolveOpacity, i138, -144068856, false, (String) objArr84[0], null);
        }
        long j8 = ((Field) objAccessartificialFrame33).getLong(null);
        try {
            if (j8 != -1) {
                if (j8 + 4611686018427387942L >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(1575402270);
                    if (objAccessartificialFrame34 == null) {
                        int bitsPerPixel2 = 16 - ImageFormat.getBitsPerPixel(0);
                        char cAxisFromString = (char) (MotionEvent.axisFromString("") + 1);
                        int modifierMetaStateMask2 = ((byte) KeyEvent.getModifierMetaStateMask()) + 748;
                        byte[] bArr27 = $$a;
                        byte b37 = bArr27[41];
                        Object[] objArr85 = new Object[1];
                        d((byte) (b37 - 1), bArr27[33], b37, objArr85);
                        objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(bitsPerPixel2, cAxisFromString, modifierMetaStateMask2, -1031537386, false, (String) objArr85[0], null);
                    }
                    Object[] objArr86 = (Object[]) ((Field) objAccessartificialFrame34).get(null);
                    objArr6 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
                    int i139 = ((int[]) objArr86[3])[0];
                    int i140 = ((int[]) objArr86[4])[0];
                    List list = (List) objArr86[0];
                    List list2 = (List) objArr86[2];
                    int iIdentityHashCode4 = System.identityHashCode(this);
                    int i141 = (((~(iIdentityHashCode4 | 1000355690)) | (-394907233)) * 56) + 1561046801 + (((~((~iIdentityHashCode4) | (-394907233))) | 1000355690) * 56) + 863906511;
                    int i142 = (i141 << 13) ^ i141;
                    int i143 = i142 ^ (i142 >>> 17);
                    ((int[]) objArr6[1])[0] = i143 ^ (i143 << 5);
                } else {
                    i5 = 0;
                }
                i6 = ((int[]) objArr6[4])[0];
                i7 = ((int[]) objArr6[3])[0];
                if (i7 == i6) {
                    Object[] objArr87 = {list, new int[1], list, new int[]{i}, new int[]{i}};
                    int i144 = ((int[]) objArr6[1])[0];
                    int i145 = ((int[]) objArr6[3])[0];
                    int i146 = ((int[]) objArr6[4])[0];
                    List list3 = (List) objArr6[0];
                    List list4 = (List) objArr6[2];
                    int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
                    int i147 = ~iElapsedRealtime;
                    int i148 = i144 + (-89688118) + (((~((-180717761) | i147)) | 424730697) * 519) + (((~(i147 | (-42272897))) | (~(467003593 | iElapsedRealtime))) * (-519)) + (((~(iElapsedRealtime | 424730697)) | 180717760) * 519);
                    int i149 = (i148 << 13) ^ i148;
                    int i150 = i149 ^ (i149 >>> 17);
                    ((int[]) objArr87[1])[0] = i150 ^ (i150 << 5);
                } else {
                    ArrayList arrayList4 = new ArrayList();
                    Object[] objArr88 = {objArr6};
                    objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1804664566);
                    if (objAccessartificialFrame3 == null) {
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(41 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (12469 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), 3690 - AndroidCharacter.getMirror('0'), -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                    }
                    arrayList4.add(((Method) objAccessartificialFrame3).invoke(null, objArr88));
                    Object[] objArr89 = {objArr6};
                    objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                    if (objAccessartificialFrame4 == null) {
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((Process.myTid() >> 22) + 41, (char) ((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 12468), 3642 - ExpandableListView.getPackedPositionGroup(0L), 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                    }
                    arrayList4.add(((Method) objAccessartificialFrame4).invoke(null, objArr89));
                    Object[] objArr90 = {Long.valueOf((((long) (-600461534)) << 32) ^ ((long) (i6 ^ i7))), Long.valueOf(-600461526)};
                    byte[] bArr28 = $$d;
                    Object[] objArr91 = new Object[1];
                    e(bArr28[26], (short) ($$e | 196), bArr28[73], objArr91);
                    Class<?> cls12 = Class.forName((String) objArr91[0]);
                    byte b38 = bArr28[508];
                    Object[] objArr92 = new Object[1];
                    e(b38, (short) (b38 | Ascii.STX), bArr28[154], objArr92);
                    cls12.getMethod((String) objArr92[0], Long.TYPE, Long.TYPE).invoke(null, objArr90);
                    Object[] objArr93 = {list, new int[1], list, new int[]{i}, new int[]{i}};
                    int i151 = ((int[]) objArr6[1])[0];
                    int i152 = ((int[]) objArr6[3])[0];
                    int i153 = ((int[]) objArr6[4])[0];
                    List list5 = (List) objArr6[0];
                    List list6 = (List) objArr6[2];
                    int iIdentityHashCode5 = System.identityHashCode(this);
                    int i154 = i151 + 1414265600 + ((~((-7471105) | iIdentityHashCode5)) * (-301)) + (((~(309498977 | iIdentityHashCode5)) | (~((~iIdentityHashCode5) | 914947435))) * (-301)) + (((~(iIdentityHashCode5 | (-914947436))) | 309498977) * 301);
                    int i155 = (i154 << 13) ^ i154;
                    int i156 = i155 ^ (i155 >>> 17);
                    ((int[]) objArr93[1])[0] = i156 ^ (i156 << 5);
                }
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame5 == null) {
                    int scrollBarSize3 = 26 - (ViewConfiguration.getScrollBarSize() >> 8);
                    char doubleTapTimeout3 = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                    int pressedStateDuration2 = (ViewConfiguration.getPressedStateDuration() >> 16) + 1041;
                    byte b39 = $$a[41];
                    byte b40 = (byte) (b39 - 1);
                    Object[] objArr94 = new Object[1];
                    d(b40, b40, b39, objArr94);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(scrollBarSize3, doubleTapTimeout3, pressedStateDuration2, 2061780482, false, (String) objArr94[0], null);
                }
                j = ((Field) objAccessartificialFrame5).getLong(null);
                if (j != -1 || j + 4611686018427387849L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                    Object[] objArr95 = {-1524905278};
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame6 == null) {
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(7 - TextUtils.lastIndexOf("", '0', 0, 0), (char) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 22251), 1034 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = zza.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame6).newInstance(objArr95), -627168001, false);
                    objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame7 == null) {
                        int i157 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 26;
                        char scrollBarFadeDuration2 = (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                        int iIndexOf4 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1042;
                        byte[] bArr29 = $$a;
                        byte b41 = bArr29[41];
                        Object[] objArr96 = new Object[1];
                        d((byte) (b41 - 1), bArr29[33], b41, objArr96);
                        objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(i157, scrollBarFadeDuration2, iIndexOf4, 1145017376, false, (String) objArr96[0], null);
                    }
                    ((Field) objAccessartificialFrame7).set(null, objArrAccessartificialFrame$78cbbd35);
                    try {
                        Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame8 == null) {
                            int pressedStateDuration3 = (ViewConfiguration.getPressedStateDuration() >> 16) + 26;
                            char modifierMetaStateMask3 = (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask()));
                            int capsMode2 = 1041 - TextUtils.getCapsMode("", 0, 0);
                            byte b42 = $$a[41];
                            byte b43 = (byte) (b42 - 1);
                            Object[] objArr97 = new Object[1];
                            d(b43, b43, b42, objArr97);
                            objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(pressedStateDuration3, modifierMetaStateMask3, capsMode2, 2061780482, false, (String) objArr97[0], null);
                        }
                        ((Field) objAccessartificialFrame8).set(null, lValueOf7);
                    } catch (Exception unused6) {
                        throw new RuntimeException();
                    }
                } else {
                    Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame35 == null) {
                        int iMyTid = (Process.myTid() >> 22) + 26;
                        char modifierMetaStateMask4 = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1);
                        int edgeSlop = (ViewConfiguration.getEdgeSlop() >> 16) + 1041;
                        byte[] bArr30 = $$a;
                        byte b44 = bArr30[41];
                        Object[] objArr98 = new Object[1];
                        d((byte) (b44 - 1), bArr30[33], b44, objArr98);
                        objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(iMyTid, modifierMetaStateMask4, edgeSlop, 1145017376, false, (String) objArr98[0], null);
                    }
                    Object[] objArr99 = (Object[]) ((Field) objAccessartificialFrame35).get(null);
                    objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                    int i158 = ((int[]) objArr99[3])[0];
                    int i159 = ((int[]) objArr99[2])[0];
                    String[] strArr10 = (String[]) objArr99[0];
                    int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) - 1766616502;
                    int i160 = ((((-227709106) + ((~((-2113545) | iCodePointAt)) * (-301))) + (((~(724847288 | iCodePointAt)) | (~((~iCodePointAt) | 802951095))) * (-301))) + (((~(iCodePointAt | (-802951096))) | 724847288) * 301)) - 627168001;
                    int i161 = (i160 << 13) ^ i160;
                    int i162 = i161 ^ (i161 >>> 17);
                    ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i162 ^ (i162 << 5);
                }
                i8 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                i9 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                if (i9 == i8) {
                    int i163 = getARTIFICIAL_FRAME_PACKAGE_NAME + 115;
                    artificialFrame = i163 % 128;
                    int i164 = i163 % 2;
                    Object[] objArr100 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                    int i165 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                    int i166 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                    int i167 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                    String[] strArr11 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                    int iIdentityHashCode6 = System.identityHashCode(this);
                    int i168 = ~(268908040 | iIdentityHashCode6);
                    int i169 = i165 + (-117620568) + (((-459241226) | i168) * (-814)) + ((i168 | (~((~iIdentityHashCode6) | 190804233)) | 471048) * 407) + (((~(iIdentityHashCode6 | (-190804234))) | (~((-268908041) | iIdentityHashCode6)) | 471048) * 407);
                    int i170 = (i169 << 13) ^ i169;
                    int i171 = i170 ^ (i170 >>> 17);
                    ((int[]) objArr100[1])[0] = i171 ^ (i171 << 5);
                    i10 = 0;
                } else {
                    arrayList = new ArrayList();
                    strArr = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                    if (strArr != null) {
                        for (String str8 : strArr) {
                            arrayList.add(str8);
                        }
                    }
                    long j9 = (((long) (-1553968320)) << 32) ^ ((long) (i8 ^ i9));
                    long j10 = -1553968318;
                    int i172 = getARTIFICIAL_FRAME_PACKAGE_NAME + 71;
                    artificialFrame = i172 % 128;
                    int i173 = i172 % 2;
                    Object[] objArr101 = {Long.valueOf(j9), Long.valueOf(j10)};
                    byte[] bArr31 = $$d;
                    Object[] objArr102 = new Object[1];
                    e(bArr31[455], (short) ($$e | 124), bArr31[9], objArr102);
                    Class<?> cls13 = Class.forName((String) objArr102[0]);
                    byte b45 = bArr31[508];
                    Object[] objArr103 = new Object[1];
                    e(b45, (short) (b45 | Ascii.STX), bArr31[154], objArr103);
                    cls13.getMethod((String) objArr103[0], Long.TYPE, Long.TYPE).invoke(null, objArr101);
                    Object[] objArr104 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                    int i174 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                    int i175 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                    int i176 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                    String[] strArr12 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                    int length3 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 1054347785;
                    int i177 = ~length3;
                    int i178 = i174 + ((((~(498178755 | i177)) | (~(length3 | 576282562))) * 959) - 305642313) + (((~(length3 | 498178755)) | (~(i177 | 576282562))) * 959);
                    int i179 = (i178 << 13) ^ i178;
                    int i180 = i179 ^ (i179 >>> 17);
                    i10 = 0;
                    ((int[]) objArr104[1])[0] = i180 ^ (i180 << 5);
                }
                objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                if (objAccessartificialFrame9 == null) {
                    int keyRepeatDelay2 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 30;
                    char cIndexOf4 = (char) (TextUtils.indexOf("", "", i10) + 49362);
                    int iAlpha = 684 - Color.alpha(i10);
                    byte[] bArr32 = $$a;
                    byte b46 = bArr32[21];
                    Object[] objArr105 = new Object[1];
                    d(b46, (byte) (b46 | 84), bArr32[33], objArr105);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay2, cIndexOf4, iAlpha, 752929587, false, (String) objArr105[0], null);
                }
                j2 = ((Field) objAccessartificialFrame9).getLong(null);
                if (j2 != -1 || j2 + 1964 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    baseContext = getBaseContext();
                    if (baseContext == null) {
                        Object[] objArr106 = new Object[1];
                        c(MotionEvent.axisFromString("") + 27, new char[]{57631, 61071, 36952, 26761, 5232, 31878, 20130, 63362, 12652, 31534, 54301, 17857, 16596, 8428, 60778, 12295, 4863, 44707, 10526, 35859, 42827, 63995, 17151, 15956, 3566, 12072}, objArr106);
                        Class<?> cls14 = Class.forName((String) objArr106[0]);
                        Object[] objArr107 = new Object[1];
                        c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 14, new char[]{5920, 19153, 54432, 7807, 46780, 59300, 2357, 27956, 59956, 26081, 50825, 56996, 20737, 35954, 60778, 12295, 59104, 18621}, objArr107);
                        baseContext = (Context) cls14.getMethod((String) objArr107[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext != null) {
                        if ((baseContext instanceof ContextWrapper) || ((ContextWrapper) baseContext).getBaseContext() != null) {
                            baseContext = baseContext.getApplicationContext();
                        } else {
                            baseContext = null;
                        }
                    }
                    Object[] objArr108 = {baseContext, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 403715645};
                    byte[] bArr33 = $$d;
                    byte b47 = bArr33[9];
                    Object[] objArr109 = new Object[1];
                    e(b47, (short) (b47 | 82), bArr33[73], objArr109);
                    Class<?> cls15 = Class.forName((String) objArr109[0]);
                    Object[] objArr110 = new Object[1];
                    e(bArr33[214], (short) JfifUtil.MARKER_SOI, (byte) (bArr33[30] - 1), objArr110);
                    objArr7 = (Object[]) cls15.getMethod((String) objArr110[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr108);
                    if (baseContext != null) {
                        objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-326560385);
                        if (objAccessartificialFrame10 == null) {
                            int iRed2 = Color.red(0) + 30;
                            char size = (char) (49362 - View.MeasureSpec.getSize(0));
                            int offsetAfter = 684 - TextUtils.getOffsetAfter("", 0);
                            byte[] bArr34 = $$a;
                            Object[] objArr111 = new Object[1];
                            d(bArr34[112], (byte) 101, bArr34[33], objArr111);
                            objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iRed2, size, offsetAfter, 1944867703, false, (String) objArr111[0], null);
                        }
                        ((Field) objAccessartificialFrame10).set(null, objArr7);
                        try {
                            Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                            if (objAccessartificialFrame11 == null) {
                                int i181 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 30;
                                char cLastIndexOf3 = (char) (TextUtils.lastIndexOf("", '0', 0) + 49363);
                                int offsetBefore2 = 684 - TextUtils.getOffsetBefore("", 0);
                                byte[] bArr35 = $$a;
                                byte b48 = bArr35[21];
                                Object[] objArr112 = new Object[1];
                                d(b48, (byte) (b48 | 84), bArr35[33], objArr112);
                                objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(i181, cLastIndexOf3, offsetBefore2, 752929587, false, (String) objArr112[0], null);
                            }
                            ((Field) objAccessartificialFrame11).set(null, lValueOf8);
                        } catch (Exception unused7) {
                            throw new RuntimeException();
                        }
                    }
                } else {
                    int i182 = artificialFrame + 11;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i182 % 128;
                    int i183 = i182 % 2;
                    Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(-326560385);
                    if (objAccessartificialFrame36 == null) {
                        int i184 = 30 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                        char threadPriority = (char) (((Process.getThreadPriority(0) + 20) >> 6) + 49362);
                        int windowTouchSlop2 = (ViewConfiguration.getWindowTouchSlop() >> 8) + 684;
                        byte[] bArr36 = $$a;
                        Object[] objArr113 = new Object[1];
                        d(bArr36[112], (byte) 101, bArr36[33], objArr113);
                        objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(i184, threadPriority, windowTouchSlop2, 1944867703, false, (String) objArr113[0], null);
                    }
                    Object[] objArr114 = (Object[]) ((Field) objAccessartificialFrame36).get(null);
                    objArr7 = new Object[]{new int[]{((int[]) objArr114[0])[0]}, new int[]{((int[]) objArr114[1])[0]}, new int[1], (String) objArr114[3]};
                    int iIdentityHashCode7 = System.identityHashCode(this);
                    int i185 = ~iIdentityHashCode7;
                    int i186 = (-407140930) + (((~(112070805 | i185)) | 822119432) * SyslogConstants.LOG_LOCAL7) + ((iIdentityHashCode7 | 67637268) * (-184)) + ((~((-866552970) | i185)) * SyslogConstants.LOG_LOCAL7) + 403715645;
                    int i187 = (i186 << 13) ^ i186;
                    int i188 = i187 ^ (i187 >>> 17);
                    ((int[]) objArr7[2])[0] = i188 ^ (i188 << 5);
                }
                i12 = ((int[]) objArr7[1])[0];
                i13 = ((int[]) objArr7[0])[0];
                if (i13 == i12) {
                    int i189 = artificialFrame + 89;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i189 % 128;
                    int i190 = i189 % 2;
                    int i191 = ((int[]) objArr7[2])[0];
                    Object[] objArr115 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
                    int i192 = ~((~Process.myTid()) | 234772945);
                    int i193 = i191 + (((27793552 | i192) * (-374)) - 1612371320) + ((i192 | 206979393) * 374);
                    int i194 = i193 ^ (i193 << 13);
                    int i195 = i194 ^ (i194 >>> 17);
                    ((int[]) objArr115[2])[0] = i195 ^ (i195 << 5);
                    return;
                }
                long j11 = (((long) (-1526109846)) << 32) ^ ((long) (i12 ^ i13));
                long j12 = -1526109842;
                int i196 = artificialFrame + 55;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i196 % 128;
                int i197 = i196 % 2;
                Object[] objArr116 = {Long.valueOf(j11), Long.valueOf(j12)};
                byte[] bArr37 = $$d;
                Object[] objArr117 = new Object[1];
                e((byte) (-bArr37[14]), (short) ($$e | 286), bArr37[73], objArr117);
                Class<?> cls16 = Class.forName((String) objArr117[0]);
                byte b49 = bArr37[508];
                Object[] objArr118 = new Object[1];
                e(b49, (short) (b49 | Ascii.STX), bArr37[154], objArr118);
                cls16.getMethod((String) objArr118[0], Long.TYPE, Long.TYPE).invoke(null, objArr116);
                int i198 = ((int[]) objArr7[2])[0];
                Object[] objArr119 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
                int i199 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 1671556030;
                int i200 = ~i199;
                int i201 = i198 + (((~((-2163353) | i200)) | (~(805294078 | i199))) * 988) + 451784482 + (((~(i199 | (-175493049))) | 173329696 | (~(i200 | 805294078))) * 988);
                int i202 = (i201 << 13) ^ i201;
                int i203 = i202 ^ (i202 >>> 17);
                ((int[]) objArr119[2])[0] = i203 ^ (i203 << 5);
                return;
            }
            i5 = 0;
            Long lValueOf9 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(1745676544);
            if (objAccessartificialFrame37 == null) {
                int scrollDefaultDelay3 = 17 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                char cMakeMeasureSpec = (char) View.MeasureSpec.makeMeasureSpec(0, 0);
                int iCombineMeasuredStates = 747 - View.combineMeasuredStates(0, 0);
                byte b50 = $$a[41];
                byte b51 = (byte) (b50 - 1);
                Object[] objArr120 = new Object[1];
                d(b51, b51, b50, objArr120);
                objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(scrollDefaultDelay3, cMakeMeasureSpec, iCombineMeasuredStates, -144068856, false, (String) objArr120[0], null);
            }
            ((Field) objAccessartificialFrame37).set(null, lValueOf9);
            i6 = ((int[]) objArr6[4])[0];
            i7 = ((int[]) objArr6[3])[0];
            if (i7 == i6) {
                Object[] objArr810 = {list3, new int[1], list4, new int[]{i145}, new int[]{i146}};
                int i1410 = ((int[]) objArr6[1])[0];
                int i1411 = ((int[]) objArr6[3])[0];
                int i1412 = ((int[]) objArr6[4])[0];
                List list7 = (List) objArr6[0];
                List list8 = (List) objArr6[2];
                int iElapsedRealtime2 = (int) SystemClock.elapsedRealtime();
                int i1413 = ~iElapsedRealtime2;
                int i1414 = i1410 + (-89688118) + (((~((-180717761) | i1413)) | 424730697) * 519) + (((~(i1413 | (-42272897))) | (~(467003593 | iElapsedRealtime2))) * (-519)) + (((~(iElapsedRealtime2 | 424730697)) | 180717760) * 519);
                int i1415 = (i1414 << 13) ^ i1414;
                int i1510 = i1415 ^ (i1415 >>> 17);
                ((int[]) objArr810[1])[0] = i1510 ^ (i1510 << 5);
            } else {
                ArrayList arrayList5 = new ArrayList();
                Object[] objArr811 = {objArr6};
                objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1804664566);
                if (objAccessartificialFrame3 == null) {
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(41 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (12469 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), 3690 - AndroidCharacter.getMirror('0'), -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                }
                arrayList5.add(((Method) objAccessartificialFrame3).invoke(null, objArr811));
                Object[] objArr812 = {objArr6};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((Process.myTid() >> 22) + 41, (char) ((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 12468), 3642 - ExpandableListView.getPackedPositionGroup(0L), 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                }
                arrayList5.add(((Method) objAccessartificialFrame4).invoke(null, objArr812));
                Object[] objArr910 = {Long.valueOf((((long) (-600461534)) << 32) ^ ((long) (i6 ^ i7))), Long.valueOf(-600461526)};
                byte[] bArr210 = $$d;
                Object[] objArr911 = new Object[1];
                e(bArr210[26], (short) ($$e | 196), bArr210[73], objArr911);
                Class<?> cls17 = Class.forName((String) objArr911[0]);
                byte b310 = bArr210[508];
                Object[] objArr912 = new Object[1];
                e(b310, (short) (b310 | Ascii.STX), bArr210[154], objArr912);
                cls17.getMethod((String) objArr912[0], Long.TYPE, Long.TYPE).invoke(null, objArr910);
                Object[] objArr913 = {list5, new int[1], list6, new int[]{i152}, new int[]{i153}};
                int i1511 = ((int[]) objArr6[1])[0];
                int i1512 = ((int[]) objArr6[3])[0];
                int i1513 = ((int[]) objArr6[4])[0];
                List list9 = (List) objArr6[0];
                List list10 = (List) objArr6[2];
                int iIdentityHashCode8 = System.identityHashCode(this);
                int i1514 = i1511 + 1414265600 + ((~((-7471105) | iIdentityHashCode8)) * (-301)) + (((~(309498977 | iIdentityHashCode8)) | (~((~iIdentityHashCode8) | 914947435))) * (-301)) + (((~(iIdentityHashCode8 | (-914947436))) | 309498977) * 301);
                int i1515 = (i1514 << 13) ^ i1514;
                int i1516 = i1515 ^ (i1515 >>> 17);
                ((int[]) objArr913[1])[0] = i1516 ^ (i1516 << 5);
            }
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame5 == null) {
                int scrollBarSize4 = 26 - (ViewConfiguration.getScrollBarSize() >> 8);
                char doubleTapTimeout4 = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                int pressedStateDuration4 = (ViewConfiguration.getPressedStateDuration() >> 16) + 1041;
                byte b311 = $$a[41];
                byte b410 = (byte) (b311 - 1);
                Object[] objArr914 = new Object[1];
                d(b410, b410, b311, objArr914);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(scrollBarSize4, doubleTapTimeout4, pressedStateDuration4, 2061780482, false, (String) objArr914[0], null);
            }
            j = ((Field) objAccessartificialFrame5).getLong(null);
            if (j != -1) {
                int iIntValue3 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                Object[] objArr915 = {-1524905278};
                objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame6 == null) {
                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(7 - TextUtils.lastIndexOf("", '0', 0, 0), (char) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 22251), 1034 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = zza.accessartificialFrame$78cbbd35(iIntValue3, 0, ((Constructor) objAccessartificialFrame6).newInstance(objArr915), -627168001, false);
                objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame7 == null) {
                    int i1517 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 26;
                    char scrollBarFadeDuration3 = (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    int iIndexOf5 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1042;
                    byte[] bArr211 = $$a;
                    byte b411 = bArr211[41];
                    Object[] objArr916 = new Object[1];
                    d((byte) (b411 - 1), bArr211[33], b411, objArr916);
                    objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(i1517, scrollBarFadeDuration3, iIndexOf5, 1145017376, false, (String) objArr916[0], null);
                }
                ((Field) objAccessartificialFrame7).set(null, objArrAccessartificialFrame$78cbbd35);
                Long lValueOf10 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame8 == null) {
                    int pressedStateDuration5 = (ViewConfiguration.getPressedStateDuration() >> 16) + 26;
                    char modifierMetaStateMask5 = (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask()));
                    int capsMode3 = 1041 - TextUtils.getCapsMode("", 0, 0);
                    byte b412 = $$a[41];
                    byte b413 = (byte) (b412 - 1);
                    Object[] objArr917 = new Object[1];
                    d(b413, b413, b412, objArr917);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(pressedStateDuration5, modifierMetaStateMask5, capsMode3, 2061780482, false, (String) objArr917[0], null);
                }
                ((Field) objAccessartificialFrame8).set(null, lValueOf10);
            } else {
                int iIntValue4 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                Object[] objArr918 = {-1524905278};
                objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame6 == null) {
                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(7 - TextUtils.lastIndexOf("", '0', 0, 0), (char) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 22251), 1034 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = zza.accessartificialFrame$78cbbd35(iIntValue4, 0, ((Constructor) objAccessartificialFrame6).newInstance(objArr918), -627168001, false);
                objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame7 == null) {
                    int i1518 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 26;
                    char scrollBarFadeDuration4 = (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    int iIndexOf6 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1042;
                    byte[] bArr212 = $$a;
                    byte b414 = bArr212[41];
                    Object[] objArr919 = new Object[1];
                    d((byte) (b414 - 1), bArr212[33], b414, objArr919);
                    objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(i1518, scrollBarFadeDuration4, iIndexOf6, 1145017376, false, (String) objArr919[0], null);
                }
                ((Field) objAccessartificialFrame7).set(null, objArrAccessartificialFrame$78cbbd35);
                Long lValueOf11 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame8 == null) {
                    int pressedStateDuration6 = (ViewConfiguration.getPressedStateDuration() >> 16) + 26;
                    char modifierMetaStateMask6 = (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask()));
                    int capsMode4 = 1041 - TextUtils.getCapsMode("", 0, 0);
                    byte b415 = $$a[41];
                    byte b416 = (byte) (b415 - 1);
                    Object[] objArr9110 = new Object[1];
                    d(b416, b416, b415, objArr9110);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(pressedStateDuration6, modifierMetaStateMask6, capsMode4, 2061780482, false, (String) objArr9110[0], null);
                }
                ((Field) objAccessartificialFrame8).set(null, lValueOf11);
            }
            i8 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            i9 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            if (i9 == i8) {
                int i1610 = getARTIFICIAL_FRAME_PACKAGE_NAME + 115;
                artificialFrame = i1610 % 128;
                int i1611 = i1610 % 2;
                Object[] objArr1010 = {strArr11, new int[1], new int[]{i167}, new int[]{i166}};
                int i1612 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i1613 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i1614 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr13 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int iIdentityHashCode9 = System.identityHashCode(this);
                int i1615 = ~(268908040 | iIdentityHashCode9);
                int i1616 = i1612 + (-117620568) + (((-459241226) | i1615) * (-814)) + ((i1615 | (~((~iIdentityHashCode9) | 190804233)) | 471048) * 407) + (((~(iIdentityHashCode9 | (-190804234))) | (~((-268908041) | iIdentityHashCode9)) | 471048) * 407);
                int i1710 = (i1616 << 13) ^ i1616;
                int i1711 = i1710 ^ (i1710 >>> 17);
                ((int[]) objArr1010[1])[0] = i1711 ^ (i1711 << 5);
                i10 = 0;
            } else {
                arrayList = new ArrayList();
                strArr = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                if (strArr != null) {
                    while (i11 < strArr.length) {
                        arrayList.add(str8);
                    }
                }
                long j13 = (((long) (-1553968320)) << 32) ^ ((long) (i8 ^ i9));
                long j14 = -1553968318;
                int i1712 = getARTIFICIAL_FRAME_PACKAGE_NAME + 71;
                artificialFrame = i1712 % 128;
                int i1713 = i1712 % 2;
                Object[] objArr1011 = {Long.valueOf(j13), Long.valueOf(j14)};
                byte[] bArr38 = $$d;
                Object[] objArr1012 = new Object[1];
                e(bArr38[455], (short) ($$e | 124), bArr38[9], objArr1012);
                Class<?> cls18 = Class.forName((String) objArr1012[0]);
                byte b417 = bArr38[508];
                Object[] objArr1013 = new Object[1];
                e(b417, (short) (b417 | Ascii.STX), bArr38[154], objArr1013);
                cls18.getMethod((String) objArr1013[0], Long.TYPE, Long.TYPE).invoke(null, objArr1011);
                Object[] objArr1014 = {strArr12, new int[1], new int[]{i176}, new int[]{i175}};
                int i1714 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i1715 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i1716 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr14 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int length4 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 1054347785;
                int i1717 = ~length4;
                int i1718 = i1714 + ((((~(498178755 | i1717)) | (~(length4 | 576282562))) * 959) - 305642313) + (((~(length4 | 498178755)) | (~(i1717 | 576282562))) * 959);
                int i1719 = (i1718 << 13) ^ i1718;
                int i1810 = i1719 ^ (i1719 >>> 17);
                i10 = 0;
                ((int[]) objArr1014[1])[0] = i1810 ^ (i1810 << 5);
            }
            objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1283093189);
            if (objAccessartificialFrame9 == null) {
                int keyRepeatDelay3 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 30;
                char cIndexOf5 = (char) (TextUtils.indexOf("", "", i10) + 49362);
                int iAlpha2 = 684 - Color.alpha(i10);
                byte[] bArr39 = $$a;
                byte b418 = bArr39[21];
                Object[] objArr1015 = new Object[1];
                d(b418, (byte) (b418 | 84), bArr39[33], objArr1015);
                objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay3, cIndexOf5, iAlpha2, 752929587, false, (String) objArr1015[0], null);
            }
            j2 = ((Field) objAccessartificialFrame9).getLong(null);
            if (j2 != -1) {
                baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr1016 = new Object[1];
                    c(MotionEvent.axisFromString("") + 27, new char[]{57631, 61071, 36952, 26761, 5232, 31878, 20130, 63362, 12652, 31534, 54301, 17857, 16596, 8428, 60778, 12295, 4863, 44707, 10526, 35859, 42827, 63995, 17151, 15956, 3566, 12072}, objArr1016);
                    Class<?> cls19 = Class.forName((String) objArr1016[0]);
                    Object[] objArr1017 = new Object[1];
                    c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 14, new char[]{5920, 19153, 54432, 7807, 46780, 59300, 2357, 27956, 59956, 26081, 50825, 56996, 20737, 35954, 60778, 12295, 59104, 18621}, objArr1017);
                    baseContext = (Context) cls19.getMethod((String) objArr1017[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    if (baseContext instanceof ContextWrapper) {
                        baseContext = baseContext.getApplicationContext();
                    } else {
                        baseContext = baseContext.getApplicationContext();
                    }
                }
                Object[] objArr1018 = {baseContext, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 403715645};
                byte[] bArr310 = $$d;
                byte b419 = bArr310[9];
                Object[] objArr1019 = new Object[1];
                e(b419, (short) (b419 | 82), bArr310[73], objArr1019);
                Class<?> cls110 = Class.forName((String) objArr1019[0]);
                Object[] objArr1110 = new Object[1];
                e(bArr310[214], (short) JfifUtil.MARKER_SOI, (byte) (bArr310[30] - 1), objArr1110);
                objArr7 = (Object[]) cls110.getMethod((String) objArr1110[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr1018);
                if (baseContext != null) {
                    objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-326560385);
                    if (objAccessartificialFrame10 == null) {
                        int iRed3 = Color.red(0) + 30;
                        char size2 = (char) (49362 - View.MeasureSpec.getSize(0));
                        int offsetAfter2 = 684 - TextUtils.getOffsetAfter("", 0);
                        byte[] bArr311 = $$a;
                        Object[] objArr1111 = new Object[1];
                        d(bArr311[112], (byte) 101, bArr311[33], objArr1111);
                        objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iRed3, size2, offsetAfter2, 1944867703, false, (String) objArr1111[0], null);
                    }
                    ((Field) objAccessartificialFrame10).set(null, objArr7);
                    Long lValueOf12 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                    if (objAccessartificialFrame11 == null) {
                        int i1811 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 30;
                        char cLastIndexOf4 = (char) (TextUtils.lastIndexOf("", '0', 0) + 49363);
                        int offsetBefore3 = 684 - TextUtils.getOffsetBefore("", 0);
                        byte[] bArr312 = $$a;
                        byte b420 = bArr312[21];
                        Object[] objArr1112 = new Object[1];
                        d(b420, (byte) (b420 | 84), bArr312[33], objArr1112);
                        objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(i1811, cLastIndexOf4, offsetBefore3, 752929587, false, (String) objArr1112[0], null);
                    }
                    ((Field) objAccessartificialFrame11).set(null, lValueOf12);
                }
            } else {
                baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr10110 = new Object[1];
                    c(MotionEvent.axisFromString("") + 27, new char[]{57631, 61071, 36952, 26761, 5232, 31878, 20130, 63362, 12652, 31534, 54301, 17857, 16596, 8428, 60778, 12295, 4863, 44707, 10526, 35859, 42827, 63995, 17151, 15956, 3566, 12072}, objArr10110);
                    Class<?> cls111 = Class.forName((String) objArr10110[0]);
                    Object[] objArr10111 = new Object[1];
                    c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 14, new char[]{5920, 19153, 54432, 7807, 46780, 59300, 2357, 27956, 59956, 26081, 50825, 56996, 20737, 35954, 60778, 12295, 59104, 18621}, objArr10111);
                    baseContext = (Context) cls111.getMethod((String) objArr10111[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    if (baseContext instanceof ContextWrapper) {
                        baseContext = baseContext.getApplicationContext();
                    } else {
                        baseContext = baseContext.getApplicationContext();
                    }
                }
                Object[] objArr10112 = {baseContext, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 403715645};
                byte[] bArr313 = $$d;
                byte b4110 = bArr313[9];
                Object[] objArr10113 = new Object[1];
                e(b4110, (short) (b4110 | 82), bArr313[73], objArr10113);
                Class<?> cls112 = Class.forName((String) objArr10113[0]);
                Object[] objArr1113 = new Object[1];
                e(bArr313[214], (short) JfifUtil.MARKER_SOI, (byte) (bArr313[30] - 1), objArr1113);
                objArr7 = (Object[]) cls112.getMethod((String) objArr1113[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr10112);
                if (baseContext != null) {
                    objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-326560385);
                    if (objAccessartificialFrame10 == null) {
                        int iRed4 = Color.red(0) + 30;
                        char size3 = (char) (49362 - View.MeasureSpec.getSize(0));
                        int offsetAfter3 = 684 - TextUtils.getOffsetAfter("", 0);
                        byte[] bArr314 = $$a;
                        Object[] objArr1114 = new Object[1];
                        d(bArr314[112], (byte) 101, bArr314[33], objArr1114);
                        objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iRed4, size3, offsetAfter3, 1944867703, false, (String) objArr1114[0], null);
                    }
                    ((Field) objAccessartificialFrame10).set(null, objArr7);
                    Long lValueOf13 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                    if (objAccessartificialFrame11 == null) {
                        int i1812 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 30;
                        char cLastIndexOf5 = (char) (TextUtils.lastIndexOf("", '0', 0) + 49363);
                        int offsetBefore4 = 684 - TextUtils.getOffsetBefore("", 0);
                        byte[] bArr315 = $$a;
                        byte b421 = bArr315[21];
                        Object[] objArr1115 = new Object[1];
                        d(b421, (byte) (b421 | 84), bArr315[33], objArr1115);
                        objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(i1812, cLastIndexOf5, offsetBefore4, 752929587, false, (String) objArr1115[0], null);
                    }
                    ((Field) objAccessartificialFrame11).set(null, lValueOf13);
                }
            }
            i12 = ((int[]) objArr7[1])[0];
            i13 = ((int[]) objArr7[0])[0];
            if (i13 == i12) {
                int i1813 = artificialFrame + 89;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i1813 % 128;
                int i1910 = i1813 % 2;
                int i1911 = ((int[]) objArr7[2])[0];
                Object[] objArr1116 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
                int i1912 = ~((~Process.myTid()) | 234772945);
                int i1913 = i1911 + (((27793552 | i1912) * (-374)) - 1612371320) + ((i1912 | 206979393) * 374);
                int i1914 = i1913 ^ (i1913 << 13);
                int i1915 = i1914 ^ (i1914 >>> 17);
                ((int[]) objArr1116[2])[0] = i1915 ^ (i1915 << 5);
                return;
            }
            long j15 = (((long) (-1526109846)) << 32) ^ ((long) (i12 ^ i13));
            long j16 = -1526109842;
            int i1916 = artificialFrame + 55;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i1916 % 128;
            int i1917 = i1916 % 2;
            Object[] objArr1117 = {Long.valueOf(j15), Long.valueOf(j16)};
            byte[] bArr316 = $$d;
            Object[] objArr1118 = new Object[1];
            e((byte) (-bArr316[14]), (short) ($$e | 286), bArr316[73], objArr1118);
            Class<?> cls113 = Class.forName((String) objArr1118[0]);
            byte b422 = bArr316[508];
            Object[] objArr1119 = new Object[1];
            e(b422, (short) (b422 | Ascii.STX), bArr316[154], objArr1119);
            cls113.getMethod((String) objArr1119[0], Long.TYPE, Long.TYPE).invoke(null, objArr1117);
            int i1918 = ((int[]) objArr7[2])[0];
            Object[] objArr1120 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
            int i1919 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 1671556030;
            int i204 = ~i1919;
            int i205 = i1918 + (((~((-2163353) | i204)) | (~(805294078 | i1919))) * 988) + 451784482 + (((~(i1919 | (-175493049))) | 173329696 | (~(i204 | 805294078))) * 988);
            int i206 = (i205 << 13) ^ i205;
            int i207 = i206 ^ (i206 >>> 17);
            ((int[]) objArr1120[2])[0] = i207 ^ (i207 << 5);
            return;
        } catch (Exception unused8) {
            throw new RuntimeException();
        }
        Context baseContext4 = getBaseContext();
        if (baseContext4 == null) {
            Object[] objArr121 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i5]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(i5, 4).codePointAt(2) - 10, new char[]{57631, 61071, 36952, 26761, 5232, 31878, 20130, 63362, 12652, 31534, 54301, 17857, 16596, 8428, 60778, 12295, 4863, 44707, 10526, 35859, 42827, 63995, 17151, 15956, 3566, 12072}, objArr121);
            Class<?> cls20 = Class.forName((String) objArr121[i5]);
            Object[] objArr122 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i5]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 17, new char[]{5920, 19153, 54432, 7807, 46780, 59300, 2357, 27956, 59956, 26081, 50825, 56996, 20737, 35954, 60778, 12295, 59104, 18621}, objArr122);
            baseContext4 = (Context) cls20.getMethod((String) objArr122[0], new Class[0]).invoke(null, null);
        }
        if (baseContext4 != null) {
            baseContext4 = ((baseContext4 instanceof ContextWrapper) && ((ContextWrapper) baseContext4).getBaseContext() == null) ? null : baseContext4.getApplicationContext();
        }
        Object[] objArr123 = {baseContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 863906511};
        byte[] bArr40 = $$d;
        Object[] objArr124 = new Object[1];
        e(bArr40[94], (short) ($$e | 262), bArr40[73], objArr124);
        Class<?> cls21 = Class.forName((String) objArr124[0]);
        Object[] objArr125 = new Object[1];
        e(bArr40[214], (short) JfifUtil.MARKER_SOI, (byte) (bArr40[30] - 1), objArr125);
        objArr6 = (Object[]) cls21.getMethod((String) objArr125[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr123);
        Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(1575402270);
        if (objAccessartificialFrame38 == null) {
            int scrollDefaultDelay4 = 17 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
            char jumpTapTimeout2 = (char) (ViewConfiguration.getJumpTapTimeout() >> 16);
            int windowTouchSlop3 = 747 - (ViewConfiguration.getWindowTouchSlop() >> 8);
            byte[] bArr41 = $$a;
            byte b52 = bArr41[41];
            Object[] objArr126 = new Object[1];
            d((byte) (b52 - 1), bArr41[33], b52, objArr126);
            objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(scrollDefaultDelay4, jumpTapTimeout2, windowTouchSlop3, -1031537386, false, (String) objArr126[0], null);
        }
        ((Field) objAccessartificialFrame38).set(null, objArr6);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() throws Throwable {
        int i = 2 % 2;
        int i2 = artificialFrame + 57;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        int i3 = i2 % 2;
        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(949068051);
        if (objAccessartificialFrame == null) {
            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(30 - Color.blue(0), (char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 49993), 73 - TextUtils.lastIndexOf("", '0', 0), -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
        }
        Object obj = ((Field) objAccessartificialFrame).get(null);
        try {
            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1579113874);
            if (objAccessartificialFrame2 == null) {
                int mode = View.MeasureSpec.getMode(0) + 30;
                char cNormalizeMetaState = (char) (KeyEvent.normalizeMetaState(0) + 49993);
                int packedPositionType = 74 - ExpandableListView.getPackedPositionType(0L);
                byte[] bArr = $$d;
                Object[] objArr = new Object[1];
                e((byte) 82, bArr[9], bArr[25], objArr);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(mode, cNormalizeMetaState, packedPositionType, -1048962150, false, (String) objArr[0], new Class[0]);
            }
            ((Method) objAccessartificialFrame2).invoke(obj, null);
            super.onResume();
            int i4 = getARTIFICIAL_FRAME_PACKAGE_NAME + 67;
            artificialFrame = i4 % 128;
            int i5 = i4 % 2;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() throws Throwable {
        int i = 2 % 2;
        int i2 = artificialFrame + 21;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        int i3 = i2 % 2;
        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(949068051);
        if (objAccessartificialFrame == null) {
            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 30, (char) (49993 - TextUtils.getTrimmedLength("")), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 74, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
        }
        Object obj = ((Field) objAccessartificialFrame).get(null);
        try {
            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1579114835);
            if (objAccessartificialFrame2 == null) {
                int pressedStateDuration = 30 - (ViewConfiguration.getPressedStateDuration() >> 16);
                char touchSlop = (char) ((ViewConfiguration.getTouchSlop() >> 8) + 49993);
                int packedPositionGroup = ExpandableListView.getPackedPositionGroup(0L) + 74;
                byte[] bArr = $$d;
                Object[] objArr = new Object[1];
                e((byte) 82, bArr[9], bArr[73], objArr);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(pressedStateDuration, touchSlop, packedPositionGroup, -1048959141, false, (String) objArr[0], new Class[0]);
            }
            ((Method) objAccessartificialFrame2).invoke(obj, null);
            super.onPause();
            int i4 = artificialFrame + 3;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i4 % 128;
            int i5 = i4 % 2;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x019e  */
    /* JADX WARN: Code duplicated, block: B:16:0x0211 A[Catch: all -> 0x0a23, TryCatch #2 {all -> 0x0a23, blocks: (B:51:0x0720, B:53:0x0741, B:54:0x079b, B:14:0x01fd, B:16:0x0211, B:17:0x0241), top: B:95:0x01fd }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0257  */
    /* JADX WARN: Code duplicated, block: B:25:0x0333  */
    /* JADX WARN: Code duplicated, block: B:50:0x0699  */
    /* JADX WARN: Code duplicated, block: B:53:0x0741 A[Catch: all -> 0x0a23, TryCatch #2 {all -> 0x0a23, blocks: (B:51:0x0720, B:53:0x0741, B:54:0x079b, B:14:0x01fd, B:16:0x0211, B:17:0x0241), top: B:95:0x01fd }] */
    /* JADX WARN: Code duplicated, block: B:57:0x07ad  */
    /* JADX WARN: Code duplicated, block: B:62:0x0864  */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) throws Throwable {
        Object objAccessartificialFrame;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        Object[] objArr;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        char c = 2;
        int i = 2 % 2;
        super.attachBaseContext(context);
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame7 == null) {
            int absoluteGravity = Gravity.getAbsoluteGravity(0, 0) + 26;
            char mode = (char) View.MeasureSpec.getMode(0);
            int defaultSize = 1041 - View.getDefaultSize(0, 0);
            byte b2 = $$a[41];
            byte b3 = (byte) (b2 - 1);
            Object[] objArr2 = new Object[1];
            d(b3, b3, b2, objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(absoluteGravity, mode, defaultSize, 2061780482, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            int i2 = artificialFrame + 81;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
            int i3 = i2 % 2;
            long j2 = j + 4611686018427387902L;
            Object[] objArr3 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(8) - 79, new char[]{57631, 61071, 36952, 26761, 5232, 31878, 20130, 63362, 14733, 15725, 18217, 60514, 28007, 24679, 5635, 2103, 20858, 57853, 35298, 20729, 7430, 6879}, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 11, new char[]{51634, 29782, 12652, 31534, 59157, 53799, 50610, 52678, 59347, 44447, 56995, 45228, 57438, 51892, 56210, 16421}, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame8 == null) {
                    int iRgb = Color.rgb(0, 0, 0) + 16777242;
                    char scrollDefaultDelay = (char) (ViewConfiguration.getScrollDefaultDelay() >> 16);
                    int iResolveSizeAndState = 1041 - View.resolveSizeAndState(0, 0, 0);
                    byte[] bArr = $$a;
                    byte b4 = bArr[41];
                    Object[] objArr5 = new Object[1];
                    d((byte) (b4 - 1), bArr[33], b4, objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iRgb, scrollDefaultDelay, iResolveSizeAndState, 1145017376, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i4 = ((int[]) objArr6[3])[0];
                int i5 = ((int[]) objArr6[2])[0];
                String[] strArr = (String[]) objArr6[0];
                int iIdentityHashCode = System.identityHashCode(this);
                int i6 = ~(1063255903 | iIdentityHashCode);
                int i7 = (-1289027002) + ((973079134 | i6) * (-476)) + (i6 * 952) + ((~((~iIdentityHashCode) | 1063255903)) * 476) + 1357742701;
                int i8 = (i7 << 13) ^ i7;
                int i9 = i8 ^ (i8 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i9 ^ (i9 << 5);
                int i10 = artificialFrame + 9;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i10 % 128;
                int i11 = i10 % 2;
            } else {
                Object[] objArr7 = new Object[1];
                c(ImageFormat.getBitsPerPixel(0) + 17, new char[]{41507, 24851, 55413, 52357, 56506, 28864, 57631, 61071, 57587, 17809, 39971, 33402, 5586, 53666, 32652, 52968}, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(16) - 94, new char[]{32295, 7395, 46780, 59300, 60778, 12295, 10526, 35859, 26965, 4945, 7929, 14137, 27319, 41952, 27403, 30102}, objArr8);
                int iIntValue = ((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue();
                try {
                    Object[] objArr9 = {-320956691};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0', 0) + 9, (char) (22250 - ((byte) KeyEvent.getModifierMetaStateMask())), (KeyEvent.getMaxKeyCode() >> 16) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = CompactHashMap.Itr.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr9), 1357742701, false);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame2 == null) {
                        int size = 26 - View.MeasureSpec.getSize(0);
                        char cMyTid = (char) (Process.myTid() >> 22);
                        int i12 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 1040;
                        byte[] bArr2 = $$a;
                        byte b5 = bArr2[41];
                        Object[] objArr10 = new Object[1];
                        d((byte) (b5 - 1), bArr2[33], b5, objArr10);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(size, cMyTid, i12, 1145017376, false, (String) objArr10[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
                    try {
                        Object[] objArr11 = new Object[1];
                        c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 18, new char[]{57631, 61071, 36952, 26761, 5232, 31878, 20130, 63362, 14733, 15725, 18217, 60514, 28007, 24679, 5635, 2103, 20858, 57853, 35298, 20729, 7430, 6879}, objArr11);
                        Class<?> cls3 = Class.forName((String) objArr11[0]);
                        Object[] objArr12 = new Object[1];
                        c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 11, new char[]{51634, 29782, 12652, 31534, 59157, 53799, 50610, 52678, 59347, 44447, 56995, 45228, 57438, 51892, 56210, 16421}, objArr12);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr12[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame3 == null) {
                            int iResolveSize = 26 - View.resolveSize(0, 0);
                            char c2 = (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
                            int i13 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 1040;
                            byte b6 = $$a[41];
                            byte b7 = (byte) (b6 - 1);
                            Object[] objArr13 = new Object[1];
                            d(b7, b7, b6, objArr13);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iResolveSize, c2, i13, 2061780482, false, (String) objArr13[0], null);
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
            Object[] objArr14 = new Object[1];
            c(ImageFormat.getBitsPerPixel(0) + 17, new char[]{41507, 24851, 55413, 52357, 56506, 28864, 57631, 61071, 57587, 17809, 39971, 33402, 5586, 53666, 32652, 52968}, objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(16) - 94, new char[]{32295, 7395, 46780, 59300, 60778, 12295, 10526, 35859, 26965, 4945, 7929, 14137, 27319, 41952, 27403, 30102}, objArr15);
            int iIntValue2 = ((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr16 = {-320956691};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0', 0) + 9, (char) (22250 - ((byte) KeyEvent.getModifierMetaStateMask())), (KeyEvent.getMaxKeyCode() >> 16) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = CompactHashMap.Itr.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr16), 1357742701, false);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame2 == null) {
                int size2 = 26 - View.MeasureSpec.getSize(0);
                char cMyTid2 = (char) (Process.myTid() >> 22);
                int i14 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 1040;
                byte[] bArr3 = $$a;
                byte b8 = bArr3[41];
                Object[] objArr17 = new Object[1];
                d((byte) (b8 - 1), bArr3[33], b8, objArr17);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(size2, cMyTid2, i14, 1145017376, false, (String) objArr17[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr18 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 18, new char[]{57631, 61071, 36952, 26761, 5232, 31878, 20130, 63362, 14733, 15725, 18217, 60514, 28007, 24679, 5635, 2103, 20858, 57853, 35298, 20729, 7430, 6879}, objArr18);
            Class<?> cls5 = Class.forName((String) objArr18[0]);
            Object[] objArr19 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 11, new char[]{51634, 29782, 12652, 31534, 59157, 53799, 50610, 52678, 59347, 44447, 56995, 45228, 57438, 51892, 56210, 16421}, objArr19);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr19[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame3 == null) {
                int iResolveSize2 = 26 - View.resolveSize(0, 0);
                char c3 = (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
                int i15 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 1040;
                byte b9 = $$a[41];
                byte b10 = (byte) (b9 - 1);
                Object[] objArr110 = new Object[1];
                d(b10, b10, b9, objArr110);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iResolveSize2, c3, i15, 2061780482, false, (String) objArr110[0], null);
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
            int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(14) + 414242544;
            int i21 = ~iCodePointAt;
            int i22 = i18 + 1774617376 + (((~(832812779 | i21)) | (-938213356)) * 98) + (((~(i21 | (-910916587))) | 832812779 | (~(910916586 | iCodePointAt))) * (-49)) + (((~(iCodePointAt | 832812779)) | 27296769) * 49);
            int i23 = (i22 << 13) ^ i22;
            int i24 = i23 ^ (i23 >>> 17);
            ((int[]) objArr20[1])[0] = i24 ^ (i24 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr2 != null) {
                int i25 = getARTIFICIAL_FRAME_PACKAGE_NAME + 31;
                artificialFrame = i25 % 128;
                int i26 = i25 % 2;
                for (String str : strArr2) {
                    arrayList.add(str);
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf(((long) (i16 ^ i17)) ^ (((long) (-481601010)) << 32)), Long.valueOf(-481601012)};
                byte[] bArr4 = $$d;
                Object[] objArr22 = new Object[1];
                e(bArr4[455], (short) ($$e | 124), bArr4[9], objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                byte b11 = bArr4[508];
                Object[] objArr23 = new Object[1];
                e(b11, (short) (b11 | Ascii.STX), bArr4[154], objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i27 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i28 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i29 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int i30 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenHeightDp;
                int i31 = i27 + (-1209401158) + ((~(1072553347 | i30)) * 623) + (((~i30) | 42209408) * (-623)) + (((~(i30 | 596433281)) | (~(518329474 | i30)) | (-1072553348)) * 623);
                int i32 = (i31 << 13) ^ i31;
                int i33 = i32 ^ (i32 >>> 17);
                ((int[]) objArr24[1])[0] = i33 ^ (i33 << 5);
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
            int size3 = View.MeasureSpec.getSize(0) + 25;
            char cAxisFromString = (char) (30067 - MotionEvent.axisFromString(""));
            int touchSlop = (ViewConfiguration.getTouchSlop() >> 8) + 816;
            byte b12 = $$a[41];
            byte b13 = (byte) (b12 - 1);
            Object[] objArr25 = new Object[1];
            d(b13, b13, b12, objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(size3, cAxisFromString, touchSlop, 721586079, false, (String) objArr25[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j3 != -1) {
            long j4 = j3 + 2022;
            Object[] objArr26 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 13, new char[]{57631, 61071, 36952, 26761, 5232, 31878, 20130, 63362, 14733, 15725, 18217, 60514, 28007, 24679, 5635, 2103, 20858, 57853, 35298, 20729, 7430, 6879}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 34, new char[]{51634, 29782, 12652, 31534, 59157, 53799, 50610, 52678, 59347, 44447, 56995, 45228, 57438, 51892, 56210, 16421}, objArr27);
            if (j4 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame10 == null) {
                    int i34 = 26 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                    char cIndexOf = (char) (30067 - TextUtils.indexOf((CharSequence) "", '0', 0));
                    int fadingEdgeLength = (ViewConfiguration.getFadingEdgeLength() >> 16) + 816;
                    byte[] bArr5 = $$a;
                    byte b14 = bArr5[41];
                    Object[] objArr28 = new Object[1];
                    d((byte) (b14 - 1), bArr5[33], b14, objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(i34, cIndexOf, fadingEdgeLength, 891606461, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i35 = ((int[]) objArr29[0])[0];
                int i36 = ((int[]) objArr29[1])[0];
                String[] strArr4 = (String[]) objArr29[2];
                int i37 = ~(Process.myTid() | 107672673);
                int i38 = ((((51256845 | i37) * (-658)) + 1236748639) + ((i37 | android.R.string.status_bar_rotate) * 658)) - 1804016188;
                int i39 = (i38 << 13) ^ i38;
                int i40 = i39 ^ (i39 >>> 17);
                ((int[]) objArr[3])[0] = i40 ^ (i40 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 5, new char[]{41507, 24851, 55413, 52357, 56506, 28864, 57631, 61071, 57587, 17809, 39971, 33402, 5586, 53666, 32652, 52968}, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 12, new char[]{32295, 7395, 46780, 59300, 60778, 12295, 10526, 35859, 26965, 4945, 7929, 14137, 27319, 41952, 27403, 30102}, objArr31);
                Object[] objArr32 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue()), 0, -1804016188};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame4 == null) {
                    int fadingEdgeLength2 = 25 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                    char c4 = (char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 30068);
                    int packedPositionType = ExpandableListView.getPackedPositionType(0L) + 816;
                    byte[] bArr6 = $$a;
                    Object[] objArr33 = new Object[1];
                    d((byte) (bArr6[86] - 1), (byte) (-bArr6[73]), bArr6[94], objArr33);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength2, c4, packedPositionType, -797394565, false, (String) objArr33[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr32);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame5 == null) {
                    int iIndexOf = 25 - TextUtils.indexOf("", "");
                    char size4 = (char) (30068 - View.MeasureSpec.getSize(0));
                    int iResolveOpacity = 816 - Drawable.resolveOpacity(0, 0);
                    byte[] bArr7 = $$a;
                    byte b15 = bArr7[41];
                    Object[] objArr34 = new Object[1];
                    d((byte) (b15 - 1), bArr7[33], b15, objArr34);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iIndexOf, size4, iResolveOpacity, 891606461, false, (String) objArr34[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr);
                try {
                    Object[] objArr35 = new Object[1];
                    c((ViewConfiguration.getFadingEdgeLength() >> 16) + 22, new char[]{57631, 61071, 36952, 26761, 5232, 31878, 20130, 63362, 14733, 15725, 18217, 60514, 28007, 24679, 5635, 2103, 20858, 57853, 35298, 20729, 7430, 6879}, objArr35);
                    Class<?> cls9 = Class.forName((String) objArr35[0]);
                    Object[] objArr36 = new Object[1];
                    c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 21, new char[]{51634, 29782, 12652, 31534, 59157, 53799, 50610, 52678, 59347, 44447, 56995, 45228, 57438, 51892, 56210, 16421}, objArr36);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr36[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame6 == null) {
                        int i41 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 25;
                        char cKeyCodeFromString = (char) (30068 - KeyEvent.keyCodeFromString(""));
                        int iLastIndexOf = TextUtils.lastIndexOf("", '0', 0, 0) + 817;
                        byte b16 = $$a[41];
                        byte b17 = (byte) (b16 - 1);
                        Object[] objArr37 = new Object[1];
                        d(b17, b17, b16, objArr37);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i41, cKeyCodeFromString, iLastIndexOf, 721586079, false, (String) objArr37[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr38 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 5, new char[]{41507, 24851, 55413, 52357, 56506, 28864, 57631, 61071, 57587, 17809, 39971, 33402, 5586, 53666, 32652, 52968}, objArr38);
            Class<?> cls10 = Class.forName((String) objArr38[0]);
            Object[] objArr39 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 12, new char[]{32295, 7395, 46780, 59300, 60778, 12295, 10526, 35859, 26965, 4945, 7929, 14137, 27319, 41952, 27403, 30102}, objArr39);
            Object[] objArr310 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr39[0], Object.class).invoke(null, this)).intValue()), 0, -1804016188};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame4 == null) {
                int fadingEdgeLength3 = 25 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                char c5 = (char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 30068);
                int packedPositionType2 = ExpandableListView.getPackedPositionType(0L) + 816;
                byte[] bArr8 = $$a;
                Object[] objArr311 = new Object[1];
                d((byte) (bArr8[86] - 1), (byte) (-bArr8[73]), bArr8[94], objArr311);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength3, c5, packedPositionType2, -797394565, false, (String) objArr311[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr310);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame5 == null) {
                int iIndexOf2 = 25 - TextUtils.indexOf("", "");
                char size5 = (char) (30068 - View.MeasureSpec.getSize(0));
                int iResolveOpacity2 = 816 - Drawable.resolveOpacity(0, 0);
                byte[] bArr9 = $$a;
                byte b18 = bArr9[41];
                Object[] objArr312 = new Object[1];
                d((byte) (b18 - 1), bArr9[33], b18, objArr312);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iIndexOf2, size5, iResolveOpacity2, 891606461, false, (String) objArr312[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr);
            Object[] objArr313 = new Object[1];
            c((ViewConfiguration.getFadingEdgeLength() >> 16) + 22, new char[]{57631, 61071, 36952, 26761, 5232, 31878, 20130, 63362, 14733, 15725, 18217, 60514, 28007, 24679, 5635, 2103, 20858, 57853, 35298, 20729, 7430, 6879}, objArr313);
            Class<?> cls11 = Class.forName((String) objArr313[0]);
            Object[] objArr314 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 21, new char[]{51634, 29782, 12652, 31534, 59157, 53799, 50610, 52678, 59347, 44447, 56995, 45228, 57438, 51892, 56210, 16421}, objArr314);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr314[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame6 == null) {
                int i42 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 25;
                char cKeyCodeFromString2 = (char) (30068 - KeyEvent.keyCodeFromString(""));
                int iLastIndexOf2 = TextUtils.lastIndexOf("", '0', 0, 0) + 817;
                byte b19 = $$a[41];
                byte b110 = (byte) (b19 - 1);
                Object[] objArr315 = new Object[1];
                d(b110, b110, b19, objArr315);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i42, cKeyCodeFromString2, iLastIndexOf2, 721586079, false, (String) objArr315[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i43 = ((int[]) objArr[1])[0];
        int i44 = ((int[]) objArr[0])[0];
        if (i44 == i43) {
            int i45 = artificialFrame + 9;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i45 % 128;
            int i46 = i45 % 2;
            Object[] objArr40 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i47 = ((int[]) objArr[3])[0];
            int i48 = ((int[]) objArr[0])[0];
            int i49 = ((int[]) objArr[1])[0];
            String[] strArr5 = (String[]) objArr[2];
            int i50 = ~System.identityHashCode(this);
            int i51 = i47 + ((((-1905804427) + (((~(i50 | 1039873531)) | (~((-835392682) | i50))) * (-184))) + (((201326608 | (~((-1036719290) | i50))) | (~(838546923 | i50))) * SyslogConstants.LOG_LOCAL7)) - 580380712);
            int i52 = (i51 << 13) ^ i51;
            int i53 = i52 ^ (i52 >>> 17);
            ((int[]) objArr40[3])[0] = i53 ^ (i53 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr6 = (String[]) objArr[2];
        if (strArr6 != null) {
            for (String str2 : strArr6) {
                arrayList2.add(str2);
            }
        }
        Object[] objArr41 = {Long.valueOf((((long) 1073592673) << 32) ^ ((long) (i43 ^ i44))), Long.valueOf(1073592672)};
        byte[] bArr10 = $$d;
        Object[] objArr42 = new Object[1];
        e((byte) (bArr10[30] - 1), bArr10[9], bArr10[73], objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        byte b20 = bArr10[508];
        Object[] objArr43 = new Object[1];
        e(b20, (short) (b20 | Ascii.STX), bArr10[154], objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
        int i54 = ((int[]) objArr[3])[0];
        int i55 = ((int[]) objArr[0])[0];
        int i56 = ((int[]) objArr[1])[0];
        String[] strArr7 = (String[]) objArr[2];
        int iIdentityHashCode2 = System.identityHashCode(this);
        int i57 = ~iIdentityHashCode2;
        int i58 = (~(266878017 | i57)) | 269484814;
        int i59 = ~(iIdentityHashCode2 | (-71312449));
        int i60 = i54 + (((i58 | i59) * (-252)) - 611131243) + ((i59 | (~(i57 | 536362831))) * 252);
        int i61 = (i60 << 13) ^ i60;
        int i62 = i61 ^ (i61 >>> 17);
        ((int[]) objArr44[3])[0] = i62 ^ (i62 << 5);
    }

    static void accessartificialFrame() {
        TopicBuilder = (char) 12631;
        ICustomTabsCallback = (char) 63379;
        extraCallbackWithResult = (char) 59348;
        onMessageChannelReady = (char) 12547;
    }
}
