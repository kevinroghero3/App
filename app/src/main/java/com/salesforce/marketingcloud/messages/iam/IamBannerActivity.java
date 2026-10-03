package com.salesforce.marketingcloud.messages.iam;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioTrack;
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
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.common.base.Ascii;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import kotlin.io.encoding.Base64;
import kotlinx.serialization.internal.HashMapClassDesc;
import o.ArtificialStackFrames;
import o.ICustomTabsCallbackDefault;

/* JADX INFO: loaded from: classes3.dex */
public class IamBannerActivity extends f {
    private static char CoroutineDebuggingKt;
    private static int accessartificialFrame;
    private static long coroutineBoundary;
    private static final String j;
    private com.salesforce.marketingcloud.messages.iam.a g;
    private boolean h;
    private long i;
    private static final byte[] $$c = {43, Base64.padSymbol, 10, -87};
    private static final int $$f = 172;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$d = {19, -17, 93, 33, -20, -6, 55, -64, -3, -10, -10, -5, -21, -8, -4, 53, -67, -12, 4, -14, -6, -19, -1, -15, 3, -15, -5, -13, 1, 47, -61, -20, -11, 5, 47, -42, -42, -5, 3, -25, 10, -10, -21, Ascii.ETB, -26, -20, -12, 8, -17, 3, -10, Ascii.ETB, -35, -10, -25, -3, -11, -15, 77, -39, -52, -6, -11, 7, -21, -3, -14, -7, -8, -69, -13, 50, -75, -6, -12, Base64.padSymbol, -70, -11, 0, -3, -7, -10, -16, 53, -61, -20, -11, 5, 47, -77, -5, -1, 51, -29, -62, Ascii.SO, -17, -5, -2, Ascii.EM, -59, 7, -8, -7, -21, Ascii.SYN, -38, 9, -10, -16, -2, -21};
    private static final int $$e = 116;
    private static final byte[] $$a = {104, 119, -28, 53, 5, -1, -33, 33, -2, -9, 5, -7, 5, -1, -50, 39, Ascii.VT, -7, -12, Ascii.SI, Ascii.ESC, 1, -7, -6, -33, 51, -12, 3, -8, 1, Ascii.CR};
    private static final int $$b = 44;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;

    class a extends com.salesforce.marketingcloud.messages.iam.a {
        a(long j, long j2) {
            super(j, j2);
        }

        @Override // com.salesforce.marketingcloud.messages.iam.a, android.os.CountDownTimer
        public void onFinish() {
            IamBannerActivity.this.h();
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0027). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$i(int r5, short r6, int r7) {
        /*
            int r7 = r7 * 3
            int r7 = 4 - r7
            int r6 = 101 - r6
            byte[] r0 = com.salesforce.marketingcloud.messages.iam.IamBannerActivity.$$c
            int r5 = r5 * 2
            int r1 = 1 - r5
            byte[] r1 = new byte[r1]
            r2 = 0
            int r5 = 0 - r5
            if (r0 != 0) goto L17
            r3 = r6
            r4 = r2
            r6 = r5
            goto L27
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r5) goto L25
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            return r5
        L25:
            r3 = r0[r7]
        L27:
            int r6 = r6 + r3
            int r7 = r7 + 1
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.messages.iam.IamBannerActivity.$$i(int, short, int):java.lang.String");
    }

    static {
        accessartificialFrame();
        j = com.salesforce.marketingcloud.g.a("IamBaseActivity");
    }

    private void a(long j2, long j3) {
        if (j2 > 0) {
            com.salesforce.marketingcloud.g.d(j, "Banner dismiss timer set.  Will auto dismiss in %dms", Long.valueOf(j2 - j3));
            a aVar = new a(j2, j3);
            this.g = aVar;
            aVar.start();
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void k(int r5, byte r6, byte r7, java.lang.Object[] r8) {
        /*
            int r5 = r5 * 28
            int r5 = r5 + 84
            byte[] r0 = com.salesforce.marketingcloud.messages.iam.IamBannerActivity.$$a
            int r7 = r7 * 8
            int r7 = 20 - r7
            int r6 = r6 * 3
            int r1 = r6 + 9
            byte[] r1 = new byte[r1]
            int r6 = r6 + 8
            r2 = 0
            if (r0 != 0) goto L19
            r4 = r6
            r5 = r7
            r3 = r2
            goto L2b
        L19:
            r3 = r2
        L1a:
            byte r4 = (byte) r5
            r1[r3] = r4
            if (r3 != r6) goto L27
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L27:
            int r3 = r3 + 1
            r4 = r0[r7]
        L2b:
            int r7 = r7 + 1
            int r5 = r5 + r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.messages.iam.IamBannerActivity.k(int, byte, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0028  */
    /* JADX WARN: Code duplicated, block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x002f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0028
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void m(short r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 63
            int r6 = 99 - r6
            int r8 = r8 * 2
            int r8 = r8 + 3
            byte[] r0 = com.salesforce.marketingcloud.messages.iam.IamBannerActivity.$$d
            int r7 = r7 * 2
            int r7 = 69 - r7
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r7
            r4 = r2
            goto L2f
        L16:
            r3 = r2
        L17:
            int r7 = r7 + 1
            byte r4 = (byte) r6
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r8) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r5
        L2f:
            int r6 = -r6
            int r7 = r7 + r6
            int r6 = r7 + (-8)
            r7 = r3
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.messages.iam.IamBannerActivity.m(short, short, int, java.lang.Object[]):void");
    }

    @Override // com.salesforce.marketingcloud.messages.iam.f
    public /* bridge */ /* synthetic */ void b(InAppMessage.Button button) {
        super.b(button);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.f, android.app.Activity
    public /* bridge */ /* synthetic */ void finish() {
        super.finish();
    }

    void h() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment fragmentFindFragmentById = supportFragmentManager.findFragmentById(R.id.content);
        if (fragmentFindFragmentById != null) {
            supportFragmentManager.beginTransaction().setCustomAnimations(0, b(c().l())).remove(fragmentFindFragmentById).commitAllowingStateLoss();
        }
        a(j.a(c().k(), a()));
    }

    @Override // com.salesforce.marketingcloud.messages.iam.f, android.view.View.OnClickListener
    public /* bridge */ /* synthetic */ void onClick(View view) {
        super.onClick(view);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (isFinishing()) {
            return;
        }
        k kVarC = c();
        InAppMessage inAppMessageL = kVarC.l();
        findViewById(R.id.content).setBackgroundDrawable(new ColorDrawable(g.a(this, inAppMessageL.windowColor(), com.salesforce.marketingcloud.R.color.mcsdk_iam_default_window_background)));
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.findFragmentById(R.id.content) == null) {
            this.h = true;
            supportFragmentManager.beginTransaction().setCustomAnimations(a(inAppMessageL), 0).add(R.id.content, c.a(kVarC)).commit();
        }
    }

