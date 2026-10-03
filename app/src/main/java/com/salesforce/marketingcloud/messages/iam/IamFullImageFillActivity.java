package com.salesforce.marketingcloud.messages.iam;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import ch.qos.logback.core.net.SyslogConstants;
import com.google.android.gms.dynamite.zza;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.salesforce.marketingcloud.R;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import o.ArtificialStackFrames;
import o.ICustomTabsCallbackDefault;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class IamFullImageFillActivity extends IamFullscreenActivity implements OnApplyWindowInsetsListener {
    private static final byte[] $$c = {35, -18, 33, -64};
    private static final int $$f = 213;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$j = {35, -18, 33, -64, Ascii.SI, 1, -60, 60, Ascii.VT, 3, -5, 8, -4, -52, 54, Ascii.DLE, -7, 17, 0, -3, -2, -51, 66, -9, Ascii.SYN, -12, Ascii.DLE, -6, -5, Ascii.SO, -59, 56, Ascii.SI, 0, 6, 6, -65, 74, 2, -8, 6, 0, Ascii.SO, -8, -1, 17, -66, Ascii.EM, 56, -8, -10, Ascii.SI, -1, -3, -29, 47, 0, 6, 6, -75, 3, 36, 54, -1, -12, Ascii.DLE, -1, -10, Ascii.SO, -22, 41, -8, 9, -9, 0, Ascii.DC2, -8, -3, -20, Ascii.CAN, Ascii.SI, -8, 5, 0, -46, 3, SignedBytes.MAX_POWER_OF_TWO, -1, 0, Ascii.SI, 3, -1, -58, -2, 62, 8, 9, -12, Ascii.DLE, -1, -10, Ascii.SO, -59, 69, -1, -8, Ascii.SYN, -11, Ascii.FF, 6, -2, -60, 54, Ascii.DLE, -7, 17, 0, -3, -2, -51, Ascii.EM, 36, 4, 2, Ascii.DLE, 3, -10, 2, -14, Ascii.US, -9, Ascii.VT, -3, Ascii.DC2, -48, 38, 0, Ascii.DC2, 7, -12, Ascii.DLE};
    private static final int $$k = 212;
    private static final byte[] $$a = {104, 117, 100, 60, 5, -1, -33, 33, -2, -9, 5, -7, 5, -1, -50, 39, Ascii.VT, -7, -12, Ascii.SI, Ascii.ESC, 1, -7, -6, -33, 51, -12, 3, -8, 1, Ascii.CR};
    private static final int $$b = 52;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static long coroutineBoundary = -899883803867009716L;
    private static int accessartificialFrame = -1151259316;
    private static char CoroutineDebuggingKt = 30313;

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0028). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$i(byte r7, int r8, short r9) {
        /*
            int r7 = r7 + 98
            byte[] r0 = com.salesforce.marketingcloud.messages.iam.IamFullImageFillActivity.$$c
            int r9 = r9 * 2
            int r9 = r9 + 1
            int r8 = r8 + 4
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L13
            r3 = r8
            r7 = r9
            r5 = r2
            goto L28
        L13:
            r3 = r2
        L14:
            int r8 = r8 + 1
            byte r4 = (byte) r7
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r9) goto L23
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            return r7
        L23:
            r3 = r0[r8]
            r6 = r3
            r3 = r8
            r8 = r6
        L28:
            int r7 = r7 + r8
            r8 = r3
            r3 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.messages.iam.IamFullImageFillActivity.$$i(byte, int, short):java.lang.String");
    }

    private final void h() {
        requestWindowFeature(1);
        getWindow().setFlags(1536, 1536);
        getWindow().getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
        if (Build.VERSION.SDK_INT >= 28) {
            getWindow().getAttributes().layoutInDisplayCutoutMode = 1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void j(int r5, int r6, short r7, java.lang.Object[] r8) {
        /*
            int r5 = r5 * 8
            int r5 = 20 - r5
            byte[] r0 = com.salesforce.marketingcloud.messages.iam.IamFullImageFillActivity.$$a
            int r6 = r6 * 3
            int r1 = r6 + 9
            int r7 = r7 * 28
            int r7 = 112 - r7
            byte[] r1 = new byte[r1]
            int r6 = r6 + 8
            r2 = 0
            if (r0 != 0) goto L18
            r4 = r5
            r3 = r2
            goto L2a
        L18:
            r3 = r2
        L19:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L26
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L26:
            int r3 = r3 + 1
            r4 = r0[r5]
        L2a:
            int r5 = r5 + 1
            int r7 = r7 + r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.messages.iam.IamFullImageFillActivity.j(int, int, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void l(short r5, short r6, byte r7, java.lang.Object[] r8) {
        /*
            int r7 = r7 * 3
            int r7 = r7 + 36
            int r5 = r5 + 4
            int r0 = r6 + 3
            byte[] r1 = com.salesforce.marketingcloud.messages.iam.IamFullImageFillActivity.$$j
            byte[] r0 = new byte[r0]
            int r6 = r6 + 2
            r2 = 0
            if (r1 != 0) goto L15
            r4 = r7
            r3 = r2
            r7 = r6
            goto L29
        L15:
            r3 = r2
        L16:
            int r5 = r5 + 1
            byte r4 = (byte) r7
            r0[r3] = r4
            if (r3 != r6) goto L25
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            r8[r2] = r5
            return
        L25:
            r4 = r1[r5]
            int r3 = r3 + 1
        L29:
            int r7 = r7 + r4
            int r7 = r7 + (-3)
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.messages.iam.IamFullImageFillActivity.l(short, short, byte, java.lang.Object[]):void");
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(@NotNull View v, @NotNull WindowInsetsCompat insets) {
        DisplayCutoutCompat displayCutout;
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        if (!isFinishing() && insets.hasInsets() && (displayCutout = insets.getDisplayCutout()) != null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mcsdk_iam_fif_content_padding_top);
            int safeInsetTop = displayCutout.getSafeInsetTop();
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.mcsdk_iam_fif_content_padding_bottom);
            int safeInsetBottom = displayCutout.getSafeInsetBottom();
            View viewFindViewById = v.findViewById(R.id.mcsdk_iam_container);
            if (safeInsetTop >= dimensionPixelSize) {
                dimensionPixelSize = safeInsetTop;
            }
            if (safeInsetBottom >= dimensionPixelSize2) {
                dimensionPixelSize2 = safeInsetBottom;
            }
            viewFindViewById.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize2);
        }
        WindowInsetsCompat windowInsetsCompatConsumeSystemWindowInsets = insets.consumeSystemWindowInsets();
        Intrinsics.checkNotNullExpressionValue(windowInsetsCompatConsumeSystemWindowInsets, "consumeSystemWindowInsets(...)");
        return windowInsetsCompatConsumeSystemWindowInsets;
    }

    @Override // com.salesforce.marketingcloud.messages.iam.IamFullscreenActivity, com.salesforce.marketingcloud.messages.iam.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        h();
        super.onCreate(bundle);
        View view = this.g;
        if (view != null) {
            ViewCompat.setOnApplyWindowInsetsListener(view, this);
        }
    }

    private static void k(char[] cArr, int i, char[] cArr2, char c, char[] cArr3, Object[] objArr) throws Throwable {
        int i2;
        int i3 = 2;
        int i4 = 2 % 2;
        ICustomTabsCallbackDefault iCustomTabsCallbackDefault = new ICustomTabsCallbackDefault();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr.length;
        char[] cArr5 = new char[length2];
        int i5 = 0;
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr3.length;
        char[] cArr6 = new char[length3];
        iCustomTabsCallbackDefault.a = 0;
        int i6 = $10 + 117;
        $11 = i6 % 128;
        int i7 = i6 % 2;
        while (iCustomTabsCallbackDefault.a < length3) {
            int i8 = $11 + 47;
            $10 = i8 % 128;
            int i9 = i8 % i3;
            try {
                Object[] objArr2 = {iCustomTabsCallbackDefault};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-10548171);
                if (objAccessartificialFrame == null) {
                    int i10 = 34 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                    char scrollBarFadeDuration = (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    int i11 = (TypedValue.complexToFraction(i5, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(i5, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1483;
                    byte b = (byte) ($$f & 3);
                    byte b2 = (byte) (-b);
                    String str$$i = $$i(b, b2, (byte) (b2 + 1));
                    Class[] clsArr = new Class[1];
                    clsArr[i5] = Object.class;
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i10, scrollBarFadeDuration, i11, 1614432829, false, str$$i, clsArr);
                }
                int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                Object[] objArr3 = {iCustomTabsCallbackDefault};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1818210492);
                if (objAccessartificialFrame2 == null) {
                    byte b3 = (byte) 3;
                    byte b4 = (byte) (b3 - 4);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0', i5) + 33, (char) (49168 - (ViewConfiguration.getFadingEdgeLength() >> 16)), TextUtils.indexOf((CharSequence) "", '0', i5, i5) + 900, 214239564, false, $$i(b3, b4, (byte) (b4 + 1)), new Class[]{Object.class});
                }
                int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                Object[] objArr4 = {iCustomTabsCallbackDefault, Integer.valueOf(cArr4[iCustomTabsCallbackDefault.a % 4] * 32718), Integer.valueOf(cArr5[iIntValue])};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1532285801);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) 0;
                    byte b6 = (byte) (b5 - 1);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((KeyEvent.getMaxKeyCode() >> 16) + 23, (char) View.combineMeasuredStates(0, 0), (Process.myTid() >> 22) + 2441, -1003383455, false, $$i(b5, b6, (byte) (b6 + 1)), new Class[]{Object.class, Integer.TYPE, Integer.TYPE});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                Object[] objArr5 = {Integer.valueOf(cArr4[iIntValue2] * 32718), Integer.valueOf(cArr5[iIntValue])};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-950633141);
                if (objAccessartificialFrame4 == null) {
                    i2 = 2;
                    byte b7 = (byte) 2;
                    byte b8 = (byte) (b7 - 3);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 19, (char) (((Process.getThreadPriority(0) + 20) >> 6) + 29754), View.MeasureSpec.makeMeasureSpec(0, 0) + 1748, 1479752515, false, $$i(b7, b8, (byte) (b8 + 1)), new Class[]{Integer.TYPE, Integer.TYPE});
                } else {
                    i2 = 2;
                }
                cArr5[iIntValue2] = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).charValue();
                cArr4[iIntValue2] = iCustomTabsCallbackDefault.MediaBrowserCompatApi21ConnectionCallback;
                cArr6[iCustomTabsCallbackDefault.a] = (char) (((((long) (cArr4[iIntValue2] ^ cArr3[iCustomTabsCallbackDefault.a])) ^ (coroutineBoundary ^ (-899883803867009716L))) ^ ((long) ((int) (((long) accessartificialFrame) ^ (-899883803867009716L))))) ^ ((long) ((char) (((long) CoroutineDebuggingKt) ^ (-899883803867009716L)))));
                iCustomTabsCallbackDefault.a++;
                i3 = i2;
                i5 = 0;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        objArr[0] = new String(cArr6);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0205  */
    /* JADX WARN: Code duplicated, block: B:16:0x0311 A[Catch: all -> 0x0c40, TryCatch #0 {all -> 0x0c40, blocks: (B:56:0x0923, B:58:0x0937, B:59:0x0960, B:14:0x02f0, B:16:0x0311, B:17:0x0361), top: B:96:0x02f0 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0373  */
    /* JADX WARN: Code duplicated, block: B:25:0x0462  */
    /* JADX WARN: Code duplicated, block: B:55:0x0861  */
    /* JADX WARN: Code duplicated, block: B:58:0x0937 A[Catch: all -> 0x0c40, TryCatch #0 {all -> 0x0c40, blocks: (B:56:0x0923, B:58:0x0937, B:59:0x0960, B:14:0x02f0, B:16:0x0311, B:17:0x0361), top: B:96:0x02f0 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0976  */
    /* JADX WARN: Code duplicated, block: B:67:0x0a8d  */
    @Override // com.salesforce.marketingcloud.messages.iam.IamFullscreenActivity, com.salesforce.marketingcloud.messages.iam.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
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
            int windowTouchSlop = 25 - (ViewConfiguration.getWindowTouchSlop() >> 8);
            char cMyPid = (char) ((Process.myPid() >> 22) + 30068);
            int iAxisFromString = MotionEvent.axisFromString("") + 817;
            byte b = (byte) (-$$a[8]);
            byte b2 = (byte) (b - 2);
            Object[] objArr2 = new Object[1];
            j(b, b2, b2, objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(windowTouchSlop, cMyPid, iAxisFromString, 721586079, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 1945;
            Object[] objArr3 = new Object[1];
            k(new char[]{0, 0, 0, 0}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(10) - 118, new char[]{41509, 35732, 20569, 40377}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 4), new char[]{32509, 2766, 7407, 8501, 49055, 28142, 9702, 16230, 63473, 12173, 27412, 903, 17128, 54114, 56573, 17651, 36214, 35742, 63893, 36319, 64752, 46597}, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            k(new char[]{0, 0, 0, 0}, 89083317 - (Process.myTid() >> 22), new char[]{46555, 20301, 45829, 49535}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 32670), new char[]{28978, 53358, 7223, 43478, 43628, 40742, 48053, 9650, 9331, 41552, 1428, 3208, 20208, 15611, 42131}, objArr4);
            if (j2 < ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object[] objArr5 = new Object[1];
                k(new char[]{0, 0, 0, 0}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 21, new char[]{29795, 56642, 59849, 48496}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 28870), new char[]{17439, 52577, 5866, 15164, 46969, 54020, 63722, 13791, 3689, 38093, 47406, 650, 20757, 15620, 21384, 44609}, objArr5);
                Class<?> cls2 = Class.forName((String) objArr5[0]);
                Object[] objArr6 = new Object[1];
                k(new char[]{0, 0, 0, 0}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35, new char[]{63249, 22993, 2129, 27620}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 58372), new char[]{38378, 3235, 46749, 27869, 24242, 45965, 14085, 34822, 49452, 19417, 52597, 47400, 59459, 40555, 39638, 31850}, objArr6);
                try {
                    Object[] objArr7 = {Integer.valueOf(((Integer) cls2.getMethod((String) objArr6[0], Object.class).invoke(null, this)).intValue()), 0, -980359684};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame == null) {
                        int windowTouchSlop2 = 25 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                        char c = (char) (30069 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)));
                        int i2 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 816;
                        byte b3 = $$a[21];
                        byte b4 = (byte) (b3 - 1);
                        byte b5 = b3;
                        Object[] objArr8 = new Object[1];
                        j(b4, b5, b5, objArr8);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(windowTouchSlop2, c, i2, -797394565, false, (String) objArr8[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr7);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame2 == null) {
                        int offsetBefore = 25 - TextUtils.getOffsetBefore("", 0);
                        char cCombineMeasuredStates = (char) (View.combineMeasuredStates(0, 0) + 30068);
                        int threadPriority = 816 - ((Process.getThreadPriority(0) + 20) >> 6);
                        byte b6 = $$a[21];
                        byte b7 = (byte) (b6 - 1);
                        Object[] objArr9 = new Object[1];
                        j(b6, b7, b7, objArr9);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(offsetBefore, cCombineMeasuredStates, threadPriority, 891606461, false, (String) objArr9[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArr);
                    try {
                        Object[] objArr10 = new Object[1];
                        k(new char[]{0, 0, 0, 0}, View.resolveSize(0, 0), new char[]{41509, 35732, 20569, 40377}, (char) (Process.getGidForName("") + 1), new char[]{32509, 2766, 7407, 8501, 49055, 28142, 9702, 16230, 63473, 12173, 27412, 903, 17128, 54114, 56573, 17651, 36214, 35742, 63893, 36319, 64752, 46597}, objArr10);
                        Class<?> cls3 = Class.forName((String) objArr10[0]);
                        Object[] objArr11 = new Object[1];
                        k(new char[]{0, 0, 0, 0}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 89083313, new char[]{46555, 20301, 45829, 49535}, (char) (32691 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))), new char[]{28978, 53358, 7223, 43478, 43628, 40742, 48053, 9650, 9331, 41552, 1428, 3208, 20208, 15611, 42131}, objArr11);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr11[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame3 == null) {
                            int scrollBarFadeDuration = 25 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                            char cRed = (char) (30068 - Color.red(0));
                            int i3 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 816;
                            byte b8 = (byte) (-$$a[8]);
                            byte b9 = (byte) (b8 - 2);
                            Object[] objArr12 = new Object[1];
                            j(b8, b9, b9, objArr12);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration, cRed, i3, 721586079, false, (String) objArr12[0], null);
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
            } else {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame8 == null) {
                    int iIndexOf = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 26;
                    char maximumDrawingCacheSize = (char) ((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 30068);
                    int i4 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 816;
                    byte b10 = $$a[21];
                    byte b11 = (byte) (b10 - 1);
                    Object[] objArr13 = new Object[1];
                    j(b10, b11, b11, objArr13);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iIndexOf, maximumDrawingCacheSize, i4, 891606461, false, (String) objArr13[0], null);
                }
                Object[] objArr14 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i5 = ((int[]) objArr14[0])[0];
                int i6 = ((int[]) objArr14[1])[0];
                String[] strArr = (String[]) objArr14[2];
                int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 1452274184;
                int i7 = ~length;
                int i8 = (((1671339365 + (((~(33062713 | i7)) | 134676612) * SyslogConstants.LOG_LOCAL7)) + ((length | 2629673) * (-184))) + ((~((-165109653) | i7)) * SyslogConstants.LOG_LOCAL7)) - 980359684;
                int i9 = (i8 << 13) ^ i8;
                int i10 = i9 ^ (i9 >>> 17);
                ((int[]) objArr[3])[0] = i10 ^ (i10 << 5);
            }
        } else {
            Object[] objArr15 = new Object[1];
            k(new char[]{0, 0, 0, 0}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 21, new char[]{29795, 56642, 59849, 48496}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 28870), new char[]{17439, 52577, 5866, 15164, 46969, 54020, 63722, 13791, 3689, 38093, 47406, 650, 20757, 15620, 21384, 44609}, objArr15);
            Class<?> cls4 = Class.forName((String) objArr15[0]);
            Object[] objArr16 = new Object[1];
            k(new char[]{0, 0, 0, 0}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35, new char[]{63249, 22993, 2129, 27620}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 58372), new char[]{38378, 3235, 46749, 27869, 24242, 45965, 14085, 34822, 49452, 19417, 52597, 47400, 59459, 40555, 39638, 31850}, objArr16);
            Object[] objArr17 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue()), 0, -980359684};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame == null) {
                int windowTouchSlop3 = 25 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                char c2 = (char) (30069 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)));
                int i11 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 816;
                byte b12 = $$a[21];
                byte b13 = (byte) (b12 - 1);
                byte b14 = b12;
                Object[] objArr18 = new Object[1];
                j(b13, b14, b14, objArr18);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(windowTouchSlop3, c2, i11, -797394565, false, (String) objArr18[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr17);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame2 == null) {
                int offsetBefore2 = 25 - TextUtils.getOffsetBefore("", 0);
                char cCombineMeasuredStates2 = (char) (View.combineMeasuredStates(0, 0) + 30068);
                int threadPriority2 = 816 - ((Process.getThreadPriority(0) + 20) >> 6);
                byte b15 = $$a[21];
                byte b16 = (byte) (b15 - 1);
                Object[] objArr19 = new Object[1];
                j(b15, b16, b16, objArr19);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(offsetBefore2, cCombineMeasuredStates2, threadPriority2, 891606461, false, (String) objArr19[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArr);
            Object[] objArr110 = new Object[1];
            k(new char[]{0, 0, 0, 0}, View.resolveSize(0, 0), new char[]{41509, 35732, 20569, 40377}, (char) (Process.getGidForName("") + 1), new char[]{32509, 2766, 7407, 8501, 49055, 28142, 9702, 16230, 63473, 12173, 27412, 903, 17128, 54114, 56573, 17651, 36214, 35742, 63893, 36319, 64752, 46597}, objArr110);
            Class<?> cls5 = Class.forName((String) objArr110[0]);
            Object[] objArr111 = new Object[1];
            k(new char[]{0, 0, 0, 0}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 89083313, new char[]{46555, 20301, 45829, 49535}, (char) (32691 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))), new char[]{28978, 53358, 7223, 43478, 43628, 40742, 48053, 9650, 9331, 41552, 1428, 3208, 20208, 15611, 42131}, objArr111);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr111[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame3 == null) {
                int scrollBarFadeDuration2 = 25 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                char cRed2 = (char) (30068 - Color.red(0));
                int i12 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 816;
                byte b17 = (byte) (-$$a[8]);
                byte b18 = (byte) (b17 - 2);
                Object[] objArr112 = new Object[1];
                j(b17, b18, b18, objArr112);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration2, cRed2, i12, 721586079, false, (String) objArr112[0], null);
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
            int streamMaxVolume = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getStreamMaxVolume(3);
            int i18 = ~streamMaxVolume;
            int i19 = i15 + 1090925989 + (((~((-613042803) | i18)) | 603979858 | (~(414870436 | i18))) * (-1136)) + (((~((-613042803) | streamMaxVolume)) | (~(414870436 | streamMaxVolume)) | (~((-405807493) | i18))) * (-568)) + (((~(streamMaxVolume | (-603979859))) | (~(i18 | (-414870437))) | (~(613042802 | i18))) * 568);
            int i20 = (i19 << 13) ^ i19;
            int i21 = i20 ^ (i20 >>> 17);
            ((int[]) objArr20[3])[0] = i21 ^ (i21 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            int i22 = 2;
            String[] strArr3 = (String[]) objArr[2];
            if (strArr3 != null) {
                int i23 = getARTIFICIAL_FRAME_PACKAGE_NAME + 49;
                artificialFrame = i23 % 128;
                int i24 = i23 % 2;
                int i25 = 0;
                while (i25 < strArr3.length) {
                    int i26 = getARTIFICIAL_FRAME_PACKAGE_NAME + com.salesforce.marketingcloud.analytics.stats.b.f40o;
                    artificialFrame = i26 % 128;
                    if (i26 % i22 == 0) {
                        arrayList.add(strArr3[i25]);
                        i25 += com.salesforce.marketingcloud.analytics.stats.b.f39n;
                    } else {
                        arrayList.add(strArr3[i25]);
                        i25++;
                    }
                    i22 = 2;
                }
            }
            long j3 = (((long) (-623935796)) << 32) ^ ((long) (i13 ^ i14));
            long j4 = -623935795;
            int i27 = getARTIFICIAL_FRAME_PACKAGE_NAME + com.salesforce.marketingcloud.analytics.stats.b.f40o;
            artificialFrame = i27 % 128;
            int i28 = i27 % 2;
            try {
                Object[] objArr21 = {Long.valueOf(j3), Long.valueOf(j4)};
                byte[] bArr = $$j;
                byte b19 = bArr[44];
                Object[] objArr22 = new Object[1];
                l(b19, (byte) (b19 & 79), (byte) (bArr[24] - 1), objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                byte b20 = (byte) ($$k & 376);
                byte b21 = bArr[18];
                Object[] objArr23 = new Object[1];
                l(b20, b21, b21, objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i29 = ((int[]) objArr[3])[0];
                int i30 = ((int[]) objArr[0])[0];
                int i31 = ((int[]) objArr[1])[0];
                String[] strArr4 = (String[]) objArr[2];
                int iIdentityHashCode = System.identityHashCode(this);
                int i32 = i29 + 548183176 + (((~((-690646223) | iIdentityHashCode)) | 538992846) * 345) + (((~((-690646223) | (~iIdentityHashCode))) | (-1031466703)) * 345) + ((~(iIdentityHashCode | (-538992847))) * 345);
                int i33 = (i32 << 13) ^ i32;
                int i34 = i33 ^ (i33 >>> 17);
                ((int[]) objArr24[3])[0] = i34 ^ (i34 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 != null) {
                    throw cause2;
                }
                throw th2;
            }
        }
        Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame9 == null) {
            int i35 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 26;
            char cIndexOf = (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1);
            int i36 = 1042 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
            byte b22 = (byte) (-$$a[8]);
            byte b23 = (byte) (b22 - 2);
            Object[] objArr25 = new Object[1];
            j(b22, b23, b23, objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(i35, cIndexOf, i36, 2061780482, false, (String) objArr25[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j5 != -1) {
            long j6 = j5 + 4611686018427387861L;
            Object[] objArr26 = new Object[1];
            k(new char[]{0, 0, 0, 0}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(5) - 108, new char[]{41509, 35732, 20569, 40377}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(0) - 37), new char[]{32509, 2766, 7407, 8501, 49055, 28142, 9702, 16230, 63473, 12173, 27412, 903, 17128, 54114, 56573, 17651, 36214, 35742, 63893, 36319, 64752, 46597}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            k(new char[]{0, 0, 0, 0}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 89083281, new char[]{46555, 20301, 45829, 49535}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 32687), new char[]{28978, 53358, 7223, 43478, 43628, 40742, 48053, 9650, 9331, 41552, 1428, 3208, 20208, 15611, 42131}, objArr27);
            if (j6 < ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object[] objArr28 = new Object[1];
                k(new char[]{0, 0, 0, 0}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35, new char[]{29795, 56642, 59849, 48496}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(10) + 28787), new char[]{17439, 52577, 5866, 15164, 46969, 54020, 63722, 13791, 3689, 38093, 47406, 650, 20757, 15620, 21384, 44609}, objArr28);
                Class<?> cls8 = Class.forName((String) objArr28[0]);
                Object[] objArr29 = new Object[1];
                k(new char[]{0, 0, 0, 0}, View.resolveSizeAndState(0, 0, 0), new char[]{63249, 22993, 2129, 27620}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 58372), new char[]{38378, 3235, 46749, 27869, 24242, 45965, 14085, 34822, 49452, 19417, 52597, 47400, 59459, 40555, 39638, 31850}, objArr29);
                int iIntValue = ((Integer) cls8.getMethod((String) objArr29[0], Object.class).invoke(null, this)).intValue();
                Object[] objArr30 = {1745592056};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 7, (char) (22251 - KeyEvent.keyCodeFromString("")), 1033 - (ViewConfiguration.getPressedStateDuration() >> 16), 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = zza.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr30), -2015347288, false);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame5 == null) {
                    int maximumDrawingCacheSize2 = 26 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                    char cCombineMeasuredStates3 = (char) View.combineMeasuredStates(0, 0);
                    int packedPositionGroup = 1041 - ExpandableListView.getPackedPositionGroup(0L);
                    byte b24 = $$a[21];
                    byte b25 = (byte) (b24 - 1);
                    Object[] objArr31 = new Object[1];
                    j(b24, b25, b25, objArr31);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize2, cCombineMeasuredStates3, packedPositionGroup, 1145017376, false, (String) objArr31[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Object[] objArr32 = new Object[1];
                    k(new char[]{0, 0, 0, 0}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 49, new char[]{41509, 35732, 20569, 40377}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4), new char[]{32509, 2766, 7407, 8501, 49055, 28142, 9702, 16230, 63473, 12173, 27412, 903, 17128, 54114, 56573, 17651, 36214, 35742, 63893, 36319, 64752, 46597}, objArr32);
                    Class<?> cls9 = Class.forName((String) objArr32[0]);
                    Object[] objArr33 = new Object[1];
                    k(new char[]{0, 0, 0, 0}, 89083318 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), new char[]{46555, 20301, 45829, 49535}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 32656), new char[]{28978, 53358, 7223, 43478, 43628, 40742, 48053, 9650, 9331, 41552, 1428, 3208, 20208, 15611, 42131}, objArr33);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr33[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame6 == null) {
                        int i37 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 26;
                        char cCombineMeasuredStates4 = (char) View.combineMeasuredStates(0, 0);
                        int windowTouchSlop4 = 1041 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                        byte b26 = (byte) (-$$a[8]);
                        byte b27 = (byte) (b26 - 2);
                        Object[] objArr34 = new Object[1];
                        j(b26, b27, b27, objArr34);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i37, cCombineMeasuredStates4, windowTouchSlop4, 2061780482, false, (String) objArr34[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            } else {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame10 == null) {
                    int mirror = AndroidCharacter.getMirror('0') - 22;
                    char pressedStateDuration = (char) (ViewConfiguration.getPressedStateDuration() >> 16);
                    int iLastIndexOf = 1040 - TextUtils.lastIndexOf("", '0', 0);
                    byte b28 = $$a[21];
                    byte b29 = (byte) (b28 - 1);
                    Object[] objArr35 = new Object[1];
                    j(b28, b29, b29, objArr35);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(mirror, pressedStateDuration, iLastIndexOf, 1145017376, false, (String) objArr35[0], null);
                }
                Object[] objArr36 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i38 = ((int[]) objArr36[3])[0];
                int i39 = ((int[]) objArr36[2])[0];
                String[] strArr5 = (String[]) objArr36[0];
                int i40 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().mcc;
                int i41 = (((-24103554) + (((~(232835376 | i40)) | (-310939184)) * (-948))) + ((~((~i40) | (-302515728))) * (-948))) - 1308642572;
                int i42 = (i41 << 13) ^ i41;
                int i43 = i42 ^ (i42 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i43 ^ (i43 << 5);
            }
        } else {
            Object[] objArr210 = new Object[1];
            k(new char[]{0, 0, 0, 0}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35, new char[]{29795, 56642, 59849, 48496}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(10) + 28787), new char[]{17439, 52577, 5866, 15164, 46969, 54020, 63722, 13791, 3689, 38093, 47406, 650, 20757, 15620, 21384, 44609}, objArr210);
            Class<?> cls10 = Class.forName((String) objArr210[0]);
            Object[] objArr211 = new Object[1];
            k(new char[]{0, 0, 0, 0}, View.resolveSizeAndState(0, 0, 0), new char[]{63249, 22993, 2129, 27620}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 58372), new char[]{38378, 3235, 46749, 27869, 24242, 45965, 14085, 34822, 49452, 19417, 52597, 47400, 59459, 40555, 39638, 31850}, objArr211);
            int iIntValue2 = ((Integer) cls10.getMethod((String) objArr211[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr37 = {1745592056};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 7, (char) (22251 - KeyEvent.keyCodeFromString("")), 1033 - (ViewConfiguration.getPressedStateDuration() >> 16), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = zza.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr37), -2015347288, false);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame5 == null) {
                int maximumDrawingCacheSize3 = 26 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                char cCombineMeasuredStates5 = (char) View.combineMeasuredStates(0, 0);
                int packedPositionGroup2 = 1041 - ExpandableListView.getPackedPositionGroup(0L);
                byte b210 = $$a[21];
                byte b211 = (byte) (b210 - 1);
                Object[] objArr38 = new Object[1];
                j(b210, b211, b211, objArr38);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize3, cCombineMeasuredStates5, packedPositionGroup2, 1145017376, false, (String) objArr38[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr39 = new Object[1];
            k(new char[]{0, 0, 0, 0}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 49, new char[]{41509, 35732, 20569, 40377}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4), new char[]{32509, 2766, 7407, 8501, 49055, 28142, 9702, 16230, 63473, 12173, 27412, 903, 17128, 54114, 56573, 17651, 36214, 35742, 63893, 36319, 64752, 46597}, objArr39);
            Class<?> cls11 = Class.forName((String) objArr39[0]);
            Object[] objArr310 = new Object[1];
            k(new char[]{0, 0, 0, 0}, 89083318 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), new char[]{46555, 20301, 45829, 49535}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 32656), new char[]{28978, 53358, 7223, 43478, 43628, 40742, 48053, 9650, 9331, 41552, 1428, 3208, 20208, 15611, 42131}, objArr310);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr310[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame6 == null) {
                int i310 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 26;
                char cCombineMeasuredStates6 = (char) View.combineMeasuredStates(0, 0);
                int windowTouchSlop5 = 1041 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                byte b212 = (byte) (-$$a[8]);
                byte b213 = (byte) (b212 - 2);
                Object[] objArr311 = new Object[1];
                j(b212, b213, b213, objArr311);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i310, cCombineMeasuredStates6, windowTouchSlop5, 2061780482, false, (String) objArr311[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i44 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i45 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i45 == i44) {
            Object[] objArr40 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i46 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i47 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i48 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr6 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int i49 = ~(((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getStreamVolume(3) | 960143248);
            int i50 = i46 + ((((-229131522) | i49) * (-658)) - 1804006626) + ((i49 | (-1035657106)) * 658);
            int i51 = (i50 << 13) ^ i50;
            int i52 = i51 ^ (i51 >>> 17);
            ((int[]) objArr40[1])[0] = i52 ^ (i52 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        if (strArr7 != null) {
            for (String str : strArr7) {
                arrayList2.add(str);
            }
        }
        Object[] objArr41 = {Long.valueOf((((long) (-761314445)) << 32) ^ ((long) (i44 ^ i45))), Long.valueOf(-761314447)};
        byte[] bArr2 = $$j;
        Object[] objArr42 = new Object[1];
        l((byte) 82, (byte) (-bArr2[13]), bArr2[47], objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        byte b30 = (byte) ($$k & 376);
        byte b31 = bArr2[18];
        Object[] objArr43 = new Object[1];
        l(b30, b31, b31, objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {strArr, new int[1], new int[]{i}, new int[]{i}};
        int i53 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
        int i54 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        int i55 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        String[] strArr8 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        int i56 = ~(System.identityHashCode(this) | 405853098);
        int i57 = i53 + (((-196730114) | i56) * (-658)) + 615423474 + ((i56 | (-465166252)) * 658);
        int i58 = (i57 << 13) ^ i57;
        int i59 = i58 ^ (i58 >>> 17);
        ((int[]) objArr44[1])[0] = i59 ^ (i59 << 5);
        int i60 = getARTIFICIAL_FRAME_PACKAGE_NAME + 19;
        artificialFrame = i60 % 128;
        int i61 = i60 % 2;
    }

    @Override // com.salesforce.marketingcloud.messages.iam.IamFullscreenActivity, com.salesforce.marketingcloud.messages.iam.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() throws Throwable {
        int i = 2 % 2;
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 53;
        artificialFrame = i2 % 128;
        int i3 = i2 % 2;
        super.onPause();
        int i4 = getARTIFICIAL_FRAME_PACKAGE_NAME + 99;
        artificialFrame = i4 % 128;
        int i5 = i4 % 2;
    }

    @Override // com.salesforce.marketingcloud.messages.iam.IamFullscreenActivity, com.salesforce.marketingcloud.messages.iam.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() throws Throwable {
        int i = 2 % 2;
        int i2 = artificialFrame + 3;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        int i3 = i2 % 2;
        super.onResume();
        if (i3 == 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    @Override // com.salesforce.marketingcloud.messages.iam.IamFullscreenActivity, com.salesforce.marketingcloud.messages.iam.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onStart() throws Throwable {
        int i = 2 % 2;
        int i2 = artificialFrame + 31;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        int i3 = i2 % 2;
        super.onStart();
        if (i3 == 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }
}
