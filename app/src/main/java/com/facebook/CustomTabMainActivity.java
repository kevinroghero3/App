package com.facebook;

import android.app.Activity;
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
import android.net.Uri;
import android.os.Bundle;
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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.CustomTab;
import com.facebook.internal.InstagramCustomTab;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginTargetApp;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.crypto.tink.hybrid.internal.HpkePrivateKeyManager$$ExternalSyntheticLambda2;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.RandomKt;
import o.ArtificialStackFrames;
import o.ICustomTabsCallback;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.commons.lang3.CharEncoding;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class CustomTabMainActivity extends Activity {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    public static final Companion Companion;
    public static final String EXTRA_ACTION;
    public static final String EXTRA_CHROME_PACKAGE;
    public static final String EXTRA_PARAMS;
    public static final String EXTRA_TARGET_APP;
    public static final String EXTRA_URL;
    private static byte[] ICustomTabsCallbackStubProxy;
    private static short[] ICustomTabsService;
    public static final String NO_ACTIVITY_EXCEPTION;
    public static final String REFRESH_ACTION;
    private static int artificialFrame;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static int getInterfaceDescriptor;
    private static int mayLaunchUrl;
    private static int onTransact;
    private BroadcastReceiver redirectReceiver;
    private boolean shouldCloseCustomTab = true;
    private static final byte[] $$c = {55, 117, 51, -11};
    private static final int $$f = JfifUtil.MARKER_EOI;
    private static int $10 = 0;
    private static int $11 = 1;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoginTargetApp.values().length];
            try {
                iArr[LoginTargetApp.INSTAGRAM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0026). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(byte r5, byte r6, short r7) {
        /*
            byte[] r0 = com.facebook.CustomTabMainActivity.$$c
            int r5 = r5 * 2
            int r5 = r5 + 4
            int r6 = r6 * 3
            int r1 = r6 + 1
            int r7 = r7 * 5
            int r7 = 117 - r7
            byte[] r1 = new byte[r1]
            r2 = 0
            if (r0 != 0) goto L16
            r4 = r6
            r3 = r2
            goto L26
        L16:
            r3 = r2
        L17:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L22
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            return r5
        L22:
            r4 = r0[r5]
            int r3 = r3 + 1
        L26:
            int r4 = -r4
            int r7 = r7 + r4
            int r5 = r5 + 1
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.CustomTabMainActivity.$$g(byte, byte, short):java.lang.String");
    }

    private static void b(short s, int i, short s2, Object[] objArr) {
        int i2 = 112 - i;
        int i3 = 108 - s;
        byte[] bArr = $$a;
        byte[] bArr2 = new byte[21 - s2];
        int i4 = 20 - s2;
        int i5 = -1;
        if (bArr == null) {
            i2 = i3 + (-i2);
            i3 = i3;
        }
        while (true) {
            i5++;
            bArr2[i5] = (byte) i2;
            if (i5 == i4) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i6 = i3 + 1;
            i2 += -bArr[i6];
            i3 = i6;
        }
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
    private static void c(int r5, int r6, short r7, java.lang.Object[] r8) {
        /*
            byte[] r0 = com.facebook.CustomTabMainActivity.$$d
            int r7 = r7 + 36
            int r5 = r5 + 4
            int r6 = 82 - r6
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L10
            r4 = r6
            r3 = r2
            goto L24
        L10:
            r3 = r2
        L11:
            int r5 = r5 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r6) goto L22
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L22:
            r4 = r0[r5]
        L24:
            int r7 = r7 + r4
            int r7 = r7 + (-4)
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.CustomTabMainActivity.c(int, int, short, java.lang.Object[]):void");
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        String stringExtra;
        CustomTab customTab;
        super.onCreate(bundle);
        String str = CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION;
        if (Intrinsics.areEqual(str, getIntent().getAction())) {
            setResult(0);
            finish();
            return;
        }
        if (bundle != null || (stringExtra = getIntent().getStringExtra(EXTRA_ACTION)) == null) {
            return;
        }
        Bundle bundleExtra = getIntent().getBundleExtra(EXTRA_PARAMS);
        String stringExtra2 = getIntent().getStringExtra(EXTRA_CHROME_PACKAGE);
        if (WhenMappings.$EnumSwitchMapping$0[LoginTargetApp.Companion.fromString(getIntent().getStringExtra(EXTRA_TARGET_APP)).ordinal()] == 1) {
            customTab = new InstagramCustomTab(stringExtra, bundleExtra);
        } else {
            customTab = new CustomTab(stringExtra, bundleExtra);
        }
        boolean zOpenCustomTab = customTab.openCustomTab(this, stringExtra2);
        this.shouldCloseCustomTab = false;
        if (!zOpenCustomTab) {
            setResult(0, getIntent().putExtra(NO_ACTIVITY_EXCEPTION, true));
            finish();
        } else {
            BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.facebook.CustomTabMainActivity$onCreate$redirectReceiver$1
                @Override // android.content.BroadcastReceiver
                public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                    Intrinsics.checkNotNullParameter(context, "context");
                    Intrinsics.checkNotNullParameter(intent, "intent");
                    Intent intent2 = new Intent(this.this$0, (Class<?>) CustomTabMainActivity.class);
                    intent2.setAction(CustomTabMainActivity.REFRESH_ACTION);
                    String str2 = CustomTabMainActivity.EXTRA_URL;
                    intent2.putExtra(str2, intent.getStringExtra(str2));
                    intent2.addFlags(603979776);
                    this.this$0.startActivity(intent2);
                }
            };
            this.redirectReceiver = broadcastReceiver;
            LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, new IntentFilter(str));
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        if (Intrinsics.areEqual(REFRESH_ACTION, intent.getAction())) {
            LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(CustomTabActivity.DESTROY_ACTION));
            sendResult(-1, intent);
        } else if (Intrinsics.areEqual(CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION, intent.getAction())) {
            sendResult(-1, intent);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.shouldCloseCustomTab) {
            sendResult(0, null);
        }
        this.shouldCloseCustomTab = true;
    }

    private final void sendResult(int i, Intent intent) {
        BroadcastReceiver broadcastReceiver = this.redirectReceiver;
        if (broadcastReceiver != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
        }
        if (intent != null) {
            String stringExtra = intent.getStringExtra(EXTRA_URL);
            Bundle responseUri = stringExtra != null ? Companion.parseResponseUri(stringExtra) : new Bundle();
            Intent intent2 = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent2, "intent");
            Intent intentCreateProtocolResultIntent = NativeProtocol.createProtocolResultIntent(intent2, responseUri, null);
            if (intentCreateProtocolResultIntent != null) {
                intent = intentCreateProtocolResultIntent;
            }
            setResult(i, intent);
        } else {
            Intent intent3 = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent3, "intent");
            setResult(i, NativeProtocol.createProtocolResultIntent(intent3, null, null));
        }
        finish();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Bundle parseResponseUri(String str) {
            Uri uri = Uri.parse(str);
            Bundle urlQueryString = Utility.parseUrlQueryString(uri.getQuery());
            urlQueryString.putAll(Utility.parseUrlQueryString(uri.getFragment()));
            return urlQueryString;
        }
    }

    static {
        byte[] bArr = new byte[736];
        System.arraycopy("\u0002§ßÊ\u0010\u0002Å=\f\u0004ü\týÍP\u0002õ\týË9\r\u0001\u0000\r\n¾H÷\u0012\u0006û\f¾&\u0015\u0015\u0005ö\u0003ò\u0017\u0012\u0006û\f0\u0007\u0001\n\u0003ù\tûã%\u0001\u0017ö\u0004\u0006\týè-\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000ÇH÷\u0000\u0006\u0015¾Kø\bø\u0011÷\n\u0002\u0011À/\u001aüþñ%ù\u0005ï#\u0004\u0001¼\u0004%7\u0000õ\u0011\u0000÷\u000fë*ù\nø\u0001\u0013ùþí\u0019\u0010ù\u0006\u0001Ó\u0004A\u0000\u0001\u0010\u0004\u0000Çÿ?\t\nõ\u0011\u0000÷\u000fÆF\u0000ù\u0017ö\r\u0007ÿÅ7\u0011ú\u0012\u0001þÿÎ\u001a%\u0005\u0003\u0011\u0004÷\u0003ó ø\fþ\u0013Ñ'\u0001\u0013\bõ\u0011\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000Ç?\bø\n\u0002\u000fý\u000bù\u000b\u0001\tûÍ9\u0002\u0006\t\u0001Í\u001a%\u0005ÿ\u0018û\fÓ\"\u0006\t\u0001ê\u001e\u0018Ñ\u001f\u0006\u0015ÿ\u0007\u000b\u0010\u0007\u0001\n\u0003ù\tûâ3÷\u0000\u0017ù\n\u0003\b\tü\u0001\t\u000eº9\u0010\u0007\u0001\n\u0003ù\tû\u0012¿<\n\u0007\f»\u001c*\u0007\fØ-ï\u0004÷\u0017\u0003\u0015ò\u0006ê-´F\u0007\r\u0005\u0005ß'à+û\u0004¼\u0011\u0006\u0004\u0006\u0012\u0004ò\u0015\u0006ù\u0001\u0007þ\nü\u000fÞ0ó\u0010ü\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000Ç7\u0013\u0004\u0000\u0001\t\u0001\f¿\u00173\u0004à!\t\u0001Ý!\u0017ñÇ\u0011\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000Ç?\bø\n\u0002\u000fý\u000bù\u000b\u0001\tûÍ9\u0010\u0007÷Í&&\u0001ù\u0015ò\u0006\u0011å\u0016\u0010\bô\rù\u0006å\u001f\u0006\u0015ÿ\u0007\u000b¯#0\u0002\u0007õ\u0011ÿ\n\u0003\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000ÇIùý\u0015÷Í?\t\nõ\u0011\u0000÷\u000fÆ)\u0019ý\u0015÷è)\nõ\u0011\u0000÷\u000fí#ù\u0007\u0001\u000f\t¯G\u0002\u0013ã\u0019ý\u0015÷ñ\u0017\u0012\u0006û\fà&\u0001ø\u0006\u0012\u0004\u0000\u0007¶\u0011\u0010\u0002Å>\u0005\u000fñ\u0006\t\u0005ü\u0013\u0004Â;\u0017ï\u0006\u000f\bù\n\u0003\t¿#0Î*þ\u0006\u0011\u0001Ú7ï\u0006\u000f\bù\n\u0003\u0010\u0002Å=\f\u0004ü\týÍ7\u0011ú\u0012\u0001þÿÎ=\n\n¿?\t\nõ\u0011\u0000÷\u000fÆ<\u0007ÿ\u000fÃP\u0004ë\u0010\u0010\u0002Å=\f\u0004ü\týÍ<\u0007\r÷\u0001\u0003\u0016öÍ9\u0010\u0002\u0007\u0003\u0003û\r\n\u0003¿%%\bù\n\u0003÷\u000fè&\u0001\u000b÷ÿ\u0005\u0011¶\u0004%7\u0000õ\u0011\u0000÷\u000fë*ù\nø\u0001\u0013ùþí\u0019\u0010ù\u0006\u0001Õ\u0010\u0002Å=\f\u0004ü\týÍ7\u0011ú\u0012\u0001þÿÎCø\u0017õ\u0011ûü\u000fÆ9\u0010\u0001\u0007\u0007ÀK\u0003ù\u0007\u0001\u000fù\u0000\u0012¿\u001a9ù÷\u0010\u0000þä0\u0001\u0007\u0007¶\u0004%7\u0000õ\u0011\u0000÷\u000fë*ù\nø\u0001\u0013ùþí\u0019\u0010ù\u0006\u0001Ó".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 736);
        $$d = bArr;
        $$e = 240;
        $$a = new byte[]{Ascii.CAN, 50, 47, 107, 9, -18, 34, -25, -4, 17, -19, Ascii.SI, 1, Ascii.DC2, -15, -19, Ascii.VT, -5, 7, 2, -15, 36, -21, -13, Ascii.SI, -2, -9, -6, 34, -15, -19, Ascii.VT, -5, 7, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, 2, -15, 33, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, -10, Ascii.US, -20, -13, 8, Ascii.VT, Ascii.CR, -27, 9, -18, 36, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, 7, -18, 43, -29, 4, -17, -2, -49, -2, Ascii.VT, 3, -3, 6, -6, 8, -11, Ascii.EM, -33, 19, -2, -8, 37, -44, 17, -12, 8, -14, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13};
        $$b = 69;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        accessartificialFrame();
        Companion = new Companion(null);
        EXTRA_ACTION = CustomTabMainActivity.class.getSimpleName() + ".extra_action";
        EXTRA_PARAMS = CustomTabMainActivity.class.getSimpleName() + ".extra_params";
        EXTRA_CHROME_PACKAGE = CustomTabMainActivity.class.getSimpleName() + ".extra_chromePackage";
        EXTRA_URL = CustomTabMainActivity.class.getSimpleName() + ".extra_url";
        EXTRA_TARGET_APP = CustomTabMainActivity.class.getSimpleName() + ".extra_targetApp";
        REFRESH_ACTION = CustomTabMainActivity.class.getSimpleName() + ".action_refresh";
        NO_ACTIVITY_EXCEPTION = CustomTabMainActivity.class.getSimpleName() + ".no_activity_exception";
    }

    /* JADX WARN: Code duplicated, block: B:50:0x01bd A[PHI: r0
  0x01bd: PHI (r0v9 int) = (r0v8 int), (r0v39 int) binds: [B:49:0x01bb, B:46:0x01a9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:51:0x01bf A[PHI: r0
  0x01bf: PHI (r0v36 int) = (r0v8 int), (r0v39 int) binds: [B:49:0x01bb, B:46:0x01a9] A[DONT_GENERATE, DONT_INLINE]] */
    private static void a(int i, byte b, int i2, short s, int i3, Object[] objArr) throws Throwable {
        boolean z;
        int i4;
        int i5;
        int i6 = 2 % 2;
        ICustomTabsCallback iCustomTabsCallback = new ICustomTabsCallback();
        StringBuilder sb = new StringBuilder();
        try {
            Object[] objArr2 = {Integer.valueOf(i2), Integer.valueOf(mayLaunchUrl)};
            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1991297565);
            if (objAccessartificialFrame == null) {
                byte b2 = (byte) 0;
                byte b3 = b2;
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(40 - TextUtils.indexOf("", "", 0, 0), (char) ((ViewConfiguration.getKeyRepeatDelay() >> 16) + 36241), (KeyEvent.getMaxKeyCode() >> 16) + 2342, 371880939, false, $$g(b2, b3, (byte) (b3 + 1)), new Class[]{Integer.TYPE, Integer.TYPE});
            }
            Object obj = null;
            int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
            if (iIntValue == -1) {
                int i7 = $11 + 53;
                $10 = i7 % 128;
                int i8 = i7 % 2;
                z = true;
            } else {
                z = false;
            }
            char c = '0';
            if (z) {
                int i9 = $11 + 81;
                $10 = i9 % 128;
                if (i9 % 2 == 0) {
                    byte[] bArr = ICustomTabsCallbackStubProxy;
                    if (bArr != null) {
                        int length = bArr.length;
                        byte[] bArr2 = new byte[length];
                        int i10 = 0;
                        while (i10 < length) {
                            try {
                                Object[] objArr3 = {Integer.valueOf(bArr[i10])};
                                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1557994855);
                                if (objAccessartificialFrame2 == null) {
                                    byte b4 = (byte) 0;
                                    byte b5 = b4;
                                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(43 - TextUtils.indexOf("", c, 0), (char) View.resolveSizeAndState(0, 0, 0), 1215 - View.MeasureSpec.getSize(0), 1011328145, false, $$g(b4, b5, b5), new Class[]{Integer.TYPE});
                                }
                                bArr2[i10] = ((Byte) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).byteValue();
                                i10++;
                                c = '0';
                            } catch (Throwable th) {
                                Throwable cause = th.getCause();
                                if (cause == null) {
                                    throw th;
                                }
                                throw cause;
                            }
                        }
                        bArr = bArr2;
                    }
                    if (bArr != null) {
                        byte[] bArr3 = ICustomTabsCallbackStubProxy;
                        Object[] objArr4 = {Integer.valueOf(i3), Integer.valueOf(onTransact)};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1991297565);
                        if (objAccessartificialFrame3 == null) {
                            byte b6 = (byte) 0;
                            byte b7 = b6;
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(39 - MotionEvent.axisFromString(""), (char) (36240 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), KeyEvent.getDeadChar(0, 0) + 2342, 371880939, false, $$g(b6, b7, (byte) (b7 + 1)), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        iIntValue = (byte) (((byte) (((long) bArr3[((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue()]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                    } else {
                        iIntValue = (short) (((short) (((long) ICustomTabsService[i3 + ((int) (((long) onTransact) ^ (-4629754035390455669L)))]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                    }
                } else {
                    obj.hashCode();
                    throw null;
                }
            }
            if (iIntValue > 0) {
                int i11 = $10 + 113;
                $11 = i11 % 128;
                if (i11 % 2 == 0) {
                    i4 = ((i3 % iIntValue) % 4) + ((int) (((long) onTransact) | (-4629754035390455669L)));
                    if (z) {
                        i5 = 1;
                    } else {
                        i5 = 0;
                    }
                } else {
                    i4 = ((i3 + iIntValue) - 2) + ((int) (((long) onTransact) ^ (-4629754035390455669L)));
                    if (z) {
                        i5 = 1;
                    } else {
                        i5 = 0;
                    }
                }
                iCustomTabsCallback.c = i4 + i5;
                try {
                    Object[] objArr5 = {iCustomTabsCallback, Integer.valueOf(i), Integer.valueOf(getInterfaceDescriptor), sb};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(216546027);
                    if (objAccessartificialFrame4 == null) {
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(41 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) TextUtils.indexOf("", "", 0), 4065 - TextUtils.lastIndexOf("", '0', 0, 0), -1819443997, false, "x", new Class[]{Object.class, Integer.TYPE, Integer.TYPE, Object.class});
                    }
                    ((StringBuilder) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).append(iCustomTabsCallback.createConnectionCallback);
                    iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                    byte[] bArr4 = ICustomTabsCallbackStubProxy;
                    if (bArr4 != null) {
                        int length2 = bArr4.length;
                        byte[] bArr5 = new byte[length2];
                        for (int i12 = 0; i12 < length2; i12++) {
                            bArr5[i12] = (byte) (((long) bArr4[i12]) ^ (-4629754035390455669L));
                        }
                        bArr4 = bArr5;
                    }
                    boolean z2 = bArr4 != null;
                    iCustomTabsCallback.a = 1;
                    while (iCustomTabsCallback.a < iIntValue) {
                        int i13 = $11 + 9;
                        $10 = i13 % 128;
                        if (i13 % 2 != 0) {
                            throw null;
                        }
                        if (z2) {
                            byte[] bArr6 = ICustomTabsCallbackStubProxy;
                            int i14 = iCustomTabsCallback.c;
                            iCustomTabsCallback.c = i14 - 1;
                            iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((byte) (((byte) (((long) bArr6[i14]) ^ (-4629754035390455669L))) + s)) ^ b));
                        } else {
                            short[] sArr = ICustomTabsService;
                            int i15 = iCustomTabsCallback.c;
                            iCustomTabsCallback.c = i15 - 1;
                            iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((short) (((short) (((long) sArr[i15]) ^ (-4629754035390455669L))) + s)) ^ b));
                        }
                        sb.append(iCustomTabsCallback.createConnectionCallback);
                        iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                        iCustomTabsCallback.a++;
                    }
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            }
            objArr[0] = sb.toString();
        } catch (Throwable th3) {
            Throwable cause3 = th3.getCause();
            if (cause3 == null) {
                throw th3;
            }
            throw cause3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:168:0x142d  */
    /* JADX WARN: Code duplicated, block: B:169:0x14b1  */
    /* JADX WARN: Code duplicated, block: B:174:0x15ab  */
    /* JADX WARN: Code duplicated, block: B:184:0x16ed  */
    /* JADX WARN: Code duplicated, block: B:187:0x16f7 A[Catch: all -> 0x2b8d, TryCatch #8 {all -> 0x2b8d, blocks: (B:338:0x2a01, B:340:0x2a0e, B:341:0x2a3a, B:343:0x2a44, B:345:0x2a51, B:346:0x2a7e, B:225:0x1b98, B:227:0x1bbb, B:228:0x1c11, B:185:0x16f1, B:187:0x16f7, B:188:0x1723, B:190:0x174e, B:191:0x17df, B:60:0x08d8, B:62:0x08ed, B:63:0x091d), top: B:393:0x08d8 }] */
    /* JADX WARN: Code duplicated, block: B:190:0x174e A[Catch: all -> 0x2b8d, TryCatch #8 {all -> 0x2b8d, blocks: (B:338:0x2a01, B:340:0x2a0e, B:341:0x2a3a, B:343:0x2a44, B:345:0x2a51, B:346:0x2a7e, B:225:0x1b98, B:227:0x1bbb, B:228:0x1c11, B:185:0x16f1, B:187:0x16f7, B:188:0x1723, B:190:0x174e, B:191:0x17df, B:60:0x08d8, B:62:0x08ed, B:63:0x091d), top: B:393:0x08d8 }] */
    /* JADX WARN: Code duplicated, block: B:194:0x17f2  */
    /* JADX WARN: Code duplicated, block: B:199:0x185f  */
    /* JADX WARN: Code duplicated, block: B:203:0x18b8  */
    /* JADX WARN: Code duplicated, block: B:204:0x191d  */
    /* JADX WARN: Code duplicated, block: B:209:0x19fe  */
    /* JADX WARN: Code duplicated, block: B:212:0x1a52  */
    /* JADX WARN: Code duplicated, block: B:214:0x1a5e  */
    /* JADX WARN: Code duplicated, block: B:216:0x1a7d  */
    /* JADX WARN: Code duplicated, block: B:217:0x1a7f  */
    /* JADX WARN: Code duplicated, block: B:219:0x1a9e A[PHI: r2
  0x1a9e: PHI (r2v411 int) = (r2v410 int), (r2v434 int) binds: [B:218:0x1a9c, B:216:0x1a7d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:221:0x1aa7  */
    /* JADX WARN: Code duplicated, block: B:224:0x1b7a  */
    /* JADX WARN: Code duplicated, block: B:227:0x1bbb A[Catch: all -> 0x2b8d, TryCatch #8 {all -> 0x2b8d, blocks: (B:338:0x2a01, B:340:0x2a0e, B:341:0x2a3a, B:343:0x2a44, B:345:0x2a51, B:346:0x2a7e, B:225:0x1b98, B:227:0x1bbb, B:228:0x1c11, B:185:0x16f1, B:187:0x16f7, B:188:0x1723, B:190:0x174e, B:191:0x17df, B:60:0x08d8, B:62:0x08ed, B:63:0x091d), top: B:393:0x08d8 }] */
    /* JADX WARN: Code duplicated, block: B:231:0x1c24  */
    /* JADX WARN: Code duplicated, block: B:236:0x1c97  */
    /* JADX WARN: Code duplicated, block: B:240:0x1cef  */
    /* JADX WARN: Code duplicated, block: B:241:0x1d80  */
    /* JADX WARN: Code duplicated, block: B:243:0x1d8c  */
    /* JADX WARN: Code duplicated, block: B:246:0x1d90 A[LOOP:1: B:244:0x1d8d->B:246:0x1d90, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:252:0x1e80  */
    /* JADX WARN: Code duplicated, block: B:262:0x1fa7  */
    /* JADX WARN: Code duplicated, block: B:264:0x1fad  */
    /* JADX WARN: Code duplicated, block: B:266:0x210a  */
    /* JADX WARN: Code duplicated, block: B:268:0x210e  */
    /* JADX WARN: Code duplicated, block: B:272:0x211a  */
    /* JADX WARN: Code duplicated, block: B:277:0x22be  */
    /* JADX WARN: Code duplicated, block: B:279:0x22c7  */
    /* JADX WARN: Code duplicated, block: B:284:0x2337  */
    /* JADX WARN: Code duplicated, block: B:290:0x2395  */
    /* JADX WARN: Code duplicated, block: B:291:0x2421  */
    /* JADX WARN: Code duplicated, block: B:293:0x242d  */
    /* JADX WARN: Code duplicated, block: B:296:0x2431 A[LOOP:0: B:294:0x242e->B:296:0x2431, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:302:0x2524  */
    /* JADX WARN: Code duplicated, block: B:305:0x2578  */
    /* JADX WARN: Code duplicated, block: B:307:0x25a4  */
    /* JADX WARN: Code duplicated, block: B:309:0x25ad  */
    /* JADX WARN: Code duplicated, block: B:312:0x267b  */
    /* JADX WARN: Code duplicated, block: B:314:0x2682  */
    /* JADX WARN: Code duplicated, block: B:316:0x27f1  */
    /* JADX WARN: Code duplicated, block: B:318:0x27f5  */
    /* JADX WARN: Code duplicated, block: B:322:0x2801  */
    /* JADX WARN: Code duplicated, block: B:327:0x28a3  */
    /* JADX WARN: Code duplicated, block: B:332:0x2912  */
    /* JADX WARN: Code duplicated, block: B:336:0x296d  */
    /* JADX WARN: Code duplicated, block: B:337:0x29fc  */
    /* JADX WARN: Code duplicated, block: B:340:0x2a0e A[Catch: all -> 0x2b8d, TryCatch #8 {all -> 0x2b8d, blocks: (B:338:0x2a01, B:340:0x2a0e, B:341:0x2a3a, B:343:0x2a44, B:345:0x2a51, B:346:0x2a7e, B:225:0x1b98, B:227:0x1bbb, B:228:0x1c11, B:185:0x16f1, B:187:0x16f7, B:188:0x1723, B:190:0x174e, B:191:0x17df, B:60:0x08d8, B:62:0x08ed, B:63:0x091d), top: B:393:0x08d8 }] */
    /* JADX WARN: Code duplicated, block: B:345:0x2a51 A[Catch: all -> 0x2b8d, TryCatch #8 {all -> 0x2b8d, blocks: (B:338:0x2a01, B:340:0x2a0e, B:341:0x2a3a, B:343:0x2a44, B:345:0x2a51, B:346:0x2a7e, B:225:0x1b98, B:227:0x1bbb, B:228:0x1c11, B:185:0x16f1, B:187:0x16f7, B:188:0x1723, B:190:0x174e, B:191:0x17df, B:60:0x08d8, B:62:0x08ed, B:63:0x091d), top: B:393:0x08d8 }] */
    @Override // android.app.Activity
    public void onStart() throws Throwable {
        Object[] objArr;
        Object[] objArrAccessartificialFrame$78cbbd35;
        int i;
        Object[] objArr2;
        int i2;
        int i3;
        Object[] objArr3;
        Long lValueOf;
        Object objAccessartificialFrame;
        int defaultSize;
        char maximumFlingVelocity;
        int iIndexOf;
        int i4;
        boolean z;
        Object obj;
        int i5;
        int i6;
        int i7;
        Object objAccessartificialFrame2;
        long j;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        Object[] objArr4;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        Object obj2;
        int i8;
        Object obj3;
        int i9;
        int i10;
        Object objAccessartificialFrame7;
        long j2;
        Object objAccessartificialFrame8;
        Object[] objArr5;
        Object objAccessartificialFrame9;
        Object objAccessartificialFrame10;
        int i11;
        int i12;
        ArrayList arrayList;
        String[] strArr;
        int i13;
        int i14;
        Object objAccessartificialFrame11;
        long j3;
        Context baseContext;
        Object[] objArr6;
        Object objAccessartificialFrame12;
        Object objAccessartificialFrame13;
        int i15;
        int i16;
        ArrayList arrayList2;
        String[] strArr2;
        int i17;
        Object objAccessartificialFrame14;
        long j4;
        Context baseContext2;
        Object[] objArr7;
        Object objAccessartificialFrame15;
        Object objAccessartificialFrame16;
        int i18;
        int i19;
        Object objAccessartificialFrame17;
        Object objAccessartificialFrame18;
        Object objAccessartificialFrame19;
        int i20;
        int i21;
        Object objAccessartificialFrame20;
        int i22 = 2 % 2;
        Object[] objArr8 = new Object[1];
        a(Color.alpha(0) - 1228203658, (byte) (View.MeasureSpec.makeMeasureSpec(0, 0) - 64), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 3, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 21), (-1997820396) + ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion, objArr8);
        String str = (String) objArr8[0];
        Object[] objArr9 = new Object[1];
        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(1) - 1228203755, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 70), ViewConfiguration.getEdgeSlop() >> 16, (short) TextUtils.getOffsetAfter("", 0), (-1997820341) - MotionEvent.axisFromString(""), objArr9);
        String str2 = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        a(6575 - AndroidCharacter.getMirror('0'), (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) + 6), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 34, (short) TextUtils.indexOf("", "", 0), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(12) - 1997820383, objArr10);
        String str3 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        a((-1228203650) - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(11) - 119), 1 - Drawable.resolveOpacity(0, 0), (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 4), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 1997820318, objArr11);
        String str4 = (String) objArr11[0];
        Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame21 == null) {
            int packedPositionChild = 29 - ExpandableListView.getPackedPositionChild(0L);
            char cMakeMeasureSpec = (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 49362);
            int gidForName = 683 - Process.getGidForName("");
            byte[] bArr = $$a;
            Object[] objArr12 = new Object[1];
            b((byte) 105, bArr[19], (byte) (-bArr[17]), objArr12);
            objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(packedPositionChild, cMakeMeasureSpec, gidForName, 752929587, false, (String) objArr12[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame21).getLong(null);
        if (j5 == -1 || j5 + 1917 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext3 = getBaseContext();
            if (baseContext3 == null) {
                Object[] objArr13 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1228203693, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 53), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 10, (short) View.getDefaultSize(0, 0), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 1997820375, objArr13);
                Class<?> cls = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 1228203705, (byte) (70 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 2, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 4), (-1997820301) - TextUtils.indexOf("", ""), objArr14);
                baseContext3 = (Context) cls.getMethod((String) objArr14[0], new Class[0]).invoke(null, null);
            }
            if (baseContext3 != null) {
                baseContext3 = ((baseContext3 instanceof ContextWrapper) && ((ContextWrapper) baseContext3).getBaseContext() == null) ? null : baseContext3.getApplicationContext();
            }
            try {
                Object[] objArr15 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -1900384413};
                byte[] bArr2 = $$d;
                Object[] objArr16 = new Object[1];
                c(bArr2[69], bArr2[181], bArr2[140], objArr16);
                Class<?> cls2 = Class.forName((String) objArr16[0]);
                Object[] objArr17 = new Object[1];
                c(bArr2[455], bArr2[504], bArr2[235], objArr17);
                Object[] objArr18 = (Object[]) cls2.getMethod((String) objArr17[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr15);
                if (baseContext3 != null) {
                    Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-326560385);
                    if (objAccessartificialFrame22 == null) {
                        int touchSlop = 30 - (ViewConfiguration.getTouchSlop() >> 8);
                        char cBlue = (char) (49362 - Color.blue(0));
                        int iIndexOf2 = TextUtils.indexOf((CharSequence) "", '0', 0) + 685;
                        byte[] bArr3 = $$a;
                        Object[] objArr19 = new Object[1];
                        b((byte) 90, bArr3[4], (byte) (-bArr3[17]), objArr19);
                        objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(touchSlop, cBlue, iIndexOf2, 1944867703, false, (String) objArr19[0], null);
                    }
                    ((Field) objAccessartificialFrame22).set(null, objArr18);
                    try {
                        Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                        if (objAccessartificialFrame23 == null) {
                            int iIndexOf3 = TextUtils.indexOf((CharSequence) "", '0', 0) + 31;
                            char cResolveSizeAndState = (char) (View.resolveSizeAndState(0, 0, 0) + 49362);
                            int i23 = 683 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                            byte[] bArr4 = $$a;
                            Object[] objArr20 = new Object[1];
                            b((byte) 105, bArr4[19], (byte) (-bArr4[17]), objArr20);
                            objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(iIndexOf3, cResolveSizeAndState, i23, 752929587, false, (String) objArr20[0], null);
                        }
                        ((Field) objAccessartificialFrame23).set(null, lValueOf2);
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
            Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-326560385);
            if (objAccessartificialFrame24 == null) {
                int pressedStateDuration = 30 - (ViewConfiguration.getPressedStateDuration() >> 16);
                char cMyTid = (char) ((Process.myTid() >> 22) + 49362);
                int i24 = 685 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                byte[] bArr5 = $$a;
                Object[] objArr21 = new Object[1];
                b((byte) 90, bArr5[4], (byte) (-bArr5[17]), objArr21);
                objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(pressedStateDuration, cMyTid, i24, 1944867703, false, (String) objArr21[0], null);
            }
            Object[] objArr22 = (Object[]) ((Field) objAccessartificialFrame24).get(null);
            objArr = new Object[]{new int[]{((int[]) objArr22[0])[0]}, new int[]{((int[]) objArr22[1])[0]}, new int[1], (String) objArr22[3]};
            int i25 = ~Process.myPid();
            int i26 = (((1524118118 + ((~(969841822 | i25)) * 52)) + (((~(566662274 | i25)) | ((~((-411961501) | i25)) | 403179548)) * (-52))) + (((~(i25 | (-566662275))) | 557880322) * 52)) - 1900384413;
            int i27 = (i26 << 13) ^ i26;
            int i28 = i27 ^ (i27 >>> 17);
            ((int[]) objArr[2])[0] = i28 ^ (i28 << 5);
        }
        int i29 = ((int[]) objArr[1])[0];
        int i30 = ((int[]) objArr[0])[0];
        if (i30 == i29) {
            int i31 = ((int[]) objArr[2])[0];
            Object[] objArr23 = {new int[]{((int[]) objArr[0])[0]}, new int[]{((int[]) objArr[1])[0]}, new int[1], (String) objArr[3]};
            int startUptimeMillis = (int) Process.getStartUptimeMillis();
            int i32 = i31 + (-1738425822) + (((~((-362547843) | startUptimeMillis)) | (-901552799)) * (-502)) + ((~((~startUptimeMillis) | (-285476867))) * (-502)) + (((~(startUptimeMillis | (-616075933))) | (-362547843)) * TypedValues.PositionType.TYPE_DRAWPATH);
            int i33 = (i32 << 13) ^ i32;
            int i34 = i33 ^ (i33 >>> 17);
            ((int[]) objArr23[2])[0] = i34 ^ (i34 << 5);
        } else {
            long j6 = ((long) (i29 ^ i30)) ^ (((long) 597320561) << 32);
            long j7 = 597320565;
            int i35 = getARTIFICIAL_FRAME_PACKAGE_NAME + 101;
            artificialFrame = i35 % 128;
            int i36 = i35 % 2;
            try {
                Object[] objArr24 = {Long.valueOf(j6), Long.valueOf(j7)};
                byte[] bArr6 = $$d;
                Object[] objArr25 = new Object[1];
                c(bArr6[68], bArr6[114], bArr6[140], objArr25);
                Class<?> cls3 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                c((short) WebSocketProtocol.PAYLOAD_SHORT, (byte) (bArr6[14] - 1), bArr6[23], objArr26);
                cls3.getMethod((String) objArr26[0], Long.TYPE, Long.TYPE).invoke(null, objArr24);
                int i37 = ((int[]) objArr[2])[0];
                Object[] objArr27 = {new int[]{((int[]) objArr[0])[0]}, new int[]{((int[]) objArr[1])[0]}, new int[1], (String) objArr[3]};
                int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 1485209346;
                int i38 = ~length;
                int i39 = ~(1009296014 | i38);
                int i40 = i37 + (-744398162) + (((-1039968240) | i39) * (-712)) + (((~(length | (-30672226))) | (~(i38 | 1039968239))) * (-712)) + ((30672239 | i39) * 712);
                int i41 = (i40 << 13) ^ i40;
                int i42 = i41 ^ (i41 >>> 17);
                ((int[]) objArr27[2])[0] = i42 ^ (i42 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame25 == null) {
            int trimmedLength = 26 - TextUtils.getTrimmedLength("");
            char packedPositionType = (char) ExpandableListView.getPackedPositionType(0L);
            int mirror = AndroidCharacter.getMirror('0') + 993;
            byte[] bArr7 = $$a;
            byte b = (byte) (bArr7[12] - 1);
            byte b2 = bArr7[48];
            Object[] objArr28 = new Object[1];
            b((byte) 75, b, b2, objArr28);
            objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(trimmedLength, packedPositionType, mirror, 2061780482, false, (String) objArr28[0], null);
        }
        long j8 = ((Field) objAccessartificialFrame25).getLong(null);
        if (j8 == -1 || j8 + 4611686018427387858L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            try {
                Object[] objArr29 = {-1358213627};
                Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame26 == null) {
                    objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", "") + 8, (char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 22251), TextUtils.lastIndexOf("", '0', 0, 0) + 1034, 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = HpkePrivateKeyManager$$ExternalSyntheticLambda2.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame26).newInstance(objArr29), 1459614203, false);
                Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame27 == null) {
                    int i43 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 25;
                    char cIndexOf = (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0'));
                    int longPressTimeout = (ViewConfiguration.getLongPressTimeout() >> 16) + 1041;
                    byte b3 = (byte) ($$b - 2);
                    byte[] bArr8 = $$a;
                    Object[] objArr30 = new Object[1];
                    b(b3, (byte) (bArr8[12] - 1), bArr8[48], objArr30);
                    objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(i43, cIndexOf, longPressTimeout, 1145017376, false, (String) objArr30[0], null);
                }
                ((Field) objAccessartificialFrame27).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame28 == null) {
                        int packedPositionGroup = ExpandableListView.getPackedPositionGroup(0L) + 26;
                        char c = (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                        int defaultSize2 = 1041 - View.getDefaultSize(0, 0);
                        byte[] bArr9 = $$a;
                        Object[] objArr31 = new Object[1];
                        b((byte) 75, (byte) (bArr9[12] - 1), bArr9[48], objArr31);
                        objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(packedPositionGroup, c, defaultSize2, 2061780482, false, (String) objArr31[0], null);
                    }
                    ((Field) objAccessartificialFrame28).set(null, lValueOf3);
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
            Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame29 == null) {
                int i44 = 25 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                char packedPositionType2 = (char) ExpandableListView.getPackedPositionType(0L);
                int iRgb = Color.rgb(0, 0, 0) + 16778257;
                byte b4 = (byte) ($$b - 2);
                byte[] bArr10 = $$a;
                Object[] objArr32 = new Object[1];
                b(b4, (byte) (bArr10[12] - 1), bArr10[48], objArr32);
                objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(i44, packedPositionType2, iRgb, 1145017376, false, (String) objArr32[0], null);
            }
            Object[] objArr33 = (Object[]) ((Field) objAccessartificialFrame29).get(null);
            objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
            int i45 = ((int[]) objArr33[3])[0];
            int i46 = ((int[]) objArr33[2])[0];
            String[] strArr3 = (String[]) objArr33[0];
            int i47 = ~(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 371003253);
            int i48 = 397471774 + (((~(i47 | 973510588)) | 89669633) * (-160)) + (((~(i47 | 895406781)) | 973510588) * SyslogConstants.LOG_LOCAL4) + 1459614203;
            int i49 = (i48 << 13) ^ i48;
            int i50 = i49 ^ (i49 >>> 17);
            ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i50 ^ (i50 << 5);
        }
        int i51 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i52 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i52 == i51) {
            Object[] objArr34 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i53 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i54 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i55 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
            int i56 = ~iFreeMemory;
            int i57 = i53 + (-157691680) + (((~(268803875 | i56)) | 346907682) * 226) + (((~(i56 | 346947363)) | 268764194 | (~((-346907683) | iFreeMemory))) * (-113)) + ((~(iFreeMemory | 268803875)) * 113);
            int i58 = (i57 << 13) ^ i57;
            int i59 = i58 ^ (i58 >>> 17);
            ((int[]) objArr34[1])[0] = i59 ^ (i59 << 5);
            i = 0;
        } else {
            ArrayList arrayList3 = new ArrayList();
            String[] strArr5 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr5 != null) {
                for (String str5 : strArr5) {
                    arrayList3.add(str5);
                }
            }
            Object[] objArr35 = {Long.valueOf(((long) (i51 ^ i52)) ^ (((long) 144551062) << 32)), Long.valueOf(144551060)};
            short s = (short) ($$e & 896);
            byte[] bArr11 = $$d;
            Object[] objArr36 = new Object[1];
            c(s, (byte) (-bArr11[403]), bArr11[83], objArr36);
            Class<?> cls4 = Class.forName((String) objArr36[0]);
            Object[] objArr37 = new Object[1];
            c((short) WebSocketProtocol.PAYLOAD_SHORT, (byte) (bArr11[14] - 1), bArr11[23], objArr37);
            cls4.getMethod((String) objArr37[0], Long.TYPE, Long.TYPE).invoke(null, objArr35);
            Object[] objArr38 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i60 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i61 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i62 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr6 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int length2 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 30348;
            int i63 = (~(692746181 | length2)) | 78645248;
            int i64 = ~length2;
            int i65 = i60 + (-182523662) + ((i63 | (~((-541442) | i64))) * 886) + (((~(i64 | (-692746182))) | 770849988) * (-1772)) + ((~(i64 | 770849988)) * 886);
            int i66 = (i65 << 13) ^ i65;
            int i67 = i66 ^ (i66 >>> 17);
            i = 0;
            ((int[]) objArr38[1])[0] = i67 ^ (i67 << 5);
        }
        Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame30 == null) {
            int i68 = 30 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
            char defaultSize3 = (char) (View.getDefaultSize(i, i) + 49362);
            int size = 684 - View.MeasureSpec.getSize(i);
            byte[] bArr12 = $$a;
            Object[] objArr39 = new Object[1];
            b((byte) 59, bArr12[4], bArr12[66], objArr39);
            objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(i68, defaultSize3, size, -1583976536, false, (String) objArr39[0], null);
        }
        long j9 = ((Field) objAccessartificialFrame30).getLong(null);
        if (j9 == -1 || j9 + 1986 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr40 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -879134571};
            byte[] bArr13 = $$d;
            Object[] objArr41 = new Object[1];
            c((short) 182, (byte) (-bArr13[403]), bArr13[140], objArr41);
            Class<?> cls5 = Class.forName((String) objArr41[0]);
            Object[] objArr42 = new Object[1];
            c((short) ($$e - 4), bArr13[132], bArr13[140], objArr42);
            objArr2 = (Object[]) cls5.getMethod((String) objArr42[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr40);
            Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame31 == null) {
                int iAxisFromString = MotionEvent.axisFromString("") + 31;
                char c2 = (char) ((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 49362);
                int packedPositionChild2 = ExpandableListView.getPackedPositionChild(0L) + 685;
                byte[] bArr14 = $$a;
                Object[] objArr43 = new Object[1];
                b(bArr14[2], bArr14[18], bArr14[48], objArr43);
                objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(iAxisFromString, c2, packedPositionChild2, -1456483158, false, (String) objArr43[0], null);
            }
            ((Field) objAccessartificialFrame31).set(null, objArr2);
            try {
                Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame32 == null) {
                    int i69 = 29 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                    char c3 = (char) (49363 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                    int iCombineMeasuredStates = View.combineMeasuredStates(0, 0) + 684;
                    byte[] bArr15 = $$a;
                    Object[] objArr44 = new Object[1];
                    b((byte) 59, bArr15[4], bArr15[66], objArr44);
                    objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(i69, c3, iCombineMeasuredStates, -1583976536, false, (String) objArr44[0], null);
                }
                ((Field) objAccessartificialFrame32).set(null, lValueOf4);
            } catch (Exception unused3) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame33 == null) {
                int minimumFlingVelocity = 30 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                char cRgb = (char) (Color.rgb(0, 0, 0) + 16826578);
                int maxKeyCode = (KeyEvent.getMaxKeyCode() >> 16) + 684;
                byte[] bArr16 = $$a;
                Object[] objArr45 = new Object[1];
                b(bArr16[2], bArr16[18], bArr16[48], objArr45);
                objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity, cRgb, maxKeyCode, -1456483158, false, (String) objArr45[0], null);
            }
            Object[] objArr46 = (Object[]) ((Field) objAccessartificialFrame33).get(null);
            objArr2 = new Object[]{new int[]{((int[]) objArr46[0])[0]}, new int[]{((int[]) objArr46[1])[0]}, new int[1], (String) objArr46[3]};
            int iIdentityHashCode = System.identityHashCode(this);
            int i70 = (((((~(iIdentityHashCode | 284833724)) | 693790050) * 56) + 647790166) + (((~((~iIdentityHashCode) | 693790050)) | 284833724) * 56)) - 879134571;
            int i71 = (i70 << 13) ^ i70;
            int i72 = i71 ^ (i71 >>> 17);
            ((int[]) objArr2[2])[0] = i72 ^ (i72 << 5);
            int i73 = getARTIFICIAL_FRAME_PACKAGE_NAME + 73;
            artificialFrame = i73 % 128;
            if (i73 % 2 == 0) {
                int i74 = 2 % 4;
            }
        }
        int i75 = ((int[]) objArr2[1])[0];
        int i76 = ((int[]) objArr2[0])[0];
        if (i76 == i75) {
            int i77 = ((int[]) objArr2[2])[0];
            Object[] objArr47 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int mode = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getMode();
            int i78 = i77 + 395406744 + (((-94570497) | mode) * (-627)) + (((~((-442299288) | mode)) | 536324487) * (-627)) + (((~(mode | 536324487)) | (~((~mode) | 442299287))) * 627);
            int i79 = (i78 << 13) ^ i78;
            int i80 = i79 ^ (i79 >>> 17);
            i2 = 0;
            ((int[]) objArr47[2])[0] = i80 ^ (i80 << 5);
        } else {
            new ArrayList().add((String) objArr2[3]);
            Object[] objArr48 = {Long.valueOf(((long) (i75 ^ i76)) ^ (((long) (-450049626)) << 32)), Long.valueOf(-450049610)};
            byte[] bArr17 = $$d;
            Object[] objArr49 = new Object[1];
            c(bArr17[68], bArr17[114], bArr17[140], objArr49);
            Class<?> cls6 = Class.forName((String) objArr49[0]);
            Object[] objArr50 = new Object[1];
            c((short) WebSocketProtocol.PAYLOAD_SHORT, (byte) (bArr17[14] - 1), bArr17[23], objArr50);
            cls6.getMethod((String) objArr50[0], Long.TYPE, Long.TYPE).invoke(null, objArr48);
            int i81 = ((int[]) objArr2[2])[0];
            Object[] objArr51 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int i82 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().densityDpi;
            int i83 = ~i82;
            int i84 = i81 + (-2125868810) + (((~(i82 | 70010052)) | (~((-69746753) | i83)) | (-908877023)) * (-68)) + ((~((-838866971) | i83)) * (-68)) + (((~((-70010053) | i83)) | (-908613723)) * 68);
            int i85 = (i84 << 13) ^ i84;
            int i86 = i85 ^ (i85 >>> 17);
            i2 = 0;
            ((int[]) objArr51[2])[0] = i86 ^ (i86 << 5);
        }
        Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame34 == null) {
            int iCombineMeasuredStates2 = 30 - View.combineMeasuredStates(i2, i2);
            char cLastIndexOf = (char) (49361 - TextUtils.lastIndexOf("", '0'));
            int threadPriority = ((Process.getThreadPriority(i2) + 20) >> 6) + 684;
            byte[] bArr18 = $$a;
            Object[] objArr52 = new Object[1];
            b((byte) (-bArr18[45]), bArr18[19], bArr18[66], objArr52);
            objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates2, cLastIndexOf, threadPriority, 508509282, false, (String) objArr52[0], null);
        }
        long j10 = ((Field) objAccessartificialFrame34).getLong(null);
        if (j10 != -1) {
            if (j10 + 1882 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame35 == null) {
                    int offsetBefore = TextUtils.getOffsetBefore("", 0) + 30;
                    char cIndexOf2 = (char) (49361 - TextUtils.indexOf((CharSequence) "", '0', 0));
                    int deadChar = 684 - KeyEvent.getDeadChar(0, 0);
                    byte[] bArr19 = $$a;
                    Object[] objArr53 = new Object[1];
                    b((byte) (-bArr19[69]), bArr19[66], bArr19[68], objArr53);
                    objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(offsetBefore, cIndexOf2, deadChar, -1321816393, false, (String) objArr53[0], null);
                }
                Object[] objArr54 = (Object[]) ((Field) objAccessartificialFrame35).get(null);
                objArr3 = new Object[]{new int[]{((int[]) objArr54[0])[0]}, new int[]{((int[]) objArr54[1])[0]}, new int[1], (String) objArr54[3]};
                int i87 = ~System.identityHashCode(this);
                int i88 = (((~((-29318924) | i87)) | 9772547) * (-241)) + 244821729 + (((~(i87 | (-19546377))) | 939532304) * 241) + 1693171692;
                int i89 = (i88 << 13) ^ i88;
                int i90 = i89 ^ (i89 >>> 17);
                ((int[]) objArr3[2])[0] = i90 ^ (i90 << 5);
            } else {
                i3 = 0;
            }
            i5 = ((int[]) objArr3[1])[0];
            i6 = ((int[]) objArr3[0])[0];
            if (i6 == i5) {
                int i91 = ((int[]) objArr3[2])[0];
                Object[] objArr55 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
                int i92 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenHeightDp;
                int i93 = ~i92;
                int i94 = i91 + 492107934 + (((~(972986111 | i93)) | 5637663) * 220) + (((~(i93 | 685643391)) | 292980383) * (-440)) + ((i92 | 972986111) * 220);
                int i95 = (i94 << 13) ^ i94;
                int i96 = i95 ^ (i95 >>> 17);
                i7 = 0;
                ((int[]) objArr55[2])[0] = i96 ^ (i96 << 5);
            } else {
                Object[] objArr56 = {Long.valueOf((((long) 684080057) << 32) ^ ((long) (i5 ^ i6))), Long.valueOf(684079545)};
                byte[] bArr20 = $$d;
                Object[] objArr57 = new Object[1];
                c((short) 325, bArr20[93], bArr20[140], objArr57);
                Class<?> cls7 = Class.forName((String) objArr57[0]);
                Object[] objArr58 = new Object[1];
                c((short) WebSocketProtocol.PAYLOAD_SHORT, (byte) (bArr20[14] - 1), bArr20[23], objArr58);
                cls7.getMethod((String) objArr58[0], Long.TYPE, Long.TYPE).invoke(null, objArr56);
                int i97 = ((int[]) objArr3[2])[0];
                Object[] objArr59 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
                int i98 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 929090659;
                int i99 = ~i98;
                int i100 = i97 + (-399851326) + (((~((-54466101) | i99)) | (~((-924157675) | i98))) * 210) + (((~(i98 | (-2756629))) | (~(i99 | (-872448203)))) * 210);
                int i101 = (i100 << 13) ^ i100;
                int i102 = i101 ^ (i101 >>> 17);
                i7 = 0;
                ((int[]) objArr59[2])[0] = i102 ^ (i102 << 5);
            }
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1168947751);
            if (objAccessartificialFrame2 == null) {
                int iResolveSize = View.resolveSize(i7, i7) + 36;
                char c4 = (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                int iIndexOf4 = 540 - TextUtils.indexOf("", "");
                byte[] bArr21 = $$a;
                Object[] objArr60 = new Object[1];
                b((byte) 75, (byte) (bArr21[12] - 1), bArr21[48], objArr60);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iResolveSize, c4, iIndexOf4, 624296913, false, (String) objArr60[0], null);
            }
            j = ((Field) objAccessartificialFrame2).getLong(null);
            if (j != -1 || j + 1925 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1717965552);
                if (objAccessartificialFrame3 == null) {
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(Gravity.getAbsoluteGravity(0, 0) + 20, (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 39517), 982 - Color.argb(0, 0, 0, 0), 117222168, false, null, new Class[0]);
                }
                Object[] objArr61 = {null, ((Constructor) objAccessartificialFrame3).newInstance(null), 653680888, 0};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-501205803);
                if (objAccessartificialFrame4 == null) {
                    int iMakeMeasureSpec = 36 - View.MeasureSpec.makeMeasureSpec(0, 0);
                    char cRgb2 = (char) (ViewCompat.MEASURED_STATE_MASK - Color.rgb(0, 0, 0));
                    int iIndexOf5 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 541;
                    byte[] bArr22 = $$a;
                    Object[] objArr62 = new Object[1];
                    b((byte) (-bArr22[64]), bArr22[2], (byte) (bArr22[12] - 1), objArr62);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec, cRgb2, iIndexOf5, 2101703389, false, (String) objArr62[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(54 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (833 - (ViewConfiguration.getLongPressTimeout() >> 16)), ExpandableListView.getPackedPositionChild(0L) + 577), (Class) ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollBarSize() >> 8) + 54, (char) Color.red(0), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 630), Integer.TYPE, Integer.TYPE});
                }
                objArr4 = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr61);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                if (objAccessartificialFrame5 == null) {
                    int iIndexOf6 = 36 - TextUtils.indexOf("", "", 0);
                    char keyRepeatDelay = (char) (ViewConfiguration.getKeyRepeatDelay() >> 16);
                    int iRgb2 = (-16776676) - Color.rgb(0, 0, 0);
                    byte b5 = (byte) ($$b - 2);
                    byte[] bArr23 = $$a;
                    Object[] objArr63 = new Object[1];
                    b(b5, (byte) (bArr23[12] - 1), bArr23[48], objArr63);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iIndexOf6, keyRepeatDelay, iRgb2, 793268735, false, (String) objArr63[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr4);
                try {
                    Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                    if (objAccessartificialFrame6 == null) {
                        int iAxisFromString2 = MotionEvent.axisFromString("") + 37;
                        char cAlpha = (char) Color.alpha(0);
                        int iResolveSize2 = 540 - View.resolveSize(0, 0);
                        byte[] bArr24 = $$a;
                        Object[] objArr64 = new Object[1];
                        b((byte) 75, (byte) (bArr24[12] - 1), bArr24[48], objArr64);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iAxisFromString2, cAlpha, iResolveSize2, 624296913, false, (String) objArr64[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf5);
                } catch (Exception unused4) {
                    throw new RuntimeException();
                }
            } else {
                Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                if (objAccessartificialFrame36 == null) {
                    int maximumDrawingCacheSize = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 36;
                    char trimmedLength2 = (char) TextUtils.getTrimmedLength("");
                    int deadChar2 = KeyEvent.getDeadChar(0, 0) + 540;
                    byte b6 = (byte) ($$b - 2);
                    byte[] bArr25 = $$a;
                    Object[] objArr65 = new Object[1];
                    b(b6, (byte) (bArr25[12] - 1), bArr25[48], objArr65);
                    objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize, trimmedLength2, deadChar2, 793268735, false, (String) objArr65[0], null);
                }
                Object[] objArr66 = (Object[]) ((Field) objAccessartificialFrame36).get(null);
                objArr4 = new Object[]{new int[1], new int[1], new int[1]};
                int i103 = ((int[]) objArr66[2])[0];
                int i104 = ((int[]) objArr66[1])[0];
                ((int[]) objArr4[2])[0] = i103;
                ((int[]) objArr4[1])[0] = i104;
                int ringerMode = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getRingerMode();
                int i105 = ~ringerMode;
                int i106 = 2080725605 + (((~((-366963740) | i105)) | (~((-984658011) | ringerMode))) * JfifUtil.MARKER_EOI) + (((~(ringerMode | (-366963740))) | 277880858) * JfifUtil.MARKER_EOI) + (((~((-984658011) | i105)) | 366963739) * JfifUtil.MARKER_EOI) + 653680888;
                int i107 = (i106 << 13) ^ i106;
                int i108 = i107 ^ (i107 >>> 17);
                ((int[]) objArr4[0])[0] = i108 ^ (i108 << 5);
            }
            obj2 = objArr4[1];
            i8 = ((int[]) obj2)[0];
            obj3 = objArr4[2];
            i9 = ((int[]) obj3)[0];
            if (i9 == i8) {
                int i109 = getARTIFICIAL_FRAME_PACKAGE_NAME + 117;
                artificialFrame = i109 % 128;
                int i110 = i109 % 2;
                Object[] objArr67 = {new int[1], new int[1], new int[1]};
                int i111 = ((int[]) objArr4[0])[0];
                int i112 = ((int[]) obj3)[0];
                int i113 = ((int[]) obj2)[0];
                ((int[]) objArr67[2])[0] = i112;
                ((int[]) objArr67[1])[0] = i113;
                int iIdentityHashCode2 = System.identityHashCode(this);
                int i114 = i111 + (-68778521) + (((~iIdentityHashCode2) | 555753730) * 1324) + (((~(iIdentityHashCode2 | 622946643)) | (~(728675106 | iIdentityHashCode2))) * (-1324)) + 41869366;
                int i115 = (i114 << 13) ^ i114;
                int i116 = i115 ^ (i115 >>> 17);
                i10 = 0;
                ((int[]) objArr67[0])[0] = i116 ^ (i116 << 5);
            } else {
                Object[] objArr68 = {Long.valueOf((((long) (-1004996904)) << 32) ^ ((long) (i8 ^ i9))), Long.valueOf(-1005001000)};
                byte[] bArr26 = $$d;
                Object[] objArr69 = new Object[1];
                c((short) 325, bArr26[93], bArr26[140], objArr69);
                Class<?> cls8 = Class.forName((String) objArr69[0]);
                Object[] objArr70 = new Object[1];
                c((short) WebSocketProtocol.PAYLOAD_SHORT, (byte) (bArr26[14] - 1), bArr26[23], objArr70);
                cls8.getMethod((String) objArr70[0], Long.TYPE, Long.TYPE).invoke(null, objArr68);
                Object[] objArr71 = {new int[1], new int[1], new int[1]};
                int i117 = ((int[]) objArr4[0])[0];
                int i118 = ((int[]) objArr4[2])[0];
                int i119 = ((int[]) objArr4[1])[0];
                ((int[]) objArr71[2])[0] = i118;
                ((int[]) objArr71[1])[0] = i119;
                int i120 = ~((int) Runtime.getRuntime().maxMemory());
                int i121 = i117 + (-53549055) + ((~(1073739763 | i120)) * 52) + (((~(400237795 | i120)) | (~((-951383955) | i120)) | 673501968) * (-52)) + (((~(i120 | (-400237796))) | 122355809) * 52);
                int i122 = (i121 << 13) ^ i121;
                int i123 = i122 ^ (i122 >>> 17);
                i10 = 0;
                ((int[]) objArr71[0])[0] = i123 ^ (i123 << 5);
            }
            objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame7 == null) {
                int i124 = 25 - (ExpandableListView.getPackedPositionForGroup(i10) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(i10) == 0L ? 0 : -1));
                char pressedStateDuration2 = (char) (30068 - (ViewConfiguration.getPressedStateDuration() >> 16));
                int iMyPid = 816 - (Process.myPid() >> 22);
                byte[] bArr27 = $$a;
                Object[] objArr72 = new Object[1];
                b((byte) 75, (byte) (bArr27[12] - 1), bArr27[48], objArr72);
                objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(i124, pressedStateDuration2, iMyPid, 721586079, false, (String) objArr72[0], null);
            }
            j2 = ((Field) objAccessartificialFrame7).getLong(null);
            if (j2 != -1) {
                i20 = artificialFrame + 69;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i20 % 128;
                if (i20 % 2 != 0) {
                    i21 = 0;
                    if (j2 + 1998 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                        objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                        if (objAccessartificialFrame20 == null) {
                            int bitsPerPixel = ImageFormat.getBitsPerPixel(i21) + 26;
                            char edgeSlop = (char) (30068 - (ViewConfiguration.getEdgeSlop() >> 16));
                            int capsMode = TextUtils.getCapsMode("", i21, i21) + 816;
                            byte b7 = (byte) ($$b - 2);
                            byte[] bArr28 = $$a;
                            Object[] objArr73 = new Object[1];
                            b(b7, (byte) (bArr28[12] - 1), bArr28[48], objArr73);
                            objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(bitsPerPixel, edgeSlop, capsMode, 891606461, false, (String) objArr73[0], null);
                        }
                        Object[] objArr74 = (Object[]) ((Field) objAccessartificialFrame20).get(null);
                        objArr5 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                        int i125 = ((int[]) objArr74[0])[0];
                        int i126 = ((int[]) objArr74[1])[0];
                        String[] strArr7 = (String[]) objArr74[2];
                        int i127 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().densityDpi;
                        int i128 = 729408813 + (((~(650075371 | i127)) | (-451903006)) * 672);
                        int i129 = ~i127;
                        int i130 = i128 + (((~(i127 | (-451903006))) | (~((-650075372) | i129))) * (-672)) + (((~(451903005 | i129)) | (-1056931584)) * 672) + 1352200332;
                        int i131 = (i130 << 13) ^ i130;
                        int i132 = i131 ^ (i131 >>> 17);
                        ((int[]) objArr5[3])[0] = i132 ^ (i132 << 5);
                    } else {
                        Object[] objArr75 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1352200332};
                        objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(1327366003);
                        if (objAccessartificialFrame8 == null) {
                            int i133 = 25 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                            char bitsPerPixel2 = (char) (30067 - ImageFormat.getBitsPerPixel(0));
                            int i134 = 817 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                            byte[] bArr29 = $$a;
                            byte b8 = (byte) (bArr29[12] - 1);
                            Object[] objArr76 = new Object[1];
                            b(b8, (byte) (b8 | Ascii.FS), bArr29[4], objArr76);
                            objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i133, bitsPerPixel2, i134, -797394565, false, (String) objArr76[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                        }
                        objArr5 = (Object[]) ((Method) objAccessartificialFrame8).invoke(null, objArr75);
                        objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                        if (objAccessartificialFrame9 == null) {
                            int longPressTimeout2 = 25 - (ViewConfiguration.getLongPressTimeout() >> 16);
                            char c5 = (char) (30069 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                            int iLastIndexOf = 815 - TextUtils.lastIndexOf("", '0', 0);
                            byte b9 = (byte) ($$b - 2);
                            byte[] bArr30 = $$a;
                            byte b10 = (byte) (bArr30[12] - 1);
                            byte b11 = bArr30[48];
                            Object[] objArr77 = new Object[1];
                            b(b9, b10, b11, objArr77);
                            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(longPressTimeout2, c5, iLastIndexOf, 891606461, false, (String) objArr77[0], null);
                        }
                        ((Field) objAccessartificialFrame9).set(null, objArr5);
                        Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame10 == null) {
                            int iKeyCodeFromString = 25 - KeyEvent.keyCodeFromString("");
                            char gidForName2 = (char) (Process.getGidForName("") + 30069);
                            int mode2 = 816 - View.MeasureSpec.getMode(0);
                            byte[] bArr31 = $$a;
                            Object[] objArr78 = new Object[1];
                            b((byte) 75, (byte) (bArr31[12] - 1), bArr31[48], objArr78);
                            objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString, gidForName2, mode2, 721586079, false, (String) objArr78[0], null);
                        }
                        ((Field) objAccessartificialFrame10).set(null, lValueOf6);
                    }
                } else if (j2 % 1998 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[1]).invoke(null, new Object[1])).longValue()) {
                    i21 = 0;
                    objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame20 == null) {
                        int bitsPerPixel3 = ImageFormat.getBitsPerPixel(i21) + 26;
                        char edgeSlop2 = (char) (30068 - (ViewConfiguration.getEdgeSlop() >> 16));
                        int capsMode2 = TextUtils.getCapsMode("", i21, i21) + 816;
                        byte b12 = (byte) ($$b - 2);
                        byte[] bArr210 = $$a;
                        Object[] objArr79 = new Object[1];
                        b(b12, (byte) (bArr210[12] - 1), bArr210[48], objArr79);
                        objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(bitsPerPixel3, edgeSlop2, capsMode2, 891606461, false, (String) objArr79[0], null);
                    }
                    Object[] objArr710 = (Object[]) ((Field) objAccessartificialFrame20).get(null);
                    objArr5 = new Object[]{new int[]{i125}, new int[]{i126}, strArr7, new int[1]};
                    int i1210 = ((int[]) objArr710[0])[0];
                    int i1211 = ((int[]) objArr710[1])[0];
                    String[] strArr8 = (String[]) objArr710[2];
                    int i1212 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().densityDpi;
                    int i1213 = 729408813 + (((~(650075371 | i1212)) | (-451903006)) * 672);
                    int i1214 = ~i1212;
                    int i135 = i1213 + (((~(i1212 | (-451903006))) | (~((-650075372) | i1214))) * (-672)) + (((~(451903005 | i1214)) | (-1056931584)) * 672) + 1352200332;
                    int i136 = (i135 << 13) ^ i135;
                    int i137 = i136 ^ (i136 >>> 17);
                    ((int[]) objArr5[3])[0] = i137 ^ (i137 << 5);
                } else {
                    Object[] objArr711 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1352200332};
                    objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame8 == null) {
                        int i138 = 25 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                        char bitsPerPixel4 = (char) (30067 - ImageFormat.getBitsPerPixel(0));
                        int i139 = 817 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                        byte[] bArr211 = $$a;
                        byte b13 = (byte) (bArr211[12] - 1);
                        Object[] objArr712 = new Object[1];
                        b(b13, (byte) (b13 | Ascii.FS), bArr211[4], objArr712);
                        objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i138, bitsPerPixel4, i139, -797394565, false, (String) objArr712[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr5 = (Object[]) ((Method) objAccessartificialFrame8).invoke(null, objArr711);
                    objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame9 == null) {
                        int longPressTimeout3 = 25 - (ViewConfiguration.getLongPressTimeout() >> 16);
                        char c6 = (char) (30069 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                        int iLastIndexOf2 = 815 - TextUtils.lastIndexOf("", '0', 0);
                        byte b14 = (byte) ($$b - 2);
                        byte[] bArr32 = $$a;
                        byte b15 = (byte) (bArr32[12] - 1);
                        byte b16 = bArr32[48];
                        Object[] objArr713 = new Object[1];
                        b(b14, b15, b16, objArr713);
                        objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(longPressTimeout3, c6, iLastIndexOf2, 891606461, false, (String) objArr713[0], null);
                    }
                    ((Field) objAccessartificialFrame9).set(null, objArr5);
                    try {
                        Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame10 == null) {
                            int iKeyCodeFromString2 = 25 - KeyEvent.keyCodeFromString("");
                            char gidForName3 = (char) (Process.getGidForName("") + 30069);
                            int mode3 = 816 - View.MeasureSpec.getMode(0);
                            byte[] bArr33 = $$a;
                            Object[] objArr714 = new Object[1];
                            b((byte) 75, (byte) (bArr33[12] - 1), bArr33[48], objArr714);
                            objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString2, gidForName3, mode3, 721586079, false, (String) objArr714[0], null);
                        }
                        ((Field) objAccessartificialFrame10).set(null, lValueOf7);
                    } catch (Exception unused5) {
                        throw new RuntimeException();
                    }
                }
            } else {
                Object[] objArr715 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1352200332};
                objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame8 == null) {
                    int i1310 = 25 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                    char bitsPerPixel5 = (char) (30067 - ImageFormat.getBitsPerPixel(0));
                    int i1311 = 817 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                    byte[] bArr212 = $$a;
                    byte b17 = (byte) (bArr212[12] - 1);
                    Object[] objArr716 = new Object[1];
                    b(b17, (byte) (b17 | Ascii.FS), bArr212[4], objArr716);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i1310, bitsPerPixel5, i1311, -797394565, false, (String) objArr716[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr5 = (Object[]) ((Method) objAccessartificialFrame8).invoke(null, objArr715);
                objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame9 == null) {
                    int longPressTimeout4 = 25 - (ViewConfiguration.getLongPressTimeout() >> 16);
                    char c7 = (char) (30069 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                    int iLastIndexOf3 = 815 - TextUtils.lastIndexOf("", '0', 0);
                    byte b18 = (byte) ($$b - 2);
                    byte[] bArr34 = $$a;
                    byte b19 = (byte) (bArr34[12] - 1);
                    byte b110 = bArr34[48];
                    Object[] objArr717 = new Object[1];
                    b(b18, b19, b110, objArr717);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(longPressTimeout4, c7, iLastIndexOf3, 891606461, false, (String) objArr717[0], null);
                }
                ((Field) objAccessartificialFrame9).set(null, objArr5);
                Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame10 == null) {
                    int iKeyCodeFromString3 = 25 - KeyEvent.keyCodeFromString("");
                    char gidForName4 = (char) (Process.getGidForName("") + 30069);
                    int mode4 = 816 - View.MeasureSpec.getMode(0);
                    byte[] bArr35 = $$a;
                    Object[] objArr718 = new Object[1];
                    b((byte) 75, (byte) (bArr35[12] - 1), bArr35[48], objArr718);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString3, gidForName4, mode4, 721586079, false, (String) objArr718[0], null);
                }
                ((Field) objAccessartificialFrame10).set(null, lValueOf8);
            }
            i11 = ((int[]) objArr5[1])[0];
            i12 = ((int[]) objArr5[0])[0];
            if (i12 == i11) {
                int i140 = artificialFrame + 93;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i140 % 128;
                int i141 = i140 % 2;
                Object[] objArr80 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i142 = ((int[]) objArr5[3])[0];
                int i143 = ((int[]) objArr5[0])[0];
                int i144 = ((int[]) objArr5[1])[0];
                String[] strArr9 = (String[]) objArr5[2];
                int i145 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 1686449086;
                int i146 = ~i145;
                int i147 = i142 + (-1002650883) + ((~(702220726 | i146)) * (-560)) + ((~(i145 | 1071328254)) * (-560)) + (((~((-504048361) | i146)) | 134940832) * 560);
                int i148 = (i147 << 13) ^ i147;
                int i149 = i148 ^ (i148 >>> 17);
                i13 = 0;
                ((int[]) objArr80[3])[0] = i149 ^ (i149 << 5);
            } else {
                arrayList = new ArrayList();
                strArr = (String[]) objArr5[2];
                if (strArr != null) {
                    for (String str6 : strArr) {
                        int i150 = artificialFrame + 27;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i150 % 128;
                        int i151 = i150 % 2;
                        arrayList.add(str6);
                    }
                }
                Object[] objArr81 = {Long.valueOf((((long) (-2134509928)) << 32) ^ ((long) (i11 ^ i12))), Long.valueOf(-2134509927)};
                byte[] bArr36 = $$d;
                Object[] objArr82 = new Object[1];
                c((short) 359, bArr36[73], bArr36[140], objArr82);
                Class<?> cls9 = Class.forName((String) objArr82[0]);
                Object[] objArr83 = new Object[1];
                c((short) WebSocketProtocol.PAYLOAD_SHORT, (byte) (bArr36[14] - 1), bArr36[23], objArr83);
                cls9.getMethod((String) objArr83[0], Long.TYPE, Long.TYPE).invoke(null, objArr81);
                Object[] objArr84 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i152 = ((int[]) objArr5[3])[0];
                int i153 = ((int[]) objArr5[0])[0];
                int i154 = ((int[]) objArr5[1])[0];
                String[] strArr10 = (String[]) objArr5[2];
                int iIdentityHashCode3 = System.identityHashCode(this);
                int i155 = i152 + 1063082885 + (((~(457535588 | iIdentityHashCode3)) | 605032210) * 104) + ((~((~iIdentityHashCode3) | (-406859845))) * (-104)) + ((iIdentityHashCode3 | 655707954) * 104);
                int i156 = (i155 << 13) ^ i155;
                int i157 = i156 ^ (i156 >>> 17);
                i13 = 0;
                ((int[]) objArr84[3])[0] = i157 ^ (i157 << 5);
            }
            objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(1313006081);
            if (objAccessartificialFrame11 == null) {
                int iAxisFromString3 = MotionEvent.axisFromString("") + 22;
                char offsetAfter = (char) TextUtils.getOffsetAfter("", i13);
                int i158 = 466 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                byte[] bArr37 = $$a;
                Object[] objArr85 = new Object[1];
                b((byte) 75, (byte) (bArr37[12] - 1), bArr37[48], objArr85);
                objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(iAxisFromString3, offsetAfter, i158, -785931255, false, (String) objArr85[0], null);
            }
            j3 = ((Field) objAccessartificialFrame11).getLong(null);
            if (j3 != -1 || j3 + 2022 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                baseContext = getBaseContext();
                if (baseContext == null) {
                    int i159 = getARTIFICIAL_FRAME_PACKAGE_NAME + 123;
                    artificialFrame = i159 % 128;
                    int i160 = i159 % 2;
                    Object[] objArr86 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 1228203707, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 53), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 24, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 1997820330, objArr86);
                    Class<?> cls10 = Class.forName((String) objArr86[0]);
                    Object[] objArr87 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 1228203705, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 35), 3 - (ViewConfiguration.getWindowTouchSlop() >> 8), (short) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (Process.myPid() >> 22) - 1997820301, objArr87);
                    baseContext = (Context) cls10.getMethod((String) objArr87[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    if ((baseContext instanceof ContextWrapper) || ((ContextWrapper) baseContext).getBaseContext() != null) {
                        baseContext = baseContext.getApplicationContext();
                    } else {
                        baseContext = null;
                    }
                }
                int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                Object[] objArr88 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1228203688, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 49), 49 - Color.argb(0, 0, 0, 0), (short) (Process.myPid() >> 22), Drawable.resolveOpacity(0, 0) - 1997820254, objArr88);
                String str7 = (String) objArr88[0];
                Object[] objArr89 = new Object[1];
                a((-1228203702) - ExpandableListView.getPackedPositionGroup(0L), (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 26), 49 - TextUtils.indexOf("", "", 0, 0), (short) TextUtils.getOffsetAfter("", 0), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 1997820306, objArr89);
                Object[] objArr90 = {baseContext, new String[]{str7, (String) objArr89[0]}, Integer.valueOf(iIntValue2), 1, -910940751};
                short s2 = (short) TypedValues.CycleType.TYPE_WAVE_PERIOD;
                byte[] bArr38 = $$d;
                Object[] objArr91 = new Object[1];
                c(s2, bArr38[85], bArr38[140], objArr91);
                Class<?> cls11 = Class.forName((String) objArr91[0]);
                byte b20 = bArr38[7];
                Object[] objArr92 = new Object[1];
                c((short) 305, b20, b20, objArr92);
                objArr6 = (Object[]) cls11.getMethod((String) objArr92[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr90);
                int i161 = ((int[]) objArr6[0])[0];
                int i162 = ((int[]) objArr6[3])[0];
                if (baseContext != null) {
                    objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(1142731807);
                    if (objAccessartificialFrame12 == null) {
                        int iIndexOf7 = 20 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                        char mirror2 = (char) ('0' - AndroidCharacter.getMirror('0'));
                        int longPressTimeout5 = 465 - (ViewConfiguration.getLongPressTimeout() >> 16);
                        byte b21 = (byte) ($$b - 2);
                        byte[] bArr39 = $$a;
                        Object[] objArr93 = new Object[1];
                        b(b21, (byte) (bArr39[12] - 1), bArr39[48], objArr93);
                        objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iIndexOf7, mirror2, longPressTimeout5, -612765161, false, (String) objArr93[0], null);
                    }
                    ((Field) objAccessartificialFrame12).set(null, objArr6);
                    try {
                        Long lValueOf9 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(1313006081);
                        if (objAccessartificialFrame13 == null) {
                            int mirror3 = 'E' - AndroidCharacter.getMirror('0');
                            char cIndexOf3 = (char) TextUtils.indexOf("", "");
                            int bitsPerPixel6 = ImageFormat.getBitsPerPixel(0) + 466;
                            byte[] bArr40 = $$a;
                            Object[] objArr94 = new Object[1];
                            b((byte) 75, (byte) (bArr40[12] - 1), bArr40[48], objArr94);
                            objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(mirror3, cIndexOf3, bitsPerPixel6, -785931255, false, (String) objArr94[0], null);
                        }
                        ((Field) objAccessartificialFrame13).set(null, lValueOf9);
                    } catch (Exception unused6) {
                        throw new RuntimeException();
                    }
                }
            } else {
                Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame37 == null) {
                    int i163 = 22 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                    char scrollBarSize = (char) (ViewConfiguration.getScrollBarSize() >> 8);
                    int maxKeyCode2 = (KeyEvent.getMaxKeyCode() >> 16) + 465;
                    byte b22 = (byte) ($$b - 2);
                    byte[] bArr41 = $$a;
                    Object[] objArr95 = new Object[1];
                    b(b22, (byte) (bArr41[12] - 1), bArr41[48], objArr95);
                    objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(i163, scrollBarSize, maxKeyCode2, -612765161, false, (String) objArr95[0], null);
                }
                Object[] objArr96 = (Object[]) ((Field) objAccessartificialFrame37).get(null);
                objArr6 = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
                int i164 = ((int[]) objArr96[3])[0];
                int i165 = ((int[]) objArr96[0])[0];
                String[] strArr11 = (String[]) objArr96[1];
                int iMyTid = Process.myTid();
                int i166 = (((-431554392) + (((-843847066) | iMyTid) * (-381))) + (((~((~iMyTid) | (-844978078))) | 162611750) * 381)) - 1527756186;
                int i167 = (i166 << 13) ^ i166;
                int i168 = i167 ^ (i167 >>> 17);
                ((int[]) objArr6[2])[0] = i168 ^ (i168 << 5);
            }
            i15 = ((int[]) objArr6[0])[0];
            i16 = ((int[]) objArr6[3])[0];
            if (i16 == i15) {
                Object[] objArr97 = {new int[]{i}, strArr, new int[1], new int[]{i}};
                int i169 = ((int[]) objArr6[2])[0];
                int i170 = ((int[]) objArr6[3])[0];
                int i171 = ((int[]) objArr6[0])[0];
                String[] strArr12 = (String[]) objArr6[1];
                int i172 = ~((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenLayout;
                int i173 = i169 + (-1986778471) + ((~(159299581 | i172)) * 52) + (((~(18224801 | i172)) | (~((-142124925) | i172)) | 141074780) * (-52)) + (((~(i172 | (-18224802))) | 17174657) * 52);
                int i174 = (i173 << 13) ^ i173;
                int i175 = i174 ^ (i174 >>> 17);
                ((int[]) objArr97[2])[0] = i175 ^ (i175 << 5);
            } else {
                arrayList2 = new ArrayList();
                strArr2 = (String[]) objArr6[1];
                if (strArr2 != null) {
                    for (String str8 : strArr2) {
                        arrayList2.add(str8);
                    }
                }
                Object[] objArr98 = {Long.valueOf(((long) (i15 ^ i16)) ^ (((long) (-2109787936)) << 32)), Long.valueOf(-2109788000)};
                short s3 = (short) ($$e | 256);
                byte[] bArr42 = $$d;
                Object[] objArr99 = new Object[1];
                c(s3, bArr42[181], bArr42[140], objArr99);
                Class<?> cls12 = Class.forName((String) objArr99[0]);
                Object[] objArr100 = new Object[1];
                c((short) WebSocketProtocol.PAYLOAD_SHORT, (byte) (bArr42[14] - 1), bArr42[23], objArr100);
                cls12.getMethod((String) objArr100[0], Long.TYPE, Long.TYPE).invoke(null, objArr98);
                Object[] objArr101 = {new int[]{i}, strArr, new int[1], new int[]{i}};
                int i176 = ((int[]) objArr6[2])[0];
                int i177 = ((int[]) objArr6[3])[0];
                int i178 = ((int[]) objArr6[0])[0];
                String[] strArr13 = (String[]) objArr6[1];
                int iMyUid = Process.myUid();
                int i179 = ~iMyUid;
                int i180 = ~(470058180 | i179);
                int i181 = i176 + (-982713211) + (((-511035111) | i180) * (-712)) + (((~(iMyUid | (-40976931))) | (~(i179 | 511035110))) * (-712)) + ((309708454 | i180) * 712);
                int i182 = (i181 << 13) ^ i181;
                int i183 = i182 ^ (i182 >>> 17);
                ((int[]) objArr101[2])[0] = i183 ^ (i183 << 5);
            }
            super.onStart();
            objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(1745676544);
            if (objAccessartificialFrame14 == null) {
                int iMyTid2 = (Process.myTid() >> 22) + 17;
                char cLastIndexOf2 = (char) ((-1) - TextUtils.lastIndexOf("", '0', 0));
                int i184 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 747;
                byte[] bArr43 = $$a;
                Object[] objArr102 = new Object[1];
                b((byte) 75, (byte) (bArr43[12] - 1), bArr43[48], objArr102);
                objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(iMyTid2, cLastIndexOf2, i184, -144068856, false, (String) objArr102[0], null);
            }
            j4 = ((Field) objAccessartificialFrame14).getLong(null);
            if (j4 != -1) {
                int i185 = artificialFrame + 37;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i185 % 128;
                int i186 = i185 % 2;
                if (j4 + 4611686018427387764L >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(1575402270);
                    if (objAccessartificialFrame19 == null) {
                        int longPressTimeout6 = 17 - (ViewConfiguration.getLongPressTimeout() >> 16);
                        char bitsPerPixel7 = (char) (ImageFormat.getBitsPerPixel(0) + 1);
                        int iIndexOf8 = TextUtils.indexOf("", "") + 747;
                        byte b23 = (byte) ($$b - 2);
                        byte[] bArr44 = $$a;
                        Object[] objArr103 = new Object[1];
                        b(b23, (byte) (bArr44[12] - 1), bArr44[48], objArr103);
                        objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(longPressTimeout6, bitsPerPixel7, iIndexOf8, -1031537386, false, (String) objArr103[0], null);
                    }
                    Object[] objArr104 = (Object[]) ((Field) objAccessartificialFrame19).get(null);
                    objArr7 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
                    int i187 = ((int[]) objArr104[3])[0];
                    int i188 = ((int[]) objArr104[4])[0];
                    List list = (List) objArr104[0];
                    List list2 = (List) objArr104[2];
                    int i189 = ~((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().getLayoutDirection();
                    int i190 = (-653971826) + ((~((-537203745) | i189)) * (-783)) + (((~(i189 | 64015071)) | (-541433387)) * 783) + 570691648;
                    int i191 = (i190 << 13) ^ i190;
                    int i192 = i191 ^ (i191 >>> 17);
                    ((int[]) objArr7[1])[0] = i192 ^ (i192 << 5);
                } else {
                    baseContext2 = getBaseContext();
                    if (baseContext2 == null) {
                        Object[] objArr105 = new Object[1];
                        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 1228203679, (byte) (Color.red(0) + 88), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 24, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 1997820375, objArr105);
                        Class<?> cls13 = Class.forName((String) objArr105[0]);
                        Object[] objArr106 = new Object[1];
                        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 1228203660, (byte) (71 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 1, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 49), ExpandableListView.getPackedPositionType(0L) - 1997820301, objArr106);
                        baseContext2 = (Context) cls13.getMethod((String) objArr106[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext2 != null) {
                        if ((baseContext2 instanceof ContextWrapper) || ((ContextWrapper) baseContext2).getBaseContext() != null) {
                            baseContext2 = baseContext2.getApplicationContext();
                        } else {
                            baseContext2 = null;
                        }
                    }
                    Object[] objArr107 = {baseContext2, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 570691648};
                    byte[] bArr45 = $$d;
                    Object[] objArr108 = new Object[1];
                    c((short) 538, bArr45[455], bArr45[140], objArr108);
                    Class<?> cls14 = Class.forName((String) objArr108[0]);
                    Object[] objArr109 = new Object[1];
                    c(bArr45[455], bArr45[504], bArr45[235], objArr109);
                    objArr7 = (Object[]) cls14.getMethod((String) objArr109[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr107);
                    objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1575402270);
                    if (objAccessartificialFrame15 == null) {
                        int edgeSlop3 = (ViewConfiguration.getEdgeSlop() >> 16) + 17;
                        char tapTimeout = (char) (ViewConfiguration.getTapTimeout() >> 16);
                        int iRgb3 = (-16776469) - Color.rgb(0, 0, 0);
                        byte b24 = (byte) ($$b - 2);
                        byte[] bArr46 = $$a;
                        Object[] objArr110 = new Object[1];
                        b(b24, (byte) (bArr46[12] - 1), bArr46[48], objArr110);
                        objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(edgeSlop3, tapTimeout, iRgb3, -1031537386, false, (String) objArr110[0], null);
                    }
                    ((Field) objAccessartificialFrame15).set(null, objArr7);
                    try {
                        Long lValueOf10 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1745676544);
                        if (objAccessartificialFrame16 == null) {
                            int iCombineMeasuredStates3 = View.combineMeasuredStates(0, 0) + 17;
                            char c8 = (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                            int i193 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 747;
                            byte[] bArr47 = $$a;
                            Object[] objArr111 = new Object[1];
                            b((byte) 75, (byte) (bArr47[12] - 1), bArr47[48], objArr111);
                            objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates3, c8, i193, -144068856, false, (String) objArr111[0], null);
                        }
                        ((Field) objAccessartificialFrame16).set(null, lValueOf10);
                    } catch (Exception unused7) {
                        throw new RuntimeException();
                    }
                }
            } else {
                baseContext2 = getBaseContext();
                if (baseContext2 == null) {
                    Object[] objArr1010 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 1228203679, (byte) (Color.red(0) + 88), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 24, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 1997820375, objArr1010);
                    Class<?> cls15 = Class.forName((String) objArr1010[0]);
                    Object[] objArr1011 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 1228203660, (byte) (71 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 1, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 49), ExpandableListView.getPackedPositionType(0L) - 1997820301, objArr1011);
                    baseContext2 = (Context) cls15.getMethod((String) objArr1011[0], new Class[0]).invoke(null, null);
                }
                if (baseContext2 != null) {
                    if (baseContext2 instanceof ContextWrapper) {
                        baseContext2 = baseContext2.getApplicationContext();
                    } else {
                        baseContext2 = baseContext2.getApplicationContext();
                    }
                }
                Object[] objArr1012 = {baseContext2, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 570691648};
                byte[] bArr48 = $$d;
                Object[] objArr1013 = new Object[1];
                c((short) 538, bArr48[455], bArr48[140], objArr1013);
                Class<?> cls16 = Class.forName((String) objArr1013[0]);
                Object[] objArr1014 = new Object[1];
                c(bArr48[455], bArr48[504], bArr48[235], objArr1014);
                objArr7 = (Object[]) cls16.getMethod((String) objArr1014[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr1012);
                objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1575402270);
                if (objAccessartificialFrame15 == null) {
                    int edgeSlop4 = (ViewConfiguration.getEdgeSlop() >> 16) + 17;
                    char tapTimeout2 = (char) (ViewConfiguration.getTapTimeout() >> 16);
                    int iRgb4 = (-16776469) - Color.rgb(0, 0, 0);
                    byte b25 = (byte) ($$b - 2);
                    byte[] bArr49 = $$a;
                    Object[] objArr112 = new Object[1];
                    b(b25, (byte) (bArr49[12] - 1), bArr49[48], objArr112);
                    objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(edgeSlop4, tapTimeout2, iRgb4, -1031537386, false, (String) objArr112[0], null);
                }
                ((Field) objAccessartificialFrame15).set(null, objArr7);
                Long lValueOf11 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame16 == null) {
                    int iCombineMeasuredStates4 = View.combineMeasuredStates(0, 0) + 17;
                    char c9 = (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                    int i194 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 747;
                    byte[] bArr410 = $$a;
                    Object[] objArr113 = new Object[1];
                    b((byte) 75, (byte) (bArr410[12] - 1), bArr410[48], objArr113);
                    objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates4, c9, i194, -144068856, false, (String) objArr113[0], null);
                }
                ((Field) objAccessartificialFrame16).set(null, lValueOf11);
            }
            i18 = ((int[]) objArr7[4])[0];
            i19 = ((int[]) objArr7[3])[0];
            if (i19 == i18) {
                int i195 = artificialFrame + b.f40o;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i195 % 128;
                int i196 = i195 % 2;
                Object[] objArr114 = {list, new int[1], list, new int[]{i}, new int[]{i}};
                int i197 = ((int[]) objArr7[1])[0];
                int i198 = ((int[]) objArr7[3])[0];
                int i199 = ((int[]) objArr7[4])[0];
                List list3 = (List) objArr7[0];
                List list4 = (List) objArr7[2];
                int i200 = ~((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().mnc;
                int i201 = i197 + (((~((-585372732) | i200)) | 2102282) * (-241)) + 1075465711 + (((~(i200 | (-583270450))) | 17973444) * 241);
                int i202 = (i201 << 13) ^ i201;
                int i203 = i202 ^ (i202 >>> 17);
                ((int[]) objArr114[1])[0] = i203 ^ (i203 << 5);
                return;
            }
            ArrayList arrayList4 = new ArrayList();
            Object[] objArr115 = {objArr7};
            objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(1804664566);
            if (objAccessartificialFrame17 == null) {
                objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(41 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 12468), Process.getGidForName("") + 3643, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
            }
            arrayList4.add(((Method) objAccessartificialFrame17).invoke(null, objArr115));
            Object[] objArr116 = {objArr7};
            objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-1243809191);
            if (objAccessartificialFrame18 == null) {
                objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(41 - Color.green(0), (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 12468), (Process.myTid() >> 22) + 3642, 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
            }
            arrayList4.add(((Method) objAccessartificialFrame18).invoke(null, objArr116));
            Object[] objArr117 = {Long.valueOf((((long) (-859472308)) << 32) ^ ((long) (i18 ^ i19))), Long.valueOf(-859472316)};
            byte[] bArr50 = $$d;
            Object[] objArr118 = new Object[1];
            c((short) 578, bArr50[11], bArr50[140], objArr118);
            Class<?> cls17 = Class.forName((String) objArr118[0]);
            Object[] objArr119 = new Object[1];
            c((short) WebSocketProtocol.PAYLOAD_SHORT, (byte) (bArr50[14] - 1), bArr50[23], objArr119);
            cls17.getMethod((String) objArr119[0], Long.TYPE, Long.TYPE).invoke(null, objArr117);
            Object[] objArr120 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i204 = ((int[]) objArr7[1])[0];
            int i205 = ((int[]) objArr7[3])[0];
            int i206 = ((int[]) objArr7[4])[0];
            List list5 = (List) objArr7[0];
            List list6 = (List) objArr7[2];
            int iIdentityHashCode4 = System.identityHashCode(this);
            int i207 = ~iIdentityHashCode4;
            int i208 = (-1531668495) + (((~((-679543059) | i207)) | (~((-124697645) | iIdentityHashCode4))) * 520);
            int i209 = ~(124697644 | i207);
            int i210 = ~(iIdentityHashCode4 | 730146102);
            int i211 = i204 + i208 + ((i209 | i210) * (-1040)) + ((i210 | (~(i207 | (-730146103))) | (-804240703)) * 520);
            int i212 = (i211 << 13) ^ i211;
            int i213 = i212 ^ (i212 >>> 17);
            ((int[]) objArr120[1])[0] = i213 ^ (i213 << 5);
        }
        i3 = 0;
        Context baseContext4 = getBaseContext();
        if (baseContext4 == null) {
            Object[] objArr121 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i3]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(i3, 4).codePointAt(i3) - 1228203695, (byte) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 87), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i3]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 24, (short) TextUtils.indexOf("", "", i3), (-1997820325) - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), objArr121);
            Class<?> cls18 = Class.forName((String) objArr121[0]);
            Object[] objArr122 = new Object[1];
            a((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1228203657, (byte) (TextUtils.indexOf("", "", 0, 0) + 70), TextUtils.lastIndexOf("", '0', 0) + 4, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1997820336, objArr122);
            baseContext4 = (Context) cls18.getMethod((String) objArr122[0], new Class[0]).invoke(null, null);
        }
        if (baseContext4 != null) {
            baseContext4 = ((baseContext4 instanceof ContextWrapper) && ((ContextWrapper) baseContext4).getBaseContext() == null) ? null : baseContext4.getApplicationContext();
        }
        Object[] objArr123 = {baseContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 1693171692};
        short s4 = (short) ($$e | 12);
        byte[] bArr51 = $$d;
        Object[] objArr124 = new Object[1];
        c(s4, bArr51[280], bArr51[476], objArr124);
        Class<?> cls19 = Class.forName((String) objArr124[0]);
        byte b26 = bArr51[7];
        Object[] objArr125 = new Object[1];
        c((short) 305, b26, b26, objArr125);
        objArr3 = (Object[]) cls19.getMethod((String) objArr125[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr123);
        if (baseContext4 != null) {
            int i214 = getARTIFICIAL_FRAME_PACKAGE_NAME + 71;
            artificialFrame = i214 % 128;
            try {
                if (i214 % 2 == 0) {
                    Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(777251007);
                    if (objAccessartificialFrame38 == null) {
                        int scrollBarFadeDuration = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 30;
                        char windowTouchSlop = (char) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 49362);
                        int iKeyCodeFromString4 = 684 - KeyEvent.keyCodeFromString("");
                        byte[] bArr52 = $$a;
                        Object[] objArr126 = new Object[1];
                        b((byte) (-bArr52[69]), bArr52[66], bArr52[68], objArr126);
                        objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration, windowTouchSlop, iKeyCodeFromString4, -1321816393, false, (String) objArr126[0], null);
                    }
                    ((Field) objAccessartificialFrame38).set(null, objArr3);
                    lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[1]).invoke(null, new Object[1])).longValue());
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-2127922582);
                    if (objAccessartificialFrame == null) {
                        defaultSize = 29 - ((byte) KeyEvent.getModifierMetaStateMask());
                        maximumFlingVelocity = (char) (49362 - Color.blue(0));
                        iIndexOf = ImageFormat.getBitsPerPixel(0) + 685;
                        i4 = 508509282;
                        z = false;
                        byte[] bArr53 = $$a;
                        Object[] objArr127 = new Object[1];
                        b((byte) (-bArr53[45]), bArr53[19], bArr53[66], objArr127);
                        obj = objArr127[0];
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(defaultSize, maximumFlingVelocity, iIndexOf, i4, z, (String) obj, null);
                    }
                } else {
                    Object objAccessartificialFrame39 = ArtificialStackFrames.accessartificialFrame(777251007);
                    if (objAccessartificialFrame39 == null) {
                        int scrollBarSize2 = 30 - (ViewConfiguration.getScrollBarSize() >> 8);
                        char capsMode3 = (char) (49362 - TextUtils.getCapsMode("", 0, 0));
                        int iIndexOf9 = 683 - TextUtils.indexOf((CharSequence) "", '0');
                        byte[] bArr54 = $$a;
                        Object[] objArr128 = new Object[1];
                        b((byte) (-bArr54[69]), bArr54[66], bArr54[68], objArr128);
                        objAccessartificialFrame39 = ArtificialStackFrames.coroutineCreation(scrollBarSize2, capsMode3, iIndexOf9, -1321816393, false, (String) objArr128[0], null);
                    }
                    ((Field) objAccessartificialFrame39).set(null, objArr3);
                    lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-2127922582);
                    if (objAccessartificialFrame == null) {
                        defaultSize = 30 - View.getDefaultSize(0, 0);
                        maximumFlingVelocity = (char) (49362 - (ViewConfiguration.getMaximumFlingVelocity() >> 16));
                        iIndexOf = 683 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                        i4 = 508509282;
                        z = false;
                        byte[] bArr55 = $$a;
                        Object[] objArr129 = new Object[1];
                        b((byte) (-bArr55[45]), bArr55[19], bArr55[66], objArr129);
                        obj = objArr129[0];
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(defaultSize, maximumFlingVelocity, iIndexOf, i4, z, (String) obj, null);
                    }
                }
                ((Field) objAccessartificialFrame).set(null, lValueOf);
            } catch (Exception unused8) {
                throw new RuntimeException();
            }
        }
        i5 = ((int[]) objArr3[1])[0];
        i6 = ((int[]) objArr3[0])[0];
        if (i6 == i5) {
            int i910 = ((int[]) objArr3[2])[0];
            Object[] objArr510 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
            int i911 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenHeightDp;
            int i912 = ~i911;
            int i913 = i910 + 492107934 + (((~(972986111 | i912)) | 5637663) * 220) + (((~(i912 | 685643391)) | 292980383) * (-440)) + ((i911 | 972986111) * 220);
            int i914 = (i913 << 13) ^ i913;
            int i915 = i914 ^ (i914 >>> 17);
            i7 = 0;
            ((int[]) objArr510[2])[0] = i915 ^ (i915 << 5);
        } else {
            Object[] objArr511 = {Long.valueOf((((long) 684080057) << 32) ^ ((long) (i5 ^ i6))), Long.valueOf(684079545)};
            byte[] bArr213 = $$d;
            Object[] objArr512 = new Object[1];
            c((short) 325, bArr213[93], bArr213[140], objArr512);
            Class<?> cls20 = Class.forName((String) objArr512[0]);
            Object[] objArr513 = new Object[1];
            c((short) WebSocketProtocol.PAYLOAD_SHORT, (byte) (bArr213[14] - 1), bArr213[23], objArr513);
            cls20.getMethod((String) objArr513[0], Long.TYPE, Long.TYPE).invoke(null, objArr511);
            int i916 = ((int[]) objArr3[2])[0];
            Object[] objArr514 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
            int i917 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 929090659;
            int i918 = ~i917;
            int i1010 = i916 + (-399851326) + (((~((-54466101) | i918)) | (~((-924157675) | i917))) * 210) + (((~(i917 | (-2756629))) | (~(i918 | (-872448203)))) * 210);
            int i1011 = (i1010 << 13) ^ i1010;
            int i1012 = i1011 ^ (i1011 >>> 17);
            i7 = 0;
            ((int[]) objArr514[2])[0] = i1012 ^ (i1012 << 5);
        }
        objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame2 == null) {
            int iResolveSize3 = View.resolveSize(i7, i7) + 36;
            char c10 = (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
            int iIndexOf10 = 540 - TextUtils.indexOf("", "");
            byte[] bArr214 = $$a;
            Object[] objArr610 = new Object[1];
            b((byte) 75, (byte) (bArr214[12] - 1), bArr214[48], objArr610);
            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iResolveSize3, c10, iIndexOf10, 624296913, false, (String) objArr610[0], null);
        }
        j = ((Field) objAccessartificialFrame2).getLong(null);
        if (j != -1) {
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1717965552);
            if (objAccessartificialFrame3 == null) {
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(Gravity.getAbsoluteGravity(0, 0) + 20, (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 39517), 982 - Color.argb(0, 0, 0, 0), 117222168, false, null, new Class[0]);
            }
            Object[] objArr611 = {null, ((Constructor) objAccessartificialFrame3).newInstance(null), 653680888, 0};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-501205803);
            if (objAccessartificialFrame4 == null) {
                int iMakeMeasureSpec2 = 36 - View.MeasureSpec.makeMeasureSpec(0, 0);
                char cRgb3 = (char) (ViewCompat.MEASURED_STATE_MASK - Color.rgb(0, 0, 0));
                int iIndexOf11 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 541;
                byte[] bArr215 = $$a;
                Object[] objArr612 = new Object[1];
                b((byte) (-bArr215[64]), bArr215[2], (byte) (bArr215[12] - 1), objArr612);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec2, cRgb3, iIndexOf11, 2101703389, false, (String) objArr612[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(54 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (833 - (ViewConfiguration.getLongPressTimeout() >> 16)), ExpandableListView.getPackedPositionChild(0L) + 577), (Class) ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollBarSize() >> 8) + 54, (char) Color.red(0), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 630), Integer.TYPE, Integer.TYPE});
            }
            objArr4 = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr611);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame5 == null) {
                int iIndexOf12 = 36 - TextUtils.indexOf("", "", 0);
                char keyRepeatDelay2 = (char) (ViewConfiguration.getKeyRepeatDelay() >> 16);
                int iRgb5 = (-16776676) - Color.rgb(0, 0, 0);
                byte b27 = (byte) ($$b - 2);
                byte[] bArr216 = $$a;
                Object[] objArr613 = new Object[1];
                b(b27, (byte) (bArr216[12] - 1), bArr216[48], objArr613);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iIndexOf12, keyRepeatDelay2, iRgb5, 793268735, false, (String) objArr613[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr4);
            Long lValueOf12 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1168947751);
            if (objAccessartificialFrame6 == null) {
                int iAxisFromString4 = MotionEvent.axisFromString("") + 37;
                char cAlpha2 = (char) Color.alpha(0);
                int iResolveSize4 = 540 - View.resolveSize(0, 0);
                byte[] bArr217 = $$a;
                Object[] objArr614 = new Object[1];
                b((byte) 75, (byte) (bArr217[12] - 1), bArr217[48], objArr614);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iAxisFromString4, cAlpha2, iResolveSize4, 624296913, false, (String) objArr614[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf12);
        } else {
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1717965552);
            if (objAccessartificialFrame3 == null) {
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(Gravity.getAbsoluteGravity(0, 0) + 20, (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 39517), 982 - Color.argb(0, 0, 0, 0), 117222168, false, null, new Class[0]);
            }
            Object[] objArr615 = {null, ((Constructor) objAccessartificialFrame3).newInstance(null), 653680888, 0};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-501205803);
            if (objAccessartificialFrame4 == null) {
                int iMakeMeasureSpec3 = 36 - View.MeasureSpec.makeMeasureSpec(0, 0);
                char cRgb4 = (char) (ViewCompat.MEASURED_STATE_MASK - Color.rgb(0, 0, 0));
                int iIndexOf13 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 541;
                byte[] bArr218 = $$a;
                Object[] objArr616 = new Object[1];
                b((byte) (-bArr218[64]), bArr218[2], (byte) (bArr218[12] - 1), objArr616);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec3, cRgb4, iIndexOf13, 2101703389, false, (String) objArr616[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(54 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (833 - (ViewConfiguration.getLongPressTimeout() >> 16)), ExpandableListView.getPackedPositionChild(0L) + 577), (Class) ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollBarSize() >> 8) + 54, (char) Color.red(0), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 630), Integer.TYPE, Integer.TYPE});
            }
            objArr4 = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr615);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame5 == null) {
                int iIndexOf14 = 36 - TextUtils.indexOf("", "", 0);
                char keyRepeatDelay3 = (char) (ViewConfiguration.getKeyRepeatDelay() >> 16);
                int iRgb6 = (-16776676) - Color.rgb(0, 0, 0);
                byte b28 = (byte) ($$b - 2);
                byte[] bArr219 = $$a;
                Object[] objArr617 = new Object[1];
                b(b28, (byte) (bArr219[12] - 1), bArr219[48], objArr617);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iIndexOf14, keyRepeatDelay3, iRgb6, 793268735, false, (String) objArr617[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr4);
            Long lValueOf13 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1168947751);
            if (objAccessartificialFrame6 == null) {
                int iAxisFromString5 = MotionEvent.axisFromString("") + 37;
                char cAlpha3 = (char) Color.alpha(0);
                int iResolveSize5 = 540 - View.resolveSize(0, 0);
                byte[] bArr2110 = $$a;
                Object[] objArr618 = new Object[1];
                b((byte) 75, (byte) (bArr2110[12] - 1), bArr2110[48], objArr618);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iAxisFromString5, cAlpha3, iResolveSize5, 624296913, false, (String) objArr618[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf13);
        }
        obj2 = objArr4[1];
        i8 = ((int[]) obj2)[0];
        obj3 = objArr4[2];
        i9 = ((int[]) obj3)[0];
        if (i9 == i8) {
            int i1013 = getARTIFICIAL_FRAME_PACKAGE_NAME + 117;
            artificialFrame = i1013 % 128;
            int i1110 = i1013 % 2;
            Object[] objArr619 = {new int[1], new int[1], new int[1]};
            int i1111 = ((int[]) objArr4[0])[0];
            int i1112 = ((int[]) obj3)[0];
            int i1113 = ((int[]) obj2)[0];
            ((int[]) objArr619[2])[0] = i1112;
            ((int[]) objArr619[1])[0] = i1113;
            int iIdentityHashCode5 = System.identityHashCode(this);
            int i1114 = i1111 + (-68778521) + (((~iIdentityHashCode5) | 555753730) * 1324) + (((~(iIdentityHashCode5 | 622946643)) | (~(728675106 | iIdentityHashCode5))) * (-1324)) + 41869366;
            int i1115 = (i1114 << 13) ^ i1114;
            int i1116 = i1115 ^ (i1115 >>> 17);
            i10 = 0;
            ((int[]) objArr619[0])[0] = i1116 ^ (i1116 << 5);
        } else {
            Object[] objArr620 = {Long.valueOf((((long) (-1004996904)) << 32) ^ ((long) (i8 ^ i9))), Long.valueOf(-1005001000)};
            byte[] bArr220 = $$d;
            Object[] objArr621 = new Object[1];
            c((short) 325, bArr220[93], bArr220[140], objArr621);
            Class<?> cls21 = Class.forName((String) objArr621[0]);
            Object[] objArr719 = new Object[1];
            c((short) WebSocketProtocol.PAYLOAD_SHORT, (byte) (bArr220[14] - 1), bArr220[23], objArr719);
            cls21.getMethod((String) objArr719[0], Long.TYPE, Long.TYPE).invoke(null, objArr620);
            Object[] objArr720 = {new int[1], new int[1], new int[1]};
            int i1117 = ((int[]) objArr4[0])[0];
            int i1118 = ((int[]) objArr4[2])[0];
            int i1119 = ((int[]) objArr4[1])[0];
            ((int[]) objArr720[2])[0] = i1118;
            ((int[]) objArr720[1])[0] = i1119;
            int i1215 = ~((int) Runtime.getRuntime().maxMemory());
            int i1216 = i1117 + (-53549055) + ((~(1073739763 | i1215)) * 52) + (((~(400237795 | i1215)) | (~((-951383955) | i1215)) | 673501968) * (-52)) + (((~(i1215 | (-400237796))) | 122355809) * 52);
            int i1217 = (i1216 << 13) ^ i1216;
            int i1218 = i1217 ^ (i1217 >>> 17);
            i10 = 0;
            ((int[]) objArr720[0])[0] = i1218 ^ (i1218 << 5);
        }
        objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame7 == null) {
            int i1219 = 25 - (ExpandableListView.getPackedPositionForGroup(i10) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(i10) == 0L ? 0 : -1));
            char pressedStateDuration3 = (char) (30068 - (ViewConfiguration.getPressedStateDuration() >> 16));
            int iMyPid2 = 816 - (Process.myPid() >> 22);
            byte[] bArr221 = $$a;
            Object[] objArr721 = new Object[1];
            b((byte) 75, (byte) (bArr221[12] - 1), bArr221[48], objArr721);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(i1219, pressedStateDuration3, iMyPid2, 721586079, false, (String) objArr721[0], null);
        }
        j2 = ((Field) objAccessartificialFrame7).getLong(null);
        if (j2 != -1) {
            i20 = artificialFrame + 69;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i20 % 128;
            if (i20 % 2 != 0) {
                i21 = 0;
                if (j2 + 1998 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame20 == null) {
                        int bitsPerPixel8 = ImageFormat.getBitsPerPixel(i21) + 26;
                        char edgeSlop5 = (char) (30068 - (ViewConfiguration.getEdgeSlop() >> 16));
                        int capsMode4 = TextUtils.getCapsMode("", i21, i21) + 816;
                        byte b111 = (byte) ($$b - 2);
                        byte[] bArr2111 = $$a;
                        Object[] objArr722 = new Object[1];
                        b(b111, (byte) (bArr2111[12] - 1), bArr2111[48], objArr722);
                        objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(bitsPerPixel8, edgeSlop5, capsMode4, 891606461, false, (String) objArr722[0], null);
                    }
                    Object[] objArr7110 = (Object[]) ((Field) objAccessartificialFrame20).get(null);
                    objArr5 = new Object[]{new int[]{i1210}, new int[]{i1211}, strArr8, new int[1]};
                    int i12110 = ((int[]) objArr7110[0])[0];
                    int i12111 = ((int[]) objArr7110[1])[0];
                    String[] strArr14 = (String[]) objArr7110[2];
                    int i12112 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().densityDpi;
                    int i12113 = 729408813 + (((~(650075371 | i12112)) | (-451903006)) * 672);
                    int i12114 = ~i12112;
                    int i1312 = i12113 + (((~(i12112 | (-451903006))) | (~((-650075372) | i12114))) * (-672)) + (((~(451903005 | i12114)) | (-1056931584)) * 672) + 1352200332;
                    int i1313 = (i1312 << 13) ^ i1312;
                    int i1314 = i1313 ^ (i1313 >>> 17);
                    ((int[]) objArr5[3])[0] = i1314 ^ (i1314 << 5);
                } else {
                    Object[] objArr7111 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1352200332};
                    objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame8 == null) {
                        int i1315 = 25 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                        char bitsPerPixel9 = (char) (30067 - ImageFormat.getBitsPerPixel(0));
                        int i1316 = 817 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                        byte[] bArr2112 = $$a;
                        byte b112 = (byte) (bArr2112[12] - 1);
                        Object[] objArr7112 = new Object[1];
                        b(b112, (byte) (b112 | Ascii.FS), bArr2112[4], objArr7112);
                        objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i1315, bitsPerPixel9, i1316, -797394565, false, (String) objArr7112[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr5 = (Object[]) ((Method) objAccessartificialFrame8).invoke(null, objArr7111);
                    objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame9 == null) {
                        int longPressTimeout7 = 25 - (ViewConfiguration.getLongPressTimeout() >> 16);
                        char c11 = (char) (30069 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                        int iLastIndexOf4 = 815 - TextUtils.lastIndexOf("", '0', 0);
                        byte b113 = (byte) ($$b - 2);
                        byte[] bArr310 = $$a;
                        byte b114 = (byte) (bArr310[12] - 1);
                        byte b115 = bArr310[48];
                        Object[] objArr7113 = new Object[1];
                        b(b113, b114, b115, objArr7113);
                        objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(longPressTimeout7, c11, iLastIndexOf4, 891606461, false, (String) objArr7113[0], null);
                    }
                    ((Field) objAccessartificialFrame9).set(null, objArr5);
                    Long lValueOf14 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame10 == null) {
                        int iKeyCodeFromString5 = 25 - KeyEvent.keyCodeFromString("");
                        char gidForName5 = (char) (Process.getGidForName("") + 30069);
                        int mode5 = 816 - View.MeasureSpec.getMode(0);
                        byte[] bArr311 = $$a;
                        Object[] objArr7114 = new Object[1];
                        b((byte) 75, (byte) (bArr311[12] - 1), bArr311[48], objArr7114);
                        objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString5, gidForName5, mode5, 721586079, false, (String) objArr7114[0], null);
                    }
                    ((Field) objAccessartificialFrame10).set(null, lValueOf14);
                }
            } else if (j2 % 1998 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[1]).invoke(null, new Object[1])).longValue()) {
                i21 = 0;
                objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame20 == null) {
                    int bitsPerPixel10 = ImageFormat.getBitsPerPixel(i21) + 26;
                    char edgeSlop6 = (char) (30068 - (ViewConfiguration.getEdgeSlop() >> 16));
                    int capsMode5 = TextUtils.getCapsMode("", i21, i21) + 816;
                    byte b116 = (byte) ($$b - 2);
                    byte[] bArr2113 = $$a;
                    Object[] objArr723 = new Object[1];
                    b(b116, (byte) (bArr2113[12] - 1), bArr2113[48], objArr723);
                    objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(bitsPerPixel10, edgeSlop6, capsMode5, 891606461, false, (String) objArr723[0], null);
                }
                Object[] objArr7115 = (Object[]) ((Field) objAccessartificialFrame20).get(null);
                objArr5 = new Object[]{new int[]{i12110}, new int[]{i12111}, strArr14, new int[1]};
                int i12115 = ((int[]) objArr7115[0])[0];
                int i12116 = ((int[]) objArr7115[1])[0];
                String[] strArr15 = (String[]) objArr7115[2];
                int i12117 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().densityDpi;
                int i12118 = 729408813 + (((~(650075371 | i12117)) | (-451903006)) * 672);
                int i12119 = ~i12117;
                int i1317 = i12118 + (((~(i12117 | (-451903006))) | (~((-650075372) | i12119))) * (-672)) + (((~(451903005 | i12119)) | (-1056931584)) * 672) + 1352200332;
                int i1318 = (i1317 << 13) ^ i1317;
                int i1319 = i1318 ^ (i1318 >>> 17);
                ((int[]) objArr5[3])[0] = i1319 ^ (i1319 << 5);
            } else {
                Object[] objArr7116 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1352200332};
                objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame8 == null) {
                    int i13110 = 25 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                    char bitsPerPixel11 = (char) (30067 - ImageFormat.getBitsPerPixel(0));
                    int i13111 = 817 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                    byte[] bArr2114 = $$a;
                    byte b117 = (byte) (bArr2114[12] - 1);
                    Object[] objArr7117 = new Object[1];
                    b(b117, (byte) (b117 | Ascii.FS), bArr2114[4], objArr7117);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i13110, bitsPerPixel11, i13111, -797394565, false, (String) objArr7117[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr5 = (Object[]) ((Method) objAccessartificialFrame8).invoke(null, objArr7116);
                objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame9 == null) {
                    int longPressTimeout8 = 25 - (ViewConfiguration.getLongPressTimeout() >> 16);
                    char c12 = (char) (30069 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                    int iLastIndexOf5 = 815 - TextUtils.lastIndexOf("", '0', 0);
                    byte b118 = (byte) ($$b - 2);
                    byte[] bArr312 = $$a;
                    byte b119 = (byte) (bArr312[12] - 1);
                    byte b1110 = bArr312[48];
                    Object[] objArr7118 = new Object[1];
                    b(b118, b119, b1110, objArr7118);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(longPressTimeout8, c12, iLastIndexOf5, 891606461, false, (String) objArr7118[0], null);
                }
                ((Field) objAccessartificialFrame9).set(null, objArr5);
                Long lValueOf15 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame10 == null) {
                    int iKeyCodeFromString6 = 25 - KeyEvent.keyCodeFromString("");
                    char gidForName6 = (char) (Process.getGidForName("") + 30069);
                    int mode6 = 816 - View.MeasureSpec.getMode(0);
                    byte[] bArr313 = $$a;
                    Object[] objArr7119 = new Object[1];
                    b((byte) 75, (byte) (bArr313[12] - 1), bArr313[48], objArr7119);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString6, gidForName6, mode6, 721586079, false, (String) objArr7119[0], null);
                }
                ((Field) objAccessartificialFrame10).set(null, lValueOf15);
            }
        } else {
            Object[] objArr71110 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1352200332};
            objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame8 == null) {
                int i13112 = 25 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                char bitsPerPixel12 = (char) (30067 - ImageFormat.getBitsPerPixel(0));
                int i13113 = 817 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                byte[] bArr2115 = $$a;
                byte b1111 = (byte) (bArr2115[12] - 1);
                Object[] objArr71111 = new Object[1];
                b(b1111, (byte) (b1111 | Ascii.FS), bArr2115[4], objArr71111);
                objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i13112, bitsPerPixel12, i13113, -797394565, false, (String) objArr71111[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr5 = (Object[]) ((Method) objAccessartificialFrame8).invoke(null, objArr71110);
            objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame9 == null) {
                int longPressTimeout9 = 25 - (ViewConfiguration.getLongPressTimeout() >> 16);
                char c13 = (char) (30069 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                int iLastIndexOf6 = 815 - TextUtils.lastIndexOf("", '0', 0);
                byte b1112 = (byte) ($$b - 2);
                byte[] bArr314 = $$a;
                byte b1113 = (byte) (bArr314[12] - 1);
                byte b1114 = bArr314[48];
                Object[] objArr71112 = new Object[1];
                b(b1112, b1113, b1114, objArr71112);
                objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(longPressTimeout9, c13, iLastIndexOf6, 891606461, false, (String) objArr71112[0], null);
            }
            ((Field) objAccessartificialFrame9).set(null, objArr5);
            Long lValueOf16 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame10 == null) {
                int iKeyCodeFromString7 = 25 - KeyEvent.keyCodeFromString("");
                char gidForName7 = (char) (Process.getGidForName("") + 30069);
                int mode7 = 816 - View.MeasureSpec.getMode(0);
                byte[] bArr315 = $$a;
                Object[] objArr71113 = new Object[1];
                b((byte) 75, (byte) (bArr315[12] - 1), bArr315[48], objArr71113);
                objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString7, gidForName7, mode7, 721586079, false, (String) objArr71113[0], null);
            }
            ((Field) objAccessartificialFrame10).set(null, lValueOf16);
        }
        i11 = ((int[]) objArr5[1])[0];
        i12 = ((int[]) objArr5[0])[0];
        if (i12 == i11) {
            int i1410 = artificialFrame + 93;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i1410 % 128;
            int i1411 = i1410 % 2;
            Object[] objArr810 = {new int[]{i143}, new int[]{i144}, strArr9, new int[1]};
            int i1412 = ((int[]) objArr5[3])[0];
            int i1413 = ((int[]) objArr5[0])[0];
            int i1414 = ((int[]) objArr5[1])[0];
            String[] strArr16 = (String[]) objArr5[2];
            int i1415 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 1686449086;
            int i1416 = ~i1415;
            int i1417 = i1412 + (-1002650883) + ((~(702220726 | i1416)) * (-560)) + ((~(i1415 | 1071328254)) * (-560)) + (((~((-504048361) | i1416)) | 134940832) * 560);
            int i1418 = (i1417 << 13) ^ i1417;
            int i1419 = i1418 ^ (i1418 >>> 17);
            i13 = 0;
            ((int[]) objArr810[3])[0] = i1419 ^ (i1419 << 5);
        } else {
            arrayList = new ArrayList();
            strArr = (String[]) objArr5[2];
            if (strArr != null) {
                while (i14 < strArr.length) {
                    int i1510 = artificialFrame + 27;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i1510 % 128;
                    int i1511 = i1510 % 2;
                    arrayList.add(str6);
                }
            }
            Object[] objArr811 = {Long.valueOf((((long) (-2134509928)) << 32) ^ ((long) (i11 ^ i12))), Long.valueOf(-2134509927)};
            byte[] bArr316 = $$d;
            Object[] objArr812 = new Object[1];
            c((short) 359, bArr316[73], bArr316[140], objArr812);
            Class<?> cls22 = Class.forName((String) objArr812[0]);
            Object[] objArr813 = new Object[1];
            c((short) WebSocketProtocol.PAYLOAD_SHORT, (byte) (bArr316[14] - 1), bArr316[23], objArr813);
            cls22.getMethod((String) objArr813[0], Long.TYPE, Long.TYPE).invoke(null, objArr811);
            Object[] objArr814 = {new int[]{i153}, new int[]{i154}, strArr10, new int[1]};
            int i1512 = ((int[]) objArr5[3])[0];
            int i1513 = ((int[]) objArr5[0])[0];
            int i1514 = ((int[]) objArr5[1])[0];
            String[] strArr17 = (String[]) objArr5[2];
            int iIdentityHashCode6 = System.identityHashCode(this);
            int i1515 = i1512 + 1063082885 + (((~(457535588 | iIdentityHashCode6)) | 605032210) * 104) + ((~((~iIdentityHashCode6) | (-406859845))) * (-104)) + ((iIdentityHashCode6 | 655707954) * 104);
            int i1516 = (i1515 << 13) ^ i1515;
            int i1517 = i1516 ^ (i1516 >>> 17);
            i13 = 0;
            ((int[]) objArr814[3])[0] = i1517 ^ (i1517 << 5);
        }
        objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame11 == null) {
            int iAxisFromString6 = MotionEvent.axisFromString("") + 22;
            char offsetAfter2 = (char) TextUtils.getOffsetAfter("", i13);
            int i1518 = 466 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
            byte[] bArr317 = $$a;
            Object[] objArr815 = new Object[1];
            b((byte) 75, (byte) (bArr317[12] - 1), bArr317[48], objArr815);
            objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(iAxisFromString6, offsetAfter2, i1518, -785931255, false, (String) objArr815[0], null);
        }
        j3 = ((Field) objAccessartificialFrame11).getLong(null);
        if (j3 != -1) {
            baseContext = getBaseContext();
            if (baseContext == null) {
                int i1519 = getARTIFICIAL_FRAME_PACKAGE_NAME + 123;
                artificialFrame = i1519 % 128;
                int i1610 = i1519 % 2;
                Object[] objArr816 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 1228203707, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 53), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 24, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 1997820330, objArr816);
                Class<?> cls110 = Class.forName((String) objArr816[0]);
                Object[] objArr817 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 1228203705, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 35), 3 - (ViewConfiguration.getWindowTouchSlop() >> 8), (short) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (Process.myPid() >> 22) - 1997820301, objArr817);
                baseContext = (Context) cls110.getMethod((String) objArr817[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                if (baseContext instanceof ContextWrapper) {
                    baseContext = baseContext.getApplicationContext();
                } else {
                    baseContext = baseContext.getApplicationContext();
                }
            }
            int iIntValue3 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr818 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1228203688, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 49), 49 - Color.argb(0, 0, 0, 0), (short) (Process.myPid() >> 22), Drawable.resolveOpacity(0, 0) - 1997820254, objArr818);
            String str9 = (String) objArr818[0];
            Object[] objArr819 = new Object[1];
            a((-1228203702) - ExpandableListView.getPackedPositionGroup(0L), (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 26), 49 - TextUtils.indexOf("", "", 0, 0), (short) TextUtils.getOffsetAfter("", 0), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 1997820306, objArr819);
            Object[] objArr910 = {baseContext, new String[]{str9, (String) objArr819[0]}, Integer.valueOf(iIntValue3), 1, -910940751};
            short s5 = (short) TypedValues.CycleType.TYPE_WAVE_PERIOD;
            byte[] bArr318 = $$d;
            Object[] objArr911 = new Object[1];
            c(s5, bArr318[85], bArr318[140], objArr911);
            Class<?> cls111 = Class.forName((String) objArr911[0]);
            byte b29 = bArr318[7];
            Object[] objArr912 = new Object[1];
            c((short) 305, b29, b29, objArr912);
            objArr6 = (Object[]) cls111.getMethod((String) objArr912[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr910);
            int i1611 = ((int[]) objArr6[0])[0];
            int i1612 = ((int[]) objArr6[3])[0];
            if (baseContext != null) {
                objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame12 == null) {
                    int iIndexOf15 = 20 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                    char mirror4 = (char) ('0' - AndroidCharacter.getMirror('0'));
                    int longPressTimeout10 = 465 - (ViewConfiguration.getLongPressTimeout() >> 16);
                    byte b210 = (byte) ($$b - 2);
                    byte[] bArr319 = $$a;
                    Object[] objArr913 = new Object[1];
                    b(b210, (byte) (bArr319[12] - 1), bArr319[48], objArr913);
                    objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iIndexOf15, mirror4, longPressTimeout10, -612765161, false, (String) objArr913[0], null);
                }
                ((Field) objAccessartificialFrame12).set(null, objArr6);
                Long lValueOf17 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(1313006081);
                if (objAccessartificialFrame13 == null) {
                    int mirror5 = 'E' - AndroidCharacter.getMirror('0');
                    char cIndexOf4 = (char) TextUtils.indexOf("", "");
                    int bitsPerPixel13 = ImageFormat.getBitsPerPixel(0) + 466;
                    byte[] bArr411 = $$a;
                    Object[] objArr914 = new Object[1];
                    b((byte) 75, (byte) (bArr411[12] - 1), bArr411[48], objArr914);
                    objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(mirror5, cIndexOf4, bitsPerPixel13, -785931255, false, (String) objArr914[0], null);
                }
                ((Field) objAccessartificialFrame13).set(null, lValueOf17);
            }
        } else {
            baseContext = getBaseContext();
            if (baseContext == null) {
                int i15110 = getARTIFICIAL_FRAME_PACKAGE_NAME + 123;
                artificialFrame = i15110 % 128;
                int i1613 = i15110 % 2;
                Object[] objArr8110 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 1228203707, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 53), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 24, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 1997820330, objArr8110);
                Class<?> cls112 = Class.forName((String) objArr8110[0]);
                Object[] objArr8111 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 1228203705, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 35), 3 - (ViewConfiguration.getWindowTouchSlop() >> 8), (short) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (Process.myPid() >> 22) - 1997820301, objArr8111);
                baseContext = (Context) cls112.getMethod((String) objArr8111[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                if (baseContext instanceof ContextWrapper) {
                    baseContext = baseContext.getApplicationContext();
                } else {
                    baseContext = baseContext.getApplicationContext();
                }
            }
            int iIntValue4 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr8112 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1228203688, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 49), 49 - Color.argb(0, 0, 0, 0), (short) (Process.myPid() >> 22), Drawable.resolveOpacity(0, 0) - 1997820254, objArr8112);
            String str10 = (String) objArr8112[0];
            Object[] objArr8113 = new Object[1];
            a((-1228203702) - ExpandableListView.getPackedPositionGroup(0L), (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 26), 49 - TextUtils.indexOf("", "", 0, 0), (short) TextUtils.getOffsetAfter("", 0), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 1997820306, objArr8113);
            Object[] objArr915 = {baseContext, new String[]{str10, (String) objArr8113[0]}, Integer.valueOf(iIntValue4), 1, -910940751};
            short s6 = (short) TypedValues.CycleType.TYPE_WAVE_PERIOD;
            byte[] bArr3110 = $$d;
            Object[] objArr916 = new Object[1];
            c(s6, bArr3110[85], bArr3110[140], objArr916);
            Class<?> cls113 = Class.forName((String) objArr916[0]);
            byte b211 = bArr3110[7];
            Object[] objArr917 = new Object[1];
            c((short) 305, b211, b211, objArr917);
            objArr6 = (Object[]) cls113.getMethod((String) objArr917[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr915);
            int i1614 = ((int[]) objArr6[0])[0];
            int i1615 = ((int[]) objArr6[3])[0];
            if (baseContext != null) {
                objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame12 == null) {
                    int iIndexOf16 = 20 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                    char mirror6 = (char) ('0' - AndroidCharacter.getMirror('0'));
                    int longPressTimeout11 = 465 - (ViewConfiguration.getLongPressTimeout() >> 16);
                    byte b212 = (byte) ($$b - 2);
                    byte[] bArr3111 = $$a;
                    Object[] objArr918 = new Object[1];
                    b(b212, (byte) (bArr3111[12] - 1), bArr3111[48], objArr918);
                    objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iIndexOf16, mirror6, longPressTimeout11, -612765161, false, (String) objArr918[0], null);
                }
                ((Field) objAccessartificialFrame12).set(null, objArr6);
                Long lValueOf18 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(1313006081);
                if (objAccessartificialFrame13 == null) {
                    int mirror7 = 'E' - AndroidCharacter.getMirror('0');
                    char cIndexOf5 = (char) TextUtils.indexOf("", "");
                    int bitsPerPixel14 = ImageFormat.getBitsPerPixel(0) + 466;
                    byte[] bArr412 = $$a;
                    Object[] objArr919 = new Object[1];
                    b((byte) 75, (byte) (bArr412[12] - 1), bArr412[48], objArr919);
                    objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(mirror7, cIndexOf5, bitsPerPixel14, -785931255, false, (String) objArr919[0], null);
                }
                ((Field) objAccessartificialFrame13).set(null, lValueOf18);
            }
        }
        i15 = ((int[]) objArr6[0])[0];
        i16 = ((int[]) objArr6[3])[0];
        if (i16 == i15) {
            Object[] objArr920 = {new int[]{i171}, strArr12, new int[1], new int[]{i170}};
            int i1616 = ((int[]) objArr6[2])[0];
            int i1710 = ((int[]) objArr6[3])[0];
            int i1711 = ((int[]) objArr6[0])[0];
            String[] strArr18 = (String[]) objArr6[1];
            int i1712 = ~((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenLayout;
            int i1713 = i1616 + (-1986778471) + ((~(159299581 | i1712)) * 52) + (((~(18224801 | i1712)) | (~((-142124925) | i1712)) | 141074780) * (-52)) + (((~(i1712 | (-18224802))) | 17174657) * 52);
            int i1714 = (i1713 << 13) ^ i1713;
            int i1715 = i1714 ^ (i1714 >>> 17);
            ((int[]) objArr920[2])[0] = i1715 ^ (i1715 << 5);
        } else {
            arrayList2 = new ArrayList();
            strArr2 = (String[]) objArr6[1];
            if (strArr2 != null) {
                while (i17 < strArr2.length) {
                    arrayList2.add(str8);
                }
            }
            Object[] objArr921 = {Long.valueOf(((long) (i15 ^ i16)) ^ (((long) (-2109787936)) << 32)), Long.valueOf(-2109788000)};
            short s7 = (short) ($$e | 256);
            byte[] bArr413 = $$d;
            Object[] objArr922 = new Object[1];
            c(s7, bArr413[181], bArr413[140], objArr922);
            Class<?> cls114 = Class.forName((String) objArr922[0]);
            Object[] objArr1015 = new Object[1];
            c((short) WebSocketProtocol.PAYLOAD_SHORT, (byte) (bArr413[14] - 1), bArr413[23], objArr1015);
            cls114.getMethod((String) objArr1015[0], Long.TYPE, Long.TYPE).invoke(null, objArr921);
            Object[] objArr1016 = {new int[]{i178}, strArr13, new int[1], new int[]{i177}};
            int i1716 = ((int[]) objArr6[2])[0];
            int i1717 = ((int[]) objArr6[3])[0];
            int i1718 = ((int[]) objArr6[0])[0];
            String[] strArr19 = (String[]) objArr6[1];
            int iMyUid2 = Process.myUid();
            int i1719 = ~iMyUid2;
            int i1810 = ~(470058180 | i1719);
            int i1811 = i1716 + (-982713211) + (((-511035111) | i1810) * (-712)) + (((~(iMyUid2 | (-40976931))) | (~(i1719 | 511035110))) * (-712)) + ((309708454 | i1810) * 712);
            int i1812 = (i1811 << 13) ^ i1811;
            int i1813 = i1812 ^ (i1812 >>> 17);
            ((int[]) objArr1016[2])[0] = i1813 ^ (i1813 << 5);
        }
        super.onStart();
        objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame14 == null) {
            int iMyTid3 = (Process.myTid() >> 22) + 17;
            char cLastIndexOf3 = (char) ((-1) - TextUtils.lastIndexOf("", '0', 0));
            int i1814 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 747;
            byte[] bArr414 = $$a;
            Object[] objArr1017 = new Object[1];
            b((byte) 75, (byte) (bArr414[12] - 1), bArr414[48], objArr1017);
            objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(iMyTid3, cLastIndexOf3, i1814, -144068856, false, (String) objArr1017[0], null);
        }
        j4 = ((Field) objAccessartificialFrame14).getLong(null);
        if (j4 != -1) {
            int i1815 = artificialFrame + 37;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i1815 % 128;
            int i1816 = i1815 % 2;
            if (j4 + 4611686018427387764L >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(1575402270);
                if (objAccessartificialFrame19 == null) {
                    int longPressTimeout12 = 17 - (ViewConfiguration.getLongPressTimeout() >> 16);
                    char bitsPerPixel15 = (char) (ImageFormat.getBitsPerPixel(0) + 1);
                    int iIndexOf17 = TextUtils.indexOf("", "") + 747;
                    byte b213 = (byte) ($$b - 2);
                    byte[] bArr415 = $$a;
                    Object[] objArr1018 = new Object[1];
                    b(b213, (byte) (bArr415[12] - 1), bArr415[48], objArr1018);
                    objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(longPressTimeout12, bitsPerPixel15, iIndexOf17, -1031537386, false, (String) objArr1018[0], null);
                }
                Object[] objArr1019 = (Object[]) ((Field) objAccessartificialFrame19).get(null);
                objArr7 = new Object[]{list, new int[1], list2, new int[]{i187}, new int[]{i188}};
                int i1817 = ((int[]) objArr1019[3])[0];
                int i1818 = ((int[]) objArr1019[4])[0];
                List list7 = (List) objArr1019[0];
                List list8 = (List) objArr1019[2];
                int i1819 = ~((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().getLayoutDirection();
                int i1910 = (-653971826) + ((~((-537203745) | i1819)) * (-783)) + (((~(i1819 | 64015071)) | (-541433387)) * 783) + 570691648;
                int i1911 = (i1910 << 13) ^ i1910;
                int i1912 = i1911 ^ (i1911 >>> 17);
                ((int[]) objArr7[1])[0] = i1912 ^ (i1912 << 5);
            } else {
                baseContext2 = getBaseContext();
                if (baseContext2 == null) {
                    Object[] objArr10110 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 1228203679, (byte) (Color.red(0) + 88), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 24, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 1997820375, objArr10110);
                    Class<?> cls115 = Class.forName((String) objArr10110[0]);
                    Object[] objArr10111 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 1228203660, (byte) (71 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 1, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 49), ExpandableListView.getPackedPositionType(0L) - 1997820301, objArr10111);
                    baseContext2 = (Context) cls115.getMethod((String) objArr10111[0], new Class[0]).invoke(null, null);
                }
                if (baseContext2 != null) {
                    if (baseContext2 instanceof ContextWrapper) {
                        baseContext2 = baseContext2.getApplicationContext();
                    } else {
                        baseContext2 = baseContext2.getApplicationContext();
                    }
                }
                Object[] objArr10112 = {baseContext2, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 570691648};
                byte[] bArr416 = $$d;
                Object[] objArr10113 = new Object[1];
                c((short) 538, bArr416[455], bArr416[140], objArr10113);
                Class<?> cls116 = Class.forName((String) objArr10113[0]);
                Object[] objArr10114 = new Object[1];
                c(bArr416[455], bArr416[504], bArr416[235], objArr10114);
                objArr7 = (Object[]) cls116.getMethod((String) objArr10114[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr10112);
                objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1575402270);
                if (objAccessartificialFrame15 == null) {
                    int edgeSlop7 = (ViewConfiguration.getEdgeSlop() >> 16) + 17;
                    char tapTimeout3 = (char) (ViewConfiguration.getTapTimeout() >> 16);
                    int iRgb7 = (-16776469) - Color.rgb(0, 0, 0);
                    byte b214 = (byte) ($$b - 2);
                    byte[] bArr417 = $$a;
                    Object[] objArr1110 = new Object[1];
                    b(b214, (byte) (bArr417[12] - 1), bArr417[48], objArr1110);
                    objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(edgeSlop7, tapTimeout3, iRgb7, -1031537386, false, (String) objArr1110[0], null);
                }
                ((Field) objAccessartificialFrame15).set(null, objArr7);
                Long lValueOf19 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame16 == null) {
                    int iCombineMeasuredStates5 = View.combineMeasuredStates(0, 0) + 17;
                    char c14 = (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                    int i1913 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 747;
                    byte[] bArr418 = $$a;
                    Object[] objArr1111 = new Object[1];
                    b((byte) 75, (byte) (bArr418[12] - 1), bArr418[48], objArr1111);
                    objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates5, c14, i1913, -144068856, false, (String) objArr1111[0], null);
                }
                ((Field) objAccessartificialFrame16).set(null, lValueOf19);
            }
        } else {
            baseContext2 = getBaseContext();
            if (baseContext2 == null) {
                Object[] objArr10115 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 1228203679, (byte) (Color.red(0) + 88), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 24, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 1997820375, objArr10115);
                Class<?> cls117 = Class.forName((String) objArr10115[0]);
                Object[] objArr10116 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 1228203660, (byte) (71 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 1, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 49), ExpandableListView.getPackedPositionType(0L) - 1997820301, objArr10116);
                baseContext2 = (Context) cls117.getMethod((String) objArr10116[0], new Class[0]).invoke(null, null);
            }
            if (baseContext2 != null) {
                if (baseContext2 instanceof ContextWrapper) {
                    baseContext2 = baseContext2.getApplicationContext();
                } else {
                    baseContext2 = baseContext2.getApplicationContext();
                }
            }
            Object[] objArr10117 = {baseContext2, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 570691648};
            byte[] bArr419 = $$d;
            Object[] objArr10118 = new Object[1];
            c((short) 538, bArr419[455], bArr419[140], objArr10118);
            Class<?> cls118 = Class.forName((String) objArr10118[0]);
            Object[] objArr10119 = new Object[1];
            c(bArr419[455], bArr419[504], bArr419[235], objArr10119);
            objArr7 = (Object[]) cls118.getMethod((String) objArr10119[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr10117);
            objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame15 == null) {
                int edgeSlop8 = (ViewConfiguration.getEdgeSlop() >> 16) + 17;
                char tapTimeout4 = (char) (ViewConfiguration.getTapTimeout() >> 16);
                int iRgb8 = (-16776469) - Color.rgb(0, 0, 0);
                byte b215 = (byte) ($$b - 2);
                byte[] bArr4110 = $$a;
                Object[] objArr1112 = new Object[1];
                b(b215, (byte) (bArr4110[12] - 1), bArr4110[48], objArr1112);
                objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(edgeSlop8, tapTimeout4, iRgb8, -1031537386, false, (String) objArr1112[0], null);
            }
            ((Field) objAccessartificialFrame15).set(null, objArr7);
            Long lValueOf110 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1745676544);
            if (objAccessartificialFrame16 == null) {
                int iCombineMeasuredStates6 = View.combineMeasuredStates(0, 0) + 17;
                char c15 = (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                int i1914 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 747;
                byte[] bArr4111 = $$a;
                Object[] objArr1113 = new Object[1];
                b((byte) 75, (byte) (bArr4111[12] - 1), bArr4111[48], objArr1113);
                objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates6, c15, i1914, -144068856, false, (String) objArr1113[0], null);
            }
            ((Field) objAccessartificialFrame16).set(null, lValueOf110);
        }
        i18 = ((int[]) objArr7[4])[0];
        i19 = ((int[]) objArr7[3])[0];
        if (i19 == i18) {
            int i1915 = artificialFrame + b.f40o;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i1915 % 128;
            int i1916 = i1915 % 2;
            Object[] objArr1114 = {list3, new int[1], list4, new int[]{i198}, new int[]{i199}};
            int i1917 = ((int[]) objArr7[1])[0];
            int i1918 = ((int[]) objArr7[3])[0];
            int i1919 = ((int[]) objArr7[4])[0];
            List list9 = (List) objArr7[0];
            List list10 = (List) objArr7[2];
            int i2010 = ~((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().mnc;
            int i2011 = i1917 + (((~((-585372732) | i2010)) | 2102282) * (-241)) + 1075465711 + (((~(i2010 | (-583270450))) | 17973444) * 241);
            int i2012 = (i2011 << 13) ^ i2011;
            int i2013 = i2012 ^ (i2012 >>> 17);
            ((int[]) objArr1114[1])[0] = i2013 ^ (i2013 << 5);
            return;
        }
        ArrayList arrayList5 = new ArrayList();
        Object[] objArr1115 = {objArr7};
        objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(1804664566);
        if (objAccessartificialFrame17 == null) {
            objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(41 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 12468), Process.getGidForName("") + 3643, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
        }
        arrayList5.add(((Method) objAccessartificialFrame17).invoke(null, objArr1115));
        Object[] objArr1116 = {objArr7};
        objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-1243809191);
        if (objAccessartificialFrame18 == null) {
            objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(41 - Color.green(0), (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 12468), (Process.myTid() >> 22) + 3642, 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
        }
        arrayList5.add(((Method) objAccessartificialFrame18).invoke(null, objArr1116));
        Object[] objArr1117 = {Long.valueOf((((long) (-859472308)) << 32) ^ ((long) (i18 ^ i19))), Long.valueOf(-859472316)};
        byte[] bArr56 = $$d;
        Object[] objArr1118 = new Object[1];
        c((short) 578, bArr56[11], bArr56[140], objArr1118);
        Class<?> cls119 = Class.forName((String) objArr1118[0]);
        Object[] objArr1119 = new Object[1];
        c((short) WebSocketProtocol.PAYLOAD_SHORT, (byte) (bArr56[14] - 1), bArr56[23], objArr1119);
        cls119.getMethod((String) objArr1119[0], Long.TYPE, Long.TYPE).invoke(null, objArr1117);
        Object[] objArr1210 = {list5, new int[1], list6, new int[]{i205}, new int[]{i206}};
        int i2014 = ((int[]) objArr7[1])[0];
        int i2015 = ((int[]) objArr7[3])[0];
        int i2016 = ((int[]) objArr7[4])[0];
        List list11 = (List) objArr7[0];
        List list12 = (List) objArr7[2];
        int iIdentityHashCode7 = System.identityHashCode(this);
        int i2017 = ~iIdentityHashCode7;
        int i2018 = (-1531668495) + (((~((-679543059) | i2017)) | (~((-124697645) | iIdentityHashCode7))) * 520);
        int i2019 = ~(124697644 | i2017);
        int i215 = ~(iIdentityHashCode7 | 730146102);
        int i216 = i2014 + i2018 + ((i2019 | i215) * (-1040)) + ((i215 | (~(i2017 | (-730146103))) | (-804240703)) * 520);
        int i217 = (i216 << 13) ^ i216;
        int i218 = i217 ^ (i217 >>> 17);
        ((int[]) objArr1210[1])[0] = i218 ^ (i218 << 5);
    }

    @Override // android.app.Activity
    protected void onPause() throws Throwable {
        int i = 2 % 2;
        int i2 = artificialFrame + 105;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        Object obj = null;
        if (i2 % 2 != 0) {
            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(949068051);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(Color.red(0) + 30, (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 49992), KeyEvent.keyCodeFromString("") + 74, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
            }
            Object obj2 = ((Field) objAccessartificialFrame).get(null);
            try {
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1579114835);
                if (objAccessartificialFrame2 == null) {
                    int jumpTapTimeout = (ViewConfiguration.getJumpTapTimeout() >> 16) + 30;
                    char cRgb = (char) (Color.rgb(0, 0, 0) + 16827209);
                    int i3 = 75 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                    byte[] bArr = $$d;
                    Object[] objArr = new Object[1];
                    c((short) 650, (byte) (-bArr[418]), bArr[140], objArr);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout, cRgb, i3, -1048959141, false, (String) objArr[0], new Class[0]);
                }
                ((Method) objAccessartificialFrame2).invoke(obj2, null);
                super.onPause();
                obj.hashCode();
                throw null;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(949068051);
        if (objAccessartificialFrame3 == null) {
            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(30 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (49993 - TextUtils.indexOf("", "", 0)), Color.red(0) + 74, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
        }
        Object obj3 = ((Field) objAccessartificialFrame3).get(null);
        try {
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1579114835);
            if (objAccessartificialFrame4 == null) {
                int deadChar = 30 - KeyEvent.getDeadChar(0, 0);
                char c = (char) (49993 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                int windowTouchSlop = 74 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                byte[] bArr2 = $$d;
                Object[] objArr2 = new Object[1];
                c((short) 650, (byte) (-bArr2[418]), bArr2[140], objArr2);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(deadChar, c, windowTouchSlop, -1048959141, false, (String) objArr2[0], new Class[0]);
            }
            ((Method) objAccessartificialFrame4).invoke(obj3, null);
            super.onPause();
            int i4 = getARTIFICIAL_FRAME_PACKAGE_NAME + 123;
            artificialFrame = i4 % 128;
            int i5 = i4 % 2;
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 == null) {
                throw th2;
            }
            throw cause2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x026d  */
    /* JADX WARN: Code duplicated, block: B:16:0x03d8 A[Catch: all -> 0x0f6d, TryCatch #2 {all -> 0x0f6d, blocks: (B:52:0x0b5c, B:54:0x0b70, B:55:0x0ba0, B:14:0x03b7, B:16:0x03d8, B:17:0x0427), top: B:99:0x03b7 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0439  */
    /* JADX WARN: Code duplicated, block: B:25:0x062e  */
    /* JADX WARN: Code duplicated, block: B:51:0x0a1c  */
    /* JADX WARN: Code duplicated, block: B:54:0x0b70 A[Catch: all -> 0x0f6d, TryCatch #2 {all -> 0x0f6d, blocks: (B:52:0x0b5c, B:54:0x0b70, B:55:0x0ba0, B:14:0x03b7, B:16:0x03d8, B:17:0x0427), top: B:99:0x03b7 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0bb6  */
    /* JADX WARN: Code duplicated, block: B:63:0x0d5e  */
    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
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
        int i2 = artificialFrame + 83;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        int i3 = i2 % 2;
        super.attachBaseContext(context);
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame7 == null) {
            int iArgb = Color.argb(0, 0, 0, 0) + 25;
            char cIndexOf = (char) (30068 - TextUtils.indexOf("", "", 0, 0));
            int i4 = 817 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
            byte[] bArr = $$a;
            Object[] objArr2 = new Object[1];
            b((byte) 75, (byte) (bArr[12] - 1), bArr[48], objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iArgb, cIndexOf, i4, 721586079, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 1916;
            Object[] objArr3 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1228203693, (byte) ((ViewConfiguration.getEdgeSlop() >> 16) - 64), 7 - (ViewConfiguration.getLongPressTimeout() >> 16), (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(19) - 111), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 1997820410, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 1228203658, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 70), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 115, (short) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)), (-1997820340) - View.getDefaultSize(0, 0), objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i5 = artificialFrame + 61;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i5 % 128;
                int i6 = i5 % 2;
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame8 == null) {
                    int iIndexOf = 25 - TextUtils.indexOf("", "", 0, 0);
                    char cRgb = (char) (Color.rgb(0, 0, 0) + 16807284);
                    int maximumDrawingCacheSize = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 816;
                    byte b = (byte) ($$b - 2);
                    byte[] bArr2 = $$a;
                    Object[] objArr5 = new Object[1];
                    b(b, (byte) (bArr2[12] - 1), bArr2[48], objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iIndexOf, cRgb, maximumDrawingCacheSize, 891606461, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i7 = ((int[]) objArr6[0])[0];
                int i8 = ((int[]) objArr6[1])[0];
                String[] strArr = (String[]) objArr6[2];
                int iIdentityHashCode = System.identityHashCode(this);
                int i9 = ~iIdentityHashCode;
                int i10 = (((((~(i9 | (-454844932))) | ((~((-653017298) | i9)) | 34357249)) * (-397)) + 1177887121) + ((iIdentityHashCode | (-1039147731)) * 397)) - 817166223;
                int i11 = (i10 << 13) ^ i10;
                int i12 = i11 ^ (i11 >>> 17);
                ((int[]) objArr[3])[0] = i12 ^ (i12 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                a((-1228203649) - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 51), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 34, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 4), ExpandableListView.getPackedPositionGroup(0L) - 1997820284, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1228203685, (byte) ((-14) - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 20, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1997820304, objArr8);
                try {
                    Object[] objArr9 = {Integer.valueOf(((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue()), 0, -817166223};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame == null) {
                        int i13 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 25;
                        char cIndexOf2 = (char) (30068 - TextUtils.indexOf("", "", 0, 0));
                        int jumpTapTimeout = (ViewConfiguration.getJumpTapTimeout() >> 16) + 816;
                        byte[] bArr3 = $$a;
                        byte b2 = (byte) (bArr3[12] - 1);
                        Object[] objArr10 = new Object[1];
                        b(b2, (byte) (b2 | Ascii.FS), bArr3[4], objArr10);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i13, cIndexOf2, jumpTapTimeout, -797394565, false, (String) objArr10[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr9);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame2 == null) {
                        int i14 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 24;
                        char packedPositionGroup = (char) (30068 - ExpandableListView.getPackedPositionGroup(0L));
                        int i15 = 817 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                        byte b3 = (byte) ($$b - 2);
                        byte[] bArr4 = $$a;
                        Object[] objArr11 = new Object[1];
                        b(b3, (byte) (bArr4[12] - 1), bArr4[48], objArr11);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i14, packedPositionGroup, i15, 891606461, false, (String) objArr11[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArr);
                    try {
                        Object[] objArr12 = new Object[1];
                        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 1228203662, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 99), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 3, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(11) - 105), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 1997820397, objArr12);
                        Class<?> cls3 = Class.forName((String) objArr12[0]);
                        Object[] objArr13 = new Object[1];
                        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1228203689, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(7) - 41), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 49, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4), (-1997820340) - Drawable.resolveOpacity(0, 0), objArr13);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr13[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame3 == null) {
                            int maximumFlingVelocity = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 25;
                            char cIndexOf3 = (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 30069);
                            int i16 = 817 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                            byte[] bArr5 = $$a;
                            Object[] objArr14 = new Object[1];
                            b((byte) 75, (byte) (bArr5[12] - 1), bArr5[48], objArr14);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity, cIndexOf3, i16, 721586079, false, (String) objArr14[0], null);
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
            a((-1228203649) - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 51), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 34, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 4), ExpandableListView.getPackedPositionGroup(0L) - 1997820284, objArr15);
            Class<?> cls4 = Class.forName((String) objArr15[0]);
            Object[] objArr16 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1228203685, (byte) ((-14) - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 20, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1997820304, objArr16);
            Object[] objArr17 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue()), 0, -817166223};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame == null) {
                int i17 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 25;
                char cIndexOf4 = (char) (30068 - TextUtils.indexOf("", "", 0, 0));
                int jumpTapTimeout2 = (ViewConfiguration.getJumpTapTimeout() >> 16) + 816;
                byte[] bArr6 = $$a;
                byte b4 = (byte) (bArr6[12] - 1);
                Object[] objArr18 = new Object[1];
                b(b4, (byte) (b4 | Ascii.FS), bArr6[4], objArr18);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i17, cIndexOf4, jumpTapTimeout2, -797394565, false, (String) objArr18[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr17);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame2 == null) {
                int i18 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 24;
                char packedPositionGroup2 = (char) (30068 - ExpandableListView.getPackedPositionGroup(0L));
                int i19 = 817 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                byte b5 = (byte) ($$b - 2);
                byte[] bArr7 = $$a;
                Object[] objArr19 = new Object[1];
                b(b5, (byte) (bArr7[12] - 1), bArr7[48], objArr19);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i18, packedPositionGroup2, i19, 891606461, false, (String) objArr19[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArr);
            Object[] objArr110 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 1228203662, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 99), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 3, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(11) - 105), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 1997820397, objArr110);
            Class<?> cls5 = Class.forName((String) objArr110[0]);
            Object[] objArr111 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1228203689, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(7) - 41), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 49, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4), (-1997820340) - Drawable.resolveOpacity(0, 0), objArr111);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr111[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame3 == null) {
                int maximumFlingVelocity2 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 25;
                char cIndexOf5 = (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 30069);
                int i110 = 817 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                byte[] bArr8 = $$a;
                Object[] objArr112 = new Object[1];
                b((byte) 75, (byte) (bArr8[12] - 1), bArr8[48], objArr112);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity2, cIndexOf5, i110, 721586079, false, (String) objArr112[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i20 = ((int[]) objArr[1])[0];
        int i21 = ((int[]) objArr[0])[0];
        if (i21 == i20) {
            Object[] objArr20 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i22 = ((int[]) objArr[3])[0];
            int i23 = ((int[]) objArr[0])[0];
            int i24 = ((int[]) objArr[1])[0];
            String[] strArr2 = (String[]) objArr[2];
            int startUptimeMillis = (int) Process.getStartUptimeMillis();
            int i25 = i22 + (((88155471 + (((-538968081) | (~startUptimeMillis)) * (-490))) + (((~(startUptimeMillis | 400420199)) | (-939388280)) * 490)) - 1252581212);
            int i26 = (i25 << 13) ^ i25;
            int i27 = i26 ^ (i26 >>> 17);
            ((int[]) objArr20[3])[0] = i27 ^ (i27 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr[2];
            if (strArr3 != null) {
                for (String str : strArr3) {
                    arrayList.add(str);
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf(((long) (i20 ^ i21)) ^ (((long) 686899091) << 32)), Long.valueOf(686899090)};
                byte[] bArr9 = $$d;
                Object[] objArr22 = new Object[1];
                c((short) 650, bArr9[23], bArr9[140], objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                c((short) WebSocketProtocol.PAYLOAD_SHORT, (byte) (bArr9[14] - 1), bArr9[23], objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i28 = ((int[]) objArr[3])[0];
                int i29 = ((int[]) objArr[0])[0];
                int i30 = ((int[]) objArr[1])[0];
                String[] strArr4 = (String[]) objArr[2];
                int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
                int i31 = i28 + (-28356385) + (((~(iFreeMemory | (-844239423))) | (-1042411789)) * (-465)) + (((-844239423) | (~((-1042411789) | iFreeMemory))) * 930) + ((iFreeMemory | (-838864909)) * 465);
                int i32 = (i31 << 13) ^ i31;
                int i33 = i32 ^ (i32 >>> 17);
                ((int[]) objArr24[3])[0] = i33 ^ (i33 << 5);
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
            int i34 = 27 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
            char jumpTapTimeout3 = (char) (ViewConfiguration.getJumpTapTimeout() >> 16);
            int iNormalizeMetaState = 1041 - KeyEvent.normalizeMetaState(0);
            byte[] bArr10 = $$a;
            Object[] objArr25 = new Object[1];
            b((byte) 75, (byte) (bArr10[12] - 1), bArr10[48], objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(i34, jumpTapTimeout3, iNormalizeMetaState, 2061780482, false, (String) objArr25[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j3 != -1) {
            long j4 = j3 + 4611686018427387873L;
            Object[] objArr26 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(10) - 1228203776, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 85), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 3, (short) (ViewConfiguration.getScrollBarFadeDuration() >> 16), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 1997820397, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1228203689, (byte) (74 - Color.blue(0)), ExpandableListView.getPackedPositionType(0L), (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 36), View.MeasureSpec.getSize(0) - 1997820340, objArr27);
            if (j4 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame10 == null) {
                    int i35 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 25;
                    char cMyTid = (char) (Process.myTid() >> 22);
                    int longPressTimeout = (ViewConfiguration.getLongPressTimeout() >> 16) + 1041;
                    byte b6 = (byte) ($$b - 2);
                    byte[] bArr11 = $$a;
                    Object[] objArr28 = new Object[1];
                    b(b6, (byte) (bArr11[12] - 1), bArr11[48], objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(i35, cMyTid, longPressTimeout, 1145017376, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i36 = ((int[]) objArr29[3])[0];
                int i37 = ((int[]) objArr29[2])[0];
                String[] strArr5 = (String[]) objArr29[0];
                int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
                int i38 = ~iMaxMemory;
                int i39 = ((1292381976 + (((~(444169068 | i38)) | (~((-522272876) | iMaxMemory))) * 210)) + (((~(iMaxMemory | 528055151)) | (~(i38 | (-438386793)))) * 210)) - 2062060958;
                int i40 = (i39 << 13) ^ i39;
                int i41 = i40 ^ (i40 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i41 ^ (i41 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 1228203653, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 51), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 114, (short) Drawable.resolveOpacity(0, 0), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1997820319, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                a(((byte) KeyEvent.getModifierMetaStateMask()) - 1228203649, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 18), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 20, (short) View.resolveSizeAndState(0, 0, 0), Color.alpha(0) - 1997820269, objArr31);
                int iIntValue = ((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue();
                Object[] objArr32 = {1447544841};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(9 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 22251), TextUtils.getCapsMode("", 0, 0) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = RandomKt.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr32), -2062060958, false);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame5 == null) {
                    int tapTimeout = 26 - (ViewConfiguration.getTapTimeout() >> 16);
                    char c = (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                    int iGreen = 1041 - Color.green(0);
                    byte b7 = (byte) ($$b - 2);
                    byte[] bArr12 = $$a;
                    Object[] objArr33 = new Object[1];
                    b(b7, (byte) (bArr12[12] - 1), bArr12[48], objArr33);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(tapTimeout, c, iGreen, 1145017376, false, (String) objArr33[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Object[] objArr34 = new Object[1];
                    a((-1228203658) - TextUtils.getOffsetAfter("", 0), (byte) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 65), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 28, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 115), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 1997820476, objArr34);
                    Class<?> cls9 = Class.forName((String) objArr34[0]);
                    Object[] objArr35 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(12) - 1228203753, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 70), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4, (short) (ViewConfiguration.getKeyRepeatDelay() >> 16), (ViewConfiguration.getMinimumFlingVelocity() >> 16) - 1997820340, objArr35);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr35[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame6 == null) {
                        int iLastIndexOf = TextUtils.lastIndexOf("", '0') + 27;
                        char cMyTid2 = (char) (Process.myTid() >> 22);
                        int iLastIndexOf2 = 1040 - TextUtils.lastIndexOf("", '0');
                        byte[] bArr13 = $$a;
                        byte b8 = (byte) (bArr13[12] - 1);
                        byte b9 = bArr13[48];
                        Object[] objArr36 = new Object[1];
                        b((byte) 75, b8, b9, objArr36);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, cMyTid2, iLastIndexOf2, 2061780482, false, (String) objArr36[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr37 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 1228203653, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 51), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 114, (short) Drawable.resolveOpacity(0, 0), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1997820319, objArr37);
            Class<?> cls10 = Class.forName((String) objArr37[0]);
            Object[] objArr38 = new Object[1];
            a(((byte) KeyEvent.getModifierMetaStateMask()) - 1228203649, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 18), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 20, (short) View.resolveSizeAndState(0, 0, 0), Color.alpha(0) - 1997820269, objArr38);
            int iIntValue2 = ((Integer) cls10.getMethod((String) objArr38[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr39 = {1447544841};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(9 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 22251), TextUtils.getCapsMode("", 0, 0) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = RandomKt.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr39), -2062060958, false);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame5 == null) {
                int tapTimeout2 = 26 - (ViewConfiguration.getTapTimeout() >> 16);
                char c2 = (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                int iGreen2 = 1041 - Color.green(0);
                byte b10 = (byte) ($$b - 2);
                byte[] bArr14 = $$a;
                Object[] objArr310 = new Object[1];
                b(b10, (byte) (bArr14[12] - 1), bArr14[48], objArr310);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(tapTimeout2, c2, iGreen2, 1145017376, false, (String) objArr310[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr311 = new Object[1];
            a((-1228203658) - TextUtils.getOffsetAfter("", 0), (byte) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 65), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 28, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 115), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 1997820476, objArr311);
            Class<?> cls11 = Class.forName((String) objArr311[0]);
            Object[] objArr312 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(12) - 1228203753, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 70), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4, (short) (ViewConfiguration.getKeyRepeatDelay() >> 16), (ViewConfiguration.getMinimumFlingVelocity() >> 16) - 1997820340, objArr312);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr312[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame6 == null) {
                int iLastIndexOf3 = TextUtils.lastIndexOf("", '0') + 27;
                char cMyTid3 = (char) (Process.myTid() >> 22);
                int iLastIndexOf4 = 1040 - TextUtils.lastIndexOf("", '0');
                byte[] bArr15 = $$a;
                byte b11 = (byte) (bArr15[12] - 1);
                byte b12 = bArr15[48];
                Object[] objArr313 = new Object[1];
                b((byte) 75, b11, b12, objArr313);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iLastIndexOf3, cMyTid3, iLastIndexOf4, 2061780482, false, (String) objArr313[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i42 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i43 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i43 == i42) {
            Object[] objArr40 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i44 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i45 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i46 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr6 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int i47 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 55083540;
            int i48 = ~i47;
            int i49 = ~((-324859590) | i48);
            int i50 = ~(246755782 | i47);
            int i51 = i44 + (-1881911684) + ((i49 | i50) * 1150) + (((~((-246755783) | i48)) | i50) * (-575)) + (((~(i47 | (-324859590))) | (~(i48 | 324859589))) * 575);
            int i52 = (i51 << 13) ^ i51;
            int i53 = i52 ^ (i52 >>> 17);
            ((int[]) objArr40[1])[0] = i53 ^ (i53 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        if (strArr7 != null) {
            int i54 = 0;
            while (i54 < strArr7.length) {
                int i55 = getARTIFICIAL_FRAME_PACKAGE_NAME + 23;
                artificialFrame = i55 % 128;
                if (i55 % 2 == 0) {
                    arrayList2.add(strArr7[i54]);
                    i54 += 77;
                } else {
                    arrayList2.add(strArr7[i54]);
                    i54++;
                }
            }
        }
        Object[] objArr41 = {Long.valueOf(((long) (i42 ^ i43)) ^ (((long) 54117470) << 32)), Long.valueOf(54117468)};
        short s = (short) ($$e & 896);
        byte[] bArr16 = $$d;
        Object[] objArr42 = new Object[1];
        c(s, (byte) (-bArr16[403]), bArr16[83], objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        Object[] objArr43 = new Object[1];
        c((short) WebSocketProtocol.PAYLOAD_SHORT, (byte) (bArr16[14] - 1), bArr16[23], objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {strArr, new int[1], new int[]{i}, new int[]{i}};
        int i56 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
        int i57 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        int i58 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        String[] strArr8 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        int streamVolume = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getStreamVolume(3);
        int i59 = ~streamVolume;
        int i60 = i56 + (((((~(5352840 | i59)) | (~((-83456648) | streamVolume))) | (~(i59 | 83456647))) * 959) - 1843625852) + (((~(streamVolume | 83456647)) | (~(i59 | (-83456648))) | (~(5352840 | streamVolume))) * 959);
        int i61 = (i60 << 13) ^ i60;
        int i62 = i61 ^ (i61 >>> 17);
        ((int[]) objArr44[1])[0] = i62 ^ (i62 << 5);
        int i63 = artificialFrame + 51;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i63 % 128;
        int i64 = i63 % 2;
    }

    static void accessartificialFrame() {
        onTransact = -1945456318;
        mayLaunchUrl = -81862524;
        getInterfaceDescriptor = -1305868704;
        ICustomTabsCallbackStubProxy = new byte[]{67, -65, 72, 98, -99, 67, -70, 74, -79, 109, 110, -16, 79, 10, -127, -80, -79, -74, 69, -67, 70, 57, -59, 52, -55, -54, Base64.padSymbol, -46, 47, 62, 51, -62, -50, 52, -58, -48, 47, 32, -39, -57, 8, -42, -40, 32, -34, 38, -62, -15, -64, 109, -45, -36, -32, Ascii.EM, 40, 41, 46, -35, 37, -34, 50, -53, 56, -34, 51, 55, 48, 49, -51, -30, 0, -53, -60, 62, -51, 48, -33, -76, 77, -67, 70, -102, -103, 123, 69, -79, 73, -126, 113, 87, -87, 75, 120, -116, 85, -94, -116, 107, 96, -74, 124, 114, -116, 127, 112, 120, -126, -73, 121, 84, -86, 124, -122, 75, -73, 83, 122, -125, 122, -82, 120, -125, 78, -75, 87, -124, 123, -73, 123, 75, -78, 85, -85, 86, -84, 87, 120, -73, 120, 121, 85, -84, 76, -123, -86, 82, -87, 86, -121, 124, 120, -121, -86, -121, -121, 86, 122, 126, -73, 84, -124, -82, 84, -87, 121, 74, 121, -125, 126, -77, 106, -112, -92, 104, 110, 66, 106, -71, -107, 68, -106, 105, -112, -69, 105, -112, 110, -110, 104, -108, 104, -106, 108, -111, 69, -111, -71, -106, -107, 106, 107, -106, 69, -72, 68, -89, 105, -105, 110, 77, -71, 90, -112, 105, -95, 110, -106, 111, SignedBytes.MAX_POWER_OF_TWO, -92, 104, 65, -72, 105, -99, 104, -111, 95, -108, -107, -107, -69, -105, -117, -117, -117, -117, -117, -117, -117, -117};
    }
}