    @Override // com.salesforce.marketingcloud.messages.iam.f, com.salesforce.marketingcloud.messages.iam.SwipeDismissConstraintLayout.SwipeDismissListener
    public /* bridge */ /* synthetic */ void onDismissed() {
        super.onDismissed();
    }

    @Override // com.salesforce.marketingcloud.messages.iam.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.salesforce.marketingcloud.messages.iam.a aVar = this.g;
        if (aVar != null) {
            aVar.cancel();
            this.g = null;
        }
    }

    @Override // com.salesforce.marketingcloud.messages.iam.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        long jDisplayDuration = b().displayDuration();
        long integer = this.h ? (long) (((double) getResources().getInteger(com.salesforce.marketingcloud.R.integer.mcsdk_iam_banner_animation_duration)) * (-1.0d)) : 0L;
        this.h = false;
        a(jDisplayDuration, integer);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.f, com.salesforce.marketingcloud.messages.iam.SwipeDismissConstraintLayout.SwipeDismissListener
    public void onSwipeStarted() {
        super.onSwipeStarted();
        com.salesforce.marketingcloud.messages.iam.a aVar = this.g;
        if (aVar != null) {
            aVar.cancel();
            this.i = this.g.a();
            this.g = null;
        }
    }

    @Override // com.salesforce.marketingcloud.messages.iam.f, com.salesforce.marketingcloud.messages.iam.SwipeDismissConstraintLayout.SwipeDismissListener
    public void onViewSettled() {
        super.onViewSettled();
        a(b().displayDuration(), this.i);
    }

    private int b(InAppMessage inAppMessage) {
        return inAppMessage.type() == InAppMessage.Type.bannerTop ? com.salesforce.marketingcloud.R.anim.mcsdk_iam_slide_out_from_top : com.salesforce.marketingcloud.R.anim.mcsdk_iam_slide_out_from_bottom;
    }

    private int a(InAppMessage inAppMessage) {
        if (inAppMessage.type() == InAppMessage.Type.bannerTop) {
            return com.salesforce.marketingcloud.R.anim.mcsdk_iam_slide_in_from_top;
        }
        return com.salesforce.marketingcloud.R.anim.mcsdk_iam_slide_in_from_bottom;
    }

    private static void l(char[] cArr, int i, char[] cArr2, char c, char[] cArr3, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
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
            try {
                Object[] objArr2 = {iCustomTabsCallbackDefault};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-10548171);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) 0;
                    byte b2 = (byte) (b + 2);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(33 - View.MeasureSpec.getMode(0), (char) (ViewConfiguration.getWindowTouchSlop() >> 8), TextUtils.getOffsetBefore("", 0) + 1483, 1614432829, false, $$i(b, b2, (byte) (b2 - 2)), new Class[]{Object.class});
                }
                int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                Object[] objArr3 = {iCustomTabsCallbackDefault};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1818210492);
                if (objAccessartificialFrame2 == null) {
                    byte b3 = (byte) 0;
                    byte b4 = b3;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 32, (char) ((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 49168), 899 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 214239564, false, $$i(b3, b4, b4), new Class[]{Object.class});
                }
                int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                Object[] objArr4 = {iCustomTabsCallbackDefault, Integer.valueOf(cArr4[iCustomTabsCallbackDefault.a % 4] * 32718), Integer.valueOf(cArr5[iIntValue])};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1532285801);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) 0;
                    byte b6 = (byte) (b5 + 3);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(23 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) ((-1) - Process.getGidForName("")), 2441 - (ViewConfiguration.getTouchSlop() >> 8), -1003383455, false, $$i(b5, b6, (byte) (b6 - 3)), new Class[]{Object.class, Integer.TYPE, Integer.TYPE});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                Object[] objArr5 = {Integer.valueOf(cArr4[iIntValue2] * 32718), Integer.valueOf(cArr5[iIntValue])};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-950633141);
                if (objAccessartificialFrame4 == null) {
                    byte b7 = (byte) 0;
                    byte b8 = (byte) (b7 + 1);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(((Process.getThreadPriority(0) + 20) >> 6) + 20, (char) (29754 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 1747, 1479752515, false, $$i(b7, b8, (byte) (b8 - 1)), new Class[]{Integer.TYPE, Integer.TYPE});
                }
                cArr5[iIntValue2] = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).charValue();
                cArr4[iIntValue2] = iCustomTabsCallbackDefault.MediaBrowserCompatApi21ConnectionCallback;
                cArr6[iCustomTabsCallbackDefault.a] = (char) (((((long) (cArr4[iIntValue2] ^ cArr3[iCustomTabsCallbackDefault.a])) ^ (coroutineBoundary ^ (-899883803867009716L))) ^ ((long) ((int) (((long) accessartificialFrame) ^ (-899883803867009716L))))) ^ ((long) ((char) (((long) CoroutineDebuggingKt) ^ (-899883803867009716L)))));
                iCustomTabsCallbackDefault.a++;
                int i3 = $11 + 1;
                $10 = i3 % 128;
                int i4 = i3 % 2;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        String str = new String(cArr6);
        int i5 = $11 + 123;
        $10 = i5 % 128;
        int i6 = i5 % 2;
        objArr[0] = str;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0229  */
    /* JADX WARN: Code duplicated, block: B:23:0x031b A[Catch: all -> 0x0cd0, TryCatch #0 {all -> 0x0cd0, blocks: (B:58:0x0917, B:60:0x092b, B:61:0x095a, B:21:0x02fa, B:23:0x031b, B:24:0x0367), top: B:98:0x02fa }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0379  */
    /* JADX WARN: Code duplicated, block: B:32:0x04af  */
    /* JADX WARN: Code duplicated, block: B:57:0x082a  */
    /* JADX WARN: Code duplicated, block: B:60:0x092b A[Catch: all -> 0x0cd0, TryCatch #0 {all -> 0x0cd0, blocks: (B:58:0x0917, B:60:0x092b, B:61:0x095a, B:21:0x02fa, B:23:0x031b, B:24:0x0367), top: B:98:0x02fa }] */
    /* JADX WARN: Code duplicated, block: B:64:0x0970  */
    /* JADX WARN: Code duplicated, block: B:69:0x0ad1  */
    @Override // com.salesforce.marketingcloud.messages.iam.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) throws Throwable {
        Object objAccessartificialFrame;
        Object[] objArr;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        char c;
        int i = 2 % 2;
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 41;
        artificialFrame = i2 % 128;
        if (i2 % 2 == 0) {
            super.attachBaseContext(context);
            Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame7 == null) {
                int threadPriority = ((Process.getThreadPriority(0) + 20) >> 6) + 25;
                char gidForName = (char) (30067 - Process.getGidForName(""));
                int iLastIndexOf = TextUtils.lastIndexOf("", '0') + 817;
                byte[] bArr = $$a;
                byte b = bArr[21];
                Object[] objArr2 = new Object[1];
                k(b, (byte) (b - 1), (byte) (-bArr[8]), objArr2);
                objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(threadPriority, gidForName, iLastIndexOf, 721586079, false, (String) objArr2[0], null);
            }
            ((Field) objAccessartificialFrame7).getLong(null);
            throw null;
        }
        super.attachBaseContext(context);
        Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame8 == null) {
            int i3 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 26;
            char bitsPerPixel = (char) (ImageFormat.getBitsPerPixel(0) + 30069);
            int longPressTimeout = (ViewConfiguration.getLongPressTimeout() >> 16) + 816;
            byte[] bArr2 = $$a;
            byte b2 = bArr2[21];
            Object[] objArr3 = new Object[1];
            k(b2, (byte) (b2 - 1), (byte) (-bArr2[8]), objArr3);
            objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i3, bitsPerPixel, longPressTimeout, 721586079, false, (String) objArr3[0], null);
        }
        long j2 = ((Field) objAccessartificialFrame8).getLong(null);
        if (j2 != -1) {
            long j3 = j2 + 1853;
            Object[] objArr4 = new Object[1];
            l(new char[]{0, 0, 0, 0}, '0' - AndroidCharacter.getMirror('0'), new char[]{35844, 61879, 9012, 40793}, (char) ('0' - AndroidCharacter.getMirror('0')), new char[]{44896, 20493, 13609, 56671, 15589, 8601, 651, 920, 16064, 62161, 48536, 17927, 13951, 3213, 16848, 52941, 998, 17169, 13200, 4545, 51104, 55606}, objArr4);
            Class<?> cls = Class.forName((String) objArr4[0]);
            Object[] objArr5 = new Object[1];
            l(new char[]{0, 0, 0, 0}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 827053880, new char[]{19865, 19415, 34865, 2751}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 49028), new char[]{51887, 39247, 57659, 29436, 40405, 28707, 51846, 52575, 40570, 12501, 11647, 63570, 55600, 46751, 62831}, objArr5);
            if (j3 >= ((Long) cls.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame9 == null) {
                    int iResolveSizeAndState = 25 - View.resolveSizeAndState(0, 0, 0);
                    char modifierMetaStateMask = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 30069);
                    int i4 = 816 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                    byte b3 = $$a[21];
                    byte b4 = b3;
                    Object[] objArr6 = new Object[1];
                    k(b4, (byte) (b4 - 1), b3, objArr6);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState, modifierMetaStateMask, i4, 891606461, false, (String) objArr6[0], null);
                }
                Object[] objArr7 = (Object[]) ((Field) objAccessartificialFrame9).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i5 = ((int[]) objArr7[0])[0];
                int i6 = ((int[]) objArr7[1])[0];
                String[] strArr = (String[]) objArr7[2];
                int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
                int i7 = 1916376589 + (((~(47049520 | iFreeMemory)) | (-245221887)) * (-964)) + (((~((~iFreeMemory) | 47049520)) | (-249424895)) * (-964)) + 1209140509;
                int i8 = (i7 << 13) ^ i7;
                int i9 = i8 ^ (i8 >>> 17);
                ((int[]) objArr[3])[0] = i9 ^ (i9 << 5);
            } else {
                Object[] objArr8 = new Object[1];
                l(new char[]{0, 0, 0, 0}, KeyEvent.normalizeMetaState(0), new char[]{49119, 22672, 17900, 4784}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 45090), new char[]{47552, 43796, 49395, 17144, 17037, 32442, 6369, 24235, 64801, 47293, 51303, 61189, 56904, 27255, 13365, 20885}, objArr8);
                Class<?> cls2 = Class.forName((String) objArr8[0]);
                Object[] objArr9 = new Object[1];
                l(new char[]{0, 0, 0, 0}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 49, new char[]{30677, 9755, 38414, 45883}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 15219), new char[]{33418, 14657, 24635, 32855, 13680, 694, 61805, 52012, 39319, 57300, 54789, 39394, 35408, 31035, 6983, 55781}, objArr9);
                try {
                    Object[] objArr10 = {Integer.valueOf(((Integer) cls2.getMethod((String) objArr9[0], Object.class).invoke(null, this)).intValue()), 0, 1209140509};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame == null) {
                        int touchSlop = (ViewConfiguration.getTouchSlop() >> 8) + 25;
                        char modifierMetaStateMask2 = (char) (30067 - ((byte) KeyEvent.getModifierMetaStateMask()));
                        int iAlpha = Color.alpha(0) + 816;
                        byte b5 = $$a[21];
                        byte b6 = (byte) (b5 - 1);
                        byte b7 = b5;
                        Object[] objArr11 = new Object[1];
                        k(b6, b7, (byte) (b7 - 1), objArr11);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(touchSlop, modifierMetaStateMask2, iAlpha, -797394565, false, (String) objArr11[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr10);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame2 == null) {
                        int iArgb = Color.argb(0, 0, 0, 0) + 25;
                        char touchSlop2 = (char) (30068 - (ViewConfiguration.getTouchSlop() >> 8));
                        int tapTimeout = (ViewConfiguration.getTapTimeout() >> 16) + 816;
                        byte b8 = $$a[21];
                        byte b9 = b8;
                        Object[] objArr12 = new Object[1];
                        k(b9, (byte) (b9 - 1), b8, objArr12);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iArgb, touchSlop2, tapTimeout, 891606461, false, (String) objArr12[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArr);
                    try {
                        Object[] objArr13 = new Object[1];
                        l(new char[]{0, 0, 0, 0}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 36, new char[]{35844, 61879, 9012, 40793}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 21), new char[]{44896, 20493, 13609, 56671, 15589, 8601, 651, 920, 16064, 62161, 48536, 17927, 13951, 3213, 16848, 52941, 998, 17169, 13200, 4545, 51104, 55606}, objArr13);
                        Class<?> cls3 = Class.forName((String) objArr13[0]);
                        Object[] objArr14 = new Object[1];
                        l(new char[]{0, 0, 0, 0}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 827053897, new char[]{19865, 19415, 34865, 2751}, (char) (49032 - (ViewConfiguration.getTouchSlop() >> 8)), new char[]{51887, 39247, 57659, 29436, 40405, 28707, 51846, 52575, 40570, 12501, 11647, 63570, 55600, 46751, 62831}, objArr14);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr14[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame3 == null) {
                            int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 25;
                            char cResolveSizeAndState = (char) (View.resolveSizeAndState(0, 0, 0) + 30068);
                            int trimmedLength = 816 - TextUtils.getTrimmedLength("");
                            byte[] bArr3 = $$a;
                            byte b10 = bArr3[21];
                            Object[] objArr15 = new Object[1];
                            k(b10, (byte) (b10 - 1), (byte) (-bArr3[8]), objArr15);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay, cResolveSizeAndState, trimmedLength, 721586079, false, (String) objArr15[0], null);
                        }
                        ((Field) objAccessartificialFrame3).set(null, lValueOf);
                        int i10 = getARTIFICIAL_FRAME_PACKAGE_NAME + 13;
                        artificialFrame = i10 % 128;
                        int i11 = i10 % 2;
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
            Object[] objArr16 = new Object[1];
            l(new char[]{0, 0, 0, 0}, KeyEvent.normalizeMetaState(0), new char[]{49119, 22672, 17900, 4784}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 45090), new char[]{47552, 43796, 49395, 17144, 17037, 32442, 6369, 24235, 64801, 47293, 51303, 61189, 56904, 27255, 13365, 20885}, objArr16);
            Class<?> cls4 = Class.forName((String) objArr16[0]);
            Object[] objArr17 = new Object[1];
            l(new char[]{0, 0, 0, 0}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 49, new char[]{30677, 9755, 38414, 45883}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 15219), new char[]{33418, 14657, 24635, 32855, 13680, 694, 61805, 52012, 39319, 57300, 54789, 39394, 35408, 31035, 6983, 55781}, objArr17);
            Object[] objArr18 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue()), 0, 1209140509};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame == null) {
                int touchSlop3 = (ViewConfiguration.getTouchSlop() >> 8) + 25;
                char modifierMetaStateMask3 = (char) (30067 - ((byte) KeyEvent.getModifierMetaStateMask()));
                int iAlpha2 = Color.alpha(0) + 816;
                byte b11 = $$a[21];
                byte b12 = (byte) (b11 - 1);
                byte b13 = b11;
                Object[] objArr19 = new Object[1];
                k(b12, b13, (byte) (b13 - 1), objArr19);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(touchSlop3, modifierMetaStateMask3, iAlpha2, -797394565, false, (String) objArr19[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr18);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame2 == null) {
                int iArgb2 = Color.argb(0, 0, 0, 0) + 25;
                char touchSlop4 = (char) (30068 - (ViewConfiguration.getTouchSlop() >> 8));
                int tapTimeout2 = (ViewConfiguration.getTapTimeout() >> 16) + 816;
                byte b14 = $$a[21];
                byte b15 = b14;
                Object[] objArr110 = new Object[1];
                k(b15, (byte) (b15 - 1), b14, objArr110);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iArgb2, touchSlop4, tapTimeout2, 891606461, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArr);
            Object[] objArr111 = new Object[1];
            l(new char[]{0, 0, 0, 0}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 36, new char[]{35844, 61879, 9012, 40793}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 21), new char[]{44896, 20493, 13609, 56671, 15589, 8601, 651, 920, 16064, 62161, 48536, 17927, 13951, 3213, 16848, 52941, 998, 17169, 13200, 4545, 51104, 55606}, objArr111);
            Class<?> cls5 = Class.forName((String) objArr111[0]);
            Object[] objArr112 = new Object[1];
            l(new char[]{0, 0, 0, 0}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 827053897, new char[]{19865, 19415, 34865, 2751}, (char) (49032 - (ViewConfiguration.getTouchSlop() >> 8)), new char[]{51887, 39247, 57659, 29436, 40405, 28707, 51846, 52575, 40570, 12501, 11647, 63570, 55600, 46751, 62831}, objArr112);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr112[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame3 == null) {
                int keyRepeatDelay2 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 25;
                char cResolveSizeAndState2 = (char) (View.resolveSizeAndState(0, 0, 0) + 30068);
                int trimmedLength2 = 816 - TextUtils.getTrimmedLength("");
                byte[] bArr4 = $$a;
                byte b16 = bArr4[21];
                Object[] objArr113 = new Object[1];
                k(b16, (byte) (b16 - 1), (byte) (-bArr4[8]), objArr113);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay2, cResolveSizeAndState2, trimmedLength2, 721586079, false, (String) objArr113[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
            int i12 = getARTIFICIAL_FRAME_PACKAGE_NAME + 13;
            artificialFrame = i12 % 128;
            int i13 = i12 % 2;
        }
        int i14 = ((int[]) objArr[1])[0];
        int i15 = ((int[]) objArr[0])[0];
        if (i15 == i14) {
            Object[] objArr20 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i16 = ((int[]) objArr[3])[0];
            int i17 = ((int[]) objArr[0])[0];
            int i18 = ((int[]) objArr[1])[0];
            String[] strArr2 = (String[]) objArr[2];
            int iIdentityHashCode = System.identityHashCode(this);
            int i19 = ~iIdentityHashCode;
            int i20 = i16 + 207782199 + (((~(372269886 | i19)) | (-909140799)) * 98) + (((~(i19 | (-570442253))) | 372269886 | (~(570442252 | iIdentityHashCode))) * (-49)) + (((~(iIdentityHashCode | 372269886)) | 338698546) * 49);
            int i21 = (i20 << 13) ^ i20;
            int i22 = i21 ^ (i21 >>> 17);
            ((int[]) objArr20[3])[0] = i22 ^ (i22 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr[2];
            if (strArr3 != null) {
                for (String str : strArr3) {
                    int i23 = getARTIFICIAL_FRAME_PACKAGE_NAME + 45;
                    artificialFrame = i23 % 128;
                    int i24 = i23 % 2;
                    arrayList.add(str);
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf(((long) (i14 ^ i15)) ^ (((long) (-1090232479)) << 32)), Long.valueOf(-1090232480)};
                byte[] bArr5 = $$d;
                byte b17 = bArr5[78];
                byte b18 = bArr5[3];
                Object[] objArr22 = new Object[1];
                m(b17, b18, (byte) (b18 - 2), objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                byte b19 = bArr5[28];
                Object[] objArr23 = new Object[1];
                m(b19, b19, bArr5[78], objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i25 = ((int[]) objArr[3])[0];
                int i26 = ((int[]) objArr[0])[0];
                int i27 = ((int[]) objArr[1])[0];
                String[] strArr4 = (String[]) objArr[2];
                int iIdentityHashCode2 = System.identityHashCode(this);
                int i28 = (-1503805571) + (((~((-806292475) | iIdentityHashCode2)) | 268436178 | (~(608120108 | iIdentityHashCode2))) * (-880));
                int i29 = (~((-806292475) | (~iIdentityHashCode2))) | (-608120109);
                int i30 = ~(iIdentityHashCode2 | 806292474);
                int i31 = i25 + i28 + ((i29 | i30) * (-880)) + (i30 * 880);
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
        Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame10 == null) {
            int scrollDefaultDelay = 26 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
            char offsetAfter = (char) TextUtils.getOffsetAfter("", 0);
            int iMyPid = 1041 - (Process.myPid() >> 22);
            byte[] bArr6 = $$a;
            byte b20 = bArr6[21];
            Object[] objArr25 = new Object[1];
            k(b20, (byte) (b20 - 1), (byte) (-bArr6[8]), objArr25);
            objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(scrollDefaultDelay, offsetAfter, iMyPid, 2061780482, false, (String) objArr25[0], null);
        }
        long j4 = ((Field) objAccessartificialFrame10).getLong(null);
        if (j4 != -1) {
            long j5 = j4 + 4611686018427387865L;
            Object[] objArr26 = new Object[1];
            l(new char[]{0, 0, 0, 0}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35, new char[]{35844, 61879, 9012, 40793}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 4), new char[]{44896, 20493, 13609, 56671, 15589, 8601, 651, 920, 16064, 62161, 48536, 17927, 13951, 3213, 16848, 52941, 998, 17169, 13200, 4545, 51104, 55606}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            l(new char[]{0, 0, 0, 0}, 827053900 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), new char[]{19865, 19415, 34865, 2751}, (char) (TextUtils.indexOf("", "", 0) + 49032), new char[]{51887, 39247, 57659, 29436, 40405, 28707, 51846, 52575, 40570, 12501, 11647, 63570, 55600, 46751, 62831}, objArr27);
            if (j5 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame11 == null) {
                    int longPressTimeout2 = (ViewConfiguration.getLongPressTimeout() >> 16) + 26;
                    char cLastIndexOf = (char) (TextUtils.lastIndexOf("", '0') + 1);
                    int longPressTimeout3 = (ViewConfiguration.getLongPressTimeout() >> 16) + 1041;
                    byte b21 = $$a[21];
                    byte b22 = b21;
                    Object[] objArr28 = new Object[1];
                    k(b22, (byte) (b22 - 1), b21, objArr28);
                    objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(longPressTimeout2, cLastIndexOf, longPressTimeout3, 1145017376, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame11).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i34 = ((int[]) objArr29[3])[0];
                int i35 = ((int[]) objArr29[2])[0];
                String[] strArr5 = (String[]) objArr29[0];
                int i36 = ~Process.myPid();
                int i37 = 587602528 + ((~((-721691773) | i36)) * (-783)) + (((~(i36 | (-723396479))) | (-801500286)) * 783) + 253019444;
                int i38 = (i37 << 13) ^ i37;
                int i39 = i38 ^ (i38 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i39 ^ (i39 << 5);
                c = 2;
            } else {
                Object[] objArr30 = new Object[1];
                l(new char[]{0, 0, 0, 0}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4, new char[]{49119, 22672, 17900, 4784}, (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 45125), new char[]{47552, 43796, 49395, 17144, 17037, 32442, 6369, 24235, 64801, 47293, 51303, 61189, 56904, 27255, 13365, 20885}, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                l(new char[]{0, 0, 0, 0}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 49, new char[]{30677, 9755, 38414, 45883}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) + 15205), new char[]{33418, 14657, 24635, 32855, 13680, 694, 61805, 52012, 39319, 57300, 54789, 39394, 35408, 31035, 6983, 55781}, objArr31);
                int iIntValue = ((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue();
                Object[] objArr32 = {-731503847};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(7 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) (22251 - (ViewConfiguration.getScrollBarFadeDuration() >> 16)), Gravity.getAbsoluteGravity(0, 0) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = HashMapClassDesc.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr32), 253019444, false);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame5 == null) {
                    int maximumDrawingCacheSize = 26 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                    char offsetAfter2 = (char) TextUtils.getOffsetAfter("", 0);
                    int i40 = 1042 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                    byte b23 = $$a[21];
                    byte b24 = b23;
                    Object[] objArr33 = new Object[1];
                    k(b24, (byte) (b24 - 1), b23, objArr33);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize, offsetAfter2, i40, 1145017376, false, (String) objArr33[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Object[] objArr34 = new Object[1];
                    l(new char[]{0, 0, 0, 0}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 49, new char[]{35844, 61879, 9012, 40793}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4), new char[]{44896, 20493, 13609, 56671, 15589, 8601, 651, 920, 16064, 62161, 48536, 17927, 13951, 3213, 16848, 52941, 998, 17169, 13200, 4545, 51104, 55606}, objArr34);
                    Class<?> cls9 = Class.forName((String) objArr34[0]);
                    Object[] objArr35 = new Object[1];
                    l(new char[]{0, 0, 0, 0}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 827053897, new char[]{19865, 19415, 34865, 2751}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 49028), new char[]{51887, 39247, 57659, 29436, 40405, 28707, 51846, 52575, 40570, 12501, 11647, 63570, 55600, 46751, 62831}, objArr35);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr35[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame6 == null) {
                        int iMyPid2 = 26 - (Process.myPid() >> 22);
                        char c2 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                        int keyRepeatTimeout = 1041 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                        byte[] bArr7 = $$a;
                        byte b25 = bArr7[21];
                        Object[] objArr36 = new Object[1];
                        k(b25, (byte) (b25 - 1), (byte) (-bArr7[8]), objArr36);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iMyPid2, c2, keyRepeatTimeout, 2061780482, false, (String) objArr36[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                    int i41 = artificialFrame + 39;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i41 % 128;
                    c = 2;
                    int i42 = i41 % 2;
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr37 = new Object[1];
            l(new char[]{0, 0, 0, 0}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4, new char[]{49119, 22672, 17900, 4784}, (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 45125), new char[]{47552, 43796, 49395, 17144, 17037, 32442, 6369, 24235, 64801, 47293, 51303, 61189, 56904, 27255, 13365, 20885}, objArr37);
            Class<?> cls10 = Class.forName((String) objArr37[0]);
            Object[] objArr38 = new Object[1];
            l(new char[]{0, 0, 0, 0}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 49, new char[]{30677, 9755, 38414, 45883}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) + 15205), new char[]{33418, 14657, 24635, 32855, 13680, 694, 61805, 52012, 39319, 57300, 54789, 39394, 35408, 31035, 6983, 55781}, objArr38);
            int iIntValue2 = ((Integer) cls10.getMethod((String) objArr38[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr39 = {-731503847};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(7 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) (22251 - (ViewConfiguration.getScrollBarFadeDuration() >> 16)), Gravity.getAbsoluteGravity(0, 0) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = HashMapClassDesc.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr39), 253019444, false);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame5 == null) {
                int maximumDrawingCacheSize2 = 26 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                char offsetAfter3 = (char) TextUtils.getOffsetAfter("", 0);
                int i43 = 1042 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                byte b26 = $$a[21];
                byte b27 = b26;
                Object[] objArr310 = new Object[1];
                k(b27, (byte) (b27 - 1), b26, objArr310);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize2, offsetAfter3, i43, 1145017376, false, (String) objArr310[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr311 = new Object[1];
            l(new char[]{0, 0, 0, 0}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 49, new char[]{35844, 61879, 9012, 40793}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4), new char[]{44896, 20493, 13609, 56671, 15589, 8601, 651, 920, 16064, 62161, 48536, 17927, 13951, 3213, 16848, 52941, 998, 17169, 13200, 4545, 51104, 55606}, objArr311);
            Class<?> cls11 = Class.forName((String) objArr311[0]);
            Object[] objArr312 = new Object[1];
            l(new char[]{0, 0, 0, 0}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 827053897, new char[]{19865, 19415, 34865, 2751}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 49028), new char[]{51887, 39247, 57659, 29436, 40405, 28707, 51846, 52575, 40570, 12501, 11647, 63570, 55600, 46751, 62831}, objArr312);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr312[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame6 == null) {
                int iMyPid3 = 26 - (Process.myPid() >> 22);
                char c3 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                int keyRepeatTimeout2 = 1041 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                byte[] bArr8 = $$a;
                byte b28 = bArr8[21];
                Object[] objArr313 = new Object[1];
                k(b28, (byte) (b28 - 1), (byte) (-bArr8[8]), objArr313);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iMyPid3, c3, keyRepeatTimeout2, 2061780482, false, (String) objArr313[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
            int i44 = artificialFrame + 39;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i44 % 128;
            c = 2;
            int i45 = i44 % 2;
        }
        int i46 = ((int[]) objArrAccessartificialFrame$78cbbd35[c])[0];
        int i47 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i47 == i46) {
            Object[] objArr40 = new Object[4];
            objArr40[1] = new int[1];
            objArr40[c] = new int[]{i};
            objArr40[3] = new int[]{i};
            int i48 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i49 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i50 = ((int[]) objArrAccessartificialFrame$78cbbd35[c])[0];
            objArr40[0] = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int i51 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenHeightDp;
            int i52 = (~(539602652 | i51)) | 80761091;
            int i53 = ~i51;
            int i54 = i48 + 783869376 + ((i52 | (~((-2657285) | i53))) * 886) + (((~(i53 | (-539602653))) | 617706459) * (-1772)) + ((~(i53 | 617706459)) * 886);
            int i55 = (i54 << 13) ^ i54;
            int i56 = i55 ^ (i55 >>> 17);
            ((int[]) objArr40[1])[0] = i56 ^ (i56 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr6 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        if (strArr6 != null) {
            int i57 = 0;
            while (i57 < strArr6.length) {
                arrayList2.add(strArr6[i57]);
                i57++;
                int i58 = artificialFrame + 15;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i58 % 128;
                int i59 = i58 % 2;
            }
        }
        long j6 = (((long) 1096202398) << 32) ^ ((long) (i46 ^ i47));
        long j7 = 1096202396;
        int i60 = getARTIFICIAL_FRAME_PACKAGE_NAME + 77;
        artificialFrame = i60 % 128;
        int i61 = i60 % 2;
        Object[] objArr41 = {Long.valueOf(j6), Long.valueOf(j7)};
        byte[] bArr9 = $$d;
        byte b29 = bArr9[78];
        Object[] objArr42 = new Object[1];
        m(b29, b29, (byte) (-bArr9[4]), objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        byte b30 = bArr9[28];
        Object[] objArr43 = new Object[1];
        m(b30, b30, bArr9[78], objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {strArr, new int[1], new int[]{i}, new int[]{i}};
        int i62 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
        int i63 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        int i64 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        String[] strArr7 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        int i65 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().uiMode;
        int i66 = ~i65;
        int i67 = i62 + (-987337216) + (((~(i66 | (-121435126))) | 68698881 | (~((-146802689) | i65))) * 717) + (((~(i65 | (-121435126))) | (~(i66 | (-146802689))) | 68698881) * 717);
        int i68 = (i67 << 13) ^ i67;
        int i69 = i68 ^ (i68 >>> 17);
        ((int[]) objArr44[1])[0] = i69 ^ (i69 << 5);
    }

    static void accessartificialFrame() {
        coroutineBoundary = -899883803867009716L;
        accessartificialFrame = -1151259316;
        CoroutineDebuggingKt = (char) 28499;
    }

    @Override // com.salesforce.marketingcloud.messages.iam.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onStart() throws Throwable {
        int i = 2 % 2;
        int i2 = artificialFrame + 85;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        int i3 = i2 % 2;
        super.onStart();
        int i4 = artificialFrame + 49;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i4 % 128;
        if (i4 % 2 == 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }
}
